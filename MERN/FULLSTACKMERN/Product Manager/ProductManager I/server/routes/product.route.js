const ProductController = require('../controllers/product.controller');
module.exports = (app) => {
    app.get('/api/products/', ProductController.findAll);
    app.post('/api/products/', ProductController.create);
};