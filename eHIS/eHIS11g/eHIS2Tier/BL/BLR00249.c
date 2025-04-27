
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00249.PC"
};


static unsigned int sqlctx = 1288461027;


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
            void  *sqhstv[8];
   unsigned int   sqhstl[8];
            int   sqhsts[8];
            void  *sqindv[8];
            int   sqinds[8];
   unsigned int   sqharm[8];
   unsigned int   *sqharc[8];
   unsigned short  sqadto[8];
   unsigned short  sqtdso[8];
} sqlstm = {12,8};

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

 static const char *sq0003 = 
"select account_code ,CASHBK_RFND_ACCT_SEQ ,CASHBK_RFND_ACCT_COL_DESC  from B\
L_EXT_ACCT_CODE where CASHBK_RFND_ACCT_SEQ is  not null  order by CASHBK_RFND_\
ACCT_SEQ            ";

 static const char *sq0004 = 
"select to_char(DOC_DATE,'dd/mm/yyyy') ,substr(PAYER_NAME,1,40) ,(((doc_type_\
code||'/')||doc_number)||decode(CANCEL_AUTH_BY_ID,null ,'','(C)')) docnum ,nvl\
(doc_amt,0) ,EXT_ACCT_CODE ,cancelled_ind ,doc_type_code ,doc_number  from BL_\
RECPT_REFUND_CAN_BOU_DTL_VW where ((((operating_facility_id=:b0 and trunc(doc_\
date)>=to_date(:b1,'dd/mm/yyyy')) and trunc(doc_date)<=to_date(:b2,'dd/mm/yyyy\
')) and CASH_SLMT_FLAG='Y') and RECPT_REFUND_IND='F') order by doc_date       \
     ";

 static const char *sq0005 = 
"select ((CHQ_NO||'-')||to_char(CHQ_DATE,'dd/mm/yyyy')) rcpt_desc ,nvl(DOC_AM\
T,0) DOC_AMT  from bl_cash_refund_cycle_trn where (((operating_facility_id=:b0\
 and nvl(CHQ_RECEIVED_YN,'N')='Y') and CHQ_RECEIVED_DATE<=to_date(:b1,'dd/mm/y\
yyy')) and (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y' and CH\
Q_CLEARED_DATE>=to_date(:b1,'dd/mm/yyyy'))))           ";

 static const char *sq0006 = 
"select a.RECOUPED_VR_NO rcpt_desc ,nvl(a.DOC_AMT,0) DOC_AMT  from bl_cash_re\
fund_cycle_trn a ,bl_cash_refund_cashbook_cb b where ((((((a.operating_facilit\
y_id=:b0 and b.operating_facility_id=a.operating_facility_id) and a.RECOUPED_V\
R_NO=b.cb_RECOUPED_VR_NO) and nvl(a.OB_TRN_YN,'N')='N') and (nvl(a.CHQ_RECEIVE\
D_YN,'N')='N' or (nvl(a.CHQ_RECEIVED_YN,'N')='Y' and trunc(a.CHQ_RECEIVED_DATE\
)>to_date(:b1,'dd/mm/yyyy')))) and a.RECOUPED_VR_NO is  not null ) and trunc(b\
.CB_DATE)<to_date(:b1,'dd/mm/yyyy'))           ";

 static const char *sq0007 = 
"select ((CHQ_NO||'-')||to_char(CHQ_DATE,'dd/mm/yyyy')) rcpt_desc ,nvl(DOC_AM\
T,0) DOC_AMT  from bl_cash_refund_cycle_trn where (((operating_facility_id=:b0\
 and nvl(CHQ_RECEIVED_YN,'N')='Y') and CHQ_RECEIVED_DATE<=to_date(:b1,'dd/mm/y\
yyy')) and (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y' and tr\
unc(CHQ_CLEARED_DATE)>to_date(:b1,'dd/mm/yyyy'))))           ";

 static const char *sq0008 = 
"select a.RECOUPED_VR_NO rcpt_desc ,nvl(a.DOC_AMT,0) DOC_AMT  from bl_cash_re\
fund_cycle_trn a ,bl_cash_refund_cashbook_cb b where ((((((a.operating_facilit\
y_id=:b0 and b.operating_facility_id=a.operating_facility_id) and a.RECOUPED_V\
R_NO=b.cb_RECOUPED_VR_NO) and nvl(a.OB_TRN_YN,'N')='N') and (nvl(a.CHQ_RECEIVE\
D_YN,'N')='N' or (nvl(a.CHQ_RECEIVED_YN,'N')='Y' and trunc(a.CHQ_RECEIVED_DATE\
)>to_date(:b1,'dd/mm/yyyy')))) and a.RECOUPED_VR_NO is  not null ) and trunc(b\
.CB_DATE)<to_date(:b1,'dd/mm/yyyy'))           ";

 static const char *sq0009 = 
"select a.RECOUPED_VR_NO rcpt_desc ,nvl(a.DOC_AMT,0) DOC_AMT  from bl_cash_re\
fund_cycle_trn a ,bl_cash_refund_cashbook_cb b where ((((((a.operating_facilit\
y_id=:b0 and b.operating_facility_id=a.operating_facility_id) and a.RECOUPED_V\
R_NO=b.cb_RECOUPED_VR_NO) and nvl(a.OB_TRN_YN,'N')='N') and (nvl(a.CHQ_RECEIVE\
D_YN,'N')='N' or (nvl(a.CHQ_RECEIVED_YN,'N')='Y' and trunc(a.CHQ_RECEIVED_DATE\
)>to_date(:b1,'dd/mm/yyyy')))) and a.RECOUPED_VR_NO is  not null ) and trunc(b\
.CB_DATE)<=to_date(:b1,'dd/mm/yyyy'))           ";

 static const char *sq0010 = 
"select ((NVL(all_doc_type_code,org_doc_type_code)||'-')||TO_CHAR(NVL(all_doc\
_num,org_doc_num))) doc_type  from bl_patient_ledger where ((operating_facilit\
y_id=:b0 and ((ad_pr_adj_bill_doc_type,ad_pr_adj_bill_doc_num) in (select all_\
doc_type_code ,all_doc_num  from bl_patient_ledger where (((operating_facility\
_id=:b0 and org_doc_type_code=:b2) and org_doc_num=:b3) and recpt_nature_code \
in ('BI','DC'))) or ((org_doc_type_code=:b2 and org_doc_num=:b3) and recpt_nat\
ure_code in ('AD','PR','RD')))) and nvl(trx_status,'X')<>'C') order by 1      \
      ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,169,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,204,0,0,0,0,0,1,0,
