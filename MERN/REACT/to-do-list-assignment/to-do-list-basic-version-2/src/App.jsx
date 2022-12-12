import './App.css';
import React, { useState } from 'react';

function App() {

    const [inputVal, setInputVal] = useState('');
    const [list, setList] = useState([]);

    function add(e) {
        e.preventDefault();

        if(inputVal === '') return;

        setList([...list, {
            text: inputVal,
            completed: false
        }]);

        setInputVal('');
    }

    function remove(index) {
        setList(list.filter((_item, i) => i !== index));
    }

    function toggleChecked(index) {
        const obj = {...list[index]};

        obj.completed = !obj.completed;

        setList([...list.slice(0, index), obj].concat(list.slice(index + 1)));
    }

    return (
        <div className='App'>
            <h1>Basic To Do List</h1>
            <form onSubmit={add}>
                <input
                    onChange={e => setInputVal(e.target.value)}
                    value={inputVal}
                />
                <button>Add</button>
            </form>

            {list.map((item, i) => (
                <div className="toDoListDisplay" key={i}>
                    <input
                        type="checkbox"
                        checked={item.completed}
                        onClick={() => toggleChecked(i)}
                        readOnly
                    />
                    <span style={{ textDecoration: item.completed && 'line-through' }}>{item.text}</span>
                    <button onClick={() => remove(i)}>Delete</button>
                </div>
            ))}

        </div>
    )
}

export default App;
