
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
           char  filnam[20];
};
static const struct sqlcxp sqlfpn =
{
    19,
    "C:\\temp\\Glocbacc.pc"
};


static unsigned long sqlctx = 36373763;


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

 static const char *sq0004 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,SUBLEDGER_ENTRY_FLAG ,DEPT_ENTRY_FLAG\
 ,PROD_ENTRY_FLAG ,SUMMARY_ACC_FLAG ,BANK_RECONCILE_FLAG ,SHORT_DESC  from GL_\
ACC_CHART where ((((MAIN_ACC1_CODE||MAIN_ACC2_CODE)>=(NVL(:b0,'      ')||NVL(:\
b1,'    ')) and (MAIN_ACC1_CODE||MAIN_ACC2_CODE)<=(NVL(:b2,'~~~~~~')||NVL(:b3,\
'~~~~'))) and NVL(SUMMARY_ACC_FLAG,'X')<>'Y') and STATUS is null )           ";

 static const char *sq0005 = 
"select distinct DEPT_CODE ,SHORT_DESC  from SY_DEPT where ((DEPT_CODE>=NVL(:\
b0,'      ') and DEPT_CODE<=NVL(:b1,'~~~~~~')) and STATUS is null )           ";

 static const char *sq0006 = 
"select PRODUCT_GROUP_CODE ,SHORT_DESC  from GL_PRODUCT_GROUP where ((PRODUCT\
_GROUP_CODE>=NVL(:b0,'   ') and PRODUCT_GROUP_CODE<=NVL(:b1,'~~~')) and STATUS\
 is null )           ";

 static const char *sq0007 = 
"select PRODUCT_LINE_CODE ,SHORT_DESC  from GL_PRODUCT_LINE where (((PRODUCT_\
GROUP_CODE=:b0 and (PRODUCT_GROUP_CODE||PRODUCT_LINE_CODE)>=(NVL(:b1,'   ')||N\
VL(:b2,'    '))) and (PRODUCT_GROUP_CODE||PRODUCT_LINE_CODE)<=(NVL(:b3,'~~~')|\
|NVL(:b4,'~~~~'))) and STATUS is null )           ";

 static const char *sq0010 = 
"select SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE  from GL_MAIN_SUBLEDGER whe\
re (((MAIN_ACC1_CODE=:b0 and MAIN_ACC2_CODE=:b1) and (SUBLEDGER_GROUP_CODE||SU\
BLEDGER_LINE_CODE)>=(NVL(:b2,'   ')||NVL(:b3,'         '))) and (SUBLEDGER_GRO\
UP_CODE||SUBLEDGER_LINE_CODE)<=(NVL(:b4,'~~~')||NVL(:b5,'~~~~~~~~')))         \
  ";

 static const char *sq0008 = 
"select 'X'  from GL_SUBLEDGER_GROUP where (SUBLEDGER_GROUP_CODE=:b0 and STAT\
US is null )           ";

 static const char *sq0009 = 
"select SHORT_DESC  from GL_SUBLEDGER_LINE where ((SUBLEDGER_GROUP_CODE=:b0 a\
nd SUBLEDGER_LINE_CODE=:b1) and STATUS is null )           ";

 static const char *sq0011 = 
"select DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,DEPT_DESC ,PROD_DES\
C  from GL_COMBINATION_TEMP where (MAIN_ACC1_CODE=:b0 and MAIN_ACC2_CODE=:b1) \
          ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,301,0,4,241,0,0,17,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
88,0,0,2,0,0,29,486,0,0,0,0,0,1,0,
103,0,0,3,0,0,30,493,0,0,0,0,0,1,0,
118,0,0,12,526,0,4,622,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,
2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,3,0,0,2,3,0,0,
205,0,0,13,59,0,4,681,0,0,1,0,0,1,0,2,3,0,0,
224,0,0,4,387,0,9,708,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
255,0,0,4,0,0,13,734,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,
302,0,0,5,154,0,9,763,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
325,0,0,5,0,0,13,778,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
348,0,0,6,175,0,9,797,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
371,0,0,6,0,0,13,806,0,0,1,0,0,1,0,2,9,0,0,
390,0,0,7,282,0,9,822,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
425,0,0,7,0,0,13,835,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
448,0,0,10,312,0,9,867,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
487,0,0,10,0,0,13,881,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
510,0,0,8,99,0,9,898,0,0,1,1,0,1,0,1,9,0,0,
529,0,0,8,0,0,13,908,0,0,1,0,0,1,0,2,9,0,0,
548,0,0,9,135,0,9,918,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
571,0,0,9,0,0,13,930,0,0,1,0,0,1,0,2,9,0,0,
590,0,0,14,228,0,4,983,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
637,0,0,15,644,0,3,1031,0,0,36,36,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,3,0,0,1,3,0,0,
796,0,0,16,0,0,27,1099,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
827,0,0,17,91,0,2,1108,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
850,0,0,18,167,0,3,1125,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
893,0,0,11,164,0,9,1161,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
916,0,0,11,0,0,13,1185,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
951,0,0,19,33,0,2,1215,0,0,0,0,0,1,0,
966,0,0,20,75,0,4,1224,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                    */
/************************************************************************/
/* PROGRAM NAME          : GLOCBACC.PC                                  */
/* AUTHOR                : S. SRIRAM                                     */
/* DATE WRITTEN          : 19-NOV-1992                                  */
/*                                                                      */
/*                                                                      */
/*  CALLED FROM          :                                                */
/*                                                                      */
/*  FUNCTION             :   Creates combination of records in          */
/*                           GL_ACC_COMBINATION                         */
/*                           ( Changed to GL_POSTING_ACC )              */
/*                                                                      */
/*  PROGRAMMED BY        :                                              */
/*                                                                      */
/*  Date                 :   21-NOV-92                                  */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*          1.        GL_POSTING_ACC          Query/Insert              */
/*          2.        GL_ACC_CHART               Lookup                 */
/*          3.        SY_DEPT                    Lookup                 */
/*          4.        GL_PARAMETER               Lookup                 */
/*          5.        GL_PRODUCT_GROUP           Lookup                 */
/*          6.        GL_PRODUCT_LINE            Lookup                 */
/*          7.        GL_MAIN_SUBLEDGER          Lookup                 */
/*          8.        GL_SUBLEDGER_GROUP         Lookup                 */
/*          9.        GL_SUBLEDGER_LINE          Lookup                 */
/*         10.        GL_COMBINATION_TEMP   Insert/Lookup/Delete        */
/*         11.        SY_PROG_MSG                Insert                 */
/*         12.        SY_PROG_CONTROL         Query/Update              */
/*                                                                      */
/*  PARAMETERS           :                                              */
/*                                                                      */
/*      S. No.       Field Names                Default Values          */
/*                                                                      */
/*          1.  MAIN_ACC1_CODE From                Spaces               */
/*          2.  MAIN_ACC1_CODE To                 '~~~~~~'              */
/*          3.  MAIN_ACC2_CODE From                Spaces               */
/*          4.  MAIN_ACC2_CODE To                  '~~~~'               */
/*          5.  DEPT_CODE From                     Spaces               */
/*          6.  DEPT_CODE To                       '~~~~'               */
/*          7.  PRODUCT_GROUP_CODE From            Spaces               */
/*          8.  PRODUCT_GROUP_CODE To               '~~~'               */
/*          9.  PRODUCT_LINE_CODE From             Spaces               */
/*         10.  PRODUCT_LINE_CODE To               '~~~~'               */
/*         11.  SUBLEDGER_GROUP_CODE From          Spaces               */
/*         12.  SUBLEDGER_GROUP_CODE To            '~~~'                */
/*         13.  SUBLEDGER_LINE_CODE From           Spaces               */
/*         14.  SUBLEDGER_LINE_CODE To            '~~~~~~~~'            */
/*                                                                      */
/*                                                                      */
/* DATE MODIFIED         : 14-FEB-1993                                  */
/* CHANGES MADE          : NEW POSTING LOGIC                            */
/*                                                                      */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <string.h>

#include "gl.h" 
#include "bl.h"

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
/*
#define DEBUG 0
*/
#define SL_APPL  (d_subledger_applicable_flag.arr[0] == 'Y')
#define SL_ENTRY (d_subledger_entry_flag.arr[0] == 'Y')

