
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
    "T:\\temp\\Bl\\ganapathy\\JDWORK\\PROC\\Blbarcon.pc"
};


static unsigned long sqlctx = 1267623845;


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
            void  *sqhstv[65];
   unsigned int   sqhstl[65];
            int   sqhsts[65];
            void  *sqindv[65];
            int   sqinds[65];
   unsigned int   sqharm[65];
   unsigned int   *sqharc[65];
   unsigned short  sqadto[65];
   unsigned short  sqtdso[65];
} sqlstm = {10,65};

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

 static const char *sq0017 = 
"select NVL(STATUS,'X') ,'Y' ,NVL(DOC_NUM_GEN_FLAG,'X')  from SY_ACC_ENTITY_D\
OC_TYPE where (DOC_TYPE_CODE=:b0 and ACC_ENTITY_CODE in (select ACC_ENTITY_COD\
E  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0018 = 
"select 'X'  from AR_TRN_DOC_TYPE where ((DOC_TYPE_CODE=:b0 and TRN_TYPE_CODE\
='1') and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where\
 ACC_ENTITY_ID=:b1))           ";

 static const char *sq0008 = 
"select DOC_TYPE_CODE ,DOC_NUM ,OPERATING_FACILITY_ID  from BL_BILL_HDR where\
 (((((((RPAD(cust_code,8) between RPAD(NVL(:b0,' '),8,' ') and RPAD(NVL(:b1,'~\
~~~~~~~'),8,' ') and TRUNC(DOC_DATE) between NVL(TO_DATE(:b2,'DD/MM/YYYY'),TRU\
NC(DOC_DATE)) and NVL(TO_DATE(:b3,'DD/MM/YYYY'),TRUNC(DOC_DATE))) and ((((RPAD\
(DOC_TYPE_CODE,6,' ')||LPAD(DOC_NUM,8,'0')) between (RPAD(NVL(:b4,' '),6,' ')|\
|LPAD(NVL(:b5,0),8,'0')) and (RPAD(NVL(:b6,'~~~~~~'),6,' ')||LPAD(NVL(:b7,9999\
9999),8,'0')) and OPERATING_FACILITY_ID=:b8) and :b9='BLBARCON') or ((DOC_TYPE\
_CODE,DOC_NUM) in (select DOC_TYPE_CODE ,DOC_NUM  from AR_DOC_ERROR where PGM_\
ID='ARTGNINV') and :b9='ARTGNINV'))) and BILL_NATURE_CODE='A') and BILL_POSTED\
_FLAG='Y') and BILL_STATUS is null ) and CUST_CODE is  not null ) and NVL(BILL\
_TOT_OUTST_AMT,0)<>0) order by CUST_CODE            ";

 static const char *sq0009 = 
"TO_CHAR(AR_INV_DOC_DATE,'DD/MM/YYYY') ,LAST_RECPT_DOC_TYPE_CODE ,LAST_RECPT_\
DOC_NUM ,TO_CHAR(LAST_RECPT_DOC_DATE,'DD/MM/YYYY') ,BILL_NATURE_CODE ,TOT_PAID\
_AMT ,BILL_POSTED_FLAG ,ADDED_BY_ID ,MODIFIED_BY_ID ,ADDED_DATE ,MODIFIED_DATE\
 ,ROWID  from BL_BILL_HDR where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) for update\
 of DOC_TYPE_CODE nowait ";

 static const char *sq0010 = 
"select SHORT_DESC  from BL_BILL_TYPE where (BILL_TYPE_CODE=:b0 and ACC_ENTIT\
Y_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1)\
)           ";

 static const char *sq0011 = 
"select BL_RECV_ACC_INT_CODE ,AR_RECV_ACC_INT_CODE  from BL_BILL_TYPE where (\
BILL_TYPE_CODE=:b0 and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC\
_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0012 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,SUBLEDGER_GROUP_CODE ,SUBL\
EDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE  from BL_GL_ACCOUNT whe\
re (ACC_INT_CODE=:b0 and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_A\
CC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0013 = 
"select PMNT_TERMS_CODE ,GL_MAIN_ACC1_CODE ,GL_MAIN_ACC2_CODE  from AR_CUSTOM\
ER where (CUST_CODE=:b0 and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from S\
Y_ACC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0014 = 
"select CREDIT_DAYS_PERIOD ,SETTLEMENT_DAYS_PERIOD ,SETTLEMENT_PERC  from AR_\
PMNT_TERMS where (PMNT_TERMS_CODE=:b0 and ACC_ENTITY_CODE in (select ACC_ENTIT\
Y_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,75,0,4,246,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
28,0,0,2,0,0,29,302,0,0,0,0,0,1,0,
43,0,0,3,0,0,29,350,0,0,0,0,0,1,0,
58,0,0,4,0,0,30,357,0,0,0,0,0,1,0,
73,0,0,5,365,0,4,414,0,0,24,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
184,0,0,6,84,0,2,469,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
211,0,0,7,117,0,4,491,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
238,0,0,17,212,0,9,708,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
261,0,0,17,0,0,13,721,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
288,0,0,18,185,0,9,743,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
311,0,0,18,0,0,13,748,0,0,1,0,0,1,0,2,9,0,0,
330,0,0,8,830,0,9,761,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
389,0,0,8,0,0,13,779,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
416,0,0,9,1359,0,9,933,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
439,0,0,9,0,0,13,947,0,0,65,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
714,0,0,19,219,0,4,1099,0,0,4,2,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
745,0,0,20,127,0,5,1115,0,0,1,1,0,1,0,1,9,0,0,
764,0,0,10,166,0,9,1129,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
787,0,0,10,0,0,13,1138,0,0,1,0,0,1,0,2,9,0,0,
806,0,0,11,198,0,9,1153,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
829,0,0,11,0,0,13,1164,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
852,0,0,12,278,0,9,1179,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
875,0,0,12,0,0,13,1200,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
918,0,0,12,278,0,9,1225,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
941,0,0,12,0,0,13,1248,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
984,0,0,13,203,0,9,1271,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1007,0,0,13,0,0,13,1282,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1034,0,0,14,217,0,9,1307,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1057,0,0,14,0,0,13,1320,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1084,0,0,21,277,0,3,1342,0,0,12,12,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1147,0,0,22,69,0,4,1382,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1170,0,0,23,1120,0,3,1408,0,0,42,42,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1353,0,0,24,452,0,3,1518,0,0,19,19,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1444,0,0,25,338,0,5,1572,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1495,0,0,26,205,0,5,1590,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1530,0,0,27,222,0,5,1604,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1569,0,0,28,484,0,5,1620,0,0,11,11,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/*************************************************************************/
/* OCS MEDICOM VER 1.0                                                   */
/************************************************************************/
/* PROGRAM NAME          : BLBARCON.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 07-AUG-1993                                  */
/*                                                                      */  
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*          1.         BL_BILL_HDR               Read                   */
/*          2.         BL_BILL_LINE              Read                   */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :             -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*  UPGRADED TO 4.1                                                     */
/************************************************************************/
          
#include <stdio.h>     
#include <string.h>
#include <gl.h>
#include <bl.h>

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define VIEW_LOG_FILE     1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
	    date_time                                  [20],
	    user_id                                    [40],
	    nd_session_id                              [16],
	    nd_pgm_date                                [25],
	    d_curr_pgm_id                              [15],
	    nd_cust_code                               [9],
	    nd_billing_grp                             [3],
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
	    nd_p_month                                 [3],
	    nd_p_year                                  [5],
	    nd_operating_facility_id		       [3],
	    nd_facility_id			       [3],
	    nd_ws_no				       [31],
	    nd_module_id			       [3],
	    nd_inv_status			       [2],
	    nd_acc_entity_code			       [5],
	    nd_dr_cnt_acc                              [2],
	    nd_fm_cust				       [9],
	    nd_to_cust				       [9],
	    d_acc_status                               [2],
	    d_acc_valid_flag                           [2],
	    nd_pat_name				       [100],
	    l_dummy                                    [10][2],
	    d_sy_acc_rowid                             [31]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_id;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[3]; } nd_billing_grp;

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

struct { unsigned short len; unsigned char arr[3]; } nd_p_month;

struct { unsigned short len; unsigned char arr[5]; } nd_p_year;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[3]; } nd_module_id;

struct { unsigned short len; unsigned char arr[2]; } nd_inv_status;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[2]; } nd_dr_cnt_acc;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_cust;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust;

struct { unsigned short len; unsigned char arr[2]; } d_acc_status;

struct { unsigned short len; unsigned char arr[2]; } d_acc_valid_flag;

struct { unsigned short len; unsigned char arr[100]; } nd_pat_name;

struct { unsigned short len; unsigned char arr[2]; } l_dummy[10];

struct { unsigned short len; unsigned char arr[31]; } d_sy_acc_rowid;


      long  nd_inv_start_doc_num,
	    nd_new_doc_num;

   /* VARCHAR bl_h_doc_type_code                          [7],
	   bl_h_doc_num                                [9],
	   bl_h_doc_date                               [13],
	   bl_h_bill_trx_type_code                     [2],
	   bl_h_serv_locn_code                         [5],
	   bl_h_bill_from_date                         [13],
	   bl_h_bill_to_date                           [13],
	   bl_h_gross_amt                              [23],
	   bl_h_serv_disc_amt                          [23],
	   bl_h_man_disc_amt                           [23],
	   bl_h_overall_disc_perc                      [6],
	   bl_h_overall_disc_amt                       [23],
	   bl_h_ovr_disc_acc_int_code                  [7],
	   bl_h_prepay_adj_amt                         [23],
	   bl_h_deposit_adj_amt                        [23],
	   bl_h_bill_amt                               [23],
	   bl_h_bill_hosp_amt                          [23],
	   bl_h_bill_drfee_amt                         [23],
	   bl_h_bill_prv_doc_type_code                 [7],
	   bl_h_bill_prv_doc_number                    [23],
	   bl_h_bill_prv_doc_date                      [13],
	   bl_h_bill_prv_bill_amt                      [23],
	   bl_h_bill_prv_bill_paid_amt                 [23],
	   bl_h_bill_prv_outst_amt                     [23],
	   bl_h_bill_hosp_prv_outst_amt                [23],
	   bl_h_bill_drfee_prv_os_amt                  [23],
	   bl_h_bill_tot_amt                           [23],
	   bl_h_bill_hosp_tot_amt                      [23],
	   bl_h_bill_drfee_tot_amt                     [23],
	   bl_h_bill_tot_outst_amt                     [23],
	   bl_h_bill_hosp_tot_outst_amt                [23],
	   bl_h_bill_drfee_tot_os_amt                  [23],
	   bl_h_bill_paid_amt                          [23],
	   bl_h_episode_type                           [2],
	   bl_h_patient_id                             [21],
	   bl_h_episode_id                             [9],
	   bl_h_visit_id                               [5],
	   bl_h_admission_date                         [13],
	   bl_h_ward_code                              [5],
	   bl_h_bed_class_code                         [3],
	   bl_h_room_num                               [5],
	   bl_h_bed_num                                [9],
	   bl_h_physician_id                           [16],
	   bl_h_clinic_code                            [5],
	   bl_h_cust_code                              [9],
	   bl_h_blng_grp_id                            [3],
	   bl_h_bill_type_code                         [3],
	   bl_h_cons_invoice_ind                       [2],
	   bl_h_bill_status                            [2],
	   bl_h_bill_print_flag                        [2],
	   bl_h_drfee_bill_upd_flag                    [2],
	   bl_h_drfee_rec_upd_flag                     [2],
	   bl_h_drfee_receipt_amt                      [23],
	   bl_h_ar_inv_doc_type_code                   [7],
	   bl_h_ar_inv_doc_number                      [9],
	   bl_h_ar_inv_doc_date                        [13],
	   bl_h_last_recpt_doc_ty_cd                   [7],
	   bl_h_last_recpt_doc_num                     [23],
	   bl_h_last_recpt_doc_date                    [13],
	   bl_h_bill_nature_code                       [2],
	   bl_h_tot_paid_amt                           [23],
	   bl_h_bill_posted_flag                       [2],
	   bl_h_added_by_id                            [21],
	   bl_h_modified_by_id                         [21],
	   bl_h_added_date                             [13],
	   bl_h_modified_date                          [13],
	   bl_h_rowid                                  [31],
	   p_gl_acc1_code	  		       [31],	
	   p_gl_acc2_code                              [31],
	   nd_new_doc_type_code                        [7],
	   nd_narration				       [51],
	   bl_par_post_month                           [3],
	   bl_par_post_year                            [5],

	   recv_int_code                               [7],
	   bl_recv_acc_int_code                        [7],
	   ar_recv_acc_int_code                        [7],
	   bl_bill_type_short_desc                     [16],

	   bl_rec_main_acc1_code                       [7],
	   bl_rec_main_acc2_code                       [5],
	   bl_rec_dept_code                            [7],
	   bl_rec_subledger_group_code                 [4],
	   bl_rec_subledger_line_code                  [9],
	   bl_rec_product_group_code                   [4],
	   bl_rec_product_line_code                    [5],

	   ar_rec_main_acc1_code                       [7],
	   ar_rec_main_acc2_code                       [5],
	   ar_rec_dept_code                            [7],
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
	   bl_h_prev_cust_code                         [9]; */ 
struct { unsigned short len; unsigned char arr[7]; } bl_h_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_h_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_h_doc_date;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_trx_type_code;

struct { unsigned short len; unsigned char arr[5]; } bl_h_serv_locn_code;

struct { unsigned short len; unsigned char arr[13]; } bl_h_bill_from_date;

struct { unsigned short len; unsigned char arr[13]; } bl_h_bill_to_date;

struct { unsigned short len; unsigned char arr[23]; } bl_h_gross_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_serv_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_man_disc_amt;

struct { unsigned short len; unsigned char arr[6]; } bl_h_overall_disc_perc;

struct { unsigned short len; unsigned char arr[23]; } bl_h_overall_disc_amt;

struct { unsigned short len; unsigned char arr[7]; } bl_h_ovr_disc_acc_int_code;

struct { unsigned short len; unsigned char arr[23]; } bl_h_prepay_adj_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_deposit_adj_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_amt;

struct { unsigned short len; unsigned char arr[7]; } bl_h_bill_prv_doc_type_code;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_prv_doc_number;

