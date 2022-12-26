/* 
    Monica Doan
    LEARN Assignment: Faker API
*/

//LEARN PLATFORM SAMPLE: 

/*
? we can create a function to return a random / fake "Product"
const { faker } = require('@faker-js/faker');
const createProduct = () => {
    const newFake = {
        name: faker.commerce.productName(),
        price: "$" + faker.commerce.price(),
        department: faker.commerce.department()
    };
    return newFake;
};
    
const newFakeProduct = createProduct();
console.log(newFakeProduct);

 * The output of the above console log will look like this
 * {
 *   name: 'Anime Figure',
 *   price: '$568.00
 *   department: 'Tools' 
 * }

 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*NOTE: USE 'npm install @faker-js/faker' and const{faker} @faker-js/faker in server.js*/
/*Create 2 functions: createUser, createCompany that return an object with the properties listed above*/

const { faker } = require('@faker-js/faker');
const express = require('express');
const app = express();
const port = 8000;

/*
Create User Object
_id
firstName
lastName
phoneNumber
email
password
*/

const generateUserObject = () => ({
    _id: faker.datatype.uuid(),
    firstName: faker.name.firstName(),
    lastName: faker.name.lastName(),
    phoneNumber: faker.phone.number(),
    email: faker.internet.email(),
    password: faker.internet.password()

});

/*
Create Company Object
_id
name
address
street
city
state
zipCode
country
*/

const generateCompanyObject = () => ({
    _id: faker.datatype.uuid(),
    name: faker.company.name(),
    address: {
        street: faker.address.streetAddress(),
        city: faker.address.cityName(),
        state: faker.address.state(),
        zipCode: faker.address.zipCode(),
        country: faker.address.country()
    }

});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*Create an api route "/api/users/new" that returns a new user */
app.get('/api/users/new', (req, res) => {
    const newUser = generateUserObject();
    res.send(newUser);
});

/*Create an api route "/api/companies/new" that returns a new company*/
app.get('/api/companies/new', (req, res) => {
    const newCompany = generateCompanyObject();
    res.send(newCompany);
});

/*Create an api route "/api/user/company" that returns both a new user and a new company*/
app.get('/api/user/company', (req, res) => {
    const newUser = generateUserObject();
    const newCompany = generateCompanyObject();
    const responseObject = {
        newUser: newUser,
        newCompany: newCompany
    }
    res.json(responseObject);
});

app.listen(port, () => console.log('express server running on port: ${port}'));