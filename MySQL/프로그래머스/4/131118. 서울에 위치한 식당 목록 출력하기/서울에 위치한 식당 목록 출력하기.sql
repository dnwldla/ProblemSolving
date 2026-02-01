-- rest_info 테이블, rest_review 테이블-> 1:n-> left outer ok
--  where 서울에 위치한 식당 ok
-- 리뷰 평균점수 round 3 ok
-- 정렬: 평균점수 desc, 즐겨찾기 desc
SELECT a.rest_id, a.rest_name, a.food_type, a.favorites, a.address,
round(avg(b.review_score),2) as score
from rest_info a inner join rest_review b
on a.rest_id=b.rest_id
where a.address like '서울%'
group by a.rest_id
order by score desc, a.favorites desc;