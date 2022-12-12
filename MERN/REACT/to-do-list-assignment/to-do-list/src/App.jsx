import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from 'react';
export default App;

function App() {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Single code line below this comment array destructure syntax is equivalent to (basically a shorthand for #1-3):
        1) const newToDoStateArr = useState("");
            ?This will return an array with 2 items.

        2) const newToDo = newToDoStateArr[0];
        3) const setToDo = newToDoStateArr[1];
            ?#2-3 stores the 1st item and the 2nd item.
    */
    const [newToDo, setNewToDo] = useState("")
    /*
    Returns an array with two items. 
    */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    const [toDos, setToDos] = useState([])
    /*
    This is an empty array
    */
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    const handleNewToDoSubmit = (e) => {
        e.preventDefault();
        if (newToDo.length === 0) {
            return;
            /*This will stop us from entering an empty string as a toDo */
        }
        
        /*
        Do not use: "toDos.push(newToDo);"
            This mutates state directly and this doesn't work when you click submit. It bypasses the setToDo
        */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        ! ' Allow the user to add a new task, initially set to not completed'
        */
        const toDoItem = {
            text: newToDo,
            complete: false
        };
            /*Create an object 'toDoItem' with a dictionary with the text and whether or not it's complete */
            
        setToDos([...toDos, toDoItem]);
            /*
            It's best to do this way.  setToDos and pass in a brand new array containing all current toDos plus 1 more.
            */
        setNewToDo("");

    };
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
    !Allow the user to remove a task by clicking the delete button.
 */
    const handleToDoDelete = (deleteToDoWithIndex) => { 
        const filteredToDos = toDos.filter((toDo, index) => {
            return index !== deleteToDoWithIndex;
            /*This will keep the other toDos in the list and only delete the one we want. */
        });
        setToDos(filteredToDos);
    };
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    const handleToggleToDoCompleteStatus = (idx) => {
        const updatedToDos = toDos.map((toDo, index) => {
            if (idx === index) {
                toDo.complete = !toDo.complete;
                //? !toDo.complete reverses the state (complete: false to true)
                /*
                NOTE:
                    !Ninja Bonus: When updating the tasks' state, don't mutate the current task objects or the current task list.
                    to avoid mutating the todo directly, do this next time:
                        const upDatedToDo = { ...toDo, complete: !toDo.complete };
                        return updatedToDo;

                        instead of 'toDo.complete = !toDo.complete;
                 */
            }
            return toDo;
        });
        setToDos(updatedToDos);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    return (
        <>
            <div className='App'>
                <div className='toDoForm'>
                    <h1>To Do List</h1>
                    <form onSubmit={(e) => {handleNewToDoSubmit(e);}}>
                        <input
                            onChange = {(e) =>{
                                setNewToDo(e.target.value);
                            }}
                            type="text"
                            value={newToDo}
                                /*
                                    The value clears the input box after submitting the text entry so it's ready for another to do entry.
                                */
                            placeholder="Enter a To-Do Item"
                        />
                        <div className="toDoFormButton">
                            <button 
                                className="btn btn-primary" 
                                type="submit"
                            >
                                Submit
                            </button>
                        </div>
                    </form>
                </div>
                <div className="toDoListContainer">
                    {
                        toDos.map((toDo, index) => {
                            const toDoClasses = [];

                            /* 
                            ! "Iterate through the existing tasks using the map method."
                            ? const toDoClasses allows us to change the class of the toDo to have 'strike-through/line-through' when we check off the toDo item.
                                ?By default we are having the toDo item to be not lined through until the user does check it off.  Hence the empty array.
                                    'const toDoClasses = []'
                             */
                            if (toDo.complete) {
                                toDoClasses.push("line-through");
                            }
                            return(
                                <div key={index} className='toDoRow'>
                                    {/* a key needs to be added here because each child in a list needs a unique key prop. index is unique.   */}
                                    <ul>
                                        <input 
                                            onChange={(e) => {
                                                handleToggleToDoCompleteStatus(index);
                                            }}
                                            checked={toDo.complete} 
                                            type="checkbox" 
                                            style={{padding: "5px"}}
                                        />
                                        <span className= {toDoClasses.join("")}>  {toDo.text}</span>
                                        <span>
                                            <butt1on className="btn btn-danger" onClick={(e) => { handleToDoDelete(index); }}>Delete</butt1on>
                                        </span>
                                    </ul>
                                </div>
                            );    
                        })
                    }

                </div>
        

            </div>
        </>
    );
}
