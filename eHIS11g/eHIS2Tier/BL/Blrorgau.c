
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrorgau.pc"
};


static unsigned int sqlctx = 1288468275;


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
            void  *sqhstv[28];
   unsigned int   sqhstl[28];
            int   sqhsts[28];
            void  *sqindv[28];
            int   sqinds[28];
   unsigned int   sqharm[28];
   unsigned int   *sqharc[28];
   unsigned short  sqadto[28];
   unsigned short  sqtdso[28];
} sqlstm = {12,28};

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
"1/01/3000'),'DD/MM/YYYY')) and ADDED_BY_ID between NVL(:b7,'                \
    ') and NVL(:b7,'~~~~~~~~~~~~~~~~~~~~')) and NVL(POSTED_FLAG,'N')='Y') orde\
r by DOC_TYPE_CODE,DOC_NUMBER            ";

 static const char *sq0008 = 
"select SHORT_NAME_LOC_LANG ,short_name  from MP_PATIENT_MAST where PATIENT_I\
D=:b0           ";

 static const char *sq0009 = 
"select SHORT_DESC  from BL_BILL_TYPE_LANG_VW where (BILL_TYPE_CODE=:b0 and L\
ANGUAGE_ID=:b1)           ";

 static const char *sq0007 = 
"select LINE_NUM ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROUP_CO\
DE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,TO_CHAR(NVL(\
DOC_AMT,0),'999,999,990.99') ,DOC_AMT ,NARRATION  from BL_DCP_ORG_TRN_DTL wher\
e ((operating_facility_id=:b0 and DOC_TYPE_CODE=:b1) and DOC_NUMBER=:b2) order\
 by LINE_NUM            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,146,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,216,0,4,182,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
91,0,0,3,158,0,4,225,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
126,0,0,4,0,0,30,265,0,0,0,0,0,1,0,
141,0,0,5,91,0,2,273,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
164,0,0,6,1219,0,9,377,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
215,0,0,6,0,0,13,444,0,0,28,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,
342,0,0,7,0,0,13,545,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
401,0,0,8,92,0,9,598,0,0,1,1,0,1,0,1,9,0,0,
420,0,0,8,0,0,13,603,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
443,0,0,10,508,0,6,617,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
470,0,0,9,102,0,9,655,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
493,0,0,9,0,0,13,660,0,0,1,0,0,1,0,2,9,0,0,
512,0,0,7,334,0,9,689,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
539,0,0,11,245,0,4,871,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
586,0,0,12,245,0,4,895,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
633,0,0,13,96,0,4,1001,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
656,0,0,14,162,0,6,1009,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
687,0,0,15,195,0,6,1036,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
714,0,0,16,210,0,6,1061,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
741,0,0,17,216,0,6,1086,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
768,0,0,18,186,0,6,1111,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
795,0,0,19,196,0,6,1138,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/*****************************************************************************/
/*                           BLRORGAU.PC                                     */
/*****************************************************************************/

/*
#define DEBUG 
*/                   

