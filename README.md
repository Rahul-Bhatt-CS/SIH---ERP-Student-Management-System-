# SIH---ERP-Student-Management-System-

Impliment getDetails in feeDetailService.
API Details.
1.Admin APIs(Format /api/admin/**)
->GET /students with query parameter "status=__"   
        ->unregistered-> get List of Unregistered Students.
        ->approved -> get List of approved Students.
        ->rejected -> get List of rejected Students.
->PUT /students with query parameters -> "status=approve" or "status = rejected" and "studentId = ____"