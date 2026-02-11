-- 7월은 같은 맛이어도 shipment_id가 다를 수 있다 
-- 7월 group by flavor로 total_order을 더한다
-- union?
select flavor from (
    select flavor, sum(total_order) as total_order
from(
select flavor, total_order from first_half
union
select flavor,sum(total_order) 
from july
group by flavor
)b
group by b.flavor
order by total_order desc
limit 3
)c



