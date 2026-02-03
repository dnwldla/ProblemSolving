-- 2022년도 평가 점수가 가장 높은 사원점수 -> 상하반기 점수 

-- 1. 평가 점수가 높은 emp_no를 찾는다 -> 그다음 조인 

select b.score,a.emp_no,a.emp_name,a.position,a.email from hr_employees a
inner join (
select emp_no,sum(score) as score
from hr_grade
group by emp_no
order by score desc limit 1
) b
on a.emp_no=b.emp_no
;

