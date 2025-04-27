
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
           char  filnam[32];
};
static const struct sqlcxp sqlfpn =
{
    31,
    "C:\\VIJAYA\\CRF-304.2\\BLBDCINV.PC"
};


static unsigned long sqlctx = 1177032949;


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
            void  *sqhstv[68];
   unsigned int   sqhstl[68];
            int   sqhsts[68];
            void  *sqindv[68];
            int   sqinds[68];
   unsigned int   sqharm[68];
   unsigned int   *sqharc[68];
   unsigned short  sqadto[68];
   unsigned short  sqtdso[68];
} sqlstm = {10,68};

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
"D_YN,'E',OP_GL_REQD_YN,'I',IP_GL_REQD_YN,'D',IP_GL_REQD_YN,'R',RF_GL_REQD_YN\
,null ),'N','N',null ))))) and BILL_STATUS is null )           ";

 static const char *sq0008 = 
"FEE_BILL_UPD_FLAG ,DRFEE_REC_UPD_FLAG ,DRFEE_RECEIPT_AMT ,AR_INV_DOC_TYPE_CO\
DE ,AR_INV_DOC_NUMBER ,TO_CHAR(AR_INV_DOC_DATE,'DD/MM/YYYY') ,LAST_RECPT_DOC_T\
YPE_CODE ,LAST_RECPT_DOC_NUM ,TO_CHAR(LAST_RECPT_DOC_DATE,'DD/MM/YYYY') ,BILL_\
NATURE_CODE ,TOT_PAID_AMT ,BILL_POSTED_FLAG ,ADDED_BY_ID ,MODIFIED_BY_ID ,ADDE\
D_DATE ,MODIFIED_DATE ,ROWID  from BL_BILL_HDR where ((operating_facility_id=:\
b0 and DOC_TYPE_CODE=:b1) and DOC_NUM=:b2) for update of BILL_STATUS nowait ";

 static const char *sq0009 = 
"select b.BL_RECV_ACC_INT_CODE ,b.DCP_RECV_ACC_INT_CODE ,a.LONG_DESC  from BL\
_BILL_TYPE A ,BL_BILL_TYPE_INT b where (((a.BILL_TYPE_CODE=:b0 and a.BILL_TYPE\
_CODE=b.BILL_TYPE_CODE) and a.ACC_ENTITY_CODE=b.ACC_ENTITY_CODE) and TO_DATE(:\
b1,'DD/MM/YYYY') between NVL(b.eff_from_date,TO_DATE('01/01/1900','DD/MM/YYYY'\
)) and NVL(b.eff_to_date,SYSDATE))           ";

 static const char *sq0010 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,SUBLEDGER_GROUP_CODE ,SUBL\
EDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE  from BL_GL_ACCOUNT whe\
re ACC_INT_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,229,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,29,305,0,0,0,0,0,1,0,
51,0,0,3,0,0,30,313,0,0,0,0,0,1,0,
66,0,0,4,199,0,4,337,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
125,0,0,5,84,0,2,370,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
152,0,0,6,268,0,4,406,0,0,8,1,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,1,0,0,2,1,0,0,2,
1,0,0,2,1,0,0,1,9,0,0,
199,0,0,7,1163,0,9,609,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
250,0,0,7,0,0,13,625,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
277,0,0,8,1488,0,9,783,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
304,0,0,8,0,0,13,797,0,0,68,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
591,0,0,9,355,0,9,946,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
614,0,0,9,0,0,13,960,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
641,0,0,10,184,0,9,982,0,0,1,1,0,1,0,1,9,0,0,
660,0,0,10,0,0,13,1003,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
703,0,0,10,184,0,9,1030,0,0,1,1,0,1,0,1,9,0,0,
722,0,0,10,0,0,13,1051,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
765,0,0,11,884,0,3,1081,0,0,27,27,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
888,0,0,12,454,0,3,1180,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
963,0,0,13,965,0,3,1312,0,0,30,30,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,
0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1098,0,0,14,595,0,3,1405,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1169,0,0,15,762,0,3,1532,0,0,22,22,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1272,0,0,16,770,0,3,1599,0,0,22,22,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1375,0,0,17,344,0,5,1672,0,0,10,10,0,1,0,1,4,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,9,0,
0,1,4,0,0,1,4,0,0,1,9,0,0,1,4,0,0,1,9,0,0,
1430,0,0,18,148,0,5,1695,0,0,4,4,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1461,0,0,19,165,0,5,1715,0,0,5,5,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1496,0,0,20,296,0,5,1731,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1539,0,0,21,272,0,4,1753,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1582,0,0,22,282,0,4,1780,0,0,6,3,0,1,0,2,4,0,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLBDCINV.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 07-AUG-1993                                 */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */ 
/*                                                                      */
/*  TABLE DETAILS                                                        */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*          1.         BL_BILL_HDR               Read                   */
/*          2.         BL_BILL_LINE              Read                   */
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
#include <gl.h>
#include <bl.h>    

  

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])

#define VIEW_LOG_FILE 1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [30],
		    date_time                                  [20],
		    user_id                                    [91],
			uid_pwd									   [91],
		    nd_session_id                              [16],
		    nd_pgm_date                                [25],
		    d_curr_pgm_name                            [15],
			nd_facility_id							   [3],
			d_ws_no                                    [31],
		    nd_fm_doc_date                             [12],
		    nd_to_doc_date                             [12],
		    nd_fm_doc_type_code                        [7],
		    nd_to_doc_type_code                        [7],
		    nd_fm_doc_num                              [9],
		    nd_to_doc_num                              [9],
		    nd_inv_doc_type_code                       [7],
		    nd_inv_date                                [12],
		    nd_doc_num_gen_flag                        [2],
	
		    d_acc_status                               [2],
		    d_acc_valid_flag                           [2],
		    t_bill_print_flag						   [2],
		    d_sy_acc_rowid                             [31]; */ 
struct { unsigned short len; unsigned char arr[30]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[31]; } d_ws_no;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[7]; } nd_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[12]; } nd_inv_date;

struct { unsigned short len; unsigned char arr[2]; } nd_doc_num_gen_flag;

struct { unsigned short len; unsigned char arr[2]; } d_acc_status;

struct { unsigned short len; unsigned char arr[2]; } d_acc_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } t_bill_print_flag;

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
		   bl_h_bill_df_prv_outst_amt               [23],
		   bl_h_bill_tot_amt                           [23],
		   bl_h_bill_hosp_tot_amt                      [23],
		   bl_h_bill_drfee_tot_amt                     [23],
		   bl_h_bill_tot_outst_amt                     [23],
		   bl_h_bill_hosp_tot_outst_amt                [23],
		   bl_h_bill_df_tot_outst_amt               [23],
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
		   bl_h_blng_grp_id                            [5],
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
		   bl_h_last_rct_doc_type_code               [7],
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
       	
		   nd_new_doc_type_code                        [7],
	
		   bl_par_post_month                           [3],
		   bl_par_post_year                            [5],
	    
		   recv_int_code                               [7],
		   bl_recv_acc_int_code                        [7],
		   ar_recv_acc_int_code                        [7],
		   bl_bill_type_long_desc                      [31],
	
		   bl_rec_main_acc1_code                       [7],
		   bl_rec_main_acc2_code                       [5],
		   bl_rec_dept_code                            [12],
		   bl_rec_subledger_group_code                 [4],
		   bl_rec_subledger_line_code                  [9],
		   bl_rec_product_group_code                   [4],
		   bl_rec_product_line_code                    [5],
	
		   ar_rec_main_acc1_code                       [7],
		   ar_rec_main_acc2_code                       [5],
		   ar_rec_dept_code                            [12],
		   ar_rec_subledger_group_code                 [4],
		   ar_rec_subledger_line_code                  [9],
		   ar_rec_product_group_code                   [4],
		   ar_rec_product_line_code                    [5],
	
		   bl_cust_pmnt_terms_code                     [3],
		   ar_pmnt_cred_days_period                    [4],
		   ar_pmnt_settl_days_period                   [4],
		   ar_pmnt_settl_percent                       [9],
	
		   bl_h_credit_doc_ref_desc                    [16]; */ 
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

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_df_prv_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_drfee_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_tot_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_hosp_tot_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_h_bill_df_tot_outst_amt;

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

struct { unsigned short len; unsigned char arr[5]; } bl_h_blng_grp_id;

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

struct { unsigned short len; unsigned char arr[7]; } bl_h_last_rct_doc_type_code;

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

struct { unsigned short len; unsigned char arr[7]; } nd_new_doc_type_code;

struct { unsigned short len; unsigned char arr[3]; } bl_par_post_month;

struct { unsigned short len; unsigned char arr[5]; } bl_par_post_year;

struct { unsigned short len; unsigned char arr[7]; } recv_int_code;

struct { unsigned short len; unsigned char arr[7]; } bl_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[7]; } ar_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[31]; } bl_bill_type_long_desc;

struct { unsigned short len; unsigned char arr[7]; } bl_rec_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_rec_main_acc2_code;

struct { unsigned short len; unsigned char arr[12]; } bl_rec_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_rec_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_rec_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_rec_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_rec_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } ar_rec_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } ar_rec_main_acc2_code;

struct { unsigned short len; unsigned char arr[12]; } ar_rec_dept_code;

struct { unsigned short len; unsigned char arr[4]; } ar_rec_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } ar_rec_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } ar_rec_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } ar_rec_product_line_code;

struct { unsigned short len; unsigned char arr[3]; } bl_cust_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[4]; } ar_pmnt_cred_days_period;

struct { unsigned short len; unsigned char arr[4]; } ar_pmnt_settl_days_period;

struct { unsigned short len; unsigned char arr[9]; } ar_pmnt_settl_percent;

struct { unsigned short len; unsigned char arr[16]; } bl_h_credit_doc_ref_desc;

	
double     bill_tot_outst_amt,
		   bill_hosp_tot_outst_amt,
		   bill_drfee_tot_outst_amt,
		   d_tot_boun_clr_amt,
		   d_bounced_hosp_charges,
		   d_bounced_drfee_charges;

     int   bl_par_def_pat_crdt_days      = 0,
		   boun_exists,count;

    char   d_ip_gl_yn,
		   d_op_gl_yn,
		   d_rf_gl_yn,
		   d_bill_print_reqd_for_inv_yn;

    char   aMesg[2000];

	char   l_msg[500];

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

int    g_err_typ;

