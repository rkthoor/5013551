CREATE TABLE ErrorLog (
    ErrorID NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ErrorMessage VARCHAR2(4000),
    ErrorDate DATE
);


CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id NUMBER,
    p_percentage NUMBER
) AS
    v_current_salary NUMBER;
BEGIN
    -- Check if employee exists and get current salary
    SELECT Salary INTO v_current_salary FROM Employees WHERE EmployeeID = p_employee_id FOR UPDATE;

    -- Update the salary
    UPDATE Employees SET Salary = Salary + (Salary * p_percentage / 100) WHERE EmployeeID = p_employee_id;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES ('Employee ID ' || p_employee_id || ' does not exist.', SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID does not exist.');
    WHEN OTHERS THEN
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/
