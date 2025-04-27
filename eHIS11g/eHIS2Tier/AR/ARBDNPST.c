
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
           char  filnam[45];
};
static const struct sqlcxp sqlfpn =
{
    44,
    "D:\\MADHU\\Billing\\Sargunan\\DNPOST\\ARBDNPST.PC"
};


static unsigned long sqlctx = 1147768085;


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
            void  *sqhstv[44];
   unsigned int   sqhstl[44];
            int   sqhsts[44];
            void  *sqindv[44];
            int   sqinds[44];
   unsigned int   sqharm[44];
   unsigned int   *sqharc[44];
   unsigned short  sqadto[44];
   unsigned short  sqtdso[44];
} sqlstm = {10,44};

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
"select DOC_TYPE_CODE ,DOC_NUM  from AR_DN_HDR where (((((((OPERATING_FACILIT\
Y_ID=:b0 and DOC_TYPE_CODE>=NVL(:b1,'      ')) and DOC_TYPE_CODE<=NVL(:b2,'~~~\
~~~')) and DOC_NUM>=NVL(:b3,0)) and DOC_NUM<=NVL(:b4,99999999)) and NVL(DOC_DA\
TE,SYSDATE)>=NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))) an\
d NVL(DOC_DATE,SYSDATE)<=NVL(TO_DATE(:b6,'DD/MM/YYYY'),to_date('47123112','YYY\
YDDMM'))) and NVL(POSTED_FLAG,'N')='N')           ";

 static const char *sq0008 = 
"select ACC_ENTITY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,ORG_DOC_TYPE_CODE ,ORG_DOC_N\
UM ,LAST_LINE_NUM ,CUST_CODE ,NARRATION ,BASE_DATE ,TO_CHAR(BASE_DATE,'YYYYMMD\
D') ,DUE_DATE ,TO_CHAR(DUE_DATE,'YYYYMMDD') ,GROSS_AMT ,GROSS_AMT ,PAYABLE_AMT\
 ,PAYABLE_AMT ,DISCOUNT_AMT ,DOC_AMT ,DOC_AMT ,CURRENCY_CODE ,EXCHG_RATE ,PMNT\
_TERMS_CODE ,SETTLEMENT_DATE ,TO_CHAR(SETTLEMENT_DATE,'YYYYMMDD') ,SETTLEMENT_\
PERC ,CUST_REF ,PATIENT_ID ,BILLING_GROUP ,BILL_DOC_TYPE_CODE ,BILL_NUM ,BILL_\
DATE ,TO_CHAR(BILL_DATE,'YYYYMMDD') ,DOCTOR_FEE_AMT ,MAIN_ACC1_CODE ,MAIN_ACC2\
_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,DEPT_CODE ,PRODUCT_GROUP_COD\
E ,PRODUCT_LINE_CODE ,POST_MONTH ,POST_YEAR ,ROWID ,CONSOLIDATED_INV_YN  from \
AR_DN_INV_HDR where ((OPERATING_FACILITY_ID=:b0 and DOC_TYPE_CODE=:b1) and DOC\
_NUM=:b2) for update of LAST_LINE_NUM nowait ";

 static const char *sq0009 = 
"select ACC_ENTITY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,ORG_DOC_TYPE_CODE ,ORG_DOC_N\
UM ,LINE_NUM ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_\
LINE_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,AMOUNT ,AMOUNT ,N\
ARRATION ,ROWID  from AR_DN_LINE where ((((OPERATING_FACILITY_ID=:b0 and DOC_T\
YPE_CODE=:b1) and DOC_NUM=:b2) and ORG_DOC_TYPE_CODE=:b3) and ORG_DOC_NUM=:b4)\
 for update of LINE_NUM nowait ";

 static const char *sq0007 = 
