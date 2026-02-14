"use client";
import { useEffect, useState } from "react";
import Nav from "@/components/Nav";
import Link from "next/link";
import api from "@/lib/api";
export default function Modules(){const [levels,setLevels]=useState<any[]>([]);useEffect(()=>{api.get('/levels').then(r=>setLevels(r.data));},[]);
return <main><Nav/><h1 className="text-3xl mb-4">Learning Modules</h1><div className="grid gap-3">{levels.map(l=><Link href={`/modules/${l.level}`} key={l.level} className="card"><p className="font-semibold">Level {l.level}: {l.title}</p><p>Completion: {l.completion}%</p></Link>)}</div></main>}
