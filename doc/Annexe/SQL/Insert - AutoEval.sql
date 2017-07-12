/*============================================================================*/
/*                                                                            */
/*            Insertion des tables utiliser pour l'auto-evaluation            */
/*                                                                            */
/*============================================================================*/

/* Insertion des modules */
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M1','Dév app interactive autonome','Développer une application interactive autonome');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M2','Dév app interactive Web','Développer une application interactive Web');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M3','Dév DAO','Développer la persistance des données');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M4','Concevoir app n-tiers','Concevoir une application en couches');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M5','Dév app n-tiers','Développer une application en couches');
INSERT INTO MODULE (MOD_ID,MOD_NOM_COURT,MOD_NOM_LONG) VALUES ('M6','Dév app mobile','Développer une application de mobilité numérique');

COMMIT;

/* Insertion des sequences */
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','Développer une interface utilisateur','Développer une interface utilisateur','M1');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S2','Maquetter une application','Maquetter une application','M1');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S3','Développer des composants d''accès aux données','Développer des composants d''accès aux données','M1');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','Développer des pages web en lien avec une base de données','Développer des pages web en lien avec une base de données','M2');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','Concevoir une base de données','Concevoir une base de données','M3');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S2','Mettre en place une base de données','Mettre en place une base de données','M3');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S3','Développer des composants dans le langage d’une base de données','Développer des composants dans le langage d’une base de données','M3');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S4','Utiliser l’anglais dans son activité professionnelle en informatique','Utiliser l’anglais dans son activité professionnelle en informatique','M3');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','Collaborer à la gestion d’un projet informatique','Collaborer à la gestion d’un projet informatique','M4');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S2','Concevoir une application','Concevoir une application','M4');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','Développer des composants métier','Développer des composants métier','M5');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S2','Construire une application organisée en couches en mettant en œuvre des frameworks','Construire une application organisée en couches en mettant en œuvre des frameworks','M5');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S3','Construire une application organisée en couches en mettant en œuvre des services Web','Construire une application organisée en couches en mettant en œuvre des services Web','M5');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S4','Préparer et exécuter les plans de tests d’une application et préparer et exécuter le déploiement d’une application','Préparer et exécuter les plans de tests d’une application et préparer et exécuter le déploiement d’une application','M5');
INSERT INTO SEQ (SEQ_ID,SEQ_NOM_COURT,SEQ_NOM_LONG,MOD_ID) VALUES ('S1','Développer une application de mobilité numérique','Développer une application de mobilité numérique','M6');

COMMIT;

/* Insertion des competences */
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C1','S''approprier l''environnement de développement','S''approprier l''environnement de développement','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C2','Coder un algorithme','Coder un algorithme','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C3','Développer Objet - concepts de base','Développer Objet - concepts de base','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C4','Développer objet - concepts avancés','Développer objet - concepts avancés','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C5','Développer une interface graphique autonome - Partie 1','Développer une interface graphique autonome - Partie 1','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C6','Développer une interface graphique autonome - Partie 2','Développer une interface graphique autonome - Partie 2','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C7','Appliquer les normes et règles du développement','Appliquer les normes et règles du développement','S1','M1');
INSERT INTO COMP (COMP_ID,COMP_NOM_COURT,COMP_NOM_LONG,SEQ_ID,MOD_ID) VALUES ('C8','Utiliser les outils avancés de développement','Utiliser les outils avancés de développement','S1','M1');

COMMIT;

/* Insertion des stagiaires */
INSERT INTO STAG (STAG_OSIA,STAG_ADRESSE,STAG_HUMEUR,STAG_MAIL,STAG_MAIL_FORMA,STAG_MDP,STAG_NOM,STAG_NUM_TEL_ADMI,STAG_NUM_TEL_FORMA,STAG_PRENOM) VALUES ('13111384',null,null,null,null,'Password','Harlé',null,null,'Aurélien');

COMMIT;

/* Insertion des niveaux d'acquisition */

INSERT INTO NIV_ACQUI (NA_ID,NA_LBL) VALUES ('A','Acquis');
INSERT INTO NIV_ACQUI (NA_ID,NA_LBL) VALUES ('AC','A confirmer');
INSERT INTO NIV_ACQUI (NA_ID,NA_LBL) VALUES ('NA','Non acquis');

COMMIT;