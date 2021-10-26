package com.one.digitalinnovation.personapi.api.dto.response;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDTO {

    private UUID id;

    @NotEmpty()
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty()
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty()
    @CPF()
    private String cpf;

    @NotNull()
    private String birthDate;

    @Valid()
    @NotEmpty
    private List<PhoneResponseDTO> phones;
    
}