#define DP_APPL  (d_dept_applicable_flag.arr[0] == 'Y')
#define DP_ENTRY (d_dept_entry_flag.arr[0] == 'Y')

#define PR_APPL  (d_prod_grp_applicable_flg.arr[0] == 'Y')
#define PR_ENTRY (d_prod_entry_flag.arr[0] == 'Y')  

#define VIEW_LOG_FILE     1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd[40]; */ 
struct { unsigned short len; unsigned char arr[40]; } uid_pwd;
  
                                                    /* LENGTH */
   /* VARCHAR  nd_session_id                [16],      
            nd_fm_main_acc1_code         [8],       /o   6    o/
            nd_to_main_acc1_code         [8],       /o   6    o/
            nd_fm_main_acc2_code         [6],       /o   4    o/
            nd_to_main_acc2_code         [6],       /o   4    o/
            nd_fm_dept_code              [11],       /o   6    o/
            nd_to_dept_code              [11],       /o   6    o/
            nd_fm_product_group_code     [4],       /o   3    o/
            nd_to_product_group_code     [4],       /o   3    o/
            nd_fm_product_line_code      [6],       /o   4    o/
            nd_to_product_line_code      [6],       /o   4    o/
            nd_fm_subledger_group_code   [4],       /o   3    o/
            nd_to_subledger_group_code   [4],       /o   3    o/
            nd_fm_subledger_line_code    [10],      /o   8    o/
            nd_to_subledger_line_code    [10],      /o   8    o/
 
            d_subledger_applicable_flag  [2],       /o   1    o/
            d_dept_applicable_flag       [2],       /o   1    o/
            d_prod_grp_applicable_flg    [2],    /o   1    o/
            d_main_acc1_code             [8],       /o   6    o/
            d_main_acc2_code             [6],       /o   4    o/
            d_subledger_entry_flag       [2],       /o   1    o/
            d_dept_entry_flag            [2],       /o   1    o/
            d_prod_entry_flag            [2],       /o   1    o/
            d_summary_acc_flag           [2],       /o   1    o/
            d_dept_code                  [11],       /o   6    o/
            d_product_group_code         [4],       /o   3    o/
            d_product_line_code          [6],       /o   4    o/
            d_subledger_group_code       [4],       /o   3    o/
            d_subledger_line_code        [10],      /o   8    o/
	        d_pgm_date                   [14],      /o   12   o/
            dummy                        [10][3],
			d_dummy						 [1], 	
 
            d_acc_flag                   [2],

            d_main_desc                  [16],
            d_dept_desc                  [16],
            d_product_desc               [16],
            d_subledger_desc             [16],
            d_bank_reconcile_flag        [3],
            d_default_dept_code          [11],
            d_default_prod_group_code    [4],
            d_default_prod_line_code     [7],
            d_default_sleg_group_code    [4],
            d_default_sleg_line_code     [9],
            d_default_dept_desc          [16],
            d_default_prod_desc          [16],
            d_default_sleg_desc          [16],
            d_default_delimiter          [3],
			p_facility_id                [3], 
		    p_acc_entity_code            [5],
			nd_acc_entity_code           [4]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[8]; } nd_fm_main_acc1_code;

struct { unsigned short len; unsigned char arr[8]; } nd_to_main_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } nd_fm_main_acc2_code;

struct { unsigned short len; unsigned char arr[6]; } nd_to_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_dept_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_dept_code;

struct { unsigned short len; unsigned char arr[4]; } nd_fm_product_group_code;

struct { unsigned short len; unsigned char arr[4]; } nd_to_product_group_code;

struct { unsigned short len; unsigned char arr[6]; } nd_fm_product_line_code;

struct { unsigned short len; unsigned char arr[6]; } nd_to_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } nd_fm_subledger_group_code;

struct { unsigned short len; unsigned char arr[4]; } nd_to_subledger_group_code;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_subledger_line_code;

struct { unsigned short len; unsigned char arr[10]; } nd_to_subledger_line_code;

struct { unsigned short len; unsigned char arr[2]; } d_subledger_applicable_flag;

struct { unsigned short len; unsigned char arr[2]; } d_dept_applicable_flag;

struct { unsigned short len; unsigned char arr[2]; } d_prod_grp_applicable_flg;

struct { unsigned short len; unsigned char arr[8]; } d_main_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } d_main_acc2_code;

struct { unsigned short len; unsigned char arr[2]; } d_subledger_entry_flag;

struct { unsigned short len; unsigned char arr[2]; } d_dept_entry_flag;

struct { unsigned short len; unsigned char arr[2]; } d_prod_entry_flag;

struct { unsigned short len; unsigned char arr[2]; } d_summary_acc_flag;

struct { unsigned short len; unsigned char arr[11]; } d_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_product_group_code;

struct { unsigned short len; unsigned char arr[6]; } d_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_subledger_group_code;

struct { unsigned short len; unsigned char arr[10]; } d_subledger_line_code;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[6]; } dummy[10];

struct { unsigned short len; unsigned char arr[1]; } d_dummy;

struct { unsigned short len; unsigned char arr[2]; } d_acc_flag;

struct { unsigned short len; unsigned char arr[16]; } d_main_desc;

struct { unsigned short len; unsigned char arr[16]; } d_dept_desc;

struct { unsigned short len; unsigned char arr[16]; } d_product_desc;

struct { unsigned short len; unsigned char arr[16]; } d_subledger_desc;

struct { unsigned short len; unsigned char arr[3]; } d_bank_reconcile_flag;

struct { unsigned short len; unsigned char arr[11]; } d_default_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_default_prod_group_code;

struct { unsigned short len; unsigned char arr[7]; } d_default_prod_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_default_sleg_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_default_sleg_line_code;

struct { unsigned short len; unsigned char arr[16]; } d_default_dept_desc;

struct { unsigned short len; unsigned char arr[16]; } d_default_prod_desc;

struct { unsigned short len; unsigned char arr[16]; } d_default_sleg_desc;

struct { unsigned short len; unsigned char arr[3]; } d_default_delimiter;

struct { unsigned short len; unsigned char arr[3]; } p_facility_id;

struct { unsigned short len; unsigned char arr[5]; } p_acc_entity_code;

struct { unsigned short len; unsigned char arr[4]; } nd_acc_entity_code;


      int   d_dept_length,
            d_prod_group_length,
            d_prod_line_length,
            d_subl_group_length,
            d_subl_line_length,
            d_post_month,
            d_post_year;

      int   nd_count ;

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

int fetch_acc_chart(),
    fetch_dept(),
    fetch_product_group(),
    fetch_product_line(),
    fetch_main_subledger(),
    fetch_combination_temp(),
    fetch_dept(),
    sql_connect();

long fetch_subledger_group(),
     fetch_subledger_line();
     

void declare_cursors(),
     fetch_param(),
     open_acc_chart_cur(),
     open_dept_cur(),
     open_product_group(),
     open_product_line(),
     open_subledger_group(),
     open_subledger_line(),
     create_posting_acc(),
     start_prog_msg(),
     start_prog_control(),
     end_prog_control(),
     open_main_subledger(),
     create_gl_comb_temp(),
     open_combination_temp(),
     delete_comb_temp(),
     del_param();

void chk_active();
void start_prog_msg();
void start_prog_control();
void end_prog_msg();
void end_prog_control();
void err_mesg(char *, int, char *);
int  get_message(char *, char *);


int  eof_dept,
     eof_product,
     ins_comb,
     dept_ctr;
     
void proc_main(argc,argv)
char *argv[];
int argc;
{
   
   if (argc != 5)
   {
      disp_message ( ERR_MESG, "Usage glocbacc uid/passwd session_id pgm_date facility_id");
      proc_exit();
   }


   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);
   strcpy(g_pgm_id,"GLOCBACC");

   strcpy(d_pgm_date.arr,argv[3]);
   d_pgm_date.len = strlen(d_pgm_date.arr);
   strcpy(g_pgm_date,argv[3]);

   if(sql_connect() == -1)
   {
      disp_message (ERR_MESG, "Error in connecting to Oracle");
      if (uid_pwd.len == 0)
         disp_message (ERR_MESG, "Null oracle uid/pwd");
      proc_exit();
   }

 

    set_meduser_role();
 chk_active();

   /* EXEC SQL SELECT OPERATING_FACILITY_ID , PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,
                   PARAM7,PARAM8,PARAM9,PARAM10,PARAM11,PARAM12,
                   PARAM13,PARAM14 
              INTO :p_facility_id,
			       :nd_fm_main_acc1_code,
                   :nd_fm_main_acc2_code,
                   :nd_to_main_acc1_code,
                   :nd_to_main_acc2_code,
                   :nd_fm_dept_code,
                   :nd_to_dept_code,
                   :nd_fm_product_group_code,
                   :nd_fm_product_line_code,
                   :nd_to_product_group_code,
                   :nd_to_product_line_code,
                   :nd_fm_subledger_group_code,
                   :nd_fm_subledger_line_code,
                   :nd_to_subledger_group_code,
                   :nd_to_subledger_line_code 
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'GLOCBACC' 
               AND SESSION_ID = :nd_session_id 
	       AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13\
 ,PARAM14 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b1\
4  from SY_PROG_PARAM where ((PGM_ID='GLOCBACC' and SESSION_ID=:b15) and PGM_D\
ATE=:b16)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&p_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_main_acc1_code;
   sqlstm.sqhstl[1] = (unsigned int  )10;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_main_acc2_code;
   sqlstm.sqhstl[2] = (unsigned int  )8;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_main_acc1_code;
   sqlstm.sqhstl[3] = (unsigned int  )10;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_main_acc2_code;
   sqlstm.sqhstl[4] = (unsigned int  )8;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_dept_code;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_dept_code;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_product_group_code;
   sqlstm.sqhstl[7] = (unsigned int  )6;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_product_line_code;
   sqlstm.sqhstl[8] = (unsigned int  )8;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_product_group_code;
   sqlstm.sqhstl[9] = (unsigned int  )6;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_product_line_code;
   sqlstm.sqhstl[10] = (unsigned int  )8;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_fm_subledger_group_code;
   sqlstm.sqhstl[11] = (unsigned int  )6;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_fm_subledger_line_code;
   sqlstm.sqhstl[12] = (unsigned int  )12;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_to_subledger_group_code;
   sqlstm.sqhstl[13] = (unsigned int  )6;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_to_subledger_line_code;
   sqlstm.sqhstl[14] = (unsigned int  )12;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[15] = (unsigned int  )18;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[16] = (unsigned int  )16;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
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



  

    if (OERROR) err_mesg("Error while Fetching the Parameters",0,"");

    if (NOT_FOUND) 
    {
      char err_msg[68];
      sprintf (err_msg, "Session_id <%s> & Pgm_id GLOCBACC\n",nd_session_id.arr);
      disp_message (ERR_MESG, err_msg);
      err_mesg("Record not existing in Parameter Table\n",0,"");
    } 

 nd_fm_main_acc1_code.arr[nd_fm_main_acc1_code.len]             = '\0';
 nd_to_main_acc1_code.arr[nd_to_main_acc1_code.len]             = '\0';
 nd_fm_main_acc2_code.arr[nd_fm_main_acc2_code.len]             = '\0';
 nd_to_main_acc2_code.arr[nd_to_main_acc2_code.len]             = '\0';
 nd_fm_dept_code.arr[nd_fm_dept_code.len]                       = '\0';
 nd_to_dept_code.arr[nd_to_dept_code.len]                       = '\0';
 nd_fm_product_group_code.arr[nd_fm_product_group_code.len]     = '\0';
 nd_to_product_group_code.arr[nd_to_product_group_code.len]     = '\0';
 nd_fm_product_line_code.arr[nd_fm_product_line_code.len]       = '\0';
 nd_to_product_line_code.arr[nd_to_product_line_code.len]     = '\0';
 nd_fm_subledger_group_code.arr[nd_fm_subledger_group_code.len] = '\0';
 nd_to_subledger_group_code.arr[nd_to_subledger_group_code.len] = '\0';
 nd_fm_subledger_line_code.arr[nd_fm_subledger_line_code.len]   = '\0';
 nd_to_subledger_line_code.arr[nd_to_subledger_line_code.len]   = '\0';

/*

#ifdef DEBUG

   printf("acc1 fr is <%s>\n",nd_fm_main_acc1_code.arr);
   printf("acc1 to is <%s>\n",nd_to_main_acc1_code.arr);
   printf("acc2 fr is <%s>\n",nd_fm_main_acc2_code.arr);
   printf("acc2 to is <%s>\n",nd_to_main_acc2_code.arr);
   printf("dept fr is <%s>\n",nd_fm_dept_code.arr);
   printf("dept to is <%s>\n",nd_to_dept_code.arr);
   printf("prod grp fr is <%s>\n",nd_fm_product_group_code.arr);
   printf("prod grp to is <%s>\n",nd_to_product_group_code.arr);
   printf("prod line fr is <%s>\n",nd_fm_product_line_code.arr);
   printf("prod line to is <%s>\n",nd_to_product_line_code.arr);
   printf("subledger gr fr is <%s>\n",nd_fm_subledger_group_code.arr);
   printf("subledger gr to is <%s>\n",nd_to_subledger_group_code.arr);
   printf("subledger ln fr is <%s>\n",nd_fm_subledger_line_code.arr);
   printf("subledger ln to is <%s>\n",nd_to_subledger_line_code.arr);

#endif
*/


      


   fetch_acc_entity();



   start_prog_control();
   start_prog_msg();
   fetch_param();
   declare_cursors();

   open_acc_chart_cur();

