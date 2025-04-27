
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
           char  filnam[51];
};
static const struct sqlcxp sqlfpn =
{
    50,
    "T:\\BL\\Facility Change Modifications\\BL\\Blbsumry.pc"
};


static unsigned long sqlctx = 464688099;


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
            void  *sqhstv[20];
   unsigned int   sqhstl[20];
            int   sqhsts[20];
            void  *sqindv[20];
            int   sqinds[20];
   unsigned int   sqharm[20];
   unsigned int   *sqharc[20];
   unsigned short  sqadto[20];
   unsigned short  sqtdso[20];
} sqlstm = {10,20};

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
"sh_ctrl_doc_date) between acc_per_start_date and acc_per_end_date))))) or ((\
:b3='N' and :b5='C') and (CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,TRUNC(CASH_C\
TRL_DOC_DATE)) in (select CASH_CTRL_DOC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,TRUNC\
(CASH_CTRL_DOC_DATE)  from BL_GL_EXPORT_TEMP where OPERATING_FACILITY_ID=:b2))\
))           ";

 static const char *sq0007 = 
"select CASH_CTRL_DOC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,TRUNC(CASH_CTRL_DOC_DA\
TE)  from BL_GL_EXPORT_TEMP where OPERATING_FACILITY_ID=:b0           ";

 static const char *sq0008 = 
"select CONCAT_POST_ACC_DESC  from GL_POSTING_ACC where (((((((MAIN_ACC1_CODE\
=:b0 and MAIN_ACC2_CODE=:b1) and DEPT_CODE=:b2) and PRODUCT_GROUP_CODE=:b3) an\
d PRODUCT_LINE_CODE=:b4) and SUBLEDGER_GROUP_CODE=:b5) and SUBLEDGER_LINE_CODE\
=:b6) and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where\
 ACC_ENTITY_ID=:b7))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,218,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,75,0,4,253,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
59,0,0,3,135,0,4,266,0,0,4,1,0,1,0,2,3,0,0,2,3,0,0,2,1,0,0,1,9,0,0,
90,0,0,4,0,0,30,341,0,0,0,0,0,1,0,
105,0,0,5,239,0,4,370,0,0,13,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,1,0,0,2,9,0,0,2,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
172,0,0,6,1347,0,9,483,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,9,0,
0,
247,0,0,7,146,0,9,490,0,0,1,1,0,1,0,1,9,0,0,
266,0,0,6,0,0,15,501,0,0,0,0,0,1,0,
281,0,0,7,0,0,15,506,0,0,0,0,0,1,0,
296,0,0,6,0,0,13,524,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
363,0,0,7,0,0,13,567,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
390,0,0,9,157,0,5,655,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
417,0,0,10,157,0,5,669,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
448,0,0,11,158,0,4,971,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
483,0,0,8,341,0,9,1018,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
530,0,0,8,0,0,13,1023,0,0,1,0,0,1,0,2,9,0,0,
549,0,0,12,373,0,3,1145,0,0,19,19,0,1,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,4,0,0,1,3,0,0,1,9,0,0,
640,0,0,13,539,0,3,1190,0,0,20,20,0,1,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
735,0,0,14,78,0,4,1251,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
758,0,0,15,215,0,4,1264,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
785,0,0,16,214,0,5,1286,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
812,0,0,17,76,0,4,1342,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
835,0,0,18,96,0,4,1362,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
858,0,0,19,172,0,6,1369,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
889,0,0,20,212,0,6,1389,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
916,0,0,21,196,0,6,1411,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
943,0,0,22,184,0,6,1433,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLBSUMRY.PC                                  */
/* AUTHOR                : NITIN KUMAR                                  */
/* Converted To Windows  : Prasad B G S 3/7/96                          */
/* DATE WRITTEN          : 10-DEC-1994                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                                     */
/*                                                                        */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/************************************************************************/
 
/* UPGRADED TO 4.1 */              

#include <stdio.h>
#include <stdlib.h>           
#include <string.h>
#include <bl.h>

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])

/*
#define DEBUG 0   
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR hosp_name                                  [120],
	    date_time                                  [20],
		uid_pwd									   [100],
	    user_id                                    [40],
	    nd_session_id                              [16],
	    nd_pgm_date                                [25],
	    d_curr_pgm_name                            [15],

	    nd_proc_month                              [3],
	    nd_proc_year                               [5],
		nd_proc_year1                              [5],
		nd_proc_year2                              [5],
	    nd_doc_type_code                           [7],
	    nd_doc_date                                [12],
	    nd_fm_trx_date                             [13],
	    nd_to_trx_date                             [13],
		nd_fm_trx_date1                            [13],
	    nd_to_trx_date1                            [13],
	    dummy                                      [2],
	    nd_doc_num                                 [9],
	    nd_operating_facility_id		           [3],
	    nd_ws_no			                       [31],
	    nd_acc_entity_code			               [5],
	    d_module_valid_id			               [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[100]; } uid_pwd;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_proc_month;

struct { unsigned short len; unsigned char arr[5]; } nd_proc_year;

struct { unsigned short len; unsigned char arr[5]; } nd_proc_year1;

struct { unsigned short len; unsigned char arr[5]; } nd_proc_year2;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type_code;

struct { unsigned short len; unsigned char arr[12]; } nd_doc_date;

struct { unsigned short len; unsigned char arr[13]; } nd_fm_trx_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_trx_date;

struct { unsigned short len; unsigned char arr[13]; } nd_fm_trx_date1;

struct { unsigned short len; unsigned char arr[13]; } nd_to_trx_date1;

struct { unsigned short len; unsigned char arr[2]; } dummy;

struct { unsigned short len; unsigned char arr[9]; } nd_doc_num;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[3]; } d_module_valid_id;

 

/* VARCHAR bl_gl_main_acc1_code						[100][7],
	   bl_gl_main_acc2_code							[100][5],
	   bl_gl_dept_code								[100][11],
	   bl_gl_product_group_code						[100][4],
	   bl_gl_product_line_code						[100][5],
	   bl_gl_subledger_group_code					[100][4],
	   bl_gl_subledger_line_code					[100][9],
	   bl_gl_rowid									[100][31],
	   nd_cust_code			       					[100][9],
	   nd_cash_ctrl_doc_type						[100][7],
   	   nd_cash_ctrl_doc_num		   					[100][9],
   	   nd_cash_ctrl_doc_date	   					[100][31]; */ 
struct { unsigned short len; unsigned char arr[10]; } bl_gl_main_acc1_code[100];

struct { unsigned short len; unsigned char arr[6]; } bl_gl_main_acc2_code[100];

struct { unsigned short len; unsigned char arr[14]; } bl_gl_dept_code[100];

struct { unsigned short len; unsigned char arr[6]; } bl_gl_product_group_code[100];

struct { unsigned short len; unsigned char arr[6]; } bl_gl_product_line_code[100];

struct { unsigned short len; unsigned char arr[6]; } bl_gl_subledger_group_code[100];

struct { unsigned short len; unsigned char arr[10]; } bl_gl_subledger_line_code[100];

struct { unsigned short len; unsigned char arr[34]; } bl_gl_rowid[100];

struct { unsigned short len; unsigned char arr[10]; } nd_cust_code[100];

struct { unsigned short len; unsigned char arr[10]; } nd_cash_ctrl_doc_type[100];

struct { unsigned short len; unsigned char arr[10]; } nd_cash_ctrl_doc_num[100];

struct { unsigned short len; unsigned char arr[34]; } nd_cash_ctrl_doc_date[100];



   /* VARCHAR t_rowid                             [31],
	   t_main_acc1_code                        [7],
	   t_main_acc2_code                        [5],
	   t_dept_code                             [11],
	   t_product_group_code                    [4],
	   t_product_line_code                     [5],
	   t_subledger_group_code                  [4],
	   t_subledger_line_code                   [9],
	   t_concat_post_acc_code                  [41],
	   t_concat_post_acc_desc                  [64],
	   t_cash_ctrl_doc_type		 			   [7],
	   d_cash_ctrl_doc_type		 			   [7],
	   t_cash_ctrl_doc_num		   			   [9],
	   d_cash_ctrl_doc_num		   			   [9],
	   t_cash_ctrl_doc_date					   [31],
	   d_cash_ctrl_doc_date					   [31],
	   nd_cust_code1						   [9]; */ 
