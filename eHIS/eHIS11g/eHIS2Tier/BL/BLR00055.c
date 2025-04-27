
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00055.PC"
};


static unsigned int sqlctx = 1288460947;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {12,18};

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

 static const char *sq0006 = 
"AR(A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS') ,b.DOC_TYPE_CODE ,b.DOC_NUMBER ,a.can\
celled_ind ,b.cancelled_date ,(A.DOC_AMT* (-1)) ,a.ext_acct_code ,a.EXT_ACCT_D\
EPT_CODE ,A.SLMT_TYPE_CODE ,A.CASH_SLMT_FLAG ,A.SLMT_DOC_REF_DESC ,A.SLMT_DOC_\
REF_DATE ,substr(A.NARRATION,1,35) ,A.BANK_IN_BATCH_DOC_TYPE ,A.BANK_IN_BATCH_\
DOC_NO ,TO_CHAR(A.DOC_DATE,'DD/MM/YYYY') ,a.doc_date  from BL_RECEIPT_REFUND_D\
TL_VW A ,BL_CANCELLED_BOUNCED_TRX b where ((((((a.DOC_TYPE_CODE=b.DOC_TYPE_COD\
E and a.DOC_NUMBER=b.DOC_NUMBER) and (a.cancelled_ind='Y' or a.bounced_yn='Y')\
) and TO_DATE(TO_CHAR(b.CANCELLED_DATE,'dd/mm/yyyy'),'dd/mm/yyyy') between TO_\
DATE(:b0,'DD/MM/YYYY') and TO_DATE(:b1,'DD/MM/YYYY')) and A.SLMT_TYPE_CODE in \
(select SLMT_TYPE_CODE  from BL_SLMT_TYPE where CASH_SLMT_FLAG<>DECODE(:b2,'Y'\
,'A','~'))) and (((A.BANK_IN_BATCH_DOC_NO=A.BANK_IN_BATCH_DOC_NO and :b3='1') \
or (A.BANK_IN_BATCH_DOC_NO is null  and :b3='2')) or :b3='3')) and A.RECPT_REF\
UND_IND='R') order by slmt_type_code,ext_acct_code,doc_date            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,203,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,169,0,4,229,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,
0,0,1,9,0,0,
79,0,0,3,147,0,4,266,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
114,0,0,4,0,0,30,303,0,0,0,0,0,1,0,
129,0,0,5,91,0,2,311,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
152,0,0,6,2029,0,9,389,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
215,0,0,6,0,0,13,442,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
302,0,0,7,38,0,4,675,0,0,2,1,0,1,0,1,4,0,0,2,4,0,0,
325,0,0,8,38,0,4,691,0,0,2,1,0,1,0,1,4,0,0,2,4,0,0,
348,0,0,9,70,0,4,766,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
371,0,0,10,87,0,4,1072,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
398,0,0,11,181,0,6,1163,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
425,0,0,12,181,0,6,1175,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
452,0,0,13,181,0,6,1187,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
479,0,0,14,181,0,6,1199,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
506,0,0,15,181,0,6,1212,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
533,0,0,16,181,0,6,1224,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
560,0,0,17,181,0,6,1236,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
587,0,0,18,181,0,6,1248,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
614,0,0,19,181,0,6,1260,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
641,0,0,20,182,0,6,1272,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
668,0,0,21,182,0,6,1284,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
695,0,0,22,182,0,6,1296,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
722,0,0,23,182,0,6,1308,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
749,0,0,24,182,0,6,1320,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
776,0,0,25,182,0,6,1332,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
803,0,0,26,182,0,6,1344,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
830,0,0,27,182,0,6,1356,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
857,0,0,28,182,0,6,1368,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
884,0,0,29,182,0,6,1380,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
911,0,0,30,182,0,6,1391,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
938,0,0,31,182,0,6,1403,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
965,0,0,32,182,0,6,1416,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*                         BLR00055.PC                                     */
/*****************************************************************************/
/*
#define DEBUG 
*/ 
                             
#include <stdio.h>        
#include <string.h>
#include <math.h>
#include "bl.h"
#define INIT_MESG "Report Generation In Progress"

#define LEGEND 1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[91],
			d_session_id[16],
			d_pgm_date[14],       
            rep_date[20],
            comp_name[50],
			oper_id[21]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;


    /* VARCHAR report_date_fm       [17],
			report_date_to          [17],
			cancelled_docs          [2],
			exclude_credit_card_trn [2],
			print_flag              [2],
			base_currency[10]; */ 
struct { unsigned short len; unsigned char arr[17]; } report_date_fm;

struct { unsigned short len; unsigned char arr[17]; } report_date_to;

struct { unsigned short len; unsigned char arr[2]; } cancelled_docs;

struct { unsigned short len; unsigned char arr[2]; } exclude_credit_card_trn;

struct { unsigned short len; unsigned char arr[2]; } print_flag;

struct { unsigned short len; unsigned char arr[10]; } base_currency;


					

   /* VARCHAR d_doc_type_code                             [7],
           d_doc_number                                [9],
           d_doc_date                                  [25],
	   d_trx_date				       [30],
		   d_trans_date								   [25],
		   d_cancelled_doc_date						   [25],
           d_doc_amt                                   [23],
           d_slmt_type_code                            [3],
           d_slmt_doc_ref_desc                         [21],
           d_slmt_doc_ref_date                         [25],
           d_cancelled_ind                             [2],
           d_narration                                 [51],
	   d_narration1                                 [51],
	   d_narration2                                 [51],
		   d_cancelled_date							   [17],
		   d_bank_in_batch_type						   [7],
		   d_bank_in_batch_no						   [9],
		   
		   d_ext_acc_code							   [11],
		   d_ext_acct_dept_code						   [7],
		   d_cash_slmt_flag							   [2],
		   nd_operating_facility_id					   [3],
		   p_language_id                   [3]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[25]; } d_doc_date;

struct { unsigned short len; unsigned char arr[30]; } d_trx_date;

struct { unsigned short len; unsigned char arr[25]; } d_trans_date;

struct { unsigned short len; unsigned char arr[25]; } d_cancelled_doc_date;

struct { unsigned short len; unsigned char arr[23]; } d_doc_amt;

struct { unsigned short len; unsigned char arr[3]; } d_slmt_type_code;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[25]; } d_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[2]; } d_cancelled_ind;

struct { unsigned short len; unsigned char arr[51]; } d_narration;

struct { unsigned short len; unsigned char arr[51]; } d_narration1;

struct { unsigned short len; unsigned char arr[51]; } d_narration2;

struct { unsigned short len; unsigned char arr[17]; } d_cancelled_date;

struct { unsigned short len; unsigned char arr[7]; } d_bank_in_batch_type;

struct { unsigned short len; unsigned char arr[9]; } d_bank_in_batch_no;

struct { unsigned short len; unsigned char arr[11]; } d_ext_acc_code;

struct { unsigned short len; unsigned char arr[7]; } d_ext_acct_dept_code;

struct { unsigned short len; unsigned char arr[2]; } d_cash_slmt_flag;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


  /* VARCHAR  d_slmt_desc		 [16],
	   d_sum_slmt_type_code_1[3],
	   d_sum_slmt_type_code_2[3],
	   d_sum_slmt_type_code_3[3],
	   d_sum_slmt_type_code_4[3],
	   d_sum_slmt_type_code_5[3],
	   d_sum_slmt_type_code_6[3],
	   d_sum_slmt_type_code_7[3],
	   d_sum_slmt_type_code_8[3],
	   d_sum_slmt_type_code_9[3],
	   d_sum_slmt_type_code_10[3],
	   
	   d_sum_slmt_desc_1[16],
	   d_sum_slmt_desc_2[16],
	   d_sum_slmt_desc_3[16],
	   d_sum_slmt_desc_4[16],
	   d_sum_slmt_desc_5[16],
	   d_sum_slmt_desc_6[16],
	   d_sum_slmt_desc_7[16],
	   d_sum_slmt_desc_8[16],
	   d_sum_slmt_desc_9[16],
	   d_sum_slmt_desc_10[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_slmt_desc;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_1;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_2;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_3;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_4;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_5;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_6;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_7;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_8;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_9;

struct { unsigned short len; unsigned char arr[3]; } d_sum_slmt_type_code_10;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_1;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_2;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_3;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_4;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_5;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_6;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_7;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_8;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_9;

struct { unsigned short len; unsigned char arr[16]; } d_sum_slmt_desc_10;




  /* VARCHAR  d_prv_slmt_type_code		[3],
	   d_prv_slmt_desc[16],
	       d_prv_acc_code								[11]; */ 
