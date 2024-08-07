DECLARE
    v_due_date DATE := SYSDATE + 30;
    CURSOR c_loans IS
        SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate <= v_due_date;
BEGIN
    FOR loan_rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || loan_rec.Name || 
                             ' (CustomerID: ' || loan_rec.CustomerID || 
                             ') has a loan due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY') || 
                             '. Please make necessary arrangements.');
    END LOOP;
END;
/
