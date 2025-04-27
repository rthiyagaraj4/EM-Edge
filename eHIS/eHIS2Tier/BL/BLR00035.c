
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
           char  filnam[34];
};
static const struct sqlcxp sqlfpn =
{
    33,
    "D:\\WORKFOLDER\\IN13330\\BLR00035.PC"
};


static unsigned long sqlctx = 1329225101;


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
            void  *sqhstv[8];
   unsigned int   sqhstl[8];
            int   sqhsts[8];
            void  *sqindv[8];
            int   sqinds[8];
   unsigned int   sqharm[8];
   unsigned int   *sqharc[8];
   unsigned short  sqadto[8];
   unsigned short  sqtdso[8];
} sqlstm = {10,8};

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
"select account_code ,cashbk_main_acct_seq  from BL_EXT_ACCT_CODE where cashb\
k_main_acct_seq is  not null  order by 2            ";

 static const char *sq0004 = 
"e(:b0,'dd/mm/yyyy')) and A.CASH_COUNTER_FACILITY_ID=:b1) order by 1         \
   ";

 static const char *sq0005 = 
"select to_char(A.CANCELLED_DATE,'dd/mm/yyyy hh24:mi:ss') ,A.DOC_TYPE_CODE ,A\
.DOC_NUMBER ,(doc_amt* (-1)) ,EXT_ACCT_CODE  from bl_cancelled_bounced_trx a ,\
bl_receipt_refund_dtl_vw b where (((((((((a.doc_type_code=b.doc_type_code and \
a.doc_number=b.doc_number) and b.RECPT_REFUND_IND='R') and NVL(b.cancelled_ind\
,'N')='Y') and NVL(A.cancelled_ind,'N')='Y') and b.CASH_SLMT_FLAG not  in ('A'\
)) and trunc(a.cancelled_date)=to_date(:b0,'dd/mm/yyyy')) and trunc(b.doc_date\
)<to_date(:b0,'dd/mm/yyyy')) and to_char(b.doc_date,'YYYYMM')=to_char(to_date(\
:b0,'dd/mm/yyyy'),'YYYYMM')) and A.CASH_COUNTER_FACILITY_ID=:b3) order by 1   \
         ";

 static const char *sq0006 = 
"select to_char(A.CANCELLED_DATE,'dd/mm/yyyy hh24:mi:ss') ,A.DOC_TYPE_CODE ,A\
.DOC_NUMBER ,(doc_amt* (-1)) ,EXT_ACCT_CODE  from bl_cancelled_bounced_trx a ,\
bl_receipt_refund_dtl_vw b where (((((((((a.doc_type_code=b.doc_type_code and \
a.doc_number=b.doc_number) and b.RECPT_REFUND_IND='R') and NVL(b.cancelled_ind\
,'N')='Y') and NVL(A.cancelled_ind,'N')='Y') and b.CASH_SLMT_FLAG not  in ('A'\
)) and trunc(a.cancelled_date)=to_date(:b0,'dd/mm/yyyy')) and trunc(b.doc_date\
)<to_date(:b0,'dd/mm/yyyy')) and to_char(b.doc_date,'YYYYMM')<to_char(to_date(\
:b0,'dd/mm/yyyy'),'YYYYMM')) and A.CASH_COUNTER_FACILITY_ID=:b3) order by 1   \
         ";

 static const char *sq0008 = 
"select ((((sum(NVL(dd_rcpt_amt,0))+sum(nvl(DD_CANC_RCPT_AMT,0)))+sum(nvl(MM_\
CANC_RCPT_AMT,0)))+sum(nvl(YY_CANC_RCPT_AMT,0)))+sum(nvl(PRV_YY_CANC_RCPT_AMT,\
0))) ,NVL(sum(NVL(DD_PMNT_AMT,0)),0) ,nvl(b.cashbk_main_acct_seq,9)  from bl_s\
ummary_tran_by_acct a ,BL_EXT_ACCT_CODE b where ((((a.ext_acct_code=b.account_\
code and OPERATING_FACILITY_ID=:b0) and trunc(TRX_DATE)<TO_DATE(:b1,'DD/MM/YYY\
Y')) and to_char(trx_date,'YYYYMM')<to_char(to_date(:b1,'DD/MM/YYYY'),'YYYYMM'\
)) and to_char(trx_date,'YYYY')=to_char(to_date(:b1,'dd/mm/yyyy'),'YYYY')) gro\
up by nvl(b.cashbk_main_acct_seq,9) order by 3            ";

 static const char *sq0007 = 
"select NVL(((((sum(NVL(dd_rcpt_amt,0))+sum(nvl(DD_CANC_RCPT_AMT,0)))+sum(nvl\
(MM_CANC_RCPT_AMT,0)))+sum(nvl(YY_CANC_RCPT_AMT,0)))+sum(nvl(PRV_YY_CANC_RCPT_\
AMT,0))),0) ,NVL(sum(NVL(DD_PMNT_AMT,0)),0) ,nvl(b.cashbk_main_acct_seq,9)  fr\
om bl_summary_tran_by_acct a ,BL_EXT_ACCT_CODE b where (((a.ext_acct_code=b.ac\
count_code and OPERATING_FACILITY_ID=:b0) and trunc(TRX_DATE)<TO_DATE(:b1,'DD/\
MM/YYYY')) and to_char(trx_date,'YYYYMM')=to_char(to_date(:b1,'dd/mm/yyyy'),'Y\
YYYMM')) group by nvl(b.cashbk_main_acct_seq,9) order by 3            ";

 static const char *sq0009 = 
"select b.bank_name ,a.bank_in_doc_no ,TRUNC(a.bank_in_date) ,a.slmt_type_cod\
e ,c.receiver_doc_ref_no ,Trunc(c.receiver_doc_ref_date) ,sum(a.doc_amt)  from\
 bl_receipt_refund_dtl_vw a ,bl_bank_name b ,bl_bank_in_doc c where ((((c.oper\
ating_facility_id=:b0 and a.bank_in_doc_no=c.bank_in_doc_no) and c.bank_code=b\
.bank_code) and a.bank_in_doc_no is  not null ) and TRUNC(a.doc_date)=TO_DATE(\
:b1,'dd/mm/yyyy')) group by b.bank_name,a.bank_in_doc_no,TRUNC(a.bank_in_date)\
,a.slmt_type_code,c.receiver_doc_ref_no,Trunc(c.receiver_doc_ref_date)        \
   ";

 static const char *sq0010 = 
"select ext_acct_code ,sum(((((NVL(DD_RCPT_AMT,0)+NVL(DD_CANC_RCPT_AMT,0))+NV\
L(MM_CANC_RCPT_AMT,0))+NVL(YY_CANC_RCPT_AMT,0))+NVL(PRV_YY_CANC_RCPT_AMT,0))) \
daily_rcpt  from bl_summary_tran_by_acct a ,bl_ext_acct_code b ,sy_acc_entity \
c where (((a.trx_date=TO_DATE(:b0,'DD/MM/YYYY') and a.ext_acct_code=b.account_\
code) and b.acc_entity_code=c.acc_entity_code) and b.cashbk_main_acct_seq is n\
ull ) group by ext_acct_code order by 2 desc             ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,208,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,255,0,0,0,0,0,1,0,
51,0,0,11,96,0,4,445,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
74,0,0,12,152,0,6,452,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
101,0,0,3,128,0,9,471,0,0,0,0,0,1,0,
116,0,0,4,1103,0,9,475,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
151,0,0,5,631,0,9,478,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
182,0,0,6,631,0,9,482,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
213,0,0,8,602,0,9,486,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
244,0,0,7,536,0,9,490,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
271,0,0,9,547,0,9,494,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
294,0,0,10,445,0,9,498,0,0,1,1,0,1,0,1,9,0,0,
313,0,0,3,0,0,13,509,0,0,2,0,0,1,0,2,9,0,0,2,3,0,0,
336,0,0,7,0,0,13,527,0,0,3,0,0,1,0,2,4,0,0,2,4,0,0,2,3,0,0,
363,0,0,9,0,0,13,561,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,4,0,0,
406,0,0,13,477,0,4,585,0,0,5,4,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
441,0,0,14,477,0,4,599,0,0,5,4,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
476,0,0,15,136,0,4,619,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
499,0,0,8,0,0,13,659,0,0,3,0,0,1,0,2,4,0,0,2,4,0,0,2,3,0,0,
526,0,0,4,0,0,13,691,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,3,0,0,
573,0,0,5,0,0,13,725,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,2,9,0,0,
608,0,0,6,0,0,13,754,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,2,9,0,0,
643,0,0,10,0,0,13,776,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
666,0,0,16,70,0,4,1125,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
689,0,0,17,174,0,4,1538,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,
728,0,0,18,129,0,6,1563,0,0,1,1,0,1,0,2,3,0,0,
747,0,0,19,141,0,4,1742,0,0,2,1,0,1,0,2,9,0,0,1,3,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00035.PC                                  */
/* AUTHOR                : D. Ganesh Murthi                             */  
/* DATE WRITTEN          : 26/10/2003                                   */      
/************************************************************************/
          
#include <stdio.h>         
#include <string.h> 
#include <bl.h>       
#include <math.h> 

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])

/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hosp_name                       [120],
			date							[20],
            date_time                       [20],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_forthe_date					[20],
			nd_facility				        [3],
			bl_trx_date				        [30],
			bl_downtime_trx_date	[30],
			bl_mn_cancel_trx_date           [30],
			bl_pmn_cancel_trx_date          [30],
			bl_bank_name                    [31],
			bl_doc_type				        [7],
			bl_downtime_doc_type	[7],
			bl_mn_cancel_doc_type           [7],
			bl_pmn_cancel_doc_type          [7],
			bl_acct_code			        [11],
			bl_mn_cancel_acct_code		    [11],
			bl_pmn_cancel_acct_code		    [11],
			bl_year_acct_code		        [11],
			bl_open_acct_code		        [11],

			bl_main_acc_code			       [11],
			
			bl_first_acc_code			       [11],
			bl_second_acc_code			       [11],
			bl_third_acc_code			       [11],
			bl_fourth_acc_code			       [11],
			bl_first_prt_code			       [11],
			bl_second_prt_code			       [11],
			bl_third_prt_code			       [11],
			bl_fourth_prt_code			       [11],
			bl_opbal_acc_code                  [11],

			bl_bank_code                       [7],
			bl_bank_batch_doctype			   [7],
			bl_bank_docdate                    [20],
			bl_bank_in_docno                   [21],
			bl_slmt_typecod                    [3],
			bl_tr_receipt_no		   [21],
			bl_tr_receipt_date		   [20],
			bl_ext_acct_facility_id		   [3],
			bl_ext_acct_dept_code		   [7],
			l_slmt_desc						   [20],
			l_aggr_acc_code					   [15],
			l_currency						   [10],
			l_translated_value				   [201],
			l_cash_book_acc_desc			   [16],
			l_pk_value						   [100]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[20]; } nd_forthe_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[30]; } bl_trx_date;

