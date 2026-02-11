-- 자동차 종류가 세단, suv
-- 2022년 11월 중에 대여 가능
-- 30일간 대여 금액이 50만원 이상, 200만원 미만

select c.car_id,c.car_type,c.fee from 
(

select a.car_id, a.car_type, round(a.daily_fee*(100-b.discount_rate)/100*30) as fee
from car_rental_company_car a
inner join car_rental_company_discount_plan b
on a.car_type=b.car_type
where car_id not in (
   select car_id
from car_rental_company_rental_history
where start_date < "2022-12-01"
  and end_date   >= "2022-11-01"

) 
and b.duration_type='30일 이상'

)c
where c.fee between 500000 and 2000001
order by c.fee desc, c.car_type, c.car_id desc
