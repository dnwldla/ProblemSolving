-- car_id별로 2022년 8월~10월까지 대여횟수가 5회 이상인 car_id를 찾는다
select month(start_date) as month,car_id,count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31'
and car_id in (
select car_id from 
(select car_id,count(*) as cnt
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between '2022-08-01' and '2022-10-31'
group by car_id
)b
where b.cnt>=5
)
group by month(start_date),car_id
order by month,car_id desc


;