char g_err_id[8],
     g_err_msg[72];

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;

	//disp_message(ERR_MESG,"1");

    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    } 
 
	//disp_message(ERR_MESG,"1");

    strcpy(g_pgm_id,"BLBDCINV");


	strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    /* EXEC SQL CONNECT :uid_pwd; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )10;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
    sqlstm.sqhstl[0] = (unsigned int  )93;
    sqlstm.sqhsts[0] = (         int  )93;
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



    if(OERROR) {
		disp_message(ORA_MESG,"Unable to connect to oracle.");
		proc_exit();
    }
  
   	//disp_message(ERR_MESG,"2");

   set_meduser_role();

 
    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);
	strcpy(g_facility_id,nd_facility_id.arr);

    start_prog_msg();
//disp_message(ERR_MESG,"Before fetch prog param");
    fetch_prog_param();
//disp_message(ERR_MESG,"bef fetch bl param");

    fetch_bl_param();

   // fetch_ws_id(); 
//disp_message(ERR_MESG,"bef declare cur");
    declare_cur();
//disp_message(ERR_MESG,"bef open cur  hdr");    
    open_cur_hdr();
//disp_message(ERR_MESG,"bef while");

    while(fetch_cur())
    {
	 if(d_bill_print_reqd_for_inv_yn=='Y')
	 {

	   if(t_bill_print_flag.arr[0]=='N')
	  {
	   sprintf(aMesg,"Document Is Not Printed %s/%s",
	   bl_h_doc_type_code.arr,bl_h_doc_num.arr);
	   //log_err_mesg(l_msg,0,"");
	    disp_message(INFO_MESG,aMesg);
	   continue;
	}

	 } 


       rec_ctr++;
       if (!lock_record())
       {
	   //disp_message(ERR_MESG,"while 0");
	 sprintf(aMesg,"Bill Record %-s/%-s is locked ",
		bl_h_doc_type_code.arr,bl_h_doc_num.arr);
         disp_message(INFO_MESG,aMesg);
	 continue;
       }
  
 //disp_message(ERR_MESG,"while 1");

       bill_tot_outst_amt       -= d_tot_boun_clr_amt;
       bill_hosp_tot_outst_amt  += d_bounced_hosp_charges;
       bill_drfee_tot_outst_amt += d_bounced_drfee_charges;
//disp_message(ERR_MESG,"while 2");
       fetch_dtls();	   
//disp_message(ERR_MESG,"Before Insert rec...");
       insert_rec();  
//disp_message(ERR_MESG,"After Insert rec...");
       
       /* EXEC SQL COMMIT WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 4;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )36;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



       if (OERROR)
	 err_mesg("COMMIT failed",0,""); 
    }
//disp_message(ERR_MESG,"process success"); 
    end_prog_msg();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )51;
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
    nd_facility_id.arr[0]               = '\0';
    nd_fm_doc_date.arr[0]               = '\0';
    nd_to_doc_date.arr[0]               = '\0';
    nd_fm_doc_type_code.arr[0]          = '\0';
    nd_to_doc_type_code.arr[0]          = '\0';
    nd_fm_doc_num.arr[0]                = '\0';
    nd_to_doc_num.arr[0]                = '\0';
    nd_facility_id.len                  = 0;
    nd_fm_doc_date.len                  = 0;
    nd_to_doc_date.len                  = 0;
    nd_fm_doc_type_code.len             = 0;
    nd_to_doc_type_code.len             = 0;
    nd_fm_doc_num.len                   = 0;
    nd_to_doc_num.len                   = 0;
    /* EXEC SQL SELECT operating_facility_id,PARAM1,PARAM2,PARAM3,PARAM4,
		   PARAM5,PARAM6, PARAM7
	      INTO :nd_facility_id,:nd_fm_doc_date,      :nd_to_doc_date,
		   :nd_fm_doc_type_code, :nd_to_doc_type_code,
		   :nd_fm_doc_num,       :nd_to_doc_num,
		   :d_ws_no
	      FROM SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PAR\
AM4 ,PARAM5 ,PARAM6 ,PARAM7 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG\
_PARAM where ((PGM_ID=:b8 and SESSION_ID=:b9) and PGM_DATE=:b10)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )66;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_type_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_type_code;
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
    sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_ws_no;
    sqlstm.sqhstl[7] = (unsigned int  )33;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_curr_pgm_name;
    sqlstm.sqhstl[8] = (unsigned int  )17;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[9] = (unsigned int  )18;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[10] = (unsigned int  )27;
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
	err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
	err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_facility_id.arr[nd_facility_id.len]             = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]             = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]             = '\0';
   nd_fm_doc_type_code.arr[nd_fm_doc_type_code.len]   = '\0';
   nd_to_doc_type_code.arr[nd_to_doc_type_code.len]   = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]               = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]               = '\0';
/*
   disp_message(ERR_MESG,"d_curr_pgm_name");
disp_message(ERR_MESG,d_curr_pgm_name.arr);
disp_message(ERR_MESG,"nd_fm_doc_type_code");
disp_message(ERR_MESG,nd_fm_doc_type_code.arr);*/

   strcpy(g_facility_id,nd_facility_id.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )125;
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
   
}

