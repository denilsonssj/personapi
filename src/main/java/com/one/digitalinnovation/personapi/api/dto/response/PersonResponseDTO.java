package com.one.digitalinnovation.personapi.api.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.one.digitalinnovation.personapi.api.dto.request.PhoneRequestDTO;

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

    @NotNull()
    private LocalDate birthDate;

    @Valid()
    @NotEmpty
    private List<PhoneRequestDTO> phones;
    
}
