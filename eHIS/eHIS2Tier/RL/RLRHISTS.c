
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
           char  filnam[45];
};
static const struct sqlcxp sqlfpn =
{
    44,
    "d:\\durai\\proc\\facility_corr_proc\\rlrhists.pc"
};


static unsigned long sqlctx = 1033704429;


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
            void  *sqhstv[12];
   unsigned int   sqhstl[12];
            int   sqhsts[12];
            void  *sqindv[12];
            int   sqinds[12];
   unsigned int   sqharm[12];
   unsigned int   *sqharc[12];
   unsigned short  sqadto[12];
   unsigned short  sqtdso[12];
} sqlstm = {10,12};

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

 static const char *sq0009 = 
"O,C.SAMPLE_ID,C.ANATOMY_SITE_CODE,E.TASK_CODE            ";

 static const char *sq0011 = 
"AILS X where (A.SPECIMEN_NO=X.SPECIMEN_NO and A.OPERATING_FACILITY_ID=X.OPER\
ATING_FACILITY_ID) group by ANATOMY_SITE_CODE)) and A.SECTION_CODE=:b3) and A.\
SECTION_CODE=C.SECTION_CODE) and A.SECTION_CODE=F.SECTION_CODE) and E.TASK_COD\
E=F.TASK_CODE) and A.SOURCE_TYPE=DECODE(:b4,'W','W','C','C','E','E',SOURCE_TYP\
E)) and NVL(A.SOURCE_CODE,'!!!!!!') between :b5 and :b6) and NVL(A.CATEGORY_CO\
DE,'!!!') between :b7 and :b8) order by A.CATEGORY_CODE,A.SPECIMEN_NO,C.SAMPLE\
_ID,C.ANATOMY_SITE_CODE,D.BLOCK_SEQ_NO,E.TASK_CODE            ";

 static const char *sq0013 = 
"AILS X where (A.SPECIMEN_NO=X.SPECIMEN_NO and A.OPERATING_FACILITY_ID=X.OPER\
ATING_FACILITY_ID) group by ANATOMY_SITE_CODE)) and A.SECTION_CODE=:b3) and A.\
SECTION_CODE=C.SECTION_CODE) and A.SECTION_CODE=F.SECTION_CODE) and E.TASK_COD\
E=F.TASK_CODE) and A.SOURCE_TYPE=DECODE(:b4,'W','W','C','C','E','E',SOURCE_TYP\
E)) and NVL(A.SOURCE_CODE,'!!!!!!') between :b5 and :b6) and NVL(A.CATEGORY_CO\
DE,'!!!') between :b7 and :b8) order by A.CATEGORY_CODE,A.SPECIMEN_NO,C.SAMPLE\
_ID,C.ANATOMY_SITE_CODE,D.BLOCK_SEQ_NO,E.TASK_CODE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,185,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,220,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,228,0,0,0,0,0,1,0,
66,0,0,4,236,0,4,263,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
125,0,0,5,109,0,2,288,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
148,0,0,6,0,0,32,298,0,0,0,0,0,1,0,
163,0,0,7,150,0,4,307,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
198,0,0,8,0,0,32,326,0,0,0,0,0,1,0,
213,0,0,9,1081,0,9,366,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
264,0,0,10,0,0,32,372,0,0,0,0,0,1,0,
279,0,0,11,1552,0,9,425,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
330,0,0,12,0,0,32,431,0,0,0,0,0,1,0,
345,0,0,13,1552,0,9,484,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
396,0,0,14,0,0,32,490,0,0,0,0,0,1,0,
411,0,0,9,0,0,13,522,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
466,0,0,15,0,0,32,551,0,0,0,0,0,1,0,
481,0,0,11,0,0,13,587,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
544,0,0,16,0,0,32,615,0,0,0,0,0,1,0,
559,0,0,13,0,0,13,651,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
622,0,0,17,0,0,32,676,0,0,0,0,0,1,0,
637,0,0,9,0,0,15,685,0,0,0,0,0,1,0,
652,0,0,11,0,0,15,690,0,0,0,0,0,1,0,
667,0,0,13,0,0,15,695,0,0,0,0,0,1,0,
682,0,0,18,148,0,6,1116,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
709,0,0,19,148,0,6,1134,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
736,0,0,20,100,0,6,1237,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
759,0,0,21,157,0,4,1340,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
794,0,0,22,0,0,32,1354,0,0,0,0,0,1,0,
809,0,0,23,168,0,4,1367,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
844,0,0,24,0,0,32,1382,0,0,0,0,0,1,0,
859,0,0,25,101,0,4,1392,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
886,0,0,26,0,0,32,1404,0,0,0,0,0,1,0,
901,0,0,27,101,0,6,1461,0,0,1,1,0,1,0,2,3,0,0,
920,0,0,28,49,0,4,1474,0,0,1,0,0,1,0,2,9,0,0,
939,0,0,29,120,0,6,1495,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
962,0,0,30,136,0,6,1505,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/****************************************************************
 * File             : RLRHISTS.pc
 * Author           : Hameed
 * Date Created     : 04/04/2005
 
 * Version          : 4.1

 * Purpose          : To generate the Histology Statistics Report
 
 * Input Parameters : Command Line Arguments
						1  UserId/Password
						2  Session ID
						3  Program Date
						
						Parameters From SY_PROG_PARAM Table

 * Table Accessed   : 

 ****************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


#define MAX_LINES   55
#define OERROR      (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode == 1403
#define LASTROW     (sqlca.sqlcode == 1403)
#define VER         "VER : 4.1\n"
#define ESC         0x1B
#define REP_WIDTH   78

/* EXEC SQL BEGIN DECLARE SECTION; */ 

     /* VARCHAR     nd_operating_facility_id [3],
	             uid_pwd                  [91],
				 nd_file_name             [150],
				 nd_file_no               [15],
				 nd_session_id            [16],
				 nd_pgm_date              [31],
				 d_version_no             [20],
				 d_version                [20],

				 /o* Parameters from SY_PROG_PARAM *o/
				 nd_section_code          [3],
				 nd_section_desc          [41],
				 nd_spec_regd_date_fr     [31],
				 nd_spec_regd_date_fr1     [31], //added for globalisation
				 nd_spec_regd_date_to     [31],
				 nd_spec_regd_date_to1     [31], //added for globalisation
				 nd_option                [2],
				 nd_category_fr           [5],
				 nd_category_to           [5],
				 nd_source_type           [4],	//13.09.2006
				 nd_source_fr             [8],	//13.09.2006
				 nd_source_to             [8],	//13.09.2006
				 /o* To fetch Header  cursor values *o/
				 d_specimen_no            [21],
				 d_category_code          [5],
				 d_category_where         [5],
				 d_category_desc          [41],
				 d_workgroup_desc         [41],
				 d_workgroup_code         [5],
				 d_workgroup_where        [5],
				 d_sample_id              [6],
				 d_anatomy_site_code      [5],
				 d_sample_indicator       [4],
				 d_block_seq_no           [4],
				 d_block_indicator        [4],
				 d_task_code              [5],
				 d_slide_yn               [2],
				 d_spec_stain_yn          [2],
				 d_spec_stain_type_ind    [3],

				 d_prv_category_code      [5],
				 d_prv_workgroup_code     [5],
				 d_prv_specimen_no        [21],
				 d_prv_sample_id          [6],
				 d_prv_block_seq_no       [4],

				 /o* For Header Routine *o/
				 //d_acc_entity_name    [61],
				 d_acc_entity_name        [300],
				 d_user                   [21],
				 d_sysdate                [31],
				 d_sysdate1                [31], //added for globalisation
		/o**************added for globalisation************************o/
				l_translated_value		 [500],
				language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[31]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[3]; } nd_section_code;

struct { unsigned short len; unsigned char arr[41]; } nd_section_desc;

struct { unsigned short len; unsigned char arr[31]; } nd_spec_regd_date_fr;

struct { unsigned short len; unsigned char arr[31]; } nd_spec_regd_date_fr1;

struct { unsigned short len; unsigned char arr[31]; } nd_spec_regd_date_to;

struct { unsigned short len; unsigned char arr[31]; } nd_spec_regd_date_to1;

struct { unsigned short len; unsigned char arr[2]; } nd_option;

struct { unsigned short len; unsigned char arr[5]; } nd_category_fr;

struct { unsigned short len; unsigned char arr[5]; } nd_category_to;

struct { unsigned short len; unsigned char arr[4]; } nd_source_type;

struct { unsigned short len; unsigned char arr[8]; } nd_source_fr;

struct { unsigned short len; unsigned char arr[8]; } nd_source_to;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[5]; } d_category_code;

struct { unsigned short len; unsigned char arr[5]; } d_category_where;

struct { unsigned short len; unsigned char arr[41]; } d_category_desc;

struct { unsigned short len; unsigned char arr[41]; } d_workgroup_desc;

struct { unsigned short len; unsigned char arr[5]; } d_workgroup_code;

struct { unsigned short len; unsigned char arr[5]; } d_workgroup_where;

struct { unsigned short len; unsigned char arr[6]; } d_sample_id;

struct { unsigned short len; unsigned char arr[5]; } d_anatomy_site_code;

struct { unsigned short len; unsigned char arr[4]; } d_sample_indicator;

struct { unsigned short len; unsigned char arr[4]; } d_block_seq_no;

struct { unsigned short len; unsigned char arr[4]; } d_block_indicator;

struct { unsigned short len; unsigned char arr[5]; } d_task_code;

struct { unsigned short len; unsigned char arr[2]; } d_slide_yn;

struct { unsigned short len; unsigned char arr[2]; } d_spec_stain_yn;

struct { unsigned short len; unsigned char arr[3]; } d_spec_stain_type_ind;

struct { unsigned short len; unsigned char arr[5]; } d_prv_category_code;

struct { unsigned short len; unsigned char arr[5]; } d_prv_workgroup_code;

struct { unsigned short len; unsigned char arr[21]; } d_prv_specimen_no;

struct { unsigned short len; unsigned char arr[6]; } d_prv_sample_id;

struct { unsigned short len; unsigned char arr[4]; } d_prv_block_seq_no;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[31]; } d_sysdate;

struct { unsigned short len; unsigned char arr[31]; } d_sysdate1;

struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;

		/***************added for globalisation*************************/

	int  l_tab_exists, d_no_of_control_slides;

	int i; //added for globalisation

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
void print_page_header();
void print_col_heading();
void prepare_new_page();
void print_detl_rec();

