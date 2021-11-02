package com.one.digitalinnovation.personapi.api.mapper;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.one.digitalinnovation.personapi.api.dto.request.PersonRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PersonResponseDTO;
import com.one.digitalinnovation.personapi.api.utils.PersonUtils;
import com.one.digitalinnovation.personapi.domain.model.Person;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.AllArgsConstructor;

@SpringBootTest
@AllArgsConstructor
public class PersonMapperTest {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Test
    @Disabled
    @DisplayName("Shoud parse Person Model to Person Request DTO")
    void parseFromPersonModelToPersonRequestDTO() {
        Person person = PersonUtils.createFakePersonEntity();
        PersonRequestDTO personRequestDTO = PersonUtils.createFakePersonRequestDTO();

        assertNotNull(personRequestDTO);
        assertNull(personRequestDTO.getId());

        personRequestDTO.setId(person.getId());
        Person personParsed = personMapper.toModel(personRequestDTO);

        assertEquals(person, personParsed);
    }

    @Test
    @DisplayName("Shoud parse Person Model to Person Response DTO")
    void parseFromPersonModelToPersonResponseDTO() {
        Person person = PersonUtils.createFakePersonEntity();
        PersonResponseDTO personResponseDTO = PersonUtils.createFakePersonResponseDTO();

        assertNotNull(personResponseDTO);
        assertNotNull(personResponseDTO.getId());

        Person personParsed = personMapper.toModel(personResponseDTO);

        assertEquals(person, personParsed);
    }

    @Test
    @Disabled
    @DisplayName("Shoud parse Person Request DTO PersonModel to Person Model")
    void parseFromPersonRequestDTOToPersonModel() {
        Person person = PersonUtils.createFakePersonEntity();
        PersonRequestDTO personRequestDTO = PersonUtils.createFakePersonRequestDTO();

        assertNotNull(personRequestDTO);
        assertNull(personRequestDTO.getId());

        personRequestDTO.setId(person.getId());
        PersonRequestDTO personRequestDTOParsed = personMapper
            .fromModelToPersonRequestDTO(person);

        assertEquals(personRequestDTO, personRequestDTOParsed);
    }

    @Test
    @Disabled
    @DisplayName("Shoud parse Person Response DTO PersonModel to Person Model")
    void parseFromPersonResponseDTOToPersonModel() {
        Person person = PersonUtils.createFakePersonEntity();
        PersonResponseDTO personResponseDTO = PersonUtils.createFakePersonResponseDTO();

        assertNotNull(personResponseDTO);
        assertNotNull(personResponseDTO.getId());

        PersonResponseDTO personResponseDTOParsed = personMapper
            .fromModelToPersonResponseDTO(person);

        assertEquals(personResponseDTO, personResponseDTOParsed);
    }
}
