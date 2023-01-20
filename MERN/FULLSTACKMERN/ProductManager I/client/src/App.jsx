import './App.css';
import React, {useState} from 'react';
import ProductForm from './components/ProductForm';
import Nav from './components/Nav';
// import Main from '../src/views/Main';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import axios from 'axios';
import DisplayList from './components/DisplayList';

function App() {
    return (
        <>
            <div style={{height: "600px", width: "600px", border: "2px solid grey", textAlign: "center", margin: "auto"}}>

                <h1>Project Manager Part 1</h1>
                <BrowserRouter>
                    <Nav/>
                    <Routes>
                        <Route index/>
                        <Route path="/products/create" element={<ProductForm />}/>
                        <Route path="/products/" element={<DisplayList/>}/>

                    </Routes>
                </BrowserRouter>
            </div>
        </>
    );
}

export default App;
