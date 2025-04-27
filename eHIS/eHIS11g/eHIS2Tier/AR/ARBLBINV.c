
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/AR/ARBLBINV.PC"
};


static unsigned int sqlctx = 1288481483;


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
            void  *sqhstv[35];
   unsigned int   sqhstl[35];
            int   sqhsts[35];
            void  *sqindv[35];
            int   sqinds[35];
   unsigned int   sqharm[35];
   unsigned int   *sqharc[35];
   unsigned short  sqadto[35];
   unsigned short  sqtdso[35];
} sqlstm = {12,35};

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

 static const char *sq0007 = 
"select C.rowid  ,A.CUST_CODE ,A.BLNG_GRP_ID ,B.TEST_CODE ,C.SECTION_CODE ,TR\
UNC(NVL(B.NET_CHARGE,0),2) ,C.SPECIMEN_NO ,TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD/M\
M/YYYY') ,C.DOC_TYPE_CODE ,C.DOC_NUM ,C.PATIENT_ID  from BL_AM_REFERRAL A ,RL_\
REQUEST_DETAIL B ,RL_REQUEST_HEADER C where (((((((SPEC_REGD_DATE_TIME>=TO_DAT\
E((:b0||'0000'),'dd/mm/yyyyhh24mi') and SPEC_REGD_DATE_TIME<(TO_DATE((:b1||'00\
00'),'dd/mm/yyyyhh24mi')+1)) and NVL(INVOICED_YN,'N')='N') and NVL(B.CANCELLED\
_YN,'N')='N') and A.REFERRAL_CODE=C.SOURCE_CODE) and A.CHARGE_POSTING_MODE='A'\
) and B.SPECIMEN_NO=C.SPECIMEN_NO) and NVL(B.NET_CHARGE,0)>0) order by A.CUST_\
CODE,C.SPECIMEN_NO,C.SECTION_CODE            ";

 static const char *sq0012 = 
"select NVL(STATUS,'X') ,NVL(AR_VALID_FLAG,'X') ,NVL(DOC_NUM_GEN_FLAG,'X')  f\
rom GL_ACC_ENTITY_DOC_TYPE_VW where DOC_TYPE_CODE=:b0           ";

 static const char *sq0013 = 
"select 'X'  from AR_TRN_DOC_TYPE where (DOC_TYPE_CODE=:b0 and TRN_TYPE_CODE=\
'1')           ";

 static const char *sq0008 = 
"select BL_RECV_ACC_INT_CODE ,AR_RECV_ACC_INT_CODE  from BL_BILL_TYPE where B\
ILL_TYPE_CODE=:b0           ";

 static const char *sq0009 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,SUBLEDGER_GROUP_CODE ,SUBL\
EDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE  from BL_GL_ACCOUNT whe\
re ACC_INT_CODE=:b0           ";

 static const char *sq0010 = 
"select PMNT_TERMS_CODE  from AR_CUSTOMER where CUST_CODE=:b0           ";

 static const char *sq0011 = 
"select CREDIT_DAYS_PERIOD ,SETTLEMENT_DAYS_PERIOD ,SETTLEMENT_PERC ,NVL(MARK\
UP_PERC,0)  from AR_PMNT_TERMS where PMNT_TERMS_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,0,0,29,336,0,0,0,0,0,1,0,
20,0,0,2,0,0,30,342,0,0,0,0,0,1,0,
35,0,0,3,193,0,4,382,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,1,9,0,0,
86,0,0,4,91,0,2,423,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
109,0,0,5,275,0,4,462,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
160,0,0,6,75,0,4,506,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
183,0,0,7,667,0,9,594,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
206,0,0,12,140,0,9,603,0,0,1,1,0,1,0,1,9,0,0,
225,0,0,12,0,0,13,616,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
252,0,0,13,91,0,9,638,0,0,1,1,0,1,0,1,9,0,0,
271,0,0,13,0,0,13,643,0,0,1,0,0,1,0,2,9,0,0,
290,0,0,7,0,0,13,683,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
349,0,0,14,125,0,4,744,0,0,3,1,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,
376,0,0,15,85,0,5,758,0,0,1,1,0,1,0,1,9,0,0,
395,0,0,8,104,0,9,769,0,0,1,1,0,1,0,1,9,0,0,
414,0,0,8,0,0,13,780,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
437,0,0,9,184,0,9,795,0,0,1,1,0,1,0,1,9,0,0,
456,0,0,9,0,0,13,816,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,
499,0,0,9,184,0,9,843,0,0,1,1,0,1,0,1,9,0,0,
518,0,0,9,0,0,13,864,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,
561,0,0,10,71,0,9,891,0,0,1,1,0,1,0,1,9,0,0,
580,0,0,10,0,0,13,900,0,0,1,0,0,1,0,2,9,0,0,
599,0,0,11,143,0,9,912,0,0,1,1,0,1,0,1,9,0,0,
618,0,0,11,0,0,13,927,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
649,0,0,16,85,0,4,950,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
672,0,0,17,94,0,4,968,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
695,0,0,18,71,0,4,981,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
718,0,0,19,276,0,3,996,0,0,14,14,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,4,0,0,1,9,0,0,
789,0,0,20,459,0,3,1045,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
880,0,0,21,1050,0,3,1104,0,0,35,35,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,4,0,0,
1035,0,0,22,293,0,5,1237,0,0,10,10,0,1,0,1,4,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1090,0,0,23,457,0,3,1257,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1181,0,0,24,61,0,5,1315,0,0,1,1,0,1,0,1,9,0,0,
1200,0,0,0,0,0,27,1331,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : ARBLBINV.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 07-AUG-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                               */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*          1.         RL_REQUEST_HEADER         Read/Update            */
/*          2.         RL_REQUEST_DETAIL         Read                   */
/*          3.         RL_PATIENT_MAST           Read                   */
/*          4.         RL_SECTION_CODE           Read                   */
/*          5.         RL_PARAM                  Read                   */
/*          6.         BL_GL_ACCOUNT             Read                   */
/*          7.         BL_BILL_TYPE              Read                   */
/*          8.         AR_INV_HDR                Insert                 */
/*          9.         AR_INV_LINE               Insert                 */
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

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])



#define VIEW_LOG_FILE    1


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR d_uid_pwd                                  [51],
  	        hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [40],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],
            nd_cust_code                               [9],
            nd_billing_grp                             [5],  -- CRF-0120
            nd_fm_doc_date                             [12],
            nd_to_doc_date                             [12],
            nd_fm_doc_type_code                        [7],
            nd_to_doc_type_code                        [7],
            nd_fm_doc_num                              [9],
            nd_to_doc_num                              [9],
            nd_inv_doc_type_code                       [7],
            nd_inv_date                                [12],
            nd_bill_type                               [3],
            nd_credit_ref                              [16],
            nd_doc_num_gen_flag                        [2],

            d_acc_status                               [2],
            d_acc_valid_flag                           [2],
            l_dummy                                    [10][2],
            d_sy_acc_rowid                             [31],
			p_language_id    [3]; */ 
struct { unsigned short len; unsigned char arr[51]; } d_uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[5]; } nd_billing_grp;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[7]; } nd_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[12]; } nd_inv_date;

struct { unsigned short len; unsigned char arr[3]; } nd_bill_type;

struct { unsigned short len; unsigned char arr[16]; } nd_credit_ref;

struct { unsigned short len; unsigned char arr[2]; } nd_doc_num_gen_flag;

struct { unsigned short len; unsigned char arr[2]; } d_acc_status;

struct { unsigned short len; unsigned char arr[2]; } d_acc_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } l_dummy[10];

