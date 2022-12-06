import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from 'react';
import { Container} from 'react-bootstrap'
import BoxDisplayComponent from './components/BoxDisplayComponent';
import BoxFormComponent from './components/BoxFormComponent';

function App() {
  const [ boxArray, setBoxArray] = useState([]);

  return (
    <>
    
      <Container className="App">
        <Container>
          <BoxFormComponent boxArray={ boxArray } setBoxArray={ setBoxArray } />
          <BoxDisplayComponent boxArray={ boxArray } />
        </Container>
      </Container>
    </>
  );
}

export default App;