
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blralled.pc"
};


static unsigned int sqlctx = 1288466187;


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
            void  *sqhstv[12];
   unsigned int   sqhstl[12];
            int   sqhsts[12];
            void  *sqindv[12];
            int   sqinds[12];
   unsigned int   sqharm[12];
   unsigned int   *sqharc[12];
   unsigned short  sqadto[12];
   unsigned short  sqtdso[12];
} sqlstm = {12,12};

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
"select DOC_TYPE_CODE ,DOC_NUMBER ,PATIENT_ID ,TO_CHAR(DOC_DATE,'DD/MM/YYYY')\
 ,TRX_TYPE_CODE ,DECODE(TRX_TYPE_CODE,'1','INV','2','DN','3','CN','4','ADJ','5\
','REC','6','PAY','') ,PAT_DOC_REFERENCE ,TO_CHAR(NVL(DOC_AMT,0),'999,999,990.\
99') ,DOC_AMT ,NARRATION ,POST_MONTH ,POST_YEAR  from BL_DCP_ALL_TRN_HDR where\
 ((((operating_facility_id=:b0 and (RPAD(DOC_TYPE_CODE,6,' ')||LTRIM(TO_CHAR(D\
OC_NUMBER,'00000009'))) between (RPAD(NVL(:b1,'      '),6)||NVL(:b2,'00000000'\
)) and (RPAD(NVL(:b3,'~~~~~~'),6)||NVL(:b4,'99999999'))) and TRUNC(DOC_DATE) b\
etween TO_DATE(NVL(:b5,'01/01/1000'),'DD/MM/YYYY') and TO_DATE(NVL(:b6,'01/01/\
3000'),'DD/MM/YYYY')) and ADDED_BY_ID between NVL(:b7,'                    ') \
and NVL(:b7,'~~~~~~~~~~~~~~~~~~~~')) and NVL(POSTED_FLAG,'N')<>'Y') order by D\
OC_TYPE_CODE,DOC_NUMBER            ";

 static const char *sq0010 = 
"select SHORT_NAME_LOC_LANG ,SHORT_NAME  from MP_PATIENT_MAST where PATIENT_I\
D=:b0           ";

 static const char *sq0009 = 
"select TO_CHAR(ORG_DOC_DATE,'DD/MM/YYYY') ,TO_CHAR(NVL(DOC_AMT,0),'999,999,9\
90.99') ,TO_CHAR(NVL(DOC_OUTST_AMT,0),'999,999,990.99') ,DOC_AMT ,DOC_OUTST_AM\
T  from BL_DCP_PENDING_DOC where ((operating_facility_id=:b0 and ORG_DOC_TYPE_\
CODE=:b1) and ORG_DOC_NUMBER=:b2)           ";

 static const char *sq0007 = 
"select LINE_NUM ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROUP_CO\
DE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,TO_CHAR(NVL(\
DOC_AMT,0),'999,999,990.99') ,DOC_AMT ,NARRATION  from BL_DCP_ALL_TRN_DTL1 whe\
re ((operating_facility_id=:b0 and DOC_TYPE_CODE=:b1) and DOC_NUMBER=:b2) orde\
r by LINE_NUM            ";

 static const char *sq0008 = 
"select ALL_DOC_TYPE_CODE ,ALL_DOC_NUMBER ,TO_CHAR(NVL(ALL_DOC_AMT,0),'999,99\
9,990.99') ,ALL_DOC_AMT  from BL_DCP_ALL_TRN_DTL2 where (DOC_TYPE_CODE=:b0 and\
 DOC_NUMBER=:b1) order by ALL_DOC_TYPE_CODE,ALL_DOC_NUMBER            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,125,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,216,0,4,156,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
91,0,0,3,128,0,4,201,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
122,0,0,4,0,0,30,235,0,0,0,0,0,1,0,
137,0,0,5,91,0,2,244,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
160,0,0,6,813,0,9,340,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
211,0,0,6,0,0,13,375,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
274,0,0,7,0,0,13,439,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
333,0,0,8,0,0,13,492,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
364,0,0,10,92,0,9,524,0,0,1,1,0,1,0,1,9,0,0,
383,0,0,10,0,0,13,529,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
406,0,0,11,511,0,6,543,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
433,0,0,9,276,0,9,578,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
460,0,0,9,0,0,13,594,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
495,0,0,7,335,0,9,636,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
522,0,0,8,224,0,9,713,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
545,0,0,12,245,0,4,883,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
};


 /*****************************************************************************/
/*                           BLRALLED.PC                                     */
/*****************************************************************************/
/*  Converted To Windows         : Prasad B G S  4/6/96                     */

/*
#define DEBUG
*/               

#include <stdio.h>   
#include <string.h>    
#include <bl.h>     
          
/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[91],   
		    d_session_id[16],
		    d_pgm_date[14],
            rep_date[20],
            comp_name[50],
			nd_facility_id[3],
		    nd_fm_doc_type_code[7],
		    nd_fm_doc_no[9],
		    nd_to_doc_type_code[7],
		    nd_to_doc_no[9],
		    nd_fm_doc_date[13],
		    nd_to_doc_date[13],
            nd_operator_id[31],
            oper_id[21],
		    d_acct_desc[65]; */ 
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

