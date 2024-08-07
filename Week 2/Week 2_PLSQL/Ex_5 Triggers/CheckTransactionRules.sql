CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Check if the transaction is a withdrawal
    IF :NEW.TransactionType = 'withdrawal' THEN
        -- Retrieve the current balance of the account
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID FOR UPDATE;

        -- Ensure the withdrawal does not exceed the balance
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for the withdrawal.');
        END IF;

        -- Update the account balance
        UPDATE Accounts SET Balance = Balance - :NEW.Amount WHERE AccountID = :NEW.AccountID;
    ELSIF :NEW.TransactionType = 'deposit' THEN
        -- Ensure the deposit amount is positive
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;

        -- Update the account balance
        UPDATE Accounts SET Balance = Balance + :NEW.Amount WHERE AccountID = :NEW.AccountID;
    ELSE
        RAISE_APPLICATION_ERROR(-20003, 'Invalid transaction type.');
    END IF;
END CheckTransactionRules;
/
