import { Switch, BrowserRouter, Route } from 'react-router-dom';
import ProfilNavBar from "./ProfilNavbar";
import ObjaviSliku from "../objavisliku/objavisliku";
import Azuriranje from "../azuriranje/azuriranje";
import Search from "../search/search";
import Vidisvojeslike from "../vidisvojeslike/vidisvojeslike";
import Profil from "./profil";



function profilRouter(){
    return(
        <main>
            <BrowserRouter>
            <ProfilNavBar></ProfilNavBar>
                <Switch>
                    <Route component={Azuriranje} exact path="/profilRouter/azuriranje"></Route>
                    <Route component={Vidisvojeslike} exact path="/profilRouter/vidisvojeslike"></Route>
                    <Route component={Profil} exact path="/profilRouter/profil"></Route>
                    <Route component={ObjaviSliku} exact path="/profilRouter/objavisliku"></Route>
                    <Route component={Search} exact path="/profilRouter/Profilsearch"></Route>
                </Switch>
            </BrowserRouter>
        </main>
    )
}

export default profilRouter;