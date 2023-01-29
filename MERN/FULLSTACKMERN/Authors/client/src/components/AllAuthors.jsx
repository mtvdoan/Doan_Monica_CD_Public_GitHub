import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow,
    Button
} from '@mui/material';
import DeleteAuthor from './DeleteAuthor';

const AllAuthors = (props) => {
    const [authors, setAuthors] = useState([]);

    //BONUS: Sort the authors alphabetically.
    authors.sort((a, b) => {
        const lastNameA = a.lastName.toLowerCase();
        const lastNameB = b.lastName.toLowerCase();
        if (lastNameA < lastNameB) return -1;
        if (lastNameA > lastNameB) return 1;
        return 0;
    });
    
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
    const removeFromDom = authorId => {
        setAuthors(authors.filter(author => author._id !== authorId))
    }

    return (
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>
                        <b>
                            Author's Name
                        </b>
                    </TableCell>
                    <TableCell>
                        <b>
                            Actions
                        </b>
                    </TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
            {
                authors.map((author, index)=>{
                return (
                    <TableRow sx={{ '&:last-child td, &:last-child th': { border: 0 } }} key={author._id} align="center">
                        <TableCell variant='h6'>{author.firstName} {author.lastName}: &nbsp; &nbsp;</TableCell>
                        <TableCell>
                            <Button href={`/authors/update/${author._id}/`} color="info" variant="contained">Update</Button>
                            <DeleteAuthor authorId={author._id} successCallback={()=>removeFromDom(author._id)}/>
                        </TableCell>
                    </TableRow>                    
                )})
            }
            </TableBody>
        </Table>
    )
};
export default AllAuthors;