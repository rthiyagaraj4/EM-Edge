
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
           char  filnam[39];
};
static const struct sqlcxp sqlfpn =
{
    38,
    "T:\\BL\\CRF-0120\\AR\\WIP\\Proc\\Arrinprt.pc"
};


static unsigned long sqlctx = 1150831269;


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
            void  *sqhstv[27];
   unsigned int   sqhstl[27];
            int   sqhsts[27];
            void  *sqindv[27];
            int   sqinds[27];
   unsigned int   sqharm[27];
   unsigned int   *sqharc[27];
   unsigned short  sqadto[27];
   unsigned short  sqtdso[27];
} sqlstm = {10,27};

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

 static const char *sq0005 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,CUST_CODE ,PA\
TIENT_ID ,BILL_DOC_TYPE_CODE ,BILL_NUM ,CUST_REF ,NARRATION ,NVL(GROSS_AMT,0) \
,NVL(DISCOUNT_AMT,0) ,NVL(PAYABLE_AMT,0) ,MISC_CUST_LONG_NAME ,MISC_CUST_SHORT\
_NAME ,MISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,MISC_CUST_ADD3_DESC ,MISC_CUS\
T_ZIP_DESC ,MISC_CUST_LONG_NAME_CHINESE ,MISC_CUST_SHORT_NAME_CHINESE ,MISC_CU\
ST_ADD1_DESC_CHINESE ,MISC_CUST_ADD2_DESC_CHINESE ,MISC_CUST_ADD3_DESC_CHINESE\
 ,MISC_CUST_ZIP_DESC_CHINESE ,CONTACT_NAME ,CONTACT_NAME_TITLE ,ROWID  from AR\
_INV_HDR where (((((((DOC_TYPE_CODE>=NVL(:b0,'      ') and DOC_TYPE_CODE<=NVL(\
:b1,'~~~~~~')) and DOC_NUM>=NVL(:b2,0)) and DOC_NUM<=NVL(:b3,99999999)) and NV\
L(DOC_DATE,SYSDATE)>=NVL(TO_DATE(:b4,'DD/MM/YYYY'),to_date('00010101','YYYYDDM\
M'))) and NVL(DOC_DATE,SYSDATE)<=NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('471231\
12','YYYYDDMM'))) and NVL(POSTED_FLAG,'N')='N') and NVL(PRINT_FLAG,'N')='N') o\
rder by DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0008 = 
"select DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINESE,LONG_NAME) ,DECOD\
E(CHINESE_REPORTING_FLAG,'Y',SHORT_NAME_CHINESE,SHORT_NAME) ,DECODE(CHINESE_RE\
PORTING_FLAG,'Y',ADD1_DESC_CHINESE,ADD1_DESC) ,DECODE(CHINESE_REPORTING_FLAG,'\
Y',ADD2_DESC_CHINESE,ADD2_DESC) ,DECODE(CHINESE_REPORTING_FLAG,'Y',ADD3_DESC_C\
HINESE,ADD3_DESC) ,DECODE(CHINESE_REPORTING_FLAG,'Y',ZIP_DESC_CHINESE,ZIP_DESC\
) ,CONTACT_NAME ,CONTACT_NAME_TITLE ,MISC_CUSTOMER_FLAG ,CHINESE_REPORTING_FLA\
G  from AR_CUSTOMER where CUST_CODE=:b0           ";

 static const char *sq0006 = 
"select PATIENT_ID ,PATIENT_NAME ,BILL_DOC_TYPE_CODE ,BILL_NUM ,TO_CHAR(BILL_\
DATE,'DD/MM/YYYY') ,SUBSTR(REMARKS,1,10) ,LAB_TEST ,AMOUNT  from AR_PATIENT_DT\
LS where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) order by BILL_DATE,PATIENT_ID    \
        ";

 static const char *sq0007 = 
"select distinct BILL_DOC_TYPE_CODE ,BILL_NUM ,AMT_PAID  from AR_PATIENT_DTLS\
 where (((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and BILL_DOC_TYPE_CODE is  not nu\
ll ) and AMOUNT>0) order by BILL_DOC_TYPE_CODE,BILL_NUM            ";

 static const char *sq0009 = 
"select SHORT_NAME  from MP_PATIENT_MAST where PATIENT_ID=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,193,0,4,227,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,1,9,0,0,
56,0,0,2,91,0,2,328,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
79,0,0,3,0,0,30,340,0,0,0,0,0,1,0,
94,0,0,4,181,0,4,367,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,
0,0,1,9,0,0,
137,0,0,5,975,0,9,488,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
176,0,0,5,0,0,13,553,0,0,27,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,
299,0,0,8,516,0,9,617,0,0,1,1,0,1,0,1,9,0,0,
318,0,0,8,0,0,13,642,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,
373,0,0,6,240,0,9,702,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
396,0,0,7,221,0,9,711,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
419,0,0,6,0,0,13,738,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,4,0,0,
466,0,0,7,0,0,13,776,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,
493,0,0,9,71,0,9,799,0,0,1,1,0,1,0,1,9,0,0,
512,0,0,9,0,0,13,804,0,0,1,0,0,1,0,2,9,0,0,
531,0,0,10,85,0,4,1013,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
558,0,0,11,53,0,5,1070,0,0,1,1,0,1,0,1,9,0,0,
577,0,0,12,0,0,29,1076,0,0,0,0,0,1,0,
592,0,0,13,0,0,27,1192,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : ARRINPRT.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 22-MAR-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_INV_HDR               Query/Update              */
/*         2.        AR_PATINET_DTLS             Query                  */
/*         3.        SY_PROG_CONTROL           Update/Lookup            */
/*         4.        SY_PROG_MESG                Insert                 */
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


/*
#define OERROR (sqlca.sqlcode < 0)
*/

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define DEST_NAME "arrinprt.lis"

#define PAT_LINES 27

#define LEGEND 1

