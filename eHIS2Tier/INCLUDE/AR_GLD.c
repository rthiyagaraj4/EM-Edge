
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
           char  filnam[26];
};
static const struct sqlcxp sqlfpn =
{
    25,
    "t:\\temp\\Finance\\AR_GLD.PC"
};


static unsigned long sqlctx = 1681950949;


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
            void  *sqhstv[27];
   unsigned int   sqhstl[27];
            int   sqhsts[27];
            void  *sqindv[27];
            int   sqinds[27];
   unsigned int   sqharm[27];
   unsigned int   *sqharc[27];
   unsigned short  sqadto[27];
   unsigned short  sqtdso[27];
} sqlstm = {10,27};

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

 static const char *sq0001 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,CUST_REF ,CUS\
T_CODE ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_C\
ODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,PAYABLE_AMT ,NARRATION \
,POST_MONTH ,POST_YEAR ,SIGN(PAYABLE_AMT) ,DECODE(SIGN(PAYABLE_AMT),(-1),(-PAY\
ABLE_AMT),PAYABLE_AMT)  from AR_INV_HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:\
b1)           ";

 static const char *sq0002 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_\
CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,NARRATION ,AMT_LOCAL ,\
SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL)  from AR_\
INV_LINE where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0003 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY')  from AR_DN_HD\
R where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0004 = 
"select CUST_REF ,CUST_CODE ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_\
CODE ,SUBLEDGER_LINE_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,D\
OC_AMT ,NARRATION ,POST_MONTH ,POST_YEAR ,SIGN(DOC_AMT) ,DECODE(SIGN(DOC_AMT),\
(-1),(-DOC_AMT),DOC_AMT) ,ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from AR_DN_INV_HDR w\
here (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0005 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_\
CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,NARRATION ,AMOUNT ,SIG\
N(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(-AMOUNT),AMOUNT)  from AR_DN_LINE where (\
((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NU\
M=:b3)           ";

 static const char *sq0006 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY')  from AR_CN_HD\
R where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0007 = 
"select CUST_REF ,CUST_CODE ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_\
CODE ,SUBLEDGER_LINE_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,D\
OC_AMT ,NARRATION ,POST_MONTH ,POST_YEAR ,SIGN(DOC_AMT) ,DECODE(SIGN(DOC_AMT),\
(-1),(-DOC_AMT),DOC_AMT) ,ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from AR_CN_INV_HDR w\
here (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0008 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_\
CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,NARRATION ,AMOUNT ,SIG\
N(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(-AMOUNT),AMOUNT)  from AR_CN_LINE where (\
((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NU\
M=:b3)           ";

 static const char *sq0009 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY')  from AR_ADJ_H\
DR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0010 = 
"select CUST_REF ,CUST_CODE ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_\
CODE ,SUBLEDGER_LINE_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,D\
OC_AMT ,NARRATION ,POST_MONTH ,POST_YEAR ,ADJ_TYPE ,SIGN(DOC_AMT) ,DECODE(SIGN\
(DOC_AMT),(-1),(-DOC_AMT),DOC_AMT) ,ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from AR_AD\
J_INV_HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0011 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_\
CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,NARRATION ,AMOUNT ,SIG\
N(AMOUNT) ,DECODE(SIGN(AMOUNT),(-1),(-AMOUNT),AMOUNT)  from AR_ADJ_LINE where \
(((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_N\
UM=:b3)           ";

 static const char *sq0012 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,CUST\
_CODE ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CO\
DE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,AMT_LOCAL ,NARRATION ,PO\
ST_MONTH ,POST_YEAR ,CHEQUE_NUM ,TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY') ,SIGN(AMT_L\
OCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL)  from AR_REC_HDR wh\
ere (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0013 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_\
CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,NARRATION ,AMT_LOCAL ,\
SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL)  from AR_\
REC_LINE where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0014 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,CUST\
_CODE ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CO\
DE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,AMT_LOCAL ,NARRATION ,PO\
ST_MONTH ,POST_YEAR ,CHEQUE_NUM ,TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY') ,SIGN(AMT_L\
OCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL)  from AR_PAY_HDR wh\
ere (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0015 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_\
CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,NARRATION ,AMT_LOCAL ,\
SIGN(AMT_LOCAL) ,DECODE(SIGN(AMT_LOCAL),(-1),(-AMT_LOCAL),AMT_LOCAL)  from AR_\
PAY_LINE where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

 static const char *sq0016 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,CUST\
_CODE ,MAIN_ACC1_CODE_BANK ,MAIN_ACC2_CODE_BANK ,SUBLEDGER_GROUP_CODE_BANK ,SU\
BLEDGER_LINE_CODE_BANK ,DEPT_CODE_BANK ,PRODUCT_GROUP_CODE_BANK ,PRODUCT_LINE_\
CODE_BANK ,MAIN_ACC1_CODE_SUSP ,MAIN_ACC2_CODE_SUSP ,SUBLEDGER_GROUP_CODE_SUSP\
 ,SUBLEDGER_LINE_CODE_SUSP ,DEPT_CODE_SUSP ,PRODUCT_GROUP_CODE_SUSP ,PRODUCT_L\
INE_CODE_SUSP ,AMT_LOCAL ,NARRATION ,POST_MONTH ,POST_YEAR ,CHEQUE_NUM ,TO_CHA\
R(CHEQUE_DATE,'DD/MM/YYYY') ,SIGN(AMT_LOCAL) ,(-AMT_LOCAL)  from AR_CASHIER wh\
ere (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,402,0,9,199,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,1,0,0,13,212,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,2,9,0,0,
115,0,0,2,293,0,9,250,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
138,0,0,2,0,0,13,263,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
197,0,0,3,130,0,9,351,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
220,0,0,3,0,0,13,364,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
247,0,0,4,361,0,9,387,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
270,0,0,4,0,0,13,405,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
353,0,0,5,327,0,9,443,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
384,0,0,5,0,0,13,457,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
443,0,0,6,130,0,9,543,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
466,0,0,6,0,0,13,556,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
493,0,0,7,361,0,9,581,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
516,0,0,7,0,0,13,598,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
599,0,0,8,327,0,9,635,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
630,0,0,8,0,0,13,648,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
689,0,0,9,131,0,9,736,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
712,0,0,9,0,0,13,749,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
739,0,0,10,372,0,9,772,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
762,0,0,10,0,0,13,787,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
849,0,0,11,328,0,9,831,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
880,0,0,11,0,0,13,841,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
939,0,0,12,438,0,9,913,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
962,0,0,12,0,0,13,923,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1057,0,0,13,293,0,9,960,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1080,0,0,13,0,0,13,970,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1139,0,0,14,438,0,9,1042,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1162,0,0,14,0,0,13,1052,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1257,0,0,15,293,0,9,1096,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1280,0,0,15,0,0,13,1106,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
1339,0,0,16,594,0,9,1172,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1362,0,0,16,0,0,13,1182,0,0,27,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,3,0,0,2,9,0,0,
1485,0,0,17,424,0,3,1521,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1572,0,0,18,424,0,3,1573,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1659,0,0,19,426,0,3,1648,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


#include <stdio.h>
#include <string.h> 
    
/*---------------------------------*/  
#define PC_START		1
#define PC_END			2
#define	INFO_MESG		3
#define ERR_MESG		4
#define ORA_MESG		5  

void proc_main (int, char **);
void disp_message ( int, char *);
void open_log_file();
void proc_exit();
/*-----------------------------------*/ 
 
#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

#define RESOURCE_BUSY        (sqlca.sqlcode == -54)

extern double atof();

/*
#define DEBUG 0
*/
    

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    int audit_option_flag;

 /* VARCHAR    nd_gd_doc_type_code        [7],
            nd_gd_doc_num              [9]; */ 
struct { unsigned short len; unsigned char arr[7]; } nd_gd_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_gd_doc_num;


 /* VARCHAR    l_gd_doc_type_code         [7],
            l_gd_doc_num               [9],
            l_gd_org_doc_type_code     [7],
            l_gd_org_doc_num           [9],
            l_gd_doc_date              [11],
            l_gd_doc_ref               [16],
            l_gd_cust_code             [9],
            l_gd_main_acc1_code        [7],
            l_gd_main_acc2_code        [5],
            l_gd_subledger_group_code  [4],
            l_gd_subledger_line_code   [9],
            l_gd_dept_code             [7],
            l_gd_product_group_code    [4],
            l_gd_product_line_code     [4],

            l_gd_main_acc1_code_susp   [7],  
            l_gd_main_acc2_code_susp   [5],
            l_gd_subled_group_code_susp[4],
            l_gd_subled_line_code_susp [9],
            l_gd_dept_code_susp        [7],
            l_gd_prod_group_code_susp  [4],
            l_gd_prod_line_code_susp   [4],

            l_gd_amount                [19],
            l_gd_amount_negative       [19],
            l_gd_debit_amt             [19],
            l_gd_credit_amt            [19],
            l_gd_narration             [51],
            l_gd_post_month            [3],
            l_gd_post_year             [5],
            l_gd_cheque_num            [11],
            l_gd_cheque_date           [11],
            l_gd_trn_type_code         [5],
            l_gd_adj_type              [3]; */ 
struct { unsigned short len; unsigned char arr[7]; } l_gd_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_gd_doc_num;

struct { unsigned short len; unsigned char arr[7]; } l_gd_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_gd_org_doc_num;

struct { unsigned short len; unsigned char arr[11]; } l_gd_doc_date;

struct { unsigned short len; unsigned char arr[16]; } l_gd_doc_ref;

struct { unsigned short len; unsigned char arr[9]; } l_gd_cust_code;

struct { unsigned short len; unsigned char arr[7]; } l_gd_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } l_gd_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } l_gd_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } l_gd_subledger_line_code;