struct { unsigned short len; unsigned char arr[30]; } bl_downtime_trx_date;

struct { unsigned short len; unsigned char arr[30]; } bl_mn_cancel_trx_date;

struct { unsigned short len; unsigned char arr[30]; } bl_pmn_cancel_trx_date;

struct { unsigned short len; unsigned char arr[31]; } bl_bank_name;

struct { unsigned short len; unsigned char arr[7]; } bl_doc_type;

struct { unsigned short len; unsigned char arr[7]; } bl_downtime_doc_type;

struct { unsigned short len; unsigned char arr[7]; } bl_mn_cancel_doc_type;

struct { unsigned short len; unsigned char arr[7]; } bl_pmn_cancel_doc_type;

struct { unsigned short len; unsigned char arr[11]; } bl_acct_code;

struct { unsigned short len; unsigned char arr[11]; } bl_mn_cancel_acct_code;

struct { unsigned short len; unsigned char arr[11]; } bl_pmn_cancel_acct_code;

struct { unsigned short len; unsigned char arr[11]; } bl_year_acct_code;

struct { unsigned short len; unsigned char arr[11]; } bl_open_acct_code;

struct { unsigned short len; unsigned char arr[11]; } bl_main_acc_code;

struct { unsigned short len; unsigned char arr[11]; } bl_first_acc_code;

struct { unsigned short len; unsigned char arr[11]; } bl_second_acc_code;

struct { unsigned short len; unsigned char arr[11]; } bl_third_acc_code;

struct { unsigned short len; unsigned char arr[11]; } bl_fourth_acc_code;

struct { unsigned short len; unsigned char arr[11]; } bl_first_prt_code;

struct { unsigned short len; unsigned char arr[11]; } bl_second_prt_code;

struct { unsigned short len; unsigned char arr[11]; } bl_third_prt_code;

struct { unsigned short len; unsigned char arr[11]; } bl_fourth_prt_code;

struct { unsigned short len; unsigned char arr[11]; } bl_opbal_acc_code;

struct { unsigned short len; unsigned char arr[7]; } bl_bank_code;

struct { unsigned short len; unsigned char arr[7]; } bl_bank_batch_doctype;

struct { unsigned short len; unsigned char arr[20]; } bl_bank_docdate;

struct { unsigned short len; unsigned char arr[21]; } bl_bank_in_docno;

struct { unsigned short len; unsigned char arr[3]; } bl_slmt_typecod;

struct { unsigned short len; unsigned char arr[21]; } bl_tr_receipt_no;

struct { unsigned short len; unsigned char arr[20]; } bl_tr_receipt_date;

struct { unsigned short len; unsigned char arr[3]; } bl_ext_acct_facility_id;

struct { unsigned short len; unsigned char arr[7]; } bl_ext_acct_dept_code;

struct { unsigned short len; unsigned char arr[20]; } l_slmt_desc;

struct { unsigned short len; unsigned char arr[15]; } l_aggr_acc_code;

struct { unsigned short len; unsigned char arr[10]; } l_currency;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[16]; } l_cash_book_acc_desc;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;


int			bl_acc_seq;
int         bl_main_seq;
int         bl_doc_num, bl_downtime_doc_num;
int         bl_mn_cancel_doc_num; 
int         bl_pmn_cancel_doc_num;
int         nd_lead_spaces;
int			x_count;
int         bl_seq_num;
int         bl_yrcl_seq_num;
int			i,j=0;

int			cancel_rec;
int			pcancel_rec;
int         bank_rec;
int         bl_bank_batch_docno;
int         field_position;

double      bl_doc_amt,
			bl_mn_cancel_doc_amt,
			bl_pmn_cancel_doc_amt,
			bl_yrclose_amount,
			bl_yr_bank_amt,
			bl_yrclose_bankamt,
			bl_dd_rcpt_amt,
			bl_mn_opbal_amt,
			bl_open_amount,
			bl_dd_pmnt_amt,
			bl_dd_tot_pmnt_amt,
			bl_first_opbal,
			bl_second_opbal,
			bl_third_opbal,
			bl_fourth_opbal,
			bl_other_opbal,
			bl_total_opbal,
			bl_day_colln_amt,
			bl_day_colln_amt1,
			bl_day_colln_amt2,
			bl_day_colln_amt3,
			bl_day_colln_amt4,
			bl_day_colln_amt5,
			
			bl_mn_ccolln_amt,
			bl_mn_ccolln_amt1,
			bl_mn_ccolln_amt2,
			bl_mn_ccolln_amt3,
			bl_mn_ccolln_amt4,
			bl_mn_ccolln_amt5,

            bl_pmn_ccolln_amt,
			bl_pmn_ccolln_amt1,
			bl_pmn_ccolln_amt2,
			bl_pmn_ccolln_amt3,
			bl_pmn_ccolln_amt4,
			bl_pmn_ccolln_amt5,

			bl_mnth_colln_amt,
			bl_mnth_colln_amt1,
			bl_mnth_colln_amt2,
			bl_mnth_colln_amt3,
			bl_mnth_colln_amt4,
			bl_mnth_colln_amt5,

			bl_yr_colln_amt,
			bl_yr_colln_amt1,
			bl_yr_colln_amt2,
			bl_yr_colln_amt3,
			bl_yr_colln_amt4,
			bl_yr_colln_amt5,

			bl_bank_total_colln_amt, 
			bl_bank_in_amt,
			bl_mnth_bank_amt,
			bl_yr_bank_amt,

			bl_dd_canc_rcpt_amt,
            bl_mm_canc_rcpt_amt,
            bl_yy_canc_rcpt_amt,
	
			l_page_total  =0,
			l_page_total1 =0,
			l_page_total2 =0,
			l_page_total3 =0,
			l_page_total4 =0,
			l_page_total5 =0,
			
			l_day_accross_total,
			l_month_accross_total,
			l_year_accross_total,
			l_aggr_acc_amt,
			
			l_total_cancellation1,
			l_total_cancellation2,
			l_total_cancellation3,
			l_total_cancellation4,
			l_total_cancellation5,
			l_total_cancellation;

char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];

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

int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLR00035");
    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);

    /* EXEC sql connect :nd_pwd; */ 

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
    sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
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


    set_meduser_role(); 
	  
    if (sqlca.sqlcode < 0 )
	{
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
        }

    	strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    	d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    	strcpy(nd_session_id.arr,argv[2]);
    	nd_session_id.len = strlen(nd_session_id.arr);
    	strcpy(g_session_id,nd_session_id.arr);

    	strcpy(nd_pgm_date.arr,argv[3]);
    	nd_pgm_date.len = strlen(nd_pgm_date.arr);
    	strcpy(g_pgm_date,nd_pgm_date.arr);

    	strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);

    	strcpy(nd_forthe_date.arr,argv[5]);
    	nd_forthe_date.len = strlen(nd_forthe_date.arr);

    //	start_prog_msg();

    	declare_cur();

    	fetch_hosp_name();

    	open_file();
     
    	fetch_legend_value();
		
		open_hdr();

		main_acct_select();
        
	    print_rec();

	    end_of_rep();

    //	end_prog_msg();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

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
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}