#define SKIP_1   7
#define SKIP_2  18
#define SKIP_2_1 10
#define SKIP_2_2 20
#define SKIP_2_3 68
#define SKIP_3  5
#define SKIP_4  9
#define SKIP_5  32
#define SKIP_6  5
#define SKIP_7  5
#define SKIP_8  12
#define SKIP_9  8
#define SKIP_10 50
#define SKIP_11 5
#define SKIP_12 65
#define SKIP_13 43
#define LENGTH_WORDS 50 
/*
#define DEBUG 1
*/
char string_var[100];

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
           date_time    [20],
		   cur_str      [8],
		   sub_cur_str  [8],
		   user_id      [20],
           nd_pgm_date  [35],
		   p_language_id [3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


   /* VARCHAR nd_facility_id   [3],
		   nd_session_id    [16],
           nd_fm_doc_type   [7],
           nd_to_doc_type   [7],
           nd_fm_doc_num    [10],
           nd_to_doc_num    [10],
           nd_fm_doc_date   [12],
           nd_to_doc_date   [12],

           d_ar_inv_doc_type_code      [7],
           d_ar_inv_doc_num            [10],
           d_ar_inv_doc_date           [12],
           d_ar_inv_cust_code          [9],
           d_ar_inv_patient_id         [21],
           d_ar_inv_bill_doc_type_code [7],
           d_ar_inv_bill_num           [10],
           d_ar_inv_cust_ref           [16],
           d_ar_inv_narration          [51],
           d_ar_inv_rowid              [31],

           d_ar_cust_long_name         [101],  -- CRF-0120
           d_ar_cust_short_name        [61],  -- CRF-0120
           d_ar_cust_add1_desc         [61],
           d_ar_cust_add2_desc         [61],
           d_ar_cust_add3_desc         [61],
           d_ar_cust_zip_desc          [31],
           d_ar_cust_contact_name      [101],  -- CRF-0120
           d_ar_cust_contact_title[61],  -- CRF-0120

			d_ar_pat_patient_id         [21],
			d_ar_pat_patient_name       [61],
			d_ar_pat_bill_doc_type_code [7],
			d_ar_pat_bill_num           [10],
			d_ar_pat_bill_date          [12],
			d_ar_pat_remarks            [16],
			d_ar_pat_lab_test           [16],

			d_ar_mp_patient_name        [61],
			d_ar_mp_patient_title       [9],

	   d_misc_cust_long_name       [101],  -- CRF-0120
	   d_misc_cust_short_name      [101],  -- CRF-0120
	   d_misc_cust_add1_desc       [61],
	   d_misc_cust_add2_desc       [61],
	   d_misc_cust_add3_desc       [61],
	   d_misc_cust_zip_desc        [31],

	   d_misc_cust_long_name_chi   [101],  -- CRF-0120
	   d_misc_cust_short_name_chi  [101],  -- CRF-0120
	   d_misc_cust_add1_desc_chi   [61],
	   d_misc_cust_add2_desc_chi   [61],
	   d_misc_cust_add3_desc_chi   [61],
	   d_misc_cust_zip_desc_chi    [61],
       d_misc_cust_contact_name    [101],  -- CRF-0120
       d_misc_cust_contact_title   [61]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[7]; } d_ar_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_ar_inv_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_inv_doc_date;

struct { unsigned short len; unsigned char arr[9]; } d_ar_inv_cust_code;

struct { unsigned short len; unsigned char arr[21]; } d_ar_inv_patient_id;

struct { unsigned short len; unsigned char arr[7]; } d_ar_inv_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_ar_inv_bill_num;

struct { unsigned short len; unsigned char arr[16]; } d_ar_inv_cust_ref;

struct { unsigned short len; unsigned char arr[51]; } d_ar_inv_narration;

struct { unsigned short len; unsigned char arr[31]; } d_ar_inv_rowid;

struct { unsigned short len; unsigned char arr[101]; } d_ar_cust_long_name;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_add1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_add2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_add3_desc;

struct { unsigned short len; unsigned char arr[31]; } d_ar_cust_zip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_ar_cust_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_contact_title;

struct { unsigned short len; unsigned char arr[21]; } d_ar_pat_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_ar_pat_patient_name;

struct { unsigned short len; unsigned char arr[7]; } d_ar_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_ar_pat_bill_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_pat_bill_date;

struct { unsigned short len; unsigned char arr[16]; } d_ar_pat_remarks;

struct { unsigned short len; unsigned char arr[16]; } d_ar_pat_lab_test;

struct { unsigned short len; unsigned char arr[61]; } d_ar_mp_patient_name;

struct { unsigned short len; unsigned char arr[9]; } d_ar_mp_patient_title;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_long_name;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add3_desc;

struct { unsigned short len; unsigned char arr[31]; } d_misc_cust_zip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_long_name_chi;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_short_name_chi;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add1_desc_chi;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add2_desc_chi;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add3_desc_chi;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_zip_desc_chi;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_contact_title;
   /*   CRF-0120   */

char   d_misc_customer_flag,
	   d_chinese_reporting_flag;

int	   nd_no_of_decimal;

double d_ar_inv_payable_amt,
       d_ar_inv_gross_amt,
	   d_ar_inv_discount_amt,
       d_ar_pat_amount,
	   d_ar_pat_amt_paid;

char   temp_amount[50];

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

FILE *fp;
int lctr = 0,pctr =0;
int inv_lctr = 0,inv_pctr = 0,lab_flag = 0,pat_lctr = 0;
int first ;

double tot_amount;

int i = 0;
char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{
 strcpy(filename,WORKING_DIR);
 strcat(filename,DEST_NAME);
  

   if (argc != 5)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
      disp_message(ERR_MESG,"Exiting...\n\007\007\007\007\007\007\007\007");
      proc_exit();
   }


   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"ARRINPRT");

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ORA_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   }

#ifdef DEBUG
  disp_message(INFO_MESG,"After connecting to oracle...\n");
#endif
   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   set_meduser_role();

strcpy(p_language_id.arr,l_language_id.arr);
p_language_id.len = l_language_id.len;
  
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;

   /* EXEC SQL SELECT operating_facility_id,
				   PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6
              INTO nd_facility_id,
				   :nd_fm_doc_type, :nd_fm_doc_num, :nd_fm_doc_date,
                   :nd_to_doc_type, :nd_to_doc_num, :nd_to_doc_date 
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRINPRT'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where \
((PGM_ID='ARRINPRT' and SESSION_ID=:b7) and PGM_DATE=:b8)";
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
   sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[8] = (unsigned int  )37;
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

   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';

#ifdef DEBUG
   sprintf(string_var,"fr type is <%d> - <%s>\n",nd_fm_doc_type.len ,nd_fm_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to type is <%d> - <%s>\n",nd_to_doc_type.len ,nd_to_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fr num  is <%d> - <%s>\n",nd_fm_doc_num.len ,nd_fm_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to num  is <%d> - <%s>\n",nd_to_doc_num.len ,nd_to_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fr dt   is <%d> - <%s>\n",nd_fm_doc_date.len ,nd_fm_doc_date.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to dt   is <%d> - <%s>\n",nd_to_doc_date.len ,nd_to_doc_date.arr);
   disp_message(INFO_MESG,string_var);
#endif


   fetch_detls();

   open_files();
   
   declare_cursors();

   while(fetch_inv_hdr())
   {   
        inv_lctr = inv_pctr = lab_flag = pat_lctr = 0;
        tot_amount = 0;
        fetch_cust_det();
        open_patient_dtls();
  
        while(fetch_patient_dtls())
        {   disp_message(INFO_MESG,"Inside fetch_patient_dtls=true");
            lab_flag = 1;
            print_details();
            tot_amount += d_ar_pat_amount;
        }

	if(lab_flag) {

            if (d_ar_inv_discount_amt) {
                chk_break(2);
		print_subtot(tot_amount);
		fprintf(fp,"\n");
		pat_lctr += 3;
                for (i=0;i<SKIP_7;i++) fprintf(fp," ");
                chk_break(1);
                fprintf(fp,"%-50s","Less: Discount");
                for (i=0;i<SKIP_8;i++) fprintf(fp," ");
                print_formated(d_ar_inv_discount_amt);
                fprintf(fp,"\n");
		pat_lctr += 1;
                tot_amount -= d_ar_inv_discount_amt;
            }

	    open_pmnt_dtls();
	    first = 1;
	    while(fetch_pmnt_dtls()) {
		if(first && (!d_ar_inv_discount_amt)) {
		    chk_break(2);
		    print_subtot(tot_amount);
		    fprintf(fp,"\n");
		    pat_lctr += 3;
	            print_oth_details(1);
		    first = 0;
		}
		else
	            print_oth_details(0);
                tot_amount -= d_ar_pat_amt_paid;
	    }
	}

        if (!lab_flag)
            print_invoice();
        else if (inv_pctr != 0)
        {
            print_footer();
        }
   }

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
                  WHERE PGM_ID     = 'ARRINPRT'
                    AND SESSION_ID = :nd_session_id
                    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRINPRT' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )56;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqhstl[1] = (unsigned int  )37;
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


/*
   end_prog_msg();
   end_prog_control();
*/
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )79;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   fclose(fp);
   return;
}

