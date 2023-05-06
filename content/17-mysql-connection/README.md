# Connecting to MySQL
*Discussing Local, Client & Remote Connections to a MySQL Server*

<br>

## Overview
* Types of Connections:
    * Local:
        * Connecting to MySQL from the command-line on the machine that is running the database
            * The connection protocol is dependent on your operating system
                * These include:
                    - TCP/IP :: Most common
                    - SOCKET :: Unix / OSX (MacOS) / Linux only
                    - PIPE :: Windows only
                    - MEMORY :: Windows only
    * Remote / Client Connection:
        * ~Client :: Connecting to MySQL through some variety of client software on the same machine running the database
            * Such as IntelliJ, MySQL Workbench, SQLPro
        * ~Remote :: Connecting to the MySQL server from a different machine over the network 

<br>

## TCP / IP
* TCP / IP:
    * Transmission Control Protocol / Internet Protocol
* DNS:
    * Domain Name Service
    * Associates an IP Address (e.g `216.58.218.110`) with a human readable name
* Localhost:
    * The hostname that refers to the machine that you are currently using
    * IP Address: `127.0.0.1`, `0.0.0.0`
* Port:
    * Defines a specific logical connection endpoint on an IP Address
    * Range: `0` to `65535` (2^16 - 1)
    * By default, MySQL listens on port `3306`
        * One might choose to configure this to a different port, in order to obscure it for security reasons

<br>

## MySQL Basics via CLI
* Bring up the terminal:
    * `mysql`
        * Obstacle:
            * Error: `ERROR 2002 (HY000): Can't connect to local MySQL server through socket '/tmp/mysql.sock' (2)`
            * Open up a separate terminal and run `mysqld`
* Commands:
    * `SHOW DATABASES;` :: Show databases on the server
    * `USE <DATABASE_NAME>;` :: Select a database for use
    * `SHOW TABLES;` :: Show available tables for the selected database
    * `SELECT * FROM <TABLE_NAME>;` :: Query all rows for a given table
* Exit the CLI tool:
    * `exit`
    * `quit`