struct { unsigned short len; unsigned char arr[7]; } l_gd_dept_code;

struct { unsigned short len; unsigned char arr[4]; } l_gd_product_group_code;

struct { unsigned short len; unsigned char arr[4]; } l_gd_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } l_gd_main_acc1_code_susp;

struct { unsigned short len; unsigned char arr[5]; } l_gd_main_acc2_code_susp;

struct { unsigned short len; unsigned char arr[4]; } l_gd_subled_group_code_susp;

struct { unsigned short len; unsigned char arr[9]; } l_gd_subled_line_code_susp;

struct { unsigned short len; unsigned char arr[7]; } l_gd_dept_code_susp;

struct { unsigned short len; unsigned char arr[4]; } l_gd_prod_group_code_susp;

struct { unsigned short len; unsigned char arr[4]; } l_gd_prod_line_code_susp;

struct { unsigned short len; unsigned char arr[19]; } l_gd_amount;

struct { unsigned short len; unsigned char arr[19]; } l_gd_amount_negative;

struct { unsigned short len; unsigned char arr[19]; } l_gd_debit_amt;

struct { unsigned short len; unsigned char arr[19]; } l_gd_credit_amt;

struct { unsigned short len; unsigned char arr[51]; } l_gd_narration;

struct { unsigned short len; unsigned char arr[3]; } l_gd_post_month;

struct { unsigned short len; unsigned char arr[5]; } l_gd_post_year;

struct { unsigned short len; unsigned char arr[11]; } l_gd_cheque_num;

struct { unsigned short len; unsigned char arr[11]; } l_gd_cheque_date;

struct { unsigned short len; unsigned char arr[5]; } l_gd_trn_type_code;

struct { unsigned short len; unsigned char arr[3]; } l_gd_adj_type;
   /* For adjustments */

int         l_gd_sign_amount;    /* sign(amount)  0 -> 0   */
                                 /*               1 -> +ve */
                                 /*              -1 -> -ve */

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA; 
 */ 
/*
 * $Header:   E:/MEDICOM-MASTER/archives/MEDICOM-eHIS5/MEDSRC/AR/AR_GLD.c-arc   1.0   Nov 16 2005 16:13:26   Administrator  $ sqlca.h 
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

 
/* #include "winproc.h" */

/* modified ver 2.10.01   */ 
  char string_var[100];
  /*----------------------*/    
  
ins_gl_distrbn(passed_doc_type,passed_doc_num,passed_trn_type)
char passed_doc_type[],
     passed_doc_num[];
int  passed_trn_type;
{
   audit_option_flag  = passed_trn_type;
   strcpy(nd_gd_doc_type_code.arr,passed_doc_type);
   nd_gd_doc_type_code.len = strlen(nd_gd_doc_type_code.arr);

   strcpy(nd_gd_doc_num.arr,passed_doc_num);
   nd_gd_doc_num.len = strlen(nd_gd_doc_num.arr);

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
        case 7 : process_cashier();
                 break;
   }
   return (0);
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
       case 7 : decl_cash_curs();
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
                        MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        PAYABLE_AMT,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        SIGN(PAYABLE_AMT),
                        DECODE(SIGN(PAYABLE_AMT),-1,-PAYABLE_AMT,PAYABLE_AMT)
                   FROM AR_INV_HDR
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 


       /* EXEC SQL DECLARE CUR_INV_LINE CURSOR FOR
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
                   FROM AR_INV_LINE
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 

}

open_in_hdr()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Open Inv hdr\n");
#endif
       /* EXEC SQL OPEN CUR_INV_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 2;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0001;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )5;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_INV_HDR",0,"");
}

fetch_in_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside Fetch in hdr\n");
#endif
       init_variables(2);

       /* EXEC SQL FETCH CUR_INV_HDR
                 INTO :l_gd_doc_type_code,
                      :l_gd_doc_num,
                      :l_gd_doc_date,
                      :l_gd_doc_ref,
                      :l_gd_cust_code,
                      :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_amount,
                      :l_gd_narration,
                      :l_gd_post_month,
                      :l_gd_post_year,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )28;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )13;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_doc_ref;
       sqlstm.sqhstl[3] = (unsigned int  )18;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_cust_code;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[9] = (unsigned int  )9;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[11] = (unsigned int  )6;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[12] = (unsigned int  )21;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[13] = (unsigned int  )53;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&l_gd_post_month;
       sqlstm.sqhstl[14] = (unsigned int  )5;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&l_gd_post_year;
       sqlstm.sqhstl[15] = (unsigned int  )7;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&l_gd_sign_amount;
       sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&l_gd_amount_negative;
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
       strcpy(l_gd_trn_type_code.arr,"INV");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0002;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )115;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
                 INTO :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_narration,
                      :l_gd_amount,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )138;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )9;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )6;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
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
       strcpy(l_gd_trn_type_code.arr,"INV");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY')
                   FROM AR_DN_HDR
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 

                     


       /* EXEC SQL DECLARE CUR_DN_INV_HDR CURSOR FOR
                 SELECT CUST_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        DOC_AMT,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        SIGN(DOC_AMT),
                        DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
                        ORG_DOC_TYPE_CODE,
                        ORG_DOC_NUM
                   FROM AR_DN_INV_HDR 
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 


       /* EXEC SQL DECLARE CUR_DN_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        NARRATION,
                        AMOUNT,
                        SIGN(AMOUNT),
                        DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT)
                   FROM AR_DN_LINE
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num
                    AND ORG_DOC_TYPE_CODE = :l_gd_org_doc_type_code
                    AND ORG_DOC_NUM       = :l_gd_org_doc_num; */ 


}

