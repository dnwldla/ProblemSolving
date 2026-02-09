select round(avg(a.length),2) as average_length
from(
select id, ifnull(length,10) as length
from fish_info
    ) a