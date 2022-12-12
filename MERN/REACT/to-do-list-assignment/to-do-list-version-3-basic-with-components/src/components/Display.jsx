import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';


/*
?Learn Platform Objectives:
!Deconstruct props object
!Delete functionality
!Simple marked complete (no ninja) functionality
!Function to handle style change when the checkbox is clicked.
*/

const Display = (props) => {
    /* 
    !Deconstruct props object
     */
    const {toDoList, setToDoList} = props;
////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    !Function to handle style change when the checkbox is clicked
    */
    const handleCompleted = (toDo) => {
        /*
            Code below (commented out):
            This will change false to true when the toDo is completed 
            This approach, although it works, is mutating the data (getter) in state which is considered bad practice, but is accepted in the industry bc of the code maintainability and simplicity.
            Also, because the setter can cause a rerender.
            Code:
                    toDo.markedDelete = !toDo.markedDelete;
                    let updateToDos = [...toDoList];
                    setToDoList(updateToDos);
                    
        */

        /*Code below is the better way to do this:
        Ninja Bonus: When updating the tasks' state do NOT mutate task objects or the current task list
        */
        let updatedToDos = toDoList.map((toDoItem) => {
            if(toDoItem === toDo){
                let updatedItem = {...toDoItem};
                updatedItem.markedDelete = !toDoItem.markedDelete;
                return updatedItem;
            }    
            else{
                return toDoItem;
            }
        });
        setToDoList(updatedToDos);
        localStorage.setItem("toDos", JSON.stringify(updatedToDos ));
    };
////////////////////////////////////////////////////////////////////////////////////////////////
  /*
    !A function to determine whether a checkbox will be checked or not.
    !Arg: boolean; This will be whether or not a todo in state has been marked complete. 
  */
    const styled = (markedDelete) =>{
        if(markedDelete === true){
            return "completed";
        }
        else{
            return "notCompleted";
        }
    };
////////////////////////////////////////////////////////////////////////////////////////////////
  /*
    !Function to delete a todo from state.
    !Arg: id of todo
  */
    const deleteButton = (idOfToDoItemToDelete) => {
        /*Call state variable setter function setToDoList w/: */
        const filteredToDos = toDoList.filter((toDo, index) => {
            return toDo.id !== idOfToDoItemToDelete;
        });
        setToDoList(filteredToDos);
        localStorage.setItem('toDos', JSON.stringify(filteredToDos));
            /*The .filter() function returns a new list with the elements that pass the condition (condition that evaulates to true) inside the filter callback function */
            
                /*
                This condition will return true if the todo's id is not the same as the id of the to do item that user chose to delete (see code below under return), and false if otherwise 
                
                If this condition evaluates to true, it will be added to the list that setToDoList is using to set the new value.
                */

                 /*Note that each toDo has a unique id/index.  They can have the same content.  This is why it's best to delete by id/index */
    };
    return(
        <div>
            {/* 
            Although index is available, it is not needed in this particular scenario.
            Best practice is to use a unique id in the object.
            Note to self to check out the key usage documentation for reactjs.
             */}

            {
                toDoList.map((toDo, index)=>(
                    
                    // -Class name will be whatever our styled function returns - this will be a string of either "completed" or "notCompleted" depending on whether this individual
                    
                    // -todo (whichever todo object is currently being iterated over) markedDelete field is true or false.
                    

                    <div className={styled(toDo.markedDelete)} key={toDo.id}>
                        {""}
                        {/* The styled function above takes the boolean value tied to the toDo item we want to delete key in the current iterated toDo object */}

                            {/* Display toDo content 
                                The input below is a checkbox.  When it is clicked, it will trigger the handleCompleted function, passing this function the entire toDo object.
                            
                            */}

                            <input
                                type="checkbox"
                                onChange={(e) => handleCompleted(toDo)}
                            />
                            <div className="toDoListDisplay">{toDo.content}</div>

                            {/* When this button is clicked, call deleteButton function with toDo id */}
                            <button 
                                className="btn btn-outline-danger btn-sm"
                                onClick = {(e) => deleteButton(toDo.id)}
                            >
                                Delete
                            </button>
                    </div>
                ))}
                {/* This allows us to see the specific object in the array like arr[i] */}
        </div>
    );
};

export default Display;