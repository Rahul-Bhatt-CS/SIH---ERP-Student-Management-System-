// components/AuthForm.js

"use client";

import { useState } from "react";
import { Eye, EyeOff } from "lucide-react";
import { useRouter } from "next/navigation";
import { registerStudent, loginStudent } from "@/lib/api/student";

export default function AuthForm({ role, type, fields }) {
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
        payload = {
          student: {
            studentid: "", // backend may generate automatically
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

        await registerStudent(payload);
        router.push("/student/login");
      } else {
        // Login
        payload = {
          student: {
            studentid: formData.name,
            password: formData.password,
          },
        };

        const data = await loginStudent(payload);
        localStorage.setItem("studentToken", data.token);
        router.push("/student/dashboard");
      }
    } catch (err) {
      setError(err.message || `${type} failed`);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="bg-card dark:bg-card shadow-2xl rounded-3xl p-6 sm:p-10 md:p-12 lg:p-16 w-full max-w-lg sm:max-w-xl md:max-w-3xl lg:max-w-4xl transition-all">
      <h1 className="text-3xl md:text-4xl font-bold mb-10 text-foreground text-center">
        {role} {type}
      </h1>

      {error && <p className="text-center text-destructive mb-6">{error}</p>}

      <form
        onSubmit={handleSubmit}
        className="grid grid-cols-1 md:grid-cols-2 gap-y-8 gap-x-6 md:gap-x-10"
      >
        {fields.map((field) => (
          <div key={field} className="flex flex-col relative">
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
              className={`px-4 py-3 md:py-4 rounded-lg border border-border bg-background text-foreground focus:outline-none focus:ring-2 focus:ring-primary ${
                field === "password" ? "pr-10" : ""
              }`}
              required
            />
            {field === "password" && (
              <button
                type="button"
                onClick={() => setShowPassword(!showPassword)}
                className="absolute top-10 md:top-12 right-3 text-muted-foreground hover:text-foreground"
              >
                {showPassword ? <EyeOff size={20} /> : <Eye size={20} />}
              </button>
            )}
          </div>
        ))}

        <div className="md:col-span-2 mt-4">
          <button
            type="submit"
            disabled={loading}
            className="w-full bg-primary text-primary-foreground py-3 md:py-4 rounded-lg font-semibold hover:bg-primary/90 transition-all text-lg md:text-xl"
          >
            {loading ? `${type}ing...` : type}
          </button>
        </div>
      </form>
    </div>
  );
}
