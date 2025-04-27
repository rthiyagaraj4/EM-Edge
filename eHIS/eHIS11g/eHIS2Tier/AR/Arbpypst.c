
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
           char  filnam[47];
};
static const struct sqlcxp sqlfpn =
{
    46,
    "d:\\madhu\\billing\\madhu\\post_refund\\arbpypst.pc"
};


static unsigned long sqlctx = 1667259307;


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
            void  *sqhstv[40];
   unsigned int   sqhstl[40];
            int   sqhsts[40];
            void  *sqindv[40];
            int   sqinds[40];
   unsigned int   sqharm[40];
   unsigned int   *sqharc[40];
   unsigned short  sqadto[40];
   unsigned short  sqtdso[40];
} sqlstm = {10,40};

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

 static const char *sq0006 = 
"select DOC_TYPE_CODE ,DOC_NUM  from AR_PAY_HDR where (((((((OPERATING_FACILI\
TY_ID=:b0 and DOC_TYPE_CODE>=NVL(:b1,'      ')) and DOC_TYPE_CODE<=NVL(:b2,'~~\
~~~~')) and DOC_NUM>=NVL(:b3,0)) and DOC_NUM<=NVL(:b4,99999999)) and NVL(DOC_D\
ATE,SYSDATE)>=NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))) a\
nd NVL(DOC_DATE,SYSDATE)<=NVL(TO_DATE(:b6,'DD/MM/YYYY'),to_date('47123112','YY\
YYDDMM'))) and NVL(POSTED_FLAG,'N')='N')           ";

 static const char *sq0007 = 
"select ACC_ENTITY_CODE ,LAST_LINE_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,TO_CH\
AR(DOC_DATE,'YYYYDDMM') ,DOC_REF ,CUST_CODE ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,S\
UBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODU\
CT_LINE_CODE ,AMT_FOREIGN ,AMT_LOCAL ,NARRATION ,POST_MONTH ,POST_YEAR ,CURREN\
CY_CODE ,EXCHG_RATE ,BANK_DESC ,CHEQUE_NUM ,CHEQUE_DATE ,MISC_CUST_LONG_NAME ,\
MISC_CUST_SHORT_NAME ,MISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,MISC_CUST_ADD3\
_DESC ,MISC_CUST_ZIP_DESC ,MISC_CUST_LONG_NAME_CHINESE ,MISC_CUST_SHORT_NAME_C\
HINESE ,MISC_CUST_ADD1_DESC_CHINESE ,MISC_CUST_ADD2_DESC_CHINESE ,MISC_CUST_AD\
D3_DESC_CHINESE ,MISC_CUST_ZIP_DESC_CHINESE ,TEL_NUM ,CONTACT_NAME ,CONTACT_NA\
ME_TITLE ,PRINT_FLAG ,ROWID  from AR_PAY_HDR where ((OPERATING_FACILITY_ID=:b0\
 and DOC_TYPE_CODE=:b1) and DOC_NUM=:b2) for update of ERROR_FLAG nowait ";

 static const char *sq0012 = 
"select NVL(STATUS,'X') ,NVL(AR_VALID_FLAG,'X') ,NVL(DOC_PRINT_FLAG,'X')  fro\
m GL_ACC_ENTITY_DOC_TYPE_VW where DOC_TYPE_CODE=:b0           ";

 static const char *sq0013 = 
"select NVL(STATUS,'X')  from SY_DOC_TYPE_MASTER where DOC_TYPE_CODE=:b0     \
      ";

 static const char *sq0009 = 
"select 'X'  from AR_TRN_DOC_TYPE where ((OPERATING_FACILITY_ID=:b0 and DOC_T\
YPE_CODE=:b1) and TRN_TYPE_CODE='6')           ";

 static const char *sq0010 = 
"select 'X'  from SY_DOC_CONTROL where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)   \
        ";

 static const char *sq0011 = 
"select NVL(STATUS,'X') ,PATIENT_FLAG ,NVL(TO_CHAR(LAST_REC_DOC_DATE,'DD/MM/Y\
YYY'),0)  from AR_CUSTOMER where CUST_CODE=:b0           ";

 static const char *sq0008 = 
"select AMT_LOCAL ,LINE_NUM ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODU\
CT_GROUP_CODE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,O\
RG_DOC_TYPE_CODE ,ORG_DOC_NUM ,LINE_TYPE_CODE ,CONSOLIDATED_INV_YN  from AR_PA\
Y_LINE where ((OPERATING_FACILITY_ID=:b0 and DOC_TYPE_CODE=:b1) and DOC_NUM=:b\
2) for update of LINE_NUM nowait ";

 static const char *sq0014 = 
"select NVL(PENDING_AMT,0)  from AR_PENDING_DOC where (((OPERATING_FACILITY_I\
D=:b0 and CUST_CODE=:b1) and DOC_TYPE_CODE=:b2) and DOC_NUM=:b3)           ";

 static const char *sq0015 = 
"select DOC_TYPE_CODE ,DOC_NUM ,PATIENT_ID ,INV_DOC_TYPE_CODE ,INV_DOC_NUM ,B\
ILL_DOC_TYPE_CODE ,BILL_NUM ,TO_CHAR(BILL_DATE,'YYYYMMDD') ,NVL(AMOUNT,0) ,ABS\
(nvl(AMOUNT,0)) ,ROWID  from AR_PATIENT_ALLOC_DTLS where ((OPERATING_FACILITY_\
ID=:b0 and DOC_TYPE_CODE=:b1) and DOC_NUM=:b2) order by DOC_TYPE_CODE,DOC_NUM \
           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,243,0,4,299,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,
68,0,0,2,97,0,4,316,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
91,0,0,3,0,0,29,477,0,0,0,0,0,1,0,
106,0,0,4,0,0,30,485,0,0,0,0,0,1,0,
121,0,0,5,0,0,30,502,0,0,0,0,0,1,0,
136,0,0,6,439,0,9,533,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
179,0,0,15,0,0,13,699,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
238,0,0,6,0,0,13,755,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
261,0,0,7,851,0,9,866,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
288,0,0,7,0,0,13,873,0,0,40,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
463,0,0,12,138,0,9,971,0,0,1,1,0,1,0,1,9,0,0,
482,0,0,12,0,0,13,983,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
509,0,0,13,82,0,9,1011,0,0,1,1,0,1,0,1,9,0,0,
528,0,0,13,0,0,13,1019,0,0,1,0,0,1,0,2,9,0,0,
547,0,0,9,123,0,9,1032,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
570,0,0,9,0,0,13,1037,0,0,1,0,0,1,0,2,9,0,0,
589,0,0,10,84,0,9,1048,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
612,0,0,10,0,0,13,1053,0,0,1,0,0,1,0,2,9,0,0,
631,0,0,11,133,0,9,1066,0,0,1,1,0,1,0,1,9,0,0,
650,0,0,11,0,0,13,1079,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
677,0,0,16,104,0,4,1180,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
704,0,0,17,89,0,4,1194,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
731,0,0,8,343,0,9,1287,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
758,0,0,18,0,0,29,1293,0,0,0,0,0,1,0,
773,0,0,14,151,0,9,1305,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
804,0,0,14,0,0,13,1312,0,0,1,0,0,1,0,2,4,0,0,
823,0,0,15,321,0,9,1364,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
850,0,0,19,171,0,4,1372,0,0,6,5,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
889,0,0,8,0,0,13,1450,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
956,0,0,20,471,0,3,1516,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
1003,0,0,21,331,0,3,1574,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1062,0,0,22,555,0,3,1616,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1089,0,0,23,70,0,2,1691,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1112,0,0,24,71,0,2,1698,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1135,0,0,25,167,0,4,1782,0,0,3,2,0,1,0,1,4,0,0,1,4,0,0,2,9,0,0,
1162,0,0,26,165,0,4,1791,0,0,3,2,0,1,0,1,4,0,0,1,4,0,0,2,9,0,0,
1189,0,0,27,145,0,3,1808,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1232,0,0,28,145,0,3,1863,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1275,0,0,29,53,0,5,1896,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1298,0,0,30,60,0,2,1910,0,0,1,1,0,1,0,1,9,0,0,
1317,0,0,31,0,0,29,1917,0,0,0,0,0,1,0,
1332,0,0,32,0,0,27,1928,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
1363,0,0,33,118,0,4,1944,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
1394,0,0,34,62,0,6,1957,0,0,1,1,0,1,0,2,9,0,0,
1413,0,0,35,44,0,4,1964,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
1436,0,0,36,44,0,4,1968,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
1459,0,0,37,115,0,4,1988,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
1486,0,0,38,140,0,4,1999,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 2.0                                                    */
/************************************************************************/
/* PROGRAM NAME          : ARBPYPST.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 09-FEB-1993                                   */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_PAY_HDR               Query/Update              */
/*         2.        AR_PAY_LINE                 Query                  */
/*         3.        SY_ACC_ENTITY_DOC_TYPE      Lookup                 */
/*         4.        SY_ACC_ENTITY               Lookup                 */
/*         5.        AR_CUSTOMER                 Lookup                 */
/*         6.        AR_PMNT_TERMS               Lookup                 */
/*         7.        BL_BLNG_GRP                 Lookup                 */
/*         8.        MP_PATIENT_MAST             Lookup                 */
/*         9.        AR_PARAMETER                Lookup                 */
/*        10.        GL_ACC_CHART                Lookup                 */
/*        11.        SY_DEPT                     Lookup                 */
/*        12.        GL_PRODUCT_LINE             Lookup                 */
/*        13.        GL_SUBLEDGER_LINE           Lookup                 */
/*        14.        GL_ACC_COMBINATION          Lookup                 */
/*        15.        AR_DOC_ERROR           Query/Insert/Delete         */
/*        16.        SY_DOC_CONTROL            Insert/Lookup            */
/*        17.        SY_PROG_CONTROL           Update/Lookup            */
/*        19.        SY_PROG_MESG                Insert                 */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*         2.        POST                validate_posting_acct          */
/*         3.        POST_DOC            post_doc (GL posting acc val)  */
/*         4.        PY_POST             ar_pay_posting                 */
/*                                              (AR Payments posting)   */
/*                                                                      */
/************************************************************************/
      
#include <stdio.h>
#include <string.h>
#include <math.h>
#include "gl.h"
/*
#define OERROR (sqlca.sqlcode < 0)
*/
#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

#define RESOURCE_BUSY        (sqlca.sqlcode == -54)

/* extern char OUTPUT_FILE_NAME[75]; */

#define VIEW_LOG_FILE 1   

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;


    int process_rep_flg, nd_no_of_decimal;

   /* VARCHAR  nd_session_id    [16],
            nd_pgm_date      [25],
            nd_fm_doc_type   [7],
            nd_to_doc_type   [7],
            nd_fm_doc_num    [10],
            nd_to_doc_num    [10],
            nd_fm_doc_date   [12],
            nd_to_doc_date   [12],
            nd_proc_flag     [2],
            nd_view_print_flg[2],
			nd_hosp_name     [100], /o added by madhu for gdoh-crf-0107.1 o/

            pmnt_terms_code  [3],
            billing_group    [5],  -- CRF-0120
            patient_id       [21],
            patient_flag     [2],
            bl_instal_flag   [2],
            mp_instal_flag   [2],
            nd_error_flag    [2],
            mast_status      [3],
            d_curr_pgm_name                      [15],
            dummy            [10][5],

            d_last_pay_doc_date           [12],

			nd_acc_entity_code            [5],
			d_module_valid_id             [3],
		    p_operational_modules         [300],
            d_consolidated_yn[2],
            nd_facility_id[4],
            d_sy_acc_bl_instal_flag       [4],
            d_sy_acc_mp_instal_flag       [4],
            d_ar_acc_status               [2],
            d_ar_acc_valid_flag           [2],
            d_customer_status             [2],
            d_customer_patient_flag       [2],
            d_pmnt_terms_status           [2],
            d_bl_blng_grp_status          [2],

            sy_doc_print_flag             [3],
            curr_acc_year                 [5],
            curr_acc_month                [3],
            gl_summ_pro_flag              [2],
            d_sy_num_acc_per              [5],
            prior_post_allow              [3],
            d_chk_amt_local               [19]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[2]; } nd_proc_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_view_print_flg;

struct { unsigned short len; unsigned char arr[100]; } nd_hosp_name;

struct { unsigned short len; unsigned char arr[3]; } pmnt_terms_code;

struct { unsigned short len; unsigned char arr[5]; } billing_group;

struct { unsigned short len; unsigned char arr[21]; } patient_id;

struct { unsigned short len; unsigned char arr[2]; } patient_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } mp_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_error_flag;

struct { unsigned short len; unsigned char arr[3]; } mast_status;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[6]; } dummy[10];

struct { unsigned short len; unsigned char arr[12]; } d_last_pay_doc_date;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[3]; } d_module_valid_id;

struct { unsigned short len; unsigned char arr[300]; } p_operational_modules;

struct { unsigned short len; unsigned char arr[2]; } d_consolidated_yn;

struct { unsigned short len; unsigned char arr[4]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[4]; } d_sy_acc_bl_instal_flag;

struct { unsigned short len; unsigned char arr[4]; } d_sy_acc_mp_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } d_ar_acc_status;

struct { unsigned short len; unsigned char arr[2]; } d_ar_acc_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } d_customer_status;

struct { unsigned short len; unsigned char arr[2]; } d_customer_patient_flag;

struct { unsigned short len; unsigned char arr[2]; } d_pmnt_terms_status;

struct { unsigned short len; unsigned char arr[2]; } d_bl_blng_grp_status;

struct { unsigned short len; unsigned char arr[3]; } sy_doc_print_flag;

struct { unsigned short len; unsigned char arr[5]; } curr_acc_year;

struct { unsigned short len; unsigned char arr[3]; } curr_acc_month;

struct { unsigned short len; unsigned char arr[2]; } gl_summ_pro_flag;

struct { unsigned short len; unsigned char arr[5]; } d_sy_num_acc_per;

struct { unsigned short len; unsigned char arr[3]; } prior_post_allow;

struct { unsigned short len; unsigned char arr[19]; } d_chk_amt_local;


   /* VARCHAR  ar_interface_code[2],
            ar_cheque_entry_yn[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } ar_interface_code;

struct { unsigned short len; unsigned char arr[2]; } ar_cheque_entry_yn;
 

   /* VARCHAR  p_language_id[4]; */ 