void print_no_sample_dtl();
void print_sample_same_dtl();
void print_sample_diff_dtl();
void print_total();
void end_report();

int page_no = 0, line_no = 0;

int l_tot_count1 = 0, l_block_count1 = 0, l_hne_slide_count1 = 0, 
    l_spec_stain_count1 = 0, l_spec_stain_hc_count1 = 0, 
	l_spec_stain_ih_count1 = 0, l_spec_stain_if_count1 = 0,
	l_no_con_slides_count1 = 0; //13.09.2006

int l_tot_count2 = 0, l_block_count2 = 0, l_hne_slide_count2 = 0, 
    l_spec_stain_count2 = 0, l_spec_stain_hc_count2 = 0, 
	l_spec_stain_ih_count2 = 0, l_spec_stain_if_count2 = 0,
	l_no_con_slides_count2 = 0; //13.09.2006

int l_tot_count3 = 0, l_block_count3 = 0, l_hne_slide_count3 = 0, 
    l_spec_stain_count3 = 0, l_spec_stain_hc_count3 = 0, 
	l_spec_stain_ih_count3 = 0, l_spec_stain_if_count3 = 0,
	l_no_con_slides_count3 = 0; //13.09.2006

int l_tot_count_g = 0, l_block_count_g = 0, l_hne_slide_count_g = 0, 
    l_spec_stain_count_g = 0, l_spec_stain_hc_count_g = 0, 
	l_spec_stain_ih_count_g = 0, l_spec_stain_if_count_g = 0,
	l_no_con_slides_count_g = 0; //13.09.2006


char flg, spc_brk_flg;

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char //rep_title1[] = "Histology Statistics Report",
     rep_title1[60],
	 rep_title2[60];

char string_var[500];

char local_legend[40][500];//added for globalisation


void proc_main(argc, argv)
int argc;
char *argv[];
{
	void get_params(),
	get_header_dtls(),
	dclr_hdr_no_sample(), 
	dclr_hdr_sample_same(),
	dclr_hdr_sample_diff(),
	do_report();

	if(argc < 4) 
	{
		disp_message(ERR_MESG, "Usage: rlrhists userid/pwd sessionid pgm_date\n");
		proc_exit();
	}

	strcpy(uid_pwd.arr , argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr);

	strcpy(nd_session_id.arr, argv[2]);
	nd_session_id.len = strlen(nd_session_id.arr);

	strcpy(nd_pgm_date.arr, argv[3]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr);

	strcpy(OUTPUT_FILE_NAME, argv[5]);

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	#ifdef DEBUG
		printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
	#endif  

	set_meduser_role();

/*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/*********************** added for globalisation ******************************/


	get_params();

	get_legend_value(37); //added for globalisation

	gen_file_name();
	get_header_dtls();
	
	//s
	//sprintf(string_var, "Date : %s  %s  %s %s",nd_source_fr.arr,
	//                                              nd_source_to.arr,
	//											  nd_source_type.arr, nd_category_to.arr);
	//disp_message(ERR_MESG, string_var);

	dclr_hdr_no_sample();
	dclr_hdr_sample_same();
	dclr_hdr_sample_diff();

	do_report();

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
 if (sqlca.sqlcode < 0) goto err_exit;
}



	fclose(fp);

	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at main() occured....\n");
	proc_exit();
}

void do_report()
{
	void print_rep_header();
	void print_header();
	int fetch_hdr_no_sample();
	int fetch_hdr_sample_same();
	int fetch_hdr_sample_diff();

	page_no = 1;
	line_no = 1;

	print_rep_header();
	print_page_header();
	print_col_heading();

	print_detl_rec();

	close_hdr_no_sample();
	close_hdr_sample_same();
	close_hdr_sample_diff();

	end_report();

}

/*** Get the Parameters from SY_PROG_PARAM Table ***/

void get_params()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL SELECT OPERATING_FACILITY_ID,
	                PARAM1, PARAM2, PARAM3, PARAM4,PARAM5,
					PARAM6, PARAM7, PARAM8 //13.09.2006
	         INTO :nd_operating_facility_id, 
			      :nd_section_code,:nd_spec_regd_date_fr,
				  :nd_spec_regd_date_to,
				  :nd_category_fr, :nd_category_to,
				  :nd_source_type, :nd_source_fr, :nd_source_to //13.09.2006
			 FROM SY_PROG_PARAM
			 WHERE UPPER(PGM_ID) = 'RLRHISTS'
			 AND SESSION_ID = TO_NUMBER(:nd_session_id)
			 AND PGM_DATE = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  fro\
m SY_PROG_PARAM where ((UPPER(PGM_ID)='RLRHISTS' and SESSION_ID=TO_NUMBER(:b9)\
) and PGM_DATE=:b10)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_spec_regd_date_fr;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_spec_regd_date_to;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_category_fr;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_category_to;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_source_type;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_source_fr;
 sqlstm.sqhstl[7] = (unsigned int  )10;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_source_to;
 sqlstm.sqhstl[8] = (unsigned int  )10;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[9] = (unsigned int  )18;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[10] = (unsigned int  )33;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	nd_operating_facility_id.arr[nd_operating_facility_id.len]   = '\0';
	nd_section_code.arr[nd_section_code.len]                     = '\0';
	nd_spec_regd_date_fr.arr[nd_spec_regd_date_fr.len]           = '\0';
	nd_spec_regd_date_to.arr[nd_spec_regd_date_to.len]           = '\0';
	nd_category_fr.arr[nd_category_fr.len]                       = '\0';
	nd_category_to.arr[nd_category_to.len]                       = '\0';
	nd_source_type.arr[nd_source_type.len]                       = '\0'; //13.09.2006
	nd_source_fr.arr[nd_source_fr.len]                           = '\0'; //13.09.2006
	nd_source_to.arr[nd_source_to.len]                           = '\0'; //13.09.2006

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL DELETE FROM SY_PROG_PARAM
	         WHERE UPPER(PGM_ID) = 'RLRHISTS'
			 AND SESSION_ID = TO_NUMBER(:nd_session_id)
			 AND PGM_DATE = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLRHISTS'\
 and SESSION_ID=TO_NUMBER(:b0)) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )125;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}




	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )148;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at get_params() occured....\n");
	proc_exit();
}

/** Get Header informations **/
void get_header_dtls()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL SELECT ACC_ENTITY_NAME,
					USER,
					TO_CHAR(SYSDATE,'DD/MM/YYYY')
             INTO :d_acc_entity_name,
			      :d_user,
				  :d_sysdate
			 FROM SY_ACC_ENTITY_lang_vw
			 WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY') \
into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:b3 and lang\
uage_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )163;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )302;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_user;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
 sqlstm.sqhstl[2] = (unsigned int  )33;
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
 sqlstm.sqhstv[4] = (         void  *)&language_id;
 sqlstm.sqhstl[4] = (unsigned int  )7;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';


	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )198;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
	proc_exit();

}

/** Declare cursor for Single Specimen/Slide (No smaple) **/

void dclr_hdr_no_sample()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL DECLARE NO_SAMPLE_HEADER CURSOR FOR
	SELECT A.SPECIMEN_NO , A.CATEGORY_CODE,
	C.SAMPLE_ID, C.ANATOMY_SITE_CODE, C.SAMPLE_INDICATOR,
	E.TASK_CODE, NVL(F.SLIDE_YN,'N') ,
	NVL(F.SPECIAL_STAIN_YN, 'N'), F.SPECIAL_STAIN_TYPE_IND,
	NVL(C.no_of_control_slides, 0) //13.09.2006
	FROM RL_REQUEST_HEADER A,  RL_SAMPLE_DETAILS C,
		 RL_SAMPLE_TASK_DTL E, RL_TASK_MAST F
	WHERE A.SPEC_REGD_DATE_TIME BETWEEN TO_DATE(:nd_spec_regd_date_fr,'DD/MM/YYYY HH24:MI:SS')
	AND TO_DATE(:nd_spec_regd_date_to,'DD/MM/YYYY HH24:MI:SS')+1
	AND A.SPECIMEN_NO = C.SPECIMEN_NO
	AND A.SPECIMEN_NO = E.SPECIMEN_NO
	AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
	AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID
	AND C.SAMPLE_ID = E.SAMPLE_ID
	AND C.SAMPLE_INDICATOR = 'NA'
	AND A.SECTION_CODE = :nd_section_code
	AND A.SECTION_CODE = C.SECTION_CODE
	AND A.SECTION_CODE = F.SECTION_CODE
	AND E.TASK_CODE = F.TASK_CODE
	AND A.SOURCE_TYPE=DECODE(:nd_source_type,'W','W','C','C','E','E',SOURCE_TYPE)  //ADDED ON 14.05.2007 TO GET WARD/CLINIC/EXTERNAL SOURCES DATA CORRECTLY
	AND NVL(A.SOURCE_CODE, '!!!!!!') BETWEEN :nd_source_fr AND :nd_source_to //13.09.2006
	AND NVL(A.CATEGORY_CODE, '!!!') BETWEEN :nd_category_fr AND :nd_category_to
	ORDER BY A.CATEGORY_CODE,A.SPECIMEN_NO, C.SAMPLE_ID, C.ANATOMY_SITE_CODE,E.TASK_CODE; */ 


	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL OPEN NO_SAMPLE_HEADER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select A.SPECIMEN_NO ,A.CATEGORY_CODE ,C.SAMPLE_ID ,C.ANATOMY_SITE_CODE \
