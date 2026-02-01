-- 동일한 회원이 동일한 상품을 재구매
select user_id,product_id from online_sale
group by user_id, product_id
having count(product_id)>1
order by user_id, product_id desc;