open_dn_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside Open dn hdr\n");
#endif
       /* EXEC SQL OPEN CUR_DN_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0003;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )197;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_DN_HDR",0,"");
}

fetch_dn_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside fetch dn hdr\n");
#endif
       init_variables(2);

       /* EXEC SQL FETCH CUR_DN_HDR
                 INTO :l_gd_doc_type_code,
                      :l_gd_doc_num,
                      :l_gd_doc_date; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )220;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )13;
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
            err_mesg("FETCH failed on cursor CUR_DN_HDR",0,"");

       null_terminate(2);
       strcpy(l_gd_trn_type_code.arr,"DEB");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0004;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )247;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
   sprintf(string_var,"doc is <%s> - <%s> \n",l_gd_doc_type_code.arr,l_gd_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"doc date is <%s>\n",l_gd_doc_date.arr);  
   disp_message(INFO_MESG,string_var); 
#endif

       /* EXEC SQL FETCH CUR_DN_INV_HDR
                 INTO :l_gd_doc_ref,
                      :l_gd_cust_code,
                      :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_amount,
                      :l_gd_narration,
                      :l_gd_post_month,
                      :l_gd_post_year,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative,
                      :l_gd_org_doc_type_code,
                      :l_gd_org_doc_num; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )270;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_ref;
       sqlstm.sqhstl[0] = (unsigned int  )18;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_cust_code;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[3] = (unsigned int  )7;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[4] = (unsigned int  )6;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[5] = (unsigned int  )11;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[6] = (unsigned int  )9;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )6;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[9] = (unsigned int  )21;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[10] = (unsigned int  )53;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&l_gd_post_month;
       sqlstm.sqhstl[11] = (unsigned int  )5;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&l_gd_post_year;
       sqlstm.sqhstl[12] = (unsigned int  )7;
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
       sqlstm.sqhstl[14] = (unsigned int  )21;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&l_gd_org_doc_type_code;
       sqlstm.sqhstl[15] = (unsigned int  )9;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&l_gd_org_doc_num;
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
            err_mesg("FETCH failed on cursor CUR_DN_INV_HDR",0,"");

       null_terminate(1);
       strcpy(l_gd_trn_type_code.arr,"DEB");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0005;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )353;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_org_doc_num;
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
                 INTO :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_narration,
                      :l_gd_amount,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )384;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )9;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )6;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
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
       strcpy(l_gd_trn_type_code.arr,"DEB");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
                        TO_CHAR(DOC_DATE,'DD/MM/YYYY')
                   FROM AR_CN_HDR
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 

                     

       /* EXEC SQL DECLARE CUR_CN_INV_HDR CURSOR FOR
                 SELECT CUST_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        DOC_AMT,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        SIGN(DOC_AMT),
                        DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
                        ORG_DOC_TYPE_CODE,
                        ORG_DOC_NUM
                   FROM AR_CN_INV_HDR 
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 


       /* EXEC SQL DECLARE CUR_CN_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        NARRATION,
                        AMOUNT,
                        SIGN(AMOUNT),
                        DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT)
                   FROM AR_CN_LINE 
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num
                    AND ORG_DOC_TYPE_CODE = :l_gd_org_doc_type_code
                    AND ORG_DOC_NUM       = :l_gd_org_doc_num; */ 

}

open_cn_hdr()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"In open cn hdr\n");
#endif
       /* EXEC SQL OPEN CUR_CN_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0006;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )443;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_CN_HDR",0,"");
}

fetch_cn_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside fetch cn hdr\n");
#endif
       init_variables(2);

       /* EXEC SQL FETCH CUR_CN_HDR
                 INTO :l_gd_doc_type_code,
                      :l_gd_doc_num,
                      :l_gd_doc_date; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )466;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )13;
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
            err_mesg("FETCH failed on cursor CUR_CN_HDR",0,"");

       null_terminate(2);
       strcpy(l_gd_trn_type_code.arr,"CRE");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

open_cn_inv_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside open cn inv hdr\n");
  sprintf(string_var,"doc is <%s> - <%s> \n",l_gd_doc_type_code.arr,l_gd_doc_num.arr);
  disp_message(INFO_MESG,string_var); 
#endif 
       /* EXEC SQL OPEN CUR_CN_INV_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0007;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )493;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
   sprintf(string_var,"doc is <%s> - <%s> \n",l_gd_doc_type_code.arr,l_gd_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"doc date is <%s>\n",l_gd_doc_date.arr);
   disp_message(INFO_MESG,string_var);
#endif 

       /* EXEC SQL FETCH CUR_CN_INV_HDR
                 INTO :l_gd_doc_ref,
                      :l_gd_cust_code,
                      :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_amount,
                      :l_gd_narration,
                      :l_gd_post_month,
                      :l_gd_post_year,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative,
                      :l_gd_org_doc_type_code,
                      :l_gd_org_doc_num; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )516;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_ref;
       sqlstm.sqhstl[0] = (unsigned int  )18;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_cust_code;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[3] = (unsigned int  )7;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[4] = (unsigned int  )6;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[5] = (unsigned int  )11;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[6] = (unsigned int  )9;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )6;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[9] = (unsigned int  )21;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[10] = (unsigned int  )53;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&l_gd_post_month;
       sqlstm.sqhstl[11] = (unsigned int  )5;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&l_gd_post_year;
       sqlstm.sqhstl[12] = (unsigned int  )7;
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
       sqlstm.sqhstl[14] = (unsigned int  )21;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&l_gd_org_doc_type_code;
       sqlstm.sqhstl[15] = (unsigned int  )9;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&l_gd_org_doc_num;
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
            err_mesg("FETCH failed on cursor CUR_CN_INV_HDR",0,"");

       null_terminate(1);
       strcpy(l_gd_trn_type_code.arr,"CRE");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0008;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )599;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_org_doc_num;
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
                 INTO :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_narration,
                      :l_gd_amount,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )630;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )9;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )6;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
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
       strcpy(l_gd_trn_type_code.arr,"CRE");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

decl_adj_curs()
{
#ifdef DEBUG
  dis_message(INFO_MESG,"In decl adj cur\n");
#endif

       /* EXEC SQL DECLARE CUR_ADJ_HDR CURSOR FOR
                 SELECT DOC_TYPE_CODE,
                        DOC_NUM,
						TO_CHAR(DOC_DATE,'DD/MM/YYYY')
                   FROM AR_ADJ_HDR
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 

                     

       /* EXEC SQL DECLARE CUR_ADJ_INV_HDR CURSOR FOR
                 SELECT CUST_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        DOC_AMT,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        ADJ_TYPE,
                        SIGN(DOC_AMT),
                        DECODE(SIGN(DOC_AMT),-1,-DOC_AMT,DOC_AMT),
                        ORG_DOC_TYPE_CODE,
                        ORG_DOC_NUM
                   FROM AR_ADJ_INV_HDR 
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 


       /* EXEC SQL DECLARE CUR_ADJ_LINE CURSOR FOR
                 SELECT MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        NARRATION,
                        AMOUNT,
                        SIGN(AMOUNT),
                        DECODE(SIGN(AMOUNT),-1,-AMOUNT,AMOUNT)
                   FROM AR_ADJ_LINE
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num
                    AND ORG_DOC_TYPE_CODE = :l_gd_org_doc_type_code
                    AND ORG_DOC_NUM       = :l_gd_org_doc_num; */ 

}

