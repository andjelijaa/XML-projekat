
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
    },[username, setUsername])
  
   

    
 
    return(
        <main>
            <div className="background"></div>
        <div className="w-full h-full text-2xl ">
        {objave.map(i => {
          return(
            <div className="flex flex-col text-2xl justify-center items-center list-none gap-12 mb-24 border  border-black border-bottom-2xl">
              <li>{i.opis}</li>
              <img src={'data:image/png;base64,'+i.kodSlike[0]} alt="slika"></img>
              <li>#{i.hashtagovi}</li>
              <li>{i.lokacija}</li>

            </div>
        )
      })}

        </div>
        </main>

    )
}

export default Vidisvojeslike;
