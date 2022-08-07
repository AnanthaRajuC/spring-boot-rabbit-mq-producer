package io.github.anantharajuc.springbootrabbitmq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="rmq")
public class PropertiesConfiguration {
    String queue;
    String exchange;
    String routingKey;
}
