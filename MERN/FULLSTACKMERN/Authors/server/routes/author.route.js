const AuthorController = require('../controllers/author.controller');
module.exports = (app) => {
    // app.get('/api', AuthorController.index);
    app.get('/api/authors/', AuthorController.findAll);
    app.get('/api/authors/:id', AuthorController.findOne);
    app.post('/api/authors/create', AuthorController.create);
    app.put('/api/authors/update/:id', AuthorController.update);
    app.delete('/api/authors/delete/:id', AuthorController.delete);

};

