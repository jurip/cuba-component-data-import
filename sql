


insert INTO counter_agent (account_number, account_name)
SELECT DISTINCT counter_agent_account_number, counter_agent
FROM ddcdi_operation cr
WHERE
   NOT EXISTS (SELECT * FROM counter_agent c
              WHERE cr.counter_agent_account_number = c.account_number)
              
              
              
              
              
              update ddcdi_operation set operation_date = to_date(operation_date_text,'dd.mm.yyyy')
              
              
              
              update ddcdi_operation set operation_date = to_date(operation_date_text,'dd.mm.yyyy');
update ddcdi_operation set incomeg = to_number(coalesce(income,'0'),'999999999.99');
update ddcdi_operation set outcomeg = to_number(coalesce(outcome,'0') ,'999999999.99');


update ddcdi_operation set operation_date = to_date(operation_date_text,'dd.mm.yyyy');
update ddcdi_operation set incomeg = to_number(case when income = '' then '0' else income end ,'999999999.99');
update ddcdi_operation set outcomeg = to_number(case when income = '' then '0' else income end ,'999999999.99');





select o.bank, o.account_number,  o.operation_date,nrg , p.income, p.outcome, p.balanc, o.ostatok 
from
(select distinct on (account_number, operation_date) operation_date ,bank, ostatok , account_number , nrg
from ddcdi_operation do2 
order by account_number, operation_date, nrg desc) as o
join
(select operation_date , sum(incomeg - outcomeg) as balanc, sum(incomeg) as income, sum(outcomeg) as outcome 
from ddcdi_operation do3 
group by account_number, operation_date 
order by account_number, operation_date asc) as p on p.operation_date = o.operation_date





select do2.account_number, do2.counter_agent_account_number , do3.counter_agent_account_number
from ddcdi_operation do2 
left outer join
(select * 
from ddcdi_operation do3) as do3
on(do2.counter_agent_account_number = do3.account_number)
where do2.counter_agent_account_number is not null






create view месячный_отчет as SELECT o.bank as БАНК,
    o.account_number as СЧЕТ,
    o.mm as МЕСЯЦ,
    o.yyyy as ГОД,
    p.income as ЗАЧИСЛЕНИЯ,
    p.outcome as СПИСАНИЯ,
    p.balanc as БАЛАНС,
    o.ostatok AS "конечный_остаток",
    o.ostatok - p.balanc AS "начальный_остаток"
   FROM ( SELECT DISTINCT ON 
   (do2.account_number, date_part('month'::text, do2.operation_date),
    		date_part('year'::text, do2.operation_date))
    		date_part('month'::text, do2.operation_date) as mm,
    		date_part('year'::text, do2.operation_date) as yyyy,
            do2.bank,
            do2.ostatok,
            do2.account_number,
            do2.nrg
           FROM ddcdi_operation do2
          ORDER BY do2.account_number, yyyy, mm, do2.nrg DESC) o
     JOIN ( SELECT account_number, date_part('month'::text, do3.operation_date) as m,
    		date_part('year'::text, do3.operation_date) as y,
            sum(do3.incomeg - do3.outcomeg) AS balanc,
            sum(do3.incomeg) AS income,
            sum(do3.outcomeg) AS outcome
           FROM ddcdi_operation do3
          GROUP BY do3.account_number, y,m
          ORDER BY do3.account_number, y,m) p ON (o.account_number = p.account_number and mm = m and yyyy = y)
          where o.yyyy != -1
          
          ;
