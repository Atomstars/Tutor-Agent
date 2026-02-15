import "./globals.css";
import type { ReactNode } from "react";
export const metadata = { title: "Java Interview Trainer" };
export default function RootLayout({ children }: { children: ReactNode }) {
  return <html lang="en"><body className="max-w-6xl mx-auto px-4">{children}</body></html>;
}