/*
#ifdef DEBUG
  printf("After opening cursor\n");
#endif
*/

   while (fetch_acc_chart())
   {
/*
#ifdef DEBUG
  printf("After fetching Main acc <%s> - <%s>\n",d_main_acc1_code.arr,
                  d_main_acc2_code.arr);
#endif
*/
       eof_dept = eof_product = ins_comb = 1;
       dept_ctr = 0;
       if ((!DP_APPL) || (!DP_ENTRY)) 
           eof_dept = 0;
       else
           open_dept_cur();
/*
#ifdef DEBUG
   printf("Dept entry flag is <%s> Prod ent is <%s> subl entry is <%s>\n",
       d_dept_entry_flag.arr,d_prod_entry_flag.arr,d_subledger_entry_flag.arr);
#endif
*/

      if ((d_dept_entry_flag.arr[0] == 'N') && 
          (d_prod_entry_flag.arr[0] == 'N') &&
          (d_subledger_entry_flag.arr[0] == 'N'))
      {
/*
#ifdef DEBUG
    printf("DEPT & PROD & SL ENTRY FLAG is 'N'\n");
#endif
*/
           strcpy(d_dept_code.arr,"");
           d_dept_code.len = strlen(d_dept_code.arr);
           strcpy(d_product_group_code.arr,"");
           d_product_group_code.len = strlen(d_product_group_code.arr);
           strcpy(d_product_line_code.arr,"");
           d_product_line_code.len = strlen(d_product_line_code.arr);
           strcpy(d_subledger_group_code.arr,"");
           d_subledger_group_code.len = strlen(d_subledger_group_code.arr);
           strcpy(d_subledger_line_code.arr,"");
           d_subledger_line_code.len = strlen(d_subledger_line_code.arr);
           create_posting_acc();
           ins_comb = 0;
       }
       else
       {
          if ((d_dept_entry_flag.arr[0] == 'Y') || 
              (d_prod_entry_flag.arr[0] == 'Y')) 
          {
              strcpy(d_subledger_group_code.arr,"");
              d_subledger_group_code.len = 0;
              strcpy(d_subledger_line_code.arr,"");
              d_subledger_line_code.len = 0;

              while (eof_dept != 0 || eof_product != 0)
              {
                if (eof_dept)
                {
                     eof_dept = fetch_dept();
                     dept_ctr ++;
                }
/*
#ifdef DEBUG
    printf("eof_dept is <%d> dept_ctr is <%d>\n",eof_dept,dept_ctr);
#endif
*/
                if ((!eof_dept) && dept_ctr > 1) break;
 
                if ((!PR_APPL) || (!PR_ENTRY))
                    eof_product = 0;
                else
                {
                    open_product_group();
                    while ((eof_product = fetch_product_group()) != 0)
                    {
                        open_product_line();
                        while (fetch_product_line())
                        {
                             if (!SL_ENTRY)
                                 create_posting_acc();
                             else
                                 create_gl_comb_temp();
                           ins_comb = 0;
                        }
                     }
                 }
/*
#ifdef DEBUG
    printf("ins comb is <%d> eof_dept is <%d>\n",ins_comb,eof_dept);
#endif
*/
                 if ((d_dept_entry_flag.arr[0] == 'Y') || 
                      (d_prod_entry_flag.arr[0] == 'Y'))
                 {
/*
#ifdef DEBUG
  printf("Insert for dept only...\n");
#endif
*/
                     if (ins_comb && eof_dept)
                     {
                         strcpy(d_product_group_code.arr,"");
                         d_product_group_code.len = 0;
                         strcpy(d_product_line_code.arr,"");
                         d_product_line_code.len = 0;
                         if (!SL_ENTRY)
                            create_posting_acc();
                         else
                            create_gl_comb_temp();
                     }
                 }
              }
          }
          if (SL_APPL && SL_ENTRY)
          {
/*
#ifdef DEBUG
   printf("Creating recs for SL\n");
#endif
*/
              strcpy(d_dept_code.arr,"");
              d_dept_code.len = strlen(d_dept_code.arr);
              strcpy(d_product_group_code.arr,"");
              d_product_group_code.len = strlen(d_product_group_code.arr);
              strcpy(d_product_line_code.arr,"");
              d_product_line_code.len = strlen(d_product_line_code.arr);
    
              open_main_subledger();
              while (fetch_main_subledger())
              {
                     if (fetch_subledger_group() == 0  ||
                             fetch_subledger_line() == 0)
                          continue;       /* Subl Group / Line is suspended */

                  if (PR_ENTRY || DP_ENTRY)
                  {
/*
#ifdef DEBUG
     printf("Before open comb temp\n");
#endif 
*/
                      open_combination_temp();
                      while (fetch_combination_temp())
                         create_posting_acc();
                  }
                  else
                       create_posting_acc();
              }
          }
       }
       
       delete_comb_temp();

       /* EXEC SQL COMMIT WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 17;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )88;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



       if (OERROR) err_mesg("Error while Commiting...\n",0,"");
    }
    end_prog_msg();
    end_prog_control();
    del_param();
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )103;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return;
}
 
void declare_cursors()
{

    /* EXEC SQL DECLARE   GL_ACC_CHART_CUR CURSOR FOR
              SELECT   MAIN_ACC1_CODE,
                       MAIN_ACC2_CODE,
                       SUBLEDGER_ENTRY_FLAG,
                       DEPT_ENTRY_FLAG,
                       PROD_ENTRY_FLAG,
                       SUMMARY_ACC_FLAG,
                       BANK_RECONCILE_FLAG,
                       SHORT_DESC
                FROM   GL_ACC_CHART
               WHERE   MAIN_ACC1_CODE||MAIN_ACC2_CODE >= 
                               NVL(:nd_fm_main_acc1_code,'      ')||
                               NVL(:nd_fm_main_acc2_code,'    ')
                 AND   MAIN_ACC1_CODE||MAIN_ACC2_CODE <= 
                               NVL(:nd_to_main_acc1_code,'~~~~~~')||
                               NVL(:nd_to_main_acc2_code,'~~~~')
                 AND   NVL(SUMMARY_ACC_FLAG,'X')  != 'Y'
                 AND   STATUS IS NULL; */ 


    /* EXEC SQL DECLARE   SY_DEPT_CUR CURSOR FOR
              SELECT   DISTINCT DEPT_CODE, SHORT_DESC
                FROM   SY_DEPT
               WHERE   DEPT_CODE >= NVL(:nd_fm_dept_code,'      ')
                 AND   DEPT_CODE <= NVL(:nd_to_dept_code,'~~~~~~')
                 AND   STATUS IS NULL; */ 


    /* EXEC SQL DECLARE   GL_PRODUCT_GROUP_CUR CURSOR FOR
              SELECT   PRODUCT_GROUP_CODE, SHORT_DESC
                FROM   GL_PRODUCT_GROUP
               WHERE   PRODUCT_GROUP_CODE >=
                              NVL(:nd_fm_product_group_code,'   ')
                 AND   PRODUCT_GROUP_CODE <=
                              NVL(:nd_to_product_group_code,'~~~')
                 AND   STATUS IS NULL; */ 


    /* EXEC SQL DECLARE   GL_PRODUCT_LINE_CUR CURSOR FOR
              SELECT   PRODUCT_LINE_CODE, SHORT_DESC
                FROM   GL_PRODUCT_LINE
               WHERE   PRODUCT_GROUP_CODE = :d_product_group_code
                 AND   PRODUCT_GROUP_CODE||PRODUCT_LINE_CODE >=
                              NVL(:nd_fm_product_group_code,'   ')||
                              NVL(:nd_fm_product_line_code,'    ')
                 AND   PRODUCT_GROUP_CODE||PRODUCT_LINE_CODE <=
                              NVL(:nd_to_product_group_code,'~~~')||
                              NVL(:nd_to_product_line_code,'~~~~')
                 AND   STATUS IS NULL; */ 


    /* EXEC SQL DECLARE   GL_SUBLEDGER_GROUP_CUR CURSOR FOR
              SELECT   'X'
                FROM   GL_SUBLEDGER_GROUP
               WHERE   SUBLEDGER_GROUP_CODE = :d_subledger_group_code
                 AND   STATUS IS NULL; */ 


    /* EXEC SQL DECLARE   GL_SUBLEDGER_LINE_CUR CURSOR FOR
              SELECT   SHORT_DESC
                FROM   GL_SUBLEDGER_LINE
               WHERE   SUBLEDGER_GROUP_CODE = :d_subledger_group_code
                 AND   SUBLEDGER_LINE_CODE  = :d_subledger_line_code
                 AND   STATUS IS NULL; */ 


     /* EXEC SQL DECLARE  GL_MAIN_SUBLEDGER_CUR CURSOR FOR
               SELECT  SUBLEDGER_GROUP_CODE,
                       SUBLEDGER_LINE_CODE
                 FROM  GL_MAIN_SUBLEDGER
                WHERE  MAIN_ACC1_CODE = :d_main_acc1_code
                  AND  MAIN_ACC2_CODE = :d_main_acc2_code
                  AND  SUBLEDGER_GROUP_CODE ||SUBLEDGER_LINE_CODE >=
                       NVL(:nd_fm_subledger_group_code,'   ')||
                       NVL(:nd_fm_subledger_line_code,'         ')
                  AND  SUBLEDGER_GROUP_CODE || SUBLEDGER_LINE_CODE <=
                       NVL(:nd_to_subledger_group_code,'~~~')||
                       NVL(:nd_to_subledger_line_code,'~~~~~~~~'); */ 


     /* EXEC SQL DECLARE  GL_COMBINATION_TEMP_CUR CURSOR FOR
               SELECT  DEPT_CODE,
                       PRODUCT_GROUP_CODE,
                       PRODUCT_LINE_CODE,
                       DEPT_DESC,
                       PROD_DESC
                 FROM  GL_COMBINATION_TEMP
                WHERE  MAIN_ACC1_CODE = :d_main_acc1_code
                  AND  MAIN_ACC2_CODE = :d_main_acc2_code; */ 

}

