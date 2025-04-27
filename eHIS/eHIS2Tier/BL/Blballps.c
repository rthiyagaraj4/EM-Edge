
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
           char  filnam[24];
};
static const struct sqlcxp sqlfpn =
{
    23,
    "C:\\temp\\ICN\\Blballps.pc"
};


static unsigned long sqlctx = 581994547;


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
            void  *sqhstv[22];
   unsigned int   sqhstl[22];
            int   sqhsts[22];
            void  *sqindv[22];
            int   sqinds[22];
   unsigned int   sqharm[22];
   unsigned int   *sqharc[22];
   unsigned short  sqadto[22];
   unsigned short  sqtdso[22];
} sqlstm = {10,22};

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
"select ROWID ,DOC_TYPE_CODE ,DOC_NUMBER  from BL_DCP_ALL_TRN_HDR where ((((o\
perating_facility_id=:b0 and (RPAD(DOC_TYPE_CODE,6,' ')||LTRIM(TO_CHAR(DOC_NUM\
BER,'00000009'))) between (RPAD(NVL(:b1,'      '),6)||NVL(:b2,'00000000')) and\
 (RPAD(NVL(:b3,'~~~~~~'),6)||NVL(:b4,'99999999'))) and DOC_DATE between TO_DAT\
E(NVL(:b5,'01/01/1000'),'DD/MM/YYYY') and TO_DATE(NVL(:b6,'01/01/3000'),'DD/MM\
/YYYY')) and ADDED_BY_ID between NVL(:b7,'                    ') and NVL(:b7,'\
~~~~~~~~~~~~~~~~~~~~')) and NVL(POSTED_FLAG,'N')<>'Y') order by DOC_TYPE_CODE,\
DOC_NUMBER            ";

 static const char *sq0007 = 
"select LINE_NUM ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROUP_CO\
DE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,DOC_AMT ,NAR\
RATION  from BL_DCP_ALL_TRN_DTL1 where ((operating_facility_id=:b0 and DOC_TYP\
E_CODE=:b1) and DOC_NUMBER=:b2)           ";

 static const char *sq0008 = 
"select ALL_DOC_TYPE_CODE ,ALL_DOC_NUMBER ,ALL_DOC_AMT  from BL_DCP_ALL_TRN_D\
TL2 where ((operating_facility_id=:b0 and DOC_TYPE_CODE=:b1) and DOC_NUMBER=:b\
2)           ";

 static const char *sq0006 = 
"select DOC_TYPE_CODE ,DOC_NUMBER ,PATIENT_ID ,TO_CHAR(DOC_DATE,'DD/MM/YYYY')\
 ,TRX_TYPE_CODE ,PAT_DOC_REFERENCE ,DOC_AMT ,NARRATION ,POST_MONTH ,POST_YEAR \
,MAX_LINE_NUM  from BL_DCP_ALL_TRN_HDR where ROWID=:b0 for update of POSTED_FL\
AG nowait ";

 static const char *sq0009 = 
"select ROWID ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE \
,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,MAX_LINE_NUM  f\
rom BL_DCP_PENDING_DOC where ((operating_facility_id=:b0 and ORG_DOC_TYPE_CODE\
=:b1) and ORG_DOC_NUMBER=:b2) for update of MAX_LINE_NUM nowait ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,139,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,229,0,4,169,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
95,0,0,3,0,0,30,226,0,0,0,0,0,1,0,
110,0,0,4,91,0,2,235,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
133,0,0,5,566,0,9,329,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
184,0,0,7,274,0,9,351,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
211,0,0,10,0,0,31,357,0,0,0,0,0,1,0,
226,0,0,8,167,0,9,361,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
253,0,0,11,0,0,31,367,0,0,0,0,0,1,0,
268,0,0,12,170,0,46,371,0,0,1,1,0,1,0,1,9,0,0,
287,0,0,13,0,0,29,383,0,0,0,0,0,1,0,
302,0,0,14,211,0,46,479,0,0,2,2,0,1,0,1,4,0,0,1,9,0,0,
325,0,0,15,527,0,3,498,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
412,0,0,16,195,0,5,562,0,0,3,3,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,
439,0,0,17,703,0,3,584,0,0,22,22,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
542,0,0,18,699,0,3,651,0,0,22,22,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
645,0,0,5,0,0,13,730,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
672,0,0,6,242,0,9,754,0,0,1,1,0,1,0,1,9,0,0,
691,0,0,6,0,0,13,786,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
750,0,0,7,0,0,13,842,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
805,0,0,8,0,0,13,884,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,
832,0,0,9,296,0,9,904,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
859,0,0,9,0,0,13,912,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,3,0,0,
910,0,0,19,161,0,3,942,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.10                                                 */
/************************************************************************/
/* PROGRAM NAME          : BLBALLPS.PC                                  */
/* AUTHOR                : M.NITIN KUMAR                                */
/* DATE WRITTEN          : 12-AUG-1993                                  */
/* Converted To Win      : BGSP                                         */  
/*                                                                       */
/* CALLED FROM           :                                              */
/*                                                                        */
/*  FUNCTION             : TO POST ORGINATING TRANSACTIONS              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */ 
/*                                                                      */
/************************************************************************/
      
	             
#include <stdio.h>
#include <string.h>
#include <bl.h> 

#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define NODATAFOUND sqlca.sqlcode == 1403
/*
#define DEBUG
*/
#define  VIEW_LOG_FILE    1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[91],
	    d_pgm_id[10],
        d_hdr_rowid[300],
	    d_session_id[16],
		nd_ws_no  [31],
	    d_pgm_date[14],
		nd_facility_id  [3],
	    nd_fm_doc_type_code[7],
	    nd_fm_doc_no[9],
	    nd_to_doc_type_code[7],
	    nd_to_doc_no[9],
	    nd_fm_doc_date[13],
	    nd_to_doc_date[13],
        nd_operator_id[21],
	    d_msg_desc[72]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[10]; } d_pgm_id;

struct { unsigned short len; unsigned char arr[300]; } d_hdr_rowid;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_no;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_no;

struct { unsigned short len; unsigned char arr[13]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_operator_id;

struct { unsigned short len; unsigned char arr[72]; } d_msg_desc;


