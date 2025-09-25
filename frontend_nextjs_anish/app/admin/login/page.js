// app/admin/login/page.js

"use client";

import LoginForm from "@/components/LoginForm"; // import your existing login component
import { useRouter } from "next/navigation";

export default function AdminLoginPage() {
  const router = useRouter();

  const handleLoginSuccess = (user) => {
    // You can check if the user role is admin
    if (user.role === "admin") {
      router.push("/admin/dashboard");
    } else {
      alert("You are not authorized to access the admin dashboard.");
    }
  };

  return (
    <div className="flex items-center justify-center h-screen bg-gray-900">
      <LoginForm onSuccess={handleLoginSuccess} />
    </div>
  );
}
