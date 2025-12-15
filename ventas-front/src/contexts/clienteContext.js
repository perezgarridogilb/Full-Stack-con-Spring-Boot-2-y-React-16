import React, { createContext, useReducer } from 'react';
import clienteReducer from '../reducer/clienteReducer';
import { OBTENER_CLIENTES } from '../components/const/actionTypes';

// 1. Crear el contexto
export const ClienteContext = createContext();

// 2. Crear el provider
export const ClienteContextProvider = (props) => {

    const initialState = {
        clientesList: []
    };

    const [state, dispatch] = useReducer(clienteReducer, initialState);

        const obtenerClientes = () => {
    
        const clientes = [
            {
                "idCliente": 1,
                "nombres": "Freddy",
                "apellidos": "Lopez",
                "direccion": "Av. Lincon",
                "telefono": "13213",
                "email": "freddy@gmail.com"
            },
            {
                "idCliente": 2,
                "nombres": "Juan",
                "apellidos": "Lopez",
                "direccion": "13132",
                "telefono": "juan@gmail.com",
                "email": "juan@gmail.com"
            }
        ];
    
            dispatch({
                type: OBTENER_CLIENTES,
                payload: clientes
            })
        }

    return (
        <ClienteContext.Provider
            value={{
                clientesList: state.clientesList,
                obtenerClientes
            }}
        >
            {props.children}
        </ClienteContext.Provider>
    );
};
