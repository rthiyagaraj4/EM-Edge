
/* Result Sets Interface */
#ifndef SQL_CRSR
#  define SQL_CRSR
  struct sql_cursor
  {
    unsigned int curocn;
    void *ptr1;
    void *ptr2;
    unsigned long magic;
  };
  typedef struct sql_cursor sql_cursor;
  typedef struct sql_cursor SQL_CURSOR;
#endif /* SQL_CRSR */

/* Thread Safety */
typedef void * sql_context;
typedef void * SQL_CONTEXT;

/* Object support */
struct sqltvn
{
  unsigned char *tvnvsn; 
  unsigned short tvnvsnl; 
  unsigned char *tvnnm;
  unsigned short tvnnml; 
  unsigned char *tvnsnm;
  unsigned short tvnsnml;
};
typedef struct sqltvn sqltvn;

struct sqladts
{
  unsigned int adtvsn; 
  unsigned short adtmode; 
  unsigned short adtnum;  
  sqltvn adttvn[1];       
};
typedef struct sqladts sqladts;

static struct sqladts sqladt = {
  1,1,0,
};

/* Binding to PL/SQL Records */
struct sqltdss
{
  unsigned int tdsvsn; 
  unsigned short tdsnum; 
  unsigned char *tdsval[1]; 
};
typedef struct sqltdss sqltdss;
static struct sqltdss sqltds =
{
  1,
  0,
};

/* File name & Package Name */
struct sqlcxp
{
  unsigned short fillen;
           char  filnam[40];
};
static const struct sqlcxp sqlfpn =
{
    39,
    "D:\\Reference\\proc\\ARBBLINV1\\ARBBLINV.PC"
};


static unsigned long sqlctx = 109240395;


static struct sqlexd {
   unsigned int   sqlvsn;
   unsigned int   arrsiz;
   unsigned int   iters;
   unsigned int   offset;
   unsigned short selerr;
   unsigned short sqlety;
   unsigned int   occurs;
      const short *cud;
   unsigned char  *sqlest;
      const char  *stmt;
   sqladts *sqladtp;
   sqltdss *sqltdsp;
            void  **sqphsv;
   unsigned int   *sqphsl;
            int   *sqphss;
            void  **sqpind;
            int   *sqpins;
   unsigned int   *sqparm;
   unsigned int   **sqparc;
   unsigned short  *sqpadto;
   unsigned short  *sqptdso;
            void  *sqhstv[67];
   unsigned int   sqhstl[67];
            int   sqhsts[67];
            void  *sqindv[67];
            int   sqinds[67];
   unsigned int   sqharm[67];
   unsigned int   *sqharc[67];
   unsigned short  sqadto[67];
   unsigned short  sqtdso[67];
} sqlstm = {10,67};

/* SQLLIB Prototypes */
extern void sqlcxt (void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlcx2t(void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlbuft(void **, char *);
extern void sqlgs2t(void **, char *);
extern void sqlorat(void **, unsigned long *, void *);

/* Forms Interface */
static const int IAPSUCC = 0;
static const int IAPFAIL = 1403;
static const int IAPFTL  = 535;
extern void sqliem(char *, int *);

 static const char *sq0019 = 
"select NVL(STATUS,'X') ,'Y' ,NVL(DOC_NUM_GEN_FLAG,'N')  from SY_ACC_ENTITY_D\
OC_TYPE where (DOC_TYPE_CODE=:b0 and ACC_ENTITY_CODE in (select ACC_ENTITY_COD\
E  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0020 = 
"select 'X'  from AR_TRN_DOC_TYPE where ((DOC_TYPE_CODE=:b0 and TRN_TYPE_CODE\
='3') and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where\
 ACC_ENTITY_ID=:b1))           ";

 static const char *sq0010 = 
"select DOC_TYPE_CODE ,DOC_NUM ,OPERATING_FACILITY_ID  from BL_BILL_HDR where\
 (((((((TRUNC(DOC_DATE) between NVL(TO_DATE(:b0,'DD/MM/YYYY'),to_date('01/01/1\
900','DD/MM/YYYY')) and NVL(TO_DATE(:b1,'DD/MM/YYYY'),to_date('01/01/3000','DD\
/MM/YYYY')) and (((((DOC_TYPE_CODE||LPAD(DOC_NUM,8,0)) between (NVL(:b2,DOC_TY\
PE_CODE)||LPAD(NVL(:b3,DOC_NUM),8,'0')) and (NVL(:b4,DOC_TYPE_CODE)||LPAD(NVL(\
:b5,DOC_NUM),8,'0')) and CUST_CODE between NVL(:b6,'!!!!!!!!') and NVL(:b7,'~~\
~~~~~~')) and (:b8='A' or OPERATING_FACILITY_ID=:b8)) and :b10='ARBBLINV') or \
((DOC_TYPE_CODE,DOC_NUM) in (select DOC_TYPE_CODE ,DOC_NUM  from AR_INV_PROCES\
S_TEMP where ((PROCESS_PGM_ID='ARTGNINV' and PROCESS_SESSION_ID=:b11) and PROC\
ESS_DATE_TIME=:b12)) and :b10='ARTGNINV'))) and BILL_NATURE_CODE='A') and CUST\
_CODE is  not null ) and NVL(BILL_TOT_OUTST_AMT,0)<>0) and BILL_STATUS is null\
 ) and ((:b14='Y' and BILL_POSTED_FLAG='Y') or :b14='N')) and (:b8='A' or OPER\
ATING_FACILITY_ID=:b8))           ";

 static const char *sq0011 = 
"_FLAG ,DRFEE_RECEIPT_AMT ,AR_INV_DOC_TYPE_CODE ,AR_INV_DOC_NUMBER ,TO_CHAR(A\
R_INV_DOC_DATE,'DD/MM/YYYY') ,LAST_RECPT_DOC_TYPE_CODE ,LAST_RECPT_DOC_NUM ,TO\
_CHAR(LAST_RECPT_DOC_DATE,'DD/MM/YYYY') ,BILL_NATURE_CODE ,TOT_PAID_AMT ,BILL_\
POSTED_FLAG ,ADDED_BY_ID ,MODIFIED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/MM/YYYY') ,TO\
_CHAR(MODIFIED_DATE,'DD/MM/YYYY') ,ROWID  from BL_BILL_HDR where ((DOC_TYPE_CO\
DE=:b0 and DOC_NUM=:b1) and OPERATING_FACILITY_ID=:b2) for update of DOC_TYPE_\
CODE nowait ";

 static const char *sq0012 = 
"select A.BL_RECV_ACC_INT_CODE ,A.AR_RECV_ACC_INT_CODE ,B.SHORT_DESC  from BL\
_BILL_TYPE_INT A ,BL_BILL_TYPE B where (((A.BILL_TYPE_CODE=:b0 and A.ACC_ENTIT\
Y_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1)\
) and TO_DATE(:b2,'DD/MM/YYYY') between nvl(A.EFF_FROM_DATE,sysdate) and nvl(A\
.EFF_TO_DATE,sysdate)) and A.BILL_TYPE_CODE=B.BILL_TYPE_CODE)           ";

 static const char *sq0013 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,SUBLEDGER_GROUP_CODE ,SUBL\
EDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE  from BL_GL_ACCOUNT whe\
re (ACC_INT_CODE=:b0 and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_A\
CC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0014 = 
"select PMNT_TERMS_CODE ,NVL(CREDIT_LIMIT_AMT,0)  from AR_CUSTOMER where CUST\
_CODE=:b0           ";

 static const char *sq0015 = 
"select CREDIT_DAYS_PERIOD ,SETTLEMENT_DAYS_PERIOD ,SETTLEMENT_PERC  from AR_\
PMNT_TERMS where (PMNT_TERMS_CODE=:b0 and ACC_ENTITY_CODE in (select ACC_ENTIT\
Y_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0016 = 
"select NVL(SUBSTR(CREDIT_DOC_REF_DESC,1,15),SUBSTR(POLICY_NUMBER,1,15)) ,SUB\
STR(POLICY_NUMBER,1,25)  from BL_EPISODE_FIN_DTLS where ((EPISODE_TYPE=:b0 and\
 EPISODE_ID=:b1) and OPERATING_FACILITY_ID=:b2)           ";

 static const char *sq0017 = 
"select NVL(SUBSTR(CREDIT_DOC_REF_DESC,1,15),SUBSTR(POLICY_NUMBER,1,15)) ,SUB\
STR(POLICY_NUMBER,1,15)  from BL_VISIT_FIN_DTLS where (((EPISODE_TYPE=:b0 and \
EPISODE_ID=:b1) and VISIT_ID=:b2) and OPERATING_FACILITY_ID=:b3)           ";

 static const char *sq0018 = 
"select NVL(SUBSTR(CREDIT_DOC_REF_DESC,1,15),SUBSTR(POLICY_NUMBER,1,15))  fro\
m BL_PATIENT_FIN_DTLS where PATIENT_ID=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,94,0,4,263,0,0,1,0,0,1,0,2,9,0,0,
24,0,0,2,31,0,4,270,0,0,1,0,0,1,0,2,9,0,0,
43,0,0,3,31,0,4,272,0,0,1,0,0,1,0,2,9,0,0,
62,0,0,4,31,0,4,275,0,0,1,0,0,1,0,2,9,0,0,
81,0,0,5,75,0,4,291,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
104,0,0,6,0,0,29,327,0,0,0,0,0,1,0,
119,0,0,7,0,0,30,335,0,0,0,0,0,1,0,
134,0,0,8,394,0,4,390,0,0,24,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
245,0,0,9,116,0,2,444,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
276,0,0,19,212,0,9,677,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
299,0,0,19,0,0,13,690,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
326,0,0,20,185,0,9,712,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
349,0,0,20,0,0,13,719,0,0,1,0,0,1,0,2,9,0,0,
368,0,0,10,968,0,9,732,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
455,0,0,10,0,0,13,748,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
482,0,0,11,1502,0,9,900,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
509,0,0,11,0,0,13,914,0,0,67,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,
792,0,0,21,243,0,4,1066,0,0,5,2,0,1,0,2,3,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
827,0,0,22,85,0,5,1084,0,0,1,1,0,1,0,1,9,0,0,
846,0,0,12,382,0,9,1095,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
873,0,0,12,0,0,13,1113,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
900,0,0,13,278,0,9,1134,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
923,0,0,13,0,0,13,1155,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
966,0,0,13,278,0,9,1183,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
989,0,0,13,0,0,13,1204,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
1032,0,0,14,96,0,9,1227,0,0,1,1,0,1,0,1,9,0,0,
1051,0,0,14,0,0,13,1237,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
1074,0,0,15,217,0,9,1253,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1097,0,0,15,0,0,13,1266,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1124,0,0,16,212,0,9,1287,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1151,0,0,16,0,0,13,1299,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1174,0,0,17,229,0,9,1317,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1205,0,0,17,0,0,13,1328,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1228,0,0,18,129,0,9,1346,0,0,1,1,0,1,0,1,9,0,0,
1247,0,0,18,0,0,13,1354,0,0,1,0,0,1,0,2,9,0,0,
1266,0,0,23,94,0,4,1375,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
1293,0,0,24,1300,0,3,1415,0,0,53,53,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1520,0,0,25,454,0,3,1539,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1611,0,0,26,74,0,4,1592,0,0,2,1,0,1,0,2,4,0,0,1,9,0,0,
1634,0,0,27,270,0,3,1619,0,0,9,9,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,4,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1685,0,0,28,753,0,3,1658,0,0,34,34,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,3,0,0,1,9,0,
0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1836,0,0,29,475,0,3,1744,0,0,20,20,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,3,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1931,0,0,30,355,0,5,1807,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1990,0,0,31,237,0,5,1828,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
2029,0,0,32,254,0,5,1849,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
2072,0,0,33,456,0,5,1880,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2131,0,0,34,0,0,27,1905,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : ARBBLINV.PC                                  */
/* AUTHOR                : MUTHU K.S                                    */
/* DATE WRITTEN          : 06-OCT-2003                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */ 
/*                                                                      */ 
/*  TABLE DETAILS                                                        */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*          1.         BL_BILL_HDR            Read/Update               */
/*          2.         BL_BILL_LINE           Read/Update               */
/*          3.         AR_INV_HDR               Insert                  */
/*          4.         AR_INV_LINE              Insert                  */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/************************************************************************/
                    
#include <stdio.h>  
#include <string.h>
#include <gl.h>
#include <bl.h>   

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define TOO_MANY_ROWS		 (sqlca.sqlerrd[2])
#define VIEW_LOG_FILE 1
     
/* EXEC SQL BEGIN DECLARE SECTION; */ 

    /* VARCHAR uid_pwd         [132],
	    hosp_name                                  [120],
	    date_time                                  [20],
	    user_id                                    [40],
	    nd_session_id                              [16],
	    nd_pgm_date                                [25],
	    d_curr_pgm_name                            [15],
		nd_fm_cust_code				     [9], //ADDED BY RAJESH
		nd_to_cust_code				     [9],
		nd_bill_no					     [21],
	    nd_fm_doc_date                             [12],
	    nd_to_doc_date                             [12],
	    nd_fm_doc_type_code                        [7],
	    nd_to_doc_type_code                        [7],
	    nd_fm_doc_num                              [9],
	    nd_to_doc_num                              [9],
	    nd_inv_doc_type_code                       [7],
	    nd_inv_date                                [13],
	    nd_doc_num_gen_flag                        [2],           
	    nd_p_month                                 [3],
        nd_p_year                                  [5],
	    nd_dr_cnt_acc                              [2],
	    d_acc_status                               [2],
	    d_acc_valid_flag                           [2],	    
	    nd_operating_facility_id 		       [3],
		nd_input_facility_id 		       [3],
		nd_ws_no				       [31],
	    nd_module_id			       [3],
	    nd_inv_status			       [2],
	    nd_acc_entity_code			       [5],
	    l_dummy                                    [10][2],
		v_installed_yn					[2],
	    d_sy_acc_rowid                             [31],
		p_language_id      [3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[21]; } nd_bill_no;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[7]; } nd_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[13]; } nd_inv_date;

struct { unsigned short len; unsigned char arr[2]; } nd_doc_num_gen_flag;

struct { unsigned short len; unsigned char arr[3]; } nd_p_month;

struct { unsigned short len; unsigned char arr[5]; } nd_p_year;

struct { unsigned short len; unsigned char arr[2]; } nd_dr_cnt_acc;

struct { unsigned short len; unsigned char arr[2]; } d_acc_status;

struct { unsigned short len; unsigned char arr[2]; } d_acc_valid_flag;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_input_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[3]; } nd_module_id;

struct { unsigned short len; unsigned char arr[2]; } nd_inv_status;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[2]; } l_dummy[10];

struct { unsigned short len; unsigned char arr[2]; } v_installed_yn;

struct { unsigned short len; unsigned char arr[31]; } d_sy_acc_rowid;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

        
	  char credit_warn[1000];
	       

      int  nd_inv_start_doc_num;
    double		bl_outst_amt,bl_cust_credit_limit,nd_ar_outstand_amt;
    double		bl_drfee_outst_amt;
   /* varchar  nd_new_doc_num                             [9]; */ 
struct { unsigned short len; unsigned char arr[9]; } nd_new_doc_num;

   /* varchar  work_doc_num                               [9]; */ 
struct { unsigned short len; unsigned char arr[9]; } work_doc_num;


   /* VARCHAR  nd_narration							   [51]; */ 
struct { unsigned short len; unsigned char arr[51]; } nd_narration;

   /* VARCHAR bl_h_doc_type_code                          [7],
	   bl_h_doc_num                                [9],
	   bl_h_doc_date                               [13],
	   bl_h_bill_trx_type_code                     [2],
	   bl_h_serv_locn_code                         [5],
	   bl_h_bill_from_date                         [13],
	   bl_h_bill_to_date                           [13],
	   bl_h_gross_amt                              [23],
	   bl_h_serv_disc_amt                          [23],
	   bl_h_man_disc_amt                           [23],
	   bl_h_overall_disc_perc                      [6],
	   bl_h_overall_disc_amt                       [23],
	   bl_h_ovr_disc_acc_int_code                  [7],
	   bl_h_prepay_adj_amt                         [23],
	   bl_h_deposit_adj_amt                        [23],
	   bl_h_bill_amt                               [23],
	   bl_h_bill_hosp_amt                          [23],
	   bl_h_bill_drfee_amt                         [23],
	   bl_h_bill_prv_doc_type_code                 [7],
	   bl_h_bill_prv_doc_number                    [23],
	   bl_h_bill_prv_doc_date                      [13],
	   bl_h_bill_prv_bill_amt                      [23],
	   bl_h_bill_prv_bill_paid_amt                 [23],
	   bl_h_bill_prv_outst_amt                     [23],
	   bl_h_bill_hosp_prv_outst_amt                [23],
       bl_h_bill_drfee_prv_out_amt               [23],
	   bl_h_bill_tot_amt                           [23],
	   bl_h_bill_hosp_tot_amt                      [23],
	   bl_h_bill_drfee_tot_amt                     [23],
	   bl_h_bill_tot_outst_amt                     [23],
	   bl_h_bill_hosp_tot_outst_amt                [23],	   
       bl_h_bill_drfee_tot_out_amt               [23],
	   bl_h_bill_paid_amt                          [23],
	   bl_h_episode_type                           [2],
	   bl_h_patient_id                             [21],
	   bl_h_episode_id                             [9],
	   bl_h_visit_id                               [5],
	   bl_h_admission_date                         [13],
	   bl_h_ward_code                              [5],
	   bl_h_bed_class_code                         [3],
	   bl_h_room_num                               [5],
	   bl_h_bed_num                                [9],
	   bl_h_physician_id                           [16],
	   bl_h_clinic_code                            [5],
	   bl_h_cust_code                              [9],
	   bl_h_blng_grp_id                            [5],  -- CRF-0120 
	   bl_h_bill_type_code                         [3],
	   bl_h_cons_invoice_ind                       [2],
	   bl_h_bill_status                            [2],
	   bl_h_bill_print_flag                        [2],
	   bl_h_drfee_bill_upd_flag                    [2],
	   bl_h_drfee_rec_upd_flag                     [2],
	   bl_h_drfee_receipt_amt                      [23],
	   bl_h_ar_inv_doc_type_code                   [7],
	   bl_h_ar_inv_doc_number                      [9],
	   bl_h_ar_inv_doc_date                        [13],
           bl_h_last_recpt_doc_type_cd               [7],
	   bl_h_last_recpt_doc_num                     [23],
	   bl_h_last_recpt_doc_date                    [13],
	   bl_h_bill_nature_code                       [2],
	   bl_h_tot_paid_amt                           [23],
	   bl_h_bill_posted_flag                       [2],
	   bl_h_added_by_id                            [21],
	   bl_h_modified_by_id                         [21],
	   bl_h_added_date                             [13],
	   bl_h_modified_date                          [13],
	   bl_h_rowid                                  [31],
       bl_facility_id                              [3], 
	   nd_new_doc_type_code                        [7],

	   bl_par_post_month                           [3],
	   bl_par_post_year                            [5],

	   recv_int_code                               [7],
	   bl_recv_acc_int_code                        [7],
	   ar_recv_acc_int_code                        [7],
	   bl_bill_type_short_desc                      [31],

	   bl_rec_main_acc1_code                       [7],
	   bl_rec_main_acc2_code                       [5],
	   bl_rec_dept_code                            [11],
	   bl_rec_subledger_group_code                 [4],
	   bl_rec_subledger_line_code                  [9],
	   bl_rec_product_group_code                   [4],
	   bl_rec_product_line_code                    [5],

	   ar_rec_main_acc1_code                       [7],
	   ar_rec_main_acc2_code                       [5],
	   ar_rec_dept_code                            [11],
	   ar_rec_subledger_group_code                 [4],
	   ar_rec_subledger_line_code                  [9],
	   ar_rec_product_group_code                   [4],
	   ar_rec_product_line_code                    [5],

	   bl_cust_pmnt_terms_code                     [3],
	   ar_pmnt_cred_days_period                    [4],
	   ar_pmnt_settl_days_period                   [4],
	   ar_pmnt_settl_percent                       [9],
	   bl_h_policy_code							   [26],	
	   bl_h_credit_doc_ref_desc                    [16]; */ 
struct { unsigned short len; unsigned char arr[7]; } bl_h_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_h_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_h_doc_date;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_trx_type_code;

struct { unsigned short len; unsigned char arr[5]; } bl_h_serv_locn_code;

struct { unsigned short len; unsigned char arr[13]; } bl_h_bill_from_date;

struct { unsigned short len; unsigned char arr[13]; } bl_h_bill_to_date;

struct { unsigned short len; unsigned char arr[23]; } bl_h_gross_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_serv_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_man_disc_amt;

struct { unsigned short len; unsigned char arr[6]; } bl_h_overall_disc_perc;

struct { unsigned short len; unsigned char arr[23]; } bl_h_overall_disc_amt;

struct { unsigned short len; unsigned char arr[7]; } bl_h_ovr_disc_acc_int_code;

struct { unsigned short len; unsigned char arr[23]; } bl_h_prepay_adj_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_deposit_adj_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_amt;

struct { unsigned short len; unsigned char arr[7]; } bl_h_bill_prv_doc_type_code;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_prv_doc_number;

struct { unsigned short len; unsigned char arr[13]; } bl_h_bill_prv_doc_date;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_prv_bill_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_prv_bill_paid_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_prv_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_prv_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_prv_out_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_tot_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_tot_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_tot_out_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_paid_amt;

struct { unsigned short len; unsigned char arr[2]; } bl_h_episode_type;

struct { unsigned short len; unsigned char arr[21]; } bl_h_patient_id;

struct { unsigned short len; unsigned char arr[9]; } bl_h_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_h_visit_id;

struct { unsigned short len; unsigned char arr[13]; } bl_h_admission_date;

struct { unsigned short len; unsigned char arr[5]; } bl_h_ward_code;

struct { unsigned short len; unsigned char arr[3]; } bl_h_bed_class_code;

struct { unsigned short len; unsigned char arr[5]; } bl_h_room_num;

struct { unsigned short len; unsigned char arr[9]; } bl_h_bed_num;

struct { unsigned short len; unsigned char arr[16]; } bl_h_physician_id;

struct { unsigned short len; unsigned char arr[5]; } bl_h_clinic_code;

struct { unsigned short len; unsigned char arr[9]; } bl_h_cust_code;

struct { unsigned short len; unsigned char arr[5]; } bl_h_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } bl_h_bill_type_code;

struct { unsigned short len; unsigned char arr[2]; } bl_h_cons_invoice_ind;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_status;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_print_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_h_drfee_bill_upd_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_h_drfee_rec_upd_flag;

struct { unsigned short len; unsigned char arr[23]; } bl_h_drfee_receipt_amt;

struct { unsigned short len; unsigned char arr[7]; } bl_h_ar_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_h_ar_inv_doc_number;

struct { unsigned short len; unsigned char arr[13]; } bl_h_ar_inv_doc_date;

struct { unsigned short len; unsigned char arr[7]; } bl_h_last_recpt_doc_type_cd;

struct { unsigned short len; unsigned char arr[23]; } bl_h_last_recpt_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_h_last_recpt_doc_date;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_nature_code;

struct { unsigned short len; unsigned char arr[23]; } bl_h_tot_paid_amt;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_posted_flag;

struct { unsigned short len; unsigned char arr[21]; } bl_h_added_by_id;

struct { unsigned short len; unsigned char arr[21]; } bl_h_modified_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_h_added_date;

struct { unsigned short len; unsigned char arr[13]; } bl_h_modified_date;

struct { unsigned short len; unsigned char arr[31]; } bl_h_rowid;

struct { unsigned short len; unsigned char arr[3]; } bl_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_new_doc_type_code;

struct { unsigned short len; unsigned char arr[3]; } bl_par_post_month;

struct { unsigned short len; unsigned char arr[5]; } bl_par_post_year;

struct { unsigned short len; unsigned char arr[7]; } recv_int_code;

struct { unsigned short len; unsigned char arr[7]; } bl_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[7]; } ar_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[31]; } bl_bill_type_short_desc;

