// app/librarian/login/page.js

import AuthForm from "@/components/AuthForm";

export default function LibrarianLogin() {
  const fields = ["email", "password"];

  return (
    <AuthForm
      role="Librarian"
      type="Login"
      fields={fields}
      submitEndpoint="/librarian/login"
    />
  );
}