struct { unsigned short len; unsigned char arr[4]; } p_language_id;

   /* VARCHAR  ar_pat_doc_type_code          [7],
           ar_pat_doc_num                [9],
           ar_pat_patient_id             [21],
           ar_pat_bill_doc_type_code     [7],
           ar_pat_bill_num               [9],
           ar_pat_inv_doc_type_code          [7],
           ar_pat_inv_doc_num                [9],
           ar_pat_bill_date              [12],
           ar_pat_rowid                  [31]; */ 
struct { unsigned short len; unsigned char arr[7]; } ar_pat_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_doc_num;

struct { unsigned short len; unsigned char arr[21]; } ar_pat_patient_id;

struct { unsigned short len; unsigned char arr[7]; } ar_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_bill_num;

struct { unsigned short len; unsigned char arr[7]; } ar_pat_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_inv_doc_num;

struct { unsigned short len; unsigned char arr[12]; } ar_pat_bill_date;

struct { unsigned short len; unsigned char arr[31]; } ar_pat_rowid;



 /* VARCHAR    d_py_hdr_acc_entity_code               [5],
            d_py_hdr_doc_type_code                 [7],
            d_py_hdr_doc_num                       [9],
            d_py_hdr_last_line_num                 [5],
            d_py_hdr_doc_date                      [15],
            d_py_hdr_doc_ref                       [11],
            d_py_hdr_cust_code                     [9],
            d_py_hdr_main_acc1_code                [7],
            d_py_hdr_main_acc2_code                [5],
            d_py_hdr_sub_group_code          [4],
            d_py_hdr_sub_line_code           [9],
            d_py_hdr_dept_code                     [11],
            d_py_hdr_product_group_code            [4],
            d_py_hdr_product_line_code             [5],
            d_py_hdr_amt_foreign                   [17],
            d_py_hdr_amt_local                     [17],
            d_py_hdr_narration                     [51],
            d_py_hdr_post_month                    [3],
            d_py_hdr_post_year                     [5],
            d_py_hdr_currency_code                 [7],
            d_py_hdr_exchg_rate                    [15],
            d_py_hdr_bank_desc                     [31],
            d_py_hdr_cheque_num                    [11],
            d_py_hdr_cheque_date                   [15],
            d_py_hdr_misc_clong_name           [101],  -- CRF-0120
            d_py_hdr_misc_cshort_name          [61],  -- CRF-0120
            d_py_hdr_misc_cadd1_desc           [61],
            d_py_hdr_misc_cadd2_desc           [61],
            d_py_hdr_misc_cadd3_desc           [61],
            d_py_hdr_misc_czip_desc            [61],
            d_py_hdr_misc_long_name_ch             [101],  -- CRF-0120
            d_py_hdr_misc_short_name_ch            [101],  -- CRF-0120
            d_py_hdr_misc_add1_desc_ch             [61],
            d_py_hdr_misc_add2_desc_ch             [61],
            d_py_hdr_misc_add3_desc_ch             [61],
            d_py_hdr_misc_zip_desc_ch              [61],
            d_py_hdr_tel_num                       [31],
            d_py_hdr_contact_name                  [101],  -- CRF-0120
            d_py_hdr_contact_name_title            [61],  -- CRF-0120
            d_py_hdr_error_flag                    [2],
            d_py_hdr_print_flag                    [2],
            d_py_hdr_posted_flag                   [2],
            d_py_hdr_interface_flag                [2],
            d_py_hdr_posted_date                   [15],
            d_py_hdr_posted_by_id                  [21],
            d_py_hdr_rowid                         [31],

            d_py_hdr_doc_date_chking               [15],

            d_line_main_acc1_code                  [7],
            d_line_main_acc2_code                  [5],
            d_line_dept_code                       [11],
            d_line_product_group_code              [4],
            d_line_product_line_code               [5],
            d_line_sub_group_code            [4],
            d_line_sub_line_code             [9],
            d_line_amt_local                       [17],
            d_line_line_num                        [5],
            d_line_org_doc_type_code               [7],
            d_line_org_doc_num                     [9],
            d_line_line_type_code                  [2]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_py_hdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[7]; } d_py_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_py_hdr_doc_num;

struct { unsigned short len; unsigned char arr[5]; } d_py_hdr_last_line_num;

struct { unsigned short len; unsigned char arr[15]; } d_py_hdr_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_py_hdr_doc_ref;

struct { unsigned short len; unsigned char arr[9]; } d_py_hdr_cust_code;

struct { unsigned short len; unsigned char arr[7]; } d_py_hdr_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_py_hdr_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } d_py_hdr_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_py_hdr_sub_line_code;

struct { unsigned short len; unsigned char arr[11]; } d_py_hdr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_py_hdr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_py_hdr_product_line_code;

struct { unsigned short len; unsigned char arr[17]; } d_py_hdr_amt_foreign;

struct { unsigned short len; unsigned char arr[17]; } d_py_hdr_amt_local;

struct { unsigned short len; unsigned char arr[51]; } d_py_hdr_narration;

struct { unsigned short len; unsigned char arr[3]; } d_py_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_py_hdr_post_year;

struct { unsigned short len; unsigned char arr[7]; } d_py_hdr_currency_code;

struct { unsigned short len; unsigned char arr[15]; } d_py_hdr_exchg_rate;

struct { unsigned short len; unsigned char arr[31]; } d_py_hdr_bank_desc;

struct { unsigned short len; unsigned char arr[11]; } d_py_hdr_cheque_num;

struct { unsigned short len; unsigned char arr[15]; } d_py_hdr_cheque_date;

struct { unsigned short len; unsigned char arr[101]; } d_py_hdr_misc_clong_name;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_cshort_name;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_cadd1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_cadd2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_cadd3_desc;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_czip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_py_hdr_misc_long_name_ch;

struct { unsigned short len; unsigned char arr[101]; } d_py_hdr_misc_short_name_ch;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_add1_desc_ch;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_add2_desc_ch;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_add3_desc_ch;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_misc_zip_desc_ch;

struct { unsigned short len; unsigned char arr[31]; } d_py_hdr_tel_num;

struct { unsigned short len; unsigned char arr[101]; } d_py_hdr_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_py_hdr_contact_name_title;

struct { unsigned short len; unsigned char arr[2]; } d_py_hdr_error_flag;

struct { unsigned short len; unsigned char arr[2]; } d_py_hdr_print_flag;

struct { unsigned short len; unsigned char arr[2]; } d_py_hdr_posted_flag;

struct { unsigned short len; unsigned char arr[2]; } d_py_hdr_interface_flag;

struct { unsigned short len; unsigned char arr[15]; } d_py_hdr_posted_date;

struct { unsigned short len; unsigned char arr[21]; } d_py_hdr_posted_by_id;

struct { unsigned short len; unsigned char arr[31]; } d_py_hdr_rowid;

struct { unsigned short len; unsigned char arr[15]; } d_py_hdr_doc_date_chking;

struct { unsigned short len; unsigned char arr[7]; } d_line_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_line_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } d_line_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_line_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_line_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_line_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_line_sub_line_code;

struct { unsigned short len; unsigned char arr[17]; } d_line_amt_local;

struct { unsigned short len; unsigned char arr[5]; } d_line_line_num;

struct { unsigned short len; unsigned char arr[7]; } d_line_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_line_org_doc_num;

struct { unsigned short len; unsigned char arr[2]; } d_line_line_type_code;


   double   nd_dtl_tot_amt,
            ar_pend_pending_amt,
			 ar_pat_tot_amt,
			ar_pat_abs_tot_amount ,
			ar_pat_amount,
			ar_pat_abs_amount,
			pending_amt;

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




#include "winproc.h"
                         
char string_var[100];                         
int g_err_typ;

char g_err_id[10],
     g_err_msg[80];


/* These variables ar used for calling post_doc (Posting acc validation) */

int  d_curr_year;
int  d_curr_month;
int  d_num_of_acc_periods;
char d_summ_flag;

/*                                                                         */

void proc_main(argc,argv)
char *argv[];
int argc;
{

   if (argc < 6)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
      proc_exit();
   }

   if (argv[5][0] == 'R')
      {strcpy(g_pgm_id,"ARRPYLST"); 
       strcpy(OUTPUT_FILE_NAME,"ARRPYLST.LIS"); 
      } 
       
   else
     { strcpy(g_pgm_id,"ARBPYPST");      
      strcpy(OUTPUT_FILE_NAME,"ARBPYPST.LIS"); 
     }
   strcpy(d_curr_pgm_name.arr,g_pgm_id); 
   d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr);

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle\n");
      proc_exit();
   }
                  
#ifdef DEBUG
  disp_message(INFO_MESG,"After connecting to oracle...\n");
#endif
   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);
   strcpy(g_facility_id,argv[4]);
	 set_meduser_role();

   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;
   chk_active();

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   nd_proc_flag.arr[0]      = '\0';
   nd_view_print_flg.arr[0] = '\0';
   nd_facility_id.arr[0] = '\0';
   nd_hosp_name.arr[0]='\0'; /* added by madhu for gdoh-crf-0107.1 */

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   nd_proc_flag.len         = 0;
   nd_view_print_flg.len    = 0;
   nd_facility_id.len = 0;
   process_rep_flg          = 0;
   nd_hosp_name.len = 0; /* added by madhu for gdoh-crf-0107.1 */

   /* EXEC SQL SELECT OPERATING_FACILITY_ID  , PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,
                   PARAM8,PARAM9,to_number(PARAM10)
              INTO :nd_facility_id, :nd_fm_doc_type, :nd_fm_doc_num, :nd_fm_doc_date,
                   :nd_to_doc_type, :nd_to_doc_num, :nd_to_doc_date,
				   :nd_proc_flag,
                   :nd_view_print_flg, :process_rep_flg
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBPYPST'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM8 ,PARAM9 ,to_number(PARAM10) into :b0,:b1,:b2,:b3,:b\
4,:b5,:b6,:b7,:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='ARBPYPST' and SESSIO\
N_ID=:b10) and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_type;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[6] = (unsigned int  )14;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_proc_flag;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_view_print_flg;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&process_rep_flg;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
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
	
	/* EXEC SQL SELECT 'Facility Name : '||ACC_ENTITY_NAME 
			  INTO :nd_hosp_name
              FROM SY_ACC_ENTITY 
              WHERE ACC_ENTITY_ID=:nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ('Facility Name : '||ACC_ENTITY_NAME) into :b0  from \
SY_ACC_ENTITY where ACC_ENTITY_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )68;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_hosp_name;
 sqlstm.sqhstl[0] = (unsigned int  )102;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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
        err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_ACC_ENTITY",0,"");

   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';
   nd_proc_flag.arr[nd_proc_flag.len]        = '\0';
   nd_view_print_flg.arr[nd_view_print_flg.len]        = '\0';
   nd_facility_id.arr[nd_facility_id.len]= '\0';
   nd_hosp_name.arr[nd_hosp_name.len]        = '\0';  /* added by madhu for gdoh-crf-0107.1 */

