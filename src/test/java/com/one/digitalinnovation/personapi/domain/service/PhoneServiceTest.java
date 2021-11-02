package com.one.digitalinnovation.personapi.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.one.digitalinnovation.personapi.api.dto.request.PhoneRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PhoneResponseDTO;
import com.one.digitalinnovation.personapi.api.mapper.PhoneMapper;
import com.one.digitalinnovation.personapi.api.utils.PhoneUtils;
import com.one.digitalinnovation.personapi.domain.model.Phone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneServiceTest {

    @Autowired
    private PhoneService phoneService;

    private final PhoneMapper phoneMapper = PhoneMapper.INSTANCE;

    @Test
    @DisplayName("Should create a Phone Request DTO")
    void testSaveAPhoneRequest() {
        Phone phone = PhoneUtils.createFakePhoneEntity();
        PhoneRequestDTO phoneToSave = PhoneUtils.createFakePhoneRequestDTO();
        PhoneResponseDTO phoneResponseDTO = phoneService.save(phoneToSave);

        assertNotNull(phoneResponseDTO);
        assertNotNull(phoneResponseDTO.getId());

        phone.setId(phoneResponseDTO.getId());

        assertEquals(phone, phoneMapper.toModel(phoneResponseDTO));
    }

    @Test
    @DisplayName("Should list a Phone Response DTO List")
    void testShouldListPhoneResponseDTO() {
        PhoneRequestDTO phoneToSave = PhoneUtils.createFakePhoneRequestDTO();
        phoneService.save(phoneToSave);
        List<PhoneResponseDTO> phoneResponseDTOList = phoneService.findAll();

        assertNotNull(phoneResponseDTOList.size() == 1);
        phoneResponseDTOList.forEach(phone -> assertNotNull(phone.getId()));
    }
}
