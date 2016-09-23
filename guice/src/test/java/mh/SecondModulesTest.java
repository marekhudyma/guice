package mh;

import com.google.inject.Guice;
import com.google.inject.Injector;
import mh.secondModule.SecondModule;
import mh.modules.SimpleModule;
import mh.secondModule.SecondModuleCarDecorator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SecondModulesTest {

    @Test
    public void testSecondModule() {
        Injector injector = Guice.createInjector(new SimpleModule(), new SecondModule());
        SecondModuleCarDecorator vehicle = injector.getInstance(SecondModuleCarDecorator.class);
        assertNotNull(vehicle);
    }
}
