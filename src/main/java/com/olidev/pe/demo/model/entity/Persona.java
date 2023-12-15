package com.olidev.pe.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "person")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String nombre;

    @Column(name = "lastname")
    String apellido;

}
