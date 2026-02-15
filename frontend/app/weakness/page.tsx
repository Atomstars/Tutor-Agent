"use client";
import { useEffect, useState } from "react";
import Nav from "@/components/Nav";
import api from "@/lib/api";
export default function Weakness(){const [d,setD]=useState<any>();useEffect(()=>{api.get('/analytics/dashboard').then(r=>setD(r.data));},[]);
return <main><Nav/><h1 className="text-3xl mb-4">Weakness Analysis</h1><div className="card"><p>Weak concept heatmap (ranked)</p><ol>{d?.weakTopics?.map((w:string,i:number)=><li key={w}>{i+1}. {w}</li>)}</ol></div></main>}
