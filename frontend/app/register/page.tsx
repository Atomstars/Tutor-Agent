"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import api from "@/lib/api";
export default function RegisterPage(){const [fullName,setName]=useState("");const [email,setEmail]=useState("");const [password,setPassword]=useState("");const r=useRouter();
const submit=async()=>{const {data}=await api.post('/auth/register',{fullName,email,password});localStorage.setItem('token',data.token);r.push('/dashboard');};
return <main className="py-10 card max-w-md"><h1 className="text-2xl mb-4">Register</h1><input className="w-full mb-2 p-2 bg-slate-800" placeholder="Full name" value={fullName} onChange={e=>setName(e.target.value)}/><input className="w-full mb-2 p-2 bg-slate-800" placeholder="Email" value={email} onChange={e=>setEmail(e.target.value)}/><input type="password" className="w-full mb-2 p-2 bg-slate-800" placeholder="Password" value={password} onChange={e=>setPassword(e.target.value)}/><button className="btn" onClick={submit}>Create account</button></main>}
