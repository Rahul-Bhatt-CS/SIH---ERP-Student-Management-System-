// app/student/register/page.js

"use client";

import AuthForm from "@/components/AuthForm";
import { registerStudent } from "@/lib/api/student";

export default function StudentRegisterPage() {
  const fields = [
    "name",
    "branch",
    "college",
    "batch",
    "contact",
    "email",
    "password",
  ];

  return (
    <AuthForm
      role="Student"
      type="Register"
      fields={fields}
      apiFunction={registerStudent}
      redirectAfter="/student/login"
    />
  );
}
