import React from 'react'
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
    Paper
} from '@material-ui/core';
import AutoStoriesIcon from '@mui/icons-material/AutoStories';
import useStyles from '../styles';


const cards = [1, 2, 3, 4, 5, 6, 7, 8, 9]
const AuthorForm = (props) => {
    const classes = useStyles();
    return(
        <>
            <CssBaseline/>
            <AppBar position="relative">
                <Toolbar>
                    <AutoStoriesIcon className={classes.icon}/>
                    <Typography variant="h4"> Authors</Typography>
                </Toolbar>
            </AppBar>
            <main>
                <TableContainer component={Paper} justifyContent="center" sx={{maxHeight: '300px'}}>
                    <Table aria-label="simple table" stickyHeader>
                        <TableHead>
                            <TableRow>
                                <TableCell>First Name</TableCell>
                                <TableCell>Last Name</TableCell>

                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {
                                tableData.map(row => (
                                    <TableRow key={row.id} sx={{'$:last-child td, &:last-child th': {border: 0}}}>
                                        <TableCell>{row.first_name}</TableCell>
                                        <TableCell>{row.last_name}</TableCell>
                                    </TableRow>
                                ))
                            }
                        </TableBody>
                    </Table>
                </TableContainer>
                <div className={classes.container}>
                    <Container  style={{marginTop: "50px"}}>
                        <Typography variant="h2" align="center" color="textPrimary" gutterBottom>Do you have a favorite author?</Typography>
                        <Typography variant="h5" align="center" color="textSecondary" paragraph>Hello everyone this is a photo album and I'm trying to make this sentence as long as possible</Typography>
                        <div className={classes.button}>
                            <Grid container spacing={2} justifyContent="center">
                                <Grid item>
                                    <Button variant="contained" color="primary">
                                        See my photos
                                    </Button>
                                </Grid>
                                <Grid item>
                                    <Button  variant="outlined" color="primary">
                                        Secondary action
                                    </Button>
                                </Grid>
                            </Grid>
                        </div>
                    </Container>
                </div>
                <Container className={classes.cardGrid} maxWidth="md">
                    <Grid container spacing={4}>
                        {cards.map((card) => (
                            <Grid item key={card} xs={12} sm ={6} m={4}>
                                <Card className={classes.card}>
                                    <CardMedia className={classes.cardMedia} image="https://source.unsplash.com/random/" title="Image Title"/>
                                    <CardContent className={classes.cardContent}>
                                        <Typography gutterBottom variant='h5'>
                                            Heading
                                        </Typography>
                                        <Typography>
                                            This is a media card to use a section to describe a content 
                                        </Typography>
                                    </CardContent>
                                    <CardActions>
                                        <Button size="small" color="primary">View</Button>
                                        <Button size="small" color="primary">Edit</Button>
                                    </CardActions>
                                </Card>
                            </Grid>
                        ))}
                    </Grid>
                </Container>
            </main>
            <footer classes={classes.footer}>
                <Typography variant="h6" align="center" gutterBottom>Footer</Typography>
                <Typography variant="subtitle1" align="center" color="textSecondary">Something here to give a footer a purpose</Typography>
            </footer>
        </>
    );
}
export default AuthorForm;
const tableData = 
    [{
  "id": 1,
  "first_name": "Jermain",
  "last_name": "Wallwork",
  "email": "jwallwork0@sina.com.cn",
  "gender": "Male",
  "ip_address": "184.1.86.51"
}, {
  "id": 2,
  "first_name": "Dario",
  "last_name": "Furnival",
  "email": "dfurnival1@studiopress.com",
  "gender": "Male",
  "ip_address": "122.235.77.152"
}, {
  "id": 3,
  "first_name": "Idelle",
  "last_name": "Ginnaly",
  "email": "iginnaly2@vk.com",
  "gender": "Genderqueer",
  "ip_address": "20.233.1.74"
}, {
  "id": 4,
  "first_name": "Pier",
  "last_name": "Jannings",
  "email": "pjannings3@jimdo.com",
  "gender": "Female",
  "ip_address": "141.202.103.119"
}, {
  "id": 5,
  "first_name": "Franky",
  "last_name": "Fright",
  "email": "ffright4@tripod.com",
  "gender": "Bigender",
  "ip_address": "107.177.174.149"
}, {
  "id": 6,
  "first_name": "Guthrey",
  "last_name": "Ziems",
  "email": "gziems5@npr.org",
  "gender": "Male",
  "ip_address": "59.206.186.47"
}, {
  "id": 7,
  "first_name": "Kesley",
  "last_name": "Giacometti",
  "email": "kgiacometti6@europa.eu",
  "gender": "Female",
  "ip_address": "57.42.178.88"
}, {
  "id": 8,
  "first_name": "Gavin",
  "last_name": "Bellefonte",
  "email": "gbellefonte7@washingtonpost.com",
  "gender": "Male",
  "ip_address": "55.251.10.185"
}, {
  "id": 9,
  "first_name": "Adelheid",
  "last_name": "Candey",
  "email": "acandey8@ucoz.ru",
  "gender": "Female",
  "ip_address": "51.102.176.81"
}, {
  "id": 10,
  "first_name": "Karl",
  "last_name": "Schankelborg",
  "email": "kschankelborg9@boston.com",
  "gender": "Male",
  "ip_address": "14.196.81.186"
}];