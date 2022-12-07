import {Container} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';

const SubContent = (props) => {

    return(
        <>
            <Container style={{
                display: 'flex',             
                justifyContent: 'center',
                margin: "auto",
                padding: "auto",
                height: "60%",
                width: "31%",
                border: "2px solid black",
                backgroundColor: "#ffd966"
            }}/>
        </>
    );
}
export default SubContent;