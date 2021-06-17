import axios from "axios";
import { useState } from "react";



function Registracija(){

    

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

    function handleSubmit(){
      
      axios.post("http://localhost:2222/autentikacija-api/add", ime, prezime, username, email, password)
      .then(res => console.log(res.data));
    }

    return(
        <main className="flex w-screen h-screen justify-center items-center">
            <div className="background w-screen h-screen"></div>
            <form className="text-2xl font-bold flex flex-col border border-blue-900 shadown-2xl p-10 text-center">
                    <h1 className="font-mono text-3xl mb-16">Registracija</h1>
                    <label htmlFor="ime">Ime : </label>
                    <input onChange={handleIme} className="border border-12 shadow-2xl my-2" name="ime" type="text"></input>
                    <label htmlFor="prezime">Prezime : </label>
                    <input onChange={handlePrezime} className="border border-12 shadow-2xl my-2" name="prezime" type="text"></input>
                    <label htmlFor="username">Korisnicko ime : </label>
                    <input onChange={handleUsername} className="border border-12 shadow-2xl my-2" name="username" type="text"></input>
                    <label htmlFor="email">Email : </label>
                    <input onChange={handleEmail} className="border border-12 shadow-2xl my-2" name="email" type="email"></input>
                    <label htmlFor="password">Lozinka : </label>
                    <input onChange={handlePassword} className="border border-12 shadow-2xl my-2" name="password" type="password"></input>
                    <button onClick={handleSubmit} className="border border-12 border-white text-white my-12 text-3xl" type="submit">Potvrdi</button>
                    
             </form>
        </main>
    )
}

export default Registracija;