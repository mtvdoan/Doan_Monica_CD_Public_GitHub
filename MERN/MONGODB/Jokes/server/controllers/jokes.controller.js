const Joke = require('../models/jokes.model');

module.exports.findAllJokes = (req, res) => {
    Joke.find()
        .then((allJokes) => {
            res.json({ messages: "Here are all the jokes!", jokes: allJokes });
        })
        .catch((err) => {
            res.json({ message: "Something went wrong when trying to find all jokes", error: err})
        })
}

module.exports.findOneSingleJoke = (req, res) => {
    Joke.findOne({_id: req.params.id})
        .then(oneSingleJoke => {
            res.json({ message: "Here's your joke you wanted!", joke: oneSingleJoke})
        })
        .catch((err) => {
            res.json({ message: "Something went wrong when trying to find a specific joke", error: err})
        });
}

module.exports.createNewJoke = (req, res) => {
    Joke.create(req.body)
        .then(newlyCreatedJoke => {
            res.json({ message: "You've successfully created a new joke", joke: newlyCreatedJoke})
        })
        .catch((err) => {
            res.json({ message: "Something went wrong when trying to create a new joke", error: err })
        });

}

module.exports.updateAnExistingJoke = (req, res) => {
    Joke.findOneAndUpdate(
        {_id: req.params.id},
        req.body,
        {
            new: true,
            runValidators: true
        }
    )
        .then(updateJoke => {
            res.json({ message: "You have successfully updated a joke", joke: updateJoke})
        })
        .catch((err) => {
            res.json({ message: "Something went wrong when trying to update an existing joke", error: err })
        });
}

module.exports.deleteAnExistingJoke = (req, res) => {
    Joke.deleteOne({_id: req.params.id})
        .then(result => {
            res.json({ message: "Joke has been deleted", result: result})
        })
        .catch((err) => {
            res.json({message: "Something went wrong when trying to delete an existing joke", error: err})
        });
}