open_adj_hdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"In open adj hdr\n");
#endif
       /* EXEC SQL OPEN CUR_ADJ_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0009;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )689;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_ADJ_HDR",0,"");
}

fetch_adj_hdr()
{
       init_variables(2);
#ifdef DEBUG
  disp_message(INFO_MESG,"In fetch adj hdr\n");
#endif

       /* EXEC SQL FETCH CUR_ADJ_HDR
                 INTO :l_gd_doc_type_code,
                      :l_gd_doc_num,
                      :l_gd_doc_date; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )712;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )13;
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
            err_mesg("FETCH failed on cursor CUR_ADJ_HDR",0,"");

       null_terminate(2);
       strcpy(l_gd_trn_type_code.arr,"ADJ");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0010;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )739;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
       l_gd_adj_type.arr[0] = '\0';
       l_gd_adj_type.len    = 0;
 
       /* EXEC SQL FETCH CUR_ADJ_INV_HDR
                 INTO :l_gd_doc_ref,
                      :l_gd_cust_code,
                      :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_amount,
                      :l_gd_narration,
                      :l_gd_post_month,
                      :l_gd_post_year,
                      :l_gd_adj_type,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative,
                      :l_gd_org_doc_type_code,
                      :l_gd_org_doc_num; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )762;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_ref;
       sqlstm.sqhstl[0] = (unsigned int  )18;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_cust_code;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[3] = (unsigned int  )7;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[4] = (unsigned int  )6;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[5] = (unsigned int  )11;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[6] = (unsigned int  )9;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )6;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[9] = (unsigned int  )21;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[10] = (unsigned int  )53;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&l_gd_post_month;
       sqlstm.sqhstl[11] = (unsigned int  )5;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&l_gd_post_year;
       sqlstm.sqhstl[12] = (unsigned int  )7;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&l_gd_adj_type;
       sqlstm.sqhstl[13] = (unsigned int  )5;
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
       sqlstm.sqhstl[15] = (unsigned int  )21;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&l_gd_org_doc_type_code;
       sqlstm.sqhstl[16] = (unsigned int  )9;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&l_gd_org_doc_num;
       sqlstm.sqhstl[17] = (unsigned int  )11;
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
            err_mesg("FETCH failed on cursor CUR_ADJ_INV_HDR",0,"");

       l_gd_adj_type.arr[l_gd_adj_type.len]  = '\0';

       null_terminate(1);
       strcpy(l_gd_trn_type_code.arr,"ADJ");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

#ifdef DEBUG
   sprintf(string_var,"After fetching Adj inv hdr  Adj type - <%s><%d>\n",
            l_gd_adj_type.arr,
            l_gd_adj_type.len);
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
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0011;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )849;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_org_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_org_doc_num;
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
                 INTO :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_narration,
                      :l_gd_amount,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )880;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )9;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )6;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
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
       strcpy(l_gd_trn_type_code.arr,"ADJ");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 


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
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 

}

open_rec_hdr()
{
       /* EXEC SQL OPEN CUR_REC_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 18;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0012;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )939;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_REC_HDR",0,"");
}

fetch_rec_hdr()
{
       init_variables(2);

       /* EXEC SQL FETCH CUR_REC_HDR
                 INTO :l_gd_doc_type_code,
                      :l_gd_doc_num,
                      :l_gd_doc_date,
                      :l_gd_doc_ref,
                      :l_gd_cust_code,
                      :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_amount,
                      :l_gd_narration,
                      :l_gd_post_month,
                      :l_gd_post_year,
                      :l_gd_cheque_num,
                      :l_gd_cheque_date,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )962;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )13;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_doc_ref;
       sqlstm.sqhstl[3] = (unsigned int  )18;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_cust_code;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[9] = (unsigned int  )9;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[11] = (unsigned int  )6;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[12] = (unsigned int  )21;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[13] = (unsigned int  )53;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&l_gd_post_month;
       sqlstm.sqhstl[14] = (unsigned int  )5;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&l_gd_post_year;
       sqlstm.sqhstl[15] = (unsigned int  )7;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&l_gd_cheque_num;
       sqlstm.sqhstl[16] = (unsigned int  )13;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&l_gd_cheque_date;
       sqlstm.sqhstl[17] = (unsigned int  )13;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&l_gd_sign_amount;
       sqlstm.sqhstl[18] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&l_gd_amount_negative;
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
       strcpy(l_gd_trn_type_code.arr,"REC");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

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
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0013;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1057;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
                 INTO :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_narration,
                      :l_gd_amount,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1080;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )9;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )6;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
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
       strcpy(l_gd_trn_type_code.arr,"REC");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}

decl_pay_curs()
{
       /* EXEC SQL DECLARE CUR_PAY_HDR CURSOR FOR
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
                   FROM AR_PAY_HDR
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 


       /* EXEC SQL DECLARE CUR_PAY_LINE CURSOR FOR
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
                   FROM AR_PAY_LINE
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 

}

open_pay_hdr()
{
       /* EXEC SQL OPEN CUR_PAY_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0014;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1139;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_PAY_HDR",0,"");
}

fetch_pay_hdr()
{
       init_variables(2);

       /* EXEC SQL FETCH CUR_PAY_HDR
                 INTO :l_gd_doc_type_code,
                      :l_gd_doc_num,
                      :l_gd_doc_date,
                      :l_gd_doc_ref,
                      :l_gd_cust_code,
                      :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_amount,
                      :l_gd_narration,
                      :l_gd_post_month,
                      :l_gd_post_year,
                      :l_gd_cheque_num,
                      :l_gd_cheque_date,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1162;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )13;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_doc_ref;
       sqlstm.sqhstl[3] = (unsigned int  )18;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_cust_code;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[9] = (unsigned int  )9;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[11] = (unsigned int  )6;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[12] = (unsigned int  )21;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[13] = (unsigned int  )53;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&l_gd_post_month;
       sqlstm.sqhstl[14] = (unsigned int  )5;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&l_gd_post_year;
       sqlstm.sqhstl[15] = (unsigned int  )7;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&l_gd_cheque_num;
       sqlstm.sqhstl[16] = (unsigned int  )13;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&l_gd_cheque_date;
       sqlstm.sqhstl[17] = (unsigned int  )13;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&l_gd_sign_amount;
       sqlstm.sqhstl[18] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&l_gd_amount_negative;
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
       strcpy(l_gd_trn_type_code.arr,"REF");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

#ifdef DEBUG
 sprintf(string_var,"count is <%d>\n",sqlca.sqlerrd[2]);
 disp_message(INFO_MESG,string_var);
 sprintf(string_var,"code is <%d>\n",sqlca.sqlcode);
 disp_message(INFO_MESG,string_var);
#endif

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
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0015;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1257;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
                 INTO :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_narration,
                      :l_gd_amount,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1280;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[4] = (unsigned int  )9;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[5] = (unsigned int  )6;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[6] = (unsigned int  )6;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[7] = (unsigned int  )53;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[8] = (unsigned int  )21;
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
       strcpy(l_gd_trn_type_code.arr,"REF");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

       if (LAST_ROW)
            return (0);
       else
            return (1);
}
/*****************************************************************/

