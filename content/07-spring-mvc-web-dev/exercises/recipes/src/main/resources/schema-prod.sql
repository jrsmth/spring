-- ----------------------- --
-- Create Databases ------ --
-- ----------------------- --
# CREATE DATABASE spring_recipe_prod; -- create first, connect via IntelliJ and then run the script below

-- ----------------------- --
-- Create service accounts --
-- ----------------------- --
CREATE USER 'spring_recipe_prod_user'@'localhost' IDENTIFIED BY 'secret-prod';
CREATE USER 'spring_recipe_prod_user'@'%' IDENTIFIED BY 'secret-prod';
# Question :: Why do we use both @'localhost' and @'%', rather than just the latter?

-- ---------------------- --
-- Database Grants ------ --
-- ---------------------- --
GRANT SELECT ON spring_recipe_prod.* to 'spring_recipe_prod_user'@'localhost';
GRANT INSERT ON spring_recipe_prod.* to 'spring_recipe_prod_user'@'localhost';
GRANT DELETE ON spring_recipe_prod.* to 'spring_recipe_prod_user'@'localhost';
GRANT UPDATE ON spring_recipe_prod.* to 'spring_recipe_prod_user'@'localhost';
GRANT SELECT ON spring_recipe_prod.* to 'spring_recipe_prod_user'@'%';
GRANT INSERT ON spring_recipe_prod.* to 'spring_recipe_prod_user'@'%';
GRANT DELETE ON spring_recipe_prod.* to 'spring_recipe_prod_user'@'%';
GRANT UPDATE ON spring_recipe_prod.* to 'spring_recipe_prod_user'@'%';