,C.SAMPLE_INDICATOR ,E.TASK_CODE ,NVL(F.SLIDE_YN,'N') ,NVL(F.SPECIAL_STAIN_Y\
N,'N') ,F.SPECIAL_STAIN_TYPE_IND ,NVL(C.no_of_control_slides,0)  from RL_REQ\
UEST_HEADER A ,RL_SAMPLE_DETAILS C ,RL_SAMPLE_TASK_DTL E ,RL_TASK_MAST F whe\
re ((((((((((((((A.SPEC_REGD_DATE_TIME between TO_DATE(:b0,'DD/MM/YYYY HH24:\
MI:SS') and (TO_DATE(:b1,'DD/MM/YYYY HH24:MI:SS')+1) and A.SPECIMEN_NO=C.SPE\
CIMEN_NO) and A.SPECIMEN_NO=E.SPECIMEN_NO) and A.OPERATING_FACILITY_ID=:b2) \
and A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID) and A.OPERATING_FACILIT\
Y_ID=E.OPERATING_FACILITY_ID) and C.SAMPLE_ID=E.SAMPLE_ID) and C.SAMPLE_INDI\
CATOR='NA') and A.SECTION_CODE=:b3) and A.SECTION_CODE=C.SECTION_CODE) and A\
.SECTION_CODE=F.SECTION_CODE) and E.TASK_CODE=F.TASK_CODE) and A.SOURCE_TYPE\
=DECODE(:b4,'W','W','C','C','E','E',SOURCE_TYPE)) and NVL(A.SOURCE_CODE,'!!!\
!!!') between :b5 and :b6) and NVL(A.CATEGORY_CODE,'!!!') between :b7 and :b\
8) order by A.CATEGORY_CODE,A.SPECIMEN_N");
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )213;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_spec_regd_date_fr;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_spec_regd_date_to;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_source_type;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_source_fr;
 sqlstm.sqhstl[5] = (unsigned int  )10;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_source_to;
 sqlstm.sqhstl[6] = (unsigned int  )10;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_category_fr;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_category_to;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )264;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at dclr_hdr_no_sample() occured....\n");
	proc_exit();
}

/** Declare cursor for Single Organ (Anatomy site same for all smaple) **/

void dclr_hdr_sample_same()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL DECLARE SAMPLE_SAME_HEADER CURSOR FOR
	SELECT A.SPECIMEN_NO , A.CATEGORY_CODE,
	C.SAMPLE_ID, C.ANATOMY_SITE_CODE, C.SAMPLE_INDICATOR,
	D.BLOCK_SEQ_NO, D.BLOCK_INDICATOR, E.TASK_CODE, NVL(F.SLIDE_YN,'N') ,
	NVL(F.SPECIAL_STAIN_YN, 'N'), F.SPECIAL_STAIN_TYPE_IND,
	NVL(C.no_of_control_slides, 0) //13.09.2006
	FROM RL_REQUEST_HEADER A,  RL_SAMPLE_DETAILS C,
		 RL_BLOCKS_FOR_SAMPLE D, RL_SAMPLE_TASK_DTL E, 
		 RL_TASK_MAST F
	WHERE A.SPEC_REGD_DATE_TIME BETWEEN TO_DATE(:nd_spec_regd_date_fr,'DD/MM/YYYY HH24:MI:SS')
	AND TO_DATE(:nd_spec_regd_date_to,'DD/MM/YYYY HH24:MI:SS')+1
	AND A.SPECIMEN_NO = C.SPECIMEN_NO
	AND A.SPECIMEN_NO = D.SPECIMEN_NO
	AND A.SPECIMEN_NO = E.SPECIMEN_NO
	AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
	AND A.OPERATING_FACILITY_ID = D.OPERATING_FACILITY_ID
	AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID
	AND C.SAMPLE_ID = D.SAMPLE_ID
	AND C.SAMPLE_ID = E.SAMPLE_ID
	AND ( (D.BLOCK_SEQ_NO = E.BLOCK_SEQ_NO AND D.BLOCK_INDICATOR = 'BL')
		  OR ( E.BLOCK_SEQ_NO = 0 AND E.TASK_INDICATOR IN ( 'SA', 'SP') )
//08.09.2005		  D.BLOCK_INDICATOR IN ('SA', 'SP') )
		 )
	AND 1 =  (SELECT COUNT(COUNT(SPECIMEN_NO))FROM RL_SAMPLE_DETAILS X
						  WHERE A.SPECIMEN_NO = X.SPECIMEN_NO
						  AND A.OPERATING_FACILITY_ID = X.OPERATING_FACILITY_ID
						  GROUP BY ANATOMY_SITE_CODE
						  )
	AND A.SECTION_CODE = :nd_section_code
	AND A.SECTION_CODE = C.SECTION_CODE
	AND A.SECTION_CODE = F.SECTION_CODE
	AND E.TASK_CODE = F.TASK_CODE
	AND A.SOURCE_TYPE=DECODE(:nd_source_type,'W','W','C','C','E','E',SOURCE_TYPE)  //ADDED ON 14.05.2007 TO GET WARD/CLINIC/EXTERNAL SOURCES DATA CORRECTLY
	AND NVL(A.SOURCE_CODE, '!!!!!!') BETWEEN :nd_source_fr AND :nd_source_to //13.09.2006
	AND NVL(A.CATEGORY_CODE,'!!!') BETWEEN :nd_category_fr AND :nd_category_to
	ORDER BY A.CATEGORY_CODE,A.SPECIMEN_NO, C.SAMPLE_ID, C.ANATOMY_SITE_CODE,
	         D.BLOCK_SEQ_NO,E.TASK_CODE; */ 



	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL OPEN SAMPLE_SAME_HEADER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select A.SPECIMEN_NO ,A.CATEGORY_CODE ,C.SAMPLE_ID ,C.ANATOMY_SITE_CODE \
