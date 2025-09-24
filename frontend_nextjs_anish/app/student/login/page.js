// app/student/login/page.js

"use client";

import AuthForm from "@/components/AuthForm";

export default function StudentLogin() {
  const fields = ["name", "password"];

  return (
    <div className="min-h-screen flex items-center justify-center px-4">
      <AuthForm
        role="Student"
        type="Login"
        fields={fields}
        submitEndpoint="/login"
      />
    </div>
  );
}
