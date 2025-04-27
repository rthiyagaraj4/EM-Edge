
/* Result Sets Interface */
#ifndef SQL_CRSR
#  define SQL_CRSR
  struct sql_cursor
  {
    unsigned int curocn;
    void *ptr1;
    void *ptr2;
    unsigned int magic;
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
           char  filnam[42];
};
static const struct sqlcxp sqlfpn =
{
    41,
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/AR/ARBGLEXP.PC"
};


static unsigned int sqlctx = 1288481467;


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
   unsigned int   sqlcmax;
   unsigned int   sqlcmin;
   unsigned int   sqlcincr;
   unsigned int   sqlctimeout;
   unsigned int   sqlcnowait;
              int   sqfoff;
   unsigned int   sqcmod;
   unsigned int   sqfmod;
            void  *sqhstv[38];
   unsigned int   sqhstl[38];
            int   sqhsts[38];
            void  *sqindv[38];
            int   sqinds[38];
   unsigned int   sqharm[38];
   unsigned int   *sqharc[38];
   unsigned short  sqadto[38];
   unsigned short  sqtdso[38];
} sqlstm = {12,38};

/* SQLLIB Prototypes */
extern void sqlcxt (void **, unsigned int *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlcx2t(void **, unsigned int *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlbuft(void **, char *);
extern void sqlgs2t(void **, char *);
extern void sqlorat(void **, unsigned int *, void *);

/* Forms Interface */
static const int IAPSUCC = 0;
static const int IAPFAIL = 1403;
static const int IAPFTL  = 535;
extern void sqliem(unsigned char *, signed int *);

 static const char *sq0010 = 
"select ACC_ENTITY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY\
') ,NVL(CUST_REF,' ') ,NVL(NARRATION,' ') ,NVL(POST_MONTH,0) ,NVL(POST_YEAR,0)\
 ,NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CODE_NEW,\
' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,NVL(SUB\
LEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,PAYABLE_AMT ,NVL\
(PAYABLE_AMT,0) ,SIGN(PAYABLE_AMT) ,DECODE(SIGN(PAYABLE_AMT),(-1),(-PAYABLE_AM\
T),PAYABLE_AMT) ,CUST_CODE ,ROWID  from AR_INV_HDR where ((POSTED_FLAG='Y' and\
 INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST\
_MONTH,'09')))<=(:b0||:b1))           ";

 static const char *sq0011 = 
"select ACC_ENTITY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY\
') ,POST_MONTH ,POST_YEAR ,ROWID  from AR_DN_HDR where ((POSTED_FLAG='Y' and I\
NTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_M\
ONTH,'09')))<=(:b0||:b1))           ";

 static const char *sq0012 = 
"select ACC_ENTITY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY\
') ,POST_MONTH ,POST_YEAR ,ROWID  from AR_CN_HDR where ((POSTED_FLAG='Y' and I\
NTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_M\
ONTH,'09')))<=(:b0||:b1))           ";

 static const char *sq0013 = 
"select ACC_ENTITY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY\
') ,POST_MONTH ,POST_YEAR ,ROWID  from AR_ADJ_HDR where ((POSTED_FLAG='Y' and \
INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_\
MONTH,'09')))<=(:b0||:b1))           ";

 static const char *sq0014 = 
"select ACC_ENTITY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY\
') ,NVL(DOC_REF,' ') ,NVL(NARRATION,' ') ,POST_MONTH ,POST_YEAR ,NVL(MAIN_ACC1\
_CODE,' ') ,NVL(MAIN_ACC2_CODE,' ') ,NVL(DEPT_CODE,' ') ,NVL(PRODUCT_GROUP_COD\
E,' ') ,NVL(PRODUCT_LINE_CODE,' ') ,NVL(SUBLEDGER_GROUP_CODE,' ') ,NVL(SUBLEDG\
ER_LINE_CODE,' ') ,NVL(AMT_LOCAL,0) ,AMT_LOCAL ,SIGN(AMT_LOCAL) ,DECODE(SIGN(A\
MT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL) ,CHEQUE_NUM ,to_char(CHEQUE_DATE,'DD/MM\
/YYYY') ,CUST_CODE ,ROWID  from AR_REC_HDR where ((POSTED_FLAG='Y' and INTERFA\
CE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'\
09')))<=(:b0||:b1))           ";

 static const char *sq0016 = 
"select ACC_ENTITY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY\
') ,NVL(CHEQUE_NUM,' ') ,NVL(NARRATION,' ') ,NVL(POST_MONTH,0) ,NVL(POST_YEAR,\
0) ,NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CODE_NE\
W,' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,NVL(S\
UBLEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,((-1)* AMT_LOC\
AL) ,AMT_LOCAL ,SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_\
LOCAL) ,CHEQUE_NUM ,to_char(CHEQUE_DATE,'DD/MM/YYYY') ,CUST_CODE ,ROWID  from \
AR_PAY_HDR where ((POSTED_FLAG='Y' and INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(\
POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09')))<=(:b0||:b1))           ";

 static const char *sq0015 = 
"select ACC_ENTITY_CODE ,NVL(NARRATION,' ') ,NVL(MAIN_ACC1_CODE_BANK,' ') ,NV\
L(MAIN_ACC2_CODE_BANK,' ') ,NVL(DEPT_CODE_BANK,' ') ,NVL(PRODUCT_GROUP_CODE_BA\
NK,' ') ,NVL(PRODUCT_LINE_CODE_BANK,' ') ,NVL(SUBLEDGER_GROUP_CODE_BANK,' ') ,\
NVL(SUBLEDGER_LINE_CODE_BANK,' ') ,AMT_LOCAL ,NVL(MAIN_ACC1_CODE_SUSP,' ') ,NV\
L(MAIN_ACC2_CODE_SUSP,' ') ,NVL(DEPT_CODE_SUSP,' ') ,NVL(PRODUCT_GROUP_CODE_SU\
SP,' ') ,NVL(PRODUCT_LINE_CODE_SUSP,' ') ,NVL(SUBLEDGER_GROUP_CODE_SUSP,' ') ,\
NVL(SUBLEDGER_LINE_CODE_SUSP,' ') ,((-1)* AMT_LOCAL) ,AMT_LOCAL ,SIGN(AMT_LOCA\
L) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL) ,CHEQUE_NUM ,to_char(C\
HEQUE_DATE,'DD/MM/YYYY') ,CUST_CODE ,ROWID  from AR_CASHIER where (DOC_TYPE_CO\
DE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0026 = 
"select NVL(BANK_RECONCILE_FLAG,'N')  from GL_POSTING_ACC where ((((((MAIN_AC\
C1_CODE=:b0 and MAIN_ACC2_CODE=:b1) and DEPT_CODE=:b2) and PRODUCT_GROUP_CODE=\
:b3) and PRODUCT_LINE_CODE=:b4) and SUBLEDGER_GROUP_CODE=:b5) and SUBLEDGER_LI\
NE_CODE=:b6)           ";

 static const char *sq0017 = 
"select MAIN_ACC1_CODE_NEW ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CODE_NEW,' \
') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,NVL(SUBLE\
DGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,((-1)* AMT_LOCAL) \
,AMT_LOCAL ,SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCA\
L) ,NVL(NARRATION,' ')  from AR_INV_LINE where (DOC_TYPE_CODE=:b0 and DOC_NUM=\
:b1)           ";

 static const char *sq0019 = 
"select NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CO\
DE_NEW,' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,\
NVL(SUBLEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,((-1)* AM\
OUNT) ,AMOUNT ,SIGN(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(-AMOUNT),AMOUNT) ,NVL(N\
ARRATION,' ')  from AR_DN_LINE where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and\
 ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUM=:b3)           ";

 static const char *sq0021 = 
"select NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CO\
DE_NEW,' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,\
NVL(SUBLEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,NVL(AMOUN\
T,0) ,AMOUNT ,SIGN(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(-AMOUNT),AMOUNT) ,NVL(NA\
RRATION,' ')  from AR_CN_LINE where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and \
ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUM=:b3)           ";

 static const char *sq0023 = 
"select NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CO\
DE_NEW,' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,\
NVL(SUBLEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,DECODE(:b\
0,'D',((-1)* AMOUNT),AMOUNT) ,AMOUNT ,SIGN(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(\
-AMOUNT),AMOUNT) ,NVL(NARRATION,' ')  from AR_ADJ_LINE where (((DOC_TYPE_CODE=\
:b1 and DOC_NUM=:b2) and ORG_DOC_TYPE_CODE=:b3) and ORG_DOC_NUM=:b4)          \
 ";

 static const char *sq0024 = 
"select NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CO\
DE_NEW,' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,\
NVL(SUBLEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,((-1)* AM\
T_LOCAL) ,AMT_LOCAL ,SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL)\
,AMT_LOCAL) ,NVL(NARRATION,' ')  from AR_REC_LINE where (DOC_TYPE_CODE=:b0 and\
 DOC_NUM=:b1)           ";

 static const char *sq0025 = 
"select NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CO\
DE_NEW,' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,\
NVL(SUBLEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,NVL(AMT_L\
OCAL,0) ,AMT_LOCAL ,SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),\
AMT_LOCAL) ,NVL(NARRATION,' ')  from AR_PAY_LINE where (DOC_TYPE_CODE=:b0 and \
DOC_NUM=:b1)           ";

 static const char *sq0018 = 
"select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM ,NVL(NARRATION,' ') ,NVL(CUST_REF,' ')\
 ,NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CODE_NEW,\
' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,NVL(SUB\
LEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,DOC_AMT ,((-1)* \
DOC_AMT) ,SIGN(DOC_AMT) ,DECODE(SIGN(DOC_AMT),(-1),(-DOC_AMT),DOC_AMT) ,CUST_C\
ODE  from AR_DN_INV_HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0020 = 
"select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM ,NVL(NARRATION,' ') ,NVL(CUST_REF,' ')\
 ,NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CODE_NEW,\
' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,NVL(SUB\
LEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,((-1)* DOC_AMT) \
,DOC_AMT ,SIGN(DOC_AMT) ,DECODE(SIGN(DOC_AMT),(-1),(-DOC_AMT),DOC_AMT) ,CUST_C\
ODE  from AR_CN_INV_HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0022 = 
"select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM ,NVL(NARRATION,' ') ,NVL(CUST_REF,' ')\
 ,NVL(MAIN_ACC1_CODE_NEW,' ') ,NVL(MAIN_ACC2_CODE_NEW,' ') ,NVL(DEPT_CODE_NEW,\
' ') ,NVL(PRODUCT_GROUP_CODE_NEW,' ') ,NVL(PRODUCT_LINE_CODE_NEW,' ') ,NVL(SUB\
LEDGER_GROUP_CODE_NEW,' ') ,NVL(SUBLEDGER_LINE_CODE_NEW,' ') ,NVL(ADJ_TYPE,' '\
) ,DECODE(ADJ_TYPE,'D',DOC_AMT,((-1)* DOC_AMT)) ,DOC_AMT ,SIGN(DOC_AMT) ,DECOD\
E(SIGN(DOC_AMT),(-1),(-DOC_AMT),DOC_AMT) ,CUST_CODE  from AR_ADJ_INV_HDR where\
 (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0027 = 
"select POST_MONTH ,POST_YEAR ,NVL(MAIN_ACC1_CODE,' ') ,NVL(MAIN_ACC2_CODE,' \
') ,NVL(DEPT_CODE,' ') ,NVL(PRODUCT_GROUP_CODE,' ') ,NVL(PRODUCT_LINE_CODE,' '\
) ,NVL(SUBLEDGER_GROUP_CODE,' ') ,NVL(SUBLEDGER_LINE_CODE,' ') ,sum(DEBIT_AMT)\
  from AR_GL_DISTRBN_TEMP where NVL(TRN_TYPE_CODE,'N')='N' group by POST_MONTH\
,POST_YEAR,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_\
LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE           ";

 static const char *sq0028 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,NVL(DOC_REF,'\
 ') ,NVL(MAIN_ACC1_CODE,' ') ,NVL(MAIN_ACC2_CODE,' ') ,NVL(DEPT_CODE,' ') ,NVL\
(PRODUCT_GROUP_CODE,' ') ,NVL(PRODUCT_LINE_CODE,' ') ,NVL(SUBLEDGER_GROUP_CODE\
,' ') ,NVL(SUBLEDGER_LINE_CODE,' ') ,NVL(DEBIT_AMT,0) ,NVL(NARRATION,' ') ,POS\
T_MONTH ,POST_YEAR ,CHEQUE_NUM  from AR_GL_DISTRBN_TEMP where TRN_TYPE_CODE='Y\
' order by DOC_TYPE_CODE,DOC_NUM,DOC_REF,NARRATION            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,285,0,4,306,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
68,0,0,2,99,0,4,341,0,0,3,1,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,
95,0,0,3,0,0,29,397,0,0,0,0,0,1,0,
110,0,0,4,0,0,30,408,0,0,0,0,0,1,0,
125,0,0,0,0,0,27,415,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
156,0,0,6,91,0,2,424,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
179,0,0,7,0,0,29,433,0,0,0,0,0,1,0,
194,0,0,8,62,0,4,444,0,0,1,0,0,1,0,2,9,0,0,
213,0,0,9,110,0,4,454,0,0,3,0,0,1,0,2,3,0,0,2,3,0,0,2,1,0,0,
240,0,0,29,32,0,2,878,0,0,0,0,0,1,0,
255,0,0,30,0,0,29,882,0,0,0,0,0,1,0,
270,0,0,31,54,0,1,892,0,0,0,0,0,1,0,
285,0,0,32,46,0,1,905,0,0,0,0,0,1,0,
300,0,0,33,47,0,1,912,0,0,0,0,0,1,0,
315,0,0,34,45,0,1,922,0,0,0,0,0,1,0,
330,0,0,35,49,0,1,929,0,0,0,0,0,1,0,
345,0,0,36,46,0,1,936,0,0,0,0,0,1,0,
360,0,0,37,45,0,1,946,0,0,0,0,0,1,0,
375,0,0,38,49,0,1,953,0,0,0,0,0,1,0,
390,0,0,39,46,0,1,960,0,0,0,0,0,1,0,
405,0,0,40,46,0,1,970,0,0,0,0,0,1,0,
420,0,0,41,50,0,1,977,0,0,0,0,0,1,0,
435,0,0,42,47,0,1,984,0,0,0,0,0,1,0,
450,0,0,43,46,0,1,994,0,0,0,0,0,1,0,
465,0,0,44,47,0,1,1001,0,0,0,0,0,1,0,
480,0,0,45,46,0,1,1011,0,0,0,0,0,1,0,
495,0,0,46,47,0,1,1018,0,0,0,0,0,1,0,
510,0,0,47,101,0,4,1031,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
533,0,0,10,660,0,9,1053,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
556,0,0,11,268,0,9,1059,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
579,0,0,12,268,0,9,1065,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
602,0,0,13,269,0,9,1070,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
625,0,0,14,652,0,9,1075,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
648,0,0,16,698,0,9,1081,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
671,0,0,10,0,0,13,1100,0,0,21,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
770,0,0,11,0,0,13,1127,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,
3,0,0,2,9,0,0,
813,0,0,12,0,0,13,1139,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,
3,0,0,2,9,0,0,
856,0,0,13,0,0,13,1151,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,
3,0,0,2,9,0,0,
899,0,0,14,0,0,13,1163,0,0,23,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1006,0,0,16,0,0,13,1191,0,0,23,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1113,0,0,15,734,0,9,1436,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1136,0,0,15,0,0,13,1438,0,0,25,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,
1251,0,0,48,310,0,3,1640,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
1322,0,0,49,310,0,3,1691,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
1393,0,0,50,323,0,3,1733,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,3,0,0,1,3,0,0,1,3,0,0,
1444,0,0,51,549,0,3,1814,0,0,34,34,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,
0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,
0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,
9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,9,0,0,
1595,0,0,26,255,0,9,1908,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1638,0,0,26,0,0,13,1915,0,0,1,0,0,1,0,2,9,0,0,
1657,0,0,17,403,0,9,1930,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1680,0,0,19,443,0,9,1935,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1711,0,0,21,442,0,9,1940,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1742,0,0,23,467,0,9,1945,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1777,0,0,24,412,0,9,1950,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1800,0,0,25,411,0,9,1955,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1823,0,0,17,0,0,13,1970,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
1886,0,0,19,0,0,13,1987,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
1949,0,0,21,0,0,13,2004,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
2012,0,0,23,0,0,13,2021,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
2075,0,0,24,0,0,13,2038,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
2138,0,0,25,0,0,13,2055,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
2201,0,0,18,464,0,9,2131,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2224,0,0,20,464,0,9,2136,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2247,0,0,22,513,0,9,2141,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2270,0,0,18,0,0,13,2156,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,
0,2,9,0,0,
2349,0,0,20,0,0,13,2177,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,
0,2,9,0,0,
2428,0,0,22,0,0,13,2201,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,
0,2,9,0,0,2,9,0,0,
2511,0,0,52,88,0,2,2307,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2534,0,0,53,89,0,2,2315,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2557,0,0,54,74,0,2,2323,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2580,0,0,55,57,0,5,2354,0,0,1,1,0,1,0,1,9,0,0,
2599,0,0,56,56,0,5,2362,0,0,1,1,0,1,0,1,9,0,0,
2618,0,0,57,56,0,5,2369,0,0,1,1,0,1,0,1,9,0,0,
2637,0,0,58,57,0,5,2376,0,0,1,1,0,1,0,1,9,0,0,
2656,0,0,59,57,0,5,2386,0,0,1,1,0,1,0,1,9,0,0,
2675,0,0,60,57,0,5,2393,0,0,1,1,0,1,0,1,9,0,0,
2694,0,0,61,57,0,5,2402,0,0,1,1,0,1,0,1,9,0,0,
2713,0,0,62,178,0,5,2452,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
1,9,0,0,
2752,0,0,63,410,0,3,2468,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
2787,0,0,27,449,0,9,2514,0,0,0,0,0,1,0,
2802,0,0,27,0,0,13,2541,0,0,10,0,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2857,0,0,64,79,0,4,2583,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2880,0,0,65,85,0,5,2593,0,0,1,1,0,1,0,1,9,0,0,
2899,0,0,66,310,0,3,2615,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
2970,0,0,67,296,0,3,2663,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
1,3,0,0,
3009,0,0,28,450,0,9,2754,0,0,0,0,0,1,0,
3024,0,0,28,0,0,13,2792,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,
0,2,9,0,0,
3103,0,0,68,310,0,3,2864,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
3174,0,0,69,314,0,3,2919,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,3,0,0,1,3,0,0,
3217,0,0,70,632,0,3,2998,0,0,38,38,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,
0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : ARBGLEXP.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 14-MAR-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                               */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        SY_PROG_CONTROL          Update/Lookup             */
/*         2.        SY_PROG_MESG                Insert                 */
/*         3.        AR_INV_HDR               Query/Update              */
/*         4.        AR_INV_LINE                 Query                  */
/*         5.        AR_DN_HDR                Query/Update              */
/*         6.        AR_DN_INV_HDR               Query                  */
/*         7.        AR_DN_LINE                  Query                  */
/*         8.        AR_CN_HDR                Query/Update              */
/*         9.        AR_CN_INV_HDR               Query                  */
/*        10.        AR_CN_LINE                  Query                  */
/*        11.        AR_ADJ_HDR               Query/Update              */
/*        12.        AR_ADJ_INV_HDR              Query                  */
/*        13.        AR_ADJ_LINE                 Query                  */
/*        14.        AR_PAY_HDR               Query/Update              */
/*        15.        AR_PAY_LINE                 Query                  */
/*        16.        AR_REC_HDR               Query/Update              */
/*        17.        AR_REC_LINE                 Query                  */
/*        18.        AR_GL_DISTRBN_TEMP       Query/Update              */
/*        19.        GL_TXN_DOC_HDR           Insert/Delete             */
/*        20.        GL_TXN_DOC_LINE          Insert/Delete             */
/*        21.        AR_CASHIER               Query/Update                  */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                       log_err_mesg                   */
/*         2.        POST                validate_posting_acct          */
/*         3.        POST_DOC            post_doc (GL posting acc val)  */
/*                                                                      */
/*                                                                      */
/************************************************************************/
                     
#include <stdio.h>
#include <math.h>
#include <string.h>
//#include "winexecc.h"
#include "gl.h"

#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

#define RESOURCE_BUSY        (sqlca.sqlcode == -54)

#define DEBUG 0

#define VIEW_LOG_FILE 1


/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;


   /* VARCHAR  nd_facility_id              [3],
			nd_session_id               [16],
            nd_pgm_date                 [25],
				p_language_id			    [3],
			nd_acc_entity_code          [5],

            nd_exp_year                 [5],
            nd_exp_month                [3],
            nd_interface_mode           [2],
            nd_inv_doc_type_code        [7],
            nd_dn_doc_type_code         [7],
            nd_cn_doc_type_code         [7],
            nd_adj_doc_type_code        [7],
            nd_rec_doc_type_code        [7],
            nd_pay_doc_type_code        [7],

            nd_tmp_doc_type_code        [7],

            d_ar_hdr_doc_type_code      [7],
            d_ar_hdr_doc_num            [9],
            d_ar_hdr_doc_date           [12],
            d_ar_hdr_cust_ref           [16],
			d_cust_code                 [9],
			d_acc_entity_code           [5],
            d_ar_hdr_narration          [51],
            d_ar_hdr_main_acc1_code     [9],
            d_ar_hdr_main_acc2_code     [7],
            d_ar_hdr_dept_code          [7],
            d_ar_hdr_product_group_code [4],
            d_ar_hdr_product_line_code  [5],
            d_ar_hdr_sub_group_code[4],
            d_ar_hdr_sub_line_code [9],
            d_ar_hdr_amount             [17],
            d_ar_off_rec_hdr_main_acc1_code     [9],
            d_ar_off_rec_hdr_main_acc2_code     [7],
            d_ar_off_rec_hdr_dept_code          [7],
            d_ar_off_rec_hdr_product_group_code [4],
            d_ar_off_rec_hdr_product_line_code  [5],
            d_ar_off_rec_hdr_sub_group_code[4],
            d_ar_off_rec_hdr_sub_line_code [9],

			d_ar_off_rec_hdr_amount     [17],

            d_ar_hdr_rowid              [31],
			d_ar_off_hdr_rowid          [31],
            d_gd_hdr_cust_ref       [16],


            d_ar_hdr_adj_type           [3],
            d_ar_hdr_org_doc_type_code  [7],
            d_ar_hdr_org_doc_num        [9],

            d_ar_line_main_acc1_code    [9],
            d_ar_line_main_acc2_code    [7],
            d_ar_line_dept_code         [7],
            d_ar_line_product_group_code[4],
            d_ar_line_product_line_code [5],
            d_ar_line_sub_group_code[4],
            d_ar_line_sub_line_code [9],
            d_ar_line_amt_local         [17],
            d_ar_line_narration         [51],
			d_module_valid_id            [3],

            d_ar_hdr_doc_ref            [16],

            d_narration1                [51],
            d_cust_ref1                 [16],

            d_ar_bank_reconcile_flg     [3],
            d_chk_main_acc1_code        [9],
            d_chk_main_acc2_code        [7],
            d_chk_dept_code             [7],
            d_chk_product_group_code    [4],
            d_chk_product_line_code     [5],
            d_chk_sub_group_code  [4],
            d_chk_sub_line_code   [9],

            ar_interface_code           [2],
            d_gl_dist_doc_type_code     [7],
            d_gl_dist_doc_num           [9],
            d_gl_dist_doc_date          [12],

            d_sy_acc_rowid              [31],
			
			l_gl_cust_ref              [16],
            l_gl_narration             [51],
            l_gd_debit_amt             [17],
            l_gd_credit_amt            [17],
            l_gd_amount                [17],
            l_gd_cheque_num            [11],
            l_prv_cheque_num           [11],
            l_gd_cheque_date           [15],
            l_gd_amount_negative       [17],
            l_gd_trn_type_code         [5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[5]; } nd_exp_year;

struct { unsigned short len; unsigned char arr[3]; } nd_exp_month;

struct { unsigned short len; unsigned char arr[2]; } nd_interface_mode;

struct { unsigned short len; unsigned char arr[7]; } nd_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_dn_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_cn_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_adj_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_rec_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_pay_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_tmp_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_hdr_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_hdr_doc_date;

struct { unsigned short len; unsigned char arr[16]; } d_ar_hdr_cust_ref;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[5]; } d_acc_entity_code;

struct { unsigned short len; unsigned char arr[51]; } d_ar_hdr_narration;

struct { unsigned short len; unsigned char arr[9]; } d_ar_hdr_main_acc1_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_hdr_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_hdr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_ar_hdr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_ar_hdr_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_ar_hdr_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_hdr_sub_line_code;

struct { unsigned short len; unsigned char arr[17]; } d_ar_hdr_amount;

struct { unsigned short len; unsigned char arr[9]; } d_ar_off_rec_hdr_main_acc1_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_off_rec_hdr_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_off_rec_hdr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_ar_off_rec_hdr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_ar_off_rec_hdr_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_ar_off_rec_hdr_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_off_rec_hdr_sub_line_code;

struct { unsigned short len; unsigned char arr[17]; } d_ar_off_rec_hdr_amount;

struct { unsigned short len; unsigned char arr[31]; } d_ar_hdr_rowid;

struct { unsigned short len; unsigned char arr[31]; } d_ar_off_hdr_rowid;

struct { unsigned short len; unsigned char arr[16]; } d_gd_hdr_cust_ref;

struct { unsigned short len; unsigned char arr[3]; } d_ar_hdr_adj_type;

struct { unsigned short len; unsigned char arr[7]; } d_ar_hdr_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_hdr_org_doc_num;

struct { unsigned short len; unsigned char arr[9]; } d_ar_line_main_acc1_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_line_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_line_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_ar_line_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_ar_line_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_ar_line_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_line_sub_line_code;

struct { unsigned short len; unsigned char arr[17]; } d_ar_line_amt_local;

struct { unsigned short len; unsigned char arr[51]; } d_ar_line_narration;

struct { unsigned short len; unsigned char arr[3]; } d_module_valid_id;

struct { unsigned short len; unsigned char arr[16]; } d_ar_hdr_doc_ref;

struct { unsigned short len; unsigned char arr[51]; } d_narration1;

struct { unsigned short len; unsigned char arr[16]; } d_cust_ref1;

struct { unsigned short len; unsigned char arr[3]; } d_ar_bank_reconcile_flg;

struct { unsigned short len; unsigned char arr[9]; } d_chk_main_acc1_code;

struct { unsigned short len; unsigned char arr[7]; } d_chk_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } d_chk_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_chk_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_chk_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_chk_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_chk_sub_line_code;

struct { unsigned short len; unsigned char arr[2]; } ar_interface_code;

struct { unsigned short len; unsigned char arr[7]; } d_gl_dist_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_gl_dist_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_gl_dist_doc_date;

struct { unsigned short len; unsigned char arr[31]; } d_sy_acc_rowid;

struct { unsigned short len; unsigned char arr[16]; } l_gl_cust_ref;

struct { unsigned short len; unsigned char arr[51]; } l_gl_narration;

struct { unsigned short len; unsigned char arr[17]; } l_gd_debit_amt;

struct { unsigned short len; unsigned char arr[17]; } l_gd_credit_amt;

struct { unsigned short len; unsigned char arr[17]; } l_gd_amount;

struct { unsigned short len; unsigned char arr[11]; } l_gd_cheque_num;

struct { unsigned short len; unsigned char arr[11]; } l_prv_cheque_num;

struct { unsigned short len; unsigned char arr[15]; } l_gd_cheque_date;

struct { unsigned short len; unsigned char arr[17]; } l_gd_amount_negative;

struct { unsigned short len; unsigned char arr[5]; } l_gd_trn_type_code;



     int    d_ar_hdr_post_month,
            d_ar_hdr_post_year,
            d_ar_run_line_num = 0;

    int     d_gl_dist_post_month,
            d_gl_dist_post_year;


	int		d_ar_switch =0;

	int     l_gd_hdr_sign_amount,
            l_gd_sign_amount;    /* sign(amount)  0 -> 0   */
                                 /*               1 -> +ve */
                                 /*              -1 -> -ve */



/* These variables ar used for calling post_doc (Posting acc validation) */

int  d_curr_year;
int  d_curr_month;
int  d_num_of_acc_periods;
char d_summ_flag;
     
/*                                                                         */

char mesg1[300];
/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header: sqlca.h 24-apr-2003.12:50:58 mkandarp Exp $ sqlca.h 
 */

/* Copyright (c) 1985, 2003, Oracle Corporation.  All rights reserved.  */
 
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
 * $Header: sqlda.h 08-may-2007.05:58:33 ardesai Exp $ sqlda.h 
 */

/***************************************************************
*      The SQLDA descriptor definition                         *
*--------------------------------------------------------------*
*      VAX/3B Version                                          *
*                                                              *
* Copyright (c) 1987, 2007, Oracle. All rights reserved.  *
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
    ardesai    05/08/07  - Bug[6037057] Undef Y
    apopat     05/08/02  - [2362423] MVS PE to make lines shorter than 79
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

#ifdef Y
 # undef Y
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
  /* ub2*   */ short     *Y; /* Ptr to Arr of max lengths of ind. var. names*/
  /* ub2*   */ short     *Z; /* Ptr to Arr of cur lengths of ind. var. names*/
  };
 
typedef struct SQLDA SQLDA;
 
#endif

/* ----------------- */
/* defines for sqlda */
/* ----------------- */

#define SQLSQLDAAlloc(arg1, arg2, arg3, arg4) sqlaldt(arg1, arg2, arg3, arg4) 

#define SQLSQLDAFree(arg1, arg2) sqlclut(arg1, arg2) 




 
#include "winproc.h"


   char		tempstring                 [50],
            l_gd_hdr_amount            [19],
            l_gd_hdr_amt_negative      [19];
 

   char tmp_main_acc1_code[10],
        tmp_main_acc2_code[10],
        tmp_dept_code[10],
        tmp_product_group_code[10],
        tmp_product_line_code[10],
        tmp_sub_group_code[10],
        tmp_sub_line_code[10];

  char  tmp_doc_type_code[10],
        tmp_doc_num[10],
        tmp_doc_date [12],
        valid_flag;

   int  tmp_post_month,
        tmp_post_year;

int t_type = 0;

int g_err_typ;

char g_err_id[10],
     g_err_msg[80];

char trn_desc[8][20] = {"","Invoice","Debit Note","Credit Note","Adjustment",
                        "Receipt","Payment"};

void proc_main(argc,argv)
char *argv[];
int argc;
{
   char mesg1[50];

   if (argc != 5)
   { 
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(g_pgm_id,"ARBGLEXP");

 
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);
 
   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle\n");
      sprintf(mesg1,"Error is %s\n",sqlca.sqlerrm.sqlerrmc);
      disp_message(ERR_MESG,mesg1);
      proc_exit();
   }              

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   strcpy(g_facility_id,argv[4]);

   set_meduser_role();
   	
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;


   chk_active();

   start_prog_control();
   start_prog_msg();
   nd_exp_month.arr[0]         = '\0';
   nd_exp_year.arr[0]          = '\0';
   nd_interface_mode.arr[0]    = '\0';
   nd_inv_doc_type_code.arr[0] = '\0';
   nd_dn_doc_type_code.arr[0]  = '\0';
   nd_cn_doc_type_code.arr[0]  = '\0';
   nd_adj_doc_type_code.arr[0] = '\0';
   nd_rec_doc_type_code.arr[0] = '\0';
   nd_pay_doc_type_code.arr[0] = '\0';
   

   nd_exp_month.len            = 0;
   nd_exp_year.len             = 0;
   nd_interface_mode.len       = 0;
   nd_inv_doc_type_code.len    = 0;
   nd_dn_doc_type_code.len     = 0;
   nd_cn_doc_type_code.len     = 0;
   nd_adj_doc_type_code.len    = 0;
   nd_rec_doc_type_code.len    = 0;
   nd_pay_doc_type_code.len    = 0;

   /* EXEC SQL SELECT operating_facility_id,
				   PARAM1,PARAM2,PARAM3,NVL(PARAM4,' '),NVL(PARAM5,' '),
                   NVL(PARAM6,' '),NVL(PARAM7,' '),NVL(PARAM8,' '),NVL(PARAM9,' ')
              INTO :nd_facility_id,
				   :nd_exp_year,
                   :nd_exp_month,
                   :nd_interface_mode,
                   :nd_inv_doc_type_code,
                   :nd_dn_doc_type_code,
                   :nd_cn_doc_type_code,
                   :nd_adj_doc_type_code,
                   :nd_rec_doc_type_code,
                   :nd_pay_doc_type_code
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBGLEXP'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,NVL(\
PARAM4,' ') ,NVL(PARAM5,' ') ,NVL(PARAM6,' ') ,NVL(PARAM7,' ') ,NVL(PARAM8,' '\
) ,NVL(PARAM9,' ') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  from SY_PROG_\
PARAM where ((PGM_ID='ARBGLEXP' and SESSION_ID=:b10) and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_exp_year;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_exp_month;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_interface_mode;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_inv_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_dn_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_cn_doc_type_code;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_adj_doc_type_code;
   sqlstm.sqhstl[7] = (unsigned int  )9;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_rec_doc_type_code;
   sqlstm.sqhstl[8] = (unsigned int  )9;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_pay_doc_type_code;
   sqlstm.sqhstl[9] = (unsigned int  )9;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[11] = (unsigned int  )27;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
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

   nd_exp_month.arr[nd_exp_month.len]                 = '\0';
   nd_exp_year.arr[nd_exp_year.len]                   = '\0';
   nd_interface_mode.arr[nd_interface_mode.len]       = '\0';
   nd_inv_doc_type_code.arr[nd_inv_doc_type_code.len] = '\0';
   nd_dn_doc_type_code.arr[nd_dn_doc_type_code.len]   = '\0';
   nd_cn_doc_type_code.arr[nd_cn_doc_type_code.len]   = '\0';
   nd_adj_doc_type_code.arr[nd_adj_doc_type_code.len] = '\0';
   nd_rec_doc_type_code.arr[nd_rec_doc_type_code.len] = '\0';
   nd_pay_doc_type_code.arr[nd_pay_doc_type_code.len] = '\0';

    nd_acc_entity_code.arr[0] = '\0';
	
	nd_acc_entity_code.len    = 0;
	
	/* EXEC SQL SELECT   ACC_ENTITY_CODE, NUM_OF_ACC_PERIODS
              INTO     :nd_acc_entity_code, :d_num_of_acc_periods
              FROM SY_ACC_ENTITY
			  where  acc_entity_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ACC_ENTITY_CODE ,NUM_OF_ACC_PERIODS into :b0,:b1  fro\
m SY_ACC_ENTITY where acc_entity_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )68;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_num_of_acc_periods;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
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
        err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

		nd_acc_entity_code.arr[nd_acc_entity_code.len]  = '\0';
    



   delete_prog_param(); 

   fetch_ar_param();

   if (ar_interface_code.arr[0] != 'B')
   {
        err_mesg("",1,"AR2320");
        proc_exit();
   }
  
   
   declare_cursors();

   for (t_type=1;t_type<7;t_type++)
   {

      lock_tables(t_type);
      delete_gl_distrbn(t_type);
      open_hdr(t_type);

      while(fetch_hdr(t_type))   
      {
          process_rec(t_type);
          if (valid_flag != 'Y')
          {
              delete_rec();
          }
          else
          {
              update_hdr_rec(t_type);

              if (nd_interface_mode.arr[0] == 'D')
                   gl_posting();
          }
		  
      }

      if (nd_interface_mode.arr[0] == 'S')
      {
          process_summary_1();
          process_summary_2();
      }

      /* EXEC SQL COMMIT WORK; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 12;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )95;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
         err_mesg("COMMIT failed",0,""); 

    }
    end_prog_msg();
    end_prog_control();



    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )110;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )125;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqlcmax = (unsigned int )100;
  sqlstm.sqlcmin = (unsigned int )2;
  sqlstm.sqlcincr = (unsigned int )1;
  sqlstm.sqlctimeout = (unsigned int )0;
  sqlstm.sqlcnowait = (unsigned int )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

delete_prog_param()
{
   /* EXEC SQL DELETE
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBGLEXP'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARBGLEXP' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )156;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[1] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   /* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )179;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
         err_mesg("COMMIT failed",0,""); 
}

fetch_ar_param()
{
   ar_interface_code.arr[0]    = '\0';
   ar_interface_code.len       = 0;

   /* EXEC SQL SELECT NVL(AR_INTERFACE_CODE,'N')
              INTO :ar_interface_code
              FROM AR_PARAMETER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(AR_INTERFACE_CODE,'N') into :b0  from AR_PARAME\
TER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )194;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_interface_code;
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
         err_mesg("SELECT failed on table AR_PARAMETER",0,"");

   ar_interface_code.arr[ar_interface_code.len]      = '\0';


   /* EXEC SQL SELECT CURRENT_ACC_YEAR,CURRENT_ACC_MONTH,
                   NVL(SUMMARY_PROCESS_FLAG,'X') 
              INTO :d_curr_year,    :d_curr_month,
                   :d_summ_flag
              FROM GL_PARAMETER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CURRENT_ACC_YEAR ,CURRENT_ACC_MONTH ,NVL(SUMMARY_PR\
OCESS_FLAG,'X') into :b0,:b1,:b2  from GL_PARAMETER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )213;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_year;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_curr_month;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_summ_flag;
   sqlstm.sqhstl[2] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table GL_PARAMETER",0,"");

    if (NOT_FOUND)
        err_mesg("Record not maintained in GL_PARAMETER",0,"");

}  
 
declare_cursors() 
{ 
 
    /* EXEC SQL DECLARE AR_INV_HDR_CUR CURSOR FOR
              SELECT ACC_ENTITY_CODE,
                     DOC_TYPE_CODE, 
                     DOC_NUM,
                     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                     NVL(CUST_REF,' '),
                     NVL(NARRATION,' '),
                     NVL(POST_MONTH,0),
                     NVL(POST_YEAR,0),
                     NVL(MAIN_ACC1_CODE_NEW,' '),
                     NVL(MAIN_ACC2_CODE_NEW,' '),
                     NVL(DEPT_CODE_NEW,' '),
                     NVL(PRODUCT_GROUP_CODE_NEW,' '),
                     NVL(PRODUCT_LINE_CODE_NEW,' '),
                     NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                     NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                     PAYABLE_AMT,
					 NVL(PAYABLE_AMT,0),
					 SIGN(PAYABLE_AMT),
                     DECODE(SIGN(PAYABLE_AMT),-1,-PAYABLE_AMT,PAYABLE_AMT),
					 CUST_CODE,
                     ROWID   
                FROM AR_INV_HDR
               WHERE POSTED_FLAG  = 'Y' 
                 AND INTERFACE_FLAG = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     :nd_exp_year||:nd_exp_month; */ 


    /* EXEC SQL DECLARE AR_DN_HDR_CUR CURSOR FOR
              SELECT ACC_ENTITY_CODE,
			         DOC_TYPE_CODE, 
                     DOC_NUM,
                     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                     POST_MONTH,
                     POST_YEAR,
                     ROWID
                FROM AR_DN_HDR
               WHERE POSTED_FLAG  = 'Y' 
                 AND INTERFACE_FLAG = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     :nd_exp_year||:nd_exp_month; */ 


    /* EXEC SQL DECLARE AR_CN_HDR_CUR CURSOR FOR
              SELECT ACC_ENTITY_CODE,
			         DOC_TYPE_CODE, 
                     DOC_NUM,
                     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                     POST_MONTH,
                     POST_YEAR,
                     ROWID
                FROM AR_CN_HDR
               WHERE POSTED_FLAG  = 'Y' 
                 AND INTERFACE_FLAG = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     :nd_exp_year||:nd_exp_month; */ 


    /* EXEC SQL DECLARE AR_ADJ_HDR_CUR CURSOR FOR
              SELECT ACC_ENTITY_CODE,
			         DOC_TYPE_CODE, 
                     DOC_NUM,
                     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                     POST_MONTH,
                     POST_YEAR,
                     ROWID
                FROM AR_ADJ_HDR
               WHERE POSTED_FLAG  = 'Y' 
                 AND INTERFACE_FLAG = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     :nd_exp_year||:nd_exp_month; */ 


    /* EXEC SQL DECLARE AR_REC_HDR_CUR CURSOR FOR
              SELECT ACC_ENTITY_CODE,
			         DOC_TYPE_CODE, 
                     DOC_NUM,
                     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                     NVL(DOC_REF,' '),
                     NVL(NARRATION,' '),
                     POST_MONTH,
                     POST_YEAR,
                     NVL(MAIN_ACC1_CODE,' '),
                     NVL(MAIN_ACC2_CODE,' '),
                     NVL(DEPT_CODE,' '),
                     NVL(PRODUCT_GROUP_CODE,' '),
                     NVL(PRODUCT_LINE_CODE,' '),
                     NVL(SUBLEDGER_GROUP_CODE,' '),
                     NVL(SUBLEDGER_LINE_CODE,' '),
                     NVL(AMT_LOCAL,0),
                     AMT_LOCAL,
                     SIGN(AMT_LOCAL),
                     DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL),
                     CHEQUE_NUM,
                     to_char(CHEQUE_DATE,'DD/MM/YYYY'),
					 CUST_CODE,
                     ROWID
                FROM AR_REC_HDR
               WHERE POSTED_FLAG  = 'Y' 
                 AND INTERFACE_FLAG = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     :nd_exp_year||:nd_exp_month; */ 


    /* EXEC SQL DECLARE AR_OFF_REC_HDR_CUR CURSOR FOR
              SELECT ACC_ENTITY_CODE, 
                     NVL(NARRATION,' '),
                     NVL(MAIN_ACC1_CODE_BANK,' '),
                     NVL(MAIN_ACC2_CODE_BANK,' '),
                     NVL(DEPT_CODE_BANK,' '),                     
                     NVL(PRODUCT_GROUP_CODE_BANK,' '),
                     NVL(PRODUCT_LINE_CODE_BANK,' '),
                     NVL(SUBLEDGER_GROUP_CODE_BANK,' '),
                     NVL(SUBLEDGER_LINE_CODE_BANK,' '),
                     AMT_LOCAL,
			         NVL(MAIN_ACC1_CODE_SUSP,' '),
                     NVL(MAIN_ACC2_CODE_SUSP,' '),
                     NVL(DEPT_CODE_SUSP,' '),
                     NVL(PRODUCT_GROUP_CODE_SUSP,' '),
                     NVL(PRODUCT_LINE_CODE_SUSP,' '),
                     NVL(SUBLEDGER_GROUP_CODE_SUSP,' '),
                     NVL(SUBLEDGER_LINE_CODE_SUSP,' '),
                     -1 * AMT_LOCAL,
                     AMT_LOCAL,
                     SIGN(AMT_LOCAL),
                     DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL),
                     CHEQUE_NUM,
                     to_char(CHEQUE_DATE,'DD/MM/YYYY'),
					 CUST_CODE,
					 ROWID
                FROM AR_CASHIER  
                WHERE DOC_TYPE_CODE = :d_ar_hdr_doc_type_code
                 AND DOC_NUM        = :d_ar_hdr_doc_num; */ 



    /* EXEC SQL DECLARE AR_PAY_HDR_CUR CURSOR FOR
              SELECT ACC_ENTITY_CODE,
			         DOC_TYPE_CODE,
                     DOC_NUM,
                     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                     NVL(CHEQUE_NUM,' '),
                     NVL(NARRATION,' '),
                     NVL(POST_MONTH,0),
                     NVL(POST_YEAR,0),
                     NVL(MAIN_ACC1_CODE_NEW,' '),
                     NVL(MAIN_ACC2_CODE_NEW,' '),
                     NVL(DEPT_CODE_NEW,' '),
                     NVL(PRODUCT_GROUP_CODE_NEW,' '),
                     NVL(PRODUCT_LINE_CODE_NEW,' '),
                     NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                     NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                     -1 * AMT_LOCAL,
                     AMT_LOCAL,
                     SIGN(AMT_LOCAL),
                     DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL),
                     CHEQUE_NUM,
                     to_char(CHEQUE_DATE,'DD/MM/YYYY'),
					 CUST_CODE,
                     ROWID
                FROM AR_PAY_HDR
               WHERE POSTED_FLAG  = 'Y' 
                 AND INTERFACE_FLAG = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     :nd_exp_year||:nd_exp_month; */ 


    /* EXEC SQL DECLARE AR_INV_LINE_CUR CURSOR FOR
              SELECT MAIN_ACC1_CODE_NEW,
                     NVL(MAIN_ACC2_CODE_NEW,' '),
                     NVL(DEPT_CODE_NEW,' '),
                     NVL(PRODUCT_GROUP_CODE_NEW,' '),
                     NVL(PRODUCT_LINE_CODE_NEW,' '),
                     NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                     NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                     -1 * AMT_LOCAL,
                     AMT_LOCAL,
                     SIGN(AMT_LOCAL),
                     DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL),
                     NVL(NARRATION,' ')
                FROM AR_INV_LINE
               WHERE DOC_TYPE_CODE = :d_ar_hdr_doc_type_code
                 AND DOC_NUM       = :d_ar_hdr_doc_num; */ 


   /* EXEC SQL DECLARE AR_DN_INV_HDR_CUR CURSOR FOR
             SELECT ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    NVL(NARRATION,' '),
                    NVL(CUST_REF,' '),
                    NVL(MAIN_ACC1_CODE_NEW,' '),
                    NVL(MAIN_ACC2_CODE_NEW,' '),
                    NVL(DEPT_CODE_NEW,' '),
                    NVL(PRODUCT_GROUP_CODE_NEW,' '),
                    NVL(PRODUCT_LINE_CODE_NEW,' '),
                    NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                    NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                    DOC_AMT,
                    -1 * DOC_AMT,
                    SIGN(DOC_AMT),
                    DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
					CUST_CODE
               FROM AR_DN_INV_HDR
              WHERE DOC_TYPE_CODE = :d_ar_hdr_doc_type_code
                AND DOC_NUM       = :d_ar_hdr_doc_num; */ 



   /* EXEC SQL DECLARE AR_DN_LINE_CUR  CURSOR FOR
             SELECT NVL(MAIN_ACC1_CODE_NEW,' '),
                    NVL(MAIN_ACC2_CODE_NEW,' '),
                    NVL(DEPT_CODE_NEW,' '),
                    NVL(PRODUCT_GROUP_CODE_NEW,' '),
                    NVL(PRODUCT_LINE_CODE_NEW,' '),
                    NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                    NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                    -1 * AMOUNT,
					AMOUNT,
                    SIGN(AMOUNT),
                    DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT),
                    NVL(NARRATION, ' ')
               FROM AR_DN_LINE
              WHERE DOC_TYPE_CODE     = :d_ar_hdr_doc_type_code
                AND DOC_NUM           = :d_ar_hdr_doc_num
                AND ORG_DOC_TYPE_CODE = :d_ar_hdr_org_doc_type_code
                AND ORG_DOC_NUM       = :d_ar_hdr_org_doc_num; */ 


   /* EXEC SQL DECLARE AR_CN_INV_HDR_CUR CURSOR FOR    
             SELECT ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    NVL(NARRATION,' '),
                    NVL(CUST_REF,' '),
                    NVL(MAIN_ACC1_CODE_NEW,' '),
                    NVL(MAIN_ACC2_CODE_NEW,' '),
                    NVL(DEPT_CODE_NEW,' '),
                    NVL(PRODUCT_GROUP_CODE_NEW,' '),
                    NVL(PRODUCT_LINE_CODE_NEW,' '),
                    NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                    NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                    -1 * DOC_AMT,
                    DOC_AMT,
                    SIGN(DOC_AMT),
                    DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
					CUST_CODE
               FROM AR_CN_INV_HDR
              WHERE DOC_TYPE_CODE = :d_ar_hdr_doc_type_code
                AND DOC_NUM       = :d_ar_hdr_doc_num; */ 



   /* EXEC SQL DECLARE AR_CN_LINE_CUR  CURSOR FOR
             SELECT NVL(MAIN_ACC1_CODE_NEW,' '),
                    NVL(MAIN_ACC2_CODE_NEW,' '),
                    NVL(DEPT_CODE_NEW,' '),
                    NVL(PRODUCT_GROUP_CODE_NEW,' '),
                    NVL(PRODUCT_LINE_CODE_NEW,' '),
                    NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                    NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                    NVL(AMOUNT,0),
                    AMOUNT,
                    SIGN(AMOUNT),
                    DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT),
                    NVL(NARRATION,' ')
               FROM AR_CN_LINE
              WHERE DOC_TYPE_CODE     = :d_ar_hdr_doc_type_code
                AND DOC_NUM           = :d_ar_hdr_doc_num
                AND ORG_DOC_TYPE_CODE = :d_ar_hdr_org_doc_type_code
                AND ORG_DOC_NUM       = :d_ar_hdr_org_doc_num; */ 


   /* EXEC SQL DECLARE AR_ADJ_INV_HDR_CUR CURSOR FOR
             SELECT ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    NVL(NARRATION,' '),
                    NVL(CUST_REF,' '),
                    NVL(MAIN_ACC1_CODE_NEW,' '),
                    NVL(MAIN_ACC2_CODE_NEW,' '),
                    NVL(DEPT_CODE_NEW,' '),
                    NVL(PRODUCT_GROUP_CODE_NEW,' '),
                    NVL(PRODUCT_LINE_CODE_NEW,' '),  
                    NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                    NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                    NVL(ADJ_TYPE,' '),
                    DECODE(ADJ_TYPE,'D',DOC_AMT,-1 * DOC_AMT),
                    DOC_AMT,
                    SIGN(DOC_AMT),
                    DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
					CUST_CODE
               FROM AR_ADJ_INV_HDR
              WHERE DOC_TYPE_CODE = :d_ar_hdr_doc_type_code
                AND DOC_NUM       = :d_ar_hdr_doc_num; */ 



   /* EXEC SQL DECLARE AR_ADJ_LINE_CUR  CURSOR FOR
             SELECT NVL(MAIN_ACC1_CODE_NEW,' '),
                    NVL(MAIN_ACC2_CODE_NEW,' '),
                    NVL(DEPT_CODE_NEW,' '),
                    NVL(PRODUCT_GROUP_CODE_NEW,' '),
                    NVL(PRODUCT_LINE_CODE_NEW,' '),
                    NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                    NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                    DECODE(:d_ar_hdr_adj_type,'D',-1 * AMOUNT,AMOUNT),
                    AMOUNT,
                    SIGN(AMOUNT),
                    DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT),
                    NVL(NARRATION,' ')
               FROM AR_ADJ_LINE
              WHERE DOC_TYPE_CODE     = :d_ar_hdr_doc_type_code
                AND DOC_NUM           = :d_ar_hdr_doc_num
                AND ORG_DOC_TYPE_CODE = :d_ar_hdr_org_doc_type_code
                AND ORG_DOC_NUM       = :d_ar_hdr_org_doc_num; */ 


   /* EXEC SQL DECLARE AR_REC_LINE_CUR  CURSOR FOR
             SELECT NVL(MAIN_ACC1_CODE_NEW,' '),
                    NVL(MAIN_ACC2_CODE_NEW,' '),
                    NVL(DEPT_CODE_NEW,' '),   
                    NVL(PRODUCT_GROUP_CODE_NEW,' '),
                    NVL(PRODUCT_LINE_CODE_NEW,' '),
                    NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                    NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                    -1 * AMT_LOCAL,
                    AMT_LOCAL,
                    SIGN(AMT_LOCAL),
                    DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL),
                    NVL(NARRATION, ' ')
               FROM AR_REC_LINE
              WHERE DOC_TYPE_CODE     = :d_ar_hdr_doc_type_code
                AND DOC_NUM           = :d_ar_hdr_doc_num; */ 

     
   /* EXEC SQL DECLARE AR_PAY_LINE_CUR  CURSOR FOR
             SELECT NVL(MAIN_ACC1_CODE_NEW,' '),
                    NVL(MAIN_ACC2_CODE_NEW,' '),
                    NVL(DEPT_CODE_NEW,' '),
                    NVL(PRODUCT_GROUP_CODE_NEW,' '),
                    NVL(PRODUCT_LINE_CODE_NEW,' '),
                    NVL(SUBLEDGER_GROUP_CODE_NEW,' '),
                    NVL(SUBLEDGER_LINE_CODE_NEW,' '),
                    NVL(AMT_LOCAL,0),
                    AMT_LOCAL,
                    SIGN(AMT_LOCAL),
                    DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL),
                    NVL(NARRATION,' ')
               FROM AR_PAY_LINE
              WHERE DOC_TYPE_CODE     = :d_ar_hdr_doc_type_code
                AND DOC_NUM           = :d_ar_hdr_doc_num; */ 


   /* EXEC SQL DECLARE GL_POSTING_ACC_CUR CURSOR FOR
             SELECT NVL(BANK_RECONCILE_FLAG,'N')
               FROM GL_POSTING_ACC
              WHERE MAIN_ACC1_CODE       = :d_chk_main_acc1_code
                AND MAIN_ACC2_CODE       = :d_chk_main_acc2_code
                AND DEPT_CODE            = :d_chk_dept_code
                AND PRODUCT_GROUP_CODE   = :d_chk_product_group_code
                AND PRODUCT_LINE_CODE    = :d_chk_product_line_code
                AND SUBLEDGER_GROUP_CODE = :d_chk_sub_group_code
                AND SUBLEDGER_LINE_CODE  = :d_chk_sub_line_code; */ 


   /* EXEC SQL DECLARE AR_GL_DISTRBN_TEMP_CUR1 CURSOR FOR
             SELECT POST_MONTH,
                    POST_YEAR,
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    SUM(DEBIT_AMT)
               FROM AR_GL_DISTRBN_TEMP
              WHERE NVL(TRN_TYPE_CODE,'N') = 'N'
              GROUP BY POST_MONTH,
                       POST_YEAR,
                       MAIN_ACC1_CODE,
                       MAIN_ACC2_CODE,
                       DEPT_CODE,
                       PRODUCT_GROUP_CODE,
                       PRODUCT_LINE_CODE,
                       SUBLEDGER_GROUP_CODE,
                       SUBLEDGER_LINE_CODE; */ 


   /* EXEC SQL DECLARE AR_GL_DISTRBN_TEMP_CUR2 CURSOR FOR
             SELECT DOC_TYPE_CODE,
                    DOC_NUM,
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    NVL(DOC_REF,' '),
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    NVL(DEBIT_AMT,0),
                    NVL(NARRATION,' '),
                    POST_MONTH,
                    POST_YEAR,
					CHEQUE_NUM
               FROM AR_GL_DISTRBN_TEMP
              WHERE TRN_TYPE_CODE = 'Y'
              ORDER BY DOC_TYPE_CODE,DOC_NUM,DOC_REF,NARRATION; */ 


}

