package com.ventas.ventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "cliente")
public class Cliente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer IdCliente;

        @Column(length = 20)
        private String nit;

        @Column(length = 100)
        private String razonSocial;

        @NotNull
        @NotBlank(message = "El email es obligatorio")
        @Size(min = 10, message = "El email es de al menos 10 caracteres")
        @Email(message = "El email no es válido")
        @Column(nullable = false, length = 150)
        private String email;

        @OneToOne
        @JoinColumn(name = "id_persona"/* , nullable = false */)
        private Persona persona;

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((IdCliente == null) ? 0 : IdCliente.hashCode());
                return result;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                Cliente other = (Cliente) obj;
                if (IdCliente == null) {
                        if (other.IdCliente != null)
                                return false;
                } else if (!IdCliente.equals(other.IdCliente))
                        return false;
                return true;
        }

        public Integer getIdCliente() {
                return IdCliente;
        }

        public void setIdCliente(Integer idCliente) {
                IdCliente = idCliente;
        }

        public String getNit() {
                return nit;
        }

        public void setNit(String nit) {
                this.nit = nit;
        }

        public String getRazonSocial() {
                return razonSocial;
        }

        public void setRazonSocial(String razonSocial) {
                this.razonSocial = razonSocial;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Persona getPersona() {
                return persona;
        }

        public void setPersona(Persona persona) {
                this.persona = persona;
        }





}
