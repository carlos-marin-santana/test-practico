--------------------------------------------------------
-- Archivo creado  - martes-noviembre-01-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure CHECK_EXISTING_EMPLOYEES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "CARLOS"."CHECK_EXISTING_EMPLOYEES" 
(
  V_GENDER_ID IN LONG 
, V_JOB_ID IN LONG 
, V_NAME IN VARCHAR2 
, V_LAST_NAME IN VARCHAR2 
, V_BIRTHDATE IN DATE
, v_id out number
) AS 
BEGIN
    IF CHECK_LEGAL_AGE(V_BIRTHDATE) >= 18 THEN
        DBMS_OUTPUT.PUT_LINE ('SE TIENE LA EDAD MÍNIMA');
        DECLARE
            found NUMBER:=0;
            job_exists NUMBER :=0;
        BEGIN
            SELECT COUNT(*) INTO job_exists FROM JOBS WHERE JOBS.ID = V_JOB_ID AND ROWNUM=1;
            SELECT nvl((SELECT 1 FROM EMPLOYEES WHERE employees.name = v_name AND employees.last_name = v_last_name), 0) INTO found FROM dual;
            IF (found = 0 AND job_exists > 0) THEN
                INSERT INTO EMPLOYEES (GENDER_ID, JOB_ID, NAME, LAST_NAME, BIRTHDATE)
                VALUES (V_GENDER_ID, V_JOB_ID, V_NAME, V_LAST_NAME, V_BIRTHDATE)
                RETURNING ID INTO V_ID;
                DBMS_OUTPUT.PUT_LINE ('SE INSERTO ' || V_ID);
            ELSE
                DBMS_OUTPUT.PUT_LINE ('YA EXISTE REGISTRO');
            END IF;
        END;
    ELSE
        DBMS_OUTPUT.PUT_LINE ('NO SE CUMPLE MÍNIMO DE EDAD');
    END IF;

END CHECK_EXISTING_EMPLOYEES;

/
