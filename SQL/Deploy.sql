Use master;
go
if DB_ID('BDD_QCM') is not null
	drop database BDD_QCM;
go
create database BDD_QCM;
go

use BDD_QCM;
go
CREATE
  TABLE EPREUVE
  (
    idEpreuve         INTEGER NOT NULL IDENTITY,
    dateDebutValidite DATETIME NOT NULL ,
    dateFinValidite   DATETIME NOT NULL ,
    tempsEcoule       INTEGER ,
    etat              CHAR (2) NOT NULL ,
    note_obtenue FLOAT ,
    niveau_obtenu CHAR (3) ,
    idTest        INTEGER NOT NULL ,
    idUtilisateur INTEGER NOT NULL ,
    CONSTRAINT EPREUVE_PK PRIMARY KEY CLUSTERED (idEpreuve)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO
ALTER TABLE EPREUVE
ADD
CHECK ( niveau_obtenu IN ('ACQ', 'ECA', 'NAC') )
GO

CREATE
  TABLE PROFIL
  (
    codeProfil CHAR (3) NOT NULL ,
    libelle    VARCHAR (100) NOT NULL ,
    CONSTRAINT PROFIL_PK PRIMARY KEY CLUSTERED (codeProfil)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE PROMOTION
  (
    codePromo CHAR (8) NOT NULL ,
    Libelle   VARCHAR (200) NOT NULL ,
    CONSTRAINT PROMOTION_PK PRIMARY KEY CLUSTERED (codePromo)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE PROPOSITION
  (
    idProposition INTEGER NOT NULL IDENTITY(1,1) ,
    enonce        VARCHAR (500) NOT NULL ,
    estBonne BIT NOT NULL ,
    idQuestion INTEGER NOT NULL ,
    CONSTRAINT PROPOSITION_PK PRIMARY KEY CLUSTERED (idProposition, idQuestion)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE QUESTION
  (
    idQuestion INTEGER NOT NULL IDENTITY,
    enonce     VARCHAR (500) NOT NULL ,
	estMultichoix bit not null, 
    media VARBINARY ,
    points  INTEGER NOT NULL ,
    idTheme INTEGER NOT NULL ,
    CONSTRAINT QUESTION_PK PRIMARY KEY CLUSTERED (idQuestion)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE QUESTION_TIRAGE
  (
    estMarquee BIT NOT NULL ,
    idQuestion INTEGER NOT NULL ,
    numordre   INTEGER NOT NULL ,
    idEpreuve  INTEGER NOT NULL ,
    CONSTRAINT QUESTION_TIRAGE_PK PRIMARY KEY CLUSTERED (idQuestion, idEpreuve)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE REPONSE_TIRAGE
  (
    idProposition INTEGER NOT NULL ,
    idQuestion    INTEGER NOT NULL ,
    idEpreuve     INTEGER NOT NULL ,
    CONSTRAINT REPONSE_TIRAGE_PK PRIMARY KEY CLUSTERED (idQuestion, idEpreuve,
    idProposition)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE SECTION_TEST
  (
    nbQuestionsATirer INTEGER NOT NULL ,
    idTest            INTEGER NOT NULL ,
    idTheme           INTEGER NOT NULL ,
    CONSTRAINT SECTION_TEST_PK PRIMARY KEY CLUSTERED (idTest, idTheme)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE TEST
  (
    idTest      INTEGER NOT NULL IDENTITY,
    libelle     VARCHAR (100) NOT NULL ,
    description VARCHAR (200) NOT NULL ,
    duree       INTEGER NOT NULL ,
    seuil_haut  INTEGER NOT NULL ,
    seuil_bas   INTEGER NOT NULL ,
    CONSTRAINT TEST_PK PRIMARY KEY CLUSTERED (idTest)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE THEME
  (
    idTheme INTEGER IDENTITY(1,1) NOT NULL ,
    libelle VARCHAR (200) NOT NULL ,
    CONSTRAINT THEME_PK PRIMARY KEY CLUSTERED (idTheme)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE UTILISATEUR
  (
    idUtilisateur INTEGER NOT NULL IDENTITY,
    nom           VARCHAR (250) NOT NULL ,
    prenom        VARCHAR (250) NOT NULL ,
    email         VARCHAR (250) NOT NULL ,
    password      VARCHAR (100) NOT NULL ,
    codeProfil    CHAR (3) NOT NULL ,
    codePromo     CHAR (8) ,
    CONSTRAINT UTILISATEUR_PK PRIMARY KEY CLUSTERED (idUtilisateur)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default" ,
  CONSTRAINT UTILISATEUR_EMAIL_UQ UNIQUE NONCLUSTERED (email) ON "default"
  )
  ON "default"
GO

ALTER TABLE UTILISATEUR
ADD CONSTRAINT Candidat_Promotion_FK FOREIGN KEY
(
codePromo
)
REFERENCES PROMOTION
(
codePromo
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE EPREUVE
ADD CONSTRAINT Epreuve_Candidat_FK FOREIGN KEY
(
idUtilisateur
)
REFERENCES UTILISATEUR
(
idUtilisateur
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE EPREUVE
ADD CONSTRAINT Epreuve_Test_FK FOREIGN KEY
(
idTest
)
REFERENCES TEST
(
idTest
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE PROPOSITION
ADD CONSTRAINT Proposition_Question_FK FOREIGN KEY
(
idQuestion
)
REFERENCES QUESTION
(
idQuestion
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE QUESTION
ADD CONSTRAINT Question_Theme_FK FOREIGN KEY
(
idTheme
)
REFERENCES THEME
(
idTheme
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE REPONSE_TIRAGE
ADD CONSTRAINT Reponse_Proposition_FK FOREIGN KEY
(
idProposition,
idQuestion
)
REFERENCES PROPOSITION
(
idProposition ,
idQuestion
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE REPONSE_TIRAGE
ADD CONSTRAINT Reponse_Tirage_FK FOREIGN KEY
(
idQuestion,
idEpreuve
)
REFERENCES QUESTION_TIRAGE
(
idQuestion ,
idEpreuve
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE SECTION_TEST
ADD CONSTRAINT Section_Test_FK FOREIGN KEY
(
idTest
)
REFERENCES TEST
(
idTest
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE SECTION_TEST
ADD CONSTRAINT Section_Theme_FK FOREIGN KEY
(
idTheme
)
REFERENCES THEME
(
idTheme
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE QUESTION_TIRAGE
ADD CONSTRAINT Tirage_Epreuve_FK FOREIGN KEY
(
idEpreuve
)
REFERENCES EPREUVE
(
idEpreuve
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE QUESTION_TIRAGE
ADD CONSTRAINT Tirage_Question_FK FOREIGN KEY
(
idQuestion
)
REFERENCES QUESTION
(
idQuestion
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE UTILISATEUR
ADD CONSTRAINT Utilisateur_Profil_FK FOREIGN KEY
(
codeProfil
)
REFERENCES PROFIL
(
codeProfil
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

-- Rapport r�capitulatif d'Oracle SQL Developer Data Modeler : 
-- 
-- CREATE TABLE                            11
-- CREATE INDEX                             0
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE DATABASE                          0
-- CREATE DEFAULT                           0
-- CREATE INDEX ON VIEW                     0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE ROLE                              0
-- CREATE RULE                              0
-- CREATE PARTITION FUNCTION                0
-- CREATE PARTITION SCHEME                  0
-- 
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0


-- Donn�es







insert into PROMOTION(codePromo, Libelle) values ('DL-127', 'Developpeur Logiciel 127');
insert into PROMOTION(codePromo, Libelle) values ('CDI-72', 'Concepteur D�veloppeur Informatique 72');
insert into PROMOTION(codePromo, Libelle) values ('DL-128', 'Developpeur Logiciel 128');
insert into PROMOTION(codePromo, Libelle) values ('CDI-73', 'Concepteur D�veloppeur Informatique 73');

insert into Profil (codeProfil, libelle) values ('STA', 'stagiaire');
insert into Profil (codeProfil, libelle) values ('FOR', 'formateur');
insert into Profil (codeProfil, libelle) values ('CAN', 'candidat');
insert into Profil (codeProfil, libelle) values ('RES', 'responsable de formation');


-- Stagiaires DL 127
insert into Utilisateur(nom, prenom, email, password, codeProfil, codePromo) values ('DUPONT', 'michel', 'michel@hotmail.fr', 'michel', 'STA', 'DL-127');
insert into Utilisateur(nom, prenom, email, password, codeProfil, codePromo) values ('DUPUIS', 'jean-michel', 'jean-michel@hotmail.fr', 'jean-michel', 'STA', 'DL-127');
insert into Utilisateur(nom, prenom, email, password, codeProfil, codePromo) values ('MARMUD', 'siraf', 'siraf@hotmail.fr', 'siraf', 'STA', 'DL-127');
insert into Utilisateur(nom, prenom, email, password, codeProfil, codePromo) values ('MARMAD', 'firas', 'firas@hotmail.fr', 'firas', 'STA', 'DL-127');
insert into Utilisateur(nom, prenom, email, password, codeProfil, codePromo) values ('MOUMOUNE', 'sarif', 'sarif@hotmail.fr', 'sarif', 'STA', 'DL-127');
insert into Utilisateur(nom, prenom, email, password, codeProfil, codePromo) values ('MARMOUN', 'frasi', 'frasi@hotmail.fr', 'frasi', 'STA', 'DL-127');

insert into Utilisateur(nom, prenom, email, password, codeProfil, codePromo) values ('FARRUGIA', 'fabrice', 'fabrice@hotmail.fr', 'fabrice', 'FOR', null);
insert into Utilisateur(nom, prenom, email, password, codeProfil, codePromo) values ('Rourour', 'robert', 'robert@hotmail.fr', 'robert', 'RES', null);

insert into Test(libelle, description, duree, seuil_haut, seuil_bas) values ('ECF Anglais', 'Un test qui sert � rien...', 30, 15, 8);
insert into Test(libelle, description, duree, seuil_haut, seuil_bas) values ('ECF Java', 'Java c est rigolo hi hi hi', 30, 15, 8);
insert into Test(libelle, description, duree, seuil_haut, seuil_bas) values ('ECF PHP', 'Du dev OOP avec Fabien ;) ;)', 30, 15, 8);

insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '26-03-2018 9:00:00', 103), CONVERT(datetime, '26-03-2018 12:00:00', 103), 'TE', 10.5, 'ECA', 1, 1);
insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '26-03-2018 9:00:00', 103), CONVERT(datetime, '26-03-2018 12:00:00', 103), 'TE', 16, 'ACQ', 1, 2);
insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '26-03-2018 9:00:00', 103), CONVERT(datetime, '26-03-2018 12:00:00', 103), 'TE', 7, 'NAC', 1, 3);
insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '26-03-2018 9:00:00', 103), CONVERT(datetime, '26-03-2018 12:00:00', 103), 'TE', 19, 'ACQ', 1, 4);
insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '26-03-2018 9:00:00', 103), CONVERT(datetime, '26-03-2018 12:00:00', 103), 'TE', 12, 'ECA', 1, 5);
insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '26-03-2018 9:00:00', 103), CONVERT(datetime, '26-03-2018 12:00:00', 103), 'TE', 9, 'NAC', 1, 6);

insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '28-03-2018 9:00:00', 103), CONVERT(datetime, '28-03-2018 12:00:00', 103), 'PL', 5, 'NAC', 2, 4);
insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '28-03-2018 9:00:00', 103), CONVERT(datetime, '28-03-2018 12:00:00', 103), 'TE', 6, 'NAC', 2, 5);
insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '28-03-2018 9:00:00', 103), CONVERT(datetime, '28-03-2018 12:00:00', 103), 'TE', 7, 'NAC', 2, 6);

insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '28-03-2018 9:00:00', 103), CONVERT(datetime, '28-03-2018 12:00:00', 103), 'EC', 15, 'ACQ', 3, 4);
insert into Epreuve(dateDebutValidite, dateFinValidite, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) values (CONVERT(datetime, '28-03-2018 9:00:00', 103), CONVERT(datetime, '28-03-2018 12:00:00', 103), 'TE', 16, 'ACQ', 3, 2);


-- QUESTIONS
insert into THEME(libelle) values('Java EE');
insert into THEME(libelle) values('Php');
insert into THEME(libelle) values('Vocabulaire');

/*
insert into QUESTION(enonce, media, points, idTheme) values ('Que veux dire "motherfucker" ?', null, 1, 1);
insert into PROPOSITION(enonce, estBonne, idQuestion) values ('Enculeur de maman', 0, 1);
insert into PROPOSITION(enonce, estBonne, idQuestion) values ('Enculer', 1, 1);
insert into PROPOSITION(enonce, estBonne, idQuestion) values ('cigarete', 0, 1);
*/




insert into Question (enonce, estMultichoix, media, points, idTheme) values ('A quoi sert une Servlet ?', 0, null, 1, 1);
insert into Question (enonce, estMultichoix, media, points, idTheme) values ('A quoi sert une JSP ?', 1, null, 1, 1);
insert into Question (enonce, estMultichoix, media, points, idTheme) values ('Lesquelles sont des balises HTML ?', 1, null, 1, 1);
insert into Question (enonce, estMultichoix, media, points, idTheme) values ('Que veut dire le EE de Java EE ?', 0, null, 1, 1);

insert into Question (enonce, estMultichoix, media, points, idTheme) values ('Quel est le framework le plus courant en php ?', 0, null, 1, 2);
insert into Question (enonce, estMultichoix, media, points, idTheme) values ('Par quoi commence forc�ment une variable Php', 0, null, 1, 2);
insert into Question (enonce, estMultichoix, media, points, idTheme) values ('Cochez les types primitif en php', 1, null, 1, 2);
insert into Question (enonce, estMultichoix, media, points, idTheme) values ('Que peut-on faire en php ?', 1, null, 1, 2);

insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Pour des traitements de requetes', 1, 1);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Pour manger des cacahu�tes', 0, 1);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Pour attraper un �l�phant', 0, 1);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Pour faire chier Max', 0, 1);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('A faire du Html dynamique', 1, 2);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('A ins�rer du code java dans une page Html', 1, 2);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('A faire la cuisine', 0, 2);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Pour �tre on fire sur le dancefloor', 0, 2);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('<h1>', 1, 3);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('<form>', 1, 3);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('<b26>', 0, 3);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('<input>', 1, 3);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Entreprise Edition', 1, 4);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Et� Hiver',0, 4);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Euh Excsuez-moi',0, 4);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Hey salut !',0, 4);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Symfony', 1, 5);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Mozart', 0, 5);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Beethoven', 0, 5);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('De Bussy', 0, 5);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('$', 1, 6);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('�', 0, 6);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('LOL', 0, 6);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('Choisis-moi', 0, 6);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('int', 1, 7);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('string', 1, 7);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('boolean', 1, 7);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('float', 1, 7);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('du web', 1, 8);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('du miel', 0, 8);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('du  d�veloppement web', 1, 8);
insert into PROPOSITION (enonce, estBonne, idQuestion) values ('des pages html dynamiques', 1, 8);




