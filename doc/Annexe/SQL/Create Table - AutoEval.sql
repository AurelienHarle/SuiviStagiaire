/*============================================================================*/
/*                                                                            */
/*             Creation des tables utiliser pour l'auto-evaluation            */
/*                                                                            */
/*============================================================================*/

CREATE TABLE "AUTO_EVAL" (	
  "AE_ID" NUMBER(10,0), 
  "AE_DATE" DATE, 
  "AE_RESSENTI" VARCHAR2(4000 CHAR), 
  "COMP_ID" VARCHAR2(3 CHAR), 
  "SEQ_ID" VARCHAR2(3 CHAR), 
  "MOD_ID" VARCHAR2(3 CHAR), 
  "NA_ID" VARCHAR2(3 CHAR), 
  "STAG_OSIA" VARCHAR2(8 CHAR)
);

COMMIT;

--------------------------------------------------------
--  DDL for Table COMP
--------------------------------------------------------

CREATE TABLE "COMP" (	
  "COMP_ID" VARCHAR2(3 CHAR), 
  "COMP_NOM_COURT" VARCHAR2(200 CHAR), 
  "COMP_NOM_LONG" VARCHAR2(200 CHAR), 
  "MOD_ID" VARCHAR2(3 CHAR), 
  "SEQ_ID" VARCHAR2(3 CHAR)
);

COMMIT;

--------------------------------------------------------
--  DDL for Table MODULE
--------------------------------------------------------

CREATE TABLE "MODULE" (	
  "MOD_ID" VARCHAR2(3 CHAR), 
	"MOD_NOM_COURT" VARCHAR2(200 CHAR), 
	"MOD_NOM_LONG" VARCHAR2(200 CHAR)
);

COMMIT;

--------------------------------------------------------
--  DDL for Table NIV_ACQUI
--------------------------------------------------------

CREATE TABLE "NIV_ACQUI" (	
  "NA_ID" VARCHAR2(2 CHAR), 
	"NA_LBL" VARCHAR2(20 CHAR)
);

COMMIT;

--------------------------------------------------------
--  DDL for Table SEQ
--------------------------------------------------------

CREATE TABLE "SEQ" (	
  "SEQ_ID" VARCHAR2(3 CHAR), 
	"SEQ_NOM_COURT" VARCHAR2(200 CHAR), 
	"SEQ_NOM_LONG" VARCHAR2(200 CHAR), 
	"MOD_ID" VARCHAR2(3 CHAR)
);

COMMIT;

--------------------------------------------------------
--  DDL for Table STAG
--------------------------------------------------------

CREATE TABLE "STAG" (	
  "STAG_OSIA" VARCHAR2(8 CHAR), 
	"STAG_ADRESSE" VARCHAR2(200 CHAR), 
	"STAG_HUMEUR" VARCHAR2(20 CHAR), 
	"STAG_MAIL" VARCHAR2(50 CHAR), 
	"STAG_MAIL_FORMA" VARCHAR2(50 CHAR), 
	"STAG_MDP" VARCHAR2(30 CHAR), 
	"STAG_NOM" VARCHAR2(60 CHAR), 
	"STAG_NUM_TEL_ADMI" VARCHAR2(10 CHAR), 
	"STAG_NUM_TEL_FORMA" VARCHAR2(10 CHAR), 
	"STAG_PRENOM" VARCHAR2(60 CHAR)
);

COMMIT;

--------------------------------------------------------
--  DDL for Index INDEX_AUTO_EVAL
--------------------------------------------------------

  CREATE UNIQUE INDEX "INDEX_AUTO_EVAL" ON "AUTO_EVAL" ("AE_ID");
  COMMIT;
  
--------------------------------------------------------
--  DDL for Index INDEX_COMP
--------------------------------------------------------

  CREATE UNIQUE INDEX "INDEX_COMP" ON "COMP" ("MOD_ID", "SEQ_ID", "COMP_ID");
  COMMIT;
  
--------------------------------------------------------
--  DDL for Index INDEX_MODULE
--------------------------------------------------------

  CREATE UNIQUE INDEX "INDEX_MODULE" ON "MODULE" ("MOD_ID");
  COMMIT;
  
--------------------------------------------------------
--  DDL for Index INDEX_NIV_ACQUI
--------------------------------------------------------

  CREATE UNIQUE INDEX "INDEX_NIV_ACQUI" ON "NIV_ACQUI" ("NA_ID");
  COMMIT;
  
--------------------------------------------------------
--  DDL for Index INDEX_SEQ
--------------------------------------------------------

  CREATE UNIQUE INDEX "INDEX_SEQ" ON "SEQ" ("MOD_ID", "SEQ_ID");
  COMMIT;
  
--------------------------------------------------------
--  DDL for Index INDEX_STAG
--------------------------------------------------------

  CREATE UNIQUE INDEX "INDEX_STAG" ON "STAG" ("STAG_OSIA");
  COMMIT;
  