delete_gl_distrbn()
{
    /* EXEC SQL DELETE FROM AR_GL_DISTRBN_TEMP; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from AR_GL_DISTRBN_TEMP ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )240;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("DELETE failed on table AR_GL_DISTRBN_TEMP",0,"");

    /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )255;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("COMMIT failed",0,"");
}

lock_tables(l_type)
int l_type;
{

     /* EXEC SQL LOCK TABLE AR_GL_DISTRBN_TEMP
                IN EXCLUSIVE MODE NOWAIT; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "lock TABLE AR_GL_DISTRBN_TEMP IN EXCLUSIVE MODE NOWAIT";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )270;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     if (RESOURCE_BUSY)
      err_mesg("AR_GL_DISTRBN_TEMP table could not be locked for exclusive use",
                        0,"");
     else if (OERROR)
         err_mesg("LOCK failed on table AR_GL_DISTRBN_TEMP",0,"");
             
     switch(l_type)
     {
        case 1 : 
                  strcpy(nd_tmp_doc_type_code.arr,nd_inv_doc_type_code.arr);

                  /* EXEC SQL LOCK TABLE AR_INV_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_INV_HDR IN EXCLUSIVE MODE NOW\
AIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )285;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2230");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_INV_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_INV_LINE
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_INV_LINE IN EXCLUSIVE MODE NO\
WAIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )300;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2230");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_INV_LINE",0,"");
                  break;
        case 2 :  
                  strcpy(nd_tmp_doc_type_code.arr,nd_dn_doc_type_code.arr);

                  /* EXEC SQL LOCK TABLE AR_DN_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_DN_HDR IN EXCLUSIVE MODE NOWA\
IT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )315;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2240");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_DN_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_DN_INV_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_DN_INV_HDR IN EXCLUSIVE MODE \
NOWAIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )330;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2240");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_DN_INV_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_DN_LINE
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_DN_LINE IN EXCLUSIVE MODE NOW\
AIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )345;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2240");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_DN_LINE",0,"");
                  break;
        case 3 :  
                  strcpy(nd_tmp_doc_type_code.arr,nd_cn_doc_type_code.arr);

                  /* EXEC SQL LOCK TABLE AR_CN_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_CN_HDR IN EXCLUSIVE MODE NOWA\
IT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )360;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2250");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_CN_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_CN_INV_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_CN_INV_HDR IN EXCLUSIVE MODE \
NOWAIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )375;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2250");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_CN_INV_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_CN_LINE
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_CN_LINE IN EXCLUSIVE MODE NOW\
AIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )390;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2250");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_CN_LINE",0,"");
                  break;
        case 4 :  
                  strcpy(nd_tmp_doc_type_code.arr,nd_adj_doc_type_code.arr);

                  /* EXEC SQL LOCK TABLE AR_ADJ_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_ADJ_HDR IN EXCLUSIVE MODE NOW\
AIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )405;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2260");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_ADJ_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_ADJ_INV_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_ADJ_INV_HDR IN EXCLUSIVE MODE\
 NOWAIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )420;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2260");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_ADJ_INV_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_ADJ_LINE
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_ADJ_LINE IN EXCLUSIVE MODE NO\
WAIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )435;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2260");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_ADJ_LINE",0,"");
                  break;
        case 5 :  
                  strcpy(nd_tmp_doc_type_code.arr,nd_rec_doc_type_code.arr);

                  /* EXEC SQL LOCK TABLE AR_REC_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_REC_HDR IN EXCLUSIVE MODE NOW\
AIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )450;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2270");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_REC_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_REC_LINE
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_REC_LINE IN EXCLUSIVE MODE NO\
WAIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )465;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2270");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_REC_LINE",0,"");
                  break;
        case 6 :  
                  strcpy(nd_tmp_doc_type_code.arr,nd_pay_doc_type_code.arr);

                  /* EXEC SQL LOCK TABLE AR_PAY_HDR
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_PAY_HDR IN EXCLUSIVE MODE NOW\
AIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )480;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2280");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_PAY_HDR",0,"");

                  /* EXEC SQL LOCK TABLE AR_PAY_LINE
                             IN EXCLUSIVE MODE NOWAIT; */ 

{
                  struct sqlexd sqlstm;
                  sqlstm.sqlvsn = 12;
                  sqlstm.arrsiz = 12;
                  sqlstm.sqladtp = &sqladt;
                  sqlstm.sqltdsp = &sqltds;
                  sqlstm.stmt = "lock TABLE AR_PAY_LINE IN EXCLUSIVE MODE NO\
WAIT";
                  sqlstm.iters = (unsigned int  )1;
                  sqlstm.offset = (unsigned int  )495;
                  sqlstm.cud = sqlcud0;
                  sqlstm.sqlest = (unsigned char  *)&sqlca;
                  sqlstm.sqlety = (unsigned short)4352;
                  sqlstm.occurs = (unsigned int  )0;
                  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                  if (RESOURCE_BUSY)
                       err_mesg("",1,"AR2280");
                   else if (OERROR)
                       err_mesg("LOCK failed on table AR_PAY_LINE",0,"");
                  break;
     }

     nd_tmp_doc_type_code.len = strlen(nd_tmp_doc_type_code.arr);

     if (nd_interface_mode.arr[0] == 'S')
     {
     /* EXEC SQL SELECT ROWID
                INTO :d_sy_acc_rowid
                FROM SY_ACC_ENTITY_DOC_TYPE
               WHERE DOC_TYPE_CODE = :nd_tmp_doc_type_code
                 FOR UPDATE OF NEXT_DOC_NO; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select ROWID into :b0  from SY_ACC_ENTITY_DOC_TYPE where\
 DOC_TYPE_CODE=:b1 for update of NEXT_DOC_NO ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )510;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_sy_acc_rowid;
     sqlstm.sqhstl[0] = (unsigned int  )33;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_tmp_doc_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
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



     if (RESOURCE_BUSY)
         err_mesg("",1,"AR2310");
     else if (OERROR)
         err_mesg("SELECT failed on table SY_ACC_ENTITY_DOC_TYPE",0,"");
     else if (NOT_FOUND)
         err_mesg("",1,"SY1610");
     }
}

open_hdr(l_type)
int l_type;
{

     switch(l_type)
     {
        case 1 :  
                 /* EXEC SQL OPEN AR_INV_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 12;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0010;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )533;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&nd_exp_year;
                 sqlstm.sqhstl[0] = (unsigned int  )7;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&nd_exp_month;
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
                      err_mesg("OPEN failed on cursor AR_INV_HDR_CUR",0,"");
                 break;
        case 2 :  
                 /* EXEC SQL OPEN AR_DN_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 12;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0011;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )556;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&nd_exp_year;
                 sqlstm.sqhstl[0] = (unsigned int  )7;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&nd_exp_month;
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
                      err_mesg("OPEN failed on cursor AR_DN_HDR_CUR",0,"");
                 break;
        case 3 :  
                 /* EXEC SQL OPEN AR_CN_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 12;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0012;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )579;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&nd_exp_year;
                 sqlstm.sqhstl[0] = (unsigned int  )7;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&nd_exp_month;
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
                      err_mesg("OPEN failed on cursor AR_CN_HDR_CUR",0,"");
                 break;
        case 4 :  
                 /* EXEC SQL OPEN AR_ADJ_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 12;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0013;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )602;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&nd_exp_year;
                 sqlstm.sqhstl[0] = (unsigned int  )7;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&nd_exp_month;
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
                      err_mesg("OPEN failed on cursor AR_ADJ_HDR_CUR",0,"");
                 break;
        case 5 :  
                 /* EXEC SQL OPEN AR_REC_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 12;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0014;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )625;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&nd_exp_year;
                 sqlstm.sqhstl[0] = (unsigned int  )7;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&nd_exp_month;
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
                      err_mesg("OPEN failed on cursor AR_REC_HDR_CUR",0,"");
                 break;
        case 6 :  
                 /* EXEC SQL OPEN AR_PAY_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 12;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0016;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )648;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&nd_exp_year;
                 sqlstm.sqhstl[0] = (unsigned int  )7;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&nd_exp_month;
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
                      err_mesg("OPEN failed on cursor AR_PAY_HDR_CUR",0,"");
                 break;
       }
}

fetch_hdr(l_type)
int l_type;
{

   init_hdr_variables(l_type);

   valid_flag = 'Y';
   d_ar_run_line_num = 0;
   
   switch (l_type)
   {
       case 1 :
             /* EXEC SQL FETCH AR_INV_HDR_CUR
                       INTO :d_acc_entity_code,
					        :d_ar_hdr_doc_type_code, 
                            :d_ar_hdr_doc_num,
                            :d_ar_hdr_doc_date,
                            :d_ar_hdr_cust_ref,
                            :d_ar_hdr_narration,
                            :d_ar_hdr_post_month,
                            :d_ar_hdr_post_year,
                            :d_ar_hdr_main_acc1_code,
                            :d_ar_hdr_main_acc2_code,
                            :d_ar_hdr_dept_code,
                            :d_ar_hdr_product_group_code,
                            :d_ar_hdr_product_line_code,
                            :d_ar_hdr_sub_group_code,
                            :d_ar_hdr_sub_line_code,
                            :d_ar_hdr_amount,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
							:d_cust_code,
                            :d_ar_hdr_rowid; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 21;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )671;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_code;
             sqlstm.sqhstl[0] = (unsigned int  )7;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
             sqlstm.sqhstl[2] = (unsigned int  )11;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_doc_date;
             sqlstm.sqhstl[3] = (unsigned int  )14;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_cust_ref;
             sqlstm.sqhstl[4] = (unsigned int  )18;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_narration;
             sqlstm.sqhstl[5] = (unsigned int  )53;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_post_month;
             sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_post_year;
             sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_main_acc1_code;
             sqlstm.sqhstl[8] = (unsigned int  )11;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_main_acc2_code;
             sqlstm.sqhstl[9] = (unsigned int  )9;
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_dept_code;
             sqlstm.sqhstl[10] = (unsigned int  )9;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_product_group_code;
             sqlstm.sqhstl[11] = (unsigned int  )6;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
             sqlstm.sqhstv[12] = (         void  *)&d_ar_hdr_product_line_code;
             sqlstm.sqhstl[12] = (unsigned int  )7;
             sqlstm.sqhsts[12] = (         int  )0;
             sqlstm.sqindv[12] = (         void  *)0;
             sqlstm.sqinds[12] = (         int  )0;
             sqlstm.sqharm[12] = (unsigned int  )0;
             sqlstm.sqadto[12] = (unsigned short )0;
             sqlstm.sqtdso[12] = (unsigned short )0;
             sqlstm.sqhstv[13] = (         void  *)&d_ar_hdr_sub_group_code;
             sqlstm.sqhstl[13] = (unsigned int  )6;
             sqlstm.sqhsts[13] = (         int  )0;
             sqlstm.sqindv[13] = (         void  *)0;
             sqlstm.sqinds[13] = (         int  )0;
             sqlstm.sqharm[13] = (unsigned int  )0;
             sqlstm.sqadto[13] = (unsigned short )0;
             sqlstm.sqtdso[13] = (unsigned short )0;
             sqlstm.sqhstv[14] = (         void  *)&d_ar_hdr_sub_line_code;
             sqlstm.sqhstl[14] = (unsigned int  )11;
             sqlstm.sqhsts[14] = (         int  )0;
             sqlstm.sqindv[14] = (         void  *)0;
             sqlstm.sqinds[14] = (         int  )0;
             sqlstm.sqharm[14] = (unsigned int  )0;
             sqlstm.sqadto[14] = (unsigned short )0;
             sqlstm.sqtdso[14] = (unsigned short )0;
             sqlstm.sqhstv[15] = (         void  *)&d_ar_hdr_amount;
             sqlstm.sqhstl[15] = (unsigned int  )19;
             sqlstm.sqhsts[15] = (         int  )0;
             sqlstm.sqindv[15] = (         void  *)0;
             sqlstm.sqinds[15] = (         int  )0;
             sqlstm.sqharm[15] = (unsigned int  )0;
             sqlstm.sqadto[15] = (unsigned short )0;
             sqlstm.sqtdso[15] = (unsigned short )0;
             sqlstm.sqhstv[16] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[16] = (unsigned int  )19;
             sqlstm.sqhsts[16] = (         int  )0;
             sqlstm.sqindv[16] = (         void  *)0;
             sqlstm.sqinds[16] = (         int  )0;
             sqlstm.sqharm[16] = (unsigned int  )0;
             sqlstm.sqadto[16] = (unsigned short )0;
             sqlstm.sqtdso[16] = (unsigned short )0;
             sqlstm.sqhstv[17] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[17] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[17] = (         int  )0;
             sqlstm.sqindv[17] = (         void  *)0;
             sqlstm.sqinds[17] = (         int  )0;
             sqlstm.sqharm[17] = (unsigned int  )0;
             sqlstm.sqadto[17] = (unsigned short )0;
             sqlstm.sqtdso[17] = (unsigned short )0;
             sqlstm.sqhstv[18] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[18] = (unsigned int  )19;
             sqlstm.sqhsts[18] = (         int  )0;
             sqlstm.sqindv[18] = (         void  *)0;
             sqlstm.sqinds[18] = (         int  )0;
             sqlstm.sqharm[18] = (unsigned int  )0;
             sqlstm.sqadto[18] = (unsigned short )0;
             sqlstm.sqtdso[18] = (unsigned short )0;
             sqlstm.sqhstv[19] = (         void  *)&d_cust_code;
             sqlstm.sqhstl[19] = (unsigned int  )11;
             sqlstm.sqhsts[19] = (         int  )0;
             sqlstm.sqindv[19] = (         void  *)0;
             sqlstm.sqinds[19] = (         int  )0;
             sqlstm.sqharm[19] = (unsigned int  )0;
             sqlstm.sqadto[19] = (unsigned short )0;
             sqlstm.sqtdso[19] = (unsigned short )0;
             sqlstm.sqhstv[20] = (         void  *)&d_ar_hdr_rowid;
             sqlstm.sqhstl[20] = (unsigned int  )33;
             sqlstm.sqhsts[20] = (         int  )0;
             sqlstm.sqindv[20] = (         void  *)0;
             sqlstm.sqinds[20] = (         int  )0;
             sqlstm.sqharm[20] = (unsigned int  )0;
             sqlstm.sqadto[20] = (unsigned short )0;
             sqlstm.sqtdso[20] = (unsigned short )0;
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
                  err_mesg("FETCH failed on cursor AR_INV_HDR_CUR",0,"");
             break;   
       case 2 :
             /* EXEC SQL FETCH AR_DN_HDR_CUR
                       INTO :d_acc_entity_code,
					        :d_ar_hdr_doc_type_code, 
                            :d_ar_hdr_doc_num,
                            :d_ar_hdr_doc_date,
                            :d_ar_hdr_post_month,
                            :d_ar_hdr_post_year,
                            :d_ar_hdr_rowid; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 21;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )770;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_code;
             sqlstm.sqhstl[0] = (unsigned int  )7;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
             sqlstm.sqhstl[2] = (unsigned int  )11;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_doc_date;
             sqlstm.sqhstl[3] = (unsigned int  )14;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_post_month;
             sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_post_year;
             sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_rowid;
             sqlstm.sqhstl[6] = (unsigned int  )33;
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
                 err_mesg("FETCH failed on cursor AR_DN_HDR_CUR",0,"");
             break; 
       case 3 :
             /* EXEC SQL FETCH AR_CN_HDR_CUR
                       INTO :d_acc_entity_code,
					        :d_ar_hdr_doc_type_code, 
                            :d_ar_hdr_doc_num,
                            :d_ar_hdr_doc_date,
                            :d_ar_hdr_post_month,
                            :d_ar_hdr_post_year,
                            :d_ar_hdr_rowid; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 21;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )813;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_code;
             sqlstm.sqhstl[0] = (unsigned int  )7;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
             sqlstm.sqhstl[2] = (unsigned int  )11;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_doc_date;
             sqlstm.sqhstl[3] = (unsigned int  )14;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_post_month;
             sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_post_year;
             sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_rowid;
             sqlstm.sqhstl[6] = (unsigned int  )33;
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
                 err_mesg("FETCH failed on cursor AR_CN_HDR_CUR",0,"");
             break;
       case 4 :
             /* EXEC SQL FETCH AR_ADJ_HDR_CUR
                       INTO :d_acc_entity_code,
					        :d_ar_hdr_doc_type_code, 
                            :d_ar_hdr_doc_num,
                            :d_ar_hdr_doc_date,
                            :d_ar_hdr_post_month,
                            :d_ar_hdr_post_year,
                            :d_ar_hdr_rowid; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 21;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )856;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_code;
             sqlstm.sqhstl[0] = (unsigned int  )7;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
             sqlstm.sqhstl[2] = (unsigned int  )11;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_doc_date;
             sqlstm.sqhstl[3] = (unsigned int  )14;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_post_month;
             sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_post_year;
             sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_rowid;
             sqlstm.sqhstl[6] = (unsigned int  )33;
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
                 err_mesg("FETCH failed on cursor AR_ADJ_HDR_CUR",0,"");
             break;
       case 5 :
             /* EXEC SQL FETCH AR_REC_HDR_CUR
                       INTO :d_acc_entity_code,
					        :d_ar_hdr_doc_type_code, 
                            :d_ar_hdr_doc_num,
                            :d_ar_hdr_doc_date,
                            :d_ar_hdr_cust_ref,
                            :d_ar_hdr_narration,
                            :d_ar_hdr_post_month,
                            :d_ar_hdr_post_year,
                            :d_ar_hdr_main_acc1_code,
                            :d_ar_hdr_main_acc2_code,
                            :d_ar_hdr_dept_code,
                            :d_ar_hdr_product_group_code,
                            :d_ar_hdr_product_line_code,
                            :d_ar_hdr_sub_group_code,
                            :d_ar_hdr_sub_line_code,
                            :d_ar_hdr_amount,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :l_gd_cheque_num,
                            :l_gd_cheque_date,
							:d_cust_code,
                            :d_ar_hdr_rowid; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 23;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )899;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_code;
             sqlstm.sqhstl[0] = (unsigned int  )7;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
             sqlstm.sqhstl[2] = (unsigned int  )11;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_doc_date;
             sqlstm.sqhstl[3] = (unsigned int  )14;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_cust_ref;
             sqlstm.sqhstl[4] = (unsigned int  )18;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_narration;
             sqlstm.sqhstl[5] = (unsigned int  )53;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_post_month;
             sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_post_year;
             sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_main_acc1_code;
             sqlstm.sqhstl[8] = (unsigned int  )11;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_main_acc2_code;
             sqlstm.sqhstl[9] = (unsigned int  )9;
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_dept_code;
             sqlstm.sqhstl[10] = (unsigned int  )9;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_product_group_code;
             sqlstm.sqhstl[11] = (unsigned int  )6;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
             sqlstm.sqhstv[12] = (         void  *)&d_ar_hdr_product_line_code;
             sqlstm.sqhstl[12] = (unsigned int  )7;
             sqlstm.sqhsts[12] = (         int  )0;
             sqlstm.sqindv[12] = (         void  *)0;
             sqlstm.sqinds[12] = (         int  )0;
             sqlstm.sqharm[12] = (unsigned int  )0;
             sqlstm.sqadto[12] = (unsigned short )0;
             sqlstm.sqtdso[12] = (unsigned short )0;
             sqlstm.sqhstv[13] = (         void  *)&d_ar_hdr_sub_group_code;
             sqlstm.sqhstl[13] = (unsigned int  )6;
             sqlstm.sqhsts[13] = (         int  )0;
             sqlstm.sqindv[13] = (         void  *)0;
             sqlstm.sqinds[13] = (         int  )0;
             sqlstm.sqharm[13] = (unsigned int  )0;
             sqlstm.sqadto[13] = (unsigned short )0;
             sqlstm.sqtdso[13] = (unsigned short )0;
             sqlstm.sqhstv[14] = (         void  *)&d_ar_hdr_sub_line_code;
             sqlstm.sqhstl[14] = (unsigned int  )11;
             sqlstm.sqhsts[14] = (         int  )0;
             sqlstm.sqindv[14] = (         void  *)0;
             sqlstm.sqinds[14] = (         int  )0;
             sqlstm.sqharm[14] = (unsigned int  )0;
             sqlstm.sqadto[14] = (unsigned short )0;
             sqlstm.sqtdso[14] = (unsigned short )0;
             sqlstm.sqhstv[15] = (         void  *)&d_ar_hdr_amount;
             sqlstm.sqhstl[15] = (unsigned int  )19;
             sqlstm.sqhsts[15] = (         int  )0;
             sqlstm.sqindv[15] = (         void  *)0;
             sqlstm.sqinds[15] = (         int  )0;
             sqlstm.sqharm[15] = (unsigned int  )0;
             sqlstm.sqadto[15] = (unsigned short )0;
             sqlstm.sqtdso[15] = (unsigned short )0;
             sqlstm.sqhstv[16] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[16] = (unsigned int  )19;
             sqlstm.sqhsts[16] = (         int  )0;
             sqlstm.sqindv[16] = (         void  *)0;
             sqlstm.sqinds[16] = (         int  )0;
             sqlstm.sqharm[16] = (unsigned int  )0;
             sqlstm.sqadto[16] = (unsigned short )0;
             sqlstm.sqtdso[16] = (unsigned short )0;
             sqlstm.sqhstv[17] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[17] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[17] = (         int  )0;
             sqlstm.sqindv[17] = (         void  *)0;
             sqlstm.sqinds[17] = (         int  )0;
             sqlstm.sqharm[17] = (unsigned int  )0;
             sqlstm.sqadto[17] = (unsigned short )0;
             sqlstm.sqtdso[17] = (unsigned short )0;
             sqlstm.sqhstv[18] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[18] = (unsigned int  )19;
             sqlstm.sqhsts[18] = (         int  )0;
             sqlstm.sqindv[18] = (         void  *)0;
             sqlstm.sqinds[18] = (         int  )0;
             sqlstm.sqharm[18] = (unsigned int  )0;
             sqlstm.sqadto[18] = (unsigned short )0;
             sqlstm.sqtdso[18] = (unsigned short )0;
             sqlstm.sqhstv[19] = (         void  *)&l_gd_cheque_num;
             sqlstm.sqhstl[19] = (unsigned int  )13;
             sqlstm.sqhsts[19] = (         int  )0;
             sqlstm.sqindv[19] = (         void  *)0;
             sqlstm.sqinds[19] = (         int  )0;
             sqlstm.sqharm[19] = (unsigned int  )0;
             sqlstm.sqadto[19] = (unsigned short )0;
             sqlstm.sqtdso[19] = (unsigned short )0;
             sqlstm.sqhstv[20] = (         void  *)&l_gd_cheque_date;
             sqlstm.sqhstl[20] = (unsigned int  )17;
             sqlstm.sqhsts[20] = (         int  )0;
             sqlstm.sqindv[20] = (         void  *)0;
             sqlstm.sqinds[20] = (         int  )0;
             sqlstm.sqharm[20] = (unsigned int  )0;
             sqlstm.sqadto[20] = (unsigned short )0;
             sqlstm.sqtdso[20] = (unsigned short )0;
             sqlstm.sqhstv[21] = (         void  *)&d_cust_code;
             sqlstm.sqhstl[21] = (unsigned int  )11;
             sqlstm.sqhsts[21] = (         int  )0;
             sqlstm.sqindv[21] = (         void  *)0;
             sqlstm.sqinds[21] = (         int  )0;
             sqlstm.sqharm[21] = (unsigned int  )0;
             sqlstm.sqadto[21] = (unsigned short )0;
             sqlstm.sqtdso[21] = (unsigned short )0;
             sqlstm.sqhstv[22] = (         void  *)&d_ar_hdr_rowid;
             sqlstm.sqhstl[22] = (unsigned int  )33;
             sqlstm.sqhsts[22] = (         int  )0;
             sqlstm.sqindv[22] = (         void  *)0;
             sqlstm.sqinds[22] = (         int  )0;
             sqlstm.sqharm[22] = (unsigned int  )0;
             sqlstm.sqadto[22] = (unsigned short )0;
             sqlstm.sqtdso[22] = (unsigned short )0;
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
                 err_mesg("FETCH failed on cursor AR_ADJ_HDR_CUR",0,"");
             break;
       case 6 :
             /* EXEC SQL FETCH AR_PAY_HDR_CUR
                       INTO :d_acc_entity_code,
					        :d_ar_hdr_doc_type_code, 
                            :d_ar_hdr_doc_num,
                            :d_ar_hdr_doc_date,
                            :d_ar_hdr_cust_ref,
                            :d_ar_hdr_narration,
                            :d_ar_hdr_post_month,
                            :d_ar_hdr_post_year,
                            :d_ar_hdr_main_acc1_code,
                            :d_ar_hdr_main_acc2_code,
                            :d_ar_hdr_dept_code,
                            :d_ar_hdr_product_group_code,
                            :d_ar_hdr_product_line_code,
                            :d_ar_hdr_sub_group_code,
                            :d_ar_hdr_sub_line_code,
                            :d_ar_hdr_amount,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :l_gd_cheque_num,
                            :l_gd_cheque_date,
							:d_cust_code,
                            :d_ar_hdr_rowid; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 23;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )1006;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_code;
             sqlstm.sqhstl[0] = (unsigned int  )7;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
             sqlstm.sqhstl[2] = (unsigned int  )11;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_doc_date;
             sqlstm.sqhstl[3] = (unsigned int  )14;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_cust_ref;
             sqlstm.sqhstl[4] = (unsigned int  )18;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_narration;
             sqlstm.sqhstl[5] = (unsigned int  )53;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_post_month;
             sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_post_year;
             sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_main_acc1_code;
             sqlstm.sqhstl[8] = (unsigned int  )11;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_main_acc2_code;
             sqlstm.sqhstl[9] = (unsigned int  )9;
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_dept_code;
             sqlstm.sqhstl[10] = (unsigned int  )9;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_product_group_code;
             sqlstm.sqhstl[11] = (unsigned int  )6;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
             sqlstm.sqhstv[12] = (         void  *)&d_ar_hdr_product_line_code;
             sqlstm.sqhstl[12] = (unsigned int  )7;
             sqlstm.sqhsts[12] = (         int  )0;
             sqlstm.sqindv[12] = (         void  *)0;
             sqlstm.sqinds[12] = (         int  )0;
             sqlstm.sqharm[12] = (unsigned int  )0;
             sqlstm.sqadto[12] = (unsigned short )0;
             sqlstm.sqtdso[12] = (unsigned short )0;
             sqlstm.sqhstv[13] = (         void  *)&d_ar_hdr_sub_group_code;
             sqlstm.sqhstl[13] = (unsigned int  )6;
             sqlstm.sqhsts[13] = (         int  )0;
             sqlstm.sqindv[13] = (         void  *)0;
             sqlstm.sqinds[13] = (         int  )0;
             sqlstm.sqharm[13] = (unsigned int  )0;
             sqlstm.sqadto[13] = (unsigned short )0;
             sqlstm.sqtdso[13] = (unsigned short )0;
             sqlstm.sqhstv[14] = (         void  *)&d_ar_hdr_sub_line_code;
             sqlstm.sqhstl[14] = (unsigned int  )11;
             sqlstm.sqhsts[14] = (         int  )0;
             sqlstm.sqindv[14] = (         void  *)0;
             sqlstm.sqinds[14] = (         int  )0;
             sqlstm.sqharm[14] = (unsigned int  )0;
             sqlstm.sqadto[14] = (unsigned short )0;
             sqlstm.sqtdso[14] = (unsigned short )0;
             sqlstm.sqhstv[15] = (         void  *)&d_ar_hdr_amount;
             sqlstm.sqhstl[15] = (unsigned int  )19;
             sqlstm.sqhsts[15] = (         int  )0;
             sqlstm.sqindv[15] = (         void  *)0;
             sqlstm.sqinds[15] = (         int  )0;
             sqlstm.sqharm[15] = (unsigned int  )0;
             sqlstm.sqadto[15] = (unsigned short )0;
             sqlstm.sqtdso[15] = (unsigned short )0;
             sqlstm.sqhstv[16] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[16] = (unsigned int  )19;
             sqlstm.sqhsts[16] = (         int  )0;
             sqlstm.sqindv[16] = (         void  *)0;
             sqlstm.sqinds[16] = (         int  )0;
             sqlstm.sqharm[16] = (unsigned int  )0;
             sqlstm.sqadto[16] = (unsigned short )0;
             sqlstm.sqtdso[16] = (unsigned short )0;
             sqlstm.sqhstv[17] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[17] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[17] = (         int  )0;
             sqlstm.sqindv[17] = (         void  *)0;
             sqlstm.sqinds[17] = (         int  )0;
             sqlstm.sqharm[17] = (unsigned int  )0;
             sqlstm.sqadto[17] = (unsigned short )0;
             sqlstm.sqtdso[17] = (unsigned short )0;
             sqlstm.sqhstv[18] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[18] = (unsigned int  )19;
             sqlstm.sqhsts[18] = (         int  )0;
             sqlstm.sqindv[18] = (         void  *)0;
             sqlstm.sqinds[18] = (         int  )0;
             sqlstm.sqharm[18] = (unsigned int  )0;
             sqlstm.sqadto[18] = (unsigned short )0;
             sqlstm.sqtdso[18] = (unsigned short )0;
             sqlstm.sqhstv[19] = (         void  *)&l_gd_cheque_num;
             sqlstm.sqhstl[19] = (unsigned int  )13;
             sqlstm.sqhsts[19] = (         int  )0;
             sqlstm.sqindv[19] = (         void  *)0;
             sqlstm.sqinds[19] = (         int  )0;
             sqlstm.sqharm[19] = (unsigned int  )0;
             sqlstm.sqadto[19] = (unsigned short )0;
             sqlstm.sqtdso[19] = (unsigned short )0;
             sqlstm.sqhstv[20] = (         void  *)&l_gd_cheque_date;
             sqlstm.sqhstl[20] = (unsigned int  )17;
             sqlstm.sqhsts[20] = (         int  )0;
             sqlstm.sqindv[20] = (         void  *)0;
             sqlstm.sqinds[20] = (         int  )0;
             sqlstm.sqharm[20] = (unsigned int  )0;
             sqlstm.sqadto[20] = (unsigned short )0;
             sqlstm.sqtdso[20] = (unsigned short )0;
             sqlstm.sqhstv[21] = (         void  *)&d_cust_code;
             sqlstm.sqhstl[21] = (unsigned int  )11;
             sqlstm.sqhsts[21] = (         int  )0;
             sqlstm.sqindv[21] = (         void  *)0;
             sqlstm.sqinds[21] = (         int  )0;
             sqlstm.sqharm[21] = (unsigned int  )0;
             sqlstm.sqadto[21] = (unsigned short )0;
             sqlstm.sqtdso[21] = (unsigned short )0;
             sqlstm.sqhstv[22] = (         void  *)&d_ar_hdr_rowid;
             sqlstm.sqhstl[22] = (unsigned int  )33;
             sqlstm.sqhsts[22] = (         int  )0;
             sqlstm.sqindv[22] = (         void  *)0;
             sqlstm.sqinds[22] = (         int  )0;
             sqlstm.sqharm[22] = (unsigned int  )0;
             sqlstm.sqadto[22] = (unsigned short )0;
             sqlstm.sqtdso[22] = (unsigned short )0;
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
                 err_mesg("FETCH failed on cursor AR_PAY_HDR_CUR",0,"");
             break;
    }

    null_term_hdr(l_type);

    if (l_type == 1 || l_type == 5 || l_type == 6)
    {
        strcpy(l_gd_hdr_amount,l_gd_amount.arr);
        l_gd_hdr_sign_amount = l_gd_sign_amount;
        strcpy(l_gd_hdr_amt_negative,l_gd_amount_negative.arr);
    }


    if (LAST_ROW) 
        return (0);
    else 
        return (1);
}

init_hdr_variables(t_type)
int t_type;
{
    switch (t_type)
    {
       case 1 :
       case 5 :
       case 6 :
            d_ar_hdr_doc_type_code.arr[0]         = '\0';
            d_ar_hdr_doc_num.arr[0]               = '\0';
            d_ar_hdr_doc_date.arr[0]              = '\0';
            d_ar_hdr_cust_ref.arr[0]              = '\0';
			d_cust_code.arr[0]                    = '\0';
			d_acc_entity_code.arr[0]              = '\0';
            d_ar_hdr_narration.arr[0]             = '\0';
            d_ar_hdr_main_acc1_code.arr[0]        = '\0';
            d_ar_hdr_main_acc2_code.arr[0]        = '\0';
            d_ar_hdr_dept_code.arr[0]             = '\0';
            d_ar_hdr_product_group_code.arr[0]    = '\0';
            d_ar_hdr_product_line_code.arr[0]     = '\0';
            d_ar_hdr_sub_group_code.arr[0]  = '\0';
            d_ar_hdr_sub_line_code.arr[0]   = '\0';
            d_ar_hdr_amount.arr[0]                = '\0';
            d_ar_hdr_rowid.arr[0]                 = '\0';
            d_ar_off_hdr_rowid.arr[0]             = '\0';
			l_gd_amount.arr[0]                    = '\0';
            l_gd_amount_negative.arr[0]           = '\0';
            l_gd_cheque_num.arr[0]                = '\0';
            l_gd_cheque_date.arr[0]               = '\0';


    		d_ar_off_rec_hdr_main_acc1_code.arr[0]    = '\0';
            d_ar_off_rec_hdr_main_acc2_code.arr[0]    = '\0';
            d_ar_off_rec_hdr_dept_code.arr[0]         = '\0';
            d_ar_off_rec_hdr_amount.arr[0]            = '\0';
            d_ar_off_rec_hdr_product_group_code.arr[0]    = '\0';
            d_ar_off_rec_hdr_product_line_code.arr[0]     = '\0';
            d_ar_off_rec_hdr_sub_group_code.arr[0]  = '\0';
            d_ar_off_rec_hdr_sub_line_code.arr[0]   = '\0';


            d_ar_hdr_doc_type_code.len            = 0;
            d_ar_hdr_doc_num.len                  = 0;
            d_ar_hdr_doc_date.len                 = 0;
            d_ar_hdr_cust_ref.len                 = 0;
			d_cust_code.len                       = 0;
			d_acc_entity_code.len                 = 0;
            d_ar_hdr_narration.len                = 0;
            d_ar_hdr_main_acc1_code.len           = 0;
            d_ar_hdr_main_acc2_code.len           = 0;
            d_ar_hdr_dept_code.len                = 0;
            d_ar_hdr_product_group_code.len       = 0;
            d_ar_hdr_product_line_code.len        = 0;
            d_ar_hdr_sub_group_code.len     = 0;
            d_ar_hdr_sub_line_code.len      = 0;
            d_ar_hdr_amount.len                   = 0;
            d_ar_hdr_rowid.len                    = 0;
			d_ar_off_hdr_rowid.len                = 0;


     		d_ar_off_rec_hdr_main_acc1_code.len   = 0;
            d_ar_off_rec_hdr_main_acc2_code.len   = 0;
            d_ar_off_rec_hdr_dept_code.len        = 0;
            d_ar_off_rec_hdr_amount.len           = 0;
            d_ar_off_rec_hdr_product_group_code.len   = 0;
            d_ar_off_rec_hdr_product_line_code.len    = 0;
            d_ar_off_rec_hdr_sub_group_code.len     = 0;
            d_ar_off_rec_hdr_sub_line_code.len      = 0;

            d_ar_hdr_post_month                   = 0;
            d_ar_hdr_post_year                    = 0;

			l_gd_amount.len                       = 0;
            l_gd_amount_negative.len              = 0;
            l_gd_cheque_num.len                   = 0;
            l_gd_cheque_date.len                  = 0;
            l_gd_sign_amount                      = 0;

          break;
    case 2 :
    case 3 : 
    case 4 :
            d_ar_hdr_doc_type_code.arr[0]         = '\0';
            d_ar_hdr_doc_num.arr[0]               = '\0';
            d_ar_hdr_doc_date.arr[0]              = '\0';
			d_acc_entity_code.arr[0]              = '\0';
            d_ar_hdr_rowid.arr[0]                 = '\0';

            d_ar_hdr_doc_type_code.len            = 0;
            d_ar_hdr_doc_num.len                  = 0;
            d_ar_hdr_doc_date.len                 = 0;
			d_acc_entity_code.len                 = 0;
            d_ar_hdr_rowid.len                    = 0;

            d_ar_hdr_post_month                   = 0;
            d_ar_hdr_post_year                    = 0;
          break;
     }
}

null_term_hdr(t_type)
int t_type;
{
    switch (t_type)
    {
       case 1 :
       case 5 :
       case 6 :
    d_ar_hdr_doc_type_code.arr[d_ar_hdr_doc_type_code.len]               = '\0';
    d_ar_hdr_doc_num.arr[d_ar_hdr_doc_num.len]                           = '\0';
    d_ar_hdr_doc_date.arr[d_ar_hdr_doc_date.len]                         = '\0';
    d_ar_hdr_cust_ref.arr[d_ar_hdr_cust_ref.len]                         = '\0';
    d_cust_code.arr[d_cust_code.len]                                     = '\0';
	d_acc_entity_code.arr[d_acc_entity_code.len]                         = '\0';
    d_ar_hdr_narration.arr[d_ar_hdr_narration.len]                       = '\0';
    d_ar_hdr_main_acc1_code.arr[d_ar_hdr_main_acc1_code.len]             = '\0';
    d_ar_hdr_main_acc2_code.arr[d_ar_hdr_main_acc2_code.len]             = '\0';
    d_ar_hdr_dept_code.arr[d_ar_hdr_dept_code.len]                       = '\0';
    d_ar_hdr_product_group_code.arr[d_ar_hdr_product_group_code.len]     = '\0';
    d_ar_hdr_product_line_code.arr[d_ar_hdr_product_line_code.len]       = '\0';
    d_ar_hdr_sub_group_code.arr[d_ar_hdr_sub_group_code.len] = '\0';
    d_ar_hdr_sub_line_code.arr[d_ar_hdr_sub_line_code.len]   = '\0';
    d_ar_hdr_amount.arr[d_ar_hdr_amount.len]                             = '\0';
    d_ar_hdr_rowid.arr[d_ar_hdr_rowid.len]                               = '\0';
    l_gd_amount.arr[l_gd_amount.len]                                     = '\0';
    l_gd_amount_negative.arr[l_gd_amount_negative.len]                   = '\0';
    l_gd_cheque_num.arr[l_gd_cheque_num.len]                             = '\0';
    l_gd_cheque_date.arr[l_gd_cheque_date.len]                           = '\0';
	d_ar_off_hdr_rowid.arr[d_ar_off_hdr_rowid.len]                       = '\0';

    d_ar_off_rec_hdr_main_acc1_code.arr[d_ar_off_rec_hdr_main_acc1_code.len] = '\0';
    d_ar_off_rec_hdr_main_acc2_code.arr[d_ar_off_rec_hdr_main_acc2_code.len] = '\0';
    d_ar_off_rec_hdr_dept_code.arr[d_ar_off_rec_hdr_dept_code.len]       = '\0';
    d_ar_off_rec_hdr_amount.arr[d_ar_off_rec_hdr_amount.len]             = '\0';
    d_ar_off_rec_hdr_product_group_code.arr[d_ar_off_rec_hdr_product_group_code.len]     = '\0';
    d_ar_off_rec_hdr_product_line_code.arr[d_ar_off_rec_hdr_product_line_code.len]       = '\0';
    d_ar_off_rec_hdr_sub_group_code.arr[d_ar_off_rec_hdr_sub_group_code.len] = '\0';
    d_ar_off_rec_hdr_sub_line_code.arr[d_ar_off_rec_hdr_sub_line_code.len]   = '\0';

          break;
    case 2 :
    case 3 :
    case 4 :
    d_ar_hdr_doc_type_code.arr[d_ar_hdr_doc_type_code.len]               = '\0';
    d_ar_hdr_doc_num.arr[d_ar_hdr_doc_num.len]                           = '\0';
    d_ar_hdr_doc_date.arr[d_ar_hdr_doc_date.len]                         = '\0';
    d_ar_hdr_rowid.arr[d_ar_hdr_rowid.len]                               = '\0';
          break;
     }
}

process_rec(l_type)
int l_type;
{
   switch (l_type)
   {
       case 1 :
       case 5 :
       case 6 :
             validate_posting(0);
             open_line(l_type);
             while (fetch_line(l_type))
             {
                 validate_posting(1);
                 gl_doc_insert(1);
             }
             gl_doc_insert(2);
             gl_doc_insert(0);
             break;
       case 2 :
       case 3 :
       case 4 :
             d_cust_ref1.arr[0]  = '\0';
             d_cust_ref1.len     = 0;
             d_narration1.len    = 0;
             d_narration1.arr[0] = '\0';

             open_trn_inv_hdr(l_type);
             while (fetch_trn_inv_hdr(l_type))
             {
                validate_posting(0);
                open_line(l_type);
                while (fetch_line(l_type))
                {
                    validate_posting(1);
                    gl_doc_insert(1);
                }
                gl_doc_insert(2);
             }
             gl_doc_insert(0);
             break;
     }
}


process_off_rec()
{

 /*-----------------30/06/2002-------------------------*/   

	/* EXEC SQL OPEN AR_OFF_REC_HDR_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0015;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1113;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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



             /* EXEC SQL FETCH AR_OFF_REC_HDR_CUR
                       INTO :d_acc_entity_code,
					        :d_ar_hdr_narration,
                            :d_ar_hdr_main_acc1_code,
                            :d_ar_hdr_main_acc2_code,
                            :d_ar_hdr_dept_code,                            
                            :d_ar_hdr_product_group_code,
                            :d_ar_hdr_product_line_code,
                            :d_ar_hdr_sub_group_code,
                            :d_ar_hdr_sub_line_code,
                            :d_ar_hdr_amount,
				 		    :d_ar_off_rec_hdr_main_acc1_code,
                            :d_ar_off_rec_hdr_main_acc2_code,
                            :d_ar_off_rec_hdr_dept_code,                            
                            :d_ar_off_rec_hdr_product_group_code,
                            :d_ar_off_rec_hdr_product_line_code,
                            :d_ar_off_rec_hdr_sub_group_code,
                            :d_ar_off_rec_hdr_sub_line_code,
                            :d_ar_off_rec_hdr_amount,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :l_gd_cheque_num,
                            :l_gd_cheque_date,
							:d_cust_code,
							:d_ar_off_hdr_rowid; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 25;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )1136;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_code;
             sqlstm.sqhstl[0] = (unsigned int  )7;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_narration;
             sqlstm.sqhstl[1] = (unsigned int  )53;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_main_acc1_code;
             sqlstm.sqhstl[2] = (unsigned int  )11;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_main_acc2_code;
             sqlstm.sqhstl[3] = (unsigned int  )9;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_dept_code;
             sqlstm.sqhstl[4] = (unsigned int  )9;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_product_group_code;
             sqlstm.sqhstl[5] = (unsigned int  )6;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_product_line_code;
             sqlstm.sqhstl[6] = (unsigned int  )7;
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_sub_group_code;
             sqlstm.sqhstl[7] = (unsigned int  )6;
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_sub_line_code;
             sqlstm.sqhstl[8] = (unsigned int  )11;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_amount;
             sqlstm.sqhstl[9] = (unsigned int  )19;
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&d_ar_off_rec_hdr_main_acc1_code;
             sqlstm.sqhstl[10] = (unsigned int  )11;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_off_rec_hdr_main_acc2_code;
             sqlstm.sqhstl[11] = (unsigned int  )9;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
             sqlstm.sqhstv[12] = (         void  *)&d_ar_off_rec_hdr_dept_code;
             sqlstm.sqhstl[12] = (unsigned int  )9;
             sqlstm.sqhsts[12] = (         int  )0;
             sqlstm.sqindv[12] = (         void  *)0;
             sqlstm.sqinds[12] = (         int  )0;
             sqlstm.sqharm[12] = (unsigned int  )0;
             sqlstm.sqadto[12] = (unsigned short )0;
             sqlstm.sqtdso[12] = (unsigned short )0;
             sqlstm.sqhstv[13] = (         void  *)&d_ar_off_rec_hdr_product_group_code;
             sqlstm.sqhstl[13] = (unsigned int  )6;
             sqlstm.sqhsts[13] = (         int  )0;
             sqlstm.sqindv[13] = (         void  *)0;
             sqlstm.sqinds[13] = (         int  )0;
             sqlstm.sqharm[13] = (unsigned int  )0;
             sqlstm.sqadto[13] = (unsigned short )0;
             sqlstm.sqtdso[13] = (unsigned short )0;
             sqlstm.sqhstv[14] = (         void  *)&d_ar_off_rec_hdr_product_line_code;
             sqlstm.sqhstl[14] = (unsigned int  )7;
             sqlstm.sqhsts[14] = (         int  )0;
             sqlstm.sqindv[14] = (         void  *)0;
             sqlstm.sqinds[14] = (         int  )0;
             sqlstm.sqharm[14] = (unsigned int  )0;
             sqlstm.sqadto[14] = (unsigned short )0;
             sqlstm.sqtdso[14] = (unsigned short )0;
             sqlstm.sqhstv[15] = (         void  *)&d_ar_off_rec_hdr_sub_group_code;
             sqlstm.sqhstl[15] = (unsigned int  )6;
             sqlstm.sqhsts[15] = (         int  )0;
             sqlstm.sqindv[15] = (         void  *)0;
             sqlstm.sqinds[15] = (         int  )0;
             sqlstm.sqharm[15] = (unsigned int  )0;
             sqlstm.sqadto[15] = (unsigned short )0;
             sqlstm.sqtdso[15] = (unsigned short )0;
             sqlstm.sqhstv[16] = (         void  *)&d_ar_off_rec_hdr_sub_line_code;
             sqlstm.sqhstl[16] = (unsigned int  )11;
             sqlstm.sqhsts[16] = (         int  )0;
             sqlstm.sqindv[16] = (         void  *)0;
             sqlstm.sqinds[16] = (         int  )0;
             sqlstm.sqharm[16] = (unsigned int  )0;
             sqlstm.sqadto[16] = (unsigned short )0;
             sqlstm.sqtdso[16] = (unsigned short )0;
             sqlstm.sqhstv[17] = (         void  *)&d_ar_off_rec_hdr_amount;
             sqlstm.sqhstl[17] = (unsigned int  )19;
             sqlstm.sqhsts[17] = (         int  )0;
             sqlstm.sqindv[17] = (         void  *)0;
             sqlstm.sqinds[17] = (         int  )0;
             sqlstm.sqharm[17] = (unsigned int  )0;
             sqlstm.sqadto[17] = (unsigned short )0;
             sqlstm.sqtdso[17] = (unsigned short )0;
             sqlstm.sqhstv[18] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[18] = (unsigned int  )19;
             sqlstm.sqhsts[18] = (         int  )0;
             sqlstm.sqindv[18] = (         void  *)0;
             sqlstm.sqinds[18] = (         int  )0;
             sqlstm.sqharm[18] = (unsigned int  )0;
             sqlstm.sqadto[18] = (unsigned short )0;
             sqlstm.sqtdso[18] = (unsigned short )0;
             sqlstm.sqhstv[19] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[19] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[19] = (         int  )0;
             sqlstm.sqindv[19] = (         void  *)0;
             sqlstm.sqinds[19] = (         int  )0;
             sqlstm.sqharm[19] = (unsigned int  )0;
             sqlstm.sqadto[19] = (unsigned short )0;
             sqlstm.sqtdso[19] = (unsigned short )0;
             sqlstm.sqhstv[20] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[20] = (unsigned int  )19;
             sqlstm.sqhsts[20] = (         int  )0;
             sqlstm.sqindv[20] = (         void  *)0;
             sqlstm.sqinds[20] = (         int  )0;
             sqlstm.sqharm[20] = (unsigned int  )0;
             sqlstm.sqadto[20] = (unsigned short )0;
             sqlstm.sqtdso[20] = (unsigned short )0;
             sqlstm.sqhstv[21] = (         void  *)&l_gd_cheque_num;
             sqlstm.sqhstl[21] = (unsigned int  )13;
             sqlstm.sqhsts[21] = (         int  )0;
             sqlstm.sqindv[21] = (         void  *)0;
             sqlstm.sqinds[21] = (         int  )0;
             sqlstm.sqharm[21] = (unsigned int  )0;
             sqlstm.sqadto[21] = (unsigned short )0;
             sqlstm.sqtdso[21] = (unsigned short )0;
             sqlstm.sqhstv[22] = (         void  *)&l_gd_cheque_date;
             sqlstm.sqhstl[22] = (unsigned int  )17;
             sqlstm.sqhsts[22] = (         int  )0;
             sqlstm.sqindv[22] = (         void  *)0;
             sqlstm.sqinds[22] = (         int  )0;
             sqlstm.sqharm[22] = (unsigned int  )0;
             sqlstm.sqadto[22] = (unsigned short )0;
             sqlstm.sqtdso[22] = (unsigned short )0;
             sqlstm.sqhstv[23] = (         void  *)&d_cust_code;
             sqlstm.sqhstl[23] = (unsigned int  )11;
             sqlstm.sqhsts[23] = (         int  )0;
             sqlstm.sqindv[23] = (         void  *)0;
             sqlstm.sqinds[23] = (         int  )0;
             sqlstm.sqharm[23] = (unsigned int  )0;
             sqlstm.sqadto[23] = (unsigned short )0;
             sqlstm.sqtdso[23] = (unsigned short )0;
             sqlstm.sqhstv[24] = (         void  *)&d_ar_off_hdr_rowid;
             sqlstm.sqhstl[24] = (unsigned int  )33;
             sqlstm.sqhsts[24] = (         int  )0;
             sqlstm.sqindv[24] = (         void  *)0;
             sqlstm.sqinds[24] = (         int  )0;
             sqlstm.sqharm[24] = (unsigned int  )0;
             sqlstm.sqadto[24] = (unsigned short )0;
             sqlstm.sqtdso[24] = (unsigned short )0;
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


;

             if (OERROR)
                 err_mesg("FETCH failed on cursor AR_OFF_REC_HDR_CUR",0,"");
          
	
     null_term_hdr(t_type);

     validate_posting(0);

	 gl_doc_insert(2);
     

	 strcpy(d_ar_hdr_main_acc1_code.arr, d_ar_off_rec_hdr_main_acc1_code.arr);
     strcpy(d_ar_hdr_main_acc2_code.arr, d_ar_off_rec_hdr_main_acc2_code.arr);
     strcpy(d_ar_hdr_dept_code.arr, d_ar_off_rec_hdr_dept_code.arr);
	 strcpy(d_ar_hdr_product_group_code.arr, d_ar_off_rec_hdr_product_group_code.arr);
	 strcpy(d_ar_hdr_product_line_code.arr, d_ar_off_rec_hdr_product_line_code.arr);
	 strcpy(d_ar_hdr_sub_group_code.arr, d_ar_off_rec_hdr_sub_group_code.arr);
	 strcpy(d_ar_hdr_sub_line_code.arr, d_ar_off_rec_hdr_sub_line_code.arr);
    
     strcpy(d_ar_hdr_amount.arr, d_ar_off_rec_hdr_amount.arr);

     strcpy(l_gd_amount.arr, d_ar_off_rec_hdr_amount.arr);
                            
     l_gd_sign_amount = -1;
      
	 //strcpy(l_gd_amount_negative.arr, d_ar_off_rec_hdr_amount.arr);
	 
     validate_posting(0);

     d_ar_hdr_amount.arr[17] = '\0';
     d_ar_hdr_amount.len = strlen(d_ar_hdr_amount.arr);

     l_gd_amount.arr[17] = '\0';
     l_gd_amount.len = strlen(l_gd_amount.arr);

     l_gd_amount_negative.arr[17] = '\0';
     l_gd_amount_negative.len = strlen(l_gd_amount_negative.arr);
     d_ar_switch = 1; 
     gl_doc_insert(2);
	 d_ar_switch = 0;
}  
validate_posting(ind)
int ind;
{

  if (ind == 0)
  {
      strcpy(d_module_valid_id.arr , "AR");

      if(validate_posting_acct( d_ar_hdr_main_acc1_code.arr,
                                d_ar_hdr_main_acc2_code.arr,
                                d_ar_hdr_dept_code.arr,
                                d_ar_hdr_product_group_code.arr,
                                d_ar_hdr_product_line_code.arr,
                                d_ar_hdr_sub_group_code.arr,
                                d_ar_hdr_sub_line_code.arr,
                                'Y',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
                                d_ar_hdr_post_year,
								d_ar_hdr_post_month,
								&g_err_typ,
                                g_err_id,
                                g_err_msg
                             ) ==  -1)
      {
             if(g_err_typ == 0)
                   err_mesg(g_err_msg,0,"");
             else 
                error_insert(g_err_id,0);
       }
  }
  else
  {
      strcpy(d_module_valid_id.arr , "AR");
	
      if(validate_posting_acct( d_ar_line_main_acc1_code.arr,
                                d_ar_line_main_acc2_code.arr,
                                d_ar_line_dept_code.arr,
                                d_ar_line_product_group_code.arr,
                                d_ar_line_product_line_code.arr,
                                d_ar_line_sub_group_code.arr,
                                d_ar_line_sub_line_code.arr,
                                'Y',   /* For chking Bank Reconcile */
								d_module_valid_id.arr, 
                                d_ar_hdr_post_year,
								d_ar_hdr_post_month,
								&g_err_typ,
                                g_err_id,
                                g_err_msg
                             ) ==  -1)
      {
             if(g_err_typ == 0)
                   err_mesg(g_err_msg,0,"");
             else 
                error_insert(g_err_id,1);
       }
   }
}

