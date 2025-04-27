
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
    "T:\\BL\\CRF-0120\\AR\\WIP\\Proc\\Arbpgdoc.pc"
};


static unsigned long sqlctx = 1150835485;


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
            void  *sqhstv[35];
   unsigned int   sqhstl[35];
            int   sqhsts[35];
            void  *sqindv[35];
            int   sqinds[35];
   unsigned int   sqharm[35];
   unsigned int   *sqharc[35];
   unsigned short  sqadto[35];
   unsigned short  sqtdso[35];
} sqlstm = {10,35};

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

 static const char *sq0012 = 
"select LONG_DESC  from AR_PMNT_TERMS where PMNT_TERMS_CODE=:b0           ";

 static const char *sq0013 = 
"select CONCAT_POST_ACC_DESC  from GL_POSTING_ACC where ((((((MAIN_ACC1_CODE=\
:b0 and MAIN_ACC2_CODE=:b1) and DEPT_CODE=:b2) and PRODUCT_GROUP_CODE=:b3) and\
 PRODUCT_LINE_CODE=:b4) and SUBLEDGER_GROUP_CODE=:b5) and SUBLEDGER_LINE_CODE=\
:b6)           ";

 static const char *sq0014 = 
"select SHORT_DESC  from BL_BLNG_GRP where BLNG_GRP_ID=:b0           ";

 static const char *sq0015 = 
"select SHORT_NAME  from MP_PATIENT_MAST where PATIENT_ID=:b0           ";

 static const char *sq0010 = 
"select CUST_CODE ,NVL(PATIENT_FLAG,' ') ,NVL(MISC_CUSTOMER_FLAG,' ') ,NVL(LO\
NG_NAME,' ')  from AR_CUSTOMER where (CUST_CODE between :b0 and :b1 and CUST_G\
ROUP_CODE between :b2 and :b3) order by CUST_CODE            ";

 static const char *sq0011 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,TO_CHAR(BASE_\
DATE,'DD/MM/YYYY') ,PMNT_TERMS_CODE ,GROSS_AMT ,DISCOUNT_AMT ,PAYABLE_AMT ,TO_\
CHAR(DUE_DATE,'DD/MM/YYYY') ,TO_CHAR(SETTLEMENT_DATE,'DD/MM/YYYY') ,TO_CHAR(SE\
TTLEMENT_PERC,'990.00') ,CUST_REF ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,\
PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CO\
DE ,NARRATION ,BILLING_GROUP ,DOCTOR_FEE_AMT ,PATIENT_ID ,BILL_DOC_TYPE_CODE ,\
BILL_NUM ,TO_CHAR(BILL_DATE,'DD/MM/YYYY') ,MISC_CUST_LONG_NAME ,MISC_CUST_SHOR\
T_NAME ,MISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,MISC_CUST_ADD3_DESC ,MISC_CU\
ST_ZIP_DESC ,POST_MONTH ,POST_YEAR ,ROWID  from AR_PENDING_DOC where ((CUST_CO\
DE=:b0 and NVL(PENDING_AMT,0)=0) and MONTHS_BETWEEN(SYSDATE,LAST_UPD_DATE)>=:b\
1) order by DOC_TYPE_CODE,DOC_NUM            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,181,0,4,196,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,
52,0,0,2,0,0,29,250,0,0,0,0,0,1,0,
67,0,0,3,0,0,30,255,0,0,0,0,0,1,0,
82,0,0,4,50,0,1,261,0,0,0,0,0,1,0,
97,0,0,5,47,0,1,269,0,0,0,0,0,1,0,
112,0,0,6,47,0,1,277,0,0,0,0,0,1,0,
127,0,0,7,51,0,1,285,0,0,0,0,0,1,0,
142,0,0,8,91,0,2,296,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
165,0,0,9,0,0,29,305,0,0,0,0,0,1,0,
180,0,0,12,73,0,9,412,0,0,1,1,0,1,0,1,9,0,0,
199,0,0,12,0,0,13,420,0,0,1,0,0,1,0,2,9,0,0,
218,0,0,13,247,0,9,431,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
261,0,0,13,0,0,13,436,0,0,1,0,0,1,0,2,9,0,0,
280,0,0,14,68,0,9,445,0,0,1,1,0,1,0,1,9,0,0,
299,0,0,14,0,0,13,453,0,0,1,0,0,1,0,2,9,0,0,
318,0,0,15,71,0,9,462,0,0,1,1,0,1,0,1,9,0,0,
337,0,0,15,0,0,13,467,0,0,1,0,0,1,0,2,9,0,0,
356,0,0,16,0,0,27,478,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
387,0,0,17,57,0,4,573,0,0,1,0,0,1,0,2,3,0,0,
406,0,0,18,147,0,4,592,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
441,0,0,19,62,0,6,598,0,0,1,1,0,1,0,2,9,0,0,
460,0,0,20,43,0,4,604,0,0,2,1,0,1,0,1,9,0,0,2,1,0,0,
483,0,0,10,215,0,9,619,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
514,0,0,10,0,0,13,638,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
545,0,0,11,823,0,9,658,0,0,2,2,0,1,0,1,9,0,0,1,3,0,0,
568,0,0,11,0,0,13,732,0,0,35,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,
0,0,
723,0,0,21,44,0,2,888,0,0,1,1,0,1,0,1,9,0,0,
742,0,0,22,95,0,2,898,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
769,0,0,23,71,0,2,910,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : ARBPGDOC.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 27-FEB-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION               :                                            */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_CUSTOMER                 Update                 */
/*         2.        AR_PENDING_DOC           Query/Delete              */
/*         3.        AR_CUST_TRN              Query/Delete              */
/*         3.        SY_PROG_CONTROL          Update/Lookup             */
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
#include <math.h>
#include <string.h>
//#include "winexecc.h"
#include "gl.h"
/*
#define OERROR (sqlca.sqlcode < 0)
*/
#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

