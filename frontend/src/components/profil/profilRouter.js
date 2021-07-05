import { Switch, BrowserRouter, Route } from 'react-router-dom';
import ProfilNavBar from "./ProfilNavbar";
import ObjaviSliku from "../objavisliku/objavisliku";
import Azuriranje from "../azuriranje/azuriranje";
import Search from "../search/search";
import Vidisvojeslike from "../vidisvojeslike/vidisvojeslike";
import Profil from "./profil";
import Login from "../login/login";
import {useState, useEffect} from 'react';


function ProfilRouter(){

    const [username, setUsername] = useState("");

    useEffect(() => {
        const token = localStorage.getItem("token");
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace('-', '+').replace('_', '/');
        const wholeUser = JSON.parse(window.atob(base64))
        setUsername(wholeUser.sub);
    },[username, setUsername])

    return(

        <main>
            <BrowserRouter>
            <ProfilNavBar></ProfilNavBar>
                <Switch>
                    <Route component={Azuriranje} path="/:username/azuriranje"></Route>
                    <Route component={Vidisvojeslike} path="/:username/vidisvojeslike"></Route>
                    <Route component={Profil} path="/:username/profil"></Route>
                    <Route component={ObjaviSliku} path="/:username/objavisliku"></Route>
                    <Route component={Search} path="/:username/Profilsearch"></Route>
                    <Route component={Login} path="/:username/login"></Route>
                </Switch>
            </BrowserRouter>
        </main>
    )
}

export default ProfilRouter;