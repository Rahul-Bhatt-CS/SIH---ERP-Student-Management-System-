// app/student/register/page.js

"use client";

import AuthForm from "@/components/AuthForm";

export default function StudentRegister() {
  const fields = [
    "name",
    "email",
    "branch",
    "college",
    "batch",
    "contact",
    "password",
  ];

  return (
    <div className="min-h-screen flex items-center justify-center px-4">
      <AuthForm
        role="Student"
        type="Register"
        fields={fields}
        submitEndpoint="/register"
      />
    </div>
  );
}
