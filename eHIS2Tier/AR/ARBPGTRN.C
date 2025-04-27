
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
           char  filnam[22];
};
static const struct sqlcxp sqlfpn =
{
    21,
    "C:\\AR10.2\\ARBPGTRN.PC"
};


static unsigned long sqlctx = 141981547;


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
            void  *sqhstv[6];
   unsigned int   sqhstl[6];
            int   sqhsts[6];
            void  *sqindv[6];
            int   sqinds[6];
   unsigned int   sqharm[6];
   unsigned int   *sqharc[6];
   unsigned short  sqadto[6];
   unsigned short  sqtdso[6];
} sqlstm = {10,6};

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

 static const char *sq0020 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_INV_HDR where (POSTED_FLAG='Y'\
 and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09')))<=(ltr\
im(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))           ";

 static const char *sq0026 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_INV_HDR where ((POSTED_FLAG='Y\
' and INTERFACE_FLAG='Y') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR\
(POST_MONTH,'09')))<=(ltrim(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))  \
         ";

 static const char *sq0021 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_DN_HDR where (POSTED_FLAG='Y' \
and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09')))<=(ltri\
m(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))           ";

 static const char *sq0027 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_DN_HDR where ((POSTED_FLAG='Y'\
 and INTERFACE_FLAG='Y') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(\
POST_MONTH,'09')))<=(ltrim(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))   \
        ";

 static const char *sq0022 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_CN_HDR where (POSTED_FLAG='Y' \
and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09')))<=(ltri\
m(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))           ";

 static const char *sq0028 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_CN_HDR where ((POSTED_FLAG='Y'\
 and INTERFACE_FLAG='Y') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(\
POST_MONTH,'09')))<=(ltrim(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))   \
        ";

 static const char *sq0023 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_ADJ_HDR where (POSTED_FLAG='Y'\
 and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09')))<=(ltr\
im(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))           ";

 static const char *sq0029 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_ADJ_HDR where ((POSTED_FLAG='Y\
' and INTERFACE_FLAG='Y') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR\
(POST_MONTH,'09')))<=(ltrim(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))  \
         ";

 static const char *sq0024 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_PAY_HDR where (POSTED_FLAG='Y'\
 and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09')))<=(ltr\
im(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))           ";

 static const char *sq0030 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_PAY_HDR where ((POSTED_FLAG='Y\
' and INTERFACE_FLAG='Y') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR\
(POST_MONTH,'09')))<=(ltrim(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))  \
         ";

 static const char *sq0025 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_REC_HDR where (POSTED_FLAG='Y'\
 and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'09')))<=(ltr\
im(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))           ";

 static const char *sq0031 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_REC_HDR where ((POSTED_FLAG='Y\
' and INTERFACE_FLAG='Y') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR\
(POST_MONTH,'09')))<=(ltrim(TO_CHAR(:b0,'0009'))||ltrim(TO_CHAR(:b1,'09'))))  \
         ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,157,0,4,144,0,0,6,2,0,1,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,
