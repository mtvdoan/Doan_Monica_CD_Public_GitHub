import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';

const navigationStyle = {
        height: "600px",
        width: "25%",
        margin: "5px",
        padding: "5px",
        display: "flex",
        flexDirection: "center",
        border: "2px solid black",
        backgroundColor: "#6fa8dc"
};
const Navigation = (props) => {
    return (
        <>
        <div style={navigationStyle}></div>
        </>
    );
}
export default Navigation;
