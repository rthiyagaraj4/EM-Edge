
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
           char  filnam[55];
};
static const struct sqlcxp sqlfpn =
{
    54,
    "C:\\Users\\RajeshK\\Desktop\\Proc_file\\Arbinpst\\RC_POST.PC"
};


static unsigned long sqlctx = 114917941;


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
            void  *sqhstv[36];
   unsigned int   sqhstl[36];
            int   sqhsts[36];
            void  *sqindv[36];
            int   sqinds[36];
   unsigned int   sqharm[36];
   unsigned int   *sqharc[36];
   unsigned short  sqadto[36];
   unsigned short  sqtdso[36];
} sqlstm = {10,36};

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

 static const char *sq0011 = 
"select DOC_TYPE_CODE ,DOC_NUM ,INV_DOC_TYPE_CODE ,INV_DOC_NUM ,BILL_DOC_TYPE\
_CODE ,BILL_NUM ,NVL(AMOUNT,0) ,ABS(nvl(AMOUNT,0)) ,ROWID  from AR_PATIENT_ALL\
OC_DTLS where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) order by DOC_TYPE_CODE,DOC_N\
UM            ";

 static const char *sq0012 = 
"select AMT_LOCAL ,LINE_NUM ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODU\
CT_GROUP_CODE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,O\
RG_DOC_TYPE_CODE ,ORG_DOC_NUM ,LINE_TYPE_CODE ,NARRATION ,CONSOLIDATED_INV_YN \
 from AR_REC_LINE where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4130,0,0,0,
5,0,0,1,151,0,4,341,0,0,6,4,0,1,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
44,0,0,2,147,0,5,355,0,0,5,5,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
79,0,0,3,147,0,5,369,0,0,5,5,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
114,0,0,4,291,0,4,406,0,0,11,3,0,1,0,2,3,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
173,0,0,5,212,0,5,449,0,0,6,6,0,1,0,1,9,0,0,1,4,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
212,0,0,6,1024,0,3,470,0,0,36,36,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
371,0,0,7,328,0,3,575,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
450,0,0,8,104,0,5,628,0,0,2,2,0,1,0,1,4,0,0,1,9,0,0,
473,0,0,9,191,0,5,635,0,0,5,5,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
508,0,0,10,131,0,5,650,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
531,0,0,11,246,0,9,691,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
554,0,0,11,0,0,13,718,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
605,0,0,12,302,0,9,776,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
628,0,0,12,0,0,13,821,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
699,0,0,13,469,0,3,875,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
750,0,0,14,350,0,3,933,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
817,0,0,15,359,0,3,988,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


#include <stdio.h> 
#include <string.h>
#include <math.h>

                 

#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)
/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


 /* VARCHAR    l_hdr_acc_entity_code               [5],
            l_hdr_doc_type_code                 [7],
            l_hdr_doc_num                       [9],
            l_hdr_last_line_num                 [5],
            l_hdr_doc_date                      [15],
            l_hdr_doc_ref                       [11],
            l_hdr_cust_code                     [9],
            l_hdr_main_acc1_code                [7],
            l_hdr_main_acc2_code                [5],
            l_hdr_subledger_group_code          [4],
            l_hdr_subledger_line_code           [9],
            l_hdr_dept_code                     [7],
            l_hdr_product_group_code            [4],
            l_hdr_product_line_code             [5],
            l_hdr_amt_local                     [17],
            l_hdr_narration                     [51],
            l_hdr_post_month                    [3],
            l_hdr_post_year                     [5],
            l_hdr_currency_code                 [7],
            l_hdr_exchg_rate                    [15],
            l_hdr_misc_cust_long_name           [41],
            l_hdr_misc_cust_short_name          [16],
            l_hdr_misc_cust_add1_desc           [31],
            l_hdr_misc_cust_add2_desc           [31],
            l_hdr_misc_cust_add3_desc           [31],
            l_hdr_misc_cust_zip_desc            [31],
            l_hdr_misc_long_name_ch             [41],
            l_hdr_misc_short_name_ch            [16],
            l_hdr_misc_add1_desc_ch             [31],
            l_hdr_misc_add2_desc_ch             [31],
            l_hdr_misc_add3_desc_ch             [31],
            l_hdr_misc_zip_desc_ch              [31],
            l_hdr_tel_num                       [31],
            l_hdr_contact_name                  [41],
            l_hdr_contact_name_title            [41],
            l_hdr_rowid                         [31],
			l_consolidated_yn                   [2],
			l_bank_desc                         [31],
            l_hdr_ar_interface_cd               [3],

            l_line_main_acc1_code                  [7],
            l_line_main_acc2_code                  [5],
            l_line_dept_code                       [7],
            l_line_product_group_code              [4],
            l_line_product_line_code               [5],
            l_line_subledger_group_code            [4],
            l_line_subledger_line_code             [9],
            l_line_amt_local                       [17],
            l_line_line_num                        [5],
            l_line_org_doc_type_code               [7],
            l_line_org_doc_num                     [9],
            l_line_line_type_code                  [2],
            l_line_narration                       [51],
            l_line_acc_entity_code                 [5],

            l_hdr_ar_cheque_num                    [11],
            l_hdr_ar_cheque_date                   [12],
            df_param_ref_num                       [10],
	    l_episode_type                         [2],
	    l_episode_id                           [9],
	    l_patient_id                           [11],
	    l_visit_id                             [5],
	    l_doc_type_code                        [7],
	    l_doc_num                              [9]; */ 
struct { unsigned short len; unsigned char arr[5]; } l_hdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[7]; } l_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_hdr_doc_num;

struct { unsigned short len; unsigned char arr[5]; } l_hdr_last_line_num;

struct { unsigned short len; unsigned char arr[15]; } l_hdr_doc_date;

struct { unsigned short len; unsigned char arr[11]; } l_hdr_doc_ref;

struct { unsigned short len; unsigned char arr[9]; } l_hdr_cust_code;

struct { unsigned short len; unsigned char arr[7]; } l_hdr_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } l_hdr_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } l_hdr_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } l_hdr_subledger_line_code;

struct { unsigned short len; unsigned char arr[7]; } l_hdr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } l_hdr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } l_hdr_product_line_code;

struct { unsigned short len; unsigned char arr[17]; } l_hdr_amt_local;

struct { unsigned short len; unsigned char arr[51]; } l_hdr_narration;

struct { unsigned short len; unsigned char arr[3]; } l_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } l_hdr_post_year;

struct { unsigned short len; unsigned char arr[7]; } l_hdr_currency_code;

struct { unsigned short len; unsigned char arr[15]; } l_hdr_exchg_rate;

struct { unsigned short len; unsigned char arr[41]; } l_hdr_misc_cust_long_name;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_misc_cust_short_name;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_cust_add1_desc;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_cust_add2_desc;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_cust_add3_desc;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_cust_zip_desc;

struct { unsigned short len; unsigned char arr[41]; } l_hdr_misc_long_name_ch;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_misc_short_name_ch;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_add1_desc_ch;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_add2_desc_ch;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_add3_desc_ch;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_zip_desc_ch;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_tel_num;

struct { unsigned short len; unsigned char arr[41]; } l_hdr_contact_name;

struct { unsigned short len; unsigned char arr[41]; } l_hdr_contact_name_title;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_rowid;

struct { unsigned short len; unsigned char arr[2]; } l_consolidated_yn;

struct { unsigned short len; unsigned char arr[31]; } l_bank_desc;

struct { unsigned short len; unsigned char arr[3]; } l_hdr_ar_interface_cd;

struct { unsigned short len; unsigned char arr[7]; } l_line_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } l_line_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } l_line_dept_code;

struct { unsigned short len; unsigned char arr[4]; } l_line_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } l_line_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } l_line_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } l_line_subledger_line_code;

struct { unsigned short len; unsigned char arr[17]; } l_line_amt_local;

struct { unsigned short len; unsigned char arr[5]; } l_line_line_num;

struct { unsigned short len; unsigned char arr[7]; } l_line_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_line_org_doc_num;

