import { Link } from 'react-router-dom';


const handleHeartClick = (e) => {
    e.target.style.color = "red";
}

function Vidisvojeslike(){
    return(
        <main>
            <div className="background"></div>
            <nav className="flex flex-row justify-between items-center w-full text-center border border-12 p-4 border-blue-900 font-mono text-2xl bg-blue-400 text-white shadow-2xl">
                    <div>
                        <Link to="/" className="ml-24">
                            Home <i class="fa fa-home"></i>
                        </Link>
                        <Link to="/pretrage" className="mx-24">
                            Pretrage <i class="fa fa-search"></i>
                        </Link>
                        <Link to="/" className="mx-24">
                            Objavi sliku <i class="fa fa-image"></i>
                        </Link>

                    </div>
                 
                    <div>
                       <Link to="/pretrage" className="mx-24">
                            Pretrage <i class="fa fa-search"></i>
                        </Link>
                        <Link to="/profil" className="mx-24">
                            Vrati se nazad <i class="fa fa-left"></i>
                        </Link>

                    </div>                  
            </nav>
      
        </main>
    )
}

export default Vidisvojeslike;