-- 2022년 3월 오프라인, 온라인 날짜-> Union
SELECT DATE_Format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, 
           PRODUCT_ID,
           USER_ID,  
           SALES_AMOUNT 
        from ONLINE_SALE 
        where Month(SALES_DATE) = 3
union
SELECT DATE_Format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, 
           PRODUCT_ID,
           null as USER_ID,  
           SALES_AMOUNT 
        from OFFLINE_SALE 
        where Month(SALES_DATE) = 3
order by sales_date, product_id, user_id;