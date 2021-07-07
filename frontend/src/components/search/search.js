import {useState} from 'react';
import axios from "axios";



function Search(){


    const [objave, setObjave] = useState([]);
    const [select,setSelect]=useState("");
    const [search,setSearch]=useState("");

    const handleRequest = (e) => {
        e.preventDefault();
        handleSubmit()
        
 
      }

    const handleInput=(e)=>{
        setSearch(e.target.value)

    }

    const handleSelect =(e)=>{
        alert(select);
        setSelect(e.target.value);
       
    }

    function handleSubmit(){
      alert("Uslo je ovde");
     /*   if(select==="lokacija") { setUrl('http://localhost:7876/slika/pretragalokacija');}
     //   else if(select==="username"){const url = 'http://localhost:7876/slikaprofil/'+select;}
        else if (select==="tagovi"){setUrl('http://localhost:7876/slika/pretragatag');}
        axios.get(url,search,{
         headers: {
               'content-type': 'application/json',
            },
            
          }).then(res => {
              if(res.status === 200){
                setObjave(res.data);
                console.log(res.data);
              }
            }
          )*/
         
        if(select==="username"){
         
            const url = 'http://localhost:7876/slika/profil/'+search;
            
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
        }  
        else if(select==="lokacija"){
            const url = 'http://localhost:7876/slika/pretragalokacija';
            alert(url);
            axios.get(url,search,{
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
        }
        else if(select==="takovi"){
            const url = 'http://localhost:7876/slika/pretragatag';
            alert(url);
            axios.get(url,search,{
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
        }

        }

    
    





    return(
        <main>
           
            <h1 className="text-center text-black text-4xl my-12">Pretrage <i className="fa fa-search"></i></h1>
            <div className="flex flex-col justify-center items-center border border-12 border-blue-900 p-12 font-mono text-2xl text-blue-900 shadow-2xl my-12">
                <select onChange={handleSelect} name="search-choice">
                    <option value="username">Username</option>
                    <option value="lokacija">Lokacija</option>
                    <option value="tagovi">Tagovi</option>
                </select>

                <form className="flex flex-col gap-16">
                    <input className="text-center mt-28 w-full" onChange={handleInput} placeholder="unesite pretragu" ></input>
                    <button className="text-center text-3xl" onClick={handleRequest} type="button">Submit</button>
                </form>
            </div>
            <div className="w-full h-full text-2xl ">
            {objave.map(i => {
            return(
                <div className="flex flex-col text-2xl justify-center items-center list-none gap-12 mb-32">
                <li>{i.opis}</li>
                <img src={'data:image/png;base64,'+i.kodSlike[0]} alt="slika"></img>
                <li>{i.hashtagovi[i.hashtagovi.length-1].nazivhashtaga}</li>
                <li>{i.lokacija.name}</li>
                
                </div>
        )
      })}

        </div>
        </main>

    )   
}

export default Search;