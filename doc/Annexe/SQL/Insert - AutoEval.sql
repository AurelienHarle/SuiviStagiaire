/*============================================================================*/
/*                                                                            */
/*            Insertion des tables utiliser pour l'auto-evaluation            */
/*                                                                            */
/*============================================================================*/

/* Insertion des modules */
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M1','D�v app interactive autonome','D�velopper une application interactive autonome');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M2','D�v app interactive Web','D�velopper une application interactive Web');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M3','D�v DAO','D�velopper la persistance des donn�es');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M4','Concevoir app n-tiers','Concevoir une application en couches');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M5','D�v app n-tiers','D�velopper une application en couches');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M6','D�v app mobile','D�velopper une application de mobilit� num�rique');

COMMIT;

/* Insertion des sequences */
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','D�velopper une interface utilisateur','D�velopper une interface utilisateur','M1');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S2','Maquetter une application','Maquetter une application','M1');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S3','D�velopper des composants d''acc�s aux donn�es','D�velopper des composants d''acc�s aux donn�es','M1');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','D�velopper des pages web en lien avec une base de donn�es','D�velopper des pages web en lien avec une base de donn�es','M2');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','Concevoir une base de donn�es','Concevoir une base de donn�es','M3');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S2','Mettre en place une base de donn�es','Mettre en place une base de donn�es','M3');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S3','D�velopper des composants dans le langage d�une base de donn�es','D�velopper des composants dans le langage d�une base de donn�es','M3');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S4','Utiliser l�anglais dans son activit� professionnelle en informatique','Utiliser l�anglais dans son activit� professionnelle en informatique','M3');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','Collaborer � la gestion d�un projet informatique','Collaborer � la gestion d�un projet informatique','M4');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S2','Concevoir une application','Concevoir une application','M4');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','D�velopper des composants m�tier','D�velopper des composants m�tier','M5');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S2','Construire une application organis�e en couches en mettant en �uvre des frameworks','Construire une application organis�e en couches en mettant en �uvre des frameworks','M5');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S3','Construire une application organis�e en couches en mettant en �uvre des services Web','Construire une application organis�e en couches en mettant en �uvre des services Web','M5');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S4','Pr�parer et ex�cuter les plans de tests d�une application et pr�parer et ex�cuter le d�ploiement d�une application','Pr�parer et ex�cuter les plans de tests d�une application et pr�parer et ex�cuter le d�ploiement d�une application','M5');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','D�velopper une application de mobilit� num�rique','D�velopper une application de mobilit� num�rique','M6');

COMMIT;

/* Insertion des competences */
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C1','S''approprier l''environnement de d�veloppement','S''approprier l''environnement de d�veloppement','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C2','Coder un algorithme','Coder un algorithme','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C3','D�velopper Objet - concepts de base','D�velopper Objet - concepts de base','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C4','D�velopper objet - concepts avanc�s','D�velopper objet - concepts avanc�s','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C5','D�velopper une interface graphique autonome - Partie 1','D�velopper une interface graphique autonome - Partie 1','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C6','D�velopper une interface graphique autonome - Partie 2','D�velopper une interface graphique autonome - Partie 2','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C7','Appliquer les normes et r�gles du d�veloppement','Appliquer les normes et r�gles du d�veloppement','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C8','Utiliser les outils avanc�s de d�veloppement','Utiliser les outils avanc�s de d�veloppement','S1','M1');

COMMIT;

/* Insertion des stagiaires */
INSERT INTO STAG (STAG_OSIA,STAG_ADRESSE,STAG_HUMEUR,STAG_MAIL,STAG_MAIL_FORMA,STAG_MDP,STAG_NOM,STAG_NUM_TEL_ADMI,STAG_NUM_TEL_FORMA,STAG_PRENOM) VALUES ('13111384',null,null,null,null,'Password','Harl�',null,null,'Aur�lien');

COMMIT;

/* Insertion des niveaux d'acquisition */

INSERT INTO NIV_ACQUI (NA_ID,NA_LBL) VALUES ('A','Acquis');
INSERT INTO NIV_ACQUI (NA_ID,NA_LBL) VALUES ('AC','A confirmer');
INSERT INTO NIV_ACQUI (NA_ID,NA_LBL) VALUES ('NA','Non acquis');

COMMIT;