package com.nightsky.opentelemetry.example.service;

import com.nightsky.opentelemetry.example.model.SampleEntity;

import java.util.Optional;

public interface SampleEntityService {

    public SampleEntity create(SampleEntity dto);

    public Optional<SampleEntity> getById(Long id);

    public void update(SampleEntity dto);

    public void delete(SampleEntity dto);

}