struct { unsigned short len; unsigned char arr[31]; } d_sy_acc_rowid;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


      long  nd_inv_start_doc_num,
            nd_new_doc_num;

    /* VARCHAR 
	    nd_facility_id                             [3],
		d_rowid                                    [26],
	    d_cust_code                                [9],
	    d_prv_cust_code                            [9],
	    d_blng_grp_id                              [5],  -- CRF-0120
	    d_request_num                              [11],
	    d_prv_request_num                          [11],
	    d_ord_regd_date                            [11],
	    d_prv_ord_regd_date                        [11],
	    d_doc_type_code                            [7],
	    d_prv_doc_type_code                        [7],
	    d_doc_num                                  [9],
	    d_prv_doc_num                              [9],
	    d_patient_id                               [21],
	    d_prv_patient_id                           [21],
	    d_patient_name                             [61],

	    d_test_code                                [7],
	    d_section_code                             [2],
	    d_prv_section_code                         [2],
	    d_section_short_name                       [16],
  
           nd_new_doc_type_code                        [7],

           bl_par_post_month                           [3],
           bl_par_post_year                            [5],

           bl_main_acc1_code_mk_inv                    [7],
           bl_main_acc2_code_mk_inv                    [5],
           bl_dept_code_mk_inv                         [11],
           bl_prod_grp_code_mk_inv                     [4],
           bl_prod_line_code_mk_inv                    [5],
           bl_sublgr_grp_code_mk_inv                   [4],
           bl_sublgr_line_code_mk_inv                  [9],
           nd_acc_entity_code                          [5],  

           recv_int_code                               [7],
           bl_recv_acc_int_code                        [7],
           ar_recv_acc_int_code                        [7],
           bl_bill_type_short_desc                     [16],

           bl_rec_main_acc1_code                       [7],
           bl_rec_main_acc2_code                       [5],
           bl_rec_dept_code                            [11],
           bl_rec_subledger_group_code                 [4],
           bl_rec_subledger_line_code                  [9],
           bl_rec_product_group_code                   [4],
           bl_rec_product_line_code                    [5],

           ar_rec_main_acc1_code                       [7],
           ar_rec_main_acc2_code                       [5],
           ar_rec_dept_code                            [11],
           ar_rec_subledger_group_code                 [4],
           ar_rec_subledger_line_code                  [9],
           ar_rec_product_group_code                   [4],
           ar_rec_product_line_code                    [5],

           bl_cust_pmnt_terms_code                     [3],
           ar_pmnt_cred_days_period                    [4],
           ar_pmnt_settl_days_period                   [4],
           ar_pmnt_settl_percent                       [9],

           bl_h_credit_doc_ref_desc                    [16],

           nd_st_patient_id                            [21],
           nd_st_doc_type_code                         [7],
           nd_st_doc_num                               [9],
           nd_st_doc_date                              [12],
           nd_st_blng_grp_id                           [3],
           bl_h_prev_cust_code                         [9]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[26]; } d_rowid;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[9]; } d_prv_cust_code;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[11]; } d_request_num;

struct { unsigned short len; unsigned char arr[11]; } d_prv_request_num;

struct { unsigned short len; unsigned char arr[11]; } d_ord_regd_date;

struct { unsigned short len; unsigned char arr[11]; } d_prv_ord_regd_date;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } d_prv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num;

struct { unsigned short len; unsigned char arr[9]; } d_prv_doc_num;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_prv_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[7]; } d_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_section_code;

struct { unsigned short len; unsigned char arr[2]; } d_prv_section_code;

struct { unsigned short len; unsigned char arr[16]; } d_section_short_name;

struct { unsigned short len; unsigned char arr[7]; } nd_new_doc_type_code;

struct { unsigned short len; unsigned char arr[3]; } bl_par_post_month;

struct { unsigned short len; unsigned char arr[5]; } bl_par_post_year;

struct { unsigned short len; unsigned char arr[7]; } bl_main_acc1_code_mk_inv;

struct { unsigned short len; unsigned char arr[5]; } bl_main_acc2_code_mk_inv;

struct { unsigned short len; unsigned char arr[11]; } bl_dept_code_mk_inv;

struct { unsigned short len; unsigned char arr[4]; } bl_prod_grp_code_mk_inv;

struct { unsigned short len; unsigned char arr[5]; } bl_prod_line_code_mk_inv;

struct { unsigned short len; unsigned char arr[4]; } bl_sublgr_grp_code_mk_inv;

struct { unsigned short len; unsigned char arr[9]; } bl_sublgr_line_code_mk_inv;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[7]; } recv_int_code;

struct { unsigned short len; unsigned char arr[7]; } bl_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[7]; } ar_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[16]; } bl_bill_type_short_desc;

struct { unsigned short len; unsigned char arr[7]; } bl_rec_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_rec_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } bl_rec_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_rec_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_rec_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_rec_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_rec_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } ar_rec_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } ar_rec_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } ar_rec_dept_code;

struct { unsigned short len; unsigned char arr[4]; } ar_rec_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } ar_rec_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } ar_rec_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } ar_rec_product_line_code;

struct { unsigned short len; unsigned char arr[3]; } bl_cust_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[4]; } ar_pmnt_cred_days_period;

struct { unsigned short len; unsigned char arr[4]; } ar_pmnt_settl_days_period;

struct { unsigned short len; unsigned char arr[9]; } ar_pmnt_settl_percent;

struct { unsigned short len; unsigned char arr[16]; } bl_h_credit_doc_ref_desc;

struct { unsigned short len; unsigned char arr[21]; } nd_st_patient_id;

struct { unsigned short len; unsigned char arr[7]; } nd_st_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_st_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_st_doc_date;

struct { unsigned short len; unsigned char arr[3]; } nd_st_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } bl_h_prev_cust_code;


    double nd_sum_outst_amt = 0,
           nd_sum_outst_amt_sec = 0,
           nd_ar_inv_line_amt = 0,
           nd_sum_drfee_amt = 0,
           d_order_item_debit_value,
		   nd_markup_amt = 0;

      int  nd_ctr = 0,
  	       ar_markup_perc =0,
	       d_line_num;

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


void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;

    if (argc < 5)    
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"ARBLBINV");

    if (sql_connect(argv[1]) == -1)
    {
        disp_message(ERR_MESG,"Error in connecting to Oracle");
        proc_exit();
    }

	set_meduser_role();

strcpy(p_language_id.arr,l_language_id.arr);
p_language_id.len = l_language_id.len;

    start_prog_msg();

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);          
	
	/*set_meduser_role();*/
    fetch_prog_param();
    fetch_ar_param();
    fetch_acc_entity_flag();
    fetch_acc_int_codes();

    declare_cur();
     
    strcpy(nd_new_doc_type_code.arr,nd_inv_doc_type_code.arr);
    nd_new_doc_type_code.len = strlen(nd_new_doc_type_code.arr);

    nd_new_doc_num           = nd_inv_start_doc_num;

    nd_sum_outst_amt = 0;
    nd_sum_drfee_amt = 0;
    nd_ctr = 0;
    d_line_num = 1;

    while(fetch_hdr()) {

       rec_ctr++;

       if(strcmp(d_prv_cust_code.arr, d_cust_code.arr)) {

          if (nd_doc_num_gen_flag.arr[0] == 'Y')
               gen_doc_num();

          if (rec_ctr > 0) {
             fetch_pat_dtls();
             insert_ar_patient();
           //  fetch_dtl_line();
             insert_ar_line();
             fetch_dtl_hdr();
             insert_ar_hdr();
          }
/*
          EXEC SQL COMMIT WORK;

          if (OERROR)
               err_mesg("COMMIT failed",0,""); 
*/
          nd_sum_outst_amt     = 0;
          nd_sum_outst_amt_sec = 0;
          nd_sum_drfee_amt     = 0;
          nd_ar_inv_line_amt   = 0;
          nd_ctr = 0;
          d_line_num           = 1;
          nd_inv_start_doc_num ++;

	  strcpy(d_prv_cust_code.arr, d_cust_code.arr);
	  strcpy(d_prv_request_num.arr, d_request_num.arr);
	  strcpy(d_prv_section_code.arr, d_section_code.arr);

       }
  
       if(strcmp(d_prv_section_code.arr, d_section_code.arr)||
          strcmp(d_prv_request_num.arr, d_request_num.arr)) {
           fetch_pat_dtls();
           insert_ar_patient();
           nd_sum_outst_amt_sec = 0;
           if(strcmp(d_prv_section_code.arr, d_section_code.arr)) {
	     //  fetch_dtl_line();
	       insert_ar_line();
	       nd_ar_inv_line_amt   = 0;
	   }
       }

       update_hdr();

       nd_sum_outst_amt     += d_order_item_debit_value;
       nd_sum_outst_amt_sec += d_order_item_debit_value;
       nd_ar_inv_line_amt   += d_order_item_debit_value;

       strcpy(d_prv_cust_code.arr,d_cust_code.arr);
       strcpy(d_prv_request_num.arr, d_request_num.arr);
       strcpy(d_prv_section_code.arr, d_section_code.arr);
       strcpy(d_prv_patient_id.arr, d_patient_id.arr);
       strcpy(d_prv_ord_regd_date.arr, d_ord_regd_date.arr);
       strcpy(d_prv_doc_type_code.arr, d_doc_type_code.arr);
       strcpy(d_prv_doc_num.arr, d_doc_num.arr);

       d_prv_cust_code.len     = strlen(d_prv_cust_code.arr);
       d_prv_request_num.len   = strlen(d_prv_request_num.arr);
       d_prv_section_code.len  = strlen(d_prv_section_code.arr);
       d_prv_patient_id.len    = strlen(d_prv_patient_id.arr);
       d_prv_ord_regd_date.len = strlen(d_prv_ord_regd_date.arr);
       d_prv_doc_type_code.len = strlen(d_prv_doc_type_code.arr);
       d_prv_doc_num.len       = strlen(d_prv_doc_num.arr);

       nd_ctr++;

       if (nd_ctr == 1)
       {
          strcpy(nd_st_patient_id.arr,d_patient_id.arr);
          strcpy(nd_st_doc_type_code.arr,d_doc_type_code.arr);
          strcpy(nd_st_doc_num.arr,d_doc_num.arr);
          strcpy(nd_st_doc_date.arr,d_ord_regd_date.arr);
          strcpy(nd_st_blng_grp_id.arr,d_blng_grp_id.arr);

          nd_st_patient_id.len    =  strlen(nd_st_patient_id.arr);
          nd_st_doc_type_code.len =  strlen(nd_st_doc_type_code.arr);
          nd_st_doc_num.len       =  strlen(nd_st_doc_num.arr);
          nd_st_doc_date.len      =  strlen(nd_st_doc_date.arr);
          nd_st_blng_grp_id.len   =  strlen(nd_st_blng_grp_id.arr);
       }

    }

    if (rec_ctr > 0)
    {
       if (nd_doc_num_gen_flag.arr[0] == 'Y')
           gen_doc_num();
       fetch_pat_dtls();
       insert_ar_patient();
     //  fetch_dtl_line();
       insert_ar_line();
       fetch_dtl_hdr();
       insert_ar_hdr();
    } 

    end_prog_msg();

    /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 0;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("COMMIT failed",0,""); 


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 0;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )20;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed REA",0,"");

}


