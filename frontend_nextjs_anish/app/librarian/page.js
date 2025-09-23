import LoginForm from "@/components/LoginForm";

export default function LibrarianLogin() {
  return <LoginForm role="Librarian" loginEndpoint="/api/librarian/login" />;
}
