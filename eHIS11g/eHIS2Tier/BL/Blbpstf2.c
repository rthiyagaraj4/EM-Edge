
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blbpstf2.pc"
};


static unsigned int sqlctx = 1288464587;


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
            void  *sqhstv[80];
   unsigned int   sqhstl[80];
            int   sqhsts[80];
            void  *sqindv[80];
            int   sqinds[80];
   unsigned int   sqharm[80];
   unsigned int   *sqharc[80];
   unsigned short  sqadto[80];
   unsigned short  sqtdso[80];
} sqlstm = {12,80};

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

 static const char *sq0009 = 
"ING_FACILITY_ID=:b1) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) an\
d A.PACKAGE_BILL_DOC_TYPE=B.PACKAGE_BILL_DOC_TYPE) and A.PACKAGE_BILL_DOC_NUM=\
B.PACKAGE_BILL_DOC_NUM) and TRUNC(A.PACKAGE_BILL_DATE)=TRUNC(B.PACKAGE_BILL_DA\
TE)) and TRX_FINALIZE_IND='Y') order by A.TRX_DOC_REF,A.PACKAGE_IND,A.PACKAGE_\
SERVICE_CODE,A.BLNG_SERV_CODE,A.ACCT_DEPT_CODE            ";

 static const char *sq0012 = 
"select BL_RECV_ACC_INT_CODE  from BL_BILL_TYPE where (BILL_TYPE_CODE=:b0 and\
 ACC_ENTITY_CODE in (select acc_entity_code  from sy_acc_entity where acc_enti\
ty_id=:b1))           ";

 static const char *sq0013 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DECODE(DEPT_CODE,'X',:b0,DEPT_CODE) ,\
SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CO\
DE  from BL_GL_ACCOUNT where (ACC_INT_CODE=:b1 and ACC_ENTITY_CODE in (select \
acc_entity_code  from sy_acc_entity where acc_entity_id=:b2))           ";

 static const char *sq0011 = 
"select BL_PKG_CTRL_ACC_INT_CODE  from BL_BILL_TYPE where (BILL_TYPE_CODE=:b0\
 and ACC_ENTITY_CODE in (select acc_entity_code  from sy_acc_entity where acc_\
entity_id=:b1))           ";

 static const char *sq0010 = 
"select BL_PKG_CTRL_ACC_INT_CODE  from BL_BILL_TYPE where (BILL_TYPE_CODE=:b0\
 and ACC_ENTITY_CODE in (select acc_entity_code  from sy_acc_entity where acc_\
entity_id=:b1))           ";

 static const char *sq0014 = 
"select ROWID  from BL_PACKAGE_CHARGES_FOLIO where ((((TRX_DOC_REF=:b0 and NV\
L(TRX_POSTED_IND,'N')='N') and TRX_DATE<=TO_DATE((:b1||' 23:59'),'DD/MM/YYYY H\
H24:MI')) and NVL(TRX_FINALIZE_IND,'N')='Y') and OPERATING_FACILITY_ID=:b2) fo\
r update of TRX_DOC_REF nowait ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,238,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,22,0,1,326,0,0,0,0,0,1,0,
51,0,0,3,0,0,29,372,0,0,0,0,0,1,0,
66,0,0,4,278,0,5,382,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
105,0,0,5,0,0,30,391,0,0,0,0,0,1,0,
120,0,0,6,101,0,4,404,0,0,2,1,0,1,0,2,1,0,0,1,9,0,0,
143,0,0,7,155,0,4,421,0,0,7,4,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
186,0,0,8,279,0,4,444,0,0,8,1,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,1,0,0,2,
1,0,0,2,1,0,0,1,9,0,0,
233,0,0,9,2416,0,9,635,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
256,0,0,9,0,0,13,788,0,0,80,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
591,0,0,12,176,0,9,959,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
614,0,0,12,0,0,13,966,0,0,1,0,0,1,0,2,9,0,0,
633,0,0,13,304,0,9,982,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
660,0,0,13,0,0,13,1002,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
703,0,0,11,180,0,9,1034,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
726,0,0,11,0,0,13,1041,0,0,1,0,0,1,0,2,9,0,0,
745,0,0,13,304,0,9,1058,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
772,0,0,13,0,0,13,1078,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
815,0,0,10,180,0,9,1106,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
838,0,0,10,0,0,13,1110,0,0,1,0,0,1,0,2,9,0,0,
857,0,0,13,304,0,9,1128,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
884,0,0,13,0,0,13,1148,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
927,0,0,15,244,0,4,1195,0,0,5,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
962,0,0,16,925,0,3,1207,0,0,27,27,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
1085,0,0,17,933,0,3,1297,0,0,27,27,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
1208,0,0,18,244,0,4,1407,0,0,5,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1243,0,0,19,925,0,3,1417,0,0,27,27,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
1366,0,0,20,30,0,43,1512,0,0,0,0,0,1,0,
1381,0,0,21,445,0,5,1519,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1416,0,0,14,263,0,9,1541,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1443,0,0,22,0,0,29,1590,0,0,0,0,0,1,0,
1458,0,0,23,22,0,1,1599,0,0,0,0,0,1,0,
1473,0,0,24,561,0,5,1745,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
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

    /* VARCHAR hosp_name                                  [120],
			date_time                                  [20],
			user_id                                    [40],
			uid_pwd      							  [132],
			nd_session_id                              [16],
			nd_pgm_date                                [25],
			d_curr_pgm_name                            [15],
			nd_post_upto_date                          [11],	  
			nd_doc_type				       [8],
			nd_doc_num				       [30],
			nd_doc_date				       [31],
			cpatdoctypecode			       [7],
			cpatdocnum                     [30],
			cpatdocdate				       [13],
			nd_pre_doc_type			       [8],
			nd_pre_doc_num			       [30],
			nd_pre_doc_date			       [31],
			nd_cust_code			       [9],
			nd_pre_cust_code		               [9],
			nd_post_year				[5],
			nd_post_month				[3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[11]; } nd_post_upto_date;

struct { unsigned short len; unsigned char arr[8]; } nd_doc_type;

struct { unsigned short len; unsigned char arr[30]; } nd_doc_num;

struct { unsigned short len; unsigned char arr[31]; } nd_doc_date;

struct { unsigned short len; unsigned char arr[7]; } cpatdoctypecode;

struct { unsigned short len; unsigned char arr[30]; } cpatdocnum;

struct { unsigned short len; unsigned char arr[13]; } cpatdocdate;

struct { unsigned short len; unsigned char arr[8]; } nd_pre_doc_type;

struct { unsigned short len; unsigned char arr[30]; } nd_pre_doc_num;

struct { unsigned short len; unsigned char arr[31]; } nd_pre_doc_date;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_pre_cust_code;

struct { unsigned short len; unsigned char arr[5]; } nd_post_year;

struct { unsigned short len; unsigned char arr[3]; } nd_post_month;



   /* VARCHAR bl_pat_trx_doc_ref                          [21],
		   bl_pat_trx_doc_ref_line_num                 [5],
		   bl_pat_trx_doc_ref_seq_num                  [5],
		   bl_pat_trx_date                             [13],
		   bl_pat_episode_type                         [2],
		   bl_pat_patient_id                           [21],
		   bl_pat_episode_id                           [9],
		   bl_pat_visit_id                             [5],
		   bl_pat_billed_flag                          [2],
		   bl_pat_settlement_ind                       [2],
		   nd_reason_text			       [51],
		   nd_cash_counter_code                        [7],
		   nd_shift_id				       [2],
		   d_orig_dept_code                            [7],
		   d_bed_class_code                            [3],
		   bl_pat_prt_grp_hdr_code                     [3],
		   bl_pat_prt_grp_line_code                    [3],
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
		   bl_pat_acct_dept_code                       [7],
		   bl_pat_orig_dept_code                       [7],
		   bl_pat_physician_id                         [16],
		   bl_pat_blng_grp_id                          [3],
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

		   bl_store_trx_date                           [13],
		   bl_store_episode_type                       [2],
		   bl_store_patient_id                         [21],
		   bl_store_episode_id                         [9],
		   bl_store_visit_id                           [5],

		   bl_store_trx_doc_ref                        [21],

		   store_concat_code                           [16],
		   store_acct_dept_code                        [7]; */ 
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

