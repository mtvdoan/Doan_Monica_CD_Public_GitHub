import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';
import render from 'react-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';;

const ProductForm = (props) => {
    const[title, setTitle] = useState("");
    const[price, setPrice] = useState(0);
    const[description, setDescription] = useState("");
    const notify = () => toast("wow");

    const onSubmitHandler = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/products/', {
            title,
            price,
            description
        })
            .then(res => {
                console.log(res) 
                console.log(res.data)
            })
            .catch(err => console.error(err))
    
    }
    
    return(
        <>

            <h1 style={{background: "gainsboro"}}>Create Product Form</h1>
            <div style={{height: "350px", width: "300px", border: "2px solid grey", textAlign: "center", margin: "auto", padding: "auto"}}>
                <form onSubmit = {onSubmitHandler}>
                    <p>
                        <label> Title:  </label>
                        <br/>
                        <input
                            type = "text"
                            onChange = {(e) => setTitle(e.target.value)}
                        />
                    </p>
                    <p>
                        <label> Price:  </label>
                        <br/>
                        <input
                            type = "number"
                            step = "0.01"
                            onChange = {(e) => setPrice(e.target.value)}
                        />
                    </p>
                    <p>
                        <label> Description:  </label>
                        <br/>
                        <input
                            type = "text"
                            onChange = {(e) => setDescription(e.target.value)}
                        />
                    </p>
                    <div>
                        <button className="btn btn-success" onClick={notify}>Submit!</button>
                        <ToastContainer />
                    </div>
                </form>
            </div>

        </>
    )
};

export default ProductForm;