import axios from "axios";
import { useState } from "react";

function Login(){

    


    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleUsername = (e) => {
        setUsername(e.target.value)
    }

    const handlePassword = (e) => {
        setPassword(e.target.value);
    }

    function handleSubmit(){
       
          axios.post("http://localhost:2222/autentikacija-api/login", username, password)
            .then(res => console.log(res.data));

        
    }


    return(
        <main className="flex w-screen h-screen justify-center items-center">
            <div className="background w-screen h-screen"></div>
            <form className="text-2xl font-bold flex flex-col border border-blue-900 shadown-2xl p-10 text-center">
                    <h1 className="font-mono text-3xl mb-16">Login</h1>
                    <label for="username">Korisnicko ime : </label>
                    <input onChange={handleUsername} className="border border-12 shadow-2xl my-3" name="username" type="text"></input>
                    <label for="password">Lozinka : </label>
                    <input onChange={handlePassword} className="border border-12 shadow-2xl my-3" name="password" type="text"></input>    
                    <button onClick={handleSubmit} className="border border-12 border-white text-white my-12 text-3xl" type="submit">Potvrdi</button>
             </form>
        </main>
    )
}

export default Login;