import React from 'react';

const Modal = (props) => {

    const cerrarModal = () => {
        console.log("Cerrando");
    }

    return ( 
        <div 
            className="modal is-active"
            style={{
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                position: "fixed",
                top: 0,
                left: 0,
                width: "100vw",
                height: "100vh",
            }}
        >
            {/* Fondo del modal */}
            <div className="modal-background"></div>

            {/* Contenedor del modal */}
            <div className="modal-card">
                <header className='modal-card-head'>
                    <p className='modal-card-title'>Crear cliente</p>
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