struct { unsigned short len; unsigned char arr[31]; } t_rowid;

struct { unsigned short len; unsigned char arr[7]; } t_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } t_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } t_dept_code;

struct { unsigned short len; unsigned char arr[4]; } t_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } t_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } t_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } t_subledger_line_code;

struct { unsigned short len; unsigned char arr[41]; } t_concat_post_acc_code;

struct { unsigned short len; unsigned char arr[64]; } t_concat_post_acc_desc;

struct { unsigned short len; unsigned char arr[7]; } t_cash_ctrl_doc_type;

struct { unsigned short len; unsigned char arr[7]; } d_cash_ctrl_doc_type;

struct { unsigned short len; unsigned char arr[9]; } t_cash_ctrl_doc_num;

struct { unsigned short len; unsigned char arr[9]; } d_cash_ctrl_doc_num;

struct { unsigned short len; unsigned char arr[31]; } t_cash_ctrl_doc_date;

struct { unsigned short len; unsigned char arr[31]; } d_cash_ctrl_doc_date;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_code1;


   /* VARCHAR bl_cr_main_acc1_code                    [7],
	   bl_cr_main_acc2_code                        [5],
	   bl_cr_dept_code                             [11],
	   bl_cr_product_group_code                    [4],
	   bl_cr_product_line_code                     [5],
	   bl_cr_subledger_group_code                  [4],
	   bl_cr_subledger_line_code                   [9]; */ 
struct { unsigned short len; unsigned char arr[7]; } bl_cr_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_cr_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } bl_cr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_cr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_cr_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_cr_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_cr_subledger_line_code;


    /* VARCHAR d_message_id  [7],
	        d_message_text[81]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_message_id;

struct { unsigned short len; unsigned char arr[81]; } d_message_text;



  /* VARCHAR nd_lang_id		[4],
		l_pk_value			[100],
		l_translated_value	[201],
		nd_temp_date		[20],
		nd_loc_date			[20],
		date_convert		[20]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;


    double bl_gl_distribution_amt[100];

    double bl_cr_distribution_amt;
    double t_distribution_amt;

    long   d_gl_run_line_num = 0,
	       d_gl_run_line_num_sum = 0;

/* These variables are used for calling post_doc */

int  d_num_of_acc_periods,i;
int  d_curr_year;
int  d_curr_month;
char d_summ_flag, nd_rep_only,nd_trn_type;
char loc_legend[999][201];

char filename[150];
 


long rec_cnt = 0;
char string_var [100];

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


char msg_str[132];

long  hdr_ctr = 0;

char r_err_msg[100];

FILE *fp_sum;

int i, g_err_typ, 
    g_invalid_acc;

char g_err_id[10],
     g_err_msg[80];

long  num_ret = 0;

  int lctr2 = 0,pctr2 = 0;

struct tnode {
    char   *acct_code;
    double dr_amt;
    double cr_amt;
    char   *l_main_acc1_code;
    char   *l_main_acc2_code;
    char   *l_dept_code;
    char   *l_product_group_code;
    char   *l_product_line_code;
    char   *l_subledger_group_code;
    char   *l_subledger_line_code;		
    char   *l_cash_ctrl_doc_type;
    char   *l_cash_ctrl_doc_num;
    char   *l_cash_ctrl_doc_date;		 

    struct tnode *left;
    struct tnode *right;
};

double g_tot_dr_amt = 0,
       g_tot_cr_amt = 0;

struct tnode *root;
char *strdup();
struct tnode *addtree();

