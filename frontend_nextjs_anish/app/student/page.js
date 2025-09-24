import AuthForm from "@/components/AuthForm";

export default function StudentLogin() {
  const fields = ["student Id", "password"];

  return (
    <AuthForm
      role="Student"
      type="Login"
      fields={fields}
      submitEndpoint="/login"
    />
  );
}