#include <stdio.h>
#include <string.h>
#include <bl.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 

 
    /* VARCHAR uid_pwd			[91],      
	    d_session_id		[16], 
	    d_pgm_date			[14],
        rep_date			[20],
        comp_name			[50],     
        nd_facility_id		[3],
	    nd_fm_doc_type_code	[7],
	    nd_fm_doc_no		[9],
	    nd_to_doc_type_code	[7],
	    nd_to_doc_no		[9],
	    nd_fm_doc_date		[11],
		nd_fm_doc_date1		[12],
	    nd_to_doc_date		[11],
		nd_to_doc_date1		[12],
        nd_operator_id		[21],
        oper_id				[21],
	    d_main_desc			[16],
	    d_dept_desc			[16],
	    d_product_desc		[16],
	    d_subledger_desc	[16],  
	    d_dept_long_desc	[32],   
	    d_acct_desc			[65]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_no;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_no;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date1;

struct { unsigned short len; unsigned char arr[11]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date1;

struct { unsigned short len; unsigned char arr[21]; } nd_operator_id;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[16]; } d_main_desc;

struct { unsigned short len; unsigned char arr[16]; } d_dept_desc;

struct { unsigned short len; unsigned char arr[16]; } d_product_desc;

struct { unsigned short len; unsigned char arr[16]; } d_subledger_desc;

struct { unsigned short len; unsigned char arr[32]; } d_dept_long_desc;

struct { unsigned short len; unsigned char arr[65]; } d_acct_desc;
    

   /* VARCHAR d_doc_type_code           [7],
           d_doc_number              [9],
           d_patient_id              [21],
           d_short_name_full         [61],
		   d_patient_name            [61],
		   d_patient_nam1            [31],
		   d_patient_name_loc_lang   [61],
           d_doc_date                [13],
           d_due_date                [13],
           d_trx_type_code           [2],
           d_trx_type_desc           [4],
           d_episode_type            [2],
           d_episode_id              [9],
           d_visit_id                [5],
           d_pat_doc_reference       [11],
           d_bill_type_code          [3],
		   d_bill_short_desc         [16],
           d_doc_nature_code         [5],
           d_doc_amt                 [23],
           d_hosp_chg_amt            [23],
           d_drfee_chg_amt           [23],
           d_main_acc1_code          [7],
           d_main_acc2_code          [5],
           d_dept_code               [7],
           d_product_group_code      [4],
           d_product_line_code       [5],
           d_subledger_group_code    [4],
           d_subledger_line_code     [9],
           d_narration               [51],
           d_post_month              [3],
           d_post_year               [5],
		   d_post_year1              [5],
		   d_posted_by_id            [21],
		   d_posted_date_time        [20]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[31]; } d_patient_nam1;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[13]; } d_doc_date;

struct { unsigned short len; unsigned char arr[13]; } d_due_date;

struct { unsigned short len; unsigned char arr[2]; } d_trx_type_code;

struct { unsigned short len; unsigned char arr[4]; } d_trx_type_desc;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[11]; } d_pat_doc_reference;

struct { unsigned short len; unsigned char arr[3]; } d_bill_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_bill_short_desc;

struct { unsigned short len; unsigned char arr[5]; } d_doc_nature_code;

struct { unsigned short len; unsigned char arr[23]; } d_doc_amt;

struct { unsigned short len; unsigned char arr[23]; } d_hosp_chg_amt;

struct { unsigned short len; unsigned char arr[23]; } d_drfee_chg_amt;

struct { unsigned short len; unsigned char arr[7]; } d_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } d_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_subledger_line_code;

struct { unsigned short len; unsigned char arr[51]; } d_narration;

struct { unsigned short len; unsigned char arr[3]; } d_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_post_year;

struct { unsigned short len; unsigned char arr[5]; } d_post_year1;

struct { unsigned short len; unsigned char arr[21]; } d_posted_by_id;

struct { unsigned short len; unsigned char arr[20]; } d_posted_date_time;


   /* VARCHAR d_dtl_line_num				[5],
           d_dtl_main_acc1_code			[7],
           d_dtl_main_acc2_code			[5],
           d_dtl_dept_code				[7],
           d_dtl_product_group_code		[4],
           d_dtl_product_line_code      [5],
           d_dtl_subledger_group_code   [4],
           d_dtl_subledger_line_code    [9],
           d_dtl_doc_amt                [23],
           d_dtl_narration              [51]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_dtl_line_num;

struct { unsigned short len; unsigned char arr[7]; } d_dtl_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_dtl_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } d_dtl_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_dtl_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_dtl_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_dtl_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_dtl_subledger_line_code;

struct { unsigned short len; unsigned char arr[23]; } d_dtl_doc_amt;

struct { unsigned short len; unsigned char arr[51]; } d_dtl_narration;


   /* VARCHAR nd_lang_id			[4],
		   l_translated_value	[201],
	       l_pk_value			[100],
		   nd_temp_date			[20],
		   nd_loc_date			[20],
		   nd_temp_date1		[12],
		   nd_loc_date1			[12],
		   nd_temp_date2		[5],
		   nd_loc_date2			[5],
		   date_convert			[20]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[12]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[5]; } nd_temp_date2;

struct { unsigned short len; unsigned char arr[5]; } nd_loc_date2;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

		   

char       nd_print_flag;

char	   string_var[100];
char	   loc_legend[999][201];

double    d_doc_amt_num;

int i=0;

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
    g_hdr_cnt;

char filename[150],g_acct_code[41];

double g_tot_amt,g_grand_tot;

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc < 5) {
        disp_message(ERR_MESG,"BLRORGAU : Usage BLRORGAU userid/password session_id pgm_date");
        proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(g_pgm_id,"BLRORGAU");
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



    if(OERROR) {
		disp_message(ERR_MESG,"Unable to connect to oracle.");
		proc_exit();
    }

   set_meduser_role();
   strcpy(nd_lang_id.arr,l_language_id.arr);
   nd_lang_id.len = l_language_id.len;

   start_prog_msg();

    nd_fm_doc_type_code.arr[0]  = '\0';
	nd_fm_doc_no.arr[0]			= '\0';
	nd_to_doc_type_code.arr[0]  = '\0';
	nd_to_doc_no.arr[0]			= '\0';
    nd_fm_doc_date.arr[0]		= '\0';
	nd_fm_doc_date1.arr[0]		= '\0';
	nd_to_doc_date.arr[0]		= '\0';
	nd_to_doc_date1.arr[0]		= '\0';
	nd_operator_id.arr[0]		= '\0';
	nd_facility_id.arr[0]		= '\0';

    nd_fm_doc_type_code.len  = 0;
	nd_fm_doc_no.len		 = 0;
	nd_to_doc_type_code.len  = 0;
	nd_to_doc_no.len		 = 0;
    nd_fm_doc_date.len		 = 0;
	nd_fm_doc_date1.len		 = 0;
	nd_to_doc_date.len		 = 0;
	nd_to_doc_date1.len		 = 0;
	nd_operator_id.len		 = 0;
    nd_facility_id.len		 = 0;


	/* EXEC SQL SELECT operating_facility_id,PARAM1,            /o FM_DOC_TYPE_CODE           o/
			PARAM2,											 /o FM_DOC_NO                  o/
			PARAM3,										     /o TO_DOC_TYPE_CODE           o/
			PARAM4,											 /o TO_DOC_NO                  o/
			PARAM5,										     /o FM_DOC_DATE                o/
			PARAM6,											 /o TO_DOC_DATE                o/
			PARAM7											 /o OPER_IDl                   o/     
		 INTO   :nd_facility_id,:nd_fm_doc_type_code,
			:nd_fm_doc_no,
			:nd_to_doc_type_code,
			:nd_to_doc_no,
		    :nd_fm_doc_date,
			:nd_to_doc_date,
			:nd_operator_id 
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRORGAU'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_PA\
RAM where ((PGM_ID='BLRORGAU' and PGM_DATE=:b8) and SESSION_ID=TO_NUMBER(:b9))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_no;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_no;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_date;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
 sqlstm.sqhstl[6] = (unsigned int  )13;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_operator_id;
 sqlstm.sqhstl[7] = (unsigned int  )23;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[8] = (unsigned int  )16;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_session_id;
 sqlstm.sqhstl[9] = (unsigned int  )18;
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
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

    nd_fm_doc_type_code.arr[nd_fm_doc_type_code.len]	= '\0';
	nd_fm_doc_no.arr[nd_fm_doc_no.len]					= '\0';
	nd_to_doc_type_code.arr[nd_to_doc_type_code.len]	= '\0';
	nd_to_doc_no.arr[nd_to_doc_no.len]					= '\0';
    nd_fm_doc_date.arr[nd_fm_doc_date.len]				= '\0';
	nd_to_doc_date.arr[nd_to_doc_date.len]				= '\0';
	nd_fm_doc_date1.arr[nd_fm_doc_date1.len]			= '\0';
	nd_to_doc_date1.arr[nd_to_doc_date1.len]			= '\0';
	nd_operator_id.arr[nd_operator_id.len]				= '\0';

    //strcpy(file_name,"blrorgau.lis");
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrorgau.lis");

    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file...");
	proc_exit();
    }


    /* EXEC SQL SELECT ACC_ENTITY_NAME,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
	     INTO   :comp_name,
				:rep_date,
				:oper_id
	     FROM   SY_ACC_ENTITY_LANG_VW
		 WHERE acc_entity_id = :nd_facility_id
		 AND   LANGUAGE_ID	 = :nd_lang_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:\
b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )91;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_lang_id;
    sqlstm.sqhstl[4] = (unsigned int  )6;
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



    if(OERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    if(rep_date.arr[0]!='\0')
	{
		init_date_temp_var();
		strcpy(date_convert.arr,rep_date.arr);
		fun_change_loc_date1();
		strcpy(rep_date.arr,date_convert.arr);
	}

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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )126;
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
         WHERE  PGM_ID     = 'BLRORGAU' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRORGAU' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )141;
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



    if(OERROR) 
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 

}


decl_curs()
{

    /*Changed the WHERE clause since the output was not coming
	if doc numbers are entered*/
    /* EXEC SQL DECLARE ORG_TRN_HDR_CUR CURSOR FOR
               SELECT DOC_TYPE_CODE,
                      DOC_NUMBER,
                      PATIENT_ID,
                      TRUNC(DOC_DATE),
                      TRUNC(DUE_DATE),
                      TRX_TYPE_CODE,
		      DECODE(TRX_TYPE_CODE,'1','INV','2','DN','3','CN',
					   '4','ADJ','5','REC','6','PAY',''),
                      EPISODE_TYPE,
                      LTRIM(TO_CHAR(EPISODE_ID,'00000009')),
                      VISIT_ID,
                      PAT_DOC_REFERENCE,
                      BILL_TYPE_CODE,
                      DOC_NATURE_CODE,
                      TO_CHAR(NVL(DOC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(HOSP_CHG_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(DRFEE_CHG_AMT,0),'999,999,990.99'),
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
		      POSTED_BY_ID,
		      TO_CHAR(POSTED_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')
                 FROM BL_DCP_ORG_TRN_HDR
		 WHERE  operating_facility_id = :nd_facility_id and
		 RPAD(DOC_TYPE_CODE,6,' ') BETWEEN
			   RPAD(NVL(:nd_fm_doc_type_code,'      '),6) AND
			   RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6)
		 AND   LTRIM(TO_CHAR(DOC_NUMBER,'00000009')) BETWEEN
			   NVL(LPAD(:nd_fm_doc_no, 8, '0'),'00000000') AND
			   NVL(LPAD(:nd_to_doc_no, 8, '0'),'99999999')
		 /oRPAD(DOC_TYPE_CODE,6,' ')||
		       LTRIM(TO_CHAR(DOC_NUMBER,'00000009')) BETWEEN
	               RPAD(NVL(:nd_fm_doc_type_code,'      '),6)||
		       NVL(:nd_fm_doc_no,'00000000') AND
	               RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6)||
		       NVL(:nd_to_doc_no,'99999999')o/
		 AND   TRUNC(DOC_DATE) BETWEEN
			 TO_DATE(NVL(:nd_fm_doc_date,'01/01/1000'),'DD/MM/YYYY')
			 AND
			 TO_DATE(NVL(:nd_to_doc_date,'01/01/3000'),'DD/MM/YYYY')
		 AND   ADDED_BY_ID BETWEEN
			 NVL(:nd_operator_id,'                    ') AND
			 NVL(:nd_operator_id,'~~~~~~~~~~~~~~~~~~~~')
		 AND   NVL(POSTED_FLAG,'N') = 'Y'
		 ORDER BY DOC_TYPE_CODE, DOC_NUMBER; */ 



     /* EXEC SQL DECLARE ORG_TRN_DTL_CUR CURSOR FOR
               SELECT LINE_NUM,
                      MAIN_ACC1_CODE,
                      MAIN_ACC2_CODE,
                      DEPT_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
                      TO_CHAR(NVL(DOC_AMT,0),'999,999,990.99'),
					  DOC_AMT,
                      NARRATION
					  FROM BL_DCP_ORG_TRN_DTL
		WHERE operating_facility_id = :nd_facility_id and
			  DOC_TYPE_CODE = :d_doc_type_code
			  AND   DOC_NUMBER    = :d_doc_number
			  ORDER BY LINE_NUM; */ 


    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
	     SELECT /o substr(SHORT_NAME,1,30),
				 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname2,
				 o/
				 SHORT_NAME_LOC_LANG,
                         short_name
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :d_patient_id; */ 


    /* EXEC SQL DECLARE BL_BILL_TYPE_CUR CURSOR FOR
	     SELECT  SHORT_DESC
	     FROM    BL_BILL_TYPE_LANG_VW
	     WHERE   BILL_TYPE_CODE = :d_bill_type_code
		 AND     LANGUAGE_ID	= :nd_lang_id; */ 


    /* EXEC SQL OPEN ORG_TRN_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select DOC_TYPE_CODE ,DOC_NUMBER ,PATIENT_ID ,TRUNC(DOC_DATE) ,TRUNC(\
DUE_DATE) ,TRX_TYPE_CODE ,DECODE(TRX_TYPE_CODE,'1','INV','2','DN','3','CN','\
4','ADJ','5','REC','6','PAY','') ,EPISODE_TYPE ,LTRIM(TO_CHAR(EPISODE_ID,'00\
000009')) ,VISIT_ID ,PAT_DOC_REFERENCE ,BILL_TYPE_CODE ,DOC_NATURE_CODE ,TO_\
CHAR(NVL(DOC_AMT,0),'999,999,990.99') ,TO_CHAR(NVL(HOSP_CHG_AMT,0),'999,999,\
990.99') ,TO_CHAR(NVL(DRFEE_CHG_AMT,0),'999,999,990.99') ,MAIN_ACC1_CODE ,MA\
IN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,SUBLEDGER_GR\
OUP_CODE ,SUBLEDGER_LINE_CODE ,NARRATION ,POST_MONTH ,POST_YEAR ,POSTED_BY_I\
D ,TO_CHAR(POSTED_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')  from BL_DCP_ORG_TRN_HD\
R where (((((operating_facility_id=:b0 and RPAD(DOC_TYPE_CODE,6,' ') between\
 RPAD(NVL(:b1,'      '),6) and RPAD(NVL(:b2,'~~~~~~'),6)) and LTRIM(TO_CHAR(\
DOC_NUMBER,'00000009')) between NVL(LPAD(:b3,8,'0'),'00000000') and NVL(LPAD\
(:b4,8,'0'),'99999999')) and TRUNC(DOC_DATE) between TO_DATE(NVL(:b5,'01/01/\
1000'),'DD/MM/YYYY') and TO_DATE(NVL(:b6,'0");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )164;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_no;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_no;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_operator_id;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_operator_id;
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


    if(OERROR)
	err_mesg("OPEN failed on cursor ORG_TRN_HDR_CUR",0,"");

}

fetch_hdr()
{

    d_doc_type_code.arr[0]                                            = '\0';
    d_doc_number.arr[0]                                               = '\0';
    d_patient_id.arr[0]                                               = '\0';
    d_doc_date.arr[0]                                                 = '\0';
    d_due_date.arr[0]                                                 = '\0';
    d_trx_type_code.arr[0]                                            = '\0';
    d_trx_type_desc.arr[0]                                            = '\0';
    d_episode_type.arr[0]                                             = '\0';
    d_episode_id.arr[0]                                               = '\0';
    d_visit_id.arr[0]                                                 = '\0';
    d_pat_doc_reference.arr[0]                                        = '\0';
    d_bill_type_code.arr[0]                                           = '\0';
    d_doc_nature_code.arr[0]                                          = '\0';
    d_doc_amt.arr[0]                                                  = '\0';
    d_hosp_chg_amt.arr[0]                                             = '\0';
    d_drfee_chg_amt.arr[0]                                            = '\0';
    d_main_acc1_code.arr[0]                                           = '\0';
    d_main_acc2_code.arr[0]                                           = '\0';
    d_dept_code.arr[0]                                                = '\0';
    d_product_group_code.arr[0]                                       = '\0';
    d_product_line_code.arr[0]                                        = '\0';
    d_subledger_group_code.arr[0]                                     = '\0';
    d_subledger_line_code.arr[0]                                      = '\0';
    d_narration.arr[0]                                                = '\0';
    d_post_month.arr[0]                                               = '\0';
    d_post_year.arr[0]                                                = '\0';
    d_posted_by_id.arr[0]                                             = '\0';
    d_posted_date_time.arr[0]                                         = '\0';

    d_doc_type_code.len                                               = 0;
    d_doc_number.len                                                  = 0;
    d_patient_id.len                                                  = 0;
    d_doc_date.len                                                    = 0;
    d_due_date.len                                                    = 0;
    d_trx_type_code.len                                               = 0;
    d_trx_type_desc.len                                               = 0;
    d_episode_type.len                                                = 0;
    d_episode_id.len                                                  = 0;
    d_visit_id.len                                                    = 0;
    d_pat_doc_reference.len                                           = 0;
    d_bill_type_code.len                                              = 0;
    d_doc_nature_code.len                                             = 0;
    d_doc_amt.len                                                     = 0;
    d_hosp_chg_amt.len                                                = 0;
    d_drfee_chg_amt.len                                               = 0;
    d_main_acc1_code.len                                              = 0;
    d_main_acc2_code.len                                              = 0;
    d_dept_code.len                                                   = 0;
    d_product_group_code.len                                          = 0;
    d_product_line_code.len                                           = 0;
    d_subledger_group_code.len                                        = 0;
    d_subledger_line_code.len                                         = 0;
    d_narration.len                                                   = 0;
    d_post_month.len                                                  = 0;
    d_post_year.len                                                   = 0;
    d_posted_by_id.len                                                = 0;
    d_posted_date_time.len                                            = 0;

     /* EXEC SQL FETCH ORG_TRN_HDR_CUR
               INTO :d_doc_type_code,
                    :d_doc_number,
                    :d_patient_id,
                    :d_doc_date,
                    :d_due_date,
                    :d_trx_type_code,
                    :d_trx_type_desc,
                    :d_episode_type,
                    :d_episode_id,
                    :d_visit_id,
                    :d_pat_doc_reference,
                    :d_bill_type_code,
                    :d_doc_nature_code,
                    :d_doc_amt,
                    :d_hosp_chg_amt,
                    :d_drfee_chg_amt,
                    :d_main_acc1_code,
                    :d_main_acc2_code,
                    :d_dept_code,
                    :d_product_group_code,
                    :d_product_line_code,
                    :d_subledger_group_code,
                    :d_subledger_line_code,
                    :d_narration,
                    :d_post_month,
                    :d_post_year,
                    :d_posted_by_id,
                    :d_posted_date_time; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 28;
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
     sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
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
     sqlstm.sqhstv[4] = (         void  *)&d_due_date;
     sqlstm.sqhstl[4] = (unsigned int  )15;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_trx_type_code;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_trx_type_desc;
     sqlstm.sqhstl[6] = (unsigned int  )6;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_episode_type;
     sqlstm.sqhstl[7] = (unsigned int  )4;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_episode_id;
     sqlstm.sqhstl[8] = (unsigned int  )11;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_visit_id;
     sqlstm.sqhstl[9] = (unsigned int  )7;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_pat_doc_reference;
     sqlstm.sqhstl[10] = (unsigned int  )13;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&d_bill_type_code;
     sqlstm.sqhstl[11] = (unsigned int  )5;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&d_doc_nature_code;
     sqlstm.sqhstl[12] = (unsigned int  )7;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&d_doc_amt;
     sqlstm.sqhstl[13] = (unsigned int  )25;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&d_hosp_chg_amt;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&d_drfee_chg_amt;
     sqlstm.sqhstl[15] = (unsigned int  )25;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&d_main_acc1_code;
     sqlstm.sqhstl[16] = (unsigned int  )9;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&d_main_acc2_code;
     sqlstm.sqhstl[17] = (unsigned int  )7;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&d_dept_code;
     sqlstm.sqhstl[18] = (unsigned int  )9;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&d_product_group_code;
     sqlstm.sqhstl[19] = (unsigned int  )6;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&d_product_line_code;
     sqlstm.sqhstl[20] = (unsigned int  )7;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&d_subledger_group_code;
     sqlstm.sqhstl[21] = (unsigned int  )6;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&d_subledger_line_code;
     sqlstm.sqhstl[22] = (unsigned int  )11;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&d_narration;
     sqlstm.sqhstl[23] = (unsigned int  )53;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&d_post_month;
     sqlstm.sqhstl[24] = (unsigned int  )5;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&d_post_year;
     sqlstm.sqhstl[25] = (unsigned int  )7;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&d_posted_by_id;
     sqlstm.sqhstl[26] = (unsigned int  )23;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&d_posted_date_time;
     sqlstm.sqhstl[27] = (unsigned int  )22;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor ORG_TRN_HDR_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_doc_type_code.arr[d_doc_type_code.len]                             = '\0';
    d_doc_number.arr[d_doc_number.len]                                   = '\0';
    d_patient_id.arr[d_patient_id.len]                                   = '\0';
    d_doc_date.arr[d_doc_date.len]                                       = '\0';
    d_due_date.arr[d_due_date.len]                                       = '\0';
    d_trx_type_code.arr[d_trx_type_code.len]                             = '\0';
    d_trx_type_desc.arr[d_trx_type_desc.len]                             = '\0';
    d_episode_type.arr[d_episode_type.len]                               = '\0';
    d_episode_id.arr[d_episode_id.len]                                   = '\0';
    d_visit_id.arr[d_visit_id.len]                                       = '\0';
    d_pat_doc_reference.arr[d_pat_doc_reference.len]                     = '\0';
    d_bill_type_code.arr[d_bill_type_code.len]                           = '\0';
    d_doc_nature_code.arr[d_doc_nature_code.len]                         = '\0';
    d_doc_amt.arr[d_doc_amt.len]                                         = '\0';
    d_hosp_chg_amt.arr[d_hosp_chg_amt.len]                               = '\0';
    d_drfee_chg_amt.arr[d_drfee_chg_amt.len]                             = '\0';
    d_main_acc1_code.arr[d_main_acc1_code.len]                           = '\0';
    d_main_acc2_code.arr[d_main_acc2_code.len]                           = '\0';
    d_dept_code.arr[d_dept_code.len]                                     = '\0';
    d_product_group_code.arr[d_product_group_code.len]                   = '\0';
    d_product_line_code.arr[d_product_line_code.len]                     = '\0';
    d_subledger_group_code.arr[d_subledger_group_code.len]               = '\0';
    d_subledger_line_code.arr[d_subledger_line_code.len]                 = '\0';
    d_narration.arr[d_narration.len]                                     = '\0';
    d_post_month.arr[d_post_month.len]                                   = '\0';
    d_post_year.arr[d_post_year.len]                                     = '\0';
    d_posted_by_id.arr[d_posted_by_id.len]                               = '\0';
    d_posted_date_time.arr[d_posted_date_time.len]                       = '\0';

    sprintf(g_acct_code,"%s-%s %s %s-%s %s-%s",
        d_main_acc1_code.arr, d_main_acc2_code.arr ,d_dept_code.arr ,
	d_product_group_code.arr, d_product_line_code.arr ,
	d_subledger_group_code.arr , d_subledger_line_code.arr);

    return 1;
    
}

fetch_dtl()
{

    d_dtl_line_num.arr[0]                                             = '\0';
    d_dtl_main_acc1_code.arr[0]                                       = '\0';
    d_dtl_main_acc2_code.arr[0]                                       = '\0';
    d_dtl_dept_code.arr[0]                                            = '\0';
    d_dtl_product_group_code.arr[0]                                   = '\0';
    d_dtl_product_line_code.arr[0]                                    = '\0';
    d_dtl_subledger_group_code.arr[0]                                 = '\0';
    d_dtl_subledger_line_code.arr[0]                                  = '\0';
    d_dtl_doc_amt.arr[0]                                              = '\0';
    d_dtl_narration.arr[0]                                            = '\0';

    d_dtl_line_num.len                                                = 0;
    d_dtl_main_acc1_code.len                                          = 0;
    d_dtl_main_acc2_code.len                                          = 0;
    d_dtl_dept_code.len                                               = 0;
    d_dtl_product_group_code.len                                      = 0;
    d_dtl_product_line_code.len                                       = 0;
    d_dtl_subledger_group_code.len                                    = 0;
    d_dtl_subledger_line_code.len                                     = 0;
    d_dtl_doc_amt.len                                                 = 0;
    d_dtl_narration.len                                               = 0;

    d_doc_amt_num = 0;
    
    /* EXEC SQL FETCH ORG_TRN_DTL_CUR
               INTO :d_dtl_line_num,
                    :d_dtl_main_acc1_code,
                    :d_dtl_main_acc2_code,
                    :d_dtl_dept_code,
                    :d_dtl_product_group_code,
                    :d_dtl_product_line_code,
                    :d_dtl_subledger_group_code,
                    :d_dtl_subledger_line_code,
                    :d_dtl_doc_amt,
		    :d_doc_amt_num,
                    :d_dtl_narration; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 28;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )342;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dtl_line_num;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_dtl_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_dtl_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_dtl_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_dtl_product_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_dtl_product_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_dtl_subledger_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_dtl_subledger_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )11;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_dtl_doc_amt;
    sqlstm.sqhstl[8] = (unsigned int  )25;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_doc_amt_num;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_dtl_narration;
    sqlstm.sqhstl[10] = (unsigned int  )53;
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




     if(OERROR)
	 err_mesg("FETCH failed on cursor ORG_TRN_DTL_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0; 

    d_dtl_line_num.arr[d_dtl_line_num.len]                               = '\0';
    d_dtl_main_acc1_code.arr[d_dtl_main_acc1_code.len]                   = '\0';
    d_dtl_main_acc2_code.arr[d_dtl_main_acc2_code.len]                   = '\0';
    d_dtl_dept_code.arr[d_dtl_dept_code.len]                             = '\0';
    d_dtl_product_group_code.arr[d_dtl_product_group_code.len]           = '\0';
    d_dtl_product_line_code.arr[d_dtl_product_line_code.len]             = '\0';
    d_dtl_subledger_group_code.arr[d_dtl_subledger_group_code.len]       = '\0';
    d_dtl_subledger_line_code.arr[d_dtl_subledger_line_code.len]         = '\0';
    d_dtl_doc_amt.arr[d_dtl_doc_amt.len]                                 = '\0';
    d_dtl_narration.arr[d_dtl_narration.len]                             = '\0';

    sprintf(g_acct_code,"%s-%s %s %s-%s %s-%s",
        d_dtl_main_acc1_code.arr, d_dtl_main_acc2_code.arr ,
	d_dtl_dept_code.arr , d_dtl_product_group_code.arr, 
	d_dtl_product_line_code.arr , d_dtl_subledger_group_code.arr , 
	d_dtl_subledger_line_code.arr);

    return 1;
    
}


fetch_patient_name()
{

    d_patient_name.arr[0]			= '\0';
	d_patient_nam1.arr[0]			= '\0';
    d_patient_name_loc_lang.arr[0]  = '\0';

    d_patient_name.len				= 0;
	d_patient_nam1.len				= 0;
    d_patient_name_loc_lang.len		= 0;

    /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 28;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )401;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

    /* EXEC SQL FETCH MP_PATIENT_MAST_CUR 
	     INTO  /o:d_patient_name,
			   :d_patient_nam1,o/
			   :d_patient_name_loc_lang,
                 :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 28;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )420;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_name_loc_lang;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_short_name_full;
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



    if(OERROR)
	err_mesg("FETCH failed on table MP_PATIENT_MAST_CUR",0,"");

    d_patient_name.arr[d_patient_name.len]					 = '\0';
	d_patient_nam1.arr[d_patient_nam1.len]					 = '\0';
    d_patient_name_loc_lang.arr[d_patient_name_loc_lang.len] = '\0';
    d_short_name_full.arr[d_short_name_full.len]             = '\0';
 
/* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :d_patient_nam1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_nam1    := :d_patient_nam1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 28;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :d_patient_name := str2 ; END IF ; blcommon . sp\
lit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NOT\
 NULL THEN :d_patient_nam1 := str2 ; END IF ; blcommon . split_words ( :d_shor\
t_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :d_patie\
nt_nam1 := :d_patient_nam1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )443;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )63;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
sqlstm.sqhstl[1] = (unsigned int  )63;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_patient_nam1;
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


       d_patient_name.arr[d_patient_name.len]  = '\0';
       d_patient_nam1.arr[d_patient_nam1.len]  = '\0';

}

fetch_bill_desc()
{

    d_bill_short_desc.arr[0]  = '\0';
    d_bill_short_desc.len  = 0;

    /* EXEC SQL OPEN BL_BILL_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 28;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )470;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_bill_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
    sqlstm.sqhstl[1] = (unsigned int  )6;
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
	err_mesg("OPEN failed on cursor BL_BILL_TYPE_CUR",0,"");

    /* EXEC SQL FETCH BL_BILL_TYPE_CUR
	     INTO  :d_bill_short_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 28;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )493;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_bill_short_desc;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_BILL_TYPE_CUR",0,"");

    d_bill_short_desc.arr[d_bill_short_desc.len]  = '\0';

}

do_report()
{

    int cnt,first;
    char s_amt[20];

    g_hdr_cnt=0;
    g_grand_tot = 0;
    line_no = 1;
    put_hdr();

    while(fetch_hdr()) {

        g_hdr_cnt ++;
        get_acct_desc_hdr();
		fetch_patient_name();
		fetch_bill_desc();
		put_trn_hdr();

	/* EXEC SQL OPEN ORG_TRN_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 28;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )512;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_number;
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



	if(OERROR)
	    err_mesg("OPEN failed on cursor ORG_TRN_DTL_CUR",0,"");

	g_tot_amt = 0;
        first=1;
	cnt = 0;
	while(fetch_dtl()) {
	    if(first) {
	        put_dtl_head();
	        first=0;
	    }
        get_acct_desc_dtl();
	    put_trn_dtl();
	    g_tot_amt += d_doc_amt_num;
	    cnt ++;
	}
	g_grand_tot += g_tot_amt;
	if(cnt) {
	   chk_break(3);
	   put_val(s_amt,g_tot_amt);
	   format_amt(s_amt);
       fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");
	   //fprintf(f1,"                                                                                                 TOTAL          %15s\n",s_amt);
       fprintf(f1,"                                                                                                 %-5.5s          %15s\n",loc_legend[39],s_amt);

	   fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n\n");

	   line_no += 4;

	}

    } 

    print_end_of_rep();

}


put_hdr()
{

  
	fprintf(f1,"\n%-6.6s : %-3.3s                               %30s                                           %s\n",loc_legend[1],loc_legend[2],comp_name.arr,rep_date.arr);
    fprintf(f1,"%-6.6s : %s\n",loc_legend[3],oper_id.arr);
    fprintf(f1,"%-6.6s : BLRORGAU                         %-40.40s                                       %-4.4s : %4d\n",loc_legend[4],loc_legend[5],loc_legend[6],page_no);
  //fprintf(f1,"\n\n");
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"%-8.8s/%-6.6s  %-8.8s   %-8.8s   %-8.8s %-9.9s          %6.6s      %9.9s     %10.10s\n",loc_legend[17],loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[23],loc_legend[24],loc_legend[25]);
    fprintf(f1,"                 %-9.9s & %-4.4s      %-6.6s   %-10.10s & %-4.4s                                        %-15.15s\n",loc_legend[26],loc_legend[27],loc_legend[28],loc_legend[29],loc_legend[30],loc_legend[31]);
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");

    line_no=10;

}

put_trn_hdr() 
{
    chk_break(5);

	if(d_doc_date.arr[0]!='\0')
	{
		init_date_temp_var();
		strcpy(date_convert.arr,d_doc_date.arr);
		fun_change_loc_date();
		strcpy(d_doc_date.arr,date_convert.arr);
	}

	 if(d_due_date.arr[0]!='\0')
	{
		init_date_temp_var();
		strcpy(date_convert.arr,d_due_date.arr);
		fun_change_loc_date();
		strcpy(d_due_date.arr,date_convert.arr);
	}

    fprintf(f1,"%-6s/%-8s  %10s %10s  %1s %3s   %-10s%s%s%s\n",
	d_doc_type_code.arr,d_doc_number.arr,d_doc_date.arr,d_due_date.arr,
	d_trx_type_code.arr,d_trx_type_desc.arr,d_pat_doc_reference.arr,
	d_doc_amt.arr, d_hosp_chg_amt.arr,d_drfee_chg_amt.arr);
    
	if(strcmp(nd_lang_id.arr,"en")==0)
	{
		fprintf(f1,"                 %-2s %-15s    %-4s  %-20s %-30.30s      %1s %-8s %4s\n",
		d_bill_type_code.arr, d_bill_short_desc.arr,d_doc_nature_code.arr,
		d_patient_id.arr,d_patient_name.arr, d_episode_type.arr,
		d_episode_id.arr,d_visit_id.arr);

		fprintf(f1,"          %-3.3s :  %-40s  %-30.30s\n",loc_legend[38],g_acct_code,d_patient_name.arr);


	}
	else
	{

		fprintf(f1,"                 %-2s %-15s    %-4s  %-20s %-30.30s      %1s %-8s %4s\n",
        d_bill_type_code.arr, d_bill_short_desc.arr,d_doc_nature_code.arr,
		d_patient_id.arr,d_patient_name_loc_lang.arr, d_episode_type.arr,
		d_episode_id.arr,d_visit_id.arr);
    
    	fprintf(f1,"          %-3.3s :  %-40s  %-30.30s\n",loc_legend[38],g_acct_code,d_patient_name_loc_lang.arr);

	}
	

	if(strlen(d_patient_nam1.arr) > 2)
	{
	  if(strcmp(nd_lang_id.arr,"en")==0)
	   fprintf(f1,"%57.57s %s \n"," ",d_patient_nam1.arr);
	  else
	   fprintf(f1,"%57.57s %s \n"," ",d_patient_name_loc_lang.arr);
	  line_no++;
	}

    fprintf(f1,"                 %s\n", d_acct_desc.arr);

	if(d_post_year.arr[0]!='\0')
	{
		init_date_temp_var();
		strcpy(date_convert.arr,d_post_year.arr);
		fun_change_loc_date2();
		strcpy(d_post_year.arr,date_convert.arr);
		
	}
	
	if(d_posted_date_time.arr[0]!='\0')
	{
		init_date_temp_var();
		strcpy(date_convert.arr,d_posted_date_time.arr);
		fun_change_loc_date4();
		strcpy(d_posted_date_time.arr,date_convert.arr);
	}

    fprintf(f1,"    %-9.9s :  %-50s    %-6.6s : %-2s/%-4s\n",loc_legend[32],d_narration.arr,loc_legend[33],d_post_month.arr,d_post_year.arr);
    fprintf(f1,"    %-9.9s :  %-20s    %-11.11s : %-20s\n\n",loc_legend[34],d_posted_by_id.arr,loc_legend[35],d_posted_date_time.arr);
 
    line_no += 7;

/* "XXXXXX/XXXXXXXX  XX/XX/XXXX XX/XX/XXXX     X    XXXXXXXXXX 999,999,990.99 999,999,999.99 999,999,999.99"
	       "                 XX XXXXXXXXXXXXXXX    XXXX     XXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X 99999999 9999"
	       "                 XXXXXX-XXXX XXXXXX XXX-XXXX XXX-XXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXX                "
	       "  
*/

}

