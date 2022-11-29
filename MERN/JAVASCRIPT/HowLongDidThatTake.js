//Monica Doan
//Coding Dojo Learning Platform Assignment: How long did that take? (Optional)

////////////////////////////////////////////////////////////////////////////////////////////////
Number.prototype.isPrime = function() {
    for( let i=2; i<this; i++ ) {
        if( this % i === 0 ) {
            return false;
        }
    }
    return true;
}
//how long it takes to find the 10,000th prime number.
const { performance } = require('perf_hooks');
const start = performance.now();
let primeCount = 0;
let num = 2; // for math reasons, 1 is considered prime
while( primeCount < 1e4 ) {
    if( num.isPrime() ) {
        primeCount++;
    }
    num++;
}
console.log(`The 10,000th prime number is ${num-1}`);
console.log(`This took ${performance.now() - start} milliseconds to run`);
//My computer takes: 
    //The 10,000th prime number is 104729
    // This took 28087.460999965668 milliseconds to run


//Try rewriting the isPrime() function above and seeing how much quicker this runs. 
//Learn platform hint: we don't need to search past the square root of the number 
Number.prototype.isPrime = function() {
    for( let i=2; i*i<this; i++ ) {
        if( this % i === 0 ) {
            return false;
        }
    }
    return true;
}

const { performance } = require('perf_hooks');
const start = performance.now();
let primeCount = 0;
let num = 2; // for math reasons, 1 is considered prime
while( primeCount < 1e4 ) {
    if( num.isPrime() ) {
        primeCount++;
    }
    num++;
}
console.log(`The 10,000th prime number is ${num-1}`);
console.log(`This took ${performance.now() - start} milliseconds to run`);

////////////////////////////////////////////////////////////////////////////////////////////////
//WHICH IS FASTER?:

// recursive 
const { performance } = require('perf_hooks');
const start = performance.now();
function rFib( n ) {
    if ( n < 2 ) {
        return n;
    }
    return rFib( n-1 ) + rFib( n-2 );
}
rFib(20);
console.log(`rFib: ${rFib(20)}`);
console.log(`This took ${performance.now() - start} milliseconds to run`);
//Answer: rFib: 6765
// This took 3.7021669149398804 milliseconds to run

//OR//

// iterative
const { performance } = require('perf_hooks');
const start = performance.now();
function iFib( n ) {
    const vals = [ 0, 1 ];
    while(vals.length-1 < n) {
        let len = vals.length;
        vals.push( vals[len-1] + vals[len-2] );
    }
    return vals[n];
}
console.log(iFib(20));  

console.log(`iFib: ${iFib(20)}`);
console.log(`This took ${performance.now() - start} milliseconds to run`);
    // iFib: 6765
    // This took 2.919332981109619 milliseconds to run

//Iterative is faster than recursive.  Check https://pythontutor.com/render.html#mode=display
/////////////////////////////////////////////////////////////////////////////////////////////////////////

// REVERSING A STRING
const { performance } = require('perf_hooks');
const start = performance.now();
const story = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident culpa nihil repellat nulla laboriosam maxime, quia aliquam ipsam reprehenderit delectus reiciendis molestias assumenda aut fugit tempore laudantium tempora aspernatur? Repellendus consequatur expedita doloribus soluta cupiditate quae fugit! Aliquid, repellat animi, illum molestias maiores, laboriosam vero impedit iusto mollitia optio labore asperiores!";
const reversed1 = story.split("").reverse().join("");
console.log(`Result: ${reversed1}`);
console.log(`This took ${performance.now() - start} milliseconds to run`);
// LEARN PLATFORM:
//     Result: !seroirepsa erobal oitpo aitillom otsui tidepmi orev masoirobal ,seroiam saitselom mulli ,imina talleper ,diuqilA !tiguf eauq etatidipuc atulos subirolod atidepxe rutauqesnoc sudnellepeR ?rutanrepsa aropmet muitnadual eropmet tiguf tua adnemussa saitselom sidneicier sutceled tiredneherper maspi mauqila aiuq ,emixam masoirobal allun talleper lihin apluc tnedivorP .tile gnicisipida rutetcesnoc tema tis rolod muspi meroL
//     This took 3.1079169511795044 milliseconds to run

//TRY TO MAKE THIS RUN MORE EFFICIENTLY.
const { performance } = require('perf_hooks');
const start = performance.now();
const story = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident culpa nihil repellat nulla laboriosam maxime, quia aliquam ipsam reprehenderit delectus reiciendis molestias assumenda aut fugit tempore laudantium tempora aspernatur? Repellendus consequatur expedita doloribus soluta cupiditate quae fugit! Aliquid, repellat animi, illum molestias maiores, laboriosam vero impedit iusto mollitia optio labore asperiores!";
// const reversed1 = story.split("").reverse().join(""); <--I took this out...
function reverseString(story) {
    var newStory = "";
    for (var i = story.length - 1; i >= 0; i--) {
        newStory += story[i];
    }
    return newStory;
}

console.log(`Result: ` , reverseString(story) );
console.log(`This took ${performance.now() - start} milliseconds to run`);
//MY RESULTS:
    // Result:  !seroirepsa erobal oitpo aitillom otsui tidepmi orev masoirobal ,seroiam saitselom mulli ,imina talleper ,diuqilA !tiguf eauq etatidipuc atulos subirolod atidepxe rutauqesnoc sudnellepeR ?rutanrepsa aropmet muitnadual eropmet tiguf tua adnemussa saitselom sidneicier sutceled tiredneherper maspi mauqila aiuq ,emixam masoirobal allun talleper lihin apluc tnedivorP .tile gnicisipida rutetcesnoc tema tis rolod muspi meroL
    // This took 2.740249991416931 milliseconds to run



