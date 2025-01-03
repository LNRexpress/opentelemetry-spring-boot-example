package com.nightsky.opentelemetry.example.db;

import com.github.javafaker.Faker;
import com.nightsky.opentelemetry.example.model.SampleEntity;
import com.nightsky.opentelemetry.example.service.SampleEntityService;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Seed implements InitializingBean {

    private final Faker faker;

    private SampleEntityService service;

    public Seed() {
        faker = new Faker();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (int i = 0; i < 5; i++) {
            SampleEntity se = new SampleEntity();
            se.setEmailAddress(faker.internet().emailAddress());
            service.create(se);
        }
    }

    @Autowired
    public void setService(SampleEntityService service) {
        this.service = service;
    }

}