void fetch_param()
{

  d_prod_group_length              = 0;
  d_prod_line_length               = 0;
  d_subl_group_length              = 0;
  d_subl_line_length               = 0;
  d_post_month                     = 0;
  d_post_year                      = 0;

  d_dept_applicable_flag.arr[0]          ='\0';
  d_prod_grp_applicable_flg.arr[0] = '\0';
  d_subledger_applicable_flag.arr[0]     = '\0';

  d_default_dept_code.arr[0]             = '\0';
  d_default_prod_group_code.arr[0]       = '\0';
  d_default_prod_line_code.arr[0]        = '\0';
  d_default_sleg_group_code.arr[0]       = '\0';
  d_default_sleg_line_code.arr[0]        = '\0';
  d_default_dept_desc.arr[0]             = '\0';
  d_default_prod_desc.arr[0]             = '\0';
  d_default_sleg_desc.arr[0]             = '\0';
  d_default_delimiter.arr[0]             = '\0';

  d_subledger_applicable_flag.len        = 0;
  d_prod_grp_applicable_flg.len    = 0;
  d_dept_applicable_flag.len             = 0;

  d_default_dept_code.len                = 0;
  d_default_prod_group_code.len          = 0;
  d_default_prod_line_code.len           = 0;
  d_default_sleg_group_code.len          = 0;
  d_default_sleg_line_code.len           = 0;
  d_default_dept_desc.len                = 0;
  d_default_prod_desc.len                = 0;
  d_default_sleg_desc.len                = 0;
  d_default_delimiter.len                = 0;

   /* EXEC SQL SELECT   SUBLEDGER_APPLICABLE_FLAG,
                     DEPT_APPLICABLE_FLAG,
                     PRODUCT_GROUP_APPLICABLE_FLAG,
                     PRODUCT_GROUP_CODE_LNGTH,
                     PRODUCT_LINE_CODE_LNGTH,
                     SUBLEDGER_GROUP_CODE_LNGTH,
                     SUBLEDGER_LINE_CODE_LNGTH,
                     DEFAULT_DEPT_CODE,
                     DEFAULT_PROD_GROUP_CODE,
                     DEFAULT_PROD_LINE_CODE,
                     DEFAULT_SLEG_GROUP_CODE,
                     DEFAULT_SLEG_LINE_CODE,
                     DEFAULT_DEPT_DESC,
                     DEFAULT_PROD_DESC,
                     DEFAULT_SLEG_DESC,
                     DEFAULT_DELIMITER,
                     CURRENT_ACC_MONTH,
                     CURRENT_ACC_YEAR
              INTO
                     :d_subledger_applicable_flag,
                     :d_dept_applicable_flag,
                     :d_prod_grp_applicable_flg,
                     :d_prod_group_length,
                     :d_prod_line_length,
                     :d_subl_group_length,
                     :d_subl_line_length,
                     :d_default_dept_code,
                     :d_default_prod_group_code,
                     :d_default_prod_line_code,
                     :d_default_sleg_group_code,
                     :d_default_sleg_line_code,
                     :d_default_dept_desc,
                     :d_default_prod_desc,
                     :d_default_sleg_desc,
                     :d_default_delimiter,
                     :d_post_month,
                     :d_post_year
              FROM   GL_PARAMETER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBLEDGER_APPLICABLE_FLAG ,DEPT_APPLICABLE_FLAG ,PR\
ODUCT_GROUP_APPLICABLE_FLAG ,PRODUCT_GROUP_CODE_LNGTH ,PRODUCT_LINE_CODE_LNGTH\
 ,SUBLEDGER_GROUP_CODE_LNGTH ,SUBLEDGER_LINE_CODE_LNGTH ,DEFAULT_DEPT_CODE ,DE\
FAULT_PROD_GROUP_CODE ,DEFAULT_PROD_LINE_CODE ,DEFAULT_SLEG_GROUP_CODE ,DEFAUL\
T_SLEG_LINE_CODE ,DEFAULT_DEPT_DESC ,DEFAULT_PROD_DESC ,DEFAULT_SLEG_DESC ,DEF\
AULT_DELIMITER ,CURRENT_ACC_MONTH ,CURRENT_ACC_YEAR into :b0,:b1,:b2,:b3,:b4,:\
b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17  from GL_PARAMETER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )118;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_subledger_applicable_flag;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_dept_applicable_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_prod_grp_applicable_flg;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_prod_group_length;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_prod_line_length;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_subl_group_length;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_subl_line_length;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_default_dept_code;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_default_prod_group_code;
   sqlstm.sqhstl[8] = (unsigned int  )6;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_default_prod_line_code;
   sqlstm.sqhstl[9] = (unsigned int  )9;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_default_sleg_group_code;
   sqlstm.sqhstl[10] = (unsigned int  )6;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_default_sleg_line_code;
   sqlstm.sqhstl[11] = (unsigned int  )11;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_default_dept_desc;
   sqlstm.sqhstl[12] = (unsigned int  )18;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_default_prod_desc;
   sqlstm.sqhstl[13] = (unsigned int  )18;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_default_sleg_desc;
   sqlstm.sqhstl[14] = (unsigned int  )18;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_default_delimiter;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_post_month;
   sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_post_year;
   sqlstm.sqhstl[17] = (unsigned int  )sizeof(int);
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



    if (OERROR) err_mesg("Error while Fetching Parameters..",0,"");

d_dept_applicable_flag.arr[d_dept_applicable_flag.len]                   = '\0';
d_prod_grp_applicable_flg.arr[d_prod_grp_applicable_flg.len] = '\0';
d_subledger_applicable_flag.arr[d_subledger_applicable_flag.len]         = '\0';

d_default_prod_group_code.arr[d_default_prod_group_code.len] = '\0';
d_default_prod_line_code.arr[d_default_prod_line_code.len]   = '\0';
d_default_sleg_group_code.arr[d_default_sleg_group_code.len] = '\0';
d_default_sleg_line_code.arr[d_default_sleg_line_code.len]   = '\0';
d_default_dept_desc.arr[d_default_dept_desc.len]             = '\0';
d_default_prod_desc.arr[d_default_prod_desc.len]             = '\0';
d_default_sleg_desc.arr[d_default_sleg_desc.len]             = '\0';
d_default_delimiter.arr[d_default_delimiter.len]             = '\0';

    if (NOT_FOUND)
    {
       err_mesg("No Record Exists in GL_PARAMETER",0,"");
    }

   /* EXEC SQL SELECT   DEPT_CODE_LENGTH
              INTO   :d_dept_length
              FROM   SM_ACC_ENTITY_PARAM; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DEPT_CODE_LENGTH into :b0  from SM_ACC_ENTITY_PARAM\
 ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )205;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_dept_length;
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



    if (OERROR) err_mesg("Error while Fetching Parameters..-SM_ACC_ENTITY_PARAM",0,"");

    if (NOT_FOUND)
    {
       err_mesg("No Record Exists in SM_ACC_ENTITY_PARAM",0,"");
    }

   if (!DP_APPL)
       d_dept_length   = 6; 
   if (!SL_APPL)
   {
      d_subl_group_length = 3;
      d_subl_line_length  = 8;
   }
   if (!PR_APPL)
   {
      d_prod_group_length = 3;
      d_prod_line_length  = 4;
   }
}

void open_acc_chart_cur()
{
    /* EXEC SQL OPEN GL_ACC_CHART_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )224;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_main_acc1_code;
    sqlstm.sqhstl[2] = (unsigned int  )10;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_main_acc2_code;
    sqlstm.sqhstl[3] = (unsigned int  )8;
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


    if (OERROR) err_mesg("Error while opening GL_ACC_CHART_CURSOR..",0,"");
}

int fetch_acc_chart()
{
 
    d_main_acc1_code.arr[0]       = '\0';
    d_main_acc2_code.arr[0]       = '\0';
    d_subledger_entry_flag.arr[0] = '\0';
    d_dept_entry_flag.arr[0]      = '\0';
    d_prod_entry_flag.arr[0]      = '\0';
    d_summary_acc_flag.arr[0]     = '\0';
    d_bank_reconcile_flag.arr[0]  = '\0';
    d_main_desc.arr[0]            = '\0';

    d_main_acc1_code.len          = 0;
    d_main_acc2_code.len          = 0;
    d_subledger_entry_flag.len    = 0;
    d_dept_entry_flag.len         = 0;
    d_prod_entry_flag.len         = 0;
    d_summary_acc_flag.len        = 0;

    d_bank_reconcile_flag.len     = 0;
    d_main_desc.len               = 0;

    /* EXEC SQL FETCH   GL_ACC_CHART_CUR
              INTO   :d_main_acc1_code,
                     :d_main_acc2_code,
                     :d_subledger_entry_flag,
                     :d_dept_entry_flag,
                     :d_prod_entry_flag,
                     :d_summary_acc_flag,
                     :d_bank_reconcile_flag,
                     :d_main_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )255;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_subledger_entry_flag;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_dept_entry_flag;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_prod_entry_flag;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_summary_acc_flag;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_bank_reconcile_flag;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_main_desc;
    sqlstm.sqhstl[7] = (unsigned int  )18;
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



    if (OERROR) err_mesg("Error while Fetching GL_ACC_CHART_CURSOR..",0,"");

    d_main_acc1_code.arr[d_main_acc1_code.len]             = '\0';
    d_main_acc2_code.arr[d_main_acc2_code.len]             = '\0';
    d_subledger_entry_flag.arr[d_subledger_entry_flag.len] = '\0';
    d_dept_entry_flag.arr[d_dept_entry_flag.len]           = '\0';
    d_prod_entry_flag.arr[d_prod_entry_flag.len]           = '\0';
    d_summary_acc_flag.arr[d_summary_acc_flag.len]         = '\0';
    d_bank_reconcile_flag.arr[d_bank_reconcile_flag.len]   = '\0';
    d_main_desc.arr[d_main_desc.len]                       = '\0';
 
    if (LAST_ROW)
        return (0);
    else
        return (1);
}

void open_dept_cur()
{
    /* EXEC SQL OPEN SY_DEPT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )302;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_dept_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_dept_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
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


    if (OERROR) err_mesg("Error while opening SY_DEPT_CUR..",0,"");
}

int fetch_dept()
{
    if (eof_dept == 0)
        return 0;
  
    d_dept_code.arr[0] = '\0';
    d_dept_desc.arr[0] = '\0';
    d_dept_code.len    = 0;
    d_dept_desc.len    = 0;


    /* EXEC SQL FETCH SY_DEPT_CUR
              INTO :d_dept_code,
                   :d_dept_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )325;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_dept_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_dept_desc;
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




    if (OERROR) err_mesg("Error while Fetching SY_DEPT_CUR..",0,"");

    d_dept_code.arr[d_dept_code.len] = '\0';
    d_dept_desc.arr[d_dept_desc.len] = '\0';

    if (LAST_ROW)
        return(0);
    else
        return(1);
}

void open_product_group()
{

    /* EXEC SQL OPEN GL_PRODUCT_GROUP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )348;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_product_group_code;
    sqlstm.sqhstl[0] = (unsigned int  )6;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_product_group_code;
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


    if (OERROR) err_mesg("Error while opening GL_PRODUCT_GROUP_CUR",0,"");
}

int fetch_product_group()
{
    d_product_group_code.arr[0] = '\0';
    d_product_group_code.len    = 0;

    /* EXEC SQL FETCH   GL_PRODUCT_GROUP_CUR
              INTO   :d_product_group_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )371;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_product_group_code;
    sqlstm.sqhstl[0] = (unsigned int  )6;
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



    if (OERROR) err_mesg("Error while fetching GL_PRODUCT_GROUP_CUR",0,"");
  
    d_product_group_code.arr[d_product_group_code.len] = '\0';

    if (LAST_ROW)
       return(0);
    else 
       return(1); 
}


void open_product_line()
{
   /* EXEC SQL OPEN GL_PRODUCT_LINE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )390;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_product_group_code;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_product_group_code;
   sqlstm.sqhstl[1] = (unsigned int  )6;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_product_line_code;
   sqlstm.sqhstl[2] = (unsigned int  )8;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_product_group_code;
   sqlstm.sqhstl[3] = (unsigned int  )6;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_product_line_code;
   sqlstm.sqhstl[4] = (unsigned int  )8;
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



   if (OERROR) err_mesg("Error while opening GL_PRODUCT_LINE_CUR",0,"");
}

int fetch_product_line()
{
    d_product_line_code.arr[0]  = '\0';
    d_product_desc.arr[0]       = '\0';

    d_product_line_code.len     = 0;
    d_product_desc.len          = 0;

    /* EXEC SQL FETCH   GL_PRODUCT_LINE_CUR
              INTO   :d_product_line_code,
                     :d_product_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )425;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_product_line_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_product_desc;
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



   if (OERROR) err_mesg("Error while fetching GL_PRODUCT_LINE_CUR",0,"");

   d_product_line_code.arr[d_product_line_code.len]  = '\0';
   d_product_desc.arr[d_product_desc.len]            = '\0';
   
   if (LAST_ROW)
      return(0);
   else 
      return(1); 
}
void open_main_subledger()
{
/*
#ifdef DEBUG
   printf("Inside open main_subl\n");
   printf("main - <%s><%d>   <%s><%d>\n",
                  d_main_acc1_code.arr,d_main_acc1_code.len,
                  d_main_acc2_code.arr,d_main_acc2_code.len);
   printf(" nd fm sl is <%s><%d> - <%s><%d>\n",
                  nd_fm_subledger_group_code.arr,nd_fm_subledger_group_code.len,
                  nd_fm_subledger_line_code.arr,nd_fm_subledger_line_code.len);

   printf(" nd to sl is <%s><%d> - <%s><%d>\n",
                  nd_to_subledger_group_code.arr,nd_to_subledger_group_code.len,
                  nd_to_subledger_line_code.arr,nd_to_subledger_line_code.len);
#endif
*/

     /* EXEC SQL OPEN GL_MAIN_SUBLEDGER_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0010;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )448;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )10;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )8;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fm_subledger_group_code;
     sqlstm.sqhstl[2] = (unsigned int  )6;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_fm_subledger_line_code;
     sqlstm.sqhstl[3] = (unsigned int  )12;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_to_subledger_group_code;
     sqlstm.sqhstl[4] = (unsigned int  )6;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_subledger_line_code;
     sqlstm.sqhstl[5] = (unsigned int  )12;
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
         err_mesg("OPEN failed on cursor GL_MAIN_SUBLEDGER_CUR",0,"");
}

int fetch_main_subledger()
{
    d_subledger_group_code.arr[0] = '\0';
    d_subledger_line_code.arr[0]  = '\0';

    d_subledger_group_code.len    = 0;
    d_subledger_line_code.len     = 0;

    /* EXEC SQL FETCH   GL_MAIN_SUBLEDGER_CUR
              INTO   :d_subledger_group_code,
                     :d_subledger_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )487;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_subledger_group_code;
    sqlstm.sqhstl[0] = (unsigned int  )6;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_subledger_line_code;
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



    if (OERROR) err_mesg("Error while fetching GL_MAIN_SUBLEDGER_CUR",0,"");
  
    d_subledger_group_code.arr[d_subledger_group_code.len] = '\0';
    d_subledger_line_code.arr[d_subledger_line_code.len]   = '\0';

    if (LAST_ROW)
       return(0);
    else 
       return(1); 
}

void open_subledger_group()
{
   /* EXEC SQL OPEN GL_SUBLEDGER_GROUP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )510;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_subledger_group_code;
   sqlstm.sqhstl[0] = (unsigned int  )6;
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



   if (OERROR) err_mesg("Error while opening GL_SUBLEDGER_GROUP_CUR",0,"");
}


long fetch_subledger_group()
{
    open_subledger_group();

    /* EXEC SQL FETCH   GL_SUBLEDGER_GROUP_CUR
              INTO   :dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )10;
    sqlstm.offset = (unsigned int  )529;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)dummy;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )8;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqharc[0] = (unsigned int   *)0;
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



    if (OERROR) err_mesg("Error while fetching GL_SUBLEDGER_GROUP_CUR",0,"");
  
    return(sqlca.sqlerrd[2]);
}

void open_subledger_line()
{
   /* EXEC SQL OPEN GL_SUBLEDGER_LINE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )548;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_subledger_group_code;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_subledger_line_code;
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



   if (OERROR) err_mesg("Error while opening GL_SUBLEDGER_LINE_CUR",0,"");
}

long  fetch_subledger_line()
{
    open_subledger_line();

    d_subledger_desc.arr[0]       = '\0';
    d_subledger_desc.len          = 0;

    /* EXEC SQL FETCH   GL_SUBLEDGER_LINE_CUR
              INTO   :d_subledger_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )571;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_subledger_desc;
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



   if (OERROR) err_mesg("Error while fetching GL_SUBLEDGER_LINE_CUR",0,"");

   d_subledger_desc.arr[d_subledger_desc.len]  = '\0';
   
   return(sqlca.sqlerrd[2]);
}

void create_posting_acc()
{
   if (d_dept_code.arr[0] == '\0')
   {
       strcpy(d_dept_code.arr,d_default_dept_code.arr);
       d_dept_code.len = strlen(d_dept_code.arr);
   }

   if (d_subledger_group_code.arr[0] == '\0')
   {
       strcpy(d_subledger_group_code.arr,d_default_sleg_group_code.arr);
       d_subledger_group_code.len = strlen(d_subledger_group_code.arr);

       strcpy(d_subledger_line_code.arr,d_default_sleg_line_code.arr);
       d_subledger_line_code.len = strlen(d_subledger_line_code.arr);
   }

   if (d_product_group_code.arr[0] == '\0')
   {
       strcpy(d_product_group_code.arr,d_default_prod_group_code.arr);
       d_product_group_code.len = strlen(d_product_group_code.arr);

       strcpy(d_product_line_code.arr,d_default_prod_line_code.arr);
       d_product_line_code.len = strlen(d_product_line_code.arr);
   }


  if (d_dept_desc.len == 0)
  {
      strcpy(d_dept_desc.arr,d_default_dept_desc.arr);
      d_dept_desc.len = strlen(d_dept_desc.arr);
  }
  if (d_product_desc.len == 0)
  {
      strcpy(d_product_desc.arr,d_default_prod_desc.arr);
      d_product_desc.len = strlen(d_product_desc.arr);
  }
  if (d_subledger_desc.len == 0)
  {
      strcpy(d_subledger_desc.arr,d_default_sleg_desc.arr);
      d_subledger_desc.len = strlen(d_subledger_desc.arr);
  }

   /* EXEC SQL SELECT  'X' 
			  INTO  :d_dummy
              FROM  GL_POSTING_ACC
             WHERE  MAIN_ACC1_CODE       = :d_main_acc1_code
               AND  MAIN_ACC2_CODE       = :d_main_acc2_code
               AND  DEPT_CODE            = :d_dept_code
               AND  PRODUCT_GROUP_CODE   = :d_product_group_code
               AND  PRODUCT_LINE_CODE    = :d_product_line_code
               AND  SUBLEDGER_GROUP_CODE = :d_subledger_group_code 
               AND  SUBLEDGER_LINE_CODE  = :d_subledger_line_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select 'X' into :b0  from GL_POSTING_ACC where ((((((MAIN_\
ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and PRODUCT_GROUP_COD\
E=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:b6) and SUBLEDGER_\
LINE_CODE=:b7)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )590;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )3;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_main_acc1_code;
   sqlstm.sqhstl[1] = (unsigned int  )10;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_main_acc2_code;
   sqlstm.sqhstl[2] = (unsigned int  )8;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_dept_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
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
   sqlstm.sqhstl[5] = (unsigned int  )8;
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
   sqlstm.sqhstl[7] = (unsigned int  )12;
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



   if (OERROR) err_mesg("Error while checking GL_POSTING_ACC",0,"");

   if (NOT_FOUND)
   {
/*
#ifdef DEBUG
   printf("Before inserting into GL_POSTING_ACC..\n");
   printf("\n <%s> - <%s> - <%s> - <%s> - <%s> - <%s> - <%s>\n",
                    d_main_acc1_code.arr,
                    d_main_acc2_code.arr,
                    d_dept_code.arr,
                    d_subledger_group_code.arr, 
                    d_subledger_line_code.arr, 
                    d_product_group_code.arr,
                    d_product_line_code.arr);
#endif
*/

/* Commented on 17/06/2004 by Suresh Kumar G, since this part is still waiting for
   approval from HMC. 	
	
	//Added on 04/03/2004 for Issue #7361

	EXEC SQL SELECT  COUNT(1) 
			  INTO  nd_count
              FROM  GL_ASSOC_POSTING_ACC
             WHERE  MAIN_ACC1_CODE       = :d_main_acc1_code
               AND  MAIN_ACC2_CODE       = :d_main_acc2_code
               AND  DEPT_CODE            = :d_dept_code
               AND  PRODUCT_GROUP_CODE   = :d_product_group_code
               AND  PRODUCT_LINE_CODE    = :d_product_line_code
               AND  SUBLEDGER_GROUP_CODE = :d_subledger_group_code 
               AND  SUBLEDGER_LINE_CODE  = :d_subledger_line_code;      
    
   if (nd_count > 0 )  
     {
*/
	   /* EXEC SQL INSERT INTO GL_POSTING_ACC
						   (ACC_ENTITY_CODE,
				  MAIN_ACC1_CODE,
						MAIN_ACC2_CODE,
						DEPT_CODE,
						SUBLEDGER_GROUP_CODE, 
						SUBLEDGER_LINE_CODE, 
						PRODUCT_GROUP_CODE,
						PRODUCT_LINE_CODE,
						CONCAT_MAIN_CODE,
						CONCAT_PROD_CODE,
						CONCAT_SLEG_CODE,
						CONCAT_POST_ACC_CODE,
						MAIN_DESC,
						DEPT_DESC,
						PROD_DESC,
						SLEG_DESC,
						CONCAT_POST_ACC_DESC,
						SUMMARY_ACC_FLAG,
						BANK_RECONCILE_FLAG,
				  ADDED_BY_ID,
						ADDED_DATE,
						POST_MONTH,
						POST_YEAR
					   )
				VALUES ( :nd_acc_entity_code,
						:d_main_acc1_code,
						:d_main_acc2_code,
						:d_dept_code,
						:d_subledger_group_code, 
						:d_subledger_line_code, 
						:d_product_group_code,
						:d_product_line_code,

						:d_main_acc1_code||:d_main_acc2_code,

						:d_product_group_code||:d_product_line_code,

						:d_subledger_group_code||:d_subledger_line_code, 

						:d_main_acc1_code||'-'||:d_main_acc2_code||' '||
						:d_dept_code ||' '||
						:d_product_group_code||'-'||:d_product_line_code||' '||
						:d_subledger_group_code||'-'||:d_subledger_line_code, 
						:d_main_desc,
						:d_dept_desc,
						:d_product_desc,
						:d_subledger_desc,
						:d_main_desc||:d_default_delimiter||
						:d_dept_desc||:d_default_delimiter||
						:d_product_desc||:d_default_delimiter||
						:d_subledger_desc,
						:d_summary_acc_flag,
						:d_bank_reconcile_flag,
				  USER,
				  SYSDATE,
						:d_post_month,
						:d_post_year
						); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 36;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into GL_POSTING_ACC (ACC_ENTITY_CODE,MAIN_ACC1_COD\
E,MAIN_ACC2_CODE,DEPT_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,PRODUCT_GR\
OUP_CODE,PRODUCT_LINE_CODE,CONCAT_MAIN_CODE,CONCAT_PROD_CODE,CONCAT_SLEG_CODE,\
CONCAT_POST_ACC_CODE,MAIN_DESC,DEPT_DESC,PROD_DESC,SLEG_DESC,CONCAT_POST_ACC_D\
ESC,SUMMARY_ACC_FLAG,BANK_RECONCILE_FLAG,ADDED_BY_ID,ADDED_DATE,POST_MONTH,POS\
T_YEAR) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,(:b1||:b2),(:b6||:b7),(:b4||:b\
5),((((((((((((:b1||'-')||:b2)||' ')||:b3)||' ')||:b6)||'-')||:b7)||' ')||:b4)\
||'-')||:b5),:b21,:b22,:b23,:b24,((((((:b21||:b26)||:b22)||:b26)||:b23)||:b26)\
||:b24),:b32,:b33,USER,SYSDATE,:b34,:b35)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )637;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
    sqlstm.sqhstl[0] = (unsigned int  )6;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )8;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_subledger_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_subledger_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )12;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_product_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_product_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )8;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_main_acc1_code;
    sqlstm.sqhstl[8] = (unsigned int  )10;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_main_acc2_code;
    sqlstm.sqhstl[9] = (unsigned int  )8;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_product_group_code;
    sqlstm.sqhstl[10] = (unsigned int  )6;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_product_line_code;
    sqlstm.sqhstl[11] = (unsigned int  )8;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_subledger_group_code;
    sqlstm.sqhstl[12] = (unsigned int  )6;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_subledger_line_code;
    sqlstm.sqhstl[13] = (unsigned int  )12;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_main_acc1_code;
    sqlstm.sqhstl[14] = (unsigned int  )10;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_main_acc2_code;
    sqlstm.sqhstl[15] = (unsigned int  )8;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_dept_code;
    sqlstm.sqhstl[16] = (unsigned int  )13;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_product_group_code;
    sqlstm.sqhstl[17] = (unsigned int  )6;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_product_line_code;
    sqlstm.sqhstl[18] = (unsigned int  )8;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_subledger_group_code;
    sqlstm.sqhstl[19] = (unsigned int  )6;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&d_subledger_line_code;
    sqlstm.sqhstl[20] = (unsigned int  )12;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_main_desc;
    sqlstm.sqhstl[21] = (unsigned int  )18;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&d_dept_desc;
    sqlstm.sqhstl[22] = (unsigned int  )18;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_product_desc;
    sqlstm.sqhstl[23] = (unsigned int  )18;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_subledger_desc;
    sqlstm.sqhstl[24] = (unsigned int  )18;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&d_main_desc;
    sqlstm.sqhstl[25] = (unsigned int  )18;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_default_delimiter;
    sqlstm.sqhstl[26] = (unsigned int  )5;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&d_dept_desc;
    sqlstm.sqhstl[27] = (unsigned int  )18;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&d_default_delimiter;
    sqlstm.sqhstl[28] = (unsigned int  )5;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&d_product_desc;
    sqlstm.sqhstl[29] = (unsigned int  )18;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&d_default_delimiter;
    sqlstm.sqhstl[30] = (unsigned int  )5;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&d_subledger_desc;
    sqlstm.sqhstl[31] = (unsigned int  )18;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&d_summary_acc_flag;
    sqlstm.sqhstl[32] = (unsigned int  )4;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&d_bank_reconcile_flag;
    sqlstm.sqhstl[33] = (unsigned int  )5;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&d_post_month;
    sqlstm.sqhstl[34] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[34] = (         int  )0;
    sqlstm.sqindv[34] = (         void  *)0;
    sqlstm.sqinds[34] = (         int  )0;
    sqlstm.sqharm[34] = (unsigned int  )0;
    sqlstm.sqadto[34] = (unsigned short )0;
    sqlstm.sqtdso[34] = (unsigned short )0;
    sqlstm.sqhstv[35] = (         void  *)&d_post_year;
    sqlstm.sqhstl[35] = (unsigned int  )sizeof(int);
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


		if (OERROR) err_mesg("Error while Inserting into GL_POSTING_ACC",0,"");
     //}

   }
}   

int sql_connect()
{

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 36;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )796;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )42;
  sqlstm.sqhsts[0] = (         int  )42;
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

void del_param()
{
	/* EXEC SQL DELETE SY_PROG_PARAM
	         WHERE  PGM_ID     = 'GLOCBACC' 
		 AND    SESSION_ID = :nd_session_id 
	         AND    PGM_DATE   = :d_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='GLOCBACC' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )827;
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
 sqlstm.sqhstv[1] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[1] = (unsigned int  )16;
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
	err_mesg("Deleting records from SY_PROG_PARAM",0,""); 
}


void create_gl_comb_temp()
{
/*
#ifdef DEBUG
   printf("Inside create gl_comb_temp\n");
#endif
*/

    /* EXEC SQL INSERT INTO GL_COMBINATION_TEMP
                (
                 MAIN_ACC1_CODE,
                 MAIN_ACC2_CODE,
                 DEPT_CODE,
                 PRODUCT_GROUP_CODE,
                 PRODUCT_LINE_CODE,
                 DEPT_DESC,
                 PROD_DESC
                )
              VALUES 
                (
                 :d_main_acc1_code,
                 :d_main_acc2_code,
                 :d_dept_code,
                 :d_product_group_code,
                 :d_product_line_code,
                 :d_dept_desc,
                 :d_product_desc
                ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 36;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into GL_COMBINATION_TEMP (MAIN_ACC1_CODE,MAIN_ACC2\
_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,DEPT_DESC,PROD_DESC) valu\
es (:b0,:b1,:b2,:b3,:b4,:b5,:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )850;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_dept_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_product_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_product_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_dept_desc;
    sqlstm.sqhstl[5] = (unsigned int  )18;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_product_desc;
    sqlstm.sqhstl[6] = (unsigned int  )18;
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
         err_mesg("INSERT failed on table GL_COMBINATION_TEMP",0,"");
/*
#ifdef DEBUG
   printf("No of recs inserted is <%d>\n",sqlca.sqlerrd[2]);
   printf("main acc is <%s><%d> - <%s><%d>\n",
                  d_main_acc1_code.arr,d_main_acc1_code.len,
                  d_main_acc2_code.arr,d_main_acc2_code.len);
#endif
*/
}


