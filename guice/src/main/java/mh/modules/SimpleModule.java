package mh.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import mh.Car;
import mh.GenericPair;
import mh.GenericPairProvider;
import mh.Pair;
import mh.secondModule.SecondModuleCarDecorator;
import mh.secondModule.SecondModuleOnlyCar;
import mh.Truck;
import mh.Vehicle;
import mh.annotations.BigVehicle;

public class SimpleModule extends AbstractModule {

    private static final String NAME = "BMW";

    @Override
    protected void configure() {
        bind(Vehicle.class).to(Car.class).asEagerSingleton();
        bind(Vehicle.class).annotatedWith(Names.named("truck")).to(Truck.class).asEagerSingleton();
        bind(Vehicle.class).annotatedWith(BigVehicle.class).to(Truck.class).asEagerSingleton();
        bind(String.class).annotatedWith(Names.named("NAME")).toInstance(NAME);
        bind(new TypeLiteral<GenericPair<Vehicle>>(){}).toProvider(GenericPairProvider.class);
    }

    @Provides
    @Singleton
    Pair vehiclePair(Vehicle v1, @BigVehicle Vehicle v2) {
        return new Pair(v1, v2);
    }

    @Provides
    @Singleton
    SecondModuleCarDecorator secondModuleOnlyCar(SecondModuleOnlyCar secondModuleOnlyCar) {
        return new SecondModuleCarDecorator(secondModuleOnlyCar);
    }

}
