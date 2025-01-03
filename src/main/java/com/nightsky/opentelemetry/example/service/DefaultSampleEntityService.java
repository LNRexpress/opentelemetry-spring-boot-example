package com.nightsky.opentelemetry.example.service;

import com.nightsky.opentelemetry.example.model.SampleEntity;
import com.nightsky.opentelemetry.example.repository.SampleEntityRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultSampleEntityService implements SampleEntityService {

    private static final String DTO_PARAM_NOT_NULL_ERROR_MESSAGE =
        "SampleEntity parameter must not be null";

    private SampleEntityRepository repository;

    @Override
    public SampleEntity create(SampleEntity dto) {
        if ( dto == null ) {
            throw new IllegalArgumentException(DTO_PARAM_NOT_NULL_ERROR_MESSAGE);
        }

        return repository.save(dto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SampleEntity> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void update(SampleEntity dto) {
        if ( dto == null ) {
            throw new IllegalArgumentException(DTO_PARAM_NOT_NULL_ERROR_MESSAGE);
        }

        repository.save(dto);
    }

    @Override
    public void delete(SampleEntity dto) {
        if ( dto == null ) {
            throw new IllegalArgumentException(DTO_PARAM_NOT_NULL_ERROR_MESSAGE);
        }

        SampleEntity se = repository.findById(dto.getId()).orElseThrow();
        repository.delete(se);
    }

    @Autowired
    public void setRepository(SampleEntityRepository repository) {
        this.repository = repository;
    }

}
