
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
    "T:\\BL\\Facility Change Modifications\\BL\\Blrgldis.pc"
};


static unsigned long sqlctx = 464689603;


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

 static const char *sq0004 = 
"_LINE_CODE,8,'0')) between (RPAD(NVL(:b16,' '),3,'0')||RPAD(NVL(:b17,' '),8,\
'0')) and (RPAD(NVL(:b18,'~~~'),3,'0')||RPAD(NVL(:b19,'~~~~~~~~'),8,'0'))) and\
 operating_facility_id=:b20) order by ((((((((((((MAIN_ACC1_CODE||'-')||MAIN_A\
CC2_CODE)||' ')||DEPT_CODE)||' ')||PRODUCT_GROUP_CODE)||'-')||PRODUCT_LINE_COD\
E)||' ')||SUBLEDGER_GROUP_CODE)||'-')||SUBLEDGER_LINE_CODE),DECODE(:b21,1,TO_C\
HAR(TRX_DATE,'YYYYMMDD'),TRX_DOC_REF)            ";

 static const char *sq0005 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,short_name  from MP_PATIENT_MAST wh\
ere PATIENT_ID=:b0           ";

 static const char *sq0006 = 
"select CONCAT_POST_ACC_DESC  from GL_POSTING_ACC where (((((((MAIN_ACC1_CODE\
=:b0 and MAIN_ACC2_CODE=:b1) and DEPT_CODE=:b2) and PRODUCT_GROUP_CODE=:b3) an\
d PRODUCT_LINE_CODE=:b4) and SUBLEDGER_GROUP_CODE=:b5) and SUBLEDGER_LINE_CODE\
=:b6) and ACC_ENTITY_CODE in (select acc_entity_code  from sy_acc_entity where\
 acc_entity_id=:b7))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,242,0,0,0,0,0,1,0,
20,0,0,2,431,0,4,297,0,0,29,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,3,0,
0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
151,0,0,3,84,0,2,372,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
178,0,0,4,2485,0,9,506,0,0,22,22,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
281,0,0,4,0,0,13,579,0,0,32,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
424,0,0,5,105,0,9,654,0,0,1,1,0,1,0,1,9,0,0,
443,0,0,5,0,0,13,666,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
466,0,0,7,515,0,6,680,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
493,0,0,6,341,0,9,800,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
540,0,0,6,0,0,13,805,0,0,1,0,0,1,0,2,9,0,0,
559,0,0,8,158,0,4,1169,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
594,0,0,9,96,0,4,1252,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
617,0,0,10,172,0,6,1259,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
648,0,0,11,212,0,6,1278,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
675,0,0,12,196,0,6,1300,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
702,0,0,13,184,0,6,1322,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRGLDIS.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 16-AUG-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                               */
/*                                                                      */
/*  FUNCTION              :                                              */
/*                                                                      */
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
                                               
#include <stdio.h>
#include <string.h>   
#include "gl.h"       
#include "bl.h"

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define INIT_MESG "Report Generation In Progress"
/*
#define DEBUG 0
*/

#define DETAIL   (nd_rep_type.arr[0] == 'D' || nd_rep_type.arr[0] == 'B')
#define SUMMARY  (nd_rep_type.arr[0] == 'S' || nd_rep_type.arr[0] == 'B')


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                   [120],
            date_time                                   [20],
            user_id                                     [40],
            nd_session_id                               [16],
            nd_pgm_date                                 [25],
            d_curr_pgm_name                             [15],
			nd_operating_facility_id					[3],
			nd_cash_ctrl_doc_type						[7],
			nd_cash_ctrl_doc_num						[9],
			nd_cash_ctrl_doc_date						[12],
            nd_fm_date                                  [11],
            nd_to_date                                  [11],
			nd_fm_date1                                 [11],
            nd_to_date1                                 [11],
            nd_fm_month                                 [3],
            nd_fm_year                                  [5],
			nd_fm_year1                                 [5],
            nd_to_month                                 [3],
			fmthyr  									[7],
			tmthyr										[7],
            nd_to_year                                  [5],
            nd_to_year1                                 [5],
            nd_rep_type                                [2],
            nd_fm_main1                                [7],
            nd_fm_main2                                [5],
            nd_to_main1                                [7],
            nd_to_main2                                [5],
            nd_fm_dept                                 [11],
            nd_to_dept                                 [11],
            nd_fm_prd_gr                               [4],
            nd_fm_prd_ln                               [5],
            nd_to_prd_gr                               [4],
            nd_to_prd_ln                               [5],
            nd_fm_sub_gr                               [4],
            nd_fm_sub_ln                               [9],
            nd_to_sub_gr                               [4],
            nd_to_sub_ln                               [9]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_cash_ctrl_doc_type;

struct { unsigned short len; unsigned char arr[9]; } nd_cash_ctrl_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_cash_ctrl_doc_date;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date1;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date1;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_month;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_year;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_year1;

struct { unsigned short len; unsigned char arr[3]; } nd_to_month;

struct { unsigned short len; unsigned char arr[7]; } fmthyr;

struct { unsigned short len; unsigned char arr[7]; } tmthyr;

struct { unsigned short len; unsigned char arr[5]; } nd_to_year;

struct { unsigned short len; unsigned char arr[5]; } nd_to_year1;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_type;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_main1;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_main2;

struct { unsigned short len; unsigned char arr[7]; } nd_to_main1;

struct { unsigned short len; unsigned char arr[5]; } nd_to_main2;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_dept;

struct { unsigned short len; unsigned char arr[11]; } nd_to_dept;

struct { unsigned short len; unsigned char arr[4]; } nd_fm_prd_gr;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_prd_ln;

struct { unsigned short len; unsigned char arr[4]; } nd_to_prd_gr;

struct { unsigned short len; unsigned char arr[5]; } nd_to_prd_ln;

struct { unsigned short len; unsigned char arr[4]; } nd_fm_sub_gr;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_sub_ln;

struct { unsigned short len; unsigned char arr[4]; } nd_to_sub_gr;

struct { unsigned short len; unsigned char arr[9]; } nd_to_sub_ln;


    int     nd_rep_order;
    int     ndfmth,ndfyr,ndtmth,ndtyr;

   /* VARCHAR bl_dis_main_acc1_code                       [7],
           bl_dis_main_acc2_code                       [5],
           bl_dis_dept_code                            [11],
           bl_dis_product_group_code                   [4],
           bl_dis_product_line_code                    [5],
           bl_dis_subledger_group_code                 [4],
           bl_dis_subledger_line_code                  [9],
           bl_dis_post_year                            [5],
           bl_dis_post_year1                           [5],
           bl_dis_post_month                           [3],
           bl_dis_trx_date                             [13],
           bl_dis_trx_date1                            [13],
           bl_dis_trx_doc_ref                          [21],
           bl_dis_trx_doc_ref_line_num                 [5],
           bl_dis_trx_doc_ref_seq_num                  [5],
           bl_dis_episode_type                         [2],
           bl_dis_patient_id                           [21],
           bl_dis_episode_id                           [9],
           bl_dis_visit_id                             [5],
           bl_dis_source_doc_ref                       [21],
           bl_dis_source_doc_date                      [13],
           bl_dis_narration                            [51],
           bl_dis_trx_type_code                        [2],
           bl_dis_debit_amt_prn                        [23],
           bl_dis_credit_amt_prn                       [23],
           bl_dis_gl_interface_by_id                   [21],
           bl_dis_gl_interface_date                    [13],
           bl_dis_gl_interface_flag                    [2],
           bl_dis_concat_post_acc                      [50],
           bl_patient_name_loc_lang                    [61],
           bl_patient_name                             [61],
		   bl_patient_name1                            [31],
           d_short_name_full                           [61],
           posting_acc_desc                            [64]; */ 
struct { unsigned short len; unsigned char arr[7]; } bl_dis_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bl_dis_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } bl_dis_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bl_dis_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bl_dis_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } bl_dis_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bl_dis_subledger_line_code;

struct { unsigned short len; unsigned char arr[5]; } bl_dis_post_year;