decl_cash_curs()
{
       /* EXEC SQL DECLARE CUR_CASH_HDR CURSOR FOR
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
                        -AMT_LOCAL
			FROM AR_CASHIER
                  WHERE DOC_TYPE_CODE = :nd_gd_doc_type_code
                    AND DOC_NUM       = :nd_gd_doc_num; */ 


       
}

open_cash_hdr()
{
       /* EXEC SQL OPEN CUR_CASH_HDR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0016;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1339;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_gd_doc_num;
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
           err_mesg("OPEN failed on cursor CUR_CASH_HDR",0,"");
}

fetch_cash_hdr()
{
       init_variables(2);

       /* EXEC SQL FETCH CUR_CASH_HDR
                 INTO :l_gd_doc_type_code,
                      :l_gd_doc_num,
                      :l_gd_doc_date,
                      :l_gd_doc_ref,
                      :l_gd_cust_code,
                      :l_gd_main_acc1_code,
                      :l_gd_main_acc2_code,
                      :l_gd_subledger_group_code,
                      :l_gd_subledger_line_code,
                      :l_gd_dept_code,
                      :l_gd_product_group_code,
                      :l_gd_product_line_code,
                      :l_gd_main_acc1_code_susp,
                      :l_gd_main_acc2_code_susp,
                      :l_gd_subled_group_code_susp,
                      :l_gd_subled_line_code_susp,
                      :l_gd_dept_code_susp,
                      :l_gd_prod_group_code_susp,
                      :l_gd_prod_line_code_susp,
                      :l_gd_amount,
                      :l_gd_narration,
                      :l_gd_post_month,
                      :l_gd_post_year,
                      :l_gd_cheque_num,
                      :l_gd_cheque_date,
                      :l_gd_sign_amount,
                      :l_gd_amount_negative; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 27;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1362;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
       sqlstm.sqhstl[2] = (unsigned int  )13;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gd_doc_ref;
       sqlstm.sqhstl[3] = (unsigned int  )18;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_gd_cust_code;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_gd_main_acc1_code;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_gd_main_acc2_code;
       sqlstm.sqhstl[6] = (unsigned int  )7;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_gd_subledger_group_code;
       sqlstm.sqhstl[7] = (unsigned int  )6;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_gd_subledger_line_code;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&l_gd_dept_code;
       sqlstm.sqhstl[9] = (unsigned int  )9;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&l_gd_product_group_code;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&l_gd_product_line_code;
       sqlstm.sqhstl[11] = (unsigned int  )6;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&l_gd_main_acc1_code_susp;
       sqlstm.sqhstl[12] = (unsigned int  )9;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&l_gd_main_acc2_code_susp;
       sqlstm.sqhstl[13] = (unsigned int  )7;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&l_gd_subled_group_code_susp;
       sqlstm.sqhstl[14] = (unsigned int  )6;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&l_gd_subled_line_code_susp;
       sqlstm.sqhstl[15] = (unsigned int  )11;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&l_gd_dept_code_susp;
       sqlstm.sqhstl[16] = (unsigned int  )9;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&l_gd_prod_group_code_susp;
       sqlstm.sqhstl[17] = (unsigned int  )6;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&l_gd_prod_line_code_susp;
       sqlstm.sqhstl[18] = (unsigned int  )6;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&l_gd_amount;
       sqlstm.sqhstl[19] = (unsigned int  )21;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&l_gd_narration;
       sqlstm.sqhstl[20] = (unsigned int  )53;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&l_gd_post_month;
       sqlstm.sqhstl[21] = (unsigned int  )5;
       sqlstm.sqhsts[21] = (         int  )0;
       sqlstm.sqindv[21] = (         void  *)0;
       sqlstm.sqinds[21] = (         int  )0;
       sqlstm.sqharm[21] = (unsigned int  )0;
       sqlstm.sqadto[21] = (unsigned short )0;
       sqlstm.sqtdso[21] = (unsigned short )0;
       sqlstm.sqhstv[22] = (         void  *)&l_gd_post_year;
       sqlstm.sqhstl[22] = (unsigned int  )7;
       sqlstm.sqhsts[22] = (         int  )0;
       sqlstm.sqindv[22] = (         void  *)0;
       sqlstm.sqinds[22] = (         int  )0;
       sqlstm.sqharm[22] = (unsigned int  )0;
       sqlstm.sqadto[22] = (unsigned short )0;
       sqlstm.sqtdso[22] = (unsigned short )0;
       sqlstm.sqhstv[23] = (         void  *)&l_gd_cheque_num;
       sqlstm.sqhstl[23] = (unsigned int  )13;
       sqlstm.sqhsts[23] = (         int  )0;
       sqlstm.sqindv[23] = (         void  *)0;
       sqlstm.sqinds[23] = (         int  )0;
       sqlstm.sqharm[23] = (unsigned int  )0;
       sqlstm.sqadto[23] = (unsigned short )0;
       sqlstm.sqtdso[23] = (unsigned short )0;
       sqlstm.sqhstv[24] = (         void  *)&l_gd_cheque_date;
       sqlstm.sqhstl[24] = (unsigned int  )13;
       sqlstm.sqhsts[24] = (         int  )0;
       sqlstm.sqindv[24] = (         void  *)0;
       sqlstm.sqinds[24] = (         int  )0;
       sqlstm.sqharm[24] = (unsigned int  )0;
       sqlstm.sqadto[24] = (unsigned short )0;
       sqlstm.sqtdso[24] = (unsigned short )0;
       sqlstm.sqhstv[25] = (         void  *)&l_gd_sign_amount;
       sqlstm.sqhstl[25] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[25] = (         int  )0;
       sqlstm.sqindv[25] = (         void  *)0;
       sqlstm.sqinds[25] = (         int  )0;
       sqlstm.sqharm[25] = (unsigned int  )0;
       sqlstm.sqadto[25] = (unsigned short )0;
       sqlstm.sqtdso[25] = (unsigned short )0;
       sqlstm.sqhstv[26] = (         void  *)&l_gd_amount_negative;
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
            err_mesg("FETCH failed on cursor CUR_CASH_HDR",0,"");

       null_terminate(2);
       strcpy(l_gd_trn_type_code.arr,"CASH");
       l_gd_trn_type_code.len = strlen(l_gd_trn_type_code.arr);

#ifdef DEBUG
 sprintf(string_var,"count is <%d>\n",sqlca.sqlerrd[2]);
 disp_message(INFO_MESG,string_var);
 sprintf(string_var,"code is <%d>\n",sqlca.sqlcode);
 disp_message(INFO_MESG,string_var);
#endif

       if (LAST_ROW)
          return (0);
       else
          return (1);
}




/*****************************************************************/

init_variables(flg)
int flg;
{

  if (flg)   /* Before Fetching hdr or Inv hdr */
  {
    if (flg == 2)  /* Before Fetching hdr */
    { 
        l_gd_doc_type_code.arr[0]         = '\0';
        l_gd_doc_num.arr[0]               = '\0';
        l_gd_doc_date.arr[0]              = '\0';
    }
    l_gd_doc_ref.arr[0]               = '\0';
    l_gd_cust_code.arr[0]             = '\0';
    l_gd_post_month.arr[0]            = '\0';
    l_gd_post_year.arr[0]             = '\0';
    l_gd_cheque_num.arr[0]            = '\0';
    l_gd_cheque_date.arr[0]           = '\0';
  }

l_gd_org_doc_type_code.arr[0]     = '\0';
l_gd_org_doc_num.arr[0]           = '\0';

l_gd_main_acc1_code.arr[0]        = '\0';
l_gd_main_acc2_code.arr[0]        = '\0';
l_gd_subledger_group_code.arr[0]  = '\0';
l_gd_subledger_line_code.arr[0]   = '\0';
l_gd_dept_code.arr[0]             = '\0';
l_gd_product_group_code.arr[0]    = '\0';
l_gd_product_line_code.arr[0]     = '\0';

l_gd_main_acc1_code_susp.arr[0]   = '\0';
l_gd_main_acc2_code_susp.arr[0]   = '\0';
l_gd_subled_group_code_susp.arr[0] = '\0';
l_gd_subled_line_code_susp.arr[0]  = '\0';
l_gd_dept_code_susp.arr[0]         = '\0';
l_gd_prod_group_code_susp.arr[0]   = '\0';
l_gd_prod_line_code_susp.arr[0]    = '\0';

l_gd_amount.arr[0]                = '\0';
l_gd_debit_amt.arr[0]             = '\0';
l_gd_credit_amt.arr[0]            = '\0';
l_gd_narration.arr[0]             = '\0';
l_gd_trn_type_code.arr[0]         = '\0';
l_gd_amount_negative.arr[0]       = '\0';

l_gd_sign_amount                  = 0;

  if (flg)   /* Before Fetching hdr or Inv hdr */
  {
    if (flg == 2)  /* Before Fetching hdr */
    { 
       l_gd_doc_type_code.len            = 0;
       l_gd_doc_num.len                  = 0;
       l_gd_doc_date.len                 = 0;
    }
    l_gd_doc_ref.len                  = 0;
    l_gd_cust_code.len                = 0;
    l_gd_post_month.len               = 0;
    l_gd_post_year.len                = 0;
    l_gd_cheque_num.len               = 0;
    l_gd_cheque_date.len              = 0;
  }

l_gd_org_doc_type_code.len        = 0;
l_gd_org_doc_num.len              = 0;

l_gd_main_acc1_code.len           = 0;
l_gd_main_acc2_code.len           = 0;
l_gd_subledger_group_code.len     = 0;
l_gd_subledger_line_code.len      = 0;
l_gd_dept_code.len                = 0;
l_gd_product_group_code.len       = 0;
l_gd_product_line_code.len        = 0;

l_gd_main_acc1_code_susp.len     = 0;
l_gd_main_acc2_code_susp.len     = 0;
l_gd_subled_group_code_susp.len     = 0;
l_gd_subled_line_code_susp.len     = 0;
l_gd_dept_code_susp.len     = 0;
l_gd_prod_group_code_susp.len     = 0;
l_gd_prod_line_code_susp.len     = 0;


l_gd_amount.len                   = 0;
l_gd_debit_amt.len                = 0;
l_gd_credit_amt.len               = 0;
l_gd_narration.len                = 0;
l_gd_trn_type_code.len            = 0;
l_gd_amount_negative.len          = 0;

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
       l_gd_doc_type_code.arr[l_gd_doc_type_code.len]                  = '\0';
       l_gd_doc_num.arr[l_gd_doc_num.len]                              = '\0';
       l_gd_doc_date.arr[l_gd_doc_date.len]                            = '\0';
    }
    l_gd_doc_ref.arr[l_gd_doc_ref.len]                              = '\0';
    l_gd_cust_code.arr[l_gd_cust_code.len]                          = '\0';
    l_gd_post_month.arr[l_gd_post_month.len]                        = '\0';
    l_gd_post_year.arr[l_gd_post_year.len]                          = '\0';
    l_gd_cheque_num.arr[l_gd_cheque_num.len]                        = '\0';
    l_gd_cheque_date.arr[l_gd_cheque_date.len]                      = '\0';
  }

