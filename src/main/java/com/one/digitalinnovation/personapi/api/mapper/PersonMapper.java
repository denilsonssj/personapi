package com.one.digitalinnovation.personapi.api.mapper;

import com.one.digitalinnovation.personapi.api.dto.request.PersonRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PersonResponseDTO;
import com.one.digitalinnovation.personapi.domain.model.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { PhoneMapper.class })
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonRequestDTO personRequestDTO);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonResponseDTO personResponseDTO);

    PersonResponseDTO toPersonResponseDTO(Person person);

    PersonResponseDTO fromModelToPersonResponseDTO(Person person);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    PersonRequestDTO fromModelToPersonRequestDTO(Person person);
}
