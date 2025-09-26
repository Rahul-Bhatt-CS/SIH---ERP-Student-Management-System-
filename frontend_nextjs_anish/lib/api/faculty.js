// lib/api/faculty.js

import { fetchWithAuth } from "@/utils/auth";

const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

// Faculty registration
export async function registerFaculty(data) {
  try {
    return await fetchWithAuth(
      `${API_BASE}/api/faculty/register`,
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      },
      "faculty"
    );
  } catch (err) {
    throw err;
  }
}

// Get all students (faculty dashboard)
export async function getAllStudents() {
  try {
    return await fetchWithAuth(
      `${API_BASE}/api/faculty/students`,
      {
        method: "GET",
      },
      "faculty"
    );
  } catch (err) {
    throw err;
  }
}

// Login (optional, can use AuthForm directly)
export async function loginFaculty(email, password) {
  try {
    const basicAuth = btoa(`${email}:${password}`);
    localStorage.setItem("facultyToken", basicAuth);
    localStorage.setItem("role", "faculty");

    const res = await fetch(`${API_BASE}/faculty/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Basic ${basicAuth}`,
      },
      body: JSON.stringify({ email, password }),
    });

    if (!res.ok) {
      const data = await res.json();
      throw new Error(data.message || "Login failed");
    }

    return await res.json();
  } catch (err) {
    throw err;
  }
}
