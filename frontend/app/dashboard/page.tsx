"use client";
import { useEffect, useState } from "react";
import Nav from "@/components/Nav";
import api from "@/lib/api";
export default function Dashboard(){const [data,setData]=useState<any>();useEffect(()=>{api.get('/analytics/dashboard').then(r=>setData(r.data));},[]);
return <main><Nav/><h1 className="text-3xl mb-4">Dashboard</h1><div className="grid grid-cols-1 md:grid-cols-4 gap-3">{['readiness','accuracy','avgTime'].map(k=><div className="card" key={k}><p className="text-slate-400">{k}</p><p className="text-2xl">{data?.[k]?.toFixed?data[k].toFixed(1):data?.[k]??'-'}</p></div>)}<div className="card"><p>Weak Topics</p><ul>{data?.weakTopics?.map((w:string)=><li key={w}>• {w}</li>)}</ul></div></div></main>}
