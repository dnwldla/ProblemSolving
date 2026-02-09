-- item_tree에서 item_id가 parent_item_id에 존재하지 않는다

select item_id,item_name,rarity
from item_info
where item_id not in (select parent_item_id from item_tree where parent_item_id is not null)
order by item_id desc;

