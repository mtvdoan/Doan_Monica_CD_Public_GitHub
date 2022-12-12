import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useEffect, useState} from 'react';
import Form from './components/Form';
import Display from './components/Display';

function App() {
    /*
        define our array state variable here so that the Form component and the Display component can both access this variable.
        We *** LIFT STATE *** when a state variable is shared across multiple components.
    */
    const [toDoList, setToDoList] = useState([]);
        /*Getter and Setter */
    
    /*SENSEI BONUS: Persist the toDo list on page refreshes. Hint, consider combining the browser's localStorage with the useEffect hook. still need to work on this...
    Read more on javascript localStorage...to understand...
     */

   const toDosLocalStorage = (JSON.parse(localStorage.getItem("toDos")));
    useEffect(() => {
        if(toDosLocalStorage === null) {
            setToDoList([]);
        }
        else{
            setToDoList(JSON.parse(localStorage.getItem("toDos")));
        }
        
    //eslint-disable-next-line
    },[]);

    return (
        <div className="App">
            {/* Pass props */}
            <h1>To Do List (Basic with Components)</h1>
            <Form
                toDoList={toDoList} 
                setToDoList = {setToDoList}
            />

            {/* Pass props */}
            <Display
                toDoList={toDoList}
                setToDoList ={setToDoList}
            />
        </div>
    );
}

export default App;