struct { unsigned short len; unsigned char arr[13]; } bl_h_bill_prv_doc_date;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_prv_bill_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_prv_bill_paid_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_prv_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_prv_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_prv_os_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_tot_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_tot_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_tot_os_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_paid_amt;

struct { unsigned short len; unsigned char arr[2]; } bl_h_episode_type;

struct { unsigned short len; unsigned char arr[21]; } bl_h_patient_id;

struct { unsigned short len; unsigned char arr[9]; } bl_h_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_h_visit_id;

struct { unsigned short len; unsigned char arr[13]; } bl_h_admission_date;

struct { unsigned short len; unsigned char arr[5]; } bl_h_ward_code;

struct { unsigned short len; unsigned char arr[3]; } bl_h_bed_class_code;

struct { unsigned short len; unsigned char arr[5]; } bl_h_room_num;

struct { unsigned short len; unsigned char arr[9]; } bl_h_bed_num;

struct { unsigned short len; unsigned char arr[16]; } bl_h_physician_id;

struct { unsigned short len; unsigned char arr[5]; } bl_h_clinic_code;

struct { unsigned short len; unsigned char arr[9]; } bl_h_cust_code;

struct { unsigned short len; unsigned char arr[3]; } bl_h_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } bl_h_bill_type_code;

struct { unsigned short len; unsigned char arr[2]; } bl_h_cons_invoice_ind;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_status;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_print_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_h_drfee_bill_upd_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_h_drfee_rec_upd_flag;

struct { unsigned short len; unsigned char arr[23]; } bl_h_drfee_receipt_amt;

struct { unsigned short len; unsigned char arr[7]; } bl_h_ar_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_h_ar_inv_doc_number;

struct { unsigned short len; unsigned char arr[13]; } bl_h_ar_inv_doc_date;

struct { unsigned short len; unsigned char arr[7]; } bl_h_last_recpt_doc_ty_cd;

struct { unsigned short len; unsigned char arr[23]; } bl_h_last_recpt_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_h_last_recpt_doc_date;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_nature_code;

struct { unsigned short len; unsigned char arr[23]; } bl_h_tot_paid_amt;

struct { unsigned short len; unsigned char arr[2]; } bl_h_bill_posted_flag;

struct { unsigned short len; unsigned char arr[21]; } bl_h_added_by_id;

struct { unsigned short len; unsigned char arr[21]; } bl_h_modified_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_h_added_date;

struct { unsigned short len; unsigned char arr[13]; } bl_h_modified_date;

struct { unsigned short len; unsigned char arr[31]; } bl_h_rowid;

struct { unsigned short len; unsigned char arr[31]; } p_gl_acc1_code;

struct { unsigned short len; unsigned char arr[31]; } p_gl_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } nd_new_doc_type_code;

struct { unsigned short len; unsigned char arr[51]; } nd_narration;

struct { unsigned short len; unsigned char arr[3]; } bl_par_post_month;

struct { unsigned short len; unsigned char arr[5]; } bl_par_post_year;

struct { unsigned short len; unsigned char arr[7]; } recv_int_code;

struct { unsigned short len; unsigned char arr[7]; } bl_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[7]; } ar_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[16]; } bl_bill_type_short_desc;

struct { unsigned short len; unsigned char arr[7]; } bl_rec_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_rec_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } bl_rec_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_rec_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_rec_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_rec_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_rec_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } ar_rec_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } ar_rec_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } ar_rec_dept_code;

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

struct { unsigned short len; unsigned char arr[9]; } bl_h_prev_cust_code;


    double nd_sum_outst_amt = 0,
	   nd_sum_drfee_amt = 0;

      int  nd_ctr = 0;
      int  nd_first = 1;

/* EXEC SQL END DECLARE SECTION; */ 

/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blbarcon.c-arc   1.0   Apr 19 2007 17:04:10   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blbarcon.c-arc   1.0   Apr 19 2007 17:04:10   vcm_th  $ sqlda.h 
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

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;

    if (argc < 6)
    {
     int i = 0;
       disp_message(ERR_MESG,"USAGE : BLBARCON USER/PWD@DB SESSION PGM_DATE FACILITY PGM_ID");
       proc_exit();
    }
 
    
    if (sql_connect(argv[1]) == -1)
    {
	disp_message(ORA_MESG,"Error in connecting to Oracle");
	proc_exit();
    }

    set_meduser_role();

    start_prog_msg();        

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    strcpy(nd_facility_id.arr,argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);
    strcpy(g_facility_id,nd_facility_id.arr);

    strcpy(d_curr_pgm_id.arr,argv[5]);
    d_curr_pgm_id.len = strlen(d_curr_pgm_id.arr);
    strcpy(g_pgm_id,d_curr_pgm_id.arr);    

    nd_acc_entity_code.arr[0] = '\0';
    nd_acc_entity_code.len = 0;

    /* EXEC SQL select acc_entity_code into :nd_acc_entity_code from sy_acc_entity
	 where acc_entity_id = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select acc_entity_code into :b0  from sy_acc_entity where\
 acc_entity_id=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.selerr = (unsigned short)1;
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



   if (OERROR||LAST_ROW)
	err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

    nd_acc_entity_code.len = strlen(nd_acc_entity_code.arr);


    fetch_prog_param();
    fetch_bl_param();

    declare_cur();
     
    open_cur_hdr();

    strcpy(nd_new_doc_type_code.arr,nd_inv_doc_type_code.arr);
    nd_new_doc_type_code.len = strlen(nd_new_doc_type_code.arr);

    nd_new_doc_num           = nd_inv_start_doc_num;

    nd_sum_outst_amt = 0;
    nd_sum_drfee_amt = 0;
    nd_ctr = 0;
    nd_first = 1;

    while(fetch_cur())
    {
       /*
       if (nd_doc_num_gen_flag.arr[0] == 'Y' && rec_ctr == 1)
	    gen_doc_num();
       */
	   
       if (!lock_record())
  	        continue;

       if (nd_first == 1) {
	   strcpy(bl_h_prev_cust_code.arr,bl_h_cust_code.arr);
	   bl_h_prev_cust_code.len = strlen(bl_h_prev_cust_code.arr);
	   nd_first = 0;
	   }

       rec_ctr++;

       if(strcmp(bl_h_prev_cust_code.arr, bl_h_cust_code.arr)) {

	  if (nd_doc_num_gen_flag.arr[0] == 'Y')
	       gen_doc_num();
          

	  if (rec_ctr > 0)
	  {
	     fetch_dtls();
	     insert_ar_rec();
	  }

	  /* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 2;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )28;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	  if (OERROR)
	       err_mesg("COMMIT failed",0,""); 

	  strcpy(bl_h_prev_cust_code.arr,bl_h_cust_code.arr);
	  bl_h_prev_cust_code.len = strlen(bl_h_prev_cust_code.arr);

	  nd_sum_outst_amt = 0;
	  nd_sum_drfee_amt = 0;
	  nd_ctr = 0;	  
	  nd_inv_start_doc_num ++;
       }

       fetch_pat_dtls();
       insert_ar_patient();
       update_bl_hdr();

       nd_sum_outst_amt += atof(bl_h_bill_tot_outst_amt.arr);
       nd_sum_drfee_amt += atof(bl_h_bill_drfee_tot_os_amt.arr);
/*
       strcpy(bl_h_prev_cust_code.arr,bl_h_cust_code.arr);
       bl_h_prev_cust_code.len = strlen(bl_h_prev_cust_code.arr);
*/
       nd_ctr++;

       if (nd_ctr == 1)
       {
	  strcpy(nd_st_patient_id.arr,bl_h_patient_id.arr);
	  strcpy(nd_st_doc_type_code.arr,bl_h_doc_type_code.arr);
	  strcpy(nd_st_doc_num.arr,bl_h_doc_num.arr);
	  strcpy(nd_st_doc_date.arr,bl_h_doc_date.arr);

	  nd_st_patient_id.len    =  strlen(nd_st_patient_id.arr);
	  nd_st_doc_type_code.len =  strlen(nd_st_doc_type_code.arr);
	  nd_st_doc_num.len       =  strlen(nd_st_doc_num.arr);
	  nd_st_doc_date.len      =  strlen(nd_st_doc_date.arr);
       }

    }

    if (rec_ctr > 0)
    {
       fetch_dtls();
       insert_ar_rec();
       gen_doc_num();
    }

    /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )43;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
	err_mesg("COMMIT failed",0,""); 

    end_prog_msg();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )58;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
	 err_mesg("COMMIT WORK RELEASE failed REA",0,"");

   return;
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
    nd_p_month.arr[0]                   = '\0';
    nd_p_year.arr[0]                    = '\0';
    nd_dr_cnt_acc.arr[0]                = '\0';
    nd_ws_no.arr[0]			= '\0';
    nd_module_id.arr[0]			= '\0';
    nd_inv_status.arr[0]		= '\0';
    nd_fm_cust.arr[0]			= '\0';
    nd_to_cust.arr[0]			= '\0';

    

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
    nd_inv_start_doc_num                = 0;
    nd_p_month.len                      = 0;
    nd_p_year.len                       = 0;
    nd_dr_cnt_acc.len                   = 0;
    nd_ws_no.len			= 0;
    nd_module_id.len			= 0;
    nd_inv_status.len			= 0;
    nd_fm_cust.len			= 0;
    nd_to_cust.len			= 0;
    

   /* EXEC SQL SELECT PARAM1, PARAM2, 
		   PARAM3, PARAM4,
		   PARAM5, PARAM6, 
		   PARAM7, PARAM8, 
		   PARAM9, PARAM10, 
		   PARAM11,PARAM12, 
		   PARAM13,PARAM14, 
		   PARAM15, PARAM16,
		   PARAM17,PARAM18,
		   PARAM19,PARAM20,
		   PARAM21
	      INTO :nd_billing_grp,      :nd_cust_code,
		   :nd_fm_doc_date,      :nd_to_doc_date,
		   :nd_fm_doc_type_code, :nd_to_doc_type_code,
		   :nd_fm_doc_num,       :nd_to_doc_num,
		   :nd_inv_doc_type_code,:nd_inv_start_doc_num,
		   :nd_inv_date,         :nd_bill_type,
		   :nd_credit_ref,       :nd_p_month,
		   :nd_p_year, 	         :nd_dr_cnt_acc,
		   :nd_ws_no,	         :nd_module_id,
		   :nd_inv_status,       :nd_fm_cust,
		   :nd_to_cust 
	     FROM SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_id
	      AND SESSION_ID = :nd_session_id
	      AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,PAR\
AM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 ,PARAM21 into :b0,:b1,:b2,:b3,:b4,:b5\
,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20  from \
SY_PROG_PARAM where ((PGM_ID=:b21 and SESSION_ID=:b22) and PGM_DATE=:b23)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )73;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_billing_grp;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_inv_doc_type_code;
   sqlstm.sqhstl[8] = (unsigned int  )9;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_inv_start_doc_num;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_inv_date;
   sqlstm.sqhstl[10] = (unsigned int  )14;
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
   sqlstm.sqhstv[12] = (         void  *)&nd_credit_ref;
   sqlstm.sqhstl[12] = (unsigned int  )18;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_p_month;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_p_year;
   sqlstm.sqhstl[14] = (unsigned int  )7;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_dr_cnt_acc;
   sqlstm.sqhstl[15] = (unsigned int  )4;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[16] = (unsigned int  )33;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_module_id;
   sqlstm.sqhstl[17] = (unsigned int  )5;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_inv_status;
   sqlstm.sqhstl[18] = (unsigned int  )4;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_fm_cust;
   sqlstm.sqhstl[19] = (unsigned int  )11;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_to_cust;
   sqlstm.sqhstl[20] = (unsigned int  )11;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_curr_pgm_id;
   sqlstm.sqhstl[21] = (unsigned int  )17;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[22] = (unsigned int  )18;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[23] = (unsigned int  )27;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
   nd_billing_grp.arr[nd_billing_grp.len] 	      = '\0';
   nd_cust_code.arr[nd_cust_code.len] 		      = '\0';
   nd_bill_type.arr[nd_bill_type.len] 		      = '\0';
   nd_credit_ref.arr[nd_credit_ref.len]		      = '\0';
   nd_p_month.arr[nd_p_month.len]                     = '\0';
   nd_p_year.arr[nd_p_year.len]                       = '\0';
   nd_dr_cnt_acc.arr[nd_dr_cnt_acc.len]               = '\0';
   nd_ws_no.arr[nd_ws_no.len]			      = '\0';
   nd_module_id.arr[nd_module_id.len]		      = '\0';
   nd_inv_status.arr[nd_inv_status.len]		      = '\0';
   nd_fm_cust.arr[nd_fm_cust.len]		      = '\0';
   nd_to_cust.arr[nd_to_cust.len]		      = '\0';
   
   /* EXEC SQL DELETE SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_id
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )184;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_id;
   sqlstm.sqhstl[0] = (unsigned int  )17;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )27;
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
	 err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
   val_doc_type();

}

fetch_bl_param()
{


    bl_par_post_month.arr[0]      = '\0';
    bl_par_post_year.arr[0]       = '\0';

    bl_par_post_month.len         = 0;
    bl_par_post_year.len          = 0;

    /* EXEC SQL SELECT CURRENT_PROC_ACC_MONTH,  CURRENT_PROC_ACC_YEAR
	     INTO :bl_par_post_month, :bl_par_post_year
	     FROM BL_PARAMETERS
     	     WHERE OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CURRENT_PROC_ACC_MONTH ,CURRENT_PROC_ACC_YEAR into\
 :b0,:b1  from BL_PARAMETERS where OPERATING_FACILITY_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )211;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
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
	 err_mesg("SELECT failed on table BL_PARAMETERS",0,"");

    if (NOT_FOUND)
	err_mesg("Record not found in BL PARAMETERS",0,"");

    bl_par_post_month.arr[bl_par_post_month.len] = '\0';
    bl_par_post_year.arr[bl_par_post_year.len] = '\0';     
    
   
   /*This following reassignment is to cater the inputs we have given in
    the form ( the month and year for which the posting has to be done).*/    
    
    strcpy(bl_par_post_month.arr,nd_p_month.arr);
    strcpy(bl_par_post_year.arr,nd_p_year.arr);    

    bl_par_post_month.len = strlen(bl_par_post_month.arr);
    bl_par_post_year.len  = strlen(bl_par_post_year.arr);     
    
}

