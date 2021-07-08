import {useEffect, useState} from 'react';
import axios from "axios";
import {Link} from 'react-router-dom';

function Home(){
    const [objave, setObjave] = useState([]);

    useEffect(() => {
        const url = 'http://localhost:7876/slika/sveobjave';
        axios.get(url,{
        headers: {
           'content-type': 'application/json',
        },
        
      }).then(res => {
          if(res.status === 200){
            setObjave(res.data);
            console.log(res.data);
          }
        }
      )
    },[])
    
    return(
        <main>
            <nav className="flex flex-row justify-between items-center w-full text-center border border-12 p-4 border-blue-900 font-mono text-2xl bg-blue-400 text-white shadow-2xl">
                    <div>
                        <Link to="/" className="ml-24">
                            Home <i className="fa fa-home"></i>
                        </Link>
                        <Link to="/pretrage" className="mx-24">
                            Pretrage <i className="fa fa-search"></i>
                        </Link>

                    </div>

                    <div>
                        <Link to="/registracija" className="mx-24">
                            Registracija <i className="fa fa-address-book"></i>
                        </Link>
                        <Link to="/login" className="mr-24">
                            Login <i className="fa fa-share"></i>
                        </Link>
                    </div>
            </nav>
            <div className="w-full h-full text-2xl ">
        {objave.map(i => {
          return(
            <div className="my-16 flex flex-col text-2xl justify-center items-center list-none gap-12 mb-24 border  border-black border-bottom-2xl">
              <li>{i.opis}</li>
              <img src={'data:image/png;base64,'+i.kodSlike[0]} alt="slika"></img>
              <li>{i.hashtagovi}</li>
              <li>{i.lokacija}</li>
              
            </div>
        )
      })}

        </div>
        </main>
    )
}

export default Home;