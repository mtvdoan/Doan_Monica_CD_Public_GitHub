import React from 'react';

import ProductForm from '../components/ProductForm';
import ProductList from '../components/ProductList';
import ProductInfo from '../components/ProductInfo';
import ProductEditForm from '../components/ProductEditForm';
import { Router, Link } from '@reach/router';


const Main = () => {
    return (
        <>
            <div>
                <h1>
                    <Link to="/">Home</Link> | 
                    <Link to="/new"> New Product</Link>
                </h1>
            </div>
            <hr/>

            <Router>
                <ProductForm path="/new" />
                <ProductList path="/" />
                <ProductInfo path="/product/:_id" />
                <ProductEditForm path="/edit/:_id" />
            </Router>
        </>
    )
}
export default Main;

/*
BASIC NOTES FOR ME TO UNDERSTAND BETTER:
In this code, it is importing React, as well as 4 other components: ProductForm, ProductList, ProductInfo, and ProductEditForm. Then it is using the Router component from the @reach/router library to create a set of routes for the application. The Router component has four child components: ProductForm, ProductList, ProductInfo and ProductEditForm.
Each component is mapped to a specific path. The ProductForm component is mapped to the "/new" path, the ProductList component is mapped to the "/" path, the ProductInfo component is mapped to the "/product/:_id" path, and the ProductEditForm component is mapped to the "/edit/:_id" path.
The Main component also contains a navigation menu at the top of the page with links to the home page and the new product page. The "Home" link is mapped to the "/" path and the "New Product" link is mapped to the "/new" path.
 */