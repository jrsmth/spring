# Noteworthy SQL Commands

<br>

### Docs
* Official [Docs](https://dev.mysql.com/doc/)

<br>

### Commands
* List available databases:
    * `SHOW DATABASES;`

<br>

* Create a database:
    * `CREATE DATABASE <DATABASE_NAME>;`

<br>

* Select a database for use:
    * `USE <DATABASE_NAME>;`

<br>

* List available tables:
    * `SHOW TABLES;`

<br>

* Select all rows from a table:
    * `SELECT * FROM <TABLE_NAME>;`

<br>

* Create a user with root access:
    * `CREATE USER '<USER_NAME>'@'%' IDENTIFIED by '<PASSWORD>';`
    * `GRANT ALL ON <DATABASE_NAME>.* TO '<USER_NAME>'@'%';`