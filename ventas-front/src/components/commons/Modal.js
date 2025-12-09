import React, { useContext } from 'react';
import { ModalContext } from '../../contexts/modalContex';

const Modal = (props) => {
    const { showModal, modalTitle, setShowModal, setmodalTitle } = useContext(ModalContext);

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
                        onClick={ () => {
                            cerrarModal();
                            setmodalTitle('')}
                        }
                    ></button>
                </header>

                <section className='modal-card-body'>
                    {props.children}
                </section>
            </div>
        </div>
    );
}

export default Modal;
