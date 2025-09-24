// components/LoginForm.js

"use client";

import { useState } from "react";
import Link from "next/link";
import { Eye, EyeOff } from "lucide-react";

export default function LoginForm({ role, loginEndpoint }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");

    try {
      // TODO: Replace with actual API call
      const response = await fetch(loginEndpoint, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });

      if (!response.ok) {
        throw new Error("Invalid credentials");
      }

      // Success logic (e.g., redirect)
      console.log(`${role} logged in successfully`);
    } catch (err) {
      setError(err.message || "Login failed");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-background/70 dark:bg-background/80">
      <div className="bg-card dark:bg-card-dark shadow-lg rounded-xl p-10 w-full max-w-md">
        <h1 className="text-2xl font-bold mb-6 text-foreground text-center">
          {role} Login
        </h1>
        <form onSubmit={handleLogin} className="space-y-4">
          {error && <p className="text-red-500 text-sm text-center">{error}</p>}
          <div className="flex flex-col">
            <label
              htmlFor="email"
              className="mb-1 text-sm font-medium text-foreground"
            >
              Email
            </label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Enter your email"
              className="px-4 py-2 rounded-lg border border-border bg-background text-foreground focus:outline-none focus:ring-2 focus:ring-primary"
              required
            />
          </div>
          <div className="flex flex-col relative">
            <label
              htmlFor="password"
              className="mb-1 text-sm font-medium text-foreground"
            >
              Password
            </label>
            <input
              type={showPassword ? "text" : "password"}
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Enter your password"
              className="px-4 py-2 rounded-lg border border-border bg-background text-foreground focus:outline-none focus:ring-2 focus:ring-primary pr-10"
              required
            />
            <button
              type="button"
              onClick={() => setShowPassword(!showPassword)}
              className="absolute top-9 right-3 text-muted-foreground hover:text-foreground"
            >
              {showPassword ? <EyeOff size={20} /> : <Eye size={20} />}
            </button>
          </div>
          <button
            type="submit"
            disabled={loading}
            className="w-full bg-primary text-primary-foreground py-2 rounded-lg font-medium hover:bg-primary/90 transition-all"
          >
            {loading ? "Logging in..." : "Login"}
          </button>
        </form>
        <p className="mt-4 text-sm text-muted-foreground text-center">
          Back to{" "}
          <Link href="/" className="text-primary hover:underline">
            Home
          </Link>
        </p>
      </div>
    </div>
  );
}