struct { unsigned short len; unsigned char arr[3]; } d_prv_slmt_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_prv_slmt_desc;

struct { unsigned short len; unsigned char arr[11]; } d_prv_acc_code;

		      
	int    d_sl_no = 0;
	int r_ctr = 0;
	int	   i = 0, j = 0 ;

    int    d_last_rec = 0;

	int l_counter = 0;

	double l_st_point;

	int l_date = 0;

    double d_doc_amt_num,
	       d_acct_total,
		   d_cancel_doc_total,
		   d_slmt_total,
		   d_slmt_grand_total,
		   d_cancel_slmt_total = 0,
		   d_net_slmt_collection,
		   d_net_acct_collection,
		   nd_doc_amt,
		   tot_doc_amt  ,
		   d_sum_slmt_total_1=0,
		   d_sum_slmt_total_2=0,
		   d_sum_slmt_total_3=0,
		   d_sum_slmt_total_4=0,
		   d_sum_slmt_total_5=0,
		   d_sum_slmt_total_6=0,
		   d_sum_slmt_total_7=0,
		   d_sum_slmt_total_8=0,
		   d_sum_slmt_total_9=0,
		   d_sum_slmt_total_10=0,
		   d_sum_slmt_total=0;
    char filename[150];



	/* VARCHAR	loc_legend1	[201],
		loc_legend2	[201],
		loc_legend3	[201],
		loc_legend4	[201],
		loc_legend5	[201],
		loc_legend6	[201],
		loc_legend7	[201],
		loc_legend8	[201],
		loc_legend9	[201],
		loc_legend10[201],
		loc_legend11[201],
		loc_legend12[201],
		loc_legend13[201],
		loc_legend14[201],
		loc_legend15[201],
		loc_legend16[201],
		loc_legend17[201],
		loc_legend18[201],
		loc_legend19[201],
		loc_legend20[201],
		loc_legend21[201],
		loc_legend22[201],
		loc_legend23[201],
		loc_legend24[201]; */ 
struct { unsigned short len; unsigned char arr[201]; } loc_legend1;

struct { unsigned short len; unsigned char arr[201]; } loc_legend2;

struct { unsigned short len; unsigned char arr[201]; } loc_legend3;

struct { unsigned short len; unsigned char arr[201]; } loc_legend4;

struct { unsigned short len; unsigned char arr[201]; } loc_legend5;

struct { unsigned short len; unsigned char arr[201]; } loc_legend6;

struct { unsigned short len; unsigned char arr[201]; } loc_legend7;

struct { unsigned short len; unsigned char arr[201]; } loc_legend8;

struct { unsigned short len; unsigned char arr[201]; } loc_legend9;

struct { unsigned short len; unsigned char arr[201]; } loc_legend10;

struct { unsigned short len; unsigned char arr[201]; } loc_legend11;

struct { unsigned short len; unsigned char arr[201]; } loc_legend12;

struct { unsigned short len; unsigned char arr[201]; } loc_legend13;

struct { unsigned short len; unsigned char arr[201]; } loc_legend14;

struct { unsigned short len; unsigned char arr[201]; } loc_legend15;

struct { unsigned short len; unsigned char arr[201]; } loc_legend16;

struct { unsigned short len; unsigned char arr[201]; } loc_legend17;

struct { unsigned short len; unsigned char arr[201]; } loc_legend18;

struct { unsigned short len; unsigned char arr[201]; } loc_legend19;

struct { unsigned short len; unsigned char arr[201]; } loc_legend20;

struct { unsigned short len; unsigned char arr[201]; } loc_legend21;

struct { unsigned short len; unsigned char arr[201]; } loc_legend22;

struct { unsigned short len; unsigned char arr[201]; } loc_legend23;

struct { unsigned short len; unsigned char arr[201]; } loc_legend24;


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

FILE *f1;


int page_no,
    line_no,
    first_line,
    g_hdr_cnt,
    g_err_typ,
	d_flag,
    g_page_break;

char file_name[15],
     g_acct_code[41],
     g_err_id[8],
     g_err_msg[72];

char string_var [200];

double g_tot_debtor,
       g_tot_recpt,
       g_tot_date,
       g_tot_counter,
       g_tot_void,
       g_grand_tot;