insert into SECTION_TEST (nbQuestionsATirer, idTest, idTheme) values (3,2,1);
insert into SECTION_TEST (nbQuestionsATirer, idTest, idTheme) values (3,3,2);


select* from SECTION_TEST 
where idTest=?;

select top 4 * from QUESTION q, THEME th, SECTION_TEST s, TEST te
where te.idTest=s.idTest
and s.idTheme=th.idTheme
and th.idTheme=q.idTheme
and s.idTheme = 1
order by RAND(1);


select * from PROPOSITION p
where idQuestion= ?;



select  top 3 * from  PROPOSITION p,  QUESTION q
INNER JOIN THEME th ON  th.idTheme = q.idTheme
INNER JOIN SECTION_TEST s on s.idTheme = q.idTheme
INNER JOIN TEST te on te.idTest = s.idTest
where q.idQuestion = p.idQuestion
order by p.idQuestion




/*

insert into Qcms (nom, niveau) values ('ECF-D�veloppement web', 'DL');
insert into Qcms (nom, niveau) values ('ECF-D�veloppement web avanc�', 'DL');
insert into Qcms (nom, niveau) values ('ECF-SQL', 'CDI');

insert into Sections (id_qcm, id_theme, nom,  nb_questions) values (1, 1,'Java EE', 4);
insert into Sections (id_qcm, id_theme, nom,  nb_questions) values (1, 2,'Php', 4);
insert into Sections (id_qcm, id_theme, nom,  nb_questions) values (2, 1,'Java EE', 2);
insert into Sections (id_qcm, id_theme, nom,  nb_questions) values (2, 2,'Php', 3);

insert into Sessions (date_inscription, date_prevue, temps_limite,id_user, id_qcm, resultat) values (CONVERT(datetime, '16-03-2018 15:00:00', 103), CONVERT(datetime, '26-03-2018 9:00:00', 103), 120, 1,1, 15);
insert into Sessions (date_inscription, date_prevue, temps_limite,id_user, id_qcm, resultat) values (CONVERT(datetime, '16-03-2018 15:00:00', 103), CONVERT(datetime, '26-03-2018 9:00:00', 103), 120, 2,2, 12);

insert into Epreuves (date_passage, temps_restant, id_session) values (CONVERT(datetime, '26-03-2018 9:00:00', 103), 60, 1);
insert into Epreuves (date_passage, temps_restant, id_session) values (CONVERT(datetime, '26-03-2018 9:00:00', 103), 20, 2);


*/