import './App.css';
import React from 'react';
import ProductForm from './components/ProductForm';
import Nav from './components/Nav';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DisplayList from './components/DisplayList';
import DisplayOne from './components/DisplayOne';
import UpdateProductForm from './components/UpdateProductForm';

function App() {
    return (
        <>
            <div style={{height: "auto", width: "600px auto", border: "2px solid grey", textAlign: "center", margin: "auto"}}>
                <h1>Project Manager Part III</h1>
                <BrowserRouter>
                    <Nav/>
                    <Routes>
                        <Route index/>
                        <Route path="/products/create" element={<ProductForm />}/>
                        <Route path="/products/" element={<DisplayList/>}/>
                        <Route path="/products/:id/" element = {<DisplayOne/>}/>
                        <Route path="/products/update/:id/" element = {<UpdateProductForm/>}/>
                    </Routes>
                </BrowserRouter>
            </div>
        </>
    );
}

export default App;
