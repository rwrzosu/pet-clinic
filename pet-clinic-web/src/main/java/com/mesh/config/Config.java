package com.mesh.config;

import com.mesh.bootstrap.PropertyDummySourceByContructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {PropertyDummySourceByContructor.class})
public class Config {

}
