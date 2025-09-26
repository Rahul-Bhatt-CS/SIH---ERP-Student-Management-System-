// components/AuthForm.js

"use client";

import { useState } from "react";
import { Eye, EyeOff } from "lucide-react";
import { useRouter } from "next/navigation";
import { fetchWithAuth } from "@/utils/auth";

export default function AuthForm({ role, type, fields, redirectAfter }) {
  const router = useRouter();
  const [formData, setFormData] = useState(
    fields.reduce((acc, field) => ({ ...acc, [field]: "" }), {})
  );
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [showPassword, setShowPassword] = useState(false);

  const handleChange = (field, value) =>
    setFormData({ ...formData, [field]: value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");
    setSuccessMessage("");

    try {
      let payload = {};
      let url = "";
      let method = "POST";

      // Prepare payload and endpoint based on type and role
      if (type === "Register") {
        url = `/api/${role.toLowerCase()}/register`;
        switch (role.toLowerCase()) {
          case "student":
            payload = {
              student: {
                studentid: formData.studentid,
                password: formData.password,
              },
              studentCollegeDetails: {
                name: formData.name,
                branch: formData.branch,
                college: formData.college,
                batch: Number(formData.batch),
                contact: Number(formData.contact),
                email: formData.email,
              },
            };
            break;
          case "faculty":
            payload = {
              faculty: {
                name: formData.name,
                department: formData.department,
                college: formData.college,
                contact: Number(formData.contact),
                email: formData.email,
                password: formData.password,
              },
            };
            break;
          case "librarian":
            payload = {
              librarian: {
                name: formData.name,
                branch: formData.branch,
                college: formData.college,
                contact: Number(formData.contact),
                email: formData.email,
                password: formData.password,
              },
            };
            break;
        }
      } else {
        // Login
        url = `/api/${role.toLowerCase()}/login`;
        let username, password;
        switch (role.toLowerCase()) {
          case "student":
            username = formData.studentid;
            password = formData.password;
            payload = { studentid: username, password };
            break;
          case "faculty":
          case "librarian":
            username = formData.email;
            password = formData.password;
            payload = { email: username, password };
            break;
          case "admin":
            username = formData.name;
            password = formData.password;
            payload = { name: username, password };
            break;
        }

        // Store Basic Auth per role
        const basicAuth = btoa(`${username}:${password}`);
        localStorage.setItem(`${role.toLowerCase()}Token`, basicAuth);
        localStorage.setItem("role", role);
      }

      // Make request
      const data = await fetchWithAuth(
        url,
        {
          method,
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(payload),
        },
        role
      );

      if (type === "Register") {
        setSuccessMessage("Registration successful!");
        setFormData(
          fields.reduce((acc, field) => ({ ...acc, [field]: "" }), {})
        );
      } else {
        router.push(redirectAfter);
      }
    } catch (err) {
      setError(err.message || `${type} failed`);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center p-4 bg-background dark:bg-background transition-colors duration-300">
      <div className="card shadow-2xl rounded-3xl p-6 sm:p-10 md:p-12 lg:p-16 w-full max-w-md sm:max-w-lg md:max-w-xl lg:max-w-2xl animate-fadeIn">
        <h1 className="text-3xl md:text-4xl font-bold mb-4 text-center text-foreground">
          {role} {type}
        </h1>

        {error && <p className="text-center text-destructive mb-4">{error}</p>}
        {successMessage && (
          <p className="text-center text-success mb-4">{successMessage}</p>
        )}

        <form
          onSubmit={handleSubmit}
          className="grid grid-cols-1 md:grid-cols-2 gap-y-6 gap-x-6 md:gap-x-8"
        >
          {fields.map((field) => (
            <div key={field} className="relative flex flex-col">
              <label className="mb-2 text-sm md:text-base font-medium text-foreground">
                {field.charAt(0).toUpperCase() + field.slice(1)}
              </label>
              <input
                type={
                  field === "password"
                    ? showPassword
                      ? "text"
                      : "password"
                    : "text"
                }
                value={formData[field]}
                onChange={(e) => handleChange(field, e.target.value)}
                placeholder={`Enter your ${field}`}
                autoComplete={
                  field === "password"
                    ? type === "Login"
                      ? "current-password"
                      : "new-password"
                    : field === "email"
                    ? "email"
                    : field === "contact"
                    ? "tel"
                    : "name"
                }
                className={`px-4 py-3 md:py-4 rounded-lg border border-border bg-input text-foreground focus:outline-none focus:ring-2 focus:ring-primary transition-all ${
                  field === "password" ? "pr-10" : ""
                }`}
                required
              />
              {field === "password" && (
                <button
                  type="button"
                  onClick={() => setShowPassword(!showPassword)}
                  className="absolute top-1/2 right-3 -translate-y-1/2 text-muted-foreground hover:text-foreground transition-colors"
                >
                  {showPassword ? <EyeOff size={22} /> : <Eye size={22} />}
                </button>
              )}
            </div>
          ))}

          <div className="md:col-span-2 mt-4">
            <button
              type="submit"
              disabled={loading}
              className={`w-full py-3 md:py-4 rounded-lg font-semibold text-lg md:text-xl text-primary-foreground bg-primary hover:bg-primary/90 transition-all ${
                loading ? "cursor-not-allowed opacity-70" : ""
              }`}
            >
              {loading ? `${type}ing...` : type}
            </button>
          </div>
        </form>

        <p className="mt-6 text-sm text-muted-foreground text-center">
          {type === "Login" ? (
            role.toLowerCase() !== "admin" ? (
              <>
                Don’t have an account?{" "}
                <a
                  href={`/${role.toLowerCase()}/register`}
                  className="text-accent hover:underline"
                >
                  Register
                </a>
              </>
            ) : null
          ) : (
            <>
              Already have an account?{" "}
              <a
                href={`/${role.toLowerCase()}/login`}
                className="text-accent hover:underline"
              >
                Login
              </a>
            </>
          )}
        </p>
      </div>
    </div>
  );
}
