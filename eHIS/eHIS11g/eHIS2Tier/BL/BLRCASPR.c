
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
           char  filnam[41];
};
static const struct sqlcxp sqlfpn =
{
    40,
    "D:\\work\\october\\kauh_scf\\11g\\BLRCASPR.PC"
};


static unsigned long sqlctx = 507111243;


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
            void  *sqhstv[32];
   unsigned int   sqhstl[32];
            int   sqhsts[32];
            void  *sqindv[32];
            int   sqinds[32];
   unsigned int   sqharm[32];
   unsigned int   *sqharc[32];
   unsigned short  sqadto[32];
   unsigned short  sqtdso[32];
} sqlstm = {10,32};

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

 static const char *sq0006 = 
") and NVL(:b18,'~')) and RECPT_NATURE_CODE between NVL(:b19,' !! ') and NVL(\
:b20,'~~')) and NVL(RECPT_TYPE_CODE,' !!!  ') between NVL(:b21,' !!!  ') and N\
VL(:b22,'~~~')) and NVL(SLMT_TYPE_CODE,'!!!!  ') between NVL(:b23,'!!!!  ') an\
d NVL(:b24,'~~~~')) and NVL(CANCELLED_IND,'X')=DECODE(:b25,'Y','Y',NVL(CANCELL\
ED_IND,'X'))) and CASH_COUNTER_FACILITY_ID=:b26) and RECPT_REFUND_IND=DECODE(:\
b27,'R','R','F','F',RECPT_REFUND_IND)) order by CASH_COUNTER_CODE,TRUNC(DOC_DA\
TE),RECPT_REFUND_IND,DEBTOR_CATEGORY_CODE,DOC_TYPE_CODE,DOC_NUMBER            ";

 static const char *sq0007 = 
"select LONG_DESC  from BL_CASH_COUNTER_LANG_VW where ((CASH_COUNTER_CODE=:b0\
 and OPERATING_FACILITY_ID=:b1) and language_id=:b2)           ";

 static const char *sq0009 = 
"select LONG_DESC  from BL_RECEIPT_TYPE_lang_vw where (RECEIPT_TYPE_CODE=:b0 \
and language_id=:b1)           ";

 static const char *sq0010 = 
"select null  ,null  ,decode(:b0,'en',substr(short_name,1,30),substr(SHORT_NA\
ME_LOC_LANG,1,30)) ,null   from MP_PATIENT_MAST where PATIENT_ID=:b1          \
 ";

 static const char *sq0011 = 
"select LONG_NAME  from AR_CUSTOMER_LANG_VW where (CUST_CODE=:b0 and language\
_id=:b1)           ";

 static const char *sq0012 = 
"select SHORT_DESC  from BL_SLMT_TYPE_lang_vw where (SLMT_TYPE_CODE=:b0 and l\
anguage_id=:b1)           ";

 static const char *sq0008 = 
"select A.SLMT_TYPE_CODE ,B.SHORT_DESC ,sum(NVL(DOC_AMT,0)) ,sum(NVL(DOC_AMT,\
0))  from BL_RECEIPT_REFUND_HDRDTL_VW A ,BL_SLMT_TYPE_LANG_VW B where ((((((((\
(TRUNC(A.DOC_DATE,'MI') between TO_DATE(:b0,'DD/MM/YYYY HH24:MI') and TO_DATE(\
:b1,'DD/MM/YYYY HH24:MI') and language_id=:b2) and CASH_COUNTER_CODE between N\
VL(:b3,'!') and NVL(:b4,'~')) and RECPT_NATURE_CODE between NVL(:b5,'!!') and \
NVL(:b6,'~~')) and NVL(RECPT_TYPE_CODE,'!!!') between NVL(:b7,'!!!') and NVL(:\
b8,'~~~')) and NVL(A.SLMT_TYPE_CODE,'!!!!') between NVL(:b9,'!!!!') and NVL(:b\
10,'~~~~')) and NVL(CANCELLED_IND,'N')=DECODE(:b11,'Y','Y','N')) and CASH_COUN\
TER_FACILITY_ID=:b12) and RECPT_REFUND_IND=DECODE(:b13,'R','R','F','F',RECPT_R\
EFUND_IND)) and A.SLMT_TYPE_CODE=B.SLMT_TYPE_CODE) group by A.SLMT_TYPE_CODE,B\
.SHORT_DESC           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4146,0,0,0,
5,0,0,1,0,0,27,165,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,317,0,4,206,0,0,16,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
115,0,0,3,158,0,4,268,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
150,0,0,4,0,0,30,299,0,0,0,0,0,1,0,
165,0,0,5,91,0,2,308,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
188,0,0,6,1568,0,9,502,0,0,28,28,0,1,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,
1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
315,0,0,6,0,0,13,582,0,0,32,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
458,0,0,7,139,0,9,663,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
485,0,0,7,0,0,13,671,0,0,1,0,0,1,0,2,9,0,0,
504,0,0,9,107,0,9,684,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
527,0,0,9,0,0,13,692,0,0,1,0,0,1,0,2,9,0,0,
546,0,0,10,155,0,9,712,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
569,0,0,10,0,0,13,717,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
600,0,0,13,131,0,6,731,0,0,2,2,0,1,0,2,9,0,0,2,9,0,0,
623,0,0,11,95,0,9,765,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
646,0,0,11,0,0,13,773,0,0,1,0,0,1,0,2,9,0,0,
665,0,0,8,0,0,13,800,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
696,0,0,12,102,0,9,832,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
719,0,0,12,0,0,13,840,0,0,1,0,0,1,0,2,9,0,0,
738,0,0,8,800,0,9,974,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
809,0,0,8,0,0,15,996,0,0,0,0,0,1,0,
824,0,0,14,96,0,4,1469,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
847,0,0,15,104,0,4,1473,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
874,0,0,16,165,0,6,1481,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
905,0,0,17,49,0,4,1499,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
932,0,0,18,225,0,6,1520,0,0,3,3,0,1,0,3,9,0,0,1,9,0,0,1,9,0,0,
959,0,0,19,147,0,6,1576,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*                         BLRCASPR.PC                                     */
/*****************************************************************************/

/*
#define DEBUG 
*/ 
#define ESC 0x1B   
                         
#include <stdio.h>        
#include <string.h>
#include "bl.h"
#define INIT_MESG "Report Generation In Progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[91],
			d_session_id[16],
			nd_temp_date[21],
			nd_temp_date1[21],
			p_language_id[3],
			date_convert[21],
			date_convert1[21],
			nd_loc_date[21],
			nd_loc_date1[21],
			d_pgm_date[14],       
			rep_date[20],
			comp_name[50],
			oper_id[21],
			nd_facility_id[3]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

	

    /* VARCHAR report_date_fm			[17],
	        report_date_to          [17],
			cash_counter_fm         [5],
			cash_counter_to         [5],
			receipt_nature_fm       [3],
			receipt_nature_to       [3],
			receipt_type_fm         [4],
			receipt_type_to         [4],
			slmt_type_fm            [3],
			slmt_type_to            [3],
			l_len_value	            [3],
			l_pk_value		        [100],
		    l_translated_value	    [201],
			cancelled_docs          [2],
			print_flag              [2]; */ 
struct { unsigned short len; unsigned char arr[17]; } report_date_fm;

struct { unsigned short len; unsigned char arr[17]; } report_date_to;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_fm;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_to;

struct { unsigned short len; unsigned char arr[3]; } receipt_nature_fm;

struct { unsigned short len; unsigned char arr[3]; } receipt_nature_to;

struct { unsigned short len; unsigned char arr[4]; } receipt_type_fm;

struct { unsigned short len; unsigned char arr[4]; } receipt_type_to;

struct { unsigned short len; unsigned char arr[3]; } slmt_type_fm;

struct { unsigned short len; unsigned char arr[3]; } slmt_type_to;

struct { unsigned short len; unsigned char arr[3]; } l_len_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[2]; } cancelled_docs;