struct { unsigned short len; unsigned char arr[51]; } nd_reason_text;

struct { unsigned short len; unsigned char arr[7]; } nd_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } nd_shift_id;

struct { unsigned short len; unsigned char arr[7]; } d_orig_dept_code;

struct { unsigned short len; unsigned char arr[3]; } d_bed_class_code;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_prt_grp_line_code;

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

struct { unsigned short len; unsigned char arr[7]; } bl_pat_acct_dept_code;

struct { unsigned short len; unsigned char arr[7]; } bl_pat_orig_dept_code;

struct { unsigned short len; unsigned char arr[16]; } bl_pat_physician_id;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_blng_grp_id;

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

struct { unsigned short len; unsigned char arr[13]; } bl_store_trx_date;

struct { unsigned short len; unsigned char arr[2]; } bl_store_episode_type;

struct { unsigned short len; unsigned char arr[21]; } bl_store_patient_id;

struct { unsigned short len; unsigned char arr[9]; } bl_store_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_store_visit_id;

struct { unsigned short len; unsigned char arr[21]; } bl_store_trx_doc_ref;

struct { unsigned short len; unsigned char arr[16]; } store_concat_code;

struct { unsigned short len; unsigned char arr[7]; } store_acct_dept_code;


/* VARCHAR    bl_dept_main_acc1_code                      [7],
		   bl_dept_main_acc2_code                      [5],
		   bl_dept_dept_code                           [7],
		   bl_dept_subledger_group_code                [4],
		   bl_dept_subledger_line_code                 [9],
		   bl_dept_product_group_code                  [4],
		   bl_dept_product_line_code                   [5],

		   bl_pkg1_main_acc1_code                      [7],
		   bl_pkg1_main_acc2_code                      [5],
		   bl_pkg1_dept_code                           [7],
		   bl_pkg1_subledger_group_code                [4],
		   bl_pkg1_subledger_line_code                 [9],
		   bl_pkg1_product_group_code                  [4],
		   bl_pkg1_product_line_code                   [5],

		   bl_pkg2_main_acc1_code                      [7],
		   bl_pkg2_main_acc2_code                      [5],
		   bl_pkg2_dept_code                           [7],
		   bl_pkg2_subledger_group_code                [4],
		   bl_pkg2_subledger_line_code                 [9],
		   bl_pkg2_product_group_code                  [4],
		   bl_pkg2_product_line_code                   [5],
		   nd_operating_facility_id					[3],
		   nd_ws_no									[31],

		   bl_acc_int_code                          [7]; */ 
struct { unsigned short len; unsigned char arr[7]; } bl_dept_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_dept_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } bl_dept_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_dept_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_dept_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_dept_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_dept_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } bl_pkg1_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pkg1_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } bl_pkg1_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pkg1_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_pkg1_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pkg1_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pkg1_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } bl_pkg2_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pkg2_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } bl_pkg2_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pkg2_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_pkg2_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pkg2_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pkg2_product_line_code;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[7]; } bl_acc_int_code;