,C.SAMPLE_INDICATOR ,D.BLOCK_SEQ_NO ,D.BLOCK_INDICATOR ,E.TASK_CODE ,NVL(F.S\
LIDE_YN,'N') ,NVL(F.SPECIAL_STAIN_YN,'N') ,F.SPECIAL_STAIN_TYPE_IND ,NVL(C.n\
o_of_control_slides,0)  from RL_REQUEST_HEADER A ,RL_SAMPLE_DETAILS C ,RL_BL\
OCKS_FOR_SAMPLE D ,RL_SAMPLE_TASK_DTL E ,RL_TASK_MAST F where ((((((((((((((\
((((A.SPEC_REGD_DATE_TIME between TO_DATE(:b0,'DD/MM/YYYY HH24:MI:SS') and (\
TO_DATE(:b1,'DD/MM/YYYY HH24:MI:SS')+1) and A.SPECIMEN_NO=C.SPECIMEN_NO) and\
 A.SPECIMEN_NO=D.SPECIMEN_NO) and A.SPECIMEN_NO=E.SPECIMEN_NO) and A.OPERATI\
NG_FACILITY_ID=:b2) and A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID) and\
 A.OPERATING_FACILITY_ID=D.OPERATING_FACILITY_ID) and A.OPERATING_FACILITY_I\
D=E.OPERATING_FACILITY_ID) and C.SAMPLE_ID=D.SAMPLE_ID) and C.SAMPLE_ID=E.SA\
MPLE_ID) and ((D.BLOCK_SEQ_NO=E.BLOCK_SEQ_NO and D.BLOCK_INDICATOR='BL') or \
(E.BLOCK_SEQ_NO=0 and E.TASK_INDICATOR in ('SA','SP')))) and 1=(select count\
(count(SPECIMEN_NO))  from RL_SAMPLE_DET");
 sqlstm.stmt = sq0011;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )279;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_spec_regd_date_fr;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_spec_regd_date_to;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_source_type;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_source_fr;
 sqlstm.sqhstl[5] = (unsigned int  )10;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_source_to;
 sqlstm.sqhstl[6] = (unsigned int  )10;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_category_fr;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_category_to;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )330;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at dclr_hdr_sample_same() occured....\n");
	proc_exit();
}

/** Declare cursor for Specimen with more than one tissue/Organ 
    (Anatomy site different for all smaple) **/

void dclr_hdr_sample_diff()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL DECLARE SAMPLE_DIFF_HEADER CURSOR FOR
	SELECT A.SPECIMEN_NO , A.CATEGORY_CODE,
	C.SAMPLE_ID, C.ANATOMY_SITE_CODE, C.SAMPLE_INDICATOR,
	D.BLOCK_SEQ_NO, D.BLOCK_INDICATOR, E.TASK_CODE, NVL(F.SLIDE_YN,'N') ,
	NVL(F.SPECIAL_STAIN_YN, 'N'), F.SPECIAL_STAIN_TYPE_IND,
	NVL(C.no_of_control_slides, 0)
	FROM RL_REQUEST_HEADER A,  RL_SAMPLE_DETAILS C,
		 RL_BLOCKS_FOR_SAMPLE D, RL_SAMPLE_TASK_DTL E, 
		 RL_TASK_MAST F
	WHERE A.SPEC_REGD_DATE_TIME BETWEEN TO_DATE(:nd_spec_regd_date_fr,'DD/MM/YYYY HH24:MI:SS')
	AND TO_DATE(:nd_spec_regd_date_to,'DD/MM/YYYY HH24:MI:SS')+1 
	AND A.SPECIMEN_NO = C.SPECIMEN_NO
	AND A.SPECIMEN_NO = D.SPECIMEN_NO
	AND A.SPECIMEN_NO = E.SPECIMEN_NO
	AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
	AND A.OPERATING_FACILITY_ID = D.OPERATING_FACILITY_ID
	AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID
	AND C.SAMPLE_ID = D.SAMPLE_ID
	AND C.SAMPLE_ID = E.SAMPLE_ID
	AND ( (D.BLOCK_SEQ_NO = E.BLOCK_SEQ_NO AND D.BLOCK_INDICATOR = 'BL')
		  OR ( E.BLOCK_SEQ_NO = 0 AND E.TASK_INDICATOR IN ( 'SA', 'SP') )
//08.09.2005		  D.BLOCK_INDICATOR IN ('SA', 'SP') )
		 )
	AND 1 <  (SELECT COUNT(COUNT(SPECIMEN_NO))FROM RL_SAMPLE_DETAILS X
						  WHERE A.SPECIMEN_NO = X.SPECIMEN_NO
						  AND A.OPERATING_FACILITY_ID = X.OPERATING_FACILITY_ID
						  GROUP BY ANATOMY_SITE_CODE
						  )
	AND A.SECTION_CODE = :nd_section_code
	AND A.SECTION_CODE = C.SECTION_CODE
	AND A.SECTION_CODE = F.SECTION_CODE
	AND E.TASK_CODE = F.TASK_CODE
	AND A.SOURCE_TYPE=DECODE(:nd_source_type,'W','W','C','C','E','E',SOURCE_TYPE)  //ADDED ON 14.05.2007 TO GET WARD/CLINIC/EXTERNAL SOURCES DATA CORRECTLY
	AND NVL(A.SOURCE_CODE, '!!!!!!') BETWEEN :nd_source_fr AND :nd_source_to //13.09.2006
	AND NVL(A.CATEGORY_CODE, '!!!') BETWEEN :nd_category_fr AND :nd_category_to
	ORDER BY A.CATEGORY_CODE,A.SPECIMEN_NO, C.SAMPLE_ID, C.ANATOMY_SITE_CODE,
	         D.BLOCK_SEQ_NO,E.TASK_CODE; */ 


	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL OPEN SAMPLE_DIFF_HEADER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select A.SPECIMEN_NO ,A.CATEGORY_CODE ,C.SAMPLE_ID ,C.ANATOMY_SITE_CODE \
,C.SAMPLE_INDICATOR ,D.BLOCK_SEQ_NO ,D.BLOCK_INDICATOR ,E.TASK_CODE ,NVL(F.S\
LIDE_YN,'N') ,NVL(F.SPECIAL_STAIN_YN,'N') ,F.SPECIAL_STAIN_TYPE_IND ,NVL(C.n\
o_of_control_slides,0)  from RL_REQUEST_HEADER A ,RL_SAMPLE_DETAILS C ,RL_BL\
OCKS_FOR_SAMPLE D ,RL_SAMPLE_TASK_DTL E ,RL_TASK_MAST F where ((((((((((((((\
((((A.SPEC_REGD_DATE_TIME between TO_DATE(:b0,'DD/MM/YYYY HH24:MI:SS') and (\
TO_DATE(:b1,'DD/MM/YYYY HH24:MI:SS')+1) and A.SPECIMEN_NO=C.SPECIMEN_NO) and\
 A.SPECIMEN_NO=D.SPECIMEN_NO) and A.SPECIMEN_NO=E.SPECIMEN_NO) and A.OPERATI\
NG_FACILITY_ID=:b2) and A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID) and\
 A.OPERATING_FACILITY_ID=D.OPERATING_FACILITY_ID) and A.OPERATING_FACILITY_I\
D=E.OPERATING_FACILITY_ID) and C.SAMPLE_ID=D.SAMPLE_ID) and C.SAMPLE_ID=E.SA\
MPLE_ID) and ((D.BLOCK_SEQ_NO=E.BLOCK_SEQ_NO and D.BLOCK_INDICATOR='BL') or \
(E.BLOCK_SEQ_NO=0 and E.TASK_INDICATOR in ('SA','SP')))) and 1<(select count\
(count(SPECIMEN_NO))  from RL_SAMPLE_DET");
 sqlstm.stmt = sq0013;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )345;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_spec_regd_date_fr;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_spec_regd_date_to;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_source_type;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_source_fr;
 sqlstm.sqhstl[5] = (unsigned int  )10;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_source_to;
 sqlstm.sqhstl[6] = (unsigned int  )10;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_category_fr;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_category_to;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )396;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at dclr_hdr_sample_same() occured....\n");
	proc_exit();
}

/** Fetch Cursor (Single Specimen/Slide - No sample) **/

int fetch_hdr_no_sample()
{
	d_specimen_no.arr[0]         = '\0';
	d_category_code.arr[0]       = '\0';
	d_sample_id.arr[0]           = '\0';
	d_anatomy_site_code.arr[0]   = '\0';
	d_sample_indicator.arr[0]    = '\0';
	d_task_code.arr[0]           = '\0';
	d_slide_yn.arr[0]            = '\0';
	d_spec_stain_yn.arr[0]       = '\0';
	d_spec_stain_type_ind.arr[0] = '\0';

	d_specimen_no.len          = 0;
	d_category_code.len        = 0;
	d_sample_id.len            = 0;
	d_anatomy_site_code.len    = 0;
	d_sample_indicator.len     = 0;
	d_task_code.len            = 0;
	d_slide_yn.len             = 0;
	d_spec_stain_yn.len        = 0;
	d_spec_stain_type_ind.len  = 0;
	d_no_of_control_slides = 0; //13.09.2006

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL FETCH NO_SAMPLE_HEADER INTO 
	:d_specimen_no,:d_category_code , :d_sample_id, :d_anatomy_site_code,
	:d_sample_indicator,:d_task_code,:d_slide_yn, 
	:d_spec_stain_yn,:d_spec_stain_type_ind, 
	:d_no_of_control_slides; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )411;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_category_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_sample_id;
 sqlstm.sqhstl[2] = (unsigned int  )8;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_anatomy_site_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_sample_indicator;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_task_code;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_slide_yn;
 sqlstm.sqhstl[6] = (unsigned int  )4;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_spec_stain_yn;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_spec_stain_type_ind;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_no_of_control_slides;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

 //13.09.2006

	if (NODATAFOUND)
		return 0;

	d_specimen_no.arr[d_specimen_no.len]                 = '\0';
	d_category_code.arr[d_category_code.len]             = '\0';
	d_sample_id.arr[d_sample_id.len]                     = '\0';
	d_anatomy_site_code.arr[d_anatomy_site_code.len]     = '\0';
	d_sample_indicator.arr[d_sample_indicator.len]       = '\0';
	d_task_code.arr[d_task_code.len]                     = '\0';
	d_slide_yn.arr[d_slide_yn.len]                       = '\0';
	d_spec_stain_yn.arr[d_spec_stain_yn.len]             = '\0';
	d_spec_stain_type_ind.arr[d_spec_stain_type_ind.len] = '\0';

// 07.09.2005
	l_tot_count1 += 1;

//13.09.2006
	//l_no_con_slides_count1 = l_no_con_slides_count1 + d_no_of_control_slides; 

	return 1;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )466;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG, "Oracle error at fetch_hdr_no_sample() occured....\n");
	proc_exit();
}

/** Fetch Cursor (Single Organ - Same anatomy for all sample) **/

int fetch_hdr_sample_same()
{
	d_specimen_no.arr[0]         = '\0';
	d_category_code.arr[0]       = '\0';
	d_sample_id.arr[0]           = '\0';
	d_anatomy_site_code.arr[0]   = '\0';
	d_sample_indicator.arr[0]    = '\0';
	d_block_seq_no.arr[0]        = '\0';
	d_block_indicator.arr[0]     = '\0';
	d_task_code.arr[0]           = '\0';
	d_slide_yn.arr[0]            = '\0';
	d_spec_stain_yn.arr[0]       = '\0';
	d_spec_stain_type_ind.arr[0] = '\0';

	d_specimen_no.len          = 0;
	d_category_code.len        = 0;
	d_sample_id.len            = 0;
	d_anatomy_site_code.len    = 0;
	d_sample_indicator.len     = 0;
	d_block_seq_no.len         = 0;
	d_block_indicator.len      = 0;
	d_task_code.len            = 0;
	d_slide_yn.len             = 0;
	d_spec_stain_yn.len        = 0;
	d_spec_stain_type_ind.len  = 0;
	d_no_of_control_slides     = 0; //13.09.2006

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL FETCH SAMPLE_SAME_HEADER INTO 
	:d_specimen_no,:d_category_code , :d_sample_id, :d_anatomy_site_code,
	:d_sample_indicator,:d_block_seq_no,:d_block_indicator,:d_task_code,:d_slide_yn, 
	:d_spec_stain_yn,:d_spec_stain_type_ind, 
	:d_no_of_control_slides; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )481;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_category_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_sample_id;
 sqlstm.sqhstl[2] = (unsigned int  )8;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_anatomy_site_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_sample_indicator;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_block_seq_no;
 sqlstm.sqhstl[5] = (unsigned int  )6;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_block_indicator;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_task_code;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_slide_yn;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_spec_stain_yn;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_spec_stain_type_ind;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_no_of_control_slides;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

 //13.09.2006

	if (NODATAFOUND)
		return 0;

	d_specimen_no.arr[d_specimen_no.len]                 = '\0';
	d_category_code.arr[d_category_code.len]             = '\0';
	d_sample_id.arr[d_sample_id.len]                     = '\0';
	d_anatomy_site_code.arr[d_anatomy_site_code.len]     = '\0';
	d_sample_indicator.arr[d_sample_indicator.len]       = '\0';
	d_block_seq_no.arr[d_block_seq_no.len]               = '\0';
	d_block_indicator.arr[d_block_indicator.len]         = '\0';
	d_task_code.arr[d_task_code.len]                     = '\0';
	d_slide_yn.arr[d_slide_yn.len]                       = '\0';
	d_spec_stain_yn.arr[d_spec_stain_yn.len]             = '\0';
	d_spec_stain_type_ind.arr[d_spec_stain_type_ind.len] = '\0';

//13.09.2006
	//l_no_con_slides_count2 = l_no_con_slides_count2 + d_no_of_control_slides; 

	return 1;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )544;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG, "Oracle error at fetch_hdr_sample_same() occured....\n");
	proc_exit();
}

/** Fetch Cursor (Single Organ - Same anatomy for all sample) **/

int fetch_hdr_sample_diff()
{
	d_specimen_no.arr[0]         = '\0';
	d_category_code.arr[0]       = '\0';
	d_sample_id.arr[0]           = '\0';
	d_anatomy_site_code.arr[0]   = '\0';
	d_sample_indicator.arr[0]    = '\0';
	d_block_seq_no.arr[0]        = '\0';
	d_block_indicator.arr[0]     = '\0';
	d_task_code.arr[0]           = '\0';
	d_slide_yn.arr[0]            = '\0';
	d_spec_stain_yn.arr[0]       = '\0';
	d_spec_stain_type_ind.arr[0] = '\0';

	d_specimen_no.len          = 0;
	d_category_code.len        = 0;
	d_sample_id.len            = 0;
	d_anatomy_site_code.len    = 0;
	d_sample_indicator.len     = 0;
	d_block_seq_no.len         = 0;
	d_block_indicator.len      = 0;
	d_task_code.len            = 0;
	d_slide_yn.len             = 0;
	d_spec_stain_yn.len        = 0;
	d_spec_stain_type_ind.len  = 0;
	d_no_of_control_slides = 0; //13.09.2006

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL FETCH SAMPLE_DIFF_HEADER INTO 
	:d_specimen_no,:d_category_code , :d_sample_id, :d_anatomy_site_code,
	:d_sample_indicator,:d_block_seq_no,:d_block_indicator, :d_task_code,:d_slide_yn, 
	:d_spec_stain_yn, :d_spec_stain_type_ind,
	:d_no_of_control_slides; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )559;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_category_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_sample_id;
 sqlstm.sqhstl[2] = (unsigned int  )8;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_anatomy_site_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_sample_indicator;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_block_seq_no;
 sqlstm.sqhstl[5] = (unsigned int  )6;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_block_indicator;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_task_code;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_slide_yn;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_spec_stain_yn;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_spec_stain_type_ind;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_no_of_control_slides;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

 //13.09.2006

	if (NODATAFOUND)
		return 0;

	d_specimen_no.arr[d_specimen_no.len]                 = '\0';
	d_category_code.arr[d_category_code.len]             = '\0';
	d_sample_id.arr[d_sample_id.len]                     = '\0';
	d_anatomy_site_code.arr[d_anatomy_site_code.len]     = '\0';
	d_sample_indicator.arr[d_sample_indicator.len]       = '\0';
	d_block_seq_no.arr[d_block_seq_no.len]               = '\0';
	d_block_indicator.arr[d_block_indicator.len]         = '\0';
	d_task_code.arr[d_task_code.len]                     = '\0';
	d_slide_yn.arr[d_slide_yn.len]                       = '\0';
	d_spec_stain_yn.arr[d_spec_stain_yn.len]             = '\0';
	d_spec_stain_type_ind.arr[d_spec_stain_type_ind.len] = '\0';

	return 1;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )622;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG, "Oracle error at fetch_hdr_sample_diff() occured....\n");
	proc_exit();
}

/** Close Category Header Cursor **/

close_hdr_no_sample()
{
	/* EXEC SQL CLOSE NO_SAMPLE_HEADER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )637;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

close_hdr_sample_same()
{
	/* EXEC SQL CLOSE SAMPLE_SAME_HEADER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )652;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

close_hdr_sample_diff()
{
	/* EXEC SQL CLOSE SAMPLE_DIFF_HEADER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )667;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/** Print Detail Record **/
void print_detl_rec()
{
	print_no_sample_dtl();
	print_sample_same_dtl();
	print_sample_diff_dtl();
	print_total();
}

/** Print details for No Sample **/

void print_no_sample_dtl()
{
	int still_rec_exist = 0;
	
	still_rec_exist = fetch_hdr_no_sample();
	
	strcpy(d_prv_category_code.arr, d_category_code.arr);

	strcpy(d_prv_specimen_no.arr, d_specimen_no.arr);

//	Commented by Sai Dutt on 07.09.2005 as incrementing of l_tot_count1
//  should be in the fetch_hdr_no_sample()
//	l_tot_count1 += 1;

//	Commented by Sai Dutt on 07.09.2005 as incrementing of l_tot_count1
//  should be based on the previous value of d_prv_specimen_no.arr so first 
//  the value of d_prv_specimen_no.arr made to 'xxxxxx'
//	l_tot_count1 += 1;
	strcpy(d_prv_specimen_no.arr, "xxxxxx");

	while (still_rec_exist)
	{
		if (strcmp(d_prv_specimen_no.arr, d_specimen_no.arr) != 0)
		{
			l_tot_count1++;
			strcpy(d_prv_specimen_no.arr, d_specimen_no.arr);

			//13.09.2006
			l_no_con_slides_count1 = l_no_con_slides_count1 + d_no_of_control_slides; 

		}
		//13.09.2006
		else if (strcmp(d_prv_sample_id.arr, d_sample_id.arr) != 0)
		{
			l_no_con_slides_count1 = l_no_con_slides_count1 + d_no_of_control_slides; 
			strcpy(d_prv_sample_id.arr, d_sample_id.arr);
//			sprintf(string_var, "2222 %s 22 %s 33 %s 44 %s ss %d dd %d", d_prv_specimen_no.arr, d_specimen_no.arr, d_prv_sample_id.arr, d_sample_id.arr, d_no_of_control_slides, l_no_con_slides_count3);
//			disp_message(ERR_MESG, string_var);
		}
		
		if ((strcmp(d_slide_yn.arr, "Y") == 0) && (strcmp(d_spec_stain_yn.arr, "Y") == 0))
		{
			l_spec_stain_count1++;

			if (strcmp(d_spec_stain_type_ind.arr, "HC") == 0)
			{
				l_spec_stain_hc_count1 += 1;
			}
			if (strcmp(d_spec_stain_type_ind.arr, "IH") == 0)
			{
				l_spec_stain_ih_count1 += 1;
			}
			if (strcmp(d_spec_stain_type_ind.arr, "IF") == 0)
			{
				l_spec_stain_if_count1 += 1;
			}

		}
		else if(strcmp(d_slide_yn.arr, "Y") == 0)
		{
			l_hne_slide_count1++;
		}
		
		still_rec_exist = fetch_hdr_no_sample();

		if(still_rec_exist == 0 )
		{
			chk_break();
			fprintf(fp, "%-8.8s  %-6d  %6s  %-6d  %-7d  %-9d  %-8d%-8d%-8d\n", 
			            "A", l_tot_count1, " ", l_hne_slide_count1,l_spec_stain_count1,
						l_spec_stain_hc_count1, l_spec_stain_ih_count1, l_spec_stain_if_count1, l_no_con_slides_count1);

//13.09.2006			fprintf(fp, "%-8.8s  %-6d  %6s  %-6d  %-7d  %-9d  %-9d  %-11d\n", 
//13.09.2006			            "A", l_tot_count1, " ", l_hne_slide_count1,l_spec_stain_count1,
//13.09.2006						l_spec_stain_hc_count1, l_spec_stain_ih_count1, l_spec_stain_if_count1);
			fprintf(fp,"\n");
			line_no += 1;
		}
	}

}

/** Print details for Sample with Same Anatomy site **/

void print_sample_same_dtl()
{
	int still_rec_exist = 0;
	
	still_rec_exist = fetch_hdr_sample_same();
	
	strcpy(d_prv_category_code.arr, d_category_code.arr);
	strcpy(d_prv_specimen_no.arr, d_specimen_no.arr);
	
	flg = 'N';
	spc_brk_flg = 'N';
	
//	Commented by Sai Dutt on 07.09.2005 as incrementing of l_tot_count2
//  should be based on the previous value of d_prv_specimen_no.arr so first 
//  the value of d_prv_specimen_no.arr made to 'xxxxxx'
//	l_tot_count2 += 1;
	strcpy(d_prv_specimen_no.arr, "xxxxxx");

	while (still_rec_exist)
	{
		if (strcmp(d_prv_specimen_no.arr, d_specimen_no.arr) != 0)
		{

			l_tot_count2++;
			strcpy(d_prv_specimen_no.arr, d_specimen_no.arr);

			strcpy(d_prv_sample_id.arr, d_sample_id.arr);	//08.09.2005
			strcpy(d_prv_block_seq_no.arr, d_block_seq_no.arr);	//08.09.2005


			//13.09.2006
			l_no_con_slides_count2 = l_no_con_slides_count2 + d_no_of_control_slides; 

			spc_brk_flg = 'Y';
		}
		//13.09.2006
		else if (strcmp(d_prv_sample_id.arr, d_sample_id.arr) != 0)
		{
			l_no_con_slides_count2 = l_no_con_slides_count2 + d_no_of_control_slides; 
//			sprintf(string_var, "2222 %s 22 %s 33 %s 44 %s ss %d dd %d", d_prv_specimen_no.arr, d_specimen_no.arr, d_prv_sample_id.arr, d_sample_id.arr, d_no_of_control_slides, l_no_con_slides_count3);
//			disp_message(ERR_MESG, string_var);
		}

		
		if ((strcmp(d_slide_yn.arr, "Y") == 0) && (strcmp(d_spec_stain_yn.arr, "Y") == 0))
		{
			l_spec_stain_count2++;

			if (strcmp(d_spec_stain_type_ind.arr, "HC") == 0)
			{
				l_spec_stain_hc_count2 += 1;
			}
			if (strcmp(d_spec_stain_type_ind.arr, "IH") == 0)
			{
				l_spec_stain_ih_count2 += 1;
			}
			if (strcmp(d_spec_stain_type_ind.arr, "IF") == 0)
			{
				l_spec_stain_if_count2 += 1;
			}

		}
		else if(strcmp(d_slide_yn.arr, "Y") == 0)
		{
			l_hne_slide_count2++;
		}
		
		/** For counting Number of Blocks **/

		if (strcmp(d_block_indicator.arr, "BL") == 0 )
		{

/*	//08.09.2005

			if (flg == 'N')
			{
				strcpy(d_prv_sample_id.arr, d_sample_id.arr);
				strcpy(d_prv_block_seq_no.arr, d_block_seq_no.arr);
				l_block_count2 += 1;
				flg = 'Y';
			}
	//08.09.2005
*/
			if ((spc_brk_flg == 'Y') ||
			    (strcmp(d_prv_sample_id.arr, d_sample_id.arr) != 0) ||
			    (strcmp(d_prv_block_seq_no.arr, d_block_seq_no.arr) != 0))
			{
				l_block_count2 += 1;
				spc_brk_flg = 'N';
			}

			strcpy(d_prv_sample_id.arr, d_sample_id.arr);
			strcpy(d_prv_block_seq_no.arr, d_block_seq_no.arr);
		}

		still_rec_exist = fetch_hdr_sample_same();

		if(still_rec_exist == 0 )
		{
			chk_break();
			fprintf(fp, "%-8.8s  %-6d  %-6d  %-6d  %-7d  %-9d  %-8d%-8d%-8d\n", 
			            "B", l_tot_count2, l_block_count2, l_hne_slide_count2,l_spec_stain_count2,
						l_spec_stain_hc_count2, l_spec_stain_ih_count2, l_spec_stain_if_count2, l_no_con_slides_count2);

//13.09.3006			fprintf(fp, "%-8.8s  %-6d  %-6d  %-6d  %-7d  %-9d  %-9d  %-11d\n", 
//13.09.3006		            "B", l_tot_count2, l_block_count2, l_hne_slide_count2,l_spec_stain_count2,
//13.09.3006						l_spec_stain_hc_count2, l_spec_stain_ih_count2, l_spec_stain_if_count2);
			fprintf(fp,"\n");
			line_no += 1;
		}
	}

}

/** Print details for Sample with Different Anatomy site **/

void print_sample_diff_dtl()
{
	int still_rec_exist = 0;
	
	still_rec_exist = fetch_hdr_sample_diff();
	

	strcpy(d_prv_category_code.arr, d_category_code.arr);

	strcpy(d_prv_specimen_no.arr, d_specimen_no.arr);

	flg = 'N';
	spc_brk_flg = 'N';
	
//	Commented by Sai Dutt on 07.09.2005 as incrementing of l_tot_count3
//  should be based on the previous value of d_prv_specimen_no.arr so first 
//  the value of d_prv_specimen_no.arr made to 'xxxxxx'
//	l_tot_count3 += 1;
	strcpy(d_prv_specimen_no.arr, "xxxxxx");

	while (still_rec_exist)
	{

		if (strcmp(d_prv_specimen_no.arr, d_specimen_no.arr) != 0)
		{
			l_tot_count3++;

			strcpy(d_prv_specimen_no.arr, d_specimen_no.arr);

			strcpy(d_prv_sample_id.arr, d_sample_id.arr);	//08.09.2005
			strcpy(d_prv_block_seq_no.arr, d_block_seq_no.arr);	//08.09.2005


			//13.09.2006
			l_no_con_slides_count3 = l_no_con_slides_count3 + d_no_of_control_slides; 

//			sprintf(string_var, "1111111 %s 22 %s 33 %s 44 %s ss %d dd %d", d_prv_specimen_no.arr, d_specimen_no.arr, d_prv_sample_id.arr, d_sample_id.arr, d_no_of_control_slides, l_no_con_slides_count3);
//			disp_message(ERR_MESG, string_var);

			spc_brk_flg = 'Y';
		}
		//13.09.2006
		else if (strcmp(d_prv_sample_id.arr, d_sample_id.arr) != 0)
		{
			l_no_con_slides_count3 = l_no_con_slides_count3 + d_no_of_control_slides; 
//			sprintf(string_var, "2222 %s 22 %s 33 %s 44 %s ss %d dd %d", d_prv_specimen_no.arr, d_specimen_no.arr, d_prv_sample_id.arr, d_sample_id.arr, d_no_of_control_slides, l_no_con_slides_count3);
//			disp_message(ERR_MESG, string_var);

		}
		

		if ((strcmp(d_slide_yn.arr, "Y") == 0) && (strcmp(d_spec_stain_yn.arr, "Y") == 0))
		{
			l_spec_stain_count3++;

			if (strcmp(d_spec_stain_type_ind.arr, "HC") == 0)
			{
				l_spec_stain_hc_count3 += 1;
			}
			if (strcmp(d_spec_stain_type_ind.arr, "IH") == 0)
			{
				l_spec_stain_ih_count3 += 1;
			}
			if (strcmp(d_spec_stain_type_ind.arr, "IF") == 0)
			{
				l_spec_stain_if_count3 += 1;
			}

		}
		else if(strcmp(d_slide_yn.arr, "Y") == 0)
		{
			l_hne_slide_count3++;
		}
		
		/** For counting Number of Blocks **/

		if ( strcmp(d_block_indicator.arr, "BL") == 0 )
		{


/*	//08.09.2005

			if (flg == 'N')
			{
				strcpy(d_prv_sample_id.arr, d_sample_id.arr);
				strcpy(d_prv_block_seq_no.arr, d_block_seq_no.arr);
				l_block_count3 += 1;
				flg = 'Y';
			}

	//08.09.2005
*/

			if ((spc_brk_flg == 'Y') ||
			    (strcmp(d_prv_sample_id.arr, d_sample_id.arr) != 0) ||
			    (strcmp(d_prv_block_seq_no.arr, d_block_seq_no.arr) != 0))
			{
				l_block_count3 += 1;
				spc_brk_flg = 'N';
			}

			strcpy(d_prv_sample_id.arr, d_sample_id.arr);
			strcpy(d_prv_block_seq_no.arr, d_block_seq_no.arr);
		}

		still_rec_exist = fetch_hdr_sample_diff();

		if(still_rec_exist == 0 )
		{
			chk_break();

			fprintf(fp, "%-8.8s  %-6d  %-6d  %-6d  %-7d  %-9d  %-8d%-8d%-8d\n", 
			            "C", l_tot_count3, l_block_count3, l_hne_slide_count3,l_spec_stain_count3,
						l_spec_stain_hc_count3, l_spec_stain_ih_count3, l_spec_stain_if_count3, l_no_con_slides_count3);
			fprintf(fp,"\n");

//13.09.2006			fprintf(fp, "%-8.8s  %-6d  %-6d  %-6d  %-7d  %-9d  %-9d  %-11d\n", 
//13.09.2006			            "C", l_tot_count3, l_block_count3, l_hne_slide_count3,l_spec_stain_count3,
//13.09.2006						l_spec_stain_hc_count3, l_spec_stain_ih_count3, l_spec_stain_if_count3);
			fprintf(fp,"\n");
			line_no += 1;
		}
	}

}

/** Print the Total **/

void print_total()
{
	l_tot_count_g           = l_tot_count1 + l_tot_count2 + l_tot_count3;
	l_block_count_g         = l_block_count1 + l_block_count2 + l_block_count3;
	l_hne_slide_count_g     = l_hne_slide_count1 + l_hne_slide_count2 + l_hne_slide_count3;
	l_spec_stain_count_g    = l_spec_stain_count1 + l_spec_stain_count2 + l_spec_stain_count3;
	l_spec_stain_hc_count_g = l_spec_stain_hc_count1 + l_spec_stain_hc_count2 + l_spec_stain_hc_count3;
	l_spec_stain_ih_count_g = l_spec_stain_ih_count1 + l_spec_stain_ih_count2 + l_spec_stain_ih_count3;
	l_spec_stain_if_count_g = l_spec_stain_if_count1 + l_spec_stain_if_count2 + l_spec_stain_if_count3;
	l_no_con_slides_count_g = l_no_con_slides_count1 + l_no_con_slides_count2 + l_no_con_slides_count3; //13.09.2006
	fprintf(fp,"------------------------------------------------------------------------------\n");
//13.09.2006
/*	fprintf(fp, "%-8.8s  %-6d  %-6d  %-6d  %-7d  %-9d  %-8d%-8d%-8d\n", 
			    "Total", l_tot_count_g, l_block_count_g, l_hne_slide_count_g,l_spec_stain_count_g,
				l_spec_stain_hc_count_g, l_spec_stain_ih_count_g, l_spec_stain_if_count_g, l_no_con_slides_count_g);
*/
	fprintf(fp, "%-8.8s  %-6d  %-6d  %-6d  %-7d  %-9d  %-8d%-8d%-8d\n", 
			    local_legend[2], l_tot_count_g, l_block_count_g, l_hne_slide_count_g,l_spec_stain_count_g,
				l_spec_stain_hc_count_g, l_spec_stain_ih_count_g, l_spec_stain_if_count_g, l_no_con_slides_count_g); //added for globalisation

//13.09.2006	fprintf(fp, "%-8.8s  %-6d  %-6d  %-6d  %-7d  %-9d  %-9d  %-11d\n", 
//13.09.2006			    "Total", l_tot_count_g, l_block_count_g, l_hne_slide_count_g,l_spec_stain_count_g,
//13.09.2006				l_spec_stain_hc_count_g, l_spec_stain_ih_count_g, l_spec_stain_if_count_g);
	fprintf(fp,"------------------------------------------------------------------------------\n");
	line_no += 2;


}

/** Print REPORT HEADER **/

void print_rep_header()
{
	void get_section_desc();

	char nd_option_desc[20],
	     nd_category_fr_desc[61],
		 nd_category_to_desc[61],
		 nd_source_type_desc[61], //13.09.2006
	     nd_source_fr_desc[61], //13.09.2006
		 nd_source_to_desc[61]; //13.09.2006

		 int rec_len;//added for globalisation

	
	get_section_desc();

//	if(strcmp(nd_option.arr, "W") == 0)
//	{
//		strcpy(nd_option_desc, "WORKGROUP");
//	}
//	else if(strcmp(nd_option.arr,"C") == 0)
//	{
//		strcpy(nd_option_desc, "CATEGORY");
		strcpy(nd_category_fr_desc, nd_category_fr.arr);
		strcpy(nd_category_to_desc, nd_category_to.arr);
		strcpy(nd_source_fr_desc, nd_source_fr.arr); //13.09.2006
		strcpy(nd_source_to_desc, nd_source_to.arr); //13.09.2006
//	}

	print_header();

	get_version_no();

	fprintf(fp,"%s\n",d_version.arr);
	fprintf(fp,"\n\n\n\n");
	//fprintf(fp,"        ");
	//fprintf(fp,"INPUT PARAMETERS :\n");
	rec_len = strlen(local_legend[3]);//added for globalisation
	print_space(30, rec_len,1);//added for globalisation
	fprintf(fp,"%s :\n", local_legend[3]);//added for globalisation
	//fprintf(fp,"        ");
	//fprintf(fp,"------------------\n\n");
	print_space(30, rec_len,1);//added for globalisation
	print_space(30, rec_len,0);//added for globalisation
	fprintf(fp,"\n\n");//added for globalisation
	//fprintf(fp,"                   ");
	//fprintf(fp,"DATE        FROM : %s\n", nd_spec_regd_date_fr.arr);

          /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_spec_regd_date_fr,'DD/MM/YYYY'), :language_id , t_date);
				//:nd_spec_regd_date_fr1 := to_char(t_date,'DD/MM/YYYY');
				:nd_spec_regd_date_fr1 :=sm_convert_date_2t(to_date(:nd_spec_regd_date_fr,'DD/MM/YYYY'),:language_id);
				END;
			END-EXEC; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 12;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "declare t_date date ; BEGIN :nd_spec_regd_date_fr1 \
:= sm_convert_date_2t ( to_date ( :nd_spec_regd_date_fr , 'DD/MM/YYYY' ) , :la\
nguage_id ) ; END ;";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )682;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&nd_spec_regd_date_fr1;
          sqlstm.sqhstl[0] = (unsigned int  )33;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&nd_spec_regd_date_fr;
          sqlstm.sqhstl[1] = (unsigned int  )33;
          sqlstm.sqhsts[1] = (         int  )0;
          sqlstm.sqindv[1] = (         void  *)0;
          sqlstm.sqinds[1] = (         int  )0;
          sqlstm.sqharm[1] = (unsigned int  )0;
          sqlstm.sqadto[1] = (unsigned short )0;
          sqlstm.sqtdso[1] = (unsigned short )0;
          sqlstm.sqhstv[2] = (         void  *)&language_id;
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



	rec_len = strlen(local_legend[4]);//added for globalisation
	print_space(23, rec_len,1);//added for globalisation
	fprintf(fp,"%s", local_legend[4]);//added for globalisation
	rec_len = strlen(local_legend[5]);//added for globalisation
	print_space(12, rec_len,1);//added for globalisation
	fprintf(fp,"%s : %s\n", local_legend[5], nd_spec_regd_date_fr1.arr);//added for globalisation
	//fprintf(fp,"                   ");
	//fprintf(fp,"              TO : %s\n", nd_spec_regd_date_to.arr);
          /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_spec_regd_date_to,'DD/MM/YYYY'), :language_id , t_date);
				//:nd_spec_regd_date_to1 := to_char(t_date,'DD/MM/YYYY');
				:nd_spec_regd_date_to1 :=sm_convert_date_2t(to_date(:nd_spec_regd_date_to,'DD/MM/YYYY'),:language_id);
				END;
			END-EXEC; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 12;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "declare t_date date ; BEGIN :nd_spec_regd_date_to1 \
:= sm_convert_date_2t ( to_date ( :nd_spec_regd_date_to , 'DD/MM/YYYY' ) , :la\
nguage_id ) ; END ;";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )709;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&nd_spec_regd_date_to1;
          sqlstm.sqhstl[0] = (unsigned int  )33;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&nd_spec_regd_date_to;
          sqlstm.sqhstl[1] = (unsigned int  )33;
          sqlstm.sqhsts[1] = (         int  )0;
          sqlstm.sqindv[1] = (         void  *)0;
          sqlstm.sqinds[1] = (         int  )0;
          sqlstm.sqharm[1] = (unsigned int  )0;
          sqlstm.sqadto[1] = (unsigned short )0;
          sqlstm.sqtdso[1] = (unsigned short )0;
          sqlstm.sqhstv[2] = (         void  *)&language_id;
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


	rec_len = strlen(local_legend[6]);//added for globalisation
	print_space(35, rec_len,1);//added for globalisation
	fprintf(fp,"%s : %s\n", local_legend[6], nd_spec_regd_date_to1.arr);//added for globalisation
	fprintf(fp,"                   ");
	//fprintf(fp,"DEPARTMENT       : %s - %s\n", nd_section_code.arr, nd_section_desc.arr);
	fprintf(fp,"%-17.17s: %s - %s\n", local_legend[7], nd_section_code.arr, nd_section_desc.arr); //added for globalisation
