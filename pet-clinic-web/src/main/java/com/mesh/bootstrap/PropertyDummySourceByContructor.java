package com.mesh.bootstrap;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "dummysource2")
public class PropertyDummySourceByContructor {
    private final String username;
    private final String password;
    private final String url;

    public PropertyDummySourceByContructor(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }
}
