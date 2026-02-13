select member_name, review_text,date_format(review_date,'%Y-%m-%d') as "review_date"
from rest_review r
inner join member_profile m
on r.member_id=m.member_id
where r.member_id=
(select member_id from rest_review
group by member_id
order by count(review_score) desc
limit 1)
order by review_date,review_text