-- 2022년 1월 카테고리별 도서 판매량
select a.category, sum(b.sales) as total_sales from 
book a inner join book_sales b
on a.book_id=b.book_id
where b.sales_date like '2022-01%'
group by a.category
order by category






;