   /* VARCHAR d_sel_doc_type_code                         [7],
           d_sel_doc_number                            [9]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_sel_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_sel_doc_number;


   /* VARCHAR d_hdr_doc_type_code                         [7],
           d_hdr_doc_number                            [9],
           d_hdr_patient_id                            [21],
           d_hdr_doc_date                              [13],
           d_hdr_trx_type_code                         [2],
           d_hdr_pat_doc_reference                     [11],
           d_hdr_narration                             [51],
           d_hdr_post_month                            [3],
           d_hdr_post_year                             [5],
           d_hdr_max_line_num                          [5]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_hdr_doc_number;

struct { unsigned short len; unsigned char arr[21]; } d_hdr_patient_id;

struct { unsigned short len; unsigned char arr[13]; } d_hdr_doc_date;

struct { unsigned short len; unsigned char arr[2]; } d_hdr_trx_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_hdr_pat_doc_reference;

struct { unsigned short len; unsigned char arr[51]; } d_hdr_narration;

struct { unsigned short len; unsigned char arr[3]; } d_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_hdr_post_year;

struct { unsigned short len; unsigned char arr[5]; } d_hdr_max_line_num;


   /* VARCHAR d_dtl1_line_num                             [5],
	       d_dtl1_main_acc1_code                       [7],
           d_dtl1_main_acc2_code                       [5],
           d_dtl1_dept_code                            [11],
           d_dtl1_product_group_code                   [4],
           d_dtl1_product_line_code                    [5],
           d_dtl1_subledger_group_code                 [4],
           d_dtl1_subledger_line_code                  [9],
           d_dtl1_narration                            [51]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_dtl1_line_num;

struct { unsigned short len; unsigned char arr[7]; } d_dtl1_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_dtl1_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } d_dtl1_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_dtl1_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } d_dtl1_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_dtl1_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_dtl1_subledger_line_code;

struct { unsigned short len; unsigned char arr[51]; } d_dtl1_narration;


   /* VARCHAR d_dtl2_all_doc_type_code                    [7],
           d_dtl2_all_doc_number                       [9]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_dtl2_all_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dtl2_all_doc_number;


   /* VARCHAR d_pend_doc_main_acc1_code                   [7],
           d_pend_doc_main_acc2_code                   [5],
           d_pend_doc_dept_code                        [11],
           d_pend_doc_product_grp_cd                   [4],
           d_pend_doc_product_line_code                [5],
           d_pend_doc_subledger_grp_cd                 [4],
           d_pend_doc_subledger_ln_cd                  [9],
           d_pend_doc_rowid                            [20]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_pend_doc_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } d_pend_doc_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } d_pend_doc_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_pend_doc_product_grp_cd;

struct { unsigned short len; unsigned char arr[5]; } d_pend_doc_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_pend_doc_subledger_grp_cd;

struct { unsigned short len; unsigned char arr[9]; } d_pend_doc_subledger_ln_cd;

struct { unsigned short len; unsigned char arr[20]; } d_pend_doc_rowid;


   int     d_pend_doc_max_line_num;

double      d_hdr_doc_amt,
            d_dtl1_doc_amt,
	        d_dtl2_all_doc_amt;


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


int g_hdr_cnt,
    g_hdr_proc,
    g_err_typ;

char file_name[15],
     g_acct_code[41],
     g_err_id[8],
     g_err_msg[72];

double g_dtl_tot_amt;

void proc_main(argc,argv)
int argc;
char *argv[];
{
    char mesg[80];

    if(argc !=5) {
        disp_message(ERR_MESG,"BLBALLPS : Usage BLBALLPS userid/password session_id pgm_date Facility");
        proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);

    strcpy(g_pgm_id,"BLBALLPS");
    strcpy(d_pgm_id.arr,"BLBALLPS");
    d_pgm_id.len  = strlen(d_pgm_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

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
        disp_message(ORA_MESG,"Unable to connect ");
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
	nd_ws_no.arr[0]		   = '\0';

    nd_fm_doc_type_code.len  = 0;
	nd_fm_doc_no.len  = 0;
	nd_to_doc_type_code.len  = 0;
	nd_to_doc_no.len  = 0;
    nd_fm_doc_date.len  = 0;
	nd_to_doc_date.len  = 0;
	nd_operator_id.len  = 0;
	nd_facility_id.len  = 0;
	nd_ws_no.len		= 0;
    

	/* EXEC SQL SELECT 
			OPERATING_FACILITY_ID,
			PARAM1,            /o FM_DOC_TYPE_CODE           o/
			PARAM2,            /o FM_DOC_NO                  o/
			PARAM3,            /o TO_DOC_TYPE_CODE           o/
			PARAM4,            /o TO_DOC_NO                  o/
			PARAM5,            /o FM_DOC_DATE                o/
			PARAM6,            /o TO_DOC_DATE                o/
			PARAM7,             /o OPER_IDl                   o/     
			PARAM8
		 INTO:nd_facility_id, 
			:nd_fm_doc_type_code,
			:nd_fm_doc_no,
			:nd_to_doc_type_code,
			:nd_to_doc_no,
		    :nd_fm_doc_date,
			:nd_to_doc_date,
			:nd_operator_id,
			:nd_ws_no 
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLBALLPS'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  fro\
m SY_PROG_PARAM where ((PGM_ID='BLBALLPS' and PGM_DATE=:b9) and SESSION_ID=TO_\
NUMBER(:b10))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
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
 sqlstm.sqhstl[7] = (unsigned int  )23;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[8] = (unsigned int  )33;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[9] = (unsigned int  )16;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_session_id;
 sqlstm.sqhstl[10] = (unsigned int  )18;
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



    if(ERROR || NODATAFOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

    nd_fm_doc_type_code.arr[nd_fm_doc_type_code.len]  = '\0';
	nd_fm_doc_no.arr[nd_fm_doc_no.len]  = '\0';
	nd_to_doc_type_code.arr[nd_to_doc_type_code.len]  = '\0';
	nd_to_doc_no.arr[nd_to_doc_no.len]  = '\0';
    nd_fm_doc_date.arr[nd_fm_doc_date.len]  = '\0';
	nd_to_doc_date.arr[nd_to_doc_date.len]  = '\0';
	nd_operator_id.arr[nd_operator_id.len]  = '\0';
	nd_facility_id.arr[nd_facility_id.len] = '\0';
	nd_ws_no.arr[nd_ws_no.len]             = '\0';

	strcpy(g_facility_id ,nd_facility_id.arr);

    g_hdr_cnt  = 0;
    g_hdr_proc = 0;

    

    decl_curs();
    process_recs();

    sprintf(mesg, "\tTotal Records Read          : %d\n",g_hdr_cnt);
    disp_message(INFO_MESG,mesg);
    sprintf(mesg,"\tTotal Records Processed     : %d\n",g_hdr_proc);
    disp_message(INFO_MESG,mesg);
    sprintf(mesg,"\tTotal Records Not Processed : %d\n\n",g_hdr_cnt - g_hdr_proc);
    disp_message(INFO_MESG,mesg);

    del_parm();

    end_prog_msg();
    /* EXEC SQL COMMIT RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )95;
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
         WHERE  PGM_ID     = 'BLBALLPS' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLBALLPS' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )110;
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
	 /* EXEC SQL DECLARE SEL_HDR_RECS CURSOR FOR
               SELECT ROWID,
		      DOC_TYPE_CODE,
		      DOC_NUMBER
                 FROM BL_DCP_ALL_TRN_HDR
		 WHERE operating_facility_id = :nd_facility_id AND
			   RPAD(DOC_TYPE_CODE,6,' ')||
		       LTRIM(TO_CHAR(DOC_NUMBER,'00000009')) BETWEEN
	               RPAD(NVL(:nd_fm_doc_type_code,'      '),6)||
		       NVL(:nd_fm_doc_no,'00000000') AND
	               RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6)||
		       NVL(:nd_to_doc_no,'99999999')
		 AND   DOC_DATE BETWEEN
			 TO_DATE(NVL(:nd_fm_doc_date,'01/01/1000'),'DD/MM/YYYY')
			 AND
			 TO_DATE(NVL(:nd_to_doc_date,'01/01/3000'),'DD/MM/YYYY')
		 AND   ADDED_BY_ID BETWEEN
			 NVL(:nd_operator_id,'                    ') AND
			 NVL(:nd_operator_id,'~~~~~~~~~~~~~~~~~~~~')
		 AND   NVL(POSTED_FLAG,'N') <> 'Y'
		 ORDER BY DOC_TYPE_CODE, DOC_NUMBER; */ 


