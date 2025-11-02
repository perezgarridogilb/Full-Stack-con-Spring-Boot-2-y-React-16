package com.ventas.ventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "cliente")
public class Cliente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer IdCliente;

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

        @NotNull
        @NotBlank(message = "El email es obligatorio")
        @Size(min = 10, message = "El email es de al menos 10 caracteres")
        @Email(message = "El email no es válido")
        @Column(nullable = false, length = 150)
        private String email;

        public Integer getIdCliente() {
                return IdCliente;
        }

        public void setIdCliente(Integer idCliente) {
                IdCliente = idCliente;
        }

        public String getNombres() {
                return nombres;
        }

        public void setNombres(String nombres) {
                this.nombres = nombres;
        }

        public String getApellidos() {
                return apellidos;
        }

        public void setApellidos(String apellidos) {
                this.apellidos = apellidos;
        }

        public String getDireccion() {
                return direccion;
        }

        public void setDireccion(String direccion) {
                this.direccion = direccion;
        }

        public String getTelefono() {
                return telefono;
        }

        public void setTelefono(String telefono) {
                this.telefono = telefono;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        

}