void proc_main(argc,argv)
int argc;
char *argv[];
{
    if(argc != 5) 
	{
        disp_message(ERR_MESG,"BLR00055 : Usage BLR00055 userid/password session_id pgm_date facility_id \n");
        proc_exit();
    }

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(g_pgm_id,"BLR00055");
    strcpy(g_pgm_date,argv[3]);

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



    if(ERROR) 
	{
		disp_message(ERR_MESG,"Unable to connect to oracle.\n");
		proc_exit();
    }

   set_meduser_role();

   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len; 

   start_prog_msg();
 
   report_date_fm.arr[0]           = '\0';
   report_date_to.arr[0]           = '\0';
   print_flag.arr[0]               = '\0';
   exclude_credit_card_trn.arr[0]	   = '\0';

   report_date_fm.len              = 0;
   report_date_to.len              = 0;
   
   print_flag.len                  = 0;
   exclude_credit_card_trn.len	   = 0;
   
	/* EXEC SQL SELECT 
			OPERATING_FACILITY_ID,
			PARAM1,    
			PARAM2,
			PARAM3,
			PARAM4 
	INTO	:nd_operating_facility_id,
			:report_date_fm,
			:report_date_to,
			:exclude_credit_card_trn,
			:print_flag
	 FROM   SY_PROG_PARAM
	 WHERE  PGM_ID     = 'BLR00055'
	 AND    PGM_DATE   = :d_pgm_date
	 AND    SESSION_ID = :d_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 into :b0,:b1,:b2,:b3,:b4  from SY_PROG_PARAM where ((PGM_ID='BLR00055' and PG\
M_DATE=:b5) and SESSION_ID=:b6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&report_date_fm;
 sqlstm.sqhstl[1] = (unsigned int  )19;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&report_date_to;
 sqlstm.sqhstl[2] = (unsigned int  )19;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&exclude_credit_card_trn;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&print_flag;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[5] = (unsigned int  )16;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_session_id;
 sqlstm.sqhstl[6] = (unsigned int  )18;
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



    if(ERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

   report_date_fm.arr[report_date_fm.len]					= '\0';
   report_date_to.arr[report_date_to.len]					= '\0';
   exclude_credit_card_trn.arr[exclude_credit_card_trn.len] = '\0';
   print_flag.arr[print_flag.len]							= '\0';
  
   strcpy(g_facility_id, nd_operating_facility_id.arr);
   strcpy(filename,WORKING_DIR);
   strcat(filename,"blr00055.lis");

    if( (f1=fopen(filename,"w")) == NULL) 
	{
        disp_message(ERR_MESG,"Error in opening output file...BLR00055.LIS");
		proc_exit();
    }
 
    base_currency.arr[0] = '\0';
    base_currency.len = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER,
		    BASE_CURRENCY
	     INTO   :comp_name,
		    :rep_date,
		    :oper_id,
		    :base_currency
	     FROM   SY_ACC_ENTITY
	     WHERE	ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER ,BASE_CURRENCY into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY where ACC_E\
NTITY_ID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )79;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqhstv[3] = (         void  *)&base_currency;
    sqlstm.sqhstl[3] = (unsigned int  )12;
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

	  

    if(ERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';

    base_currency.arr[base_currency.len] = '\0';

    page_no=1;
    line_no=1;

    fetch_legend_value();

    decl_curs();

    put_inp_parm();

    do_report();

    fclose(f1);

    del_parm();

    end_prog_msg();

    /* EXEC SQL COMMIT RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )114;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}

del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
         WHERE  PGM_ID     = 'BLR00055' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR00055' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )129;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )16;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_session_id;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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



    if(ERROR) 
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 

}


decl_curs()
{

	/* EXEC SQL DECLARE BL_REC_REF_CUR CURSOR FOR
	SELECT	TO_CHAR(A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS') Trx_date  ,
			 TO_CHAR(A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS') ,
			 A.DOC_TYPE_CODE,
			 A.DOC_NUMBER,
			 a.cancelled_ind,
			 b.cancelled_date,
			 A.DOC_AMT,
			 A.ext_acct_code,
			 A.EXT_ACCT_DEPT_CODE     ,
			 A.SLMT_TYPE_CODE,
			 A.CASH_SLMT_FLAG                         ,
			 A.SLMT_DOC_REF_DESC                      ,
			 A.SLMT_DOC_REF_DATE                      ,
			 A.NARRATION, 
			 A.BANK_IN_BATCH_DOC_TYPE ,
			 A.BANK_IN_BATCH_DOC_NO, 
			 TO_CHAR(A.DOC_DATE ,'DD/MM/YYYY'),
			 a.doc_date
	FROM	BL_RECEIPT_REFUND_DTL_VW A,BL_CANCELLED_BOUNCED_TRX b
	WHERE	a.DOC_TYPE_CODE = b.DOC_TYPE_CODE(+)
	AND		a.DOC_NUMBER = b.DOC_NUMBER(+) 
	AND		TO_DATE(TO_CHAR(DOC_DATE,'dd/mm/yyyy'),'dd/mm/yyyy')
	BETWEEN TO_DATE(:report_date_fm,'DD/MM/YYYY') AND TO_DATE(:report_date_to,'DD/MM/YYYY')
	AND		A.SLMT_TYPE_CODE IN (SELECT SLMT_TYPE_CODE FROM BL_SLMT_TYPE
			WHERE CASH_SLMT_FLAG != DECODE(:exclude_credit_card_trn ,'Y','A','~')) /o changed null to '~' o/
        AND            ((A.BANK_IN_BATCH_DOC_NO =  A.BANK_IN_BATCH_DOC_NO AND :print_flag = '1') 
			OR (A.BANK_IN_BATCH_DOC_NO IS NULL AND :print_flag = '2')
			OR :print_flag = '3')
	AND    A.RECPT_REFUND_IND = 'R'
	UNION ALL
	SELECT	TO_CHAR(b.CANCELLED_DATE,'DD/MM/YYYY HH24:MI:SS') trx_date      ,
			TO_CHAR(A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS'),
			b.DOC_TYPE_CODE,
			b.DOC_NUMBER,
			a.cancelled_ind,
			b.cancelled_date,
			A.DOC_AMT * -1                        ,
			a.ext_acct_code,
			a.EXT_ACCT_DEPT_CODE     ,
			A.SLMT_TYPE_CODE,
			A.CASH_SLMT_FLAG                         ,
			A.SLMT_DOC_REF_DESC                      ,
			A.SLMT_DOC_REF_DATE                      ,
			substr(A.NARRATION , 1,35),
			A.BANK_IN_BATCH_DOC_TYPE ,
			A.BANK_IN_BATCH_DOC_NO   ,
			TO_CHAR(A.DOC_DATE ,'DD/MM/YYYY'),
			a.doc_date
	FROM	BL_RECEIPT_REFUND_DTL_VW A, BL_CANCELLED_BOUNCED_TRX b
	WHERE	a.DOC_TYPE_CODE = b.DOC_TYPE_CODE
	AND	a.DOC_NUMBER = b.DOC_NUMBER
	AND	(a.cancelled_ind = 'Y' OR a.bounced_yn = 'Y')
	AND	TO_DATE(TO_CHAR(b.CANCELLED_DATE,'dd/mm/yyyy'),'dd/mm/yyyy')
	BETWEEN TO_DATE(:report_date_fm,'DD/MM/YYYY') AND TO_DATE(:report_date_to,'DD/MM/YYYY')
	AND		A.SLMT_TYPE_CODE IN (SELECT SLMT_TYPE_CODE FROM BL_SLMT_TYPE
	WHERE           CASH_SLMT_FLAG != DECODE(:exclude_credit_card_trn ,'Y', 'A','~')) /o changed null to '~' o/
	AND     ((A.BANK_IN_BATCH_DOC_NO =  A.BANK_IN_BATCH_DOC_NO AND :print_flag = '1') 
	      OR (A.BANK_IN_BATCH_DOC_NO IS NULL AND :print_flag = '2')
              OR :print_flag = '3')
	AND    A.RECPT_REFUND_IND       = 'R'
	ORDER BY slmt_type_code, ext_acct_code,doc_date; */ 


     
    /* EXEC SQL OPEN BL_REC_REF_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select TO_CHAR(A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS') Trx_date ,TO_CHAR(\
A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS') ,A.DOC_TYPE_CODE ,A.DOC_NUMBER ,a.cancel\
led_ind ,b.cancelled_date ,A.DOC_AMT ,A.ext_acct_code ,A.EXT_ACCT_DEPT_CODE \
,A.SLMT_TYPE_CODE ,A.CASH_SLMT_FLAG ,A.SLMT_DOC_REF_DESC ,A.SLMT_DOC_REF_DAT\
E ,A.NARRATION ,A.BANK_IN_BATCH_DOC_TYPE ,A.BANK_IN_BATCH_DOC_NO ,TO_CHAR(A.\
DOC_DATE,'DD/MM/YYYY') ,a.doc_date  from BL_RECEIPT_REFUND_DTL_VW A ,BL_CANC\
ELLED_BOUNCED_TRX b where (((((a.DOC_TYPE_CODE=b.DOC_TYPE_CODE(+) and a.DOC_\
NUMBER=b.DOC_NUMBER(+)) and TO_DATE(TO_CHAR(DOC_DATE,'dd/mm/yyyy'),'dd/mm/yy\
yy') between TO_DATE(:b0,'DD/MM/YYYY') and TO_DATE(:b1,'DD/MM/YYYY')) and A.\
SLMT_TYPE_CODE in (select SLMT_TYPE_CODE  from BL_SLMT_TYPE where CASH_SLMT_\
FLAG<>DECODE(:b2,'Y','A','~'))) and (((A.BANK_IN_BATCH_DOC_NO=A.BANK_IN_BATC\
H_DOC_NO and :b3='1') or (A.BANK_IN_BATCH_DOC_NO is null  and :b3='2')) or :\
b3='3')) and A.RECPT_REFUND_IND='R') union all select TO_CHAR(b.CANCELLED_DA\
TE,'DD/MM/YYYY HH24:MI:SS') trx_date ,TO_CH");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )152;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&report_date_fm;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&report_date_to;
    sqlstm.sqhstl[1] = (unsigned int  )19;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&exclude_credit_card_trn;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&print_flag;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&print_flag;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&print_flag;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&report_date_fm;
    sqlstm.sqhstl[6] = (unsigned int  )19;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&report_date_to;
    sqlstm.sqhstl[7] = (unsigned int  )19;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&exclude_credit_card_trn;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&print_flag;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&print_flag;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&print_flag;
    sqlstm.sqhstl[11] = (unsigned int  )4;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor BL_REC_REF_CUR",0,"");

}

fetch_bl_rec()
{

	d_doc_date.arr[0]												  = '\0';
	d_cancelled_doc_date.arr[0]										  = '\0';
    d_doc_type_code.arr[0]                                            = '\0';
    d_doc_number.arr[0]                                               = '\0';
	d_cancelled_ind.arr[0]                                            = '\0';
	d_cancelled_date.arr[0]											  = '\0';
    d_doc_date.arr[0]                                                 = '\0';
	d_ext_acc_code.arr[0]											  = '\0';
	d_ext_acct_dept_code.arr[0]										  = '\0';
    d_doc_amt.arr[0]                                                  = '\0';
    d_slmt_type_code.arr[0]                                           = '\0';
    d_slmt_doc_ref_desc.arr[0]                                        = '\0';
    d_slmt_doc_ref_date.arr[0]                                        = '\0';
    d_narration.arr[0]                                                = '\0';
	d_bank_in_batch_type.arr[0]										  = '\0';
	d_bank_in_batch_no.arr[0]										  = '\0';
	d_trans_date.arr[0] = '\0';


    d_doc_date.len													  = 0;
	d_cancelled_doc_date.len										  = 0;
	d_doc_type_code.len                                               = 0;
    d_doc_number.len                                                  = 0;
	d_cancelled_ind.len                                               = 0;
	d_cancelled_date.len											  = 0;
	d_doc_date.len                                                    = 0;
	d_ext_acc_code.len     											  = 0;
	d_ext_acct_dept_code.len										  = 0;
    d_doc_amt.len                                                     = 0;
    d_slmt_type_code.len                                              = 0;
    d_slmt_doc_ref_desc.len                                           = 0;
    d_slmt_doc_ref_date.len                                           = 0;

    
    d_narration.len                                                   = 0;
	d_bank_in_batch_type.len										  = 0;
	d_bank_in_batch_no.len											  = 0;
	d_trans_date.len = 0;

    d_doc_amt_num = 0;

    d_last_rec = 0;

     /* EXEC SQL FETCH BL_REC_REF_CUR
               INTO :d_doc_date,
		:d_cancelled_doc_date,
		:d_doc_type_code,
		:d_doc_number,
		:d_cancelled_ind,
		:d_cancelled_date,
		:d_doc_amt_num,
		:d_ext_acc_code,
		:d_ext_acct_dept_code,
		:d_slmt_type_code,
		:d_cash_slmt_flag,
		:d_slmt_doc_ref_desc,
		:d_slmt_doc_ref_date,
		:d_narration,
		:d_bank_in_batch_type,
		:d_bank_in_batch_no,
		:d_trans_date,
		:d_trx_date; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )215;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&d_doc_date;
     sqlstm.sqhstl[0] = (unsigned int  )27;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_cancelled_doc_date;
     sqlstm.sqhstl[1] = (unsigned int  )27;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_doc_type_code;
     sqlstm.sqhstl[2] = (unsigned int  )9;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_doc_number;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_cancelled_ind;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_cancelled_date;
     sqlstm.sqhstl[5] = (unsigned int  )19;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_doc_amt_num;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_ext_acc_code;
     sqlstm.sqhstl[7] = (unsigned int  )13;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_ext_acct_dept_code;
     sqlstm.sqhstl[8] = (unsigned int  )9;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_slmt_type_code;
     sqlstm.sqhstl[9] = (unsigned int  )5;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_cash_slmt_flag;
     sqlstm.sqhstl[10] = (unsigned int  )4;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&d_slmt_doc_ref_desc;
     sqlstm.sqhstl[11] = (unsigned int  )23;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&d_slmt_doc_ref_date;
     sqlstm.sqhstl[12] = (unsigned int  )27;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&d_narration;
     sqlstm.sqhstl[13] = (unsigned int  )53;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&d_bank_in_batch_type;
     sqlstm.sqhstl[14] = (unsigned int  )9;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&d_bank_in_batch_no;
     sqlstm.sqhstl[15] = (unsigned int  )11;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&d_trans_date;
     sqlstm.sqhstl[16] = (unsigned int  )27;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&d_trx_date;
     sqlstm.sqhstl[17] = (unsigned int  )32;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			   
    if(ERROR)
	err_mesg("FETCH failed on cursor BL_REC_REF_CUR",0,"");

    if(NO_DATA_FOUND)
	{
		d_last_rec = 1;
		return 0;
	}
   

    d_doc_date.arr[d_doc_date.len]					 = '\0';
	d_cancelled_doc_date.arr[d_cancelled_doc_date.len]		 = '\0';
    d_doc_type_code.arr[d_doc_type_code.len]                             = '\0';
    d_doc_number.arr[d_doc_number.len]                                   = '\0';
    d_cancelled_ind.arr[d_cancelled_ind.len]                             = '\0';
	d_cancelled_date.arr[d_cancelled_date.len]                       = '\0';
	d_doc_amt.arr[d_doc_amt.len]                                     = '\0';
	d_ext_acc_code.arr[d_ext_acc_code.len]                           = '\0';
	d_ext_acct_dept_code.arr[d_ext_acct_dept_code.len]		 = '\0';
    d_slmt_type_code.arr[d_slmt_type_code.len]                           = '\0';
    d_cash_slmt_flag.arr[d_cash_slmt_flag.len]                           = '\0';
	d_slmt_doc_ref_desc.arr[d_slmt_doc_ref_desc.len]                 = '\0';
	d_slmt_doc_ref_date.arr[d_slmt_doc_ref_date.len]                 = '\0';
    d_narration.arr[d_narration.len]                                     = '\0';
	d_bank_in_batch_type.arr[d_bank_in_batch_type.len]		 = '\0';
	d_bank_in_batch_no.arr[d_bank_in_batch_no.len]			 = '\0';
	d_trans_date.arr[d_trans_date.len] = '\0';

	d_narration1.arr[0] = '\0';
	d_narration1.len = 0;

	d_narration2.arr[0] = '\0';
	d_narration2.len = 0;

	r_ctr = 0;
	if (strlen(d_narration.arr) > 0)
	   split_text(d_narration.arr,30,d_narration1.arr,&r_ctr);			
        
	if (strlen(d_narration.arr) > 30)
	   split_text(d_narration.arr,30,d_narration2.arr,&r_ctr);			
	   

    l_counter = l_counter + 1;
	
    if (l_counter == 1 )
	{
	    strcpy(d_prv_slmt_type_code.arr,d_slmt_type_code.arr);
		strcpy(d_prv_acc_code.arr,d_ext_acc_code.arr);
	}

    return 1;

}






do_report()
{
    int cnt,first,brk;
    
    char s_amt[20];
    d_acct_total  = 0;
	d_cancel_doc_total = 0;
	d_slmt_total  = 0;
	d_slmt_grand_total = 0;
	d_cancel_slmt_total= 0;
    
	l_date = 0;

    g_grand_tot = 0;
    line_no = 1;
    
	put_hdr();

    g_hdr_cnt = 0;
    
    d_sl_no = 0;
	d_prv_slmt_type_code.arr[0] = '\0';
	d_prv_acc_code.arr[0] = '\0';

	d_prv_slmt_type_code.len =  0;
	d_prv_acc_code.len = 0;

	d_flag = 0;
	d_acct_total = 0;
	d_cancel_doc_total = 0;
	d_slmt_total = 0;
	d_cancel_slmt_total = 0;
	d_net_slmt_collection = 0;
	d_net_acct_collection = 0;

    
    while(fetch_bl_rec()) 
	{
	    if (strcmp(d_prv_slmt_type_code.arr,d_slmt_type_code.arr) == 0)
		{                  
		   
		   if(strcmp(d_prv_acc_code.arr , d_ext_acc_code.arr) == 0 )
		   {
                   print_details();
	           get_total();	 
		   }
		   else /* Account code*/
		   {
			   print_account_total();

			   d_acct_total = 0;
			   d_cancel_doc_total = 0;
			   d_net_acct_collection = 0;
			   print_details();
			   get_total();
		   }
		}
        else /* for slmttype */
		{
			print_account_total();
			print_settlement_total();
            
			d_slmt_total = 0;
			d_acct_total = 0;
			d_cancel_doc_total = 0;
			d_cancel_slmt_total = 0;
			print_details();
			
			get_total();	
		}

            d_slmt_grand_total  = d_slmt_grand_total + d_doc_amt_num;    
		
	    strcpy(d_prv_slmt_type_code.arr,d_slmt_type_code.arr);
	    strcpy(d_prv_slmt_desc.arr,d_slmt_desc.arr);
	    strcpy(d_prv_acc_code.arr,d_ext_acc_code.arr);
	} /* end of while */ 

    if (l_counter != 0)
	{
		print_account_total();

		line_no = line_no +2;
		check_page_break();

		print_settlement_total();        

		line_no = line_no +2;
	        check_page_break();

		print_grand_settlement_total();

                line_no = line_no +2;
		check_page_break();

		if((line_no+5+6+j) > 55)
		{
			line_no = 0;			
			fprintf(f1,"\f");
			fprintf(f1,"\n");
			put_hdr();
		}

		print_sum_settlement_total();
		
	        d_slmt_total = 0;
		d_slmt_grand_total = 0;
		d_acct_total = 0;
		d_cancel_doc_total = 0;
		d_cancel_slmt_total = 0;
		d_net_slmt_collection = 0;
		d_net_acct_collection = 0;

    }

    print_end_of_rep();
}

