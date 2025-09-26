// lib/api/student.js

import { fetchWithAuth } from "@/utils/auth";

// Base API URL
const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

// Helper to safely parse JSON
async function safeJson(res) {
  const text = await res.text();
  try {
    return text ? JSON.parse(text) : {};
  } catch {
    return {};
  }
}

// Student registration
export async function registerStudent(data) {
  try {
    return await fetchWithAuth(
      `${API_BASE}/api/register`,
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      },
      "student"
    ); // automatically uses studentToken
  } catch (err) {
    throw err;
  }
}

// Login function for student (optional, you can use AuthForm directly)
export async function loginStudent(studentid, password) {
  try {
    const basicAuth = btoa(`${studentid}:${password}`);
    localStorage.setItem("studentToken", basicAuth);
    localStorage.setItem("role", "student");

    const res = await fetch(`${API_BASE}/student/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Basic ${basicAuth}`,
      },
      body: JSON.stringify({ studentid, password }),
    });

    if (!res.ok) {
      const data = await safeJson(res);
      throw new Error(data.message || "Login failed");
    }

    return await safeJson(res);
  } catch (err) {
    throw err;
  }
}
