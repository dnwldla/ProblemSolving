-- food_type별로 즐겨찾기가 많은 식당

select food_type,rest_id,rest_name,favorites
from (
select food_type,rest_id, rest_name, dense_rank() over(partition by food_type order by favorites desc) as r,favorites
from rest_info
    )a
    where a.r=1
    order by food_type desc
