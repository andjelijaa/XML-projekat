import './App.css';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Registracija from "./components/register/register";
import Login from "./components/login/login";
import Home from "./components/home/home";
import Search from "./components/search/search";
import Profil from './components/profil/profil';
import Vidisvojeslike from './components/vidisvojeslike/vidisvojeslike';
import Azuriranje from "./components/azuriranje/azuriranje";
import Objavisliku from './components/objavisliku/objavisliku';


function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route component={Home} path="/" exact/>
        <Route component={Registracija} path="/registracija"/>
        <Route component={Login} path="/login"/>
        <Route component={Search} path="/pretrage"/>
        <Route component={Profil} path="/profil"/>
        <Route component={Vidisvojeslike} path="/vidisvojeslike"/>
        <Route component={Azuriranje} path="/azuriranje"/>
        <Route component={Objavisliku} path="/objavisliku">
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
 