import React from 'react'


const Menu = () => {
    return (
        
        <div className='panel'>
            <p className='panel-heading'>
                Menu
            </p>
            <div className="panel-block">
                <div className="button is-fullwidth">
                    <span>
                        <i className="fas fa-home"></i>
                    </span>
                    <span>
Inicio
                    </span>
                    
                </div>
                                <div className="button is-fullwidth">
                    <span>
                        <i className="fas fa-users"></i>
                    </span>
                    <span>
Clientes
                    </span>
                    
                </div>
            </div>
        </div>
    );
}
 
export default Menu;