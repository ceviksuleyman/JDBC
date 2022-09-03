--Function Olusturma

--TASK-1 : iki parametre ile calisip bu parametreleri toplayarak return yapan bir fonksiyon olusturun.

CREATE OR REPLACE FUNCTION toplamaF(x NUMERIC,y NUMERIC) -->Replace -> olustur veya uzerine yaz.
RETURNS NUMERIC
LANGUAGE plpgsql
AS
$$
BEGIN

RETURN x+y;

END
$$


SELECT * FROM toplamaF(14,21) AS toplam;



-- TASK-2 : Koninin hacmini hesaplayan bir function yazın.

CREATE OR REPLACE FUNCTION koniAlan(x NUMERIC, y NUMERIC)
RETURNS NUMERIC
LANGUAGE plpgsql
AS
$$
BEGIN

RETURN (3.14*(x*x*y))/3;

END
$$


SELECT * FROM koniAlan(3,5) AS koniAlan