struct { unsigned short len; unsigned char arr[5]; } bl_dis_post_year1;

struct { unsigned short len; unsigned char arr[3]; } bl_dis_post_month;

struct { unsigned short len; unsigned char arr[13]; } bl_dis_trx_date;

struct { unsigned short len; unsigned char arr[13]; } bl_dis_trx_date1;

struct { unsigned short len; unsigned char arr[21]; } bl_dis_trx_doc_ref;

struct { unsigned short len; unsigned char arr[5]; } bl_dis_trx_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[5]; } bl_dis_trx_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[2]; } bl_dis_episode_type;

struct { unsigned short len; unsigned char arr[21]; } bl_dis_patient_id;

struct { unsigned short len; unsigned char arr[9]; } bl_dis_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_dis_visit_id;

struct { unsigned short len; unsigned char arr[21]; } bl_dis_source_doc_ref;

struct { unsigned short len; unsigned char arr[13]; } bl_dis_source_doc_date;

struct { unsigned short len; unsigned char arr[51]; } bl_dis_narration;

struct { unsigned short len; unsigned char arr[2]; } bl_dis_trx_type_code;

struct { unsigned short len; unsigned char arr[23]; } bl_dis_debit_amt_prn;

struct { unsigned short len; unsigned char arr[23]; } bl_dis_credit_amt_prn;

struct { unsigned short len; unsigned char arr[21]; } bl_dis_gl_interface_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_dis_gl_interface_date;

struct { unsigned short len; unsigned char arr[2]; } bl_dis_gl_interface_flag;

struct { unsigned short len; unsigned char arr[50]; } bl_dis_concat_post_acc;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[31]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[64]; } posting_acc_desc;


	/* VARCHAR nd_lang_id			[4],
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

		

   double  bl_dis_debit_amt,
           bl_dis_credit_amt;

   double acc_debit_amt_tot,
          acc_credit_amt_tot,
          grand_debit_amt_tot,
          grand_credit_amt_tot;

	char loc_legend[999][201];

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

char concat_post_acc_st                   [50];
char  filename [150];
char  string_var [100];

  int    tot_admissions = 0;

  int    lctr1 = 0,pctr1 = 0;
  int    lctr2 = 0,pctr2 = 0;

FILE *fp_det;
FILE *fp_sum;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;

    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRGLDIS");

    if (sql_connect(argv[1]) == -1)
    {
        disp_message(ORA_MESG,"Error in connecting to Oracle");
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

    strcpy(nd_operating_facility_id.arr,argv[4]);
    nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);
    strcpy(g_facility_id,nd_operating_facility_id.arr);

    start_prog_msg();

    fetch_prog_param();
	fetch_legend_value();
    declare_cur();
    fetch_hosp_name();
    open_file();
     
    open_bl_gl_dis();

    acc_debit_amt_tot  = 0;
    acc_credit_amt_tot = 0;

    while(fetch_bl_gl_dis())
    {
        if (concat_post_acc_st[0] == '\0')
        {
          strcpy(concat_post_acc_st,bl_dis_concat_post_acc.arr);
          get_post_desc();
          print_posting_acc();
        }

        if (strcmp(concat_post_acc_st,bl_dis_concat_post_acc.arr))
        {
           print_acc_total();
           strcpy(concat_post_acc_st,bl_dis_concat_post_acc.arr);
           get_post_desc();
           print_posting_acc();
        }

        print_rec();
        rec_ctr++;
    }

    if (rec_ctr)
       print_grand_total();

    end_of_rep();
    end_prog_msg();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 0;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
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
    nd_fm_date.arr[0]          = '\0';
    nd_to_date.arr[0]          = '\0';
    nd_fm_month.arr[0]         = '\0';
    nd_fm_year.arr[0]          = '\0';
    nd_to_month.arr[0]         = '\0';
    nd_to_year.arr[0]          = '\0';
    nd_rep_type.arr[0]         = '\0';
    nd_fm_main1.arr[0]         = '\0';
    nd_fm_main2.arr[0]         = '\0';
    nd_to_main1.arr[0]         = '\0';
    nd_to_main2.arr[0]         = '\0';
    nd_fm_dept.arr[0]          = '\0';
    nd_to_dept.arr[0]          = '\0';
    nd_fm_prd_gr.arr[0]        = '\0';
    nd_fm_prd_ln.arr[0]        = '\0';
    nd_to_prd_gr.arr[0]        = '\0';
    nd_to_prd_ln.arr[0]        = '\0';
    nd_fm_sub_gr.arr[0]        = '\0';
    nd_fm_sub_ln.arr[0]        = '\0';
    nd_to_sub_gr.arr[0]        = '\0';
    nd_to_sub_ln.arr[0]        = '\0';

    nd_fm_date.len             = 0;
    nd_to_date.len             = 0;
    nd_fm_month.len            = 0;
    nd_fm_year.len             = 0;
    nd_to_month.len            = 0;
    nd_to_year.len             = 0;
    nd_rep_type.len            = 0;
    nd_fm_main1.len            = 0;
    nd_fm_main2.len            = 0;
    nd_to_main1.len            = 0;
    nd_to_main2.len            = 0;
    nd_fm_dept.len             = 0;
    nd_to_dept.len             = 0;
    nd_fm_prd_gr.len           = 0;
    nd_fm_prd_ln.len           = 0;
    nd_to_prd_gr.len           = 0;
    nd_to_prd_ln.len           = 0;
    nd_fm_sub_gr.len           = 0;
    nd_fm_sub_ln.len           = 0;
    nd_to_sub_gr.len           = 0;
    nd_to_sub_ln.len           = 0;

    nd_rep_order               = 0;

   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,
                   PARAM5,PARAM6,
				   PARAM7,PARAM8,PARAM9,PARAM10,
                   PARAM11,PARAM12,
                   PARAM13,PARAM14,PARAM15,PARAM16,
                   PARAM17,PARAM18,PARAM19,PARAM20,
                   PARAM21,PARAM22,
				   PARAM3,PARAM4,PARAM5,PARAM6
              INTO :nd_fm_date,:nd_to_date,
                   :nd_fm_month,:nd_fm_year, :nd_to_month,:nd_to_year,
                   :nd_rep_type,  :nd_rep_order,
                   :nd_fm_main1,:nd_fm_main2,:nd_to_main1,:nd_to_main2,
                   :nd_fm_dept, :nd_to_dept,
                   :nd_fm_prd_gr,:nd_fm_prd_ln,:nd_to_prd_gr,:nd_to_prd_ln,
                   :nd_fm_sub_gr,:nd_fm_sub_ln,:nd_to_sub_gr,:nd_to_sub_ln,
				   :ndfmth,:ndfyr,:ndtmth,:ndtyr
             FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,PAR\
AM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 ,PARAM21 ,PARAM22 ,PARAM3 ,PARAM4 ,PA\
RAM5 ,PARAM6 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,\
:b14,:b15,:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24,:b25  from SY_PROG_PARA\
M where ((PGM_ID=:b26 and SESSION_ID=:b27) and PGM_DATE=:b28)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_month;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_year;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_month;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_year;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_rep_type;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_rep_order;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_main1;
   sqlstm.sqhstl[8] = (unsigned int  )9;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_fm_main2;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_main1;
   sqlstm.sqhstl[10] = (unsigned int  )9;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_to_main2;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_fm_dept;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_to_dept;
   sqlstm.sqhstl[13] = (unsigned int  )13;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_fm_prd_gr;
   sqlstm.sqhstl[14] = (unsigned int  )6;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_fm_prd_ln;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_to_prd_gr;
   sqlstm.sqhstl[16] = (unsigned int  )6;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_to_prd_ln;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_fm_sub_gr;
   sqlstm.sqhstl[18] = (unsigned int  )6;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_fm_sub_ln;
   sqlstm.sqhstl[19] = (unsigned int  )11;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_to_sub_gr;
   sqlstm.sqhstl[20] = (unsigned int  )6;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_to_sub_ln;
   sqlstm.sqhstl[21] = (unsigned int  )11;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&ndfmth;
   sqlstm.sqhstl[22] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&ndfyr;
   sqlstm.sqhstl[23] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&ndtmth;
   sqlstm.sqhstl[24] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&ndtyr;
   sqlstm.sqhstl[25] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[26] = (unsigned int  )17;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[27] = (unsigned int  )18;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[28] = (unsigned int  )27;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
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


/*
sprintf(string_var,"fm month-> %s",nd_fm_month.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"to month-> %s",nd_to_month.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"fm yuear-> %s",nd_fm_year.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"to year-> %s",nd_to_year.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,":nd_fm_main1-> %s",nd_fm_main1.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"to main1-> %s",nd_to_main1.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"fm main2 -> %s",nd_fm_main2.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"to main2-> %s",nd_to_main2.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"fm dept-> %s",nd_fm_dept.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"to main2-> %s",nd_to_dept.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"to main2-> %s",nd_to_main2.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"to main2-> %s",nd_to_main2.arr);
disp_message(ERR_MESG,string_var);
*/
   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

    nd_fm_date.arr[nd_fm_date.len]     = '\0';
    nd_to_date.arr[nd_to_date.len]     = '\0';
    nd_fm_month.arr[nd_fm_month.len]   = '\0';
    nd_fm_year.arr[nd_fm_year.len]     = '\0';
    nd_to_month.arr[nd_to_month.len]   = '\0';
    nd_to_year.arr[nd_to_year.len]     = '\0';
    nd_rep_type.arr[nd_rep_type.len]   = '\0';
    nd_fm_main1.arr[nd_fm_main1.len]   = '\0';
    nd_fm_main2.arr[nd_fm_main2.len]   = '\0';
    nd_to_main1.arr[nd_to_main1.len]   = '\0';
    nd_to_main2.arr[nd_to_main2.len]   = '\0';
    nd_fm_dept.arr[nd_fm_dept.len]     = '\0';
    nd_to_dept.arr[nd_to_dept.len]     = '\0';
    nd_fm_prd_gr.arr[nd_fm_prd_gr.len] = '\0';
    nd_fm_prd_ln.arr[nd_fm_prd_ln.len] = '\0';
    nd_to_prd_gr.arr[nd_to_prd_gr.len] = '\0';
    nd_to_prd_ln.arr[nd_to_prd_ln.len] = '\0';
    nd_fm_sub_gr.arr[nd_fm_sub_gr.len] = '\0';
    nd_fm_sub_ln.arr[nd_fm_sub_ln.len] = '\0';
    nd_to_sub_gr.arr[nd_to_sub_gr.len] = '\0';
    nd_to_sub_ln.arr[nd_to_sub_ln.len] = '\0';

   
   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )151;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[0] = (unsigned int  )17;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )27;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
}

