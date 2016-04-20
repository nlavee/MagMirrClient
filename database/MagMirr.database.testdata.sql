use magmirr;

# INSERT TEST DATA FOR USER
insert into user (username, first_name, last_name, email, password_id) values ("test_david", "David", "Jones", "djones@magmirr.com", 1);
insert into user (username, first_name, last_name, email, password_id) values ("test_nujabes", "Nujabes", "Aiki", "naiki@magmirr.com", 1);
insert into user (username, first_name, last_name, email, password_id) values ("test_admin", "Okawari", "Mirror", "omirror@magmirr.com", 1);
insert into user (username, first_name, last_name, email, password_id) values ("test_user", "Wade", "Wilson", "wwilson@magmirr.com", 1);

# INSERT TEST DATA FOR PWD
insert into password (pw_hash, salt) values ("d43e5e577e46a25d7645cdb2f7793017", "[B@239cf00a");

# INSERT TEST DATA FOR PRIVILEGE
insert into privilege (privilege_description, privilege_name) values ("sudo user", "root");
insert into privilege (privilege_description, privilege_name) values ("admin user", "admin");
insert into privilege (privilege_description, privilege_name) values ("normal user", "norm");
insert into privilege (privilege_description, privilege_name) values ("guest user", "guest");

