
import {useEffect, useState} from 'react';
import axios from "axios";


function Vidisvojeslike(){

    const [username,setUsername]=useState("");
    const [objave, setObjave] = useState([]);

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
        renderObjave();
      }

    const renderObjave = () => {
      return null;
    }   

    function handleSubmit(){
        const url = 'http://localhost:7876/slika/profil/'+username;
        axios.get(url,{
        headers: {
           'content-type': 'application/json',
        },
        
      }).then(res => {
          if(res.status === 200){
            setObjave(res.data);
            console.log(res.data);
          }
        }
      )
    }
    
 
    return(
        <main>
            <div className="background"></div>
             <button onClick={handleRequest} className="border border-12 border-black text-black my-12 text-3xl" type="button">Prikazi slike</button>
        <div className="w-full h-full text-2xl ">
        {objave.map(i => {
          return(
            <div className="flex flex-col text-2xl justify-center items-center list-none gap-12">
              <li>{i.opis}</li>
              <img src={'data:image/png;base64,'+i.kodSlike[0]} alt="slika"></img>
              <li>{i.hashtagovi[i.hashtagovi.length-1].nazivhashtaga}</li>
              <li>{i.lokacija.name}</li>
            </div>
        )
      })}

        </div>
        </main>

    )
}

export default Vidisvojeslike;
