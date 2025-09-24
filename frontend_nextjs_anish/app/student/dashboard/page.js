// app/student/dashboard/page.js
"use client";

import { Card, CardTitle } from "@/components/ui/card";
import { Bell } from "lucide-react";
import { useState } from "react";
import StudentLayout from "../StudentLayout";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

export default function StudentDashboard() {
  const studentName = "John Doe";
  const [notificationsOpen, setNotificationsOpen] = useState(false);

  const stats = [
    { title: "GPA", value: "8.7", color: "bg-green-500" },
    { title: "Fees Paid", value: "$2,300", color: "bg-blue-500" },
    { title: "Pending Tasks", value: "3", color: "bg-yellow-500" },
    { title: "Hostel Status", value: "Allocated", color: "bg-purple-500" },
  ];

  const chartData = [
    { month: "Jan", gpa: 7.5 },
    { month: "Feb", gpa: 8.0 },
    { month: "Mar", gpa: 8.2 },
    { month: "Apr", gpa: 8.5 },
    { month: "May", gpa: 8.7 },
  ];

  const recentActivities = [
    {
      title: "Exam Result Released",
      description: "Mathematics exam result is now available.",
      date: "2025-09-20",
    },
    {
      title: "Fee Payment Reminder",
      description: "Semester 2 tuition fees are due in 3 days.",
      date: "2025-09-18",
    },
    {
      title: "Hostel Allocation Updated",
      description: "Your hostel room has been assigned.",
      date: "2025-09-15",
    },
    {
      title: "New Assignment Posted",
      description: "Computer Science project submission deadline extended.",
      date: "2025-09-12",
    },
  ];

  return (
    <StudentLayout>
      <div className="flex justify-between items-center mb-6">
        <h2 className="text-3xl font-bold text-foreground">
          Welcome, {studentName}
        </h2>
        <div className="relative">
          <button
            onClick={() => setNotificationsOpen(!notificationsOpen)}
            className="p-2 rounded-full hover:bg-accent/20 transition-colors"
          >
            <Bell size={24} />
          </button>
          <span className="absolute top-0 right-0 w-2 h-2 bg-red-500 rounded-full" />
        </div>
      </div>

      {/* Stats */}
      <section className="grid gap-6 sm:grid-cols-2 lg:grid-cols-4 mb-6">
        {stats.map((stat) => (
          <Card
            key={stat.title}
            className="p-4 shadow hover:shadow-lg transition-all cursor-pointer"
          >
            <CardTitle className="text-lg font-semibold">
              {stat.title}
            </CardTitle>
            <p
              className={`text-2xl font-bold mt-2 ${stat.color} text-white px-2 py-1 rounded-lg w-max`}
            >
              {stat.value}
            </p>
          </Card>
        ))}
      </section>

      {/* GPA Chart */}
      <section className="bg-card dark:bg-card-dark p-4 rounded-lg shadow mb-6">
        <h3 className="text-lg font-bold mb-4">GPA Trend</h3>
        <div style={{ width: "100%", height: 250 }}>
          <ResponsiveContainer width="100%" height="100%">
            <LineChart data={chartData}>
              <XAxis dataKey="month" stroke="#8884d8" />
              <YAxis stroke="#8884d8" />
              <Tooltip />
              <Line
                type="monotone"
                dataKey="gpa"
                stroke="#8884d8"
                strokeWidth={3}
              />
            </LineChart>
          </ResponsiveContainer>
        </div>
      </section>

      {/* Recent Activities */}
      <section className="bg-card dark:bg-card-dark p-4 rounded-lg shadow mb-6">
        <h3 className="text-lg font-bold mb-4">Recent Activities</h3>
        <div className="divide-y divide-border max-h-64 overflow-y-auto">
          {recentActivities.map((activity, index) => (
            <div key={index} className="py-3">
              <p className="text-sm font-semibold text-foreground">
                {activity.title}
              </p>
              <p className="text-sm text-muted-foreground">
                {activity.description}
              </p>
              <p className="text-xs text-muted-foreground mt-1">
                {activity.date}
              </p>
            </div>
          ))}
        </div>
      </section>
    </StudentLayout>
  );
}
