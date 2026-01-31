-- flavor만 출력
-- total_order>=3000 and ingredient is 과일
-- order total_order desc

SELECT first_half.flavor from
first_half inner join icecream_info
on first_half.flavor=icecream_info.flavor
where first_half.total_order>=3000 and icecream_info.ingredient_type='fruit_based';