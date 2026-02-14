"use client";
import { useEffect, useState } from "react";
import Nav from "@/components/Nav";
import api from "@/lib/api";

export default function Tutor() {
  const [mode, setMode] = useState("Normal");
  const [prompt, setPrompt] = useState("Explain HashMap internal working for interviews");
  const [history, setHistory] = useState<any[]>([]);
  const [res, setRes] = useState<any>();

  const load = async () => {
    const r = await api.get("/tutor/history");
    setHistory(r.data);
  };

  useEffect(() => {
    void load();
  }, []);

  const ask = async () => {
    const { data } = await api.post("/tutor/chat", { mode, prompt });
    setRes(data);
    await load();
  };

  return (
    <main>
      <Nav />
      <h1 className="text-3xl mb-4">AI Tutor</h1>
      <div className="grid md:grid-cols-2 gap-3">
        <div className="card">
          <select className="p-2 bg-slate-800 w-full" value={mode} onChange={(e) => setMode(e.target.value)}>
            {["Normal", "Revision", "Emergency", "Company"].map((m) => (
              <option key={m}>{m}</option>
            ))}
          </select>
          <textarea className="p-2 bg-slate-800 w-full h-40 mt-2" value={prompt} onChange={(e) => setPrompt(e.target.value)} />
          <button className="btn mt-3" onClick={ask}>Ask Tutor</button>
          <pre className="mt-3 text-xs">{JSON.stringify(res, null, 2)}</pre>
        </div>
        <div className="card">
          <h2>Conversation History</h2>
          <ul className="text-sm">
            {history.map((m: any) => (
              <li key={m.id}><b>{m.role}:</b> {m.content}</li>
            ))}
          </ul>
        </div>
      </div>
    </main>
  );
}
