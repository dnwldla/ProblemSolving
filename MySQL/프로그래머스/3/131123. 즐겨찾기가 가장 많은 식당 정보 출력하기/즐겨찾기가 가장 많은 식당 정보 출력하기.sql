-- 코드를 입력하세요
-- 음식 종류별 즐겨찾기 수가 가장 많은 식당
-- 아우 max가 어렵네; 
select food_type,rest_id,rest_name,favorites
from rest_info a
where (a.favorites,a.food_type) in (
select max(favorites) as favorites, food_type
from rest_info 
group by food_type
)
order by food_type desc


;