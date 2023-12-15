package com.olidev.pe.demo.service;

import com.olidev.pe.demo.model.dto.PersonaRequestDto;
import com.olidev.pe.demo.model.dto.PersonaResponseDto;
import com.olidev.pe.demo.model.entity.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> listarPersonas();
    Persona savePersona(PersonaRequestDto personaRequestDto);

}
