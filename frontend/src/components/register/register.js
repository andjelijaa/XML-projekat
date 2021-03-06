import axios from "axios";
import { useState } from "react";


function Registracija(){

    const [ime, setIme] = useState("");
    const [prezime, setPrezime] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");


    const userData = JSON.stringify({
      "ime" : ime,
      "prezime" : prezime,
      "email" : email,
      "password" : password,
      "username" : username
    })
   

    
    const handleIme = (e) => {
      setIme(e.target.value);
    }

    const handlePrezime = (e) => {
      setPrezime(e.target.value);
    }
  
    const handleEmail = (e) => {
      setEmail(e.target.value);
    }
    
    const handleUsername = (e) => {
      setUsername(e.target.value);
    }

    const handlePassword = (e) => {
      setPassword(e.target.value);
    }

    const handleRequest = (e) => {
      e.preventDefault();
      handleSubmit()
      window.location.replace("http://localhost:3000/login")
    }

    function handleSubmit(){
      axios.post('http://localhost:7879/profilRegistrovanog/add', userData, {
        headers: {
           'content-type': 'application/json',
        },
        }).then(res => {
            if(res.status === 200){
              console.log("Uspesna registracija");
              setTimeout(handleSubmit, 2000);
             
            }
    })
  }

    return(
        <main className="flex w-screen h-screen justify-center items-center">
            <div className="background w-screen h-screen"></div>
            <form className="text-2xl font-bold flex flex-col border border-blue-900 shadown-2xl p-10 text-center">
                    <h1 className="font-mono text-3xl mb-16">Registracija</h1>
                    <label htmlFor="ime">Ime : </label>
                    <input onChange={handleIme} autoComplete="" className="border border-12 shadow-2xl my-2" name="ime" type="text"></input>
                    <label htmlFor="prezime">Prezime : </label>
                    <input onChange={handlePrezime} autoComplete="" className="border border-12 shadow-2xl my-2" name="prezime" type="text"></input>
                    <label htmlFor="username">Korisnicko ime : </label>
                    <input onChange={handleUsername} autoComplete="" className="border border-12 shadow-2xl my-2" name="username" type="text"></input>
                    <label htmlFor="email">Email : </label>
                    <input onChange={handleEmail} autoComplete="" className="border border-12 shadow-2xl my-2" name="email" type="email"></input>
                    <label htmlFor="password">Lozinka : </label>
                    <input onChange={handlePassword} autoComplete="" className="border border-12 shadow-2xl my-2" name="password" type="password"></input>
                    <button onClick={handleRequest} className="border border-12 border-white text-white my-12 text-3xl" type="button">Potvrdi</button>
             </form>
        </main>
    )
}

export default Registracija;