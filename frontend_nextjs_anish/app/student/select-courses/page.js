// app/student/select-courses/page.js

import StudentLayout from "../StudentLayout";
import { Card, CardTitle, CardContent } from "@/components/ui/card";

export default function SelectCoursesPage() {
  const courses = ["Mathematics", "Physics", "Computer Science", "English"];

  return (
    <StudentLayout>
      <h1 className="text-2xl font-bold text-foreground mb-6">
        Select Courses
      </h1>

      <Card className="p-4 shadow-lg">
        <CardTitle>Course Registration</CardTitle>
        <CardContent>
          <form className="flex flex-col gap-3">
            {courses.map((course) => (
              <label key={course} className="flex items-center gap-2">
                <input type="checkbox" className="checkbox" />
                {course}
              </label>
            ))}
            <button type="submit" className="btn btn-primary mt-2">
              Submit Selected Courses
            </button>
          </form>
        </CardContent>
      </Card>
    </StudentLayout>
  );
}