struct { unsigned short len; unsigned char arr[13]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[31]; } nd_operator_id;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[65]; } d_acct_desc;


   /* VARCHAR d_hdr_doc_type_code                         [7],
           d_hdr_doc_number                            [9],
           d_hdr_patient_id                            [21],
		   d_patient_name                              [61],
               d_short_name_full                           [61],
               mp_pat_short_name                           [61],
		   d_patient_name1							   [61],
		   d_patient_name_loc_lang                     [61],
           d_hdr_doc_date                              [13],
           d_hdr_trx_type_code                         [2],
		   d_hdr_trx_type_desc                         [4],
           d_hdr_pat_doc_reference                     [11],
           d_hdr_doc_amt                               [23],
           d_hdr_narration                             [51],
           d_hdr_post_month                            [3],
           d_hdr_post_year                             [5]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_hdr_doc_number;

struct { unsigned short len; unsigned char arr[21]; } d_hdr_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name1;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[13]; } d_hdr_doc_date;

struct { unsigned short len; unsigned char arr[2]; } d_hdr_trx_type_code;

struct { unsigned short len; unsigned char arr[4]; } d_hdr_trx_type_desc;

struct { unsigned short len; unsigned char arr[11]; } d_hdr_pat_doc_reference;

struct { unsigned short len; unsigned char arr[23]; } d_hdr_doc_amt;

struct { unsigned short len; unsigned char arr[51]; } d_hdr_narration;

struct { unsigned short len; unsigned char arr[3]; } d_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_hdr_post_year;


   /* VARCHAR d_dtl1_line_num                             [5],
           d_dtl1_main_acc1_code                       [7],
           d_dtl1_main_acc2_code                       [5],
           d_dtl1_dept_code                            [11],
           d_dtl1_product_group_code                   [4],
           d_dtl1_product_line_code                    [5],
           d_dtl1_subledger_group_code                 [4],
           d_dtl1_subledger_line_code                  [9],
           d_dtl1_doc_amt                              [23],
           d_dtl1_narration                            [51]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_dtl1_line_num;

struct { unsigned short len; unsigned char arr[7]; } d_dtl1_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_dtl1_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } d_dtl1_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_dtl1_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_dtl1_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_dtl1_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_dtl1_subledger_line_code;

struct { unsigned short len; unsigned char arr[23]; } d_dtl1_doc_amt;

struct { unsigned short len; unsigned char arr[51]; } d_dtl1_narration;


   /* VARCHAR d_dtl2_all_doc_type_code                    [7],
           d_dtl2_all_doc_number                       [9],
           d_dtl2_all_doc_amt                          [23]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_dtl2_all_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dtl2_all_doc_number;

struct { unsigned short len; unsigned char arr[23]; } d_dtl2_all_doc_amt;


   /* VARCHAR d_pend_doc_date                             [13],
		   d_pend_doc_amt                              [23],
		   d_pend_doc_outst_amt                        [23]; */ 
struct { unsigned short len; unsigned char arr[13]; } d_pend_doc_date;

struct { unsigned short len; unsigned char arr[23]; } d_pend_doc_amt;

struct { unsigned short len; unsigned char arr[23]; } d_pend_doc_outst_amt;


double    d_doc_amt_num_hdr,
          d_doc_amt_num_dtl1,
          d_doc_amt_num_dtl2,
		  d_doc_amt_num_pend,
		  d_doc_outst_amt_num_pend;

char filename[150];
char string_var [100];

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
    g_err_typ;

char g_acct_code[41],
     g_err_id[8],
     g_err_msg[72];

