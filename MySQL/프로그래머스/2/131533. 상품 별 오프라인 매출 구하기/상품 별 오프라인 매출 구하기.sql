-- 상품 코드별 매출액 합계
SELECT p.product_code,sum(sales_amount)*p.price as sales
from product p
join offline_sale os
on p.product_id=os.product_id
group by p.product_code,p.price
order by sales desc, product_code

