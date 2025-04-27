
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
           char  filnam[39];
};
static const struct sqlcxp sqlfpn =
{
    38,
    "T:\\BL\\CRF-0120\\AR\\WIP\\Proc\\arrorlst.pc"
};


static unsigned long sqlctx = 1150830357;


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
            void  *sqhstv[48];
   unsigned int   sqhstl[48];
            int   sqhsts[48];
            void  *sqindv[48];
            int   sqinds[48];
   unsigned int   sqharm[48];
   unsigned int   *sqharc[48];
   unsigned short  sqadto[48];
   unsigned short  sqtdso[48];
} sqlstm = {10,48};

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

 static const char *sq0003 = 
"select DOC_TYPE_CODE ,DOC_NUM  from AR_CASHIER where ((((((DOC_TYPE_CODE>=NV\
L(:b0,'      ') and DOC_TYPE_CODE<=NVL(:b1,'~~~~~~')) and DOC_NUM>=NVL(:b2,0))\
 and DOC_NUM<=NVL(:b3,99999999)) and NVL(DOC_DATE,SYSDATE)>=NVL(TO_DATE(:b4,'Y\
YYYDDMM'),to_date('00010101','YYYYDDMM'))) and NVL(DOC_DATE,SYSDATE)<=NVL(TO_D\
ATE(:b5,'YYYYDDMM'),to_date('47123112','YYYYDDMM'))) and NVL(POSTED_FLAG,'N')=\
'N') order by DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0005 = 
"L(:b1,'~~~~~~')) and DOC_NUM>=NVL(:b2,0)) and DOC_NUM<=NVL(:b3,99999999)) an\
d NVL(DOC_DATE,SYSDATE)>=NVL(TO_DATE(:b4,'YYYYDDMM'),to_date('00010101','YYYYD\
DMM'))) and NVL(DOC_DATE,SYSDATE)<=NVL(TO_DATE(:b5,'YYYYDDMM'),to_date('471231\
12','YYYYDDMM'))) and NVL(POSTED_FLAG,'N')='N') order by MAIN_ACC1_CODE_BANK,M\
AIN_ACC2_CODE_BANK,DEPT_CODE_BANK,PRODUCT_GROUP_CODE_BANK,PRODUCT_LINE_CODE_BA\
NK,SUBLEDGER_GROUP_CODE_BANK,SUBLEDGER_LINE_CODE_BANK,DOC_TYPE_CODE,DOC_NUM   \
         ";

 static const char *sq0004 = 
"L(:b1,'~~~~~~')) and DOC_NUM>=NVL(:b2,0)) and DOC_NUM<=NVL(:b3,99999999)) an\
d NVL(DOC_DATE,SYSDATE)>=NVL(TO_DATE(:b4,'YYYYDDMM'),to_date('00010101','YYYYD\
DMM'))) and NVL(DOC_DATE,SYSDATE)<=NVL(TO_DATE(:b5,'YYYYDDMM'),to_date('471231\
12','YYYYDDMM'))) and NVL(POSTED_FLAG,'N')='N') order by DOC_TYPE_CODE,DOC_NUM\
            ";

 static const char *sq0007 = 
"select DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINESE,LONG_NAME)  from \
AR_CUSTOMER where CUST_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,356,0,4,287,0,0,15,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
80,0,0,2,0,0,30,368,0,0,0,0,0,1,0,
95,0,0,3,435,0,9,389,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
134,0,0,5,1499,0,9,526,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
173,0,0,4,1346,0,9,530,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
212,0,0,5,0,0,13,656,0,0,48,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
419,0,0,4,0,0,13,707,0,0,48,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
626,0,0,8,0,0,27,824,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
657,0,0,9,140,0,4,834,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
688,0,0,10,118,0,4,851,0,0,4,1,0,1,0,2,3,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
719,0,0,11,128,0,4,880,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
750,0,0,12,148,0,4,957,0,0,6,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,4,0,0,2,9,0,0,2,
9,0,0,
789,0,0,7,118,0,9,1050,0,0,1,1,0,1,0,1,9,0,0,
808,0,0,7,0,0,13,1058,0,0,1,0,0,1,0,2,9,0,0,
827,0,0,13,245,0,4,1074,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
874,0,0,14,245,0,4,1091,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                   */
/************************************************************************/
/* PROGRAM NAME          : ARRORLST.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 09-FEB-1993                                  */
/*                                                                      */
/* CALLED FROM            :                                              */
/*                                                                                                               */
/*  FUNCTION               :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_CASHIER              Query/Update              */
/*         2.        GL_ACC_CHART                Lookup                 */
/*         3.        SY_DEPT                     Lookup                 */
/*         4.        GL_PRODUCT_LINE             Lookup                 */
/*         5.        GL_SUBLEDGER_LINE           Lookup                 */
/*         6.        GL_ACC_COMBINATION          Lookup                 */
/*         7.        SY_DOC_CONTROL            Insert/Lookup            */
/*         8.        SY_PROG_CONTROL           Update/Lookup            */
/*         9.        SY_PROG_MESG                Insert                 */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*         2.        POST                validate_posting_acct          */
/*         3.        POST_DOC            post_doc (GL posting acc val)  */
/*                                                                      */
/*                                                                      */
/************************************************************************/
                                 
#include <stdio.h>
#include <math.h>
#include <string.h>
#include <gl.h>
/*
#define OERROR (sqlca.sqlcode < 0)
*/
#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

#define RESOURCE_BUSY        (sqlca.sqlcode == -54)


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

            pmnt_terms_code  [3],
            billing_group    [5],  -- CRF-0120
            patient_id       [21],
            patient_flag     [2],
            bl_instal_flag   [2],
            mp_instal_flag   [2],
            nd_error_flag    [2],
            print_flag       [3],
	    nd_bank_flag     [2],
            mast_status      [3],
            d_curr_pgm_name  [15],
            dummy            [10][5],

            d_last_inv_doc_date           [12],
			nd_acc_entity_code					[5],


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

struct { unsigned short len; unsigned char arr[3]; } pmnt_terms_code;

struct { unsigned short len; unsigned char arr[5]; } billing_group;

struct { unsigned short len; unsigned char arr[21]; } patient_id;

struct { unsigned short len; unsigned char arr[2]; } patient_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } mp_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_error_flag;

struct { unsigned short len; unsigned char arr[3]; } print_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_bank_flag;

struct { unsigned short len; unsigned char arr[3]; } mast_status;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[6]; } dummy[10];