chk_break(cnt)
int cnt;
{
    if (pat_lctr+cnt > PAT_LINES || pat_lctr == 0)
        print_pat_head();
}

fetch_detls()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   cur_str.arr[0]        = '\0';
   sub_cur_str.arr[0]    = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   cur_str.len		  = 0;
   sub_cur_str.len    = 0;
   user_id.len        = 0;

   
   /* EXEC SQL SELECT ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY'), BASE_CURRENCY,
                   USER,BASE_CURRENCY_DEC,NO_OF_DECIMAL
              INTO :hosp_name, :date_time, :cur_str, :user_id,:sub_cur_str,:nd_no_of_decimal
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,BAS\
E_CURRENCY ,USER ,BASE_CURRENCY_DEC ,NO_OF_DECIMAL into :b0,:b1,:b2,:b3,:b4,:b\
5  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )94;
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
   sqlstm.sqhstv[1] = (         void  *)&date_time;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&cur_str;
   sqlstm.sqhstl[2] = (unsigned int  )10;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&user_id;
   sqlstm.sqhstl[3] = (unsigned int  )22;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&sub_cur_str;
   sqlstm.sqhstl[4] = (unsigned int  )10;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
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
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   cur_str.arr[cur_str.len]				  = '\0';
   sub_cur_str.arr[sub_cur_str.len]       = '\0';
   user_id.arr[user_id.len]               = '\0';

}

open_files()
{
   if ((fp = fopen(filename,"w")) == NULL)
   {
        err_mesg("\nError while opening File arrrmltr.lis\n",0,"");
        proc_exit();
   }

#ifdef DEBUG
   disp_message(INFO_MESG,"After opening file\n");
#endif
}

declare_cursors()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside declare cursors\n");
#endif

   /* EXEC SQL DECLARE AR_INV_HDR_CUR CURSOR FOR
             SELECT DOC_TYPE_CODE,
                    DOC_NUM,
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    CUST_CODE,
                    PATIENT_ID,
                    BILL_DOC_TYPE_CODE,
                    BILL_NUM,
                    CUST_REF,
                    NARRATION,
		    NVL(GROSS_AMT,0),
		    NVL(DISCOUNT_AMT,0),
                    NVL(PAYABLE_AMT,0),
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
		    CONTACT_NAME,
		    CONTACT_NAME_TITLE,
                    ROWID
               FROM AR_INV_HDR
              WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
                AND NVL(POSTED_FLAG,'N') = 'N'
                AND NVL(PRINT_FLAG,'N')  = 'N'
              ORDER BY DOC_TYPE_CODE,DOC_NUM; */ 


   /* EXEC SQL DECLARE AR_PATIENT_DTLS_CUR CURSOR FOR
             SELECT PATIENT_ID,
		    PATIENT_NAME,
                    BILL_DOC_TYPE_CODE,
                    BILL_NUM,
                    TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
                    SUBSTR(REMARKS,1,10),
		    LAB_TEST,
                    AMOUNT 
               FROM AR_PATIENT_DTLS
              WHERE DOC_TYPE_CODE = :d_ar_inv_doc_type_code
                AND DOC_NUM       = :d_ar_inv_doc_num
              ORDER BY BILL_DATE,PATIENT_ID; */ 


   /* EXEC SQL DECLARE AR_PATIENT_PMNT_CUR CURSOR FOR
             SELECT DISTINCT BILL_DOC_TYPE_CODE,
                             BILL_NUM,
                             AMT_PAID 
               FROM AR_PATIENT_DTLS
              WHERE DOC_TYPE_CODE = :d_ar_inv_doc_type_code
                AND DOC_NUM       = :d_ar_inv_doc_num
		AND BILL_DOC_TYPE_CODE IS NOT NULL
		AND AMOUNT      > 0
              ORDER BY BILL_DOC_TYPE_CODE,BILL_NUM; */ 


    /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
        SELECT DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINESE,LONG_NAME),
               DECODE(CHINESE_REPORTING_FLAG,'Y',SHORT_NAME_CHINESE,SHORT_NAME),
               DECODE(CHINESE_REPORTING_FLAG,'Y',ADD1_DESC_CHINESE,ADD1_DESC),
               DECODE(CHINESE_REPORTING_FLAG,'Y',ADD2_DESC_CHINESE,ADD2_DESC),
               DECODE(CHINESE_REPORTING_FLAG,'Y',ADD3_DESC_CHINESE,ADD3_DESC),
               DECODE(CHINESE_REPORTING_FLAG,'Y',ZIP_DESC_CHINESE,ZIP_DESC),
               CONTACT_NAME,
               CONTACT_NAME_TITLE,
	       MISC_CUSTOMER_FLAG,
	       CHINESE_REPORTING_FLAG
          FROM AR_CUSTOMER
         WHERE CUST_CODE = :d_ar_inv_cust_code; */ 


    /* EXEC SQL DECLARE AR_PATIENT_CUR CURSOR FOR
              SELECT SHORT_NAME
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :d_ar_pat_patient_id; */ 


    /* EXEC SQL OPEN AR_INV_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )137;
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
         err_mesg("OPEN failed on cursor AR_INV_HDR_CUR",0,"");

}

fetch_inv_hdr()
{

d_ar_inv_doc_type_code.arr[0]      = '\0';
d_ar_inv_doc_num.arr[0]            = '\0';
d_ar_inv_doc_date.arr[0]           = '\0';
d_ar_inv_cust_code.arr[0]          = '\0';
d_ar_inv_patient_id.arr[0]         = '\0';
d_ar_inv_bill_doc_type_code.arr[0] = '\0';
d_ar_inv_bill_num.arr[0]           = '\0';
d_ar_inv_cust_ref.arr[0]           = '\0';
d_ar_inv_narration.arr[0]          = '\0';
d_ar_inv_rowid.arr[0]              = '\0';
d_misc_cust_long_name.arr[0]       = '\0';
d_misc_cust_short_name.arr[0]      = '\0';
d_misc_cust_add1_desc.arr[0]       = '\0';
d_misc_cust_add2_desc.arr[0]       = '\0';
d_misc_cust_add3_desc.arr[0]       = '\0';
d_misc_cust_zip_desc.arr[0]        = '\0';
d_misc_cust_long_name_chi.arr[0]   = '\0';
d_misc_cust_short_name_chi.arr[0]  = '\0';
d_misc_cust_add1_desc_chi.arr[0]   = '\0';
d_misc_cust_add2_desc_chi.arr[0]   = '\0';
d_misc_cust_add3_desc_chi.arr[0]   = '\0';
d_misc_cust_zip_desc_chi.arr[0]    = '\0';
d_misc_cust_contact_name.arr[0]    = '\0';
d_misc_cust_contact_title.arr[0]  = '\0';


d_ar_inv_doc_type_code.len         = 0;
d_ar_inv_doc_num.len               = 0;
d_ar_inv_doc_date.len              = 0;
d_ar_inv_cust_code.len             = 0;
d_ar_inv_patient_id.len            = 0;
d_ar_inv_bill_doc_type_code.len    = 0;
d_ar_inv_bill_num.len              = 0;
d_ar_inv_cust_ref.len              = 0;
d_ar_inv_narration.len             = 0;
d_ar_inv_rowid.len                 = 0;
d_misc_cust_long_name.len          = 0;
d_misc_cust_short_name.len         = 0;
d_misc_cust_add1_desc.len          = 0;
d_misc_cust_add2_desc.len          = 0;
d_misc_cust_add3_desc.len          = 0;
d_misc_cust_zip_desc.len           = 0;
d_misc_cust_long_name_chi.len      = 0;
d_misc_cust_short_name_chi.len     = 0;
d_misc_cust_add1_desc_chi.len      = 0;
d_misc_cust_add2_desc_chi.len      = 0;
d_misc_cust_add3_desc_chi.len      = 0;
d_misc_cust_zip_desc_chi.len       = 0;
d_misc_cust_contact_name.len       = 0;
d_misc_cust_contact_title.len  = 0;

d_ar_inv_payable_amt               = 0;
d_ar_inv_gross_amt                 = 0;
d_ar_inv_discount_amt              = 0;

    /* EXEC SQL FETCH AR_INV_HDR_CUR
              INTO :d_ar_inv_doc_type_code,
                   :d_ar_inv_doc_num,
                   :d_ar_inv_doc_date,
                   :d_ar_inv_cust_code,
                   :d_ar_inv_patient_id,
                   :d_ar_inv_bill_doc_type_code,
                   :d_ar_inv_bill_num,
                   :d_ar_inv_cust_ref,
                   :d_ar_inv_narration,
                   :d_ar_inv_gross_amt,
                   :d_ar_inv_discount_amt,
                   :d_ar_inv_payable_amt,
		   :d_misc_cust_long_name,
		   :d_misc_cust_short_name,
		   :d_misc_cust_add1_desc,
		   :d_misc_cust_add2_desc,
		   :d_misc_cust_add3_desc,
		   :d_misc_cust_zip_desc,
		   :d_misc_cust_long_name_chi,
		   :d_misc_cust_short_name_chi,
		   :d_misc_cust_add1_desc_chi,
		   :d_misc_cust_add2_desc_chi,
		   :d_misc_cust_add3_desc_chi,
		   :d_misc_cust_zip_desc_chi,
                   :d_misc_cust_contact_name,
                   :d_misc_cust_contact_title,
                   :d_ar_inv_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )176;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )12;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_inv_doc_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_inv_cust_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ar_inv_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ar_inv_bill_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ar_inv_bill_num;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_ar_inv_cust_ref;
    sqlstm.sqhstl[7] = (unsigned int  )18;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_ar_inv_narration;
    sqlstm.sqhstl[8] = (unsigned int  )53;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_ar_inv_gross_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_ar_inv_discount_amt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_ar_inv_payable_amt;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_misc_cust_long_name;
    sqlstm.sqhstl[12] = (unsigned int  )103;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_misc_cust_short_name;
    sqlstm.sqhstl[13] = (unsigned int  )103;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_misc_cust_add1_desc;
    sqlstm.sqhstl[14] = (unsigned int  )63;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_misc_cust_add2_desc;
    sqlstm.sqhstl[15] = (unsigned int  )63;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_misc_cust_add3_desc;
    sqlstm.sqhstl[16] = (unsigned int  )63;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_misc_cust_zip_desc;
    sqlstm.sqhstl[17] = (unsigned int  )33;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_misc_cust_long_name_chi;
    sqlstm.sqhstl[18] = (unsigned int  )103;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_misc_cust_short_name_chi;
    sqlstm.sqhstl[19] = (unsigned int  )103;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&d_misc_cust_add1_desc_chi;
    sqlstm.sqhstl[20] = (unsigned int  )63;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_misc_cust_add2_desc_chi;
    sqlstm.sqhstl[21] = (unsigned int  )63;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&d_misc_cust_add3_desc_chi;
    sqlstm.sqhstl[22] = (unsigned int  )63;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_misc_cust_zip_desc_chi;
    sqlstm.sqhstl[23] = (unsigned int  )63;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_misc_cust_contact_name;
    sqlstm.sqhstl[24] = (unsigned int  )103;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&d_misc_cust_contact_title;
    sqlstm.sqhstl[25] = (unsigned int  )63;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_ar_inv_rowid;
    sqlstm.sqhstl[26] = (unsigned int  )33;
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
         err_mesg("FETCH failed on cursor AR_INV_HDR_CUR",0,"");

d_ar_inv_doc_type_code.arr[d_ar_inv_doc_type_code.len] = '\0';
d_ar_inv_doc_num.arr[d_ar_inv_doc_num.len] = '\0';
d_ar_inv_doc_date.arr[d_ar_inv_doc_date.len] = '\0';
d_ar_inv_cust_code.arr[d_ar_inv_cust_code.len] = '\0';
d_ar_inv_patient_id.arr[d_ar_inv_patient_id.len] = '\0';
d_ar_inv_bill_doc_type_code.arr[d_ar_inv_bill_doc_type_code.len] = '\0';
d_ar_inv_bill_num.arr[d_ar_inv_bill_num.len] = '\0';
d_ar_inv_cust_ref.arr[d_ar_inv_cust_ref.len] = '\0';
d_ar_inv_narration.arr[d_ar_inv_narration.len] = '\0';
d_misc_cust_long_name.arr[d_misc_cust_long_name.len] = '\0';
d_misc_cust_short_name.arr[d_misc_cust_short_name.len] = '\0';
d_misc_cust_add1_desc.arr[d_misc_cust_add1_desc.len] = '\0';
d_misc_cust_add2_desc.arr[d_misc_cust_add2_desc.len] = '\0';
d_misc_cust_add3_desc.arr[d_misc_cust_add3_desc.len] = '\0';
d_misc_cust_zip_desc.arr[d_misc_cust_zip_desc.len] = '\0';
d_misc_cust_long_name_chi.arr[d_misc_cust_long_name_chi.len] = '\0';
d_misc_cust_short_name_chi.arr[d_misc_cust_short_name_chi.len] = '\0';
d_misc_cust_add1_desc_chi.arr[d_misc_cust_add1_desc_chi.len] = '\0';
d_misc_cust_add2_desc_chi.arr[d_misc_cust_add2_desc_chi.len] = '\0';
d_misc_cust_add3_desc_chi.arr[d_misc_cust_add3_desc_chi.len] = '\0';
d_misc_cust_zip_desc_chi.arr[d_misc_cust_zip_desc_chi.len] = '\0';
d_misc_cust_contact_name.arr[d_misc_cust_contact_name.len]  = '\0';
d_misc_cust_contact_title.arr[d_misc_cust_contact_title.len]  = '\0';

   if (LAST_ROW)
       return (0);
   else
       return (1);

}

fetch_cust_det()
{
    /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )299;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_cust_code;
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
    d_ar_cust_short_name.arr[0]         = '\0';
    d_ar_cust_add1_desc.arr[0]          = '\0';
    d_ar_cust_add2_desc.arr[0]          = '\0';
    d_ar_cust_add3_desc.arr[0]          = '\0';
    d_ar_cust_zip_desc.arr[0]           = '\0';
    d_ar_cust_contact_name.arr[0]       = '\0';
    d_ar_cust_contact_title.arr[0] = '\0';
    d_misc_customer_flag                = '\0';
    d_chinese_reporting_flag            = '\0';

    d_ar_cust_long_name.len             = 0;
    d_ar_cust_short_name.len            = 0;
    d_ar_cust_add1_desc.len             = 0;
    d_ar_cust_add2_desc.len             = 0;
    d_ar_cust_add3_desc.len             = 0;
    d_ar_cust_zip_desc.len              = 0;
    d_ar_cust_contact_name.len          = 0;
    d_ar_cust_contact_title.len    = 0;

    /* EXEC SQL FETCH AR_CUSTOMER_CUR
              INTO :d_ar_cust_long_name,
                   :d_ar_cust_short_name,
                   :d_ar_cust_add1_desc,
                   :d_ar_cust_add2_desc,
                   :d_ar_cust_add3_desc,
                   :d_ar_cust_zip_desc,
                   :d_ar_cust_contact_name,
                   :d_ar_cust_contact_title,
		   :d_misc_customer_flag,
		   :d_chinese_reporting_flag; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )318;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_cust_long_name;
    sqlstm.sqhstl[0] = (unsigned int  )103;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_cust_short_name;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_cust_add1_desc;
    sqlstm.sqhstl[2] = (unsigned int  )63;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_cust_add2_desc;
    sqlstm.sqhstl[3] = (unsigned int  )63;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ar_cust_add3_desc;
    sqlstm.sqhstl[4] = (unsigned int  )63;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ar_cust_zip_desc;
    sqlstm.sqhstl[5] = (unsigned int  )33;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ar_cust_contact_name;
    sqlstm.sqhstl[6] = (unsigned int  )103;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_ar_cust_contact_title;
    sqlstm.sqhstl[7] = (unsigned int  )63;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_misc_customer_flag;
    sqlstm.sqhstl[8] = (unsigned int  )1;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_chinese_reporting_flag;
    sqlstm.sqhstl[9] = (unsigned int  )1;
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
         err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

d_ar_cust_long_name.arr[d_ar_cust_long_name.len] = '\0';
d_ar_cust_short_name.arr[d_ar_cust_short_name.len] = '\0';
d_ar_cust_add1_desc.arr[d_ar_cust_add1_desc.len] = '\0';
d_ar_cust_add2_desc.arr[d_ar_cust_add2_desc.len] = '\0';
d_ar_cust_add3_desc.arr[d_ar_cust_add3_desc.len] = '\0';
d_ar_cust_zip_desc.arr[d_ar_cust_zip_desc.len] = '\0';
d_ar_cust_contact_name.arr[d_ar_cust_contact_name.len] = '\0';
d_ar_cust_contact_title.arr[d_ar_cust_contact_title.len] = '\0';

if(d_misc_customer_flag == 'Y') {
    if(d_chinese_reporting_flag == 'Y') {
	strcpy(d_ar_cust_long_name.arr,d_misc_cust_long_name_chi.arr);
	strcpy(d_ar_cust_short_name.arr,d_misc_cust_short_name_chi.arr);
	strcpy(d_ar_cust_add1_desc.arr,d_misc_cust_add1_desc_chi.arr);
	strcpy(d_ar_cust_add2_desc.arr,d_misc_cust_add2_desc_chi.arr);
	strcpy(d_ar_cust_add3_desc.arr,d_misc_cust_add3_desc_chi.arr);
	strcpy(d_ar_cust_zip_desc.arr,d_misc_cust_zip_desc_chi.arr);
    }
    else {
	strcpy(d_ar_cust_long_name.arr,d_misc_cust_long_name.arr);
	strcpy(d_ar_cust_short_name.arr,d_misc_cust_short_name.arr);
	strcpy(d_ar_cust_add1_desc.arr,d_misc_cust_add1_desc.arr);
	strcpy(d_ar_cust_add2_desc.arr,d_misc_cust_add2_desc.arr);
	strcpy(d_ar_cust_add3_desc.arr,d_misc_cust_add3_desc.arr);
	strcpy(d_ar_cust_zip_desc.arr,d_misc_cust_zip_desc.arr);
    }

    strcpy(d_ar_cust_contact_name.arr,d_misc_cust_contact_name.arr);
    strcpy(d_ar_cust_contact_title.arr,d_misc_cust_contact_title.arr);

    d_ar_cust_long_name.len = strlen(d_ar_cust_long_name.arr);
    d_ar_cust_short_name.len = strlen(d_ar_cust_short_name.arr);
    d_ar_cust_add1_desc.len = strlen(d_ar_cust_add1_desc.arr);
    d_ar_cust_add2_desc.len = strlen(d_ar_cust_add2_desc.arr);
    d_ar_cust_add3_desc.len = strlen(d_ar_cust_add3_desc.arr);
    d_ar_cust_zip_desc.len = strlen(d_ar_cust_zip_desc.arr);
    d_ar_cust_contact_name.len = strlen(d_ar_cust_contact_name.arr);
    d_ar_cust_contact_title.len = strlen(d_ar_cust_contact_title.arr);
}

}


open_patient_dtls()
{
   /* EXEC SQL OPEN AR_PATIENT_DTLS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )373;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )12;
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
         err_mesg("OPEN failed on cursor AR_PATIENT_DTLS_CUR",0,"");

}

open_pmnt_dtls()
{
   /* EXEC SQL OPEN AR_PATIENT_PMNT_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )396;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )12;
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
         err_mesg("OPEN failed on cursor AR_PATIENT_PMNT_CUR",0,"");

}

fetch_patient_dtls()
{
d_ar_pat_patient_id.arr[0]         = '\0';
d_ar_pat_bill_doc_type_code.arr[0] = '\0';
d_ar_pat_bill_num.arr[0]           = '\0';
d_ar_pat_bill_date.arr[0]          = '\0';
d_ar_pat_remarks.arr[0]            = '\0';
d_ar_pat_lab_test.arr[0]           = '\0';
d_ar_pat_patient_name.arr[0]       = '\0';

d_ar_pat_patient_id.len            = 0;
d_ar_pat_bill_doc_type_code.len    = 0;
d_ar_pat_bill_num.len              = 0;
d_ar_pat_bill_date.len             = 0;
d_ar_pat_remarks.len               = 0;
d_ar_pat_lab_test.len              = 0;
d_ar_pat_patient_name.len          = 0;

d_ar_pat_amount                    = 0;

   /* EXEC SQL FETCH AR_PATIENT_DTLS_CUR
             INTO :d_ar_pat_patient_id,
                  :d_ar_pat_patient_name,
                  :d_ar_pat_bill_doc_type_code,
                  :d_ar_pat_bill_num,
                  :d_ar_pat_bill_date,
                  :d_ar_pat_remarks,
                  :d_ar_pat_lab_test,
                  :d_ar_pat_amount; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )419;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_pat_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_pat_patient_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_pat_bill_num;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ar_pat_bill_date;
   sqlstm.sqhstl[4] = (unsigned int  )14;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_ar_pat_remarks;
   sqlstm.sqhstl[5] = (unsigned int  )18;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_ar_pat_lab_test;
   sqlstm.sqhstl[6] = (unsigned int  )18;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_ar_pat_amount;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor AR_PATIENT_DTLS_CUR",0,"");

d_ar_pat_patient_id.arr[d_ar_pat_patient_id.len] = '\0';
d_ar_pat_patient_name.arr[d_ar_pat_patient_name.len] = '\0';
d_ar_pat_bill_doc_type_code.arr[d_ar_pat_bill_doc_type_code.len] = '\0';
d_ar_pat_bill_num.arr[d_ar_pat_bill_num.len] = '\0';
d_ar_pat_bill_date.arr[d_ar_pat_bill_date.len] = '\0';
d_ar_pat_remarks.arr[d_ar_pat_remarks.len] = '\0';
d_ar_pat_lab_test.arr[d_ar_pat_lab_test.len] = '\0';

  if (LAST_ROW)
      return (0);
  else
      return (1);
}

fetch_pmnt_dtls()
{

d_ar_pat_bill_doc_type_code.arr[0] = '\0';
d_ar_pat_bill_num.arr[0]           = '\0';

d_ar_pat_bill_doc_type_code.len    = 0;
d_ar_pat_bill_num.len              = 0;

d_ar_pat_amt_paid                  = 0;

   /* EXEC SQL FETCH AR_PATIENT_PMNT_CUR
             INTO :d_ar_pat_bill_doc_type_code,
                  :d_ar_pat_bill_num,
                  :d_ar_pat_amt_paid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )466;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_pat_bill_num;
   sqlstm.sqhstl[1] = (unsigned int  )12;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_pat_amt_paid;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor AR_PATIENT_PMNT_CUR",0,"");

d_ar_pat_bill_doc_type_code.arr[d_ar_pat_bill_doc_type_code.len] = '\0';
d_ar_pat_bill_num.arr[d_ar_pat_bill_num.len] = '\0';

  if (LAST_ROW)
      return (0);
  else
      return (1);
}

fetch_patient_name()
{

d_ar_mp_patient_name.arr[0] = '\0';
d_ar_mp_patient_name.len    = 0;

     /* EXEC SQL OPEN AR_PATIENT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 27;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0009;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )493;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_ar_pat_patient_id;
     sqlstm.sqhstl[0] = (unsigned int  )23;
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
         err_mesg("OPEN failed on cursor AR_PATIENT_CUR",0,"");

     /* EXEC SQL FETCH AR_PATIENT_CUR
               INTO :d_ar_mp_patient_name; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 27;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )512;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_ar_mp_patient_name;
     sqlstm.sqhstl[0] = (unsigned int  )63;
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
         err_mesg("FETCH failed on cursor AR_PATIENT_CUR",0,"");    
     d_ar_mp_patient_name.arr[d_ar_mp_patient_name.len] = '\0';

#ifdef DEBUG
  sprintf(string_var,"Patient is <%s>\n",d_ar_mp_patient_name.arr);
  disp_message(INFO_MESG,string_var);
#endif
}

print_page_head()
{

int i=0;
static int g_first = 1;

#ifdef DEBUG
    disp_message(INFO_MESG,"Inside print_page_head\n");
#endif

   inv_lctr = 0;
   inv_pctr++;

   if (inv_pctr > 1)
      print_balance1();

   if(!g_first)
       fprintf(fp,"\f");

   g_first=0;

   for (i=0;i<SKIP_1;i++) fprintf(fp,"\n");
   for (i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-40s",d_ar_inv_cust_code.arr);
   for (i=0;i<SKIP_2_1;i++) fprintf(fp," ");
   fprintf(fp,"%-6s %s %-8s\n",d_ar_inv_doc_type_code.arr,
       (d_ar_inv_doc_type_code.len != 0 && d_ar_inv_doc_num.len != 0)?"/":"",
                 d_ar_inv_doc_num.arr);

   for (i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-40s\n",d_ar_cust_long_name.arr);

   for (i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-30s",d_ar_cust_add1_desc.arr);
   for (i=0;i<SKIP_2_2;i++) fprintf(fp," ");
   fprintf(fp,"%10s\n",d_ar_inv_doc_date.arr);

   for (i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-30s\n",d_ar_cust_add2_desc.arr);

   for (i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-30s",d_ar_cust_add3_desc.arr);
   for (i=0;i<SKIP_2_2;i++) fprintf(fp," ");
   if (!lab_flag)
       fprintf(fp,"%s\n",d_ar_inv_patient_id.arr);
   else
       fprintf(fp,"\n");

   for (i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-30s\n",d_ar_cust_zip_desc.arr);

   for (i=0;i<SKIP_2_3;i++) fprintf(fp," ");
   if (!lab_flag)
       fprintf(fp,"%-6s %s %-8s\n",d_ar_inv_bill_doc_type_code.arr,
                 (d_ar_inv_bill_doc_type_code.len != 0 &&
                  d_ar_inv_bill_num.len != 0)?"/":"",
               d_ar_inv_bill_num.arr);
   else
       fprintf(fp,"\n");

   for (i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-40s\n",d_ar_cust_contact_name.arr);

   for (i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-40s",d_ar_cust_contact_title.arr);

   for (i=0;i<SKIP_2_1;i++) fprintf(fp," ");
   fprintf(fp,"%s\n",d_ar_inv_cust_ref.arr);

   for (i=0;i<SKIP_3;i++) fprintf(fp,"\n");
/*
   if (inv_pctr > 1)
        print_balance2();
*/
#ifdef DEBUG
    disp_message(INFO_MESG,"completed print_page_head\n");
    fflush(fp);
