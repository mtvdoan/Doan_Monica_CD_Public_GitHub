import React, { useState } from "react";
import "./App.css";
import Form from "./components/Form";
import Display from "./components/Display";

function App() {
  // define our array state variable here so that the Form component and the Display component can both access this variable.
  // We *** LIFT STATE *** when a state variable is shared across multiple components.
  const [todoList, setTodoList] = useState([]);

  return (
    <div className="App">
      {/* pass props */}
      <Form todoList={todoList} setTodoList={setTodoList} />
      {/* pass props */}
      <Display todoList={todoList} setTodoList={setTodoList} />
    </div>
  );
}

export default App;