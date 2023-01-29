import React, {useState} from 'react';
import {useNavigate, Link} from 'react-router-dom';
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


const AuthorForm = (props) => {
    const navigate = useNavigate();
    const classes = useStyles();
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [errors, setErrors] = useState([]);

    const onSubmitHandler = (e) => {
        e.preventDefault();
        axios
            .post("http://localhost:8000/api/authors/create/", {
                firstName,
                lastName
            })
            .then((res) =>{
                console.log(res)
                alert("New author added!")
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
    }
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
                                                    <Typography key ={i} color="error">{error}</Typography>                                         
                                                </>
                                            ))
                                        }                                                
                                        <div style={{margin: '10px'}}>
                                            <TextField 
                                                style={{margin: "10px"}} 
                                                type="text" 
                                                className="form-control"
                                                id="firstName" 
                                                placeholder="First Name" 
                                                variant="outlined" 
                                                name="firstName"
                                                onChange = {(e) => setFirstName(e.target.value)}
                                                />
                                            <TextField 
                                                style={{fontStyle: "red"}}
                                                type="text" 
                                                id="lastName" 
                                                className="form-control"
                                                placeholder='Last Name'
                                                variant="outlined" 
                                                name="lastName"
                                                onChange = {(e) => setLastName(e.target.value)}
                                            />
                                        </div>
                                        <div>
                                                <Button variant='contained' type="submit" color="primary">Add Author</Button>
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
export default AuthorForm;