struct { unsigned short len; unsigned char arr[2]; } print_flag;

		
        
   /* VARCHAR d_recpt_refund_ind                          [2],
           d_recpt_refund_desc                         [31],
           d_doc_type_code                             [7],
		   
           d_doc_number                                [9],
		   d_doc_srno		                           [7],
           d_recpt_nature_code                         [3],
           d_recpt_nature_desc                         [16],
           d_debtor_category_code                      [2],
           d_debtor_category_desc                      [60],
           d_doc_date                                  [21],
           d_trx_date_time                             [21],
           d_episode_type                              [2],
           d_patient_id                                [21],
           d_short_name_full                           [61],
           d_patient_name                              [61],
		   d_patient_name1							   [61],
           d_patient_name_loc_lang                     [61],
           d_episode_id                                [9],
           d_visit_id                                  [5],
           d_bill_doc_type_code                        [7],
           d_bill_doc_number                           [9],
		   d_bill_doc_srno                             [7],
           d_customer_code                             [9],
           d_cust_name                                 [101],
           d_cash_counter_code                         [5],
           d_counter_desc                              [101],
           d_shift_id                                  [2],
           d_doc_amt                                   [23],
           d_recpt_type_code                           [4],
           d_recpt_desc                                [101],
           d_slmt_type_code                            [3],
           d_slmt_type_desc                            [101],
           d_slmt_doc_ref_desc                         [21],
           d_slmt_doc_ref_date                         [19],
			d_slmt_doc_ref_date1                       [21],
           d_slmt_doc_remarks                          [31],
           d_cancelled_ind                             [2],
           d_narration                                 [81],
		   nd_cancel_reason							   [51],
           d_ip_adm_trf_dep_ind                        [2],
		   nd_operating_facility_id					   [3]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_recpt_refund_ind;

struct { unsigned short len; unsigned char arr[31]; } d_recpt_refund_desc;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[7]; } d_doc_srno;

struct { unsigned short len; unsigned char arr[3]; } d_recpt_nature_code;

struct { unsigned short len; unsigned char arr[16]; } d_recpt_nature_desc;

struct { unsigned short len; unsigned char arr[2]; } d_debtor_category_code;

struct { unsigned short len; unsigned char arr[60]; } d_debtor_category_desc;

struct { unsigned short len; unsigned char arr[21]; } d_doc_date;

struct { unsigned short len; unsigned char arr[21]; } d_trx_date_time;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name1;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_bill_doc_number;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_srno;

struct { unsigned short len; unsigned char arr[9]; } d_customer_code;

struct { unsigned short len; unsigned char arr[101]; } d_cust_name;

struct { unsigned short len; unsigned char arr[5]; } d_cash_counter_code;

struct { unsigned short len; unsigned char arr[101]; } d_counter_desc;

struct { unsigned short len; unsigned char arr[2]; } d_shift_id;

struct { unsigned short len; unsigned char arr[23]; } d_doc_amt;

struct { unsigned short len; unsigned char arr[4]; } d_recpt_type_code;

struct { unsigned short len; unsigned char arr[101]; } d_recpt_desc;

struct { unsigned short len; unsigned char arr[3]; } d_slmt_type_code;

struct { unsigned short len; unsigned char arr[101]; } d_slmt_type_desc;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[19]; } d_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_date1;

struct { unsigned short len; unsigned char arr[31]; } d_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[2]; } d_cancelled_ind;

struct { unsigned short len; unsigned char arr[81]; } d_narration;

struct { unsigned short len; unsigned char arr[51]; } nd_cancel_reason;

struct { unsigned short len; unsigned char arr[2]; } d_ip_adm_trf_dep_ind;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;


  /* VARCHAR  d_prv_cash_counter_code                      [5],
           d_prv_doc_date                               [11],
           d_prv_recpt_refund_ind                       [2],
           d_prv_debtor_category_code                   [2],
           d_prv_debtor_category_desc                   [60]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_prv_cash_counter_code;

struct { unsigned short len; unsigned char arr[11]; } d_prv_doc_date;

struct { unsigned short len; unsigned char arr[2]; } d_prv_recpt_refund_ind;

struct { unsigned short len; unsigned char arr[2]; } d_prv_debtor_category_code;

struct { unsigned short len; unsigned char arr[60]; } d_prv_debtor_category_desc;

            
    double d_doc_amt_num,
		   nd_doc_amt,
		   tot_doc_amt;
	char   filename[150];
	char loc_legend[999][201];
	char x_msg[200];
	char l_mesg[200];

    int i;		
           

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

FILE *f1;

int page_no,
    line_no,
    first_line,
    g_hdr_cnt,
    g_err_typ,
    g_page_break;

char file_name[15],
     g_acct_code[41],
     g_err_id[8],
     g_err_msg[72];

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

    if(argc != 5) {
        disp_message(ERR_MESG,"BLRCASPR : Usage BLRCASPR userid/password session_id pgm_date facility_id \n");
        proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

	strcpy(nd_facility_id.arr,argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr); //PRADEEP
	nd_facility_id.arr[nd_facility_id.len] = '\0';

    strcpy(g_pgm_id,"BLRCASPR");
    strcpy(g_pgm_date,argv[3]);

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



    if(ERROR) {
		disp_message(ERR_MESG,"Unable to connect to oracle.\n");
		proc_exit();
    }

   set_meduser_role();

   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;
   
   start_prog_msg();

 
   report_date_fm.arr[0]           = '\0';
   report_date_to.arr[0]           = '\0';
   cash_counter_fm.arr[0]          = '\0';
   cash_counter_to.arr[0]          = '\0';
   receipt_nature_fm.arr[0]        = '\0';
   receipt_nature_to.arr[0]        = '\0';
   receipt_type_fm.arr[0]          = '\0';
   receipt_type_to.arr[0]          = '\0';
   slmt_type_fm.arr[0]             = '\0';
   slmt_type_to.arr[0]             = '\0';
   cancelled_docs.arr[0]           = '\0';
   print_flag.arr[0]               = '\0';

   report_date_fm.len              = 0;
   report_date_to.len              = 0;
   cash_counter_fm.len             = 0;
   cash_counter_to.len             = 0;
   receipt_nature_fm.len           = 0;
   receipt_nature_to.len           = 0;
   receipt_type_fm.len             = 0;
   receipt_type_to.len             = 0;
   cancelled_docs.len              = 0;
   print_flag.len                  = 0;
   slmt_type_fm.len                = 0;
   slmt_type_to.len                = 0;

	/* EXEC SQL SELECT 
			OPERATING_FACILITY_ID,
			PARAM1,            /o REP_DATE_FM                o/
			PARAM2,            /o REP_DATE_TO                o/
			PARAM3,            /o CASH_COUNTER_FM            o/
			PARAM4,            /o CASH_COUNTER_TO            o/
			PARAM5,            /o RECEIPT_NATURE_FM          o/
			PARAM6,            /o RECEIPT_NATURE_TO          o/
			PARAM7,            /o RECEIPT_TYPE_FM            o/
			PARAM8,            /o RECEIPT_TYPE_TO            o/
			PARAM9,            /o SLMT_TYPE_FM               o/
			PARAM10,           /o SLMT_TYPE_TO               o/
			PARAM11,           /o CANCELLED_DOCS             o/
			PARAM12            /oIN PRT_FLAG                 o/
		 INTO			:nd_operating_facility_id,
						:report_date_fm,                                         //report_date_to,
                        :report_date_to,                                        //caport_date_fm,
						:cash_counter_fm,                                      //resh_counter_fm,
                        :cash_counter_to,                                     //cash_counter_to,
                        :receipt_nature_fm,                                  //receipt_nature_fm,
                        :receipt_nature_to,                                 //receit_type_fm,
                        :receipt_type_fm,                                  //receipt_pt_nature_to,
                        :receipt_type_to,                                 //receiptype_to,
						:slmt_type_fm,                                   //slmt_type_fm,
						:slmt_type_to,                                  //slmt_type_to,
                        :cancelled_docs,
                        :print_flag
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRCASPR'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = TO_NUMBER(:d_session_id)
		 AND    OPERATING_FACILITY_ID =:nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 into :b0,:\
b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12  from SY_PROG_PARAM where ((\
(PGM_ID='BLRCASPR' and PGM_DATE=:b13) and SESSION_ID=TO_NUMBER(:b14)) and OPER\
ATING_FACILITY_ID=:b15)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstv[3] = (         void  *)&cash_counter_fm;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&cash_counter_to;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&receipt_nature_fm;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&receipt_nature_to;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&receipt_type_fm;
 sqlstm.sqhstl[7] = (unsigned int  )6;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&receipt_type_to;
 sqlstm.sqhstl[8] = (unsigned int  )6;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&slmt_type_fm;
 sqlstm.sqhstl[9] = (unsigned int  )5;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&slmt_type_to;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&cancelled_docs;
 sqlstm.sqhstl[11] = (unsigned int  )4;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&print_flag;
 sqlstm.sqhstl[12] = (unsigned int  )4;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[13] = (unsigned int  )16;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_session_id;
 sqlstm.sqhstl[14] = (unsigned int  )18;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[15] = (unsigned int  )5;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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

   report_date_fm.arr[report_date_fm.len]            = '\0';
   report_date_to.arr[report_date_to.len]            = '\0';
   cash_counter_fm.arr[cash_counter_fm.len]          = '\0';
   cash_counter_to.arr[cash_counter_to.len]          = '\0';
   receipt_nature_fm.arr[receipt_nature_fm.len]      = '\0';
   receipt_nature_to.arr[receipt_nature_to.len]      = '\0';
   receipt_type_fm.arr[receipt_type_fm.len]          = '\0';
   receipt_type_to.arr[receipt_type_to.len]          = '\0';
   cancelled_docs.arr[cancelled_docs.len]            = '\0';
   print_flag.arr[print_flag.len]                    = '\0';
   slmt_type_fm.arr[slmt_type_fm.len]                = '\0';
   slmt_type_to.arr[slmt_type_to.len]                = '\0';

   strcpy(g_facility_id, nd_operating_facility_id.arr);
   strcpy(filename,WORKING_DIR);
   strcat(filename,"blrcaspr.lis");

    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file...BLRUNBRF.LIS");
	proc_exit();

    }
 

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
	     INTO		:comp_name,
					:rep_date,
					:oper_id
	     FROM		SY_ACC_ENTITY_lang_vw
		 WHERE		ACC_ENTITY_ID = :nd_operating_facility_id
		 AND		language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )115;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&p_language_id;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )150;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}


del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
         WHERE  PGM_ID     = 'BLRCASPR' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRCASPR' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )165;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
               SELECT RECPT_REFUND_IND,
			   /oDECODE(RECPT_REFUND_IND,'R','Receipts',
					       'Payments / Refunds'),  commented by saikiran for 19587o/
                 DECODE(RECPT_REFUND_IND,'R',:loc_legend[54],
					       :loc_legend[55]),  
                      DOC_TYPE_CODE,
                      DOC_NUMBER,
					  DOC_SRNO,
                      RECPT_NATURE_CODE,
					  DECODE(RECPT_NATURE_CODE,'AD',:loc_legend[56],
					       'RD',:loc_legend[57],
					       'PR',:loc_legend[58],
					       'MI',:loc_legend[59],
					       'DC',:loc_legend[60],
					       'BI',:loc_legend[61],
					       'CU',:loc_legend[62]), 
					  /oDECODE(RECPT_NATURE_CODE,'AD','Adjustable Dep ',
					       'RD','Refundable Dep ',
					       'PR','Prepayments',
					       'MI','Miscellaneous',
					       'DC','Def. Cash Pat.',
					       'BI','Against Bill',
					       'CU','Customers'), commented by saikiran for 19587o/
                      DEBTOR_CATEGORY_CODE,
		      /oDECODE(DEBTOR_CATEGORY_CODE,
			     'I','Inpatients',
				 'D','Daycare',			//31/10/2004
			     'O','Outpatients',
				 'E','Emergency',
				 'R','Referal Patients',
			     'Miscellaneous (Deferred cash patients, Customers, Others)'), commented by saikiran for 19587o/
                      DECODE(DEBTOR_CATEGORY_CODE,
					 'I',:loc_legend[63],
					 'D',:loc_legend[64],	
					 'O',:loc_legend[65],
					 'E',:loc_legend[66],
					 'R',:loc_legend[67],
					 :loc_legend[68]), 
					  TO_CHAR(TRUNC(DOC_DATE),'DD/MM/RRRR'),
                      TO_CHAR(TRX_DATE_TIME,'DD/MM/YYYY HH24:MI'),  
                      EPISODE_TYPE,
                      PATIENT_ID,
                      EPISODE_ID,
                      VISIT_ID,
                      BILL_DOC_TYPE_CODE, 
                      LTRIM(TO_CHAR(BILL_DOC_NUMBER,'00000009')),
					  BILL_DOC_SRNO, 	
                      CUSTOMER_CODE,
                      CASH_COUNTER_CODE, 
                      SHIFT_ID,
                      TO_CHAR(DOC_AMT,'999,999,990.99'),
                      DOC_AMT,
                      RECPT_TYPE_CODE,
                      SLMT_TYPE_CODE,
                      SLMT_DOC_REF_DESC,
					  
                      TO_CHAR(TRUNC(SLMT_DOC_REF_DATE),'DD/MM/RRRR'),
					  //TO_CHAR(SLMT_DOC_REF_DATE,'DD/MM/YYYY HH24:MI'), 
                      SLMT_DOC_REMARKS,
                      DECODE(CANCELLED_IND,'N',' ',CANCELLED_IND),
                      SUBSTR(NARRATION,1,40),
                      IP_ADM_TRF_DEP_IND,
					  CANCEL_REASON
                 FROM BL_RECEIPT_REFUND_HDRDTL_VW
		/o WHERE ADDED_DATE  BETWEEN o/
		WHERE TRUNC(DOC_DATE,'MI')  BETWEEN
		/o---- Added on 14/03/1998 ------------o/
		      TO_DATE(:report_date_fm,'DD/MM/YYYY HH24:MI') AND
              TO_DATE(:report_date_to,'DD/MM/YYYY HH24:MI')
		/o------------------------------------o/
		  AND CASH_COUNTER_CODE BETWEEN
              NVL(:cash_counter_fm,' ! ')   AND 
			  NVL(:cash_counter_to,'~')                     //~~
 
		  AND RECPT_NATURE_CODE BETWEEN
			  NVL(:receipt_nature_fm,' !! ') AND 
			  NVL(:receipt_nature_to,'~~')                  //~~

		  AND NVL(RECPT_TYPE_CODE,' !!!  ')  BETWEEN
			  NVL(:receipt_type_fm,' !!!  ') AND 
			  NVL(:receipt_type_to,'~~~')                   //~~~

		  AND NVL(SLMT_TYPE_CODE,'!!!!  ')  BETWEEN
			  NVL(:slmt_type_fm,'!!!!  ')   AND 
			  NVL(:slmt_type_to,'~~~~')                     //~~ 

		  AND NVL(CANCELLED_IND,'X') = 
			  DECODE(:cancelled_docs,'Y','Y',NVL(CANCELLED_IND,'X'))
		  AND CASH_COUNTER_FACILITY_ID  = :nd_operating_facility_id
		  AND RECPT_REFUND_IND = 
			  DECODE(:print_flag,'R','R','F','F',RECPT_REFUND_IND)
		ORDER BY CASH_COUNTER_CODE, TRUNC(DOC_DATE), RECPT_REFUND_IND,
			 DEBTOR_CATEGORY_CODE, DOC_TYPE_CODE, DOC_NUMBER; */ 

  
    /* EXEC SQL DECLARE CASH_COUNTER_CUR CURSOR FOR
	     SELECT  LONG_DESC 
	     FROM     BL_CASH_COUNTER_LANG_VW
	     WHERE   CASH_COUNTER_CODE = :d_cash_counter_code
		 AND     OPERATING_FACILITY_ID = :nd_operating_facility_id
		 and language_id=:p_language_id; */ 



   /*------- Added on 14/03/1999 to get Slmt Totals------*/

    /* EXEC SQL DECLARE BL_SLMT_TOTALS CURSOR FOR
               SELECT A.SLMT_TYPE_CODE,
		              B.SHORT_DESC,
				      SUM(NVL(DOC_AMT,0)),
				      SUM(NVL(DOC_AMT,0))
                 FROM BL_RECEIPT_REFUND_HDRDTL_VW A, BL_SLMT_TYPE_LANG_VW B
		 /o WHERE A.ADDED_DATE  BETWEEN o/
		    WHERE TRUNC(A.DOC_DATE,'MI')  BETWEEN 
		      TO_DATE(:report_date_fm,'DD/MM/YYYY HH24:MI') AND
              TO_DATE(:report_date_to,'DD/MM/YYYY HH24:MI')
		  and language_id=:p_language_id	
		  AND CASH_COUNTER_CODE BETWEEN
			  NVL(:cash_counter_fm,'!') AND 
			  NVL(:cash_counter_to,'~') 
	/o------ Added 0n 14/03/1999 -----------------o/
		  AND RECPT_NATURE_CODE BETWEEN
			  NVL(:receipt_nature_fm,'!!') AND 
			  NVL(:receipt_nature_to,'~~')
		  AND NVL(RECPT_TYPE_CODE,'!!!') BETWEEN
			  NVL(:receipt_type_fm,'!!!') AND 
			  NVL(:receipt_type_to,'~~~')
		  AND NVL(A.SLMT_TYPE_CODE,'!!!!') BETWEEN
			  NVL(:slmt_type_fm,'!!!!') AND
			  NVL(:slmt_type_to,'~~~~')
		  AND NVL(CANCELLED_IND,'N') = 
			  DECODE(:cancelled_docs,'Y','Y','N')
		  AND CASH_COUNTER_FACILITY_ID  = :nd_operating_facility_id
		  AND RECPT_REFUND_IND = 
			  DECODE(:print_flag,'R','R','F','F',RECPT_REFUND_IND)
	/o--------------------------------------------o/		 
    	  AND A.SLMT_TYPE_CODE = B.SLMT_TYPE_CODE
		GROUP BY A.SLMT_TYPE_CODE,B.SHORT_DESC; */ 


   
   /*------- Added on 14/03/1999 to get Slmt Totals------*/
   
    /* EXEC SQL DECLARE RECPT_TYPE_CUR CURSOR FOR
	     SELECT  LONG_DESC 
	     FROM    BL_RECEIPT_TYPE_lang_vw
	     WHERE   RECEIPT_TYPE_CODE = :d_recpt_type_code
		 and     language_id=:p_language_id; */ 
           //Mode of Payment

    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
