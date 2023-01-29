const Author = require('../models/author.model');    

module.exports.index = (request, response) => {
    response.json({
        message: "This is the beginning"
    });
}

module.exports = {

    findAll: (req,res) => {

        Author
            .find()
            .then(allAuthors => res.json(allAuthors))
            .catch((err) => res.status(400).json({message: "Something went wrong when finding all authors", error:err}));
    },

    findOne: (req,res) => {
        Author
            .findById(req.params.id)
            .then(author => res.json(author))
            .catch((err) => res.status(400).json({message: "Something went wrong when trying to find details of an author", error:err}));
    },
    
    create: (req,res) => {

        Author
            .create(req.body)
            .then((newAuthor) => res.json(newAuthor))
            .catch((err) => res.status(400).json({message: "Something went wrong when creating a new author", error:err}));
    },

    update: (req,res) => {

        Author
            .findByIdAndUpdate(
                req.params.id, 
                req.body,
                {new: true, runValidators: true}
            )
            .then(updatedAuthor => res.json({updatedAuthor}))
            .catch((err) => res.status(400).json({message: "Something went wrong when updating an author", error:err}));
    },

    delete: (req,res) => {

        Author
            .findByIdAndDelete(req.params.id)
            .then(deletedAuthor => res.json({deletedAuthor}))
            .catch((err) => res.status(400).json({message: "Something went wrong when adding a favorite author", error:err}));
    }
};

