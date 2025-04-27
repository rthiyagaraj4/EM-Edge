
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
           char  filnam[50];
};
static const struct sqlcxp sqlfpn =
{
    49,
    "d:\\madhu\\billing\\sargunan\\postinvoice\\arbinpst.pc"
};


static unsigned long sqlctx = 1980859755;


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
            void  *sqhstv[59];
   unsigned int   sqhstl[59];
            int   sqhsts[59];
            void  *sqindv[59];
            int   sqinds[59];
   unsigned int   sqharm[59];
   unsigned int   *sqharc[59];
   unsigned short  sqadto[59];
   unsigned short  sqtdso[59];
} sqlstm = {10,59};

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

 static const char *sq0007 = 
"select DOC_TYPE_CODE ,DOC_NUM  from AR_INV_HDR where (((((((OPERATING_FACILI\
TY_ID=:b0 and DOC_TYPE_CODE>=NVL(:b1,'      ')) and DOC_TYPE_CODE<=NVL(:b2,'~~\
~~~~')) and DOC_NUM>=NVL(:b3,0)) and DOC_NUM<=NVL(:b4,99999999)) and NVL(DOC_D\
ATE,SYSDATE)>=NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))) a\
nd NVL(DOC_DATE,SYSDATE)<=NVL(TO_DATE(:b6,'DD/MM/YYYY'),to_date('47123112','YY\
YYDDMM'))) and NVL(POSTED_FLAG,'N')='N')           ";

 static const char *sq0008 = 
"ITLE ,ERROR_FLAG ,CONSOLIDATED_INV_YN ,MODULE_ID ,NVL(PB_INVOICE_YN,'N')  fr\
om AR_INV_HDR where ((OPERATING_FACILITY_ID=:b0 and DOC_TYPE_CODE=:b1) and DOC\
_NUM=:b2) for update of ERROR_FLAG nowait ";

 static const char *sq0014 = 
"select NVL(STATUS,'X') ,NVL(AR_VALID_FLAG,'X') ,NVL(BL_VALID_FLAG,'X') ,NVL(\
DOC_PRINT_FLAG,'X')  from GL_ACC_ENTITY_DOC_TYPE_VW where DOC_TYPE_CODE=:b0   \
        ";

 static const char *sq0015 = 
"select NVL(STATUS,'X')  from SY_DOC_TYPE_MASTER where DOC_TYPE_CODE=:b0     \
      ";

 static const char *sq0010 = 
"select 'X'  from AR_TRN_DOC_TYPE where ((OPERATING_FACILITY_ID=:b0 and DOC_T\
YPE_CODE=:b1) and TRN_TYPE_CODE='1')           ";

 static const char *sq0011 = 
"select 'X'  from SY_DOC_CONTROL where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)   \
        ";

 static const char *sq0012 = 
"select NVL(STATUS,'X') ,PATIENT_FLAG ,NVL(TO_CHAR(LAST_INV_DOC_DATE,'YYYYMMD\
D'),0)  from AR_CUSTOMER where CUST_CODE=:b0           ";

 static const char *sq0013 = 
"select NVL(STATUS,'X')  from AR_PMNT_TERMS where PMNT_TERMS_CODE=:b0        \
   ";

 static const char *sq0009 = 
"select NVL(a.AMT_LOCAL,0) ,a.LINE_NUM ,a.MAIN_ACC1_CODE ,a.MAIN_ACC2_CODE ,a\
.DEPT_CODE ,a.PRODUCT_GROUP_CODE ,a.PRODUCT_LINE_CODE ,a.SUBLEDGER_GROUP_CODE \
,a.SUBLEDGER_LINE_CODE ,a.AMT_LOCAL  from AR_INV_LINE a ,AR_INV_HDR b where ((\
((b.OPERATING_FACILITY_ID=:b0 and a.doc_type_code=b.doc_type_code) and a.doc_n\
um=b.doc_num) and a.DOC_TYPE_CODE=:b1) and a.DOC_NUM=:b2) for update of a.LINE\
_NUM nowait ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,232,0,4,309,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,
68,0,0,2,97,0,4,326,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
91,0,0,3,0,0,29,348,0,0,0,0,0,1,0,
106,0,0,4,0,0,29,447,0,0,0,0,0,1,0,
121,0,0,5,0,0,30,455,0,0,0,0,0,1,0,
136,0,0,6,0,0,30,471,0,0,0,0,0,1,0,
151,0,0,7,439,0,9,493,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
194,0,0,16,0,0,17,679,0,0,1,1,0,1,0,1,1,0,0,
213,0,0,7,0,0,13,701,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
236,0,0,8,1220,0,9,850,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
263,0,0,8,0,0,13,857,0,0,59,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
514,0,0,14,162,0,9,1003,0,0,1,1,0,1,0,1,9,0,0,
533,0,0,14,0,0,13,1018,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
564,0,0,15,82,0,9,1048,0,0,1,1,0,1,0,1,9,0,0,
583,0,0,15,0,0,13,1056,0,0,1,0,0,1,0,2,9,0,0,
602,0,0,10,123,0,9,1069,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
625,0,0,10,0,0,13,1074,0,0,1,0,0,1,0,2,9,0,0,
644,0,0,11,84,0,9,1083,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
667,0,0,11,0,0,13,1088,0,0,1,0,0,1,0,2,9,0,0,
686,0,0,12,131,0,9,1099,0,0,1,1,0,1,0,1,9,0,0,
705,0,0,12,0,0,13,1112,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
732,0,0,13,79,0,9,1132,0,0,1,1,0,1,0,1,9,0,0,
751,0,0,13,0,0,13,1140,0,0,1,0,0,1,0,2,9,0,0,
770,0,0,17,71,0,4,1164,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
793,0,0,14,162,0,9,1274,0,0,1,1,0,1,0,1,9,0,0,
812,0,0,14,0,0,13,1288,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
839,0,0,16,0,0,45,1351,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
866,0,0,18,0,0,29,1357,0,0,0,0,0,1,0,
881,0,0,16,0,0,13,1388,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
932,0,0,19,62,0,4,1423,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
955,0,0,14,162,0,9,1442,0,0,1,1,0,1,0,1,9,0,0,
974,0,0,14,0,0,13,1455,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1001,0,0,20,56,0,5,1488,0,0,2,2,0,1,0,1,3,0,0,1,9,0,0,
1024,0,0,9,400,0,9,1562,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1051,0,0,21,0,0,29,1568,0,0,0,0,0,1,0,
1066,0,0,9,0,0,13,1598,0,0,10,0,0,1,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1121,0,0,22,492,0,3,1682,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,9,0,0,
1180,0,0,23,348,0,3,1741,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,
1247,0,0,24,691,0,3,1787,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1282,0,0,25,564,0,3,1851,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1309,0,0,26,70,0,2,1893,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1332,0,0,27,71,0,2,1900,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1355,0,0,28,63,0,4,1934,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1378,0,0,29,145,0,3,1968,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1421,0,0,30,145,0,3,2047,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1464,0,0,31,53,0,5,2067,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1487,0,0,32,92,0,2,2081,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1510,0,0,33,0,0,29,2089,0,0,0,0,0,1,0,
1525,0,0,34,0,0,27,2100,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
1556,0,0,35,118,0,4,2109,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
1587,0,0,36,62,0,6,2120,0,0,1,1,0,1,0,2,9,0,0,
1606,0,0,37,44,0,4,2126,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1629,0,0,38,44,0,4,2130,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1652,0,0,39,84,0,4,2151,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1675,0,0,40,140,0,4,2162,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                    */
/************************************************************************/
/* PROGRAM NAME          : ARBINPST.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 06-JAN-1993                                   */
/*                                                                      */
/* CALLED FROM           :                                               */
/*                                                                           */
/*  FUNCTION             :                                                  */
/*                                                                      */
/*  TABLE DETAILS                                                        */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_INV_HDRR              Query/Update              */
/*         2.        AR_INV_LINE                 Query                  */
/*         3.        GL_ACC_ENTITY_DOC_TYPE_VW   Lookup                 */
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
/*         4.        IN_POST             ar_inv_posting (AR inv posting)*/
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

#define VIEW_LOG_FILE 1

#define INIT_MESG "Report Generation in Progress "

#define DEBUG 0
#define	INFO_MESG		3

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
			nd_hosp_name     [100],
p_language_id [3],
            chk_doc_type_code    [7], 

            doc_type_code    [7], 
            doc_num          [9],
			d_consolidated_inv [2],
			d_module_id		 [3],
            doc_date         [12],
            doc_date_chking  [12],
            cust_code        [9],
            pmnt_terms_code  [3],
            billing_group    [5],  -- CRF-0120
            patient_id       [21],
            patient_flag     [2],
            nd_error_flag    [2],
            rowid_hdr        [31],
            line_num         [5],
            print_flag       [3],


            dummy            [10][5],

            d_last_inv_doc_date           [12],
 
            d_sy_acc_bl_instal_flag       [4],
            d_sy_acc_mp_instal_flag       [4],
            d_ar_acc_status               [2],
            d_ar_acc_valid_flag           [2], 
			d_bl_acc_valid_flag           [2], 
            d_customer_status             [2],
            d_customer_patient_flag       [2],
            d_pmnt_terms_status           [2],
            d_bl_blng_grp_status          [2],
            
			p_operational_modules         [300],
             
            d_main_acc1_code              [8],
            d_main_acc2_code              [8],
            d_dept_code                   [15],
            d_product_group_code          [4],
            d_product_line_code           [8],
            d_subledger_group_code        [4],
			d_module_valid_id             [3],
            d_subledger_line_code         [12],
            sy_doc_print_flag             [3], 
            curr_acc_year                 [5],
            curr_acc_month                [3],
            gl_summ_pro_flag              [2],
            d_sy_num_acc_per              [5],
            prior_post_allow              [3],
			nd_acc_entity_code            [5],
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

struct { unsigned short len; unsigned char arr[100]; } nd_hosp_name;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[7]; } chk_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } doc_num;

struct { unsigned short len; unsigned char arr[2]; } d_consolidated_inv;

struct { unsigned short len; unsigned char arr[3]; } d_module_id;

struct { unsigned short len; unsigned char arr[12]; } doc_date;

struct { unsigned short len; unsigned char arr[12]; } doc_date_chking;

struct { unsigned short len; unsigned char arr[9]; } cust_code;

struct { unsigned short len; unsigned char arr[3]; } pmnt_terms_code;

struct { unsigned short len; unsigned char arr[5]; } billing_group;

struct { unsigned short len; unsigned char arr[21]; } patient_id;

struct { unsigned short len; unsigned char arr[2]; } patient_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_error_flag;

struct { unsigned short len; unsigned char arr[31]; } rowid_hdr;

struct { unsigned short len; unsigned char arr[5]; } line_num;

struct { unsigned short len; unsigned char arr[3]; } print_flag;

struct { unsigned short len; unsigned char arr[6]; } dummy[10];

struct { unsigned short len; unsigned char arr[12]; } d_last_inv_doc_date;

struct { unsigned short len; unsigned char arr[4]; } d_sy_acc_bl_instal_flag;

struct { unsigned short len; unsigned char arr[4]; } d_sy_acc_mp_instal_flag;

struct { unsigned short len; unsigned char arr[2]; } d_ar_acc_status;

struct { unsigned short len; unsigned char arr[2]; } d_ar_acc_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } d_bl_acc_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } d_customer_status;

struct { unsigned short len; unsigned char arr[2]; } d_customer_patient_flag;

struct { unsigned short len; unsigned char arr[2]; } d_pmnt_terms_status;

struct { unsigned short len; unsigned char arr[2]; } d_bl_blng_grp_status;

struct { unsigned short len; unsigned char arr[300]; } p_operational_modules;

struct { unsigned short len; unsigned char arr[8]; } d_main_acc1_code;

struct { unsigned short len; unsigned char arr[8]; } d_main_acc2_code;

struct { unsigned short len; unsigned char arr[15]; } d_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_product_group_code;

struct { unsigned short len; unsigned char arr[8]; } d_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_subledger_group_code;

struct { unsigned short len; unsigned char arr[3]; } d_module_valid_id;

struct { unsigned short len; unsigned char arr[12]; } d_subledger_line_code;

struct { unsigned short len; unsigned char arr[3]; } sy_doc_print_flag;

struct { unsigned short len; unsigned char arr[5]; } curr_acc_year;

struct { unsigned short len; unsigned char arr[3]; } curr_acc_month;

struct { unsigned short len; unsigned char arr[2]; } gl_summ_pro_flag;

struct { unsigned short len; unsigned char arr[5]; } d_sy_num_acc_per;

struct { unsigned short len; unsigned char arr[3]; } prior_post_allow;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[19]; } d_chk_amt_local;


   /* VARCHAR  ar_interface_code[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } ar_interface_code;


   /* VARCHAR  d_hdr_main_acc1_code              [8],
            d_hdr_main_acc2_code              [8],
            d_hdr_dept_code                   [15],
            d_hdr_product_group_code          [4],
            d_hdr_product_line_code           [8],
            d_hdr_subledger_group_code        [4],
            d_hdr_subledger_line_code         [12]; */ 
struct { unsigned short len; unsigned char arr[8]; } d_hdr_main_acc1_code;

struct { unsigned short len; unsigned char arr[8]; } d_hdr_main_acc2_code;

struct { unsigned short len; unsigned char arr[15]; } d_hdr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_hdr_product_group_code;

struct { unsigned short len; unsigned char arr[8]; } d_hdr_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_hdr_subledger_group_code;

