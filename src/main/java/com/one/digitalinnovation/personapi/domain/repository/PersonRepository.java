package com.one.digitalinnovation.personapi.domain.repository;

import java.util.UUID;

import com.one.digitalinnovation.personapi.domain.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {}
