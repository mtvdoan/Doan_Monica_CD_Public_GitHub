function tossCoin() {
    return Math.random() > 0.5 ? "heads" : "tails";
}

function fiveHeadsSync() {
    return new Promise((resolve, reject) => {
    let headsCount = 0;
    let attempts = 0;
    while(headsCount < 5 && attempts <= 100) {
        attempts++;
        let result = tossCoin();
        console.log(`${result} was flipped`);
        if(result === "heads") {
            headsCount++;
        } else {
            headsCount = 0;
        }
    }
    if(headsCount == 5 && attempts < 100){
        resolve("A total of " + attempts + " attempts were made!" + " Heads flipped 5 times after less than 100 attempts");
        
    }
    else{
        reject("A total of " + attempts + " attempts were made!" + " Oh boo. Heads was flipped 5 times, but after more than 100 attempts!  That's too many!")
    }
  
    });
    
}

fiveHeadsSync()
    .then( res => console.log(res) )
    .catch( err => console.log(err) );
console.log( "When does this run now?");
console.log( "This is run after the fiveHeadsSync function completes" );