double g_tot_amt_dtl1,
       g_tot_amt_dtl2,
       g_grand_tot_hdr,
       g_grand_tot_dtl1,
       g_grand_tot_dtl2;

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc !=5) {
      disp_message(ERR_MESG,"BLRALLED : Usage BLRALLED userid/password session_id pgm_date facility");
      proc_exit();
    }

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(g_pgm_id,"BLRALLED");
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
	  disp_message(ORA_MESG,"Unable to connect to oracle.\n");
  	  proc_exit();
    }

	
   set_meduser_role();

   start_prog_msg();

    nd_fm_doc_type_code.arr[0]  = '\0';
	nd_fm_doc_no.arr[0]  = '\0';
	nd_to_doc_type_code.arr[0]  = '\0';
	nd_to_doc_no.arr[0]  = '\0';
    nd_fm_doc_date.arr[0]  = '\0';
	nd_to_doc_date.arr[0]  = '\0';
	nd_operator_id.arr[0]  = '\0';
	nd_facility_id.arr[0]  = '\0';

    nd_fm_doc_type_code.len  = 0;
	nd_fm_doc_no.len  = 0;
	nd_to_doc_type_code.len  = 0;
	nd_to_doc_no.len  = 0;
    nd_fm_doc_date.len  = 0;
	nd_to_doc_date.len  = 0;
	nd_operator_id.len  = 0;
	nd_facility_id.len  = 0;


	/* EXEC SQL SELECT 
			OPERATING_FACILITY_ID,
			PARAM1,            /o FM_DOC_TYPE_CODE           o/
			PARAM2,            /o FM_DOC_NO                  o/
			PARAM3,            /o TO_DOC_TYPE_CODE           o/
			PARAM4,            /o TO_DOC_NO                  o/
			PARAM5,            /o FM_DOC_DATE                o/
			PARAM6,            /o TO_DOC_DATE                o/
			PARAM7             /o OPER_IDl                   o/     
		 INTO  :nd_facility_id,
			:nd_fm_doc_type_code,
			:nd_fm_doc_no,
			:nd_to_doc_type_code,
			:nd_to_doc_no,
		        :nd_fm_doc_date,
			:nd_to_doc_date,
			:nd_operator_id 
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRALLED'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_PA\
RAM where ((PGM_ID='BLRALLED' and PGM_DATE=:b8) and SESSION_ID=TO_NUMBER(:b9))";
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
 sqlstm.sqhstl[5] = (unsigned int  )15;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
 sqlstm.sqhstl[6] = (unsigned int  )15;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_operator_id;
 sqlstm.sqhstl[7] = (unsigned int  )33;
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

    nd_fm_doc_type_code.arr[nd_fm_doc_type_code.len]  = '\0';
	nd_fm_doc_no.arr[nd_fm_doc_no.len]  = '\0';
	nd_to_doc_type_code.arr[nd_to_doc_type_code.len]  = '\0';
	nd_to_doc_no.arr[nd_to_doc_no.len]  = '\0';
    nd_fm_doc_date.arr[nd_fm_doc_date.len]  = '\0';
    nd_to_doc_date.arr[nd_to_doc_date.len]  = '\0';
	nd_operator_id.arr[nd_operator_id.len]  = '\0';
	nd_facility_id.arr[nd_facility_id.len] = '\0';
	strcpy(g_facility_id,nd_facility_id.arr);

	
    strcpy(filename,WORKING_DIR);
	strcat(filename,"blralled.lis");
    if( (f1=fopen(filename,"w")) == NULL) {
        
	proc_exit();
    }


    /* EXEC SQL SELECT ACCOUNTING_NAME,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
	     INTO   :comp_name,
		    :rep_date,
		    :oper_id
	     FROM   SY_ACC_ENTITY
 		 where ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
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

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';

    page_no=1;
    line_no=1;

		
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
    sqlstm.offset = (unsigned int  )122;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return;

disp_message(ERR_MESG,"LAST");
}

del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
         WHERE  PGM_ID     = 'BLRALLED' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRALLED' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )137;
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

     /* EXEC SQL DECLARE ALL_TRN_HDR_CUR CURSOR FOR
               SELECT DOC_TYPE_CODE,
                      DOC_NUMBER,
                      PATIENT_ID,
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                      TRX_TYPE_CODE,
		      DECODE(TRX_TYPE_CODE,'1','INV','2','DN','3','CN',
					   '4','ADJ','5','REC','6','PAY',''),
                      PAT_DOC_REFERENCE,
                      TO_CHAR(NVL(DOC_AMT,0),'999,999,990.99'),
		      DOC_AMT,
                      NARRATION,
                      POST_MONTH,
                      POST_YEAR
         FROM BL_DCP_ALL_TRN_HDR 
		 WHERE operating_facility_id = :nd_facility_id and
				RPAD(DOC_TYPE_CODE,6,' ')||
		       LTRIM(TO_CHAR(DOC_NUMBER,'00000009')) BETWEEN
	               RPAD(NVL(:nd_fm_doc_type_code,'      '),6)||
		       NVL(:nd_fm_doc_no,'00000000') AND
	               RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6)||
		       NVL(:nd_to_doc_no,'99999999')
		 AND   TRUNC(DOC_DATE) BETWEEN
			 TO_DATE(NVL(:nd_fm_doc_date,'01/01/1000'),'DD/MM/YYYY')
			 AND
			 TO_DATE(NVL(:nd_to_doc_date,'01/01/3000'),'DD/MM/YYYY')
		 AND   ADDED_BY_ID BETWEEN
			 NVL(:nd_operator_id,'                    ') AND
			 NVL(:nd_operator_id,'~~~~~~~~~~~~~~~~~~~~')
		 AND   NVL(POSTED_FLAG,'N') <> 'Y'
		 ORDER BY DOC_TYPE_CODE, DOC_NUMBER; */ 



     /* EXEC SQL DECLARE ALL_TRN_DTL1_CUR CURSOR FOR
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
                 FROM BL_DCP_ALL_TRN_DTL1
		WHERE operating_facility_id = :nd_facility_id and
		DOC_TYPE_CODE = :d_hdr_doc_type_code
		AND   DOC_NUMBER    = :d_hdr_doc_number
		ORDER BY LINE_NUM; */ 


     /* EXEC SQL DECLARE ALL_TRN_DTL2_CUR CURSOR FOR
               SELECT ALL_DOC_TYPE_CODE,
                      ALL_DOC_NUMBER,
                      TO_CHAR(NVL(ALL_DOC_AMT,0),'999,999,990.99'),
                      ALL_DOC_AMT
                 FROM BL_DCP_ALL_TRN_DTL2 
		WHERE 
		DOC_TYPE_CODE = :d_hdr_doc_type_code
		AND   DOC_NUMBER    = :d_hdr_doc_number
             ORDER BY ALL_DOC_TYPE_CODE,
		      ALL_DOC_NUMBER; */ 


    /* EXEC SQL DECLARE PENDING_DOC_CUR CURSOR FOR
	      SELECT TO_CHAR(ORG_DOC_DATE,'DD/MM/YYYY'),
		     TO_CHAR(NVL(DOC_AMT,0),'999,999,990.99'),
	             TO_CHAR(NVL(DOC_OUTST_AMT,0),'999,999,990.99'),
		     DOC_AMT,
		     DOC_OUTST_AMT
	        FROM BL_DCP_PENDING_DOC
	       WHERE operating_facility_id = :nd_facility_id and
		   ORG_DOC_TYPE_CODE = :d_dtl2_all_doc_type_code
	       AND   ORG_DOC_NUMBER    = :d_dtl2_all_doc_number; */ 


    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
	     SELECT  /oSUBSTR(SHORT_NAME,1,30) SHORT_NAME,
		         decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
		         o/
				 SHORT_NAME_LOC_LANG,SHORT_NAME
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :d_hdr_patient_id; */ 


    /* EXEC SQL OPEN ALL_TRN_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )160;
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
    sqlstm.sqhstl[5] = (unsigned int  )15;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[6] = (unsigned int  )15;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_operator_id;
    sqlstm.sqhstl[7] = (unsigned int  )33;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_operator_id;
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


    if(OERROR)
	err_mesg("OPEN failed on cursor ALL_TRN_HDR_CUR",0,"");

} 
   
fetch_hdr() 
{

    d_hdr_doc_type_code.arr[0]                                        = '\0';
    d_hdr_doc_number.arr[0]                                           = '\0';
    d_hdr_patient_id.arr[0]                                           = '\0';
    d_hdr_doc_date.arr[0]                                             = '\0';
    d_hdr_trx_type_code.arr[0]                                        = '\0';
    d_hdr_trx_type_desc.arr[0]                                        = '\0';
    d_hdr_pat_doc_reference.arr[0]                                    = '\0';
    d_hdr_doc_amt.arr[0]                                              = '\0';
    d_hdr_narration.arr[0]                                            = '\0';
    d_hdr_post_month.arr[0]                                           = '\0';
    d_hdr_post_year.arr[0]                                            = '\0';
    
    d_hdr_doc_type_code.len                                           = 0;
    d_hdr_doc_number.len                                              = 0;
    d_hdr_patient_id.len                                              = 0;
    d_hdr_doc_date.len                                                = 0;
    d_hdr_trx_type_code.len                                           = 0;
    d_hdr_trx_type_desc.len                                           = 0;
    d_hdr_pat_doc_reference.len                                       = 0;
    d_hdr_doc_amt.len                                                 = 0;
    d_hdr_narration.len                                               = 0;
    d_hdr_post_month.len                                              = 0;
    d_hdr_post_year.len                                               = 0;

    d_doc_amt_num_hdr  = 0;

     /* EXEC SQL FETCH ALL_TRN_HDR_CUR
               INTO :d_hdr_doc_type_code,
                    :d_hdr_doc_number,
                    :d_hdr_patient_id,
                    :d_hdr_doc_date,
                    :d_hdr_trx_type_code,
                    :d_hdr_trx_type_desc,
                    :d_hdr_pat_doc_reference,
                    :d_hdr_doc_amt,
					:d_doc_amt_num_hdr,
                    :d_hdr_narration,
                    :d_hdr_post_month,
                    :d_hdr_post_year; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )211;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&d_hdr_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_hdr_doc_number;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_hdr_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_hdr_doc_date;
     sqlstm.sqhstl[3] = (unsigned int  )15;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_hdr_trx_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_hdr_trx_type_desc;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_hdr_pat_doc_reference;
     sqlstm.sqhstl[6] = (unsigned int  )13;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_hdr_doc_amt;
     sqlstm.sqhstl[7] = (unsigned int  )25;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_doc_amt_num_hdr;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_hdr_narration;
     sqlstm.sqhstl[9] = (unsigned int  )53;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_hdr_post_month;
     sqlstm.sqhstl[10] = (unsigned int  )5;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&d_hdr_post_year;
     sqlstm.sqhstl[11] = (unsigned int  )7;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor ALL_TRN_HDR_CUR",0,"");
    
    if(NO_DATA_FOUND)
	return 0;

    d_hdr_doc_type_code.arr[d_hdr_doc_type_code.len]                     = '\0';
    d_hdr_doc_number.arr[d_hdr_doc_number.len]                           = '\0';
    d_hdr_patient_id.arr[d_hdr_patient_id.len]                           = '\0';
    d_hdr_doc_date.arr[d_hdr_doc_date.len]                               = '\0';
    d_hdr_trx_type_code.arr[d_hdr_trx_type_code.len]                     = '\0';
    d_hdr_trx_type_desc.arr[d_hdr_trx_type_desc.len]                     = '\0';
    d_hdr_pat_doc_reference.arr[d_hdr_pat_doc_reference.len]             = '\0';
    d_hdr_doc_amt.arr[d_hdr_doc_amt.len]                                 = '\0';
    d_hdr_narration.arr[d_hdr_narration.len]                             = '\0';
    d_hdr_post_month.arr[d_hdr_post_month.len]                           = '\0';
    d_hdr_post_year.arr[d_hdr_post_year.len]                             = '\0';

    return 1;

    
}

fetch_dtl1()
{

    d_dtl1_line_num.arr[0]                                            = '\0';
    d_dtl1_main_acc1_code.arr[0]                                      = '\0';
    d_dtl1_main_acc2_code.arr[0]                                      = '\0';
    d_dtl1_dept_code.arr[0]                                           = '\0';
    d_dtl1_product_group_code.arr[0]                                  = '\0';
    d_dtl1_product_line_code.arr[0]                                   = '\0';
    d_dtl1_subledger_group_code.arr[0]                                = '\0';
    d_dtl1_subledger_line_code.arr[0]                                 = '\0';
    d_dtl1_doc_amt.arr[0]                                             = '\0';
    d_dtl1_narration.arr[0]                                           = '\0';
    
    d_dtl1_line_num.len                                               = 0;
    d_dtl1_main_acc1_code.len                                         = 0;
    d_dtl1_main_acc2_code.len                                         = 0;
    d_dtl1_dept_code.len                                              = 0;
    d_dtl1_product_group_code.len                                     = 0;
    d_dtl1_product_line_code.len                                      = 0;
    d_dtl1_subledger_group_code.len                                   = 0;
    d_dtl1_subledger_line_code.len                                    = 0;
    d_dtl1_doc_amt.len                                                = 0;
    d_dtl1_narration.len                                              = 0;
     
    d_doc_amt_num_dtl1 = 0;

     /* EXEC SQL FETCH ALL_TRN_DTL1_CUR
               INTO :d_dtl1_line_num,
                    :d_dtl1_main_acc1_code,
                    :d_dtl1_main_acc2_code,
                    :d_dtl1_dept_code,
                    :d_dtl1_product_group_code,
                    :d_dtl1_product_line_code,
                    :d_dtl1_subledger_group_code,
                    :d_dtl1_subledger_line_code,
                    :d_dtl1_doc_amt,
		    :d_doc_amt_num_dtl1,
                    :d_dtl1_narration; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )274;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&d_dtl1_line_num;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_dtl1_main_acc1_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_dtl1_main_acc2_code;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_dtl1_dept_code;
     sqlstm.sqhstl[3] = (unsigned int  )13;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_dtl1_product_group_code;
     sqlstm.sqhstl[4] = (unsigned int  )6;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_dtl1_product_line_code;
     sqlstm.sqhstl[5] = (unsigned int  )7;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_dtl1_subledger_group_code;
     sqlstm.sqhstl[6] = (unsigned int  )6;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_dtl1_subledger_line_code;
     sqlstm.sqhstl[7] = (unsigned int  )11;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_dtl1_doc_amt;
     sqlstm.sqhstl[8] = (unsigned int  )25;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_doc_amt_num_dtl1;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_dtl1_narration;
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
	err_mesg("FETCH failed on cursor ALL_TRN_DTL1_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_dtl1_line_num.arr[d_dtl1_line_num.len]                             = '\0';
    d_dtl1_main_acc1_code.arr[d_dtl1_main_acc1_code.len]                 = '\0';
    d_dtl1_main_acc2_code.arr[d_dtl1_main_acc2_code.len]                 = '\0';
    d_dtl1_dept_code.arr[d_dtl1_dept_code.len]                           = '\0';
    d_dtl1_product_group_code.arr[d_dtl1_product_group_code.len]         = '\0';
    d_dtl1_product_line_code.arr[d_dtl1_product_line_code.len]           = '\0';
    d_dtl1_subledger_group_code.arr[d_dtl1_subledger_group_code.len]     = '\0';
    d_dtl1_subledger_line_code.arr[d_dtl1_subledger_line_code.len]       = '\0';
    d_dtl1_doc_amt.arr[d_dtl1_doc_amt.len]                               = '\0';
    d_dtl1_narration.arr[d_dtl1_narration.len]                           = '\0';

    sprintf(g_acct_code,"%s-%s %s %s-%s %s-%s",
        d_dtl1_main_acc1_code.arr, d_dtl1_main_acc2_code.arr ,
	d_dtl1_dept_code.arr , d_dtl1_product_group_code.arr, 
	d_dtl1_product_line_code.arr , d_dtl1_subledger_group_code.arr , 
	d_dtl1_subledger_line_code.arr);

    return 1;
    
}

fetch_dtl2()
{

    d_dtl2_all_doc_type_code.arr[0]                                   = '\0';
    d_dtl2_all_doc_number.arr[0]                                      = '\0';
    d_dtl2_all_doc_amt.arr[0]                                         = '\0';
     
    d_dtl2_all_doc_type_code.len                                      = 0;
    d_dtl2_all_doc_number.len                                         = 0;
    d_dtl2_all_doc_amt.len                                            = 0;

    d_doc_amt_num_dtl2 = 0;

    /* EXEC SQL FETCH ALL_TRN_DTL2_CUR
               INTO :d_dtl2_all_doc_type_code,
                    :d_dtl2_all_doc_number,
                    :d_dtl2_all_doc_amt,
		    :d_doc_amt_num_dtl2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )333;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dtl2_all_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_dtl2_all_doc_number;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_dtl2_all_doc_amt;
    sqlstm.sqhstl[2] = (unsigned int  )25;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_doc_amt_num_dtl2;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor ALL_TRN_DTL2_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_dtl2_all_doc_type_code.arr[d_dtl2_all_doc_type_code.len]           = '\0';
    d_dtl2_all_doc_number.arr[d_dtl2_all_doc_number.len]                 = '\0';
    d_dtl2_all_doc_amt.arr[d_dtl2_all_doc_amt.len]                       = '\0';

    return 1;

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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )364;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_hdr_patient_id;
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
			   :d_patient_name1,o/
		       :d_patient_name_loc_lang,
                   :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )383;
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

    d_patient_name.arr[d_patient_name.len]  = '\0';
	d_patient_name1.arr[d_patient_name1.len]  = '\0';
    d_patient_name_loc_lang.arr[d_patient_name_loc_lang.len]  = '\0';
    d_short_name_full.arr[d_short_name_full.len]              = '\0';

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
         :d_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_name1    := :d_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 \
) ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , \
str2 ) ; IF str2 IS NOT NULL THEN :d_patient_name := str2 ; END IF ; blcommon \
. split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS\
 NOT NULL THEN :d_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d\
_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :d_\
patient_name1 := :d_patient_name1 || str2 ; end if ; END ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )406;
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
    sqlstm.sqhstv[2] = (         void  *)&d_patient_name1;
    sqlstm.sqhstl[2] = (unsigned int  )63;
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
       d_patient_name1.arr[d_patient_name1.len]  = '\0';

}

fetch_pending_amt()
{

    /* EXEC SQL OPEN PENDING_DOC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )433;
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
    sqlstm.sqhstv[1] = (         void  *)&d_dtl2_all_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_dtl2_all_doc_number;
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
	err_mesg("OPEN failed on cursor PENDING_DOC_CUR",0,"");

    d_pend_doc_date.arr[0]  = '\0';
    d_pend_doc_amt.arr[0]  = '\0';
    d_pend_doc_outst_amt.arr[0]  = '\0';

    d_pend_doc_date.len  = 0;
    d_pend_doc_amt.len  = 0;
    d_pend_doc_outst_amt.len  = 0;

    d_doc_amt_num_pend = 0;
    d_doc_outst_amt_num_pend = 0;

    /* EXEC SQL FETCH PENDING_DOC_CUR 
	     INTO  :d_pend_doc_date,
	           :d_pend_doc_amt,
		   :d_pend_doc_outst_amt,
		   :d_doc_amt_num_pend,
		   :d_doc_outst_amt_num_pend; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )460;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_date;
    sqlstm.sqhstl[0] = (unsigned int  )15;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_amt;
    sqlstm.sqhstl[1] = (unsigned int  )25;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_pend_doc_outst_amt;
    sqlstm.sqhstl[2] = (unsigned int  )25;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_doc_amt_num_pend;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_doc_outst_amt_num_pend;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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
	err_mesg("FETCH failed on cursor PENDING_DOC_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_pend_doc_date.arr[d_pend_doc_date.len]  = '\0';
    d_pend_doc_amt.arr[d_pend_doc_amt.len]  = '\0';
    d_pend_doc_outst_amt.arr[d_pend_doc_outst_amt.len]  = '\0';
   
    return 1;

}

do_report()
{

    int cnt,first;
    char s_amt[20];

    g_hdr_cnt=0;
    g_grand_tot_hdr  = 0;
    g_grand_tot_dtl1 = 0;
    g_grand_tot_dtl2 = 0;
    line_no = 1;
	
    put_hdr();
	
    while(fetch_hdr()) {
			
        g_hdr_cnt ++;
	g_grand_tot_hdr += d_doc_amt_num_hdr;
	fetch_patient_name();
	put_trn_hdr();

	/* EXEC SQL OPEN ALL_TRN_DTL1_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )495;
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
 sqlstm.sqhstv[1] = (         void  *)&d_hdr_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_hdr_doc_number;
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
	    err_mesg("OPEN failed on cursor ALL_TRN_DTL1_CUR",0,"");

	g_tot_amt_dtl1 = 0;
        first=1;
	cnt = 0;
	
	while(fetch_dtl1()) {
	    if(first) {
	        put_dtl1_head();
	        first=0;
	    }

		

            get_acct_desc_dtl1();
			

	    put_trn_dtl1();


	    if(validate_posting_acct( d_dtl1_main_acc1_code.arr,
		 		      d_dtl1_main_acc2_code.arr,
		 		      d_dtl1_dept_code.arr,
		 		      d_dtl1_product_group_code.arr,
		 		      d_dtl1_product_line_code.arr,
		 		      d_dtl1_subledger_group_code.arr,
		 		      d_dtl1_subledger_line_code.arr,
				      'N',
					  "BL",
					   d_hdr_post_year.arr,
					  d_hdr_post_month.arr,
					  &g_err_typ,
				      g_err_id,
				      g_err_msg
		    		      ) ==  -1) {

						 
    
	        if (g_err_typ) {  /* application error */
    
		    if(!strcmp(g_err_id,"GL1430"))
		      strcpy(g_err_msg,"BL5100 - Invalid Posting Account");
		    else if(!strcmp(g_err_id,"GL1540"))
		      strcpy(g_err_msg,"BL5102 - Posting Account should be detail account");
		    else
		      strcpy(g_err_msg,"BL5105 - Posting Account has been suspended");
		    chk_break(1);
		    fprintf(f1,"** ERROR **   :  %s\n",g_err_msg);
		    line_no ++;
    
	        }
    
                else   /* oracle error */
    
	            err_mesg(g_err_msg,0,"");
    
	    } /* end of if validate_posting_acct */ 

	    g_tot_amt_dtl1 += d_doc_amt_num_dtl1;
	    cnt ++;
	}
	g_grand_tot_dtl1 += g_tot_amt_dtl1;
	if(cnt) {
	   chk_break(3);
	   put_val(s_amt,g_tot_amt_dtl1);
	   format_amt(s_amt);
           fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");
	   fprintf(f1,"                                                                                                 TOTAL          %15s\n",s_amt);
           fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n\n");

	   line_no += 4;

	}

	/* EXEC SQL OPEN ALL_TRN_DTL2_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )522;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&d_hdr_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_hdr_doc_number;
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
	    err_mesg("OPEN failed on cursor ALL_TRN_DTL2_CUR",0,"");

	g_tot_amt_dtl2 = 0;
        first=1;
	cnt = 0;
	while(fetch_dtl2()) {
	    if(first) {
	        put_dtl2_head();
	        first=0;
	    }
	    fetch_pending_amt();
	    put_trn_dtl2();

	    g_tot_amt_dtl2 += d_doc_amt_num_dtl2;
	    cnt ++;
	}
	g_grand_tot_dtl2 += g_tot_amt_dtl2;
	if(cnt) {
	   chk_break(3);
	   put_val(s_amt,g_tot_amt_dtl2);
	   format_amt(s_amt);
           fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");
	   fprintf(f1,"                                                     TOTAL          %15s\n",s_amt);
           fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n\n");

	   line_no += 4;

	}
       
	  
	if(!equal(d_doc_amt_num_hdr,g_tot_amt_dtl1) ||
	   !equal(d_doc_amt_num_hdr,g_tot_amt_dtl2)) {
	    strcpy(g_err_msg,"BL5108 - Mismatch between doc amt and sum of alloc amts");
	    chk_break(1);
	    fprintf(f1,"** ERROR **   :  %s\n\n\n",g_err_msg);
	    line_no += 3;
	}




    } 

    
	print_end_of_rep();




}


put_hdr()
{

    fprintf(f1,"MDL : BL                                       %30s                                       %s\n",comp_name.arr,rep_date.arr);

    fprintf(f1,"OPR : %s\n",oper_id.arr);

    fprintf(f1,"REP : BLRALLED                               EDIT LIST OF ALLOCATING TRANSACTIONS                                        PAGE : %4d\n",page_no);

    fprintf(f1,"\n\n");
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"DOC TYPE/NUMBER  DOC DATE   TRX TYPE REFERENCE          AMOUNT  PERIOD NARRATION\n");
    fprintf(f1,"                 PATIENT NO. & NAME\n");
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");

    line_no=10;

}

put_trn_hdr() 
{
    chk_break(2);

    fprintf(f1,"%-6s/%-8s  %8s  %1s %3s   %-10s",
	//%s  %2s/%4s  %-50s\n",
	d_hdr_doc_type_code.arr, d_hdr_doc_number.arr, d_hdr_doc_date.arr,
	d_hdr_trx_type_code.arr, d_hdr_trx_type_desc.arr, 
	d_hdr_pat_doc_reference.arr);
	print_formated(d_doc_amt_num_hdr); //d_hdr_doc_amt.arr,
	fprintf(f1,"  %2s/%4s  %-50s\n",d_hdr_post_month.arr, d_hdr_post_year.arr, d_hdr_narration.arr);
    fprintf(f1,"       %-20s %30.30s %-30.30s\n\n", d_hdr_patient_id.arr,
	d_patient_name_loc_lang.arr, d_patient_name.arr);
 
    if (strlen(d_patient_name1.arr) > 2 )
	{ 
	  fprintf(f1,"%58s %s\n", " ", d_patient_name1.arr);
 
	  line_no++;
	 
	}


    line_no += 3;

/*
               "XXXXXX/XXXXXXXX  XX/XX/XXXX   X XXX  XXXXXXXXXX 999,999,990.99  99/99  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
               "                 XXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"                                

*/

}

