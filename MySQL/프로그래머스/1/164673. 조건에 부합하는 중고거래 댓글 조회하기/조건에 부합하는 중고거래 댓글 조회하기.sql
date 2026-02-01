-- 2022년 10월
SELECT a.title,a.board_id,b.reply_id,b.writer_id,b.contents,date_format(b.created_date,'%Y-%m-%d') as created_date
from used_goods_board a inner join used_goods_reply b
on a.board_id=b.board_id
where date_format(a.created_date,'%Y-%m-%d') like '2022-10%'
order by b.created_date,a.title;
