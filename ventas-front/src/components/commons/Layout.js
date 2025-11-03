import React from 'react'
import Menu from './Menu';
import Header from './Header';

const Layout = () => {
    return (<div>

        <Header/>
        <div className="container">

            <div className="columns">
                <div className="column is-one-quarter"><Menu/></div>
                <div className="column">
                    <p>Este es el contenido</p>
                </div>
            </div>
        </div>
        </div>
    );
}
 
export default Layout;