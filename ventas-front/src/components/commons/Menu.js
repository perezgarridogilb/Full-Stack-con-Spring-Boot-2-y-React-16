import React from 'react'
import { Link } from 'react-router-dom';


const Menu = () => {
    return (

        <div className='panel'>
            <p className='panel-heading'>
                Menu
            </p>
            <div className="panel-block">
                <Link to="/" className="button is-fullwidth">
                    <span>
                        <i className="fas fa-home"></i>
                    </span>
                    <span>
                        Inicio
                    </span>

                </Link>
                <Link to="/clientes" className="button is-fullwidth">
                    <span>
                        <i className="fas fa-users"></i>
                    </span>
                    <span>
                        Clientes
                    </span>
                </Link>
            </div>
        </div>
    );
}

export default Menu;