declare_cur()
{

     /* EXEC SQL DECLARE BL_GL_DIS_CUR CURSOR FOR
               SELECT MAIN_ACC1_CODE,
                      MAIN_ACC2_CODE,
                      DEPT_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
                      POST_YEAR,
                      POST_MONTH,
                      TRUNC(TRX_DATE),
                      TRX_DOC_REF,
                      TRX_DOC_REF_LINE_NUM,
                      TRX_DOC_REF_SEQ_NUM,
                      EPISODE_TYPE,
                      PATIENT_ID,
                      EPISODE_ID,
                       VISIT_ID,
                      SOURCE_DOC_REF,
                      TRUNC(SOURCE_DOC_DATE),
                      SUBSTR(NARRATION,1,36),
                      TRX_TYPE_CODE,
                      DECODE(SIGN(NVL(DISTRIBUTION_AMT,0)),1,
                       TO_CHAR(NVL(DISTRIBUTION_AMT,0),'999,999,990.00'),
                       '                '),
                      DECODE(SIGN(NVL(DISTRIBUTION_AMT,0)),-1,
                       TO_CHAR(-1*NVL(DISTRIBUTION_AMT,0),'999,999,990.00'),
                       '                '),
                      DECODE(SIGN(NVL(DISTRIBUTION_AMT,0)),1,
                       NVL(DISTRIBUTION_AMT,0),0),
                      DECODE(SIGN(NVL(DISTRIBUTION_AMT,0)),-1,
                       -1*NVL(DISTRIBUTION_AMT,0),0),
                      GL_INTERFACE_BY_ID,
                      TRUNC(GL_INTERFACE_DATE),
                      GL_INTERFACE_FLAG,
                      MAIN_ACC1_CODE||'-'||
                      MAIN_ACC2_CODE||' '||
                      DEPT_CODE||' '||
                      PRODUCT_GROUP_CODE||'-'||
                      PRODUCT_LINE_CODE||' '||
                      SUBLEDGER_GROUP_CODE||'-'||
                      SUBLEDGER_LINE_CODE,
		      CASH_CTRL_DOC_TYPE,             
		      CASH_CTRL_DOC_NUMBER,           
		      TRUNC(CASH_CTRL_DOC_DATE)             
                 FROM BL_GL_DISTRIBUTION 
		 WHERE TRUNC(TRX_DATE) BETWEEN 
                        NVL(TO_DATE(:nd_fm_date,'DD/MM/YYYY'),
                             to_date('00010101','YYYYDDMM')) AND
                        NVL(TO_DATE(:nd_to_date,'DD/MM/YYYY'),
                             to_date('47123112','YYYYDDMM'))
			     		  AND
			         LTRIM(TO_CHAR(POST_YEAR,'0009'))||
					 LTRIM(TO_CHAR(POST_MONTH,'09'))
					 BETWEEN 
					 LTRIM(TO_CHAR(nvl(to_number(:nd_fm_year),'0001'),'0009'))||
					 LTRIM(TO_CHAR(nvl(to_number(:nd_fm_month),'01'),'09')) 
					 AND
					 LTRIM(TO_CHAR(nvl(to_number(:nd_to_year),'9999'),'0009'))||
					 LTRIM(TO_CHAR(nvl(to_number(:nd_to_month),'99'),'09'))	         	 
                  AND RPAD(MAIN_ACC1_CODE,6,' ')||RPAD(MAIN_ACC2_CODE,4,' ')
                   BETWEEN 
                       RPAD(NVL(:nd_fm_main1,' '),6,' ')||
                       RPAD(NVL(:nd_fm_main2,' '),4,' ')
                     AND
                       RPAD(NVL(:nd_to_main1,'~~~~~~'),6,' ')||
                       RPAD(NVL(:nd_to_main2,'~~~~'),4,' ')
                  AND RPAD(DEPT_CODE, 6, ' ') BETWEEN 
                       RPAD(NVL(:nd_fm_dept,' '),6,' ')
                      AND 
                       RPAD(NVL(:nd_to_dept,'~~~~~~'),6,' ')
                  AND RPAD(PRODUCT_GROUP_CODE,3,'0')||RPAD(PRODUCT_LINE_CODE,4,'0')
                   BETWEEN 
                       RPAD(NVL(:nd_fm_prd_gr,' '),3,'0')||
                       RPAD(NVL(:nd_fm_prd_ln,' '),4,'0')
                     AND 
                       RPAD(NVL(:nd_to_prd_gr,'~~~'),3,'0')||
                       RPAD(NVL(:nd_to_prd_ln,'~~~~'),4,'0')
                  AND RPAD(SUBLEDGER_GROUP_CODE,3,'0')||RPAD(SUBLEDGER_LINE_CODE,8,'0')
                   BETWEEN 
                       RPAD(NVL(:nd_fm_sub_gr,' '),3,'0')||
                       RPAD(NVL(:nd_fm_sub_ln,' '),8,'0')
                     AND
                       RPAD(NVL(:nd_to_sub_gr,'~~~'),3,'0')||
                       RPAD(NVL(:nd_to_sub_ln,'~~~~~~~~'),8,'0')
		  AND operating_facility_id = :nd_operating_facility_id
                 ORDER BY MAIN_ACC1_CODE||'-'||
                          MAIN_ACC2_CODE||' '||
                          DEPT_CODE||' '||
                          PRODUCT_GROUP_CODE||'-'||
                          PRODUCT_LINE_CODE||' '||
                          SUBLEDGER_GROUP_CODE||'-'||
                          SUBLEDGER_LINE_CODE,
                          DECODE(:nd_rep_order,1,TO_CHAR(TRX_DATE,'YYYYMMDD'),
                               TRX_DOC_REF); */ 


    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
                     /osubstr(SHORT_NAME,1,30),
					 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname2 ,
                     o/
					 short_name
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_dis_patient_id; */ 


     /* EXEC SQL DECLARE GL_POSTING_ACC_CUR CURSOR FOR
               SELECT CONCAT_POST_ACC_DESC
                 FROM GL_POSTING_ACC
                WHERE MAIN_ACC1_CODE       = :bl_dis_main_acc1_code
                  AND MAIN_ACC2_CODE       = :bl_dis_main_acc2_code
                  AND DEPT_CODE            = :bl_dis_dept_code
                  AND PRODUCT_GROUP_CODE   = :bl_dis_product_group_code
                  AND PRODUCT_LINE_CODE    = :bl_dis_product_line_code
                  AND SUBLEDGER_GROUP_CODE = :bl_dis_subledger_group_code
                  AND SUBLEDGER_LINE_CODE  = :bl_dis_subledger_line_code
		  AND ACC_ENTITY_CODE IN ( SELECT acc_entity_code FROM sy_acc_entity
			where acc_entity_id = :nd_operating_facility_id ); */ 

}

