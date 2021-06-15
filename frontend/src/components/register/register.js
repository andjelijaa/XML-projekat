import axios from "axios";



function registracija(){
      axios({
        method: 'post',
        url: 'http://localhost:7878',
        data: {
          ime: 'Finn',
          prezime: 'Williams',
          username:'user',
          email:'ema',
          password:'pass',
          repeatPassword:'pass1'

        }
      });


    return(
        <main className="flex w-screen h-screen justify-center items-center">
            <div className="background w-screen h-screen"></div>
            <form className="text-2xl font-bold flex flex-col border border-blue-900 shadown-2xl p-10 text-center">
                    <h1 className="font-mono text-3xl mb-16">Registracija</h1>
                    <label for="username">Korisnicko ime : </label>
                    <input className="border border-12 shadow-2xl my-3" name="username" type="text"></input>
                    <label for="email">Email : </label>
                    <input className="border border-12 shadow-2xl my-3" name="email" type="email"></input>
                    <label for="password">Lozinka : </label>
                    <input className="border border-12 shadow-2xl my-3" name="password" type="password"></input>
                    <label for="repeat-password">Ponovi lozinku : </label>
                    <input className="border border-12 shadow-2xl my-3" name="repeat-password" type="password"></input>
                    <button className="border border-12 border-white text-white my-12 text-3xl" type="submit">Potvrdi</button>
             </form>
        </main>
    )
}

export default registracija;