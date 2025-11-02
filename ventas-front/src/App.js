import React from 'react';
import Header from './components/Header';
import Menu from './components/Menu';

function App() {
  const menu = 1;
  return (
    <div>
      <Header/>
      <Menu titulo ={menu}/>
    </div>
  );
}

export default App;
