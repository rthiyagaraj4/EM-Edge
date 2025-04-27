
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
           char  filnam[30];
};
static const struct sqlcxp sqlfpn =
{
    29,
    "C:\\temp1\\ICN-DEMO\\BLBPSTFL.PC"
};


static unsigned long sqlctx = 1480334949;


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
            void  *sqhstv[84];
   unsigned int   sqhstl[84];
            int   sqhsts[84];
            void  *sqindv[84];
            int   sqinds[84];
   unsigned int   sqharm[84];
   unsigned int   *sqharc[84];
   unsigned short  sqadto[84];
   unsigned short  sqtdso[84];
} sqlstm = {10,84};

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

 static const char *sq0013 = 
"I:SS')) and NVL(TRX_FINALIZE_IND,'N')='Y') and (EPISODE_TYPE not  in ('O','E\
') or (EPISODE_TYPE in ('O','E') and NVL(AVAILED_IND,'N') not  in ('Y','U','C'\
)))) order by TRX_DOC_REF,PACKAGE_IND,PACKAGE_SERVICE_CODE,BLNG_SERV_CODE,ACCT\
_DEPT_CODE            ";

 static const char *sq0021 = 
"select BL_RECV_ACC_INT_CODE  from BL_BILL_TYPE_INT A where ((BILL_TYPE_CODE=\
:b0 and TO_DATE(:b1,'DD/MM/YYYY') between NVL(EFF_FROM_DATE,TO_DATE('01/01/190\
0','DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE)) and exists (select 'X'  from S\
Y_ACC_ENTITY B where (ACC_ENTITY_ID=:b2 and A.ACC_ENTITY_CODE=B.ACC_ENTITY_COD\
E)))           ";

 static const char *sq0022 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DECODE(DEPT_CODE,'X',:b0,DEPT_CODE) ,\
SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CO\
DE  from BL_GL_ACCOUNT A where (ACC_INT_CODE=:b1 and exists (select 'X'  from \
SY_ACC_ENTITY B where (ACC_ENTITY_ID=:b2 and A.ACC_ENTITY_CODE=B.ACC_ENTITY_CO\
DE)))           ";

 static const char *sq0017 = 
"select DISCOUNT_ACC_INT_CODE  from BL_TYPE_FOR_SERV_GRP A where (((BLNG_GRP_\
ID=:b0 and BILL_TYPE_CODE=:b1) and TO_DATE(:b2,'DD/MM/YYYY') between NVL(EFF_F\
ROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE)) and\
 exists (select 'X'  from SY_ACC_ENTITY B where (ACC_ENTITY_ID=:b3 and A.ACC_E\
NTITY_CODE=B.ACC_ENTITY_CODE)))           ";

 static const char *sq0018 = 
"select DISCOUNT_ACC_INT_CODE  from BL_SERV_GRP_PAYER_INT A where (((((BLNG_G\
RP_ID=:b0 and BILL_TYPE_CODE=:b1) and BLNG_SERV_CODE=:b2) and CUST_CODE=:b3) a\
nd TO_DATE(:b4,'DD/MM/YYYY') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','D\
D/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE)) and exists (select 'X'  from SY_ACC\
_ENTITY B where (ACC_ENTITY_ID=:b5 and A.ACC_ENTITY_CODE=B.ACC_ENTITY_CODE))) \
          ";

 static const char *sq0019 = 
"select DISCOUNT_ACC_INT_CODE  from BL_SERV_GRP_PAYER_INT A where (((((BLNG_G\
RP_ID=:b0 and BILL_TYPE_CODE=:b1) and BLNG_SERV_CODE=(select serv_classificati\
on_code  from bl_blng_serv where blng_serv_code=:b2)) and CUST_CODE=:b3) and T\
O_DATE(:b4,'DD/MM/YYYY') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM\
/YYYY')) and NVL(EFF_TO_DATE,SYSDATE)) and exists (select 'X'  from SY_ACC_ENT\
ITY B where (ACC_ENTITY_ID=:b5 and A.ACC_ENTITY_CODE=B.ACC_ENTITY_CODE)))     \
      ";

 static const char *sq0020 = 
"select DISCOUNT_ACC_INT_CODE  from BL_SERV_GRP_PAYER_INT A where (((((BLNG_G\
RP_ID=:b0 and BILL_TYPE_CODE=:b1) and BLNG_SERV_CODE=SUBSTR(:b2,1,2)) and CUST\
_CODE=:b3) and TO_DATE(:b4,'DD/MM/YYYY') between NVL(EFF_FROM_DATE,TO_DATE('01\
/01/1900','DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE)) and exists (select 'X' \
 from SY_ACC_ENTITY B where (ACC_ENTITY_ID=:b5 and A.ACC_ENTITY_CODE=B.ACC_ENT\
ITY_CODE)))           ";

 static const char *sq0014 = 
"select INCOME_ACC_INT_CODE  from BL_TYPE_FOR_BLNG_SERV A where (((BLNG_SERV_\
CODE=:b0 and BILL_TYPE_CODE=:b1) and TO_DATE(:b2,'DD/MM/YYYY') between NVL(EFF\
_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE)) a\
nd exists (select 'X'  from SY_ACC_ENTITY B where (ACC_ENTITY_ID=:b3 and A.ACC\
_ENTITY_CODE=B.ACC_ENTITY_CODE)))           ";

 static const char *sq0015 = 
"select INCOME_ACC_INT_CODE  from BL_TYPE_FOR_BLNG_SERV A where (((BLNG_SERV_\
CODE=(select serv_classification_code  from bl_blng_serv where blng_serv_code=\
:b0) and BILL_TYPE_CODE=:b1) and TO_DATE(:b2,'DD/MM/YYYY') between NVL(EFF_FRO\
M_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE)) and e\
xists (select 'X'  from SY_ACC_ENTITY B where (ACC_ENTITY_ID=:b3 and A.ACC_ENT\
ITY_CODE=B.ACC_ENTITY_CODE)))           ";

 static const char *sq0016 = 
"select INCOME_ACC_INT_CODE  from BL_TYPE_FOR_BLNG_SERV A where (((BLNG_SERV_\
CODE=SUBSTR(:b0,1,2) and BILL_TYPE_CODE=:b1) and TO_DATE(:b2,'DD/MM/YYYY') bet\
ween NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(EFF_TO_DATE\
,SYSDATE)) and exists (select 'X'  from SY_ACC_ENTITY B where (ACC_ENTITY_ID=:\
b3 and A.ACC_ENTITY_CODE=B.ACC_ENTITY_CODE)))           ";

 static const char *sq0023 = 
"select  /*+ INDEX(BL_PATIENT_CHARGES_FOLIO BL_PATIENT_CHARGES_FOLIO_I1) USE \
					             BL_PATIENT_CHARGES_FOLIO_I1 +*/ ROWID  from BL_PATIENT_CHARG\
ES_FOLIO where (((((((TRX_DOC_REF=:b0 and TRX_DOC_REF_LINE_NUM=DECODE(:b1,'Y',\
TRX_DOC_REF_LINE_NUM,:b2)) and TRX_DOC_REF_SEQ_NUM=DECODE(:b1,'Y',TRX_DOC_REF_\
SEQ_NUM,:b4)) and NVL(TRX_POSTED_IND,'N')='N') and TRX_DATE<=TO_DATE((:b5||' 2\
3:59:59'),'DD/MM/YYYY HH24:MI:SS')) and NVL(TRX_FINALIZE_IND,'N')='Y') and OPE\
RATING_FACILITY_ID=:b6) and (EPISODE_TYPE not  in ('O','E') or (EPISODE_TYPE i\
n ('O','E') and NVL(AVAILED_IND,'N') not  in ('Y','U','C')))) for update of TR\
X_DOC_REF nowait ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,279,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,116,0,6,317,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
67,0,0,3,22,0,1,352,0,0,0,0,0,1,0,
82,0,0,4,105,0,4,364,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
113,0,0,5,22,0,1,511,0,0,0,0,0,1,0,
128,0,0,6,554,0,6,622,0,0,21,21,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
227,0,0,7,0,0,29,679,0,0,0,0,0,1,0,
242,0,0,8,319,0,5,690,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
289,0,0,9,0,0,30,705,0,0,0,0,0,1,0,
304,0,0,10,191,0,4,724,0,0,10,4,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
359,0,0,11,318,0,4,761,0,0,9,1,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,1,0,0,2,
1,0,0,2,1,0,0,2,9,0,0,1,9,0,0,
410,0,0,12,101,0,4,813,0,0,2,1,0,1,0,2,1,0,0,1,9,0,0,
433,0,0,13,2302,0,9,1094,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
456,0,0,13,0,0,13,1275,0,0,84,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,
807,0,0,24,525,0,6,1452,0,0,10,10,0,1,0,2,9,0,0,3,9,0,0,2,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
862,0,0,25,1992,0,6,1485,0,0,13,13,0,1,0,3,9,0,0,3,9,0,0,2,9,0,0,3,9,0,0,3,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
929,0,0,26,205,0,4,1581,0,0,5,4,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
964,0,0,27,208,0,4,1592,0,0,5,4,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
999,0,0,21,325,0,9,1699,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1026,0,0,21,0,0,13,1706,0,0,1,0,0,1,0,2,9,0,0,
1045,0,0,22,326,0,9,1726,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1072,0,0,22,0,0,13,1752,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1115,0,0,17,352,0,9,1786,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1146,0,0,17,0,0,13,1794,0,0,1,0,0,1,0,2,9,0,0,
1165,0,0,18,398,0,9,1799,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1204,0,0,18,0,0,13,1807,0,0,1,0,0,1,0,2,9,0,0,
1223,0,0,19,472,0,9,1818,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1262,0,0,19,0,0,13,1826,0,0,1,0,0,1,0,2,9,0,0,
1281,0,0,20,410,0,9,1836,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1320,0,0,20,0,0,13,1844,0,0,1,0,0,1,0,2,9,0,0,
1339,0,0,17,352,0,9,1854,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1370,0,0,17,0,0,13,1862,0,0,1,0,0,1,0,2,9,0,0,
1389,0,0,22,326,0,9,1885,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1416,0,0,22,0,0,13,1905,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1459,0,0,14,354,0,9,1936,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1490,0,0,14,0,0,13,1941,0,0,1,0,0,1,0,2,9,0,0,
1509,0,0,15,428,0,9,1952,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1540,0,0,15,0,0,13,1957,0,0,1,0,0,1,0,2,9,0,0,
1559,0,0,16,366,0,9,1965,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1590,0,0,16,0,0,13,1970,0,0,1,0,0,1,0,2,9,0,0,
1609,0,0,22,326,0,9,1991,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1636,0,0,22,0,0,13,2011,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1679,0,0,28,244,0,4,2061,0,0,5,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1714,0,0,29,966,0,3,2087,0,0,32,32,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1857,0,0,30,974,0,3,2189,0,0,32,32,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2000,0,0,31,244,0,4,2303,0,0,5,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
2035,0,0,32,966,0,3,2324,0,0,32,32,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2178,0,0,33,30,0,43,2417,0,0,0,0,0,1,0,
2193,0,0,34,930,0,5,2426,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2244,0,0,35,365,0,5,2454,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
2287,0,0,23,639,0,9,2478,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
2330,0,0,23,0,0,13,2492,0,0,1,0,0,1,0,2,9,0,0,
2349,0,0,36,0,0,29,2553,0,0,0,0,0,1,0,
2364,0,0,37,22,0,1,2566,0,0,0,0,0,1,0,
2379,0,0,38,361,0,5,2771,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
2418,0,0,39,338,0,6,2798,0,0,5,5,0,1,0,1,97,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLBPSTFL.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* Converted to windows  : Prasad B G S 3/7/96                          */
/* DATE WRITTEN          : 19-AUG-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                                */
/*                                                                      */
/*  TABLE DETAILS                                                       */   
/*                                                                      */
/*        S. No.       TABLENAMES              INPUT/OUTPUT             */
/*                                                                      */
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
#include "gl.h"  
#include "bl.h"     
         
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define VIEW_LOG_FILE 1

/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 

    /* VARCHAR hosp_name                              [120],
	    date_time                                  [20],
	    user_id                                    [40],
	    nd_pwd 									   [91],
	    nd_session_id                              [16],
	    nd_pgm_date                                [25],
	    d_curr_pgm_name                            [15],
	    nd_post_upto_date                          [11],
	    nd_operating_facility_id				   [3],
	    nd_ws_no								   [31],
	    nd_doc_type_code						    [7],
	    nd_doc_num									[9],
	    nd_doc_date								   [35],
	    nd_cash_counter_code                        [7] ,
	    nd_shift_id									[2],
	    nd_reason_text							  [300],
	    nd_pre_doc_type_code						[7],
	    nd_pre_doc_num								[9],
	    nd_pre_doc_date							   [35],
	    nd_cust_code								[9],
	    nd_pre_cust_code							[9],
	    nd_post_month								[3],
	    nd_post_year								[5],
	    nd_error_level								[10],
	    nd_sys_message_id							[10],
	    nd_error_text							  [1000]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[11]; } nd_post_upto_date;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_doc_num;

struct { unsigned short len; unsigned char arr[35]; } nd_doc_date;

struct { unsigned short len; unsigned char arr[7]; } nd_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } nd_shift_id;

struct { unsigned short len; unsigned char arr[300]; } nd_reason_text;

struct { unsigned short len; unsigned char arr[7]; } nd_pre_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_pre_doc_num;

struct { unsigned short len; unsigned char arr[35]; } nd_pre_doc_date;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_pre_cust_code;

struct { unsigned short len; unsigned char arr[3]; } nd_post_month;

struct { unsigned short len; unsigned char arr[5]; } nd_post_year;

struct { unsigned short len; unsigned char arr[10]; } nd_error_level;

struct { unsigned short len; unsigned char arr[10]; } nd_sys_message_id;

struct { unsigned short len; unsigned char arr[1000]; } nd_error_text;
   

   /* VARCHAR bl_pat_trx_doc_ref                      [21],
	   bl_pat_trx_doc_ref_line_num                 [5],
	   bl_pat_trx_doc_ref_seq_num                  [5],
	   bl_pat_trx_date                             [13],
	   bl_pat_episode_type                         [2],
	   bl_pat_patient_id                           [21],
	   bl_pat_episode_id                           [9],
	   bl_pat_visit_id                             [5],
	   bl_pat_billed_flag                          [2],
	   bl_pat_settlement_ind                       [2],

	   d_orig_dept_code                            [11],
	   d_bed_class_code                            [3],

	   bl_pat_prt_grp_hdr_code                     [6],
	   bl_pat_prt_grp_line_code                    [4],
	   bl_pat_package_ind                          [2],
	   bl_pat_package_service_code                 [11],
	   bl_pat_blng_serv_code                       [11],
	   bl_pat_package_trx_ind                      [2],
	   bl_pat_serv_locn_code                       [5],
	   bl_pat_serv_item_code                       [21],
	   bl_pat_serv_item_desc                       [41],
	   bl_pat_rate_charge_flag                     [2],
	   bl_pat_base_qty                             [23],
	   bl_pat_base_rate                            [23],
	   bl_pat_serv_qty                             [23],
	   bl_pat_base_charge_amt                      [23],
	   bl_pat_org_gross_charge_amt                 [23],
	   bl_pat_org_disc_amt                         [23],
	   bl_pat_org_net_charge_amt                   [23],
	   bl_pat_upd_gross_charge_amt                 [23],
	   bl_pat_upd_disc_amt                         [23],
	   bl_pat_upd_net_charge_amt                   [23],
	   bl_pat_adj_gross_charge_amt                 [23],
	   bl_pat_adj_disc_amt                         [23],
	   bl_pat_adj_net_charge_amt                   [23],
	   bl_pat_module_id                            [3],
	   bl_pat_source_doc_ref                       [21],
	   bl_pat_source_doc_date                      [13],
	   bl_pat_service_date                         [13],
	   bl_pat_service_date_time		       [30],
	   bl_pat_acct_dept_code                       [11],
	   bl_pat_orig_dept_code                       [11],
	   bl_pat_physician_id                         [16],
	   l_op_physician_id			       [17],
	   l_clinic_code			       [5],
	   l_ward_code				       [5],
	   bl_pat_blng_grp_id                          [5],
	   bl_pat_blng_class_code                      [3],
	   bl_pat_day_type_code                        [3],
	   bl_pat_time_type_code                       [3],
	   bl_pat_disc_perc                            [6],
	   bl_pat_addl_factor_num                      [6],
	   bl_pat_bed_class_code                       [3],
	   bl_pat_bill_type_code                       [3],
	   bl_pat_folio_remarks                        [51],
	   bl_pat_df_service_ind                       [2],
	   bl_pat_df_upd_flag                          [2],
	   bl_pat_doc_type_code                        [7],
	   bl_pat_doc_number                           [23],
	   bl_pat_bill_doc_type_code                   [7],
	   bl_pat_bill_doc_num                         [9],
	   bl_pat_bill_doc_date                        [13],
	   bl_pat_trx_finalize_ind                     [2],
	   bl_pat_finalized_by_id                      [21],
	   bl_pat_finalized_date                       [13],
	   bl_pat_trx_posted_ind                       [2],
	   bl_pat_posted_by_id                         [21],
	   bl_pat_posted_date                          [13],
	   bl_pat_last_adjusted_by_id                  [21],
	   bl_pat_last_adjusted_date                   [13],
	   bl_pat_added_by_id                          [21],
	   bl_pat_modified_by_id                       [21],
	   bl_pat_added_date                           [13],
	   bl_pat_modified_date                        [13],

	   bl_pat_rowid                                [31],

	   bl_pat_concat_code                          [16],

	   bl_store_trx_doc_ref_line_no		       [10],	
	   bl_store_trx_doc_ref_seq_no		       [10],
	   bl_store_trx_date                           [13],
	   bl_store_episode_type                       [2],
	   bl_store_patient_id                         [21],
	   bl_store_episode_id                         [9],
	   bl_store_visit_id                           [5],
	   bl_store_trx_doc_ref                        [51],
	   store_concat_code                           [16],
	   bl_loc                                      [10],     
	   store_acct_dept_code                        [11]; */ 
struct { unsigned short len; unsigned char arr[21]; } bl_pat_trx_doc_ref;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_trx_date;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_episode_type;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_patient_id;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_visit_id;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_billed_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_settlement_ind;

struct { unsigned short len; unsigned char arr[11]; } d_orig_dept_code;

struct { unsigned short len; unsigned char arr[3]; } d_bed_class_code;

struct { unsigned short len; unsigned char arr[6]; } bl_pat_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pat_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_package_ind;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_package_service_code;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_blng_serv_code;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_package_trx_ind;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_serv_locn_code;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_serv_item_code;

struct { unsigned short len; unsigned char arr[41]; } bl_pat_serv_item_desc;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_rate_charge_flag;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_base_qty;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_base_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_serv_qty;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_base_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_org_gross_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_org_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_org_net_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_gross_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_net_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_adj_gross_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_adj_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_adj_net_charge_amt;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_module_id;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_source_doc_ref;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_source_doc_date;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_service_date;

struct { unsigned short len; unsigned char arr[30]; } bl_pat_service_date_time;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_acct_dept_code;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_orig_dept_code;

struct { unsigned short len; unsigned char arr[16]; } bl_pat_physician_id;

struct { unsigned short len; unsigned char arr[17]; } l_op_physician_id;

struct { unsigned short len; unsigned char arr[5]; } l_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } l_ward_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_blng_class_code;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_day_type_code;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_time_type_code;

struct { unsigned short len; unsigned char arr[6]; } bl_pat_disc_perc;

struct { unsigned short len; unsigned char arr[6]; } bl_pat_addl_factor_num;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_bed_class_code;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_bill_type_code;

struct { unsigned short len; unsigned char arr[51]; } bl_pat_folio_remarks;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_df_service_ind;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_df_upd_flag;

struct { unsigned short len; unsigned char arr[7]; } bl_pat_doc_type_code;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_doc_number;

struct { unsigned short len; unsigned char arr[7]; } bl_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_bill_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_bill_doc_date;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_trx_finalize_ind;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_finalized_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_finalized_date;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_trx_posted_ind;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_posted_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_posted_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_last_adjusted_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_last_adjusted_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_added_by_id;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_modified_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_added_date;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_modified_date;

struct { unsigned short len; unsigned char arr[31]; } bl_pat_rowid;

struct { unsigned short len; unsigned char arr[16]; } bl_pat_concat_code;

struct { unsigned short len; unsigned char arr[10]; } bl_store_trx_doc_ref_line_no;

struct { unsigned short len; unsigned char arr[10]; } bl_store_trx_doc_ref_seq_no;

struct { unsigned short len; unsigned char arr[13]; } bl_store_trx_date;

struct { unsigned short len; unsigned char arr[2]; } bl_store_episode_type;

struct { unsigned short len; unsigned char arr[21]; } bl_store_patient_id;

struct { unsigned short len; unsigned char arr[9]; } bl_store_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_store_visit_id;

struct { unsigned short len; unsigned char arr[51]; } bl_store_trx_doc_ref;

struct { unsigned short len; unsigned char arr[16]; } store_concat_code;

struct { unsigned short len; unsigned char arr[10]; } bl_loc;

struct { unsigned short len; unsigned char arr[11]; } store_acct_dept_code;



/* VARCHAR    bl_dept_main_acc1_code                  [11],
	   bl_dept_main_acc2_code                      [5],
	   bl_dept_dept_code                           [11],
	   bl_dept_subledger_group_code                [4],
	   bl_dept_subledger_line_code                 [9],
	   bl_dept_product_group_code                  [4],
	   bl_dept_product_line_code                   [5],

	   bl_pkg1_main_acc1_code                      [11],
	   bl_pkg1_main_acc2_code                      [5],
	   bl_pkg1_dept_code                           [11],
	   bl_pkg1_subledger_group_code                [4],
	   bl_pkg1_subledger_line_code                 [9],
	   bl_pkg1_product_group_code                  [4],
	   bl_pkg1_product_line_code                   [5],

	   bl_pkg2_main_acc1_code                      [11],
	   bl_pkg2_main_acc2_code                      [5],
	   bl_pkg2_dept_code                           [11],
	   bl_pkg2_subledger_group_code                [4],
	   bl_pkg2_subledger_line_code                 [9],
	   bl_pkg2_product_group_code                  [4],
	   bl_pkg2_product_line_code                   [5],

	   bl_acc_int_code                             [7]; */ 
struct { unsigned short len; unsigned char arr[11]; } bl_dept_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_dept_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } bl_dept_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_dept_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_dept_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_dept_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_dept_product_line_code;

struct { unsigned short len; unsigned char arr[11]; } bl_pkg1_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pkg1_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } bl_pkg1_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pkg1_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_pkg1_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pkg1_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pkg1_product_line_code;

struct { unsigned short len; unsigned char arr[11]; } bl_pkg2_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pkg2_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } bl_pkg2_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pkg2_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_pkg2_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pkg2_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pkg2_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } bl_acc_int_code;


/* VARCHAR    d_hdr_upd_rowid            [20],
           d_lin_upd_rowid            [20]; */ 
struct { unsigned short len; unsigned char arr[20]; } d_hdr_upd_rowid;

struct { unsigned short len; unsigned char arr[20]; } d_lin_upd_rowid;


 
 
/* VARCHAR	        l_allow_unbilled_folio			[10],
				l_unbilled_remarks				[55],
				l_cash_ctrl_rcpt_in_use			[10],
				l_temp_narration				[100],
				l_group_posting_yn				[5],
				l_temp_prev_trx_doc_ref			[51],
				l_temp_curr_trx_doc_ref			[51],
				l_temp_reason					[100],
				l_error_yn						[10],
				l_error_msg						[300]; */ 
struct { unsigned short len; unsigned char arr[10]; } l_allow_unbilled_folio;

struct { unsigned short len; unsigned char arr[55]; } l_unbilled_remarks;

struct { unsigned short len; unsigned char arr[10]; } l_cash_ctrl_rcpt_in_use;

struct { unsigned short len; unsigned char arr[100]; } l_temp_narration;

struct { unsigned short len; unsigned char arr[5]; } l_group_posting_yn;

struct { unsigned short len; unsigned char arr[51]; } l_temp_prev_trx_doc_ref;

struct { unsigned short len; unsigned char arr[51]; } l_temp_curr_trx_doc_ref;

struct { unsigned short len; unsigned char arr[100]; } l_temp_reason;

struct { unsigned short len; unsigned char arr[10]; } l_error_yn;

struct { unsigned short len; unsigned char arr[300]; } l_error_msg;
   
/* These Variables added by raghava on 15/07/2008 for Additional Charge*/
/* VARCHAR		 bl_operating_facility_id [3],
			 bl_blng_serv_code		  [11],
			 bl_bill_type_code        [4],
			 bl_rule_code			  [7],
			 bl_gl_interface_code	  [7]; */ 
