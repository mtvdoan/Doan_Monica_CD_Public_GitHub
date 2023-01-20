import React, {useState} from 'react';
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';

const ProductForm = (props) => {
    const[title, setTitle] = useState("");
    const[price, setPrice] = useState(0);
    const[description, setDescription] = useState("");
    const[errors, setErrors] = useState([]);

    const notify = () =>{
        toast("Success!  You have added a new product!", {
            position: toast.POSITION.TOP_CENTER
        });
    };
        
    const onSubmitHandler = (e) => {
        e.preventDefault();
        axios
            .post('http://localhost:8000/api/products/', {
                title,
                price,
                description
            })
            .then(() => console.log("Creation succesful on backend"))
            .catch((err) => {
                console.log(err)
                const errorRes = err.response.error.errors;
                const errorArray = [];
                for (const key of Object.keys(errorRes)){
                    errorArray.push(errorRes[key].message);
                }
                setErrors(errorArray);
            });
    }
    
    return(
        <>
            <h1 style={{background: "gainsboro"}}>Create Product Form</h1>
            <div style={{height: "350px", width: "500px", border: "2px solid grey", textAlign: "center", margin: "auto", padding: "auto"}}>
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
                        <textarea 
                            rows="4"
                            cols="30"
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