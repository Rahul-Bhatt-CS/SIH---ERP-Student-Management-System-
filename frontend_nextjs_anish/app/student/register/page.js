// app/student/register/page.js

"use client";

import AuthForm from "@/components/AuthForm";

export default function StudentRegister() {
  const fields = [
    "studentid",
    "password",
    "name",
    "branch",
    "college",
    "batch",
    "contact",
    "email",
  ];

  return (
    <AuthForm
      role="Student"
      type="Register"
      fields={fields}
      submitEndpoint="/register"
    />
  );
}
