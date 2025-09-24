// app/student/course-registration/page.js

import StudentLayout from "../StudentLayout";
import { Card, CardTitle, CardContent } from "@/components/ui/card";

export default function CourseRegistrationPage() {
  return (
    <StudentLayout>
      <h1 className="text-2xl font-bold text-foreground mb-6">
        Submit Courses
      </h1>

      <Card className="p-4 shadow-lg">
        <CardTitle>Course Codes Submission</CardTitle>
        <CardContent>
          <form className="flex flex-col gap-4">
            <label>
              Course Code:
              <input
                type="text"
                placeholder="Enter course code"
                className="input w-full mt-1"
              />
            </label>
            <button type="submit" className="btn btn-primary mt-2">
              Submit Courses
            </button>
          </form>
        </CardContent>
      </Card>
    </StudentLayout>
  );
}