/o	     SELECT  
		         substr(SHORT_NAME,1,30),
				 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
				
				 SHORT_NAME_LOC_LANG,short_name
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :d_patient_id; o/

		 SELECT  
			null, 
			null,
			decode(:p_language_id,'en', substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,30)),
			null
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :d_patient_id; */ 



    /* EXEC SQL DECLARE CUSTOMER_CUR CURSOR FOR
	     SELECT  LONG_NAME
	     FROM    AR_CUSTOMER_LANG_VW
	     WHERE   CUST_CODE = :d_customer_code
		 and language_id=:p_language_id; */ 

	 
		 
										                 //Name of the Hospital 

    /* EXEC SQL DECLARE SLMT_TYPE_CUR CURSOR FOR
	     SELECT  SHORT_DESC
	     FROM    BL_SLMT_TYPE_lang_vw
	     WHERE   SLMT_TYPE_CODE = :d_slmt_type_code
		 and language_id=:p_language_id; */ 
               //Payment Through

    /* EXEC SQL OPEN BL_REC_REF_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 28;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select RECPT_REFUND_IND ,DECODE(RECPT_REFUND_IND,'R',:b0,:b1) ,DOC_TY\
PE_CODE ,DOC_NUMBER ,DOC_SRNO ,RECPT_NATURE_CODE ,DECODE(RECPT_NATURE_CODE,'\
AD',:b2,'RD',:b3,'PR',:b4,'MI',:b5,'DC',:b6,'BI',:b7,'CU',:b8) ,DEBTOR_CATEG\
ORY_CODE ,DECODE(DEBTOR_CATEGORY_CODE,'I',:b9,'D',:b10,'O',:b11,'E',:b12,'R'\
,:b13,:b14) ,TO_CHAR(TRUNC(DOC_DATE),'DD/MM/RRRR') ,TO_CHAR(TRX_DATE_TIME,'D\
D/MM/YYYY HH24:MI') ,EPISODE_TYPE ,PATIENT_ID ,EPISODE_ID ,VISIT_ID ,BILL_DO\
C_TYPE_CODE ,LTRIM(TO_CHAR(BILL_DOC_NUMBER,'00000009')) ,BILL_DOC_SRNO ,CUST\
OMER_CODE ,CASH_COUNTER_CODE ,SHIFT_ID ,TO_CHAR(DOC_AMT,'999,999,990.99') ,D\
OC_AMT ,RECPT_TYPE_CODE ,SLMT_TYPE_CODE ,SLMT_DOC_REF_DESC ,TO_CHAR(TRUNC(SL\
MT_DOC_REF_DATE),'DD/MM/RRRR') ,SLMT_DOC_REMARKS ,DECODE(CANCELLED_IND,'N','\
 ',CANCELLED_IND) ,SUBSTR(NARRATION,1,40) ,IP_ADM_TRF_DEP_IND ,CANCEL_REASON\
  from BL_RECEIPT_REFUND_HDRDTL_VW where (((((((TRUNC(DOC_DATE,'MI') between\
 TO_DATE(:b15,'DD/MM/YYYY HH24:MI') and TO_DATE(:b16,'DD/MM/YYYY HH24:MI') a\
nd CASH_COUNTER_CODE between NVL(:b17,' ! '");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )188;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)loc_legend[54];
    sqlstm.sqhstl[0] = (unsigned int  )201;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)loc_legend[55];
    sqlstm.sqhstl[1] = (unsigned int  )201;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)loc_legend[56];
    sqlstm.sqhstl[2] = (unsigned int  )201;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)loc_legend[57];
    sqlstm.sqhstl[3] = (unsigned int  )201;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)loc_legend[58];
    sqlstm.sqhstl[4] = (unsigned int  )201;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)loc_legend[59];
    sqlstm.sqhstl[5] = (unsigned int  )201;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)loc_legend[60];
    sqlstm.sqhstl[6] = (unsigned int  )201;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)loc_legend[61];
    sqlstm.sqhstl[7] = (unsigned int  )201;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)loc_legend[62];
    sqlstm.sqhstl[8] = (unsigned int  )201;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)loc_legend[63];
    sqlstm.sqhstl[9] = (unsigned int  )201;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)loc_legend[64];
    sqlstm.sqhstl[10] = (unsigned int  )201;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)loc_legend[65];
    sqlstm.sqhstl[11] = (unsigned int  )201;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)loc_legend[66];
    sqlstm.sqhstl[12] = (unsigned int  )201;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)loc_legend[67];
    sqlstm.sqhstl[13] = (unsigned int  )201;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)loc_legend[68];
    sqlstm.sqhstl[14] = (unsigned int  )201;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&report_date_fm;
    sqlstm.sqhstl[15] = (unsigned int  )19;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&report_date_to;
    sqlstm.sqhstl[16] = (unsigned int  )19;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&cash_counter_fm;
    sqlstm.sqhstl[17] = (unsigned int  )7;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&cash_counter_to;
    sqlstm.sqhstl[18] = (unsigned int  )7;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&receipt_nature_fm;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&receipt_nature_to;
    sqlstm.sqhstl[20] = (unsigned int  )5;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&receipt_type_fm;
    sqlstm.sqhstl[21] = (unsigned int  )6;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&receipt_type_to;
    sqlstm.sqhstl[22] = (unsigned int  )6;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&slmt_type_fm;
    sqlstm.sqhstl[23] = (unsigned int  )5;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&slmt_type_to;
    sqlstm.sqhstl[24] = (unsigned int  )5;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&cancelled_docs;
    sqlstm.sqhstl[25] = (unsigned int  )4;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[26] = (unsigned int  )5;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&print_flag;
    sqlstm.sqhstl[27] = (unsigned int  )4;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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

    d_recpt_refund_ind.arr[0]                                         = '\0';
    d_doc_type_code.arr[0]                                            = '\0';
	
    d_doc_number.arr[0]                                               = '\0';
	d_doc_srno.arr[0]                                                 = '\0';
    d_recpt_nature_code.arr[0]                                        = '\0';
    d_debtor_category_code.arr[0]                                     = '\0';
    d_doc_date.arr[0]                                                 = '\0';
    d_trx_date_time.arr[0]                                            = '\0';
    d_episode_type.arr[0]                                             = '\0';
    d_patient_id.arr[0]                                               = '\0';
    d_episode_id.arr[0]                                               = '\0';
    d_visit_id.arr[0]                                                 = '\0';
    d_bill_doc_type_code.arr[0]                                       = '\0';
    d_bill_doc_number.arr[0]                                          = '\0';
	d_bill_doc_srno.arr[0]                                                = '\0';
    d_customer_code.arr[0]                                            = '\0';
    d_cash_counter_code.arr[0]                                        = '\0';
    d_shift_id.arr[0]                                                 = '\0';
    d_doc_amt.arr[0]                                                  = '\0';
    d_recpt_type_code.arr[0]                                          = '\0';
    d_slmt_type_code.arr[0]                                           = '\0';
    d_slmt_doc_ref_desc.arr[0]                                        = '\0';
    d_slmt_doc_ref_date.arr[0]                                        = '\0';
	    d_slmt_doc_ref_date1.arr[0]                                        = '\0';
    d_slmt_doc_remarks.arr[0]                                         = '\0';
    d_cancelled_ind.arr[0]                                            = '\0';
    d_narration.arr[0]                                                = '\0';
    d_recpt_refund_desc.arr[0]                                        = '\0';
    d_recpt_nature_desc.arr[0]                                        = '\0';
    d_debtor_category_desc.arr[0]                                     = '\0';
    d_ip_adm_trf_dep_ind.arr[0]                                       = '\0';
	nd_cancel_reason.arr[0]											  = '\0';

    d_recpt_refund_ind.len                                            = 0;
    d_doc_type_code.len                                               = 0;
	
    d_doc_number.len                                                  = 0;
	d_doc_srno.len                                                    = 0;
    d_recpt_nature_code.len                                           = 0;
    d_debtor_category_code.len                                        = 0;
    d_doc_date.len                                                    = 0;
    d_trx_date_time.len                                               = 0;
    d_episode_type.len                                                = 0;
    d_patient_id.len                                                  = 0;
    d_episode_id.len                                                  = 0;
    d_visit_id.len                                                    = 0;
    d_bill_doc_type_code.len                                          = 0;
    d_bill_doc_number.len                                             = 0;
	d_bill_doc_srno.len                                               = 0;
    d_customer_code.len                                               = 0;
    d_cash_counter_code.len                                           = 0;
    d_shift_id.len                                                    = 0;
    d_doc_amt.len                                                     = 0;
    d_recpt_type_code.len                                             = 0;
    d_slmt_type_code.len                                              = 0;
    d_slmt_doc_ref_desc.len                                           = 0;
    d_slmt_doc_ref_date.len                                           = 0;
	d_slmt_doc_ref_date1.len                                           = 0;
    d_slmt_doc_remarks.len                                            = 0;
    d_cancelled_ind.len                                               = 0;
    d_narration.len                                                   = 0;
    d_recpt_refund_desc.len                                           = 0;
    d_recpt_nature_desc.len                                           = 0;
    d_debtor_category_desc.len                                        = 0;
    d_ip_adm_trf_dep_ind.len                                          = 0;
	nd_cancel_reason.len  											  = 0;

    d_doc_amt_num = 0;

     /* EXEC SQL FETCH BL_REC_REF_CUR
               INTO :d_recpt_refund_ind,
		    :d_recpt_refund_desc,
                    :d_doc_type_code,
					:d_doc_number,
					:d_doc_srno,
                    :d_recpt_nature_code,
                    :d_recpt_nature_desc,
                    :d_debtor_category_code,
                    :d_debtor_category_desc,
                    :d_doc_date,
                    :d_trx_date_time,
                    :d_episode_type,
                    :d_patient_id,
                    :d_episode_id,
                    :d_visit_id,
                    :d_bill_doc_type_code,
                    :d_bill_doc_number,
					:d_bill_doc_srno,
                    :d_customer_code,
                    :d_cash_counter_code,
                    :d_shift_id,
                    :d_doc_amt,
                    :d_doc_amt_num,
                    :d_recpt_type_code,
                    :d_slmt_type_code,
                    :d_slmt_doc_ref_desc,
                    :d_slmt_doc_ref_date,
                    :d_slmt_doc_remarks,
                    :d_cancelled_ind,
                    :d_narration,
                    :d_ip_adm_trf_dep_ind,
					:nd_cancel_reason; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 32;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )315;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_recpt_refund_ind;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_recpt_refund_desc;
     sqlstm.sqhstl[1] = (unsigned int  )33;
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
     sqlstm.sqhstv[4] = (         void  *)&d_doc_srno;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_recpt_nature_code;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_recpt_nature_desc;
     sqlstm.sqhstl[6] = (unsigned int  )18;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_debtor_category_code;
     sqlstm.sqhstl[7] = (unsigned int  )4;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_debtor_category_desc;
     sqlstm.sqhstl[8] = (unsigned int  )62;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_doc_date;
     sqlstm.sqhstl[9] = (unsigned int  )23;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_trx_date_time;
     sqlstm.sqhstl[10] = (unsigned int  )23;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&d_episode_type;
     sqlstm.sqhstl[11] = (unsigned int  )4;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&d_patient_id;
     sqlstm.sqhstl[12] = (unsigned int  )23;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&d_episode_id;
     sqlstm.sqhstl[13] = (unsigned int  )11;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&d_visit_id;
     sqlstm.sqhstl[14] = (unsigned int  )7;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&d_bill_doc_type_code;
     sqlstm.sqhstl[15] = (unsigned int  )9;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&d_bill_doc_number;
     sqlstm.sqhstl[16] = (unsigned int  )11;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&d_bill_doc_srno;
     sqlstm.sqhstl[17] = (unsigned int  )9;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&d_customer_code;
     sqlstm.sqhstl[18] = (unsigned int  )11;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&d_cash_counter_code;
     sqlstm.sqhstl[19] = (unsigned int  )7;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&d_shift_id;
     sqlstm.sqhstl[20] = (unsigned int  )4;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&d_doc_amt;
     sqlstm.sqhstl[21] = (unsigned int  )25;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&d_doc_amt_num;
     sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&d_recpt_type_code;
     sqlstm.sqhstl[23] = (unsigned int  )6;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&d_slmt_type_code;
     sqlstm.sqhstl[24] = (unsigned int  )5;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&d_slmt_doc_ref_desc;
     sqlstm.sqhstl[25] = (unsigned int  )23;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&d_slmt_doc_ref_date;
     sqlstm.sqhstl[26] = (unsigned int  )21;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&d_slmt_doc_remarks;
     sqlstm.sqhstl[27] = (unsigned int  )33;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&d_cancelled_ind;
     sqlstm.sqhstl[28] = (unsigned int  )4;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&d_narration;
     sqlstm.sqhstl[29] = (unsigned int  )83;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&d_ip_adm_trf_dep_ind;
     sqlstm.sqhstl[30] = (unsigned int  )4;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&nd_cancel_reason;
     sqlstm.sqhstl[31] = (unsigned int  )53;
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
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
	return 0;

    d_recpt_refund_ind.arr[d_recpt_refund_ind.len]                       = '\0';
    d_doc_type_code.arr[d_doc_type_code.len]                             = '\0';
	
    d_doc_number.arr[d_doc_number.len]                                   = '\0';
	d_doc_srno.arr[d_doc_srno.len]                             = '\0';
    d_recpt_nature_code.arr[d_recpt_nature_code.len]                     = '\0';
    d_debtor_category_code.arr[d_debtor_category_code.len]               = '\0';
    d_doc_date.arr[d_doc_date.len]                                       = '\0';
    d_trx_date_time.arr[d_trx_date_time.len]                             = '\0';
    d_episode_type.arr[d_episode_type.len]                               = '\0';
    d_patient_id.arr[d_patient_id.len]                                   = '\0';
    d_episode_id.arr[d_episode_id.len]                                   = '\0';
    d_visit_id.arr[d_visit_id.len]                                       = '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]                   = '\0';
    d_bill_doc_number.arr[d_bill_doc_number.len]                         = '\0';
	d_bill_doc_srno.arr[d_bill_doc_srno.len]                             = '\0';
    d_customer_code.arr[d_customer_code.len]                             = '\0';
    d_cash_counter_code.arr[d_cash_counter_code.len]                     = '\0';
    d_shift_id.arr[d_shift_id.len]                                       = '\0';
    d_doc_amt.arr[d_doc_amt.len]                                         = '\0';
    d_recpt_type_code.arr[d_recpt_type_code.len]                         = '\0';
    d_slmt_type_code.arr[d_slmt_type_code.len]                           = '\0';
    d_slmt_doc_ref_desc.arr[d_slmt_doc_ref_desc.len]                     = '\0';
    d_slmt_doc_ref_date.arr[d_slmt_doc_ref_date.len]                     = '\0';
	d_slmt_doc_ref_date1.arr[d_slmt_doc_ref_date.len]                     = '\0';
    d_slmt_doc_remarks.arr[d_slmt_doc_remarks.len]                       = '\0';
    d_cancelled_ind.arr[d_cancelled_ind.len]                             = '\0';
    d_narration.arr[d_narration.len]                                     = '\0';
    d_recpt_refund_desc.arr[d_recpt_refund_desc.len]                     = '\0';
    d_recpt_nature_desc.arr[d_recpt_nature_desc.len]                     = '\0';
    d_debtor_category_desc.arr[d_debtor_category_desc.len]               = '\0';
    d_ip_adm_trf_dep_ind.arr[d_ip_adm_trf_dep_ind.len]                   = '\0';
	nd_cancel_reason.arr[nd_cancel_reason.len]						     = '\0';

    return 1;

}

fetch_counter_desc()
{

    /* EXEC SQL OPEN CASH_COUNTER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )458;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cash_counter_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
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



    if(ERROR)
        err_mesg("OPEN failed on cursor CASH_COUNTER_CUR",0,"");

    d_counter_desc.arr[0]  = '\0';
    d_counter_desc.len  = 0;

    /* EXEC SQL FETCH CASH_COUNTER_CUR 
	     INTO  :d_counter_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )485;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_counter_desc;
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



    if(ERROR)
        err_mesg("FETCH failed on cursor CASH_COUNTER_CUR",0,"");
   
    d_counter_desc.arr[d_counter_desc.len]  = '\0';

}

fetch_recpt_desc()
{

    /* EXEC SQL OPEN RECPT_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )504;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_recpt_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )6;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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



    if(ERROR)
        err_mesg("OPEN failed on cursor RECPT_TYPE_CUR",0,"");

    d_recpt_desc.arr[0]  = '\0';
    d_recpt_desc.len  = 0;

    /* EXEC SQL FETCH RECPT_TYPE_CUR 
	     INTO  :d_recpt_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )527;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_recpt_desc;
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



    if(ERROR)
        err_mesg("FETCH failed on cursor RECPT_TYPE_CUR",0,"");
   
    d_recpt_desc.arr[d_recpt_desc.len]  = '\0';

}
fetch_patient_name()
{

    d_patient_name.arr[0]  = '\0';
	d_patient_name1.arr[0]  = '\0';
    d_patient_name_loc_lang.arr[0]  = '\0';

    d_patient_name.len  = 0;
	d_patient_name1.len  = 0;
    d_patient_name_loc_lang.len  = 0;

    /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )546;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&p_language_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

    /* EXEC SQL FETCH MP_PATIENT_MAST_CUR 
	     INTO  :d_patient_name,
			   :d_patient_name1,
		       :d_patient_name_loc_lang,
               :d_short_name_full  ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )569;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_patient_name1;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_patient_name_loc_lang;
    sqlstm.sqhstl[2] = (unsigned int  )63;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_short_name_full;
    sqlstm.sqhstl[3] = (unsigned int  )63;
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



    if(ERROR)
	err_mesg("FETCH failed on table MP_PATIENT_MAST_CUR",0,"");

   /* d_patient_name.arr[d_patient_name.len]  = '\0';
	d_patient_name1.arr[d_patient_name1.len]  = '\0';*/
    d_patient_name_loc_lang.arr[d_patient_name_loc_lang.len]  = '\0';
    d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
   /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