put_dtl_head()
{

    chk_break(3);

    fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(f1,"    %-4.4s         %-15.15s                            %-9.9s                                                    %6.6s\n",loc_legend[36],loc_legend[37],loc_legend[32],loc_legend[23]);
    fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");

    line_no += 3;

}

put_trn_dtl()
{

    chk_break(2);
    fprintf(f1,"    %4s         %-40s   %-50s  %s\n",
        d_dtl_line_num.arr,g_acct_code,
	d_dtl_narration.arr,d_dtl_doc_amt.arr);
    fprintf(f1,"                 %s\n",d_acct_desc.arr);

    line_no += 2;
/*
	       "    XXXX         XXXXXX-XXXX XXXXXX XXX-XXXX XXX-XXXXXXXX   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX   999,999,999.99"
*/

}

get_acct_desc_hdr()
{

    d_acct_desc.arr[0] = '\0';

    /* EXEC SQL SELECT CONCAT_POST_ACC_DESC 
	     INTO   :d_acct_desc 
	     FROM   GL_POSTING_ACC
	     WHERE  MAIN_ACC1_CODE       =  :d_main_acc1_code
	     AND    MAIN_ACC2_CODE       =  :d_main_acc2_code
	     AND    DEPT_CODE            =  :d_dept_code
	     AND    PRODUCT_GROUP_CODE   =  :d_product_group_code
	     AND    PRODUCT_LINE_CODE    =  :d_product_line_code
	     AND    SUBLEDGER_GROUP_CODE =  :d_subledger_group_code
	     AND    SUBLEDGER_LINE_CODE  =  :d_subledger_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 28;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CONCAT_POST_ACC_DESC into :b0  from GL_POSTING_ACC\
 where ((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and\
 PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:\
b6) and SUBLEDGER_LINE_CODE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )539;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_acct_desc;
    sqlstm.sqhstl[0] = (unsigned int  )67;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_product_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_product_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_subledger_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_subledger_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )11;
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



    if(OERROR)
	err_mesg("SELECT failed on table GL_POSTING_ACC",0,"");


    d_acct_desc.arr[d_acct_desc.len] = '\0';

}

get_acct_desc_dtl()
{

    d_acct_desc.arr[0] = '\0';

    /* EXEC SQL SELECT CONCAT_POST_ACC_DESC 
	     INTO   :d_acct_desc 
	     FROM   GL_POSTING_ACC
	     WHERE  MAIN_ACC1_CODE       =  :d_dtl_main_acc1_code
	     AND    MAIN_ACC2_CODE       =  :d_dtl_main_acc2_code
	     AND    DEPT_CODE            =  :d_dtl_dept_code
	     AND    PRODUCT_GROUP_CODE   =  :d_dtl_product_group_code
	     AND    PRODUCT_LINE_CODE    =  :d_dtl_product_line_code
	     AND    SUBLEDGER_GROUP_CODE =  :d_dtl_subledger_group_code
	     AND    SUBLEDGER_LINE_CODE  =  :d_dtl_subledger_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 28;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CONCAT_POST_ACC_DESC into :b0  from GL_POSTING_ACC\
 where ((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and\
 PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:\
b6) and SUBLEDGER_LINE_CODE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )586;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_acct_desc;
    sqlstm.sqhstl[0] = (unsigned int  )67;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_dtl_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_dtl_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_dtl_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_dtl_product_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_dtl_product_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_dtl_subledger_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_dtl_subledger_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )11;
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



    if(OERROR)
	err_mesg("SELECT failed on table GL_POSTING_ACC",0,"");


    d_acct_desc.arr[d_acct_desc.len] = '\0';


}

chk_break(nol)
int nol;
{

	if(line_no+nol >= 55) {
           fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
	}

}

put_inp_parm()
{

	if(strcmp(nd_fm_doc_type_code.arr,"\0")==0)
	strcpy(nd_fm_doc_type_code.arr,loc_legend[15]);
	if(strcmp(nd_to_doc_type_code.arr,"\0")==0)
	strcpy(nd_to_doc_type_code.arr,loc_legend[16]);
	if(strcmp(nd_fm_doc_no.arr,"\0")==0)
	strcpy(nd_fm_doc_no.arr,loc_legend[15]);
	if(strcmp(nd_to_doc_no.arr,"\0")==0)
	strcpy(nd_to_doc_no.arr,loc_legend[16]);
	
	if(strcmp(nd_fm_doc_date.arr,"\0")==0)
	strcpy(nd_fm_doc_date1.arr,loc_legend[15]);
	else
	{
	
		init_date_temp_var();
		strcpy(date_convert.arr,nd_fm_doc_date.arr);
		fun_change_loc_date3();
		strcpy(nd_fm_doc_date1.arr,date_convert.arr);

	}
	if(strcmp(nd_to_doc_date.arr,"\0")==0)
	strcpy(nd_to_doc_date1.arr,loc_legend[16]);
	else
	{
	
		init_date_temp_var();
		strcpy(date_convert.arr,nd_to_doc_date.arr);
		fun_change_loc_date3();
		strcpy(nd_to_doc_date1.arr,date_convert.arr);

	}
   
	fprintf(f1,"%-6.6s : %-3.3s                               %30s                                           %s\n",loc_legend[1],loc_legend[2],comp_name.arr,rep_date.arr);
    fprintf(f1,"%-6.6s : %s\n",loc_legend[3],oper_id.arr);
    fprintf(f1,"%-6.6s : BLRORGAU                         %-40.40s                                       %-4.4s : %4d\n",loc_legend[4],loc_legend[5],loc_legend[6],page_no);
 	fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n\n");
    fprintf(f1,"VER : 1.10.01\n");
    fprintf(f1,"\n\n\n\n");
  	fprintf(f1,"\t%-16.16s\n",loc_legend[7]);
    fprintf(f1,"\t----------------\n\n");
	fprintf(f1,"\t\t%-15.15s       : %-s\n\n",loc_legend[8],nd_facility_id.arr);
    fprintf(f1,"\t\t%-15.15s %-5.5s : %-6s\n",loc_legend[9],loc_legend[13],nd_fm_doc_type_code.arr);
    fprintf(f1,"\t\t%-15.15s %-5.5s : %-6s\n\n"," ",loc_legend[14],nd_to_doc_type_code.arr);
    fprintf(f1,"\t\t%-15.15s %-5.5s : %-s\n",loc_legend[10],loc_legend[13],nd_fm_doc_no.arr);
    fprintf(f1,"\t\t%-15.15s %-5.5s : %-s\n\n"," ",loc_legend[14],nd_to_doc_no.arr);
    fprintf(f1,"\t\t%-15.15s %-5.5s : %-s\n",loc_legend[11],loc_legend[13],nd_fm_doc_date1.arr);
    fprintf(f1,"\t\t%-15.15s %-5.5s : %-s\n\n"," ",loc_legend[14],nd_to_doc_date1.arr);
    fprintf(f1,"\t\t%-15.15s       : %-s\n\n",loc_legend[12],nd_operator_id.arr);
    fprintf(f1,"");
    ++page_no;

}


print_end_of_rep()
{
    char s_amt[20];

    put_val(s_amt,g_grand_tot);
    format_amt(s_amt);
    fprintf(f1,"%-33.33s : %d                                                      %-11.11s          %15s\n",loc_legend[40],g_hdr_cnt,loc_legend[41],s_amt);
	fprintf(f1,"                                                    ** %-13.13s **                                                             \n",loc_legend[42]);
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';
     
		/* EXEC SQL SELECT LTRIM(RTRIM('BLRORGAU.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 28;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRORGAU.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )633;
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
			blcommon.get_local_lang_desc(:nd_facility_id ,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:nd_lang_id);

      

		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 28;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )656;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqhstv[3] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
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

/* Added by Raghava at 27/11/2007 for Internationalization Date Conversion */

get_local_date()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
		
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YY'),:nd_lang_id,t_date);

		 :nd_loc_date1:= to_char(t_date,'DD-MON-YY');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 28;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date1 , 'DD/MM/YY' ) , :nd_lang_id , t_date ) ; \
