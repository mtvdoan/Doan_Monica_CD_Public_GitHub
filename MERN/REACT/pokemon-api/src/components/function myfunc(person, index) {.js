function myfunc(person, index) {
    return (<div key={index}>{person.name}</div>)
}


{people.length > 0 && people.map(mufunc)}