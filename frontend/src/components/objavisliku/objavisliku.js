import {useEffect, useState} from 'react';
import axios from "axios";




function Objavisliku(){
    const [nazivfajla, setNazivfajla] = useState("");
    const [selectedFile, setSelectedFile] = useState(null);
    const [tag, setTag] = useState("");
    const [lokacija, setLokacija] = useState("");
    const [username, setUsername]= useState("");
    const [opis, setOpis] = useState("");

    useEffect(() => {
      const token = localStorage.getItem("token");
      const base64Url = token.split('.')[1];
      const base64 = base64Url.replace('-', '+').replace('_', '/');
      const wholeUser = JSON.parse(window.atob(base64))
      setUsername(wholeUser.sub);
  },[username, setUsername])


    const userData = JSON.stringify({
      "nazivfajla" : nazivfajla,
      "selectedFile" : selectedFile,
      "tag" : tag,
      "lokacija" : lokacija,
      "username" : username,
      "opis": opis
    })


  
    const handleTag = (e) => {
      setTag(e.target.value);
    }
    
   const handleUsername = (e) => {
    setUsername(e.target.value);
    }

    const handleLokacija = (e) => {
      setLokacija(e.target.value);
    }

    const handleOpis= (e) => {
      setOpis(e.target.value);
    }

    const handleRequest = (e) => {
      e.preventDefault();
      handleSubmit()
    }


    function handleSubmit(){
      axios.post('http://localhost:7876/slika/info', userData, {
        headers: {
           'content-type': 'application/json',
        },
        }).then(res => {
            if(res.status === 200){
              console.log("Uspesna postavljna slika");              
            }
    })
  }


    return(
    <main>
    <div>
      <form className="flex flex-col my-8 w-1/3">
        <input
          type="text"
    
          onChange={(e) => setNazivfajla(e.target.value)}
        />

        <input
          type="file"
          value={selectedFile}
          onChange={(e) => setSelectedFile(e.target.files[0])}
        />
         <label> Dodaj opis</label>
        <input onChange={handleOpis} name="opis" type="text" className="border border-16 shadow-2xl my-2"></input>
        <label> Dodaj tag</label>
        <input onChange={handleTag} name="tag" type="text" className="border border-16 shadow-2xl my-2"></input>
        <label>Dodaj lokaciju</label>
        <input onChange={handleLokacija} name="lokacija" type="text" className="border border-16 shadow-2xl my-2"></input>
        <button   onClick={handleRequest} type="submit" className="border border-12 border-black text-black my-12 text-2xl">Objavi</button>
      </form>
    </div>

    </main>
    )
}


export default Objavisliku;