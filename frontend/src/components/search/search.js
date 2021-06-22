function search(){
    return(
        <main>
           
            <h1 className="text-center text-black text-4xl my-12">Pretrage <i className="fa fa-search"></i></h1>
            <div className="flex flex-col justify-center items-center border border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl my-12">
                <select name="search-choice">
                    <option value="username">Username</option>
                    <option value="lokacija" selected>Lokacija</option>
                    <option value="tagovi">Tagovi</option>
                </select>

                <form>
                    <input className="text-center mt-28" placeholder="pretrazi" ></input>
                </form>
            </div>
        </main>

    )   
}

export default search;