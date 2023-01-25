const { Product } = require('../models/product.model')

module.exports.index = (req, res) => {
  res.json({ message: "This is only the beginning.  -Monica" });
}


module.exports.createProduct = (req, res) => {
  const { title, price, description } = req.body;
  Product.create({
    title,
    price,
    description
  })
    .then(product => res.json(product))
    .catch(err => res.json(err));
};


module.exports.getAllProducts = (req, res) => {
  Product.find({})
    .then(products => res.json(products))
    .catch(err => res.json(err));
};


module.exports.getOneProduct = (req, res) => {
  Product.findOne({ _id: req.params._id })
    .then(prod => res.json(prod))
    .catch(err => res.json(err));
};


module.exports.updateProduct = (req, res) => {
  Product.findOneAndUpdate({ _id: req.params._id }, req.body, { runValidators: true })
    .then( () => res.json({msg: "Update successful"}))
    .catch(err => res.json(err));
};


module.exports.deleteProduct = (req, res) => {
  Product.deleteOne({_id: req.params._id})
    .then(deleteConfirmation => res.json(deleteConfirmation))
    .catch(err => res.json(err))
};

/*
BASIC NOTES TO SELF TO HELP ME UNDERSTAND BETTER: 

This code exports several functions that interact with a MongoDB database through the Mongoose library. The code imports the "Product" model, which is used to interact with the "product" collection in the database.

The first function, "index", returns a JSON object containing a message "Hello World" when it is called.

The second function, "createProduct", takes the data passed in the request body, creates a new product object using this data, and then stores this object in the database.

The third function, "getAllProducts", retrieves all products from the database and returns them in a JSON object.

The fourth function, "getOneProduct", retrieves one product from the database based on its ID and returns it in a JSON object.

The fifth function, "updateProduct", updates the product in the database based on the ID passed in the request parameters, using data passed in the request body.

The sixth function, "deleteProduct", deletes one product from the database based on the ID passed in the request parameters. It returns a JSON object with the details of the deletion.

 */