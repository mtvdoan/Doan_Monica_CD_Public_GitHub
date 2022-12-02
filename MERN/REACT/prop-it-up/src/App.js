import './App.css';
import PersonCard from './components/PersonCard';

function App() {
  return (
    <div className="App">
    <PersonCard 
    lastName= {'John'}
    firstName= {'Edward'}
    age={'25'}
    color={'Golden Yellow'}
    />
    
    <PersonCard 
    lastName= {'Doan'}
    firstName= {'Monica'}
    age={'35'}
    color={'Black'}
    />
    
    <PersonCard 
    lastName= {'Ames'}
    firstName= {'Alex'}
    age={'35'}
    color={'Golden Yellow'}
    />
    
    <PersonCard 
    lastName= {'Doo'}
    firstName= {'Zipidee'}
    age={'35'}
    color={'Black'}
    />
    
    
    </div>
    );
  }
  
  export default App;
  