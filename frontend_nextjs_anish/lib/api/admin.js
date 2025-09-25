// lib/api/admin.js

const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

// Get all unapproved students
export async function getUnapprovedStudents() {
  try {
    const res = await fetch(`${API_BASE}/unregisteredStudents`, {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    });

    if (!res.ok) {
      const errData = await res.json();
      throw new Error(errData.message || "Failed to fetch unapproved students");
    }

    return await res.json();
  } catch (err) {
    throw err;
  }
}

// Approve or reject a student
export async function approveOrRejectStudent(studentid, value) {
  try {
    const res = await fetch(`${API_BASE}/approveStudent/${value}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ studentid }),
    });

    if (!res.ok) {
      const errData = await res.json();
      throw new Error(errData.message || "Failed to update student status");
    }

    return await res.json();
  } catch (err) {
    throw err;
  }
}
