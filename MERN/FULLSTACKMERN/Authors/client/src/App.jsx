import './App.css';
import * as React from 'react';
import{BrowserRouter, Routes, Route} from 'react-router-dom';
import NewAuthorFormView from './views/NewAuthorFormView';
import HomePage from './views/HomePage';
import UpdateAuthorForm from './components/UpdateAuthorForm';
import AuthorForm from './components/AuthorForm';
function App() {
  return (
    <>
      <div>
        <BrowserRouter>
          <Routes>
            <Route path='/' element={<HomePage />} />
            <Route element={<AuthorForm/>} path="/authors/create/"/>
            <Route element={<UpdateAuthorForm/>} path="/authors/update/:id"/>
          </Routes>
        </BrowserRouter>
      </div>
    </>
  );
}

export default App;
