package com.one.digitalinnovation.personapi.api.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.UUID;

import com.one.digitalinnovation.personapi.api.dto.request.PersonRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PersonResponseDTO;
import com.one.digitalinnovation.personapi.domain.model.Person;

public class PersonUtils {

    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final String CPF_NUMBER = "69561718057";
    private static final UUID PERSON_ID = UUID.fromString("429ec7ea-8b74-402a-b7a0-94e0a1aca305");
    private static final LocalDate BIRTH_NAME = LocalDate.of(1990, 10, 15);

    public static PersonResponseDTO createFakePersonResponseDTO() {
        return PersonResponseDTO.builder()
            .id(PERSON_ID)
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .cpf(CPF_NUMBER)
            .birthDate(BIRTH_NAME.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
            .phones(Collections.singletonList(PhoneUtils.createFakePhoneResponseDTO()))
            .build();
    }

    public static PersonRequestDTO createFakePersonRequestDTO() {
        return PersonRequestDTO.builder()
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .cpf(CPF_NUMBER)
            .birthDate(BIRTH_NAME.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
            .phones(Collections.singletonList(PhoneUtils.createFakePhoneRequestDTO()))
            .build();
    }

    public static Person createFakePersonEntity() {
        return Person.builder()
            .id(PERSON_ID)
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .cpf(CPF_NUMBER)
            .birthDate(BIRTH_NAME)
            .phones(Collections.singletonList(PhoneUtils.createFakePhoneEntity()))
            .build();
    }

}
