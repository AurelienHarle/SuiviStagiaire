CREATE USER admin_suivi_stag
IDENTIFIED by p4ssw0rd
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON USERS
PROFILE profil_admin_suivi_stag
ROLE role_admin_suivi_stag
ACCOUNT UNLOCK;

CREATE ROLE role_admin_suivi_stag;

GRANT ALL PRIVILEGES TO role_admin_suivi_stag; 
commit;

GRANT role_admin_suivi_stag TO admin_suivi_stag;