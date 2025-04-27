
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
           char  filnam[29];
};
static const struct sqlcxp sqlfpn =
{
    28,
    "T:\\BL\\CRF-0120_2\\Blrprrec.pc"
};


static unsigned long sqlctx = 802283325;


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

 static const char *sq0002 = 
"select a.DOC_TYPE_CODE ,a.DOC_NUMBER ,a.DOC_SRNO ,to_char(a.DOC_DATE,'dd/mm/\
yyyy') ,a.EPISODE_TYPE ,a.PATIENT_ID ,LTRIM(TO_CHAR(a.EPISODE_ID,'00000009')) \
,a.VISIT_ID ,a.BILL_DOC_TYPE_CODE ,LTRIM(TO_CHAR(a.BILL_DOC_NUMBER,'00000009')\
) ,a.CUSTOMER_CODE ,TO_CHAR(a.DOC_AMT) DOC_AMT ,a.SLMT_TYPE_CODE ,a.SLMT_DOC_R\
EF_DESC ,TRUNC(a.SLMT_DOC_REF_DATE) ,a.SLMT_DOC_REMARKS ,a.NARRATION ,a.PAYER_\
NAME ,A.rowid  ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') ,a.CASH_COUNTER_CODE ,a.\
SHIFT_ID ,(a.DOC_TYPE_CODE||LTRIM(TO_CHAR(a.DOC_NUMBER,'00000009'))) ,a.RECPT_\
REFUND_IND ,a.RECPT_NATURE_CODE ,a.HCARE_APPL_NUM ,a.ADDED_BY_ID  from BL_RECE\
IPT_REFUND_HDRDTL_VW a where (a.DOC_TYPE_CODE=:b0 and a.DOC_NUMBER=:b1) for up\
date of PRINT_FLAG nowait ";

 static const char *sq0016 = 
"select a.BLNG_SERV_CODE ,a.DEPOSIT_AMT ,b.long_desc  from BL_RCPT_RFND_SERVI\
CE_DTL a ,BL_BLNG_SERV B where ((a.DOC_TYPE_CODE=:b0 and a.DOC_NUMBER=To_NUMBE\
R(:b1)) and a.blng_serv_code=b.blng_serv_code) order by 1            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,94,0,4,234,0,0,3,1,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,
32,0,0,3,0,0,32,341,0,0,0,0,0,1,0,
47,0,0,2,726,0,9,352,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
70,0,0,4,108,0,4,369,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
97,0,0,5,116,0,4,393,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
128,0,0,6,106,0,4,417,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
159,0,0,7,210,0,4,434,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
186,0,0,2,0,0,15,465,0,0,0,0,0,1,0,
201,0,0,8,0,0,30,487,0,0,0,0,0,1,0,
216,0,0,9,0,0,27,494,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
247,0,0,2,0,0,13,524,0,0,27,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,
370,0,0,10,0,0,32,557,0,0,0,0,0,1,0,
385,0,0,11,96,0,4,613,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
412,0,0,12,229,0,4,645,0,0,6,5,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
451,0,0,13,191,0,4,666,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
474,0,0,14,266,0,4,800,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
513,0,0,15,164,0,4,852,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
540,0,0,16,223,0,9,910,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
563,0,0,16,0,0,15,929,0,0,0,0,0,1,0,
578,0,0,16,0,0,13,939,0,0,3,0,0,1,0,2,9,0,0,2,4,0,0,2,9,0,0,
605,0,0,17,96,0,4,992,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
632,0,0,18,229,0,4,1018,0,0,6,5,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
671,0,0,19,195,0,4,1129,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
706,0,0,20,164,0,4,1163,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
733,0,0,21,93,0,5,1202,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                               */
/************************************************************************/
/* PROGRAM NAME          : BLRPRREC.PC                                  */
/* AUTHOR                : NITIN KUMAR                                  */
/* DATE WRITTEN          : 18-APR-1993                                  */
/* MODIFIED BY           : Aldrin Alberto for AMH                       */                                                                     
/*                                                                      */
/* CALLED FROM           :                                              */ 
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.     TABLENAMES             INPUT/OUTPUT                */
/*                                                                      */
/*         1.        BL_RECEIPT_REFUND_DTL     Query/Update             */
/*         2.        SY_PROG_CONTROL           Update/Lookup            */
/*         3.        SY_PROG_MESG                Insert                 */
/*                                                                      */
/*  PARAMETERS           :             -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/*                                                                      */
/************************************************************************/
/* UPGRADED TO 4.1   */
    
	                                         
/* All control-chars have been commented as they do not make sense on a DMP
   All reference to HK$ change to Dhs
   -  For American Hospital Implementation. -- G. Viswanath/31/7/1996
*/     
  
#include <stdio.h>
#include <string.h>
#include <math.h>
//#include <sqlca.h>
//#include <sqlda.h>
#include <bl.h>

/*
#define OERROR (sqlca.sqlcode < 0)
*/

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define MAX_LINES 80

#define INIT_MESG       "Printing Receipt / Refund  in progress"
#define ONLINE_PRINTING 1
/*
#define DEBUG 1
*/
      
#define SKIP_1 3
#define SKIP_2 64
#define SKIP_3 3
#define SKIP_4 10
#define SKIP_4_1 2
#define SKIP_5 22
#define SKIP_6 15
#define SKIP_6_1 15
#define SKIP_7 3
#define SKIP_8 13
#define SKIP_9 10

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
           date_time    [20],
           user_id      [20],
           nd_pgm_date  [35],
	   nd_facility_name[31],
	   nd_service_desc[41],
	   nd_recpt_nature_code[3],
	   nd_blng_grp   [3],
	   nd_blng_desc  [16],
	   nd_hcard_status[12],	
	   nd_service_code[11],
	   nd_hcard_num[21],
	   
	   nd_hcard_expiry_date[15],
	   nd_cash_counter_desc [16]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[41]; } nd_service_desc;

struct { unsigned short len; unsigned char arr[3]; } nd_recpt_nature_code;

struct { unsigned short len; unsigned char arr[3]; } nd_blng_grp;

struct { unsigned short len; unsigned char arr[16]; } nd_blng_desc;

struct { unsigned short len; unsigned char arr[12]; } nd_hcard_status;

struct { unsigned short len; unsigned char arr[11]; } nd_service_code;

struct { unsigned short len; unsigned char arr[21]; } nd_hcard_num;

struct { unsigned short len; unsigned char arr[15]; } nd_hcard_expiry_date;

