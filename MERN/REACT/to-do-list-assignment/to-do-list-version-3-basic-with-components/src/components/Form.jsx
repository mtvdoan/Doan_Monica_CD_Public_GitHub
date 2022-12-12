import React, {useState} from "react";

const Form = (props) => {


/*
?Learn Platform Objectives
!State for toDoText
!Deconstruct props object
*/
    /*State for toDoText */
    const [toDoText, setToDoText] = useState("");

    /*Deconstruct props object */
    const {toDoList, setToDoList} = props;

    /*Handler to be called when form is submitted */
    const submitHandler = (e) => {
        e.preventDefault();
        /*We will call the setter function. Inside, we will set our new toDoList Array state variables with...
            1. a copy of all current elements in toDoList
            2. the toDo that the user wants to do to the toDoList when they click the submit button
         */
        /*This stops us from adding empty strings to the to do list. */
        const newToDo = 
        {
            content: toDoText,
            markedDelete: false,
            /*markedDelete will be initialized in every toDo as false. A unique id for each toDo item is needed.  We can use generate a random unique number using a tool from javascript */

            id: Math.floor(Math.random() * 1000000).toString(),
                /*This is just to give a unique id to each toDo item.  This is because there may be two to-do items that are the same, but different id's */
        };

        setToDoList([...toDoList, newToDo]);
        /*
        -shallow copy of toDoList --> this will copy all the values inside toDoList into the array being set. 
        -build new toDo object and add to end of array to be set (...toDoList)
        */

        // {
        //     content: toDoText,
        //     markedDelete: false,
        //     /*markedDelete will be initialized in every toDo as false. A unique id for each toDo item is needed.  We can use generate a random unique number using a tool from javascript */

        //     id: Math.floor(Math.random() * 1000000).toString(),
        //         /*This is just to give a unique id to each toDo item.  This is because there may be two to-do items that are the same, but different id's */
        // },
        /////////////////////////////////////////////////////////////////
        localStorage.setItem("toDos", JSON.stringify([...toDoList, newToDo]));
        setToDoText("");
    };
    
    return(
        <div className="addNewToDo">
            <form onSubmit={submitHandler}>

                {/* This will be the input where toDoText is added */}
                <input
                    value={toDoText}
                        /*The line above clears the input box after you click 'Add' */
                    onChange={(e) =>setToDoText(e.target.value)}
                    type="text"
                />
                <button>Add</button>
            </form>
        </div>
    );
};

export default Form;