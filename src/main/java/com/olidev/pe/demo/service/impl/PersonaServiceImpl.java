package com.olidev.pe.demo.service.impl;

import com.olidev.pe.demo.model.dao.PersonaRepository;
import com.olidev.pe.demo.model.dto.PersonaRequestDto;
import com.olidev.pe.demo.model.dto.PersonaResponseDto;
import com.olidev.pe.demo.model.entity.Persona;
import com.olidev.pe.demo.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<Persona> listarPersonas() {
        if (personaRepository.findAll().isEmpty()) return null;
        return personaRepository.findAll();
    }

    @Override
    public Persona savePersona(PersonaRequestDto personaRequestDto) {
        Persona persona = Persona
                .builder()
                .nombre(personaRequestDto.nombre)
                .apellido(personaRequestDto.apellido)
                .build();
        return personaRepository.save(persona);
    }
}
