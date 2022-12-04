import './App.css';
import {Form, Container, Row} from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import UserForm from './components/UserForm'
function App() {
  return (
    <div className="App" style={{width: '800px'}}>
        <u>
          <h1>Created 2 Versions of User Forms:</h1>
        </u>
        <h3 style={{color: "blue"}}>Version 1</h3>
          <UserForm/>
        <hr/>
        <hr/>
        <h3 style={{color: "red"}}>Version 2</h3>
        <Container md>
          <Form>
            <Row md>
              {/* md here makes it so as you change the horizontal size of the page, the page will adjust itself. */}
              <Form.Group className="input-group-text" controlId="firstName">
                <Form.Label className="label"> First Name </Form.Label>
                <Form.Control type="text" placeholder="John" />
              </Form.Group>
            </Row>

            <Row md>
              {/* md here makes it so as you change the horizontal size of the page, the page will adjust itself. */}
              <Form.Group className="input-group-text" controlId="lastName">
                <Form.Label className="label"> Last Name </Form.Label>
                <Form.Control type="text" placeholder="Smit" />
              </Form.Group>
            </Row>

            <Row md>
              {/* md here makes it so as you change the horizontal size of the page, the page will adjust itself. */}
              <Form.Group className="input-group-text" controlId="email">
                <Form.Label className="label"> Last Name </Form.Label>
                <Form.Control type="email" placeholder="johnsmith@email.com" />
              </Form.Group>
            </Row>

            <Row md>
              {/* md here makes it so as you change the horizontal size of the page, the page will adjust itself. */}
              <Form.Group className="input-group-text" controlId="Password">
                <Form.Label className="label"> Password </Form.Label>
                <Form.Control type="password" placeholder="" />
              </Form.Group>
            </Row>
          </Form>
      </Container>
    </div>
  );
}

export default App;