fetch_prog_param()
{

    nd_fm_doc_date.arr[0]               = '\0';
    nd_to_doc_date.arr[0]               = '\0';
    nd_fm_doc_type_code.arr[0]          = '\0';
    nd_to_doc_type_code.arr[0]          = '\0';
    nd_fm_doc_num.arr[0]                = '\0';
    nd_to_doc_num.arr[0]                = '\0';
    nd_inv_doc_type_code.arr[0]         = '\0';
    nd_inv_date.arr[0]                  = '\0';
    nd_billing_grp.arr[0]               = '\0';
    nd_cust_code.arr[0]                 = '\0';
    nd_bill_type.arr[0]                 = '\0';
    nd_credit_ref.arr[0]                = '\0';
	nd_facility_id.arr[0]               = '\0';

    nd_fm_doc_date.len                  = 0;
    nd_to_doc_date.len                  = 0;
    nd_fm_doc_type_code.len             = 0;
    nd_to_doc_type_code.len             = 0;
    nd_fm_doc_num.len                   = 0;
    nd_to_doc_num.len                   = 0;
    nd_inv_doc_type_code.len            = 0;
    nd_inv_date.len                     = 0;
    nd_billing_grp.len                  = 0;
    nd_cust_code.len                    = 0;
    nd_bill_type.len                    = 0;
    nd_credit_ref.len                   = 0;
    nd_facility_id.len                  = 0;

    nd_inv_start_doc_num                = 0;

   /* EXEC SQL SELECT operating_facility_id,
				   PARAM1, PARAM2, PARAM3, PARAM4,
                   PARAM5, PARAM6
/o				   
				   , PARAM7, PARAM8, PARAM9,
                   PARAM10, PARAM11, PARAM12, PARAM13
o/
              INTO :nd_facility_id,
                   :nd_fm_doc_date,
                   :nd_to_doc_date,
                   :nd_inv_doc_type_code,
                   :nd_inv_start_doc_num,
                   :nd_inv_date,
                   :nd_bill_type
              FROM SY_PROG_PARAM
                   WHERE 
                   PGM_ID     = 'ARBLBINV'
                   AND SESSION_ID = :nd_session_id
                   AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where \
((PGM_ID='ARBLBINV' and SESSION_ID=:b7) and PGM_DATE=:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )35;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_inv_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_inv_start_doc_num;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_inv_date;
   sqlstm.sqhstl[5] = (unsigned int  )14;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_bill_type;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[8] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_fm_doc_date.arr[nd_fm_doc_date.len]             = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]             = '\0';
   nd_fm_doc_type_code.arr[nd_fm_doc_type_code.len]   = '\0';
   nd_to_doc_type_code.arr[nd_to_doc_type_code.len]   = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]               = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]               = '\0';
   nd_inv_doc_type_code.arr[nd_inv_doc_type_code.len] = '\0';
   nd_inv_date.arr[nd_inv_date.len]                   = '\0';
   nd_facility_id.arr[nd_facility_id.len]             = '\0';
   nd_billing_grp.arr[nd_billing_grp.len] = '\0';
   nd_cust_code.arr[nd_cust_code.len] = '\0';
   nd_bill_type.arr[nd_bill_type.len] = '\0';
   nd_credit_ref.arr[nd_credit_ref.len] = '\0';

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBLBINV'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARBLBINV' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )86;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

   
   val_doc_type();

}

fetch_ar_param()
{

    bl_par_post_month.arr[0]      = '\0';
    bl_par_post_year.arr[0]       = '\0';

	bl_main_acc1_code_mk_inv.arr[0] = '\0';
	bl_main_acc2_code_mk_inv.arr[0] = '\0';
	bl_dept_code_mk_inv.arr[0] = '\0';
	bl_prod_grp_code_mk_inv.arr[0] = '\0';
	bl_prod_line_code_mk_inv.arr[0] = '\0';
	bl_sublgr_grp_code_mk_inv.arr[0] = '\0';
	bl_sublgr_line_code_mk_inv.arr[0] = '\0';

    bl_par_post_month.len         = 0;
    bl_par_post_year.len          = 0;

	bl_main_acc1_code_mk_inv.len = 0;
	bl_main_acc2_code_mk_inv.len = 0;
	bl_dept_code_mk_inv.len = 0;
	bl_prod_grp_code_mk_inv.len = 0;
	bl_prod_line_code_mk_inv.len = 0;
	bl_sublgr_grp_code_mk_inv.len = 0;
	bl_sublgr_line_code_mk_inv.len = 0;


    /* EXEC SQL SELECT 
                   CURRENT_ACC_MONTH,  CURRENT_ACC_YEAR,
                   MAIN_ACC1_CODE_MK_BILLS, MAIN_ACC2_CODE_MK_BILLS,  
                   DEPT_CODE_MK_BILLS, PROD_GRP_CODE_MK_BILLS,   
                   PROD_LINE_CODE_MK_BILLS, SUBLGR_GRP_CODE_MK_BILLS, 
                   SUBLGR_LINE_CODE_MK_BILLS	
                   INTO 
                   :bl_par_post_month,       :bl_par_post_year,
                   :bl_main_acc1_code_mk_inv,:bl_main_acc2_code_mk_inv,
                   :bl_dept_code_mk_inv, :bl_prod_grp_code_mk_inv,
                   :bl_prod_line_code_mk_inv, :bl_sublgr_grp_code_mk_inv,
                   :bl_sublgr_line_code_mk_inv
                   FROM AR_PARAMETER; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CURRENT_ACC_MONTH ,CURRENT_ACC_YEAR ,MAIN_ACC1_COD\
E_MK_BILLS ,MAIN_ACC2_CODE_MK_BILLS ,DEPT_CODE_MK_BILLS ,PROD_GRP_CODE_MK_BILL\
S ,PROD_LINE_CODE_MK_BILLS ,SUBLGR_GRP_CODE_MK_BILLS ,SUBLGR_LINE_CODE_MK_BILL\
S into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from AR_PARAMETER ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )109;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_par_post_month;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_par_post_year;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_main_acc1_code_mk_inv;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_main_acc2_code_mk_inv;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_dept_code_mk_inv;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_prod_grp_code_mk_inv;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_prod_line_code_mk_inv;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bl_sublgr_grp_code_mk_inv;
    sqlstm.sqhstl[7] = (unsigned int  )6;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bl_sublgr_line_code_mk_inv;
    sqlstm.sqhstl[8] = (unsigned int  )11;
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
         err_mesg("SELECT failed on table AR_PARAMETER",0,"");

    if (NOT_FOUND)
        err_mesg("Record not found in  AR PARAMETER",0,"");

    bl_par_post_month.arr[bl_par_post_month.len] = '\0';
    bl_par_post_year.arr[bl_par_post_year.len] = '\0';


    bl_main_acc1_code_mk_inv.arr[bl_main_acc1_code_mk_inv.len] = '\0';
	bl_main_acc2_code_mk_inv.arr[bl_main_acc2_code_mk_inv.len] = '\0';
    bl_dept_code_mk_inv.arr[bl_dept_code_mk_inv.len] = '\0';
    bl_prod_grp_code_mk_inv.arr[bl_prod_grp_code_mk_inv.len] = '\0';
    bl_prod_line_code_mk_inv.arr[bl_prod_line_code_mk_inv.len] = '\0';
    bl_sublgr_grp_code_mk_inv.arr[bl_sublgr_grp_code_mk_inv.len] = '\0';
    bl_sublgr_line_code_mk_inv.arr[bl_sublgr_line_code_mk_inv.len] = '\0';


}


fetch_acc_entity_flag()
{

   nd_acc_entity_code.arr[0] = '\0';

   nd_acc_entity_code.len    = 0;


	   /* EXEC SQL SELECT  ACC_ENTITY_CODE
              INTO     :nd_acc_entity_code
              FROM      SY_ACC_ENTITY
		   where   ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_CODE into :b0  from SY_ACC_ENTITY where\
 ACC_ENTITY_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )160;
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
        err_mesg("Record not found in  SY_ACC_ENTITY",0,"");

    nd_acc_entity_code.arr[nd_acc_entity_code.len] = '\0';

}

declare_cur()
{
 
     /* EXEC SQL DECLARE RL_REQ_HDR_CUR CURSOR FOR
	       SELECT C.ROWID,
		      A.CUST_CODE,
		      A.BLNG_GRP_ID,
		      B.TEST_CODE,
		      C.SECTION_CODE,
		      TRUNC(NVL(B.NET_CHARGE,0),2),
		      C.SPECIMEN_NO,
		      TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),
		      C.DOC_TYPE_CODE,
		      C.DOC_NUM,
  		      C.PATIENT_ID
		 FROM BL_AM_REFERRAL A,
		      RL_REQUEST_DETAIL B,
		      RL_REQUEST_HEADER C
		WHERE SPEC_REGD_DATE_TIME >= TO_DATE(:nd_fm_doc_date||'0000',
						'dd/mm/yyyyhh24mi') 
		  AND SPEC_REGD_DATE_TIME < TO_DATE(:nd_to_doc_date||'0000',
						'dd/mm/yyyyhh24mi')+1 
		  AND NVL(INVOICED_YN,'N')  = 'N'
		  AND NVL(B.CANCELLED_YN,'N') = 'N'
		  AND A.REFERRAL_CODE  = C.SOURCE_CODE
		  AND A.CHARGE_POSTING_MODE = 'A'
		  AND B.SPECIMEN_NO = C.SPECIMEN_NO
		  AND NVL(B.NET_CHARGE,0) > 0
	      ORDER BY A.CUST_CODE, C.SPECIMEN_NO, C.SECTION_CODE; */ 


     /* EXEC SQL DECLARE BL_BILL_TYPE_CUR CURSOR FOR
               SELECT BL_RECV_ACC_INT_CODE,
                      AR_RECV_ACC_INT_CODE
                 FROM BL_BILL_TYPE
                WHERE BILL_TYPE_CODE = :nd_bill_type; */ 


     /* EXEC SQL DECLARE BL_GL_ACCOUNT_CUR CURSOR FOR
               SELECT MAIN_ACC1_CODE,
                      MAIN_ACC2_CODE,
                      DEPT_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE
                 FROM BL_GL_ACCOUNT
                WHERE ACC_INT_CODE = :recv_int_code; */ 

 
     /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
               SELECT PMNT_TERMS_CODE
                 FROM AR_CUSTOMER
                WHERE CUST_CODE = :d_prv_cust_code; */ 


     /* EXEC SQL DECLARE AR_PMNT_TERMS_CUR CURSOR FOR
               SELECT CREDIT_DAYS_PERIOD,
                      SETTLEMENT_DAYS_PERIOD,
                      SETTLEMENT_PERC,
					  NVL(MARKUP_PERC,0)
                 FROM AR_PMNT_TERMS
                WHERE PMNT_TERMS_CODE = :bl_cust_pmnt_terms_code; */ 


   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
             SELECT NVL(STATUS,'X'),
                    NVL(AR_VALID_FLAG,'X'),
                    NVL(DOC_NUM_GEN_FLAG,'X')
               FROM GL_ACC_ENTITY_DOC_TYPE_VW
              WHERE DOC_TYPE_CODE   = :nd_inv_doc_type_code; */ 


   /* EXEC SQL DECLARE AR_TRN_DOC_TYPE_CUR CURSOR FOR
             SELECT 'X'
               FROM AR_TRN_DOC_TYPE
              WHERE DOC_TYPE_CODE = :nd_inv_doc_type_code
                AND TRN_TYPE_CODE = '1'; */ 


    /* EXEC SQL OPEN RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )183;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[0] = (unsigned int  )14;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[1] = (unsigned int  )14;
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
	err_mesg("OPEN failed on cursor RL_REQ_HDR_CUR",0,"");
}

val_doc_type()
{

   /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )206;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_inv_doc_type_code;
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

   d_acc_status.arr[0]     = '\0';
   d_acc_valid_flag.arr[0] = '\0';
   nd_doc_num_gen_flag.arr[0]          = '\0';

   d_acc_valid_flag.len = 0;
   d_acc_status.len     = 0;
   nd_doc_num_gen_flag.len             = 0;

   /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
             INTO :d_acc_status,
                  :d_acc_valid_flag,
                  :nd_doc_num_gen_flag; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )225;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_status;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_acc_valid_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_doc_num_gen_flag;
   sqlstm.sqhstl[2] = (unsigned int  )4;
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

   d_acc_status.arr[d_acc_status.len]         = '\0';
   d_acc_valid_flag.arr[d_acc_valid_flag.len] = '\0';
   nd_doc_num_gen_flag.arr[nd_doc_num_gen_flag.len]   = '\0';

   if (NOT_FOUND)      /* Doc type not existing in SY_ACC_ENTITY_DOC_TYPE */
         err_mesg("",1,"SY2200");
   else
   {
      if (d_acc_valid_flag.arr[0] != 'Y') /* Doc Not valid for AP    */
            err_mesg("Document Type not valid for AR module",0,"");
      if (d_acc_status.arr[0] == 'S')     /* Doc is suspended        */
            err_mesg("",1,"SY2190");
   } 

   /* EXEC SQL OPEN AR_TRN_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0013;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )252;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_inv_doc_type_code;
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
         err_mesg("OPEN failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   /* EXEC SQL FETCH AR_TRN_DOC_TYPE_CUR
             INTO :l_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )271;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)l_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )4;
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
       err_mesg("Trn type Not valid for this document",0,"");

}

fetch_hdr()
{

    static int first = 1;

    d_rowid.arr[0]           = '\0';
    d_cust_code.arr[0]       = '\0';
    d_blng_grp_id.arr[0]     = '\0';
    d_request_num.arr[0]     = '\0';
    d_ord_regd_date.arr[0]   = '\0';
    d_doc_type_code.arr[0]   = '\0';
    d_doc_num.arr[0]         = '\0';
    d_test_code.arr[0]       = '\0';
    d_section_code.arr[0]    = '\0';
    d_patient_id.arr[0]      = '\0';

    d_rowid.len              = 0;
    d_cust_code.len          = 0;
    d_blng_grp_id.len        = 0;
    d_request_num.len        = 0;
    d_ord_regd_date.len      = 0;
    d_doc_type_code.len      = 0;
    d_doc_num.len            = 0;
    d_test_code.len          = 0;
    d_section_code.len       = 0;
    d_patient_id.len         = 0;

    d_order_item_debit_value    = 0;

    /* EXEC SQL FETCH RL_REQ_HDR_CUR 
	          INTO  :d_rowid,
					:d_cust_code,
					:d_blng_grp_id,
					:d_test_code,
					:d_section_code,
					:d_order_item_debit_value,
                    :d_request_num,
                    :d_ord_regd_date,
                    :d_doc_type_code,
                    :d_doc_num,
					:d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )290;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )28;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_section_code;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_order_item_debit_value;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_request_num;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_ord_regd_date;
    sqlstm.sqhstl[7] = (unsigned int  )13;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[8] = (unsigned int  )9;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_doc_num;
    sqlstm.sqhstl[9] = (unsigned int  )11;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[10] = (unsigned int  )23;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor RL_REQ_HDR_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_cust_code.arr[d_cust_code.len]            = '\0';
    d_blng_grp_id.arr[d_blng_grp_id.len]        = '\0';
    d_test_code.arr[d_test_code.len]            = '\0';
    d_section_code.arr[d_section_code.len]      = '\0';
    d_request_num.arr[d_request_num.len]        = '\0';
    d_ord_regd_date.arr[d_ord_regd_date.len]    = '\0';
    d_doc_type_code.arr[d_doc_type_code.len]    = '\0';
    d_doc_num.arr[d_doc_num.len]                = '\0';
    d_patient_id.arr[d_patient_id.len]          = '\0';

    if(first) 
	{
	strcpy(d_prv_cust_code.arr, d_cust_code.arr);
	strcpy(d_prv_request_num.arr, d_request_num.arr);
	strcpy(d_prv_section_code.arr, d_section_code.arr);
	strcpy(d_prv_patient_id.arr, d_patient_id.arr);
	strcpy(d_prv_ord_regd_date.arr, d_ord_regd_date.arr);
	strcpy(d_prv_doc_type_code.arr, d_doc_type_code.arr);
	strcpy(d_prv_doc_num.arr, d_doc_num.arr);

        d_prv_cust_code.len     = strlen(d_prv_cust_code.arr);
        d_prv_request_num.len   = strlen(d_prv_request_num.arr);
        d_prv_section_code.len  = strlen(d_prv_section_code.arr);
        d_prv_patient_id.len    = strlen(d_prv_patient_id.arr);
        d_prv_ord_regd_date.len = strlen(d_prv_ord_regd_date.arr);
        d_prv_doc_type_code.len = strlen(d_prv_doc_type_code.arr);
        d_prv_doc_num.len       = strlen(d_prv_doc_num.arr);


	first = 0;
    }

    return 1;
}

gen_doc_num()
{
     d_sy_acc_rowid.arr[0]  = '\0';
     d_sy_acc_rowid.len     = 0;

     nd_inv_start_doc_num = 0;

     /* EXEC SQL SELECT NVL(NEXT_DOC_NO,0),    ROWID
                INTO :nd_inv_start_doc_num, :d_sy_acc_rowid
                FROM SY_ACC_ENTITY_DOC_TYPE
               WHERE DOC_TYPE_CODE = :nd_inv_doc_type_code
                 FOR UPDATE OF NEXT_DOC_NO; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(NEXT_DOC_NO,0) ,ROWID into :b0,:b1  from SY_A\
CC_ENTITY_DOC_TYPE where DOC_TYPE_CODE=:b2 for update of NEXT_DOC_NO ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )349;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_inv_start_doc_num;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
     sqlstm.sqhstv[2] = (         void  *)&nd_inv_doc_type_code;
     sqlstm.sqhstl[2] = (unsigned int  )9;
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
         err_mesg("SELECT failed on table SY_ACC_ENTITY_DOC_TYPE",0,"");

     if (NOT_FOUND)
         err_mesg("Record not found in SY ACC ENTITY DOC TYPE",0,"");

     d_sy_acc_rowid.arr[d_sy_acc_rowid.len] = '\0';

     /* EXEC SQL UPDATE SY_ACC_ENTITY_DOC_TYPE 
                 SET NEXT_DOC_NO = NVL(NEXT_DOC_NO,0) + 1
               WHERE ROWID = :d_sy_acc_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update SY_ACC_ENTITY_DOC_TYPE  set NEXT_DOC_NO=(NVL(NEXT\
_DOC_NO,0)+1) where ROWID=:b0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )376;
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

fetch_acc_int_codes()
{

     /* EXEC SQL OPEN BL_BILL_TYPE_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0008;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )395;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_bill_type;
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
         err_mesg("OPEN failed on cursor BL_BILL_TYPE_CUR",0,"");

    bl_recv_acc_int_code.arr[0]            = '\0';
    ar_recv_acc_int_code.arr[0]            = '\0';

    bl_recv_acc_int_code.len               = 0;
    ar_recv_acc_int_code.len               = 0;

     /* EXEC SQL FETCH BL_BILL_TYPE_CUR
               INTO :bl_recv_acc_int_code,
                    :ar_recv_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )414;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_recv_acc_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&ar_recv_acc_int_code;
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
         err_mesg("FETCH failed on cursor BL_BILL_TYPE_CUR",0,"");
     if (NOT_FOUND)
         err_mesg("Record not found in BL BILL TYPE",0,"");

     bl_recv_acc_int_code.arr[bl_recv_acc_int_code.len] = '\0';
     ar_recv_acc_int_code.arr[ar_recv_acc_int_code.len] = '\0';

     strcpy(recv_int_code.arr,ar_recv_acc_int_code.arr);
     recv_int_code.len = strlen(recv_int_code.arr);

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0009;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )437;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&recv_int_code;
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
         err_mesg("OPEN failed on cursor BL_GL_ACCOUNT_CUR - 2",0,"");

     ar_rec_main_acc1_code.arr[0]             = '\0';
     ar_rec_main_acc2_code.arr[0]             = '\0';
     ar_rec_dept_code.arr[0]                  = '\0';
     ar_rec_subledger_group_code.arr[0]       = '\0';
     ar_rec_subledger_line_code.arr[0]        = '\0';
     ar_rec_product_group_code.arr[0]         = '\0';
     ar_rec_product_line_code.arr[0]          = '\0';

     ar_rec_main_acc1_code.len                = 0;
     ar_rec_main_acc2_code.len                = 0;
     ar_rec_dept_code.len                     = 0;
     ar_rec_subledger_group_code.len          = 0;
     ar_rec_subledger_line_code.len           = 0;
     ar_rec_product_group_code.len            = 0;
     ar_rec_product_line_code.len             = 0;

     /* EXEC SQL FETCH BL_GL_ACCOUNT_CUR
               INTO :ar_rec_main_acc1_code,
                    :ar_rec_main_acc2_code,
                    :ar_rec_dept_code,
                    :ar_rec_subledger_group_code,
                    :ar_rec_subledger_line_code,
                    :ar_rec_product_group_code,
                    :ar_rec_product_line_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )456;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&ar_rec_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&ar_rec_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&ar_rec_dept_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&ar_rec_subledger_group_code;
     sqlstm.sqhstl[3] = (unsigned int  )6;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&ar_rec_subledger_line_code;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&ar_rec_product_group_code;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&ar_rec_product_line_code;
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

     if (NOT_FOUND)
         err_mesg("Record not found in BL GL ACCOUNT - 2",0,"");

     ar_rec_main_acc1_code.arr[ar_rec_main_acc1_code.len]             = '\0';
     ar_rec_main_acc2_code.arr[ar_rec_main_acc2_code.len]             = '\0';
     ar_rec_dept_code.arr[ar_rec_dept_code.len]                       = '\0';
     ar_rec_subledger_group_code.arr[ar_rec_subledger_group_code.len] = '\0';
     ar_rec_subledger_line_code.arr[ar_rec_subledger_line_code.len]   = '\0';
     ar_rec_product_group_code.arr[ar_rec_product_group_code.len]     = '\0';
     ar_rec_product_line_code.arr[ar_rec_product_line_code.len]       = '\0';


     strcpy(recv_int_code.arr,bl_recv_acc_int_code.arr);
     recv_int_code.len = strlen(recv_int_code.arr);

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0009;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )499;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&recv_int_code;
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
         err_mesg("OPEN failed on cursor BL_GL_ACCOUNT_CUR",0,"");

     bl_rec_main_acc1_code.arr[0]             = '\0';
     bl_rec_main_acc2_code.arr[0]             = '\0';
     bl_rec_dept_code.arr[0]                  = '\0';
     bl_rec_subledger_group_code.arr[0]       = '\0';
     bl_rec_subledger_line_code.arr[0]        = '\0';
     bl_rec_product_group_code.arr[0]         = '\0';
     bl_rec_product_line_code.arr[0]          = '\0';

     bl_rec_main_acc1_code.len                = 0;
     bl_rec_main_acc2_code.len                = 0;
     bl_rec_dept_code.len                     = 0;
     bl_rec_subledger_group_code.len          = 0;
     bl_rec_subledger_line_code.len           = 0;
     bl_rec_product_group_code.len            = 0;
     bl_rec_product_line_code.len             = 0;

     /* EXEC SQL FETCH BL_GL_ACCOUNT_CUR
               INTO :bl_rec_main_acc1_code,
                    :bl_rec_main_acc2_code,
                    :bl_rec_dept_code,
                    :bl_rec_subledger_group_code,
                    :bl_rec_subledger_line_code,
                    :bl_rec_product_group_code,
                    :bl_rec_product_line_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )518;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_rec_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_rec_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_rec_dept_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_rec_subledger_group_code;
     sqlstm.sqhstl[3] = (unsigned int  )6;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_rec_subledger_line_code;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_rec_product_group_code;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_rec_product_line_code;
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

     if (NOT_FOUND)
         err_mesg("Record not found in BL GL ACCOUNT",0,"");
 
     bl_rec_main_acc1_code.arr[bl_rec_main_acc1_code.len]              = '\0';
     bl_rec_main_acc2_code.arr[bl_rec_main_acc2_code.len]              = '\0';
     bl_rec_dept_code.arr[bl_rec_dept_code.len]                        = '\0';
     bl_rec_subledger_group_code.arr[bl_rec_subledger_group_code.len]  = '\0';
     bl_rec_subledger_line_code.arr[bl_rec_subledger_line_code.len]    = '\0';
     bl_rec_product_group_code.arr[bl_rec_product_group_code.len]      = '\0';
     bl_rec_product_line_code.arr[bl_rec_product_line_code.len]        = '\0';

}

fetch_dtl_hdr()
{

     /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )561;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_prv_cust_code;
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

     bl_cust_pmnt_terms_code.arr[0]             = '\0';

     bl_cust_pmnt_terms_code.len                = 0;

     /* EXEC SQL FETCH AR_CUSTOMER_CUR
               INTO :bl_cust_pmnt_terms_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )580;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_cust_pmnt_terms_code;
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
         err_mesg("FETCH failed on cursor AR_CUSTOMER",0,"");

     if (NOT_FOUND)
         err_mesg("Record not found in AR CUSTOMER",0,"");

     bl_cust_pmnt_terms_code.arr[bl_cust_pmnt_terms_code.len] = '\0';
     bl_cust_pmnt_terms_code.arr[bl_cust_pmnt_terms_code.len] = '\0';

     /* EXEC SQL OPEN AR_PMNT_TERMS_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0011;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )599;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_cust_pmnt_terms_code;
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

     ar_pmnt_cred_days_period.arr[0]           = '\0';
     ar_pmnt_settl_days_period.arr[0]          = '\0';
     ar_pmnt_settl_percent.arr[0]              = '\0';

     ar_pmnt_cred_days_period.len              = 0;
     ar_pmnt_settl_days_period.len             = 0;
     ar_pmnt_settl_percent.len                 = 0;
	 ar_markup_perc                            = 0;


     /* EXEC SQL FETCH AR_PMNT_TERMS_CUR
               INTO :ar_pmnt_cred_days_period,
                    :ar_pmnt_settl_days_period,
                    :ar_pmnt_settl_percent,
					:ar_markup_perc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )618;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&ar_pmnt_cred_days_period;
     sqlstm.sqhstl[0] = (unsigned int  )6;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&ar_pmnt_settl_days_period;
     sqlstm.sqhstl[1] = (unsigned int  )6;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&ar_pmnt_settl_percent;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&ar_markup_perc;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
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
         err_mesg("FETCH failed on cursor AR_PMNT_TERMS_CUR",0,"");

     if (NOT_FOUND)
         err_mesg("Record not found in AR PMNT TERMS",0,"");

     ar_pmnt_cred_days_period.arr[ar_pmnt_cred_days_period.len]       = '\0';
     ar_pmnt_settl_days_period.arr[ar_pmnt_settl_days_period.len]     = '\0';
     ar_pmnt_settl_percent.arr[ar_pmnt_settl_percent.len]             = '\0';
   
}

fetch_dtl_line()
{
    bl_rec_dept_code.arr[0]  = '\0';
    bl_rec_dept_code.len     = 0;

    /* EXEC SQL SELECT DEPT_CODE
	           INTO :bl_rec_dept_code
	           //FROM RL_PARAM
			   FROM RL_PARAM_FOR_FACILITY                      //  ADDED ON 08/02/2008
			   WHERE OPERATING_FACILITY_ID =:nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select DEPT_CODE into :b0  from RL_PARAM_FOR_FACILITY whe\
re OPERATING_FACILITY_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )649;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_rec_dept_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
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

   //  ADDED ON 08/02/2008

    if(OERROR || NO_DATA_FOUND)
	err_mesg("SELECT failed on table RL_PARAM",0,"");

    bl_rec_dept_code.arr[bl_rec_dept_code.len]                        = '\0';

}  

fetch_pat_dtls()
{
    d_patient_name.arr[0]   = '\0';
    d_patient_name.len      = 0;

    /* EXEC SQL SELECT NVL(SHORT_NAME,SHORT_NAME_LOC_LANG)
	       INTO :d_patient_name
	       FROM RL_PATIENT_MAST
	      WHERE PATIENT_ID = :d_prv_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(SHORT_NAME,SHORT_NAME_LOC_LANG) into :b0  from\
 RL_PATIENT_MAST where PATIENT_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )672;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prv_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
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
	err_mesg("SELECT failed on table RL_PATIENT_MAST",0,"");

    d_patient_name.arr[d_patient_name.len]   = '\0';

    d_section_short_name.arr[0]  = '\0';
    d_section_short_name.len     = 0;

    /* EXEC SQL SELECT SHORT_NAME
	       INTO :d_section_short_name
	       FROM RL_SECTION_CODE
	      WHERE SECTION_CODE  = :d_prv_section_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_NAME into :b0  from RL_SECTION_CODE where SE\
CTION_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )695;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_section_short_name;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prv_section_code;
    sqlstm.sqhstl[1] = (unsigned int  )4;
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



    if(OERROR||NO_DATA_FOUND)
	err_mesg("SELECT failed on table RL_SECTION_CODE",0,"");

    d_section_short_name.arr[d_section_short_name.len]  = '\0';

}

insert_ar_patient()
{

     /* EXEC SQL INSERT INTO AR_PATIENT_DTLS
               (
                 DOC_TYPE_CODE,
                 DOC_NUM,
                 PATIENT_ID,
				 PATIENT_NAME,
                 BILL_DOC_TYPE_CODE,
                 BILL_NUM,
                 BILL_DATE,
                 REMARKS,
				 LAB_TEST,
                 AMOUNT,
				 AMT_PAID,
				 BILL_TYPE_CODE,
				 PEND_AMOUNT,    
				 BILLING_GROUP  
               )
             VALUES
               (
                 :nd_new_doc_type_code,            /o DOC_TYPE_CODE      o/
                 :nd_inv_start_doc_num,            /o DOC_NUM            o/
                 :d_prv_patient_id,                /o PATIENT_ID         o/
				 :d_patient_name,                  /o PATIENT_NAME       o/
                 :d_prv_doc_type_code,             /o BILL DOC TYPE CODE o/
                 :d_prv_doc_num,                   /o BILL NUM           o/
                 TO_DATE(:d_prv_ord_regd_date, 
								'DD/MM/YYYY'),	   /o BILL_DATEo/
                 :d_prv_request_num,               /o REMARKS            o/
				 :d_section_short_name,            /o LAB_TEST           o/
                 :nd_sum_outst_amt_sec,            /o AMOUNT             o/
		         :nd_sum_outst_amt_sec,            /o AMOUNT PAID        o/
				 :nd_bill_type,                    /o BILL TYPE CODE     o/
		         :nd_sum_outst_amt_sec,            /o AMOUNT OUTSTANDING o/
                 :nd_st_blng_grp_id                /o BILLING GROUP      o/
               ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "insert into AR_PATIENT_DTLS (DOC_TYPE_CODE,DOC_NUM,PATIE\
NT_ID,PATIENT_NAME,BILL_DOC_TYPE_CODE,BILL_NUM,BILL_DATE,REMARKS,LAB_TEST,AMOU\
NT,AMT_PAID,BILL_TYPE_CODE,PEND_AMOUNT,BILLING_GROUP) values (:b0,:b1,:b2,:b3,\
:b4,:b5,TO_DATE(:b6,'DD/MM/YYYY'),:b7,:b8,:b9,:b9,:b11,:b9,:b13)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )718;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_new_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_inv_start_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_prv_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_patient_name;
     sqlstm.sqhstl[3] = (unsigned int  )63;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_prv_doc_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_prv_doc_num;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_prv_ord_regd_date;
     sqlstm.sqhstl[6] = (unsigned int  )13;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_prv_request_num;
     sqlstm.sqhstl[7] = (unsigned int  )13;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_section_short_name;
     sqlstm.sqhstl[8] = (unsigned int  )18;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_sum_outst_amt_sec;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_sum_outst_amt_sec;
     sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&nd_bill_type;
     sqlstm.sqhstl[11] = (unsigned int  )5;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&nd_sum_outst_amt_sec;
     sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&nd_st_blng_grp_id;
     sqlstm.sqhstl[13] = (unsigned int  )5;
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
         err_mesg("INSERT failed on table AR_PATIENT_DTLS",0,"");
}
/******************************************************/
insert_ar_hdr()
{


if ((ar_markup_perc > 0) && (nd_sum_outst_amt > 0))
   {
     nd_markup_amt = 0;
	 nd_markup_amt = ((nd_sum_outst_amt * ar_markup_perc) / 100 );

        /* EXEC SQL INSERT INTO AR_INV_LINE
                  (
                    ACC_ENTITY_CODE,
					DOC_TYPE_CODE,
                    DOC_NUM,
                    LINE_NUM,
                    MAIN_ACC1_CODE,
                    MAIN_ACC2_CODE,
                    SUBLEDGER_GROUP_CODE,
                    SUBLEDGER_LINE_CODE,
                    DEPT_CODE,
                    PRODUCT_GROUP_CODE,
                    PRODUCT_LINE_CODE,
                    AMT_LOCAL,
                    NARRATION,
                    MAIN_ACC1_CODE_NEW,
                    MAIN_ACC2_CODE_NEW,
                    SUBLEDGER_GROUP_CODE_NEW,
                    SUBLEDGER_LINE_CODE_NEW,
                    DEPT_CODE_NEW,
                    PRODUCT_GROUP_CODE_NEW,
                    PRODUCT_LINE_CODE_NEW
                  )
                VALUES
                  (
				    :nd_acc_entity_code,
                    :nd_new_doc_type_code,             /o DOC_TYPE_CODE  o/
                    :nd_inv_start_doc_num,             /o DOC_NUM       o/
                    :d_line_num,                       /o LINE NUM       o/
                    :bl_main_acc1_code_mk_inv,            /o -------------- o/
                    :bl_main_acc2_code_mk_inv,            /o                o/
                    :bl_sublgr_grp_code_mk_inv,        /o    POSTING     o/
                    :bl_sublgr_line_code_mk_inv,       /o                o/
                    :bl_dept_code_mk_inv,              /o      A/C       o/
                    :bl_prod_grp_code_mk_inv,          /o                o/
                    :bl_prod_line_code_mk_inv,         /o -------------- o/
                    trunc(:nd_markup_amt,2),            /o AMT LOCAL      o/
                    NULL,                              /o NARRATION      o/
                    :bl_main_acc1_code_mk_inv,          /o -------------- o/
                    :bl_main_acc2_code_mk_inv,         /o                o/
                    :bl_sublgr_grp_code_mk_inv,        /o    POSTING     o/
                    :bl_sublgr_line_code_mk_inv,       /o                o/
                    :bl_dept_code_mk_inv,              /o      A/C       o/
                    :bl_prod_grp_code_mk_inv,        /o                o/
                    :bl_prod_line_code_mk_inv          /o -------------- o/
                  ); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 19;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into AR_INV_LINE (ACC_ENTITY_CODE,DOC_TYPE_COD\
E,DOC_NUM,LINE_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGE\
R_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,AMT_LOCAL,NARRATION\
,MAIN_ACC1_CODE_NEW,MAIN_ACC2_CODE_NEW,SUBLEDGER_GROUP_CODE_NEW,SUBLEDGER_LINE\
_CODE_NEW,DEPT_CODE_NEW,PRODUCT_GROUP_CODE_NEW,PRODUCT_LINE_CODE_NEW) values (\
:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,trunc(:b11,2),null ,:b4,:b5,:b6,:\
b7,:b8,:b9,:b10)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )789;
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
        sqlstm.sqhstv[1] = (         void  *)&nd_new_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_inv_start_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_line_num;
        sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&bl_main_acc1_code_mk_inv;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&bl_main_acc2_code_mk_inv;
        sqlstm.sqhstl[5] = (unsigned int  )7;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&bl_sublgr_grp_code_mk_inv;
        sqlstm.sqhstl[6] = (unsigned int  )6;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&bl_sublgr_line_code_mk_inv;
        sqlstm.sqhstl[7] = (unsigned int  )11;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&bl_dept_code_mk_inv;
        sqlstm.sqhstl[8] = (unsigned int  )13;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&bl_prod_grp_code_mk_inv;
        sqlstm.sqhstl[9] = (unsigned int  )6;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&bl_prod_line_code_mk_inv;
        sqlstm.sqhstl[10] = (unsigned int  )7;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&nd_markup_amt;
        sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&bl_main_acc1_code_mk_inv;
        sqlstm.sqhstl[12] = (unsigned int  )9;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&bl_main_acc2_code_mk_inv;
        sqlstm.sqhstl[13] = (unsigned int  )7;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&bl_sublgr_grp_code_mk_inv;
        sqlstm.sqhstl[14] = (unsigned int  )6;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&bl_sublgr_line_code_mk_inv;
        sqlstm.sqhstl[15] = (unsigned int  )11;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&bl_dept_code_mk_inv;
        sqlstm.sqhstl[16] = (unsigned int  )13;
        sqlstm.sqhsts[16] = (         int  )0;
        sqlstm.sqindv[16] = (         void  *)0;
        sqlstm.sqinds[16] = (         int  )0;
        sqlstm.sqharm[16] = (unsigned int  )0;
        sqlstm.sqadto[16] = (unsigned short )0;
        sqlstm.sqtdso[16] = (unsigned short )0;
        sqlstm.sqhstv[17] = (         void  *)&bl_prod_grp_code_mk_inv;
        sqlstm.sqhstl[17] = (unsigned int  )6;
        sqlstm.sqhsts[17] = (         int  )0;
        sqlstm.sqindv[17] = (         void  *)0;
        sqlstm.sqinds[17] = (         int  )0;
        sqlstm.sqharm[17] = (unsigned int  )0;
        sqlstm.sqadto[17] = (unsigned short )0;
        sqlstm.sqtdso[17] = (unsigned short )0;
        sqlstm.sqhstv[18] = (         void  *)&bl_prod_line_code_mk_inv;
        sqlstm.sqhstl[18] = (unsigned int  )7;
        sqlstm.sqhsts[18] = (         int  )0;
        sqlstm.sqindv[18] = (         void  *)0;
        sqlstm.sqinds[18] = (         int  )0;
        sqlstm.sqharm[18] = (unsigned int  )0;
        sqlstm.sqadto[18] = (unsigned short )0;
        sqlstm.sqtdso[18] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}





   
        if (OERROR)
            err_mesg("INSERT failed on table AR_INV_LINE - Markup",0,"");

	d_line_num++;


   }


	 /* EXEC SQL INSERT INTO AR_INV_HDR
               (
                 ACC_ENTITY_CODE,
				 OPERATING_FACILITY_ID,			//Added on 3/8/2005
				 DOC_TYPE_CODE,
                 DOC_NUM,
                 LAST_LINE_NUM,
                 CUST_CODE,
                 DOC_DATE,
                 NARRATION,
                 BASE_DATE,
                 DUE_DATE,
                 GROSS_AMT,
                 PAYABLE_AMT,
                 DISCOUNT_AMT,
                 PMNT_TERMS_CODE,
                 SETTLEMENT_DATE,
                 SETTLEMENT_PERC,
                 CUST_REF,
//                 PATIENT_ID,
//                 BILLING_GROUP,
//                 BILL_DOC_TYPE_CODE,
//                 BILL_NUM,
//                 BILL_DATE,
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
                 ERROR_FLAG,
                 PRINT_FLAG,
                 POSTED_FLAG,
                 INTERFACE_FLAG,
                 MAIN_ACC1_CODE_NEW,
                 MAIN_ACC2_CODE_NEW,
                 SUBLEDGER_GROUP_CODE_NEW,
                 SUBLEDGER_LINE_CODE_NEW,
                 DEPT_CODE_NEW,
                 PRODUCT_GROUP_CODE_NEW,
                 PRODUCT_LINE_CODE_NEW,
//                 BILL_TYPE_CODE,
				 LAB_INVOICE_YN,
				 MODULE_ID,              
				 CONSOLIDATED_INV_YN,    
				 MARKUP_AMT,             
				 ADDED_BY_ID,            
				 MODIFIED_BY_ID,         
				 ADDED_DATE,             
				 MODIFIED_DATE          
               )
              VALUES
               (
                 :nd_acc_entity_code,             /o ACC ENTITY CODE o/
				 :nd_facility_id,
				 :nd_new_doc_type_code,             /o DOC_TYPE_CODE o/
                 :nd_inv_start_doc_num,             /o DOC_NUM       o/
                 1,                                 /o LAST LINE NUM o/
                 :d_prv_cust_code,                  /o CUST CODE     o/
                 to_date(:nd_inv_date,'dd/mm/yyyy'),   /o DOC DATE      o/
                 NULL,                              /o NARRATION     o/
                 to_date(:nd_inv_date,'dd/mm/yyyy'), /o DOC DATE      o/
                 to_date(:nd_inv_date,'dd/mm/yyyy') + :ar_pmnt_cred_days_period, 
				                  /oDUE DATEo/
                 :nd_sum_outst_amt,                 /o GROSS AMT     o/
                 :nd_sum_outst_amt + trunc(:nd_markup_amt,2), 
				 /o PAYABLE AMT   o/
                 0,                                 /o DISCOUNT AMT  o/
                 :bl_cust_pmnt_terms_code,          /o PMNT TERMS    o/
                 to_date(:nd_inv_date,'dd/mm/yyyy') + :ar_pmnt_settl_days_period,
									 /oSTLMT DTo/
                 :ar_pmnt_settl_percent,           /o SETTLEMENT PERCo/
                 :nd_credit_ref,                   /o CUST REF       o/
//                 :nd_st_patient_id,                /o PATIENT ID     o/
//                 :nd_st_blng_grp_id,               /o BILLING GROUP  o/
//                 :nd_st_doc_type_code,             /o BILL DOC TYPE CODE o/
//                 :nd_st_doc_num,                   /o BILL NUM       o/
//                 to_date(:nd_inv_date,'dd/mm/yyyy'),                    
													 /o BILL DATE      o/
                 :nd_sum_drfee_amt,                /o DOCTOR FEE AMT o/
                 :ar_rec_main_acc1_code,           /o -------------- o/
                 :ar_rec_main_acc2_code,           /o                o/
                 :ar_rec_subledger_group_code,     /o    POSTING     o/
                 :ar_rec_subledger_line_code,      /o                o/
                 :ar_rec_dept_code,                /o      A/C       o/
                 :ar_rec_product_group_code,       /o                o/
                 :ar_rec_product_line_code,        /o -------------- o/
                 :bl_par_post_month,               /o POST MONTH     o/
                 :bl_par_post_year,                /o POST YEAR      o/
                 NULL,                             /o ERROR FLAG     o/
                 'N',                              /o PRINT FLAG     o/
                 NULL,                             /o POSTED FLAG    o/
                 NULL,                             /o INTERFACE FLAG o/
                 :ar_rec_main_acc1_code,           /o -------------- o/
                 :ar_rec_main_acc2_code,           /o                o/
                 :ar_rec_subledger_group_code,     /o    POSTING     o/
                 :ar_rec_subledger_line_code,      /o                o/
                 :ar_rec_dept_code,                /o      A/C       o/
                 :ar_rec_product_group_code,       /o                o/
                 :ar_rec_product_line_code,        /o -------------- o/
//                 :nd_bill_type,                    /o BILL TYPE CODE o/
				 'Y',                               /o LAB INVOICE YN o/
                 'RL',
				 'N',
                 trunc(:nd_markup_amt,2),
                 user,
                 user,
                 sysdate,
                 sysdate   
               ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 35;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "insert into AR_INV_HDR (ACC_ENTITY_CODE,OPERATING_FACILITY_ID,DOC_TYPE_\
CODE,DOC_NUM,LAST_LINE_NUM,CUST_CODE,DOC_DATE,NARRATION,BASE_DATE,DUE_DATE,G\
ROSS_AMT,PAYABLE_AMT,DISCOUNT_AMT,PMNT_TERMS_CODE,SETTLEMENT_DATE,SETTLEMENT\
_PERC,CUST_REF,DOCTOR_FEE_AMT,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_\
CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,POST\
_MONTH,POST_YEAR,ERROR_FLAG,PRINT_FLAG,POSTED_FLAG,INTERFACE_FLAG,MAIN_ACC1_\
CODE_NEW,MAIN_ACC2_CODE_NEW,SUBLEDGER_GROUP_CODE_NEW,SUBLEDGER_LINE_CODE_NEW\
,DEPT_CODE_NEW,PRODUCT_GROUP_CODE_NEW,PRODUCT_LINE_CODE_NEW,LAB_INVOICE_YN,M\
ODULE_ID,CONSOLIDATED_INV_YN,MARKUP_AMT,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DAT\
E,MODIFIED_DATE) values (:b0,:b1,:b2,:b3,1,:b4,to_date(:b5,'dd/mm/yyyy'),nul\
l ,to_date(:b5,'dd/mm/yyyy'),(to_date(:b5,'dd/mm/yyyy')+:b8),:b9,(:b9+trunc(\
:b11,2)),0,:b12,(to_date(:b5,'dd/mm/yyyy')+:b14),:b15,:b16,:b17,:b18,:b19,:b\
20,:b21,:b22,:b23,:b24,:b25,:b26,null ,'N',null ,null ,:b18,:b19,:b20,:b21,:\
b22,:b23,:b24,'Y','RL','N',trunc(:b11,2),");
  sqlstm.stmt = "user,user,sysdate,sysdate)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )880;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_new_doc_type_code;
  sqlstm.sqhstl[2] = (unsigned int  )9;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_inv_start_doc_num;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_prv_cust_code;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_inv_date;
  sqlstm.sqhstl[5] = (unsigned int  )14;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_inv_date;
  sqlstm.sqhstl[6] = (unsigned int  )14;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_inv_date;
  sqlstm.sqhstl[7] = (unsigned int  )14;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&ar_pmnt_cred_days_period;
  sqlstm.sqhstl[8] = (unsigned int  )6;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_sum_outst_amt;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_sum_outst_amt;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_markup_amt;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&bl_cust_pmnt_terms_code;
  sqlstm.sqhstl[12] = (unsigned int  )5;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_inv_date;
  sqlstm.sqhstl[13] = (unsigned int  )14;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&ar_pmnt_settl_days_period;
  sqlstm.sqhstl[14] = (unsigned int  )6;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&ar_pmnt_settl_percent;
  sqlstm.sqhstl[15] = (unsigned int  )11;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_credit_ref;
  sqlstm.sqhstl[16] = (unsigned int  )18;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_sum_drfee_amt;
  sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&ar_rec_main_acc1_code;
  sqlstm.sqhstl[18] = (unsigned int  )9;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&ar_rec_main_acc2_code;
  sqlstm.sqhstl[19] = (unsigned int  )7;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&ar_rec_subledger_group_code;
  sqlstm.sqhstl[20] = (unsigned int  )6;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqhstv[21] = (         void  *)&ar_rec_subledger_line_code;
  sqlstm.sqhstl[21] = (unsigned int  )11;
  sqlstm.sqhsts[21] = (         int  )0;
  sqlstm.sqindv[21] = (         void  *)0;
  sqlstm.sqinds[21] = (         int  )0;
  sqlstm.sqharm[21] = (unsigned int  )0;
  sqlstm.sqadto[21] = (unsigned short )0;
  sqlstm.sqtdso[21] = (unsigned short )0;
  sqlstm.sqhstv[22] = (         void  *)&ar_rec_dept_code;
  sqlstm.sqhstl[22] = (unsigned int  )13;
  sqlstm.sqhsts[22] = (         int  )0;
  sqlstm.sqindv[22] = (         void  *)0;
  sqlstm.sqinds[22] = (         int  )0;
  sqlstm.sqharm[22] = (unsigned int  )0;
  sqlstm.sqadto[22] = (unsigned short )0;
  sqlstm.sqtdso[22] = (unsigned short )0;
  sqlstm.sqhstv[23] = (         void  *)&ar_rec_product_group_code;
  sqlstm.sqhstl[23] = (unsigned int  )6;
  sqlstm.sqhsts[23] = (         int  )0;
  sqlstm.sqindv[23] = (         void  *)0;
  sqlstm.sqinds[23] = (         int  )0;
  sqlstm.sqharm[23] = (unsigned int  )0;
  sqlstm.sqadto[23] = (unsigned short )0;
  sqlstm.sqtdso[23] = (unsigned short )0;
  sqlstm.sqhstv[24] = (         void  *)&ar_rec_product_line_code;
  sqlstm.sqhstl[24] = (unsigned int  )7;
  sqlstm.sqhsts[24] = (         int  )0;
  sqlstm.sqindv[24] = (         void  *)0;
  sqlstm.sqinds[24] = (         int  )0;
  sqlstm.sqharm[24] = (unsigned int  )0;
  sqlstm.sqadto[24] = (unsigned short )0;
  sqlstm.sqtdso[24] = (unsigned short )0;
  sqlstm.sqhstv[25] = (         void  *)&bl_par_post_month;
  sqlstm.sqhstl[25] = (unsigned int  )5;
  sqlstm.sqhsts[25] = (         int  )0;
  sqlstm.sqindv[25] = (         void  *)0;
  sqlstm.sqinds[25] = (         int  )0;
  sqlstm.sqharm[25] = (unsigned int  )0;
  sqlstm.sqadto[25] = (unsigned short )0;
  sqlstm.sqtdso[25] = (unsigned short )0;
  sqlstm.sqhstv[26] = (         void  *)&bl_par_post_year;
  sqlstm.sqhstl[26] = (unsigned int  )7;
  sqlstm.sqhsts[26] = (         int  )0;
  sqlstm.sqindv[26] = (         void  *)0;
  sqlstm.sqinds[26] = (         int  )0;
  sqlstm.sqharm[26] = (unsigned int  )0;
  sqlstm.sqadto[26] = (unsigned short )0;
  sqlstm.sqtdso[26] = (unsigned short )0;
  sqlstm.sqhstv[27] = (         void  *)&ar_rec_main_acc1_code;
  sqlstm.sqhstl[27] = (unsigned int  )9;
  sqlstm.sqhsts[27] = (         int  )0;
  sqlstm.sqindv[27] = (         void  *)0;
  sqlstm.sqinds[27] = (         int  )0;
  sqlstm.sqharm[27] = (unsigned int  )0;
  sqlstm.sqadto[27] = (unsigned short )0;
  sqlstm.sqtdso[27] = (unsigned short )0;
  sqlstm.sqhstv[28] = (         void  *)&ar_rec_main_acc2_code;
  sqlstm.sqhstl[28] = (unsigned int  )7;
  sqlstm.sqhsts[28] = (         int  )0;
  sqlstm.sqindv[28] = (         void  *)0;
  sqlstm.sqinds[28] = (         int  )0;
  sqlstm.sqharm[28] = (unsigned int  )0;
  sqlstm.sqadto[28] = (unsigned short )0;
  sqlstm.sqtdso[28] = (unsigned short )0;
  sqlstm.sqhstv[29] = (         void  *)&ar_rec_subledger_group_code;
  sqlstm.sqhstl[29] = (unsigned int  )6;
  sqlstm.sqhsts[29] = (         int  )0;
  sqlstm.sqindv[29] = (         void  *)0;
  sqlstm.sqinds[29] = (         int  )0;
  sqlstm.sqharm[29] = (unsigned int  )0;
  sqlstm.sqadto[29] = (unsigned short )0;
  sqlstm.sqtdso[29] = (unsigned short )0;
  sqlstm.sqhstv[30] = (         void  *)&ar_rec_subledger_line_code;
  sqlstm.sqhstl[30] = (unsigned int  )11;
  sqlstm.sqhsts[30] = (         int  )0;
  sqlstm.sqindv[30] = (         void  *)0;
  sqlstm.sqinds[30] = (         int  )0;
  sqlstm.sqharm[30] = (unsigned int  )0;
  sqlstm.sqadto[30] = (unsigned short )0;
  sqlstm.sqtdso[30] = (unsigned short )0;
  sqlstm.sqhstv[31] = (         void  *)&ar_rec_dept_code;
  sqlstm.sqhstl[31] = (unsigned int  )13;
  sqlstm.sqhsts[31] = (         int  )0;
  sqlstm.sqindv[31] = (         void  *)0;
  sqlstm.sqinds[31] = (         int  )0;
  sqlstm.sqharm[31] = (unsigned int  )0;
  sqlstm.sqadto[31] = (unsigned short )0;
  sqlstm.sqtdso[31] = (unsigned short )0;
  sqlstm.sqhstv[32] = (         void  *)&ar_rec_product_group_code;
  sqlstm.sqhstl[32] = (unsigned int  )6;
  sqlstm.sqhsts[32] = (         int  )0;
  sqlstm.sqindv[32] = (         void  *)0;
  sqlstm.sqinds[32] = (         int  )0;
  sqlstm.sqharm[32] = (unsigned int  )0;
  sqlstm.sqadto[32] = (unsigned short )0;
  sqlstm.sqtdso[32] = (unsigned short )0;
  sqlstm.sqhstv[33] = (         void  *)&ar_rec_product_line_code;
  sqlstm.sqhstl[33] = (unsigned int  )7;
  sqlstm.sqhsts[33] = (         int  )0;
  sqlstm.sqindv[33] = (         void  *)0;
  sqlstm.sqinds[33] = (         int  )0;
  sqlstm.sqharm[33] = (unsigned int  )0;
  sqlstm.sqadto[33] = (unsigned short )0;
  sqlstm.sqtdso[33] = (unsigned short )0;
  sqlstm.sqhstv[34] = (         void  *)&nd_markup_amt;
  sqlstm.sqhstl[34] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[34] = (         int  )0;
  sqlstm.sqindv[34] = (         void  *)0;
  sqlstm.sqinds[34] = (         int  )0;
  sqlstm.sqharm[34] = (unsigned int  )0;
  sqlstm.sqadto[34] = (unsigned short )0;
  sqlstm.sqtdso[34] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




     

     if (OERROR)
         err_mesg("INSERT failed on table AR_INV_HDR",0,"");

	 ar_markup_perc = 0;
	 nd_markup_amt = 0;

}



/*********************************************************/

insert_ar_line()
{

    /* EXEC SQL UPDATE AR_INV_LINE
		SET AMT_LOCAL = NVL(AMT_LOCAL,0) + 
                                NVL(:nd_ar_inv_line_amt,0)
	      WHERE DOC_TYPE_CODE         = :nd_new_doc_type_code
				AND DOC_NUM               = :nd_inv_start_doc_num
                AND MAIN_ACC1_CODE        = :bl_rec_main_acc1_code
                AND MAIN_ACC2_CODE        = :bl_rec_main_acc2_code
                AND SUBLEDGER_GROUP_CODE  = :bl_rec_subledger_group_code
                AND SUBLEDGER_LINE_CODE   = :bl_rec_subledger_line_code
                AND DEPT_CODE             = :bl_rec_dept_code
                AND PRODUCT_GROUP_CODE    = :bl_rec_product_group_code
                AND PRODUCT_LINE_CODE     = :bl_rec_product_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_INV_LINE  set AMT_LOCAL=(NVL(AMT_LOCAL,0)+NVL(:\
b0,0)) where ((((((((DOC_TYPE_CODE=:b1 and DOC_NUM=:b2) and MAIN_ACC1_CODE=:b3\
) and MAIN_ACC2_CODE=:b4) and SUBLEDGER_GROUP_CODE=:b5) and SUBLEDGER_LINE_COD\
E=:b6) and DEPT_CODE=:b7) and PRODUCT_GROUP_CODE=:b8) and PRODUCT_LINE_CODE=:b\
9)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1035;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ar_inv_line_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_new_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_inv_start_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_rec_main_acc1_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_rec_main_acc2_code;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_rec_subledger_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_rec_subledger_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bl_rec_dept_code;
    sqlstm.sqhstl[7] = (unsigned int  )13;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bl_rec_product_group_code;
    sqlstm.sqhstl[8] = (unsigned int  )6;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&bl_rec_product_line_code;
    sqlstm.sqhstl[9] = (unsigned int  )7;
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



    if(OERROR)
	err_mesg("UPDATE failed on table AR_INV_LINE",0,"");

    /* if no data has been updated then insert new record */

    if(!sqlca.sqlerrd[2]) {
	     
        /* EXEC SQL INSERT INTO AR_INV_LINE
                  (
                    ACC_ENTITY_CODE,
					DOC_TYPE_CODE,
                    DOC_NUM,
                    LINE_NUM,
                    MAIN_ACC1_CODE,
                    MAIN_ACC2_CODE,
                    SUBLEDGER_GROUP_CODE,
                    SUBLEDGER_LINE_CODE,
                    DEPT_CODE,
                    PRODUCT_GROUP_CODE,
                    PRODUCT_LINE_CODE,
                    AMT_LOCAL,
                    NARRATION,
                    MAIN_ACC1_CODE_NEW,
                    MAIN_ACC2_CODE_NEW,
                    SUBLEDGER_GROUP_CODE_NEW,
                    SUBLEDGER_LINE_CODE_NEW,
                    DEPT_CODE_NEW,
                    PRODUCT_GROUP_CODE_NEW,
                    PRODUCT_LINE_CODE_NEW
                  )
                VALUES
                  (
				    :nd_acc_entity_code,
                    :nd_new_doc_type_code,             /o DOC_TYPE_CODE  o/
                    :nd_inv_start_doc_num,             /o DOC_NUM       o/
                    :d_line_num,                       /o LINE NUM       o/
                    :bl_rec_main_acc1_code,            /o -------------- o/
                    :bl_rec_main_acc2_code,            /o                o/
                    :bl_rec_subledger_group_code,      /o    POSTING     o/
                    :bl_rec_subledger_line_code,       /o                o/
                    :bl_rec_dept_code,                 /o      A/C       o/
                    :bl_rec_product_group_code,        /o                o/
                    :bl_rec_product_line_code,         /o -------------- o/
                    NVL(:nd_ar_inv_line_amt,0),        /o AMT LOCAL      o/
                    NULL,                              /o NARRATION      o/
                    :bl_rec_main_acc1_code,            /o -------------- o/
                    :bl_rec_main_acc2_code,            /o                o/
                    :bl_rec_subledger_group_code,      /o    POSTING     o/
                    :bl_rec_subledger_line_code,       /o                o/
                    :bl_rec_dept_code,                 /o      A/C       o/
                    :bl_rec_product_group_code,        /o                o/
                    :bl_rec_product_line_code          /o -------------- o/
                  ); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 35;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into AR_INV_LINE (ACC_ENTITY_CODE,DOC_TYPE_COD\
E,DOC_NUM,LINE_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGE\
R_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,AMT_LOCAL,NARRATION\
,MAIN_ACC1_CODE_NEW,MAIN_ACC2_CODE_NEW,SUBLEDGER_GROUP_CODE_NEW,SUBLEDGER_LINE\
_CODE_NEW,DEPT_CODE_NEW,PRODUCT_GROUP_CODE_NEW,PRODUCT_LINE_CODE_NEW) values (\
:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,NVL(:b11,0),null ,:b4,:b5,:b6,:b7\
,:b8,:b9,:b10)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1090;
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
        sqlstm.sqhstv[1] = (         void  *)&nd_new_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_inv_start_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_line_num;
        sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&bl_rec_main_acc1_code;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&bl_rec_main_acc2_code;
        sqlstm.sqhstl[5] = (unsigned int  )7;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&bl_rec_subledger_group_code;
        sqlstm.sqhstl[6] = (unsigned int  )6;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&bl_rec_subledger_line_code;
        sqlstm.sqhstl[7] = (unsigned int  )11;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&bl_rec_dept_code;
        sqlstm.sqhstl[8] = (unsigned int  )13;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&bl_rec_product_group_code;
        sqlstm.sqhstl[9] = (unsigned int  )6;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&bl_rec_product_line_code;
        sqlstm.sqhstl[10] = (unsigned int  )7;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&nd_ar_inv_line_amt;
        sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&bl_rec_main_acc1_code;
        sqlstm.sqhstl[12] = (unsigned int  )9;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&bl_rec_main_acc2_code;
        sqlstm.sqhstl[13] = (unsigned int  )7;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&bl_rec_subledger_group_code;
        sqlstm.sqhstl[14] = (unsigned int  )6;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&bl_rec_subledger_line_code;
        sqlstm.sqhstl[15] = (unsigned int  )11;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&bl_rec_dept_code;
        sqlstm.sqhstl[16] = (unsigned int  )13;
        sqlstm.sqhsts[16] = (         int  )0;
        sqlstm.sqindv[16] = (         void  *)0;
        sqlstm.sqinds[16] = (         int  )0;
        sqlstm.sqharm[16] = (unsigned int  )0;
        sqlstm.sqadto[16] = (unsigned short )0;
        sqlstm.sqtdso[16] = (unsigned short )0;
        sqlstm.sqhstv[17] = (         void  *)&bl_rec_product_group_code;
        sqlstm.sqhstl[17] = (unsigned int  )6;
        sqlstm.sqhsts[17] = (         int  )0;
        sqlstm.sqindv[17] = (         void  *)0;
        sqlstm.sqinds[17] = (         int  )0;
        sqlstm.sqharm[17] = (unsigned int  )0;
        sqlstm.sqadto[17] = (unsigned short )0;
        sqlstm.sqtdso[17] = (unsigned short )0;
        sqlstm.sqhstv[18] = (         void  *)&bl_rec_product_line_code;
        sqlstm.sqhstl[18] = (unsigned int  )7;
        sqlstm.sqhsts[18] = (         int  )0;
        sqlstm.sqindv[18] = (         void  *)0;
        sqlstm.sqinds[18] = (         int  )0;
        sqlstm.sqharm[18] = (unsigned int  )0;
        sqlstm.sqadto[18] = (unsigned short )0;
        sqlstm.sqtdso[18] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   
        if (OERROR)
            err_mesg("INSERT failed on table AR_INV_LINE",0,"");

	d_line_num++;
    }

}

update_hdr()
{

    /* EXEC SQL UPDATE RL_REQUEST_HEADER
		SET INVOICED_YN = 'Y'
	      WHERE ROWID       = :d_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update RL_REQUEST_HEADER  set INVOICED_YN='Y' where ROWID\
=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1181;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )28;
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
	err_mesg("UPDATE failed on table RL_REQ_HDR",0,"");

}

sql_connect(l_uid_pwd)
char l_uid_pwd[];
{

  strcpy(d_uid_pwd.arr,l_uid_pwd);
  d_uid_pwd.len = strlen(d_uid_pwd.arr);

  /* EXEC SQL CONNECT :d_uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 35;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )1200;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )53;
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