//	fprintf(fp,"                   ");
//	fprintf(fp,"OPTION SELECTED  : %s\n", nd_option_desc);
	
//	if (strcmp(nd_option.arr, "C") == 0)
//	{

/* --Start -- Added by Sai Dutt on 13.09.2006 */
	if (strcmp(nd_source_type.arr, "W") == 0)
	  //strcpy(nd_source_type_desc , "Ward");
	  strcpy(nd_source_type_desc , local_legend[8]); //added for globalisation
	else if (strcmp(nd_source_type.arr, "C") == 0)
	  //strcpy(nd_source_type_desc , "Clinic");
	  strcpy(nd_source_type_desc , local_legend[9]); //added for globalisation
	else if (strcmp(nd_source_type.arr, "E") == 0)
	  //strcpy(nd_source_type_desc , "External");
	  strcpy(nd_source_type_desc , local_legend[10]); //added for globalisation
	else if (strcmp(nd_source_type.arr, "A") == 0)
	  //strcpy(nd_source_type_desc , "All");
	  strcpy(nd_source_type_desc , local_legend[11]); //added for globalisation

		fprintf(fp,"                   ");
		//fprintf(fp,"SOURCE TYPE      : %s\n", nd_source_type_desc);
		fprintf(fp,"%-17.17s: %s\n", local_legend[12], nd_source_type_desc); //added for globalisation


	if (strcmp(nd_source_fr_desc, "!!!!!!") == 0)
	  //strcpy(nd_source_fr_desc , "LOWEST");
	  strcpy(nd_source_fr_desc , local_legend[13]); //added for globalisation
	if (strcmp(nd_source_to_desc, "~~~~~~") == 0)
	  //strcpy(nd_source_to_desc , "HIGHEST");
	  strcpy(nd_source_to_desc , local_legend[14]); //added for globalisation

		fprintf(fp,"                   ");
		//fprintf(fp,"SOURCE FROM      : %s\n", nd_source_fr_desc);
		fprintf(fp,"%-17.17s: %s\n", local_legend[15], nd_source_fr_desc); //added for globalisation
		fprintf(fp,"                   ");
		//fprintf(fp,"SOURCE TO        : %s\n", nd_source_to_desc);
		/* Commented by Durai Rajkumar against RL-ICN-Common-6334 on 05/11/08
		fprintf(fp,"%-17.17s: %s\n", local_legend[16], nd_source_fr_desc); //added for globalisation */
		fprintf(fp,"%-17.17s: %s\n", local_legend[16], nd_source_to_desc);   /* Added by Durai Rajkumar against RL-ICN-Common-6334 on 05/11/08 */
