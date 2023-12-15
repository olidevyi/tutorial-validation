package com.olidev.pe.demo.controller;

import com.olidev.pe.demo.model.dto.PersonaRequestDto;
import com.olidev.pe.demo.model.dto.PersonaResponseDto;
import com.olidev.pe.demo.model.entity.Persona;
import com.olidev.pe.demo.service.PersonaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping("/personas")
    public ResponseEntity<List<PersonaResponseDto>> listarPersonas() {
        List<Persona> personaList = personaService.listarPersonas();
        List<PersonaResponseDto> personaResponseDtoList = personaList.stream().map(persona -> PersonaResponseDto
                                                                                                .builder()
                                                                                                .id(persona.getId())
                                                                                                .nombre(persona.getNombre())
                                                                                                .apellido(persona.getApellido())
                                                                                                .build())
                                                                                                .toList();
        return new ResponseEntity<>(personaResponseDtoList, HttpStatus.OK);
    }

    @PostMapping("/persona")
    public ResponseEntity<PersonaResponseDto> savePersona(@RequestBody @Valid PersonaRequestDto personaRequestDto, UriComponentsBuilder uriComponentsBuilder) {
            Persona persona = personaService.savePersona(personaRequestDto);
            URI url = uriComponentsBuilder.path("api/v1/persona/{id}").buildAndExpand(persona.getId()).toUri();
            PersonaResponseDto personaResponseDto = PersonaResponseDto
                                                    .builder()
                                                    .id(persona.getId())
                                                    .nombre(persona.getNombre())
                                                    .apellido(persona.getApellido())
                                                    .build();
            return ResponseEntity.created(url).body(personaResponseDto);
    }

}
