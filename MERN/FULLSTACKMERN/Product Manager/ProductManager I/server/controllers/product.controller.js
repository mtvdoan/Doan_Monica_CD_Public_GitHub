
const Product = require('../models/product.model');
// module.exports.index = (req, res) => {
//     res.json({ message: "Hello World"});
// }
module.exports = {
    // index: (req, res) => {
    //     res.json({ message: "Hello World"});
    // },
    findAll: (req, res) => {
        Product
            .find()
            .then((allProducts) => res.json(allProducts))
            .catch((err) => res.json({message: 'Something went wrong while trying to view all products', error: err}))
    },
    create: (req, res) => {
        Product
            .create(req.body)
            .then((newProduct) => res.json(newProduct))
            .catch(err => res.json({message: "Something went wrong with create", error: err}))
    }
};