/o     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :d_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_name1    := :d_patient_name1 || str2;
       end if;
o/
	 :d_patient_name   :=null;
     :d_patient_name1    :=null;
 END;
  END;
       
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 32;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 )\
 ; BEGIN :d_patient_name := null ; :d_patient_name1 := null ; END ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )600;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_patient_name1;
   sqlstm.sqhstl[1] = (unsigned int  )63;
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


       d_patient_name.arr[d_patient_name.len]  = '\0';
       d_patient_name1.arr[d_patient_name1.len]  = '\0';
}

fetch_cust_name()
{

    /* EXEC SQL OPEN CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )623;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_customer_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor CUSTOMER_CUR",0,"");

    d_cust_name.arr[0]  = '\0';
    d_cust_name.len  = 0;

    /* EXEC SQL FETCH CUSTOMER_CUR 
	     INTO  :d_cust_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )646;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_name;
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



    if(ERROR)
	err_mesg("FETCH failed on cursor CUSTOMER_CUR",0,"");
	      
    d_cust_name.arr[d_cust_name.len]  = '\0';

}

/*-------- Added on 14/03/1999 to Print Slmt Totals ----*/

fetch_slmt_totals()
{

    d_slmt_type_code.arr[0]  = '\0';
    d_slmt_type_desc.arr[0]  = '\0';


    d_slmt_type_code.len     = 0;
    d_slmt_type_desc.len     = 0;

    
	nd_doc_amt			     = 0;

    d_doc_amt_num = 0;

     /* EXEC SQL FETCH BL_SLMT_TOTALS
               INTO :d_slmt_type_code,
				    :d_slmt_type_desc,
	                :nd_doc_amt,
                    :d_doc_amt_num; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 32;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )665;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_slmt_type_desc;
     sqlstm.sqhstl[1] = (unsigned int  )103;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_doc_amt;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_doc_amt_num;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
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



    if(ERROR)
	err_mesg("FETCH failed on cursor BL_REC_REF_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_slmt_type_code.arr[d_slmt_type_code.len]   = '\0';
    d_slmt_type_desc.arr[d_slmt_type_desc.len]   = '\0';
  

   

   
    tot_doc_amt = tot_doc_amt + nd_doc_amt;


    return 1;
	
}


/*------------------------------------------------------*/

fetch_slmt_desc()
{

    /* EXEC SQL OPEN SLMT_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )696;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor SLMT_TYPE_CUR",0,"");

    d_slmt_type_desc.arr[0]  = '\0';
    d_slmt_type_desc.len  = 0;

    /* EXEC SQL FETCH SLMT_TYPE_CUR
	     INTO  :d_slmt_type_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )719;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_desc;
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



    if(ERROR)
	err_mesg("FETCH failed on cursor SLMT_TYPE_CUR",0,"");

    d_slmt_type_desc.arr[d_slmt_type_desc.len]  = '\0';

}

do_report()
{

    int cnt,first,brk;
    char s_amt[20];

    g_tot_debtor  = 0;
    g_tot_recpt   = 0;
    g_tot_date    = 0;
    g_tot_counter = 0;
    g_tot_void    = 0;

    g_grand_tot = 0;
    line_no = 1;
    put_hdr();

    g_hdr_cnt = 0;
    init_prv_values();

    while(fetch_bl_rec()) {

	if((brk = change())) {
	    if(g_hdr_cnt)
	        print_totals(brk,1);
            copy_val();
	    put_rec(brk);
	}
	else {
            copy_val();
	    put_rec(0);
	}

        g_tot_debtor  += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;
        g_tot_recpt   += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;
        g_tot_date    += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;
        g_tot_counter += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;
        g_tot_void    += d_cancelled_ind.arr[0]=='Y'?d_doc_amt_num:0;

        g_grand_tot   += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;

        g_hdr_cnt = 1;
    }

    if(g_hdr_cnt) {
	print_totals(4,0);
	print_grand_totals();
    }

    /*-------- Added on 14/03/1999 to Print Slmt Totals ------*/
	if(g_hdr_cnt) print_slmt_totals();
    /*--------------------------------------------------------*/

    print_end_of_rep();

}


put_hdr()
{
 
	if(rep_date.arr[0]!='\0')
	{
      init_date_temp_var();                            

	  strcpy(date_convert.arr,rep_date.arr);          
 	  fun_change_loc_date();
	}

     fprintf(f1,"%-6.6s : %s                                       %30s                                 %10s\n",loc_legend[43],loc_legend[15],comp_name.arr,date_convert.arr);
    fprintf(f1,"%-6.6s : %s\n",loc_legend[44],oper_id.arr);

    fprintf(f1,"%-6.6s : %s                               %s                          %6s : %4d\n",loc_legend[45],loc_legend[4],loc_legend[5],loc_legend[3],page_no);
   
    fprintf(f1,"--------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"  %-21s%-19s %-30s %-16s    %-21s      %-15s\n",loc_legend[16],loc_legend[17],loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[21]);
	//fprintf(f1,"      %-15s  %-10s                                     %-8s        %-11s        %-11s %-13s\n",loc_legend[16],loc_legend[17],loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[21]);
    fprintf(f1,"      %-41.41s %-12.12s %-30.30s %-30.30s     %-11s \n",loc_legend[22],loc_legend[23],loc_legend[24],loc_legend[25],loc_legend[26]);
	fprintf(f1,"      %-17s                        \n",loc_legend[29]);

    fprintf(f1,"--------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");

    line_no=9;

}
     
put_carry()
{
	    fetch_counter_desc();
	if(d_doc_date.arr[0] !='\0')
	{
		init_date_temp_var();
	    strcpy(date_convert.arr,d_doc_date.arr);            // pradeep
 	    fun_change_loc_date();
 	    fprintf(f1,"%15s     : %-2s %-30.30s     %7s              : %10s     %15s  : %-2s %-30s\n\n",loc_legend[9],
		    d_cash_counter_code.arr, d_counter_desc.arr,loc_legend[42],
		    date_convert.arr,loc_legend[46],d_recpt_refund_ind.arr,
		    d_recpt_refund_desc.arr);
}
	    fprintf(f1,"%20s  : %s %-60s\n",loc_legend[31],
		    d_prv_debtor_category_code.arr, d_prv_debtor_category_desc.arr);

	    line_no +=3;
}

/*---------- Added to Print Slmt Totals -----------*/

print_slmt_totals()
{
    char s_amt[20];
	tot_doc_amt = 0;

    chk_break(4);
	/*--------- Page Skip Added on 13/3/1999 ----------*/
	 fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
	/*-------------------------------------------------*/

    fprintf(f1,"\n\n%45s\n",loc_legend[32]);
    fprintf(f1,"----------------------------------------------\n\n");
    line_no += 5;

    /* EXEC SQL OPEN BL_SLMT_TOTALS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )738;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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
    sqlstm.sqhstv[2] = (         void  *)&p_language_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&cash_counter_fm;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&cash_counter_to;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&receipt_nature_fm;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&receipt_nature_to;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&receipt_type_fm;
    sqlstm.sqhstl[7] = (unsigned int  )6;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&receipt_type_to;
    sqlstm.sqhstl[8] = (unsigned int  )6;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&slmt_type_fm;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&slmt_type_to;
    sqlstm.sqhstl[10] = (unsigned int  )5;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&cancelled_docs;
    sqlstm.sqhstl[11] = (unsigned int  )4;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[12] = (unsigned int  )5;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&print_flag;
    sqlstm.sqhstl[13] = (unsigned int  )4;
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


    if(ERROR)
	err_mesg("OPEN failed on cursor BL_SLMT_TOTALS",0,"");
     
    while(fetch_slmt_totals()) {
       chk_break(1);
	   
       fprintf(f1,"%-2s %-16.16s    ", 
		  d_slmt_type_code.arr, d_slmt_type_desc.arr);
       print_formated(nd_doc_amt, f1);
	   fprintf(f1,"\n");	
       line_no ++;
	   line_no++;
    }

	 fprintf(f1,"%-18s"," ");
	   fprintf(f1,"-----------------------\n");
	   fprintf(f1,"%10s             ",loc_legend[33]);
	   print_formated(tot_doc_amt, f1);
	   fprintf(f1,"\n");
	   fprintf(f1,"%-18s"," ");
	   fprintf(f1,"-----------------------\n");
    /* EXEC SQL CLOSE BL_SLMT_TOTALS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )809;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(ERROR)
	err_mesg("CLOSE failed on cursor BL_SLMT_TOTALS",0,"");
}

/*-------------------------------------------------*/
put_rec(flg) 
int flg;
{

    if(flg) {

	if(flg > 1) {
	    fetch_counter_desc();
if(d_doc_date.arr[0] !='\0')
{
	init_date_temp_var();
    strcpy(date_convert.arr,d_doc_date.arr);            // pradeep
     fun_change_loc_date();
  		fprintf(f1,"%s     : %-2s %-30.30s     %s    : %10s     %s    : %-2s %-30s\n\n",loc_legend[9],
		    d_cash_counter_code.arr, d_counter_desc.arr,loc_legend[42],
		    date_convert.arr,loc_legend[14],d_recpt_refund_ind.arr,
		    d_recpt_refund_desc.arr);

}
           fprintf(f1,"%s  : %s %-60s\n",loc_legend[31],
		    d_debtor_category_code.arr, d_debtor_category_desc.arr);

	    line_no +=3;
	}
	else {
	    chk_break(3);
	    if(!g_page_break) {
	    fprintf(f1,"\n\n%s  : %s %-30s\n",loc_legend[31],
		    d_debtor_category_code.arr, d_debtor_category_desc.arr);
	        line_no +=3;
	    }
	}
    }

    chk_break(3);
    fetch_recpt_desc();
    fetch_slmt_desc();
if(d_trx_date_time.arr[0] !='\0')
{

	init_date_temp_var1();
	strcpy(date_convert1.arr,d_trx_date_time.arr);            // pradeep
 	fun_change_loc_date1(); 
 
    fprintf(f1,"\n  %-6s/%-7s/%-3s   %-2s %-14s  %-3s%-28.28s %1s %-16s %-6s/%-12s/%-2s ", 
	// %s %s\n",
	    d_doc_type_code.arr, d_doc_number.arr,d_doc_srno.arr, d_recpt_nature_code.arr,
	    d_recpt_nature_desc.arr, d_recpt_type_code.arr, 
	    d_recpt_desc.arr, d_shift_id.arr,date_convert1.arr, 
	    d_bill_doc_type_code.arr, d_bill_doc_number.arr,d_bill_doc_srno.arr);

}
        print_formated(d_doc_amt_num, f1);
		fprintf(f1," %s\n",d_cancelled_ind.arr);      
	//d_doc_amt.arr, d_cancelled_ind.arr);
	if(d_slmt_doc_ref_date.arr[0] !='\0')
{
 
		init_date_temp_var1();
		strcpy(date_convert1.arr,d_slmt_doc_ref_date.arr);
 		fun_change_loc_date1();	
 		

    fprintf(f1,"      %-2s %-16.16s %-22.22s %-10.10s %-29.29s %-26.26s%11s\n",
	    d_slmt_type_code.arr, d_slmt_type_desc.arr,
	    d_slmt_doc_ref_desc.arr,date_convert1.arr,
            d_slmt_doc_remarks.arr, d_narration.arr,
            d_ip_adm_trf_dep_ind.arr);

} 
 
/*--- Added to cater to requirement of User on 20/4/1999 -----*/
if(nd_cancel_reason.arr[0] != '\0')
{
	fprintf(f1,"       %-50s\n",nd_cancel_reason.arr);
}

/*------------------- End Of Addition ------------------------*/
/*
	       "      XXXXXX 99999999  XX XXXXXXXXXXXXXXX XXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X  XX/XX/XXXX XX:XX XXXXXX/999999999 999,999,999.99 X"
	       "       XX XXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXX XX/XX/XXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
*/
if(nd_cancel_reason.arr[0] != '\0')
{
    line_no += 4;
}
if(nd_cancel_reason.arr[0] == '\0')
{
    line_no += 3;
}

    if(d_patient_id.arr[0]) {
	fetch_patient_name();
	fprintf(f1,"          %11s      :  %-19.20s %-20.20s %-30.30s %1s %8s %4s\n",loc_legend[41],
		   d_patient_id.arr, d_patient_name_loc_lang.arr,
		   d_patient_name.arr, d_episode_type.arr,d_episode_id.arr,
		   d_visit_id.arr);
	if(strlen(d_patient_name1.arr) > 2)
{
 fprintf(f1,"%66s %s \n"," ",d_patient_name1.arr);
 line_no++;
}  
   
	line_no ++;
/*
	           "          Patient      :  XXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X 99999999 9999"
*/

    }

    if(d_customer_code.arr[0]) {
	fetch_cust_name();
	fprintf(f1,"          %11s     :  %-8s %-30.30s\n",loc_legend[34], d_customer_code.arr, d_cust_name.arr);
	line_no ++;

/*
	           "          Customer     :  XXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "
*/

    }

}

print_totals(brk,new_page)
int brk, new_page;
{

    char s_amt[20];

    chk_break(brk+1);

    fprintf(f1,"\n");

    if(brk >= 1) {
	put_val(s_amt,g_tot_debtor);
	format_amt(s_amt);
	fprintf(f1,"%87s %26s : %15s\n", "",loc_legend[37],s_amt);
	g_tot_debtor = 0;
    }

    if(brk >= 2) {
	put_val(s_amt,g_tot_recpt);
	format_amt(s_amt);
	fprintf(f1,"%87s %25s  : %15s\n", "",loc_legend[35],s_amt);
	g_tot_recpt = 0;

	put_val(s_amt,g_tot_void);
	format_amt(s_amt);
	fprintf(f1,"%87s %25s  : %15s\n", "",loc_legend[36],s_amt);
	g_tot_void  = 0;
    }

    if(brk >= 3) {
	put_val(s_amt,g_tot_date );
	format_amt(s_amt);
	fprintf(f1,"%87s %25s  : %15s\n", "",loc_legend[40],s_amt);
	g_tot_date  = 0;
    }

    if(brk == 4) {
	put_val(s_amt,g_tot_counter);
	format_amt(s_amt);
	fprintf(f1,"%87s %25s  : %15s\n", "",loc_legend[38],s_amt);
	g_tot_counter = 0;
    }

    line_no += brk+1;
    if(brk > 1 && new_page) {
           fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
    }

}

print_grand_totals()
{
    char s_amt[20];

    chk_break(2);

    put_val(s_amt,g_grand_tot);
    format_amt(s_amt);
    fprintf(f1,"\n%87s %25s  : %15s\n\n", "",loc_legend[39],s_amt);
    
    line_no += 3;

}

chk_break(nol)
int nol;
{

	g_page_break = 0;

	if(line_no+nol >= 40) //55 //modified by sai on 21-dec-2009 for 17258
	{
	   g_page_break = 1;
           fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
	   put_carry();
	}

}


put_inp_parm()
{   
    //disp_message(ERR_MESG,p_language_id.arr);
	init_date_temp_var();

	strcpy(date_convert.arr,rep_date.arr);            // pradeep
 
	fun_change_loc_date();                //pradeep
 
    fprintf(f1,"%c&l1O",ESC);   /* To Print Landscape           */
	fprintf(f1,"%c&a7L",ESC); 	/* To Set the Left margin  		*/
    fprintf(f1,"%c(s14H",ESC); 	/* To set the font size			*/
     fprintf(f1,"\n");
 
    fprintf(f1,"%-6.6s : %s                              %30s                                    %10s\n",loc_legend[43],loc_legend[15],comp_name.arr,date_convert.arr);
         
    fprintf(f1,"%-6.6s : %s\n",loc_legend[44],oper_id.arr);
    fprintf(f1,"%-6.6s : %s                            %40s                     %6s :%4d\n",loc_legend[45],loc_legend[4],loc_legend[5],loc_legend[3],page_no);
    init_date_temp_var();

	strcpy(date_convert.arr,report_date_fm.arr);
 	fun_change_loc_date();
     
	fprintf(f1,"                                          %16s ",date_convert.arr);
	
	init_date_temp_var();

	strcpy(date_convert.arr,report_date_to.arr);
 	fun_change_loc_date();
 
	fprintf(f1," - %12s\n",date_convert.arr);   
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n\n");
    //fprintf(f1,"VER : 4.1\n");
	fprintf(f1,"%s: 4.1\n",loc_legend[69]);

    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\t%17s\n",loc_legend[47]);
    fprintf(f1,"\t----------------\n\n");

    //fprintf(f1,"\t\tREPORT DATE           FROM : %s\n",report_date_fm.arr);
    //fprintf(f1,"\t\t                        TO : %s\n\n",report_date_to.arr);
		
	
	if(report_date_fm.arr[0]=='\0')
		fprintf(f1,"\t\t %20s        %10s : LOWEST\n",loc_legend[8],loc_legend[6]);
	
	else
		
		{
		init_date_temp_var();


		strcpy(date_convert.arr,report_date_fm.arr);
 		fun_change_loc_date();
 		fprintf(f1,"\t\t%20s           %10s : %s\n",loc_legend[8],loc_legend[6],date_convert.arr); //%4s 

	    }
	if(report_date_to.arr[0]=='\0')
		
		fprintf(f1,"\t\t				    %20s : %-10.10s\n\n",loc_legend[7],loc_legend[49]);
	
	else
		{
		init_date_temp_var();

		strcpy(date_convert.arr,report_date_to.arr);
 		fun_change_loc_date();
 		fprintf(f1,"\t\t		     %20s : %s\n\n",loc_legend[7],date_convert.arr);
		}

    if(cash_counter_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t %20s          %10s : %-10.10s \n",loc_legend[9],loc_legend[6],loc_legend[50]);
	else
		fprintf(f1,"\t\t %20s          %10s : %s\n",loc_legend[9],loc_legend[6],cash_counter_fm.arr);  
    if(cash_counter_to.arr[0] =='\0')
		fprintf(f1,"\t\t           	     %20s : %-10.10s \n\n",loc_legend[7],loc_legend[49]);
	else
		fprintf(f1,"\t\t 		     %20s : %s\n\n",loc_legend[7],cash_counter_to.arr); 
    if(receipt_nature_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t   %20s        %10s : %-10.10s \n",loc_legend[10],loc_legend[6],loc_legend[50]);
	else
		fprintf(f1,"\t\t   %20s        %10s : %s\n",loc_legend[10],loc_legend[6],receipt_nature_fm.arr);  
    if(receipt_nature_to.arr[0] =='\0')
		fprintf(f1,"\t\t           	     %20s : %-10.10s \n\n",loc_legend[7],loc_legend[49]);
	else
		fprintf(f1,"\t\t	             %20s : %s\n\n",loc_legend[7],receipt_nature_to.arr); 
	if(receipt_type_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t %20s          %10s : %-10.10s \n",loc_legend[11],loc_legend[6],loc_legend[50]);
	else
		fprintf(f1,"\t\t %20s          %10s : %s\n",loc_legend[11],loc_legend[6],receipt_type_fm.arr);  
    if(receipt_type_to.arr[0] =='\0')
		fprintf(f1,"\t\t           	     %20s : %-10.10s \n\n",loc_legend[7],loc_legend[49]);
	else
		fprintf(f1,"\t\t		     %20s : %s\n\n",loc_legend[7],receipt_type_to.arr); 
	
	 if(slmt_type_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t    %20s       %10s : %-10.10s \n",loc_legend[12],loc_legend[6],loc_legend[50]);
	else
		fprintf(f1,"\t\t    %20s       %10s : %s\n",loc_legend[12],loc_legend[6],slmt_type_fm.arr);  
    if(slmt_type_to.arr[0] =='\0')
		fprintf(f1,"\t\t           	     %20s : %-10.10s\n\n",loc_legend[7],loc_legend[49]);
	else
		fprintf(f1,"\t\t		       %18s : %s\n\n",loc_legend[7],slmt_type_to.arr); 
		fprintf(f1,"\t\t   %25s              : %s\n\n",loc_legend[13],cancelled_docs.arr);
		fprintf(f1,"\t\t     %25s            : %s\n\n",loc_legend[14],print_flag.arr);
    //fprintf(f1,"\t\t                             (1-Receipts, 2-Refunds,3-Both)\n");
	fprintf(f1,"\t\t                             (%-15.15s, %-15.15s,%-10.10s)\n",loc_legend[51],loc_legend[52],loc_legend[53]);
    fprintf(f1,"");
    ++page_no;

    //fprintf(f1,"\t\tCASH COUNTER          FROM : %s\n",cash_counter_fm.arr);
    //fprintf(f1,"\t\t                      TO : %s\n\n",cash_counter_to.arr);
	//fprintf(f1,"\t\tRECEIPT NATURE        FROM : %s\n",receipt_nature_fm.arr);
    //fprintf(f1,"\t\t                        TO : %s\n\n",receipt_nature_to.arr);
    //fprintf(f1,"\t\tRECEIPT TYPE          FROM : %s\n",receipt_type_fm.arr);
    //fprintf(f1,"\t\t                        TO : %s\n\n",receipt_type_to.arr);
    //fprintf(f1,"\t\tSETTLEMENT TYPE       FROM : %s\n",slmt_type_fm.arr);
    //fprintf(f1,"\t\t                        TO : %s\n\n",slmt_type_to.arr);
  
}





 

print_end_of_rep()
{
    //fprintf(f1,"\n\n                                                    ** %15s **                                                             \n",loc_legend[48]);saikiran
	   fprintf(f1,"\n\n                                                    **%-10s**                                                             \n",loc_legend[48]);// by saikiran for 17459 on 04/12/2010
}

init_prv_values()
{

    d_prv_cash_counter_code.arr[0]     = '\0';
    d_prv_doc_date.arr[0]              = '\0';
    d_prv_recpt_refund_ind.arr[0]      = '\0';
    d_prv_debtor_category_code.arr[0]  = '\0';

    d_prv_cash_counter_code.len     = 0;
    d_prv_doc_date.len              = 0;
    d_prv_recpt_refund_ind.len      = 0;
    d_prv_debtor_category_code.len  = 0;

}

change()
{

    if(strcmp(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr))
	return 4;

    if(strcmp(d_prv_doc_date.arr,             d_doc_date.arr))
	return 3;

    if(strcmp(d_prv_recpt_refund_ind.arr,     d_recpt_refund_ind.arr))
	return 2;

    if(strcmp(d_prv_debtor_category_code.arr, d_debtor_category_code.arr))
	return 1;
    
    return 0;

}

copy_val()
{

    strcpy(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr);
    strcpy(d_prv_doc_date.arr,             d_doc_date.arr);
    strcpy(d_prv_recpt_refund_ind.arr,     d_recpt_refund_ind.arr);
    strcpy(d_prv_debtor_category_code.arr, d_debtor_category_code.arr);
    strcpy(d_prv_debtor_category_desc.arr, d_debtor_category_desc.arr);

    d_prv_cash_counter_code.len     =   strlen(d_cash_counter_code.arr);
    d_prv_doc_date.len              =   strlen(d_doc_date.arr);
    d_prv_recpt_refund_ind.len      =   strlen(d_recpt_refund_ind.arr);
    d_prv_debtor_category_code.len  =   strlen(d_debtor_category_code.arr);

}


/*
print_formated(loc_amount)
double loc_amount;
{
 char s_amt[20];
 sprintf(s_amt,"%15.2f",loc_amount);
 format_amt(s_amt);
 fprintf(f1,"%10s \n",s_amt); 
}  
*/
 
print_formated(loc_amount,fp)
double loc_amount;
FILE *fp;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        //ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt,"-");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
                //ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s",str_amt);
        }
}
/*fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		EXEC SQL SELECT LTRIM(RTRIM('BLRCASPR.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual;

		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_translated_value.arr[0]		= '\0';

		EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:nd_facility_id,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:p_language_id);
		END;
		END-EXEC;

		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}
*/
fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';
		l_len_value.arr[0] = '\0';


		/* EXEC SQL SELECT LTRIM(RTRIM('BLRCASPR.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 32;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRCASPR.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )824;
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



		/* EXEC SQL SELECT length(column_value) INTO :l_len_value 
		           FROM sm_record_trans_data 
				   WHERE language_id =:p_language_id AND Pk_value = :l_pk_value; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 32;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select length(column_value) into :b0  from sm_record_trans_\
data where (language_id=:b1 and Pk_value=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )847;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_len_value;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&p_language_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_pk_value;
  sqlstm.sqhstl[2] = (unsigned int  )102;
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



		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_len_value.arr[l_len_value.len]= '\0';
		l_translated_value.arr[0]		= '\0';

		/* EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:nd_facility_id,
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 32;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )874;
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


		/* EXEC SQL SELECT substr(:l_translated_value,1,(:l_len_value+4))  
		          INTO :l_translated_value
		          FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 32;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(:b0,1,(:b1+4)) into :b0  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )905;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[0] = (unsigned int  )203;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_len_value;
  sqlstm.sqhstl[1] = (unsigned int  )5;
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


	
	
			
	
		//l_translated_value.arr[l_translated_value.len] = '\0';

	

		strcpy(loc_legend[i],l_translated_value.arr);
		
	

	}
}
get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	  
   //    	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/RRRR HH24:MI'),:p_language_id,t_date);  
      
	//   :nd_loc_date := to_char(t_date,'DD/MM/RRRR');
	
	 	  :nd_loc_date := sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/RRRR HH24:MI'),:p_language_id); 
			 :nd_loc_date := to_char(to_date(:nd_loc_date,'DD/MM/RRRR'),'DD/MM/RRRR');	   
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 32;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/RRRR HH24:MI' ) , :p_language_id ) ; :nd\
_loc_date := to_char ( to_date ( :nd_loc_date , 'DD/MM/RRRR' ) , 'DD/MM/RRRR' \
) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )932;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
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


        

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

}

 
 
                     
init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
date_convert.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
}


fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date1  date;
	
	BEGIN
	  
      // 	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MM/RRRR HH24:MI'),:p_language_id,t_date1);  
      
	   //:nd_loc_date1 := to_char(t_date1,'DD/MM/RRRR HH24:MI');
	
	   :nd_loc_date1 := sm_convert_datetime_2t(to_date(:nd_temp_date1,'DD/MM/RRRR HH24:MI'),:p_language_id);  



	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 32;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN :nd_loc_date1 := sm_convert_dat\
etime_2t ( to_date ( :nd_temp_date1 , 'DD/MM/RRRR HH24:MI' ) , :p_language_id \
) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )959;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date1;
 sqlstm.sqhstl[1] = (unsigned int  )23;
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


        

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

}

                     
init_date_temp_var1()
{
nd_temp_date1.arr[0] = '\0';
nd_loc_date1.arr[0]  = '\0';
date_convert1.arr[0] = '\0';

nd_temp_date1.len = 0;
nd_loc_date1.len  = 0;
date_convert1.len = 0;
}


fun_change_loc_date1()
{

strcpy(nd_temp_date1.arr,date_convert1.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);
nd_temp_date1.arr[nd_temp_date1.len]='\0';

get_local_date1();

strcpy(date_convert1.arr,nd_loc_date1.arr); 

}








