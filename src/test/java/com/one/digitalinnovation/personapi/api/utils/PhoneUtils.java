package com.one.digitalinnovation.personapi.api.utils;

import java.util.UUID;

import com.one.digitalinnovation.personapi.api.dto.request.PhoneRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PhoneResponseDTO;
import com.one.digitalinnovation.personapi.domain.enums.PhoneType;
import com.one.digitalinnovation.personapi.domain.model.Phone;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final UUID PHONE_ID = UUID.randomUUID();

    public static PhoneRequestDTO createFakePhoneRequestDTO() {
        return PhoneRequestDTO.builder()
            .number(PHONE_NUMBER)
            .type(PHONE_TYPE)
            .build();
    }

    public static PhoneResponseDTO createFakePhoneResponseDTO() {
        return PhoneResponseDTO.builder()
            .id(PHONE_ID)
            .number(PHONE_NUMBER)
            .type(PHONE_TYPE)
            .build();
    }

    public static Phone createFakePhoneEntity() {
        return Phone.builder()
            .id(PHONE_ID)
            .number(PHONE_NUMBER)
            .type(PHONE_TYPE)
            .build();
    }
}
