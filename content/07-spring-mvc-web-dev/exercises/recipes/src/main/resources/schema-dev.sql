# Note :: technically, we should not be using schema-autogen.sql to set up the actual db structure; instead, we should be defining tables here

-- ----------------------- --
-- Create Databases ------ --
-- ----------------------- --
# CREATE DATABASE spring_recipe_dev; -- create first, connect via IntelliJ and then run the script below

-- ----------------------- --
-- Create service accounts --
-- ----------------------- --
CREATE USER 'spring_recipe_dev_user'@'localhost' IDENTIFIED BY 'secret-dev';
CREATE USER 'spring_recipe_dev_user'@'%' IDENTIFIED BY 'secret-dev';
# Question :: Why do we use both @'localhost' and @'%', rather than just the latter?

-- ---------------------- --
-- Database Grants ------ --
-- ---------------------- --
GRANT SELECT ON spring_recipe_dev.* to 'spring_recipe_dev_user'@'localhost';
GRANT INSERT ON spring_recipe_dev.* to 'spring_recipe_dev_user'@'localhost';
GRANT DELETE ON spring_recipe_dev.* to 'spring_recipe_dev_user'@'localhost';
GRANT UPDATE ON spring_recipe_dev.* to 'spring_recipe_dev_user'@'localhost';
GRANT SELECT ON spring_recipe_dev.* to 'spring_recipe_dev_user'@'%';
GRANT INSERT ON spring_recipe_dev.* to 'spring_recipe_dev_user'@'%';
GRANT DELETE ON spring_recipe_dev.* to 'spring_recipe_dev_user'@'%';
GRANT UPDATE ON spring_recipe_dev.* to 'spring_recipe_dev_user'@'%';