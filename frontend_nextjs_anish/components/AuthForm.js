// components/AuthForm.js

"use client";

import { useState } from "react";
import { Eye, EyeOff } from "lucide-react";
import { useRouter } from "next/navigation";

export default function AuthForm({ role, type, fields, submitEndpoint }) {
  const router = useRouter();
  const [formData, setFormData] = useState(
    fields.reduce((acc, field) => {
      acc[field] = "";
      return acc;
    }, {})
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
      const res = await fetch(
        `${process.env.NEXT_PUBLIC_API_BASE_URL}${submitEndpoint}`,
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(formData),
        }
      );

      if (!res.ok) {
        const errData = await res.json();
        throw new Error(errData.message || `${type} failed`);
      }

      if (type === "Register") {
        router.push("/student/page"); // redirect to login after registration
      } else {
        const data = await res.json();
        localStorage.setItem("studentToken", data.token); // store JWT/token
        router.push("/student/dashboard"); // redirect after login
      }
    } catch (err) {
      setError(err.message || `${type} failed`);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-background/70 dark:bg-background/80">
      <div className="bg-card dark:bg-card-dark shadow-lg rounded-xl p-10 w-full max-w-md">
        <h1 className="text-2xl font-bold mb-6 text-foreground text-center">
          {role} {type}
        </h1>
        {error && <p className="text-center text-red-500 mb-4">{error}</p>}
        <form onSubmit={handleSubmit} className="space-y-4">
          {fields.map((field) => (
            <div key={field} className="flex flex-col relative">
              <label className="mb-1 text-sm font-medium text-foreground">
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
                className={`px-4 py-2 rounded-lg border border-border bg-background text-foreground focus:outline-none focus:ring-2 focus:ring-primary ${
                  field === "password" ? "pr-10" : ""
                }`}
                required
              />
              {field === "password" && (
                <button
                  type="button"
                  onClick={() => setShowPassword(!showPassword)}
                  className="absolute top-9 right-3 text-muted-foreground hover:text-foreground"
                >
                  {showPassword ? <EyeOff size={20} /> : <Eye size={20} />}
                </button>
              )}
            </div>
          ))}

          <button
            type="submit"
            disabled={loading}
            className="w-full bg-primary text-primary-foreground py-2 rounded-lg font-medium hover:bg-primary/90 transition-all"
          >
            {loading ? `${type}ing...` : type}
          </button>
        </form>
      </div>
    </div>
  );
}