struct { unsigned short len; unsigned char arr[7]; } bl_rec_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_rec_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } bl_rec_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_rec_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_rec_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_rec_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_rec_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } ar_rec_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } ar_rec_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } ar_rec_dept_code;

struct { unsigned short len; unsigned char arr[4]; } ar_rec_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } ar_rec_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } ar_rec_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } ar_rec_product_line_code;

struct { unsigned short len; unsigned char arr[3]; } bl_cust_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[4]; } ar_pmnt_cred_days_period;

struct { unsigned short len; unsigned char arr[4]; } ar_pmnt_settl_days_period;

struct { unsigned short len; unsigned char arr[9]; } ar_pmnt_settl_percent;

struct { unsigned short len; unsigned char arr[26]; } bl_h_policy_code;

struct { unsigned short len; unsigned char arr[16]; } bl_h_credit_doc_ref_desc;


char string_var[100];

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header: sqlca.h,v 1.3 1994/12/12 19:27:27 jbasu Exp $ sqlca.h 
 */

/* Copyright (c) 1985,1986, 1998 by Oracle Corporation. */
 
/*
NAME
  SQLCA : SQL Communications Area.
FUNCTION
  Contains no code. Oracle fills in the SQLCA with status info
  during the execution of a SQL stmt.
NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************

  If the symbol SQLCA_STORAGE_CLASS is defined, then the SQLCA
  will be defined to have this storage class. For example:
 
    #define SQLCA_STORAGE_CLASS extern
 
  will define the SQLCA as an extern.
 
  If the symbol SQLCA_INIT is defined, then the SQLCA will be
  statically initialized. Although this is not necessary in order
  to use the SQLCA, it is a good pgming practice not to have
  unitialized variables. However, some C compilers/OS's don't
  allow automatic variables to be init'd in this manner. Therefore,
  if you are INCLUDE'ing the SQLCA in a place where it would be
  an automatic AND your C compiler/OS doesn't allow this style
  of initialization, then SQLCA_INIT should be left undefined --
  all others can define SQLCA_INIT if they wish.

  If the symbol SQLCA_NONE is defined, then the SQLCA variable will
  not be defined at all.  The symbol SQLCA_NONE should not be defined
  in source modules that have embedded SQL.  However, source modules
  that have no embedded SQL, but need to manipulate a sqlca struct
  passed in as a parameter, can set the SQLCA_NONE symbol to avoid
  creation of an extraneous sqlca variable.
 
MODIFIED
    lvbcheng   07/31/98 -  long to int
    jbasu      12/12/94 -  Bug 217878: note this is an SOSD file
    losborne   08/11/92 -  No sqlca var if SQLCA_NONE macro set 
  Clare      12/06/84 - Ch SQLCA to not be an extern.
  Clare      10/21/85 - Add initialization.
  Bradbury   01/05/86 - Only initialize when SQLCA_INIT set
  Clare      06/12/86 - Add SQLCA_STORAGE_CLASS option.
*/
 
#ifndef SQLCA
#define SQLCA 1
 
struct   sqlca
         {
         /* ub1 */ char    sqlcaid[8];
         /* b4  */ int     sqlabc;
         /* b4  */ int     sqlcode;
         struct
           {
           /* ub2 */ unsigned short sqlerrml;
           /* ub1 */ char           sqlerrmc[70];
           } sqlerrm;
         /* ub1 */ char    sqlerrp[8];
         /* b4  */ int     sqlerrd[6];
         /* ub1 */ char    sqlwarn[8];
         /* ub1 */ char    sqlext[8];
         };

#ifndef SQLCA_NONE 
#ifdef   SQLCA_STORAGE_CLASS
SQLCA_STORAGE_CLASS struct sqlca sqlca
#else
         struct sqlca sqlca
#endif
 
#ifdef  SQLCA_INIT
         = {
         {'S', 'Q', 'L', 'C', 'A', ' ', ' ', ' '},
         sizeof(struct sqlca),
         0,
         { 0, {0}},
         {'N', 'O', 'T', ' ', 'S', 'E', 'T', ' '},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0}
         }
#endif
         ;
#endif
 
#endif
 
/* end SQLCA */
/* EXEC SQL INCLUDE SQLDA.H;
 */ 
/*
 * $Header: sqlda.h 31-jul-99.19:34:41 apopat Exp $ sqlda.h 
 */

/***************************************************************
*      The SQLDA descriptor definition                         *
*--------------------------------------------------------------*
*      VAX/3B Version                                          *
*                                                              *
*  Copyright (c) 1987, 1997, 1998, 1999 by Oracle Corporation                    *
***************************************************************/


/* NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************
*/

/*  MODIFIED
    apopat     07/31/99 -  [707588] TAB to blanks for OCCS
    lvbcheng   10/27/98 -  change long to int for sqlda
    lvbcheng   08/15/97 -  Move sqlda protos to sqlcpr.h
    lvbcheng   06/25/97 -  Move sqlda protos to this file
    jbasu      01/29/95 -  correct typo
    jbasu      01/27/95 -  correct comment - ub2->sb2
    jbasu      12/12/94 - Bug 217878: note this is an SOSD file
    Morse      12/01/87 - undef L and S for v6 include files
    Richey     07/13/87 - change int defs to long 
    Clare      09/13/84 - Port: Ch types to match SQLLIB structs
    Clare      10/02/86 - Add ifndef SQLDA
*/

#ifndef SQLDA_
#define SQLDA_ 1
 
#ifdef T
# undef T
#endif
#ifdef F
# undef F
#endif

#ifdef S
# undef S
#endif
#ifdef L
# undef L
#endif
 
struct SQLDA {
  /* ub4    */ int        N; /* Descriptor size in number of entries        */
  /* text** */ char     **V; /* Ptr to Arr of addresses of main variables   */
  /* ub4*   */ int       *L; /* Ptr to Arr of lengths of buffers            */
  /* sb2*   */ short     *T; /* Ptr to Arr of types of buffers              */
  /* sb2**  */ short    **I; /* Ptr to Arr of addresses of indicator vars   */
  /* sb4    */ int        F; /* Number of variables found by DESCRIBE       */
  /* text** */ char     **S; /* Ptr to Arr of variable name pointers        */
  /* ub2*   */ short     *M; /* Ptr to Arr of max lengths of var. names     */
  /* ub2*   */ short     *C; /* Ptr to Arr of current lengths of var. names */
  /* text** */ char     **X; /* Ptr to Arr of ind. var. name pointers       */
  /* ub2*   */ short     *Y; /* Ptr to Arr of max lengths of ind. var. names */
  /* ub2*   */ short     *Z; /* Ptr to Arr of cur lengths of ind. var. names */
  };
 
typedef struct SQLDA SQLDA;
 
#endif

/* ----------------- */
/* defines for sqlda */
/* ----------------- */

#define SQLSQLDAAlloc(arg1, arg2, arg3, arg4) sqlaldt(arg1, arg2, arg3, arg4) 

#define SQLSQLDAFree(arg1, arg2) sqlclut(arg1, arg2) 





FILE *fp;
#include <winproc.h>

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;

    if (argc < 6)  
    {
		int i = 0;
		disp_message(ERR_MESG,"Not enough Parameters for running this program");
		proc_exit();
    }
	 

    strcpy(g_pgm_id,"ARBBLINV");

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);


    if (sql_connect() == -1)
    {
		disp_message(ERR_MESG,"Error in connecting to Oracle");
		proc_exit();
    }
  
    set_meduser_role();

