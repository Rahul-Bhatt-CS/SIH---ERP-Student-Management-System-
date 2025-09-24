// app/student/fees/page.js

import StudentLayout from "../StudentLayout";
import { Card, CardTitle, CardContent } from "@/components/ui/card";

export default function FeesPage() {
  return (
    <StudentLayout>
      <h1 className="text-2xl font-bold text-foreground mb-6">
        Submit Fees Details
      </h1>

      <Card className="p-4 shadow-lg">
        <CardTitle>Fees Payment</CardTitle>
        <CardContent>
          <form className="flex flex-col gap-4">
            <label>
              Amount:
              <input
                type="number"
                placeholder="Enter amount"
                className="input w-full mt-1"
              />
            </label>
            <label>
              Semester:
              <select className="input w-full mt-1">
                <option>Semester 1</option>
                <option>Semester 2</option>
                <option>Semester 3</option>
              </select>
            </label>
            <button type="submit" className="btn btn-primary mt-2">
              Submit Payment
            </button>
          </form>
        </CardContent>
      </Card>
    </StudentLayout>
  );
}
