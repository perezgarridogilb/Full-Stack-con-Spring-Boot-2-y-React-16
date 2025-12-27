import React from 'react';
import 'bulma/css/bulma.css';
import '@fortawesome/fontawesome-free/js/all';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Clientes from './pages/Clientes';

import axios from 'axios';

axios.interceptors.request.use(config => {
  config.baseURL = process.env.REACT_APP_API_BASE_URL;
  return config;
});

function App() {
  return (

    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/clientes" element={<Clientes />} />
      </Routes>
    </Router>

  );
}

export default App;
