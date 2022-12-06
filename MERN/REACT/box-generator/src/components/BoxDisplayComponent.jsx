

import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'
// import styles from './Box.module.css';

// eslint-disable-next-line
import {Container} from 'react-bootstrap'

const BoxDisplayComponent = (props) => {
    const { boxArray } = props;
    return (
        <>
            <Container>
                {
                    boxArray.map((box,index) => (
                        <Container key={index} style={{
                            display: "inline-flex",
                            justifyContent: "center",
                            border: "2px solid black", 
                            height: "150px", 
                            width:"150px",
                            margin: "10px",
                            height: box.size,
                            width: box.size,
                            background: box.color}}>
                        </Container>
                    ))
                }
            </Container>
        </>
    );
}

export default BoxDisplayComponent;