void proc_main(argc,argv)
char *argv[];
int argc;
{

    long n;

    if (argc < 6)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLBSUMRY");

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

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
    sqlstm.sqhstl[0] = (unsigned int  )102;
    sqlstm.sqhsts[0] = (         int  )102;
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
	{
		disp_message(ORA_MESG,"Unable to connect to oracle.");
		proc_exit();
    }
    set_meduser_role();
	strcpy(nd_lang_id.arr,l_language_id.arr);
    nd_lang_id.len = l_language_id.len;

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    strcpy(nd_operating_facility_id.arr,argv[5]);
    nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);
    strcpy(g_facility_id,nd_operating_facility_id.arr);

    strcpy(d_module_valid_id.arr , "BL");
    d_module_valid_id.len = strlen(d_module_valid_id.arr);

    fetch_prog_param();
	fetch_legend_value();

    start_prog_msg();


    /* EXEC SQL SELECT acc_entity_code INTO :nd_acc_entity_code
	     FROM sy_acc_entity
	     WHERE  acc_entity_id = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select acc_entity_code into :b0  from sy_acc_entity where\
 acc_entity_id=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
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


         
          nd_acc_entity_code.len = strlen(nd_acc_entity_code.arr);
				
    
    if(nd_rep_only != 'Y')

	start_prog_control();
	
    declare_cur();

	/* EXEC SQL SELECT CURRENT_ACC_YEAR,CURRENT_ACC_MONTH,
		NVL(SUMMARY_PROCESS_FLAG,'X')
	   INTO :d_curr_year,    :d_curr_month,
		:d_summ_flag
	   FROM GL_PARAMETER
	   WHERE ACC_ENTITY_CODE = :nd_acc_entity_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CURRENT_ACC_YEAR ,CURRENT_ACC_MONTH ,NVL(SUMMARY_PROC\
ESS_FLAG,'X') into :b0,:b1,:b2  from GL_PARAMETER where ACC_ENTITY_CODE=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )59;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_curr_year;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_curr_month;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_summ_flag;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_acc_entity_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
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
          err_mesg("SELECT failed on table GL_PARAMETER",0,"");

      if (NOT_FOUND)
       err_mesg("Record not maintained in GL_PARAMETER",0,"");

    open_cur();
    i=0;


    root = NULL;

    do_updt();

    if(nd_rep_only == 'Y')
    {

		do_report(root);
     }
    else 
	{
	strcpy(OUTPUT_FILE_NAME,"blbsumry.log");

      //sprintf(print,"%c",nd_trn_type);
	  //disp_message(ERR_MESG,print);	  

      if (nd_trn_type == 'O' || nd_trn_type == 'A') 
	   {fetch_doc_no();}

		export_gl(root);
	
	if(d_gl_run_line_num_sum) 
	{	    
    
		if (nd_trn_type == 'O' || nd_trn_type == 'A')
		{    
		  ins_hdr_rec_summary();

		  if (post_doc((long)0,nd_doc_type_code.arr,
		    atol(nd_doc_num.arr),r_err_msg) == -1)
			 err_mesg(r_err_msg,0,""); 
	      upd_doc_num();
		}
    
		if (nd_trn_type == 'C')
		{
		  while(fetch_bl_gl_exp_temp())
		 {

            ins_hdr_rec_summary();
			if (post_doc((long)0,d_cash_ctrl_doc_type.arr,
		    atol(d_cash_ctrl_doc_num.arr),r_err_msg) == -1)
			err_mesg(r_err_msg,0,""); 	
		 }
		}
	
	} 
    

   }
	
    close_cur();

    end_prog_msg();
    
    if(nd_rep_only != 'Y')
	end_prog_control();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )90;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
	 err_mesg("COMMIT WORK RELEASE failed",0,"");

    return;
}

fetch_prog_param()
{
    nd_proc_month.arr[0]      = '\0';
    nd_proc_year.arr[0]       = '\0';
    nd_doc_type_code.arr[0]   = '\0';
    nd_doc_date.arr[0]        = '\0';
    nd_fm_trx_date.arr[0]     = '\0';
    nd_to_trx_date.arr[0]     = '\0';
    nd_ws_no.arr[0]	      = '\0';


    nd_proc_month.len         = 0;
    nd_proc_year.len          = 0;
    nd_doc_type_code.len      = 0;
    nd_doc_date.len           = 0;
    nd_fm_trx_date.len        = 0;
    nd_to_trx_date.len        = 0;
    nd_ws_no.len	      = 0;

    nd_rep_only = '\0';
    nd_trn_type = '\0';

   /* EXEC SQL SELECT PARAM1,
		   PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,NVL(PARAM7,'Y'),
		   PARAM8,PARAM9
	      INTO :nd_proc_month,
		   :nd_proc_year,
		   :nd_doc_type_code,
		   :nd_doc_date,
		   :nd_fm_trx_date,
		   :nd_to_trx_date,
		   :nd_rep_only,
		   :nd_ws_no,
		   :nd_trn_type
	      FROM SY_PROG_PARAM
	      WHERE PGM_ID     = :d_curr_pgm_name
	       AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,NVL\
(PARAM7,'Y') ,PARAM8 ,PARAM9 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from SY\
_PROG_PARAM where (((PGM_ID=:b9 and OPERATING_FACILITY_ID=:b10) and SESSION_ID\
=:b11) and PGM_DATE=:b12)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )105;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_proc_month;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_proc_year;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_trx_date;
   sqlstm.sqhstl[4] = (unsigned int  )15;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_trx_date;
   sqlstm.sqhstl[5] = (unsigned int  )15;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_rep_only;
   sqlstm.sqhstl[6] = (unsigned int  )1;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[7] = (unsigned int  )33;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_trn_type;
   sqlstm.sqhstl[8] = (unsigned int  )1;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[9] = (unsigned int  )17;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[11] = (unsigned int  )18;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[12] = (unsigned int  )27;
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

  
		   //disp_message(ERR_MESG,nd_trn_type);

//    

   if (OERROR)
	err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
	err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_proc_month.arr[nd_proc_month.len]       = '\0';
   nd_proc_year.arr[nd_proc_year.len]         = '\0';
   nd_doc_type_code.arr[nd_doc_type_code.len] = '\0';
   nd_doc_date.arr[nd_doc_date.len]           = '\0';
   nd_fm_trx_date.arr[nd_fm_trx_date.len]     = '\0';
   nd_to_trx_date.arr[nd_to_trx_date.len]     = '\0';
   nd_ws_no.arr[nd_ws_no.len]		      = '\0';
}

declare_cur()
{
     /* EXEC SQL DECLARE BL_GL_DISTRIBUTION_CUR CURSOR FOR
	       SELECT ROWID,
		      MAIN_ACC1_CODE,
		      MAIN_ACC2_CODE,
		      DEPT_CODE,
		      PRODUCT_GROUP_CODE,
		      PRODUCT_LINE_CODE,
		      SUBLEDGER_GROUP_CODE,
		      SUBLEDGER_LINE_CODE,
		      NVL(DISTRIBUTION_AMT,0),
		      CUST_CODE,
		      CASH_CTRL_DOC_TYPE,             
		      CASH_CTRL_DOC_NUMBER,
		      trunc(CASH_CTRL_DOC_DATE)  
		 FROM BL_GL_DISTRIBUTION
		WHERE POST_MONTH = :nd_proc_month
		  AND POST_YEAR  = :nd_proc_year
		  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND NVL(GL_INTERFACE_FLAG,'N') = 'N'		  
		  AND (
			   ((:nd_rep_only = 'Y' OR :nd_rep_only = 'N') AND :nd_trn_type = 'A' )
			   OR		  
			   (:nd_rep_only = 'Y' AND :nd_trn_type = 'O' AND 
			      (CASH_CTRL_DOC_TYPE IS NULL OR (CASH_CTRL_DOC_TYPE is not null
					and post_year||to_char(post_month,'FM00') < (SELECT acc_per_year||to_char(acc_per_month,'FM00') 
								FROM sy_acc_period_defn
								WHERE TRUNC(cash_ctrl_doc_date) 
								BETWEEN acc_per_start_date AND acc_per_end_date))			      
			      )
			      )
		       OR
		       (:nd_rep_only = 'Y' AND :nd_trn_type = 'C' AND CASH_CTRL_DOC_TYPE IS NOT	NULL )
		       OR
		       (:nd_rep_only = 'N' AND :nd_trn_type = 'O' AND 
		       (CASH_CTRL_DOC_TYPE IS NULL OR (CASH_CTRL_DOC_TYPE is not null
					and post_year||to_char(post_month,'FM00') < (SELECT acc_per_year||to_char(acc_per_month,'FM00') 
								FROM sy_acc_period_defn
								WHERE TRUNC(cash_ctrl_doc_date) 
								BETWEEN acc_per_start_date AND acc_per_end_date))			      
			      )
		       )
		       OR
		       (:nd_rep_only = 'N' AND :nd_trn_type = 'C' AND 
			(CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,TRUNC(CASH_CTRL_DOC_DATE))
			IN ( SELECT CASH_CTRL_DOC_TYPE_CODE,CASH_CTRL_DOC_NUMBER,           
							    TRUNC(CASH_CTRL_DOC_DATE)             
			     FROM  BL_GL_EXPORT_TEMP
			     WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id))	
			)			
			; */ 


     /* EXEC SQL DECLARE BL_GL_EXPORT_TEM_CUR CURSOR FOR
	          SELECT CASH_CTRL_DOC_TYPE_CODE,
			         CASH_CTRL_DOC_NUMBER,           
							    TRUNC(CASH_CTRL_DOC_DATE)             
			  FROM  BL_GL_EXPORT_TEMP
			  WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 



     /* EXEC SQL DECLARE GL_POSTING_ACC_CUR CURSOR FOR
	       SELECT CONCAT_POST_ACC_DESC
		 FROM GL_POSTING_ACC
		WHERE MAIN_ACC1_CODE       = :t_main_acc1_code
		  AND MAIN_ACC2_CODE       = :t_main_acc2_code
		  AND DEPT_CODE            = :t_dept_code
		  AND PRODUCT_GROUP_CODE   = :t_product_group_code
		  AND PRODUCT_LINE_CODE    = :t_product_line_code
		  AND SUBLEDGER_GROUP_CODE = :t_subledger_group_code
		  AND SUBLEDGER_LINE_CODE  = :t_subledger_line_code
	          AND ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
				          WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 

}

open_cur()
{
    /* EXEC SQL OPEN BL_GL_DISTRIBUTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select ROWID ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROU\
P_CODE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,NVL(DI\
STRIBUTION_AMT,0) ,CUST_CODE ,CASH_CTRL_DOC_TYPE ,CASH_CTRL_DOC_NUMBER ,trun\
c(CASH_CTRL_DOC_DATE)  from BL_GL_DISTRIBUTION where ((((POST_MONTH=:b0 and \
POST_YEAR=:b1) and OPERATING_FACILITY_ID=:b2) and NVL(GL_INTERFACE_FLAG,'N')\
='N') and ((((((:b3='Y' or :b3='N') and :b5='A') or ((:b3='Y' and :b5='O') a\
nd (CASH_CTRL_DOC_TYPE is null  or (CASH_CTRL_DOC_TYPE is  not null  and (po\
st_year||to_char(post_month,'FM00'))<(select (acc_per_year||to_char(acc_per_\
month,'FM00'))  from sy_acc_period_defn where TRUNC(cash_ctrl_doc_date) betw\
een acc_per_start_date and acc_per_end_date))))) or ((:b3='Y' and :b5='C') a\
nd CASH_CTRL_DOC_TYPE is  not null )) or ((:b3='N' and :b5='O') and (CASH_CT\
RL_DOC_TYPE is null  or (CASH_CTRL_DOC_TYPE is  not null  and (post_year||to\
_char(post_month,'FM00'))<(select (acc_per_year||to_char(acc_per_month,'FM00\
'))  from sy_acc_period_defn where TRUNC(ca");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )172;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_proc_month;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_proc_year;
    sqlstm.sqhstl[1] = (unsigned int  )7;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_rep_only;
    sqlstm.sqhstl[3] = (unsigned int  )1;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_rep_only;
    sqlstm.sqhstl[4] = (unsigned int  )1;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_trn_type;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_rep_only;
    sqlstm.sqhstl[6] = (unsigned int  )1;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_trn_type;
    sqlstm.sqhstl[7] = (unsigned int  )1;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_rep_only;
    sqlstm.sqhstl[8] = (unsigned int  )1;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_trn_type;
    sqlstm.sqhstl[9] = (unsigned int  )1;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_rep_only;
    sqlstm.sqhstl[10] = (unsigned int  )1;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_trn_type;
    sqlstm.sqhstl[11] = (unsigned int  )1;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_rep_only;
    sqlstm.sqhstl[12] = (unsigned int  )1;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_trn_type;
    sqlstm.sqhstl[13] = (unsigned int  )1;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[14] = (unsigned int  )5;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
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



    if (RESOURCE_BUSY)
	 err_mesg("BL_GL_DISTRIBUTION records can't be locked",0,"");
    else if (OERROR)
	 err_mesg("OPEN failed on cursor BL_GL_DISTRIBUTION_CUR",0,"");

   /* EXEC SQL OPEN BL_GL_EXPORT_TEM_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )247;
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



    if (RESOURCE_BUSY)
	 err_mesg("BL_GL_EXPORT_TEMP records can't be locked",0,"");
    else if (OERROR)
	 err_mesg("OPEN failed on cursor BL_GL_EXPORT_TEMP",0,"");

}

close_cur()
{
    /* EXEC SQL CLOSE BL_GL_DISTRIBUTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )266;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
	 err_mesg("CLOSE failed on cursor BL_GL_DISTRIBUTION_CUR",0,"");

    /* EXEC SQL CLOSE BL_GL_EXPORT_TEM_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )281;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
	 err_mesg("CLOSE failed on cursor BL_GL_EXPORT_TEM_CUR",0,"");


}

do_updt()
{
    long n_recs;

	for(;;) 
	{
	 n_recs = 0;

     /* EXEC SQL WHENEVER NOT FOUND GOTO err_exit; */ 


     /* EXEC SQL FETCH BL_GL_DISTRIBUTION_CUR
	       INTO :bl_gl_rowid,
		    :bl_gl_main_acc1_code,
		    :bl_gl_main_acc2_code,
		    :bl_gl_dept_code,
		    :bl_gl_product_group_code,
		    :bl_gl_product_line_code,
		    :bl_gl_subledger_group_code,
		    :bl_gl_subledger_line_code,
		    :bl_gl_distribution_amt,
		    :nd_cust_code,
		    :nd_cash_ctrl_doc_type,
		    :nd_cash_ctrl_doc_num,
		    :nd_cash_ctrl_doc_date; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )100;
     sqlstm.offset = (unsigned int  )296;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)bl_gl_rowid;
     sqlstm.sqhstl[0] = (unsigned int  )33;
     sqlstm.sqhsts[0] = (         int  )36;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)bl_gl_main_acc1_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )12;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqharc[1] = (unsigned int   *)0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)bl_gl_main_acc2_code;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )8;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqharc[2] = (unsigned int   *)0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)bl_gl_dept_code;
     sqlstm.sqhstl[3] = (unsigned int  )13;
     sqlstm.sqhsts[3] = (         int  )16;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqharc[3] = (unsigned int   *)0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)bl_gl_product_group_code;
     sqlstm.sqhstl[4] = (unsigned int  )6;
     sqlstm.sqhsts[4] = (         int  )8;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqharc[4] = (unsigned int   *)0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)bl_gl_product_line_code;
     sqlstm.sqhstl[5] = (unsigned int  )7;
     sqlstm.sqhsts[5] = (         int  )8;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqharc[5] = (unsigned int   *)0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)bl_gl_subledger_group_code;
     sqlstm.sqhstl[6] = (unsigned int  )6;
     sqlstm.sqhsts[6] = (         int  )8;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqharc[6] = (unsigned int   *)0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)bl_gl_subledger_line_code;
     sqlstm.sqhstl[7] = (unsigned int  )11;
     sqlstm.sqhsts[7] = (         int  )12;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqharc[7] = (unsigned int   *)0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)bl_gl_distribution_amt;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )sizeof(double);
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqharc[8] = (unsigned int   *)0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)nd_cust_code;
     sqlstm.sqhstl[9] = (unsigned int  )11;
     sqlstm.sqhsts[9] = (         int  )12;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqharc[9] = (unsigned int   *)0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)nd_cash_ctrl_doc_type;
     sqlstm.sqhstl[10] = (unsigned int  )9;
     sqlstm.sqhsts[10] = (         int  )12;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqharc[10] = (unsigned int   *)0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)nd_cash_ctrl_doc_num;
     sqlstm.sqhstl[11] = (unsigned int  )11;
     sqlstm.sqhsts[11] = (         int  )12;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqharc[11] = (unsigned int   *)0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)nd_cash_ctrl_doc_date;
     sqlstm.sqhstl[12] = (unsigned int  )33;
     sqlstm.sqhsts[12] = (         int  )36;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqharc[12] = (unsigned int   *)0;
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
     if (sqlca.sqlcode == 1403) goto err_exit;
}



    if (OERROR)
	 err_mesg("FETCH failed on cursor BL_GL_DISTRIBUTION_CUR",0,"");

        
    n_recs = sqlca.sqlerrd[2];
    process_recs(sqlca.sqlerrd[2] - num_ret);
    num_ret = n_recs;
}


err_exit:
    /* EXEC SQL WHENEVER NOT FOUND CONTINUE ; */ 

	
    if((sqlca.sqlerrd[2] - num_ret) > 0);
	process_recs(sqlca.sqlerrd[2] - num_ret);
 }
 