#ifdef DEBUG
   sprintf(string_var,"fr type is <%d> - <%s>\n",nd_fm_doc_type.len ,nd_fm_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to type is <%d> - <%s>\n",nd_to_doc_type.len ,nd_to_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fr num  is <%d> - <%s>\n",nd_fm_doc_num.len ,nd_fm_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to num  is <%d> - <%s>\n",nd_to_doc_num.len ,nd_to_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fr dt   is <%d> - <%s>\n",nd_fm_doc_date.len ,nd_fm_doc_date.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to dt   is <%d> - <%s>\n",nd_to_doc_date.len ,nd_to_doc_date.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"prc flg is <%d> - <%s>\n",nd_proc_flag.len ,nd_proc_flag.arr);
   disp_message(INFO_MESG,string_var);
#endif

   start_prog_control();
   start_prog_msg();
   
   delete_records();

   fetch_acc_entity_flag();

   fetch_ar_parameter();
  
   declare_cursor();

   
   disp_message(INFO_MESG,nd_hosp_name.arr); /* added by madhu for gdoh-crf-0107.1 */
   disp_message(INFO_MESG,"\n"); /* added by madhu for gdoh-crf-0107.1 */
   
   while (fetch_cur())    /* Fetches Hdr recs rowid */
   {
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside while...\n"); 
#endif

      strcpy(nd_error_flag.arr,"N");
      nd_error_flag.len = 1;

      nd_dtl_tot_amt    = 0;

      if (!fetch_rec())    /* Fetch all the details & lock Hdr row */
          continue;

      validate_pay_header();

      if (!validate_pay_line())
             continue;

      validate_pay_amt();

      update_err_flg();
      
      if (nd_proc_flag.arr[0] == 'P') 
      {
#ifdef DEBUG
    disp_message(INFO_MESG,"Processing option\n");
#endif
          if (nd_error_flag.arr[0] == 'N')
          {
#ifdef DEBUG
    disp_message(INFO_MESG,"Online GL interface\n");
		
		sprintf(string_var," doc_date_chking is <%s> last rec doc <%s>\n",
            d_py_hdr_doc_date_chking.arr,
            d_last_pay_doc_date.arr);
            disp_message(INFO_MESG,string_var);


		sprintf(string_var," doc_date_chking is <%ld> last pay doc <%ld>\n",
            atol(d_py_hdr_doc_date_chking.arr),
            atol(d_last_pay_doc_date.arr));
            disp_message(INFO_MESG,string_var);

#endif
                 ar_pay_posting(
            d_py_hdr_acc_entity_code.arr,
            d_py_hdr_doc_type_code.arr,
            d_py_hdr_doc_num.arr,
            d_py_hdr_last_line_num.arr,
            d_py_hdr_doc_date.arr,
            d_py_hdr_doc_ref.arr,
            d_py_hdr_cust_code.arr,
            d_py_hdr_main_acc1_code.arr,
            d_py_hdr_main_acc2_code.arr,
            d_py_hdr_sub_group_code.arr,
            d_py_hdr_sub_line_code.arr,
            d_py_hdr_dept_code.arr,
            d_py_hdr_product_group_code.arr,
            d_py_hdr_product_line_code.arr,
            d_py_hdr_amt_local.arr,
            d_py_hdr_narration.arr,
            d_py_hdr_post_month.arr,
            d_py_hdr_post_year.arr,
            d_py_hdr_currency_code.arr,
            d_py_hdr_exchg_rate.arr,
            d_py_hdr_misc_clong_name.arr,
            d_py_hdr_misc_cshort_name.arr,
            d_py_hdr_misc_cadd1_desc.arr,
            d_py_hdr_misc_cadd2_desc.arr,
            d_py_hdr_misc_cadd3_desc.arr,
            d_py_hdr_misc_czip_desc.arr,
            d_py_hdr_misc_long_name_ch.arr,
            d_py_hdr_misc_short_name_ch.arr,
            d_py_hdr_misc_add1_desc_ch.arr,
            d_py_hdr_misc_add2_desc_ch.arr,
            d_py_hdr_misc_add3_desc_ch.arr,
            d_py_hdr_misc_zip_desc_ch.arr,
            d_py_hdr_tel_num.arr,
            d_py_hdr_contact_name.arr,
            d_py_hdr_contact_name_title.arr,
            d_py_hdr_rowid.arr,
            ar_interface_code.arr,
            d_py_hdr_doc_date_chking.arr,
            d_last_pay_doc_date.arr,
            d_py_hdr_cheque_num.arr,
            d_py_hdr_cheque_date.arr,
			d_py_hdr_bank_desc.arr,
			nd_facility_id.arr);

             if (ar_interface_code.arr[0] == 'O')
             {
                  gl_posting();      

				  ins_gl_distrbn(d_py_hdr_doc_type_code.arr,d_py_hdr_doc_num.arr,6,nd_facility_id.arr);


/*    Commented on 15-MAR-93 as per request by GL team 

      if (!  (atoi(d_py_hdr_post_year.arr) > atoi(curr_acc_year.arr)) ||
            ( atoi(d_py_hdr_post_year.arr) == atoi(curr_acc_year.arr) && 
              atoi(d_py_hdr_post_month.arr) > atoi(curr_acc_month.arr) )  )
                     delete_gl_recs();
*/
              }
          } 
       }
       /* EXEC SQL COMMIT WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 12;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )91;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



       if (OERROR)
         err_mesg("COMMIT failed",0,""); 
   }

if (process_rep_flg == 3)
{
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )106;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
        err_mesg("COMMIT failed",0,""); 

   /* run_report(); */

   if(sql_connect() == -1) 
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle 2 time\n");
      proc_exit();
   }
}

/*   delete_records();*/
   end_prog_msg();
   end_prog_control();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )121;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   return;

}

declare_cursor()
{

#ifdef DEBUG
   disp_message(INFO_MESG,"Before Declaring cursor CUR_PAY_HDR...\n");
#endif


/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY VSK 15/11/1999 */

   /* EXEC SQL DECLARE CUR_PAY_HDR CURSOR FOR
             SELECT DOC_TYPE_CODE, DOC_NUM
               FROM AR_PAY_HDR
              WHERE OPERATING_FACILITY_ID=:nd_facility_id  /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
                AND DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE) <= 
                    NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
                AND NVL(POSTED_FLAG,'N') = 'N'; */ 


   /* EXEC SQL OPEN CUR_PAY_HDR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )136;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
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
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[4] = (unsigned int  )12;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[5] = (unsigned int  )14;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[6] = (unsigned int  )14;
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
         err_mesg("OPEN failed on cursor CUR_PAY_HDR",0,"");

 /* EXEC SQL DECLARE AR_PAY_HDR_CUR CURSOR FOR
           SELECT ACC_ENTITY_CODE,
                  LAST_LINE_NUM,
                  TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                  TO_CHAR(DOC_DATE,'YYYYDDMM'),
                  DOC_REF,
                  CUST_CODE,
                  MAIN_ACC1_CODE,
                  MAIN_ACC2_CODE,
                  SUBLEDGER_GROUP_CODE,
                  SUBLEDGER_LINE_CODE,
                  DEPT_CODE,
                  PRODUCT_GROUP_CODE,
                  PRODUCT_LINE_CODE,
                  AMT_FOREIGN,
                  AMT_LOCAL,
                  NARRATION,
                  POST_MONTH,
                  POST_YEAR,
                  CURRENCY_CODE,
                  EXCHG_RATE,
                  BANK_DESC,
                  CHEQUE_NUM,
                  CHEQUE_DATE,
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
                  PRINT_FLAG,
                  ROWID
             FROM AR_PAY_HDR
            WHERE OPERATING_FACILITY_ID=:nd_facility_id  /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
              AND DOC_TYPE_CODE = :d_py_hdr_doc_type_code
              AND DOC_NUM       = :d_py_hdr_doc_num
              FOR UPDATE OF ERROR_FLAG NOWAIT; */ 


   /* EXEC SQL DECLARE CUR_PAY_LINE CURSOR FOR
             SELECT AMT_LOCAL,
                    LINE_NUM,
                    MAIN_ACC1_CODE,
                    MAIN_ACC2_CODE,
                    DEPT_CODE,
                    PRODUCT_GROUP_CODE,
                    PRODUCT_LINE_CODE,
                    SUBLEDGER_GROUP_CODE,
                    SUBLEDGER_LINE_CODE,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    LINE_TYPE_CODE,
					CONSOLIDATED_INV_YN
               FROM AR_PAY_LINE
              WHERE OPERATING_FACILITY_ID=:nd_facility_id  /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
                AND DOC_TYPE_CODE = :d_py_hdr_doc_type_code
                AND DOC_NUM       = :d_py_hdr_doc_num
                FOR UPDATE OF LINE_NUM NOWAIT; */ 


   /* EXEC SQL DECLARE AR_TRN_DOC_TYPE_CUR CURSOR FOR
             SELECT 'X'
               FROM AR_TRN_DOC_TYPE
              WHERE OPERATING_FACILITY_ID=:nd_facility_id  /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
                AND DOC_TYPE_CODE = :d_py_hdr_doc_type_code
                AND TRN_TYPE_CODE = '6'; */ 


 /* EXEC SQL DECLARE SY_DOC_CONTROL_CUR CURSOR FOR
             SELECT 'X'
               FROM SY_DOC_CONTROL
              WHERE DOC_TYPE_CODE = :d_py_hdr_doc_type_code
                AND DOC_NUM       = :d_py_hdr_doc_num; */ 



   /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
             SELECT NVL(STATUS,'X'),
                    PATIENT_FLAG,
                    NVL(TO_CHAR(LAST_REC_DOC_DATE,'DD/MM/YYYY'),0)
               FROM AR_CUSTOMER
              WHERE CUST_CODE        = :d_py_hdr_cust_code; */ 


   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
             SELECT NVL(STATUS,'X'),
                    NVL(AR_VALID_FLAG,'X'),
                    NVL(DOC_PRINT_FLAG,'X')
               FROM GL_ACC_ENTITY_DOC_TYPE_VW
              WHERE DOC_TYPE_CODE   = :d_py_hdr_doc_type_code; */ 


    /* EXEC SQL DECLARE SY_DOC_TYPE_MAST_CUR CURSOR FOR
              SELECT NVL(STATUS,'X')
                FROM SY_DOC_TYPE_MASTER
               WHERE DOC_TYPE_CODE = :d_py_hdr_doc_type_code; */ 

  
    /* EXEC SQL DECLARE AR_PENDING_CUR CURSOR FOR
              SELECT NVL(PENDING_AMT,0)
                FROM AR_PENDING_DOC
               WHERE OPERATING_FACILITY_ID=:nd_facility_id  /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
                 AND CUST_CODE     = :d_py_hdr_cust_code
                 AND DOC_TYPE_CODE = :d_line_org_doc_type_code
                 AND DOC_NUM       = :d_line_org_doc_num; */ 



	/* EXEC SQL DECLARE AR_PATIENT_DTLS_CUR CURSOR FOR
              SELECT DOC_TYPE_CODE,
                     DOC_NUM,
                     PATIENT_ID,
					 INV_DOC_TYPE_CODE,
					 INV_DOC_NUM       ,     
                     BILL_DOC_TYPE_CODE,
                     BILL_NUM,
                     TO_CHAR(BILL_DATE,'YYYYMMDD'),
                     NVL(AMOUNT,0),
					  ABS(nvl(AMOUNT,0)),
                     ROWID
                FROM AR_PATIENT_ALLOC_DTLS
               WHERE OPERATING_FACILITY_ID=:nd_facility_id  /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
                AND DOC_TYPE_CODE = :d_py_hdr_doc_type_code
                AND DOC_NUM       = :d_py_hdr_doc_num
               ORDER BY DOC_TYPE_CODE , DOC_NUM; */ 


#ifdef DEBUG
   disp_message(INFO_MESG,"After Declaring  & opening cursor CUR_PAY_HDR...\n");
#endif
}

/******************************************************************/