open_bl_gl_dis()
{
    /* EXEC SQL OPEN BL_GL_DIS_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE \
,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,POST_YEAR ,PO\
ST_MONTH ,TRUNC(TRX_DATE) ,TRX_DOC_REF ,TRX_DOC_REF_LINE_NUM ,TRX_DOC_REF_SE\
Q_NUM ,EPISODE_TYPE ,PATIENT_ID ,EPISODE_ID ,VISIT_ID ,SOURCE_DOC_REF ,TRUNC\
(SOURCE_DOC_DATE) ,SUBSTR(NARRATION,1,36) ,TRX_TYPE_CODE ,DECODE(SIGN(NVL(DI\
STRIBUTION_AMT,0)),1,TO_CHAR(NVL(DISTRIBUTION_AMT,0),'999,999,990.00'),'    \
            ') ,DECODE(SIGN(NVL(DISTRIBUTION_AMT,0)),(-1),TO_CHAR(((-1)* NVL\
(DISTRIBUTION_AMT,0)),'999,999,990.00'),'                ') ,DECODE(SIGN(NVL\
(DISTRIBUTION_AMT,0)),1,NVL(DISTRIBUTION_AMT,0),0) ,DECODE(SIGN(NVL(DISTRIBU\
TION_AMT,0)),(-1),((-1)* NVL(DISTRIBUTION_AMT,0)),0) ,GL_INTERFACE_BY_ID ,TR\
UNC(GL_INTERFACE_DATE) ,GL_INTERFACE_FLAG ,((((((((((((MAIN_ACC1_CODE||'-')|\
|MAIN_ACC2_CODE)||' ')||DEPT_CODE)||' ')||PRODUCT_GROUP_CODE)||'-')||PRODUCT\
_LINE_CODE)||' ')||SUBLEDGER_GROUP_CODE)||'-')||SUBLEDGER_LINE_CODE) ,CASH_C\
TRL_DOC_TYPE ,CASH_CTRL_DOC_NUMBER ,TRUNC(C");
    sqlbuft((void **)0, 
      "ASH_CTRL_DOC_DATE)  from BL_GL_DISTRIBUTION where ((((((TRUNC(TRX_DAT\
E) between NVL(TO_DATE(:b0,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM')) and\
 NVL(TO_DATE(:b1,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM')) and (LTRIM(TO\
_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09'))) between (LTRIM(TO\
_CHAR(nvl(to_number(:b2),'0001'),'0009'))||LTRIM(TO_CHAR(nvl(to_number(:b3),\
'01'),'09'))) and (LTRIM(TO_CHAR(nvl(to_number(:b4),'9999'),'0009'))||LTRIM(\
TO_CHAR(nvl(to_number(:b5),'99'),'09')))) and (RPAD(MAIN_ACC1_CODE,6,' ')||R\
PAD(MAIN_ACC2_CODE,4,' ')) between (RPAD(NVL(:b6,' '),6,' ')||RPAD(NVL(:b7,'\
 '),4,' ')) and (RPAD(NVL(:b8,'~~~~~~'),6,' ')||RPAD(NVL(:b9,'~~~~'),4,' '))\
) and RPAD(DEPT_CODE,6,' ') between RPAD(NVL(:b10,' '),6,' ') and RPAD(NVL(:\
b11,'~~~~~~'),6,' ')) and (RPAD(PRODUCT_GROUP_CODE,3,'0')||RPAD(PRODUCT_LINE\
_CODE,4,'0')) between (RPAD(NVL(:b12,' '),3,'0')||RPAD(NVL(:b13,' '),4,'0'))\
 and (RPAD(NVL(:b14,'~~~'),3,'0')||RPAD(NVL(:b15,'~~~~'),4,'0'))) and (RPAD(\
SUBLEDGER_GROUP_CODE,3,'0')||RPAD(SUBLEDGER");
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )178;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_year;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_month;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_month;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fm_main1;
    sqlstm.sqhstl[6] = (unsigned int  )9;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fm_main2;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_main1;
    sqlstm.sqhstl[8] = (unsigned int  )9;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_main2;
    sqlstm.sqhstl[9] = (unsigned int  )7;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_fm_dept;
    sqlstm.sqhstl[10] = (unsigned int  )13;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_to_dept;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_fm_prd_gr;
    sqlstm.sqhstl[12] = (unsigned int  )6;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_fm_prd_ln;
    sqlstm.sqhstl[13] = (unsigned int  )7;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_to_prd_gr;
    sqlstm.sqhstl[14] = (unsigned int  )6;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_to_prd_ln;
    sqlstm.sqhstl[15] = (unsigned int  )7;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_fm_sub_gr;
    sqlstm.sqhstl[16] = (unsigned int  )6;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_fm_sub_ln;
    sqlstm.sqhstl[17] = (unsigned int  )11;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_to_sub_gr;
    sqlstm.sqhstl[18] = (unsigned int  )6;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_to_sub_ln;
    sqlstm.sqhstl[19] = (unsigned int  )11;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[20] = (unsigned int  )5;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&nd_rep_order;
    sqlstm.sqhstl[21] = (unsigned int  )sizeof(int);
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_GL_DIS_CUR",0,"");
}

fetch_bl_gl_dis()
{

bl_dis_main_acc1_code.arr[0]                                      = '\0';
bl_dis_main_acc2_code.arr[0]                                      = '\0';
bl_dis_dept_code.arr[0]                                           = '\0';
bl_dis_product_group_code.arr[0]                                  = '\0';
bl_dis_product_line_code.arr[0]                                   = '\0';
bl_dis_subledger_group_code.arr[0]                                = '\0';
bl_dis_subledger_line_code.arr[0]                                 = '\0';
bl_dis_post_year.arr[0]                                           = '\0';
bl_dis_post_month.arr[0]                                          = '\0';
bl_dis_trx_date.arr[0]                                            = '\0';
bl_dis_trx_doc_ref.arr[0]                                         = '\0';
bl_dis_trx_doc_ref_line_num.arr[0]                                = '\0';
bl_dis_trx_doc_ref_seq_num.arr[0]                                 = '\0';
bl_dis_episode_type.arr[0]                                        = '\0';
bl_dis_patient_id.arr[0]                                          = '\0';
bl_dis_episode_id.arr[0]                                          = '\0';
bl_dis_visit_id.arr[0]                                            = '\0';
bl_dis_source_doc_ref.arr[0]                                      = '\0';
bl_dis_source_doc_date.arr[0]                                     = '\0';
bl_dis_narration.arr[0]                                           = '\0';
bl_dis_trx_type_code.arr[0]                                       = '\0';
bl_dis_debit_amt_prn.arr[0]                                       = '\0';
bl_dis_credit_amt_prn.arr[0]                                      = '\0';
bl_dis_gl_interface_by_id.arr[0]                                  = '\0';
bl_dis_gl_interface_date.arr[0]                                   = '\0';
bl_dis_gl_interface_flag.arr[0]                                   = '\0';
bl_dis_concat_post_acc.arr[0]                                     = '\0';
nd_cash_ctrl_doc_type.arr[0]									  = '\0';
nd_cash_ctrl_doc_num.arr[0]										  = '\0';
nd_cash_ctrl_doc_date.arr[0]									  = '\0';

bl_dis_main_acc1_code.len                                         = 0;
bl_dis_main_acc2_code.len                                         = 0;
bl_dis_dept_code.len                                              = 0;
bl_dis_product_group_code.len                                     = 0;
bl_dis_product_line_code.len                                      = 0;
bl_dis_subledger_group_code.len                                   = 0;
bl_dis_subledger_line_code.len                                    = 0;
bl_dis_post_year.len                                              = 0;
bl_dis_post_month.len                                             = 0;
bl_dis_trx_date.len                                               = 0;
bl_dis_trx_doc_ref.len                                            = 0;
bl_dis_trx_doc_ref_line_num.len                                   = 0;
bl_dis_trx_doc_ref_seq_num.len                                    = 0;
bl_dis_episode_type.len                                           = 0;
bl_dis_patient_id.len                                             = 0;
bl_dis_episode_id.len                                             = 0;
bl_dis_visit_id.len                                               = 0;
bl_dis_source_doc_ref.len                                         = 0;
bl_dis_source_doc_date.len                                        = 0;
bl_dis_narration.len                                              = 0;
bl_dis_trx_type_code.len                                          = 0;
bl_dis_debit_amt_prn.len                                          = 0;
bl_dis_credit_amt_prn.len                                         = 0;
bl_dis_gl_interface_by_id.len                                     = 0;
bl_dis_gl_interface_date.len                                      = 0;
bl_dis_gl_interface_flag.len                                      = 0;
bl_dis_concat_post_acc.len                                        = 0;
nd_cash_ctrl_doc_type.len										  = 0;
nd_cash_ctrl_doc_num.len										  = 0;
nd_cash_ctrl_doc_date.len										  = 0;
bl_dis_debit_amt                                                  = 0;
bl_dis_credit_amt                                                 = 0;


     /* EXEC SQL FETCH BL_GL_DIS_CUR
               INTO :bl_dis_main_acc1_code,
                    :bl_dis_main_acc2_code,
                    :bl_dis_dept_code,
                    :bl_dis_product_group_code,
                    :bl_dis_product_line_code,
                    :bl_dis_subledger_group_code,
                    :bl_dis_subledger_line_code,
                    :bl_dis_post_year,
                    :bl_dis_post_month,
                    :bl_dis_trx_date,
                    :bl_dis_trx_doc_ref,
                    :bl_dis_trx_doc_ref_line_num,
                    :bl_dis_trx_doc_ref_seq_num,
                    :bl_dis_episode_type,
                    :bl_dis_patient_id,
                    :bl_dis_episode_id,
                    :bl_dis_visit_id,
                    :bl_dis_source_doc_ref,
                    :bl_dis_source_doc_date,
                    :bl_dis_narration,
                    :bl_dis_trx_type_code,
                    :bl_dis_debit_amt_prn,
                    :bl_dis_credit_amt_prn,
                    :bl_dis_debit_amt,
                    :bl_dis_credit_amt,
                    :bl_dis_gl_interface_by_id,
                    :bl_dis_gl_interface_date,
                    :bl_dis_gl_interface_flag,
                    :bl_dis_concat_post_acc,
					:nd_cash_ctrl_doc_type,
					:nd_cash_ctrl_doc_num,
					:nd_cash_ctrl_doc_date; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 32;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )281;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_dis_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_dis_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_dis_dept_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_dis_product_group_code;
     sqlstm.sqhstl[3] = (unsigned int  )6;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_dis_product_line_code;
     sqlstm.sqhstl[4] = (unsigned int  )7;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_dis_subledger_group_code;
     sqlstm.sqhstl[5] = (unsigned int  )6;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_dis_subledger_line_code;
     sqlstm.sqhstl[6] = (unsigned int  )11;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_dis_post_year;
     sqlstm.sqhstl[7] = (unsigned int  )7;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_dis_post_month;
     sqlstm.sqhstl[8] = (unsigned int  )5;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_dis_trx_date;
     sqlstm.sqhstl[9] = (unsigned int  )15;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_dis_trx_doc_ref;
     sqlstm.sqhstl[10] = (unsigned int  )23;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_dis_trx_doc_ref_line_num;
     sqlstm.sqhstl[11] = (unsigned int  )7;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_dis_trx_doc_ref_seq_num;
     sqlstm.sqhstl[12] = (unsigned int  )7;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_dis_episode_type;
     sqlstm.sqhstl[13] = (unsigned int  )4;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_dis_patient_id;
     sqlstm.sqhstl[14] = (unsigned int  )23;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_dis_episode_id;
     sqlstm.sqhstl[15] = (unsigned int  )11;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_dis_visit_id;
     sqlstm.sqhstl[16] = (unsigned int  )7;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_dis_source_doc_ref;
     sqlstm.sqhstl[17] = (unsigned int  )23;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_dis_source_doc_date;
     sqlstm.sqhstl[18] = (unsigned int  )15;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_dis_narration;
     sqlstm.sqhstl[19] = (unsigned int  )53;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_dis_trx_type_code;
     sqlstm.sqhstl[20] = (unsigned int  )4;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_dis_debit_amt_prn;
     sqlstm.sqhstl[21] = (unsigned int  )25;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_dis_credit_amt_prn;
     sqlstm.sqhstl[22] = (unsigned int  )25;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_dis_debit_amt;
     sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_dis_credit_amt;
     sqlstm.sqhstl[24] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&bl_dis_gl_interface_by_id;
     sqlstm.sqhstl[25] = (unsigned int  )23;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&bl_dis_gl_interface_date;
     sqlstm.sqhstl[26] = (unsigned int  )15;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&bl_dis_gl_interface_flag;
     sqlstm.sqhstl[27] = (unsigned int  )4;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&bl_dis_concat_post_acc;
     sqlstm.sqhstl[28] = (unsigned int  )52;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&nd_cash_ctrl_doc_type;
     sqlstm.sqhstl[29] = (unsigned int  )9;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&nd_cash_ctrl_doc_num;
     sqlstm.sqhstl[30] = (unsigned int  )11;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&nd_cash_ctrl_doc_date;
     sqlstm.sqhstl[31] = (unsigned int  )14;
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



    if (OERROR)
         err_mesg("FETCH failed on cursor BL_GL_DIS_CUR",0,"");

bl_dis_main_acc1_code.arr[bl_dis_main_acc1_code.len]                     = '\0';
bl_dis_main_acc2_code.arr[bl_dis_main_acc2_code.len]                     = '\0';
bl_dis_dept_code.arr[bl_dis_dept_code.len]                               = '\0';
bl_dis_product_group_code.arr[bl_dis_product_group_code.len]             = '\0';
bl_dis_product_line_code.arr[bl_dis_product_line_code.len]               = '\0';
bl_dis_subledger_group_code.arr[bl_dis_subledger_group_code.len]         = '\0';
bl_dis_subledger_line_code.arr[bl_dis_subledger_line_code.len]           = '\0';
bl_dis_post_year.arr[bl_dis_post_year.len]                               = '\0';
bl_dis_post_month.arr[bl_dis_post_month.len]                             = '\0';
bl_dis_trx_date.arr[bl_dis_trx_date.len]                                 = '\0';
bl_dis_trx_doc_ref.arr[bl_dis_trx_doc_ref.len]                           = '\0';
bl_dis_trx_doc_ref_line_num.arr[bl_dis_trx_doc_ref_line_num.len]         = '\0';
bl_dis_trx_doc_ref_seq_num.arr[bl_dis_trx_doc_ref_seq_num.len]           = '\0';
bl_dis_episode_type.arr[bl_dis_episode_type.len]                         = '\0';
bl_dis_patient_id.arr[bl_dis_patient_id.len]                             = '\0';
bl_dis_episode_id.arr[bl_dis_episode_id.len]                             = '\0';
bl_dis_visit_id.arr[bl_dis_visit_id.len]                                 = '\0';
bl_dis_source_doc_ref.arr[bl_dis_source_doc_ref.len]                     = '\0';
bl_dis_source_doc_date.arr[bl_dis_source_doc_date.len]                   = '\0';
bl_dis_narration.arr[bl_dis_narration.len]                               = '\0';
bl_dis_trx_type_code.arr[bl_dis_trx_type_code.len]                       = '\0';
bl_dis_debit_amt_prn.arr[bl_dis_debit_amt_prn.len]                       = '\0';
bl_dis_credit_amt_prn.arr[bl_dis_credit_amt_prn.len]                     = '\0';
bl_dis_gl_interface_by_id.arr[bl_dis_gl_interface_by_id.len]             = '\0';
bl_dis_gl_interface_date.arr[bl_dis_gl_interface_date.len]               = '\0';
bl_dis_gl_interface_flag.arr[bl_dis_gl_interface_flag.len]               = '\0';
bl_dis_concat_post_acc.arr[bl_dis_concat_post_acc.len]                   = '\0';
nd_cash_ctrl_doc_type.arr[nd_cash_ctrl_doc_type.len]     				 = '\0';
nd_cash_ctrl_doc_num.arr[nd_cash_ctrl_doc_num.len]						 = '\0';
nd_cash_ctrl_doc_date.arr[nd_cash_ctrl_doc_date.len]					 = '\0';


    return(LAST_ROW?0:1);
}

fetch_dtls()     
{

   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 32;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )424;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_dis_patient_id;
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
        err_mesg("OPEN failed on cursor BL_PAT_NAME_CUR",0,"");

   bl_patient_name_loc_lang.arr[0]           = '\0';
   bl_patient_name.arr[0]                    = '\0';
   bl_patient_name1.arr[0]                    = '\0';

   bl_patient_name_loc_lang.len              = 0;
   bl_patient_name.len                       = 0;
   bl_patient_name1.len                       = 0;

    /* EXEC SQL FETCH BL_PAT_NAME_CUR
              INTO :bl_patient_name_loc_lang,  
                   /o:bl_patient_name,
				   :bl_patient_name1,o/
                   :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )443;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_patient_name_loc_lang;
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



    if (OERROR)
         err_mesg("FETCH failed on cursor BL_PAT_NAME_CUR",0,"");

    bl_patient_name_loc_lang.arr[bl_patient_name_loc_lang.len] = '\0';
    bl_patient_name.arr[bl_patient_name.len]				   = '\0';
	bl_patient_name1.arr[bl_patient_name1.len]				   = '\0';
    d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
/* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :bl_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_name1    := :bl_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 32;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :bl_patient_name := str2 ; END IF ; blcommon . s\
plit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NO\
T NULL THEN :bl_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d_s\
hort_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl_p\
atient_name1 := :bl_patient_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )466;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )63;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&bl_patient_name;
sqlstm.sqhstl[1] = (unsigned int  )63;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&bl_patient_name1;
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


       bl_patient_name.arr[bl_patient_name.len]  = '\0';
       bl_patient_name1.arr[bl_patient_name1.len]  = '\0';

}

print_rec(ind)
int ind;
{
   char l_form_str[200];

   acc_debit_amt_tot  += bl_dis_debit_amt;
   acc_credit_amt_tot += bl_dis_credit_amt;

   if (!DETAIL)
       return;

   if (lctr1 > 60)
       print_head1();

   fetch_dtls();

   if (DETAIL)
   {
      sprintf(l_form_str,
           "    %s  %%2s/%%2s  %%-36.36s %%1s %%-8s %%-20.20s %%-18.18s %%-7.7s %%-12.12s %%s%%s\n",
      (nd_rep_order == 1)?"%-10s %-20s/%4s/%4s":"%-20s/%4s/%4s %-10s");

if(bl_dis_trx_date.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,bl_dis_trx_date.arr);
fun_change_loc_date1();
strcpy(bl_dis_trx_date1.arr,date_convert.arr);
}

if(bl_dis_post_year.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,bl_dis_post_year.arr);
fun_change_loc_date2();
strcpy(bl_dis_post_year1.arr,date_convert.arr);
}
   
     fprintf(fp_det,l_form_str,
              (nd_rep_order == 1)?bl_dis_trx_date1.arr:bl_dis_trx_doc_ref.arr,
              (nd_rep_order == 1)? bl_dis_trx_doc_ref.arr:
                          bl_dis_trx_doc_ref_line_num.arr,
              (nd_rep_order == 1)? bl_dis_trx_doc_ref_line_num.arr:
                          bl_dis_trx_doc_ref_seq_num.arr,
              (nd_rep_order == 1)? bl_dis_trx_doc_ref_seq_num.arr:
                          bl_dis_trx_date1.arr,
              bl_dis_post_month.arr,
              bl_dis_post_year1.arr,
              bl_dis_narration.arr,
              bl_dis_episode_type.arr,
              bl_dis_episode_id.arr,
              bl_dis_patient_id.arr,
	      nd_cash_ctrl_doc_type.arr,
	      nd_cash_ctrl_doc_num.arr,
	      nd_cash_ctrl_doc_date.arr,
              bl_dis_debit_amt_prn.arr,
              bl_dis_credit_amt_prn.arr);
     lctr1+=1;

        fflush(fp_det);
    }
}

print_posting_acc()
{
    if (DETAIL)
    {
        if (lctr1 > 60)
            print_head1();
        fprintf(fp_det,"%-45.45s",bl_dis_concat_post_acc.arr);
        fprintf(fp_det,"        %s\n",posting_acc_desc.arr);
        lctr1+=2;
    }

    if (SUMMARY)
    {
        if (lctr2 > 52)
            print_head2();
        fprintf(fp_sum,"%-75.75s ",bl_dis_concat_post_acc.arr);
    }
        
}

get_post_desc()
{
      posting_acc_desc.arr[0] = '\0';
      posting_acc_desc.len    = 0;

      /* EXEC SQL OPEN GL_POSTING_ACC_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 32;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0006;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )493;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_dis_main_acc1_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_dis_main_acc2_code;
      sqlstm.sqhstl[1] = (unsigned int  )7;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_dis_dept_code;
      sqlstm.sqhstl[2] = (unsigned int  )13;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_dis_product_group_code;
      sqlstm.sqhstl[3] = (unsigned int  )6;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_dis_product_line_code;
      sqlstm.sqhstl[4] = (unsigned int  )7;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_dis_subledger_group_code;
      sqlstm.sqhstl[5] = (unsigned int  )6;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_dis_subledger_line_code;
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
                INTO :posting_acc_desc; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 32;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )540;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&posting_acc_desc;
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

      posting_acc_desc.arr[posting_acc_desc.len] = '\0';

      if(NO_DATA_FOUND)
          strcpy(posting_acc_desc.arr,loc_legend[37]);

}

print_acc_total()
{
   if (DETAIL)
   {
       if (lctr1 > 55)
           print_head1();
       fprintf(fp_det,"%165s--------------- ---------------\n"," ");
       fprintf(fp_det,"%142s  %-10.10s            "," ",loc_legend[32]);
       print_formated(acc_debit_amt_tot,fp_det);fprintf(fp_det," ");
       print_formated(acc_credit_amt_tot,fp_det);
       fprintf(fp_det,"\n%165s--------------- ---------------\n"," ");
       fprintf(fp_det,"%142s  %-11.11s                           "," ",loc_legend[33]);
       print_formated(acc_debit_amt_tot-acc_credit_amt_tot,fp_det);
       fprintf(fp_det,"\n\n");
       lctr1+=5;
   }

   if (SUMMARY)
   {
       print_formated(acc_debit_amt_tot,fp_sum);fprintf(fp_sum," ");
       print_formated(acc_credit_amt_tot,fp_sum);fprintf(fp_sum," ");
       print_formated(acc_debit_amt_tot-acc_credit_amt_tot,fp_sum);
       fprintf(fp_sum,"\n");
       fprintf(fp_sum,"        %s\n",posting_acc_desc.arr);
       lctr2+= 2;
   }
   grand_debit_amt_tot  += acc_debit_amt_tot;
   grand_credit_amt_tot += acc_credit_amt_tot;

   acc_debit_amt_tot  = 0;
   acc_credit_amt_tot = 0;
}

print_grand_total()
{
   print_acc_total();
   if (DETAIL)
   {
       if (lctr1 > 55)
           print_head1();
       fprintf(fp_det,"%165s--------------- ---------------\n"," ");
       fprintf(fp_det,"%142s  %-11.11s           "," ",loc_legend[34]);
       print_formated(grand_debit_amt_tot,fp_det); fprintf(fp_det," ");
       print_formated(grand_credit_amt_tot,fp_det);
       fprintf(fp_det,"\n%165s--------------- ---------------\n"," ");
       fprintf(fp_det,"%142s  %-13.13s                         "," ",loc_legend[35]);
       print_formated(grand_debit_amt_tot-grand_credit_amt_tot,fp_det);
       fprintf(fp_det,"\n\n");
       lctr1+=5;
   }

   if (SUMMARY)
   {
       if (lctr2 > 50)
           print_head1();
       fprintf(fp_sum,"%75s--------------- --------------- ---------------\n"," ");
       fprintf(fp_sum,"%65s %-6.6s    "," ",loc_legend[32]);
       print_formated(grand_debit_amt_tot,fp_sum);fprintf(fp_sum," ");
       print_formated(grand_credit_amt_tot,fp_sum);fprintf(fp_sum," ");
       print_formated(grand_debit_amt_tot-grand_credit_amt_tot,fp_sum);
       fprintf(fp_sum,"\n");
       fprintf(fp_sum,"%75s--------------- --------------- ---------------\n"," ");
       lctr2+= 4;
   }
}

end_of_rep()
{
    if (DETAIL)
    {
      fprintf(fp_det,"\n\n                                       \
             ***  %-13.13s ***\n",loc_legend[36]);
      fflush(fp_det);
    }

    if (SUMMARY)
    {
      fprintf(fp_sum,"\n\n                                         \
             ***  %-13.13s ***\n",loc_legend[36]);
      fflush(fp_sum);
    }
}

open_file()
{
    if (DETAIL)
    {
		strcpy(filename,WORKING_DIR);
		
		strcat(filename,"blrgldde.lis");

		strcpy(OUTPUT_FILE_NAME,"blrgldde.lis");
	
         if ((fp_det = fopen(filename,"w")) == NULL)
         {
             disp_message(ERR_MESG,"Error in opening file blrgldde.lis");
             proc_exit();
         }
         
         print_title1();
         print_head1();
    }

    if (SUMMARY)
    {
		strcpy(filename,WORKING_DIR);
		strcat(filename,"blrgldsu.lis");
		
		strcpy(OUTPUT_FILE_NAME,"blrgldsu.lis");

         if ((fp_sum = fopen(filename,"w")) == NULL)
         {
             disp_message(ERR_MESG,"Error in opening file blrgldsu.lis");
             
			 proc_exit();
         }
        
         print_title2();
         print_head2();         
    }                 
    
}

print_title1()    /* Title for Detail */
{
    if (!DETAIL)
        return;

fprintf(fp_det,"\fMDL : BL                                            %-40.40s                          %-16.16s\n",hosp_name.arr,date_time.arr);
fprintf(fp_det,"OPR : %-30.30s \n", user_id.arr);
fprintf(fp_det,"REP : %-8s                            %-43.43s                                     %-4.4s : %4d\n","BLRGLDDE",loc_legend[1],loc_legend[2],++pctr1);
fprintf(fp_det,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp_det,"VER : 4.1\n");
fflush(fp_det);

if(nd_fm_date.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_fm_date.arr);
fun_change_loc_date1();
strcpy(nd_fm_date1.arr,date_convert.arr);
}

if(nd_to_date.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_to_date.arr);
fun_change_loc_date1();
strcpy(nd_to_date1.arr,date_convert.arr);
}