struct { unsigned short len; unsigned char arr[12]; } d_hdr_subledger_line_code;


   /* VARCHAR d_hdr_acc_entity_code                [5],
           d_hdr_last_line_num                  [5],
           d_hdr_narration                      [51],
           d_hdr_base_date                      [12],
           d_chk_base_date                      [12],
           d_hdr_due_date                       [12],
           d_chk_due_date                       [12],
           d_hdr_gross_amt                      [16],
           d_hdr_discount_amt                   [16],
		   d_hdr_markup_amt                     [16],
           d_hdr_currency_code                  [8],
           d_hdr_exchg_rate                     [16],
           d_hdr_settlement_date                [12],
           d_chk_settlement_date                [12],
           d_hdr_settlement_perc                [6],
           d_hdr_cust_ref                       [16],
           d_hdr_bill_doc_type_code             [7],
           d_hdr_bill_num                       [9],
           d_hdr_bill_date                      [13],
           d_chk_bill_date                      [13],
           d_hdr_doctor_fee_amt                 [16],
           d_hdr_post_month                     [3],
           d_hdr_post_year                      [5],
           d_hdr_misc_cust_long_name            [101],  -- CRF-0120
           d_hdr_misc_cust_short_name           [101],  -- CRF-0120
           d_hdr_misc_cust_add1_desc            [61],  -- CRF-0120
           d_hdr_misc_cust_add2_desc            [61],  -- CRF-0120
           d_hdr_misc_cust_add3_desc            [61],  -- CRF-0120
           d_hdr_misc_cust_zip_desc             [31],
           d_hdr_cust_long_name_locl    [101],  -- CRF-0120
           d_hdr_cust_short_name_locl   [101],  -- CRF-0120
           d_hdr_cust_add1_desc_locl    [61],  -- CRF-0120
           d_hdr_cust_add2_desc_locl    [61],  -- CRF-0120
           d_hdr_cust_add3_desc_locl    [61],  -- CRF-0120
           d_hdr_cust_zip_desc_locl     [31],
           d_hdr_tel_num                        [31],
           d_hdr_contact_name                   [101],  -- CRF-0120
           d_hdr_contact_name_title             [61],  -- CRF-0120
           d_hdr_error_flag                     [2],
           d_curr_pgm_name                      [15],
           mast_status                          [2],
           d_chk_payable_amt                    [17],
		   d_pb_invoice_yn						[2],

           ar_pat_doc_type_code          [7],
           ar_pat_doc_num                [9],
           ar_pat_patient_id             [21],
           ar_pat_bill_doc_type_code     [7],
           ar_pat_bill_num               [9],
           ar_pat_remarks                [16],
           ar_pat_bill_date              [12],
           ar_pat_rowid                  [31]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_hdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[5]; } d_hdr_last_line_num;

struct { unsigned short len; unsigned char arr[51]; } d_hdr_narration;

struct { unsigned short len; unsigned char arr[12]; } d_hdr_base_date;

struct { unsigned short len; unsigned char arr[12]; } d_chk_base_date;

struct { unsigned short len; unsigned char arr[12]; } d_hdr_due_date;

struct { unsigned short len; unsigned char arr[12]; } d_chk_due_date;

struct { unsigned short len; unsigned char arr[16]; } d_hdr_gross_amt;

struct { unsigned short len; unsigned char arr[16]; } d_hdr_discount_amt;

struct { unsigned short len; unsigned char arr[16]; } d_hdr_markup_amt;

struct { unsigned short len; unsigned char arr[8]; } d_hdr_currency_code;

struct { unsigned short len; unsigned char arr[16]; } d_hdr_exchg_rate;

struct { unsigned short len; unsigned char arr[12]; } d_hdr_settlement_date;

struct { unsigned short len; unsigned char arr[12]; } d_chk_settlement_date;

struct { unsigned short len; unsigned char arr[6]; } d_hdr_settlement_perc;

struct { unsigned short len; unsigned char arr[16]; } d_hdr_cust_ref;

struct { unsigned short len; unsigned char arr[7]; } d_hdr_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_hdr_bill_num;

struct { unsigned short len; unsigned char arr[13]; } d_hdr_bill_date;

struct { unsigned short len; unsigned char arr[13]; } d_chk_bill_date;

struct { unsigned short len; unsigned char arr[16]; } d_hdr_doctor_fee_amt;

struct { unsigned short len; unsigned char arr[3]; } d_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_hdr_post_year;

struct { unsigned short len; unsigned char arr[101]; } d_hdr_misc_cust_long_name;

struct { unsigned short len; unsigned char arr[101]; } d_hdr_misc_cust_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_misc_cust_add1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_misc_cust_add2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_misc_cust_add3_desc;

struct { unsigned short len; unsigned char arr[31]; } d_hdr_misc_cust_zip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_hdr_cust_long_name_locl;

struct { unsigned short len; unsigned char arr[101]; } d_hdr_cust_short_name_locl;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_cust_add1_desc_locl;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_cust_add2_desc_locl;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_cust_add3_desc_locl;

struct { unsigned short len; unsigned char arr[31]; } d_hdr_cust_zip_desc_locl;

struct { unsigned short len; unsigned char arr[31]; } d_hdr_tel_num;

struct { unsigned short len; unsigned char arr[101]; } d_hdr_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_contact_name_title;

struct { unsigned short len; unsigned char arr[2]; } d_hdr_error_flag;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } mast_status;

struct { unsigned short len; unsigned char arr[17]; } d_chk_payable_amt;

struct { unsigned short len; unsigned char arr[2]; } d_pb_invoice_yn;

struct { unsigned short len; unsigned char arr[7]; } ar_pat_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_doc_num;

struct { unsigned short len; unsigned char arr[21]; } ar_pat_patient_id;

struct { unsigned short len; unsigned char arr[7]; } ar_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_bill_num;

struct { unsigned short len; unsigned char arr[16]; } ar_pat_remarks;

struct { unsigned short len; unsigned char arr[12]; } ar_pat_bill_date;

struct { unsigned short len; unsigned char arr[31]; } ar_pat_rowid;


   char    l_sql_stmt                    [3000];   

   double   nd_dtl_tot_amt,
            nd_dtl_tot_deb_amt,
            amt_local,
            payable_amt,
            ar_pat_amount,
            ar_pat_tot_amt;
   
   int     nd_no_of_decimal,ar_pat_line_num;

   int     bl_instal_flag , mp_instal_flag;

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
    int i = 0;
      disp_mesg("Not enough Parameters for running this program\n");
      proc_exit();
   }

   if (argv[5][0] == 'R')
      strcpy(g_pgm_id,"ARRINLST");
   else
      strcpy(g_pgm_id,"ARBINPST");

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
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);
              

   set_meduser_role();
//strcpy(p_language_id.arr,l_language_id.arr);
p_language_id.len = p_language_id.len;  
   chk_active();


   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   nd_proc_flag.arr[0]      = '\0';
   nd_view_print_flg.arr[0] = '\0';
   nd_facility_id.arr[0]='\0';
   nd_hosp_name.arr[0]='\0';
   
   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   nd_proc_flag.len         = 0;
   nd_view_print_flg.len    = 0;
   nd_facility_id.len    = 0;
   nd_hosp_name.len = 0;

   process_rep_flg          = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID , PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM8,
                   PARAM9,PARAM10
              INTO :nd_facility_id, :nd_fm_doc_type, :nd_fm_doc_num, :nd_fm_doc_date,
                   :nd_to_doc_type, :nd_to_doc_num, :nd_to_doc_date,
                   :nd_proc_flag,
                   :nd_view_print_flg, :process_rep_flg
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBINPST'
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
b7,:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='ARBINPST' and SESSION_ID=:b10) \
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
		
   nd_facility_id.arr[nd_facility_id.len]    = '\0';
   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';
   nd_proc_flag.arr[nd_proc_flag.len]        = '\0';
   nd_view_print_flg.arr[nd_view_print_flg.len]        = '\0';

   start_prog_control();
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



   start_prog_msg();
   
   delete_records();

   fetch_acc_entity_flag();

   fetch_ar_parameter();
  
   declare_cursor();

disp_message(INFO_MESG,nd_hosp_name.arr);
disp_message(INFO_MESG,"\n");
   while (fetch_cur())    /* Fetches Hdr recs rowid */
   {
     
	 
	  strcpy(nd_error_flag.arr,"N");
      nd_error_flag.len = 1;

      if (!fetch_rec())    /* Fetch all the details & lock Hdr row */
          continue;

      validate_inv_header();

//      if (d_customer_patient_flag.arr[0] == 'N')

     /*************** Conslidated invoice  of Billing module****************/

   
	 
	 if ((strcmp(d_consolidated_inv.arr , "Y") == 0) 
	     && (strcmp(d_module_id.arr  , "BL") == 0))
      {
           ar_pat_tot_amt = 0;

           if (!open_patient_dtls())
                continue;

           ar_pat_line_num = 1;

           while (fetch_patient_dtls())
           {
                validate_patient_dtls();
                update_pat_dtls();
           }

           if ((ar_pat_line_num != 1) &&
              (doubcmp(ar_pat_tot_amt,payable_amt) != 0))
                 error_insert_null("   0","AR2180","");
      }

      if (!validate_inv_line()) /* Fetch & validate inv lines         */
           continue;            /* Returns 1 if Lines are locked      */

      validate_inv_amt();

      update_err_flg();
      
	 

      if (nd_proc_flag.arr[0] == 'P') 
      { 
      
       if (nd_error_flag.arr[0] == 'N')
          {
			 /* Added on 2/12/2003 to accomodate temporary adhoc function*/
			 if (strcmp(d_pb_invoice_yn.arr,"Y") == 0)
			    insert_ar_patient_dtls();

			 if (ar_interface_code.arr[0] != 'O')
             {
                 
               ar_inv_posting(rowid_hdr.arr,ar_interface_code.arr,
                               d_last_inv_doc_date.arr);
             }
             else
             {
                  gl_doc_insert();
                  if (!gl_posting())
				  {


				    ins_gl_distrbn(doc_type_code.arr,doc_num.arr,1,nd_facility_id.arr);
     
				     ar_inv_posting(rowid_hdr.arr,ar_interface_code.arr,
                              d_last_inv_doc_date.arr);
                  } 
/*    Commented on 15-MAR-93 as per request by GL team 

      if (!  (atoi(d_hdr_post_year.arr) > atoi(curr_acc_year.arr)) ||
            ( atoi(d_hdr_post_year.arr) == atoi(curr_acc_year.arr) && 
              atoi(d_hdr_post_month.arr) > atoi(curr_acc_month.arr) )  )
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
       sqlstm.offset = (unsigned int  )106;
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
   sqlstm.offset = (unsigned int  )121;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
        err_mesg("COMMIT failed",0,""); 

   run_report();

   if(sql_connect() == -1)
   {
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
   sqlstm.offset = (unsigned int  )136;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

declare_cursor()
{


   /* EXEC SQL DECLARE CUR_INV_HDR CURSOR FOR
             SELECT DOC_TYPE_CODE, DOC_NUM 
               FROM AR_INV_HDR
              WHERE OPERATING_FACILITY_ID=:nd_facility_id  
			    AND DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
                AND NVL(POSTED_FLAG,'N') = 'N'; */ 


   /* EXEC SQL OPEN CUR_INV_HDR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )151;
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
         err_mesg("OPEN failed on cursor CUR_INV_HDR",0,"");


   /* EXEC SQL DECLARE CUR_INV_REC CURSOR FOR
             SELECT TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    TO_CHAR(DOC_DATE,'YYYYMMDD'),
                    CUST_CODE,        PMNT_TERMS_CODE,
                    BILLING_GROUP,    PATIENT_ID,
                    NVL(PAYABLE_AMT,0),
                    PAYABLE_AMT,
                    PRINT_FLAG,
                    MAIN_ACC1_CODE,
                    MAIN_ACC2_CODE,
                    DEPT_CODE,
                    PRODUCT_GROUP_CODE,
                    PRODUCT_LINE_CODE,
                    SUBLEDGER_GROUP_CODE,
                    SUBLEDGER_LINE_CODE,
                    ROWID rwid,
                    ACC_ENTITY_CODE,
                    LAST_LINE_NUM,
                    NARRATION   ,
                    BASE_DATE   ,
                    TO_CHAR(BASE_DATE,'YYYYMMDD'),
                    DUE_DATE,
                    TO_CHAR(DUE_DATE,'YYYYMMDD'),
                    GROSS_AMT,
                    DISCOUNT_AMT,
					MARKUP_AMT,
                    CURRENCY_CODE ,
                    EXCHG_RATE  ,
                    SETTLEMENT_DATE  , 
                    TO_CHAR(SETTLEMENT_DATE,'YYYYMMDD'),
                    SETTLEMENT_PERC  ,
                    CUST_REF  ,
                    BILL_DOC_TYPE_CODE  ,
                    BILL_NUM  ,
                    BILL_DATE  ,
                    TO_CHAR(BILL_DATE,'YYYYMMDD'),
                    DOCTOR_FEE_AMT   ,
					POST_MONTH  ,
                    POST_YEAR  ,
                    MISC_CUST_LONG_NAME  ,
                    MISC_CUST_SHORT_NAME    ,
                    MISC_CUST_ADD1_DESC    ,
                    MISC_CUST_ADD2_DESC    ,
                    MISC_CUST_ADD3_DESC    ,
                    MISC_CUST_ZIP_DESC    ,
                    MISC_CUST_LONG_NAME_CHINESE    ,
                    MISC_CUST_SHORT_NAME_CHINESE    ,
                    MISC_CUST_ADD1_DESC_CHINESE    ,
                    MISC_CUST_ADD2_DESC_CHINESE    ,
                    MISC_CUST_ADD3_DESC_CHINESE    ,
                    MISC_CUST_ZIP_DESC_CHINESE    ,
                    TEL_NUM    ,
                    CONTACT_NAME    ,
                    CONTACT_NAME_TITLE    ,
                    ERROR_FLAG  ,
					CONSOLIDATED_INV_YN,
					MODULE_ID,
					NVL(PB_INVOICE_YN,'N')
               FROM AR_INV_HDR
              WHERE OPERATING_FACILITY_ID= :nd_facility_id
			    and DOC_TYPE_CODE = :doc_type_code
                AND DOC_NUM       = :doc_num
                FOR UPDATE OF ERROR_FLAG NOWAIT; */ 


   /* EXEC SQL DECLARE CUR_INV_LINE CURSOR FOR
             SELECT NVL(a.AMT_LOCAL,0), a.LINE_NUM,
                    a.MAIN_ACC1_CODE,
                    a.MAIN_ACC2_CODE,
                    a.DEPT_CODE,
                    a.PRODUCT_GROUP_CODE,
                    a.PRODUCT_LINE_CODE,
                    a.SUBLEDGER_GROUP_CODE,
                    a.SUBLEDGER_LINE_CODE,
                    a.AMT_LOCAL
               FROM AR_INV_LINE a,AR_INV_HDR b
              WHERE b.OPERATING_FACILITY_ID= :nd_facility_id
			    and a.doc_type_code=b.doc_type_code
				and a.doc_num=b.doc_num 
			    and a.DOC_TYPE_CODE = :doc_type_code
                AND a.DOC_NUM       = :doc_num
                FOR UPDATE OF a.LINE_NUM NOWAIT; */ 


   /* EXEC SQL DECLARE AR_TRN_DOC_TYPE_CUR CURSOR FOR
             SELECT 'X'
               FROM AR_TRN_DOC_TYPE
              WHERE OPERATING_FACILITY_ID= :nd_facility_id
			    AND DOC_TYPE_CODE = :doc_type_code
                AND TRN_TYPE_CODE = '1'; */ 


   /* EXEC SQL DECLARE SY_DOC_CONTROL_CUR CURSOR FOR
             SELECT 'X'
               FROM SY_DOC_CONTROL
              WHERE DOC_TYPE_CODE = :doc_type_code
                AND DOC_NUM       = :doc_num; */ 


   /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
             SELECT NVL(STATUS,'X'),
                    PATIENT_FLAG,
                    NVL(TO_CHAR(LAST_INV_DOC_DATE,'YYYYMMDD'),0)
               FROM AR_CUSTOMER
              WHERE CUST_CODE        = :cust_code; */ 


   /* EXEC SQL DECLARE AR_PMNT_TERMS_CUR CURSOR FOR
             SELECT NVL(STATUS,'X')
               FROM AR_PMNT_TERMS
              WHERE PMNT_TERMS_CODE = :pmnt_terms_code; */ 


   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
             SELECT NVL(STATUS,'X'),
                    NVL(AR_VALID_FLAG,'X'),
                    NVL(BL_VALID_FLAG,'X'),
                    NVL(DOC_PRINT_FLAG,'X')
               FROM GL_ACC_ENTITY_DOC_TYPE_VW
              WHERE DOC_TYPE_CODE   = :chk_doc_type_code; */ 


    /* EXEC SQL DECLARE SY_DOC_TYPE_MAST_CUR CURSOR FOR
              SELECT NVL(STATUS,'X')
                FROM SY_DOC_TYPE_MASTER
               WHERE DOC_TYPE_CODE = :chk_doc_type_code; */ 


    /* commented on 2/12/2003 to accomodate temporary adhoc function.
	EXEC SQL DECLARE AR_PATIENT_DTLS_CUR CURSOR FOR
              SELECT DOC_TYPE_CODE,
                     DOC_NUM,
                     PATIENT_ID,
                     BILL_DOC_TYPE_CODE,
                     BILL_NUM,
                     TO_CHAR(BILL_DATE,'YYYYMMDD'),
                     REMARKS,
                     NVL(AMOUNT,0),
                     ROWID
                FROM AR_PATIENT_DTLS
               WHERE OPERATING_FACILITY_ID=:nd_facility_id
			   AND DOC_TYPE_CODE = :doc_type_code
                 AND DOC_NUM       = :doc_num
               ORDER BY BILL_DATE, PATIENT_ID
                 FOR UPDATE OF LINE_NUM NOWAIT;
    */
	/* Added on 2/12/2003 to accomodate temporary adhoc function*/	
         
		if (strcmp(d_pb_invoice_yn.arr,"Y") == 0)
		{
	           strcpy(l_sql_stmt," SELECT AR_INVOICE_DOC_TYPE_CODE DOC_TYPE_CODE, \
                                          AR_INVOICE_DOC_NUM DOC_NUM, \
                                          PATIENT_ID, \
                                          DOC_TYPE_CODE BILL_DOC_TYPE_CODE, \
                                          DOC_NUM BILL_NUM, \
                                          TO_CHAR(DOC_DATE,'YYYYMMDD') BILL_DATE, \
                                          DOC_REF REMARKS, \
                                          NVL(DOC_AMT,0) AMOUNT, \
                                          ROWID \
                                     FROM AR_PAT_BILLS_TEMP \
                                    WHERE OPERATING_FACILITY_ID= :nd_facility_id \
									  AND AR_INVOICE_DOC_TYPE_CODE = :doc_type_code \
                                      AND AR_INVOICE_DOC_NUM       = :doc_num \
                                 ORDER BY DOC_DATE, PATIENT_ID"); 


        }
		else
        {	
               
               strcpy(l_sql_stmt," SELECT DOC_TYPE_CODE, \
                                          DOC_NUM, \
                                          PATIENT_ID, \
                                          BILL_DOC_TYPE_CODE, \
                                          BILL_NUM, \
                                          TO_CHAR(BILL_DATE,'YYYYMMDD'), \
                                          REMARKS, \
                                          NVL(AMOUNT,0), \
                                          ROWID \
                                     FROM AR_PATIENT_DTLS  \
                                    WHERE OPERATING_FACILITY_ID= :nd_facility_id  \
									  AND DOC_TYPE_CODE = :doc_type_code \
                                      AND DOC_NUM       = :doc_num \
                                 ORDER BY BILL_DATE, PATIENT_ID \
                                      FOR UPDATE OF LINE_NUM NOWAIT");		 
		 						  
		 }

	     /* EXEC SQL PREPARE SELECT_PATIENT FROM :l_sql_stmt; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 12;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )194;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)l_sql_stmt;
      sqlstm.sqhstl[0] = (unsigned int  )3000;
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



         if(OERROR)
		    err_mesg("DECLARE failed while PREPARING cursor AR_PATIENT_DTLS_CUR",0,"");

	     /* EXEC SQL DECLARE AR_PATIENT_DTLS_CUR CURSOR FOR SELECT_PATIENT; */ 


	     if(OERROR)	   
		    err_mesg("DECLARE failed on cursor AR_PATIENT_DTLS_CUR",0,"");

} 

fetch_cur()    
{

   doc_type_code.arr[0]     = '\0';
   doc_num.arr[0]           = '\0';
   
   doc_type_code.len        = 0;
   doc_num.len              = 0;
   

   /* EXEC SQL FETCH CUR_INV_HDR 
             INTO :doc_type_code, :doc_num ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )213;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&doc_num;
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
         err_mesg("FETCH failed on cursor CUR_INV_HDR",0,"");

   doc_type_code.arr[doc_type_code.len]     = '\0';
   doc_num.arr[doc_num.len]                 = '\0';
   
   if (LAST_ROW)
       return(0);
   else
       return(1);
}

fetch_rec()
{
   cust_code.arr[0]         = '\0';
   pmnt_terms_code.arr[0]   = '\0';
   billing_group.arr[0]     = '\0';
   patient_id.arr[0]        = '\0';

   d_hdr_main_acc1_code.arr[0]       = '\0';
   d_hdr_main_acc2_code.arr[0]       = '\0';
   d_hdr_dept_code.arr[0]            = '\0';
   d_hdr_product_group_code.arr[0]   = '\0';
   d_hdr_product_line_code.arr[0]    = '\0';
   d_hdr_subledger_group_code.arr[0] = '\0';
   d_hdr_subledger_line_code.arr[0]  = '\0';

   rowid_hdr.arr[0]              = '\0';
   doc_date.arr[0]               = '\0';
   doc_date_chking.arr[0]        = '\0';

   print_flag.arr[0]             = '\0';       

   cust_code.len            = 0;
   pmnt_terms_code.len      = 0;
   billing_group.len        = 0;
   patient_id.len           = 0;
   print_flag.len           = 0;       
   
   d_hdr_main_acc1_code.len       = 0;
   d_hdr_main_acc2_code.len       = 0;
   d_hdr_dept_code.len            = 0;
   d_hdr_product_group_code.len   = 0;
   d_hdr_product_line_code.len    = 0;
   d_hdr_subledger_group_code.len = 0;
   d_hdr_subledger_line_code.len  = 0;
   rowid_hdr.len              = 0;
   doc_date.len               = 0;
   doc_date_chking.len        = 0;  

   nd_dtl_tot_amt             = 0;
   nd_dtl_tot_deb_amt         = 0;  
   payable_amt                = 0;
   d_chk_payable_amt.arr[0]   = '\0';
   d_chk_payable_amt.len      = 0;
 
   d_hdr_acc_entity_code.arr[0]   = '\0';
   d_hdr_last_line_num.arr[0]   = '\0';
   d_hdr_narration.arr[0]   = '\0';
   d_hdr_base_date.arr[0]   = '\0';
   d_chk_base_date.arr[0]   = '\0';
   d_hdr_due_date.arr[0]   = '\0';
   d_chk_due_date.arr[0]   = '\0';
   d_hdr_gross_amt.arr[0]   = '\0';
   d_hdr_discount_amt.arr[0]   = '\0';
   d_hdr_markup_amt.arr[0]   = '\0';
   d_hdr_currency_code.arr[0]   = '\0';
   d_hdr_exchg_rate.arr[0]   = '\0';
   d_hdr_settlement_date.arr[0]   = '\0';
   d_chk_settlement_date.arr[0]   = '\0';
   d_hdr_settlement_perc.arr[0]   = '\0';
   d_hdr_cust_ref.arr[0]   = '\0';
   d_hdr_bill_doc_type_code.arr[0]   = '\0';
   d_hdr_bill_num.arr[0]   = '\0';
   d_hdr_bill_date.arr[0]   = '\0';
   d_chk_bill_date.arr[0]   = '\0';
   d_hdr_doctor_fee_amt.arr[0]   = '\0';
   d_hdr_post_month.arr[0]   = '\0';
   d_hdr_post_year.arr[0]   = '\0';
   d_hdr_misc_cust_long_name.arr[0]   = '\0';
   d_hdr_misc_cust_short_name.arr[0]   = '\0';
   d_hdr_misc_cust_add1_desc.arr[0]   = '\0';
   d_hdr_misc_cust_add2_desc.arr[0]   = '\0';
   d_hdr_misc_cust_add3_desc.arr[0]   = '\0';
   d_hdr_misc_cust_zip_desc.arr[0]   = '\0';
   d_hdr_cust_long_name_locl.arr[0]   = '\0';
   d_hdr_cust_short_name_locl.arr[0]   = '\0';
   d_hdr_cust_add1_desc_locl.arr[0]   = '\0';
   d_hdr_cust_add2_desc_locl.arr[0]   = '\0';
   d_hdr_cust_add3_desc_locl.arr[0]   = '\0';
   d_hdr_cust_zip_desc_locl.arr[0]   = '\0';

   d_consolidated_inv.arr[0] = '\0';
   d_module_id.arr[0] = '\0';

   d_hdr_tel_num.arr[0]   = '\0';
   d_hdr_contact_name.arr[0]   = '\0';
   d_hdr_contact_name_title.arr[0]   = '\0';
   d_hdr_error_flag.arr[0]   = '\0';

   d_hdr_acc_entity_code.len     = 0;
   d_hdr_last_line_num.len     = 0;
   d_hdr_narration.len     = 0;
   d_hdr_base_date.len     = 0;
   d_chk_base_date.len     = 0;
   d_hdr_due_date.len     = 0;
   d_chk_due_date.len     = 0;
   d_hdr_gross_amt.len     = 0;
   d_hdr_discount_amt.len     = 0;
   d_hdr_markup_amt.len     = 0;
   d_hdr_currency_code.len     = 0;
   d_hdr_exchg_rate.len     = 0;
   d_hdr_settlement_date.len     = 0;
   d_chk_settlement_date.len     = 0;
   d_hdr_settlement_perc.len     = 0;
   d_hdr_cust_ref.len     = 0;
   d_hdr_bill_doc_type_code.len     = 0;
   d_hdr_bill_num.len     = 0;
   d_hdr_bill_date.len     = 0;
   d_chk_bill_date.len     = 0;
   d_hdr_doctor_fee_amt.len     = 0;
   d_hdr_post_month.len     = 0;
   d_hdr_post_year.len     = 0;
   d_hdr_misc_cust_long_name.len     = 0;
   d_hdr_misc_cust_short_name.len     = 0;
   d_hdr_misc_cust_add1_desc.len     = 0;
   d_hdr_misc_cust_add2_desc.len     = 0;
   d_hdr_misc_cust_add3_desc.len     = 0;
   d_hdr_misc_cust_zip_desc.len     = 0;
   d_hdr_cust_long_name_locl.len     = 0;
   d_hdr_cust_short_name_locl.len     = 0;
   d_hdr_cust_add1_desc_locl.len     = 0;
   d_hdr_cust_add2_desc_locl.len     = 0;
   d_hdr_cust_add3_desc_locl.len     = 0;
   d_hdr_cust_zip_desc_locl.len     = 0;

   d_consolidated_inv.len = 0;
   d_module_id.len = 0;
   d_pb_invoice_yn.len = 0; 

   d_hdr_tel_num.len     = 0;
   d_hdr_contact_name.len     = 0;
   d_hdr_contact_name_title.len     = 0;
   d_hdr_error_flag.len     = 0;


   /* EXEC SQL OPEN CUR_INV_REC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,TO_CHAR(DOC_DATE,'YYYYMMDD') ,C\
UST_CODE ,PMNT_TERMS_CODE ,BILLING_GROUP ,PATIENT_ID ,NVL(PAYABLE_AMT,0) ,PA\
YABLE_AMT ,PRINT_FLAG ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GR\
OUP_CODE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,ROWI\
D rwid ,ACC_ENTITY_CODE ,LAST_LINE_NUM ,NARRATION ,BASE_DATE ,TO_CHAR(BASE_D\
ATE,'YYYYMMDD') ,DUE_DATE ,TO_CHAR(DUE_DATE,'YYYYMMDD') ,GROSS_AMT ,DISCOUNT\
_AMT ,MARKUP_AMT ,CURRENCY_CODE ,EXCHG_RATE ,SETTLEMENT_DATE ,TO_CHAR(SETTLE\
MENT_DATE,'YYYYMMDD') ,SETTLEMENT_PERC ,CUST_REF ,BILL_DOC_TYPE_CODE ,BILL_N\
UM ,BILL_DATE ,TO_CHAR(BILL_DATE,'YYYYMMDD') ,DOCTOR_FEE_AMT ,POST_MONTH ,PO\
ST_YEAR ,MISC_CUST_LONG_NAME ,MISC_CUST_SHORT_NAME ,MISC_CUST_ADD1_DESC ,MIS\
C_CUST_ADD2_DESC ,MISC_CUST_ADD3_DESC ,MISC_CUST_ZIP_DESC ,MISC_CUST_LONG_NA\
ME_CHINESE ,MISC_CUST_SHORT_NAME_CHINESE ,MISC_CUST_ADD1_DESC_CHINESE ,MISC_\
CUST_ADD2_DESC_CHINESE ,MISC_CUST_ADD3_DESC_CHINESE ,MISC_CUST_ZIP_DESC_CHIN\
ESE ,TEL_NUM ,CONTACT_NAME ,CONTACT_NAME_T");
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )236;
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
   sqlstm.sqhstv[1] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&doc_num;
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
         err_mesg("OPEN failed on cursor CUR_INV_REC",0,"");

   /* EXEC SQL FETCH CUR_INV_REC
             INTO :doc_date,
                  :doc_date_chking,
                  :cust_code,                 :pmnt_terms_code,
                  :billing_group,             :patient_id,
                  :payable_amt,
                  :d_chk_payable_amt,         :print_flag,
                  :d_hdr_main_acc1_code,      :d_hdr_main_acc2_code,
                  :d_hdr_dept_code,           :d_hdr_product_group_code,
                  :d_hdr_product_line_code,   :d_hdr_subledger_group_code,
                  :d_hdr_subledger_line_code, :rowid_hdr,
/o** Additional Fields  **o/

                  :d_hdr_acc_entity_code                   ,
                  :d_hdr_last_line_num                     ,
                  :d_hdr_narration                         ,
                  :d_hdr_base_date                          ,
                  :d_chk_base_date                          ,
                  :d_hdr_due_date                           ,
                  :d_chk_due_date                           ,
                  :d_hdr_gross_amt                          ,
                  :d_hdr_discount_amt                       ,
				  :d_hdr_markup_amt                       ,
                  :d_hdr_currency_code                     ,
                  :d_hdr_exchg_rate                         ,
                  :d_hdr_settlement_date                    ,
                  :d_chk_settlement_date                    ,
                  :d_hdr_settlement_perc                   ,
                  :d_hdr_cust_ref                           ,
                  :d_hdr_bill_doc_type_code                ,
                  :d_hdr_bill_num                          ,
                  :d_hdr_bill_date                          ,
                  :d_chk_bill_date                          ,
                  :d_hdr_doctor_fee_amt                     ,
                  :d_hdr_post_month                        ,
                  :d_hdr_post_year                         ,
                  :d_hdr_misc_cust_long_name                ,
                  :d_hdr_misc_cust_short_name               ,
                  :d_hdr_misc_cust_add1_desc                ,
                  :d_hdr_misc_cust_add2_desc                ,
                  :d_hdr_misc_cust_add3_desc                ,
                  :d_hdr_misc_cust_zip_desc                 ,
                  :d_hdr_cust_long_name_locl        ,
                  :d_hdr_cust_short_name_locl       ,
                  :d_hdr_cust_add1_desc_locl        ,
                  :d_hdr_cust_add2_desc_locl        ,
                  :d_hdr_cust_add3_desc_locl        ,
                  :d_hdr_cust_zip_desc_locl         ,
                  :d_hdr_tel_num                            ,
                  :d_hdr_contact_name                       ,
                  :d_hdr_contact_name_title                 ,
                  :d_hdr_error_flag  ,
				  :d_consolidated_inv ,
				  :d_module_id,
				  :d_pb_invoice_yn ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )263;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&doc_date;
   sqlstm.sqhstl[0] = (unsigned int  )14;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&doc_date_chking;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&pmnt_terms_code;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&billing_group;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&patient_id;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&payable_amt;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_chk_payable_amt;
   sqlstm.sqhstl[7] = (unsigned int  )19;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&print_flag;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_hdr_main_acc1_code;
   sqlstm.sqhstl[9] = (unsigned int  )10;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_hdr_main_acc2_code;
   sqlstm.sqhstl[10] = (unsigned int  )10;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_hdr_dept_code;
   sqlstm.sqhstl[11] = (unsigned int  )17;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_hdr_product_group_code;
   sqlstm.sqhstl[12] = (unsigned int  )6;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_hdr_product_line_code;
   sqlstm.sqhstl[13] = (unsigned int  )10;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_hdr_subledger_group_code;
   sqlstm.sqhstl[14] = (unsigned int  )6;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_hdr_subledger_line_code;
   sqlstm.sqhstl[15] = (unsigned int  )14;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&rowid_hdr;
   sqlstm.sqhstl[16] = (unsigned int  )33;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_hdr_acc_entity_code;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_hdr_last_line_num;
   sqlstm.sqhstl[18] = (unsigned int  )7;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_hdr_narration;
   sqlstm.sqhstl[19] = (unsigned int  )53;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_hdr_base_date;
   sqlstm.sqhstl[20] = (unsigned int  )14;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_chk_base_date;
   sqlstm.sqhstl[21] = (unsigned int  )14;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_hdr_due_date;
   sqlstm.sqhstl[22] = (unsigned int  )14;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_chk_due_date;
   sqlstm.sqhstl[23] = (unsigned int  )14;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_hdr_gross_amt;
   sqlstm.sqhstl[24] = (unsigned int  )18;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_hdr_discount_amt;
   sqlstm.sqhstl[25] = (unsigned int  )18;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&d_hdr_markup_amt;
   sqlstm.sqhstl[26] = (unsigned int  )18;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&d_hdr_currency_code;
   sqlstm.sqhstl[27] = (unsigned int  )10;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&d_hdr_exchg_rate;
   sqlstm.sqhstl[28] = (unsigned int  )18;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&d_hdr_settlement_date;
   sqlstm.sqhstl[29] = (unsigned int  )14;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&d_chk_settlement_date;
   sqlstm.sqhstl[30] = (unsigned int  )14;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&d_hdr_settlement_perc;
   sqlstm.sqhstl[31] = (unsigned int  )8;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&d_hdr_cust_ref;
   sqlstm.sqhstl[32] = (unsigned int  )18;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&d_hdr_bill_doc_type_code;
   sqlstm.sqhstl[33] = (unsigned int  )9;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&d_hdr_bill_num;
   sqlstm.sqhstl[34] = (unsigned int  )11;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&d_hdr_bill_date;
   sqlstm.sqhstl[35] = (unsigned int  )15;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&d_chk_bill_date;
   sqlstm.sqhstl[36] = (unsigned int  )15;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&d_hdr_doctor_fee_amt;
   sqlstm.sqhstl[37] = (unsigned int  )18;
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&d_hdr_post_month;
   sqlstm.sqhstl[38] = (unsigned int  )5;
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&d_hdr_post_year;
   sqlstm.sqhstl[39] = (unsigned int  )7;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&d_hdr_misc_cust_long_name;
   sqlstm.sqhstl[40] = (unsigned int  )103;
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&d_hdr_misc_cust_short_name;
   sqlstm.sqhstl[41] = (unsigned int  )103;
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqhstv[42] = (         void  *)&d_hdr_misc_cust_add1_desc;
   sqlstm.sqhstl[42] = (unsigned int  )63;
   sqlstm.sqhsts[42] = (         int  )0;
   sqlstm.sqindv[42] = (         void  *)0;
   sqlstm.sqinds[42] = (         int  )0;
   sqlstm.sqharm[42] = (unsigned int  )0;
   sqlstm.sqadto[42] = (unsigned short )0;
   sqlstm.sqtdso[42] = (unsigned short )0;
   sqlstm.sqhstv[43] = (         void  *)&d_hdr_misc_cust_add2_desc;
   sqlstm.sqhstl[43] = (unsigned int  )63;
   sqlstm.sqhsts[43] = (         int  )0;
   sqlstm.sqindv[43] = (         void  *)0;
   sqlstm.sqinds[43] = (         int  )0;
   sqlstm.sqharm[43] = (unsigned int  )0;
   sqlstm.sqadto[43] = (unsigned short )0;
   sqlstm.sqtdso[43] = (unsigned short )0;
   sqlstm.sqhstv[44] = (         void  *)&d_hdr_misc_cust_add3_desc;
   sqlstm.sqhstl[44] = (unsigned int  )63;
   sqlstm.sqhsts[44] = (         int  )0;
   sqlstm.sqindv[44] = (         void  *)0;
   sqlstm.sqinds[44] = (         int  )0;
   sqlstm.sqharm[44] = (unsigned int  )0;
   sqlstm.sqadto[44] = (unsigned short )0;
   sqlstm.sqtdso[44] = (unsigned short )0;
   sqlstm.sqhstv[45] = (         void  *)&d_hdr_misc_cust_zip_desc;
   sqlstm.sqhstl[45] = (unsigned int  )33;
   sqlstm.sqhsts[45] = (         int  )0;
   sqlstm.sqindv[45] = (         void  *)0;
   sqlstm.sqinds[45] = (         int  )0;
   sqlstm.sqharm[45] = (unsigned int  )0;
   sqlstm.sqadto[45] = (unsigned short )0;
   sqlstm.sqtdso[45] = (unsigned short )0;
   sqlstm.sqhstv[46] = (         void  *)&d_hdr_cust_long_name_locl;
   sqlstm.sqhstl[46] = (unsigned int  )103;
   sqlstm.sqhsts[46] = (         int  )0;
   sqlstm.sqindv[46] = (         void  *)0;
   sqlstm.sqinds[46] = (         int  )0;
   sqlstm.sqharm[46] = (unsigned int  )0;
   sqlstm.sqadto[46] = (unsigned short )0;
   sqlstm.sqtdso[46] = (unsigned short )0;
   sqlstm.sqhstv[47] = (         void  *)&d_hdr_cust_short_name_locl;
   sqlstm.sqhstl[47] = (unsigned int  )103;
   sqlstm.sqhsts[47] = (         int  )0;
   sqlstm.sqindv[47] = (         void  *)0;
   sqlstm.sqinds[47] = (         int  )0;
   sqlstm.sqharm[47] = (unsigned int  )0;
   sqlstm.sqadto[47] = (unsigned short )0;
   sqlstm.sqtdso[47] = (unsigned short )0;
   sqlstm.sqhstv[48] = (         void  *)&d_hdr_cust_add1_desc_locl;
   sqlstm.sqhstl[48] = (unsigned int  )63;
   sqlstm.sqhsts[48] = (         int  )0;
   sqlstm.sqindv[48] = (         void  *)0;
   sqlstm.sqinds[48] = (         int  )0;
   sqlstm.sqharm[48] = (unsigned int  )0;
   sqlstm.sqadto[48] = (unsigned short )0;
   sqlstm.sqtdso[48] = (unsigned short )0;
   sqlstm.sqhstv[49] = (         void  *)&d_hdr_cust_add2_desc_locl;
   sqlstm.sqhstl[49] = (unsigned int  )63;
   sqlstm.sqhsts[49] = (         int  )0;
   sqlstm.sqindv[49] = (         void  *)0;
   sqlstm.sqinds[49] = (         int  )0;
   sqlstm.sqharm[49] = (unsigned int  )0;
   sqlstm.sqadto[49] = (unsigned short )0;
   sqlstm.sqtdso[49] = (unsigned short )0;
   sqlstm.sqhstv[50] = (         void  *)&d_hdr_cust_add3_desc_locl;
   sqlstm.sqhstl[50] = (unsigned int  )63;
   sqlstm.sqhsts[50] = (         int  )0;
   sqlstm.sqindv[50] = (         void  *)0;
   sqlstm.sqinds[50] = (         int  )0;
   sqlstm.sqharm[50] = (unsigned int  )0;
   sqlstm.sqadto[50] = (unsigned short )0;
   sqlstm.sqtdso[50] = (unsigned short )0;
   sqlstm.sqhstv[51] = (         void  *)&d_hdr_cust_zip_desc_locl;
   sqlstm.sqhstl[51] = (unsigned int  )33;
   sqlstm.sqhsts[51] = (         int  )0;
   sqlstm.sqindv[51] = (         void  *)0;
   sqlstm.sqinds[51] = (         int  )0;
   sqlstm.sqharm[51] = (unsigned int  )0;
   sqlstm.sqadto[51] = (unsigned short )0;
   sqlstm.sqtdso[51] = (unsigned short )0;
   sqlstm.sqhstv[52] = (         void  *)&d_hdr_tel_num;
   sqlstm.sqhstl[52] = (unsigned int  )33;
   sqlstm.sqhsts[52] = (         int  )0;
   sqlstm.sqindv[52] = (         void  *)0;
   sqlstm.sqinds[52] = (         int  )0;
   sqlstm.sqharm[52] = (unsigned int  )0;
   sqlstm.sqadto[52] = (unsigned short )0;
   sqlstm.sqtdso[52] = (unsigned short )0;
   sqlstm.sqhstv[53] = (         void  *)&d_hdr_contact_name;
   sqlstm.sqhstl[53] = (unsigned int  )103;
   sqlstm.sqhsts[53] = (         int  )0;
   sqlstm.sqindv[53] = (         void  *)0;
   sqlstm.sqinds[53] = (         int  )0;
   sqlstm.sqharm[53] = (unsigned int  )0;
   sqlstm.sqadto[53] = (unsigned short )0;
   sqlstm.sqtdso[53] = (unsigned short )0;
   sqlstm.sqhstv[54] = (         void  *)&d_hdr_contact_name_title;
   sqlstm.sqhstl[54] = (unsigned int  )63;
   sqlstm.sqhsts[54] = (         int  )0;
   sqlstm.sqindv[54] = (         void  *)0;
   sqlstm.sqinds[54] = (         int  )0;
   sqlstm.sqharm[54] = (unsigned int  )0;
   sqlstm.sqadto[54] = (unsigned short )0;
   sqlstm.sqtdso[54] = (unsigned short )0;
   sqlstm.sqhstv[55] = (         void  *)&d_hdr_error_flag;
   sqlstm.sqhstl[55] = (unsigned int  )4;
   sqlstm.sqhsts[55] = (         int  )0;
   sqlstm.sqindv[55] = (         void  *)0;
   sqlstm.sqinds[55] = (         int  )0;
   sqlstm.sqharm[55] = (unsigned int  )0;
   sqlstm.sqadto[55] = (unsigned short )0;
   sqlstm.sqtdso[55] = (unsigned short )0;
   sqlstm.sqhstv[56] = (         void  *)&d_consolidated_inv;
   sqlstm.sqhstl[56] = (unsigned int  )4;
   sqlstm.sqhsts[56] = (         int  )0;
   sqlstm.sqindv[56] = (         void  *)0;
   sqlstm.sqinds[56] = (         int  )0;
   sqlstm.sqharm[56] = (unsigned int  )0;
   sqlstm.sqadto[56] = (unsigned short )0;
   sqlstm.sqtdso[56] = (unsigned short )0;
   sqlstm.sqhstv[57] = (         void  *)&d_module_id;
   sqlstm.sqhstl[57] = (unsigned int  )5;
   sqlstm.sqhsts[57] = (         int  )0;
   sqlstm.sqindv[57] = (         void  *)0;
   sqlstm.sqinds[57] = (         int  )0;
   sqlstm.sqharm[57] = (unsigned int  )0;
   sqlstm.sqadto[57] = (unsigned short )0;
   sqlstm.sqtdso[57] = (unsigned short )0;
   sqlstm.sqhstv[58] = (         void  *)&d_pb_invoice_yn;
   sqlstm.sqhstl[58] = (unsigned int  )4;
   sqlstm.sqhsts[58] = (         int  )0;
   sqlstm.sqindv[58] = (         void  *)0;
   sqlstm.sqinds[58] = (         int  )0;
   sqlstm.sqharm[58] = (unsigned int  )0;
   sqlstm.sqadto[58] = (unsigned short )0;
   sqlstm.sqtdso[58] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




   if (OERROR)
         err_mesg("FETCH failed on cursor CUR_INV_REC",0,"");

   cust_code.arr[cust_code.len]             = '\0';
   pmnt_terms_code.arr[pmnt_terms_code.len] = '\0';
   billing_group.arr[billing_group.len]     =  '\0';
   patient_id.arr[patient_id.len]           =  '\0';
   d_chk_base_date.arr[d_chk_base_date.len] = '\0';
   d_chk_due_date.arr[d_chk_due_date.len]   = '\0';
   d_chk_settlement_date.arr[d_chk_settlement_date.len]   = '\0';
   d_chk_bill_date.arr[d_chk_bill_date.len] = '\0';

   rowid_hdr.arr[rowid_hdr.len]                           =  '\0';


   d_hdr_main_acc1_code.arr[d_hdr_main_acc1_code.len]             = '\0';
   d_hdr_main_acc2_code.arr[d_hdr_main_acc2_code.len]             = '\0';
   d_hdr_dept_code.arr[d_hdr_dept_code.len]                       = '\0';
   d_hdr_product_group_code.arr[d_hdr_product_group_code.len]     = '\0';
   d_hdr_product_line_code.arr[d_hdr_product_line_code.len]       = '\0';
   d_hdr_subledger_group_code.arr[d_hdr_subledger_group_code.len] = '\0';
   d_hdr_subledger_line_code.arr[d_hdr_subledger_line_code.len]   = '\0';

   d_hdr_post_month.arr[d_hdr_post_month.len]                     = '\0';
   d_hdr_post_year.arr[d_hdr_post_year.len]                       = '\0';
   doc_date.arr[doc_date.len]                                     = '\0';
   doc_date_chking.arr[doc_date_chking.len]                       = '\0';
   d_chk_payable_amt.arr[d_chk_payable_amt.len]                   = '\0';
   d_hdr_gross_amt.arr[d_hdr_gross_amt.len]                       = '\0';
   d_hdr_discount_amt.arr[d_hdr_discount_amt.len]                 = '\0';
   d_hdr_markup_amt.arr[d_hdr_markup_amt.len]                 = '\0';

d_hdr_acc_entity_code.arr[d_hdr_acc_entity_code.len] = '\0';
d_hdr_last_line_num.arr[d_hdr_last_line_num.len] = '\0';
d_hdr_narration.arr[d_hdr_narration.len] = '\0';
d_hdr_base_date.arr[d_hdr_base_date.len] = '\0';
d_chk_base_date.arr[d_chk_base_date.len] = '\0';
d_hdr_due_date.arr[d_hdr_due_date.len] = '\0';
d_chk_due_date.arr[d_chk_due_date.len] = '\0';
d_hdr_gross_amt.arr[d_hdr_gross_amt.len] = '\0';
d_hdr_discount_amt.arr[d_hdr_discount_amt.len] = '\0';
d_hdr_markup_amt.arr[d_hdr_markup_amt.len] = '\0';

d_hdr_currency_code.arr[d_hdr_currency_code.len] = '\0';
d_hdr_exchg_rate.arr[d_hdr_exchg_rate.len] = '\0';
d_hdr_settlement_date.arr[d_hdr_settlement_date.len] = '\0';
d_chk_settlement_date.arr[d_chk_settlement_date.len] = '\0';
d_hdr_settlement_perc.arr[d_hdr_settlement_perc.len] = '\0';
d_hdr_cust_ref.arr[d_hdr_cust_ref.len] = '\0';
d_hdr_bill_doc_type_code.arr[d_hdr_bill_doc_type_code.len] = '\0';
d_hdr_bill_num.arr[d_hdr_bill_num.len] = '\0';
d_hdr_bill_date.arr[d_hdr_bill_date.len] = '\0';
d_chk_bill_date.arr[d_chk_bill_date.len] = '\0';
d_hdr_doctor_fee_amt.arr[d_hdr_doctor_fee_amt.len] = '\0';
d_hdr_post_month.arr[d_hdr_post_month.len] = '\0';
d_hdr_post_year.arr[d_hdr_post_year.len] = '\0';
d_hdr_misc_cust_long_name.arr[d_hdr_misc_cust_long_name.len] = '\0';
d_hdr_misc_cust_short_name.arr[d_hdr_misc_cust_short_name.len] = '\0';
d_hdr_misc_cust_add1_desc.arr[d_hdr_misc_cust_add1_desc.len] = '\0';
d_hdr_misc_cust_add2_desc.arr[d_hdr_misc_cust_add2_desc.len] = '\0';
d_hdr_misc_cust_add3_desc.arr[d_hdr_misc_cust_add3_desc.len] = '\0';
d_hdr_misc_cust_zip_desc.arr[d_hdr_misc_cust_zip_desc.len] = '\0';
d_hdr_cust_long_name_locl.arr[d_hdr_cust_long_name_locl.len] = '\0';
d_hdr_cust_short_name_locl.arr[d_hdr_cust_short_name_locl.len] = '\0';
d_hdr_cust_add1_desc_locl.arr[d_hdr_cust_add1_desc_locl.len] = '\0';
d_hdr_cust_add2_desc_locl.arr[d_hdr_cust_add2_desc_locl.len] = '\0';
d_hdr_cust_add3_desc_locl.arr[d_hdr_cust_add3_desc_locl.len] = '\0';
d_hdr_cust_zip_desc_locl.arr[d_hdr_cust_zip_desc_locl.len] = '\0';

d_consolidated_inv.arr[d_consolidated_inv.len] = '\0';
d_module_id.arr[d_module_id.len] = '\0';
d_pb_invoice_yn.arr[d_pb_invoice_yn.len] = '\0';

d_hdr_tel_num.arr[d_hdr_tel_num.len] = '\0';
d_hdr_contact_name.arr[d_hdr_contact_name.len] = '\0';
d_hdr_contact_name_title.arr[d_hdr_contact_name_title.len] = '\0';
d_hdr_error_flag.arr[d_hdr_error_flag.len] = '\0';

   return(sqlca.sqlerrd[2]);
}

validate_inv_header()
{
   char chk1_arr[30],chk2_arr[30] , chk3_arr[30];

   
   strcpy(chk_doc_type_code.arr,doc_type_code.arr);
   chk_doc_type_code.len =  strlen(chk_doc_type_code.arr);

   /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0014;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )514;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&chk_doc_type_code;
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

   d_ar_acc_status.arr[0]     = '\0';
   d_ar_acc_valid_flag.arr[0] = '\0';
   d_bl_acc_valid_flag.arr[0] = '\0';
   sy_doc_print_flag.arr[0]   = '\0';

   d_ar_acc_valid_flag.len = 0;
   d_bl_acc_valid_flag.len = 0;
   d_ar_acc_status.len     = 0;
   sy_doc_print_flag.len   = 0;

   /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
             INTO :d_ar_acc_status,
                  :d_ar_acc_valid_flag,
				  :d_bl_acc_valid_flag,
                  :sy_doc_print_flag; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )533;
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
   sqlstm.sqhstv[2] = (         void  *)&d_bl_acc_valid_flag;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&sy_doc_print_flag;
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
        err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,""); 

   d_ar_acc_status.arr[d_ar_acc_status.len]         = '\0';
   d_ar_acc_valid_flag.arr[d_ar_acc_valid_flag.len] = '\0';
   d_bl_acc_valid_flag.arr[d_bl_acc_valid_flag.len] = '\0';
   sy_doc_print_flag.arr[sy_doc_print_flag.len]     = '\0';
   
   if (NOT_FOUND)
         error_insert("   0","SY1610");
   else
   { 
      if ((d_ar_acc_valid_flag.arr[0] != 'Y') && (d_bl_acc_valid_flag.arr[0] != 'Y'))
            error_insert("   0","SY1700");
      if (d_ar_acc_status.arr[0] == 'S')
            error_insert("   0","SY1640");

      if (nd_proc_flag.arr[0] == 'P') 
      {
          if (print_flag.arr[0] != 'Y' && sy_doc_print_flag.arr[0] == 'Y')
               error_insert("   0","SY2370");
      }
   } 

   /* EXEC SQL OPEN SY_DOC_TYPE_MAST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0015;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )564;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&chk_doc_type_code;
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
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )583;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&mast_status;
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
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0010;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )602;
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
   sqlstm.sqhstv[1] = (         void  *)&doc_type_code;
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
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )625;
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

   /* EXEC SQL OPEN SY_DOC_CONTROL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )644;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&doc_num;
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
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )667;
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
  
   /****   AR_CUSTOMER Validation   *****/
  
   /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )686;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&cust_code;
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
   d_last_inv_doc_date.arr[0]     = '\0';

   d_customer_status.len       = 0;
   d_customer_patient_flag.len = 0;
   d_last_inv_doc_date.len     = 0;

   /* EXEC SQL FETCH AR_CUSTOMER_CUR
             INTO :d_customer_status,
                  :d_customer_patient_flag,
                  :d_last_inv_doc_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )705;
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
   sqlstm.sqhstv[2] = (         void  *)&d_last_inv_doc_date;
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
   d_last_inv_doc_date.arr[d_last_inv_doc_date.len]         = '\0';

   if (OERROR)
        err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

   if (NOT_FOUND)
        error_insert("   0","AR1210");
   else
     if (d_customer_status.arr[0] == 'S')
        error_insert("   0","AR1220");

   /****   AR_PMNT_TERMS  Validation   *****/

   /* EXEC SQL OPEN AR_PMNT_TERMS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0013;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )732;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&pmnt_terms_code;
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
        err_mesg("OPEN failed on cursor AR_PMNT_TERMS_CUR",0,"");

   d_pmnt_terms_status.arr[0] = '\0';
   d_pmnt_terms_status.len    = 0;

   /* EXEC SQL FETCH AR_PMNT_TERMS_CUR
             INTO :d_pmnt_terms_status; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )751;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pmnt_terms_status;
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



   d_pmnt_terms_status.arr[d_pmnt_terms_status.len] = '\0';

   if (OERROR)
        err_mesg("FETCH failed on cursor AR_PMNT_TERMS_CUR",0,"");

   if (NOT_FOUND)
        error_insert("   0","AR1240");
   else
      if (d_pmnt_terms_status.arr[0] == 'S')
           error_insert("   0","AR1250");

   /****   PATIENT_MAST & BL_BLNG_GRP Validation    *****/

   if (d_customer_patient_flag.arr[0] == 'Y')
   {
      
	  if (bl_instal_flag > 0 && d_pb_invoice_yn.arr[0] == 'N' && strcmp(d_module_id.arr,"RL") != 0 && strcmp(d_module_id.arr,"SS") != 0 && strcmp(d_module_id.arr,"ST") != 0)
      {
          d_bl_blng_grp_status.arr[0] = '\0';
          d_bl_blng_grp_status.len    = 0;

          /* EXEC SQL SELECT NVL(STATUS,'X')
                     INTO :d_bl_blng_grp_status
                     FROM BL_BLNG_GRP
                    WHERE BLNG_GRP_ID  = :billing_group; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 59;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "select NVL(STATUS,'X') into :b0  from BL_BLNG_GRP w\
here BLNG_GRP_ID=:b1";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )770;
          sqlstm.selerr = (unsigned short)1;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&d_bl_blng_grp_status;
          sqlstm.sqhstl[0] = (unsigned int  )4;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&billing_group;
          sqlstm.sqhstl[1] = (unsigned int  )7;
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



          d_bl_blng_grp_status.arr[d_bl_blng_grp_status.len] = '\0';

          if (OERROR)
              err_mesg("SELECT failed on table BL_BLNG_GRP",0,"");

          if (NOT_FOUND)
             error_insert("   0","SY0110");
          else if (d_bl_blng_grp_status.arr[0] == 'S')
             error_insert("   0","BL0026");

      }
      /*
      if (mp_instal_flag > 0) 
      {
          EXEC SQL SELECT 'X'
                     INTO :dummy
                     FROM MP_PATIENT_MAST
                    WHERE PATIENT_ID  = :patient_id;

          if (OERROR)
             err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");
          if (NOT_FOUND)
             error_insert("   0","SY2021");
      }
      */
   }

   validate_posting("   0",0);

      if (atoi(d_hdr_post_month.arr) > atoi(d_sy_num_acc_per.arr))
             error_insert("   0","GL2290");

      if (atoi(d_hdr_post_year.arr) < atoi(curr_acc_year.arr))
             error_insert("   0","GL1595");

      if ( (atoi(d_hdr_post_year.arr) == atoi(curr_acc_year.arr) && 
              atoi(d_hdr_post_month.arr) < atoi(curr_acc_month.arr)) &&
               prior_post_allow.arr[0] != 'Y' )
                  error_insert("   0","GL1310");

      if (atol(d_chk_base_date.arr) <  atol(doc_date_chking.arr))
                  error_insert("   0","AR1090");

      if (atol(d_chk_due_date.arr) <  atol(d_chk_base_date.arr))
                  error_insert("   0","AR1100");

      if (d_chk_settlement_date.len != 0)
      {
          if (atol(d_chk_settlement_date.arr) < atol(d_chk_base_date.arr) ||
              atol(d_chk_settlement_date.arr) > atol(d_chk_due_date.arr))
                  error_insert("   0","AR1110");

          if (d_hdr_settlement_perc.len == 0)
                  error_insert("   0","AR1130");
      }
      else if (d_hdr_settlement_perc.len != 0)
              error_insert("   0","AR1120");

      /*Commented on 19/Jul/2004 as per request from BL Team 
      if (atof(d_hdr_gross_amt.arr) <= 0)
                error_insert("   0","AR1140");
      */
  
      if (nd_no_of_decimal == 3)
	     {
			  sprintf(chk1_arr,"%15.3f",atof(d_hdr_discount_amt.arr));
			  sprintf(chk3_arr,"%15.3f",atof(d_hdr_markup_amt.arr));
			  sprintf(chk2_arr,"%15.3f",atof(d_hdr_gross_amt.arr) + atof(d_hdr_markup_amt.arr) - payable_amt);
          }
	  else
	     {
			  sprintf(chk1_arr,"%15.2f",atof(d_hdr_discount_amt.arr));
			  sprintf(chk3_arr,"%15.2f",atof(d_hdr_markup_amt.arr));
			  sprintf(chk2_arr,"%15.2f",atof(d_hdr_gross_amt.arr) + atof(d_hdr_markup_amt.arr) - payable_amt);
          }
/*
      ltrim(chk1_arr); 
      ltrim(chk2_arr);
	  ltrim(chk3_arr);
*/
      format_amt(chk1_arr,nd_no_of_decimal);
	  format_amt(chk2_arr,nd_no_of_decimal);
	  format_amt(chk3_arr,nd_no_of_decimal);
/*
	  if (strcmp(chk1_arr,"-0.00") == 0)
         strcpy(chk1_arr,"0.00");
      if (strcmp(chk2_arr,"-0.00") == 0)
         strcpy(chk2_arr,"0.00");
*/
      if (strcmp(chk1_arr,chk2_arr))
      {
           error_insert("   0","AR1160");
      }

      if (d_customer_patient_flag.arr[0] == 'Y' && d_pb_invoice_yn.arr[0] == 'N' && strcmp(d_module_id.arr,"RL") != 0 && strcmp(d_module_id.arr,"SS") != 0 && strcmp(d_module_id.arr,"ST") != 0)
      {
          if (atol(d_chk_bill_date.arr) > atol(doc_date_chking.arr))
                error_insert("   0","AR1170");

          if (atof(d_hdr_doctor_fee_amt.arr) > payable_amt)
                error_insert("   0","AR1180");

          strcpy(chk_doc_type_code.arr,d_hdr_bill_doc_type_code.arr);
          chk_doc_type_code.len =  strlen(chk_doc_type_code.arr);

          /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 59;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = sq0014;
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )793;
          sqlstm.selerr = (unsigned short)1;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&chk_doc_type_code;
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
               err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR - 2",
                         0,"");

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
          sqlstm.arrsiz = 59;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )812;
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
               err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR - 2",
                          0,""); 
          d_ar_acc_status.arr[d_ar_acc_status.len]         = '\0';
          d_ar_acc_valid_flag.arr[d_ar_acc_valid_flag.len] = '\0';
          sy_doc_print_flag.arr[sy_doc_print_flag.len]     = '\0';
   
          if (NOT_FOUND)
                error_insert_null("   0","SY1610","(BILL DOC TYPE)");
          else
          {
             if (d_ar_acc_status.arr[0] == 'S')
                   error_insert_null("   0","SY1640","(BILL DOC TYPE)");
          } 
      }

  
	  
     if (doc_date.len == 0)
            error_insert_null("   0","SY1470","Field = DOC DATE");
     if (cust_code.len == 0)
            error_insert_null("   0","SY1470","Field = CUST CODE");
     if (pmnt_terms_code.len == 0)
            error_insert_null("   0","SY1470","Field = PAY TERMS");
     if (d_chk_base_date.len == 0)
            error_insert_null("   0","SY1470","Field = BASE DATE");
     if (d_chk_due_date.len == 0)
            error_insert_null("   0","SY1470","Field = DUE DATE");
     if (d_hdr_gross_amt.len == 0)
            error_insert_null("   0","SY1470","Field = GROSS AMT");
     if (d_chk_payable_amt.len == 0)
            error_insert_null("   0","SY1470","Field = PAYABLE AMT");

     if (billing_group.len == 0 && d_customer_patient_flag.arr[0] == 'Y' && d_pb_invoice_yn.arr[0] == 'N' && strcmp(d_module_id.arr,"RL") != 0 && strcmp(d_module_id.arr,"SS") != 0 && strcmp(d_module_id.arr,"ST") != 0)
            error_insert_null("   0","SY1470","Field = BILLING GROUP");
     if (d_hdr_bill_doc_type_code.len == 0 && d_customer_patient_flag.arr[0] == 'Y' && d_pb_invoice_yn.arr[0] == 'N' && strcmp(d_module_id.arr,"RL") != 0 && strcmp(d_module_id.arr,"SS") != 0 && strcmp(d_module_id.arr,"ST") != 0)
            error_insert_null("   0","SY1470","Field = BILL DOC TYPE");
     if (d_hdr_bill_num.len == 0 && d_customer_patient_flag.arr[0] == 'Y' && d_pb_invoice_yn.arr[0] == 'N' && strcmp(d_module_id.arr,"RL") != 0 && strcmp(d_module_id.arr,"SS") != 0 && strcmp(d_module_id.arr,"ST") != 0)
            error_insert_null("   0","SY1470","Field = BILL NUM");
     if (d_hdr_bill_date.len == 0 && d_customer_patient_flag.arr[0] == 'Y' && d_pb_invoice_yn.arr[0] == 'N' && strcmp(d_module_id.arr,"RL") != 0 && strcmp(d_module_id.arr,"SS") != 0 && strcmp(d_module_id.arr,"ST") != 0)
            error_insert_null("   0","SY1470","Field = BILL DATE");
  
     if (patient_id.len == 0 && d_customer_patient_flag.arr[0] == 'Y' && d_pb_invoice_yn.arr[0] == 'N' && strcmp(d_module_id.arr,"RL") != 0 && strcmp(d_module_id.arr,"SS") != 0 && strcmp(d_module_id.arr,"ST") != 0)
            error_insert_null("   0","SY1470","Field = PATIENT NO");

     if (d_hdr_post_month.len == 0)
            error_insert_null("   0","SY1470","Field = POST MONTH");
     if (d_hdr_post_year.len == 0)
            error_insert_null("   0","SY1470","Field = POST YEAR");