l_gd_org_doc_type_code.arr[l_gd_org_doc_type_code.len]          = '\0';
l_gd_org_doc_num.arr[l_gd_org_doc_num.len]                      = '\0';

l_gd_main_acc1_code.arr[l_gd_main_acc1_code.len]                = '\0';
l_gd_main_acc2_code.arr[l_gd_main_acc2_code.len]                = '\0';
l_gd_subledger_group_code.arr[l_gd_subledger_group_code.len]    = '\0';
l_gd_subledger_line_code.arr[l_gd_subledger_line_code.len]      = '\0';
l_gd_dept_code.arr[l_gd_dept_code.len]                          = '\0';
l_gd_product_group_code.arr[l_gd_product_group_code.len]        = '\0';
l_gd_product_line_code.arr[l_gd_product_line_code.len]          = '\0';

l_gd_main_acc1_code_susp.arr[l_gd_main_acc1_code_susp.len]       = '\0';
l_gd_main_acc2_code_susp.arr[l_gd_main_acc2_code_susp.len]       = '\0';
l_gd_subled_group_code_susp.arr[l_gd_subled_group_code_susp.len] = '\0';
l_gd_subled_line_code_susp.arr[l_gd_subled_line_code_susp.len]   = '\0';
l_gd_dept_code_susp.arr[l_gd_dept_code_susp.len]                 = '\0';
l_gd_prod_group_code_susp.arr[l_gd_prod_group_code_susp.len]     = '\0';
l_gd_prod_line_code_susp.arr[l_gd_prod_line_code_susp.len]       = '\0';

