-- 식품 정보, 주문정보
-- 생산일자가 2022년 5월: produce_date
-- 아니 근데 id가 있는데 다른게 null이면 어케 처리해야 하냐
select a.product_id,a.product_name,sum(price*amount) as total_sales from food_product a 
join (
SELECT product_id,amount from food_order
where produce_date like '2022-05%'
) b
on a.product_id=b.product_id

group by a.product_id,a.product_name
order by total_sales desc,product_id