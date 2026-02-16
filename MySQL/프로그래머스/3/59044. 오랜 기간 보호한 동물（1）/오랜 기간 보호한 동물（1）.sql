-- animal_outs에 없는 animal_id를 구하고 datetime 기준으로 정렬 limit

SELECT ai.name, ai.datetime from 
animal_ins ai
where ai.name is not null 
and ai.animal_id not in (
select ao.animal_id from animal_outs ao
where ao.name is not null)
order by ai.datetime
limit 3