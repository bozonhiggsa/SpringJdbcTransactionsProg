DROP TABLE IF EXISTS spring_jdbc_transactions.public.DEVELOPERS CASCADE;
DROP TABLE IF EXISTS spring_jdbc_transactions.public.PROJECTS CASCADE;

CREATE TABLE spring_jdbc_transactions.public.DEVELOPERS
(
  ID serial NOT NULL,
  NAME character varying(50) NOT NULL,
  SPECIALITY character varying(50) NOT NULL,
  EXPERIENCE INT NOT NULL,
  CONSTRAINT IDr PRIMARY KEY (ID)
)
WITH (
OIDS = FALSE
)
;

CREATE TABLE spring_jdbc_transactions.public.PROJECTS
(
  DEVELOPERS_ID INT NOT NULL,
  NAME character varying(50) NOT NULL,
  COMPANY character varying(50) NOT NULL
)
WITH (
OIDS = FALSE
)
;