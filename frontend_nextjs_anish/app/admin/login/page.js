// app/admin/login/page.js

"use client";

import AuthForm from "@/components/AuthForm";

export default function AdminLoginPage() {
  const fields = ["name", "password"];

  // For Admin, we'll handle login logic inside AuthForm or via a placeholder API function
  const fakeAdminLogin = async ({ student }) => {
    // Hardcoded admin credentials
    if (student.studentid === "admin" && student.password === "admin123") {
      return { token: "admin-token" }; // fake token
    } else {
      throw new Error("Invalid admin credentials");
    }
  };

  return (
    <AuthForm
      role="Admin"
      type="Login"
      fields={fields}
      apiFunction={fakeAdminLogin}
      redirectAfter="/admin/dashboard"
    />
  );
}
