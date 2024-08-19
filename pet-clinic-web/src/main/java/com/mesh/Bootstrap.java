package com.mesh;

import com.mesh.model.Vet;
import org.springframework.boot.CommandLineRunner;

public class Bootstrap implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Vet vet = new Vet("a", "b");

    }
}
