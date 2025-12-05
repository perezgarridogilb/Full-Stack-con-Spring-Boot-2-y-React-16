import React from 'react'
import Layout from '../components/commons/Layout';
import TableCliente from '../components/clientes/TableCliente';

const Clientes = () => {
    
    return (
        <Layout>
            <div className='panel '>
                <div className='panel-heading'>
                    Clientes
                </div>
                <div className='box'>
                    <div className='container'>
                        <button className='button is-small is-primary' >
                            <span className='icon is-small '>
                                <i className='fas fa-plus'></i>
                            </span>
                            <span>Registrar nuevo</span>
                        </button>
                    </div>
                    <TableCliente/>
                </div>
            </div>
        </Layout>
    );
}

export default Clientes;