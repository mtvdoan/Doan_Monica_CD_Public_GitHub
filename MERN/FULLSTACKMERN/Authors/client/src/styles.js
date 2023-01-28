import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
    container: {
        backgroundColor: theme.palette.background.paper,
        padding: theme.spacing(8,0,6)
    },
    icon:{
        marginRight: "20px"
    },
    button:{
        marginTop: "40px"
    },
    cardGrid:  {
        paddingTop: '20 px 0'
    },
    card: {
        height: '100%',
        display: 'flex',
        flexDirection: 'column'
    },
    cardMedia:  {
        paddingTop: '56.25%' // 16:9

    },
    cardContent:  {
        flexGrow: 1
    },
    footer:{
        backgroundColor: theme.palette.background.pepper,
        padding: '50px 0'
    },
    tableContainer: {
        width: '500px',
        margin: 'auto',
        marginTop: '50px'
    },
    inputField: {
        padding: "10px",
    },
}));
export default useStyles;