#define RESOURCE_BUSY        (sqlca.sqlcode == -54)

/*
#define DEBUG 0
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;


   /* VARCHAR  nd_facility_id         [3],
			nd_session_id          [16],
            nd_pgm_date            [25],
            hosp_name              [120],
            date_time              [20],
            user_id                [20]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;


   /* VARCHAR  nd_fm_cust_code        [9],
            nd_to_cust_code        [9],
            nd_fm_group_code       [3],
            nd_to_group_code       [3],
            nd_purge_zero          [2],
            nd_print_flg           [2]; */ 
struct { unsigned short len; unsigned char arr[9]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_group_code;

struct { unsigned short len; unsigned char arr[3]; } nd_to_group_code;

struct { unsigned short len; unsigned char arr[2]; } nd_purge_zero;

struct { unsigned short len; unsigned char arr[2]; } nd_print_flg;
 

       int  month_paid_inv = 0;

   /* VARCHAR  ar_customer_cust_code           [9],
            ar_customer_patient_flag        [2],
            ar_customer_misc_cflag			[2],
            ar_customer_cust_long_name      [61],
            ar_pend_doc_type_code           [7],
            ar_pend_doc_num                 [9],
            ar_pend_rowid                   [31],
            cust_trn_doc_type_code          [7],
            cust_trn_doc_num                [9],
            cust_trn_org_doc_type_code      [7],
            cust_trn_org_doc_num            [9],
            ar_pend_doc_date                [12],
            ar_pend_base_date               [12],
            ar_pend_pmnt_terms_code         [3],
            ar_pend_due_date                [12],
            ar_pend_settlement_date         [12],
            ar_pend_settlement_perc         [8],
            ar_pend_cust_ref                [16],
            ar_pend_main_acc1_code          [7],
            ar_pend_main_acc2_code          [5],
            ar_pend_dept_code               [11],
            ar_pend_product_group_code      [4],
            ar_pend_product_line_code       [5],
            ar_pend_sub_group_code			[4],
            ar_pend_sub_line_code			[9],
            ar_pend_narration               [51],
            ar_pend_billing_group           [5],  -- CRF-0120
            ar_pend_patient_id              [21],
            ar_pend_bill_doc_type_code      [7],
            ar_pend_bill_num                [9],
            ar_pend_bill_date               [12],
            ar_pend_misc_clong_name			[101],  -- CRF-0120
            ar_pend_misc_cshort_name		[61],
            ar_pend_misc_cadd1_desc			[61],
            ar_pend_misc_cadd2_desc			[61],
            ar_pend_misc_cadd3_desc			[61],
            ar_pend_misc_czip_desc			[31],
            cust_trn_rowid                  [31],
            pmnt_terms_desc                 [31],
            gl_posting_desc                 [64],
            patient_desc                    [31],
            billing_group_desc              [41],  -- CRF-0120
			p_operational_modules           [201]; */ 
struct { unsigned short len; unsigned char arr[9]; } ar_customer_cust_code;

struct { unsigned short len; unsigned char arr[2]; } ar_customer_patient_flag;

struct { unsigned short len; unsigned char arr[2]; } ar_customer_misc_cflag;

struct { unsigned short len; unsigned char arr[61]; } ar_customer_cust_long_name;

struct { unsigned short len; unsigned char arr[7]; } ar_pend_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pend_doc_num;

struct { unsigned short len; unsigned char arr[31]; } ar_pend_rowid;

struct { unsigned short len; unsigned char arr[7]; } cust_trn_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } cust_trn_doc_num;

struct { unsigned short len; unsigned char arr[7]; } cust_trn_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } cust_trn_org_doc_num;

struct { unsigned short len; unsigned char arr[12]; } ar_pend_doc_date;

struct { unsigned short len; unsigned char arr[12]; } ar_pend_base_date;

struct { unsigned short len; unsigned char arr[3]; } ar_pend_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[12]; } ar_pend_due_date;

struct { unsigned short len; unsigned char arr[12]; } ar_pend_settlement_date;

struct { unsigned short len; unsigned char arr[8]; } ar_pend_settlement_perc;

struct { unsigned short len; unsigned char arr[16]; } ar_pend_cust_ref;

struct { unsigned short len; unsigned char arr[7]; } ar_pend_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } ar_pend_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } ar_pend_dept_code;

struct { unsigned short len; unsigned char arr[4]; } ar_pend_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } ar_pend_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } ar_pend_sub_group_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pend_sub_line_code;

struct { unsigned short len; unsigned char arr[51]; } ar_pend_narration;

struct { unsigned short len; unsigned char arr[5]; } ar_pend_billing_group;

struct { unsigned short len; unsigned char arr[21]; } ar_pend_patient_id;

struct { unsigned short len; unsigned char arr[7]; } ar_pend_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pend_bill_num;

struct { unsigned short len; unsigned char arr[12]; } ar_pend_bill_date;

struct { unsigned short len; unsigned char arr[101]; } ar_pend_misc_clong_name;

struct { unsigned short len; unsigned char arr[61]; } ar_pend_misc_cshort_name;

struct { unsigned short len; unsigned char arr[61]; } ar_pend_misc_cadd1_desc;

struct { unsigned short len; unsigned char arr[61]; } ar_pend_misc_cadd2_desc;

struct { unsigned short len; unsigned char arr[61]; } ar_pend_misc_cadd3_desc;

struct { unsigned short len; unsigned char arr[31]; } ar_pend_misc_czip_desc;

struct { unsigned short len; unsigned char arr[31]; } cust_trn_rowid;

struct { unsigned short len; unsigned char arr[31]; } pmnt_terms_desc;

