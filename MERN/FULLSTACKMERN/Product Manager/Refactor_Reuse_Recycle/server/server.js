const express = require('express');
const app = express();
const cors = require('cors');
const port = 8000;

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({extended: true}));

require('./config/mongoose.config');
require('./routes/product.route')(app);


app.listen(port, () => console.log('listening on port ' + port));

/*
BASIC NOTES TO SELF SO I CAN UNDERSTAND BETTER: 

This code is setting up a server using the Express.js framework. The server is being set up to listen on port 8000.

It is also utilizing the middleware packages "cors" and "express.json" to handle cross-origin resource sharing and JSON data respectively. Then it's using express.urlencoded to parse incoming request bodies before handling them.

It then requires and runs the code from two other files, mongoose.config and product.route.

mongoose.config is likely configuring a connection to a MongoDB database.

product.route is likely specifying the various routes and the corresponding controller methods that should be run for each route.

Finally, it starts the server to listen on the specified port and logs a message to the console to confirm that the server is running.

 */