44,0,0,2,0,0,30,174,0,0,0,0,0,1,0,
59,0,0,3,46,0,1,181,0,0,0,0,0,1,0,
74,0,0,4,47,0,1,188,0,0,0,0,0,1,0,
89,0,0,5,45,0,1,195,0,0,0,0,0,1,0,
104,0,0,6,49,0,1,202,0,0,0,0,0,1,0,
119,0,0,7,46,0,1,209,0,0,0,0,0,1,0,
134,0,0,8,45,0,1,216,0,0,0,0,0,1,0,
149,0,0,9,49,0,1,223,0,0,0,0,0,1,0,
164,0,0,10,46,0,1,230,0,0,0,0,0,1,0,
179,0,0,11,46,0,1,237,0,0,0,0,0,1,0,
194,0,0,12,50,0,1,244,0,0,0,0,0,1,0,
209,0,0,13,47,0,1,251,0,0,0,0,0,1,0,
224,0,0,14,46,0,1,258,0,0,0,0,0,1,0,
239,0,0,15,47,0,1,265,0,0,0,0,0,1,0,
254,0,0,16,46,0,1,272,0,0,0,0,0,1,0,
269,0,0,17,47,0,1,279,0,0,0,0,0,1,0,
284,0,0,18,91,0,2,290,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
307,0,0,19,0,0,29,299,0,0,0,0,0,1,0,
322,0,0,32,98,0,4,471,0,0,3,0,0,1,0,2,3,0,0,2,9,0,0,2,3,0,0,
349,0,0,33,78,0,4,484,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
372,0,0,34,0,0,27,495,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
403,0,0,20,216,0,9,548,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
426,0,0,26,241,0,9,554,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
449,0,0,20,0,0,13,572,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
476,0,0,26,0,0,13,581,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
503,0,0,35,40,0,2,602,0,0,1,1,0,1,0,1,9,0,0,
522,0,0,36,39,0,2,607,0,0,1,1,0,1,0,1,9,0,0,
541,0,0,37,39,0,2,612,0,0,1,1,0,1,0,1,9,0,0,
560,0,0,38,40,0,2,617,0,0,1,1,0,1,0,1,9,0,0,
579,0,0,39,40,0,2,622,0,0,1,1,0,1,0,1,9,0,0,
598,0,0,40,40,0,2,628,0,0,1,1,0,1,0,1,9,0,0,
617,0,0,41,69,0,2,641,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
640,0,0,42,69,0,2,647,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
663,0,0,43,70,0,2,653,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
686,0,0,44,67,0,2,667,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
709,0,0,45,66,0,2,673,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
732,0,0,46,66,0,2,679,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
755,0,0,47,67,0,2,685,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
778,0,0,48,67,0,2,691,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
801,0,0,49,67,0,2,698,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
824,0,0,21,215,0,9,721,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
847,0,0,27,240,0,9,727,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
870,0,0,21,0,0,13,745,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
897,0,0,27,0,0,13,754,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
924,0,0,22,215,0,9,784,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
947,0,0,28,240,0,9,790,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
970,0,0,22,0,0,13,808,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
997,0,0,28,0,0,13,817,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1024,0,0,23,216,0,9,847,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
1047,0,0,29,241,0,9,853,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
1070,0,0,23,0,0,13,871,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1097,0,0,29,0,0,13,880,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1124,0,0,24,216,0,9,909,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
1147,0,0,30,241,0,9,915,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
1170,0,0,24,0,0,13,933,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1197,0,0,30,0,0,13,942,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1224,0,0,25,216,0,9,971,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
1247,0,0,31,241,0,9,977,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
1270,0,0,25,0,0,13,995,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1297,0,0,31,0,0,13,1004,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                    */
/************************************************************************/
/* PROGRAM NAME          : ARBPGTRN.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 23-FEB-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                                 */
/*                                                                                           */
/*  FUNCTION             :                                               */
/*                                                                             */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_CUSTOMER                 Update                 */
/*         2.        SY_PROG_CONTROL          Update/Lookup             */
/*         3.        SY_PROG_MESG                Insert                 */
/*         4.        AR_INV_HDR               Query/Delete              */
/*         5.        AR_INV_LINE              Query/Delete              */
/*         6.        AR_DN_HDR                Query/Delete              */
/*         7.        AR_DN_INV_HDR            Query/Delete              */
/*         8.        AR_DN_LINE               Query/Delete              */
/*         9.        AR_CN_HDR                Query/Delete              */
/*        10.        AR_CN_INV_HDR            Query/Delete              */
/*        11.        AR_CN_LINE               Query/Delete              */
/*        12.        AR_ADJ_HDR               Query/Delete              */
/*        13.        AR_ADJ_INV_HDR           Query/Delete              */
/*        14.        AR_ADJ_LINE              Query/Delete              */
/*        15.        AR_PAY_HDR               Query/Delete              */
/*        16.        AR_PAY_LINE              Query/Delete              */
/*        17.        AR_REC_HDR               Query/Delete              */
/*        18.        AR_REC_LINE              Query/Delete              */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                       disp_mesg                      */
/*                                                                      */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <math.h>
#include <string.h>
#include "gl.h"
/*
#define OERROR (sqlca.sqlcode < 0)
*/
#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define VIEW_LOG_FILE 1
/*
#define DEBUG 0
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;


   /* VARCHAR  nd_facility_id         [3],
			nd_session_id          [16],
            nd_pgm_date            [25],
            nd_gl_interface_method [4]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[4]; } nd_gl_interface_method;


   /* VARCHAR  ar_interface_code      [3]; */ 
