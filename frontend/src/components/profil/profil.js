import axios from "axios";

import {useEffect, useState} from 'react';

function Profil(){

    const [username, setUsername] = useState("");
    const [objave, setObjave] = useState([]);
    const [comment, setComment] = useState("");
    const [sakriveno, setSakriveno] = useState(true);

    useEffect(() => {


        const token = localStorage.getItem("token");
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace('-', '+').replace('_', '/');
        const wholeUser = JSON.parse(window.atob(base64))
        setUsername(wholeUser.sub);
   

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
    },[username, setUsername])

    const handleHeartClick = (e) => {
        e.target.style.color = "red";
    }
    
    const handleComment = (e) => {
      setComment(e.target.value);
    }

    const openComment = () => {
      setSakriveno(false);
    }


    const sendComment = (id) => {
      const url = "http://localhost:7876/komentar/kreiraj";
      const data = {
        "objavaID" : id,
        "text" : comment,
        "username" : username
      }
      axios.post()


    }

    return (
        <main>

            <div className=" flex flex-col justify-center items-center w-2/6 text-center margin">
            <div className="w-full h-full text-2xl ">
        {objave.map(i => {
          return(
            <div className="flex flex-col text-2xl justify-center items-center list-none gap-12 mb-24 border  border-black border-bottom-2xl">
              <li>{i.opis}</li>
              <img src={'data:image/png;base64,'+i.kodSlike[0]} alt="slika"></img>
              <li>#{i.hashtagovi}</li>
              <li>{i.lokacija}</li>
              <li className="fa fa-heart" onClick={handleHeartClick}> like </li>
              <li className="fa fa-comments mb-12" onClick={openComment}>comment</li>
              <div className={sakriveno ? "hidden" : "visible my-12"}>
                <input type="text" className="border border-blue-700 mx-4" onChange={handleComment}></input>
                <button type="button" onClick={sendComment(i.id)}>posalji komentar</button>
              </div>
            </div>
        )
      })}
        </div>
        </div>
        </main>

    )
}

export default Profil;