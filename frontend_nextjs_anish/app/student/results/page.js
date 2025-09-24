// app/student/results/page.js

import StudentLayout from "../StudentLayout";
import { Card, CardTitle, CardContent } from "@/components/ui/card";

export default function ResultsPage() {
  const results = [
    { subject: "Mathematics", grade: "A" },
    { subject: "Physics", grade: "B+" },
    { subject: "Computer Science", grade: "A-" },
  ];

  return (
    <StudentLayout>
      <h1 className="text-2xl font-bold text-foreground mb-6">
        Print Results / Submission Card
      </h1>

      {results.map((r) => (
        <Card key={r.subject} className="p-4 shadow-lg mb-4">
          <CardTitle>{r.subject}</CardTitle>
          <CardContent>Grade: {r.grade}</CardContent>
        </Card>
      ))}
      <button className="btn btn-primary mt-2">Print Results</button>
    </StudentLayout>
  );
}
