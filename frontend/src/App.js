import logo from './logo.svg';
import './App.css';

import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Test from './Test';
import Add from './Add';
import Home from './Home';
import View from './View';
import Delete from './Delete';


function About() {
  return <h1>О нас</h1>;
}

function NotFound() {
  return <h1>Страница не найдена</h1>;
}

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/add" element={<Add />}/>
        <Route path="/test" element={<Test />} />
        <Route path='/view' element={<View/>} />
        <Route path='/delete' element={<Delete/>} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
  );
}

export default App;
