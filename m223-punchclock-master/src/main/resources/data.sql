/* User: admin, Password: supperpassword*/
INSERT INTO PUBLIC.APPLICATION_USER (ID, E_ROLE, PASSWORD, USERNAME, ACTIVE)
VALUES (1, 2, '$2a$10$kl4mzDxIFSRNtV2Kloxpo.XHxjNak5oKneAF7BqGDkljlsrdJjA2C', 'admin', true);

/* User: user, Password: supperpassword*/
INSERT INTO PUBLIC.APPLICATION_USER (ID, E_ROLE, PASSWORD, USERNAME, ACTIVE)
VALUES (2, 1, '$2a$10$kl4mzDxIFSRNtV2Kloxpo.XHxjNak5oKneAF7BqGDkljlsrdJjA2C', 'user', true);

INSERT INTO PUBLIC.CATEGORY (ID, APPLICATION_USER_ID, DESCRIPTION, E_ICON, NAME) VALUES (1, 2, 'test', 1, 'important');
INSERT INTO PUBLIC.CATEGORY (ID, APPLICATION_USER_ID, DESCRIPTION, E_ICON, NAME) VALUES (2, 2, 'second test', 2, 'nice');
INSERT INTO PUBLIC.CATEGORY (ID, APPLICATION_USER_ID, DESCRIPTION, E_ICON, NAME) VALUES (3, 2, 'second test', 3, 'bad');

INSERT INTO PUBLIC.PLACE (ID, APPLICATION_USER_ID, E_ICON, NAME) VALUES (1, 2, 1, null);

INSERT INTO PUBLIC.ENTRY (ID, APPLICATION_USER_ID, CHECK_IN, CHECK_OUT, CATEGORIE_ID, PLACE_ID) VALUES (1, 2, '2021-09-29 16:34:11.000000', '2021-09-29 18:34:14.000000', 1, 1);
