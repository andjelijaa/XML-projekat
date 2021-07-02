import { Link } from 'react-router-dom';  


function Profil(){
    return(
        <main>
            <div className="background"></div>
            <nav className="flex flex-row justify-between items-center w-full text-center border border-12 p-4 border-blue-900 font-mono text-2xl bg-blue-400 text-white shadow-2xl">
                    <div>
                        <Link to="/" className="ml-24">
                            Home <i class="fa fa-home"></i>
                        </Link>
                        <Link to="/" className="mx-24">
                            Objavi sliku <i class="fa fa-image"></i>
                        </Link>
                    </div>
                    <div>
                        <Link to="/" className="mx-24">
                            Azuriranje <i class="fa fa-address-book"></i>
                        </Link>
                        <Link to="/" className="mr-24">
                            Odjava <i class="fa-solid fa-right"></i>
                        </Link>
                    </div>                  
            </nav>
            <nav className="flex flex-row justify-between items-center w-full text-center border border-12 p-4 border-blue-900 font-mono text-2xl bg-blue-400 text-white shadow-2xl">
                    <div>
                  
                        <Link to="/pretrage" className="mx-24">
                            Pretrage <i class="fa fa-search"></i>
                        </Link>
                        </div>
                        <div>
                        <Link to="/" className="mx-24">
                            Vidi svoje slike <i class="fa fa-image"></i>
                        </Link>
                 
                    </div>                  
            </nav>
            <div className=" flex flex-col justify-center items-center w-2/6 text-center margin">

            

               
            </div>
        </main>
    )
}

export default Profil;