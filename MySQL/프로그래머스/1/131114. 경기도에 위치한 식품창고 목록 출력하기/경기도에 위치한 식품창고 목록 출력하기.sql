-- 냉동시설 여부 null n
-- 창고 id, 이름, 주소, 냉동시설 여부

select warehouse_id, warehouse_name, address, ifnull(freezer_yn,'N') as freezer_yn
from food_warehouse
where address like '경기도%';