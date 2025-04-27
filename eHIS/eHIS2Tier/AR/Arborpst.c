
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
           char  filnam[46];
};
static const struct sqlcxp sqlfpn =
{
    45,
    "T:\\BL\\MEDICITY_POSTING\\SOURCES\\AR\\Arborpst.pc"
};


static unsigned long sqlctx = 1188944235;


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
            void  *sqhstv[50];
   unsigned int   sqhstl[50];
            int   sqhsts[50];
            void  *sqindv[50];
            int   sqinds[50];
   unsigned int   sqharm[50];
   unsigned int   *sqharc[50];
   unsigned short  sqadto[50];
   unsigned short  sqtdso[50];
} sqlstm = {10,50};

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

 static const char *sq0004 = 
"select DOC_TYPE_CODE ,DOC_NUM  from AR_CASHIER where ((((((DOC_TYPE_CODE>=NV\
L(:b0,'      ') and DOC_TYPE_CODE<=NVL(:b1,'~~~~~~')) and DOC_NUM>=NVL(:b2,0))\
 and DOC_NUM<=NVL(:b3,99999999)) and NVL(DOC_DATE,SYSDATE)>=NVL(TO_DATE(:b4,'D\
D/MM/YYYY'),to_date('00010101','YYYYDDMM'))) and NVL(DOC_DATE,SYSDATE)<=NVL(TO\
_DATE(:b5,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))) and NVL(POSTED_FLAG,'\
N')='N')           ";

 static const char *sq0006 = 
"select NVL(DOC_PRINT_FLAG,'X')  from GL_ACC_ENTITY_DOC_TYPE_VW where DOC_TYP\
E_CODE=:b0           ";

 static const char *sq0005 = 
"_NUM=:b1) for update of ERROR_FLAG nowait ";

 static const char *sq0007 = 
"select DECODE(CHINESE_REPORTING_FLAG,'Y',RPAD(NVL(LONG_NAME_CHINESE,' '),33,\
' '),RPAD(NVL(LONG_NAME,' '),33,' '))  from AR_CUSTOMER where CUST_CODE=:b0   \
        ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,346,0,4,288,0,0,14,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
76,0,0,2,0,0,29,417,0,0,0,0,0,1,0,
91,0,0,3,0,0,30,425,0,0,0,0,0,1,0,
106,0,0,4,407,0,9,448,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
145,0,0,6,97,0,9,525,0,0,1,1,0,1,0,1,9,0,0,
164,0,0,6,0,0,13,533,0,0,1,0,0,1,0,2,9,0,0,
183,0,0,4,0,0,13,558,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
206,0,0,5,1066,0,9,678,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
229,0,0,5,0,0,13,685,0,0,50,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
444,0,0,8,455,0,3,868,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
491,0,0,9,350,0,3,926,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
558,0,0,10,358,0,3,970,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
625,0,0,11,294,0,3,1018,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
668,0,0,12,1005,0,3,1057,0,0,42,42,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
851,0,0,13,70,0,2,1175,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
874,0,0,14,71,0,2,1182,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
897,0,0,15,161,0,3,1228,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
936,0,0,16,60,0,2,1262,0,0,1,1,0,1,0,1,9,0,0,
955,0,0,17,0,0,29,1269,0,0,0,0,0,1,0,
970,0,0,18,53,0,5,1287,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
993,0,0,19,146,0,5,1296,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1020,0,0,20,0,0,27,1312,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
1051,0,0,21,62,0,4,1322,0,0,1,0,0,1,0,2,9,0,0,
1070,0,0,22,140,0,4,1332,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1101,0,0,23,118,0,4,1349,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
1132,0,0,24,128,0,4,1380,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1163,0,0,25,150,0,4,1452,0,0,6,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,4,0,0,2,9,0,0,
2,9,0,0,
1202,0,0,7,162,0,9,1535,0,0,1,1,0,1,0,1,9,0,0,
1221,0,0,7,0,0,13,1543,0,0,1,0,0,1,0,2,9,0,0,
1240,0,0,26,245,0,4,1559,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
1287,0,0,27,245,0,4,1576,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                   */
/************************************************************************/
/* PROGRAM NAME          : ARBORPST.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 09-FEB-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                                */
/*                                                                      */
/*  FUNCTION             :                                                */
/*                                                                       */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_CASHIER              Query/Update               */
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
#include "gl.h"

#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

#define RESOURCE_BUSY        (sqlca.sqlcode == -54)

/*                   
extern char OUTPUT_FILE_NAME[75];                   
*/
/*#define DEBUG 1*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;


    int process_rep_flg;
    /* VARCHAR  p_language_id[4]; */ 
struct { unsigned short len; unsigned char arr[4]; } p_language_id;

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
			interface_code   [2],

            pmnt_terms_code  [3],
            billing_group    [5],  -- CRF-0120
            patient_id       [21],
            patient_flag     [2],
            bl_instal_flag   [2],
            mp_instal_flag   [2],
            nd_error_flag    [2],
            print_flag       [3],
            mast_status      [3],
            d_curr_pgm_name                      [15],
            dummy            [10][5],

            d_last_inv_doc_date           [12],

			nd_acc_entity_code            [5],
			d_module_valid_id             [3],
			d_added_by_id				  [31],
		    d_modified_by_id			  [31],
			d_added_date				  [31],
			d_modified_date				  [31],



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

struct { unsigned short len; unsigned char arr[2]; } interface_code;

struct { unsigned short len; unsigned char arr[3]; } pmnt_terms_code;

struct { unsigned short len; unsigned char arr[5]; } billing_group;

struct { unsigned short len; unsigned char arr[21]; } patient_id;

struct { unsigned short len; unsigned char arr[2]; } patient_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } mp_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_error_flag;

struct { unsigned short len; unsigned char arr[3]; } print_flag;

struct { unsigned short len; unsigned char arr[3]; } mast_status;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[6]; } dummy[10];

struct { unsigned short len; unsigned char arr[12]; } d_last_inv_doc_date;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[3]; } d_module_valid_id;

struct { unsigned short len; unsigned char arr[31]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[31]; } d_modified_by_id;

struct { unsigned short len; unsigned char arr[31]; } d_added_date;

struct { unsigned short len; unsigned char arr[31]; } d_modified_date;

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
            d_rc_hdr_pr_group_code_sp            [11],
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
            d_rc_hdr_misc_cshort_name          [61],  -- CRF-0120
            d_rc_hdr_misc_cadd1_desc           [61],
            d_rc_hdr_misc_cadd2_desc           [61],
            d_rc_hdr_misc_cadd3_desc           [61],
            d_rc_hdr_misc_czip_desc            [31],
            d_rc_hdr_misc_long_name_ch             [101],  -- CRF-0120
            d_rc_hdr_misc_short_name_ch            [101],  -- CRF-0120
            d_rc_hdr_misc_add1_desc_ch             [61],
            d_rc_hdr_misc_add2_desc_ch             [61],
            d_rc_hdr_misc_add3_desc_ch             [61],
            d_rc_hdr_misc_zip_desc_ch              [61],
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