--------------------------------------------------------
--  Constraints for Table AUTO_EVAL
--------------------------------------------------------

  ALTER TABLE "AUTO_EVAL" ADD PRIMARY KEY ("AE_ID");
  ALTER TABLE "AUTO_EVAL" MODIFY ("STAG_OSIA" NOT NULL ENABLE);
  ALTER TABLE "AUTO_EVAL" MODIFY ("NA_ID" NOT NULL ENABLE);
  ALTER TABLE "AUTO_EVAL" MODIFY ("MOD_ID" NOT NULL ENABLE);
  ALTER TABLE "AUTO_EVAL" MODIFY ("SEQ_ID" NOT NULL ENABLE);
  ALTER TABLE "AUTO_EVAL" MODIFY ("COMP_ID" NOT NULL ENABLE);
  ALTER TABLE "AUTO_EVAL" MODIFY ("AE_DATE" NOT NULL ENABLE);
  ALTER TABLE "AUTO_EVAL" MODIFY ("AE_ID" NOT NULL ENABLE);
  COMMIT;
  
--------------------------------------------------------
--  Constraints for Table COMP
--------------------------------------------------------

  ALTER TABLE "COMP" ADD PRIMARY KEY ("SEQ_ID", "MOD_ID", "COMP_ID");
  ALTER TABLE "COMP" MODIFY ("MOD_ID" NOT NULL ENABLE);
  ALTER TABLE "COMP" MODIFY ("SEQ_ID" NOT NULL ENABLE);
  ALTER TABLE "COMP" MODIFY ("COMP_NOM_LONG" NOT NULL ENABLE);
  ALTER TABLE "COMP" MODIFY ("COMP_NOM_COURT" NOT NULL ENABLE);
  ALTER TABLE "COMP" MODIFY ("COMP_ID" NOT NULL ENABLE);
  COMMIT;
  
--------------------------------------------------------
--  Constraints for Table MODULE
--------------------------------------------------------

  ALTER TABLE "MODULE" ADD PRIMARY KEY ("MOD_ID");
  ALTER TABLE "MODULE" MODIFY ("MOD_NOM_LONG" NOT NULL ENABLE);
  ALTER TABLE "MODULE" MODIFY ("MOD_NOM_COURT" NOT NULL ENABLE);
  ALTER TABLE "MODULE" MODIFY ("MOD_ID" NOT NULL ENABLE);
  COMMIT;
  
--------------------------------------------------------
--  Constraints for Table NIV_ACQUI
--------------------------------------------------------

  ALTER TABLE "NIV_ACQUI" ADD PRIMARY KEY ("NA_ID");
  ALTER TABLE "NIV_ACQUI" MODIFY ("NA_LBL" NOT NULL ENABLE);
  ALTER TABLE "NIV_ACQUI" MODIFY ("NA_ID" NOT NULL ENABLE);
  COMMIT;
  
--------------------------------------------------------
--  Constraints for Table SEQ
--------------------------------------------------------

  ALTER TABLE "SEQ" ADD PRIMARY KEY ("MOD_ID", "SEQ_ID");
  ALTER TABLE "SEQ" MODIFY ("MOD_ID" NOT NULL ENABLE);
  ALTER TABLE "SEQ" MODIFY ("SEQ_NOM_LONG" NOT NULL ENABLE);
  ALTER TABLE "SEQ" MODIFY ("SEQ_NOM_COURT" NOT NULL ENABLE);
  ALTER TABLE "SEQ" MODIFY ("SEQ_ID" NOT NULL ENABLE);
  COMMIT;
  
--------------------------------------------------------
--  Constraints for Table STAG
--------------------------------------------------------

  ALTER TABLE "STAG" ADD PRIMARY KEY ("STAG_OSIA");
  ALTER TABLE "STAG" MODIFY ("STAG_PRENOM" NOT NULL ENABLE);
  ALTER TABLE "STAG" MODIFY ("STAG_NOM" NOT NULL ENABLE);
  ALTER TABLE "STAG" MODIFY ("STAG_MDP" NOT NULL ENABLE);
  ALTER TABLE "STAG" MODIFY ("STAG_OSIA" NOT NULL ENABLE);
  COMMIT;
  
--------------------------------------------------------
--  Ref Constraints for Table AUTO_EVAL
--------------------------------------------------------

  ALTER TABLE "AUTO_EVAL" ADD CONSTRAINT "FK_COMP_ID_SEQ_ID_MOD_ID" FOREIGN KEY ("COMP_ID", "SEQ_ID", "MOD_ID")
	  REFERENCES "COMP" ("SEQ_ID", "MOD_ID", "COMP_ID") ENABLE;
  COMMIT;
  
  ALTER TABLE "AUTO_EVAL" ADD CONSTRAINT "FK_NA_ID" FOREIGN KEY ("NA_ID")
	  REFERENCES "NIV_ACQUI" ("NA_ID") ENABLE;
  COMMIT;
  
  ALTER TABLE "AUTO_EVAL" ADD CONSTRAINT "FK_STAG_OSIA" FOREIGN KEY ("STAG_OSIA")
	  REFERENCES "STAG" ("STAG_OSIA") ENABLE;
  COMMIT;
    
--------------------------------------------------------
--  Ref Constraints for Table COMP
--------------------------------------------------------
    
     ALTER TABLE "COMP" ADD CONSTRAINT "FK_SEQ_ID_MOD_ID" FOREIGN KEY ("MOD_ID", "SEQ_ID")
	  REFERENCES "SEQ" ("MOD_ID", "SEQ_ID") ENABLE;
    
  COMMIT;
--------------------------------------------------------
--  Ref Constraints for Table SEQ
--------------------------------------------------------

  ALTER TABLE "SEQ" ADD CONSTRAINT "FK_MOD_ID" FOREIGN KEY ("MOD_ID")
	  REFERENCES "MODULE" ("MOD_ID") ENABLE;
  COMMIT;
