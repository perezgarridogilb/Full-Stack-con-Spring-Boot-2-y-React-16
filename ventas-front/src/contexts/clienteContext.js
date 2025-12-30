import React, { createContext, useReducer } from 'react';
import clienteReducer from '../reducer/clienteReducer';
import { ELIMINAR_CLIENTE, MODIFICAR_CLIENTE, OBTENER_CLIENTE, OBTENER_CLIENTES, REGISTRAR_CLIENTE } from '../components/const/actionTypes';
// import { v4 as uuidv4 } from 'uuid';
import Axios from 'axios';
import Swal from 'sweetalert2';

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
        // const response1 = [];
        try {
            const response = await Axios.get('/clientes');
            console.log(response.data);
            dispatch({
                type: OBTENER_CLIENTES,
                payload: response.data
            })
        } catch (error) {
            console.error(error);
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "No se pudo obtener clientes",
                toast: true
            });
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


    }

    const registrarCliente = async cliente => {
        try {
            const response = await Axios.post('/clientes', cliente);

            dispatch({
                type: REGISTRAR_CLIENTE,
                payload: response.data
            });

            Swal.fire({
                icon: "success",
                title: "Correcto",
                text: "Cliente registrado correctamente",
                toast: true
            });
            return true; // ✅ éxito
        } catch (error) {
            console.error(error);
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "No se pudo registrar el cliente",
                toast: true
            });
            return false; // ❌ error
        }
    };

    const obtenerCliente = async (cliente) => {
        try {
            let clienteEncontrado = null;
            if (cliente !== null) {
                const response = await Axios.get(`/clientes/${cliente.idCliente}`);
                clienteEncontrado = response.data;
            } else {
                clienteEncontrado = cliente;
            }
            dispatch({
                type: OBTENER_CLIENTE,
                payload: clienteEncontrado
            })
        } catch (error) {
            console.error(error);
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "No se pudo obtener el cliente",
                toast: true
            });
        }

    }

    const actualizarCliente = async cliente => {
        debugger;
        try {

            const response = await Axios.put(`/clientes`, cliente);

            dispatch({
                type: MODIFICAR_CLIENTE,
                payload: response.data
            })

            Swal.fire({
                icon: "success",
                title: "Correcto",
                text: "Cliente modificado correctamente",
                toast: true
            });
        } catch (error) {
            console.log(error);
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "No se pudo modificar el cliente",
                toast: true
            });

        }
    }

    const eliminarCliente = idCliente => {
        try {


            Swal.fire({
                icon: "question",
                title: "¿Desea continuar?",
                text: "Se eliminará el cliente seleccionado",
                showCancelButton: true,
                confirmButtonText: 'Sí, eliminar'
            }).then(async result => {
                if (result.value) {
                    await Axios.delete(`/clientes/${idCliente}`);
                    dispatch({
                        type: ELIMINAR_CLIENTE,
                        payload: idCliente
                    })

                    Swal.fire({
                        icon: "success",
                        title: "Correcto",
                        text: "Cliente eliminado correctamente",
                        toast: true
                    });
                }
            });

        } catch (error) {
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "No se pudo eliminar el cliente",
                toast: true
            });
        }
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
