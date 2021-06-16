import axios from "axios";
import { useState } from "react";



function registracija(){

    function handleSubmit(){
      axios({
        method: 'post',
        url: 'http://localhost:7878',
        data: {
          ime: {ime},
          prezime: {prezime},
          username:{username},
          email: {email},
          password: {password},
        }
      });
    }

    const [ime, setIme] = useState("");
    const [prezime, setPrezime] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");

    const 
    handleIme = (e) => {
      setIme(e.target.value);
    }

    const
    handlePrezime = (e) => {
      setPrezime(e.target.value);
    }
  
    const 
    handleEmail = (e) => {
      setEmail(e.target.value);
    }
    
    const
    handleUsername = (e) => {
      setUsername(e.target.value);
    }

    const 
    handlePassword = (e) => {
      setPassword(e.target.value);
    }

    return(
        <main className="flex w-screen h-screen justify-center items-center">
            <div className="background w-screen h-screen"></div>
            <form className="text-2xl font-bold flex flex-col border border-blue-900 shadown-2xl p-10 text-center">
                    <h1 className="font-mono text-3xl mb-16">Registracija</h1>
                    <label for="ime">Ime : </label>
                    <input onChange={handleIme} className="border border-12 shadow-2xl my-3" name="ime" type="text"></input>
                    <label for="prezime">Prezime : </label>
                    <input onChange={handlePrezime} className="border border-12 shadow-2xl my-3" name="prezime" type="text"></input>
                    <label for="username">Korisnicko ime : </label>
                    <input onChange={handleUsername} className="border border-12 shadow-2xl my-3" name="username" type="text"></input>
                    <label for="email">Email : </label>
                    <input onChange={handleEmail} className="border border-12 shadow-2xl my-3" name="email" type="email"></input>
                    <label for="password">Lozinka : </label>
                    <input onChange={handlePassword} className="border border-12 shadow-2xl my-3" name="password" type="password"></input>
                    <label for="repeat-password">Ponovi lozinku : </label>
                    <input className="border border-12 shadow-2xl my-3" name="repeat-password" type="password"></input>
                    <button onClick={handleSubmit} className="border border-12 border-white text-white my-12 text-3xl" type="submit">Potvrdi</button>
                    
             </form>
        </main>
    )
}

export default registracija;