strcpy(p_language_id.arr,l_language_id.arr);
p_language_id.len = l_language_id.len;

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);


	strcpy(nd_operating_facility_id.arr,argv[5]);
    nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);    
    strcpy(g_facility_id, nd_operating_facility_id.arr);


    /*strcpy(nd_operating_facility_id.arr,argv[4]);  //changed from argv[5] to argv[4] 13/02/2008
    nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);    
    strcpy(g_facility_id, nd_operating_facility_id.arr);*/



    start_prog_msg();
	
    fetch_prog_param();
    fetch_ar_param();

 //Added By Saif 10/09/2007

    /* exec sql select install_yn into :v_installed_yn from sm_module 
		where module_id in ('GL','XF') and install_yn='Y'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 1;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select install_yn into :b0  from sm_module where (module_\
id in ('GL','XF') and install_yn='Y')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&v_installed_yn;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		v_installed_yn.arr[0]='\0';
		v_installed_yn.len   = 0;

    if (TOO_MANY_ROWS)
	   /* exec sql select 'Y' into :v_installed_yn from dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 1;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select 'Y' into :b0  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )24;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&v_installed_yn;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)    
	/* exec sql select 'N' into :v_installed_yn from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 1;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select 'N' into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )43;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&v_installed_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (NOT_FOUND)
	   /* exec sql select 'N' into :v_installed_yn from dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 1;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select 'N' into :b0  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )62;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&v_installed_yn;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   
	v_installed_yn.arr[v_installed_yn.len]		      = '\0';

	/* Upto Here */

    declare_cur();  

    open_cur_hdr();

    while(fetch_cur())
    {

    nd_acc_entity_code.arr[0] ='\0';
    nd_acc_entity_code.len =0;

    /* exec sql select acc_entity_code into :nd_acc_entity_code from sy_acc_entity
		where acc_entity_id  = :bl_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select acc_entity_code into :b0  from sy_acc_entity where\
 acc_entity_id=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )81;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    nd_acc_entity_code.arr[nd_acc_entity_code.len] = '\0';  

       rec_ctr++;
       if (!lock_record())
			continue;   

       if (nd_doc_num_gen_flag.arr[0] == 'Y' &&
		   bl_outst_amt < 0)
       {
			gen_doc_num();
       }
       else if (rec_ctr != 1)
			nd_inv_start_doc_num++;


       fetch_dtls();      

/* This select acc codes() function is to receive the account codes as per
   the form variable nd_dr_cnt_acc  Modified on 24/03/97 by V.S.K */       

       select_acc_codes(); /* Written on 24/03/97 */

       /* Modification on 18/05/1998  Start */

       if (bl_outst_amt > 0)
	      insert_ar_rec();
       if (bl_outst_amt < 0)
	      insert_cn_rec();

       /* Modification on 18/05/1998  End */
  
       update_bl_hdr();

       /* EXEC SQL COMMIT WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 2;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )104;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   //EXEC SQL ROLLBACK WORK;

       if (OERROR)
	 err_mesg("COMMIT failed",0,""); 
    }
    end_prog_msg();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )119;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//EXEC SQL ROLLBACK WORK;
    if (OERROR)
	 err_mesg("COMMIT WORK RELEASE failed REA",0,"");

    return;
}


fetch_prog_param()
{
    nd_fm_cust_code.arr[0]		    = '\0'; /*rajesh*/
    nd_to_cust_code.arr[0]		    = '\0';
    nd_bill_no.arr[0]			    ='\0';
    nd_fm_doc_date.arr[0]               = '\0';
    nd_to_doc_date.arr[0]               = '\0';
    nd_fm_doc_type_code.arr[0]          = '\0';
    nd_to_doc_type_code.arr[0]          = '\0';
    nd_fm_doc_num.arr[0]                = '\0';
    nd_to_doc_num.arr[0]                = '\0';
    nd_inv_doc_type_code.arr[0]         = '\0';
    nd_inv_date.arr[0]                  = '\0';
    nd_doc_num_gen_flag.arr[0]          = '\0';
    nd_p_month.arr[0]                   = '\0';
    nd_p_year.arr[0]                    = '\0';
    nd_dr_cnt_acc.arr[0]                = '\0';
    nd_acc_entity_code.arr[0]		= '\0';
    nd_module_id.arr[0]			    = '\0';
    nd_inv_status.arr[0]		    = '\0';
	nd_input_facility_id.arr[0]     = '\0';

	nd_fm_cust_code.len		    = 0;
	nd_to_cust_code.len		    = 0;
      nd_bill_no.len			    =0;
    nd_fm_doc_date.len                  = 0;
    nd_to_doc_date.len                  = 0;
    nd_fm_doc_type_code.len             = 0;
    nd_to_doc_type_code.len             = 0;
    nd_fm_doc_num.len                   = 0;
    nd_to_doc_num.len                   = 0;
    nd_inv_doc_type_code.len            = 0;
    nd_inv_date.len                     = 0;
    nd_doc_num_gen_flag.len             = 0;
	

    nd_inv_start_doc_num                = 0;     
    nd_p_month.len                      = 0;
    nd_p_year.len                       = 0;
    nd_dr_cnt_acc.len                   = 0;
    nd_acc_entity_code.len		= 0;
    nd_module_id.len			= 0;
    nd_inv_status.len			= 0;
    nd_input_facility_id.len    = 0;


   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,
		   PARAM5,PARAM6,PARAM7,PARAM8,PARAM9,
		   PARAM10,lpad(PARAM11,2,0),PARAM12,PARAM13,
		   PARAM14,
		   PARAM15,
		   PARAM16,
		   PARAM17,
		   PARAM18, //ADDED BY RAJESH
		   PARAM19,
               PARAM20
	      INTO :nd_fm_doc_date,  :nd_to_doc_date,
		   :nd_fm_doc_type_code, :nd_to_doc_type_code,
		   :nd_fm_doc_num,       :nd_to_doc_num,
		   :nd_inv_doc_type_code,:nd_inv_start_doc_num,
		   :nd_inv_date,         :nd_doc_num_gen_flag,
		   :nd_p_month,          :nd_p_year,
		   :nd_dr_cnt_acc,
		   :nd_ws_no,
		   :nd_module_id,
		   :nd_inv_status,
           :nd_input_facility_id,
		   :nd_fm_cust_code,
		   :nd_to_cust_code,
           :nd_bill_no
	      FROM SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date  
	       AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,PARAM10 ,lpad(PARAM11,2,0) ,PARAM12 ,PARAM13 ,PARAM14 ,PA\
RAM15 ,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 into :b0,:b1,:b2,:b3,:b4,:b\
5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19  from SY_P\
ROG_PARAM where (((PGM_ID=:b20 and SESSION_ID=:b21) and PGM_DATE=:b22) and OPE\
RATING_FACILITY_ID=:b23)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )134;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[0] = (unsigned int  )14;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_inv_doc_type_code;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_inv_start_doc_num;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_inv_date;
   sqlstm.sqhstl[8] = (unsigned int  )15;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_doc_num_gen_flag;
   sqlstm.sqhstl[9] = (unsigned int  )4;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_p_month;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_p_year;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_dr_cnt_acc;
   sqlstm.sqhstl[12] = (unsigned int  )4;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[13] = (unsigned int  )33;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_module_id;
   sqlstm.sqhstl[14] = (unsigned int  )5;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_inv_status;
   sqlstm.sqhstl[15] = (unsigned int  )4;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_input_facility_id;
   sqlstm.sqhstl[16] = (unsigned int  )5;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[18] = (unsigned int  )11;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_bill_no;
   sqlstm.sqhstl[19] = (unsigned int  )23;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[20] = (unsigned int  )17;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[21] = (unsigned int  )18;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[22] = (unsigned int  )27;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[23] = (unsigned int  )5;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   
   if (OERROR)    
	err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
	err_mesg("No Record found in SY_PROG_PARAM",0,"");
   
   nd_fm_doc_date.arr[nd_fm_doc_date.len]             = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]             = '\0';
   nd_fm_doc_type_code.arr[nd_fm_doc_type_code.len]   = '\0';
   nd_to_doc_type_code.arr[nd_to_doc_type_code.len]   = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]               = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]               = '\0';
   nd_inv_doc_type_code.arr[nd_inv_doc_type_code.len] = '\0';
   nd_inv_date.arr[nd_inv_date.len]                   = '\0';
   nd_doc_num_gen_flag.arr[nd_doc_num_gen_flag.len]   = '\0'; 
   nd_p_month.arr[nd_p_month.len]                     = '\0';
   nd_p_year.arr[nd_p_year.len]                       = '\0';
   nd_dr_cnt_acc.arr[nd_dr_cnt_acc.len]               = '\0';
   nd_module_id.arr[nd_module_id.len]		      = '\0';
   nd_inv_status.arr[nd_inv_status.len]		      = '\0';
   nd_input_facility_id.arr[nd_input_facility_id.len] = '\0';
   nd_fm_cust_code.arr[nd_fm_cust_code.len]		='\0';  /* Rajesh */
   nd_to_cust_code.arr[nd_to_cust_code.len]		='\0';
   nd_bill_no.arr[nd_bill_no.len]			      ='\0';
   /* EXEC SQL DELETE SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date 
	       AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((PGM_ID=:b0 and SESSIO\
N_ID=:b1) and PGM_DATE=:b2) and OPERATING_FACILITY_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )245;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[0] = (unsigned int  )17;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )27;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
	 err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
   val_doc_type();

}

fetch_ar_param()
{
	
	bl_par_post_month.arr[0]      = '\0';
    bl_par_post_year.arr[0]       = '\0';

    bl_par_post_month.len         = 0;
    bl_par_post_year.len          = 0;

   
    strcpy(bl_par_post_month.arr,nd_p_month.arr);
    strcpy(bl_par_post_year.arr,nd_p_year.arr);

	bl_par_post_month.len = strlen(bl_par_post_month.arr);
	bl_par_post_year.len  = strlen(bl_par_post_year.arr);

}
  
declare_cur()
{


     /* EXEC SQL DECLARE BL_HDR_CUR CURSOR FOR
            SELECT DOC_TYPE_CODE,
            DOC_NUM,
			OPERATING_FACILITY_ID
            FROM BL_BILL_HDR 
            WHERE TRUNC(DOC_DATE) BETWEEN
            NVL( TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),to_date('01/01/1900', 'DD/MM/YYYY'))
             AND 
			NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),
                             to_date('01/01/3000','DD/MM/YYYY')) 
			AND ((( (DOC_TYPE_CODE||LPAD(DOC_NUM,8,0))  
			BETWEEN
                NVL(:nd_fm_doc_type_code,DOC_TYPE_CODE)||LPAD(NVL(:nd_fm_doc_num,DOC_NUM),8,'0') 
            AND NVL(:nd_to_doc_type_code,DOC_TYPE_CODE)||LPAD(NVL(:nd_to_doc_num,DOC_NUM),8,'0') 
            AND CUST_CODE BETWEEN NVL(:nd_fm_cust_code,'!!!!!!!!') AND NVL(:nd_to_cust_code,'~~~~~~~~') /orajesho/
            		  
			  AND (:nd_input_facility_id = 'A' OR
			       OPERATING_FACILITY_ID = :nd_input_facility_id)
		      AND :d_curr_pgm_name = 'ARBBLINV')
		      OR		   
		      ((DOC_TYPE_CODE,DOC_NUM) IN 
				(SELECT DOC_TYPE_CODE,DOC_NUM FROM AR_INV_PROCESS_TEMP
			         WHERE PROCESS_PGM_ID = 'ARTGNINV'
					 AND   PROCESS_SESSION_ID=:nd_session_id
					 AND   PROCESS_DATE_TIME=:nd_pgm_date)
  				 AND :d_curr_pgm_name = 'ARTGNINV')))           
             AND BILL_NATURE_CODE = 'A'
		     //AND BILL_POSTED_FLAG = 'Y'
			 AND CUST_CODE IS NOT NULL
		     AND NVL(BILL_TOT_OUTST_AMT,0) != 0
		     AND BILL_STATUS IS NULL   
			 AND ((:v_installed_yn = 'Y' AND BILL_POSTED_FLAG = 'Y') 
						OR (:v_installed_yn = 'N'))   //Rajesh
		     AND (:nd_input_facility_id = 'A' OR 
		           OPERATING_FACILITY_ID = :nd_input_facility_id ); */ 

	      
               

     /* EXEC SQL DECLARE BL_HDR_REC_CUR CURSOR FOR
	       SELECT TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
		      BILL_TRX_TYPE_CODE,
		      SERV_LOCN_CODE,
		      TO_CHAR(BILL_FROM_DATE,'DD/MM/YYYY'),
		      TO_CHAR(BILL_TO_DATE,'DD/MM/YYYY'),
		      GROSS_AMT,
		      SERV_DISC_AMT,
		      MAN_DISC_AMT,
		      OVERALL_DISC_PERC,
		      OVERALL_DISC_AMT,
		      OVR_DISC_ACC_INT_CODE,
		      PREPAY_ADJ_AMT,
		      DEPOSIT_ADJ_AMT,
		      BILL_AMT,
		      BILL_HOSP_AMT,
		      BILL_DRFEE_AMT,
		      BILL_PRV_DOC_TYPE_CODE,
		      BILL_PRV_DOC_NUMBER,
		      TO_CHAR(BILL_PRV_DOC_DATE,'DD/MM/YYYY'),
		      BILL_PRV_BILL_AMT,
		      BILL_PRV_BILL_PAID_AMT,
		      BILL_PRV_OUTST_AMT,
		      BILL_HOSP_PRV_OUTST_AMT,
		      BILL_DRFEE_PRV_OUTST_AMT,
		      BILL_TOT_AMT,
		      BILL_HOSP_TOT_AMT,
		      BILL_DRFEE_TOT_AMT,
		      NVL(BILL_TOT_OUTST_AMT,0),
		      NVL(BILL_HOSP_TOT_OUTST_AMT,0),
		      NVL(BILL_DRFEE_TOT_OUTST_AMT,0),
		      NVL(BILL_TOT_OUTST_AMT,0),
		      NVL(BILL_DRFEE_TOT_OUTST_AMT,0),
		      BILL_PAID_AMT,
		      EPISODE_TYPE,
		      PATIENT_ID,
		      EPISODE_ID,
		      VISIT_ID,
		      TO_CHAR(ADMISSION_DATE,'DD/MM/YYYY'),
		      WARD_CODE,
		      BED_CLASS_CODE,
		      ROOM_NUM,
		      BED_NUM,
		      PHYSICIAN_ID,
		      CLINIC_CODE,
		      CUST_CODE,
		      BLNG_GRP_ID,
		      BILL_TYPE_CODE,
		      CONS_INVOICE_IND,
		      BILL_STATUS,
		      BILL_PRINT_FLAG,
		      DRFEE_BILL_UPD_FLAG,
		      DRFEE_REC_UPD_FLAG,
		      DRFEE_RECEIPT_AMT,
		      AR_INV_DOC_TYPE_CODE,
		      AR_INV_DOC_NUMBER,
		      TO_CHAR(AR_INV_DOC_DATE,'DD/MM/YYYY'),
		      LAST_RECPT_DOC_TYPE_CODE,
		      LAST_RECPT_DOC_NUM,
		      TO_CHAR(LAST_RECPT_DOC_DATE,'DD/MM/YYYY'),
		      BILL_NATURE_CODE,
		      TOT_PAID_AMT,
		      BILL_POSTED_FLAG,
		      ADDED_BY_ID,
		      MODIFIED_BY_ID,
		      TO_CHAR(ADDED_DATE,'DD/MM/YYYY'),
		      TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY'),
		      ROWID
		 FROM BL_BILL_HDR
		WHERE DOC_TYPE_CODE = :bl_h_doc_type_code
          AND DOC_NUM       = :bl_h_doc_num
		  AND OPERATING_FACILITY_ID = :bl_facility_id
		  FOR UPDATE OF DOC_TYPE_CODE NOWAIT; */ 

 
     /* EXEC SQL DECLARE BL_BILL_TYPE_CUR CURSOR FOR  
	       SELECT A.BL_RECV_ACC_INT_CODE, 
		          A.AR_RECV_ACC_INT_CODE, 
		          B.SHORT_DESC
		 FROM BL_BILL_TYPE_INT A, BL_BILL_TYPE B
		WHERE A.BILL_TYPE_CODE = :bl_h_bill_type_code
		  AND A.ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
			WHERE ACC_ENTITY_ID = :nd_operating_facility_id )
          And TO_DATE(:nd_inv_date,'DD/MM/YYYY') between nvl(A.EFF_FROM_DATE,sysdate)  and nvl(A.EFF_TO_DATE,sysdate)
		  AND A.BILL_TYPE_CODE = B.BILL_TYPE_CODE; */ 



     /* EXEC SQL DECLARE BL_GL_ACCOUNT_CUR CURSOR FOR
	       SELECT MAIN_ACC1_CODE,
		      MAIN_ACC2_CODE,
		      DEPT_CODE,
		      SUBLEDGER_GROUP_CODE,
		      SUBLEDGER_LINE_CODE,
		      PRODUCT_GROUP_CODE,
		      PRODUCT_LINE_CODE
		 FROM BL_GL_ACCOUNT
		WHERE ACC_INT_CODE = :recv_int_code
		  AND ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
			WHERE ACC_ENTITY_ID = :nd_operating_facility_id ); */ 

 
     /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
	       SELECT PMNT_TERMS_CODE,NVL(CREDIT_LIMIT_AMT,0)
		 FROM AR_CUSTOMER
		WHERE CUST_CODE = :bl_h_cust_code; */ 


     /* EXEC SQL DECLARE AR_PMNT_TERMS_CUR CURSOR FOR
	       SELECT CREDIT_DAYS_PERIOD,
		      SETTLEMENT_DAYS_PERIOD,
		      SETTLEMENT_PERC
		 FROM AR_PMNT_TERMS
		WHERE PMNT_TERMS_CODE = :bl_cust_pmnt_terms_code
		  AND ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
			WHERE ACC_ENTITY_ID = :nd_operating_facility_id ); */ 


     /* EXEC SQL DECLARE BL_EPI_FIN_DTLS_CUR CURSOR FOR
	       SELECT  NVL(SUBSTR(CREDIT_DOC_REF_DESC,1,15),SUBSTR(POLICY_NUMBER,1,15)),
		           SUBSTR(POLICY_NUMBER,1,25)
		 FROM BL_EPISODE_FIN_DTLS
		WHERE EPISODE_TYPE = :bl_h_episode_type --DECODE(:bl_h_bill_trx_type_code,'E','O','D','I','A','I')
		  AND EPISODE_ID   = :bl_h_episode_id
		  AND OPERATING_FACILITY_ID = :bl_facility_id; */ 


     /* EXEC SQL DECLARE BL_VISIT_FIN_DTLS_CUR CURSOR FOR
	       SELECT NVL(SUBSTR(CREDIT_DOC_REF_DESC,1,15),SUBSTR(POLICY_NUMBER,1,15)),
		   SUBSTR(POLICY_NUMBER,1,15)
		 FROM BL_VISIT_FIN_DTLS
		WHERE EPISODE_TYPE = :bl_h_episode_type  //04/03/2005
		  AND EPISODE_ID   = :bl_h_episode_id
		  AND VISIT_ID     = :bl_h_visit_id
		  AND OPERATING_FACILITY_ID = :bl_facility_id; */ 


     /* EXEC SQL DECLARE BL_PATIENT_FIN_DTLS_CUR CURSOR FOR
	       SELECT NVL(SUBSTR(CREDIT_DOC_REF_DESC,1,15),SUBSTR(POLICY_NUMBER,1,15))
		 FROM BL_PATIENT_FIN_DTLS
		WHERE PATIENT_ID   = :bl_h_patient_id; */ 



   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
	     SELECT NVL(STATUS,'X'),
		    'Y',--NVL(AR_VALID_FLAG,'X'),
		    NVL(DOC_NUM_GEN_FLAG,'N')
	       FROM SY_ACC_ENTITY_DOC_TYPE
	      WHERE DOC_TYPE_CODE   = :nd_inv_doc_type_code
		AND ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					 WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 


				 

   /* EXEC SQL DECLARE AR_TRN_DOC_TYPE_CUR CURSOR FOR
	     SELECT 'X'
	       FROM AR_TRN_DOC_TYPE
	      WHERE DOC_TYPE_CODE = :nd_inv_doc_type_code
		AND TRN_TYPE_CODE = '3'
		AND ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					 WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 


}

val_doc_type()
{ 

   /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0019;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )276;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
   if (OERROR)
       err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,"");

   d_acc_status.arr[0]     = '\0';
   d_acc_valid_flag.arr[0] = '\0';
   nd_doc_num_gen_flag.arr[0]          = '\0';

   d_acc_valid_flag.len = 0;
   d_acc_status.len     = 0;
   nd_doc_num_gen_flag.len             = 0;

   /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
	     INTO :d_acc_status,
		  :d_acc_valid_flag,
		  :nd_doc_num_gen_flag; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )299;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_status;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_acc_valid_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_doc_num_gen_flag;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   
   if (OERROR)
	err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,""); 

   d_acc_status.arr[d_acc_status.len]         = '\0';
   d_acc_valid_flag.arr[d_acc_valid_flag.len] = '\0';
   nd_doc_num_gen_flag.arr[nd_doc_num_gen_flag.len]   = '\0';

   if (NOT_FOUND)      /* Doc type not existing in SY_ACC_ENTITY_DOC_TYPE */
	 err_mesg("",1,"SY2200");
   else
   {
      if (d_acc_valid_flag.arr[0] != 'Y') /* Doc Not valid for AR    */
	    err_mesg("Document Type not valid for AR module",0,"");
      if (d_acc_status.arr[0] == 'S')     /* Doc is suspended        */
	    err_mesg("",1,"SY2190");
   } 

   /* EXEC SQL OPEN AR_TRN_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0020;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )326;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
	 err_mesg("OPEN failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

//disp_message(ERR_MESG,nd_inv_doc_type_code.arr);	

   /* EXEC SQL FETCH AR_TRN_DOC_TYPE_CUR
	     INTO :l_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )349;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)l_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )4;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqharc[0] = (unsigned int   *)0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
	 err_mesg("FETCH failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   if (NOT_FOUND)
       err_mesg("Trn type Not valid for this document",0,"");

} 

open_cur_hdr()
{
     /* EXEC SQL OPEN BL_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )368;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_date;
     sqlstm.sqhstl[0] = (unsigned int  )14;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_date;
     sqlstm.sqhstl[1] = (unsigned int  )14;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_type_code;
     sqlstm.sqhstl[2] = (unsigned int  )9;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_num;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_num;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_fm_cust_code;
     sqlstm.sqhstl[6] = (unsigned int  )11;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_cust_code;
     sqlstm.sqhstl[7] = (unsigned int  )11;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_input_facility_id;
     sqlstm.sqhstl[8] = (unsigned int  )5;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_input_facility_id;
     sqlstm.sqhstl[9] = (unsigned int  )5;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_curr_pgm_name;
     sqlstm.sqhstl[10] = (unsigned int  )17;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&nd_session_id;
     sqlstm.sqhstl[11] = (unsigned int  )18;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&nd_pgm_date;
     sqlstm.sqhstl[12] = (unsigned int  )27;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&d_curr_pgm_name;
     sqlstm.sqhstl[13] = (unsigned int  )17;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&v_installed_yn;
     sqlstm.sqhstl[14] = (unsigned int  )4;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&v_installed_yn;
     sqlstm.sqhstl[15] = (unsigned int  )4;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&nd_input_facility_id;
     sqlstm.sqhstl[16] = (unsigned int  )5;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&nd_input_facility_id;
     sqlstm.sqhstl[17] = (unsigned int  )5;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_HDR_CUR",0,"");
}

fetch_cur()
{
bl_h_doc_type_code.arr[0]                                 = '\0';
bl_h_doc_num.arr[0]                                       = '\0';
bl_facility_id.arr[0]                                     = '\0';

bl_h_doc_type_code.len                                    = 0;
bl_h_doc_num.len                                          = 0;
bl_facility_id.len                                        = 0;
 
     /* EXEC SQL FETCH BL_HDR_CUR
	       INTO :bl_h_doc_type_code,
		    :bl_h_doc_num,
			:bl_facility_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )455;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_h_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
	        
     if (OERROR)
         err_mesg("FETCH failed on cursor BL_HDR_CUR xxxx...",0,"");

bl_h_doc_type_code.arr[bl_h_doc_type_code.len]                           = '\0';
bl_h_doc_num.arr[bl_h_doc_num.len]                                       = '\0';
bl_facility_id.arr[bl_facility_id.len]                                   = '\0';

   return(LAST_ROW?0:1);
}

lock_record()
{
   char l_str[100];

bl_h_doc_date.arr[0]                                              = '\0';
bl_h_bill_trx_type_code.arr[0]                                    = '\0';
bl_h_serv_locn_code.arr[0]                                        = '\0';
bl_h_bill_from_date.arr[0]                                        = '\0';
bl_h_bill_to_date.arr[0]                                          = '\0';
bl_h_gross_amt.arr[0]                                             = '\0';
bl_h_serv_disc_amt.arr[0]                                         = '\0';
bl_h_man_disc_amt.arr[0]                                          = '\0';
bl_h_overall_disc_perc.arr[0]                                     = '\0';
bl_h_overall_disc_amt.arr[0]                                      = '\0';
bl_h_ovr_disc_acc_int_code.arr[0]                                 = '\0';
bl_h_prepay_adj_amt.arr[0]                                        = '\0';
bl_h_deposit_adj_amt.arr[0]                                       = '\0';
bl_h_bill_amt.arr[0]                                              = '\0';
bl_h_bill_hosp_amt.arr[0]                                         = '\0';
bl_h_bill_drfee_amt.arr[0]                                        = '\0';
bl_h_bill_prv_doc_type_code.arr[0]                                = '\0';
bl_h_bill_prv_doc_number.arr[0]                                   = '\0';
bl_h_bill_prv_doc_date.arr[0]                                     = '\0';
bl_h_bill_prv_bill_amt.arr[0]                                     = '\0';
bl_h_bill_prv_bill_paid_amt.arr[0]                                = '\0';
bl_h_bill_prv_outst_amt.arr[0]                                    = '\0';
bl_h_bill_hosp_prv_outst_amt.arr[0]                               = '\0';
bl_h_bill_drfee_prv_out_amt.arr[0]                              = '\0';
bl_h_bill_tot_amt.arr[0]                                          = '\0';
bl_h_bill_hosp_tot_amt.arr[0]                                     = '\0';
bl_h_bill_drfee_tot_amt.arr[0]                                    = '\0';
bl_h_bill_tot_outst_amt.arr[0]                                    = '\0';
bl_h_bill_hosp_tot_outst_amt.arr[0]                               = '\0';
bl_h_bill_drfee_tot_out_amt.arr[0]                              = '\0';
bl_h_bill_paid_amt.arr[0]                                         = '\0';
bl_h_episode_type.arr[0]                                          = '\0';
bl_h_patient_id.arr[0]                                            = '\0';
bl_h_episode_id.arr[0]                                            = '\0';
bl_h_visit_id.arr[0]                                              = '\0';
bl_h_admission_date.arr[0]                                        = '\0';
bl_h_ward_code.arr[0]                                             = '\0';
bl_h_bed_class_code.arr[0]                                        = '\0';
bl_h_room_num.arr[0]                                              = '\0';
bl_h_bed_num.arr[0]                                               = '\0';
bl_h_physician_id.arr[0]                                          = '\0';
bl_h_clinic_code.arr[0]                                           = '\0';
bl_h_cust_code.arr[0]                                             = '\0';
bl_h_blng_grp_id.arr[0]                                           = '\0';
bl_h_bill_type_code.arr[0]                                        = '\0';
bl_h_cons_invoice_ind.arr[0]                                      = '\0';
bl_h_bill_status.arr[0]                                           = '\0';
bl_h_bill_print_flag.arr[0]                                       = '\0';
bl_h_drfee_bill_upd_flag.arr[0]                                   = '\0';
bl_h_drfee_rec_upd_flag.arr[0]                                    = '\0';
bl_h_drfee_receipt_amt.arr[0]                                     = '\0';
bl_h_ar_inv_doc_type_code.arr[0]                                  = '\0';
bl_h_ar_inv_doc_number.arr[0]                                     = '\0';
bl_h_ar_inv_doc_date.arr[0]                                       = '\0';
bl_h_last_recpt_doc_type_cd.arr[0]                              = '\0';
bl_h_last_recpt_doc_num.arr[0]                                    = '\0';
bl_h_last_recpt_doc_date.arr[0]                                   = '\0';
bl_h_bill_nature_code.arr[0]                                      = '\0';
bl_h_tot_paid_amt.arr[0]                                          = '\0';
bl_h_bill_posted_flag.arr[0]                                      = '\0';
bl_h_added_by_id.arr[0]                                           = '\0';
bl_h_modified_by_id.arr[0]                                        = '\0';
bl_h_added_date.arr[0]                                            = '\0';
bl_h_modified_date.arr[0]                                         = '\0';
bl_h_rowid.arr[0]                                                 = '\0';

bl_h_doc_date.len                                                 = 0;
bl_h_bill_trx_type_code.len                                       = 0;
bl_h_serv_locn_code.len                                           = 0;
bl_h_bill_from_date.len                                           = 0;
bl_h_bill_to_date.len                                             = 0;
bl_h_gross_amt.len                                                = 0;
bl_h_serv_disc_amt.len                                            = 0;
bl_h_man_disc_amt.len                                             = 0;
bl_h_overall_disc_perc.len                                        = 0;
bl_h_overall_disc_amt.len                                         = 0;
bl_h_ovr_disc_acc_int_code.len                                    = 0;
bl_h_prepay_adj_amt.len                                           = 0;
bl_h_deposit_adj_amt.len                                          = 0;
bl_h_bill_amt.len                                                 = 0;
bl_h_bill_hosp_amt.len                                            = 0;
bl_h_bill_drfee_amt.len                                           = 0;
bl_h_bill_prv_doc_type_code.len                                   = 0;
bl_h_bill_prv_doc_number.len                                      = 0;
bl_h_bill_prv_doc_date.len                                        = 0;
bl_h_bill_prv_bill_amt.len                                        = 0;
bl_h_bill_prv_bill_paid_amt.len                                   = 0;
bl_h_bill_prv_outst_amt.len                                       = 0;
bl_h_bill_hosp_prv_outst_amt.len                                  = 0;
bl_h_bill_drfee_prv_out_amt.len                                 = 0;
bl_h_bill_tot_amt.len                                             = 0;
bl_h_bill_hosp_tot_amt.len                                        = 0;
bl_h_bill_drfee_tot_amt.len                                       = 0;
bl_h_bill_tot_outst_amt.len                                       = 0;
bl_h_bill_hosp_tot_outst_amt.len                                  = 0;
bl_h_bill_drfee_tot_out_amt.len                                 = 0;
bl_h_bill_paid_amt.len                                            = 0;
bl_h_episode_type.len                                             = 0;
bl_h_patient_id.len                                               = 0;
bl_h_episode_id.len                                               = 0;
bl_h_visit_id.len                                                 = 0;
bl_h_admission_date.len                                           = 0;
bl_h_ward_code.len                                                = 0;
bl_h_bed_class_code.len                                           = 0;
bl_h_room_num.len                                                 = 0;
bl_h_bed_num.len                                                  = 0;
bl_h_physician_id.len                                             = 0;
bl_h_clinic_code.len                                              = 0;
bl_h_cust_code.len                                                = 0;
bl_h_blng_grp_id.len                                              = 0;
bl_h_bill_type_code.len                                           = 0;
bl_h_cons_invoice_ind.len                                         = 0;
bl_h_bill_status.len                                              = 0;
bl_h_bill_print_flag.len                                          = 0;
bl_h_drfee_bill_upd_flag.len                                      = 0;
bl_h_drfee_rec_upd_flag.len                                       = 0;
bl_h_drfee_receipt_amt.len                                        = 0;
bl_h_ar_inv_doc_type_code.len                                     = 0;
bl_h_ar_inv_doc_number.len                                        = 0;
bl_h_ar_inv_doc_date.len                                          = 0;
bl_h_last_recpt_doc_type_cd.len                                 = 0;
bl_h_last_recpt_doc_num.len                                       = 0;
bl_h_last_recpt_doc_date.len                                      = 0;
bl_h_bill_nature_code.len                                         = 0;
bl_h_tot_paid_amt.len                                             = 0;
bl_h_bill_posted_flag.len                                         = 0;
bl_h_added_by_id.len                                              = 0;
bl_h_modified_by_id.len                                           = 0;
bl_h_added_date.len                                               = 0;
bl_h_modified_date.len                                            = 0;
bl_h_rowid.len                                                    = 0;

     /* EXEC SQL OPEN BL_HDR_REC_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "select TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,BILL_TRX_TYPE_CODE ,SERV_LOCN\
_CODE ,TO_CHAR(BILL_FROM_DATE,'DD/MM/YYYY') ,TO_CHAR(BILL_TO_DATE,'DD/MM/YYY\
Y') ,GROSS_AMT ,SERV_DISC_AMT ,MAN_DISC_AMT ,OVERALL_DISC_PERC ,OVERALL_DISC\
_AMT ,OVR_DISC_ACC_INT_CODE ,PREPAY_ADJ_AMT ,DEPOSIT_ADJ_AMT ,BILL_AMT ,BILL\
_HOSP_AMT ,BILL_DRFEE_AMT ,BILL_PRV_DOC_TYPE_CODE ,BILL_PRV_DOC_NUMBER ,TO_C\
HAR(BILL_PRV_DOC_DATE,'DD/MM/YYYY') ,BILL_PRV_BILL_AMT ,BILL_PRV_BILL_PAID_A\
MT ,BILL_PRV_OUTST_AMT ,BILL_HOSP_PRV_OUTST_AMT ,BILL_DRFEE_PRV_OUTST_AMT ,B\
ILL_TOT_AMT ,BILL_HOSP_TOT_AMT ,BILL_DRFEE_TOT_AMT ,NVL(BILL_TOT_OUTST_AMT,0\
) ,NVL(BILL_HOSP_TOT_OUTST_AMT,0) ,NVL(BILL_DRFEE_TOT_OUTST_AMT,0) ,NVL(BILL\
_TOT_OUTST_AMT,0) ,NVL(BILL_DRFEE_TOT_OUTST_AMT,0) ,BILL_PAID_AMT ,EPISODE_T\
YPE ,PATIENT_ID ,EPISODE_ID ,VISIT_ID ,TO_CHAR(ADMISSION_DATE,'DD/MM/YYYY') \
,WARD_CODE ,BED_CLASS_CODE ,ROOM_NUM ,BED_NUM ,PHYSICIAN_ID ,CLINIC_CODE ,CU\
ST_CODE ,BLNG_GRP_ID ,BILL_TYPE_CODE ,CONS_INVOICE_IND ,BILL_STATUS ,BILL_PR\
INT_FLAG ,DRFEE_BILL_UPD_FLAG ,DRFEE_REC_UPD");
     sqlstm.stmt = sq0011;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )482;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_h_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



sprintf(l_str,"BL BILL HDR Document %s - %s busy",
	     bl_h_doc_type_code.arr,bl_h_doc_num.arr);

     if (RESOURCE_BUSY)
     {
	 log_err_mesg(l_str,0,"");
	 return(0);
     }
     else if (OERROR)
	 err_mesg("OPEN failed on cursor BL_HDR_REC_CUR",0,"");


     /* EXEC SQL FETCH BL_HDR_REC_CUR
	       INTO :bl_h_doc_date,
		    :bl_h_bill_trx_type_code,
		    :bl_h_serv_locn_code,
		    :bl_h_bill_from_date,
		    :bl_h_bill_to_date,
		    :bl_h_gross_amt,
		    :bl_h_serv_disc_amt,
		    :bl_h_man_disc_amt,
		    :bl_h_overall_disc_perc,
		    :bl_h_overall_disc_amt,
		    :bl_h_ovr_disc_acc_int_code,
		    :bl_h_prepay_adj_amt,
		    :bl_h_deposit_adj_amt,
		    :bl_h_bill_amt,
		    :bl_h_bill_hosp_amt,
		    :bl_h_bill_drfee_amt,
		    :bl_h_bill_prv_doc_type_code,
		    :bl_h_bill_prv_doc_number,
		    :bl_h_bill_prv_doc_date,
		    :bl_h_bill_prv_bill_amt,
		    :bl_h_bill_prv_bill_paid_amt,
		    :bl_h_bill_prv_outst_amt,
		    :bl_h_bill_hosp_prv_outst_amt,
                    :bl_h_bill_drfee_prv_out_amt,
		    :bl_h_bill_tot_amt,
		    :bl_h_bill_hosp_tot_amt,
		    :bl_h_bill_drfee_tot_amt,
		    :bl_h_bill_tot_outst_amt,
		    :bl_h_bill_hosp_tot_outst_amt,
                    :bl_h_bill_drfee_tot_out_amt,
		    :bl_outst_amt,
		    :bl_drfee_outst_amt,
		    :bl_h_bill_paid_amt,
		    :bl_h_episode_type,
		    :bl_h_patient_id,
		    :bl_h_episode_id,
		    :bl_h_visit_id,
		    :bl_h_admission_date,
		    :bl_h_ward_code,
		    :bl_h_bed_class_code,
		    :bl_h_room_num,
		    :bl_h_bed_num,
		    :bl_h_physician_id,
		    :bl_h_clinic_code,
		    :bl_h_cust_code,
	 	    :bl_h_blng_grp_id,
		    :bl_h_bill_type_code,
		    :bl_h_cons_invoice_ind,
		    :bl_h_bill_status,
		    :bl_h_bill_print_flag,
		    :bl_h_drfee_bill_upd_flag,
		    :bl_h_drfee_rec_upd_flag,
		    :bl_h_drfee_receipt_amt,
		    :bl_h_ar_inv_doc_type_code,
		    :bl_h_ar_inv_doc_number,
		    :bl_h_ar_inv_doc_date,
                    :bl_h_last_recpt_doc_type_cd,
		    :bl_h_last_recpt_doc_num,
		    :bl_h_last_recpt_doc_date,
		    :bl_h_bill_nature_code,
		    :bl_h_tot_paid_amt,
		    :bl_h_bill_posted_flag,
		    :bl_h_added_by_id,
		    :bl_h_modified_by_id,
		    :bl_h_added_date,
		    :bl_h_modified_date,
		    :bl_h_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )509;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[0] = (unsigned int  )15;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_h_bill_trx_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )4;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_h_serv_locn_code;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_h_bill_from_date;
     sqlstm.sqhstl[3] = (unsigned int  )15;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_h_bill_to_date;
     sqlstm.sqhstl[4] = (unsigned int  )15;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_h_gross_amt;
     sqlstm.sqhstl[5] = (unsigned int  )25;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_h_serv_disc_amt;
     sqlstm.sqhstl[6] = (unsigned int  )25;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_h_man_disc_amt;
     sqlstm.sqhstl[7] = (unsigned int  )25;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_h_overall_disc_perc;
     sqlstm.sqhstl[8] = (unsigned int  )8;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_h_overall_disc_amt;
     sqlstm.sqhstl[9] = (unsigned int  )25;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_h_ovr_disc_acc_int_code;
     sqlstm.sqhstl[10] = (unsigned int  )9;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_h_prepay_adj_amt;
     sqlstm.sqhstl[11] = (unsigned int  )25;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_h_deposit_adj_amt;
     sqlstm.sqhstl[12] = (unsigned int  )25;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_h_bill_amt;
     sqlstm.sqhstl[13] = (unsigned int  )25;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_h_bill_hosp_amt;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_h_bill_drfee_amt;
     sqlstm.sqhstl[15] = (unsigned int  )25;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_h_bill_prv_doc_type_code;
     sqlstm.sqhstl[16] = (unsigned int  )9;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_h_bill_prv_doc_number;
     sqlstm.sqhstl[17] = (unsigned int  )25;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_h_bill_prv_doc_date;
     sqlstm.sqhstl[18] = (unsigned int  )15;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_h_bill_prv_bill_amt;
     sqlstm.sqhstl[19] = (unsigned int  )25;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_h_bill_prv_bill_paid_amt;
     sqlstm.sqhstl[20] = (unsigned int  )25;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_h_bill_prv_outst_amt;
     sqlstm.sqhstl[21] = (unsigned int  )25;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_h_bill_hosp_prv_outst_amt;
     sqlstm.sqhstl[22] = (unsigned int  )25;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_h_bill_drfee_prv_out_amt;
     sqlstm.sqhstl[23] = (unsigned int  )25;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_h_bill_tot_amt;
     sqlstm.sqhstl[24] = (unsigned int  )25;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&bl_h_bill_hosp_tot_amt;
     sqlstm.sqhstl[25] = (unsigned int  )25;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&bl_h_bill_drfee_tot_amt;
     sqlstm.sqhstl[26] = (unsigned int  )25;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&bl_h_bill_tot_outst_amt;
     sqlstm.sqhstl[27] = (unsigned int  )25;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&bl_h_bill_hosp_tot_outst_amt;
     sqlstm.sqhstl[28] = (unsigned int  )25;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&bl_h_bill_drfee_tot_out_amt;
     sqlstm.sqhstl[29] = (unsigned int  )25;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&bl_outst_amt;
     sqlstm.sqhstl[30] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&bl_drfee_outst_amt;
     sqlstm.sqhstl[31] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&bl_h_bill_paid_amt;
     sqlstm.sqhstl[32] = (unsigned int  )25;
     sqlstm.sqhsts[32] = (         int  )0;
     sqlstm.sqindv[32] = (         void  *)0;
     sqlstm.sqinds[32] = (         int  )0;
     sqlstm.sqharm[32] = (unsigned int  )0;
     sqlstm.sqadto[32] = (unsigned short )0;
     sqlstm.sqtdso[32] = (unsigned short )0;
     sqlstm.sqhstv[33] = (         void  *)&bl_h_episode_type;
     sqlstm.sqhstl[33] = (unsigned int  )4;
     sqlstm.sqhsts[33] = (         int  )0;
     sqlstm.sqindv[33] = (         void  *)0;
     sqlstm.sqinds[33] = (         int  )0;
     sqlstm.sqharm[33] = (unsigned int  )0;
     sqlstm.sqadto[33] = (unsigned short )0;
     sqlstm.sqtdso[33] = (unsigned short )0;
     sqlstm.sqhstv[34] = (         void  *)&bl_h_patient_id;
     sqlstm.sqhstl[34] = (unsigned int  )23;
     sqlstm.sqhsts[34] = (         int  )0;
     sqlstm.sqindv[34] = (         void  *)0;
     sqlstm.sqinds[34] = (         int  )0;
     sqlstm.sqharm[34] = (unsigned int  )0;
     sqlstm.sqadto[34] = (unsigned short )0;
     sqlstm.sqtdso[34] = (unsigned short )0;
     sqlstm.sqhstv[35] = (         void  *)&bl_h_episode_id;
     sqlstm.sqhstl[35] = (unsigned int  )11;
     sqlstm.sqhsts[35] = (         int  )0;
     sqlstm.sqindv[35] = (         void  *)0;
     sqlstm.sqinds[35] = (         int  )0;
     sqlstm.sqharm[35] = (unsigned int  )0;
     sqlstm.sqadto[35] = (unsigned short )0;
     sqlstm.sqtdso[35] = (unsigned short )0;
     sqlstm.sqhstv[36] = (         void  *)&bl_h_visit_id;
     sqlstm.sqhstl[36] = (unsigned int  )7;
     sqlstm.sqhsts[36] = (         int  )0;
     sqlstm.sqindv[36] = (         void  *)0;
     sqlstm.sqinds[36] = (         int  )0;
     sqlstm.sqharm[36] = (unsigned int  )0;
     sqlstm.sqadto[36] = (unsigned short )0;
     sqlstm.sqtdso[36] = (unsigned short )0;
     sqlstm.sqhstv[37] = (         void  *)&bl_h_admission_date;
     sqlstm.sqhstl[37] = (unsigned int  )15;
     sqlstm.sqhsts[37] = (         int  )0;
     sqlstm.sqindv[37] = (         void  *)0;
     sqlstm.sqinds[37] = (         int  )0;
     sqlstm.sqharm[37] = (unsigned int  )0;
     sqlstm.sqadto[37] = (unsigned short )0;
     sqlstm.sqtdso[37] = (unsigned short )0;
     sqlstm.sqhstv[38] = (         void  *)&bl_h_ward_code;
     sqlstm.sqhstl[38] = (unsigned int  )7;
     sqlstm.sqhsts[38] = (         int  )0;
     sqlstm.sqindv[38] = (         void  *)0;
     sqlstm.sqinds[38] = (         int  )0;
     sqlstm.sqharm[38] = (unsigned int  )0;
     sqlstm.sqadto[38] = (unsigned short )0;
     sqlstm.sqtdso[38] = (unsigned short )0;
     sqlstm.sqhstv[39] = (         void  *)&bl_h_bed_class_code;
     sqlstm.sqhstl[39] = (unsigned int  )5;
     sqlstm.sqhsts[39] = (         int  )0;
     sqlstm.sqindv[39] = (         void  *)0;
     sqlstm.sqinds[39] = (         int  )0;
     sqlstm.sqharm[39] = (unsigned int  )0;
     sqlstm.sqadto[39] = (unsigned short )0;
     sqlstm.sqtdso[39] = (unsigned short )0;
     sqlstm.sqhstv[40] = (         void  *)&bl_h_room_num;
     sqlstm.sqhstl[40] = (unsigned int  )7;
     sqlstm.sqhsts[40] = (         int  )0;
     sqlstm.sqindv[40] = (         void  *)0;
     sqlstm.sqinds[40] = (         int  )0;
     sqlstm.sqharm[40] = (unsigned int  )0;
     sqlstm.sqadto[40] = (unsigned short )0;
     sqlstm.sqtdso[40] = (unsigned short )0;
     sqlstm.sqhstv[41] = (         void  *)&bl_h_bed_num;
     sqlstm.sqhstl[41] = (unsigned int  )11;
     sqlstm.sqhsts[41] = (         int  )0;
     sqlstm.sqindv[41] = (         void  *)0;
     sqlstm.sqinds[41] = (         int  )0;
     sqlstm.sqharm[41] = (unsigned int  )0;
     sqlstm.sqadto[41] = (unsigned short )0;
     sqlstm.sqtdso[41] = (unsigned short )0;
     sqlstm.sqhstv[42] = (         void  *)&bl_h_physician_id;
     sqlstm.sqhstl[42] = (unsigned int  )18;
     sqlstm.sqhsts[42] = (         int  )0;
     sqlstm.sqindv[42] = (         void  *)0;
     sqlstm.sqinds[42] = (         int  )0;
     sqlstm.sqharm[42] = (unsigned int  )0;
     sqlstm.sqadto[42] = (unsigned short )0;
     sqlstm.sqtdso[42] = (unsigned short )0;
     sqlstm.sqhstv[43] = (         void  *)&bl_h_clinic_code;
     sqlstm.sqhstl[43] = (unsigned int  )7;
     sqlstm.sqhsts[43] = (         int  )0;
     sqlstm.sqindv[43] = (         void  *)0;
     sqlstm.sqinds[43] = (         int  )0;
     sqlstm.sqharm[43] = (unsigned int  )0;
     sqlstm.sqadto[43] = (unsigned short )0;
     sqlstm.sqtdso[43] = (unsigned short )0;
     sqlstm.sqhstv[44] = (         void  *)&bl_h_cust_code;
     sqlstm.sqhstl[44] = (unsigned int  )11;
     sqlstm.sqhsts[44] = (         int  )0;
     sqlstm.sqindv[44] = (         void  *)0;
     sqlstm.sqinds[44] = (         int  )0;
     sqlstm.sqharm[44] = (unsigned int  )0;
     sqlstm.sqadto[44] = (unsigned short )0;
     sqlstm.sqtdso[44] = (unsigned short )0;
     sqlstm.sqhstv[45] = (         void  *)&bl_h_blng_grp_id;
     sqlstm.sqhstl[45] = (unsigned int  )7;
     sqlstm.sqhsts[45] = (         int  )0;
     sqlstm.sqindv[45] = (         void  *)0;
     sqlstm.sqinds[45] = (         int  )0;
     sqlstm.sqharm[45] = (unsigned int  )0;
     sqlstm.sqadto[45] = (unsigned short )0;
     sqlstm.sqtdso[45] = (unsigned short )0;
     sqlstm.sqhstv[46] = (         void  *)&bl_h_bill_type_code;
     sqlstm.sqhstl[46] = (unsigned int  )5;
     sqlstm.sqhsts[46] = (         int  )0;
     sqlstm.sqindv[46] = (         void  *)0;
     sqlstm.sqinds[46] = (         int  )0;
     sqlstm.sqharm[46] = (unsigned int  )0;
     sqlstm.sqadto[46] = (unsigned short )0;
     sqlstm.sqtdso[46] = (unsigned short )0;
     sqlstm.sqhstv[47] = (         void  *)&bl_h_cons_invoice_ind;
     sqlstm.sqhstl[47] = (unsigned int  )4;
     sqlstm.sqhsts[47] = (         int  )0;
     sqlstm.sqindv[47] = (         void  *)0;
     sqlstm.sqinds[47] = (         int  )0;
     sqlstm.sqharm[47] = (unsigned int  )0;
     sqlstm.sqadto[47] = (unsigned short )0;
     sqlstm.sqtdso[47] = (unsigned short )0;
     sqlstm.sqhstv[48] = (         void  *)&bl_h_bill_status;
     sqlstm.sqhstl[48] = (unsigned int  )4;
     sqlstm.sqhsts[48] = (         int  )0;
     sqlstm.sqindv[48] = (         void  *)0;
     sqlstm.sqinds[48] = (         int  )0;
     sqlstm.sqharm[48] = (unsigned int  )0;
     sqlstm.sqadto[48] = (unsigned short )0;
     sqlstm.sqtdso[48] = (unsigned short )0;
     sqlstm.sqhstv[49] = (         void  *)&bl_h_bill_print_flag;
     sqlstm.sqhstl[49] = (unsigned int  )4;
     sqlstm.sqhsts[49] = (         int  )0;
     sqlstm.sqindv[49] = (         void  *)0;
     sqlstm.sqinds[49] = (         int  )0;
     sqlstm.sqharm[49] = (unsigned int  )0;
     sqlstm.sqadto[49] = (unsigned short )0;
     sqlstm.sqtdso[49] = (unsigned short )0;
     sqlstm.sqhstv[50] = (         void  *)&bl_h_drfee_bill_upd_flag;
     sqlstm.sqhstl[50] = (unsigned int  )4;
     sqlstm.sqhsts[50] = (         int  )0;
     sqlstm.sqindv[50] = (         void  *)0;
     sqlstm.sqinds[50] = (         int  )0;
     sqlstm.sqharm[50] = (unsigned int  )0;
     sqlstm.sqadto[50] = (unsigned short )0;
     sqlstm.sqtdso[50] = (unsigned short )0;
     sqlstm.sqhstv[51] = (         void  *)&bl_h_drfee_rec_upd_flag;
     sqlstm.sqhstl[51] = (unsigned int  )4;
     sqlstm.sqhsts[51] = (         int  )0;
     sqlstm.sqindv[51] = (         void  *)0;
     sqlstm.sqinds[51] = (         int  )0;
     sqlstm.sqharm[51] = (unsigned int  )0;
     sqlstm.sqadto[51] = (unsigned short )0;
     sqlstm.sqtdso[51] = (unsigned short )0;
     sqlstm.sqhstv[52] = (         void  *)&bl_h_drfee_receipt_amt;
     sqlstm.sqhstl[52] = (unsigned int  )25;
     sqlstm.sqhsts[52] = (         int  )0;
     sqlstm.sqindv[52] = (         void  *)0;
     sqlstm.sqinds[52] = (         int  )0;
     sqlstm.sqharm[52] = (unsigned int  )0;
     sqlstm.sqadto[52] = (unsigned short )0;
     sqlstm.sqtdso[52] = (unsigned short )0;
     sqlstm.sqhstv[53] = (         void  *)&bl_h_ar_inv_doc_type_code;
     sqlstm.sqhstl[53] = (unsigned int  )9;
     sqlstm.sqhsts[53] = (         int  )0;
     sqlstm.sqindv[53] = (         void  *)0;
     sqlstm.sqinds[53] = (         int  )0;
     sqlstm.sqharm[53] = (unsigned int  )0;
     sqlstm.sqadto[53] = (unsigned short )0;
     sqlstm.sqtdso[53] = (unsigned short )0;
     sqlstm.sqhstv[54] = (         void  *)&bl_h_ar_inv_doc_number;
     sqlstm.sqhstl[54] = (unsigned int  )11;
     sqlstm.sqhsts[54] = (         int  )0;
     sqlstm.sqindv[54] = (         void  *)0;
     sqlstm.sqinds[54] = (         int  )0;
     sqlstm.sqharm[54] = (unsigned int  )0;
     sqlstm.sqadto[54] = (unsigned short )0;
     sqlstm.sqtdso[54] = (unsigned short )0;
     sqlstm.sqhstv[55] = (         void  *)&bl_h_ar_inv_doc_date;
     sqlstm.sqhstl[55] = (unsigned int  )15;
     sqlstm.sqhsts[55] = (         int  )0;
     sqlstm.sqindv[55] = (         void  *)0;
     sqlstm.sqinds[55] = (         int  )0;
     sqlstm.sqharm[55] = (unsigned int  )0;
     sqlstm.sqadto[55] = (unsigned short )0;
     sqlstm.sqtdso[55] = (unsigned short )0;
     sqlstm.sqhstv[56] = (         void  *)&bl_h_last_recpt_doc_type_cd;
     sqlstm.sqhstl[56] = (unsigned int  )9;
     sqlstm.sqhsts[56] = (         int  )0;
     sqlstm.sqindv[56] = (         void  *)0;
     sqlstm.sqinds[56] = (         int  )0;
     sqlstm.sqharm[56] = (unsigned int  )0;
     sqlstm.sqadto[56] = (unsigned short )0;
     sqlstm.sqtdso[56] = (unsigned short )0;
     sqlstm.sqhstv[57] = (         void  *)&bl_h_last_recpt_doc_num;
     sqlstm.sqhstl[57] = (unsigned int  )25;
     sqlstm.sqhsts[57] = (         int  )0;
     sqlstm.sqindv[57] = (         void  *)0;
     sqlstm.sqinds[57] = (         int  )0;
     sqlstm.sqharm[57] = (unsigned int  )0;
     sqlstm.sqadto[57] = (unsigned short )0;
     sqlstm.sqtdso[57] = (unsigned short )0;
     sqlstm.sqhstv[58] = (         void  *)&bl_h_last_recpt_doc_date;
     sqlstm.sqhstl[58] = (unsigned int  )15;
     sqlstm.sqhsts[58] = (         int  )0;
     sqlstm.sqindv[58] = (         void  *)0;
     sqlstm.sqinds[58] = (         int  )0;
     sqlstm.sqharm[58] = (unsigned int  )0;
     sqlstm.sqadto[58] = (unsigned short )0;
     sqlstm.sqtdso[58] = (unsigned short )0;
     sqlstm.sqhstv[59] = (         void  *)&bl_h_bill_nature_code;
     sqlstm.sqhstl[59] = (unsigned int  )4;
     sqlstm.sqhsts[59] = (         int  )0;
     sqlstm.sqindv[59] = (         void  *)0;
     sqlstm.sqinds[59] = (         int  )0;
     sqlstm.sqharm[59] = (unsigned int  )0;
     sqlstm.sqadto[59] = (unsigned short )0;
     sqlstm.sqtdso[59] = (unsigned short )0;
     sqlstm.sqhstv[60] = (         void  *)&bl_h_tot_paid_amt;
     sqlstm.sqhstl[60] = (unsigned int  )25;
     sqlstm.sqhsts[60] = (         int  )0;
     sqlstm.sqindv[60] = (         void  *)0;
     sqlstm.sqinds[60] = (         int  )0;
     sqlstm.sqharm[60] = (unsigned int  )0;
     sqlstm.sqadto[60] = (unsigned short )0;
     sqlstm.sqtdso[60] = (unsigned short )0;
     sqlstm.sqhstv[61] = (         void  *)&bl_h_bill_posted_flag;
     sqlstm.sqhstl[61] = (unsigned int  )4;
     sqlstm.sqhsts[61] = (         int  )0;
     sqlstm.sqindv[61] = (         void  *)0;
     sqlstm.sqinds[61] = (         int  )0;
     sqlstm.sqharm[61] = (unsigned int  )0;
     sqlstm.sqadto[61] = (unsigned short )0;
     sqlstm.sqtdso[61] = (unsigned short )0;
     sqlstm.sqhstv[62] = (         void  *)&bl_h_added_by_id;
     sqlstm.sqhstl[62] = (unsigned int  )23;
     sqlstm.sqhsts[62] = (         int  )0;
     sqlstm.sqindv[62] = (         void  *)0;
     sqlstm.sqinds[62] = (         int  )0;
     sqlstm.sqharm[62] = (unsigned int  )0;
     sqlstm.sqadto[62] = (unsigned short )0;
     sqlstm.sqtdso[62] = (unsigned short )0;
     sqlstm.sqhstv[63] = (         void  *)&bl_h_modified_by_id;
     sqlstm.sqhstl[63] = (unsigned int  )23;
     sqlstm.sqhsts[63] = (         int  )0;
     sqlstm.sqindv[63] = (         void  *)0;
     sqlstm.sqinds[63] = (         int  )0;
     sqlstm.sqharm[63] = (unsigned int  )0;
     sqlstm.sqadto[63] = (unsigned short )0;
     sqlstm.sqtdso[63] = (unsigned short )0;
     sqlstm.sqhstv[64] = (         void  *)&bl_h_added_date;
     sqlstm.sqhstl[64] = (unsigned int  )15;
     sqlstm.sqhsts[64] = (         int  )0;
     sqlstm.sqindv[64] = (         void  *)0;
     sqlstm.sqinds[64] = (         int  )0;
     sqlstm.sqharm[64] = (unsigned int  )0;
     sqlstm.sqadto[64] = (unsigned short )0;
     sqlstm.sqtdso[64] = (unsigned short )0;
     sqlstm.sqhstv[65] = (         void  *)&bl_h_modified_date;
     sqlstm.sqhstl[65] = (unsigned int  )15;
     sqlstm.sqhsts[65] = (         int  )0;
     sqlstm.sqindv[65] = (         void  *)0;
     sqlstm.sqinds[65] = (         int  )0;
     sqlstm.sqharm[65] = (unsigned int  )0;
     sqlstm.sqadto[65] = (unsigned short )0;
     sqlstm.sqtdso[65] = (unsigned short )0;
     sqlstm.sqhstv[66] = (         void  *)&bl_h_rowid;
     sqlstm.sqhstl[66] = (unsigned int  )33;
     sqlstm.sqhsts[66] = (         int  )0;
     sqlstm.sqindv[66] = (         void  *)0;
     sqlstm.sqinds[66] = (         int  )0;
     sqlstm.sqharm[66] = (unsigned int  )0;
     sqlstm.sqadto[66] = (unsigned short )0;
     sqlstm.sqtdso[66] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
         err_mesg("FETCH failed on cursor BL_HDR_REC_CUR",0,"");

bl_h_doc_date.arr[bl_h_doc_date.len]                                     = '\0';
bl_h_bill_trx_type_code.arr[bl_h_bill_trx_type_code.len]                 = '\0';
bl_h_serv_locn_code.arr[bl_h_serv_locn_code.len]                         = '\0';
bl_h_bill_from_date.arr[bl_h_bill_from_date.len]                         = '\0';
bl_h_bill_to_date.arr[bl_h_bill_to_date.len]                             = '\0';
bl_h_gross_amt.arr[bl_h_gross_amt.len]                                   = '\0';
bl_h_serv_disc_amt.arr[bl_h_serv_disc_amt.len]                           = '\0';
bl_h_man_disc_amt.arr[bl_h_man_disc_amt.len]                             = '\0';
bl_h_overall_disc_perc.arr[bl_h_overall_disc_perc.len]                   = '\0';
bl_h_overall_disc_amt.arr[bl_h_overall_disc_amt.len]                     = '\0';
bl_h_ovr_disc_acc_int_code.arr[bl_h_ovr_disc_acc_int_code.len]           = '\0';
bl_h_prepay_adj_amt.arr[bl_h_prepay_adj_amt.len]                         = '\0';
bl_h_deposit_adj_amt.arr[bl_h_deposit_adj_amt.len]                       = '\0';
bl_h_bill_amt.arr[bl_h_bill_amt.len]                                     = '\0';
bl_h_bill_hosp_amt.arr[bl_h_bill_hosp_amt.len]                           = '\0';
bl_h_bill_drfee_amt.arr[bl_h_bill_drfee_amt.len]                         = '\0';
bl_h_bill_prv_doc_type_code.arr[bl_h_bill_prv_doc_type_code.len]         = '\0';
bl_h_bill_prv_doc_number.arr[bl_h_bill_prv_doc_number.len]               = '\0';
bl_h_bill_prv_doc_date.arr[bl_h_bill_prv_doc_date.len]                   = '\0';
bl_h_bill_prv_bill_amt.arr[bl_h_bill_prv_bill_amt.len]                   = '\0';
bl_h_bill_prv_bill_paid_amt.arr[bl_h_bill_prv_bill_paid_amt.len]         = '\0';
bl_h_bill_prv_outst_amt.arr[bl_h_bill_prv_outst_amt.len]                 = '\0';
bl_h_bill_hosp_prv_outst_amt.arr[bl_h_bill_hosp_prv_outst_amt.len]       = '\0';
bl_h_bill_drfee_prv_out_amt.arr[bl_h_bill_drfee_prv_out_amt.len]     = '\0';
bl_h_bill_tot_amt.arr[bl_h_bill_tot_amt.len]                             = '\0';
bl_h_bill_hosp_tot_amt.arr[bl_h_bill_hosp_tot_amt.len]                   = '\0';
bl_h_bill_drfee_tot_amt.arr[bl_h_bill_drfee_tot_amt.len]                 = '\0';
bl_h_bill_tot_outst_amt.arr[bl_h_bill_tot_outst_amt.len]                 = '\0';
bl_h_bill_hosp_tot_outst_amt.arr[bl_h_bill_hosp_tot_outst_amt.len]       = '\0';
bl_h_bill_drfee_tot_out_amt.arr[bl_h_bill_drfee_tot_out_amt.len]     = '\0';
bl_h_bill_paid_amt.arr[bl_h_bill_paid_amt.len]                           = '\0';
bl_h_episode_type.arr[bl_h_episode_type.len]                             = '\0';
bl_h_patient_id.arr[bl_h_patient_id.len]                                 = '\0';
bl_h_episode_id.arr[bl_h_episode_id.len]                                 = '\0';
bl_h_visit_id.arr[bl_h_visit_id.len]                                     = '\0';
bl_h_admission_date.arr[bl_h_admission_date.len]                         = '\0';
bl_h_ward_code.arr[bl_h_ward_code.len]                                   = '\0';
bl_h_bed_class_code.arr[bl_h_bed_class_code.len]                         = '\0';
bl_h_room_num.arr[bl_h_room_num.len]                                     = '\0';
bl_h_bed_num.arr[bl_h_bed_num.len]                                       = '\0';
bl_h_physician_id.arr[bl_h_physician_id.len]                             = '\0';
bl_h_clinic_code.arr[bl_h_clinic_code.len]                               = '\0';
bl_h_cust_code.arr[bl_h_cust_code.len]                                   = '\0';
bl_h_blng_grp_id.arr[bl_h_blng_grp_id.len]                               = '\0';
bl_h_bill_type_code.arr[bl_h_bill_type_code.len]                         = '\0';
bl_h_cons_invoice_ind.arr[bl_h_cons_invoice_ind.len]                     = '\0';
bl_h_bill_status.arr[bl_h_bill_status.len]                               = '\0';
bl_h_bill_print_flag.arr[bl_h_bill_print_flag.len]                       = '\0';
bl_h_drfee_bill_upd_flag.arr[bl_h_drfee_bill_upd_flag.len]               = '\0';
bl_h_drfee_rec_upd_flag.arr[bl_h_drfee_rec_upd_flag.len]                 = '\0';
bl_h_drfee_receipt_amt.arr[bl_h_drfee_receipt_amt.len]                   = '\0';
bl_h_ar_inv_doc_type_code.arr[bl_h_ar_inv_doc_type_code.len]             = '\0';
bl_h_ar_inv_doc_number.arr[bl_h_ar_inv_doc_number.len]                   = '\0';
bl_h_ar_inv_doc_date.arr[bl_h_ar_inv_doc_date.len]                       = '\0';
bl_h_last_recpt_doc_type_cd.arr[bl_h_last_recpt_doc_type_cd.len]     = '\0';
bl_h_last_recpt_doc_num.arr[bl_h_last_recpt_doc_num.len]                 = '\0';
bl_h_last_recpt_doc_date.arr[bl_h_last_recpt_doc_date.len]               = '\0';
bl_h_bill_nature_code.arr[bl_h_bill_nature_code.len]                     = '\0';
bl_h_tot_paid_amt.arr[bl_h_tot_paid_amt.len]                             = '\0';
bl_h_bill_posted_flag.arr[bl_h_bill_posted_flag.len]                     = '\0';
bl_h_added_by_id.arr[bl_h_added_by_id.len]                               = '\0';
bl_h_modified_by_id.arr[bl_h_modified_by_id.len]                         = '\0';
bl_h_added_date.arr[bl_h_added_date.len]                                 = '\0';
bl_h_modified_date.arr[bl_h_modified_date.len]                           = '\0';
bl_h_rowid.arr[bl_h_rowid.len]                                           = '\0';

strcpy(nd_inv_date.arr,bl_h_doc_date.arr);
nd_inv_date.len = strlen(nd_inv_date.arr);

   return(ROW_COUNT);
}

gen_doc_num()
{
     d_sy_acc_rowid.arr[0]  = '\0';
     d_sy_acc_rowid.len     = 0;
     work_doc_num.arr[0]  = '\0';
     work_doc_num.len     = 0;
     nd_inv_start_doc_num = 0;

     /* EXEC SQL SELECT NVL(NEXT_DOC_NO,0),    ROWID ,
                     NVL(NEXT_DOC_NO,0)
		INTO :nd_inv_start_doc_num, :d_sy_acc_rowid, :work_doc_num
		FROM SY_ACC_ENTITY_DOC_TYPE
	       WHERE DOC_TYPE_CODE = :nd_inv_doc_type_code
		 AND ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					  WHERE ACC_ENTITY_ID = :nd_operating_facility_id )
		 FOR UPDATE OF NEXT_DOC_NO; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(NEXT_DOC_NO,0) ,ROWID ,NVL(NEXT_DOC_NO,0) int\
o :b0,:b1,:b2  from SY_ACC_ENTITY_DOC_TYPE where (DOC_TYPE_CODE=:b3 and ACC_EN\
TITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:\
b4)) for update of NEXT_DOC_NO ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )792;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_inv_start_doc_num;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_sy_acc_rowid;
     sqlstm.sqhstl[1] = (unsigned int  )33;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&work_doc_num;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_inv_doc_type_code;
     sqlstm.sqhstl[3] = (unsigned int  )9;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[4] = (unsigned int  )5;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("SELECT failed on table SY_ACC_ENTITY_DOC_TYPE",0,"");

     if (NOT_FOUND)
	 err_mesg("Record not found in SY ACC ENTITY DOC TYPE",0,"");

     d_sy_acc_rowid.arr[d_sy_acc_rowid.len] = '\0';
     work_doc_num.arr[work_doc_num.len]  = '\0';

     /* EXEC SQL UPDATE SY_ACC_ENTITY_DOC_TYPE 
		 SET NEXT_DOC_NO = NVL(NEXT_DOC_NO,0) + 1
	       WHERE ROWID = :d_sy_acc_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update SY_ACC_ENTITY_DOC_TYPE  set NEXT_DOC_NO=(NVL(NEXT\
_DOC_NO,0)+1) where ROWID=:b0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )827;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_sy_acc_rowid;
     sqlstm.sqhstl[0] = (unsigned int  )33;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
	 err_mesg("UPDATE failed on table SY_ACC_ENTITY_DOC_TYPE",0,"");

}

fetch_dtls()
{
     /* EXEC SQL OPEN BL_BILL_TYPE_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0012;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )846;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_bill_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_inv_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_BILL_TYPE_CUR",0,"");


/*	sprintf(string_var," bill type code : %s",bl_h_bill_type_code.arr);
	disp_message(ERR_MESG,string_var); */


    bl_recv_acc_int_code.arr[0]            = '\0';
    ar_recv_acc_int_code.arr[0]            = '\0';
    bl_bill_type_short_desc.arr[0]          = '\0';

    bl_recv_acc_int_code.len               = 0;
    ar_recv_acc_int_code.len               = 0;
    bl_bill_type_short_desc.len             = 0;

     /* EXEC SQL FETCH BL_BILL_TYPE_CUR
	       INTO :bl_recv_acc_int_code,
		    :ar_recv_acc_int_code,
		    :bl_bill_type_short_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )873;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_recv_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&ar_recv_acc_int_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_bill_type_short_desc;
     sqlstm.sqhstl[2] = (unsigned int  )33;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_BILL_TYPE_CUR",0,"");
     if (NOT_FOUND)
	 err_mesg("Record not found in BL BILL TYPE",0,"");

     bl_recv_acc_int_code.arr[bl_recv_acc_int_code.len] = '\0';
     ar_recv_acc_int_code.arr[ar_recv_acc_int_code.len] = '\0';
     bl_bill_type_short_desc.arr[bl_bill_type_short_desc.len] = '\0';

     strcpy(recv_int_code.arr,bl_recv_acc_int_code.arr);
     recv_int_code.len = strlen(recv_int_code.arr);

/*	sprintf(string_var," recv int code  : %s",recv_int_code.arr);
	disp_message(ERR_MESG,string_var); */


     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )900;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&recv_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_GL_ACCOUNT_CUR",0,"");

     bl_rec_main_acc1_code.arr[0]             = '\0';
     bl_rec_main_acc2_code.arr[0]             = '\0';
     bl_rec_dept_code.arr[0]                  = '\0';
     bl_rec_subledger_group_code.arr[0]       = '\0';
     bl_rec_subledger_line_code.arr[0]        = '\0';
     bl_rec_product_group_code.arr[0]         = '\0';
     bl_rec_product_line_code.arr[0]          = '\0';

     bl_rec_main_acc1_code.len                = 0;
     bl_rec_main_acc2_code.len                = 0;
     bl_rec_dept_code.len                     = 0;
     bl_rec_subledger_group_code.len          = 0;
     bl_rec_subledger_line_code.len           = 0;
     bl_rec_product_group_code.len            = 0;
     bl_rec_product_line_code.len             = 0;

     /* EXEC SQL FETCH BL_GL_ACCOUNT_CUR 
	       INTO :bl_rec_main_acc1_code,
		    :bl_rec_main_acc2_code,
		    :bl_rec_dept_code,
		    :bl_rec_subledger_group_code,
		    :bl_rec_subledger_line_code,
		    :bl_rec_product_group_code,
		    :bl_rec_product_line_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )923;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_rec_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_rec_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_rec_dept_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_rec_subledger_group_code;
     sqlstm.sqhstl[3] = (unsigned int  )6;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_rec_subledger_line_code;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_rec_product_group_code;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_rec_product_line_code;
     sqlstm.sqhstl[6] = (unsigned int  )7;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_GL_ACCOUNT_CUR",0,"");

     if (NOT_FOUND)
	 err_mesg("Record not found in BL GL ACCOUNT",0,"");
 
     bl_rec_main_acc1_code.arr[bl_rec_main_acc1_code.len]              = '\0';
     bl_rec_main_acc2_code.arr[bl_rec_main_acc2_code.len]              = '\0';
     bl_rec_dept_code.arr[bl_rec_dept_code.len]                        = '\0';
     bl_rec_subledger_group_code.arr[bl_rec_subledger_group_code.len]  = '\0';
     bl_rec_subledger_line_code.arr[bl_rec_subledger_line_code.len]    = '\0';
     bl_rec_product_group_code.arr[bl_rec_product_group_code.len]      = '\0';
     bl_rec_product_line_code.arr[bl_rec_product_line_code.len]        = '\0';

     strcpy(recv_int_code.arr,ar_recv_acc_int_code.arr);
     recv_int_code.len = strlen(recv_int_code.arr);

/*	sprintf(string_var," recv int code  : %s",recv_int_code.arr);
	disp_message(ERR_MESG,string_var); */

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )966;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&recv_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_GL_ACCOUNT_CUR - 2",0,"");

     ar_rec_main_acc1_code.arr[0]             = '\0';
     ar_rec_main_acc2_code.arr[0]             = '\0';
     ar_rec_dept_code.arr[0]                  = '\0';
     ar_rec_subledger_group_code.arr[0]       = '\0';
     ar_rec_subledger_line_code.arr[0]        = '\0';
     ar_rec_product_group_code.arr[0]         = '\0';
     ar_rec_product_line_code.arr[0]          = '\0';

     ar_rec_main_acc1_code.len                = 0;
     ar_rec_main_acc2_code.len                = 0;
     ar_rec_dept_code.len                     = 0;
     ar_rec_subledger_group_code.len          = 0;
     ar_rec_subledger_line_code.len           = 0;
     ar_rec_product_group_code.len            = 0;
     ar_rec_product_line_code.len             = 0;

     /* EXEC SQL FETCH BL_GL_ACCOUNT_CUR
	       INTO :ar_rec_main_acc1_code,
		    :ar_rec_main_acc2_code,
		    :ar_rec_dept_code,
		    :ar_rec_subledger_group_code,
		    :ar_rec_subledger_line_code,
		    :ar_rec_product_group_code,
		    :ar_rec_product_line_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )989;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&ar_rec_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&ar_rec_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&ar_rec_dept_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&ar_rec_subledger_group_code;
     sqlstm.sqhstl[3] = (unsigned int  )6;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&ar_rec_subledger_line_code;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&ar_rec_product_group_code;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&ar_rec_product_line_code;
     sqlstm.sqhstl[6] = (unsigned int  )7;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_GL_ACCOUNT_CUR - 2",0,"");

     if (NOT_FOUND)
	 err_mesg("Record not found in BL GL ACCOUNT - 2",0,"");
 
     ar_rec_main_acc1_code.arr[ar_rec_main_acc1_code.len]             = '\0';
     ar_rec_main_acc2_code.arr[ar_rec_main_acc2_code.len]             = '\0';
     ar_rec_dept_code.arr[ar_rec_dept_code.len]                       = '\0';
     ar_rec_subledger_group_code.arr[ar_rec_subledger_group_code.len] = '\0';
     ar_rec_subledger_line_code.arr[ar_rec_subledger_line_code.len]   = '\0';
     ar_rec_product_group_code.arr[ar_rec_product_group_code.len]     = '\0';
     ar_rec_product_line_code.arr[ar_rec_product_line_code.len]       = '\0';

     /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0014;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1032;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_cust_code;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");

     bl_cust_pmnt_terms_code.arr[0]             = '\0';
     bl_cust_credit_limit = 0;

     bl_cust_pmnt_terms_code.len                = 0;

     /* EXEC SQL FETCH AR_CUSTOMER_CUR
	       INTO :bl_cust_pmnt_terms_code,
		        :bl_cust_credit_limit; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1051;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_cust_pmnt_terms_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_cust_credit_limit;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("FETCH failed on cursor AR_CUSTOMER",0,"");

     if (NOT_FOUND)
	 err_mesg("Record not found in AR CUSTOMER",0,"");

     bl_cust_pmnt_terms_code.arr[bl_cust_pmnt_terms_code.len] = '\0';
     bl_cust_pmnt_terms_code.arr[bl_cust_pmnt_terms_code.len] = '\0';




     /* EXEC SQL OPEN AR_PMNT_TERMS_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0015;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1074;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_cust_pmnt_terms_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("OPEN failed on cursor AR_PMNT_TERMS_CUR",0,"");

     ar_pmnt_cred_days_period.arr[0]           = '\0';
     ar_pmnt_settl_days_period.arr[0]          = '\0';
     ar_pmnt_settl_percent.arr[0]              = '\0';

     ar_pmnt_cred_days_period.len              = 0;
     ar_pmnt_settl_days_period.len             = 0;
     ar_pmnt_settl_percent.len                 = 0;

     /* EXEC SQL FETCH AR_PMNT_TERMS_CUR
	       INTO :ar_pmnt_cred_days_period,
		    :ar_pmnt_settl_days_period,
		    :ar_pmnt_settl_percent; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1097;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&ar_pmnt_cred_days_period;
     sqlstm.sqhstl[0] = (unsigned int  )6;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&ar_pmnt_settl_days_period;
     sqlstm.sqhstl[1] = (unsigned int  )6;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&ar_pmnt_settl_percent;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("FETCH failed on cursor AR_PMNT_TERMS_CUR",0,"");

     if (NOT_FOUND)
	 err_mesg("Record not found in AR PMNT TERMS",0,"");

     ar_pmnt_cred_days_period.arr[ar_pmnt_cred_days_period.len]       = '\0';
     ar_pmnt_settl_days_period.arr[ar_pmnt_settl_days_period.len]     = '\0';
     ar_pmnt_settl_percent.arr[ar_pmnt_settl_percent.len]             = '\0';

     if (bl_h_episode_type.arr[0] == 'I' || bl_h_episode_type.arr[0] == 'D')
     
     /*(bl_h_bill_trx_type_code.arr[0] == 'D' ||
	 bl_h_bill_trx_type_code.arr[0] == 'A' ||
	 bl_h_bill_trx_type_code.arr[0] == 'E' )*/
    {
	 /* EXEC SQL OPEN BL_EPI_FIN_DTLS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 67;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0016;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1124;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_h_episode_type;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_h_episode_id;
  sqlstm.sqhstl[1] = (unsigned int  )11;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 if (OERROR)
	     err_mesg("OPEN failed on cursor BL_EPI_FIN_DTLS_CUR",0,"");

	 bl_h_credit_doc_ref_desc.arr[0]             = '\0';
	 bl_h_credit_doc_ref_desc.len                = 0;

	 bl_h_policy_code.arr[0] = '\0';
	 bl_h_policy_code.len    = 0;


	 /* EXEC SQL FETCH BL_EPI_FIN_DTLS_CUR
		   INTO :bl_h_credit_doc_ref_desc,
				:bl_h_policy_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 67;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1151;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_h_credit_doc_ref_desc;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_h_policy_code;
  sqlstm.sqhstl[1] = (unsigned int  )28;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 if (OERROR)
	     err_mesg("FETCH failed on cursor BL_EPI_FIN_DTLS_CUR",0,"");

	 if (NOT_FOUND)
	     err_mesg("Record not found in BL EPISODE FIN DTLS",0,"");
    
	 bl_h_credit_doc_ref_desc.arr[bl_h_credit_doc_ref_desc.len] = '\0';
	 bl_h_policy_code.arr[bl_h_policy_code.len] = '\0';
    }
    else if  (bl_h_episode_type.arr[0] == 'E' || bl_h_episode_type.arr[0] == 'O' ) //(bl_h_bill_trx_type_code.arr[0] == 'O')
    {

	if (bl_h_episode_id.arr[0] != '\0')
	   {
	 /* EXEC SQL OPEN BL_VISIT_FIN_DTLS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 67;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0017;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1174;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_h_episode_type;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_h_episode_id;
  sqlstm.sqhstl[1] = (unsigned int  )11;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_h_visit_id;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bl_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 if (OERROR)
	     err_mesg("OPEN failed on cursor BL_VISIT_FIN_DTLS_CUR",0,"");

	 bl_h_credit_doc_ref_desc.arr[0]             = '\0';
	 bl_h_credit_doc_ref_desc.len                = 0;

	 bl_h_policy_code.arr[0] = '\0';
	 bl_h_policy_code.len    = 0;

	 /* EXEC SQL FETCH BL_VISIT_FIN_DTLS_CUR
		   INTO :bl_h_credit_doc_ref_desc,
				:bl_h_policy_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 67;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1205;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_h_credit_doc_ref_desc;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_h_policy_code;
  sqlstm.sqhstl[1] = (unsigned int  )28;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 if (OERROR)
	     err_mesg("FETCH failed on cursor BL_VISIT_FIN_DTLS_CUR",0,"");
    
	 if (NOT_FOUND)
	     err_mesg("Record not found in BL VISIT FIN DTLS",0,"");

	 bl_h_credit_doc_ref_desc.arr[bl_h_credit_doc_ref_desc.len] = '\0';
	 bl_h_policy_code.arr[bl_h_policy_code.len] = '\0';
	 
	 }

   }
    else if (bl_h_episode_type.arr[0] == 'R') //(bl_h_bill_trx_type_code.arr[0] == 'R')
    {
	 /* EXEC SQL OPEN BL_PATIENT_FIN_DTLS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 67;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0018;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1228;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_h_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 if (OERROR)
	     err_mesg("OPEN failed on cursor BL_PATIENT_FIN_DTLS_CUR",0,"");

	 bl_h_credit_doc_ref_desc.arr[0]             = '\0';
	 bl_h_credit_doc_ref_desc.len                = 0;

	 /* EXEC SQL FETCH BL_PATIENT_FIN_DTLS_CUR
		   INTO :bl_h_credit_doc_ref_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 67;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1247;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_h_credit_doc_ref_desc;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	 if (OERROR)
	     err_mesg("FETCH failed on cursor BL_PATIENT_FIN_DTLS_CUR",0,"");
    
	 if (NOT_FOUND)
	     err_mesg("Record not found in BL PATIENT FIN DTLS",0,"");

	 bl_h_credit_doc_ref_desc.arr[bl_h_credit_doc_ref_desc.len] = '\0';
   }
   else err_mesg("Bill trx type invalid",0,"");

}

/* This function has been added on 24/03/97 due to the new form input of
   debtor control account flag */  

select_acc_codes()
{
	if (nd_dr_cnt_acc.arr[0] == 'N')
	{                       
	   /* EXEC SQL  SELECT gl_main_acc1_code,
				gl_main_acc2_code
			 INTO   :ar_rec_main_acc1_code,
					:ar_rec_main_acc2_code
			 FROM   AR_CUSTOMER
			 WHERE  CUST_CODE = :bl_h_cust_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 67;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select gl_main_acc1_code ,gl_main_acc2_code into :b0,:b1 \
 from AR_CUSTOMER where CUST_CODE=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1266;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&ar_rec_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&ar_rec_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_h_cust_code;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   
			 
				 
	  if (OERROR)
			err_mesg("SELECT failed on table AR_CUSTOMER",0,"");

      if (NOT_FOUND)
			err_mesg("No Record found in AR_CUSTOMER",0,"");        
			
		ar_rec_main_acc1_code.arr[ar_rec_main_acc1_code.len] = '\0';
		ar_rec_main_acc2_code.arr[ar_rec_main_acc2_code.len] = '\0';
	    
	}                          
}  
  
insert_ar_rec()
{

strcpy(nd_new_doc_type_code.arr,bl_h_doc_type_code.arr);
nd_new_doc_type_code.len = strlen(nd_new_doc_type_code.arr);

strcpy(nd_new_doc_num.arr,bl_h_doc_num.arr);
nd_new_doc_num.len = strlen(nd_new_doc_num.arr);
strcpy(work_doc_num.arr,bl_h_doc_num.arr);
work_doc_num.len = strlen(work_doc_num.arr);

/*-- The narration modified by prefixing customer code along with the 
     current narration as per AH requirement VSK 01/05/1999 */

nd_narration.arr[0] = '\0';
nd_narration.len = 0;
sprintf(nd_narration.arr,"%-10s%-15s%-25s",bl_h_cust_code.arr,bl_bill_type_short_desc.arr,bl_h_policy_code.arr);
nd_narration.len = strlen(nd_narration.arr);
nd_narration.arr[nd_narration.len] = '\0'; 

     /* EXEC SQL INSERT INTO AR_INV_HDR
	       (
		 DOC_TYPE_CODE,
		 DOC_NUM,
		 LAST_LINE_NUM,
		 CUST_CODE,
		 DOC_DATE,
		 NARRATION,
		 BASE_DATE,
		 DUE_DATE,
		 GROSS_AMT,
		 PAYABLE_AMT,
		 DISCOUNT_AMT,
		 PMNT_TERMS_CODE,
		 SETTLEMENT_DATE,
		 SETTLEMENT_PERC,
		 CUST_REF,
		 EPISODE_TYPE,
		 EPISODE_ID,
		 VISIT_ID,
		 PATIENT_ID,
		 BILLING_GROUP,
		 BILL_DOC_TYPE_CODE,
		 BILL_NUM,
		 BILL_DATE,
		 DOCTOR_FEE_AMT,
		 MAIN_ACC1_CODE,
		 MAIN_ACC2_CODE,
		 SUBLEDGER_GROUP_CODE,
		 SUBLEDGER_LINE_CODE,
		 DEPT_CODE,
		 PRODUCT_GROUP_CODE,
		 PRODUCT_LINE_CODE,
		 POST_MONTH,
		 POST_YEAR,
		 ERROR_FLAG,
		 PRINT_FLAG,
		 POSTED_FLAG,
		 INTERFACE_FLAG,
		 MAIN_ACC1_CODE_NEW,
		 MAIN_ACC2_CODE_NEW,
		 SUBLEDGER_GROUP_CODE_NEW,
		 SUBLEDGER_LINE_CODE_NEW,
		 DEPT_CODE_NEW,
		 PRODUCT_GROUP_CODE_NEW,
		 PRODUCT_LINE_CODE_NEW,
		 BILL_TYPE_CODE,
		 ADDED_BY_ID,                    
		 MODIFIED_BY_ID,                 
		 ADDED_DATE,                     
		 MODIFIED_DATE,                 
		 OPERATING_FACILITY_ID,
		 ACC_ENTITY_CODE,
		 MODULE_ID,              
		 CONSOLIDATED_INV_YN,
		 FILE_NO     /o Rajesh o/ 
	       )
	      VALUES
	       (
		 :nd_new_doc_type_code,             /o DOC_TYPE_CODE o/
		 :nd_new_doc_num,                   /o DOC_NUM       o/
		 1,                                 /o LAST LINE NUM o/
		 :bl_h_cust_code,                   /o CUST CODE     o/
		 TO_DATE(NVL(:nd_inv_date,:bl_h_doc_date),'DD/MM/YYYY'),  /o DOC DATE      o/
//		 :bl_bill_type_short_desc,           /o NARRATION     o/
		 :nd_narration,						/o NARRATION o/
		 TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),                    /o BASE DATE     o/
		 to_date(:bl_h_doc_date,'DD/MM/YYYY') + :ar_pmnt_cred_days_period, /o DUE DATE o/
		 TRUNC(:bl_h_bill_tot_outst_amt,2) +        
		 TRUNC(:bl_h_man_disc_amt,2) +
		 TRUNC(:bl_h_serv_disc_amt,2) +
		 TRUNC(:bl_h_overall_disc_amt,2),            /o GROSS AMT     o/
		 TRUNC(:bl_h_bill_tot_outst_amt,2),          /o PAYABLE AMT   o/
		 TRUNC(:bl_h_man_disc_amt,2) +              
		 TRUNC(:bl_h_serv_disc_amt,2) +
		 TRUNC(:bl_h_overall_disc_amt,2),            /o DISCOUNT AMT  o/
		 :bl_cust_pmnt_terms_code,          /o PMNT TERMS    o/
		 to_date(:bl_h_doc_date,'DD/MM/YYYY') + :ar_pmnt_settl_days_period, /o STLMNT DATE o/
		 :ar_pmnt_settl_percent,           /o SETTLEMENT PERCo/
		 :bl_h_credit_doc_ref_desc,        /o CUST REF       o/
		 :bl_h_episode_type,               /o EPISODE TYPE   o/
		 :bl_h_episode_id,                 /o EPISODE ID     o/
		 :bl_h_visit_id,                   /o VISIT ID       o/
		 :bl_h_patient_id,                 /o PATIENT ID     o/
		 :bl_h_blng_grp_id,                /o BILLING GROUP  o/
		 :bl_h_doc_type_code,              /o BILL DOC TYPE CODE o/
		 :bl_h_doc_num,                    /o BILL NUM       o/
		 TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),                   /o BILL DATE      o/
         :bl_h_bill_drfee_tot_out_amt,   /o DOCTOR FEE AMT o/
		 :ar_rec_main_acc1_code,           /o -------------- o/
		 :ar_rec_main_acc2_code,           /o                o/
		 :ar_rec_subledger_group_code,     /o    POSTING     o/
		 :ar_rec_subledger_line_code,      /o                o/
		 :ar_rec_dept_code,                /o      A/C       o/
		 :ar_rec_product_group_code,       /o                o/
		 :ar_rec_product_line_code,        /o -------------- o/
         :bl_par_post_month,
          :bl_par_post_year,          
		 NULL,                             /o ERROR FLAG     o/
		 'N',                              /o PRINT FLAG     o/
		 NULL,                             /o POSTED FLAG    o/
		 NULL,                             /o INTERFACE FLAG o/
		 :ar_rec_main_acc1_code,           /o -------------- o/
		 :ar_rec_main_acc2_code,           /o                o/
		 :ar_rec_subledger_group_code,     /o    POSTING     o/
		 :ar_rec_subledger_line_code,      /o                o/
		 :ar_rec_dept_code,                /o      A/C       o/
		 :ar_rec_product_group_code,       /o                o/
		 :ar_rec_product_line_code,        /o -------------- o/
		 :bl_h_bill_type_code,              /o BILL TYPE CODE o/
		 USER,USER,
		 SYSDATE,SYSDATE,
		 :bl_facility_id,
		 :nd_acc_entity_code,
		 :nd_module_id,
		 :nd_inv_status,
		 :nd_bill_no  	   /o  Rajesh o/    ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "insert into AR_INV_HDR (DOC_TYPE_CODE,DOC_NUM,LAST_LINE_NUM,CUST_COD\
E,DOC_DATE,NARRATION,BASE_DATE,DUE_DATE,GROSS_AMT,PAYABLE_AMT,DISCOUNT_AMT,P\
MNT_TERMS_CODE,SETTLEMENT_DATE,SETTLEMENT_PERC,CUST_REF,EPISODE_TYPE,EPISODE\
_ID,VISIT_ID,PATIENT_ID,BILLING_GROUP,BILL_DOC_TYPE_CODE,BILL_NUM,BILL_DATE,\
DOCTOR_FEE_AMT,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_\
LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,POST_MONTH,POST_YEA\
R,ERROR_FLAG,PRINT_FLAG,POSTED_FLAG,INTERFACE_FLAG,MAIN_ACC1_CODE_NEW,MAIN_A\
CC2_CODE_NEW,SUBLEDGER_GROUP_CODE_NEW,SUBLEDGER_LINE_CODE_NEW,DEPT_CODE_NEW,\
PRODUCT_GROUP_CODE_NEW,PRODUCT_LINE_CODE_NEW,BILL_TYPE_CODE,ADDED_BY_ID,MODI\
FIED_BY_ID,ADDED_DATE,MODIFIED_DATE,OPERATING_FACILITY_ID,ACC_ENTITY_CODE,MO\
DULE_ID,CONSOLIDATED_INV_YN,FILE_NO) values (:b0,:b1,1,:b2,TO_DATE(NVL(:b3,:\
b4),'DD/MM/YYYY'),:b5,TO_DATE(:b4,'DD/MM/YYYY'),(to_date(:b4,'DD/MM/YYYY')+:\
b8),(((TRUNC(:b9,2)+TRUNC(:b10,2))+TRUNC(:b11,2))+TRUNC(:b12,2)),TRUNC(:b9,2\
),((TRUNC(:b10,2)+TRUNC(:b11,2))+TRUNC(:b12,");
     sqlstm.stmt = "2)),:b17,(to_date(:b4,'DD/MM/YYYY')+:b19),:b20,:b21,:b22\
,:b23,:b24,:b25,:b26,:b27,:b28,TO_DATE(:b4,'DD/MM/YYYY'),:b30,:b31,:b32,:b33,:\
b34,:b35,:b36,:b37,:b38,:b39,null ,'N',null ,null ,:b31,:b32,:b33,:b34,:b35,:b\
36,:b37,:b47,USER,USER,SYSDATE,SYSDATE,:b48,:b49,:b50,:b51,:b52)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1293;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_new_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_new_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_h_cust_code;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_inv_date;
     sqlstm.sqhstl[3] = (unsigned int  )15;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[4] = (unsigned int  )15;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_narration;
     sqlstm.sqhstl[5] = (unsigned int  )53;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[6] = (unsigned int  )15;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[7] = (unsigned int  )15;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&ar_pmnt_cred_days_period;
     sqlstm.sqhstl[8] = (unsigned int  )6;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_h_bill_tot_outst_amt;
     sqlstm.sqhstl[9] = (unsigned int  )25;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_h_man_disc_amt;
     sqlstm.sqhstl[10] = (unsigned int  )25;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_h_serv_disc_amt;
     sqlstm.sqhstl[11] = (unsigned int  )25;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_h_overall_disc_amt;
     sqlstm.sqhstl[12] = (unsigned int  )25;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_h_bill_tot_outst_amt;
     sqlstm.sqhstl[13] = (unsigned int  )25;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_h_man_disc_amt;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_h_serv_disc_amt;
     sqlstm.sqhstl[15] = (unsigned int  )25;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_h_overall_disc_amt;
     sqlstm.sqhstl[16] = (unsigned int  )25;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_cust_pmnt_terms_code;
     sqlstm.sqhstl[17] = (unsigned int  )5;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[18] = (unsigned int  )15;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&ar_pmnt_settl_days_period;
     sqlstm.sqhstl[19] = (unsigned int  )6;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&ar_pmnt_settl_percent;
     sqlstm.sqhstl[20] = (unsigned int  )11;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_h_credit_doc_ref_desc;
     sqlstm.sqhstl[21] = (unsigned int  )18;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_h_episode_type;
     sqlstm.sqhstl[22] = (unsigned int  )4;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_h_episode_id;
     sqlstm.sqhstl[23] = (unsigned int  )11;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_h_visit_id;
     sqlstm.sqhstl[24] = (unsigned int  )7;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&bl_h_patient_id;
     sqlstm.sqhstl[25] = (unsigned int  )23;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&bl_h_blng_grp_id;
     sqlstm.sqhstl[26] = (unsigned int  )7;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&bl_h_doc_type_code;
     sqlstm.sqhstl[27] = (unsigned int  )9;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&bl_h_doc_num;
     sqlstm.sqhstl[28] = (unsigned int  )11;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[29] = (unsigned int  )15;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&bl_h_bill_drfee_tot_out_amt;
     sqlstm.sqhstl[30] = (unsigned int  )25;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&ar_rec_main_acc1_code;
     sqlstm.sqhstl[31] = (unsigned int  )9;
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&ar_rec_main_acc2_code;
     sqlstm.sqhstl[32] = (unsigned int  )7;
     sqlstm.sqhsts[32] = (         int  )0;
     sqlstm.sqindv[32] = (         void  *)0;
     sqlstm.sqinds[32] = (         int  )0;
     sqlstm.sqharm[32] = (unsigned int  )0;
     sqlstm.sqadto[32] = (unsigned short )0;
     sqlstm.sqtdso[32] = (unsigned short )0;
     sqlstm.sqhstv[33] = (         void  *)&ar_rec_subledger_group_code;
     sqlstm.sqhstl[33] = (unsigned int  )6;
     sqlstm.sqhsts[33] = (         int  )0;
     sqlstm.sqindv[33] = (         void  *)0;
     sqlstm.sqinds[33] = (         int  )0;
     sqlstm.sqharm[33] = (unsigned int  )0;
     sqlstm.sqadto[33] = (unsigned short )0;
     sqlstm.sqtdso[33] = (unsigned short )0;
     sqlstm.sqhstv[34] = (         void  *)&ar_rec_subledger_line_code;
     sqlstm.sqhstl[34] = (unsigned int  )11;
     sqlstm.sqhsts[34] = (         int  )0;
     sqlstm.sqindv[34] = (         void  *)0;
     sqlstm.sqinds[34] = (         int  )0;
     sqlstm.sqharm[34] = (unsigned int  )0;
     sqlstm.sqadto[34] = (unsigned short )0;
     sqlstm.sqtdso[34] = (unsigned short )0;
     sqlstm.sqhstv[35] = (         void  *)&ar_rec_dept_code;
     sqlstm.sqhstl[35] = (unsigned int  )13;
     sqlstm.sqhsts[35] = (         int  )0;
     sqlstm.sqindv[35] = (         void  *)0;
     sqlstm.sqinds[35] = (         int  )0;
     sqlstm.sqharm[35] = (unsigned int  )0;
     sqlstm.sqadto[35] = (unsigned short )0;
     sqlstm.sqtdso[35] = (unsigned short )0;
     sqlstm.sqhstv[36] = (         void  *)&ar_rec_product_group_code;
     sqlstm.sqhstl[36] = (unsigned int  )6;
     sqlstm.sqhsts[36] = (         int  )0;
     sqlstm.sqindv[36] = (         void  *)0;
     sqlstm.sqinds[36] = (         int  )0;
     sqlstm.sqharm[36] = (unsigned int  )0;
     sqlstm.sqadto[36] = (unsigned short )0;
     sqlstm.sqtdso[36] = (unsigned short )0;
     sqlstm.sqhstv[37] = (         void  *)&ar_rec_product_line_code;
     sqlstm.sqhstl[37] = (unsigned int  )7;
     sqlstm.sqhsts[37] = (         int  )0;
     sqlstm.sqindv[37] = (         void  *)0;
     sqlstm.sqinds[37] = (         int  )0;
     sqlstm.sqharm[37] = (unsigned int  )0;
     sqlstm.sqadto[37] = (unsigned short )0;
     sqlstm.sqtdso[37] = (unsigned short )0;
     sqlstm.sqhstv[38] = (         void  *)&bl_par_post_month;
     sqlstm.sqhstl[38] = (unsigned int  )5;
     sqlstm.sqhsts[38] = (         int  )0;
     sqlstm.sqindv[38] = (         void  *)0;
     sqlstm.sqinds[38] = (         int  )0;
     sqlstm.sqharm[38] = (unsigned int  )0;
     sqlstm.sqadto[38] = (unsigned short )0;
     sqlstm.sqtdso[38] = (unsigned short )0;
     sqlstm.sqhstv[39] = (         void  *)&bl_par_post_year;
     sqlstm.sqhstl[39] = (unsigned int  )7;
     sqlstm.sqhsts[39] = (         int  )0;
     sqlstm.sqindv[39] = (         void  *)0;
     sqlstm.sqinds[39] = (         int  )0;
     sqlstm.sqharm[39] = (unsigned int  )0;
     sqlstm.sqadto[39] = (unsigned short )0;
     sqlstm.sqtdso[39] = (unsigned short )0;
     sqlstm.sqhstv[40] = (         void  *)&ar_rec_main_acc1_code;
     sqlstm.sqhstl[40] = (unsigned int  )9;
     sqlstm.sqhsts[40] = (         int  )0;
     sqlstm.sqindv[40] = (         void  *)0;
     sqlstm.sqinds[40] = (         int  )0;
     sqlstm.sqharm[40] = (unsigned int  )0;
     sqlstm.sqadto[40] = (unsigned short )0;
     sqlstm.sqtdso[40] = (unsigned short )0;
     sqlstm.sqhstv[41] = (         void  *)&ar_rec_main_acc2_code;
     sqlstm.sqhstl[41] = (unsigned int  )7;
     sqlstm.sqhsts[41] = (         int  )0;
     sqlstm.sqindv[41] = (         void  *)0;
     sqlstm.sqinds[41] = (         int  )0;
     sqlstm.sqharm[41] = (unsigned int  )0;
     sqlstm.sqadto[41] = (unsigned short )0;
     sqlstm.sqtdso[41] = (unsigned short )0;
     sqlstm.sqhstv[42] = (         void  *)&ar_rec_subledger_group_code;
     sqlstm.sqhstl[42] = (unsigned int  )6;
     sqlstm.sqhsts[42] = (         int  )0;
     sqlstm.sqindv[42] = (         void  *)0;
     sqlstm.sqinds[42] = (         int  )0;
     sqlstm.sqharm[42] = (unsigned int  )0;
     sqlstm.sqadto[42] = (unsigned short )0;
     sqlstm.sqtdso[42] = (unsigned short )0;
     sqlstm.sqhstv[43] = (         void  *)&ar_rec_subledger_line_code;
     sqlstm.sqhstl[43] = (unsigned int  )11;
     sqlstm.sqhsts[43] = (         int  )0;
     sqlstm.sqindv[43] = (         void  *)0;
     sqlstm.sqinds[43] = (         int  )0;
     sqlstm.sqharm[43] = (unsigned int  )0;
     sqlstm.sqadto[43] = (unsigned short )0;
     sqlstm.sqtdso[43] = (unsigned short )0;
     sqlstm.sqhstv[44] = (         void  *)&ar_rec_dept_code;
     sqlstm.sqhstl[44] = (unsigned int  )13;
     sqlstm.sqhsts[44] = (         int  )0;
     sqlstm.sqindv[44] = (         void  *)0;
     sqlstm.sqinds[44] = (         int  )0;
     sqlstm.sqharm[44] = (unsigned int  )0;
     sqlstm.sqadto[44] = (unsigned short )0;
     sqlstm.sqtdso[44] = (unsigned short )0;
     sqlstm.sqhstv[45] = (         void  *)&ar_rec_product_group_code;
     sqlstm.sqhstl[45] = (unsigned int  )6;
     sqlstm.sqhsts[45] = (         int  )0;
     sqlstm.sqindv[45] = (         void  *)0;
     sqlstm.sqinds[45] = (         int  )0;
     sqlstm.sqharm[45] = (unsigned int  )0;
     sqlstm.sqadto[45] = (unsigned short )0;
     sqlstm.sqtdso[45] = (unsigned short )0;
     sqlstm.sqhstv[46] = (         void  *)&ar_rec_product_line_code;
     sqlstm.sqhstl[46] = (unsigned int  )7;
     sqlstm.sqhsts[46] = (         int  )0;
     sqlstm.sqindv[46] = (         void  *)0;
     sqlstm.sqinds[46] = (         int  )0;
     sqlstm.sqharm[46] = (unsigned int  )0;
     sqlstm.sqadto[46] = (unsigned short )0;
     sqlstm.sqtdso[46] = (unsigned short )0;
     sqlstm.sqhstv[47] = (         void  *)&bl_h_bill_type_code;
     sqlstm.sqhstl[47] = (unsigned int  )5;
     sqlstm.sqhsts[47] = (         int  )0;
     sqlstm.sqindv[47] = (         void  *)0;
     sqlstm.sqinds[47] = (         int  )0;
     sqlstm.sqharm[47] = (unsigned int  )0;
     sqlstm.sqadto[47] = (unsigned short )0;
     sqlstm.sqtdso[47] = (unsigned short )0;
     sqlstm.sqhstv[48] = (         void  *)&bl_facility_id;
     sqlstm.sqhstl[48] = (unsigned int  )5;
     sqlstm.sqhsts[48] = (         int  )0;
     sqlstm.sqindv[48] = (         void  *)0;
     sqlstm.sqinds[48] = (         int  )0;
     sqlstm.sqharm[48] = (unsigned int  )0;
     sqlstm.sqadto[48] = (unsigned short )0;
     sqlstm.sqtdso[48] = (unsigned short )0;
     sqlstm.sqhstv[49] = (         void  *)&nd_acc_entity_code;
     sqlstm.sqhstl[49] = (unsigned int  )7;
     sqlstm.sqhsts[49] = (         int  )0;
     sqlstm.sqindv[49] = (         void  *)0;
     sqlstm.sqinds[49] = (         int  )0;
     sqlstm.sqharm[49] = (unsigned int  )0;
     sqlstm.sqadto[49] = (unsigned short )0;
     sqlstm.sqtdso[49] = (unsigned short )0;
     sqlstm.sqhstv[50] = (         void  *)&nd_module_id;
     sqlstm.sqhstl[50] = (unsigned int  )5;
     sqlstm.sqhsts[50] = (         int  )0;
     sqlstm.sqindv[50] = (         void  *)0;
     sqlstm.sqinds[50] = (         int  )0;
     sqlstm.sqharm[50] = (unsigned int  )0;
     sqlstm.sqadto[50] = (unsigned short )0;
     sqlstm.sqtdso[50] = (unsigned short )0;
     sqlstm.sqhstv[51] = (         void  *)&nd_inv_status;
     sqlstm.sqhstl[51] = (unsigned int  )4;
     sqlstm.sqhsts[51] = (         int  )0;
     sqlstm.sqindv[51] = (         void  *)0;
     sqlstm.sqinds[51] = (         int  )0;
     sqlstm.sqharm[51] = (unsigned int  )0;
     sqlstm.sqadto[51] = (unsigned short )0;
     sqlstm.sqtdso[51] = (unsigned short )0;
     sqlstm.sqhstv[52] = (         void  *)&nd_bill_no;
     sqlstm.sqhstl[52] = (unsigned int  )23;
     sqlstm.sqhsts[52] = (         int  )0;
     sqlstm.sqindv[52] = (         void  *)0;
     sqlstm.sqinds[52] = (         int  )0;
     sqlstm.sqharm[52] = (unsigned int  )0;
     sqlstm.sqadto[52] = (unsigned short )0;
     sqlstm.sqtdso[52] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     if (sqlca.sqlcode == -1438)
     {
	disp_message(ORA_MESG,"Check The doc num - (Max is 8 digits)");
     }
     if (OERROR)
	 err_mesg("INSERT failed on table AR_INV_HDR",0,"");

     /* EXEC SQL INSERT INTO AR_INV_LINE
	       (
		 DOC_TYPE_CODE,
		 DOC_NUM,
		 LINE_NUM,
		 MAIN_ACC1_CODE,
		 MAIN_ACC2_CODE,
		 SUBLEDGER_GROUP_CODE,
		 SUBLEDGER_LINE_CODE,
		 DEPT_CODE,
		 PRODUCT_GROUP_CODE,
		 PRODUCT_LINE_CODE,
		 AMT_LOCAL,
		 NARRATION,
		 MAIN_ACC1_CODE_NEW,
		 MAIN_ACC2_CODE_NEW,
		 SUBLEDGER_GROUP_CODE_NEW,
		 SUBLEDGER_LINE_CODE_NEW,
		 DEPT_CODE_NEW,
		 PRODUCT_GROUP_CODE_NEW,
		 PRODUCT_LINE_CODE_NEW,
		 ACC_ENTITY_CODE
	       )
	     VALUES
	       (
		 :nd_new_doc_type_code,             /o DOC_TYPE_CODE  o/
		 :nd_new_doc_num,                   /o DOC_NUM        o/
		 1,                                 /o LINE NUM       o/
		 :bl_rec_main_acc1_code,            /o -------------- o/
		 :bl_rec_main_acc2_code,            /o                o/
		 :bl_rec_subledger_group_code,      /o    POSTING     o/
		 :bl_rec_subledger_line_code,       /o                o/
		 :bl_rec_dept_code,                 /o      A/C       o/
		 :bl_rec_product_group_code,        /o                o/
		 :bl_rec_product_line_code,         /o -------------- o/
		 TRUNC(:bl_h_bill_tot_outst_amt,2),          /o AMT LOCAL      o/
//		 :bl_bill_type_short_desc,          /o NARRATION      o/
		 :nd_narration,						/o NARRATION	  o/
		 :bl_rec_main_acc1_code,            /o -------------- o/
		 :bl_rec_main_acc2_code,            /o                o/
		 :bl_rec_subledger_group_code,      /o    POSTING     o/
		 :bl_rec_subledger_line_code,       /o                o/
		 :bl_rec_dept_code,                 /o      A/C       o/
		 :bl_rec_product_group_code,        /o                o/
		 :bl_rec_product_line_code,          /o -------------- o/
		 :nd_acc_entity_code
	       ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 67;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "insert into AR_INV_LINE (DOC_TYPE_CODE,DOC_NUM,LINE_NUM,\
MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CO\
DE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,AMT_LOCAL,NARRATION,MAIN_ACC1_CODE_NEW\
,MAIN_ACC2_CODE_NEW,SUBLEDGER_GROUP_CODE_NEW,SUBLEDGER_LINE_CODE_NEW,DEPT_CODE\
_NEW,PRODUCT_GROUP_CODE_NEW,PRODUCT_LINE_CODE_NEW,ACC_ENTITY_CODE) values (:b0\
,:b1,1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,TRUNC(:b9,2),:b10,:b2,:b3,:b4,:b5,:b6,:b7,:\
b8,:b18)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1520;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_new_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_new_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_rec_main_acc1_code;
     sqlstm.sqhstl[2] = (unsigned int  )9;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_rec_main_acc2_code;
     sqlstm.sqhstl[3] = (unsigned int  )7;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_rec_subledger_group_code;
     sqlstm.sqhstl[4] = (unsigned int  )6;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_rec_subledger_line_code;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_rec_dept_code;
     sqlstm.sqhstl[6] = (unsigned int  )13;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_rec_product_group_code;
     sqlstm.sqhstl[7] = (unsigned int  )6;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_rec_product_line_code;
     sqlstm.sqhstl[8] = (unsigned int  )7;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_h_bill_tot_outst_amt;
     sqlstm.sqhstl[9] = (unsigned int  )25;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_narration;
     sqlstm.sqhstl[10] = (unsigned int  )53;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_rec_main_acc1_code;
     sqlstm.sqhstl[11] = (unsigned int  )9;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_rec_main_acc2_code;
     sqlstm.sqhstl[12] = (unsigned int  )7;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_rec_subledger_group_code;
     sqlstm.sqhstl[13] = (unsigned int  )6;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_rec_subledger_line_code;
     sqlstm.sqhstl[14] = (unsigned int  )11;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_rec_dept_code;
     sqlstm.sqhstl[15] = (unsigned int  )13;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_rec_product_group_code;
     sqlstm.sqhstl[16] = (unsigned int  )6;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_rec_product_line_code;
     sqlstm.sqhstl[17] = (unsigned int  )7;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&nd_acc_entity_code;
     sqlstm.sqhstl[18] = (unsigned int  )7;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("INSERT failed on table AR_INV_LINE",0,"");

	   nd_ar_outstand_amt = 0;

	/* EXEC SQL SELECT OUTSTANDING_AMT INTO :nd_ar_outstand_amt
	   FROM AR_CUST_OUTST_VW
	  WHERE CUST_CODE = :bl_h_cust_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 67;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OUTSTANDING_AMT into :b0  from AR_CUST_OUTST_VW where\
 CUST_CODE=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1611;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_ar_outstand_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_h_cust_code;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
	 err_mesg("SELECT failed on table AR_CUST_OUTST_VW ",0,"");

	if (NOT_FOUND)
		 nd_ar_outstand_amt = 0;

    if (( nd_ar_outstand_amt > bl_cust_credit_limit ) && (bl_cust_credit_limit > 0))
	   {
	   sprintf(credit_warn,"Outstanding Amount exceeding the Credit Limit for %s",bl_h_cust_code.arr);
	   disp_message(ERR_MESG,credit_warn );  
	   }
 	 	  
    
  
}

/*Modification on 18/05/1998 Start  */

insert_cn_rec()
{
    strcpy(nd_new_doc_type_code.arr,nd_inv_doc_type_code.arr);
    nd_new_doc_type_code.len  = strlen(nd_new_doc_type_code.arr);

    /* EXEC SQL INSERT INTO AR_CN_HDR
	     ( DOC_TYPE_CODE,
	       DOC_NUM,
	       CUST_CODE,
	       DOC_DATE,
	       DOC_AMT,
	       POST_MONTH,
	       POST_YEAR,
               ADDED_BY_ID,                    
	       MODIFIED_BY_ID,                 
	       ADDED_DATE,                     
	       MODIFIED_DATE,
	       ACC_ENTITY_CODE,
		   FILE_NO          )
	       VALUES
	     ( :nd_new_doc_type_code,
	       :nd_inv_start_doc_num,
	       :bl_h_cust_code,
	       TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),
	       :bl_outst_amt*-1,
	       :bl_par_post_month,
           :bl_par_post_year ,
		    USER,
		    USER,
		    SYSDATE,
		    SYSDATE,
		   :nd_acc_entity_code,
		   :nd_bill_no  	   /o  Rajesh o/ ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 67;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into AR_CN_HDR (DOC_TYPE_CODE,DOC_NUM,CUST_CODE,DO\
C_DATE,DOC_AMT,POST_MONTH,POST_YEAR,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODI\
FIED_DATE,ACC_ENTITY_CODE,FILE_NO) values (:b0,:b1,:b2,TO_DATE(:b3,'DD/MM/YYYY\
'),(:b4* (-1)),:b5,:b6,USER,USER,SYSDATE,SYSDATE,:b7,:b8)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1634;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_new_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_inv_start_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_h_cust_code;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_h_doc_date;
    sqlstm.sqhstl[3] = (unsigned int  )15;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_outst_amt;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_par_post_month;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_par_post_year;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_acc_entity_code;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_bill_no;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




     if (sqlca.sqlcode == -1438)
     {
	disp_message(ORA_MESG,"Check The doc num - (Max is 8 digits)");
     }

     if (OERROR)
	 err_mesg("INSERT failed on table AR_CN_HDR",0,"");


      /* EXEC SQL INSERT INTO AR_CN_INV_HDR
	     ( DOC_TYPE_CODE,
	       DOC_NUM,
	       ORG_DOC_TYPE_CODE,
	       ORG_DOC_NUM,
	       LAST_LINE_NUM,
	       CUST_CODE,
	       DOC_AMT,
	       CUST_REF,
	       MAIN_ACC1_CODE,
	       MAIN_ACC2_CODE,
	       SUBLEDGER_GROUP_CODE,
	       SUBLEDGER_LINE_CODE,
	       DEPT_CODE,
	       PRODUCT_GROUP_CODE,
	       PRODUCT_LINE_CODE,
	       POST_MONTH,
	       POST_YEAR,
	       MAIN_ACC1_CODE_NEW,
	       MAIN_ACC2_CODE_NEW,
	       SUBLEDGER_GROUP_CODE_NEW,
	       SUBLEDGER_LINE_CODE_NEW,
	       DEPT_CODE_NEW,
	       PRODUCT_GROUP_CODE_NEW,
	       PRODUCT_LINE_CODE_NEW,
	       PATIENT_ID,
		   BILLING_GROUP,
		   BILL_DOC_TYPE_CODE,
		   BILL_NUM,
		   BILL_DATE,
		   DOCTOR_FEE_AMT,
		   BILL_TYPE_CODE,
	/o----- Added by Venkat on 25/12/1999 -----o/	   
		  EPISODE_TYPE,
		  EPISODE_ID,
		  VISIT_ID,
		ACC_ENTITY_CODE
	     )
	      VALUES
	     (
	      :nd_new_doc_type_code,
	      :nd_inv_start_doc_num,
	      :nd_new_doc_type_code,
	      :nd_inv_start_doc_num,
	      1,
	      :bl_h_cust_code,
	      :bl_outst_amt*-1,
	      :bl_h_credit_doc_ref_desc,
	      :ar_rec_main_acc1_code,           
	      :ar_rec_main_acc2_code,           
	      :ar_rec_subledger_group_code,     
	      :ar_rec_subledger_line_code,      
	      :ar_rec_dept_code,                
	      :ar_rec_product_group_code,       
	      :ar_rec_product_line_code,
              :bl_par_post_month,
                :bl_par_post_year,   
	      :ar_rec_main_acc1_code,           
	      :ar_rec_main_acc2_code,           
	      :ar_rec_subledger_group_code,     
	      :ar_rec_subledger_line_code,      
	      :ar_rec_dept_code,                
	      :ar_rec_product_group_code,       
	      :ar_rec_product_line_code,
	      :bl_h_patient_id,                 /o PATIENT ID     o/
		  :bl_h_blng_grp_id,                /o BILLING GROUP  o/
		  :bl_h_doc_type_code,              /o BILL DOC TYPE CODE o/
		  :bl_h_doc_num,                    /o BILL NUM       o/
		  TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),  /o BILL DATE      o/
		  :bl_drfee_outst_amt*-1,   /o DOCTOR FEE AMT o/
		  :bl_h_bill_type_code ,             /o BILL TYPE CODE o/
 /o---- Added by Venkat on 25/12/1999 -----o/	  
		 :bl_h_episode_type,               /o EPISODE TYPE   o/
		 :bl_h_episode_id,                 /o EPISODE ID     o/
		 :bl_h_visit_id,                   /o VISIT ID       o/
		 :nd_acc_entity_code
	      ); */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 67;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "insert into AR_CN_INV_HDR (DOC_TYPE_CODE,DOC_NUM,ORG_DO\
C_TYPE_CODE,ORG_DOC_NUM,LAST_LINE_NUM,CUST_CODE,DOC_AMT,CUST_REF,MAIN_ACC1_COD\
E,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GR\
OUP_CODE,PRODUCT_LINE_CODE,POST_MONTH,POST_YEAR,MAIN_ACC1_CODE_NEW,MAIN_ACC2_C\
ODE_NEW,SUBLEDGER_GROUP_CODE_NEW,SUBLEDGER_LINE_CODE_NEW,DEPT_CODE_NEW,PRODUCT\
_GROUP_CODE_NEW,PRODUCT_LINE_CODE_NEW,PATIENT_ID,BILLING_GROUP,BILL_DOC_TYPE_C\
ODE,BILL_NUM,BILL_DATE,DOCTOR_FEE_AMT,BILL_TYPE_CODE,EPISODE_TYPE,EPISODE_ID,V\
ISIT_ID,ACC_ENTITY_CODE) values (:b0,:b1,:b0,:b1,1,:b4,(:b5* (-1)),:b6,:b7,:b8\
,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b23,:b24,:\
b25,:b26,TO_DATE(:b27,'DD/MM/YYYY'),(:b28* (-1)),:b29,:b30,:b31,:b32,:b33)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1685;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_new_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_inv_start_doc_num;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_new_doc_type_code;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_inv_start_doc_num;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_h_cust_code;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_outst_amt;
      sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_h_credit_doc_ref_desc;
      sqlstm.sqhstl[6] = (unsigned int  )18;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&ar_rec_main_acc1_code;
      sqlstm.sqhstl[7] = (unsigned int  )9;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&ar_rec_main_acc2_code;
      sqlstm.sqhstl[8] = (unsigned int  )7;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&ar_rec_subledger_group_code;
      sqlstm.sqhstl[9] = (unsigned int  )6;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&ar_rec_subledger_line_code;
      sqlstm.sqhstl[10] = (unsigned int  )11;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&ar_rec_dept_code;
      sqlstm.sqhstl[11] = (unsigned int  )13;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&ar_rec_product_group_code;
      sqlstm.sqhstl[12] = (unsigned int  )6;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&ar_rec_product_line_code;
      sqlstm.sqhstl[13] = (unsigned int  )7;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&bl_par_post_month;
      sqlstm.sqhstl[14] = (unsigned int  )5;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&bl_par_post_year;
      sqlstm.sqhstl[15] = (unsigned int  )7;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&ar_rec_main_acc1_code;
      sqlstm.sqhstl[16] = (unsigned int  )9;
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&ar_rec_main_acc2_code;
      sqlstm.sqhstl[17] = (unsigned int  )7;
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&ar_rec_subledger_group_code;
      sqlstm.sqhstl[18] = (unsigned int  )6;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&ar_rec_subledger_line_code;
      sqlstm.sqhstl[19] = (unsigned int  )11;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqhstv[20] = (         void  *)&ar_rec_dept_code;
      sqlstm.sqhstl[20] = (unsigned int  )13;
      sqlstm.sqhsts[20] = (         int  )0;
      sqlstm.sqindv[20] = (         void  *)0;
      sqlstm.sqinds[20] = (         int  )0;
      sqlstm.sqharm[20] = (unsigned int  )0;
      sqlstm.sqadto[20] = (unsigned short )0;
      sqlstm.sqtdso[20] = (unsigned short )0;
      sqlstm.sqhstv[21] = (         void  *)&ar_rec_product_group_code;
      sqlstm.sqhstl[21] = (unsigned int  )6;
      sqlstm.sqhsts[21] = (         int  )0;
      sqlstm.sqindv[21] = (         void  *)0;
      sqlstm.sqinds[21] = (         int  )0;
      sqlstm.sqharm[21] = (unsigned int  )0;
      sqlstm.sqadto[21] = (unsigned short )0;
      sqlstm.sqtdso[21] = (unsigned short )0;
      sqlstm.sqhstv[22] = (         void  *)&ar_rec_product_line_code;
      sqlstm.sqhstl[22] = (unsigned int  )7;
      sqlstm.sqhsts[22] = (         int  )0;
      sqlstm.sqindv[22] = (         void  *)0;
      sqlstm.sqinds[22] = (         int  )0;
      sqlstm.sqharm[22] = (unsigned int  )0;
      sqlstm.sqadto[22] = (unsigned short )0;
      sqlstm.sqtdso[22] = (unsigned short )0;
      sqlstm.sqhstv[23] = (         void  *)&bl_h_patient_id;
      sqlstm.sqhstl[23] = (unsigned int  )23;
      sqlstm.sqhsts[23] = (         int  )0;
      sqlstm.sqindv[23] = (         void  *)0;
      sqlstm.sqinds[23] = (         int  )0;
      sqlstm.sqharm[23] = (unsigned int  )0;
      sqlstm.sqadto[23] = (unsigned short )0;
      sqlstm.sqtdso[23] = (unsigned short )0;
      sqlstm.sqhstv[24] = (         void  *)&bl_h_blng_grp_id;
      sqlstm.sqhstl[24] = (unsigned int  )7;
      sqlstm.sqhsts[24] = (         int  )0;
      sqlstm.sqindv[24] = (         void  *)0;
      sqlstm.sqinds[24] = (         int  )0;
      sqlstm.sqharm[24] = (unsigned int  )0;
      sqlstm.sqadto[24] = (unsigned short )0;
      sqlstm.sqtdso[24] = (unsigned short )0;
      sqlstm.sqhstv[25] = (         void  *)&bl_h_doc_type_code;
      sqlstm.sqhstl[25] = (unsigned int  )9;
      sqlstm.sqhsts[25] = (         int  )0;
      sqlstm.sqindv[25] = (         void  *)0;
      sqlstm.sqinds[25] = (         int  )0;
      sqlstm.sqharm[25] = (unsigned int  )0;
      sqlstm.sqadto[25] = (unsigned short )0;
      sqlstm.sqtdso[25] = (unsigned short )0;
      sqlstm.sqhstv[26] = (         void  *)&bl_h_doc_num;
      sqlstm.sqhstl[26] = (unsigned int  )11;
      sqlstm.sqhsts[26] = (         int  )0;
      sqlstm.sqindv[26] = (         void  *)0;
      sqlstm.sqinds[26] = (         int  )0;
      sqlstm.sqharm[26] = (unsigned int  )0;
      sqlstm.sqadto[26] = (unsigned short )0;
      sqlstm.sqtdso[26] = (unsigned short )0;
      sqlstm.sqhstv[27] = (         void  *)&bl_h_doc_date;
      sqlstm.sqhstl[27] = (unsigned int  )15;
      sqlstm.sqhsts[27] = (         int  )0;
      sqlstm.sqindv[27] = (         void  *)0;
      sqlstm.sqinds[27] = (         int  )0;
      sqlstm.sqharm[27] = (unsigned int  )0;
      sqlstm.sqadto[27] = (unsigned short )0;
      sqlstm.sqtdso[27] = (unsigned short )0;
      sqlstm.sqhstv[28] = (         void  *)&bl_drfee_outst_amt;
      sqlstm.sqhstl[28] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[28] = (         int  )0;
      sqlstm.sqindv[28] = (         void  *)0;
      sqlstm.sqinds[28] = (         int  )0;
      sqlstm.sqharm[28] = (unsigned int  )0;
      sqlstm.sqadto[28] = (unsigned short )0;
      sqlstm.sqtdso[28] = (unsigned short )0;
      sqlstm.sqhstv[29] = (         void  *)&bl_h_bill_type_code;
      sqlstm.sqhstl[29] = (unsigned int  )5;
      sqlstm.sqhsts[29] = (         int  )0;
      sqlstm.sqindv[29] = (         void  *)0;
      sqlstm.sqinds[29] = (         int  )0;
      sqlstm.sqharm[29] = (unsigned int  )0;
      sqlstm.sqadto[29] = (unsigned short )0;
      sqlstm.sqtdso[29] = (unsigned short )0;
      sqlstm.sqhstv[30] = (         void  *)&bl_h_episode_type;
      sqlstm.sqhstl[30] = (unsigned int  )4;
      sqlstm.sqhsts[30] = (         int  )0;
      sqlstm.sqindv[30] = (         void  *)0;
      sqlstm.sqinds[30] = (         int  )0;
      sqlstm.sqharm[30] = (unsigned int  )0;
      sqlstm.sqadto[30] = (unsigned short )0;
      sqlstm.sqtdso[30] = (unsigned short )0;
      sqlstm.sqhstv[31] = (         void  *)&bl_h_episode_id;
      sqlstm.sqhstl[31] = (unsigned int  )11;
      sqlstm.sqhsts[31] = (         int  )0;
      sqlstm.sqindv[31] = (         void  *)0;
      sqlstm.sqinds[31] = (         int  )0;
      sqlstm.sqharm[31] = (unsigned int  )0;
      sqlstm.sqadto[31] = (unsigned short )0;
      sqlstm.sqtdso[31] = (unsigned short )0;
      sqlstm.sqhstv[32] = (         void  *)&bl_h_visit_id;
      sqlstm.sqhstl[32] = (unsigned int  )7;
      sqlstm.sqhsts[32] = (         int  )0;
      sqlstm.sqindv[32] = (         void  *)0;
      sqlstm.sqinds[32] = (         int  )0;
      sqlstm.sqharm[32] = (unsigned int  )0;
      sqlstm.sqadto[32] = (unsigned short )0;
      sqlstm.sqtdso[32] = (unsigned short )0;
      sqlstm.sqhstv[33] = (         void  *)&nd_acc_entity_code;
      sqlstm.sqhstl[33] = (unsigned int  )7;
      sqlstm.sqhsts[33] = (         int  )0;
      sqlstm.sqindv[33] = (         void  *)0;
      sqlstm.sqinds[33] = (         int  )0;
      sqlstm.sqharm[33] = (unsigned int  )0;
      sqlstm.sqadto[33] = (unsigned short )0;
      sqlstm.sqtdso[33] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (sqlca.sqlcode == -1438)
     {
	disp_message(ORA_MESG,"Check The doc num - (Max is 8 digits)");
     }

     if (OERROR)
	 err_mesg("INSERT failed on table AR_CN_INV_HDR",0,"");

      /* EXEC SQL INSERT INTO AR_CN_LINE
	     ( DOC_TYPE_CODE,
	       DOC_NUM,
	       ORG_DOC_TYPE_CODE,
	       ORG_DOC_NUM,      
	       LINE_NUM,
	       MAIN_ACC1_CODE,
	       MAIN_ACC2_CODE,
	       SUBLEDGER_GROUP_CODE,
	       SUBLEDGER_LINE_CODE,
	       DEPT_CODE,
	       PRODUCT_GROUP_CODE,
	       PRODUCT_LINE_CODE,
	       AMOUNT,
	       MAIN_ACC1_CODE_NEW,
	       MAIN_ACC2_CODE_NEW,
	       SUBLEDGER_GROUP_CODE_NEW,
	       SUBLEDGER_LINE_CODE_NEW,
	       DEPT_CODE_NEW,
	       PRODUCT_GROUP_CODE_NEW,
	       PRODUCT_LINE_CODE_NEW,
	       ACC_ENTITY_CODE
	     )
	      VALUES
	     (
	      :nd_new_doc_type_code,
	      :nd_inv_start_doc_num,
	      :nd_new_doc_type_code,
	      :nd_inv_start_doc_num,
	      1,
	      :bl_rec_main_acc1_code,
	      :bl_rec_main_acc2_code,
	      :bl_rec_subledger_group_code,
	      :bl_rec_subledger_line_code,
	      :bl_rec_dept_code,
	      :bl_rec_product_group_code,
	      :bl_rec_product_line_code,
	      :bl_outst_amt*-1,
	      :bl_rec_main_acc1_code,
	      :bl_rec_main_acc2_code,
	      :bl_rec_subledger_group_code,
	      :bl_rec_subledger_line_code,
	      :bl_rec_dept_code,
	      :bl_rec_product_group_code,
	      :bl_rec_product_line_code,
	      :nd_acc_entity_code
	      ); */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 67;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "insert into AR_CN_LINE (DOC_TYPE_CODE,DOC_NUM,ORG_DOC_T\
YPE_CODE,ORG_DOC_NUM,LINE_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CO\
DE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,AMOUNT,M\
AIN_ACC1_CODE_NEW,MAIN_ACC2_CODE_NEW,SUBLEDGER_GROUP_CODE_NEW,SUBLEDGER_LINE_C\
ODE_NEW,DEPT_CODE_NEW,PRODUCT_GROUP_CODE_NEW,PRODUCT_LINE_CODE_NEW,ACC_ENTITY_\
CODE) values (:b0,:b1,:b0,:b1,1,:b4,:b5,:b6,:b7,:b8,:b9,:b10,(:b11* (-1)),:b4,\
:b5,:b6,:b7,:b8,:b9,:b10,:b19)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1836;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_new_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_inv_start_doc_num;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_new_doc_type_code;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_inv_start_doc_num;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_rec_main_acc1_code;
      sqlstm.sqhstl[4] = (unsigned int  )9;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_rec_main_acc2_code;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_rec_subledger_group_code;
      sqlstm.sqhstl[6] = (unsigned int  )6;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bl_rec_subledger_line_code;
      sqlstm.sqhstl[7] = (unsigned int  )11;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&bl_rec_dept_code;
      sqlstm.sqhstl[8] = (unsigned int  )13;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&bl_rec_product_group_code;
      sqlstm.sqhstl[9] = (unsigned int  )6;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&bl_rec_product_line_code;
      sqlstm.sqhstl[10] = (unsigned int  )7;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&bl_outst_amt;
      sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&bl_rec_main_acc1_code;
      sqlstm.sqhstl[12] = (unsigned int  )9;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&bl_rec_main_acc2_code;
      sqlstm.sqhstl[13] = (unsigned int  )7;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&bl_rec_subledger_group_code;
      sqlstm.sqhstl[14] = (unsigned int  )6;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&bl_rec_subledger_line_code;
      sqlstm.sqhstl[15] = (unsigned int  )11;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&bl_rec_dept_code;
      sqlstm.sqhstl[16] = (unsigned int  )13;
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&bl_rec_product_group_code;
      sqlstm.sqhstl[17] = (unsigned int  )6;
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&bl_rec_product_line_code;
      sqlstm.sqhstl[18] = (unsigned int  )7;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&nd_acc_entity_code;
      sqlstm.sqhstl[19] = (unsigned int  )7;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("INSERT failed on table AR_CN_LINE",0,"");


}

/*Modification on 18/05/1998 End  */

update_bl_hdr()
{
   /*
    sprintf(string_var,"Patient Id : %s",bl_h_patient_id.arr);
	disp_message(ERR_MESG,string_var);
    */

    /* EXEC SQL UPDATE BL_PATIENT_FIN_DTLS
		    SET
      TOT_OUTST_IP_AMT      =  NVL(TOT_OUTST_IP_AMT,0) -
			       DECODE(:bl_h_episode_type,'I',:bl_h_bill_tot_outst_amt,'D',:bl_h_bill_tot_outst_amt,0),
      TOT_OUTST_OP_AMT      =  NVL(TOT_OUTST_OP_AMT,0) -
			       DECODE(:bl_h_episode_type,'O',:bl_h_bill_tot_outst_amt,'E',:bl_h_bill_tot_outst_amt,0),
      TOT_OUTST_REF_AMT     =  NVL(TOT_OUTST_REF_AMT,0) -
			       DECODE(:bl_h_episode_type,'R',:bl_h_bill_tot_outst_amt,0),
      MODIFIED_BY_ID        =  USER,         
      MODIFIED_DATE         =  SYSDATE,       
      MODIFIED_AT_WS_NO     =  :nd_ws_no,       
      MODIFIED_FACILITY_ID  =  :nd_operating_facility_id     
      WHERE  PATIENT_ID     = :bl_h_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 67;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_PATIENT_FIN_DTLS  set TOT_OUTST_IP_AMT=(NVL(TOT\
_OUTST_IP_AMT,0)-DECODE(:b0,'I',:b1,'D',:b1,0)),TOT_OUTST_OP_AMT=(NVL(TOT_OUTS\
T_OP_AMT,0)-DECODE(:b0,'O',:b1,'E',:b1,0)),TOT_OUTST_REF_AMT=(NVL(TOT_OUTST_RE\
F_AMT,0)-DECODE(:b0,'R',:b1,0)),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODI\
FIED_AT_WS_NO=:b8,MODIFIED_FACILITY_ID=:b9 where PATIENT_ID=:b10";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1931;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_h_bill_tot_outst_amt;
    sqlstm.sqhstl[1] = (unsigned int  )25;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_h_bill_tot_outst_amt;
    sqlstm.sqhstl[2] = (unsigned int  )25;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_h_bill_tot_outst_amt;
    sqlstm.sqhstl[4] = (unsigned int  )25;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_h_bill_tot_outst_amt;
    sqlstm.sqhstl[5] = (unsigned int  )25;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bl_h_bill_tot_outst_amt;
    sqlstm.sqhstl[7] = (unsigned int  )25;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[8] = (unsigned int  )33;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&bl_h_patient_id;
    sqlstm.sqhstl[10] = (unsigned int  )23;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR || NO_DATA_FOUND)
	err_mesg("UPDATE failed on table BL_PATIENT_FIN_DTLS",0,"");

    if(bl_h_episode_type.arr[0] != 'R') {

      if (bl_h_episode_id.arr[0] != '\0')
         {
	/* EXEC SQL UPDATE BL_EPISODE_FIN_DTLS
		 SET    TOT_OUTST_AMT = NVL(TOT_OUTST_AMT,0) - 
					:bl_h_bill_tot_outst_amt,
		        MODIFIED_BY_ID        =  USER,         
		        MODIFIED_DATE         =  SYSDATE,       
		        MODIFIED_AT_WS_NO     =  :nd_ws_no,       
		        MODIFIED_FACILITY_ID  =  :nd_operating_facility_id     
		 WHERE  EPISODE_TYPE  = :bl_h_episode_type
		 AND    EPISODE_ID    = :bl_h_episode_id
		 AND    OPERATING_FACILITY_ID = :bl_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 67;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_EPISODE_FIN_DTLS  set TOT_OUTST_AMT=(NVL(TOT_OUTST\
_AMT,0)-:b0),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1,M\
ODIFIED_FACILITY_ID=:b2 where ((EPISODE_TYPE=:b3 and EPISODE_ID=:b4) and OPERA\
TING_FACILITY_ID=:b5)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1990;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_h_bill_tot_outst_amt;
 sqlstm.sqhstl[0] = (unsigned int  )25;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_h_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_h_episode_id;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 if(OERROR || NO_DATA_FOUND)
	     err_mesg("UPDATE failed on table BL_EPISODE_FIN_DTLS",0,"");

		 }
    }

    if(bl_h_episode_type.arr[0] == 'O' || bl_h_episode_type.arr[0] == 'E') {

	if (bl_h_episode_id.arr[0] != '\0')
	   {
	/* EXEC SQL UPDATE BL_VISIT_FIN_DTLS
		 SET    TOT_OUTST_AMT = NVL(TOT_OUTST_AMT,0) - 
					:bl_h_bill_tot_outst_amt,
			MODIFIED_BY_ID        =  USER,         
		        MODIFIED_DATE         =  SYSDATE,       
		        MODIFIED_AT_WS_NO     =  :nd_ws_no,       
		        MODIFIED_FACILITY_ID  =  :nd_operating_facility_id     
		 WHERE  EPISODE_TYPE  = :bl_h_episode_type
		 AND    EPISODE_ID    = :bl_h_episode_id
		 AND    VISIT_ID      = :bl_h_visit_id
		 AND    OPERATING_FACILITY_ID = :bl_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 67;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_VISIT_FIN_DTLS  set TOT_OUTST_AMT=(NVL(TOT_OUTST_A\
MT,0)-:b0),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1,MOD\
IFIED_FACILITY_ID=:b2 where (((EPISODE_TYPE=:b3 and EPISODE_ID=:b4) and VISIT_\
ID=:b5) and OPERATING_FACILITY_ID=:b6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2029;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_h_bill_tot_outst_amt;
 sqlstm.sqhstl[0] = (unsigned int  )25;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_h_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_h_episode_id;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_h_visit_id;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&bl_facility_id;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 if(OERROR || NO_DATA_FOUND)
	     err_mesg("UPDATE failed on table BL_VISIT_FIN_DTLS",0,"");

		}
    }
/*
    EXEC SQL UPDATE BL_BILL_HDR
		SET BILL_STATUS = 'A',
		    AR_INV_DOC_TYPE_CODE = :nd_new_doc_type_code,
		    AR_INV_DOC_NUMBER    = :nd_new_doc_num,
		    AR_INV_DOC_DATE      = TO_DATE(NVL(:nd_inv_date,:bl_h_doc_date),'DD/MM/YYYY')
	      WHERE ROWID = :bl_h_rowid;

   if (OERROR)
	 err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");
*/

   //09/11/2002 As part of system controls and checks amt_transferred 
   //column is introduced
   /* EXEC SQL UPDATE BL_BILL_HDR
	       SET BILL_STATUS = 'A',
		   AR_INV_DOC_TYPE_CODE = :nd_new_doc_type_code,
		   AR_INV_DOC_NUMBER    = :work_doc_num,
		   AR_INV_DOC_DATE      = TO_DATE(NVL(:nd_inv_date,:bl_h_doc_date),'DD/MM/YYYY'),
		   BILL_TOT_OUTST_AMT       = NVL(BILL_TOT_OUTST_AMT,0) -
					       :bl_h_bill_tot_outst_amt,
		   BILL_HOSP_TOT_OUTST_AMT  = NVL(BILL_HOSP_TOT_OUTST_AMT,0)-
					       :bl_h_bill_hosp_tot_outst_amt,
		   BILL_DRFEE_TOT_OUTST_AMT = NVL(BILL_DRFEE_TOT_OUTST_AMT,0)-
                                               :bl_h_bill_drfee_tot_out_amt,
		   AMT_TRANSFERRED = AMT_TRANSFERRED + :bl_h_bill_tot_outst_amt		,
	   	   MODIFIED_BY_ID        =  USER,         
		   MODIFIED_DATE         =  SYSDATE,        
		   MODIFIED_AT_WS_NO     =  :nd_ws_no,       
		   MODIFIED_FACILITY_ID  =  :nd_operating_facility_id     										
	     WHERE ROWID = :bl_h_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 67;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update BL_BILL_HDR  set BILL_STATUS='A',AR_INV_DOC_TYPE_CO\
DE=:b0,AR_INV_DOC_NUMBER=:b1,AR_INV_DOC_DATE=TO_DATE(NVL(:b2,:b3),'DD/MM/YYYY'\
),BILL_TOT_OUTST_AMT=(NVL(BILL_TOT_OUTST_AMT,0)-:b4),BILL_HOSP_TOT_OUTST_AMT=(\
NVL(BILL_HOSP_TOT_OUTST_AMT,0)-:b5),BILL_DRFEE_TOT_OUTST_AMT=(NVL(BILL_DRFEE_T\
OT_OUTST_AMT,0)-:b6),AMT_TRANSFERRED=(AMT_TRANSFERRED+:b4),MODIFIED_BY_ID=USER\
,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b8,MODIFIED_FACILITY_ID=:b9 where RO\
WID=:b10";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2072;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_new_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&work_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_inv_date;
   sqlstm.sqhstl[2] = (unsigned int  )15;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bl_h_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )15;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&bl_h_bill_tot_outst_amt;
   sqlstm.sqhstl[4] = (unsigned int  )25;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&bl_h_bill_hosp_tot_outst_amt;
   sqlstm.sqhstl[5] = (unsigned int  )25;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&bl_h_bill_drfee_tot_out_amt;
   sqlstm.sqhstl[6] = (unsigned int  )25;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&bl_h_bill_tot_outst_amt;
   sqlstm.sqhstl[7] = (unsigned int  )25;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[8] = (unsigned int  )33;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&bl_h_rowid;
   sqlstm.sqhstl[10] = (unsigned int  )33;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
	 err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");

}                 

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 67;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )2131;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )134;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}
