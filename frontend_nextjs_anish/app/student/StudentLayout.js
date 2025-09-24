// app/student/StudentLayout.js

"use client";

import { useState } from "react";
import StudentSidebar from "@/components/StudentSidebar";

export default function StudentLayout({ children }) {
  const [sidebarOpen, setSidebarOpen] = useState(false);

  return (
    <div className="flex min-h-screen bg-background/70 dark:bg-background/80">
      {/* Sidebar */}
      <StudentSidebar
        sidebarOpen={sidebarOpen}
        setSidebarOpen={setSidebarOpen}
      />

      {/* Mobile overlay */}
      {sidebarOpen && (
        <div
          className="fixed inset-0 bg-black/40 z-40 md:hidden"
          onClick={() => setSidebarOpen(false)}
        />
      )}

      {/* Main Content */}
      <main className="flex-1 p-6 md:ml-64">{children}</main>
    </div>
  );
}
