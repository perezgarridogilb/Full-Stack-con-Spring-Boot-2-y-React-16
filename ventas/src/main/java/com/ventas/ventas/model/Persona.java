package com.ventas.ventas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

        @NotNull(message = "El nombre no puede ser nulo")
        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 3, max = 70, message = "El nombre debe ser mayor a 3 caracteres")
        @Column(name = "nombres", nullable = false, length = 70)
        private String nombres;

        @NotNull
        @NotBlank(message = "Los apellidos son obligatorios")
        @Size(min = 3, max = 150, message = "Los apellidos deben ser mayor a 3 caracteres")
        @Column(name = "apellidos", nullable = false, length = 150)
        private String apellidos;

        @Size(min = 3, message = "La dirección no debe superar los 150 caracteres")
        @Column(name = "direccion", nullable = true, length = 150)
        private String direccion;

        @Size(min = 8, message = "El teléfono debe tener al menos 8 digitos")
        @Column(name = "telefono", nullable = true, length = 10)
        private String telefono;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }



    
}