declare_cur()
{
     /* EXEC SQL DECLARE BL_EXT_ACCT_CODE_CUR CURSOR FOR 
		      select  account_code,
			          cashbk_main_acct_seq
			  from 	BL_EXT_ACCT_CODE
			  where  cashbk_main_acct_seq is not null
			  order by 2; */ 


     /* EXEC SQL DECLARE DTL_RECEIPT_CUR CURSOR FOR 
		      select to_char(doc_date,'dd/mm/yyyy hh24:mi:ss') DOCDATE, doc_type_code DOCTYPE, 
					 doc_number DOC_NO, 
					 doc_amt AMOUNT,  EXT_ACCT_CODE ACCT_CODE,
					 to_char(DOWNTIME_DOC_DATE,'dd/mm/yyyy hh24:mi:ss'),      
					 DOWNTIME_DOC_TYPE_CODE, 
					 DOWNTIME_DOC_NUMBER    
		      from   bl_receipt_refund_dtl_VW
		      where  TRUNC(doc_date)   =  to_date(:nd_forthe_date,'dd/mm/yyyy') 
			  and    RECPT_REFUND_IND  = 'R'
			  and    CASH_SLMT_FLAG  not in ('A')  
              and    CASH_COUNTER_FACILITY_ID = :nd_facility
              union  ALL
		      select to_char(A.CANCELLED_DATE,'dd/mm/yyyy hh24:mi:ss') DOCDATE, A.DOC_TYPE_CODE ,
					 A.DOC_NUMBER DOC_NO ,
					 (doc_amt * -1) AMOUNT , EXT_ACCT_CODE  ACC_CODE,
					 to_char(DOWNTIME_DOC_DATE,'dd/mm/yyyy hh24:mi:ss'),      
					 DOWNTIME_DOC_TYPE_CODE, 
					 DOWNTIME_DOC_NUMBER    
		      from bl_cancelled_bounced_trx a, bl_receipt_refund_dtl_VW b
		      where a.doc_type_code = b.doc_type_code
		      and  a.doc_number = b.doc_number
			  and  b.RECPT_REFUND_IND       = 'R'
			  and  NVL(b.cancelled_ind,'N') = 'Y'       
		      and  NVL(A.cancelled_ind,'N') = 'Y' 
			  and  b.CASH_SLMT_FLAG  not in ('A')  
	          and  trunc(a.cancelled_date) = to_date(:nd_forthe_date,'dd/mm/yyyy')
			  and  trunc(b.doc_date) = to_date(:nd_forthe_date,'dd/mm/yyyy')
              and  A.CASH_COUNTER_FACILITY_ID = :nd_facility
			  order by 1; */ 


     /* EXEC SQL DECLARE  bl_month_cancel_detail cursor for
			  select  to_char(A.CANCELLED_DATE,'dd/mm/yyyy hh24:mi:ss'), A.DOC_TYPE_CODE ,
					  A.DOC_NUMBER ,
					  (doc_amt * -1), EXT_ACCT_CODE  
		      from bl_cancelled_bounced_trx a, bl_receipt_refund_dtl_vw b
		      where a.doc_type_code = b.doc_type_code
		      and  a.doc_number = b.doc_number
			  and  b.RECPT_REFUND_IND       = 'R'
		      and  NVL(b.cancelled_ind,'N') = 'Y'     
		      and  NVL(A.cancelled_ind,'N') = 'Y' 
			  and  b.CASH_SLMT_FLAG  not in ('A')  
	          and  trunc(a.cancelled_date) = to_date(:nd_forthe_date,'dd/mm/yyyy')
			  and  trunc(b.doc_date) < to_date(:nd_forthe_date,'dd/mm/yyyy')
			  and  to_char(b.doc_date,'YYYYMM') = to_char(to_date(:nd_forthe_date,'dd/mm/yyyy'),'YYYYMM')
              and  A.CASH_COUNTER_FACILITY_ID = :nd_facility
			  order by 1; */ 


     /* EXEC SQL DECLARE  bl_prev_month_cancel_detail cursor for
			    select  to_char(A.CANCELLED_DATE,'dd/mm/yyyy hh24:mi:ss'), A.DOC_TYPE_CODE ,
						A.DOC_NUMBER ,
						(doc_amt * -1), EXT_ACCT_CODE  
				from bl_cancelled_bounced_trx a, bl_receipt_refund_dtl_vw b
				where a.doc_type_code = b.doc_type_code
				and  a.doc_number = b.doc_number
				and  b.RECPT_REFUND_IND       = 'R'
				and  NVL(b.cancelled_ind,'N') = 'Y'     
				and  NVL(A.cancelled_ind,'N') = 'Y' 
				and  b.CASH_SLMT_FLAG  not in ('A')  
	            and  trunc(a.cancelled_date) = to_date(:nd_forthe_date,'dd/mm/yyyy')
				and  trunc(b.doc_date) < to_date(:nd_forthe_date,'dd/mm/yyyy')
				and  to_char(b.doc_date,'YYYYMM') < to_char(to_date(:nd_forthe_date,'dd/mm/yyyy'),'YYYYMM')
                and  A.CASH_COUNTER_FACILITY_ID = :nd_facility
				order by 1; */ 


	/* EXEC SQL DECLARE bl_open_balance 
	          cursor 
			     for
	          select NVL((sum(NVL(dd_rcpt_amt,0)) + sum(nvl(DD_CANC_RCPT_AMT,0)) + sum(nvl(MM_CANC_RCPT_AMT,0)) + sum(nvl(YY_CANC_RCPT_AMT,0)) + sum(nvl(PRV_YY_CANC_RCPT_AMT,0))),0) ,
			         NVL(SUM(NVL(DD_PMNT_AMT,0)),0),
			         nvl(b.cashbk_main_acct_seq,9)
			    from bl_summary_tran_by_acct a, 
					 BL_EXT_ACCT_CODE  b
			   where a.ext_acct_code       = b.account_code
			     and OPERATING_FACILITY_ID =:nd_facility
			     AND trunc(TRX_DATE)       < TO_DATE(:nd_forthe_date,'DD/MM/YYYY')
                 and to_char(trx_date,'YYYYMM') = to_char(to_date(:nd_forthe_date,'dd/mm/yyyy'),'YYYYMM') 
               group 
			      by nvl(b.cashbk_main_acct_seq,9)
			   order 
			      by 3; */ 



	/* EXEC SQL DECLARE bl_year_clos_balance cursor for
	         select sum(NVL(dd_rcpt_amt,0)) + sum(nvl(DD_CANC_RCPT_AMT,0)) + sum(nvl(MM_CANC_RCPT_AMT,0)) + sum(nvl(YY_CANC_RCPT_AMT,0)) + sum(nvl(PRV_YY_CANC_RCPT_AMT,0)) ,
					NVL(SUM(NVL(DD_PMNT_AMT,0)),0),
			        nvl(b.cashbk_main_acct_seq,9)
			 from bl_summary_tran_by_acct a, BL_EXT_ACCT_CODE  b
			 where  a.ext_acct_code = b.account_code
			 and OPERATING_FACILITY_ID =:nd_facility
			 AND trunc(TRX_DATE) < TO_DATE(:nd_forthe_date,'DD/MM/YYYY')
			 AND to_char(trx_date,'YYYYMM') < to_char(to_date(:nd_forthe_date,'DD/MM/YYYY'),'YYYYMM')
             and to_char(trx_date,'YYYY') = to_char(to_date(:nd_forthe_date,'dd/mm/yyyy'),'YYYY') 
            // AND EXT_ACCT_FACILITY_ID = :nd_facility
			 group by nvl(b.cashbk_main_acct_seq,9)
			 order by 3; */ 


    /*EXEC SQL DECLARE bl_bank_in_dtls cursor for
			 select BANK_NAME, BANK_IN_DOC_NO,
					BANK_IN_DATE,
					SLMT_TYPE_CODE,
					BANK_IN_AMT
			 from   BL_BANK_IN_DOC A, BL_BANK_NAME B
			 where  a.BANK_CODE  =  b.BANK_CODE
			 and    trunc(BANK_IN_DATE) = to_date(:nd_forthe_date,'dd/mm/yyyy')
			 order by 1,2;*/


    //The receipt refund table which was accessed is changed to view.
	/* EXEC SQL DECLARE bl_bank_in_dtls 
	          CURSOR 
			     FOR
			  SELECT b.bank_name,
					 a.bank_in_doc_no,
					 TRUNC(a.bank_in_date),
					 a.slmt_type_code,
					 c.receiver_doc_ref_no,
					 Trunc(c.receiver_doc_ref_date),
					 SUM(a.doc_amt)
				FROM bl_receipt_refund_dtl_vw a,   
					 bl_bank_name b,
					 bl_bank_in_doc c
			   WHERE c.operating_facility_id = :nd_facility
			     AND a.bank_in_doc_no        = c.bank_in_doc_no
			     AND c.bank_code             = b.bank_code
			     AND a.bank_in_doc_no IS NOT NULL
			     AND TRUNC(a.doc_date) = TO_DATE(:nd_forthe_date,'dd/mm/yyyy')
			   GROUP 
			      BY b.bank_name,
					 a.bank_in_doc_no,
					 TRUNC(a.bank_in_date),
					 a.slmt_type_code,
					 c.receiver_doc_ref_no,
					 Trunc(c.receiver_doc_ref_date); */ 


	/*EXEC SQL DECLARE account_aggregate
			  CURSOR 
                 FOR
			  SELECT ext_acct_code, 
					 SUM(NVL(doc_amt,0))
				FROM bl_receipt_refund_dtl
			   WHERE TRUNC(doc_date)   =  TO_DATE(:nd_forthe_date,'DD/MM/YYYY')
				 AND recpt_refund_ind  = 'R'
				 AND cash_slmt_flag  NOT IN ('A')
				 AND cash_counter_facility_id = :nd_facility
			   GROUP 
			      BY ext_acct_code;
	
	This is commented and the below equivalent is used.
	*/

	/* EXEC SQL DECLARE account_aggregate
			  CURSOR 
                 FOR
			  SELECT ext_acct_code,
			 		 SUM(NVL(DD_RCPT_AMT,0)+NVL(DD_CANC_RCPT_AMT,0)+NVL(MM_CANC_RCPT_AMT,0)
					 +NVL(YY_CANC_RCPT_AMT,0)+NVL(PRV_YY_CANC_RCPT_AMT,0))  daily_rcpt
			    FROM bl_summary_tran_by_acct a, 
			         bl_ext_acct_code b, 
				 	 sy_acc_entity c
			   WHERE a.trx_date        = TO_DATE(:nd_forthe_date,'DD/MM/YYYY')
			     AND a.ext_acct_code   = b.account_code
			     AND b.acc_entity_code = c.acc_entity_code
				 AND b.cashbk_main_acct_seq IS NULL
			   GROUP
			      BY ext_acct_code
		       ORDER
			      BY 2 DESC; */ 
		  
}

fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00035.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00035.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )51;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&i;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_pk_value;
  sqlstm.sqhstl[1] = (unsigned int  )102;
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



		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_translated_value.arr[0]		= '\0';

		/* EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:nd_facility,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										  NULL);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 NULL ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )74;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_pk_value;
  sqlstm.sqhstl[1] = (unsigned int  )102;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[2] = (unsigned int  )203;
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



		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}

open_hdr() 
{
    /* EXEC SQL OPEN BL_EXT_ACCT_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0003;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )101;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_EXT_ACCT_CODE_CUR",0,"");

    /* EXEC SQL OPEN DTL_RECEIPT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select to_char(doc_date,'dd/mm/yyyy hh24:mi:ss') DOCDATE ,doc_type_co\
de DOCTYPE ,doc_number DOC_NO ,doc_amt AMOUNT ,EXT_ACCT_CODE ACCT_CODE ,to_c\
har(DOWNTIME_DOC_DATE,'dd/mm/yyyy hh24:mi:ss') ,DOWNTIME_DOC_TYPE_CODE ,DOWN\
TIME_DOC_NUMBER  from bl_receipt_refund_dtl_VW where (((TRUNC(doc_date)=to_d\
ate(:b0,'dd/mm/yyyy') and RECPT_REFUND_IND='R') and CASH_SLMT_FLAG not  in (\
'A')) and CASH_COUNTER_FACILITY_ID=:b1) union all select to_char(A.CANCELLED\
_DATE,'dd/mm/yyyy hh24:mi:ss') DOCDATE ,A.DOC_TYPE_CODE ,A.DOC_NUMBER DOC_NO\
 ,(doc_amt* (-1)) AMOUNT ,EXT_ACCT_CODE ACC_CODE ,to_char(DOWNTIME_DOC_DATE,\
'dd/mm/yyyy hh24:mi:ss') ,DOWNTIME_DOC_TYPE_CODE ,DOWNTIME_DOC_NUMBER  from \
bl_cancelled_bounced_trx a ,bl_receipt_refund_dtl_VW b where ((((((((a.doc_t\
ype_code=b.doc_type_code and a.doc_number=b.doc_number) and b.RECPT_REFUND_I\
ND='R') and NVL(b.cancelled_ind,'N')='Y') and NVL(A.cancelled_ind,'N')='Y') \
and b.CASH_SLMT_FLAG not  in ('A')) and trunc(a.cancelled_date)=to_date(:b0,\
'dd/mm/yyyy')) and trunc(b.doc_date)=to_dat");
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )116;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[0] = (unsigned int  )22;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_facility;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[3] = (unsigned int  )22;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_facility;
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
         err_mesg("OPEN failed on cursor DTL_RECEIPT_CUR",0,"");
    /* EXEC SQL OPEN bl_month_cancel_detail; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )151;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[0] = (unsigned int  )22;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_facility;
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
         err_mesg("OPEN failed on cursor bl_month_cancel_detail",0,"");

    /* EXEC SQL OPEN bl_prev_month_cancel_detail; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )182;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[0] = (unsigned int  )22;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_facility;
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
         err_mesg("OPEN failed on cursor bl_prev_month_cancel_detail",0,"");
	
	/* EXEC SQL OPEN bl_year_clos_balance; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )213;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_forthe_date;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_forthe_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_forthe_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
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
         err_mesg("OPEN failed on cursor bl_year_clos_balance",0,"");

	/* EXEC SQL OPEN bl_open_balance; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )244;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_forthe_date;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_forthe_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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
         err_mesg("OPEN failed on cursor bl_open_balance",0,"");

	/* EXEC SQL OPEN bl_bank_in_dtls; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )271;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_forthe_date;
 sqlstm.sqhstl[1] = (unsigned int  )22;
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
         err_mesg("OPEN failed on cursor bl_bank_in_dtls cursor",0,"");

	/* EXEC SQL OPEN account_aggregate; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0010;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )294;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_forthe_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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
         err_mesg("OPEN failed on cursor account_aggregate cursor",0,"");	 
}

fetch_main_acc()
{
   bl_main_acc_code.arr[0] = '\0';
   bl_main_acc_code.len = 0;
  

      /* EXEC SQL FETCH BL_EXT_ACCT_CODE_CUR
               INTO :bl_main_acc_code,
			:bl_main_seq; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )313;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_main_acc_code;
      sqlstm.sqhstl[0] = (unsigned int  )13;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_main_seq;
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
            err_mesg("FETCH failed on cursor BL_EXT_ACCT_CODE_CUR",0,"");

   bl_main_acc_code.arr[bl_main_acc_code.len] = '\0';

   return(LAST_ROW?0:1);
}

fetch_open_bal()
{
   bl_open_amount = 0;
   bl_seq_num  = 0;
   bl_dd_pmnt_amt = 0;

      /* EXEC SQL FETCH bl_open_balance
               INTO :bl_open_amount,
					:bl_dd_pmnt_amt,
					:bl_seq_num; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )336;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_open_amount;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_dd_pmnt_amt;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_seq_num;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
            err_mesg("FETCH failed on cursor bl_open_balance",0,"");


   return(LAST_ROW?0:1);
}

fetch_bank_in_dtls()
{
		bl_bank_name.arr[0]  = '\0';
		bl_bank_batch_doctype.arr[0]  = '\0';
		bl_bank_docdate.arr[0]  = '\0';
		bl_bank_in_docno.arr[0]  = '\0';
		bl_slmt_typecod.arr[0]  = '\0';

		bl_bank_name.len = 0;
		bl_bank_batch_doctype.len = 0;
		bl_bank_docdate.len = 0;
		bl_bank_in_docno.len = 0;
		bl_slmt_typecod.len = 0;

		bl_bank_batch_docno = 0;
		bl_bank_in_amt = 0;

		bl_tr_receipt_no.arr[0] = '\0';
		bl_tr_receipt_no.len = 0;

		bl_tr_receipt_date.arr[0] = '\0';
		bl_tr_receipt_date.len = 0;
	
	      /* EXEC SQL FETCH bl_bank_in_dtls
               INTO :bl_bank_name,
		    :bl_bank_in_docno,
		    :bl_bank_docdate,
		    :bl_slmt_typecod,
		    :bl_tr_receipt_no,
		    :bl_tr_receipt_date,
		    :bl_bank_in_amt; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 7;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )363;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&bl_bank_name;
       sqlstm.sqhstl[0] = (unsigned int  )33;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&bl_bank_in_docno;
       sqlstm.sqhstl[1] = (unsigned int  )23;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&bl_bank_docdate;
       sqlstm.sqhstl[2] = (unsigned int  )22;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&bl_slmt_typecod;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&bl_tr_receipt_no;
       sqlstm.sqhstl[4] = (unsigned int  )23;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&bl_tr_receipt_date;
       sqlstm.sqhstl[5] = (unsigned int  )22;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&bl_bank_in_amt;
       sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
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
            err_mesg("FETCH failed on cursor bl_bank_in_dtls",0,"");

		bl_bank_name.arr[bl_bank_name.len]  = '\0';
		bl_bank_batch_doctype.arr[bl_bank_batch_doctype.len]  = '\0';
		bl_bank_docdate.arr[bl_bank_docdate.len]  = '\0';
		bl_bank_in_docno.arr[bl_bank_in_docno.len]  = '\0';
		bl_slmt_typecod.arr[bl_slmt_typecod.len]  = '\0';
		bl_tr_receipt_no.arr[bl_tr_receipt_no.len] = '\0';
		bl_tr_receipt_date.arr[bl_tr_receipt_date.len] = '\0';

		return(LAST_ROW?0:1);
}

rec_count_check()
{
			/* EXEC SQL  
			  select  count(*)
			  into    :cancel_rec
		      from bl_cancelled_bounced_trx a, bl_receipt_refund_dtl_vw b
		      where a.doc_type_code = b.doc_type_code
		      and  a.doc_number = b.doc_number
			  and  b.RECPT_REFUND_IND  = 'R'
		      and  NVL(b.cancelled_ind,'N') = 'Y'     
		      and  NVL(A.cancelled_ind,'N') = 'Y' 
	          and  trunc(a.cancelled_date) = to_date(:nd_forthe_date,'dd/mm/yyyy')
			  and  trunc(b.doc_date) < to_date(:nd_forthe_date,'dd/mm/yyyy')
			  and  to_char(b.doc_date,'YYYYMM') = to_char(to_date(:nd_forthe_date,'dd/mm/yyyy'),'YYYYMM')
              and  A.CASH_COUNTER_FACILITY_ID = :nd_facility; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select count(*)  into :b0  from bl_cancelled_bounced_trx a\
 ,bl_receipt_refund_dtl_vw b where ((((((((a.doc_type_code=b.doc_type_code and\
 a.doc_number=b.doc_number) and b.RECPT_REFUND_IND='R') and NVL(b.cancelled_in\
d,'N')='Y') and NVL(A.cancelled_ind,'N')='Y') and trunc(a.cancelled_date)=to_d\
ate(:b1,'dd/mm/yyyy')) and trunc(b.doc_date)<to_date(:b1,'dd/mm/yyyy')) and to\
_char(b.doc_date,'YYYYMM')=to_char(to_date(:b1,'dd/mm/yyyy'),'YYYYMM')) and A.\
CASH_COUNTER_FACILITY_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )406;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&cancel_rec;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_forthe_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_forthe_date;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_forthe_date;
   sqlstm.sqhstl[3] = (unsigned int  )22;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_facility;
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



			/* EXEC SQL  
			  select  count(*)   
			  into    :pcancel_rec
		      from bl_cancelled_bounced_trx a, bl_receipt_refund_dtl_vw b
		      where a.doc_type_code = b.doc_type_code
		      and  a.doc_number = b.doc_number
			  and  b.RECPT_REFUND_IND  = 'R'
		      and  NVL(b.cancelled_ind,'N') = 'Y'     
		      and  NVL(A.cancelled_ind,'N') = 'Y' 
	          and  trunc(a.cancelled_date) = to_date(:nd_forthe_date,'dd/mm/yyyy')
			  and  trunc(b.doc_date) < to_date(:nd_forthe_date,'dd/mm/yyyy')
			  and  to_char(b.doc_date,'YYYYMM') < to_char(to_date(:nd_forthe_date,'dd/mm/yyyy'),'YYYYMM')
              and  A.CASH_COUNTER_FACILITY_ID = :nd_facility; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select count(*)  into :b0  from bl_cancelled_bounced_trx a\
 ,bl_receipt_refund_dtl_vw b where ((((((((a.doc_type_code=b.doc_type_code and\
 a.doc_number=b.doc_number) and b.RECPT_REFUND_IND='R') and NVL(b.cancelled_in\
d,'N')='Y') and NVL(A.cancelled_ind,'N')='Y') and trunc(a.cancelled_date)=to_d\
ate(:b1,'dd/mm/yyyy')) and trunc(b.doc_date)<to_date(:b1,'dd/mm/yyyy')) and to\
_char(b.doc_date,'YYYYMM')<to_char(to_date(:b1,'dd/mm/yyyy'),'YYYYMM')) and A.\
CASH_COUNTER_FACILITY_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )441;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&pcancel_rec;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_forthe_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_forthe_date;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_forthe_date;
   sqlstm.sqhstl[3] = (unsigned int  )22;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_facility;
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



			/*EXEC SQL  
			 select count(*)
			 into   :bank_rec
			 from   BL_BANK_IN_DOC
			 where trunc(BANK_IN_DATE) = to_date(:nd_forthe_date,'dd/mm/yyyy');*/

			 /* EXEC SQL  
			 select count(*)
			 into   :bank_rec
			 from   bl_receipt_refund_Dtl
		   WHERE bank_in_doc_no IS NOT NULL
			 AND TRUNC(doc_date) = TO_DATE(:nd_forthe_date,'dd/mm/yyyy'); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from bl_receipt_refund_Dtl whe\
re (bank_in_doc_no is  not null  and TRUNC(doc_date)=TO_DATE(:b1,'dd/mm/yyyy')\
)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )476;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bank_rec;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_forthe_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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


}	

main_acct_select()
{
   while(fetch_main_acc())
   {
	 if (bl_main_seq == 1) 
		strcpy(bl_first_acc_code.arr,bl_main_acc_code.arr);
	 else if (bl_main_seq == 2) 
		strcpy(bl_second_acc_code.arr,bl_main_acc_code.arr);
	 else if (bl_main_seq == 3) 
		strcpy(bl_third_acc_code.arr,bl_main_acc_code.arr);
	 else
		strcpy(bl_fourth_acc_code.arr,bl_main_acc_code.arr);
   }

   print_head();

	bl_yrclose_bankamt = 0;
	bl_yr_colln_amt    = 0;
	bl_yr_bank_amt     = 0;
	//bl_yr_bank_amt   = bl_yrclose_bankamt;
	bl_yr_colln_amt1 = 0;
	bl_yr_colln_amt2 = 0;
	bl_yr_colln_amt3 = 0;
	bl_yr_colln_amt4 = 0;
	bl_yr_colln_amt5 = 0;
}

fetch_year_close_bal()
{
	bl_yrclose_amount = 0;
   	bl_yrcl_seq_num  = 0;

      /* EXEC SQL FETCH bl_year_clos_balance
                INTO :bl_yrclose_amount,
					 :bl_yrclose_bankamt,
					 :bl_yrcl_seq_num; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 7;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )499;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_yrclose_amount;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_yrclose_bankamt;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_yrcl_seq_num;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
            err_mesg("FETCH failed on cursor bl_open_balance",0,"");


   return(LAST_ROW?0:1);
}

fetch_hdr()
{
bl_trx_date.arr[0]   = '\0';

bl_downtime_trx_date.arr[0] = '\0';
bl_downtime_trx_date.len = 0;

bl_doc_type.arr[0]   = '\0';

bl_downtime_doc_type.arr[0] = '\0';
bl_downtime_doc_type.len = 0;

bl_doc_type.len      = 0;
bl_trx_date.len   = 0;
bl_acct_code.arr[0]  = '\0';
bl_acct_code.len     = 0;

bl_doc_num	     = 0;
bl_doc_amt           = 0;

      /* EXEC SQL FETCH DTL_RECEIPT_CUR
               INTO :bl_trx_date,
					:bl_doc_type,
					:bl_doc_num ,
					:bl_doc_amt,
					:bl_acct_code,
					:bl_downtime_trx_date,
					:bl_downtime_doc_type,
					:bl_downtime_doc_num; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )526;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_trx_date;
      sqlstm.sqhstl[0] = (unsigned int  )32;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_doc_type;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_doc_amt;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_acct_code;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_downtime_trx_date;
      sqlstm.sqhstl[5] = (unsigned int  )32;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_downtime_doc_type;
      sqlstm.sqhstl[6] = (unsigned int  )9;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bl_downtime_doc_num;
      sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
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
            err_mesg("FETCH failed on cursor DTL_RECEIPT_CUR",0,"");

bl_trx_date.arr[bl_trx_date.len]              = '\0';
bl_doc_type.arr[bl_doc_type.len]              = '\0';
bl_acct_code.arr[bl_acct_code.len]            = '\0';
bl_downtime_trx_date.arr[bl_downtime_trx_date.len] = '\0';
bl_downtime_doc_type.arr[bl_downtime_doc_type.len] = '\0';


    return(LAST_ROW?0:1);
}

fetch_prev_cancel()
{
	bl_mn_cancel_trx_date.arr[0]   = '\0';
	bl_mn_cancel_doc_type.arr[0]   = '\0';
	bl_mn_cancel_doc_type.len      = 0;
	bl_mn_cancel_trx_date.len   = 0;
	bl_mn_cancel_acct_code.arr[0]  = '\0';
	bl_mn_cancel_acct_code.len     = 0;

	bl_mn_cancel_doc_num = 0;
	bl_mn_cancel_doc_amt           = 0;

      /* EXEC SQL FETCH bl_month_cancel_detail
               INTO :bl_mn_cancel_trx_date,
					:bl_mn_cancel_doc_type,
					:bl_mn_cancel_doc_num ,
					:bl_mn_cancel_doc_amt,
					:bl_mn_cancel_acct_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )573;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_mn_cancel_trx_date;
      sqlstm.sqhstl[0] = (unsigned int  )32;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_mn_cancel_doc_type;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_mn_cancel_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_mn_cancel_doc_amt;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_mn_cancel_acct_code;
      sqlstm.sqhstl[4] = (unsigned int  )13;
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
            err_mesg("FETCH failed on cursor bl_month_cancel_detail",0,"");

	bl_mn_cancel_trx_date.arr[bl_mn_cancel_trx_date.len]  = '\0';
	bl_mn_cancel_doc_type.arr[bl_mn_cancel_doc_type.len]              = '\0';
	bl_mn_cancel_acct_code.arr[bl_mn_cancel_acct_code.len]            = '\0';

    return(LAST_ROW?0:1);
}

fetch_prv_month_cancel()
{

	bl_pmn_cancel_trx_date.arr[0]   = '\0';
	bl_pmn_cancel_doc_type.arr[0]   = '\0';
	bl_pmn_cancel_doc_type.len      = 0;
	bl_pmn_cancel_trx_date.len   = 0;
	bl_pmn_cancel_acct_code.arr[0]  = '\0';
	bl_pmn_cancel_acct_code.len     = 0;

	bl_pmn_cancel_doc_num = 0;
	bl_pmn_cancel_doc_amt           = 0;

      /* EXEC SQL FETCH bl_prev_month_cancel_detail
               INTO :bl_pmn_cancel_trx_date,
					:bl_pmn_cancel_doc_type,
					:bl_pmn_cancel_doc_num ,
					:bl_pmn_cancel_doc_amt,
					:bl_pmn_cancel_acct_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )608;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_pmn_cancel_trx_date;
      sqlstm.sqhstl[0] = (unsigned int  )32;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_pmn_cancel_doc_type;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_pmn_cancel_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_pmn_cancel_doc_amt;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_pmn_cancel_acct_code;
      sqlstm.sqhstl[4] = (unsigned int  )13;
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
            err_mesg("FETCH failed on cursor bl_prev_month_cancel_detail",0,"");


	bl_pmn_cancel_trx_date.arr[bl_pmn_cancel_trx_date.len]  = '\0';
	bl_pmn_cancel_doc_type.arr[bl_pmn_cancel_doc_type.len]              = '\0';
	bl_pmn_cancel_acct_code.arr[bl_pmn_cancel_acct_code.len]            = '\0';

    return(LAST_ROW?0:1);
}


fetch_account_aggregate()
{
	l_aggr_acc_code.arr[0] = '\0';

	/* EXEC SQL FETCH account_aggregate
	          INTO 	:l_aggr_acc_code,
					:l_aggr_acc_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )643;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_aggr_acc_code;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_aggr_acc_amt;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
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
        err_mesg("FETCH failed on CURSOR account_aggregate",0,"");

	l_aggr_acc_code.arr[l_aggr_acc_code.len] = '\0';

	return(LAST_ROW?0:1);
}
print_rec()
{

	year_balance();

	print_open_balance();

	rec_count_check();

    print_day_details();

    print_bank_in_dtls();

	print_cancel_details();

	print_prev_cancel_details();

	print_column_total();

	print_month_total();      

    print_year_total();

	print_account_aggregate();
}  

year_balance()
{
  char l_msg[200];
 
	while (fetch_year_close_bal())
	{
		if (bl_yrcl_seq_num == 1)
			bl_yr_colln_amt1 = bl_yrclose_amount;

		else if (bl_yrcl_seq_num == 2)
			bl_yr_colln_amt2 = bl_yrclose_amount;

		else if (bl_yrcl_seq_num == 3)
			bl_yr_colln_amt3 = bl_yrclose_amount;

		else if (bl_yrcl_seq_num == 4)
			bl_yr_colln_amt4 = bl_yrclose_amount;

		else
			bl_yr_colln_amt5 = bl_yrclose_amount;

		bl_yr_colln_amt += bl_yrclose_amount;

		bl_yr_bank_amt += bl_yrclose_bankamt;
	}
}

print_prev_cancel_details()
{
	if (pcancel_rec > 0 )
	{
		check_page_end(3,0);
		fprintf(fp,"\nLess: Previous month(s) Cancellations\n\n");
		lctr+=3;

		while(fetch_prv_month_cancel())
		{
			check_page_end(1,0);
			fprintf(fp,"%-20.20s %-6s / %-8d ",
				        bl_pmn_cancel_trx_date.arr, 
						bl_pmn_cancel_doc_type.arr, 
						bl_pmn_cancel_doc_num);
			print_formated(bl_pmn_cancel_doc_amt);
			bl_pmn_ccolln_amt += bl_pmn_cancel_doc_amt;
		
			fprintf(fp,"%17s"," ");

			if (strcmp(bl_pmn_cancel_acct_code.arr,bl_first_acc_code.arr) == 0)
			{
				print_formated(bl_pmn_cancel_doc_amt);
				bl_pmn_ccolln_amt1 += bl_pmn_cancel_doc_amt;
			}
			else if(strcmp(bl_pmn_cancel_acct_code.arr,bl_second_acc_code.arr) == 0)
			{  
				calc_space(2);
				print_formated(bl_pmn_cancel_doc_amt);
				bl_pmn_ccolln_amt2 += bl_pmn_cancel_doc_amt;
			}
			else if (strcmp(bl_pmn_cancel_acct_code.arr,bl_third_acc_code.arr) == 0)
			{  
				calc_space(3);
                print_formated(bl_pmn_cancel_doc_amt);
				bl_pmn_ccolln_amt3 += bl_pmn_cancel_doc_amt;
			}
			else if (strcmp(bl_pmn_cancel_acct_code.arr,bl_fourth_acc_code.arr) == 0)
            {   
				calc_space(4);
			    print_formated(bl_pmn_cancel_doc_amt);
				bl_pmn_ccolln_amt4 += bl_pmn_cancel_doc_amt;
			}
			else 
			{
				calc_space(5);
				print_formated(bl_pmn_cancel_doc_amt);
                fprintf(fp, " %7s ", bl_pmn_cancel_acct_code.arr);
				bl_pmn_ccolln_amt5 += bl_pmn_cancel_doc_amt;
			}
			fprintf(fp,"\n");
 			lctr++;
			check_page_end(1,0);
		}
		print_prev_mnth_cancel_total();      
	}
}

print_open_balance()
{
    bl_total_opbal = 0;
	bl_dd_pmnt_amt = 0;

	while (fetch_open_bal())
	{
		if (bl_seq_num == 1)
			bl_first_opbal = bl_open_amount;
		else if (bl_seq_num == 2)
			bl_second_opbal = bl_open_amount;
		else if (bl_seq_num == 3)
			bl_third_opbal = bl_open_amount;
		else if (bl_seq_num == 4)
			bl_fourth_opbal = bl_open_amount;
		else
			bl_other_opbal = bl_open_amount;

		bl_total_opbal     += bl_open_amount;
		bl_dd_tot_pmnt_amt += bl_dd_pmnt_amt;
	}

	bl_yr_colln_amt  += bl_total_opbal;
	bl_yr_colln_amt1 += bl_first_opbal;
	bl_yr_colln_amt2 += bl_second_opbal;
	bl_yr_colln_amt3 += bl_third_opbal;
	bl_yr_colln_amt4 += bl_fourth_opbal;
	bl_yr_colln_amt5 += bl_other_opbal;

   
	fprintf(fp, "  %-37.37s",loc_legend[220]);
	if ( bl_total_opbal != 0)   
		print_formated(bl_total_opbal);
	else
        print_formated(0);

	//Newly added column
	if (bl_total_opbal != 0)   
		print_formated(bl_total_opbal);
	else
        print_formated(0);

	if ( bl_dd_tot_pmnt_amt != 0)   
		print_formated(bl_dd_tot_pmnt_amt);
	else
        print_formated(0);

	//Newly added column
	fprintf(fp,"                 ");

	//Newly added column
	fprintf(fp,"                 ");
	
	if ( bl_first_opbal != 0)   
		print_formated(bl_first_opbal);
	else
        print_formated(0);

	if (bl_second_opbal != 0)
		print_formated(bl_second_opbal);
	else
        print_formated(0);

	if (bl_third_opbal != 0)
       print_formated(bl_third_opbal);
	else
        print_formated(0);

	if (bl_fourth_opbal != 0)
       print_formated(bl_fourth_opbal);
	else
        print_formated(0);

	if (bl_other_opbal != 0)
       print_formated(bl_other_opbal);
	else
        print_formated(0);

	bl_yr_bank_amt += bl_dd_tot_pmnt_amt;

	fprintf(fp,"\n");
 	lctr++;
	fprintf(fp,"\n");
 	lctr++;
}

print_day_details()
{
  while(fetch_hdr())
  {
	fprintf(fp,"%-20.20s %-6s / %-8d ", bl_trx_date.arr, bl_doc_type.arr, bl_doc_num);
	print_formated(bl_doc_amt);
    
	l_page_total = bl_doc_amt + l_page_total;

	fprintf(fp,"%17s"," ");

	bl_day_colln_amt += bl_doc_amt;

    if (strcmp(bl_acct_code.arr,bl_first_acc_code.arr) == 0)
	{	
		fprintf(fp,"%51s"," ");
		print_formated(bl_doc_amt);
        bl_day_colln_amt1 += bl_doc_amt;
		l_page_total1 += bl_doc_amt;
	}
	else if (strcmp(bl_acct_code.arr,bl_second_acc_code.arr) == 0)
	{  
		calc_space(2);
        print_formated(bl_doc_amt);
		bl_day_colln_amt2 += bl_doc_amt;
		l_page_total2 += bl_doc_amt;
	}
    else
	if (strcmp(bl_acct_code.arr,bl_third_acc_code.arr) == 0)
	{  
		calc_space(3);
        print_formated(bl_doc_amt);
		bl_day_colln_amt3 += bl_doc_amt;
		l_page_total3 += bl_doc_amt;
	}
    else if (strcmp(bl_acct_code.arr,bl_fourth_acc_code.arr) == 0)
    {   
		calc_space(4);
		print_formated(bl_doc_amt);
		bl_day_colln_amt4 += bl_doc_amt;
		l_page_total4 += bl_doc_amt;
	}
    else
    {
		calc_space(5);
		print_formated(bl_doc_amt);
		bl_day_colln_amt5 += bl_doc_amt;
        fprintf(fp, " %7s ", bl_acct_code.arr);
		l_page_total5 += bl_doc_amt;
	}
	fprintf(fp,"\n");
 	lctr++;
	check_page_end(1,1);
	if (bl_downtime_doc_type.arr[0] != '\0')
	{
		fprintf(fp,"%-20.20s (%-s %-d) ", "", bl_downtime_doc_type.arr, bl_downtime_doc_num);
		fprintf(fp,"\n");
		lctr++;
		check_page_end(1,1);
	}
  }   
}


print_cancel_details()
{
    if (cancel_rec > 0 )
	{  
		check_page_end(2,1);
		fprintf(fp,"Less: Previous Day(s) Cancellations\n\n");
		lctr+=2;
		check_page_end(2,1);

		while(fetch_prev_cancel())
		{
    		fprintf(fp,"%-20.20s %-6s / %-8d ",bl_mn_cancel_trx_date.arr, bl_mn_cancel_doc_type.arr, bl_mn_cancel_doc_num);
			print_formated(bl_mn_cancel_doc_amt);
			bl_mn_ccolln_amt += bl_mn_cancel_doc_amt;

			fprintf(fp,"%17s"," ");

			if (strcmp(bl_mn_cancel_acct_code.arr,bl_first_acc_code.arr) == 0)
			{
				print_formated(bl_mn_cancel_doc_amt);
				bl_mn_ccolln_amt1 += bl_mn_cancel_doc_amt;
			}
			else if (strcmp(bl_mn_cancel_acct_code.arr,bl_second_acc_code.arr) == 0)
			{  
				calc_space(2);
				print_formated(bl_mn_cancel_doc_amt);
				bl_mn_ccolln_amt2 += bl_mn_cancel_doc_amt;
			}
			else if (strcmp(bl_mn_cancel_acct_code.arr,bl_third_acc_code.arr) == 0)
			{  
				calc_space(3);
                print_formated(bl_mn_cancel_doc_amt);
				bl_mn_ccolln_amt3 += bl_mn_cancel_doc_amt;
			}
			else if (strcmp(bl_mn_cancel_acct_code.arr,bl_fourth_acc_code.arr) == 0)
            {   
				calc_space(4);
			    print_formated(bl_mn_cancel_doc_amt);
				bl_mn_ccolln_amt4 += bl_mn_cancel_doc_amt;
			}
			else
			{
				calc_space(5);
				print_formated(bl_mn_cancel_doc_amt);
                fprintf(fp, " %7s ", bl_mn_cancel_acct_code.arr);
				bl_mn_ccolln_amt5 += bl_mn_cancel_doc_amt;
			}
			fprintf(fp,"\n");

 			lctr=lctr+2;
			check_page_end(2,1);
		}
	  	print_cancel_total();      
	}
}

print_bank_in_dtls()
{
	char str_var[1000];

	if (bank_rec > 0)
	{
		check_page_end(2,1);
		fprintf(fp,"\n");
		lctr+=2;
		
		while(fetch_bank_in_dtls())
		{
			fprintf(fp,"                                                                         ");
			print_formated(bl_bank_in_amt);
			fprintf(fp," %-19.19s   ",bl_bank_docdate.arr);
			fprintf(fp," %-19.19s\n",bl_tr_receipt_date.arr);
			lctr++;
			fprintf(fp,"                                                                                           ");

			l_slmt_desc.arr[0] = '\0';

			/* EXEC SQL SELECT short_desc
			           INTO :l_slmt_desc
					   FROM bl_slmt_type
					  WHERE slmt_type_code = :bl_slmt_typecod; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from bl_slmt_type where slmt_t\
ype_code=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )666;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_slmt_desc;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bl_slmt_typecod;
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



			l_slmt_desc.arr[l_slmt_desc.len] = '\0';

			sprintf(str_var,"%-s %-s ",bl_bank_in_docno.arr,l_slmt_desc.arr);
			fprintf(fp,"%-23.23s",str_var);
			fprintf(fp,"%-20.20s",bl_tr_receipt_no.arr);

			bl_bank_total_colln_amt += bl_bank_in_amt;
		
			fprintf(fp,"\n");
			lctr++;

			//bl_yr_bank_amt   += bl_bank_total_colln_amt;
			bl_yr_bank_amt   += bl_bank_in_amt;
			
			check_page_end(2,1);	
		}
		//print_bank_total();
	}
}

print_bank_total()
{
	fprintf(fp,"%56s","  ");
	fprintf(fp,"----------------- \n");
	fprintf(fp,"  Bank-in Total     %36s", " ");
	print_formated(bl_bank_total_colln_amt);
	fprintf(fp,"\n");
	//fprintf(fp,"\n%39s"," ");
	//align_head(3);
	lctr+=3;
}

print_cancel_total()
{
	check_page_end(3,1);
	fprintf(fp,"%39s"," ");
	align_head(3);
  	fprintf(fp, " ");
	fprintf(fp," Cancellation for the Month           ");
	print_formated(bl_mn_ccolln_amt);
	fprintf(fp,"%68s"," ");
	print_formated(bl_mn_ccolln_amt1);
	print_formated(bl_mn_ccolln_amt2);
	print_formated(bl_mn_ccolln_amt3);   
	print_formated(bl_mn_ccolln_amt4);
	print_formated(bl_mn_ccolln_amt5);   
	fprintf(fp,"\n%39s"," ");
    align_head(3);
	lctr+=3;

	l_total_cancellation1+= bl_mn_ccolln_amt1;
	l_total_cancellation2+= bl_mn_ccolln_amt2;
	l_total_cancellation3+= bl_mn_ccolln_amt3;  
	l_total_cancellation4+= bl_mn_ccolln_amt4;
	l_total_cancellation5+= bl_mn_ccolln_amt5;
	
	l_total_cancellation  = l_total_cancellation1 + l_total_cancellation2 + l_total_cancellation3 + l_total_cancellation4 + l_total_cancellation5;
	
	check_page_end(0,1);
}

print_page_openbal()
{
	fprintf(fp,"  %-37.37s",loc_legend[220]);
	//print_formated(bl_day_colln_amt);
	print_formated(bl_mnth_colln_amt);

	//Monthly balance should be carried forward insted of day total.
	//l_day_accross_total = bl_day_colln_amt1 + bl_day_colln_amt2 + bl_day_colln_amt3 + bl_day_colln_amt4 + bl_day_colln_amt5;
	//print_formated(l_day_accross_total); //New column
    
	l_month_accross_total = bl_mnth_colln_amt1 + bl_mnth_colln_amt2 + bl_mnth_colln_amt3 + bl_mnth_colln_amt4 + bl_mnth_colln_amt5;
    print_formated(l_month_accross_total);    //New Column


	
	print_formated(bl_dd_tot_pmnt_amt);
	//fprintf(fp,"%17s"," ");

	fprintf(fp,"%34s"," ");   //New column
	print_formated(bl_mnth_colln_amt1);
	print_formated(bl_mnth_colln_amt2);
	print_formated(bl_mnth_colln_amt3);   
	print_formated(bl_mnth_colln_amt4);
	print_formated(bl_mnth_colln_amt5);
	fprintf(fp,"\n\n");  
	lctr+=5;
}

print_column_total()
{
	check_page_end(3,0);
	fprintf(fp,"                                                        ");
	
	if(l_total_cancellation!=0)
		l_page_total += l_total_cancellation;
	
	print_formated(l_page_total);
	fprintf(fp,"\n");

	fprintf(fp,"%39s"," ");
	align_head(3);
	fprintf(fp, " ");
	fprintf(fp," %-37.37s",loc_legend[230]);

	if(l_total_cancellation!=0)
		bl_day_colln_amt += l_total_cancellation;
	print_formated(bl_day_colln_amt);

	//Incorporated to reduce the cancelled doc amount.
	if(l_total_cancellation1!=0)
		bl_day_colln_amt1 += l_total_cancellation1;
	if(l_total_cancellation2!=0)
		bl_day_colln_amt2 += l_total_cancellation2;
	if(l_total_cancellation3!=0)
		bl_day_colln_amt3 += l_total_cancellation3;  
	if(l_total_cancellation4!=0)
		bl_day_colln_amt4 += l_total_cancellation4;
	if(l_total_cancellation5!=0)
		bl_day_colln_amt5 += l_total_cancellation5;  

	l_day_accross_total = bl_day_colln_amt1 + bl_day_colln_amt2 + bl_day_colln_amt3 + bl_day_colln_amt4 + bl_day_colln_amt5;
	//l_day_accross_total+= l_day_accross_total;
	print_formated(l_day_accross_total); //New column
	
	//fprintf(fp,"%2s"," ");
	print_formated(bl_bank_total_colln_amt);

	//fprintf(fp,"%17s"," ");

	fprintf(fp,"%34s"," ");   //New column
	print_formated(bl_day_colln_amt1);
	print_formated(bl_day_colln_amt2);
	print_formated(bl_day_colln_amt3);   
	print_formated(bl_day_colln_amt4);
	print_formated(bl_day_colln_amt5);
	fprintf(fp,"\n%39s"," ");
	align_head(3);
	lctr+=3;
	//check_page_end(3,0);
}

print_month_total()
{
	  check_page_end(3,0);	
      bl_mnth_colln_amt  = bl_total_opbal + bl_day_colln_amt + bl_mn_ccolln_amt;
	  bl_mnth_bank_amt   = bl_dd_tot_pmnt_amt + bl_bank_total_colln_amt;
	  bl_mnth_colln_amt1 = bl_first_opbal + bl_day_colln_amt1 + bl_mn_ccolln_amt1;
      bl_mnth_colln_amt2 = bl_second_opbal + bl_day_colln_amt2 + bl_mn_ccolln_amt2;
      bl_mnth_colln_amt3 = bl_third_opbal + bl_day_colln_amt3 + bl_mn_ccolln_amt3;
      bl_mnth_colln_amt4 = bl_fourth_opbal + bl_day_colln_amt4 + bl_mn_ccolln_amt4;
      bl_mnth_colln_amt5 = bl_other_opbal + bl_day_colln_amt5 + bl_mn_ccolln_amt5;
  	  fprintf(fp, " ");
	               
	  fprintf(fp," %-37.37s",loc_legend[240]);
	  if(l_total_cancellation!=0)
		bl_mnth_colln_amt += l_total_cancellation;
	  print_formated(bl_mnth_colln_amt);
	  
	  if(l_total_cancellation1!=0)	
		bl_mnth_colln_amt1 += l_total_cancellation1;
	  if(l_total_cancellation2!=0)
		bl_mnth_colln_amt2 += l_total_cancellation2;
	  if(l_total_cancellation3!=0)
		bl_mnth_colln_amt3 += l_total_cancellation3;  
	  if(l_total_cancellation4!=0)
		bl_mnth_colln_amt4 += l_total_cancellation4;
	  if(l_total_cancellation5!=0)
		bl_mnth_colln_amt5 += l_total_cancellation5;  

	  l_month_accross_total = bl_mnth_colln_amt1 + bl_mnth_colln_amt2 + bl_mnth_colln_amt3 + bl_mnth_colln_amt4 + bl_mnth_colln_amt5;
	  print_formated(l_month_accross_total);    //New Column
	  print_formated(bl_mnth_bank_amt);
	  fprintf(fp,"                                  ");	//New column
	  
	  print_formated(bl_mnth_colln_amt1);
	  print_formated(bl_mnth_colln_amt2);
	  print_formated(bl_mnth_colln_amt3);   
	  print_formated(bl_mnth_colln_amt4);
	  print_formated(bl_mnth_colln_amt5);   
      fprintf(fp, " \n");
	  lctr++;
	  //check_page_end(3,0);
}

print_year_total()
{ 
	  check_page_end(4,0);
	  /*bl_yr_colln_amt  += bl_mnth_colln_amt + bl_pmn_ccolln_amt;
	  bl_yr_bank_amt   += bl_mnth_bank_amt;
	  bl_yr_colln_amt1 += bl_mnth_colln_amt1 + bl_pmn_ccolln_amt1;
      bl_yr_colln_amt2 += bl_mnth_colln_amt2 + bl_pmn_ccolln_amt2;
      bl_yr_colln_amt3 += bl_mnth_colln_amt3 + bl_pmn_ccolln_amt3;
      bl_yr_colln_amt4 += bl_mnth_colln_amt4 + bl_pmn_ccolln_amt4;
      bl_yr_colln_amt5 += bl_mnth_colln_amt5 + bl_pmn_ccolln_amt5;*/

	  bl_yr_colln_amt  += l_page_total +  bl_pmn_ccolln_amt;
	  //bl_yr_bank_amt   += bl_mnth_bank_amt;
	  //bl_yr_bank_amt   += bl_bank_total_colln_amt + bl_dd_tot_pmnt_amt;  -- Moved to bank collection printing procedure.
	  bl_yr_colln_amt1 += l_page_total1 + bl_pmn_ccolln_amt1;
      bl_yr_colln_amt2 += l_page_total2 + bl_pmn_ccolln_amt2;
      bl_yr_colln_amt3 += l_page_total3 + bl_pmn_ccolln_amt3;
      bl_yr_colln_amt4 += l_page_total4 + bl_pmn_ccolln_amt4;
      bl_yr_colln_amt5 += l_page_total5 + bl_pmn_ccolln_amt5;	  
	  
	  fprintf(fp,"%39s"," ");
	  align_head(3);
	  fprintf(fp, " ");
	  fprintf(fp," %-37.37s",loc_legend[260]);
	  print_formated(bl_yr_colln_amt);

	  if(l_total_cancellation!=0)	
		bl_yr_colln_amt += l_total_cancellation;	

	  if(l_total_cancellation1!=0)	
		bl_yr_colln_amt1 += l_total_cancellation1;
	  if(l_total_cancellation2!=0)
		bl_yr_colln_amt2 += l_total_cancellation2;
	  if(l_total_cancellation3!=0)
		bl_yr_colln_amt3 += l_total_cancellation3;  
	  if(l_total_cancellation4!=0)
		bl_yr_colln_amt4 += l_total_cancellation4;
	  if(l_total_cancellation5!=0)
		bl_yr_colln_amt5 += l_total_cancellation5;  

	  l_year_accross_total = bl_yr_colln_amt1 + bl_yr_colln_amt2 + bl_yr_colln_amt3 + bl_yr_colln_amt4 + bl_yr_colln_amt5; 	
	  print_formated(l_year_accross_total);  //New Column
	  
	  print_formated(bl_yr_bank_amt);
	  fprintf(fp,"%34s"," ");	//New column
		
	  print_formated(bl_yr_colln_amt1);
	  print_formated(bl_yr_colln_amt2);
	  print_formated(bl_yr_colln_amt3);   
	  print_formated(bl_yr_colln_amt4);
	  print_formated(bl_yr_colln_amt5);   
      fprintf(fp, " \n");
	  fprintf(fp,"%39s"," ");
	  align_head(3);
	  lctr+=3;
	  //check_page_end(1,0);
}
   