struct { unsigned short len; unsigned char arr[12]; } d_last_inv_doc_date;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

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


 /* VARCHAR    d_rc_hdr_acc_entity_code               [5],
            d_rc_hdr_doc_type_code                 [7],
            d_rc_hdr_doc_num                       [9],
            d_rc_hdr_party_type_code               [3],
            d_rc_hdr_doc_date                      [15],
            d_rc_hdr_doc_ref                       [11],
            d_rc_hdr_cust_code                     [9],
            d_rc_hdr_main_acc1_code_bk           [7],
            d_rc_hdr_main_acc2_code_bk           [5],
            d_rc_hdr_subl_group_code_bk          [4],
            d_rc_hdr_subl_line_code_bk           [9],
            d_rc_hdr_dept_code_bk                [11],
            d_rc_hdr_pr_group_code_bk            [4],
            d_rc_hdr_pr_line_code_bk             [5],
            d_rc_hdr_main_acc1_code_sp           [7],
            d_rc_hdr_main_acc2_code_sp           [5],
            d_rc_hdr_subl_group_code_sp          [4],
            d_rc_hdr_subl_line_code_sp           [9],
            d_rc_hdr_dept_code_sp                [11],
            d_rc_hdr_pr_group_code_sp            [4],
            d_rc_hdr_pr_line_code_sp             [5],
            d_rc_hdr_amt_foreign                   [17],
            d_rc_hdr_amt_local                     [17],
            d_rc_hdr_narration                     [51],
            d_rc_hdr_post_month                    [3],
            d_rc_hdr_post_year                     [5],
            d_rc_hdr_currency_code                 [7],
            d_rc_hdr_exchg_rate                    [15],
            d_rc_hdr_bank_desc                     [31],
            d_rc_hdr_cheque_num                    [11],
            d_rc_hdr_cheque_date                   [15],
            d_rc_hdr_misc_clong_name           [101],  -- CRF-0120
            d_rc_hdr_misc_cshort_name          [101],  -- CRF-0120
            d_rc_hdr_misc_cadd1_desc           [61],  -- CRF-0120
            d_rc_hdr_misc_cadd2_desc           [61],  -- CRF-0120
            d_rc_hdr_misc_cadd3_desc           [61],  -- CRF-0120
            d_rc_hdr_misc_czip_desc            [31],
            d_rc_hdr_misc_long_name_ch             [101],  -- CRF-0120
            d_rc_hdr_misc_short_name_ch            [101],  -- CRF-0120
            d_rc_hdr_misc_add1_desc_ch             [61],  -- CRF-0120
            d_rc_hdr_misc_add2_desc_ch             [61],  -- CRF-0120
            d_rc_hdr_misc_add3_desc_ch             [61],  -- CRF-0120
            d_rc_hdr_misc_zip_desc_ch              [31],
            d_rc_hdr_tel_num                       [31],
            d_rc_hdr_contact_name                  [101],  -- CRF-0120
            d_rc_hdr_contact_name_title            [61],  -- CRF-0120
            d_rc_hdr_error_flag                    [2],
            d_rc_hdr_print_flag                    [2],
            d_rc_hdr_posted_flag                   [2],
            d_rc_hdr_interface_flag                [2],
            d_rc_hdr_posted_date                   [15],
            d_rc_hdr_posted_by_id                  [21],
            d_rc_hdr_rowid                         [31],
            d_sy_doc_print_flag                    [2]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_rc_hdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[7]; } d_rc_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_rc_hdr_doc_num;

struct { unsigned short len; unsigned char arr[3]; } d_rc_hdr_party_type_code;

struct { unsigned short len; unsigned char arr[15]; } d_rc_hdr_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_rc_hdr_doc_ref;

struct { unsigned short len; unsigned char arr[9]; } d_rc_hdr_cust_code;

struct { unsigned short len; unsigned char arr[7]; } d_rc_hdr_main_acc1_code_bk;

struct { unsigned short len; unsigned char arr[5]; } d_rc_hdr_main_acc2_code_bk;

struct { unsigned short len; unsigned char arr[4]; } d_rc_hdr_subl_group_code_bk;

struct { unsigned short len; unsigned char arr[9]; } d_rc_hdr_subl_line_code_bk;

struct { unsigned short len; unsigned char arr[11]; } d_rc_hdr_dept_code_bk;

struct { unsigned short len; unsigned char arr[4]; } d_rc_hdr_pr_group_code_bk;

struct { unsigned short len; unsigned char arr[5]; } d_rc_hdr_pr_line_code_bk;

struct { unsigned short len; unsigned char arr[7]; } d_rc_hdr_main_acc1_code_sp;

struct { unsigned short len; unsigned char arr[5]; } d_rc_hdr_main_acc2_code_sp;

struct { unsigned short len; unsigned char arr[4]; } d_rc_hdr_subl_group_code_sp;

struct { unsigned short len; unsigned char arr[9]; } d_rc_hdr_subl_line_code_sp;

struct { unsigned short len; unsigned char arr[11]; } d_rc_hdr_dept_code_sp;

struct { unsigned short len; unsigned char arr[4]; } d_rc_hdr_pr_group_code_sp;

struct { unsigned short len; unsigned char arr[5]; } d_rc_hdr_pr_line_code_sp;

struct { unsigned short len; unsigned char arr[17]; } d_rc_hdr_amt_foreign;

struct { unsigned short len; unsigned char arr[17]; } d_rc_hdr_amt_local;

struct { unsigned short len; unsigned char arr[51]; } d_rc_hdr_narration;

struct { unsigned short len; unsigned char arr[3]; } d_rc_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_rc_hdr_post_year;

struct { unsigned short len; unsigned char arr[7]; } d_rc_hdr_currency_code;

struct { unsigned short len; unsigned char arr[15]; } d_rc_hdr_exchg_rate;

struct { unsigned short len; unsigned char arr[31]; } d_rc_hdr_bank_desc;

struct { unsigned short len; unsigned char arr[11]; } d_rc_hdr_cheque_num;

struct { unsigned short len; unsigned char arr[15]; } d_rc_hdr_cheque_date;

struct { unsigned short len; unsigned char arr[101]; } d_rc_hdr_misc_clong_name;

struct { unsigned short len; unsigned char arr[101]; } d_rc_hdr_misc_cshort_name;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_cadd1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_cadd2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_cadd3_desc;

struct { unsigned short len; unsigned char arr[31]; } d_rc_hdr_misc_czip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_rc_hdr_misc_long_name_ch;

struct { unsigned short len; unsigned char arr[101]; } d_rc_hdr_misc_short_name_ch;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_add1_desc_ch;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_add2_desc_ch;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_add3_desc_ch;

struct { unsigned short len; unsigned char arr[31]; } d_rc_hdr_misc_zip_desc_ch;

struct { unsigned short len; unsigned char arr[31]; } d_rc_hdr_tel_num;

struct { unsigned short len; unsigned char arr[101]; } d_rc_hdr_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_contact_name_title;

struct { unsigned short len; unsigned char arr[2]; } d_rc_hdr_error_flag;

struct { unsigned short len; unsigned char arr[2]; } d_rc_hdr_print_flag;

struct { unsigned short len; unsigned char arr[2]; } d_rc_hdr_posted_flag;

struct { unsigned short len; unsigned char arr[2]; } d_rc_hdr_interface_flag;

struct { unsigned short len; unsigned char arr[15]; } d_rc_hdr_posted_date;

struct { unsigned short len; unsigned char arr[21]; } d_rc_hdr_posted_by_id;

struct { unsigned short len; unsigned char arr[31]; } d_rc_hdr_rowid;

struct { unsigned short len; unsigned char arr[2]; } d_sy_doc_print_flag;

    /* VARCHAR  p_language_id[4]; */ 
struct { unsigned short len; unsigned char arr[4]; } p_language_id;

    /* VARCHAR rep_date[20],
            comp_name[50],
            oper_id[21],
           d_ar_cust_long_name         [101],  -- CRF-0120
		   d_acct_desc_bank            [65],
		   d_acct_desc_susp            [65],
		   d_conv_date_doc             [12],
		   d_conv_date_bank            [12],
		   nd_conv_fm_date             [12],
		   nd_conv_to_date             [12]; */ 
struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[101]; } d_ar_cust_long_name;

struct { unsigned short len; unsigned char arr[65]; } d_acct_desc_bank;

struct { unsigned short len; unsigned char arr[65]; } d_acct_desc_susp;

struct { unsigned short len; unsigned char arr[12]; } d_conv_date_doc;

struct { unsigned short len; unsigned char arr[12]; } d_conv_date_bank;

struct { unsigned short len; unsigned char arr[12]; } nd_conv_fm_date;

struct { unsigned short len; unsigned char arr[12]; } nd_conv_to_date;


double     d_amt_local;

/* This variable is used for calling post_doc (Posting acc validation)   */

int  d_num_of_acc_periods, nd_no_of_decimal;

/*                                                                       */ 

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

int g_err_typ,
    g_tot_print,
    g_print_bank;

char g_err_id[10],
     g_err_msg[80],
     g_main_acc1_code[8],
     g_main_acc2_code[6],
     g_dept_code[12],
     g_product_group_code[4],
     g_product_line_code[6],
     g_subledger_group_code[4],
     g_subledger_line_code[10];

double g_tot,
       g_tot_bank;

/* These variables are used for calling post_doc (Posting acc validation) */

int  d_curr_year;
int  d_curr_month;
char d_summ_flag;

/*                                                                         */

FILE *f1;

int page_no,
    line_no,
    first_break;
char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{
	strcpy(filename,WORKING_DIR);
	strcpy(OUTPUT_FILE_NAME,argv[5]);
	strcat(filename,OUTPUT_FILE_NAME);

	//strcat(filename,"arrorlst.lis");

   if (argc < 6)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(g_pgm_id,"ARRORLST");

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
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);
    strcpy(g_facility_id,argv[4]);
   set_meduser_role();

       strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   nd_proc_flag.arr[0]      = '\0';
   nd_view_print_flg.arr[0] = '\0';
   nd_bank_flag.arr[0]      = '\0';
   nd_facility_id.arr[0] = '\0';

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   nd_proc_flag.len         = 0;
   nd_view_print_flg.len    = 0;
   nd_bank_flag.len         = 0;
   nd_facility_id.len       = 0;

   process_rep_flg          = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID ,PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM8,
                   PARAM9,PARAM10,
                   TO_CHAR(TO_DATE(PARAM3,'YYYYDDMM'),'DD/MM/YYYY'),
		   TO_CHAR(TO_DATE(PARAM6,'YYYYDDMM'),'DD/MM/YYYY'),
		   PARAM11
              INTO :nd_facility_id, :nd_fm_doc_type, :nd_fm_doc_num, :nd_fm_doc_date,
                   :nd_to_doc_type, :nd_to_doc_num, :nd_to_doc_date,
                   :nd_proc_flag,
                   :nd_view_print_flg, :process_rep_flg,
		   :nd_conv_fm_date, :nd_conv_to_date,
		   :nd_bank_flag
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRORLST'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM8 ,PARAM9 ,PARAM10 ,TO_CHAR(TO_DATE(PARAM3,'YYYYDDMM'\
),'DD/MM/YYYY') ,TO_CHAR(TO_DATE(PARAM6,'YYYYDDMM'),'DD/MM/YYYY') ,PARAM11 int\
o :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12  from SY_PROG_PARAM w\
here ((PGM_ID='ARRORLST' and SESSION_ID=:b13) and PGM_DATE=:b14)";
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
   sqlstm.sqhstv[10] = (         void  *)&nd_conv_fm_date;
   sqlstm.sqhstl[10] = (unsigned int  )14;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_conv_to_date;
   sqlstm.sqhstl[11] = (unsigned int  )14;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_bank_flag;
   sqlstm.sqhstl[12] = (unsigned int  )4;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[13] = (unsigned int  )18;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[14] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';
   nd_proc_flag.arr[nd_proc_flag.len]        = '\0';
   nd_view_print_flg.arr[nd_view_print_flg.len]        = '\0';
   nd_conv_fm_date.arr[nd_conv_fm_date.len]  = '\0';
   nd_conv_to_date.arr[nd_conv_to_date.len]  = '\0';
   nd_facility_id.arr[nd_facility_id.len]        = '\0';


   start_prog_msg();
   
   fetch_parameter();
   fetch_detls();

   open_files();
  
   declare_cursor();
    page_no=1;
    line_no=1;
    g_tot = g_tot_bank = 0;
    g_tot_print = 0;
    first_break = 1;
   
   put_inp_parm();

   put_hdr();

   init_post_acc();

   while (fetch_rec())
   {
      get_acct_desc();
      g_print_bank = 1;

      if(line_no == 1)
	    put_hdr();

      if( (nd_bank_flag.arr[0] == 'Y') && (!same_acct()) )
	  do_bank();
      
      fetch_cust_dets();
      put_doc_hdr();
      g_tot_print = 1;

      copy_val();

   }

   if(nd_bank_flag.arr[0] == 'Y' && g_print_bank)
       print_bank_tot();

   print_end_of_rep();
   fclose(f1);

   end_prog_msg();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )80;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

