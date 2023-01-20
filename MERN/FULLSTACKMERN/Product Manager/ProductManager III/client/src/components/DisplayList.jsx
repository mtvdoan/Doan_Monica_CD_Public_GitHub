import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

const DisplayList = (props) => {

    const [productList, setProductList] = useState([]);

    const deleteProduct = (productId) => {
        axios
            // .delete(`http://localhost:8000/api/products/${productId}`) works the same
            .delete("http://localhost:8000/api/products/" + productId)
            .then(() => {
                console.log('Successfully deleted product from backend')
                removeFromDom(productId)
            })
            .catch(err => console.log("something went wrong trying to delete product", err))
    };

    const removeFromDom = (productId) => {
        setProductList(productList.filter(p => p._id !== productId))
    };

    useEffect(() => {
        axios
            .get("http://localhost:8000/api/products/")
            .then((response) => setProductList(response.data))
            .catch((err)=>console.log(err))
    }, []);

    return (
        <>
            <p className="font-weight-light" style={{background: "lavender", fontSize: "24px", fontFamily:"monospace" }}>ALL PRODUCTS</p>
            <div>
                {
                    productList.length > 0 && productList.map((product, index) => (
                        <>
                            <p style={{ fontSize: "18px"}}>
                                <Link to = {"/products/" + product._id}>
                                    <h1 style={{fontSize: "32px"}}>{product.title}</h1>
                                </Link>
                                
                                <Link style={{margin: "5px"}} to = {"/products/update/" + product._id}>
                                    <button type='button' className='btn btn-info btn-sm'>Update</button>
                                </Link>
                                <button 
                                    type='button' 
                                    className='btn btn-danger btn-sm'
                                    onClick = {() => deleteProduct(product._id)}
                                >
                                    Delete
                                </button>
                            </p>
                        </>
                    ))
                }
            </div>
        </>
    )
};
export default DisplayList;