package com.one.digitalinnovation.personapi.api.mapper;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.one.digitalinnovation.personapi.api.dto.request.PhoneRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PhoneResponseDTO;
import com.one.digitalinnovation.personapi.api.utils.PhoneUtils;
import com.one.digitalinnovation.personapi.domain.model.Phone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.AllArgsConstructor;

@SpringBootTest
@AllArgsConstructor
public class PhoneMapperTest {

    private final PhoneMapper phoneMapper = PhoneMapper.INSTANCE;

    @Test
    @DisplayName("Shoud parse Phone Model to Phone Request DTO")
    void parseFromPhoneModelToPhoneRequestDTO() {
        Phone phone = PhoneUtils.createFakePhoneEntity();
        PhoneRequestDTO phoneRequestDTO = PhoneUtils.createFakePhoneRequestDTO();

        assertNotNull(phoneRequestDTO);
        assertNull(phoneRequestDTO.getId());
        phoneRequestDTO.setId(phone.getId());

        Phone phoneParsed = phoneMapper.toModel(phoneRequestDTO);

        assertEquals(phone, phoneParsed);
    }

    @Test
    @DisplayName("Shoud parse Phone Model to Phone Response DTO")
    void parseFromPhoneModelToPhoneResponseDTO() {
        Phone phone = PhoneUtils.createFakePhoneEntity();
        PhoneResponseDTO phoneResponseDTO = PhoneUtils.createFakePhoneResponseDTO();

        assertNotNull(phoneResponseDTO);
        assertNotNull(phoneResponseDTO.getId());

        Phone phoneParsed = phoneMapper.toModel(phoneResponseDTO);

        assertEquals(phone, phoneParsed);
    }


    @Test
    @DisplayName("Shoud parse Phone Request DTO PhoneModel to Phone Model")
    void parseFromPhoneRequestDTOToPhoneModel() {
        Phone phone = PhoneUtils.createFakePhoneEntity();
        PhoneRequestDTO phoneRequestDTO = PhoneUtils.createFakePhoneRequestDTO();

        assertNotNull(phoneRequestDTO);
        assertNull(phoneRequestDTO.getId());
        phoneRequestDTO.setId(phone.getId());

        PhoneRequestDTO phoneRequestDTOParsed = phoneMapper.fromModeltoRequestDTO(phone);

        assertEquals(phoneRequestDTO, phoneRequestDTOParsed);
    }

    @Test
    @DisplayName("Shoud parse Phone Response DTO PhoneModel to Phone Model")
    void parseFromPhoneResponseDTOToPhoneModel() {
        Phone phone = PhoneUtils.createFakePhoneEntity();
        PhoneResponseDTO phoneResponseDTO = PhoneUtils.createFakePhoneResponseDTO();

        assertNotNull(phoneResponseDTO);
        assertNotNull(phoneResponseDTO.getId());

        PhoneResponseDTO phoneResponseDTOParsed = phoneMapper.fromModeltoResponseDTO(phone);

        assertEquals(phoneResponseDTO, phoneResponseDTOParsed);
    }
}
