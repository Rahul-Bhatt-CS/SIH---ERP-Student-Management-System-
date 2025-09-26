// lib/api/librarian.js

import { fetchWithAuth } from "@/utils/auth";

const API_BASE = process.env.NEXT_PUBLIC_API_BASE_URL;

// Librarian registration
export async function registerLibrarian(data) {
  try {
    return await fetchWithAuth(
      `${API_BASE}/api/librarian/register`,
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      },
      "librarian"
    );
  } catch (err) {
    throw err;
  }
}

// Get all books
export async function getAllBooks() {
  try {
    return await fetchWithAuth(
      `${API_BASE}/api/librarian/books`,
      {
        method: "GET",
      },
      "librarian"
    );
  } catch (err) {
    throw err;
  }
}

// Login (optional)
export async function loginLibrarian(email, password) {
  try {
    const basicAuth = btoa(`${email}:${password}`);
    localStorage.setItem("librarianToken", basicAuth);
    localStorage.setItem("role", "librarian");

    const res = await fetch(`${API_BASE}/librarian/login`, {
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