fetch_bl_gl_exp_temp()
{
    d_cash_ctrl_doc_type.arr[0]	      = '\0';
	d_cash_ctrl_doc_num.arr[0]        = '\0';
	d_cash_ctrl_doc_date.arr[0]       = '\0';

	d_cash_ctrl_doc_type.len	      = 0;
    d_cash_ctrl_doc_num.len           = 0;
	d_cash_ctrl_doc_date.len          = 0;


    /* EXEC SQL FETCH BL_GL_EXPORT_TEM_CUR
             INTO :d_cash_ctrl_doc_type,
		          :d_cash_ctrl_doc_num,
				  :d_cash_ctrl_doc_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )363;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cash_ctrl_doc_type;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cash_ctrl_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_cash_ctrl_doc_date;
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



    d_cash_ctrl_doc_type.arr[d_cash_ctrl_doc_type.len] = '\0';
    d_cash_ctrl_doc_num.arr[d_cash_ctrl_doc_num.len] = '\0';
	d_cash_ctrl_doc_date.arr[d_cash_ctrl_doc_date.len] = '\0';

    if (OERROR)
	 err_mesg("FETCH failed on cursor BL_GL_EXPORT_TEM_CUR",0,"");

	 if (LAST_ROW) 
		  return 0;
	 else
	      return 1;
}


process_recs(n)
long n;
{
    char aMesg[80];
    long i;
    char posting_acc[36];

    rec_cnt += n;



    for(i=0; i<n; i++) {

       strcpy(t_rowid.arr, bl_gl_rowid[i].arr);
       strcpy(t_main_acc1_code.arr, bl_gl_main_acc1_code[i].arr);
       strcpy(t_main_acc2_code.arr, bl_gl_main_acc2_code[i].arr);
       strcpy(t_dept_code.arr, bl_gl_dept_code[i].arr);
       strcpy(t_product_group_code.arr, bl_gl_product_group_code[i].arr);
       strcpy(t_product_line_code.arr, bl_gl_product_line_code[i].arr);
       strcpy(t_subledger_group_code.arr, bl_gl_subledger_group_code[i].arr);
       strcpy(t_subledger_line_code.arr, bl_gl_subledger_line_code[i].arr);
       strcpy(nd_cust_code1.arr,nd_cust_code[i].arr);
       strcpy(t_cash_ctrl_doc_type.arr,nd_cash_ctrl_doc_type[i].arr);
       strcpy(t_cash_ctrl_doc_num.arr,nd_cash_ctrl_doc_num[i].arr);
       strcpy(t_cash_ctrl_doc_date.arr,nd_cash_ctrl_doc_date[i].arr);
  
       t_rowid.len                  = strlen(t_rowid.arr);
       t_main_acc1_code.len         = strlen(t_main_acc1_code.arr);
       t_main_acc2_code.len         = strlen(t_main_acc2_code.arr);
       t_dept_code.len              = strlen(t_dept_code.arr);
       t_product_group_code.len     = strlen(t_product_group_code.arr);
       t_product_line_code.len      = strlen(t_product_line_code.arr);
       t_subledger_group_code.len   = strlen(t_subledger_group_code.arr);
       t_subledger_line_code.len    = strlen(t_subledger_line_code.arr);
       nd_cust_code1.len	    = strlen(nd_cust_code1.arr);
       t_cash_ctrl_doc_type.len	    = strlen(t_cash_ctrl_doc_type.arr);
       t_cash_ctrl_doc_num.len	    = strlen(t_cash_ctrl_doc_num.arr);
       t_cash_ctrl_doc_date.len	    = strlen(t_cash_ctrl_doc_date.arr);

       t_distribution_amt = bl_gl_distribution_amt[i];

       sprintf(posting_acc,"%s-%s %s %s-%s %s-%s %s %s %s",
	   t_main_acc1_code.arr,
	   t_main_acc2_code.arr,
	   t_dept_code.arr,
	   t_product_group_code.arr,
	   t_product_line_code.arr,
	   t_subledger_group_code.arr,
	   t_subledger_line_code.arr,
	   t_cash_ctrl_doc_type.arr,
	   t_cash_ctrl_doc_num.arr,
	   t_cash_ctrl_doc_date.arr);

	   root = addtree(root, posting_acc, t_distribution_amt,
			  t_main_acc1_code.arr,
			  t_main_acc2_code.arr,
			  t_dept_code.arr,
			  t_product_group_code.arr,
			  t_product_line_code.arr,
			  t_subledger_group_code.arr,
			  t_subledger_line_code.arr,
			  t_cash_ctrl_doc_type.arr,
			  t_cash_ctrl_doc_num.arr,
			  t_cash_ctrl_doc_date.arr);
		
    if(nd_rep_only != 'Y') 
	{
     

	/* EXEC SQL UPDATE BL_GL_DISTRIBUTION
		 SET    GL_INTERFACE_FLAG = 'Y',
			MODIFIED_BY_ID = USER ,
			MODIFIED_DATE  = SYSDATE,       
			MODIFIED_AT_WS_NO = :nd_ws_no,     
			MODIFIED_FACILITY_ID = :nd_operating_facility_id
		 WHERE  ROWID             = :t_rowid ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_GL_DISTRIBUTION  set GL_INTERFACE_FLAG='Y',MODIFIE\
D_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=\
:b1 where ROWID=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )390;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[0] = (unsigned int  )33;
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
 sqlstm.sqhstv[2] = (         void  *)&t_rowid;
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

    // :bl_gl_rowid;

//	 disp_message (ERR_MESG,t_rowid.arr);  

       
	if(OERROR)
	    err_mesg("UPDATE failed on table BL_GL_DISTRIBUTION",0,"");

       /* EXEC SQL UPDATE BL_CASH_CONTROL_RCPT
                   SET EXPORTED_TO_GL_YN = 'Y'
		 WHERE DOC_TYPE_CODE  = :t_cash_ctrl_doc_type 
           AND DOC_NUMBER     = :t_cash_ctrl_doc_num
		   AND TRUNC(DOC_DATE)= :t_cash_ctrl_doc_date
           AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 15;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "update BL_CASH_CONTROL_RCPT  set EXPORTED_TO_GL_YN='Y'\
 where (((DOC_TYPE_CODE=:b0 and DOC_NUMBER=:b1) and TRUNC(DOC_DATE)=:b2) and O\
PERATING_FACILITY_ID=:b3)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )417;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&t_cash_ctrl_doc_type;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&t_cash_ctrl_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )11;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&t_cash_ctrl_doc_date;
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



//	  disp_message(ERR_MESG, "OK");

	if(OERROR)
	    err_mesg("UPDATE failed on table BL_CASH_CONTROL_RCPT",0,"");    
    }
	}

    sprintf(aMesg,"Processed %ld Records.\n",rec_cnt);
    disp_message(INFO_MESG,aMesg);
}

struct tnode *addtree(p, w, n,main1,main2,dept,prod1,prod2,sleg1,sleg2,
						doctype,docnum,docdate)
struct tnode *p;
double n;
char *w,*main1,*main2,*dept,*prod1,*prod2,*sleg1,*sleg2,*doctype,*docnum,*docdate;
{
    int cond;

    if(p==NULL) {
	p=(struct tnode *) malloc(sizeof(struct tnode));
	if(p==NULL) {
	    disp_message(ERR_MESG,"Unable to allocate memory");
	    proc_exit();
	}
	p->acct_code = strdup(w);
	p->l_main_acc1_code        = strdup(main1);
	p->l_main_acc2_code        = strdup(main2);
	p->l_dept_code             = strdup(dept);
	p->l_product_group_code    = strdup(prod1);
	p->l_product_line_code     = strdup(prod2);
	p->l_subledger_group_code  = strdup(sleg1);
	p->l_subledger_line_code   = strdup(sleg2);
	
	p->l_cash_ctrl_doc_type    = strdup(doctype);
	p->l_cash_ctrl_doc_num     = strdup(docnum);
	p->l_cash_ctrl_doc_date    = strdup(docdate);

	if(n < (double)0) {
	    p->cr_amt = -n;
	    p->dr_amt = 0;
	}
	else {
	    p->dr_amt = n;
	    p->cr_amt = 0;
	}
	p->left = p->right = NULL;
    }
    else if ((cond = strcmp(w,p->acct_code)) == 0) {
	if(n < (double)0)
	    p->cr_amt += -n;
	else
	    p->dr_amt += n;
    }
    else if(cond < 0)
	p->left = addtree(p->left, w, n,
			  main1,main2,dept,prod1,prod2,sleg1,sleg2,doctype,docnum,docdate);
    else 
	p->right = addtree(p->right, w,n,
			   main1,main2,dept,prod1,prod2,sleg1,sleg2,doctype,docnum,docdate);

    return p;
}
      
char *strdup(s)
char *s;
{
    char * p;
    p = (char *) malloc(strlen(s)+1);
    if (p != NULL)
	strcpy(p,s);
    else {
	disp_message(ERR_MESG,"unable to allocate memory");
	proc_exit();
    }

    return p;
}

do_report(p)
struct tnode* p;
{


    strcpy(filename,WORKING_DIR);
	strcat(filename,"blrgldsu.lis");
	
	strcpy(OUTPUT_FILE_NAME,"blrgldsu.lis");
    
    if ((fp_sum = fopen(filename,"w")) == NULL)
    {
	disp_message(ERR_MESG,"Error in opening file blrgldsu.lis");
	proc_exit();
    }	


    fetch_hosp_name();

    print_title2();

    print_head2();

    treeprint(root);

    if (p) {
	print_total();
	fprintf(fp_sum,"\n\n                                                          %-15.15s\n",loc_legend[16]);
    fclose(fp_sum);
    }

}

treeprint(p)
struct tnode *p;
{
    int cnt = 0;

    if(p != NULL) {
	treeprint(p->left);
       g_invalid_acc = 0;

       
       get_post_desc(p);

       fprintf(fp_sum,"%-75s", p->acct_code);
       print_formated(p->dr_amt,fp_sum);fprintf(fp_sum," ");
       print_formated(p->cr_amt,fp_sum);fprintf(fp_sum," ");
       print_formated(p->dr_amt-p->cr_amt,fp_sum);
       g_tot_dr_amt += p->dr_amt;
       g_tot_cr_amt += p->cr_amt;
       fprintf(fp_sum,"\n");
       fprintf(fp_sum,"        %s\n",t_concat_post_acc_desc.arr);


/* Validate the posting account *****************************************/
       if(!g_invalid_acc) {
	 strcpy(t_main_acc1_code.arr,       p->l_main_acc1_code);
	 strcpy(t_main_acc2_code.arr,       p->l_main_acc2_code);
	 strcpy(t_dept_code.arr,            p->l_dept_code);
	 strcpy(t_product_group_code.arr,   p->l_product_group_code);
	 strcpy(t_product_line_code.arr,    p->l_product_line_code);
	 strcpy(t_subledger_group_code.arr, p->l_subledger_group_code);
	 strcpy(t_subledger_line_code.arr,  p->l_subledger_line_code);

	 strcpy(t_cash_ctrl_doc_type.arr,  p->l_cash_ctrl_doc_type);
	 strcpy(t_cash_ctrl_doc_num.arr,  p->l_cash_ctrl_doc_num);
     strcpy(t_cash_ctrl_doc_date.arr,  p->l_cash_ctrl_doc_date);	 
	 
  
	 t_main_acc1_code.len         = strlen(t_main_acc1_code.arr);
	 t_main_acc2_code.len         = strlen(t_main_acc2_code.arr);
	 t_dept_code.len              = strlen(t_dept_code.arr);
	 t_product_group_code.len     = strlen(t_product_group_code.arr);
	 t_product_line_code.len      = strlen(t_product_line_code.arr);
	 t_subledger_group_code.len   = strlen(t_subledger_group_code.arr);
	 t_subledger_line_code.len    = strlen(t_subledger_line_code.arr);

	 t_cash_ctrl_doc_type.len    = strlen(t_cash_ctrl_doc_type.arr);
	 t_cash_ctrl_doc_num.len    = strlen(t_cash_ctrl_doc_num.arr);
	 t_cash_ctrl_doc_date.len    = strlen(t_cash_ctrl_doc_date.arr);

    
	 if(validate_posting_acct( t_main_acc1_code.arr,
				   t_main_acc2_code.arr,
				   t_dept_code.arr,
				   t_product_group_code.arr,
				   t_product_line_code.arr,
				   t_subledger_group_code.arr,
				   t_subledger_line_code.arr,
				   'Y',   /* For chking Bank Reconcile */
			           d_module_valid_id.arr,
				   nd_proc_year.arr,
				   nd_proc_month.arr,				   
				   &g_err_typ,
				   g_err_id,
				   g_err_msg
				 ) ==  -1)
	  {
	      if(g_err_typ)
		  fetch_msg(g_err_id);
	      else
		  strcpy(d_message_text.arr,g_err_msg);
  
	      fprintf(fp_sum,"****ERROR: %s\n",d_message_text.arr);
	      lctr2++;
  
	  }


	}

/************************************************************************/

       lctr2+= 2;
       cnt ++;
       if (lctr2 > 52)
	    print_head2();
       treeprint(p->right);
    }

}

