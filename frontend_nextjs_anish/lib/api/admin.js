// lib/api/admin.js

import { fetchWithAuth } from "@/utils/auth";

const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

// Register a new admin
export async function registerAdmin(username, password) {
  try {
    const res = await fetch(`${API_BASE}/register/admin`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, password }),
    });
    if (!res.ok)
      throw new Error(`Registration failed with status ${res.status}`);
    return await res.json();
  } catch (err) {
    console.error("Admin registration error:", err);
    throw err;
  }
}

// Get all unapproved students
export async function getUnapprovedStudents() {
  try {
    return await fetchWithAuth(
      `${API_BASE}/admin/students?status=unregistered`,
      {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      }
    );
  } catch (err) {
    throw err;
  }
}

// Approve or reject a student
export async function approveOrRejectStudent(studentid, status) {
  try {
    return await fetchWithAuth(`${API_BASE}/admin/approve?status=${status}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ sId: studentid }),
    });
  } catch (err) {
    throw err;
  }
}
