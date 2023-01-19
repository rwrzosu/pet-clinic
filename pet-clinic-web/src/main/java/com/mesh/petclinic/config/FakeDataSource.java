package com.mesh.petclinic.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeDataSource {
    private String username;
    private String password;
    private String jdbcurl;
}
