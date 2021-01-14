package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface TestConfig extends Config {
    @Config.Key("url")
    @Config.DefaultValue("https://otus.ru")
    String key();
}
