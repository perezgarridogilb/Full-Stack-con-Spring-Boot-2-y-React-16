package com.ventas.ventas.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

        // @OneToMany
        // @JoinColumn(name = "id_persona", nullable = false)
    private Integer idVenta;

    private LocalDate fecha;

        @ManyToOne
        /** una venta a muchos clientes */
        @JoinColumn(name = "id_cliente"/* , nullable = false */)
        private Cliente cliente;

        public Integer getIdVenta() {
            return idVenta;
        }

        public void setIdVenta(Integer idVenta) {
            this.idVenta = idVenta;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((idVenta == null) ? 0 : idVenta.hashCode());
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
            Venta other = (Venta) obj;
            if (idVenta == null) {
                if (other.idVenta != null)
                    return false;
            } else if (!idVenta.equals(other.idVenta))
                return false;
            return true;
        }



}
