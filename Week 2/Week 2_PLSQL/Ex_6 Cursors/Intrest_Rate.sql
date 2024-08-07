DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;
    
    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_new_interest_rate NUMBER;
BEGIN
    -- Example: New policy - increase interest rate by 0.5%
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loan_id, v_interest_rate;
        EXIT WHEN c_loans%NOTFOUND;

        v_new_interest_rate := v_interest_rate + 0.5;

        -- Update the interest rate
        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE LoanID = v_loan_id;
    END LOOP;
    CLOSE c_loans;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
