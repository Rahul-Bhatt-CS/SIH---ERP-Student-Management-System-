import LoginForm from "@/components/LoginForm";

export default function StudentLogin() {
  return <LoginForm role="Student" loginEndpoint="/api/student/login" />;
}
