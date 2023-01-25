import React from 'react';
import axios from 'axios';
import { Button } from '../styles/Style';

const DeleteButton = (props) => {
  const { productId, successCallback } = props;


  const deleteProduct = e => {
    axios.delete('http://localhost:8000/api/product/' + productId)
      .then(res => { successCallback() })
  }


  return (
    <>
    
      <Button onClick={ deleteProduct }>Delete</Button>
    </>
  )
}
export default DeleteButton;

/*
BASIC NOTES FOR SELF TO UNDERSTAND BETTER:

This code defines a functional React component called "DeleteButton" that takes in props "productId" and "successCallback". The component renders a button element with an onClick event that calls a function called "deleteProduct". The "deleteProduct" function uses the "axios" library to make a DELETE request to the specified endpoint with the "productId" appended to the end of the URL. If the request is successful, it calls the "successCallback" function that was passed in as a prop. The component is exported at the end of the file to be used in other parts of the application.

 */
