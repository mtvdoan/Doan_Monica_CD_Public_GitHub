import React, {useEffect, useState} from 'react';
import {useNavigate} from 'react-router-dom';
import {
CssBaseline,
AppBar,
Toolbar,
Typography,
Card,
CardContent,
Box, 
Button
} from '@mui/material/'

import AllAuthors from '../components/AllAuthors';
import useStyles from '../styles';

import AutoStoriesIcon from '@mui/icons-material/AutoStories';

const HomePage = (props) => {
    const [authors, setAuthors] = useState([]);
    const navigate = useNavigate();
    const classes = useStyles();
    const ariaLabel = { 'aria-label': 'description' };
    return(
        <>
            <CssBaseline/>
            <AppBar position="relative">
                <Toolbar style={{display: 'inline-flex', justifyContent: 'space-between'}}>
                    <Typography align="center" component="span" variant="h5" sx={{letterSpacing: 6, m: 3}}> Home Page</Typography>
                    <div>
                        <AutoStoriesIcon className={classes.icon}/>
                        <Typography component="span" sx={{letterSpacing: 6, m: 1}}> Authors</Typography>
                    </div>
                </Toolbar>
            </AppBar>
            <main style={{marginTop: "50px", padding: "10px"}} align="center">
                <Card variant="outlined" align="center" style={{border: "2px solid black", width: "500px", margin: "auto"}}>
                    <Typography variant="h5">Favorite Authors:</Typography>
                    <CardContent>
                        <AllAuthors authors={authors} setAuthors={setAuthors}/>
                    </CardContent>
                </Card>
                <Button style={{margin: "10px"}} variant="contained" color="primary" href="/authors/create/">Add New Author</Button>
            </main>
        </>
    )
}
export default HomePage;