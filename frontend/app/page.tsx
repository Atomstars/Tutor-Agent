import Link from "next/link";
export default function Home() {
  return <main className="py-16"><h1 className="text-4xl font-bold">Java Interview Training Platform</h1><p className="mt-4 text-slate-300">AI-powered private preparation system for aggressive interview readiness.</p><div className="mt-6 flex gap-3"><Link href="/register" className="btn">Get Started</Link><Link href="/login" className="px-4 py-2 rounded-lg bg-slate-700">Login</Link></div></main>;
}
