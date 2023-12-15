package com.olidev.pe.demo.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class PersonaRequestDto implements Serializable {

    @NotBlank(message = "nombre no puede ser nulo o vacío")
    public String nombre;

    @NotBlank(message = "apellido no puede ser nulo o vacío")
    public String apellido;
}
