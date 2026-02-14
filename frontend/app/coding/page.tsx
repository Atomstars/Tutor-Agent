"use client";
import { useMemo, useState } from "react";
import Editor from "@monaco-editor/react";
import Nav from "@/components/Nav";
import api from "@/lib/api";

export default function CodingPage(){
  const [code,setCode]=useState('public class Main { public static void main(String[] args){ System.out.println("PASS"); }}');
  const [result,setResult]=useState<any>();
  const [attempts,setAttempts]=useState(0);
  const start = useMemo(()=>Date.now(),[]);
  const elapsed = Math.floor((Date.now()-start)/1000);
  const run=async()=>{setAttempts(a=>a+1);const {data}=await api.post('/coding/run',{problemId:'two-sum-java',code});setResult(data);};
  return <main><Nav/><h1 className="text-3xl mb-4">Coding Practice</h1><p className="mb-2">Attempts: {attempts} | Timer: {elapsed}s</p><div className="card"><Editor height="320px" defaultLanguage="java" value={code} onChange={(v)=>setCode(v||"")}/><button className="btn mt-3" onClick={run}>Run</button><pre className="mt-3 text-sm bg-black p-3 rounded">{JSON.stringify(result,null,2)}</pre></div></main>
}