/*  Commented since validate_posting_acct is doing this validation */

/*      check_bank_reconcile("   0",0); */

}  

open_patient_dtls()
{
   /* EXEC SQL OPEN AR_PATIENT_DTLS_CUR USING :nd_facility_id,:doc_type_code,:doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )839;
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
   sqlstm.sqhstv[1] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&doc_num;
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
     sqlstm.arrsiz = 59;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )866;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     return (0);
   }
   else if (OERROR)
        err_mesg("OPEN failed on cursor AR_PATIENT_DTLS_CUR",0,"");

   return (1);
}

fetch_patient_dtls()
{
ar_pat_doc_type_code.arr[0]       = '\0';
ar_pat_doc_num.arr[0]             = '\0';
ar_pat_patient_id.arr[0]          = '\0';
ar_pat_bill_doc_type_code.arr[0]  = '\0';
ar_pat_bill_num.arr[0]            = '\0';
ar_pat_bill_date.arr[0]           = '\0';
ar_pat_remarks.arr[0]             = '\0';
ar_pat_rowid.arr[0]               = '\0';

ar_pat_doc_type_code.len          = 0;
ar_pat_doc_num.len                = 0;
ar_pat_patient_id.len             = 0;
ar_pat_bill_doc_type_code.len     = 0;
ar_pat_bill_num.len               = 0;
ar_pat_bill_date.len              = 0;
ar_pat_remarks.len                = 0;
ar_pat_rowid.len                  = 0;

ar_pat_amount                     = 0;

   /* EXEC SQL FETCH AR_PATIENT_DTLS_CUR
             INTO :ar_pat_doc_type_code,
                  :ar_pat_doc_num,
                  :ar_pat_patient_id,
                  :ar_pat_bill_doc_type_code,
                  :ar_pat_bill_num,
                  :ar_pat_bill_date,
                  :ar_pat_remarks,
                  :ar_pat_amount,
                  :ar_pat_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )881;
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
   sqlstm.sqhstv[3] = (         void  *)&ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_pat_bill_num;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ar_pat_bill_date;
   sqlstm.sqhstl[5] = (unsigned int  )14;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ar_pat_remarks;
   sqlstm.sqhstl[6] = (unsigned int  )18;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ar_pat_amount;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&ar_pat_rowid;
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
       err_mesg("FETCH failed on cursor AR_PATIENT_DTLS_CUR",0,"");

ar_pat_doc_type_code.arr[ar_pat_doc_type_code.len]           = '\0';
ar_pat_doc_num.arr[ar_pat_doc_num.len]                       = '\0';
ar_pat_patient_id.arr[ar_pat_patient_id.len]                 = '\0';
ar_pat_bill_doc_type_code.arr[ar_pat_bill_doc_type_code.len] = '\0';
ar_pat_bill_num.arr[ar_pat_bill_num.len]                     = '\0';
ar_pat_bill_date.arr[ar_pat_bill_date.len]                   = '\0';
ar_pat_remarks.arr[ar_pat_remarks.len]                       = '\0';
ar_pat_rowid.arr[ar_pat_rowid.len]                           = '\0';

   if (LAST_ROW)
       return (0);
   else 
       return (1);
}

validate_patient_dtls()
{
   if (ar_pat_patient_id.len == 0)
         error_insert_null("   1","SY1470","Field = PATIENT NO ");
   else if (mp_instal_flag > 0)
   {
        /* EXEC SQL SELECT 'X'
                   INTO :dummy
                   FROM MP_PATIENT_MAST
                  WHERE PATIENT_ID  = :ar_pat_patient_id; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 59;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select 'X' into :b0  from MP_PATIENT_MAST where PATIE\
NT_ID=:b1";
        sqlstm.iters = (unsigned int  )10;
        sqlstm.offset = (unsigned int  )932;
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
        sqlstm.sqhstv[1] = (         void  *)&ar_pat_patient_id;
        sqlstm.sqhstl[1] = (unsigned int  )23;
        sqlstm.sqhsts[1] = (         int  )23;
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
             err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

         if (NOT_FOUND)
            error_insert_null("   1","SY2021","");
   }

   if (ar_pat_bill_doc_type_code.len == 0)
         error_insert_null("   1","SY1470","Field = BILL DOC TYPE ");
   else
   {
         strcpy(chk_doc_type_code.arr,ar_pat_bill_doc_type_code.arr);
         chk_doc_type_code.len = strlen(chk_doc_type_code.arr);

         /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 59;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = sq0014;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )955;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&chk_doc_type_code;
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
             err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR - 3",0,"");

         d_ar_acc_status.arr[0]     = '\0';
         d_ar_acc_valid_flag.arr[0] = '\0';
         sy_doc_print_flag.arr[0]   = '\0';

         d_ar_acc_valid_flag.len    = 0;
         d_ar_acc_status.len        = 0;
         sy_doc_print_flag.len      = 0;

         /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
                   INTO :d_ar_acc_status,
                        :d_ar_acc_valid_flag,
                        :sy_doc_print_flag; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 59;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )974;
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
             err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR - 3",0,""); 
         d_ar_acc_status.arr[d_ar_acc_status.len]         = '\0';
         d_ar_acc_valid_flag.arr[d_ar_acc_valid_flag.len] = '\0';

         if (NOT_FOUND)
               error_insert_null("   1","SY1610","");
         else if (d_ar_acc_status.arr[0] == 'S')
                    error_insert_null("   1","SY1640","");
      }

      if (atol(ar_pat_bill_date.arr) > atol(doc_date_chking.arr))
            error_insert_null("   1","AR1170","");

      if (ar_pat_bill_num.len == 0)
            error_insert_null("   1","SY1470","Field = BILL NUM ");
      if (ar_pat_bill_date.len == 0)
            error_insert_null("   1","SY1470","Field = BILL DATE ");
      //if (ar_pat_remarks.len == 0)
      //      error_insert_null("   1","SY1470","Field = REMARKS ");
      if (ar_pat_amount == 0)
            error_insert_null("   1","SY1470","Field = AMOUNT ");

  ar_pat_tot_amt += ar_pat_amount;

}

update_pat_dtls()
{
    /* EXEC SQL UPDATE AR_PATIENT_DTLS
                SET LINE_NUM = :ar_pat_line_num
              WHERE ROWID    = :ar_pat_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 59;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_PATIENT_DTLS  set LINE_NUM=:b0 where ROWID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1001;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&ar_pat_line_num;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&ar_pat_rowid;
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
         err_mesg("UPDATE failed on table AR_PATIENT_DTLS",0,"");

    ar_pat_line_num ++;

}

validate_posting(loc_line_num,ind)
char loc_line_num[];
int ind;
{

  if (ind == 0)
  {
    strcpy(d_module_valid_id.arr , "AR");
      if(validate_posting_acct( d_hdr_main_acc1_code.arr,
                                d_hdr_main_acc2_code.arr,
                                d_hdr_dept_code.arr,
                                d_hdr_product_group_code.arr,
                                d_hdr_product_line_code.arr,
                                d_hdr_subledger_group_code.arr,
                                d_hdr_subledger_line_code.arr,
                                'Y',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
                                atol(d_hdr_post_year.arr),
								atol(d_hdr_post_month.arr),
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
	   
      if(validate_posting_acct( d_main_acc1_code.arr,
                                d_main_acc2_code.arr,
                                d_dept_code.arr,
                                d_product_group_code.arr,
                                d_product_line_code.arr,
                                d_subledger_group_code.arr,
                                d_subledger_line_code.arr,
                                'Y',   /* For chking Bank Reconcile */
								d_module_valid_id.arr,
                                atol(d_hdr_post_year.arr),
								atol(d_hdr_post_month.arr),
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

validate_inv_line()
{
  

   /* EXEC SQL OPEN CUR_INV_LINE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1024;
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
   sqlstm.sqhstv[1] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&doc_num;
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
        sqlstm.arrsiz = 59;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1051;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        return (0);
   }
   else if (OERROR)
         err_mesg("OPEN failed on cursor AR_INV_LINE",0,"");

   while (1)
   {
      amt_local = 0;
      line_num.arr[0] = '\0';
      line_num.len    = 0;

      d_main_acc1_code.arr[0]       = '\0';
      d_main_acc2_code.arr[0]       = '\0';
      d_dept_code.arr[0]            = '\0';
      d_product_group_code.arr[0]   = '\0';
      d_product_line_code.arr[0]    = '\0';
      d_subledger_group_code.arr[0] = '\0';
      d_subledger_line_code.arr[0]  = '\0';
      d_chk_amt_local.arr[0]        = '\0';

      d_main_acc1_code.len       = 0;
      d_main_acc2_code.len       = 0;
      d_dept_code.len            = 0;
      d_product_group_code.len   = 0;
      d_product_line_code.len    = 0;
      d_subledger_group_code.len = 0;
      d_subledger_line_code.len  = 0;
      d_chk_amt_local.len        = 0;

      /* EXEC SQL FETCH CUR_INV_LINE
                INTO :amt_local, :line_num,
                     :d_main_acc1_code,
                     :d_main_acc2_code,
                     :d_dept_code,
                     :d_product_group_code,
                     :d_product_line_code,
                     :d_subledger_group_code,
                     :d_subledger_line_code,
                     :d_chk_amt_local; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 59;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1066;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&amt_local;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&line_num;
      sqlstm.sqhstl[1] = (unsigned int  )7;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_main_acc1_code;
      sqlstm.sqhstl[2] = (unsigned int  )10;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_main_acc2_code;
      sqlstm.sqhstl[3] = (unsigned int  )10;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_dept_code;
      sqlstm.sqhstl[4] = (unsigned int  )17;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_product_group_code;
      sqlstm.sqhstl[5] = (unsigned int  )6;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_product_line_code;
      sqlstm.sqhstl[6] = (unsigned int  )10;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_subledger_group_code;
      sqlstm.sqhstl[7] = (unsigned int  )6;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_subledger_line_code;
      sqlstm.sqhstl[8] = (unsigned int  )14;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&d_chk_amt_local;
      sqlstm.sqhstl[9] = (unsigned int  )21;
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
         err_mesg("FETCH failed on cursor CUR_INV_LINE",0,"");

      line_num.arr[line_num.len] = '\0';

      d_main_acc1_code.arr[d_main_acc1_code.len]             = '\0';
      d_main_acc2_code.arr[d_main_acc2_code.len]             = '\0';
      d_dept_code.arr[d_dept_code.len]                       = '\0';
      d_product_group_code.arr[d_product_group_code.len]     = '\0';
      d_product_line_code.arr[d_product_line_code.len]       = '\0';
      d_subledger_group_code.arr[d_subledger_group_code.len] = '\0';
      d_subledger_line_code.arr[d_subledger_line_code.len]   = '\0';
      d_chk_amt_local.arr[d_chk_amt_local.len]               = '\0';

      if (LAST_ROW) break;

      nd_dtl_tot_amt += amt_local;

      if (amt_local < 0)
         nd_dtl_tot_deb_amt -= amt_local; 

/****           deb_amt = deb_amt + abs(loc_amt)                      ****/

      validate_posting(line_num.arr,1);

/*  Commented since validate_posting_acct is doing this validation */

/*      check_bank_reconcile(line_num.arr,1); */

     if (d_chk_amt_local.len == 0)
            error_insert_null(line_num.arr,"SY1470","Field = AMOUNT");
   }
   return (1);
}

