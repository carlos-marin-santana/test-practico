--------------------------------------------------------
-- Archivo creado  - martes-noviembre-01-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function CHECK_LEGAL_AGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "CARLOS"."CHECK_LEGAL_AGE" 
(
  BIRTHDATE IN DATE 
) RETURN NUMBER AS 
BEGIN
  RETURN floor(MONTHS_BETWEEN(SYSDATE, BIRTHDATE))/12;
END CHECK_LEGAL_AGE;

/