struct { unsigned short len; unsigned char arr[2]; } l_line_line_type_code;

struct { unsigned short len; unsigned char arr[51]; } l_line_narration;

struct { unsigned short len; unsigned char arr[5]; } l_line_acc_entity_code;

struct { unsigned short len; unsigned char arr[11]; } l_hdr_ar_cheque_num;

struct { unsigned short len; unsigned char arr[12]; } l_hdr_ar_cheque_date;

struct { unsigned short len; unsigned char arr[10]; } df_param_ref_num;

struct { unsigned short len; unsigned char arr[2]; } l_episode_type;

struct { unsigned short len; unsigned char arr[9]; } l_episode_id;

struct { unsigned short len; unsigned char arr[11]; } l_patient_id;

struct { unsigned short len; unsigned char arr[5]; } l_visit_id;

struct { unsigned short len; unsigned char arr[7]; } l_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_doc_num;


/* VARCHAR  d_interface_code[2],
         d_pat_doc_type_code          [7],
         d_pat_doc_num                [9],
         d_pat_patient_id             [21],
         d_pat_bill_doc_type_code     [7],
         d_pat_bill_num               [9],
         d_pat_inv_doc_type_code      [7],
         d_pat_inv_doc_num            [9],
         d_pat_bill_date              [12],
         d_pat_rowid                  [31]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_interface_code;

struct { unsigned short len; unsigned char arr[7]; } d_pat_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_pat_doc_num;

struct { unsigned short len; unsigned char arr[21]; } d_pat_patient_id;

struct { unsigned short len; unsigned char arr[7]; } d_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_pat_bill_num;

struct { unsigned short len; unsigned char arr[7]; } d_pat_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_pat_inv_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_pat_bill_date;

struct { unsigned short len; unsigned char arr[31]; } d_pat_rowid;


int         l_ar_pend_last_doc_line_num;

double      l_line_amt_total = 0;

double       d_pat_amount ,
		temp_pend_amt,
		temp_amount,
             d_pat_abs_amount ;

double      l_ar_pend_doctor_fee_amt = 0,
            l_ar_pend_pending_amt    = 0,
            l_ar_pend_hosp_charges   = 0,
            doctor_fees_to_be_paid   = 0;

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






extern long atol();
extern double atof();

ar_rec_posting(
            passed_acc_entity_code,
            passed_doc_type_code,
            passed_doc_num,
            passed_last_line_num,
            passed_doc_date,
            passed_doc_ref,
            passed_cust_code,
            passed_main_acc1_code,
            passed_main_acc2_code,
            passed_subledger_group_code,
            passed_subledger_line_code,
            passed_dept_code,
            passed_product_group_code,
            passed_product_line_code,
            passed_amt_local,
            passed_narration,
            passed_post_month,
            passed_post_year,
            passed_currency_code,
            passed_exchg_rate,
            passed_misc_cust_long_name,
            passed_misc_cust_short_name,
            passed_misc_cust_add1_desc,
            passed_misc_cust_add2_desc,
            passed_misc_cust_add3_desc,
            passed_misc_cust_zip_desc,
            passed_misc_long_name_ch,
            passed_misc_short_name_ch,
            passed_misc_add1_desc_ch,
            passed_misc_add2_desc_ch,
            passed_misc_add3_desc_ch,
            passed_misc_zip_desc_ch,
            passed_tel_num,
            passed_contact_name,
            passed_contact_name_title,
            passed_rowid,
            l_ar_interface,
            passed_doc_date_chking,
            passed_last_rec_doc_dt,
            passed_cheque_num,
            passed_cheque_date,
			passed_bank_desc)
char passed_acc_entity_code       [  ],
     passed_doc_type_code         [  ],
     passed_doc_num               [  ],
     passed_last_line_num         [  ],
     passed_doc_date              [  ],
     passed_doc_ref               [  ],
     passed_cust_code             [  ],
     passed_main_acc1_code        [  ],
     passed_main_acc2_code        [  ],
     passed_subledger_group_code  [  ],
     passed_subledger_line_code   [  ],
     passed_dept_code             [  ],
     passed_product_group_code    [  ],
     passed_product_line_code     [  ],
     passed_amt_local             [  ],
     passed_narration             [  ],
     passed_post_month            [  ],
     passed_post_year             [  ],
     passed_currency_code         [  ],
     passed_exchg_rate            [  ],
     passed_misc_cust_long_name   [  ],
     passed_misc_cust_short_name  [  ],
     passed_misc_cust_add1_desc   [  ],
     passed_misc_cust_add2_desc   [  ],
     passed_misc_cust_add3_desc   [  ],
     passed_misc_cust_zip_desc    [  ],
     passed_misc_long_name_ch     [  ],
     passed_misc_short_name_ch    [  ],
     passed_misc_add1_desc_ch     [  ],
     passed_misc_add2_desc_ch     [  ],
     passed_misc_add3_desc_ch     [  ],
     passed_misc_zip_desc_ch      [  ],
     passed_tel_num               [  ],
     passed_contact_name          [  ],
     passed_contact_name_title    [  ],
     passed_rowid                 [  ],
     l_ar_interface               [  ],
     passed_cheque_num            [  ],
     passed_cheque_date           [  ],
	 passed_bank_desc             [  ];

char passed_doc_date_chking       [ ],
     passed_last_rec_doc_dt       [ ];
{

static int decl_flg = 1;

if (decl_flg) l_decl_line();


strcpy(l_hdr_acc_entity_code.arr,passed_acc_entity_code);
strcpy(l_hdr_doc_type_code.arr,passed_doc_type_code);
strcpy(l_hdr_doc_num.arr,passed_doc_num);
strcpy(l_hdr_last_line_num.arr,passed_last_line_num);
strcpy(l_hdr_doc_date.arr,passed_doc_date);
strcpy(l_hdr_doc_ref.arr,passed_doc_ref);
strcpy(l_hdr_cust_code.arr,passed_cust_code);
strcpy(l_hdr_main_acc1_code.arr,passed_main_acc1_code);
strcpy(l_hdr_main_acc2_code.arr,passed_main_acc2_code);
strcpy(l_hdr_subledger_group_code.arr,passed_subledger_group_code);
strcpy(l_hdr_subledger_line_code.arr,passed_subledger_line_code);
strcpy(l_hdr_dept_code.arr,passed_dept_code);
strcpy(l_hdr_product_group_code.arr,passed_product_group_code);
strcpy(l_hdr_product_line_code.arr,passed_product_line_code);
strcpy(l_hdr_amt_local.arr,passed_amt_local);
strcpy(l_hdr_narration.arr,passed_narration);
strcpy(l_hdr_post_month.arr,passed_post_month);
strcpy(l_hdr_post_year.arr,passed_post_year);
strcpy(l_hdr_currency_code.arr,passed_currency_code);
strcpy(l_hdr_exchg_rate.arr,passed_exchg_rate);
strcpy(l_hdr_misc_cust_long_name.arr,passed_misc_cust_long_name);
strcpy(l_hdr_misc_cust_short_name.arr,passed_misc_cust_short_name);
strcpy(l_hdr_misc_cust_add1_desc.arr,passed_misc_cust_add1_desc);
strcpy(l_hdr_misc_cust_add2_desc.arr,passed_misc_cust_add2_desc);
strcpy(l_hdr_misc_cust_add3_desc.arr,passed_misc_cust_add3_desc);
strcpy(l_hdr_misc_cust_zip_desc.arr,passed_misc_cust_zip_desc);
strcpy(l_hdr_misc_long_name_ch.arr,passed_misc_long_name_ch);
strcpy(l_hdr_misc_short_name_ch.arr,passed_misc_short_name_ch);
strcpy(l_hdr_misc_add1_desc_ch.arr,passed_misc_add1_desc_ch);
strcpy(l_hdr_misc_add2_desc_ch.arr,passed_misc_add2_desc_ch);
strcpy(l_hdr_misc_add3_desc_ch.arr,passed_misc_add3_desc_ch);
strcpy(l_hdr_misc_zip_desc_ch.arr,passed_misc_zip_desc_ch);
strcpy(l_hdr_tel_num.arr,passed_tel_num);
strcpy(l_hdr_contact_name.arr,passed_contact_name);
strcpy(l_hdr_contact_name_title.arr,passed_contact_name_title);
strcpy(l_hdr_rowid.arr,passed_rowid);
strcpy(l_hdr_ar_interface_cd.arr,l_ar_interface);
strcpy(l_hdr_ar_cheque_num.arr,passed_cheque_num);
strcpy(l_hdr_ar_cheque_date.arr,passed_cheque_date);
strcpy(l_bank_desc.arr,passed_bank_desc);


l_hdr_acc_entity_code.len = strlen(l_hdr_acc_entity_code.arr);
l_hdr_doc_type_code.len = strlen(l_hdr_doc_type_code.arr);
l_hdr_doc_num.len = strlen(l_hdr_doc_num.arr);
l_hdr_last_line_num.len = strlen(l_hdr_last_line_num.arr);
l_hdr_doc_date.len = strlen(l_hdr_doc_date.arr);
l_hdr_doc_ref.len = strlen(l_hdr_doc_ref.arr);
l_hdr_cust_code.len = strlen(l_hdr_cust_code.arr);
l_hdr_main_acc1_code.len = strlen(l_hdr_main_acc1_code.arr);
l_hdr_main_acc2_code.len = strlen(l_hdr_main_acc2_code.arr);
l_hdr_subledger_group_code.len = strlen(l_hdr_subledger_group_code.arr);
l_hdr_subledger_line_code.len = strlen(l_hdr_subledger_line_code.arr);
l_hdr_dept_code.len = strlen(l_hdr_dept_code.arr);
l_hdr_product_group_code.len = strlen(l_hdr_product_group_code.arr);
l_hdr_product_line_code.len = strlen(l_hdr_product_line_code.arr);
l_hdr_amt_local.len = strlen(l_hdr_amt_local.arr);
l_hdr_narration.len = strlen(l_hdr_narration.arr);
l_hdr_post_month.len = strlen(l_hdr_post_month.arr);
l_hdr_post_year.len = strlen(l_hdr_post_year.arr);
l_hdr_currency_code.len = strlen(l_hdr_currency_code.arr);
l_hdr_exchg_rate.len = strlen(l_hdr_exchg_rate.arr);
l_hdr_misc_cust_long_name.len = strlen(l_hdr_misc_cust_long_name.arr);
l_hdr_misc_cust_short_name.len = strlen(l_hdr_misc_cust_short_name.arr);
l_hdr_misc_cust_add1_desc.len = strlen(l_hdr_misc_cust_add1_desc.arr);
l_hdr_misc_cust_add2_desc.len = strlen(l_hdr_misc_cust_add2_desc.arr);
l_hdr_misc_cust_add3_desc.len = strlen(l_hdr_misc_cust_add3_desc.arr);
l_hdr_misc_cust_zip_desc.len = strlen(l_hdr_misc_cust_zip_desc.arr);
l_hdr_misc_long_name_ch.len = strlen(l_hdr_misc_long_name_ch.arr);
l_hdr_misc_short_name_ch.len = strlen(l_hdr_misc_short_name_ch.arr);
l_hdr_misc_add1_desc_ch.len = strlen(l_hdr_misc_add1_desc_ch.arr);
l_hdr_misc_add2_desc_ch.len = strlen(l_hdr_misc_add2_desc_ch.arr);
l_hdr_misc_add3_desc_ch.len = strlen(l_hdr_misc_add3_desc_ch.arr);
l_hdr_misc_zip_desc_ch.len = strlen(l_hdr_misc_zip_desc_ch.arr);
l_hdr_tel_num.len = strlen(l_hdr_tel_num.arr);
l_hdr_contact_name.len = strlen(l_hdr_contact_name.arr);
l_hdr_contact_name_title.len = strlen(l_hdr_contact_name_title.arr);
l_hdr_rowid.len = strlen(l_hdr_rowid.arr);
l_hdr_ar_interface_cd.len = strlen(l_hdr_ar_interface_cd.arr);
l_hdr_ar_cheque_num.len   = strlen(l_hdr_ar_cheque_num.arr);
l_hdr_ar_cheque_date.len   = strlen(l_hdr_ar_cheque_date.arr);
l_bank_desc.len   = strlen(l_bank_desc.arr);

#ifdef DEBUG
  sprintf(string_var,"Doc - <%s-%s> \n",l_hdr_doc_type_code.arr,
                    l_hdr_doc_num.arr);
                    disp_message(INFO_MESG,string_var);
#endif


#ifdef DEBUG
   sprintf(string_var," last rec dt -> <%ld>  doc date -> <%ld>\n",
	     passed_last_rec_doc_dt,passed_doc_date_chking);
	     disp_message(INFO_MESG,string_var);
#endif
 
 if (l_hdr_ar_interface_cd.arr[0] == 'O')
      l_gl_doc_insert();

 l_rc_open_rec_line();

 l_line_amt_total = 0;
 
 while (l_fetch_rc_line())
 {
   #ifdef DEBUG
      disp_message(INFO_MESG,"After rec from Rc line \n"); 
   #endif

    l_ar_pend_last_doc_line_num = 1;

#ifdef DEBUG
  disp_message(INFO_MESG,"Before ins gl_insert_line\n");
#endif

/**********************************************************/

 
 if (strcmp(l_consolidated_yn.arr , "Y") == 0)
 {
  
    l_alloc_pat_dtls();

    l_open_pat_cur();


	while(fetch_alloc_pat_dtls())
	{
    
      /* EXEC SQL 
		   SELECT PEND_AMOUNT, AMOUNT 
		   INTO   :temp_pend_amt, :temp_amount
		   FROM   AR_PATIENT_DTLS
		   WHERE  DOC_TYPE_CODE = :d_pat_inv_doc_type_code 
		   AND    DOC_NUM       =     :d_pat_inv_doc_num
		   AND    BILL_DOC_TYPE_CODE =    :d_pat_bill_doc_type_code
		   AND    BILL_NUM           =  :d_pat_bill_num; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 6;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select PEND_AMOUNT ,AMOUNT into :b0,:b1  from AR_PATIEN\
T_DTLS where (((DOC_TYPE_CODE=:b2 and DOC_NUM=:b3) and BILL_DOC_TYPE_CODE=:b4)\
 and BILL_NUM=:b5)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )5;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&temp_pend_amt;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&temp_amount;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_pat_inv_doc_type_code;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_pat_inv_doc_num;
      sqlstm.sqhstl[3] = (unsigned int  )11;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_pat_bill_doc_type_code;
      sqlstm.sqhstl[4] = (unsigned int  )9;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_pat_bill_num;
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



	 
	 if ((temp_pend_amt > 0 ) && (temp_pend_amt >= d_pat_amount) && (temp_amount > 0)) 
            
	   {
	  
	      /* EXEC SQL  UPDATE AR_PATIENT_DTLS
	     		SET PEND_AMOUNT = PEND_AMOUNT + :d_pat_amount
			WHERE DOC_TYPE_CODE      = :d_pat_inv_doc_type_code 
      			AND   DOC_NUM            =     :d_pat_inv_doc_num
      			AND   BILL_DOC_TYPE_CODE =    :d_pat_bill_doc_type_code
      			AND   BILL_NUM           =  :d_pat_bill_num; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 6;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "update AR_PATIENT_DTLS  set PEND_AMOUNT=(PEND_AMOUNT+:\
b0) where (((DOC_TYPE_CODE=:b1 and DOC_NUM=:b2) and BILL_DOC_TYPE_CODE=:b3) an\
d BILL_NUM=:b4)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )44;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&d_pat_amount;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_pat_inv_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_pat_inv_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )11;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_pat_bill_doc_type_code;
       sqlstm.sqhstl[3] = (unsigned int  )9;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_pat_bill_num;
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



	  	if (OERROR)
        	err_mesg("UPDATE failed on table AR_PATIENT_DTLS",0,"");
	     }

     if ((temp_pend_amt < 0) && (temp_pend_amt <= d_pat_amount) && (temp_amount < 0))
	 {
	  
	      /* EXEC SQL  UPDATE AR_PATIENT_DTLS
	     		SET PEND_AMOUNT = PEND_AMOUNT + :d_pat_amount
			WHERE DOC_TYPE_CODE      = :d_pat_inv_doc_type_code 
      			AND   DOC_NUM            =     :d_pat_inv_doc_num
      			AND   BILL_DOC_TYPE_CODE =    :d_pat_bill_doc_type_code
      			AND   BILL_NUM           =  :d_pat_bill_num; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 6;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "update AR_PATIENT_DTLS  set PEND_AMOUNT=(PEND_AMOUNT+:\
b0) where (((DOC_TYPE_CODE=:b1 and DOC_NUM=:b2) and BILL_DOC_TYPE_CODE=:b3) an\
d BILL_NUM=:b4)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )79;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&d_pat_amount;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_pat_inv_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_pat_inv_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )11;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_pat_bill_doc_type_code;
       sqlstm.sqhstl[3] = (unsigned int  )9;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&d_pat_bill_num;
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



	  	if (OERROR)
        	err_mesg("UPDATE failed on table AR_PATIENT_DTLS",0,"");
     	}


     }

   }

/*************************************************************/
    if (l_hdr_ar_interface_cd.arr[0] == 'O')
        l_gl_insert_line();

    if (l_line_line_type_code.arr[0] == 'P')
    {
        l_ar_pend_doctor_fee_amt = 0;
        l_ar_pend_pending_amt    = 0;
        l_ar_pend_hosp_charges   = 0;
        doctor_fees_to_be_paid   = 0;

        l_episode_type.arr[0]  = '\0';
        l_patient_id.arr[0]    = '\0';
        l_episode_id.arr[0]    = '\0';
        l_visit_id.arr[0]      = '\0';

        l_episode_type.len     = 0;
        l_patient_id.len       = 0;
        l_episode_id.len       = 0;
        l_visit_id.len         = 0;

        /* EXEC SQL SELECT NVL(LAST_DOC_LINE_NUM,1) + 1, NVL(DOCTOR_FEE_AMT,0),
                        NVL(PENDING_AMT,0),
                        NVL(PENDING_AMT,0) - NVL(DOCTOR_FEE_AMT,0),
			EPISODE_TYPE,
			EPISODE_ID,
			VISIT_ID,
			PATIENT_ID
                   INTO :l_ar_pend_last_doc_line_num,
                        :l_ar_pend_doctor_fee_amt,
                        :l_ar_pend_pending_amt,
                        :l_ar_pend_hosp_charges,
                        :l_episode_type,
                        :l_episode_id,
                        :l_visit_id,
                        :l_patient_id
                   FROM AR_PENDING_DOC
                  WHERE CUST_CODE     = :l_hdr_cust_code
                    AND DOC_TYPE_CODE = :l_line_org_doc_type_code
                    AND DOC_NUM       = :l_line_org_doc_num; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 11;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select (NVL(LAST_DOC_LINE_NUM,1)+1) ,NVL(DOCTOR_FEE_A\
MT,0) ,NVL(PENDING_AMT,0) ,(NVL(PENDING_AMT,0)-NVL(DOCTOR_FEE_AMT,0)) ,EPISODE\
_TYPE ,EPISODE_ID ,VISIT_ID ,PATIENT_ID into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  \
from AR_PENDING_DOC where ((CUST_CODE=:b8 and DOC_TYPE_CODE=:b9) and DOC_NUM=:\
b10)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )114;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&l_ar_pend_last_doc_line_num;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&l_ar_pend_doctor_fee_amt;
        sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&l_ar_pend_pending_amt;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&l_ar_pend_hosp_charges;
        sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&l_episode_type;
        sqlstm.sqhstl[4] = (unsigned int  )4;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&l_episode_id;
        sqlstm.sqhstl[5] = (unsigned int  )11;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&l_visit_id;
        sqlstm.sqhstl[6] = (unsigned int  )7;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&l_patient_id;
        sqlstm.sqhstl[7] = (unsigned int  )13;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&l_hdr_cust_code;
        sqlstm.sqhstl[8] = (unsigned int  )11;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&l_line_org_doc_type_code;
        sqlstm.sqhstl[9] = (unsigned int  )9;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&l_line_org_doc_num;
        sqlstm.sqhstl[10] = (unsigned int  )11;
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
            err_mesg("SELECT failed on table AR_PENDING_DOC",0,"");

#ifdef DEBUG
sprintf(string_var,"pend doc fees <%f> pending amt <%f> pend hosp ch <%f>\n",
           l_ar_pend_doctor_fee_amt,l_ar_pend_pending_amt,
           l_ar_pend_hosp_charges);
           disp_message(INFO_MESG,string_var);
sprintf(string_var,"line amt loc is <%f>\n",atof(l_line_amt_local.arr));
disp_message(INFO_MESG,string_var);
#endif

        if (l_ar_pend_doctor_fee_amt > 0.00)
            if (doubcmp(l_ar_pend_pending_amt,atof(l_line_amt_local.arr)) == 0)
                 doctor_fees_to_be_paid  =  l_ar_pend_doctor_fee_amt;
            else if (atof(l_line_amt_local.arr) > l_ar_pend_hosp_charges) 
                  doctor_fees_to_be_paid  = atof(l_line_amt_local.arr) -
                     ((l_ar_pend_hosp_charges > 0)?l_ar_pend_hosp_charges:0);

#ifdef DEBUG
  sprintf(string_var,"doctor fees to be paid <%f>\n", doctor_fees_to_be_paid);
  disp_message(INFO_MESG,string_var);
#endif

         /* EXEC SQL UPDATE AR_PENDING_DOC
                     SET PENDING_AMT = NVL(PENDING_AMT,0) - :l_line_amt_local,
                         DOCTOR_FEE_AMT = NVL(DOCTOR_FEE_AMT,0) - 
                                 :doctor_fees_to_be_paid,
                         LAST_DOC_LINE_NUM = :l_ar_pend_last_doc_line_num,
                         LAST_UPD_DATE     = SYSDATE
                   WHERE CUST_CODE = :l_hdr_cust_code
                     AND DOC_TYPE_CODE = :l_line_org_doc_type_code
                     AND DOC_NUM       = :l_line_org_doc_num; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 11;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "update AR_PENDING_DOC  set PENDING_AMT=(NVL(PENDING_\
AMT,0)-:b0),DOCTOR_FEE_AMT=(NVL(DOCTOR_FEE_AMT,0)-:b1),LAST_DOC_LINE_NUM=:b2,L\
AST_UPD_DATE=SYSDATE where ((CUST_CODE=:b3 and DOC_TYPE_CODE=:b4) and DOC_NUM=\
:b5)";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )173;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&l_line_amt_local;
         sqlstm.sqhstl[0] = (unsigned int  )19;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&doctor_fees_to_be_paid;
         sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&l_ar_pend_last_doc_line_num;
         sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&l_hdr_cust_code;
         sqlstm.sqhstl[3] = (unsigned int  )11;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&l_line_org_doc_type_code;
         sqlstm.sqhstl[4] = (unsigned int  )9;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&l_line_org_doc_num;
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



         if (OERROR)
             err_mesg("UPDATE failed on table AR_PENDING_DOC",0,"");
         
        /* Commented since "Doctor Fee DF" module is no more supported
        if (doctor_fees_to_be_paid > 0.00)
              ins_df_cust_pmnt_int();
        */
    }
    
    if (l_line_line_type_code.arr[0] == 'A')
    {
    /* EXEC SQL INSERT INTO AR_PENDING_DOC
        (
         ACC_ENTITY_CODE,
         DOC_TYPE_CODE,
         DOC_NUM,
         LAST_DOC_LINE_NUM,
         CUST_CODE,
         DOC_DATE,
         NARRATION,
         GROSS_AMT,
         PAYABLE_AMT,
         DISCOUNT_AMT,
         PENDING_AMT,
         ALLOCATED_AMT,
         CURRENCY_CODE,
         EXCHG_RATE,
         CUST_REF,
         MAIN_ACC1_CODE,
         MAIN_ACC2_CODE,
         SUBLEDGER_GROUP_CODE,
         SUBLEDGER_LINE_CODE,
         DEPT_CODE,
         PRODUCT_GROUP_CODE,
         PRODUCT_LINE_CODE,
         POST_MONTH,
         POST_YEAR,
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
         TEL_NUM,
         CONTACT_NAME,
         CONTACT_NAME_TITLE,
         TRN_TYPE_CODE,
         LAST_UPD_DATE,
		 ADDED_BY_ID,
		 ADDED_DATE,
		 MODIFIED_BY_ID,
		 MODIFIED_DATE
       )
    VALUES
       (
         :l_hdr_acc_entity_code,
         :l_hdr_doc_type_code,
         :l_hdr_doc_num,
         1,
         :l_hdr_cust_code,
         to_date(:l_hdr_doc_date,'DD/MM/YYYY'),
         :l_line_narration,
         :l_line_amt_local * -1,
         :l_line_amt_local * -1,
         0,
         :l_line_amt_local * -1,
         0,
         :l_hdr_currency_code,
         :l_hdr_exchg_rate,
         :l_hdr_doc_ref,
         :l_line_main_acc1_code,
         :l_line_main_acc2_code,
         :l_line_subledger_group_code,
         :l_line_subledger_line_code,
         :l_line_dept_code,
         :l_line_product_group_code,
         :l_line_product_line_code,
         :l_hdr_post_month,
         :l_hdr_post_year,
         :l_hdr_misc_cust_long_name,
         :l_hdr_misc_cust_short_name,
         :l_hdr_misc_cust_add1_desc,
         :l_hdr_misc_cust_add2_desc,
         :l_hdr_misc_cust_add3_desc,
         :l_hdr_misc_cust_zip_desc,
         :l_hdr_misc_long_name_ch,
         :l_hdr_misc_short_name_ch,
         :l_hdr_misc_add1_desc_ch,
         :l_hdr_misc_add2_desc_ch,
         :l_hdr_misc_add3_desc_ch,
         :l_hdr_misc_zip_desc_ch,
         :l_hdr_tel_num,
         :l_hdr_contact_name,
         :l_hdr_contact_name_title,
         '5',
          SYSDATE,
		  USER,
		  SYSDATE,
		  USER,
		  SYSDATE
         ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 36;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into AR_PENDING_DOC (ACC_ENTITY_CODE,DOC_TYPE_CODE\
,DOC_NUM,LAST_DOC_LINE_NUM,CUST_CODE,DOC_DATE,NARRATION,GROSS_AMT,PAYABLE_AMT,\
DISCOUNT_AMT,PENDING_AMT,ALLOCATED_AMT,CURRENCY_CODE,EXCHG_RATE,CUST_REF,MAIN_\
ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PR\
ODUCT_GROUP_CODE,PRODUCT_LINE_CODE,POST_MONTH,POST_YEAR,MISC_CUST_LONG_NAME,MI\
SC_CUST_SHORT_NAME,MISC_CUST_ADD1_DESC,MISC_CUST_ADD2_DESC,MISC_CUST_ADD3_DESC\
,MISC_CUST_ZIP_DESC,MISC_CUST_LONG_NAME_CHINESE,MISC_CUST_SHORT_NAME_CHINESE,M\
ISC_CUST_ADD1_DESC_CHINESE,MISC_CUST_ADD2_DESC_CHINESE,MISC_CUST_ADD3_DESC_CHI\
NESE,MISC_CUST_ZIP_DESC_CHINESE,TEL_NUM,CONTACT_NAME,CONTACT_NAME_TITLE,TRN_TY\
PE_CODE,LAST_UPD_DATE,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE) val\
ues (:b0,:b1,:b2,1,:b3,to_date(:b4,'DD/MM/YYYY'),:b5,(:b6* (-1)),(:b6* (-1)),0\
,(:b6* (-1)),0,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20,:b21\
,:b22,:b23,:b24,:b25,:b26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,:b34,:b35,'5',SYS\
DATE,USER,SYSDATE,USER,SYSDATE)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )212;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_hdr_acc_entity_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_hdr_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_hdr_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_hdr_cust_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_hdr_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )17;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&l_line_narration;
    sqlstm.sqhstl[5] = (unsigned int  )53;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&l_line_amt_local;
    sqlstm.sqhstl[6] = (unsigned int  )19;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&l_line_amt_local;
    sqlstm.sqhstl[7] = (unsigned int  )19;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&l_line_amt_local;
    sqlstm.sqhstl[8] = (unsigned int  )19;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&l_hdr_currency_code;
    sqlstm.sqhstl[9] = (unsigned int  )9;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&l_hdr_exchg_rate;
    sqlstm.sqhstl[10] = (unsigned int  )17;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&l_hdr_doc_ref;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&l_line_main_acc1_code;
    sqlstm.sqhstl[12] = (unsigned int  )9;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&l_line_main_acc2_code;
    sqlstm.sqhstl[13] = (unsigned int  )7;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&l_line_subledger_group_code;
    sqlstm.sqhstl[14] = (unsigned int  )6;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&l_line_subledger_line_code;
    sqlstm.sqhstl[15] = (unsigned int  )11;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&l_line_dept_code;
    sqlstm.sqhstl[16] = (unsigned int  )9;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&l_line_product_group_code;
    sqlstm.sqhstl[17] = (unsigned int  )6;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&l_line_product_line_code;
    sqlstm.sqhstl[18] = (unsigned int  )7;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&l_hdr_post_month;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&l_hdr_post_year;
    sqlstm.sqhstl[20] = (unsigned int  )7;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&l_hdr_misc_cust_long_name;
    sqlstm.sqhstl[21] = (unsigned int  )43;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&l_hdr_misc_cust_short_name;
    sqlstm.sqhstl[22] = (unsigned int  )18;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&l_hdr_misc_cust_add1_desc;
    sqlstm.sqhstl[23] = (unsigned int  )33;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&l_hdr_misc_cust_add2_desc;
    sqlstm.sqhstl[24] = (unsigned int  )33;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&l_hdr_misc_cust_add3_desc;
    sqlstm.sqhstl[25] = (unsigned int  )33;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&l_hdr_misc_cust_zip_desc;
    sqlstm.sqhstl[26] = (unsigned int  )33;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&l_hdr_misc_long_name_ch;
    sqlstm.sqhstl[27] = (unsigned int  )43;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&l_hdr_misc_short_name_ch;
    sqlstm.sqhstl[28] = (unsigned int  )18;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&l_hdr_misc_add1_desc_ch;
    sqlstm.sqhstl[29] = (unsigned int  )33;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&l_hdr_misc_add2_desc_ch;
    sqlstm.sqhstl[30] = (unsigned int  )33;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&l_hdr_misc_add3_desc_ch;
    sqlstm.sqhstl[31] = (unsigned int  )33;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&l_hdr_misc_zip_desc_ch;
    sqlstm.sqhstl[32] = (unsigned int  )33;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&l_hdr_tel_num;
    sqlstm.sqhstl[33] = (unsigned int  )33;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&l_hdr_contact_name;
    sqlstm.sqhstl[34] = (unsigned int  )43;
    sqlstm.sqhsts[34] = (         int  )0;
    sqlstm.sqindv[34] = (         void  *)0;
    sqlstm.sqinds[34] = (         int  )0;
    sqlstm.sqharm[34] = (unsigned int  )0;
    sqlstm.sqadto[34] = (unsigned short )0;
    sqlstm.sqtdso[34] = (unsigned short )0;
    sqlstm.sqhstv[35] = (         void  *)&l_hdr_contact_name_title;
    sqlstm.sqhstl[35] = (unsigned int  )43;
    sqlstm.sqhsts[35] = (         int  )0;
    sqlstm.sqindv[35] = (         void  *)0;
    sqlstm.sqinds[35] = (         int  )0;
    sqlstm.sqharm[35] = (unsigned int  )0;
    sqlstm.sqadto[35] = (unsigned short )0;
    sqlstm.sqtdso[35] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
         err_mesg("INSERT failed on table AR_PENDING_DOC",0,"");
   } 

   if (l_line_line_type_code.arr[0] != 'D')
   {
	    l_line_amt_total += atof(l_line_amt_local.arr);
			
      /* EXEC SQL INSERT INTO AR_CUST_TRN
           (
             ACC_ENTITY_CODE,
             CUST_CODE,
             ORG_DOC_TYPE_CODE,
             ORG_DOC_NUM,
             LINE_NUM,
             DOC_TYPE_CODE,
             DOC_NUM,
             DOC_DATE,
             NARRATION,
             AMOUNT,
             CUST_REF,
             TRN_TYPE_CODE,
			 POST_MONTH,
			 POST_YEAR,
			 BANK_DESC,
			 CHEQUE_NUM,
			 CHEQUE_DATE    
          )
       VALUES
          (
             :l_hdr_acc_entity_code,
             :l_hdr_cust_code,
             :l_line_org_doc_type_code,
             :l_line_org_doc_num,
             :l_ar_pend_last_doc_line_num,
             :l_hdr_doc_type_code,
             :l_hdr_doc_num,
             to_date(:l_hdr_doc_date,'DD/MM/YYYY'),
             :l_line_narration,
             :l_line_amt_local * -1,
             :l_hdr_doc_ref,
            '5',
			:l_hdr_post_month,
            :l_hdr_post_year,
			:l_bank_desc,
			:l_hdr_ar_cheque_num, 
			:l_hdr_ar_cheque_date 
           ); */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 36;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "insert into AR_CUST_TRN (ACC_ENTITY_CODE,CUST_CODE,ORG_\
DOC_TYPE_CODE,ORG_DOC_NUM,LINE_NUM,DOC_TYPE_CODE,DOC_NUM,DOC_DATE,NARRATION,AM\
OUNT,CUST_REF,TRN_TYPE_CODE,POST_MONTH,POST_YEAR,BANK_DESC,CHEQUE_NUM,CHEQUE_D\
ATE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,to_date(:b7,'DD/MM/YYYY'),:b8,(:b9* (\
-1)),:b10,'5',:b11,:b12,:b13,:b14,:b15)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )371;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_hdr_acc_entity_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_hdr_cust_code;
      sqlstm.sqhstl[1] = (unsigned int  )11;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_line_org_doc_type_code;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_line_org_doc_num;
      sqlstm.sqhstl[3] = (unsigned int  )11;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_ar_pend_last_doc_line_num;
      sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_hdr_doc_type_code;
      sqlstm.sqhstl[5] = (unsigned int  )9;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_hdr_doc_num;
      sqlstm.sqhstl[6] = (unsigned int  )11;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_hdr_doc_date;
      sqlstm.sqhstl[7] = (unsigned int  )17;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&l_line_narration;
      sqlstm.sqhstl[8] = (unsigned int  )53;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&l_line_amt_local;
      sqlstm.sqhstl[9] = (unsigned int  )19;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&l_hdr_doc_ref;
      sqlstm.sqhstl[10] = (unsigned int  )13;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_hdr_post_month;
      sqlstm.sqhstl[11] = (unsigned int  )5;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_hdr_post_year;
      sqlstm.sqhstl[12] = (unsigned int  )7;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_bank_desc;
      sqlstm.sqhstl[13] = (unsigned int  )33;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&l_hdr_ar_cheque_num;
      sqlstm.sqhstl[14] = (unsigned int  )13;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&l_hdr_ar_cheque_date;
      sqlstm.sqhstl[15] = (unsigned int  )14;
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



         if (OERROR)
               err_mesg("INSERT failed on table AR_CUST_TRN",0,"");
     }





 }  /**** End of Fetch line loop ****/

   if (atol(passed_last_rec_doc_dt) > atol(passed_doc_date_chking))
   {
      /* EXEC SQL UPDATE AR_CUSTOMER
                  SET OUTSTANDING_BALANCE_AMT = 
                        NVL(OUTSTANDING_BALANCE_AMT,0) -  :l_line_amt_total
                WHERE CUST_CODE = :l_hdr_cust_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 36;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update AR_CUSTOMER  set OUTSTANDING_BALANCE_AMT=(NVL(OU\
TSTANDING_BALANCE_AMT,0)-:b0) where CUST_CODE=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )450;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_line_amt_total;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_hdr_cust_code;
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


    }
    else
    {
      /* EXEC SQL UPDATE AR_CUSTOMER
                  SET OUTSTANDING_BALANCE_AMT = 
                        NVL(OUTSTANDING_BALANCE_AMT,0) -  :l_line_amt_total,
                      LAST_REC_DOC_TYPE  = :l_hdr_doc_type_code,
                      LAST_REC_DOC_NUM   = :l_hdr_doc_num,
                      LAST_REC_DOC_DATE  = to_date(:l_hdr_doc_date,'DD/MM/YYYY')
                WHERE CUST_CODE = :l_hdr_cust_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 36;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update AR_CUSTOMER  set OUTSTANDING_BALANCE_AMT=(NVL(OU\
TSTANDING_BALANCE_AMT,0)-:b0),LAST_REC_DOC_TYPE=:b1,LAST_REC_DOC_NUM=:b2,LAST_\
REC_DOC_DATE=to_date(:b3,'DD/MM/YYYY') where CUST_CODE=:b4";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )473;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_line_amt_total;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_hdr_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_hdr_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_hdr_doc_date;
      sqlstm.sqhstl[3] = (unsigned int  )17;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_hdr_cust_code;
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



    }
		
    if (OERROR)
         err_mesg("UPDATE failed on table AR_CUSTOMER",0,"");


 
  /* EXEC SQL UPDATE AR_REC_HDR
              SET POSTED_FLAG               = 'Y',
                  INTERFACE_FLAG            = 
                        DECODE(:l_hdr_ar_interface_cd,'O','Y','N'),
                  POSTED_DATE               = SYSDATE,
                  POSTED_BY_ID              = USER
            WHERE ROWID = :l_hdr_rowid; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 36;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update AR_REC_HDR  set POSTED_FLAG='Y',INTERFACE_FLAG=DECOD\
E(:b0,'O','Y','N'),POSTED_DATE=SYSDATE,POSTED_BY_ID=USER where ROWID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )508;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_hdr_ar_interface_cd;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_hdr_rowid;
  sqlstm.sqhstl[1] = (unsigned int  )33;
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
        err_mesg("UPDATE failed on table AR_INV_HDR - AR Posting",0,"");

#ifdef DEBUG
   disp_message(INFO_MESG,"After ar_inv_posting...\n");
#endif

}


l_alloc_pat_dtls()  
{
         
   /* EXEC SQL DECLARE l_alloc_pat_cur CURSOR FOR		 
		  SELECT DOC_TYPE_CODE,
                      DOC_NUM,
                      INV_DOC_TYPE_CODE,
					  INV_DOC_NUM       ,     
                      BILL_DOC_TYPE_CODE,
                      BILL_NUM,
                      NVL(AMOUNT,0),
					  ABS(nvl(AMOUNT,0)),
                      ROWID
			  FROM AR_PATIENT_ALLOC_DTLS
              WHERE DOC_TYPE_CODE = :l_hdr_doc_type_code
                AND DOC_NUM       = :l_hdr_doc_num
               ORDER BY DOC_TYPE_CODE , DOC_NUM; */ 



}

l_open_pat_cur()
{
    /* EXEC SQL OPEN l_alloc_pat_cur; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 36;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )531;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_hdr_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_hdr_doc_num;
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
         err_mesg("OPEN failed on cursor l_alloc_pat_cur",0,"");
}

fetch_alloc_pat_dtls()
{
  d_pat_doc_type_code.arr[0]       = '\0';
  d_pat_doc_num.arr[0]             = '\0';
  d_pat_bill_doc_type_code.arr[0]  = '\0';
  d_pat_bill_num.arr[0]            = '\0';
  d_pat_inv_doc_type_code.arr[0] = '\0';
  d_pat_inv_doc_num.arr[0] = '\0';
  d_pat_rowid.arr[0]               = '\0';

  d_pat_doc_type_code.len          = 0;
  d_pat_doc_num.len                = 0;
  d_pat_bill_doc_type_code.len     = 0;
  d_pat_bill_num.len               = 0;
  d_pat_inv_doc_type_code.len = 0;
  d_pat_inv_doc_num.len = 0;
  d_pat_rowid.len                  = 0;

  d_pat_amount      = 0;
  d_pat_abs_amount  =0;

         /* EXEC SQL FETCH l_alloc_pat_cur
                INTO 
  				  :d_pat_doc_type_code,
                  :d_pat_doc_num,
                  :d_pat_inv_doc_type_code,
                  :d_pat_inv_doc_num,
                  :d_pat_bill_doc_type_code,
                  :d_pat_bill_num,
                  :d_pat_amount,
                  :d_pat_abs_amount,
                  :d_pat_rowid; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 36;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )554;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&d_pat_doc_type_code;
         sqlstm.sqhstl[0] = (unsigned int  )9;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&d_pat_doc_num;
         sqlstm.sqhstl[1] = (unsigned int  )11;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&d_pat_inv_doc_type_code;
         sqlstm.sqhstl[2] = (unsigned int  )9;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&d_pat_inv_doc_num;
         sqlstm.sqhstl[3] = (unsigned int  )11;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&d_pat_bill_doc_type_code;
         sqlstm.sqhstl[4] = (unsigned int  )9;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&d_pat_bill_num;
         sqlstm.sqhstl[5] = (unsigned int  )11;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&d_pat_amount;
         sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&d_pat_abs_amount;
         sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&d_pat_rowid;
         sqlstm.sqhstl[8] = (unsigned int  )33;
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
            err_mesg("FETCH failed on cursor l_alloc_pat_cur - rc_post",0,"");

                  
    d_pat_doc_type_code.arr[d_pat_doc_type_code.len]           = '\0';
    d_pat_doc_num.arr[d_pat_doc_num.len]                       = '\0';
    d_pat_bill_doc_type_code.arr[d_pat_bill_doc_type_code.len] = '\0';
    d_pat_bill_num.arr[d_pat_bill_num.len]                     = '\0';
    d_pat_rowid.arr[d_pat_rowid.len]                           = '\0';
    d_pat_inv_doc_type_code.arr[d_pat_inv_doc_type_code.len] = '\0';
    d_pat_inv_doc_num.arr[d_pat_inv_doc_num.len]= '\0';

	 if (LAST_ROW)
      return(0);
     else
      return(1);

}



l_decl_line()
{

   /* EXEC SQL DECLARE L_CUR_REC_LINE CURSOR FOR
             SELECT AMT_LOCAL,
                    LINE_NUM,
                    MAIN_ACC1_CODE,
                    MAIN_ACC2_CODE,
                    DEPT_CODE,
                    PRODUCT_GROUP_CODE,
                    PRODUCT_LINE_CODE,
                    SUBLEDGER_GROUP_CODE,
                    SUBLEDGER_LINE_CODE,
                    ORG_DOC_TYPE_CODE,
                    ORG_DOC_NUM,
                    LINE_TYPE_CODE,
                    NARRATION,
					CONSOLIDATED_INV_YN
               FROM AR_REC_LINE
              WHERE DOC_TYPE_CODE = :l_hdr_doc_type_code
                AND DOC_NUM       = :l_hdr_doc_num; */ 

}

l_rc_open_rec_line()
{
    /* EXEC SQL OPEN L_CUR_REC_LINE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 36;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )605;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_hdr_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_hdr_doc_num;
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
         err_mesg("OPEN failed on cursor L_CUR_REC_LINE",0,"");
}

l_fetch_rc_line()
{
      l_line_main_acc1_code.arr[0]       = '\0';
      l_line_main_acc2_code.arr[0]       = '\0';
      l_line_dept_code.arr[0]            = '\0';
      l_line_product_group_code.arr[0]   = '\0';
      l_line_product_line_code.arr[0]    = '\0';
      l_line_subledger_group_code.arr[0] = '\0';
      l_line_subledger_line_code.arr[0]  = '\0';
      l_line_amt_local.arr[0]            = '\0';
      l_line_line_num.arr[0]             = '\0';

      l_line_org_doc_type_code.arr[0]    = '\0';
      l_line_org_doc_num.arr[0]          = '\0';
      l_line_line_type_code.arr[0]       = '\0';
      l_line_narration.arr[0]            = '\0';
	  l_consolidated_yn.arr[0]           = '\0';

      l_line_main_acc1_code.len          = 0;
      l_line_main_acc2_code.len          = 0;
      l_line_dept_code.len               = 0;
      l_line_product_group_code.len      = 0;
      l_line_product_line_code.len       = 0;
      l_line_subledger_group_code.len    = 0;
      l_line_subledger_line_code.len     = 0;
      l_line_amt_local.len               = 0;
      l_line_line_num.len                = 0;

      l_line_org_doc_type_code.len       = 0;
      l_line_org_doc_num.len             = 0;
      l_line_line_type_code.len          = 0;
      l_line_narration.len               = 0;
	  l_consolidated_yn.len              = 0;


#ifdef DEBUG
      disp_message(INFO_MESG,"Before fetching rec from ar_inv_line\n");
#endif

      /* EXEC SQL FETCH L_CUR_REC_LINE
                INTO :l_line_amt_local,
                     :l_line_line_num,
                     :l_line_main_acc1_code,
                     :l_line_main_acc2_code,
                     :l_line_dept_code,
                     :l_line_product_group_code,
                     :l_line_product_line_code,
                     :l_line_subledger_group_code,
                     :l_line_subledger_line_code,
                     :l_line_org_doc_type_code,
                     :l_line_org_doc_num,
                     :l_line_line_type_code,
                     :l_line_narration,
					 :l_consolidated_yn; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 36;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )628;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_line_amt_local;
      sqlstm.sqhstl[0] = (unsigned int  )19;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_line_line_num;
      sqlstm.sqhstl[1] = (unsigned int  )7;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_line_main_acc1_code;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_line_main_acc2_code;
      sqlstm.sqhstl[3] = (unsigned int  )7;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_line_dept_code;
      sqlstm.sqhstl[4] = (unsigned int  )9;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_line_product_group_code;
      sqlstm.sqhstl[5] = (unsigned int  )6;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_line_product_line_code;
      sqlstm.sqhstl[6] = (unsigned int  )7;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_line_subledger_group_code;
      sqlstm.sqhstl[7] = (unsigned int  )6;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&l_line_subledger_line_code;
      sqlstm.sqhstl[8] = (unsigned int  )11;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&l_line_org_doc_type_code;
      sqlstm.sqhstl[9] = (unsigned int  )9;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&l_line_org_doc_num;
      sqlstm.sqhstl[10] = (unsigned int  )11;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_line_line_type_code;
      sqlstm.sqhstl[11] = (unsigned int  )4;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_line_narration;
      sqlstm.sqhstl[12] = (unsigned int  )53;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_consolidated_yn;
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



      if (OERROR)
         err_mesg("FETCH failed on cursor CUR_REC_LINE - rc_post",0,"");

l_line_line_num.arr[l_line_line_num.len] = '\0';
l_line_main_acc1_code.arr[l_line_main_acc1_code.len]             = '\0';
l_line_main_acc2_code.arr[l_line_main_acc2_code.len]             = '\0';
l_line_dept_code.arr[l_line_dept_code.len]                       = '\0';
l_line_product_group_code.arr[l_line_product_group_code.len]     = '\0';
l_line_product_line_code.arr[l_line_product_line_code.len]       = '\0';
l_line_subledger_group_code.arr[l_line_subledger_group_code.len] = '\0';
l_line_subledger_line_code.arr[l_line_subledger_line_code.len]   = '\0';
l_line_amt_local.arr[l_line_amt_local.len]                       = '\0';

l_line_org_doc_type_code.arr[l_line_org_doc_type_code.len]       = '\0';
l_line_org_doc_num.arr[l_line_org_doc_num.len]                   = '\0';
l_line_line_type_code.arr[l_line_line_type_code.len]             = '\0';
l_line_narration.arr[l_line_narration.len]                       = '\0';
l_consolidated_yn.arr[l_consolidated_yn.len] = '\0';

#ifdef DEBUG
      sprintf(string_var,"After fetching rec count is <%d> \n",sqlca.sqlerrd[2]);
      disp_message(INFO_MESG,string_var);
#endif

  if (LAST_ROW)
      return(0);
  else
      return(1);

}

l_gl_doc_insert()
{
#ifdef DEBUG
   sprintf(string_var,"Inside gl_doc_insert...\n");
   disp_message(INFO_MESG,string_var);
#endif 

   /* EXEC SQL INSERT INTO GL_TXN_DOC_HDR
          (
           ACC_ENTITY_CODE,
           DOC_TYPE_CODE,
           BATCH_NUM,
           DOC_NUM,
           DOC_DATE,
           DOC_REF,
           NARRATION,
           POST_MONTH,
           POST_YEAR,
           CTRL_AMT,
           DOC_NATURE,
           UNIT_TYPE_CODE,
           CURRENCY_CODE,
           EXCHG_RATE,
           ERROR_FLAG,
           ADDED_BY_ID,
           MODIFIED_BY_ID,
           ADDED_DATE,
           MODIFIED_DATE,
           MAX_LINE_NUM,
           MODULE_ID,
           TXN_TYPE_DESC,
           STD_JV_REF,
           PRINT_FLAG
           )
      VALUES
         (
           :l_hdr_acc_entity_code,
           :l_hdr_doc_type_code,
           0,
           :l_hdr_doc_num,
           to_date(:l_hdr_doc_date,'DD/MM/YYYY'),
           SUBSTR(:l_hdr_doc_ref,1,10),
           :l_hdr_narration,
           :l_hdr_post_month,
           :l_hdr_post_year,
           0,
           NULL,
           NULL,
           NULL,
           NULL,
           NULL,
           USER,
           USER,
           SYSDATE,
           SYSDATE,
           :l_hdr_last_line_num,
           'AR',
           NULL,
           NULL,
           NULL
         ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 36;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into GL_TXN_DOC_HDR (ACC_ENTITY_CODE,DOC_TYPE_CODE,\
BATCH_NUM,DOC_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT,DOC\
_NATURE,UNIT_TYPE_CODE,CURRENCY_CODE,EXCHG_RATE,ERROR_FLAG,ADDED_BY_ID,MODIFIE\
D_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID,TXN_TYPE_DESC,STD_JV_R\
EF,PRINT_FLAG) values (:b0,:b1,0,:b2,to_date(:b3,'DD/MM/YYYY'),SUBSTR(:b4,1,10\
),:b5,:b6,:b7,0,null ,null ,null ,null ,null ,USER,USER,SYSDATE,SYSDATE,:b8,'A\
R',null ,null ,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )699;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_hdr_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_hdr_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_hdr_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )17;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_hdr_doc_ref;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_hdr_narration;
   sqlstm.sqhstl[5] = (unsigned int  )53;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_hdr_post_month;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_hdr_post_year;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_hdr_last_line_num;
   sqlstm.sqhstl[8] = (unsigned int  )7;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_HDR",0,"");
            
  /* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
         (
           ACC_ENTITY_CODE,
           BATCH_NUM,
           DOC_TYPE_CODE,
           DOC_NUM,
           MAIN_ACC1_CODE,
           MAIN_ACC2_CODE,
           SUBLEDGER_GROUP_CODE,
           SUBLEDGER_LINE_CODE,
           DEPT_CODE,
           PRODUCT_GROUP_CODE,
           PRODUCT_LINE_CODE,
           FOREIGN_AMT,
           LOCAL_AMT,
           NARRATION,
           LINE_NUM,
           INTER_ACC_ENTITY,
		   CUST_SUPP_CODE
         )
      VALUES
         (
           :l_hdr_acc_entity_code,
           0, 
           :l_hdr_doc_type_code,
           :l_hdr_doc_num,
           :l_hdr_main_acc1_code,
           :l_hdr_main_acc2_code,
           :l_hdr_subledger_group_code,
           :l_hdr_subledger_line_code,
           :l_hdr_dept_code,
           :l_hdr_product_group_code,
           :l_hdr_product_line_code,
           NULL,
           :l_hdr_amt_local,
           :l_hdr_narration,
           '0',
           NULL,
		   :l_hdr_cust_code 
         ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 36;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,null ,:b10,:b11,'0',null ,:b12)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )750;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_hdr_acc_entity_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_hdr_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_hdr_doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_hdr_main_acc1_code;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_hdr_main_acc2_code;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_hdr_subledger_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_hdr_subledger_line_code;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_hdr_dept_code;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&l_hdr_product_group_code;
  sqlstm.sqhstl[8] = (unsigned int  )6;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&l_hdr_product_line_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&l_hdr_amt_local;
  sqlstm.sqhstl[10] = (unsigned int  )19;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&l_hdr_narration;
  sqlstm.sqhstl[11] = (unsigned int  )53;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&l_hdr_cust_code;
  sqlstm.sqhstl[12] = (unsigned int  )11;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_LINE",0,"");    

#ifdef DEBUG
   disp_message(INFO_MESG,"After gl_doc_insert...\n");
#endif 
}

l_gl_insert_line()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside gl_insert_line...\n");
#endif 

  /* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
         (
           ACC_ENTITY_CODE,
           BATCH_NUM,
           DOC_TYPE_CODE,
           DOC_NUM,
           MAIN_ACC1_CODE,
           MAIN_ACC2_CODE,
           SUBLEDGER_GROUP_CODE,
           SUBLEDGER_LINE_CODE,
           DEPT_CODE,
           PRODUCT_GROUP_CODE,
           PRODUCT_LINE_CODE,
           FOREIGN_AMT,
           LOCAL_AMT,
           NARRATION,
           LINE_NUM,
           INTER_ACC_ENTITY,
		   CUST_SUPP_CODE
         )
     VALUES  
         (
           :l_hdr_acc_entity_code,
           0,
           :l_hdr_doc_type_code,
           :l_hdr_doc_num,
           :l_line_main_acc1_code,
           :l_line_main_acc2_code,
           :l_line_subledger_group_code,
           :l_line_subledger_line_code,
           :l_line_dept_code,
           :l_line_product_group_code,
           :l_line_product_line_code,
           null,
           :l_line_amt_local * -1,
           :l_line_narration,
           :l_line_line_num,
           null,
		   :l_hdr_cust_code 
         ); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 36;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_\
TYPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER\
_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,FOREIGN_AMT,LOCAL_AM\
T,NARRATION,LINE_NUM,INTER_ACC_ENTITY,CUST_SUPP_CODE) values (:b0,0,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,null ,(:b10* (-1)),:b11,:b12,null ,:b13)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )817;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_hdr_acc_entity_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_hdr_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_hdr_doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_line_main_acc1_code;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_line_main_acc2_code;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_line_subledger_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_line_subledger_line_code;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_line_dept_code;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&l_line_product_group_code;
  sqlstm.sqhstl[8] = (unsigned int  )6;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&l_line_product_line_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&l_line_amt_local;
  sqlstm.sqhstl[10] = (unsigned int  )19;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&l_line_narration;
  sqlstm.sqhstl[11] = (unsigned int  )53;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&l_line_line_num;
  sqlstm.sqhstl[12] = (unsigned int  )7;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&l_hdr_cust_code;
  sqlstm.sqhstl[13] = (unsigned int  )11;
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
         err_mesg("INSERT failed on table GL_TXN_DOC_LINE - for line",0,"");    




#ifdef DEBUG
   disp_message(INFO_MESG,"After gl_insert_line...\n");
#endif 
}
