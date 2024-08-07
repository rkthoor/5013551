CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    -- Calculate the age in years
    v_age := FLOOR((SYSDATE - p_dob) / 365.25);
    RETURN v_age;
END CalculateAge;
/
