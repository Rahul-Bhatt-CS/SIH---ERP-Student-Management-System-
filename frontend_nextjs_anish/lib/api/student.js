// lib/api/student.js

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

// Student registration (hardcoded Basic Auth)
export async function registerStudent(data) {
  try {
    const res = await fetch(`${API_BASE}/api/register`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    if (!res.ok) {
      const errorData = await safeJson(res);
      throw new Error(
        errorData.message || `Registration failed with status ${res.status}`
      );
    }

    return await safeJson(res);
  } catch (err) {
    throw err;
  }
}

// Student login (stores credentials in localStorage)
export async function loginStudent(studentid, password) {
  try {
    const basicAuth = btoa(`${studentid}:${password}`);
    localStorage.setItem("basicAuth", basicAuth);
    localStorage.setItem("role", "student");

    const res = await fetch(`${API_BASE}/student/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ studentid, password }),
    });

    console.log(res);

    if (!res.ok) {
      const data = await safeJson(res);
      throw new Error(data.message || "Login failed");
    }

    return await safeJson(res);
  } catch (err) {
    throw err;
  }
}
