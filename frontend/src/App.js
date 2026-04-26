import React, { useState } from "react";
import axios from "axios";

function App(){
const [username,setUsername]=useState("");
const [password,setPassword]=useState("");
const [token,setToken]=useState("");
const [mood,setMood]=useState("");
const [tasks,setTasks]=useState([]);

const API="http://YOUR_EC2_IP:8080";

const login=async()=>{
const res=await axios.post(API+"/auth/login",{username,password});
setToken(res.data.token);
};

const fetchTasks=async()=>{
const res=await axios.get(API+"/tasks/"+mood);
setTasks(res.data);
};

return(
<div style={{padding:"20px",fontFamily:"Arial"}}>
<h1>MoodSync</h1>

<input placeholder="username" onChange={e=>setUsername(e.target.value)}/>
<input placeholder="password" type="password" onChange={e=>setPassword(e.target.value)}/>
<button onClick={login}>Login</button>

<br/><br/>

<select onChange={e=>setMood(e.target.value)}>
<option>Select Mood</option>
<option value="TIRED">😴</option>
<option value="FOCUSED">🔥</option>
</select>

<button onClick={fetchTasks}>Get Tasks</button>

<ul>
{tasks.map(t=><li key={t.id}>{t.title}</li>)}
</ul>
</div>
);
}

export default App;
