package com.one.digitalinnovation.personapi.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "first_name")
    @NotBlank()
    @Size(max = 64)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank()
    @Size(max = 64)
    private String lastName;

    @Column(name = "cpf", nullable = false, unique = true)
    @NotBlank()
    @CPF()
    private String cpf;

    @Column(name = "birth_date")
    @NotNull()
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = { 
        CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE
    })
    private List<Phone> phones;
}
