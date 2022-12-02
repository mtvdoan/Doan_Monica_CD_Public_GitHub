
import React, { useState } from 'react';

const Counter = (props) =>{
    //We are creating a getter (inStock) and setter (setInStock)
    //State is used for holding and updating things and changing those values as it goes
    //props is for passing things
    const [ age, setAge ] = useState(props.initialAge);
    return(
        <div>
            <h2>{ props.name }</h2>
            <p>Age: { age }</p>
            <button onClick={ (event) => setAge(age + 1)}>Birthday Button for { props.name }</button>
        </div>
    );
}

export default Counter;