validate_inv_amt()  
{
   char l_ch_dtl_amt[20],l_ch_payable_amt[20];
   double l_diff_amts = 0;
    if (nd_no_of_decimal == 3)
      {
		sprintf(l_ch_dtl_amt,"%15.3f",nd_dtl_tot_amt);
		sprintf(l_ch_payable_amt,"%15.3f",payable_amt);
      }
	else
      {
		sprintf(l_ch_dtl_amt,"%15.2f",nd_dtl_tot_amt);
		sprintf(l_ch_payable_amt,"%15.2f",payable_amt);
      }
/*
    ltrim(l_ch_dtl_amt); 
    ltrim(l_ch_payable_amt);
 
     
  if (strcmp(l_ch_dtl_amt,"-0.00") == 0)
     strcpy(l_ch_dtl_amt,"0.00");
  if (strcmp(l_ch_payable_amt,"-0.00") == 0)
     strcpy(l_ch_payable_amt,"0.00");
*/
    format_amt(l_ch_dtl_amt,nd_no_of_decimal);
	format_amt(l_ch_payable_amt,nd_no_of_decimal);   

    if (strcmp(l_ch_dtl_amt,l_ch_payable_amt) != 0) 
    {
          error_insert("   0","AR1200");
    }
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
           :doc_type_code,
           0,
           :doc_num,
           TO_DATE(:doc_date,'DD/MM/YYYY'),
           SUBSTR(:d_hdr_cust_ref,1,10),
           :d_hdr_narration,
           :d_hdr_post_month,
           :d_hdr_post_year,
           NVL(:payable_amt,0) + NVL(:nd_dtl_tot_deb_amt,0),
           NULL,
           NULL,
           NULL,
           NULL,
           NULL,
           USER,
           USER,
           SYSDATE,
           SYSDATE,
           :d_hdr_last_line_num,
           'AR',
           NULL,
           NULL,
           NULL ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into GL_TXN_DOC_HDR (ACC_ENTITY_CODE,DOC_TYPE_CODE,\
BATCH_NUM,DOC_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT,DOC\
_NATURE,UNIT_TYPE_CODE,CURRENCY_CODE,EXCHG_RATE,ERROR_FLAG,ADDED_BY_ID,MODIFIE\
D_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID,TXN_TYPE_DESC,STD_JV_R\
EF,PRINT_FLAG) values (:b0,:b1,0,:b2,TO_DATE(:b3,'DD/MM/YYYY'),SUBSTR(:b4,1,10\
),:b5,:b6,:b7,(NVL(:b8,0)+NVL(:b9,0)),null ,null ,null ,null ,null ,USER,USER,\
SYSDATE,SYSDATE,:b10,'AR',null ,null ,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1121;
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
   sqlstm.sqhstv[1] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_hdr_cust_ref;
   sqlstm.sqhstl[4] = (unsigned int  )18;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_hdr_narration;
   sqlstm.sqhstl[5] = (unsigned int  )53;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_hdr_post_month;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_hdr_post_year;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&payable_amt;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_dtl_tot_deb_amt;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_hdr_last_line_num;
   sqlstm.sqhstl[10] = (unsigned int  )7;
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
           0,
           :doc_type_code,
           :doc_num,
           :d_hdr_main_acc1_code,
           :d_hdr_main_acc2_code,
           :d_hdr_subledger_group_code,
           :d_hdr_subledger_line_code,
           :d_hdr_dept_code,
           :d_hdr_product_group_code,
           :d_hdr_product_line_code,
           NULL,
           :payable_amt,
           :d_hdr_narration,
           0,
           NULL,
		   :cust_code
         ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 59;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,null ,:b10,:b11,0,null ,:b12)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1180;
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
  sqlstm.sqhstv[1] = (         void  *)&doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_hdr_main_acc1_code;
  sqlstm.sqhstl[3] = (unsigned int  )10;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_hdr_main_acc2_code;
  sqlstm.sqhstl[4] = (unsigned int  )10;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_hdr_subledger_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_hdr_subledger_line_code;
  sqlstm.sqhstl[6] = (unsigned int  )14;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_hdr_dept_code;
  sqlstm.sqhstl[7] = (unsigned int  )17;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_hdr_product_group_code;
  sqlstm.sqhstl[8] = (unsigned int  )6;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_hdr_product_line_code;
  sqlstm.sqhstl[9] = (unsigned int  )10;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&payable_amt;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_hdr_narration;
  sqlstm.sqhstl[11] = (unsigned int  )53;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&cust_code;
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
         SELECT
           :nd_acc_entity_code,
           0,
           a.DOC_TYPE_CODE,
           a.DOC_NUM,
           a.MAIN_ACC1_CODE,
           a.MAIN_ACC2_CODE,
           a.SUBLEDGER_GROUP_CODE,
           a.SUBLEDGER_LINE_CODE,
           a.DEPT_CODE,
           a.PRODUCT_GROUP_CODE,
           a.PRODUCT_LINE_CODE,
           NULL,
           a.AMT_LOCAL * -1,
           a.NARRATION,
           a.LINE_NUM,
           NULL ,
		   :cust_code
     FROM  AR_INV_LINE a,AR_INV_HDR b
    WHERE  b.OPERATING_FACILITY_ID=:nd_facility_id
	and a.doc_type_code=b.doc_type_code
	and a.doc_num=b.doc_num
	  AND  a.DOC_TYPE_CODE = :doc_type_code
      AND  a.DOC_NUM       = :doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 59;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY,CUST_SUPP_CODE)select :b0 ,0 ,a.DOC_TYPE\
