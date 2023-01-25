const mongoose = require('mongoose');
mongoose
    .connect('mongodb://127.0.0.1:27017/productmanager', {
        useNewUrlParser: true,
        useUnifiedTopology: true,

    })
    .then(() => console.log("Established a connection to the database"))
    .catch(err => console.log('Something went wrong when connecting to the database', err));

/* 
BASIC NOTES TO SELF TO HELP ME UNDERSTAND THINGS:
This code is using the Mongoose library to connect to a MongoDB database. The Mongoose library is a MongoDB object modeling tool for Node.js.

The connect() function is used to establish a connection to the MongoDB server and create a new database called "productmanager" if it doesn't already exist. The first argument passed to the connect() function is the connection string, which includes the IP address and port of the MongoDB server, as well as the name of the database.

The useNewUrlParser and useUnifiedTopology options are passed as an object to the connect function, it is used to avoid deprecation warnings.

The connect() function returns a promise which is resolved if the connection is successful and rejected if there is an error. In this case, the then() method is used to log a message to the console if the connection is successful. If there is an error, it will be caught by the catch() method and an error message is logged to the console.

*/