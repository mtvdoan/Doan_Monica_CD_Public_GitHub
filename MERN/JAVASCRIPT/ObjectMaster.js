/* Monica Doan
Coding Dojo Learning Platform Assignment: Object Master
*/

const pokémon = Object.freeze([
    { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
    { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
    { "id": 9,   "name": "Blastoise",  "types": ["water"] },
    { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
    { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
    { "id": 23,  "name": "Ekans",      "types": ["poison"] },
    { "id": 24,  "name": "Arbok",      "types": ["poison"] },
    { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
    { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
    { "id": 52,  "name": "Meowth",     "types": ["normal"] },
    { "id": 63,  "name": "Abra",       "types": ["psychic"] },
    { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
    { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
    { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
    { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
    { "id": 98,  "name": "Krabby",     "types": ["water"] },
    { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
    { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
    { "id": 133, "name": "Eevee",      "types": ["normal"] },
    { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
    { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
    { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
    { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
]);

/* 
? For example we could create a list of pokémon that have names that start with the letter "B" by using the following code.
*/
const bListPkmn = pokémon.filter( p => p.name[0] === "B" );
console.log(bListPkmn);
/*
[
    { id: 1, name: 'Bulbasaur', types: [ 'poison', 'grass' ] },
    { id: 9, name: 'Blastoise', types: [ 'water' ] },
    { id: 12, name: 'Butterfree', types: [ 'bug', 'flying' ] }
]
*/

/*
? Or if we wanted to return an array of just the ids, we could use something like this.
*/
const pkmnIds = pokémon.map(p => p.id);
console.log(pkmnIds);
/*
[
    1,   5,   9,  12,  16,  23,  24,
    25,  37,  52,  63,  67,  72,  74,
    87,  98, 115, 122, 133, 144, 145,
    146, 148
]
*/
////////////////////////////////////////////////////////////////////////////////////////////////
/*
an array of pokémon objects where the id is evenly divisible by 3
*/
const pkmThreeArray = pokémon.filter( p => p.id % 3 === 0 );
console.log(pkmThreeArray);
/*
[
    { id: 9, name: 'Blastoise', types: [ 'water' ] },
    { id: 12, name: 'Butterfree', types: [ 'bug', 'flying' ] },
    { id: 24, name: 'Arbok', types: [ 'poison' ] },
    { id: 63, name: 'Abra', types: [ 'psychic' ] },
    { id: 72, name: 'Tentacool', types: [ 'water', 'poison' ] },
    { id: 87, name: 'Dewgong', types: [ 'water', 'ice' ] },
    { id: 144, name: 'Articuno', types: [ 'ice', 'flying' ] }
]
*/
////////////////////////////////////////////////////////////////////////////////////////////////
/*
an array of pokémon objects that are "fire" type
*/
const firePkmns = pokémon.filter(p => p.types.includes('fire'));
console.log(firePkmns);
////////////////////////////////////////////////////////////////////////////////////////////////
/*
an array of pokémon objects that have more than one type
*/
const moreThanOneTypePkmns = pokémon.filter(p => p.types.length > 1);
console.log(moreThanOneTypePkmns)
////////////////////////////////////////////////////////////////////////////////////////////////
/*
an array with just the names of the pokémon
*/
const namePkmns = pokémon.map(p => p.name);
console.log(namePkmns);
////////////////////////////////////////////////////////////////////////////////////////////////
/*
an array with just the names of pokémon with an id greater than 99
*/
const greaterThan99Pkmns = pokémon.filter( p => p.id > 99);
console.log(greaterThan99Pkmns);
////////////////////////////////////////////////////////////////////////////////////////////////
/*
an array with just the names of the pokémon whose only type is poison
*/
const poisonOnlyPkmns = pokémon
    .filter(
        p => p.types.length == 1 
            && p.types[0]== 'poison')
    .map(
        p => p.name);
console.log(poisonOnlyPkmns);

////////////////////////////////////////////////////////////////////////////////////////////////
/*
an array containing just the first type of all the pokémon whose second type is "flying"
*/
const typesWithFlying = pokémon
    .filter(
        p => p.types.length == 2
            && p.types[1] == 'flying')
    .map(
        p => p.types[0]);
console.log(typesWithFlying);
////////////////////////////////////////////////////////////////////////////////////////////////
/*
a count of the number of pokémon that are "normal" type
*/
const countNormalPkmn = pokémon
    .filter(
        p => p.types.includes('normal')
    )
    .length;
console.log(countNormalPkmn);