import React, { useContext } from 'react';
import { ModalContext } from "../../contexts/modal/modalContex";

const Modal = () => {
    const { showModal, modalTitle, setShowModal } = useContext(ModalContext);

    const cerrarModal = () => {
        setShowModal(false);
    }

    if (!showModal) return null; // ← oculta por completo el modal

    return (
        <div className="modal is-active">
            <div className="modal-background" onClick={cerrarModal}></div>

            <div className="modal-card">
                <header className='modal-card-head'>
                    <p className='modal-card-title'>{modalTitle}</p>
                    <button
                        className='delete'
                        aria-label='close'
                        onClick={cerrarModal}
                    ></button>
                </header>

                <section className='modal-card-body'>
                    Contenido
                </section>
            </div>
        </div>
    );
}

export default Modal;