#endif
}

print_details()
{

#ifdef DEBUG
    disp_message(INFO_MESG,"Inside print_details\n");
#endif

  if (pat_lctr > PAT_LINES || pat_lctr == 0)
      print_pat_head();

   for (i=0;i<SKIP_6;i++) fprintf(fp," ");
   /* old format
   fprintf(fp,"%-10s %-6s %8s %-10s %-15s",
                  d_ar_pat_bill_date.arr,
                  d_ar_pat_bill_doc_type_code.arr,
                  d_ar_pat_bill_num.arr,
                  d_ar_pat_patient_id.arr,
                  d_ar_pat_remarks.arr);
    */
   fprintf(fp,"%-10s %-6s %8s %-10s %-15s",
                  d_ar_pat_bill_date.arr,
                  d_ar_pat_bill_doc_type_code.arr,
                  d_ar_pat_bill_num.arr,
                  d_ar_pat_remarks.arr,
                  d_ar_pat_lab_test.arr);

   for (i=0;i<SKIP_4;i++) fprintf(fp," ");
   print_formated(d_ar_pat_amount);
   fprintf(fp,"\n");
   for (i=0;i<SKIP_5;i++) fprintf(fp," ");
   /* old format
   fprintf(fp,"%s\n",d_ar_mp_patient_name.arr);
   */
   fprintf(fp,"%s\n",d_ar_pat_patient_name.arr);
   pat_lctr += 2;

#ifdef DEBUG
    disp_message(INFO_MESG,"Completed print_details\n");
#endif
}

