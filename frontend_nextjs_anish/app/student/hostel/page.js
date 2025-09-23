// app/student/hostel/page.js

import StudentLayout from "../StudentLayout";
import { Card, CardTitle, CardContent } from "@/components/ui/card";

export default function HostelPage() {
  return (
    <StudentLayout>
      <h1 className="text-2xl font-bold text-foreground mb-6">
        Submit Hostel Details
      </h1>

      <Card className="p-4 shadow-lg">
        <CardTitle>Hostel Allocation</CardTitle>
        <CardContent>
          <form className="flex flex-col gap-4">
            <label>
              Room Type:
              <select className="input w-full mt-1">
                <option>Single</option>
                <option>Double</option>
              </select>
            </label>
            <label>
              Hostel Block:
              <input
                type="text"
                placeholder="Enter block"
                className="input w-full mt-1"
              />
            </label>
            <button type="submit" className="btn btn-primary mt-2">
              Submit Hostel Details
            </button>
          </form>
        </CardContent>
      </Card>
    </StudentLayout>
  );
}
