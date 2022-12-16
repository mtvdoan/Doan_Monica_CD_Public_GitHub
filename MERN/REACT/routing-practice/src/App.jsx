import './App.css';
import React from 'react';
import Home from './components/Home';
import PathEntry from './components/PathEntry';
import {
	BrowserRouter,
	Routes,
	Route,
	Link
	} from "react-router-dom";
function App() {
	return (
		<>
			<div className="App">
				<BrowserRouter>
					<h1>Routing Practice</h1>
					<Routes>
						<Route path="/home/" element={<Home />} />
						<Route path="/:entry/:colorText/:bgColor/" element={<PathEntry/>} />
						<Route path="/:entry /" element={<PathEntry/>} />
					</Routes>
				</BrowserRouter>
			</div>
		</>
	);
}

export default App;
