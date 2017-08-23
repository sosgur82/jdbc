-- drop & create sequence
drop sequence seq_author;
create sequence seq_author
start with 1
increment by 1
maxvalue 9999999999;

drop sequence seq_book;
create sequence seq_book
start with 1
increment by 1
maxvalue 9999999999;

-- author getList 
  select no, name, profile 
    from author
order by no;

-- author insert
insert 
  into author
values ( seq_author.nextval, 'dqwd', 'dqwdwq');

select * from author;    


-- book getList 
  select a.no, a.title, a.state, b.name  
    from book a,
	     author b
   where a.author_no = b.no		 
order by a.no;
