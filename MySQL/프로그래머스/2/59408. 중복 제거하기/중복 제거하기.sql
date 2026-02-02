-- 동물의 이름 몇개
select count(distinct(name)) from animal_ins
where name is not null;