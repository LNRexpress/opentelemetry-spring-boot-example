package com.nightsky.opentelemetry.example.repository;

import com.nightsky.opentelemetry.example.model.SampleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SampleEntityRepository extends JpaRepository<SampleEntity, Long> {
}
