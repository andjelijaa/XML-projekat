import './App.css';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Registracija from "./components/register/register";
import Login from "./components/login/login";
import Home from "./components/home/home";
import Search from "./components/search/search";
import profilRouter from './components/profil/profilRouter';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route component={Home} path="/" exact/>
        <Route component={Registracija} path="/registracija"/>
        <Route component={Login} path="/login"/>
        <Route component={Search} path="/pretrage"/>
        <Route component={profilRouter} path="/:username"/>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
 