



## Useful SQL Commands
* Access MySQL via CLI:
    * `mysqld`
    * `mysql -u root`
* Set up local database:
    ```sql
        CREATE DATABASE <DATABASE_NAME>;
    ```


* mysqld
mysql -u root
create database jara3_db;
create user 'jara3-dev'@'%' identified by 'password';
grant all on jara3_db.* to 'jara3-dev'@'%';
View all local users
mysql -u root
use jara3_db;
select * from j3_user;
quit
Delete all local users
mysql -u root
use jara3_db;
truncate table j3_user;
quit


* Commands:
    * `SHOW DATABASES;` :: List databases on the server
    * `USE <DATABASE_NAME>;` :: Select a database for use
    * `SHOW TABLES;` :: List available tables for the selected database
    * `SELECT * FROM <TABLE_NAME>;` :: Query all rows for a given table
    * `help` :: List popular MySQL commands
* Exit the CLI tool:
    * `exit`
    * `quit`