fetch_bl_param()
{

    bl_par_post_month.arr[0]      = '\0';
    bl_par_post_year.arr[0]       = '\0';

    bl_par_post_month.len         = 0;
    bl_par_post_year.len          = 0;

    bl_par_def_pat_crdt_days      = 0;

    d_ip_gl_yn       = '\0';
    d_op_gl_yn       = '\0';
    d_rf_gl_yn       = '\0';
	d_bill_print_reqd_for_inv_yn ='\0';

    /*
    EXEC SQL SELECT CURRENT_PROC_ACC_MONTH,  CURRENT_PROC_ACC_YEAR,
		    DEF_PAT_CRDT_DAYS
	       INTO :bl_par_post_month,      :bl_par_post_year,
		    :bl_par_def_pat_crdt_days
	       FROM BL_PARAMETERS
		   WHERE operating_facility_id = :nd_facility_id;
    */


    /* EXEC SQL SELECT 
            CURRENT_PROC_ACC_MONTH,
            CURRENT_PROC_ACC_YEAR,
    
    /o      TO_CHAR(SYSDATE,'MM'),
            TO_CHAR(SYSDATE,'YY'),  o/
            
		    DEF_PAT_CRDT_DAYS,
		    NVL(IP_GL_REQD_YN,'N'),
		    NVL(OP_GL_REQD_YN,'N'),
		    NVL(RF_GL_REQD_YN,'N'),
			nvl(BILL_PRINTING_REQD_FOR_DCP_YN,'N')
	       INTO :bl_par_post_month,      :bl_par_post_year,
		    :bl_par_def_pat_crdt_days,
		    :d_ip_gl_yn,
		    :d_op_gl_yn,
		    :d_rf_gl_yn,
			:d_bill_print_reqd_for_inv_yn
	       FROM BL_PARAMETERS
		   WHERE operating_facility_id = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CURRENT_PROC_ACC_MONTH ,CURRENT_PROC_ACC_YEAR ,DEF\
_PAT_CRDT_DAYS ,NVL(IP_GL_REQD_YN,'N') ,NVL(OP_GL_REQD_YN,'N') ,NVL(RF_GL_REQD\
_YN,'N') ,nvl(BILL_PRINTING_REQD_FOR_DCP_YN,'N') into :b0,:b1,:b2,:b3,:b4,:b5,\
:b6  from BL_PARAMETERS where operating_facility_id=:b7";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )152;
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
    sqlstm.sqhstv[2] = (         void  *)&bl_par_def_pat_crdt_days;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ip_gl_yn;
    sqlstm.sqhstl[3] = (unsigned int  )1;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_op_gl_yn;
    sqlstm.sqhstl[4] = (unsigned int  )1;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_rf_gl_yn;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_bill_print_reqd_for_inv_yn;
    sqlstm.sqhstl[6] = (unsigned int  )1;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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

}
/*
fetch_ws_id()
{
   d_ws_no.arr[0]      = '\0'; 
  d_ws_no.len = 0;

  EXEC SQL EXECUTE
	BEGIN
		workstation.get_workstation_id (:nd_facility_id, :d_ws_no);
	END;
	END-EXEC;

  d_ws_no.arr[d_ws_no.len]      = '\0'; 
} 
*/
declare_cur()
{

     /* EXEC SQL DECLARE BL_HDR_CUR CURSOR FOR
	       SELECT DOC_TYPE_CODE,
		      DOC_NUM,
			  Nvl(bill_print_flag,'N')
		 FROM BL_BILL_HDR a
		 WHERE operating_facility_id = :nd_facility_id AND
	     TRUNC(DOC_DATE)     BETWEEN
			NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),
                           to_date('01/01/1900','DD/MM/YYYY'))
		     AND 
			NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),
                            to_date('01/01/3000','DD/MM/YYYY'))
		  AND 
				  RPAD(DOC_TYPE_CODE,6,' ')|| LPAD(DOC_NUM,8,'0')
					 BETWEEN
					 RPAD(NVL(:nd_fm_doc_type_code,' '),6,' ')||
					 LPAD(NVL(:nd_fm_doc_num,0),8,'0')
					 AND
					 RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6,' ')||
					 LPAD(NVL(:nd_to_doc_num,99999999),8,'0')
		  AND BILL_NATURE_CODE = 'C'
		  AND BILL_TRX_TYPE_CODE != 'I'
		  AND ( (BILL_POSTED_FLAG = 'Y' 
                 AND  EXISTS
                (SELECT 'x' FROM  BL_PARAMETERS  B
                 WHERE  operating_facility_id = :nd_facility_id and decode(a.episode_type,'O','Y','E','Y', 'I','Y','D','Y','R','Y','N')=
                           
                                   Decode(decode(a.episode_type,'O',OP_GL_REQD_YN,
                                                                'E',OP_GL_REQD_YN,
                                                                'I',IP_GL_REQD_YN,
                                                                'D',IP_GL_REQD_YN,
                                                                'R',RF_GL_REQD_YN,null),'Y','Y',null)
                )
                )
              OR (EXISTS
                 (SELECT 'x' FROM  BL_PARAMETERS  B
                  WHERE  operating_facility_id = :nd_facility_id and decode(a.episode_type,'O','N','E','N', 'I','N','D','N','R','N','Y')=
                           
                                   Decode(decode(a.episode_type,'O',OP_GL_REQD_YN,
                                                                'E',OP_GL_REQD_YN,
                                                                'I',IP_GL_REQD_YN,
                                                                'D',IP_GL_REQD_YN,
                                                                'R',RF_GL_REQD_YN,null),'N','N',null)
                 )
				)
            ) 
		
		  AND BILL_STATUS IS NULL; */ 




     /* EXEC SQL DECLARE BL_HDR_REC_CUR CURSOR FOR
	       SELECT TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
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
		      NVL(BILL_HOSP_TOT_OUTST_AMT,0),
		      NVL(BILL_DRFEE_TOT_OUTST_AMT,0),
		      NVL(BILL_TOT_OUTST_AMT,0),
		      NVL(BILL_HOSP_TOT_OUTST_AMT,0),
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
		WHERE operating_facility_id = :nd_facility_id AND
			  DOC_TYPE_CODE = :bl_h_doc_type_code
		  AND DOC_NUM       = :bl_h_doc_num
		  FOR UPDATE OF BILL_STATUS NOWAIT; */ 


     /* EXEC SQL DECLARE BL_BILL_TYPE_CUR CURSOR FOR
	       SELECT b.BL_RECV_ACC_INT_CODE,
		      b.DCP_RECV_ACC_INT_CODE,
		      a.LONG_DESC
		 FROM BL_BILL_TYPE A, BL_BILL_TYPE_INT b
		WHERE a.BILL_TYPE_CODE = :bl_h_bill_type_code
		and a.BILL_TYPE_CODE = b.BILL_TYPE_CODE
		and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE
		AND   TO_DATE(:bl_h_doc_date,'DD/MM/YYYY') between 
		      NVL(b.eff_from_date,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(b.eff_to_date,SYSDATE); */ 

		      /* Effective date range is included ON 01/06/2004 */

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


}

open_cur_hdr()
{
     /* EXEC SQL OPEN BL_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "select DOC_TYPE_CODE ,DOC_NUM ,Nvl(bill_print_flag,'N')  from BL_BIL\
L_HDR a where ((((((operating_facility_id=:b0 and TRUNC(DOC_DATE) between NV\
L(TO_DATE(:b1,'DD/MM/YYYY'),to_date('01/01/1900','DD/MM/YYYY')) and NVL(TO_D\
ATE(:b2,'DD/MM/YYYY'),to_date('01/01/3000','DD/MM/YYYY'))) and (RPAD(DOC_TYP\
E_CODE,6,' ')||LPAD(DOC_NUM,8,'0')) between (RPAD(NVL(:b3,' '),6,' ')||LPAD(\
NVL(:b4,0),8,'0')) and (RPAD(NVL(:b5,'~~~~~~'),6,' ')||LPAD(NVL(:b6,99999999\
),8,'0'))) and BILL_NATURE_CODE='C') and BILL_TRX_TYPE_CODE<>'I') and ((BILL\
_POSTED_FLAG='Y' and exists (select 'x'  from BL_PARAMETERS B where (operati\
ng_facility_id=:b0 and decode(a.episode_type,'O','Y','E','Y','I','Y','D','Y'\
,'R','Y','N')=Decode(decode(a.episode_type,'O',OP_GL_REQD_YN,'E',OP_GL_REQD_\
YN,'I',IP_GL_REQD_YN,'D',IP_GL_REQD_YN,'R',RF_GL_REQD_YN,null ),'Y','Y',null\
 )))) or exists (select 'x'  from BL_PARAMETERS B where (operating_facility_\
id=:b0 and decode(a.episode_type,'O','N','E','N','I','N','D','N','R','N','Y'\
)=Decode(decode(a.episode_type,'O',OP_GL_REQ");
     sqlstm.stmt = sq0007;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )199;
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
     sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_type_code;
     sqlstm.sqhstl[3] = (unsigned int  )9;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_num;
     sqlstm.sqhstl[4] = (unsigned int  )11;
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
     sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_num;
     sqlstm.sqhstl[6] = (unsigned int  )11;
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
	 err_mesg("OPEN failed on cursor BL_HDR_CUR",0,"");
}

fetch_cur()
{
//disp_message(ERR_MESG,"In fetch_cur...");
bl_h_doc_type_code.arr[0]                                         = '\0';
bl_h_doc_num.arr[0]                                               = '\0';
t_bill_print_flag.arr[0]            = '\0';
bl_h_doc_type_code.len                                            = 0;
bl_h_doc_num.len                                                  = 0;
t_bill_print_flag.len=0;

     /* EXEC SQL FETCH BL_HDR_CUR
	       INTO :bl_h_doc_type_code,
		    :bl_h_doc_num,
		    :t_bill_print_flag; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )250;
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
     sqlstm.sqhstv[2] = (         void  *)&t_bill_print_flag;
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


//disp_message(ERR_MESG,"fetch cur 2");
     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_HDR_CUR",0,"");

bl_h_doc_type_code.arr[bl_h_doc_type_code.len]                           = '\0';
bl_h_doc_num.arr[bl_h_doc_num.len]                                       = '\0';
t_bill_print_flag.arr[t_bill_print_flag.len]  = '\0';

if(LAST_ROW) 
count=0;
   return(LAST_ROW?0:1);
   //disp_message(ERR_MESG,"process success"); 
}

lock_record()
{
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
bl_h_bill_df_prv_outst_amt.arr[0]                              = '\0';
bl_h_bill_tot_amt.arr[0]                                          = '\0';
bl_h_bill_hosp_tot_amt.arr[0]                                     = '\0';
bl_h_bill_drfee_tot_amt.arr[0]                                    = '\0';
bl_h_bill_tot_outst_amt.arr[0]                                    = '\0';
bl_h_bill_hosp_tot_outst_amt.arr[0]                               = '\0';
bl_h_bill_df_tot_outst_amt.arr[0]                              = '\0';
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
bl_h_last_rct_doc_type_code.arr[0]                              = '\0';
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
bl_h_bill_df_prv_outst_amt.len                                 = 0;
bl_h_bill_tot_amt.len                                             = 0;
bl_h_bill_hosp_tot_amt.len                                        = 0;
bl_h_bill_drfee_tot_amt.len                                       = 0;
bl_h_bill_tot_outst_amt.len                                       = 0;
bl_h_bill_hosp_tot_outst_amt.len                                  = 0;
bl_h_bill_df_tot_outst_amt.len                                 = 0;
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
bl_h_last_rct_doc_type_code.len                                 = 0;
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

bill_tot_outst_amt       = 0;
bill_hosp_tot_outst_amt  = 0;
bill_drfee_tot_outst_amt = 0;

     /* EXEC SQL OPEN BL_HDR_REC_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
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
) ,NVL(BILL_HOSP_TOT_OUTST_AMT,0) ,NVL(BILL_DRFEE_TOT_OUTST_AMT,0) ,NVL(BILL\
_TOT_OUTST_AMT,0) ,NVL(BILL_HOSP_TOT_OUTST_AMT,0) ,NVL(BILL_DRFEE_TOT_OUTST_\
AMT,0) ,BILL_PAID_AMT ,EPISODE_TYPE ,PATIENT_ID ,EPISODE_ID ,VISIT_ID ,TO_CH\
AR(ADMISSION_DATE,'DD/MM/YYYY') ,WARD_CODE ,BED_CLASS_CODE ,ROOM_NUM ,BED_NU\
M ,PHYSICIAN_ID ,CLINIC_CODE ,CUST_CODE ,BLNG_GRP_ID ,BILL_TYPE_CODE ,CONS_I\
NVOICE_IND ,BILL_STATUS ,BILL_PRINT_FLAG ,DR");
     sqlstm.stmt = sq0008;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )277;
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
     sqlstm.sqhstv[1] = (         void  *)&bl_h_doc_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_h_doc_num;
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



     sprintf(l_str,"BL BILL HDR Document %s - %s busy",
	     bl_h_doc_type_code.arr,bl_h_doc_num.arr);

     if (RESOURCE_BUSY)
     {
	 log_err_mesg(l_str,0,"");
	 return(0);
     }
     else if (OERROR)
	 err_mesg("OPEN failed on cursor BL_HDR_REC_CUR",0,"");
//disp_message(ERR_MESG,"fetch cur ");

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
		    :bl_h_bill_df_prv_outst_amt,
		    :bl_h_bill_tot_amt,
		    :bl_h_bill_hosp_tot_amt,
		    :bl_h_bill_drfee_tot_amt,
		    :bl_h_bill_tot_outst_amt,
		    :bl_h_bill_hosp_tot_outst_amt,
		    :bl_h_bill_df_tot_outst_amt,
		    :bill_tot_outst_amt,
		    :bill_hosp_tot_outst_amt,
		    :bill_drfee_tot_outst_amt,
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
		    :bl_h_last_rct_doc_type_code,
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
     sqlstm.arrsiz = 68;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )304;
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
     sqlstm.sqhstv[23] = (         void  *)&bl_h_bill_df_prv_outst_amt;
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
     sqlstm.sqhstv[29] = (         void  *)&bl_h_bill_df_tot_outst_amt;
     sqlstm.sqhstl[29] = (unsigned int  )25;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&bill_tot_outst_amt;
     sqlstm.sqhstl[30] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&bill_hosp_tot_outst_amt;
     sqlstm.sqhstl[31] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&bill_drfee_tot_outst_amt;
     sqlstm.sqhstl[32] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[32] = (         int  )0;
     sqlstm.sqindv[32] = (         void  *)0;
     sqlstm.sqinds[32] = (         int  )0;
     sqlstm.sqharm[32] = (unsigned int  )0;
     sqlstm.sqadto[32] = (unsigned short )0;
     sqlstm.sqtdso[32] = (unsigned short )0;
     sqlstm.sqhstv[33] = (         void  *)&bl_h_bill_paid_amt;
     sqlstm.sqhstl[33] = (unsigned int  )25;
     sqlstm.sqhsts[33] = (         int  )0;
     sqlstm.sqindv[33] = (         void  *)0;
     sqlstm.sqinds[33] = (         int  )0;
     sqlstm.sqharm[33] = (unsigned int  )0;
     sqlstm.sqadto[33] = (unsigned short )0;
     sqlstm.sqtdso[33] = (unsigned short )0;
     sqlstm.sqhstv[34] = (         void  *)&bl_h_episode_type;
     sqlstm.sqhstl[34] = (unsigned int  )4;
     sqlstm.sqhsts[34] = (         int  )0;
     sqlstm.sqindv[34] = (         void  *)0;
     sqlstm.sqinds[34] = (         int  )0;
     sqlstm.sqharm[34] = (unsigned int  )0;
     sqlstm.sqadto[34] = (unsigned short )0;
     sqlstm.sqtdso[34] = (unsigned short )0;
     sqlstm.sqhstv[35] = (         void  *)&bl_h_patient_id;
     sqlstm.sqhstl[35] = (unsigned int  )23;
     sqlstm.sqhsts[35] = (         int  )0;
     sqlstm.sqindv[35] = (         void  *)0;
     sqlstm.sqinds[35] = (         int  )0;
     sqlstm.sqharm[35] = (unsigned int  )0;
     sqlstm.sqadto[35] = (unsigned short )0;
     sqlstm.sqtdso[35] = (unsigned short )0;
     sqlstm.sqhstv[36] = (         void  *)&bl_h_episode_id;
     sqlstm.sqhstl[36] = (unsigned int  )11;
     sqlstm.sqhsts[36] = (         int  )0;
     sqlstm.sqindv[36] = (         void  *)0;
     sqlstm.sqinds[36] = (         int  )0;
     sqlstm.sqharm[36] = (unsigned int  )0;
     sqlstm.sqadto[36] = (unsigned short )0;
     sqlstm.sqtdso[36] = (unsigned short )0;
     sqlstm.sqhstv[37] = (         void  *)&bl_h_visit_id;
     sqlstm.sqhstl[37] = (unsigned int  )7;
     sqlstm.sqhsts[37] = (         int  )0;
     sqlstm.sqindv[37] = (         void  *)0;
     sqlstm.sqinds[37] = (         int  )0;
     sqlstm.sqharm[37] = (unsigned int  )0;
     sqlstm.sqadto[37] = (unsigned short )0;
     sqlstm.sqtdso[37] = (unsigned short )0;
     sqlstm.sqhstv[38] = (         void  *)&bl_h_admission_date;
     sqlstm.sqhstl[38] = (unsigned int  )15;
     sqlstm.sqhsts[38] = (         int  )0;
     sqlstm.sqindv[38] = (         void  *)0;
     sqlstm.sqinds[38] = (         int  )0;
     sqlstm.sqharm[38] = (unsigned int  )0;
     sqlstm.sqadto[38] = (unsigned short )0;
     sqlstm.sqtdso[38] = (unsigned short )0;
     sqlstm.sqhstv[39] = (         void  *)&bl_h_ward_code;
     sqlstm.sqhstl[39] = (unsigned int  )7;
     sqlstm.sqhsts[39] = (         int  )0;
     sqlstm.sqindv[39] = (         void  *)0;
     sqlstm.sqinds[39] = (         int  )0;
     sqlstm.sqharm[39] = (unsigned int  )0;
     sqlstm.sqadto[39] = (unsigned short )0;
     sqlstm.sqtdso[39] = (unsigned short )0;
     sqlstm.sqhstv[40] = (         void  *)&bl_h_bed_class_code;
     sqlstm.sqhstl[40] = (unsigned int  )5;
     sqlstm.sqhsts[40] = (         int  )0;
     sqlstm.sqindv[40] = (         void  *)0;
     sqlstm.sqinds[40] = (         int  )0;
     sqlstm.sqharm[40] = (unsigned int  )0;
     sqlstm.sqadto[40] = (unsigned short )0;
     sqlstm.sqtdso[40] = (unsigned short )0;
     sqlstm.sqhstv[41] = (         void  *)&bl_h_room_num;
     sqlstm.sqhstl[41] = (unsigned int  )7;
     sqlstm.sqhsts[41] = (         int  )0;
     sqlstm.sqindv[41] = (         void  *)0;
     sqlstm.sqinds[41] = (         int  )0;
     sqlstm.sqharm[41] = (unsigned int  )0;
     sqlstm.sqadto[41] = (unsigned short )0;
     sqlstm.sqtdso[41] = (unsigned short )0;
     sqlstm.sqhstv[42] = (         void  *)&bl_h_bed_num;
     sqlstm.sqhstl[42] = (unsigned int  )11;
     sqlstm.sqhsts[42] = (         int  )0;
     sqlstm.sqindv[42] = (         void  *)0;
     sqlstm.sqinds[42] = (         int  )0;
     sqlstm.sqharm[42] = (unsigned int  )0;
     sqlstm.sqadto[42] = (unsigned short )0;
     sqlstm.sqtdso[42] = (unsigned short )0;
     sqlstm.sqhstv[43] = (         void  *)&bl_h_physician_id;
     sqlstm.sqhstl[43] = (unsigned int  )18;
     sqlstm.sqhsts[43] = (         int  )0;
     sqlstm.sqindv[43] = (         void  *)0;
     sqlstm.sqinds[43] = (         int  )0;
     sqlstm.sqharm[43] = (unsigned int  )0;
     sqlstm.sqadto[43] = (unsigned short )0;
     sqlstm.sqtdso[43] = (unsigned short )0;
     sqlstm.sqhstv[44] = (         void  *)&bl_h_clinic_code;
     sqlstm.sqhstl[44] = (unsigned int  )7;
     sqlstm.sqhsts[44] = (         int  )0;
     sqlstm.sqindv[44] = (         void  *)0;
     sqlstm.sqinds[44] = (         int  )0;
     sqlstm.sqharm[44] = (unsigned int  )0;
     sqlstm.sqadto[44] = (unsigned short )0;
     sqlstm.sqtdso[44] = (unsigned short )0;
     sqlstm.sqhstv[45] = (         void  *)&bl_h_cust_code;
     sqlstm.sqhstl[45] = (unsigned int  )11;
     sqlstm.sqhsts[45] = (         int  )0;
     sqlstm.sqindv[45] = (         void  *)0;
     sqlstm.sqinds[45] = (         int  )0;
     sqlstm.sqharm[45] = (unsigned int  )0;
     sqlstm.sqadto[45] = (unsigned short )0;
     sqlstm.sqtdso[45] = (unsigned short )0;
     sqlstm.sqhstv[46] = (         void  *)&bl_h_blng_grp_id;
     sqlstm.sqhstl[46] = (unsigned int  )7;
     sqlstm.sqhsts[46] = (         int  )0;
     sqlstm.sqindv[46] = (         void  *)0;
     sqlstm.sqinds[46] = (         int  )0;
     sqlstm.sqharm[46] = (unsigned int  )0;
     sqlstm.sqadto[46] = (unsigned short )0;
     sqlstm.sqtdso[46] = (unsigned short )0;
     sqlstm.sqhstv[47] = (         void  *)&bl_h_bill_type_code;
     sqlstm.sqhstl[47] = (unsigned int  )5;
     sqlstm.sqhsts[47] = (         int  )0;
     sqlstm.sqindv[47] = (         void  *)0;
     sqlstm.sqinds[47] = (         int  )0;
     sqlstm.sqharm[47] = (unsigned int  )0;
     sqlstm.sqadto[47] = (unsigned short )0;
     sqlstm.sqtdso[47] = (unsigned short )0;
     sqlstm.sqhstv[48] = (         void  *)&bl_h_cons_invoice_ind;
     sqlstm.sqhstl[48] = (unsigned int  )4;
     sqlstm.sqhsts[48] = (         int  )0;
     sqlstm.sqindv[48] = (         void  *)0;
     sqlstm.sqinds[48] = (         int  )0;
     sqlstm.sqharm[48] = (unsigned int  )0;
     sqlstm.sqadto[48] = (unsigned short )0;
     sqlstm.sqtdso[48] = (unsigned short )0;
     sqlstm.sqhstv[49] = (         void  *)&bl_h_bill_status;
     sqlstm.sqhstl[49] = (unsigned int  )4;
     sqlstm.sqhsts[49] = (         int  )0;
     sqlstm.sqindv[49] = (         void  *)0;
     sqlstm.sqinds[49] = (         int  )0;
     sqlstm.sqharm[49] = (unsigned int  )0;
     sqlstm.sqadto[49] = (unsigned short )0;
     sqlstm.sqtdso[49] = (unsigned short )0;
     sqlstm.sqhstv[50] = (         void  *)&bl_h_bill_print_flag;
     sqlstm.sqhstl[50] = (unsigned int  )4;
     sqlstm.sqhsts[50] = (         int  )0;
     sqlstm.sqindv[50] = (         void  *)0;
     sqlstm.sqinds[50] = (         int  )0;
     sqlstm.sqharm[50] = (unsigned int  )0;
     sqlstm.sqadto[50] = (unsigned short )0;
     sqlstm.sqtdso[50] = (unsigned short )0;
     sqlstm.sqhstv[51] = (         void  *)&bl_h_drfee_bill_upd_flag;
     sqlstm.sqhstl[51] = (unsigned int  )4;
     sqlstm.sqhsts[51] = (         int  )0;
     sqlstm.sqindv[51] = (         void  *)0;
     sqlstm.sqinds[51] = (         int  )0;
     sqlstm.sqharm[51] = (unsigned int  )0;
     sqlstm.sqadto[51] = (unsigned short )0;
     sqlstm.sqtdso[51] = (unsigned short )0;
     sqlstm.sqhstv[52] = (         void  *)&bl_h_drfee_rec_upd_flag;
     sqlstm.sqhstl[52] = (unsigned int  )4;
     sqlstm.sqhsts[52] = (         int  )0;
     sqlstm.sqindv[52] = (         void  *)0;
     sqlstm.sqinds[52] = (         int  )0;
     sqlstm.sqharm[52] = (unsigned int  )0;
     sqlstm.sqadto[52] = (unsigned short )0;
     sqlstm.sqtdso[52] = (unsigned short )0;
     sqlstm.sqhstv[53] = (         void  *)&bl_h_drfee_receipt_amt;
     sqlstm.sqhstl[53] = (unsigned int  )25;
     sqlstm.sqhsts[53] = (         int  )0;
     sqlstm.sqindv[53] = (         void  *)0;
     sqlstm.sqinds[53] = (         int  )0;
     sqlstm.sqharm[53] = (unsigned int  )0;
     sqlstm.sqadto[53] = (unsigned short )0;
     sqlstm.sqtdso[53] = (unsigned short )0;
     sqlstm.sqhstv[54] = (         void  *)&bl_h_ar_inv_doc_type_code;
     sqlstm.sqhstl[54] = (unsigned int  )9;
     sqlstm.sqhsts[54] = (         int  )0;
     sqlstm.sqindv[54] = (         void  *)0;
     sqlstm.sqinds[54] = (         int  )0;
     sqlstm.sqharm[54] = (unsigned int  )0;
     sqlstm.sqadto[54] = (unsigned short )0;
     sqlstm.sqtdso[54] = (unsigned short )0;
     sqlstm.sqhstv[55] = (         void  *)&bl_h_ar_inv_doc_number;
     sqlstm.sqhstl[55] = (unsigned int  )11;
     sqlstm.sqhsts[55] = (         int  )0;
     sqlstm.sqindv[55] = (         void  *)0;
     sqlstm.sqinds[55] = (         int  )0;
     sqlstm.sqharm[55] = (unsigned int  )0;
     sqlstm.sqadto[55] = (unsigned short )0;
     sqlstm.sqtdso[55] = (unsigned short )0;
     sqlstm.sqhstv[56] = (         void  *)&bl_h_ar_inv_doc_date;
     sqlstm.sqhstl[56] = (unsigned int  )15;
     sqlstm.sqhsts[56] = (         int  )0;
     sqlstm.sqindv[56] = (         void  *)0;
     sqlstm.sqinds[56] = (         int  )0;
     sqlstm.sqharm[56] = (unsigned int  )0;
     sqlstm.sqadto[56] = (unsigned short )0;
     sqlstm.sqtdso[56] = (unsigned short )0;
     sqlstm.sqhstv[57] = (         void  *)&bl_h_last_rct_doc_type_code;
     sqlstm.sqhstl[57] = (unsigned int  )9;
     sqlstm.sqhsts[57] = (         int  )0;
     sqlstm.sqindv[57] = (         void  *)0;
     sqlstm.sqinds[57] = (         int  )0;
     sqlstm.sqharm[57] = (unsigned int  )0;
     sqlstm.sqadto[57] = (unsigned short )0;
     sqlstm.sqtdso[57] = (unsigned short )0;
     sqlstm.sqhstv[58] = (         void  *)&bl_h_last_recpt_doc_num;
     sqlstm.sqhstl[58] = (unsigned int  )25;
     sqlstm.sqhsts[58] = (         int  )0;
     sqlstm.sqindv[58] = (         void  *)0;
     sqlstm.sqinds[58] = (         int  )0;
     sqlstm.sqharm[58] = (unsigned int  )0;
     sqlstm.sqadto[58] = (unsigned short )0;
     sqlstm.sqtdso[58] = (unsigned short )0;
     sqlstm.sqhstv[59] = (         void  *)&bl_h_last_recpt_doc_date;
     sqlstm.sqhstl[59] = (unsigned int  )15;
     sqlstm.sqhsts[59] = (         int  )0;
     sqlstm.sqindv[59] = (         void  *)0;
     sqlstm.sqinds[59] = (         int  )0;
     sqlstm.sqharm[59] = (unsigned int  )0;
     sqlstm.sqadto[59] = (unsigned short )0;
     sqlstm.sqtdso[59] = (unsigned short )0;
     sqlstm.sqhstv[60] = (         void  *)&bl_h_bill_nature_code;
     sqlstm.sqhstl[60] = (unsigned int  )4;
     sqlstm.sqhsts[60] = (         int  )0;
     sqlstm.sqindv[60] = (         void  *)0;
     sqlstm.sqinds[60] = (         int  )0;
     sqlstm.sqharm[60] = (unsigned int  )0;
     sqlstm.sqadto[60] = (unsigned short )0;
     sqlstm.sqtdso[60] = (unsigned short )0;
     sqlstm.sqhstv[61] = (         void  *)&bl_h_tot_paid_amt;
     sqlstm.sqhstl[61] = (unsigned int  )25;
     sqlstm.sqhsts[61] = (         int  )0;
     sqlstm.sqindv[61] = (         void  *)0;
     sqlstm.sqinds[61] = (         int  )0;
     sqlstm.sqharm[61] = (unsigned int  )0;
     sqlstm.sqadto[61] = (unsigned short )0;
     sqlstm.sqtdso[61] = (unsigned short )0;
     sqlstm.sqhstv[62] = (         void  *)&bl_h_bill_posted_flag;
     sqlstm.sqhstl[62] = (unsigned int  )4;
     sqlstm.sqhsts[62] = (         int  )0;
     sqlstm.sqindv[62] = (         void  *)0;
     sqlstm.sqinds[62] = (         int  )0;
     sqlstm.sqharm[62] = (unsigned int  )0;
     sqlstm.sqadto[62] = (unsigned short )0;
     sqlstm.sqtdso[62] = (unsigned short )0;
     sqlstm.sqhstv[63] = (         void  *)&bl_h_added_by_id;
     sqlstm.sqhstl[63] = (unsigned int  )23;
     sqlstm.sqhsts[63] = (         int  )0;
     sqlstm.sqindv[63] = (         void  *)0;
     sqlstm.sqinds[63] = (         int  )0;
     sqlstm.sqharm[63] = (unsigned int  )0;
     sqlstm.sqadto[63] = (unsigned short )0;
     sqlstm.sqtdso[63] = (unsigned short )0;
     sqlstm.sqhstv[64] = (         void  *)&bl_h_modified_by_id;
     sqlstm.sqhstl[64] = (unsigned int  )23;
     sqlstm.sqhsts[64] = (         int  )0;
     sqlstm.sqindv[64] = (         void  *)0;
     sqlstm.sqinds[64] = (         int  )0;
     sqlstm.sqharm[64] = (unsigned int  )0;
     sqlstm.sqadto[64] = (unsigned short )0;
     sqlstm.sqtdso[64] = (unsigned short )0;
     sqlstm.sqhstv[65] = (         void  *)&bl_h_added_date;
     sqlstm.sqhstl[65] = (unsigned int  )15;
     sqlstm.sqhsts[65] = (         int  )0;
     sqlstm.sqindv[65] = (         void  *)0;
     sqlstm.sqinds[65] = (         int  )0;
     sqlstm.sqharm[65] = (unsigned int  )0;
     sqlstm.sqadto[65] = (unsigned short )0;
     sqlstm.sqtdso[65] = (unsigned short )0;
     sqlstm.sqhstv[66] = (         void  *)&bl_h_modified_date;
     sqlstm.sqhstl[66] = (unsigned int  )15;
     sqlstm.sqhsts[66] = (         int  )0;
     sqlstm.sqindv[66] = (         void  *)0;
     sqlstm.sqinds[66] = (         int  )0;
     sqlstm.sqharm[66] = (unsigned int  )0;
     sqlstm.sqadto[66] = (unsigned short )0;
     sqlstm.sqtdso[66] = (unsigned short )0;
     sqlstm.sqhstv[67] = (         void  *)&bl_h_rowid;
     sqlstm.sqhstl[67] = (unsigned int  )33;
     sqlstm.sqhsts[67] = (         int  )0;
     sqlstm.sqindv[67] = (         void  *)0;
     sqlstm.sqinds[67] = (         int  )0;
     sqlstm.sqharm[67] = (unsigned int  )0;
     sqlstm.sqadto[67] = (unsigned short )0;
     sqlstm.sqtdso[67] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


//disp_message(ERR_MESG,"fetch cur 56");
      if (OERROR)
	 err_mesg("FETCH failed on cursor BL_HDR_CUR",0,"");
       if (NOT_FOUND)
     err_mesg("No data found on cursor BL_HDR_CUR",0,"");

//disp_message(ERR_MESG,"end of fetch cur");

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
bl_h_bill_df_prv_outst_amt.arr[bl_h_bill_df_prv_outst_amt.len]     = '\0';
bl_h_bill_tot_amt.arr[bl_h_bill_tot_amt.len]                             = '\0';
bl_h_bill_hosp_tot_amt.arr[bl_h_bill_hosp_tot_amt.len]                   = '\0';
bl_h_bill_drfee_tot_amt.arr[bl_h_bill_drfee_tot_amt.len]                 = '\0';
bl_h_bill_tot_outst_amt.arr[bl_h_bill_tot_outst_amt.len]                 = '\0';
bl_h_bill_hosp_tot_outst_amt.arr[bl_h_bill_hosp_tot_outst_amt.len]       = '\0';
bl_h_bill_df_tot_outst_amt.arr[bl_h_bill_df_tot_outst_amt.len]     = '\0';
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
bl_h_last_rct_doc_type_code.arr[bl_h_last_rct_doc_type_code.len]     = '\0';
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

   return(ROW_COUNT);
}

fetch_dtls()
{
      //disp_message(ERR_MESG,"in fetch dtls...");
     /* EXEC SQL OPEN BL_BILL_TYPE_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 68;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0009;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )591;
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
     sqlstm.sqhstv[1] = (         void  *)&bl_h_doc_date;
     sqlstm.sqhstl[1] = (unsigned int  )15;
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
    bl_bill_type_long_desc.arr[0]          = '\0';

    bl_recv_acc_int_code.len               = 0;
    ar_recv_acc_int_code.len               = 0;
    bl_bill_type_long_desc.len             = 0;

    //disp_message(ERR_MESG,bl_h_bill_type_code.arr);  //pradeep
	 /* EXEC SQL FETCH BL_BILL_TYPE_CUR
	       INTO :bl_recv_acc_int_code,
		    :ar_recv_acc_int_code, 
		    :bl_bill_type_long_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 68;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )614;
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
  sqlstm.sqhstv[2] = (         void  *)&bl_bill_type_long_desc;
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



//disp_message(ERR_MESG,"fetch_dtl 1");

     if (OERROR)
	 err_mesg("FETCH failed on cursor BL_BILL_TYPE_CUR",0,"");

     if (NOT_FOUND)
	 err_mesg("Record not found in BL BILL TYPE",0,"");

     bl_recv_acc_int_code.arr[bl_recv_acc_int_code.len] = '\0';
     ar_recv_acc_int_code.arr[ar_recv_acc_int_code.len] = '\0';
     bl_bill_type_long_desc.arr[bl_bill_type_long_desc.len] = '\0';



     strcpy(recv_int_code.arr,bl_recv_acc_int_code.arr);
     recv_int_code.len = strlen(recv_int_code.arr);

     /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 68;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )641;
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
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
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
     sqlstm.arrsiz = 68;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )660;
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
     sqlstm.sqhstl[2] = (unsigned int  )14;
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
     sqlstm.arrsiz = 68;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )703;
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
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
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
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 68;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )722;
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
     sqlstm.sqhstl[2] = (unsigned int  )14;
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

}

insert_rec()
{

   // disp_message(ERR_MESG,bl_h_doc_type_code.arr);
//	 disp_message(ERR_MESG,bl_h_doc_num.arr);
	 /* EXEC SQL INSERT INTO BL_DCP_ORG_TRN_HDR
	     (operating_facility_id,
		 DOC_TYPE_CODE,
		 DOC_NUMBER,
		 PATIENT_ID,
		 DOC_DATE,
		 DUE_DATE,
		 TRX_TYPE_CODE,
		 EPISODE_TYPE,
		 EPISODE_ID,
		 VISIT_ID,
		 
		 PAT_DOC_REFERENCE,
		 BILL_TYPE_CODE,
		 DOC_NATURE_CODE,
		 DOC_AMT,
		 HOSP_CHG_AMT,
		 DRFEE_CHG_AMT,
		 MAIN_ACC1_CODE,
		 MAIN_ACC2_CODE,
		 SUBLEDGER_GROUP_CODE,
		 SUBLEDGER_LINE_CODE,
		 DEPT_CODE,
		 PRODUCT_GROUP_CODE,
		 PRODUCT_LINE_CODE,
		 NARRATION,
		 POST_MONTH,
		 POST_YEAR,
		 MAX_LINE_NUM,
		 POSTED_FLAG,
		 POSTED_DATE_TIME,
		 POSTED_BY_ID,
		 ADDED_BY_ID,
		 MODIFIED_BY_ID,
		 ADDED_DATE,
		 MODIFIED_DATE,
		 ADDED_AT_WS_NO,         
		 ADDED_FACILITY_ID,      
		 MODIFIED_AT_WS_NO,      
		 MODIFIED_FACILITY_ID   

	       )
	      VALUES
	       (:nd_facility_id,
		 :bl_h_doc_type_code,             /o DOC_TYPE_CODE o/
		 :bl_h_doc_num,                     /o DOC_NUM       o/
		 :bl_h_patient_id,                  /o PATIENT ID    o/
 		 TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'), /o DOC DATE      o/
		 TO_DATE(:bl_h_doc_date,'DD/MM/YYYY') + :bl_par_def_pat_crdt_days, /o DUE DATE o/
		 '1',                               /o TRX TYPE CODE o/
		 :bl_h_episode_type,                /o EPISODE TYPE  o/
		 :bl_h_episode_id,                  /o EPISODE ID    o/
		 :bl_h_visit_id,                    /o VISIT ID      o/
		 
		 NULL,                              /o PAT_DOC_REFERENCE o/
		 :bl_h_bill_type_code,              /o BILL TYPE CODE o/
		 NULL,                              /o DOC NATURE CODE o/
		 :bill_tot_outst_amt,               /o DOC AMT       o/
		 :bill_hosp_tot_outst_amt,          /o HOSP CHG AMT  o/
		 :bill_drfee_tot_outst_amt,         /o DRFEE CHG AMT o/
		 :ar_rec_main_acc1_code,           /o -------------- o/
		 :ar_rec_main_acc2_code,           /o                o/
		 :ar_rec_subledger_group_code,     /o    POSTING     o/
		 :ar_rec_subledger_line_code,      /o                o/
		 :ar_rec_dept_code,                /o      A/C       o/
		 :ar_rec_product_group_code,       /o                o/
		 :ar_rec_product_line_code,        /o -------------- o/
		 NULL,                             /o NARRATION      o/
         to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'MM'), /o POST MONTH     o/
         to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'YYYY'), /o POST YEAR      o/
		 1,                                /o MAX LINE NUM   o/
		 'Y',                              /o POSTED FLAG    o/
         SYSDATE,                             /o POSTED DATE TIME o/
		 USER,                             /o POSTED BY ID   o/
		 USER,                             /o ADDED BY ID    o/
		 USER,                             /o MODIFIED BY ID o/
		 SYSDATE,					       /o ADDED DATE     o/
		 sysdate ,                             /o MODIFIED DATE  o/
         :d_ws_no,
		 :nd_facility_id,
		 :d_ws_no,
		 :nd_facility_id
	       ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 68;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into BL_DCP_ORG_TRN_HDR (operating_facility_id,DOC_T\
YPE_CODE,DOC_NUMBER,PATIENT_ID,DOC_DATE,DUE_DATE,TRX_TYPE_CODE,EPISODE_TYPE,EP\
ISODE_ID,VISIT_ID,PAT_DOC_REFERENCE,BILL_TYPE_CODE,DOC_NATURE_CODE,DOC_AMT,HOS\
P_CHG_AMT,DRFEE_CHG_AMT,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUB\
LEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,NARRATION,POST\
_MONTH,POST_YEAR,MAX_LINE_NUM,POSTED_FLAG,POSTED_DATE_TIME,POSTED_BY_ID,ADDED_\
BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID\
,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,TO_DATE(:b4,'\
DD/MM/YYYY'),(TO_DATE(:b4,'DD/MM/YYYY')+:b6),'1',:b7,:b8,:b9,null ,:b10,null ,\
:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20,null ,to_char(to_date(:b4,'D\
D/MM/YYYY'),'MM'),to_char(to_date(:b4,'DD/MM/YYYY'),'YYYY'),1,'Y',SYSDATE,USER\
,USER,USER,SYSDATE,sysdate,:b23,:b0,:b23,:b0)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )765;
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
  sqlstm.sqhstv[1] = (         void  *)&bl_h_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_h_doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bl_h_patient_id;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&bl_h_doc_date;
  sqlstm.sqhstl[4] = (unsigned int  )15;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&bl_h_doc_date;
  sqlstm.sqhstl[5] = (unsigned int  )15;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&bl_par_def_pat_crdt_days;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&bl_h_episode_type;
  sqlstm.sqhstl[7] = (unsigned int  )4;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&bl_h_episode_id;
  sqlstm.sqhstl[8] = (unsigned int  )11;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&bl_h_visit_id;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&bl_h_bill_type_code;
  sqlstm.sqhstl[10] = (unsigned int  )5;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&bill_tot_outst_amt;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&bill_hosp_tot_outst_amt;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&bill_drfee_tot_outst_amt;
  sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&ar_rec_main_acc1_code;
  sqlstm.sqhstl[14] = (unsigned int  )9;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&ar_rec_main_acc2_code;
  sqlstm.sqhstl[15] = (unsigned int  )7;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&ar_rec_subledger_group_code;
  sqlstm.sqhstl[16] = (unsigned int  )6;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&ar_rec_subledger_line_code;
  sqlstm.sqhstl[17] = (unsigned int  )11;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&ar_rec_dept_code;
  sqlstm.sqhstl[18] = (unsigned int  )14;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&ar_rec_product_group_code;
  sqlstm.sqhstl[19] = (unsigned int  )6;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&ar_rec_product_line_code;
  sqlstm.sqhstl[20] = (unsigned int  )7;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqhstv[21] = (         void  *)&bl_h_doc_date;
  sqlstm.sqhstl[21] = (unsigned int  )15;
  sqlstm.sqhsts[21] = (         int  )0;
  sqlstm.sqindv[21] = (         void  *)0;
  sqlstm.sqinds[21] = (         int  )0;
  sqlstm.sqharm[21] = (unsigned int  )0;
  sqlstm.sqadto[21] = (unsigned short )0;
  sqlstm.sqtdso[21] = (unsigned short )0;
  sqlstm.sqhstv[22] = (         void  *)&bl_h_doc_date;
  sqlstm.sqhstl[22] = (unsigned int  )15;
  sqlstm.sqhsts[22] = (         int  )0;
  sqlstm.sqindv[22] = (         void  *)0;
  sqlstm.sqinds[22] = (         int  )0;
  sqlstm.sqharm[22] = (unsigned int  )0;
  sqlstm.sqadto[22] = (unsigned short )0;
  sqlstm.sqtdso[22] = (unsigned short )0;
  sqlstm.sqhstv[23] = (         void  *)&d_ws_no;
  sqlstm.sqhstl[23] = (unsigned int  )33;
  sqlstm.sqhsts[23] = (         int  )0;
  sqlstm.sqindv[23] = (         void  *)0;
  sqlstm.sqinds[23] = (         int  )0;
  sqlstm.sqharm[23] = (unsigned int  )0;
  sqlstm.sqadto[23] = (unsigned short )0;
  sqlstm.sqtdso[23] = (unsigned short )0;
  sqlstm.sqhstv[24] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[24] = (unsigned int  )5;
  sqlstm.sqhsts[24] = (         int  )0;
  sqlstm.sqindv[24] = (         void  *)0;
  sqlstm.sqinds[24] = (         int  )0;
  sqlstm.sqharm[24] = (unsigned int  )0;
  sqlstm.sqadto[24] = (unsigned short )0;
  sqlstm.sqtdso[24] = (unsigned short )0;
  sqlstm.sqhstv[25] = (         void  *)&d_ws_no;
  sqlstm.sqhstl[25] = (unsigned int  )33;
  sqlstm.sqhsts[25] = (         int  )0;
  sqlstm.sqindv[25] = (         void  *)0;
  sqlstm.sqinds[25] = (         int  )0;
  sqlstm.sqharm[25] = (unsigned int  )0;
  sqlstm.sqadto[25] = (unsigned short )0;
  sqlstm.sqtdso[25] = (unsigned short )0;
  sqlstm.sqhstv[26] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[26] = (unsigned int  )5;
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
	 err_mesg("INSERT failed on table BL_DCP_ORG_TRN_HDR",0,"");

    /**** Added NK 23/03/94 to post immediately ****/

	

    process_hdr();

	


    /***********************************************/


     /* EXEC SQL INSERT INTO BL_DCP_ORG_TRN_DTL
	       (OPERATING_FACILITY_ID,
		 DOC_TYPE_CODE,
		 DOC_NUMBER,
		 LINE_NUM,
		 MAIN_ACC1_CODE,
		 MAIN_ACC2_CODE,
		 SUBLEDGER_GROUP_CODE,
		 SUBLEDGER_LINE_CODE,
		 DEPT_CODE,
		 PRODUCT_GROUP_CODE,
		 PRODUCT_LINE_CODE,
		 DOC_AMT,
		 NARRATION,
		 ADDED_BY_ID,
		 MODIFIED_BY_ID,
		 ADDED_DATE,
		 MODIFIED_DATE,
		 ADDED_AT_WS_NO,         
		 ADDED_FACILITY_ID,      
		 MODIFIED_AT_WS_NO,      
		 MODIFIED_FACILITY_ID   
	       )
	     VALUES
	       (:nd_facility_id,
		 :bl_h_doc_type_code,               /o DOC_TYPE_CODE  o/
		 :bl_h_doc_num,                     /o DOC_NUM        o/
		 1,                                 /o LINE NUM       o/
		 :bl_rec_main_acc1_code,            /o -------------- o/
		 :bl_rec_main_acc2_code,            /o                o/
		 :bl_rec_subledger_group_code,      /o    POSTING     o/
		 :bl_rec_subledger_line_code,       /o                o/
		 :bl_rec_dept_code,                 /o      A/C       o/
		 :bl_rec_product_group_code,        /o                o/
		 :bl_rec_product_line_code,         /o -------------- o/
		 :bill_tot_outst_amt,               /o DOC AMT        o/
		 NULL,                              /o NARRATION      o/
		 USER,                             /o ADDED BY ID    o/
		 USER,                             /o MODIFIED BY ID o/
		 SYSDATE,					       /o ADDED DATE     o/
		 sysdate ,                             /o MODIFIED DATE  o/
         :d_ws_no,
		 :nd_facility_id,
		 :d_ws_no,
		 :nd_facility_id
	       ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 68;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "insert into BL_DCP_ORG_TRN_DTL (OPERATING_FACILITY_ID,DO\
C_TYPE_CODE,DOC_NUMBER,LINE_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_\
CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,DOC_AM\
T,NARRATION,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO\
,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2\
,1,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,null ,USER,USER,SYSDATE,sysdate,:b11,:b0,:\
b11,:b0)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )888;
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
     sqlstm.sqhstv[1] = (         void  *)&bl_h_doc_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_h_doc_num;
     sqlstm.sqhstl[2] = (unsigned int  )11;
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
     sqlstm.sqhstl[7] = (unsigned int  )14;
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
     sqlstm.sqhstv[10] = (         void  *)&bill_tot_outst_amt;
     sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&d_ws_no;
     sqlstm.sqhstl[11] = (unsigned int  )33;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[12] = (unsigned int  )5;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&d_ws_no;
     sqlstm.sqhstl[13] = (unsigned int  )33;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[14] = (unsigned int  )5;
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
	 err_mesg("INSERT failed on table BL_DCP_ORG_TRN_DTL",0,"");

    /**** Added NK 23/03/94 to post immediately ****/


    process_dtl();

 

    updt_patient_fin_dtls();


    /***********************************************/
}

/**************** ADDED NK 23/03/94 ****************************************/
process_hdr()
{
   char aMesg[80];
         
	 
		if(validate_posting_acct( ar_rec_main_acc1_code.arr,
				  ar_rec_main_acc2_code.arr,
				  ar_rec_dept_code.arr,
				  ar_rec_product_group_code.arr,
				  ar_rec_product_line_code.arr,
				  ar_rec_subledger_group_code.arr,
				  ar_rec_subledger_line_code.arr,
				  'Y',
				  "BL",
				  &g_err_typ,
				  g_err_id,
				  g_err_msg
				  ) ==  -1) {

				  

	    if (g_err_typ) {  /* application error */
		sprintf(aMesg,"Posting A/C (HDR) : %s-%s %s %s-%s %s-%s\n",
			ar_rec_main_acc1_code.arr,
			ar_rec_main_acc2_code.arr,
			ar_rec_dept_code.arr,
			ar_rec_product_group_code.arr,
			ar_rec_product_line_code.arr,
			ar_rec_subledger_group_code.arr,
			ar_rec_subledger_line_code.arr);

		disp_message(ERR_MESG,aMesg);
        disp_message(ERR_MESG,g_err_id);
//if strcmp(t_bill_print_flag.arr ,"N") == 0 )

		if(!strcmp(g_err_id,"GL1430"))
		  err_mesg("Invalid Posting Account",0,"");
		else if(!strcmp(g_err_id,"GL1540"))
		  err_mesg("Posting A/C should be detail account",0,"");
		else if(!strcmp(g_err_id,"GL2530"))
		  err_mesg("Monthly Balance not Available for this Posting A/c, Cannot Process",0,"");
		else
		  err_mesg("Posting A/C has been suspended",0,"");
	    }

	    else   /* oracle error */

		err_mesg(g_err_msg,0,"");

	} /* end of if validate_posting_acct */ 


//disp_message(ERR_MESG,"Before pending doc...");
	insrt_pending_doc();
//disp_message(ERR_MESG,"Before dcp trn....");
	
	insrt_bl_dcp_trn();
//disp_message(ERR_MESG,"Before gl list");
	
	insrt_bl_gl_dist(1);

	

}

insrt_pending_doc()
{

    /* EXEC SQL INSERT INTO BL_DCP_PENDING_DOC 
		    ( operating_facility_id,
			 PATIENT_ID,
			 ORG_DOC_TYPE_CODE,
			 ORG_DOC_NUMBER,
			 ORG_DOC_DATE,
			 DUE_DATE,
			 TRX_TYPE_CODE,
			 EPISODE_TYPE,
			 EPISODE_ID,
			 VISIT_ID,
			 PAT_DOC_REFERENCE,
			 BILL_TYPE_CODE,
			 DOC_NATURE_CODE,
			 DOC_AMT,
			 HOSP_CHG_AMT,
			 DRFEE_CHG_AMT,
			 DOC_OUTST_AMT,
			 HOSP_CHG_OUTST_AMT,
			 DRFEE_CHG_OUTST_AMT,
			 MAIN_ACC1_CODE,
			 MAIN_ACC2_CODE,
			 DEPT_CODE,
			 PRODUCT_GROUP_CODE,
			 PRODUCT_LINE_CODE,
			 SUBLEDGER_GROUP_CODE,
			 SUBLEDGER_LINE_CODE,
			 NARRATION,
			 POST_MONTH,
			 POST_YEAR,
			 TRX_PROCESSED_IND,
			 MAX_LINE_NUM,
			 POSTED_DATE,
			 POSTED_BY_ID,
			 ADDED_BY_ID,            
			 MODIFIED_BY_ID,         
			 ADDED_DATE     ,        
			 MODIFIED_DATE   ,       
			 ADDED_AT_WS_NO   ,      
			 ADDED_FACILITY_ID ,     
			 MODIFIED_AT_WS_NO  ,    
			 MODIFIED_FACILITY_ID   
		    )
	     VALUES (:nd_facility_id,
		 :bl_h_patient_id,
		 :bl_h_doc_type_code,
		 :bl_h_doc_num,
		 TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),
		 TO_DATE(:bl_h_doc_date,'DD/MM/YYYY') + :bl_par_def_pat_crdt_days,
		 '1',
		 :bl_h_episode_type,
		 :bl_h_episode_id,
		 :bl_h_visit_id,
		 NULL,
		 :bl_h_bill_type_code,
		 NULL,
		 :bill_tot_outst_amt,
		 :bill_hosp_tot_outst_amt,
		 :bill_drfee_tot_outst_amt,
		 :bill_tot_outst_amt,
		 :bill_hosp_tot_outst_amt,
		 :bill_drfee_tot_outst_amt,
		 :ar_rec_main_acc1_code,
		 :ar_rec_main_acc2_code,
		 :ar_rec_dept_code,
		 :ar_rec_product_group_code,
		 :ar_rec_product_line_code,
		 :ar_rec_subledger_group_code,
		 :ar_rec_subledger_line_code,
		 NULL,
         to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'MM'),
         to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'YYYY'),
		 'Y',
		 1,
		 SYSDATE,
		 USER,
		 USER,                             /o ADDED BY ID    o/
		 USER,                             /o MODIFIED BY ID o/
		 SYSDATE,					       /o ADDED DATE     o/
		 sysdate ,                             /o MODIFIED DATE  o/
         :d_ws_no,
		 :nd_facility_id,
		 :d_ws_no,
		 :nd_facility_id
	       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 68;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_DCP_PENDING_DOC (operating_facility_id,PAT\
IENT_ID,ORG_DOC_TYPE_CODE,ORG_DOC_NUMBER,ORG_DOC_DATE,DUE_DATE,TRX_TYPE_CODE,E\
PISODE_TYPE,EPISODE_ID,VISIT_ID,PAT_DOC_REFERENCE,BILL_TYPE_CODE,DOC_NATURE_CO\
DE,DOC_AMT,HOSP_CHG_AMT,DRFEE_CHG_AMT,DOC_OUTST_AMT,HOSP_CHG_OUTST_AMT,DRFEE_C\
HG_OUTST_AMT,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUC\
T_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,NARRATION,POST_MONTH,POST\
_YEAR,TRX_PROCESSED_IND,MAX_LINE_NUM,POSTED_DATE,POSTED_BY_ID,ADDED_BY_ID,MODI\
FIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_\
AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,TO_DATE(:b4,'DD/MM/YYYY\
'),(TO_DATE(:b4,'DD/MM/YYYY')+:b6),'1',:b7,:b8,:b9,null ,:b10,null ,:b11,:b12,\
:b13,:b11,:b12,:b13,:b17,:b18,:b19,:b20,:b21,:b22,:b23,null ,to_char(to_date(:\
b4,'DD/MM/YYYY'),'MM'),to_char(to_date(:b4,'DD/MM/YYYY'),'YYYY'),'Y',1,SYSDATE\
,USER,USER,USER,SYSDATE,sysdate,:b26,:b0,:b26,:b0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )963;
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
    sqlstm.sqhstv[1] = (         void  *)&bl_h_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_h_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_h_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_h_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )15;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_h_doc_date;
    sqlstm.sqhstl[5] = (unsigned int  )15;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_par_def_pat_crdt_days;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bl_h_episode_id;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&bl_h_visit_id;
    sqlstm.sqhstl[9] = (unsigned int  )7;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&bl_h_bill_type_code;
    sqlstm.sqhstl[10] = (unsigned int  )5;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&bill_hosp_tot_outst_amt;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&bill_drfee_tot_outst_amt;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&bill_hosp_tot_outst_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&bill_drfee_tot_outst_amt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&ar_rec_main_acc1_code;
    sqlstm.sqhstl[17] = (unsigned int  )9;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&ar_rec_main_acc2_code;
    sqlstm.sqhstl[18] = (unsigned int  )7;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&ar_rec_dept_code;
    sqlstm.sqhstl[19] = (unsigned int  )14;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&ar_rec_product_group_code;
    sqlstm.sqhstl[20] = (unsigned int  )6;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&ar_rec_product_line_code;
    sqlstm.sqhstl[21] = (unsigned int  )7;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&ar_rec_subledger_group_code;
    sqlstm.sqhstl[22] = (unsigned int  )6;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&ar_rec_subledger_line_code;
    sqlstm.sqhstl[23] = (unsigned int  )11;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&bl_h_doc_date;
    sqlstm.sqhstl[24] = (unsigned int  )15;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&bl_h_doc_date;
    sqlstm.sqhstl[25] = (unsigned int  )15;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_ws_no;
    sqlstm.sqhstl[26] = (unsigned int  )33;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[27] = (unsigned int  )5;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&d_ws_no;
    sqlstm.sqhstl[28] = (unsigned int  )33;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[29] = (unsigned int  )5;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
	err_mesg("INSERT failed on table BL_DCP_PENDING_DOC",0,"");

}

insrt_bl_dcp_trn()
{
    /* EXEC SQL INSERT INTO BL_DCP_TRN
		    (operating_facility_id,
			 PATIENT_ID,
			 ORG_DOC_TYPE_CODE,
			 ORG_DOC_NUMBER,
			 LINE_NUM,
			 DOC_TYPE_CODE,
			 DOC_NUMBER,
			 DOC_DATE,
			 PAT_DOC_REFERENCE,
			 DOC_NATURE_CODE,
			 DOC_AMT,
			 TRX_TYPE_CODE,
			 NARRATION,
			 POST_MONTH,
			 POST_YEAR,
			 POSTED_DATE,
			 POSTED_BY_ID,
 			 ADDED_BY_ID,            
			 MODIFIED_BY_ID,         
			 ADDED_DATE     ,        
			 MODIFIED_DATE   ,       
			 ADDED_AT_WS_NO   ,      
			 ADDED_FACILITY_ID ,     
			 MODIFIED_AT_WS_NO  ,    
			 MODIFIED_FACILITY_ID   
		    )    
	    VALUES  ( :nd_facility_id,
		      :bl_h_patient_id,
			 :bl_h_doc_type_code,
			 :bl_h_doc_num,
			 0,
			 :bl_h_doc_type_code,
			 :bl_h_doc_num,
			 TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),
			 NULL,
			 NULL,
			 :bill_tot_outst_amt,
			 '1',
			 NULL,
             to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'MM'),
             to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'YYYY'),
			 SYSDATE,
			 USER,
	 		 USER,                             /o ADDED BY ID    o/
			 USER,                             /o MODIFIED BY ID o/
			 SYSDATE,					       /o ADDED DATE     o/
			 sysdate ,                             /o MODIFIED DATE  o/
			:d_ws_no,
			:nd_facility_id,
			:d_ws_no,
			:nd_facility_id
			 ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 68;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_DCP_TRN (operating_facility_id,PATIENT_ID,\
ORG_DOC_TYPE_CODE,ORG_DOC_NUMBER,LINE_NUM,DOC_TYPE_CODE,DOC_NUMBER,DOC_DATE,PA\
T_DOC_REFERENCE,DOC_NATURE_CODE,DOC_AMT,TRX_TYPE_CODE,NARRATION,POST_MONTH,POS\
T_YEAR,POSTED_DATE,POSTED_BY_ID,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED\
_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)\
 values (:b0,:b1,:b2,:b3,0,:b2,:b3,TO_DATE(:b6,'DD/MM/YYYY'),null ,null ,:b7,'\
1',null ,to_char(to_date(:b6,'DD/MM/YYYY'),'MM'),to_char(to_date(:b6,'DD/MM/YY\
YY'),'YYYY'),SYSDATE,USER,USER,USER,SYSDATE,sysdate,:b10,:b0,:b10,:b0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1098;
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
    sqlstm.sqhstv[1] = (         void  *)&bl_h_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_h_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_h_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )11;
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
    sqlstm.sqhstv[7] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bl_h_doc_date;
    sqlstm.sqhstl[8] = (unsigned int  )15;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&bl_h_doc_date;
    sqlstm.sqhstl[9] = (unsigned int  )15;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_ws_no;
    sqlstm.sqhstl[10] = (unsigned int  )33;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[11] = (unsigned int  )5;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_ws_no;
    sqlstm.sqhstl[12] = (unsigned int  )33;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_facility_id;
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


	    
    if(OERROR)
	err_mesg("INSERT failed on table BL_DCP_TRN",0,"");

}

process_dtl()
{


    char aMesg[80];
	if(validate_posting_acct( bl_rec_main_acc1_code.arr,

				  bl_rec_main_acc2_code.arr,
				  bl_rec_dept_code.arr,
				  bl_rec_product_group_code.arr,
				  bl_rec_product_line_code.arr,
				  bl_rec_subledger_group_code.arr,
				  bl_rec_subledger_line_code.arr,
				  'N',
				  "BL",
				  &g_err_typ,
				  g_err_id,
				  g_err_msg
				  ) ==  -1) {

	    if (g_err_typ) {  /* application error */
		sprintf(aMesg,"Posting A/C (LINE) : %s-%s %s %s-%s %s-%s\n",
			bl_rec_main_acc1_code.arr,
			bl_rec_main_acc2_code.arr,
			bl_rec_dept_code.arr,
			bl_rec_product_group_code.arr,
			bl_rec_product_line_code.arr,
			bl_rec_subledger_group_code.arr,
			bl_rec_subledger_line_code.arr);
	
		disp_message(INFO_MESG,aMesg);
		
		if(!strcmp(g_err_id,"GL1430"))		  
		  err_mesg("Invalid Posting Account",0,"");
		  
		else if(!strcmp(g_err_id,"GL1540"))
		  err_mesg("Posting A/C should be detail account",0,"");

		else if(!strcmp(g_err_id,"GL2530"))
		  err_mesg("Monthly Balance not Available for this Posting A/c, Cannot Process",0,"");

		else
		  err_mesg("Posting A/C has been suspended",0,"");
	    }

	    else   /* oracle error */

		err_mesg(g_err_msg,0,"");

	} /* end of if validate_posting_acct */ 

	insrt_bl_gl_dist(2);

}

