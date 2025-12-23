import React, { useContext } from 'react';
import { ModalContext } from "../contexts/modalContex";
import { ClienteContext } from '../contexts/clienteContext';


const ToolbarCliente = () => {
        const abrirModalCrear = () => {
        console.log("Modal Crear...");
        setShowModal(true);
        setmodalTitle('Registrar nuevo cliente');
        obtenerCliente(null);
;    }

       const { showModal, modalTitle, setShowModal, setmodalTitle } = useContext(ModalContext);

       const { obtenerCliente } = useContext(ClienteContext);
    
        const cerrarModal = () => {
            setShowModal(false);
        }
    return (<div className='container'>
        <button 
        className='button is-small is-primary'
        onClick={ () => {
            abrirModalCrear()
        } }
        >
            <span className='icon is-small '>
                <i className='fas fa-plus'></i>
            </span>
            <span>Registrar nuevo</span>
        </button>
    </div>);
}

export default ToolbarCliente;