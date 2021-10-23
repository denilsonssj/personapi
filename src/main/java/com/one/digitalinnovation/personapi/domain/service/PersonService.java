package com.one.digitalinnovation.personapi.domain.service;

import java.util.List;

import com.one.digitalinnovation.personapi.api.dto.request.PersonRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PersonResponseDTO;
import com.one.digitalinnovation.personapi.api.mapper.PersonMapper;
import com.one.digitalinnovation.personapi.domain.model.Person;
import com.one.digitalinnovation.personapi.domain.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    public PersonResponseDTO save(PersonRequestDTO personRequestDTO) {
        Person person = personMapper.toModel(personRequestDTO);
        return personMapper.toPersonResponseDTO(this.personRepository.save(person));
    }

}
