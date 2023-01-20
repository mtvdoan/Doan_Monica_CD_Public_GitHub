const ProductController = require('../controllers/product.controller');
module.exports = (app) => {
    app.get('/api/products/', ProductController.findAll);
    app.get('/api/products/:id/', ProductController.findOne)
    app.post('/api/products/', ProductController.create);
};