-- a는 부모, b는 자식
select a.id as id,
count(b.id) as child_count
from ecoli_data a left outer join ecoli_data b
on a.id=b.parent_id
group by a.id
order by a.id;