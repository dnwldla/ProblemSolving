select id,
case when size<=0.25 then 'CRITICAL'
    when size<=0.5 then 'HIGH'
    when size<=0.75 then 'MEDIUM'
    else 'LOW'
end as colony_name
from(

select id, percent_rank() over (order by size_of_colony desc) as size
from ecoli_data) a
order by id