     /* EXEC SQL DECLARE ALL_TRN_HDR_CUR CURSOR FOR
               SELECT DOC_TYPE_CODE,
                      DOC_NUMBER,
                      PATIENT_ID,
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                      TRX_TYPE_CODE,
                      PAT_DOC_REFERENCE,
                      DOC_AMT,
                      NARRATION,
                      POST_MONTH,
                      POST_YEAR,
                      MAX_LINE_NUM
                 FROM BL_DCP_ALL_TRN_HDR
		WHERE ROWID = :d_hdr_rowid
		  FOR UPDATE OF POSTED_FLAG NOWAIT; */ 


     /* EXEC SQL DECLARE ALL_TRN_DTL1_CUR CURSOR FOR
               SELECT LINE_NUM,
		      MAIN_ACC1_CODE,
                      MAIN_ACC2_CODE,
                      DEPT_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
                      DOC_AMT,
                      NARRATION
                 FROM BL_DCP_ALL_TRN_DTL1 
		WHERE operating_facility_id = :nd_facility_id AND
		DOC_TYPE_CODE = :d_hdr_doc_type_code
		  AND DOC_NUMBER    = :d_hdr_doc_number; */ 


     /* EXEC SQL DECLARE ALL_TRN_DTL2_CUR CURSOR FOR
               SELECT ALL_DOC_TYPE_CODE,
                      ALL_DOC_NUMBER,
                      ALL_DOC_AMT
                 FROM BL_DCP_ALL_TRN_DTL2
		WHERE operating_facility_id = :nd_facility_id AND
		DOC_TYPE_CODE = :d_hdr_doc_type_code
		  AND DOC_NUMBER    = :d_hdr_doc_number; */ 


    /* EXEC SQL DECLARE PEND_DOC_CUR CURSOR FOR
	      SELECT ROWID,
                     MAIN_ACC1_CODE,
                     MAIN_ACC2_CODE,
                     DEPT_CODE,
                     PRODUCT_GROUP_CODE,
                     PRODUCT_LINE_CODE,
                     SUBLEDGER_GROUP_CODE,
                     SUBLEDGER_LINE_CODE,
		     MAX_LINE_NUM
		FROM BL_DCP_PENDING_DOC
	    WHERE operating_facility_id = :nd_facility_id AND
		 ORG_DOC_TYPE_CODE = :d_dtl2_all_doc_type_code
		 AND ORG_DOC_NUMBER    = :d_dtl2_all_doc_number
		 FOR UPDATE OF MAX_LINE_NUM NOWAIT; */ 


    /* EXEC SQL OPEN SEL_HDR_RECS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )133;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor SEL_HDR_RECS",0,"");

}

process_recs()
{

    while(fetch_recs()) {

	     g_hdr_cnt++;

        if(lock_hdr() EQ -1) {
            log_messg("Unable to lock record in BL_DCP_ALL_TRN_HDR","HDR");
            continue;
        }
	

	updt_patient_fin_dtls();

	/* EXEC SQL OPEN ALL_TRN_DTL1_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )184;
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



	if(ERROR)
	    err_mesg("OPEN failed on cursor ALL_TRN_DTL1_CUR",0,"");

	if(process_dtl1() EQ -1) {
	    /* EXEC SQL ROLLBACK WORK; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )211;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	    continue;
	}

	/* EXEC SQL OPEN ALL_TRN_DTL2_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )226;
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



	if(ERROR)
	    err_mesg("OPEN failed on cursor ALL_TRN_DTL2_CUR",0,"");

	if(process_dtl2() EQ -1) {
	    /* EXEC SQL ROLLBACK WORK; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )253;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	    continue;
	}

	/* EXEC SQL UPDATE BL_DCP_ALL_TRN_HDR
		 SET    POSTED_FLAG = 'Y',
				POSTED_BY_ID = USER,
				POSTED_DATE_TIME = SYSDATE,
				MODIFIED_BY_ID = USER,
				MODIFIED_DATE = SYSDATE,
				MODIFIED_AT_WS_NO       = :nd_ws_no
		 WHERE  CURRENT OF ALL_TRN_HDR_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_DCP_ALL_TRN_HDR  set POSTED_FLAG='Y',POSTED_BY_ID=\
USER,POSTED_DATE_TIME=SYSDATE,MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFI\
ED_AT_WS_NO=:b0 where rowid = :x";
 sqlstm.iters = (unsigned int  )6;
 sqlstm.offset = (unsigned int  )268;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )33;
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
	    err_mesg("UPDATE failed on table BL_DCP_ORG_TRN_HDR",0,"");

	/* EXEC SQL COMMIT WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )287;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	g_hdr_proc ++;

    } /* end of while fetch recs */


}

