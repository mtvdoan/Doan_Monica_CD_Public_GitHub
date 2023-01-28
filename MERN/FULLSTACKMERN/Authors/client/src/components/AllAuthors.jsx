import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom'
import {
    Box,
    Typography,
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow,
Button
} from '@mui/material'

const AllAuthors = (props) => {
const [authors, setAuthors] = useState([]);
    
    useEffect(()=>{
        axios.get("http://localhost:8000/api/authors/")
        .then((res)=>{
        console.log(res.data);
            setAuthors(res.data);
	})
        .catch((err)=>{
            console.log(err);
        })
    }, [])

    const handleDeleteAuthor = (authorId) => {
        axios
            .delete(`http://localhost:8000/api/authors/delete/${authorId}`)
            .then((response) => {
                console.log("success deleting author")
                alert("Deleted author")
                console.log(response)
                const filteredAuthors = authors.filter((author) => {
                return author._id !== authorId;
                });
                setAuthors(filteredAuthors);
            })
            .catch((err) => {
                console.log("error deleting author", err.response);
            });
    };
    
    return (
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>Author's Name</TableCell>
                    <TableCell>Actions</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
            {
                authors.map((author, index)=>{
                return (
                    <TableRow sx={{ '&:last-child td, &:last-child th': { border: 0 } }} key={author._id} align="center">
                        <TableCell variant='h6'>{author.firstName} {author.lastName}: &nbsp; &nbsp;</TableCell>
                        <TableCell>
                            <Button href={`/authors/update/${author._id}/`} color="info" variant="contained">Edit</Button>
                            <Button
                                onClick={() => handleDeleteAuthor(author._id)}
                                color="error"
                                variant='contained'
                            >
                                Delete
                            </Button>
                        </TableCell>
                    </TableRow>                    
                )})
            }
            </TableBody>
        </Table>
    )
};
export default AllAuthors;