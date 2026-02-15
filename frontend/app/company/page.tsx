"use client";
import { useState } from "react";
import Nav from "@/components/Nav";
import api from "@/lib/api";
export default function Company(){const [company,setCompany]=useState('Google');const [res,setRes]=useState<any>();const run=async()=>{const {data}=await api.post('/company/focus',{company});setRes(data);};
return <main><Nav/><h1 className="text-3xl mb-4">Company-Specific Mode</h1><div className="card"><input className="p-2 bg-slate-800 w-full" value={company} onChange={e=>setCompany(e.target.value)}/><button className="btn mt-3" onClick={run}>Generate Focus Plan</button><pre className="mt-3">{JSON.stringify(res,null,2)}</pre></div></main>}