struct { unsigned short len; unsigned char arr[11]; } d_rc_hdr_pr_group_code_sp;

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

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_cshort_name;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_cadd1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_cadd2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_cadd3_desc;

struct { unsigned short len; unsigned char arr[31]; } d_rc_hdr_misc_czip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_rc_hdr_misc_long_name_ch;

struct { unsigned short len; unsigned char arr[101]; } d_rc_hdr_misc_short_name_ch;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_add1_desc_ch;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_add2_desc_ch;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_add3_desc_ch;

struct { unsigned short len; unsigned char arr[61]; } d_rc_hdr_misc_zip_desc_ch;

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


    /* VARCHAR rep_date[20],
            comp_name[50],
            oper_id[21],
           d_ar_cust_long_name         [41],
	   d_acct_desc_bank            [65],
	   d_acct_desc_susp            [65],
	   d_conv_date_doc             [12],
	   d_conv_date_bank            [12],
	   nd_conv_fm_date             [12],
	   nd_conv_to_date             [12]; */ 
struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[41]; } d_ar_cust_long_name;

struct { unsigned short len; unsigned char arr[65]; } d_acct_desc_bank;

struct { unsigned short len; unsigned char arr[65]; } d_acct_desc_susp;

struct { unsigned short len; unsigned char arr[12]; } d_conv_date_doc;

struct { unsigned short len; unsigned char arr[12]; } d_conv_date_bank;

struct { unsigned short len; unsigned char arr[12]; } nd_conv_fm_date;

struct { unsigned short len; unsigned char arr[12]; } nd_conv_to_date;

  /* VARCHAR temp_doc_num[9]; */ 
struct { unsigned short len; unsigned char arr[9]; } temp_doc_num;


double     d_amt_local;

char  string_var[150];
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





#include "winproc.h"

int g_err_typ;

char g_err_id[10],
     g_err_msg[80];

double g_tot = 0;

/* These variables are used for calling post_doc (Posting acc validation) */

int  d_curr_year;
int  d_curr_month;
char d_summ_flag;

/*                                                                         */

FILE *f1;

int page_no,
    line_no,
    first_line;
int	line_num;
char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{
 strcpy(filename,WORKING_DIR);
 strcat(filename,"arborpst.lis");
   if (argc < 5)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(g_pgm_id,"ARBORPST");
   strcpy(OUTPUT_FILE_NAME,"ARBORPST.LIS");
   
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
   chk_active();

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   nd_proc_flag.arr[0]      = '\0';
   nd_view_print_flg.arr[0] = '\0';
   nd_facility_id.arr[0]   = '\0';

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   nd_proc_flag.len         = 0;
   nd_view_print_flg.len    = 0;

   nd_facility_id.len       = 0;
   process_rep_flg          = 0;

   
   /* EXEC SQL SELECT OPERATING_FACILITY_ID, 
                   PARAM1,
				   PARAM2,
				   PARAM3,
				   PARAM4,
				   PARAM5,
				   PARAM6,
				   PARAM8,
                   PARAM9,
				   PARAM10,
                   TO_CHAR(TO_DATE(PARAM3,'DD/MM/YYYY'),'DD/MM/YYYY'),
		           TO_CHAR(TO_DATE(PARAM6,'DD/MM/YYYY'),'DD/MM/YYYY')
              INTO :nd_facility_id,
			       :nd_fm_doc_type, 
				   :nd_fm_doc_num, 
				   :nd_fm_doc_date,
                   :nd_to_doc_type, 
				   :nd_to_doc_num, 
				   :nd_to_doc_date,
                   :nd_proc_flag,
                   :nd_view_print_flg, 
				   :process_rep_flg,
		           :nd_conv_fm_date, 
				   :nd_conv_to_date
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBORPST'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM8 ,PARAM9 ,PARAM10 ,TO_CHAR(TO_DATE(PARAM3,'DD/MM/YYY\
Y'),'DD/MM/YYYY') ,TO_CHAR(TO_DATE(PARAM6,'DD/MM/YYYY'),'DD/MM/YYYY') into :b0\
,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11  from SY_PROG_PARAM where ((PGM\
_ID='ARBORPST' and SESSION_ID=:b12) and PGM_DATE=:b13)";
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
   sqlstm.sqhstv[12] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[12] = (unsigned int  )18;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[13] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   strcpy(temp_doc_num.arr,"");
   temp_doc_num.arr[temp_doc_num.len]        = '\0';

   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';
   nd_proc_flag.arr[nd_proc_flag.len]        = '\0';
   nd_view_print_flg.arr[nd_view_print_flg.len]        = '\0';
   nd_conv_fm_date.arr[nd_conv_fm_date.len]  = '\0';
   nd_facility_id.arr[nd_facility_id.len]  = '\0';

 

   start_prog_control();

   start_prog_msg();

   
   delete_records();

   fetch_parameter();

   fetch_detls();


   open_files();
  

   declare_cursor();


    page_no=1;
    line_no=1;
   
   put_inp_parm();

      

   put_hdr();

      

   while (fetch_cur())
   {
      strcpy(nd_error_flag.arr,"N");
      nd_error_flag.len = 1;

      if (!fetch_rec())    /* Fetch all the details & lock Hdr row */
          continue;

   

      validate_posting();

      validate_print_flg();

      if(line_no == 1)
	    put_hdr();
      


	  fetch_cust_dets();

      put_doc_hdr();

	   

      update_err_flg();

	  
     if (nd_error_flag.arr[0] == 'N')
      {
	      if (strcmp(d_rc_hdr_party_type_code.arr, "C") == 0)
          {  
		     
		     ar_posting();
		  }

	         if ((strcmp(d_rc_hdr_party_type_code.arr , "C") == 0) 
	          && (strcmp(interface_code.arr , "O") == 0))
     		  {
		        gl_doc_insert();
                gl_posting(); 
                ins_gl_distrbn(d_rc_hdr_doc_type_code.arr,d_rc_hdr_doc_num.arr,7);
		       }
  
       }   

       /* EXEC SQL COMMIT WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 14;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )76;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
       if (OERROR)
         err_mesg("COMMIT failed",0,""); 
   }
   end_prog_msg();
   end_prog_control();
   print_end_of_rep();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
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



   
   fclose(f1);

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
                    NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
                AND NVL(POSTED_FLAG,'N') = 'N'; */ 


   /* EXEC SQL OPEN CUR_RECEIPTS; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0004;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )106;
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

 /* EXEC SQL DECLARE BL_REC_HDR_CUR CURSOR FOR
           SELECT ACC_ENTITY_CODE,
                  PARTY_TYPE_CODE,
                  TO_CHAR(DOC_DATE,'DD/MON/YYYY'),
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
                  TO_CHAR(CHEQUE_DATE,'DD/MON/YYYY'),
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
                  ROWID,
				  ADDED_BY_ID,    
				  MODIFIED_BY_ID,
				  ADDED_DATE  ,
				  MODIFIED_DATE 
             FROM AR_CASHIER
            WHERE DOC_TYPE_CODE = :d_rc_hdr_doc_type_code
              AND DOC_NUM       = :d_rc_hdr_doc_num
              FOR UPDATE OF ERROR_FLAG NOWAIT; */ 

 
   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
             SELECT NVL(DOC_PRINT_FLAG,'X')
               FROM GL_ACC_ENTITY_DOC_TYPE_VW
              WHERE DOC_TYPE_CODE   = :d_rc_hdr_doc_type_code; */ 

    
    /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
              SELECT DECODE(CHINESE_REPORTING_FLAG,'Y',
                     RPAD(NVL(LONG_NAME_CHINESE,' '),33,' '),RPAD(NVL(LONG_NAME,' '),33,' '))
                FROM AR_CUSTOMER
               WHERE CUST_CODE = :d_rc_hdr_cust_code; */ 


}  