print_total()
{
    fprintf(fp_sum,"%75s--------------- --------------- ---------------\n"," ");
    fprintf(fp_sum,"%65s %-5.5s    "," ",loc_legend[15]);
    print_formated(g_tot_dr_amt,fp_sum);fprintf(fp_sum," ");
    print_formated(g_tot_cr_amt,fp_sum);fprintf(fp_sum," ");
    print_formated(g_tot_dr_amt-g_tot_cr_amt,fp_sum);
    fprintf(fp_sum,"\n");
    fprintf(fp_sum,"%75s--------------- --------------- ---------------\n"," ");
    lctr2+= 4;
}

print_title2()   /* Title for Summary */
{
#ifdef DEBUG
  printf("In print title2\n");
#endif
init_date_temp_var();
strcpy(date_convert.arr,date_time.arr);
fun_change_loc_date();
strcpy(date_time.arr,date_convert.arr);
fprintf(fp_sum,"\fMDL : BL                                             %-40.40s                             %-16.16s\n",hosp_name.arr,date_time.arr);
fprintf(fp_sum,"OPR : %-30.30s \n", user_id.arr);
fprintf(fp_sum,"REP : %-8s                            %-44.44s                                    %-4.4s : %4d\n","BLRGLDSU",loc_legend[1],loc_legend[2],++pctr2);

fprintf(fp_sum,"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp_sum,"VER : 4.1\n");
fflush(fp_sum);

if(nd_fm_trx_date.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_fm_trx_date.arr);
fun_change_loc_date1();
strcpy(nd_fm_trx_date1.arr,date_convert.arr);
}

if(nd_to_trx_date.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_to_trx_date.arr);
fun_change_loc_date1();
strcpy(nd_to_trx_date1.arr,date_convert.arr);
}

