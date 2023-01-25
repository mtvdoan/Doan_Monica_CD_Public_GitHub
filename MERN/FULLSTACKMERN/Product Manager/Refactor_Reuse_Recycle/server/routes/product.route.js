const ProductController = require('../controllers/product.controller');


module.exports = function(app){
  app.get('/api', ProductController.index);
  app.post('/api/product', ProductController.createProduct);
  app.get('/api/products', ProductController.getAllProducts);
  app.get('/api/product/:_id', ProductController.getOneProduct);
  app.put('/api/product/:_id', ProductController.updateProduct);
  app.delete('/api/product/:_id', ProductController.deleteProduct);
}

/*
BASIC NOTES TO SELF TO HELP ME UNDERSTAND BETTER:  

This code is setting up routes for an Express.js web application.
It is importing the "ProductController" module, which exports a number of functions that handle different HTTP requests.
It sets up the following routes on the app:

app.get('/api', ProductController.index);
This route maps the root URL '/api' to the "index" function of the "ProductController" module. When a GET request is made to the '/api' endpoint, it will invoke the "index" function, which is expected to handle the request and send a response.

app.post('/api/product', ProductController.createProduct);
This route maps the url '/api/product' to the "createProduct" function of the "ProductController" module. When a POST request is made to this endpoint, it will invoke the "createProduct" function, which is expected to handle the request and send a response.

app.get('/api/products', ProductController.getAllProducts);
This route maps the url '/api/products' to the "getAllProducts" function of the "ProductController" module. When a GET request is made to this endpoint, it will invoke the "getAllProducts" function, which is expected to handle the request and send a response.

app.get('/api/product/:_id', ProductController.getOneProduct);
This route maps the url '/api/product/:_id' to the "getOneProduct" function of the "ProductController" module. When a GET request is made to this endpoint, it will invoke the "getOneProduct" function, which is expected to handle the request and send a response.

app.put('/api/product/:_id', ProductController.updateProduct);
This route maps the url '/api/product/:_id' to the "updateProduct" function of the "ProductController'/api/product/:_id' to the "getOneProduct" function of the "ProductController" module. When a GET request is made to this endpoint, it will invoke the "getOneProduct" function, which is expected to handle the request and send a response.


 */