51,0,0,10,0,0,13,363,0,0,1,0,0,1,0,2,9,0,0,
70,0,0,3,174,0,9,380,0,0,0,0,0,1,0,
85,0,0,4,471,0,9,384,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
112,0,0,5,365,0,9,388,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
139,0,0,6,513,0,9,392,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
166,0,0,7,371,0,9,396,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
193,0,0,8,513,0,9,400,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
220,0,0,9,514,0,9,404,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
247,0,0,3,0,0,13,417,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,
274,0,0,11,158,0,4,444,0,0,2,0,0,1,0,2,3,0,0,2,3,0,0,
297,0,0,12,282,0,4,456,0,0,7,2,0,1,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,1,
9,0,0,1,9,0,0,
340,0,0,13,264,0,4,465,0,0,3,2,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,
367,0,0,14,245,0,4,474,0,0,6,2,0,1,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,1,9,0,0,1,
9,0,0,
406,0,0,15,263,0,4,481,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
437,0,0,5,0,0,13,558,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
460,0,0,10,550,0,9,609,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
499,0,0,10,0,0,15,622,0,0,0,0,0,1,0,
514,0,0,4,0,0,13,745,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,
561,0,0,6,0,0,13,936,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
584,0,0,16,36,0,4,969,0,0,2,1,0,1,0,1,4,0,0,2,4,0,0,
607,0,0,7,0,0,13,991,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
630,0,0,8,0,0,13,1026,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
653,0,0,9,0,0,13,1044,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
676,0,0,17,181,0,4,1301,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,
715,0,0,18,96,0,4,1397,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
738,0,0,19,162,0,6,1404,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00249.PC                                  */
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
			bl_doc_date				        [30],
			bl_payer_name		            [61],
			bl_doc_num						[30],
			bl_pmn_cancel_trx_date          [30],
			bl_acct_code                    [11],
			bl_cancel_ind				    [2],
			bl_ob_vch_desc					[30],
			bl_ob_chq_desc					[30],
			bl_cb_vch_desc					[30],
			bl_cb_vch_desc_cur				[30],
			bl_cb_chq_desc					[30],
			cashbook_ob_date				[11],
			l_pk_value						[100],
			l_currency						[10],
			cashbook_cb_date				[11],
			l_translated_value				[201],
			bl_main_acc_code			    [11],
			bl_main_acc_code_desc				[20],
			bl_ext_accode_1					[11],
			bl_ext_accode_2					[11],
			bl_ext_accode_3					[11],
			bl_ext_accode_4					[11],
			bl_ext_accode_desc1				[20],
			bl_ext_accode_desc2				[20],
			bl_ext_accode_desc3				[20],
			bl_ext_accode_desc4				[20],
			d_ref_doc_type_code				[10],
			d_ref_doc_num					[20],
			d_dep_doc_num					[18],
			nd_date_month                   [5],
			p_language_id                   [3]; */ 
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

struct { unsigned short len; unsigned char arr[30]; } bl_doc_date;

struct { unsigned short len; unsigned char arr[61]; } bl_payer_name;

struct { unsigned short len; unsigned char arr[30]; } bl_doc_num;

struct { unsigned short len; unsigned char arr[30]; } bl_pmn_cancel_trx_date;

struct { unsigned short len; unsigned char arr[11]; } bl_acct_code;

struct { unsigned short len; unsigned char arr[2]; } bl_cancel_ind;

struct { unsigned short len; unsigned char arr[30]; } bl_ob_vch_desc;

struct { unsigned short len; unsigned char arr[30]; } bl_ob_chq_desc;

struct { unsigned short len; unsigned char arr[30]; } bl_cb_vch_desc;

struct { unsigned short len; unsigned char arr[30]; } bl_cb_vch_desc_cur;

struct { unsigned short len; unsigned char arr[30]; } bl_cb_chq_desc;

struct { unsigned short len; unsigned char arr[11]; } cashbook_ob_date;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[10]; } l_currency;

struct { unsigned short len; unsigned char arr[11]; } cashbook_cb_date;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[11]; } bl_main_acc_code;

struct { unsigned short len; unsigned char arr[20]; } bl_main_acc_code_desc;

struct { unsigned short len; unsigned char arr[11]; } bl_ext_accode_1;

struct { unsigned short len; unsigned char arr[11]; } bl_ext_accode_2;

struct { unsigned short len; unsigned char arr[11]; } bl_ext_accode_3;

struct { unsigned short len; unsigned char arr[11]; } bl_ext_accode_4;

struct { unsigned short len; unsigned char arr[20]; } bl_ext_accode_desc1;

struct { unsigned short len; unsigned char arr[20]; } bl_ext_accode_desc2;

struct { unsigned short len; unsigned char arr[20]; } bl_ext_accode_desc3;

struct { unsigned short len; unsigned char arr[20]; } bl_ext_accode_desc4;

struct { unsigned short len; unsigned char arr[10]; } d_ref_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } d_ref_doc_num;

struct { unsigned short len; unsigned char arr[18]; } d_dep_doc_num;

struct { unsigned short len; unsigned char arr[5]; } nd_date_month;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

			

char        d_dep_doc_num_arr[7][20];


int			i, j;

double  bl_doc_amt			,
		bl_ob_chq_amt		,
		bl_ob_vch_amt		,
		bl_cb_chq_amt		,
		bl_cb_vch_amt		,
		bl_cb_vch_amt_cur   ,
		ob_voting_limit     ,  
		cb_voting_limit     ,
		ob_cash_in_hand	    ,
		cb_cash_in_hand_amt ,
		tot_rcp_amt 		,
		tot_refund_amt 		,
		cb_tot_vch_amt  	,  
		cb_tot_chq_amt		,
		tot_ob_amt			,
		ob_tot_chq_amt      ,
		ob_tot_vch_amt		,
		cb_recpmnt_vr_amt	,
		ob_cash_in_hand		,
		tot_close_bal		,
		
		first_col_tot	=0,
		second_col_tot	=0,
		third_col_tot	=0,
		fourth_col_tot	=0,
		others_col_tot  =0,

		bl_doc_amt1	=0,
		bl_doc_amt2	=0,
		bl_doc_amt3	=0,
		bl_doc_amt4	=0,
		oth_amt	=0;


int	    bl_acc_seq;
int     bl_main_seq;
int     seq_order;
int     ext_count;
int     oth_count;
int     page_count;
int		op_err_flag;
int     rec_count =0;
int     rec_reached =0;
int		l_cb_vch_cnt =1; 
int		l_cb_chq_cnt =1;
int		l_ob_chq_cnt =1;
int		l_ob_vch_cnt =1;

char filename[150];
char x_msg[200];
int	 i,j=0;
char loc_legend[999][201];

char loc_legend150[999][201];
char loc_legend160[999][201];

char l_mesg[200];


int ctr = 0,  len = 0,len1 = 0;
int r_ctr = 0;
int r_ctr1 = 0;
char l_string[300];
char cl_string[300];
char cl_string1[300];



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

    strcpy(g_pgm_id,"BLR00249");
    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);

    /* EXEC sql connect :nd_pwd; */ 

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
    sqlstm.sqlcmax = (unsigned int )100;
    sqlstm.sqlcmin = (unsigned int )2;
    sqlstm.sqlcincr = (unsigned int )1;
    sqlstm.sqlctimeout = (unsigned int )0;
    sqlstm.sqlcnowait = (unsigned int )0;
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

		strcpy(p_language_id.arr,l_language_id.arr);
	    p_language_id.len = l_language_id.len;
 
    	strcpy(cashbook_ob_date.arr,argv[5]);

    	cashbook_ob_date.len = strlen(cashbook_ob_date.arr);
    	strcpy(cashbook_cb_date.arr,argv[6]);
    	cashbook_cb_date.len = strlen(cashbook_cb_date.arr);

        process_report();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}
   
process_report()
{
    	        declare_cur();
		open_cursors();
		open_file();
		fetch_legend_value();
		fetch_hosp_name();
		fetch_open_close_bal();  

		fprintf(fp,"%c",0x0F); /*** set Dot-matrix printer to compressed mode ***/
		print_head();
		print_rec();
	        end_of_rep();
	 	fprintf(fp,"%c",0x12); /*** Set Dot-matrix Printer to Normal Mode ***/

}


