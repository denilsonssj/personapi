package com.one.digitalinnovation.personapi.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.one.digitalinnovation.personapi.api.dto.request.PersonRequestDTO;
import com.one.digitalinnovation.personapi.api.dto.response.PersonResponseDTO;
import com.one.digitalinnovation.personapi.domain.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")

public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public List<PersonResponseDTO> findAll() {
        return this.personService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonResponseDTO> save(
        @RequestBody @Valid PersonRequestDTO person) {
        return ResponseEntity.ok(personService.save(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable UUID id) {
        Optional<PersonResponseDTO> personResponse = this.personService.findById(id);
        return personResponse.map(ResponseEntity::ok)
          .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        Optional<PersonResponseDTO> personResponse = this.personService.deleteById(id);
        if(personResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> updateById(
        @PathVariable UUID id,
        @RequestBody @Valid PersonRequestDTO personRequestDTO) {
        Optional<PersonResponseDTO> person = this.personService.updateById(id, personRequestDTO);
        if(person.isPresent()) {
            return ResponseEntity.ok(person.get());
        }
        return ResponseEntity.notFound().build();
    }
}
