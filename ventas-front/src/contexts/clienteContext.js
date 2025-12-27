import React, { createContext, useReducer } from 'react';
import clienteReducer from '../reducer/clienteReducer';
import { ELIMINAR_CLIENTE, MODIFICAR_CLIENTE, OBTENER_CLIENTE, OBTENER_CLIENTES, REGISTRAR_CLIENTE } from '../components/const/actionTypes';
import { type } from '@testing-library/user-event/dist/type';
import { v4 as uuidv4 } from 'uuid';
import Axios from 'axios';


// 1. Crear el contexto
export const ClienteContext = createContext();

// 2. Crear el provider
export const ClienteContextProvider = (props) => {

    const initialState = {
        clientesList: [],
        clienteActual: null
    };

    const [state, dispatch] = useReducer(clienteReducer, initialState);

        const obtenerClientes = async () => {

            try {
        const response = await Axios.get('http://localhost:9090/api/clientes');
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
    
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

    const registrarCliente = cliente => {
        let clienteNuevo = {
            ...cliente,
            idCliente:  uuidv4()
        }

        console.log(clienteNuevo);
        
        dispatch({
            type: REGISTRAR_CLIENTE,
            payload: clienteNuevo
        })
    }

            const obtenerCliente = (cliente) => {
                
            dispatch({
                type: OBTENER_CLIENTE,
                payload: cliente
            })
        }

        const actualizarCliente = cliente => {
            dispatch({
                type: MODIFICAR_CLIENTE,
                payload: cliente
            })
        }

                const eliminarCliente = idCliente => {
            dispatch({
                type: ELIMINAR_CLIENTE,
                payload: idCliente
            })
        }

    return (
        <ClienteContext.Provider
            value={{
                clientesList: state.clientesList,
                clienteActual: state.clienteActual,

                obtenerClientes,
                registrarCliente,
                obtenerCliente,
                actualizarCliente,
                eliminarCliente
            }}
        >
            {props.children}
        </ClienteContext.Provider>
    );
};