l_gd_amount.arr[l_gd_amount.len]                                = '\0';
l_gd_debit_amt.arr[l_gd_debit_amt.len]                          = '\0';
l_gd_credit_amt.arr[l_gd_credit_amt.len]                        = '\0';
l_gd_narration.arr[l_gd_narration.len]                          = '\0';
l_gd_trn_type_code.arr[l_gd_trn_type_code.len]                  = '\0';
l_gd_amount_negative.arr[l_gd_amount_negative.len]              = '\0';

#ifdef DEBUG
  sprintf(string_var,"doc is <%s><%d> - <%s><%d> <%s>-<%d>\n",
       l_gd_doc_type_code.arr,
       l_gd_doc_type_code.len,
       l_gd_doc_num.arr,
       l_gd_doc_num.len,
       l_gd_doc_date.arr,
       l_gd_doc_date.len);
  disp_message(INFO_MESG,string_var);     
  sprintf(string_var," main <%s><%d> - <%s><%d>\n",
       l_gd_main_acc1_code.arr,
       l_gd_main_acc1_code.len,
       l_gd_main_acc2_code.arr,
       l_gd_main_acc2_code.len);
  disp_message(INFO_MESG,string_var);     
  sprintf(string_var," amt is <%s><%d> amt neg is <%s> sign is <%d>\n",
       l_gd_amount.arr,
       l_gd_amount.len,
       l_gd_amount_negative.arr,
       l_gd_sign_amount);
  disp_message(INFO_MESG,string_var);     
#endif
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


process_cashier()
{
   open_cash_hdr();

   fetch_cash_hdr();
    
   insert_cash_disturbution(); 
       
    
}