if(nd_proc_year.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_proc_year.arr);
fun_change_loc_date2();
strcpy(nd_proc_year1.arr,date_convert.arr);
}

fprintf(fp_sum,"\n\n\n\n        %-16.16s :\n        ----------------\n\n",loc_legend[3]);
fprintf(fp_sum,"                  %-16.16s  %-4.4s : %10s\n",loc_legend[4],loc_legend[6],nd_fm_trx_date1.arr);
fprintf(fp_sum,"                                    %-4.4s : %10s\n\n",loc_legend[7],nd_to_trx_date1.arr);
fprintf(fp_sum,"                       %-17.17s : %02d/%04d\n\n",loc_legend[5],atoi(nd_proc_month.arr),atoi(nd_proc_year1.arr));
}

print_head2()   /* Heading for Summary */
{

if(nd_proc_year.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_proc_year.arr);
fun_change_loc_date2();
strcpy(nd_proc_year1.arr,date_convert.arr);
}

fprintf(fp_sum,"\fMDL : BL                                             %-40.40s                             %-16.16s\n",hosp_name.arr,date_time.arr);
fprintf(fp_sum,"OPR : %-30.30s \n", user_id.arr);
fprintf(fp_sum,"REP : %-8s                            %-44.44s                                    %-4.4s : %4d\n","BLRGLDSU",loc_legend[1],loc_legend[2],++pctr2);
fprintf(fp_sum,"                                                 (%-14.14s %02d/%04d to %02d/%04d)\n",loc_legend[8],atoi(nd_proc_month.arr),atoi(nd_proc_year1.arr),
atoi(nd_proc_month.arr),atoi(nd_proc_year1.arr));
fprintf(fp_sum,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp_sum,"%-11.11s & %-11.11s                                                           %5.5s          %6.6s         %7.7s\n",
		loc_legend[9],loc_legend[10],loc_legend[11],loc_legend[12],loc_legend[13]);
fprintf(fp_sum,"-------------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp_sum);
lctr2 = 11;
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		    USER
	     INTO :hosp_name, :date_time, :user_id
	     FROM  SY_ACC_ENTITY_LANG_VW
	     WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		 AND   LANGUAGE_ID   = :nd_lang_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:\
b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )448;
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
    sqlstm.sqhstl[2] = (unsigned int  )42;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	user_id.arr[user_id.len]               = '\0';


}

get_post_desc(p)
struct tnode *p;
{
      t_concat_post_acc_desc.arr[0]  = '\0';
      t_concat_post_acc_desc.len     = 0;

       strcpy(t_main_acc1_code.arr, p->l_main_acc1_code);
       strcpy(t_main_acc2_code.arr, p->l_main_acc2_code);
       strcpy(t_dept_code.arr, p->l_dept_code);
       strcpy(t_product_group_code.arr, p->l_product_group_code);
       strcpy(t_product_line_code.arr, p->l_product_line_code);
       strcpy(t_subledger_group_code.arr, p->l_subledger_group_code);
       strcpy(t_subledger_line_code.arr, p->l_subledger_line_code);

	   strcpy(t_cash_ctrl_doc_type.arr, p->l_cash_ctrl_doc_type);
	   strcpy(t_cash_ctrl_doc_num.arr, p->l_cash_ctrl_doc_num);
	   strcpy(t_cash_ctrl_doc_date.arr, p->l_cash_ctrl_doc_date);

       t_main_acc1_code.len         = strlen(t_main_acc1_code.arr);
       t_main_acc2_code.len         = strlen(t_main_acc2_code.arr);
       t_dept_code.len              = strlen(t_dept_code.arr);
       t_product_group_code.len     = strlen(t_product_group_code.arr);
       t_product_line_code.len      = strlen(t_product_line_code.arr);
       t_subledger_group_code.len   = strlen(t_subledger_group_code.arr);
       t_subledger_line_code.len    = strlen(t_subledger_line_code.arr);

	   t_cash_ctrl_doc_type.len    = strlen(t_cash_ctrl_doc_type.arr);
	   t_cash_ctrl_doc_num.len     = strlen(t_cash_ctrl_doc_num.arr);
	   t_cash_ctrl_doc_date.len    = strlen(t_cash_ctrl_doc_date.arr);	   


