// app/page.js

import Link from "next/link";
import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { ArrowRight, User, Book, GraduationCap } from "lucide-react";
import DashboardStats from "@/components/DashboardStats";
import HowItWorks from "@/components/HowItWorks";

export default function Home() {
  const features = [
    {
      name: "Admissions",
      description: "Manage student admissions seamlessly.",
      link: "/admissions",
    },
    {
      name: "Fees",
      description: "Track and process fee payments easily.",
      link: "/fees",
    },
    {
      name: "Hostel",
      description: "Monitor hostel occupancy in real-time.",
      link: "/hostel",
    },
    {
      name: "Exams",
      description: "Manage student examinations and results.",
      link: "/exams",
    },
    {
      name: "Dashboard",
      description: "Get instant insights with interactive dashboards.",
      link: "/dashboard",
    },
  ];

  const loginSections = [
    {
      role: "Student",
      description: "Access your courses, dashboard, and personal profile.",
      link: "/student",
      icon: <GraduationCap className="w-10 h-10 mx-auto mb-4 text-blue-500" />,
      cardClasses: "border-blue-300 group",
      titleColor:
        "text-blue-600 dark:text-blue-200 group-hover:text-blue-800 dark:group-hover:text-blue-200",
      buttonColor: "bg-blue-500 hover:bg-blue-600",
    },
    {
      role: "Faculty",
      description: "Manage classes, track student progress, and access tools.",
      link: "/faculty",
      icon: <User className="w-10 h-10 mx-auto mb-4 text-green-500" />,
      cardClasses: "border-green-300 group",
      titleColor:
        "text-green-600 dark:text-green-200 group-hover:text-green-800 dark:group-hover:text-green-200",
      buttonColor: "bg-green-500 hover:bg-green-600",
    },
    {
      role: "Librarian",
      description:
        "Manage books, track inventory, and assist users efficiently.",
      link: "/librarian",
      icon: <Book className="w-10 h-10 mx-auto mb-4 text-purple-500" />,
      cardClasses: "border-purple-300 group",
      titleColor:
        "text-purple-600 dark:text-purple-200 group-hover:text-purple-800 dark:group-hover:text-purple-200",
      buttonColor: "bg-purple-500 hover:bg-purple-600",
    },
  ];

  return (
    <main className="relative">
      {/* Hero Section */}
      <section className="bg-background/70 dark:bg-background/80 backdrop-blur-md py-20 px-6 text-center">
        <h1 className="text-4xl md:text-6xl font-extrabold text-foreground mb-4">
          🎓 ERP-Based Student Management
        </h1>
        <p className="text-muted-foreground max-w-2xl mx-auto mb-8 text-lg md:text-xl">
          Streamline admissions, fees, hostel allocation, and examinations with
          a modern, integrated system – all lightweight and user-friendly.
        </p>
        <Link href="/admissions">
          <button className="bg-primary text-primary-foreground px-6 py-3 rounded-lg shadow-lg hover:shadow-xl transition-all font-semibold">
            Get Started
            <ArrowRight className="inline ml-2 w-4 h-4" />
          </button>
        </Link>
      </section>

      {/* Login Sections */}
      <section className="py-16 px-6 max-w-7xl mx-auto grid gap-8 sm:grid-cols-1 md:grid-cols-3">
        {loginSections.map((section) => (
          <Card
            key={section.role}
            className={`relative cursor-pointer shadow text-center transform transition-all duration-300 group hover:scale-105 hover:shadow-lg ${section.cardClasses}`}
          >
            {/* Gradient overlay */}
            <div className="absolute inset-0 rounded-lg opacity-0 group-hover:opacity-30 transition-opacity duration-300 bg-gradient-to-br from-transparent to-primary/20 dark:to-primary/40 pointer-events-none"></div>

            <CardHeader className="relative rounded-t-lg z-10">
              <div className="transition-transform duration-300 group-hover:scale-110">
                {section.icon}
              </div>
              <CardTitle
                className={`text-lg font-bold ${section.titleColor} transition-colors duration-300`}
              >
                {section.role}
              </CardTitle>
            </CardHeader>
            <CardContent className="relative z-10">
              <p className="text-muted-foreground group-hover:text-foreground transition-colors duration-300 mb-4">
                {section.description}
              </p>
              <Link href={section.link}>
                <button
                  className={`${section.buttonColor} text-white px-4 py-2 rounded-lg shadow transition-all font-medium`}
                >
                  Login
                </button>
              </Link>
            </CardContent>
          </Card>
        ))}
      </section>

      {/* Features Grid */}
      <section className="py-16 px-6 max-w-7xl mx-auto grid gap-8 sm:grid-cols-2 lg:grid-cols-3">
        {features.map((feature) => (
          <Link href={feature.link} key={feature.name}>
            <Card className="hover:scale-105 transform transition-all duration-300 cursor-pointer border border-border shadow hover:shadow-lg">
              <CardHeader>
                <CardTitle className="text-lg font-bold">
                  {feature.name}
                </CardTitle>
              </CardHeader>
              <CardContent>
                <p className="text-muted-foreground">{feature.description}</p>
              </CardContent>
            </Card>
          </Link>
        ))}
      </section>

      {/* Dashboard Stats */}
      <DashboardStats />

      {/* How It Works Section */}
      <HowItWorks />
    </main>
  );
}
