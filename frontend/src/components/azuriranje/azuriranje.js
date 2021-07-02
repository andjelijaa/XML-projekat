
function Azuriranje(){

    return(
        <main className="flex w-screen h-screen justify-center items-center">
            <div className="background w-screen h-screen"></div>
            <form className="text-2xl font-bold flex flex-col border border-blue-900 shadown-2xl p-10 text-center">
                    <h1 className="font-mono text-3xl mb-16">Azuriranje</h1>
                    <label htmlFor="ime">Ime : </label>
                    <input className="border border-12 shadow-2xl my-2" name="ime" type="text"></input>
                    <label htmlFor="prezime">Prezime : </label>
                    <input className="border border-12 shadow-2xl my-2" name="prezime" type="text"></input>
                    <label htmlFor="username">Korisnicko ime : </label>
                    <input className="border border-12 shadow-2xl my-2" name="username" type="text"></input>
                    <label htmlFor="password">Lozinka : </label>
                    <input className="border border-12 shadow-2xl my-2" name="password" type="password"></input>
                    <button className="border border-12 border-white text-white my-12 text-3xl" type="submit">Potvrdi</button>
             </form>
        </main>
    )
}

export default Azuriranje;