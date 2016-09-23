package mh.secondModule;

import com.google.inject.AbstractModule;

public class SecondModule  extends AbstractModule {

    private static final String NAME = "BMW";

    @Override
    protected void configure() {
        bind(SecondModuleOnlyCar.class).asEagerSingleton();
    }

}
