import axios from "axios";
import React, { useState } from "react";

function Login(){

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    

    const userData = JSON.stringify({
        "password" : password,
        "username" : username
      })

    const handleUsername = (e) => {
        setUsername(e.target.value)
    }

    const handlePassword = (e) => {
        setPassword(e.target.value);
    }

    const handleRequest = (e) => {
      e.preventDefault();
      handleSubmit();
      setTimeout(function(){
          window.location.replace("http://localhost:3000/profilRouter/profil");
      }, 2000);
    }


    function handleSubmit(){
        axios.post('http://localhost:7879/profilRegistrovanog/login', userData, {
          headers: {
             'content-type': 'application/json',
          },
          
        }).then(res => {
            if(res.status === 200){
              localStorage.setItem("token", res.data);
              console.log("Uspesan login");
            }
          }
        )
     
      }

    
     return(
        <main className="flex w-screen h-screen justify-center items-center">
            <div className="background w-screen h-screen"></div>
            <form className="text-2xl font-bold flex flex-col border border-blue-900 shadown-2xl p-10 text-center">
                    <h1 className="font-mono text-3xl mb-16">Login</h1>
                    <label htmlFor="username">Korisnicko ime : </label>
                    <input onChange={handleUsername} className="border border-12 shadow-2xl my-3" name="username" type="text"></input>
                    <label htmlFor="password">Lozinka : </label>
                    <input type="password" onChange={handlePassword} className="border border-12 shadow-2xl my-3" name="password" ></input>    
             </form>
             <button onClick={handleRequest} className="border border-12 border-white text-white my-12 text-3xl" type="button">Potvrdi</button>
        </main>
    )
}

export default Login;