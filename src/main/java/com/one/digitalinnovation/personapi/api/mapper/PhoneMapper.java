package com.one.digitalinnovation.personapi.api.mapper;

import com.one.digitalinnovation.personapi.api.dto.request.PhoneRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PhoneResponseDTO;
import com.one.digitalinnovation.personapi.domain.model.Phone;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toModel(PhoneRequestDTO phoneRequestDTO);

    Phone toModel(PhoneResponseDTO phoneResponseDTO);

    PhoneResponseDTO fromModeltoResponseDTO(Phone phone);

    PhoneRequestDTO fromModeltoRequestDTO(Phone phone);

}
