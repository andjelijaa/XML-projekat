import {useEffect, useState} from 'react';
import axios from "axios";


function Vidisvojeslike(){

    const [objava,setObjava]=useState();
    const [sveObjava,setSveObjava]=useState();
    const [username,setUsername]=useState("");

    useEffect(() => {
        const token = localStorage.getItem("token");
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace('-', '+').replace('_', '/');
        const wholeUser = JSON.parse(window.atob(base64))
        setUsername(wholeUser.sub);
    },[username, setUsername])
  

    const handleRequest = (e) => {
        e.preventDefault();
        handleSubmit()
      }
  
      
    function handleSubmit(){
        const url = 'http://localhost:7876/slika/profil/'+username;
        axios.get(url,{
        headers: {
           'content-type': 'application/json',
        },
        
      }).then(res => {
          if(res.status === 200){

            setObjava(res.data[0]);
            console.log(res.data);
            const sveObjave=objava.map(i => <li>
                <li>i.nazivFajla </li>
                <li>i.opis </li>
                <li>i.tagovi</li>
                <li>i.lokacija </li>
        
                </li>    );
                setSveObjava(sveObjave);
           // console.log("Uspesan pregled slika profila");
          }
        }
      )
    }
    
 
    return(
        <main>
            <div className="background"></div>
             <button onClick={handleRequest} className="border border-12 border-black text-black my-12 text-3xl" type="button">Prikazi slike</button>
       <div>
           {sveObjava}
           </div>     
      
        </main>
    )
}

export default Vidisvojeslike;