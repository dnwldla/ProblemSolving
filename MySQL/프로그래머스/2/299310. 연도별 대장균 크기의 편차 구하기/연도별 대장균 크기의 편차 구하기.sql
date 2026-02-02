-- 연도 별 대장균 크기가 큰 것
select year(differentiation_date) as YEAR,
(select max(size_of_colony) from ecoli_data
 where year(differentiation_date)=YEAR
group by year(differentiation_date)
)- size_of_colony as 'YEAR_DEV',
id
from ecoli_data
order by YEAR, YEAR_DEV;
