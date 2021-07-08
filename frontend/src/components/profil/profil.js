import axios from "axios";

import {useEffect, useState} from 'react';

function Profil(){

    const [username, setUsername] = useState("");
    const [objave, setObjave] = useState([]);

    useEffect(() => {
        const token = localStorage.getItem("token");
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace('-', '+').replace('_', '/');
        const wholeUser = JSON.parse(window.atob(base64))
        setUsername(wholeUser.sub);
   


        const url = 'http://localhost:7876/slika/sveobjave';
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

    const handleHeartClick = (e) => {
        e.target.style.color = "red";
    }
    

    return (
        <main>


            <div className=" flex flex-col justify-center items-center w-2/6 text-center margin">
            <div className="w-full h-full text-2xl ">
        {objave.map(i => {
          return(
            <div className="flex flex-col text-2xl justify-center items-center list-none gap-12 mb-24 border  border-black border-bottom-2xl">
              <li>{i.opis}</li>
              <img src={'data:image/png;base64,'+i.kodSlike[0]} alt="slika"></img>
              <li>{i.hashtagovi}</li>
              <li>{i.lokacija}</li>
              <li className="fa fa-heart" onClick={handleHeartClick}> like </li>
              <li className="fa fa-comments mb-12">comment</li>
            </div>
        )
      })}
        </div>
        </div>
        </main>

    )
}

export default Profil;