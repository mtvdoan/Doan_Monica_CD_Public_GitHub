import 'bootstrap/dist/css/bootstrap.min.css';

import React, { useState } from 'react';
import {Form, Button, Container, Row, Col} from 'react-bootstrap';
import styles from './Box.module.css';
const BoxFormComponent = (props) => {
    // hold state of color 
    const {boxArray, setBoxArray} = props;
    const[color,setColor] = useState("");
    const[size, setSize] = useState("");
    const submitHandler = (event) => {
        // preventing page load 
        event.preventDefault();
        // props.onNewBox( color )
        // console.log("box color chosen")
        setBoxArray([
        ...boxArray, 
        {
            color: color,
            size: size + "px"
        }
    ]);
    }

    return (
        <>
            <Container style={{marginTop: "150px"}}>
                <Form onSubmit={ submitHandler }>
                    <Row>
                        <Col>
                            <Form.Group as = {Row} className="mb-3">
                                <Form.Label column="lg" lg={2}>Color:</Form.Label>
                                <Col>
                                <Form.Control 
                                    size="lg"
                                    label="Color:"
                                    type="text" 
                                    name="color" 
                                    placeholder="Enter a Color"
                                    onChange={ (event) => setColor( event.target.value )
                                    }/>    
                                </Col>
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <Row>
                                <Form.Group as={Row} className="mb-3">
                                    <Form.Label column="lg">Enter a Size:</Form.Label>
                                    <Col>
                                        <Form.Control
                                            type="text"
                                            name="size"
                                            size="lg"
                                            placeholder='(Please enter a value:  (Example: 100 = 100px x 100px)'
                                            value={size}
                                            onChange={ (event) => setSize( event.target.value)}
                                        />
                                    </Col>
                                    <Col>
                                        <Button type="submit" variant='primary'>Add</Button>
                                    </Col>
                                </Form.Group>
                                <Form.Text id='pickASize' muted>Example: '100' is 100x100 in pixels</Form.Text>
                            </Row>
                        </Col>
                    </Row>
            </Form>
            </Container>
        </>
    )

}

export default BoxFormComponent;