struct { unsigned short len; unsigned char arr[3]; } bl_operating_facility_id;

struct { unsigned short len; unsigned char arr[11]; } bl_blng_serv_code;

struct { unsigned short len; unsigned char arr[4]; } bl_bill_type_code;

struct { unsigned short len; unsigned char arr[7]; } bl_rule_code;

struct { unsigned short len; unsigned char arr[7]; } bl_gl_interface_code;


double 		 bl_addl_charge_amt,
			 bl_addl_charge_amt_in_charge;
/* upto here*/
 
    int		bl_pat_serv_mth,
			bl_pat_serv_yr;

    int		bl_mth,
			bl_yr,
			cur_mth,
			cur_yr,
			nd_month,l_cnt=1,
			nd_year;

   double  bl_tot_gross_charge_amt = 0,
	   bl_tot_disc_amt = 0,
	   bl_tot_net_charge_amt = 0;

    char   d_ip_gl_yn,
	   d_op_gl_yn,
	   nd_cash_control_use_flag,
	   d_rf_gl_yn,
	   l_mesg[500],
	   ctest[100],temp[100];

    /* VARCHAR	nd_orig_doc_ref[30],nd_trx_status[2], nd_confirmed_yn[2]; */ 
struct { unsigned short len; unsigned char arr[30]; } nd_orig_doc_ref;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_status;

struct { unsigned short len; unsigned char arr[2]; } nd_confirmed_yn;
                  
    long        nd_orig_doc_ref_line_num,          
	        nd_orig_doc_ref_seq_num,
		nd_can_rec_ctr = 0;

    char msg_str_var[1000], string_var[1000];

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





#include <winproc.h>

int rec_ctr = 0, err_ctr = 0;
char msg_str[132];

char	prv_trx_ref[51];
char	l_prev_trx_doc_ref_line_num[10];
char	l_prev_trx_doc_ref_seq_num[20];
int skip_rec;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 7)
    {
		int i = 0;
		disp_message(ERR_MESG,"Not enough Parameters for running this program");
		proc_exit();
    }
 
    strcpy(g_pgm_id,"BLBPSTFL");

    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);

    /* EXEC sql connect :nd_pwd; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )10;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
    sqlstm.sqhstl[0] = (unsigned int  )93;
    sqlstm.sqhsts[0] = (         int  )93;
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


	if(OERROR)
    {
		disp_message(ERR_MESG,"Error in connecting to Oracle");
		proc_exit();
    }

    set_meduser_role();

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

    strcpy(g_facility_id,nd_operating_facility_id.arr);    

    strcpy(nd_ws_no.arr,argv[6]);
    nd_ws_no.len = strlen(nd_ws_no.arr);  

    start_prog_msg();
    fetch_prog_param();

    l_error_yn.arr[0]	= '\0';
    l_error_msg.arr[0]	= '\0';
    l_error_yn.len	= 0;
    l_error_msg.len	= 0;

    

    /* EXEC SQL EXECUTE
    BEGIN
	bl_upd_back_cash_ctrl(:nd_operating_facility_id,
	  		      :l_group_posting_yn,
			      :l_error_yn,
			      :l_error_msg);
    END;
    END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin bl_upd_back_cash_ctrl ( :nd_operating_facility_id ,\
 :l_group_posting_yn , :l_error_yn , :l_error_msg ) ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_group_posting_yn;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_error_yn;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_error_msg;
    sqlstm.sqhstl[3] = (unsigned int  )302;
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




    l_error_yn.len  = strlen(l_error_yn.arr);
    l_error_msg.len = strlen(l_error_msg.arr);

    if(strcmp(l_error_yn.arr,"Y")==0)
    {
	sprintf(l_mesg,"Error in Proc bl_upd_back_cash_control : %s",l_error_msg.arr);
	disp_message(ERR_MESG,l_mesg);
    }
	
    declare_cur();
    cash_control_use_chec();
     
    bl_tot_gross_charge_amt = 0;
    bl_tot_disc_amt = 0;
    bl_tot_net_charge_amt = 0;

    prv_trx_ref[0] = '\0';

    open_cur();
    skip_rec = 0;

    while(fetch_cur())
    {	   
    

	 /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "savepoint LAST_DOC_REF";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )67;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	

    
	    if (OERROR)
		  err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

        
		if((strcmp(bl_pat_physician_id.arr,"000000000000000")==0) && (strcmp(bl_pat_episode_type.arr,"O")==0 || strcmp(bl_pat_episode_type.arr,"E")==0 ))
		{
			l_op_physician_id.arr[0] = '\0';
			
			/* EXEC SQL SELECT physician_id
			           INTO :l_op_physician_id
					   FROM op_visit
					  WHERE facility_id = :nd_operating_facility_id
					    AND	episode_id  = :bl_pat_episode_id
						AND visit_id    = :bl_pat_visit_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select physician_id into :b0  from op_visit where ((facili\
ty_id=:b1 and episode_id=:b2) and visit_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )82;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_op_physician_id;
   sqlstm.sqhstl[0] = (unsigned int  )19;
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
   sqlstm.sqhstv[2] = (         void  *)&bl_pat_episode_id;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bl_pat_visit_id;
   sqlstm.sqhstl[3] = (unsigned int  )7;
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




			if(strlen(l_op_physician_id.arr)>0)
			{
				l_op_physician_id.arr[l_op_physician_id.len] = '\0';
				strcpy(bl_pat_physician_id.arr,l_op_physician_id.arr);
				bl_pat_physician_id.len = strlen(bl_pat_physician_id.arr);
			}	
		}		


		upd_reasons_in_folio_for_unposting();        

		if (nd_reason_text.arr[0] != '\0')
		{
			//New addition by Harish on 05/05/2004
			err_ctr=0;
			continue;	
		}
		//if(strcmp("OR-IPEN0404-00000136",bl_pat_trx_doc_ref.arr))

		if(strcmp(l_group_posting_yn.arr,"Y")==0)
		{
			if(skip_rec && !strcmp(prv_trx_ref, bl_pat_trx_doc_ref.arr))
			{
				//New addition by Harish on 05/05/2004
				err_ctr=0;
				continue;
			}
		}
		else if(strcmp(l_group_posting_yn.arr,"N")==0)
		{
			l_temp_curr_trx_doc_ref.arr[0] = '\0';
			l_temp_curr_trx_doc_ref.len    = 0;

			l_temp_prev_trx_doc_ref.arr[0] = '\0';
			l_temp_prev_trx_doc_ref.len    = 0;

			strcat(l_temp_curr_trx_doc_ref.arr,bl_pat_trx_doc_ref.arr);
			l_temp_curr_trx_doc_ref.len = strlen(l_temp_curr_trx_doc_ref.arr);		

			strcat(l_temp_curr_trx_doc_ref.arr,bl_pat_trx_doc_ref_line_num.arr);
			l_temp_curr_trx_doc_ref.len = strlen(l_temp_curr_trx_doc_ref.arr);		

			strcat(l_temp_curr_trx_doc_ref.arr,bl_pat_trx_doc_ref_seq_num.arr);
			l_temp_curr_trx_doc_ref.len = strlen(l_temp_curr_trx_doc_ref.arr);		

			strcat(l_temp_prev_trx_doc_ref.arr,prv_trx_ref);
			l_temp_prev_trx_doc_ref.len = strlen(l_temp_prev_trx_doc_ref.arr);		

			strcat(l_temp_prev_trx_doc_ref.arr,l_prev_trx_doc_ref_line_num);
			l_temp_prev_trx_doc_ref.len = strlen(l_temp_prev_trx_doc_ref.arr);		

			strcat(l_temp_prev_trx_doc_ref.arr,l_prev_trx_doc_ref_seq_num);
			l_temp_prev_trx_doc_ref.len = strlen(l_temp_prev_trx_doc_ref.arr);				
			

			if(skip_rec && (!strcmp(l_temp_curr_trx_doc_ref.arr,l_temp_prev_trx_doc_ref.arr)))
			{
				//New addition by Harish on 05/05/2004
				err_ctr=0;
				continue;
			}
		}

		//if(strcmp("OR-IPEN0404-00000136",bl_pat_trx_doc_ref.arr))

		if(strcmp(l_group_posting_yn.arr,"Y")==0)
		{
			if(strcmp(prv_trx_ref, bl_pat_trx_doc_ref.arr)) 
			{
				/* Check if all records for the trx_doc_ref can be locked    */
				/* If not the skip all those trx_doc_ref                     */
				strcpy(prv_trx_ref,bl_pat_trx_doc_ref.arr);
				strcpy(l_prev_trx_doc_ref_line_num,bl_pat_trx_doc_ref_line_num.arr);
				strcpy(l_prev_trx_doc_ref_seq_num,bl_pat_trx_doc_ref_seq_num.arr);

				if(!lock_trx_ref())
					skip_rec = 1;
				else 
					skip_rec = 0;

				if(skip_rec)
				{
					//New addition by Harish on 05/05/2004
					err_ctr=0;
					continue;
				}
			}
		}
		else if(strcmp(l_group_posting_yn.arr,"N")==0)
		{
			//if(strcmp("OR-IPEN0404-00000136",bl_pat_trx_doc_ref.arr))

			if(strcmp(l_temp_curr_trx_doc_ref.arr,l_temp_prev_trx_doc_ref.arr)) 
			{
				/* Check if all records for the trx_doc_ref can be locked    */
				/* If not the skip all those trx_doc_ref                     */
				strcpy(prv_trx_ref,bl_pat_trx_doc_ref.arr);
				strcpy(l_prev_trx_doc_ref_line_num,bl_pat_trx_doc_ref_line_num.arr);
				strcpy(l_prev_trx_doc_ref_seq_num,bl_pat_trx_doc_ref_seq_num.arr);

				if(!lock_trx_ref())
					skip_rec = 1;
				else 
					skip_rec = 0;

				if(skip_rec)
				{
					//New addition by Harish on 05/05/2004
					err_ctr=0;
					continue;
				}
			}
		}

		//if(strcmp("OR-IPEN0404-00000136",bl_pat_trx_doc_ref.arr))


		strcpy(prv_trx_ref,bl_pat_trx_doc_ref.arr);
		strcpy(l_prev_trx_doc_ref_line_num,bl_pat_trx_doc_ref_line_num.arr);
		strcpy(l_prev_trx_doc_ref_seq_num,bl_pat_trx_doc_ref_seq_num.arr);

		

		if(bl_pat_package_trx_ind.arr[0] == 'Y')
		{
			updt_pkg_inc();

		}
		if(bl_pat_package_trx_ind.arr[0] == 'N')
		{
			updt_srv_inc();
		}



		if(bl_pat_package_trx_ind.arr[0] == 'N') 
		{
			if (!rec_ctr)
			{
				/* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "savepoint LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )113;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
				if (OERROR)
					err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 
			}
			rec_ctr++;

	

			if(strcmp(l_group_posting_yn.arr,"Y")==0)
			{
				if ((rec_ctr == 1)||(strcmp(bl_store_trx_doc_ref.arr,bl_pat_trx_doc_ref.arr)))
				{
					
					trx_ref_break();

				}
			}
			else if(strcmp(l_group_posting_yn.arr,"N")==0)
			{
				//sprintf(l_mesg,"Trx  : %s  %s  %s     Store  : %s  %s  %s",bl_pat_trx_doc_ref.arr,bl_pat_trx_doc_ref_line_num.arr, bl_pat_trx_doc_ref_seq_num.arr,bl_store_trx_doc_ref.arr,bl_store_trx_doc_ref_line_no.arr,bl_store_trx_doc_ref_seq_no.arr);
				//disp_message(ERR_MESG,l_mesg);

				l_temp_curr_trx_doc_ref.arr[0] = '\0';
				l_temp_curr_trx_doc_ref.len    = 0;

				l_temp_prev_trx_doc_ref.arr[0] = '\0';
				l_temp_prev_trx_doc_ref.len    = 0;

				strcat(l_temp_curr_trx_doc_ref.arr,bl_pat_trx_doc_ref.arr);
				l_temp_curr_trx_doc_ref.len = strlen(l_temp_curr_trx_doc_ref.arr);		

				strcat(l_temp_curr_trx_doc_ref.arr,bl_pat_trx_doc_ref_line_num.arr);
				l_temp_curr_trx_doc_ref.len = strlen(l_temp_curr_trx_doc_ref.arr);		

				strcat(l_temp_curr_trx_doc_ref.arr,bl_pat_trx_doc_ref_seq_num.arr);
				l_temp_curr_trx_doc_ref.len = strlen(l_temp_curr_trx_doc_ref.arr);		

				strcat(l_temp_prev_trx_doc_ref.arr,bl_store_trx_doc_ref.arr);
				l_temp_prev_trx_doc_ref.len = strlen(l_temp_prev_trx_doc_ref.arr);		

				strcat(l_temp_prev_trx_doc_ref.arr,bl_store_trx_doc_ref_line_no.arr);
				l_temp_prev_trx_doc_ref.len = strlen(l_temp_prev_trx_doc_ref.arr);		

				strcat(l_temp_prev_trx_doc_ref.arr,bl_store_trx_doc_ref_seq_no.arr);
				l_temp_prev_trx_doc_ref.len = strlen(l_temp_prev_trx_doc_ref.arr);		


				if ((rec_ctr == 1)||strcmp(l_temp_curr_trx_doc_ref.arr,l_temp_prev_trx_doc_ref.arr))
				{	

					//if(strcmp("OR-IPEN0404-00000136",bl_pat_trx_doc_ref.arr))

				   trx_ref_break();

				

				}
			}



			if ((rec_ctr == 1)||(strcmp(store_concat_code.arr,bl_pat_concat_code.arr)))
			{
				concat_break();
			}


			if ((rec_ctr == 1)||(strcmp(store_acct_dept_code.arr,bl_pat_acct_dept_code.arr)))
			{	
					
				dept_break();
			}



			bl_tot_gross_charge_amt += atof(bl_pat_adj_gross_charge_amt.arr);
			bl_tot_disc_amt			+= atof(bl_pat_adj_disc_amt.arr);
			bl_tot_net_charge_amt	+= atof(bl_pat_adj_net_charge_amt.arr);
		}

    
	    strcpy(nd_pre_doc_type_code.arr,nd_doc_type_code.arr);
	    nd_pre_doc_type_code.len = strlen(nd_pre_doc_type_code.arr);
        
	    strcpy(nd_pre_doc_num.arr,nd_doc_num.arr);
	    nd_pre_doc_num.len = strlen(nd_pre_doc_num.arr);
        
	    strcpy(nd_pre_doc_date.arr,nd_doc_date.arr);
	    nd_pre_doc_date.len = strlen(nd_pre_doc_date.arr);
        
	    strcpy(nd_pre_cust_code.arr,nd_cust_code.arr);
	    nd_pre_cust_code.len = strlen(nd_pre_cust_code.arr);

	  /*l_cnt++;
	  if (l_cnt > 100) 
	   {
	      disp_message(ERR_MESG, "100");
		  l_cnt = 0;
	  }*/

	/* This one newly added by raghava on 15/07/2008 for inserting additional charge in BL_GL_DISTRIBUTION*/	 
	 if(bl_addl_charge_amt_in_charge != 0) 
	 {


		l_error_yn.arr[0]	= '\0';
		l_error_msg.arr[0]	= '\0';
		l_error_yn.len	= 0;
		l_error_msg.len	= 0;

		/* EXEC SQL EXECUTE
		BEGIN
		   
		BL_POST_ADDL_SERV_CHARGE.GET_ADDL_CHARGE_DETLS(:nd_operating_facility_id,
										 TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY'),
										 :bl_pat_trx_doc_ref, 				
										 :bl_pat_trx_doc_ref_line_num,
										 :bl_pat_trx_doc_ref_seq_num, 
										 :nd_post_year,						
										 :nd_post_month,
										 :bl_pat_acct_dept_code,
										 :l_group_posting_yn,
										 :bl_pat_episode_type,
										 :bl_pat_patient_id,
										 :bl_pat_episode_id,
										 :bl_pat_visit_id,
										 :l_temp_narration,
										 :nd_ws_no,
										 :nd_pre_doc_type_code,
										 :nd_pre_doc_num,
										 TO_DATE(:nd_pre_doc_date,'DD/MM/YYYY'),
										 :nd_pre_cust_code,
										 :l_error_yn,
										 :l_error_msg);
					  
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin BL_POST_ADDL_SERV_CHARGE . GET_ADDL_CHARGE_DETLS ( :n\
d_operating_facility_id , TO_DATE ( :bl_pat_trx_date , 'DD/MM/YYYY' ) , :bl_pa\
t_trx_doc_ref , :bl_pat_trx_doc_ref_line_num , :bl_pat_trx_doc_ref_seq_num , :\
nd_post_year , :nd_post_month , :bl_pat_acct_dept_code , :l_group_posting_yn ,\
 :bl_pat_episode_type , :bl_pat_patient_id , :bl_pat_episode_id , :bl_pat_visi\
t_id , :l_temp_narration , :nd_ws_no , :nd_pre_doc_type_code , :nd_pre_doc_num\
 , TO_DATE ( :nd_pre_doc_date , 'DD/MM/YYYY' ) , :nd_pre_cust_code , :l_error_\
yn , :l_error_msg ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )128;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_pat_trx_date;
  sqlstm.sqhstl[1] = (unsigned int  )15;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_doc_ref;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bl_pat_trx_doc_ref_line_num;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_doc_ref_seq_num;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_post_year;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_post_month;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&bl_pat_acct_dept_code;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&l_group_posting_yn;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&bl_pat_episode_type;
  sqlstm.sqhstl[9] = (unsigned int  )4;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&bl_pat_patient_id;
  sqlstm.sqhstl[10] = (unsigned int  )23;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&bl_pat_episode_id;
  sqlstm.sqhstl[11] = (unsigned int  )11;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&bl_pat_visit_id;
  sqlstm.sqhstl[12] = (unsigned int  )7;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&l_temp_narration;
  sqlstm.sqhstl[13] = (unsigned int  )102;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[14] = (unsigned int  )33;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_pre_doc_type_code;
  sqlstm.sqhstl[15] = (unsigned int  )9;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_pre_doc_num;
  sqlstm.sqhstl[16] = (unsigned int  )11;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_pre_doc_date;
  sqlstm.sqhstl[17] = (unsigned int  )37;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_pre_cust_code;
  sqlstm.sqhstl[18] = (unsigned int  )11;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&l_error_yn;
  sqlstm.sqhstl[19] = (unsigned int  )12;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&l_error_msg;
  sqlstm.sqhstl[20] = (unsigned int  )302;
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


	
						
		l_error_yn.len  = strlen(l_error_yn.arr);
		l_error_msg.len = strlen(l_error_msg.arr);

		if(strcmp(l_error_yn.arr,"Y")==0)
		{
		sprintf(l_mesg,":%s",l_error_msg.arr);
		disp_message(ERR_MESG,l_mesg);
		}


	 }
	/* upto here 15/07/2008*/ 

}//end while


    
	if (rec_ctr)
    {
	  if (!err_ctr)
		{
			//disp_message(ERR_MESG,"create_bl_gl_dist_dept 2");

			 create_bl_gl_dist_dept();
			
			 create_bl_gl_dist_trx_ref();
			
			 upd_pat_chg_folio();
			 /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )227;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			 if (OERROR)
			 err_mesg("COMMIT failed",0,""); 
		}
		else
		   continue_to_next_ref();
	}

   

    end_prog_msg();
    /* EXEC SQL UPDATE BL_PARAMETERS 
	     SET    LAST_FOLIO_POST_DATE = 
				  TO_DATE(:nd_post_upto_date,'DD/MM/YYYY'),
		    MODIFIED_BY_ID         = USER,
	            MODIFIED_DATE          = SYSDATE,
		    ADDED_AT_WS_NO         = :nd_ws_no,
		    ADDED_FACILITY_ID      = :nd_operating_facility_id,
	            MODIFIED_AT_WS_NO      = :nd_ws_no,
		    MODIFIED_FACILITY_ID   = :nd_operating_facility_id
	     WHERE  NVL(LAST_FOLIO_POST_DATE,
				  TO_DATE(:nd_post_upto_date,'DD/MM/YYYY'))
			      <=  TO_DATE(:nd_post_upto_date,'DD/MM/YYYY')
 	     AND    OPERATING_FACILITY_ID = :nd_operating_facility_id ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_PARAMETERS  set LAST_FOLIO_POST_DATE=TO_DATE(:b\
0,'DD/MM/YYYY'),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b1,A\
DDED_FACILITY_ID=:b2,MODIFIED_AT_WS_NO=:b1,MODIFIED_FACILITY_ID=:b2 where (NVL\
(LAST_FOLIO_POST_DATE,TO_DATE(:b0,'DD/MM/YYYY'))<=TO_DATE(:b0,'DD/MM/YYYY') an\
d OPERATING_FACILITY_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )242;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_post_upto_date;
    sqlstm.sqhstl[0] = (unsigned int  )13;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[3] = (unsigned int  )33;
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
    sqlstm.sqhstv[5] = (         void  *)&nd_post_upto_date;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_post_upto_date;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[7] = (unsigned int  )5;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
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




    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )289;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
	 err_mesg("COMMIT WORK RELEASE failed REA",0,"");
  //  disp_message(ERR_MESG, "EXEC SQL UPDATE BL_PARAMETERS ");

    return;
}

fetch_prog_param() 
{

    nd_post_upto_date.arr[0]        = '\0';
    nd_post_upto_date.len			= 0;
	l_allow_unbilled_folio.arr[0]	= '\0';
	l_unbilled_remarks.arr[0]		= '\0';
	l_group_posting_yn.arr[0]		= '\0';
    nd_month = 0;
    nd_year  = 0;

  /* EXEC SQL SELECT PARAM1,
				  PARAM2,
				  PARAM3, 
				  PARAM4, 
				  PARAM5,
				  PARAM6
	        INTO :nd_month,
				 :nd_year,
				 :nd_post_upto_date,
				 :l_allow_unbilled_folio,
				 :l_unbilled_remarks,
				 :l_group_posting_yn
		  FROM SY_PROG_PARAM
		 WHERE OPERATING_FACILITY_ID =  :nd_operating_facility_id
		 AND   PGM_ID                = :d_curr_pgm_name
		 AND   SESSION_ID            = :nd_session_id
		 AND   PGM_DATE              = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 into \
:b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where (((OPERATING_FACILITY_ID=:b6\
 and PGM_ID=:b7) and SESSION_ID=:b8) and PGM_DATE=:b9)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )304;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_month;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_year;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_post_upto_date;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_allow_unbilled_folio;
  sqlstm.sqhstl[3] = (unsigned int  )12;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_unbilled_remarks;
  sqlstm.sqhstl[4] = (unsigned int  )57;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_group_posting_yn;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_curr_pgm_name;
  sqlstm.sqhstl[7] = (unsigned int  )17;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
  sqlstm.sqhstl[8] = (unsigned int  )18;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[9] = (unsigned int  )27;
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
	err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
	err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_post_upto_date.arr[nd_post_upto_date.len]			= '\0';
	l_allow_unbilled_folio.arr[l_allow_unbilled_folio.len]	= '\0';
	l_unbilled_remarks.arr[l_unbilled_remarks.len]			= '\0';
	l_group_posting_yn.arr[l_group_posting_yn.len]			= '\0';

   if (nd_month == 0 || nd_year == 0 )
	 err_mesg("",1,"BL9005");

    d_ip_gl_yn = '\0';
    d_op_gl_yn = '\0';
    d_rf_gl_yn = '\0';
	l_cash_ctrl_rcpt_in_use.arr[0] = '\0';

   /* EXEC SQL SELECT CURRENT_PROC_ACC_MONTH,
		   CURRENT_PROC_ACC_YEAR,
		   TO_NUMBER(TO_CHAR(SYSDATE,'MM')),
		   TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')),
		   NVL(IP_GL_REQD_YN,'N'),
		   NVL(OP_GL_REQD_YN,'N'),
		   NVL(RF_GL_REQD_YN,'N'),
		   NVL(cash_ctrl_rcpt_in_use_yn,'N')
	INTO   :bl_mth,
		   :bl_yr,
		   :cur_mth,
		   :cur_yr,
		   :d_ip_gl_yn,
		   :d_op_gl_yn,
		   :d_rf_gl_yn,
		   :l_cash_ctrl_rcpt_in_use
    FROM   BL_PARAMETERS
   WHERE   OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CURRENT_PROC_ACC_MONTH ,CURRENT_PROC_ACC_YEAR ,TO_N\
UMBER(TO_CHAR(SYSDATE,'MM')) ,TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) ,NVL(IP_GL_RE\
QD_YN,'N') ,NVL(OP_GL_REQD_YN,'N') ,NVL(RF_GL_REQD_YN,'N') ,NVL(cash_ctrl_rcpt\
_in_use_yn,'N') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from BL_PARAMETERS where\
 OPERATING_FACILITY_ID=:b8";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )359;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_mth;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bl_yr;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&cur_mth;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&cur_yr;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ip_gl_yn;
   sqlstm.sqhstl[4] = (unsigned int  )1;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_op_gl_yn;
   sqlstm.sqhstl[5] = (unsigned int  )1;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_rf_gl_yn;
   sqlstm.sqhstl[6] = (unsigned int  )1;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_cash_ctrl_rcpt_in_use;
   sqlstm.sqhstl[7] = (unsigned int  )12;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[8] = (unsigned int  )5;
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



    if(OERROR)
		err_mesg("SELECT failed on table BL_PARAMETERS",0,"");

	l_cash_ctrl_rcpt_in_use.arr[l_cash_ctrl_rcpt_in_use.len] = '\0';	
		

    if( (cur_yr > bl_yr) || (cur_yr==bl_yr && cur_mth > bl_mth) ) 
	{
		nd_month = cur_mth;
		nd_year  = cur_yr;
    }
    else 
	{
		nd_month = bl_mth;
		nd_year  = bl_yr;
    }

	/* HANDLED IN FORM BY VSK 20/01/2001 FOR BLENH PURPOSE
	EXEC SQL DELETE SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	     AND   OPERATING_FACILITY_ID = :nd_operating_facility_id
	     AND   SESSION_ID = :nd_session_id
	     AND   PGM_DATE   = :nd_pgm_date;

   if (OERROR)
	 err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");*/
   
}

