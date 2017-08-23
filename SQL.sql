select employee_id, 
       first_name, 
	   last_name, 
	   salary
 from employees;

-------------------------------------------------


select * from author;

update author set name='도우넛' where no = 12;

insert into author values( seq_author.nextval, '', '');

rollback;