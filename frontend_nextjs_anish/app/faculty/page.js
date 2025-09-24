import AuthForm from "@/components/AuthForm";

export default function FacultyLogin() {
  const fields = ["email", "password"];

  return (
    <AuthForm
      role="Faculty"
      type="Login"
      fields={fields}
      submitEndpoint="/faculty/login"
    />
  );
}
