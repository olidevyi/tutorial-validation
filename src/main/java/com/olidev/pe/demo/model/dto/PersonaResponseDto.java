package com.olidev.pe.demo.model.dto;

import lombok.Builder;

import java.io.Serializable;

//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class PersonaResponseDto implements Serializable {

    public Long id;
    public String nombre;
    public String apellido;

}
