-- 입양을 
SELECT ao.animal_id,ao.name
from animal_outs ao
left outer join animal_ins ai
on ai.animal_id=ao.animal_id
where ai.animal_id is null
order by ao.animal_id