struct { unsigned short len; unsigned char arr[3]; } ar_interface_code;


   /* VARCHAR  ar_customer_cust_code  [10],
            d_doc_type_code        [7],
            d_doc_num              [9],
			nd_trn_type_code	   [2],
            d_rowid                [31],
            d_dummy                [3][10]; */ 
struct { unsigned short len; unsigned char arr[10]; } ar_customer_cust_code;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num;

struct { unsigned short len; unsigned char arr[2]; } nd_trn_type_code;

struct { unsigned short len; unsigned char arr[31]; } d_rowid;

struct { unsigned short len; unsigned char arr[10]; } d_dummy[3];


       int  curr_acc_month   = 0,
            curr_acc_year    = 0,
            num_acc_period   = 0;

       int  nd_mth,
	    nd_year;
char string_var[100];

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

int  rec_exists = 0;

void proc_main(argc,argv)
char *argv[];
int argc;
{

   if (argc != 5)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }
      
   strcpy(g_pgm_id,"ARBPGTRN");
 
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   set_meduser_role();

   /*
   chk_active();
   start_prog_control();
   */

   start_prog_msg();

   fetch_ar_param();

   nd_mth = 0;
   nd_year = 0;

   /* EXEC SQL SELECT operating_facility_id,
				   PARAM1,PARAM2,PARAM3
              INTO :nd_facility_id,
				   :nd_mth, :nd_year,
				   :nd_trn_type_code
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBPGTRN'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 into \
:b0,:b1,:b2,:b3  from SY_PROG_PARAM where ((PGM_ID='ARBPGTRN' and SESSION_ID=:\
b4) and PGM_DATE=:b5)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_mth;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_year;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_trn_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[4] = (unsigned int  )18;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[5] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

nd_trn_type_code.arr[nd_trn_type_code.len] = '\0';

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   delete_prog_param();

   lock_tables();

   declare_cursors();

   delete_recs();

   end_prog_msg();
   /*
   end_prog_control();
   */
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )44;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

lock_tables()
{

   /* EXEC SQL LOCK TABLE AR_INV_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_INV_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )59;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2230");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_INV_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_INV_LINE
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_INV_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )74;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2230");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_INV_LINE",0,"");

   /* EXEC SQL LOCK TABLE AR_DN_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_DN_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )89;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2240");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_DN_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_DN_INV_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_DN_INV_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )104;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2240");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_DN_INV_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_DN_LINE
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_DN_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )119;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2240");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_DN_LINE",0,"");

   /* EXEC SQL LOCK TABLE AR_CN_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CN_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )134;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2250");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_CN_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_CN_INV_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CN_INV_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )149;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2250");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_CN_INV_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_CN_LINE
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CN_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )164;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2250");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_CN_LINE",0,"");

   /* EXEC SQL LOCK TABLE AR_ADJ_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_ADJ_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )179;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2260");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_ADJ_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_ADJ_INV_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_ADJ_INV_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )194;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2260");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_ADJ_INV_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_ADJ_LINE
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_ADJ_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )209;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2260");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_ADJ_LINE",0,"");

   /* EXEC SQL LOCK TABLE AR_PAY_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_PAY_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )224;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2280");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_PAY_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_PAY_LINE
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_PAY_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )239;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2280");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_PAY_LINE",0,"");

   /* EXEC SQL LOCK TABLE AR_REC_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_REC_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )254;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2270");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_REC_HDR",0,"");

   /* EXEC SQL LOCK TABLE AR_REC_LINE
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_REC_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )269;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2270");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_REC_LINE",0,"");

}

delete_prog_param()
{
   /* EXEC SQL DELETE
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBPGTRN'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARBPGTRN' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )284;
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
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )307;
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
   if (ar_interface_code.arr[0] != 'B')
   {
        /* EXEC SQL DECLARE AR_INV_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_INV_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_DN_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_DN_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_CN_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_CN_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_ADJ_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_ADJ_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_PAY_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_PAY_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_REC_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_REC_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 

    }
    else
    {
        /* EXEC SQL DECLARE AR_INV_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_INV_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND INTERFACE_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_DN_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_DN_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND INTERFACE_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_CN_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_CN_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND INTERFACE_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_ADJ_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_ADJ_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND INTERFACE_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_PAY_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_PAY_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND INTERFACE_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 


        /* EXEC SQL DECLARE AR_REC_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_REC_HDR
                   WHERE POSTED_FLAG = 'Y'
                     AND INTERFACE_FLAG = 'Y'
                     AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                         LTRIM(TO_CHAR(POST_MONTH,'09'))
                         <= 
                         ltrim(TO_CHAR(:nd_year,'0009'))||
                         ltrim(TO_CHAR(:nd_mth,'09')); */ 

    }
}

