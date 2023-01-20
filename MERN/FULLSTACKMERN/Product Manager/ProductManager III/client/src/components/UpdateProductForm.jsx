import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';
import { useParams } from 'react-router-dom';

const UpdateProductForm = (props) => {
    const {id} = useParams();
    const[title, setTitle] = useState("");
    const[price, setPrice] = useState(0);
    const[description, setDescription] = useState("");
    const[errors, setErrors] = useState([]);
    const notify = () =>{
        toast("You have successfully updated a product!", {
            position: toast.POSITION.TOP_CENTER
        });
    };
    useEffect(() => {
        axios
            .get('http://localhost:8000/api/products/' + id)
            .then(res=> {
                setTitle(res.data.title)
                setPrice(res.data.price)
                setDescription(res.data.description)
            })
            .catch(err => console.log('Something went wrong while updating'))
    },[]);

    const onSubmitHandler = (e) => {
        e.preventDefault();
        const newProduct = {
            title, 
            price,
            description
        }
        axios
            .put('http://localhost:8000/api/products/' + id, newProduct)
            .then(() => console.log('Update is successful in backend'))
            .catch((err) => {
                console.log(err)
                const errorRes = err.response.data.error.errors;
                const errorArray = [];

                for(const key of Object.keys(errorRes)) {
                    errorArray.push(errorRes[key].message);
                }
                setErrors(errorArray);
            });
    };
    
    return(
        <>

            <h1 style={{background: "gainsboro"}}>Create Product Form</h1>
            <div style={{height: "350px", width: "500px", border: "2px solid grey", textAlign: "center", margin: "auto", padding: "auto"}}>
                <form onSubmit = {onSubmitHandler}>
                    {
                        errors.length > 0 && errors.map((error, i)=>(
                            <>
                                <p key ={i} className="text-danger">{error}</p>
                            
                            </>
                        ))
                    }
                    <p>
                        <label> Title:  </label>
                        <br/>
                        <input
                            type = "text"
                            onChange = {(e) => setTitle(e.target.value)}
                            value = {title}
                        />
                    </p>
                    <p>
                        <label> Price:  </label>
                        <br/>
                        <input
                            type = "number"
                            step = "0.01"
                            onChange = {(e) => setPrice(e.target.value)}
                            value = {price}
                        />
                    </p>
                    <p>
                        <label> Description:  </label>
                        <br/>
                        <textarea 
                            rows="4"
                            cols="30"
                            type = "text"
                            value = {description}
                            onChange = {(e) => setDescription(e.target.value)}
                        />
                    </p>
                    <div>
                        <button className="btn btn-primary" onClick={notify}>Update!</button>
                        <ToastContainer />
                    </div>
                </form>
            </div>

        </>
    )
};

export default UpdateProductForm;