/* --End   -- Added by Sai Dutt on 13.09.2006 */

	if (strcmp(nd_category_fr_desc, "!!!") == 0)
	  //strcpy(nd_category_fr_desc , "LOWEST");
	  strcpy(nd_category_fr_desc , local_legend[13]); //added for globalisation
	if (strcmp(nd_category_to_desc, "~~~") == 0)
	  //strcpy(nd_category_to_desc , "HIGHEST");
	  /* Commented by Durai Rajkumar against RL-ICN-Common-6334 on 05/11/08
	  strcpy(nd_category_fr_desc , local_legend[14]); //added for globalisation */
	  strcpy(nd_category_to_desc , local_legend[14]);						/* Added by Durai Rajkumar against RL-ICN-Common-6334 on 05/11/08 */

		fprintf(fp,"                   ");
		//fprintf(fp,"CATEGORY FROM    : %s\n", nd_category_fr_desc);
		/* Commented by Durai Rajkumar against RL-ICN-Common-6334 on 05/11/08
		fprintf(fp,"%-17.17s: %s\n", local_legend[17], nd_source_fr_desc); //added for globalisation */
		fprintf(fp,"%-17.17s: %s\n", local_legend[17], nd_category_fr_desc); /* Added by Durai Rajkumar against RL-ICN-Common-6334 on 05/11/08 */
		fprintf(fp,"                   ");
		//fprintf(fp,"-CATEGORY TO      : %s\n", nd_category_to_desc);
		/* Commented by Durai Rajkumar against RL-ICN-Common-6334 on 05/11/08
		fprintf(fp,"%-17.17s: %s\n", local_legend[18], nd_source_to_desc); //added for globalisation */
		fprintf(fp,"%-17.17s: %s\n", local_legend[18], nd_category_to_desc); /* Added by Durai Rajkumar against RL-ICN-Common-6334 on 05/11/08 */