declare_cur()   
{
     /* EXEC SQL DECLARE SEQ_EXTACCT CURSOR FOR 
		      select  account_code ,
			          CASHBK_RFND_ACCT_SEQ,
				  CASHBK_RFND_ACCT_COL_DESC
			  from 	  BL_EXT_ACCT_CODE
			  where   CASHBK_RFND_ACCT_SEQ  is not null
			  order by CASHBK_RFND_ACCT_SEQ; */ 


     /* EXEC SQL DECLARE DETAIL_CUR CURSOR FOR 
		      select  to_char(DOC_DATE,'dd/mm/yyyy'), 
					  substr(PAYER_NAME,1,40),
					  doc_type_code||'/'||doc_number||decode(CANCEL_AUTH_BY_ID,null,'','(C)') docnum, 
					  nvl(doc_amt,0), 
					  EXT_ACCT_CODE, cancelled_ind,
					  doc_type_code,
					  doc_number
			  from    BL_RECPT_REFUND_CAN_BOU_DTL_VW
			  where   operating_facility_id = :nd_facility	
			  and	  trunc(doc_date) >= to_date(:cashbook_ob_date,'dd/mm/yyyy')
			  and     trunc(doc_date) <= to_date(:cashbook_cb_date,'dd/mm/yyyy')
			  and     CASH_SLMT_FLAG = 'Y'
			  and 	  RECPT_REFUND_IND ='F'
			  order by doc_date ; */ 

    
     /* EXEC SQL DECLARE ob_chqinhnd CURSOR FOR 
		      select  CHQ_NO||'-'|| to_char(CHQ_DATE,'dd/mm/yyyy') rcpt_desc,
 					  nvl(DOC_AMT,0) DOC_AMT
 			  from 	  bl_cash_refund_cycle_trn
 			  where   operating_facility_id = :nd_facility	
 			  and	  nvl(CHQ_RECEIVED_YN,'N') = 'Y' 
			  and    CHQ_RECEIVED_DATE <= to_date(:cashbook_ob_date,'dd/mm/yyyy')
			  and    (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y' and CHQ_CLEARED_DATE >= to_date(:cashbook_ob_date,'dd/mm/yyyy'))); */ 

//10/04/2005		  and    (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y' and CHQ_CLEARED_DATE >= to_date(:cashbook_cb_date,'dd/mm/yyyy')));

    
     /* EXEC SQL DECLARE ob_vchinhnd cursor for
			  select  a.RECOUPED_VR_NO rcpt_desc, 
					  nvl(a.DOC_AMT,0) DOC_AMT
			  from 	  bl_cash_refund_cycle_trn a, bl_cash_refund_cashbook_cb b
			  where   a.operating_facility_id = :nd_facility	
			  and b.operating_facility_id = a.operating_facility_id
			  and a.RECOUPED_VR_NO = b.cb_RECOUPED_VR_NO
			  and 	  nvl(a.OB_TRN_YN,'N')='N'    
			  and     (nvl(a.CHQ_RECEIVED_YN,'N') = 'N' or
					  (nvl(a.CHQ_RECEIVED_YN,'N') = 'Y' 
			  and	  trunc(a.CHQ_RECEIVED_DATE) > to_date(:cashbook_ob_date,'dd/mm/yyyy')))
			  and     a.RECOUPED_VR_NO is not null       
			  //and     trunc(a.VR_DATE) < to_date(:cashbook_ob_date,'dd/mm/yyyy');
			  and     trunc(b.CB_DATE) < to_date(:cashbook_ob_date,'dd/mm/yyyy'); */ 


// 09/08/2005		  and     trunc(VR_DATE) <= to_date(:cashbook_ob_date,'dd/mm/yyyy');
//10/04/2005		  and     trunc(VR_DATE) < to_date(:cashbook_ob_date,'dd/mm/yyyy');			  

     /* EXEC SQL DECLARE Cb_chqinhnd cursor for
			  select  CHQ_NO||'-'||to_char(CHQ_DATE,'dd/mm/yyyy') rcpt_desc,
 					  nvl(DOC_AMT,0) DOC_AMT
 			  from    bl_cash_refund_cycle_trn
 			  where   operating_facility_id = :nd_facility	
 			  and	  nvl(CHQ_RECEIVED_YN,'N') = 'Y' 
 			  and     CHQ_RECEIVED_DATE <= to_date(:cashbook_cb_date,'dd/mm/yyyy')
			  and     (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y' 
					and  trunc(CHQ_CLEARED_DATE) > to_date(:cashbook_cb_date,'dd/mm/yyyy'))); */ 


	/* EXEC SQL DECLARE  Cb_vchinhnd cursor for
			 select	  a.RECOUPED_VR_NO rcpt_desc,
				  nvl(a.DOC_AMT,0) DOC_AMT
			 from 	  bl_cash_refund_cycle_trn a, bl_cash_refund_cashbook_cb b
			 where	  a.operating_facility_id = :nd_facility	
			 and b.operating_facility_id = a.operating_facility_id
			  and a.RECOUPED_VR_NO = b.cb_RECOUPED_VR_NO
			 and	  nvl(a.OB_TRN_YN,'N')='N'    
			 and	  (nvl(a.CHQ_RECEIVED_YN,'N') = 'N' or
				  (nvl(a.CHQ_RECEIVED_YN,'N') = 'Y' 			 
			// and	  trunc(a.CHQ_RECEIVED_DATE) <= to_date(:cashbook_cb_date,'dd/mm/yyyy')))  // on 03/08/06
			 and	  trunc(a.CHQ_RECEIVED_DATE) > to_date(:cashbook_cb_date,'dd/mm/yyyy')))
			 and	  a.RECOUPED_VR_NO is not null        
			 //and	  trunc(a.VR_DATE) < to_date(:cashbook_cb_date,'dd/mm/yyyy');
			and	  trunc(b.CB_DATE) < to_date(:cashbook_cb_date,'dd/mm/yyyy'); */ 
	
		//	 and	  trunc(a.VR_DATE) <= to_date(:cashbook_cb_date,'dd/mm/yyyy');
//10/04/2005		 and	  trunc(a.VR_DATE) < to_date(:cashbook_cb_date,'dd/mm/yyyy');

	/* EXEC SQL DECLARE  Cb_vchinhnd_curr 	cursor for
			 select	  a.RECOUPED_VR_NO rcpt_desc,
					  nvl(a.DOC_AMT,0) DOC_AMT
			 from 	  bl_cash_refund_cycle_trn a, bl_cash_refund_cashbook_cb b
			 where	  a.operating_facility_id = :nd_facility	
			 and b.operating_facility_id = a.operating_facility_id
			  and a.RECOUPED_VR_NO = b.cb_RECOUPED_VR_NO
			 and	  nvl(a.OB_TRN_YN,'N')='N'    
			 and	  (nvl(a.CHQ_RECEIVED_YN,'N') = 'N' or
					  (nvl(a.CHQ_RECEIVED_YN,'N') = 'Y' 
			 and	  trunc(a.CHQ_RECEIVED_DATE) > to_date(:cashbook_cb_date,'dd/mm/yyyy')))
			 and	  a.RECOUPED_VR_NO is not null        
			// and	  trunc(a.VR_DATE) <= to_date(:cashbook_cb_date,'dd/mm/yyyy');
			 and	  trunc(b.CB_DATE) <= to_date(:cashbook_cb_date,'dd/mm/yyyy'); */ 

//10/04/2005		 and	  trunc(a.VR_DATE) = to_date(:cashbook_cb_date,'dd/mm/yyyy');

/* EXEC SQL  DECLARE  DEP_DETAILS CURSOR FOR
	SELECT NVL(all_doc_type_code,org_doc_type_code)||'-'|| 
	       TO_CHAR(NVL(all_doc_num,org_doc_num)) doc_type
	FROM bl_patient_ledger
	WHERE operating_facility_id = :nd_facility
			AND
			(
		   (
		     (ad_pr_adj_bill_doc_type,ad_pr_adj_bill_doc_num) IN 
			     (	
			     		SELECT all_doc_type_code, all_doc_num 
			     		FROM bl_patient_ledger
			      	WHERE operating_facility_id = :nd_facility
			      	AND org_doc_type_code =  :d_ref_doc_type_code
			      	AND org_doc_num =  :d_ref_doc_num
			      	AND recpt_nature_code in ( 'BI','DC')
			     )
		   )
	     OR
		   (
		    org_doc_type_code = :d_ref_doc_type_code AND 
		    org_doc_num = :d_ref_doc_num 
		    AND recpt_nature_code in ('AD','PR','RD')
		   )	 
	    )
	AND nvl(trx_status,'X')   !=  'C'	
	ORDER BY 1; */ 

	
}

