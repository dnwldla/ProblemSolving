-- 2022년 1월 도서 where
-- 저자, 카테고리별 매출액
-- 뭐부터 해야 하냐면
-- 2022년 필터링 해서 group by 한다

--  작가 id 
select d.author_id,author_name,d.category, d.total_sales
from author c
left outer join (
select b.author_id, b.category, sum(a.sales*b.price) as total_sales from book_sales a
join book b
on a.book_id=b.book_id
where a.sales_date like '2022-01%'
group by b.author_id, b.category
) d
on c.author_id=d.author_id
order by author_id, category desc