CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_interest_rate NUMBER := 0.01; -- 1% interest rate
BEGIN
    -- Update balance for all savings accounts
    UPDATE Accounts
    SET Balance = Balance + (Balance * v_interest_rate)
    WHERE AccountType = 'savings';

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END ProcessMonthlyInterest;
/