process_dtl1()
{
    g_dtl_tot_amt = 0;


	while(fetch_dtl1()) {


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
		  log_messg("Invalid Posting Account",d_dtl1_line_num.arr);
		else if(!strcmp(g_err_id,"GL1540"))
		  log_messg("Posting A/C should be detail account",d_dtl1_line_num.arr);
		else
		  log_messg("Posting A/C has been suspended",d_dtl1_line_num.arr);
		return -1;
	    }

            else   /* oracle error */

	        err_mesg(g_err_msg,0,"");

	} /* end of if validate_posting_acct */ 

        g_dtl_tot_amt += d_dtl1_doc_amt;

	insrt_bl_gl_dist(1);


    }

    if(!equal(d_hdr_doc_amt, g_dtl_tot_amt)) {
        log_messg("Debits do not match Credits for Detail 1","");
	return -1;
    }

    return 1;

}

process_dtl2()
{
    g_dtl_tot_amt = 0;

    while(fetch_dtl2()) {

       if(fetch_pend_doc() EQ -1) {
	   log_messg("Unable to lock record in BL_DCP_PENDING_DOC","");
	   return -1;
       }
       insrt_bl_dcp_trn();
       updt_pending_doc();
       insrt_bl_gl_dist(2);

        g_dtl_tot_amt += d_dtl2_all_doc_amt;

    }

    if(!equal(d_hdr_doc_amt, g_dtl_tot_amt)) {
        log_messg("Debits do not match Credits for Detail 2","");
	return -1;
    }

    return 1;

}