void open_combination_temp()
{
     /* EXEC SQL OPEN GL_COMBINATION_TEMP_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 36;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0011;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )893;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_main_acc1_code;
     sqlstm.sqhstl[0] = (unsigned int  )10;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_main_acc2_code;
     sqlstm.sqhstl[1] = (unsigned int  )8;
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
         err_mesg("OPEN failed on cursor GL_COMBINATION_TEMP_CUR",0,"");
}

int fetch_combination_temp()
{
/*
#ifdef DEBUG
   printf("Inside fetch combination_temp \n");
#endif
*/
    d_dept_code.arr[0]           = '\0';
    d_product_group_code.arr[0]  = '\0';
    d_product_line_code.arr[0]   = '\0';
    d_dept_desc.arr[0]           = '\0';
    d_product_desc.arr[0]        = '\0';

    d_dept_code.len              = 0;
    d_product_group_code.len     = 0;
    d_product_line_code.len      = 0;
    d_dept_desc.len              = 0;
    d_product_desc.len           = 0;

     /* EXEC SQL FETCH GL_COMBINATION_TEMP_CUR
               INTO :d_dept_code,
                    :d_product_group_code,
                    :d_product_line_code,
                    :d_dept_desc,
                    :d_product_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 36;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )916;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_dept_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_product_group_code;
     sqlstm.sqhstl[1] = (unsigned int  )6;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_product_line_code;
     sqlstm.sqhstl[2] = (unsigned int  )8;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_dept_desc;
     sqlstm.sqhstl[3] = (unsigned int  )18;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_product_desc;
     sqlstm.sqhstl[4] = (unsigned int  )18;
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
         err_mesg("FETCH failed on cursor GL_COMBINATION_TEMP_CUR",0,"");

     d_dept_code.arr[d_dept_code.len]                    = '\0';
     d_product_group_code.arr[d_product_group_code.len]  = '\0';
     d_product_line_code.arr[d_product_line_code.len]    = '\0';
     d_dept_desc.arr[d_dept_desc.len]                    = '\0';
     d_product_desc.arr[d_product_desc.len]              = '\0';

/*
#ifdef DEBUG
   printf(" %d records fetched \n",sqlca.sqlerrd[2]);
#endif
*/

     if (LAST_ROW)
        return(0);
     else
        return(1);
}

void delete_comb_temp()
{
       /* EXEC SQL DELETE GL_COMBINATION_TEMP; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 36;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "delete  from GL_COMBINATION_TEMP ";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )951;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



       if (OERROR)
            err_mesg("DELETE failed on table GL_COMBINATION_TEMP",0,"");
}

fetch_acc_entity()
{

 /* EXEC SQL SELECT   ACC_ENTITY_CODE
              INTO     :nd_acc_entity_code
              FROM SY_ACC_ENTITY
			  where  acc_entity_id = :p_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ACC_ENTITY_CODE into :b0  from SY_ACC_ENTITY where ac\
c_entity_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )966;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
 sqlstm.sqhstl[0] = (unsigned int  )6;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_facility_id;
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


		nd_acc_entity_code.arr[nd_acc_entity_code.len]                    = '\0';



}