if(nd_fm_year.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_fm_year.arr);
fun_change_loc_date2();
strcpy(nd_fm_year1.arr,date_convert.arr);
}
if(nd_to_year.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_to_year.arr);
fun_change_loc_date2();
strcpy(nd_to_year1.arr,date_convert.arr);
}

fprintf(fp_det,"\n\n\n\n        %-16.16s :\n        ----------------\n\n",loc_legend[3]);
fprintf(fp_det,"                  %-16.16s  %-4.4s : %10s\n",loc_legend[4],loc_legend[38],
                                               nd_fm_date1.arr);
fprintf(fp_det,"                                    %-4.4s : %10s\n\n",loc_legend[39],
                                               nd_to_date1.arr);
fprintf(fp_det,"                  %-17.17s %-4.4s : %2s/%4s\n",loc_legend[5],loc_legend[38],
                         nd_fm_month.arr,nd_fm_year1.arr);
fprintf(fp_det,"                                    %-4.4s : %2s/%4s\n\n",loc_legend[39],
                         nd_to_month.arr,nd_to_year1.arr);
fprintf(fp_det,"                  %-11.11s            : %1s\n",loc_legend[6],nd_rep_type.arr);
fprintf(fp_det,"                            (D - %-6.6s  S - %-7.7s  B - %-4.4s)\n\n",loc_legend[7],loc_legend[8],loc_legend[9]);
fprintf(fp_det,"                  %-12.12s           : %s\n\n",loc_legend[10],
(nd_rep_order == 1)?loc_legend[11]:(nd_rep_order == 2)?loc_legend[12]:"");
fprintf(fp_det,"                  %-17.17s                         %-4.4s           %-2.2s\n\n",loc_legend[13],loc_legend[38],loc_legend[39]);
fprintf(fp_det,"                       %-12.12s                     %-6s-%-4s   %6s-%-4s\n",loc_legend[14],
            nd_fm_main1.arr, nd_fm_main2.arr, nd_to_main1.arr, nd_to_main2.arr);