print_prev_mnth_cancel_total()
{
	  check_page_end(3,0);
	  fprintf(fp,"%39s"," ");
	  align_head(3);
  	  fprintf(fp, " ");
	  fprintf(fp," Previous Months Cancellation         ");
	  print_formated(bl_pmn_ccolln_amt);
	  fprintf(fp,"%68s"," ");
	  print_formated(bl_pmn_ccolln_amt1);
	  print_formated(bl_pmn_ccolln_amt2);
	  print_formated(bl_pmn_ccolln_amt3);   
	  print_formated(bl_pmn_ccolln_amt4);
	  print_formated(bl_pmn_ccolln_amt5);   
      fprintf(fp, " \n");
	  fprintf(fp,"%39s"," ");
	  align_head(3);
	  lctr+=3;

	  l_total_cancellation1+= bl_pmn_ccolln_amt1;
	  l_total_cancellation2+= bl_pmn_ccolln_amt2;
	  l_total_cancellation3+= bl_pmn_ccolln_amt3;  
	  l_total_cancellation4+= bl_pmn_ccolln_amt4;
	  l_total_cancellation5+= bl_pmn_ccolln_amt5;  

	  l_total_cancellation  = l_total_cancellation1 + l_total_cancellation2 + l_total_cancellation3 + l_total_cancellation4 + l_total_cancellation5;
	  
	  //check_page_end(3,0);
}
 