fetch_patient_dtls()
{
ar_pat_doc_type_code.arr[0]       = '\0';
ar_pat_doc_num.arr[0]             = '\0';
ar_pat_patient_id.arr[0]          = '\0';
ar_pat_bill_doc_type_code.arr[0]  = '\0';
ar_pat_bill_num.arr[0]            = '\0';
ar_pat_bill_date.arr[0]           = '\0';
ar_pat_inv_doc_type_code.arr[0] = '\0';
ar_pat_inv_doc_num.arr[0] = '\0';
ar_pat_rowid.arr[0]               = '\0';

ar_pat_doc_type_code.len          = 0;
ar_pat_doc_num.len                = 0;
ar_pat_patient_id.len             = 0;
ar_pat_bill_doc_type_code.len     = 0;
ar_pat_bill_num.len               = 0;
ar_pat_bill_date.len              = 0;
ar_pat_inv_doc_type_code.len = 0;
ar_pat_inv_doc_num.len = 0;

ar_pat_rowid.len                  = 0;

ar_pat_amount                     = 0;
ar_pat_abs_amount  =0;

   /* EXEC SQL FETCH AR_PATIENT_DTLS_CUR
             INTO :ar_pat_doc_type_code,
                  :ar_pat_doc_num,
                  :ar_pat_patient_id,
				  :ar_pat_inv_doc_type_code,
                  :ar_pat_inv_doc_num,
                  :ar_pat_bill_doc_type_code,
                  :ar_pat_bill_num,
                  :ar_pat_bill_date,
                  :ar_pat_amount,
                  :ar_pat_abs_amount,
                  :ar_pat_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )179;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_pat_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_pat_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_pat_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_pat_inv_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_pat_inv_doc_num;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ar_pat_bill_num;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ar_pat_bill_date;
   sqlstm.sqhstl[7] = (unsigned int  )14;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&ar_pat_amount;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&ar_pat_abs_amount;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&ar_pat_rowid;
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
       err_mesg("FETCH failed on cursor AR_PATIENT_DTLS_CUR",0,"");


ar_pat_doc_type_code.arr[ar_pat_doc_type_code.len]           = '\0';
ar_pat_doc_num.arr[ar_pat_doc_num.len]                       = '\0';
ar_pat_patient_id.arr[ar_pat_patient_id.len]                 = '\0';
ar_pat_bill_doc_type_code.arr[ar_pat_bill_doc_type_code.len] = '\0';
ar_pat_bill_num.arr[ar_pat_bill_num.len]                     = '\0';
ar_pat_bill_date.arr[ar_pat_bill_date.len]                   = '\0';
ar_pat_rowid.arr[ar_pat_rowid.len]                           = '\0';
ar_pat_inv_doc_type_code.arr[ar_pat_inv_doc_type_code.len] = '\0';
ar_pat_inv_doc_num.arr[ar_pat_inv_doc_num.len]= '\0';

ar_pat_tot_amt += ar_pat_amount;
ar_pat_abs_tot_amount  += ar_pat_abs_amount;



   if (LAST_ROW)
       return (0);
   else 
       return (1);
}

/*********************************************************************/



fetch_cur()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Fetch rec...\n");
#endif

   d_py_hdr_doc_type_code.arr[0]     = '\0';
   d_py_hdr_doc_num.arr[0]           = '\0';

   d_py_hdr_doc_type_code.len        = 0;
   d_py_hdr_doc_num.len              = 0;


   /* EXEC SQL FETCH CUR_PAY_HDR 
             INTO :d_py_hdr_doc_type_code, :d_py_hdr_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )238;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_num;
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
         err_mesg("FETCH failed on cursor CUR_PAY_HDR",0,"");

   d_py_hdr_doc_type_code.arr[d_py_hdr_doc_type_code.len]     = '\0';
   d_py_hdr_doc_num.arr[d_py_hdr_doc_num.len]                 = '\0';

#ifdef DEBUG
    sprintf(string_var," Doc type is <%s> Doc num is <%s>\n",d_py_hdr_doc_type_code.arr,
                  d_py_hdr_doc_num.arr);
                  disp_message(INFO_MESG,string_var);
#endif

   if (LAST_ROW)
       return(0);
   else
       return(1);
}

fetch_rec()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Fetch rec...\n");
#endif

d_py_hdr_acc_entity_code.arr[0]           = '\0';
d_py_hdr_last_line_num.arr[0]             = '\0';
d_py_hdr_doc_date.arr[0]                  = '\0';
d_py_hdr_doc_ref.arr[0]                   = '\0';
d_py_hdr_cust_code.arr[0]                 = '\0';
d_py_hdr_main_acc1_code.arr[0]            = '\0';
d_py_hdr_main_acc2_code.arr[0]            = '\0';
d_py_hdr_sub_group_code.arr[0]      = '\0';
d_py_hdr_sub_line_code.arr[0]       = '\0';
d_py_hdr_dept_code.arr[0]                 = '\0';
d_py_hdr_product_group_code.arr[0]        = '\0';
d_py_hdr_product_line_code.arr[0]         = '\0';
d_py_hdr_amt_foreign.arr[0]               = '\0';
d_py_hdr_amt_local.arr[0]                 = '\0';
d_py_hdr_narration.arr[0]                 = '\0';
d_py_hdr_post_month.arr[0]                = '\0';
d_py_hdr_post_year.arr[0]                 = '\0';
d_py_hdr_currency_code.arr[0]             = '\0';
d_py_hdr_exchg_rate.arr[0]                = '\0';
d_py_hdr_bank_desc.arr[0]                 = '\0';
d_py_hdr_cheque_num.arr[0]                = '\0';
d_py_hdr_cheque_date.arr[0]               = '\0';
d_py_hdr_misc_clong_name.arr[0]       = '\0';
d_py_hdr_misc_cshort_name.arr[0]      = '\0';
d_py_hdr_misc_cadd1_desc.arr[0]       = '\0';
d_py_hdr_misc_cadd2_desc.arr[0]       = '\0';
d_py_hdr_misc_cadd3_desc.arr[0]       = '\0';
d_py_hdr_misc_czip_desc.arr[0]        = '\0';
d_py_hdr_misc_long_name_ch.arr[0]         = '\0';
d_py_hdr_misc_short_name_ch.arr[0]        = '\0';
d_py_hdr_misc_add1_desc_ch.arr[0]         = '\0';
d_py_hdr_misc_add2_desc_ch.arr[0]         = '\0';
d_py_hdr_misc_add3_desc_ch.arr[0]         = '\0';
d_py_hdr_misc_zip_desc_ch.arr[0]          = '\0';
d_py_hdr_tel_num.arr[0]                   = '\0';
d_py_hdr_contact_name.arr[0]              = '\0';
d_py_hdr_contact_name_title.arr[0]        = '\0';
d_py_hdr_print_flag.arr[0]                = '\0';
d_py_hdr_rowid.arr[0]                     = '\0';

d_py_hdr_doc_date_chking.arr[0]           = '\0';

d_py_hdr_acc_entity_code.len               = 0;
d_py_hdr_last_line_num.len                 = 0;
d_py_hdr_doc_date.len                      = 0;
d_py_hdr_doc_ref.len                       = 0;
d_py_hdr_cust_code.len                     = 0;
d_py_hdr_main_acc1_code.len                = 0;
d_py_hdr_main_acc2_code.len                = 0;
d_py_hdr_sub_group_code.len          = 0;
d_py_hdr_sub_line_code.len           = 0;
d_py_hdr_dept_code.len                     = 0;
d_py_hdr_product_group_code.len            = 0;
d_py_hdr_product_line_code.len             = 0;
d_py_hdr_amt_foreign.len                   = 0;
d_py_hdr_amt_local.len                     = 0;
d_py_hdr_narration.len                     = 0;
d_py_hdr_post_month.len                    = 0;
d_py_hdr_post_year.len                     = 0;
d_py_hdr_currency_code.len                 = 0;
d_py_hdr_exchg_rate.len                    = 0;
d_py_hdr_bank_desc.len                     = 0;
d_py_hdr_cheque_num.len                    = 0;
d_py_hdr_cheque_date.len                   = 0;
d_py_hdr_misc_clong_name.len           = 0;
d_py_hdr_misc_cshort_name.len          = 0;
d_py_hdr_misc_cadd1_desc.len           = 0;
d_py_hdr_misc_cadd2_desc.len           = 0;
d_py_hdr_misc_cadd3_desc.len           = 0;
d_py_hdr_misc_czip_desc.len            = 0;
d_py_hdr_misc_long_name_ch.len             = 0;
d_py_hdr_misc_short_name_ch.len            = 0;
d_py_hdr_misc_add1_desc_ch.len             = 0;
d_py_hdr_misc_add2_desc_ch.len             = 0;
d_py_hdr_misc_add3_desc_ch.len             = 0;
d_py_hdr_misc_zip_desc_ch.len              = 0;
d_py_hdr_tel_num.len                       = 0;
d_py_hdr_contact_name.len                  = 0;
d_py_hdr_contact_name_title.len            = 0;
d_py_hdr_print_flag.len                    = 0;
d_py_hdr_rowid.len                         = 0;

d_py_hdr_doc_date_chking.len               = 0;

   /* EXEC SQL OPEN AR_PAY_HDR_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )261;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_doc_num;
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



   if (RESOURCE_BUSY)
        return (0);
   else if (OERROR)
         err_mesg("OPEN failed on cursor AR_PAY_HDR_CUR",0,"");

   /* EXEC SQL FETCH AR_PAY_HDR_CUR 
             INTO :d_py_hdr_acc_entity_code,
                  :d_py_hdr_last_line_num,
                  :d_py_hdr_doc_date,
                  :d_py_hdr_doc_date_chking,
                  :d_py_hdr_doc_ref,
                  :d_py_hdr_cust_code,
                  :d_py_hdr_main_acc1_code,
                  :d_py_hdr_main_acc2_code,
                  :d_py_hdr_sub_group_code,
                  :d_py_hdr_sub_line_code,
                  :d_py_hdr_dept_code,
                  :d_py_hdr_product_group_code,
                  :d_py_hdr_product_line_code,
                  :d_py_hdr_amt_foreign,
                  :d_py_hdr_amt_local,
                  :d_py_hdr_narration,
                  :d_py_hdr_post_month,
                  :d_py_hdr_post_year,
                  :d_py_hdr_currency_code,
                  :d_py_hdr_exchg_rate,
                  :d_py_hdr_bank_desc,
                  :d_py_hdr_cheque_num,
                  :d_py_hdr_cheque_date,
                  :d_py_hdr_misc_clong_name,
                  :d_py_hdr_misc_cshort_name,
                  :d_py_hdr_misc_cadd1_desc,
                  :d_py_hdr_misc_cadd2_desc,
                  :d_py_hdr_misc_cadd3_desc,
                  :d_py_hdr_misc_czip_desc,
                  :d_py_hdr_misc_long_name_ch,
                  :d_py_hdr_misc_short_name_ch,
                  :d_py_hdr_misc_add1_desc_ch,
                  :d_py_hdr_misc_add2_desc_ch,
                  :d_py_hdr_misc_add3_desc_ch,
                  :d_py_hdr_misc_zip_desc_ch,
                  :d_py_hdr_tel_num,
                  :d_py_hdr_contact_name,
                  :d_py_hdr_contact_name_title,
                  :d_py_hdr_print_flag,
                  :d_py_hdr_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )288;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_last_line_num;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )17;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_py_hdr_doc_date_chking;
   sqlstm.sqhstl[3] = (unsigned int  )17;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_py_hdr_doc_ref;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_py_hdr_cust_code;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_py_hdr_main_acc1_code;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_py_hdr_main_acc2_code;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_py_hdr_sub_group_code;
   sqlstm.sqhstl[8] = (unsigned int  )6;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_py_hdr_sub_line_code;
   sqlstm.sqhstl[9] = (unsigned int  )11;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_py_hdr_dept_code;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_py_hdr_product_group_code;
   sqlstm.sqhstl[11] = (unsigned int  )6;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_py_hdr_product_line_code;
   sqlstm.sqhstl[12] = (unsigned int  )7;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_py_hdr_amt_foreign;
   sqlstm.sqhstl[13] = (unsigned int  )19;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_py_hdr_amt_local;
   sqlstm.sqhstl[14] = (unsigned int  )19;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_py_hdr_narration;
   sqlstm.sqhstl[15] = (unsigned int  )53;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_py_hdr_post_month;
   sqlstm.sqhstl[16] = (unsigned int  )5;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_py_hdr_post_year;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_py_hdr_currency_code;
   sqlstm.sqhstl[18] = (unsigned int  )9;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_py_hdr_exchg_rate;
   sqlstm.sqhstl[19] = (unsigned int  )17;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_py_hdr_bank_desc;
   sqlstm.sqhstl[20] = (unsigned int  )33;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_py_hdr_cheque_num;
   sqlstm.sqhstl[21] = (unsigned int  )13;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_py_hdr_cheque_date;
   sqlstm.sqhstl[22] = (unsigned int  )17;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_py_hdr_misc_clong_name;
   sqlstm.sqhstl[23] = (unsigned int  )103;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_py_hdr_misc_cshort_name;
   sqlstm.sqhstl[24] = (unsigned int  )63;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_py_hdr_misc_cadd1_desc;
   sqlstm.sqhstl[25] = (unsigned int  )63;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&d_py_hdr_misc_cadd2_desc;
   sqlstm.sqhstl[26] = (unsigned int  )63;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&d_py_hdr_misc_cadd3_desc;
   sqlstm.sqhstl[27] = (unsigned int  )63;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&d_py_hdr_misc_czip_desc;
   sqlstm.sqhstl[28] = (unsigned int  )63;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&d_py_hdr_misc_long_name_ch;
   sqlstm.sqhstl[29] = (unsigned int  )103;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&d_py_hdr_misc_short_name_ch;
   sqlstm.sqhstl[30] = (unsigned int  )103;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&d_py_hdr_misc_add1_desc_ch;
   sqlstm.sqhstl[31] = (unsigned int  )63;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&d_py_hdr_misc_add2_desc_ch;
   sqlstm.sqhstl[32] = (unsigned int  )63;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&d_py_hdr_misc_add3_desc_ch;
   sqlstm.sqhstl[33] = (unsigned int  )63;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&d_py_hdr_misc_zip_desc_ch;
   sqlstm.sqhstl[34] = (unsigned int  )63;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&d_py_hdr_tel_num;
   sqlstm.sqhstl[35] = (unsigned int  )33;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&d_py_hdr_contact_name;
   sqlstm.sqhstl[36] = (unsigned int  )103;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&d_py_hdr_contact_name_title;
   sqlstm.sqhstl[37] = (unsigned int  )63;
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&d_py_hdr_print_flag;
   sqlstm.sqhstl[38] = (unsigned int  )4;
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&d_py_hdr_rowid;
   sqlstm.sqhstl[39] = (unsigned int  )33;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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

d_py_hdr_acc_entity_code.arr[d_py_hdr_acc_entity_code.len]             = '\0';
d_py_hdr_last_line_num.arr[d_py_hdr_last_line_num.len]                 = '\0';
d_py_hdr_doc_date.arr[d_py_hdr_doc_date.len]                           = '\0';
d_py_hdr_doc_ref.arr[d_py_hdr_doc_ref.len]                             = '\0';
d_py_hdr_cust_code.arr[d_py_hdr_cust_code.len]                         = '\0';
d_py_hdr_main_acc1_code.arr[d_py_hdr_main_acc1_code.len]               = '\0';
d_py_hdr_main_acc2_code.arr[d_py_hdr_main_acc2_code.len]               = '\0';
d_py_hdr_sub_group_code.arr[d_py_hdr_sub_group_code.len]   = '\0';
d_py_hdr_sub_line_code.arr[d_py_hdr_sub_line_code.len]     = '\0';
d_py_hdr_dept_code.arr[d_py_hdr_dept_code.len]                         = '\0';
d_py_hdr_product_group_code.arr[d_py_hdr_product_group_code.len]       = '\0';
d_py_hdr_product_line_code.arr[d_py_hdr_product_line_code.len]         = '\0';
d_py_hdr_amt_foreign.arr[d_py_hdr_amt_foreign.len]                     = '\0';
d_py_hdr_amt_local.arr[d_py_hdr_amt_local.len]                         = '\0';
d_py_hdr_narration.arr[d_py_hdr_narration.len]                         = '\0';
d_py_hdr_post_month.arr[d_py_hdr_post_month.len]                       = '\0';
d_py_hdr_post_year.arr[d_py_hdr_post_year.len]                         = '\0';
d_py_hdr_currency_code.arr[d_py_hdr_currency_code.len]                 = '\0';
d_py_hdr_exchg_rate.arr[d_py_hdr_exchg_rate.len]                       = '\0';
d_py_hdr_bank_desc.arr[d_py_hdr_bank_desc.len]                         = '\0';
d_py_hdr_cheque_num.arr[d_py_hdr_cheque_num.len]                       = '\0';
d_py_hdr_cheque_date.arr[d_py_hdr_cheque_date.len]                     = '\0';
d_py_hdr_misc_clong_name.arr[d_py_hdr_misc_clong_name.len]     = '\0';
d_py_hdr_misc_cshort_name.arr[d_py_hdr_misc_cshort_name.len]   = '\0';
d_py_hdr_misc_cadd1_desc.arr[d_py_hdr_misc_cadd1_desc.len]     = '\0';
d_py_hdr_misc_cadd2_desc.arr[d_py_hdr_misc_cadd2_desc.len]     = '\0';
d_py_hdr_misc_cadd3_desc.arr[d_py_hdr_misc_cadd3_desc.len]     = '\0';
d_py_hdr_misc_czip_desc.arr[d_py_hdr_misc_czip_desc.len]       = '\0';
d_py_hdr_misc_long_name_ch.arr[d_py_hdr_misc_long_name_ch.len]         = '\0';
d_py_hdr_misc_short_name_ch.arr[d_py_hdr_misc_short_name_ch.len]       = '\0';
d_py_hdr_misc_add1_desc_ch.arr[d_py_hdr_misc_add1_desc_ch.len]         = '\0';
d_py_hdr_misc_add2_desc_ch.arr[d_py_hdr_misc_add2_desc_ch.len]         = '\0';
d_py_hdr_misc_add3_desc_ch.arr[d_py_hdr_misc_add3_desc_ch.len]         = '\0';
d_py_hdr_misc_zip_desc_ch.arr[d_py_hdr_misc_zip_desc_ch.len]           = '\0';
d_py_hdr_tel_num.arr[d_py_hdr_tel_num.len]                             = '\0';
d_py_hdr_contact_name.arr[d_py_hdr_contact_name.len]                   = '\0';
d_py_hdr_contact_name_title.arr[d_py_hdr_contact_name_title.len]       = '\0';
d_py_hdr_print_flag.arr[d_py_hdr_print_flag.len]                       = '\0';
d_py_hdr_rowid.arr[d_py_hdr_rowid.len]                                 = '\0';

d_py_hdr_doc_date_chking.arr[d_py_hdr_doc_date_chking.len]            = '\0';

   return(sqlca.sqlerrd[2]);
}

validate_pay_header()
{
   char chk1_arr[30],chk2_arr[30];

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Val inv header...\n");
#endif

   /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )463;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_doc_type_code;
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


 
   if (OERROR) err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,"");

   d_ar_acc_status.arr[0]     = '\0';
   d_ar_acc_valid_flag.arr[0] = '\0';
   sy_doc_print_flag.arr[0]   = '\0';

   d_ar_acc_valid_flag.len = 0;
   d_ar_acc_status.len     = 0;
   sy_doc_print_flag.len   = 0;

   /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
             INTO :d_ar_acc_status,
                  :d_ar_acc_valid_flag,
                  :sy_doc_print_flag; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )482;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_acc_status;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_acc_valid_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&sy_doc_print_flag;
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
        err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,""); 

   d_ar_acc_status.arr[d_ar_acc_status.len]         = '\0';
   d_ar_acc_valid_flag.arr[d_ar_acc_valid_flag.len] = '\0';
   sy_doc_print_flag.arr[sy_doc_print_flag.len]     = '\0';
   
   if (NOT_FOUND)
         error_insert("   0","SY1610");
   else
   {
      if (d_ar_acc_valid_flag.arr[0] != 'Y')
            error_insert("   0","SY1700");
      if (d_ar_acc_status.arr[0] == 'S')
            error_insert("   0","SY1640");

      if (nd_proc_flag.arr[0] == 'P') 
      {
          if (d_py_hdr_print_flag.arr[0] != 'Y' && sy_doc_print_flag.arr[0] == 'Y')
               error_insert("   0","SY2370");
      }
   } 

   /* EXEC SQL OPEN SY_DOC_TYPE_MAST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0013;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )509;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_doc_type_code;
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
       err_mesg("OPEN failed on cursor SY_DOC_TYPE_MAST_CUR",0,""); 

   mast_status.arr[0] = '\0';
   mast_status.len    = 0;

   /* EXEC SQL FETCH SY_DOC_TYPE_MAST_CUR
             INTO :mast_status; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )528;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&mast_status;
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
       err_mesg("FETCH failed on cursor SY_DOC_TYPE_MAST_CUR",0,""); 

   mast_status.arr[mast_status.len] = '\0';
   
   if (NOT_FOUND)
        error_insert("   0","SY1610");
   else if (mast_status.arr[0] == 'S')
        error_insert("   0","SY2190");
   
   /* EXEC SQL OPEN AR_TRN_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )547;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_type_code;
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



   if (OERROR)
        err_mesg("OPEN failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   /* EXEC SQL FETCH AR_TRN_DOC_TYPE_CUR
             INTO :dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )570;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)dummy;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )8;
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
        error_insert("   0","AR1890");

  /*------- Added By Venkat  ---------------------*/
   
   /* EXEC SQL OPEN SY_DOC_CONTROL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0010;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )589;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_num;
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
        err_mesg("OPEN failed on cursor SY_DOC_CONTROL_CUR",0,"");

   /* EXEC SQL FETCH SY_DOC_CONTROL_CUR
             INTO :dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )612;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)dummy;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )8;
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
        err_mesg("FETCH failed on cursor SY_DOC_CONTROL_CUR",0,"");

   if (!NOT_FOUND)   /*   Record Exists   */
        error_insert("   0","AR1080");
  
  /*----------------------------------------------*/ 
   
   /****   AR_CUSTOMER Validation   *****/
  
   /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )631;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_cust_code;
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

   d_customer_status.arr[0]       = '\0';
   d_customer_patient_flag.arr[0] = '\0';
   d_last_pay_doc_date.arr[0]     = '\0';

   d_customer_status.len       = 0;
   d_customer_patient_flag.len = 0;
   d_last_pay_doc_date.len     = 0;

   /* EXEC SQL FETCH AR_CUSTOMER_CUR
             INTO :d_customer_status,
                  :d_customer_patient_flag,
                  :d_last_pay_doc_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )650;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_customer_status;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_customer_patient_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_last_pay_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
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



   d_customer_status.arr[d_customer_status.len]             = '\0';
   d_customer_patient_flag.arr[d_customer_patient_flag.len] = '\0';
   d_last_pay_doc_date.arr[d_last_pay_doc_date.len]         = '\0';

   if (OERROR)
        err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

   if (NOT_FOUND)
        error_insert("   0","AR1210");
   else
     if (d_customer_status.arr[0] == 'S')
        error_insert("   0","AR1220");

#ifdef DEBUG
   disp_message(INFO_MESG,"Before validate posting\n");
#endif

   validate_posting("   0",0);

#ifdef DEBUG
   disp_message(INFO_MESG,"After validate posting\n");
#endif

      if (atoi(d_py_hdr_post_month.arr) > atoi(d_sy_num_acc_per.arr))
             error_insert("   0","GL2290");

      if (atoi(d_py_hdr_post_year.arr) < atoi(curr_acc_year.arr))
             error_insert("   0","GL1595");

      if ( (atoi(d_py_hdr_post_year.arr) == atoi(curr_acc_year.arr) && 
              atoi(d_py_hdr_post_month.arr) < atoi(curr_acc_month.arr)) &&
               prior_post_allow.arr[0] != 'Y' )
                  error_insert("   0","GL1310");

      if (atof(d_py_hdr_amt_local.arr) < 0.00)
                error_insert("   0","AR1970");
  
      if (d_py_hdr_doc_date.len == 0)
            error_insert_null("   0","SY1470","Field = DOC DATE");
      if (d_py_hdr_cust_code.len == 0)
            error_insert_null("   0","SY1470","Field = CUST CODE");
      if (d_py_hdr_amt_local.len == 0)
            error_insert_null("   0","SY1470","Field = AMOUNT");

     if (d_py_hdr_post_month.len == 0)
            error_insert_null("   0","SY1470","Field = POST MONTH");
     if (d_py_hdr_post_year.len == 0)
            error_insert_null("   0","SY1470","Field = POST YEAR");

   /*
   {

     if (d_py_hdr_bank_desc.len == 0)
            error_insert_null("   0","SY1470","Field = BANK NAME");

     if (d_py_hdr_cheque_num.len == 0)
            error_insert_null("   0","SY1470","Field = CHEQUE NUM");

     if (d_py_hdr_cheque_date.len == 0)
            error_insert_null("   0","SY1470","Field = CHEQUE DATE");
		 
    }           
     
	*/                