struct { unsigned short len; unsigned char arr[64]; } gl_posting_desc;

struct { unsigned short len; unsigned char arr[31]; } patient_desc;

struct { unsigned short len; unsigned char arr[41]; } billing_group_desc;

struct { unsigned short len; unsigned char arr[201]; } p_operational_modules;


char        df_instal_flag;

double      ar_pend_gross_amt,
            ar_pend_discount_amt,
            ar_pend_payable_amt,
            ar_pend_doctor_fee_amt;

int         ar_pend_post_month,
            ar_pend_post_year;

int			nd_no_of_decimal;

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

int delete_cnt = 0;

FILE *fp;
int lctr = 0,pctr =0;
char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{
   char mesg1[50];
  
   strcpy(filename,WORKING_DIR);
   strcat(filename,"arbpgdoc.lis");

   if (argc != 5)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(g_pgm_id,"ARBPGDOC");
 
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle\n");
      sprintf(mesg1,"Error is %s\n",sqlca.sqlerrm.sqlerrmc);
      disp_message(ERR_MESG,mesg1);
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   set_meduser_role();               
   
   chk_active();

   start_prog_control();
   start_prog_msg();

   nd_fm_cust_code.arr[0]      = '\0';
   nd_to_cust_code.arr[0]      = '\0';
   nd_fm_group_code.arr[0]     = '\0';
   nd_to_group_code.arr[0]     = '\0';
   nd_print_flg.arr[0]         = '\0';

   nd_fm_cust_code.len         = 0;
   nd_to_cust_code.len         = 0;
   nd_fm_group_code.len        = 0;
   nd_to_group_code.len        = 0;
   nd_print_flg.len            = 0;

   /* EXEC SQL SELECT operating_facility_id,
				   PARAM1,  PARAM2,
                   PARAM3,  PARAM4,
                   PARAM5
              INTO :nd_facility_id,
				   :nd_fm_cust_code,    :nd_to_cust_code,
                   :nd_fm_group_code,   :nd_to_group_code,
                   :nd_print_flg 
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBPGDOC'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 into :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID='AR\
BPGDOC' and SESSION_ID=:b6) and PGM_DATE=:b7)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_group_code;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_group_code;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_print_flg;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[6] = (unsigned int  )18;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[7] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

    nd_fm_cust_code.arr[nd_fm_cust_code.len]        = '\0';
    nd_to_cust_code.arr[nd_to_cust_code.len]        = '\0';
    nd_fm_group_code.arr[nd_fm_group_code.len]      = '\0';
    nd_to_group_code.arr[nd_to_group_code.len]      = '\0';
    nd_print_flg.arr[nd_print_flg.len]              = '\0';

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");
 
   fetch_desc();
   fetch_ar_param();

   delete_prog_param();

   if (nd_print_flg.arr[0] == 'Y')
          lock_tables();

   open_files();
   declare_cursors();
   open_customer();
   while (fetch_customer())
   {
       open_pending_doc();
       while (fetch_pending_doc())
       {
           fetch_descriptions();
           print_details();
           if (nd_print_flg.arr[0] == 'N')
           {
              delete_pending_doc();
              delete_cust_trn();
              delete_patient_dtls();
           }
       }
   }
               
   print_end();

   /* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )52;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
         err_mesg("COMMIT failed",0,"");
   end_prog_msg();
   end_prog_control();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )67;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

lock_tables()
{
   /* EXEC SQL LOCK TABLE AR_PENDING_DOC
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_PENDING_DOC IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )82;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2200");
   else if (OERROR)
           err_mesg("LOCK failed on table AR_PENDING_DOC",0,"");
 
   /* EXEC SQL LOCK TABLE AR_CUST_TRN
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CUST_TRN IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )97;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2210");
   else if (OERROR)
           err_mesg("LOCK failed on table AR_CUST_TRN",0,"");

   /* EXEC SQL LOCK TABLE AR_CUSTOMER
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CUSTOMER IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )112;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2190");
   else if (OERROR)
           err_mesg("LOCK failed on table AR_CUST_TRN",0,"");

   /* EXEC SQL LOCK TABLE AR_PATIENT_DTLS
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_PATIENT_DTLS IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )127;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2220");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_PATIENT_DTLS",0,"");
}

delete_prog_param()
{
   /* EXEC SQL DELETE
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBPGDOC'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARBPGDOC' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )142;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   /* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )165;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
         err_mesg("COMMIT failed",0,""); 
}

declare_cursors()
{
   
     /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
               SELECT CUST_CODE,
                      NVL(PATIENT_FLAG,' '),
                      NVL(MISC_CUSTOMER_FLAG,' '),
                      NVL(LONG_NAME,' ')
                 FROM AR_CUSTOMER
                WHERE CUST_CODE 
              BETWEEN :nd_fm_cust_code 
                  AND :nd_to_cust_code
                  AND CUST_GROUP_CODE
              BETWEEN :nd_fm_group_code
                  AND :nd_to_group_code
                ORDER BY CUST_CODE; */ 


     /* EXEC SQL DECLARE AR_PENDING_DOC_CUR CURSOR FOR
               SELECT DOC_TYPE_CODE,
                      DOC_NUM,
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                      TO_CHAR(BASE_DATE,'DD/MM/YYYY'),
                      PMNT_TERMS_CODE,
                      GROSS_AMT,
                      DISCOUNT_AMT,
                      PAYABLE_AMT,
                      TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                      TO_CHAR(SETTLEMENT_DATE,'DD/MM/YYYY'),
                      TO_CHAR(SETTLEMENT_PERC,'990.00'),
                      CUST_REF,
                      MAIN_ACC1_CODE,
                      MAIN_ACC2_CODE,
                      DEPT_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
                      NARRATION,
                      BILLING_GROUP,
                      DOCTOR_FEE_AMT,
                      PATIENT_ID,
                      BILL_DOC_TYPE_CODE,
                      BILL_NUM,
                      TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
                      MISC_CUST_LONG_NAME,
                      MISC_CUST_SHORT_NAME,
                      MISC_CUST_ADD1_DESC,
                      MISC_CUST_ADD2_DESC,
                      MISC_CUST_ADD3_DESC,
                      MISC_CUST_ZIP_DESC,
                      POST_MONTH,
                      POST_YEAR,
                      ROWID
                 FROM AR_PENDING_DOC
                WHERE CUST_CODE = :ar_customer_cust_code
                  AND NVL(PENDING_AMT,0)    = 0
                  AND MONTHS_BETWEEN(SYSDATE,LAST_UPD_DATE) >= :month_paid_inv
		  /o
                  AND DECODE(:df_instal_flag,'Y',NVL(DOCTOR_FEE_AMT,0),0) = 0
		  o/
                ORDER BY DOC_TYPE_CODE,DOC_NUM; */ 


/*
     EXEC SQL DECLARE AR_CUST_TRN_CUR CURSOR FOR
               SELECT DOC_TYPE_CODE,     DOC_NUM,
                      ORG_DOC_TYPE_CODE, ORG_DOC_NUM,
                      ROWID
                 FROM AR_CUST_TRN
                WHERE CUST_CODE = :ar_customer_cust_code;
*/

     /* EXEC SQL DECLARE AR_PMNT_TERMS_CUR CURSOR FOR
               SELECT LONG_DESC
                 FROM AR_PMNT_TERMS
                WHERE PMNT_TERMS_CODE = :ar_pend_pmnt_terms_code; */ 


     /* EXEC SQL DECLARE GL_POSTING_ACC_CUR CURSOR FOR
               SELECT CONCAT_POST_ACC_DESC
                 FROM GL_POSTING_ACC
                WHERE MAIN_ACC1_CODE       = :ar_pend_main_acc1_code
                  AND MAIN_ACC2_CODE       = :ar_pend_main_acc2_code
                  AND DEPT_CODE            = :ar_pend_dept_code
                  AND PRODUCT_GROUP_CODE   = :ar_pend_product_group_code
                  AND PRODUCT_LINE_CODE    = :ar_pend_product_line_code
                  AND SUBLEDGER_GROUP_CODE = :ar_pend_sub_group_code
                  AND SUBLEDGER_LINE_CODE  = :ar_pend_sub_line_code; */ 


     /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
               SELECT SHORT_DESC
                 FROM BL_BLNG_GRP
                WHERE BLNG_GRP_ID = :ar_pend_billing_group; */ 


     /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
               SELECT SHORT_NAME
                 FROM MP_PATIENT_MAST
                WHERE PATIENT_ID = :ar_pend_patient_id; */ 


}