struct { unsigned short len; unsigned char arr[16]; } nd_cash_counter_desc;


   /* VARCHAR nd_session_id    [16],
	   nd_facility_id   [3] ,
           nd_fm_doc_type   [7],
	   nd_clinic	    [16],
           nd_to_doc_type   [7],
	   nd_nationality   [5],
           nd_fm_doc_num    [10],
           nd_to_doc_num    [10],
           nd_fm_doc_date   [12],
		   // Added by MRAMESH. date : 31-dec-1997
	   cur_str          [8],
	   sub_cur_str      [8],	   
           nd_to_doc_date   [12]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[16]; } nd_clinic;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[5]; } nd_nationality;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;


   /* VARCHAR d_doc_type_code                             [7],
           d_doc_number                                [9],
		   d_doc_srno								   [3],
           d_doc_date                                  [13],
           d_trx_date_time                             [17],
           d_episode_type                              [2],
           d_patient_id                                [21],
           d_patient_name                              [61],
           d_patient_name_loc_lang                     [61],
           d_episode_id                                [9],
           d_visit_id                                  [5],
           d_bill_doc_type_code                        [7],
           d_bill_doc_number                           [9],
           d_customer_code                             [9],
           d_cust_name                                 [41],
           d_doc_amt                                   [23],
           d_slmt_type_code                            [3],
           d_slmt_type_desc                            [16],
           d_slmt_doc_ref_desc                         [21],
           d_slmt_doc_ref_date                         [13],
           d_slmt_doc_remarks                          [102],
           d_narration                                 [51],
	   nd_cashier										[31],
           d_payer_name                                [41],
	   nd_hcare_appl_num								[21],
           d_cur_bed_num                               [9],
	   d_cur_ward_code									[5],
           d_cash_counter_code                         [3],	   
           d_shift_id                                  [2],
	   d_rowid                                     [20],
	   d_doc_type_num                              [25],
	   nd_reportid								[20],
	   nd_recpt_desc							[13],
	   p_language_id							[3]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[3]; } d_doc_srno;

struct { unsigned short len; unsigned char arr[13]; } d_doc_date;

struct { unsigned short len; unsigned char arr[17]; } d_trx_date_time;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_bill_doc_number;

struct { unsigned short len; unsigned char arr[9]; } d_customer_code;

struct { unsigned short len; unsigned char arr[41]; } d_cust_name;

struct { unsigned short len; unsigned char arr[23]; } d_doc_amt;

struct { unsigned short len; unsigned char arr[3]; } d_slmt_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_slmt_type_desc;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[13]; } d_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[102]; } d_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[51]; } d_narration;

struct { unsigned short len; unsigned char arr[31]; } nd_cashier;

struct { unsigned short len; unsigned char arr[41]; } d_payer_name;

struct { unsigned short len; unsigned char arr[21]; } nd_hcare_appl_num;

struct { unsigned short len; unsigned char arr[9]; } d_cur_bed_num;

struct { unsigned short len; unsigned char arr[5]; } d_cur_ward_code;

struct { unsigned short len; unsigned char arr[3]; } d_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } d_shift_id;

struct { unsigned short len; unsigned char arr[20]; } d_rowid;

struct { unsigned short len; unsigned char arr[25]; } d_doc_type_num;

struct { unsigned short len; unsigned char arr[20]; } nd_reportid;

struct { unsigned short len; unsigned char arr[13]; } nd_recpt_desc;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

	   //l_language_id							[3];

   char    nd_print_flag,
	   nd_rec_ref_flag,
           online_batch_flag,
	   d_err_code[30],
	   g_facility_id[3],
	   string_var[200];

   double  d_doc_amt_num,
	   nd_dep_amt;
   int nd_no_of_decimal,
	nd_dep_status = 0;   

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

FILE *fp;
int lctr = 0,pctr =0;

char filename[150];
char l_epi_barcode[50],
     l_rec_barcode[50];

void proc_main(argc,argv)
char *argv[];
int argc;
{

   char lv_msg[1024];
   
   if (argc < 9) {
        disp_message(ERR_MESG,"BLRPRREC : Usage BLRPRREC userid/password session_id pgm_date doc_type num print_flag facility report id \n");
        proc_exit();
    } 
   if (argc == 11) 
      {
        strcpy(nd_reportid.arr,argv[9]);
       // nd_reportid.len = strlen(uid_pwd.arr);
	    nd_reportid.len = strlen(nd_reportid.arr);
      }
   if (argc < 8)
      {
        strcpy(nd_reportid.arr,"BLRPRREC");
       // nd_reportid.len = strlen(uid_pwd.arr);
	   nd_reportid.len = strlen(nd_reportid.arr);
      }
   
   
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(g_session_id,argv[2]);
   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"BLRPRREC"); 

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   }

   set_meduser_role();
   strcpy(p_language_id.arr,l_language_id.arr);
		p_language_id.len = l_language_id.len;

   strcpy(g_pgm_date,argv[3]);
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   strcpy(d_doc_type_code.arr, argv[5]);
   strcpy(d_doc_number.arr, argv[6]);

   d_doc_type_code.len = strlen(d_doc_type_code.arr);
   d_doc_number.len    = strlen(d_doc_number.arr);

   strcpy(nd_facility_id.arr,argv[8]);

   nd_facility_id.len  = strlen(nd_facility_id.arr);
   strcpy(g_facility_id,nd_facility_id.arr);
   
   nd_print_flag = argv[7][0];  

   nd_facility_name.arr[0] = '\0';
   nd_facility_name.len = 0;

    
   /* exec sql select acc_entity_name, no_of_decimal 
		into :nd_facility_name, :nd_no_of_decimal
 	    from sy_acc_entity where acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select acc_entity_name ,no_of_decimal into :b0,:b1  from s\
y_acc_entity where acc_entity_id=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_name;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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
    {
         err_mesg("SELECT failed on cursor SY_ACC_ENTITY",0,"");
    }
    nd_facility_name.arr[nd_facility_name.len] = '\0';


    open_files(); 

    d_doc_date.arr[0]                                                 = '\0';
	d_doc_srno.arr[0]												  = '\0';
    d_episode_type.arr[0]                                             = '\0';
    d_patient_id.arr[0]                                               = '\0';
    d_episode_id.arr[0]                                               = '\0';
    d_visit_id.arr[0]                                                 = '\0';
    d_bill_doc_type_code.arr[0]                                       = '\0';
    d_bill_doc_number.arr[0]                                          = '\0';
    d_customer_code.arr[0]                                            = '\0';
    d_doc_amt.arr[0]                                                  = '\0';
    d_slmt_type_code.arr[0]                                           = '\0';
    d_slmt_doc_ref_desc.arr[0]                                        = '\0';
    d_slmt_doc_ref_date.arr[0]                                        = '\0';
    d_slmt_doc_remarks.arr[0]                                         = '\0';
    d_narration.arr[0]                                                = '\0';
    d_payer_name.arr[0]                                               = '\0';
    d_rowid.arr[0]                                                    = '\0';
    d_trx_date_time.arr[0]                                            = '\0';
    d_cash_counter_code.arr[0]                                        = '\0';
    d_shift_id.arr[0]                                                 = '\0';
    d_doc_type_num.arr[0]                                             = '\0';
    nd_hcare_appl_num.arr[0]  					      = '\0';

    nd_recpt_nature_code.arr[0]					      = '\0';
    
    d_doc_date.len                                                    = 0;
	d_doc_srno.len													  = 0;
    d_episode_type.len                                                = 0;
    d_patient_id.len                                                  = 0;
    d_episode_id.len                                                  = 0;
    d_visit_id.len                                                    = 0;
    d_bill_doc_type_code.len                                          = 0;
    d_bill_doc_number.len                                             = 0;
    d_customer_code.len                                               = 0;
    d_doc_amt.len                                                     = 0;
    d_slmt_type_code.len                                              = 0;
    d_slmt_doc_ref_desc.len                                           = 0;
    d_slmt_doc_ref_date.len                                           = 0;
    d_slmt_doc_remarks.len                                            = 0;
    d_narration.len                                                   = 0;
    d_payer_name.len                                                  = 0;
    d_rowid.len                                                       = 0;
    d_trx_date_time.len                                               = 0;
    d_cash_counter_code.len                                           = 0;
    d_shift_id.len                                                    = 0;
    d_doc_type_num.len                                                = 0;
    nd_hcare_appl_num.len					      = 0;

    nd_recpt_nature_code.len					      = 0;

    d_doc_amt_num                                                     = 0;

    nd_cashier.arr[0]						      = '\0';
    nd_cashier.len						      = 0;
    
    

   /* EXEC SQL DECLARE receipt_cursor CURSOR FOR 
				SELECT a.DOC_TYPE_CODE,
                   a.DOC_NUMBER,
				   a.DOC_SRNO,
                   to_char(a.DOC_DATE,'dd/mm/yyyy'),
                   a.EPISODE_TYPE,
                   a.PATIENT_ID,
                   LTRIM(TO_CHAR(a.EPISODE_ID,'00000009')),
                   a.VISIT_ID,
                   a.BILL_DOC_TYPE_CODE,
                   LTRIM(TO_CHAR(a.BILL_DOC_NUMBER,'00000009')),
                   a.CUSTOMER_CODE,
                   TO_CHAR(a.DOC_AMT) DOC_AMT,
                   a.SLMT_TYPE_CODE,
                   a.SLMT_DOC_REF_DESC,
                   TRUNC(a.SLMT_DOC_REF_DATE),
                   a.SLMT_DOC_REMARKS,
                   a.NARRATION,
                   a.PAYER_NAME,
                   A.ROWID,
                   TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   a.CASH_COUNTER_CODE,
                   a.SHIFT_ID,
		   a.DOC_TYPE_CODE||LTRIM(TO_CHAR(a.DOC_NUMBER,'00000009')),
		   a.RECPT_REFUND_IND,
		   a.RECPT_NATURE_CODE,
		   a.HCARE_APPL_NUM,
		   a.ADDED_BY_ID
        FROM BL_RECEIPT_REFUND_HDRDTL_VW a
	    WHERE a.DOC_TYPE_CODE 	= :d_doc_type_code
	     AND a.DOC_NUMBER    	= :d_doc_number 
		 FOR UPDATE OF PRINT_FLAG NOWAIT; */ 
   

    if(sqlca.sqlcode == -54)
	 {
      sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
       disp_message(ERR_MESG,d_err_code);
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 3;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )32;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			proc_exit();
	  }


    if (OERROR)
    {
         err_mesg("DECLARE failed on cursor BL_REC_REF_CUR",0,"");

	}

	/* EXEC SQL OPEN receipt_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0002;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )47;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
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
    {
         err_mesg("OPEN failed on cursor receipt_cursor",0,"");

    }	 

	while(fn_fetch_receipt_cursor())
	  {
   
    nd_print_flag = nd_rec_ref_flag;   

    nd_cash_counter_desc.arr[0] = '\0';
    nd_cash_counter_desc.len = 0;    
   

    /* exec sql select short_desc into :nd_cash_counter_desc from bl_cash_counter
	     where operating_facility_id = :nd_facility_id
		and cash_counter_code = :d_cash_counter_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 3;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select short_desc into :b0  from bl_cash_counter where (o\
perating_facility_id=:b1 and cash_counter_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )70;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_cash_counter_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
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
    sqlstm.sqhstv[2] = (         void  *)&d_cash_counter_code;
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
    {
         err_mesg("FETCH failed on BL_CASH_COUNTER",0,"");
    }
    
    nd_cash_counter_desc.arr[nd_cash_counter_desc.len] = '\0';

    l_epi_barcode[0] = '\0';
    l_rec_barcode[0] = '\0';

        if(strlen(d_patient_id.arr) != 0) { 

            d_patient_name.arr[0]  = '\0';
            d_patient_name_loc_lang.arr[0]  = '\0';
            nd_nationality.arr[0]  = '\0';

            d_patient_name.len  = 0;
            d_patient_name_loc_lang.len  = 0;
	    nd_nationality.len = 0;

	     /* EXEC SQL SELECT  SHORT_NAME,
	        	      SHORT_NAME_LOC_LANG,
			      NATIONALITY_CODE
	              INTO   :d_patient_name,
			     :d_patient_name_loc_lang,
			     :nd_nationality
	              FROM    MP_PATIENT_MAST
	              WHERE   PATIENT_ID = :d_patient_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 4;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select SHORT_NAME ,SHORT_NAME_LOC_LANG ,NATIONALITY_COD\
E into :b0,:b1,:b2  from MP_PATIENT_MAST where PATIENT_ID=:b3";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )97;
      sqlstm.selerr = (unsigned short)1;
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
      sqlstm.sqhstv[1] = (         void  *)&d_patient_name_loc_lang;
      sqlstm.sqhstl[1] = (unsigned int  )63;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_nationality;
      sqlstm.sqhstl[2] = (unsigned int  )7;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
      sqlstm.sqhstl[3] = (unsigned int  )23;
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



            if(OERROR)
		{   

	        err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");
		}
    
            d_patient_name.arr[d_patient_name.len]  = '\0';
            d_patient_name_loc_lang.arr[d_patient_name_loc_lang.len]  = '\0';
            nd_nationality.arr[nd_nationality.len] = '\0';

            d_cur_bed_num.arr[0] = '\0';
            d_cur_bed_num.len    = 0;
	    d_cur_ward_code.arr[0] = '\0';
            d_cur_ward_code.len    = 0;
            
            /* EXEC SQL SELECT CUR_BED_NUM,CUR_WARD_CODE
                     INTO   :d_cur_bed_num, :d_cur_ward_code
                     FROM   IP_EPISODE
                     WHERE  EPISODE_ID = :d_episode_id
		     AND facility_id = :nd_facility_id; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "select CUR_BED_NUM ,CUR_WARD_CODE into :b0,:b1  f\
rom IP_EPISODE where (EPISODE_ID=:b2 and facility_id=:b3)";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )128;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_cur_bed_num;
            sqlstm.sqhstl[0] = (unsigned int  )11;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&d_cur_ward_code;
            sqlstm.sqhstl[1] = (unsigned int  )7;
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
            sqlstm.sqhstl[2] = (unsigned int  )11;
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



            if(OERROR)
                err_mesg("SELECT failed on table IP_EPISODE",0,"");

            d_cur_bed_num.arr[d_cur_bed_num.len] = '\0';
            d_cur_ward_code.arr[d_cur_ward_code.len] = '\0';
        }
	    
	if(d_customer_code.arr[0]) {
            d_cust_name.arr[0]          = '\0';
            d_cust_name.len             = 0;

	    /* EXEC SQL SELECT DECODE(CHINESE_REPORTING_FLAG,'Y',
                        LONG_NAME_CHINESE,LONG_NAME)
                 INTO   :d_cust_name
                 FROM   AR_CUSTOMER
                 WHERE  CUST_CODE = :d_customer_code			
		 AND acc_entity_code in ( select acc_entity_code from sy_acc_entity
			where acc_entity_id  = :nd_facility_id ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINE\
SE,LONG_NAME) into :b0  from AR_CUSTOMER where (CUST_CODE=:b1 and acc_entity_c\
ode in (select acc_entity_code  from sy_acc_entity where acc_entity_id=:b2))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )159;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_cust_name;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_customer_code;
     sqlstm.sqhstl[1] = (unsigned int  )11;
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
		{   

                 err_mesg("SELECT failed on cursor AR_CUSTOMER_CUR",0,"");
		}

             d_cust_name.arr[d_cust_name.len] = '\0';
        }

//        fprintf(fp,"%c%c%c",27,67,33);
        //if(nd_print_flag EQ "R")


   	if(nd_print_flag EQ 'R')
		 print_receipt(); 
        else	 
		print_refund();

		
       		 update_rec();   

	}

    /* EXEC SQL CLOSE receipt_cursor; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )186;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   fclose(fp);
  

  
   
  PrintDocument
   (
		uid_pwd.arr,		//char	*PUidPwd;
		nd_session_id.arr,	//char	*PSessionID;
		nd_facility_id.arr,	//char	*PFacilityID;
		"BL",				//char	*PModuleID;
		nd_reportid.arr,			//char	*PDocumentID;
		filename,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		" ",				//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		999					//int		PPageTo;
	);
	
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )201;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   return;
}


sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )216;
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

   strcpy(filename,WORKING_DIR);
   if(nd_print_flag EQ 'R')
       strcat(filename,"blroffrc.lis");
   else
       strcat(filename,"blrrefnd.lis");

   strcpy ( OUTPUT_FILE_NAME, filename );

   if ((fp = fopen(filename,"w")) == NULL)
   {
        err_mesg("Error while opening output file",0,"");
        proc_exit();
   }

}


fn_fetch_receipt_cursor()
   {
	
	/* EXEC SQL fetch receipt_cursor
		      INTO :d_doc_type_code,
                  :d_doc_number,
				  :d_doc_srno,
                  :d_doc_date,
				  :d_episode_type,
                  :d_patient_id,
                  :d_episode_id,
                  :d_visit_id,
                  :d_bill_doc_type_code,
                  :d_bill_doc_number,
                  :d_customer_code,
                  :d_doc_amt,
                  :d_slmt_type_code,
                  :d_slmt_doc_ref_desc,
                  :d_slmt_doc_ref_date,
                  :d_slmt_doc_remarks,
                  :d_narration,
                  :d_payer_name,
                  :d_rowid,
                  :d_trx_date_time,
                  :d_cash_counter_code,
                  :d_shift_id,
				  :d_doc_type_num,
				  :nd_rec_ref_flag,
				  :nd_recpt_nature_code,
  				  :nd_hcare_appl_num,
				  :nd_cashier ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )247;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_srno;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[3] = (unsigned int  )15;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[5] = (unsigned int  )23;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_visit_id;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_bill_doc_type_code;
 sqlstm.sqhstl[8] = (unsigned int  )9;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_bill_doc_number;
 sqlstm.sqhstl[9] = (unsigned int  )11;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_customer_code;
 sqlstm.sqhstl[10] = (unsigned int  )11;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_doc_amt;
 sqlstm.sqhstl[11] = (unsigned int  )25;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_slmt_type_code;
 sqlstm.sqhstl[12] = (unsigned int  )5;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_slmt_doc_ref_desc;
 sqlstm.sqhstl[13] = (unsigned int  )23;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_slmt_doc_ref_date;
 sqlstm.sqhstl[14] = (unsigned int  )15;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&d_slmt_doc_remarks;
 sqlstm.sqhstl[15] = (unsigned int  )104;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&d_narration;
 sqlstm.sqhstl[16] = (unsigned int  )53;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&d_payer_name;
 sqlstm.sqhstl[17] = (unsigned int  )43;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&d_rowid;
 sqlstm.sqhstl[18] = (unsigned int  )22;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&d_trx_date_time;
 sqlstm.sqhstl[19] = (unsigned int  )19;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&d_cash_counter_code;
 sqlstm.sqhstl[20] = (unsigned int  )5;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&d_shift_id;
 sqlstm.sqhstl[21] = (unsigned int  )4;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&d_doc_type_num;
 sqlstm.sqhstl[22] = (unsigned int  )27;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&nd_rec_ref_flag;
 sqlstm.sqhstl[23] = (unsigned int  )1;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_recpt_nature_code;
 sqlstm.sqhstl[24] = (unsigned int  )5;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&nd_hcare_appl_num;
 sqlstm.sqhstl[25] = (unsigned int  )23;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&nd_cashier;
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


    
	if(sqlca.sqlcode == -54) 
	{
		/*sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);*/
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 27;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )370;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		proc_exit();
	}   

    if (OERROR)
    {
         err_mesg("FETCH failed on cursor receipt_cursor",0,"");
    }

    d_doc_type_code.arr[d_doc_type_code.len]                             = '\0';
    d_doc_number.arr[d_doc_number.len]                                   = '\0';
	d_doc_srno.arr[d_doc_srno.len]										 = '\0';
    d_doc_date.arr[d_doc_date.len]                                       = '\0';
    d_episode_type.arr[d_episode_type.len]                               = '\0';
    d_patient_id.arr[d_patient_id.len]                                   = '\0';
    d_episode_id.arr[d_episode_id.len]                                   = '\0';
    d_visit_id.arr[d_visit_id.len]                                       = '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]                   = '\0';
    d_bill_doc_number.arr[d_bill_doc_number.len]                         = '\0';
    d_customer_code.arr[d_customer_code.len]                             = '\0';
    d_doc_amt.arr[d_doc_amt.len]                                         = '\0';
    d_slmt_type_code.arr[d_slmt_type_code.len]                           = '\0';
    d_slmt_doc_ref_desc.arr[d_slmt_doc_ref_desc.len]                     = '\0';
    d_slmt_doc_ref_date.arr[d_slmt_doc_ref_date.len]                     = '\0';
    d_slmt_doc_remarks.arr[d_slmt_doc_remarks.len]                       = '\0';
    d_payer_name.arr[d_payer_name.len]                                   = '\0';
    d_narration.arr[d_narration.len]                                     = '\0';
    d_trx_date_time.arr[d_trx_date_time.len]                             = '\0';
    d_cash_counter_code.arr[d_cash_counter_code.len]                     = '\0';
    d_shift_id.arr[d_shift_id.len]                                       = '\0';
    d_doc_type_num.arr[d_doc_type_num.len]                               = '\0';
    nd_hcare_appl_num.arr[nd_hcare_appl_num.len]			 = '\0';

    nd_recpt_nature_code.arr[nd_recpt_nature_code.len]			 = '\0';    

    d_doc_amt_num = atof(d_doc_amt.arr);
    nd_cashier.arr[nd_cashier.len]					 = '\0';  

		return(LAST_ROW?0:1); 
}


