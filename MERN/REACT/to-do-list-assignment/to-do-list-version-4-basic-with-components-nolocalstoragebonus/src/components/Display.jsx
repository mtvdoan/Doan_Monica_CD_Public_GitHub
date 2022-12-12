import React, { useState } from "react";

const Display = (props) => {
    //Deconstruct props object
    const { todoList, setTodoList } = props;
    
    //Function to handle style change when the checkbox is clicked
    const handleCompleted = (todo) => {
        // non-ninja bonus: This approach, although it works, is mutating the data (getter) in state which is considered a bad practice,
        // but is accepted in the industry because of the code maintainability and simplicity.
        // Also, because the setter can cause a rerender.
        
        todo.markedDelete = !todo.markedDelete;
        setTodoList([...todoList]);
    };
    
    /*
    A function to determine whether a checkbox will be checked or not.
    Arg: boolean; This will be whether or not a todo in state has been marked complete. 
    */
    
    const styled = (markedDelete) => {
        if (markedDelete === true) {
            return "completed";
        } else {
            return "notCompleted";
        }
    };
    
    /*
    Function to delete a todo from state.
    Arg: id of todo
    */
    const deleteButton = (idFromBelow) => {
        // call our state variable setter function setToDoList with...
        setTodoList(
            // the .filter() function returns a new list with the elemenets that pass the condition (condition evaluates to true) inside the filter callback function
            todoList.filter((todo, index) => {
                // this condition will return true if the todo's id is not the same as the idFromBelow argument (iterated todo's id), and false is otherwise.
                // If this condition evaluates to true, it will be added to the list that setToDoList is using to set the new value
                return todo.id !== idFromBelow;
            })
            );
        };
        return (
            <div>
            {/* Although index is available, it is not needed in this particular scenario. */}
            {/* Best practice is to use a unique id in the object.  */}
            {/* See the documentation for more information regarding key usage:
        https://reactjs.org/docs/lists-and-keys.html#keys */}
        {todoList.map((todo, index) => (
            // Class name will be whatever our styled function returns - this will be a string of either "completed" or "notCompleted" depending on whether this individual
            // todo (whichever todo object is currently being iterated over) markedDelete field is true or false.
            <div className={styled(todo.markedDelete)} key={todo.id}>
            {" "}
            {/* the styled function above takes in the boolean value tied to the markedDelete key in the currently iterated todo object */}
            <p>{todo.content}</p> {/* display todo content */}
            {/* 
            This input below is a checkbox. When it is changed (clicked), it will trigger the handleCompleted function, passing this function the entire todo object.
        */}
        <input type="checkbox" onChange={() => handleCompleted(todo)} />
        {/* When this button is clcked, call deleteButton function with todo id */}
        <button onClick={() => deleteButton(todo.id)}>Delete</button>{" "}
        </div>
        ))}
        </div>
        );
    };
    
    export default Display;