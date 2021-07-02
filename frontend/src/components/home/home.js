import { Link } from 'react-router-dom';
import biliGejtic from './images/biliGejtic.jpg';
import markoZukic from "./images/markoZukic.jpg";
import andjelaMerkalovic from "./images/andjelaMerkalovic.jpg";
import vojaSeselj from "./images/vojaSeselj.jpg";

const handleHeartClick = (e) => {
    e.target.style.color = "red";
}

function Home(){
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
                        <Link to="/profil" className="mx-24">
                            Profil <i class="fa fa-search"></i>
                        </Link>
                    </div>
                 
                    <div>
                        <Link to="/registracija" className="mx-24">
                            Registracija <i class="fa fa-address-book"></i>
                        </Link>
                        <Link to="/login" className="mr-24">
                            Login <i class="fa fa-share"></i>
                        </Link>
                    </div>                  
            </nav>
            <div className=" flex flex-col justify-center items-center w-2/6 text-center margin">

             

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Bili Gejtic</h1>
                    <img className="post-pick my-4" src={biliGejtic} alt="bili gejtic"></img>
                    <h3 className="my-4">#tb #oneyearago #vodka</h3>
                    <div className="flex justify-between text-center w-2/6 my-4">
                        <i onClick={handleHeartClick} class="fa fa-heart"></i>
                        <i class="fa fa-comment"></i>
                    </div>
                </div>

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Marko Zukic</h1>
                    <img className="post-pick my-4" src={markoZukic} alt="bili gejtic"></img>
                    <h3 className="my-4">#tb #lastnight #prom</h3>
                    <div className="flex justify-between text-center w-2/6 my-4">
                        <i onClick={handleHeartClick} class="fa fa-heart"></i>
                        <i class="fa fa-comment"></i>
                    </div>
                </div>

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Andjela Merkalovic</h1>
                    <img className="post-pick my-4" src={andjelaMerkalovic} alt="bili gejtic"></img>
                    <h3 className="my-4">#tb #germany #office</h3>
                    <div className="flex justify-between text-center w-2/6 my-4">
                        <i onClick={handleHeartClick} class="fa fa-heart"></i>
                        <i class="fa fa-comment"></i>
                    </div>
                </div>

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Voja Seselj</h1>
                    <img className="post-pick my-4" src={vojaSeselj} alt="bili gejtic"></img>
                    <h3 className="my-4">#uKandzamaKarlaDelPonte #win #Hag</h3>
                    <div className="flex justify-between text-center w-2/6 my-4">
                        <i onClick={handleHeartClick} class="fa fa-heart"></i>
                        <i class="fa fa-comment"></i>
                    </div>
                </div>

               
            </div>
        </main>
    )
}

export default Home;