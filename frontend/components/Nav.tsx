"use client";
import Link from "next/link";
const links = ["dashboard","modules","coding","mock-interview","analytics","weakness","company","tutor","settings"];
export default function Nav() {
  return <nav className="flex flex-wrap gap-3 py-4">{links.map((l)=><Link key={l} href={`/${l}`} className="text-sm px-3 py-1 bg-slate-800 rounded">{l}</Link>)}</nav>;
}
