const JokeController = require('../controllers/jokes.controller');

module.exports = app => {
    app.get('/api/jokes/:id', JokeController.findOneSingleJoke);
    app.get('/api/jokes', JokeController.findAllJokes);
    app.post('/api/jokes/:id', JokeController.createNewJoke);
    app.put('/api/jokes/:id', JokeController.updateAnExistingJoke);
    app.delete('/api/jokes/:id', JokeController.deleteAnExistingJoke);
}

/*Note to self: I noticed that update does not work with '/api/jokes/:_id'
Learning platform requested to use with _id...
Have to use 'api/jokes/:id' instead
*/