// app/admin/dashboard/page.js

"use client";

import { useState } from "react";
import { Card, CardContent, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";

export default function AdminDashboard() {
  const [requests, setRequests] = useState([
    { id: 1, name: "John Doe", role: "Faculty", email: "john@school.com" },
    { id: 2, name: "Jane Smith", role: "Librarian", email: "jane@school.com" },
  ]);

  const handleAction = (id, action) => {
    setRequests(requests.filter((req) => req.id !== id));
    alert(`Request ${action}d!`);
  };

  return (
    <div className="p-6 bg-gray-900 min-h-screen text-white">
      <h1 className="text-3xl font-bold mb-6">Admin Dashboard</h1>
      {requests.length === 0 ? (
        <p>No pending requests.</p>
      ) : (
        requests.map((req) => (
          <Card
            key={req.id}
            className="flex justify-between items-center p-4 mb-4 bg-gray-800"
          >
            <CardContent>
              <CardTitle>{req.name}</CardTitle>
              <p>Role: {req.role}</p>
              <p>Email: {req.email}</p>
            </CardContent>
            <div className="space-x-2">
              <Button
                onClick={() => handleAction(req.id, "approve")}
                className="bg-green-500 hover:bg-green-600"
              >
                Approve
              </Button>
              <Button
                onClick={() => handleAction(req.id, "reject")}
                className="bg-red-500 hover:bg-red-600"
              >
                Reject
              </Button>
            </div>
          </Card>
        ))
      )}
    </div>
  );
}
