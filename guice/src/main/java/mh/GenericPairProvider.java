package mh;

import com.google.inject.Provider;
import mh.annotations.BigVehicle;

import javax.inject.Inject;

public class GenericPairProvider implements Provider<GenericPair<Vehicle>> {

    private final Vehicle v1;
    private final Vehicle v2;

    @Inject
    public GenericPairProvider(Vehicle v1, @BigVehicle Vehicle v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public GenericPair<Vehicle> get() {
        return new GenericPair<Vehicle>(v1, v2);
    }

}