declare_cur()
{
     /* EXEC SQL DECLARE BL_HDR_CUR CURSOR FOR
	       SELECT DOC_TYPE_CODE,
		      DOC_NUM,
		      OPERATING_FACILITY_ID
		 FROM BL_BILL_HDR
		WHERE 
		      //BLNG_GRP_ID = :nd_billing_grp AND 

	    	      RPAD(cust_code,8) BETWEEN
		      RPAD(NVL(:nd_fm_cust,' '),8,' ')   AND
		      RPAD(NVL(:nd_to_cust,'~~~~~~~~'),8,' ') AND 
		      TRUNC(DOC_DATE) BETWEEN
		      NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),TRUNC(DOC_DATE)) AND 
		      NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),TRUNC(DOC_DATE)) 

		      AND 
		      ((
		      RPAD(DOC_TYPE_CODE,6,' ')|| LPAD(DOC_NUM,8,'0')  BETWEEN
		      RPAD(NVL(:nd_fm_doc_type_code,' '),6,' ')||
		      LPAD(NVL(:nd_fm_doc_num,0),8,'0')   AND
		      RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6,' ')||
		      LPAD(NVL(:nd_to_doc_num,99999999),8,'0')		      
		      AND OPERATING_FACILITY_ID = :nd_facility_id 
		      AND :d_curr_pgm_id = 'BLBARCON')
		      OR
		      ((DOC_TYPE_CODE,DOC_NUM) IN 
				(SELECT DOC_TYPE_CODE,DOC_NUM FROM AR_DOC_ERROR
			         WHERE PGM_ID = 'ARTGNINV')
  				 AND :d_curr_pgm_id = 'ARTGNINV'))
		  AND BILL_NATURE_CODE = 'A'
		  AND BILL_POSTED_FLAG = 'Y'
		  AND BILL_STATUS IS NULL
		  AND CUST_CODE IS NOT NULL
		  AND NVL(BILL_TOT_OUTST_AMT,0) != 0		  
		  ORDER BY CUST_CODE; */ 


     /* EXEC SQL DECLARE BL_HDR_REC_CUR CURSOR FOR
	       SELECT 
		      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
		      BILL_TRX_TYPE_CODE,
		      SERV_LOCN_CODE,
		      TO_CHAR(BILL_FROM_DATE,'DD/MM/YYYY'),
		      TO_CHAR(BILL_TO_DATE,'DD/MM/YYYY'),
		      GROSS_AMT,
		      SERV_DISC_AMT,
		      MAN_DISC_AMT,
		      OVERALL_DISC_PERC,
		      OVERALL_DISC_AMT,
		      OVR_DISC_ACC_INT_CODE,
		      PREPAY_ADJ_AMT,
		      DEPOSIT_ADJ_AMT,
		      BILL_AMT,
		      BILL_HOSP_AMT,
		      BILL_DRFEE_AMT,
		      BILL_PRV_DOC_TYPE_CODE,
		      BILL_PRV_DOC_NUMBER,
		      TO_CHAR(BILL_PRV_DOC_DATE,'DD/MM/YYYY'),
		      BILL_PRV_BILL_AMT,
		      BILL_PRV_BILL_PAID_AMT,
		      BILL_PRV_OUTST_AMT,
		      BILL_HOSP_PRV_OUTST_AMT,
		      BILL_DRFEE_PRV_OUTST_AMT,
		      BILL_TOT_AMT,
		      BILL_HOSP_TOT_AMT,
		      BILL_DRFEE_TOT_AMT,
		      NVL(BILL_TOT_OUTST_AMT,0),
		      BILL_HOSP_TOT_OUTST_AMT,
		      NVL(BILL_DRFEE_TOT_OUTST_AMT,0),
		      BILL_PAID_AMT,
		      EPISODE_TYPE,
		      PATIENT_ID,
		      EPISODE_ID,
		      VISIT_ID,
		      TO_CHAR(ADMISSION_DATE,'DD/MM/YYYY'),
		      WARD_CODE,
		      BED_CLASS_CODE,
		      ROOM_NUM,
		      BED_NUM,
		      PHYSICIAN_ID,
		      CLINIC_CODE,
		      CUST_CODE,
		      BLNG_GRP_ID,
		      BILL_TYPE_CODE,
		      CONS_INVOICE_IND,
		      BILL_STATUS,
		      BILL_PRINT_FLAG,
		      DRFEE_BILL_UPD_FLAG,
		      DRFEE_REC_UPD_FLAG,
		      DRFEE_RECEIPT_AMT,
		      AR_INV_DOC_TYPE_CODE,
		      AR_INV_DOC_NUMBER,
		      TO_CHAR(AR_INV_DOC_DATE,'DD/MM/YYYY'),
		      LAST_RECPT_DOC_TYPE_CODE,
		      LAST_RECPT_DOC_NUM,
		      TO_CHAR(LAST_RECPT_DOC_DATE,'DD/MM/YYYY'),
		      BILL_NATURE_CODE,
		      TOT_PAID_AMT,
		      BILL_POSTED_FLAG,
		      ADDED_BY_ID,
		      MODIFIED_BY_ID,
		      ADDED_DATE,
		      MODIFIED_DATE,
		      ROWID
		 FROM BL_BILL_HDR
		WHERE DOC_TYPE_CODE = :bl_h_doc_type_code
		  AND DOC_NUM       = :bl_h_doc_num  		  
		  FOR UPDATE OF DOC_TYPE_CODE NOWAIT; */ 


     /* EXEC SQL DECLARE BL_BILL_TYPE_PAT_CUR CURSOR FOR
	       SELECT SHORT_DESC
		 FROM BL_BILL_TYPE
		WHERE BILL_TYPE_CODE = :bl_h_bill_type_code
		AND   ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_facility_id ); */ 


     /* EXEC SQL DECLARE BL_BILL_TYPE_CUR CURSOR FOR
	       SELECT BL_RECV_ACC_INT_CODE,
		      AR_RECV_ACC_INT_CODE
		 FROM BL_BILL_TYPE
		WHERE BILL_TYPE_CODE = :nd_bill_type
		AND   ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_facility_id ); */ 

     /* EXEC SQL DECLARE BL_GL_ACCOUNT_CUR CURSOR FOR
	       SELECT MAIN_ACC1_CODE,
		      MAIN_ACC2_CODE,
		      DEPT_CODE,
		      SUBLEDGER_GROUP_CODE,
		      SUBLEDGER_LINE_CODE,
		      PRODUCT_GROUP_CODE,
		      PRODUCT_LINE_CODE
		 FROM BL_GL_ACCOUNT
		WHERE ACC_INT_CODE = :recv_int_code
		AND   ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_facility_id  ); */ 

 
     /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
	       SELECT PMNT_TERMS_CODE, GL_MAIN_ACC1_CODE,
	       		  GL_MAIN_ACC2_CODE
		 FROM AR_CUSTOMER
		WHERE CUST_CODE = :bl_h_prev_cust_code
		AND   ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_facility_id ); */ 


     /* EXEC SQL DECLARE AR_PMNT_TERMS_CUR CURSOR FOR
	       SELECT CREDIT_DAYS_PERIOD,
		      SETTLEMENT_DAYS_PERIOD,
		      SETTLEMENT_PERC
		 FROM AR_PMNT_TERMS
		WHERE PMNT_TERMS_CODE = :bl_cust_pmnt_terms_code
		AND   ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_facility_id ); */ 


     /* EXEC SQL DECLARE BL_EPI_FIN_DTLS_CUR CURSOR FOR
	       SELECT CREDIT_DOC_REF_DESC
		 FROM BL_EPISODE_FIN_DTLS
		WHERE EPISODE_TYPE = DECODE(:bl_h_bill_trx_type_code,
					    'E','O','D','I','A','I')
		  AND EPISODE_ID   = :bl_h_episode_id
		  AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 


     /* EXEC SQL DECLARE BL_VISIT_FIN_DTLS_CUR CURSOR FOR
	       SELECT CREDIT_DOC_REF_DESC
		 FROM BL_VISIT_FIN_DTLS
		WHERE EPISODE_TYPE = 'O'
		  AND EPISODE_ID   = :bl_h_episode_id
		  AND VISIT_ID     = :bl_h_visit_id
		  AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 


   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
	     SELECT NVL(STATUS,'X'),
		    'Y',  --NVL(AR_VALID_FLAG,'X'),
		    NVL(DOC_NUM_GEN_FLAG,'X')
	       FROM SY_ACC_ENTITY_DOC_TYPE
	      WHERE DOC_TYPE_CODE   = :nd_inv_doc_type_code
		AND ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_facility_id ); */ 


   /* EXEC SQL DECLARE AR_TRN_DOC_TYPE_CUR CURSOR FOR
	     SELECT 'X'
	       FROM AR_TRN_DOC_TYPE
	      WHERE DOC_TYPE_CODE = :nd_inv_doc_type_code
		AND TRN_TYPE_CODE = '1'
		AND ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_facility_id ); */ 

}

val_doc_type()
{

   /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0017;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )238;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )261;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0018;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )288;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
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
	 err_mesg("OPEN failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   /* EXEC SQL FETCH AR_TRN_DOC_TYPE_CUR
	     INTO :l_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )311;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
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

