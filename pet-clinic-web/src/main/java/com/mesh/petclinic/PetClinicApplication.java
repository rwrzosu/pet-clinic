package com.mesh.petclinic;

import com.mesh.petclinic.config.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:fakedatasource.properties")
@SpringBootApplication
public class PetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }

    @Bean
    public FakeDataSource fakeDataSource(
            @Value("${rw.username}") String username,
            @Value("${rw.password}") String password,
            @Value("${rw.jdbcurl}") String jdbcurl
    ) {
        FakeDataSource fds = new FakeDataSource();
        fds.setUsername(username);
        fds.setPassword(password);
        fds.setJdbcurl(jdbcurl);
        return fds;
    }
}
