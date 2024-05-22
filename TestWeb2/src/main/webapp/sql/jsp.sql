CREATE TABLE tbl_products (
	product_code	number		NOT NULL,
	product_name	varchar2(100 char)		NULL,
	price	number		NULL,
	add_date	date	default sysdate,
	main_category	varchar2(30 char)		NULL,
	sub_category	varchar2(30 char)		NULL,
	product_img	varchar2(200 char)		NULL
);

ALTER TABLE tbl_products ADD CONSTRAINT PK_TBL_PRODUCTS PRIMARY KEY (
	product_code
);


create sequence products_seq;

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','¼Ò½º ´ß°¡½¿»ì');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','ºñ¿£³ª');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','ÈÄ¶ûÅ©/²¿Ä¡');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','º¼/Å¥ºê');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','½ºÅ×ÀÌÅ©');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','¼öºñµå');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','ÈÆÁ¦ ´ß°¡½¿»ì');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','¿Àºì±¸ÀÌ ´ß°¡½¿»ì');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','½½¶óÀÌ½ºÇÜ/Ä¡ÆÔ');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','´ß°¡½¿»ì','»ý´ß°¡½¿»ì');


insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','°£Æí ÇÑ³¢/¹ÝÂù','°íÃß¹Ù»ç»è');

insert into tbl_products(PRODUCT_CODE, PRODUCT_NAME, MAIN_CATEGORY, SUB_CATEGORY)
values(products_seq.nextval, 'test','°£Æí ÇÑ³¢/¹ÝÂù','µ·Ä«Ã÷º¼');

select sub_category
from tbl_products
where main_category = '´ß°¡½¿»ì';

select MAIN_CATEGORY, count(1)
from tbl_products
group by main_category
order by main_category;

select MAIN_CATEGORY,sub_category
from tbl_products
order by main_category;

select sub_category
from tbl_products
where main_category = '´ß°¡½¿»ì';




CREATE TABLE tbl_orders (
	order_no	number		NOT NULL,
	member_id	varchar2(30 char)		NULL,
	order_date	date		NULL,
	total_price	number		NULL,
	order_status	varchar2(30 char)		NULL,
	delivery_address	varchar2(200 char)		NULL
);

CREATE TABLE tbl_details (
	detail_no	number		NOT NULL,
	order_no	number		NULL,
	product_code	number		NULL,
	option_code	number		NULL,
	count	number		NULL,
	price	number		NULL,
	member_id	varchar2(30 char)		NULL
);

ALTER TABLE tbl_orders ADD CONSTRAINT PK_TBL_ORDERS PRIMARY KEY (
	order_no
);

ALTER TABLE tbl_details ADD CONSTRAINT PK_TBL_DETAILS PRIMARY KEY (
	detail_no
);

create sequence orders_seq;
create sequence details_seq;

insert into tbl_details(DETAIL_NO, ORDER_NO, PRODUCT_CODE)
values(details_seq.nextval, 1, 5);

select product_code, count(1) 
from tbl_details 
group by product_code
order by 2 desc;


select * from tbl_products where product_code=1;

