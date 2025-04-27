
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/AR/ARBGLDIS.PC"
};


static unsigned int sqlctx = 1288481219;


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
            void  *sqhstv[27];
   unsigned int   sqhstl[27];
            int   sqhsts[27];
            void  *sqindv[27];
            int   sqinds[27];
   unsigned int   sqharm[27];
   unsigned int   *sqharc[27];
   unsigned short  sqadto[27];
   unsigned short  sqtdso[27];
} sqlstm = {12,27};

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

 static const char *sq0006 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,CUST_REF ,CUS\
T_CODE ,MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGER_GROUP_CODE_NEW ,SUBL\
EDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_NEW ,PRODUCT_LINE_CODE_\
NEW ,PAYABLE_AMT ,NARRATION ,POST_MONTH ,POST_YEAR ,SIGN(PAYABLE_AMT) ,DECODE(\
SIGN(PAYABLE_AMT),(-1),(-PAYABLE_AMT),PAYABLE_AMT)  from AR_INV_HDR where (((D\
OC_TYPE_CODE>=NVL(:b0,'!!!!!!') and DOC_TYPE_CODE<=NVL(:b1,'~~~~~~')) and NVL(\
POSTED_FLAG,'N')='Y') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POS\
T_MONTH,'09'))) between (:b2||:b3) and (:b4||:b5))           ";

 static const char *sq0007 = 
"select MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGER_GROUP_CODE_NEW ,SUB\
LEDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_NEW ,PRODUCT_LINE_CODE\
_NEW ,NARRATION ,AMT_LOCAL ,SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT\
_LOCAL),AMT_LOCAL)  from AR_INV_LINE where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)\
           ";

 static const char *sq0008 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,POST_MONTH ,P\
