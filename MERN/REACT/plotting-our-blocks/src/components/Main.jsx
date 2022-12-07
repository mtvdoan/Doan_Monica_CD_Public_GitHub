import { Row } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';

const mainStyle = {
        height: "750px",
        width: "75%",
        margin: "5px",
        padding: "5px",
        display: "flex",
        justifyContent: "center",
        border: "2px solid black",
        backgroundColor: "#e06666"
};

const Main = (props) => {

    return (
        <>
            <Row style={mainStyle}>
                {props.children}
            </Row>
        </>

    );
}
export default Main;
