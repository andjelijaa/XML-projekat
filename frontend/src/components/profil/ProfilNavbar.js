import { Link } from 'react-router-dom';  


function ProfilNavBar(){
    return(
        <main>
            <div className="background"></div>
            <nav className="flex flex-row justify-center items-center p-2 w-full text-center border border-12 border-blue-900 font-mono text-1xl bg-blue-400 text-white shadow-2xl">
                    <div className="mx-12 flex flex-row justify-center items-center text-center">
                        <Link to="/profilRouter/profil" className="ml-24">
                            Profil
                        </Link>
                        <i class="fa fa-home"></i>
                    </div>
                    <div className="mx-12 flex flex-row justify-center items-center text-center">
                        <Link to="/profilRouter/objavisliku">
                            Objavi sliku
                        </Link>
                        <i class="fa fa-image"></i>
                    </div>

                    <div className="mx-12 flex flex-row justify-center items-center  text-center">
                        <Link to="/profilRouter/Profilsearch"> 
                            Pretrage 
                        </Link>
                        <i className="fa fa-search"></i>
                    </div>

                    <div className="mx-12 flex flex-row justify-center items-center text-center">
                        <Link to="/profilRouter/vidisvojeslike" >
                            Vidi svoje slike
                        </Link>
                        <i className="fa fa-image"></i>
                    </div>     

                    <div className="mx-12 flex flex-row justify-center items-center  text-center">
                        <Link to="/profilRouter/azuriranje" >
                            Azuriranje 
                        </Link>
                        <i className="fa fa-address-book"></i>

                    </div>
                    <div className="mx-12 flex flex-row justify-center items-center  text-center">
                        <Link to="/" >
                            Odjava 
                        </Link>
                        <i className="fa fa-sign-out-alt"></i>
                    </div>           
                 
            </nav>             
        </main>
    )
}

export default ProfilNavBar;