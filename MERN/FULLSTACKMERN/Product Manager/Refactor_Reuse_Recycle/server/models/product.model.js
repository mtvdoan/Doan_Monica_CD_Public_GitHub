const mongoose = require('mongoose');


const ProductSchema = new mongoose.Schema(
  {
    title: { 
      type: String,
      required: [true, "Title is required"],
      minlength: [2, "Title must be at least 2 characters long"] 
    },
    price: { 
      type: Number,
      required: [true, "Price is required"],
      min: [1, "Price cannot be less than 1"]
    },
    description: { 
      type: String,
      required: [true, "Description is required"],
      minlength: [5, "Description must be at least 5 characters long"]
    }
  }, { timestamps: true });


module.exports.Product = mongoose.model("Product", ProductSchema);

/*
BASIC NOTES FOR ME TO UNDERSTAND BETTER:  This code is creating a Mongoose schema for a product. Mongoose is a library that allows you to define a schema for a MongoDB document and then interact with the database using that schema.

The code starts by requiring the Mongoose library, then it creates a new schema called ProductSchema. This schema defines three fields for the product: title, price, and description. Each field has a type and some validation rules.

For example, title is a string and it is required and must have at least 2 characters long. Price is number and it is required and cannot be less than 1. Description is a string and it is required and must have at least 5 characters long.

The schema also has timestamps option set to true, which will automatically add createdAt and updatedAt fields to the documents.

Finally, the code exports the Product model, which is created by calling mongoose.model() and passing in the name of the model ("Product") and the schema (ProductSchema). This will allow other parts of the application to interact with the products collection in the database using this model.

 */