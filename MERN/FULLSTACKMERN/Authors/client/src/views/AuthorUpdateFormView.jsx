import React, {useState} from 'react';
import axios from 'axios';
import UpdateAuthorForm from '../components/UpdateAuthorForm';
import AllAuthors from '../components/AllAuthors';
import { makeStyles } from "@material-ui/core/styles";

import {
CssBaseline,
AppBar,
Toolbar,
Typography,

} from '@mui/material'
import styles from '../styles'
import AutoStoriesIcon from '@mui/icons-material/AutoStories';

const AuthorUpdateFormView = (props) =>{
    const classes = makeStyles();
    const [authors, setAuthors] = useState([]);
    return(
        <>
            <div>
                <UpdateAuthorForm authors={authors} setAuthors={setAuthors}/>
            </div>
        </>
    )
}
export default AuthorUpdateFormView;