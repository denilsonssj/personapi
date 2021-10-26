package com.one.digitalinnovation.personapi.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.one.digitalinnovation.personapi.api.dto.request.PersonRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PersonResponseDTO;
import com.one.digitalinnovation.personapi.api.mapper.PersonMapper;
import com.one.digitalinnovation.personapi.api.repository.PersonRepository;
import com.one.digitalinnovation.personapi.domain.model.Person;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public List<PersonResponseDTO> findAll() {
        List<Person> people = this.personRepository.findAll();
        return people.stream().map(personMapper::toPersonResponseDTO)
          .collect(Collectors.toList());
    }

    public PersonResponseDTO save(PersonRequestDTO personRequestDTO) {
        Person person = personMapper.toModel(personRequestDTO);
        return personMapper.toPersonResponseDTO(this.personRepository.save(person));
    }

    public Optional<PersonResponseDTO> findById(UUID id) {
        Optional<Person> person = this.personRepository.findById(id);
        if(person.isPresent()) {
            return Optional.of(this.personMapper.toPersonResponseDTO(person.get()));
        }
        return Optional.empty();
    }

    public Optional<PersonResponseDTO> deleteById(UUID id) {
        Optional<Person> person = this.personRepository.findById(id);
        if (person.isPresent()) {
            this.personRepository.deleteById(id);
            return Optional.of(this.personMapper.toPersonResponseDTO(person.get()));
        }
        return Optional.empty();
    }

    public Optional<PersonResponseDTO> updateById(
        UUID id, PersonRequestDTO personRequestDTO) {
        if(this.personRepository.existsById(id)) {
            Person savedPerson = this.personRepository
                .save(this.personMapper.toModel(personRequestDTO));
            return Optional.of(this.personMapper.toPersonResponseDTO(savedPerson));
        }
        return Optional.empty();
    }

}
