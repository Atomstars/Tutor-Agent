"use client";
import { useEffect, useState } from "react";
import Nav from "@/components/Nav";
import { LineChart, Line, XAxis, YAxis, Tooltip, ResponsiveContainer } from "recharts";
import api from "@/lib/api";
export default function Analytics(){const [d,setD]=useState<any>();useEffect(()=>{api.get('/analytics/dashboard').then(r=>setD(r.data));},[]);
const trend=[{day:'Mon',score:55},{day:'Tue',score:60},{day:'Wed',score:68},{day:'Thu',score:d?.readiness||72}];
return <main><Nav/><h1 className="text-3xl mb-4">Performance Analytics</h1><div className="card h-72"><ResponsiveContainer width="100%" height="100%"><LineChart data={trend}><XAxis dataKey="day"/><YAxis/><Tooltip/><Line dataKey="score" stroke="#10b981"/></LineChart></ResponsiveContainer></div></main>}