:nd_loc_date1 := to_char ( t_date , 'DD-MON-YY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )687;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date1;
 sqlstm.sqhstl[0] = (unsigned int  )14;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[2] = (unsigned int  )14;
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

get_local_date1()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		 get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YY HH24:MI'),:nd_lang_id,t_date);

		 :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 28;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YY HH24:MI' ) , :nd_lang_id , t_da\
te ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )714;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
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
        err_mesg("SELECTING Date failed",0,"");


}

get_local_date4()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		 get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YY HH24:MI:SS'),:nd_lang_id,t_date);

		 :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI:SS');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 28;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YY HH24:MI:SS' ) , :nd_lang_id , t\
_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH24:MI:SS' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )741;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
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
        err_mesg("SELECTING Date failed",0,"");


}

get_local_date2()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		 get_locale_date.convert_to_locale_date(to_date(:nd_temp_date2,'YYYY'),:nd_lang_id,t_date);

		 :nd_loc_date2 := to_char(t_date,'YYYY');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 28;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date2 , 'YYYY' ) , :nd_lang_id , t_date ) ; :nd_\
loc_date2 := to_char ( t_date , 'YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )768;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date2;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date2;
 sqlstm.sqhstl[2] = (unsigned int  )7;
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


		
		nd_loc_date2.arr[nd_loc_date2.len]='\0';
		
		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");


}

