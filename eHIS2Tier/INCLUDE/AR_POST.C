
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
           char  filnam[27];
};
static const struct sqlcxp sqlfpn =
{
    26,
    "T:\\temp\\Finance\\AR_POST.PC"
};


static unsigned long sqlctx = 931066571;


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
            void  *sqhstv[58];
   unsigned int   sqhstl[58];
            int   sqhsts[58];
            void  *sqindv[58];
            int   sqinds[58];
   unsigned int   sqharm[58];
   unsigned int   *sqharc[58];
   unsigned short  sqadto[58];
   unsigned short  sqtdso[58];
} sqlstm = {10,58};

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
"select DOC_TYPE_CODE ,DOC_NUM ,INV_DOC_TYPE_CODE ,INV_DOC_NUM ,BILL_DOC_TYPE\
_CODE ,BILL_NUM ,NVL(AMOUNT,0) ,ABS(nvl(AMOUNT,0)) ,ROWID  from AR_PATIENT_ALL\
OC_DTLS where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) order by DOC_TYPE_CODE,DOC_N\
UM            ";

 static const char *sq0007 = 
"select NVL(ACC_ENTITY_CODE,' ') ,DOC_TYPE_CODE ,DOC_NUM ,ORG_DOC_TYPE_CODE ,\
ORG_DOC_NUM ,NVL(LAST_LINE_NUM,0) ,NVL(CUST_CODE,' ') ,NVL(NARRATION,' ') ,TO_\
CHAR(BASE_DATE,'DD/MM/YYYY') ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,NVL(GROSS_AMT,0)\
 ,NVL(PAYABLE_AMT,0) ,NVL(DISCOUNT_AMT,0) ,NVL(DOC_AMT,0) ,NVL(CURRENCY_CODE,'\
 ') ,NVL(EXCHG_RATE,0) ,NVL(PMNT_TERMS_CODE,' ') ,TO_CHAR(SETTLEMENT_DATE,'DD/\
MM/YYYY') ,NVL(SETTLEMENT_PERC,0) ,NVL(CUST_REF,' ') ,NVL(PATIENT_ID,' ') ,NVL\
(BILLING_GROUP,' ') ,NVL(BILL_DOC_TYPE_CODE,' ') ,NVL(BILL_NUM,0) ,TO_CHAR(BIL\
L_DATE,'DD/MM/YYYY') ,NVL(DOCTOR_FEE_AMT,0) ,NVL(MAIN_ACC1_CODE,' ') ,NVL(MAIN\
_ACC2_CODE,' ') ,NVL(SUBLEDGER_GROUP_CODE,' ') ,NVL(SUBLEDGER_LINE_CODE,' ') ,\
NVL(DEPT_CODE,' ') ,NVL(PRODUCT_GROUP_CODE,' ') ,NVL(PRODUCT_LINE_CODE,' ') ,N\
VL(POST_MONTH,0) ,NVL(POST_YEAR,0) ,NVL(BILL_TYPE_CODE,' ') ,ROWID ,CONSOLIDAT\
ED_INV_YN  from AR_DN_INV_HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)       \
    ";

 static const char *sq0009 = 
"select NVL(ACC_ENTITY_CODE,' ') ,DOC_TYPE_CODE ,DOC_NUM ,ORG_DOC_TYPE_CODE ,\
ORG_DOC_NUM ,NVL(LAST_LINE_NUM,0) ,NVL(CUST_CODE,' ') ,NVL(NARRATION,' ') ,TO_\
CHAR(BASE_DATE,'DD/MM/YYYY') ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,NVL(GROSS_AMT,0)\
 ,NVL(PAYABLE_AMT,0) ,NVL(DISCOUNT_AMT,0) ,NVL(DOC_AMT,0) ,NVL(CURRENCY_CODE,'\
 ') ,NVL(EXCHG_RATE,0) ,NVL(PMNT_TERMS_CODE,' ') ,TO_CHAR(SETTLEMENT_DATE,'DD/\
MM/YYYY') ,NVL(SETTLEMENT_PERC,0) ,NVL(CUST_REF,' ') ,NVL(PATIENT_ID,' ') ,NVL\
(BILLING_GROUP,' ') ,NVL(BILL_DOC_TYPE_CODE,' ') ,NVL(BILL_NUM,0) ,TO_CHAR(BIL\
L_DATE,'DD/MM/YYYY') ,NVL(DOCTOR_FEE_AMT,0) ,NVL(MAIN_ACC1_CODE,' ') ,NVL(MAIN\
_ACC2_CODE,' ') ,NVL(SUBLEDGER_GROUP_CODE,' ') ,NVL(SUBLEDGER_LINE_CODE,' ') ,\
NVL(DEPT_CODE,' ') ,NVL(PRODUCT_GROUP_CODE,' ') ,NVL(PRODUCT_LINE_CODE,' ') ,N\
VL(POST_MONTH,0) ,NVL(POST_YEAR,0) ,NVL(BILL_TYPE_CODE,' ') ,ROWID ,CONSOLIDAT\
ED_INV_YN  from AR_CN_INV_HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)       \
    ";

 static const char *sq0011 = 
"E,' ') ,NVL(MISC_CUST_SHORT_NAME_CHINESE,' ') ,NVL(MISC_CUST_ADD1_DESC_CHINE\
SE,' ') ,NVL(MISC_CUST_ADD2_DESC_CHINESE,' ') ,NVL(MISC_CUST_ADD3_DESC_CHINESE\
,' ') ,NVL(MISC_CUST_ZIP_DESC_CHINESE,' ') ,NVL(TEL_NUM,' ') ,NVL(CONTACT_NAME\
,' ') ,NVL(CONTACT_NAME_TITLE,' ') ,ROWID ,NVL(ADJ_TYPE,' ') ,NVL(BILL_TYPE_CO\
DE,' ') ,CONSOLIDATED_INV_YN  from AR_ADJ_INV_HDR where (DOC_TYPE_CODE=:b0 and\
 DOC_NUM=:b1)           ";

 static const char *sq0008 = 
"select NVL(ACC_ENTITY_CODE,' ') ,DOC_TYPE_CODE ,DOC_NUM ,ORG_DOC_TYPE_CODE ,\
ORG_DOC_NUM ,LINE_NUM ,NVL(MAIN_ACC1_CODE,' ') ,NVL(MAIN_ACC2_CODE,' ') ,NVL(S\
UBLEDGER_GROUP_CODE,' ') ,NVL(SUBLEDGER_LINE_CODE,' ') ,NVL(DEPT_CODE,' ') ,NV\
L(PRODUCT_GROUP_CODE,' ') ,NVL(PRODUCT_LINE_CODE,' ') ,NVL(AMOUNT,0) ,NVL(NARR\
ATION,' ') ,ROWID  from AR_DN_LINE where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)\
 and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUM=:b3)           ";

 static const char *sq0010 = 
"select NVL(ACC_ENTITY_CODE,' ') ,DOC_TYPE_CODE ,DOC_NUM ,ORG_DOC_TYPE_CODE ,\
ORG_DOC_NUM ,LINE_NUM ,NVL(MAIN_ACC1_CODE,' ') ,NVL(MAIN_ACC2_CODE,' ') ,NVL(S\
UBLEDGER_GROUP_CODE,' ') ,NVL(SUBLEDGER_LINE_CODE,' ') ,NVL(DEPT_CODE,' ') ,NV\
L(PRODUCT_GROUP_CODE,' ') ,NVL(PRODUCT_LINE_CODE,' ') ,NVL(AMOUNT,0) ,NVL(NARR\
ATION,' ') ,ROWID  from AR_CN_LINE where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)\
 and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUM=:b3)           ";

 static const char *sq0012 = 
"select NVL(ACC_ENTITY_CODE,' ') ,DOC_TYPE_CODE ,DOC_NUM ,ORG_DOC_TYPE_CODE ,\
ORG_DOC_NUM ,LINE_NUM ,NVL(MAIN_ACC1_CODE,' ') ,NVL(MAIN_ACC2_CODE,' ') ,NVL(S\
UBLEDGER_GROUP_CODE,' ') ,NVL(SUBLEDGER_LINE_CODE,' ') ,NVL(DEPT_CODE,' ') ,NV\
L(PRODUCT_GROUP_CODE,' ') ,NVL(PRODUCT_LINE_CODE,' ') ,NVL(AMOUNT,0) ,NVL(NARR\
ATION,' ') ,ROWID  from AR_ADJ_LINE where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1\
) and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUM=:b3)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,381,0,3,194,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,
84,0,0,2,381,0,3,249,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,
163,0,0,3,469,0,3,300,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
214,0,0,4,130,0,5,368,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
237,0,0,5,130,0,5,381,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
260,0,0,6,131,0,5,394,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
283,0,0,13,246,0,9,656,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
306,0,0,13,0,0,13,683,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
357,0,0,14,1388,0,3,735,0,0,58,58,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,1,
0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,
604,0,0,15,202,0,5,863,0,0,5,5,0,1,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
639,0,0,16,123,0,4,875,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
670,0,0,17,147,0,5,897,0,0,5,5,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
705,0,0,18,335,0,3,919,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,
0,1,9,0,0,
784,0,0,19,132,0,5,963,0,0,4,4,0,1,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
815,0,0,20,293,0,3,986,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
858,0,0,21,132,0,5,1026,0,0,4,4,0,1,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
889,0,0,7,938,0,9,1045,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
912,0,0,9,938,0,9,1052,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
935,0,0,11,1436,0,9,1059,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
958,0,0,8,447,0,9,1072,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
989,0,0,10,447,0,9,1079,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1020,0,0,12,448,0,9,1086,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1051,0,0,22,833,0,4,1154,0,0,26,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,
1170,0,0,23,833,0,4,1217,0,0,26,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,
1289,0,0,24,247,0,4,1280,0,0,10,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1344,0,0,7,0,0,13,1426,0,0,38,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1511,0,0,9,0,0,13,1471,0,0,38,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1678,0,0,11,0,0,13,1549,0,0,54,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,
1909,0,0,8,0,0,13,1712,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
1988,0,0,10,0,0,13,1735,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
2067,0,0,12,0,0,13,1758,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
};


#include <stdio.h>
#include <math.h>
        
 
#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)
/*
#define DEBUG 0
*/  
/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hdr_rowid_passed                     [31],

            l_ar_hdr_doc_type_code                [7], 
            l_ar_hdr_doc_num                      [9],
            l_ar_hdr_cust_code                    [9],
            l_ar_hdr_doc_date                     [12],

            l_ar_hdr_acc_entity_code              [5],
            l_ar_hdr_doc_amt	                  [17],
            l_ar_hdr_post_month                   [3],
            l_ar_hdr_post_year                    [5],
            l_ar_hdr_misc_clong_name          [41],
            l_ar_hdr_misc_cshort_name         [16],
            l_ar_hdr_misc_cadd1_desc          [31],
            l_ar_hdr_misc_cadd2_desc          [31],
            l_ar_hdr_misc_cadd3_desc          [31],
            l_ar_hdr_misc_czip_desc           [31],
            l_ar_hdr_misc_long_chinese            [41],
            l_ar_hdr_misc_short_chinese           [16],
            l_ar_hdr_misc_add1_chinese            [31],
            l_ar_hdr_misc_add2_chinese            [31],
            l_ar_hdr_misc_add3_chinese            [31],
            l_ar_hdr_misc_zip_chinese             [31],
            l_ar_hdr_tel_num                      [31],
            l_ar_hdr_contact_name                 [41],
            l_ar_hdr_contact_name_title           [41],
            l_ar_hdr_error_flag                   [2],
            l_ar_hdr_print_flag                   [2],
            l_ar_hdr_rowid                        [31],

            l_ar_ihdr_acc_entity_code            [5],
            l_ar_ihdr_doc_type_code              [7],
            l_ar_ihdr_doc_num                    [9],
            l_ar_ihdr_org_doc_type_code          [7],
            l_ar_ihdr_org_doc_num                [9],
            l_ar_ihdr_last_line_num              [5],
            l_ar_ihdr_cust_code                  [8],
            l_ar_ihdr_narration                  [51],
            l_ar_ihdr_base_date                  [12],
            l_ar_ihdr_due_date                   [12],
            l_ar_ihdr_gross_amt                  [19],
            l_ar_ihdr_payable_amt                [19],
            l_ar_ihdr_discount_amt               [19],
            l_ar_ihdr_doc_amt                    [19],
            l_ar_ihdr_currency_code              [19],
            l_ar_ihdr_exchg_rate                 [20],
            l_ar_ihdr_pmnt_terms_code            [3],
            l_ar_ihdr_settlement_date            [12],
            l_ar_ihdr_settlement_perc            [7],
            l_ar_ihdr_cust_ref                   [16],
            l_ar_ihdr_patient_id                 [21],
            l_ar_ihdr_billing_group              [3],
            l_ar_ihdr_bill_doc_type_code         [7],
            l_ar_ihdr_bill_type_code             [2],
            l_ar_ihdr_bill_num                   [9],
            l_ar_ihdr_bill_date                  [12],
            l_ar_ihdr_doctor_fee_amt             [19],
            l_ar_ihdr_main_acc1_code             [7],
            l_ar_ihdr_main_acc2_code             [5],
            l_ar_ihdr_sub_group_code       [4],
            l_ar_ihdr_sub_line_code        [9],
            l_ar_ihdr_dept_code                  [7],
            l_ar_ihdr_product_group_code         [4],
            l_ar_ihdr_product_line_code          [5],
            l_ar_ihdr_post_month                 [3],
            l_ar_ihdr_post_year                  [5],
            l_ar_ihdr_rowid                      [31],
            l_ar_ihdr_adj_type                   [3],
			l_consolidated_yn                    [2],

            l_ar_line_acc_entity_code            [5],
            l_ar_line_doc_type_code              [7],
            l_ar_line_doc_num                    [9],
            l_ar_line_org_doc_type_code          [7],
            l_ar_line_org_doc_num                [9],
            l_ar_line_line_num                   [5],
            l_ar_line_main_acc1_code             [7],
            l_ar_line_main_acc2_code             [5],
            l_ar_line_sub_group_code       [4],
            l_ar_line_sub_line_code        [9],
            l_ar_line_dept_code                  [7],
            l_ar_line_product_group_code         [4],
            l_ar_line_product_line_code          [5],
            l_ar_line_amount                     [19],
            l_ar_line_narration                  [51],
            l_ar_line_rowid                      [31],
            l_ar_interface_code                    [2]; */ 
struct { unsigned short len; unsigned char arr[31]; } hdr_rowid_passed;

struct { unsigned short len; unsigned char arr[7]; } l_ar_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_hdr_doc_num;

struct { unsigned short len; unsigned char arr[9]; } l_ar_hdr_cust_code;

struct { unsigned short len; unsigned char arr[12]; } l_ar_hdr_doc_date;

struct { unsigned short len; unsigned char arr[5]; } l_ar_hdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[17]; } l_ar_hdr_doc_amt;

struct { unsigned short len; unsigned char arr[3]; } l_ar_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } l_ar_hdr_post_year;

struct { unsigned short len; unsigned char arr[41]; } l_ar_hdr_misc_clong_name;

struct { unsigned short len; unsigned char arr[16]; } l_ar_hdr_misc_cshort_name;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_misc_cadd1_desc;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_misc_cadd2_desc;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_misc_cadd3_desc;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_misc_czip_desc;

struct { unsigned short len; unsigned char arr[41]; } l_ar_hdr_misc_long_chinese;

struct { unsigned short len; unsigned char arr[16]; } l_ar_hdr_misc_short_chinese;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_misc_add1_chinese;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_misc_add2_chinese;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_misc_add3_chinese;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_misc_zip_chinese;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_tel_num;

struct { unsigned short len; unsigned char arr[41]; } l_ar_hdr_contact_name;

struct { unsigned short len; unsigned char arr[41]; } l_ar_hdr_contact_name_title;

struct { unsigned short len; unsigned char arr[2]; } l_ar_hdr_error_flag;

struct { unsigned short len; unsigned char arr[2]; } l_ar_hdr_print_flag;

struct { unsigned short len; unsigned char arr[31]; } l_ar_hdr_rowid;

struct { unsigned short len; unsigned char arr[5]; } l_ar_ihdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_ihdr_doc_num;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_ihdr_org_doc_num;

struct { unsigned short len; unsigned char arr[5]; } l_ar_ihdr_last_line_num;

struct { unsigned short len; unsigned char arr[8]; } l_ar_ihdr_cust_code;

struct { unsigned short len; unsigned char arr[51]; } l_ar_ihdr_narration;

struct { unsigned short len; unsigned char arr[12]; } l_ar_ihdr_base_date;

struct { unsigned short len; unsigned char arr[12]; } l_ar_ihdr_due_date;

struct { unsigned short len; unsigned char arr[19]; } l_ar_ihdr_gross_amt;

struct { unsigned short len; unsigned char arr[19]; } l_ar_ihdr_payable_amt;

struct { unsigned short len; unsigned char arr[19]; } l_ar_ihdr_discount_amt;

struct { unsigned short len; unsigned char arr[19]; } l_ar_ihdr_doc_amt;

struct { unsigned short len; unsigned char arr[19]; } l_ar_ihdr_currency_code;

struct { unsigned short len; unsigned char arr[20]; } l_ar_ihdr_exchg_rate;

struct { unsigned short len; unsigned char arr[3]; } l_ar_ihdr_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[12]; } l_ar_ihdr_settlement_date;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_settlement_perc;

struct { unsigned short len; unsigned char arr[16]; } l_ar_ihdr_cust_ref;

struct { unsigned short len; unsigned char arr[21]; } l_ar_ihdr_patient_id;

struct { unsigned short len; unsigned char arr[3]; } l_ar_ihdr_billing_group;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[2]; } l_ar_ihdr_bill_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_ihdr_bill_num;

struct { unsigned short len; unsigned char arr[12]; } l_ar_ihdr_bill_date;

struct { unsigned short len; unsigned char arr[19]; } l_ar_ihdr_doctor_fee_amt;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } l_ar_ihdr_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } l_ar_ihdr_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_ihdr_sub_line_code;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } l_ar_ihdr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } l_ar_ihdr_product_line_code;

struct { unsigned short len; unsigned char arr[3]; } l_ar_ihdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } l_ar_ihdr_post_year;

struct { unsigned short len; unsigned char arr[31]; } l_ar_ihdr_rowid;

struct { unsigned short len; unsigned char arr[3]; } l_ar_ihdr_adj_type;

struct { unsigned short len; unsigned char arr[2]; } l_consolidated_yn;

struct { unsigned short len; unsigned char arr[5]; } l_ar_line_acc_entity_code;

struct { unsigned short len; unsigned char arr[7]; } l_ar_line_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_line_doc_num;

struct { unsigned short len; unsigned char arr[7]; } l_ar_line_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_line_org_doc_num;

struct { unsigned short len; unsigned char arr[5]; } l_ar_line_line_num;

struct { unsigned short len; unsigned char arr[7]; } l_ar_line_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } l_ar_line_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } l_ar_line_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_line_sub_line_code;

struct { unsigned short len; unsigned char arr[7]; } l_ar_line_dept_code;

struct { unsigned short len; unsigned char arr[4]; } l_ar_line_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } l_ar_line_product_line_code;

struct { unsigned short len; unsigned char arr[19]; } l_ar_line_amount;

struct { unsigned short len; unsigned char arr[51]; } l_ar_line_narration;

struct { unsigned short len; unsigned char arr[31]; } l_ar_line_rowid;

struct { unsigned short len; unsigned char arr[2]; } l_ar_interface_code;


/* VARCHAR  d_pat_doc_type_code          [7],
         d_pat_doc_num                [9],
         d_pat_patient_id             [21],
         d_pat_bill_doc_type_code     [7],
         d_pat_bill_num               [9],
         d_pat_inv_doc_type_code      [7],
         d_pat_inv_doc_num            [9],
         d_pat_bill_date              [12],
         d_pat_rowid                  [31]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_pat_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_pat_doc_num;

struct { unsigned short len; unsigned char arr[21]; } d_pat_patient_id;

struct { unsigned short len; unsigned char arr[7]; } d_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_pat_bill_num;

struct { unsigned short len; unsigned char arr[7]; } d_pat_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_pat_inv_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_pat_bill_date;

struct { unsigned short len; unsigned char arr[31]; } d_pat_rowid;


double       d_pat_amount ,
             d_pat_abs_amount ;


 /* VARCHAR    l_cust_ref1[16],
            l_narration[51]; */ 
struct { unsigned short len; unsigned char arr[16]; } l_cust_ref1;

struct { unsigned short len; unsigned char arr[51]; } l_narration;


   int      l_ar_pend_last_doc_line_num;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA;
 */ 