"select ACC_ENTITY_CODE ,CUST_CODE ,DOC_DATE ,TO_CHAR(DOC_DATE,'YYYYMMDD') ,D\
OC_AMT ,DOC_AMT ,POST_MONTH ,POST_YEAR ,MISC_CUST_LONG_NAME ,MISC_CUST_SHORT_N\
AME ,MISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,MISC_CUST_ADD3_DESC ,MISC_CUST_\
ZIP_DESC ,MISC_CUST_LONG_NAME_CHINESE ,MISC_CUST_SHORT_NAME_CHINESE ,MISC_CUST\
_ADD1_DESC_CHINESE ,MISC_CUST_ADD2_DESC_CHINESE ,MISC_CUST_ADD3_DESC_CHINESE ,\
MISC_CUST_ZIP_DESC_CHINESE ,TEL_NUM ,CONTACT_NAME ,CONTACT_NAME_TITLE ,ERROR_F\
LAG ,PRINT_FLAG ,ROWID  from AR_DN_HDR where ((OPERATING_FACILITY_ID=:b0 and D\
OC_TYPE_CODE=:b1) and DOC_NUM=:b2) for update of ERROR_FLAG nowait ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,232,0,4,335,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,
68,0,0,2,97,0,4,352,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
91,0,0,3,0,0,29,484,0,0,0,0,0,1,0,
106,0,0,4,0,0,30,492,0,0,0,0,0,1,0,
121,0,0,5,0,0,30,509,0,0,0,0,0,1,0,
136,0,0,6,438,0,9,542,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
179,0,0,8,823,0,9,667,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
206,0,0,10,0,0,29,673,0,0,0,0,0,1,0,
221,0,0,9,419,0,9,691,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
256,0,0,11,0,0,29,697,0,0,0,0,0,1,0,
271,0,0,6,0,0,13,722,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
294,0,0,7,611,0,9,806,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
321,0,0,7,0,0,13,813,0,0,26,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
440,0,0,12,104,0,4,944,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
467,0,0,13,89,0,4,958,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
494,0,0,8,0,0,13,1217,0,0,44,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,
2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
685,0,0,9,0,0,13,1385,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
768,0,0,14,70,0,2,1486,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
791,0,0,15,71,0,2,1493,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
814,0,0,16,183,0,3,1610,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
865,0,0,17,183,0,3,1685,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
916,0,0,18,52,0,5,1722,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
939,0,0,19,60,0,2,1735,0,0,1,1,0,1,0,1,9,0,0,
958,0,0,20,0,0,29,1742,0,0,0,0,0,1,0,
973,0,0,21,0,0,27,1753,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
1004,0,0,22,118,0,4,1771,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
1035,0,0,23,62,0,6,1782,0,0,1,1,0,1,0,2,9,0,0,
1054,0,0,24,44,0,4,1788,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1077,0,0,25,44,0,4,1792,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1100,0,0,26,84,0,4,1831,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1123,0,0,27,140,0,4,1842,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                   */
/************************************************************************/
/* PROGRAM NAME          : ARBDNPST.PC                                    */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 19-JAN-1993                                  */
/*                                                                          */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                                */
/*                                                                      */
/*  TABLE DETAILS                                                        */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_DN_HDR                Query/Update              */
/*         2.        AR_DN_INV_HDR            Query/Update              */
/*         3.        AR_DN_LINE                  Query                  */
/*         4.        SY_ACC_ENTITY_DOC_TYPE      Lookup                 */
/*         5.        SY_ACC_ENTITY               Lookup                 */
/*         6.        AR_CUSTOMER                 Lookup                 */
/*         7.        AR_PMNT_TERMS               Lookup                 */
/*         8.        BL_BLNG_GRP                 Lookup                 */
/*         9.        MP_PATIENT_MAST             Lookup                 */
/*        10.        AR_PARAMETER                Lookup                 */
/*        11.        GL_ACC_CHART                Lookup                 */
/*        12.        SY_DEPT                     Lookup                 */
/*        13.        GL_PRODUCT_LINE             Lookup                 */
/*        14.        GL_SUBLEDGER_LINE           Lookup                 */
/*        15.        GL_ACC_COMBINATION          Lookup                 */
/*        16.        AR_DOC_ERROR           Query/Insert/Delete         */
/*        17.        SY_DOC_CONTROL            Insert/Lookup            */
/*        18.        SY_PROG_CONTROL           Update/Lookup            */
/*        19.        SY_PROG_MESG                Insert                 */
/*        20.        AR_PENDING_DOC            Insert/Lookup            */
/*        21.        AR_CUST_TRN                 Insert                 */
/*        22.        GL_PARAMETER                Query                  */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
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


    int process_rep_flg;

   /* VARCHAR  nd_facility_id   [3],
			nd_session_id    [16],
            nd_pgm_date      [25],
            nd_fm_doc_type   [7],
            nd_to_doc_type   [7],
            nd_fm_doc_num    [10],
            nd_to_doc_num    [10],
            nd_fm_doc_date   [12],
            nd_to_doc_date   [12],
            nd_proc_flag     [2],
            nd_view_print_flg[2],
			nd_hosp_name     [100], /o added by sargunan for gdoh-crf-0107.1 o/
			
            d_facility_id[3],
            d_dn_hdr_doc_type_code                [7], 
            d_dn_hdr_doc_num                      [9],
            d_dn_hdr_cust_code                    [9],
            d_dn_hdr_doc_date                     [12],
            d_chk_hdr_doc_date                     [12],
            d_dn_hdr_doc_date_chking              [12],

            d_dn_hdr_acc_entity_code              [5],
/o            d_dn_hdr_doc_amt                    [17],o/
            d_dn_hdr_doc_amt_chk                  [17],
            d_dn_hdr_post_month                   [3],
            d_dn_hdr_post_year                    [5],
            d_dn_hdr_misc_cust_long_name          [101],   -- CRF-0120
            d_dn_hdr_misc_cust_sname         [101],        -- CRF-0120
            d_dn_hdr_misc_cust_add1_desc          [61],
            d_dn_hdr_misc_cust_add2_desc          [61],
            d_dn_hdr_misc_cust_add3_desc          [61],
            d_dn_hdr_misc_cust_zip_desc           [31],
            d_dn_hdr_misc_long_chinese            [101],     -- CRF-0120
            d_dn_hdr_misc_short_chinese           [101],     -- CRF-0120
            d_dn_hdr_misc_add1_chinese            [61],
            d_dn_hdr_misc_add2_chinese            [61],
            d_dn_hdr_misc_add3_chinese            [61],
            d_dn_hdr_misc_zip_chinese             [31],
            d_dn_hdr_tel_num                      [31],
            d_dn_hdr_contact_name                 [101],  -- CRF-0120
            d_dn_hdr_contact_name_title           [61],   -- CRF-0120
            d_dn_hdr_error_flag                   [2],
            d_dn_hdr_print_flag                   [2],
            d_dn_hdr_rowid                        [31],


			nd_acc_entity_code [5],
			p_operational_modules [300],
			d_consolidated_yn[2],
			d_module_valid_id             [3],
			d_ar_flag[2],


            curr_acc_year                 [5],
            curr_acc_month                [3],
            gl_summ_pro_flag              [2],
            d_sy_num_acc_per              [5],
            prior_post_allow              [3],

            d_dn_ihdr_acc_entity_code            [5],
            d_dn_ihdr_doc_type_code              [7],
            d_dn_ihdr_doc_num                    [9],
            d_dn_ihdr_org_doc_type_code          [7],
            d_dn_ihdr_org_doc_num                [9],
            d_dn_ihdr_last_line_num              [5],
            d_dn_ihdr_cust_code                  [8],
            d_dn_ihdr_narration                  [51],
            d_dn_ihdr_base_date                  [12],
            d_chk_ihdr_base_date                 [12],
            d_dn_ihdr_due_date                   [12],
            d_chk_ihdr_due_date                  [12],
/o            d_dn_ihdr_gross_amt                  [19],o/
            d_chk_ihdr_gross_amt                 [19],
/o            d_dn_ihdr_payable_amt                [19],o/
            d_chk_ihdr_payable_amt                [19],
/o            d_dn_ihdr_discount_amt               [19],o/
/o            d_dn_ihdr_doc_amt                    [19],o/
            d_dn_ihdr_doc_amt_chk                [19],
            d_dn_ihdr_currency_code              [19],
            d_dn_ihdr_exchg_rate                 [20],
            d_dn_ihdr_pmnt_terms_code            [3],
            d_dn_ihdr_settlement_date            [12],
            d_chk_ihdr_settlement_date           [12],
            d_dn_ihdr_settlement_perc            [7],
            d_dn_ihdr_cust_ref                   [16],
            d_dn_ihdr_patient_id                 [21],
            d_dn_ihdr_billing_group              [5],   -- CRF-0120
            d_dn_ihdr_bill_doc_type_code         [7],
            d_dn_ihdr_bill_num                   [9],
            d_dn_ihdr_bill_date                  [12],
            d_chk_ihdr_bill_date                  [12],
/o            d_dn_ihdr_doctor_fee_amt             [19],o/
            d_dn_ihdr_main_acc1_code             [7],
            d_dn_ihdr_main_acc2_code             [5],
            d_dn_ihdr_sub_group_code       [4],
            d_dn_ihdr_sub_line_code        [9],
            d_dn_ihdr_dept_code                  [11],
            d_dn_ihdr_product_group_code         [4],
            d_dn_ihdr_product_line_code          [5],
            d_dn_ihdr_post_month                 [3],
            d_dn_ihdr_post_year                  [5],
            d_dn_ihdr_rowid                      [31],

            d_dn_line_acc_entity_code            [5],
            d_dn_line_doc_type_code              [7],
            d_dn_line_doc_num                    [9],
            d_dn_line_org_doc_type_code          [7],
            d_dn_line_org_doc_num                [9],
            d_dn_line_line_num                   [5],
            d_dn_line_main_acc1_code             [7],
            d_dn_line_main_acc2_code             [5],
            d_dn_line_sub_group_code       [4],
            d_dn_line_sub_line_code        [9],
            d_dn_line_dept_code                  [11],
            d_dn_line_product_group_code         [4],
            d_dn_line_product_line_code          [5],
/o            d_dn_line_amount                     [19],o/
            d_dn_line_amount_chk                 [19],
            d_dn_line_narration                  [51],
            d_dn_line_rowid                      [31],

            d_sy_acc_bl_instal_flag       [4],
            d_sy_acc_mp_instal_flag       [4],
            d_ar_acc_status               [2],
            d_ar_acc_valid_flag           [2],
            d_customer_status             [2],
            d_pmnt_terms_status           [2],
            d_bl_blng_grp_status          [2],
            d_curr_pgm_name                      [15],
            mast_status                          [2],
            d_chk_payable_amt                    [17],
            sy_doc_print_flag             [3],
            nd_error_flag    [2],
            dummy                                [10][10]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

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

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

struct { unsigned short len; unsigned char arr[7]; } d_dn_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dn_hdr_doc_num;

struct { unsigned short len; unsigned char arr[9]; } d_dn_hdr_cust_code;

struct { unsigned short len; unsigned char arr[12]; } d_dn_hdr_doc_date;

struct { unsigned short len; unsigned char arr[12]; } d_chk_hdr_doc_date;

struct { unsigned short len; unsigned char arr[12]; } d_dn_hdr_doc_date_chking;

struct { unsigned short len; unsigned char arr[5]; } d_dn_hdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[17]; } d_dn_hdr_doc_amt_chk;

struct { unsigned short len; unsigned char arr[3]; } d_dn_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_dn_hdr_post_year;

struct { unsigned short len; unsigned char arr[101]; } d_dn_hdr_misc_cust_long_name;

struct { unsigned short len; unsigned char arr[101]; } d_dn_hdr_misc_cust_sname;

struct { unsigned short len; unsigned char arr[61]; } d_dn_hdr_misc_cust_add1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_dn_hdr_misc_cust_add2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_dn_hdr_misc_cust_add3_desc;

struct { unsigned short len; unsigned char arr[31]; } d_dn_hdr_misc_cust_zip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_dn_hdr_misc_long_chinese;

struct { unsigned short len; unsigned char arr[101]; } d_dn_hdr_misc_short_chinese;

struct { unsigned short len; unsigned char arr[61]; } d_dn_hdr_misc_add1_chinese;

struct { unsigned short len; unsigned char arr[61]; } d_dn_hdr_misc_add2_chinese;

struct { unsigned short len; unsigned char arr[61]; } d_dn_hdr_misc_add3_chinese;

struct { unsigned short len; unsigned char arr[31]; } d_dn_hdr_misc_zip_chinese;

struct { unsigned short len; unsigned char arr[31]; } d_dn_hdr_tel_num;

struct { unsigned short len; unsigned char arr[101]; } d_dn_hdr_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_dn_hdr_contact_name_title;

struct { unsigned short len; unsigned char arr[2]; } d_dn_hdr_error_flag;

struct { unsigned short len; unsigned char arr[2]; } d_dn_hdr_print_flag;

struct { unsigned short len; unsigned char arr[31]; } d_dn_hdr_rowid;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[300]; } p_operational_modules;

struct { unsigned short len; unsigned char arr[2]; } d_consolidated_yn;

struct { unsigned short len; unsigned char arr[3]; } d_module_valid_id;

struct { unsigned short len; unsigned char arr[2]; } d_ar_flag;

struct { unsigned short len; unsigned char arr[5]; } curr_acc_year;

struct { unsigned short len; unsigned char arr[3]; } curr_acc_month;

struct { unsigned short len; unsigned char arr[2]; } gl_summ_pro_flag;

struct { unsigned short len; unsigned char arr[5]; } d_sy_num_acc_per;

struct { unsigned short len; unsigned char arr[3]; } prior_post_allow;

struct { unsigned short len; unsigned char arr[5]; } d_dn_ihdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[7]; } d_dn_ihdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dn_ihdr_doc_num;

struct { unsigned short len; unsigned char arr[7]; } d_dn_ihdr_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dn_ihdr_org_doc_num;

struct { unsigned short len; unsigned char arr[5]; } d_dn_ihdr_last_line_num;

struct { unsigned short len; unsigned char arr[8]; } d_dn_ihdr_cust_code;

struct { unsigned short len; unsigned char arr[51]; } d_dn_ihdr_narration;

struct { unsigned short len; unsigned char arr[12]; } d_dn_ihdr_base_date;

struct { unsigned short len; unsigned char arr[12]; } d_chk_ihdr_base_date;

struct { unsigned short len; unsigned char arr[12]; } d_dn_ihdr_due_date;

struct { unsigned short len; unsigned char arr[12]; } d_chk_ihdr_due_date;

struct { unsigned short len; unsigned char arr[19]; } d_chk_ihdr_gross_amt;

struct { unsigned short len; unsigned char arr[19]; } d_chk_ihdr_payable_amt;

struct { unsigned short len; unsigned char arr[19]; } d_dn_ihdr_doc_amt_chk;

struct { unsigned short len; unsigned char arr[19]; } d_dn_ihdr_currency_code;

struct { unsigned short len; unsigned char arr[20]; } d_dn_ihdr_exchg_rate;

struct { unsigned short len; unsigned char arr[3]; } d_dn_ihdr_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[12]; } d_dn_ihdr_settlement_date;

struct { unsigned short len; unsigned char arr[12]; } d_chk_ihdr_settlement_date;

struct { unsigned short len; unsigned char arr[7]; } d_dn_ihdr_settlement_perc;

struct { unsigned short len; unsigned char arr[16]; } d_dn_ihdr_cust_ref;

struct { unsigned short len; unsigned char arr[21]; } d_dn_ihdr_patient_id;

struct { unsigned short len; unsigned char arr[5]; } d_dn_ihdr_billing_group;

struct { unsigned short len; unsigned char arr[7]; } d_dn_ihdr_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dn_ihdr_bill_num;

struct { unsigned short len; unsigned char arr[12]; } d_dn_ihdr_bill_date;

struct { unsigned short len; unsigned char arr[12]; } d_chk_ihdr_bill_date;

struct { unsigned short len; unsigned char arr[7]; } d_dn_ihdr_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_dn_ihdr_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } d_dn_ihdr_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_dn_ihdr_sub_line_code;

struct { unsigned short len; unsigned char arr[11]; } d_dn_ihdr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_dn_ihdr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_dn_ihdr_product_line_code;

struct { unsigned short len; unsigned char arr[3]; } d_dn_ihdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_dn_ihdr_post_year;

struct { unsigned short len; unsigned char arr[31]; } d_dn_ihdr_rowid;

struct { unsigned short len; unsigned char arr[5]; } d_dn_line_acc_entity_code;

struct { unsigned short len; unsigned char arr[7]; } d_dn_line_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dn_line_doc_num;

struct { unsigned short len; unsigned char arr[7]; } d_dn_line_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dn_line_org_doc_num;

struct { unsigned short len; unsigned char arr[5]; } d_dn_line_line_num;

struct { unsigned short len; unsigned char arr[7]; } d_dn_line_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_dn_line_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } d_dn_line_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_dn_line_sub_line_code;

struct { unsigned short len; unsigned char arr[11]; } d_dn_line_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_dn_line_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_dn_line_product_line_code;

struct { unsigned short len; unsigned char arr[19]; } d_dn_line_amount_chk;

struct { unsigned short len; unsigned char arr[51]; } d_dn_line_narration;

struct { unsigned short len; unsigned char arr[31]; } d_dn_line_rowid;

struct { unsigned short len; unsigned char arr[4]; } d_sy_acc_bl_instal_flag;

struct { unsigned short len; unsigned char arr[4]; } d_sy_acc_mp_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } d_ar_acc_status;

struct { unsigned short len; unsigned char arr[2]; } d_ar_acc_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } d_customer_status;

struct { unsigned short len; unsigned char arr[2]; } d_pmnt_terms_status;

struct { unsigned short len; unsigned char arr[2]; } d_bl_blng_grp_status;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } mast_status;

struct { unsigned short len; unsigned char arr[17]; } d_chk_payable_amt;

struct { unsigned short len; unsigned char arr[3]; } sy_doc_print_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_error_flag;

struct { unsigned short len; unsigned char arr[10]; } dummy[10];



   /* VARCHAR  ar_interface_code[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } ar_interface_code;

 
   char  temp_var[1000];

   double   nd_dtl_tot_amt,
            nd_doc_tot_amt,
            amt_local,

            d_dn_line_amount,
            d_dn_hdr_doc_amt,
            d_dn_ihdr_doc_amt,
            d_dn_ihdr_doctor_fee_amt,
            d_dn_ihdr_discount_amt,
            d_dn_ihdr_payable_amt,
            d_dn_ihdr_gross_amt;



   int    bl_instal_flag ,  mp_instal_flag, nd_no_of_dec;
   char  filename[150];

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

int       open_line_cur = 0;

char      d_customer_patient_flag       [2];

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

   if (argc != 6)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
      proc_exit();
   }
 
   if (argv[5][0] == 'R')
      {strcpy(g_pgm_id,"ARRDNLST");
       strcpy(OUTPUT_FILE_NAME,"ARRDNLST.LIS");
      }  
   else
      {strcpy(g_pgm_id,"ARBDNPST");
       strcpy(OUTPUT_FILE_NAME,"ARBDNPST.LIS");
      } 

   strcpy(d_curr_pgm_name.arr,g_pgm_id); 
   d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

   

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

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
   /*strcpy(g_pgm_date,argv[3]); Added By Rajesh kanna for 49827 */
   
   
   strncpy(g_pgm_date,argv[3],10);
   
   strcpy(d_facility_id.arr, argv[4]);
	d_facility_id.len = strlen(d_facility_id.arr);

   set_meduser_role();
 
 strcpy(g_facility_id, d_facility_id.arr); /* Added by Rajesh kanna for 49827 */
 
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
   nd_hosp_name.arr[0]='\0'; 

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   nd_proc_flag.len         = 0;
   nd_view_print_flg.len    = 0;
   nd_facility_id.len       = 0;
   nd_hosp_name.len = 0; 
   process_rep_flg          = 0;
 
   /* EXEC SQL SELECT OPERATING_FACILITY_ID , PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM8,
                   PARAM9,PARAM10
              INTO :nd_facility_id, :nd_fm_doc_type, :nd_fm_doc_num, :nd_fm_doc_date,
                   :nd_to_doc_type, :nd_to_doc_num, :nd_to_doc_date,
                   :nd_proc_flag,
                   :nd_view_print_flg, :process_rep_flg
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBDNPST'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM8 ,PARAM9 ,PARAM10 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:\
b7,:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='ARBDNPST' and SESSION_ID=:b10) \
and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
  sqlstm.stmt = "select ('Facility Name : '||ACC_ENTITY_NAME) into :b0  from\
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
   nd_facility_id.arr[nd_facility_id.len]        = '\0';
   nd_hosp_name.arr[nd_hosp_name.len]        = '\0'; 


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
 disp_message(INFO_MESG,nd_hosp_name.arr);
disp_message(INFO_MESG,"\n"); 
   
   ar_declare_cursor();    
   

   while (fetch_cur())
   {
      strcpy(nd_error_flag.arr,"N");
      nd_error_flag.len = 1;

      nd_doc_tot_amt     = 0;

      if (!fetch_rec())    /* Fetch all the details & lock Hdr row */
          continue;

      validate_dn_header();

      if (!open_cur_dn_ihdr())  /* Open inv header                    */
           continue;            /* Returns 1 if Lines are locked      */

      open_line_cur = 0;

      while (fetch_dn_inv_hdr1())
      {
         nd_dtl_tot_amt     = 0;

         validate_dn_inv_header();

         if (!open_cur_dn_line()) /* Open lines                         */
         {                        /* Returns 1 if Lines are locked      */
            open_line_cur = 1;
            break;
         }
 
         while (fetch_dn_line1())
             validate_dn_line();

         validate_dn_inv_amt();
      }

      if (open_line_cur)
            continue;

      validate_dn_amt();

      update_err_flg();
      
      if (nd_proc_flag.arr[0] == 'A')   
      {
#ifdef DEBUG
    disp_message(INFO_MESG,"Processing option\n");
#endif
          if (nd_error_flag.arr[0] == 'N')
          {        
             
             gl_doc_insert(d_dn_hdr_rowid.arr,ar_interface_code.arr,'D','D');

             if (ar_interface_code.arr[0] == 'O')
             {
#ifdef DEBUG
    disp_message(INFO_MESG,"Not Online GL interface\n");
#endif
                  
				  
				  gl_posting();

				  ins_gl_distrbn(d_dn_hdr_doc_type_code.arr,d_dn_hdr_doc_num.arr,2,nd_facility_id.arr); /* nd_facility_id added by madhusudhan for gdoh-crf-0107*/ 


/*    Commented on 15-MAR-93 as per request by GL team 

      if (!  (atoi(d_dn_hdr_post_year.arr) > atoi(curr_acc_year.arr)) ||
            ( atoi(d_dn_hdr_post_year.arr) == atoi(curr_acc_year.arr) && 
              atoi(d_dn_hdr_post_month.arr) > atoi(curr_acc_month.arr) )  )
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

//   run_report();

   if(sql_connect() == -1)
   {
      disp_message(INFO_MESG,"OERROR in connecting to Oracle 2 time\n");
      exit(0);
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
   disp_message(INFO_MESG,"Before Declaring cursors ...\n");
#endif


/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY VSK 14/11/1999 */
/*SATHISH ADDED OPERATING_FACILITY_ID = :nd_facility_id FOR GDOH-CRF-0107 ON 24-01-2017*/

   /* EXEC SQL DECLARE CUR_DN_HDR CURSOR FOR
             SELECT DOC_TYPE_CODE, DOC_NUM
               FROM AR_DN_HDR
              WHERE OPERATING_FACILITY_ID = :nd_facility_id
			    AND DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
                AND NVL(POSTED_FLAG,'N') = 'N'; */ 


   /* EXEC SQL OPEN CUR_DN_HDR; */ 

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
         err_mesg("OPEN failed on cursor CUR_DN_HDR",0,"");

   /* EXEC SQL DECLARE CUR_DN_REC CURSOR FOR
             SELECT ACC_ENTITY_CODE,
                    CUST_CODE,
                    DOC_DATE,
                    TO_CHAR(DOC_DATE,'YYYYMMDD'),
                    DOC_AMT,
                    DOC_AMT,
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
                    PRINT_FLAG,
                    ROWID
               FROM AR_DN_HDR
              WHERE OPERATING_FACILITY_ID = :nd_facility_id 
			    AND DOC_TYPE_CODE = :d_dn_hdr_doc_type_code
                AND DOC_NUM       = :d_dn_hdr_doc_num
                FOR UPDATE OF ERROR_FLAG NOWAIT; */ 


   /* EXEC SQL DECLARE CUR_DN_INV_HDR CURSOR FOR
             SELECT ACC_ENTITY_CODE,
                    DOC_TYPE_CODE,
                    DOC_NUM,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    LAST_LINE_NUM,
                    CUST_CODE,
                    NARRATION,
                    BASE_DATE,
                    TO_CHAR(BASE_DATE,'YYYYMMDD'),
                    DUE_DATE,
                    TO_CHAR(DUE_DATE,'YYYYMMDD'),
                    GROSS_AMT,
                    GROSS_AMT,
                    PAYABLE_AMT,
                    PAYABLE_AMT,
                    DISCOUNT_AMT,
                    DOC_AMT,
                    DOC_AMT,
                    CURRENCY_CODE,
                    EXCHG_RATE,
                    PMNT_TERMS_CODE,
                    SETTLEMENT_DATE,
                    TO_CHAR(SETTLEMENT_DATE,'YYYYMMDD'),
                    SETTLEMENT_PERC,
                    CUST_REF,
                    PATIENT_ID,
                    BILLING_GROUP,
                    BILL_DOC_TYPE_CODE,
                    BILL_NUM,
                    BILL_DATE,
                    TO_CHAR(BILL_DATE,'YYYYMMDD'),
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
                    ROWID,
					CONSOLIDATED_INV_YN
               FROM AR_DN_INV_HDR
              WHERE OPERATING_FACILITY_ID = :nd_facility_id 
			    AND DOC_TYPE_CODE = :d_dn_hdr_doc_type_code
                AND DOC_NUM       = :d_dn_hdr_doc_num
                FOR UPDATE OF LAST_LINE_NUM NOWAIT; */ 


   /* EXEC SQL DECLARE CUR_AR_DN_LINE  CURSOR FOR
             SELECT ACC_ENTITY_CODE,
                    DOC_TYPE_CODE,
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
                    AMOUNT,
                    NARRATION,
                    ROWID
               FROM AR_DN_LINE
              WHERE OPERATING_FACILITY_ID = :nd_facility_id 
			    AND DOC_TYPE_CODE     = :d_dn_hdr_doc_type_code
                AND DOC_NUM           = :d_dn_hdr_doc_num
                AND ORG_DOC_TYPE_CODE = :d_dn_ihdr_org_doc_type_code
                AND ORG_DOC_NUM       = :d_dn_ihdr_org_doc_num
                FOR UPDATE OF LINE_NUM NOWAIT; */ 


#ifdef DEBUG
   disp_message(INFO_MESG,"After Declaring  & opening cursor CUR_DN_HDR...\n");
#endif
}

open_cur_dn_ihdr()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"inside open cur_dn_ihdr\n");
#endif
      /* EXEC SQL OPEN CUR_DN_INV_HDR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 12;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0008;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )179;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_dn_hdr_doc_num;
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
           error_insert("9999","AR2070");
           update_err_flg();
           /* EXEC SQL COMMIT WORK; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 12;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )206;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


           return (0);
       }
       else if (OERROR)
            err_mesg("OPEN failed on cursor CUR_DN_INV_HDR",0,"");

#ifdef DEBUG
  disp_message(INFO_MESG,"after open cur_dn_ihdr\n");
#endif
    return (1);
}

open_cur_dn_line()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"inside open cur_dn_line\n");
#endif

       /* EXEC SQL OPEN CUR_AR_DN_LINE; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 12;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0009;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )221;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
       sqlstm.sqhstl[0] = (unsigned int  )5;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_dn_hdr_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )11;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_dn_ihdr_org_doc_type_code;
       sqlstm.sqhstl[3] = (unsigned int  )9;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_dn_ihdr_org_doc_num;
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



       if (RESOURCE_BUSY)
       {
            error_insert("9998","AR2070");
            update_err_flg();
            /* EXEC SQL COMMIT WORK; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 12;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )256;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


            return (0);
       }
       else if (OERROR)
             err_mesg("OPEN failed on cursor CUR_AR_DN_LINE",0,"");

#ifdef DEBUG
  disp_message(INFO_MESG,"after open cur_dn_line\n");
#endif
   return (1);
}

fetch_cur()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Fetch rec...\n");
#endif

   d_dn_hdr_doc_type_code.arr[0]     = '\0';
   d_dn_hdr_doc_num.arr[0]           = '\0';

   d_dn_hdr_doc_type_code.len        = 0;
   d_dn_hdr_doc_num.len              = 0;


   /* EXEC SQL FETCH CUR_DN_HDR 
             INTO :d_dn_hdr_doc_type_code, :d_dn_hdr_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )271;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_dn_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_doc_num;
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
         err_mesg("FETCH failed on cursor CUR_DN_HDR",0,"");

   d_dn_hdr_doc_type_code.arr[d_dn_hdr_doc_type_code.len]     = '\0';
   d_dn_hdr_doc_num.arr[d_dn_hdr_doc_num.len]                 = '\0';

#ifdef DEBUG
    sprintf(string_var," Doc type is <%s> Doc num is <%s>\n",d_dn_hdr_doc_type_code.arr,
                  d_dn_hdr_doc_num.arr); 
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


d_dn_hdr_acc_entity_code.arr[0]           = '\0';
d_dn_hdr_cust_code.arr[0]                 = '\0';
d_dn_hdr_doc_date.arr[0]                  = '\0';
d_chk_hdr_doc_date.arr[0]                 = '\0';
/*d_dn_hdr_doc_amt.arr[0]                 = '\0';*/
d_dn_hdr_doc_amt_chk.arr[0]               = '\0';
d_dn_hdr_post_month.arr[0]                = '\0';
d_dn_hdr_post_year.arr[0]                 = '\0';
d_dn_hdr_misc_cust_long_name.arr[0]       = '\0';
d_dn_hdr_misc_cust_sname.arr[0]      = '\0';
d_dn_hdr_misc_cust_add1_desc.arr[0]       = '\0';
d_dn_hdr_misc_cust_add2_desc.arr[0]       = '\0';
d_dn_hdr_misc_cust_add3_desc.arr[0]       = '\0';
d_dn_hdr_misc_cust_zip_desc.arr[0]        = '\0';
d_dn_hdr_misc_long_chinese.arr[0]         = '\0';
d_dn_hdr_misc_short_chinese.arr[0]        = '\0';
d_dn_hdr_misc_add1_chinese.arr[0]         = '\0';
d_dn_hdr_misc_add2_chinese.arr[0]         = '\0';
d_dn_hdr_misc_add3_chinese.arr[0]         = '\0';
d_dn_hdr_misc_zip_chinese.arr[0]          = '\0';
d_dn_hdr_tel_num.arr[0]                   = '\0';
d_dn_hdr_contact_name.arr[0]              = '\0';
d_dn_hdr_contact_name_title.arr[0]        = '\0';
d_dn_hdr_error_flag.arr[0]                = '\0';
d_dn_hdr_print_flag.arr[0]                = '\0';
d_dn_hdr_rowid.arr[0]                     = '\0';

d_dn_hdr_acc_entity_code.len              = 0;
d_dn_hdr_cust_code.len                    = 0;
d_dn_hdr_doc_date.len                     = 0;
d_chk_hdr_doc_date.len                    = 0;
/*d_dn_hdr_doc_amt.len                    = 0;*/
d_dn_hdr_doc_amt_chk.len                  = 0;
d_dn_hdr_post_month.len                   = 0;
d_dn_hdr_post_year.len                    = 0;
d_dn_hdr_misc_cust_long_name.len          = 0;
d_dn_hdr_misc_cust_sname.len         = 0;
d_dn_hdr_misc_cust_add1_desc.len          = 0;
d_dn_hdr_misc_cust_add2_desc.len          = 0;
d_dn_hdr_misc_cust_add3_desc.len          = 0;
d_dn_hdr_misc_cust_zip_desc.len           = 0;
d_dn_hdr_misc_long_chinese.len            = 0;
d_dn_hdr_misc_short_chinese.len           = 0;
d_dn_hdr_misc_add1_chinese.len            = 0;
d_dn_hdr_misc_add2_chinese.len            = 0;
d_dn_hdr_misc_add3_chinese.len            = 0;
d_dn_hdr_misc_zip_chinese.len             = 0;
d_dn_hdr_tel_num.len                      = 0;
d_dn_hdr_contact_name.len                 = 0;
d_dn_hdr_contact_name_title.len           = 0;
d_dn_hdr_error_flag.len                   = 0;
d_dn_hdr_print_flag.len                   = 0;
d_dn_hdr_rowid.len                        = 0;

d_dn_hdr_doc_amt                          = 0;

   /* EXEC SQL OPEN CUR_DN_REC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )294;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_dn_hdr_doc_num;
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
         err_mesg("OPEN failed on cursor CUR_DN_REC",0,"");

   /* EXEC SQL FETCH   CUR_DN_REC
             INTO   :d_dn_hdr_acc_entity_code,
                    :d_dn_hdr_cust_code,
                    :d_dn_hdr_doc_date,
                    :d_chk_hdr_doc_date,
                    :d_dn_hdr_doc_amt,
                    :d_dn_hdr_doc_amt_chk,
                    :d_dn_hdr_post_month,
                    :d_dn_hdr_post_year,
                    :d_dn_hdr_misc_cust_long_name,
                    :d_dn_hdr_misc_cust_sname,
                    :d_dn_hdr_misc_cust_add1_desc,
                    :d_dn_hdr_misc_cust_add2_desc,
                    :d_dn_hdr_misc_cust_add3_desc,
                    :d_dn_hdr_misc_cust_zip_desc,
                    :d_dn_hdr_misc_long_chinese,
                    :d_dn_hdr_misc_short_chinese,
                    :d_dn_hdr_misc_add1_chinese,
                    :d_dn_hdr_misc_add2_chinese,
                    :d_dn_hdr_misc_add3_chinese,
                    :d_dn_hdr_misc_zip_chinese,
                    :d_dn_hdr_tel_num,
                    :d_dn_hdr_contact_name,
                    :d_dn_hdr_contact_name_title,
                    :d_dn_hdr_error_flag,
                    :d_dn_hdr_print_flag,
                    :d_dn_hdr_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 26;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )321;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_dn_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_dn_hdr_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_chk_hdr_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_dn_hdr_doc_amt;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_dn_hdr_doc_amt_chk;
   sqlstm.sqhstl[5] = (unsigned int  )19;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_dn_hdr_post_month;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_dn_hdr_post_year;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_dn_hdr_misc_cust_long_name;
   sqlstm.sqhstl[8] = (unsigned int  )103;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_dn_hdr_misc_cust_sname;
   sqlstm.sqhstl[9] = (unsigned int  )103;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_dn_hdr_misc_cust_add1_desc;
   sqlstm.sqhstl[10] = (unsigned int  )63;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_dn_hdr_misc_cust_add2_desc;
   sqlstm.sqhstl[11] = (unsigned int  )63;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_dn_hdr_misc_cust_add3_desc;
   sqlstm.sqhstl[12] = (unsigned int  )63;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_dn_hdr_misc_cust_zip_desc;
   sqlstm.sqhstl[13] = (unsigned int  )33;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_dn_hdr_misc_long_chinese;
   sqlstm.sqhstl[14] = (unsigned int  )103;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_dn_hdr_misc_short_chinese;
   sqlstm.sqhstl[15] = (unsigned int  )103;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_dn_hdr_misc_add1_chinese;
   sqlstm.sqhstl[16] = (unsigned int  )63;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_dn_hdr_misc_add2_chinese;
   sqlstm.sqhstl[17] = (unsigned int  )63;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_dn_hdr_misc_add3_chinese;
   sqlstm.sqhstl[18] = (unsigned int  )63;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_dn_hdr_misc_zip_chinese;
   sqlstm.sqhstl[19] = (unsigned int  )33;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_dn_hdr_tel_num;
   sqlstm.sqhstl[20] = (unsigned int  )33;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_dn_hdr_contact_name;
   sqlstm.sqhstl[21] = (unsigned int  )103;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_dn_hdr_contact_name_title;
   sqlstm.sqhstl[22] = (unsigned int  )63;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_dn_hdr_error_flag;
   sqlstm.sqhstl[23] = (unsigned int  )4;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_dn_hdr_print_flag;
   sqlstm.sqhstl[24] = (unsigned int  )4;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_dn_hdr_rowid;
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
         err_mesg("FETCH failed on cursor CUR_DN_REC",0,"");

d_dn_hdr_acc_entity_code.arr[d_dn_hdr_acc_entity_code.len]             = '\0';
d_dn_hdr_cust_code.arr[d_dn_hdr_cust_code.len]                         = '\0';
d_dn_hdr_doc_date.arr[d_dn_hdr_doc_date.len]                           = '\0';
d_chk_hdr_doc_date.arr[d_chk_hdr_doc_date.len]                         = '\0';
/*d_dn_hdr_doc_amt.arr[d_dn_hdr_doc_amt.len]                           = '\0';*/
d_dn_hdr_doc_amt_chk.arr[d_dn_hdr_doc_amt_chk.len]                     = '\0';
d_dn_hdr_post_month.arr[d_dn_hdr_post_month.len]                       = '\0';
d_dn_hdr_post_year.arr[d_dn_hdr_post_year.len]                         = '\0';
d_dn_hdr_misc_cust_long_name.arr[d_dn_hdr_misc_cust_long_name.len]     = '\0';
d_dn_hdr_misc_cust_sname.arr[d_dn_hdr_misc_cust_sname.len]   = '\0';
d_dn_hdr_misc_cust_add1_desc.arr[d_dn_hdr_misc_cust_add1_desc.len]     = '\0';
d_dn_hdr_misc_cust_add2_desc.arr[d_dn_hdr_misc_cust_add2_desc.len]     = '\0';
d_dn_hdr_misc_cust_add3_desc.arr[d_dn_hdr_misc_cust_add3_desc.len]     = '\0';
d_dn_hdr_misc_cust_zip_desc.arr[d_dn_hdr_misc_cust_zip_desc.len]       = '\0';
d_dn_hdr_misc_long_chinese.arr[d_dn_hdr_misc_long_chinese.len]         = '\0';
d_dn_hdr_misc_short_chinese.arr[d_dn_hdr_misc_short_chinese.len]       = '\0';
d_dn_hdr_misc_add1_chinese.arr[d_dn_hdr_misc_add1_chinese.len]         = '\0';
d_dn_hdr_misc_add2_chinese.arr[d_dn_hdr_misc_add2_chinese.len]         = '\0';
d_dn_hdr_misc_add3_chinese.arr[d_dn_hdr_misc_add3_chinese.len]         = '\0';
d_dn_hdr_misc_zip_chinese.arr[d_dn_hdr_misc_zip_chinese.len]           = '\0';
d_dn_hdr_tel_num.arr[d_dn_hdr_tel_num.len]                             = '\0';
d_dn_hdr_contact_name.arr[d_dn_hdr_contact_name.len]                   = '\0';
d_dn_hdr_contact_name_title.arr[d_dn_hdr_contact_name_title.len]       = '\0';
d_dn_hdr_error_flag.arr[d_dn_hdr_error_flag.len]                       = '\0';
d_dn_hdr_print_flag.arr[d_dn_hdr_print_flag.len]                       = '\0';
d_dn_hdr_rowid.arr[d_dn_hdr_rowid.len]                                 = '\0';


#ifdef DEBUG
   disp_message(INFO_MESG,"After null termination fetch rec\n");
#endif

   return(sqlca.sqlerrd[2]);
}
  