//	}

	fprintf(fp,"\n");
	fprintf(fp,"\f");
}

/** Print Header Informations **/

void print_header()
{
	static int first = 1;
	char buf[15];
	int col;
	
	strcpy(rep_title2, "");

	if (first)
	{
		memset(hdr_line1, ' ', REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
        memset(hdr_line4,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL : RL",8);
        col = (int)(REP_WIDTH-strlen(d_acc_entity_name.arr))/2;
        strncpy(hdr_line1+col,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
        /* EXEC SQL EXECUTE
			DECLARE
				t_date   date;
			BEGIN
				//t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI'); //Added HH24:MI by srinivas
				:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
			END;
		END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 12;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert\
_datetime_2t ( SYSDATE , :language_id ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )736;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_sysdate1;
        sqlstm.sqhstl[0] = (unsigned int  )33;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&language_id;
        sqlstm.sqhstl[1] = (unsigned int  )7;
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


		col = (REP_WIDTH-strlen(d_sysdate1.arr));
        strcpy(hdr_line1+col,d_sysdate1.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,d_user.arr);
	}

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRHISTS",14);
    strcpy(rep_title1, local_legend[1] ); //added for globalisation
	col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"%s : %4d",local_legend[19],page_no++);
    //sprintf(buf,"PAGE : %4d",page_no++);
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

    col = (int)(REP_WIDTH-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    if(first)
        fprintf(fp,"%s\n",hdr_line1);
    else
	  { fprintf(fp,"\n");
	    fprintf(fp,"%s\n",hdr_line1);
	  }
    fprintf(fp,"%s\n",hdr_line2);
    fprintf(fp,"%s\n",hdr_line3);
    fprintf(fp,"%s\n",hdr_line4);
    fprintf(fp,"%s\n",hdr_line5);

    first = 0;

}

/** Print Page Header info for all the Pages **/

void print_page_header()
{
	print_header();
	line_no += 5;
}

/** Print Column Heading **/

void print_col_heading()
{
	//fprintf(fp,"Category  No. of  No. of  No. of  No. of   Histo      No of   No of   No of   \n");
	fprintf(fp,"%-8.8s  %-6.6s  %-6.6s  %-6.6s  %-6.6s   %-9.9s  %-6.6s  %-6.6s  %-6.6s  \n",local_legend[20], 
			local_legend[21], local_legend[21], local_legend[21], local_legend[21], local_legend[22], local_legend[21],
			local_legend[21], local_legend[21]); //added for globalisation
	//fprintf(fp,"          Cases   Blocks  H & E   Special  Chemistry  IHC     IMF     Control \n");
	fprintf(fp,"          %-5.5s   %-6.6s  %-5.5s   %-7.7s  %-9.9s  %-6.6s  %-6.6s  %-7.7s \n",
	local_legend[23], local_legend[24], local_legend[25], local_legend[26], local_legend[27], local_legend[28], local_legend[29], local_legend[30]); //added for globalisation
	//fprintf(fp,"                          Slides  Stain                               Slides  \n");
	fprintf(fp,"                          %-6.6s  %-6.6s                              %-6.6s  \n",
	local_legend[31], local_legend[32], local_legend[31]); //added for globalisation
	fprintf(fp,"------------------------------------------------------------------------------\n");

//13.09.2006	fprintf(fp,"Category  No. of  No. of  No. of  No. of   Histo      Immuno-    Immmuno \n");
//13.09.2006	fprintf(fp,"          Cases   Blocks  H & E   Special  Chemistry  Histo      Flouresence \n");
//13.09.2006	fprintf(fp,"                          Slides  Stain               Chemistry\n");
//13.09.2006	fprintf(fp,"------------------------------------------------------------------------------\n");
	line_no += 4;
}

	
/** Generate File Name **/

gen_file_name()
{
	strcpy(nd_file_name.arr, WORKING_DIR);
	nd_file_name.len = strlen(nd_file_name.arr);

	strcat(nd_file_name.arr, OUTPUT_FILE_NAME);
	nd_file_name.len = strlen(nd_file_name.arr);

	if ((fp = fopen(nd_file_name.arr, "w")) == NULL)
	{
		sprintf(string_var,"Error while opening file %s\n", nd_file_name.arr);
		disp_message(ERR_MESG,string_var);
		proc_exit();
	}

}
/** Get the Category Desc **/
get_category_desc(category_cd)
char *category_cd;
{
	
	strcpy(d_category_where.arr, category_cd);
	d_category_where.len = strlen(d_category_where.arr);

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL SELECT LONG_DESC
	         INTO :d_category_desc
			 FROM RL_CATEGORY_CODE_lang_vw
			 WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND SECTION_CODE = :nd_section_code
			 AND CATEGORY_CODE = :d_category_where
			 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from RL_CATEGORY_CODE_lang_vw whe\
re (((OPERATING_FACILITY_ID=:b1 and SECTION_CODE=:b2) and CATEGORY_CODE=:b3) a\
nd language_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )759;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_category_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_category_where;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&language_id;
 sqlstm.sqhstl[4] = (unsigned int  )7;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	d_category_desc.arr[d_category_desc.len]   = '\0';

	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )794;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG, "Oracle error at get_category_desc() occured....\n");
	proc_exit();
}

/** Get The Workgroup desc **/
get_workgroup_desc(work_grp)
char *work_grp;
{
	strcpy(d_workgroup_where.arr, work_grp);
	d_workgroup_where.len = strlen(d_workgroup_where.arr);

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL SELECT LONG_DESC 
	         INTO :d_workgroup_desc
			 FROM RL_OUTST_WORK_GROUP_lang_vw
			 WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND SECTION_CODE = :nd_section_code
			 AND OUTST_WORK_GROUP_CODE = :d_workgroup_where
			 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from RL_OUTST_WORK_GROUP_lang_vw \
where (((OPERATING_FACILITY_ID=:b1 and SECTION_CODE=:b2) and OUTST_WORK_GROUP_\
CODE=:b3) and language_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )809;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_workgroup_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_workgroup_where;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&language_id;
 sqlstm.sqhstl[4] = (unsigned int  )7;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


			 

	d_workgroup_desc.arr[d_workgroup_desc.len] = '\0';

	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )844;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG, "Oracle error at get_workgroup_desc() occured....\n");
	proc_exit();

}

/** Get the Section Desc **/
void get_section_desc()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL SELECT SHORT_NAME
	         INTO :nd_section_desc 
			 FROM RL_SECTION_CODE_lang_vw
			 WHERE SECTION_CODE = :nd_section_code
 			 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_NAME into :b0  from RL_SECTION_CODE_lang_vw whe\
re (SECTION_CODE=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )859;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_section_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	nd_section_desc.arr[nd_section_desc.len]  = '\0';

	return;

err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )886;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG, "Oracle error at get_section_desc occured....\n");
	proc_exit();

}

