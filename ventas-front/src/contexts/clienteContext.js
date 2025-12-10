import React, { createContext, useReducer } from 'react';
import clienteReducer from '../reducer/clienteReducer';

// 1. Crear el contexto
export const ClienteContext = createContext();

// 2. Crear el provider
export const ClienteContextProvider = (props) => {

    const initialState = {
        clientesList: []
    };

    const [state, dispatch] = useReducer(clienteReducer, initialState);

    return (
        <ClienteContext.Provider
            value={{
                clientesList: state.clientesList,
                dispatch
            }}
        >
            {props.children}
        </ClienteContext.Provider>
    );
};
