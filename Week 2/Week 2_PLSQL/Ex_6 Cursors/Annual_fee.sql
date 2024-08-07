DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;
    
    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee NUMBER := 50; -- Annual maintenance fee
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_account_id, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;

        -- Deduct the annual fee
        UPDATE Accounts
        SET Balance = v_balance - v_annual_fee
        WHERE AccountID = v_account_id;

        -- Optional: Log the fee deduction as a transaction
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (Transactions_SEQ.NEXTVAL, v_account_id, SYSDATE, -v_annual_fee, 'fee');
    END LOOP;
    CLOSE c_accounts;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