validate_dn_header()
{

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Val dn header...\n");
#endif

strcpy(d_ar_flag.arr , "\0");

validate_ar_header(
            d_dn_hdr_doc_type_code.arr, 
            d_dn_hdr_doc_num.arr,
            d_dn_hdr_cust_code.arr,
            d_dn_hdr_doc_date.arr,
            d_dn_hdr_doc_amt_chk.arr,
            d_dn_hdr_post_month.arr,
            d_dn_hdr_post_year.arr,
            d_dn_hdr_print_flag.arr,
            atoi(curr_acc_year.arr),
            atoi(curr_acc_month.arr),
            atoi(d_sy_num_acc_per.arr),
            nd_proc_flag.arr,
            prior_post_allow.arr,
            d_customer_patient_flag,
            'D',
			d_ar_flag.arr,
			nd_facility_id.arr /*Added for GDOH-CRF-0107*/
);

#ifdef DEBUG
   disp_message(INFO_MESG,"After Val inv header...\n");
#endif
}

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


#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Check bank reconcile\n");
#endif

  if (ind == 0)
  {
      strcpy(l_main_acc1.arr,d_dn_ihdr_main_acc1_code.arr);
      strcpy(l_main_acc2.arr,d_dn_ihdr_main_acc2_code.arr);
  }
  else
  {
      strcpy(l_main_acc1.arr,d_dn_line_main_acc1_code.arr);
      strcpy(l_main_acc2.arr,d_dn_line_main_acc2_code.arr);
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
  sqlstm.arrsiz = 26;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select BANK_RECONCILE_FLAG into :b0  from GL_ACC_CHART wher\
e (MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )440;
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
         sqlstm.arrsiz = 26;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select 'X' into :b0  from GL_BB_TXN_HDR where (MAIN_\
ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2)";
         sqlstm.iters = (unsigned int  )10;
         sqlstm.offset = (unsigned int  )467;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)dummy;
         sqlstm.sqhstl[0] = (unsigned int  )12;
         sqlstm.sqhsts[0] = (         int  )12;
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
#ifdef DEBUG
   disp_message(INFO_MESG,"after Checking bank reconcile\n");