fetch_descriptions()
{
     /* EXEC SQL OPEN AR_PMNT_TERMS_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0012;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )180;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&ar_pend_pmnt_terms_code;
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

     pmnt_terms_desc.arr[0]    = '\0';
     pmnt_terms_desc.len       = 0;

     /* EXEC SQL FETCH AR_PMNT_TERMS_CUR
               INTO :pmnt_terms_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )199;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&pmnt_terms_desc;
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
         err_mesg("FETCH failed on cursor AR_PMNT_TERMS_CUR",0,"");

     pmnt_terms_desc.arr[pmnt_terms_desc.len] = '\0';

      gl_posting_desc.arr[0]    = '\0';
      gl_posting_desc.len       = 0;

      /* EXEC SQL OPEN GL_POSTING_ACC_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0013;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )218;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&ar_pend_main_acc1_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&ar_pend_main_acc2_code;
      sqlstm.sqhstl[1] = (unsigned int  )7;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&ar_pend_dept_code;
      sqlstm.sqhstl[2] = (unsigned int  )13;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&ar_pend_product_group_code;
      sqlstm.sqhstl[3] = (unsigned int  )6;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&ar_pend_product_line_code;
      sqlstm.sqhstl[4] = (unsigned int  )7;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&ar_pend_sub_group_code;
      sqlstm.sqhstl[5] = (unsigned int  )6;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&ar_pend_sub_line_code;
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



      if (OERROR)
         err_mesg("OPEN failed on cursor GL_POSTING_ACC_CUR",0,"");

      /* EXEC SQL FETCH GL_POSTING_ACC_CUR
                INTO :gl_posting_desc; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )261;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&gl_posting_desc;
      sqlstm.sqhstl[0] = (unsigned int  )66;
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
         err_mesg("FETCH failed on cursor GL_POSTING_ACC_CUR",0,"");

      gl_posting_desc.arr[gl_posting_desc.len] = '\0';


      /* EXEC SQL OPEN BL_BLNG_GRP_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0014;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )280;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&ar_pend_billing_group;
      sqlstm.sqhstl[0] = (unsigned int  )7;
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
         err_mesg("OPEN failed on cursor BL_BLNG_GRP_CUR",0,"");

      billing_group_desc.arr[0]     = '\0';
      billing_group_desc.len        = 0;

      /* EXEC SQL FETCH BL_BLNG_GRP_CUR
                INTO :billing_group_desc; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )299;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&billing_group_desc;
      sqlstm.sqhstl[0] = (unsigned int  )43;
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



      billing_group_desc.arr[billing_group_desc.len] = '\0';

      
      patient_desc.arr[0] = '\0';
      patient_desc.len    = 0;

      /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0015;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )318;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&ar_pend_patient_id;
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
         err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

      /* EXEC SQL FETCH MP_PATIENT_MAST_CUR
                INTO :patient_desc; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )337;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&patient_desc;
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
         err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

      patient_desc.arr[patient_desc.len] = '\0';
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )356;
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

open_files()
{
 char err_stmt[70];

   if ((fp = fopen(filename,"w")) == NULL)
   {
        sprintf(err_stmt,"Error while opening File %s","arbpgdoc.lis");
        err_mesg(err_stmt,0,"");
        proc_exit();
   }

   print_title();
   print_head();

}

print_title()
{
  void print_hospital_name();
  
  /*
  fprintf(fp,
"\n\nMDL : AR                                         %-30s                                      %-15s\n",
      hosp_name.arr,date_time.arr);
  */
   print_hospital_name(133,"AR",hosp_name.arr,date_time.arr);

  fprintf(fp,"OPR : %-10s\n", user_id.arr);
  fprintf(fp,
"REP : %-8s                                       %-28s                                         PAGE : %4d\n",
    g_pgm_id,"PURGED DOCUMENTS REPORT",++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
//fprintf(fp,"VER : 1.10.01\n");
  fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"                CUST CODE      FROM : %-10s\n",nd_fm_cust_code.arr);
fprintf(fp,"                                 TO : %-10s\n\n",nd_to_cust_code.arr);
fprintf(fp,"                GROUP CODE     FROM : %-10s\n",
                      nd_fm_group_code.arr);
fprintf(fp,"                                 TO : %-10s\n\n",
                      nd_to_group_code.arr);
fprintf(fp,"                PRINT ONLY          : %s\n\n",nd_print_flg.arr);

 fflush(fp);
}
   
