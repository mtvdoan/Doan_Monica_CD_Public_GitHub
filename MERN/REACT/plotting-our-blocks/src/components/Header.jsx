import { Container} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';

const Header = (props) => {

    return (
        <>
            <Container style={{
                display: 'flex',
                justifyContent: 'center',
                margin: "auto",
                height: "100px",
                width: "900px",
                border: "2px solid black",
                backgroundColor: "#6aa84f"
            }}>
            </Container>  
        </>
    );
}
export default Header;