error_insert(l_err_id,l_type)
char l_err_id[];
int l_type;
{
   char str[132];

   valid_flag = 'N';

   if (l_type == 0)
   {
       sprintf(str,"%s - %s/%s  %s-%s  %s  %s-%s %s-%s",
           trn_desc[t_type],
           d_ar_hdr_doc_type_code.arr,
           d_ar_hdr_doc_num.arr,
           d_ar_hdr_main_acc1_code.arr,
           d_ar_hdr_main_acc2_code.arr,
           d_ar_hdr_dept_code.arr,
           d_ar_hdr_product_group_code.arr,
           d_ar_hdr_product_line_code.arr,
           d_ar_hdr_sub_group_code.arr,
           d_ar_hdr_sub_line_code.arr);

        log_err_mesg(str,1,l_err_id);
  }
  else
  {
       sprintf(str,"%s - %s/%s  %s-%s  %s  %s-%s %s-%s",
           trn_desc[t_type],
           d_ar_hdr_doc_type_code.arr,
           d_ar_hdr_doc_num.arr,
           d_ar_line_main_acc1_code.arr,
           d_ar_line_main_acc2_code.arr,
           d_ar_line_dept_code.arr,
           d_ar_line_product_group_code.arr,
           d_ar_line_product_line_code.arr,
           d_ar_line_sub_group_code.arr,
           d_ar_line_sub_line_code.arr);
        log_err_mesg(str,1,l_err_id);
   }
}