insrt_bl_gl_dist(flg)
int flg;
{

    if( (bl_h_episode_type.arr[0] == 'I' && d_ip_gl_yn == 'N') ||
        (bl_h_episode_type.arr[0] == 'D' && d_ip_gl_yn == 'N') || 
	(bl_h_episode_type.arr[0] == 'O' && d_op_gl_yn == 'N') ||
        (bl_h_episode_type.arr[0] == 'E' && d_op_gl_yn == 'N') ||
	(bl_h_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N') )
	return;

    if(flg EQ 1) {

	/* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
			(    operating_facility_id,
			     MAIN_ACC1_CODE,
			     MAIN_ACC2_CODE,
			     DEPT_CODE,
			     PRODUCT_GROUP_CODE,
			     PRODUCT_LINE_CODE,
			     SUBLEDGER_GROUP_CODE,
			     SUBLEDGER_LINE_CODE,
			     POST_YEAR,
			     POST_MONTH,
			     TRX_DATE,
			     TRX_DOC_REF,
			     TRX_DOC_REF_LINE_NUM,
			     TRX_DOC_REF_SEQ_NUM,
			     EPISODE_TYPE,
			     PATIENT_ID,
			     EPISODE_ID,
			     VISIT_ID,
			     NARRATION,
			     TRX_TYPE_CODE,
			     DISTRIBUTION_AMT,
			     GL_INTERFACE_FLAG,
	  			 ADDED_BY_ID,            
				 MODIFIED_BY_ID,         
				 ADDED_DATE     ,        
				 MODIFIED_DATE   ,       
				ADDED_AT_WS_NO   ,      
				ADDED_FACILITY_ID ,     
				MODIFIED_AT_WS_NO  ,    
				MODIFIED_FACILITY_ID   
			)
		VALUES  (:nd_facility_id,
		         :ar_rec_main_acc1_code,
			     :ar_rec_main_acc2_code,
			     :ar_rec_dept_code,
			     :ar_rec_product_group_code,
			     :ar_rec_product_line_code,
			     :ar_rec_subledger_group_code,
			     :ar_rec_subledger_line_code,
                 to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'YYYY'),
                 to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'MM'),
                             to_date(:bl_h_doc_date,'DD/MM/YYYY'),
			     RPAD(:bl_h_doc_type_code,6,' ')||'-'||
					LPAD(:bl_h_doc_num,8,'0'),
			     0,
			     0,
			     :bl_h_episode_type,
			     :bl_h_patient_id,
			     :bl_h_episode_id,
			     :bl_h_visit_id,
			     NULL,
			     '1',
			     :bill_tot_outst_amt,
			     'N',
				 	 		 USER,                             /o ADDED BY ID    o/
			 USER,                             /o MODIFIED BY ID o/
			 SYSDATE,					       /o ADDED DATE     o/
			 sysdate ,                             /o MODIFIED DATE  o/
			:d_ws_no,
			:nd_facility_id,
			:d_ws_no,
			:nd_facility_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 68;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (operating_facility_id,MAIN_A\
CC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLEDG\
ER_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,TR\
X_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISI\
T_ID,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT,GL_INTERFACE_FLAG,ADDED_BY_ID,MO\
DIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIE\
D_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,to_ch\
ar(to_date(:b8,'DD/MM/YYYY'),'YYYY'),to_char(to_date(:b8,'DD/MM/YYYY'),'MM'),t\
o_date(:b8,'DD/MM/YYYY'),((RPAD(:b11,6,' ')||'-')||LPAD(:b12,8,'0')),0,0,:b13,\
:b14,:b15,:b16,null ,'1',:b17,'N',USER,USER,SYSDATE,sysdate,:b18,:b0,:b18,:b0)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1169;
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
 sqlstm.sqhstv[1] = (         void  *)&ar_rec_main_acc1_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ar_rec_main_acc2_code;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ar_rec_dept_code;
 sqlstm.sqhstl[3] = (unsigned int  )14;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&ar_rec_product_group_code;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&ar_rec_product_line_code;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&ar_rec_subledger_group_code;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&ar_rec_subledger_line_code;
 sqlstm.sqhstl[7] = (unsigned int  )11;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&bl_h_doc_date;
 sqlstm.sqhstl[8] = (unsigned int  )15;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&bl_h_doc_date;
 sqlstm.sqhstl[9] = (unsigned int  )15;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&bl_h_doc_date;
 sqlstm.sqhstl[10] = (unsigned int  )15;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&bl_h_doc_type_code;
 sqlstm.sqhstl[11] = (unsigned int  )9;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&bl_h_doc_num;
 sqlstm.sqhstl[12] = (unsigned int  )11;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&bl_h_episode_type;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&bl_h_patient_id;
 sqlstm.sqhstl[14] = (unsigned int  )23;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&bl_h_episode_id;
 sqlstm.sqhstl[15] = (unsigned int  )11;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&bl_h_visit_id;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&bill_tot_outst_amt;
 sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&d_ws_no;
 sqlstm.sqhstl[18] = (unsigned int  )33;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[19] = (unsigned int  )5;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&d_ws_no;
 sqlstm.sqhstl[20] = (unsigned int  )33;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[21] = (unsigned int  )5;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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

	/* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
			(    operating_facility_id,
				 MAIN_ACC1_CODE,
			     MAIN_ACC2_CODE,
			     DEPT_CODE,
			     PRODUCT_GROUP_CODE,
			     PRODUCT_LINE_CODE,
			     SUBLEDGER_GROUP_CODE,
			     SUBLEDGER_LINE_CODE,
			     POST_YEAR,
			     POST_MONTH,
			     TRX_DATE,
			     TRX_DOC_REF,
			     TRX_DOC_REF_LINE_NUM,
			     TRX_DOC_REF_SEQ_NUM,
			     EPISODE_TYPE,
			     PATIENT_ID,
			     EPISODE_ID,
			     VISIT_ID,
			     NARRATION,
			     TRX_TYPE_CODE,
			     DISTRIBUTION_AMT,
			     GL_INTERFACE_FLAG,
 	  			 ADDED_BY_ID,            
				 MODIFIED_BY_ID,         
				 ADDED_DATE     ,        
				 MODIFIED_DATE   ,       
				ADDED_AT_WS_NO   ,      
				ADDED_FACILITY_ID ,     
				MODIFIED_AT_WS_NO  ,    
				MODIFIED_FACILITY_ID   
			)
		VALUES  ( :nd_facility_id,
				  :bl_rec_main_acc1_code,
			     :bl_rec_main_acc2_code,
			     :bl_rec_dept_code,
			     :bl_rec_product_group_code,
			     :bl_rec_product_line_code,
			     :bl_rec_subledger_group_code,
			     :bl_rec_subledger_line_code,
                 to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'YYYY'),
                 to_char(to_date(:bl_h_doc_date,'DD/MM/YYYY'),'MM'),
   			     TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),
			     RPAD(:bl_h_doc_type_code,6,' ')||'-'||
					LPAD(:bl_h_doc_num,8,'0'),
			     0,
			     0,
			     :bl_h_episode_type,
			     :bl_h_patient_id,
			     :bl_h_episode_id,
			     :bl_h_visit_id,
			     NULL,
			     '1',
			     :bill_tot_outst_amt * -1,
			     'N',
	 	 		 USER,                             /o ADDED BY ID    o/
				 USER,                             /o MODIFIED BY ID o/
				 SYSDATE,					       /o ADDED DATE     o/
				sysdate ,                             /o MODIFIED DATE  o/
				:d_ws_no,
				:nd_facility_id,
				:d_ws_no,
				:nd_facility_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 68;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (operating_facility_id,MAIN_A\
CC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLEDG\
ER_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,TR\
X_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISI\
T_ID,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT,GL_INTERFACE_FLAG,ADDED_BY_ID,MO\
DIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIE\
D_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,to_ch\
ar(to_date(:b8,'DD/MM/YYYY'),'YYYY'),to_char(to_date(:b8,'DD/MM/YYYY'),'MM'),T\
O_DATE(:b8,'DD/MM/YYYY'),((RPAD(:b11,6,' ')||'-')||LPAD(:b12,8,'0')),0,0,:b13,\
:b14,:b15,:b16,null ,'1',(:b17* (-1)),'N',USER,USER,SYSDATE,sysdate,:b18,:b0,:\
b18,:b0)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1272;
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
 sqlstm.sqhstv[1] = (         void  *)&bl_rec_main_acc1_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_rec_main_acc2_code;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_rec_dept_code;
 sqlstm.sqhstl[3] = (unsigned int  )14;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_rec_product_group_code;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_rec_product_line_code;
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
 sqlstm.sqhstv[8] = (         void  *)&bl_h_doc_date;
 sqlstm.sqhstl[8] = (unsigned int  )15;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&bl_h_doc_date;
 sqlstm.sqhstl[9] = (unsigned int  )15;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&bl_h_doc_date;
 sqlstm.sqhstl[10] = (unsigned int  )15;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&bl_h_doc_type_code;
 sqlstm.sqhstl[11] = (unsigned int  )9;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&bl_h_doc_num;
 sqlstm.sqhstl[12] = (unsigned int  )11;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&bl_h_episode_type;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&bl_h_patient_id;
 sqlstm.sqhstl[14] = (unsigned int  )23;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&bl_h_episode_id;
 sqlstm.sqhstl[15] = (unsigned int  )11;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&bl_h_visit_id;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&bill_tot_outst_amt;
 sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&d_ws_no;
 sqlstm.sqhstl[18] = (unsigned int  )33;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[19] = (unsigned int  )5;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&d_ws_no;
 sqlstm.sqhstl[20] = (unsigned int  )33;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[21] = (unsigned int  )5;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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
	err_mesg("INSERT failed on table BL_GL_DISTRIBUTION",0,"");

}

updt_patient_fin_dtls()
{

    /* EXEC SQL UPDATE BL_PATIENT_FIN_DTLS
	  SET    TOT_DEF_PAT_OUTST_AMT = NVL(TOT_DEF_PAT_OUTST_AMT,0) +
					    :bill_tot_outst_amt,
		    TRX_PROCESSED_IND     = 'Y',
      TOT_OUTST_IP_AMT      =  NVL(TOT_OUTST_IP_AMT,0) -
			       DECODE(:bl_h_episode_type,'I',
				      :bill_tot_outst_amt,'D',:bill_tot_outst_amt,0),
      TOT_OUTST_OP_AMT      =  NVL(TOT_OUTST_OP_AMT,0) -
			       DECODE(:bl_h_episode_type,'O',
				      :bill_tot_outst_amt,'E',:bill_tot_outst_amt,0),
      TOT_OUTST_REF_AMT     =  NVL(TOT_OUTST_REF_AMT,0) -
			       DECODE(:bl_h_episode_type,'R',
				      :bill_tot_outst_amt,0)
	     WHERE  PATIENT_ID            = :bl_h_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 68;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_PATIENT_FIN_DTLS  set TOT_DEF_PAT_OUTST_AMT=(NV\
L(TOT_DEF_PAT_OUTST_AMT,0)+:b0),TRX_PROCESSED_IND='Y',TOT_OUTST_IP_AMT=(NVL(TO\
T_OUTST_IP_AMT,0)-DECODE(:b1,'I',:b0,'D',:b0,0)),TOT_OUTST_OP_AMT=(NVL(TOT_OUT\
ST_OP_AMT,0)-DECODE(:b1,'O',:b0,'E',:b0,0)),TOT_OUTST_REF_AMT=(NVL(TOT_OUTST_R\
EF_AMT,0)-DECODE(:b1,'R',:b0,0)) where PATIENT_ID=:b9";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1375;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
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
    sqlstm.sqhstv[5] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&bl_h_patient_id;
    sqlstm.sqhstl[9] = (unsigned int  )23;
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



    if(OERROR || NO_DATA_FOUND)
	err_mesg("UPDATE failed on table BL_PATIENT_FIN_DTLS",0,"");

    if(bl_h_episode_type.arr[0] != 'R') {

      if (bl_h_episode_id.arr[0] != '\0')
	      { if (bl_h_episode_id.arr[0] != '\0')
            {
	/* EXEC SQL UPDATE BL_EPISODE_FIN_DTLS
		 SET    TOT_OUTST_AMT = NVL(TOT_OUTST_AMT,0) - 
					:bill_tot_outst_amt
		 WHERE  operating_facility_id = :nd_facility_id AND
		 EPISODE_TYPE  = :bl_h_episode_type
		 AND    EPISODE_ID    = :bl_h_episode_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 68;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_EPISODE_FIN_DTLS  set TOT_OUTST_AMT=(NVL(TOT_OUTST\
_AMT,0)-:b0) where ((operating_facility_id=:b1 and EPISODE_TYPE=:b2) and EPISO\
DE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1430;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bill_tot_outst_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
 sqlstm.sqhstv[2] = (         void  *)&bl_h_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_h_episode_id;
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


    
	 if(OERROR || NO_DATA_FOUND)
	     err_mesg("UPDATE failed on table BL_EPISODE_FIN_DTLS",0,"");
         }


		}
    }

    if(bl_h_episode_type.arr[0] == 'O' || bl_h_episode_type.arr[0] == 'E'  ) {

		if (bl_h_episode_id.arr[0] != '\0')
		   {

	/* EXEC SQL UPDATE BL_VISIT_FIN_DTLS
		 SET    TOT_OUTST_AMT = NVL(TOT_OUTST_AMT,0) - 
					:bill_tot_outst_amt
		 WHERE  operating_facility_id = :nd_facility_id AND
		 EPISODE_TYPE  = :bl_h_episode_type
		 AND    EPISODE_ID    = :bl_h_episode_id
		 AND    VISIT_ID      = :bl_h_visit_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 68;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_VISIT_FIN_DTLS  set TOT_OUTST_AMT=(NVL(TOT_OUTST_A\
MT,0)-:b0) where (((operating_facility_id=:b1 and EPISODE_TYPE=:b2) and EPISOD\
E_ID=:b3) and VISIT_ID=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1461;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bill_tot_outst_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
 sqlstm.sqhstv[2] = (         void  *)&bl_h_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_h_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_h_visit_id;
 sqlstm.sqhstl[4] = (unsigned int  )7;
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
	     err_mesg("UPDATE failed on table BL_VISIT_FIN_DTLS",0,"");

		 }
    }

   //09/11/2002 As part of system controls and checks amt_transferred 
   //column is introduced
    /* EXEC SQL UPDATE BL_BILL_HDR
	     SET    BILL_TOT_OUTST_AMT       = 0,
		    BILL_HOSP_TOT_OUTST_AMT  = 0,
                    BILL_DRFEE_TOT_OUTST_AMT = 0,
                    BILL_STATUS              = 'D',
                    AR_INV_DOC_TYPE_CODE     = :bl_h_doc_type_code,
                    AR_INV_DOC_NUMBER        = :bl_h_doc_num,
                    AR_INV_DOC_DATE          = TO_DATE(:bl_h_doc_date,'DD/MM/YYYY'),
					AMT_TRANSFERRED			 = :bill_tot_outst_amt
	     WHERE  operating_facility_id = :nd_facility_id AND
		 DOC_TYPE_CODE = :bl_h_doc_type_code
	     AND    DOC_NUM       = :bl_h_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 68;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_BILL_HDR  set BILL_TOT_OUTST_AMT=0,BILL_HOSP_TO\
T_OUTST_AMT=0,BILL_DRFEE_TOT_OUTST_AMT=0,BILL_STATUS='D',AR_INV_DOC_TYPE_CODE=\
:b0,AR_INV_DOC_NUMBER=:b1,AR_INV_DOC_DATE=TO_DATE(:b2,'DD/MM/YYYY'),AMT_TRANSF\
ERRED=:b3 where ((operating_facility_id=:b4 and DOC_TYPE_CODE=:b0) and DOC_NUM\
=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1496;
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
    sqlstm.sqhstv[2] = (         void  *)&bl_h_doc_date;
    sqlstm.sqhstl[2] = (unsigned int  )15;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bill_tot_outst_amt;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_h_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_h_doc_num;
    sqlstm.sqhstl[6] = (unsigned int  )11;
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



    if(OERROR)
	err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");
}

check_boun_exists()
{   

    boun_exists = 0;

    /* EXEC SQL SELECT COUNT(*)
	     INTO   :boun_exists
	     FROM   BL_RECEIPT_REFUND_HDRDTL_VW
	     WHERE  operating_facility_id = :nd_facility_id 
	     AND EPISODE_TYPE = :bl_h_episode_type
	     AND EPISODE_ID   = :bl_h_episode_id
	     AND VISIT_ID     = DECODE(:bl_h_episode_type,'I',VISIT_ID,
	                                 'D',VISIT_ID,
					  :bl_h_visit_id)
	     AND    PATIENT_ID   = :bl_h_patient_id
	     AND    BOUNCED_YN   = 'Y' 
	     AND REPL_CHQ_DOC_TYPE_CODE is null; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 68;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from BL_RECEIPT_REFUND_HDRDTL_\
VW where ((((((operating_facility_id=:b1 and EPISODE_TYPE=:b2) and EPISODE_ID=\
:b3) and VISIT_ID=DECODE(:b2,'I',VISIT_ID,'D',VISIT_ID,:b5)) and PATIENT_ID=:b\
6) and BOUNCED_YN='Y') and REPL_CHQ_DOC_TYPE_CODE is null )";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1539;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&boun_exists;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
    sqlstm.sqhstv[2] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_h_episode_id;
    sqlstm.sqhstl[3] = (unsigned int  )11;
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
    sqlstm.sqhstv[5] = (         void  *)&bl_h_visit_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_h_patient_id;
    sqlstm.sqhstl[6] = (unsigned int  )23;
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



    if(OERROR)
	err_mesg("SELECT failed on table BL_RECEIPT_REFUND_DTL",0,"");

    return boun_exists;

}

get_boun_clr_amt()
{

    d_tot_boun_clr_amt      = 0;
    d_bounced_hosp_charges  = 0;
    d_bounced_drfee_charges = 0;

    /* EXEC SQL SELECT NVL(AFT_DISCH_PREPAY_BOUN_CLR,0) +
		    NVL(AFT_DISCH_DEP_BOUN_CLR,0)    +
		    NVL(AFT_DISCH_PMNT_BOUN_CLR,0),
		    NVL(BOUNCED_HOSP_CHARGES,0),
		    NVL(BOUNCED_DRFEE_CHARGES,0)
	     INTO   :d_tot_boun_clr_amt,
		    :d_bounced_hosp_charges,
		    :d_bounced_drfee_charges
	     FROM   BL_EPISODE_FIN_DTLS
	     WHERE  operating_facility_id = :nd_facility_id 
	     AND EPISODE_TYPE = :bl_h_episode_type
	     AND EPISODE_ID   = :bl_h_episode_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 68;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ((NVL(AFT_DISCH_PREPAY_BOUN_CLR,0)+NVL(AFT_DISCH_D\
EP_BOUN_CLR,0))+NVL(AFT_DISCH_PMNT_BOUN_CLR,0)) ,NVL(BOUNCED_HOSP_CHARGES,0) ,\
NVL(BOUNCED_DRFEE_CHARGES,0) into :b0,:b1,:b2  from BL_EPISODE_FIN_DTLS where \
((operating_facility_id=:b3 and EPISODE_TYPE=:b4) and EPISODE_ID=:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1582;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_tot_boun_clr_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_bounced_hosp_charges;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_bounced_drfee_charges;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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
    sqlstm.sqhstv[4] = (         void  *)&bl_h_episode_type;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_h_episode_id;
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



    if(OERROR)
	err_mesg("SELECT failed on table BL_EPISODE_FIN_DTLS",0,"");

}


/*
check_for_bill_printed()
{

    d_tot_boun_clr_amt      = 0;
    d_bounced_hosp_charges  = 0;
    d_bounced_drfee_charges = 0;

    EXEC SQL SELECT bill_print_flag
	     INTO  :nd_bill_print_flag
	     FROM   bl_bill_hdr
	     WHERE  operating_facility_id = :nd_facility_id 
	     AND EPISODE_TYPE = :bl_h_episode_type
	     AND EPISODE_ID   = :bl_h_episode_id;

    if(OERROR)
	err_mesg("SELECT failed on table BL_EPISODE_FIN_DTLS",0,"");

}
*/
