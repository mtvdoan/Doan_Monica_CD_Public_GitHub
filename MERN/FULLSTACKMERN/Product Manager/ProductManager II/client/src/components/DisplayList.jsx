import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

const DisplayList = (props) => {
    const [productList, setProductList] = useState([]);
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
                                    <h1 style={{fontSize: "18px"}}>{product.title}</h1>
                                </Link>
                            </p>
                        </>
                    ))
                }

            </div>
        </>
    )
};
export default DisplayList;