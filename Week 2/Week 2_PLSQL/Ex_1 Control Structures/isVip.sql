ALTER TABLE Customers ADD IsVIP CHAR(1) DEFAULT 'F';

DECLARE
    v_vip_balance NUMBER := 10000;
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    FOR customer_rec IN c_customers LOOP
        IF customer_rec.Balance > v_vip_balance THEN
            UPDATE Customers
            SET IsVIP = 'T'
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