put_hdr()
{

    print_page_title();
    //fprintf(f1,"OPR : %s\n",oper_id.arr);
	//fprintf(f1,"%-10.10s :BLR00055",loc_legend1.arr);
    //fprintf(f1,"%-50s                       ",loc_legend2.arr);
	//fprintf(f1,"%-10.10s :BLR00055",loc_legend1.arr);
	//fprintf(f1,"                                                   %-8s : %4d\n",loc_legend3.arr , page_no);
    //fprintf(f1,"                                                    %10s  -  %10s\n",report_date_fm.arr, report_date_to.arr);
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(f1,"%-5.5s   %-19.19s  %-19.19s  %-14.14s   %-9.9s   %-8.8s   %-19.19s  %13.13s   %-30.30s %-16.16s\n",loc_legend5.arr, loc_legend6.arr, loc_legend20.arr,loc_legend7.arr, loc_legend8.arr, loc_legend9.arr, loc_legend10.arr, loc_legend11.arr, loc_legend12.arr, loc_legend16.arr);     
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");

    line_no=9;
	check_page_break();
}
  
print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;

	line_no= 0;
	l_report_width=175;

	l_acc_entity_length = strlen(comp_name.arr);


	//Code for Line 1
	l_start_point=((l_report_width/2)-(l_acc_entity_length/2));
	l_st_point = l_start_point;
	/* exec sql select round(:l_st_point) into :l_st_point from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select round(:b0) into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )302;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_st_point;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_st_point;
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


	l_start_point = l_st_point;

	fprintf(f1,"MDL           : BL");
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(f1,"%s",comp_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(18+strlen(rep_date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(f1,"%-15.15s  %s\n","",rep_date.arr);

	//Code for Line 2
	l_start_point=0;
	l_start_point=((l_report_width/2)-((strlen(loc_legend2.arr))/2));
	l_st_point = l_start_point;
	/* exec sql select round(:l_st_point) into :l_st_point from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select round(:b0) into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )325;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_st_point;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_st_point;
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


	l_start_point = l_st_point;
	
	fprintf(f1,"OPR           : %s",oper_id.arr);
	l_start_point=l_start_point-(strlen(oper_id.arr)+16);
	print_spaces(l_start_point);
	fprintf(f1,"%s\n",loc_legend2.arr);
	
	//Code for Line 3
	l_start_point=0;
	fprintf(f1,"%-14.14s: BLR00055                                                    %s - %s                                                              %s:%d\n",loc_legend1.arr,report_date_fm.arr, report_date_to.arr, loc_legend3.arr, page_no);
	page_no++;
}

print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(f1," ");
	}
}
   
print_details()
{
	d_sl_no = d_sl_no + 1;
        get_slmt_desc();	
	fprintf(f1 ,"%-5.5d   " , d_sl_no);
        fprintf(f1, "%-20.20s ",d_doc_date.arr);
	fprintf(f1, "%-20.20s ",d_cancelled_doc_date.arr);
	fprintf(f1, "%-6.6s/%-8.8s  ", d_doc_type_code.arr , d_doc_number.arr);
	fprintf(f1, "%-10.10s  ", d_ext_acc_code.arr);
	fprintf(f1 , "%-6.6s     " ,d_ext_acct_dept_code.arr);
	fprintf(f1 , "%-2.2s " ,d_slmt_type_code.arr);
	
	fprintf(f1, "%-15.15s  ", d_slmt_desc.arr);
	print_formated(d_doc_amt_num, f1);
	//fprintf(f1, "     ");
	fprintf(f1, " %-30.30s ", d_narration1.arr);
    
	if ((d_bank_in_batch_type.arr[0] != '\0') && (d_bank_in_batch_no.arr[0] != '\0'))
        fprintf(f1, "%-s/%-s\n", d_bank_in_batch_type.arr , d_bank_in_batch_no.arr);
	else
        fprintf(f1, "\n");

        line_no = line_no +1;
	check_page_break();

	if(d_narration2.arr[0] != '\0')
	{
		fprintf(f1 ,"%-5.5s   " ,"");
		fprintf(f1, "%-20.20s ","");
		fprintf(f1, "%-20.20s ","");
		fprintf(f1, "%-6.6s %-8.8s  ", "" , "");
		fprintf(f1, "%-10.10s  ", "");
		fprintf(f1 , "%-6.6s     " ,"");
		fprintf(f1 , "%-2.2s " ,"");		
		fprintf(f1, "%-15.15s  ", "");
		fprintf(f1, "%-10.10s  ", "");
		//print_formated(d_doc_amt_num, f1);
		fprintf(f1, "    ");
		fprintf(f1, " %-33.33s ",d_narration2.arr);		
		fprintf(f1, "\n");

		line_no = line_no +1;
		check_page_break();
	}
}

get_slmt_desc()
{

    d_slmt_desc.arr[0] = '\0';
	d_slmt_desc.len = 0;
	
	/* EXEC SQL 
	     SELECT  SHORT_DESC
		 into    :d_slmt_desc
	     FROM    BL_SLMT_TYPE
	     WHERE   SLMT_TYPE_CODE = :d_slmt_type_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_DESC into :b0  from BL_SLMT_TYPE where SLMT_TYP\
E_CODE=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )348;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_slmt_desc;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_slmt_type_code;
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
	err_mesg("SELECT failed on table BL_SLMT_TYPE",0,"");



	d_slmt_desc.arr[d_slmt_desc.len] = '\0';

}
put_inp_parm()
{

    print_page_title();	
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
    fprintf(f1,"VER : 4.1\n");
    fprintf(f1,"\n\n\n\n");
    //fprintf(f1,"\tINPUT PARAMETERS\n");

	fprintf(f1,"\t%s\n",loc_legend4.arr);
    fprintf(f1,"\t-----------------\n\n");
    fprintf(f1,"\t\tREPORT DATE           FROM : %s\n",report_date_fm.arr);
    fprintf(f1,"\t\t                        TO : %s\n\n",report_date_to.arr);
    fprintf(f1,"\t\tCANCELLED DOCS ONLY        : %s\n\n",cancelled_docs.arr);

    if (strcmp(print_flag.arr,"1") == 0)
    fprintf(f1,"\t\tOPTION			   : %s\n\n","With Bank-in Batch");
    else if (strcmp(print_flag.arr,"2") == 0)
    fprintf(f1,"\t\tOPTION			   : %s\n\n","Without Bank-in Batch");
    else
    fprintf(f1,"\t\tOPTION			   : %s\n\n","Both");

    //fprintf(f1,"\t\tOPTION		       : %s\n\n",print_flag.arr);
    //fprintf(f1,"\t\t                             (1-Receipts, 2-Refunds, 3-Both)\n");

    fprintf(f1,"");
    fprintf(f1,"\n");
}


print_end_of_rep()
{
    fprintf(f1,"\n\n                                                    ** END OF REPORT **                                                             \n");
}


print_account_total()
{
	if (loc_legend13.arr[0] == '\0' )
		fprintf(f1 ,"                                                         ACCOUNT TOTAL (%-6.6s)    =      ",d_prv_acc_code.arr);
	else
		fprintf(f1,"                                                                             %20.20s (%-6.6s) =  ",loc_legend13.arr,d_prv_acc_code.arr);
	
	print_formated(d_acct_total, f1);

	

	if( d_cancel_doc_total != 0 )
	{
		if (loc_legend17.arr[0] == '\0' )
			fprintf(f1," Prev Period Cancel Total =     " );
		else
			fprintf(f1," %-29.29s    ",loc_legend17.arr);

		print_formated(d_cancel_doc_total, f1);
	}
	 
	//fprintf(f1,        "             Net Collection  = " );
	//d_net_acct_collection = d_acct_total + d_cancel_doc_total ; 
	//print_formated(d_net_acct_collection, f1);

	fprintf(f1, "\n\n");
}

print_settlement_total()
{
	    fprintf(f1,"                                                                                                      ------------------------------------------------------------------------\n");
		//fprintf(f1,"                         Settltment Total = ");

		if (loc_legend18.arr[0] == '\0' )
		   fprintf(f1, "                         Settlement Total = " );
	    else
		   fprintf(f1,"                                                                   %35.35s        ",loc_legend18.arr);

	    

		print_formated(d_slmt_total, f1);

		//fprintf( f1  , "  Prev Period Slmt Cancel Total = ");
	
	   

	   if(d_cancel_slmt_total!= 0)
	   {
		   if (loc_legend19.arr[0] == '\0' )
			   fprintf(f1, " Prev Period Slmt Cancel Total =  " );
		   else
			   fprintf(f1," %-33.33s",loc_legend19.arr);

		   print_formated(d_cancel_slmt_total,f1);
	   }
        
		
		//fprintf(f1, "   Net Settlement Collection =  " );
		//d_net_slmt_collection = d_slmt_total + d_cancel_slmt_total ; 
		//print_formated(d_net_slmt_collection, f1);

		fprintf(f1, "\n");
		fprintf(f1,"                                                                                                      ------------------------------------------------------------------------\n");

		j = j + 1;			

		if ( j == 1 )
		{		
			strcpy(d_sum_slmt_type_code_1.arr,d_prv_slmt_type_code.arr);			
			strcpy(d_sum_slmt_desc_1.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_1 = d_slmt_total + d_cancel_slmt_total; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_1;
	
		}

		if ( j == 2 )
		{
			strcpy(d_sum_slmt_type_code_2.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_2.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_2 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_2;
		}

		if ( j == 3 )
		{
			strcpy(d_sum_slmt_type_code_3.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_3.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_3 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_3;
		}

		if ( j == 4 )
		{
			strcpy(d_sum_slmt_type_code_4.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_4.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_4 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_4;
		}

		if ( j == 5 )
		{
			strcpy(d_sum_slmt_type_code_5.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_5.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_5 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_5;
		}

		if ( j == 6 )
		{
			strcpy(d_sum_slmt_type_code_6.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_6.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_6 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_6;
		}

		if ( j == 7 )
		{
			strcpy(d_sum_slmt_type_code_7.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_7.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_7 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_7;
		}

		if ( j == 8 )
		{
			strcpy(d_sum_slmt_type_code_8.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_8.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_8 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_8;
		}

		if ( j == 9 )
		{
			strcpy(d_sum_slmt_type_code_9.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_9.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_9 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_9;
		}

		if ( j == 10 )
		{
			strcpy(d_sum_slmt_type_code_10.arr,d_prv_slmt_type_code.arr);
			strcpy(d_sum_slmt_desc_10.arr,d_prv_slmt_desc.arr);
			d_sum_slmt_total_10 = d_slmt_total + d_cancel_slmt_total ; 
			d_sum_slmt_total = d_sum_slmt_total + d_sum_slmt_total_10;
		}
	}


print_grand_settlement_total()
{
	 //     fprintf(f1,"                                                                                           ------------------------------------------------------------------------------------\n");

		if (loc_legend21.arr[0] == '\0' )
		   fprintf(f1, "                   Grand Settlement Total = " );
	    else
		   fprintf(f1,"                                                                                     %17.17s        ",loc_legend21.arr);

	    

		print_formated(d_slmt_grand_total, f1);		

		fprintf(f1, "\n");
		fprintf(f1,"                                                                                                      ------------------------------------------------------------------------\n");
}


print_sum_settlement_total()
{
		fprintf(f1,"		---------------------------------------------------------------------------\n");
		if (loc_legend22.arr[0] == '\0' )
		   fprintf(f1, "		Total Summary   \n" );
		else
		   fprintf(f1,"		%-20.20s		    %10.10s \n",loc_legend22.arr,base_currency.arr);

	        fprintf(f1,"		---------------------------------------------------------------------------\n");

		if (d_sum_slmt_type_code_1.arr[0] != '\0')
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_1.arr,d_sum_slmt_desc_1.arr);
			print_formated(d_sum_slmt_total_1, f1);				
			fprintf(f1, "\n");
		}

		if (d_sum_slmt_type_code_2.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_2.arr,d_sum_slmt_desc_2.arr);
			print_formated(d_sum_slmt_total_2, f1);				
			fprintf(f1, "\n");
		}

		if (d_sum_slmt_type_code_3.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_3.arr,d_sum_slmt_desc_3.arr);
			print_formated(d_sum_slmt_total_3, f1);				
			fprintf(f1, "\n");
		}
		if (d_sum_slmt_type_code_4.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_4.arr,d_sum_slmt_desc_4.arr);
			print_formated(d_sum_slmt_total_4, f1);				
			fprintf(f1, "\n");
		}

		if (d_sum_slmt_type_code_5.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_5.arr,d_sum_slmt_desc_5.arr);
			print_formated(d_sum_slmt_total_5, f1);				
			fprintf(f1, "\n");
		}

		if (d_sum_slmt_type_code_6.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_6.arr,d_sum_slmt_desc_6.arr);
			print_formated(d_sum_slmt_total_6, f1);				
			fprintf(f1, "\n");
		}

		if (d_sum_slmt_type_code_7.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_7.arr,d_sum_slmt_desc_7.arr);
			print_formated(d_sum_slmt_total_7, f1);				
			fprintf(f1, "\n");
		}

		if (d_sum_slmt_type_code_8.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_8.arr,d_sum_slmt_desc_8.arr);
			print_formated(d_sum_slmt_total_8, f1);				
			fprintf(f1, "\n");
		}

		if (d_sum_slmt_type_code_9.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_9.arr,d_sum_slmt_desc_9.arr);
			print_formated(d_sum_slmt_total_9, f1);				
			fprintf(f1, "\n");
		}

		if (d_sum_slmt_type_code_10.arr[0])
		{
			fprintf(f1,"		%-2.2s %-17.17s		",d_sum_slmt_type_code_10.arr,d_sum_slmt_desc_10.arr);
			print_formated(d_sum_slmt_total_10, f1);				
			fprintf(f1, "\n");
		}

		fprintf(f1,"		---------------------------------------------------------------------------\n");
		fprintf(f1,"		%-20.20s		",loc_legend23.arr);
		print_formated(d_sum_slmt_total, f1);				
		fprintf(f1, "\n");		
		fprintf(f1,"		---------------------------------------------------------------------------\n");
}

get_total()
{

	/* EXEC SQL SELECT sign(to_date(:report_date_fm,'dd/mm/yyyy')-to_date(:d_trans_date,'dd/mm/yyyy'))
	INTO l_date FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select sign((to_date(:b0,'dd/mm/yyyy')-to_date(:b1,'dd/mm/yy\
yy'))) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )371;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&report_date_fm;
 sqlstm.sqhstl[0] = (unsigned int  )19;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_trans_date;
 sqlstm.sqhstl[1] = (unsigned int  )27;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_date;
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



	if (l_date == 1)
	{
	   d_cancel_doc_total = d_cancel_doc_total + d_doc_amt_num;
	   d_cancel_slmt_total = d_cancel_slmt_total + d_doc_amt_num ;
	}
	else
	{
		d_acct_total = d_acct_total + d_doc_amt_num;
		d_slmt_total = d_slmt_total + d_doc_amt_num;
	}	
	
}

print_formated(loc_amount,fp)
double loc_amount;
FILE *fp;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        format_amt(s_amt);
		sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-10sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);
        format_amt(s_amt);
		sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-10s  ",str_amt);
    }
}

/* to get the lengend value*/
fetch_legend_value()
{
	loc_legend1.arr[0]		= '\0';
	loc_legend2.arr[0]		= '\0';
	loc_legend3.arr[0]		= '\0';
	loc_legend4.arr[0]		= '\0';
	loc_legend5.arr[0]		= '\0';
	loc_legend6.arr[0]		= '\0';
	loc_legend7.arr[0]		= '\0';
	loc_legend8.arr[0]		= '\0';
	loc_legend9.arr[0]		= '\0';
	loc_legend10.arr[0]		= '\0';
	loc_legend11.arr[0]		= '\0';
	loc_legend12.arr[0]		= '\0';
	loc_legend13.arr[0]		= '\0';
	loc_legend14.arr[0]		= '\0';
	loc_legend15.arr[0]		= '\0';
	loc_legend16.arr[0]		= '\0';
	loc_legend17.arr[0]		= '\0';
	loc_legend18.arr[0]		= '\0';
	loc_legend19.arr[0]		= '\0';
	loc_legend20.arr[0]		= '\0';
	loc_legend21.arr[0]		= '\0';
	loc_legend22.arr[0]		= '\0';
	loc_legend23.arr[0]		= '\0';
	loc_legend24.arr[0]		= '\0';

	loc_legend1.len			= 0;
	loc_legend2.len			= 0;
	loc_legend3.len			= 0;
	loc_legend4.len			= 0;
	loc_legend5.len			= 0;
	loc_legend6.len			= 0;
	loc_legend7.len			= 0;
	loc_legend8.len			= 0;
	loc_legend9.len			= 0;
	loc_legend10.len		= 0;
	loc_legend11.len		= 0;
	loc_legend12.len		= 0;
	loc_legend13.len		= 0;
	loc_legend14.len		= 0;
	loc_legend15.len		= 0;
	loc_legend16.len		= 0;
	loc_legend17.len		= 0;
	loc_legend18.len		= 0;
	loc_legend19.len		= 0;
	loc_legend20.len		= 0;
	loc_legend21.len		= 0;
	loc_legend22.len		= 0;
	loc_legend23.len		= 0;
	loc_legend24.len		= 0;

	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0010',
									:loc_legend1,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0010\
' , :loc_legend1 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )398;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend1;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0020',
									:loc_legend2,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0020\
' , :loc_legend2 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )425;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend2;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0030',
									:loc_legend3,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0030\
' , :loc_legend3 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )452;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend3;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


	
	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0150',
									:loc_legend4,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0150\
' , :loc_legend4 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )479;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend4;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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




	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0060',
									:loc_legend5,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0060\
' , :loc_legend5 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )506;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend5;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0070',
									:loc_legend6,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0070\
' , :loc_legend6 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )533;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend6;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0080',
									:loc_legend7,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0080\
' , :loc_legend7 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )560;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend7;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0090',
									:loc_legend8,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0090\
' , :loc_legend8 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )587;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend8;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0100',
									:loc_legend9,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0100\
' , :loc_legend9 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )614;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend9;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0110',
									:loc_legend10,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0110\
' , :loc_legend10 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )641;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend10;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0120',
									:loc_legend11,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0120\
' , :loc_legend11 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )668;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend11;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0130',
									:loc_legend12,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0130\
' , :loc_legend12 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )695;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend12;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0140',
									:loc_legend13,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0140\
' , :loc_legend13 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )722;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend13;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0160',
									:loc_legend16,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0160\
' , :loc_legend16 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )749;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend16;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0170',
									:loc_legend17,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0170\
' , :loc_legend17 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )776;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend17;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0180',
									:loc_legend18,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0180\
' , :loc_legend18 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )803;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend18;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0190',
									:loc_legend19,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0190\
' , :loc_legend19 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )830;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend19;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0200',
									:loc_legend20,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0200\
' , :loc_legend20 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )857;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend20;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0210',
									:loc_legend21,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0210\
' , :loc_legend21 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )884;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend21;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0220',
									:loc_legend22,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0220\
' , :loc_legend22 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )911;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend22;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


	
	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
									'SM',
									'SM_LANG_LEGEND',
									'DFLT_LEGEND_VALUE',
									'MLBLR00055.LEGEND_0230',
									:loc_legend23,
									:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0230\
' , :loc_legend23 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )938;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend23;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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




	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.get_local_lang_desc(:nd_operating_facility_id,
					'SM',
					'SM_LANG_LEGEND',
					'DFLT_LEGEND_VALUE',
					'MLBLR00055.LEGEND_0240',
					:loc_legend24,
					:p_language_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facilit\
y_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , 'MLBLR00055.LEGEND_0240\
' , :loc_legend24 , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )965;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend24;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



	loc_legend1.arr[loc_legend1.len]		= '\0';
	loc_legend2.arr[loc_legend2.len]		= '\0';
	loc_legend3.arr[loc_legend3.len]		= '\0';
	loc_legend4.arr[loc_legend4.len]		= '\0';
	loc_legend5.arr[loc_legend5.len]		= '\0';
	loc_legend6.arr[loc_legend6.len]		= '\0';
	loc_legend7.arr[loc_legend7.len]		= '\0';
	loc_legend8.arr[loc_legend8.len]		= '\0';
	loc_legend9.arr[loc_legend9.len]		= '\0';
	loc_legend10.arr[loc_legend10.len]		= '\0';
	loc_legend11.arr[loc_legend11.len]		= '\0';
	loc_legend12.arr[loc_legend12.len]		= '\0';
	loc_legend13.arr[loc_legend13.len]		= '\0';
	loc_legend14.arr[loc_legend14.len]		= '\0';
	loc_legend15.arr[loc_legend15.len]		= '\0';
	loc_legend16.arr[loc_legend16.len]		= '\0';
	loc_legend17.arr[loc_legend17.len]		= '\0';
	loc_legend18.arr[loc_legend18.len]		= '\0';
	loc_legend19.arr[loc_legend19.len]		= '\0';
	loc_legend20.arr[loc_legend20.len]		= '\0';
	loc_legend21.arr[loc_legend21.len]		= '\0';
	loc_legend22.arr[loc_legend22.len]		= '\0';
	loc_legend23.arr[loc_legend23.len]		= '\0';
	loc_legend24.arr[loc_legend24.len]		= '\0';
}

check_page_break()
{
	if((line_no+5) > 55)
	{
		line_no = 0;		
		fprintf(f1,"\f");
		fprintf(f1,"\n");
		put_hdr();
	}
}