#ifdef DEBUG
   disp_message(INFO_MESG,"After Val inv header...\n");
#endif
}
/*-------- Added By Venkat -----------------------------*/

check_bank_reconcile(loc_line_num,ind)
char loc_line_num[];
int ind;
{
  /* EXEC SQL BEGIN DECLARE SECTION; */ 


      /* VARCHAR gl_bank_reconcile_flag[3],
              l_main_acc1[8],
              l_main_acc2[8]; */ 
struct { unsigned short len; unsigned char arr[3]; } gl_bank_reconcile_flag;

struct { unsigned short len; unsigned char arr[8]; } l_main_acc1;

struct { unsigned short len; unsigned char arr[8]; } l_main_acc2;


  /* EXEC SQL END DECLARE SECTION; */ 


  if (ind == 0)
  {
      strcpy(l_main_acc1.arr,d_py_hdr_main_acc1_code.arr);
      strcpy(l_main_acc2.arr,d_py_hdr_main_acc2_code.arr);
  }
  else
  {
      strcpy(l_main_acc1.arr,d_line_main_acc1_code.arr);
      strcpy(l_main_acc2.arr,d_line_main_acc2_code.arr);
  }

  l_main_acc1.len = strlen(l_main_acc1.arr);
  l_main_acc2.len = strlen(l_main_acc2.arr);

  /* EXEC SQL SELECT BANK_RECONCILE_FLAG
             INTO :gl_bank_reconcile_flag
             FROM GL_ACC_CHART
            WHERE MAIN_ACC1_CODE  = :l_main_acc1
               AND MAIN_ACC2_CODE = :l_main_acc2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 40;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select BANK_RECONCILE_FLAG into :b0  from GL_ACC_CHART wher\
e (MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )677;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&gl_bank_reconcile_flag;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_main_acc1;
  sqlstm.sqhstl[1] = (unsigned int  )10;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_main_acc2;
  sqlstm.sqhstl[2] = (unsigned int  )10;
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
         err_mesg("SELECT failed on table GL_ACC_CHART",0,"");

   if (NOT_FOUND)
         error_insert(loc_line_num,"SY1400");
   else 
   if (gl_bank_reconcile_flag.arr[0] == 'Y')
   {
         /* EXEC SQL SELECT 'X'
                    INTO :dummy
                    FROM GL_BB_TXN_HDR
                   WHERE MAIN_ACC1_CODE = :l_main_acc1
                     AND MAIN_ACC2_CODE = :l_main_acc2; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 40;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select 'X' into :b0  from GL_BB_TXN_HDR where (MAIN_\
ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2)";
         sqlstm.iters = (unsigned int  )10;
         sqlstm.offset = (unsigned int  )704;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)dummy;
         sqlstm.sqhstl[0] = (unsigned int  )7;
         sqlstm.sqhsts[0] = (         int  )8;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqharc[0] = (unsigned int   *)0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&l_main_acc1;
         sqlstm.sqhstl[1] = (unsigned int  )10;
         sqlstm.sqhsts[1] = (         int  )10;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&l_main_acc2;
         sqlstm.sqhstl[2] = (unsigned int  )10;
         sqlstm.sqhsts[2] = (         int  )10;
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
            err_mesg("SELECT failed on table GL_BB_TXN_HDR",0,"");

        if (NOT_FOUND)
            error_insert(loc_line_num,"GL2310");
   }
}
/*------------ End Of Addition ----------------------*/            
validate_posting(loc_line_num,ind)
char loc_line_num[];
int ind;
{

#ifdef DEBUG
  disp_message(INFO_MESG,"Inside valiate posting acc...\n");
#endif

  if (ind == 0)
  {

      strcpy(d_module_valid_id.arr , "AR");

      if(validate_posting_acct( d_py_hdr_main_acc1_code.arr,
                                d_py_hdr_main_acc2_code.arr,
                                d_py_hdr_dept_code.arr,
                                d_py_hdr_product_group_code.arr,
                                d_py_hdr_product_line_code.arr,
                                d_py_hdr_sub_group_code.arr,
                                d_py_hdr_sub_line_code.arr,
                                'Y',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
								atol(d_py_hdr_post_year.arr),
								atol(d_py_hdr_post_month.arr),
                                &g_err_typ,
                                g_err_id,
                                g_err_msg
                             ) ==  -1)
      {
             if(g_err_typ == 0)
                   err_mesg(g_err_msg,0,"");
             else 
                error_insert(loc_line_num,g_err_id);
       }
  } 
  else
  {

       strcpy(d_module_valid_id.arr , "AR");

      if(validate_posting_acct( d_line_main_acc1_code.arr,
                                d_line_main_acc2_code.arr,
                                d_line_dept_code.arr,
                                d_line_product_group_code.arr,
                                d_line_product_line_code.arr,
                                d_line_sub_group_code.arr,
                                d_line_sub_line_code.arr,
                                'Y',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
								atol(d_py_hdr_post_year.arr),
								atol(d_py_hdr_post_month.arr),
                                &g_err_typ,
                                g_err_id,
                                g_err_msg
                             ) ==  -1)
      {
             if(g_err_typ == 0)
                   err_mesg(g_err_msg,0,"");
             else 
                error_insert(loc_line_num,g_err_id);
       }
   }
}

validate_pay_line()
{

  double l_line_amt_local;
  
#ifdef DEBUG
   sprintf(string_var,"DOC_TYPE_CODE is <%s> - <%d>\n",d_py_hdr_doc_type_code.arr,
                d_py_hdr_doc_type_code.len);
                disp_message(INFO_MESG,string_var);
   sprintf(string_var,"DOC_NUM       is <%s> - <%d>\n",d_py_hdr_doc_num.arr,
                d_py_hdr_doc_num.len);             
                disp_message(INFO_MESG,string_var);
#endif

   /* EXEC SQL OPEN CUR_PAY_LINE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )731;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_doc_num;
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



   if (RESOURCE_BUSY)
   {
        error_insert("   0","AR2070");
        update_err_flg();
        /* EXEC SQL COMMIT WORK; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 40;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )758;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        return (0);
   }
   else if (OERROR)
         err_mesg("OPEN failed on cursor AR_PAY_LINE",0,"");

   while (fetch_line())
   {
      nd_dtl_tot_amt += atof(d_line_amt_local.arr);

      if (d_line_line_type_code.arr[0] == 'P')
      {
            /* EXEC SQL OPEN AR_PENDING_CUR; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 40;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0014;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )773;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
            sqlstm.sqhstl[0] = (unsigned int  )6;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_cust_code;
            sqlstm.sqhstl[1] = (unsigned int  )11;
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqhstv[2] = (         void  *)&d_line_org_doc_type_code;
            sqlstm.sqhstl[2] = (unsigned int  )9;
            sqlstm.sqhsts[2] = (         int  )0;
            sqlstm.sqindv[2] = (         void  *)0;
            sqlstm.sqinds[2] = (         int  )0;
            sqlstm.sqharm[2] = (unsigned int  )0;
            sqlstm.sqadto[2] = (unsigned short )0;
            sqlstm.sqtdso[2] = (unsigned short )0;
            sqlstm.sqhstv[3] = (         void  *)&d_line_org_doc_num;
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
               err_mesg("OPEN failed on cursor AR_PENDING_CUR",0,"");
               
            ar_pend_pending_amt = 0;

            /* EXEC SQL FETCH AR_PENDING_CUR
                      INTO :ar_pend_pending_amt; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 40;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )804;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&ar_pend_pending_amt;
            sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
               err_mesg("FETCH failed on cursor AR_PENDING_CUR",0,"");

            l_line_amt_local = atof(d_line_amt_local.arr);
 
            if (NOT_FOUND)
                error_insert(d_line_line_num.arr,"AR1810");
	    else if (ar_pend_pending_amt < 0 && atof(d_line_amt_local.arr) > 0)
                      error_insert(d_line_line_num.arr,"AR2010");
            else if (abs(l_line_amt_local) > abs(ar_pend_pending_amt))
                      error_insert(d_line_line_num.arr,"AR2010");
              
            if (d_line_amt_local.len == 0)
               error_insert_null(d_line_line_num.arr,"SY1470","Field = AMOUNT");


/*
            else if ( (atof(d_line_amt_local.arr) < 0) ||
                       (!doubcmp(atof(d_line_amt_local.arr),0)) )
                      error_insert(d_line_line_num.arr,"AR1970");
*/

            validate_posting(d_line_line_num.arr,1);
       }
       else if (d_line_line_type_code.arr[0] == 'A')
       {
            if (d_line_amt_local.len == 0)
               error_insert_null(d_line_line_num.arr,"SY1470","Field = AMOUNT");
            else if ( (atof(d_line_amt_local.arr) < 0) ||
                       (!doubcmp(atof(d_line_amt_local.arr),0)) )
                      error_insert(d_line_line_num.arr,"AR1970");

            validate_posting(d_line_line_num.arr,1);
        }
        else if (d_line_line_type_code.arr[0] == 'D')
        {
            if (d_line_amt_local.len == 0)
               error_insert_null(d_line_line_num.arr,"SY1470","Field = AMOUNT");

            validate_posting(d_line_line_num.arr,1);
        }
        else 
             error_insert(d_line_line_num.arr,"AR1990");
   
    

       if (strcmp(d_consolidated_yn.arr , "Y") == 0) 
		{

            /* EXEC SQL OPEN AR_PATIENT_DTLS_CUR; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 40;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0015;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )823;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
            sqlstm.sqhstl[0] = (unsigned int  )6;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_type_code;
            sqlstm.sqhstl[1] = (unsigned int  )9;
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_doc_num;
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



			 while(fetch_patient_dtls())
			 {

			     
		            pending_amt = 0;
      
	  		        /* EXEC SQL SELECT PEND_AMOUNT
					into  :pending_amt
					from   AR_PATIENT_DTLS
					WHERE  OPERATING_FACILITY_ID=:nd_facility_id  /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
                    AND DOC_TYPE_CODE = :ar_pat_inv_doc_type_code
					AND    DOC_NUM       = :ar_pat_inv_doc_num
					AND    BILL_DOC_TYPE_CODE = :ar_pat_bill_doc_type_code
					AND    BILL_NUM = :ar_pat_bill_num; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 10;
             sqlstm.arrsiz = 40;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = "select PEND_AMOUNT into :b0  from AR_PATIENT_DTL\
S where ((((OPERATING_FACILITY_ID=:b1 and DOC_TYPE_CODE=:b2) and DOC_NUM=:b3) \
and BILL_DOC_TYPE_CODE=:b4) and BILL_NUM=:b5)";
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )850;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)256;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqhstv[0] = (         void  *)&pending_amt;
             sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
             sqlstm.sqhstl[1] = (unsigned int  )6;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&ar_pat_inv_doc_type_code;
             sqlstm.sqhstl[2] = (unsigned int  )9;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqhstv[3] = (         void  *)&ar_pat_inv_doc_num;
             sqlstm.sqhstl[3] = (unsigned int  )11;
             sqlstm.sqhsts[3] = (         int  )0;
             sqlstm.sqindv[3] = (         void  *)0;
             sqlstm.sqinds[3] = (         int  )0;
             sqlstm.sqharm[3] = (unsigned int  )0;
             sqlstm.sqadto[3] = (unsigned short )0;
             sqlstm.sqtdso[3] = (unsigned short )0;
             sqlstm.sqhstv[4] = (         void  *)&ar_pat_bill_doc_type_code;
             sqlstm.sqhstl[4] = (unsigned int  )9;
             sqlstm.sqhsts[4] = (         int  )0;
             sqlstm.sqindv[4] = (         void  *)0;
             sqlstm.sqinds[4] = (         int  )0;
             sqlstm.sqharm[4] = (unsigned int  )0;
             sqlstm.sqadto[4] = (unsigned short )0;
             sqlstm.sqtdso[4] = (unsigned short )0;
             sqlstm.sqhstv[5] = (         void  *)&ar_pat_bill_num;
             sqlstm.sqhstl[5] = (unsigned int  )11;
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
					err_mesg("SELECT  failed on   AR_PATIENT_DTLS",0,"");

				if (NOT_FOUND)
					error_insert_null("   0","SY1470","Field = AR PAT DTLS");
  
               if (  ar_pat_abs_amount > pending_amt )
			   {

                   error_insert("   0","AR2393");

                }
		 
			}

    		 if (doubcmp(ar_pat_tot_amt,l_line_amt_local) != 0) 
                    error_insert_null("   0","AR2180","Mismatch with doc amt and Pat amt");

		 }

  
   }



   return (1);
}

fetch_line()
{
      d_line_main_acc1_code.arr[0]       = '\0';
      d_line_main_acc2_code.arr[0]       = '\0';
      d_line_dept_code.arr[0]            = '\0';
      d_line_product_group_code.arr[0]   = '\0';
      d_line_product_line_code.arr[0]    = '\0';
      d_line_sub_group_code.arr[0] = '\0';
      d_line_sub_line_code.arr[0]  = '\0';
      d_line_amt_local.arr[0]            = '\0';
      d_line_line_num.arr[0]             = '\0';

      d_line_org_doc_type_code.arr[0]    = '\0';
      d_line_org_doc_num.arr[0]          = '\0';
      d_line_line_type_code.arr[0]       = '\0';
	  d_consolidated_yn.arr[0] = '\0';


      d_line_main_acc1_code.len          = 0;
      d_line_main_acc2_code.len          = 0;
      d_line_dept_code.len               = 0;
      d_line_product_group_code.len      = 0;
      d_line_product_line_code.len       = 0;
      d_line_sub_group_code.len    = 0;
      d_line_sub_line_code.len     = 0;
      d_line_amt_local.len               = 0;
      d_line_line_num.len                = 0;

      d_line_org_doc_type_code.len       = 0;
      d_line_org_doc_num.len             = 0;
      d_line_line_type_code.len          = 0;
	  d_consolidated_yn.len = 0;



#ifdef DEBUG
      disp_message(INFO_MESG,"Before fetching rec from ar_pay_line\n");
#endif

      /* EXEC SQL FETCH CUR_PAY_LINE
                INTO :d_line_amt_local,
                     :d_line_line_num,
                     :d_line_main_acc1_code,
                     :d_line_main_acc2_code,
                     :d_line_dept_code,
                     :d_line_product_group_code,
                     :d_line_product_line_code,
                     :d_line_sub_group_code,
                     :d_line_sub_line_code,
                     :d_line_org_doc_type_code,
                     :d_line_org_doc_num,
                     :d_line_line_type_code,
					 :d_consolidated_yn; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 40;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )889;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_line_amt_local;
      sqlstm.sqhstl[0] = (unsigned int  )19;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_line_line_num;
      sqlstm.sqhstl[1] = (unsigned int  )7;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_line_main_acc1_code;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_line_main_acc2_code;
      sqlstm.sqhstl[3] = (unsigned int  )7;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_line_dept_code;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_line_product_group_code;
      sqlstm.sqhstl[5] = (unsigned int  )6;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_line_product_line_code;
      sqlstm.sqhstl[6] = (unsigned int  )7;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_line_sub_group_code;
      sqlstm.sqhstl[7] = (unsigned int  )6;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_line_sub_line_code;
      sqlstm.sqhstl[8] = (unsigned int  )11;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&d_line_org_doc_type_code;
      sqlstm.sqhstl[9] = (unsigned int  )9;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&d_line_org_doc_num;
      sqlstm.sqhstl[10] = (unsigned int  )11;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&d_line_line_type_code;
      sqlstm.sqhstl[11] = (unsigned int  )4;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&d_consolidated_yn;
      sqlstm.sqhstl[12] = (unsigned int  )4;
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



      if (OERROR)
         err_mesg("FETCH failed on cursor CUR_PAY_LINE",0,"");

d_line_line_num.arr[d_line_line_num.len] = '\0';
d_line_main_acc1_code.arr[d_line_main_acc1_code.len]             = '\0';
d_line_main_acc2_code.arr[d_line_main_acc2_code.len]             = '\0';
d_line_dept_code.arr[d_line_dept_code.len]                       = '\0';
d_line_product_group_code.arr[d_line_product_group_code.len]     = '\0';
d_line_product_line_code.arr[d_line_product_line_code.len]       = '\0';
d_line_sub_group_code.arr[d_line_sub_group_code.len] = '\0';
d_line_sub_line_code.arr[d_line_sub_line_code.len]   = '\0';
d_line_amt_local.arr[d_line_amt_local.len]                       = '\0';

d_line_org_doc_type_code.arr[d_line_org_doc_type_code.len]       = '\0';
d_line_org_doc_num.arr[d_line_org_doc_num.len]                   = '\0';
d_line_line_type_code.arr[d_line_line_type_code.len]             = '\0';
d_consolidated_yn.arr[d_consolidated_yn.len] = '\0';


#ifdef DEBUG
      sprintf(string_var,"After fetching pay count is <%d> \n",sqlca.sqlerrd[2]);
      disp_message(INFO_MESG,string_var);
#endif

  if (LAST_ROW)
      return(0);
  else
      return(1);

} 

validate_pay_amt() 
{
    if (doubcmp((-1*nd_dtl_tot_amt),atof(d_py_hdr_amt_local.arr)) != 0)
    {
#ifdef DEBUG
        sprintf(string_var,"nd dtl amt is <%f>\n local amt is <%f>\n",
                     nd_dtl_tot_amt,atof(d_py_hdr_amt_local.arr));
                     disp_message(INFO_MESG,string_var);
#endif

          error_insert("   0","AR1200");
    }
}
  
gl_doc_insert()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside gl_doc_insert...\n");
#endif 

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
           NULL,
           :d_py_hdr_doc_type_code,
           0,
           :d_py_hdr_doc_num,
           to_date(:d_py_hdr_doc_date,'DD/MM/YYYY'),
           SUBSTR(:d_py_hdr_doc_ref,1,10),
           :d_py_hdr_narration,
           :d_py_hdr_post_month,
           :d_py_hdr_post_year,
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
           :d_py_hdr_last_line_num,
           'AR',
           NULL,
           NULL,
           NULL
         ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into GL_TXN_DOC_HDR (ACC_ENTITY_CODE,DOC_TYPE_CODE,\
BATCH_NUM,DOC_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT,DOC\
_NATURE,UNIT_TYPE_CODE,CURRENCY_CODE,EXCHG_RATE,ERROR_FLAG,ADDED_BY_ID,MODIFIE\
D_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID,TXN_TYPE_DESC,STD_JV_R\
EF,PRINT_FLAG) values (null ,:b0,0,:b1,to_date(:b2,'DD/MM/YYYY'),SUBSTR(:b3,1,\
10),:b4,:b5,:b6,0,null ,null ,null ,null ,null ,USER,USER,SYSDATE,SYSDATE,:b7,\
'AR',null ,null ,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )956;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )17;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_py_hdr_doc_ref;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_py_hdr_narration;
   sqlstm.sqhstl[4] = (unsigned int  )53;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_py_hdr_post_month;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_py_hdr_post_year;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_py_hdr_last_line_num;
   sqlstm.sqhstl[7] = (unsigned int  )7;
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



    if (OERROR)
         err_mesg("INSERT failed on table GL_TXN_DOC_HDR",0,"");
            
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
           INTER_ACC_ENTITY
         )
      VALUES
         (
           NULL,
           0,
           :d_py_hdr_doc_type_code,
           :d_py_hdr_doc_num,
           :d_py_hdr_main_acc1_code,
           :d_py_hdr_main_acc2_code,
           :d_py_hdr_sub_group_code,
           :d_py_hdr_sub_line_code,
           :d_py_hdr_dept_code,
           :d_py_hdr_product_group_code,
           :d_py_hdr_product_line_code,
           NULL,
           :d_py_hdr_amt_local,
           :d_py_hdr_narration,
           '0',
           NULL 
         ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 40;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY) values (null ,0,:b0,:b1,:b2,:b3,:b4,:b5\
,:b6,:b7,:b8,null ,:b9,:b10,'0',null )";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1003;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_num;
  sqlstm.sqhstl[1] = (unsigned int  )11;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_main_acc1_code;
  sqlstm.sqhstl[2] = (unsigned int  )9;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_py_hdr_main_acc2_code;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_py_hdr_sub_group_code;
  sqlstm.sqhstl[4] = (unsigned int  )6;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_py_hdr_sub_line_code;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_py_hdr_dept_code;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_py_hdr_product_group_code;
  sqlstm.sqhstl[7] = (unsigned int  )6;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_py_hdr_product_line_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_py_hdr_amt_local;
  sqlstm.sqhstl[9] = (unsigned int  )19;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_py_hdr_narration;
  sqlstm.sqhstl[10] = (unsigned int  )53;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_LINE",0,"");    

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
           INTER_ACC_ENTITY
         )
         SELECT
           NULL,
           0,
           DOC_TYPE_CODE,
           DOC_NUM,
           MAIN_ACC1_CODE,
           MAIN_ACC2_CODE,
           SUBLEDGER_GROUP_CODE,
           SUBLEDGER_LINE_CODE,
           DEPT_CODE,
           PRODUCT_GROUP_CODE,
           PRODUCT_LINE_CODE,
           NULL,
           AMT_LOCAL,
           NARRATION,
           LINE_NUM,
           NULL 
     FROM  AR_PAY_LINE
    WHERE  OPERATING_FACILITY_ID=:nd_facility_id  /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
      AND  DOC_TYPE_CODE = :d_py_hdr_doc_type_code
      AND  DOC_NUM       = :d_py_hdr_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 40;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY)select null  ,0 ,DOC_TYPE_CODE ,DOC_NUM \
,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,DE\
PT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,null  ,AMT_LOCAL ,NARRATION ,L\
INE_NUM ,null   from AR_PAY_LINE where ((OPERATING_FACILITY_ID=:b0 and DOC_TYP\
E_CODE=:b1) and DOC_NUM=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1062;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )6;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_doc_num;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_LINE - for line",0,"");    

#ifdef DEBUG
   disp_message(INFO_MESG,"After gl_doc_insert...\n");
#endif 
}

gl_posting()
{

 char r_err_msg[100];

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside gl_posting...\n");
#endif


 if (post_doc((long)0,d_py_hdr_doc_type_code.arr,atol(d_py_hdr_doc_num.arr),
            r_err_msg) == -1)
        err_mesg(r_err_msg,0,""); 

#ifdef DEBUG
   disp_message(INFO_MESG,"After gl_posting...\n");
#endif
   return (0);
}

delete_gl_recs()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"inside delete_gl_recs...\n");
#endif

 /* EXEC SQL DELETE FROM GL_TXN_DOC_HDR 
                WHERE DOC_TYPE_CODE = :d_py_hdr_doc_type_code
                  AND DOC_NUM       = :d_py_hdr_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 40;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from GL_TXN_DOC_HDR  where (DOC_TYPE_CODE=:b0 and DO\
C_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1089;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_num;
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
                WHERE DOC_TYPE_CODE = :d_py_hdr_doc_type_code
                  AND DOC_NUM       = :d_py_hdr_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 40;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from GL_TXN_DOC_LINE  where (DOC_TYPE_CODE=:b0 and D\
OC_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1112;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_py_hdr_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_num;
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

#ifdef DEBUG
   disp_message(INFO_MESG,"After delete_gl_recs...\n");
#endif
}

error_insert(line_no,msg_id)
char line_no[],msg_id[];
{
   /* EXEC SQL BEGIN DECLARE SECTION; */ 

     /* VARCHAR ar_line_no[5],
             ar_err_code[7],
             l_ar_doc_error_text[71]; */ 
struct { unsigned short len; unsigned char arr[5]; } ar_line_no;

struct { unsigned short len; unsigned char arr[7]; } ar_err_code;

struct { unsigned short len; unsigned char arr[71]; } l_ar_doc_error_text;

   /* EXEC SQL END DECLARE SECTION; */ 


   char l_ch_payable_amt[25],
        l_ch_tot_amt[25];

#ifdef DEBUG
    sprintf(string_var,"Inside Error_ins line no is <%s> msg is <%s>\n",line_no,msg_id);
    disp_message(INFO_MESG,string_var);
#endif
   fflush(stdout);

   if (strcmp(line_no,"   0"))
     sprintf(ar_line_no.arr,"%4d",atoi(line_no));
   else
     strcpy(ar_line_no.arr,line_no);

   ar_line_no.len = strlen(ar_line_no.arr);

   strcpy(ar_err_code.arr,msg_id);
   ar_err_code.len = strlen(ar_err_code.arr);

   l_ar_doc_error_text.len = 0;
   l_ar_doc_error_text.arr[0] = '\0';

   if (strcmp(ar_err_code.arr,"AR1200") == 0)
   {
      if (nd_no_of_decimal == 3)
	  {
	    sprintf(l_ch_payable_amt,"%19.3f",atof(d_py_hdr_amt_local.arr));
        sprintf(l_ch_tot_amt,"%19.3f",nd_dtl_tot_amt);
      }
      else 
	  { 
	    sprintf(l_ch_payable_amt,"%19.2f",atof(d_py_hdr_amt_local.arr));
        sprintf(l_ch_tot_amt,"%19.2f",nd_dtl_tot_amt);
      }
 

   	   format_amt(l_ch_payable_amt,nd_no_of_decimal);
	   format_amt(l_ch_tot_amt,nd_no_of_decimal);


       sprintf(l_ar_doc_error_text.arr,"Doc Amt = %s   Sum of Line Amt = %s",
                   l_ch_payable_amt,l_ch_tot_amt);
       l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);


   }


   /********************************************************************/

if (strcmp(ar_err_code.arr,"AR2393") == 0)
{   

      l_ar_doc_error_text.len = 0;
      l_ar_doc_error_text.arr[0] = '\0';

     #ifdef DEBUG
       disp_message(INFO_MESG,"Error code is AR2393\n");
       fflush(stdout);
     #endif
     
	 if (nd_no_of_decimal == 3)
     {
       /* EXEC SQL SELECT 'Doc Amt = '|| 
                ltrim(rtrim(TO_CHAR(:ar_pat_abs_amount,'999,999,999,990.999')))
                || '   Pending Amt = '||
                ltrim(rtrim(TO_CHAR(:pending_amt,'999,999,999,990.999')))
        INTO :l_ar_doc_error_text
        FROM DUAL; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 40;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select ((('Doc Amt = '||ltrim(rtrim(TO_CHAR(:b0,'999,9\
99,999,990.999'))))||'   Pending Amt = ')||ltrim(rtrim(TO_CHAR(:b1,'999,999,99\
9,990.999')))) into :b2  from DUAL ";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1135;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&ar_pat_abs_amount;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&pending_amt;
       sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_ar_doc_error_text;
       sqlstm.sqhstl[2] = (unsigned int  )73;
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


     }
	 else
     {
       /* EXEC SQL SELECT 'Doc Amt = '|| 
                ltrim(rtrim(TO_CHAR(:ar_pat_abs_amount,'999,999,999,990.99')))
                || '   Pending Amt = '||
                ltrim(rtrim(TO_CHAR(:pending_amt,'999,999,999,990.99')))
        INTO :l_ar_doc_error_text
        FROM DUAL; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 40;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select ((('Doc Amt = '||ltrim(rtrim(TO_CHAR(:b0,'999,9\
99,999,990.99'))))||'   Pending Amt = ')||ltrim(rtrim(TO_CHAR(:b1,'999,999,999\
,990.99')))) into :b2  from DUAL ";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1162;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&ar_pat_abs_amount;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&pending_amt;
       sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_ar_doc_error_text;
       sqlstm.sqhstl[2] = (unsigned int  )73;
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


     }

     l_ar_doc_error_text.arr[l_ar_doc_error_text.len] = '\0';

     if (OERROR)
          err_mesg("SELECT failed on table DUAL",0,"",0,"");
 
 }
  
/********************************************************************/

   /* EXEC SQL INSERT INTO AR_DOC_ERROR
                   (PGM_ID,
                    DOC_TYPE_CODE,    DOC_NUM,
                    LINE_NUM,         ERROR_CODE,
                    ERROR_TEXT,OPERATING_FACILITY_ID) /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
            VALUES (:d_curr_pgm_name,:d_py_hdr_doc_type_code,   :d_py_hdr_doc_num,
                    :ar_line_no,      :ar_err_code,
                    :l_ar_doc_error_text,:nd_facility_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (PGM_ID,DOC_TYPE_CODE,DOC_NUM,LIN\
E_NUM,ERROR_CODE,ERROR_TEXT,OPERATING_FACILITY_ID) values (:b0,:b1,:b2,:b3,:b4\
,:b5,:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1189;
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
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_line_no;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_err_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_ar_doc_error_text;
   sqlstm.sqhstl[5] = (unsigned int  )73;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[6] = (unsigned int  )6;
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
   {
     sprintf(string_var,"doc type is <%s> - <%d>\n",d_py_hdr_doc_type_code.arr,
              d_py_hdr_doc_type_code.len);
              disp_message(ORA_MESG,string_var);
     sprintf(string_var,"doc num is <%s> - <%d>\n",d_py_hdr_doc_num.arr,
              d_py_hdr_doc_num.len);
              disp_message(ORA_MESG,string_var);              

     sprintf(string_var,"line no is <%s> - <%d>\n",d_line_line_num.arr,d_line_line_num.len);
     disp_message(ORA_MESG,string_var);
     sprintf(string_var,"err is <%s> - <%d>\n",ar_err_code.arr,ar_err_code.len);
     disp_message(ORA_MESG,string_var);
     err_mesg("INSERT failed on table AR_DOC_ERROR",0,"");
   }

   strcpy(nd_error_flag.arr,"Y");
   nd_error_flag.len = 1;
}

error_insert_null(line_no,msg_id,msg_txt)
char line_no[],msg_id[],msg_txt[];
{
   /* EXEC SQL BEGIN DECLARE SECTION; */ 

     /* VARCHAR ar_line_no[5],
             ar_err_code[7],
             l_ar_doc_error_text[71]; */ 
struct { unsigned short len; unsigned char arr[5]; } ar_line_no;

struct { unsigned short len; unsigned char arr[7]; } ar_err_code;

struct { unsigned short len; unsigned char arr[71]; } l_ar_doc_error_text;

   /* EXEC SQL END DECLARE SECTION; */ 


   if (strcmp(line_no,"   0"))
     sprintf(ar_line_no.arr,"%4d",atoi(line_no));
   else
     strcpy(ar_line_no.arr,line_no);

   ar_line_no.len = strlen(ar_line_no.arr);

   strcpy(ar_err_code.arr,msg_id);
   ar_err_code.len = strlen(ar_err_code.arr);

   l_ar_doc_error_text.len = 0;
   l_ar_doc_error_text.arr[0] = '\0';

   strcpy(l_ar_doc_error_text.arr,msg_txt);
   l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);


   /* EXEC SQL INSERT INTO AR_DOC_ERROR
                   (PGM_ID,
                    DOC_TYPE_CODE,    DOC_NUM,
                    LINE_NUM,         ERROR_CODE,
                    ERROR_TEXT,OPERATING_FACILITY_ID) /oADDED BY MADHUSUDHAN FOR GDOH-CRF-0107o/
            VALUES (:d_curr_pgm_name,:d_py_hdr_doc_type_code,   :d_py_hdr_doc_num,
                    :ar_line_no,      :ar_err_code,
                    :l_ar_doc_error_text,:nd_facility_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (PGM_ID,DOC_TYPE_CODE,DOC_NUM,LIN\
E_NUM,ERROR_CODE,ERROR_TEXT,OPERATING_FACILITY_ID) values (:b0,:b1,:b2,:b3,:b4\
,:b5,:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1232;
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
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_py_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_line_no;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_err_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_ar_doc_error_text;
   sqlstm.sqhstl[5] = (unsigned int  )73;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[6] = (unsigned int  )6;
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
   {
     sprintf(string_var,"doc type is <%s> - <%d>\n",d_py_hdr_doc_type_code.arr,
                d_py_hdr_doc_type_code.len); 
                disp_message(ORA_MESG,string_var);
     sprintf(string_var,"doc num is <%s> - <%d>\n",d_py_hdr_doc_num.arr,
                     d_py_hdr_doc_num.len);       
                     disp_message(ORA_MESG,string_var);
     sprintf(string_var,"line no is <%s> - <%d>\n",d_line_line_num.arr,d_line_line_num.len);
     disp_message(ORA_MESG,string_var);
     sprintf(string_var,"err is <%s> - <%d>\n",ar_err_code.arr,ar_err_code.len);
     disp_message(ORA_MESG,string_var);
     err_mesg("INSERT failed on table AR_DOC_ERROR",0,"");
   }

   strcpy(nd_error_flag.arr,"Y");
   nd_error_flag.len = 1;
}
update_err_flg()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Update err flg...");
#endif

   /* EXEC SQL UPDATE AR_PAY_HDR 
               SET ERROR_FLAG = :nd_error_flag
             WHERE ROWID      = :d_py_hdr_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 40;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update AR_PAY_HDR  set ERROR_FLAG=:b0 where ROWID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1275;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_error_flag;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_py_hdr_rowid;
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
         err_mesg("UPDATE failed on table AR_PAY_HDR",0,"");

}

delete_records()
{
    
    while (1)
    {
       /* EXEC SQL DELETE FROM AR_DOC_ERROR 
                      WHERE PGM_ID = :d_curr_pgm_name
                        AND ROWNUM < 500; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 40;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "delete  from AR_DOC_ERROR  where (PGM_ID=:b0 and ROWNU\
M<500)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1298;
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
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
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
         err_mesg("DELETE failed on table AR_DOC_ERROR",0,"");

       /* EXEC SQL COMMIT WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 40;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1317;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


       if (OERROR)
            err_mesg("COMMIT failed",0,""); 

       if (NOT_FOUND)
             break;
    }
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 40;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )1332;
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

fetch_acc_entity_flag()
{
                        
  
   /*EXEC SQL SELECT BL_INSTAL_FLAG,  MP_INSTAL_FLAG, NUM_OF_ACC_PERIODS
              INTO :d_sy_acc_bl_instal_flag, :d_sy_acc_mp_instal_flag,
                   :d_sy_num_acc_per
              FROM SY_ACC_ENTITY;*/

  /* EXEC SQL SELECT  NUM_OF_ACC_PERIODS , ACC_ENTITY_CODE,
                   NO_OF_DECIMAL
              INTO   :d_sy_num_acc_per, :nd_acc_entity_code,
			         :nd_no_of_decimal
              FROM SY_ACC_ENTITY
		   where   ACC_ENTITY_ID = :nd_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 40;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NUM_OF_ACC_PERIODS ,ACC_ENTITY_CODE ,NO_OF_DECIMAL i\
nto :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1363;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_sy_num_acc_per;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_acc_entity_code;
  sqlstm.sqhstl[1] = (unsigned int  )7;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_no_of_decimal;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
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
        err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");


		/* EXEC SQL EXECUTE 
            BEGIN
	         GET_INSTALLED_MODULES(:p_operational_modules);
            END;
        END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 40;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin GET_INSTALLED_MODULES ( :p_operational_modules ) ; EN\
D ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1394;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&p_operational_modules;
  sqlstm.sqhstl[0] = (unsigned int  )302;
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

 


		/* EXEC SQL SELECT INSTR(:p_operational_modules , 'BL|')
	         into   :d_sy_acc_bl_instal_flag 
			from dual ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 40;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select INSTR(:b0,'BL|') into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1413;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&p_operational_modules;
  sqlstm.sqhstl[0] = (unsigned int  )302;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_sy_acc_bl_instal_flag;
  sqlstm.sqhstl[1] = (unsigned int  )6;
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



	/* EXEC SQL SELECT INSTR(:p_operational_modules , 'MP|')
	         into   :d_sy_acc_mp_instal_flag
			from dual ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 40;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INSTR(:b0,'MP|') into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1436;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_operational_modules;
 sqlstm.sqhstl[0] = (unsigned int  )302;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sy_acc_mp_instal_flag;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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


 


  
   d_sy_num_acc_per.arr[d_sy_num_acc_per.len]               = '\0';

   d_num_of_acc_periods = atoi(d_sy_num_acc_per.arr);
}

fetch_ar_parameter()
{
     ar_interface_code.arr[0] = '\0';
     ar_interface_code.len    = 0;

     ar_cheque_entry_yn.arr[0] = '\0';
     ar_cheque_entry_yn.len    = 0;

     /* EXEC SQL SELECT AR_INTERFACE_CODE, CHQ_ENTRY_IN_PAY_ALLOW_YN 
                INTO :ar_interface_code, :ar_cheque_entry_yn
                FROM AR_PARAMETER
				WHERE OPERATING_FACILITY_ID=:nd_facility_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 40;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select AR_INTERFACE_CODE ,CHQ_ENTRY_IN_PAY_ALLOW_YN into\
 :b0,:b1  from AR_PARAMETER where OPERATING_FACILITY_ID=:b2";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1459;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&ar_interface_code;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&ar_cheque_entry_yn;
     sqlstm.sqhstl[1] = (unsigned int  )4;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )6;
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

  /*ADDED BY MADHUSUDHAN FOR GDOH-CRF-0107*/; 

     if (OERROR)
         err_mesg("SELECT failed on table AR_PARAMETER",0,"");

     ar_interface_code.arr[ar_interface_code.len]='\0';
     ar_cheque_entry_yn.arr[ar_cheque_entry_yn.len]='\0';

     /* EXEC SQL SELECT CURRENT_ACC_YEAR,CURRENT_ACC_MONTH,
                     PRIOR_POSTING_ALLOW_FLAG,
                     NVL(SUMMARY_PROCESS_FLAG,'X') 
                INTO :curr_acc_year,    :curr_acc_month,
                     :prior_post_allow, :gl_summ_pro_flag
                FROM GL_PARAMETER; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 40;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select CURRENT_ACC_YEAR ,CURRENT_ACC_MONTH ,PRIOR_POSTIN\
G_ALLOW_FLAG ,NVL(SUMMARY_PROCESS_FLAG,'X') into :b0,:b1,:b2,:b3  from GL_PARA\
METER ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1486;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&prior_post_allow;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&gl_summ_pro_flag;
     sqlstm.sqhstl[3] = (unsigned int  )4;
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
         err_mesg("SELECT failed on table GL_PARAMETER",0,"");

     curr_acc_year.arr[curr_acc_year.len]       = '\0';
     curr_acc_month.arr[curr_acc_month.len]     = '\0';
     prior_post_allow.arr[prior_post_allow.len] = '\0';
     gl_summ_pro_flag.arr[gl_summ_pro_flag.len] = '\0';

d_curr_year  = atoi(curr_acc_year.arr);
d_curr_month = atoi(curr_acc_month.arr);
d_summ_flag  = gl_summ_pro_flag.arr[0];
}

run_report()
{
  char l_run_string[300],l_messg_str[132];
  int  l_ret_run_rep;

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Run report\n");
#endif

  disp_message(INFO_MESG,"Generating report\n");

  sprintf(l_run_string,"r25run %s %s no \
  %s session_id=%s pgm_date=%s %s desname=%s.lis","print_job=no",
  "arrpylst",uid_pwd.arr,
  (nd_view_print_flg.arr[0]=='V')?"batch=no":"batch=yes",
  nd_session_id.arr,g_pgm_date,
  (nd_view_print_flg.arr[0]=='V')?"destype=Screen":"destype=File",
  (nd_proc_flag.arr[0]=='P')?"arbpypst":"arrpylst");
 
  l_ret_run_rep = WinExec(l_run_string,SW_NORMAL);
  if (l_ret_run_rep<32)
  {disp_message(ERR_MESG,"Error in calling Report Writer Program");
   proc_exit();
  } 

  if (l_ret_run_rep)
  {
     sprintf("%s\n",l_run_string);
     sprintf(l_messg_str,"RUNREP - arrpylst session = %s failed \
return value %d",nd_session_id.arr,l_ret_run_rep);
     err_mesg(l_messg_str,0,"");
  }
#ifdef DEBUG
   disp_message(INFO_MESG,"After run rep...\n");
#endif
}

ltrim(l_str)
char *l_str;
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}

/*put_comma(str)
char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10];
  strcpy(arr,str);
  strncpy(l_str1,arr + (strlen(arr) - 2),2);
  l_str1[2] = '\0';
  arr[strlen(str)-3] = '\0';
  i = strlen(arr);
  j = i;
  k = j/3;
  l = k;
  m = i - (l*3);
  if (i > 3)
  {
      for (a=0;a<m;a++)
         o_arr[a] = arr[a];
   if (m)
   {
     o_arr[m] = ','; b=m+1;
   }
   else b = m;
  for (c=1,a=m;arr[a]!= '\0';a++,b++)
  {
     o_arr[b] = arr[a]; 
     c++;
     if (c > 3 && arr[a+1] != '\0')
     {
       o_arr[++b] = ','; c = 1;
     }
   }
   o_arr[b] = '\0';
  }
  else
      strcpy(o_arr,arr);
   sprintf(str,"%s.%s",o_arr,l_str1);
} */

doubcmp(_doub1,_doub2)
double _doub1,_doub2;
{
  char _doub_str1[25],_doub_str2[25];
  if (nd_no_of_decimal == 3)
  {
    sprintf(_doub_str1,"%15.3f",_doub1);
    sprintf(_doub_str2,"%15.3f",_doub2);
	  if (strcmp(_doub_str1,"-0.000") == 0)
		 strcpy(_doub_str1,"0.000");
	  if (strcmp(_doub_str2,"-0.000") == 0)
		 strcpy(_doub_str2,"0.000");

  format_amt(_doub_str1,nd_no_of_decimal);
  format_amt(_doub_str2,nd_no_of_decimal);
  
  if (_doub1 < 0)
     sprintf(_doub_str1,"%-15.3f",_doub1);
 
 if (_doub2 < 0)
     sprintf(_doub_str2,"%-15.3f",_doub2);

  }  
  else   
  { 
    sprintf(_doub_str1,"%15.2f",_doub1);
    sprintf(_doub_str2,"%15.2f",_doub2);
	  if (strcmp(_doub_str1,"-0.00") == 0)
		 strcpy(_doub_str1,"0.00");
	  if (strcmp(_doub_str2,"-0.00") == 0)
		 strcpy(_doub_str2,"0.00"); 
  format_amt(_doub_str1,nd_no_of_decimal);
  format_amt(_doub_str2,nd_no_of_decimal);
  
  if (_doub1 < 0)
     sprintf(_doub_str1,"%-15.2f",_doub1);
 
 if (_doub2 < 0)
     sprintf(_doub_str2,"%-15.2f",_doub2);

  }
  
  return(strcmp(_doub_str1,_doub_str2));
}
