// utils/auth.js

// Login with role-based credentials
export const login = async (username, password, role) => {
  try {
    const basicAuth = btoa(`${username}:${password}`);

    const res = await fetch(`/api/${role}/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Basic ${basicAuth}`,
      },
      body: JSON.stringify({ username, password }), // optional depending on backend
    });

    if (!res.ok) throw new Error("Login failed");

    // Store Basic Auth and role for future requests
    localStorage.setItem("basicAuth", basicAuth);
    localStorage.setItem("role", role);

    return await res.json();
  } catch (err) {
    console.error(err);
    throw err;
  }
};

// Fetch wrapper that automatically sends Basic Auth
export const fetchWithAuth = async (url, options = {}) => {
  const basicAuth = localStorage.getItem("basicAuth");
  const role = localStorage.getItem("role");
  if (!basicAuth || !role) throw new Error("No stored credentials");

  const headers = {
    ...options.headers,
    Authorization: `Basic ${basicAuth}`,
  };

  const res = await fetch(url, { ...options, headers });
  if (!res.ok) throw new Error(`Request failed with status ${res.status}`);
  return res.json();
};