_CODE ,a.DOC_NUM ,a.MAIN_ACC1_CODE ,a.MAIN_ACC2_CODE ,a.SUBLEDGER_GROUP_CODE ,\
a.SUBLEDGER_LINE_CODE ,a.DEPT_CODE ,a.PRODUCT_GROUP_CODE ,a.PRODUCT_LINE_CODE \
,null  ,(a.AMT_LOCAL* (-1)) ,a.NARRATION ,a.LINE_NUM ,null  ,:b1  from AR_INV_\
LINE a ,AR_INV_HDR b where ((((b.OPERATING_FACILITY_ID=:b2 and a.doc_type_code\
=b.doc_type_code) and a.doc_num=b.doc_num) and a.DOC_TYPE_CODE=:b3) and a.DOC_\
NUM=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1247;
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
  sqlstm.sqhstv[1] = (         void  *)&cust_code;
  sqlstm.sqhstl[1] = (unsigned int  )11;
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
  sqlstm.sqhstv[3] = (         void  *)&doc_type_code;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&doc_num;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_LINE - for line",0,"");    

}

gl_posting()    
{
 char r_err_msg[100];

 if (post_doc((long)0,doc_type_code.arr,atol(doc_num.arr),r_err_msg) == -1)
        err_mesg(r_err_msg,0,""); 		

   return (0);
}

