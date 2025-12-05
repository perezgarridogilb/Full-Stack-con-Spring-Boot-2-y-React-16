import React, { useState } from 'react';

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
                            
                    <tr key={cliente.idCliente}>
                        <td>
                            <button className='button is-small is-info mr-1' title='Modificar'>
                                <span className='icon is-small '>
                                    <i className='fas fa-edit'></i>
                                </span>
                            </button>
                            <button className='button is-small is-danger' title='Eliminar'>
                                <span className='icon is-small'>
                                    <i className='fas fa-trash-alt'></i>
                                </span>
                            </button>
                        </td>
                        <td>{cliente.nombres}</td>
                        <td>{cliente.apellidos}</td>
                        <td>{cliente.direccion}</td>
                        <td>{cliente.email}</td>
                    </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}
export default TableCliente;