package com.mesh.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@Setter
@PropertySource("classpath:propertydummysource.properties")
@ConfigurationProperties("dummysource")
public class PropertyDummySource {
    private String msg;
}
