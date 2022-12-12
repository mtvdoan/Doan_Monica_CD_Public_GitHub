import React, { useState } from "react";

const Form = (props) => {
    //state for todoText
    const [todoText, setTodoText] = useState("");
    
    //deconstruct props object
    
    const { todoList, setTodoList } = props;
    
    // handler to be called when form is submitted.
    const submitHandler = (e) => {
        e.preventDefault();
        if(todoText.length === 0){
            return;
        }
        // We will call the setter function. Inside, we will set our new todoList Array state variables with...
        //    1. a copy of all the CURRENT elements in todoList
        //    2. the todo that the user want to do to the todo list when they click submit button
      
        setTodoList([
            // shallow copy of todoList --> this will simply copy all the values inside todoList into this array being set
            ...todoList,
            // build new todo object and add to end of array to be set
            {
                content: todoText,
                markedDelete: false, // markedDelete will be initialized in every todo as false
                //We need a unique id for each to item. This is a common javascript way to generate a random, unique number.
                id: Math.floor(Math.random() * 100000000).toString(),
            },
        ]);
        
        setTodoText("");
    };
    
    return (
        <div>
            <h1>To-Do List (No LocalStorage Bonus)</h1>
            <form onSubmit={submitHandler}>
                {/* This will be the input where todoText is added.  */}
                <input
                    value={todoText}
                    onChange={(e) => setTodoText(e.target.value)}
                    type="text"
                />
                <button>Add</button>
            </form>
        </div>
        );
    };
    
    export default Form;