open_cur_hdr()
{
     /* EXEC SQL OPEN BL_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0008;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )330;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fm_cust;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_cust;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_date;
     sqlstm.sqhstl[2] = (unsigned int  )14;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_date;
     sqlstm.sqhstl[3] = (unsigned int  )14;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_num;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_type_code;
     sqlstm.sqhstl[6] = (unsigned int  )9;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_num;
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
     sqlstm.sqhstv[9] = (         void  *)&d_curr_pgm_id;
     sqlstm.sqhstl[9] = (unsigned int  )17;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_curr_pgm_id;
     sqlstm.sqhstl[10] = (unsigned int  )17;
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
	 err_mesg("OPEN failed on cursor BL_HDR_CUR",0,"");
	 

}

fetch_cur()
{
	bl_h_doc_type_code.arr[0]                                         = '\0';
	bl_h_doc_num.arr[0]                                               = '\0';
	nd_operating_facility_id.arr[0]					  = '\0';

	bl_h_doc_type_code.len                                            = 0;
	bl_h_doc_num.len                                                  = 0;
	nd_operating_facility_id.len					  = 0;

	/* EXEC SQL FETCH BL_HDR_CUR
	         INTO :bl_h_doc_type_code,
		      :bl_h_doc_num,
		      :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )389;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_h_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_h_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )11;
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
	 err_mesg("FETCH failed on cursor BL_HDR_CUR",0,"");


	bl_h_doc_type_code.arr[bl_h_doc_type_code.len]                    = '\0';
	bl_h_doc_num.arr[bl_h_doc_num.len]                                = '\0';
	nd_operating_facility_id.arr[nd_operating_facility_id.len]        = '\0';
	

	return(LAST_ROW?0:1);
}

lock_record()
{
   static int first = 1;
   char l_str[100];

bl_h_doc_date.arr[0]                                              = '\0';
bl_h_bill_trx_type_code.arr[0]                                    = '\0';
bl_h_serv_locn_code.arr[0]                                        = '\0';
bl_h_bill_from_date.arr[0]                                        = '\0';
bl_h_bill_to_date.arr[0]                                          = '\0';
bl_h_gross_amt.arr[0]                                             = '\0';
bl_h_serv_disc_amt.arr[0]                                         = '\0';
bl_h_man_disc_amt.arr[0]                                          = '\0';
bl_h_overall_disc_perc.arr[0]                                     = '\0';
bl_h_overall_disc_amt.arr[0]                                      = '\0';
bl_h_ovr_disc_acc_int_code.arr[0]                                 = '\0';
bl_h_prepay_adj_amt.arr[0]                                        = '\0';
bl_h_deposit_adj_amt.arr[0]                                       = '\0';
bl_h_bill_amt.arr[0]                                              = '\0';
bl_h_bill_hosp_amt.arr[0]                                         = '\0';
bl_h_bill_drfee_amt.arr[0]                                        = '\0';
bl_h_bill_prv_doc_type_code.arr[0]                                = '\0';
bl_h_bill_prv_doc_number.arr[0]                                   = '\0';
bl_h_bill_prv_doc_date.arr[0]                                     = '\0';
bl_h_bill_prv_bill_amt.arr[0]                                     = '\0';
bl_h_bill_prv_bill_paid_amt.arr[0]                                = '\0';
bl_h_bill_prv_outst_amt.arr[0]                                    = '\0';
bl_h_bill_hosp_prv_outst_amt.arr[0]                               = '\0';
bl_h_bill_drfee_prv_os_amt.arr[0]                                 = '\0';
bl_h_bill_tot_amt.arr[0]                                          = '\0';
bl_h_bill_hosp_tot_amt.arr[0]                                     = '\0';
bl_h_bill_drfee_tot_amt.arr[0]                                    = '\0';
bl_h_bill_tot_outst_amt.arr[0]                                    = '\0';
bl_h_bill_hosp_tot_outst_amt.arr[0]                               = '\0';
bl_h_bill_drfee_tot_os_amt.arr[0]                                 = '\0';
bl_h_bill_paid_amt.arr[0]                                         = '\0';
bl_h_episode_type.arr[0]                                          = '\0';
bl_h_patient_id.arr[0]                                            = '\0';
bl_h_episode_id.arr[0]                                            = '\0';
bl_h_visit_id.arr[0]                                              = '\0';
bl_h_admission_date.arr[0]                                        = '\0';
bl_h_ward_code.arr[0]                                             = '\0';
bl_h_bed_class_code.arr[0]                                        = '\0';
bl_h_room_num.arr[0]                                              = '\0';
bl_h_bed_num.arr[0]                                               = '\0';
bl_h_physician_id.arr[0]                                          = '\0';
bl_h_clinic_code.arr[0]                                           = '\0';
bl_h_cust_code.arr[0]                                             = '\0';
bl_h_blng_grp_id.arr[0]                                           = '\0';
bl_h_bill_type_code.arr[0]                                        = '\0';
bl_h_cons_invoice_ind.arr[0]                                      = '\0';
bl_h_bill_status.arr[0]                                           = '\0';
bl_h_bill_print_flag.arr[0]                                       = '\0';
bl_h_drfee_bill_upd_flag.arr[0]                                   = '\0';
bl_h_drfee_rec_upd_flag.arr[0]                                    = '\0';
bl_h_drfee_receipt_amt.arr[0]                                     = '\0';
bl_h_ar_inv_doc_type_code.arr[0]                                  = '\0';
bl_h_ar_inv_doc_number.arr[0]                                     = '\0';
bl_h_ar_inv_doc_date.arr[0]                                       = '\0';
bl_h_last_recpt_doc_ty_cd.arr[0]                                  = '\0';
bl_h_last_recpt_doc_num.arr[0]                                    = '\0';
bl_h_last_recpt_doc_date.arr[0]                                   = '\0';
bl_h_bill_nature_code.arr[0]                                      = '\0';
bl_h_tot_paid_amt.arr[0]                                          = '\0';
bl_h_bill_posted_flag.arr[0]                                      = '\0';
bl_h_added_by_id.arr[0]                                           = '\0';
bl_h_modified_by_id.arr[0]                                        = '\0';
bl_h_added_date.arr[0]                                            = '\0';
bl_h_modified_date.arr[0]                                         = '\0';
bl_h_rowid.arr[0]                                                 = '\0';

bl_h_doc_date.len                                                 = 0;
bl_h_bill_trx_type_code.len                                       = 0;
bl_h_serv_locn_code.len                                           = 0;
bl_h_bill_from_date.len                                           = 0;
bl_h_bill_to_date.len                                             = 0;
bl_h_gross_amt.len                                                = 0;
bl_h_serv_disc_amt.len                                            = 0;
bl_h_man_disc_amt.len                                             = 0;
bl_h_overall_disc_perc.len                                        = 0;
bl_h_overall_disc_amt.len                                         = 0;
bl_h_ovr_disc_acc_int_code.len                                    = 0;
bl_h_prepay_adj_amt.len                                           = 0;
bl_h_deposit_adj_amt.len                                          = 0;
bl_h_bill_amt.len                                                 = 0;
bl_h_bill_hosp_amt.len                                            = 0;
bl_h_bill_drfee_amt.len                                           = 0;
bl_h_bill_prv_doc_type_code.len                                   = 0;
bl_h_bill_prv_doc_number.len                                      = 0;
bl_h_bill_prv_doc_date.len                                        = 0;
bl_h_bill_prv_bill_amt.len                                        = 0;
bl_h_bill_prv_bill_paid_amt.len                                   = 0;
bl_h_bill_prv_outst_amt.len                                       = 0;
bl_h_bill_hosp_prv_outst_amt.len                                  = 0;
bl_h_bill_drfee_prv_os_amt.len                                 = 0;
bl_h_bill_tot_amt.len                                             = 0;
bl_h_bill_hosp_tot_amt.len                                        = 0;
bl_h_bill_drfee_tot_amt.len                                       = 0;
bl_h_bill_tot_outst_amt.len                                       = 0;
bl_h_bill_hosp_tot_outst_amt.len                                  = 0;
bl_h_bill_drfee_tot_os_amt.len                                 = 0;
bl_h_bill_paid_amt.len                                            = 0;
bl_h_episode_type.len                                             = 0;
bl_h_patient_id.len                                               = 0;
bl_h_episode_id.len                                               = 0;
bl_h_visit_id.len                                                 = 0;
bl_h_admission_date.len                                           = 0;
bl_h_ward_code.len                                                = 0;
bl_h_bed_class_code.len                                           = 0;
bl_h_room_num.len                                                 = 0;
bl_h_bed_num.len                                                  = 0;
bl_h_physician_id.len                                             = 0;
bl_h_clinic_code.len                                              = 0;
bl_h_cust_code.len                                                = 0;
bl_h_blng_grp_id.len                                              = 0;
bl_h_bill_type_code.len                                           = 0;
bl_h_cons_invoice_ind.len                                         = 0;
bl_h_bill_status.len                                              = 0;
bl_h_bill_print_flag.len                                          = 0;
bl_h_drfee_bill_upd_flag.len                                      = 0;
bl_h_drfee_rec_upd_flag.len                                       = 0;
bl_h_drfee_receipt_amt.len                                        = 0;
bl_h_ar_inv_doc_type_code.len                                     = 0;
bl_h_ar_inv_doc_number.len                                        = 0;
bl_h_ar_inv_doc_date.len                                          = 0;
bl_h_last_recpt_doc_ty_cd.len                                 = 0;
bl_h_last_recpt_doc_num.len                                       = 0;
bl_h_last_recpt_doc_date.len                                      = 0;
bl_h_bill_nature_code.len                                         = 0;
bl_h_tot_paid_amt.len                                             = 0;
bl_h_bill_posted_flag.len                                         = 0;
bl_h_added_by_id.len                                              = 0;
bl_h_modified_by_id.len                                           = 0;
bl_h_added_date.len                                               = 0;
bl_h_modified_date.len                                            = 0;
bl_h_rowid.len                                                    = 0;

     /* EXEC SQL OPEN BL_HDR_REC_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "select TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,BILL_TRX_TYPE_CODE ,SERV_LOCN\
_CODE ,TO_CHAR(BILL_FROM_DATE,'DD/MM/YYYY') ,TO_CHAR(BILL_TO_DATE,'DD/MM/YYY\
Y') ,GROSS_AMT ,SERV_DISC_AMT ,MAN_DISC_AMT ,OVERALL_DISC_PERC ,OVERALL_DISC\
_AMT ,OVR_DISC_ACC_INT_CODE ,PREPAY_ADJ_AMT ,DEPOSIT_ADJ_AMT ,BILL_AMT ,BILL\
_HOSP_AMT ,BILL_DRFEE_AMT ,BILL_PRV_DOC_TYPE_CODE ,BILL_PRV_DOC_NUMBER ,TO_C\
HAR(BILL_PRV_DOC_DATE,'DD/MM/YYYY') ,BILL_PRV_BILL_AMT ,BILL_PRV_BILL_PAID_A\
MT ,BILL_PRV_OUTST_AMT ,BILL_HOSP_PRV_OUTST_AMT ,BILL_DRFEE_PRV_OUTST_AMT ,B\
ILL_TOT_AMT ,BILL_HOSP_TOT_AMT ,BILL_DRFEE_TOT_AMT ,NVL(BILL_TOT_OUTST_AMT,0\
) ,BILL_HOSP_TOT_OUTST_AMT ,NVL(BILL_DRFEE_TOT_OUTST_AMT,0) ,BILL_PAID_AMT ,\
EPISODE_TYPE ,PATIENT_ID ,EPISODE_ID ,VISIT_ID ,TO_CHAR(ADMISSION_DATE,'DD/M\
M/YYYY') ,WARD_CODE ,BED_CLASS_CODE ,ROOM_NUM ,BED_NUM ,PHYSICIAN_ID ,CLINIC\
_CODE ,CUST_CODE ,BLNG_GRP_ID ,BILL_TYPE_CODE ,CONS_INVOICE_IND ,BILL_STATUS\
 ,BILL_PRINT_FLAG ,DRFEE_BILL_UPD_FLAG ,DRFEE_REC_UPD_FLAG ,DRFEE_RECEIPT_AM\
T ,AR_INV_DOC_TYPE_CODE ,AR_INV_DOC_NUMBER ,");
     sqlstm.stmt = sq0009;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )416;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_h_doc_num;
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



sprintf(l_str,"BL BILL HDR Document %s - %s busy",
	     bl_h_doc_type_code.arr,bl_h_doc_num.arr);

     if (RESOURCE_BUSY)
     {
	 log_err_mesg(l_str,0,"");
	 return(0);
     }
     else if (OERROR)
	 err_mesg("OPEN failed on cursor BL_HDR_REC_CUR",0,"");


     /* EXEC SQL FETCH BL_HDR_REC_CUR
	       INTO :bl_h_doc_date,
		    :bl_h_bill_trx_type_code,
		    :bl_h_serv_locn_code,
		    :bl_h_bill_from_date,
		    :bl_h_bill_to_date,
		    :bl_h_gross_amt,
		    :bl_h_serv_disc_amt,
		    :bl_h_man_disc_amt,
		    :bl_h_overall_disc_perc,
		    :bl_h_overall_disc_amt,
		    :bl_h_ovr_disc_acc_int_code,
		    :bl_h_prepay_adj_amt,
		    :bl_h_deposit_adj_amt,
		    :bl_h_bill_amt,
		    :bl_h_bill_hosp_amt,
		    :bl_h_bill_drfee_amt,
		    :bl_h_bill_prv_doc_type_code,
		    :bl_h_bill_prv_doc_number,
		    :bl_h_bill_prv_doc_date,
		    :bl_h_bill_prv_bill_amt,
		    :bl_h_bill_prv_bill_paid_amt,
		    :bl_h_bill_prv_outst_amt,
		    :bl_h_bill_hosp_prv_outst_amt,
		    :bl_h_bill_drfee_prv_os_amt,
		    :bl_h_bill_tot_amt,
		    :bl_h_bill_hosp_tot_amt,
		    :bl_h_bill_drfee_tot_amt,
		    :bl_h_bill_tot_outst_amt,
		    :bl_h_bill_hosp_tot_outst_amt,
		    :bl_h_bill_drfee_tot_os_amt,
		    :bl_h_bill_paid_amt,
		    :bl_h_episode_type,
		    :bl_h_patient_id,
		    :bl_h_episode_id,
		    :bl_h_visit_id,
		    :bl_h_admission_date,
		    :bl_h_ward_code,
		    :bl_h_bed_class_code,
		    :bl_h_room_num,
		    :bl_h_bed_num,
		    :bl_h_physician_id,
		    :bl_h_clinic_code,
		    :bl_h_cust_code,
		    :bl_h_blng_grp_id,
		    :bl_h_bill_type_code,
		    :bl_h_cons_invoice_ind,
		    :bl_h_bill_status,
		    :bl_h_bill_print_flag,
		    :bl_h_drfee_bill_upd_flag,
		    :bl_h_drfee_rec_upd_flag,
		    :bl_h_drfee_receipt_amt,
		    :bl_h_ar_inv_doc_type_code,
		    :bl_h_ar_inv_doc_number,
		    :bl_h_ar_inv_doc_date,
		    :bl_h_last_recpt_doc_ty_cd,
		    :bl_h_last_recpt_doc_num,
		    :bl_h_last_recpt_doc_date,
		    :bl_h_bill_nature_code,
		    :bl_h_tot_paid_amt,
		    :bl_h_bill_posted_flag,
		    :bl_h_added_by_id,
		    :bl_h_modified_by_id,
		    :bl_h_added_date,
		    :bl_h_modified_date,
		    :bl_h_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )439;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[0] = (unsigned int  )15;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_h_bill_trx_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )4;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_h_serv_locn_code;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_h_bill_from_date;
     sqlstm.sqhstl[3] = (unsigned int  )15;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_h_bill_to_date;
     sqlstm.sqhstl[4] = (unsigned int  )15;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_h_gross_amt;
     sqlstm.sqhstl[5] = (unsigned int  )25;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_h_serv_disc_amt;
     sqlstm.sqhstl[6] = (unsigned int  )25;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_h_man_disc_amt;
     sqlstm.sqhstl[7] = (unsigned int  )25;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_h_overall_disc_perc;
     sqlstm.sqhstl[8] = (unsigned int  )8;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_h_overall_disc_amt;
     sqlstm.sqhstl[9] = (unsigned int  )25;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_h_ovr_disc_acc_int_code;
     sqlstm.sqhstl[10] = (unsigned int  )9;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_h_prepay_adj_amt;
     sqlstm.sqhstl[11] = (unsigned int  )25;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_h_deposit_adj_amt;
     sqlstm.sqhstl[12] = (unsigned int  )25;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_h_bill_amt;
     sqlstm.sqhstl[13] = (unsigned int  )25;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_h_bill_hosp_amt;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_h_bill_drfee_amt;
     sqlstm.sqhstl[15] = (unsigned int  )25;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_h_bill_prv_doc_type_code;
     sqlstm.sqhstl[16] = (unsigned int  )9;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_h_bill_prv_doc_number;
     sqlstm.sqhstl[17] = (unsigned int  )25;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_h_bill_prv_doc_date;
     sqlstm.sqhstl[18] = (unsigned int  )15;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_h_bill_prv_bill_amt;
     sqlstm.sqhstl[19] = (unsigned int  )25;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_h_bill_prv_bill_paid_amt;
     sqlstm.sqhstl[20] = (unsigned int  )25;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_h_bill_prv_outst_amt;
     sqlstm.sqhstl[21] = (unsigned int  )25;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_h_bill_hosp_prv_outst_amt;
     sqlstm.sqhstl[22] = (unsigned int  )25;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_h_bill_drfee_prv_os_amt;
     sqlstm.sqhstl[23] = (unsigned int  )25;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_h_bill_tot_amt;
     sqlstm.sqhstl[24] = (unsigned int  )25;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&bl_h_bill_hosp_tot_amt;
     sqlstm.sqhstl[25] = (unsigned int  )25;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&bl_h_bill_drfee_tot_amt;
     sqlstm.sqhstl[26] = (unsigned int  )25;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&bl_h_bill_tot_outst_amt;
     sqlstm.sqhstl[27] = (unsigned int  )25;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&bl_h_bill_hosp_tot_outst_amt;
     sqlstm.sqhstl[28] = (unsigned int  )25;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&bl_h_bill_drfee_tot_os_amt;
     sqlstm.sqhstl[29] = (unsigned int  )25;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&bl_h_bill_paid_amt;
     sqlstm.sqhstl[30] = (unsigned int  )25;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&bl_h_episode_type;
     sqlstm.sqhstl[31] = (unsigned int  )4;
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&bl_h_patient_id;
     sqlstm.sqhstl[32] = (unsigned int  )23;
     sqlstm.sqhsts[32] = (         int  )0;
     sqlstm.sqindv[32] = (         void  *)0;
     sqlstm.sqinds[32] = (         int  )0;
     sqlstm.sqharm[32] = (unsigned int  )0;
     sqlstm.sqadto[32] = (unsigned short )0;
     sqlstm.sqtdso[32] = (unsigned short )0;
     sqlstm.sqhstv[33] = (         void  *)&bl_h_episode_id;
     sqlstm.sqhstl[33] = (unsigned int  )11;
     sqlstm.sqhsts[33] = (         int  )0;
     sqlstm.sqindv[33] = (         void  *)0;
     sqlstm.sqinds[33] = (         int  )0;
     sqlstm.sqharm[33] = (unsigned int  )0;
     sqlstm.sqadto[33] = (unsigned short )0;
     sqlstm.sqtdso[33] = (unsigned short )0;
     sqlstm.sqhstv[34] = (         void  *)&bl_h_visit_id;
     sqlstm.sqhstl[34] = (unsigned int  )7;
     sqlstm.sqhsts[34] = (         int  )0;
     sqlstm.sqindv[34] = (         void  *)0;
     sqlstm.sqinds[34] = (         int  )0;
     sqlstm.sqharm[34] = (unsigned int  )0;
     sqlstm.sqadto[34] = (unsigned short )0;
     sqlstm.sqtdso[34] = (unsigned short )0;
     sqlstm.sqhstv[35] = (         void  *)&bl_h_admission_date;
     sqlstm.sqhstl[35] = (unsigned int  )15;
     sqlstm.sqhsts[35] = (         int  )0;
     sqlstm.sqindv[35] = (         void  *)0;
     sqlstm.sqinds[35] = (         int  )0;
     sqlstm.sqharm[35] = (unsigned int  )0;
     sqlstm.sqadto[35] = (unsigned short )0;
     sqlstm.sqtdso[35] = (unsigned short )0;
     sqlstm.sqhstv[36] = (         void  *)&bl_h_ward_code;
     sqlstm.sqhstl[36] = (unsigned int  )7;
     sqlstm.sqhsts[36] = (         int  )0;
     sqlstm.sqindv[36] = (         void  *)0;
     sqlstm.sqinds[36] = (         int  )0;
     sqlstm.sqharm[36] = (unsigned int  )0;
     sqlstm.sqadto[36] = (unsigned short )0;
     sqlstm.sqtdso[36] = (unsigned short )0;
     sqlstm.sqhstv[37] = (         void  *)&bl_h_bed_class_code;
     sqlstm.sqhstl[37] = (unsigned int  )5;
     sqlstm.sqhsts[37] = (         int  )0;
     sqlstm.sqindv[37] = (         void  *)0;
     sqlstm.sqinds[37] = (         int  )0;
     sqlstm.sqharm[37] = (unsigned int  )0;
     sqlstm.sqadto[37] = (unsigned short )0;
     sqlstm.sqtdso[37] = (unsigned short )0;
     sqlstm.sqhstv[38] = (         void  *)&bl_h_room_num;
     sqlstm.sqhstl[38] = (unsigned int  )7;
     sqlstm.sqhsts[38] = (         int  )0;
     sqlstm.sqindv[38] = (         void  *)0;
     sqlstm.sqinds[38] = (         int  )0;
     sqlstm.sqharm[38] = (unsigned int  )0;
     sqlstm.sqadto[38] = (unsigned short )0;
     sqlstm.sqtdso[38] = (unsigned short )0;
     sqlstm.sqhstv[39] = (         void  *)&bl_h_bed_num;
     sqlstm.sqhstl[39] = (unsigned int  )11;
     sqlstm.sqhsts[39] = (         int  )0;
     sqlstm.sqindv[39] = (         void  *)0;
     sqlstm.sqinds[39] = (         int  )0;
     sqlstm.sqharm[39] = (unsigned int  )0;
     sqlstm.sqadto[39] = (unsigned short )0;
     sqlstm.sqtdso[39] = (unsigned short )0;
     sqlstm.sqhstv[40] = (         void  *)&bl_h_physician_id;
     sqlstm.sqhstl[40] = (unsigned int  )18;
     sqlstm.sqhsts[40] = (         int  )0;
     sqlstm.sqindv[40] = (         void  *)0;
     sqlstm.sqinds[40] = (         int  )0;
     sqlstm.sqharm[40] = (unsigned int  )0;
     sqlstm.sqadto[40] = (unsigned short )0;
     sqlstm.sqtdso[40] = (unsigned short )0;
     sqlstm.sqhstv[41] = (         void  *)&bl_h_clinic_code;
     sqlstm.sqhstl[41] = (unsigned int  )7;
     sqlstm.sqhsts[41] = (         int  )0;
     sqlstm.sqindv[41] = (         void  *)0;
     sqlstm.sqinds[41] = (         int  )0;
     sqlstm.sqharm[41] = (unsigned int  )0;
     sqlstm.sqadto[41] = (unsigned short )0;
     sqlstm.sqtdso[41] = (unsigned short )0;
     sqlstm.sqhstv[42] = (         void  *)&bl_h_cust_code;
     sqlstm.sqhstl[42] = (unsigned int  )11;
     sqlstm.sqhsts[42] = (         int  )0;
     sqlstm.sqindv[42] = (         void  *)0;
     sqlstm.sqinds[42] = (         int  )0;
     sqlstm.sqharm[42] = (unsigned int  )0;
     sqlstm.sqadto[42] = (unsigned short )0;
     sqlstm.sqtdso[42] = (unsigned short )0;
     sqlstm.sqhstv[43] = (         void  *)&bl_h_blng_grp_id;
     sqlstm.sqhstl[43] = (unsigned int  )5;
     sqlstm.sqhsts[43] = (         int  )0;
     sqlstm.sqindv[43] = (         void  *)0;
     sqlstm.sqinds[43] = (         int  )0;
     sqlstm.sqharm[43] = (unsigned int  )0;
     sqlstm.sqadto[43] = (unsigned short )0;
     sqlstm.sqtdso[43] = (unsigned short )0;
     sqlstm.sqhstv[44] = (         void  *)&bl_h_bill_type_code;
     sqlstm.sqhstl[44] = (unsigned int  )5;
     sqlstm.sqhsts[44] = (         int  )0;
     sqlstm.sqindv[44] = (         void  *)0;
     sqlstm.sqinds[44] = (         int  )0;
     sqlstm.sqharm[44] = (unsigned int  )0;
     sqlstm.sqadto[44] = (unsigned short )0;
     sqlstm.sqtdso[44] = (unsigned short )0;
     sqlstm.sqhstv[45] = (         void  *)&bl_h_cons_invoice_ind;
     sqlstm.sqhstl[45] = (unsigned int  )4;
     sqlstm.sqhsts[45] = (         int  )0;
     sqlstm.sqindv[45] = (         void  *)0;
     sqlstm.sqinds[45] = (         int  )0;
     sqlstm.sqharm[45] = (unsigned int  )0;
     sqlstm.sqadto[45] = (unsigned short )0;
     sqlstm.sqtdso[45] = (unsigned short )0;
     sqlstm.sqhstv[46] = (         void  *)&bl_h_bill_status;
     sqlstm.sqhstl[46] = (unsigned int  )4;
     sqlstm.sqhsts[46] = (         int  )0;
     sqlstm.sqindv[46] = (         void  *)0;
     sqlstm.sqinds[46] = (         int  )0;
     sqlstm.sqharm[46] = (unsigned int  )0;
     sqlstm.sqadto[46] = (unsigned short )0;
     sqlstm.sqtdso[46] = (unsigned short )0;
     sqlstm.sqhstv[47] = (         void  *)&bl_h_bill_print_flag;
     sqlstm.sqhstl[47] = (unsigned int  )4;
     sqlstm.sqhsts[47] = (         int  )0;
     sqlstm.sqindv[47] = (         void  *)0;
     sqlstm.sqinds[47] = (         int  )0;
     sqlstm.sqharm[47] = (unsigned int  )0;
     sqlstm.sqadto[47] = (unsigned short )0;
     sqlstm.sqtdso[47] = (unsigned short )0;
     sqlstm.sqhstv[48] = (         void  *)&bl_h_drfee_bill_upd_flag;
     sqlstm.sqhstl[48] = (unsigned int  )4;
     sqlstm.sqhsts[48] = (         int  )0;
     sqlstm.sqindv[48] = (         void  *)0;
     sqlstm.sqinds[48] = (         int  )0;
     sqlstm.sqharm[48] = (unsigned int  )0;
     sqlstm.sqadto[48] = (unsigned short )0;
     sqlstm.sqtdso[48] = (unsigned short )0;
     sqlstm.sqhstv[49] = (         void  *)&bl_h_drfee_rec_upd_flag;
     sqlstm.sqhstl[49] = (unsigned int  )4;
     sqlstm.sqhsts[49] = (         int  )0;
     sqlstm.sqindv[49] = (         void  *)0;
     sqlstm.sqinds[49] = (         int  )0;
     sqlstm.sqharm[49] = (unsigned int  )0;
     sqlstm.sqadto[49] = (unsigned short )0;
     sqlstm.sqtdso[49] = (unsigned short )0;
     sqlstm.sqhstv[50] = (         void  *)&bl_h_drfee_receipt_amt;
     sqlstm.sqhstl[50] = (unsigned int  )25;
     sqlstm.sqhsts[50] = (         int  )0;
     sqlstm.sqindv[50] = (         void  *)0;
     sqlstm.sqinds[50] = (         int  )0;
     sqlstm.sqharm[50] = (unsigned int  )0;
     sqlstm.sqadto[50] = (unsigned short )0;
     sqlstm.sqtdso[50] = (unsigned short )0;
     sqlstm.sqhstv[51] = (         void  *)&bl_h_ar_inv_doc_type_code;
     sqlstm.sqhstl[51] = (unsigned int  )9;
     sqlstm.sqhsts[51] = (         int  )0;
     sqlstm.sqindv[51] = (         void  *)0;
     sqlstm.sqinds[51] = (         int  )0;
     sqlstm.sqharm[51] = (unsigned int  )0;
     sqlstm.sqadto[51] = (unsigned short )0;
     sqlstm.sqtdso[51] = (unsigned short )0;
     sqlstm.sqhstv[52] = (         void  *)&bl_h_ar_inv_doc_number;
     sqlstm.sqhstl[52] = (unsigned int  )11;
     sqlstm.sqhsts[52] = (         int  )0;
     sqlstm.sqindv[52] = (         void  *)0;
     sqlstm.sqinds[52] = (         int  )0;
     sqlstm.sqharm[52] = (unsigned int  )0;
     sqlstm.sqadto[52] = (unsigned short )0;
     sqlstm.sqtdso[52] = (unsigned short )0;
     sqlstm.sqhstv[53] = (         void  *)&bl_h_ar_inv_doc_date;
     sqlstm.sqhstl[53] = (unsigned int  )15;
     sqlstm.sqhsts[53] = (         int  )0;
     sqlstm.sqindv[53] = (         void  *)0;
     sqlstm.sqinds[53] = (         int  )0;
     sqlstm.sqharm[53] = (unsigned int  )0;
     sqlstm.sqadto[53] = (unsigned short )0;
     sqlstm.sqtdso[53] = (unsigned short )0;
     sqlstm.sqhstv[54] = (         void  *)&bl_h_last_recpt_doc_ty_cd;
     sqlstm.sqhstl[54] = (unsigned int  )9;
     sqlstm.sqhsts[54] = (         int  )0;
     sqlstm.sqindv[54] = (         void  *)0;
     sqlstm.sqinds[54] = (         int  )0;
     sqlstm.sqharm[54] = (unsigned int  )0;
     sqlstm.sqadto[54] = (unsigned short )0;
     sqlstm.sqtdso[54] = (unsigned short )0;
     sqlstm.sqhstv[55] = (         void  *)&bl_h_last_recpt_doc_num;
     sqlstm.sqhstl[55] = (unsigned int  )25;
     sqlstm.sqhsts[55] = (         int  )0;
     sqlstm.sqindv[55] = (         void  *)0;
     sqlstm.sqinds[55] = (         int  )0;
     sqlstm.sqharm[55] = (unsigned int  )0;
     sqlstm.sqadto[55] = (unsigned short )0;
     sqlstm.sqtdso[55] = (unsigned short )0;
     sqlstm.sqhstv[56] = (         void  *)&bl_h_last_recpt_doc_date;
     sqlstm.sqhstl[56] = (unsigned int  )15;
     sqlstm.sqhsts[56] = (         int  )0;
     sqlstm.sqindv[56] = (         void  *)0;
     sqlstm.sqinds[56] = (         int  )0;
     sqlstm.sqharm[56] = (unsigned int  )0;
     sqlstm.sqadto[56] = (unsigned short )0;
     sqlstm.sqtdso[56] = (unsigned short )0;
     sqlstm.sqhstv[57] = (         void  *)&bl_h_bill_nature_code;
     sqlstm.sqhstl[57] = (unsigned int  )4;
     sqlstm.sqhsts[57] = (         int  )0;
     sqlstm.sqindv[57] = (         void  *)0;
     sqlstm.sqinds[57] = (         int  )0;
     sqlstm.sqharm[57] = (unsigned int  )0;
     sqlstm.sqadto[57] = (unsigned short )0;
     sqlstm.sqtdso[57] = (unsigned short )0;
     sqlstm.sqhstv[58] = (         void  *)&bl_h_tot_paid_amt;
     sqlstm.sqhstl[58] = (unsigned int  )25;
     sqlstm.sqhsts[58] = (         int  )0;
     sqlstm.sqindv[58] = (         void  *)0;
     sqlstm.sqinds[58] = (         int  )0;
     sqlstm.sqharm[58] = (unsigned int  )0;
     sqlstm.sqadto[58] = (unsigned short )0;
     sqlstm.sqtdso[58] = (unsigned short )0;
     sqlstm.sqhstv[59] = (         void  *)&bl_h_bill_posted_flag;
     sqlstm.sqhstl[59] = (unsigned int  )4;
     sqlstm.sqhsts[59] = (         int  )0;
     sqlstm.sqindv[59] = (         void  *)0;
     sqlstm.sqinds[59] = (         int  )0;
     sqlstm.sqharm[59] = (unsigned int  )0;
     sqlstm.sqadto[59] = (unsigned short )0;
     sqlstm.sqtdso[59] = (unsigned short )0;
     sqlstm.sqhstv[60] = (         void  *)&bl_h_added_by_id;
     sqlstm.sqhstl[60] = (unsigned int  )23;
     sqlstm.sqhsts[60] = (         int  )0;
     sqlstm.sqindv[60] = (         void  *)0;
     sqlstm.sqinds[60] = (         int  )0;
     sqlstm.sqharm[60] = (unsigned int  )0;
     sqlstm.sqadto[60] = (unsigned short )0;
     sqlstm.sqtdso[60] = (unsigned short )0;
     sqlstm.sqhstv[61] = (         void  *)&bl_h_modified_by_id;
     sqlstm.sqhstl[61] = (unsigned int  )23;
     sqlstm.sqhsts[61] = (         int  )0;
     sqlstm.sqindv[61] = (         void  *)0;
     sqlstm.sqinds[61] = (         int  )0;
     sqlstm.sqharm[61] = (unsigned int  )0;
     sqlstm.sqadto[61] = (unsigned short )0;
     sqlstm.sqtdso[61] = (unsigned short )0;
     sqlstm.sqhstv[62] = (         void  *)&bl_h_added_date;
     sqlstm.sqhstl[62] = (unsigned int  )15;
     sqlstm.sqhsts[62] = (         int  )0;
     sqlstm.sqindv[62] = (         void  *)0;
     sqlstm.sqinds[62] = (         int  )0;
     sqlstm.sqharm[62] = (unsigned int  )0;
     sqlstm.sqadto[62] = (unsigned short )0;
     sqlstm.sqtdso[62] = (unsigned short )0;
     sqlstm.sqhstv[63] = (         void  *)&bl_h_modified_date;
     sqlstm.sqhstl[63] = (unsigned int  )15;
     sqlstm.sqhsts[63] = (         int  )0;
     sqlstm.sqindv[63] = (         void  *)0;
     sqlstm.sqinds[63] = (         int  )0;
     sqlstm.sqharm[63] = (unsigned int  )0;
     sqlstm.sqadto[63] = (unsigned short )0;
     sqlstm.sqtdso[63] = (unsigned short )0;
     sqlstm.sqhstv[64] = (         void  *)&bl_h_rowid;
     sqlstm.sqhstl[64] = (unsigned int  )33;
     sqlstm.sqhsts[64] = (         int  )0;
     sqlstm.sqindv[64] = (         void  *)0;
     sqlstm.sqinds[64] = (         int  )0;
     sqlstm.sqharm[64] = (unsigned int  )0;
     sqlstm.sqadto[64] = (unsigned short )0;
     sqlstm.sqtdso[64] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
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
	 err_mesg("FETCH failed on cursor BL_HDR_CUR",0,"");

bl_h_doc_date.arr[bl_h_doc_date.len]                                     = '\0';
bl_h_bill_trx_type_code.arr[bl_h_bill_trx_type_code.len]                 = '\0';
bl_h_serv_locn_code.arr[bl_h_serv_locn_code.len]                         = '\0';
bl_h_bill_from_date.arr[bl_h_bill_from_date.len]                         = '\0';
bl_h_bill_to_date.arr[bl_h_bill_to_date.len]                             = '\0';
bl_h_gross_amt.arr[bl_h_gross_amt.len]                                   = '\0';
bl_h_serv_disc_amt.arr[bl_h_serv_disc_amt.len]                           = '\0';
bl_h_man_disc_amt.arr[bl_h_man_disc_amt.len]                             = '\0';
bl_h_overall_disc_perc.arr[bl_h_overall_disc_perc.len]                   = '\0';
bl_h_overall_disc_amt.arr[bl_h_overall_disc_amt.len]                     = '\0';
bl_h_ovr_disc_acc_int_code.arr[bl_h_ovr_disc_acc_int_code.len]           = '\0';
bl_h_prepay_adj_amt.arr[bl_h_prepay_adj_amt.len]                         = '\0';
bl_h_deposit_adj_amt.arr[bl_h_deposit_adj_amt.len]                       = '\0';
bl_h_bill_amt.arr[bl_h_bill_amt.len]                                     = '\0';
bl_h_bill_hosp_amt.arr[bl_h_bill_hosp_amt.len]                           = '\0';
bl_h_bill_drfee_amt.arr[bl_h_bill_drfee_amt.len]                         = '\0';
bl_h_bill_prv_doc_type_code.arr[bl_h_bill_prv_doc_type_code.len]         = '\0';
bl_h_bill_prv_doc_number.arr[bl_h_bill_prv_doc_number.len]               = '\0';
bl_h_bill_prv_doc_date.arr[bl_h_bill_prv_doc_date.len]                   = '\0';
bl_h_bill_prv_bill_amt.arr[bl_h_bill_prv_bill_amt.len]                   = '\0';
bl_h_bill_prv_bill_paid_amt.arr[bl_h_bill_prv_bill_paid_amt.len]         = '\0';
bl_h_bill_prv_outst_amt.arr[bl_h_bill_prv_outst_amt.len]                 = '\0';
bl_h_bill_hosp_prv_outst_amt.arr[bl_h_bill_hosp_prv_outst_amt.len]       = '\0';
bl_h_bill_drfee_prv_os_amt.arr[bl_h_bill_drfee_prv_os_amt.len]     = '\0';
bl_h_bill_tot_amt.arr[bl_h_bill_tot_amt.len]                             = '\0';
bl_h_bill_hosp_tot_amt.arr[bl_h_bill_hosp_tot_amt.len]                   = '\0';
bl_h_bill_drfee_tot_amt.arr[bl_h_bill_drfee_tot_amt.len]                 = '\0';
bl_h_bill_tot_outst_amt.arr[bl_h_bill_tot_outst_amt.len]                 = '\0';
bl_h_bill_hosp_tot_outst_amt.arr[bl_h_bill_hosp_tot_outst_amt.len]       = '\0';
bl_h_bill_drfee_tot_os_amt.arr[bl_h_bill_drfee_tot_os_amt.len]     = '\0';
bl_h_bill_paid_amt.arr[bl_h_bill_paid_amt.len]                           = '\0';
bl_h_episode_type.arr[bl_h_episode_type.len]                             = '\0';
bl_h_patient_id.arr[bl_h_patient_id.len]                                 = '\0';
bl_h_episode_id.arr[bl_h_episode_id.len]                                 = '\0';
bl_h_visit_id.arr[bl_h_visit_id.len]                                     = '\0';
bl_h_admission_date.arr[bl_h_admission_date.len]                         = '\0';
bl_h_ward_code.arr[bl_h_ward_code.len]                                   = '\0';
bl_h_bed_class_code.arr[bl_h_bed_class_code.len]                         = '\0';
bl_h_room_num.arr[bl_h_room_num.len]                                     = '\0';
bl_h_bed_num.arr[bl_h_bed_num.len]                                       = '\0';
bl_h_physician_id.arr[bl_h_physician_id.len]                             = '\0';
bl_h_clinic_code.arr[bl_h_clinic_code.len]                               = '\0';
bl_h_cust_code.arr[bl_h_cust_code.len]                                   = '\0';
bl_h_blng_grp_id.arr[bl_h_blng_grp_id.len]                               = '\0';
bl_h_bill_type_code.arr[bl_h_bill_type_code.len]                         = '\0';
bl_h_cons_invoice_ind.arr[bl_h_cons_invoice_ind.len]                     = '\0';
bl_h_bill_status.arr[bl_h_bill_status.len]                               = '\0';
bl_h_bill_print_flag.arr[bl_h_bill_print_flag.len]                       = '\0';
bl_h_drfee_bill_upd_flag.arr[bl_h_drfee_bill_upd_flag.len]               = '\0';
bl_h_drfee_rec_upd_flag.arr[bl_h_drfee_rec_upd_flag.len]                 = '\0';
bl_h_drfee_receipt_amt.arr[bl_h_drfee_receipt_amt.len]                   = '\0';
bl_h_ar_inv_doc_type_code.arr[bl_h_ar_inv_doc_type_code.len]             = '\0';
bl_h_ar_inv_doc_number.arr[bl_h_ar_inv_doc_number.len]                   = '\0';
bl_h_ar_inv_doc_date.arr[bl_h_ar_inv_doc_date.len]                       = '\0';
bl_h_last_recpt_doc_ty_cd.arr[bl_h_last_recpt_doc_ty_cd.len]     = '\0';
bl_h_last_recpt_doc_num.arr[bl_h_last_recpt_doc_num.len]                 = '\0';
bl_h_last_recpt_doc_date.arr[bl_h_last_recpt_doc_date.len]               = '\0';
bl_h_bill_nature_code.arr[bl_h_bill_nature_code.len]                     = '\0';
bl_h_tot_paid_amt.arr[bl_h_tot_paid_amt.len]                             = '\0';
bl_h_bill_posted_flag.arr[bl_h_bill_posted_flag.len]                     = '\0';
bl_h_added_by_id.arr[bl_h_added_by_id.len]                               = '\0';
bl_h_modified_by_id.arr[bl_h_modified_by_id.len]                         = '\0';
bl_h_added_date.arr[bl_h_added_date.len]                                 = '\0';
bl_h_modified_date.arr[bl_h_modified_date.len]                           = '\0';
bl_h_rowid.arr[bl_h_rowid.len]                                           = '\0';
/*
    if(first) {
	strcpy(bl_h_prev_cust_code.arr, bl_h_cust_code.arr);
	bl_h_prev_cust_code.len = strlen(bl_h_prev_cust_code.arr);
	first = 0;
    } */

   return(ROW_COUNT);
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
		AND  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
		     			  WHERE ACC_ENTITY_ID = :nd_facility_id)
		FOR UPDATE OF NEXT_DOC_NO; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(NEXT_DOC_NO,0) ,ROWID into :b0,:b1  from SY_A\