print_oth_details(flg)
int flg;
{

#ifdef DEBUG
    disp_message(INFO_MESG,"Inside print_oth_details\n");
#endif

  chk_break(1);

   for (i=0;i<SKIP_6;i++) fprintf(fp," ");

   fprintf(fp,"%-5s Payment Received for %-6s/%-8s           ",
		  flg ? "Less:":"",
                  d_ar_pat_bill_doc_type_code.arr,
                  d_ar_pat_bill_num.arr);

   for (i=0;i<SKIP_4;i++) fprintf(fp," ");
   print_formated(d_ar_pat_amt_paid);
   fprintf(fp,"\n");
   pat_lctr ++;

#ifdef DEBUG
    disp_message(INFO_MESG,"Completed print_oth_details\n");
#endif
}

print_pat_head()
{
   print_page_head();

   for (i=0;i<SKIP_6;i++) fprintf(fp," ");

   fprintf(fp,"LAB DATE   CHARGE SLIP/NO  REFERENCE  LAB TEST");
/*
   for (i=0;i<SKIP_4;i++) fprintf(fp," ");
   fprintf(fp,"                 AMOUNT");
*/
   fprintf(fp,"\n");
   for (i=0;i<SKIP_6;i++) fprintf(fp," ");
   fprintf(fp,"---------- --------------- ---------- ---------------");
/*
   for (i=0;i<SKIP_4;i++) fprintf(fp," ");
   fprintf(fp,"----------------");
*/
   fprintf(fp,"\n");

   pat_lctr = 0;

   if (inv_pctr > 1)
        print_balance2();

}