fetch_dep_dtls()
{
    d_dep_doc_num.arr[0]	= '\0';
    d_dep_doc_num.len		= 0;
 

    
	/* EXEC SQL FETCH DEP_DETAILS 
	INTO  :d_dep_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_dep_doc_num;
 sqlstm.sqhstl[0] = (unsigned int  )20;
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
		err_mesg("FETCH failed on cursor fetch_dep_dtls",0,"");

		if(NO_DATA_FOUND)
		return 0;
	
    d_dep_doc_num.arr[d_dep_doc_num.len] = '\0';
   
    return 1;

}

open_cursors() 
{
    /* EXEC SQL OPEN SEQ_EXTACCT; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0003;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )70;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor SEQ_EXTACCT",0,"");

    /* EXEC SQL OPEN DETAIL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )85;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&cashbook_ob_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&cashbook_cb_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
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
         err_mesg("OPEN failed on cursor DETAIL_CUR",0,"");

    /* EXEC SQL OPEN ob_chqinhnd; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )112;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&cashbook_ob_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&cashbook_ob_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
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
         err_mesg("OPEN failed on cursor ob_chqinhnd",0,"");

    /* EXEC SQL OPEN ob_vchinhnd; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )139;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&cashbook_ob_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&cashbook_ob_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
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
         err_mesg("OPEN failed on cursor ob_vchinhnd",0,"");

    /* EXEC SQL OPEN Cb_chqinhnd; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )166;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&cashbook_cb_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&cashbook_cb_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
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
         err_mesg("OPEN failed on cursor Cb_chqinhnd",0,"");
	
	/* EXEC SQL OPEN Cb_vchinhnd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )193;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cashbook_cb_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&cashbook_cb_date;
 sqlstm.sqhstl[2] = (unsigned int  )13;
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
         err_mesg("OPEN failed on cursor Cb_vchinhnd",0,"");

	/* EXEC SQL OPEN Cb_vchinhnd_curr; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )220;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cashbook_cb_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&cashbook_cb_date;
 sqlstm.sqhstl[2] = (unsigned int  )13;
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
         err_mesg("OPEN failed on cursor Cb_vchinhnd_curr",0,"");
}

fetch_ext_acc_seq()
{
   bl_main_acc_code.arr[0] = '\0';
   bl_main_acc_code_desc.arr[0] = '\0';
   bl_main_acc_code.len = 0;
   bl_main_acc_code_desc.len = 0;
   bl_main_seq  =0;

      /* EXEC SQL FETCH SEQ_EXTACCT
               INTO :bl_main_acc_code,
		    :bl_main_seq,
		    :bl_main_acc_code_desc; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 4;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )247;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
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
      sqlstm.sqhstv[2] = (         void  *)&bl_main_acc_code_desc;
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
           err_mesg("FETCH failed on cursor SEQ_EXTACCT",0,"");

   bl_main_acc_code.arr[bl_main_acc_code.len] = '\0';
   bl_main_acc_code_desc.arr[bl_main_acc_code_desc.len] ='\0';

 return(LAST_ROW?0:1);
}


fetch_open_close_bal()
{
   ob_tot_chq_amt  = 0; 
   ob_tot_vch_amt  = 0;
   ob_cash_in_hand = 0;  
   cb_cash_in_hand_amt =0;
   cb_tot_chq_amt  = 0;
   cb_tot_vch_amt  = 0;
   tot_ob_amt = 0;
   ext_count  = 0;
   oth_count  = 0;

	/* EXEC SQL select  sum(decode(nvl(CASHBK_RFND_ACCT_SEQ,9),9,0,1)) EXT_COUNT, 
					 sum(decode(nvl(CASHBK_RFND_ACCT_SEQ,9),9,1,0)) NUL_COUNT
			 into    :ext_count, :oth_count
			 from 	 BL_EXT_ACCT_CODE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select sum(decode(nvl(CASHBK_RFND_ACCT_SEQ,9),9,0,1)) EXT_CO\
UNT ,sum(decode(nvl(CASHBK_RFND_ACCT_SEQ,9),9,1,0)) NUL_COUNT into :b0,:b1  fr\
om BL_EXT_ACCT_CODE ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )274;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ext_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&oth_count;
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


/*			 where   account_code in (select distinct ext_acct_code
									   from  bl_recpt_refund_can_bou_dtl_vw
									   where operating_facility_id = :nd_facility	
									   and	 trunc(doc_date) >= to_date(:cashbook_ob_date,'dd/mm/yyyy')
									   and   trunc(doc_date) <= to_date(:cashbook_cb_date,'dd/mm/yyyy')
									   and   cash_slmt_flag = 'Y'
									   and 	 RECPT_REFUND_IND ='F');
*/
	/* EXEC SQL select  to_char(CB_DATE+1,'ddmm'),nvl(CB_CASH_IN_HAND_AMT,0), NVL(CB_VOTING_LIMIT_AMT,0),nvl(CB_CHQ_IN_HAND_AMT,0), nvl(CB_VOUCHER_IN_HAND_AMT,0)
			 into 	 :nd_date_month,:ob_cash_in_hand, :ob_voting_limit, :ob_tot_chq_amt, :ob_tot_vch_amt
			 from 	 bl_cash_refund_cashbook_cb
			 where	 operating_facility_id = :nd_facility	
			 and	 CB_DATE =  to_date(:cashbook_ob_date,'dd/mm/yyyy') -1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select to_char((CB_DATE+1),'ddmm') ,nvl(CB_CASH_IN_HAND_AMT,\
0) ,NVL(CB_VOTING_LIMIT_AMT,0) ,nvl(CB_CHQ_IN_HAND_AMT,0) ,nvl(CB_VOUCHER_IN_H\
AND_AMT,0) into :b0,:b1,:b2,:b3,:b4  from bl_cash_refund_cashbook_cb where (op\
erating_facility_id=:b5 and CB_DATE=(to_date(:b6,'dd/mm/yyyy')-1))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )297;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_date_month;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ob_cash_in_hand;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ob_voting_limit;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ob_tot_chq_amt;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&ob_tot_vch_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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
 sqlstm.sqhstv[6] = (         void  *)&cashbook_ob_date;
 sqlstm.sqhstl[6] = (unsigned int  )13;
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


	
	if NOT_FOUND
	     {
             op_err_flag =1;
			 /* EXEC SQL select sum(nvl(doc_amt,0))
					  into   :ob_tot_chq_amt
			 from	  bl_cash_refund_cycle_trn
			 where    recouped_vr_no is null
			 and      chq_received_date <= to_date(:cashbook_ob_date,'dd/mm/yyyy')
		     and      (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y' and CHQ_CLEARED_DATE >= to_date(:cashbook_ob_date,'dd/mm/yyyy'))); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select sum(nvl(doc_amt,0)) into :b0  from bl_cash_refund_\
cycle_trn where ((recouped_vr_no is null  and chq_received_date<=to_date(:b1,'\
dd/mm/yyyy')) and (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y'\
 and CHQ_CLEARED_DATE>=to_date(:b1,'dd/mm/yyyy'))))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )340;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&ob_tot_chq_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&cashbook_ob_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&cashbook_ob_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
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


//10/4/2005	     and      (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y' and CHQ_CLEARED_DATE >= to_date(:cashbook_cb_date,'dd/mm/yyyy')));
		 }

	/* EXEC SQL select  nvl(CB_VOTING_LIMIT_AMT,0), nvl(CB_CHQ_IN_HAND_AMT,0), nvl(CB_VOUCHER_IN_HAND_AMT,0),
					 nvl(CB_CASH_IN_HAND_AMT,0)
			 into 	 :cb_voting_limit, :cb_tot_chq_amt, :cb_tot_vch_amt, :cb_cash_in_hand_amt
			 from 	 bl_cash_refund_cashbook_cb 
			 where   operating_facility_id = :nd_facility	
 			 and     CB_DATE =  to_date(:cashbook_cb_date,'dd/mm/yyyy'); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select nvl(CB_VOTING_LIMIT_AMT,0) ,nvl(CB_CHQ_IN_HAND_AMT,0)\
 ,nvl(CB_VOUCHER_IN_HAND_AMT,0) ,nvl(CB_CASH_IN_HAND_AMT,0) into :b0,:b1,:b2,:\
b3  from bl_cash_refund_cashbook_cb where (operating_facility_id=:b4 and CB_DA\
TE=to_date(:b5,'dd/mm/yyyy'))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )367;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cb_voting_limit;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cb_tot_chq_amt;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&cb_tot_vch_amt;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&cb_cash_in_hand_amt;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
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
 sqlstm.sqhstv[5] = (         void  *)&cashbook_cb_date;
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


  
    /* EXEC SQL select  count(*)
			 into    :rec_count
			  from    BL_RECPT_REFUND_CAN_BOU_DTL_VW
			  where   operating_facility_id = :nd_facility	
			  and	  trunc(doc_date) >= to_date(:cashbook_ob_date,'dd/mm/yyyy')
			  and     trunc(doc_date) <= to_date(:cashbook_cb_date,'dd/mm/yyyy')
			  and     cash_slmt_flag = 'Y'
			  and 	  RECPT_REFUND_IND ='F'
			  order by doc_date ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from BL_RECPT_REFUND_CAN_BOU_D\
TL_VW where ((((operating_facility_id=:b1 and trunc(doc_date)>=to_date(:b2,'dd\
/mm/yyyy')) and trunc(doc_date)<=to_date(:b3,'dd/mm/yyyy')) and cash_slmt_flag\
='Y') and RECPT_REFUND_IND='F') order by doc_date ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )406;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rec_count;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
    sqlstm.sqhstv[2] = (         void  *)&cashbook_ob_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&cashbook_cb_date;
    sqlstm.sqhstl[3] = (unsigned int  )13;
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



	//tot_ob_amt = ob_cash_in_hand + ob_tot_chq_amt + ob_tot_vch_amt;  
	  tot_ob_amt = ob_cash_in_hand;
    
       if (OERROR)
            err_mesg("FETCH failed on fetch_open_close_bal()",0,"");

   return(LAST_ROW?0:1);
}   

print_rec()  
{
    print_open_cashinhnd();
    print_ob_chqinhnd();
    print_ob_vchinhnd();
    print_day_details();
    print_close_cashinhnd();
    print_cb_chqinhnd();
    print_cb_vchinhnd();
    print_cb_vchinhnd_cur();
    print_close_total(2);	
}  

print_open_cashinhnd()  
{ 
    
	check_page_end(0, 2);

if (strcmp(nd_date_month.arr, "0101") == 0)   
{
		fprintf(fp,"%-50s %6s %-15s ",loc_legend[281],l_currency.arr,loc_legend[282]);   
		fprintf(fp,"\n");
		fprintf(fp,"%-50s",loc_legend[283]);   
		fprintf(fp,"\n");
		lctr =lctr+2;


}
	fprintf(fp,"%-10.10s %-36.36s ",cashbook_ob_date.arr,loc_legend[180]);
	print_formated(ob_cash_in_hand,15);
	fprintf(fp,"\n");
	lctr++;
}

print_ob_chqinhnd()
{
  while(fetch_ob_chqinhnd())
  {
   check_page_end(0, 2);
   if (l_ob_chq_cnt == 1)
    	fprintf(fp,"%25.25s %-20.20s  ",loc_legend[190],bl_ob_chq_desc.arr);
   else
	fprintf(fp,"%-10.10s%-15.15s %-20.20s  ","","",bl_ob_chq_desc.arr);

   print_formated(bl_ob_chq_amt,15);
   tot_ob_amt += bl_ob_chq_amt;
   fprintf(fp,"\n");
   lctr++;
   l_ob_chq_cnt++;
  }
} 

fetch_ob_chqinhnd()
{
 bl_ob_chq_desc.arr[0]		= '\0';
 bl_ob_chq_desc.len		= 0;
 bl_ob_chq_amt =0;  

    /* EXEC SQL FETCH ob_chqinhnd  
             INTO  :bl_ob_chq_desc,
				   :bl_ob_chq_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )437;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_ob_chq_desc;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_ob_chq_amt;
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
            err_mesg("FETCH failed on cursor ob_chqinhnd",0,"");

	bl_ob_chq_desc.arr[bl_ob_chq_desc.len]              = '\0';

    return(LAST_ROW?0:1);
}

print_ob_vchinhnd()
{
  while(fetch_ob_vchinhnd())
  {				
    check_page_end(0, 2);
    if (l_ob_vch_cnt == 1)
	  	fprintf(fp,"%25.25s %-21.21s ",loc_legend[200],bl_ob_vch_desc.arr);
	else
		fprintf(fp,"%25.25s %-21.21s ","",bl_ob_vch_desc.arr);

	print_formated(bl_ob_vch_amt,15);
	tot_ob_amt += bl_ob_vch_amt;
	fprintf(fp,"\n");
	lctr++;
	l_ob_vch_cnt++;
  }
}    

print_day_details()
{ 
   tot_refund_amt= 0;

        

  while(fetch_hdr())
  {
                   ctr = 0;
					r_ctr = 0;
					r_ctr1 = 0;


     for (i=1;i<=10; i++)
	{
	for (j=0;j<=10;j++)
	{
		d_dep_doc_num_arr[i][j] = '\0';
	}
	}        

     /* EXEC SQL OPEN DEP_DETAILS; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )460;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_facility;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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
     sqlstm.sqhstv[2] = (         void  *)&d_ref_doc_type_code;
     sqlstm.sqhstl[2] = (unsigned int  )12;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_ref_doc_num;
     sqlstm.sqhstl[3] = (unsigned int  )22;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_ref_doc_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )12;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_ref_doc_num;
     sqlstm.sqhstl[5] = (unsigned int  )22;
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
     err_mesg("OPEN failed on cursor DEP_DETAILS",0,"");

     i=1;

     while(fetch_dep_dtls())
     {
	strcpy(d_dep_doc_num_arr[i],d_dep_doc_num.arr);	
	i++;
     }     	

     /* EXEC SQL CLOSE DEP_DETAILS; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )499;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if(OERROR)	   
     err_mesg("CLOSE failed on cursor DEP_DETAILS",0,"");


        //check_page_end(0, 4);
		check_page_end(4,1);
	fprintf(fp,"%63.63s %-10.10s  "," ",bl_doc_date.arr);
//--------------------------------	

	len1 = strlen(bl_payer_name.arr);
					split_text(bl_payer_name.arr, 15, cl_string1, &r_ctr1);
					//check_page_end(0, 1);   Commented on 3/7/2006
					fprintf(fp,"%-15.15s",cl_string1);
				//	lctr++;
					strcpy(cl_string1,"");

fprintf(fp,"%5.5s%-15.15s %-15.15s "," ",bl_doc_num.arr,d_dep_doc_num_arr[1]);

//-------------------------------------------

	proc_set_col_pos();


   print_formated(bl_doc_amt,15);


	tot_refund_amt= tot_refund_amt + bl_doc_amt;

        rec_reached++;
	
	fprintf(fp,"\n");
		lctr++;
//	--------------
   	print_payer_name();
	//---------------------
 	//lctr++;

	if (d_dep_doc_num_arr[2][0] != '\0')  
	{

		check_page_end(0, 2);
		fprintf(fp,"%63.63s %-10.10s %-20.20s %-15.15s %-15.15s ",
		     " ","", "", "",d_dep_doc_num_arr[2]);
	
	fprintf(fp,"\n");
 	lctr++;
	}

	if (d_dep_doc_num_arr[3][0] != '\0')  
	{

		check_page_end(0, 2);
		fprintf(fp,"%63.63s %-10.10s %-20.20s %-15.15s %-15.15s ",
		     " ","", "", "",d_dep_doc_num_arr[3]);
	
	fprintf(fp,"\n");
 	lctr++;
	}

	if (d_dep_doc_num_arr[4][0] != '\0')  
	{

		check_page_end(0, 2);
		fprintf(fp,"%63.63s %-10.10s %-20.20s %-15.15s %-15.15s ",
		     " ","", "", "",d_dep_doc_num_arr[4]);
	
	fprintf(fp,"\n");
 	lctr++;
	}

	if (d_dep_doc_num_arr[5][0] != '\0')  
	{

		check_page_end(0, 2);
		fprintf(fp,"%63.63s %-10.10s %-20.20s %-15.15s %-15.15s ",
		     " ","", "", "",d_dep_doc_num_arr[5]);
	
	fprintf(fp,"\n");
 	lctr++;
	}
  }   
}

print_payer_name()
{
  		   
					while(r_ctr1 < len1)
					{	
						split_text(bl_payer_name.arr,60,cl_string1,&r_ctr1);
						//check_page_end(0, 1);
						fprintf(fp,"%76s%-15.15s\n"," ",cl_string1);
						strcpy(cl_string1,"");  
							lctr++;
					}
					r_ctr1=0;

       }


fetch_hdr()   
{
 bl_doc_date.arr[0]		= '\0';
 bl_payer_name.arr[0]	= '\0';
 bl_doc_num.arr[0]		= '\0';
 bl_acct_code.arr[0]	= '\0';
 bl_cancel_ind.arr[0]	= '\0';

 bl_doc_date.len		= 0;
 bl_payer_name.len		= 0;
 bl_doc_num.len			= 0;
 bl_acct_code.len		= 0;
 bl_cancel_ind.len		= 0;

 bl_doc_amt				= 0;

 d_ref_doc_type_code.arr[0] = '\0';
 d_ref_doc_type_code.len = 0;

 d_ref_doc_num.arr[0] = '\0';
 d_ref_doc_num.len = 0;

      /* EXEC SQL FETCH DETAIL_CUR
               INTO :bl_doc_date,
			:bl_payer_name,
			:bl_doc_num ,
			:bl_doc_amt,
			:bl_acct_code,
			:bl_cancel_ind,
			:d_ref_doc_type_code,
			:d_ref_doc_num; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )514;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&bl_doc_date;
      sqlstm.sqhstl[0] = (unsigned int  )32;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_payer_name;
      sqlstm.sqhstl[1] = (unsigned int  )63;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )32;
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
      sqlstm.sqhstv[5] = (         void  *)&bl_cancel_ind;
      sqlstm.sqhstl[5] = (unsigned int  )4;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_ref_doc_type_code;
      sqlstm.sqhstl[6] = (unsigned int  )12;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_ref_doc_num;
      sqlstm.sqhstl[7] = (unsigned int  )22;
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
            err_mesg("FETCH failed on cursor DETAIL_CUR",0,"");

bl_doc_date.arr[bl_doc_date.len]              = '\0';
bl_payer_name.arr[bl_payer_name.len]          = '\0';
bl_doc_num.arr[bl_doc_num.len]		      = '\0';
bl_acct_code.arr[bl_acct_code.len]	      = '\0';
bl_cancel_ind.arr[bl_cancel_ind.len]	      = '\0';
d_ref_doc_type_code.arr[d_ref_doc_type_code.len]  = '\0';
d_ref_doc_num.arr[d_ref_doc_num.len]		  = '\0';

    return(LAST_ROW?0:1);
}

proc_set_col_pos()
{
   if (strcmp(bl_acct_code.arr, bl_ext_accode_1.arr) == 0)   
           proc_column_pos(1);
   else
     if (strcmp(bl_acct_code.arr, bl_ext_accode_2.arr) == 0)
	      proc_column_pos(2);
   else
     if (strcmp(bl_acct_code.arr, bl_ext_accode_3.arr) == 0)
      proc_column_pos(3);
   else
     if (strcmp(bl_acct_code.arr, bl_ext_accode_4.arr) == 0)
      proc_column_pos(4);
   else
	  proc_column_pos(9);
}  

proc_column_pos(flg)
int flg;
{
  int oth_tot_spaces =0; 
  int nflg=0; 
  char dg_log[300];  

   switch(flg)
  {

  case 1:  first_col_tot += bl_doc_amt;
        break;
  
  case 2:  second_col_tot += bl_doc_amt;
            nflg=0;
          if(strcmp(bl_ext_accode_1.arr,"\0")==0)
           nflg=nflg+1;
           oth_tot_spaces = (flg-nflg-1) * 18;
		   sprintf(dg_log,"%%%ds",oth_tot_spaces);
		   fprintf(fp,dg_log," ");
		   break;
  
  case 3:  third_col_tot += bl_doc_amt;
           nflg=0;
		    if(strcmp(bl_ext_accode_1.arr,"\0")==0)
			nflg=nflg+1;
			if(strcmp(bl_ext_accode_2.arr,"\0")==0) 
			nflg=nflg+1;
           oth_tot_spaces = (flg-nflg-1) * 18;
		   sprintf(dg_log,"%%%ds",oth_tot_spaces);
		   fprintf(fp,dg_log," ");
		   break;
  
  case 4:  fourth_col_tot += bl_doc_amt;
           nflg=0;
			if(strcmp(bl_ext_accode_1.arr,"\0")==0)
				nflg=nflg+1;
			if(strcmp(bl_ext_accode_2.arr,"\0")==0) 
				 nflg=nflg+1;
			if(strcmp(bl_ext_accode_3.arr,"\0")==0) 
				nflg=nflg+1;
            oth_tot_spaces = (flg-nflg-1) * 18;
		   sprintf(dg_log,"%%%ds",oth_tot_spaces);
		   fprintf(fp,dg_log," ");
		    break;
  
  case 9:  others_col_tot += bl_doc_amt;
			if(strcmp(bl_ext_accode_1.arr,"\0")==0)
				nflg=nflg+1;
			if(strcmp(bl_ext_accode_2.arr,"\0")==0) 
				 nflg=nflg+1;
			if(strcmp(bl_ext_accode_3.arr,"\0")==0) 
				nflg=nflg+1;
			if(strcmp(bl_ext_accode_4.arr,"\0")==0) 
				nflg=nflg+1;
           oth_tot_spaces = ext_count * 18;
		   sprintf(dg_log,"%%%ds",oth_tot_spaces);
		   fprintf(fp,dg_log," ");
		  
  }
}

check_ext_account()   
{
	while(fetch_ext_acc_seq())
	{
	    if (bl_main_seq == 1 )
	    {
		strcpy(bl_ext_accode_1.arr,bl_main_acc_code.arr);
		strcpy(bl_ext_accode_desc1.arr,bl_main_acc_code_desc.arr);

	    }
	    else if (bl_main_seq == 2)
	    {
		strcpy(bl_ext_accode_2.arr,bl_main_acc_code.arr);
		strcpy(bl_ext_accode_desc2.arr,bl_main_acc_code_desc.arr);
	    }
	    else if (bl_main_seq == 3)
	    {
		strcpy(bl_ext_accode_3.arr,bl_main_acc_code.arr);
		strcpy(bl_ext_accode_desc3.arr,bl_main_acc_code_desc.arr);
	    }
	    else if (bl_main_seq == 4)
	    {
		strcpy(bl_ext_accode_4.arr,bl_main_acc_code.arr);
		strcpy(bl_ext_accode_desc4.arr,bl_main_acc_code_desc.arr);
	    }
      }
}


print_close_total(flg)
int flg;
{
  char t_msg[300];  

      
  if (flg==2)
 {
  fprintf(fp,"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  //fprintf(fp,"                   %26s ",loc_legend[120]);
  
  fprintf(fp,"               %-30.30s ",loc_legend[250]);  
  print_formated(tot_ob_amt,17);

  //fprintf(fp,"          %-39.39s",loc_legend[230], " ");
  fprintf(fp,"          %-39.39s","");
  //print_formated(cb_voting_limit,17);
  fprintf(fp,"%-20.20s","");
  fprintf(fp,"%78.78s","");
  print_formated(cb_voting_limit,17);
  fprintf(fp,"\n");
 }
else
 {
  fprintf(fp,"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  page_total();
 }

  fprintf(fp,"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  lctr= lctr+3;
}

page_total()
{
	fprintf(fp,"           %36.36s "," ");

	print_formated(tot_ob_amt,15);
        
	fprintf(fp,"%-10.10s %-20.20s %-15.15s %-15.15s","","","","");
  	if (bl_ext_accode_1.arr[0] != '\0')
	  print_formated(first_col_tot,15);
	if (bl_ext_accode_2.arr[0] != '\0')
	  print_formated(second_col_tot,16);
	if (bl_ext_accode_3.arr[0] != '\0')
	  print_formated(third_col_tot,16);
	if (bl_ext_accode_4.arr[0] != '\0')
	  print_formated(fourth_col_tot,16);
    if (oth_count != 0)    
	  print_formated(others_col_tot,16);
   fprintf(fp,"\n");
   lctr++;
}	

fetch_ob_vchinhnd()
{
 bl_ob_vch_desc.arr[0]	= '\0';
 bl_ob_vch_desc.len		= 0;
 bl_ob_vch_amt =0;

    /* EXEC SQL FETCH ob_vchinhnd
             INTO  :bl_ob_vch_desc,
				   :bl_ob_vch_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )561;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_ob_vch_desc;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_ob_vch_amt;
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
            err_mesg("FETCH failed on cursor ob_vchinhnd",0,"");

	bl_ob_vch_desc.arr[bl_ob_vch_desc.len]              = '\0';

    return(LAST_ROW?0:1);
}
    
print_close_cashinhnd()  
{ 
   check_page_end(0, 2);


											 
    fprintf(fp,"\n%75.75s %-51.51s "," ", loc_legend[210]);
	
	if (bl_ext_accode_1.arr[0] != '\0')
	  print_formated(first_col_tot,15);
	if (bl_ext_accode_2.arr[0] != '\0')
	  print_formated(second_col_tot,16);
	if (bl_ext_accode_3.arr[0] != '\0')
	  print_formated(third_col_tot,16);
	if (bl_ext_accode_4.arr[0] != '\0')
	  print_formated(fourth_col_tot,16);
    if (oth_count != 0)    
	  print_formated(others_col_tot,16);
    fprintf(fp,"\n");
	lctr++;
	
		/* EXEC SQL select abs(:tot_refund_amt)
				 into :cb_recpmnt_vr_amt from dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select abs(:b0) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )584;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&tot_refund_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&cb_recpmnt_vr_amt;
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



        fprintf(fp,"\n%75.75s %-51.51s %-85.85s"," ", loc_legend[220],"");

   	//fprintf(fp,"\n%65s %-20.20s %78s "," ","Total Refunds for the period", " ");
       print_formated(cb_recpmnt_vr_amt,16);
	fprintf(fp,"\n");
    lctr++;
  	fprintf(fp,"\n%-63.63s %-11.11s %-25.25s %-15.15s"," ",cashbook_cb_date.arr,loc_legend[180], " ");

	fprintf(fp,"%97.97s","");
	print_formated(cb_cash_in_hand_amt,15);
	lctr++;
}
    
fetch_cb_chqinhnd()
{
 bl_cb_chq_desc.arr[0]	= '\0';
 bl_cb_chq_desc.len		= 0;
 bl_cb_chq_amt			= 0;

    /* EXEC SQL FETCH cb_chqinhnd
             INTO  :bl_cb_chq_desc,
				   :bl_cb_chq_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )607;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_cb_chq_desc;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_cb_chq_amt;
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
            err_mesg("FETCH failed on cursor cb_chqinhnd",0,"");

	bl_cb_chq_desc.arr[bl_cb_chq_desc.len]  = '\0';

    return(LAST_ROW?0:1);
}

print_cb_chqinhnd()
{
  while(fetch_cb_chqinhnd())
  {
	check_page_end(0, 2);
   if (l_cb_chq_cnt ==1)
  	fprintf(fp,"\n%-75.75s %-25.25s %-20.20s"," ",loc_legend[190],bl_cb_chq_desc.arr);
   else
  	fprintf(fp,"\n%-74.74s %-26.26s %-20.20s"," "," ",bl_cb_chq_desc.arr);

	fprintf(fp,"%92.92s","");
	print_formated(bl_cb_chq_amt,15);
	lctr++;
    l_cb_chq_cnt++;
  }
}

fetch_cb_vchinhnd()
{
 bl_cb_vch_desc.arr[0]	= '\0';
 bl_cb_vch_desc.len		= 0;
 bl_cb_vch_amt =0;

    /* EXEC SQL FETCH cb_vchinhnd
             INTO  :bl_cb_vch_desc,
		   :bl_cb_vch_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )630;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_cb_vch_desc;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_cb_vch_amt;
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
            err_mesg("FETCH failed on cursor cb_vchinhnd",0,"");

	bl_cb_vch_desc.arr[bl_cb_vch_desc.len]              = '\0';

    return(LAST_ROW?0:1);
}

fetch_cb_vchinhnd_cur()
{
 bl_cb_vch_desc_cur.arr[0]	= '\0';
 bl_cb_vch_desc_cur.len		= 0;
 bl_cb_vch_amt_cur =0;

    /* EXEC SQL FETCH cb_vchinhnd_curr
             INTO  :bl_cb_vch_desc_cur,
				   :bl_cb_vch_amt_cur; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )653;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_cb_vch_desc_cur;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_cb_vch_amt_cur;
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
            err_mesg("FETCH failed on cursor cb_vchinhnd_curr",0,"");

	bl_cb_vch_desc_cur.arr[bl_cb_vch_desc_cur.len]              = '\0';

    return(LAST_ROW?0:1);
}

  
print_cb_vchinhnd()
{
  //double l_cb = 0;

  tot_close_bal =0;
  tot_close_bal = (cb_tot_chq_amt+cb_tot_vch_amt+cb_cash_in_hand_amt)-cb_recpmnt_vr_amt;  

  //l_cb = cb_tot_chq_amt + cb_cash_in_hand_amt;

  while(fetch_cb_vchinhnd())
  {
   //if (l_cb < tot_close_bal)
   //{
    check_page_end(0, 2);
    if (l_cb_vch_cnt == 1)    
    		fprintf(fp,"\n %-74.74s %-25.25s %-24.24s"," ",loc_legend[200],bl_cb_vch_desc.arr);
	else
	  	    fprintf(fp,"\n%-74.74s %-26.26s %-24.24s"," "," ",bl_cb_vch_desc.arr);

	fprintf(fp,"%88.88s","");
	print_formated(bl_cb_vch_amt,15);
	lctr++;

    l_cb_vch_cnt++;
    //}    
    //l_cb = l_cb + bl_cb_vch_amt;
    
  }
    check_page_end(0, 2);
    fprintf(fp,"\n %74.74s %-20.20s %-35.35s "," "," ",""); 
    
    fprintf(fp,"%79.79s","");
    //print_formated(tot_close_bal,17);	


}

print_cb_vchinhnd_cur()
{
  /*
  fetch_cb_vchinhnd_cur();
  if (l_cb_vch_cnt == 1)
     fprintf(fp,"\n%74.74s %-20.20s %-20.20s"," ",loc_legend[200],bl_cb_vch_desc_cur.arr);
  else
     fprintf(fp,"\n%74.74s %-20.20s %-20.20s"," "," ",bl_cb_vch_desc_cur.arr);
  print_formated(bl_cb_vch_amt_cur,15);
  lctr++;
  */
  fprintf(fp,"\n");
  lctr++;
  
}
  