/* VARCHAR    d_hdr_upd_rowid							[20],
           d_lin_upd_rowid            				[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } d_hdr_upd_rowid;

struct { unsigned short len; unsigned char arr[20]; } d_lin_upd_rowid;


    int    bl_pat_serv_mth,
		   bl_pat_serv_yr;

    int    bl_mth,
		   bl_yr,
		   cur_mth,
		   cur_yr,
		   nd_month,
		   nd_year;

   double  bl_tot_gross_charge_amt = 0,
		   bl_tot_disc_amt = 0,
		   bl_tot_net_charge_amt = 0;

    char   d_ip_gl_yn,
			nd_cash_control_use_flag,
		   d_op_gl_yn,
		   d_rf_gl_yn;

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





#include <winproc.h>

int rec_ctr = 0, err_ctr = 0;
char msg_str[132];

char prv_trx_ref[21];

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

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   /* EXEC SQL CONNECT :uid_pwd; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )5;
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
        upd_reasons_in_pack_folio_for_unposting();

        if (nd_reason_text.arr[0] != '\0')
			continue;
           
		if(skip_rec && !strcmp(prv_trx_ref, bl_pat_trx_doc_ref.arr))
			continue;

		if(strcmp(prv_trx_ref, bl_pat_trx_doc_ref.arr)) 
		{

			/* Check if all records for the trx_doc_ref can be locked    */
			/* If not the skip all those trx_doc_ref                     */
			strcpy(prv_trx_ref,bl_pat_trx_doc_ref.arr);

			if(!lock_trx_ref())
				skip_rec = 1;
			else 
				skip_rec = 0;

			if(skip_rec)
				continue;
		}

		strcpy(prv_trx_ref,bl_pat_trx_doc_ref.arr);

		/************ ADDED NK 01/02/94 **************
		if(bl_pat_package_trx_ind.arr[0] == 'Y')
			updt_pkg_inc();

		if(bl_pat_package_trx_ind.arr[0] == 'N')
			updt_srv_inc();

		*********************************************/

		//if(bl_pat_package_trx_ind.arr[0] == 'N') 
		if(bl_pat_package_trx_ind.arr[0] == 'Y') 
		{
			/*if (!lock_record())
				continue;
			*/

			if (!rec_ctr)
			{
				/* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "savepoint LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
				if(OERROR)
					err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 
			}

			rec_ctr++;

			if ((rec_ctr == 1)||(strcmp(bl_store_trx_doc_ref.arr,bl_pat_trx_doc_ref.arr)))
			{
				trx_ref_break();
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
			bl_tot_disc_amt += atof(bl_pat_adj_disc_amt.arr);
			bl_tot_net_charge_amt += atof(bl_pat_adj_net_charge_amt.arr);
		}
        
		strcpy(nd_pre_doc_type.arr,nd_doc_type.arr);
	    nd_pre_doc_type.len = strlen(nd_pre_doc_type.arr);
        strcpy(nd_pre_doc_num.arr,nd_doc_num.arr);
	    nd_pre_doc_num.len = strlen(nd_pre_doc_num.arr);
        strcpy(nd_pre_doc_date.arr,nd_doc_date.arr);
	    nd_pre_doc_date.len = strlen(nd_pre_doc_date.arr);
        strcpy(nd_pre_cust_code.arr,nd_cust_code.arr);
	    nd_pre_cust_code.len = strlen(nd_pre_cust_code.arr);
    }

    if (rec_ctr)
    {
		if (!err_ctr)
		{
			create_bl_gl_dist_dept();
			create_bl_gl_dist_trx_ref();
			upd_pat_chg_folio();
			
			/* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
				SET LAST_FOLIO_POST_DATE	= TO_DATE(:nd_post_upto_date,'DD/MM/YYYY'),
					MODIFIED_BY_ID			= USER,  
					MODIFIED_DATE			= SYSDATE, 	
					MODIFIED_AT_WS_NO		= :nd_ws_no,  
					MODIFIED_FACILITY_ID	= :nd_operating_facility_id  
			  WHERE NVL(LAST_FOLIO_POST_DATE,TO_DATE(:nd_post_upto_date,'DD/MM/YYYY')) <=  TO_DATE(:nd_post_upto_date,'DD/MM/YYYY')
				AND OPERATING_FACILITY_ID	= :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_PARAMETERS  set LAST_FOLIO_POST_DATE=TO_DATE(:b\
0,'DD/MM/YYYY'),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b\
1,MODIFIED_FACILITY_ID=:b2 where (NVL(LAST_FOLIO_POST_DATE,TO_DATE(:b0,'DD/MM/\
YYYY'))<=TO_DATE(:b0,'DD/MM/YYYY') and OPERATING_FACILITY_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )66;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_post_upto_date;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_post_upto_date;
    sqlstm.sqhstl[4] = (unsigned int  )13;
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



	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )105;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	if (OERROR)
		err_mesg("COMMIT WORK RELEASE failed REA",0,"");

    return;
}


cash_control_use_chec()
{
   nd_cash_control_use_flag = 'N'; 		
   
   /* EXEC SQL SELECT NVL(CASH_CTRL_RCPT_IN_USE_YN,'N') INTO :nd_cash_control_use_flag 
   FROM BL_PARAMETERS
   WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(CASH_CTRL_RCPT_IN_USE_YN,'N') into :b0  from BL\
_PARAMETERS where OPERATING_FACILITY_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )120;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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

fetch_prog_param()
{

    nd_post_upto_date.arr[0]               = '\0';
    nd_post_upto_date.len        = 0;

    nd_month = 0;
    nd_year  = 0;

  /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3
	      INTO :nd_month,:nd_year,:nd_post_upto_date
	      FROM SY_PROG_PARAM
	      WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date
	       AND OPERATING_FACILITY_Id = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 into :b0,:b1,:b2  from SY_PRO\
G_PARAM where (((PGM_ID=:b3 and SESSION_ID=:b4) and PGM_DATE=:b5) and OPERATIN\
G_FACILITY_Id=:b6)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )143;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqhstv[3] = (         void  *)&d_curr_pgm_name;
  sqlstm.sqhstl[3] = (unsigned int  )17;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_session_id;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[5] = (unsigned int  )27;
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

 

   if (OERROR)
	err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
	err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_post_upto_date.arr[nd_post_upto_date.len]  = '\0';

   if (nd_month == 0 || nd_year == 0 )
	 err_mesg("",1,"BL9005");

    d_ip_gl_yn = '\0';
    d_op_gl_yn = '\0';
    d_rf_gl_yn = '\0';

   /* EXEC SQL SELECT CURRENT_PROC_ACC_MONTH,
		   CURRENT_PROC_ACC_YEAR,
		   TO_NUMBER(TO_CHAR(SYSDATE,'MM')),
		   TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')),
		   NVL(IP_GL_REQD_YN,'N'),
		   NVL(OP_GL_REQD_YN,'N'),
		   NVL(RF_GL_REQD_YN,'N')
	    INTO   :bl_mth,
		   :bl_yr,
		   :cur_mth,
		   :cur_yr,
		   :d_ip_gl_yn,
		   :d_op_gl_yn,
		   :d_rf_gl_yn
	    FROM   BL_PARAMETERS
	    WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CURRENT_PROC_ACC_MONTH ,CURRENT_PROC_ACC_YEAR ,TO_N\
UMBER(TO_CHAR(SYSDATE,'MM')) ,TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) ,NVL(IP_GL_RE\
QD_YN,'N') ,NVL(OP_GL_REQD_YN,'N') ,NVL(RF_GL_REQD_YN,'N') into :b0,:b1,:b2,:b\
3,:b4,:b5,:b6  from BL_PARAMETERS where OPERATING_FACILITY_ID=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )186;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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



    if(OERROR)
	err_mesg("SELECT failed on table BL_PARAMETERS",0,"");

    if( (cur_yr > bl_yr) || (cur_yr==bl_yr && cur_mth > bl_mth) ) {
	nd_month = cur_mth;
	nd_year  = cur_yr;
    }
    else {
	nd_month = bl_mth;
	nd_year  = bl_yr;
    }

/*   HANDLED IN FORM BY VSK 20/01/2001 FOR BLENH PURPOSE

EXEC SQL DELETE SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date
	       AND OPERATING_FACILITY_ID = :nd_operating_facility_id;

   if (OERROR)
	 err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");*/   
}

declare_cur()
{

     /* EXEC SQL DECLARE BL_PAT_CHG_FOLIO_CUR CURSOR FOR
	       SELECT A.TRX_DOC_REF,
		      A.TRX_DOC_REF_LINE_NUM,
		      A.TRX_DOC_REF_SEQ_NUM,
		      TO_CHAR(A.TRX_DATE,'DD/MM/YYYY'),
		      NVL(A.EPISODE_TYPE,'R'),
		      A.PATIENT_ID,
		      NVL(A.EPISODE_ID,0),
		      NVL(A.VISIT_ID,0),
		      A.BILLED_FLAG,
		      A.SETTLEMENT_IND,
		      A.PRT_GRP_HDR_CODE,
		      A.PRT_GRP_LINE_CODE,
		      A.PACKAGE_IND,
		      A.PACKAGE_SERVICE_CODE,
		      A.BLNG_SERV_CODE,
		      A.PACKAGE_TRX_IND,
		      A.SERV_LOCN_CODE,
		      A.SERV_ITEM_CODE,
		      A.SERV_ITEM_DESC,
		      A.RATE_CHARGE_FLAG,
		      A.BASE_QTY,
		      ROUND(A.BASE_RATE,6),
		      A.SERV_QTY,
		      ROUND(A.BASE_CHARGE_AMT,6),
		      A.ORG_GROSS_CHARGE_AMT,
		      A.ORG_DISC_AMT,
		      A.ORG_NET_CHARGE_AMT,
		      A.UPD_GROSS_CHARGE_AMT,
		      A.UPD_DISC_AMT,
		      A.UPD_NET_CHARGE_AMT,
		      A.ADJ_GROSS_CHARGE_AMT,
		      A.ADJ_DISC_AMT,  
		      A.ADJ_NET_CHARGE_AMT,
		      A.MODULE_ID,  
		      A.SOURCE_DOC_REF,
		      TO_CHAR(A.SOURCE_DOC_DATE,'DD/MM/YYYY'),
		      TO_CHAR(A.SERVICE_DATE,'DD/MM/YYYY'),
		      TO_NUMBER(TO_CHAR(A.SERVICE_DATE,'MM')),
		      TO_NUMBER(TO_CHAR(A.SERVICE_DATE,'YYYY')),
		      NVL(A.ACCT_DEPT_CODE,'0000'),
		      NVL(A.ORIG_DEPT_CODE,'0000'),
		      NVL(A.PHYSICIAN_ID,'000000000000000'),
		      A.BLNG_GRP_ID,
		      A.BLNG_CLASS_CODE,
		      A.DAY_TYPE_CODE,
		      A.TIME_TYPE_CODE,
		      A.DISC_PERC,
		      A.ADDL_FACTOR_NUM,
		      NVL(A.BED_CLASS_CODE,'XX') BED_CLASS_CODE,
		      A.BILL_TYPE_CODE,
		      A.FOLIO_REMARKS,
		      A.DF_SERVICE_IND,
		      A.DF_UPD_FLAG,
		      A.DOC_TYPE_CODE,
		      A.DOC_NUMBER,
		      A.BILL_DOC_TYPE_CODE,
		      A.BILL_DOC_NUM,
		      TO_CHAR(A.BILL_DOC_DATE,'DD/MM/YYYY'),
		      A.TRX_FINALIZE_IND,
		      A.FINALIZED_BY_ID,
		      TO_CHAR(A.FINALIZED_DATE,'DD/MM/YYYY'),
		      A.TRX_POSTED_IND,
		      A.POSTED_BY_ID,
		      TO_CHAR(A.POSTED_DATE,'DD/MM/YYYY'),
		      A.LAST_ADJUSTED_BY_ID,
		      TO_CHAR(A.LAST_ADJUSTED_DATE,'DD/MM/YYYY'),
		      A.ADDED_BY_ID,
		      A.MODIFIED_BY_ID,
		      TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY'),
		      TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY'),
		      A.PACKAGE_IND||A.PACKAGE_SERVICE_CODE||A.BLNG_SERV_CODE,
		      B.CASH_CTRL_DOC_TYPE_CODE,        
		      B.CASH_CTRL_DOC_NUMBER,           
		      B.CASH_CTRL_DOC_DATE,
		      B.CASH_COUNTER_CODE,
		      B.SHIFT_ID,
		      A.PACKAGE_BILL_DOC_TYPE,
		      A.PACKAGE_BILL_DOC_NUM,
		      A.PACKAGE_BILL_DATE,
		      A.CUST_CODE
		 FROM BL_PACKAGE_CHARGES_FOLIO A,
		      BL_BILL_HDR B
		WHERE A.TRX_POSTED_IND = 'N'   
		  AND A.TRX_DATE <= TO_DATE(:nd_post_upto_date||' 23:59','DD/MM/YYYY HH24:MI')
		  AND NVL(A.TRX_FINALIZE_IND,'N') = 'Y' 
		  AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		  AND A.PACKAGE_BILL_DOC_TYPE = B.PACKAGE_BILL_DOC_TYPE
		  AND A.PACKAGE_BILL_DOC_NUM = B.PACKAGE_BILL_DOC_NUM 
		  AND TRUNC(A.PACKAGE_BILL_DATE) = TRUNC(B.PACKAGE_BILL_DATE)
		  AND TRX_FINALIZE_IND = 'Y'
		  ORDER BY A.TRX_DOC_REF,A.PACKAGE_IND,
			 A.PACKAGE_SERVICE_CODE,
			 A.BLNG_SERV_CODE,
			 A.ACCT_DEPT_CODE; */ 


     /* EXEC SQL DECLARE BL_TYPE_BLNG_SERV_CUR CURSOR FOR
	       SELECT BL_PKG_CTRL_ACC_INT_CODE
		 FROM BL_BILL_TYPE
		WHERE BILL_TYPE_CODE = :bl_pat_bill_type_code
		AND   ACC_ENTITY_CODE IN ( SELECT acc_entity_code FROM sy_acc_entity
					   WHERE acc_entity_id = :nd_operating_facility_id); */ 


     /* EXEC SQL DECLARE BL_TYPE_SERV_GRP_CUR CURSOR FOR
	        SELECT BL_PKG_CTRL_ACC_INT_CODE
		 FROM BL_BILL_TYPE
		WHERE BILL_TYPE_CODE = :bl_pat_bill_type_code
		AND   ACC_ENTITY_CODE IN ( SELECT acc_entity_code FROM sy_acc_entity
			   WHERE acc_entity_id = :nd_operating_facility_id); */ 



     /* EXEC SQL DECLARE BL_BILL_TYPE_CUR CURSOR FOR
	       SELECT BL_RECV_ACC_INT_CODE
		 FROM BL_BILL_TYPE
		WHERE BILL_TYPE_CODE = :bl_pat_bill_type_code
		AND   ACC_ENTITY_CODE IN ( SELECT acc_entity_code FROM sy_acc_entity
					   WHERE acc_entity_id = :nd_operating_facility_id); */ 



     /* EXEC SQL DECLARE BL_GL_ACCOUNT_CUR CURSOR FOR
	       SELECT MAIN_ACC1_CODE,
		      MAIN_ACC2_CODE,
		      DECODE(DEPT_CODE,'X',:store_acct_dept_code,DEPT_CODE),
		      SUBLEDGER_GROUP_CODE,
		      SUBLEDGER_LINE_CODE,
		      PRODUCT_GROUP_CODE,
		      PRODUCT_LINE_CODE
		 FROM BL_GL_ACCOUNT
		WHERE ACC_INT_CODE = :bl_acc_int_code
		AND   ACC_ENTITY_CODE IN ( SELECT acc_entity_code FROM sy_acc_entity
			   WHERE acc_entity_id = :nd_operating_facility_id); */ 



    /* EXEC SQL DECLARE LOCK_TRX_REF_CUR CURSOR FOR
	     SELECT ROWID
	       FROM BL_PACKAGE_CHARGES_FOLIO
	      WHERE TRX_DOC_REF  = :bl_pat_trx_doc_ref
		  AND   NVL(TRX_POSTED_IND,'N') = 'N'
	      AND   TRX_DATE <= TO_DATE(:nd_post_upto_date||' 23:59','DD/MM/YYYY HH24:MI')
	      AND   NVL(TRX_FINALIZE_IND,'N') = 'Y'
	      AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		  FOR   UPDATE OF TRX_DOC_REF NOWAIT; */ 

}

open_cur()
{
     /* EXEC SQL OPEN BL_PAT_CHG_FOLIO_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "select A.TRX_DOC_REF ,A.TRX_DOC_REF_LINE_NUM ,A.TRX_DOC_REF_SEQ_NUM \
,TO_CHAR(A.TRX_DATE,'DD/MM/YYYY') ,NVL(A.EPISODE_TYPE,'R') ,A.PATIENT_ID ,NV\
L(A.EPISODE_ID,0) ,NVL(A.VISIT_ID,0) ,A.BILLED_FLAG ,A.SETTLEMENT_IND ,A.PRT\
_GRP_HDR_CODE ,A.PRT_GRP_LINE_CODE ,A.PACKAGE_IND ,A.PACKAGE_SERVICE_CODE ,A\
.BLNG_SERV_CODE ,A.PACKAGE_TRX_IND ,A.SERV_LOCN_CODE ,A.SERV_ITEM_CODE ,A.SE\
RV_ITEM_DESC ,A.RATE_CHARGE_FLAG ,A.BASE_QTY ,ROUND(A.BASE_RATE,6) ,A.SERV_Q\
TY ,ROUND(A.BASE_CHARGE_AMT,6) ,A.ORG_GROSS_CHARGE_AMT ,A.ORG_DISC_AMT ,A.OR\
G_NET_CHARGE_AMT ,A.UPD_GROSS_CHARGE_AMT ,A.UPD_DISC_AMT ,A.UPD_NET_CHARGE_A\
MT ,A.ADJ_GROSS_CHARGE_AMT ,A.ADJ_DISC_AMT ,A.ADJ_NET_CHARGE_AMT ,A.MODULE_I\
D ,A.SOURCE_DOC_REF ,TO_CHAR(A.SOURCE_DOC_DATE,'DD/MM/YYYY') ,TO_CHAR(A.SERV\
ICE_DATE,'DD/MM/YYYY') ,TO_NUMBER(TO_CHAR(A.SERVICE_DATE,'MM')) ,TO_NUMBER(T\
O_CHAR(A.SERVICE_DATE,'YYYY')) ,NVL(A.ACCT_DEPT_CODE,'0000') ,NVL(A.ORIG_DEP\
T_CODE,'0000') ,NVL(A.PHYSICIAN_ID,'000000000000000') ,A.BLNG_GRP_ID ,A.BLNG\
_CLASS_CODE ,A.DAY_TYPE_CODE ,A.TIME_TYPE_CO");
     sqlbuft((void **)0, 
       "DE ,A.DISC_PERC ,A.ADDL_FACTOR_NUM ,NVL(A.BED_CLASS_CODE,'XX') BED_C\
LASS_CODE ,A.BILL_TYPE_CODE ,A.FOLIO_REMARKS ,A.DF_SERVICE_IND ,A.DF_UPD_FLA\
G ,A.DOC_TYPE_CODE ,A.DOC_NUMBER ,A.BILL_DOC_TYPE_CODE ,A.BILL_DOC_NUM ,TO_C\
HAR(A.BILL_DOC_DATE,'DD/MM/YYYY') ,A.TRX_FINALIZE_IND ,A.FINALIZED_BY_ID ,TO\
_CHAR(A.FINALIZED_DATE,'DD/MM/YYYY') ,A.TRX_POSTED_IND ,A.POSTED_BY_ID ,TO_C\
HAR(A.POSTED_DATE,'DD/MM/YYYY') ,A.LAST_ADJUSTED_BY_ID ,TO_CHAR(A.LAST_ADJUS\
TED_DATE,'DD/MM/YYYY') ,A.ADDED_BY_ID ,A.MODIFIED_BY_ID ,TO_CHAR(A.ADDED_DAT\
E,'DD/MM/YYYY') ,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY') ,((A.PACKAGE_IND||A.P\
ACKAGE_SERVICE_CODE)||A.BLNG_SERV_CODE) ,B.CASH_CTRL_DOC_TYPE_CODE ,B.CASH_C\
TRL_DOC_NUMBER ,B.CASH_CTRL_DOC_DATE ,B.CASH_COUNTER_CODE ,B.SHIFT_ID ,A.PAC\
KAGE_BILL_DOC_TYPE ,A.PACKAGE_BILL_DOC_NUM ,A.PACKAGE_BILL_DATE ,A.CUST_CODE\
  from BL_PACKAGE_CHARGES_FOLIO A ,BL_BILL_HDR B where ((((((((A.TRX_POSTED_\
IND='N' and A.TRX_DATE<=TO_DATE((:b0||' 23:59'),'DD/MM/YYYY HH24:MI')) and N\
VL(A.TRX_FINALIZE_IND,'N')='Y') and A.OPERAT");
     sqlstm.stmt = sq0009;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )233;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_post_upto_date;
     sqlstm.sqhstl[0] = (unsigned int  )13;
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



     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_PAT_CHG_FOLIO_CUR",0,"");
}

fetch_cur()
{
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
cpatdoctypecode.arr[0]			       			  = '\0';
cpatdocnum.arr[0]                              			  = '\0';
cpatdocdate.arr[0]				       		  = '\0';


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
		    :nd_doc_type,
		    :nd_doc_num,
		    :nd_doc_date,
		    :nd_cash_counter_code,
		    :nd_shift_id,
	    	    :cpatdoctypecode,
            	    :cpatdocnum,
	    	    :cpatdocdate,
		    :nd_cust_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )256;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
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
     sqlstm.sqhstl[10] = (unsigned int  )5;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_pat_prt_grp_line_code;
     sqlstm.sqhstl[11] = (unsigned int  )5;
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
     sqlstm.sqhstl[39] = (unsigned int  )9;
     sqlstm.sqhsts[39] = (         int  )0;
     sqlstm.sqindv[39] = (         void  *)0;
     sqlstm.sqinds[39] = (         int  )0;
     sqlstm.sqharm[39] = (unsigned int  )0;
     sqlstm.sqadto[39] = (unsigned short )0;
     sqlstm.sqtdso[39] = (unsigned short )0;
     sqlstm.sqhstv[40] = (         void  *)&bl_pat_orig_dept_code;
     sqlstm.sqhstl[40] = (unsigned int  )9;
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
     sqlstm.sqhstl[42] = (unsigned int  )5;
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
     sqlstm.sqhstv[71] = (         void  *)&nd_doc_type;
     sqlstm.sqhstl[71] = (unsigned int  )10;
     sqlstm.sqhsts[71] = (         int  )0;
     sqlstm.sqindv[71] = (         void  *)0;
     sqlstm.sqinds[71] = (         int  )0;
     sqlstm.sqharm[71] = (unsigned int  )0;
     sqlstm.sqadto[71] = (unsigned short )0;
     sqlstm.sqtdso[71] = (unsigned short )0;
     sqlstm.sqhstv[72] = (         void  *)&nd_doc_num;
     sqlstm.sqhstl[72] = (unsigned int  )32;
     sqlstm.sqhsts[72] = (         int  )0;
     sqlstm.sqindv[72] = (         void  *)0;
     sqlstm.sqinds[72] = (         int  )0;
     sqlstm.sqharm[72] = (unsigned int  )0;
     sqlstm.sqadto[72] = (unsigned short )0;
     sqlstm.sqtdso[72] = (unsigned short )0;
     sqlstm.sqhstv[73] = (         void  *)&nd_doc_date;
     sqlstm.sqhstl[73] = (unsigned int  )33;
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
     sqlstm.sqhstv[76] = (         void  *)&cpatdoctypecode;
     sqlstm.sqhstl[76] = (unsigned int  )9;
     sqlstm.sqhsts[76] = (         int  )0;
     sqlstm.sqindv[76] = (         void  *)0;
     sqlstm.sqinds[76] = (         int  )0;
     sqlstm.sqharm[76] = (unsigned int  )0;
     sqlstm.sqadto[76] = (unsigned short )0;
     sqlstm.sqtdso[76] = (unsigned short )0;
     sqlstm.sqhstv[77] = (         void  *)&cpatdocnum;
     sqlstm.sqhstl[77] = (unsigned int  )32;
     sqlstm.sqhsts[77] = (         int  )0;
     sqlstm.sqindv[77] = (         void  *)0;
     sqlstm.sqinds[77] = (         int  )0;
     sqlstm.sqharm[77] = (unsigned int  )0;
     sqlstm.sqadto[77] = (unsigned short )0;
     sqlstm.sqtdso[77] = (unsigned short )0;
     sqlstm.sqhstv[78] = (         void  *)&cpatdocdate;
     sqlstm.sqhstl[78] = (unsigned int  )15;
     sqlstm.sqhsts[78] = (         int  )0;
     sqlstm.sqindv[78] = (         void  *)0;
     sqlstm.sqinds[78] = (         int  )0;
     sqlstm.sqharm[78] = (unsigned int  )0;
     sqlstm.sqadto[78] = (unsigned short )0;
     sqlstm.sqtdso[78] = (unsigned short )0;
     sqlstm.sqhstv[79] = (         void  *)&nd_cust_code;
     sqlstm.sqhstl[79] = (unsigned int  )11;
     sqlstm.sqhsts[79] = (         int  )0;
     sqlstm.sqindv[79] = (         void  *)0;
     sqlstm.sqinds[79] = (         int  )0;
     sqlstm.sqharm[79] = (unsigned int  )0;
     sqlstm.sqadto[79] = (unsigned short )0;
     sqlstm.sqtdso[79] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
	 err_mesg("FETCH failed on cursor BL_PAT_CHG_FOLIO_CUR",0,"");

cpatdoctypecode.arr[cpatdoctypecode.len] = '\0';
cpatdocnum.arr[cpatdocnum.len] = '\0';     
cpatdocdate.arr[cpatdocdate.len] = '\0';	
nd_cust_code.arr[nd_cust_code.len]					= '\0';
nd_cash_counter_code.arr[nd_cash_counter_code.len]                      = '\0';
nd_shift_id.arr[nd_shift_id.len]                      			= '\0';
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
nd_doc_type.arr[nd_doc_type.len]  		                         = '\0';
nd_doc_num.arr[nd_doc_num.len]  		                         = '\0';
nd_doc_date.arr[nd_doc_date.len]  		                         = '\0';


     return(LAST_ROW?0:1);
}

fetch_bl_gl_account_trx_ref()
{

     /* EXEC SQL OPEN BL_BILL_TYPE_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0012;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )591;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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


     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_BILL_TYPE_CUR",0,"");

     bl_acc_int_code.arr[0]     = '\0';
     bl_acc_int_code.len        = '\0';
 
     /* EXEC SQL FETCH BL_BILL_TYPE_CUR
	       INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )614;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
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
	   sprintf(msg_str,"Record for %s not found in BL_BILL_TYPE",
			  bl_pat_bill_type_code.arr);
	   loc_log_msg(msg_str);
	   return;
     }

     bl_acc_int_code.arr[bl_acc_int_code.len] = '\0';

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )633;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&store_acct_dept_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )660;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_pkg2_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
     sqlstm.sqhstl[2] = (unsigned int  )9;
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
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0011;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )703;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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


     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_TYPE_SERV_GRP_CUR",0,"");

     bl_acc_int_code.arr[0]     = '\0';
     bl_acc_int_code.len        = '\0';

     /* EXEC SQL FETCH BL_TYPE_SERV_GRP_CUR
	       INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )726;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
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
	 err_mesg("FETCH failed on cursor BL_TYPE_SERV_GRP_CUR",0,"");

     if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s - %s not found in BL_TYPE_SERV_GRP",
			  bl_pat_blng_grp_id.arr,
			  bl_pat_bill_type_code.arr);
	   loc_log_msg(msg_str);
	   return;
     }

     bl_acc_int_code.arr[bl_acc_int_code.len] = '\0';

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )745;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&store_acct_dept_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )772;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_pkg1_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
     sqlstm.sqhstl[2] = (unsigned int  )9;
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
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )815;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_bill_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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


     if (OERROR)
	 err_mesg("OPEN failed on cursor BL_TYPE_BLNG_SERV_CUR",0,"");

     /* EXEC SQL FETCH BL_TYPE_BLNG_SERV_CUR
	       INTO :bl_acc_int_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )838;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
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
	   sprintf(msg_str,"Record for %s - %s not found in BL_TYPE_BLNG_SERV",
			  bl_pat_blng_serv_code.arr,
			  bl_pat_bill_type_code.arr);
	   loc_log_msg(msg_str);
	   return;
     }

     bl_acc_int_code.arr[bl_acc_int_code.len] = '\0';

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )857;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&store_acct_dept_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )884;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_dept_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
     sqlstm.sqhstl[2] = (unsigned int  )9;
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
	(bl_store_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N'))
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
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 80;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select nvl(acc_per_year,to_char(to_date(:b0,'DD/MM/YY\
YY'),'YYYY')) ,nvl(acc_per_month,to_char(to_date(:b0,'DD/MM/YYYY'),'MM')) into\
 :b2,:b3  from sy_acc_period_defn where to_date(:b0,'DD/MM/YYYY') between acc_\
per_start_date and acc_per_end_date";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )927;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
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

    if(bl_tot_disc_amt != 0) {

	/* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
		  ( 
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
		    GL_INTERFACE_FLAG,	  /o   N  o/
		    ADDED_BY_ID,                    
		    MODIFIED_BY_ID,                 
		    ADDED_DATE    ,
		    MODIFIED_DATE,                  
		    ADDED_AT_WS_NO,                 
		    ADDED_FACILITY_ID,              
		    MODIFIED_AT_WS_NO,              
		    MODIFIED_FACILITY_ID,
		    OPERATING_FACILITY_ID,
		    CASH_CTRL_DOC_TYPE,             
		    CASH_CTRL_DOC_NUMBER,           
		    CASH_CTRL_DOC_DATE ,
		    CUST_CODE                       
	       )
	   VALUES
	      (
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
		   NVL(:nd_post_year, TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'YYYY')),
		   NVL(:nd_post_month, TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'MM')),
		   TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),
		   :bl_store_trx_doc_ref,
		   0,
		   0,
		   :bl_store_episode_type,
		   :bl_store_patient_id,
		   :bl_store_episode_id,
		   :bl_store_visit_id,
		   NULL,
		   NULL,
		   NULL,
		   'F',
		   :bl_tot_disc_amt,
		   NULL,
		   NULL,
		   'N',
		   USER,
		   USER,                 
		   SYSDATE,
		   SYSDATE,                  
		   :nd_ws_no,                 
		   :nd_operating_facility_id,              
		   :nd_ws_no,                 
		   :nd_operating_facility_id,              
		   :nd_operating_facility_id,
		   :nd_pre_doc_type,
		   :nd_pre_doc_num,
		   :nd_pre_doc_date,
	           :nd_pre_cust_code 		 ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 80;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (MAIN_ACC1_CODE,MAIN_ACC2_COD\
E,DEPT_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,PRODUCT_GROUP_CODE,PRODUC\
T_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,TRX\
_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,SOURCE_DOC_REF,SO\
URCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT,GL_INTERFACE_BY_ID,GL_I\
NTERFACE_DATE,GL_INTERFACE_FLAG,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED\
_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,\
OPERATING_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_CTRL_DOC_DA\
TE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,NVL(:b7,TO_CHAR(TO_DATE(:b8,\
'DD/MM/YYYY'),'YYYY')),NVL(:b9,TO_CHAR(TO_DATE(:b8,'DD/MM/YYYY'),'MM')),TO_DAT\
E(:b8,'DD/MM/YYYY'),:b12,0,0,:b13,:b14,:b15,:b16,null ,null ,null ,'F',:b17,nu\
ll ,null ,'N',USER,USER,SYSDATE,SYSDATE,:b18,:b19,:b18,:b19,:b19,:b23,:b24,:b2\
5,:b26)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )962;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_pkg1_main_acc1_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
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
 sqlstm.sqhstl[2] = (unsigned int  )9;
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
 sqlstm.sqhstv[7] = (         void  *)&nd_post_year;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&bl_store_trx_date;
 sqlstm.sqhstl[8] = (unsigned int  )15;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_post_month;
 sqlstm.sqhstl[9] = (unsigned int  )5;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&bl_store_trx_date;
 sqlstm.sqhstl[10] = (unsigned int  )15;
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
 sqlstm.sqhstv[12] = (         void  *)&bl_store_trx_doc_ref;
 sqlstm.sqhstl[12] = (unsigned int  )23;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&bl_store_episode_type;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&bl_store_patient_id;
 sqlstm.sqhstl[14] = (unsigned int  )23;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&bl_store_episode_id;
 sqlstm.sqhstl[15] = (unsigned int  )11;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&bl_store_visit_id;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&bl_tot_disc_amt;
 sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[18] = (unsigned int  )33;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[19] = (unsigned int  )5;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[20] = (unsigned int  )33;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[21] = (unsigned int  )5;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[22] = (unsigned int  )5;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&nd_pre_doc_type;
 sqlstm.sqhstl[23] = (unsigned int  )10;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_pre_doc_num;
 sqlstm.sqhstl[24] = (unsigned int  )32;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&nd_pre_doc_date;
 sqlstm.sqhstl[25] = (unsigned int  )33;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&nd_pre_cust_code;
 sqlstm.sqhstl[26] = (unsigned int  )11;
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
	     err_mesg("INSERT failed on table BL_GL_DISTRIBUTION - 2",0,"");
    }

    /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
	      (
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
		    ADDED_DATE    ,
		    MODIFIED_DATE,                  
		    ADDED_AT_WS_NO,                 
		    ADDED_FACILITY_ID,              
		    MODIFIED_AT_WS_NO,              
		    MODIFIED_FACILITY_ID,
		    OPERATING_FACILITY_ID    ,
   		    CASH_CTRL_DOC_TYPE,             
		    CASH_CTRL_DOC_NUMBER,           
		    CASH_CTRL_DOC_DATE  ,
		    CUST_CODE                      

	   )
       VALUES
	  (
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
	       0,
	       0,
	       :bl_store_episode_type,
	       :bl_store_patient_id,
	       :bl_store_episode_id,
	       :bl_store_visit_id,
	       NULL,
	       NULL,
	       NULL,
	       'F',
	       -1 * :bl_tot_gross_charge_amt,
	       NULL,
	       NULL,
	       'N',
		   USER,
		   USER,                 
		   SYSDATE,
		   SYSDATE,                  
		   :nd_ws_no,                 
		   :nd_operating_facility_id,              
		   :nd_ws_no,                 
		   :nd_operating_facility_id,              
		   :nd_operating_facility_id,
		   :nd_pre_doc_type,
		   :nd_pre_doc_num,
		   :nd_pre_doc_date,
		   :nd_pre_cust_code           		 ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 80;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (MAIN_ACC1_CODE,MAIN_ACC2_\
CODE,DEPT_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,PRODUCT_GROUP_CODE,PRO\
DUCT_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,\
TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,SOURCE_DOC_REF\
,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT,GL_INTERFACE_BY_ID,G\
L_INTERFACE_DATE,GL_INTERFACE_FLAG,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIF\
IED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_\
ID,OPERATING_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_CTRL_DOC\
_DATE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,nvl(:b7,TO_CHAR(TO_DATE(:\
b8,'DD/MM/YYYY'),'YYYY')),nvl(:b9,TO_CHAR(TO_DATE(:b8,'DD/MM/YYYY'),'MM')),TO_\
DATE(:b8,'DD/MM/YYYY'),:b12,0,0,:b13,:b14,:b15,:b16,null ,null ,null ,'F',((-1\
)* :b17),null ,null ,'N',USER,USER,SYSDATE,SYSDATE,:b18,:b19,:b18,:b19,:b19,:b\
23,:b24,:b25,:b26)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1085;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_dept_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
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
    sqlstm.sqhstl[2] = (unsigned int  )9;
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
    sqlstm.sqhstv[7] = (         void  *)&nd_post_year;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[8] = (unsigned int  )15;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_post_month;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[10] = (unsigned int  )15;
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
    sqlstm.sqhstv[12] = (         void  *)&bl_store_trx_doc_ref;
    sqlstm.sqhstl[12] = (unsigned int  )23;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&bl_store_episode_type;
    sqlstm.sqhstl[13] = (unsigned int  )4;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&bl_store_patient_id;
    sqlstm.sqhstl[14] = (unsigned int  )23;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&bl_store_episode_id;
    sqlstm.sqhstl[15] = (unsigned int  )11;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&bl_store_visit_id;
    sqlstm.sqhstl[16] = (unsigned int  )7;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&bl_tot_gross_charge_amt;
    sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[18] = (unsigned int  )33;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[20] = (unsigned int  )33;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[21] = (unsigned int  )5;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[22] = (unsigned int  )5;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&nd_pre_doc_type;
    sqlstm.sqhstl[23] = (unsigned int  )10;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&nd_pre_doc_num;
    sqlstm.sqhstl[24] = (unsigned int  )32;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&nd_pre_doc_date;
    sqlstm.sqhstl[25] = (unsigned int  )33;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&nd_pre_cust_code;
    sqlstm.sqhstl[26] = (unsigned int  )11;
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
	 err_mesg("INSERT failed on table BL_GL_DISTRIBUTION",0,"");

}

create_bl_gl_dist_trx_ref()
{

    if( (bl_store_episode_type.arr[0] == 'I' && d_ip_gl_yn == 'N') ||
        (bl_store_episode_type.arr[0] == 'D' && d_ip_gl_yn == 'N') ||
	(bl_store_episode_type.arr[0] == 'O' && d_op_gl_yn == 'N') ||
	(bl_store_episode_type.arr[0] == 'E' && d_op_gl_yn == 'N') ||
	(bl_store_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N'))

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
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 80;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select nvl(acc_per_year,to_char(to_date(:b0,'DD/MM/YY\
YY'),'YYYY')) ,nvl(acc_per_month,to_char(to_date(:b0,'DD/MM/YYYY'),'MM')) into\
 :b2,:b3  from sy_acc_period_defn where to_date(:b0,'DD/MM/YYYY') between acc_\
per_start_date and acc_per_end_date";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1208;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
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

    /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
	      (
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
		GL_INTERFACE_FLAG,   /o   NULLo/
		    ADDED_BY_ID,                    
		    MODIFIED_BY_ID,                 
		    ADDED_DATE    ,
		    MODIFIED_DATE,                  
		    ADDED_AT_WS_NO,                 
		    ADDED_FACILITY_ID,              
		    MODIFIED_AT_WS_NO,              
		    MODIFIED_FACILITY_ID,
		    OPERATING_FACILITY_ID,
		    CASH_CTRL_DOC_TYPE,             
		    CASH_CTRL_DOC_NUMBER,           
		    CASH_CTRL_DOC_DATE ,
		    CUST_CODE                       
    
	   )

       VALUES
	  (
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
	       NVL(:nd_post_year, TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'YYYY')),
	       nvl(:nd_post_month, TO_CHAR(TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),'MM')),
	       TO_DATE(:bl_store_trx_date,'DD/MM/YYYY'),
	       :bl_store_trx_doc_ref,
	       0,
	       0,
	       :bl_store_episode_type,
	       :bl_store_patient_id,
	       :bl_store_episode_id,
	       :bl_store_visit_id,
	       NULL,
	       NULL,
	       NULL,
	       'F',
	       :bl_tot_net_charge_amt,
	       NULL,
	       NULL,
	       'N',
		   USER,
		   USER,                 
		   SYSDATE,
		   SYSDATE,                  
		   :nd_ws_no,                 
		   :nd_operating_facility_id,              
		   :nd_ws_no,                 
		   :nd_operating_facility_id,              
		   :nd_operating_facility_id,
		   :nd_pre_doc_type,
		   :nd_pre_doc_num,
		   :nd_pre_doc_date,
		   :nd_pre_cust_code); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 80;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (MAIN_ACC1_CODE,MAIN_ACC2_\
CODE,DEPT_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,PRODUCT_GROUP_CODE,PRO\
DUCT_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,\
TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,SOURCE_DOC_REF\
,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT,GL_INTERFACE_BY_ID,G\
L_INTERFACE_DATE,GL_INTERFACE_FLAG,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIF\
IED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_\
ID,OPERATING_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_CTRL_DOC\
_DATE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,NVL(:b7,TO_CHAR(TO_DATE(:\
b8,'DD/MM/YYYY'),'YYYY')),nvl(:b9,TO_CHAR(TO_DATE(:b8,'DD/MM/YYYY'),'MM')),TO_\
DATE(:b8,'DD/MM/YYYY'),:b12,0,0,:b13,:b14,:b15,:b16,null ,null ,null ,'F',:b17\
,null ,null ,'N',USER,USER,SYSDATE,SYSDATE,:b18,:b19,:b18,:b19,:b19,:b23,:b24,\
:b25,:b26)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1243;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_pkg2_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
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
    sqlstm.sqhstl[2] = (unsigned int  )9;
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
    sqlstm.sqhstv[7] = (         void  *)&nd_post_year;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[8] = (unsigned int  )15;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_post_month;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&bl_store_trx_date;
    sqlstm.sqhstl[10] = (unsigned int  )15;
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
    sqlstm.sqhstv[12] = (         void  *)&bl_store_trx_doc_ref;
    sqlstm.sqhstl[12] = (unsigned int  )23;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&bl_store_episode_type;
    sqlstm.sqhstl[13] = (unsigned int  )4;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&bl_store_patient_id;
    sqlstm.sqhstl[14] = (unsigned int  )23;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&bl_store_episode_id;
    sqlstm.sqhstl[15] = (unsigned int  )11;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&bl_store_visit_id;
    sqlstm.sqhstl[16] = (unsigned int  )7;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&bl_tot_net_charge_amt;
    sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[18] = (unsigned int  )33;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[20] = (unsigned int  )33;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[21] = (unsigned int  )5;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[22] = (unsigned int  )5;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&nd_pre_doc_type;
    sqlstm.sqhstl[23] = (unsigned int  )10;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&nd_pre_doc_num;
    sqlstm.sqhstl[24] = (unsigned int  )32;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&nd_pre_doc_date;
    sqlstm.sqhstl[25] = (unsigned int  )33;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&nd_pre_cust_code;
    sqlstm.sqhstl[26] = (unsigned int  )11;
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
	 err_mesg("INSERT failed on table BL_GL_DISTRIBUTION - 3",0,"");
}

continue_to_next_ref()
{
    /* EXEC SQL ROLLBACK WORK TO SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 80;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "rollback work  to LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1366;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
	 err_mesg("ROLLBACK TO LAST_DOC_REF failed",0,""); 
}

upd_pat_chg_folio()
{
     /* EXEC SQL UPDATE BL_PACKAGE_CHARGES_FOLIO
		   SET   DF_UPD_FLAG = DECODE(DF_SERVICE_IND,'D','Y',DF_UPD_FLAG),
		         TRX_POSTED_IND = 'Y',
		         POSTED_BY_ID   =  USER,
		         POSTED_DATE    =  SYSDATE,
			 MODIFIED_BY_ID =  USER,                 
		         MODIFIED_DATE  =  SYSDATE        ,         
		         MODIFIED_AT_WS_NO    = :nd_ws_no,              
		         MODIFIED_FACILITY_ID = :nd_operating_facility_id,
			 UNPOSTED_REASON      = NULL			 
	       WHERE TRX_DOC_REF    = :bl_store_trx_doc_ref
		   AND   NVL(TRX_POSTED_IND,'N') = 'N'
	       AND   TRX_DATE <= TO_DATE(:nd_post_upto_date||' 23:59','DD/MM/YYYY HH24:MI')
	       AND   NVL(TRX_FINALIZE_IND,'N') = 'Y'
	       AND   OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 80;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update BL_PACKAGE_CHARGES_FOLIO  set DF_UPD_FLAG=DECODE(\
DF_SERVICE_IND,'D','Y',DF_UPD_FLAG),TRX_POSTED_IND='Y',POSTED_BY_ID=USER,POSTE\
D_DATE=SYSDATE,MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b0\
,MODIFIED_FACILITY_ID=:b1,UNPOSTED_REASON=null  where ((((TRX_DOC_REF=:b2 and \
NVL(TRX_POSTED_IND,'N')='N') and TRX_DATE<=TO_DATE((:b3||' 23:59'),'DD/MM/YYYY\
 HH24:MI')) and NVL(TRX_FINALIZE_IND,'N')='Y') and OPERATING_FACILITY_ID=:b1)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1381;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
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
     sqlstm.sqhstv[2] = (         void  *)&bl_store_trx_doc_ref;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_post_upto_date;
     sqlstm.sqhstl[3] = (unsigned int  )13;
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
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

		   

     if (OERROR)
	 err_mesg("UPDATE failed on table BL_PACKAGE_CHARGES_FOLIO",0,"");
}

lock_trx_ref()
{
    /* EXEC SQL OPEN LOCK_TRX_REF_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 80;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0014;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1416;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_pat_trx_doc_ref;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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

   return 1;
}

loc_log_msg(str)
char str[];
{
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

     if (rec_ctr != 1)
     {
	  dept_break();
	  if (!err_ctr)
	  {
	      create_bl_gl_dist_trx_ref();
	      upd_pat_chg_folio();
	      err_ctr = 0;
	   }
	   /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 80;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1443;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   if (OERROR)
	      err_mesg("COMMIT failed",0,""); 
    }
    err_ctr = 0;
    bl_tot_gross_charge_amt = 0;
    bl_tot_disc_amt = 0;
    bl_tot_net_charge_amt = 0;

    /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 80;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "savepoint LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1458;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
	err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

    if (bl_pat_df_service_ind.arr[0] == 'D')
    {
	    if (bl_pat_df_upd_flag.arr[0] != 'Y')
	    {
		/*
		 if (bl_dpf_post(bl_pat_doc_type_code.arr,
				 bl_pat_doc_number.arr))
		 {
			sprintf(msg_str,"Error in DPF posting for %s - %s",
				     bl_pat_doc_type_code.arr,
				     bl_pat_doc_number.arr);
			loc_log_msg(msg_str,0,"");
		  }
		*/
	     }
    }
	  /*
	  fetch_bl_gl_account_trx_ref();
	  */
	  strcpy(bl_store_trx_doc_ref.arr,bl_pat_trx_doc_ref.arr);
	  bl_store_trx_doc_ref.len = strlen(bl_store_trx_doc_ref.arr);

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
       fetch_bl_gl_account_pkg();
       strcpy(store_concat_code.arr,bl_pat_concat_code.arr);
       store_concat_code.len = strlen(store_concat_code.arr);
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
}



