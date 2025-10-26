package com.ventas.ventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
        @Column(name = "nombres", nullable = false, length = 70)
        private String nombres;

        @Column(name = "apellidos", nullable = false, length = 150)
        private String apellidos;

        @Column(name = "direccion", nullable = true, length = 150)
        private String direccion;

        @Column(name = "telefono", nullable = true, length = 10)
        private String telefono;

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
