import './App.css';
import PersonCard from './components/PersonCard';
import { useState } from 'react';
function App() {
  const [age, setAge] = useState(0);
  return (
    <div className="App">
      <PersonCard 
      lastName= {'John'}
      firstName= {'Edward'}
      initialAge = {31}
      color={'Golden Yellow'}
      />
      
      <PersonCard 
      lastName= {'Doan'}
      firstName= {'Monica'}
      initialAge={35}
      color={'Black'}
      />
      
      <PersonCard 
      lastName= {'Ames'}
      firstName= {'Alex'}
      initialAge={35}
      color={'Golden Yellow'}
      />
      
      <PersonCard 
      lastName= {'Doo'}
      firstName= {'Zipidee'}
      initialAge={100}
      color={'Black'}
      />
    </div>
    );
  }
  
  export default App;
  