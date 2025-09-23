import LoginForm from "@/components/LoginForm";

export default function FacultyLogin() {
  return <LoginForm role="Faculty" loginEndpoint="/api/faculty/login" />;
}
