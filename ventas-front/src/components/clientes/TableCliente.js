import React, { useContext, useEffect, useState } from 'react';
import RowCliente from './RowCliente';
import { ClienteContext } from '../../contexts/clienteContext';
import { type } from '@testing-library/user-event/dist/type';
import { OBTENER_CLIENTES } from '../const/actionTypes';

const TableCliente = () => {
    const  { clientesList, obtenerClientes } = useContext(ClienteContext);
    useEffect(() => {
        obtenerClientes();
    }, [])
    if (clientesList.length === 0) {
        return (<center><p>No existen clientes</p></center> );
    }

    // const obtenerClientes = () => {

    // const clientes = [
    //     {
    //         "idCliente": 1,
    //         "nombres": "Freddy",
    //         "apellidos": "Lopez",
    //         "direccion": "Av. Lincon",
    //         "telefono": "13213",
    //         "email": "freddy@gmail.com"
    //     },
    //     {
    //         "idCliente": 2,
    //         "nombres": "Juan",
    //         "apellidos": "Lopez",
    //         "direccion": "13132",
    //         "telefono": "juan@gmail.com",
    //         "email": "juan@gmail.com"
    //     }
    // ];

    //     dispatch({
    //         type: OBTENER_CLIENTES,
    //         playload: clientes
    //     })
    // }


    return (
        <div className='table-container'>
            <table className='table is-hoverable is-fullwidth'>
                <thead>
                    <tr>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        clientesList.map(cliente => (
                            <RowCliente cliente={cliente} key={cliente.idCliente}/>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}
export default TableCliente;