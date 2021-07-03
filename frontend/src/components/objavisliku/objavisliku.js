import React, { useState } from "react";

function Objavisliku(){
    const [name, setName] = useState("");
    const [selectedFile, setSelectedFile] = useState(null);
    return(
    <main>
    <div>
      <form className="flex flex-col my-8 w-1/3">
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <input
          type="file"
          value={selectedFile}
          onChange={(e) => setSelectedFile(e.target.files[0])}
        />
        <label> Dodaj tag</label>
        <input name="tag" type="text" className="border border-16 shadow-2xl my-2"></input>
        <label>Dodaj lokaciju</label>
        <input name="lokacija" type="text" className="border border-16 shadow-2xl my-2"></input>
        <button type="submit" className="border border-12 border-black text-black my-12 text-2xl">Objavi</button>
      </form>
    </div>

    </main>
    )
}


export default Objavisliku;