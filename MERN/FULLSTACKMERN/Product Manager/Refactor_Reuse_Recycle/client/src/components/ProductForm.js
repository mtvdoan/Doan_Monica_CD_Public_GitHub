import React, { useState } from 'react';
import axios from 'axios';
import { navigate } from '@reach/router';
// import { Form, Label, FormGroup, Input, Button } from '../styles/Style';



import '../App.css';


const ProductForm = (props) => {
  const [ title, setTitle ] = useState("");
  const [ price, setPrice ] = useState(0);
  const [ description, setDescription ] = useState("");
  const [ errors, setErrors ] = useState({});


  const onSubmitHandler = e => {
    e.preventDefault();
    axios.post('http://localhost:8000/api/product', { title, price, description })
      .then(res => {
        if(res.data.errors) { setErrors(res.data.errors); }
        else { navigate("/"); }
        console.log(res);
      })
      .catch(err => console.log(err));
  }

  
  return (
    <form onSubmit={ onSubmitHandler }>
      <h2>Create a Product</h2>
      <div>
        <label>Title</label>
        <input type="text" onChange={(e) => setTitle(e.target.value)}/>
        <span className="text-danger">{ errors.title ? errors.title.message: "" }</span>
      </div>
      <div>
        <label>Price</label>
        <input type="number" onChange={(e) => setPrice(e.target.value)}/>
        <span className="text-danger">{ errors.price ? errors.price.message: "" }</span>
      </div>
      <div>
        <label>Description</label>
        <input type="text" onChange={(e) => setDescription(e.target.value)}/>
        <span className="text-danger">{ errors.description ? errors.description.message: "" }</span>
      </div>
      <button type="submit">Submit</button>
    </form>
  )
}
export default ProductForm;

/**
BASIC NOTES FOR SELF TO UNDERSTAND BETTER:

This code defines a functional React component called "ProductForm" that manages its state using the React Hook "useState". The component renders a form with input fields for creating a new product, including title, price, and description. The form includes an onSubmit event handler that calls the "onSubmitHandler" function which sends a POST request to the specified endpoint with the data entered in the form fields.

The "onSubmitHandler" function uses the "axios" library to make a POST request to the specified endpoint with the data entered in the form fields. If there is any error, it will be handled and set to the "errors" state. If the request is successful, it will navigate to the home page.

The component also includes error messages next to each input field that will be displayed if there are any errors.

It also uses the "navigate" function from the "@reach/router" library to redirect to the home page on a successful submission
 */