put_dtl1_head()
{

    chk_break(3);

    fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"    LINE         POSTING ACCOUNT                            NARRATION                                                    AMOUNT\n");
    fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");

    line_no += 3;

}

put_trn_dtl1()
{

    chk_break(2);
    fprintf(f1,"    %4s         %-40s   %-50s  %s\n",
        d_dtl1_line_num.arr,g_acct_code,
	d_dtl1_narration.arr,d_dtl1_doc_amt.arr);
    fprintf(f1,"                 %s\n",d_acct_desc.arr);

    line_no += 2;
/*
	       "    XXXX         XXXXXX-XXXX XXXXXX XXX-XXXX XXX-XXXXXXXX   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX   999,999,999.99"
*/

}

put_dtl2_head()
{

    chk_break(3);

    fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"    ALLOC DOCUMENT    DATE                    AMT        OUTST AMT        ALLOC AMT\n");
    fprintf(f1,"    --------------------------------------------------------------------------------------------------------------------------------\n");

    line_no += 3;

}

put_trn_dtl2()
{

    chk_break(1);
    fprintf(f1,"    %-6s/%-8s   %-10s  %s  %s  %s\n",
	d_dtl2_all_doc_type_code.arr, d_dtl2_all_doc_number.arr,
	d_pend_doc_date.arr, d_pend_doc_amt.arr, d_pend_doc_outst_amt.arr,
	d_dtl2_all_doc_amt.arr);
    line_no += 1;
/*
	       "    XXXXXX/99999999   XX/XX/XXXX   999,999,999.99   999,999,999.99   999,999,999.99"
*/

}