      /* EXEC SQL OPEN GL_POSTING_ACC_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 15;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0008;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )483;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&t_main_acc1_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&t_main_acc2_code;
      sqlstm.sqhstl[1] = (unsigned int  )7;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&t_dept_code;
      sqlstm.sqhstl[2] = (unsigned int  )13;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&t_product_group_code;
      sqlstm.sqhstl[3] = (unsigned int  )6;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&t_product_line_code;
      sqlstm.sqhstl[4] = (unsigned int  )7;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&t_subledger_group_code;
      sqlstm.sqhstl[5] = (unsigned int  )6;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&t_subledger_line_code;
      sqlstm.sqhstl[6] = (unsigned int  )11;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[7] = (unsigned int  )5;
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
	   err_mesg("OPEN failed on cursor GL_POSTING_ACC_CUR",0,"");

      /* EXEC SQL FETCH GL_POSTING_ACC_CUR
		INTO :t_concat_post_acc_desc; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 15;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )530;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&t_concat_post_acc_desc;
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

      t_concat_post_acc_desc.arr[t_concat_post_acc_desc.len]  = '\0';

      if(NO_DATA_FOUND) {
	 strcpy(t_concat_post_acc_desc.arr,loc_legend[14]);
	 g_invalid_acc = 1;
      }
}

/*
print_formated(loc_amount,fp)
double loc_amount;
FILE *fp;
{

   char out_str[30],out_str1[30];



   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15.2f",loc_amount);
      //ltrim(out_str);
	  str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
      //ltrim(out_str);
	  str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14sCR",out_str1);
   }

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
          //      ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s ",str_amt);
        }

}


export_gl(p)
struct tnode *p;
{

    if(p != NULL) {

	export_gl(p->left);

	strcpy(t_main_acc1_code.arr,       p->l_main_acc1_code);
	strcpy(t_main_acc2_code.arr,       p->l_main_acc2_code);
	strcpy(t_dept_code.arr,            p->l_dept_code);
	strcpy(t_product_group_code.arr,   p->l_product_group_code);
	strcpy(t_product_line_code.arr,    p->l_product_line_code);
	strcpy(t_subledger_group_code.arr, p->l_subledger_group_code);
	strcpy(t_subledger_line_code.arr,  p->l_subledger_line_code);

    strcpy(t_cash_ctrl_doc_type.arr, p->l_cash_ctrl_doc_type);
    strcpy(t_cash_ctrl_doc_num.arr, p->l_cash_ctrl_doc_num);
    strcpy(t_cash_ctrl_doc_date.arr, p->l_cash_ctrl_doc_date);

	t_main_acc1_code.len         = strlen(t_main_acc1_code.arr);
	t_main_acc2_code.len         = strlen(t_main_acc2_code.arr);
	t_dept_code.len              = strlen(t_dept_code.arr);
	t_product_group_code.len     = strlen(t_product_group_code.arr);
	t_product_line_code.len      = strlen(t_product_line_code.arr);
	t_subledger_group_code.len   = strlen(t_subledger_group_code.arr);
	t_subledger_line_code.len    = strlen(t_subledger_line_code.arr);

	t_cash_ctrl_doc_type.len    = strlen(t_cash_ctrl_doc_type.arr);
    t_cash_ctrl_doc_num.len    = strlen(t_cash_ctrl_doc_num.arr);
    t_cash_ctrl_doc_date.len    = strlen(t_cash_ctrl_doc_date.arr);	   


	t_distribution_amt           = p->dr_amt - p->cr_amt;

	val_post_acc();
	
	ins_line_rec_summary();   

	export_gl(p->right);
    }

}

ins_line_rec_summary()
{
	d_gl_run_line_num_sum++;

	/* EXEC SQL INSERT INTO GL_TXN_DOC_LINE
	       (
		 ACC_ENTITY_CODE,
		 BATCH_NUM,
		 DOC_TYPE_CODE,
		 DOC_NUM,
		 MAIN_ACC1_CODE,
		 MAIN_ACC2_CODE,
		 DEPT_CODE,
		 PRODUCT_GROUP_CODE,
		 PRODUCT_LINE_CODE,
		 SUBLEDGER_GROUP_CODE,
		 SUBLEDGER_LINE_CODE,
		 LOCAL_AMT,
		 NARRATION,
		 LINE_NUM,
		 CUST_SUPP_CODE
	       )
	     VALUES
	       (
		 :nd_acc_entity_code,
		 0,
		 DECODE(:nd_trn_type,'O',:nd_doc_type_code,'A',:nd_doc_type_code,:t_cash_ctrl_doc_type),
		 DECODE(:nd_trn_type,'O',:nd_doc_num,'A',:nd_doc_num,:t_cash_ctrl_doc_num),
		 :t_main_acc1_code,
		 :t_main_acc2_code,
		 :t_dept_code,
		 :t_product_group_code,
		 :t_product_line_code,
		 :t_subledger_group_code,
		 :t_subledger_line_code,
		 :t_distribution_amt,
		 NULL,
		 :d_gl_run_line_num_sum,
		 :nd_cust_code1
	       ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into GL_TXN_DOC_LINE (ACC_ENTITY_CODE,BATCH_NUM,DOC_T\
YPE_CODE,DOC_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PR\
ODUCT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,LOCAL_AMT,NARRATION,L\
INE_NUM,CUST_SUPP_CODE) values (:b0,0,DECODE(:b1,'O',:b2,'A',:b2,:b4),DECODE(:\
b1,'O',:b6,'A',:b6,:b8),:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,null ,:b17,:b18\
)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )549;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_trn_type;
 sqlstm.sqhstl[1] = (unsigned int  )1;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_doc_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&t_cash_ctrl_doc_type;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_trn_type;
 sqlstm.sqhstl[5] = (unsigned int  )1;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_doc_num;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_doc_num;
 sqlstm.sqhstl[7] = (unsigned int  )11;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&t_cash_ctrl_doc_num;
 sqlstm.sqhstl[8] = (unsigned int  )11;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&t_main_acc1_code;
 sqlstm.sqhstl[9] = (unsigned int  )9;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&t_main_acc2_code;
 sqlstm.sqhstl[10] = (unsigned int  )7;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&t_dept_code;
 sqlstm.sqhstl[11] = (unsigned int  )13;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&t_product_group_code;
 sqlstm.sqhstl[12] = (unsigned int  )6;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&t_product_line_code;
 sqlstm.sqhstl[13] = (unsigned int  )7;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&t_subledger_group_code;
 sqlstm.sqhstl[14] = (unsigned int  )6;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&t_subledger_line_code;
 sqlstm.sqhstl[15] = (unsigned int  )11;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&t_distribution_amt;
 sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&d_gl_run_line_num_sum;
 sqlstm.sqhstl[17] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_cust_code1;
 sqlstm.sqhstl[18] = (unsigned int  )11;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
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
	   err_mesg("INSERT failed on table GL_TXN_DOC_LINE - SUMMARY",0,"");

}

ins_hdr_rec_summary()
{

       /* EXEC SQL INSERT INTO GL_TXN_DOC_HDR
	      (
		BATCH_NUM,
		DOC_TYPE_CODE,
		DOC_NUM,
		DOC_DATE,
		DOC_REF,
		NARRATION,
		POST_MONTH,
		POST_YEAR,
		CTRL_AMT,   
		ADDED_BY_ID,
		MODIFIED_BY_ID,
		ADDED_DATE,          
		MODIFIED_DATE,
		MAX_LINE_NUM,
		MODULE_ID,
		ADDED_FACILITY_ID   ,
		MODIFIED_FACILITY_ID,   
		ADDED_AT_WS_NO      ,   
		MODIFIED_AT_WS_NO,
		ACC_ENTITY_CODE 
	//	POSTED_FLAG
	      )
	    VALUES
	      (
		0,
				 						                
		DECODE(:nd_trn_type,'O',:nd_doc_type_code,'A',:nd_doc_type_code,:d_cash_ctrl_doc_type),
		DECODE(:nd_trn_type,'O',:nd_doc_num,'A',:nd_doc_num,:d_cash_ctrl_doc_num),
		DECODE(:nd_trn_type,'O',to_date(:nd_doc_date,'DD/MM/YYYY'),
							'A',to_date(:nd_doc_date,'DD/MM/YYYY'),
					to_date(:d_cash_ctrl_doc_date,'DD/MM/YYYY')),
		NULL,
		NULL,
		:nd_proc_month,
		:nd_proc_year,
		0,
		USER,
		USER,
		SYSDATE,
		SYSDATE,
		:d_gl_run_line_num_sum,
		'BL',
		:nd_operating_facility_id   ,
		:nd_operating_facility_id,   
		:nd_ws_no      ,   
		:nd_ws_no,
		 :nd_acc_entity_code      
		// 'Y'
	     ); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "insert into GL_TXN_DOC_HDR (BATCH_NUM,DOC_TYPE_CODE,DO\
C_NUM,DOC_DATE,DOC_REF,NARRATION,POST_MONTH,POST_YEAR,CTRL_AMT,ADDED_BY_ID,MOD\
IFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,MAX_LINE_NUM,MODULE_ID,ADDED_FACILITY_ID,\
MODIFIED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_AT_WS_NO,ACC_ENTITY_CODE) values \
(0,DECODE(:b0,'O',:b1,'A',:b1,:b3),DECODE(:b0,'O',:b5,'A',:b5,:b7),DECODE(:b0,\
'O',to_date(:b9,'DD/MM/YYYY'),'A',to_date(:b9,'DD/MM/YYYY'),to_date(:b11,'DD/M\
M/YYYY')),null ,null ,:b12,:b13,0,USER,USER,SYSDATE,SYSDATE,:b14,'BL',:b15,:b1\
5,:b17,:b17,:b19)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )640;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_trn_type;
       sqlstm.sqhstl[0] = (unsigned int  )1;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_cash_ctrl_doc_type;
       sqlstm.sqhstl[3] = (unsigned int  )9;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_trn_type;
       sqlstm.sqhstl[4] = (unsigned int  )1;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_doc_num;
       sqlstm.sqhstl[5] = (unsigned int  )11;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&nd_doc_num;
       sqlstm.sqhstl[6] = (unsigned int  )11;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&d_cash_ctrl_doc_num;
       sqlstm.sqhstl[7] = (unsigned int  )11;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&nd_trn_type;
       sqlstm.sqhstl[8] = (unsigned int  )1;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&nd_doc_date;
       sqlstm.sqhstl[9] = (unsigned int  )14;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&nd_doc_date;
       sqlstm.sqhstl[10] = (unsigned int  )14;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&d_cash_ctrl_doc_date;
       sqlstm.sqhstl[11] = (unsigned int  )33;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&nd_proc_month;
       sqlstm.sqhstl[12] = (unsigned int  )5;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&nd_proc_year;
       sqlstm.sqhstl[13] = (unsigned int  )7;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&d_gl_run_line_num_sum;
       sqlstm.sqhstl[14] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[15] = (unsigned int  )5;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[16] = (unsigned int  )5;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&nd_ws_no;
       sqlstm.sqhstl[17] = (unsigned int  )33;
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
       sqlstm.sqhstv[19] = (         void  *)&nd_acc_entity_code;
       sqlstm.sqhstl[19] = (unsigned int  )7;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
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
	 err_mesg("INSERT failed on table GL_TXN_DOC_HDR - 2",0,"");
}

fetch_doc_no()
{

    d_num_of_acc_periods = 0;

    /* EXEC SQL SELECT NUM_OF_ACC_PERIODS
	       INTO :d_num_of_acc_periods
	       FROM SY_ACC_ENTITY
	       WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NUM_OF_ACC_PERIODS into :b0  from SY_ACC_ENTITY wh\
ere ACC_ENTITY_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )735;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_num_of_acc_periods;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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

     nd_doc_num.arr[0] = '\0';
     nd_doc_num.len    = 0;
	 
	 

     /* EXEC SQL SELECT NVL(NEXT_DOC_NO,1)
		INTO :nd_doc_num
		FROM SY_ACC_ENTITY_DOC_TYPE
	       WHERE DOC_TYPE_CODE = :nd_doc_type_code
	       AND ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
				          WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
 	       FOR UPDATE OF NEXT_DOC_NO NOWAIT; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 20;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(NEXT_DOC_NO,1) into :b0  from SY_ACC_ENTITY_D\
OC_TYPE where (DOC_TYPE_CODE=:b1 and ACC_ENTITY_CODE in (select ACC_ENTITY_COD\
E  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2)) for update of NEXT_DOC_NO nowa\
it ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )758;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_doc_num;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_doc_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
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



     if (RESOURCE_BUSY)
	 err_mesg("SY_ACC_ENTITY_DOC_TYPE record can't be locked",0,"");

     if (OERROR)
	 err_mesg("SELECT failed on table SY_ACC_ENTITY_DOC_TYPE",0,"");

     if (NOT_FOUND)
	 err_mesg("RECORD not found in SY_ACC_ENTITY_DOC_TYPE",0,"");

     nd_doc_num.arr[nd_doc_num.len]           = '\0';
}

upd_doc_num()
{
     /* EXEC SQL UPDATE SY_ACC_ENTITY_DOC_TYPE 
		 SET NEXT_DOC_NO = :nd_doc_num + 1,
			MODIFIED_BY_ID = USER ,
			MODIFIED_DATE  = SYSDATE   
	       WHERE DOC_TYPE_CODE = :nd_doc_type_code
	       AND ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
				          WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 20;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update SY_ACC_ENTITY_DOC_TYPE  set NEXT_DOC_NO=(:b0+1),M\
ODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE where (DOC_TYPE_CODE=:b1 and ACC_ENTI\
TY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2\
))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )785;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_doc_num;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_doc_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
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
	 err_mesg("UPDATE failed on table SY_ACC_ENTITY_DOC_TYPE",0,"");
}

val_post_acc()
{
    char aMesg[80];
      if(validate_posting_acct( t_main_acc1_code.arr,
				t_main_acc2_code.arr,
				t_dept_code.arr,
				t_product_group_code.arr,
				t_product_line_code.arr,
				t_subledger_group_code.arr,
				t_subledger_line_code.arr,
				'Y',   /* For chking Bank Reconcile */
				d_module_valid_id.arr,
				nd_proc_year.arr,
				nd_proc_month.arr,
				&g_err_typ,
				g_err_id,
				g_err_msg
			     ) ==  -1)
      {
	     sprintf(aMesg,"Error in posting account %s-%s %s %s-%s %s-%s\n",
		      t_main_acc1_code.arr,
		      t_main_acc2_code.arr,
		      t_dept_code.arr,
		      t_product_group_code.arr,
		      t_product_line_code.arr,
		      t_subledger_group_code.arr,
		      t_subledger_line_code.arr);
	 disp_message(ERR_MESG,aMesg);
	     if(g_err_typ == 0)
		   err_mesg(g_err_msg,0,"");
	     else 
		err_mesg("",1,g_err_id);
       }
}

