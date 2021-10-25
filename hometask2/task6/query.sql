
---- Вывести список получателей платежей и сумму поатежей по каждому из них ----
SELECT name, SUM(value)
FROM receivers r,
     expenses e
WHERE r.id = e.receiver
GROUP BY name;

---- Вывести сумму платежей за тот день, когда был совершен наибольший платеж ----
SELECT paydate, SUM(value) as S
FROM expenses
WHERE paydate = (SELECT paydate
                 FROM expenses
                 WHERE value = (SELECT MAX(value) FROM expenses))
GROUP BY paydate;

---- Вывест наибольший платеж за тот день, когда сумма платежей была наибольшей ----
SELECT result.m AS 'MAX AMOUNT OF EXPENSE'
FROM (SELECT paydate, SUM(value) as s, MAX(value) as m
      FROM expenses
      GROUP BY paydate) result
WHERE result.s = (
    SELECT max(s)
    FROM (SELECT sum(value) AS s
          FROM expenses
          GROUP BY paydate) maxSum);
