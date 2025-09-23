// components/HowItWorks.js

"use client";

import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { FileText, DollarSign, Home, BarChart2 } from "lucide-react";

const steps = [
  {
    title: "Admission Intake",
    description:
      "Students fill out online forms and data flows directly to the central database.",
    icon: <FileText size={28} className="text-primary" />,
  },
  {
    title: "Fee Collection",
    description:
      "Automated receipts and tracking make fee management effortless.",
    icon: <DollarSign size={28} className="text-primary" />,
  },
  {
    title: "Hostel Management",
    description:
      "Track occupancy in real-time and manage room allocations seamlessly.",
    icon: <Home size={28} className="text-primary" />,
  },
  {
    title: "Dashboard & Reports",
    description:
      "Interactive dashboards provide administrators instant insights.",
    icon: <BarChart2 size={28} className="text-primary" />,
  },
];

export default function HowItWorks() {
  return (
    <section className="py-16 px-6 max-w-7xl mx-auto">
      <h2 className="text-2xl md:text-3xl font-bold text-foreground mb-12 text-center">
        How It Works
      </h2>

      <div className="grid gap-8 sm:grid-cols-2 lg:grid-cols-4">
        {steps.map((step, idx) => (
          <Card
            key={idx}
            className="flex flex-col items-center p-6 text-center hover:scale-105 transform transition-all duration-300 cursor-pointer border border-border shadow hover:shadow-lg"
          >
            <div className="mb-4">{step.icon}</div>
            <CardHeader>
              <CardTitle className="text-lg font-semibold">
                {step.title}
              </CardTitle>
            </CardHeader>
            <CardContent>
              <p className="text-muted-foreground">{step.description}</p>
            </CardContent>
          </Card>
        ))}
      </div>
    </section>
  );
}
