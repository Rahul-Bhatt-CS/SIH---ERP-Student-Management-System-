// lib/api/admin.js

import { fetchWithAuth } from "@/utils/auth";

const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

// Get all unapproved students
export async function getUnapprovedStudents() {
  try {
    return await fetchWithAuth(
      `${API_BASE}/unregisteredStudents`,
      {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      },
      "admin"
    ); // uses adminToken automatically
  } catch (err) {
    throw err;
  }
}

// Approve or reject a student
export async function approveOrRejectStudent(studentid, value) {
  try {
    return await fetchWithAuth(
      `${API_BASE}/approveStudent/${value}`,
      {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ studentid }),
      },
      "admin"
    ); // uses adminToken automatically
  } catch (err) {
    throw err;
  }
}