validate_print_flg()
{

      /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 14;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0006;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )145;
      sqlstm.selerr = (unsigned short)1;
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
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
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

      d_sy_doc_print_flag.arr[0]   = '\0';
      d_sy_doc_print_flag.len      = 0;

      /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
                INTO :d_sy_doc_print_flag; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 14;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )164;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_sy_doc_print_flag;
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
         err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,"");

      d_sy_doc_print_flag.arr[d_sy_doc_print_flag.len] = '\0';

      if (d_sy_doc_print_flag.arr[0] == 'Y' &&
                  d_rc_hdr_print_flag.arr[0] != 'Y')               
                  {
					  error_insert("1","AR7777","Receipt Hdr Print flag is not set to Y");
		              nd_error_flag.arr[0] = 'Y';
        	      }
}

fetch_cur()
{
   d_rc_hdr_doc_type_code.arr[0]     = '\0';
   d_rc_hdr_doc_num.arr[0]           = '\0';

   d_rc_hdr_doc_type_code.len        = 0;
   d_rc_hdr_doc_num.len              = 0;


   /* EXEC SQL FETCH CUR_RECEIPTS
             INTO :d_rc_hdr_doc_type_code, :d_rc_hdr_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )183;
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
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
         err_mesg("FETCH failed on cursor CUR_RECEIPTS",0,"");

   d_rc_hdr_doc_type_code.arr[d_rc_hdr_doc_type_code.len]     = '\0';
   d_rc_hdr_doc_num.arr[d_rc_hdr_doc_num.len]                 = '\0';

   if (LAST_ROW)
       return(0);
   else
       return(1);
}

fetch_rec()
{
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
d_added_by_id.arr[0] = '\0';
d_modified_by_id.arr[0] = '\0';
d_added_date.arr[0] = '\0';
d_modified_date.arr[0] = '\0';


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
d_added_by_id.len = 0;
d_modified_by_id.len = 0;
d_added_date.len = 0;
d_modified_date.len = 0;

   /* EXEC SQL OPEN BL_REC_HDR_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select ACC_ENTITY_CODE ,PARTY_TYPE_CODE ,TO_CHAR(DOC_DATE,'DD/MON/YYYY\
') ,DOC_REF ,CUST_CODE ,MAIN_ACC1_CODE_BANK ,MAIN_ACC2_CODE_BANK ,SUBLEDGER_\
GROUP_CODE_BANK ,SUBLEDGER_LINE_CODE_BANK ,DEPT_CODE_BANK ,PRODUCT_GROUP_COD\
E_BANK ,PRODUCT_LINE_CODE_BANK ,MAIN_ACC1_CODE_SUSP ,MAIN_ACC2_CODE_SUSP ,SU\
BLEDGER_GROUP_CODE_SUSP ,SUBLEDGER_LINE_CODE_SUSP ,DEPT_CODE_SUSP ,PRODUCT_G\
ROUP_CODE_SUSP ,PRODUCT_LINE_CODE_SUSP ,AMT_FOREIGN ,AMT_LOCAL ,NARRATION ,P\
OST_MONTH ,POST_YEAR ,CURRENCY_CODE ,EXCHG_RATE ,BANK_DESC ,CHEQUE_NUM ,TO_C\
HAR(CHEQUE_DATE,'DD/MON/YYYY') ,MISC_CUST_LONG_NAME ,MISC_CUST_SHORT_NAME ,M\
ISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,MISC_CUST_ADD3_DESC ,MISC_CUST_ZIP_\
DESC ,MISC_CUST_LONG_NAME_CHINESE ,MISC_CUST_SHORT_NAME_CHINESE ,MISC_CUST_A\
DD1_DESC_CHINESE ,MISC_CUST_ADD2_DESC_CHINESE ,MISC_CUST_ADD3_DESC_CHINESE ,\
MISC_CUST_ZIP_DESC_CHINESE ,TEL_NUM ,CONTACT_NAME ,CONTACT_NAME_TITLE ,PRINT\
_FLAG ,ROWID ,ADDED_BY_ID ,MODIFIED_BY_ID ,ADDED_DATE ,MODIFIED_DATE  from A\
R_CASHIER where (DOC_TYPE_CODE=:b0 and DOC");
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )206;
   sqlstm.selerr = (unsigned short)1;
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
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
         err_mesg("OPEN failed on cursor BL_REC_HDR_CUR",0,"");

   /* EXEC SQL FETCH BL_REC_HDR_CUR 
             INTO :d_rc_hdr_acc_entity_code,
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
                  :d_rc_hdr_rowid,
				  :d_added_by_id,
				  :d_modified_by_id,
				  :d_added_date,
				  :d_modified_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 50;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )229;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_rc_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_party_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )17;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_doc_ref;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_cust_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_main_acc1_code_bk;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_main_acc2_code_bk;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_subl_group_code_bk;
   sqlstm.sqhstl[7] = (unsigned int  )6;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_rc_hdr_subl_line_code_bk;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_rc_hdr_dept_code_bk;
   sqlstm.sqhstl[9] = (unsigned int  )13;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_rc_hdr_pr_group_code_bk;
   sqlstm.sqhstl[10] = (unsigned int  )6;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_rc_hdr_pr_line_code_bk;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_rc_hdr_main_acc1_code_sp;
   sqlstm.sqhstl[12] = (unsigned int  )9;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_rc_hdr_main_acc2_code_sp;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_rc_hdr_subl_group_code_sp;
   sqlstm.sqhstl[14] = (unsigned int  )6;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_rc_hdr_subl_line_code_sp;
   sqlstm.sqhstl[15] = (unsigned int  )11;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_rc_hdr_dept_code_sp;
   sqlstm.sqhstl[16] = (unsigned int  )13;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_rc_hdr_pr_group_code_sp;
   sqlstm.sqhstl[17] = (unsigned int  )13;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_rc_hdr_pr_line_code_sp;
   sqlstm.sqhstl[18] = (unsigned int  )7;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_rc_hdr_amt_foreign;
   sqlstm.sqhstl[19] = (unsigned int  )19;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_rc_hdr_amt_local;
   sqlstm.sqhstl[20] = (unsigned int  )19;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_rc_hdr_narration;
   sqlstm.sqhstl[21] = (unsigned int  )53;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_rc_hdr_post_month;
   sqlstm.sqhstl[22] = (unsigned int  )5;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_rc_hdr_post_year;
   sqlstm.sqhstl[23] = (unsigned int  )7;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_rc_hdr_currency_code;
   sqlstm.sqhstl[24] = (unsigned int  )9;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_rc_hdr_exchg_rate;
   sqlstm.sqhstl[25] = (unsigned int  )17;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&d_rc_hdr_bank_desc;
   sqlstm.sqhstl[26] = (unsigned int  )33;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&d_rc_hdr_cheque_num;
   sqlstm.sqhstl[27] = (unsigned int  )13;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&d_rc_hdr_cheque_date;
   sqlstm.sqhstl[28] = (unsigned int  )17;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&d_rc_hdr_misc_clong_name;
   sqlstm.sqhstl[29] = (unsigned int  )103;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&d_rc_hdr_misc_cshort_name;
   sqlstm.sqhstl[30] = (unsigned int  )63;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&d_rc_hdr_misc_cadd1_desc;
   sqlstm.sqhstl[31] = (unsigned int  )63;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&d_rc_hdr_misc_cadd2_desc;
   sqlstm.sqhstl[32] = (unsigned int  )63;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&d_rc_hdr_misc_cadd3_desc;
   sqlstm.sqhstl[33] = (unsigned int  )63;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&d_rc_hdr_misc_czip_desc;
   sqlstm.sqhstl[34] = (unsigned int  )33;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&d_rc_hdr_misc_long_name_ch;
   sqlstm.sqhstl[35] = (unsigned int  )103;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&d_rc_hdr_misc_short_name_ch;
   sqlstm.sqhstl[36] = (unsigned int  )103;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&d_rc_hdr_misc_add1_desc_ch;
   sqlstm.sqhstl[37] = (unsigned int  )63;
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&d_rc_hdr_misc_add2_desc_ch;
   sqlstm.sqhstl[38] = (unsigned int  )63;
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&d_rc_hdr_misc_add3_desc_ch;
   sqlstm.sqhstl[39] = (unsigned int  )63;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&d_rc_hdr_misc_zip_desc_ch;
   sqlstm.sqhstl[40] = (unsigned int  )63;
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&d_rc_hdr_tel_num;
   sqlstm.sqhstl[41] = (unsigned int  )33;
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqhstv[42] = (         void  *)&d_rc_hdr_contact_name;
   sqlstm.sqhstl[42] = (unsigned int  )103;
   sqlstm.sqhsts[42] = (         int  )0;
   sqlstm.sqindv[42] = (         void  *)0;
   sqlstm.sqinds[42] = (         int  )0;
   sqlstm.sqharm[42] = (unsigned int  )0;
   sqlstm.sqadto[42] = (unsigned short )0;
   sqlstm.sqtdso[42] = (unsigned short )0;
   sqlstm.sqhstv[43] = (         void  *)&d_rc_hdr_contact_name_title;
   sqlstm.sqhstl[43] = (unsigned int  )63;
   sqlstm.sqhsts[43] = (         int  )0;
   sqlstm.sqindv[43] = (         void  *)0;
   sqlstm.sqinds[43] = (         int  )0;
   sqlstm.sqharm[43] = (unsigned int  )0;
   sqlstm.sqadto[43] = (unsigned short )0;
   sqlstm.sqtdso[43] = (unsigned short )0;
   sqlstm.sqhstv[44] = (         void  *)&d_rc_hdr_print_flag;
   sqlstm.sqhstl[44] = (unsigned int  )4;
   sqlstm.sqhsts[44] = (         int  )0;
   sqlstm.sqindv[44] = (         void  *)0;
   sqlstm.sqinds[44] = (         int  )0;
   sqlstm.sqharm[44] = (unsigned int  )0;
   sqlstm.sqadto[44] = (unsigned short )0;
   sqlstm.sqtdso[44] = (unsigned short )0;
   sqlstm.sqhstv[45] = (         void  *)&d_rc_hdr_rowid;
   sqlstm.sqhstl[45] = (unsigned int  )33;
   sqlstm.sqhsts[45] = (         int  )0;
   sqlstm.sqindv[45] = (         void  *)0;
   sqlstm.sqinds[45] = (         int  )0;
   sqlstm.sqharm[45] = (unsigned int  )0;
   sqlstm.sqadto[45] = (unsigned short )0;
   sqlstm.sqtdso[45] = (unsigned short )0;
   sqlstm.sqhstv[46] = (         void  *)&d_added_by_id;
   sqlstm.sqhstl[46] = (unsigned int  )33;
   sqlstm.sqhsts[46] = (         int  )0;
   sqlstm.sqindv[46] = (         void  *)0;
   sqlstm.sqinds[46] = (         int  )0;
   sqlstm.sqharm[46] = (unsigned int  )0;
   sqlstm.sqadto[46] = (unsigned short )0;
   sqlstm.sqtdso[46] = (unsigned short )0;
   sqlstm.sqhstv[47] = (         void  *)&d_modified_by_id;
   sqlstm.sqhstl[47] = (unsigned int  )33;
   sqlstm.sqhsts[47] = (         int  )0;
   sqlstm.sqindv[47] = (         void  *)0;
   sqlstm.sqinds[47] = (         int  )0;
   sqlstm.sqharm[47] = (unsigned int  )0;
   sqlstm.sqadto[47] = (unsigned short )0;
   sqlstm.sqtdso[47] = (unsigned short )0;
   sqlstm.sqhstv[48] = (         void  *)&d_added_date;
   sqlstm.sqhstl[48] = (unsigned int  )33;
   sqlstm.sqhsts[48] = (         int  )0;
   sqlstm.sqindv[48] = (         void  *)0;
   sqlstm.sqinds[48] = (         int  )0;
   sqlstm.sqharm[48] = (unsigned int  )0;
   sqlstm.sqadto[48] = (unsigned short )0;
   sqlstm.sqtdso[48] = (unsigned short )0;
   sqlstm.sqhstv[49] = (         void  *)&d_modified_date;
   sqlstm.sqhstl[49] = (unsigned int  )33;
   sqlstm.sqhsts[49] = (         int  )0;
   sqlstm.sqindv[49] = (         void  *)0;
   sqlstm.sqinds[49] = (         int  )0;
   sqlstm.sqharm[49] = (unsigned int  )0;
   sqlstm.sqadto[49] = (unsigned short )0;
   sqlstm.sqtdso[49] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("FETCH failed on cursor BL_REC_HDR_CUR",0,"");

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
d_added_by_id.arr[d_added_by_id.len] = '\0';
d_modified_by_id.arr[d_modified_by_id.len] = '\0';
d_added_date.arr[d_added_date.len] = '\0';
d_modified_date.arr[d_modified_date.len] = '\0';

   return(sqlca.sqlerrd[2]);
}                                        

validate_posting()
{
char main_bk[150],main_sp[150];

     strcpy(d_module_valid_id.arr , "AR");


     if (validate_posting_acct( d_rc_hdr_main_acc1_code_bk.arr,
                                d_rc_hdr_main_acc2_code_bk.arr,
                                d_rc_hdr_dept_code_bk.arr,
                                d_rc_hdr_pr_group_code_bk.arr,
                                d_rc_hdr_pr_line_code_bk.arr,
                                d_rc_hdr_subl_group_code_bk.arr,
                                d_rc_hdr_subl_line_code_bk.arr,
                                'N',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
                                atol(d_rc_hdr_post_year.arr),
								atol(d_rc_hdr_post_month.arr),
								&g_err_typ,
                                g_err_id,
                                g_err_msg
                             ) ==  -1)
     {
	
             if(g_err_typ == 0)
                   err_mesg(g_err_msg,0,"");
             else 
             {              
				  // disp_message(ERR_MESG,"Bank");
                   strcpy(nd_error_flag.arr,"Y");
  sprintf(main_bk,"%s-%s : Invalid Bank Account",d_rc_hdr_main_acc1_code_bk.arr,d_rc_hdr_main_acc2_code_bk.arr);
  error_insert("1","AR7777",main_bk);
 //error_insert("1","AR7777","Invalid Bank Account");
             }
     }
 
     strcpy(d_module_valid_id.arr , "AR"); 

     if (validate_posting_acct( d_rc_hdr_main_acc1_code_sp.arr,
                                d_rc_hdr_main_acc2_code_sp.arr,
                                d_rc_hdr_dept_code_sp.arr,
                                d_rc_hdr_pr_group_code_sp.arr,
                                d_rc_hdr_pr_line_code_sp.arr,
                                d_rc_hdr_subl_group_code_sp.arr,
                                d_rc_hdr_subl_line_code_sp.arr,
                                'N',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
                                atol(d_rc_hdr_post_year.arr),
								atol(d_rc_hdr_post_month.arr),
                                &g_err_typ,
                                g_err_id,
                                g_err_msg
                             ) ==  -1) 
      {
             if(g_err_typ == 0)
                   err_mesg(g_err_msg,0,"");
             else 
             {
				//disp_message(ERR_MESG,"susp	");
                   strcpy(nd_error_flag.arr,"Y");
                   nd_error_flag.len = 1;
  sprintf(main_sp,"%s-%s : Invalid Susp Account",d_rc_hdr_main_acc1_code_sp.arr,d_rc_hdr_main_acc2_code_sp.arr);
  error_insert("1","AR7777",main_sp);
			 //  error_insert("1","AR7777","Invalid Susp Account");
             }
       }
fflush(stdout);
}

gl_doc_insert()
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
           :nd_acc_entity_code,
           :d_rc_hdr_doc_type_code,
           1,
           :d_rc_hdr_doc_num,
           TO_DATE(:d_rc_hdr_doc_date,'DD/MON/YYYY'),
           :d_rc_hdr_cheque_num,
           :d_rc_hdr_narration,
           :d_rc_hdr_post_month,
           :d_rc_hdr_post_year,
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
           2,
           'AR',
           NULL,
           NULL,
           NULL
         ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 50;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into GL_TXN_DOC_HDR (ACC_ENTITY_CODE,DOC_TYPE_CODE,\
BATCH_NUM,DOC_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT,DOC\
_NATURE,UNIT_TYPE_CODE,CURRENCY_CODE,EXCHG_RATE,ERROR_FLAG,ADDED_BY_ID,MODIFIE\
D_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID,TXN_TYPE_DESC,STD_JV_R\
EF,PRINT_FLAG) values (:b0,:b1,1,:b2,TO_DATE(:b3,'DD/MON/YYYY'),:b4,:b5,:b6,:b\
7,0,null ,null ,null ,null ,null ,USER,USER,SYSDATE,SYSDATE,2,'AR',null ,null \
,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )444;
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
   sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )17;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_cheque_num;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_narration;
   sqlstm.sqhstl[5] = (unsigned int  )53;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_post_month;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_post_year;
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
           INTER_ACC_ENTITY,
		   CUST_SUPP_CODE
         )
      VALUES
         (
           :nd_acc_entity_code,
           1,
           :d_rc_hdr_doc_type_code,
           :d_rc_hdr_doc_num,
           :d_rc_hdr_main_acc1_code_bk,
           :d_rc_hdr_main_acc2_code_bk,
           :d_rc_hdr_subl_group_code_bk,
           :d_rc_hdr_subl_line_code_bk,
           :d_rc_hdr_dept_code_bk,
           :d_rc_hdr_pr_group_code_bk,
           :d_rc_hdr_pr_line_code_bk,
           NULL,
           :d_rc_hdr_amt_local,
           :d_rc_hdr_narration,
           '1',
           NULL,
		   :d_rc_hdr_cust_code 
         ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 50;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY,CUST_SUPP_CODE) values (:b0,1,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,null ,:b10,:b11,'1',null ,:b12)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )491;
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
  sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_main_acc1_code_bk;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_main_acc2_code_bk;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_subl_group_code_bk;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_subl_line_code_bk;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_dept_code_bk;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_rc_hdr_pr_group_code_bk;
  sqlstm.sqhstl[8] = (unsigned int  )6;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_rc_hdr_pr_line_code_bk;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_rc_hdr_amt_local;
  sqlstm.sqhstl[10] = (unsigned int  )19;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_rc_hdr_narration;
  sqlstm.sqhstl[11] = (unsigned int  )53;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_rc_hdr_cust_code;
  sqlstm.sqhstl[12] = (unsigned int  )11;
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
           INTER_ACC_ENTITY,
		   CUST_SUPP_CODE
         )
      VALUES
         (
           :nd_acc_entity_code,
           1,
           :d_rc_hdr_doc_type_code,
           :d_rc_hdr_doc_num,
           :d_rc_hdr_main_acc1_code_sp,
           :d_rc_hdr_main_acc2_code_sp,
           :d_rc_hdr_subl_group_code_sp,
           :d_rc_hdr_subl_line_code_sp,
           :d_rc_hdr_dept_code_sp,
           :d_rc_hdr_pr_group_code_sp,
           :d_rc_hdr_pr_line_code_sp,
           NULL,
           :d_rc_hdr_amt_local * -1,
           :d_rc_hdr_narration,
           '2',
           NULL,
		   :d_rc_hdr_cust_code
         ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 50;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY,CUST_SUPP_CODE) values (:b0,1,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,null ,(:b10* (-1)),:b11,'2',null ,:b12)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )558;
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
  sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_main_acc1_code_sp;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_main_acc2_code_sp;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_subl_group_code_sp;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_subl_line_code_sp;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_dept_code_sp;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_rc_hdr_pr_group_code_sp;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_rc_hdr_pr_line_code_sp;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_rc_hdr_amt_local;
  sqlstm.sqhstl[10] = (unsigned int  )19;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_rc_hdr_narration;
  sqlstm.sqhstl[11] = (unsigned int  )53;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_rc_hdr_cust_code;
  sqlstm.sqhstl[12] = (unsigned int  )11;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_LINE - for line 2",0,"");

}    

ar_posting()
{
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
         :d_rc_hdr_acc_entity_code,
         'AR',
         :d_rc_hdr_doc_type_code,
         :d_rc_hdr_doc_num,
         TO_DATE(:d_rc_hdr_doc_date,'DD/MON/YYYY'),
         SYSDATE,
         'P',
         :d_rc_hdr_narration,
         :d_rc_hdr_post_month,
         :d_rc_hdr_post_year,
         USER,
         USER,
         SYSDATE,
         SYSDATE
       ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 50;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_DOC_CONTROL (ACC_ENTITY_CODE,MODULE_ID,DOC_\
TYPE_CODE,DOC_NUM,DOC_DATE,POSTED_DATE,DOC_STATUS,NARRATION,POST_MONTH,POST_YE\
AR,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE) values (:b0,'AR',:b1,:\
b2,TO_DATE(:b3,'DD/MON/YYYY'),SYSDATE,'P',:b4,:b5,:b6,USER,USER,SYSDATE,SYSDAT\
E)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )625;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_rc_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )17;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_narration;
   sqlstm.sqhstl[4] = (unsigned int  )53;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_post_month;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_post_year;
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


   /* EXEC SQL INSERT INTO AR_REC_HDR
      (
         ACC_ENTITY_CODE,
         DOC_TYPE_CODE,
         DOC_NUM,
         LAST_LINE_NUM,
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
         INTERFACE_FLAG,
		 ADDED_BY_ID,    
		 MODIFIED_BY_ID,
		 ADDED_DATE ,    
		 MODIFIED_DATE  
       )
     VALUES
       (
        :d_rc_hdr_acc_entity_code,
        :d_rc_hdr_doc_type_code,
        :d_rc_hdr_doc_num,
        '0',
        TO_DATE(:d_rc_hdr_doc_date,'DD/MON/YYYY'),
        :d_rc_hdr_doc_ref,
        :d_rc_hdr_cust_code,
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
        TO_DATE(:d_rc_hdr_cheque_date,'DD/MON/YYYY'),
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
        'Y',
        'N',
		:d_added_by_id,
		:d_modified_by_id,
		:d_added_date,
		:d_modified_date
		
       ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 50;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_REC_HDR (ACC_ENTITY_CODE,DOC_TYPE_CODE,DOC_\
NUM,LAST_LINE_NUM,DOC_DATE,DOC_REF,CUST_CODE,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUB\
LEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LIN\
E_CODE,AMT_FOREIGN,AMT_LOCAL,NARRATION,POST_MONTH,POST_YEAR,CURRENCY_CODE,EXCH\
G_RATE,BANK_DESC,CHEQUE_NUM,CHEQUE_DATE,MISC_CUST_LONG_NAME,MISC_CUST_SHORT_NA\
ME,MISC_CUST_ADD1_DESC,MISC_CUST_ADD2_DESC,MISC_CUST_ADD3_DESC,MISC_CUST_ZIP_D\
ESC,MISC_CUST_LONG_NAME_CHINESE,MISC_CUST_SHORT_NAME_CHINESE,MISC_CUST_ADD1_DE\
SC_CHINESE,MISC_CUST_ADD2_DESC_CHINESE,MISC_CUST_ADD3_DESC_CHINESE,MISC_CUST_Z\
IP_DESC_CHINESE,TEL_NUM,CONTACT_NAME,CONTACT_NAME_TITLE,PRINT_FLAG,INTERFACE_F\
LAG,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE) values (:b0,:b1,:b2,'\
0',TO_DATE(:b3,'DD/MON/YYYY'),:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14\
,:b15,:b16,:b17,:b18,:b19,:b20,:b21,TO_DATE(:b22,'DD/MON/YYYY'),:b23,:b24,:b25\
,:b26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,:b34,:b35,:b36,:b37,'Y','N',:b38,:b39\
,:b40,:b41)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )668;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_rc_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_rc_hdr_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )17;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_rc_hdr_doc_ref;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_rc_hdr_cust_code;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_rc_hdr_main_acc1_code_sp;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_rc_hdr_main_acc2_code_sp;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_rc_hdr_subl_group_code_sp;
   sqlstm.sqhstl[8] = (unsigned int  )6;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_rc_hdr_subl_line_code_sp;
   sqlstm.sqhstl[9] = (unsigned int  )11;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_rc_hdr_dept_code_sp;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_rc_hdr_pr_group_code_sp;
   sqlstm.sqhstl[11] = (unsigned int  )13;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_rc_hdr_pr_line_code_sp;
   sqlstm.sqhstl[12] = (unsigned int  )7;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_rc_hdr_amt_foreign;
   sqlstm.sqhstl[13] = (unsigned int  )19;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_rc_hdr_amt_local;
   sqlstm.sqhstl[14] = (unsigned int  )19;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_rc_hdr_narration;
   sqlstm.sqhstl[15] = (unsigned int  )53;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_rc_hdr_post_month;
   sqlstm.sqhstl[16] = (unsigned int  )5;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_rc_hdr_post_year;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_rc_hdr_currency_code;
   sqlstm.sqhstl[18] = (unsigned int  )9;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_rc_hdr_exchg_rate;
   sqlstm.sqhstl[19] = (unsigned int  )17;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_rc_hdr_bank_desc;
   sqlstm.sqhstl[20] = (unsigned int  )33;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_rc_hdr_cheque_num;
   sqlstm.sqhstl[21] = (unsigned int  )13;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_rc_hdr_cheque_date;
   sqlstm.sqhstl[22] = (unsigned int  )17;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_rc_hdr_misc_clong_name;
   sqlstm.sqhstl[23] = (unsigned int  )103;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_rc_hdr_misc_cshort_name;
   sqlstm.sqhstl[24] = (unsigned int  )63;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_rc_hdr_misc_cadd1_desc;
   sqlstm.sqhstl[25] = (unsigned int  )63;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&d_rc_hdr_misc_cadd2_desc;
   sqlstm.sqhstl[26] = (unsigned int  )63;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&d_rc_hdr_misc_cadd3_desc;
   sqlstm.sqhstl[27] = (unsigned int  )63;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&d_rc_hdr_misc_czip_desc;
   sqlstm.sqhstl[28] = (unsigned int  )33;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&d_rc_hdr_misc_long_name_ch;
   sqlstm.sqhstl[29] = (unsigned int  )103;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&d_rc_hdr_misc_short_name_ch;
   sqlstm.sqhstl[30] = (unsigned int  )103;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&d_rc_hdr_misc_add1_desc_ch;
   sqlstm.sqhstl[31] = (unsigned int  )63;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&d_rc_hdr_misc_add2_desc_ch;
   sqlstm.sqhstl[32] = (unsigned int  )63;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&d_rc_hdr_misc_add3_desc_ch;
   sqlstm.sqhstl[33] = (unsigned int  )63;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&d_rc_hdr_misc_zip_desc_ch;
   sqlstm.sqhstl[34] = (unsigned int  )63;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&d_rc_hdr_tel_num;
   sqlstm.sqhstl[35] = (unsigned int  )33;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&d_rc_hdr_contact_name;
   sqlstm.sqhstl[36] = (unsigned int  )103;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&d_rc_hdr_contact_name_title;
   sqlstm.sqhstl[37] = (unsigned int  )63;
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&d_added_by_id;
   sqlstm.sqhstl[38] = (unsigned int  )33;
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&d_modified_by_id;
   sqlstm.sqhstl[39] = (unsigned int  )33;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&d_added_date;
   sqlstm.sqhstl[40] = (unsigned int  )33;
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&d_modified_date;
   sqlstm.sqhstl[41] = (unsigned int  )33;
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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

gl_posting()
{
 char r_err_msg[100];




 if (post_doc((long)1,d_rc_hdr_doc_type_code.arr,atol(d_rc_hdr_doc_num.arr),
            r_err_msg) == -1)
        err_mesg(r_err_msg,0,""); 



   return (0);
}

delete_gl_recs()
{
 /* EXEC SQL DELETE FROM GL_TXN_DOC_HDR 
                WHERE DOC_TYPE_CODE = :d_rc_hdr_doc_type_code
                  AND DOC_NUM       = :d_rc_hdr_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 50;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from GL_TXN_DOC_HDR  where (DOC_TYPE_CODE=:b0 and DO\
C_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )851;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
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
                WHERE DOC_TYPE_CODE = :d_rc_hdr_doc_type_code
                  AND DOC_NUM       = :d_rc_hdr_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 50;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from GL_TXN_DOC_LINE  where (DOC_TYPE_CODE=:b0 and D\
OC_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )874;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
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

}

/*----------------------------------- */

error_insert(line_no,msg_id,msg_text)
char line_no[],msg_id[],msg_text[];
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

   strcpy(ar_err_code.arr,msg_id);
   ar_err_code.len = strlen(ar_err_code.arr);
   strcpy(l_ar_doc_error_text.arr,msg_text);
   l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);
      
   l_ar_doc_error_text.arr[l_ar_doc_error_text.len] = '\0';
 
   if (strcmp(d_rc_hdr_doc_num.arr,temp_doc_num.arr) != 0){
       line_num = 1;
strcpy(temp_doc_num.arr,d_rc_hdr_doc_num.arr);   
	   }
   else {
	line_num++;
	   }

   sprintf(ar_line_no.arr,"%d",line_num);
   ar_line_no.len = strlen(ar_line_no.arr);

   /* EXEC SQL INSERT INTO AR_DOC_ERROR
                   (PGM_ID,
                    DOC_TYPE_CODE,    DOC_NUM,
                    LINE_NUM,         ERROR_CODE,
                    ERROR_TEXT,
                    DOC_TYPE_CODE_REF, DOC_NUM_REF)
            VALUES (:d_curr_pgm_name,:d_rc_hdr_doc_type_code,
                    :d_rc_hdr_doc_num,
                    :ar_line_no,      :ar_err_code,
                    :l_ar_doc_error_text,NULL,NULL); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 50;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (PGM_ID,DOC_TYPE_CODE,DOC_NUM,LIN\
E_NUM,ERROR_CODE,ERROR_TEXT,DOC_TYPE_CODE_REF,DOC_NUM_REF) values (:b0,:b1,:b2\
,:b3,:b4,:b5,null ,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )897;
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
   sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_doc_num;
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
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                   // :l_doc_type_code_ref,:l_doc_num_ref);

    if (OERROR)
   {
     sprintf(string_var,"doc type is <%s> - <%d>\n",d_rc_hdr_doc_type_code.arr,d_rc_hdr_doc_type_code.len);
    // disp_message(ORA_MESG,string_var);
     sprintf(string_var,"doc num is <%s> - <%d>\n",d_rc_hdr_doc_num.arr,d_rc_hdr_doc_num.len);
    // disp_message(ORA_MESG,string_var);
     sprintf(string_var,"line no is <%s> - <%d>\n",ar_line_no.arr,ar_line_no.len);
   //  disp_message(ORA_MESG,string_var);
     sprintf(string_var,"err is <%s> - <%d>\n",ar_err_code.arr,ar_err_code.len);
     //disp_message(ORA_MESG,string_var);
     err_mesg("INSERT failed on table AR_DOC_ERROR",0,"");
   }

   strcpy(nd_error_flag.arr,"Y");
   nd_error_flag.len = 1;
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
       sqlstm.arrsiz = 50;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "delete  from AR_DOC_ERROR  where (PGM_ID=:b0 and ROWNU\
M<500)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )936;
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
       sqlstm.arrsiz = 50;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )955;
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



/*----------------------------------- */