print_account_aggregate()
{
	lctr++;
	check_page_end(2,0);
	fprintf(fp,"%121.121s : ",loc_legend[270]);
	print_formated(l_year_accross_total);
	fprintf(fp,"\n\n");	
	lctr+=2;
	check_page_end(3,0);
	fprintf(fp,"%98s%-s\n"," ",loc_legend[250]);
	fprintf(fp,"%98s"," ");fill_dash(strlen(loc_legend[250]));
	fprintf(fp,"\n");

	while(fetch_account_aggregate())
	{
		check_page_end(1,0);
		fprintf(fp,"%98s%-15.15s         : "," ",l_aggr_acc_code.arr);
		print_formated(l_aggr_acc_amt);
		fprintf(fp,"\n");
		lctr++;
	}
}

end_of_rep()
{
	fprintf(fp,"\n\n %72s   ***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00035.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00035.lis");
       proc_exit();
    }
}

print_head()
{
	align_head(0);
	/*fprintf(fp,"MDL : BL %62s %-30s %49s %-16s\n"," ",hosp_name.arr," ",date_time.arr);
	fprintf(fp,"OPR : %-10s \n", user_id.arr);
	fprintf(fp,"REP : %-8s  %62s %s  %60s  PAGE : %4d\n","BLR00035"," "," CASH BOOK "," ",++pctr);
	fprintf(fp,"%70s DATE OF COLLECTION %s          \n"," ",nd_forthe_date.arr);
	fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------");
	align_head(1);
	fprintf(fp,"Date/Time            Receipt Reference          Amount      Total Amount  Bank-in Amount  Date/Doc No/Slmt   Perbandaharran");
	*/

	print_page_title();
	align_head(6);
	align_head(4); 
	fprintf(fp,"%-18.18s   %-17.17s  %14.14s  %16.16s  %14.14s  %16.16s  %15.15s",loc_legend[130],loc_legend[140],loc_legend[150],loc_legend[160],loc_legend[150],loc_legend[170],loc_legend[140]) ;
	align_head(2);
	align_head(5);
	fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------");
	align_head(1);
	
	fflush(fp);  
	lctr = 13;
}

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;

	l_report_width=220;
	l_acc_entity_length = strlen(hosp_name.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	fprintf(fp,"MDL           : BL");
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",hosp_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[30],date.arr);

	//Code for Line 2
	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[1]))/2));
	fprintf(fp,"OPR           : %s",user_id.arr);
	l_start_point=l_start_point-(strlen(user_id.arr)+16);
	print_spaces(l_start_point);
	fprintf(fp,"%s",loc_legend[1]);
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[1]);
	l_start_point=(l_report_width-(17+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[40],date_time.arr);

	//Code for Line 3
	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-((strlen(nd_forthe_date.arr)+strlen(loc_legend[10]))/2));
	fprintf(fp,"%-14.14s: BLR00035",loc_legend[20]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	fprintf(fp,"%s %s",loc_legend[10],nd_forthe_date.arr);
	l_comp_name_end_point=l_start_point+24+strlen(loc_legend[10])+strlen(nd_forthe_date.arr);
	l_start_point=(l_report_width-(17+9)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %d\n",loc_legend[50],++pctr);
	
	fprintf(fp,"\n");
}

fill_dash(flg)
{
  int i;
  for (i=1;i<=flg;i++)
	fprintf(fp,"%s","-");
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
	date.arr[0]		 = '\0';
    user_id.arr[0]   = '\0';
	l_currency.arr[0]= '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
	date.len		 = 0;
    user_id.len      = 0;
	l_currency.len	 = 0;
    // COMMENTED ACCOUNTING_NAME  AND ADDED ACC_ENTITY_NAME  FOR IN13330
    /* EXEC SQL SELECT ACC_ENTITY_NAME,--ACCOUNTING_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/RRRR'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
                    USER,
					base_currency
               INTO :hosp_name, 
					:date,
					:date_time, 
					:user_id,
					:l_currency
               FROM SY_ACC_ENTITY
	          WHERE ACC_ENTITY_ID = :nd_facility; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/RRRR') ,TO\
_CHAR(SYSDATE,'HH24:MI:SS') ,USER ,base_currency into :b0,:b1,:b2,:b3,:b4  fro\
m SY_ACC_ENTITY where ACC_ENTITY_ID=:b5";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )689;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&hosp_name;
    sqlstm.sqhstl[0] = (unsigned int  )122;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&date_time;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&user_id;
    sqlstm.sqhstl[3] = (unsigned int  )93;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_currency;
    sqlstm.sqhstl[4] = (unsigned int  )12;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility;
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



    if (OERROR) 
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	date.arr[date.len]					   = '\0';
	user_id.arr[user_id.len]               = '\0';
	l_currency.arr[l_currency.len]		   = '\0';
}

align_head(flg)
{
	/* EXEC SQL EXECUTE  
	BEGIN
		SELECT  COUNT(DISTINCT account_code) 
		  INTO  :x_count
		  FROM  bl_ext_acct_code a
		 WHERE	cashbk_main_acct_seq IS NOT NULL;
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SELECT COUNT ( DISTINCT account_code ) INTO :x_count F\
ROM bl_ext_acct_code a WHERE cashbk_main_acct_seq IS NOT NULL ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )728;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&x_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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



	switch(flg)       
	{

      case 0 :  
			if (bl_first_prt_code.arr[0] == '\0')
			{ 
				if (bl_first_acc_code.arr[0] !='\0') 
				{
					strcpy(bl_first_prt_code.arr,bl_first_acc_code.arr);
					field_position = 1;
				}
				else if (bl_second_acc_code.arr[0] !='\0')
				{
					strcpy(bl_first_prt_code.arr,bl_second_acc_code.arr);
					field_position = 2;
				}
				else if (bl_third_acc_code.arr[0] !='\0')
				{
					strcpy(bl_first_prt_code.arr,bl_third_acc_code.arr);
					field_position = 3;
				}
				else
				{
					strcpy(bl_first_prt_code.arr,bl_fourth_acc_code.arr);
					field_position = 4;
				}
			}

			if (field_position == 4 )
				  break;
			else
			{ 
				if (bl_second_prt_code.arr[0] == '\0') 
				{ 
					if (field_position > 1)
					{
						if (field_position == 2 )
							if (bl_third_acc_code.arr[0] !='\0')
							{
								strcpy(bl_second_prt_code.arr,bl_third_acc_code.arr);
								field_position = 3;
							}
							else if (field_position == 3)
							{ 
								if (bl_fourth_acc_code.arr[0] !='\0')
								{ 
									strcpy(bl_second_prt_code.arr,bl_fourth_acc_code.arr);
									field_position = 4;
								}
	    					}
					}
                    else if (bl_second_acc_code.arr[0] != '\0')
					{
						strcpy(bl_second_prt_code.arr, bl_second_acc_code.arr);
						field_position = 2;
					}
				}
            }
			
			if (field_position == 4)
				  break;
			else if (field_position == 2)
			{ 
				if (bl_third_acc_code.arr[0] !='\0')
				{
					strcpy(bl_third_prt_code.arr,bl_third_acc_code.arr);
					field_position = 3;
				}
			}
            else if (field_position == 3)
			{ 
				if (bl_fourth_acc_code.arr[0] !='\0')
				{
					strcpy(bl_third_prt_code.arr,bl_fourth_acc_code.arr);
					field_position = 4;
					break;
				}
			}

			if (field_position  == 3)
				if (bl_fourth_acc_code.arr[0] != '\0')
					strcpy(bl_fourth_prt_code.arr,bl_fourth_acc_code.arr);
				break;

	  case 1 :	
			if (x_count == 0)   
			{ 
				fill_dash(33);
				fprintf(fp, " \n");
			}
			else if (x_count == 1)
			{
				fill_dash(49);
				fprintf(fp, " \n");
			}
			else if (x_count == 2) 
			{
				fill_dash(65);
				fprintf(fp, " \n");
			}
			else if (x_count == 3)
			{ 
				fill_dash(81);
				fprintf(fp, " \n"); 
			}
			else
			{ 
				fill_dash(97);
				fprintf(fp, " \n"); 
			}
			break;
	  case 2 :   
			/*if (x_count == 0)
				fprintf(fp, "%-32.32s \n","      Others  Acct.Code" );
			else*/ 
			
			if(x_count == 1)
			{ 
				//fprintf(fp, "%16s %27s ",bl_first_acc_code.arr,"      Others  Acct.Code" );
				fprintf(fp, "%16s ",bl_first_acc_code.arr);
			}
			else if(x_count == 2) 
			{
				fprintf(fp, "%16s %16s ",bl_first_acc_code.arr, bl_second_acc_code.arr);
			}
			else if(x_count == 3)
			{
				fprintf(fp, "%16s %16s %16s ",bl_first_acc_code.arr, bl_second_acc_code.arr,bl_third_acc_code.arr);
			}
			else if(x_count == 4)
			{
				fprintf(fp,"%16s %16s %16s %16s ",bl_first_acc_code.arr, bl_second_acc_code.arr,bl_third_acc_code.arr,bl_fourth_acc_code.arr);
			}
			fprintf(fp,"%16.16s  %8.8s\n",loc_legend[180],loc_legend[190]);
			break;

	case 3 : 
			if (x_count == 0)   
	         { 
				fill_dash(118);
				fprintf(fp, " \n");
			 }
			 else if (x_count == 1)
			 {
				fill_dash(134);
				fprintf(fp, " \n");
			 }
		     else if (x_count == 2) 
			 {
				fill_dash(150);
				fprintf(fp, " \n");
			 }
			 else if (x_count == 3)
			 { 
				fill_dash(166);
				fprintf(fp, " \n"); 
			 }
			 else
			 { 
				fill_dash(182);
				fprintf(fp, " \n"); 
			 }
			 break;
	case 4 :
			
			fprintf(fp,"%95s%-11.11s                  "," ",loc_legend[120]);
			for(j=1;j<=x_count;j++)
			{
				l_cash_book_acc_desc.arr[0]='\0';

				/* EXEC SQL SELECT cashbk_main_acct_col_desc
					       INTO :l_cash_book_acc_desc
						   FROM bl_ext_acct_code
						  WHERE cashbk_main_acct_seq = :j
						    AND cashbk_main_acct_col_desc IS NOT NULL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select cashbk_main_acct_col_desc into :b0  from bl_ext_ac\
ct_code where (cashbk_main_acct_seq=:b1 and cashbk_main_acct_col_desc is  not \
null )";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )747;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_cash_book_acc_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&j;
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


				
				if(OERROR) 
					err_mesg("SELECT failed on table bl_ext_acct_code",0,"");
				
				l_cash_book_acc_desc.arr[l_cash_book_acc_desc.len]='\0';

				fprintf(fp, "%15.15s  ",l_cash_book_acc_desc.arr);
			}
			fprintf(fp,"\n");
			break;

	case 5 :
			fprintf(fp,"%46s%8.8s      %12.12s        %8.8s       %-11.11s        %-15.15s "," ",l_currency.arr,l_currency.arr,l_currency.arr,loc_legend[200],loc_legend[210]);
			for(j=1;j<=x_count;j++)
			{
				fprintf(fp, "%9.9s        ",l_currency.arr);
			}
			fprintf(fp, "%9.9s\n",l_currency.arr);
			break;
	case 6 :
			fprintf(fp,"%72s<"," ");
			fill_dash(26-(strlen(loc_legend[60])/2));
			fprintf(fp,"%s",loc_legend[60]);
			fill_dash(26-(strlen(loc_legend[60])/2));
			fprintf(fp,">  <");
			fill_dash(((((x_count-1)*20)+27)/2)-(strlen(loc_legend[70])/2));
			fprintf(fp,"%s",loc_legend[70]);
			fill_dash(((((x_count-1)*20)+27)/2)-(strlen(loc_legend[70])/2));
			fprintf(fp,">\n");
	}
}


calc_space(flg)
{
  char dgx[200];
  char x_msg[200];

  switch (flg) 
  {
		case 2:
			if (bl_first_acc_code.arr[0] == '\0')
			{
			   fprintf(fp,"%51s"," ");
			   fprintf(fp,"%17s "," ");
			
			}
			else
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%33s "," ");
			}
			break;

		case 3:
			if ((bl_first_acc_code.arr[0] == '\0') && (bl_second_acc_code.arr[0] == '\0'))
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp," ");
			}
			else if ((bl_first_acc_code.arr[0] == '\0') || (bl_second_acc_code.arr[0] == '\0'))
			{				
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%16s "," ");
			}
			else
		  	{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%33s "," ");
			}
			break;
		case 4:
			if ((bl_first_acc_code.arr[0] == '\0') && (bl_second_acc_code.arr[0] == '\0') && (bl_third_acc_code.arr[0] == '\0'))
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp," ");
			}
			else if ((bl_first_acc_code.arr[0] == '\0') && (bl_second_acc_code.arr[0] == '\0') && (bl_third_acc_code.arr[0] != '\0'))
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%16s "," ");
			}
			else if ((bl_first_acc_code.arr[0] == '\0') && (bl_second_acc_code.arr[0] != '\0') && (bl_third_acc_code.arr[0] == '\0'))
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%16s "," ");
			}
			else if ((bl_first_acc_code.arr[0] != '\0') && (bl_second_acc_code.arr[0] == '\0') && (bl_third_acc_code.arr[0] == '\0'))
			{	
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%16s "," ");
			}
			else if ((bl_first_acc_code.arr[0] == '\0') && (bl_second_acc_code.arr[0] != '\0') && (bl_third_acc_code.arr[0] != '\0'))
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%33s "," ");
			}
			else if ((bl_first_acc_code.arr[0] != '\0') && (bl_second_acc_code.arr[0] != '\0') && (bl_third_acc_code.arr[0] == '\0'))
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%33s "," ");
			}
			else if ((bl_first_acc_code.arr[0] == '\0') && (bl_second_acc_code.arr[0] != '\0') && (bl_third_acc_code.arr[0] != '\0'))
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%33s "," ");
			}
			else 
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%50s "," ");
			}
				break;
		case 5:
			if (x_count == 4)
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%67s "," ");  
			}
			else if (x_count == 3)
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%50s ", " ");
			}
			else if (x_count == 2)
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%33s ", " ");
			}
			else
			{
				fprintf(fp,"%51s"," ");
				fprintf(fp,"%16s "," ");
			}
			break;
	}

}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s  ",str_amt);
    }
}                        

check_page_end(l_lead_lines, l_print_flag)
int l_lead_lines;
int	l_print_flag;
{
	if(l_print_flag==1)
		l_lead_lines=l_lead_lines+10;

	if((lctr+l_lead_lines)>60) 
	{
		if(l_print_flag==1)
		{
			print_column_total();
			print_month_total();      
			print_year_total();
			fprintf(fp,"%121.121s : ",loc_legend[270]);
			print_formated(l_year_accross_total);
			fprintf(fp,"\n");
		}		
		l_page_total  = 0;
		l_page_total1 = 0;
		l_page_total2 = 0;
		l_page_total3 = 0;
		l_page_total4 = 0;
		l_page_total5 = 0;

		fprintf(fp,"\f");
		print_head();
		if(l_print_flag==1)
			print_page_openbal();
		lctr = 14;
	}
}

print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp," ");
	}
}