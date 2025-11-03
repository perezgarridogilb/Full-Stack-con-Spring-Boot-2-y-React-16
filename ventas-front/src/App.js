import React from 'react';
import 'bulma/css/bulma.css'
import Header from './components/commons/Header';
import Menu from './components/commons/Menu';
 import '@fortawesome/fontawesome-free/js/all'

function App() {
  const menu = 1;
  return (
    <div> 
            <Header/>
            <Menu/>
    </div>
  );
}

export default App;