print_invoice()
{

  char   p_name[40];

#ifdef DEBUG
    disp_message(INFO_MESG,"Inside print_invoice\n");
#endif
   print_page_head();
   for (i=0;i<SKIP_3;i++) fprintf(fp,"\n");
   for (i=0;i<SKIP_7;i++) fprintf(fp," ");
/*************************************************************************/
/* MODIFIED TO FETCH AND PRINT THE PATIENT NAME                          */
/*************************************************************************/

    d_ar_mp_patient_title.arr[0]  = '\0';
    d_ar_mp_patient_name.arr[0]   = '\0';

   sprintf(string_var,"fr type is <%S> \n",d_ar_inv_patient_id.arr);
   disp_message(INFO_MESG,string_var);

    /* EXEC SQL SELECT TITLE_CODE,
		    SHORT_NAME
	       INTO :d_ar_mp_patient_title,
		    :d_ar_mp_patient_name
	       FROM MP_PATIENT_MAST
	      WHERE PATIENT_ID = :d_ar_inv_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TITLE_CODE ,SHORT_NAME into :b0,:b1  from MP_PATIE\
NT_MAST where PATIENT_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )531;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_mp_patient_title;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_mp_patient_name;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_inv_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
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



    if(OERROR)
	err_mesg("SELECT failed on MP_PATIENT_MAST",0,"");

    d_ar_mp_patient_title.arr[d_ar_mp_patient_title.len]  = '\0';
    d_ar_mp_patient_name.arr[d_ar_mp_patient_name.len]    = '\0';

    sprintf(p_name,"%s %s",
	   d_ar_mp_patient_title.arr,d_ar_mp_patient_name.arr);

    ltrim(p_name);

    if(sqlca.sqlerrd[2]) {
	fprintf(fp,"%s\n",p_name);

    ltrim(p_name);
        for (i=0;i<SKIP_7;i++) fprintf(fp," ");
    }

/*************************************************************************/

   fprintf(fp,"%-50s",d_ar_inv_narration.arr);
   for (i=0;i<SKIP_8;i++) fprintf(fp," ");
   print_formated(d_ar_inv_gross_amt);
#ifdef DEBUG
    disp_message(INFO_MESG,"after discountiprint_formatted\n");
#endif
   for (i=0;i<SKIP_9;i++) fprintf(fp,"\n");

   if (d_ar_inv_discount_amt) {
       for (i=0;i<SKIP_7;i++) fprintf(fp," ");
       fprintf(fp,"%-50s","Less: Discount");
       for (i=0;i<SKIP_8;i++) fprintf(fp," ");
       print_formated(d_ar_inv_discount_amt);
   }
   fprintf(fp,"\n");
   
   print_total(d_ar_inv_payable_amt);
   
#ifdef DEBUG
    disp_message(INFO_MESG,"after print_total\n");
#endif
   update_invoice();
#ifdef DEBUG
    disp_message(INFO_MESG,"Completed print_page_head\n");
#endif
}

