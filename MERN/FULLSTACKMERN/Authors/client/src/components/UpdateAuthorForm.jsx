import React, {useState} from 'react';
import {useNavigate, Link, useParams} from 'react-router-dom';
import axios from 'axios';
import { 
    Typography, 
    AppBar,
    Card,
    CardActions,
    CardContent,
    CardMedia,
    CssBaseline, 
    Grid, 
    Toolbar,
    Container,
    Button,
    TableContainer,
    Table,
    TableHead,
    TableBody,
    TableRow, 
    TableCell,
    Paper,
    Box,
    TextField, 
    Input, 
    FormControl,
    FormHelperText,
    InputLabel,
    FormLabel
} from '@mui/material/';
import AutoStoriesIcon from '@mui/icons-material/AutoStories';
import useStyles from '../styles';
import { useEffect } from 'react';


const UpdateAuthorForm = (props) => {
    const {id} = useParams();
    const navigate = useNavigate();
    const classes = useStyles();
    const ariaLabel = { 'aria-label': 'description' };
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
                setAuthorNotFoundError("Author with input ID not found");
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
                        <Typography align="center" component="span" variant="h5" sx={{letterSpacing: 6, m: 3}}>Add New Author</Typography>
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
                        errors.length > 0 && errors.map((error, i)=>(
                            <>
                                <p key ={i} className="text-danger">{error}</p>
                            
                            </>
                        ))
                    }
                                                <div style={{margin: '10px'}}>
                                                    <input 
                                                        style={{margin: "10px"}} 
                                                        type="text" 
                                                        id="firstName" 
                                                        label="First Name" 
                                                        variant="outlined" 
                                                        name="firstName"
                                                        value={firstName}
                                                        onChange = {(e) => setFirstName(e.target.value)}
                                                        />
                                                    <input
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