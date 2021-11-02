package com.one.digitalinnovation.personapi.api.repository;

import java.util.UUID;

import com.one.digitalinnovation.personapi.domain.model.Phone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {}