fprintf(fp_det,"                       %-4.4s                             %-6s           %6s\n",loc_legend[15],
            nd_fm_dept.arr, nd_to_dept.arr);
fprintf(fp_det,"                       %-7.7s                          %-6s-%-4s      %-3s-%-4s\n",loc_legend[16],
           nd_fm_prd_gr.arr,nd_fm_prd_ln.arr,nd_to_prd_gr.arr,nd_to_prd_ln.arr);
fprintf(fp_det,"                       %-9.9s                        %-6s-%-4s      %-3s-%-4s\n",loc_legend[17],
           nd_fm_sub_gr.arr,nd_fm_sub_ln.arr,nd_to_sub_gr.arr,nd_to_sub_ln.arr);

}

print_title2()   /* Title for Summary */
{
  if (!SUMMARY)
        return;
fprintf(fp_sum,"\fMDL : BL                                            %-40.40s                         %-16.16s\n",hosp_name.arr,date_time.arr);
fprintf(fp_sum,"OPR : %-30.30s \n", user_id.arr);
fprintf(fp_sum,"REP : %-8s                            %-44.44s                               %-4.4s : %4d\n",
"BLRGLDSU",loc_legend[18],loc_legend[2],++pctr2);

fprintf(fp_sum,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp_sum,"VER : 4.1\n");
fflush(fp_sum);

if(nd_fm_date.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_fm_date.arr);
fun_change_loc_date1();
strcpy(nd_fm_date1.arr,date_convert.arr);
}

