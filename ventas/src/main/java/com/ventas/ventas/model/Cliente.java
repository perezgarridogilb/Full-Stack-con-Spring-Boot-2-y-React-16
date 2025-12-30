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


        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        

}
