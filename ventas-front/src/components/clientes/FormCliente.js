import React, { useContext, useState } from 'react';
import { ModalContext } from '../../contexts/modalContex';
import { ClienteContext } from '../../contexts/clienteContext';

const FormCliente = () => {

        const { showModal, modalTitle, setShowModal, setmodalTitle } = useContext(ModalContext);
    
        const { registrarCliente } = useContext(ClienteContext);

    const clienteDefault = {
        nombres: '',
        apellidos: '',
        direccion: '',
        telefono: '',
        email: ''
    }

       const cerrarModal = () => {
           limpiarForm();
    setShowModal(false);
    // obtenerCliente(null);     
    }

    const handleChange = e => {
        setCliente({
            ...cliente,
            [e.target.name]: e.target.value
        })
    }


    const [cliente, setCliente] = useState(clienteDefault);
    const [mensaje, setMensaje] = useState(null);

    const handleOnSubmit = e => {
        e.preventDefault();
        debugger;
            // validar
        if (cliente.nombres.trim() === '' && cliente.apellidos.trim() === '' && cliente.email.trim() === '') {
            setMensaje('Los nombres, apellidos y el email son obligatorios.');
            return;
        }

        // obtener objeto enviar
        //console.log(obtenerClienteAEnviar());
        registrarCliente(obtenerClienteAEnviar());
    

        // cerrar y limpiar el modal
        cerrarModal();
    }

    const obtenerClienteAEnviar = () => {
        let clienteTemp = {...cliente};
        if (clienteTemp.direccion === '') {
            delete clienteTemp.direccion;
        }
        debugger;
        if (clienteTemp.telefono === '') {
            delete clienteTemp.telefono;
        }
        return clienteTemp;
    }

      const limpiarForm = () => {
    setMensaje(null);
    setCliente(clienteDefault);
  }

 

    return (
        <form onSubmit={handleOnSubmit}>
      { mensaje ? <div className="notification is-danger">{mensaje}</div> : null }

            <div class="field is-horizontal">
                <div class="field-label is-normal">
                    <label class="label">Nombre Completo</label>
                </div>
                <div class="field-body">
                    <div class="field">
                        <p class="control is-expanded has-icons-left">
                            <input
                                autocomplete="off"
                                class="input"
                                type="text"
                                placeholder="Nombre"
                                name="nombres"
                                value={cliente.nombres}
                                onChange={handleChange}

                            />
                            <span class="icon is-small is-left">
                                <i class="fas fa-user"></i>
                            </span>
                        </p>
                    </div>
                    <div class="field">
                        <p class="control is-expanded">
                            <input
                                autocomplete="off"
                                class="input"
                                type="text"
                                placeholder="Apellidos"
                                name="apellidos"
                                value={cliente.apellidos}
                                onChange={handleChange}
                            />
                        </p>
                    </div>
                </div>
            </div>

            <div class="field is-horizontal">
                <div class="field-label is-normal">
                    <label class="label">Direccion</label>
                </div>
                <div class="field-body">
                    <div class="field">
                        <div class="control is-expanded has-icons-left">
                            <input
                                autocomplete="off"
                                class="input"
                                type="text"
                                placeholder="Ingrese su direccion"
                                name="direccion"
                                value={cliente.direccion}
                                onChange={handleChange}
                            />
                            <span class="icon is-small is-left">
                                <i class="fas fa-map-marked-alt"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="field is-horizontal">
                <div class="field-label is-normal">
                    <label class="label">Telefono</label>
                </div>
                <div class="field-body">
                    <div class="field">
                        <div class="control is-expanded has-icons-left">
                            <input
                                autocomplete="off"
                                class="input"
                                type="text"
                                placeholder="Telefono"
                                name="telefono"
                                value={cliente.telefono}
                                onChange={handleChange}
                            />
                            <span class="icon is-small is-left">
                                <i class="fas fa-phone"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="field is-horizontal">
                <div class="field-label is-normal">
                    <label class="label">Email</label>
                </div>
                <div class="field-body">
                    <div class="field">
                        <div class="control is-expanded has-icons-left">
                            <input
                                autocomplete="off"
                                class="input"
                                type="email"
                                placeholder="Ingrese su Email"
                                name="email"
                                value={cliente.email}
                                onChange={handleChange}
                            />
                            <span class="icon is-small is-left">
                                <i class="fas fa-envelope"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="field is-horizontal">
                <div class="field-label"></div>
                <div class="field-body">
                    <div class="field">
                        <div class="control">
              <button type="submit" className="button is-primary mr-1">Guardar</button>
                            <button type="button" class="button" onClick={ () => cerrarModal() }>Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>

        </form>

    );
}

export default FormCliente;