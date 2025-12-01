import React from 'react'
import Layout from '../components/commons/Layout';

const Clientes = () => {
    return (
        <Layout>
            <div className='panel '>
                <div className='panel-heading'>
                    Clientes
                </div>
                <div className='box'>
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
                            <tr>
                                <td>
                                    <button className='button'>
                                        <span className='icon is-small'>
                                            <i className='fas fa-bold'></i>
                                        </span>
                                    </button>
                                </td>
                                <td>Aguilar</td>
                                <td>C. Lincon</td>
                                <td>2222222221</td>
                                <td>freddy@gmail.com</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </Layout>
    );
}

export default Clientes;