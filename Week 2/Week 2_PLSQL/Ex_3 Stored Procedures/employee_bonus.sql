CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department VARCHAR2,
    p_bonus_percentage NUMBER
) AS
BEGIN
    -- Update salary by adding the bonus percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateEmployeeBonus;
/
