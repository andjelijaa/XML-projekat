import { Link } from 'react-router-dom';  
import {useEffect, useState} from 'react';

function ProfilNavBar(){

    const [username, setUsername] = useState("");

    const handleOdjava = () => {
        localStorage.clear();
        window.location.replace("http://localhost:3000/login");
    }


    useEffect(() => {
        const token = localStorage.getItem("token");
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace('-', '+').replace('_', '/');
        const wholeUser = JSON.parse(window.atob(base64))
        setUsername(wholeUser.sub);
    },[username, setUsername])

    return(
        <main>
            <div className="background"></div>
            <nav className="flex flex-row justify-center items-center p-2 w-full text-center border border-12 border-blue-900 font-mono text-1xl bg-blue-400 text-white shadow-2xl">
                    <div className="mx-12 flex flex-row justify-center items-center text-center">
                        <Link to={"/"+username+"/profil"} className="ml-24">
                            Profil
                        </Link>
                        <i className="fa fa-home"></i>
                    </div>
                    <div className="mx-12 flex flex-row justify-center items-center text-center">
                        <Link to={"/"+username+"/objavisliku"}>
                            Objavi sliku
                        </Link>
                        <i className="fa fa-image"></i>
                    </div>

                    <div className="mx-12 flex flex-row justify-center items-center  text-center">
                        <Link to={"/"+username+"/Profilsearch"}> 
                            Pretrage 
                        </Link>
                        <i className="fa fa-search"></i>
                    </div>

                    <div className="mx-12 flex flex-row justify-center items-center text-center">
                        <Link to={"/"+username+"/vidisvojeslike"} >
                            Vidi svoje slike
                        </Link>
                        <i className="fa fa-image"></i>
                    </div>     

                    <div className="mx-12 flex flex-row justify-center items-center  text-center">
                        <Link to={"/"+username+"/azuriranje"}>
                            Azuriranje 
                        </Link>
                        <i className="fa fa-address-book"></i>

                    </div>
                    <div className="mx-12 flex flex-row justify-center items-center  text-center">
                     <button onClick={handleOdjava}>
                         Odjava
                     </button>
                        
                        <i className="fa fa-sign-out-alt"></i>
                    </div>           
                 
            </nav>             
        </main>
    )
}

export default ProfilNavBar;