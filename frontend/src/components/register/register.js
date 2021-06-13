function registracija(){
    return(
        <main className="flex w-screen h-screen justify-center items-center">
            <div className="background w-screen h-screen"></div>
            <form className="text-2xl font-bold flex flex-col border border-blue-900 shadown-2xl p-10 text-center">
                    <h1 className="font-mono text-3xl mb-16">Registracija</h1>
                    <label for="username">Korisnicko ime : </label>
                    <input className="border border-12 shadow-2xl my-3" name="username" type="text"></input>
                    <label for="username">Email : </label>
                    <input className="border border-12 shadow-2xl my-3" name="username" type="text"></input>
                    <label for="username">Lozinka : </label>
                    <input className="border border-12 shadow-2xl my-3" name="username" type="text"></input>
                    <label for="username">Ponovi lozinku : </label>
                    <input className="border border-12 shadow-2xl my-3" name="username" type="text"></input>
                    <button className="border border-12 border-white text-white my-12 text-3xl" type="submit">Potvrdi</button>
             </form>
        </main>
    )
}

export default registracija;