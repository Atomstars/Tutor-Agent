"use client";
import { useState } from "react";
import Nav from "@/components/Nav";
import api from "@/lib/api";
export default function MockPage(){const [company,setCompany]=useState('Amazon');const [answer,setAnswer]=useState('');const [res,setRes]=useState<any>();
const submit=async()=>{const {data}=await api.post('/mock/submit',{company,answers:[answer]});setRes(data);};
return <main><Nav/><h1 className="text-3xl mb-4">Mock Interview</h1><div className="card"><input className="p-2 bg-slate-800 w-full mb-2" value={company} onChange={e=>setCompany(e.target.value)} placeholder="Company"/><textarea className="p-2 bg-slate-800 w-full h-36" value={answer} onChange={e=>setAnswer(e.target.value)} placeholder="Answer"/><button className="btn mt-3" onClick={submit}>Evaluate</button><pre className="mt-3">{JSON.stringify(res,null,2)}</pre></div></main>}
