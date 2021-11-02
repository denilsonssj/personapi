package com.one.digitalinnovation.personapi.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.one.digitalinnovation.personapi.api.dto.request.PhoneRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PhoneResponseDTO;
import com.one.digitalinnovation.personapi.api.mapper.PhoneMapper;
import com.one.digitalinnovation.personapi.api.repository.PhoneRepository;
import com.one.digitalinnovation.personapi.domain.model.Phone;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PhoneService {

    private PhoneRepository phoneRepository;

    private final PhoneMapper phoneMapper = PhoneMapper.INSTANCE;

    @Transactional
    public PhoneResponseDTO save(PhoneRequestDTO phoneRequestDTO) {
        Phone phoneToSave = phoneMapper.toModel(phoneRequestDTO);
        return this.phoneMapper.fromModeltoResponseDTO(
            this.phoneRepository.save(phoneToSave)
        );
    }

    @Transactional
    public List<PhoneResponseDTO> findAll() {
        return this.phoneRepository.findAll()
            .stream()
            .map(this.phoneMapper::fromModeltoResponseDTO)
            .collect(Collectors.toList());
    }
}
