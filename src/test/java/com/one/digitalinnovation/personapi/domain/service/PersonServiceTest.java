package com.one.digitalinnovation.personapi.domain.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.one.digitalinnovation.personapi.api.dto.request.PersonRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PersonResponseDTO;
import com.one.digitalinnovation.personapi.api.utils.PersonUtils;
import com.one.digitalinnovation.personapi.domain.model.Person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    @DisplayName("Should be create a fake person")
    void testGivenPersonRequestDTOReturnSavedPerson() {
        PersonRequestDTO personRequestDTO = PersonUtils.createFakePersonRequestDTO();
        Person person = PersonUtils.createFakePersonEntity();

        PersonResponseDTO personResponseDTO = this.personService.save(personRequestDTO);

        assertNotNull(personResponseDTO);
        assertNotNull(personResponseDTO.getId());
        personResponseDTO.getPhones().forEach(phone ->
            assertNotNull(phone.getId())
        );
        
    }
}

