import React, {useState} from 'react'
import axios from 'axios';
import {Button} from '@mui/material'

const DeleteAuthor = (props) => {
    const { authorId, successCallback } = props;
    const [ authors, setAuthors ] = useState([]);
    const handleDeleteAuthor = (e) => {
        axios
            .delete("http://localhost:8000/api/authors/delete/" + authorId)
            .then((response) => {
                successCallback();
                console.log("success deleting author")
                alert("Deleted author")
                console.log(response)
                const filteredAuthors = authors.filter((author) => {
                return author._id !== id;
                });
                setAuthors(filteredAuthors);
            })
            .catch((err) => {
                console.log("error deleting author", err.response);
            });
    };
    
    return (
        <>
            <Button
                color="error"
                variant='contained'
                style={{margin: "10px"}}
                onClick={handleDeleteAuthor}
            >
                Delete
            </Button>
        
        </>
    )
}
export default DeleteAuthor;