fetch_ar_param()
{
   curr_acc_month = 0;
   curr_acc_year  = 0;

   ar_interface_code.arr[0]    = '\0';
   ar_interface_code.len       = 0;

   /* EXEC SQL SELECT CURRENT_ACC_MONTH, AR_INTERFACE_CODE,
                   CURRENT_ACC_YEAR
              INTO :curr_acc_month,   :ar_interface_code,
                   :curr_acc_year
              FROM AR_PARAMETER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CURRENT_ACC_MONTH ,AR_INTERFACE_CODE ,CURRENT_ACC_Y\
EAR into :b0,:b1,:b2  from AR_PARAMETER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )322;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&curr_acc_month;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_interface_code;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&curr_acc_year;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
         err_mesg("SELECT failed on table AR_PARAMETER",0,"");

   ar_interface_code.arr[ar_interface_code.len]      = '\0';

   num_acc_period = 0;

   /* EXEC SQL SELECT NUM_OF_ACC_PERIODS
              INTO :num_acc_period
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NUM_OF_ACC_PERIODS into :b0  from SY_ACC_ENTITY whe\
re ACC_ENTITY_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )349;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&num_acc_period;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )372;
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

delete_recs()
{

if(strcmp(nd_trn_type_code.arr,"1")==0){
    delete_invoices();
	}
if(strcmp(nd_trn_type_code.arr,"2")==0){
    delete_debits();
	}
if(strcmp(nd_trn_type_code.arr,"3")==0){
    delete_credits();
	}
if(strcmp(nd_trn_type_code.arr,"4")==0){
    delete_adjus();
	}
if(strcmp(nd_trn_type_code.arr,"6")==0){
    delete_payments();
	}
if(strcmp(nd_trn_type_code.arr,"5")==0){
    delete_receipts();
	}
if(strcmp(nd_trn_type_code.arr,"7")==0)
  {
	delete_invoices();
	delete_debits();
	delete_credits();
	delete_adjus();
	delete_payments();
	delete_receipts();
  } 
}

delete_invoices()
{
   open_inv_hdr();
   while (fetch_inv_hdr())
   {
       delete_line(1);
       delete_hdr(1);
   }
}

open_inv_hdr()
{
   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL OPEN AR_INV_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0020;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )403;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_INV_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_INV_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0026;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )426;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_INV_HDR_BAT_CUR",0,"");
   }
}

fetch_inv_hdr()
{
   d_doc_type_code.arr[0] = '\0';
   d_doc_num.arr[0]       = '\0';
   d_rowid.arr[0]         = '\0';

   d_doc_type_code.len    = 0;
   d_doc_num.len          = 0;
   d_rowid.len            = 0;

   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL FETCH AR_INV_HDR_CUR
               INTO :d_doc_type_code,
                    :d_doc_num,
                    :d_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )449;
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
     sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor AR_INV_HDR_CUR",0,"");
   }
   else
   {
        /* EXEC SQL FETCH AR_INV_HDR_BAT_CUR
                  INTO :d_doc_type_code,
                       :d_doc_num,
                       :d_rowid; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )476;
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
        sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[1] = (unsigned int  )11;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


        if (OERROR)
           err_mesg("FETCH failed on cursor AR_INV_HDR_BAT_CUR",0,"");
   }
   d_doc_type_code.arr[d_doc_type_code.len]        = '\0';
   d_doc_num.arr[d_doc_num.len]                    = '\0';
   d_rowid.arr[d_rowid.len]                        = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}

delete_hdr(no)
int no;
{
   switch (no)
   {
      case 1 :
               /* EXEC SQL DELETE AR_INV_HDR
                         WHERE ROWID = :d_rowid; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_INV_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )503;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqhstv[0] = (         void  *)&d_rowid;
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


               if (OERROR) err_mesg("DELETE failed on table AR_INV_HDR",0,"");
               break;
      case 2 :
               /* EXEC SQL DELETE AR_DN_HDR
                         WHERE ROWID = :d_rowid; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_DN_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )522;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqhstv[0] = (         void  *)&d_rowid;
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


               if (OERROR) err_mesg("DELETE failed on table AR_DN_HDR",0,"");
               break;
      case 3 :
               /* EXEC SQL DELETE AR_CN_HDR
                         WHERE ROWID = :d_rowid; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_CN_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )541;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqhstv[0] = (         void  *)&d_rowid;
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


               if (OERROR) err_mesg("DELETE failed on table AR_CN_HDR",0,"");
               break;
      case 4 :
               /* EXEC SQL DELETE AR_ADJ_HDR
                         WHERE ROWID = :d_rowid; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_ADJ_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )560;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqhstv[0] = (         void  *)&d_rowid;
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


               if (OERROR) err_mesg("DELETE failed on table AR_ADJ_HDR",0,"");
               break;
      case 5 :
               /* EXEC SQL DELETE AR_PAY_HDR
                         WHERE ROWID = :d_rowid; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_PAY_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )579;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqhstv[0] = (         void  *)&d_rowid;
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


               if (OERROR) err_mesg("DELETE failed on table AR_PAY_HDR",0,"");
               break;

      case 6 :
               /* EXEC SQL DELETE AR_REC_HDR
                         WHERE ROWID = :d_rowid; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_REC_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )598;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqhstv[0] = (         void  *)&d_rowid;
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


               if (OERROR) err_mesg("DELETE failed on table AR_REC_HDR",0,"");
               break;
     }
}

delete_inv_hdr(no)
int no;
{
   switch (no)
   {
      case 2 :
               /* EXEC SQL DELETE AR_DN_INV_HDR
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_DN_INV_HDR  where (DOC_TYPE_CO\
DE=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )617;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


               if (OERROR) err_mesg("DELETE failed on table AR_DN_INV_HDR",0,"");
               break;
      case 3 :
               /* EXEC SQL DELETE AR_CN_INV_HDR
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_CN_INV_HDR  where (DOC_TYPE_CO\
DE=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )640;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


               if (OERROR) err_mesg("DELETE failed on table AR_CN_INV_HDR",0,"");
               break;
      case 4 :
               /* EXEC SQL DELETE AR_ADJ_INV_HDR
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_ADJ_INV_HDR  where (DOC_TYPE_C\
ODE=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )663;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


              if (OERROR) err_mesg("DELETE failed on table AR_ADJ_INV_HDR",0,"");
              break;
     }
}

delete_line(no)
int no;
{
   switch (no)
   {
      case 1 :
               /* EXEC SQL DELETE AR_INV_LINE
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_INV_LINE  where (DOC_TYPE_CODE\
=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )686;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


               if (OERROR) err_mesg("DELETE failed on table AR_INV_LINE",0,"");
               break;
      case 2 :
               /* EXEC SQL DELETE AR_DN_LINE
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_DN_LINE  where (DOC_TYPE_CODE=\
:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )709;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


               if (OERROR) err_mesg("DELETE failed on table AR_DN_LINE",0,"");
               break;
      case 3 :
               /* EXEC SQL DELETE AR_CN_LINE
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_CN_LINE  where (DOC_TYPE_CODE=\
:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )732;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


               if (OERROR) err_mesg("DELETE failed on table AR_CN_LINE",0,"");
               break;
      case 4 :
               /* EXEC SQL DELETE AR_ADJ_LINE
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_ADJ_LINE  where (DOC_TYPE_CODE\
=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )755;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


               if (OERROR) err_mesg("DELETE failed on table AR_ADJ_LINE",0,"");
               break;
      case 5 :
               /* EXEC SQL DELETE AR_PAY_LINE
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_PAY_LINE  where (DOC_TYPE_CODE\
=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )778;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


               if (OERROR) err_mesg("DELETE failed on table AR_PAY_LINE",0,"");
               break;

      case 6 :
               /* EXEC SQL DELETE AR_REC_LINE
                         WHERE DOC_TYPE_CODE = :d_doc_type_code
                           AND DOC_NUM       = :d_doc_num; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_REC_LINE  where (DOC_TYPE_CODE\
=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )801;
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
               sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


               if (OERROR) err_mesg("DELETE failed on table AR_REC_LINE",0,"");
               break;
     }
}

delete_debits()
{
   open_dn_hdr();
   while (fetch_dn_hdr())
   {
       delete_line(2);
       delete_inv_hdr(2);
       delete_hdr(2);
   }
}

open_dn_hdr()
{
   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL OPEN AR_DN_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0021;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )824;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_DN_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_DN_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0027;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )847;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_DN_HDR_BAT_CUR",0,"");
   }
}

fetch_dn_hdr()
{
   d_doc_type_code.arr[0] = '\0';
   d_doc_num.arr[0]       = '\0';
   d_rowid.arr[0]         = '\0';

   d_doc_type_code.len    = 0;
   d_doc_num.len          = 0;
   d_rowid.len            = 0;

   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL FETCH AR_DN_HDR_CUR
               INTO :d_doc_type_code,
                    :d_doc_num,
                    :d_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )870;
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
     sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor AR_DN_HDR_CUR",0,"");
   }
   else
   {
        /* EXEC SQL FETCH AR_DN_HDR_BAT_CUR
                  INTO :d_doc_type_code,
                       :d_doc_num,
                       :d_rowid; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )897;
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
        sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[1] = (unsigned int  )11;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


        if (OERROR)
           err_mesg("FETCH failed on cursor AR_DN_HDR_BAT_CUR",0,"");
   }
   d_doc_type_code.arr[d_doc_type_code.len]        = '\0';
   d_doc_num.arr[d_doc_num.len]                    = '\0';
   d_rowid.arr[d_rowid.len]                        = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}

delete_credits()
{
   open_cn_hdr();
   while (fetch_cn_hdr())
   {
       delete_line(3);
       delete_inv_hdr(3);
       delete_hdr(3);
   }
}

open_cn_hdr()
{
   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL OPEN AR_CN_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0022;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )924;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_CN_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_CN_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0028;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )947;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_CN_HDR_BAT_CUR",0,"");
   }
}

fetch_cn_hdr()
{
   d_doc_type_code.arr[0] = '\0';
   d_doc_num.arr[0]       = '\0';
   d_rowid.arr[0]         = '\0';

   d_doc_type_code.len    = 0;
   d_doc_num.len          = 0;
   d_rowid.len            = 0;

   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL FETCH AR_CN_HDR_CUR
               INTO :d_doc_type_code,
                    :d_doc_num,
                    :d_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )970;
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
     sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor AR_CN_HDR_CUR",0,"");
   }
   else
   {
        /* EXEC SQL FETCH AR_CN_HDR_BAT_CUR
                  INTO :d_doc_type_code,
                       :d_doc_num,
                       :d_rowid; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )997;
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
        sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[1] = (unsigned int  )11;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


        if (OERROR)
           err_mesg("FETCH failed on cursor AR_CN_HDR_BAT_CUR",0,"");
   }
   d_doc_type_code.arr[d_doc_type_code.len]        = '\0';
   d_doc_num.arr[d_doc_num.len]                    = '\0';
   d_rowid.arr[d_rowid.len]                        = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}

delete_adjus()
{
   open_adj_hdr();
   while (fetch_adj_hdr())
   {
       delete_line(4);
       delete_inv_hdr(4);
       delete_hdr(4);
   }
}

open_adj_hdr()
{
   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL OPEN AR_ADJ_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0023;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1024;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_ADJ_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_ADJ_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0029;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1047;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_ADJ_HDR_BAT_CUR",0,"");
   }
}

fetch_adj_hdr()
{
   d_doc_type_code.arr[0] = '\0';
   d_doc_num.arr[0]       = '\0';
   d_rowid.arr[0]         = '\0';

   d_doc_type_code.len    = 0;
   d_doc_num.len          = 0;
   d_rowid.len            = 0;

   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL FETCH AR_ADJ_HDR_CUR
               INTO :d_doc_type_code,
                    :d_doc_num,
                    :d_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1070;
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
     sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor AR_ADJ_HDR_CUR",0,"");
   }
   else
   {
        /* EXEC SQL FETCH AR_ADJ_HDR_BAT_CUR
                  INTO :d_doc_type_code,
                       :d_doc_num,
                       :d_rowid; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1097;
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
        sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[1] = (unsigned int  )11;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


        if (OERROR)
           err_mesg("FETCH failed on cursor AR_ADJ_HDR_BAT_CUR",0,"");
   }
   d_doc_type_code.arr[d_doc_type_code.len]        = '\0';
   d_doc_num.arr[d_doc_num.len]                    = '\0';
   d_rowid.arr[d_rowid.len]                        = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}

delete_payments()
{
   open_pay_hdr();
   while (fetch_pay_hdr())
   {
       delete_line(5);
       delete_hdr(5);
   }
}

open_pay_hdr()
{
   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL OPEN AR_PAY_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0024;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1124;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_PAY_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_PAY_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0030;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1147;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_PAY_HDR_BAT_CUR",0,"");
   }
}

fetch_pay_hdr()
{
   d_doc_type_code.arr[0] = '\0';
   d_doc_num.arr[0]       = '\0';
   d_rowid.arr[0]         = '\0';

   d_doc_type_code.len    = 0;
   d_doc_num.len          = 0;
   d_rowid.len            = 0;

   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL FETCH AR_PAY_HDR_CUR
               INTO :d_doc_type_code,
                    :d_doc_num,
                    :d_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1170;
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
     sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor AR_PAY_HDR_CUR",0,"");
   }
   else
   {
        /* EXEC SQL FETCH AR_PAY_HDR_BAT_CUR
                  INTO :d_doc_type_code,
                       :d_doc_num,
                       :d_rowid; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1197;
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
        sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[1] = (unsigned int  )11;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


        if (OERROR)
           err_mesg("FETCH failed on cursor AR_PAY_HDR_BAT_CUR",0,"");
   }
   d_doc_type_code.arr[d_doc_type_code.len]        = '\0';
   d_doc_num.arr[d_doc_num.len]                    = '\0';
   d_rowid.arr[d_rowid.len]                        = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}

delete_receipts()
{
   open_rec_hdr();
   while (fetch_rec_hdr())
   {
       delete_line(6);
       delete_hdr(6);
   }
}

open_rec_hdr()
{
   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL OPEN AR_REC_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0025;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1224;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_REC_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_REC_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0031;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1247;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_mth;
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
         err_mesg("OPEN failed on cursor AR_REC_HDR_BAT_CUR",0,"");
   }
}

fetch_rec_hdr()
{
   d_doc_type_code.arr[0] = '\0';
   d_doc_num.arr[0]       = '\0';
   d_rowid.arr[0]         = '\0';

   d_doc_type_code.len    = 0;
   d_doc_num.len          = 0;
   d_rowid.len            = 0;

   if (ar_interface_code.arr[0] != 'B')
   { 
     /* EXEC SQL FETCH AR_REC_HDR_CUR
               INTO :d_doc_type_code,
                    :d_doc_num,
                    :d_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1270;
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
     sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor AR_REC_HDR_CUR",0,"");
   }
   else
   {
        /* EXEC SQL FETCH AR_REC_HDR_BAT_CUR
                  INTO :d_doc_type_code,
                       :d_doc_num,
                       :d_rowid; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1297;
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
        sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[1] = (unsigned int  )11;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_rowid;
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


        if (OERROR)
           err_mesg("FETCH failed on cursor AR_REC_HDR_BAT_CUR",0,"");
   }
   d_doc_type_code.arr[d_doc_type_code.len]        = '\0';
   d_doc_num.arr[d_doc_num.len]                    = '\0';
   d_rowid.arr[d_rowid.len]                        = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}
