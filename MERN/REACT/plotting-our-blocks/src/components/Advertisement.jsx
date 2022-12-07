import {Row} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';

const Advertisement = (props) => {

    return(
        <> 
            <Row style={{
                display: 'flex',
                justifyContent: 'center',
                margin: "auto",
                padding: "auto",
                height: "35%",
                width: "95%",
                border: "2px solid black",
                backgroundColor: "#b4a7d6"
            }}/>  
        </>
    );
}
export default Advertisement;