insert_ar_patient_dtls()
{
   if (strcmp(d_pb_invoice_yn.arr,"Y") == 0)
   {
   /* EXEC SQL INSERT INTO AR_PATIENT_DTLS 
             ( OPERATING_FACILITY_ID,
			  DOC_TYPE_CODE,  
              DOC_NUM,
              PATIENT_ID,
              PATIENT_NAME,
              BILL_DOC_TYPE_CODE,
              BILL_NUM,
              BILL_DATE,  
              BILLING_GROUP,  
              AMOUNT,
              PEND_AMOUNT,
              LINE_NUM
             )
            SELECT A.OPERATING_FACILITY_ID,
              A.AR_INVOICE_DOC_TYPE_CODE, 
              A.AR_INVOICE_DOC_NUM,
              A.PATIENT_ID,
              SUBSTR(B.SHORT_NAME,1,30),
              A.DOC_TYPE_CODE,
              A.DOC_NUM,
              A.DOC_DATE,
              A.BILLING_GROUP,
              A.DOC_AMT,
              A.DOC_AMT,
              ROWNUM
            FROM AR_PAT_BILLS_TEMP A, MP_PATIENT_MAST B
           WHERE A.OPERATING_FACILITY_ID=:nd_facility_id
		     and A.PATIENT_ID                = B.PATIENT_ID
             AND A.AR_INVOICE_DOC_TYPE_CODE  = :doc_type_code
             AND A.AR_INVOICE_DOC_NUM        = :doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_PATIENT_DTLS (OPERATING_FACILITY_ID,DOC_TYP\
E_CODE,DOC_NUM,PATIENT_ID,PATIENT_NAME,BILL_DOC_TYPE_CODE,BILL_NUM,BILL_DATE,B\
ILLING_GROUP,AMOUNT,PEND_AMOUNT,LINE_NUM)select A.OPERATING_FACILITY_ID ,A.AR_\
INVOICE_DOC_TYPE_CODE ,A.AR_INVOICE_DOC_NUM ,A.PATIENT_ID ,SUBSTR(B.SHORT_NAME\
,1,30) ,A.DOC_TYPE_CODE ,A.DOC_NUM ,A.DOC_DATE ,A.BILLING_GROUP ,A.DOC_AMT ,A.\
DOC_AMT ,ROWNUM  from AR_PAT_BILLS_TEMP A ,MP_PATIENT_MAST B where (((A.OPERAT\
ING_FACILITY_ID=:b0 and A.PATIENT_ID=B.PATIENT_ID) and A.AR_INVOICE_DOC_TYPE_C\
ODE=:b1) and A.AR_INVOICE_DOC_NUM=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1282;
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
   sqlstm.sqhstv[1] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&doc_num;
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
         err_mesg("INSERT failed on table AR_PATIENT_DTLS",0,"");
   }

}



delete_gl_recs()
{
 /* EXEC SQL DELETE FROM GL_TXN_DOC_HDR 
                WHERE DOC_TYPE_CODE = :doc_type_code
                  AND DOC_NUM       = :doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 59;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from GL_TXN_DOC_HDR  where (DOC_TYPE_CODE=:b0 and DO\
C_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1309;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&doc_num;
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
                WHERE DOC_TYPE_CODE = :doc_type_code
                  AND DOC_NUM       = :doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 59;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from GL_TXN_DOC_LINE  where (DOC_TYPE_CODE=:b0 and D\
OC_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1332;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&doc_num;
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


   varchar l_ch_payable_amt[25],
        l_ch_tot_amt[25];

   if (strcmp(line_no,"   0"))
     sprintf(ar_line_no.arr,"%4d",atoi(line_no) + 10);
   else
     strcpy(ar_line_no.arr,line_no);

   ar_line_no.len = strlen(ar_line_no.arr);

   strcpy(ar_err_code.arr,msg_id);
   ar_err_code.len = strlen(ar_err_code.arr);

   l_ar_doc_error_text.len = 0;
   l_ar_doc_error_text.arr[0] = '\0';
 
   /* EXEC SQL SELECT MESSAGE_TEXT 
            INTO   :l_ar_doc_error_text
			FROM   MESSAGE 
			WHERE  MESSAGE_ID = :ar_err_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select MESSAGE_TEXT into :b0  from MESSAGE where MESSAGE_I\
D=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1355;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_doc_error_text;
   sqlstm.sqhstl[0] = (unsigned int  )73;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_err_code;
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


 
      
   if (strcmp(ar_err_code.arr,"AR1200") == 0)
   {
    
	   if (nd_no_of_decimal == 3) 
	     {
		   sprintf(l_ch_payable_amt,"%19.3f",payable_amt);
		   sprintf(l_ch_tot_amt,"%19.3f",nd_dtl_tot_amt);
         }
       else 
	     {
		   sprintf(l_ch_payable_amt,"%19.2f",payable_amt);
		   sprintf(l_ch_tot_amt,"%19.2f",nd_dtl_tot_amt);
         }
  
/* 
       ltrim(l_ch_payable_amt);
       ltrim(l_ch_tot_amt);
*/ 
       format_amt(l_ch_payable_amt,nd_no_of_decimal);
	   format_amt(l_ch_tot_amt,nd_no_of_decimal);

	
       sprintf(l_ar_doc_error_text.arr,"Doc Amt = %s   Sum of Line Amt = %s ",
                   l_ch_payable_amt,l_ch_tot_amt);
       l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);
   } 
   l_ar_doc_error_text.arr[l_ar_doc_error_text.len] = '\0';
 
   /* EXEC SQL INSERT INTO AR_DOC_ERROR
                   (OPERATING_FACILITY_ID,PGM_ID,
                    DOC_TYPE_CODE,    DOC_NUM,
                    LINE_NUM,         ERROR_CODE,
                    ERROR_TEXT)
            VALUES (:nd_facility_id,:d_curr_pgm_name,:doc_type_code,   :doc_num,
                    :ar_line_no,      :ar_err_code,
                    :l_ar_doc_error_text); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (OPERATING_FACILITY_ID,PGM_ID,DOC\
_TYPE_CODE,DOC_NUM,LINE_NUM,ERROR_CODE,ERROR_TEXT) values (:b0,:b1,:b2,:b3,:b4\
,:b5,:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1378;
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
   sqlstm.sqhstv[1] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_line_no;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ar_err_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_ar_doc_error_text;
   sqlstm.sqhstl[6] = (unsigned int  )73;
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


   char l_ch_payable_amt[25],
        l_ch_tot_amt[25];

   if (strcmp(line_no,"   0") != 0 && strcmp(line_no,"   1") != 0)
     sprintf(ar_line_no.arr,"%4d",atoi(line_no) + 10);
   else
     strcpy(ar_line_no.arr,line_no);

   ar_line_no.len = strlen(ar_line_no.arr);

   strcpy(ar_err_code.arr,msg_id);
   ar_err_code.len = strlen(ar_err_code.arr);

   l_ar_doc_error_text.len = 0;
   l_ar_doc_error_text.arr[0] = '\0';


   if (strcmp(ar_err_code.arr,"AR2180") == 0)
   {
       if (nd_no_of_decimal == 3)
	     {
		   sprintf(l_ch_payable_amt,"%19.3f",payable_amt);
		   sprintf(l_ch_tot_amt,"%19.3f",ar_pat_tot_amt);
         }
        else
	     {
		   sprintf(l_ch_payable_amt,"%19.2f",payable_amt);
		   sprintf(l_ch_tot_amt,"%19.2f",ar_pat_tot_amt);
         }
/*
       ltrim(l_ch_payable_amt);
       ltrim(l_ch_tot_amt);
*/
   	   format_amt(l_ch_payable_amt,nd_no_of_decimal);
	   format_amt(l_ch_tot_amt,nd_no_of_decimal);

       sprintf(l_ar_doc_error_text.arr,
              "Doc Amt = %s Sum of Patient Line Amt = %s ",
                   l_ch_payable_amt,l_ch_tot_amt);
   }
   else if (strcmp(line_no,"   1") == 0)
   {
       sprintf(l_ar_doc_error_text.arr,"%sin PATIENT DTLS Line %d ",msg_txt,
                         ar_pat_line_num);
   }
   else 
   {
       strcpy(l_ar_doc_error_text.arr,msg_txt);
   }

   l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);

   /* EXEC SQL INSERT INTO AR_DOC_ERROR
                   (OPERATING_FACILITY_ID,PGM_ID,
                    DOC_TYPE_CODE,    DOC_NUM,
                    LINE_NUM,         ERROR_CODE,
                    ERROR_TEXT)
            VALUES (:nd_facility_id,:d_curr_pgm_name,:doc_type_code,   :doc_num,
                    :ar_line_no,      :ar_err_code,
                    :l_ar_doc_error_text); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (OPERATING_FACILITY_ID,PGM_ID,DOC\
_TYPE_CODE,DOC_NUM,LINE_NUM,ERROR_CODE,ERROR_TEXT) values (:b0,:b1,:b2,:b3,:b4\
,:b5,:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1421;
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
   sqlstm.sqhstv[1] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_line_no;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ar_err_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_ar_doc_error_text;
   sqlstm.sqhstl[6] = (unsigned int  )73;
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
     err_mesg("INSERT failed on table AR_DOC_ERROR",0,"");
   }

   strcpy(nd_error_flag.arr,"Y");
   nd_error_flag.len = 1;
}

update_err_flg()
{
   /* EXEC SQL UPDATE AR_INV_HDR 
               SET ERROR_FLAG = :nd_error_flag
             WHERE ROWID      = :rowid_hdr; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update AR_INV_HDR  set ERROR_FLAG=:b0 where ROWID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1464;
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
   sqlstm.sqhstv[1] = (         void  *)&rowid_hdr;
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
         err_mesg("UPDATE failed on table AR_INV_HDR",0,"");

}

delete_records()
{
    
    while (1)
    {
       /* EXEC SQL DELETE FROM AR_DOC_ERROR 
                      WHERE OPERATING_FACILITY_ID = :nd_facility_id
					    AND PGM_ID = :d_curr_pgm_name
                        AND ROWNUM < 500; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 59;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "delete  from AR_DOC_ERROR  where ((OPERATING_FACILITY_\
ID=:b0 and PGM_ID=:b1) and ROWNUM<500)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1487;
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
       sqlstm.sqhstv[1] = (         void  *)&d_curr_pgm_name;
       sqlstm.sqhstl[1] = (unsigned int  )17;
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
         err_mesg("DELETE failed on table AR_DOC_ERROR",0,"");

       /* EXEC SQL COMMIT WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 59;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1510;
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
  sqlstm.arrsiz = 59;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )1525;
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
   /* EXEC SQL SELECT  NUM_OF_ACC_PERIODS , ACC_ENTITY_CODE , NO_OF_DECIMAL
              INTO   :d_sy_num_acc_per, :nd_acc_entity_code, :nd_no_of_decimal
              FROM SY_ACC_ENTITY
		   where   ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 59;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NUM_OF_ACC_PERIODS ,ACC_ENTITY_CODE ,NO_OF_DECIMAL \
into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1556;
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




   


    

    /* EXEC SQL EXECUTE 
            BEGIN
	         GET_INSTALLED_MODULES(:p_operational_modules);   
            END;
    END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 59;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin GET_INSTALLED_MODULES ( :p_operational_modules ) ; \
END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1587;
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
 sqlstm.arrsiz = 59;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INSTR(:b0,'BL|') into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1606;
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
 sqlstm.arrsiz = 59;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INSTR(:b0,'MP|') into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1629;
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






   if (OERROR)
        err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

  
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
     sqlstm.arrsiz = 59;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select AR_INTERFACE_CODE into :b0  from AR_PARAMETER whe\
re OPERATING_FACILITY_ID=:b1";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1652;
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
     sqlstm.arrsiz = 59;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select CURRENT_ACC_YEAR ,CURRENT_ACC_MONTH ,PRIOR_POSTIN\
G_ALLOW_FLAG ,NVL(SUMMARY_PROCESS_FLAG,'X') into :b0,:b1,:b2,:b3  from GL_PARA\
METER ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1675;
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

  sprintf(l_run_string,"runrep %s %s no \
  %s session_id=%s pgm_date=%s %s desname=%s.lis",
  "arrinlst",uid_pwd.arr,
  (nd_view_print_flg.arr[0]=='V')?"batch=no":"batch=yes",
  nd_session_id.arr,g_pgm_date,
  (nd_view_print_flg.arr[0]=='V')?"destype=Screen":"destype=File",
  (nd_proc_flag.arr[0]=='P')?"arbinpst":"arrinlst");
 
  l_ret_run_rep = WinExec(l_run_string,SW_NORMAL);

  if (l_ret_run_rep<32)
  {
     
     disp_message(ERR_MESG,"Error in calling Report Writer Program");
     proc_exit();
     sprintf(l_messg_str,"RUNREP - arrinlst session = %s failed \
return value %d",nd_session_id.arr,l_ret_run_rep);
     err_mesg(l_messg_str,0,"");
  }
} 

doubcmp(_doub1,_doub2)
double _doub1,_doub2;
{
  varchar _doub_str1[25],_doub_str2[25];
  if (nd_no_of_decimal == 3)
  {
	  sprintf(_doub_str1,"%15.3f",_doub1);
	  sprintf(_doub_str2,"%15.3f",_doub2);
  }
  else
  { 
	  sprintf(_doub_str1,"%15.2f",_doub1);
	  sprintf(_doub_str2,"%15.2f",_doub2);
  }

/* 
  ltrim(_doub_str1);
  ltrim(_doub_str2);
  if (strcmp(_doub_str1,"-0.00") == 0)
     strcpy(_doub_str1,"0.00");
  if (strcmp(_doub_str2,"-0.00") == 0)
     strcpy(_doub_str2,"0.00");
*/
  format_amt(_doub_str1,nd_no_of_decimal);
  format_amt(_doub_str2,nd_no_of_decimal);
  return(strcmp(_doub_str1,_doub_str2));
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

