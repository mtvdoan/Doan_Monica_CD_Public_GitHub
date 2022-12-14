import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useState, useEffect} from 'react';
import './App.css';
import axios from 'axios';
function App() {
    // const[pokemon, setPokemon] = useState([]);
    const[responseData, setResponseData] = useState(null);
    const[isShown, setIsShown] = useState(false);
    const onClickHandler = event => {
        setIsShown(current=>!current);
    }
    useEffect(() => {
      axios.get('https://pokeapi.co/api/v2/pokemon')
        .then(response =>{setResponseData(response.data)})
        // fetch('https://pokeapi.co/api/v2/pokemon')
        //     .then(response => response.json())
        //     .then(response=> setPokemon(response.results))
    }, []);
    function Box() {
      return (
        <div>
            {responseData && responseData.results.map((poke, index) => {
              const capitalizedFirstLetterPokemonName = poke.name.charAt(0).toUpperCase();
                    const restOfPokemonName = poke.name.slice(1);
                    const capitalizedPokemonName = capitalizedFirstLetterPokemonName + restOfPokemonName;
                    return (
                        <div key={index}>{capitalizedPokemonName}</div>
              );
            })
          }
          </div>
      )
    }
    return(
        <>
            <div>
                <button onClick={ onClickHandler }>Fetch Pokemon</button>
            </div>
            {isShown && (<Box/>)}
        </>
    );
};
export default App;

/*
Notes to self:
*pokemon.length needs to be >0 or the map function will not be called and give 0.
*This needs to be set this way:
    ?{pokemon.length > 0 && 
                    ?pokemon.map((pokemon, index) 
    ?Because && operator has a lower precedence than the map function called.  Without the () map will be called before the condition is checked. 
*remember that JSX elements must be returned from the function that contains them.
    *Here the map will return an array of 'div' elements and the 'return' makes sure that array is returned from the 'Box' function.
 */