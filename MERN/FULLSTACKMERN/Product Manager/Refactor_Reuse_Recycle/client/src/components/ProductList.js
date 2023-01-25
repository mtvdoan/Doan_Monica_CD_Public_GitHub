import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from '@reach/router';
import DeleteButton from './DeleteButton';

const ProductList = (props)=> {
  const getEverything = () => {
    axios.get("http://localhost:8000/api/products")
      .then(res => setProducts(res.data))
      .catch(err => console.log(err));
  };


  const [products, setProducts] = useState([]);


  useEffect( () => {
    getEverything();
  }, []);


  return(
    <div className = "container">
      <h3>Product List</h3>
      <table className='table table-striped'>
        <thead>
          <tr>
            <th scope="col">
              Title
            </th>
            <th scope="col">
              Price
            </th> 
            <th scope="col">
              Description
            </th>
            <th scope="col">
              Action
            </th>
          </tr>
        </thead>
        <tbody>
          
            { products.map( product => {
          return (
            <tr key={ product._id }>
            <td>
              <Link to = { `/product/${product._id}` }>{ product.title }</Link> 
            </td>
            <td>
              { product.price }
            </td>
            <td>
              { product.description }
            </td>
            <td>
              <Link to = {`/edit/${product._id}`} className="btn-link" > Edit </Link> | 
              <DeleteButton productId = { product._id } successCallback = { () => getEverything() }/>
            </td>
          </tr> 
        )})}     
    </tbody>
</table>
</div>
  )
}
export default ProductList;

/*
BASIC NOTES FOR SELF TO UNDERSTAND BETTER:

This code defines a functional React component called "ProductInfo" that takes in a prop called "_id". The component uses the React Hooks "useEffect" and "useState" to manage its state and behavior. The component fetches the product data by sending a GET request to the specified endpoint with the "_id" passed in as a prop appended to the end of the URL. The data fetched from the API is used to set the state of the component and also used to display the title, price, and description of the product.

The component renders a div element with h3 elements displaying the title, price, and description of the product. It also renders a component called "DeleteButton" passing it the product's _id and a callback function to navigate back to the home page when the delete action is successful.

 */