fetch_msg(l_message_id)
char *l_message_id;
{
    strcpy(d_message_id.arr, l_message_id);
    d_message_id.len = strlen(d_message_id.arr);

    d_message_text.arr[0] = '\0';
    d_message_text.len    = 0; 

    /* EXEC SQL SELECT SUBSTR(MESSAGE_TEXT,1,80)    
	     INTO   :d_message_text
	     FROM   MESSAGE
	     WHERE  MESSAGE_ID = :d_message_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SUBSTR(MESSAGE_TEXT,1,80) into :b0  from MESSAGE w\
here MESSAGE_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )812;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_message_text;
    sqlstm.sqhstl[0] = (unsigned int  )83;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_message_id;
    sqlstm.sqhstl[1] = (unsigned int  )9;
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
	err_mesg("SELECT failed on table MESSAGE",0,"");

    if(NO_DATA_FOUND)
	strcpy(d_message_text.arr,"ERROR in posting Account");
    else
	d_message_text.arr[d_message_text.len]  = '\0';
}
fetch_legend_value()
{

	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLBSUMRY.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLBSUMRY.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )835;
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



		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_translated_value.arr[0]		= '\0';

		/* EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:nd_operating_facility_id,
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facili\
ty_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_trans\
lated_value , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )858;
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

get_local_date()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:nd_lang_id,t_date);

		:nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :nd_lang_id , t_\
date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )889;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
get_local_date1()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:nd_lang_id,t_date);

		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :nd_lang_id , t_date ) ;\
 :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )916;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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


    nd_loc_date .arr[nd_loc_date .len]='\0';
		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

}
get_local_date2()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'YYYY'),:nd_lang_id,t_date);

		:nd_loc_date := to_char(t_date,'YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'YYYY' ) , :nd_lang_id , t_date ) ; :nd_l\
oc_date := to_char ( t_date , 'YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )943;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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


    nd_loc_date .arr[nd_loc_date .len]='\0';
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

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 
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
strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date2();

strcpy(date_convert.arr,nd_loc_date.arr); 
}