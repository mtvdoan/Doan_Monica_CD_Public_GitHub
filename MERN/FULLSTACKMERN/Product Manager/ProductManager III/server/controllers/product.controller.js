
const Product = require('../models/product.model');

module.exports = {
    findAll: (req, res) => {
        Product
            .find()
            .then((allProducts) => res.json(allProducts))
            .catch((err) => res.json({message: 'Something went wrong while trying to view all products', error: err}))
    },

    findOne: (req, res) => {
        Product
            .findById(req.params.id)
            .then((product) => res.json(product))
            .catch((err) => res.json({message: 'Something went wrong while trying to find details of a product', error: err}))
    },

    create: (req, res) => {
        Product
            .create(req.body)
            .then((newProduct) => res.json(newProduct))
            .catch(err => res.json({message: "Something went wrong with create", error: err}))
    },

    update: (req, res) => {
        Product
            .findByIdAndUpdate(req.params.id, req.body, {new: true, runValidators: true})
            .then(updatedProduct => res.json({updatedProduct}))
            .catch(err => res.json({message: "Something went wrong while updating", error:err}))
    },
    
    delete: (req, res) => {
        Product
            .findByIdAndDelete(req.params.id)
            .then(deletedProduct => res.json({deletedProduct}))
            .catch(err => res.status(400).json({message: "Something went wrong while deleting", error:err}));
    }
};