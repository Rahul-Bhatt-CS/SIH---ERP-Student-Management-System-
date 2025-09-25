// components/AuthForm.js

"use client";

import { useState } from "react";
import { Eye, EyeOff } from "lucide-react";
import { useRouter } from "next/navigation";

export default function AuthForm({
  role,
  type,
  fields,
  apiFunction,
  redirectAfter,
}) {
  const router = useRouter();
  const [formData, setFormData] = useState(
    fields.reduce((acc, field) => ({ ...acc, [field]: "" }), {})
  );
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [showPassword, setShowPassword] = useState(false);

  const handleChange = (field, value) => {
    setFormData({ ...formData, [field]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");

    try {
      let payload = {};

      if (type === "Register") {
        if (role.toLowerCase() === "student") {
          payload = {
            student: { studentid: "", password: formData.password },
            studentCollegeDetails: {
              name: formData.name,
              branch: formData.branch,
              college: formData.college,
              batch: Number(formData.batch),
              contact: Number(formData.contact),
              email: formData.email,
            },
          };
        } else if (role.toLowerCase() === "faculty") {
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
        } else if (role.toLowerCase() === "librarian") {
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
        }
      } else {
        // Login
        if (role.toLowerCase() === "student") {
          payload = {
            student: { studentid: formData.name, password: formData.password },
          };
        } else if (role.toLowerCase() === "faculty") {
          payload = {
            faculty: { email: formData.email, password: formData.password },
          };
        } else if (role.toLowerCase() === "librarian") {
          payload = {
            librarian: { email: formData.email, password: formData.password },
          };
        } else if (role.toLowerCase() === "admin") {
          payload = {
            admin: { name: formData.name, password: formData.password },
          };
        }
      }

      const data = await apiFunction(payload);

      if (type === "Login" && data?.token) {
        localStorage.setItem(`${role.toLowerCase()}Token`, data.token);
      }

      router.push(redirectAfter);
    } catch (err) {
      setError(err.message || `${type} failed`);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center p-4 bg-background dark:bg-background transition-colors duration-300">
      <div className="card shadow-2xl rounded-3xl p-6 sm:p-10 md:p-12 lg:p-16 w-full max-w-md sm:max-w-lg md:max-w-xl lg:max-w-2xl animate-fadeIn">
        <h1 className="text-3xl md:text-4xl font-bold mb-8 text-center text-foreground">
          {role} {type}
        </h1>

        {error && <p className="text-center text-destructive mb-6">{error}</p>}

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
