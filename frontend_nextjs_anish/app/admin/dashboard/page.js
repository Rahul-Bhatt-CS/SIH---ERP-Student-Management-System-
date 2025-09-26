// app/admin/dashboard/page.js

"use client";

import { useEffect, useState } from "react";
import { Card, CardContent, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { getUnapprovedStudents, approveOrRejectStudent } from "@/lib/api/admin";

export default function AdminDashboard() {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [actionLoadingIds, setActionLoadingIds] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    setLoading(true);
    try {
      const data = await getUnapprovedStudents();
      setStudents(data);
    } catch (err) {
      setError(err.message || "Failed to fetch students");
    } finally {
      setLoading(false);
    }
  };

  const handleAction = async (studentid, status) => {
    setActionLoadingIds((prev) => [...prev, studentid]);
    try {
      await approveOrRejectStudent(studentid, status);
      setStudents((prev) => prev.filter((s) => s.studentid !== studentid));
    } catch (err) {
      setError(err.message || "Action failed");
    } finally {
      setActionLoadingIds((prev) => prev.filter((id) => id !== studentid));
    }
  };

  return (
    <div className="p-6 sm:p-10 min-h-screen bg-background dark:bg-background transition-colors">
      <h1 className="text-3xl sm:text-4xl font-bold mb-8 text-foreground text-center sm:text-left">
        Admin Dashboard
      </h1>

      {error && (
        <p className="text-destructive text-center sm:text-left mb-6">
          {error}
        </p>
      )}

      {loading ? (
        <p className="text-muted-foreground text-center">
          Loading unapproved students...
        </p>
      ) : students.length === 0 ? (
        <p className="text-muted-foreground text-center">
          No pending requests.
        </p>
      ) : (
        <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-3">
          {students.map((student) => {
            const isActionLoading = actionLoadingIds.includes(
              student.studentid
            );
            return (
              <Card
                key={student.studentid}
                className="bg-card dark:bg-card-foreground shadow-lg rounded-lg flex flex-col justify-between p-4 transition-colors"
              >
                <CardContent className="flex-1">
                  <CardTitle className="text-lg sm:text-xl text-foreground font-semibold mb-2">
                    {student.name}
                  </CardTitle>
                  <p className="text-sm text-muted-foreground mb-1">
                    Branch: {student.branch}
                  </p>
                  <p className="text-sm text-muted-foreground mb-1">
                    College: {student.college}
                  </p>
                  <p className="text-sm text-muted-foreground mb-1">
                    Batch: {student.batch}
                  </p>
                  <p className="text-sm text-muted-foreground mb-1">
                    Contact: {student.contact}
                  </p>
                  <p className="text-sm text-muted-foreground">
                    Email: {student.email}
                  </p>
                </CardContent>
                <div className="mt-4 flex gap-2 justify-end">
                  <Button
                    onClick={() => handleAction(student.studentid, "accept")}
                    disabled={isActionLoading}
                    className="bg-primary text-primary-foreground hover:bg-primary/90 transition-all flex-1"
                  >
                    {isActionLoading ? "Processing..." : "Approve"}
                  </Button>
                  <Button
                    onClick={() => handleAction(student.studentid, "reject")}
                    disabled={isActionLoading}
                    className="bg-destructive text-primary-foreground hover:bg-destructive/90 transition-all flex-1"
                  >
                    {isActionLoading ? "Processing..." : "Reject"}
                  </Button>
                </div>
              </Card>
            );
          })}
        </div>
      )}
    </div>
  );
}