OST_YEAR  from AR_DN_HDR where (((DOC_TYPE_CODE>=NVL(:b0,'!!!!!!') and DOC_TYP\
E_CODE<=NVL(:b1,'~~~~~~')) and NVL(POSTED_FLAG,'N')='Y') and (LTRIM(TO_CHAR(PO\
ST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09'))) between (:b2||:b3) and (:b4\
||:b5))           ";

 static const char *sq0009 = 
"select CUST_REF ,CUST_CODE ,MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGE\
R_GROUP_CODE_NEW ,SUBLEDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_N\
EW ,PRODUCT_LINE_CODE_NEW ,DOC_AMT ,NARRATION ,SIGN(DOC_AMT) ,DECODE(SIGN(DOC_\
AMT),(-1),(-DOC_AMT),DOC_AMT) ,ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from AR_DN_INV_\
HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0010 = 
"select MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGER_GROUP_CODE_NEW ,SUB\
LEDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_NEW ,PRODUCT_LINE_CODE\
_NEW ,NARRATION ,AMOUNT ,SIGN(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(-AMOUNT),AMOU\
NT)  from AR_DN_LINE where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and ORG_DOC_T\
YPE_CODE=:b2) and ORG_DOC_NUM=:b3)           ";

 static const char *sq0011 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,POST_MONTH ,P\
OST_YEAR  from AR_CN_HDR where (((DOC_TYPE_CODE>=NVL(:b0,'!!!!!!') and DOC_TYP\
E_CODE<=NVL(:b1,'~~~~~~')) and NVL(POSTED_FLAG,'N')='Y') and (LTRIM(TO_CHAR(PO\
ST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09'))) between (:b2||:b3) and (:b4\
||:b5))           ";

 static const char *sq0012 = 
"select CUST_REF ,CUST_CODE ,MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGE\
R_GROUP_CODE_NEW ,SUBLEDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_N\
EW ,PRODUCT_LINE_CODE_NEW ,DOC_AMT ,NARRATION ,SIGN(DOC_AMT) ,DECODE(SIGN(DOC_\
AMT),(-1),(-DOC_AMT),DOC_AMT) ,ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from AR_CN_INV_\
HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0013 = 
"select MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGER_GROUP_CODE_NEW ,SUB\
LEDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_NEW ,PRODUCT_LINE_CODE\
_NEW ,NARRATION ,AMOUNT ,SIGN(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(-AMOUNT),AMOU\
NT)  from AR_CN_LINE where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and ORG_DOC_T\
YPE_CODE=:b2) and ORG_DOC_NUM=:b3)           ";

 static const char *sq0014 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,POST_MONTH ,P\
OST_YEAR  from AR_ADJ_HDR where (((DOC_TYPE_CODE>=NVL(:b0,'!!!!!!') and DOC_TY\
PE_CODE<=NVL(:b1,'~~~~~~')) and NVL(POSTED_FLAG,'N')='Y') and (LTRIM(TO_CHAR(P\
OST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09'))) between (:b2||:b3) and (:b\
4||:b5))           ";

 static const char *sq0015 = 
"select CUST_REF ,CUST_CODE ,MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGE\
R_GROUP_CODE_NEW ,SUBLEDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_N\
EW ,PRODUCT_LINE_CODE_NEW ,DOC_AMT ,NARRATION ,ADJ_TYPE ,SIGN(DOC_AMT) ,DECODE\
(SIGN(DOC_AMT),(-1),(-DOC_AMT),DOC_AMT) ,ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from \
AR_ADJ_INV_HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0016 = 
"select MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGER_GROUP_CODE_NEW ,SUB\
LEDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_NEW ,PRODUCT_LINE_CODE\
_NEW ,NARRATION ,AMOUNT ,SIGN(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(-AMOUNT),AMOU\
NT)  from AR_ADJ_LINE where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and ORG_DOC_\
TYPE_CODE=:b2) and ORG_DOC_NUM=:b3)           ";

 static const char *sq0017 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,CUST\
_CODE ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CO\
DE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,AMT_LOCAL ,NARRATION ,PO\
ST_MONTH ,POST_YEAR ,CHEQUE_NUM ,TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY') ,SIGN(AMT_L\
OCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL)  from AR_REC_HDR wh\
ere (((DOC_TYPE_CODE>=NVL(:b0,'!!!!!!') and DOC_TYPE_CODE<=NVL(:b1,'~~~~~~')) \
and NVL(POSTED_FLAG,'N')='Y') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_\
CHAR(POST_MONTH,'09'))) between (:b2||:b3) and (:b4||:b5))           ";

 static const char *sq0018 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_\
CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,NARRATION ,AMT_LOCAL ,\
SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL)  from AR_\
REC_LINE where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0019 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,CUST\
_CODE ,MAIN_ACC1_CODE_BANK ,MAIN_ACC2_CODE_BANK ,SUBLEDGER_GROUP_CODE_BANK ,SU\
BLEDGER_LINE_CODE_BANK ,DEPT_CODE_BANK ,PRODUCT_GROUP_CODE_BANK ,PRODUCT_LINE_\
CODE_BANK ,MAIN_ACC1_CODE_SUSP ,MAIN_ACC2_CODE_SUSP ,SUBLEDGER_GROUP_CODE_SUSP\
 ,SUBLEDGER_LINE_CODE_SUSP ,DEPT_CODE_SUSP ,PRODUCT_GROUP_CODE_SUSP ,PRODUCT_L\
INE_CODE_SUSP ,AMT_LOCAL ,NARRATION ,POST_MONTH ,POST_YEAR ,CHEQUE_NUM ,TO_CHA\
R(CHEQUE_DATE,'DD/MM/YYYY') ,SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AM\
T_LOCAL),AMT_LOCAL)  from AR_CASHIER where ((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1\
) and NVL(POSTED_FLAG,'N')='Y')           ";

 static const char *sq0020 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,CUST\
_CODE ,MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGER_GROUP_CODE_NEW ,SUBLE\
DGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_NEW ,PRODUCT_LINE_CODE_N\
EW ,AMT_LOCAL ,NARRATION ,POST_MONTH ,POST_YEAR ,CHEQUE_NUM ,TO_CHAR(CHEQUE_DA\
TE,'DD/MM/YYYY') ,SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AM\
T_LOCAL)  from AR_PAY_HDR where (((DOC_TYPE_CODE>=NVL(:b0,'!!!!!!') and DOC_TY\
PE_CODE<=NVL(:b1,'~~~~~~')) and NVL(POSTED_FLAG,'N')='Y') and (LTRIM(TO_CHAR(P\
OST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09'))) between (:b2||:b3) and (:b\
4||:b5))           ";

 static const char *sq0021 = 
"select MAIN_ACC1_CODE_NEW ,MAIN_ACC2_CODE_NEW ,SUBLEDGER_GROUP_CODE_NEW ,SUB\
LEDGER_LINE_CODE_NEW ,DEPT_CODE_NEW ,PRODUCT_GROUP_CODE_NEW ,PRODUCT_LINE_CODE\
_NEW ,NARRATION ,AMT_LOCAL ,SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT\
_LOCAL),AMT_LOCAL)  from AR_PAY_LINE where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)\
           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,232,0,4,195,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
68,0,0,2,0,0,29,253,0,0,0,0,0,1,0,
83,0,0,3,0,0,30,257,0,0,0,0,0,1,0,
98,0,0,4,0,0,30,274,0,0,0,0,0,1,0,
113,0,0,0,0,0,27,280,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
144,0,0,6,605,0,9,377,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
183,0,0,6,0,0,13,390,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,3,0,0,2,9,0,0,
270,0,0,7,321,0,9,428,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
293,0,0,7,0,0,13,441,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
352,0,0,8,328,0,9,535,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
391,0,0,8,0,0,13,548,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
426,0,0,9,366,0,9,573,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
449,0,0,9,0,0,13,591,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
524,0,0,10,355,0,9,627,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
555,0,0,10,0,0,13,641,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
614,0,0,11,328,0,9,733,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
653,0,0,11,0,0,13,746,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
688,0,0,12,366,0,9,773,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
711,0,0,12,0,0,13,790,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
786,0,0,13,355,0,9,825,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
817,0,0,13,0,0,13,838,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
876,0,0,14,329,0,9,932,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
915,0,0,14,0,0,13,945,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
950,0,0,15,377,0,9,970,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
973,0,0,15,0,0,13,985,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
1052,0,0,16,356,0,9,1027,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1083,0,0,16,0,0,13,1037,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1142,0,0,17,613,0,9,1152,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1181,0,0,17,0,0,13,1162,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1276,0,0,18,293,0,9,1199,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1299,0,0,18,0,0,13,1209,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1358,0,0,19,664,0,9,1237,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1381,0,0,19,0,0,13,1247,0,0,27,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,3,0,0,2,9,0,0,
1504,0,0,20,641,0,9,1347,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1543,0,0,20,0,0,13,1357,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1638,0,0,21,321,0,9,1394,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1661,0,0,21,0,0,13,1404,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1720,0,0,22,431,0,3,1756,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1815,0,0,23,0,0,29,1810,0,0,0,0,0,1,0,
1830,0,0,24,49,0,2,1975,0,0,0,0,0,1,0,
1845,0,0,25,0,0,29,1981,0,0,0,0,0,1,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : ARBGLDIS.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 11-FEB-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                     */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_INV_HDR                  Query                  */
/*         2.        AR_INV_LINE                 Query                  */
/*         3.        AR_DN_HDR                   Query                  */
/*         4.        AR_DN_INV_HDR               Query                  */
/*         5.        AR_DN_LINE                  Query                  */
/*         6.        AR_CN_HDR                   Query                  */
/*         7.        AR_CN_INV_HDR               Query                  */
/*         8.        AR_CN_LINE                  Query                  */
/*         9.        AR_ADJ_HDR                  Query                  */
/*        10.        AR_ADJ_INV_HDR              Query                  */
/*        11.        AR_ADJ_LINE                 Query                  */
/*        12.        AR_REC_HDR                  Query                  */
/*        13.        AR_REC_LINE                 Query                  */
/*        14.        AR_PAY_HDR                  Query                  */
/*        15.        AR_PAY_LINE                 Query                  */
/*        16.        AR_CASHIER                  Query                  */
/*        17.        SY_PROG_CONTROL           Update/Lookup            */
/*        18.        SY_PROG_MESG                Insert                 */
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
#include <math.h>
#include <stdlib.h>
#include "gl.h"
/*
#define OERROR (sqlca.sqlcode < 0)
*/
#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

/*
#define DEBUG 0
*/
               
#define VIEW_LOG_FILE 1
/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;


    int audit_option_flag;
    int process_rep_flg  ;

   /* VARCHAR  nd_facility_id   [3],
		    nd_session_id    [16],
            nd_pgm_date      [25],
            nd_fm_doc_type   [7],
            nd_to_doc_type   [7],
            nd_proc_flag     [2],
            nd_view_print_flg[2],
            nd_rep_type      [3],
            nd_fm_month      [3],
	        nd_fm_year       [5],
            nd_to_month      [3],
	        nd_to_year       [5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[2]; } nd_proc_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_view_print_flg;

struct { unsigned short len; unsigned char arr[3]; } nd_rep_type;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_month;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_year;

struct { unsigned short len; unsigned char arr[3]; } nd_to_month;

struct { unsigned short len; unsigned char arr[5]; } nd_to_year;


 /* VARCHAR    d_ar_doc_type_code         [7],
            d_ar_doc_num               [9],
            d_ar_org_doc_type_code     [7],
            d_ar_org_doc_num           [9],
            d_ar_doc_date              [12],
            d_ar_doc_ref               [16],
            d_ar_cust_code             [9],
            d_ar_main_acc1_code        [7],
            d_ar_main_acc2_code        [5],
            d_ar_subledger_group_code  [4],
            d_ar_subledger_line_code   [9],
            d_ar_dept_code             [11],
            d_ar_product_group_code    [4],
            d_ar_product_line_code     [5],
            d_ar_amount                [19],
            d_ar_amount_negative       [19],
            d_ar_debit_amt             [19],
            d_ar_credit_amt            [19],
            d_ar_narration             [51],
            d_ar_post_month            [3],
            d_ar_post_year             [5],
            d_ar_cheque_num            [11],
            d_ar_cheque_date           [12],
            d_ar_trn_type_code         [7],
			d_ar_main_acc1_code_su     [7],
            d_ar_main_acc2_code_su     [5],
            d_ar_subledger_group_code_su [4],
            d_ar_subledger_line_code_su  [9],
            d_ar_dept_code_su          [11],
            d_ar_product_group_code_su [4],
            d_ar_product_line_code_su  [5],
			p_language_id			   [3],
            d_ar_adj_type              [3]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_ar_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_doc_num;

struct { unsigned short len; unsigned char arr[7]; } d_ar_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_org_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_doc_date;

struct { unsigned short len; unsigned char arr[16]; } d_ar_doc_ref;

struct { unsigned short len; unsigned char arr[9]; } d_ar_cust_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_ar_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } d_ar_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_subledger_line_code;

struct { unsigned short len; unsigned char arr[11]; } d_ar_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_ar_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_ar_product_line_code;

struct { unsigned short len; unsigned char arr[19]; } d_ar_amount;

struct { unsigned short len; unsigned char arr[19]; } d_ar_amount_negative;

struct { unsigned short len; unsigned char arr[19]; } d_ar_debit_amt;

struct { unsigned short len; unsigned char arr[19]; } d_ar_credit_amt;

struct { unsigned short len; unsigned char arr[51]; } d_ar_narration;

struct { unsigned short len; unsigned char arr[3]; } d_ar_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_ar_post_year;

struct { unsigned short len; unsigned char arr[11]; } d_ar_cheque_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_cheque_date;

struct { unsigned short len; unsigned char arr[7]; } d_ar_trn_type_code;

struct { unsigned short len; unsigned char arr[7]; } d_ar_main_acc1_code_su;

struct { unsigned short len; unsigned char arr[5]; } d_ar_main_acc2_code_su;

struct { unsigned short len; unsigned char arr[4]; } d_ar_subledger_group_code_su;

struct { unsigned short len; unsigned char arr[9]; } d_ar_subledger_line_code_su;

struct { unsigned short len; unsigned char arr[11]; } d_ar_dept_code_su;

struct { unsigned short len; unsigned char arr[4]; } d_ar_product_group_code_su;

struct { unsigned short len; unsigned char arr[5]; } d_ar_product_line_code_su;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[3]; } d_ar_adj_type;
   /* For adjustments */

int         d_ar_sign_amount;    /* sign(amount)  0 -> 0   */
                                 /*               1 -> +ve */
                                 /*              -1 -> -ve */

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
char string_var[100];

int ins_ctr = 0;       /* Used for commiting */

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc != 5)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
      proc_exit();
   }


   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   strcpy(g_pgm_id,"ARBGLDIS");

   strcpy(g_facility_id,argv[4]);

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle\n");
      proc_exit();
   }  

#ifdef DEBUG
  disp_message(INFO_MESG,"After connecting to oracle...\n");
#endif

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/

   set_meduser_role();
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

   chk_active();

   nd_fm_doc_type.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_proc_flag.arr[0]      = '\0';
   nd_view_print_flg.arr[0] = '\0';
   nd_rep_type.arr[0]       = '\0';
   nd_fm_month.arr[0]       = '\0';
   nd_fm_year.arr[0]        = '\0';
   nd_to_month.arr[0]       = '\0';
   nd_to_year.arr[0]        = '\0';

   nd_fm_doc_type.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_proc_flag.len         = 0;
   nd_view_print_flg.len    = 0;
   nd_rep_type.len          = 0;
   nd_fm_month.len          = 0;
   nd_fm_year.len           = 0;
   nd_to_month.len          = 0;
   nd_to_year.len           = 0;

   audit_option_flag        = 0;
   process_rep_flg          = 0;

   /* EXEC SQL SELECT operating_facility_id,
				   PARAM1,PARAM2,PARAM3,PARAM4,
				   //PARAM5,
				   PARAM6,
                   PARAM7, PARAM8, PARAM9, PARAM10 
              INTO :nd_facility_id,
				   :nd_fm_doc_type,    
				   :nd_to_doc_type, 
                   :audit_option_flag, 
				   :process_rep_flg,
                   //:nd_view_print_flg, 
				   :nd_rep_type,
		   :nd_fm_month, :nd_fm_year, :nd_to_month, :nd_to_year
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBGLDIS'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:\
b7,:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='ARBGLDIS' and SESSION_ID=:b10) \
and PGM_DATE=:b11)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_type;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_type;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&audit_option_flag;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&process_rep_flg;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_rep_type;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_month;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_year;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_month;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_year;
   sqlstm.sqhstl[9] = (unsigned int  )7;
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

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_fm_doc_type.arr[nd_fm_doc_type.len]          = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]          = '\0';
   nd_view_print_flg.arr[nd_view_print_flg.len]    = '\0';
   nd_rep_type.arr[nd_rep_type.len]                = '\0';
   nd_fm_month.arr[nd_fm_month.len]                = '\0';
   nd_fm_year.arr[nd_fm_year.len]                  = '\0';
   nd_to_month.arr[nd_to_month.len]                = '\0';
   nd_to_year.arr[nd_to_year.len]                  = '\0';
   
   
#ifdef DEBUG
   sprintf(string_var,"fr type is <%d> - <%s>\n",nd_fm_doc_type.len ,nd_fm_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to type is <%d> - <%s>\n",nd_to_doc_type.len ,nd_to_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"option  is <%d> \n",audit_option_flag);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"prc flg is <%d> \n",process_rep_flg);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fm mth/yr is <%s>/<%s>\n",nd_fm_month.arr,nd_fm_year.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to mth/yr is <%s>/<%s>\n",nd_to_month.arr,nd_to_year.arr);
   disp_message(INFO_MESG,string_var);
#endif

   start_prog_control();
   start_prog_msg();

   delete_records();
 
   declare_cursors();

   process_audits();

   /* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )68;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (process_rep_flg == 3)
   {
      /* EXEC SQL COMMIT WORK RELEASE; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 12;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )83;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
           err_mesg("COMMIT failed",0,""); 

      run_report();

      if(sql_connect() == -1)
      {
         disp_message(ORA_MESG,"Error in connecting to Oracle 2 time\n");
         proc_exit();
      }
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
   sqlstm.offset = (unsigned int  )98;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   return;
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
  sqlstm.offset = (unsigned int  )113;
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

declare_cursors()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside declare cursors\n");
   sprintf(string_var," opt flag is <%d>\n",audit_option_flag);
   disp_message(INFO_MESG,string_var);
#endif

    switch  (audit_option_flag)
    {
        case 1 : decl_in_curs();
                 break;
        case 2 : decl_dn_curs();
                 break;
        case 3 : decl_cn_curs();
                 break;
        case 4 : decl_adj_curs();
                 break;
        case 5 : decl_rec_curs();
                 break;
        case 6 : decl_pay_curs();
                 break;
        case 7 : decl_in_curs();
                 decl_dn_curs();
                 decl_cn_curs();
                 decl_adj_curs();
                 decl_rec_curs();
                 decl_pay_curs();
                 break;
    }
}

decl_in_curs()
{
#ifdef DEBUG 
  disp_message(INFO_MESG,"Inside Decl inv cur\n");
#endif
       /* EXEC SQL DECLARE CUR_INV_HDR CURSOR FOR
                 SELECT DOC_TYPE_CODE,
                        DOC_NUM,
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY'),	
                        CUST_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        PAYABLE_AMT,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        SIGN(PAYABLE_AMT),
                        DECODE(SIGN(PAYABLE_AMT),-1,-PAYABLE_AMT,PAYABLE_AMT)
                   FROM AR_INV_HDR
                  WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'!!!!!!')
                    AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                    AND NVL(POSTED_FLAG,'N') = 'Y'
                    AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                        LTRIM(TO_CHAR(POST_MONTH,'09'))
                            BETWEEN
                        :nd_fm_year||:nd_fm_month
			    AND
                        :nd_to_year||:nd_to_month; */ 



       /* EXEC SQL DECLARE CUR_INV_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        NARRATION,
                        AMT_LOCAL,
                        SIGN(AMT_LOCAL),
                        DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL)
                   FROM AR_INV_LINE
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num; */ 

}

open_in_hdr()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Open Inv hdr\n");
#endif
       /* EXEC SQL OPEN CUR_INV_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 12;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0006;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )144;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_year;
       sqlstm.sqhstl[2] = (unsigned int  )7;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_fm_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_month;
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



       if (OERROR)
           err_mesg("OPEN failed on cursor CUR_INV_HDR",0,"");
}

fetch_in_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside Fetch in hdr\n");
#endif
       init_variables(2);

       /* EXEC SQL FETCH CUR_INV_HDR
                 INTO :d_ar_doc_type_code,
                      :d_ar_doc_num,
                      :d_ar_doc_date,
                      :d_ar_doc_ref,
                      :d_ar_cust_code,
                      :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_amount,
                      :d_ar_narration,
                      :d_ar_post_month,
                      :d_ar_post_year,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )183;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )14;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_doc_ref;
       sqlstm.sqhstl[3] = (unsigned int  )18;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_cust_code;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[9] = (unsigned int  )13;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[11] = (unsigned int  )7;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[12] = (unsigned int  )21;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[13] = (unsigned int  )53;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&d_ar_post_month;
       sqlstm.sqhstl[14] = (unsigned int  )5;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&d_ar_post_year;
       sqlstm.sqhstl[15] = (unsigned int  )7;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[17] = (unsigned int  )21;
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
            err_mesg("FETCH failed on cursor CUR_INV_HDR",0,"");

       null_terminate(2);
       strcpy(d_ar_trn_type_code.arr,"INV");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_in_line()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside Open inv line\n");
#endif
       /* EXEC SQL OPEN CUR_INV_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0007;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )270;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_INV_LINE",0,"");
}

fetch_in_line()
{
#ifdef DEBUG 
  disp_message(INFO_MESG,"Inside fetch inv line\n");
#endif
       init_variables(0);

       /* EXEC SQL FETCH  CUR_INV_LINE
                 INTO :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_narration,
                      :d_ar_amount,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )293;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )13;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[10] = (unsigned int  )21;
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
         err_mesg("FETCH failed on cursor CUR_INV_LINE",0,"");

       null_terminate(0);
       strcpy(d_ar_trn_type_code.arr,"INV");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

decl_dn_curs()
{
#ifdef DEBUG 
  disp_message(INFO_MESG,"Inside decl Dn curs\n");
#endif
       /* EXEC SQL DECLARE CUR_DN_HDR CURSOR FOR
                 SELECT DOC_TYPE_CODE,
                        DOC_NUM,
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
			POST_MONTH,
			POST_YEAR
                   FROM AR_DN_HDR
                  WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'!!!!!!')
                    AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                    AND NVL(POSTED_FLAG,'N') = 'Y'
                    AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                        LTRIM(TO_CHAR(POST_MONTH,'09'))
                            BETWEEN
                        :nd_fm_year||:nd_fm_month 
			    AND
                        :nd_to_year|| :nd_to_month; */ 



       /* EXEC SQL DECLARE CUR_DN_INV_HDR CURSOR FOR
                 SELECT CUST_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        DOC_AMT,
                        NARRATION,
                        SIGN(DOC_AMT),
                        DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
                        ORG_DOC_TYPE_CODE,
                        ORG_DOC_NUM
                   FROM AR_DN_INV_HDR 
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num; */ 


       /* EXEC SQL DECLARE CUR_DN_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        NARRATION,
                        AMOUNT,
                        SIGN(AMOUNT),
                        DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT)
                   FROM AR_DN_LINE
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num
                    AND ORG_DOC_TYPE_CODE = :d_ar_org_doc_type_code
                    AND ORG_DOC_NUM       = :d_ar_org_doc_num; */ 


}

open_dn_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside Open dn hdr\n");
#endif
       /* EXEC SQL OPEN CUR_DN_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0008;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )352;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_year;
       sqlstm.sqhstl[2] = (unsigned int  )7;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_fm_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_month;
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



       if (OERROR)
           err_mesg("OPEN failed on cursor CUR_DN_HDR",0,"");
}

fetch_dn_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside fetch dn hdr\n");
#endif
       init_variables(2);

       /* EXEC SQL FETCH CUR_DN_HDR
                 INTO :d_ar_doc_type_code,
                      :d_ar_doc_num,
                      :d_ar_doc_date,
                      :d_ar_post_month,
                      :d_ar_post_year; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )391;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )14;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_post_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_post_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
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
            err_mesg("FETCH failed on cursor CUR_DN_HDR",0,"");

       null_terminate(2);
       strcpy(d_ar_trn_type_code.arr,"DEB");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_dn_inv_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside open dn inv hdr\n");
#endif
       /* EXEC SQL OPEN CUR_DN_INV_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0009;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )426;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_DN_INV_HDR",0,"");
}

fetch_dn_inv_hdr()
{
       init_variables(1);

#ifdef DEBUG
   disp_message(INFO_MESG,"In fetch dn inv hdr\n");
   sprintf(string_var,"doc is <%s> - <%s> \n",d_ar_doc_type_code.arr,d_ar_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"doc date is <%s>\n",d_ar_doc_date.arr);
   disp_message(INFO_MESG,string_var);
#endif

       /* EXEC SQL FETCH CUR_DN_INV_HDR
                 INTO :d_ar_doc_ref,
                      :d_ar_cust_code,
                      :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_amount,
                      :d_ar_narration,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative,
                      :d_ar_org_doc_type_code,
                      :d_ar_org_doc_num; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )449;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_ref;
       sqlstm.sqhstl[0] = (unsigned int  )18;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_cust_code;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[3] = (unsigned int  )7;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[4] = (unsigned int  )6;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[5] = (unsigned int  )11;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[6] = (unsigned int  )13;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )7;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[9] = (unsigned int  )21;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[10] = (unsigned int  )53;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[12] = (unsigned int  )21;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&d_ar_org_doc_type_code;
       sqlstm.sqhstl[13] = (unsigned int  )9;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&d_ar_org_doc_num;
       sqlstm.sqhstl[14] = (unsigned int  )11;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
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
            err_mesg("FETCH failed on cursor CUR_DN_INV_HDR",0,"");

       null_terminate(1);
       strcpy(d_ar_trn_type_code.arr,"DEB");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_dn_line()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Before open dn line\n");
#endif

       /* EXEC SQL OPEN CUR_DN_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0010;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )524;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_org_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_DN_LINE",0,"");
}

fetch_dn_line()
{
       init_variables(0);

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Fetch dn line\n");
#endif

       /* EXEC SQL FETCH  CUR_DN_LINE
                 INTO :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_narration,
                      :d_ar_amount,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )555;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )13;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[10] = (unsigned int  )21;
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
         err_mesg("FETCH failed on cursor CUR_DN_LINE",0,"");

       null_terminate(0);
       strcpy(d_ar_trn_type_code.arr,"DEB");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

decl_cn_curs()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"In decl cn curs\n");
#endif
       /* EXEC SQL DECLARE CUR_CN_HDR CURSOR FOR
                 SELECT DOC_TYPE_CODE,
                        DOC_NUM,
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
			POST_MONTH,
			POST_YEAR
                   FROM AR_CN_HDR
                  WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'!!!!!!')
                    AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                    AND NVL(POSTED_FLAG,'N') = 'Y'
                    AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                        LTRIM(TO_CHAR(POST_MONTH,'09'))
                            BETWEEN
                        :nd_fm_year||:nd_fm_month
			    AND
                        :nd_to_year||:nd_to_month; */ 


       /* EXEC SQL DECLARE CUR_CN_INV_HDR CURSOR FOR
                 SELECT CUST_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        DOC_AMT,
                        NARRATION,
                        SIGN(DOC_AMT),
                        DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
                        ORG_DOC_TYPE_CODE,
                        ORG_DOC_NUM
                   FROM AR_CN_INV_HDR 
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num; */ 


       /* EXEC SQL DECLARE CUR_CN_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        NARRATION,
                        AMOUNT,
                        SIGN(AMOUNT),
                        DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT)
                   FROM AR_CN_LINE 
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num
                    AND ORG_DOC_TYPE_CODE = :d_ar_org_doc_type_code
                    AND ORG_DOC_NUM       = :d_ar_org_doc_num; */ 

}

open_cn_hdr()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"In open cn hdr\n");
#endif
       /* EXEC SQL OPEN CUR_CN_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0011;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )614;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_year;
       sqlstm.sqhstl[2] = (unsigned int  )7;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_fm_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_month;
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



       if (OERROR)
           err_mesg("OPEN failed on cursor CUR_CN_HDR",0,"");
}

fetch_cn_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside fetch cn hdr\n");
#endif
       init_variables(2);

       /* EXEC SQL FETCH CUR_CN_HDR
                 INTO :d_ar_doc_type_code,
                      :d_ar_doc_num,
                      :d_ar_doc_date,
                      :d_ar_post_month,
                      :d_ar_post_year; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )653;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )14;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_post_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_post_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
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
            err_mesg("FETCH failed on cursor CUR_CN_HDR",0,"");

       null_terminate(2);
       strcpy(d_ar_trn_type_code.arr,"CRE");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_cn_inv_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside open cn inv hdr\n");
  sprintf(string_var,"doc is <%s> - <%s> \n",d_ar_doc_type_code.arr,d_ar_doc_num.arr);
  disp_message(INFO_MESG,string_var);
#endif 
       /* EXEC SQL OPEN CUR_CN_INV_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0012;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )688;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_CN_INV_HDR",0,"");
}

fetch_cn_inv_hdr()
{
       init_variables(1);
#ifdef DEBUG
   disp_message(INFO_MESG,"In fetch cn inv hdr\n");
   sprintf(string_var,"doc is <%s> - <%s> \n",d_ar_doc_type_code.arr,d_ar_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"doc date is <%s>\n",d_ar_doc_date.arr);
   disp_message(INFO_MESG,string_var);
#endif 

       /* EXEC SQL FETCH CUR_CN_INV_HDR
                 INTO :d_ar_doc_ref,
                      :d_ar_cust_code,
                      :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_amount,
                      :d_ar_narration,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative,
                      :d_ar_org_doc_type_code,
                      :d_ar_org_doc_num; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )711;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_ref;
       sqlstm.sqhstl[0] = (unsigned int  )18;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_cust_code;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[3] = (unsigned int  )7;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[4] = (unsigned int  )6;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[5] = (unsigned int  )11;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[6] = (unsigned int  )13;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )7;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[9] = (unsigned int  )21;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[10] = (unsigned int  )53;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[12] = (unsigned int  )21;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&d_ar_org_doc_type_code;
       sqlstm.sqhstl[13] = (unsigned int  )9;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&d_ar_org_doc_num;
       sqlstm.sqhstl[14] = (unsigned int  )11;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
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
            err_mesg("FETCH failed on cursor CUR_CN_INV_HDR",0,"");

       null_terminate(1);
       strcpy(d_ar_trn_type_code.arr,"CRE");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_cn_line()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside open cn line\n");
#endif
       /* EXEC SQL OPEN CUR_CN_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0013;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )786;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_org_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_CN_LINE",0,"");
}

fetch_cn_line()
{
       init_variables(0);
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside fetch cn line\n");
#endif

       /* EXEC SQL FETCH  CUR_CN_LINE
                 INTO :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_narration,
                      :d_ar_amount,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )817;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )13;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[10] = (unsigned int  )21;
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
         err_mesg("FETCH failed on cursor CUR_CN_LINE",0,"");

       null_terminate(0);
       strcpy(d_ar_trn_type_code.arr,"CRE");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

decl_adj_curs()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"In decl adj cur\n");
#endif

       /* EXEC SQL DECLARE CUR_ADJ_HDR CURSOR FOR
                 SELECT DOC_TYPE_CODE,
                        DOC_NUM,
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
			POST_MONTH,
			POST_YEAR
                   FROM AR_ADJ_HDR
                  WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'!!!!!!')
                    AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                    AND NVL(POSTED_FLAG,'N') = 'Y'
                    AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                        LTRIM(TO_CHAR(POST_MONTH,'09'))
                            BETWEEN
                        :nd_fm_year||:nd_fm_month
			    AND
                        :nd_to_year||:nd_to_month; */ 


       /* EXEC SQL DECLARE CUR_ADJ_INV_HDR CURSOR FOR
                 SELECT CUST_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        DOC_AMT,
                        NARRATION,
                        ADJ_TYPE,
                        SIGN(DOC_AMT),
                        DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
                        ORG_DOC_TYPE_CODE,
                        ORG_DOC_NUM
                   FROM AR_ADJ_INV_HDR 
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num; */ 


       /* EXEC SQL DECLARE CUR_ADJ_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        NARRATION,
                        AMOUNT,
                        SIGN(AMOUNT),
                        DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT)
                   FROM AR_ADJ_LINE
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num
                    AND ORG_DOC_TYPE_CODE = :d_ar_org_doc_type_code
                    AND ORG_DOC_NUM       = :d_ar_org_doc_num; */ 

}

open_adj_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"In open adj hdr\n");
#endif
       /* EXEC SQL OPEN CUR_ADJ_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0014;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )876;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_year;
       sqlstm.sqhstl[2] = (unsigned int  )7;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_fm_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_month;
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



       if (OERROR)
           err_mesg("OPEN failed on cursor CUR_ADJ_HDR",0,"");
}

fetch_adj_hdr()
{
       init_variables(2);
#ifdef DEBUG
  disp_message(INFO_MESG,"In fetch adj hdr\n");
#endif

       /* EXEC SQL FETCH CUR_ADJ_HDR
                 INTO :d_ar_doc_type_code,
                      :d_ar_doc_num,
                      :d_ar_doc_date,
                      :d_ar_post_month,
                      :d_ar_post_year; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )915;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )14;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_post_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_post_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
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
            err_mesg("FETCH failed on cursor CUR_ADJ_HDR",0,"");

       null_terminate(2);
       strcpy(d_ar_trn_type_code.arr,"ADJ");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_adj_inv_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"in open adj inv hdr\n");
#endif
       /* EXEC SQL OPEN CUR_ADJ_INV_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0015;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )950;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_ADJ_INV_HDR",0,"");
}

fetch_adj_inv_hdr()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside fetch adj inv hdr\n");
#endif
       init_variables(1);
       d_ar_adj_type.arr[0] = '\0';
       d_ar_adj_type.len    = 0;
 
       /* EXEC SQL FETCH CUR_ADJ_INV_HDR
                 INTO :d_ar_doc_ref,
                      :d_ar_cust_code,
                      :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_amount,
                      :d_ar_narration,
                      :d_ar_adj_type,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative,
                      :d_ar_org_doc_type_code,
                      :d_ar_org_doc_num; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )973;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_ref;
       sqlstm.sqhstl[0] = (unsigned int  )18;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_cust_code;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[3] = (unsigned int  )7;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[4] = (unsigned int  )6;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[5] = (unsigned int  )11;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[6] = (unsigned int  )13;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )7;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[9] = (unsigned int  )21;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[10] = (unsigned int  )53;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&d_ar_adj_type;
       sqlstm.sqhstl[11] = (unsigned int  )5;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[13] = (unsigned int  )21;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&d_ar_org_doc_type_code;
       sqlstm.sqhstl[14] = (unsigned int  )9;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&d_ar_org_doc_num;
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
            err_mesg("FETCH failed on cursor CUR_ADJ_INV_HDR",0,"");

       d_ar_adj_type.arr[d_ar_adj_type.len]  = '\0';

       null_terminate(1);
       strcpy(d_ar_trn_type_code.arr,"ADJ");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

#ifdef DEBUG
   sprintf(string_var,"After fetching Adj inv hdr  Adj type - <%s><%d>\n",
            d_ar_adj_type.arr,
            d_ar_adj_type.len);
            disp_message(INFO_MESG,string_var);
#endif

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_adj_line()
{
       /* EXEC SQL OPEN CUR_ADJ_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0016;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1052;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_org_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_ADJ_LINE",0,"");
}

fetch_adj_line()
{
       init_variables(0);

       /* EXEC SQL FETCH  CUR_ADJ_LINE
                 INTO :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_narration,
                      :d_ar_amount,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1083;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )13;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[10] = (unsigned int  )21;
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
         err_mesg("FETCH failed on cursor CUR_ADJ_LINE",0,"");

       null_terminate(0);
       strcpy(d_ar_trn_type_code.arr,"ADJ");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

decl_rec_curs()
{
       /* EXEC SQL DECLARE CUR_REC_HDR CURSOR FOR
                 SELECT DOC_TYPE_CODE,
                        DOC_NUM,
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY'),	
                        DOC_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        AMT_LOCAL,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        CHEQUE_NUM,
                        TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY'),
                        SIGN(AMT_LOCAL),
                        DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL)
                   FROM AR_REC_HDR
                  WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'!!!!!!')
                    AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                    AND NVL(POSTED_FLAG,'N') = 'Y'
                    AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                        LTRIM(TO_CHAR(POST_MONTH,'09'))
                            BETWEEN
                        :nd_fm_year||
                        :nd_fm_month
			    AND
                        :nd_to_year||
                        :nd_to_month; */ 


       /* EXEC SQL DECLARE CUR_REC_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        NARRATION,
                        AMT_LOCAL,
                        SIGN(AMT_LOCAL),
                        DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL)
                   FROM AR_REC_LINE
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num; */ 



		/* EXEC SQL DECLARE OFF_REC_CUR CURSOR FOR
                 SELECT DOC_TYPE_CODE,
                        DOC_NUM,
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY'),	
                        DOC_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE_BANK,
                        MAIN_ACC2_CODE_BANK,
                        SUBLEDGER_GROUP_CODE_BANK,
                        SUBLEDGER_LINE_CODE_BANK,
                        DEPT_CODE_BANK,
                        PRODUCT_GROUP_CODE_BANK,
                        PRODUCT_LINE_CODE_BANK,
						MAIN_ACC1_CODE_SUSP,
                        MAIN_ACC2_CODE_SUSP,
                        SUBLEDGER_GROUP_CODE_SUSP,
                        SUBLEDGER_LINE_CODE_SUSP,
                        DEPT_CODE_SUSP,
                        PRODUCT_GROUP_CODE_SUSP,
                        PRODUCT_LINE_CODE_SUSP,
                        AMT_LOCAL,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        CHEQUE_NUM,
                        TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY'),
                        SIGN(AMT_LOCAL),
						DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL)
                   FROM AR_CASHIER
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num
                    AND NVL(POSTED_FLAG,'N') = 'Y'; */ 

}

open_rec_hdr()
{
       /* EXEC SQL OPEN CUR_REC_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0017;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1142;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_year;
       sqlstm.sqhstl[2] = (unsigned int  )7;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_fm_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_month;
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



       if (OERROR)
           err_mesg("OPEN failed on cursor CUR_REC_HDR",0,"");
}

fetch_rec_hdr()
{
       init_variables(2);

       /* EXEC SQL FETCH CUR_REC_HDR
                 INTO :d_ar_doc_type_code,
                      :d_ar_doc_num,
                      :d_ar_doc_date,
                      :d_ar_doc_ref,
                      :d_ar_cust_code,
                      :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_amount,
                      :d_ar_narration,
                      :d_ar_post_month,
                      :d_ar_post_year,
                      :d_ar_cheque_num,
                      :d_ar_cheque_date,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1181;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )14;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_doc_ref;
       sqlstm.sqhstl[3] = (unsigned int  )18;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_cust_code;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[9] = (unsigned int  )13;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[11] = (unsigned int  )7;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[12] = (unsigned int  )21;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[13] = (unsigned int  )53;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&d_ar_post_month;
       sqlstm.sqhstl[14] = (unsigned int  )5;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&d_ar_post_year;
       sqlstm.sqhstl[15] = (unsigned int  )7;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&d_ar_cheque_num;
       sqlstm.sqhstl[16] = (unsigned int  )13;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&d_ar_cheque_date;
       sqlstm.sqhstl[17] = (unsigned int  )14;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[18] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[19] = (unsigned int  )21;
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
            err_mesg("FETCH failed on cursor CUR_REC_HDR",0,"");

       null_terminate(2);
       strcpy(d_ar_trn_type_code.arr,"REC");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_rec_line()
{
       /* EXEC SQL OPEN CUR_REC_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0018;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1276;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_REC_LINE",0,"");
}

fetch_rec_line()
{
       init_variables(0);

       /* EXEC SQL FETCH  CUR_REC_LINE
                 INTO :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_narration,
                      :d_ar_amount,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1299;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )13;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[10] = (unsigned int  )21;
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
            err_mesg("FETCH failed on cursor CUR_REC_LINE",0,"");

       null_terminate(0);
       strcpy(d_ar_trn_type_code.arr,"REC");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}
//---added 09/06/02 ----------------
open_off_rec_cur()
{
       /* EXEC SQL OPEN OFF_REC_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0019;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1358;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
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
           err_mesg("OPEN failed on cursor OFF_REC_CUR",0,"");
}

fetch_off_rec()
{
       init_variables(0);

       /* EXEC SQL FETCH  OFF_REC_CUR

                 INTO :d_ar_doc_type_code,
                      :d_ar_doc_num,
                      :d_ar_doc_date,
                      :d_ar_doc_ref,
                      :d_ar_cust_code,
                      :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_main_acc1_code_su,
                      :d_ar_main_acc2_code_su,
                      :d_ar_subledger_group_code_su,
                      :d_ar_subledger_line_code_su,
                      :d_ar_dept_code_su,
                      :d_ar_product_group_code_su,
                      :d_ar_product_line_code_su,
					  :d_ar_amount,
                      :d_ar_narration,
                      :d_ar_post_month,
                      :d_ar_post_year,
                      :d_ar_cheque_num,
                      :d_ar_cheque_date,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 27;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1381;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )14;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_doc_ref;
       sqlstm.sqhstl[3] = (unsigned int  )18;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_cust_code;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[9] = (unsigned int  )13;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[11] = (unsigned int  )7;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&d_ar_main_acc1_code_su;
       sqlstm.sqhstl[12] = (unsigned int  )9;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&d_ar_main_acc2_code_su;
       sqlstm.sqhstl[13] = (unsigned int  )7;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&d_ar_subledger_group_code_su;
       sqlstm.sqhstl[14] = (unsigned int  )6;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&d_ar_subledger_line_code_su;
       sqlstm.sqhstl[15] = (unsigned int  )11;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&d_ar_dept_code_su;
       sqlstm.sqhstl[16] = (unsigned int  )13;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&d_ar_product_group_code_su;
       sqlstm.sqhstl[17] = (unsigned int  )6;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&d_ar_product_line_code_su;
       sqlstm.sqhstl[18] = (unsigned int  )7;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[19] = (unsigned int  )21;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[20] = (unsigned int  )53;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&d_ar_post_month;
       sqlstm.sqhstl[21] = (unsigned int  )5;
       sqlstm.sqhsts[21] = (         int  )0;
       sqlstm.sqindv[21] = (         void  *)0;
       sqlstm.sqinds[21] = (         int  )0;
       sqlstm.sqharm[21] = (unsigned int  )0;
       sqlstm.sqadto[21] = (unsigned short )0;
       sqlstm.sqtdso[21] = (unsigned short )0;
       sqlstm.sqhstv[22] = (         void  *)&d_ar_post_year;
       sqlstm.sqhstl[22] = (unsigned int  )7;
       sqlstm.sqhsts[22] = (         int  )0;
       sqlstm.sqindv[22] = (         void  *)0;
       sqlstm.sqinds[22] = (         int  )0;
       sqlstm.sqharm[22] = (unsigned int  )0;
       sqlstm.sqadto[22] = (unsigned short )0;
       sqlstm.sqtdso[22] = (unsigned short )0;
       sqlstm.sqhstv[23] = (         void  *)&d_ar_cheque_num;
       sqlstm.sqhstl[23] = (unsigned int  )13;
       sqlstm.sqhsts[23] = (         int  )0;
       sqlstm.sqindv[23] = (         void  *)0;
       sqlstm.sqinds[23] = (         int  )0;
       sqlstm.sqharm[23] = (unsigned int  )0;
       sqlstm.sqadto[23] = (unsigned short )0;
       sqlstm.sqtdso[23] = (unsigned short )0;
       sqlstm.sqhstv[24] = (         void  *)&d_ar_cheque_date;
       sqlstm.sqhstl[24] = (unsigned int  )14;
       sqlstm.sqhsts[24] = (         int  )0;
       sqlstm.sqindv[24] = (         void  *)0;
       sqlstm.sqinds[24] = (         int  )0;
       sqlstm.sqharm[24] = (unsigned int  )0;
       sqlstm.sqadto[24] = (unsigned short )0;
       sqlstm.sqtdso[24] = (unsigned short )0;
       sqlstm.sqhstv[25] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[25] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[25] = (         int  )0;
       sqlstm.sqindv[25] = (         void  *)0;
       sqlstm.sqinds[25] = (         int  )0;
       sqlstm.sqharm[25] = (unsigned int  )0;
       sqlstm.sqadto[25] = (unsigned short )0;
       sqlstm.sqtdso[25] = (unsigned short )0;
       sqlstm.sqhstv[26] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[26] = (unsigned int  )21;
       sqlstm.sqhsts[26] = (         int  )0;
       sqlstm.sqindv[26] = (         void  *)0;
       sqlstm.sqinds[26] = (         int  )0;
       sqlstm.sqharm[26] = (unsigned int  )0;
       sqlstm.sqadto[26] = (unsigned short )0;
       sqlstm.sqtdso[26] = (unsigned short )0;
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
            err_mesg("FETCH failed on cursor OFF_REC_CUR",0,"");

       null_terminate(0);
       strcpy(d_ar_trn_type_code.arr,"REC");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}
//---End added 09/06/02 ----------------
decl_pay_curs()
{
       /* EXEC SQL DECLARE CUR_PAY_HDR CURSOR FOR
                 SELECT DOC_TYPE_CODE,
                        DOC_NUM,
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY'),	
                        DOC_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        AMT_LOCAL,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        CHEQUE_NUM,
                        TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY'),
                        SIGN(AMT_LOCAL),
                        DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL)
                   FROM AR_PAY_HDR
                  WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'!!!!!!')
                    AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                    AND NVL(POSTED_FLAG,'N') = 'Y'
                    AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                        LTRIM(TO_CHAR(POST_MONTH,'09'))
                            BETWEEN
                        :nd_fm_year||
                        :nd_fm_month
			    AND
                       :nd_to_year||
                        :nd_to_month; */ 



       /* EXEC SQL DECLARE CUR_PAY_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE_NEW,
                        MAIN_ACC2_CODE_NEW,
                        SUBLEDGER_GROUP_CODE_NEW,
                        SUBLEDGER_LINE_CODE_NEW,
                        DEPT_CODE_NEW,
                        PRODUCT_GROUP_CODE_NEW,
                        PRODUCT_LINE_CODE_NEW,
                        NARRATION,
                        AMT_LOCAL,
                        SIGN(AMT_LOCAL),
                        DECODE(SIGN(AMT_LOCAL),-1,-AMT_LOCAL,AMT_LOCAL)
                   FROM AR_PAY_LINE
                  WHERE DOC_TYPE_CODE = :d_ar_doc_type_code
                    AND DOC_NUM       = :d_ar_doc_num; */ 

}

open_pay_hdr()
{
       /* EXEC SQL OPEN CUR_PAY_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 27;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0020;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1504;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_year;
       sqlstm.sqhstl[2] = (unsigned int  )7;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_fm_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
       sqlstm.sqhstl[4] = (unsigned int  )7;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_month;
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



       if (OERROR)
           err_mesg("OPEN failed on cursor CUR_PAY_HDR",0,"");
}

fetch_pay_hdr()
{
       init_variables(2);

       /* EXEC SQL FETCH CUR_PAY_HDR
                 INTO :d_ar_doc_type_code,
                      :d_ar_doc_num,
                      :d_ar_doc_date,
                      :d_ar_doc_ref,
                      :d_ar_cust_code,
                      :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_amount,
                      :d_ar_narration,
                      :d_ar_post_month,
                      :d_ar_post_year,
                      :d_ar_cheque_num,
                      :d_ar_cheque_date,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 27;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1543;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )14;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_doc_ref;
       sqlstm.sqhstl[3] = (unsigned int  )18;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_cust_code;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[9] = (unsigned int  )13;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[11] = (unsigned int  )7;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[12] = (unsigned int  )21;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[13] = (unsigned int  )53;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&d_ar_post_month;
       sqlstm.sqhstl[14] = (unsigned int  )5;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&d_ar_post_year;
       sqlstm.sqhstl[15] = (unsigned int  )7;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&d_ar_cheque_num;
       sqlstm.sqhstl[16] = (unsigned int  )13;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&d_ar_cheque_date;
       sqlstm.sqhstl[17] = (unsigned int  )14;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[18] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[19] = (unsigned int  )21;
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
            err_mesg("FETCH failed on cursor CUR_PAY_HDR",0,"");

       null_terminate(2);
       strcpy(d_ar_trn_type_code.arr,"PAY");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_pay_line()
{
       /* EXEC SQL OPEN CUR_PAY_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 27;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0021;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1638;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_PAY_LINE",0,"");
}

fetch_pay_line()
{
       init_variables(0);

       /* EXEC SQL FETCH  CUR_PAY_LINE
                 INTO :d_ar_main_acc1_code,
                      :d_ar_main_acc2_code,
                      :d_ar_subledger_group_code,
                      :d_ar_subledger_line_code,
                      :d_ar_dept_code,
                      :d_ar_product_group_code,
                      :d_ar_product_line_code,
                      :d_ar_narration,
                      :d_ar_amount,
                      :d_ar_sign_amount,
                      :d_ar_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 27;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1661;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&d_ar_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_ar_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_ar_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_ar_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_ar_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )13;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&d_ar_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&d_ar_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_ar_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&d_ar_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&d_ar_sign_amount;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&d_ar_amount_negative;
       sqlstm.sqhstl[10] = (unsigned int  )21;
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
         err_mesg("FETCH failed on cursor CUR_PAY_LINE",0,"");

       null_terminate(0);
       strcpy(d_ar_trn_type_code.arr,"PAY");
       d_ar_trn_type_code.len = strlen(d_ar_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

init_variables(flg)
int flg;
{

  if (flg)   /* Before Fetching hdr or Inv hdr */
  {
    if (flg == 2)  /* Before Fetching hdr */
    { 
        d_ar_doc_type_code.arr[0]         = '\0';
        d_ar_doc_num.arr[0]               = '\0';
        d_ar_doc_date.arr[0]              = '\0';
        d_ar_post_month.arr[0]            = '\0';
        d_ar_post_year.arr[0]             = '\0';
    }
    d_ar_doc_ref.arr[0]               = '\0';
    d_ar_cust_code.arr[0]             = '\0';
    d_ar_cheque_num.arr[0]            = '\0';
    d_ar_cheque_date.arr[0]           = '\0';
  }

d_ar_org_doc_type_code.arr[0]     = '\0';
d_ar_org_doc_num.arr[0]           = '\0';

d_ar_main_acc1_code.arr[0]        = '\0';
d_ar_main_acc2_code.arr[0]        = '\0';
d_ar_subledger_group_code.arr[0]  = '\0';
d_ar_subledger_line_code.arr[0]   = '\0';
d_ar_dept_code.arr[0]             = '\0';
d_ar_product_group_code.arr[0]    = '\0';
d_ar_product_line_code.arr[0]     = '\0';
d_ar_main_acc1_code_su.arr[0]        = '\0';
d_ar_main_acc2_code_su.arr[0]        = '\0';
d_ar_subledger_group_code_su.arr[0]  = '\0';
d_ar_subledger_line_code_su.arr[0]   = '\0';
d_ar_dept_code_su.arr[0]             = '\0';
d_ar_product_group_code_su.arr[0]    = '\0';
d_ar_product_line_code_su.arr[0]     = '\0';

d_ar_amount.arr[0]                = '\0';
d_ar_debit_amt.arr[0]             = '\0';
d_ar_credit_amt.arr[0]            = '\0';
d_ar_narration.arr[0]             = '\0';
d_ar_trn_type_code.arr[0]         = '\0';
d_ar_amount_negative.arr[0]       = '\0';

d_ar_sign_amount                  = 0;

  if (flg)   /* Before Fetching hdr or Inv hdr */
  {
    if (flg == 2)  /* Before Fetching hdr */
    { 
       d_ar_doc_type_code.len            = 0;
       d_ar_doc_num.len                  = 0;
       d_ar_doc_date.len                 = 0;
       d_ar_post_month.len               = 0;
       d_ar_post_year.len                = 0;
    }
    d_ar_doc_ref.len                  = 0;
    d_ar_cust_code.len                = 0;
    d_ar_cheque_num.len               = 0;
    d_ar_cheque_date.len              = 0;
  }

d_ar_org_doc_type_code.len        = 0;
d_ar_org_doc_num.len              = 0;

d_ar_main_acc1_code.len           = 0;
d_ar_main_acc2_code.len           = 0;
d_ar_subledger_group_code.len     = 0;
d_ar_subledger_line_code.len      = 0;
d_ar_dept_code.len                = 0;
d_ar_product_group_code.len       = 0;
d_ar_product_line_code.len        = 0;
d_ar_main_acc1_code_su.len        = 0;
d_ar_main_acc2_code_su.len        = 0;
d_ar_subledger_group_code_su.len  = 0;
d_ar_subledger_line_code_su.len   = 0;
d_ar_dept_code_su.len             = 0;
d_ar_product_group_code_su.len    = 0;
d_ar_product_line_code_su.len     = 0;
d_ar_amount.len                   = 0;
d_ar_debit_amt.len                = 0;
d_ar_credit_amt.len               = 0;
d_ar_narration.len                = 0;
d_ar_trn_type_code.len            = 0;
d_ar_amount_negative.len          = 0;

}

null_terminate(flg)
int flg;
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside null termination\n");
#endif
 
  if (flg)   /* Before Fetching hdr or Inv hdr */
  {
    if (flg == 2)  /* Before Fetching hdr */
    { 
       d_ar_doc_type_code.arr[d_ar_doc_type_code.len]                  = '\0';
       d_ar_doc_num.arr[d_ar_doc_num.len]                              = '\0';
       d_ar_doc_date.arr[d_ar_doc_date.len]                            = '\0';
       d_ar_post_month.arr[d_ar_post_month.len]                        = '\0';
       d_ar_post_year.arr[d_ar_post_year.len]                          = '\0';
    }
    d_ar_doc_ref.arr[d_ar_doc_ref.len]                              = '\0';
    d_ar_cust_code.arr[d_ar_cust_code.len]                          = '\0';
    d_ar_cheque_num.arr[d_ar_cheque_num.len]                        = '\0';
    d_ar_cheque_date.arr[d_ar_cheque_date.len]                      = '\0';
  }

d_ar_org_doc_type_code.arr[d_ar_org_doc_type_code.len]          = '\0';
d_ar_org_doc_num.arr[d_ar_org_doc_num.len]                      = '\0';

d_ar_main_acc1_code.arr[d_ar_main_acc1_code.len]                = '\0';
d_ar_main_acc2_code.arr[d_ar_main_acc2_code.len]                = '\0';
d_ar_subledger_group_code.arr[d_ar_subledger_group_code.len]    = '\0';
d_ar_subledger_line_code.arr[d_ar_subledger_line_code.len]      = '\0';
d_ar_dept_code.arr[d_ar_dept_code.len]                          = '\0';
d_ar_product_group_code.arr[d_ar_product_group_code.len]        = '\0';
d_ar_product_line_code.arr[d_ar_product_line_code.len]          = '\0';
d_ar_main_acc1_code_su.arr[d_ar_main_acc1_code_su.len]          = '\0';
d_ar_main_acc2_code_su.arr[d_ar_main_acc2_code_su.len]          = '\0';
d_ar_subledger_group_code_su.arr[d_ar_subledger_group_code_su.len] = '\0';
d_ar_subledger_line_code_su.arr[d_ar_subledger_line_code_su.len]   = '\0';
d_ar_dept_code_su.arr[d_ar_dept_code_su.len]                    = '\0';
d_ar_product_group_code_su.arr[d_ar_product_group_code_su.len]  = '\0';
d_ar_product_line_code_su.arr[d_ar_product_line_code_su.len]    = '\0';
d_ar_amount.arr[d_ar_amount.len]                                = '\0';
d_ar_debit_amt.arr[d_ar_debit_amt.len]                          = '\0';
d_ar_credit_amt.arr[d_ar_credit_amt.len]                        = '\0';
d_ar_narration.arr[d_ar_narration.len]                          = '\0';
d_ar_trn_type_code.arr[d_ar_trn_type_code.len]                  = '\0';
d_ar_amount_negative.arr[d_ar_amount_negative.len]              = '\0';

#ifdef DEBUG
  sprintf(string_var,"doc is <%s><%d> - <%s><%d> <%s>-<%d>\n",
       d_ar_doc_type_code.arr,
       d_ar_doc_type_code.len,
       d_ar_doc_num.arr,
       d_ar_doc_num.len,
       d_ar_doc_date.arr,
       d_ar_doc_date.len);
       disp_message(INFO_MESG,string_var);
  sprintf(string_var," main <%s><%d> - <%s><%d>\n",
       d_ar_main_acc1_code.arr,
       d_ar_main_acc1_code.len,
       d_ar_main_acc2_code.arr,
       d_ar_main_acc2_code.len);          
       disp_message(INFO_MESG,string_var);
  sprintf(string_var," amt is <%s><%d> amt neg is <%s> sign is <%d>\n",
       d_ar_amount.arr,
       d_ar_amount.len,
       d_ar_amount_negative.arr,
       d_ar_sign_amount);                 
       disp_message(INFO_MESG,string_var);
#endif
}

process_audits()
{
    switch  (audit_option_flag)
    {
        case 1 : process_inv();
                 break;
        case 2 : process_dn();
                 break;
        case 3 : process_cn();
                 break;
        case 4 : process_adj();
                 break;
        case 5 : process_rec();
                 break;
        case 6 : process_pay();
                 break;
        case 7 : process_inv();
                 process_dn();
                 process_cn();
                 process_adj();
                 process_rec();
                 process_pay();
                 break;
    }
}

process_inv()
{
   open_in_hdr();

   while (fetch_in_hdr())
   {
       insert_distrbn(0); 
       open_in_line();
       while(fetch_in_line())
       {
          insert_distrbn(1); 
       }
    }
}
 
process_dn()
{
   open_dn_hdr();

   while (fetch_dn_hdr())
   {
       open_dn_inv_hdr();
       while (fetch_dn_inv_hdr())
       {
           insert_distrbn(0); 
           open_dn_line();
           while(fetch_dn_line())
           {
              insert_distrbn(1); 
           }
        }
    }
}

process_cn()
{
   open_cn_hdr();

   while (fetch_cn_hdr())
   {
       open_cn_inv_hdr();
       while (fetch_cn_inv_hdr())
       {
           insert_distrbn(0); 
           open_cn_line();
           while(fetch_cn_line())
           {
              insert_distrbn(1); 
           }
        }
    }
}

process_adj()
{
   open_adj_hdr();

   while (fetch_adj_hdr())
   {
       open_adj_inv_hdr();
       while (fetch_adj_inv_hdr())
       {
           insert_distrbn(0); 
           open_adj_line();
           while(fetch_adj_line())
           {
              insert_distrbn(1); 
           }
        }
    }
}

process_rec()
{
   open_rec_hdr();

   while (fetch_rec_hdr())
   {
       insert_distrbn(0); 
	   //---added 09/06/02 ----------------
	   open_off_rec_cur();
	   fetch_off_rec();
	   insert_distrbn(0);

	   strcpy(d_ar_main_acc1_code.arr, d_ar_main_acc1_code_su.arr);
       strcpy(d_ar_main_acc2_code.arr, d_ar_main_acc2_code_su.arr);
       strcpy(d_ar_subledger_group_code.arr, d_ar_subledger_group_code_su.arr);
       strcpy(d_ar_subledger_line_code.arr, d_ar_subledger_line_code_su.arr);
       strcpy(d_ar_dept_code.arr, d_ar_dept_code_su.arr);
       strcpy(d_ar_product_group_code.arr, d_ar_product_group_code_su.arr);
       strcpy(d_ar_product_line_code.arr, d_ar_product_line_code_su.arr);


	   //strcpy(d_ar_credit_amt.arr, (char ) ((-1) *  atoi(d_ar_debit_amt.arr)));
       
	   
       insert_distrbn(1);  
	   //---End added 09/06/02 ----------------
       open_rec_line();
       while(fetch_rec_line())
       {
          insert_distrbn(1); 
       }
    }
}

process_pay()
{
   open_pay_hdr();

   while (fetch_pay_hdr())
   {

       insert_distrbn(0); 
       open_pay_line();
       while(fetch_pay_line())
       {
          insert_distrbn(1); 
       }
    }
}

insert_distrbn(hdr_line)
int hdr_line;
{
   calculate_credit_debit(hdr_line);

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside insert distrbn \n");
   sprintf(string_var,"doc is <%s> - <%s>\n",d_ar_doc_type_code.arr,d_ar_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var," deb is <%s><%d> cre is <%s><%d>\n",
        d_ar_debit_amt.arr,
        d_ar_debit_amt.len,
        d_ar_credit_amt.arr,
        d_ar_credit_amt.len);         
        disp_message(INFO_MESG,string_var);
   getchar();
#endif

   /* EXEC SQL INSERT INTO AR_GL_DISTRBN_TEMP
            (
               DOC_TYPE_CODE,
               DOC_NUM,
               DOC_DATE,
               DOC_REF,
               CUST_CODE,
               MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               DEBIT_AMT,
               CREDIT_AMT,
               NARRATION,
               POST_MONTH,
               POST_YEAR,
               CHEQUE_NUM,
               CHEQUE_DATE,
               TRN_TYPE_CODE
            )
        VALUES
            (
               :d_ar_doc_type_code,
               :d_ar_doc_num,
               TO_DATE(:d_ar_doc_date,'DD/MM/YYYY'),
               :d_ar_doc_ref,
               :d_ar_cust_code,
               :d_ar_main_acc1_code,
               :d_ar_main_acc2_code,
               :d_ar_subledger_group_code,
               :d_ar_subledger_line_code,
               :d_ar_dept_code,
               :d_ar_product_group_code,
               :d_ar_product_line_code,
               :d_ar_debit_amt,
               :d_ar_credit_amt,
               :d_ar_narration,
               :d_ar_post_month,
               :d_ar_post_year,
               :d_ar_cheque_num,
               TO_DATE(:d_ar_cheque_date,'DD/MM/YYYY'),
               :d_ar_trn_type_code
            ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_GL_DISTRBN_TEMP (DOC_TYPE_CODE,DOC_NUM,DOC_\
DATE,DOC_REF,CUST_CODE,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBL\
EDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,DEBIT_AMT,CREDI\
T_AMT,NARRATION,POST_MONTH,POST_YEAR,CHEQUE_NUM,CHEQUE_DATE,TRN_TYPE_CODE) val\
ues (:b0,:b1,TO_DATE(:b2,'DD/MM/YYYY'),:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:\
b12,:b13,:b14,:b15,:b16,:b17,TO_DATE(:b18,'DD/MM/YYYY'),:b19)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1720;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_doc_ref;
   sqlstm.sqhstl[3] = (unsigned int  )18;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ar_cust_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_ar_main_acc1_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_ar_main_acc2_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_ar_subledger_group_code;
   sqlstm.sqhstl[7] = (unsigned int  )6;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_ar_subledger_line_code;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_ar_dept_code;
   sqlstm.sqhstl[9] = (unsigned int  )13;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_ar_product_group_code;
   sqlstm.sqhstl[10] = (unsigned int  )6;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_ar_product_line_code;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_ar_debit_amt;
   sqlstm.sqhstl[12] = (unsigned int  )21;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_ar_credit_amt;
   sqlstm.sqhstl[13] = (unsigned int  )21;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_ar_narration;
   sqlstm.sqhstl[14] = (unsigned int  )53;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_ar_post_month;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_ar_post_year;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_ar_cheque_num;
   sqlstm.sqhstl[17] = (unsigned int  )13;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_ar_cheque_date;
   sqlstm.sqhstl[18] = (unsigned int  )14;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_ar_trn_type_code;
   sqlstm.sqhstl[19] = (unsigned int  )9;
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
           err_mesg("INSERT failed on table AR_GL_DISTRBN_TEMP",0,"");

        if (++ins_ctr > 100)
        {
             ins_ctr = 0;

             /* EXEC SQL COMMIT WORK; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 27;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )1815;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


             if (OERROR)
                err_mesg("COMMIT failed",0,""); 
        }

}


calculate_credit_debit(hdr_line) /* 0 -> Hdr   1 -> Line */
int hdr_line;
{
 int trn_flg = 0;

 if (audit_option_flag == 7)
 {
    if (!strcmp(d_ar_trn_type_code.arr,"INV"))
          trn_flg = 1;
    else if (!strcmp(d_ar_trn_type_code.arr,"DEB"))
            trn_flg = 2;
         else if (!strcmp(d_ar_trn_type_code.arr,"CRE"))
               trn_flg = 3;
              else if (!strcmp(d_ar_trn_type_code.arr,"ADJ"))
                    trn_flg = 4;
                 else if (!strcmp(d_ar_trn_type_code.arr,"REC"))
                       trn_flg = 5;
                 else if (!strcmp(d_ar_trn_type_code.arr,"PAY"))
                       trn_flg = 6;
  }
  else
     trn_flg = audit_option_flag;
 

  switch  (trn_flg)
  {
      case 1 : 
               if ( !hdr_line )   /* Hdr rec */
                   Debit();
               else if (atof(d_ar_amount.arr) < 0.00)    /* -ve */
                       Debit(); 
                    else 
                       Credit();
               break; 
      case 2 :
               if ( !hdr_line )   /* Hdr rec */
                   Debit();
               else if (atof(d_ar_amount.arr) < 0.00)   /* -ve */
                       Debit(); 
                    else 
                       Credit();
               break;
      case 3 : 
               if ( !hdr_line )   /* Hdr rec */
                   Credit();
               else if (atof(d_ar_amount.arr) < 0.00)   /* -ve */
                       Credit(); 
                    else 
                       Debit();
               break;
      case 4 : 
               if ( !hdr_line )   /* Hdr rec */
               {
                   if (d_ar_adj_type.arr[0] == 'D')
                        Debit();
                   else
                        Credit();
               }
               else if (atof(d_ar_amount.arr) < 0.00)   /* -ve */
                    {
                       if (d_ar_adj_type.arr[0] == 'D')
                            Debit();
                       else
                            Credit();
                    }
                    else 
                    {
                       if (d_ar_adj_type.arr[0] == 'D')
                            Credit();
                       else
                            Debit();
                    }
               break;
      case 5 :
               if ( !hdr_line )   /* Hdr rec */
                   Debit();
               else if (atof(d_ar_amount.arr) < 0.00)
                       Debit(); 
                  else 
                       Credit();
               break;
      case 6 : /* the following condition have been changed by VSK
				  on 12/09/1999. The condition is altered to bring
				  amouts as credit and debit which was before both
				  credit */
               if ( !hdr_line )   /* Hdr rec */
			   {		
					if (atof(d_ar_amount.arr) < 0.00)
	                   Debit();
					else
					   Credit();
			   }
               else 
			   {
					if (atof(d_ar_amount.arr) < 0.00)
                       Debit();
                    else 
                       Credit(); 
			   }
               break;
    }
}

Credit()
{

#ifdef DEBUG
   sprintf(string_var,"%s - %d - %s - %s",d_ar_doc_num.arr,d_ar_sign_amount,d_ar_amount_negative.arr,d_ar_amount.arr);
   disp_message(INFO_MESG,string_var);
#endif

   if (d_ar_sign_amount == 0)
         strcpy(d_ar_credit_amt.arr,"");
   else
   {
       if (d_ar_sign_amount == -1)
         strcpy(d_ar_credit_amt.arr,d_ar_amount_negative.arr);
       else
         strcpy(d_ar_credit_amt.arr,d_ar_amount.arr);
    }

   strcpy(d_ar_debit_amt.arr,"");

   d_ar_credit_amt.len = strlen(d_ar_credit_amt.arr);
   d_ar_debit_amt.len = strlen(d_ar_debit_amt.arr);
}
 
Debit()
{

#ifdef DEBUG
   sprintf(string_var,"%s - %d - %s - %s",d_ar_doc_num.arr,d_ar_sign_amount,d_ar_amount_negative.arr,d_ar_amount.arr);
   disp_message(INFO_MESG,string_var);
#endif

   if (d_ar_sign_amount == 0)
         strcpy(d_ar_debit_amt.arr,"");
   else
   {
        if (d_ar_sign_amount == -1)
           strcpy(d_ar_debit_amt.arr,d_ar_amount_negative.arr);
        else
           strcpy(d_ar_debit_amt.arr,d_ar_amount.arr);
   }

   strcpy(d_ar_credit_amt.arr,"");

   d_ar_credit_amt.len = strlen(d_ar_credit_amt.arr);
   d_ar_debit_amt.len = strlen(d_ar_debit_amt.arr);
}

delete_records()
{
    
    while (1)
    {
       
       /* EXEC SQL DELETE FROM AR_GL_DISTRBN_TEMP
                      WHERE ROWNUM < 500; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 27;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "delete  from AR_GL_DISTRBN_TEMP  where ROWNUM<500";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1830;
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
       sqlstm.arrsiz = 27;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1845;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



       if (OERROR)
            err_mesg("COMMIT failed",0,""); 

       if (NOT_FOUND)
             break;
    }
}

run_report()
{
  char l_run_string[300],l_messg_str[132];
  int  l_ret_run_rep;

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Run report\n");
#endif

  disp_message(INFO_MESG,"Generating Detail report\n");

if (nd_rep_type.arr[0] == 'D')
{
     sprintf(l_run_string,"runrep %s %s no \
%s session_id=%s pgm_date=%s %s desname=%s.lis",
     "arrgldtl", uid_pwd.arr,
     (nd_view_print_flg.arr[0]=='V')?"batch=no":"batch=yes",
     nd_session_id.arr,g_pgm_date,
     (nd_view_print_flg.arr[0]=='V')?"destype=Screen":"destype=File",
      "arrgldtl");
 
      l_ret_run_rep = WinExec(l_run_string,SW_NORMAL);
      if (l_ret_run_rep < 32)
      { disp_message(ERR_MESG,"Error in calling Report Writer Program");
        proc_exit();
      }  
      if (l_ret_run_rep)
      {
         sprintf("%s\n",l_run_string);
         sprintf(l_messg_str,"RUNREP-arrgldis session=%s pgm dt = %s failed \
return value %d",
         nd_session_id.arr,nd_pgm_date.arr,l_ret_run_rep);
         err_mesg(l_messg_str,0,"");
       }

  disp_message(INFO_MESG,"Generating Summary report\n");

       sprintf(l_run_string,"runrep %s %s no \
 %s session_id=%s pgm_date=%s %s desname=%s.lis",
       "arrgldsm",uid_pwd.arr,
       (nd_view_print_flg.arr[0]=='V')?"batch=no":"batch=yes",
       nd_session_id.arr,g_pgm_date,
       (nd_view_print_flg.arr[0]=='V')?"destype=Screen":"destype=File",
       "arrgldsm");
 
       l_ret_run_rep = WinExec(l_run_string,SW_NORMAL);
      if (l_ret_run_rep < 32)
      { disp_message(ERR_MESG,"Error in calling Report Writer Program");
        proc_exit();
      }

       if (l_ret_run_rep)
       {
          sprintf("%s\n",l_run_string);
          sprintf(l_messg_str,
           "RUNREP - arrgldsm session = %s pgm dt = %s failed return value %d",
           nd_session_id.arr,nd_pgm_date.arr,l_ret_run_rep);
           err_mesg(l_messg_str,0,"");
        }
 }
 else
 {
      sprintf(l_run_string,"runrep %s %s no \
  %s session_id=%s pgm_date=%s %s desname=%s.lis",
     "arrgldsm", uid_pwd.arr,
     (nd_view_print_flg.arr[0]=='V')?"batch=no":"batch=yes",
     nd_session_id.arr,g_pgm_date,
     (nd_view_print_flg.arr[0]=='V')?"destype=Screen":"destype=File",
     "arrgldsm");
      l_ret_run_rep = WinExec(l_run_string,SW_NORMAL);
      if (l_ret_run_rep < 32)
      { disp_message(ERR_MESG,"Error in calling Report Writer Program");
        proc_exit();
      }

      if (l_ret_run_rep)
      {
         sprintf("%s\n",l_run_string);
         sprintf(l_messg_str,
             "RUNREP-arrgldsm session=%s pgm dt = %s failed return value %d",
            nd_session_id.arr,nd_pgm_date.arr,l_ret_run_rep);
         err_mesg(l_messg_str,0,"");
       }
 }
#ifdef DEBUG
   disp_message(INFO_MESG,"After run rep...\n");
#endif
}