updt_pending_doc()
{

    /* EXEC SQL UPDATE BL_DCP_PENDING_DOC
	     SET    DOC_OUTST_AMT  = NVL(DOC_OUTST_AMT,0) + :d_dtl2_all_doc_amt,
		    MAX_LINE_NUM   = NVL(MAX_LINE_NUM,0) + 1,
		    TRX_PROCESSED_IND = 'Y'	,		
				MODIFIED_BY_ID = USER,
				MODIFIED_DATE = SYSDATE,
				MODIFIED_AT_WS_NO       = :nd_ws_no
	     WHERE  CURRENT OF PEND_DOC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_DCP_PENDING_DOC  set DOC_OUTST_AMT=(NVL(DOC_OUT\
ST_AMT,0)+:b0),MAX_LINE_NUM=(NVL(MAX_LINE_NUM,0)+1),TRX_PROCESSED_IND='Y',MODI\
FIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1 where rowid = :x";
    sqlstm.iters = (unsigned int  )9;
    sqlstm.offset = (unsigned int  )302;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_dtl2_all_doc_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )sizeof(double);
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )33;
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
	err_mesg("UPDATE failed on table BL_DCP_PENDING_DOC",0,"");

}


insrt_bl_dcp_trn()
{


    /* EXEC SQL INSERT INTO BL_DCP_TRN
		    (    operating_facility_id,
					     PATIENT_ID,
                         ORG_DOC_TYPE_CODE,
                         ORG_DOC_NUMBER,
                         LINE_NUM,
                         DOC_TYPE_CODE,
                         DOC_NUMBER,
                         DOC_DATE,
                         PAT_DOC_REFERENCE,
                         DOC_NATURE_CODE,
                         DOC_AMT,
                         TRX_TYPE_CODE,
                         NARRATION,
                         POST_MONTH,
                         POST_YEAR,
                         POSTED_DATE,
                         POSTED_BY_ID,
				 		 ADDED_BY_ID,
						 MODIFIED_BY_ID,
						 ADDED_DATE,	
						 MODIFIED_DATE,
						 ADDED_AT_WS_NO,         
						 ADDED_FACILITY_ID,      
						 MODIFIED_AT_WS_NO,      
						 MODIFIED_FACILITY_ID   
		    )    
	    VALUES  (    :nd_facility_id,
						 :d_hdr_patient_id,
                         :d_dtl2_all_doc_type_code,
                         :d_dtl2_all_doc_number,
                         :d_pend_doc_max_line_num + 1,
                         :d_hdr_doc_type_code,
                         :d_hdr_doc_number,
                         TO_DATE(:d_hdr_doc_date,'DD/MM/YYYY'),
                         :d_hdr_pat_doc_reference,
                         NULL,
                         :d_dtl2_all_doc_amt,
                         :d_hdr_trx_type_code,
                         :d_hdr_narration,
                         :d_hdr_post_month,
                         :d_hdr_post_year,
                         SYSDATE,
                         USER,
						 USER,                             /o ADDED BY ID    o/
						 USER,                             /o MODIFIED BY ID o/
						 SYSDATE,					       /o ADDED DATE     o/
						 sysdate ,                             /o MODIFIED DATE  o/
						:nd_ws_no,	
						:nd_facility_id,
						:nd_ws_no,
						:nd_facility_id
	            ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_DCP_TRN (operating_facility_id,PATIENT_ID,\
ORG_DOC_TYPE_CODE,ORG_DOC_NUMBER,LINE_NUM,DOC_TYPE_CODE,DOC_NUMBER,DOC_DATE,PA\
T_DOC_REFERENCE,DOC_NATURE_CODE,DOC_AMT,TRX_TYPE_CODE,NARRATION,POST_MONTH,POS\
T_YEAR,POSTED_DATE,POSTED_BY_ID,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED\
_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)\
 values (:b0,:b1,:b2,:b3,(:b4+1),:b5,:b6,TO_DATE(:b7,'DD/MM/YYYY'),:b8,null ,:\
b9,:b10,:b11,:b12,:b13,SYSDATE,USER,USER,USER,SYSDATE,sysdate,:b14,:b0,:b14,:b\
0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )325;
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
    sqlstm.sqhstv[1] = (         void  *)&d_hdr_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_dtl2_all_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_dtl2_all_doc_number;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_pend_doc_max_line_num;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_hdr_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_hdr_doc_number;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_hdr_doc_date;
    sqlstm.sqhstl[7] = (unsigned int  )15;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_hdr_pat_doc_reference;
    sqlstm.sqhstl[8] = (unsigned int  )13;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_dtl2_all_doc_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_hdr_trx_type_code;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_hdr_narration;
    sqlstm.sqhstl[11] = (unsigned int  )53;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_hdr_post_month;
    sqlstm.sqhstl[12] = (unsigned int  )5;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_hdr_post_year;
    sqlstm.sqhstl[13] = (unsigned int  )7;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[14] = (unsigned int  )33;
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
    sqlstm.sqhstv[16] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[16] = (unsigned int  )33;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[17] = (unsigned int  )5;
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
	err_mesg("INSERT failed on table BL_DCP_TRN",0,"");

}


updt_patient_fin_dtls()
{


    /* EXEC SQL UPDATE BL_PATIENT_FIN_DTLS
	     SET    TOT_DEF_PAT_OUTST_AMT = NVL(TOT_DEF_PAT_OUTST_AMT,0) +
					    :d_hdr_doc_amt,
		    TRX_PROCESSED_IND     = 'Y',
			MODIFIED_BY_ID = USER,
			MODIFIED_DATE = SYSDATE,
			MODIFIED_AT_WS_NO       = :nd_ws_no			
	     WHERE  PATIENT_ID            = :d_hdr_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_PATIENT_FIN_DTLS  set TOT_DEF_PAT_OUTST_AMT=(NV\
L(TOT_DEF_PAT_OUTST_AMT,0)+:b0),TRX_PROCESSED_IND='Y',MODIFIED_BY_ID=USER,MODI\
FIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1 where PATIENT_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )412;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_hdr_doc_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[1] = (unsigned int  )33;
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



    if(ERROR || NODATAFOUND)
	err_mesg("UPDATE failed on table BL_PATIENT_FIN_DTLS",0,"");



}


insrt_bl_gl_dist(flg)
int flg;
{
    if(flg EQ 1) {

        /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
                        (  operating_facility_id,
							  MAIN_ACC1_CODE,
                             MAIN_ACC2_CODE,
                             DEPT_CODE,
                             PRODUCT_GROUP_CODE,
                             PRODUCT_LINE_CODE,
                             SUBLEDGER_GROUP_CODE,
                             SUBLEDGER_LINE_CODE,
                             POST_YEAR,
                             POST_MONTH,
                             TRX_DATE,
                             TRX_DOC_REF,
                             TRX_DOC_REF_LINE_NUM,
                             TRX_DOC_REF_SEQ_NUM,
                             EPISODE_TYPE,
                             PATIENT_ID,
                             EPISODE_ID,
                             VISIT_ID,
                             NARRATION,
                             TRX_TYPE_CODE,
                             DISTRIBUTION_AMT,
                             GL_INTERFACE_FLAG,
	 				 		 ADDED_BY_ID,
						 MODIFIED_BY_ID,
						 ADDED_DATE,	
						 MODIFIED_DATE,
						 ADDED_AT_WS_NO,         
						 ADDED_FACILITY_ID,      
						 MODIFIED_AT_WS_NO,      
						 MODIFIED_FACILITY_ID   
			)
		VALUES  (  :nd_facility_id,
							  :d_dtl1_main_acc1_code,
                             :d_dtl1_main_acc2_code,
                             :d_dtl1_dept_code,
                             :d_dtl1_product_group_code,
                             :d_dtl1_product_line_code,
                             :d_dtl1_subledger_group_code,
                             :d_dtl1_subledger_line_code,
                             :d_hdr_post_year,
                             :d_hdr_post_month,
                             TO_DATE(:d_hdr_doc_date,'DD/MM/YYYY'),
                             RPAD(:d_hdr_doc_type_code,6,' ')||'-'||
			                LPAD(:d_hdr_doc_number,8,'0'),
                             :d_dtl1_line_num,
                             0,
                             NULL,
                             :d_hdr_patient_id,
                             NULL,
                             NULL,
                             :d_hdr_narration,
                             :d_hdr_trx_type_code,
                             :d_dtl1_doc_amt * -1,
                             'N',
	 						 USER,                             /o ADDED BY ID    o/
							 USER,                             /o MODIFIED BY ID o/
							 SYSDATE,					       /o ADDED DATE     o/
							sysdate ,                             /o MODIFIED DATE  o/
							:nd_ws_no,	
							:nd_facility_id,
							:nd_ws_no,
							:nd_facility_id
			); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 22;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (operating_facility_id\
,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,\
SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC\
_REF,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_\
ID,VISIT_ID,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT,GL_INTERFACE_FLAG,ADDED_B\
Y_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,\
MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b\
7,:b8,:b9,TO_DATE(:b10,'DD/MM/YYYY'),((RPAD(:b11,6,' ')||'-')||LPAD(:b12,8,'0'\
)),:b13,0,null ,:b14,null ,null ,:b15,:b16,(:b17* (-1)),'N',USER,USER,SYSDATE,\
sysdate,:b18,:b0,:b18,:b0)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )439;
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
        sqlstm.sqhstv[8] = (         void  *)&d_hdr_post_year;
        sqlstm.sqhstl[8] = (unsigned int  )7;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&d_hdr_post_month;
        sqlstm.sqhstl[9] = (unsigned int  )5;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&d_hdr_doc_date;
        sqlstm.sqhstl[10] = (unsigned int  )15;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&d_hdr_doc_type_code;
        sqlstm.sqhstl[11] = (unsigned int  )9;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&d_hdr_doc_number;
        sqlstm.sqhstl[12] = (unsigned int  )11;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&d_dtl1_line_num;
        sqlstm.sqhstl[13] = (unsigned int  )7;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&d_hdr_patient_id;
        sqlstm.sqhstl[14] = (unsigned int  )23;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&d_hdr_narration;
        sqlstm.sqhstl[15] = (unsigned int  )53;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&d_hdr_trx_type_code;
        sqlstm.sqhstl[16] = (unsigned int  )4;
        sqlstm.sqhsts[16] = (         int  )0;
        sqlstm.sqindv[16] = (         void  *)0;
        sqlstm.sqinds[16] = (         int  )0;
        sqlstm.sqharm[16] = (unsigned int  )0;
        sqlstm.sqadto[16] = (unsigned short )0;
        sqlstm.sqtdso[16] = (unsigned short )0;
        sqlstm.sqhstv[17] = (         void  *)&d_dtl1_doc_amt;
        sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[17] = (         int  )0;
        sqlstm.sqindv[17] = (         void  *)0;
        sqlstm.sqinds[17] = (         int  )0;
        sqlstm.sqharm[17] = (unsigned int  )0;
        sqlstm.sqadto[17] = (unsigned short )0;
        sqlstm.sqtdso[17] = (unsigned short )0;
        sqlstm.sqhstv[18] = (         void  *)&nd_ws_no;
        sqlstm.sqhstl[18] = (unsigned int  )33;
        sqlstm.sqhsts[18] = (         int  )0;
        sqlstm.sqindv[18] = (         void  *)0;
        sqlstm.sqinds[18] = (         int  )0;
        sqlstm.sqharm[18] = (unsigned int  )0;
        sqlstm.sqadto[18] = (unsigned short )0;
        sqlstm.sqtdso[18] = (unsigned short )0;
        sqlstm.sqhstv[19] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[19] = (unsigned int  )5;
        sqlstm.sqhsts[19] = (         int  )0;
        sqlstm.sqindv[19] = (         void  *)0;
        sqlstm.sqinds[19] = (         int  )0;
        sqlstm.sqharm[19] = (unsigned int  )0;
        sqlstm.sqadto[19] = (unsigned short )0;
        sqlstm.sqtdso[19] = (unsigned short )0;
        sqlstm.sqhstv[20] = (         void  *)&nd_ws_no;
        sqlstm.sqhstl[20] = (unsigned int  )33;
        sqlstm.sqhsts[20] = (         int  )0;
        sqlstm.sqindv[20] = (         void  *)0;
        sqlstm.sqinds[20] = (         int  )0;
        sqlstm.sqharm[20] = (unsigned int  )0;
        sqlstm.sqadto[20] = (unsigned short )0;
        sqlstm.sqtdso[20] = (unsigned short )0;
        sqlstm.sqhstv[21] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[21] = (unsigned int  )5;
        sqlstm.sqhsts[21] = (         int  )0;
        sqlstm.sqindv[21] = (         void  *)0;
        sqlstm.sqinds[21] = (         int  )0;
        sqlstm.sqharm[21] = (unsigned int  )0;
        sqlstm.sqadto[21] = (unsigned short )0;
        sqlstm.sqtdso[21] = (unsigned short )0;
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
    else {

        /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION
                        (    operating_facility_id,
							 MAIN_ACC1_CODE,
                             MAIN_ACC2_CODE,
                             DEPT_CODE,
                             PRODUCT_GROUP_CODE,
                             PRODUCT_LINE_CODE,
                             SUBLEDGER_GROUP_CODE,
                             SUBLEDGER_LINE_CODE,
                             POST_YEAR,
                             POST_MONTH,
                             TRX_DATE,
                             TRX_DOC_REF,
                             TRX_DOC_REF_LINE_NUM,
                             TRX_DOC_REF_SEQ_NUM,
                             EPISODE_TYPE,
                             PATIENT_ID,
                             EPISODE_ID,
                             VISIT_ID,
                             NARRATION,
                             TRX_TYPE_CODE,
                             DISTRIBUTION_AMT,
                             GL_INTERFACE_FLAG,
 	 				 		 ADDED_BY_ID,
							 MODIFIED_BY_ID,
							 ADDED_DATE,	
							 MODIFIED_DATE,
							 ADDED_AT_WS_NO,         
							 ADDED_FACILITY_ID,      
							 MODIFIED_AT_WS_NO,      
							 MODIFIED_FACILITY_ID
			)
			VALUES  (		 :nd_facility_id,
							 :d_pend_doc_main_acc1_code,
                             :d_pend_doc_main_acc2_code,
                             :d_pend_doc_dept_code,
                             :d_pend_doc_product_grp_cd,
                             :d_pend_doc_product_line_code,
                             :d_pend_doc_subledger_grp_cd,
                             :d_pend_doc_subledger_ln_cd,
                             :d_hdr_post_year,
                             :d_hdr_post_month,
                             TO_DATE(:d_hdr_doc_date,'DD/MM/YYYY'),
                             RPAD(:d_hdr_doc_type_code,6,' ')||'-'||
			                LPAD(:d_hdr_doc_number,8,'0'),
                             :d_pend_doc_max_line_num + 1,
                             0,
                             NULL,
                             :d_hdr_patient_id,
                             NULL,
                             NULL,
                             :d_hdr_narration,
                             :d_hdr_trx_type_code,
                             :d_dtl2_all_doc_amt,
                             'N',
		 					 USER,                             /o ADDED BY ID    o/
							 USER,                             /o MODIFIED BY ID o/
							 SYSDATE,					       /o ADDED DATE     o/
							sysdate ,                             /o MODIFIED DATE  o/
							:nd_ws_no,	
							:nd_facility_id,
							:nd_ws_no,
							:nd_facility_id
			); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 22;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (operating_facility_id\
,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,\
SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC\
_REF,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_\
ID,VISIT_ID,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT,GL_INTERFACE_FLAG,ADDED_B\
Y_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,\
MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b\
7,:b8,:b9,TO_DATE(:b10,'DD/MM/YYYY'),((RPAD(:b11,6,' ')||'-')||LPAD(:b12,8,'0'\
)),(:b13+1),0,null ,:b14,null ,null ,:b15,:b16,:b17,'N',USER,USER,SYSDATE,sysd\
ate,:b18,:b0,:b18,:b0)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )542;
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
        sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_main_acc1_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_pend_doc_main_acc2_code;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_pend_doc_dept_code;
        sqlstm.sqhstl[3] = (unsigned int  )13;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_pend_doc_product_grp_cd;
        sqlstm.sqhstl[4] = (unsigned int  )6;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_pend_doc_product_line_code;
        sqlstm.sqhstl[5] = (unsigned int  )7;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_pend_doc_subledger_grp_cd;
        sqlstm.sqhstl[6] = (unsigned int  )6;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&d_pend_doc_subledger_ln_cd;
        sqlstm.sqhstl[7] = (unsigned int  )11;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&d_hdr_post_year;
        sqlstm.sqhstl[8] = (unsigned int  )7;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&d_hdr_post_month;
        sqlstm.sqhstl[9] = (unsigned int  )5;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&d_hdr_doc_date;
        sqlstm.sqhstl[10] = (unsigned int  )15;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&d_hdr_doc_type_code;
        sqlstm.sqhstl[11] = (unsigned int  )9;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&d_hdr_doc_number;
        sqlstm.sqhstl[12] = (unsigned int  )11;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&d_pend_doc_max_line_num;
        sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&d_hdr_patient_id;
        sqlstm.sqhstl[14] = (unsigned int  )23;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&d_hdr_narration;
        sqlstm.sqhstl[15] = (unsigned int  )53;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&d_hdr_trx_type_code;
        sqlstm.sqhstl[16] = (unsigned int  )4;
        sqlstm.sqhsts[16] = (         int  )0;
        sqlstm.sqindv[16] = (         void  *)0;
        sqlstm.sqinds[16] = (         int  )0;
        sqlstm.sqharm[16] = (unsigned int  )0;
        sqlstm.sqadto[16] = (unsigned short )0;
        sqlstm.sqtdso[16] = (unsigned short )0;
        sqlstm.sqhstv[17] = (         void  *)&d_dtl2_all_doc_amt;
        sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[17] = (         int  )0;
        sqlstm.sqindv[17] = (         void  *)0;
        sqlstm.sqinds[17] = (         int  )0;
        sqlstm.sqharm[17] = (unsigned int  )0;
        sqlstm.sqadto[17] = (unsigned short )0;
        sqlstm.sqtdso[17] = (unsigned short )0;
        sqlstm.sqhstv[18] = (         void  *)&nd_ws_no;
        sqlstm.sqhstl[18] = (unsigned int  )33;
        sqlstm.sqhsts[18] = (         int  )0;
        sqlstm.sqindv[18] = (         void  *)0;
        sqlstm.sqinds[18] = (         int  )0;
        sqlstm.sqharm[18] = (unsigned int  )0;
        sqlstm.sqadto[18] = (unsigned short )0;
        sqlstm.sqtdso[18] = (unsigned short )0;
        sqlstm.sqhstv[19] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[19] = (unsigned int  )5;
        sqlstm.sqhsts[19] = (         int  )0;
        sqlstm.sqindv[19] = (         void  *)0;
        sqlstm.sqinds[19] = (         int  )0;
        sqlstm.sqharm[19] = (unsigned int  )0;
        sqlstm.sqadto[19] = (unsigned short )0;
        sqlstm.sqtdso[19] = (unsigned short )0;
        sqlstm.sqhstv[20] = (         void  *)&nd_ws_no;
        sqlstm.sqhstl[20] = (unsigned int  )33;
        sqlstm.sqhsts[20] = (         int  )0;
        sqlstm.sqindv[20] = (         void  *)0;
        sqlstm.sqinds[20] = (         int  )0;
        sqlstm.sqharm[20] = (unsigned int  )0;
        sqlstm.sqadto[20] = (unsigned short )0;
        sqlstm.sqtdso[20] = (unsigned short )0;
        sqlstm.sqhstv[21] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[21] = (unsigned int  )5;
        sqlstm.sqhsts[21] = (         int  )0;
        sqlstm.sqindv[21] = (         void  *)0;
        sqlstm.sqinds[21] = (         int  )0;
        sqlstm.sqharm[21] = (unsigned int  )0;
        sqlstm.sqadto[21] = (unsigned short )0;
        sqlstm.sqtdso[21] = (unsigned short )0;
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

}

fetch_recs()
{

    d_hdr_rowid.arr[0]='\0';
	d_sel_doc_type_code.arr[0]  = '\0';
    d_sel_doc_number.arr[0]  = '\0';
	d_hdr_rowid.len=0;
    d_sel_doc_type_code.len  = 0;
    d_sel_doc_number.len  = 0;

    /* EXEC SQL FETCH SEL_HDR_RECS 
	     INTO  :d_hdr_rowid,
		       :d_sel_doc_type_code,
		       :d_sel_doc_number; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )645;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_hdr_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )302;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_sel_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_sel_doc_number;
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


			   

    if(ERROR)
	err_mesg("FETCH failed on cursor SEL_HDR_RECS",0,"");

    if(NODATAFOUND)
	return 0;
	
	d_hdr_rowid.arr[d_hdr_rowid.len]        = '\0';
    d_sel_doc_type_code.arr[d_sel_doc_type_code.len]  = '\0';
    d_sel_doc_number.arr[d_sel_doc_number.len]        = '\0';
   return 1;
	


}

lock_hdr()
{
    
	/* EXEC SQL OPEN ALL_TRN_HDR_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )672;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_hdr_rowid;
 sqlstm.sqhstl[0] = (unsigned int  )302;
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



    if(RESOURCE_BUSY)
	return -1;

    if(ERROR)
	err_mesg("OPEN failed on table ALL_TRN_HDR_CUR",0,"");
    
    d_hdr_doc_type_code.arr[0]                                        = '\0';
    d_hdr_doc_number.arr[0]                                           = '\0';
    d_hdr_patient_id.arr[0]                                           = '\0';
    d_hdr_doc_date.arr[0]                                             = '\0';
    d_hdr_trx_type_code.arr[0]                                        = '\0';
    d_hdr_pat_doc_reference.arr[0]                                    = '\0';
    d_hdr_narration.arr[0]                                            = '\0';
    d_hdr_post_month.arr[0]                                           = '\0';
    d_hdr_post_year.arr[0]                                            = '\0';
    d_hdr_max_line_num.arr[0]                                         = '\0';
    
    d_hdr_doc_type_code.len                                           = 0;
    d_hdr_doc_number.len                                              = 0;
    d_hdr_patient_id.len                                              = 0;
    d_hdr_doc_date.len                                                = 0;
    d_hdr_trx_type_code.len                                           = 0;
    d_hdr_pat_doc_reference.len                                       = 0;
    d_hdr_narration.len                                               = 0;
    d_hdr_post_month.len                                              = 0;
    d_hdr_post_year.len                                               = 0;
    d_hdr_max_line_num.len                                            = 0;

    d_hdr_doc_amt                                                     = 0;

     /* EXEC SQL FETCH ALL_TRN_HDR_CUR
               INTO :d_hdr_doc_type_code,
                    :d_hdr_doc_number,
                    :d_hdr_patient_id,
                    :d_hdr_doc_date,
                    :d_hdr_trx_type_code,
                    :d_hdr_pat_doc_reference,
                    :d_hdr_doc_amt,
                    :d_hdr_narration,
                    :d_hdr_post_month,
                    :d_hdr_post_year,
                    :d_hdr_max_line_num; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 22;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )691;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
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
     sqlstm.sqhstv[5] = (         void  *)&d_hdr_pat_doc_reference;
     sqlstm.sqhstl[5] = (unsigned int  )13;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_hdr_doc_amt;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_hdr_narration;
     sqlstm.sqhstl[7] = (unsigned int  )53;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_hdr_post_month;
     sqlstm.sqhstl[8] = (unsigned int  )5;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_hdr_post_year;
     sqlstm.sqhstl[9] = (unsigned int  )7;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_hdr_max_line_num;
     sqlstm.sqhstl[10] = (unsigned int  )7;
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


    
    if(ERROR||NODATAFOUND)
	err_mesg("FETCH failed on cursor ALL_TRN_HDR_CUR",0,"");

    d_hdr_doc_type_code.arr[d_hdr_doc_type_code.len]                     = '\0';
    d_hdr_doc_number.arr[d_hdr_doc_number.len]                           = '\0';
    d_hdr_patient_id.arr[d_hdr_patient_id.len]                           = '\0';
    d_hdr_doc_date.arr[d_hdr_doc_date.len]                               = '\0';
    d_hdr_trx_type_code.arr[d_hdr_trx_type_code.len]                     = '\0';
    d_hdr_pat_doc_reference.arr[d_hdr_pat_doc_reference.len]             = '\0';
    d_hdr_narration.arr[d_hdr_narration.len]                             = '\0';
    d_hdr_post_month.arr[d_hdr_post_month.len]                           = '\0';
    d_hdr_post_year.arr[d_hdr_post_year.len]                             = '\0';
    d_hdr_max_line_num.arr[d_hdr_max_line_num.len]                       = '\0';
    return 1;

}


fetch_dtl1()
{

    d_dtl1_main_acc1_code.arr[0]                                      = '\0';
    d_dtl1_main_acc2_code.arr[0]                                      = '\0';
    d_dtl1_dept_code.arr[0]                                           = '\0';
    d_dtl1_product_group_code.arr[0]                                  = '\0';
    d_dtl1_product_line_code.arr[0]                                   = '\0';
    d_dtl1_subledger_group_code.arr[0]                                = '\0';
    d_dtl1_subledger_line_code.arr[0]                                 = '\0';
    d_dtl1_narration.arr[0]                                           = '\0';
    d_dtl1_line_num.arr[0]                                            = '\0';
    
    d_dtl1_main_acc1_code.len                                         = 0;
    d_dtl1_main_acc2_code.len                                         = 0;
    d_dtl1_dept_code.len                                              = 0;
    d_dtl1_product_group_code.len                                     = 0;
    d_dtl1_product_line_code.len                                      = 0;
    d_dtl1_subledger_group_code.len                                   = 0;
    d_dtl1_subledger_line_code.len                                    = 0;
    d_dtl1_narration.len                                              = 0;
    d_dtl1_line_num.len                                               = 0;

    d_dtl1_doc_amt                                                    = 0;

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
                    :d_dtl1_narration; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 22;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )750;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
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
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_dtl1_narration;
     sqlstm.sqhstl[9] = (unsigned int  )53;
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


    
    if(ERROR)
	err_mesg("FETCH failed on cursor ALL_TRN_DTL1_CUR",0,"");

    if(NODATAFOUND)
	return 0;

    d_dtl1_line_num.arr[d_dtl1_line_num.len]                             = '\0';
    d_dtl1_main_acc1_code.arr[d_dtl1_main_acc1_code.len]                 = '\0';
    d_dtl1_main_acc2_code.arr[d_dtl1_main_acc2_code.len]                 = '\0';
    d_dtl1_dept_code.arr[d_dtl1_dept_code.len]                           = '\0';
    d_dtl1_product_group_code.arr[d_dtl1_product_group_code.len]         = '\0';
    d_dtl1_product_line_code.arr[d_dtl1_product_line_code.len]           = '\0';
    d_dtl1_subledger_group_code.arr[d_dtl1_subledger_group_code.len]     = '\0';
    d_dtl1_subledger_line_code.arr[d_dtl1_subledger_line_code.len]       = '\0';
    d_dtl1_narration.arr[d_dtl1_narration.len]                           = '\0';

    return 1;
}

fetch_dtl2()
{

    d_dtl2_all_doc_type_code.arr[0]                                   = '\0';
    d_dtl2_all_doc_number.arr[0]                                      = '\0';
    
    d_dtl2_all_doc_type_code.len                                      = 0;
    d_dtl2_all_doc_number.len                                         = 0;

    d_dtl2_all_doc_amt                                                = 0;

     /* EXEC SQL FETCH ALL_TRN_DTL2_CUR
               INTO :d_dtl2_all_doc_type_code,
                    :d_dtl2_all_doc_number,
                    :d_dtl2_all_doc_amt; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 22;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )805;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
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



    if(ERROR)
	err_mesg("FETCH failed on cursor ALL_TRN_DTL2_CUR",0,"");

    if(NODATAFOUND)
	return 0;

    d_dtl2_all_doc_type_code.arr[d_dtl2_all_doc_type_code.len]           = '\0';
    d_dtl2_all_doc_number.arr[d_dtl2_all_doc_number.len]                 = '\0';

    return 1;
}

fetch_pend_doc()
{

    /* EXEC SQL OPEN PEND_DOC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )832;
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



    if(RESOURCE_BUSY)
	return -1;

    if(ERROR)
	err_mesg("OPEN failed on cusor PEND_DOC_CUR",0,"");

    /* EXEC SQL FETCH PEND_DOC_CUR
	      INTO :d_pend_doc_rowid,
                   :d_pend_doc_main_acc1_code,
                   :d_pend_doc_main_acc2_code,
                   :d_pend_doc_dept_code,
                   :d_pend_doc_product_grp_cd,
                   :d_pend_doc_product_line_code,
                   :d_pend_doc_subledger_grp_cd,
                   :d_pend_doc_subledger_ln_cd,
		   :d_pend_doc_max_line_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )859;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )22;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_pend_doc_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_pend_doc_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_pend_doc_product_grp_cd;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_pend_doc_product_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_pend_doc_subledger_grp_cd;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_pend_doc_subledger_ln_cd;
    sqlstm.sqhstl[7] = (unsigned int  )11;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_pend_doc_max_line_num;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
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



    if(ERROR)
	err_mesg("FETCH failed on cursor PEND_DOC_CUR",0,"");

    return 1;

}


log_messg(l_msg_desc,l_line_no)
char l_msg_desc[], l_line_no[];
{

	
    sprintf(d_msg_desc.arr,"%s/%s %4s %s",d_sel_doc_type_code.arr, 
	   d_sel_doc_number.arr,l_line_no,l_msg_desc);

	
	d_msg_desc.len = strlen(d_msg_desc.arr);

        /* EXEC SQL INSERT INTO SY_PROG_MSG
                           ( PGM_ID,
                             MSG_TYPE,
                             MSG_NUM,
                             MSG_DESC,
                             MSG_DATE_TIME, 
							 SESSION_ID,
                             PGM_DATE,
							 OPERATING_FACILITY_ID)
	         VALUES    ( :d_pgm_id,
						  'E',
						 NULL,
						:d_msg_desc,
						SYSDATE,
						:d_session_id,
						:d_pgm_date,
						:nd_facility_id); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 22;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,MSG_TYPE,MSG_NUM,MSG_\
DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE,OPERATING_FACILITY_ID) values (:b0,'E',\
null ,:b1,SYSDATE,:b2,:b3,:b4)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )910;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_pgm_id;
        sqlstm.sqhstl[0] = (unsigned int  )12;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_msg_desc;
        sqlstm.sqhstl[1] = (unsigned int  )74;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_session_id;
        sqlstm.sqhstl[2] = (unsigned int  )18;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_pgm_date;
        sqlstm.sqhstl[3] = (unsigned int  )16;
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



    
        if(ERROR)
	    err_mesg("INSERT failed on table SY_PROG_MSG",0,"");
		       

}
