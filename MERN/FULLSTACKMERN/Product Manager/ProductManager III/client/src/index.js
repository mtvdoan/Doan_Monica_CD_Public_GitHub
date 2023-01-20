import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
// To add Bootstrap
  // npm install react bootstrap bootstrap
  // add below to index.js
import "bootstrap/dist/css/bootstrap.min.css";

// To add Toastify
//$ npm install --save react-toastify
// $ yarn add react-toastify
//https://fkhadra.github.io/react-toastify/introduction/

//TOASTIFY GIST:
  // import React from 'react';
  // import { ToastContainer, toast } from 'react-toastify';

  // import 'react-toastify/dist/ReactToastify.css';
  // // minified version is also included
  // // import 'react-toastify/dist/ReactToastify.min.css';

  // function App(){
  //   const notify = () => toast("Wow so easy !");

  //   return (
  //     <div>
  //       <button onClick={notify}>Notify !</button>
  //       <ToastContainer />
  //     </div>
  //   );
  // }
import 'react-toastify/dist/ReactToastify.css';



const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
