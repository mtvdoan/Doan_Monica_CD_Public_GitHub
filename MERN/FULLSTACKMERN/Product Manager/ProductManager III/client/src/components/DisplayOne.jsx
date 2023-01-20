import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {useParams} from 'react-router-dom';

const DisplayOne = (props) => {
    const {id} = useParams();
    const[product, setProduct] = useState({});

    useEffect(() => {
        axios
            .get("http://localhost:8000/api/products/" + id)
            .then(res => setProduct(res.data))
            .catch(err => console.error(err))
    }, [])
    
    return(
        <>
            <div className="border border-dark p-3">
                <h1 style={{background: "lavender"}}>Product Details</h1>
                <hr/>
                <h2 style={{background: "Thistle", width: "auto"}}>{product.title}</h2>
                <p style={{textAlign: "left", padding: "10px"}}>
                    <span style={{fontWeight: "bold"}}>Price:   </span>
                    <span style={{background: "cornsilk"}}>{product.price}</span>
                </p>
                <p style={{textAlign: "center", padding: "10px"}}>
                    <span style={{fontWeight: "bold"}}>Description:   </span>
                    <span style={{background:"lightsteelblue"}}>{product.description}</span>
                </p>
            </div>
        </>
    )
};
export default DisplayOne;