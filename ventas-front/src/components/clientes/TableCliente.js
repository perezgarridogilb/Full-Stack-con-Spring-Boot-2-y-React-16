import React, { useState } from 'react';
import RowCliente from './RowCliente';

const TableCliente = () => {
    const [clientesList, setClientesList] = useState([
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
    ]);

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