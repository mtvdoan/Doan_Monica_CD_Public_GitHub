import React, {useState} from 'react';
import {useNavigate, Link, useParams} from 'react-router-dom';
import axios from 'axios';
import { 
    Typography, 
    AppBar,
    CssBaseline, 
    Toolbar,
    Button,
    TableContainer,
    Table,
    TableBody,
    TableRow, 
    TableCell,
    Paper,
    TextField, 
} from '@mui/material/';
import AutoStoriesIcon from '@mui/icons-material/AutoStories';
import useStyles from '../styles';
import { useEffect } from 'react';


const UpdateAuthorForm = (props) => {
    const {id} = useParams();
    const navigate = useNavigate();
    const classes = useStyles();
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const[errors, setErrors] = useState({});
    const [authorNotFoundError, setAuthorNotFoundError] = useState("");
    console.log(id);
    useEffect(() => {
        axios
            .get(`http://localhost:8000/api/authors/${id}`)
            .then((res) => {
                console.log(res.data);
                setFirstName(res.data.firstName)
                setLastName(res.data.lastName)
            })
            .catch((err) => {
                console.log(err.response);

                //BONUS: If someone tries to navigate to the edit page with an unrecognized id, display an error message. For example, "We're sorry, but we could not find the author you are looking for. Would you like to add an author to our database?" Then, provide a link to take them to the form to create an author. 
                setAuthorNotFoundError("Uh Oh! Author with input ID not found");
            });
    }, []);

    const onSubmitHandler = (e) => {
        e.preventDefault();
        axios
            .put(`http://localhost:8000/api/authors/update/${id}`, {
                firstName,
                lastName
            })
            .then((res) =>{
                console.log(res);
                alert("Successfully updated author!")
                navigate("/");
            })
            .catch((err) => {
                console.log(err)
                const errorRes = err.response.data.error.errors;
                const errorArray = [];

                for(const key of Object.keys(errorRes)) {
                    errorArray.push(errorRes[key].message);
                }
                setErrors(errorArray);
            });
    };

    return(
        <>
            <CssBaseline/>
            <AppBar position="relative">
                <Toolbar style={{display: 'inline-flex', justifyContent: 'space-between'}}>
                    <Typography align="center" component="span" variant="h5" sx={{letterSpacing: 6, m: 3}}>Update Author</Typography>
                    <div>
                        <AutoStoriesIcon className={classes.icon}/>
                        <Typography component="span" sx={{letterSpacing: 6, m: 1}}> Authors</Typography>
                    </div>
                </Toolbar>
            </AppBar>
            <main align="center">
                <TableContainer className={classes.tableContainer} component={Paper} sx={{maxWidth: '500px', margin: 'auto', marginTop: "50px"}}>
                    <Table aria-label="simple table" stickyHeader>
                            <TableBody>
                                <TableRow>
                                    <TableCell align='center'>
                                        <form onSubmit={onSubmitHandler}>
                                        {
                                            authorNotFoundError ? (
                                                <Typography variant="h6" color="error">
                                                    {authorNotFoundError} 
                                                    <Button variant="contained" color="success" href="/authors/create/">Click here to add author</Button>
                                                </Typography>
                                            ) : null
                                        }

                                        {
                                        errors.length > 0 && errors.map((error, i)=>(
                                                <>
                                                    <Typography key ={i} color="error">{error}</Typography>
                                                
                                                </>
                                            ))
                                        }
                                            <div style={{margin: '10px'}}>
                                                <TextField 
                                                    style={{margin: "10px"}} 
                                                    type="text" 
                                                    id="firstName" 
                                                    label="First Name" 
                                                    variant="outlined" 
                                                    name="firstName"
                                                    value={firstName}
                                                    onChange = {(e) => setFirstName(e.target.value)}
                                                    />
                                                <TextField
                                                    type="text" 
                                                    value={lastName}
                                                    id="lastName" 
                                                    label="Last Name" 
                                                    variant="outlined" 
                                                    name="lastName"
                                                    onChange = {(e) => setLastName(e.target.value)}
                                                />
                                            </div>
                                            <div>
                                                <Button variant='contained' type="submit" color="primary">Update Author</Button>
                                            </div>
                                        </form>
                                    </TableCell>
                                </TableRow>
                        </TableBody>
                    </Table>
                </TableContainer>
                <Button href="/" variant='contained' type="submit" color="error" style={{margin: "10px"}}>
                    HOME
                </Button>
            </main>
        </>
    );
}
export default UpdateAuthorForm;