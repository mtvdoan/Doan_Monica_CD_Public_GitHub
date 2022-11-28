// //Problem 1
const cars = ['Tesla', 'Mercedes', 'Honda']
const [ randomCar ] = cars
const [ ,otherRandomCar ] = cars
//Predict the output
console.log(randomCar)
    //prints the first car 'Tesla'
console.log(otherRandomCar)
//     //prints th;e second car 'Mercedes' because of the ONE comma in front which skips the first car

//Problem 2
const employee = {
    name: 'Elon',
    age: 47,
    company: 'Tesla'
}
const { name: otherName } = employee;
//Predict the output
// console.log(name);
    //otherName is undefined
console.log(otherName);
    //prints out 'Elon' since name is referred as 'otherName'

// //Problem 3
const person = {
    name: 'Phil Smith',
    age: 47,
    height: '6 feet'
}
const password = '12345';
const { password: hashedPassword } = person;  
// //Predict the output
console.log(password);
    //prints out '12345'
console.log(hashedPassword);
    //prints an error message because hashedPassword is undefined.  password is already defined in a constant above.


//Problem 4
const numbers = [8, 2, 3, 5, 6, 1, 67, 12, 2];
const [,first] = numbers;
const [,,,second] = numbers;
const [,,,,,,,,third] = numbers;
// //Predict the output
console.log(first == second);
//     //prints false because first is '2' and second is ' 5'
console.log(first == third);
//     //prints true because first is '2' and third is '2'


//Problem 5
const lastTest = {
    key: 'value',
    secondKey: [1, 5, 1, 8, 3, 3]
}
const { key } = lastTest;
const { secondKey } = lastTest;
const [ ,willThisWork] = secondKey;
//Predict the output
console.log(key);
    //prints out 'value'
console.log(secondKey);
    //prints out 
        // secondKey: [1, 5, 1, 8, 3, 3]
console.log(secondKey[0]);
    //prints out 1
console.log(willThisWork);
    //prints out 5
        //willThisWork is at the 2nd spot of array of secondKey so 5