print_receipt()
{
   char out_str[10][133];
   char s_amt[20];
   int  length_str[10];
   int  i = 0,no_of_lines = 0;
   char epi_visit[14];

   //Added by MRAMESH. Date : 31-dec-1997
   cur_str.arr[0]   = '\0';
   cur_str.len      =  0;   
   sub_cur_str.arr[0]   = '\0';
   sub_cur_str.len      = 0;
   
   /* exec sql select base_currency,
                   base_currency_dec 
            into :cur_str,
		 :sub_cur_str
  	    from sy_acc_entity
	    where acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select base_currency ,base_currency_dec into :b0,:b1  from\
 sy_acc_entity where acc_entity_id=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )385;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&cur_str;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&sub_cur_str;
   sqlstm.sqhstl[1] = (unsigned int  )10;
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



   if (sqlca.sqlcode == 1403)
    { 
     err_mesg("No base currency in table SY_ACC_ENTITY",0,"");
	}
   if (sqlca.sqlcode < 0)
      {   

     err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");
       }
   
   cur_str.arr[cur_str.len]  = '\0';
   sub_cur_str.arr[sub_cur_str.len] = '\0';


   if(d_episode_type.arr[0] EQ 'I' || d_episode_type.arr[0] EQ 'D' ) // EPNH 14/10/2004 
      sprintf(epi_visit,"%-8s",d_episode_id.arr);
   else


  if (d_episode_type.arr[0] EQ 'O' || d_episode_type.arr[0] EQ 'E') // EPNH 14/10/2004 
  {

   nd_clinic.arr[0] = '\0';
   nd_clinic.len = 0;

   /* exec sql select short_desc into :nd_clinic from  bl_op_clinic_vw where 
	    facility_id = :nd_facility_id
	    and clinic_code in
		(select clinic_code from bl_visit_fin_dtls
		where patient_id = :d_patient_id and visit_id=:d_visit_id
		and episode_id = :d_episode_id
		and operating_facility_id = :nd_facility_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from bl_op_clinic_vw where (fa\
cility_id=:b1 and clinic_code in (select clinic_code  from bl_visit_fin_dtls w\
here (((patient_id=:b2 and visit_id=:b3) and episode_id=:b4) and operating_fac\
ility_id=:b1)))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )412;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_clinic;
   sqlstm.sqhstl[0] = (unsigned int  )18;
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
   sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
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
        err_mesg("SELECT failed on BL_OP_CLINIC_VW",0,"");   

   nd_clinic.arr[nd_clinic.len] = '\0';   }		

   if (d_episode_type.arr[0] EQ 'I' || d_episode_type.arr[0] EQ 'D' ) // EPNH 14/10/2004 
	sprintf(epi_visit,"%-8s",d_episode_id.arr);
   else
       if (d_episode_type.arr[0] EQ 'O' || d_episode_type.arr[0] EQ 'E' ) // EPNH 14/10/2004 
        sprintf(epi_visit,"%-8s/%-4s",d_episode_id.arr,d_visit_id.arr);
       else
		sprintf(epi_visit,"%-8s %-4s"," "," ");
    
   /* EXEC SQL
   select decode(:nd_recpt_nature_code,
					'AD','Pat Deposit',
					'BI','Against Bill',
					'DC','DCP',
					'MI','Misc', 
					'PR','Prepayment' ,
					'RD','Ref Deposit',
					'HC','Healthcard',
					'PD','Pkg Deposit', 
					'CU','Customer') 
				into :nd_recpt_desc
				from dual; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select decode(:b0,'AD','Pat Deposit','BI','Against Bill','\
DC','DCP','MI','Misc','PR','Prepayment','RD','Ref Deposit','HC','Healthcard','\
PD','Pkg Deposit','CU','Customer') into :b1  from dual ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )451;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_recpt_nature_code;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_recpt_desc;
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

	   
	    

   fprintf(fp,"\n\n\n\n\n\n");
 
  
   fprintf(fp,"%50s Receipt No.: %-6s/%-8s/%-s\n"," ",d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);

   fprintf(fp,"%50s Date    : %s\n"," ",d_doc_date.arr);

   fprintf(fp,"%50s Nature  : %s(%s)\n"," ",nd_recpt_desc.arr,nd_recpt_nature_code.arr);

   fprintf(fp,"%50s Episode : %-14s\n\n\n\n"," ",epi_visit);

   fprintf(fp,"%30s %s\n\n"," ", "DEPARTMENT OF FINANCE");

   fprintf(fp,"%30s %s\n\n\n\n"," ", "  OFFICIAL RECEIPT");
 
  if (d_patient_id.arr[0])
   {
   fprintf(fp,"%5s Patient No       : %s "," ",d_patient_id.arr);
   fprintf(fp,"Name : %-60.32s \n",d_patient_name.arr);
   }
  else												
   fprintf(fp,"%5s Patient No       : %s \n"," ","______________________");
   
  
   length_str[0] = 45;
   for (i =1;i<10;i++)
      length_str[i] = 80;
   for (i =1;i<10;i++)
      strcpy(out_str[i],"");

// no_of_lines = print_in_words(d_doc_amt_num<0?-d_doc_amt_num:d_doc_amt_num,length_str,out_str,nd_no_of_decimal);

 
   no_of_lines =    print_in_words(d_doc_amt_num<0?-d_doc_amt_num:d_doc_amt_num,MAX_LINES,sub_cur_str.arr,out_str,nd_no_of_decimal);


   put_val(s_amt,d_doc_amt_num < 0? -d_doc_amt_num:d_doc_amt_num);
   

   format_amt(s_amt);
   if(nd_print_flag EQ 'R')
   {
     for(i=0;i<SKIP_5;i++) fprintf(fp," ");
   }
   else
   {
     for(i=0;i<SKIP_6;i++) fprintf(fp," ");
   }

   if(strlen(out_str[1]))
       strcat(out_str[1],")");
   else
       strcat(out_str[0],")");
   fprintf(fp,"\n");
   fprintf(fp,"%5s The Sum of %s : %s\n"," ",cur_str.arr,s_amt);
   
   if(d_doc_amt_num != 0)
   fprintf(fp,"\n%5s (%-6s"," ",cur_str.arr);
   

  if(d_doc_amt_num == 0) 
   {
   fprintf(fp,"\n\n\t\t(%s",out_str[0]);
   fprintf(fp,"\n");
   }
   else
 
        
	for (i=0;i<3;i++)
			{	fprintf(fp,"%s \n %5s",out_str[i]," ");
				}

// fprintf(fp,"\n");

 if(d_customer_code.arr[0])
   fprintf(fp,"Received From    : %-40s\n",d_cust_name.arr);

 else 
   if(d_patient_id.arr[0])
    {fprintf(fp,"Received From    : %-60s \n",d_patient_name.arr);
		 if (strlen(d_cur_ward_code.arr) >0)
			fprintf(fp,"%24s Ward : %s "," ",d_cur_ward_code.arr);
		 
		 if (strlen(nd_clinic.arr) >0)
			fprintf(fp,"%24s Clinic : %s "," ",nd_clinic.arr);

		 if (strlen(d_cur_bed_num.arr) >0)
			fprintf(fp,"%24s Bed : %s "," ",d_cur_bed_num.arr);
			fprintf(fp,"\n");
   }
   else
   fprintf(fp,"Received From    : %-40s\n",d_payer_name.arr);
    
   fprintf(fp,"%5s In Respect of    :", " ");
   if (strcmp(nd_recpt_nature_code.arr,"BI") == 0 )	 		
         fprintf(fp," Bill Doc.Type : %-7s/ %-8s \n", d_bill_doc_type_code.arr,d_bill_doc_number.arr);
   else   
    if (strcmp(nd_recpt_nature_code.arr,"MI") == 0 )	 		
       {
	 if (nd_hcare_appl_num.arr[0])
	      fprintf(fp," Healthcare Application Number : %-20.20s \n",nd_hcare_appl_num.arr);	
	 else 	   
	      fprintf(fp," %-50s\n\n",d_narration.arr);
	}
     else
      if (strcmp(nd_recpt_nature_code.arr,"HC") == 0 )
	{ 	
				nd_blng_grp.arr[0] = '\0';
				nd_blng_desc.arr[0] = '\0';
		  	        nd_hcard_status.arr[0] = '\0';	
		   	        nd_hcard_num.arr[0] = '\0';
			        nd_hcard_expiry_date.arr[0] = '\0';

				nd_blng_grp.len =0 ;
				nd_blng_desc.len =0 ;
		   	        nd_hcard_status.len =0 ;
		   	        nd_hcard_num.len =0 ;
			        nd_hcard_expiry_date.len =0 ;

		/* EXEC SQL  SELECT a.BLNG_GRP_ID,b.SHORT_DESC,
		          	 DECODE(HCARD_STATUS,'P','PERMANENT','TEMPORARY')  STATUS ,           	    			  HCARD_NUM,                      		
				  TO_CHAR(HCARD_EXPIRY_DATE,'DD/MM/YYYY')              
			INTO
				nd_blng_grp ,
				nd_blng_desc,
		   	        nd_hcard_status,	
		   	        nd_hcard_num,
			        nd_hcard_expiry_date
			FROM BL_PATIENT_FIN_DTLS a, BL_BLNG_GRP b
			WHERE a.BLNG_GRP_ID = a.BLNG_GRP_ID
			AND   PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select a.BLNG_GRP_ID ,b.SHORT_DESC ,DECODE(HCARD_STATUS,'P'\
,'PERMANENT','TEMPORARY') STATUS ,HCARD_NUM ,TO_CHAR(HCARD_EXPIRY_DATE,'DD/MM/\
YYYY') into :b0,:b1,:b2,:b3,:b4  from BL_PATIENT_FIN_DTLS a ,BL_BLNG_GRP b whe\
re (a.BLNG_GRP_ID=a.BLNG_GRP_ID and PATIENT_ID=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )474;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_blng_desc;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_hcard_status;
  sqlstm.sqhstl[2] = (unsigned int  )14;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_hcard_num;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_hcard_expiry_date;
  sqlstm.sqhstl[4] = (unsigned int  )17;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[5] = (unsigned int  )23;
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


				
				nd_blng_grp.arr[nd_blng_grp.len] = '\0';
				nd_blng_desc.arr[nd_blng_desc.len] = '\0';
		   	        nd_hcard_status.arr[nd_hcard_status.len] = '\0';	
		   	        nd_hcard_num.arr[nd_hcard_num.len] = '\0';
			        nd_hcard_expiry_date.arr[nd_hcard_expiry_date.len] = '\0';




		     fprintf(fp," Health Card No.: %-20s  							",nd_hcard_num.arr);
		     fprintf(fp,"\n");
		     fprintf(fp,"%5s                    Status : %-15s Expiry Date : %-12s\n"," ",nd_hcard_status.arr,nd_hcard_expiry_date.arr);	
		     fprintf(fp,"%5s                    Billing Group : %-15s\n"," ",nd_blng_desc.arr);
		}
      else
        if (strcmp(nd_recpt_nature_code.arr,"AD") == 0 )
	 {	     declare_dep_cursor();		      
		     fprintf(fp," Adjustable deposit For %20s\n\n",epi_visit);
          }	
	 else
	    if (strcmp(nd_recpt_nature_code.arr,"RD") == 0 )
	 {	     fprintf(fp," Refundable Deposit for %-50s\n\n",d_narration.arr);
          }				
	else
		if (strcmp(nd_recpt_nature_code.arr,"PR") == 0 )
	 {	     fprintf(fp," Prepayment for %-50s\n\n",d_narration.arr);
          }				

      else 	   
	fprintf(fp,"%-50s\n\n\n",d_narration.arr);


   fprintf(fp,"\n\n\n");

   fprintf(fp,"%30s    PAYMENT DETAILS\n\n\n"," ");

    d_slmt_type_desc.arr[0]  = '\0';
    d_slmt_type_desc.len  = 0;

    /* EXEC SQL SELECT  SHORT_DESC
		     INTO    :d_slmt_type_desc
		     FROM    BL_SLMT_TYPE
		     WHERE   SLMT_TYPE_CODE = :d_slmt_type_code
		     AND acc_entity_code in ( select acc_entity_code from sy_acc_entity
					      where acc_entity_id = :nd_facility_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_DESC into :b0  from BL_SLMT_TYPE where (SLMT\
_TYPE_CODE=:b1 and acc_entity_code in (select acc_entity_code  from sy_acc_ent\
ity where acc_entity_id=:b2))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )513;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_desc;
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


    if(OERROR)
	{   
	err_mesg("FETCH failed on cursor SLMT_TYPE_CUR",0,"");
	}

   d_slmt_type_desc.arr[d_slmt_type_desc.len]  = '\0';

   fprintf(fp,"%5s Settlement Type  : %s\n\n"," ",d_slmt_type_desc.arr);

   //if (strlen(d_slmt_doc_ref_desc.arr) > 0 || strlen(d_slmt_doc_ref_date.arr) > 0) 
   if (d_slmt_doc_ref_desc.arr[0])
		fprintf(fp,"%5s Cheque/Card No   : %-20s  Date : %10s\n\n"," ",d_slmt_doc_ref_desc.arr, d_slmt_doc_ref_date.arr);
   else
        fprintf(fp,"%5s Cheque/Card No   : %-20s  Date : %10s\n\n"," ","____________________________", "_______________");
   
   if (d_slmt_doc_remarks.arr[0])
	   fprintf(fp,"%5s Bank Card/Co.Name: %-30s\n\n\n\n\n"," ",d_slmt_doc_remarks.arr);
   else
	   fprintf(fp,"%5s Bank Card/Co.Name: %-30s\n\n\n\n\n"," ","______________________________");
   
   fprintf(fp,"%5s Cashier   : %s       Counter : %s       Shift: %s \n\n"," ",nd_cashier.arr,d_cash_counter_code.arr,d_shift_id.arr);
   fprintf(fp,"%5s ________________________________________________________________________\n\n"," ");

   fprintf(fp,"%5s **This is a Computer Generated Receipt,Therefore No Signature Required** \n"," ");
   fprintf(fp,"%5s              ***Must Produce the Receipt for any Refund***\n"," ");
   fprintf(fp,"");


    /*
   * Following PrintDocument Call is added by Sundar on Dec 16,2002.
   * To test PrintDocument function (SY_PRINT.PC).
   */
  

}