gl_doc_insert(ins_flg)
int ins_flg;
{
    if (valid_flag == 'N')
          return (0);

    if (t_type == 1 || t_type == 5 || t_type == 6)
    {
          strcpy(d_cust_ref1.arr,d_ar_hdr_cust_ref.arr);
          d_cust_ref1.arr[10] = '\0';
          d_cust_ref1.len = strlen(d_cust_ref1.arr);

          strcpy(d_narration1.arr,d_ar_hdr_narration.arr);
          d_narration1.len = strlen(d_narration1.arr);
    }

    if (ins_flg != 0)
         insert_distrbn((ins_flg == 2)?0:1);


    if (nd_interface_mode.arr[0] == 'S')
    {
         if (ins_flg != 0)
            insert_gl_distrbn_temp(ins_flg);
    }
    else if (ins_flg == 1)
    {
        d_ar_run_line_num ++;
/*
disp_message (ERR_MESG,d_ar_hdr_doc_type_code.arr);
disp_message (ERR_MESG,d_ar_hdr_doc_num.arr);
sprintf(tempstring,"%d",d_ar_run_line_num);
disp_message (ERR_MESG,tempstring);
*/
        /* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
               (
                 ACC_ENTITY_CODE,
				 BATCH_NUM,
                 DOC_TYPE_CODE,
                 DOC_NUM,
                 MAIN_ACC1_CODE,
                 MAIN_ACC2_CODE,
                 DEPT_CODE,
                 PRODUCT_GROUP_CODE,
                 PRODUCT_LINE_CODE,
                 SUBLEDGER_GROUP_CODE,
                 SUBLEDGER_LINE_CODE,
                 LOCAL_AMT,
                 NARRATION,
                 LINE_NUM,
				 CUST_SUPP_CODE
               )
             VALUES
               (
                 :nd_acc_entity_code,
				 0,
                 :d_ar_hdr_doc_type_code,
                 :d_ar_hdr_doc_num,
                 :d_ar_line_main_acc1_code,
                 :d_ar_line_main_acc2_code,
                 :d_ar_line_dept_code,
                 :d_ar_line_product_group_code,
                 :d_ar_line_product_line_code,
                 :d_ar_line_sub_group_code,
                 :d_ar_line_sub_line_code,
                 :d_ar_line_amt_local,
                 :d_ar_line_narration,
                 :d_ar_run_line_num,
				 :d_cust_code
               ); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 25;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NU\
M,DOC_TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_\
CODE,PRODUCT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,LOCAL_AMT,NARR\
ATION,LINE_NUM,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:\
b9,:b10,:b11,:b12,:b13)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1251;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
        sqlstm.sqhstl[0] = (unsigned int  )7;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_ar_line_main_acc1_code;
        sqlstm.sqhstl[3] = (unsigned int  )11;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_ar_line_main_acc2_code;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_ar_line_dept_code;
        sqlstm.sqhstl[5] = (unsigned int  )9;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_ar_line_product_group_code;
        sqlstm.sqhstl[6] = (unsigned int  )6;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&d_ar_line_product_line_code;
        sqlstm.sqhstl[7] = (unsigned int  )7;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&d_ar_line_sub_group_code;
        sqlstm.sqhstl[8] = (unsigned int  )6;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&d_ar_line_sub_line_code;
        sqlstm.sqhstl[9] = (unsigned int  )11;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&d_ar_line_amt_local;
        sqlstm.sqhstl[10] = (unsigned int  )19;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&d_ar_line_narration;
        sqlstm.sqhstl[11] = (unsigned int  )53;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&d_ar_run_line_num;
        sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&d_cust_code;
        sqlstm.sqhstl[13] = (unsigned int  )11;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
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
             err_mesg("INSERT failed on table GL_TXN_DOC_LINE - 1",0,"");
    }
    else
    {
     if (ins_flg == 2)
     { 
        d_ar_run_line_num ++;
/*
disp_message (ERR_MESG,d_ar_hdr_doc_type_code.arr);
disp_message (ERR_MESG,d_ar_hdr_doc_num.arr);
sprintf(tempstring,"%d",d_ar_run_line_num);
disp_message (ERR_MESG,tempstring);
*/
        /* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
               (
                 ACC_ENTITY_CODE,
				 BATCH_NUM,
                 DOC_TYPE_CODE,
                 DOC_NUM,
                 MAIN_ACC1_CODE,
                 MAIN_ACC2_CODE,
                 DEPT_CODE,
                 PRODUCT_GROUP_CODE,
                 PRODUCT_LINE_CODE,
                 SUBLEDGER_GROUP_CODE,
                 SUBLEDGER_LINE_CODE,
                 LOCAL_AMT,
                 NARRATION,
                 LINE_NUM,
				 CUST_SUPP_CODE
               )
             VALUES
               (
                 :nd_acc_entity_code,
				 0,
                 :d_ar_hdr_doc_type_code,
                 :d_ar_hdr_doc_num,
                 :d_ar_hdr_main_acc1_code,
                 :d_ar_hdr_main_acc2_code,
                 :d_ar_hdr_dept_code,
                 :d_ar_hdr_product_group_code,
                 :d_ar_hdr_product_line_code,
                 :d_ar_hdr_sub_group_code,
                 :d_ar_hdr_sub_line_code,
                 :d_ar_hdr_amount,
                 :d_ar_hdr_narration,
                 :d_ar_run_line_num,
				 :d_cust_code
               ); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 25;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NU\
M,DOC_TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_\
CODE,PRODUCT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,LOCAL_AMT,NARR\
ATION,LINE_NUM,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:\
b9,:b10,:b11,:b12,:b13)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1322;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
        sqlstm.sqhstl[0] = (unsigned int  )7;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_main_acc1_code;
        sqlstm.sqhstl[3] = (unsigned int  )11;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_main_acc2_code;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_dept_code;
        sqlstm.sqhstl[5] = (unsigned int  )9;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_product_group_code;
        sqlstm.sqhstl[6] = (unsigned int  )6;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_product_line_code;
        sqlstm.sqhstl[7] = (unsigned int  )7;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_sub_group_code;
        sqlstm.sqhstl[8] = (unsigned int  )6;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_sub_line_code;
        sqlstm.sqhstl[9] = (unsigned int  )11;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_amount;
        sqlstm.sqhstl[10] = (unsigned int  )19;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_narration;
        sqlstm.sqhstl[11] = (unsigned int  )53;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&d_ar_run_line_num;
        sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&d_cust_code;
        sqlstm.sqhstl[13] = (unsigned int  )11;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
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
           err_mesg("INSERT failed on table GL_TXN_DOC_LINE - 2",0,"");
     }
     else
     {
       /* EXEC SQL INSERT INTO GL_TXN_DOC_HDR
              ( 
                ACC_ENTITY_CODE,
				BATCH_NUM,
                DOC_TYPE_CODE,
                DOC_NUM,
                DOC_DATE,
                DOC_REF,
                NARRATION,
                POST_MONTH,
                POST_YEAR,
                CTRL_AMT,
                ADDED_BY_ID,
                MODIFIED_BY_ID,
                ADDED_DATE,
                MODIFIED_DATE,
                MAX_LINE_NUM,
                MODULE_ID
              )
            VALUES
              (
                :nd_acc_entity_code,
				0,
                :d_ar_hdr_doc_type_code,
                :d_ar_hdr_doc_num,
                TO_DATE(:d_ar_hdr_doc_date,'DD/MM/YYYY'),
                SUBSTR(:d_cust_ref1,1,10),
                :d_narration1,
                :d_ar_hdr_post_month,
                :d_ar_hdr_post_year,
                0,
                USER,
                USER,
                SYSDATE,
                SYSDATE,
                :d_ar_run_line_num,
                'AR'
             ); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 25;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "insert into GL_TXN_DOC_HDR (ACC_ENTITY_CODE,BATCH_NUM,\
DOC_TYPE_CODE,DOC_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT\
,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID) v\
alues (:b0,0,:b1,:b2,TO_DATE(:b3,'DD/MM/YYYY'),SUBSTR(:b4,1,10),:b5,:b6,:b7,0,\
USER,USER,SYSDATE,SYSDATE,:b8,'AR')";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1393;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
       sqlstm.sqhstl[0] = (unsigned int  )7;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )11;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_doc_date;
       sqlstm.sqhstl[3] = (unsigned int  )14;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_cust_ref1;
       sqlstm.sqhstl[4] = (unsigned int  )18;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_narration1;
       sqlstm.sqhstl[5] = (unsigned int  )53;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_post_month;
       sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_post_year;
       sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_run_line_num;
       sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
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



    if (OERROR)
         err_mesg("INSERT failed on table GL_TXN_DOC_HDR - HAHA 1",0,"");
    }
  }
}

insert_gl_distrbn_temp(ins_flg)
int ins_flg;
{
    /* EXEC SQL BEGIN DECLARE SECTION; */ 

     int l_ins_flg = 0;
     /* VARCHAR d_gl_dist_doc_ref[16],
             d_gl_dist_narration[51]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_gl_dist_doc_ref;

struct { unsigned short len; unsigned char arr[51]; } d_gl_dist_narration;

    /* EXEC SQL END DECLARE SECTION; */ 



    l_ins_flg = ins_flg;

    d_gl_dist_doc_ref.arr[0] = '\0';
    d_gl_dist_narration.arr[0]    = '\0';

    d_gl_dist_doc_ref.len    = 0;
    d_gl_dist_narration.len       = 0;

    if (ins_flg == 0) 
    {
       if ( (t_type == 1 || t_type == 5 || t_type == 6) ||
            ( (strcmp(d_ar_hdr_doc_type_code.arr,
               d_ar_hdr_org_doc_type_code.arr)==0)  &&
             (strcmp(d_ar_hdr_doc_num.arr,d_ar_hdr_org_doc_num.arr)==0)) )
       {
          strcpy(d_gl_dist_doc_ref.arr,d_ar_hdr_cust_ref.arr);
          d_gl_dist_doc_ref.arr[10] = '\0';
          d_gl_dist_doc_ref.len = strlen(d_gl_dist_doc_ref.arr);

          strcpy(d_gl_dist_narration.arr,d_narration1.arr);
          d_gl_dist_narration.len = strlen(d_gl_dist_narration.arr);
       }
    }

    fetch_bank_reconcile(ins_flg);

    /* EXEC SQL INSERT INTO AR_GL_DISTRBN_TEMP
          (
            DOC_TYPE_CODE,
            DOC_NUM,
            DOC_DATE,
            DOC_REF,
            MAIN_ACC1_CODE,
            MAIN_ACC2_CODE,
            DEPT_CODE,
            PRODUCT_GROUP_CODE,
            PRODUCT_LINE_CODE,
            SUBLEDGER_GROUP_CODE,
            SUBLEDGER_LINE_CODE	,
            DEBIT_AMT,
            NARRATION,
            POST_MONTH,
            POST_YEAR,
            TRN_TYPE_CODE
          )
      VALUES
          (
            :d_ar_hdr_doc_type_code,
            :d_ar_hdr_doc_num,
            TO_DATE(:d_ar_hdr_doc_date,'DD/MM/YYYY'),
            SUBSTR(:d_gl_dist_doc_ref,1,10),
            DECODE(:l_ins_flg,'2',
                :d_ar_hdr_main_acc1_code, :d_ar_line_main_acc1_code),
            DECODE(:l_ins_flg,'2',
                 :d_ar_hdr_main_acc2_code, :d_ar_line_main_acc2_code),
            DECODE(:l_ins_flg,'2',
                 :d_ar_hdr_dept_code, :d_ar_line_dept_code),
            DECODE(:l_ins_flg,'2',
                 :d_ar_hdr_product_group_code, :d_ar_line_product_group_code),
            DECODE(:l_ins_flg,'2',
                 :d_ar_hdr_product_line_code, :d_ar_line_product_line_code),
            DECODE(:l_ins_flg,'2',
               :d_ar_hdr_sub_group_code, :d_ar_line_sub_group_code),
            DECODE(:l_ins_flg,'2',
                 :d_ar_hdr_sub_line_code, :d_ar_line_sub_line_code),
            DECODE(:l_ins_flg,'2',
                 :d_ar_hdr_amount, :d_ar_line_amt_local),
            DECODE(:l_ins_flg,'2',:d_gl_dist_narration,:d_ar_line_narration),
            :d_ar_hdr_post_month,
            :d_ar_hdr_post_year,
            :d_ar_bank_reconcile_flg
          ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into AR_GL_DISTRBN_TEMP (DOC_TYPE_CODE,DOC_NUM,DOC\
_DATE,DOC_REF,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODU\
CT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEBIT_AMT,NARRATION,POST\
_MONTH,POST_YEAR,TRN_TYPE_CODE) values (:b0,:b1,TO_DATE(:b2,'DD/MM/YYYY'),SUBS\
TR(:b3,1,10),DECODE(:b4,'2',:b5,:b6),DECODE(:b4,'2',:b8,:b9),DECODE(:b4,'2',:b\
11,:b12),DECODE(:b4,'2',:b14,:b15),DECODE(:b4,'2',:b17,:b18),DECODE(:b4,'2',:b\
20,:b21),DECODE(:b4,'2',:b23,:b24),DECODE(:b4,'2',:b26,:b27),DECODE(:b4,'2',:b\
29,:b30),:b31,:b32,:b33)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1444;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_gl_dist_doc_ref;
    sqlstm.sqhstl[3] = (unsigned int  )18;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_main_acc1_code;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ar_line_main_acc1_code;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_main_acc2_code;
    sqlstm.sqhstl[8] = (unsigned int  )9;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_ar_line_main_acc2_code;
    sqlstm.sqhstl[9] = (unsigned int  )9;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_dept_code;
    sqlstm.sqhstl[11] = (unsigned int  )9;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_ar_line_dept_code;
    sqlstm.sqhstl[12] = (unsigned int  )9;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_ar_hdr_product_group_code;
    sqlstm.sqhstl[14] = (unsigned int  )6;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_ar_line_product_group_code;
    sqlstm.sqhstl[15] = (unsigned int  )6;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_ar_hdr_product_line_code;
    sqlstm.sqhstl[17] = (unsigned int  )7;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_ar_line_product_line_code;
    sqlstm.sqhstl[18] = (unsigned int  )7;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[19] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&d_ar_hdr_sub_group_code;
    sqlstm.sqhstl[20] = (unsigned int  )6;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_ar_line_sub_group_code;
    sqlstm.sqhstl[21] = (unsigned int  )6;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[22] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_ar_hdr_sub_line_code;
    sqlstm.sqhstl[23] = (unsigned int  )11;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_ar_line_sub_line_code;
    sqlstm.sqhstl[24] = (unsigned int  )11;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[25] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_ar_hdr_amount;
    sqlstm.sqhstl[26] = (unsigned int  )19;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&d_ar_line_amt_local;
    sqlstm.sqhstl[27] = (unsigned int  )19;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&l_ins_flg;
    sqlstm.sqhstl[28] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&d_gl_dist_narration;
    sqlstm.sqhstl[29] = (unsigned int  )53;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&d_ar_line_narration;
    sqlstm.sqhstl[30] = (unsigned int  )53;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&d_ar_hdr_post_month;
    sqlstm.sqhstl[31] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&d_ar_hdr_post_year;
    sqlstm.sqhstl[32] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&d_ar_bank_reconcile_flg;
    sqlstm.sqhstl[33] = (unsigned int  )5;
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



     if (OERROR)
         err_mesg("INSERT failed on table AR_GL_DISTRBN_TEMP",0,"");

}

fetch_bank_reconcile(l_flg)
int l_flg;
{
    if (l_flg == 0 || l_flg == 2)
    {
       strcpy(d_chk_main_acc1_code.arr,d_ar_hdr_main_acc1_code.arr);
       strcpy(d_chk_main_acc2_code.arr,d_ar_hdr_main_acc2_code.arr);
       strcpy(d_chk_dept_code.arr,d_ar_hdr_dept_code.arr);
       strcpy(d_chk_product_group_code.arr,d_ar_hdr_product_group_code.arr);
       strcpy(d_chk_product_line_code.arr,d_ar_hdr_product_line_code.arr);
       strcpy(d_chk_sub_group_code.arr,d_ar_hdr_sub_group_code.arr);
       strcpy(d_chk_sub_line_code.arr,d_ar_hdr_sub_line_code.arr);

       d_chk_main_acc1_code.len = strlen(d_chk_main_acc1_code.arr);
       d_chk_main_acc2_code.len = strlen(d_chk_main_acc2_code.arr);
       d_chk_dept_code.len      = strlen(d_chk_dept_code.arr);
d_chk_product_group_code.len    = strlen(d_chk_product_group_code.arr);
d_chk_product_line_code.len    = strlen(d_chk_product_line_code.arr);
d_chk_sub_group_code.len = strlen(d_chk_sub_group_code.arr);
d_chk_sub_line_code.len  = strlen(d_chk_sub_line_code.arr);
 
    }
    else
    {
       strcpy(d_chk_main_acc1_code.arr,d_ar_line_main_acc1_code.arr);
       strcpy(d_chk_main_acc2_code.arr,d_ar_line_main_acc2_code.arr);
       strcpy(d_chk_dept_code.arr,d_ar_line_dept_code.arr);
       strcpy(d_chk_product_group_code.arr,d_ar_line_product_group_code.arr);
       strcpy(d_chk_product_line_code.arr,d_ar_line_product_line_code.arr);
      strcpy(d_chk_sub_group_code.arr,d_ar_line_sub_group_code.arr);
       strcpy(d_chk_sub_line_code.arr,d_ar_line_sub_line_code.arr);

       d_chk_main_acc1_code.len = strlen(d_chk_main_acc1_code.arr);
       d_chk_main_acc2_code.len = strlen(d_chk_main_acc2_code.arr);
       d_chk_dept_code.len      = strlen(d_chk_dept_code.arr);
       d_chk_product_group_code.len     = strlen(d_chk_product_group_code.arr);
       d_chk_product_line_code.len      = strlen(d_chk_product_line_code.arr);
       d_chk_sub_group_code.len   = strlen(d_chk_sub_group_code.arr);
       d_chk_sub_line_code.len    = strlen(d_chk_sub_line_code.arr);
 
    }

    /* EXEC SQL OPEN GL_POSTING_ACC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0026;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1595;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_chk_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_chk_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_chk_dept_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_chk_product_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_chk_product_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_chk_sub_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_chk_sub_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )11;
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
         err_mesg("OPEN failed on cursor GL_POSTING_ACC_CUR",0,"");

    d_ar_bank_reconcile_flg.arr[0] = '\0';
    d_ar_bank_reconcile_flg.len    = 0;

    /* EXEC SQL FETCH GL_POSTING_ACC_CUR
              INTO :d_ar_bank_reconcile_flg; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1638;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_bank_reconcile_flg;
    sqlstm.sqhstl[0] = (unsigned int  )5;
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
         err_mesg("FETCH failed on cursor GL_POSTING_ACC_CUR",0,"");

    d_ar_bank_reconcile_flg.arr[d_ar_bank_reconcile_flg.len] = '\0';
}

open_line(l_type)
int l_type;
{
     switch(l_type)
     {
        case 1 :  
                 /* EXEC SQL OPEN AR_INV_LINE_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0017;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )1657;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[0] = (unsigned int  )9;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
                      err_mesg("OPEN failed on cursor AR_INV_LINE_CUR",0,"");
                 break;
        case 2 :  
                 /* EXEC SQL OPEN AR_DN_LINE_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0019;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )1680;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[0] = (unsigned int  )9;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
                 sqlstm.sqhstl[1] = (unsigned int  )11;
                 sqlstm.sqhsts[1] = (         int  )0;
                 sqlstm.sqindv[1] = (         void  *)0;
                 sqlstm.sqinds[1] = (         int  )0;
                 sqlstm.sqharm[1] = (unsigned int  )0;
                 sqlstm.sqadto[1] = (unsigned short )0;
                 sqlstm.sqtdso[1] = (unsigned short )0;
                 sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_org_doc_type_code;
                 sqlstm.sqhstl[2] = (unsigned int  )9;
                 sqlstm.sqhsts[2] = (         int  )0;
                 sqlstm.sqindv[2] = (         void  *)0;
                 sqlstm.sqinds[2] = (         int  )0;
                 sqlstm.sqharm[2] = (unsigned int  )0;
                 sqlstm.sqadto[2] = (unsigned short )0;
                 sqlstm.sqtdso[2] = (unsigned short )0;
                 sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_org_doc_num;
                 sqlstm.sqhstl[3] = (unsigned int  )11;
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
                      err_mesg("OPEN failed on cursor AR_DN_LINE_CUR",0,"");
                 break;
        case 3 :  
                 /* EXEC SQL OPEN AR_CN_LINE_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0021;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )1711;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[0] = (unsigned int  )9;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
                 sqlstm.sqhstl[1] = (unsigned int  )11;
                 sqlstm.sqhsts[1] = (         int  )0;
                 sqlstm.sqindv[1] = (         void  *)0;
                 sqlstm.sqinds[1] = (         int  )0;
                 sqlstm.sqharm[1] = (unsigned int  )0;
                 sqlstm.sqadto[1] = (unsigned short )0;
                 sqlstm.sqtdso[1] = (unsigned short )0;
                 sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_org_doc_type_code;
                 sqlstm.sqhstl[2] = (unsigned int  )9;
                 sqlstm.sqhsts[2] = (         int  )0;
                 sqlstm.sqindv[2] = (         void  *)0;
                 sqlstm.sqinds[2] = (         int  )0;
                 sqlstm.sqharm[2] = (unsigned int  )0;
                 sqlstm.sqadto[2] = (unsigned short )0;
                 sqlstm.sqtdso[2] = (unsigned short )0;
                 sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_org_doc_num;
                 sqlstm.sqhstl[3] = (unsigned int  )11;
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
                      err_mesg("OPEN failed on cursor AR_CN_LINE_CUR",0,"");
                 break;
        case 4 :  
                 /* EXEC SQL OPEN AR_ADJ_LINE_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0023;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )1742;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_adj_type;
                 sqlstm.sqhstl[0] = (unsigned int  )5;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[1] = (unsigned int  )9;
                 sqlstm.sqhsts[1] = (         int  )0;
                 sqlstm.sqindv[1] = (         void  *)0;
                 sqlstm.sqinds[1] = (         int  )0;
                 sqlstm.sqharm[1] = (unsigned int  )0;
                 sqlstm.sqadto[1] = (unsigned short )0;
                 sqlstm.sqtdso[1] = (unsigned short )0;
                 sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
                 sqlstm.sqhstl[2] = (unsigned int  )11;
                 sqlstm.sqhsts[2] = (         int  )0;
                 sqlstm.sqindv[2] = (         void  *)0;
                 sqlstm.sqinds[2] = (         int  )0;
                 sqlstm.sqharm[2] = (unsigned int  )0;
                 sqlstm.sqadto[2] = (unsigned short )0;
                 sqlstm.sqtdso[2] = (unsigned short )0;
                 sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_org_doc_type_code;
                 sqlstm.sqhstl[3] = (unsigned int  )9;
                 sqlstm.sqhsts[3] = (         int  )0;
                 sqlstm.sqindv[3] = (         void  *)0;
                 sqlstm.sqinds[3] = (         int  )0;
                 sqlstm.sqharm[3] = (unsigned int  )0;
                 sqlstm.sqadto[3] = (unsigned short )0;
                 sqlstm.sqtdso[3] = (unsigned short )0;
                 sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_org_doc_num;
                 sqlstm.sqhstl[4] = (unsigned int  )11;
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
                      err_mesg("OPEN failed on cursor AR_ADJ_LINE_CUR",0,"");
                 break;
        case 5 :  
                 /* EXEC SQL OPEN AR_REC_LINE_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0024;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )1777;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[0] = (unsigned int  )9;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
                      err_mesg("OPEN failed on cursor AR_REC_LINE_CUR",0,"");
                 break;
        case 6 :  
                 /* EXEC SQL OPEN AR_PAY_LINE_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0025;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )1800;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[0] = (unsigned int  )9;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
                      err_mesg("OPEN failed on cursor AR_PAY_LINE_CUR",0,"");
                 break;
       }
}

fetch_line(l_type)
int l_type;
{
   init_line_variables();

   switch (l_type)
   {
       case 1 :
             /* EXEC SQL FETCH AR_INV_LINE_CUR
                       INTO :d_ar_line_main_acc1_code,
                            :d_ar_line_main_acc2_code,
                            :d_ar_line_dept_code,
                            :d_ar_line_product_group_code,
                            :d_ar_line_product_line_code,
                            :d_ar_line_sub_group_code,
                            :d_ar_line_sub_line_code,
                            :d_ar_line_amt_local,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :d_ar_line_narration; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 34;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )1823;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_ar_line_main_acc1_code;
             sqlstm.sqhstl[0] = (unsigned int  )11;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_line_main_acc2_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_line_dept_code;
             sqlstm.sqhstl[2] = (unsigned int  )9;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_line_product_group_code;
             sqlstm.sqhstl[3] = (unsigned int  )6;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_line_product_line_code;
             sqlstm.sqhstl[4] = (unsigned int  )7;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_line_sub_group_code;
             sqlstm.sqhstl[5] = (unsigned int  )6;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_line_sub_line_code;
             sqlstm.sqhstl[6] = (unsigned int  )11;
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_line_amt_local;
             sqlstm.sqhstl[7] = (unsigned int  )19;
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[8] = (unsigned int  )19;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[10] = (unsigned int  )19;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_line_narration;
             sqlstm.sqhstl[11] = (unsigned int  )53;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
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
                  err_mesg("FETCH failed on cursor AR_INV_LINE_CUR",0,"");
             break;
       case 2 :
             /* EXEC SQL FETCH AR_DN_LINE_CUR
                       INTO :d_ar_line_main_acc1_code,
                            :d_ar_line_main_acc2_code,
                            :d_ar_line_dept_code,
                            :d_ar_line_product_group_code,
                            :d_ar_line_product_line_code,
                            :d_ar_line_sub_group_code,
                            :d_ar_line_sub_line_code,
                            :d_ar_line_amt_local,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :d_ar_line_narration; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 34;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )1886;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_ar_line_main_acc1_code;
             sqlstm.sqhstl[0] = (unsigned int  )11;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_line_main_acc2_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_line_dept_code;
             sqlstm.sqhstl[2] = (unsigned int  )9;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_line_product_group_code;
             sqlstm.sqhstl[3] = (unsigned int  )6;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_line_product_line_code;
             sqlstm.sqhstl[4] = (unsigned int  )7;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_line_sub_group_code;
             sqlstm.sqhstl[5] = (unsigned int  )6;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_line_sub_line_code;
             sqlstm.sqhstl[6] = (unsigned int  )11;
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_line_amt_local;
             sqlstm.sqhstl[7] = (unsigned int  )19;
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[8] = (unsigned int  )19;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[10] = (unsigned int  )19;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_line_narration;
             sqlstm.sqhstl[11] = (unsigned int  )53;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
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
                  err_mesg("FETCH failed on cursor AR_DN_LINE_CUR",0,"");
             break;
       case 3 :
             /* EXEC SQL FETCH AR_CN_LINE_CUR
                       INTO :d_ar_line_main_acc1_code,
                            :d_ar_line_main_acc2_code,
                            :d_ar_line_dept_code,
                            :d_ar_line_product_group_code,
                            :d_ar_line_product_line_code,
                            :d_ar_line_sub_group_code,
                            :d_ar_line_sub_line_code,
                            :d_ar_line_amt_local,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :d_ar_line_narration; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 34;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )1949;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_ar_line_main_acc1_code;
             sqlstm.sqhstl[0] = (unsigned int  )11;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_line_main_acc2_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_line_dept_code;
             sqlstm.sqhstl[2] = (unsigned int  )9;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_line_product_group_code;
             sqlstm.sqhstl[3] = (unsigned int  )6;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_line_product_line_code;
             sqlstm.sqhstl[4] = (unsigned int  )7;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_line_sub_group_code;
             sqlstm.sqhstl[5] = (unsigned int  )6;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_line_sub_line_code;
             sqlstm.sqhstl[6] = (unsigned int  )11;
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_line_amt_local;
             sqlstm.sqhstl[7] = (unsigned int  )19;
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[8] = (unsigned int  )19;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[10] = (unsigned int  )19;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_line_narration;
             sqlstm.sqhstl[11] = (unsigned int  )53;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
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
                  err_mesg("FETCH failed on cursor AR_CN_LINE_CUR",0,"");
             break;
       case 4 :
             /* EXEC SQL FETCH AR_ADJ_LINE_CUR
                       INTO :d_ar_line_main_acc1_code,
                            :d_ar_line_main_acc2_code,
                            :d_ar_line_dept_code,
                            :d_ar_line_product_group_code,
                            :d_ar_line_product_line_code,
                            :d_ar_line_sub_group_code,
                            :d_ar_line_sub_line_code,
                            :d_ar_line_amt_local,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :d_ar_line_narration; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 34;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )2012;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_ar_line_main_acc1_code;
             sqlstm.sqhstl[0] = (unsigned int  )11;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_line_main_acc2_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_line_dept_code;
             sqlstm.sqhstl[2] = (unsigned int  )9;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_line_product_group_code;
             sqlstm.sqhstl[3] = (unsigned int  )6;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_line_product_line_code;
             sqlstm.sqhstl[4] = (unsigned int  )7;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_line_sub_group_code;
             sqlstm.sqhstl[5] = (unsigned int  )6;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_line_sub_line_code;
             sqlstm.sqhstl[6] = (unsigned int  )11;
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_line_amt_local;
             sqlstm.sqhstl[7] = (unsigned int  )19;
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[8] = (unsigned int  )19;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[10] = (unsigned int  )19;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_line_narration;
             sqlstm.sqhstl[11] = (unsigned int  )53;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
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
                  err_mesg("FETCH failed on cursor AR_ADJ_LINE_CUR",0,"");
             break;
       case 5 :
             /* EXEC SQL FETCH AR_REC_LINE_CUR
                       INTO :d_ar_line_main_acc1_code,
                            :d_ar_line_main_acc2_code,
                            :d_ar_line_dept_code,
                            :d_ar_line_product_group_code,
                            :d_ar_line_product_line_code,
                            :d_ar_line_sub_group_code,
                            :d_ar_line_sub_line_code,
                            :d_ar_line_amt_local,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :d_ar_line_narration; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 34;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )2075;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_ar_line_main_acc1_code;
             sqlstm.sqhstl[0] = (unsigned int  )11;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_line_main_acc2_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_line_dept_code;
             sqlstm.sqhstl[2] = (unsigned int  )9;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_line_product_group_code;
             sqlstm.sqhstl[3] = (unsigned int  )6;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_line_product_line_code;
             sqlstm.sqhstl[4] = (unsigned int  )7;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_line_sub_group_code;
             sqlstm.sqhstl[5] = (unsigned int  )6;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_line_sub_line_code;
             sqlstm.sqhstl[6] = (unsigned int  )11;
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_line_amt_local;
             sqlstm.sqhstl[7] = (unsigned int  )19;
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[8] = (unsigned int  )19;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[10] = (unsigned int  )19;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_line_narration;
             sqlstm.sqhstl[11] = (unsigned int  )53;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
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
                  err_mesg("FETCH failed on cursor AR_REC_LINE_CUR",0,"");
             break;
       case 6 :
             /* EXEC SQL FETCH AR_PAY_LINE_CUR
                       INTO :d_ar_line_main_acc1_code,
                            :d_ar_line_main_acc2_code,
                            :d_ar_line_dept_code,
                            :d_ar_line_product_group_code,
                            :d_ar_line_product_line_code,
                            :d_ar_line_sub_group_code,
                            :d_ar_line_sub_line_code,
                            :d_ar_line_amt_local,
                            :l_gd_amount,
                            :l_gd_sign_amount,
                            :l_gd_amount_negative,
                            :d_ar_line_narration; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 34;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )2138;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&d_ar_line_main_acc1_code;
             sqlstm.sqhstl[0] = (unsigned int  )11;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_ar_line_main_acc2_code;
             sqlstm.sqhstl[1] = (unsigned int  )9;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_ar_line_dept_code;
             sqlstm.sqhstl[2] = (unsigned int  )9;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&d_ar_line_product_group_code;
             sqlstm.sqhstl[3] = (unsigned int  )6;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&d_ar_line_product_line_code;
             sqlstm.sqhstl[4] = (unsigned int  )7;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&d_ar_line_sub_group_code;
             sqlstm.sqhstl[5] = (unsigned int  )6;
             sqlstm.sqhsts[5] = (         int  )0;
             sqlstm.sqindv[5] = (         void  *)0;
             sqlstm.sqinds[5] = (         int  )0;
             sqlstm.sqharm[5] = (unsigned int  )0;
             sqlstm.sqadto[5] = (unsigned short )0;
             sqlstm.sqtdso[5] = (unsigned short )0;
             sqlstm.sqhstv[6] = (         void  *)&d_ar_line_sub_line_code;
             sqlstm.sqhstl[6] = (unsigned int  )11;
             sqlstm.sqhsts[6] = (         int  )0;
             sqlstm.sqindv[6] = (         void  *)0;
             sqlstm.sqinds[6] = (         int  )0;
             sqlstm.sqharm[6] = (unsigned int  )0;
             sqlstm.sqadto[6] = (unsigned short )0;
             sqlstm.sqtdso[6] = (unsigned short )0;
             sqlstm.sqhstv[7] = (         void  *)&d_ar_line_amt_local;
             sqlstm.sqhstl[7] = (unsigned int  )19;
             sqlstm.sqhsts[7] = (         int  )0;
             sqlstm.sqindv[7] = (         void  *)0;
             sqlstm.sqinds[7] = (         int  )0;
             sqlstm.sqharm[7] = (unsigned int  )0;
             sqlstm.sqadto[7] = (unsigned short )0;
             sqlstm.sqtdso[7] = (unsigned short )0;
             sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
             sqlstm.sqhstl[8] = (unsigned int  )19;
             sqlstm.sqhsts[8] = (         int  )0;
             sqlstm.sqindv[8] = (         void  *)0;
             sqlstm.sqinds[8] = (         int  )0;
             sqlstm.sqharm[8] = (unsigned int  )0;
             sqlstm.sqadto[8] = (unsigned short )0;
             sqlstm.sqtdso[8] = (unsigned short )0;
             sqlstm.sqhstv[9] = (         void  *)&l_gd_sign_amount;
             sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
             sqlstm.sqhsts[9] = (         int  )0;
             sqlstm.sqindv[9] = (         void  *)0;
             sqlstm.sqinds[9] = (         int  )0;
             sqlstm.sqharm[9] = (unsigned int  )0;
             sqlstm.sqadto[9] = (unsigned short )0;
             sqlstm.sqtdso[9] = (unsigned short )0;
             sqlstm.sqhstv[10] = (         void  *)&l_gd_amount_negative;
             sqlstm.sqhstl[10] = (unsigned int  )19;
             sqlstm.sqhsts[10] = (         int  )0;
             sqlstm.sqindv[10] = (         void  *)0;
             sqlstm.sqinds[10] = (         int  )0;
             sqlstm.sqharm[10] = (unsigned int  )0;
             sqlstm.sqadto[10] = (unsigned short )0;
             sqlstm.sqtdso[10] = (unsigned short )0;
             sqlstm.sqhstv[11] = (         void  *)&d_ar_line_narration;
             sqlstm.sqhstl[11] = (unsigned int  )53;
             sqlstm.sqhsts[11] = (         int  )0;
             sqlstm.sqindv[11] = (         void  *)0;
             sqlstm.sqinds[11] = (         int  )0;
             sqlstm.sqharm[11] = (unsigned int  )0;
             sqlstm.sqadto[11] = (unsigned short )0;
             sqlstm.sqtdso[11] = (unsigned short )0;
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
                  err_mesg("FETCH failed on cursor AR_PAY_LINE_CUR",0,"");
             break;
     }
     null_term_line();

     if (LAST_ROW)
         return (0);
     else
         return (1);
}

init_line_variables()
{
   d_ar_line_main_acc1_code.arr[0]        = '\0';
   d_ar_line_main_acc2_code.arr[0]        = '\0';
   d_ar_line_dept_code.arr[0]             = '\0';
   d_ar_line_product_group_code.arr[0]    = '\0';
   d_ar_line_product_line_code.arr[0]     = '\0';
   d_ar_line_sub_group_code.arr[0]  = '\0';
   d_ar_line_sub_line_code.arr[0]   = '\0';
   d_ar_line_amt_local.arr[0]             = '\0';
   d_ar_line_narration.arr[0]             = '\0';
   l_gd_amount.arr[0]                     = '\0';
   l_gd_amount_negative.arr[0]            = '\0';


   d_ar_line_main_acc1_code.len           = 0;
   d_ar_line_main_acc2_code.len           = 0;
   d_ar_line_dept_code.len                = 0;
   d_ar_line_product_group_code.len       = 0;
   d_ar_line_product_line_code.len        = 0;
   d_ar_line_sub_group_code.len     = 0;
   d_ar_line_sub_line_code.len      = 0;
   d_ar_line_amt_local.len                = 0;
   d_ar_line_narration.len                = 0;
   l_gd_amount.len                        = 0;
   l_gd_amount_negative.len               = 0;

}

null_term_line()
{
  d_ar_line_main_acc1_code.arr[d_ar_line_main_acc1_code.len]             = '\0';
  d_ar_line_main_acc2_code.arr[d_ar_line_main_acc2_code.len]             = '\0';
  d_ar_line_dept_code.arr[d_ar_line_dept_code.len]                       = '\0';
  d_ar_line_product_group_code.arr[d_ar_line_product_group_code.len]     = '\0';
  d_ar_line_product_line_code.arr[d_ar_line_product_line_code.len]       = '\0';
  d_ar_line_sub_group_code.arr[d_ar_line_sub_group_code.len] = '\0';
  d_ar_line_sub_line_code.arr[d_ar_line_sub_line_code.len]   = '\0';
  d_ar_line_amt_local.arr[d_ar_line_amt_local.len]                       = '\0';
  d_ar_line_narration.arr[d_ar_line_narration.len]                       = '\0';
  l_gd_amount.arr[l_gd_amount.len]                                       = '\0';
  l_gd_amount_negative.arr[l_gd_amount_negative.len]                     = '\0';

}

open_trn_inv_hdr(l_type)
int l_type;
{
     switch(l_type)
     {
        case 2 :
                 /* EXEC SQL OPEN AR_DN_INV_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0018;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )2201;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[0] = (unsigned int  )9;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
                      err_mesg("OPEN failed on cursor AR_DN_INV_HDR_CUR",0,"");
                 break;
        case 3 :  
                 /* EXEC SQL OPEN AR_CN_INV_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0020;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )2224;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[0] = (unsigned int  )9;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
                      err_mesg("OPEN failed on cursor AR_CN_INV_HDR_CUR",0,"");
                 break;
        case 4 :  
                 /* EXEC SQL OPEN AR_ADJ_INV_HDR_CUR; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = sq0022;
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )2247;
                 sqlstm.selerr = (unsigned short)1;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqcmod = (unsigned int )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
                 sqlstm.sqhstl[0] = (unsigned int  )9;
                 sqlstm.sqhsts[0] = (         int  )0;
                 sqlstm.sqindv[0] = (         void  *)0;
                 sqlstm.sqinds[0] = (         int  )0;
                 sqlstm.sqharm[0] = (unsigned int  )0;
                 sqlstm.sqadto[0] = (unsigned short )0;
                 sqlstm.sqtdso[0] = (unsigned short )0;
                 sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
                      err_mesg("OPEN failed on cursor AR_ADJ_INV_HDR_CUR",0,"");
                 break;
       }
}

fetch_trn_inv_hdr(l_type)
int l_type;
{
     init_trn_ihdr_variables();

     switch(l_type)
     {
        case 2 :
               /* EXEC SQL FETCH AR_DN_INV_HDR_CUR
                         INTO :d_ar_hdr_org_doc_type_code,
                              :d_ar_hdr_org_doc_num,
                              :d_ar_hdr_narration,
                              :d_ar_hdr_cust_ref,
                              :d_ar_hdr_main_acc1_code,
                              :d_ar_hdr_main_acc2_code,
                              :d_ar_hdr_dept_code,
                              :d_ar_hdr_product_group_code,
                              :d_ar_hdr_product_line_code,
                              :d_ar_hdr_sub_group_code,
                              :d_ar_hdr_sub_line_code,
                              :d_ar_hdr_amount,
                              :l_gd_amount,
                              :l_gd_sign_amount,
                              :l_gd_amount_negative,
							  :d_cust_code; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 12;
               sqlstm.arrsiz = 34;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )2270;
               sqlstm.selerr = (unsigned short)1;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)4352;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqfoff = (           int )0;
               sqlstm.sqfmod = (unsigned int )2;
               sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_org_doc_type_code;
               sqlstm.sqhstl[0] = (unsigned int  )9;
               sqlstm.sqhsts[0] = (         int  )0;
               sqlstm.sqindv[0] = (         void  *)0;
               sqlstm.sqinds[0] = (         int  )0;
               sqlstm.sqharm[0] = (unsigned int  )0;
               sqlstm.sqadto[0] = (unsigned short )0;
               sqlstm.sqtdso[0] = (unsigned short )0;
               sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_org_doc_num;
               sqlstm.sqhstl[1] = (unsigned int  )11;
               sqlstm.sqhsts[1] = (         int  )0;
               sqlstm.sqindv[1] = (         void  *)0;
               sqlstm.sqinds[1] = (         int  )0;
               sqlstm.sqharm[1] = (unsigned int  )0;
               sqlstm.sqadto[1] = (unsigned short )0;
               sqlstm.sqtdso[1] = (unsigned short )0;
               sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_narration;
               sqlstm.sqhstl[2] = (unsigned int  )53;
               sqlstm.sqhsts[2] = (         int  )0;
               sqlstm.sqindv[2] = (         void  *)0;
               sqlstm.sqinds[2] = (         int  )0;
               sqlstm.sqharm[2] = (unsigned int  )0;
               sqlstm.sqadto[2] = (unsigned short )0;
               sqlstm.sqtdso[2] = (unsigned short )0;
               sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_cust_ref;
               sqlstm.sqhstl[3] = (unsigned int  )18;
               sqlstm.sqhsts[3] = (         int  )0;
               sqlstm.sqindv[3] = (         void  *)0;
               sqlstm.sqinds[3] = (         int  )0;
               sqlstm.sqharm[3] = (unsigned int  )0;
               sqlstm.sqadto[3] = (unsigned short )0;
               sqlstm.sqtdso[3] = (unsigned short )0;
               sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_main_acc1_code;
               sqlstm.sqhstl[4] = (unsigned int  )11;
               sqlstm.sqhsts[4] = (         int  )0;
               sqlstm.sqindv[4] = (         void  *)0;
               sqlstm.sqinds[4] = (         int  )0;
               sqlstm.sqharm[4] = (unsigned int  )0;
               sqlstm.sqadto[4] = (unsigned short )0;
               sqlstm.sqtdso[4] = (unsigned short )0;
               sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_main_acc2_code;
               sqlstm.sqhstl[5] = (unsigned int  )9;
               sqlstm.sqhsts[5] = (         int  )0;
               sqlstm.sqindv[5] = (         void  *)0;
               sqlstm.sqinds[5] = (         int  )0;
               sqlstm.sqharm[5] = (unsigned int  )0;
               sqlstm.sqadto[5] = (unsigned short )0;
               sqlstm.sqtdso[5] = (unsigned short )0;
               sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_dept_code;
               sqlstm.sqhstl[6] = (unsigned int  )9;
               sqlstm.sqhsts[6] = (         int  )0;
               sqlstm.sqindv[6] = (         void  *)0;
               sqlstm.sqinds[6] = (         int  )0;
               sqlstm.sqharm[6] = (unsigned int  )0;
               sqlstm.sqadto[6] = (unsigned short )0;
               sqlstm.sqtdso[6] = (unsigned short )0;
               sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_product_group_code;
               sqlstm.sqhstl[7] = (unsigned int  )6;
               sqlstm.sqhsts[7] = (         int  )0;
               sqlstm.sqindv[7] = (         void  *)0;
               sqlstm.sqinds[7] = (         int  )0;
               sqlstm.sqharm[7] = (unsigned int  )0;
               sqlstm.sqadto[7] = (unsigned short )0;
               sqlstm.sqtdso[7] = (unsigned short )0;
               sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_product_line_code;
               sqlstm.sqhstl[8] = (unsigned int  )7;
               sqlstm.sqhsts[8] = (         int  )0;
               sqlstm.sqindv[8] = (         void  *)0;
               sqlstm.sqinds[8] = (         int  )0;
               sqlstm.sqharm[8] = (unsigned int  )0;
               sqlstm.sqadto[8] = (unsigned short )0;
               sqlstm.sqtdso[8] = (unsigned short )0;
               sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_sub_group_code;
               sqlstm.sqhstl[9] = (unsigned int  )6;
               sqlstm.sqhsts[9] = (         int  )0;
               sqlstm.sqindv[9] = (         void  *)0;
               sqlstm.sqinds[9] = (         int  )0;
               sqlstm.sqharm[9] = (unsigned int  )0;
               sqlstm.sqadto[9] = (unsigned short )0;
               sqlstm.sqtdso[9] = (unsigned short )0;
               sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_sub_line_code;
               sqlstm.sqhstl[10] = (unsigned int  )11;
               sqlstm.sqhsts[10] = (         int  )0;
               sqlstm.sqindv[10] = (         void  *)0;
               sqlstm.sqinds[10] = (         int  )0;
               sqlstm.sqharm[10] = (unsigned int  )0;
               sqlstm.sqadto[10] = (unsigned short )0;
               sqlstm.sqtdso[10] = (unsigned short )0;
               sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_amount;
               sqlstm.sqhstl[11] = (unsigned int  )19;
               sqlstm.sqhsts[11] = (         int  )0;
               sqlstm.sqindv[11] = (         void  *)0;
               sqlstm.sqinds[11] = (         int  )0;
               sqlstm.sqharm[11] = (unsigned int  )0;
               sqlstm.sqadto[11] = (unsigned short )0;
               sqlstm.sqtdso[11] = (unsigned short )0;
               sqlstm.sqhstv[12] = (         void  *)&l_gd_amount;
               sqlstm.sqhstl[12] = (unsigned int  )19;
               sqlstm.sqhsts[12] = (         int  )0;
               sqlstm.sqindv[12] = (         void  *)0;
               sqlstm.sqinds[12] = (         int  )0;
               sqlstm.sqharm[12] = (unsigned int  )0;
               sqlstm.sqadto[12] = (unsigned short )0;
               sqlstm.sqtdso[12] = (unsigned short )0;
               sqlstm.sqhstv[13] = (         void  *)&l_gd_sign_amount;
               sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
               sqlstm.sqhsts[13] = (         int  )0;
               sqlstm.sqindv[13] = (         void  *)0;
               sqlstm.sqinds[13] = (         int  )0;
               sqlstm.sqharm[13] = (unsigned int  )0;
               sqlstm.sqadto[13] = (unsigned short )0;
               sqlstm.sqtdso[13] = (unsigned short )0;
               sqlstm.sqhstv[14] = (         void  *)&l_gd_amount_negative;
               sqlstm.sqhstl[14] = (unsigned int  )19;
               sqlstm.sqhsts[14] = (         int  )0;
               sqlstm.sqindv[14] = (         void  *)0;
               sqlstm.sqinds[14] = (         int  )0;
               sqlstm.sqharm[14] = (unsigned int  )0;
               sqlstm.sqadto[14] = (unsigned short )0;
               sqlstm.sqtdso[14] = (unsigned short )0;
               sqlstm.sqhstv[15] = (         void  *)&d_cust_code;
               sqlstm.sqhstl[15] = (unsigned int  )11;
               sqlstm.sqhsts[15] = (         int  )0;
               sqlstm.sqindv[15] = (         void  *)0;
               sqlstm.sqinds[15] = (         int  )0;
               sqlstm.sqharm[15] = (unsigned int  )0;
               sqlstm.sqadto[15] = (unsigned short )0;
               sqlstm.sqtdso[15] = (unsigned short )0;
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
                   err_mesg("FETCH failed on cursor AR_DN_INV_HDR_CUR",0,"");
               break;
        case 3 :
               /* EXEC SQL FETCH AR_CN_INV_HDR_CUR
                         INTO :d_ar_hdr_org_doc_type_code,
                              :d_ar_hdr_org_doc_num,
                              :d_ar_hdr_narration,
                              :d_ar_hdr_cust_ref,
                              :d_ar_hdr_main_acc1_code,
                              :d_ar_hdr_main_acc2_code,
                              :d_ar_hdr_dept_code,
                              :d_ar_hdr_product_group_code,
                              :d_ar_hdr_product_line_code,
                              :d_ar_hdr_sub_group_code,
                              :d_ar_hdr_sub_line_code,
                              :d_ar_hdr_amount,
                              :l_gd_amount,
                              :l_gd_sign_amount,
                              :l_gd_amount_negative,
							  :d_cust_code; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 12;
               sqlstm.arrsiz = 34;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )2349;
               sqlstm.selerr = (unsigned short)1;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)4352;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqfoff = (           int )0;
               sqlstm.sqfmod = (unsigned int )2;
               sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_org_doc_type_code;
               sqlstm.sqhstl[0] = (unsigned int  )9;
               sqlstm.sqhsts[0] = (         int  )0;
               sqlstm.sqindv[0] = (         void  *)0;
               sqlstm.sqinds[0] = (         int  )0;
               sqlstm.sqharm[0] = (unsigned int  )0;
               sqlstm.sqadto[0] = (unsigned short )0;
               sqlstm.sqtdso[0] = (unsigned short )0;
               sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_org_doc_num;
               sqlstm.sqhstl[1] = (unsigned int  )11;
               sqlstm.sqhsts[1] = (         int  )0;
               sqlstm.sqindv[1] = (         void  *)0;
               sqlstm.sqinds[1] = (         int  )0;
               sqlstm.sqharm[1] = (unsigned int  )0;
               sqlstm.sqadto[1] = (unsigned short )0;
               sqlstm.sqtdso[1] = (unsigned short )0;
               sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_narration;
               sqlstm.sqhstl[2] = (unsigned int  )53;
               sqlstm.sqhsts[2] = (         int  )0;
               sqlstm.sqindv[2] = (         void  *)0;
               sqlstm.sqinds[2] = (         int  )0;
               sqlstm.sqharm[2] = (unsigned int  )0;
               sqlstm.sqadto[2] = (unsigned short )0;
               sqlstm.sqtdso[2] = (unsigned short )0;
               sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_cust_ref;
               sqlstm.sqhstl[3] = (unsigned int  )18;
               sqlstm.sqhsts[3] = (         int  )0;
               sqlstm.sqindv[3] = (         void  *)0;
               sqlstm.sqinds[3] = (         int  )0;
               sqlstm.sqharm[3] = (unsigned int  )0;
               sqlstm.sqadto[3] = (unsigned short )0;
               sqlstm.sqtdso[3] = (unsigned short )0;
               sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_main_acc1_code;
               sqlstm.sqhstl[4] = (unsigned int  )11;
               sqlstm.sqhsts[4] = (         int  )0;
               sqlstm.sqindv[4] = (         void  *)0;
               sqlstm.sqinds[4] = (         int  )0;
               sqlstm.sqharm[4] = (unsigned int  )0;
               sqlstm.sqadto[4] = (unsigned short )0;
               sqlstm.sqtdso[4] = (unsigned short )0;
               sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_main_acc2_code;
               sqlstm.sqhstl[5] = (unsigned int  )9;
               sqlstm.sqhsts[5] = (         int  )0;
               sqlstm.sqindv[5] = (         void  *)0;
               sqlstm.sqinds[5] = (         int  )0;
               sqlstm.sqharm[5] = (unsigned int  )0;
               sqlstm.sqadto[5] = (unsigned short )0;
               sqlstm.sqtdso[5] = (unsigned short )0;
               sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_dept_code;
               sqlstm.sqhstl[6] = (unsigned int  )9;
               sqlstm.sqhsts[6] = (         int  )0;
               sqlstm.sqindv[6] = (         void  *)0;
               sqlstm.sqinds[6] = (         int  )0;
               sqlstm.sqharm[6] = (unsigned int  )0;
               sqlstm.sqadto[6] = (unsigned short )0;
               sqlstm.sqtdso[6] = (unsigned short )0;
               sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_product_group_code;
               sqlstm.sqhstl[7] = (unsigned int  )6;
               sqlstm.sqhsts[7] = (         int  )0;
               sqlstm.sqindv[7] = (         void  *)0;
               sqlstm.sqinds[7] = (         int  )0;
               sqlstm.sqharm[7] = (unsigned int  )0;
               sqlstm.sqadto[7] = (unsigned short )0;
               sqlstm.sqtdso[7] = (unsigned short )0;
               sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_product_line_code;
               sqlstm.sqhstl[8] = (unsigned int  )7;
               sqlstm.sqhsts[8] = (         int  )0;
               sqlstm.sqindv[8] = (         void  *)0;
               sqlstm.sqinds[8] = (         int  )0;
               sqlstm.sqharm[8] = (unsigned int  )0;
               sqlstm.sqadto[8] = (unsigned short )0;
               sqlstm.sqtdso[8] = (unsigned short )0;
               sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_sub_group_code;
               sqlstm.sqhstl[9] = (unsigned int  )6;
               sqlstm.sqhsts[9] = (         int  )0;
               sqlstm.sqindv[9] = (         void  *)0;
               sqlstm.sqinds[9] = (         int  )0;
               sqlstm.sqharm[9] = (unsigned int  )0;
               sqlstm.sqadto[9] = (unsigned short )0;
               sqlstm.sqtdso[9] = (unsigned short )0;
               sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_sub_line_code;
               sqlstm.sqhstl[10] = (unsigned int  )11;
               sqlstm.sqhsts[10] = (         int  )0;
               sqlstm.sqindv[10] = (         void  *)0;
               sqlstm.sqinds[10] = (         int  )0;
               sqlstm.sqharm[10] = (unsigned int  )0;
               sqlstm.sqadto[10] = (unsigned short )0;
               sqlstm.sqtdso[10] = (unsigned short )0;
               sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_amount;
               sqlstm.sqhstl[11] = (unsigned int  )19;
               sqlstm.sqhsts[11] = (         int  )0;
               sqlstm.sqindv[11] = (         void  *)0;
               sqlstm.sqinds[11] = (         int  )0;
               sqlstm.sqharm[11] = (unsigned int  )0;
               sqlstm.sqadto[11] = (unsigned short )0;
               sqlstm.sqtdso[11] = (unsigned short )0;
               sqlstm.sqhstv[12] = (         void  *)&l_gd_amount;
               sqlstm.sqhstl[12] = (unsigned int  )19;
               sqlstm.sqhsts[12] = (         int  )0;
               sqlstm.sqindv[12] = (         void  *)0;
               sqlstm.sqinds[12] = (         int  )0;
               sqlstm.sqharm[12] = (unsigned int  )0;
               sqlstm.sqadto[12] = (unsigned short )0;
               sqlstm.sqtdso[12] = (unsigned short )0;
               sqlstm.sqhstv[13] = (         void  *)&l_gd_sign_amount;
               sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
               sqlstm.sqhsts[13] = (         int  )0;
               sqlstm.sqindv[13] = (         void  *)0;
               sqlstm.sqinds[13] = (         int  )0;
               sqlstm.sqharm[13] = (unsigned int  )0;
               sqlstm.sqadto[13] = (unsigned short )0;
               sqlstm.sqtdso[13] = (unsigned short )0;
               sqlstm.sqhstv[14] = (         void  *)&l_gd_amount_negative;
               sqlstm.sqhstl[14] = (unsigned int  )19;
               sqlstm.sqhsts[14] = (         int  )0;
               sqlstm.sqindv[14] = (         void  *)0;
               sqlstm.sqinds[14] = (         int  )0;
               sqlstm.sqharm[14] = (unsigned int  )0;
               sqlstm.sqadto[14] = (unsigned short )0;
               sqlstm.sqtdso[14] = (unsigned short )0;
               sqlstm.sqhstv[15] = (         void  *)&d_cust_code;
               sqlstm.sqhstl[15] = (unsigned int  )11;
               sqlstm.sqhsts[15] = (         int  )0;
               sqlstm.sqindv[15] = (         void  *)0;
               sqlstm.sqinds[15] = (         int  )0;
               sqlstm.sqharm[15] = (unsigned int  )0;
               sqlstm.sqadto[15] = (unsigned short )0;
               sqlstm.sqtdso[15] = (unsigned short )0;
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
                   err_mesg("FETCH failed on cursor AR_CN_INV_HDR_CUR",0,"");
               break;
        case 4 :
               d_ar_hdr_adj_type.arr[0] = '\0';
               d_ar_hdr_adj_type.len    = 0;
    
               /* EXEC SQL FETCH AR_ADJ_INV_HDR_CUR
                         INTO :d_ar_hdr_org_doc_type_code,
                              :d_ar_hdr_org_doc_num,
                              :d_ar_hdr_narration,
                              :d_ar_hdr_cust_ref,
                              :d_ar_hdr_main_acc1_code,
                              :d_ar_hdr_main_acc2_code,
                              :d_ar_hdr_dept_code,
                              :d_ar_hdr_product_group_code,
                              :d_ar_hdr_product_line_code,
                              :d_ar_hdr_sub_group_code,
                              :d_ar_hdr_sub_line_code,
                              :d_ar_hdr_adj_type,
                              :d_ar_hdr_amount,
                              :l_gd_amount,
                              :l_gd_sign_amount,
                              :l_gd_amount_negative,
							  :d_cust_code; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 12;
               sqlstm.arrsiz = 34;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )2428;
               sqlstm.selerr = (unsigned short)1;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)4352;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqfoff = (           int )0;
               sqlstm.sqfmod = (unsigned int )2;
               sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_org_doc_type_code;
               sqlstm.sqhstl[0] = (unsigned int  )9;
               sqlstm.sqhsts[0] = (         int  )0;
               sqlstm.sqindv[0] = (         void  *)0;
               sqlstm.sqinds[0] = (         int  )0;
               sqlstm.sqharm[0] = (unsigned int  )0;
               sqlstm.sqadto[0] = (unsigned short )0;
               sqlstm.sqtdso[0] = (unsigned short )0;
               sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_org_doc_num;
               sqlstm.sqhstl[1] = (unsigned int  )11;
               sqlstm.sqhsts[1] = (         int  )0;
               sqlstm.sqindv[1] = (         void  *)0;
               sqlstm.sqinds[1] = (         int  )0;
               sqlstm.sqharm[1] = (unsigned int  )0;
               sqlstm.sqadto[1] = (unsigned short )0;
               sqlstm.sqtdso[1] = (unsigned short )0;
               sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_narration;
               sqlstm.sqhstl[2] = (unsigned int  )53;
               sqlstm.sqhsts[2] = (         int  )0;
               sqlstm.sqindv[2] = (         void  *)0;
               sqlstm.sqinds[2] = (         int  )0;
               sqlstm.sqharm[2] = (unsigned int  )0;
               sqlstm.sqadto[2] = (unsigned short )0;
               sqlstm.sqtdso[2] = (unsigned short )0;
               sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_cust_ref;
               sqlstm.sqhstl[3] = (unsigned int  )18;
               sqlstm.sqhsts[3] = (         int  )0;
               sqlstm.sqindv[3] = (         void  *)0;
               sqlstm.sqinds[3] = (         int  )0;
               sqlstm.sqharm[3] = (unsigned int  )0;
               sqlstm.sqadto[3] = (unsigned short )0;
               sqlstm.sqtdso[3] = (unsigned short )0;
               sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_main_acc1_code;
               sqlstm.sqhstl[4] = (unsigned int  )11;
               sqlstm.sqhsts[4] = (         int  )0;
               sqlstm.sqindv[4] = (         void  *)0;
               sqlstm.sqinds[4] = (         int  )0;
               sqlstm.sqharm[4] = (unsigned int  )0;
               sqlstm.sqadto[4] = (unsigned short )0;
               sqlstm.sqtdso[4] = (unsigned short )0;
               sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_main_acc2_code;
               sqlstm.sqhstl[5] = (unsigned int  )9;
               sqlstm.sqhsts[5] = (         int  )0;
               sqlstm.sqindv[5] = (         void  *)0;
               sqlstm.sqinds[5] = (         int  )0;
               sqlstm.sqharm[5] = (unsigned int  )0;
               sqlstm.sqadto[5] = (unsigned short )0;
               sqlstm.sqtdso[5] = (unsigned short )0;
               sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_dept_code;
               sqlstm.sqhstl[6] = (unsigned int  )9;
               sqlstm.sqhsts[6] = (         int  )0;
               sqlstm.sqindv[6] = (         void  *)0;
               sqlstm.sqinds[6] = (         int  )0;
               sqlstm.sqharm[6] = (unsigned int  )0;
               sqlstm.sqadto[6] = (unsigned short )0;
               sqlstm.sqtdso[6] = (unsigned short )0;
               sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_product_group_code;
               sqlstm.sqhstl[7] = (unsigned int  )6;
               sqlstm.sqhsts[7] = (         int  )0;
               sqlstm.sqindv[7] = (         void  *)0;
               sqlstm.sqinds[7] = (         int  )0;
               sqlstm.sqharm[7] = (unsigned int  )0;
               sqlstm.sqadto[7] = (unsigned short )0;
               sqlstm.sqtdso[7] = (unsigned short )0;
               sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_product_line_code;
               sqlstm.sqhstl[8] = (unsigned int  )7;
               sqlstm.sqhsts[8] = (         int  )0;
               sqlstm.sqindv[8] = (         void  *)0;
               sqlstm.sqinds[8] = (         int  )0;
               sqlstm.sqharm[8] = (unsigned int  )0;
               sqlstm.sqadto[8] = (unsigned short )0;
               sqlstm.sqtdso[8] = (unsigned short )0;
               sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_sub_group_code;
               sqlstm.sqhstl[9] = (unsigned int  )6;
               sqlstm.sqhsts[9] = (         int  )0;
               sqlstm.sqindv[9] = (         void  *)0;
               sqlstm.sqinds[9] = (         int  )0;
               sqlstm.sqharm[9] = (unsigned int  )0;
               sqlstm.sqadto[9] = (unsigned short )0;
               sqlstm.sqtdso[9] = (unsigned short )0;
               sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_sub_line_code;
               sqlstm.sqhstl[10] = (unsigned int  )11;
               sqlstm.sqhsts[10] = (         int  )0;
               sqlstm.sqindv[10] = (         void  *)0;
               sqlstm.sqinds[10] = (         int  )0;
               sqlstm.sqharm[10] = (unsigned int  )0;
               sqlstm.sqadto[10] = (unsigned short )0;
               sqlstm.sqtdso[10] = (unsigned short )0;
               sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_adj_type;
               sqlstm.sqhstl[11] = (unsigned int  )5;
               sqlstm.sqhsts[11] = (         int  )0;
               sqlstm.sqindv[11] = (         void  *)0;
               sqlstm.sqinds[11] = (         int  )0;
               sqlstm.sqharm[11] = (unsigned int  )0;
               sqlstm.sqadto[11] = (unsigned short )0;
               sqlstm.sqtdso[11] = (unsigned short )0;
               sqlstm.sqhstv[12] = (         void  *)&d_ar_hdr_amount;
               sqlstm.sqhstl[12] = (unsigned int  )19;
               sqlstm.sqhsts[12] = (         int  )0;
               sqlstm.sqindv[12] = (         void  *)0;
               sqlstm.sqinds[12] = (         int  )0;
               sqlstm.sqharm[12] = (unsigned int  )0;
               sqlstm.sqadto[12] = (unsigned short )0;
               sqlstm.sqtdso[12] = (unsigned short )0;
               sqlstm.sqhstv[13] = (         void  *)&l_gd_amount;
               sqlstm.sqhstl[13] = (unsigned int  )19;
               sqlstm.sqhsts[13] = (         int  )0;
               sqlstm.sqindv[13] = (         void  *)0;
               sqlstm.sqinds[13] = (         int  )0;
               sqlstm.sqharm[13] = (unsigned int  )0;
               sqlstm.sqadto[13] = (unsigned short )0;
               sqlstm.sqtdso[13] = (unsigned short )0;
               sqlstm.sqhstv[14] = (         void  *)&l_gd_sign_amount;
               sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
               sqlstm.sqhsts[14] = (         int  )0;
               sqlstm.sqindv[14] = (         void  *)0;
               sqlstm.sqinds[14] = (         int  )0;
               sqlstm.sqharm[14] = (unsigned int  )0;
               sqlstm.sqadto[14] = (unsigned short )0;
               sqlstm.sqtdso[14] = (unsigned short )0;
               sqlstm.sqhstv[15] = (         void  *)&l_gd_amount_negative;
               sqlstm.sqhstl[15] = (unsigned int  )19;
               sqlstm.sqhsts[15] = (         int  )0;
               sqlstm.sqindv[15] = (         void  *)0;
               sqlstm.sqinds[15] = (         int  )0;
               sqlstm.sqharm[15] = (unsigned int  )0;
               sqlstm.sqadto[15] = (unsigned short )0;
               sqlstm.sqtdso[15] = (unsigned short )0;
               sqlstm.sqhstv[16] = (         void  *)&d_cust_code;
               sqlstm.sqhstl[16] = (unsigned int  )11;
               sqlstm.sqhsts[16] = (         int  )0;
               sqlstm.sqindv[16] = (         void  *)0;
               sqlstm.sqinds[16] = (         int  )0;
               sqlstm.sqharm[16] = (unsigned int  )0;
               sqlstm.sqadto[16] = (unsigned short )0;
               sqlstm.sqtdso[16] = (unsigned short )0;
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
                   err_mesg("FETCH failed on cursor AR_ADJ_INV_HDR_CUR",0,"");

               d_ar_hdr_adj_type.arr[d_ar_hdr_adj_type.len] = '\0';
               break;
     }
     null_term_ihdr();
     if ((strcmp(d_ar_hdr_doc_type_code.arr,
             d_ar_hdr_org_doc_type_code.arr)==0)  &&
          (strcmp(d_ar_hdr_doc_num.arr,d_ar_hdr_org_doc_num.arr)==0))
      {
          strcpy(d_cust_ref1.arr,d_ar_hdr_cust_ref.arr);
          d_cust_ref1.arr[10] = '\0';
          d_cust_ref1.len = strlen(d_cust_ref1.arr);

          strcpy(d_narration1.arr,d_ar_hdr_narration.arr);
          d_narration1.len = strlen(d_narration1.arr);
      }

      strcpy(l_gd_hdr_amount,l_gd_amount.arr);
      l_gd_hdr_sign_amount = l_gd_sign_amount;
      strcpy(l_gd_hdr_amt_negative,l_gd_amount_negative.arr);


     if (LAST_ROW)
         return (0);
     else
         return (1);
}

init_trn_ihdr_variables()
{
  d_ar_hdr_org_doc_type_code.arr[0]     = '\0';
  d_ar_hdr_org_doc_num.arr[0]           = '\0';
  d_ar_hdr_narration.arr[0]             = '\0';
  d_ar_hdr_cust_ref.arr[0]              = '\0';
  d_cust_code.arr[0]                    = '\0';
  d_ar_hdr_main_acc1_code.arr[0]        = '\0';
  d_ar_hdr_main_acc2_code.arr[0]        = '\0';
  d_ar_hdr_dept_code.arr[0]             = '\0';
  d_ar_hdr_product_group_code.arr[0]    = '\0';
  d_ar_hdr_product_line_code.arr[0]     = '\0';
  d_ar_hdr_sub_group_code.arr[0]  = '\0';
  d_ar_hdr_sub_line_code.arr[0]   = '\0';
  d_ar_hdr_amount.arr[0]                = '\0';
  l_gd_amount.arr[0]                    = '\0';
  l_gd_amount_negative.arr[0]           = '\0';

  d_ar_hdr_org_doc_type_code.len        = 0;
  d_ar_hdr_org_doc_num.len              = 0;
  d_ar_hdr_narration.len                = 0;
  d_ar_hdr_cust_ref.len                 = 0;
  d_cust_code.len                       = 0;
  d_ar_hdr_main_acc1_code.len           = 0;
  d_ar_hdr_main_acc2_code.len           = 0;
  d_ar_hdr_dept_code.len                = 0;
  d_ar_hdr_product_group_code.len       = 0;
  d_ar_hdr_product_line_code.len        = 0;
  d_ar_hdr_sub_group_code.len     = 0;
  d_ar_hdr_sub_line_code.len      = 0;
  d_ar_hdr_amount.len                   = 0;
  l_gd_amount.len                       = 0;
  l_gd_amount_negative.len              = 0;

}

null_term_ihdr()
{
    d_ar_hdr_org_doc_type_code.arr[d_ar_hdr_org_doc_type_code.len]       = '\0';
    d_ar_hdr_org_doc_num.arr[d_ar_hdr_org_doc_num.len]                   = '\0';
    d_ar_hdr_narration.arr[d_ar_hdr_narration.len]                       = '\0';
    d_ar_hdr_cust_ref.arr[d_ar_hdr_cust_ref.len]                         = '\0';
	d_cust_code.arr[d_cust_code.len]                                     = '\0';
    d_ar_hdr_main_acc1_code.arr[d_ar_hdr_main_acc1_code.len]             = '\0';
    d_ar_hdr_main_acc2_code.arr[d_ar_hdr_main_acc2_code.len]             = '\0';
    d_ar_hdr_dept_code.arr[d_ar_hdr_dept_code.len]                       = '\0';
    d_ar_hdr_product_group_code.arr[d_ar_hdr_product_group_code.len]     = '\0';
    d_ar_hdr_product_line_code.arr[d_ar_hdr_product_line_code.len]       = '\0';
    d_ar_hdr_sub_group_code.arr[d_ar_hdr_sub_group_code.len] = '\0';
    d_ar_hdr_sub_line_code.arr[d_ar_hdr_sub_line_code.len]   = '\0';
    d_ar_hdr_amount.arr[d_ar_hdr_amount.len]                             = '\0';
    l_gd_amount.arr[l_gd_amount.len]                                     = '\0';
    l_gd_amount_negative.arr[l_gd_amount_negative.len]                   = '\0';

}

delete_rec()
{
   /* EXEC SQL DELETE FROM GL_TXN_DOC_HDR
                  WHERE BATCH_NUM     = 0
                    AND DOC_TYPE_CODE = :d_ar_hdr_doc_type_code
                    AND DOC_NUM       = :d_ar_hdr_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 34;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from GL_TXN_DOC_HDR  where ((BATCH_NUM=0 and DOC_T\
YPE_CODE=:b0) and DOC_NUM=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2511;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
         err_mesg("DELETE failed on table GL_TXN_DOC_HDR",0,"");

   /* EXEC SQL DELETE FROM GL_TXN_DOC_LINE
                  WHERE BATCH_NUM     = 0
                    AND DOC_TYPE_CODE = :d_ar_hdr_doc_type_code
                    AND DOC_NUM       = :d_ar_hdr_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 34;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from GL_TXN_DOC_LINE  where ((BATCH_NUM=0 and DOC_\
TYPE_CODE=:b0) and DOC_NUM=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2534;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
         err_mesg("DELETE failed on table GL_TXN_DOC_LINE",0,"");

   /* EXEC SQL DELETE FROM AR_GL_DISTRBN_TEMP
                  WHERE DOC_TYPE_CODE = :d_ar_hdr_doc_type_code
                    AND DOC_NUM       = :d_ar_hdr_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 34;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from AR_GL_DISTRBN_TEMP  where (DOC_TYPE_CODE=:b0 \
and DOC_NUM=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2557;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
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
         err_mesg("DELETE failed on table AR_GL_DISTRBN_TEMP - 1",0,"");
}

gl_posting()
{
 char r_err_msg[100];

 if (post_doc((long)0,d_ar_hdr_doc_type_code.arr,
              atol(d_ar_hdr_doc_num.arr),r_err_msg) == -1)
        err_mesg(r_err_msg,0,""); 
}

gl_posting_2()
{
 char r_err_msg[100];

 if (post_doc((long)0,tmp_doc_type_code,atol(tmp_doc_num),r_err_msg) == -1)
        err_mesg(r_err_msg,0,""); 
}

update_hdr_rec(l_type)
int l_type;
{
     switch(l_type)
     {
        case 1 :  
                 /* EXEC SQL UPDATE AR_INV_HDR
                             SET INTERFACE_FLAG = 'Y'
                           WHERE ROWID = :d_ar_hdr_rowid; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = "update AR_INV_HDR  set INTERFACE_FLAG='Y' wh\
ere ROWID=:b0";
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )2580;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_rowid;
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
                      err_mesg("UPDATE failed on cursor AR_INV_HDR",0,"");
                 break;
        case 2 :  
		         
                 /* EXEC SQL UPDATE AR_DN_HDR
                             SET INTERFACE_FLAG = 'Y'
                           WHERE ROWID = :d_ar_hdr_rowid; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = "update AR_DN_HDR  set INTERFACE_FLAG='Y' whe\
re ROWID=:b0";
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )2599;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_rowid;
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
                      err_mesg("UPDATE failed on cursor AR_DN_HDR",0,"");
                 break;
        case 3 :  
                 /* EXEC SQL UPDATE AR_CN_HDR
                             SET INTERFACE_FLAG = 'Y'
                           WHERE ROWID = :d_ar_hdr_rowid; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = "update AR_CN_HDR  set INTERFACE_FLAG='Y' whe\
re ROWID=:b0";
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )2618;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_rowid;
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
                      err_mesg("UPDATE failed on cursor AR_CN_HDR",0,"");
                 break;
        case 4 :  
                 /* EXEC SQL UPDATE AR_ADJ_HDR
                             SET INTERFACE_FLAG = 'Y'
                           WHERE ROWID = :d_ar_hdr_rowid; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = "update AR_ADJ_HDR  set INTERFACE_FLAG='Y' wh\
ere ROWID=:b0";
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )2637;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_rowid;
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
                      err_mesg("UPDATE failed on cursor AR_ADJ_HDR",0,"");
                 break;
        case 5 :  

  		         process_off_rec();  
				 
				 /* EXEC SQL UPDATE AR_REC_HDR
                             SET INTERFACE_FLAG = 'Y'
                           WHERE ROWID = :d_ar_hdr_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 34;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update AR_REC_HDR  set INTERFACE_FLAG='Y' where ROWID=:b\
0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2656;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_rowid;
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
                      err_mesg("UPDATE failed on cursor AR_REC_HDR",0,"");
                 break;

				 /* EXEC SQL UPDATE AR_CASHIER
                           SET INTERFACE_FLAG = 'Y'
                           WHERE ROWID = :d_ar_off_hdr_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 34;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update AR_CASHIER  set INTERFACE_FLAG='Y' where ROWID=:b\
0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2675;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_ar_off_hdr_rowid;
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
                      err_mesg("UPDATE failed on cursor AR_CASHIER",0,"");
                 break;

        case 6 :  
                 /* EXEC SQL UPDATE AR_PAY_HDR
                            SET INTERFACE_FLAG = 'Y'
                           WHERE ROWID = :d_ar_hdr_rowid; */ 

{
                 struct sqlexd sqlstm;
                 sqlstm.sqlvsn = 12;
                 sqlstm.arrsiz = 34;
                 sqlstm.sqladtp = &sqladt;
                 sqlstm.sqltdsp = &sqltds;
                 sqlstm.stmt = "update AR_PAY_HDR  set INTERFACE_FLAG='Y' wh\
ere ROWID=:b0";
                 sqlstm.iters = (unsigned int  )1;
                 sqlstm.offset = (unsigned int  )2694;
                 sqlstm.cud = sqlcud0;
                 sqlstm.sqlest = (unsigned char  *)&sqlca;
                 sqlstm.sqlety = (unsigned short)4352;
                 sqlstm.occurs = (unsigned int  )0;
                 sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_rowid;
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
                      err_mesg("UPDATE failed on cursor AR_PAY_HDR",0,"");
                 break;
       }
}

process_summary_1()
{
    open_gl_distrbn_cur1();
    tmp_post_month = 0; 
    tmp_post_year  = 0;
    d_ar_run_line_num = 0;

    strcpy(d_ar_hdr_doc_type_code.arr,nd_tmp_doc_type_code.arr);
    d_ar_hdr_doc_type_code.len = strlen(d_ar_hdr_doc_type_code.arr);    

    while (fetch_distrbn_rec1()) 
    {        
		 
        if ( (tmp_post_month != d_ar_hdr_post_month) ||
             (tmp_post_year  != d_ar_hdr_post_year) )
        {
             insert_gl_hdr_rec();
             gl_posting();
             
			 tmp_post_month = d_ar_hdr_post_month;
             tmp_post_year  = d_ar_hdr_post_year;
             d_ar_run_line_num = 0;
			 
        }
        if (d_ar_run_line_num == 0)
         { 
		   generate_num();
		   update_ar_gl_dist();
          }
        insert_gl_line_rec();
     }
     if (d_ar_run_line_num > 0)
		insert_gl_hdr_rec();
     
     gl_posting();
 

} 

update_ar_gl_dist()
{
     /* EXEC SQL UPDATE AR_GL_DISTRBN
	    SET REF_DOC_TYPE_CODE = :d_ar_hdr_doc_type_code,
			REF_DOC_NUM       = :d_ar_hdr_doc_num
      WHERE REF_PROCESS = :nd_pgm_date
	    AND NVL(REF_FLAG,'N') = 'N' 
		AND POST_YEAR = :d_ar_hdr_post_year
		AND POST_MONTH = :d_ar_hdr_post_month
		AND TRN_TYPE_CODE = :l_gd_trn_type_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 34;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update AR_GL_DISTRBN  set REF_DOC_TYPE_CODE=:b0,REF_DOC_\
NUM=:b1 where ((((REF_PROCESS=:b2 and NVL(REF_FLAG,'N')='N') and POST_YEAR=:b3\
) and POST_MONTH=:b4) and TRN_TYPE_CODE=:b5)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2713;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
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
     sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_post_year;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_post_month;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&l_gd_trn_type_code;
     sqlstm.sqhstl[5] = (unsigned int  )7;
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


          
		  if (OERROR)
                  err_mesg("UPDATE failed on cursor AR_GL_DISTRBN ",0,"");
 
     
   if (!NOT_FOUND)
    {

   /* EXEC SQL INSERT INTO SY_DOC_CONTROL (ACC_ENTITY_CODE,                
										MODULE_ID,                      
										DOC_TYPE_CODE,                  
										DOC_NUM,                        
										DOC_DATE,                       
										POSTED_DATE,                    
										DOC_STATUS,                     
										NARRATION,                      
										POST_MONTH,                     
										POST_YEAR,                      
										CANCELLED_DATE,                 
										ADDED_BY_ID,                    
										ADDED_DATE ,                    
										ADDED_AT_WS_NO ,                
										ADDED_FACILITY_ID,              
										MODIFIED_BY_ID,                 
										MODIFIED_DATE,                  
										MODIFIED_AT_WS_NO,              
										MODIFIED_FACILITY_ID)
                       VALUES		( :nd_acc_entity_code,
					                  'AR',
									  :d_ar_hdr_doc_type_code,
									  :d_ar_hdr_doc_num,
									  TRUNC(SYSDATE),
									  SYSDATE,					            
                                      'P',
									  NULL, 
                                      :d_ar_hdr_post_month,
									  :d_ar_hdr_post_year,
									  TO_DATE(NULL),
									  USER,
									  SYSDATE,
									  NULL,
									  NULL,
									  USER,
									  SYSDATE, 
									  NULL,
									  NULL); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 34;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_DOC_CONTROL (ACC_ENTITY_CODE,MODULE_ID,DOC_\
TYPE_CODE,DOC_NUM,DOC_DATE,POSTED_DATE,DOC_STATUS,NARRATION,POST_MONTH,POST_YE\
AR,CANCELLED_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODI\
FIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,'\
AR',:b1,:b2,TRUNC(SYSDATE),SYSDATE,'P',null ,:b3,:b4,TO_DATE(null ),USER,SYSDA\
TE,null ,null ,USER,SYSDATE,null ,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2752;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_post_month;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_post_year;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
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
                  err_mesg("Insert failed on table SY_DOC_CONTROL 1",0,"");
   }
}
 
open_gl_distrbn_cur1()
{
   /* EXEC SQL OPEN AR_GL_DISTRBN_TEMP_CUR1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 34;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0027;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2787;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
         err_mesg("OPEN failed on cursor AR_GL_DISTRBN_TEMP_CUR1",0,"");
} 

fetch_distrbn_rec1()
{
  d_ar_hdr_main_acc1_code.arr[0]        = '\0';
  d_ar_hdr_main_acc2_code.arr[0]        = '\0';
  d_ar_hdr_dept_code.arr[0]             = '\0';
  d_ar_hdr_product_group_code.arr[0]    = '\0';
  d_ar_hdr_product_line_code.arr[0]     = '\0';
  d_ar_hdr_sub_group_code.arr[0]  = '\0';
  d_ar_hdr_sub_line_code.arr[0]   = '\0';
  d_ar_hdr_amount.arr[0]                = '\0';

  d_ar_hdr_main_acc1_code.len           = 0;
  d_ar_hdr_main_acc2_code.len           = 0;
  d_ar_hdr_dept_code.len                = 0;
  d_ar_hdr_product_group_code.len       = 0;
  d_ar_hdr_product_line_code.len        = 0;
  d_ar_hdr_sub_group_code.len     = 0;
  d_ar_hdr_sub_line_code.len      = 0;
  d_ar_hdr_amount.len                   = 0;
  d_ar_hdr_post_month                   = 0;
  d_ar_hdr_post_year                    = 0;

    /* EXEC SQL FETCH AR_GL_DISTRBN_TEMP_CUR1
              INTO :d_ar_hdr_post_month,
                   :d_ar_hdr_post_year,
                   :d_ar_hdr_main_acc1_code,
                   :d_ar_hdr_main_acc2_code,
                   :d_ar_hdr_dept_code,
                   :d_ar_hdr_product_group_code,
                   :d_ar_hdr_product_line_code,
                   :d_ar_hdr_sub_group_code,
                   :d_ar_hdr_sub_line_code,
                   :d_ar_hdr_amount; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2802;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_post_month;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_post_year;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_main_acc1_code;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_main_acc2_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_dept_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_product_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_product_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_sub_group_code;
    sqlstm.sqhstl[7] = (unsigned int  )6;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_sub_line_code;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_amount;
    sqlstm.sqhstl[9] = (unsigned int  )19;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
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
         err_mesg("FETCH failed on cursor AR_GL_DISTRBN_TEMP_CUR1",0,"");

    d_ar_hdr_main_acc1_code.arr[d_ar_hdr_main_acc1_code.len]             = '\0';
    d_ar_hdr_main_acc2_code.arr[d_ar_hdr_main_acc2_code.len]             = '\0';
    d_ar_hdr_dept_code.arr[d_ar_hdr_dept_code.len]                       = '\0';
    d_ar_hdr_product_group_code.arr[d_ar_hdr_product_group_code.len]     = '\0';
    d_ar_hdr_product_line_code.arr[d_ar_hdr_product_line_code.len]       = '\0';
    d_ar_hdr_sub_group_code.arr[d_ar_hdr_sub_group_code.len] = '\0';
    d_ar_hdr_sub_line_code.arr[d_ar_hdr_sub_line_code.len]   = '\0';
    d_ar_hdr_amount.arr[d_ar_hdr_amount.len]                             = '\0';

    if (tmp_post_month == 0)
    {
        tmp_post_month = d_ar_hdr_post_month;
        tmp_post_year  = d_ar_hdr_post_year;
    }

    if (LAST_ROW) 
       return(0);
    else
       return(1);
 
}

generate_num()
{
     d_ar_hdr_doc_num.arr[0] = '\0';
     d_ar_hdr_doc_num.len    = 0;

     /* EXEC SQL SELECT NVL(NEXT_DOC_NO,0)
                INTO :d_ar_hdr_doc_num
                FROM SY_ACC_ENTITY_DOC_TYPE
               WHERE ROWID = :d_sy_acc_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 34;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(NEXT_DOC_NO,0) into :b0  from SY_ACC_ENTITY_D\
OC_TYPE where ROWID=:b1";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2857;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_num;
     sqlstm.sqhstl[0] = (unsigned int  )11;
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

     d_ar_hdr_doc_num.arr[d_ar_hdr_doc_num.len] = '\0';

     /* EXEC SQL UPDATE SY_ACC_ENTITY_DOC_TYPE 
                 SET NEXT_DOC_NO = NVL(NEXT_DOC_NO,0) + 1
               WHERE ROWID = :d_sy_acc_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 34;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update SY_ACC_ENTITY_DOC_TYPE  set NEXT_DOC_NO=(NVL(NEXT\
_DOC_NO,0)+1) where ROWID=:b0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2880;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
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

insert_gl_line_rec()
{
    d_ar_run_line_num ++;

    sprintf(d_narration1.arr,"AR %s %02d/%04d",trn_desc[t_type],
                         tmp_post_month,
                         tmp_post_year);
    d_narration1.len = strlen(d_narration1.arr);
/*
disp_message (ERR_MESG,d_ar_hdr_doc_type_code.arr);
disp_message (ERR_MESG,d_ar_hdr_doc_num.arr);
sprintf(tempstring,"%d",d_ar_run_line_num);
disp_message (ERR_MESG,tempstring);
*/  
    /* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
           (
              ACC_ENTITY_CODE,
			  BATCH_NUM,
              DOC_TYPE_CODE,
              DOC_NUM,
              MAIN_ACC1_CODE,
              MAIN_ACC2_CODE,
              DEPT_CODE,
              PRODUCT_GROUP_CODE,
              PRODUCT_LINE_CODE,
              SUBLEDGER_GROUP_CODE,
              SUBLEDGER_LINE_CODE,
              LOCAL_AMT,
              NARRATION,
              LINE_NUM,
			  CUST_SUPP_CODE
            )
          VALUES
            (
              :nd_acc_entity_code,
			  0,
              :d_ar_hdr_doc_type_code,
              :d_ar_hdr_doc_num,
              :d_ar_hdr_main_acc1_code,
              :d_ar_hdr_main_acc2_code,
              :d_ar_hdr_dept_code,
              :d_ar_hdr_product_group_code,
              :d_ar_hdr_product_line_code,
              :d_ar_hdr_sub_group_code,
              :d_ar_hdr_sub_line_code,
              :d_ar_hdr_amount,
              :d_narration1,
              :d_ar_run_line_num,
			  :d_cust_code
            ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DO\
C_TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE\
,PRODUCT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,LOCAL_AMT,NARRATIO\
N,LINE_NUM,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:\
b10,:b11,:b12,:b13)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2899;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_main_acc1_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_main_acc2_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_dept_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_product_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_product_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_sub_group_code;
    sqlstm.sqhstl[8] = (unsigned int  )6;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_sub_line_code;
    sqlstm.sqhstl[9] = (unsigned int  )11;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_amount;
    sqlstm.sqhstl[10] = (unsigned int  )19;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_narration1;
    sqlstm.sqhstl[11] = (unsigned int  )53;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_ar_run_line_num;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[13] = (unsigned int  )11;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
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
           err_mesg("INSERT failed on table GL_TXN_DOC_LINE - 3",0,"");

}

insert_gl_hdr_rec()
{
       d_gl_dist_post_month  = tmp_post_month;
       d_gl_dist_post_year   = tmp_post_year;


       /* EXEC SQL INSERT INTO GL_TXN_DOC_HDR
              (
                ACC_ENTITY_CODE,
				BATCH_NUM,
                DOC_TYPE_CODE,
                DOC_NUM,
                DOC_DATE,
                DOC_REF,
                NARRATION,
                POST_MONTH,
                POST_YEAR,
                CTRL_AMT,
                ADDED_BY_ID,
                MODIFIED_BY_ID,
                ADDED_DATE,
                MODIFIED_DATE,
                MAX_LINE_NUM,
                MODULE_ID
              )
            VALUES
              (
                :nd_acc_entity_code,
				0,
                :d_ar_hdr_doc_type_code,
                :d_ar_hdr_doc_num,
                SYSDATE,
                NULL,
                NULL,
                :d_gl_dist_post_month,
                :d_gl_dist_post_year,
                0,
                USER,
                USER,
                SYSDATE,
                SYSDATE,
                :d_ar_run_line_num,
                'AR'
             ); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 34;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "insert into GL_TXN_DOC_HDR (ACC_ENTITY_CODE,BATCH_NUM,\
DOC_TYPE_CODE,DOC_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT\
,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID) v\
alues (:b0,0,:b1,:b2,SYSDATE,null ,null ,:b3,:b4,0,USER,USER,SYSDATE,SYSDATE,:\
b5,'AR')";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )2970;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
       sqlstm.sqhstl[0] = (unsigned int  )7;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )11;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_gl_dist_post_month;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_gl_dist_post_year;
       sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_run_line_num;
       sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
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



    if (OERROR)
         err_mesg("INSERT failed on table GL_TXN_DOC_HDR - 2 - HAHA 2",0,"");

}

process_summary_2()
{
    tmp_doc_type_code[0] = '\0';
    tmp_doc_num[0]       = '\0';
    d_ar_run_line_num = 0;
    
    open_gl_distrbn_cur2();
    while (fetch_distrbn_rec2())
    {
         if ( (strcmp(tmp_doc_type_code,d_ar_hdr_doc_type_code.arr) != 0) ||
              (strcmp(tmp_doc_num,d_ar_hdr_doc_num.arr) != 0) )
         {
             insert_gl_hdr_rec2();
             gl_posting_2();

             d_ar_run_line_num = 0;

             strcpy(tmp_doc_type_code,d_ar_hdr_doc_type_code.arr);
             strcpy(tmp_doc_num,d_ar_hdr_doc_num.arr);
             strcpy(tmp_doc_date,d_ar_hdr_doc_date.arr);

             tmp_post_month = d_ar_hdr_post_month;
             tmp_post_year  = d_ar_hdr_post_year;

             strcpy(d_cust_ref1.arr,d_ar_hdr_doc_ref.arr);
             d_cust_ref1.arr[10] = '\0';
             d_cust_ref1.len = strlen(d_cust_ref1.arr);

             strcpy(d_narration1.arr,d_ar_hdr_narration.arr);
             d_narration1.len = strlen(d_narration1.arr);
         }
         insert_gl_line_rec2();

         strcpy(l_prv_cheque_num.arr,l_gd_cheque_num.arr);
         l_prv_cheque_num.len = strlen(l_prv_cheque_num.arr);

    }
    if (d_ar_run_line_num > 0)
    {
        insert_gl_hdr_rec2();
        gl_posting_2();
    }

}

open_gl_distrbn_cur2()
{
   /* EXEC SQL OPEN AR_GL_DISTRBN_TEMP_CUR2; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 34;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0028;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3009;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
         err_mesg("OPEN failed on cursor AR_GL_DISTRBN_TEMP_CUR2",0,"");
}

fetch_distrbn_rec2()
{

  d_ar_hdr_doc_type_code.arr[0]         = '\0';
  d_ar_hdr_doc_num.arr[0]               = '\0';
  d_ar_hdr_doc_date.arr[0]              = '\0';
  d_ar_hdr_doc_ref.arr[0]               = '\0';
  d_ar_hdr_main_acc1_code.arr[0]        = '\0';
  d_ar_hdr_main_acc2_code.arr[0]        = '\0';
  d_ar_hdr_dept_code.arr[0]             = '\0';
  d_ar_hdr_product_group_code.arr[0]    = '\0';
  d_ar_hdr_product_line_code.arr[0]     = '\0';
  d_ar_hdr_sub_group_code.arr[0]  = '\0';
  d_ar_hdr_sub_line_code.arr[0]   = '\0';
  d_ar_hdr_amount.arr[0]                = '\0';
  d_ar_hdr_narration.arr[0]             = '\0';
  l_gd_cheque_num.arr[0]                = '\0';

  d_ar_hdr_main_acc1_code.len           = 0;
  d_ar_hdr_main_acc2_code.len           = 0;
  d_ar_hdr_dept_code.len                = 0;
  d_ar_hdr_product_group_code.len       = 0;
  d_ar_hdr_product_line_code.len        = 0;
  d_ar_hdr_sub_group_code.len     = 0;
  d_ar_hdr_sub_line_code.len      = 0;
  d_ar_hdr_amount.len                   = 0;
  d_ar_hdr_narration.len                = 0;
  l_gd_cheque_num.len                   = 0;

  d_ar_hdr_post_month                   = 0;
  d_ar_hdr_post_year                    = 0;

      /* EXEC SQL FETCH AR_GL_DISTRBN_TEMP_CUR2
                INTO :d_ar_hdr_doc_type_code,
                     :d_ar_hdr_doc_num,
                     :d_ar_hdr_doc_date,
                     :d_ar_hdr_doc_ref,
                     :d_ar_hdr_main_acc1_code,
                     :d_ar_hdr_main_acc2_code,
                     :d_ar_hdr_dept_code,
                     :d_ar_hdr_product_group_code,
                     :d_ar_hdr_product_line_code,
                     :d_ar_hdr_sub_group_code,
                     :d_ar_hdr_sub_line_code,
                     :d_ar_hdr_amount,
                     :d_ar_hdr_narration,
                     :d_ar_hdr_post_month,
                     :d_ar_hdr_post_year,
					 :l_gd_cheque_num; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 34;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )3024;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
      sqlstm.sqhstl[1] = (unsigned int  )11;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_date;
      sqlstm.sqhstl[2] = (unsigned int  )14;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_doc_ref;
      sqlstm.sqhstl[3] = (unsigned int  )18;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_main_acc1_code;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_main_acc2_code;
      sqlstm.sqhstl[5] = (unsigned int  )9;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_dept_code;
      sqlstm.sqhstl[6] = (unsigned int  )9;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_product_group_code;
      sqlstm.sqhstl[7] = (unsigned int  )6;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_product_line_code;
      sqlstm.sqhstl[8] = (unsigned int  )7;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_sub_group_code;
      sqlstm.sqhstl[9] = (unsigned int  )6;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_sub_line_code;
      sqlstm.sqhstl[10] = (unsigned int  )11;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&d_ar_hdr_amount;
      sqlstm.sqhstl[11] = (unsigned int  )19;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&d_ar_hdr_narration;
      sqlstm.sqhstl[12] = (unsigned int  )53;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&d_ar_hdr_post_month;
      sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&d_ar_hdr_post_year;
      sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&l_gd_cheque_num;
      sqlstm.sqhstl[15] = (unsigned int  )13;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
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
         err_mesg("FETCH failed on cursor AR_GL_DISTRBN_TEMP_CUR2",0,"");

    d_ar_hdr_doc_type_code.arr[d_ar_hdr_doc_type_code.len]               = '\0';
    d_ar_hdr_doc_num.arr[d_ar_hdr_doc_num.len]                           = '\0';
    d_ar_hdr_doc_date.arr[d_ar_hdr_doc_date.len]                         = '\0';
    d_ar_hdr_doc_ref.arr[d_ar_hdr_doc_ref.len]                           = '\0';
    d_ar_hdr_main_acc1_code.arr[d_ar_hdr_main_acc1_code.len]             = '\0';
    d_ar_hdr_main_acc2_code.arr[d_ar_hdr_main_acc2_code.len]             = '\0';
    d_ar_hdr_dept_code.arr[d_ar_hdr_dept_code.len]                       = '\0';
    d_ar_hdr_product_group_code.arr[d_ar_hdr_product_group_code.len]     = '\0';
    d_ar_hdr_product_line_code.arr[d_ar_hdr_product_line_code.len]       = '\0';
    d_ar_hdr_sub_group_code.arr[d_ar_hdr_sub_group_code.len] = '\0';
    d_ar_hdr_sub_line_code.arr[d_ar_hdr_sub_line_code.len]   = '\0';
    d_ar_hdr_amount.arr[d_ar_hdr_amount.len]                             = '\0';
    d_ar_hdr_narration.arr[d_ar_hdr_narration.len]                       = '\0';
    l_gd_cheque_num.arr[l_gd_cheque_num.len]                             = '\0';

     if (strlen(tmp_doc_type_code) == 0)
     {
          strcpy(tmp_doc_type_code,d_ar_hdr_doc_type_code.arr);
          strcpy(tmp_doc_num,d_ar_hdr_doc_num.arr);
          strcpy(tmp_doc_date,d_ar_hdr_doc_date.arr);
          tmp_post_month = d_ar_hdr_post_month;
          tmp_post_year  = d_ar_hdr_post_year;

          strcpy(d_cust_ref1.arr,d_ar_hdr_doc_ref.arr);
          d_cust_ref1.arr[10] = '\0';
          d_cust_ref1.len = strlen(d_cust_ref1.arr);

          strcpy(d_narration1.arr,d_ar_hdr_narration.arr);
          d_narration1.len = strlen(d_narration1.arr);
      }

    if (LAST_ROW)
         return(0);
    else
         return(1);
}

insert_gl_line_rec2()
{
    d_ar_run_line_num++;

    sprintf(d_narration1.arr,"AR %s %02d/%04d",trn_desc[t_type],
                         tmp_post_month,
                         tmp_post_year);
    d_narration1.len = strlen(d_narration1.arr);
/*
disp_message (ERR_MESG,d_ar_hdr_doc_type_code.arr);
disp_message (ERR_MESG,d_ar_hdr_doc_num.arr);
sprintf(tempstring,"%d",d_ar_run_line_num);
disp_message (ERR_MESG,tempstring);
*/ 
        /* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
               (
                 ACC_ENTITY_CODE,
				 BATCH_NUM,
                 DOC_TYPE_CODE,
                 DOC_NUM,
                 MAIN_ACC1_CODE,
                 MAIN_ACC2_CODE,
                 DEPT_CODE,
                 PRODUCT_GROUP_CODE,
                 PRODUCT_LINE_CODE,
                 SUBLEDGER_GROUP_CODE,
                 SUBLEDGER_LINE_CODE,
                 LOCAL_AMT,
                 NARRATION,
                 LINE_NUM,
				 CUST_SUPP_CODE
               )
             VALUES
               (
                 :nd_acc_entity_code,
				 0,
                 :d_ar_hdr_doc_type_code,
                 :d_ar_hdr_doc_num,
                 :d_ar_hdr_main_acc1_code,
                 :d_ar_hdr_main_acc2_code,
                 :d_ar_hdr_dept_code,
                 :d_ar_hdr_product_group_code,
                 :d_ar_hdr_product_line_code,
                 :d_ar_hdr_sub_group_code,
                 :d_ar_hdr_sub_line_code,
                 :d_ar_hdr_amount,
                 :d_narration1,
                 :d_ar_run_line_num,
				 :d_cust_code
               ); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 34;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NU\
M,DOC_TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_\
CODE,PRODUCT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,LOCAL_AMT,NARR\
ATION,LINE_NUM,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:\
b9,:b10,:b11,:b12,:b13)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )3103;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
        sqlstm.sqhstl[0] = (unsigned int  )7;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_ar_hdr_main_acc1_code;
        sqlstm.sqhstl[3] = (unsigned int  )11;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_ar_hdr_main_acc2_code;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_ar_hdr_dept_code;
        sqlstm.sqhstl[5] = (unsigned int  )9;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_product_group_code;
        sqlstm.sqhstl[6] = (unsigned int  )6;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&d_ar_hdr_product_line_code;
        sqlstm.sqhstl[7] = (unsigned int  )7;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&d_ar_hdr_sub_group_code;
        sqlstm.sqhstl[8] = (unsigned int  )6;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_sub_line_code;
        sqlstm.sqhstl[9] = (unsigned int  )11;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&d_ar_hdr_amount;
        sqlstm.sqhstl[10] = (unsigned int  )19;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&d_narration1;
        sqlstm.sqhstl[11] = (unsigned int  )53;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&d_ar_run_line_num;
        sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&d_cust_code;
        sqlstm.sqhstl[13] = (unsigned int  )11;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
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
           err_mesg("INSERT failed on table GL_TXN_DOC_LINE - 2",0,"");

}

insert_gl_hdr_rec2()
{
      strcpy(d_gl_dist_doc_type_code.arr,tmp_doc_type_code);
      strcpy(d_gl_dist_doc_num.arr,tmp_doc_num);
      strcpy(d_gl_dist_doc_date.arr,tmp_doc_date);

      d_gl_dist_doc_type_code.len = strlen(d_gl_dist_doc_type_code.arr);
      d_gl_dist_doc_num.len       = strlen(d_gl_dist_doc_num.arr);
      d_gl_dist_doc_date.len      = strlen(d_gl_dist_doc_date.arr);

      d_gl_dist_post_month = tmp_post_month;
      d_gl_dist_post_year  = tmp_post_year;

       /* EXEC SQL INSERT INTO GL_TXN_DOC_HDR
              (
                ACC_ENTITY_CODE,
				BATCH_NUM,
                DOC_TYPE_CODE,
                DOC_NUM,
                DOC_DATE,
                DOC_REF,
                NARRATION,
                POST_MONTH,
                POST_YEAR,
                CTRL_AMT,
                ADDED_BY_ID,
                MODIFIED_BY_ID,
                ADDED_DATE,
                MODIFIED_DATE,
                MAX_LINE_NUM,
                MODULE_ID
              )
            VALUES
              (
                :nd_acc_entity_code,
				0,
                :d_gl_dist_doc_type_code,
                :d_gl_dist_doc_num,
                TO_DATE(:d_gl_dist_doc_date,'DD/MM/YYYY'),
                NULL,
                NULL,
                :d_gl_dist_post_month,
                :d_gl_dist_post_year,
                0,
                USER,
                USER,
                SYSDATE,
                SYSDATE,
                :d_ar_run_line_num,
                'AR'
             ); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 34;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "insert into GL_TXN_DOC_HDR (ACC_ENTITY_CODE,BATCH_NUM,\
DOC_TYPE_CODE,DOC_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT\
,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID) v\
alues (:b0,0,:b1,:b2,TO_DATE(:b3,'DD/MM/YYYY'),null ,null ,:b4,:b5,0,USER,USER\
,SYSDATE,SYSDATE,:b6,'AR')";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )3174;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
       sqlstm.sqhstl[0] = (unsigned int  )7;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_gl_dist_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_gl_dist_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )11;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_gl_dist_doc_date;
       sqlstm.sqhstl[3] = (unsigned int  )14;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_gl_dist_post_month;
       sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_gl_dist_post_year;
       sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_run_line_num;
       sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
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
         err_mesg("INSERT failed on table GL_TXN_DOC_HDR - HAHA 3",0,"");
}

insert_distrbn(hdr_line) /* 0 -> Hdr   1 -> Line */
int hdr_line;
{


    /* EXEC SQL BEGIN DECLARE SECTION; */ 

       int l_ins_flg = 0;
    /* EXEC SQL END DECLARE SECTION; */ 



    l_ins_flg = hdr_line;

    if (hdr_line == 0 && d_ar_switch == 0)
    {
        strcpy(l_gd_amount.arr,l_gd_hdr_amount);
        l_gd_amount.len = strlen(l_gd_amount.arr);

        l_gd_sign_amount = l_gd_hdr_sign_amount;

        strcpy(l_gd_amount_negative.arr,l_gd_hdr_amt_negative);
        l_gd_amount_negative.len = strlen(l_gd_amount_negative.arr);
    }


 
   calculate_credit_debit(hdr_line);

    if (strcmp(l_gd_trn_type_code.arr,"PAY") != 0)
    {
        strcpy(d_gd_hdr_cust_ref.arr,d_ar_hdr_cust_ref.arr);
        d_gd_hdr_cust_ref.len = strlen(d_gd_hdr_cust_ref.arr);
    }


   fetch_bank_reconcile(hdr_line);
        
   /* EXEC SQL INSERT INTO AR_GL_DISTRBN
            (
               DOC_TYPE_CODE,
               DOC_NUM,
               DOC_DATE,
               DOC_REF,
               CUST_CODE,
               MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               DEBIT_AMT,
               CREDIT_AMT,
               NARRATION,
               POST_MONTH,
               POST_YEAR,
               CHEQUE_NUM,
               CHEQUE_DATE,
               TRN_TYPE_CODE,
			   REF_FLAG ,
			   REF_PROCESS
            )
        VALUES
            (
            :d_ar_hdr_doc_type_code,
            :d_ar_hdr_doc_num,
            to_date(:d_ar_hdr_doc_date,'DD/MM/YYYY'),
            :d_gd_hdr_cust_ref,
            :d_cust_code, 
            DECODE(:l_ins_flg,'0',
                :d_ar_hdr_main_acc1_code, :d_ar_line_main_acc1_code),
            DECODE(:l_ins_flg,'0',
                 :d_ar_hdr_main_acc2_code, :d_ar_line_main_acc2_code),
            DECODE(:l_ins_flg,'0',
                 :d_ar_hdr_dept_code, :d_ar_line_dept_code),
            DECODE(:l_ins_flg,'0',
                 :d_ar_hdr_product_group_code, :d_ar_line_product_group_code),
            DECODE(:l_ins_flg,'0',
                 :d_ar_hdr_product_line_code, :d_ar_line_product_line_code),
            DECODE(:l_ins_flg,'0',
               :d_ar_hdr_sub_group_code, :d_ar_line_sub_group_code),
            DECODE(:l_ins_flg,'0',
                 :d_ar_hdr_sub_line_code, :d_ar_line_sub_line_code),
            ABS(:l_gd_debit_amt),
            :l_gd_credit_amt,
            DECODE(:l_ins_flg,'0',:d_ar_hdr_narration,:d_ar_line_narration),
            :d_ar_hdr_post_month,
            :d_ar_hdr_post_year, 
            :l_gd_cheque_num,
            to_date(:l_gd_cheque_date,'DD/MM/YYYY'),
            :l_gd_trn_type_code,
			:d_ar_bank_reconcile_flg,
		    :nd_pgm_date
            ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 38;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_GL_DISTRBN (DOC_TYPE_CODE,DOC_NUM,DOC_DATE,\
DOC_REF,CUST_CODE,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,P\
RODUCT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEBIT_AMT,CREDIT_AMT\
,NARRATION,POST_MONTH,POST_YEAR,CHEQUE_NUM,CHEQUE_DATE,TRN_TYPE_CODE,REF_FLAG,\
REF_PROCESS) values (:b0,:b1,to_date(:b2,'DD/MM/YYYY'),:b3,:b4,DECODE(:b5,'0',\
:b6,:b7),DECODE(:b5,'0',:b9,:b10),DECODE(:b5,'0',:b12,:b13),DECODE(:b5,'0',:b1\
5,:b16),DECODE(:b5,'0',:b18,:b19),DECODE(:b5,'0',:b21,:b22),DECODE(:b5,'0',:b2\
4,:b25),ABS(:b26),:b27,DECODE(:b5,'0',:b29,:b30),:b31,:b32,:b33,to_date(:b34,'\
DD/MM/YYYY'),:b35,:b36,:b37)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3217;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_hdr_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_hdr_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_gd_hdr_cust_ref;
   sqlstm.sqhstl[3] = (unsigned int  )18;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_ins_flg;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_ar_hdr_main_acc1_code;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_ar_line_main_acc1_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_ins_flg;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_ar_hdr_main_acc2_code;
   sqlstm.sqhstl[9] = (unsigned int  )9;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_ar_line_main_acc2_code;
   sqlstm.sqhstl[10] = (unsigned int  )9;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_ins_flg;
   sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_ar_hdr_dept_code;
   sqlstm.sqhstl[12] = (unsigned int  )9;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_ar_line_dept_code;
   sqlstm.sqhstl[13] = (unsigned int  )9;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&l_ins_flg;
   sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_ar_hdr_product_group_code;
   sqlstm.sqhstl[15] = (unsigned int  )6;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_ar_line_product_group_code;
   sqlstm.sqhstl[16] = (unsigned int  )6;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&l_ins_flg;
   sqlstm.sqhstl[17] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_ar_hdr_product_line_code;
   sqlstm.sqhstl[18] = (unsigned int  )7;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_ar_line_product_line_code;
   sqlstm.sqhstl[19] = (unsigned int  )7;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&l_ins_flg;
   sqlstm.sqhstl[20] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_ar_hdr_sub_group_code;
   sqlstm.sqhstl[21] = (unsigned int  )6;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_ar_line_sub_group_code;
   sqlstm.sqhstl[22] = (unsigned int  )6;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&l_ins_flg;
   sqlstm.sqhstl[23] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_ar_hdr_sub_line_code;
   sqlstm.sqhstl[24] = (unsigned int  )11;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_ar_line_sub_line_code;
   sqlstm.sqhstl[25] = (unsigned int  )11;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&l_gd_debit_amt;
   sqlstm.sqhstl[26] = (unsigned int  )19;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&l_gd_credit_amt;
   sqlstm.sqhstl[27] = (unsigned int  )19;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&l_ins_flg;
   sqlstm.sqhstl[28] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&d_ar_hdr_narration;
   sqlstm.sqhstl[29] = (unsigned int  )53;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&d_ar_line_narration;
   sqlstm.sqhstl[30] = (unsigned int  )53;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&d_ar_hdr_post_month;
   sqlstm.sqhstl[31] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&d_ar_hdr_post_year;
   sqlstm.sqhstl[32] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&l_gd_cheque_num;
   sqlstm.sqhstl[33] = (unsigned int  )13;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&l_gd_cheque_date;
   sqlstm.sqhstl[34] = (unsigned int  )17;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&l_gd_trn_type_code;
   sqlstm.sqhstl[35] = (unsigned int  )7;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&d_ar_bank_reconcile_flg;
   sqlstm.sqhstl[36] = (unsigned int  )5;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[37] = (unsigned int  )27;
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
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
           err_mesg("INSERT failed on table AR_GL_DISTRBN",0,"");
 
}

calculate_credit_debit(hdr_line) /* 0 -> Hdr   1 -> Line */
int hdr_line;
{
  switch  (t_type) 
  {
      case 1 : 
               strcpy(l_gd_trn_type_code.arr,"INV");
               if ( !hdr_line )   /* Hdr rec */
                   Debit();
               else if (l_gd_sign_amount == -1)          /* -ve */
                       Debit(); 
                    else 
                       Credit ();
               break; 
      case 2 :
               strcpy(l_gd_trn_type_code.arr,"DEB");
               if ( !hdr_line )   /* Hdr rec */
                   Debit();
               else if (l_gd_sign_amount == -1)          /* -ve */
                       Debit(); 
                    else 
                       Credit();
               break;
      case 3 : 
               strcpy(l_gd_trn_type_code.arr,"CRE");
               if ( !hdr_line )   /* Hdr rec */
                   Credit();
               else if (l_gd_sign_amount == -1)          /* -ve */
                       Credit(); 
                    else 
                       Debit();
               break;
      case 4 : 
               strcpy(l_gd_trn_type_code.arr,"ADJ");
               if ( !hdr_line )   /* Hdr rec */
               {
                   if (d_ar_hdr_adj_type.arr[0] == 'D')
                        Debit();
                   else
                        Credit();
               }
               else if (l_gd_sign_amount == -1)          /* -ve */
                    {
                       if (d_ar_hdr_adj_type.arr[0] == 'D')
                            Debit();
                       else
                            Credit();
                    }
                    else 
                    {
                       if (d_ar_hdr_adj_type.arr[0] == 'D')
                            Credit();
                       else
                            Debit();
                    }
               break;
      case 5 :
               strcpy(l_gd_trn_type_code.arr,"REC");
               if ( !hdr_line )   /* Hdr rec */
                       Debit();
               else if (l_gd_sign_amount == -1)          /* -ve */
                       Debit(); 
                  else 
                       Credit();
               break;
      case 6 :
               strcpy(l_gd_trn_type_code.arr,"PAY");
               if ( !hdr_line )   /* Hdr rec */
                   Credit();
               else if (l_gd_sign_amount == -1)          /* -ve */
                       Debit();
                  else 
                       Credit(); 
               break;
    }

    l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);
}

Credit()
{
   if (l_gd_sign_amount == 0)
         strcpy(l_gd_credit_amt.arr,"");
   else
   {
       if (l_gd_sign_amount == -1)
         strcpy(l_gd_credit_amt.arr,l_gd_amount_negative.arr);
       else
         strcpy(l_gd_credit_amt.arr,l_gd_amount.arr);
    }

   strcpy(l_gd_debit_amt.arr,"");

   l_gd_credit_amt.len = strlen(l_gd_credit_amt.arr);
   l_gd_debit_amt.len = strlen(l_gd_debit_amt.arr);
}

Debit()
{
   if (l_gd_sign_amount == 0)
         strcpy(l_gd_debit_amt.arr,"");
   else
   {
        if (l_gd_sign_amount == -1)
           strcpy(l_gd_debit_amt.arr,l_gd_amount_negative.arr);
        else
           strcpy(l_gd_debit_amt.arr,l_gd_amount.arr);
   }
  
   strcpy(l_gd_credit_amt.arr,"");

   l_gd_credit_amt.len = strlen(l_gd_credit_amt.arr);
   l_gd_debit_amt.len = strlen(l_gd_debit_amt.arr);
   
  if (d_ar_switch == 1)
   {
      strcpy(l_gd_credit_amt.arr,l_gd_amount_negative.arr);
	  strcpy(l_gd_debit_amt.arr,"");
	  l_gd_credit_amt.len = strlen(l_gd_credit_amt.arr);
      l_gd_debit_amt.len = strlen(l_gd_debit_amt.arr);
      d_ar_switch = 0;
	}
}

