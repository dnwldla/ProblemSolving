-- 회원의 리뷰량 등수를 정한다
select mf.member_name,c.review_text,date_format(c.review_date,"%Y-%m-%d") as review_date
from member_profile mf
join 
(select a.member_id, a.review_text,a.review_date from rest_review a
inner join (
select member_id, dense_rank() over (order by count(*) desc) as r
from rest_review
group by member_id) b
on a.member_id=b.member_id
where r=1) c
on mf.member_id=c.member_id
order by review_date, review_text