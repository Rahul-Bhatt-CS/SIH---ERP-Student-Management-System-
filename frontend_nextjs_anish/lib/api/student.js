// lib/api/student.js

const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

export async function registerStudent(data) {
  try {
    const res = await fetch(`${API_BASE}/register`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
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