get_local_date3()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
		
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YY'),:nd_lang_id,t_date);

		 :nd_loc_date1:= to_char(t_date,'DD/MM/YYYY');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 28;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date1 , 'DD/MM/YY' ) , :nd_lang_id , t_date ) ; \
:nd_loc_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )795;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date1;
 sqlstm.sqhstl[0] = (unsigned int  )14;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[2] = (unsigned int  )14;
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

nd_temp_date.arr[0] =  '\0';
nd_loc_date.arr[0]  =  '\0';
nd_temp_date1.arr[0]=  '\0';
nd_loc_date1.arr[0] =  '\0';
nd_temp_date2.arr[0]=  '\0';
nd_loc_date2.arr[0] =  '\0';
date_convert.arr[0] =  '\0';
d_post_year1.arr[0]	=  '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
nd_temp_date1.len= 0;
nd_loc_date1.len = 0;
date_convert.len = 0;
nd_temp_date2.len =0;
nd_loc_date2.len  =0;
d_post_year1.len  =0;
}

fun_change_loc_date()
{

strcpy(nd_temp_date1.arr,date_convert.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);

get_local_date();

strcpy(date_convert.arr,nd_loc_date1.arr); 

}

fun_change_loc_date1()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date1();

strcpy(date_convert.arr,nd_loc_date.arr); 
}

fun_change_loc_date2()
{

strcpy(nd_temp_date2.arr,date_convert.arr);
nd_temp_date2.len = strlen(nd_temp_date2.arr);

get_local_date2();

strcpy(date_convert.arr,nd_loc_date2.arr); 
}

fun_change_loc_date3()
{

strcpy(nd_temp_date1.arr,date_convert.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);

get_local_date3();

strcpy(date_convert.arr,nd_loc_date1.arr); 

}

fun_change_loc_date4()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date4();

strcpy(date_convert.arr,nd_loc_date.arr); 
}

/* upto here */