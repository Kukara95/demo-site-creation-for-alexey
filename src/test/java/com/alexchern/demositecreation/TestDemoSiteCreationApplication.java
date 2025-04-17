package com.alexchern.demositecreation;

import org.springframework.boot.SpringApplication;

public class TestDemoSiteCreationApplication {

    public static void main(String[] args) {
        SpringApplication.from(DemoSiteCreationApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
