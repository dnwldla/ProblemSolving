-- 생일 3월 여자  / 전화번호 null이면 제외 
-- id asc

select member_id, member_name, gender, date_format(date_of_birth,'%Y-%m-%d') as date_of_birth
from member_profile
where month(member_profile.date_of_birth)='3' and tlno is not null and gender='W'
order by member_id;