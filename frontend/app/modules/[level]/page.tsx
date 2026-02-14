import Nav from "@/components/Nav";
const topics = ["Theory","Real-world explanation","Interview Q&A","Coding problems","Difficulty progression","Completion tracking"];
export default function LevelPage({params}:{params:{level:string}}){return <main><Nav/><h1 className="text-3xl mb-4">Level {params.level}</h1><div className="grid md:grid-cols-2 gap-3">{topics.map(t=><section key={t} className="card"><h2 className="font-semibold">{t}</h2><p className="text-slate-300">Structured content for level {params.level} with production-focused interview preparation.</p></section>)}</div></main>}
