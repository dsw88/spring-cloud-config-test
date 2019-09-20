package org.springframework.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private final ConfigurableEnvironment environment;

    @Autowired
    public ApplicationRunner(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello");
        MutablePropertySources propertySources = environment.getPropertySources();
        for(PropertySource propertySource : propertySources) {
            System.out.println(propertySource.getName());
        }
        System.out.println(environment.getProperty("someprop"));
    }

}