print_head() 
{  
  void print_hospital_name();
  /*
  fprintf(fp,
"\fMDL : AR                                         %-30s                                      %-15s\n",
      hosp_name.arr,date_time.arr);
  */

  fprintf(fp,"\f");
  print_hospital_name(133,"AR",hosp_name.arr,date_time.arr);

  fprintf(fp,"OPR : %-10s\n", user_id.arr);
  fprintf(fp,
"REP : %-8s                                       %-28s                                         PAGE : %4d\n",
    g_pgm_id,"PURGED DOCUMENTS REPORT",++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,
"DOC TYPE & NO   DOC DATE  CUST CODE & NAME                                TERMS PERIOD     AMT. GROSS       AMT. DISC        AMT. PAY\n");
fprintf(fp,
"       ST.DUE DT. DUE DATE   SETTL. DATE &   %% CUSTOMER REF               TERMS DESC\n");
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
  fflush(fp);
  lctr = 8;
}

print_end()
{
fprintf(fp,
"\n\n\n                                                      **   END  OF  REPORT   ** \n\n");
  fflush(fp);
  fclose(fp);
}

fetch_ar_param()
{
   month_paid_inv = 0;

   /* EXEC SQL SELECT MONTHS_PAID_INV_PURGE
              INTO :month_paid_inv
              FROM AR_PARAMETER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select MONTHS_PAID_INV_PURGE into :b0  from AR_PARAMETER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )387;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&month_paid_inv;
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


  
   if (OERROR)
         err_mesg("SELECT failed on table AR_PARAMETER",0,"");

}

fetch_desc()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0; 
   date_time.len      = 0;
   user_id.len        = 0;

   /* EXEC SQL SELECT ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   USER,NO_OF_DECIMAL
              INTO :hosp_name, :date_time, :user_id,:nd_no_of_decimal
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER ,NO_OF_DECIMAL into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY where ACC_EN\
TITY_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )406;
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
   sqlstm.sqhstv[2] = (         void  *)&user_id;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
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
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin GET_INSTALLED_MODULES ( :p_operational_modules ) ; \
END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )441;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&p_operational_modules;
    sqlstm.sqhstl[0] = (unsigned int  )203;
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

 

	/* EXEC SQL SELECT INSTR(:p_operational_modules , 'DF')
	         into   :df_instal_flag 
			from dual ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INSTR(:b0,'DF') into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )460;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_operational_modules;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&df_instal_flag;
 sqlstm.sqhstl[1] = (unsigned int  )1;
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

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';
}

open_customer()
{
     /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )483;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fm_cust_code;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_cust_code;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fm_group_code;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_to_group_code;
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
         err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");

}

fetch_customer()
{
   ar_customer_cust_code.arr[0]          ='\0';
   ar_customer_patient_flag.arr[0]       = '\0';
   ar_customer_misc_cflag.arr[0] = '\0';
   ar_customer_cust_long_name.arr[0]     = '\0';

   ar_customer_cust_code.len             = 0;
   ar_customer_patient_flag.len          = 0;
   ar_customer_misc_cflag.len    = 0;
   ar_customer_cust_long_name.len        = 0;

   /* EXEC SQL FETCH AR_CUSTOMER_CUR
             INTO :ar_customer_cust_code,
                  :ar_customer_patient_flag,
                  :ar_customer_misc_cflag,
                  :ar_customer_cust_long_name; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )514;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
   sqlstm.sqhstl[0] = (unsigned int  )11;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_customer_patient_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_customer_misc_cflag;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_customer_cust_long_name;
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



  if (OERROR)
         err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

ar_customer_cust_code.arr[ar_customer_cust_code.len]                   = '\0';
ar_customer_patient_flag.arr[ar_customer_patient_flag.len]             = '\0';
ar_customer_misc_cflag.arr[ar_customer_misc_cflag.len] = '\0';
ar_customer_cust_long_name.arr[ar_customer_cust_long_name.len]         = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}

open_pending_doc()
{
     /* EXEC SQL OPEN AR_PENDING_DOC_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0011;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )545;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&month_paid_inv;
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
         err_mesg("OPEN failed on cursor AR_PENDING_DOC_CUR",0,"");

}

fetch_pending_doc()
{
   ar_pend_doc_type_code.arr[0]             = '\0';
   ar_pend_doc_num.arr[0]                   = '\0';
   ar_pend_doc_date.arr[0]                  = '\0';
   ar_pend_base_date.arr[0]                 = '\0';
   ar_pend_pmnt_terms_code.arr[0]           = '\0';
   ar_pend_due_date.arr[0]                  = '\0';
   ar_pend_settlement_date.arr[0]           = '\0';
   ar_pend_settlement_perc.arr[0]           = '\0';
   ar_pend_cust_ref.arr[0]                  = '\0';
   ar_pend_main_acc1_code.arr[0]            = '\0';
   ar_pend_main_acc2_code.arr[0]            = '\0';
   ar_pend_dept_code.arr[0]                 = '\0';
   ar_pend_product_group_code.arr[0]        = '\0';
   ar_pend_product_line_code.arr[0]         = '\0';
   ar_pend_sub_group_code.arr[0]      = '\0';
   ar_pend_sub_line_code.arr[0]       = '\0';
   ar_pend_narration.arr[0]                 = '\0';
   ar_pend_billing_group.arr[0]             = '\0';
   ar_pend_patient_id.arr[0]                = '\0';
   ar_pend_bill_doc_type_code.arr[0]        = '\0';
   ar_pend_bill_num.arr[0]                  = '\0';
   ar_pend_bill_date.arr[0]                 = '\0';
   ar_pend_misc_clong_name.arr[0]       = '\0';
   ar_pend_misc_cshort_name.arr[0]      = '\0';
   ar_pend_misc_cadd1_desc.arr[0]       = '\0';
   ar_pend_misc_cadd2_desc.arr[0]       = '\0';
   ar_pend_misc_cadd3_desc.arr[0]       = '\0';
   ar_pend_misc_czip_desc.arr[0]        = '\0';
   ar_pend_rowid.arr[0]                     = '\0';

   ar_pend_doc_type_code.len                = 0;
   ar_pend_doc_num.len                      = 0;
   ar_pend_doc_date.len                     = 0;
   ar_pend_base_date.len                    = 0;
   ar_pend_pmnt_terms_code.len              = 0;
   ar_pend_due_date.len                     = 0;
   ar_pend_settlement_date.len              = 0;
   ar_pend_settlement_perc.len              = 0;
   ar_pend_cust_ref.len                     = 0;
   ar_pend_main_acc1_code.len               = 0;
   ar_pend_main_acc2_code.len               = 0;
   ar_pend_dept_code.len                    = 0;
   ar_pend_product_group_code.len           = 0;
   ar_pend_product_line_code.len            = 0;
   ar_pend_sub_group_code.len         = 0;
   ar_pend_sub_line_code.len          = 0;
   ar_pend_narration.len                    = 0;
   ar_pend_billing_group.len                = 0;
   ar_pend_patient_id.len                   = 0;
   ar_pend_bill_doc_type_code.len           = 0;
   ar_pend_bill_num.len                     = 0;
   ar_pend_bill_date.len                    = 0;
   ar_pend_misc_clong_name.len          = 0;
   ar_pend_misc_cshort_name.len         = 0;
   ar_pend_misc_cadd1_desc.len          = 0;
   ar_pend_misc_cadd2_desc.len          = 0;
   ar_pend_misc_cadd3_desc.len          = 0;
   ar_pend_misc_czip_desc.len           = 0;
   ar_pend_rowid.len                        = 0;

   ar_pend_gross_amt                        = 0;
   ar_pend_payable_amt                      = 0;
   ar_pend_discount_amt                     = 0;
   ar_pend_doctor_fee_amt                   = 0;

   /* EXEC SQL FETCH AR_PENDING_DOC_CUR
             INTO :ar_pend_doc_type_code,
                  :ar_pend_doc_num,
                  :ar_pend_doc_date,
                  :ar_pend_base_date,
                  :ar_pend_pmnt_terms_code,
                  :ar_pend_gross_amt,
                  :ar_pend_discount_amt,
                  :ar_pend_payable_amt,
                  :ar_pend_due_date,
                  :ar_pend_settlement_date,
                  :ar_pend_settlement_perc,
                  :ar_pend_cust_ref,
                  :ar_pend_main_acc1_code,
                  :ar_pend_main_acc2_code,
                  :ar_pend_dept_code,
                  :ar_pend_product_group_code,
                  :ar_pend_product_line_code,
                  :ar_pend_sub_group_code,
                  :ar_pend_sub_line_code,
                  :ar_pend_narration,
                  :ar_pend_billing_group,
                  :ar_pend_doctor_fee_amt,
                  :ar_pend_patient_id,
                  :ar_pend_bill_doc_type_code,
                  :ar_pend_bill_num,
                  :ar_pend_bill_date,
                  :ar_pend_misc_clong_name,
                  :ar_pend_misc_cshort_name,
                  :ar_pend_misc_cadd1_desc,
                  :ar_pend_misc_cadd2_desc,
                  :ar_pend_misc_cadd3_desc,
                  :ar_pend_misc_czip_desc,
                  :ar_pend_post_month,
                  :ar_pend_post_year,
                  :ar_pend_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )568;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_pend_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_pend_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_pend_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_pend_base_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_pend_pmnt_terms_code;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ar_pend_gross_amt;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ar_pend_discount_amt;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ar_pend_payable_amt;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&ar_pend_due_date;
   sqlstm.sqhstl[8] = (unsigned int  )14;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&ar_pend_settlement_date;
   sqlstm.sqhstl[9] = (unsigned int  )14;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&ar_pend_settlement_perc;
   sqlstm.sqhstl[10] = (unsigned int  )10;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&ar_pend_cust_ref;
   sqlstm.sqhstl[11] = (unsigned int  )18;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&ar_pend_main_acc1_code;
   sqlstm.sqhstl[12] = (unsigned int  )9;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&ar_pend_main_acc2_code;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&ar_pend_dept_code;
   sqlstm.sqhstl[14] = (unsigned int  )13;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&ar_pend_product_group_code;
   sqlstm.sqhstl[15] = (unsigned int  )6;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&ar_pend_product_line_code;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&ar_pend_sub_group_code;
   sqlstm.sqhstl[17] = (unsigned int  )6;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&ar_pend_sub_line_code;
   sqlstm.sqhstl[18] = (unsigned int  )11;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&ar_pend_narration;
   sqlstm.sqhstl[19] = (unsigned int  )53;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&ar_pend_billing_group;
   sqlstm.sqhstl[20] = (unsigned int  )7;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&ar_pend_doctor_fee_amt;
   sqlstm.sqhstl[21] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&ar_pend_patient_id;
   sqlstm.sqhstl[22] = (unsigned int  )23;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&ar_pend_bill_doc_type_code;
   sqlstm.sqhstl[23] = (unsigned int  )9;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&ar_pend_bill_num;
   sqlstm.sqhstl[24] = (unsigned int  )11;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&ar_pend_bill_date;
   sqlstm.sqhstl[25] = (unsigned int  )14;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&ar_pend_misc_clong_name;
   sqlstm.sqhstl[26] = (unsigned int  )103;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&ar_pend_misc_cshort_name;
   sqlstm.sqhstl[27] = (unsigned int  )63;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&ar_pend_misc_cadd1_desc;
   sqlstm.sqhstl[28] = (unsigned int  )63;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&ar_pend_misc_cadd2_desc;
   sqlstm.sqhstl[29] = (unsigned int  )63;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&ar_pend_misc_cadd3_desc;
   sqlstm.sqhstl[30] = (unsigned int  )63;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&ar_pend_misc_czip_desc;
   sqlstm.sqhstl[31] = (unsigned int  )33;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&ar_pend_post_month;
   sqlstm.sqhstl[32] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&ar_pend_post_year;
   sqlstm.sqhstl[33] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&ar_pend_rowid;
   sqlstm.sqhstl[34] = (unsigned int  )33;
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
         err_mesg("FETCH failed on cursor AR_PENDING_DOC",0,"");

ar_pend_doc_type_code.arr[ar_pend_doc_type_code.len]                     = '\0';
ar_pend_doc_num.arr[ar_pend_doc_num.len]                                 = '\0';
ar_pend_doc_date.arr[ar_pend_doc_date.len]                               = '\0';
ar_pend_base_date.arr[ar_pend_base_date.len]                             = '\0';
ar_pend_pmnt_terms_code.arr[ar_pend_pmnt_terms_code.len]                 = '\0';
ar_pend_due_date.arr[ar_pend_due_date.len]                               = '\0';
ar_pend_settlement_date.arr[ar_pend_settlement_date.len]                 = '\0';
ar_pend_settlement_perc.arr[ar_pend_settlement_perc.len]                 = '\0';
ar_pend_cust_ref.arr[ar_pend_cust_ref.len]                               = '\0';
ar_pend_main_acc1_code.arr[ar_pend_main_acc1_code.len]                   = '\0';
ar_pend_main_acc2_code.arr[ar_pend_main_acc2_code.len]                   = '\0';
ar_pend_dept_code.arr[ar_pend_dept_code.len]                             = '\0';
ar_pend_product_group_code.arr[ar_pend_product_group_code.len]           = '\0';
ar_pend_product_line_code.arr[ar_pend_product_line_code.len]             = '\0';
ar_pend_sub_group_code.arr[ar_pend_sub_group_code.len]       = '\0';
ar_pend_sub_line_code.arr[ar_pend_sub_line_code.len]         = '\0';
ar_pend_narration.arr[ar_pend_narration.len]                             = '\0';
ar_pend_billing_group.arr[ar_pend_billing_group.len]                     = '\0';
ar_pend_patient_id.arr[ar_pend_patient_id.len]                           = '\0';
ar_pend_bill_doc_type_code.arr[ar_pend_bill_doc_type_code.len]           = '\0';
ar_pend_bill_num.arr[ar_pend_bill_num.len]                               = '\0';
ar_pend_bill_date.arr[ar_pend_bill_date.len]                             = '\0';
ar_pend_misc_clong_name.arr[ar_pend_misc_clong_name.len]         = '\0';
ar_pend_misc_cshort_name.arr[ar_pend_misc_cshort_name.len]       = '\0';
ar_pend_misc_cadd1_desc.arr[ar_pend_misc_cadd1_desc.len]         = '\0';
ar_pend_misc_cadd2_desc.arr[ar_pend_misc_cadd2_desc.len]         = '\0';
ar_pend_misc_cadd3_desc.arr[ar_pend_misc_cadd3_desc.len]         = '\0';
ar_pend_misc_czip_desc.arr[ar_pend_misc_czip_desc.len]           = '\0';
ar_pend_rowid.arr[ar_pend_rowid.len]                                     = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}

print_details()
{
   if (lctr > 56) print_head();

   fprintf(fp,"%-6s %8s %-10s %-8s %-40s %-2s  %02d/%02d ",
           ar_pend_doc_type_code.arr,
           ar_pend_doc_num.arr,
           ar_pend_doc_date.arr,
           ar_customer_cust_code.arr,
           ar_customer_cust_long_name.arr,
           ar_pend_pmnt_terms_code.arr,
           ar_pend_post_month,
           ar_pend_post_year);
            
           print_formated(ar_pend_gross_amt);
           fprintf(fp,"  ");
           print_formated(ar_pend_discount_amt);
           fprintf(fp,"  ");
           print_formated(ar_pend_payable_amt);
           fprintf(fp,"\n");


   fprintf(fp,"       %-10s %-10s %-10s %6s %-15s            %-30s\n",
            ar_pend_base_date.arr,
            ar_pend_due_date.arr,
            ar_pend_settlement_date.arr,
            ar_pend_settlement_perc.arr,
            ar_pend_cust_ref.arr,
            pmnt_terms_desc.arr);
  
    fprintf(fp,"    POSTING A/C   : %-6s-%-4s %-6s %-3s-%-4s %-3s-%-8s\n",
             ar_pend_main_acc1_code.arr,
             ar_pend_main_acc2_code.arr,
             ar_pend_dept_code.arr,
             ar_pend_product_group_code.arr,
             ar_pend_product_line_code.arr,
             ar_pend_sub_group_code.arr,
             ar_pend_sub_line_code.arr);
    fprintf(fp,"                    %-s\n",gl_posting_desc.arr);
    fprintf(fp,"    NARRATION     : %-50s\n",ar_pend_narration.arr);
    lctr+=5;

    if (ar_customer_patient_flag.arr[0]  == 'Y')
    {
        if (lctr > 56) print_head();

        fprintf(fp,"    BILLING GROUP : %-2s %-15s                  ",
                ar_pend_billing_group.arr,billing_group_desc.arr);
        fprintf(fp,"     BILL DOC TYPE, NO & DATE : %-6s %8s %-10s\n",
                   ar_pend_bill_doc_type_code.arr,
                   ar_pend_bill_num.arr,
                   ar_pend_bill_date.arr);
        fprintf(fp,"    PATIENT ID    : %-10s %-30s\n",
                   ar_pend_patient_id.arr,patient_desc.arr);
        lctr+=2;
        fflush(fp);
    }

    if (ar_customer_misc_cflag.arr[0] == 'Y')
    {
         if (lctr > 56) print_head();

         fprintf(fp,"    MISC CUSTOMER : %-40s %-15s\n",
                        ar_pend_misc_clong_name.arr,
                        ar_pend_misc_cshort_name.arr);
         fprintf(fp,"                    %-30s           %-30s\n",
                        ar_pend_misc_cadd1_desc.arr,
                        ar_pend_misc_cadd2_desc.arr);
         fprintf(fp,"                    %-30s           %-30s\n",
                        ar_pend_misc_cadd3_desc.arr,
                        ar_pend_misc_czip_desc.arr);
         lctr+=3;
         fflush(fp);
     
     }
     fprintf(fp,"\n");
     lctr ++;
     fflush(fp);
}

delete_pending_doc()
{
    /* EXEC SQL DELETE AR_PENDING_DOC
              WHERE ROWID = :ar_pend_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from AR_PENDING_DOC  where ROWID=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )723;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&ar_pend_rowid;
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
         err_mesg("DELETE failed on table AR_PENDING_DOC",0,"");

}

delete_cust_trn()
{
   /* EXEC SQL DELETE FROM AR_CUST_TRN
             WHERE CUST_CODE = :ar_customer_cust_code
               AND ORG_DOC_TYPE_CODE = :ar_pend_doc_type_code
               AND ORG_DOC_NUM       = :ar_pend_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from AR_CUST_TRN  where ((CUST_CODE=:b0 and ORG_DO\
C_TYPE_CODE=:b1) and ORG_DOC_NUM=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )742;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
   sqlstm.sqhstl[0] = (unsigned int  )11;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_pend_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_pend_doc_num;
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
         err_mesg("DELETE failed on table AR_CUST_TRN",0,"");

}

delete_patient_dtls()
{
   /* EXEC SQL DELETE FROM AR_PATIENT_DTLS
             WHERE DOC_TYPE_CODE = :ar_pend_doc_type_code
               AND DOC_NUM       = :ar_pend_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from AR_PATIENT_DTLS  where (DOC_TYPE_CODE=:b0 and\
 DOC_NUM=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )769;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_pend_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_pend_doc_num;
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
         err_mesg("DELETE failed on table AR_PATIENT_DTLS",0,"");

}

print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (nd_no_of_decimal==3)
      sprintf(out_str,"%11.3f",loc_amount);
   else
      sprintf(out_str,"%11.2f",loc_amount);

	  format_amt(out_str,nd_no_of_decimal);

   if (loc_amount == 0)
      fprintf(fp,"%-14s"," ");
   else if (loc_amount > 0)
   {
      //sprintf(out_str,"%11.2f",loc_amount);
      //ltrim(out_str);	  
	  //put_comma(out_str);

 	  format_amt(out_str,nd_no_of_decimal);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s",out_str1);
   }
   else
   {
      //sprintf(out_str,"%11.2f",-loc_amount);
      //ltrim(out_str);	  
	  //put_comma(out_str);
	  format_amt(out_str,nd_no_of_decimal);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14sCR",out_str1);      
   }
}

void print_hospital_name(nd_rep_width    ,
                         nd_mod_id       ,
                         nd_hospital_name,
                         nd_date          )
int  nd_rep_width;
char nd_mod_id[3];
char nd_hospital_name[31];
char nd_date[17];
{
	int i = 0 , pos = 0 , len = 0, len_date = 0 , pos_date = 0,len1=0;

    /*Find the length of Hospital Name*/
    for(len = 0; nd_hospital_name[len] != '\0'; len++);

    /*Find the length of Date*/
    for(len_date = 0; nd_date[len_date] != '\0'; len_date++);

	len1 = (len % 2);

	if (len1==0)
	   len1=9;
    else
	   len1=10;

    len = len / 2;

    pos = (nd_rep_width / 2	) - len;

	pos_date = nd_rep_width - len_date;

	fprintf(fp,"MDL : %2s",nd_mod_id);

	for(i = 9; i < pos ; fprintf(fp," "),i++);

	fprintf(fp,"%s",nd_hospital_name);

	for(i = i + (len * 2) ; i < pos_date + 1; fprintf(fp," "),i++);

    fprintf(fp,"%s\n",nd_date);
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

