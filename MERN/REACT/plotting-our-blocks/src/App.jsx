
import './App.css';
import React from 'react';
import { Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './components/Header'
import Navigation from './components/Navigation'
import Main from './components/Main'
import SubContent from './components/SubContent'
import Advertisement from './components/Advertisement';
// import Advertisement from './components/Advertisement.jsx'
function App() {
  return (
    <>
 
      <Container className='App'>
        <Header/>
        <Container className='container2'>
          <Navigation/>
            <Main>
              <SubContent/>
              <SubContent/>
              <SubContent/>
              <Advertisement/>
            </Main>
            

              
              


        </Container>
          
      </Container>



    </>
  );
}

export default App;