#endif
  fflush(stdout);
}
            
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

      if(validate_posting_acct( d_dn_ihdr_main_acc1_code.arr,
                                d_dn_ihdr_main_acc2_code.arr,
                                d_dn_ihdr_dept_code.arr,
                                d_dn_ihdr_product_group_code.arr,
                                d_dn_ihdr_product_line_code.arr,
                                d_dn_ihdr_sub_group_code.arr,
                                d_dn_ihdr_sub_line_code.arr,
                                'Y',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
                                atol(d_dn_ihdr_post_year.arr),
								atol(d_dn_ihdr_post_month.arr),
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


      if(validate_posting_acct( d_dn_line_main_acc1_code.arr,
                                d_dn_line_main_acc2_code.arr,
                                d_dn_line_dept_code.arr,
                                d_dn_line_product_group_code.arr,
                                d_dn_line_product_line_code.arr,
                                d_dn_line_sub_group_code.arr,
                                d_dn_line_sub_line_code.arr,
                                'Y',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
                                atol(d_dn_ihdr_post_year.arr),
								atol(d_dn_ihdr_post_month.arr),
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

#ifdef DEBUG
  disp_message(INFO_MESG,"After valiate posting acc...\n");
#endif

}

validate_dn_inv_header()
{
   char chk1_arr[30],chk2_arr[30];
  
validate_ar_inv_header(                       /* Genl. fn available in    */
            d_dn_ihdr_doc_type_code.arr,      /* ar_valid.pc              */
            d_dn_ihdr_doc_num.arr,
            d_dn_ihdr_org_doc_type_code.arr, 
            d_dn_ihdr_org_doc_num.arr,
            d_dn_ihdr_cust_code.arr,
            d_chk_hdr_doc_date.arr,
            d_chk_ihdr_due_date.arr,
            d_chk_ihdr_settlement_date.arr,
            d_dn_ihdr_settlement_perc.arr,
            d_dn_ihdr_doc_amt,
            d_dn_ihdr_doc_amt_chk.len,
            d_dn_ihdr_gross_amt,
            d_chk_ihdr_gross_amt.len,
            d_dn_ihdr_payable_amt,
            d_chk_ihdr_payable_amt.len,
            d_dn_ihdr_discount_amt,
            d_chk_ihdr_bill_date.arr,
            d_dn_ihdr_doctor_fee_amt,
            d_dn_ihdr_pmnt_terms_code.arr,
            d_dn_ihdr_bill_num.len,
            d_sy_acc_bl_instal_flag.arr,
            d_sy_acc_mp_instal_flag.arr,
            d_customer_patient_flag,
            d_dn_ihdr_bill_doc_type_code.arr,
            d_dn_ihdr_billing_group.arr,
            d_dn_ihdr_patient_id.arr,
            d_chk_ihdr_base_date.arr,
            'D',
            'D',
			d_consolidated_yn.arr,
			nd_facility_id.arr  /*Added for GDOH-CRF-0107*/
);

   validate_posting("   0",0);

#ifdef DEBUG
   disp_message(INFO_MESG,"After validate posting\n");
#endif

/*  Commented since validate_posting_acct is doing this validation */

/*   check_bank_reconcile("   0",0); */

#ifdef DEBUG
   sprintf(string_var," Doc tot amt is <%f> ihdr_doc_amt is <%f>\n",
            nd_doc_tot_amt,d_dn_ihdr_doc_amt);   
            disp_message(INFO_MESG,string_var);
#endif

   fflush(stdout);

   nd_doc_tot_amt += d_dn_ihdr_doc_amt;

#ifdef DEBUG
   disp_message(INFO_MESG,"after validate dn inv header\n");
#endif

}

fetch_dn_inv_hdr1()
{

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside fetch dn inv header\n");
#endif

d_dn_ihdr_acc_entity_code.arr[0]           = '\0';
d_dn_ihdr_doc_type_code.arr[0]             = '\0';
d_dn_ihdr_doc_num.arr[0]                   = '\0';
d_dn_ihdr_org_doc_type_code.arr[0]         = '\0';
d_dn_ihdr_org_doc_num.arr[0]               = '\0';
d_dn_ihdr_last_line_num.arr[0]             = '\0';
d_dn_ihdr_cust_code.arr[0]                 = '\0';
d_dn_ihdr_narration.arr[0]                 = '\0';
d_dn_ihdr_base_date.arr[0]                 = '\0';
d_chk_ihdr_base_date.arr[0]                = '\0';
d_dn_ihdr_due_date.arr[0]                  = '\0';
d_chk_ihdr_due_date.arr[0]                 = '\0';
/*d_dn_ihdr_gross_amt.arr[0]               = '\0';*/
d_chk_ihdr_gross_amt.arr[0]                = '\0';
/*d_dn_ihdr_payable_amt.arr[0]             = '\0';*/
d_chk_ihdr_payable_amt.arr[0]              = '\0';
/*d_dn_ihdr_discount_amt.arr[0]            = '\0';*/
/*d_dn_ihdr_doc_amt.arr[0]                 = '\0';*/
d_dn_ihdr_doc_amt_chk.arr[0]               = '\0';
d_dn_ihdr_currency_code.arr[0]             = '\0';
d_dn_ihdr_exchg_rate.arr[0]                = '\0';
d_dn_ihdr_pmnt_terms_code.arr[0]           = '\0';
d_dn_ihdr_settlement_date.arr[0]           = '\0';
d_chk_ihdr_settlement_date.arr[0]          = '\0';
d_dn_ihdr_settlement_perc.arr[0]           = '\0';
d_dn_ihdr_cust_ref.arr[0]                  = '\0';
d_dn_ihdr_patient_id.arr[0]                = '\0';
d_dn_ihdr_billing_group.arr[0]             = '\0';
d_dn_ihdr_bill_doc_type_code.arr[0]        = '\0';
d_dn_ihdr_bill_num.arr[0]                  = '\0';
d_dn_ihdr_bill_date.arr[0]                 = '\0';
d_chk_ihdr_bill_date.arr[0]                = '\0';
/*d_dn_ihdr_doctor_fee_amt.arr[0]          = '\0';*/
d_dn_ihdr_main_acc1_code.arr[0]            = '\0';
d_dn_ihdr_main_acc2_code.arr[0]            = '\0';
d_dn_ihdr_sub_group_code.arr[0]      = '\0';
d_dn_ihdr_sub_line_code.arr[0]       = '\0';
d_dn_ihdr_dept_code.arr[0]                 = '\0';
d_dn_ihdr_product_group_code.arr[0]        = '\0';
d_dn_ihdr_product_line_code.arr[0]         = '\0';
d_dn_ihdr_post_month.arr[0]                = '\0';
d_dn_ihdr_post_year.arr[0]                 = '\0';
d_dn_ihdr_rowid.arr[0]                     = '\0';
d_consolidated_yn.arr[0]   = '\0';

d_dn_ihdr_acc_entity_code.len              = 0;
d_dn_ihdr_doc_type_code.len                = 0;
d_dn_ihdr_doc_num.len                      = 0;
d_dn_ihdr_org_doc_type_code.len            = 0;
d_dn_ihdr_org_doc_num.len                  = 0;
d_dn_ihdr_last_line_num.len                = 0;
d_dn_ihdr_cust_code.len                    = 0;
d_dn_ihdr_narration.len                    = 0;
d_dn_ihdr_base_date.len                    = 0;
d_chk_ihdr_base_date.len                   = 0;
d_dn_ihdr_due_date.len                     = 0;
d_chk_ihdr_due_date.len                    = 0;
/*d_dn_ihdr_gross_amt.len                  = 0;*/
d_chk_ihdr_gross_amt.len                   = 0;
/*d_dn_ihdr_payable_amt.len                = 0;*/
d_chk_ihdr_payable_amt.len                 = 0;
/*d_dn_ihdr_discount_amt.len               = 0;*/
/*d_dn_ihdr_doc_amt.len                    = 0;*/
d_dn_ihdr_doc_amt_chk.len                  = 0;
d_dn_ihdr_currency_code.len                = 0;
d_dn_ihdr_exchg_rate.len                   = 0;
d_dn_ihdr_pmnt_terms_code.len              = 0;
d_dn_ihdr_settlement_date.len              = 0;
d_chk_ihdr_settlement_date.len             = 0;
d_dn_ihdr_settlement_perc.len              = 0;
d_dn_ihdr_cust_ref.len                     = 0;
d_dn_ihdr_patient_id.len                   = 0;
d_dn_ihdr_billing_group.len                = 0;
d_dn_ihdr_bill_doc_type_code.len           = 0;
d_dn_ihdr_bill_num.len                     = 0;
d_dn_ihdr_bill_date.len                    = 0;
d_chk_ihdr_bill_date.len                   = 0;
/*d_dn_ihdr_doctor_fee_amt.len             = 0;*/
d_dn_ihdr_main_acc1_code.len               = 0;
d_dn_ihdr_main_acc2_code.len               = 0;
d_dn_ihdr_sub_group_code.len         = 0;
d_dn_ihdr_sub_line_code.len          = 0;
d_dn_ihdr_dept_code.len                    = 0;
d_dn_ihdr_product_group_code.len           = 0;
d_dn_ihdr_product_line_code.len            = 0;
d_dn_ihdr_post_month.len                   = 0;
d_dn_ihdr_post_year.len                    = 0;
d_dn_ihdr_rowid.len                        = 0;
d_consolidated_yn.len   = 0;

d_dn_ihdr_discount_amt                     = 0;
d_dn_ihdr_payable_amt                      = 0;
d_dn_ihdr_gross_amt                        = 0;
d_dn_ihdr_doctor_fee_amt                   = 0;
d_dn_ihdr_doc_amt                          = 0;

#ifdef DEBUG
      disp_message(INFO_MESG,"Before fetching rec from ar_dn_inv_hdr\n");
#endif

      /* EXEC SQL FETCH CUR_DN_INV_HDR
                INTO :d_dn_ihdr_acc_entity_code,
                     :d_dn_ihdr_doc_type_code,
                     :d_dn_ihdr_doc_num,
                     :d_dn_ihdr_org_doc_type_code,
                     :d_dn_ihdr_org_doc_num,
                     :d_dn_ihdr_last_line_num,
                     :d_dn_ihdr_cust_code,
                     :d_dn_ihdr_narration,
                     :d_dn_ihdr_base_date,
                     :d_chk_ihdr_base_date,
                     :d_dn_ihdr_due_date,
                     :d_chk_ihdr_due_date,
                     :d_dn_ihdr_gross_amt,
                     :d_chk_ihdr_gross_amt,
                     :d_dn_ihdr_payable_amt,
                     :d_chk_ihdr_payable_amt,
                     :d_dn_ihdr_discount_amt,
                     :d_dn_ihdr_doc_amt,
                     :d_dn_ihdr_doc_amt_chk,
                     :d_dn_ihdr_currency_code,
                     :d_dn_ihdr_exchg_rate,
                     :d_dn_ihdr_pmnt_terms_code,
                     :d_dn_ihdr_settlement_date,
                     :d_chk_ihdr_settlement_date,
                     :d_dn_ihdr_settlement_perc,
                     :d_dn_ihdr_cust_ref,
                     :d_dn_ihdr_patient_id,
                     :d_dn_ihdr_billing_group,
                     :d_dn_ihdr_bill_doc_type_code,
                     :d_dn_ihdr_bill_num,
                     :d_dn_ihdr_bill_date,
                     :d_chk_ihdr_bill_date,
                     :d_dn_ihdr_doctor_fee_amt,
                     :d_dn_ihdr_main_acc1_code,
                     :d_dn_ihdr_main_acc2_code,
                     :d_dn_ihdr_sub_group_code,
                     :d_dn_ihdr_sub_line_code,
                     :d_dn_ihdr_dept_code,
                     :d_dn_ihdr_product_group_code,
                     :d_dn_ihdr_product_line_code,
                     :d_dn_ihdr_post_month,
                     :d_dn_ihdr_post_year,
                     :d_dn_ihdr_rowid,
					 :d_consolidated_yn; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 44;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )494;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_dn_ihdr_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_dn_ihdr_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_dn_ihdr_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_dn_ihdr_org_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_dn_ihdr_org_doc_num;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_dn_ihdr_last_line_num;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_dn_ihdr_cust_code;
      sqlstm.sqhstl[6] = (unsigned int  )10;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_dn_ihdr_narration;
      sqlstm.sqhstl[7] = (unsigned int  )53;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_dn_ihdr_base_date;
      sqlstm.sqhstl[8] = (unsigned int  )14;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&d_chk_ihdr_base_date;
      sqlstm.sqhstl[9] = (unsigned int  )14;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&d_dn_ihdr_due_date;
      sqlstm.sqhstl[10] = (unsigned int  )14;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&d_chk_ihdr_due_date;
      sqlstm.sqhstl[11] = (unsigned int  )14;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&d_dn_ihdr_gross_amt;
      sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&d_chk_ihdr_gross_amt;
      sqlstm.sqhstl[13] = (unsigned int  )21;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&d_dn_ihdr_payable_amt;
      sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&d_chk_ihdr_payable_amt;
      sqlstm.sqhstl[15] = (unsigned int  )21;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&d_dn_ihdr_discount_amt;
      sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&d_dn_ihdr_doc_amt;
      sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&d_dn_ihdr_doc_amt_chk;
      sqlstm.sqhstl[18] = (unsigned int  )21;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&d_dn_ihdr_currency_code;
      sqlstm.sqhstl[19] = (unsigned int  )21;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqhstv[20] = (         void  *)&d_dn_ihdr_exchg_rate;
      sqlstm.sqhstl[20] = (unsigned int  )22;
      sqlstm.sqhsts[20] = (         int  )0;
      sqlstm.sqindv[20] = (         void  *)0;
      sqlstm.sqinds[20] = (         int  )0;
      sqlstm.sqharm[20] = (unsigned int  )0;
      sqlstm.sqadto[20] = (unsigned short )0;
      sqlstm.sqtdso[20] = (unsigned short )0;
      sqlstm.sqhstv[21] = (         void  *)&d_dn_ihdr_pmnt_terms_code;
      sqlstm.sqhstl[21] = (unsigned int  )5;
      sqlstm.sqhsts[21] = (         int  )0;
      sqlstm.sqindv[21] = (         void  *)0;
      sqlstm.sqinds[21] = (         int  )0;
      sqlstm.sqharm[21] = (unsigned int  )0;
      sqlstm.sqadto[21] = (unsigned short )0;
      sqlstm.sqtdso[21] = (unsigned short )0;
      sqlstm.sqhstv[22] = (         void  *)&d_dn_ihdr_settlement_date;
      sqlstm.sqhstl[22] = (unsigned int  )14;
      sqlstm.sqhsts[22] = (         int  )0;
      sqlstm.sqindv[22] = (         void  *)0;
      sqlstm.sqinds[22] = (         int  )0;
      sqlstm.sqharm[22] = (unsigned int  )0;
      sqlstm.sqadto[22] = (unsigned short )0;
      sqlstm.sqtdso[22] = (unsigned short )0;
      sqlstm.sqhstv[23] = (         void  *)&d_chk_ihdr_settlement_date;
      sqlstm.sqhstl[23] = (unsigned int  )14;
      sqlstm.sqhsts[23] = (         int  )0;
      sqlstm.sqindv[23] = (         void  *)0;
      sqlstm.sqinds[23] = (         int  )0;
      sqlstm.sqharm[23] = (unsigned int  )0;
      sqlstm.sqadto[23] = (unsigned short )0;
      sqlstm.sqtdso[23] = (unsigned short )0;
      sqlstm.sqhstv[24] = (         void  *)&d_dn_ihdr_settlement_perc;
      sqlstm.sqhstl[24] = (unsigned int  )9;
      sqlstm.sqhsts[24] = (         int  )0;
      sqlstm.sqindv[24] = (         void  *)0;
      sqlstm.sqinds[24] = (         int  )0;
      sqlstm.sqharm[24] = (unsigned int  )0;
      sqlstm.sqadto[24] = (unsigned short )0;
      sqlstm.sqtdso[24] = (unsigned short )0;
      sqlstm.sqhstv[25] = (         void  *)&d_dn_ihdr_cust_ref;
      sqlstm.sqhstl[25] = (unsigned int  )18;
      sqlstm.sqhsts[25] = (         int  )0;
      sqlstm.sqindv[25] = (         void  *)0;
      sqlstm.sqinds[25] = (         int  )0;
      sqlstm.sqharm[25] = (unsigned int  )0;
      sqlstm.sqadto[25] = (unsigned short )0;
      sqlstm.sqtdso[25] = (unsigned short )0;
      sqlstm.sqhstv[26] = (         void  *)&d_dn_ihdr_patient_id;
      sqlstm.sqhstl[26] = (unsigned int  )23;
      sqlstm.sqhsts[26] = (         int  )0;
      sqlstm.sqindv[26] = (         void  *)0;
      sqlstm.sqinds[26] = (         int  )0;
      sqlstm.sqharm[26] = (unsigned int  )0;
      sqlstm.sqadto[26] = (unsigned short )0;
      sqlstm.sqtdso[26] = (unsigned short )0;
      sqlstm.sqhstv[27] = (         void  *)&d_dn_ihdr_billing_group;
      sqlstm.sqhstl[27] = (unsigned int  )7;
      sqlstm.sqhsts[27] = (         int  )0;
      sqlstm.sqindv[27] = (         void  *)0;
      sqlstm.sqinds[27] = (         int  )0;
      sqlstm.sqharm[27] = (unsigned int  )0;
      sqlstm.sqadto[27] = (unsigned short )0;
      sqlstm.sqtdso[27] = (unsigned short )0;
      sqlstm.sqhstv[28] = (         void  *)&d_dn_ihdr_bill_doc_type_code;
      sqlstm.sqhstl[28] = (unsigned int  )9;
      sqlstm.sqhsts[28] = (         int  )0;
      sqlstm.sqindv[28] = (         void  *)0;
      sqlstm.sqinds[28] = (         int  )0;
      sqlstm.sqharm[28] = (unsigned int  )0;
      sqlstm.sqadto[28] = (unsigned short )0;
      sqlstm.sqtdso[28] = (unsigned short )0;
      sqlstm.sqhstv[29] = (         void  *)&d_dn_ihdr_bill_num;
      sqlstm.sqhstl[29] = (unsigned int  )11;
      sqlstm.sqhsts[29] = (         int  )0;
      sqlstm.sqindv[29] = (         void  *)0;
      sqlstm.sqinds[29] = (         int  )0;
      sqlstm.sqharm[29] = (unsigned int  )0;
      sqlstm.sqadto[29] = (unsigned short )0;
      sqlstm.sqtdso[29] = (unsigned short )0;
      sqlstm.sqhstv[30] = (         void  *)&d_dn_ihdr_bill_date;
      sqlstm.sqhstl[30] = (unsigned int  )14;
      sqlstm.sqhsts[30] = (         int  )0;
      sqlstm.sqindv[30] = (         void  *)0;
      sqlstm.sqinds[30] = (         int  )0;
      sqlstm.sqharm[30] = (unsigned int  )0;
      sqlstm.sqadto[30] = (unsigned short )0;
      sqlstm.sqtdso[30] = (unsigned short )0;
      sqlstm.sqhstv[31] = (         void  *)&d_chk_ihdr_bill_date;
      sqlstm.sqhstl[31] = (unsigned int  )14;
      sqlstm.sqhsts[31] = (         int  )0;
      sqlstm.sqindv[31] = (         void  *)0;
      sqlstm.sqinds[31] = (         int  )0;
      sqlstm.sqharm[31] = (unsigned int  )0;
      sqlstm.sqadto[31] = (unsigned short )0;
      sqlstm.sqtdso[31] = (unsigned short )0;
      sqlstm.sqhstv[32] = (         void  *)&d_dn_ihdr_doctor_fee_amt;
      sqlstm.sqhstl[32] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[32] = (         int  )0;
      sqlstm.sqindv[32] = (         void  *)0;
      sqlstm.sqinds[32] = (         int  )0;
      sqlstm.sqharm[32] = (unsigned int  )0;
      sqlstm.sqadto[32] = (unsigned short )0;
      sqlstm.sqtdso[32] = (unsigned short )0;
      sqlstm.sqhstv[33] = (         void  *)&d_dn_ihdr_main_acc1_code;
      sqlstm.sqhstl[33] = (unsigned int  )9;
      sqlstm.sqhsts[33] = (         int  )0;
      sqlstm.sqindv[33] = (         void  *)0;
      sqlstm.sqinds[33] = (         int  )0;
      sqlstm.sqharm[33] = (unsigned int  )0;
      sqlstm.sqadto[33] = (unsigned short )0;
      sqlstm.sqtdso[33] = (unsigned short )0;
      sqlstm.sqhstv[34] = (         void  *)&d_dn_ihdr_main_acc2_code;
      sqlstm.sqhstl[34] = (unsigned int  )7;
      sqlstm.sqhsts[34] = (         int  )0;
      sqlstm.sqindv[34] = (         void  *)0;
      sqlstm.sqinds[34] = (         int  )0;
      sqlstm.sqharm[34] = (unsigned int  )0;
      sqlstm.sqadto[34] = (unsigned short )0;
      sqlstm.sqtdso[34] = (unsigned short )0;
      sqlstm.sqhstv[35] = (         void  *)&d_dn_ihdr_sub_group_code;
      sqlstm.sqhstl[35] = (unsigned int  )6;
      sqlstm.sqhsts[35] = (         int  )0;
      sqlstm.sqindv[35] = (         void  *)0;
      sqlstm.sqinds[35] = (         int  )0;
      sqlstm.sqharm[35] = (unsigned int  )0;
      sqlstm.sqadto[35] = (unsigned short )0;
      sqlstm.sqtdso[35] = (unsigned short )0;
      sqlstm.sqhstv[36] = (         void  *)&d_dn_ihdr_sub_line_code;
      sqlstm.sqhstl[36] = (unsigned int  )11;
      sqlstm.sqhsts[36] = (         int  )0;
      sqlstm.sqindv[36] = (         void  *)0;
      sqlstm.sqinds[36] = (         int  )0;
      sqlstm.sqharm[36] = (unsigned int  )0;
      sqlstm.sqadto[36] = (unsigned short )0;
      sqlstm.sqtdso[36] = (unsigned short )0;
      sqlstm.sqhstv[37] = (         void  *)&d_dn_ihdr_dept_code;
      sqlstm.sqhstl[37] = (unsigned int  )13;
      sqlstm.sqhsts[37] = (         int  )0;
      sqlstm.sqindv[37] = (         void  *)0;
      sqlstm.sqinds[37] = (         int  )0;
      sqlstm.sqharm[37] = (unsigned int  )0;
      sqlstm.sqadto[37] = (unsigned short )0;
      sqlstm.sqtdso[37] = (unsigned short )0;
      sqlstm.sqhstv[38] = (         void  *)&d_dn_ihdr_product_group_code;
      sqlstm.sqhstl[38] = (unsigned int  )6;
      sqlstm.sqhsts[38] = (         int  )0;
      sqlstm.sqindv[38] = (         void  *)0;
      sqlstm.sqinds[38] = (         int  )0;
      sqlstm.sqharm[38] = (unsigned int  )0;
      sqlstm.sqadto[38] = (unsigned short )0;
      sqlstm.sqtdso[38] = (unsigned short )0;
      sqlstm.sqhstv[39] = (         void  *)&d_dn_ihdr_product_line_code;
      sqlstm.sqhstl[39] = (unsigned int  )7;
      sqlstm.sqhsts[39] = (         int  )0;
      sqlstm.sqindv[39] = (         void  *)0;
      sqlstm.sqinds[39] = (         int  )0;
      sqlstm.sqharm[39] = (unsigned int  )0;
      sqlstm.sqadto[39] = (unsigned short )0;
      sqlstm.sqtdso[39] = (unsigned short )0;
      sqlstm.sqhstv[40] = (         void  *)&d_dn_ihdr_post_month;
      sqlstm.sqhstl[40] = (unsigned int  )5;
      sqlstm.sqhsts[40] = (         int  )0;
      sqlstm.sqindv[40] = (         void  *)0;
      sqlstm.sqinds[40] = (         int  )0;
      sqlstm.sqharm[40] = (unsigned int  )0;
      sqlstm.sqadto[40] = (unsigned short )0;
      sqlstm.sqtdso[40] = (unsigned short )0;
      sqlstm.sqhstv[41] = (         void  *)&d_dn_ihdr_post_year;
      sqlstm.sqhstl[41] = (unsigned int  )7;
      sqlstm.sqhsts[41] = (         int  )0;
      sqlstm.sqindv[41] = (         void  *)0;
      sqlstm.sqinds[41] = (         int  )0;
      sqlstm.sqharm[41] = (unsigned int  )0;
      sqlstm.sqadto[41] = (unsigned short )0;
      sqlstm.sqtdso[41] = (unsigned short )0;
      sqlstm.sqhstv[42] = (         void  *)&d_dn_ihdr_rowid;
      sqlstm.sqhstl[42] = (unsigned int  )33;
      sqlstm.sqhsts[42] = (         int  )0;
      sqlstm.sqindv[42] = (         void  *)0;
      sqlstm.sqinds[42] = (         int  )0;
      sqlstm.sqharm[42] = (unsigned int  )0;
      sqlstm.sqadto[42] = (unsigned short )0;
      sqlstm.sqtdso[42] = (unsigned short )0;
      sqlstm.sqhstv[43] = (         void  *)&d_consolidated_yn;
      sqlstm.sqhstl[43] = (unsigned int  )4;
      sqlstm.sqhsts[43] = (         int  )0;
      sqlstm.sqindv[43] = (         void  *)0;
      sqlstm.sqinds[43] = (         int  )0;
      sqlstm.sqharm[43] = (unsigned int  )0;
      sqlstm.sqadto[43] = (unsigned short )0;
      sqlstm.sqtdso[43] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
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

d_dn_ihdr_acc_entity_code.arr[d_dn_ihdr_acc_entity_code.len]           = '\0';
d_dn_ihdr_doc_type_code.arr[d_dn_ihdr_doc_type_code.len]               = '\0';
d_dn_ihdr_doc_num.arr[d_dn_ihdr_doc_num.len]                           = '\0';
d_dn_ihdr_org_doc_type_code.arr[d_dn_ihdr_org_doc_type_code.len]       = '\0';
d_dn_ihdr_org_doc_num.arr[d_dn_ihdr_org_doc_num.len]                   = '\0';
d_dn_ihdr_last_line_num.arr[d_dn_ihdr_last_line_num.len]               = '\0';
d_dn_ihdr_cust_code.arr[d_dn_ihdr_cust_code.len]                       = '\0';
d_dn_ihdr_narration.arr[d_dn_ihdr_narration.len]                       = '\0';
d_dn_ihdr_base_date.arr[d_dn_ihdr_base_date.len]                       = '\0';
d_chk_ihdr_base_date.arr[d_chk_ihdr_base_date.len]                     = '\0';
d_dn_ihdr_due_date.arr[d_dn_ihdr_due_date.len]                         = '\0';
d_chk_ihdr_due_date.arr[d_chk_ihdr_due_date.len]                       = '\0';
/*d_dn_ihdr_gross_amt.arr[d_dn_ihdr_gross_amt.len]                     = '\0';*/
d_chk_ihdr_gross_amt.arr[d_chk_ihdr_gross_amt.len]                     = '\0';
/*d_dn_ihdr_payable_amt.arr[d_dn_ihdr_payable_amt.len]                 = '\0';*/
d_chk_ihdr_payable_amt.arr[d_chk_ihdr_payable_amt.len]                 = '\0';
/*d_dn_ihdr_discount_amt.arr[d_dn_ihdr_discount_amt.len]               = '\0';*/
/*d_dn_ihdr_doc_amt.arr[d_dn_ihdr_doc_amt.len]                         = '\0';*/
d_dn_ihdr_doc_amt_chk.arr[d_dn_ihdr_doc_amt_chk.len]                   = '\0';
d_dn_ihdr_currency_code.arr[d_dn_ihdr_currency_code.len]               = '\0';
d_dn_ihdr_exchg_rate.arr[d_dn_ihdr_exchg_rate.len]                     = '\0';
d_dn_ihdr_pmnt_terms_code.arr[d_dn_ihdr_pmnt_terms_code.len]           = '\0';
d_dn_ihdr_settlement_date.arr[d_dn_ihdr_settlement_date.len]           = '\0';
d_chk_ihdr_settlement_date.arr[d_chk_ihdr_settlement_date.len]         = '\0';
d_dn_ihdr_settlement_perc.arr[d_dn_ihdr_settlement_perc.len]           = '\0';
d_dn_ihdr_cust_ref.arr[d_dn_ihdr_cust_ref.len]                         = '\0';
d_dn_ihdr_patient_id.arr[d_dn_ihdr_patient_id.len]                     = '\0';
d_dn_ihdr_billing_group.arr[d_dn_ihdr_billing_group.len]               = '\0';
d_dn_ihdr_bill_doc_type_code.arr[d_dn_ihdr_bill_doc_type_code.len]     = '\0';
d_dn_ihdr_bill_num.arr[d_dn_ihdr_bill_num.len]                         = '\0';
d_dn_ihdr_bill_date.arr[d_dn_ihdr_bill_date.len]                       = '\0';
d_chk_ihdr_bill_date.arr[d_chk_ihdr_bill_date.len]                     = '\0';
/*d_dn_ihdr_doctor_fee_amt.arr[d_dn_ihdr_doctor_fee_amt.len]           = '\0';*/
d_dn_ihdr_main_acc1_code.arr[d_dn_ihdr_main_acc1_code.len]             = '\0';
d_dn_ihdr_main_acc2_code.arr[d_dn_ihdr_main_acc2_code.len]             = '\0';
d_dn_ihdr_sub_group_code.arr[d_dn_ihdr_sub_group_code.len] = '\0';
d_dn_ihdr_sub_line_code.arr[d_dn_ihdr_sub_line_code.len]   = '\0';
d_dn_ihdr_dept_code.arr[d_dn_ihdr_dept_code.len]                       = '\0';
d_dn_ihdr_product_group_code.arr[d_dn_ihdr_product_group_code.len]     = '\0';
d_dn_ihdr_product_line_code.arr[d_dn_ihdr_product_line_code.len]       = '\0';
d_dn_ihdr_post_month.arr[d_dn_ihdr_post_month.len]                     = '\0';
d_dn_ihdr_post_year.arr[d_dn_ihdr_post_year.len]                       = '\0';
d_dn_ihdr_rowid.arr[d_dn_ihdr_rowid.len]                               = '\0';
d_consolidated_yn.arr[d_consolidated_yn.len]   = '\0';

#ifdef DEBUG
      sprintf(string_var,"After fetching rec count is <%d> \n",sqlca.sqlerrd[2]);
      disp_message(INFO_MESG,string_var);
#endif

      if (LAST_ROW)
           return(0);
      else
           return(1);

}

validate_dn_line()
{
  
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside Validate dn line \n");
#endif

      validate_posting(d_dn_line_line_num.arr,1);

      if (d_dn_line_amount_chk.len == 0)
             error_insert_null(d_dn_line_line_num.arr,"SY1470","Field = AMOUNT");           

	  nd_dtl_tot_amt += d_dn_line_amount;

   fflush(stdout);
}

fetch_dn_line1()
{
d_dn_line_acc_entity_code.arr[0]      = '\0';
d_dn_line_doc_type_code.arr[0]        = '\0';
d_dn_line_doc_num.arr[0]              = '\0';
d_dn_line_org_doc_type_code.arr[0]    = '\0';
d_dn_line_org_doc_num.arr[0]          = '\0';
d_dn_line_line_num.arr[0]             = '\0';
d_dn_line_main_acc1_code.arr[0]       = '\0';
d_dn_line_main_acc2_code.arr[0]       = '\0';
d_dn_line_sub_group_code.arr[0] = '\0';
d_dn_line_sub_line_code.arr[0]  = '\0';
d_dn_line_dept_code.arr[0]            = '\0';
d_dn_line_product_group_code.arr[0]   = '\0';
d_dn_line_product_line_code.arr[0]    = '\0';
/*d_dn_line_amount.arr[0]             = '\0';*/
d_dn_line_amount_chk.arr[0]           = '\0';
d_dn_line_narration.arr[0]            = '\0';
d_dn_line_rowid.arr[0]                = '\0';


d_dn_line_acc_entity_code.len         = 0;
d_dn_line_doc_type_code.len           = 0;
d_dn_line_doc_num.len                 = 0;
d_dn_line_org_doc_type_code.len       = 0;
d_dn_line_org_doc_num.len             = 0;
d_dn_line_line_num.len                = 0;
d_dn_line_main_acc1_code.len          = 0;
d_dn_line_main_acc2_code.len          = 0;
d_dn_line_sub_group_code.len    = 0;
d_dn_line_sub_line_code.len     = 0;
d_dn_line_dept_code.len               = 0;
d_dn_line_product_group_code.len      = 0;
d_dn_line_product_line_code.len       = 0;
/*d_dn_line_amount.len                = 0;*/
d_dn_line_amount_chk.len              = 0;
d_dn_line_narration.len               = 0;
d_dn_line_rowid.len                   = 0;

d_dn_line_amount                      = 0;

#ifdef DEBUG
      disp_message(INFO_MESG,"Before fetching rec from ar_inv_line\n");
#endif

      /* EXEC SQL FETCH CUR_AR_DN_LINE
                INTO :d_dn_line_acc_entity_code,
                     :d_dn_line_doc_type_code,
                     :d_dn_line_doc_num,
                     :d_dn_line_org_doc_type_code,
                     :d_dn_line_org_doc_num,
                     :d_dn_line_line_num,
                     :d_dn_line_main_acc1_code,
                     :d_dn_line_main_acc2_code,
                     :d_dn_line_sub_group_code,
                     :d_dn_line_sub_line_code,
                     :d_dn_line_dept_code,
                     :d_dn_line_product_group_code,
                     :d_dn_line_product_line_code,
                     :d_dn_line_amount,
                     :d_dn_line_amount_chk,
                     :d_dn_line_narration,
                     :d_dn_line_rowid; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 44;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )685;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_dn_line_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_dn_line_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_dn_line_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_dn_line_org_doc_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )9;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_dn_line_org_doc_num;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_dn_line_line_num;
      sqlstm.sqhstl[5] = (unsigned int  )7;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_dn_line_main_acc1_code;
      sqlstm.sqhstl[6] = (unsigned int  )9;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_dn_line_main_acc2_code;
      sqlstm.sqhstl[7] = (unsigned int  )7;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_dn_line_sub_group_code;
      sqlstm.sqhstl[8] = (unsigned int  )6;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&d_dn_line_sub_line_code;
      sqlstm.sqhstl[9] = (unsigned int  )11;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&d_dn_line_dept_code;
      sqlstm.sqhstl[10] = (unsigned int  )13;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&d_dn_line_product_group_code;
      sqlstm.sqhstl[11] = (unsigned int  )6;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&d_dn_line_product_line_code;
      sqlstm.sqhstl[12] = (unsigned int  )7;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&d_dn_line_amount;
      sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&d_dn_line_amount_chk;
      sqlstm.sqhstl[14] = (unsigned int  )21;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&d_dn_line_narration;
      sqlstm.sqhstl[15] = (unsigned int  )53;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&d_dn_line_rowid;
      sqlstm.sqhstl[16] = (unsigned int  )33;
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
         err_mesg("FETCH failed on cursor CUR_AR_DN_LINE",0,"");

d_dn_line_acc_entity_code.arr[d_dn_line_acc_entity_code.len]           = '\0';
d_dn_line_doc_type_code.arr[d_dn_line_doc_type_code.len]               = '\0';
d_dn_line_doc_num.arr[d_dn_line_doc_num.len]                           = '\0';
d_dn_line_org_doc_type_code.arr[d_dn_line_org_doc_type_code.len]       = '\0';
d_dn_line_org_doc_num.arr[d_dn_line_org_doc_num.len]                   = '\0';
d_dn_line_line_num.arr[d_dn_line_line_num.len]                         = '\0';
d_dn_line_main_acc1_code.arr[d_dn_line_main_acc1_code.len]             = '\0';
d_dn_line_main_acc2_code.arr[d_dn_line_main_acc2_code.len]             = '\0';
d_dn_line_sub_group_code.arr[d_dn_line_sub_group_code.len] = '\0';
d_dn_line_sub_line_code.arr[d_dn_line_sub_line_code.len]   = '\0';
d_dn_line_dept_code.arr[d_dn_line_dept_code.len]                       = '\0';
d_dn_line_product_group_code.arr[d_dn_line_product_group_code.len]     = '\0';
d_dn_line_product_line_code.arr[d_dn_line_product_line_code.len]       = '\0';
/*d_dn_line_amount.arr[d_dn_line_amount.len]                           = '\0';*/
d_dn_line_amount_chk.arr[d_dn_line_amount_chk.len]                     = '\0';
d_dn_line_narration.arr[d_dn_line_narration.len]                       = '\0';
d_dn_line_rowid.arr[d_dn_line_rowid.len]                               = '\0';

#ifdef DEBUG
      sprintf(string_var,"After fetching rec count is <%d> \n",sqlca.sqlerrd[2]);
      disp_message(INFO_MESG,string_var);
#endif

      if (LAST_ROW)
            return (0);
      else
            return (1);
}

validate_dn_inv_amt()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside validate dn inv amt\n");
#endif

    if (doubcmp(nd_dtl_tot_amt,d_dn_ihdr_doc_amt) != 0)
    {

          error_insert("9998","AR1790");
    }

}


validate_dn_amt()
{
   
#ifdef DEBUG
   disp_message(INFO_MESG,"inside validate dn amt\n");
#endif
	
	if (doubcmp(nd_doc_tot_amt,d_dn_hdr_doc_amt) != 0)
          error_insert("9999","AR1780");
}
  
gl_posting() 
{
 char r_err_msg[100];

#ifdef DEBUG
   disp_message(INFO_MESG,"Inside gl_posting...\n");
#endif

 if (post_doc((long)0,d_dn_hdr_doc_type_code.arr,atol(d_dn_hdr_doc_num.arr),
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
                WHERE DOC_TYPE_CODE = :d_dn_hdr_doc_type_code
                  AND DOC_NUM       = :d_dn_hdr_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 44;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from GL_TXN_DOC_HDR  where (DOC_TYPE_CODE=:b0 and DO\
C_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )768;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_dn_hdr_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_doc_num;
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
                WHERE DOC_TYPE_CODE = :d_dn_hdr_doc_type_code
                  AND DOC_NUM       = :d_dn_hdr_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 44;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from GL_TXN_DOC_LINE  where (DOC_TYPE_CODE=:b0 and D\
OC_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )791;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_dn_hdr_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_doc_num;
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
             l_ar_doc_error_text[71],
             l_doc_type_code_ref[7],
             l_doc_num_ref[9]; */ 
struct { unsigned short len; unsigned char arr[5]; } ar_line_no;

struct { unsigned short len; unsigned char arr[7]; } ar_err_code;

struct { unsigned short len; unsigned char arr[71]; } l_ar_doc_error_text;

struct { unsigned short len; unsigned char arr[7]; } l_doc_type_code_ref;

struct { unsigned short len; unsigned char arr[9]; } l_doc_num_ref;


   /* EXEC SQL END DECLARE SECTION; */ 


   char l_ch_amt1[25],
        l_ch_tot_amt[25];

   if (strcmp(line_no,"9999") == 0)
   {
     sprintf(ar_line_no.arr,"%4d",0);
     strcpy(l_doc_type_code_ref.arr,"      ");
     strcpy(l_doc_num_ref.arr,"");
     l_doc_type_code_ref.len  = 6;
     l_doc_num_ref.len  = 0;
   }
   else 
   {
        if (strcmp(line_no,"9998") == 0)
            sprintf(ar_line_no.arr,"%4d",0);
        else
            sprintf(ar_line_no.arr,"%4d",atoi(line_no));

        strcpy(l_doc_type_code_ref.arr,d_dn_ihdr_org_doc_type_code.arr);
        strcpy(l_doc_num_ref.arr,d_dn_ihdr_org_doc_num.arr);
        l_doc_type_code_ref.len  = strlen(d_dn_ihdr_org_doc_type_code.arr);
        l_doc_num_ref.len  = strlen(d_dn_ihdr_org_doc_num.arr);
   }

   ar_line_no.len = strlen(ar_line_no.arr);

   strcpy(ar_err_code.arr,msg_id);
   ar_err_code.len = strlen(ar_err_code.arr);

   l_ar_doc_error_text.len = 0;
   l_ar_doc_error_text.arr[0] = '\0';
   
   
   if (strcmp(ar_err_code.arr,"AR1780") == 0)
   {
	   if (nd_no_of_dec == 3) 
	     {
		    sprintf(l_ch_amt1,"%19.3f",d_dn_hdr_doc_amt);
		    sprintf(l_ch_tot_amt,"%19.3f",nd_doc_tot_amt);
         }
       else 
	     { 
		   sprintf(l_ch_amt1,"%19.2f",d_dn_hdr_doc_amt);
		   sprintf(l_ch_tot_amt,"%19.2f",nd_doc_tot_amt);
         } 
         format_amt(l_ch_amt1,nd_no_of_dec);
		 format_amt(l_ch_tot_amt,nd_no_of_dec);   


     sprintf(l_ar_doc_error_text.arr,"Doc Amt = %s   Sum of Debit Amounts = %s",
                   l_ch_amt1,l_ch_tot_amt);
 

     l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);
 
/*************
   EXEC SQL SELECT ' Doc Amt = '|| 
                ltrim(rtrim(TO_CHAR(:d_dn_hdr_doc_amt,'999,999,999,990.99')))
                || '   Sum of Debit Amounts = '||
                ltrim(rtrim(TO_CHAR(:nd_doc_tot_amt,'999,999,999,990.99')))
        INTO :l_ar_doc_error_text
        FROM DUAL;

     l_ar_doc_error_text.arr[l_ar_doc_error_text.len] = '\0';

     if (OERROR)
          err_mesg("SELECT failed on table DUAL",0,"",0,"");
 *******************/
 
   }
   else if (strcmp(ar_err_code.arr,"AR1790") == 0)
   {
	   if (nd_no_of_dec == 3) 
	     {
		   sprintf(l_ch_amt1,"%19.3f",d_dn_ihdr_doc_amt);
		   sprintf(l_ch_tot_amt,"%19.3f",nd_dtl_tot_amt);
         }
       else
	     {
		   sprintf(l_ch_amt1,"%19.2f",d_dn_ihdr_doc_amt);
		   sprintf(l_ch_tot_amt,"%19.2f",nd_dtl_tot_amt);
         }

         format_amt(l_ch_amt1,nd_no_of_dec);
		 format_amt(l_ch_tot_amt,nd_no_of_dec);

     sprintf(l_ar_doc_error_text.arr,"Debit Amt = %s   Sum of Line Amounts = %s",
                   l_ch_amt1,l_ch_tot_amt);
     l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);

   }

   /* EXEC SQL INSERT INTO AR_DOC_ERROR
                   (PGM_ID,
                    DOC_TYPE_CODE,    DOC_NUM,
                    LINE_NUM,         ERROR_CODE,
                    ERROR_TEXT,
                    DOC_TYPE_CODE_REF, DOC_NUM_REF,
					OPERATING_FACILITY_ID)
            VALUES (:d_curr_pgm_name,:d_dn_hdr_doc_type_code,
                    :d_dn_hdr_doc_num,
                    :ar_line_no,      :ar_err_code,
                    :l_ar_doc_error_text,
                    :l_doc_type_code_ref,:l_doc_num_ref,
					:nd_facility_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 44;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (PGM_ID,DOC_TYPE_CODE,DOC_NUM,LIN\
E_NUM,ERROR_CODE,ERROR_TEXT,DOC_TYPE_CODE_REF,DOC_NUM_REF,OPERATING_FACILITY_I\
D) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )814;
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
   sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_dn_hdr_doc_num;
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
   sqlstm.sqhstv[6] = (         void  *)&l_doc_type_code_ref;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_doc_num_ref;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
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



   if (OERROR)
   {
     sprintf(string_var,"doc type is <%s> - <%d>\n",d_dn_hdr_doc_type_code.arr,d_dn_hdr_doc_type_code.len);
     disp_message(ORA_MESG,string_var);
     sprintf(string_var,"doc num is <%s> - <%d>\n",d_dn_hdr_doc_num.arr,d_dn_hdr_doc_num.len);
     disp_message(ORA_MESG,string_var);
     sprintf(string_var,"line no is <%s> - <%d>\n",ar_line_no.arr,ar_line_no.len);
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
             l_ar_doc_error_text[71],
             l_doc_type_code_ref[7],
             l_doc_num_ref[9]; */ 
struct { unsigned short len; unsigned char arr[5]; } ar_line_no;

struct { unsigned short len; unsigned char arr[7]; } ar_err_code;

struct { unsigned short len; unsigned char arr[71]; } l_ar_doc_error_text;

struct { unsigned short len; unsigned char arr[7]; } l_doc_type_code_ref;

struct { unsigned short len; unsigned char arr[9]; } l_doc_num_ref;

   /* EXEC SQL END DECLARE SECTION; */ 


   if (strcmp(line_no,"9999") == 0)
   {
     sprintf(ar_line_no.arr,"%4d",0);
     strcpy(l_doc_type_code_ref.arr,"      ");
     strcpy(l_doc_num_ref.arr,"");
     l_doc_type_code_ref.len  = 6;
     l_doc_num_ref.len  = 0;
   }
   else 
   {
        if (strcmp(line_no,"9998") == 0)
            sprintf(ar_line_no.arr,"%4d",0);
        else
            sprintf(ar_line_no.arr,"%4d",atoi(line_no));

        strcpy(l_doc_type_code_ref.arr,d_dn_ihdr_org_doc_type_code.arr);
        strcpy(l_doc_num_ref.arr,d_dn_ihdr_org_doc_num.arr);
        l_doc_type_code_ref.len  = strlen(d_dn_ihdr_org_doc_type_code.arr);
        l_doc_num_ref.len  = strlen(d_dn_ihdr_org_doc_num.arr);
   }


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
                    ERROR_TEXT,
                    DOC_TYPE_CODE_REF,DOC_NUM_REF,
					OPERATING_FACILITY_ID)
            VALUES (:d_curr_pgm_name,:d_dn_hdr_doc_type_code,   
                    :d_dn_hdr_doc_num,
                    :ar_line_no,      :ar_err_code,
                    :l_ar_doc_error_text,
                    :l_doc_type_code_ref,:l_doc_num_ref,
					:nd_facility_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 44;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (PGM_ID,DOC_TYPE_CODE,DOC_NUM,LIN\
E_NUM,ERROR_CODE,ERROR_TEXT,DOC_TYPE_CODE_REF,DOC_NUM_REF,OPERATING_FACILITY_I\
D) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )865;
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
   sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_dn_hdr_doc_num;
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
   sqlstm.sqhstv[6] = (         void  *)&l_doc_type_code_ref;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_doc_num_ref;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
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



   if (OERROR)
   {
     sprintf(string_var,"doc type is <%s> - <%d>\n",d_dn_hdr_doc_type_code.arr,d_dn_hdr_doc_type_code.len);
     disp_message(ORA_MESG,string_var);
     sprintf(string_var,"doc num is <%s> - <%d>\n",d_dn_hdr_doc_num.arr,d_dn_hdr_doc_num.len);
     disp_message(ORA_MESG,string_var);
     sprintf(string_var,"line no is <%s> - <%d>\n",ar_line_no.arr,ar_line_no.len);
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

   /* EXEC SQL UPDATE AR_DN_HDR 
               SET ERROR_FLAG = :nd_error_flag
             WHERE ROWID      = :d_dn_hdr_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 44;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update AR_DN_HDR  set ERROR_FLAG=:b0 where ROWID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )916;
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
   sqlstm.sqhstv[1] = (         void  *)&d_dn_hdr_rowid;
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
       sqlstm.arrsiz = 44;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "delete  from AR_DOC_ERROR  where (PGM_ID=:b0 and ROWNU\
M<500)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )939;
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
       sqlstm.arrsiz = 44;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )958;
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
  sqlstm.arrsiz = 44;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )973;
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
			       :nd_no_of_dec
              FROM SY_ACC_ENTITY
		   where   ACC_ENTITY_ID = :nd_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 44;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NUM_OF_ACC_PERIODS ,ACC_ENTITY_CODE ,NO_OF_DECIMAL i\
nto :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1004;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_no_of_dec;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
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
        err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");


   /* EXEC SQL EXECUTE 
            BEGIN
	         GET_INSTALLED_MODULES(:p_operational_modules);   
            END;
    END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 44;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin GET_INSTALLED_MODULES ( :p_operational_modules ) ; E\
ND ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1035;
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
	         into   :bl_instal_flag 
			from dual ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 44;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INSTR(:b0,'BL|') into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1054;
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
 sqlstm.sqhstv[1] = (         void  *)&bl_instal_flag;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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
	         into   :mp_instal_flag
			from dual ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 44;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INSTR(:b0,'MP|') into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1077;
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
 sqlstm.sqhstv[1] = (         void  *)&mp_instal_flag;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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




	 if (bl_instal_flag > 0 )
	 {
         strcpy(d_sy_acc_bl_instal_flag.arr , "Y");
	  }
	else
	{

          strcpy(d_sy_acc_bl_instal_flag.arr , "N");   
	 }

	  if (mp_instal_flag > 0 )
	 {
         strcpy(d_sy_acc_mp_instal_flag.arr , "Y");
	  }
	else
	{

          strcpy(d_sy_acc_mp_instal_flag.arr , "N");   
	 }


             

  
   d_sy_num_acc_per.arr[d_sy_num_acc_per.len]               = '\0';

   d_num_of_acc_periods = atoi(d_sy_num_acc_per.arr);
}

fetch_ar_parameter()
{
     ar_interface_code.arr[0] = '\0';
     ar_interface_code.len    = 0;

     /* EXEC SQL SELECT AR_INTERFACE_CODE 
                INTO :ar_interface_code
                FROM AR_PARAMETER
			   WHERE OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 44;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select AR_INTERFACE_CODE into :b0  from AR_PARAMETER whe\
re OPERATING_FACILITY_ID=:b1";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1100;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
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
         err_mesg("SELECT failed on table AR_PARAMETER",0,"");

     ar_interface_code.arr[ar_interface_code.len]='\0';


     /* EXEC SQL SELECT CURRENT_ACC_YEAR,CURRENT_ACC_MONTH,
                     PRIOR_POSTING_ALLOW_FLAG,
                     NVL(SUMMARY_PROCESS_FLAG,'X') 
                INTO :curr_acc_year,    :curr_acc_month,
                     :prior_post_allow, :gl_summ_pro_flag
                FROM GL_PARAMETER; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 44;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select CURRENT_ACC_YEAR ,CURRENT_ACC_MONTH ,PRIOR_POSTIN\
G_ALLOW_FLAG ,NVL(SUMMARY_PROCESS_FLAG,'X') into :b0,:b1,:b2,:b3  from GL_PARA\
METER ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1123;
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
  "arrdnlst",uid_pwd.arr,
  (nd_view_print_flg.arr[0]=='V')?"batch=no":"batch=yes",
  nd_session_id.arr,g_pgm_date,
  (nd_view_print_flg.arr[0]=='V')?"destype=Screen":"destype=File",
  (nd_proc_flag.arr[0]=='P')?"arbdnpst":"arrdnlst");
 
  l_ret_run_rep = WinExec(l_run_string,SW_NORMAL);

   if (l_ret_run_rep<32)
   {disp_message(ERR_MESG,"Error in calling Report Writer Program");
    proc_exit();
   } 
  /*if (l_ret_run_rep)
  {
     sprintf(string_var,"%s\n",l_run_string);
     disp_message(INFO_MESG,string_var);
     sprintf(l_messg_str,"RUNREP - arrinlst session = %s failed \
return value %d",nd_session_id.arr,l_ret_run_rep);
     err_mesg(l_messg_str,0,"");
  } */
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

doubcmp(_doub1,_doub2)
double _doub1,_doub2;
{
  char _doub_str1[25],_doub_str2[25];

  if (nd_no_of_dec == 3)
  {
	  sprintf(_doub_str1,"%15.3f",_doub1);
	  sprintf(_doub_str2,"%15.3f",_doub2);

	  if (strcmp(_doub_str1,"-0.000") == 0)
		 strcpy(_doub_str1,"0.000");
	  if (strcmp(_doub_str2,"-0.000") == 0)
		 strcpy(_doub_str2,"0.000");

  }
  else
  {
	  sprintf(_doub_str1,"%15.2f",_doub1);
	  sprintf(_doub_str2,"%15.2f",_doub2);

	  if (strcmp(_doub_str1,"-0.00") == 0)
		 strcpy(_doub_str1,"0.00");
	  if (strcmp(_doub_str2,"-0.00") == 0)
		 strcpy(_doub_str2,"0.00");

  }

  format_amt(_doub_str1,nd_no_of_dec);
  format_amt(_doub_str2,nd_no_of_dec);

  return(strcmp(_doub_str1,_doub_str2));
}
