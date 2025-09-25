// lib/api/student.js

const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

async function safeJson(res) {
  const text = await res.text();
  try {
    return text ? JSON.parse(text) : {};
  } catch {
    return {};
  }
}

const BASIC_AUTH_USERNAME = "60448";
const BASIC_AUTH_PASSWORD = "rahulbhatt";

export async function registerStudent(data) {
  try {
    const basicAuth = btoa(`${BASIC_AUTH_USERNAME}:${BASIC_AUTH_PASSWORD}`);

    const res = await fetch(`${API_BASE}/api/register`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Basic ${basicAuth}`,
      },
      body: JSON.stringify(data),
    });

    if (!res.ok) {
      const errorData = await safeJson(res);
      throw new Error(errorData.message || "Registration failed");
    }

    return await safeJson(res);
  } catch (err) {
    throw err;
  }
}

export async function loginStudent(data) {
  try {
    const res = await fetch(`${API_BASE}/student/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    });

    if (!res.ok) {
      const errorData = await safeJson(res);
      throw new Error(errorData.message || "Login failed");
    }

    return await safeJson(res);
  } catch (err) {
    throw err;
  }
}
