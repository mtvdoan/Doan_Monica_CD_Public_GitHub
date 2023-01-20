const mongoose = require('mongoose');

const ProductSchema = new mongoose.Schema(
    {
        title: {
            type: String, 
            required: [true, "Title is required"],
            minLength: [3, 'Title must be at least 3 characters']
    },
        price: {
            type: Number,
            required: [true, "Price is required"],
            min: [0.01, 'Price must be at least $0.01'],
    },
        description: {
            type: String,
            required: [true, "Description is required"],
            minLength: [10, 'Description must be at least 10 characters']
        }
    },
    {timestamps: true}
);
const Product =mongoose.model('Product', ProductSchema);
module.exports = Product;