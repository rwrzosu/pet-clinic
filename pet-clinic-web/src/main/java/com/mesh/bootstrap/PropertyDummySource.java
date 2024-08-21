package com.mesh.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties("dummysource")
public class PropertyDummySource {
    private String username;
    private String password;
    private String url;
}
