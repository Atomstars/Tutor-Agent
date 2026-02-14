"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import api from "@/lib/api";
export default function LoginPage(){const [email,setEmail]=useState("");const [password,setPassword]=useState("");const [error,setError]=useState("");const r=useRouter();
const submit=async()=>{try{const {data}=await api.post('/auth/login',{email,password});localStorage.setItem('token',data.token);r.push('/dashboard');}catch(e:any){setError(e?.response?.data?.error||'Login failed');}};
return <main className="py-10 card max-w-md"><h1 className="text-2xl mb-4">Login</h1><input className="w-full mb-2 p-2 bg-slate-800" placeholder="Email" value={email} onChange={e=>setEmail(e.target.value)}/><input type="password" className="w-full mb-2 p-2 bg-slate-800" placeholder="Password" value={password} onChange={e=>setPassword(e.target.value)}/><button className="btn" onClick={submit}>Login</button><p className="text-red-400 mt-2">{error}</p></main>}
