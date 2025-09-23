// components/DashboardStats.js

"use client";

import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { Users, DollarSign, Home, FileText } from "lucide-react";
import { useEffect, useState } from "react";

const statsData = [
  { title: "Total Students", icon: <Users />, value: 1250 },
  { title: "Fees Collected", icon: <DollarSign />, value: 850000 },
  { title: "Hostel Occupancy", icon: <Home />, value: 320 },
  { title: "Upcoming Exams", icon: <FileText />, value: 12 },
];

export default function DashboardStats() {
  const [counts, setCounts] = useState(statsData.map(() => 0));

  useEffect(() => {
    const interval = setInterval(() => {
      setCounts((prev) =>
        prev.map((v, i) => {
          if (v < statsData[i].value)
            return v + Math.ceil(statsData[i].value / 50);
          return statsData[i].value;
        })
      );
    }, 50);
    return () => clearInterval(interval);
  }, []);

  return (
    <section className="py-16 px-6 max-w-7xl mx-auto">
      <h2 className="text-2xl md:text-3xl font-bold text-foreground mb-8 text-center">
        Key Metrics
      </h2>
      <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
        {statsData.map((stat, idx) => (
          <Card
            key={stat.title}
            className="flex flex-col items-center justify-center p-6 hover:scale-105 transform transition-all duration-300 border border-border shadow hover:shadow-lg"
          >
            <div className="mb-4 text-primary">{stat.icon}</div>
            <CardHeader>
              <CardTitle className="text-lg font-semibold">
                {stat.title}
              </CardTitle>
            </CardHeader>
            <CardContent>
              <p className="text-2xl font-bold text-foreground">
                {counts[idx].toLocaleString()}
              </p>
            </CardContent>
          </Card>
        ))}
      </div>
    </section>
  );
}