declare_dep_cursor()
{   /* EXEC SQL DECLARE deposit_cursor CURSOR FOR 
	SELECT a.BLNG_SERV_CODE,a.DEPOSIT_AMT,
	       b.long_desc	
	 FROM BL_RCPT_RFND_SERVICE_DTL a,
	      BL_BLNG_SERV B
	WHERE a.DOC_TYPE_CODE  = :d_doc_type_code AND 
	      a.DOC_NUMBER = To_NUMBER(:d_doc_number) AND
	      a.blng_serv_code = b.blng_serv_code
	ORDER BY 1; */ 


   if(OERROR)	   
	err_mesg("DECLARE failed on cursor deposit_cursor",0,"");
	

    nd_dep_status = 0;
    /* EXEC SQL OPEN deposit_cursor; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0016;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )540;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
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



    if(OERROR)	   
	err_mesg("OPEN failed on cursor deposit_cursor",0,"");
	
    while (fetch_dep_cursor())
    {  
       if ( nd_dep_status == 1 )
	     {
		 fprintf(fp,"\n\n");
         fprintf(fp,"    SERVICE CODE  DESCRIPTION                    APPROX.SERVICE CHARGE\n ");
		 fprintf(fp,"   ------------  -----------                    ---------------------\n");

		 }
       
	     fprintf(fp,"    %-12.12s  %-30.30s ",nd_service_code.arr,nd_service_desc.arr);  
		 print_formated(nd_dep_amt) ;   
		 fprintf(fp,"\n");
    }
  /* exec sql close deposit_cursor; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )563;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_dep_cursor()
{
    nd_service_code.arr[0] = '\0';
    nd_service_code.len	   = 0;
	nd_service_desc.arr[0]	   = '\0';
    nd_service_desc.len	   = 0;
    nd_dep_amt = 0;
    /* EXEC SQL FETCH deposit_cursor INTO	
		:nd_service_code,:nd_dep_amt,:nd_service_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )578;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_service_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_dep_amt;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_service_desc;
    sqlstm.sqhstl[2] = (unsigned int  )43;
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
	err_mesg("FETCH failed on cursor deposit_cursor",0,"");

    if (sqlca.sqlcode == 1403 )	
	return 0;
     nd_service_code.arr[nd_service_code.len] = '\0';
	 nd_service_desc.arr[nd_service_desc.len] = '\0';
        nd_dep_status = nd_dep_status + 1;
        return 1;   
}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	strcat(s_amt,"-");
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s ",str_amt);
        }

}


print_refund()
{
   char out_str[10][133];
   char s_amt[20];
   char epi_visit[14];
   int  length_str[10];
   int  i = 0,no_of_lines = 0;

    //Added by MRAMESH. Date : 31-dec-1997
   cur_str.arr[0]   = '\0';
   cur_str.len      =  0;   
   sub_cur_str.arr[0]   = '\0';
   sub_cur_str.len      = 0;



  /* exec sql select base_currency,
            base_currency_dec 
            Into :cur_str,
		  sub_cur_str
		 from sy_acc_entity
	       where acc_entity_id = :nd_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select base_currency ,base_currency_dec into :b0,:b1  from \
sy_acc_entity where acc_entity_id=:b2";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )605;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&cur_str;
  sqlstm.sqhstl[0] = (unsigned int  )10;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&sub_cur_str;
  sqlstm.sqhstl[1] = (unsigned int  )10;
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



   if (sqlca.sqlcode == 1403)
	{   
     err_mesg("No base currency in table SY_ACC_ENTITY",0,"");
	}
   if (sqlca.sqlcode < 0)
   {   
     err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");
}

   cur_str.arr[cur_str.len]  = '\0';
   sub_cur_str.arr[sub_cur_str.len] = '\0';

   if(d_episode_type.arr[0] EQ 'I' || d_episode_type.arr[0] EQ 'D') // EPNH 14/10/2004 
      sprintf(epi_visit,"%-8s",d_episode_id.arr);
   else
	{
        nd_clinic.arr[0] = '\0';
        nd_clinic.len = 0;

   /* exec sql select short_desc into :nd_clinic from  bl_op_clinic_vw where 
	    facility_id = :nd_facility_id
	    and clinic_code in
		(select clinic_code from bl_visit_fin_dtls
		where patient_id = :d_patient_id and visit_id=:d_visit_id
		and episode_id = :d_episode_id
		and operating_facility_id = :nd_facility_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from bl_op_clinic_vw where (fa\
cility_id=:b1 and clinic_code in (select clinic_code  from bl_visit_fin_dtls w\
here (((patient_id=:b2 and visit_id=:b3) and episode_id=:b4) and operating_fac\
ility_id=:b1)))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )632;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_clinic;
   sqlstm.sqhstl[0] = (unsigned int  )18;
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
   sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
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



    nd_clinic.arr[nd_clinic.len] = '\0';

   
   sprintf(epi_visit,"%-8s/%-4s",d_episode_id.arr,d_visit_id.arr); 
   }

   fprintf(fp,"\n\n\n\n\n\n");

   fprintf(fp,"%50s Refund No. : %-6s/%-8s/%-s\n"," ",d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);

   fprintf(fp,"%50s Date       : %s\n"," ",d_doc_date.arr);

   fprintf(fp,"%50s Episode    : %-14s\n\n\n\n"," ",epi_visit);
 
   fprintf(fp,"%30s %s\n\n"," ",    "DEPARTMENT OF FINANCE");

   fprintf(fp,"%30s %s\n\n\n\n"," ","REFUND ACKNOWLEDGMENT");

   fprintf(fp,"%5s Refunded to      :"," " );
 
   if(d_customer_code.arr[0])
       fprintf(fp," %-40s\n\n",d_cust_name.arr);
   else if(d_patient_id.arr[0])
    {  fprintf(fp," %-60s \n\n",d_patient_name.arr);
	   fprintf(fp,"%5s Patient No       : %s "," ",d_patient_id.arr);
	   fprintf(fp,"Name : %-60.32s \n\n",d_patient_name.arr);
       if (strlen(nd_clinic.arr) >0)
       fprintf(fp,"%5s Clinic           : %s "," ",nd_clinic.arr);

       if (strlen(d_cur_ward_code.arr) >0)
           fprintf(fp,"%5s Ward : %s "," ",d_cur_ward_code.arr);
 
       if (strlen(d_cur_bed_num.arr) >0)
           fprintf(fp," Bed : %s",d_cur_bed_num.arr);
       
       fprintf(fp,"\n\n");

   }
   else
       fprintf(fp," %-40s\n\n",d_payer_name.arr);
      
   length_str[0] = 45;
   for (i =1;i<10;i++)
      length_str[i] = 80;
   for (i =1;i<10;i++)
      strcpy(out_str[i],"");


   //no_of_lines = print_in_words(d_doc_amt_num<0?-d_doc_amt_num:d_doc_amt_num,MAX_LINES,sub_cur_str.arr,out_str);

   no_of_lines = print_in_words(d_doc_amt_num<0?-d_doc_amt_num:d_doc_amt_num,MAX_LINES,sub_cur_str.arr,out_str,nd_no_of_decimal);


  put_val(s_amt,d_doc_amt_num < 0? -d_doc_amt_num:d_doc_amt_num);
   format_amt(s_amt);

   
 if(strlen(out_str[1]))
       strcat(out_str[1],")");
   else 
       strcat(out_str[0],")");
   fprintf(fp,"\n");
     
   fprintf(fp,"%5s The Sum of %s : %s\n"," ",cur_str.arr,s_amt);
   
   if(d_doc_amt_num != 0)
   fprintf(fp,"\n%5s (%-6s"," ",cur_str.arr);
   

  if(d_doc_amt_num == 0) 
   {
   fprintf(fp,"\n\n\t\t(%s",out_str[0]);
   fprintf(fp,"\n");
   }
   else
 
	for (i=0;i<3;i++)
			{	fprintf(fp,"%s \n %5s",out_str[i]," ");
				}
				
   // fprintf(fp,"\n");
 
 
   fprintf(fp,"In Respect of : ");
   if (strcmp(nd_recpt_nature_code.arr,"BI") == 0 )	 		
      fprintf(fp,"%5s Bill Doc.Type: %-7s/ %-8s \n"," ",d_bill_doc_type_code.arr,d_bill_doc_number.arr);
    if (strcmp(nd_recpt_nature_code.arr,"MI") == 0 )	 		
	{ if (nd_hcare_appl_num.arr[0])
	      fprintf(fp,"%5s Healthcare Application Number: %-10s \n"," ",nd_hcare_appl_num.arr);
	  else
	      fprintf(fp," %-50s\n",d_narration.arr);	
	}
      if (strcmp(nd_recpt_nature_code.arr,"HC") == 0 )
	{ 
				nd_blng_grp.arr[0] = '\0';
		   	        nd_hcard_status.arr[0] = '\0';	
		   	        nd_hcard_num.arr[0] = '\0';
			        nd_hcard_expiry_date.arr[0] = '\0';
				nd_blng_grp.len =0 ;
		   	        nd_hcard_status.len =0 ;
		   	        nd_hcard_num.len =0 ;
			        nd_hcard_expiry_date.len =0 ;

		/* EXEC SQL  SELECT BLNG_GRP_ID,
		          	 DECODE(HCARD_STATUS,'P','Permanent','Temporary')  STATUS ,           	    			  HCARD_NUM,                      		
				  TO_CHAR(HCARD_EXPIRY_DATE,'DD/MM/YYYY')              
			INTO
				nd_blng_grp ,
		   	        nd_hcard_status,	
		   	        nd_hcard_num,
			        nd_hcard_expiry_date
			FROM BL_PATIENT_FIN_DTLS
			WHERE PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select BLNG_GRP_ID ,DECODE(HCARD_STATUS,'P','Permanent','Te\
mporary') STATUS ,HCARD_NUM ,TO_CHAR(HCARD_EXPIRY_DATE,'DD/MM/YYYY') into :b0,\
:b1,:b2,:b3  from BL_PATIENT_FIN_DTLS where PATIENT_ID=:b4";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )671;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_hcard_status;
  sqlstm.sqhstl[1] = (unsigned int  )14;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_hcard_num;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_hcard_expiry_date;
  sqlstm.sqhstl[3] = (unsigned int  )17;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
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


				
				nd_blng_grp.arr[nd_blng_grp.len] = '\0';
		   	        nd_hcard_status.arr[nd_hcard_status.len] = '\0';	
		   	        nd_hcard_num.arr[nd_hcard_num.len] = '\0';
			        nd_hcard_expiry_date.arr[nd_hcard_expiry_date.len] = '\0';

			 fprintf(fp,"%5s Healthcard Num: %-20s Expiry Date: %-12s "," ",nd_hcard_num.arr,nd_hcard_expiry_date.arr);
		 fprintf(fp,"\n");
			 fprintf(fp,"%5s Billing Group : %-2s   Status : %-15s \n"," ",nd_blng_grp.arr,nd_hcard_status.arr);	

		}

      if (strcmp(nd_recpt_nature_code.arr,"AD") == 0 )
	{
		declare_dep_cursor();		
	}

  fprintf(fp,"\n");

fprintf(fp,"\n\n %30s    PAYMENT DETAILS\n\n\n\n"," ");

    d_slmt_type_desc.arr[0]  = '\0';
    d_slmt_type_desc.len  = 0;

    /* EXEC SQL SELECT  SHORT_DESC
		     INTO    :d_slmt_type_desc
		     FROM    BL_SLMT_TYPE
		     WHERE   SLMT_TYPE_CODE = :d_slmt_type_code
		     AND acc_entity_code in ( select acc_entity_code from sy_acc_entity
					      where acc_entity_id = :nd_facility_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_DESC into :b0  from BL_SLMT_TYPE where (SLMT\
_TYPE_CODE=:b1 and acc_entity_code in (select acc_entity_code  from sy_acc_ent\
ity where acc_entity_id=:b2))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )706;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_desc;
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


    if(OERROR)
	{   
	err_mesg("FETCH failed on cursor SLMT_TYPE_CUR",0,"");
	}

   d_slmt_type_desc.arr[d_slmt_type_desc.len]  = '\0';

   fprintf(fp,"%5s Settlement Type  : %s\n\n"," ",d_slmt_type_desc.arr);

   if (d_slmt_doc_ref_desc.arr[0])
		fprintf(fp,"%5s Cheque/Card No   : %-20s  Date : %10s\n\n"," ",d_slmt_doc_ref_desc.arr, d_slmt_doc_ref_date.arr);
   else
        fprintf(fp,"%5s Cheque/Card No   : %-20s  Date : %10s\n\n"," ","____________________________", "_______________");
   
   if (d_slmt_doc_remarks.arr[0])
	   fprintf(fp,"%5s Bank Card/Co.Name: %-30s\n\n\n\n\n"," ",d_slmt_doc_remarks.arr);
   else
	   fprintf(fp,"%5s Bank Card/Co.Name: %-30s\n\n\n\n\n"," ","______________________________");
   
   fprintf(fp,"%5s Cashier   : %s       Counter : %s       Shift: %s \n\n"," ",nd_cashier.arr,d_cash_counter_code.arr,d_shift_id.arr);

   fprintf(fp,"%5s ________________________________________________________________________\n\n"," ");

   fprintf(fp,"\n%5s _____________________\n"," ");
   fprintf(fp,"%5s Signature     \n\n\n\n"," ");
   fprintf(fp,"%5s Full Name         : __________________________________________\n\n\n", " ");
   fprintf(fp,"%5s Id or Passport No.: ___________________\n\f", " ");

//disp_message(ERR_MESG," check 6");
}

update_rec()
{
    /* EXEC SQL UPDATE BL_RECEIPT_REFUND_HDR
             SET PRINT_FLAG = 'Y'
			 where DOC_TYPE_CODE 	= :d_doc_type_code
			AND DOC_NUMBER  = :d_doc_number; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_RECEIPT_REFUND_HDR  set PRINT_FLAG='Y' where (D\
OC_TYPE_CODE=:b0 and DOC_NUMBER=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )733;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
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



             //WHERE ROWID = :d_rowid;

     if (OERROR)
	{   
         err_mesg("UPDATE failed on table BL_RECEIPT_REFUND_HDR",0,"");
}
}