CC_ENTITY_DOC_TYPE where (DOC_TYPE_CODE=:b2 and ACC_ENTITY_CODE in (select ACC\
_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3)) for update of NEXT_\
DOC_NO ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )714;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
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
	 err_mesg("SELECT failed on table SY_ACC_ENTITY_DOC_TYPE",0,"");

     if (NOT_FOUND)
	 err_mesg("Record not found in SY ACC ENTITY DOC TYPE",0,"");

     d_sy_acc_rowid.arr[d_sy_acc_rowid.len] = '\0';    

     /* EXEC SQL UPDATE SY_ACC_ENTITY_DOC_TYPE 
	      SET NEXT_DOC_NO = NVL(NEXT_DOC_NO,0) + 1,
		MODIFIED_BY_ID  = USER,
		MODIFIED_DATE   = SYSDATE
	        WHERE ROWID = :d_sy_acc_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update SY_ACC_ENTITY_DOC_TYPE  set NEXT_DOC_NO=(NVL(NEXT\
_DOC_NO,0)+1),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE where ROWID=:b0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )745;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
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

fetch_pat_dtls()
{


     /* EXEC SQL OPEN BL_BILL_TYPE_PAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )764;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_bill_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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
	 err_mesg("OPEN failed on cursor BL_BILL_TYPE_PAT_CUR",0,"");

    bl_bill_type_short_desc.arr[0]         = '\0';

    bl_bill_type_short_desc.len            = 0;

     /* EXEC SQL FETCH BL_BILL_TYPE_PAT_CUR
	       INTO :bl_bill_type_short_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )787;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_bill_type_short_desc;
     sqlstm.sqhstl[0] = (unsigned int  )18;
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
	 err_mesg("FETCH failed on cursor BL_BILL_TYPE_PAT_CUR",0,"");
     if (NOT_FOUND)
	 err_mesg("Record not found in BL BILL TYPE",0,"");

     bl_bill_type_short_desc.arr[bl_bill_type_short_desc.len] = '\0';

}

fetch_dtls()
{    
     
     /* EXEC SQL OPEN BL_BILL_TYPE_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0011;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )806;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_bill_type;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )829;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
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

     strcpy(recv_int_code.arr,bl_recv_acc_int_code.arr);
     recv_int_code.len = strlen(recv_int_code.arr);

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0012;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )852;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&recv_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )875;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
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
     sqlstm.sqhstl[2] = (unsigned int  )9;
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

     strcpy(recv_int_code.arr,ar_recv_acc_int_code.arr);
     recv_int_code.len = strlen(recv_int_code.arr);

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0012;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )918;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&recv_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
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
     p_gl_acc1_code.len			              = 0;
     p_gl_acc2_code.len                       = 0;

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
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )941;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
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
     sqlstm.sqhstl[2] = (unsigned int  )9;
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

     /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )984;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_prev_cust_code;
     sqlstm.sqhstl[0] = (unsigned int  )11;
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
	 err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");

     bl_cust_pmnt_terms_code.arr[0]             = '\0';
     p_gl_acc1_code.arr[0]			            = '\0';
     p_gl_acc2_code.arr[0]			            = '\0';

     bl_cust_pmnt_terms_code.len                = 0;

     /* EXEC SQL FETCH AR_CUSTOMER_CUR
	       INTO :bl_cust_pmnt_terms_code, 
                    :p_gl_acc1_code,
		    :p_gl_acc2_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1007;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_cust_pmnt_terms_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&p_gl_acc1_code;
     sqlstm.sqhstl[1] = (unsigned int  )33;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&p_gl_acc2_code;
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
	 err_mesg("FETCH failed on cursor AR_CUSTOMER",0,"");

     if (NOT_FOUND)
	 err_mesg("Record not found in AR CUSTOMER",0,"");     
     
     bl_cust_pmnt_terms_code.arr[bl_cust_pmnt_terms_code.len] = '\0';
     bl_cust_pmnt_terms_code.arr[bl_cust_pmnt_terms_code.len] = '\0';
     p_gl_acc1_code.arr[p_gl_acc1_code.len] 				  = '\0';
     p_gl_acc2_code.arr[p_gl_acc2_code.len] 				  = '\0';     
     
	 if (nd_dr_cnt_acc.arr[0] == 'N')
	 {                                                                       
	 	strcpy(ar_rec_main_acc1_code.arr,p_gl_acc1_code.arr);
	 	strcpy(ar_rec_main_acc2_code.arr,p_gl_acc2_code.arr);
	 }	
	 	
	 	     
     

     /* EXEC SQL OPEN AR_PMNT_TERMS_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0014;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1034;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_cust_pmnt_terms_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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
	 err_mesg("OPEN failed on cursor AR_PMNT_TERMS_CUR",0,"");

     ar_pmnt_cred_days_period.arr[0]           = '\0';
     ar_pmnt_settl_days_period.arr[0]          = '\0';
     ar_pmnt_settl_percent.arr[0]              = '\0';

     ar_pmnt_cred_days_period.len              = 0;
     ar_pmnt_settl_days_period.len             = 0;
     ar_pmnt_settl_percent.len                 = 0;

     /* EXEC SQL FETCH AR_PMNT_TERMS_CUR
	       INTO :ar_pmnt_cred_days_period,
		    :ar_pmnt_settl_days_period,
		    :ar_pmnt_settl_percent; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1057;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
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
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
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

insert_ar_patient()
{

     pat_dtls();

     /* EXEC SQL INSERT INTO AR_PATIENT_DTLS
	       (
		 DOC_TYPE_CODE,
		 DOC_NUM,
		 PATIENT_ID,
		 PATIENT_NAME,
		 BILL_DOC_TYPE_CODE,
		 BILL_NUM,
		 BILL_DATE,
	         BILL_TYPE_CODE,         
		 BILLING_GROUP,          
		 REMARKS,
		 AMOUNT,
		 PEND_AMOUNT
	       )
	     VALUES
	       (
		 :nd_new_doc_type_code,            /o DOC_TYPE_CODE      o/
		 :nd_inv_start_doc_num,            /o DOC_NUM       o/
		 :bl_h_patient_id,                 /o PATIENT_ID         o/
		 SUBSTR(:nd_pat_name,1,30),
		 :bl_h_doc_type_code,              /o BILL DOC TYPE CODE o/
		 :bl_h_doc_num,                    /o BILL NUM           o/
		 TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),                   /o BILL_DATE          o/
		 :bl_h_bill_type_code,	
		 :bl_h_blng_grp_id,
		 :bl_bill_type_short_desc,         /o REMARKS            o/
		 NVL(:bl_h_bill_tot_outst_amt,0),   /o AMOUNT             o/
		 NVL(:bl_h_bill_tot_outst_amt,0)
	       ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "insert into AR_PATIENT_DTLS (DOC_TYPE_CODE,DOC_NUM,PATIE\
NT_ID,PATIENT_NAME,BILL_DOC_TYPE_CODE,BILL_NUM,BILL_DATE,BILL_TYPE_CODE,BILLIN\
G_GROUP,REMARKS,AMOUNT,PEND_AMOUNT) values (:b0,:b1,:b2,SUBSTR(:b3,1,30),:b4,:\
b5,TO_DATE(:b6,'DD/MM/YYYY'),:b7,:b8,:b9,NVL(:b10,0),NVL(:b10,0))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1084;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
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
     sqlstm.sqhstv[2] = (         void  *)&bl_h_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_pat_name;
     sqlstm.sqhstl[3] = (unsigned int  )102;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_h_doc_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_h_doc_num;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[6] = (unsigned int  )15;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_h_bill_type_code;
     sqlstm.sqhstl[7] = (unsigned int  )5;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_h_blng_grp_id;
     sqlstm.sqhstl[8] = (unsigned int  )5;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_bill_type_short_desc;
     sqlstm.sqhstl[9] = (unsigned int  )18;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_h_bill_tot_outst_amt;
     sqlstm.sqhstl[10] = (unsigned int  )25;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_h_bill_tot_outst_amt;
     sqlstm.sqhstl[11] = (unsigned int  )25;
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
	 err_mesg("INSERT failed on table AR_PATIENT_DTLS",0,"");
}

pat_dtls()
{
nd_pat_name.arr[0] = '\0';
nd_pat_name.len = 0;

/* EXEC SQL SELECT short_name INTO :nd_pat_name FROM MP_PATIENT_MAST
WHERE patient_id = :bl_h_patient_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 65;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select short_name into :b0  from MP_PATIENT_MAST where patien\
t_id=:b1";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1147;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_pat_name;
sqlstm.sqhstl[0] = (unsigned int  )102;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&bl_h_patient_id;
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



bl_h_patient_id.arr[bl_h_patient_id.len] = '\0';

if (OERROR)
 err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

}


insert_ar_rec()
{

/*-- The narration modified by prefixing customer code along with the 
     current narration as per AH requirement VSK 01/05/1999 
	 current narration as of now is NULL in this. */