get_acct_desc_dtl1()
{

    d_acct_desc.arr[0] = '\0';

    /* EXEC SQL SELECT CONCAT_POST_ACC_DESC 
	     INTO   :d_acct_desc 
	     FROM   GL_POSTING_ACC
	     WHERE  MAIN_ACC1_CODE       =  :d_dtl1_main_acc1_code
	     AND    MAIN_ACC2_CODE       =  :d_dtl1_main_acc2_code
	     AND    DEPT_CODE            =  :d_dtl1_dept_code
	     AND    PRODUCT_GROUP_CODE   =  :d_dtl1_product_group_code
	     AND    PRODUCT_LINE_CODE    =  :d_dtl1_product_line_code
	     AND    SUBLEDGER_GROUP_CODE =  :d_dtl1_subledger_group_code
	     AND    SUBLEDGER_LINE_CODE  =  :d_dtl1_subledger_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CONCAT_POST_ACC_DESC into :b0  from GL_POSTING_ACC\
 where ((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and\
 PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:\
b6) and SUBLEDGER_LINE_CODE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )545;
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
    sqlstm.sqhstv[1] = (         void  *)&d_dtl1_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_dtl1_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_dtl1_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_dtl1_product_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_dtl1_product_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_dtl1_subledger_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_dtl1_subledger_line_code;
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

	
    fprintf(f1,"MDL : BL                                       %30s                                       %s\n",comp_name.arr,rep_date.arr);
	
    fprintf(f1,"OPR : %s\n",oper_id.arr);

    fprintf(f1,"REP : BLRALLED                               EDIT LIST OF ALLOCATING TRANSACTIONS                                        PAGE : %4d\n",page_no);
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n\n");
    fprintf(f1,"VER : 1.10.01\n");
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\tINPUT PARAMETERS\n");
    fprintf(f1,"\t----------------\n\n");
	fprintf(f1,"\t\tFACILITY ID           : %s\n\n",nd_facility_id.arr);
    fprintf(f1,"\t\tDOC TYPE CODE   FROM  : %-6s\n",nd_fm_doc_type_code.arr);
    fprintf(f1,"\t\t                TO    : %-6s\n\n",nd_to_doc_type_code.arr);
    fprintf(f1,"\t\tDOCUMENT NUMBER FROM  : %s\n",nd_fm_doc_no.arr);
    fprintf(f1,"\t\t                TO    : %s\n\n",nd_to_doc_no.arr);
    fprintf(f1,"\t\tDOCUMENT DATE   FROM  : %s\n",nd_fm_doc_date.arr);
    fprintf(f1,"\t\t                TO    : %s\n\n",nd_to_doc_date.arr);
    fprintf(f1,"\t\tOPERATOR ID           : %s\n\n",nd_operator_id.arr);
    fprintf(f1,"");
    ++page_no;


}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt,"-");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(f1,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
                ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(f1,"%-14s ",str_amt);
        }
}

print_end_of_rep()
{
    char s_amt_hdr[20], s_amt_dtl1[20], s_amt_dtl2[20];

    if(g_hdr_cnt) {
	chk_break(1);
        put_val(s_amt_hdr,g_grand_tot_hdr);
        format_amt(s_amt_hdr);

        put_val(s_amt_dtl1,g_grand_tot_dtl1);
        format_amt(s_amt_dtl1);
    
        put_val(s_amt_dtl2,g_grand_tot_dtl2);
        format_amt(s_amt_dtl2);

	fprintf(f1,"GRAND TOTALS :  DOCUMENT AMT ----> %15s     POSTING ACCT LINE AMT ----> %15s     ALLOC AMT ----> %15s\n\n", 
	s_amt_hdr, s_amt_dtl1, s_amt_dtl2);
	line_no += 2;
    
    }
    chk_break(2);
    fprintf(f1,"TOTAL NUMBER OF DOCUMENTS PRINTED : %d\n\n",g_hdr_cnt);
    fprintf(f1,"                                                    ** END OF REPORT **                                                             \n");
}
