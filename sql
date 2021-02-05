


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



CREATE OR REPLACE VIEW public.operation_by_year_account
AS SELECT
    date_part('year'::text, operation.op_date) AS yyyy,
    sum(operation.income) AS income,
    sum(operation.outcome) AS outcome,
    operation.account_number
   FROM operation
  GROUP BY operation.account_number, (date_part('year'::text, operation.op_date))
  ORDER BY operation.account_number;



  CREATE OR REPLACE VIEW public.годовой_отчет_общий
  AS SELECT
      o.yyyy AS "ГОД",
      p.income AS "ЗАЧИСЛЕНИЯ",
      p.outcome AS "СПИСАНИЯ",
      p.balanc AS "БАЛАНС",
      o.ostatok AS "конечный_остаток",
      o.ostatok - p.balanc AS "начальный_остаток",
      o.account_number as "счет",
      da.bank ,
      da.company ,
      da."name" as "naimenovanie"
     FROM ( SELECT DISTINCT ON (date_part('year'::text, do2.operation_date), do2.account_number)
              date_part('year'::text, do2.operation_date) AS yyyy,
              do2.ostatok,
              do2.nrg,
              do2.account_number
             FROM ddcdi_operation do2
            ORDER BY (date_part('year'::text, do2.operation_date)), do2.account_number, do2.nrg DESC) o
       JOIN ( SELECT
              date_part('year'::text, do3.operation_date) AS y,
              sum(do3.incomeg - do3.outcomeg) AS balanc,
              sum(do3.incomeg) AS income,
              sum(do3.outcomeg) AS outcome,
              do3.account_number  as account_number
             FROM ddcdi_operation do3
            GROUP BY (date_part('year'::text, do3.operation_date), do3.account_number)
            ORDER BY (date_part('year'::text, do3.operation_date))) p ON o.yyyy = p.y and o.account_number = p.account_number
            left outer join ddcdi_account da on p.account_number = da.account_number

            WHERE o.yyyy <> '-1'::integer::double precision






    ;



    drop view годовой_отчет_общий;
    CREATE OR REPLACE VIEW public.годовой_отчет_общий
    AS SELECT
        o.yyyy AS "ГОД",
        p.income AS "ЗАЧИСЛЕНИЯ",
        p.outcome AS "СПИСАНИЯ",
        p.balanc AS "БАЛАНС",
        o.ostatok AS "конечный_остаток",
        o.ostatok - p.balanc AS "начальный_остаток",
        o.account_number AS "СЧЕТ",
        da.bank,
        da.company,
        da.name AS naimenovanie,
        md5(random()::text || clock_timestamp()::text)::uuid as id,
        null as delete_ts,
        null as deleted_by,
        null as version
       FROM ( SELECT DISTINCT ON ((date_part('year'::text, do2.operation_date)), do2.account_number) date_part('year'::text, do2.operation_date) AS yyyy,
                do2.ostatok,
                do2.nrg,
                do2.account_number
               FROM ddcdi_operation do2
              ORDER BY (date_part('year'::text, do2.operation_date)), do2.account_number, do2.nrg DESC) o
         JOIN ( SELECT date_part('year'::text, do3.operation_date) AS y,
                sum(do3.incomeg - do3.outcomeg) AS balanc,
                sum(do3.incomeg) AS income,
                sum(do3.outcomeg) AS outcome,
                do3.account_number
               FROM ddcdi_operation do3
              GROUP BY (date_part('year'::text, do3.operation_date)), do3.account_number
              ORDER BY (date_part('year'::text, do3.operation_date))) p ON o.yyyy = p.y AND o.account_number::text = p.account_number::text
         LEFT JOIN ddcdi_account da ON p.account_number::text = da.account_number::text;




         CREATE FUNCTION emp_stamp() RETURNS trigger AS $emp_stamp$
             BEGIN
                 -- Проверить, что указаны имя сотрудника и зарплата
                 IF NEW.operation_date_text IS not NULL THEN
                     new.operation_date = dt_or_null(new.operation_date_text,'dd.mm.yyyy');
                 END IF;
                RETURN NEW;
             END;
         $emp_stamp$ LANGUAGE plpgsql;

         CREATE TRIGGER emp_stamp BEFORE INSERT OR UPDATE ON ddcdi_operation
             FOR EACH ROW EXECUTE PROCEDURE emp_stamp();


             drop trigger emp_stamp on ddcdi_operation;
             drop function emp_stamp;
             CREATE FUNCTION emp_stamp() RETURNS trigger AS $emp_stamp$
                          BEGIN
                              -- Проверить, что указаны имя сотрудника и зарплата
                              IF NEW.operation_date_text IS not NULL THEN
                                  new.operation_date = dt_or_null(new.operation_date_text,'dd.mm.yyyy');
                              END IF;
                             RETURN NEW;
                          END;
                      $emp_stamp$ LANGUAGE plpgsql;










                      create or replace function dt_or_null (s text, fmt text)

                      returns date
                      as
                      $$
                      begin

                      return to_date(s, fmt);

                      exception
                      when others then return null;

                      end;

                      $$ language plpgsql;