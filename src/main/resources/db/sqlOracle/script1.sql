CREATE TABLE ITEMS
(
  ID NUMBER NOT NULL
, PARENT_ID NUMBER
, NAME_ITEM VARCHAR2(250)
, COUNT_ITEM VARCHAR2(250)
, CONSTRAINT ITEMS_PK PRIMARY KEY
  (
    ID
  )
  ENABLE
);

insert into items (id,parent_id,name_item,count_item) values (1,null,'sbory',null);
insert into items (id,parent_id,name_item,count_item) values (2,1,'africa',null);
insert into items (id,parent_id,name_item,count_item) values (3,1,'azia',null);
insert into items (id,parent_id,name_item,count_item) values (4,2,'opt',null);
insert into items (id,parent_id,name_item,count_item) values (5,2,'roznica',null);
insert into items (id,parent_id,name_item,count_item) values (6,4,'sbor1',1);
insert into items (id,parent_id,name_item,count_item) values (7,4,'sbor3',3);
insert into items (id,parent_id,name_item,count_item) values (8,5,'sbor2',2);
insert into items (id,parent_id,name_item,count_item) values (9,5,'sbor3',5);
insert into items (id,parent_id,name_item,count_item) values (10,3,'opt',null);
insert into items (id,parent_id,name_item,count_item) values (11,3,'roznica',null);
insert into items (id,parent_id,name_item,count_item) values (12,10,'sbor5',5);
insert into items (id,parent_id,name_item,count_item) values (13,10,'sbor7',7);
insert into items (id,parent_id,name_item,count_item) values (14,10,'sbor2',4);
insert into items (id,parent_id,name_item,count_item) values (15,11,'sbor1',3);
commit;

SELECT id, parent_id, name_item,count_item,SYS_CONNECT_BY_PATH(name_item, '/') "Path"
      FROM items
      START WITH parent_id is null
      CONNECT BY PRIOR id = parent_id;
      update items

update ITEMS s
   set s.PATH = (
SELECT SYS_CONNECT_BY_PATH(name_item, '/') "Path"
      FROM items ss
      where s.ID = ss.ID
      START WITH parent_id is null
      CONNECT BY PRIOR id = parent_id);