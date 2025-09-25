// lib/api/student.js

const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

/**
 * Register a new student
 * @param {Object} data - Registration payload
 */
export async function registerStudent(data) {
  try {
    const res = await fetch(`${API_BASE}/register`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    });

    if (!res.ok) {
      const errorData = await res.json();
      throw new Error(errorData.message || "Registration failed");
    }

    return await res.json();
  } catch (err) {
    throw err;
  }
}

/**
 * Login a student
 * @param {Object} data - Login payload
 */
export async function loginStudent(data) {
  try {
    const res = await fetch(`${API_BASE}/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    });

    if (!res.ok) {
      const errorData = await res.json();
      throw new Error(errorData.message || "Login failed");
    }

    return await res.json();
  } catch (err) {
    throw err;
  }
}
