DECLARE
    CURSOR c_transactions IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
    
    v_customer_id Customers.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN c_transactions;
    LOOP
        FETCH c_transactions INTO v_customer_id, v_name, v_transaction_date, v_amount, v_transaction_type;
        EXIT WHEN c_transactions%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' (ID: ' || v_customer_id || ')');
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || TO_CHAR(v_transaction_date, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || v_transaction_type);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_amount);
        DBMS_OUTPUT.PUT_LINE('-------------------------');
    END LOOP;
    CLOSE c_transactions;
END;
/