insert_cash_disturbution()
{
     

   /* EXEC SQL INSERT INTO AR_GL_DISTRBN
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
               :l_gd_doc_type_code,
               :l_gd_doc_num,
                TO_DATE(:l_gd_doc_date,'DD/MM/YYYY'),
               :l_gd_doc_ref,
               :l_gd_cust_code,
               :l_gd_main_acc1_code,
               :l_gd_main_acc2_code,
               :l_gd_subledger_group_code,
               :l_gd_subledger_line_code,
               :l_gd_dept_code,
               :l_gd_product_group_code,
               :l_gd_product_line_code,
               :l_gd_amount,
               0,
               :l_gd_narration,
               :l_gd_post_month,
               :l_gd_post_year,
               :l_gd_cheque_num,
			   TO_DATE(:l_gd_cheque_date,'DD/MM/YYYY'),
               'REC'
   ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_GL_DISTRBN (DOC_TYPE_CODE,DOC_NUM,DOC_DATE,\
DOC_REF,CUST_CODE,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,DEBIT_AMT,CREDIT_AMT\
,NARRATION,POST_MONTH,POST_YEAR,CHEQUE_NUM,CHEQUE_DATE,TRN_TYPE_CODE) values (\
:b0,:b1,TO_DATE(:b2,'DD/MM/YYYY'),:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,0\
,:b13,:b14,:b15,:b16,TO_DATE(:b17,'DD/MM/YYYY'),'REC')";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1485;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_gd_doc_ref;
   sqlstm.sqhstl[3] = (unsigned int  )18;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_gd_cust_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_gd_main_acc1_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_gd_main_acc2_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_gd_subledger_group_code;
   sqlstm.sqhstl[7] = (unsigned int  )6;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_gd_subledger_line_code;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_gd_dept_code;
   sqlstm.sqhstl[9] = (unsigned int  )9;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_gd_product_group_code;
   sqlstm.sqhstl[10] = (unsigned int  )6;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_gd_product_line_code;
   sqlstm.sqhstl[11] = (unsigned int  )6;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&l_gd_amount;
   sqlstm.sqhstl[12] = (unsigned int  )21;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&l_gd_narration;
   sqlstm.sqhstl[13] = (unsigned int  )53;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&l_gd_post_month;
   sqlstm.sqhstl[14] = (unsigned int  )5;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&l_gd_post_year;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&l_gd_cheque_num;
   sqlstm.sqhstl[16] = (unsigned int  )13;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&l_gd_cheque_date;
   sqlstm.sqhstl[17] = (unsigned int  )13;
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
           err_mesg("INSERT failed on table AR_GL_DISTRBN",0,"");

   
    /* EXEC SQL INSERT INTO AR_GL_DISTRBN
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
               :l_gd_doc_type_code,
               :l_gd_doc_num,
                TO_DATE(:l_gd_doc_date,'DD/MM/YYYY'),
               :l_gd_doc_ref,
               :l_gd_cust_code,
               :l_gd_main_acc1_code_susp,
               :l_gd_main_acc2_code_susp,
               :l_gd_subled_group_code_susp,
               :l_gd_subled_line_code_susp,
               :l_gd_dept_code_susp,
               :l_gd_prod_group_code_susp,
               :l_gd_prod_line_code_susp,
               0,
               :l_gd_amount,
               :l_gd_narration,
               :l_gd_post_month,
               :l_gd_post_year,
               :l_gd_cheque_num,
			   TO_DATE(:l_gd_cheque_date,'DD/MM/YYYY'),
               'REC'
   ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into AR_GL_DISTRBN (DOC_TYPE_CODE,DOC_NUM,DOC_DATE\
,DOC_REF,CUST_CODE,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGE\
R_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,DEBIT_AMT,CREDIT_AM\
T,NARRATION,POST_MONTH,POST_YEAR,CHEQUE_NUM,CHEQUE_DATE,TRN_TYPE_CODE) values \
(:b0,:b1,TO_DATE(:b2,'DD/MM/YYYY'),:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,0,:b1\
2,:b13,:b14,:b15,:b16,TO_DATE(:b17,'DD/MM/YYYY'),'REC')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1572;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_gd_doc_ref;
    sqlstm.sqhstl[3] = (unsigned int  )18;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_gd_cust_code;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&l_gd_main_acc1_code_susp;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&l_gd_main_acc2_code_susp;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&l_gd_subled_group_code_susp;
    sqlstm.sqhstl[7] = (unsigned int  )6;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&l_gd_subled_line_code_susp;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&l_gd_dept_code_susp;
    sqlstm.sqhstl[9] = (unsigned int  )9;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&l_gd_prod_group_code_susp;
    sqlstm.sqhstl[10] = (unsigned int  )6;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&l_gd_prod_line_code_susp;
    sqlstm.sqhstl[11] = (unsigned int  )6;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&l_gd_amount;
    sqlstm.sqhstl[12] = (unsigned int  )21;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&l_gd_narration;
    sqlstm.sqhstl[13] = (unsigned int  )53;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&l_gd_post_month;
    sqlstm.sqhstl[14] = (unsigned int  )5;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&l_gd_post_year;
    sqlstm.sqhstl[15] = (unsigned int  )7;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&l_gd_cheque_num;
    sqlstm.sqhstl[16] = (unsigned int  )13;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&l_gd_cheque_date;
    sqlstm.sqhstl[17] = (unsigned int  )13;
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
           err_mesg("INSERT failed on table AR_GL_DISTRBN",0,"");



}



insert_distrbn(hdr_line)
int hdr_line;
{
   calculate_credit_debit(hdr_line);

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside insert distrbn \n");
   sprintf(string_var,"doc is <%s> - <%s>\n",l_gd_doc_type_code.arr,l_gd_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var," deb is <%s><%d> cre is <%s><%d>\n",
        l_gd_debit_amt.arr,
        l_gd_debit_amt.len,
        l_gd_credit_amt.arr,
        l_gd_credit_amt.len);
   disp_message(INFO_MESG,string_var);     
   getchar();
#endif

   /* EXEC SQL INSERT INTO AR_GL_DISTRBN
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
               :l_gd_doc_type_code,
               :l_gd_doc_num,
                TO_DATE(:l_gd_doc_date,'DD/MM/YYYY'),
               :l_gd_doc_ref,
               :l_gd_cust_code,
               :l_gd_main_acc1_code,
               :l_gd_main_acc2_code,
               :l_gd_subledger_group_code,
               :l_gd_subledger_line_code,
               :l_gd_dept_code,
               :l_gd_product_group_code,
               :l_gd_product_line_code,
               :l_gd_debit_amt,
               :l_gd_credit_amt,
               :l_gd_narration,
               :l_gd_post_month,
               :l_gd_post_year,
               :l_gd_cheque_num,
			   TO_DATE(:l_gd_cheque_date,'DD/MM/YYYY'),
               :l_gd_trn_type_code
            ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_GL_DISTRBN (DOC_TYPE_CODE,DOC_NUM,DOC_DATE,\
DOC_REF,CUST_CODE,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,DEBIT_AMT,CREDIT_AMT\
,NARRATION,POST_MONTH,POST_YEAR,CHEQUE_NUM,CHEQUE_DATE,TRN_TYPE_CODE) values (\
:b0,:b1,TO_DATE(:b2,'DD/MM/YYYY'),:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:\
b13,:b14,:b15,:b16,:b17,TO_DATE(:b18,'DD/MM/YYYY'),:b19)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1659;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_gd_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_gd_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_gd_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_gd_doc_ref;
   sqlstm.sqhstl[3] = (unsigned int  )18;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_gd_cust_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_gd_main_acc1_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_gd_main_acc2_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_gd_subledger_group_code;
   sqlstm.sqhstl[7] = (unsigned int  )6;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_gd_subledger_line_code;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_gd_dept_code;
   sqlstm.sqhstl[9] = (unsigned int  )9;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_gd_product_group_code;
   sqlstm.sqhstl[10] = (unsigned int  )6;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_gd_product_line_code;
   sqlstm.sqhstl[11] = (unsigned int  )6;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&l_gd_debit_amt;
   sqlstm.sqhstl[12] = (unsigned int  )21;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&l_gd_credit_amt;
   sqlstm.sqhstl[13] = (unsigned int  )21;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&l_gd_narration;
   sqlstm.sqhstl[14] = (unsigned int  )53;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&l_gd_post_month;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&l_gd_post_year;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&l_gd_cheque_num;
   sqlstm.sqhstl[17] = (unsigned int  )13;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&l_gd_cheque_date;
   sqlstm.sqhstl[18] = (unsigned int  )13;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&l_gd_trn_type_code;
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
           err_mesg("INSERT failed on table AR_GL_DISTRBN",0,"");

}


calculate_credit_debit(hdr_line) /* 0 -> Hdr   1 -> Line */
int hdr_line;
{
 int trn_flg = 0;

 if (audit_option_flag == 7)
 {
    if (!strcmp(l_gd_trn_type_code.arr,"INV"))
          trn_flg = 1;
    else if (!strcmp(l_gd_trn_type_code.arr,"DEB"))
            trn_flg = 2;
         else if (!strcmp(l_gd_trn_type_code.arr,"CRE"))
               trn_flg = 3;
              else if (!strcmp(l_gd_trn_type_code.arr,"ADJ"))
                    trn_flg = 4;
                 else if (!strcmp(l_gd_trn_type_code.arr,"REC"))
                       trn_flg = 5;
                 else if (!strcmp(l_gd_trn_type_code.arr,"REF"))
                       trn_flg = 6;
  }
  else
     trn_flg = audit_option_flag;

#ifdef DEBUG
  sprintf(string_var,"Amt is <%s> - <%f> hdr_line is <%d> \n",l_gd_amount.arr,
              atof(l_gd_amount.arr),
             hdr_line);
  disp_message(INFO_MESG,string_var);              
              
#endif
 
  switch  (trn_flg)
  {
      case 1 :  
               if ( !hdr_line )   /* Hdr rec */
                   Debit();
               else if (atof(l_gd_amount.arr) < 0.00)    /* -ve */
                       Debit(); 
                    else 
                       Credit();
               break; 
      case 2 :
               if ( !hdr_line )   /* Hdr rec */
                   Debit();
               else if (atof(l_gd_amount.arr) < 0.00)   /* -ve */
                       Debit(); 
                    else 
                       Credit();
               break;
      case 3 : 
               if ( !hdr_line )   /* Hdr rec */
                   Credit();
               else if (atof(l_gd_amount.arr) < 0.00)   /* -ve */
                       Credit(); 
                    else 
                       Debit();
               break;
      case 4 : 
               if ( !hdr_line )   /* Hdr rec */
               {
                   if (l_gd_adj_type.arr[0] == 'D')
                        Debit();
                   else
                        Credit();
               }
               else if (atof(l_gd_amount.arr) < 0.00)   /* -ve */
                    {
                       if (l_gd_adj_type.arr[0] == 'D')
                            Debit();
                       else
                            Credit();
                    }
                    else 
                    {
                       if (l_gd_adj_type.arr[0] == 'D')
                            Credit();
                       else
                            Debit();
                    }
               break;
      case 5 :
               if ( !hdr_line )   /* Hdr rec */
                   Debit();
               else if (atof(l_gd_amount.arr) < 0.00)
                       Debit(); 
                  else 
                       Credit();
               break;
      case 6 :
               if ( !hdr_line )   /* Hdr rec */
                   Credit();
               else if (atof(l_gd_amount.arr) < 0.00)
                       Debit();
                  else 
                       Credit(); 
               break;
    }

}

Credit()
{
#ifdef DEBUG
 sprintf("In Credit sign is <%d>",l_gd_sign_amount);
 disp_message(INFO_MESG,string_var);           
           

#endif

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
#ifdef DEBUG
 sprintf(string_var,"In Debit sign is <%d>",l_gd_sign_amount);  
 disp_message(INFO_MESG,string_var);
#endif
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
}
