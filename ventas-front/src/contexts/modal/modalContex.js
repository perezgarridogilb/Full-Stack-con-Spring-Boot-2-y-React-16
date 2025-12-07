import { createContext, useState } from "react";

export const ModalContext = createContext();

export const ModalContextProvider = ({ children }) => {
    const [showModal, setShowModal] = useState(false);
    const [modalTitle, setmodalTitle] = useState("");

    return (
        <ModalContext.Provider value={{ showModal, modalTitle, setShowModal, setmodalTitle }}>
            {children}
        </ModalContext.Provider>
    );
};

export default ModalContext;