/** To Prepare New page **/

void prepare_new_page()
{
   fprintf(fp,"\n");
   fprintf(fp,"\f");
   line_no = 1;

   print_page_header();
   print_col_heading();

}

/** to print the last line of the report **/
void end_report()
{
  fprintf(fp,"\n");
  fprintf(fp,"\n");
  //fprintf(fp, "Category A   : Single Specimen/Slide\n");
  fprintf(fp, "%8.8s A   : %s\n", local_legend[20], local_legend[33]); //added for globalisation
  //fprintf(fp, "Category B   : Single Organ\n");
  fprintf(fp, "%8.8s B   : %s\n", local_legend[20], local_legend[34]); //added for globalisation
  //fprintf(fp, "Category C   : Specimen with more than one tissue/organ\n");
  fprintf(fp, "%8.8s C   : %s\n", local_legend[20], local_legend[35]); //added for globalisation
  fprintf(fp,"\n");
  fprintf(fp,"\n");
  //fprintf(fp,"                      ******** End of Report *********");
  fprintf(fp,"                      ******** %s *********", local_legend[36]); //added for globalisation
  fprintf(fp,"\n");
  fprintf(fp,"\f");
}

/** Check for Page Break **/

chk_break()
{
	if ((line_no + 1) >= MAX_LINES)
	{
		prepare_new_page();
	}
}

/** Get the version **/

get_version_no()
{
     d_version_no.arr[0] = '\0';
     d_version_no.len    =  0;

     strcpy(d_version.arr,"VER : ");

	 /* EXEC SQL EXECUTE 
	      begin
			if SM_INSTALLATION_TAB_CHECK THEN
			   :l_tab_exists := 1;
			else
			   :l_tab_exists := 0;
			end if;
		  end;
	 END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )901;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_tab_exists;
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




    if (l_tab_exists) 
    {
	    /* EXEC SQL SELECT VERSION_NO INTO :d_version_no 
                 FROM   SM_INSTALLATION; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )920;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_version_no;
     sqlstm.sqhstl[0] = (unsigned int  )22;
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

 
        d_version_no.arr[d_version_no.len] = '\0';
    }
    else
	    strcpy(d_version_no.arr,"2.1");

	    strcat(d_version.arr,d_version_no.arr);


    if (OERROR)
	{
	    strcpy(d_version_no.arr,"2.1");
	    strcat(d_version.arr,d_version_no.arr);
    }

}

/****************************** added for globalisation *****************************/
get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRHISTS.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRHISTS.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )939;
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
 sqlstm.sqhstv[1] = (         void  *)&language_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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



	for (i=1; i<=cou; i++)
	{
	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRHISTS.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRHISTS.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )962;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&i;
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


	
	l_translated_value.arr[l_translated_value.len] = '\0';

	//sp_message(ERR_MESG,l_translated_value.arr);

	strcpy(local_legend[i],l_translated_value.arr);
	}
 }

print_space(int aa, int bb, int cc)
{
	if (cc ==1)
	{
  		for(i=1;i <= (aa - bb) ;i++)
		{
			fprintf(fp,"%s"," ");
		}	
	}
	else if (cc ==0)
	{
  		for(i= (aa - bb);i <= aa ;i++)
		{
			fprintf(fp,"%s","-");
		}	
	}
}

/*************************** added for globalisation*************************************/