nd_narration.arr[0] = '\0';
nd_narration.len = 0;
sprintf(nd_narration.arr,"%-10s",bl_h_prev_cust_code.arr);
nd_narration.len = strlen(nd_narration.arr);
nd_narration.arr[nd_narration.len] = '\0';



     /* EXEC SQL INSERT INTO AR_INV_HDR
	       (
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
		 PATIENT_ID,
		 BILLING_GROUP,
		 BILL_DOC_TYPE_CODE,
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
		 BILL_TYPE_CODE,
		 ADDED_BY_ID,                    
		 MODIFIED_BY_ID,                 
		 ADDED_DATE,                     
		 MODIFIED_DATE,                  
		 OPERATING_FACILITY_ID,
		 ACC_ENTITY_CODE,
		 MODULE_ID,              
		 CONSOLIDATED_INV_YN              
	       )
	      VALUES
	       (
		 :nd_new_doc_type_code,             /o DOC_TYPE_CODE o/
		 :nd_inv_start_doc_num,             /o DOC_NUM       o/
		 1,                                 /o LAST LINE NUM o/
		 :bl_h_prev_cust_code,              /o CUST CODE     o/
		 TO_DATE(:nd_inv_date,'DD/MM/YYYY'),                      /o DOC DATE      o/
		 :nd_narration,                              /o NARRATION     o/
		 TO_DATE(:nd_inv_date,'DD/MM/YYYY'),                      /o DOC DATE      o/
		 to_date(:nd_inv_date,'DD/MM/YYYY') + :ar_pmnt_cred_days_period, /oDUE DATEo/
		 :nd_sum_outst_amt,                 /o GROSS AMT     o/
		 :nd_sum_outst_amt,                 /o PAYABLE AMT   o/
		 0,                                 /o DISCOUNT AMT  o/
		 :bl_cust_pmnt_terms_code,          /o PMNT TERMS    o/
		 to_date(:nd_inv_date,'DD/MM/YYYY') + :ar_pmnt_settl_days_period,/oSTLMT DTo/
		 :ar_pmnt_settl_percent,           /o SETTLEMENT PERCo/
		 :nd_credit_ref,                   /o CUST REF       o/
		 :nd_st_patient_id,                /o PATIENT ID     o/
		 :bl_h_blng_grp_id,	/o:nd_billing_grp,        BILLING GROUP  o/
		 :nd_st_doc_type_code,             /o BILL DOC TYPE CODE o/
		 :nd_st_doc_num,                   /o BILL NUM       o/
		 TO_DATE(:nd_inv_date,'DD/MM/YYYY'),                     /o BILL DATE      o/
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
		 :nd_bill_type,                     /o BILL TYPE CODE o/
		 USER,                    
		 USER,                 
		 SYSDATE,                     
		 SYSDATE,                  
		 :nd_operating_facility_id,
		 :nd_acc_entity_code,
		 :nd_module_id,
		 :nd_inv_status
	       ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "insert into AR_INV_HDR (DOC_TYPE_CODE,DOC_NUM,LAST_LINE_NUM,CUST_COD\
E,DOC_DATE,NARRATION,BASE_DATE,DUE_DATE,GROSS_AMT,PAYABLE_AMT,DISCOUNT_AMT,P\
MNT_TERMS_CODE,SETTLEMENT_DATE,SETTLEMENT_PERC,CUST_REF,PATIENT_ID,BILLING_G\
ROUP,BILL_DOC_TYPE_CODE,BILL_NUM,BILL_DATE,DOCTOR_FEE_AMT,MAIN_ACC1_CODE,MAI\
N_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP\
_CODE,PRODUCT_LINE_CODE,POST_MONTH,POST_YEAR,ERROR_FLAG,PRINT_FLAG,POSTED_FL\
AG,INTERFACE_FLAG,MAIN_ACC1_CODE_NEW,MAIN_ACC2_CODE_NEW,SUBLEDGER_GROUP_CODE\
_NEW,SUBLEDGER_LINE_CODE_NEW,DEPT_CODE_NEW,PRODUCT_GROUP_CODE_NEW,PRODUCT_LI\
NE_CODE_NEW,BILL_TYPE_CODE,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DA\
TE,OPERATING_FACILITY_ID,ACC_ENTITY_CODE,MODULE_ID,CONSOLIDATED_INV_YN) valu\
es (:b0,:b1,1,:b2,TO_DATE(:b3,'DD/MM/YYYY'),:b4,TO_DATE(:b3,'DD/MM/YYYY'),(t\
o_date(:b3,'DD/MM/YYYY')+:b7),:b8,:b8,0,:b10,(to_date(:b3,'DD/MM/YYYY')+:b12\
),:b13,:b14,:b15,:b16,:b17,:b18,TO_DATE(:b3,'DD/MM/YYYY'),:b20,:b21,:b22,:b2\
3,:b24,:b25,:b26,:b27,:b28,:b29,null ,'N',nu");
     sqlstm.stmt = "ll ,null ,:b21,:b22,:b23,:b24,:b25,:b26,:b27,:b37,USER,U\
SER,SYSDATE,SYSDATE,:b38,:b39,:b40,:b41)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1170;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
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
     sqlstm.sqhstv[2] = (         void  *)&bl_h_prev_cust_code;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_inv_date;
     sqlstm.sqhstl[3] = (unsigned int  )14;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_narration;
     sqlstm.sqhstl[4] = (unsigned int  )53;
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
     sqlstm.sqhstv[7] = (         void  *)&ar_pmnt_cred_days_period;
     sqlstm.sqhstl[7] = (unsigned int  )6;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_sum_outst_amt;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
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
     sqlstm.sqhstv[10] = (         void  *)&bl_cust_pmnt_terms_code;
     sqlstm.sqhstl[10] = (unsigned int  )5;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&nd_inv_date;
     sqlstm.sqhstl[11] = (unsigned int  )14;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&ar_pmnt_settl_days_period;
     sqlstm.sqhstl[12] = (unsigned int  )6;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&ar_pmnt_settl_percent;
     sqlstm.sqhstl[13] = (unsigned int  )11;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&nd_credit_ref;
     sqlstm.sqhstl[14] = (unsigned int  )18;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&nd_st_patient_id;
     sqlstm.sqhstl[15] = (unsigned int  )23;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_h_blng_grp_id;
     sqlstm.sqhstl[16] = (unsigned int  )5;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&nd_st_doc_type_code;
     sqlstm.sqhstl[17] = (unsigned int  )9;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&nd_st_doc_num;
     sqlstm.sqhstl[18] = (unsigned int  )11;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&nd_inv_date;
     sqlstm.sqhstl[19] = (unsigned int  )14;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&nd_sum_drfee_amt;
     sqlstm.sqhstl[20] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&ar_rec_main_acc1_code;
     sqlstm.sqhstl[21] = (unsigned int  )9;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&ar_rec_main_acc2_code;
     sqlstm.sqhstl[22] = (unsigned int  )7;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&ar_rec_subledger_group_code;
     sqlstm.sqhstl[23] = (unsigned int  )6;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&ar_rec_subledger_line_code;
     sqlstm.sqhstl[24] = (unsigned int  )11;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&ar_rec_dept_code;
     sqlstm.sqhstl[25] = (unsigned int  )9;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&ar_rec_product_group_code;
     sqlstm.sqhstl[26] = (unsigned int  )6;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&ar_rec_product_line_code;
     sqlstm.sqhstl[27] = (unsigned int  )7;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&bl_par_post_month;
     sqlstm.sqhstl[28] = (unsigned int  )5;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&bl_par_post_year;
     sqlstm.sqhstl[29] = (unsigned int  )7;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&ar_rec_main_acc1_code;
     sqlstm.sqhstl[30] = (unsigned int  )9;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&ar_rec_main_acc2_code;
     sqlstm.sqhstl[31] = (unsigned int  )7;
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&ar_rec_subledger_group_code;
     sqlstm.sqhstl[32] = (unsigned int  )6;
     sqlstm.sqhsts[32] = (         int  )0;
     sqlstm.sqindv[32] = (         void  *)0;
     sqlstm.sqinds[32] = (         int  )0;
     sqlstm.sqharm[32] = (unsigned int  )0;
     sqlstm.sqadto[32] = (unsigned short )0;
     sqlstm.sqtdso[32] = (unsigned short )0;
     sqlstm.sqhstv[33] = (         void  *)&ar_rec_subledger_line_code;
     sqlstm.sqhstl[33] = (unsigned int  )11;
     sqlstm.sqhsts[33] = (         int  )0;
     sqlstm.sqindv[33] = (         void  *)0;
     sqlstm.sqinds[33] = (         int  )0;
     sqlstm.sqharm[33] = (unsigned int  )0;
     sqlstm.sqadto[33] = (unsigned short )0;
     sqlstm.sqtdso[33] = (unsigned short )0;
     sqlstm.sqhstv[34] = (         void  *)&ar_rec_dept_code;
     sqlstm.sqhstl[34] = (unsigned int  )9;
     sqlstm.sqhsts[34] = (         int  )0;
     sqlstm.sqindv[34] = (         void  *)0;
     sqlstm.sqinds[34] = (         int  )0;
     sqlstm.sqharm[34] = (unsigned int  )0;
     sqlstm.sqadto[34] = (unsigned short )0;
     sqlstm.sqtdso[34] = (unsigned short )0;
     sqlstm.sqhstv[35] = (         void  *)&ar_rec_product_group_code;
     sqlstm.sqhstl[35] = (unsigned int  )6;
     sqlstm.sqhsts[35] = (         int  )0;
     sqlstm.sqindv[35] = (         void  *)0;
     sqlstm.sqinds[35] = (         int  )0;
     sqlstm.sqharm[35] = (unsigned int  )0;
     sqlstm.sqadto[35] = (unsigned short )0;
     sqlstm.sqtdso[35] = (unsigned short )0;
     sqlstm.sqhstv[36] = (         void  *)&ar_rec_product_line_code;
     sqlstm.sqhstl[36] = (unsigned int  )7;
     sqlstm.sqhsts[36] = (         int  )0;
     sqlstm.sqindv[36] = (         void  *)0;
     sqlstm.sqinds[36] = (         int  )0;
     sqlstm.sqharm[36] = (unsigned int  )0;
     sqlstm.sqadto[36] = (unsigned short )0;
     sqlstm.sqtdso[36] = (unsigned short )0;
     sqlstm.sqhstv[37] = (         void  *)&nd_bill_type;
     sqlstm.sqhstl[37] = (unsigned int  )5;
     sqlstm.sqhsts[37] = (         int  )0;
     sqlstm.sqindv[37] = (         void  *)0;
     sqlstm.sqinds[37] = (         int  )0;
     sqlstm.sqharm[37] = (unsigned int  )0;
     sqlstm.sqadto[37] = (unsigned short )0;
     sqlstm.sqtdso[37] = (unsigned short )0;
     sqlstm.sqhstv[38] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[38] = (unsigned int  )5;
     sqlstm.sqhsts[38] = (         int  )0;
     sqlstm.sqindv[38] = (         void  *)0;
     sqlstm.sqinds[38] = (         int  )0;
     sqlstm.sqharm[38] = (unsigned int  )0;
     sqlstm.sqadto[38] = (unsigned short )0;
     sqlstm.sqtdso[38] = (unsigned short )0;
     sqlstm.sqhstv[39] = (         void  *)&nd_acc_entity_code;
     sqlstm.sqhstl[39] = (unsigned int  )7;
     sqlstm.sqhsts[39] = (         int  )0;
     sqlstm.sqindv[39] = (         void  *)0;
     sqlstm.sqinds[39] = (         int  )0;
     sqlstm.sqharm[39] = (unsigned int  )0;
     sqlstm.sqadto[39] = (unsigned short )0;
     sqlstm.sqtdso[39] = (unsigned short )0;
     sqlstm.sqhstv[40] = (         void  *)&nd_module_id;
     sqlstm.sqhstl[40] = (unsigned int  )5;
     sqlstm.sqhsts[40] = (         int  )0;
     sqlstm.sqindv[40] = (         void  *)0;
     sqlstm.sqinds[40] = (         int  )0;
     sqlstm.sqharm[40] = (unsigned int  )0;
     sqlstm.sqadto[40] = (unsigned short )0;
     sqlstm.sqtdso[40] = (unsigned short )0;
     sqlstm.sqhstv[41] = (         void  *)&nd_inv_status;
     sqlstm.sqhstl[41] = (unsigned int  )4;
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



     if (OERROR)
	 err_mesg("INSERT failed on table AR_INV_HDR",0,"");

     /* EXEC SQL INSERT INTO AR_INV_LINE
	       (
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
		 PRODUCT_LINE_CODE_NEW,
		 ACC_ENTITY_CODE
	       )
	     VALUES
	       (
		 :nd_new_doc_type_code,             /o DOC_TYPE_CODE  o/
		 :nd_inv_start_doc_num,             /o DOC_NUM       o/
		 1,                                 /o LINE NUM       o/
		 :bl_rec_main_acc1_code,            /o -------------- o/
		 :bl_rec_main_acc2_code,            /o                o/
		 :bl_rec_subledger_group_code,      /o    POSTING     o/
		 :bl_rec_subledger_line_code,       /o                o/
		 :bl_rec_dept_code,                 /o      A/C       o/
		 :bl_rec_product_group_code,        /o                o/
		 :bl_rec_product_line_code,         /o -------------- o/
		 NVL(:nd_sum_outst_amt,0),          /o AMT LOCAL      o/
		 :nd_narration,                              /o NARRATION      o/
		 :bl_rec_main_acc1_code,            /o -------------- o/
		 :bl_rec_main_acc2_code,            /o                o/
		 :bl_rec_subledger_group_code,      /o    POSTING     o/
		 :bl_rec_subledger_line_code,       /o                o/
		 :bl_rec_dept_code,                 /o      A/C       o/
		 :bl_rec_product_group_code,        /o                o/
		 :bl_rec_product_line_code,          /o -------------- o/
		 :nd_acc_entity_code
	       ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "insert into AR_INV_LINE (DOC_TYPE_CODE,DOC_NUM,LINE_NUM,\
MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CO\
DE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,AMT_LOCAL,NARRATION,MAIN_ACC1_CODE_NEW\
,MAIN_ACC2_CODE_NEW,SUBLEDGER_GROUP_CODE_NEW,SUBLEDGER_LINE_CODE_NEW,DEPT_CODE\
_NEW,PRODUCT_GROUP_CODE_NEW,PRODUCT_LINE_CODE_NEW,ACC_ENTITY_CODE) values (:b0\
,:b1,1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,NVL(:b9,0),:b10,:b2,:b3,:b4,:b5,:b6,:b7,:b8\
,:b18)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1353;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
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
     sqlstm.sqhstv[2] = (         void  *)&bl_rec_main_acc1_code;
     sqlstm.sqhstl[2] = (unsigned int  )9;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_rec_main_acc2_code;
     sqlstm.sqhstl[3] = (unsigned int  )7;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_rec_subledger_group_code;
     sqlstm.sqhstl[4] = (unsigned int  )6;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_rec_subledger_line_code;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_rec_dept_code;
     sqlstm.sqhstl[6] = (unsigned int  )9;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_rec_product_group_code;
     sqlstm.sqhstl[7] = (unsigned int  )6;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_rec_product_line_code;
     sqlstm.sqhstl[8] = (unsigned int  )7;
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
     sqlstm.sqhstv[10] = (         void  *)&nd_narration;
     sqlstm.sqhstl[10] = (unsigned int  )53;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_rec_main_acc1_code;
     sqlstm.sqhstl[11] = (unsigned int  )9;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_rec_main_acc2_code;
     sqlstm.sqhstl[12] = (unsigned int  )7;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_rec_subledger_group_code;
     sqlstm.sqhstl[13] = (unsigned int  )6;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_rec_subledger_line_code;
     sqlstm.sqhstl[14] = (unsigned int  )11;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_rec_dept_code;
     sqlstm.sqhstl[15] = (unsigned int  )9;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_rec_product_group_code;
     sqlstm.sqhstl[16] = (unsigned int  )6;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_rec_product_line_code;
     sqlstm.sqhstl[17] = (unsigned int  )7;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&nd_acc_entity_code;
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
}

update_bl_hdr()
{

    /* EXEC SQL UPDATE BL_PATIENT_FIN_DTLS
    SET
      TOT_OUTST_IP_AMT      =  NVL(TOT_OUTST_IP_AMT,0) -
			       DECODE(:bl_h_episode_type,'I',:bl_h_bill_tot_outst_amt,0),
      TOT_OUTST_OP_AMT      =  NVL(TOT_OUTST_OP_AMT,0) -
			       DECODE(:bl_h_episode_type,'O',:bl_h_bill_tot_outst_amt,0),
      TOT_OUTST_REF_AMT     =  NVL(TOT_OUTST_REF_AMT,0) -
			       DECODE(:bl_h_episode_type,'R',:bl_h_bill_tot_outst_amt,0),
      MODIFIED_BY_ID        =  USER,         
      MODIFIED_DATE         =  SYSDATE,          
      MODIFIED_AT_WS_NO     =  :nd_ws_no,         
      MODIFIED_FACILITY_ID  =  :nd_facility_id         
    WHERE  PATIENT_ID     = :bl_h_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 65;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_PATIENT_FIN_DTLS  set TOT_OUTST_IP_AMT=(NVL(TOT\
_OUTST_IP_AMT,0)-DECODE(:b0,'I',:b1,0)),TOT_OUTST_OP_AMT=(NVL(TOT_OUTST_OP_AMT\
,0)-DECODE(:b0,'O',:b1,0)),TOT_OUTST_REF_AMT=(NVL(TOT_OUTST_REF_AMT,0)-DECODE(\
:b0,'R',:b1,0)),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b\
6,MODIFIED_FACILITY_ID=:b7 where PATIENT_ID=:b8";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1444;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_h_bill_tot_outst_amt;
    sqlstm.sqhstl[1] = (unsigned int  )25;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_h_bill_tot_outst_amt;
    sqlstm.sqhstl[3] = (unsigned int  )25;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_h_bill_tot_outst_amt;
    sqlstm.sqhstl[5] = (unsigned int  )25;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[6] = (unsigned int  )33;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[7] = (unsigned int  )5;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bl_h_patient_id;
    sqlstm.sqhstl[8] = (unsigned int  )23;
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



    if(OERROR || NO_DATA_FOUND)
	err_mesg("UPDATE failed on table BL_PATIENT_FIN_DTLS",0,"");

    if(bl_h_episode_type.arr[0] != 'R') {
      /* EXEC SQL UPDATE BL_EPISODE_FIN_DTLS
	       SET    TOT_OUTST_AMT = NVL(TOT_OUTST_AMT,0) - :bl_h_bill_tot_outst_amt,
	        MODIFIED_BY_ID        =  USER,         
	        MODIFIED_DATE         =  SYSDATE,          
      		MODIFIED_AT_WS_NO     =  :nd_ws_no,         
	        MODIFIED_FACILITY_ID  =  :nd_facility_id         
	     WHERE  EPISODE_TYPE  = :bl_h_episode_type
	     AND    EPISODE_ID    = :bl_h_episode_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 65;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update BL_EPISODE_FIN_DTLS  set TOT_OUTST_AMT=(NVL(TOT_\
OUTST_AMT,0)-:b0),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=\
:b1,MODIFIED_FACILITY_ID=:b2 where (EPISODE_TYPE=:b3 and EPISODE_ID=:b4)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1495;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_h_bill_tot_outst_amt;
      sqlstm.sqhstl[0] = (unsigned int  )25;
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
      sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_h_episode_type;
      sqlstm.sqhstl[3] = (unsigned int  )4;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_h_episode_id;
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



      if(OERROR || NO_DATA_FOUND)
	 err_mesg("UPDATE failed on table BL_EPISODE_FIN_DTLS",0,"");
      }

   if(bl_h_episode_type.arr[0] == 'O') {
     /* EXEC SQL UPDATE BL_VISIT_FIN_DTLS
	    SET TOT_OUTST_AMT = NVL(TOT_OUTST_AMT,0) - :bl_h_bill_tot_outst_amt,
	        MODIFIED_BY_ID        =  USER,         
	        MODIFIED_DATE         =  SYSDATE,          
      		MODIFIED_AT_WS_NO     =  :nd_ws_no,         
	        MODIFIED_FACILITY_ID  =  :nd_facility_id         
	    WHERE EPISODE_TYPE = :bl_h_episode_type
	    AND   EPISODE_ID   = :bl_h_episode_id
	    AND   VISIT_ID     = :bl_h_visit_id
	     ; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 65;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update BL_VISIT_FIN_DTLS  set TOT_OUTST_AMT=(NVL(TOT_OUT\
ST_AMT,0)-:b0),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1\
,MODIFIED_FACILITY_ID=:b2 where ((EPISODE_TYPE=:b3 and EPISODE_ID=:b4) and VIS\
IT_ID=:b5)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1530;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_h_bill_tot_outst_amt;
     sqlstm.sqhstl[0] = (unsigned int  )25;
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
     sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_h_episode_type;
     sqlstm.sqhstl[3] = (unsigned int  )4;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_h_episode_id;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_h_visit_id;
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



     if(OERROR || NO_DATA_FOUND)
	err_mesg("UPDATE failed on table BL_VISIT_FIN_DTLS",0,"");
     }
        
        
   /* EXEC SQL UPDATE BL_BILL_HDR
	       SET BILL_STATUS = 'A',
		   AR_INV_DOC_TYPE_CODE = :nd_new_doc_type_code,
		   AR_INV_DOC_NUMBER    = :nd_inv_start_doc_num,
		   AR_INV_DOC_DATE      = TO_DATE(NVL(:nd_inv_date,:bl_h_doc_date),'DD/MM/YYYY'),
		   BILL_TOT_OUTST_AMT   = NVL(BILL_TOT_OUTST_AMT,0) -
				            :bl_h_bill_tot_outst_amt,
		   AMT_TRANSFERRED	= nvl(AMT_TRANSFERRED,0) + :bl_h_bill_tot_outst_amt,
		   CONS_INVOICE_IND	= 'Y',
		   BILL_HOSP_TOT_OUTST_AMT  = NVL(BILL_HOSP_TOT_OUTST_AMT,0)-  :bl_h_bill_hosp_tot_outst_amt,
		   BILL_DRFEE_TOT_OUTST_AMT = NVL(BILL_DRFEE_TOT_OUTST_AMT,0)-
	                                       :bl_h_bill_drfee_tot_os_amt,
                   MODIFIED_BY_ID        =  USER,         
	           MODIFIED_DATE         =  SYSDATE,          
      		   MODIFIED_AT_WS_NO     =  :nd_ws_no,         
	           MODIFIED_FACILITY_ID  =  :nd_facility_id         
	     WHERE ROWID = :bl_h_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 65;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update BL_BILL_HDR  set BILL_STATUS='A',AR_INV_DOC_TYPE_CO\
DE=:b0,AR_INV_DOC_NUMBER=:b1,AR_INV_DOC_DATE=TO_DATE(NVL(:b2,:b3),'DD/MM/YYYY'\
),BILL_TOT_OUTST_AMT=(NVL(BILL_TOT_OUTST_AMT,0)-:b4),AMT_TRANSFERRED=(nvl(AMT_\
TRANSFERRED,0)+:b4),CONS_INVOICE_IND='Y',BILL_HOSP_TOT_OUTST_AMT=(NVL(BILL_HOS\
P_TOT_OUTST_AMT,0)-:b6),BILL_DRFEE_TOT_OUTST_AMT=(NVL(BILL_DRFEE_TOT_OUTST_AMT\
,0)-:b7),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b8,MODIF\
IED_FACILITY_ID=:b9 where ROWID=:b10";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1569;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_inv_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bl_h_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )15;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&bl_h_bill_tot_outst_amt;
   sqlstm.sqhstl[4] = (unsigned int  )25;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&bl_h_bill_tot_outst_amt;
   sqlstm.sqhstl[5] = (unsigned int  )25;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&bl_h_bill_hosp_tot_outst_amt;
   sqlstm.sqhstl[6] = (unsigned int  )25;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&bl_h_bill_drfee_tot_os_amt;
   sqlstm.sqhstl[7] = (unsigned int  )25;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[8] = (unsigned int  )33;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&bl_h_rowid;
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
	 err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");
}