if(nd_to_date.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_to_date.arr);
fun_change_loc_date1();
strcpy(nd_to_date1.arr,date_convert.arr);
}

if(nd_fm_year.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_fm_year.arr);
fun_change_loc_date2();
strcpy(nd_fm_year1.arr,date_convert.arr);
}
if(nd_to_year.arr[0]!='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_to_year.arr);
fun_change_loc_date2();
strcpy(nd_to_year1.arr,date_convert.arr);
}


fprintf(fp_sum,"\n\n\n\n        %-16.16s :\n        ----------------\n\n",loc_legend[3]);
fprintf(fp_sum,"                  %-16.16s  %-4.4s : %10s\n",loc_legend[4],loc_legend[38],
                                               nd_fm_date1.arr);
fprintf(fp_sum,"                                    %-4.4s : %10s\n\n",loc_legend[39],
                                               nd_to_date1.arr);
fprintf(fp_sum,"                  %-17.17s %-4.4s : %2s/%4s\n",loc_legend[5],loc_legend[38],
                         nd_fm_month.arr,nd_fm_year1.arr);
fprintf(fp_sum,"                                    %-4.4s : %2s/%4s\n\n",loc_legend[39],
                         nd_to_month.arr,nd_to_year1.arr);
fprintf(fp_sum,"                  %-11.11s            : %1s\n",loc_legend[6],nd_rep_type.arr);
fprintf(fp_sum,"                            (D - %-6.6s  S - %-7.7s  B - %-4.4s)\n\n",loc_legend[7],loc_legend[8],loc_legend[9]);
fprintf(fp_sum,"                  %-12.12s           : %s\n\n",loc_legend[10],
(nd_rep_order == 1)?loc_legend[11]:(nd_rep_order == 2)?loc_legend[12]:"");
fprintf(fp_sum,"                  %-17.17s                         %-4.4s           %-2.2s\n\n",loc_legend[13],loc_legend[38],loc_legend[39]);
fprintf(fp_sum,"                       %-12.12s                     %-6s-%-4s   %6s-%-4s\n",loc_legend[14],
            nd_fm_main1.arr, nd_fm_main2.arr, nd_to_main1.arr, nd_to_main2.arr);