update_invoice()
{

    /* EXEC SQL UPDATE AR_INV_HDR
                SET PRINT_FLAG = 'Y'
              WHERE ROWID = :d_ar_inv_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_INV_HDR  set PRINT_FLAG='Y' where ROWID=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )558;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_rowid;
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
         err_mesg("UPDATE failed on table AR_INV_HDR",0,"");

    /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )577;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT failed",0,""); 
}

print_subtot(l_amount)
double l_amount;
{

    for (i=0;i<SKIP_12;i++) fprintf(fp," ");
    for (i=0;i<18;i++) fprintf(fp,"-");
    fprintf(fp,"\n");
    for (i=0;i<SKIP_11;i++) fprintf(fp," ");
    fprintf(fp,"                                             SUB TOTAL : ");
    print_formated_tot(l_amount);
    fprintf(fp,"\n");
}

print_total(l_amount)
double l_amount; 
{
   char out_str[10][133];
   int no_of_lines;
   

   fprintf(fp,"\n");
   for (i=0;i<SKIP_12;i++) fprintf(fp," ");
   for (i=0;i<18;i++) fprintf(fp,"-");
   fprintf(fp,"\n");
   for (i=0;i<SKIP_11;i++) fprintf(fp," ");
   fprintf(fp,"DETAILS AS PER ATTACHED BILL                     TOTAL : ");
   print_formated_tot(l_amount);
   fprintf(fp,"\n");
   for (i=0;i<SKIP_12;i++) fprintf(fp," ");
   for (i=0;i<18;i++) fprintf(fp,"-");
   fprintf(fp,"\n");
   pat_lctr += 4;
   for (i=0;i<SKIP_11;i++) fprintf(fp," ");   
   
   no_of_lines = print_in_words(l_amount,LENGTH_WORDS,sub_cur_str.arr,out_str,nd_no_of_decimal);
#ifdef DEBUG
    disp_message(INFO_MESG,"after calling  print in words\n");
    sprintf(string_var,"no_of_lines = <%d>\n",no_of_lines);
    disp_message(INFO_MESG,string_var);
#endif
   fprintf(fp,"\n\n");
   pat_lctr += 2;

   if(l_amount)
      fprintf(fp, "%-6s", cur_str.arr);
   for (i =0;i<no_of_lines;i++)
      fprintf(fp,"     %s\n", out_str[i]);

    pat_lctr += no_of_lines;
#ifdef DEBUG
    disp_message(INFO_MESG,"after print total \n");
#endif
}

print_footer()
{

    chk_break(8);

    print_total(tot_amount);

    for(i=0; i < 35-pat_lctr; i++)
        fprintf(fp,"\n");

    fprintf(fp,"PAGE : %d\n", ++ pctr);
    update_invoice();
}

print_balance1()
{
 int i = 0;

    fprintf(fp,"\n");
    for (i=0;i<SKIP_13;i++) fprintf(fp," ");
    fprintf(fp,"C/F BALANCE  :     ");
    print_formated_tot(tot_amount);
    fprintf(fp,"\n");

    pat_lctr += 2;

    for(i=0; i < 34-pat_lctr; i++)
        fprintf(fp,"\n");

    fprintf(fp,"PAGE : %d\n", ++pctr);
}
    
print_balance2()
{
 int i = 0;
    pat_lctr ++;
    inv_lctr ++;
    for (i=0;i<SKIP_13;i++) fprintf(fp," ");
    fprintf(fp,"B/F BALANCE  :     ");
    print_formated_tot(tot_amount);
    fprintf(fp,"\n");
    pat_lctr += 1;
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

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )592;
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

l_put_comma(str)

char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10];
  strcpy(arr,str);
  strncpy(l_str1,arr + (strlen(arr) - 2),2);
  l_str1[2] = '\0';
  arr[strlen(str)-3] = '\0';
  i = strlen(arr);
  j = i;
  k = j/3;
  l = k;
  m = i - (l*3);
  if (i > 3)
  {
      for (a=0;a<m;a++)
         o_arr[a] = arr[a];
   if (m)
   {
     o_arr[m] = ','; b=m+1;
   }
   else b = m;
  for (c=1,a=m;arr[a]!= '\0';a++,b++)
  {
     o_arr[b] = arr[a]; 
     c++;
     if (c > 3 && arr[a+1] != '\0')
     {
       o_arr[++b] = ','; c = 1;
     }
   }
   o_arr[b] = '\0';
  }
  else
      strcpy(o_arr,arr);
   sprintf(str,"%s.%s",o_arr,l_str1);
}

rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
}

print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (nd_no_of_decimal == 3)
     sprintf(out_str,"%10.3f",loc_amount);
   else
     sprintf(out_str,"%10.2f",loc_amount);

    format_amt(out_str,nd_no_of_decimal);

 if (loc_amount == 0)
      fprintf(fp,"%16s"," ");
   else if (loc_amount > 0)
   {
      fprintf(fp,"%16s",out_str);
   }
   else
   {
      fprintf(fp,"%15s-",out_str);
   }

/*
   if (loc_amount == 0)
      fprintf(fp,"%-14s"," ");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%10.2f",loc_amount);
      ltrim(out_str);	  
	  l_put_comma(out_str);	  
      sprintf(out_str1,"%15s",out_str);
      fprintf(fp,"%-15s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%10.2f",-loc_amount);
      ltrim(out_str);	  
	  l_put_comma(out_str);	  
      sprintf(out_str1,"%15s",out_str);
      fprintf(fp,"%-15s-",out_str1);
   }
*/
} 

print_formated_tot(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (nd_no_of_decimal==3)
      sprintf(out_str,"%13.3f",loc_amount);
   else
      sprintf(out_str,"%13.2f",loc_amount);

      format_amt(out_str,nd_no_of_decimal);

   if (loc_amount == 0)
      fprintf(fp,"%21s"," ");
   else if (loc_amount > 0)
   {
      fprintf(fp,"%21s",out_str);
   }
   else
   {
      fprintf(fp,"%20s-",out_str);
   }

/*
   if (loc_amount == 0)
      fprintf(fp,"%-14s"," ");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%13.2f",loc_amount);
      ltrim(out_str);
	  
	  l_put_comma(out_str);
	  
      sprintf(out_str1,"%20s",out_str);
      fprintf(fp,"%-20s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%13.2f",-loc_amount);
      ltrim(out_str);
	  
	  l_put_comma(out_str);
	  
      sprintf(out_str1,"%20s",out_str);
      fprintf(fp,"%-20s-",out_str1);
   }
*/
}
