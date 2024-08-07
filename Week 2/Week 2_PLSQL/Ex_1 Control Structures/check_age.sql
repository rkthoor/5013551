DECLARE
    v_customer_age NUMBER;
    v_discount NUMBER := 0.01; -- 1% discount
    CURSOR c_customers IS
        SELECT CustomerID, (SYSDATE - DOB) / 365 AS Age
        FROM Customers;
BEGIN
    FOR customer_rec IN c_customers LOOP
        v_customer_age := customer_rec.Age;
        IF v_customer_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - (InterestRate * v_discount)
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
