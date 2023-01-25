import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { navigate } from '@reach/router';
import '../App.css';
const ProductEditForm = (props) => {
  const [ title, setTitle ] = useState("");
  const [ price, setPrice ] = useState(0);
  const [ description, setDescription ] = useState("");
  const [ errors, setErrors ] = useState({});


	useEffect( () => {
		axios.get("http://localhost:8000/api/product/" + props._id)
		.then(res => {
			setTitle(res.data.title);
			setPrice(res.data.price);
			setDescription(res.data.description);
			console.log(res.data)
		})
		.catch(err => console.log(err))
	}, [props._id])


  const onSubmitHandler = e => {
		e.preventDefault();
		axios.put("http://localhost:8000/api/product/" + props._id, {
		title,
		price,
		description
    })
		.then(res => {
			if(res.data.errors) { setErrors(res.data.errors); }
			else { navigate("/"); }
			console.log(res);
		})
		.catch(err => console.log(err));
 	}

  return (
	<div>
		<form onSubmit={ onSubmitHandler }>
			<h2>Update A Product</h2>
			<div>
				<label>Title</label>
				<input type="text" onChange={(e) => setTitle(e.target.value)} value={ title }/>
				<span className="text-danger">{ errors.title ? errors.title.message: "" }</span>
			</div>
			<div>
				<label>Price   </label>
				<input type="number" onChange={(e) => setPrice(e.target.value)} value={ price }/>
				<span className="text-danger">{ errors.price ? errors.price.message: "" }</span>
			</div>
			<div>
				<label>Description</label>
				<input type="text" onChange={(e) => setDescription(e.target.value)} value={description}/>
				<span className="text-danger">{ errors.description ? errors.description.message: "" }</span>
			</div>
			<button type="submit">Submit</button>
		</form>
	</div>
  )
}
export default ProductEditForm;

/*
BASIC NOTES FOR SELF TO UNDERSTAND BETTER:

This code defines a functional React component called "ProductEditForm" that takes in a prop called "_id". The component uses the React Hooks "useState" and "useEffect" to manage its state and behavior. The component fetches the product data by sending a GET request to the specified endpoint with the "_id" passed in as a prop appended to the end of the URL. The data fetched from the API is used to set the state of the component and also used to populate the input fields in the form.

When the form is submitted, the component sends a PUT request to the same endpoint with the updated data. If there is any error, it will be handled and set to the "errors" state. If the request is successful, it will navigate to the home page.

The component renders a form with input fields for editing the title, price, and description of the product. The form includes an onSubmit event handler that calls the "onSubmitHandler" function which sends the PUT request. The component also includes error messages next to each input field that will be displayed if there are any errors.

 */