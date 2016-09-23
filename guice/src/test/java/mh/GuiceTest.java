package mh;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import mh.annotations.BigVehicle;
import mh.modules.SimpleModule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GuiceTest {

    @Test
    public void testSimpleModule() {
        Injector injector = Guice.createInjector(new SimpleModule());
        Vehicle vehicle = injector.getInstance(Vehicle.class);
        assertNotNull(vehicle);
        assertTrue(vehicle instanceof Car);
    }

    @Test
    public void testSimpleModule_named() {
        Injector injector = Guice.createInjector(new SimpleModule());
        Vehicle vehicle = injector.getInstance(Key.get(Vehicle.class, Names.named("truck")));
        assertNotNull(vehicle);
        assertTrue(vehicle instanceof Truck);
    }

    @Test
    public void testSimpleModule_annotation() {
        Injector injector = Guice.createInjector(new SimpleModule());
        Vehicle vehicle = injector.getInstance(Key.get(Vehicle.class, BigVehicle.class));
        assertNotNull(vehicle);
        assertTrue(vehicle instanceof Truck);
    }

    @Test
    public void testSimpleModule_provider() {
        Injector injector = Guice.createInjector(new SimpleModule());
        Pair pair = injector.getInstance(Pair.class);
        assertNotNull(pair);
        assertTrue(pair.getV1() instanceof Car);
        assertTrue(pair.getV2() instanceof Truck);
    }

    @Test
    public void testSimpleModule_constant() {
        Injector injector = Guice.createInjector(new SimpleModule());
        String name = injector.getInstance(Key.get(String.class, Names.named("NAME")));
        assertNotNull(name);
        assertEquals("BMW", name);
    }

    @Test
    public void testSimpleModule_generic() {
        Injector injector = Guice.createInjector(new SimpleModule());
        GenericPair pair = injector.getInstance(Key.get(new TypeLiteral<GenericPair<Vehicle>>(){}));

        assertNotNull(pair);
        assertTrue(pair.getV1() instanceof Car);
        assertTrue(pair.getV2() instanceof Truck);
    }

    @Test
    public void testSimpleModule_singleton() {
        Injector injector = Guice.createInjector(new SimpleModule());
        Vehicle vehicle1 = injector.getInstance(Key.get(Vehicle.class, Names.named("truck")));
        Vehicle vehicle2 = injector.getInstance(Key.get(Vehicle.class, BigVehicle.class));

        assertTrue(vehicle1 != vehicle2);
    }

}