end_of_rep()
{
	fprintf(fp,"\n\n %100s   ***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00249.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00249.lis");
       proc_exit();
    }

  check_ext_account();
}     

print_head()   
{
	char l_str1[1000];	
    int l_space=0;int k=0;
    int rctr=0;  

	print_page_title();
	fprintf(fp,"<-------------------------%-8.8s----------------------------> <--------------------------------------------------------------------------%-7.7s-------------------------------------------------------------------------------------->\n",loc_legend[100],loc_legend[110]);	

//fprintf(fp,"                %-60.60s                                                    %17.17s %17.17s %17.17s %17.17s %17.17s %15.15s\n",loc_legend[120],bl_ext_accode_desc1.arr,bl_ext_accode_desc2.arr,bl_ext_accode_desc3.arr,bl_ext_accode_desc4.arr,loc_legend[170],loc_legend[240]);


//===========================-Code Description(21/06/2005 by Robert)--===================================

  fprintf(fp,"               %-60.60s                                                     ",loc_legend[120]);
 if (bl_ext_accode_desc1.arr[0] != '\0')
	  {
	  fprintf(fp, "%17.17s ",bl_ext_accode_desc1.arr);
       l_space=l_space+17;
       }
	if (bl_ext_accode_desc2.arr[0] != '\0')
	   {
		fprintf(fp, "%17.17s ",bl_ext_accode_desc2.arr);
		l_space=l_space+17;
       }

	if (bl_ext_accode_desc3.arr[0] != '\0')
	  {
		fprintf(fp, "%17.17s ",bl_ext_accode_desc3.arr);
		l_space=l_space+17;
       }
	if (bl_ext_accode_desc4.arr[0] != '\0')
	   {
		fprintf(fp, "%17.17s ",bl_ext_accode_desc4.arr);
		l_space=l_space+17;
       }
fprintf(fp,"%17.17s ",loc_legend[170]);
l_space=l_space+17+8;  
 for(k=0;k<=(90-l_space); k++)
   fprintf(fp," ");  
fprintf(fp,"%11.11s\n",loc_legend[240]);

//=====================================End of Code Description===================================



	r_ctr = 0;
	len = strlen(loc_legend[150]);
	rctr = 0;
	while(r_ctr < len)
	{	
		split_text(loc_legend[150],15,loc_legend150[rctr],&r_ctr);			
		rctr = rctr + 1;
	}

	r_ctr = 0;
	len = strlen(loc_legend[160]);
	rctr = 0;
	while(r_ctr < len)
	{	
		split_text(loc_legend[160],15,loc_legend160[rctr],&r_ctr);			
		rctr = rctr + 1;
	}
	
	fprintf(fp,"%-15.15s           %-31.31s    RM %-10.10s %-20.20s %-15.15s %-15.15s ",loc_legend[30],loc_legend[130],loc_legend[30],loc_legend[140],loc_legend150[0],loc_legend160[0]);

	if (bl_ext_accode_1.arr[0] != '\0')
	  fprintf(fp, "%17.17s ",loc_legend[260]);
	if (bl_ext_accode_2.arr[0] != '\0')
		fprintf(fp, "%17.17s ",loc_legend[260]);
	if (bl_ext_accode_3.arr[0] != '\0')
		fprintf(fp, "%17.17s ",loc_legend[260]);
	if (bl_ext_accode_4.arr[0] != '\0')
		fprintf(fp, "%17.17s ",loc_legend[260]);
	fprintf(fp," \n");

	if (loc_legend150[1][0] != '\0' || loc_legend160[1][0] != '\0')
	{		
		fprintf(fp,"%-15.15s           %-31.31s       %-10.10s %-20.20s %-15.15s %-15.15s ","","","","",loc_legend150[1],loc_legend160[1]);		
	}
	else
	{
		fprintf(fp,"%-15.15s           %-31.31s       %-10.10s %-20.20s %-15.15s %-15.15s ","","","","","","");		
	}

	if (bl_ext_accode_1.arr[0] != '\0')
	  fprintf(fp, "%17.17s ",bl_ext_accode_1.arr);
	if (bl_ext_accode_2.arr[0] != '\0')
		fprintf(fp, "%17.17s ",bl_ext_accode_2.arr);
	if (bl_ext_accode_3.arr[0] != '\0')
		fprintf(fp, "%17.17s ",bl_ext_accode_3.arr);
	if (bl_ext_accode_4.arr[0] != '\0')
		fprintf(fp, "%17.17s ",bl_ext_accode_4.arr);
    if (oth_count != 0)    
		fprintf(fp, "%17.17s ","");   

	
	fprintf(fp," \n");
	fprintf(fp,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

	fflush(fp);  
	lctr = 15;    
}
 
print_page_title()  
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;

	l_report_width=229;
	l_acc_entity_length = strlen(hosp_name.arr);
  
    fprintf(fp,"\n");
	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	fprintf(fp,"MDL           : BL");
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",hosp_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%15.15s : %s\n",loc_legend[30],date.arr);

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
	fprintf(fp,"%15.15s : %s\n",loc_legend[40],date_time.arr);
  
	//Code for Line 3  
	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-((strlen(cashbook_ob_date.arr)+strlen(cashbook_cb_date.arr)+strlen(loc_legend[80])+strlen(loc_legend[90])+6)/2));
	fprintf(fp,"%-14.14s: BLR00249","Report Id ");
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	fprintf(fp,"%s (%s  %s %s)",loc_legend[80], cashbook_ob_date.arr,loc_legend[90],cashbook_cb_date.arr);
	l_comp_name_end_point=l_start_point+24+6+strlen(cashbook_ob_date.arr)
					+strlen(cashbook_cb_date.arr)
					+strlen(loc_legend[80])
					+strlen(loc_legend[90]);
	l_start_point=(l_report_width-18-7-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%15.15s : %d\n",loc_legend[50],++pctr);

	fprintf(fp,"\n");
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
	date.arr[0]		 = '\0';
	l_currency.arr[0]= '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
	date.len		 = 0;
    user_id.len      = 0;
	l_currency.len	 = 0;

    /* EXEC SQL SELECT upper(ACC_ENTITY_NAME), 
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,TO_CHAR(SYSDATE,'DD/MM/RRR\
R') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,USER ,base_currency into :b0,:b1,:b2,:b3,:\
b4  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b5";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )676;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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


print_formated(loc_amount,loc_size)
double loc_amount;
int loc_size;
{
	char s_amt[17], str_amt[17];	
	char str_val_length[20];
	char str_val_lengthcr[20];
	char str_val_lengthpv[20];

    sprintf(str_val_length,"%%%ds",loc_size);

	//sprintf(str_val_lengthcr,"%%%dsCR",loc_size);

	sprintf(str_val_lengthcr,"  %%%ds",loc_size);
	sprintf(str_val_lengthpv,"%%%ds  ",loc_size);

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,str_val_length,s_amt);
        fprintf(fp,str_val_lengthcr,str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,str_val_length,s_amt);
        fprintf(fp,str_val_lengthpv,str_amt);
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
  	  page_count++;
		
	  if (rec_reached >= rec_count)
		print_close_total(1);
/*	  else
  		print_close_total(2);*/
	
		fprintf(fp,"\f");
		print_head();
		page_total();   
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


fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00249.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00249.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )715;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
			blcommon.get_local_lang_desc(
						:nd_facility,
						'SM',
						'SM_LANG_LEGEND',
						'DFLT_LEGEND_VALUE',
						:l_pk_value,
						:l_translated_value,
						:p_language_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )738;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqhstv[3] = (         void  *)&p_language_id;
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



		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}

