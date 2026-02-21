-- fish type 기준으로 
select id,fish_name,length from (
select fi.id,fni.fish_name, length, rank() over (partition by fi.fish_type order by length desc) as r
from fish_info fi
join fish_name_info fni on fi.fish_type=fni.fish_type
) tb
where r=1
order by id