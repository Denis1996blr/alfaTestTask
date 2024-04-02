package config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/test/resources/app.properties"})
public interface AppConfig extends Config {

    Platform platformName();

    String app();

    String remote();
}