/*
 * $Header:   E:/MEDICOM-MASTER/archives/MEDICOM-eHIS5/MEDSRC/AR/AR_POST.C-arc   1.0   Nov 16 2005 16:13:26   Administrator  $ sqlca.h 
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



gl_doc_insert(rowid,ar_interface,l_trn_type,l_adj_type)
char rowid[],ar_interface[],l_trn_type,l_adj_type;
{
   /* EXEC SQL BEGIN DECLARE SECTION; */ 


       int     l_line_num = 0;
       char    d_ar_adj_type;

   /* EXEC SQL END DECLARE SECTION; */ 


   static int decl_flg = 1;

   d_ar_adj_type = l_adj_type;

   strcpy(hdr_rowid_passed.arr,rowid);
   hdr_rowid_passed.len = strlen(hdr_rowid_passed.arr);

   strcpy(l_ar_interface_code.arr,ar_interface);
   l_ar_interface_code.len = strlen(l_ar_interface_code.arr);

   if (decl_flg) dn_post_declare_curs();
   
   decl_flg = 0;

   dn_post_select_rec(l_trn_type);

   dn_post_open_ihdr(l_trn_type);

   l_cust_ref1.arr[0] = '\0';
   l_cust_ref1.len = 0; 
   l_narration.arr[0] = '\0';
   l_narration.len = 0; 

   while (dn_post_fetch_dn_inv_hdr(l_trn_type))
   {
      if (l_trn_type == 'A')
      {
           l_adj_type    = l_ar_ihdr_adj_type.arr[0];
           d_ar_adj_type = l_ar_ihdr_adj_type.arr[0];
      }

      l_line_num ++;


      if ((strcmp(l_ar_ihdr_doc_type_code.arr,l_ar_ihdr_org_doc_type_code.arr)==0)  &&
          (strcmp(l_ar_ihdr_doc_num.arr,l_ar_ihdr_org_doc_num.arr)==0))
      {
          strcpy(l_cust_ref1.arr,l_ar_ihdr_cust_ref.arr);
          l_cust_ref1.arr[10] = '\0';
          l_cust_ref1.len = strlen(l_cust_ref1.arr);

          strcpy(l_narration.arr,l_ar_ihdr_narration.arr);
          l_narration.len = strlen(l_narration.arr);
          dn_posting(0,l_adj_type,l_trn_type);
      }
      else
	  {
         dn_posting(1,l_adj_type,l_trn_type);

	 }


  if (l_ar_interface_code.arr[0] == 'O')
  {

  /* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
         (
           ACC_ENTITY_CODE,
           BATCH_NUM,
           DOC_TYPE_CODE,
           DOC_NUM,
           MAIN_ACC1_CODE,
           MAIN_ACC2_CODE,
           SUBLEDGER_GROUP_CODE,
           SUBLEDGER_LINE_CODE,
           DEPT_CODE,
           PRODUCT_GROUP_CODE,
           PRODUCT_LINE_CODE,
           FOREIGN_AMT,
           LOCAL_AMT,
           NARRATION,
           LINE_NUM,
           INTER_ACC_ENTITY,
		   CUST_SUPP_CODE
         )
      VALUES
         (
           :l_ar_hdr_acc_entity_code,
           0,
           :l_ar_ihdr_doc_type_code,
           :l_ar_ihdr_doc_num,
           :l_ar_ihdr_main_acc1_code,
           :l_ar_ihdr_main_acc2_code,
           :l_ar_ihdr_sub_group_code,
           :l_ar_ihdr_sub_line_code,
           :l_ar_ihdr_dept_code,
           :l_ar_ihdr_product_group_code,
           :l_ar_ihdr_product_line_code,
           NULL,
           decode(:d_ar_adj_type,'D',:l_ar_ihdr_doc_amt,-1 * :l_ar_ihdr_doc_amt),
           :l_ar_ihdr_narration,
           :l_line_num,
           NULL,
		   :l_ar_ihdr_cust_code
 
         ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,null ,decode(:b10,'D',:b11,((-1)* :b11)),:b13,:b14,n\
ull ,:b15)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_acc_entity_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_main_acc1_code;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_ar_ihdr_main_acc2_code;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_ar_ihdr_sub_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_ar_ihdr_sub_line_code;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_ar_ihdr_dept_code;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&l_ar_ihdr_product_group_code;
  sqlstm.sqhstl[8] = (unsigned int  )6;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&l_ar_ihdr_product_line_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_ar_adj_type;
  sqlstm.sqhstl[10] = (unsigned int  )1;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&l_ar_ihdr_doc_amt;
  sqlstm.sqhstl[11] = (unsigned int  )21;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&l_ar_ihdr_doc_amt;
  sqlstm.sqhstl[12] = (unsigned int  )21;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&l_ar_ihdr_narration;
  sqlstm.sqhstl[13] = (unsigned int  )53;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&l_line_num;
  sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&l_ar_ihdr_cust_code;
  sqlstm.sqhstl[15] = (unsigned int  )10;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_LINE - 1",0,"");    
   }

      dn_post_open_line(l_trn_type);

      while (dn_post_fetch_dn_line(l_trn_type))
      {
          l_line_num++;
   
  if (l_ar_interface_code.arr[0] == 'O')
  {

  /* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
         (
           ACC_ENTITY_CODE,
           BATCH_NUM,
           DOC_TYPE_CODE,
           DOC_NUM,
           MAIN_ACC1_CODE,
           MAIN_ACC2_CODE,
           SUBLEDGER_GROUP_CODE,
           SUBLEDGER_LINE_CODE,
           DEPT_CODE,
           PRODUCT_GROUP_CODE,
           PRODUCT_LINE_CODE,
           FOREIGN_AMT,
           LOCAL_AMT,
           NARRATION,
           LINE_NUM,
           INTER_ACC_ENTITY,
		   CUST_SUPP_CODE
         )
      VALUES
         (
           :l_ar_hdr_acc_entity_code,
           0, 
           :l_ar_line_doc_type_code,
           :l_ar_line_doc_num,   
           :l_ar_line_main_acc1_code,
           :l_ar_line_main_acc2_code,
           :l_ar_line_sub_group_code,
           :l_ar_line_sub_line_code,
           :l_ar_line_dept_code,
           :l_ar_line_product_group_code,
           :l_ar_line_product_line_code,
           NULL,
           decode(:d_ar_adj_type,'D',:l_ar_line_amount * -1,:l_ar_line_amount),
           :l_ar_line_narration,
           :l_line_num,
           null ,
		   :l_ar_ihdr_cust_code
          ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,null ,decode(:b10,'D',(:b11* (-1)),:b11),:b13,:b14,n\
ull ,:b15)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )84;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_acc_entity_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_ar_line_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_ar_line_doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_ar_line_main_acc1_code;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_ar_line_main_acc2_code;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_ar_line_sub_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_ar_line_sub_line_code;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_ar_line_dept_code;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&l_ar_line_product_group_code;
  sqlstm.sqhstl[8] = (unsigned int  )6;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&l_ar_line_product_line_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_ar_adj_type;
  sqlstm.sqhstl[10] = (unsigned int  )1;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&l_ar_line_amount;
  sqlstm.sqhstl[11] = (unsigned int  )21;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&l_ar_line_amount;
  sqlstm.sqhstl[12] = (unsigned int  )21;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&l_ar_line_narration;
  sqlstm.sqhstl[13] = (unsigned int  )53;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&l_line_num;
  sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&l_ar_ihdr_cust_code;
  sqlstm.sqhstl[15] = (unsigned int  )10;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_LINE - for line",0,"");    
     }
    }
   }

   dn_post_ar_insertings(l_trn_type == 'A'?'D':l_adj_type,l_trn_type);

   if (l_ar_interface_code.arr[0] == 'O')
   {
   /* EXEC SQL INSERT INTO GL_TXN_DOC_HDR
          (
           ACC_ENTITY_CODE,
           DOC_TYPE_CODE,
           BATCH_NUM,
           DOC_NUM,
           DOC_DATE,
           DOC_REF,
           NARRATION,
           POST_MONTH,
           POST_YEAR,
           CTRL_AMT,
           DOC_NATURE,
           UNIT_TYPE_CODE,
           CURRENCY_CODE,
           EXCHG_RATE,
           ERROR_FLAG,
           ADDED_BY_ID,
           MODIFIED_BY_ID,
           ADDED_DATE,
           MODIFIED_DATE,
           MAX_LINE_NUM,
           MODULE_ID,
           TXN_TYPE_DESC,
           STD_JV_REF,
           PRINT_FLAG
           )
      VALUES
         (
           :l_ar_hdr_acc_entity_code,
           :l_ar_hdr_doc_type_code,
           0,
           :l_ar_hdr_doc_num,
           to_date(:l_ar_hdr_doc_date,'DD/MM/YYYY'),
           SUBSTR(:l_cust_ref1,1,10),
           :l_narration,
           :l_ar_hdr_post_month,
           :l_ar_hdr_post_year,
           0,
           NULL,
           NULL,
           NULL,
           NULL,
           NULL,
           USER,
           USER,
           SYSDATE,
           SYSDATE,
           :l_line_num,
           'AR',
           NULL,
           NULL,
           NULL
         ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into GL_TXN_DOC_HDR (ACC_ENTITY_CODE,DOC_TYPE_CODE,\
BATCH_NUM,DOC_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT,DOC\
_NATURE,UNIT_TYPE_CODE,CURRENCY_CODE,EXCHG_RATE,ERROR_FLAG,ADDED_BY_ID,MODIFIE\
D_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID,TXN_TYPE_DESC,STD_JV_R\
EF,PRINT_FLAG) values (:b0,:b1,0,:b2,to_date(:b3,'DD/MM/YYYY'),SUBSTR(:b4,1,10\
),:b5,:b6,:b7,0,null ,null ,null ,null ,null ,USER,USER,SYSDATE,SYSDATE,:b8,'A\
R',null ,null ,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )163;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_ar_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_ar_hdr_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_cust_ref1;
   sqlstm.sqhstl[4] = (unsigned int  )18;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_narration;
   sqlstm.sqhstl[5] = (unsigned int  )53;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_ar_hdr_post_month;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_ar_hdr_post_year;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_line_num;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_HDR",0,"");
  }

  ar_update_hdr(l_trn_type);

}

ar_update_hdr(l_trn_type)
char l_trn_type;
{
   if (l_trn_type == 'D')
   {
    /* EXEC SQL UPDATE AR_DN_HDR
                SET POSTED_FLAG               = 'Y',
                    INTERFACE_FLAG            = 
                        DECODE(:l_ar_interface_code,'O','Y','N'),
                  POSTED_DATE               = SYSDATE,
                  POSTED_BY_ID              = USER
              WHERE ROWID = :hdr_rowid_passed; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_DN_HDR  set POSTED_FLAG='Y',INTERFACE_FLAG=DECO\
DE(:b0,'O','Y','N'),POSTED_DATE=SYSDATE,POSTED_BY_ID=USER where ROWID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )214;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_ar_interface_code;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&hdr_rowid_passed;
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
         err_mesg("UPDATE failed on table AR_DN_HDR",0,"");
   }
   else if (l_trn_type == 'C')
   {
    /* EXEC SQL UPDATE AR_CN_HDR
                SET POSTED_FLAG               = 'Y',
                    INTERFACE_FLAG            = 
                        DECODE(:l_ar_interface_code,'O','Y','N'),
                  POSTED_DATE               = SYSDATE,
                  POSTED_BY_ID              = USER
              WHERE ROWID = :hdr_rowid_passed; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_CN_HDR  set POSTED_FLAG='Y',INTERFACE_FLAG=DECO\
DE(:b0,'O','Y','N'),POSTED_DATE=SYSDATE,POSTED_BY_ID=USER where ROWID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )237;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_ar_interface_code;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&hdr_rowid_passed;
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
         err_mesg("UPDATE failed on table AR_CN_HDR",0,"");
    }
    else
    {
    /* EXEC SQL UPDATE AR_ADJ_HDR
                SET POSTED_FLAG               = 'Y',
                    INTERFACE_FLAG            = 
                        DECODE(:l_ar_interface_code,'O','Y','N'),
                  POSTED_DATE               = SYSDATE,
                  POSTED_BY_ID              = USER
              WHERE ROWID = :hdr_rowid_passed; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_ADJ_HDR  set POSTED_FLAG='Y',INTERFACE_FLAG=DEC\
ODE(:b0,'O','Y','N'),POSTED_DATE=SYSDATE,POSTED_BY_ID=USER where ROWID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )260;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_ar_interface_code;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&hdr_rowid_passed;
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
         err_mesg("UPDATE failed on table AR_ADJ_HDR",0,"");
      
    }

}

dn_post_declare_curs()
{
   /* EXEC SQL DECLARE DN_POST_INV_HDR CURSOR FOR
             SELECT NVL(ACC_ENTITY_CODE,' '),
                    DOC_TYPE_CODE,
                    DOC_NUM,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    NVL(LAST_LINE_NUM,0),
                    NVL(CUST_CODE,' '),
                    NVL(NARRATION,' '),
                    TO_CHAR(BASE_DATE,'DD/MM/YYYY'),
                    TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                    NVL(GROSS_AMT,0),
                    NVL(PAYABLE_AMT,0),
                    NVL(DISCOUNT_AMT,0),
                    NVL(DOC_AMT,0),
                    NVL(CURRENCY_CODE,' '),
                    NVL(EXCHG_RATE,0),
                    NVL(PMNT_TERMS_CODE,' '),
                    TO_CHAR(SETTLEMENT_DATE,'DD/MM/YYYY'),
                    NVL(SETTLEMENT_PERC,0),
                    NVL(CUST_REF,' '),
                    NVL(PATIENT_ID,' '),
                    NVL(BILLING_GROUP,' '),
                    NVL(BILL_DOC_TYPE_CODE,' '),
                    NVL(BILL_NUM,0),
                    TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
                    NVL(DOCTOR_FEE_AMT,0),
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(POST_MONTH,0),
                    NVL(POST_YEAR,0),
                    NVL(BILL_TYPE_CODE,' '),
                    ROWID,
					CONSOLIDATED_INV_YN
              FROM AR_DN_INV_HDR
              WHERE DOC_TYPE_CODE = :l_ar_hdr_doc_type_code
                AND DOC_NUM       = :l_ar_hdr_doc_num; */ 



   /* EXEC SQL DECLARE DN_POST_LINE  CURSOR FOR
             SELECT NVL(ACC_ENTITY_CODE,' '),
                    DOC_TYPE_CODE,
                    DOC_NUM,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    LINE_NUM,
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(AMOUNT,0),
                    NVL(NARRATION,' '),
                    ROWID
               FROM AR_DN_LINE
              WHERE DOC_TYPE_CODE     = :l_ar_hdr_doc_type_code
                AND DOC_NUM           = :l_ar_hdr_doc_num
                AND ORG_DOC_TYPE_CODE = :l_ar_ihdr_org_doc_type_code
                AND ORG_DOC_NUM       = :l_ar_ihdr_org_doc_num; */ 


   /* EXEC SQL DECLARE CN_POST_INV_HDR CURSOR FOR
             SELECT NVL(ACC_ENTITY_CODE,' '),
                    DOC_TYPE_CODE,
                    DOC_NUM,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    NVL(LAST_LINE_NUM,0),
                    NVL(CUST_CODE,' '),
                    NVL(NARRATION,' '),
                    TO_CHAR(BASE_DATE,'DD/MM/YYYY'),
                    TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                    NVL(GROSS_AMT,0),
                    NVL(PAYABLE_AMT,0),
                    NVL(DISCOUNT_AMT,0),
                    NVL(DOC_AMT,0),
                    NVL(CURRENCY_CODE,' '),
                    NVL(EXCHG_RATE,0),
                    NVL(PMNT_TERMS_CODE,' '),
                    TO_CHAR(SETTLEMENT_DATE,'DD/MM/YYYY'),
                    NVL(SETTLEMENT_PERC,0),
                    NVL(CUST_REF,' '),
                    NVL(PATIENT_ID,' '),
                    NVL(BILLING_GROUP,' '),
                    NVL(BILL_DOC_TYPE_CODE,' '),
                    NVL(BILL_NUM,0),
                    TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
                    NVL(DOCTOR_FEE_AMT,0),
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(POST_MONTH,0),
                    NVL(POST_YEAR,0),
                    NVL(BILL_TYPE_CODE,' '),
                    ROWID,
					CONSOLIDATED_INV_YN
               FROM AR_CN_INV_HDR
              WHERE DOC_TYPE_CODE = :l_ar_hdr_doc_type_code
                AND DOC_NUM       = :l_ar_hdr_doc_num; */ 



   /* EXEC SQL DECLARE CN_POST_LINE  CURSOR FOR
             SELECT NVL(ACC_ENTITY_CODE,' '),
                    DOC_TYPE_CODE,
                    DOC_NUM,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    LINE_NUM,
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(AMOUNT,0),
                    NVL(NARRATION,' '),
                    ROWID
               FROM AR_CN_LINE
              WHERE DOC_TYPE_CODE     = :l_ar_hdr_doc_type_code
                AND DOC_NUM           = :l_ar_hdr_doc_num
                AND ORG_DOC_TYPE_CODE = :l_ar_ihdr_org_doc_type_code
                AND ORG_DOC_NUM       = :l_ar_ihdr_org_doc_num; */ 


   /* EXEC SQL DECLARE ADJ_POST_INV_HDR CURSOR FOR
             SELECT NVL(ACC_ENTITY_CODE,' '),
                    DOC_TYPE_CODE,
                    DOC_NUM,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    NVL(LAST_LINE_NUM,0),
                    NVL(CUST_CODE,' '),
                    NVL(NARRATION,' '),
                    TO_CHAR(BASE_DATE,'DD/MM/YYYY'),
                    TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                    NVL(GROSS_AMT,0),
                    NVL(PAYABLE_AMT,0),
                    NVL(DISCOUNT_AMT,0),
                    NVL(DOC_AMT,0),
                    NVL(CURRENCY_CODE,' '),
                    NVL(EXCHG_RATE,0),
                    NVL(PMNT_TERMS_CODE,' '),
                    TO_CHAR(SETTLEMENT_DATE,'DD/MM/YYYY'),
                    NVL(SETTLEMENT_PERC,0),
                    NVL(CUST_REF,' '),
                    NVL(PATIENT_ID,' '),
                    NVL(BILLING_GROUP,' '),
                    NVL(BILL_DOC_TYPE_CODE,' '),
                    NVL(BILL_NUM,0),
                    TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
                    NVL(DOCTOR_FEE_AMT,0),
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(POST_MONTH,0),
                    NVL(POST_YEAR,0),
                    NVL(MISC_CUST_LONG_NAME,' '),
                    NVL(MISC_CUST_SHORT_NAME,' '),
                    NVL(MISC_CUST_ADD1_DESC,' '),
                    NVL(MISC_CUST_ADD2_DESC,' '),
                    NVL(MISC_CUST_ADD3_DESC,' '),
                    NVL(MISC_CUST_ZIP_DESC,' '),
                    NVL(MISC_CUST_LONG_NAME_CHINESE,' '),
                    NVL(MISC_CUST_SHORT_NAME_CHINESE,' '),
                    NVL(MISC_CUST_ADD1_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ADD2_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ADD3_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ZIP_DESC_CHINESE,' '),
                    NVL(TEL_NUM,' '),
                    NVL(CONTACT_NAME,' '),
                    NVL(CONTACT_NAME_TITLE,' '),
                    ROWID,
                    NVL(ADJ_TYPE,' '),
                    NVL(BILL_TYPE_CODE,' '),
					CONSOLIDATED_INV_YN
               FROM AR_ADJ_INV_HDR
              WHERE DOC_TYPE_CODE = :l_ar_hdr_doc_type_code
                AND DOC_NUM       = :l_ar_hdr_doc_num; */ 



   /* EXEC SQL DECLARE ADJ_POST_LINE  CURSOR FOR
             SELECT NVL(ACC_ENTITY_CODE,' '),
                    DOC_TYPE_CODE,
                    DOC_NUM,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    LINE_NUM,
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(AMOUNT,0),
                    NVL(NARRATION,' '),
                    ROWID
               FROM AR_ADJ_LINE
              WHERE DOC_TYPE_CODE     = :l_ar_hdr_doc_type_code
                AND DOC_NUM           = :l_ar_hdr_doc_num
                AND ORG_DOC_TYPE_CODE = :l_ar_ihdr_org_doc_type_code
                AND ORG_DOC_NUM       = :l_ar_ihdr_org_doc_num; */ 


}


/**************************************************************************/

l_alloc_pat_dtls()
{
         
   /* EXEC SQL DECLARE l_alloc_pat_cur CURSOR FOR		 
		  SELECT DOC_TYPE_CODE,
                      DOC_NUM,
                      INV_DOC_TYPE_CODE,
					  INV_DOC_NUM       ,     
                      BILL_DOC_TYPE_CODE,
                      BILL_NUM,
                      NVL(AMOUNT,0),
					  ABS(nvl(AMOUNT,0)),
                      ROWID
			  FROM AR_PATIENT_ALLOC_DTLS
              WHERE DOC_TYPE_CODE     = :l_ar_hdr_doc_type_code
                AND DOC_NUM           = :l_ar_hdr_doc_num
               ORDER BY DOC_TYPE_CODE , DOC_NUM; */ 



}

l_open_pat_cur()
{
    /* EXEC SQL OPEN l_alloc_pat_cur; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0013;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )283;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
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
         err_mesg("OPEN failed on cursor l_alloc_pat_cur",0,"");
}

fetch_alloc_pat_dtls()
{
  d_pat_doc_type_code.arr[0]       = '\0';
  d_pat_doc_num.arr[0]             = '\0';
  d_pat_bill_doc_type_code.arr[0]  = '\0';
  d_pat_bill_num.arr[0]            = '\0';
  d_pat_inv_doc_type_code.arr[0] = '\0';
  d_pat_inv_doc_num.arr[0] = '\0';
  d_pat_rowid.arr[0]               = '\0';

  d_pat_doc_type_code.len          = 0;
  d_pat_doc_num.len                = 0;
  d_pat_bill_doc_type_code.len     = 0;
  d_pat_bill_num.len               = 0;
  d_pat_inv_doc_type_code.len = 0;
  d_pat_inv_doc_num.len = 0;
  d_pat_rowid.len                  = 0;

  d_pat_amount      = 0;
  d_pat_abs_amount  =0;

         /* EXEC SQL FETCH l_alloc_pat_cur
                INTO 
  				  :d_pat_doc_type_code,
                  :d_pat_doc_num,
                  :d_pat_inv_doc_type_code,
                  :d_pat_inv_doc_num,
                  :d_pat_bill_doc_type_code,
                  :d_pat_bill_num,
                  :d_pat_amount,
                  :d_pat_abs_amount,
                  :d_pat_rowid; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 16;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )306;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&d_pat_doc_type_code;
         sqlstm.sqhstl[0] = (unsigned int  )9;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&d_pat_doc_num;
         sqlstm.sqhstl[1] = (unsigned int  )11;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&d_pat_inv_doc_type_code;
         sqlstm.sqhstl[2] = (unsigned int  )9;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&d_pat_inv_doc_num;
         sqlstm.sqhstl[3] = (unsigned int  )11;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&d_pat_bill_doc_type_code;
         sqlstm.sqhstl[4] = (unsigned int  )9;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&d_pat_bill_num;
         sqlstm.sqhstl[5] = (unsigned int  )11;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&d_pat_amount;
         sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&d_pat_abs_amount;
         sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&d_pat_rowid;
         sqlstm.sqhstl[8] = (unsigned int  )33;
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
            err_mesg("FETCH failed on cursor l_alloc_pat_cur - ar_post",0,"");

                  
    d_pat_doc_type_code.arr[d_pat_doc_type_code.len]           = '\0';
    d_pat_doc_num.arr[d_pat_doc_num.len]                       = '\0';
    d_pat_bill_doc_type_code.arr[d_pat_bill_doc_type_code.len] = '\0';
    d_pat_bill_num.arr[d_pat_bill_num.len]                     = '\0';
    d_pat_rowid.arr[d_pat_rowid.len]                           = '\0';
    d_pat_inv_doc_type_code.arr[d_pat_inv_doc_type_code.len] = '\0';
    d_pat_inv_doc_num.arr[d_pat_inv_doc_num.len]= '\0';

	 if (LAST_ROW)
      return(0);
     else
      return(1);

}



/**************************************************************************/

dn_posting(alloc_flag,l_adj_type,l_trn_type)
int alloc_flag;
char l_adj_type,
     l_trn_type;
{
  /* EXEC SQL BEGIN DECLARE SECTION; */ 

     char d_ar_adj_type,d_ar_trn_type;
  /* EXEC SQL END DECLARE SECTION; */ 


  d_ar_adj_type = l_adj_type;
  d_ar_trn_type = l_trn_type;

    
  if (alloc_flag == 0)
  {      
 
	  
 /* EXEC SQL INSERT INTO AR_PENDING_DOC
        (
         ACC_ENTITY_CODE,
         DOC_TYPE_CODE,
         DOC_NUM,
         LAST_DOC_LINE_NUM,
         CUST_CODE,
         DOC_DATE,
         NARRATION,
         BASE_DATE,
         DUE_DATE,
         GROSS_AMT,
         PAYABLE_AMT,
         DISCOUNT_AMT,
         PENDING_AMT,
         ALLOCATED_AMT,
         CURRENCY_CODE,
         EXCHG_RATE,
         PMNT_TERMS_CODE,
         SETTLEMENT_DATE,
         SETTLEMENT_PERC,
         CUST_REF,
         PATIENT_ID,
         BILLING_GROUP,
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
         MISC_CUST_LONG_NAME,
         MISC_CUST_SHORT_NAME,
         MISC_CUST_ADD1_DESC,
         MISC_CUST_ADD2_DESC,
         MISC_CUST_ADD3_DESC,
         MISC_CUST_ZIP_DESC,
         MISC_CUST_LONG_NAME_CHINESE,
         MISC_CUST_SHORT_NAME_CHINESE,
         MISC_CUST_ADD1_DESC_CHINESE,
         MISC_CUST_ADD2_DESC_CHINESE,
         MISC_CUST_ADD3_DESC_CHINESE,
         MISC_CUST_ZIP_DESC_CHINESE,
         TEL_NUM,
         CONTACT_NAME,
         CONTACT_NAME_TITLE,
         ERROR_FLAG,
         BILL_DOC_TYPE_CODE,
         TRN_TYPE_CODE,
         LAST_UPD_DATE,
         BILL_TYPE_CODE

       )
    VALUES
       (
         :l_ar_ihdr_acc_entity_code,
         :l_ar_ihdr_doc_type_code,
         :l_ar_ihdr_doc_num,
          1,
         :l_ar_ihdr_cust_code,          
         TO_DATE(:l_ar_hdr_doc_date,'DD/MM/YYYY'),
         :l_ar_ihdr_narration,
         TO_DATE(:l_ar_ihdr_base_date,'DD/MM/YYYY'),
         TO_DATE(:l_ar_ihdr_due_date,'DD/MM/YYYY'),
         decode(:d_ar_adj_type,'D',:l_ar_ihdr_gross_amt,
                                   -1 * :l_ar_ihdr_doc_amt),
         decode(:d_ar_adj_type,'D',:l_ar_ihdr_payable_amt,
                                   -1 * :l_ar_ihdr_doc_amt),
         decode(:d_ar_adj_type,'D',:l_ar_ihdr_discount_amt,0),
         decode(:d_ar_adj_type,'D',:l_ar_ihdr_doc_amt,-1 * :l_ar_ihdr_doc_amt),
         0,
         :l_ar_ihdr_currency_code,
         :l_ar_ihdr_exchg_rate,
         :l_ar_ihdr_pmnt_terms_code,
         TO_DATE(:l_ar_ihdr_settlement_date,'DD/MM/YYYY'),
         :l_ar_ihdr_settlement_perc,
         :l_ar_ihdr_cust_ref,
         :l_ar_ihdr_patient_id,
         :l_ar_ihdr_billing_group,
         :l_ar_ihdr_bill_num,
         TO_DATE(:l_ar_ihdr_bill_date,'DD/MM/YYYY'),
         :l_ar_ihdr_doctor_fee_amt,
         :l_ar_ihdr_main_acc1_code,
         :l_ar_ihdr_main_acc2_code,
         :l_ar_ihdr_sub_group_code,
         :l_ar_ihdr_sub_line_code,
         :l_ar_ihdr_dept_code,
         :l_ar_ihdr_product_group_code,
         :l_ar_ihdr_product_line_code,
         :l_ar_hdr_post_month,
         :l_ar_hdr_post_year,
         :l_ar_hdr_misc_clong_name,
         :l_ar_hdr_misc_cshort_name,
         :l_ar_hdr_misc_cadd1_desc,
         :l_ar_hdr_misc_cadd2_desc,
         :l_ar_hdr_misc_cadd3_desc,
         :l_ar_hdr_misc_czip_desc,
         :l_ar_hdr_misc_long_chinese,
         :l_ar_hdr_misc_short_chinese,
         :l_ar_hdr_misc_add1_chinese,
         :l_ar_hdr_misc_add2_chinese,
         :l_ar_hdr_misc_add3_chinese,
         :l_ar_hdr_misc_zip_chinese,
         :l_ar_hdr_tel_num,
         :l_ar_hdr_contact_name,
         :l_ar_hdr_contact_name_title,
         :l_ar_hdr_error_flag,
         :l_ar_ihdr_bill_doc_type_code,
         decode(:d_ar_trn_type,'D','2','C','3','A','4'), 
         SYSDATE,
         :l_ar_ihdr_bill_type_code
         ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 58;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "insert into AR_PENDING_DOC (ACC_ENTITY_CODE,DOC_TYPE_CODE,DOC_NUM,LAST_D\
OC_LINE_NUM,CUST_CODE,DOC_DATE,NARRATION,BASE_DATE,DUE_DATE,GROSS_AMT,PAYABL\
E_AMT,DISCOUNT_AMT,PENDING_AMT,ALLOCATED_AMT,CURRENCY_CODE,EXCHG_RATE,PMNT_T\
ERMS_CODE,SETTLEMENT_DATE,SETTLEMENT_PERC,CUST_REF,PATIENT_ID,BILLING_GROUP,\
BILL_NUM,BILL_DATE,DOCTOR_FEE_AMT,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GR\
OUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,\
POST_MONTH,POST_YEAR,MISC_CUST_LONG_NAME,MISC_CUST_SHORT_NAME,MISC_CUST_ADD1\
_DESC,MISC_CUST_ADD2_DESC,MISC_CUST_ADD3_DESC,MISC_CUST_ZIP_DESC,MISC_CUST_L\
ONG_NAME_CHINESE,MISC_CUST_SHORT_NAME_CHINESE,MISC_CUST_ADD1_DESC_CHINESE,MI\
SC_CUST_ADD2_DESC_CHINESE,MISC_CUST_ADD3_DESC_CHINESE,MISC_CUST_ZIP_DESC_CHI\
NESE,TEL_NUM,CONTACT_NAME,CONTACT_NAME_TITLE,ERROR_FLAG,BILL_DOC_TYPE_CODE,T\
RN_TYPE_CODE,LAST_UPD_DATE,BILL_TYPE_CODE) values (:b0,:b1,:b2,1,:b3,TO_DATE\
(:b4,'DD/MM/YYYY'),:b5,TO_DATE(:b6,'DD/MM/YYYY'),TO_DATE(:b7,'DD/MM/YYYY'),d\
ecode(:b8,'D',:b9,((-1)* :b10)),decode(:");
 sqlstm.stmt = "b8,'D',:b12,((-1)* :b10)),decode(:b8,'D',:b15,0),decode(:b8,\
'D',:b10,((-1)* :b10)),0,:b19,:b20,:b21,TO_DATE(:b22,'DD/MM/YYYY'),:b23,:b24,:\
b25,:b26,:b27,TO_DATE(:b28,'DD/MM/YYYY'),:b29,:b30,:b31,:b32,:b33,:b34,:b35,:b\
36,:b37,:b38,:b39,:b40,:b41,:b42,:b43,:b44,:b45,:b46,:b47,:b48,:b49,:b50,:b51,\
:b52,:b53,:b54,:b55,decode(:b56,'D','2','C','3','A','4'),SYSDATE,:b57)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )357;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_ar_ihdr_acc_entity_code;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_doc_num;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_cust_code;
 sqlstm.sqhstl[3] = (unsigned int  )10;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_ar_hdr_doc_date;
 sqlstm.sqhstl[4] = (unsigned int  )14;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_ar_ihdr_narration;
 sqlstm.sqhstl[5] = (unsigned int  )53;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_ar_ihdr_base_date;
 sqlstm.sqhstl[6] = (unsigned int  )14;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_ar_ihdr_due_date;
 sqlstm.sqhstl[7] = (unsigned int  )14;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_ar_adj_type;
 sqlstm.sqhstl[8] = (unsigned int  )1;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_ar_ihdr_gross_amt;
 sqlstm.sqhstl[9] = (unsigned int  )21;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_ar_ihdr_doc_amt;
 sqlstm.sqhstl[10] = (unsigned int  )21;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_ar_adj_type;
 sqlstm.sqhstl[11] = (unsigned int  )1;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&l_ar_ihdr_payable_amt;
 sqlstm.sqhstl[12] = (unsigned int  )21;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&l_ar_ihdr_doc_amt;
 sqlstm.sqhstl[13] = (unsigned int  )21;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_ar_adj_type;
 sqlstm.sqhstl[14] = (unsigned int  )1;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&l_ar_ihdr_discount_amt;
 sqlstm.sqhstl[15] = (unsigned int  )21;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&d_ar_adj_type;
 sqlstm.sqhstl[16] = (unsigned int  )1;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&l_ar_ihdr_doc_amt;
 sqlstm.sqhstl[17] = (unsigned int  )21;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&l_ar_ihdr_doc_amt;
 sqlstm.sqhstl[18] = (unsigned int  )21;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&l_ar_ihdr_currency_code;
 sqlstm.sqhstl[19] = (unsigned int  )21;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&l_ar_ihdr_exchg_rate;
 sqlstm.sqhstl[20] = (unsigned int  )22;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&l_ar_ihdr_pmnt_terms_code;
 sqlstm.sqhstl[21] = (unsigned int  )5;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&l_ar_ihdr_settlement_date;
 sqlstm.sqhstl[22] = (unsigned int  )14;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&l_ar_ihdr_settlement_perc;
 sqlstm.sqhstl[23] = (unsigned int  )9;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&l_ar_ihdr_cust_ref;
 sqlstm.sqhstl[24] = (unsigned int  )18;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&l_ar_ihdr_patient_id;
 sqlstm.sqhstl[25] = (unsigned int  )23;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&l_ar_ihdr_billing_group;
 sqlstm.sqhstl[26] = (unsigned int  )5;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&l_ar_ihdr_bill_num;
 sqlstm.sqhstl[27] = (unsigned int  )11;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&l_ar_ihdr_bill_date;
 sqlstm.sqhstl[28] = (unsigned int  )14;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&l_ar_ihdr_doctor_fee_amt;
 sqlstm.sqhstl[29] = (unsigned int  )21;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&l_ar_ihdr_main_acc1_code;
 sqlstm.sqhstl[30] = (unsigned int  )9;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&l_ar_ihdr_main_acc2_code;
 sqlstm.sqhstl[31] = (unsigned int  )7;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&l_ar_ihdr_sub_group_code;
 sqlstm.sqhstl[32] = (unsigned int  )6;
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&l_ar_ihdr_sub_line_code;
 sqlstm.sqhstl[33] = (unsigned int  )11;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&l_ar_ihdr_dept_code;
 sqlstm.sqhstl[34] = (unsigned int  )9;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&l_ar_ihdr_product_group_code;
 sqlstm.sqhstl[35] = (unsigned int  )6;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&l_ar_ihdr_product_line_code;
 sqlstm.sqhstl[36] = (unsigned int  )7;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&l_ar_hdr_post_month;
 sqlstm.sqhstl[37] = (unsigned int  )5;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&l_ar_hdr_post_year;
 sqlstm.sqhstl[38] = (unsigned int  )7;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&l_ar_hdr_misc_clong_name;
 sqlstm.sqhstl[39] = (unsigned int  )43;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&l_ar_hdr_misc_cshort_name;
 sqlstm.sqhstl[40] = (unsigned int  )18;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&l_ar_hdr_misc_cadd1_desc;
 sqlstm.sqhstl[41] = (unsigned int  )33;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)&l_ar_hdr_misc_cadd2_desc;
 sqlstm.sqhstl[42] = (unsigned int  )33;
 sqlstm.sqhsts[42] = (         int  )0;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
 sqlstm.sqhstv[43] = (         void  *)&l_ar_hdr_misc_cadd3_desc;
 sqlstm.sqhstl[43] = (unsigned int  )33;
 sqlstm.sqhsts[43] = (         int  )0;
 sqlstm.sqindv[43] = (         void  *)0;
 sqlstm.sqinds[43] = (         int  )0;
 sqlstm.sqharm[43] = (unsigned int  )0;
 sqlstm.sqadto[43] = (unsigned short )0;
 sqlstm.sqtdso[43] = (unsigned short )0;
 sqlstm.sqhstv[44] = (         void  *)&l_ar_hdr_misc_czip_desc;
 sqlstm.sqhstl[44] = (unsigned int  )33;
 sqlstm.sqhsts[44] = (         int  )0;
 sqlstm.sqindv[44] = (         void  *)0;
 sqlstm.sqinds[44] = (         int  )0;
 sqlstm.sqharm[44] = (unsigned int  )0;
 sqlstm.sqadto[44] = (unsigned short )0;
 sqlstm.sqtdso[44] = (unsigned short )0;
 sqlstm.sqhstv[45] = (         void  *)&l_ar_hdr_misc_long_chinese;
 sqlstm.sqhstl[45] = (unsigned int  )43;
 sqlstm.sqhsts[45] = (         int  )0;
 sqlstm.sqindv[45] = (         void  *)0;
 sqlstm.sqinds[45] = (         int  )0;
 sqlstm.sqharm[45] = (unsigned int  )0;
 sqlstm.sqadto[45] = (unsigned short )0;
 sqlstm.sqtdso[45] = (unsigned short )0;
 sqlstm.sqhstv[46] = (         void  *)&l_ar_hdr_misc_short_chinese;
 sqlstm.sqhstl[46] = (unsigned int  )18;
 sqlstm.sqhsts[46] = (         int  )0;
 sqlstm.sqindv[46] = (         void  *)0;
 sqlstm.sqinds[46] = (         int  )0;
 sqlstm.sqharm[46] = (unsigned int  )0;
 sqlstm.sqadto[46] = (unsigned short )0;
 sqlstm.sqtdso[46] = (unsigned short )0;
 sqlstm.sqhstv[47] = (         void  *)&l_ar_hdr_misc_add1_chinese;
 sqlstm.sqhstl[47] = (unsigned int  )33;
 sqlstm.sqhsts[47] = (         int  )0;
 sqlstm.sqindv[47] = (         void  *)0;
 sqlstm.sqinds[47] = (         int  )0;
 sqlstm.sqharm[47] = (unsigned int  )0;
 sqlstm.sqadto[47] = (unsigned short )0;
 sqlstm.sqtdso[47] = (unsigned short )0;
 sqlstm.sqhstv[48] = (         void  *)&l_ar_hdr_misc_add2_chinese;
 sqlstm.sqhstl[48] = (unsigned int  )33;
 sqlstm.sqhsts[48] = (         int  )0;
 sqlstm.sqindv[48] = (         void  *)0;
 sqlstm.sqinds[48] = (         int  )0;
 sqlstm.sqharm[48] = (unsigned int  )0;
 sqlstm.sqadto[48] = (unsigned short )0;
 sqlstm.sqtdso[48] = (unsigned short )0;
 sqlstm.sqhstv[49] = (         void  *)&l_ar_hdr_misc_add3_chinese;
 sqlstm.sqhstl[49] = (unsigned int  )33;
 sqlstm.sqhsts[49] = (         int  )0;
 sqlstm.sqindv[49] = (         void  *)0;
 sqlstm.sqinds[49] = (         int  )0;
 sqlstm.sqharm[49] = (unsigned int  )0;
 sqlstm.sqadto[49] = (unsigned short )0;
 sqlstm.sqtdso[49] = (unsigned short )0;
 sqlstm.sqhstv[50] = (         void  *)&l_ar_hdr_misc_zip_chinese;
 sqlstm.sqhstl[50] = (unsigned int  )33;
 sqlstm.sqhsts[50] = (         int  )0;
 sqlstm.sqindv[50] = (         void  *)0;
 sqlstm.sqinds[50] = (         int  )0;
 sqlstm.sqharm[50] = (unsigned int  )0;
 sqlstm.sqadto[50] = (unsigned short )0;
 sqlstm.sqtdso[50] = (unsigned short )0;
 sqlstm.sqhstv[51] = (         void  *)&l_ar_hdr_tel_num;
 sqlstm.sqhstl[51] = (unsigned int  )33;
 sqlstm.sqhsts[51] = (         int  )0;
 sqlstm.sqindv[51] = (         void  *)0;
 sqlstm.sqinds[51] = (         int  )0;
 sqlstm.sqharm[51] = (unsigned int  )0;
 sqlstm.sqadto[51] = (unsigned short )0;
 sqlstm.sqtdso[51] = (unsigned short )0;
 sqlstm.sqhstv[52] = (         void  *)&l_ar_hdr_contact_name;
 sqlstm.sqhstl[52] = (unsigned int  )43;
 sqlstm.sqhsts[52] = (         int  )0;
 sqlstm.sqindv[52] = (         void  *)0;
 sqlstm.sqinds[52] = (         int  )0;
 sqlstm.sqharm[52] = (unsigned int  )0;
 sqlstm.sqadto[52] = (unsigned short )0;
 sqlstm.sqtdso[52] = (unsigned short )0;
 sqlstm.sqhstv[53] = (         void  *)&l_ar_hdr_contact_name_title;
 sqlstm.sqhstl[53] = (unsigned int  )43;
 sqlstm.sqhsts[53] = (         int  )0;
 sqlstm.sqindv[53] = (         void  *)0;
 sqlstm.sqinds[53] = (         int  )0;
 sqlstm.sqharm[53] = (unsigned int  )0;
 sqlstm.sqadto[53] = (unsigned short )0;
 sqlstm.sqtdso[53] = (unsigned short )0;
 sqlstm.sqhstv[54] = (         void  *)&l_ar_hdr_error_flag;
 sqlstm.sqhstl[54] = (unsigned int  )4;
 sqlstm.sqhsts[54] = (         int  )0;
 sqlstm.sqindv[54] = (         void  *)0;
 sqlstm.sqinds[54] = (         int  )0;
 sqlstm.sqharm[54] = (unsigned int  )0;
 sqlstm.sqadto[54] = (unsigned short )0;
 sqlstm.sqtdso[54] = (unsigned short )0;
 sqlstm.sqhstv[55] = (         void  *)&l_ar_ihdr_bill_doc_type_code;
 sqlstm.sqhstl[55] = (unsigned int  )9;
 sqlstm.sqhsts[55] = (         int  )0;
 sqlstm.sqindv[55] = (         void  *)0;
 sqlstm.sqinds[55] = (         int  )0;
 sqlstm.sqharm[55] = (unsigned int  )0;
 sqlstm.sqadto[55] = (unsigned short )0;
 sqlstm.sqtdso[55] = (unsigned short )0;
 sqlstm.sqhstv[56] = (         void  *)&d_ar_trn_type;
 sqlstm.sqhstl[56] = (unsigned int  )1;
 sqlstm.sqhsts[56] = (         int  )0;
 sqlstm.sqindv[56] = (         void  *)0;
 sqlstm.sqinds[56] = (         int  )0;
 sqlstm.sqharm[56] = (unsigned int  )0;
 sqlstm.sqadto[56] = (unsigned short )0;
 sqlstm.sqtdso[56] = (unsigned short )0;
 sqlstm.sqhstv[57] = (         void  *)&l_ar_ihdr_bill_type_code;
 sqlstm.sqhstl[57] = (unsigned int  )4;
 sqlstm.sqhsts[57] = (         int  )0;
 sqlstm.sqindv[57] = (         void  *)0;
 sqlstm.sqinds[57] = (         int  )0;
 sqlstm.sqharm[57] = (unsigned int  )0;
 sqlstm.sqadto[57] = (unsigned short )0;
 sqlstm.sqtdso[57] = (unsigned short )0;
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
   {
        
        err_mesg("INSERT failed on table AR_PENDING_DOC",0,"");
   } 

       l_ar_pend_last_doc_line_num = 1;
   }
   else
   {
        /* EXEC SQL UPDATE AR_PENDING_DOC
                    SET PENDING_AMT = NVL(PENDING_AMT,0) + 
                           decode(:d_ar_adj_type,'D',:l_ar_ihdr_doc_amt,
                                                  -1 * :l_ar_ihdr_doc_amt),
                        LAST_DOC_LINE_NUM = NVL(LAST_DOC_LINE_NUM,0) + 1,
                        LAST_UPD_DATE     = SYSDATE
                  WHERE DOC_TYPE_CODE = :l_ar_ihdr_org_doc_type_code
                    AND DOC_NUM       = :l_ar_ihdr_org_doc_num; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 58;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update AR_PENDING_DOC  set PENDING_AMT=(NVL(PENDING_A\
MT,0)+decode(:b0,'D',:b1,((-1)* :b1))),LAST_DOC_LINE_NUM=(NVL(LAST_DOC_LINE_NU\
M,0)+1),LAST_UPD_DATE=SYSDATE where (DOC_TYPE_CODE=:b3 and DOC_NUM=:b4)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )604;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_ar_adj_type;
        sqlstm.sqhstl[0] = (unsigned int  )1;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_doc_amt;
        sqlstm.sqhstl[1] = (unsigned int  )21;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_doc_amt;
        sqlstm.sqhstl[2] = (unsigned int  )21;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_type_code;
        sqlstm.sqhstl[3] = (unsigned int  )9;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&l_ar_ihdr_org_doc_num;
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
           err_mesg("UPDATE failed on table AR_PENDING_DOC",0,"");

        /* EXEC SQL SELECT NVL(LAST_DOC_LINE_NUM,1)
                   INTO :l_ar_pend_last_doc_line_num
                   FROM AR_PENDING_DOC
                  WHERE CUST_CODE     = :l_ar_ihdr_cust_code
                    AND DOC_TYPE_CODE = :l_ar_ihdr_org_doc_type_code
                    AND DOC_NUM       = :l_ar_ihdr_org_doc_num; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 58;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select NVL(LAST_DOC_LINE_NUM,1) into :b0  from AR_PEN\
DING_DOC where ((CUST_CODE=:b1 and DOC_TYPE_CODE=:b2) and DOC_NUM=:b3)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )639;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&l_ar_pend_last_doc_line_num;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_cust_code;
        sqlstm.sqhstl[1] = (unsigned int  )10;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_org_doc_type_code;
        sqlstm.sqhstl[2] = (unsigned int  )9;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_num;
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
            err_mesg("SELECT failed on table AR_PENDING_DOC",0,"");


 /************************************************************************/
    if (strcmp(l_consolidated_yn.arr , "Y") == 0)
   {
  
    l_alloc_pat_dtls();

    l_open_pat_cur();

	while(fetch_alloc_pat_dtls())
	{
    
	  
      /* EXEC SQL UPDATE AR_PATIENT_DTLS
	  SET PEND_AMOUNT = PEND_AMOUNT + :d_pat_amount
	  WHERE DOC_TYPE_CODE      = :d_pat_inv_doc_type_code 
      AND   DOC_NUM            =     :d_pat_inv_doc_num
      AND   BILL_DOC_TYPE_CODE =    :d_pat_bill_doc_type_code
      AND   BILL_NUM           =  :d_pat_bill_num; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update AR_PATIENT_DTLS  set PEND_AMOUNT=(PEND_AMOUNT+:b\
0) where (((DOC_TYPE_CODE=:b1 and DOC_NUM=:b2) and BILL_DOC_TYPE_CODE=:b3) and\
 BILL_NUM=:b4)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )670;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_pat_amount;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_pat_inv_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_pat_inv_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_pat_bill_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_pat_bill_num;
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
        err_mesg("UPDATE failed on table AR_PATIENT_DTLS",0,"");

	}

   }

     /*************************************************************/



   }

  if (strcmp(l_ar_ihdr_doc_amt.arr , "0") != 0)
   {
   /* EXEC SQL INSERT INTO AR_CUST_TRN
        (
          ACC_ENTITY_CODE,
          CUST_CODE,
          ORG_DOC_TYPE_CODE,
          ORG_DOC_NUM,
          LINE_NUM,
          DOC_TYPE_CODE,
          DOC_NUM,
          DOC_DATE,
          NARRATION,
          AMOUNT,
          CUST_REF,
          TRN_TYPE_CODE,
		  POST_MONTH,
		  POST_YEAR
       )
    VALUES
       (
          :l_ar_ihdr_acc_entity_code,
          :l_ar_ihdr_cust_code,
          :l_ar_ihdr_org_doc_type_code,
          :l_ar_ihdr_org_doc_num,
          :l_ar_pend_last_doc_line_num,
          :l_ar_ihdr_doc_type_code,
          :l_ar_ihdr_doc_num,
          to_date(:l_ar_hdr_doc_date,'DD/MM/YYYY'),
          :l_ar_ihdr_narration,
          decode(:d_ar_adj_type,'D',:l_ar_ihdr_doc_amt,-1 * :l_ar_ihdr_doc_amt),
          :l_ar_ihdr_cust_ref,
          decode(:d_ar_trn_type,'D','2','C','3','A','4'),
		  :l_ar_ihdr_post_month,
          :l_ar_ihdr_post_year
        ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_CUST_TRN (ACC_ENTITY_CODE,CUST_CODE,ORG_DOC\
_TYPE_CODE,ORG_DOC_NUM,LINE_NUM,DOC_TYPE_CODE,DOC_NUM,DOC_DATE,NARRATION,AMOUN\
T,CUST_REF,TRN_TYPE_CODE,POST_MONTH,POST_YEAR) values (:b0,:b1,:b2,:b3,:b4,:b5\
,:b6,to_date(:b7,'DD/MM/YYYY'),:b8,decode(:b9,'D',:b10,((-1)* :b10)),:b12,deco\
de(:b13,'D','2','C','3','A','4'),:b14,:b15)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )705;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_ihdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )10;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_org_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_ar_pend_last_doc_line_num;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_ar_ihdr_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_ar_ihdr_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_ar_hdr_doc_date;
   sqlstm.sqhstl[7] = (unsigned int  )14;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_ar_ihdr_narration;
   sqlstm.sqhstl[8] = (unsigned int  )53;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_ar_adj_type;
   sqlstm.sqhstl[9] = (unsigned int  )1;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_ar_ihdr_doc_amt;
   sqlstm.sqhstl[10] = (unsigned int  )21;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_ar_ihdr_doc_amt;
   sqlstm.sqhstl[11] = (unsigned int  )21;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&l_ar_ihdr_cust_ref;
   sqlstm.sqhstl[12] = (unsigned int  )18;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_ar_trn_type;
   sqlstm.sqhstl[13] = (unsigned int  )1;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&l_ar_ihdr_post_month;
   sqlstm.sqhstl[14] = (unsigned int  )5;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&l_ar_ihdr_post_year;
   sqlstm.sqhstl[15] = (unsigned int  )7;
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
         err_mesg("INSERT failed on table AR_CUST_TRN",0,"");
  } /* if amount != 0 */


   if (l_trn_type == 'A')
   {

   /* EXEC SQL UPDATE AR_CUSTOMER
               SET OUTSTANDING_BALANCE_AMT = 
                        NVL(OUTSTANDING_BALANCE_AMT,0) + 
                    decode(:d_ar_adj_type,'D',:l_ar_ihdr_doc_amt,
                                         -1 * :l_ar_ihdr_doc_amt)
             WHERE CUST_CODE = :l_ar_ihdr_cust_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update AR_CUSTOMER  set OUTSTANDING_BALANCE_AMT=(NVL(OUTST\
ANDING_BALANCE_AMT,0)+decode(:b0,'D',:b1,((-1)* :b1))) where CUST_CODE=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )784;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_adj_type;
   sqlstm.sqhstl[0] = (unsigned int  )1;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_doc_amt;
   sqlstm.sqhstl[1] = (unsigned int  )21;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_doc_amt;
   sqlstm.sqhstl[2] = (unsigned int  )21;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_cust_code;
   sqlstm.sqhstl[3] = (unsigned int  )10;
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
          err_mesg("UPDATE failed on table AR_CUSTOMER",0,"");

   }

}

dn_post_ar_insertings(l_adj_type,l_trn_type)
char l_adj_type,l_trn_type;
{
 /* EXEC SQL BEGIN DECLARE SECTION; */ 

    char d_ar_adj_type;
 /* EXEC SQL END DECLARE SECTION; */ 


    d_ar_adj_type = l_adj_type;

   /* EXEC SQL INSERT INTO SY_DOC_CONTROL
      (
         ACC_ENTITY_CODE,
         MODULE_ID,
         DOC_TYPE_CODE,
         DOC_NUM,
         DOC_DATE,
         POSTED_DATE,
         DOC_STATUS,
         NARRATION,
         POST_MONTH,
         POST_YEAR,
         ADDED_BY_ID,
         MODIFIED_BY_ID,
         ADDED_DATE,
         MODIFIED_DATE
      )
   VALUES 
      (
         :l_ar_hdr_acc_entity_code,
         'AR',
         :l_ar_hdr_doc_type_code,
         :l_ar_hdr_doc_num,
         to_date(:l_ar_hdr_doc_date,'DD/MM/YYYY'),
         SYSDATE,
         'P',
         :l_narration,
         :l_ar_hdr_post_month,
         :l_ar_hdr_post_year,
         USER,
         USER,
         SYSDATE,
         SYSDATE
       ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_DOC_CONTROL (ACC_ENTITY_CODE,MODULE_ID,DOC_\
TYPE_CODE,DOC_NUM,DOC_DATE,POSTED_DATE,DOC_STATUS,NARRATION,POST_MONTH,POST_YE\
AR,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE) values (:b0,'AR',:b1,:\
b2,to_date(:b3,'DD/MM/YYYY'),SYSDATE,'P',:b4,:b5,:b6,USER,USER,SYSDATE,SYSDATE\
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )815;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_ar_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_ar_hdr_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_narration;
   sqlstm.sqhstl[4] = (unsigned int  )53;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_ar_hdr_post_month;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_ar_hdr_post_year;
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
         err_mesg("INSERT failed on table SY_DOC_CONTROL",0,"");

   if (l_trn_type != 'A')
   {
   /* EXEC SQL UPDATE AR_CUSTOMER
               SET OUTSTANDING_BALANCE_AMT = 
                        NVL(OUTSTANDING_BALANCE_AMT,0) + 
                    decode(:d_ar_adj_type,'D',:l_ar_hdr_doc_amt,
                                         -1 * :l_ar_hdr_doc_amt)
             WHERE CUST_CODE = :l_ar_hdr_cust_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update AR_CUSTOMER  set OUTSTANDING_BALANCE_AMT=(NVL(OUTST\
ANDING_BALANCE_AMT,0)+decode(:b0,'D',:b1,((-1)* :b1))) where CUST_CODE=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )858;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_adj_type;
   sqlstm.sqhstl[0] = (unsigned int  )1;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_amt;
   sqlstm.sqhstl[1] = (unsigned int  )19;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_ar_hdr_doc_amt;
   sqlstm.sqhstl[2] = (unsigned int  )19;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_ar_hdr_cust_code;
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
        err_mesg("UPDATE failed on table AR_CUSTOMER",0,"");
   }


}

dn_post_open_ihdr(l_trn_type)
char l_trn_type;
{
   if (l_trn_type == 'D')
   {
      /* EXEC SQL OPEN DN_POST_INV_HDR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0007;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )889;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
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
            err_mesg("OPEN failed on cursor DN_POST_INV_HDR",0,"");
    }
    else if (l_trn_type == 'C')
   {
      /* EXEC SQL OPEN CN_POST_INV_HDR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0009;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )912;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
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
            err_mesg("OPEN failed on cursor CN_POST_INV_HDR",0,"");
    }
    else
    {
      /* EXEC SQL OPEN ADJ_POST_INV_HDR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlbuft((void **)0, 
        "select NVL(ACC_ENTITY_CODE,' ') ,DOC_TYPE_CODE ,DOC_NUM ,ORG_DOC_TY\
PE_CODE ,ORG_DOC_NUM ,NVL(LAST_LINE_NUM,0) ,NVL(CUST_CODE,' ') ,NVL(NARRATIO\
N,' ') ,TO_CHAR(BASE_DATE,'DD/MM/YYYY') ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,NVL\
(GROSS_AMT,0) ,NVL(PAYABLE_AMT,0) ,NVL(DISCOUNT_AMT,0) ,NVL(DOC_AMT,0) ,NVL(\
CURRENCY_CODE,' ') ,NVL(EXCHG_RATE,0) ,NVL(PMNT_TERMS_CODE,' ') ,TO_CHAR(SET\
TLEMENT_DATE,'DD/MM/YYYY') ,NVL(SETTLEMENT_PERC,0) ,NVL(CUST_REF,' ') ,NVL(P\
ATIENT_ID,' ') ,NVL(BILLING_GROUP,' ') ,NVL(BILL_DOC_TYPE_CODE,' ') ,NVL(BIL\
L_NUM,0) ,TO_CHAR(BILL_DATE,'DD/MM/YYYY') ,NVL(DOCTOR_FEE_AMT,0) ,NVL(MAIN_A\
CC1_CODE,' ') ,NVL(MAIN_ACC2_CODE,' ') ,NVL(SUBLEDGER_GROUP_CODE,' ') ,NVL(S\
UBLEDGER_LINE_CODE,' ') ,NVL(DEPT_CODE,' ') ,NVL(PRODUCT_GROUP_CODE,' ') ,NV\
L(PRODUCT_LINE_CODE,' ') ,NVL(POST_MONTH,0) ,NVL(POST_YEAR,0) ,NVL(MISC_CUST\
_LONG_NAME,' ') ,NVL(MISC_CUST_SHORT_NAME,' ') ,NVL(MISC_CUST_ADD1_DESC,' ')\
 ,NVL(MISC_CUST_ADD2_DESC,' ') ,NVL(MISC_CUST_ADD3_DESC,' ') ,NVL(MISC_CUST_\
ZIP_DESC,' ') ,NVL(MISC_CUST_LONG_NAME_CHINES");
      sqlstm.stmt = sq0011;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )935;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
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
            err_mesg("OPEN failed on cursor ADJ_POST_INV_HDR",0,"");
    }

}

dn_post_open_line(l_trn_type)
char l_trn_type;
{
   if (l_trn_type == 'D')
   {
       /* EXEC SQL OPEN DN_POST_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 58;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0008;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )958;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_num;
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
             err_mesg("OPEN failed on cursor DN_POST_LINE",0,"");
    }
    else if (l_trn_type == 'C')
    {
       /* EXEC SQL OPEN CN_POST_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 58;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0010;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )989;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_num;
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
             err_mesg("OPEN failed on cursor CN_POST_LINE",0,"");
    }
    else 
    {
       /* EXEC SQL OPEN ADJ_POST_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 58;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0012;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1020;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_num;
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
             err_mesg("OPEN failed on cursor ADJ_POST_LINE",0,"");
     }

}

dn_post_select_rec(l_trn_type)
char l_trn_type;
{
l_ar_hdr_acc_entity_code.arr[0]             = '\0';
l_ar_hdr_cust_code.arr[0]                   = '\0';
l_ar_hdr_doc_date.arr[0]                    = '\0';
l_ar_hdr_doc_amt.arr[0]                     = '\0';
l_ar_hdr_post_month.arr[0]                  = '\0';
l_ar_hdr_post_year.arr[0]                   = '\0';
l_ar_hdr_misc_clong_name.arr[0]         = '\0';
l_ar_hdr_misc_cshort_name.arr[0]        = '\0';
l_ar_hdr_misc_cadd1_desc.arr[0]         = '\0';
l_ar_hdr_misc_cadd2_desc.arr[0]         = '\0';
l_ar_hdr_misc_cadd3_desc.arr[0]         = '\0';
l_ar_hdr_misc_czip_desc.arr[0]          = '\0';
l_ar_hdr_misc_long_chinese.arr[0]           = '\0';
l_ar_hdr_misc_short_chinese.arr[0]          = '\0';
l_ar_hdr_misc_add1_chinese.arr[0]           = '\0';
l_ar_hdr_misc_add2_chinese.arr[0]           = '\0';
l_ar_hdr_misc_add3_chinese.arr[0]           = '\0';
l_ar_hdr_misc_zip_chinese.arr[0]            = '\0';
l_ar_hdr_tel_num.arr[0]                     = '\0';
l_ar_hdr_contact_name.arr[0]                = '\0';
l_ar_hdr_contact_name_title.arr[0]          = '\0';
l_ar_hdr_error_flag.arr[0]                  = '\0';
l_ar_hdr_print_flag.arr[0]                  = '\0';
l_ar_hdr_rowid.arr[0]                       = '\0';

l_ar_hdr_acc_entity_code.len                = 0;
l_ar_hdr_cust_code.len                      = 0;
l_ar_hdr_doc_date.len                       = 0;
l_ar_hdr_doc_amt.len                        = 0;
l_ar_hdr_post_month.len                     = 0;
l_ar_hdr_post_year.len                      = 0;
l_ar_hdr_misc_clong_name.len            = 0;
l_ar_hdr_misc_cshort_name.len           = 0;
l_ar_hdr_misc_cadd1_desc.len            = 0;
l_ar_hdr_misc_cadd2_desc.len            = 0;
l_ar_hdr_misc_cadd3_desc.len            = 0;
l_ar_hdr_misc_czip_desc.len             = 0;
l_ar_hdr_misc_long_chinese.len              = 0;
l_ar_hdr_misc_short_chinese.len             = 0;
l_ar_hdr_misc_add1_chinese.len              = 0;
l_ar_hdr_misc_add2_chinese.len              = 0;
l_ar_hdr_misc_add3_chinese.len              = 0;
l_ar_hdr_misc_zip_chinese.len               = 0;
l_ar_hdr_tel_num.len                        = 0;
l_ar_hdr_contact_name.len                   = 0;
l_ar_hdr_contact_name_title.len             = 0;
l_ar_hdr_error_flag.len                     = 0;
l_ar_hdr_print_flag.len                     = 0;
l_ar_hdr_rowid.len                          = 0;

if (l_trn_type == 'D')
{        

   l_ar_hdr_doc_date.arr[0]                    = '\0';
   l_ar_hdr_doc_date.len                       = 0;
   
   
   /* EXEC SQL SELECT  DOC_TYPE_CODE,
                    DOC_NUM,
                    NVL(ACC_ENTITY_CODE,' '),
                    NVL(CUST_CODE,' '),
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    NVL(DOC_AMT,0),
                    NVL(POST_MONTH,0),
                    NVL(POST_YEAR,0),
                    NVL(MISC_CUST_LONG_NAME,' '),
                    NVL(MISC_CUST_SHORT_NAME,' '),
                    NVL(MISC_CUST_ADD1_DESC,' '),
                    NVL(MISC_CUST_ADD2_DESC,' '),
                    NVL(MISC_CUST_ADD3_DESC,' '),
                    NVL(MISC_CUST_ZIP_DESC,' '),
                    NVL(MISC_CUST_LONG_NAME_CHINESE,' '),
                    NVL(MISC_CUST_SHORT_NAME_CHINESE,' '),
                    NVL(MISC_CUST_ADD1_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ADD2_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ADD3_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ZIP_DESC_CHINESE,' '),
                    NVL(TEL_NUM,' '),
                    NVL(CONTACT_NAME,' '),
                    NVL(CONTACT_NAME_TITLE,' '),
                    NVL(ERROR_FLAG,' '),
                    NVL(PRINT_FLAG,' ')
             INTO   
                    :l_ar_hdr_doc_type_code,
                    :l_ar_hdr_doc_num,
                    :l_ar_hdr_acc_entity_code,
                    :l_ar_hdr_cust_code,
                    :l_ar_hdr_doc_date,
                    :l_ar_hdr_doc_amt,
                    :l_ar_hdr_post_month,
                    :l_ar_hdr_post_year,
                    :l_ar_hdr_misc_clong_name,
                    :l_ar_hdr_misc_cshort_name,
                    :l_ar_hdr_misc_cadd1_desc,
                    :l_ar_hdr_misc_cadd2_desc,
                    :l_ar_hdr_misc_cadd3_desc,
                    :l_ar_hdr_misc_czip_desc,
                    :l_ar_hdr_misc_long_chinese,
                    :l_ar_hdr_misc_short_chinese,
                    :l_ar_hdr_misc_add1_chinese,
                    :l_ar_hdr_misc_add2_chinese,
                    :l_ar_hdr_misc_add3_chinese,
                    :l_ar_hdr_misc_zip_chinese,
                    :l_ar_hdr_tel_num,
                    :l_ar_hdr_contact_name,
                    :l_ar_hdr_contact_name_title,
                    :l_ar_hdr_error_flag,
                    :l_ar_hdr_print_flag
               FROM AR_DN_HDR
              WHERE ROWID = :hdr_rowid_passed; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DOC_TYPE_CODE ,DOC_NUM ,NVL(ACC_ENTITY_CODE,' ') ,N\
VL(CUST_CODE,' ') ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,NVL(DOC_AMT,0) ,NVL(POST_MO\
NTH,0) ,NVL(POST_YEAR,0) ,NVL(MISC_CUST_LONG_NAME,' ') ,NVL(MISC_CUST_SHORT_NA\
ME,' ') ,NVL(MISC_CUST_ADD1_DESC,' ') ,NVL(MISC_CUST_ADD2_DESC,' ') ,NVL(MISC_\
CUST_ADD3_DESC,' ') ,NVL(MISC_CUST_ZIP_DESC,' ') ,NVL(MISC_CUST_LONG_NAME_CHIN\
ESE,' ') ,NVL(MISC_CUST_SHORT_NAME_CHINESE,' ') ,NVL(MISC_CUST_ADD1_DESC_CHINE\
SE,' ') ,NVL(MISC_CUST_ADD2_DESC_CHINESE,' ') ,NVL(MISC_CUST_ADD3_DESC_CHINESE\
,' ') ,NVL(MISC_CUST_ZIP_DESC_CHINESE,' ') ,NVL(TEL_NUM,' ') ,NVL(CONTACT_NAME\
,' ') ,NVL(CONTACT_NAME_TITLE,' ') ,NVL(ERROR_FLAG,' ') ,NVL(PRINT_FLAG,' ') i\
nto :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16\
,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24  from AR_DN_HDR where ROWID=:b25";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1051;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_ar_hdr_acc_entity_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_ar_hdr_cust_code;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_ar_hdr_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )14;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_ar_hdr_doc_amt;
   sqlstm.sqhstl[5] = (unsigned int  )19;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_ar_hdr_post_month;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_ar_hdr_post_year;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_ar_hdr_misc_clong_name;
   sqlstm.sqhstl[8] = (unsigned int  )43;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_ar_hdr_misc_cshort_name;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_ar_hdr_misc_cadd1_desc;
   sqlstm.sqhstl[10] = (unsigned int  )33;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_ar_hdr_misc_cadd2_desc;
   sqlstm.sqhstl[11] = (unsigned int  )33;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&l_ar_hdr_misc_cadd3_desc;
   sqlstm.sqhstl[12] = (unsigned int  )33;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&l_ar_hdr_misc_czip_desc;
   sqlstm.sqhstl[13] = (unsigned int  )33;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&l_ar_hdr_misc_long_chinese;
   sqlstm.sqhstl[14] = (unsigned int  )43;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&l_ar_hdr_misc_short_chinese;
   sqlstm.sqhstl[15] = (unsigned int  )18;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&l_ar_hdr_misc_add1_chinese;
   sqlstm.sqhstl[16] = (unsigned int  )33;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&l_ar_hdr_misc_add2_chinese;
   sqlstm.sqhstl[17] = (unsigned int  )33;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&l_ar_hdr_misc_add3_chinese;
   sqlstm.sqhstl[18] = (unsigned int  )33;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&l_ar_hdr_misc_zip_chinese;
   sqlstm.sqhstl[19] = (unsigned int  )33;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&l_ar_hdr_tel_num;
   sqlstm.sqhstl[20] = (unsigned int  )33;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&l_ar_hdr_contact_name;
   sqlstm.sqhstl[21] = (unsigned int  )43;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&l_ar_hdr_contact_name_title;
   sqlstm.sqhstl[22] = (unsigned int  )43;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&l_ar_hdr_error_flag;
   sqlstm.sqhstl[23] = (unsigned int  )4;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&l_ar_hdr_print_flag;
   sqlstm.sqhstl[24] = (unsigned int  )4;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&hdr_rowid_passed;
   sqlstm.sqhstl[25] = (unsigned int  )33;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
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
         err_mesg("SELECT failed on table AR_DN_HDR - ar_posting ",0,"");
    if (NOT_FOUND)
    {
       err_mesg("Record not found in AR_DN_HDR - ar post - AR",0,"");
    }
  }
  else if (l_trn_type == 'C')
  {
   /* EXEC SQL SELECT  DOC_TYPE_CODE,
                    DOC_NUM,
                    NVL(ACC_ENTITY_CODE,' '),
                    NVL(CUST_CODE,' '),
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    NVL(DOC_AMT,0),
                    NVL(POST_MONTH,0),
                    NVL(POST_YEAR,0),
                    NVL(MISC_CUST_LONG_NAME,' '),
                    NVL(MISC_CUST_SHORT_NAME,' '),
                    NVL(MISC_CUST_ADD1_DESC,' '),
                    NVL(MISC_CUST_ADD2_DESC,' '),
                    NVL(MISC_CUST_ADD3_DESC,' '),
                    NVL(MISC_CUST_ZIP_DESC,' '),
                    NVL(MISC_CUST_LONG_NAME_CHINESE,' '),
                    NVL(MISC_CUST_SHORT_NAME_CHINESE,' '),
                    NVL(MISC_CUST_ADD1_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ADD2_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ADD3_DESC_CHINESE,' '),
                    NVL(MISC_CUST_ZIP_DESC_CHINESE,' '),
                    NVL(TEL_NUM,' '),
                    NVL(CONTACT_NAME,' '),
                    NVL(CONTACT_NAME_TITLE,' '),
                    NVL(ERROR_FLAG,' '),
                    NVL(PRINT_FLAG,' ')
             INTO   
                    :l_ar_hdr_doc_type_code,
                    :l_ar_hdr_doc_num,
                    :l_ar_hdr_acc_entity_code,
                    :l_ar_hdr_cust_code,
                    :l_ar_hdr_doc_date,
                    :l_ar_hdr_doc_amt,
                    :l_ar_hdr_post_month,
                    :l_ar_hdr_post_year,
                    :l_ar_hdr_misc_clong_name,
                    :l_ar_hdr_misc_cshort_name,
                    :l_ar_hdr_misc_cadd1_desc,
                    :l_ar_hdr_misc_cadd2_desc,
                    :l_ar_hdr_misc_cadd3_desc,
                    :l_ar_hdr_misc_czip_desc,
                    :l_ar_hdr_misc_long_chinese,
                    :l_ar_hdr_misc_short_chinese,
                    :l_ar_hdr_misc_add1_chinese,
                    :l_ar_hdr_misc_add2_chinese,
                    :l_ar_hdr_misc_add3_chinese,
                    :l_ar_hdr_misc_zip_chinese,
                    :l_ar_hdr_tel_num,
                    :l_ar_hdr_contact_name,
                    :l_ar_hdr_contact_name_title,
                    :l_ar_hdr_error_flag,
                    :l_ar_hdr_print_flag
               FROM AR_CN_HDR
              WHERE ROWID = :hdr_rowid_passed; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DOC_TYPE_CODE ,DOC_NUM ,NVL(ACC_ENTITY_CODE,' ') ,N\
VL(CUST_CODE,' ') ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,NVL(DOC_AMT,0) ,NVL(POST_MO\
NTH,0) ,NVL(POST_YEAR,0) ,NVL(MISC_CUST_LONG_NAME,' ') ,NVL(MISC_CUST_SHORT_NA\
ME,' ') ,NVL(MISC_CUST_ADD1_DESC,' ') ,NVL(MISC_CUST_ADD2_DESC,' ') ,NVL(MISC_\
CUST_ADD3_DESC,' ') ,NVL(MISC_CUST_ZIP_DESC,' ') ,NVL(MISC_CUST_LONG_NAME_CHIN\
ESE,' ') ,NVL(MISC_CUST_SHORT_NAME_CHINESE,' ') ,NVL(MISC_CUST_ADD1_DESC_CHINE\
SE,' ') ,NVL(MISC_CUST_ADD2_DESC_CHINESE,' ') ,NVL(MISC_CUST_ADD3_DESC_CHINESE\
,' ') ,NVL(MISC_CUST_ZIP_DESC_CHINESE,' ') ,NVL(TEL_NUM,' ') ,NVL(CONTACT_NAME\
,' ') ,NVL(CONTACT_NAME_TITLE,' ') ,NVL(ERROR_FLAG,' ') ,NVL(PRINT_FLAG,' ') i\
nto :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16\
,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24  from AR_CN_HDR where ROWID=:b25";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1170;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_ar_hdr_acc_entity_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_ar_hdr_cust_code;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_ar_hdr_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )14;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_ar_hdr_doc_amt;
   sqlstm.sqhstl[5] = (unsigned int  )19;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_ar_hdr_post_month;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_ar_hdr_post_year;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_ar_hdr_misc_clong_name;
   sqlstm.sqhstl[8] = (unsigned int  )43;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_ar_hdr_misc_cshort_name;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_ar_hdr_misc_cadd1_desc;
   sqlstm.sqhstl[10] = (unsigned int  )33;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_ar_hdr_misc_cadd2_desc;
   sqlstm.sqhstl[11] = (unsigned int  )33;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&l_ar_hdr_misc_cadd3_desc;
   sqlstm.sqhstl[12] = (unsigned int  )33;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&l_ar_hdr_misc_czip_desc;
   sqlstm.sqhstl[13] = (unsigned int  )33;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&l_ar_hdr_misc_long_chinese;
   sqlstm.sqhstl[14] = (unsigned int  )43;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&l_ar_hdr_misc_short_chinese;
   sqlstm.sqhstl[15] = (unsigned int  )18;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&l_ar_hdr_misc_add1_chinese;
   sqlstm.sqhstl[16] = (unsigned int  )33;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&l_ar_hdr_misc_add2_chinese;
   sqlstm.sqhstl[17] = (unsigned int  )33;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&l_ar_hdr_misc_add3_chinese;
   sqlstm.sqhstl[18] = (unsigned int  )33;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&l_ar_hdr_misc_zip_chinese;
   sqlstm.sqhstl[19] = (unsigned int  )33;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&l_ar_hdr_tel_num;
   sqlstm.sqhstl[20] = (unsigned int  )33;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&l_ar_hdr_contact_name;
   sqlstm.sqhstl[21] = (unsigned int  )43;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&l_ar_hdr_contact_name_title;
   sqlstm.sqhstl[22] = (unsigned int  )43;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&l_ar_hdr_error_flag;
   sqlstm.sqhstl[23] = (unsigned int  )4;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&l_ar_hdr_print_flag;
   sqlstm.sqhstl[24] = (unsigned int  )4;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&hdr_rowid_passed;
   sqlstm.sqhstl[25] = (unsigned int  )33;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
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
         err_mesg("SELECT failed on table AR_CN_HDR - ar_posting ",0,"");
    if (NOT_FOUND)
    {
       err_mesg("Record not found in AR_CN_HDR - ar post - AR",0,"");
    }
  }
  else 
  {
   /* EXEC SQL SELECT  DOC_TYPE_CODE,
                    DOC_NUM,
                    ACC_ENTITY_CODE,
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    NVL(DOC_AMT,0),
                    NVL(POST_MONTH,0),
                    NVL(POST_YEAR,0),
                    NVL(ERROR_FLAG,' '),
                    NVL(PRINT_FLAG,' ')
             INTO   
                    :l_ar_hdr_doc_type_code,
                    :l_ar_hdr_doc_num,
                    :l_ar_hdr_acc_entity_code,
                    :l_ar_hdr_doc_date,
                    :l_ar_hdr_doc_amt,
                    :l_ar_hdr_post_month,
                    :l_ar_hdr_post_year,
                    :l_ar_hdr_error_flag,
                    :l_ar_hdr_print_flag
              FROM AR_ADJ_HDR
              WHERE ROWID = :hdr_rowid_passed; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DOC_TYPE_CODE ,DOC_NUM ,ACC_ENTITY_CODE ,TO_CHAR(DO\
C_DATE,'DD/MM/YYYY') ,NVL(DOC_AMT,0) ,NVL(POST_MONTH,0) ,NVL(POST_YEAR,0) ,NVL\
(ERROR_FLAG,' ') ,NVL(PRINT_FLAG,' ') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8\
  from AR_ADJ_HDR where ROWID=:b9";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1289;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_ar_hdr_acc_entity_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_ar_hdr_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_ar_hdr_doc_amt;
   sqlstm.sqhstl[4] = (unsigned int  )19;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_ar_hdr_post_month;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_ar_hdr_post_year;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_ar_hdr_error_flag;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_ar_hdr_print_flag;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&hdr_rowid_passed;
   sqlstm.sqhstl[9] = (unsigned int  )33;
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
         err_mesg("SELECT failed on table AR_ADJ_HDR - ar_posting ",0,"");

    if (NOT_FOUND)
    {
       err_mesg("Record not found in AR_ADJ_HDR - ar post - AR",0,"");
    }
  }
  

l_ar_hdr_acc_entity_code.arr[l_ar_hdr_acc_entity_code.len]               = '\0';
l_ar_hdr_cust_code.arr[l_ar_hdr_cust_code.len]                           = '\0';
l_ar_hdr_doc_date.arr[l_ar_hdr_doc_date.len]                             = '\0';
l_ar_hdr_doc_amt.arr[l_ar_hdr_doc_amt.len]                               = '\0';
l_ar_hdr_post_month.arr[l_ar_hdr_post_month.len]                         = '\0';
l_ar_hdr_post_year.arr[l_ar_hdr_post_year.len]                           = '\0';
l_ar_hdr_misc_clong_name.arr[l_ar_hdr_misc_clong_name.len]       = '\0';
l_ar_hdr_misc_cshort_name.arr[l_ar_hdr_misc_cshort_name.len]     = '\0';
l_ar_hdr_misc_cadd1_desc.arr[l_ar_hdr_misc_cadd1_desc.len]       = '\0';
l_ar_hdr_misc_cadd2_desc.arr[l_ar_hdr_misc_cadd2_desc.len]       = '\0';
l_ar_hdr_misc_cadd3_desc.arr[l_ar_hdr_misc_cadd3_desc.len]       = '\0';
l_ar_hdr_misc_czip_desc.arr[l_ar_hdr_misc_czip_desc.len]         = '\0';
l_ar_hdr_misc_long_chinese.arr[l_ar_hdr_misc_long_chinese.len]           = '\0';
l_ar_hdr_misc_short_chinese.arr[l_ar_hdr_misc_short_chinese.len]         = '\0';
l_ar_hdr_misc_add1_chinese.arr[l_ar_hdr_misc_add1_chinese.len]           = '\0';
l_ar_hdr_misc_add2_chinese.arr[l_ar_hdr_misc_add2_chinese.len]           = '\0';
l_ar_hdr_misc_add3_chinese.arr[l_ar_hdr_misc_add3_chinese.len]           = '\0';
l_ar_hdr_misc_zip_chinese.arr[l_ar_hdr_misc_zip_chinese.len]             = '\0';
l_ar_hdr_tel_num.arr[l_ar_hdr_tel_num.len]                               = '\0';
l_ar_hdr_contact_name.arr[l_ar_hdr_contact_name.len]                     = '\0';
l_ar_hdr_contact_name_title.arr[l_ar_hdr_contact_name_title.len]         = '\0';
l_ar_hdr_error_flag.arr[l_ar_hdr_error_flag.len]                         = '\0';
l_ar_hdr_print_flag.arr[l_ar_hdr_print_flag.len]                         = '\0';
l_ar_hdr_rowid.arr[l_ar_hdr_rowid.len]                                   = '\0';

   
}

dn_post_fetch_dn_inv_hdr(l_trn_type)
char l_trn_type;
{
l_ar_ihdr_acc_entity_code.arr[0]         = '\0';
l_ar_ihdr_doc_type_code.arr[0]           = '\0';
l_ar_ihdr_bill_type_code.arr[0]           = '\0';
l_ar_ihdr_doc_num.arr[0]                 = '\0';
l_ar_ihdr_org_doc_type_code.arr[0]       = '\0';
l_ar_ihdr_org_doc_num.arr[0]             = '\0';
l_ar_ihdr_last_line_num.arr[0]           = '\0';
l_ar_ihdr_cust_code.arr[0]               = '\0';
l_ar_ihdr_narration.arr[0]               = '\0';
l_ar_ihdr_base_date.arr[0]               = '\0';
l_ar_ihdr_due_date.arr[0]                = '\0';
l_ar_ihdr_gross_amt.arr[0]               = '\0';
l_ar_ihdr_payable_amt.arr[0]             = '\0';
l_ar_ihdr_discount_amt.arr[0]            = '\0';
l_ar_ihdr_doc_amt.arr[0]                 = '\0';
l_ar_ihdr_currency_code.arr[0]           = '\0';
l_ar_ihdr_exchg_rate.arr[0]              = '\0';
l_ar_ihdr_pmnt_terms_code.arr[0]         = '\0';
l_ar_ihdr_settlement_date.arr[0]         = '\0';
l_ar_ihdr_settlement_perc.arr[0]         = '\0';
l_ar_ihdr_cust_ref.arr[0]                = '\0';
l_ar_ihdr_patient_id.arr[0]              = '\0';
l_ar_ihdr_billing_group.arr[0]           = '\0';
l_ar_ihdr_bill_doc_type_code.arr[0]      = '\0';
l_ar_ihdr_bill_num.arr[0]                = '\0';
l_ar_ihdr_bill_date.arr[0]               = '\0';
l_ar_ihdr_doctor_fee_amt.arr[0]          = '\0';
l_ar_ihdr_main_acc1_code.arr[0]          = '\0';
l_ar_ihdr_main_acc2_code.arr[0]          = '\0';
l_ar_ihdr_sub_group_code.arr[0]    = '\0';
l_ar_ihdr_sub_line_code.arr[0]     = '\0';
l_ar_ihdr_dept_code.arr[0]               = '\0';
l_ar_ihdr_product_group_code.arr[0]      = '\0';
l_ar_ihdr_product_line_code.arr[0]       = '\0';
l_ar_ihdr_post_month.arr[0]              = '\0';
l_ar_ihdr_post_year.arr[0]               = '\0';
l_ar_ihdr_rowid.arr[0]                   = '\0';
l_ar_ihdr_adj_type.arr[0]                = '\0';
l_consolidated_yn.arr[0] = '\0';


l_ar_ihdr_acc_entity_code.len            = 0;
l_ar_ihdr_doc_type_code.len              = 0;
l_ar_ihdr_bill_type_code.len             = 0;
l_ar_ihdr_doc_num.len                    = 0;
l_ar_ihdr_org_doc_type_code.len          = 0;
l_ar_ihdr_org_doc_num.len                = 0;
l_ar_ihdr_last_line_num.len              = 0;
l_ar_ihdr_cust_code.len                  = 0;
l_ar_ihdr_narration.len                  = 0;
l_ar_ihdr_base_date.len                  = 0;
l_ar_ihdr_due_date.len                   = 0;
l_ar_ihdr_gross_amt.len                  = 0;
l_ar_ihdr_payable_amt.len                = 0;
l_ar_ihdr_discount_amt.len               = 0;
l_ar_ihdr_doc_amt.len                    = 0;
l_ar_ihdr_currency_code.len              = 0;
l_ar_ihdr_exchg_rate.len                 = 0;
l_ar_ihdr_pmnt_terms_code.len            = 0;
l_ar_ihdr_settlement_date.len            = 0;
l_ar_ihdr_settlement_perc.len            = 0;
l_ar_ihdr_cust_ref.len                   = 0;
l_ar_ihdr_patient_id.len                 = 0;
l_ar_ihdr_billing_group.len              = 0;
l_ar_ihdr_bill_doc_type_code.len         = 0;
l_ar_ihdr_bill_num.len                   = 0;
l_ar_ihdr_bill_date.len                  = 0;
l_ar_ihdr_doctor_fee_amt.len             = 0;
l_ar_ihdr_main_acc1_code.len             = 0;
l_ar_ihdr_main_acc2_code.len             = 0;
l_ar_ihdr_sub_group_code.len       = 0;
l_ar_ihdr_sub_line_code.len        = 0;
l_ar_ihdr_dept_code.len                  = 0;
l_ar_ihdr_product_group_code.len         = 0;
l_ar_ihdr_product_line_code.len          = 0;
l_ar_ihdr_post_month.len                 = 0;
l_ar_ihdr_post_year.len                  = 0;
l_ar_ihdr_rowid.len                      = 0;
l_ar_ihdr_adj_type.len                   = 0;
l_consolidated_yn.len  = 0;

if (l_trn_type == 'D')
{
      /* EXEC SQL FETCH DN_POST_INV_HDR
                INTO :l_ar_ihdr_acc_entity_code,
                     :l_ar_ihdr_doc_type_code,
                     :l_ar_ihdr_doc_num,
                     :l_ar_ihdr_org_doc_type_code,
                     :l_ar_ihdr_org_doc_num,
                     :l_ar_ihdr_last_line_num,
                     :l_ar_ihdr_cust_code,
                     :l_ar_ihdr_narration,
                     :l_ar_ihdr_base_date,
                     :l_ar_ihdr_due_date,
                     :l_ar_ihdr_gross_amt,
                     :l_ar_ihdr_payable_amt,
                     :l_ar_ihdr_discount_amt,
                     :l_ar_ihdr_doc_amt,
                     :l_ar_ihdr_currency_code,
                     :l_ar_ihdr_exchg_rate,
                     :l_ar_ihdr_pmnt_terms_code,
                     :l_ar_ihdr_settlement_date,
                     :l_ar_ihdr_settlement_perc,
                     :l_ar_ihdr_cust_ref,
                     :l_ar_ihdr_patient_id,
                     :l_ar_ihdr_billing_group,
                     :l_ar_ihdr_bill_doc_type_code,
                     :l_ar_ihdr_bill_num,
                     :l_ar_ihdr_bill_date,
                     :l_ar_ihdr_doctor_fee_amt,
                     :l_ar_ihdr_main_acc1_code,
                     :l_ar_ihdr_main_acc2_code,
                     :l_ar_ihdr_sub_group_code,
                     :l_ar_ihdr_sub_line_code,
                     :l_ar_ihdr_dept_code,
                     :l_ar_ihdr_product_group_code,
                     :l_ar_ihdr_product_line_code,
                     :l_ar_ihdr_post_month,
                     :l_ar_ihdr_post_year,
                     :l_ar_ihdr_bill_type_code,
                     :l_ar_ihdr_rowid,
					 :l_consolidated_yn; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1344;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_ihdr_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_ar_ihdr_org_doc_num;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_ar_ihdr_last_line_num;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_ar_ihdr_cust_code;
      sqlstm.sqhstl[6] = (unsigned int  )10;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_ar_ihdr_narration;
      sqlstm.sqhstl[7] = (unsigned int  )53;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&l_ar_ihdr_base_date;
      sqlstm.sqhstl[8] = (unsigned int  )14;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&l_ar_ihdr_due_date;
      sqlstm.sqhstl[9] = (unsigned int  )14;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&l_ar_ihdr_gross_amt;
      sqlstm.sqhstl[10] = (unsigned int  )21;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_ar_ihdr_payable_amt;
      sqlstm.sqhstl[11] = (unsigned int  )21;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_ar_ihdr_discount_amt;
      sqlstm.sqhstl[12] = (unsigned int  )21;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_ar_ihdr_doc_amt;
      sqlstm.sqhstl[13] = (unsigned int  )21;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&l_ar_ihdr_currency_code;
      sqlstm.sqhstl[14] = (unsigned int  )21;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&l_ar_ihdr_exchg_rate;
      sqlstm.sqhstl[15] = (unsigned int  )22;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&l_ar_ihdr_pmnt_terms_code;
      sqlstm.sqhstl[16] = (unsigned int  )5;
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&l_ar_ihdr_settlement_date;
      sqlstm.sqhstl[17] = (unsigned int  )14;
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&l_ar_ihdr_settlement_perc;
      sqlstm.sqhstl[18] = (unsigned int  )9;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&l_ar_ihdr_cust_ref;
      sqlstm.sqhstl[19] = (unsigned int  )18;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqhstv[20] = (         void  *)&l_ar_ihdr_patient_id;
      sqlstm.sqhstl[20] = (unsigned int  )23;
      sqlstm.sqhsts[20] = (         int  )0;
      sqlstm.sqindv[20] = (         void  *)0;
      sqlstm.sqinds[20] = (         int  )0;
      sqlstm.sqharm[20] = (unsigned int  )0;
      sqlstm.sqadto[20] = (unsigned short )0;
      sqlstm.sqtdso[20] = (unsigned short )0;
      sqlstm.sqhstv[21] = (         void  *)&l_ar_ihdr_billing_group;
      sqlstm.sqhstl[21] = (unsigned int  )5;
      sqlstm.sqhsts[21] = (         int  )0;
      sqlstm.sqindv[21] = (         void  *)0;
      sqlstm.sqinds[21] = (         int  )0;
      sqlstm.sqharm[21] = (unsigned int  )0;
      sqlstm.sqadto[21] = (unsigned short )0;
      sqlstm.sqtdso[21] = (unsigned short )0;
      sqlstm.sqhstv[22] = (         void  *)&l_ar_ihdr_bill_doc_type_code;
      sqlstm.sqhstl[22] = (unsigned int  )9;
      sqlstm.sqhsts[22] = (         int  )0;
      sqlstm.sqindv[22] = (         void  *)0;
      sqlstm.sqinds[22] = (         int  )0;
      sqlstm.sqharm[22] = (unsigned int  )0;
      sqlstm.sqadto[22] = (unsigned short )0;
      sqlstm.sqtdso[22] = (unsigned short )0;
      sqlstm.sqhstv[23] = (         void  *)&l_ar_ihdr_bill_num;
      sqlstm.sqhstl[23] = (unsigned int  )11;
      sqlstm.sqhsts[23] = (         int  )0;
      sqlstm.sqindv[23] = (         void  *)0;
      sqlstm.sqinds[23] = (         int  )0;
      sqlstm.sqharm[23] = (unsigned int  )0;
      sqlstm.sqadto[23] = (unsigned short )0;
      sqlstm.sqtdso[23] = (unsigned short )0;
      sqlstm.sqhstv[24] = (         void  *)&l_ar_ihdr_bill_date;
      sqlstm.sqhstl[24] = (unsigned int  )14;
      sqlstm.sqhsts[24] = (         int  )0;
      sqlstm.sqindv[24] = (         void  *)0;
      sqlstm.sqinds[24] = (         int  )0;
      sqlstm.sqharm[24] = (unsigned int  )0;
      sqlstm.sqadto[24] = (unsigned short )0;
      sqlstm.sqtdso[24] = (unsigned short )0;
      sqlstm.sqhstv[25] = (         void  *)&l_ar_ihdr_doctor_fee_amt;
      sqlstm.sqhstl[25] = (unsigned int  )21;
      sqlstm.sqhsts[25] = (         int  )0;
      sqlstm.sqindv[25] = (         void  *)0;
      sqlstm.sqinds[25] = (         int  )0;
      sqlstm.sqharm[25] = (unsigned int  )0;
      sqlstm.sqadto[25] = (unsigned short )0;
      sqlstm.sqtdso[25] = (unsigned short )0;
      sqlstm.sqhstv[26] = (         void  *)&l_ar_ihdr_main_acc1_code;
      sqlstm.sqhstl[26] = (unsigned int  )9;
      sqlstm.sqhsts[26] = (         int  )0;
      sqlstm.sqindv[26] = (         void  *)0;
      sqlstm.sqinds[26] = (         int  )0;
      sqlstm.sqharm[26] = (unsigned int  )0;
      sqlstm.sqadto[26] = (unsigned short )0;
      sqlstm.sqtdso[26] = (unsigned short )0;
      sqlstm.sqhstv[27] = (         void  *)&l_ar_ihdr_main_acc2_code;
      sqlstm.sqhstl[27] = (unsigned int  )7;
      sqlstm.sqhsts[27] = (         int  )0;
      sqlstm.sqindv[27] = (         void  *)0;
      sqlstm.sqinds[27] = (         int  )0;
      sqlstm.sqharm[27] = (unsigned int  )0;
      sqlstm.sqadto[27] = (unsigned short )0;
      sqlstm.sqtdso[27] = (unsigned short )0;
      sqlstm.sqhstv[28] = (         void  *)&l_ar_ihdr_sub_group_code;
      sqlstm.sqhstl[28] = (unsigned int  )6;
      sqlstm.sqhsts[28] = (         int  )0;
      sqlstm.sqindv[28] = (         void  *)0;
      sqlstm.sqinds[28] = (         int  )0;
      sqlstm.sqharm[28] = (unsigned int  )0;
      sqlstm.sqadto[28] = (unsigned short )0;
      sqlstm.sqtdso[28] = (unsigned short )0;
      sqlstm.sqhstv[29] = (         void  *)&l_ar_ihdr_sub_line_code;
      sqlstm.sqhstl[29] = (unsigned int  )11;
      sqlstm.sqhsts[29] = (         int  )0;
      sqlstm.sqindv[29] = (         void  *)0;
      sqlstm.sqinds[29] = (         int  )0;
      sqlstm.sqharm[29] = (unsigned int  )0;
      sqlstm.sqadto[29] = (unsigned short )0;
      sqlstm.sqtdso[29] = (unsigned short )0;
      sqlstm.sqhstv[30] = (         void  *)&l_ar_ihdr_dept_code;
      sqlstm.sqhstl[30] = (unsigned int  )9;
      sqlstm.sqhsts[30] = (         int  )0;
      sqlstm.sqindv[30] = (         void  *)0;
      sqlstm.sqinds[30] = (         int  )0;
      sqlstm.sqharm[30] = (unsigned int  )0;
      sqlstm.sqadto[30] = (unsigned short )0;
      sqlstm.sqtdso[30] = (unsigned short )0;
      sqlstm.sqhstv[31] = (         void  *)&l_ar_ihdr_product_group_code;
      sqlstm.sqhstl[31] = (unsigned int  )6;
      sqlstm.sqhsts[31] = (         int  )0;
      sqlstm.sqindv[31] = (         void  *)0;
      sqlstm.sqinds[31] = (         int  )0;
      sqlstm.sqharm[31] = (unsigned int  )0;
      sqlstm.sqadto[31] = (unsigned short )0;
      sqlstm.sqtdso[31] = (unsigned short )0;
      sqlstm.sqhstv[32] = (         void  *)&l_ar_ihdr_product_line_code;
      sqlstm.sqhstl[32] = (unsigned int  )7;
      sqlstm.sqhsts[32] = (         int  )0;
      sqlstm.sqindv[32] = (         void  *)0;
      sqlstm.sqinds[32] = (         int  )0;
      sqlstm.sqharm[32] = (unsigned int  )0;
      sqlstm.sqadto[32] = (unsigned short )0;
      sqlstm.sqtdso[32] = (unsigned short )0;
      sqlstm.sqhstv[33] = (         void  *)&l_ar_ihdr_post_month;
      sqlstm.sqhstl[33] = (unsigned int  )5;
      sqlstm.sqhsts[33] = (         int  )0;
      sqlstm.sqindv[33] = (         void  *)0;
      sqlstm.sqinds[33] = (         int  )0;
      sqlstm.sqharm[33] = (unsigned int  )0;
      sqlstm.sqadto[33] = (unsigned short )0;
      sqlstm.sqtdso[33] = (unsigned short )0;
      sqlstm.sqhstv[34] = (         void  *)&l_ar_ihdr_post_year;
      sqlstm.sqhstl[34] = (unsigned int  )7;
      sqlstm.sqhsts[34] = (         int  )0;
      sqlstm.sqindv[34] = (         void  *)0;
      sqlstm.sqinds[34] = (         int  )0;
      sqlstm.sqharm[34] = (unsigned int  )0;
      sqlstm.sqadto[34] = (unsigned short )0;
      sqlstm.sqtdso[34] = (unsigned short )0;
      sqlstm.sqhstv[35] = (         void  *)&l_ar_ihdr_bill_type_code;
      sqlstm.sqhstl[35] = (unsigned int  )4;
      sqlstm.sqhsts[35] = (         int  )0;
      sqlstm.sqindv[35] = (         void  *)0;
      sqlstm.sqinds[35] = (         int  )0;
      sqlstm.sqharm[35] = (unsigned int  )0;
      sqlstm.sqadto[35] = (unsigned short )0;
      sqlstm.sqtdso[35] = (unsigned short )0;
      sqlstm.sqhstv[36] = (         void  *)&l_ar_ihdr_rowid;
      sqlstm.sqhstl[36] = (unsigned int  )33;
      sqlstm.sqhsts[36] = (         int  )0;
      sqlstm.sqindv[36] = (         void  *)0;
      sqlstm.sqinds[36] = (         int  )0;
      sqlstm.sqharm[36] = (unsigned int  )0;
      sqlstm.sqadto[36] = (unsigned short )0;
      sqlstm.sqtdso[36] = (unsigned short )0;
      sqlstm.sqhstv[37] = (         void  *)&l_consolidated_yn;
      sqlstm.sqhstl[37] = (unsigned int  )4;
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
         err_mesg("FETCH failed on cursor CUR_DN_INV_HDR",0,"");
}
else if (l_trn_type == 'C')
{
      /* EXEC SQL FETCH CN_POST_INV_HDR
                INTO :l_ar_ihdr_acc_entity_code,
                     :l_ar_ihdr_doc_type_code,
                     :l_ar_ihdr_doc_num,
                     :l_ar_ihdr_org_doc_type_code,
                     :l_ar_ihdr_org_doc_num,
                     :l_ar_ihdr_last_line_num,
                     :l_ar_ihdr_cust_code,
                     :l_ar_ihdr_narration,
                     :l_ar_ihdr_base_date,
                     :l_ar_ihdr_due_date,
                     :l_ar_ihdr_gross_amt,
                     :l_ar_ihdr_payable_amt,
                     :l_ar_ihdr_discount_amt,
                     :l_ar_ihdr_doc_amt,
                     :l_ar_ihdr_currency_code,
                     :l_ar_ihdr_exchg_rate,
                     :l_ar_ihdr_pmnt_terms_code,
                     :l_ar_ihdr_settlement_date,
                     :l_ar_ihdr_settlement_perc,
                     :l_ar_ihdr_cust_ref,
                     :l_ar_ihdr_patient_id,
                     :l_ar_ihdr_billing_group,
                     :l_ar_ihdr_bill_doc_type_code,
                     :l_ar_ihdr_bill_num,
                     :l_ar_ihdr_bill_date,
                     :l_ar_ihdr_doctor_fee_amt,
                     :l_ar_ihdr_main_acc1_code,
                     :l_ar_ihdr_main_acc2_code,
                     :l_ar_ihdr_sub_group_code,
                     :l_ar_ihdr_sub_line_code,
                     :l_ar_ihdr_dept_code,
                     :l_ar_ihdr_product_group_code,
                     :l_ar_ihdr_product_line_code,
                     :l_ar_ihdr_post_month,
                     :l_ar_ihdr_post_year,
                     :l_ar_ihdr_bill_type_code,
                     :l_ar_ihdr_rowid,
					 :l_consolidated_yn; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1511;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_ihdr_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_ar_ihdr_org_doc_num;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_ar_ihdr_last_line_num;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_ar_ihdr_cust_code;
      sqlstm.sqhstl[6] = (unsigned int  )10;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_ar_ihdr_narration;
      sqlstm.sqhstl[7] = (unsigned int  )53;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&l_ar_ihdr_base_date;
      sqlstm.sqhstl[8] = (unsigned int  )14;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&l_ar_ihdr_due_date;
      sqlstm.sqhstl[9] = (unsigned int  )14;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&l_ar_ihdr_gross_amt;
      sqlstm.sqhstl[10] = (unsigned int  )21;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_ar_ihdr_payable_amt;
      sqlstm.sqhstl[11] = (unsigned int  )21;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_ar_ihdr_discount_amt;
      sqlstm.sqhstl[12] = (unsigned int  )21;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_ar_ihdr_doc_amt;
      sqlstm.sqhstl[13] = (unsigned int  )21;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&l_ar_ihdr_currency_code;
      sqlstm.sqhstl[14] = (unsigned int  )21;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&l_ar_ihdr_exchg_rate;
      sqlstm.sqhstl[15] = (unsigned int  )22;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&l_ar_ihdr_pmnt_terms_code;
      sqlstm.sqhstl[16] = (unsigned int  )5;
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&l_ar_ihdr_settlement_date;
      sqlstm.sqhstl[17] = (unsigned int  )14;
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&l_ar_ihdr_settlement_perc;
      sqlstm.sqhstl[18] = (unsigned int  )9;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&l_ar_ihdr_cust_ref;
      sqlstm.sqhstl[19] = (unsigned int  )18;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqhstv[20] = (         void  *)&l_ar_ihdr_patient_id;
      sqlstm.sqhstl[20] = (unsigned int  )23;
      sqlstm.sqhsts[20] = (         int  )0;
      sqlstm.sqindv[20] = (         void  *)0;
      sqlstm.sqinds[20] = (         int  )0;
      sqlstm.sqharm[20] = (unsigned int  )0;
      sqlstm.sqadto[20] = (unsigned short )0;
      sqlstm.sqtdso[20] = (unsigned short )0;
      sqlstm.sqhstv[21] = (         void  *)&l_ar_ihdr_billing_group;
      sqlstm.sqhstl[21] = (unsigned int  )5;
      sqlstm.sqhsts[21] = (         int  )0;
      sqlstm.sqindv[21] = (         void  *)0;
      sqlstm.sqinds[21] = (         int  )0;
      sqlstm.sqharm[21] = (unsigned int  )0;
      sqlstm.sqadto[21] = (unsigned short )0;
      sqlstm.sqtdso[21] = (unsigned short )0;
      sqlstm.sqhstv[22] = (         void  *)&l_ar_ihdr_bill_doc_type_code;
      sqlstm.sqhstl[22] = (unsigned int  )9;
      sqlstm.sqhsts[22] = (         int  )0;
      sqlstm.sqindv[22] = (         void  *)0;
      sqlstm.sqinds[22] = (         int  )0;
      sqlstm.sqharm[22] = (unsigned int  )0;
      sqlstm.sqadto[22] = (unsigned short )0;
      sqlstm.sqtdso[22] = (unsigned short )0;
      sqlstm.sqhstv[23] = (         void  *)&l_ar_ihdr_bill_num;
      sqlstm.sqhstl[23] = (unsigned int  )11;
      sqlstm.sqhsts[23] = (         int  )0;
      sqlstm.sqindv[23] = (         void  *)0;
      sqlstm.sqinds[23] = (         int  )0;
      sqlstm.sqharm[23] = (unsigned int  )0;
      sqlstm.sqadto[23] = (unsigned short )0;
      sqlstm.sqtdso[23] = (unsigned short )0;
      sqlstm.sqhstv[24] = (         void  *)&l_ar_ihdr_bill_date;
      sqlstm.sqhstl[24] = (unsigned int  )14;
      sqlstm.sqhsts[24] = (         int  )0;
      sqlstm.sqindv[24] = (         void  *)0;
      sqlstm.sqinds[24] = (         int  )0;
      sqlstm.sqharm[24] = (unsigned int  )0;
      sqlstm.sqadto[24] = (unsigned short )0;
      sqlstm.sqtdso[24] = (unsigned short )0;
      sqlstm.sqhstv[25] = (         void  *)&l_ar_ihdr_doctor_fee_amt;
      sqlstm.sqhstl[25] = (unsigned int  )21;
      sqlstm.sqhsts[25] = (         int  )0;
      sqlstm.sqindv[25] = (         void  *)0;
      sqlstm.sqinds[25] = (         int  )0;
      sqlstm.sqharm[25] = (unsigned int  )0;
      sqlstm.sqadto[25] = (unsigned short )0;
      sqlstm.sqtdso[25] = (unsigned short )0;
      sqlstm.sqhstv[26] = (         void  *)&l_ar_ihdr_main_acc1_code;
      sqlstm.sqhstl[26] = (unsigned int  )9;
      sqlstm.sqhsts[26] = (         int  )0;
      sqlstm.sqindv[26] = (         void  *)0;
      sqlstm.sqinds[26] = (         int  )0;
      sqlstm.sqharm[26] = (unsigned int  )0;
      sqlstm.sqadto[26] = (unsigned short )0;
      sqlstm.sqtdso[26] = (unsigned short )0;
      sqlstm.sqhstv[27] = (         void  *)&l_ar_ihdr_main_acc2_code;
      sqlstm.sqhstl[27] = (unsigned int  )7;
      sqlstm.sqhsts[27] = (         int  )0;
      sqlstm.sqindv[27] = (         void  *)0;
      sqlstm.sqinds[27] = (         int  )0;
      sqlstm.sqharm[27] = (unsigned int  )0;
      sqlstm.sqadto[27] = (unsigned short )0;
      sqlstm.sqtdso[27] = (unsigned short )0;
      sqlstm.sqhstv[28] = (         void  *)&l_ar_ihdr_sub_group_code;
      sqlstm.sqhstl[28] = (unsigned int  )6;
      sqlstm.sqhsts[28] = (         int  )0;
      sqlstm.sqindv[28] = (         void  *)0;
      sqlstm.sqinds[28] = (         int  )0;
      sqlstm.sqharm[28] = (unsigned int  )0;
      sqlstm.sqadto[28] = (unsigned short )0;
      sqlstm.sqtdso[28] = (unsigned short )0;
      sqlstm.sqhstv[29] = (         void  *)&l_ar_ihdr_sub_line_code;
      sqlstm.sqhstl[29] = (unsigned int  )11;
      sqlstm.sqhsts[29] = (         int  )0;
      sqlstm.sqindv[29] = (         void  *)0;
      sqlstm.sqinds[29] = (         int  )0;
      sqlstm.sqharm[29] = (unsigned int  )0;
      sqlstm.sqadto[29] = (unsigned short )0;
      sqlstm.sqtdso[29] = (unsigned short )0;
      sqlstm.sqhstv[30] = (         void  *)&l_ar_ihdr_dept_code;
      sqlstm.sqhstl[30] = (unsigned int  )9;
      sqlstm.sqhsts[30] = (         int  )0;
      sqlstm.sqindv[30] = (         void  *)0;
      sqlstm.sqinds[30] = (         int  )0;
      sqlstm.sqharm[30] = (unsigned int  )0;
      sqlstm.sqadto[30] = (unsigned short )0;
      sqlstm.sqtdso[30] = (unsigned short )0;
      sqlstm.sqhstv[31] = (         void  *)&l_ar_ihdr_product_group_code;
      sqlstm.sqhstl[31] = (unsigned int  )6;
      sqlstm.sqhsts[31] = (         int  )0;
      sqlstm.sqindv[31] = (         void  *)0;
      sqlstm.sqinds[31] = (         int  )0;
      sqlstm.sqharm[31] = (unsigned int  )0;
      sqlstm.sqadto[31] = (unsigned short )0;
      sqlstm.sqtdso[31] = (unsigned short )0;
      sqlstm.sqhstv[32] = (         void  *)&l_ar_ihdr_product_line_code;
      sqlstm.sqhstl[32] = (unsigned int  )7;
      sqlstm.sqhsts[32] = (         int  )0;
      sqlstm.sqindv[32] = (         void  *)0;
      sqlstm.sqinds[32] = (         int  )0;
      sqlstm.sqharm[32] = (unsigned int  )0;
      sqlstm.sqadto[32] = (unsigned short )0;
      sqlstm.sqtdso[32] = (unsigned short )0;
      sqlstm.sqhstv[33] = (         void  *)&l_ar_ihdr_post_month;
      sqlstm.sqhstl[33] = (unsigned int  )5;
      sqlstm.sqhsts[33] = (         int  )0;
      sqlstm.sqindv[33] = (         void  *)0;
      sqlstm.sqinds[33] = (         int  )0;
      sqlstm.sqharm[33] = (unsigned int  )0;
      sqlstm.sqadto[33] = (unsigned short )0;
      sqlstm.sqtdso[33] = (unsigned short )0;
      sqlstm.sqhstv[34] = (         void  *)&l_ar_ihdr_post_year;
      sqlstm.sqhstl[34] = (unsigned int  )7;
      sqlstm.sqhsts[34] = (         int  )0;
      sqlstm.sqindv[34] = (         void  *)0;
      sqlstm.sqinds[34] = (         int  )0;
      sqlstm.sqharm[34] = (unsigned int  )0;
      sqlstm.sqadto[34] = (unsigned short )0;
      sqlstm.sqtdso[34] = (unsigned short )0;
      sqlstm.sqhstv[35] = (         void  *)&l_ar_ihdr_bill_type_code;
      sqlstm.sqhstl[35] = (unsigned int  )4;
      sqlstm.sqhsts[35] = (         int  )0;
      sqlstm.sqindv[35] = (         void  *)0;
      sqlstm.sqinds[35] = (         int  )0;
      sqlstm.sqharm[35] = (unsigned int  )0;
      sqlstm.sqadto[35] = (unsigned short )0;
      sqlstm.sqtdso[35] = (unsigned short )0;
      sqlstm.sqhstv[36] = (         void  *)&l_ar_ihdr_rowid;
      sqlstm.sqhstl[36] = (unsigned int  )33;
      sqlstm.sqhsts[36] = (         int  )0;
      sqlstm.sqindv[36] = (         void  *)0;
      sqlstm.sqinds[36] = (         int  )0;
      sqlstm.sqharm[36] = (unsigned int  )0;
      sqlstm.sqadto[36] = (unsigned short )0;
      sqlstm.sqtdso[36] = (unsigned short )0;
      sqlstm.sqhstv[37] = (         void  *)&l_consolidated_yn;
      sqlstm.sqhstl[37] = (unsigned int  )4;
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
         err_mesg("FETCH failed on cursor CUR_CN_INV_HDR",0,"");
  }
  else
  {
l_ar_hdr_misc_clong_name.arr[0]            = '\0';
l_ar_hdr_misc_cshort_name.arr[0]           = '\0';
l_ar_hdr_misc_cadd1_desc.arr[0]            = '\0';
l_ar_hdr_misc_cadd2_desc.arr[0]            = '\0';
l_ar_hdr_misc_cadd3_desc.arr[0]            = '\0';
l_ar_hdr_misc_czip_desc.arr[0]             = '\0';
l_ar_hdr_misc_long_chinese.arr[0]              = '\0';
l_ar_hdr_misc_short_chinese.arr[0]             = '\0';
l_ar_hdr_misc_add1_chinese.arr[0]              = '\0';
l_ar_hdr_misc_add2_chinese.arr[0]              = '\0';
l_ar_hdr_misc_add3_chinese.arr[0]              = '\0';
l_ar_hdr_misc_zip_chinese.arr[0]               = '\0';
l_ar_hdr_tel_num.arr[0]                        = '\0';
l_ar_hdr_contact_name.arr[0]                   = '\0';
l_ar_hdr_contact_name_title.arr[0]             = '\0';


l_ar_hdr_misc_clong_name.len               = 0;
l_ar_hdr_misc_cshort_name.len              = 0;
l_ar_hdr_misc_cadd1_desc.len               = 0;
l_ar_hdr_misc_cadd2_desc.len               = 0;
l_ar_hdr_misc_cadd3_desc.len               = 0;
l_ar_hdr_misc_czip_desc.len                = 0;
l_ar_hdr_misc_long_chinese.len                 = 0;
l_ar_hdr_misc_short_chinese.len                = 0;
l_ar_hdr_misc_add1_chinese.len                 = 0;
l_ar_hdr_misc_add2_chinese.len                 = 0;
l_ar_hdr_misc_add3_chinese.len                 = 0;
l_ar_hdr_misc_zip_chinese.len                  = 0;
l_ar_hdr_tel_num.len                           = 0;
l_ar_hdr_contact_name.len                      = 0;
l_ar_hdr_contact_name_title.len                = 0;

      /* EXEC SQL FETCH ADJ_POST_INV_HDR
                INTO :l_ar_ihdr_acc_entity_code,
                     :l_ar_ihdr_doc_type_code,
                     :l_ar_ihdr_doc_num,
                     :l_ar_ihdr_org_doc_type_code,
                     :l_ar_ihdr_org_doc_num,
                     :l_ar_ihdr_last_line_num,
                     :l_ar_ihdr_cust_code,
                     :l_ar_ihdr_narration,
                     :l_ar_ihdr_base_date,
                     :l_ar_ihdr_due_date,
                     :l_ar_ihdr_gross_amt,
                     :l_ar_ihdr_payable_amt,
                     :l_ar_ihdr_discount_amt,
                     :l_ar_ihdr_doc_amt,
                     :l_ar_ihdr_currency_code,
                     :l_ar_ihdr_exchg_rate,
                     :l_ar_ihdr_pmnt_terms_code,
                     :l_ar_ihdr_settlement_date,
                     :l_ar_ihdr_settlement_perc,
                     :l_ar_ihdr_cust_ref,
                     :l_ar_ihdr_patient_id,
                     :l_ar_ihdr_billing_group,
                     :l_ar_ihdr_bill_doc_type_code,
                     :l_ar_ihdr_bill_num,
                     :l_ar_ihdr_bill_date,
                     :l_ar_ihdr_doctor_fee_amt,
                     :l_ar_ihdr_main_acc1_code,
                     :l_ar_ihdr_main_acc2_code,
                     :l_ar_ihdr_sub_group_code,
                     :l_ar_ihdr_sub_line_code,
                     :l_ar_ihdr_dept_code,
                     :l_ar_ihdr_product_group_code,
                     :l_ar_ihdr_product_line_code,
                     :l_ar_ihdr_post_month,
                     :l_ar_ihdr_post_year,
                     :l_ar_hdr_misc_clong_name,
                     :l_ar_hdr_misc_cshort_name,
                     :l_ar_hdr_misc_cadd1_desc,
                     :l_ar_hdr_misc_cadd2_desc,
                     :l_ar_hdr_misc_cadd3_desc,
                     :l_ar_hdr_misc_czip_desc,
                     :l_ar_hdr_misc_long_chinese,
                     :l_ar_hdr_misc_short_chinese,
                     :l_ar_hdr_misc_add1_chinese,
                     :l_ar_hdr_misc_add2_chinese,
                     :l_ar_hdr_misc_add3_chinese,
                     :l_ar_hdr_misc_zip_chinese,
                     :l_ar_hdr_tel_num,
                     :l_ar_hdr_contact_name,
                     :l_ar_hdr_contact_name_title,
                     :l_ar_ihdr_rowid,
                     :l_ar_ihdr_adj_type,
                     :l_ar_ihdr_bill_type_code,
					 :l_consolidated_yn; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1678;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_ihdr_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_ar_ihdr_org_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_ar_ihdr_org_doc_num;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_ar_ihdr_last_line_num;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_ar_ihdr_cust_code;
      sqlstm.sqhstl[6] = (unsigned int  )10;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_ar_ihdr_narration;
      sqlstm.sqhstl[7] = (unsigned int  )53;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&l_ar_ihdr_base_date;
      sqlstm.sqhstl[8] = (unsigned int  )14;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&l_ar_ihdr_due_date;
      sqlstm.sqhstl[9] = (unsigned int  )14;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&l_ar_ihdr_gross_amt;
      sqlstm.sqhstl[10] = (unsigned int  )21;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_ar_ihdr_payable_amt;
      sqlstm.sqhstl[11] = (unsigned int  )21;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_ar_ihdr_discount_amt;
      sqlstm.sqhstl[12] = (unsigned int  )21;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_ar_ihdr_doc_amt;
      sqlstm.sqhstl[13] = (unsigned int  )21;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&l_ar_ihdr_currency_code;
      sqlstm.sqhstl[14] = (unsigned int  )21;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&l_ar_ihdr_exchg_rate;
      sqlstm.sqhstl[15] = (unsigned int  )22;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&l_ar_ihdr_pmnt_terms_code;
      sqlstm.sqhstl[16] = (unsigned int  )5;
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&l_ar_ihdr_settlement_date;
      sqlstm.sqhstl[17] = (unsigned int  )14;
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&l_ar_ihdr_settlement_perc;
      sqlstm.sqhstl[18] = (unsigned int  )9;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&l_ar_ihdr_cust_ref;
      sqlstm.sqhstl[19] = (unsigned int  )18;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqhstv[20] = (         void  *)&l_ar_ihdr_patient_id;
      sqlstm.sqhstl[20] = (unsigned int  )23;
      sqlstm.sqhsts[20] = (         int  )0;
      sqlstm.sqindv[20] = (         void  *)0;
      sqlstm.sqinds[20] = (         int  )0;
      sqlstm.sqharm[20] = (unsigned int  )0;
      sqlstm.sqadto[20] = (unsigned short )0;
      sqlstm.sqtdso[20] = (unsigned short )0;
      sqlstm.sqhstv[21] = (         void  *)&l_ar_ihdr_billing_group;
      sqlstm.sqhstl[21] = (unsigned int  )5;
      sqlstm.sqhsts[21] = (         int  )0;
      sqlstm.sqindv[21] = (         void  *)0;
      sqlstm.sqinds[21] = (         int  )0;
      sqlstm.sqharm[21] = (unsigned int  )0;
      sqlstm.sqadto[21] = (unsigned short )0;
      sqlstm.sqtdso[21] = (unsigned short )0;
      sqlstm.sqhstv[22] = (         void  *)&l_ar_ihdr_bill_doc_type_code;
      sqlstm.sqhstl[22] = (unsigned int  )9;
      sqlstm.sqhsts[22] = (         int  )0;
      sqlstm.sqindv[22] = (         void  *)0;
      sqlstm.sqinds[22] = (         int  )0;
      sqlstm.sqharm[22] = (unsigned int  )0;
      sqlstm.sqadto[22] = (unsigned short )0;
      sqlstm.sqtdso[22] = (unsigned short )0;
      sqlstm.sqhstv[23] = (         void  *)&l_ar_ihdr_bill_num;
      sqlstm.sqhstl[23] = (unsigned int  )11;
      sqlstm.sqhsts[23] = (         int  )0;
      sqlstm.sqindv[23] = (         void  *)0;
      sqlstm.sqinds[23] = (         int  )0;
      sqlstm.sqharm[23] = (unsigned int  )0;
      sqlstm.sqadto[23] = (unsigned short )0;
      sqlstm.sqtdso[23] = (unsigned short )0;
      sqlstm.sqhstv[24] = (         void  *)&l_ar_ihdr_bill_date;
      sqlstm.sqhstl[24] = (unsigned int  )14;
      sqlstm.sqhsts[24] = (         int  )0;
      sqlstm.sqindv[24] = (         void  *)0;
      sqlstm.sqinds[24] = (         int  )0;
      sqlstm.sqharm[24] = (unsigned int  )0;
      sqlstm.sqadto[24] = (unsigned short )0;
      sqlstm.sqtdso[24] = (unsigned short )0;
      sqlstm.sqhstv[25] = (         void  *)&l_ar_ihdr_doctor_fee_amt;
      sqlstm.sqhstl[25] = (unsigned int  )21;
      sqlstm.sqhsts[25] = (         int  )0;
      sqlstm.sqindv[25] = (         void  *)0;
      sqlstm.sqinds[25] = (         int  )0;
      sqlstm.sqharm[25] = (unsigned int  )0;
      sqlstm.sqadto[25] = (unsigned short )0;
      sqlstm.sqtdso[25] = (unsigned short )0;
      sqlstm.sqhstv[26] = (         void  *)&l_ar_ihdr_main_acc1_code;
      sqlstm.sqhstl[26] = (unsigned int  )9;
      sqlstm.sqhsts[26] = (         int  )0;
      sqlstm.sqindv[26] = (         void  *)0;
      sqlstm.sqinds[26] = (         int  )0;
      sqlstm.sqharm[26] = (unsigned int  )0;
      sqlstm.sqadto[26] = (unsigned short )0;
      sqlstm.sqtdso[26] = (unsigned short )0;
      sqlstm.sqhstv[27] = (         void  *)&l_ar_ihdr_main_acc2_code;
      sqlstm.sqhstl[27] = (unsigned int  )7;
      sqlstm.sqhsts[27] = (         int  )0;
      sqlstm.sqindv[27] = (         void  *)0;
      sqlstm.sqinds[27] = (         int  )0;
      sqlstm.sqharm[27] = (unsigned int  )0;
      sqlstm.sqadto[27] = (unsigned short )0;
      sqlstm.sqtdso[27] = (unsigned short )0;
      sqlstm.sqhstv[28] = (         void  *)&l_ar_ihdr_sub_group_code;
      sqlstm.sqhstl[28] = (unsigned int  )6;
      sqlstm.sqhsts[28] = (         int  )0;
      sqlstm.sqindv[28] = (         void  *)0;
      sqlstm.sqinds[28] = (         int  )0;
      sqlstm.sqharm[28] = (unsigned int  )0;
      sqlstm.sqadto[28] = (unsigned short )0;
      sqlstm.sqtdso[28] = (unsigned short )0;
      sqlstm.sqhstv[29] = (         void  *)&l_ar_ihdr_sub_line_code;
      sqlstm.sqhstl[29] = (unsigned int  )11;
      sqlstm.sqhsts[29] = (         int  )0;
      sqlstm.sqindv[29] = (         void  *)0;
      sqlstm.sqinds[29] = (         int  )0;
      sqlstm.sqharm[29] = (unsigned int  )0;
      sqlstm.sqadto[29] = (unsigned short )0;
      sqlstm.sqtdso[29] = (unsigned short )0;
      sqlstm.sqhstv[30] = (         void  *)&l_ar_ihdr_dept_code;
      sqlstm.sqhstl[30] = (unsigned int  )9;
      sqlstm.sqhsts[30] = (         int  )0;
      sqlstm.sqindv[30] = (         void  *)0;
      sqlstm.sqinds[30] = (         int  )0;
      sqlstm.sqharm[30] = (unsigned int  )0;
      sqlstm.sqadto[30] = (unsigned short )0;
      sqlstm.sqtdso[30] = (unsigned short )0;
      sqlstm.sqhstv[31] = (         void  *)&l_ar_ihdr_product_group_code;
      sqlstm.sqhstl[31] = (unsigned int  )6;
      sqlstm.sqhsts[31] = (         int  )0;
      sqlstm.sqindv[31] = (         void  *)0;
      sqlstm.sqinds[31] = (         int  )0;
      sqlstm.sqharm[31] = (unsigned int  )0;
      sqlstm.sqadto[31] = (unsigned short )0;
      sqlstm.sqtdso[31] = (unsigned short )0;
      sqlstm.sqhstv[32] = (         void  *)&l_ar_ihdr_product_line_code;
      sqlstm.sqhstl[32] = (unsigned int  )7;
      sqlstm.sqhsts[32] = (         int  )0;
      sqlstm.sqindv[32] = (         void  *)0;
      sqlstm.sqinds[32] = (         int  )0;
      sqlstm.sqharm[32] = (unsigned int  )0;
      sqlstm.sqadto[32] = (unsigned short )0;
      sqlstm.sqtdso[32] = (unsigned short )0;
      sqlstm.sqhstv[33] = (         void  *)&l_ar_ihdr_post_month;
      sqlstm.sqhstl[33] = (unsigned int  )5;
      sqlstm.sqhsts[33] = (         int  )0;
      sqlstm.sqindv[33] = (         void  *)0;
      sqlstm.sqinds[33] = (         int  )0;
      sqlstm.sqharm[33] = (unsigned int  )0;
      sqlstm.sqadto[33] = (unsigned short )0;
      sqlstm.sqtdso[33] = (unsigned short )0;
      sqlstm.sqhstv[34] = (         void  *)&l_ar_ihdr_post_year;
      sqlstm.sqhstl[34] = (unsigned int  )7;
      sqlstm.sqhsts[34] = (         int  )0;
      sqlstm.sqindv[34] = (         void  *)0;
      sqlstm.sqinds[34] = (         int  )0;
      sqlstm.sqharm[34] = (unsigned int  )0;
      sqlstm.sqadto[34] = (unsigned short )0;
      sqlstm.sqtdso[34] = (unsigned short )0;
      sqlstm.sqhstv[35] = (         void  *)&l_ar_hdr_misc_clong_name;
      sqlstm.sqhstl[35] = (unsigned int  )43;
      sqlstm.sqhsts[35] = (         int  )0;
      sqlstm.sqindv[35] = (         void  *)0;
      sqlstm.sqinds[35] = (         int  )0;
      sqlstm.sqharm[35] = (unsigned int  )0;
      sqlstm.sqadto[35] = (unsigned short )0;
      sqlstm.sqtdso[35] = (unsigned short )0;
      sqlstm.sqhstv[36] = (         void  *)&l_ar_hdr_misc_cshort_name;
      sqlstm.sqhstl[36] = (unsigned int  )18;
      sqlstm.sqhsts[36] = (         int  )0;
      sqlstm.sqindv[36] = (         void  *)0;
      sqlstm.sqinds[36] = (         int  )0;
      sqlstm.sqharm[36] = (unsigned int  )0;
      sqlstm.sqadto[36] = (unsigned short )0;
      sqlstm.sqtdso[36] = (unsigned short )0;
      sqlstm.sqhstv[37] = (         void  *)&l_ar_hdr_misc_cadd1_desc;
      sqlstm.sqhstl[37] = (unsigned int  )33;
      sqlstm.sqhsts[37] = (         int  )0;
      sqlstm.sqindv[37] = (         void  *)0;
      sqlstm.sqinds[37] = (         int  )0;
      sqlstm.sqharm[37] = (unsigned int  )0;
      sqlstm.sqadto[37] = (unsigned short )0;
      sqlstm.sqtdso[37] = (unsigned short )0;
      sqlstm.sqhstv[38] = (         void  *)&l_ar_hdr_misc_cadd2_desc;
      sqlstm.sqhstl[38] = (unsigned int  )33;
      sqlstm.sqhsts[38] = (         int  )0;
      sqlstm.sqindv[38] = (         void  *)0;
      sqlstm.sqinds[38] = (         int  )0;
      sqlstm.sqharm[38] = (unsigned int  )0;
      sqlstm.sqadto[38] = (unsigned short )0;
      sqlstm.sqtdso[38] = (unsigned short )0;
      sqlstm.sqhstv[39] = (         void  *)&l_ar_hdr_misc_cadd3_desc;
      sqlstm.sqhstl[39] = (unsigned int  )33;
      sqlstm.sqhsts[39] = (         int  )0;
      sqlstm.sqindv[39] = (         void  *)0;
      sqlstm.sqinds[39] = (         int  )0;
      sqlstm.sqharm[39] = (unsigned int  )0;
      sqlstm.sqadto[39] = (unsigned short )0;
      sqlstm.sqtdso[39] = (unsigned short )0;
      sqlstm.sqhstv[40] = (         void  *)&l_ar_hdr_misc_czip_desc;
      sqlstm.sqhstl[40] = (unsigned int  )33;
      sqlstm.sqhsts[40] = (         int  )0;
      sqlstm.sqindv[40] = (         void  *)0;
      sqlstm.sqinds[40] = (         int  )0;
      sqlstm.sqharm[40] = (unsigned int  )0;
      sqlstm.sqadto[40] = (unsigned short )0;
      sqlstm.sqtdso[40] = (unsigned short )0;
      sqlstm.sqhstv[41] = (         void  *)&l_ar_hdr_misc_long_chinese;
      sqlstm.sqhstl[41] = (unsigned int  )43;
      sqlstm.sqhsts[41] = (         int  )0;
      sqlstm.sqindv[41] = (         void  *)0;
      sqlstm.sqinds[41] = (         int  )0;
      sqlstm.sqharm[41] = (unsigned int  )0;
      sqlstm.sqadto[41] = (unsigned short )0;
      sqlstm.sqtdso[41] = (unsigned short )0;
      sqlstm.sqhstv[42] = (         void  *)&l_ar_hdr_misc_short_chinese;
      sqlstm.sqhstl[42] = (unsigned int  )18;
      sqlstm.sqhsts[42] = (         int  )0;
      sqlstm.sqindv[42] = (         void  *)0;
      sqlstm.sqinds[42] = (         int  )0;
      sqlstm.sqharm[42] = (unsigned int  )0;
      sqlstm.sqadto[42] = (unsigned short )0;
      sqlstm.sqtdso[42] = (unsigned short )0;
      sqlstm.sqhstv[43] = (         void  *)&l_ar_hdr_misc_add1_chinese;
      sqlstm.sqhstl[43] = (unsigned int  )33;
      sqlstm.sqhsts[43] = (         int  )0;
      sqlstm.sqindv[43] = (         void  *)0;
      sqlstm.sqinds[43] = (         int  )0;
      sqlstm.sqharm[43] = (unsigned int  )0;
      sqlstm.sqadto[43] = (unsigned short )0;
      sqlstm.sqtdso[43] = (unsigned short )0;
      sqlstm.sqhstv[44] = (         void  *)&l_ar_hdr_misc_add2_chinese;
      sqlstm.sqhstl[44] = (unsigned int  )33;
      sqlstm.sqhsts[44] = (         int  )0;
      sqlstm.sqindv[44] = (         void  *)0;
      sqlstm.sqinds[44] = (         int  )0;
      sqlstm.sqharm[44] = (unsigned int  )0;
      sqlstm.sqadto[44] = (unsigned short )0;
      sqlstm.sqtdso[44] = (unsigned short )0;
      sqlstm.sqhstv[45] = (         void  *)&l_ar_hdr_misc_add3_chinese;
      sqlstm.sqhstl[45] = (unsigned int  )33;
      sqlstm.sqhsts[45] = (         int  )0;
      sqlstm.sqindv[45] = (         void  *)0;
      sqlstm.sqinds[45] = (         int  )0;
      sqlstm.sqharm[45] = (unsigned int  )0;
      sqlstm.sqadto[45] = (unsigned short )0;
      sqlstm.sqtdso[45] = (unsigned short )0;
      sqlstm.sqhstv[46] = (         void  *)&l_ar_hdr_misc_zip_chinese;
      sqlstm.sqhstl[46] = (unsigned int  )33;
      sqlstm.sqhsts[46] = (         int  )0;
      sqlstm.sqindv[46] = (         void  *)0;
      sqlstm.sqinds[46] = (         int  )0;
      sqlstm.sqharm[46] = (unsigned int  )0;
      sqlstm.sqadto[46] = (unsigned short )0;
      sqlstm.sqtdso[46] = (unsigned short )0;
      sqlstm.sqhstv[47] = (         void  *)&l_ar_hdr_tel_num;
      sqlstm.sqhstl[47] = (unsigned int  )33;
      sqlstm.sqhsts[47] = (         int  )0;
      sqlstm.sqindv[47] = (         void  *)0;
      sqlstm.sqinds[47] = (         int  )0;
      sqlstm.sqharm[47] = (unsigned int  )0;
      sqlstm.sqadto[47] = (unsigned short )0;
      sqlstm.sqtdso[47] = (unsigned short )0;
      sqlstm.sqhstv[48] = (         void  *)&l_ar_hdr_contact_name;
      sqlstm.sqhstl[48] = (unsigned int  )43;
      sqlstm.sqhsts[48] = (         int  )0;
      sqlstm.sqindv[48] = (         void  *)0;
      sqlstm.sqinds[48] = (         int  )0;
      sqlstm.sqharm[48] = (unsigned int  )0;
      sqlstm.sqadto[48] = (unsigned short )0;
      sqlstm.sqtdso[48] = (unsigned short )0;
      sqlstm.sqhstv[49] = (         void  *)&l_ar_hdr_contact_name_title;
      sqlstm.sqhstl[49] = (unsigned int  )43;
      sqlstm.sqhsts[49] = (         int  )0;
      sqlstm.sqindv[49] = (         void  *)0;
      sqlstm.sqinds[49] = (         int  )0;
      sqlstm.sqharm[49] = (unsigned int  )0;
      sqlstm.sqadto[49] = (unsigned short )0;
      sqlstm.sqtdso[49] = (unsigned short )0;
      sqlstm.sqhstv[50] = (         void  *)&l_ar_ihdr_rowid;
      sqlstm.sqhstl[50] = (unsigned int  )33;
      sqlstm.sqhsts[50] = (         int  )0;
      sqlstm.sqindv[50] = (         void  *)0;
      sqlstm.sqinds[50] = (         int  )0;
      sqlstm.sqharm[50] = (unsigned int  )0;
      sqlstm.sqadto[50] = (unsigned short )0;
      sqlstm.sqtdso[50] = (unsigned short )0;
      sqlstm.sqhstv[51] = (         void  *)&l_ar_ihdr_adj_type;
      sqlstm.sqhstl[51] = (unsigned int  )5;
      sqlstm.sqhsts[51] = (         int  )0;
      sqlstm.sqindv[51] = (         void  *)0;
      sqlstm.sqinds[51] = (         int  )0;
      sqlstm.sqharm[51] = (unsigned int  )0;
      sqlstm.sqadto[51] = (unsigned short )0;
      sqlstm.sqtdso[51] = (unsigned short )0;
      sqlstm.sqhstv[52] = (         void  *)&l_ar_ihdr_bill_type_code;
      sqlstm.sqhstl[52] = (unsigned int  )4;
      sqlstm.sqhsts[52] = (         int  )0;
      sqlstm.sqindv[52] = (         void  *)0;
      sqlstm.sqinds[52] = (         int  )0;
      sqlstm.sqharm[52] = (unsigned int  )0;
      sqlstm.sqadto[52] = (unsigned short )0;
      sqlstm.sqtdso[52] = (unsigned short )0;
      sqlstm.sqhstv[53] = (         void  *)&l_consolidated_yn;
      sqlstm.sqhstl[53] = (unsigned int  )4;
      sqlstm.sqhsts[53] = (         int  )0;
      sqlstm.sqindv[53] = (         void  *)0;
      sqlstm.sqinds[53] = (         int  )0;
      sqlstm.sqharm[53] = (unsigned int  )0;
      sqlstm.sqadto[53] = (unsigned short )0;
      sqlstm.sqtdso[53] = (unsigned short )0;
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

l_ar_hdr_misc_clong_name.arr[l_ar_hdr_misc_clong_name.len]     = '\0';
l_ar_hdr_misc_cshort_name.arr[l_ar_hdr_misc_cshort_name.len]   = '\0';
l_ar_hdr_misc_cadd1_desc.arr[l_ar_hdr_misc_cadd1_desc.len]     = '\0';
l_ar_hdr_misc_cadd2_desc.arr[l_ar_hdr_misc_cadd2_desc.len]     = '\0';
l_ar_hdr_misc_cadd3_desc.arr[l_ar_hdr_misc_cadd3_desc.len]     = '\0';
l_ar_hdr_misc_czip_desc.arr[l_ar_hdr_misc_czip_desc.len]       = '\0';
l_ar_hdr_misc_long_chinese.arr[l_ar_hdr_misc_long_chinese.len]         = '\0';
l_ar_hdr_misc_short_chinese.arr[l_ar_hdr_misc_short_chinese.len]       = '\0';
l_ar_hdr_misc_add1_chinese.arr[l_ar_hdr_misc_add1_chinese.len]         = '\0';
l_ar_hdr_misc_add2_chinese.arr[l_ar_hdr_misc_add2_chinese.len]         = '\0';
l_ar_hdr_misc_add3_chinese.arr[l_ar_hdr_misc_add3_chinese.len]         = '\0';
l_ar_hdr_misc_zip_chinese.arr[l_ar_hdr_misc_zip_chinese.len]           = '\0';
l_ar_hdr_tel_num.arr[l_ar_hdr_tel_num.len]                             = '\0';
l_ar_hdr_contact_name.arr[l_ar_hdr_contact_name.len]                   = '\0';
l_ar_hdr_contact_name_title.arr[l_ar_hdr_contact_name_title.len]       = '\0';

   }

l_ar_ihdr_acc_entity_code.arr[l_ar_ihdr_acc_entity_code.len]           = '\0';
l_ar_ihdr_doc_type_code.arr[l_ar_ihdr_doc_type_code.len]               = '\0';
l_ar_ihdr_bill_type_code.arr[l_ar_ihdr_bill_type_code.len]             = '\0';
l_ar_ihdr_doc_num.arr[l_ar_ihdr_doc_num.len]                           = '\0';
l_ar_ihdr_org_doc_type_code.arr[l_ar_ihdr_org_doc_type_code.len]       = '\0';
l_ar_ihdr_org_doc_num.arr[l_ar_ihdr_org_doc_num.len]                   = '\0';
l_ar_ihdr_last_line_num.arr[l_ar_ihdr_last_line_num.len]               = '\0';
l_ar_ihdr_cust_code.arr[l_ar_ihdr_cust_code.len]                       = '\0';
l_ar_ihdr_narration.arr[l_ar_ihdr_narration.len]                       = '\0';
l_ar_ihdr_base_date.arr[l_ar_ihdr_base_date.len]                       = '\0';
l_ar_ihdr_due_date.arr[l_ar_ihdr_due_date.len]                         = '\0';
l_ar_ihdr_gross_amt.arr[l_ar_ihdr_gross_amt.len]                       = '\0';
l_ar_ihdr_payable_amt.arr[l_ar_ihdr_payable_amt.len]                   = '\0';
l_ar_ihdr_discount_amt.arr[l_ar_ihdr_discount_amt.len]                 = '\0';
l_ar_ihdr_doc_amt.arr[l_ar_ihdr_doc_amt.len]                           = '\0';
l_ar_ihdr_currency_code.arr[l_ar_ihdr_currency_code.len]               = '\0';
l_ar_ihdr_exchg_rate.arr[l_ar_ihdr_exchg_rate.len]                     = '\0';
l_ar_ihdr_pmnt_terms_code.arr[l_ar_ihdr_pmnt_terms_code.len]           = '\0';
l_ar_ihdr_settlement_date.arr[l_ar_ihdr_settlement_date.len]           = '\0';
l_ar_ihdr_settlement_perc.arr[l_ar_ihdr_settlement_perc.len]           = '\0';
l_ar_ihdr_cust_ref.arr[l_ar_ihdr_cust_ref.len]                         = '\0';
l_ar_ihdr_patient_id.arr[l_ar_ihdr_patient_id.len]                     = '\0';
l_ar_ihdr_billing_group.arr[l_ar_ihdr_billing_group.len]               = '\0';
l_ar_ihdr_bill_doc_type_code.arr[l_ar_ihdr_bill_doc_type_code.len]     = '\0';
l_ar_ihdr_bill_num.arr[l_ar_ihdr_bill_num.len]                         = '\0';
l_ar_ihdr_bill_date.arr[l_ar_ihdr_bill_date.len]                       = '\0';
l_ar_ihdr_doctor_fee_amt.arr[l_ar_ihdr_doctor_fee_amt.len]             = '\0';
l_ar_ihdr_main_acc1_code.arr[l_ar_ihdr_main_acc1_code.len]             = '\0';
l_ar_ihdr_main_acc2_code.arr[l_ar_ihdr_main_acc2_code.len]             = '\0';
l_ar_ihdr_sub_group_code.arr[l_ar_ihdr_sub_group_code.len] = '\0';
l_ar_ihdr_sub_line_code.arr[l_ar_ihdr_sub_line_code.len]   = '\0';
l_ar_ihdr_dept_code.arr[l_ar_ihdr_dept_code.len]                       = '\0';
l_ar_ihdr_product_group_code.arr[l_ar_ihdr_product_group_code.len]     = '\0';
l_ar_ihdr_product_line_code.arr[l_ar_ihdr_product_line_code.len]       = '\0';
l_ar_ihdr_post_month.arr[l_ar_ihdr_post_month.len]                     = '\0';
l_ar_ihdr_post_year.arr[l_ar_ihdr_post_year.len]                       = '\0';
l_ar_ihdr_rowid.arr[l_ar_ihdr_rowid.len]                               = '\0';
l_ar_ihdr_adj_type.arr[l_ar_ihdr_adj_type.len]                         = '\0';
l_consolidated_yn.arr[l_consolidated_yn.len]						   = '\0';

      if (LAST_ROW)
            return (0);
      else
            return (1);
}

dn_post_fetch_dn_line(l_trn_type)
char l_trn_type;
{
l_ar_line_acc_entity_code.arr[0]      = '\0';
l_ar_line_doc_type_code.arr[0]        = '\0';
l_ar_line_doc_num.arr[0]              = '\0';
l_ar_line_org_doc_type_code.arr[0]    = '\0';
l_ar_line_org_doc_num.arr[0]          = '\0';
l_ar_line_line_num.arr[0]             = '\0';
l_ar_line_main_acc1_code.arr[0]       = '\0';
l_ar_line_main_acc2_code.arr[0]       = '\0';
l_ar_line_sub_group_code.arr[0] = '\0';
l_ar_line_sub_line_code.arr[0]  = '\0';
l_ar_line_dept_code.arr[0]            = '\0';
l_ar_line_product_group_code.arr[0]   = '\0';
l_ar_line_product_line_code.arr[0]    = '\0';
l_ar_line_amount.arr[0]               = '\0';
l_ar_line_narration.arr[0]            = '\0';
l_ar_line_rowid.arr[0]                = '\0';


l_ar_line_acc_entity_code.len         = 0;
l_ar_line_doc_type_code.len           = 0;
l_ar_line_doc_num.len                 = 0;
l_ar_line_org_doc_type_code.len       = 0;
l_ar_line_org_doc_num.len             = 0;
l_ar_line_line_num.len                = 0;
l_ar_line_main_acc1_code.len          = 0;
l_ar_line_main_acc2_code.len          = 0;
l_ar_line_sub_group_code.len    = 0;
l_ar_line_sub_line_code.len     = 0;
l_ar_line_dept_code.len               = 0;
l_ar_line_product_group_code.len      = 0;
l_ar_line_product_line_code.len       = 0;
l_ar_line_amount.len                  = 0;
l_ar_line_narration.len               = 0;
l_ar_line_rowid.len                   = 0;

if (l_trn_type == 'D')
{
      /* EXEC SQL FETCH DN_POST_LINE
                INTO :l_ar_line_acc_entity_code,
                     :l_ar_line_doc_type_code,
                     :l_ar_line_doc_num,
                     :l_ar_line_org_doc_type_code,
                     :l_ar_line_org_doc_num,
                     :l_ar_line_line_num,
                     :l_ar_line_main_acc1_code,
                     :l_ar_line_main_acc2_code,
                     :l_ar_line_sub_group_code,
                     :l_ar_line_sub_line_code,
                     :l_ar_line_dept_code,
                     :l_ar_line_product_group_code,
                     :l_ar_line_product_line_code,
                     :l_ar_line_amount,
                     :l_ar_line_narration,
                     :l_ar_line_rowid; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1909;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_line_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_line_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_ar_line_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_ar_line_org_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_ar_line_org_doc_num;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_ar_line_line_num;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_ar_line_main_acc1_code;
      sqlstm.sqhstl[6] = (unsigned int  )9;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_ar_line_main_acc2_code;
      sqlstm.sqhstl[7] = (unsigned int  )7;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&l_ar_line_sub_group_code;
      sqlstm.sqhstl[8] = (unsigned int  )6;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&l_ar_line_sub_line_code;
      sqlstm.sqhstl[9] = (unsigned int  )11;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&l_ar_line_dept_code;
      sqlstm.sqhstl[10] = (unsigned int  )9;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_ar_line_product_group_code;
      sqlstm.sqhstl[11] = (unsigned int  )6;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_ar_line_product_line_code;
      sqlstm.sqhstl[12] = (unsigned int  )7;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_ar_line_amount;
      sqlstm.sqhstl[13] = (unsigned int  )21;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&l_ar_line_narration;
      sqlstm.sqhstl[14] = (unsigned int  )53;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&l_ar_line_rowid;
      sqlstm.sqhstl[15] = (unsigned int  )33;
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
         err_mesg("FETCH failed on cursor CUR_AR_DN_LINE",0,"");
}
else if (l_trn_type == 'C')
{
      /* EXEC SQL FETCH CN_POST_LINE
                INTO :l_ar_line_acc_entity_code,
                     :l_ar_line_doc_type_code,
                     :l_ar_line_doc_num,
                     :l_ar_line_org_doc_type_code,
                     :l_ar_line_org_doc_num,
                     :l_ar_line_line_num,
                     :l_ar_line_main_acc1_code,
                     :l_ar_line_main_acc2_code,
                     :l_ar_line_sub_group_code,
                     :l_ar_line_sub_line_code,
                     :l_ar_line_dept_code,
                     :l_ar_line_product_group_code,
                     :l_ar_line_product_line_code,
                     :l_ar_line_amount,
                     :l_ar_line_narration,
                     :l_ar_line_rowid; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1988;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_line_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_line_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_ar_line_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_ar_line_org_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_ar_line_org_doc_num;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_ar_line_line_num;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_ar_line_main_acc1_code;
      sqlstm.sqhstl[6] = (unsigned int  )9;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_ar_line_main_acc2_code;
      sqlstm.sqhstl[7] = (unsigned int  )7;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&l_ar_line_sub_group_code;
      sqlstm.sqhstl[8] = (unsigned int  )6;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&l_ar_line_sub_line_code;
      sqlstm.sqhstl[9] = (unsigned int  )11;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&l_ar_line_dept_code;
      sqlstm.sqhstl[10] = (unsigned int  )9;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_ar_line_product_group_code;
      sqlstm.sqhstl[11] = (unsigned int  )6;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_ar_line_product_line_code;
      sqlstm.sqhstl[12] = (unsigned int  )7;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_ar_line_amount;
      sqlstm.sqhstl[13] = (unsigned int  )21;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&l_ar_line_narration;
      sqlstm.sqhstl[14] = (unsigned int  )53;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&l_ar_line_rowid;
      sqlstm.sqhstl[15] = (unsigned int  )33;
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
         err_mesg("FETCH failed on cursor CUR_AR_CN_LINE",0,"");
 }
 else
 {
      /* EXEC SQL FETCH ADJ_POST_LINE
                INTO :l_ar_line_acc_entity_code,
                     :l_ar_line_doc_type_code,
                     :l_ar_line_doc_num,
                     :l_ar_line_org_doc_type_code,
                     :l_ar_line_org_doc_num,
                     :l_ar_line_line_num,
                     :l_ar_line_main_acc1_code,
                     :l_ar_line_main_acc2_code,
                     :l_ar_line_sub_group_code,
                     :l_ar_line_sub_line_code,
                     :l_ar_line_dept_code,
                     :l_ar_line_product_group_code,
                     :l_ar_line_product_line_code,
                     :l_ar_line_amount,
                     :l_ar_line_narration,
                     :l_ar_line_rowid; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 58;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2067;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_line_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_line_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_ar_line_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_ar_line_org_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_ar_line_org_doc_num;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_ar_line_line_num;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_ar_line_main_acc1_code;
      sqlstm.sqhstl[6] = (unsigned int  )9;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_ar_line_main_acc2_code;
      sqlstm.sqhstl[7] = (unsigned int  )7;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&l_ar_line_sub_group_code;
      sqlstm.sqhstl[8] = (unsigned int  )6;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&l_ar_line_sub_line_code;
      sqlstm.sqhstl[9] = (unsigned int  )11;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&l_ar_line_dept_code;
      sqlstm.sqhstl[10] = (unsigned int  )9;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_ar_line_product_group_code;
      sqlstm.sqhstl[11] = (unsigned int  )6;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_ar_line_product_line_code;
      sqlstm.sqhstl[12] = (unsigned int  )7;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_ar_line_amount;
      sqlstm.sqhstl[13] = (unsigned int  )21;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&l_ar_line_narration;
      sqlstm.sqhstl[14] = (unsigned int  )53;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&l_ar_line_rowid;
      sqlstm.sqhstl[15] = (unsigned int  )33;
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
         err_mesg("FETCH failed on cursor CUR_ADJ_CN_LINE",0,"");
 }

l_ar_line_acc_entity_code.arr[l_ar_line_acc_entity_code.len]           = '\0';
l_ar_line_doc_type_code.arr[l_ar_line_doc_type_code.len]               = '\0';
l_ar_line_doc_num.arr[l_ar_line_doc_num.len]                           = '\0';
l_ar_line_org_doc_type_code.arr[l_ar_line_org_doc_type_code.len]       = '\0';
l_ar_line_org_doc_num.arr[l_ar_line_org_doc_num.len]                   = '\0';
l_ar_line_line_num.arr[l_ar_line_line_num.len]                         = '\0';
l_ar_line_main_acc1_code.arr[l_ar_line_main_acc1_code.len]             = '\0';
l_ar_line_main_acc2_code.arr[l_ar_line_main_acc2_code.len]             = '\0';
l_ar_line_sub_group_code.arr[l_ar_line_sub_group_code.len] = '\0';
l_ar_line_sub_line_code.arr[l_ar_line_sub_line_code.len]   = '\0';
l_ar_line_dept_code.arr[l_ar_line_dept_code.len]                       = '\0';
l_ar_line_product_group_code.arr[l_ar_line_product_group_code.len]     = '\0';
l_ar_line_product_line_code.arr[l_ar_line_product_line_code.len]       = '\0';
l_ar_line_amount.arr[l_ar_line_amount.len]                             = '\0';
l_ar_line_narration.arr[l_ar_line_narration.len]                       = '\0';
l_ar_line_rowid.arr[l_ar_line_rowid.len]                               = '\0';

      if (LAST_ROW)
            return (0);
      else
            return (1);

}