declare_cursor()
{

   /* EXEC SQL DECLARE CUR_RECEIPTS CURSOR FOR
             SELECT DOC_TYPE_CODE, DOC_NUM
               FROM AR_CASHIER
              WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'YYYYDDMM'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'YYYYDDMM'),to_date('47123112','YYYYDDMM'))
                AND NVL(POSTED_FLAG,'N') = 'N'
                ORDER BY DOC_TYPE_CODE,DOC_NUM; */ 


   /* EXEC SQL OPEN CUR_RECEIPTS; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0003;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )95;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )14;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[5] = (unsigned int  )14;
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
         err_mesg("OPEN failed on cursor CUR_RECEIPTS",0,"");

 /* EXEC SQL DECLARE BL_REC_HDR_CUR1 CURSOR FOR
           SELECT DOC_TYPE_CODE,
                  DOC_NUM,
                  ACC_ENTITY_CODE,
                  PARTY_TYPE_CODE,
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
                  AMT_FOREIGN,
                  AMT_LOCAL,
                  NARRATION,
                  POST_MONTH,
                  POST_YEAR,
                  CURRENCY_CODE,
                  EXCHG_RATE,
                  BANK_DESC,
                  CHEQUE_NUM,
                  TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY'),
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
             FROM AR_CASHIER
             WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'YYYYDDMM'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'YYYYDDMM'),to_date('47123112','YYYYDDMM'))
                AND NVL(POSTED_FLAG,'N') = 'N'
                ORDER BY DOC_TYPE_CODE,DOC_NUM; */ 



 /* EXEC SQL DECLARE BL_REC_HDR_CUR2 CURSOR FOR
           SELECT DOC_TYPE_CODE,
                  DOC_NUM,
                  ACC_ENTITY_CODE,
                  PARTY_TYPE_CODE,
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
                  AMT_FOREIGN,
                  AMT_LOCAL,
                  NARRATION,
                  POST_MONTH,
                  POST_YEAR,
                  CURRENCY_CODE,
                  EXCHG_RATE,
                  BANK_DESC,
                  CHEQUE_NUM,
                  TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY'),
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
             FROM AR_CASHIER
              WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'YYYYDDMM'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'YYYYDDMM'),to_date('47123112','YYYYDDMM'))
                AND NVL(POSTED_FLAG,'N') = 'N'
                ORDER BY MAIN_ACC1_CODE_BANK,
			 MAIN_ACC2_CODE_BANK,
			 DEPT_CODE_BANK,
			 PRODUCT_GROUP_CODE_BANK,
			 PRODUCT_LINE_CODE_BANK,
			 SUBLEDGER_GROUP_CODE_BANK,
			 SUBLEDGER_LINE_CODE_BANK,
			 DOC_TYPE_CODE,DOC_NUM; */ 


   if(nd_bank_flag.arr[0] == 'Y') {

       /* EXEC SQL OPEN BL_REC_HDR_CUR2; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 15;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlbuft((void **)0, 
         "select DOC_TYPE_CODE ,DOC_NUM ,ACC_ENTITY_CODE ,PARTY_TYPE_CODE ,T\
O_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,CUST_CODE ,MAIN_ACC1_CODE_BANK ,MAIN\
_ACC2_CODE_BANK ,SUBLEDGER_GROUP_CODE_BANK ,SUBLEDGER_LINE_CODE_BANK ,DEPT_C\
ODE_BANK ,PRODUCT_GROUP_CODE_BANK ,PRODUCT_LINE_CODE_BANK ,MAIN_ACC1_CODE_SU\
SP ,MAIN_ACC2_CODE_SUSP ,SUBLEDGER_GROUP_CODE_SUSP ,SUBLEDGER_LINE_CODE_SUSP\
 ,DEPT_CODE_SUSP ,PRODUCT_GROUP_CODE_SUSP ,PRODUCT_LINE_CODE_SUSP ,AMT_FOREI\
GN ,AMT_LOCAL ,NARRATION ,POST_MONTH ,POST_YEAR ,CURRENCY_CODE ,EXCHG_RATE ,\
BANK_DESC ,CHEQUE_NUM ,TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY') ,MISC_CUST_LONG_NAM\
E ,MISC_CUST_SHORT_NAME ,MISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,MISC_CUST\
_ADD3_DESC ,MISC_CUST_ZIP_DESC ,MISC_CUST_LONG_NAME_CHINESE ,MISC_CUST_SHORT\
_NAME_CHINESE ,MISC_CUST_ADD1_DESC_CHINESE ,MISC_CUST_ADD2_DESC_CHINESE ,MIS\
C_CUST_ADD3_DESC_CHINESE ,MISC_CUST_ZIP_DESC_CHINESE ,TEL_NUM ,CONTACT_NAME \
,CONTACT_NAME_TITLE ,PRINT_FLAG ,ROWID  from AR_CASHIER where ((((((DOC_TYPE\
_CODE>=NVL(:b0,'      ') and DOC_TYPE_CODE<=NV");
       sqlstm.stmt = sq0005;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )134;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
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
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )12;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_num;
       sqlstm.sqhstl[3] = (unsigned int  )12;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )14;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_date;
       sqlstm.sqhstl[5] = (unsigned int  )14;
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


   }
   else  {

       /* EXEC SQL OPEN BL_REC_HDR_CUR1; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 15;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlbuft((void **)0, 
         "select DOC_TYPE_CODE ,DOC_NUM ,ACC_ENTITY_CODE ,PARTY_TYPE_CODE ,T\
O_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,CUST_CODE ,MAIN_ACC1_CODE_BANK ,MAIN\
_ACC2_CODE_BANK ,SUBLEDGER_GROUP_CODE_BANK ,SUBLEDGER_LINE_CODE_BANK ,DEPT_C\
ODE_BANK ,PRODUCT_GROUP_CODE_BANK ,PRODUCT_LINE_CODE_BANK ,MAIN_ACC1_CODE_SU\
SP ,MAIN_ACC2_CODE_SUSP ,SUBLEDGER_GROUP_CODE_SUSP ,SUBLEDGER_LINE_CODE_SUSP\
 ,DEPT_CODE_SUSP ,PRODUCT_GROUP_CODE_SUSP ,PRODUCT_LINE_CODE_SUSP ,AMT_FOREI\
GN ,AMT_LOCAL ,NARRATION ,POST_MONTH ,POST_YEAR ,CURRENCY_CODE ,EXCHG_RATE ,\
BANK_DESC ,CHEQUE_NUM ,TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY') ,MISC_CUST_LONG_NAM\
E ,MISC_CUST_SHORT_NAME ,MISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,MISC_CUST\
_ADD3_DESC ,MISC_CUST_ZIP_DESC ,MISC_CUST_LONG_NAME_CHINESE ,MISC_CUST_SHORT\
_NAME_CHINESE ,MISC_CUST_ADD1_DESC_CHINESE ,MISC_CUST_ADD2_DESC_CHINESE ,MIS\
C_CUST_ADD3_DESC_CHINESE ,MISC_CUST_ZIP_DESC_CHINESE ,TEL_NUM ,CONTACT_NAME \
,CONTACT_NAME_TITLE ,PRINT_FLAG ,ROWID  from AR_CASHIER where ((((((DOC_TYPE\
_CODE>=NVL(:b0,'      ') and DOC_TYPE_CODE<=NV");
       sqlstm.stmt = sq0004;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )173;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
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
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )12;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_num;
       sqlstm.sqhstl[3] = (unsigned int  )12;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )14;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_date;
       sqlstm.sqhstl[5] = (unsigned int  )14;
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


   }

   if(OERROR)
       err_mesg("OPEN failed on CURSOR BL_REC_HDR_CUR",0,"");


   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
             SELECT NVL(DOC_PRINT_FLAG,'X')
               FROM GL_ACC_ENTITY_DOC_TYPE_VW
              WHERE DOC_TYPE_CODE   = :d_rc_hdr_doc_type_code; */ 

    
    /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
              SELECT DECODE(CHINESE_REPORTING_FLAG,'Y',
                     LONG_NAME_CHINESE,LONG_NAME)
                FROM AR_CUSTOMER
               WHERE CUST_CODE = :d_rc_hdr_cust_code; */ 


}


fetch_rec()
{
   d_rc_hdr_doc_type_code.arr[0]     = '\0';
   d_rc_hdr_doc_num.arr[0]           = '\0';

   d_rc_hdr_doc_type_code.len        = 0;
   d_rc_hdr_doc_num.len              = 0;

d_rc_hdr_acc_entity_code.arr[0]           = '\0';
d_rc_hdr_party_type_code.arr[0]           = '\0';
d_rc_hdr_doc_date.arr[0]                  = '\0';
d_rc_hdr_doc_ref.arr[0]                   = '\0';
d_rc_hdr_cust_code.arr[0]                 = '\0';
d_rc_hdr_main_acc1_code_bk.arr[0]       = '\0';
d_rc_hdr_main_acc2_code_bk.arr[0]       = '\0';
d_rc_hdr_subl_group_code_bk.arr[0]      = '\0';
d_rc_hdr_subl_line_code_bk.arr[0]       = '\0';
d_rc_hdr_dept_code_bk.arr[0]            = '\0';
d_rc_hdr_pr_group_code_bk.arr[0]        = '\0';
d_rc_hdr_pr_line_code_bk.arr[0]         = '\0';
d_rc_hdr_main_acc1_code_sp.arr[0]       = '\0';
d_rc_hdr_main_acc2_code_sp.arr[0]       = '\0';
d_rc_hdr_subl_group_code_sp.arr[0]      = '\0';
d_rc_hdr_subl_line_code_sp.arr[0]       = '\0';
d_rc_hdr_dept_code_sp.arr[0]            = '\0';
d_rc_hdr_pr_group_code_sp.arr[0]        = '\0';
d_rc_hdr_pr_line_code_sp.arr[0]         = '\0';
d_rc_hdr_amt_foreign.arr[0]               = '\0';
d_rc_hdr_amt_local.arr[0]                 = '\0';
d_rc_hdr_narration.arr[0]                 = '\0';
d_rc_hdr_post_month.arr[0]                = '\0';
d_rc_hdr_post_year.arr[0]                 = '\0';
d_rc_hdr_currency_code.arr[0]             = '\0';
d_rc_hdr_exchg_rate.arr[0]                = '\0';
d_rc_hdr_bank_desc.arr[0]                 = '\0';
d_rc_hdr_cheque_num.arr[0]                = '\0';
d_rc_hdr_cheque_date.arr[0]               = '\0';
d_rc_hdr_misc_clong_name.arr[0]       = '\0';
d_rc_hdr_misc_cshort_name.arr[0]      = '\0';
d_rc_hdr_misc_cadd1_desc.arr[0]       = '\0';
d_rc_hdr_misc_cadd2_desc.arr[0]       = '\0';
d_rc_hdr_misc_cadd3_desc.arr[0]       = '\0';
d_rc_hdr_misc_czip_desc.arr[0]        = '\0';
d_rc_hdr_misc_long_name_ch.arr[0]         = '\0';
d_rc_hdr_misc_short_name_ch.arr[0]        = '\0';
d_rc_hdr_misc_add1_desc_ch.arr[0]         = '\0';
d_rc_hdr_misc_add2_desc_ch.arr[0]         = '\0';
d_rc_hdr_misc_add3_desc_ch.arr[0]         = '\0';
d_rc_hdr_misc_zip_desc_ch.arr[0]          = '\0';
d_rc_hdr_tel_num.arr[0]                   = '\0';
d_rc_hdr_contact_name.arr[0]              = '\0';
d_rc_hdr_contact_name_title.arr[0]        = '\0';
d_rc_hdr_rowid.arr[0]                     = '\0';
d_rc_hdr_print_flag.arr[0]                = '\0';


d_rc_hdr_acc_entity_code.len               = 0;
d_rc_hdr_party_type_code.len               = 0;
d_rc_hdr_doc_date.len                      = 0;
d_rc_hdr_doc_ref.len                       = 0;
d_rc_hdr_cust_code.len                     = 0;
d_rc_hdr_main_acc1_code_bk.len           = 0;
d_rc_hdr_main_acc2_code_bk.len           = 0;
d_rc_hdr_subl_group_code_bk.len          = 0;
d_rc_hdr_subl_line_code_bk.len           = 0;
d_rc_hdr_dept_code_bk.len                = 0;
d_rc_hdr_pr_group_code_bk.len            = 0;
d_rc_hdr_pr_line_code_bk.len             = 0;
d_rc_hdr_main_acc1_code_sp.len           = 0;
d_rc_hdr_main_acc2_code_sp.len           = 0;
d_rc_hdr_subl_group_code_sp.len          = 0;
d_rc_hdr_subl_line_code_sp.len           = 0;
d_rc_hdr_dept_code_sp.len                = 0;
d_rc_hdr_pr_group_code_sp.len            = 0;
d_rc_hdr_pr_line_code_sp.len             = 0;
d_rc_hdr_amt_foreign.len                   = 0;
d_rc_hdr_amt_local.len                     = 0;
d_rc_hdr_narration.len                     = 0;
d_rc_hdr_post_month.len                    = 0;
d_rc_hdr_post_year.len                     = 0;
d_rc_hdr_currency_code.len                 = 0;
d_rc_hdr_exchg_rate.len                    = 0;
d_rc_hdr_bank_desc.len                     = 0;
d_rc_hdr_cheque_num.len                    = 0;
d_rc_hdr_cheque_date.len                   = 0;
d_rc_hdr_misc_clong_name.len           = 0;
d_rc_hdr_misc_cshort_name.len          = 0;
d_rc_hdr_misc_cadd1_desc.len           = 0;
d_rc_hdr_misc_cadd2_desc.len           = 0;
d_rc_hdr_misc_cadd3_desc.len           = 0;
d_rc_hdr_misc_czip_desc.len            = 0;
d_rc_hdr_misc_long_name_ch.len             = 0;
d_rc_hdr_misc_short_name_ch.len            = 0;
d_rc_hdr_misc_add1_desc_ch.len             = 0;
d_rc_hdr_misc_add2_desc_ch.len             = 0;
d_rc_hdr_misc_add3_desc_ch.len             = 0;
d_rc_hdr_misc_zip_desc_ch.len              = 0;
d_rc_hdr_tel_num.len                       = 0;
d_rc_hdr_contact_name.len                  = 0;
d_rc_hdr_contact_name_title.len            = 0;
d_rc_hdr_print_flag.len                    = 0;
d_rc_hdr_rowid.len                         = 0;


if(nd_bank_flag.arr[0] == 'Y') {
   /* EXEC SQL FETCH BL_REC_HDR_CUR2
             INTO :d_rc_hdr_doc_type_code, 
                  :d_rc_hdr_doc_num,
                  :d_rc_hdr_acc_entity_code,
                  :d_rc_hdr_party_type_code,
                  :d_rc_hdr_doc_date,
                  :d_rc_hdr_doc_ref,
                  :d_rc_hdr_cust_code,
                  :d_rc_hdr_main_acc1_code_bk,
                  :d_rc_hdr_main_acc2_code_bk,
                  :d_rc_hdr_subl_group_code_bk,
                  :d_rc_hdr_subl_line_code_bk,
                  :d_rc_hdr_dept_code_bk,
                  :d_rc_hdr_pr_group_code_bk,
                  :d_rc_hdr_pr_line_code_bk,
                  :d_rc_hdr_main_acc1_code_sp,
                  :d_rc_hdr_main_acc2_code_sp,
                  :d_rc_hdr_subl_group_code_sp,
                  :d_rc_hdr_subl_line_code_sp,
                  :d_rc_hdr_dept_code_sp,
                  :d_rc_hdr_pr_group_code_sp,
                  :d_rc_hdr_pr_line_code_sp,
                  :d_rc_hdr_amt_foreign,
                  :d_rc_hdr_amt_local,
                  :d_rc_hdr_narration,
                  :d_rc_hdr_post_month,
                  :d_rc_hdr_post_year,
                  :d_rc_hdr_currency_code,
                  :d_rc_hdr_exchg_rate,
                  :d_rc_hdr_bank_desc,
                  :d_rc_hdr_cheque_num,
                  :d_rc_hdr_cheque_date,
                  :d_rc_hdr_misc_clong_name,
                  :d_rc_hdr_misc_cshort_name,
                  :d_rc_hdr_misc_cadd1_desc,
                  :d_rc_hdr_misc_cadd2_desc,
                  :d_rc_hdr_misc_cadd3_desc,
                  :d_rc_hdr_misc_czip_desc,
                  :d_rc_hdr_misc_long_name_ch,
                  :d_rc_hdr_misc_short_name_ch,
                  :d_rc_hdr_misc_add1_desc_ch,
                  :d_rc_hdr_misc_add2_desc_ch,
                  :d_rc_hdr_misc_add3_desc_ch,
                  :d_rc_hdr_misc_zip_desc_ch,
                  :d_rc_hdr_tel_num,
                  :d_rc_hdr_contact_name,
                  :d_rc_hdr_contact_name_title,
                  :d_rc_hdr_print_flag,
                  :d_rc_hdr_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )212;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_rc_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_acc_entity_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_party_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )17;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_doc_ref;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_cust_code;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_main_acc1_code_bk;
   sqlstm.sqhstl[7] = (unsigned int  )9;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_rc_hdr_main_acc2_code_bk;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_rc_hdr_subl_group_code_bk;
   sqlstm.sqhstl[9] = (unsigned int  )6;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_rc_hdr_subl_line_code_bk;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_rc_hdr_dept_code_bk;
   sqlstm.sqhstl[11] = (unsigned int  )13;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_rc_hdr_pr_group_code_bk;
   sqlstm.sqhstl[12] = (unsigned int  )6;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_rc_hdr_pr_line_code_bk;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_rc_hdr_main_acc1_code_sp;
   sqlstm.sqhstl[14] = (unsigned int  )9;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_rc_hdr_main_acc2_code_sp;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_rc_hdr_subl_group_code_sp;
   sqlstm.sqhstl[16] = (unsigned int  )6;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_rc_hdr_subl_line_code_sp;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_rc_hdr_dept_code_sp;
   sqlstm.sqhstl[18] = (unsigned int  )13;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_rc_hdr_pr_group_code_sp;
   sqlstm.sqhstl[19] = (unsigned int  )6;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_rc_hdr_pr_line_code_sp;
   sqlstm.sqhstl[20] = (unsigned int  )7;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_rc_hdr_amt_foreign;
   sqlstm.sqhstl[21] = (unsigned int  )19;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_rc_hdr_amt_local;
   sqlstm.sqhstl[22] = (unsigned int  )19;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_rc_hdr_narration;
   sqlstm.sqhstl[23] = (unsigned int  )53;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_rc_hdr_post_month;
   sqlstm.sqhstl[24] = (unsigned int  )5;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_rc_hdr_post_year;
   sqlstm.sqhstl[25] = (unsigned int  )7;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&d_rc_hdr_currency_code;
   sqlstm.sqhstl[26] = (unsigned int  )9;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&d_rc_hdr_exchg_rate;
   sqlstm.sqhstl[27] = (unsigned int  )17;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&d_rc_hdr_bank_desc;
   sqlstm.sqhstl[28] = (unsigned int  )33;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&d_rc_hdr_cheque_num;
   sqlstm.sqhstl[29] = (unsigned int  )13;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&d_rc_hdr_cheque_date;
   sqlstm.sqhstl[30] = (unsigned int  )17;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&d_rc_hdr_misc_clong_name;
   sqlstm.sqhstl[31] = (unsigned int  )103;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&d_rc_hdr_misc_cshort_name;
   sqlstm.sqhstl[32] = (unsigned int  )103;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&d_rc_hdr_misc_cadd1_desc;
   sqlstm.sqhstl[33] = (unsigned int  )63;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&d_rc_hdr_misc_cadd2_desc;
   sqlstm.sqhstl[34] = (unsigned int  )63;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&d_rc_hdr_misc_cadd3_desc;
   sqlstm.sqhstl[35] = (unsigned int  )63;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&d_rc_hdr_misc_czip_desc;
   sqlstm.sqhstl[36] = (unsigned int  )33;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&d_rc_hdr_misc_long_name_ch;
   sqlstm.sqhstl[37] = (unsigned int  )103;
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&d_rc_hdr_misc_short_name_ch;
   sqlstm.sqhstl[38] = (unsigned int  )103;
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&d_rc_hdr_misc_add1_desc_ch;
   sqlstm.sqhstl[39] = (unsigned int  )63;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&d_rc_hdr_misc_add2_desc_ch;
   sqlstm.sqhstl[40] = (unsigned int  )63;
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&d_rc_hdr_misc_add3_desc_ch;
   sqlstm.sqhstl[41] = (unsigned int  )63;
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqhstv[42] = (         void  *)&d_rc_hdr_misc_zip_desc_ch;
   sqlstm.sqhstl[42] = (unsigned int  )33;
   sqlstm.sqhsts[42] = (         int  )0;
   sqlstm.sqindv[42] = (         void  *)0;
   sqlstm.sqinds[42] = (         int  )0;
   sqlstm.sqharm[42] = (unsigned int  )0;
   sqlstm.sqadto[42] = (unsigned short )0;
   sqlstm.sqtdso[42] = (unsigned short )0;
   sqlstm.sqhstv[43] = (         void  *)&d_rc_hdr_tel_num;
   sqlstm.sqhstl[43] = (unsigned int  )33;
   sqlstm.sqhsts[43] = (         int  )0;
   sqlstm.sqindv[43] = (         void  *)0;
   sqlstm.sqinds[43] = (         int  )0;
   sqlstm.sqharm[43] = (unsigned int  )0;
   sqlstm.sqadto[43] = (unsigned short )0;
   sqlstm.sqtdso[43] = (unsigned short )0;
   sqlstm.sqhstv[44] = (         void  *)&d_rc_hdr_contact_name;
   sqlstm.sqhstl[44] = (unsigned int  )103;
   sqlstm.sqhsts[44] = (         int  )0;
   sqlstm.sqindv[44] = (         void  *)0;
   sqlstm.sqinds[44] = (         int  )0;
   sqlstm.sqharm[44] = (unsigned int  )0;
   sqlstm.sqadto[44] = (unsigned short )0;
   sqlstm.sqtdso[44] = (unsigned short )0;
   sqlstm.sqhstv[45] = (         void  *)&d_rc_hdr_contact_name_title;
   sqlstm.sqhstl[45] = (unsigned int  )63;
   sqlstm.sqhsts[45] = (         int  )0;
   sqlstm.sqindv[45] = (         void  *)0;
   sqlstm.sqinds[45] = (         int  )0;
   sqlstm.sqharm[45] = (unsigned int  )0;
   sqlstm.sqadto[45] = (unsigned short )0;
   sqlstm.sqtdso[45] = (unsigned short )0;
   sqlstm.sqhstv[46] = (         void  *)&d_rc_hdr_print_flag;
   sqlstm.sqhstl[46] = (unsigned int  )4;
   sqlstm.sqhsts[46] = (         int  )0;
   sqlstm.sqindv[46] = (         void  *)0;
   sqlstm.sqinds[46] = (         int  )0;
   sqlstm.sqharm[46] = (unsigned int  )0;
   sqlstm.sqadto[46] = (unsigned short )0;
   sqlstm.sqtdso[46] = (unsigned short )0;
   sqlstm.sqhstv[47] = (         void  *)&d_rc_hdr_rowid;
   sqlstm.sqhstl[47] = (unsigned int  )33;
   sqlstm.sqhsts[47] = (         int  )0;
   sqlstm.sqindv[47] = (         void  *)0;
   sqlstm.sqinds[47] = (         int  )0;
   sqlstm.sqharm[47] = (unsigned int  )0;
   sqlstm.sqadto[47] = (unsigned short )0;
   sqlstm.sqtdso[47] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
else {
   /* EXEC SQL FETCH BL_REC_HDR_CUR1
             INTO :d_rc_hdr_doc_type_code, 
                  :d_rc_hdr_doc_num,
                  :d_rc_hdr_acc_entity_code,
                  :d_rc_hdr_party_type_code,
                  :d_rc_hdr_doc_date,
                  :d_rc_hdr_doc_ref,
                  :d_rc_hdr_cust_code,
                  :d_rc_hdr_main_acc1_code_bk,
                  :d_rc_hdr_main_acc2_code_bk,
                  :d_rc_hdr_subl_group_code_bk,
                  :d_rc_hdr_subl_line_code_bk,
                  :d_rc_hdr_dept_code_bk,
                  :d_rc_hdr_pr_group_code_bk,
                  :d_rc_hdr_pr_line_code_bk,
                  :d_rc_hdr_main_acc1_code_sp,
                  :d_rc_hdr_main_acc2_code_sp,
                  :d_rc_hdr_subl_group_code_sp,
                  :d_rc_hdr_subl_line_code_sp,
                  :d_rc_hdr_dept_code_sp,
                  :d_rc_hdr_pr_group_code_sp,
                  :d_rc_hdr_pr_line_code_sp,
                  :d_rc_hdr_amt_foreign,
                  :d_rc_hdr_amt_local,
                  :d_rc_hdr_narration,
                  :d_rc_hdr_post_month,
                  :d_rc_hdr_post_year,
                  :d_rc_hdr_currency_code,
                  :d_rc_hdr_exchg_rate,
                  :d_rc_hdr_bank_desc,
                  :d_rc_hdr_cheque_num,
                  :d_rc_hdr_cheque_date,
                  :d_rc_hdr_misc_clong_name,
                  :d_rc_hdr_misc_cshort_name,
                  :d_rc_hdr_misc_cadd1_desc,
                  :d_rc_hdr_misc_cadd2_desc,
                  :d_rc_hdr_misc_cadd3_desc,
                  :d_rc_hdr_misc_czip_desc,
                  :d_rc_hdr_misc_long_name_ch,
                  :d_rc_hdr_misc_short_name_ch,
                  :d_rc_hdr_misc_add1_desc_ch,
                  :d_rc_hdr_misc_add2_desc_ch,
                  :d_rc_hdr_misc_add3_desc_ch,
                  :d_rc_hdr_misc_zip_desc_ch,
                  :d_rc_hdr_tel_num,
                  :d_rc_hdr_contact_name,
                  :d_rc_hdr_contact_name_title,
                  :d_rc_hdr_print_flag,
                  :d_rc_hdr_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )419;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_rc_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_acc_entity_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_party_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )17;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_doc_ref;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_cust_code;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_main_acc1_code_bk;
   sqlstm.sqhstl[7] = (unsigned int  )9;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_rc_hdr_main_acc2_code_bk;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_rc_hdr_subl_group_code_bk;
   sqlstm.sqhstl[9] = (unsigned int  )6;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_rc_hdr_subl_line_code_bk;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_rc_hdr_dept_code_bk;
   sqlstm.sqhstl[11] = (unsigned int  )13;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_rc_hdr_pr_group_code_bk;
   sqlstm.sqhstl[12] = (unsigned int  )6;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_rc_hdr_pr_line_code_bk;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_rc_hdr_main_acc1_code_sp;
   sqlstm.sqhstl[14] = (unsigned int  )9;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_rc_hdr_main_acc2_code_sp;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_rc_hdr_subl_group_code_sp;
   sqlstm.sqhstl[16] = (unsigned int  )6;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_rc_hdr_subl_line_code_sp;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_rc_hdr_dept_code_sp;
   sqlstm.sqhstl[18] = (unsigned int  )13;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_rc_hdr_pr_group_code_sp;
   sqlstm.sqhstl[19] = (unsigned int  )6;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_rc_hdr_pr_line_code_sp;
   sqlstm.sqhstl[20] = (unsigned int  )7;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_rc_hdr_amt_foreign;
   sqlstm.sqhstl[21] = (unsigned int  )19;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_rc_hdr_amt_local;
   sqlstm.sqhstl[22] = (unsigned int  )19;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_rc_hdr_narration;
   sqlstm.sqhstl[23] = (unsigned int  )53;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_rc_hdr_post_month;
   sqlstm.sqhstl[24] = (unsigned int  )5;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_rc_hdr_post_year;
   sqlstm.sqhstl[25] = (unsigned int  )7;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&d_rc_hdr_currency_code;
   sqlstm.sqhstl[26] = (unsigned int  )9;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&d_rc_hdr_exchg_rate;
   sqlstm.sqhstl[27] = (unsigned int  )17;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&d_rc_hdr_bank_desc;
   sqlstm.sqhstl[28] = (unsigned int  )33;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&d_rc_hdr_cheque_num;
   sqlstm.sqhstl[29] = (unsigned int  )13;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&d_rc_hdr_cheque_date;
   sqlstm.sqhstl[30] = (unsigned int  )17;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&d_rc_hdr_misc_clong_name;
   sqlstm.sqhstl[31] = (unsigned int  )103;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&d_rc_hdr_misc_cshort_name;
   sqlstm.sqhstl[32] = (unsigned int  )103;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&d_rc_hdr_misc_cadd1_desc;
   sqlstm.sqhstl[33] = (unsigned int  )63;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&d_rc_hdr_misc_cadd2_desc;
   sqlstm.sqhstl[34] = (unsigned int  )63;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&d_rc_hdr_misc_cadd3_desc;
   sqlstm.sqhstl[35] = (unsigned int  )63;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&d_rc_hdr_misc_czip_desc;
   sqlstm.sqhstl[36] = (unsigned int  )33;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&d_rc_hdr_misc_long_name_ch;
   sqlstm.sqhstl[37] = (unsigned int  )103;
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&d_rc_hdr_misc_short_name_ch;
   sqlstm.sqhstl[38] = (unsigned int  )103;
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&d_rc_hdr_misc_add1_desc_ch;
   sqlstm.sqhstl[39] = (unsigned int  )63;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&d_rc_hdr_misc_add2_desc_ch;
   sqlstm.sqhstl[40] = (unsigned int  )63;
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&d_rc_hdr_misc_add3_desc_ch;
   sqlstm.sqhstl[41] = (unsigned int  )63;
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqhstv[42] = (         void  *)&d_rc_hdr_misc_zip_desc_ch;
   sqlstm.sqhstl[42] = (unsigned int  )33;
   sqlstm.sqhsts[42] = (         int  )0;
   sqlstm.sqindv[42] = (         void  *)0;
   sqlstm.sqinds[42] = (         int  )0;
   sqlstm.sqharm[42] = (unsigned int  )0;
   sqlstm.sqadto[42] = (unsigned short )0;
   sqlstm.sqtdso[42] = (unsigned short )0;
   sqlstm.sqhstv[43] = (         void  *)&d_rc_hdr_tel_num;
   sqlstm.sqhstl[43] = (unsigned int  )33;
   sqlstm.sqhsts[43] = (         int  )0;
   sqlstm.sqindv[43] = (         void  *)0;
   sqlstm.sqinds[43] = (         int  )0;
   sqlstm.sqharm[43] = (unsigned int  )0;
   sqlstm.sqadto[43] = (unsigned short )0;
   sqlstm.sqtdso[43] = (unsigned short )0;
   sqlstm.sqhstv[44] = (         void  *)&d_rc_hdr_contact_name;
   sqlstm.sqhstl[44] = (unsigned int  )103;
   sqlstm.sqhsts[44] = (         int  )0;
   sqlstm.sqindv[44] = (         void  *)0;
   sqlstm.sqinds[44] = (         int  )0;
   sqlstm.sqharm[44] = (unsigned int  )0;
   sqlstm.sqadto[44] = (unsigned short )0;
   sqlstm.sqtdso[44] = (unsigned short )0;
   sqlstm.sqhstv[45] = (         void  *)&d_rc_hdr_contact_name_title;
   sqlstm.sqhstl[45] = (unsigned int  )63;
   sqlstm.sqhsts[45] = (         int  )0;
   sqlstm.sqindv[45] = (         void  *)0;
   sqlstm.sqinds[45] = (         int  )0;
   sqlstm.sqharm[45] = (unsigned int  )0;
   sqlstm.sqadto[45] = (unsigned short )0;
   sqlstm.sqtdso[45] = (unsigned short )0;
   sqlstm.sqhstv[46] = (         void  *)&d_rc_hdr_print_flag;
   sqlstm.sqhstl[46] = (unsigned int  )4;
   sqlstm.sqhsts[46] = (         int  )0;
   sqlstm.sqindv[46] = (         void  *)0;
   sqlstm.sqinds[46] = (         int  )0;
   sqlstm.sqharm[46] = (unsigned int  )0;
   sqlstm.sqadto[46] = (unsigned short )0;
   sqlstm.sqtdso[46] = (unsigned short )0;
   sqlstm.sqhstv[47] = (         void  *)&d_rc_hdr_rowid;
   sqlstm.sqhstl[47] = (unsigned int  )33;
   sqlstm.sqhsts[47] = (         int  )0;
   sqlstm.sqindv[47] = (         void  *)0;
   sqlstm.sqinds[47] = (         int  )0;
   sqlstm.sqharm[47] = (unsigned int  )0;
   sqlstm.sqadto[47] = (unsigned short )0;
   sqlstm.sqtdso[47] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
         err_mesg("FETCH failed on cursor BL_REC_HDR_CUR",0,"");

   if (LAST_ROW)
       return(0);

   d_rc_hdr_doc_type_code.arr[d_rc_hdr_doc_type_code.len]     = '\0';
   d_rc_hdr_doc_num.arr[d_rc_hdr_doc_num.len]                 = '\0';

d_rc_hdr_acc_entity_code.arr[d_rc_hdr_acc_entity_code.len]             = '\0';
d_rc_hdr_party_type_code.arr[d_rc_hdr_party_type_code.len]             = '\0';
d_rc_hdr_doc_date.arr[d_rc_hdr_doc_date.len]                           = '\0';
d_rc_hdr_doc_ref.arr[d_rc_hdr_doc_ref.len]                             = '\0';
d_rc_hdr_cust_code.arr[d_rc_hdr_cust_code.len]                         = '\0';

d_rc_hdr_main_acc1_code_bk.arr[d_rc_hdr_main_acc1_code_bk.len]     = '\0';
d_rc_hdr_main_acc2_code_bk.arr[d_rc_hdr_main_acc2_code_bk.len]     = '\0';
d_rc_hdr_subl_group_code_bk.arr[d_rc_hdr_subl_group_code_bk.len]   = '\0';
d_rc_hdr_subl_line_code_bk.arr[d_rc_hdr_subl_line_code_bk.len]     = '\0';
d_rc_hdr_dept_code_bk.arr[d_rc_hdr_dept_code_bk.len]               = '\0';
d_rc_hdr_pr_group_code_bk.arr[d_rc_hdr_pr_group_code_bk.len]       = '\0';
d_rc_hdr_pr_line_code_bk.arr[d_rc_hdr_pr_line_code_bk.len]         = '\0';

d_rc_hdr_main_acc1_code_sp.arr[d_rc_hdr_main_acc1_code_sp.len]     = '\0';
d_rc_hdr_main_acc2_code_sp.arr[d_rc_hdr_main_acc2_code_sp.len]     = '\0';
d_rc_hdr_subl_group_code_sp.arr[d_rc_hdr_subl_group_code_sp.len]   = '\0';
d_rc_hdr_subl_line_code_sp.arr[d_rc_hdr_subl_line_code_sp.len]     = '\0';
d_rc_hdr_dept_code_sp.arr[d_rc_hdr_dept_code_sp.len]               = '\0';
d_rc_hdr_pr_group_code_sp.arr[d_rc_hdr_pr_group_code_sp.len]       = '\0';
d_rc_hdr_pr_line_code_sp.arr[d_rc_hdr_pr_line_code_sp.len]         = '\0';

d_rc_hdr_amt_foreign.arr[d_rc_hdr_amt_foreign.len]                     = '\0';
d_rc_hdr_amt_local.arr[d_rc_hdr_amt_local.len]                         = '\0';
d_rc_hdr_narration.arr[d_rc_hdr_narration.len]                         = '\0';
d_rc_hdr_post_month.arr[d_rc_hdr_post_month.len]                       = '\0';
d_rc_hdr_post_year.arr[d_rc_hdr_post_year.len]                         = '\0';
d_rc_hdr_currency_code.arr[d_rc_hdr_currency_code.len]                 = '\0';
d_rc_hdr_exchg_rate.arr[d_rc_hdr_exchg_rate.len]                       = '\0';
d_rc_hdr_bank_desc.arr[d_rc_hdr_bank_desc.len]                         = '\0';
d_rc_hdr_cheque_num.arr[d_rc_hdr_cheque_num.len]                       = '\0';
d_rc_hdr_cheque_date.arr[d_rc_hdr_cheque_date.len]                     = '\0';
d_rc_hdr_misc_clong_name.arr[d_rc_hdr_misc_clong_name.len]     = '\0';
d_rc_hdr_misc_cshort_name.arr[d_rc_hdr_misc_cshort_name.len]   = '\0';
d_rc_hdr_misc_cadd1_desc.arr[d_rc_hdr_misc_cadd1_desc.len]     = '\0';
d_rc_hdr_misc_cadd2_desc.arr[d_rc_hdr_misc_cadd2_desc.len]     = '\0';
d_rc_hdr_misc_cadd3_desc.arr[d_rc_hdr_misc_cadd3_desc.len]     = '\0';
d_rc_hdr_misc_czip_desc.arr[d_rc_hdr_misc_czip_desc.len]       = '\0';
d_rc_hdr_misc_long_name_ch.arr[d_rc_hdr_misc_long_name_ch.len]         = '\0';
d_rc_hdr_misc_short_name_ch.arr[d_rc_hdr_misc_short_name_ch.len]       = '\0';
d_rc_hdr_misc_add1_desc_ch.arr[d_rc_hdr_misc_add1_desc_ch.len]         = '\0';
d_rc_hdr_misc_add2_desc_ch.arr[d_rc_hdr_misc_add2_desc_ch.len]         = '\0';
d_rc_hdr_misc_add3_desc_ch.arr[d_rc_hdr_misc_add3_desc_ch.len]         = '\0';
d_rc_hdr_misc_zip_desc_ch.arr[d_rc_hdr_misc_zip_desc_ch.len]           = '\0';
d_rc_hdr_tel_num.arr[d_rc_hdr_tel_num.len]                             = '\0';
d_rc_hdr_contact_name.arr[d_rc_hdr_contact_name.len]                   = '\0';
d_rc_hdr_contact_name_title.arr[d_rc_hdr_contact_name_title.len]       = '\0';
d_rc_hdr_print_flag.arr[d_rc_hdr_print_flag.len]                       = '\0';
d_rc_hdr_rowid.arr[d_rc_hdr_rowid.len]                                 = '\0';

return(1);

}


sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )626;
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

fetch_parameter()
{

     /* EXEC SQL SELECT CURRENT_ACC_YEAR,CURRENT_ACC_MONTH,
                     PRIOR_POSTING_ALLOW_FLAG,
                     NVL(SUMMARY_PROCESS_FLAG,'X') 
                INTO :curr_acc_year,    :curr_acc_month,
                     :prior_post_allow, :gl_summ_pro_flag
                FROM GL_PARAMETER; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 48;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select CURRENT_ACC_YEAR ,CURRENT_ACC_MONTH ,PRIOR_POSTIN\
G_ALLOW_FLAG ,NVL(SUMMARY_PROCESS_FLAG,'X') into :b0,:b1,:b2,:b3  from GL_PARA\
METER ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )657;
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

     d_num_of_acc_periods = 0;

     /* EXEC SQL SELECT NUM_OF_ACC_PERIODS , ACC_ENTITY_CODE,
	                 NO_OF_DECIMAL
                INTO :d_num_of_acc_periods , :nd_acc_entity_code ,
				     :nd_no_of_decimal
              FROM SY_ACC_ENTITY
			  where   ACC_ENTITY_ID = :nd_facility_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 48;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NUM_OF_ACC_PERIODS ,ACC_ENTITY_CODE ,NO_OF_DECIMA\
L into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )688;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_num_of_acc_periods;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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

d_curr_year  = atoi(curr_acc_year.arr);
d_curr_month = atoi(curr_acc_month.arr);
d_summ_flag  = gl_summ_pro_flag.arr[0];

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

fetch_detls()
{
    /* EXEC SQL SELECT ACCOUNTING_NAME,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
	     INTO   :comp_name,
		    :rep_date,
		    :oper_id
	     FROM   SY_ACC_ENTITY
		 where   ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )719;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )52;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&oper_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
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

;

    if(OERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';


}

open_files()
{
   char		txt_msg[101];
   if ((f1 = fopen(filename,"w")) == NULL)
   {
        sprintf(txt_msg,"Error While Opening File %s",filename);
		err_mesg(txt_msg,0,"");
		//err_mesg("\nError while opening File arrorpst.lis\n",0,"");
        exit(0);
   }

}


chk_break(nol) 
int nol;
{

	if(line_no+nol >= 55) {
           fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
	}

}


put_hdr()
{
  void print_hospital_name();
/*
    fprintf(f1,"MDL : AR                                       %30s                                      %s\n",comp_name.arr,rep_date.arr);
*/
    print_hospital_name(132,"AR",comp_name.arr,rep_date.arr);
    fprintf(f1,"OPR : %s\n",oper_id.arr);

    fprintf(f1,"REP : ARRORLST                                        CASHIER RECEIPTS - EDIT LIST                                       PAGE : %4d\n",page_no);

    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"DOCUMENT  DOCUMENT    DOCUMENT     POST       DOCUMENT          CUSTOMER   CUSTOMER NAME                                   DOCUMENT \n");
    fprintf(f1,"TYPE        NUMBER    DATE         MTH/YR     REFERENCE         CODE                                                         AMOUNT \n");
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n"); 

    line_no=8;

}

put_doc_hdr()
{

    char s_amt[20];

    d_amt_local             = 0;
    d_conv_date_doc.arr[0]  = '\0';
    d_conv_date_bank.arr[0] = '\0';

    /* EXEC SQL SELECT TO_NUMBER(:d_rc_hdr_amt_local),
		    TO_CHAR(TO_DATE(:d_rc_hdr_doc_date,'DD/MM/YYYY'),'DD/MM/YYYY'),
		    TO_CHAR(TO_DATE(:d_rc_hdr_cheque_date,'DD/MM/YYYY'),'DD/MM/YYYY')
	     INTO   :d_amt_local,
		    :d_conv_date_doc,
		    :d_conv_date_bank
	     FROM   DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_NUMBER(:b0) ,TO_CHAR(TO_DATE(:b1,'DD/MM/YYYY'),\
'DD/MM/YYYY') ,TO_CHAR(TO_DATE(:b2,'DD/MM/YYYY'),'DD/MM/YYYY') into :b3,:b4,:b\
5  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )750;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_rc_hdr_amt_local;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_date;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_cheque_date;
    sqlstm.sqhstl[2] = (unsigned int  )17;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_amt_local;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_conv_date_doc;
    sqlstm.sqhstl[4] = (unsigned int  )14;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_conv_date_bank;
    sqlstm.sqhstl[5] = (unsigned int  )14;
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



    if(OERROR)
	err_mesg("SELECT failed on table DUAL",0,"");

    d_conv_date_doc.arr[d_conv_date_doc.len] = '\0';
    d_conv_date_bank.arr[d_conv_date_bank.len] = '\0';

    g_tot += d_amt_local;
    g_tot_bank += d_amt_local;
 
    if (nd_no_of_decimal == 3)
	   sprintf(s_amt,"%15.3f",d_amt_local);
    else
	   sprintf(s_amt,"%15.2f",d_amt_local);
    format_amt(s_amt,nd_no_of_decimal);

    chk_break(4); 

    fprintf(f1,"%-8s  %8s    %-12s%2s/%4s",d_rc_hdr_doc_type_code.arr,
	    d_rc_hdr_doc_num.arr,d_conv_date_doc.arr,
	    d_rc_hdr_post_month.arr,d_rc_hdr_post_year.arr);

    fprintf(f1,"     %-15s   %-10s %-40s %15s\n",d_rc_hdr_doc_ref.arr,
	    d_rc_hdr_cust_code.arr,d_ar_cust_long_name.arr,s_amt);
    fprintf(f1,"CHEQUE NO    : %-10s DATED : %-10s DRAWN ON BANK : %-30s\n",
	    d_rc_hdr_cheque_num.arr,d_conv_date_bank.arr,
	    d_rc_hdr_bank_desc.arr);

    if(nd_bank_flag.arr[0] != 'Y') {
        fprintf(f1,"BANK A/C     : %s-%s %s %s-%s %s-%s   DESC : %s\n",
        d_rc_hdr_main_acc1_code_bk.arr, d_rc_hdr_main_acc2_code_bk.arr ,
        d_rc_hdr_dept_code_bk.arr ,d_rc_hdr_pr_group_code_bk.arr,
        d_rc_hdr_pr_line_code_bk.arr,d_rc_hdr_subl_group_code_bk.arr, 
        d_rc_hdr_subl_line_code_bk.arr,d_acct_desc_bank.arr);
    }

    fprintf(f1,"SUSPENSE A/C : %s-%s %s %s-%s %s-%s   DESC : %s\n",
    d_rc_hdr_main_acc1_code_sp.arr, d_rc_hdr_main_acc2_code_sp.arr ,
    d_rc_hdr_dept_code_sp.arr ,d_rc_hdr_pr_group_code_sp.arr,
    d_rc_hdr_pr_line_code_sp.arr,d_rc_hdr_subl_group_code_sp.arr, 
    d_rc_hdr_subl_line_code_sp.arr,d_acct_desc_susp.arr);
   
   fprintf(f1,"NARRATION    : %s\n",d_rc_hdr_narration.arr); 
   if(nd_bank_flag.arr[0] != 'Y') 
       line_no += 7;
   else
       line_no += 6;

    fprintf(f1,"\n\n");


}


put_inp_parm()
{
    void print_hospital_name();
	/*
	fprintf(f1,"MDL : AR                                       %30s                                      %s\n",comp_name.arr,rep_date.arr);
    */
	print_hospital_name(132,"AR",comp_name.arr,rep_date.arr);
	fprintf(f1,"OPR : %s\n",oper_id.arr);
    fprintf(f1,"REP : ARRORLST                                        CASHIER RECEIPTS - EDIT LIST                                       PAGE : %4d\n",page_no);
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");


    fprintf(f1,"\n\n"); 
    fprintf(f1,"\n\n");
    fprintf(f1,"\tINPUT PARAMETERS\n");
    fprintf(f1,"\t----------------\n\n");
    fprintf(f1,"\t\tDOCUMENT TYPE   FROM  : %s\n",nd_fm_doc_type.arr);
    fprintf(f1,"\t\t                TO    : %s\n\n",nd_to_doc_type.arr);
    fprintf(f1,"\t\tDOCUMENT NUMBER FROM  : %s\n",nd_fm_doc_num.arr);
    fprintf(f1,"\t\t                TO    : %s\n\n",nd_to_doc_num.arr);
    fprintf(f1,"\t\tDOCUMENT DATE   FROM  : %s\n",nd_conv_fm_date.arr);
    fprintf(f1,"\t\t                TO    : %s\n\n",nd_conv_to_date.arr);
    fprintf(f1,"\t\tSORT BY BANK          : %c\n\n",nd_bank_flag.arr[0]);
    fprintf(f1,"");
    ++page_no;


}


fetch_cust_dets()
{
    /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )789;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_rc_hdr_cust_code;
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

    d_ar_cust_long_name.arr[0]          = '\0';
    d_ar_cust_long_name.len             = 0;

    /* EXEC SQL FETCH AR_CUSTOMER_CUR
              INTO :d_ar_cust_long_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )808;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_cust_long_name;
    sqlstm.sqhstl[0] = (unsigned int  )103;
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
         err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

     d_ar_cust_long_name.arr[d_ar_cust_long_name.len] = '\0';

}

get_acct_desc()
{

    d_acct_desc_bank.arr[0] = '\0';
    d_acct_desc_susp.arr[0] = '\0';

    /* EXEC SQL SELECT CONCAT_POST_ACC_DESC
	     INTO   :d_acct_desc_bank
	     FROM   GL_POSTING_ACC
	     WHERE  MAIN_ACC1_CODE       =  :d_rc_hdr_main_acc1_code_bk
	     AND    MAIN_ACC2_CODE       =  :d_rc_hdr_main_acc2_code_bk
	     AND    DEPT_CODE            =  :d_rc_hdr_dept_code_bk
	     AND    PRODUCT_GROUP_CODE   =  :d_rc_hdr_pr_group_code_bk
	     AND    PRODUCT_LINE_CODE    =  :d_rc_hdr_pr_line_code_bk
	     AND    SUBLEDGER_GROUP_CODE =  :d_rc_hdr_subl_group_code_bk
	     AND    SUBLEDGER_LINE_CODE  =  :d_rc_hdr_subl_line_code_bk; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CONCAT_POST_ACC_DESC into :b0  from GL_POSTING_ACC\
 where ((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and\
 PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:\
b6) and SUBLEDGER_LINE_CODE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )827;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_acct_desc_bank;
    sqlstm.sqhstl[0] = (unsigned int  )67;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_main_acc1_code_bk;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_main_acc2_code_bk;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_dept_code_bk;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_pr_group_code_bk;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_pr_line_code_bk;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_subl_group_code_bk;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_subl_line_code_bk;
    sqlstm.sqhstl[7] = (unsigned int  )11;
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



    if(OERROR)
	err_mesg("SELECT failed on table GL_POSTING_ACC",0,"");


    d_acct_desc_bank.arr[d_acct_desc_bank.len] = '\0';

    /* EXEC SQL SELECT CONCAT_POST_ACC_DESC
	     INTO   :d_acct_desc_susp
	     FROM   GL_POSTING_ACC
	     WHERE  MAIN_ACC1_CODE       =  :d_rc_hdr_main_acc1_code_sp
	     AND    MAIN_ACC2_CODE       =  :d_rc_hdr_main_acc2_code_sp
	     AND    DEPT_CODE            =  :d_rc_hdr_dept_code_sp
	     AND    PRODUCT_GROUP_CODE   =  :d_rc_hdr_pr_group_code_sp
	     AND    PRODUCT_LINE_CODE    =  :d_rc_hdr_pr_line_code_sp
	     AND    SUBLEDGER_GROUP_CODE =  :d_rc_hdr_subl_group_code_sp
	     AND    SUBLEDGER_LINE_CODE  =  :d_rc_hdr_subl_line_code_sp; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CONCAT_POST_ACC_DESC into :b0  from GL_POSTING_ACC\
 where ((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and\
 PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:\
b6) and SUBLEDGER_LINE_CODE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )874;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_acct_desc_susp;
    sqlstm.sqhstl[0] = (unsigned int  )67;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_main_acc1_code_sp;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_main_acc2_code_sp;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_dept_code_sp;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_pr_group_code_sp;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_pr_line_code_sp;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_subl_group_code_sp;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_subl_line_code_sp;
    sqlstm.sqhstl[7] = (unsigned int  )11;
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



    if(OERROR)
	err_mesg("SELECT failed on table GL_POSTING_ACC",0,"");


    d_acct_desc_susp.arr[d_acct_desc_susp.len] = '\0';

}

print_end_of_rep()
{
    char s_amt[20];

    if (nd_no_of_decimal == 3)
	   sprintf(s_amt,"%15.3f",g_tot);
    else
       sprintf(s_amt,"%15.2f",g_tot);
	
	format_amt(s_amt,nd_no_of_decimal);


    if(g_tot_print) {
        chk_break(3);
    
        fprintf(f1,"\n\n                                                                                    TOTAL  ------>                  %15s\n",s_amt);
        fprintf(f1,"\n\n                                              ** END OF REPORT **                                                               \n");
    }

}

copy_val()
{
    strcpy(g_main_acc1_code,       d_rc_hdr_main_acc1_code_bk.arr);
    strcpy(g_main_acc2_code,       d_rc_hdr_main_acc2_code_bk.arr);
    strcpy(g_dept_code,            d_rc_hdr_dept_code_bk.arr);
    strcpy(g_product_group_code,   d_rc_hdr_pr_group_code_bk.arr);
    strcpy(g_product_line_code,    d_rc_hdr_pr_line_code_bk.arr);
    strcpy(g_subledger_group_code, d_rc_hdr_subl_group_code_bk.arr);
    strcpy(g_subledger_line_code,  d_rc_hdr_subl_line_code_bk.arr);
}

same_acct()
{

    if(!strcmp(g_main_acc1_code,       d_rc_hdr_main_acc1_code_bk.arr) &&
       !strcmp(g_main_acc2_code,       d_rc_hdr_main_acc2_code_bk.arr) &&
       !strcmp(g_dept_code,            d_rc_hdr_dept_code_bk.arr) &&
       !strcmp(g_product_group_code,   d_rc_hdr_pr_group_code_bk.arr) &&
       !strcmp(g_product_line_code,    d_rc_hdr_pr_line_code_bk.arr) &&
       !strcmp(g_subledger_group_code, d_rc_hdr_subl_group_code_bk.arr) &&
       !strcmp(g_subledger_line_code,  d_rc_hdr_subl_line_code_bk.arr)
      ) 
	return 1;
    else
	return 0;
}


init_post_acc()
{

        g_main_acc1_code[0] = '\0';
        g_main_acc2_code[0]= '\0';
        g_dept_code[0]= '\0';
        g_product_group_code[0]= '\0';
        g_product_line_code[0]= '\0';
        g_subledger_group_code[0]= '\0';
        g_subledger_line_code[0]= '\0';

}

do_bank()
{


    if(!first_break) 
	print_bank_tot();


    chk_break(1);

    fprintf(f1,"BANK A/C     : %s-%s %s %s-%s %s-%s   DESC : %s\n\n\n",
    d_rc_hdr_main_acc1_code_bk.arr, d_rc_hdr_main_acc2_code_bk.arr ,
    d_rc_hdr_dept_code_bk.arr ,d_rc_hdr_pr_group_code_bk.arr,
    d_rc_hdr_pr_line_code_bk.arr,d_rc_hdr_subl_group_code_bk.arr, 
    d_rc_hdr_subl_line_code_bk.arr,d_acct_desc_bank.arr);

    line_no += 3;

    first_break = 0;
    g_print_bank = 0;

}

print_bank_tot()
{
    char s_amt[20];

        if (nd_no_of_decimal == 3 )
		   sprintf(s_amt,"%15.3f",g_tot_bank);
        else
		   sprintf(s_amt,"%15.2f",g_tot_bank);
        format_amt(s_amt, nd_no_of_decimal);
	chk_break(3);
        fprintf(f1,"                                                                               BANK TOTAL  ------>                  %15s\n\n\n",s_amt);
	line_no += 3;
	g_tot_bank = 0;

}
void print_hospital_name(nd_rep_width    ,
                         nd_mod_id       ,
                         nd_hospital_name,
                         nd_date          )
int  nd_rep_width;
char nd_mod_id[3];
char nd_hospital_name[31]; 
char nd_date[17];
{    
	int i = 0 , pos = 0 , len = 0, len_date = 0 , pos_date = 0,len1 = 0;

    /*Find the length of Hospital Name*/
    for(len = 0; nd_hospital_name[len] != '\0'; len++);

    /*Find the length of Date*/
    for(len_date = 0; nd_date[len_date] != '\0'; len_date++);
    
    len1 = (len % 2 );

	if (len1 == 0)
	  len1=9;
	else 
	   len1=10;
 
	
    len = (len / 2 )  ;

    pos = (nd_rep_width / 2	) - len;

	pos_date = nd_rep_width - len_date;

	fprintf(f1,"MDL : %2s",nd_mod_id);
     
    
	for(i = len1; i < pos ; fprintf(f1," "),i++);

	fprintf(f1,"%s",nd_hospital_name);

	for(i = i + (len * 2) ; i < pos_date + 1; fprintf(f1," "),i++);

    fprintf(f1,"%s\n",nd_date);
}
