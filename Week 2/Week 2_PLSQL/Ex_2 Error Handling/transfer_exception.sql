CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id NUMBER,
    p_to_account_id NUMBER,
    p_amount NUMBER
) AS
    v_from_balance NUMBER;
    v_to_balance NUMBER;
BEGIN
    -- Check balances
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id FOR UPDATE;
    SELECT Balance INTO v_to_balance FROM Accounts WHERE AccountID = p_to_account_id FOR UPDATE;

    -- Check if sufficient funds are available
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;

    -- Perform the transfer
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account_id;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/