update_err_flg()
{

  if (nd_error_flag.arr[0] == 'Y')
  {
       /* EXEC SQL UPDATE AR_CASHIER 
                   SET ERROR_FLAG = :nd_error_flag
                 WHERE ROWID      = :d_rc_hdr_rowid; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 50;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "update AR_CASHIER  set ERROR_FLAG=:b0 where ROWID=:b1";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )970;
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
       sqlstm.sqhstv[1] = (         void  *)&d_rc_hdr_rowid;
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
            err_mesg("UPDATE failed on table AR_CASHIER",0,"");
   }
   else
   {
       /* EXEC SQL UPDATE AR_CASHIER
                   SET ERROR_FLAG      = :nd_error_flag,
                       POSTED_FLAG     = 'Y',
                       INTERFACE_FLAG  = DECODE(:interface_code,'O','Y','N'),
                       POSTED_DATE     = SYSDATE,
                       POSTED_BY_ID    = USER
                 WHERE ROWID           = :d_rc_hdr_rowid; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 50;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "update AR_CASHIER  set ERROR_FLAG=:b0,POSTED_FLAG='Y',\
INTERFACE_FLAG=DECODE(:b1,'O','Y','N'),POSTED_DATE=SYSDATE,POSTED_BY_ID=USER w\
here ROWID=:b2";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )993;
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
       sqlstm.sqhstv[1] = (         void  *)&interface_code;
       sqlstm.sqhstl[1] = (unsigned int  )4;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_rc_hdr_rowid;
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
           err_mesg("UPDATE failed on table AR_CASHIER",0,"");

    }
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 50;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )1020;
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

     /* EXEC SQL SELECT NVL(AR_INTERFACE_CODE, 'B')
                INTO :interface_code
                FROM AR_PARAMETER; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 50;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(AR_INTERFACE_CODE,'B') into :b0  from AR_PARA\
METER ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1051;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&interface_code;
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

		 interface_code.arr[interface_code.len] = '\0';


     /* EXEC SQL SELECT CURRENT_ACC_YEAR,CURRENT_ACC_MONTH,
                     PRIOR_POSTING_ALLOW_FLAG,
                     NVL(SUMMARY_PROCESS_FLAG,'X') 
                INTO :curr_acc_year,    :curr_acc_month,
                     :prior_post_allow, :gl_summ_pro_flag
                FROM GL_PARAMETER; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 50;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select CURRENT_ACC_YEAR ,CURRENT_ACC_MONTH ,PRIOR_POSTIN\
G_ALLOW_FLAG ,NVL(SUMMARY_PROCESS_FLAG,'X') into :b0,:b1,:b2,:b3  from GL_PARA\
METER ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1070;
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

        /* EXEC SQL SELECT  NUM_OF_ACC_PERIODS , ACC_ENTITY_CODE,
		                 NO_OF_DECIMAL
              INTO       :d_sy_num_acc_per, :nd_acc_entity_code,
			             :nd_no_of_decimal
              FROM        SY_ACC_ENTITY
		      where       ACC_ENTITY_ID = :nd_facility_id; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 50;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select NUM_OF_ACC_PERIODS ,ACC_ENTITY_CODE ,NO_OF_DEC\
IMAL into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1101;
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
		 where       ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 50;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1132;
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
   if ((f1 = fopen(filename,"w")) == NULL)
   {
        err_mesg("\nError while opening File arborpst.lis\n",0,"");
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

    fprintf(f1,"MDL : AR                                       %30s                                       %s\n",comp_name.arr,rep_date.arr);

    fprintf(f1,"OPR : %s\n",oper_id.arr);

    fprintf(f1,"REP : ARBORPST                                        CASHIER RECEIPTS - POSTING                                         PAGE : %4d\n",page_no);

    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"DOCUMENT  DOCUMENT    DOCUMENT     POST       DOCUMENT          CUSTOMER   CUSTOMER NAME                                   DOCUMENT \n");
    fprintf(f1,"TYPE        NUMBER    DATE         MTH/YR     REFERENCE         CODE                                                         AMOUNT \n");
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");

    line_no=12;

}

put_doc_hdr()
{

    varchar s_amt[20];

    d_amt_local             = 0;
    d_conv_date_doc.arr[0]  = '\0';
    d_conv_date_bank.arr[0] = '\0';

    /* EXEC SQL SELECT TO_NUMBER(:d_rc_hdr_amt_local),
		    TO_CHAR(TO_DATE(:d_rc_hdr_doc_date,'DD/MON/YYYY'),'DD/MM/YYYY'),
		    TO_CHAR(TO_DATE(:d_rc_hdr_cheque_date,'DD/MON/YYYY'),'DD/MM/YYYY')
	     INTO   :d_amt_local,
		    :d_conv_date_doc,
		    :d_conv_date_bank
	     FROM   DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 50;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_NUMBER(:b0) ,TO_CHAR(TO_DATE(:b1,'DD/MON/YYYY')\
,'DD/MM/YYYY') ,TO_CHAR(TO_DATE(:b2,'DD/MON/YYYY'),'DD/MM/YYYY') into :b3,:b4,\
:b5  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1163;
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

    if (nd_no_of_decimal == 3)
	   sprintf(s_amt,"%15.3f",d_amt_local);
    else
	   sprintf(s_amt,"%15.2f",d_amt_local);
	
	format_amt(s_amt,nd_no_of_decimal);

    chk_break(4); 

    fprintf(f1,"%-8s  %8s    %-12s  %2s/%4s",d_rc_hdr_doc_type_code.arr,
	    d_rc_hdr_doc_num.arr,d_conv_date_doc.arr,
	    d_rc_hdr_post_month.arr,d_rc_hdr_post_year.arr);

    fprintf(f1,"   %-15s   %-10s %-30s        %15s\n",d_rc_hdr_doc_ref.arr,
	    d_rc_hdr_cust_code.arr,d_ar_cust_long_name.arr,s_amt);
    fprintf(f1,"CHEQUE NO    : %-10s DATED : %-10s DRAWN ON BANK : %-30s\n",
	    d_rc_hdr_cheque_num.arr,d_conv_date_bank.arr,
	    d_rc_hdr_bank_desc.arr);
    get_acct_desc();
    fprintf(f1,"BANK A/C     : %s-%s %s %s-%s %s-%s   DESC : %s\n",
    d_rc_hdr_main_acc1_code_bk.arr, d_rc_hdr_main_acc2_code_bk.arr ,
    d_rc_hdr_dept_code_bk.arr ,d_rc_hdr_pr_group_code_bk.arr,
    d_rc_hdr_pr_line_code_bk.arr,d_rc_hdr_subl_group_code_bk.arr, 
    d_rc_hdr_subl_line_code_bk.arr,d_acct_desc_bank.arr);

    fprintf(f1,"SUSPENSE A/C : %s-%s %s %s-%s %s-%s   DESC : %s\n",
    d_rc_hdr_main_acc1_code_sp.arr, d_rc_hdr_main_acc2_code_sp.arr ,
    d_rc_hdr_dept_code_sp.arr ,d_rc_hdr_pr_group_code_sp.arr,
    d_rc_hdr_pr_line_code_sp.arr,d_rc_hdr_subl_group_code_sp.arr, 
    d_rc_hdr_subl_line_code_sp.arr,d_acct_desc_susp.arr);

    fprintf(f1,"NARRATION    : %s\n",d_rc_hdr_narration.arr);

    fprintf(f1,"\n\n");

    line_no += 7;

}


put_inp_parm()
{
    fprintf(f1,"MDL : AR                                       %30s                                       %s\n",comp_name.arr,rep_date.arr);
    fprintf(f1,"OPR : %s\n",oper_id.arr);
    fprintf(f1,"REP : ARBORPST                                        CASHIER RECEIPTS - POSTING                                         PAGE : %4d\n",page_no);
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n\n");


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
    fprintf(f1,"");
    ++page_no;


}


fetch_cust_dets()
{
    /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 50;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1202;
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
    sqlstm.arrsiz = 50;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1221;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_cust_long_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
    sqlstm.arrsiz = 50;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CONCAT_POST_ACC_DESC into :b0  from GL_POSTING_ACC\
 where ((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and\
 PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:\
b6) and SUBLEDGER_LINE_CODE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1240;
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
    sqlstm.arrsiz = 50;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CONCAT_POST_ACC_DESC into :b0  from GL_POSTING_ACC\
 where ((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and\
 PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:\
b6) and SUBLEDGER_LINE_CODE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1287;
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
    sqlstm.sqhstl[4] = (unsigned int  )13;
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
    varchar s_amt[20];

    if (nd_no_of_decimal == 3)
	   sprintf(s_amt,"%15.3f",g_tot);
    else
       sprintf(s_amt,"%15.2f",g_tot);
	
	format_amt(s_amt,nd_no_of_decimal);
    
	chk_break(5);

    fprintf(f1,"\n\n                                                                                    TOTAL  ------>                  %15s\n",s_amt);
    fprintf(f1,"\n\n                                              ** END OF REPORT **                                                               \n");
}
   