cash_control_use_chec()
{
   nd_cash_control_use_flag = 'N'; 		
   
   /* EXEC SQL SELECT NVL(CASH_CTRL_RCPT_IN_USE_YN,'N') INTO :nd_cash_control_use_flag 
   FROM BL_PARAMETERS
   WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(CASH_CTRL_RCPT_IN_USE_YN,'N') into :b0  from BL\
_PARAMETERS where OPERATING_FACILITY_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )410;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_cash_control_use_flag;
   sqlstm.sqhstl[0] = (unsigned int  )1;
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



      if(OERROR) 
        err_mesg("SELECT failed on table BL_PARAMETERS",0,""); 
}


declare_cur()
{
	 //NVL(AVAILED_IND,'N') NOT IN ('Y','U','C') 'C' IS ADDED
     
     /* EXEC SQL DECLARE BL_PAT_CHG_FOLIO_CUR CURSOR FOR
	       SELECT TRX_DOC_REF,
		      TRX_DOC_REF_LINE_NUM,
		      TRX_DOC_REF_SEQ_NUM,
		      TO_CHAR(TRX_DATE,'DD/MM/YYYY'),
		      EPISODE_TYPE,
		      PATIENT_ID,
		      EPISODE_ID,
		      VISIT_ID,
		      BILLED_FLAG,
		      SETTLEMENT_IND,
		      PRT_GRP_HDR_CODE,
		      PRT_GRP_LINE_CODE,
		      PACKAGE_IND,
		      PACKAGE_SERVICE_CODE,
		      BLNG_SERV_CODE,
		      PACKAGE_TRX_IND,
		      SERV_LOCN_CODE,
		      SERV_ITEM_CODE,
		      SERV_ITEM_DESC,
		      RATE_CHARGE_FLAG,
		      BASE_QTY,
		      ROUND(BASE_RATE,6),
		      SERV_QTY,
		      ROUND(BASE_CHARGE_AMT,6),
		      (ORG_GROSS_CHARGE_AMT-NVL(ADDL_CHARGE_AMT_IN_CHARGE,0)),
		      ORG_DISC_AMT,
		      ORG_NET_CHARGE_AMT,
		      (UPD_GROSS_CHARGE_AMT-NVL(ADDL_CHARGE_AMT_IN_CHARGE,0)),
		      UPD_DISC_AMT,
		      UPD_NET_CHARGE_AMT,
		      (ADJ_GROSS_CHARGE_AMT-NVL(ADDL_CHARGE_AMT_IN_CHARGE,0)),
		      ADJ_DISC_AMT,
		      ADJ_NET_CHARGE_AMT,
		      MODULE_ID,
		      SOURCE_DOC_REF,
		      TO_CHAR(SOURCE_DOC_DATE,'DD/MM/YYYY'),
		      NVL(TO_CHAR(SERVICE_DATE,'DD/MM/YYYY'),TO_CHAR(TRX_DATE,'DD/MM/YYYY')),
		      TO_NUMBER(TO_CHAR(SERVICE_DATE,'MM')),
		      TO_NUMBER(TO_CHAR(SERVICE_DATE,'YYYY')),
		      ACCT_DEPT_CODE,
		      ORIG_DEPT_CODE,
		      NVL(PHYSICIAN_ID,'000000000000000'),
		      BLNG_GRP_ID,
		      BLNG_CLASS_CODE,
		      DAY_TYPE_CODE,
		      TIME_TYPE_CODE,
		      DISC_PERC,
		      ADDL_FACTOR_NUM,
		      NVL(BED_CLASS_CODE,'XX') BED_CLASS_CODE,
		      BILL_TYPE_CODE,
		      FOLIO_REMARKS,
		      DF_SERVICE_IND,
		      DF_UPD_FLAG,
		      DOC_TYPE_CODE,
		      DOC_NUMBER,
		      BILL_DOC_TYPE_CODE,
		      BILL_DOC_NUM,
		      TO_CHAR(BILL_DOC_DATE,'DD/MM/YYYY'),
		      TRX_FINALIZE_IND,
		      FINALIZED_BY_ID,
		      TO_CHAR(FINALIZED_DATE,'DD/MM/YYYY'),
		      TRX_POSTED_IND,
		      POSTED_BY_ID,
		      TO_CHAR(POSTED_DATE,'DD/MM/YYYY'),
		      LAST_ADJUSTED_BY_ID,
		      TO_CHAR(LAST_ADJUSTED_DATE,'DD/MM/YYYY'),
		      ADDED_BY_ID,
		      MODIFIED_BY_ID,
		      TO_CHAR(ADDED_DATE,'DD/MM/YYYY'),
		      TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY'),
		      PACKAGE_IND||PACKAGE_SERVICE_CODE||BLNG_SERV_CODE,
		      CASH_CTRL_DOC_TYPE_CODE,        
		      CASH_CTRL_DOC_NUMBER,           
		      CASH_CTRL_DOC_DATE,
		      CASH_COUNTER_CODE,
		      SHIFT_ID,
		      CUST_CODE,		      
		      ORIG_DOC_REF,                   
		      ORIG_DOC_REF_LINE_NUM,          
		      ORIG_DOC_REF_SEQ_NUM,
		      TRX_STATUS,
		      NVL(CONFIRMED_YN,'N'),
		      TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),
			  NVL(ADDL_CHARGE_AMT_IN_CHARGE,0)
		FROM BL_PAT_CHARGES_TEMP
		WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND NVL(TRX_POSTED_IND,'N') = 'N'   
		AND TRX_DATE <= TO_DATE(:nd_post_upto_date||' 23:59:59','DD/MM/YYYY HH24:MI:SS')
		/oAND NVL(CONFIRMED_YN,'N') = 'Y'o/
		AND NVL(TRX_FINALIZE_IND,'N') = 'Y' 
		AND (EPISODE_TYPE not in ('O','E') OR   
     		    (EPISODE_TYPE in ('O','E') AND NVL(AVAILED_IND,'N') NOT IN ('Y','U','C')))
		ORDER BY TRX_DOC_REF,PACKAGE_IND,
			 PACKAGE_SERVICE_CODE,
			 BLNG_SERV_CODE,
			 ACCT_DEPT_CODE; */ 
 
   
    /* EXEC SQL DECLARE BL_TYPE_BLNG_SERV_CUR CURSOR FOR
	       SELECT INCOME_ACC_INT_CODE
	       FROM BL_TYPE_FOR_BLNG_SERV A
	       WHERE BLNG_SERV_CODE = :bl_pat_blng_serv_code
	       AND BILL_TYPE_CODE = :bl_pat_bill_type_code
	       AND TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY') between 
		      NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(EFF_TO_DATE,SYSDATE)  // Effective date range is included on 01/06/2004
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 


/*	       AND ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id);*/

/* EXEC SQL DECLARE BL_TYPE_BLNG_SERV_CLSFN_CUR CURSOR FOR
	       SELECT INCOME_ACC_INT_CODE
	       FROM BL_TYPE_FOR_BLNG_SERV A
	       WHERE BLNG_SERV_CODE = (select serv_classification_code from bl_blng_serv
								   where blng_serv_code =:bl_pat_blng_serv_code)         //SUBSTR(:bl_pat_blng_serv_code,1,3)
	       AND BILL_TYPE_CODE = :bl_pat_bill_type_code
	       AND TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY') between 
		      NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(EFF_TO_DATE,SYSDATE)  // Effective date range is included on 01/06/2004
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 

		   
/*		   ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id);*/



/* EXEC SQL DECLARE BL_TYPE_BLNG_SERV_GRP_CUR CURSOR FOR
	       SELECT INCOME_ACC_INT_CODE
	       FROM BL_TYPE_FOR_BLNG_SERV A
	       WHERE BLNG_SERV_CODE = SUBSTR(:bl_pat_blng_serv_code,1,2)
	       AND BILL_TYPE_CODE = :bl_pat_bill_type_code
	       AND TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY') between 
		      NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(EFF_TO_DATE,SYSDATE)  // Effective date range is included on 01/06/2004
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 


/*	       AND ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id);*/

  /* EXEC SQL DECLARE BL_TYPE_SERV_GRP_CUR CURSOR FOR
	       SELECT DISCOUNT_ACC_INT_CODE
	       FROM BL_TYPE_FOR_SERV_GRP A
	       WHERE BLNG_GRP_ID = :bl_pat_blng_grp_id
	       AND BILL_TYPE_CODE = :bl_pat_bill_type_code
	       AND TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY') between 
		      NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(EFF_TO_DATE,SYSDATE)    // Effective date range is included ON 01/06/2004
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 

/*
	       AND ACC_ENTITY_CODE IN  (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id);*/

/* EXEC SQL DECLARE BL_TYPE_SERV_GRP_BY_PAYER_CUR CURSOR FOR
	       SELECT DISCOUNT_ACC_INT_CODE
	       FROM BL_SERV_GRP_PAYER_INT A
	       WHERE BLNG_GRP_ID = :bl_pat_blng_grp_id
	       AND BILL_TYPE_CODE = :bl_pat_bill_type_code
		   //AND BLNG_SERV_CODE = :bl_pat_blng_grp_id
		   AND BLNG_SERV_CODE = :bl_pat_blng_serv_code
		   AND CUST_CODE      = :nd_cust_code
	       AND TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY') between 
		      NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(EFF_TO_DATE,SYSDATE)    // Effective date range is included ON 01/06/2004
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 


/*	       AND ACC_ENTITY_CODE IN  (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id); */   

/* two cursor BL_TYPE_SERV_GRP_BY_PAYER_CUR1,BL_TYPE_SERV_GRP_BY_PAYER_CUR2 added on 15-02-2008*/

/* EXEC SQL DECLARE BL_TYPE_SERV_GRP_BY_PAYER_CUR1 CURSOR FOR
	       SELECT DISCOUNT_ACC_INT_CODE
	       FROM BL_SERV_GRP_PAYER_INT A
	       WHERE BLNG_GRP_ID = :bl_pat_blng_grp_id
	       AND BILL_TYPE_CODE = :bl_pat_bill_type_code
		   //AND BLNG_SERV_CODE = :bl_pat_blng_grp_id
		   AND BLNG_SERV_CODE = (select serv_classification_code from bl_blng_serv
								   where blng_serv_code =:bl_pat_blng_serv_code) //SUBSTR(:bl_pat_blng_serv_code,1,3)
		   AND CUST_CODE      = :nd_cust_code
	       AND TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY') between 
		      NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(EFF_TO_DATE,SYSDATE)    // Effective date range is included ON 01/06/2004
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 



/* EXEC SQL DECLARE BL_TYPE_SERV_GRP_BY_PAYER_CUR2 CURSOR FOR
	       SELECT DISCOUNT_ACC_INT_CODE
	       FROM BL_SERV_GRP_PAYER_INT A
	       WHERE BLNG_GRP_ID = :bl_pat_blng_grp_id
	       AND BILL_TYPE_CODE = :bl_pat_bill_type_code
		   //AND BLNG_SERV_CODE = :bl_pat_blng_grp_id
		   AND BLNG_SERV_CODE = SUBSTR(:bl_pat_blng_serv_code,1,2)
		   AND CUST_CODE      = :nd_cust_code
	       AND TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY') between 
		      NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(EFF_TO_DATE,SYSDATE)    // Effective date range is included ON 01/06/2004
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 



     /* EXEC SQL DECLARE BL_BILL_TYPE_CUR CURSOR FOR
	       SELECT BL_RECV_ACC_INT_CODE
	       FROM BL_BILL_TYPE_INT A
	       WHERE BILL_TYPE_CODE = :bl_pat_bill_type_code
	       AND TO_DATE(:bl_pat_trx_date,'DD/MM/YYYY') between 
		      NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(EFF_TO_DATE,SYSDATE)   // Effective date range is included ON 01/06/2004
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 


/*	       AND   ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id);*/

     /* EXEC SQL DECLARE BL_GL_ACCOUNT_CUR CURSOR FOR
	       SELECT MAIN_ACC1_CODE,
		      MAIN_ACC2_CODE,
		      DECODE(DEPT_CODE,'X',:store_acct_dept_code,DEPT_CODE),
		      SUBLEDGER_GROUP_CODE,
		      SUBLEDGER_LINE_CODE,
		      PRODUCT_GROUP_CODE,
		      PRODUCT_LINE_CODE
		FROM BL_GL_ACCOUNT A
		WHERE ACC_INT_CODE = :bl_acc_int_code
	       AND EXISTS (SELECT 'X' FROM SY_ACC_ENTITY B WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE); */ 



/*	        AND   ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id);*/


    /* EXEC SQL DECLARE LOCK_TRX_REF_CUR 
	       CURSOR FOR
	          SELECT 
		  /o+INDEX(BL_PATIENT_CHARGES_FOLIO BL_PATIENT_CHARGES_FOLIO_I1) USE 			
		             BL_PATIENT_CHARGES_FOLIO_I1o/ 
			     ROWID
	           FROM BL_PATIENT_CHARGES_FOLIO
	           WHERE TRX_DOC_REF			= :bl_pat_trx_doc_ref
		   AND TRX_DOC_REF_LINE_NUM		= DECODE(:l_group_posting_yn,'Y',TRX_DOC_REF_LINE_NUM,:bl_pat_trx_doc_ref_line_num)
		   AND TRX_DOC_REF_SEQ_NUM		= DECODE(:l_group_posting_yn,'Y',TRX_DOC_REF_SEQ_NUM,:bl_pat_trx_doc_ref_seq_num)
		   AND NVL(TRX_POSTED_IND,'N')	= 'N'
		   AND TRX_DATE				<= TO_DATE(:nd_post_upto_date||' 23:59:59','DD/MM/YYYY HH24:MI:SS')
		  /o AND CONFIRMED_YN			= 'Y' o/
		   AND NVL(TRX_FINALIZE_IND,'N')	= 'Y'
		   AND OPERATING_FACILITY_ID		= :nd_operating_facility_id
		   AND (EPISODE_TYPE not in ('O','E') OR 
		       (EPISODE_TYPE  in ('O','E') AND NVL(AVAILED_IND,'N') NOT IN ('Y','U','C')))
	           FOR UPDATE OF TRX_DOC_REF NOWAIT; */ 



}
open_cur()   
{
     /* EXEC SQL OPEN BL_PAT_CHG_FOLIO_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 21;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "select TRX_DOC_REF ,TRX_DOC_REF_LINE_NUM ,TRX_DOC_REF_SEQ_NUM ,TO_CH\
AR(TRX_DATE,'DD/MM/YYYY') ,EPISODE_TYPE ,PATIENT_ID ,EPISODE_ID ,VISIT_ID ,B\
ILLED_FLAG ,SETTLEMENT_IND ,PRT_GRP_HDR_CODE ,PRT_GRP_LINE_CODE ,PACKAGE_IND\
 ,PACKAGE_SERVICE_CODE ,BLNG_SERV_CODE ,PACKAGE_TRX_IND ,SERV_LOCN_CODE ,SER\
V_ITEM_CODE ,SERV_ITEM_DESC ,RATE_CHARGE_FLAG ,BASE_QTY ,ROUND(BASE_RATE,6) \
,SERV_QTY ,ROUND(BASE_CHARGE_AMT,6) ,(ORG_GROSS_CHARGE_AMT-NVL(ADDL_CHARGE_A\
MT_IN_CHARGE,0)) ,ORG_DISC_AMT ,ORG_NET_CHARGE_AMT ,(UPD_GROSS_CHARGE_AMT-NV\
L(ADDL_CHARGE_AMT_IN_CHARGE,0)) ,UPD_DISC_AMT ,UPD_NET_CHARGE_AMT ,(ADJ_GROS\
S_CHARGE_AMT-NVL(ADDL_CHARGE_AMT_IN_CHARGE,0)) ,ADJ_DISC_AMT ,ADJ_NET_CHARGE\
_AMT ,MODULE_ID ,SOURCE_DOC_REF ,TO_CHAR(SOURCE_DOC_DATE,'DD/MM/YYYY') ,NVL(\
TO_CHAR(SERVICE_DATE,'DD/MM/YYYY'),TO_CHAR(TRX_DATE,'DD/MM/YYYY')) ,TO_NUMBE\
R(TO_CHAR(SERVICE_DATE,'MM')) ,TO_NUMBER(TO_CHAR(SERVICE_DATE,'YYYY')) ,ACCT\
_DEPT_CODE ,ORIG_DEPT_CODE ,NVL(PHYSICIAN_ID,'000000000000000') ,BLNG_GRP_ID\
 ,BLNG_CLASS_CODE ,DAY_TYPE_CODE ,TIME_TYPE_");
     sqlbuft((void **)0, 
       "CODE ,DISC_PERC ,ADDL_FACTOR_NUM ,NVL(BED_CLASS_CODE,'XX') BED_CLASS\
_CODE ,BILL_TYPE_CODE ,FOLIO_REMARKS ,DF_SERVICE_IND ,DF_UPD_FLAG ,DOC_TYPE_\
CODE ,DOC_NUMBER ,BILL_DOC_TYPE_CODE ,BILL_DOC_NUM ,TO_CHAR(BILL_DOC_DATE,'D\
D/MM/YYYY') ,TRX_FINALIZE_IND ,FINALIZED_BY_ID ,TO_CHAR(FINALIZED_DATE,'DD/M\
M/YYYY') ,TRX_POSTED_IND ,POSTED_BY_ID ,TO_CHAR(POSTED_DATE,'DD/MM/YYYY') ,L\
AST_ADJUSTED_BY_ID ,TO_CHAR(LAST_ADJUSTED_DATE,'DD/MM/YYYY') ,ADDED_BY_ID ,M\
ODIFIED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/MM/YYYY') ,TO_CHAR(MODIFIED_DATE,'DD/M\
M/YYYY') ,((PACKAGE_IND||PACKAGE_SERVICE_CODE)||BLNG_SERV_CODE) ,CASH_CTRL_D\
OC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,CASH_CTRL_DOC_DATE ,CASH_COUNTER_CODE ,S\
HIFT_ID ,CUST_CODE ,ORIG_DOC_REF ,ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NU\
M ,TRX_STATUS ,NVL(CONFIRMED_YN,'N') ,TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:\
MI:SS') ,NVL(ADDL_CHARGE_AMT_IN_CHARGE,0)  from BL_PAT_CHARGES_TEMP where ((\
((OPERATING_FACILITY_ID=:b0 and NVL(TRX_POSTED_IND,'N')='N') and TRX_DATE<=T\
O_DATE((:b1||' 23:59:59'),'DD/MM/YYYY HH24:M");
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )433;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_post_upto_date;
     sqlstm.sqhstl[1] = (unsigned int  )13;
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
	 err_mesg("OPEN failed on cursor BL_PAT_CHG_FOLIO_CUR",0,"");
}

fetch_cur()
{

nd_cust_code.arr[0]												  = '\0';
bl_pat_trx_doc_ref.arr[0]                                         = '\0';
bl_pat_trx_doc_ref_line_num.arr[0]                                = '\0';
bl_pat_trx_doc_ref_seq_num.arr[0]                                 = '\0';
bl_pat_trx_date.arr[0]                                            = '\0';
bl_pat_episode_type.arr[0]                                        = '\0';
bl_pat_patient_id.arr[0]                                          = '\0';
bl_pat_episode_id.arr[0]                                          = '\0';
bl_pat_visit_id.arr[0]                                            = '\0';
bl_pat_billed_flag.arr[0]                                         = '\0';
bl_pat_settlement_ind.arr[0]                                      = '\0';
bl_pat_prt_grp_hdr_code.arr[0]                                    = '\0';
bl_pat_prt_grp_line_code.arr[0]                                   = '\0';
bl_pat_package_ind.arr[0]                                         = '\0';
bl_pat_package_service_code.arr[0]                                = '\0';
bl_pat_blng_serv_code.arr[0]                                      = '\0';
bl_pat_package_trx_ind.arr[0]                                     = '\0';
bl_pat_serv_locn_code.arr[0]                                      = '\0';
bl_pat_serv_item_code.arr[0]                                      = '\0';
bl_pat_serv_item_desc.arr[0]                                      = '\0';
bl_pat_rate_charge_flag.arr[0]                                    = '\0';
bl_pat_base_qty.arr[0]                                            = '\0';
bl_pat_base_rate.arr[0]                                           = '\0';
bl_pat_serv_qty.arr[0]                                            = '\0';
bl_pat_base_charge_amt.arr[0]                                     = '\0';
bl_pat_org_gross_charge_amt.arr[0]                                = '\0';
bl_pat_org_disc_amt.arr[0]                                        = '\0';
bl_pat_org_net_charge_amt.arr[0]                                  = '\0';
bl_pat_upd_gross_charge_amt.arr[0]                                = '\0';
bl_pat_upd_disc_amt.arr[0]                                        = '\0';
bl_pat_upd_net_charge_amt.arr[0]                                  = '\0';
bl_pat_adj_gross_charge_amt.arr[0]                                = '\0';
bl_pat_adj_disc_amt.arr[0]                                        = '\0';
bl_pat_adj_net_charge_amt.arr[0]                                  = '\0';
bl_pat_module_id.arr[0]                                           = '\0';
bl_pat_source_doc_ref.arr[0]                                      = '\0';
bl_pat_source_doc_date.arr[0]                                     = '\0';
bl_pat_service_date.arr[0]                                        = '\0';
bl_pat_service_date_time.arr[0] = '\0';
bl_pat_acct_dept_code.arr[0]                                      = '\0';
bl_pat_orig_dept_code.arr[0]                                      = '\0';
bl_pat_physician_id.arr[0]                                        = '\0';
bl_pat_blng_grp_id.arr[0]                                         = '\0';
bl_pat_blng_class_code.arr[0]                                     = '\0';
bl_pat_day_type_code.arr[0]                                       = '\0';
bl_pat_time_type_code.arr[0]                                      = '\0';
bl_pat_disc_perc.arr[0]                                           = '\0';
bl_pat_addl_factor_num.arr[0]                                     = '\0';
bl_pat_bed_class_code.arr[0]                                      = '\0';
bl_pat_bill_type_code.arr[0]                                      = '\0';
bl_pat_folio_remarks.arr[0]                                       = '\0';
bl_pat_df_service_ind.arr[0]                                      = '\0';
bl_pat_df_upd_flag.arr[0]                                         = '\0';
bl_pat_doc_type_code.arr[0]                                       = '\0';
bl_pat_doc_number.arr[0]                                          = '\0';
bl_pat_bill_doc_type_code.arr[0]                                  = '\0';
bl_pat_bill_doc_num.arr[0]                                        = '\0';
bl_pat_bill_doc_date.arr[0]                                       = '\0';
bl_pat_trx_finalize_ind.arr[0]                                    = '\0';
bl_pat_finalized_by_id.arr[0]                                     = '\0';
bl_pat_finalized_date.arr[0]                                      = '\0';
bl_pat_trx_posted_ind.arr[0]                                      = '\0';
bl_pat_posted_by_id.arr[0]                                        = '\0';
bl_pat_posted_date.arr[0]                                         = '\0';
bl_pat_last_adjusted_by_id.arr[0]                                 = '\0';
bl_pat_last_adjusted_date.arr[0]                                  = '\0';
bl_pat_added_by_id.arr[0]                                         = '\0';
bl_pat_modified_by_id.arr[0]                                      = '\0';
bl_pat_added_date.arr[0]                                          = '\0';
bl_pat_modified_date.arr[0]                                       = '\0';
bl_pat_concat_code.arr[0]                                         = '\0';
nd_cash_counter_code.arr[0]                                       = '\0';
nd_shift_id.arr[0]                                       	  = '\0';
nd_doc_type_code.arr[0]  = '\0';
nd_doc_num.arr[0]  = '\0';
nd_doc_date.arr[0]  = '\0';

nd_cash_counter_code.arr[0] = '\0';
nd_shift_id.arr[0] = '\0';
nd_cust_code.arr[0] = '\0';

nd_orig_doc_ref.arr[0] = '\0';                  
nd_trx_status.arr[0] = '\0';
nd_confirmed_yn.arr[0] = '\0';


bl_pat_trx_doc_ref.len                                            = 0;
bl_pat_trx_doc_ref_line_num.len                                   = 0;
bl_pat_trx_doc_ref_seq_num.len                                    = 0;
bl_pat_trx_date.len                                               = 0;
bl_pat_episode_type.len                                           = 0;
bl_pat_patient_id.len                                             = 0;
bl_pat_episode_id.len                                             = 0;
bl_pat_visit_id.len                                               = 0;
bl_pat_billed_flag.len                                            = 0;
bl_pat_settlement_ind.len                                         = 0;
bl_pat_prt_grp_hdr_code.len                                       = 0;
bl_pat_prt_grp_line_code.len                                      = 0;
bl_pat_package_ind.len                                            = 0;
bl_pat_package_service_code.len                                   = 0;
bl_pat_blng_serv_code.len                                         = 0;
bl_pat_package_trx_ind.len                                        = 0;
bl_pat_serv_locn_code.len                                         = 0;
bl_pat_serv_item_code.len                                         = 0;
bl_pat_serv_item_desc.len                                         = 0;
bl_pat_rate_charge_flag.len                                       = 0;
bl_pat_base_qty.len                                               = 0;
bl_pat_base_rate.len                                              = 0;
bl_pat_serv_qty.len                                               = 0;
bl_pat_base_charge_amt.len                                        = 0;
bl_pat_org_gross_charge_amt.len                                   = 0;
bl_pat_org_disc_amt.len                                           = 0;
bl_pat_org_net_charge_amt.len                                     = 0;
bl_pat_upd_gross_charge_amt.len                                   = 0;
bl_pat_upd_disc_amt.len                                           = 0;
bl_pat_upd_net_charge_amt.len                                     = 0;
bl_pat_adj_gross_charge_amt.len                                   = 0;
bl_pat_adj_disc_amt.len                                           = 0;
bl_pat_adj_net_charge_amt.len                                     = 0;
bl_pat_module_id.len                                              = 0;
bl_pat_source_doc_ref.len                                         = 0;
bl_pat_source_doc_date.len                                        = 0;
bl_pat_service_date.len                                           = 0;
bl_pat_service_date_time.len = 0;
bl_pat_acct_dept_code.len                                         = 0;
bl_pat_orig_dept_code.len                                         = 0;
bl_pat_physician_id.len                                           = 0;
bl_pat_blng_grp_id.len                                            = 0;
bl_pat_blng_class_code.len                                        = 0;
bl_pat_day_type_code.len                                          = 0;
bl_pat_time_type_code.len                                         = 0;
bl_pat_disc_perc.len                                              = 0;
bl_pat_addl_factor_num.len                                        = 0;
bl_pat_bed_class_code.len                                         = 0;
bl_pat_bill_type_code.len                                         = 0;
bl_pat_folio_remarks.len                                          = 0;
bl_pat_df_service_ind.len                                         = 0;
bl_pat_df_upd_flag.len                                            = 0;
bl_pat_doc_type_code.len                                          = 0;
bl_pat_doc_number.len                                             = 0;
bl_pat_bill_doc_type_code.len                                     = 0;
bl_pat_bill_doc_num.len                                           = 0;
bl_pat_bill_doc_date.len                                          = 0;
bl_pat_trx_finalize_ind.len                                       = 0;
bl_pat_finalized_by_id.len                                        = 0;
bl_pat_finalized_date.len                                         = 0;
bl_pat_trx_posted_ind.len                                         = 0;
bl_pat_posted_by_id.len                                           = 0;
bl_pat_posted_date.len                                            = 0;
bl_pat_last_adjusted_by_id.len                                    = 0;
bl_pat_last_adjusted_date.len                                     = 0;
bl_pat_added_by_id.len                                            = 0;
bl_pat_modified_by_id.len                                         = 0;
bl_pat_added_date.len                                             = 0;
bl_pat_modified_date.len                                          = 0;
bl_pat_concat_code.len                                            = 0;

nd_orig_doc_ref.len						  =0;                  
nd_orig_doc_ref_line_num = 0;          
nd_orig_doc_ref_seq_num = 0;
nd_trx_status.len = 0;
nd_confirmed_yn.len = 0;

nd_doc_type_code.len			                          = 0;
nd_doc_num.len			                                  = 0;
nd_doc_date.len		                                          = 0;
nd_cash_counter_code.len = 0;
nd_shift_id.len = 0;
nd_cust_code.len = 0;


     /* EXEC SQL FETCH BL_PAT_CHG_FOLIO_CUR
	       INTO :bl_pat_trx_doc_ref,
		    :bl_pat_trx_doc_ref_line_num,
		    :bl_pat_trx_doc_ref_seq_num,
		    :bl_pat_trx_date,
		    :bl_pat_episode_type,
		    :bl_pat_patient_id,
		    :bl_pat_episode_id,
		    :bl_pat_visit_id,
		    :bl_pat_billed_flag,
		    :bl_pat_settlement_ind,
		    :bl_pat_prt_grp_hdr_code,
		    :bl_pat_prt_grp_line_code,
		    :bl_pat_package_ind,
		    :bl_pat_package_service_code,
		    :bl_pat_blng_serv_code,
		    :bl_pat_package_trx_ind,
		    :bl_pat_serv_locn_code,
		    :bl_pat_serv_item_code,
		    :bl_pat_serv_item_desc,
		    :bl_pat_rate_charge_flag,
		    :bl_pat_base_qty,
		    :bl_pat_base_rate,
		    :bl_pat_serv_qty,
		    :bl_pat_base_charge_amt,
		    :bl_pat_org_gross_charge_amt,
		    :bl_pat_org_disc_amt,
		    :bl_pat_org_net_charge_amt,
		    :bl_pat_upd_gross_charge_amt,
		    :bl_pat_upd_disc_amt,
		    :bl_pat_upd_net_charge_amt,
		    :bl_pat_adj_gross_charge_amt,
		    :bl_pat_adj_disc_amt,
		    :bl_pat_adj_net_charge_amt,
		    :bl_pat_module_id,
		    :bl_pat_source_doc_ref,
		    :bl_pat_source_doc_date,
		    :bl_pat_service_date,
		    :bl_pat_serv_mth,
		    :bl_pat_serv_yr,
		    :bl_pat_acct_dept_code,
		    :bl_pat_orig_dept_code,
		    :bl_pat_physician_id,
		    :bl_pat_blng_grp_id,
		    :bl_pat_blng_class_code,
		    :bl_pat_day_type_code,
		    :bl_pat_time_type_code,
		    :bl_pat_disc_perc,
		    :bl_pat_addl_factor_num,
		    :bl_pat_bed_class_code,
		    :bl_pat_bill_type_code,
		    :bl_pat_folio_remarks,
		    :bl_pat_df_service_ind,
		    :bl_pat_df_upd_flag,
		    :bl_pat_doc_type_code,
		    :bl_pat_doc_number,
		    :bl_pat_bill_doc_type_code,
		    :bl_pat_bill_doc_num,
		    :bl_pat_bill_doc_date,
		    :bl_pat_trx_finalize_ind,
		    :bl_pat_finalized_by_id,
		    :bl_pat_finalized_date,
		    :bl_pat_trx_posted_ind,
		    :bl_pat_posted_by_id,
		    :bl_pat_posted_date,
		    :bl_pat_last_adjusted_by_id,
		    :bl_pat_last_adjusted_date,
		    :bl_pat_added_by_id,
		    :bl_pat_modified_by_id,
		    :bl_pat_added_date,
		    :bl_pat_modified_date,
		    :bl_pat_concat_code,
		    :nd_doc_type_code,
		    :nd_doc_num,
		    :nd_doc_date,
		    :nd_cash_counter_code,
		    :nd_shift_id,
		    :nd_cust_code,
		    :nd_orig_doc_ref,                  
		    :nd_orig_doc_ref_line_num,          
		    :nd_orig_doc_ref_seq_num,
		    :nd_trx_status,
		    :nd_confirmed_yn,
		    :bl_pat_service_date_time,
			:bl_addl_charge_amt_in_charge; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )456;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_trx_doc_ref;
     sqlstm.sqhstl[0] = (unsigned int  )23;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_trx_doc_ref_line_num;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_doc_ref_seq_num;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[3] = (unsigned int  )15;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_episode_type;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_pat_patient_id;
     sqlstm.sqhstl[5] = (unsigned int  )23;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_pat_episode_id;
     sqlstm.sqhstl[6] = (unsigned int  )11;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_pat_visit_id;
     sqlstm.sqhstl[7] = (unsigned int  )7;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_pat_billed_flag;
     sqlstm.sqhstl[8] = (unsigned int  )4;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_pat_settlement_ind;
     sqlstm.sqhstl[9] = (unsigned int  )4;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_pat_prt_grp_hdr_code;
     sqlstm.sqhstl[10] = (unsigned int  )8;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_pat_prt_grp_line_code;
     sqlstm.sqhstl[11] = (unsigned int  )6;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_pat_package_ind;
     sqlstm.sqhstl[12] = (unsigned int  )4;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_pat_package_service_code;
     sqlstm.sqhstl[13] = (unsigned int  )13;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_pat_blng_serv_code;
     sqlstm.sqhstl[14] = (unsigned int  )13;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_pat_package_trx_ind;
     sqlstm.sqhstl[15] = (unsigned int  )4;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_pat_serv_locn_code;
     sqlstm.sqhstl[16] = (unsigned int  )7;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_pat_serv_item_code;
     sqlstm.sqhstl[17] = (unsigned int  )23;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_pat_serv_item_desc;
     sqlstm.sqhstl[18] = (unsigned int  )43;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_pat_rate_charge_flag;
     sqlstm.sqhstl[19] = (unsigned int  )4;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_pat_base_qty;
     sqlstm.sqhstl[20] = (unsigned int  )25;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_pat_base_rate;
     sqlstm.sqhstl[21] = (unsigned int  )25;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_pat_serv_qty;
     sqlstm.sqhstl[22] = (unsigned int  )25;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_pat_base_charge_amt;
     sqlstm.sqhstl[23] = (unsigned int  )25;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_pat_org_gross_charge_amt;
     sqlstm.sqhstl[24] = (unsigned int  )25;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&bl_pat_org_disc_amt;
     sqlstm.sqhstl[25] = (unsigned int  )25;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&bl_pat_org_net_charge_amt;
     sqlstm.sqhstl[26] = (unsigned int  )25;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&bl_pat_upd_gross_charge_amt;
     sqlstm.sqhstl[27] = (unsigned int  )25;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&bl_pat_upd_disc_amt;
     sqlstm.sqhstl[28] = (unsigned int  )25;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&bl_pat_upd_net_charge_amt;
     sqlstm.sqhstl[29] = (unsigned int  )25;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&bl_pat_adj_gross_charge_amt;
     sqlstm.sqhstl[30] = (unsigned int  )25;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&bl_pat_adj_disc_amt;
     sqlstm.sqhstl[31] = (unsigned int  )25;
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&bl_pat_adj_net_charge_amt;
     sqlstm.sqhstl[32] = (unsigned int  )25;
     sqlstm.sqhsts[32] = (         int  )0;
     sqlstm.sqindv[32] = (         void  *)0;
     sqlstm.sqinds[32] = (         int  )0;
     sqlstm.sqharm[32] = (unsigned int  )0;
     sqlstm.sqadto[32] = (unsigned short )0;
     sqlstm.sqtdso[32] = (unsigned short )0;
     sqlstm.sqhstv[33] = (         void  *)&bl_pat_module_id;
     sqlstm.sqhstl[33] = (unsigned int  )5;
     sqlstm.sqhsts[33] = (         int  )0;
     sqlstm.sqindv[33] = (         void  *)0;
     sqlstm.sqinds[33] = (         int  )0;
     sqlstm.sqharm[33] = (unsigned int  )0;
     sqlstm.sqadto[33] = (unsigned short )0;
     sqlstm.sqtdso[33] = (unsigned short )0;
     sqlstm.sqhstv[34] = (         void  *)&bl_pat_source_doc_ref;
     sqlstm.sqhstl[34] = (unsigned int  )23;
     sqlstm.sqhsts[34] = (         int  )0;
     sqlstm.sqindv[34] = (         void  *)0;
     sqlstm.sqinds[34] = (         int  )0;
     sqlstm.sqharm[34] = (unsigned int  )0;
     sqlstm.sqadto[34] = (unsigned short )0;
     sqlstm.sqtdso[34] = (unsigned short )0;
     sqlstm.sqhstv[35] = (         void  *)&bl_pat_source_doc_date;
     sqlstm.sqhstl[35] = (unsigned int  )15;
     sqlstm.sqhsts[35] = (         int  )0;
     sqlstm.sqindv[35] = (         void  *)0;
     sqlstm.sqinds[35] = (         int  )0;
     sqlstm.sqharm[35] = (unsigned int  )0;
     sqlstm.sqadto[35] = (unsigned short )0;
     sqlstm.sqtdso[35] = (unsigned short )0;
     sqlstm.sqhstv[36] = (         void  *)&bl_pat_service_date;
     sqlstm.sqhstl[36] = (unsigned int  )15;
     sqlstm.sqhsts[36] = (         int  )0;
     sqlstm.sqindv[36] = (         void  *)0;
     sqlstm.sqinds[36] = (         int  )0;
     sqlstm.sqharm[36] = (unsigned int  )0;
     sqlstm.sqadto[36] = (unsigned short )0;
     sqlstm.sqtdso[36] = (unsigned short )0;
     sqlstm.sqhstv[37] = (         void  *)&bl_pat_serv_mth;
     sqlstm.sqhstl[37] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[37] = (         int  )0;
     sqlstm.sqindv[37] = (         void  *)0;
     sqlstm.sqinds[37] = (         int  )0;
     sqlstm.sqharm[37] = (unsigned int  )0;
     sqlstm.sqadto[37] = (unsigned short )0;
     sqlstm.sqtdso[37] = (unsigned short )0;
     sqlstm.sqhstv[38] = (         void  *)&bl_pat_serv_yr;
     sqlstm.sqhstl[38] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[38] = (         int  )0;
     sqlstm.sqindv[38] = (         void  *)0;
     sqlstm.sqinds[38] = (         int  )0;
     sqlstm.sqharm[38] = (unsigned int  )0;
     sqlstm.sqadto[38] = (unsigned short )0;
     sqlstm.sqtdso[38] = (unsigned short )0;
     sqlstm.sqhstv[39] = (         void  *)&bl_pat_acct_dept_code;
     sqlstm.sqhstl[39] = (unsigned int  )13;
     sqlstm.sqhsts[39] = (         int  )0;
     sqlstm.sqindv[39] = (         void  *)0;
     sqlstm.sqinds[39] = (         int  )0;
     sqlstm.sqharm[39] = (unsigned int  )0;
     sqlstm.sqadto[39] = (unsigned short )0;
     sqlstm.sqtdso[39] = (unsigned short )0;
     sqlstm.sqhstv[40] = (         void  *)&bl_pat_orig_dept_code;
     sqlstm.sqhstl[40] = (unsigned int  )13;
     sqlstm.sqhsts[40] = (         int  )0;
     sqlstm.sqindv[40] = (         void  *)0;
     sqlstm.sqinds[40] = (         int  )0;
     sqlstm.sqharm[40] = (unsigned int  )0;
     sqlstm.sqadto[40] = (unsigned short )0;
     sqlstm.sqtdso[40] = (unsigned short )0;
     sqlstm.sqhstv[41] = (         void  *)&bl_pat_physician_id;
     sqlstm.sqhstl[41] = (unsigned int  )18;
     sqlstm.sqhsts[41] = (         int  )0;
     sqlstm.sqindv[41] = (         void  *)0;
     sqlstm.sqinds[41] = (         int  )0;
     sqlstm.sqharm[41] = (unsigned int  )0;
     sqlstm.sqadto[41] = (unsigned short )0;
     sqlstm.sqtdso[41] = (unsigned short )0;
     sqlstm.sqhstv[42] = (         void  *)&bl_pat_blng_grp_id;
     sqlstm.sqhstl[42] = (unsigned int  )7;
     sqlstm.sqhsts[42] = (         int  )0;
     sqlstm.sqindv[42] = (         void  *)0;
     sqlstm.sqinds[42] = (         int  )0;
     sqlstm.sqharm[42] = (unsigned int  )0;
     sqlstm.sqadto[42] = (unsigned short )0;
     sqlstm.sqtdso[42] = (unsigned short )0;
     sqlstm.sqhstv[43] = (         void  *)&bl_pat_blng_class_code;
     sqlstm.sqhstl[43] = (unsigned int  )5;
     sqlstm.sqhsts[43] = (         int  )0;
     sqlstm.sqindv[43] = (         void  *)0;
     sqlstm.sqinds[43] = (         int  )0;
     sqlstm.sqharm[43] = (unsigned int  )0;
     sqlstm.sqadto[43] = (unsigned short )0;
     sqlstm.sqtdso[43] = (unsigned short )0;
     sqlstm.sqhstv[44] = (         void  *)&bl_pat_day_type_code;
     sqlstm.sqhstl[44] = (unsigned int  )5;
     sqlstm.sqhsts[44] = (         int  )0;
     sqlstm.sqindv[44] = (         void  *)0;
     sqlstm.sqinds[44] = (         int  )0;
     sqlstm.sqharm[44] = (unsigned int  )0;
     sqlstm.sqadto[44] = (unsigned short )0;
     sqlstm.sqtdso[44] = (unsigned short )0;
     sqlstm.sqhstv[45] = (         void  *)&bl_pat_time_type_code;
     sqlstm.sqhstl[45] = (unsigned int  )5;
     sqlstm.sqhsts[45] = (         int  )0;
     sqlstm.sqindv[45] = (         void  *)0;
     sqlstm.sqinds[45] = (         int  )0;
     sqlstm.sqharm[45] = (unsigned int  )0;
     sqlstm.sqadto[45] = (unsigned short )0;
     sqlstm.sqtdso[45] = (unsigned short )0;
     sqlstm.sqhstv[46] = (         void  *)&bl_pat_disc_perc;
     sqlstm.sqhstl[46] = (unsigned int  )8;
     sqlstm.sqhsts[46] = (         int  )0;
     sqlstm.sqindv[46] = (         void  *)0;
     sqlstm.sqinds[46] = (         int  )0;
     sqlstm.sqharm[46] = (unsigned int  )0;
     sqlstm.sqadto[46] = (unsigned short )0;
     sqlstm.sqtdso[46] = (unsigned short )0;
     sqlstm.sqhstv[47] = (         void  *)&bl_pat_addl_factor_num;
     sqlstm.sqhstl[47] = (unsigned int  )8;
     sqlstm.sqhsts[47] = (         int  )0;
     sqlstm.sqindv[47] = (         void  *)0;
     sqlstm.sqinds[47] = (         int  )0;
     sqlstm.sqharm[47] = (unsigned int  )0;
     sqlstm.sqadto[47] = (unsigned short )0;
     sqlstm.sqtdso[47] = (unsigned short )0;
     sqlstm.sqhstv[48] = (         void  *)&bl_pat_bed_class_code;
     sqlstm.sqhstl[48] = (unsigned int  )5;
     sqlstm.sqhsts[48] = (         int  )0;
     sqlstm.sqindv[48] = (         void  *)0;
     sqlstm.sqinds[48] = (         int  )0;
     sqlstm.sqharm[48] = (unsigned int  )0;
     sqlstm.sqadto[48] = (unsigned short )0;
     sqlstm.sqtdso[48] = (unsigned short )0;
     sqlstm.sqhstv[49] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[49] = (unsigned int  )5;
     sqlstm.sqhsts[49] = (         int  )0;
     sqlstm.sqindv[49] = (         void  *)0;
     sqlstm.sqinds[49] = (         int  )0;
     sqlstm.sqharm[49] = (unsigned int  )0;
     sqlstm.sqadto[49] = (unsigned short )0;
     sqlstm.sqtdso[49] = (unsigned short )0;
     sqlstm.sqhstv[50] = (         void  *)&bl_pat_folio_remarks;
     sqlstm.sqhstl[50] = (unsigned int  )53;
     sqlstm.sqhsts[50] = (         int  )0;
     sqlstm.sqindv[50] = (         void  *)0;
     sqlstm.sqinds[50] = (         int  )0;
     sqlstm.sqharm[50] = (unsigned int  )0;
     sqlstm.sqadto[50] = (unsigned short )0;
     sqlstm.sqtdso[50] = (unsigned short )0;
     sqlstm.sqhstv[51] = (         void  *)&bl_pat_df_service_ind;
     sqlstm.sqhstl[51] = (unsigned int  )4;
     sqlstm.sqhsts[51] = (         int  )0;
     sqlstm.sqindv[51] = (         void  *)0;
     sqlstm.sqinds[51] = (         int  )0;
     sqlstm.sqharm[51] = (unsigned int  )0;
     sqlstm.sqadto[51] = (unsigned short )0;
     sqlstm.sqtdso[51] = (unsigned short )0;
     sqlstm.sqhstv[52] = (         void  *)&bl_pat_df_upd_flag;
     sqlstm.sqhstl[52] = (unsigned int  )4;
     sqlstm.sqhsts[52] = (         int  )0;
     sqlstm.sqindv[52] = (         void  *)0;
     sqlstm.sqinds[52] = (         int  )0;
     sqlstm.sqharm[52] = (unsigned int  )0;
     sqlstm.sqadto[52] = (unsigned short )0;
     sqlstm.sqtdso[52] = (unsigned short )0;
     sqlstm.sqhstv[53] = (         void  *)&bl_pat_doc_type_code;
     sqlstm.sqhstl[53] = (unsigned int  )9;
     sqlstm.sqhsts[53] = (         int  )0;
     sqlstm.sqindv[53] = (         void  *)0;
     sqlstm.sqinds[53] = (         int  )0;
     sqlstm.sqharm[53] = (unsigned int  )0;
     sqlstm.sqadto[53] = (unsigned short )0;
     sqlstm.sqtdso[53] = (unsigned short )0;
     sqlstm.sqhstv[54] = (         void  *)&bl_pat_doc_number;
     sqlstm.sqhstl[54] = (unsigned int  )25;
     sqlstm.sqhsts[54] = (         int  )0;
     sqlstm.sqindv[54] = (         void  *)0;
     sqlstm.sqinds[54] = (         int  )0;
     sqlstm.sqharm[54] = (unsigned int  )0;
     sqlstm.sqadto[54] = (unsigned short )0;
     sqlstm.sqtdso[54] = (unsigned short )0;
     sqlstm.sqhstv[55] = (         void  *)&bl_pat_bill_doc_type_code;
     sqlstm.sqhstl[55] = (unsigned int  )9;
     sqlstm.sqhsts[55] = (         int  )0;
     sqlstm.sqindv[55] = (         void  *)0;
     sqlstm.sqinds[55] = (         int  )0;
     sqlstm.sqharm[55] = (unsigned int  )0;
     sqlstm.sqadto[55] = (unsigned short )0;
     sqlstm.sqtdso[55] = (unsigned short )0;
     sqlstm.sqhstv[56] = (         void  *)&bl_pat_bill_doc_num;
     sqlstm.sqhstl[56] = (unsigned int  )11;
     sqlstm.sqhsts[56] = (         int  )0;
     sqlstm.sqindv[56] = (         void  *)0;
     sqlstm.sqinds[56] = (         int  )0;
     sqlstm.sqharm[56] = (unsigned int  )0;
     sqlstm.sqadto[56] = (unsigned short )0;
     sqlstm.sqtdso[56] = (unsigned short )0;
     sqlstm.sqhstv[57] = (         void  *)&bl_pat_bill_doc_date;
     sqlstm.sqhstl[57] = (unsigned int  )15;
     sqlstm.sqhsts[57] = (         int  )0;
     sqlstm.sqindv[57] = (         void  *)0;
     sqlstm.sqinds[57] = (         int  )0;
     sqlstm.sqharm[57] = (unsigned int  )0;
     sqlstm.sqadto[57] = (unsigned short )0;
     sqlstm.sqtdso[57] = (unsigned short )0;
     sqlstm.sqhstv[58] = (         void  *)&bl_pat_trx_finalize_ind;
     sqlstm.sqhstl[58] = (unsigned int  )4;
     sqlstm.sqhsts[58] = (         int  )0;
     sqlstm.sqindv[58] = (         void  *)0;
     sqlstm.sqinds[58] = (         int  )0;
     sqlstm.sqharm[58] = (unsigned int  )0;
     sqlstm.sqadto[58] = (unsigned short )0;
     sqlstm.sqtdso[58] = (unsigned short )0;
     sqlstm.sqhstv[59] = (         void  *)&bl_pat_finalized_by_id;
     sqlstm.sqhstl[59] = (unsigned int  )23;
     sqlstm.sqhsts[59] = (         int  )0;
     sqlstm.sqindv[59] = (         void  *)0;
     sqlstm.sqinds[59] = (         int  )0;
     sqlstm.sqharm[59] = (unsigned int  )0;
     sqlstm.sqadto[59] = (unsigned short )0;
     sqlstm.sqtdso[59] = (unsigned short )0;
     sqlstm.sqhstv[60] = (         void  *)&bl_pat_finalized_date;
     sqlstm.sqhstl[60] = (unsigned int  )15;
     sqlstm.sqhsts[60] = (         int  )0;
     sqlstm.sqindv[60] = (         void  *)0;
     sqlstm.sqinds[60] = (         int  )0;
     sqlstm.sqharm[60] = (unsigned int  )0;
     sqlstm.sqadto[60] = (unsigned short )0;
     sqlstm.sqtdso[60] = (unsigned short )0;
     sqlstm.sqhstv[61] = (         void  *)&bl_pat_trx_posted_ind;
     sqlstm.sqhstl[61] = (unsigned int  )4;
     sqlstm.sqhsts[61] = (         int  )0;
     sqlstm.sqindv[61] = (         void  *)0;
     sqlstm.sqinds[61] = (         int  )0;
     sqlstm.sqharm[61] = (unsigned int  )0;
     sqlstm.sqadto[61] = (unsigned short )0;
     sqlstm.sqtdso[61] = (unsigned short )0;
     sqlstm.sqhstv[62] = (         void  *)&bl_pat_posted_by_id;
     sqlstm.sqhstl[62] = (unsigned int  )23;
     sqlstm.sqhsts[62] = (         int  )0;
     sqlstm.sqindv[62] = (         void  *)0;
     sqlstm.sqinds[62] = (         int  )0;
     sqlstm.sqharm[62] = (unsigned int  )0;
     sqlstm.sqadto[62] = (unsigned short )0;
     sqlstm.sqtdso[62] = (unsigned short )0;
     sqlstm.sqhstv[63] = (         void  *)&bl_pat_posted_date;
     sqlstm.sqhstl[63] = (unsigned int  )15;
     sqlstm.sqhsts[63] = (         int  )0;
     sqlstm.sqindv[63] = (         void  *)0;
     sqlstm.sqinds[63] = (         int  )0;
     sqlstm.sqharm[63] = (unsigned int  )0;
     sqlstm.sqadto[63] = (unsigned short )0;
     sqlstm.sqtdso[63] = (unsigned short )0;
     sqlstm.sqhstv[64] = (         void  *)&bl_pat_last_adjusted_by_id;
     sqlstm.sqhstl[64] = (unsigned int  )23;
     sqlstm.sqhsts[64] = (         int  )0;
     sqlstm.sqindv[64] = (         void  *)0;
     sqlstm.sqinds[64] = (         int  )0;
     sqlstm.sqharm[64] = (unsigned int  )0;
     sqlstm.sqadto[64] = (unsigned short )0;
     sqlstm.sqtdso[64] = (unsigned short )0;
     sqlstm.sqhstv[65] = (         void  *)&bl_pat_last_adjusted_date;
     sqlstm.sqhstl[65] = (unsigned int  )15;
     sqlstm.sqhsts[65] = (         int  )0;
     sqlstm.sqindv[65] = (         void  *)0;
     sqlstm.sqinds[65] = (         int  )0;
     sqlstm.sqharm[65] = (unsigned int  )0;
     sqlstm.sqadto[65] = (unsigned short )0;
     sqlstm.sqtdso[65] = (unsigned short )0;
     sqlstm.sqhstv[66] = (         void  *)&bl_pat_added_by_id;
     sqlstm.sqhstl[66] = (unsigned int  )23;
     sqlstm.sqhsts[66] = (         int  )0;
     sqlstm.sqindv[66] = (         void  *)0;
     sqlstm.sqinds[66] = (         int  )0;
     sqlstm.sqharm[66] = (unsigned int  )0;
     sqlstm.sqadto[66] = (unsigned short )0;
     sqlstm.sqtdso[66] = (unsigned short )0;
     sqlstm.sqhstv[67] = (         void  *)&bl_pat_modified_by_id;
     sqlstm.sqhstl[67] = (unsigned int  )23;
     sqlstm.sqhsts[67] = (         int  )0;
     sqlstm.sqindv[67] = (         void  *)0;
     sqlstm.sqinds[67] = (         int  )0;
     sqlstm.sqharm[67] = (unsigned int  )0;
     sqlstm.sqadto[67] = (unsigned short )0;
     sqlstm.sqtdso[67] = (unsigned short )0;
     sqlstm.sqhstv[68] = (         void  *)&bl_pat_added_date;
     sqlstm.sqhstl[68] = (unsigned int  )15;
     sqlstm.sqhsts[68] = (         int  )0;
     sqlstm.sqindv[68] = (         void  *)0;
     sqlstm.sqinds[68] = (         int  )0;
     sqlstm.sqharm[68] = (unsigned int  )0;
     sqlstm.sqadto[68] = (unsigned short )0;
     sqlstm.sqtdso[68] = (unsigned short )0;
     sqlstm.sqhstv[69] = (         void  *)&bl_pat_modified_date;
     sqlstm.sqhstl[69] = (unsigned int  )15;
     sqlstm.sqhsts[69] = (         int  )0;
     sqlstm.sqindv[69] = (         void  *)0;
     sqlstm.sqinds[69] = (         int  )0;
     sqlstm.sqharm[69] = (unsigned int  )0;
     sqlstm.sqadto[69] = (unsigned short )0;
     sqlstm.sqtdso[69] = (unsigned short )0;
     sqlstm.sqhstv[70] = (         void  *)&bl_pat_concat_code;
     sqlstm.sqhstl[70] = (unsigned int  )18;
     sqlstm.sqhsts[70] = (         int  )0;
     sqlstm.sqindv[70] = (         void  *)0;
     sqlstm.sqinds[70] = (         int  )0;
     sqlstm.sqharm[70] = (unsigned int  )0;
     sqlstm.sqadto[70] = (unsigned short )0;
     sqlstm.sqtdso[70] = (unsigned short )0;
     sqlstm.sqhstv[71] = (         void  *)&nd_doc_type_code;
     sqlstm.sqhstl[71] = (unsigned int  )9;
     sqlstm.sqhsts[71] = (         int  )0;
     sqlstm.sqindv[71] = (         void  *)0;
     sqlstm.sqinds[71] = (         int  )0;
     sqlstm.sqharm[71] = (unsigned int  )0;
     sqlstm.sqadto[71] = (unsigned short )0;
     sqlstm.sqtdso[71] = (unsigned short )0;
     sqlstm.sqhstv[72] = (         void  *)&nd_doc_num;
     sqlstm.sqhstl[72] = (unsigned int  )11;
     sqlstm.sqhsts[72] = (         int  )0;
     sqlstm.sqindv[72] = (         void  *)0;
     sqlstm.sqinds[72] = (         int  )0;
     sqlstm.sqharm[72] = (unsigned int  )0;
     sqlstm.sqadto[72] = (unsigned short )0;
     sqlstm.sqtdso[72] = (unsigned short )0;
     sqlstm.sqhstv[73] = (         void  *)&nd_doc_date;
     sqlstm.sqhstl[73] = (unsigned int  )37;
     sqlstm.sqhsts[73] = (         int  )0;
     sqlstm.sqindv[73] = (         void  *)0;
     sqlstm.sqinds[73] = (         int  )0;
     sqlstm.sqharm[73] = (unsigned int  )0;
     sqlstm.sqadto[73] = (unsigned short )0;
     sqlstm.sqtdso[73] = (unsigned short )0;
     sqlstm.sqhstv[74] = (         void  *)&nd_cash_counter_code;
     sqlstm.sqhstl[74] = (unsigned int  )9;
     sqlstm.sqhsts[74] = (         int  )0;
     sqlstm.sqindv[74] = (         void  *)0;
     sqlstm.sqinds[74] = (         int  )0;
     sqlstm.sqharm[74] = (unsigned int  )0;
     sqlstm.sqadto[74] = (unsigned short )0;
     sqlstm.sqtdso[74] = (unsigned short )0;
     sqlstm.sqhstv[75] = (         void  *)&nd_shift_id;
     sqlstm.sqhstl[75] = (unsigned int  )4;
     sqlstm.sqhsts[75] = (         int  )0;
     sqlstm.sqindv[75] = (         void  *)0;
     sqlstm.sqinds[75] = (         int  )0;
     sqlstm.sqharm[75] = (unsigned int  )0;
     sqlstm.sqadto[75] = (unsigned short )0;
     sqlstm.sqtdso[75] = (unsigned short )0;
     sqlstm.sqhstv[76] = (         void  *)&nd_cust_code;
     sqlstm.sqhstl[76] = (unsigned int  )11;
     sqlstm.sqhsts[76] = (         int  )0;
     sqlstm.sqindv[76] = (         void  *)0;
     sqlstm.sqinds[76] = (         int  )0;
     sqlstm.sqharm[76] = (unsigned int  )0;
     sqlstm.sqadto[76] = (unsigned short )0;
     sqlstm.sqtdso[76] = (unsigned short )0;
     sqlstm.sqhstv[77] = (         void  *)&nd_orig_doc_ref;
     sqlstm.sqhstl[77] = (unsigned int  )32;
     sqlstm.sqhsts[77] = (         int  )0;
     sqlstm.sqindv[77] = (         void  *)0;
     sqlstm.sqinds[77] = (         int  )0;
     sqlstm.sqharm[77] = (unsigned int  )0;
     sqlstm.sqadto[77] = (unsigned short )0;
     sqlstm.sqtdso[77] = (unsigned short )0;
     sqlstm.sqhstv[78] = (         void  *)&nd_orig_doc_ref_line_num;
     sqlstm.sqhstl[78] = (unsigned int  )sizeof(long);
     sqlstm.sqhsts[78] = (         int  )0;
     sqlstm.sqindv[78] = (         void  *)0;
     sqlstm.sqinds[78] = (         int  )0;
     sqlstm.sqharm[78] = (unsigned int  )0;
     sqlstm.sqadto[78] = (unsigned short )0;
     sqlstm.sqtdso[78] = (unsigned short )0;
     sqlstm.sqhstv[79] = (         void  *)&nd_orig_doc_ref_seq_num;
     sqlstm.sqhstl[79] = (unsigned int  )sizeof(long);
     sqlstm.sqhsts[79] = (         int  )0;
     sqlstm.sqindv[79] = (         void  *)0;
     sqlstm.sqinds[79] = (         int  )0;
     sqlstm.sqharm[79] = (unsigned int  )0;
     sqlstm.sqadto[79] = (unsigned short )0;
     sqlstm.sqtdso[79] = (unsigned short )0;
     sqlstm.sqhstv[80] = (         void  *)&nd_trx_status;
     sqlstm.sqhstl[80] = (unsigned int  )4;
     sqlstm.sqhsts[80] = (         int  )0;
     sqlstm.sqindv[80] = (         void  *)0;
     sqlstm.sqinds[80] = (         int  )0;
     sqlstm.sqharm[80] = (unsigned int  )0;
     sqlstm.sqadto[80] = (unsigned short )0;
     sqlstm.sqtdso[80] = (unsigned short )0;
     sqlstm.sqhstv[81] = (         void  *)&nd_confirmed_yn;
     sqlstm.sqhstl[81] = (unsigned int  )4;
     sqlstm.sqhsts[81] = (         int  )0;
     sqlstm.sqindv[81] = (         void  *)0;
     sqlstm.sqinds[81] = (         int  )0;
     sqlstm.sqharm[81] = (unsigned int  )0;
     sqlstm.sqadto[81] = (unsigned short )0;
     sqlstm.sqtdso[81] = (unsigned short )0;
     sqlstm.sqhstv[82] = (         void  *)&bl_pat_service_date_time;
     sqlstm.sqhstl[82] = (unsigned int  )32;
     sqlstm.sqhsts[82] = (         int  )0;
     sqlstm.sqindv[82] = (         void  *)0;
     sqlstm.sqinds[82] = (         int  )0;
     sqlstm.sqharm[82] = (unsigned int  )0;
     sqlstm.sqadto[82] = (unsigned short )0;
     sqlstm.sqtdso[82] = (unsigned short )0;
     sqlstm.sqhstv[83] = (         void  *)&bl_addl_charge_amt_in_charge;
     sqlstm.sqhstl[83] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[83] = (         int  )0;
     sqlstm.sqindv[83] = (         void  *)0;
     sqlstm.sqinds[83] = (         int  )0;
     sqlstm.sqharm[83] = (unsigned int  )0;
     sqlstm.sqadto[83] = (unsigned short )0;
     sqlstm.sqtdso[83] = (unsigned short )0;
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



     //if(LAST_ROW)
	 //return 0;
	 if (OERROR)
	 err_mesg("FETCH failed on cursor BL_PAT_CHG_FOLIO_CUR",0,"");	
	 

	nd_cust_code.arr[nd_cust_code.len]                                       = '\0';
	bl_pat_trx_doc_ref.arr[bl_pat_trx_doc_ref.len]                           = '\0';
	bl_pat_trx_doc_ref_line_num.arr[bl_pat_trx_doc_ref_line_num.len]         = '\0';
	bl_pat_trx_doc_ref_seq_num.arr[bl_pat_trx_doc_ref_seq_num.len]           = '\0';
	bl_pat_trx_date.arr[bl_pat_trx_date.len]                                 = '\0';
	bl_pat_episode_type.arr[bl_pat_episode_type.len]                         = '\0';
	bl_pat_patient_id.arr[bl_pat_patient_id.len]                             = '\0';
	bl_pat_episode_id.arr[bl_pat_episode_id.len]                             = '\0';
	bl_pat_visit_id.arr[bl_pat_visit_id.len]                                 = '\0';
	bl_pat_billed_flag.arr[bl_pat_billed_flag.len]                           = '\0';
	bl_pat_settlement_ind.arr[bl_pat_settlement_ind.len]                     = '\0';
	bl_pat_prt_grp_hdr_code.arr[bl_pat_prt_grp_hdr_code.len]                 = '\0';
	bl_pat_prt_grp_line_code.arr[bl_pat_prt_grp_line_code.len]               = '\0';
	bl_pat_package_ind.arr[bl_pat_package_ind.len]                           = '\0';
	bl_pat_package_service_code.arr[bl_pat_package_service_code.len]         = '\0';
	bl_pat_blng_serv_code.arr[bl_pat_blng_serv_code.len]                     = '\0';
	bl_pat_package_trx_ind.arr[bl_pat_package_trx_ind.len]                   = '\0';
	bl_pat_serv_locn_code.arr[bl_pat_serv_locn_code.len]                     = '\0';
	bl_pat_serv_item_code.arr[bl_pat_serv_item_code.len]                     = '\0';
	bl_pat_serv_item_desc.arr[bl_pat_serv_item_desc.len]                     = '\0';
	bl_pat_rate_charge_flag.arr[bl_pat_rate_charge_flag.len]                 = '\0';
	bl_pat_base_qty.arr[bl_pat_base_qty.len]                                 = '\0';
	bl_pat_base_rate.arr[bl_pat_base_rate.len]                               = '\0';
	bl_pat_serv_qty.arr[bl_pat_serv_qty.len]                                 = '\0';
	bl_pat_base_charge_amt.arr[bl_pat_base_charge_amt.len]                   = '\0';
	bl_pat_org_gross_charge_amt.arr[bl_pat_org_gross_charge_amt.len]         = '\0';
	bl_pat_org_disc_amt.arr[bl_pat_org_disc_amt.len]                         = '\0';
	bl_pat_org_net_charge_amt.arr[bl_pat_org_net_charge_amt.len]             = '\0';
	bl_pat_upd_gross_charge_amt.arr[bl_pat_upd_gross_charge_amt.len]         = '\0';
	bl_pat_upd_disc_amt.arr[bl_pat_upd_disc_amt.len]                         = '\0';
	bl_pat_upd_net_charge_amt.arr[bl_pat_upd_net_charge_amt.len]             = '\0';
	bl_pat_adj_gross_charge_amt.arr[bl_pat_adj_gross_charge_amt.len]         = '\0';
	bl_pat_adj_disc_amt.arr[bl_pat_adj_disc_amt.len]                         = '\0';
	bl_pat_adj_net_charge_amt.arr[bl_pat_adj_net_charge_amt.len]             = '\0';
	bl_pat_module_id.arr[bl_pat_module_id.len]                               = '\0';
	bl_pat_source_doc_ref.arr[bl_pat_source_doc_ref.len]                     = '\0';
	bl_pat_source_doc_date.arr[bl_pat_source_doc_date.len]                   = '\0';
	bl_pat_service_date.arr[bl_pat_service_date.len]                         = '\0';
	bl_pat_service_date_time.arr[bl_pat_service_date_time.len]		 = '\0';
	bl_pat_acct_dept_code.arr[bl_pat_acct_dept_code.len]                     = '\0';
	bl_pat_orig_dept_code.arr[bl_pat_orig_dept_code.len]                     = '\0';
	bl_pat_physician_id.arr[bl_pat_physician_id.len]                         = '\0';
	bl_pat_blng_grp_id.arr[bl_pat_blng_grp_id.len]                           = '\0';
	bl_pat_blng_class_code.arr[bl_pat_blng_class_code.len]                   = '\0';
	bl_pat_day_type_code.arr[bl_pat_day_type_code.len]                       = '\0';
	bl_pat_time_type_code.arr[bl_pat_time_type_code.len]                     = '\0';
	bl_pat_disc_perc.arr[bl_pat_disc_perc.len]                               = '\0';
	bl_pat_addl_factor_num.arr[bl_pat_addl_factor_num.len]                   = '\0';
	bl_pat_bed_class_code.arr[bl_pat_bed_class_code.len]                     = '\0';
	bl_pat_bill_type_code.arr[bl_pat_bill_type_code.len]                     = '\0';
	bl_pat_folio_remarks.arr[bl_pat_folio_remarks.len]                       = '\0';
	bl_pat_df_service_ind.arr[bl_pat_df_service_ind.len]                     = '\0';
	bl_pat_df_upd_flag.arr[bl_pat_df_upd_flag.len]                           = '\0';
	bl_pat_doc_type_code.arr[bl_pat_doc_type_code.len]                       = '\0';
	bl_pat_doc_number.arr[bl_pat_doc_number.len]                             = '\0';
	bl_pat_bill_doc_type_code.arr[bl_pat_bill_doc_type_code.len]             = '\0';
	bl_pat_bill_doc_num.arr[bl_pat_bill_doc_num.len]                         = '\0';
	bl_pat_bill_doc_date.arr[bl_pat_bill_doc_date.len]                       = '\0';
	bl_pat_trx_finalize_ind.arr[bl_pat_trx_finalize_ind.len]                 = '\0';
	bl_pat_finalized_by_id.arr[bl_pat_finalized_by_id.len]                   = '\0';
	bl_pat_finalized_date.arr[bl_pat_finalized_date.len]                     = '\0';
	bl_pat_trx_posted_ind.arr[bl_pat_trx_posted_ind.len]                     = '\0';
	bl_pat_posted_by_id.arr[bl_pat_posted_by_id.len]                         = '\0';
	bl_pat_posted_date.arr[bl_pat_posted_date.len]                           = '\0';
	bl_pat_last_adjusted_by_id.arr[bl_pat_last_adjusted_by_id.len]           = '\0';
	bl_pat_last_adjusted_date.arr[bl_pat_last_adjusted_date.len]             = '\0';
	bl_pat_added_by_id.arr[bl_pat_added_by_id.len]                           = '\0';
	bl_pat_modified_by_id.arr[bl_pat_modified_by_id.len]                     = '\0';
	bl_pat_added_date.arr[bl_pat_added_date.len]                             = '\0';
	bl_pat_modified_date.arr[bl_pat_modified_date.len]                       = '\0';
	bl_pat_concat_code.arr[bl_pat_concat_code.len]                           = '\0';
	nd_doc_type_code.arr[nd_doc_type_code.len]                               = '\0';
	nd_doc_num.arr[nd_doc_num.len]                                          = '\0';
	nd_doc_date.arr[nd_doc_date.len]                                         = '\0';
	nd_cash_counter_code.arr[nd_cash_counter_code.len]                      = '\0';
	nd_shift_id.arr[nd_shift_id.len]                      			= '\0';

	nd_orig_doc_ref.arr[nd_orig_doc_ref.len] = '\0';                  
	nd_trx_status.arr[nd_trx_status.len] = '\0';
	nd_confirmed_yn.arr[nd_confirmed_yn.len] = '\0';

	nd_cust_code.arr[nd_cust_code.len] = '\0';

	if (bl_pat_orig_dept_code.arr[0] == '\0' && bl_pat_trx_doc_ref.arr[0] != '\0')
	{	
		/* EXEC SQL EXECUTE
		BEGIN	
			:nd_error_level := null;
			:nd_sys_message_id := null;
			:nd_error_text := null;

			BLCOMMON.GET_SERVICE_DEPT
			(:nd_operating_facility_id,
			:bl_pat_episode_type,
			:bl_pat_episode_id,
			:bl_pat_visit_id,
			:bl_pat_patient_id,
			TO_DATE(:bl_pat_service_date_time,'DD/MM/YYYY HH24:MI:SS'),
			:bl_pat_orig_dept_code,
			:nd_error_level,
			:nd_sys_message_id,
			:nd_error_text);		
		
			if :nd_sys_message_id is not null then
				:nd_error_level := '10';
				:nd_error_text := BLCOMMON.GET_ERROR_TEXT(:nd_sys_message_id);
			end if;
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 84;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :nd_error_level := null ; :nd_sys_message_id := null \
; :nd_error_text := null ; BLCOMMON . GET_SERVICE_DEPT ( :nd_operating_facilit\
y_id , :bl_pat_episode_type , :bl_pat_episode_id , :bl_pat_visit_id , :bl_pat_\
patient_id , TO_DATE ( :bl_pat_service_date_time , 'DD/MM/YYYY HH24:MI:SS' ) ,\
 :bl_pat_orig_dept_code , :nd_error_level , :nd_sys_message_id , :nd_error_tex\
t ) ; if :nd_sys_message_id is not null then :nd_error_level := '10' ; :nd_err\
or_text := BLCOMMON . GET_ERROR_TEXT ( :nd_sys_message_id ) ; end if ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )807;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_error_level;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_sys_message_id;
  sqlstm.sqhstl[1] = (unsigned int  )12;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_error_text;
  sqlstm.sqhstl[2] = (unsigned int  )1002;
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
  sqlstm.sqhstv[4] = (         void  *)&bl_pat_episode_type;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&bl_pat_episode_id;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&bl_pat_visit_id;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&bl_pat_patient_id;
  sqlstm.sqhstl[7] = (unsigned int  )23;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&bl_pat_service_date_time;
  sqlstm.sqhstl[8] = (unsigned int  )32;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&bl_pat_orig_dept_code;
  sqlstm.sqhstl[9] = (unsigned int  )13;
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




		if (nd_error_text.arr[0] != '\0' && strcmp(nd_error_level.arr,"10") == 0)
			disp_message(ERR_MESG,nd_error_text.arr);					
	}

	
	if (bl_pat_acct_dept_code.arr[0] == '\0' && bl_pat_trx_doc_ref.arr[0] != '\0')
	{
		/* EXEC SQL EXECUTE
		BEGIN				
		
			BEGIN
			   :l_clinic_code := null;
			   :l_ward_code    := null;
			   :nd_error_level := null;
  			   :nd_sys_message_id := null;
			   :nd_error_text := null;

			   if :bl_pat_episode_type in ('O','E') then 
				BEGIN
					SELECT CLINIC_CODE INTO :l_clinic_code
					FROM BL_VISIT_FIN_DTLS
					WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
					AND EPISODE_TYPE = :bl_pat_episode_type
					AND EPISODE_ID = :bl_pat_episode_id
					AND VISIT_ID   = :bl_pat_visit_id
					AND PATIENT_ID = :bl_pat_patient_id;
				EXCEPTION
					WHEN NO_DATA_FOUND THEN
						:nd_sys_message_id := 'BL9022';
						:nd_error_level := '10';
						:nd_error_text := BLCOMMON.GET_ERROR_TEXT(:nd_sys_message_id);					
					WHEN OTHERS THEN
						:nd_error_level := '10';
						:nd_error_text  := SUBSTR(SQLERRM,1,200);					
				END;			
			    end if;

			    if :bl_pat_episode_type in ('I','D') then 			   			   
			    
				BEGIN
					SELECT TO_WARD_CODE INTO :l_ward_code
					FROM BL_IP_ADT_TRN_VW
					WHERE FACILITY_ID = :nd_operating_facility_id
					AND EPISODE_ID = :bl_pat_episode_id
					AND SRL_NO in (
						SELECT MAX(SRL_NO)
						FROM BL_IP_ADT_TRN_VW
						WHERE FACILITY_ID=:nd_operating_facility_id
						AND EPISODE_ID = :bl_pat_episode_id
						AND PATIENT_ID = :bl_pat_patient_id
						AND NVL(ADT_TRN_STATUS,'X') != '9'
						AND NVL(TRN_CODE,'X') in ('A','T')
						AND TRN_DATE_TIME <= TO_DATE(:bl_pat_service_date_time,'DD/MM/YYYY HH24:MI:SS'));										
				EXCEPTION
					WHEN no_data_found THEN 
						:nd_sys_message_id :='BL4157';
						:nd_error_level := '10';
						:nd_error_text := BLCOMMON.GET_ERROR_TEXT(:nd_sys_message_id);					
					WHEN OTHERS THEN
						:nd_error_level := '10';
						:nd_error_text  := SUBSTR(SQLERRM,1,200);
			
				END;											
			   end if;		   			   

			   if :nd_sys_message_id is null and :nd_error_text is null then 

					BLVALID.VALID_BLNG_SERV_ACC_DEPT
					(	:bl_pat_blng_serv_code,
						:nd_operating_facility_id,          
						:bl_pat_episode_type,         
						:l_clinic_code,         
						:l_ward_code,
						:bl_pat_acct_dept_code,
						:nd_error_level,
						:nd_sys_message_id,
						:nd_error_text);		
				
					if :nd_sys_message_id is not null then
						:nd_error_level := '10';
						:nd_error_text := BLCOMMON.GET_ERROR_TEXT(:nd_sys_message_id);
					end if;						
			   end if;
		      END;
		      
		      
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 84;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "begin BEGIN :l_clinic_code := null ; :l_ward_code := null ; :nd_error_l\
evel := null ; :nd_sys_message_id := null ; :nd_error_text := null ; if :bl_\
pat_episode_type in ( 'O' , 'E' ) then BEGIN SELECT CLINIC_CODE INTO :l_clin\
ic_code FROM BL_VISIT_FIN_DTLS WHERE OPERATING_FACILITY_ID = :nd_operating_f\
acility_id AND EPISODE_TYPE = :bl_pat_episode_type AND EPISODE_ID = :bl_pat_\
episode_id AND VISIT_ID = :bl_pat_visit_id AND PATIENT_ID = :bl_pat_patient_\
id ; EXCEPTION WHEN NO_DATA_FOUND THEN :nd_sys_message_id := 'BL9022' ; :nd_\
error_level := '10' ; :nd_error_text := BLCOMMON . GET_ERROR_TEXT ( :nd_sys_\
message_id ) ; WHEN OTHERS THEN :nd_error_level := '10' ; :nd_error_text := \
SUBSTR ( SQLERRM , 1 , 200 ) ; END ; end if ; if :bl_pat_episode_type in ( '\
I' , 'D' ) then BEGIN SELECT TO_WARD_CODE INTO :l_ward_code FROM BL_IP_ADT_T\
RN_VW WHERE FACILITY_ID = :nd_operating_facility_id AND EPISODE_ID = :bl_pat\
_episode_id AND SRL_NO in ( SELECT MAX ( SRL_NO ) FROM BL_IP_ADT_TRN_VW WHER\
E FACILITY_ID = :nd_operating_facility_id");
  sqlstm.stmt = " AND EPISODE_ID = :bl_pat_episode_id AND PATIENT_ID = :bl_p\
at_patient_id AND NVL ( ADT_TRN_STATUS , 'X' ) != '9' AND NVL ( TRN_CODE , 'X'\
 ) in ( 'A' , 'T' ) AND TRN_DATE_TIME <= TO_DATE ( :bl_pat_service_date_time ,\
 'DD/MM/YYYY HH24:MI:SS' ) ) ; EXCEPTION WHEN no_data_found THEN :nd_sys_messa\
ge_id := 'BL4157' ; :nd_error_level := '10' ; :nd_error_text := BLCOMMON . GET\
_ERROR_TEXT ( :nd_sys_message_id ) ; WHEN OTHERS THEN :nd_error_level := '10' \
; :nd_error_text := SUBSTR ( SQLERRM , 1 , 200 ) ; END ; end if ; if :nd_sys_m\
essage_id is null and :nd_error_text is null then BLVALID . VALID_BLNG_SERV_AC\
C_DEPT ( :bl_pat_blng_serv_code , :nd_operating_facility_id , :bl_pat_episode_\
type , :l_clinic_code , :l_ward_code , :bl_pat_acct_dept_code , :nd_error_leve\
l , :nd_sys_message_id , :nd_error_text ) ; if :nd_sys_message_id is not null \
then :nd_error_level := '10' ; :nd_error_text := BLCOMMON . GET_ERROR_TEXT ( :\
nd_sys_message_id ) ; end if ; end if ; END ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )862;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_clinic_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_ward_code;
  sqlstm.sqhstl[1] = (unsigned int  )7;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_error_level;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_sys_message_id;
  sqlstm.sqhstl[3] = (unsigned int  )12;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_error_text;
  sqlstm.sqhstl[4] = (unsigned int  )1002;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&bl_pat_episode_type;
  sqlstm.sqhstl[5] = (unsigned int  )4;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&bl_pat_episode_id;
  sqlstm.sqhstl[7] = (unsigned int  )11;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&bl_pat_visit_id;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&bl_pat_patient_id;
  sqlstm.sqhstl[9] = (unsigned int  )23;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&bl_pat_service_date_time;
  sqlstm.sqhstl[10] = (unsigned int  )32;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&bl_pat_blng_serv_code;
  sqlstm.sqhstl[11] = (unsigned int  )13;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&bl_pat_acct_dept_code;
  sqlstm.sqhstl[12] = (unsigned int  )13;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
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





		if (nd_error_text.arr[0] != '\0' && strcmp(nd_error_level.arr,"10") == 0)
			disp_message(ERR_MESG,nd_error_text.arr);		
	}
	

	nd_can_rec_ctr = 0;


	if (strcmp(nd_trx_status.arr,"C") == 0 && nd_orig_doc_ref.arr[0] != '\0' && 
			bl_pat_bill_doc_type_code.arr[0] == '\0')
	{

		/* EXEC SQL SELECT count(*) INTO :nd_can_rec_ctr 
			 FROM bl_patient_charges_folio 
			 WHERE operating_facility_id = :nd_operating_facility_id
			 AND TRX_DOC_REF = :nd_orig_doc_ref        
			 AND TRX_DOC_REF_LINE_NUM  = :nd_orig_doc_ref_line_num
			 AND TRX_DOC_REF_SEQ_NUM = :nd_orig_doc_ref_seq_num
			 AND BILL_DOC_TYPE_CODE IS NULL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 84;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from bl_patient_charges_folio wh\
ere ((((operating_facility_id=:b1 and TRX_DOC_REF=:b2) and TRX_DOC_REF_LINE_NU\
M=:b3) and TRX_DOC_REF_SEQ_NUM=:b4) and BILL_DOC_TYPE_CODE is null )";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )929;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_can_rec_ctr;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
  sqlstm.sqhstv[2] = (         void  *)&nd_orig_doc_ref;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_orig_doc_ref_line_num;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_orig_doc_ref_seq_num;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
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


	}
	else if (strcmp(nd_trx_status.arr,"C") == 0 && nd_orig_doc_ref.arr[0] == '\0' && 
			bl_pat_bill_doc_type_code.arr[0] == '\0')
	{
		/* EXEC SQL SELECT count(*) INTO :nd_can_rec_ctr 
			 FROM bl_patient_charges_folio 
			 WHERE operating_facility_id = :nd_operating_facility_id
			 AND ORIG_DOC_REF = :bl_pat_trx_doc_ref        
			 AND ORIG_DOC_REF_LINE_NUM  = :bl_pat_trx_doc_ref_line_num
			 AND ORIG_DOC_REF_SEQ_NUM = :bl_pat_trx_doc_ref_seq_num
			 AND BILL_DOC_TYPE_CODE IS NULL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 84;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from bl_patient_charges_folio wh\
ere ((((operating_facility_id=:b1 and ORIG_DOC_REF=:b2) and ORIG_DOC_REF_LINE_\
NUM=:b3) and ORIG_DOC_REF_SEQ_NUM=:b4) and BILL_DOC_TYPE_CODE is null )";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )964;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_can_rec_ctr;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
  sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_doc_ref;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bl_pat_trx_doc_ref_line_num;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_doc_ref_seq_num;
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


	}
	
	else if ( atof(bl_pat_upd_gross_charge_amt.arr) == 0 )
	{
		nd_can_rec_ctr = 1;   // Allow to process
	}
	else
	{		
		nd_can_rec_ctr = 0;
	}

   
    return(LAST_ROW?0:1);
}

fetch_bl_gl_account_trx_ref()
{

/*
     EXEC SQL OPEN BL_TYPE_SERV_GRP_CUR;
     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_TYPE_SERV_GRP_CUR",0,"");

     bl_acc_int_code.arr[0]     = '\0';
     bl_acc_int_code.len        = '\0';

     EXEC SQL FETCH BL_TYPE_SERV_GRP_CUR
	       INTO :bl_acc_int_code;

     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_TYPE_SERV_GRP_CUR",0,"");

     
     if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s - %s not found in BL_TYPE_FOR_SERV_GRP",
			  bl_pat_blng_grp_id.arr,
			  bl_pat_bill_type_code.arr);

	   loc_log_msg(msg_str);
	   strcpy(msg_str_var,msg_str);
	   upd_folio_unpost_reason();	   
	   return;
     }
     bl_acc_int_code.arr[bl_acc_int_code.len] = '\0';

     EXEC SQL OPEN BL_GL_ACCOUNT_CUR;
     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_GL_ACCOUNT_CUR",0,"");

     bl_pkg1_main_acc1_code.arr[0]            = '\0';
     bl_pkg1_main_acc2_code.arr[0]            = '\0';
     bl_pkg1_dept_code.arr[0]                 = '\0';
     bl_pkg1_subledger_group_code.arr[0]      = '\0';
     bl_pkg1_subledger_line_code.arr[0]       = '\0';
     bl_pkg1_product_group_code.arr[0]        = '\0';
     bl_pkg1_product_line_code.arr[0]         = '\0';

     bl_pkg1_main_acc1_code.len                = 0;
     bl_pkg1_main_acc2_code.len                = 0;
     bl_pkg1_dept_code.len                     = 0;
     bl_pkg1_subledger_group_code.len          = 0;
     bl_pkg1_subledger_line_code.len           = 0;
     bl_pkg1_product_group_code.len            = 0;
     bl_pkg1_product_line_code.len             = 0;

     EXEC SQL FETCH BL_GL_ACCOUNT_CUR
	       INTO :bl_pkg1_main_acc1_code,
		    :bl_pkg1_main_acc2_code,
		    :bl_pkg1_dept_code,
		    :bl_pkg1_subledger_group_code,
		    :bl_pkg1_subledger_line_code,
		    :bl_pkg1_product_group_code,
		    :bl_pkg1_product_line_code;
     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_GL_ACCOUNT_CUR",0,"");


     if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s %s - %s not found in BL_GL_ACCOUNT",
		       bl_acc_int_code.arr,
		       bl_pat_blng_grp_id.arr,
		       bl_pat_bill_type_code.arr);

	   loc_log_msg(msg_str);
	   strcpy(msg_str_var,msg_str);
	   upd_folio_unpost_reason();	   
	   return;
     }

bl_pkg1_main_acc1_code.arr[bl_pkg1_main_acc1_code.len] = '\0';
bl_pkg1_main_acc2_code.arr[bl_pkg1_main_acc2_code.len] = '\0';
bl_pkg1_dept_code.arr[bl_pkg1_dept_code.len] = '\0';
bl_pkg1_subledger_group_code.arr[bl_pkg1_subledger_group_code.len] = '\0';
bl_pkg1_subledger_line_code.arr[bl_pkg1_subledger_line_code.len] = '\0';
bl_pkg1_product_group_code.arr[bl_pkg1_product_group_code.len] = '\0';
bl_pkg1_product_line_code.arr[bl_pkg1_product_line_code.len] = '\0';
*/

     /* EXEC SQL OPEN BL_BILL_TYPE_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0021;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )999;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[1] = (unsigned int  )15;
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

     bl_acc_int_code.arr[0]     = '\0';
     bl_acc_int_code.len        = '\0';
 
     /* EXEC SQL FETCH BL_BILL_TYPE_CUR
	       INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1026;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
	     err_mesg("FETCH failed on cursor BL_BILL_TYPE_CUR",0,"");


     if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s not found in BL_BILL_TYPE_INT",
			  bl_pat_bill_type_code.arr);

	   loc_log_msg(msg_str);
	   strcpy(msg_str_var,msg_str);
	   upd_folio_unpost_reason();	   
	   return;
     }

     bl_acc_int_code.arr[bl_acc_int_code.len] = '\0';

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0022;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1045;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&store_acct_dept_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
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
if (sqlca.sqlcode == 1403) 
    {
    disp_message(ERR_MESG,"NO DATA FOUND IN BL GL ACCOUNT CUR");
    proc_exit();
    }


     bl_pkg2_main_acc1_code.arr[0]            = '\0';
     bl_pkg2_main_acc2_code.arr[0]            = '\0';
     bl_pkg2_dept_code.arr[0]                 = '\0';
     bl_pkg2_subledger_group_code.arr[0]      = '\0';
     bl_pkg2_subledger_line_code.arr[0]       = '\0';
     bl_pkg2_product_group_code.arr[0]        = '\0';
     bl_pkg2_product_line_code.arr[0]         = '\0';

     bl_pkg2_main_acc1_code.len                = 0;
     bl_pkg2_main_acc2_code.len                = 0;
     bl_pkg2_dept_code.len                     = 0;
     bl_pkg2_subledger_group_code.len          = 0;
     bl_pkg2_subledger_line_code.len           = 0;
     bl_pkg2_product_group_code.len            = 0;
     bl_pkg2_product_line_code.len             = 0;

     /* EXEC SQL FETCH BL_GL_ACCOUNT_CUR
	       INTO :bl_pkg2_main_acc1_code,
		    :bl_pkg2_main_acc2_code,
		    :bl_pkg2_dept_code,
		    :bl_pkg2_subledger_group_code,
		    :bl_pkg2_subledger_line_code,
		    :bl_pkg2_product_group_code,
		    :bl_pkg2_product_line_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1072;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pkg2_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pkg2_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pkg2_dept_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_pkg2_subledger_group_code;
     sqlstm.sqhstl[3] = (unsigned int  )6;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pkg2_subledger_line_code;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_pkg2_product_group_code;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_pkg2_product_line_code;
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

     if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s %s not found in BL_GL_ACCOUNT",
			bl_acc_int_code.arr,
			bl_pat_bill_type_code.arr);

	   loc_log_msg(msg_str);
	   return;
     }

bl_pkg2_main_acc1_code.arr[bl_pkg2_main_acc1_code.len] = '\0';
bl_pkg2_main_acc2_code.arr[bl_pkg2_main_acc2_code.len] = '\0';
bl_pkg2_dept_code.arr[bl_pkg2_dept_code.len] = '\0';
bl_pkg2_subledger_group_code.arr[bl_pkg2_subledger_group_code.len] = '\0';
bl_pkg2_subledger_line_code.arr[bl_pkg2_subledger_line_code.len] = '\0';
bl_pkg2_product_group_code.arr[bl_pkg2_product_group_code.len] = '\0';
bl_pkg2_product_line_code.arr[bl_pkg2_product_line_code.len] = '\0';

}

fetch_bl_gl_account_pkg()
{

     /* EXEC SQL OPEN BL_TYPE_SERV_GRP_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0017;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1115;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_grp_id;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
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
	 err_mesg("OPEN failed on cursor BL_TYPE_SERV_GRP_CUR",0,"");

     bl_acc_int_code.arr[0]     = '\0';
     bl_acc_int_code.len        = '\0';     


     /* EXEC SQL FETCH BL_TYPE_SERV_GRP_CUR
	       INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1146;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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



				if (nd_cust_code.arr[0] != '\0')   /* Added on 26-MAr-2007 for Enhancement */
				{
				 /* EXEC SQL OPEN BL_TYPE_SERV_GRP_BY_PAYER_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0018;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1165;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_grp_id;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_blng_serv_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_cust_code;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[4] = (unsigned int  )15;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
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
				 err_mesg("OPEN failed on cursor BL_TYPE_SERV_GRP_BY_PAYER_CUR",0,"");

				 bl_acc_int_code.arr[0]     = '\0';
				 bl_acc_int_code.len        = '\0';     


				 /* EXEC SQL FETCH BL_TYPE_SERV_GRP_BY_PAYER_CUR
					   INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1204;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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



				}
     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_TYPE_SERV_GRP_BY_PAYER_CUR",0,"");

/* added on 15-02-2008*/

	 if (LAST_ROW)
				{
				 /* EXEC SQL OPEN BL_TYPE_SERV_GRP_BY_PAYER_CUR1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0019;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1223;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_grp_id;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_blng_serv_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_cust_code;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[4] = (unsigned int  )15;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
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
				 err_mesg("OPEN failed on cursor BL_TYPE_SERV_GRP_BY_PAYER_CUR1",0,"");

				 bl_acc_int_code.arr[0]     = '\0';
				 bl_acc_int_code.len        = '\0';     


				 /* EXEC SQL FETCH BL_TYPE_SERV_GRP_BY_PAYER_CUR1
					   INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1262;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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



				}

     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_TYPE_SERV_GRP_BY_PAYER_CUR1",0,"");

	 if (LAST_ROW)
				{
				 /* EXEC SQL OPEN BL_TYPE_SERV_GRP_BY_PAYER_CUR2; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0020;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1281;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_grp_id;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_blng_serv_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_cust_code;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[4] = (unsigned int  )15;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
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
				 err_mesg("OPEN failed on cursor BL_TYPE_SERV_GRP_BY_PAYER_CUR2",0,"");

				 bl_acc_int_code.arr[0]     = '\0';
				 bl_acc_int_code.len        = '\0';     


				 /* EXEC SQL FETCH BL_TYPE_SERV_GRP_BY_PAYER_CUR2
					   INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1320;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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



				}

     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_TYPE_SERV_GRP_BY_PAYER_CUR2",0,"");

	 if (LAST_ROW)
				{
				 /* EXEC SQL OPEN BL_TYPE_SERV_GRP_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0017;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1339;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_grp_id;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
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
				 err_mesg("OPEN failed on cursor BL_TYPE_SERV_GRP_CUR",0,"");

				 bl_acc_int_code.arr[0]     = '\0';
				 bl_acc_int_code.len        = '\0';     


				 /* EXEC SQL FETCH BL_TYPE_SERV_GRP_CUR
					   INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1370;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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


				}
     
	 if (OERROR)
	 err_mesg("FETCH failed on cursor BL_TYPE_SERV_GRP_CUR",0,"");

/*upto here added on 15-02-2008*/

	 if (ROW_COUNT == 0)
     {
	sprintf(msg_str,"Record for %s - %s not found in BL_TYPE_FOR_SERV_GRP",
			  bl_pat_blng_grp_id.arr,
			  bl_pat_bill_type_code.arr);

	loc_log_msg(msg_str);	   
	strcpy(msg_str_var,msg_str);
	upd_folio_unpost_reason();	   
	return;
     }

     bl_acc_int_code.arr[bl_acc_int_code.len] = '\0';

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0022;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1389;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&store_acct_dept_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
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

     bl_pkg1_main_acc1_code.arr[0]            = '\0';
     bl_pkg1_main_acc2_code.arr[0]            = '\0';
     bl_pkg1_dept_code.arr[0]                 = '\0';
     bl_pkg1_subledger_group_code.arr[0]      = '\0';
     bl_pkg1_subledger_line_code.arr[0]       = '\0';
     bl_pkg1_product_group_code.arr[0]        = '\0';
     bl_pkg1_product_line_code.arr[0]         = '\0';

     bl_pkg1_main_acc1_code.len                = 0;
     bl_pkg1_main_acc2_code.len                = 0;
     bl_pkg1_dept_code.len                     = 0;
     bl_pkg1_subledger_group_code.len          = 0;
     bl_pkg1_subledger_line_code.len           = 0;
     bl_pkg1_product_group_code.len            = 0;
     bl_pkg1_product_line_code.len             = 0;

     /* EXEC SQL FETCH BL_GL_ACCOUNT_CUR
	       INTO :bl_pkg1_main_acc1_code,
		    :bl_pkg1_main_acc2_code,
		    :bl_pkg1_dept_code,
		    :bl_pkg1_subledger_group_code,
		    :bl_pkg1_subledger_line_code,
		    :bl_pkg1_product_group_code,
		    :bl_pkg1_product_line_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1416;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pkg1_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pkg1_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pkg1_dept_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_pkg1_subledger_group_code;
     sqlstm.sqhstl[3] = (unsigned int  )6;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pkg1_subledger_line_code;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_pkg1_product_group_code;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_pkg1_product_line_code;
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

     if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s %s - %s not found in BL_GL_ACCOUNT",
		       bl_acc_int_code.arr,
		       bl_pat_blng_grp_id.arr,
		       bl_pat_bill_type_code.arr);

	   loc_log_msg(msg_str);
	   return;
     }

bl_pkg1_main_acc1_code.arr[bl_pkg1_main_acc1_code.len] = '\0';
bl_pkg1_main_acc2_code.arr[bl_pkg1_main_acc2_code.len] = '\0';
bl_pkg1_dept_code.arr[bl_pkg1_dept_code.len] = '\0';
bl_pkg1_subledger_group_code.arr[bl_pkg1_subledger_group_code.len] = '\0';
bl_pkg1_subledger_line_code.arr[bl_pkg1_subledger_line_code.len] = '\0';
bl_pkg1_product_group_code.arr[bl_pkg1_product_group_code.len] = '\0';
bl_pkg1_product_line_code.arr[bl_pkg1_product_line_code.len] = '\0';
     
     
     /* EXEC SQL OPEN BL_TYPE_BLNG_SERV_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0014;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1459;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_serv_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
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
	 err_mesg("OPEN failed on cursor BL_TYPE_BLNG_SERV_CUR",0,"");

     /* EXEC SQL FETCH BL_TYPE_BLNG_SERV_CUR
	       INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1490;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
	 err_mesg("FETCH failed on cursor BL_TYPE_BLNG_SERV_CUR",0,"");

     

     if (ROW_COUNT == 0)		/* Added on 26-MAR-2007 for enhancement */
     {
     		
				 /* EXEC SQL OPEN BL_TYPE_BLNG_SERV_CLSFN_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0015;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1509;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_serv_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
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
				 err_mesg("OPEN failed on cursor BL_TYPE_BLNG_SERV_CLSFN_CUR",0,"");

				 /* EXEC SQL FETCH BL_TYPE_BLNG_SERV_CLSFN_CUR
					   INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1540;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
				 err_mesg("FETCH failed on cursor BL_TYPE_BLNG_SERV_CUR",0,"");

				 if (ROW_COUNT == 0)
				 {
						 /* EXEC SQL OPEN BL_TYPE_BLNG_SERV_GRP_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 84;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0016;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1559;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_serv_code;
       sqlstm.sqhstl[0] = (unsigned int  )13;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&bl_pat_bill_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )5;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_date;
       sqlstm.sqhstl[2] = (unsigned int  )15;
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
						 err_mesg("OPEN failed on cursor BL_TYPE_BLNG_SERV_CUR",0,"");

						 /* EXEC SQL FETCH BL_TYPE_BLNG_SERV_GRP_CUR
							   INTO :bl_acc_int_code; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 84;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1590;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&bl_acc_int_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
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
						 err_mesg("FETCH failed on cursor BL_TYPE_BLNG_SERV_CUR",0,"");

						  if (ROW_COUNT == 0)
									 {
						   sprintf(msg_str,"Record for %s - %s not found in BL_TYPE_FOR_BLNG_SERV",
								  bl_pat_blng_serv_code.arr,
								  bl_pat_bill_type_code.arr);

						   loc_log_msg(msg_str);
						   strcpy(msg_str_var,msg_str);
						   upd_folio_unpost_reason();	   
						   return;
									}
				   }
		}
	bl_acc_int_code.arr[bl_acc_int_code.len] = '\0';

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0022;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1609;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&store_acct_dept_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_acc_int_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
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
	 err_mesg("OPEN failed on cursor BL_GL_ACCOUNT_CUR - 3",0,"");

     bl_dept_main_acc1_code.arr[0]            = '\0';
     bl_dept_main_acc2_code.arr[0]            = '\0';
     bl_dept_dept_code.arr[0]                 = '\0';
     bl_dept_subledger_group_code.arr[0]      = '\0';
     bl_dept_subledger_line_code.arr[0]       = '\0';
     bl_dept_product_group_code.arr[0]        = '\0';
     bl_dept_product_line_code.arr[0]         = '\0';

     bl_dept_main_acc1_code.len                = 0;
     bl_dept_main_acc2_code.len                = 0;
     bl_dept_dept_code.len                     = 0;
     bl_dept_subledger_group_code.len          = 0;
     bl_dept_subledger_line_code.len           = 0;
     bl_dept_product_group_code.len            = 0;
     bl_dept_product_line_code.len             = 0;

     /* EXEC SQL FETCH BL_GL_ACCOUNT_CUR
	       INTO :bl_dept_main_acc1_code,
		    :bl_dept_main_acc2_code,
		    :bl_dept_dept_code,
		    :bl_dept_subledger_group_code,
		    :bl_dept_subledger_line_code,
		    :bl_dept_product_group_code,
		    :bl_dept_product_line_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 84;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1636;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_dept_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_dept_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_dept_dept_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_dept_subledger_group_code;
     sqlstm.sqhstl[3] = (unsigned int  )6;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_dept_subledger_line_code;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_dept_product_group_code;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_dept_product_line_code;
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
	 err_mesg("FETCH failed on cursor BL_GL_ACCOUNT_CUR - 3",0,"");

     if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s %s - %s not found in BL_GL_ACCOUNT",
			 bl_acc_int_code.arr,
			 bl_pat_blng_serv_code.arr,
			 bl_pat_bill_type_code.arr);

	   loc_log_msg(msg_str);
	   return;
     }

bl_dept_main_acc1_code.arr[bl_dept_main_acc1_code.len] = '\0';
bl_dept_main_acc2_code.arr[bl_dept_main_acc2_code.len] = '\0';
bl_dept_dept_code.arr[bl_dept_dept_code.len] = '\0';
bl_dept_subledger_group_code.arr[bl_dept_subledger_group_code.len] = '\0';
bl_dept_subledger_line_code.arr[bl_dept_subledger_line_code.len] = '\0';
bl_dept_product_group_code.arr[bl_dept_product_group_code.len] = '\0';
bl_dept_product_line_code.arr[bl_dept_product_line_code.len] = '\0';

}

create_bl_gl_dist_dept()
{

    if( (bl_store_episode_type.arr[0] == 'I' && d_ip_gl_yn == 'N') ||
        (bl_store_episode_type.arr[0] == 'D' && d_ip_gl_yn == 'N') ||  
	(bl_store_episode_type.arr[0] == 'O' && d_op_gl_yn == 'N') ||
	(bl_store_episode_type.arr[0] == 'E' && d_op_gl_yn == 'N') ||
	(bl_store_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N') )
	{
	return;
	}

	nd_post_month.arr[0] = '\0';
	nd_post_month.len = 0;

        nd_post_year.arr[0] = '\0';
	nd_post_year.len = 0;

        /* exec sql select nvl(acc_per_year, to_char(to_date(:bl_store_trx_date,'DD/MM/YYYY'),'YYYY')),
        nvl(acc_per_month,to_char(to_date(:bl_store_trx_date,'DD/MM/YYYY'),'MM'))  
	into :nd_post_year, :nd_post_month
	from sy_acc_period_defn
	where to_date(:bl_store_trx_date,'DD/MM/YYYY') 
	between acc_per_start_date and acc_per_end_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 84;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select nvl(acc_per_year,to_char(to_date(:b0,'DD/MM/YY\
YY'),'YYYY')) ,nvl(acc_per_month,to_char(to_date(:b0,'DD/MM/YYYY'),'MM')) into\
 :b2,:b3  from sy_acc_period_defn where to_date(:b0,'DD/MM/YYYY') between acc_\
per_start_date and acc_per_end_date";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1679;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&bl_store_trx_date;
        sqlstm.sqhstl[0] = (unsigned int  )15;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&bl_store_trx_date;
        sqlstm.sqhstl[1] = (unsigned int  )15;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_post_year;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_post_month;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&bl_store_trx_date;
        sqlstm.sqhstl[4] = (unsigned int  )15;
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

	

	nd_post_month.arr[nd_post_month.len] = '\0';
	nd_post_year.arr[nd_post_year.len] = '\0';


    if(bl_tot_disc_amt != 0) 
	{
   

		l_temp_narration.arr[0] = '\0';
		l_temp_narration.len = 0;

		if((strcmp(l_cash_ctrl_rcpt_in_use.arr,"Y")==0) && (strcmp(l_allow_unbilled_folio.arr,"Y")==0) &&
		   (nd_pre_doc_type_code.arr[0]=='\0'))
		{
			strcpy(l_temp_narration.arr,l_unbilled_remarks.arr);
			l_temp_narration.len = strlen(l_temp_narration.arr);
		}

    
	/* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
		  (
		    OPERATING_FACILITY_ID,
		    MAIN_ACC1_CODE,
		    MAIN_ACC2_CODE,
		    DEPT_CODE,
		    SUBLEDGER_GROUP_CODE,
		    SUBLEDGER_LINE_CODE,
		    PRODUCT_GROUP_CODE,
		    PRODUCT_LINE_CODE,
		    POST_YEAR,           /o  accepted o/
		    POST_MONTH,           /o  accepted o/
		    TRX_DATE,            /o from pat o/
		    TRX_DOC_REF,            /o from pat o/
		    TRX_DOC_REF_LINE_NUM,/o   0    o/
		    TRX_DOC_REF_SEQ_NUM,/o   0    o/
		    EPISODE_TYPE,       /o from pat o/
		    PATIENT_ID,       /o from pat o/
		    EPISODE_ID,       /o from pat o/
		    VISIT_ID,       /o from pat o/
		    SOURCE_DOC_REF,     /o   NULL       o/
		    SOURCE_DOC_DATE,    /o   NULL       o/
		    NARRATION,          /o   NULL       o/
		    TRX_TYPE_CODE,      /o   F          o/
		    DISTRIBUTION_AMT,   /o   net      o/
		    GL_INTERFACE_BY_ID, /o NULL o/
		    GL_INTERFACE_DATE, /o NULL o/
		    GL_INTERFACE_FLAG,   /o   N  o/
		    ADDED_BY_ID,
		    MODIFIED_BY_ID,         
	        ADDED_DATE,             
            MODIFIED_DATE,          
            ADDED_AT_WS_NO,         
            ADDED_FACILITY_ID,      
            MODIFIED_AT_WS_NO,      
            MODIFIED_FACILITY_ID,
	   	    CASH_CTRL_DOC_TYPE,     
		    CASH_CTRL_DOC_NUMBER,   
		    CASH_CTRL_DOC_DATE,
		    CUST_CODE     		        	
	       )
	   VALUES
	      (
		   :nd_operating_facility_id,
		   :bl_pkg1_main_acc1_code,
		   :bl_pkg1_main_acc2_code,
		   :bl_pkg1_dept_code,
		   :bl_pkg1_subledger_group_code,
		   :bl_pkg1_subledger_line_code,
		   :bl_pkg1_product_group_code,
		   :bl_pkg1_product_line_code,
		   /o
		   :nd_year,
		   :nd_month,
		   o/
		   nvl(:nd_post_year,TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'YYYY')),
		   nvl(:nd_post_month,TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'MM')),
		   TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),
		   :bl_store_trx_doc_ref,
		   DECODE(:l_group_posting_yn,'Y',0,:bl_store_trx_doc_ref_line_no),
		   DECODE(:l_group_posting_yn,'Y',0,:bl_store_trx_doc_ref_seq_no),
		   :bl_store_episode_type,
		   :bl_store_patient_id,
		   :bl_store_episode_id,
		   :bl_store_visit_id,
		   NULL,
		   NULL,
		   :l_temp_narration,
		   'F',
		   :bl_tot_disc_amt,
		   NULL,
		   NULL,
		   'N',
		   user,
		   user,
		   sysdate,
		   sysdate,
		   :nd_ws_no,
		   :nd_operating_facility_id,
		   :nd_ws_no,
		   :nd_operating_facility_id,
	       :nd_pre_doc_type_code,
		   :nd_pre_doc_num,
		   :nd_pre_doc_date,
		   :nd_pre_cust_code
		 ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 84;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (OPERATING_FACILITY_ID,MAIN_A\
CC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,PRO\
DUCT_GROUP_CODE,PRODUCT_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,TR\
X_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISI\
T_ID,SOURCE_DOC_REF,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT,G\
L_INTERFACE_BY_ID,GL_INTERFACE_DATE,GL_INTERFACE_FLAG,ADDED_BY_ID,MODIFIED_BY_\
ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO\
,MODIFIED_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_CTRL_DOC_DA\
TE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,nvl(:b8,TO_CHAR(TO_DATE(\
:b9,'DD/MM/YYYY'),'YYYY')),nvl(:b10,TO_CHAR(TO_DATE(:b9,'DD/MM/YYYY'),'MM')),T\
O_DATE(:b9,'DD/MM/YYYY'),:b13,DECODE(:b14,'Y',0,:b15),DECODE(:b14,'Y',0,:b17),\
:b18,:b19,:b20,:b21,null ,null ,:b22,'F',:b23,null ,null ,'N',user,user,sysdat\
e,sysdate,:b24,:b0,:b24,:b0,:b28,:b29,:b30,:b31)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1714;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_pkg1_main_acc1_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_pkg1_main_acc2_code;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_pkg1_dept_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_pkg1_subledger_group_code;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_pkg1_subledger_line_code;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&bl_pkg1_product_group_code;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&bl_pkg1_product_line_code;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_post_year;
 sqlstm.sqhstl[8] = (unsigned int  )7;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&bl_store_trx_date;
 sqlstm.sqhstl[9] = (unsigned int  )15;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_post_month;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&bl_store_trx_date;
 sqlstm.sqhstl[11] = (unsigned int  )15;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&bl_store_trx_date;
 sqlstm.sqhstl[12] = (unsigned int  )15;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&bl_store_trx_doc_ref;
 sqlstm.sqhstl[13] = (unsigned int  )53;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&l_group_posting_yn;
 sqlstm.sqhstl[14] = (unsigned int  )7;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&bl_store_trx_doc_ref_line_no;
 sqlstm.sqhstl[15] = (unsigned int  )12;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&l_group_posting_yn;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&bl_store_trx_doc_ref_seq_no;
 sqlstm.sqhstl[17] = (unsigned int  )12;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&bl_store_episode_type;
 sqlstm.sqhstl[18] = (unsigned int  )4;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&bl_store_patient_id;
 sqlstm.sqhstl[19] = (unsigned int  )23;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&bl_store_episode_id;
 sqlstm.sqhstl[20] = (unsigned int  )11;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&bl_store_visit_id;
 sqlstm.sqhstl[21] = (unsigned int  )7;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&l_temp_narration;
 sqlstm.sqhstl[22] = (unsigned int  )102;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&bl_tot_disc_amt;
 sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[24] = (unsigned int  )33;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[25] = (unsigned int  )5;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[26] = (unsigned int  )33;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[27] = (unsigned int  )5;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&nd_pre_doc_type_code;
 sqlstm.sqhstl[28] = (unsigned int  )9;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&nd_pre_doc_num;
 sqlstm.sqhstl[29] = (unsigned int  )11;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&nd_pre_doc_date;
 sqlstm.sqhstl[30] = (unsigned int  )37;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&nd_pre_cust_code;
 sqlstm.sqhstl[31] = (unsigned int  )11;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
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
	     err_mesg("INSERT failed on table BL_GL_DISTRIBUTION - 2",0,"");
    }

	l_temp_narration.arr[0] = '\0';
	l_temp_narration.len = 0;

	if((strcmp(l_cash_ctrl_rcpt_in_use.arr,"Y")==0) && (strcmp(l_allow_unbilled_folio.arr,"Y")==0) &&
	   (nd_pre_doc_type_code.arr[0]=='\0'))
	{
		strcpy(l_temp_narration.arr,l_unbilled_remarks.arr);
		l_temp_narration.len = strlen(l_temp_narration.arr);
	}

    /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
	      (

		OPERATING_FACILITY_ID,
		MAIN_ACC1_CODE,
		MAIN_ACC2_CODE,
		DEPT_CODE,
		SUBLEDGER_GROUP_CODE,
		SUBLEDGER_LINE_CODE,
		PRODUCT_GROUP_CODE,
		PRODUCT_LINE_CODE,
		POST_YEAR,           /o  accepted o/
		POST_MONTH,           /o  accepted o/
		TRX_DATE,            /o from pat o/
		TRX_DOC_REF,            /o from pat o/
		TRX_DOC_REF_LINE_NUM,/o   0    o/
		TRX_DOC_REF_SEQ_NUM,/o   0    o/
		EPISODE_TYPE,       /o from pat o/
		PATIENT_ID,       /o from pat o/
		EPISODE_ID,       /o from pat o/
		VISIT_ID,       /o from pat o/
		SOURCE_DOC_REF,     /o   NULL       o/
		SOURCE_DOC_DATE,    /o   NULL       o/
		NARRATION,          /o   NULL       o/
		TRX_TYPE_CODE,      /o   F          o/
		DISTRIBUTION_AMT,   /o   tot_gross * -1     o/
		GL_INTERFACE_BY_ID, /o NULL o/
		GL_INTERFACE_DATE, /o NULL o/
		GL_INTERFACE_FLAG,  /o   N  o/
		ADDED_BY_ID,
		MODIFIED_BY_ID,         
		ADDED_DATE,             
		MODIFIED_DATE,          
		ADDED_AT_WS_NO,         
		ADDED_FACILITY_ID,      
		MODIFIED_AT_WS_NO,      
		MODIFIED_FACILITY_ID,
		CASH_CTRL_DOC_TYPE,     
		CASH_CTRL_DOC_NUMBER,   
		CASH_CTRL_DOC_DATE,
		CUST_CODE
	   )
       VALUES
	  (
	       :nd_operating_facility_id,	
	       :bl_dept_main_acc1_code,
	       :bl_dept_main_acc2_code,
	       :bl_dept_dept_code,
	       :bl_dept_subledger_group_code,
	       :bl_dept_subledger_line_code,
	       :bl_dept_product_group_code,
	       :bl_dept_product_line_code,
	       /o
	       :nd_year,
	       :nd_month,
	       o/
	       nvl(:nd_post_year, TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'YYYY')),
	       nvl(:nd_post_month, TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'MM')),
	       TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),
	       :bl_store_trx_doc_ref,
		   DECODE(:l_group_posting_yn,'Y',0,:bl_store_trx_doc_ref_line_no),
		   DECODE(:l_group_posting_yn,'Y',0,:bl_store_trx_doc_ref_seq_no),
	       :bl_store_episode_type,
	       :bl_store_patient_id,
	       :bl_store_episode_id,
	       :bl_store_visit_id,
	       NULL,
	       NULL,
	       :l_temp_narration,
	       'F',
	       -1 * :bl_tot_gross_charge_amt,
	       NULL,
	       NULL,
	       'N',
	       user,
	       user,
	       sysdate,
	       sysdate,
	       :nd_ws_no,
	       :nd_operating_facility_id,
	       :nd_ws_no,
	       :nd_operating_facility_id,
	       :nd_pre_doc_type_code,
	       :nd_pre_doc_num,
    	   :nd_pre_doc_date,
	       :nd_pre_cust_code
	   ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 84;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (OPERATING_FACILITY_ID,MAI\
N_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,\
PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF\
,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,V\
ISIT_ID,SOURCE_DOC_REF,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AM\
T,GL_INTERFACE_BY_ID,GL_INTERFACE_DATE,GL_INTERFACE_FLAG,ADDED_BY_ID,MODIFIED_\
BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS\
_NO,MODIFIED_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_CTRL_DOC\
_DATE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,nvl(:b8,TO_CHAR(TO_DA\
TE(:b9,'DD/MM/YYYY'),'YYYY')),nvl(:b10,TO_CHAR(TO_DATE(:b9,'DD/MM/YYYY'),'MM')\
),TO_DATE(:b9,'DD/MM/YYYY'),:b13,DECODE(:b14,'Y',0,:b15),DECODE(:b14,'Y',0,:b1\
7),:b18,:b19,:b20,:b21,null ,null ,:b22,'F',((-1)* :b23),null ,null ,'N',user,\
user,sysdate,sysdate,:b24,:b0,:b24,:b0,:b28,:b29,:b30,:b31)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1857;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_dept_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_dept_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_dept_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_dept_subledger_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_dept_subledger_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_dept_product_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bl_dept_product_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_post_year;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[9] = (unsigned int  )15;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_post_month;
    sqlstm.sqhstl[10] = (unsigned int  )5;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[11] = (unsigned int  )15;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[12] = (unsigned int  )15;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&bl_store_trx_doc_ref;
    sqlstm.sqhstl[13] = (unsigned int  )53;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&l_group_posting_yn;
    sqlstm.sqhstl[14] = (unsigned int  )7;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&bl_store_trx_doc_ref_line_no;
    sqlstm.sqhstl[15] = (unsigned int  )12;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&l_group_posting_yn;
    sqlstm.sqhstl[16] = (unsigned int  )7;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&bl_store_trx_doc_ref_seq_no;
    sqlstm.sqhstl[17] = (unsigned int  )12;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&bl_store_episode_type;
    sqlstm.sqhstl[18] = (unsigned int  )4;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&bl_store_patient_id;
    sqlstm.sqhstl[19] = (unsigned int  )23;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&bl_store_episode_id;
    sqlstm.sqhstl[20] = (unsigned int  )11;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&bl_store_visit_id;
    sqlstm.sqhstl[21] = (unsigned int  )7;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&l_temp_narration;
    sqlstm.sqhstl[22] = (unsigned int  )102;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&bl_tot_gross_charge_amt;
    sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[24] = (unsigned int  )33;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[25] = (unsigned int  )5;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[26] = (unsigned int  )33;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[27] = (unsigned int  )5;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&nd_pre_doc_type_code;
    sqlstm.sqhstl[28] = (unsigned int  )9;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&nd_pre_doc_num;
    sqlstm.sqhstl[29] = (unsigned int  )11;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&nd_pre_doc_date;
    sqlstm.sqhstl[30] = (unsigned int  )37;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&nd_pre_cust_code;
    sqlstm.sqhstl[31] = (unsigned int  )11;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
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
       err_mesg("INSERT failed on table BL_GL_DISTRIBUTION",0,"");

}

create_bl_gl_dist_trx_ref()
{

    if( (bl_store_episode_type.arr[0] == 'I' && d_ip_gl_yn == 'N') ||
        (bl_store_episode_type.arr[0] == 'D' && d_ip_gl_yn == 'N') || 
	(bl_store_episode_type.arr[0] == 'O' && d_op_gl_yn == 'N') ||
        (bl_store_episode_type.arr[0] == 'E' && d_op_gl_yn == 'N') ||
	(bl_store_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N') )
	 return;	
	
	if (bl_store_trx_doc_ref.arr[0] == '\0')
			return;	

	nd_post_month.arr[0] = '\0';
	nd_post_month.len = 0;

        nd_post_year.arr[0] = '\0';
	nd_post_year.len = 0;
	

        /* exec sql select nvl(acc_per_year, to_char(to_date(:bl_store_trx_date,'DD/MM/YYYY'),'YYYY')),
        nvl(acc_per_month,to_char(to_date(:bl_store_trx_date,'DD/MM/YYYY'),'MM'))  
	into :nd_post_year, :nd_post_month
	from sy_acc_period_defn
	where to_date(:bl_store_trx_date,'DD/MM/YYYY') 
	between acc_per_start_date and acc_per_end_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 84;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select nvl(acc_per_year,to_char(to_date(:b0,'DD/MM/YY\
YY'),'YYYY')) ,nvl(acc_per_month,to_char(to_date(:b0,'DD/MM/YYYY'),'MM')) into\
 :b2,:b3  from sy_acc_period_defn where to_date(:b0,'DD/MM/YYYY') between acc_\
per_start_date and acc_per_end_date";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2000;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&bl_store_trx_date;
        sqlstm.sqhstl[0] = (unsigned int  )15;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&bl_store_trx_date;
        sqlstm.sqhstl[1] = (unsigned int  )15;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_post_year;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_post_month;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&bl_store_trx_date;
        sqlstm.sqhstl[4] = (unsigned int  )15;
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

	

	nd_post_month.arr[nd_post_month.len] = '\0';
	nd_post_year.arr[nd_post_year.len] = '\0';

	l_temp_narration.arr[0] = '\0';
	l_temp_narration.len = 0;

	if((strcmp(l_cash_ctrl_rcpt_in_use.arr,"Y")==0) && (strcmp(l_allow_unbilled_folio.arr,"Y")==0) &&
	   (nd_pre_doc_type_code.arr[0]=='\0'))
	{
		strcpy(l_temp_narration.arr,l_unbilled_remarks.arr);
		l_temp_narration.len = strlen(l_temp_narration.arr);
	}	


    /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
	      (
		OPERATING_FACILITY_ID,
		MAIN_ACC1_CODE,
		MAIN_ACC2_CODE,
		DEPT_CODE,
		SUBLEDGER_GROUP_CODE,
		SUBLEDGER_LINE_CODE,
		PRODUCT_GROUP_CODE,
		PRODUCT_LINE_CODE,
		POST_YEAR,           /o  accepted o/
		POST_MONTH,           /o  accepted o/
		TRX_DATE,            /o from pat o/
		TRX_DOC_REF,            /o from pat o/
		TRX_DOC_REF_LINE_NUM,/o   0    o/
		TRX_DOC_REF_SEQ_NUM,/o   0    o/
		EPISODE_TYPE,       /o from pat o/
		PATIENT_ID,       /o from pat o/
		EPISODE_ID,       /o from pat o/
		VISIT_ID,       /o from pat o/
		SOURCE_DOC_REF,     /o   NULL       o/
		SOURCE_DOC_DATE,    /o   NULL       o/
		NARRATION,          /o   NULL       o/
		TRX_TYPE_CODE,      /o   F          o/
		DISTRIBUTION_AMT,   /o   bl_tot_disc_amt, o/
		GL_INTERFACE_BY_ID, /o NULL o/
		GL_INTERFACE_DATE, /o NULL o/
		GL_INTERFACE_FLAG,   /o   N  o/
		ADDED_BY_ID,
		MODIFIED_BY_ID,         
	        ADDED_DATE,             
                MODIFIED_DATE,          
                ADDED_AT_WS_NO,         
                ADDED_FACILITY_ID,      
                MODIFIED_AT_WS_NO,      
                MODIFIED_FACILITY_ID    	,
	 	CASH_CTRL_DOC_TYPE,     
		CASH_CTRL_DOC_NUMBER,   
		CASH_CTRL_DOC_DATE,
		CUST_CODE     		        	   	
	   )
       VALUES
	  (
	        :nd_operating_facility_id,	
	        :bl_pkg2_main_acc1_code,
	        :bl_pkg2_main_acc2_code,
	        :bl_pkg2_dept_code,
	        :bl_pkg2_subledger_group_code,
	        :bl_pkg2_subledger_line_code,
	        :bl_pkg2_product_group_code,
	        :bl_pkg2_product_line_code,
	       /o
	       :nd_year,
	       :nd_month,
	       o/
	        nvl(:nd_post_year, TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'YYYY')),
	        nvl(:nd_post_month, TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'MM')),
	        TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),
	       :bl_store_trx_doc_ref,
		   DECODE(:l_group_posting_yn,'Y',0,:bl_store_trx_doc_ref_line_no),
		   DECODE(:l_group_posting_yn,'Y',0,:bl_store_trx_doc_ref_seq_no),
	       :bl_store_episode_type,
	       :bl_store_patient_id,
	       :bl_store_episode_id,
	       :bl_store_visit_id,
	       NULL,
	       NULL,
	       :l_temp_narration,
	       'F',
	       :bl_tot_net_charge_amt,
	       NULL,
	       NULL,
	       'N',
	       user,
	       user,
	       sysdate,
	       sysdate,
	       :nd_ws_no,
	       :nd_operating_facility_id,
	       :nd_ws_no,
	       :nd_operating_facility_id,
	       :nd_pre_doc_type_code,
	       :nd_pre_doc_num,
	       :nd_pre_doc_date,
	       :nd_pre_cust_code
	     ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 84;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (OPERATING_FACILITY_ID,MAI\
N_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,\
PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF\
,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,V\
ISIT_ID,SOURCE_DOC_REF,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AM\
T,GL_INTERFACE_BY_ID,GL_INTERFACE_DATE,GL_INTERFACE_FLAG,ADDED_BY_ID,MODIFIED_\
BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS\
_NO,MODIFIED_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_CTRL_DOC\
_DATE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,nvl(:b8,TO_CHAR(TO_DA\
TE(:b9,'DD/MM/YYYY'),'YYYY')),nvl(:b10,TO_CHAR(TO_DATE(:b9,'DD/MM/YYYY'),'MM')\
),TO_DATE(:b9,'DD/MM/YYYY'),:b13,DECODE(:b14,'Y',0,:b15),DECODE(:b14,'Y',0,:b1\
7),:b18,:b19,:b20,:b21,null ,null ,:b22,'F',:b23,null ,null ,'N',user,user,sys\
date,sysdate,:b24,:b0,:b24,:b0,:b28,:b29,:b30,:b31)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2035;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_pkg2_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_pkg2_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_pkg2_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_pkg2_subledger_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_pkg2_subledger_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_pkg2_product_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bl_pkg2_product_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_post_year;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[9] = (unsigned int  )15;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_post_month;
    sqlstm.sqhstl[10] = (unsigned int  )5;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[11] = (unsigned int  )15;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[12] = (unsigned int  )15;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&bl_store_trx_doc_ref;
    sqlstm.sqhstl[13] = (unsigned int  )53;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&l_group_posting_yn;
    sqlstm.sqhstl[14] = (unsigned int  )7;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&bl_store_trx_doc_ref_line_no;
    sqlstm.sqhstl[15] = (unsigned int  )12;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&l_group_posting_yn;
    sqlstm.sqhstl[16] = (unsigned int  )7;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&bl_store_trx_doc_ref_seq_no;
    sqlstm.sqhstl[17] = (unsigned int  )12;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&bl_store_episode_type;
    sqlstm.sqhstl[18] = (unsigned int  )4;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&bl_store_patient_id;
    sqlstm.sqhstl[19] = (unsigned int  )23;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&bl_store_episode_id;
    sqlstm.sqhstl[20] = (unsigned int  )11;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&bl_store_visit_id;
    sqlstm.sqhstl[21] = (unsigned int  )7;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&l_temp_narration;
    sqlstm.sqhstl[22] = (unsigned int  )102;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&bl_tot_net_charge_amt;
    sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[24] = (unsigned int  )33;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[25] = (unsigned int  )5;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[26] = (unsigned int  )33;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[27] = (unsigned int  )5;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&nd_pre_doc_type_code;
    sqlstm.sqhstl[28] = (unsigned int  )9;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&nd_pre_doc_num;
    sqlstm.sqhstl[29] = (unsigned int  )11;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&nd_pre_doc_date;
    sqlstm.sqhstl[30] = (unsigned int  )37;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&nd_pre_cust_code;
    sqlstm.sqhstl[31] = (unsigned int  )11;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
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
		err_mesg("INSERT failed on table BL_GL_DISTRIBUTION - 3",0,"");
}

continue_to_next_ref()
{
    /* EXEC SQL ROLLBACK WORK TO SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 84;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "rollback work  to LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2178;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
		err_mesg("ROLLBACK TO LAST_DOC_REF failed",0,""); 
}

upd_pat_chg_folio()
{


/* EXEC SQL UPDATE /o+INDEX(BL_PATIENT_CHARGES_FOLIO BL_PATIENT_CHARGES_FOLIO_I1) USE BL_PATIENT_CHARGES_FOLIO_I1o/ 
	     BL_PATIENT_CHARGES_FOLIO
	     SET DF_UPD_FLAG = DECODE(DF_SERVICE_IND,'D','Y',DF_UPD_FLAG),
	     TRX_POSTED_IND			= 'Y',
	     POSTED_BY_ID			=  USER,
	     POSTED_DATE			=  SYSDATE,
	     MODIFIED_BY_ID			= user,
	     MODIFIED_DATE			= SYSDATE,
	     ADDED_AT_WS_NO			= :nd_ws_no,
	     ADDED_FACILITY_ID		= :nd_operating_facility_id,
	     MODIFIED_AT_WS_NO		= :nd_ws_no,
	     MODIFIED_FACILITY_ID	= :nd_operating_facility_id,
	     UNPOSTED_REASON			= NULL,
	     ACCT_DEPT_CODE = DECODE(ACCT_DEPT_CODE,null,:bl_pat_acct_dept_code,ACCT_DEPT_CODE),
	     ORIG_DEPT_CODE = decode(ORIG_DEPT_CODE, null,:bl_pat_orig_dept_code,ORIG_DEPT_CODE)
	WHERE OPERATING_FACILITY_ID	= :nd_operating_facility_id
	AND TRX_DOC_REF = :bl_store_trx_doc_ref
	AND TRX_DOC_REF_LINE_NUM	= TRX_DOC_REF_LINE_NUM 
	AND TRX_DOC_REF_SEQ_NUM		= TRX_DOC_REF_SEQ_NUM  
	AND NVL(TRX_POSTED_IND,'X') = 'N'	
	AND TRX_DATE	  <= TO_DATE(:nd_post_upto_date||' 23:59:59','DD/MM/YYYY HH24:MI:SS')
	AND NVL(TRX_FINALIZE_IND,'N') = 'Y'
	AND (EPISODE_TYPE not in ('O','E') OR 
	(EPISODE_TYPE  in ('O','E') AND NVL(AVAILED_IND,'N') NOT IN ('Y','U','C'))); */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 84;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "update  /*+ INDEX(BL_PATIENT_CHARGES_FOLIO BL_PATIENT_CHARGES\
_FOLIO_I1) USE BL_PATIENT_CHARGES_FOLIO_I1 +*/ BL_PATIENT_CHARGES_FOLIO  set D\
F_UPD_FLAG=DECODE(DF_SERVICE_IND,'D','Y',DF_UPD_FLAG),TRX_POSTED_IND='Y',POSTE\
D_BY_ID=USER,POSTED_DATE=SYSDATE,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADD\
ED_AT_WS_NO=:b0,ADDED_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_\
ID=:b1,UNPOSTED_REASON=null ,ACCT_DEPT_CODE=DECODE(ACCT_DEPT_CODE,null ,:b4,AC\
CT_DEPT_CODE),ORIG_DEPT_CODE=decode(ORIG_DEPT_CODE,null ,:b5,ORIG_DEPT_CODE) w\
here (((((((OPERATING_FACILITY_ID=:b1 and TRX_DOC_REF=:b7) and TRX_DOC_REF_LIN\
E_NUM=TRX_DOC_REF_LINE_NUM) and TRX_DOC_REF_SEQ_NUM=TRX_DOC_REF_SEQ_NUM) and N\
VL(TRX_POSTED_IND,'X')='N') and TRX_DATE<=TO_DATE((:b8||' 23:59:59'),'DD/MM/YY\
YY HH24:MI:SS')) and NVL(TRX_FINALIZE_IND,'N')='Y') and (EPISODE_TYPE not  in \
('O','E') or (EPISODE_TYPE in ('O','E') and NVL(AVAILED_IND,'N') not  in ('Y',\
'U','C'))))";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2193;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
sqlstm.sqhstl[0] = (unsigned int  )33;
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
sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
sqlstm.sqhstl[2] = (unsigned int  )33;
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
sqlstm.sqhstv[4] = (         void  *)&bl_pat_acct_dept_code;
sqlstm.sqhstl[4] = (unsigned int  )13;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&bl_pat_orig_dept_code;
sqlstm.sqhstl[5] = (unsigned int  )13;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
sqlstm.sqhstl[6] = (unsigned int  )5;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&bl_store_trx_doc_ref;
sqlstm.sqhstl[7] = (unsigned int  )53;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&nd_post_upto_date;
sqlstm.sqhstl[8] = (unsigned int  )13;
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






	/* EXEC SQL UPDATE BL_PATIENT_CHARGES_FOLIO
	SET DF_UPD_FLAG			= 'Y',
	TRX_POSTED_IND			= 'Y',
	MODIFIED_BY_ID			= user,
	MODIFIED_DATE			= SYSDATE,
	ADDED_AT_WS_NO			= :nd_ws_no,
	ADDED_FACILITY_ID		= :nd_operating_facility_id,
	MODIFIED_AT_WS_NO		= :nd_ws_no,
	MODIFIED_FACILITY_ID   = :nd_operating_facility_id,
	UNPOSTED_REASON		= NULL,
	ACCT_DEPT_CODE = DECODE(ACCT_DEPT_CODE,null,:bl_pat_acct_dept_code,ACCT_DEPT_CODE),
	ORIG_DEPT_CODE = decode(ORIG_DEPT_CODE, null,:bl_pat_orig_dept_code,ORIG_DEPT_CODE)
	WHERE ROWID	= :bl_pat_rowid; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 84;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_PATIENT_CHARGES_FOLIO  set DF_UPD_FLAG='Y',TRX_POS\
TED_IND='Y',MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED\
_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1,UNPOSTED_REASO\
N=null ,ACCT_DEPT_CODE=DECODE(ACCT_DEPT_CODE,null ,:b4,ACCT_DEPT_CODE),ORIG_DE\
PT_CODE=decode(ORIG_DEPT_CODE,null ,:b5,ORIG_DEPT_CODE) where ROWID=:b6";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2244;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[0] = (unsigned int  )33;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[2] = (unsigned int  )33;
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
 sqlstm.sqhstv[4] = (         void  *)&bl_pat_acct_dept_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_pat_orig_dept_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&bl_pat_rowid;
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
		err_mesg("UPDATE failed on table BL_PATIENT_CHARGES_FOLIO",0,"");
}

lock_trx_ref()
{
	bl_pat_rowid.arr[0] = '\0';
	bl_pat_rowid.len = 0;

   /* EXEC SQL OPEN LOCK_TRX_REF_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 84;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0023;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2287;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_pat_trx_doc_ref;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_group_posting_yn;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_doc_ref_line_num;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_group_posting_yn;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_doc_ref_seq_num;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_post_upto_date;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
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



   if (RESOURCE_BUSY)
   {
	 sprintf(msg_str,"Patient Charges folio rec %s-%s-%s is busy",
					  bl_pat_trx_doc_ref.arr,
					  bl_pat_trx_doc_ref_line_num.arr,
					  bl_pat_trx_doc_ref_seq_num.arr);
	 lock_msg(msg_str);
	 return (0);
   }
   else if (OERROR)
	 err_mesg("OPEN failed on cursor LOCK_TRX_REF_CUR",0,"");

	/* EXEC SQL FETCH lock_trx_ref_cur
	          INTO :bl_pat_rowid; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 84;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2330;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_pat_rowid;
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
		err_mesg("FETCH failed on CURSOR lock_trx_ref_cur",0,"");

	bl_pat_rowid.arr[bl_pat_rowid.len] = '\0';

	return 1;
}

loc_log_msg(str)
char str[];
{
  disp_message(INFO_MESG, str);
  if (strlen(str) > 70)
      str[70] = '\0';
  if (err_ctr == 0)
       continue_to_next_ref();
  log_err_mesg(str,0,"");
  err_ctr++;
}

lock_msg(str)
char str[];
{
  if (strlen(str) > 70)
      str[70] = '\0';
  log_err_mesg(str,0,"");
}


trx_ref_break()
{



    if (rec_ctr!=1||strcmp(l_group_posting_yn.arr,"N")==0)
    {
		//if(strcmp("OR-IPEN0404-00000136",bl_pat_trx_doc_ref.arr))
		
		 //strcpy(store_acct_dept_code.arr,bl_pat_acct_dept_code.arr); //HARI
		//store_acct_dept_code.len = strlen(store_acct_dept_code.arr);//HARI
	  				
			
		dept_break();

		if (!err_ctr)
		{
			//if(strcmp("OR-IPEN0404-00000136",bl_pat_trx_doc_ref.arr))
	

			create_bl_gl_dist_trx_ref();

			upd_pat_chg_folio();



			err_ctr = 0;
		}

		/* EXEC SQL COMMIT WORK; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 84;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2349;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   
		if (OERROR)
	      err_mesg("COMMIT failed",0,""); 
	}


    
	err_ctr					= 0;
    bl_tot_gross_charge_amt = 0;
    bl_tot_disc_amt			= 0;
    bl_tot_net_charge_amt	= 0;

    /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 84;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "savepoint LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2364;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
		err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

	  strcpy(bl_store_trx_doc_ref.arr,bl_pat_trx_doc_ref.arr);
	  bl_store_trx_doc_ref.len = strlen(bl_store_trx_doc_ref.arr);

	  strcpy(bl_store_trx_doc_ref_line_no.arr,bl_pat_trx_doc_ref_line_num.arr);
	  bl_store_trx_doc_ref_line_no.len = strlen(bl_store_trx_doc_ref_line_no.arr);
	  
	  strcpy(bl_store_trx_doc_ref_seq_no.arr,bl_pat_trx_doc_ref_seq_num.arr);
	  bl_store_trx_doc_ref_seq_no.len = strlen(bl_store_trx_doc_ref_seq_no.arr);

	  strcpy(bl_store_trx_date.arr,bl_pat_trx_date.arr);
	  bl_store_trx_date.len = strlen(bl_store_trx_date.arr);

	  strcpy(bl_store_episode_type.arr,bl_pat_episode_type.arr);
	  bl_store_episode_type.len = strlen(bl_store_episode_type.arr);

	  strcpy(bl_store_patient_id.arr,bl_pat_patient_id.arr);
	  bl_store_patient_id.len = strlen(bl_store_patient_id.arr);

	  strcpy(bl_store_episode_id.arr,bl_pat_episode_id.arr);
	  bl_store_episode_id.len = strlen(bl_store_episode_id.arr);

	  strcpy(bl_store_visit_id.arr,bl_pat_visit_id.arr);
	  bl_store_visit_id.len = strlen(bl_store_visit_id.arr);

	  strcpy(store_concat_code.arr,bl_pat_concat_code.arr);
	  store_concat_code.len = strlen(store_concat_code.arr);

	  strcpy(store_acct_dept_code.arr,bl_pat_acct_dept_code.arr);
	  store_acct_dept_code.len = strlen(store_acct_dept_code.arr);

	  fetch_bl_gl_account_trx_ref();
	 

		
	  if (rec_ctr != 1)
	     fetch_bl_gl_account_pkg();


}


concat_break()
{
				
			
       dept_break();
       //commented and moved couple of line down.
	   //fetch_bl_gl_account_pkg();
       strcpy(store_concat_code.arr,bl_pat_concat_code.arr);
       store_concat_code.len = strlen(store_concat_code.arr);
	 //change made by Harish on 03/09/2002 for 
	 //dept code issue

	 
	 fetch_bl_gl_account_pkg();
}

dept_break()
{




    if (store_acct_dept_code.arr[0] != '\0')
    {
       if (!err_ctr)
       {
	 	if (rec_ctr != 1)
	 	{
	     		create_bl_gl_dist_dept();
	     		bl_tot_gross_charge_amt = 0;
	     		bl_tot_disc_amt         = 0;
	 	}
       }
     }



     strcpy(store_acct_dept_code.arr,bl_pat_acct_dept_code.arr);
     store_acct_dept_code.len = strlen(store_acct_dept_code.arr);
	 //Introduced by Harish 03/09/2002 for 
	 //dept code issue
     

     fetch_bl_gl_account_pkg();



}

upd_reasons_in_folio_for_unposting()
{
        /*
	If folio is unbilled, there will be no bill and hence no cash control against the folio
	service. So to facilitate posting of unbilled records, the below conditions were commented.
	 */

	 nd_reason_text.arr[0] =  '\0';
	 nd_reason_text.len    = 0;

	 if((strcmp(l_cash_ctrl_rcpt_in_use.arr,"Y")==0) && (strcmp(l_allow_unbilled_folio.arr,"N")==0) && nd_can_rec_ctr == 0)
	 {		  
		 if (nd_doc_type_code.arr[0] == '\0' &&  nd_cash_control_use_flag == 'Y')
			   strcpy(nd_reason_text.arr,"No Cash Control Document Type is available for this record");     
		 
		 else if (nd_doc_num.arr[0] == '\0' && nd_cash_control_use_flag == 'Y')
			   strcpy(nd_reason_text.arr,"No Cash Control Document Number is available for this record");     
		 
		 else if (nd_doc_date.arr[0] == '\0' && nd_cash_control_use_flag == 'Y')
			   strcpy(nd_reason_text.arr,"No Cash Control Document Date is available for this record");     

		 else if (nd_cash_counter_code.arr[0] == '\0')
			strcpy(nd_reason_text.arr,"No cash counter code is available in this record");  
		
		 else if (nd_shift_id.arr[0] == '\0')
			   strcpy(nd_reason_text.arr,"No Shift Id is available for this record");     
          } 
	  
	  if (bl_pat_orig_dept_code.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No original Dept code is available for this record");     		
      
	  else if (bl_pat_physician_id.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Physician Id is available for this record");     		
      
	  else if (bl_pat_blng_class_code.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Billing Class Code is available for this record");     		

	  else if (bl_pat_bill_type_code.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Bill Type Code is available for this record");     							   

	  else if (bl_pat_service_date.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Service Date is available for this record");     		
           
	  else if (bl_pat_blng_serv_code.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Billing Service Code is available for this record");     		
           
	  else if (bl_pat_episode_type.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Episode Type is available for this record");     		
           
	  else if (bl_pat_settlement_ind.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Settlement Indicator is available for this record");     		
           
	  else if (bl_pat_blng_grp_id.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Billing Group Id  is available for this record");     		
           
	  else if (bl_pat_patient_id.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Patient Id  is available for this record");    

	  else if (nd_confirmed_yn.arr[0] != 'Y' && nd_reason_text.arr[0] == '\0' &&
	       strcmp(nd_trx_status.arr,"C") != 0 && strcmp(l_cash_ctrl_rcpt_in_use.arr,"Y") !=0 )
	   {
	   strcpy(nd_reason_text.arr,"Billing Service is not confirmed");     			   
	   }  
	   nd_reason_text.len = strlen(nd_reason_text.arr);	

	  if (nd_reason_text.arr[0])  
	   {
		l_temp_reason.len		= 0;
		l_temp_reason.arr[0]	= '\0';	
			
		strcpy(l_temp_reason.arr,nd_reason_text.arr);
		l_temp_reason.len = strlen(l_temp_reason.arr);	

		strcat(l_temp_reason.arr,"-");
		l_temp_reason.len = strlen(l_temp_reason.arr);		
		  
		strcat(l_temp_reason.arr,bl_pat_trx_doc_ref.arr);
		l_temp_reason.len = strlen(l_temp_reason.arr);		

		loc_log_msg(l_temp_reason.arr);         
		//return;
          } 

      

     if (nd_reason_text.len>0)
     {
		 /*
		   This is a folio posting program and hence Bills records need not be 
		   updated with Unposted Reason - 27/01/2004 Harish.	


		 EXEC SQL UPDATE BL_BILL_HDR
			  SET  UNPOSTED_REASON = :nd_reason_text,
			   BILL_POSTED_FLAG = 'N',  
			   MODIFIED_BY_ID             = user,
				   MODIFIED_DATE          = SYSDATE,
				   MODIFIED_AT_WS_NO      = :nd_ws_no,
			   MODIFIED_FACILITY_ID       = :nd_operating_facility_id
				  WHERE DOC_TYPE_CODE     = :bl_pat_bill_doc_type_code
			  AND   DOC_NUM	   = :bl_pat_bill_doc_num ;


		if (OERROR)
			err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");*/

		//sprintf(l_mesg,"Trx Doc Ref : %s   Cash Counter Code : %s   Shift Id : %s   Doc Type Code/Num/Date : %s %s %s",bl_pat_trx_doc_ref.arr, nd_cash_counter_code.arr, nd_shift_id.arr, nd_doc_type_code.arr, nd_doc_num.arr, nd_doc_date.arr);
		//disp_message(ERR_MESG,l_mesg);


		/* EXEC SQL UPDATE /o+INDEX(BL_PATIENT_CHARGES_FOLIO BL_PATIENT_CHARGES_FOLIO_I1) USE BL_PATIENT_CHARGES_FOLIO_I1o/ 
				 BL_PATIENT_CHARGES_FOLIO
		     SET UNPOSTED_REASON		= SUBSTR(:nd_reason_text,1,50),
		         TRX_POSTED_IND			= 'N',
		    	 MODIFIED_BY_ID			= USER,
	             MODIFIED_DATE			= SYSDATE,
	             MODIFIED_AT_WS_NO		= :nd_ws_no,
		    	 MODIFIED_FACILITY_ID   = :nd_operating_facility_id
		   WHERE trx_doc_ref			= :bl_pat_trx_doc_ref
		     AND trx_doc_ref_line_num	= :bl_pat_trx_doc_ref_line_num
			 AND trx_doc_ref_seq_num	= :bl_pat_trx_doc_ref_seq_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 84;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update  /*+ INDEX(BL_PATIENT_CHARGES_FOLIO BL_PATIENT_CHARG\
ES_FOLIO_I1) USE BL_PATIENT_CHARGES_FOLIO_I1 +*/ BL_PATIENT_CHARGES_FOLIO  set\
 UNPOSTED_REASON=SUBSTR(:b0,1,50),TRX_POSTED_IND='N',MODIFIED_BY_ID=USER,MODIF\
IED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1,MODIFIED_FACILITY_ID=:b2 where ((trx_do\
c_ref=:b3 and trx_doc_ref_line_num=:b4) and trx_doc_ref_seq_num=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2379;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_reason_text;
  sqlstm.sqhstl[0] = (unsigned int  )302;
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
  sqlstm.sqhstv[3] = (         void  *)&bl_pat_trx_doc_ref;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_doc_ref_line_num;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&bl_pat_trx_doc_ref_seq_num;
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



		//WHERE ROWID				= :bl_pat_rowid;
		   //Rowid should not be used in this place....Rowid not fetched at this place...it is 
		   //fetched after this place...so always old rowid will be updated here.
		   //Commented by Harish on 05/05/2004
		if (OERROR)
		   err_mesg("UPDATE failed on table BL_PATIENT_CHARGES_FOLIO",0,"");
    }
}

upd_folio_unpost_reason()
{

///*+INDEX(BL_PATIENT_CHARGES_FOLIO BL_PATIENT_CHARGES_FOLIO_I1) USE BL_PATIENT_CHARGES_FOLIO_I1*/ 
/*PRAGMA AUTONOMOUS_TRANSACTION;*/

/* EXEC SQL EXECUTE 
BEGIN

	UPDATE BL_PATIENT_CHARGES_FOLIO
	SET UNPOSTED_REASON		= substr(:msg_str_var,1,50)
	WHERE operating_facility_id = :nd_operating_facility_id
	AND trx_doc_ref		= :bl_pat_trx_doc_ref
	AND trx_doc_ref_line_num	= :bl_pat_trx_doc_ref_line_num
	AND trx_doc_ref_seq_num	= :bl_pat_trx_doc_ref_seq_num;	
exception
when others then 
	null;
END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 84;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin UPDATE BL_PATIENT_CHARGES_FOLIO SET UNPOSTED_REASON = s\
ubstr ( :msg_str_var , 1 , 50 ) WHERE operating_facility_id = :nd_operating_fa\
cility_id AND trx_doc_ref = :bl_pat_trx_doc_ref AND trx_doc_ref_line_num = :bl\
_pat_trx_doc_ref_line_num AND trx_doc_ref_seq_num = :bl_pat_trx_doc_ref_seq_nu\
m ; exception when others then null ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2418;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)msg_str_var;
sqlstm.sqhstl[0] = (unsigned int  )1000;
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
sqlstm.sqhstv[2] = (         void  *)&bl_pat_trx_doc_ref;
sqlstm.sqhstl[2] = (unsigned int  )23;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&bl_pat_trx_doc_ref_line_num;
sqlstm.sqhstl[3] = (unsigned int  )7;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_doc_ref_seq_num;
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

 

}