upd_reasons_in_pack_folio_for_unposting()
{
     nd_reason_text.arr[0]  =  '\0';
	 nd_reason_text.len = 0;
     
     /* 
		   This is a folio posting program and hence Bills records need not be 
		   updated with Unposted Reason - 27/01/2004 Harish.	

	 if (nd_cash_counter_code.arr[0] == '\0')
        strcpy(nd_reason_text.arr,"No cash counter code is available in this record");     
     else if (nd_shift_id.arr[0] == '\0')
           strcpy(nd_reason_text.arr,"No Shift Id is available for this record");     
     else if (nd_doc_type.arr[0] == '\0' && nd_cash_control_use_flag == 'Y')
              strcpy(nd_reason_text.arr,"No Cash Control Document Type is available for this record");     
	 else if (nd_doc_num.arr[0] == '\0'  && nd_cash_control_use_flag == 'Y')
                  strcpy(nd_reason_text.arr,"No Cash Control Document Number is available for this record");     
	 else if (nd_doc_date.arr[0] == '\0' && nd_cash_control_use_flag == 'Y')
                     strcpy(nd_reason_text.arr,"No Cash Control Document Date is available for this record");     

     else */
	 
	 if (bl_pat_orig_dept_code.arr[0] == '\0')
                       strcpy(nd_reason_text.arr,"No original Dept code is available for this record");     		
     else if (bl_pat_physician_id.arr[0] == '\0')
                       strcpy(nd_reason_text.arr,"No Physician Id is available for this record");     		
     else if (bl_pat_blng_class_code.arr[0] == '\0')
                       strcpy(nd_reason_text.arr,"No Billing Class Code is available for this record");     		
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
	 else if (bl_pat_bill_type_code.arr[0] == '\0')
                       strcpy(nd_reason_text.arr,"No Bill Type Code is available for this record");     		

     else if (bl_pat_patient_id.arr[0] == '\0')
                       strcpy(nd_reason_text.arr,"No Patient Id  is available for this record");     		

     if (nd_reason_text.arr[0] != '\0')
     {
		/*  
			This is a folio posting program and hence Bills records need not be 
			updated with Unposted Reason - 27/01/2004 Harish.	
		
		     SQL UPDATE  BL_BILL_HDR
					SET  UNPOSTED_REASON		= :nd_reason_text,
						 BILL_POSTED_FLAG		= 'N',  
						 MODIFIED_BY_ID         = user,
						 MODIFIED_DATE          = SYSDATE,
						 MODIFIED_AT_WS_NO      = :nd_ws_no,
						 MODIFIED_FACILITY_ID   = :nd_operating_facility_id
				 WHERE	 OPERATING_FACILITY_ID	= :nd_operating_facility_id
				   AND   DOC_TYPE_CODE			= :cpatdoctypecode
				   AND   DOC_NUM				= :cpatdocnum ;

		if (OERROR)
			err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");*/


		/* EXEC SQL UPDATE BL_PACKAGE_CHARGES_FOLIO
					SET UNPOSTED_REASON = :nd_reason_text,
						TRX_POSTED_IND = 'N',
		    			MODIFIED_BY_ID			= user,
	            		MODIFIED_DATE			= SYSDATE,
	            		MODIFIED_AT_WS_NO		= :nd_ws_no,
		    			MODIFIED_FACILITY_ID	= :nd_operating_facility_id
				  WHERE TRX_DOC_REF				= :bl_store_trx_doc_ref
				    AND TRX_DOC_REF_LINE_NUM	= TRX_DOC_REF_LINE_NUM 
					AND OPERATING_FACILITY_ID	= :nd_operating_facility_id
					AND TRX_DOC_REF_SEQ_NUM		= TRX_DOC_REF_SEQ_NUM  
					AND NVL(TRX_POSTED_IND,'X') = 'N'
					AND TRX_DATE <= TO_DATE(:nd_post_upto_date||' 23:59','DD/MM/YYYY HH24:MI')
					AND NVL(TRX_FINALIZE_IND,'N')= 'Y'
					AND	(EPISODE_TYPE not in ('O','E') 
						 OR 
						(EPISODE_TYPE in ('O','E') AND NVL(AVAILED_IND,'N') NOT IN ('Y','U','C'))); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 80;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_PACKAGE_CHARGES_FOLIO  set UNPOSTED_REASON=:b0,TR\
X_POSTED_IND='N',MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:\
b1,MODIFIED_FACILITY_ID=:b2 where (((((((TRX_DOC_REF=:b3 and TRX_DOC_REF_LINE_\
NUM=TRX_DOC_REF_LINE_NUM) and OPERATING_FACILITY_ID=:b2) and TRX_DOC_REF_SEQ_N\
UM=TRX_DOC_REF_SEQ_NUM) and NVL(TRX_POSTED_IND,'X')='N') and TRX_DATE<=TO_DATE\
((:b5||' 23:59'),'DD/MM/YYYY HH24:MI')) and NVL(TRX_FINALIZE_IND,'N')='Y') and\
 (EPISODE_TYPE not  in ('O','E') or (EPISODE_TYPE in ('O','E') and NVL(AVAILED\
_IND,'N') not  in ('Y','U','C'))))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1473;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_reason_text;
  sqlstm.sqhstl[0] = (unsigned int  )53;
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
  sqlstm.sqhstv[3] = (         void  *)&bl_store_trx_doc_ref;
  sqlstm.sqhstl[3] = (unsigned int  )23;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
	 err_mesg("UPDATE failed on table BL_PACKAGE_CHARGES_FOLIO",0,"");


	
    }
}