fprintf(fp_sum,"                       %-4.4s                             %6s            %6s\n",loc_legend[15],
            nd_fm_dept.arr, nd_to_dept.arr);
fprintf(fp_sum,"                       %-7.7s                          %-6s-%-4s      %-3s-%-4s\n",loc_legend[16],
           nd_fm_prd_gr.arr,nd_fm_prd_ln.arr,nd_to_prd_gr.arr,nd_to_prd_ln.arr);
fprintf(fp_sum,"                       %-9.9s                        %-6s-%-8s  %-3s-%-4s\n",loc_legend[17],
           nd_fm_sub_gr.arr,nd_fm_sub_ln.arr,nd_to_sub_gr.arr,nd_to_sub_ln.arr);

}

print_head1()    /* Heading for Detail */
{
  
  if (!DETAIL)
        return;
fprintf(fp_det,"\fMDL : BL	                                      %-40.40s	                            %-16.16s\n",hosp_name.arr,date_time.arr);
fprintf(fp_det,"OPR : %-30.30s \n", user_id.arr);
fprintf(fp_det,"REP : %-8s                              %-43.43s                  		                 				%-4.4s : %4d\n",
"BLRGLDDE",loc_legend[1],loc_legend[2],++pctr1);

if(nd_rep_order == 1)
{
fprintf(fp_det,"      %-12.12s : %-11.11s      		(%-14.14s %2s/%4s to %2s/%4s)\n",
loc_legend[10],loc_legend[11],loc_legend[19],
nd_fm_month.arr,nd_fm_year1.arr,
nd_to_month.arr,nd_to_year1.arr);
}
else
{
fprintf(fp_det,"      %-12.12s : %-11.11s      		(%-14.14s %2s/%4s to %2s/%4s)\n",
loc_legend[10],loc_legend[12],loc_legend[19],
nd_fm_month.arr,nd_fm_year1.arr,
nd_to_month.arr,nd_to_year1.arr);

}


fprintf(fp_det,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
/*
fprintf(fp_det,"    %s PERIOD NARRATION                              EPISODE   / PAT NO               CASH CTRL DOC TYPE/DOC NUM/DOC DATE              DEBIT          CREDIT\n",
(nd_rep_order == 1)?"TRX DATE   TRX DOC REF/LINE NUM/SER NUM  ":
    "TRX DOC REF/LINE NUM/SER NUM  TRX DATE   ");
*/

if(nd_rep_order == 1)
{

fprintf(fp_det,"    %-8.8s   %-11.11s/%-8.8s/%-8.8s %-6.6s %-9.9s                              %-7.7s   / %-6.6s               %-18.18s/%-7.7s/%-7.7s              %5.5s          %6.6s\n",
loc_legend[11],loc_legend[12],loc_legend[21],loc_legend[22],
	loc_legend[20],loc_legend[41],loc_legend[23],loc_legend[24],loc_legend[25],loc_legend[26],loc_legend[27],loc_legend[28],loc_legend[29]);

}
else
{

fprintf(fp_det,"    %-11.11s/%-8.8s/%-8.8s  %8.8s %-6.6s %-9.9s                              %-7.7s   / %-6.6s               %-18.18s/%-7.7s/%-7.7s              %5.5s          %6.6s\n",
	loc_legend[12],loc_legend[21],loc_legend[22],loc_legend[11],
	loc_legend[20],loc_legend[41],loc_legend[23],loc_legend[24],loc_legend[25],loc_legend[26],loc_legend[27],loc_legend[28],loc_legend[29]);

}



fprintf(fp_det,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp_det);
lctr1 = 7;
}

print_head2()   /* Heading for Summary */
{
  if (!SUMMARY)
        return;
fprintf(fp_sum,"\fMDL : BL                                            %-40.40s                         %-15.15s\n",
hosp_name.arr,date_time.arr);
fprintf(fp_sum,"OPR : %-30.30s \n", user_id.arr);
fprintf(fp_sum,"REP : %-8s                            %-44.44s                               %-4.4s : %4d\n",
"BLRGLDSU",loc_legend[18],loc_legend[2],++pctr2);

fprintf(fp_sum,"                                                 (%-14.14s %2s/%4s to %2s/%4s)\n",loc_legend[19],
nd_fm_month.arr,nd_fm_year1.arr,
nd_to_month.arr,nd_to_year1.arr);
fprintf(fp_sum,"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp_sum,"%-11.11s & %-11.11s                                                            %5.5s          %6.6s         %7.7s\n",
				loc_legend[30],loc_legend[31],loc_legend[28],loc_legend[29],loc_legend[40]);
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

    /* EXEC SQL SELECT acc_entity_name,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY_LANG_VW
	       WHERE acc_entity_id = :nd_operating_facility_id
		   AND   LANGUAGE_ID = :nd_lang_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 32;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select acc_entity_name ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:\
b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )559;
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

init_date_temp_var();
strcpy(date_convert.arr,date_time.arr);
fun_change_loc_date();
strcpy(date_time.arr,date_convert.arr);

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
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14sCR",out_str1);
   }
  
  

}
*/

print_formated(loc_amount,fp)
double loc_amount;
FILE *fp;
{
	char s_amt[30],str_amt[30];		

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
	ltrim(s_amt);
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        //strcat(s_amt,"-");
        fprintf(fp,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
        ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s ",str_amt);
        }


}
fetch_legend_value()
{

	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRGLDIS.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 32;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRGLDIS.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )594;
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
  sqlstm.arrsiz = 32;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facili\
ty_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_trans\
lated_value , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )617;
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
 sqlstm.arrsiz = 32;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :nd_lang_id , t_\
date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )648;
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
 sqlstm.arrsiz = 32;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :nd_lang_id , t_date ) ;\
 :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )675;
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
 sqlstm.arrsiz = 32;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'YYYY' ) , :nd_lang_id , t_date ) ; :nd_l\
oc_date := to_char ( t_date , 'YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )702;
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