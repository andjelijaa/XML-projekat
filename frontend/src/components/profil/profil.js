import biliGejtic from "../home/images/biliGejtic.jpg";
import markoZukic from "../home/images/markoZukic.jpg";
import andjelaMerkalovic from "../home/images/andjelaMerkalovic.jpg";
import vojaSeselj from "../home/images/vojaSeselj.jpg";
import {useEffect, useState} from 'react';

function Profil(){

    const [username, setUsername] = useState("");

    useEffect(() => {
        const token = localStorage.getItem("token");
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace('-', '+').replace('_', '/');
        const wholeUser = JSON.parse(window.atob(base64))
        setUsername(wholeUser.sub);
    },[username, setUsername])

    return (
        <main>


            <div className=" flex flex-col justify-center items-center w-2/6 text-center margin">

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Uspesno ste se ulogovali, {username}</h1>
                </div>

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Bili Gejtic</h1>
                    <img className="post-pick my-4" src={biliGejtic} alt="bili gejtic"></img>
                    <h3 className="my-4">#tb #oneyearago #vodka</h3>
                    <div className="flex justify-between text-center w-2/6 my-4">
                        <i className="fa fa-heart"></i>
                        <i className="fa fa-comment"></i>
                    </div>
                </div>

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Marko Zukic</h1>
                    <img className="post-pick my-4" src={markoZukic} alt="bili gejtic"></img>
                    <h3 className="my-4">#tb #lastnight #prom</h3>
                    <div className="flex justify-between text-center w-2/6 my-4">
                        <i className="fa fa-heart"></i>
                        <i className="fa fa-comment"></i>
                    </div>
                </div>

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Andjela Merkalovic</h1>
                    <img className="post-pick my-4" src={andjelaMerkalovic} alt="bili gejtic"></img>
                    <h3 className="my-4">#tb #germany #office</h3>
                    <div className="flex justify-between text-center w-2/6 my-4">
                        <i className="fa fa-heart"></i>
                        <i className="fa fa-comment"></i>
                    </div>
                </div>

                <div className="flex flex-col justify-center items-center border w-full border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl bg-white my-12">
                    <h1 className="my-4">Voja Seselj</h1>
                    <img className="post-pick my-4" src={vojaSeselj} alt="bili gejtic"></img>
                    <h3 className="my-4">#uKandzamaKarlaDelPonte #win #Hag</h3>
                    <div className="flex justify-between text-center w-2/6 my-4">
                        <i className="fa fa-heart"></i>
                        <i className="fa fa-comment"></i>
                    </div>
                </div>

            </div>
        </main>

    )
}

export default Profil;