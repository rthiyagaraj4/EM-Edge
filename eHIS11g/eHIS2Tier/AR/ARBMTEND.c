
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
    "D:\\BLTEST\\11g\\GDOH-SCF-0137\\PROC\\ARBMTEND.PC"
};


static unsigned long sqlctx = 604874427;


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
            void  *sqhstv[4];
   unsigned int   sqhstl[4];
            int   sqhsts[4];
            void  *sqindv[4];
            int   sqinds[4];
   unsigned int   sqharm[4];
   unsigned int   *sqharc[4];
   unsigned short  sqadto[4];
   unsigned short  sqtdso[4];
} sqlstm = {10,4};

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

 static const char *sq0023 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_INV_HDR where (POSTED_FLAG='Y'\
 and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<=:b2)))           ";

 static const char *sq0029 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_INV_HDR where ((POSTED_FLAG='Y\
' and INTERFACE_FLAG='Y') and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<\
=:b2)))           ";

 static const char *sq0024 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_DN_HDR where (POSTED_FLAG='Y' \
and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<=:b2)))           ";

 static const char *sq0030 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_DN_HDR where ((POSTED_FLAG='Y'\
 and INTERFACE_FLAG='Y') and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<=\
:b2)))           ";

 static const char *sq0025 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_CN_HDR where (POSTED_FLAG='Y' \
and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<=:b2)))           ";

 static const char *sq0031 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_CN_HDR where ((POSTED_FLAG='Y'\
 and INTERFACE_FLAG='Y') and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<=\
:b2)))           ";

 static const char *sq0026 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_ADJ_HDR where (POSTED_FLAG='Y'\
 and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<=:b2)))           ";

 static const char *sq0032 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_ADJ_HDR where ((POSTED_FLAG='Y\
' and INTERFACE_FLAG='Y') and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<\
=:b2)))           ";

 static const char *sq0027 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_PAY_HDR where (POSTED_FLAG='Y'\
 and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<=:b2)))           ";

 static const char *sq0033 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_PAY_HDR where ((POSTED_FLAG='Y\
' and INTERFACE_FLAG='Y') and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<\
=:b2)))           ";

 static const char *sq0028 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_REC_HDR where (POSTED_FLAG='Y'\
 and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<=:b2)))           ";

 static const char *sq0034 = 
"select DOC_TYPE_CODE ,DOC_NUM ,ROWID  from AR_REC_HDR where ((POSTED_FLAG='Y\
' and INTERFACE_FLAG='Y') and (POST_YEAR<:b0 or (POST_YEAR=:b0 and POST_MONTH<\
=:b2)))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,133,0,4,157,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
36,0,0,2,0,0,30,198,0,0,0,0,0,1,0,
51,0,0,3,0,0,30,210,0,0,0,0,0,1,0,
66,0,0,4,47,0,1,217,0,0,0,0,0,1,0,
81,0,0,5,48,0,1,224,0,0,0,0,0,1,0,
96,0,0,6,46,0,1,231,0,0,0,0,0,1,0,
111,0,0,7,47,0,1,238,0,0,0,0,0,1,0,
126,0,0,8,45,0,1,245,0,0,0,0,0,1,0,
141,0,0,9,49,0,1,252,0,0,0,0,0,1,0,
156,0,0,10,46,0,1,259,0,0,0,0,0,1,0,
171,0,0,11,45,0,1,266,0,0,0,0,0,1,0,
186,0,0,12,49,0,1,273,0,0,0,0,0,1,0,
201,0,0,13,46,0,1,280,0,0,0,0,0,1,0,
216,0,0,14,46,0,1,287,0,0,0,0,0,1,0,
231,0,0,15,50,0,1,294,0,0,0,0,0,1,0,
246,0,0,16,47,0,1,301,0,0,0,0,0,1,0,
261,0,0,17,46,0,1,308,0,0,0,0,0,1,0,
276,0,0,18,47,0,1,315,0,0,0,0,0,1,0,
291,0,0,19,46,0,1,322,0,0,0,0,0,1,0,
306,0,0,20,47,0,1,329,0,0,0,0,0,1,0,
321,0,0,21,91,0,2,340,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
344,0,0,22,0,0,29,349,0,0,0,0,0,1,0,
359,0,0,35,98,0,4,509,0,0,3,0,0,1,0,2,3,0,0,2,9,0,0,2,3,0,0,
386,0,0,36,78,0,4,522,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
409,0,0,37,0,0,27,533,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
440,0,0,38,236,0,4,547,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
467,0,0,39,212,0,4,561,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
494,0,0,40,235,0,4,586,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
521,0,0,41,211,0,4,600,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
548,0,0,42,235,0,4,625,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
575,0,0,43,211,0,4,639,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
602,0,0,44,236,0,4,664,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
629,0,0,45,212,0,4,678,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
656,0,0,46,236,0,4,703,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
683,0,0,47,212,0,4,717,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
710,0,0,48,236,0,4,743,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
737,0,0,49,212,0,4,757,0,0,3,2,0,1,0,2,9,0,0,1,3,0,0,1,3,0,0,
764,0,0,23,147,0,9,802,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
791,0,0,29,172,0,9,808,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
818,0,0,23,0,0,13,826,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
845,0,0,29,0,0,13,835,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
872,0,0,50,40,0,2,856,0,0,1,1,0,1,0,1,9,0,0,
891,0,0,51,39,0,2,861,0,0,1,1,0,1,0,1,9,0,0,
910,0,0,52,39,0,2,866,0,0,1,1,0,1,0,1,9,0,0,
929,0,0,53,40,0,2,871,0,0,1,1,0,1,0,1,9,0,0,
948,0,0,54,40,0,2,876,0,0,1,1,0,1,0,1,9,0,0,
967,0,0,55,40,0,2,882,0,0,1,1,0,1,0,1,9,0,0,
986,0,0,56,69,0,2,895,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1009,0,0,57,69,0,2,901,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1032,0,0,58,70,0,2,907,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1055,0,0,59,67,0,2,921,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1078,0,0,60,66,0,2,927,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1101,0,0,61,66,0,2,933,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1124,0,0,62,67,0,2,939,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1147,0,0,63,67,0,2,945,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1170,0,0,64,67,0,2,952,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1193,0,0,24,146,0,9,975,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1220,0,0,30,171,0,9,981,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1247,0,0,24,0,0,13,999,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1274,0,0,30,0,0,13,1008,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1301,0,0,25,146,0,9,1038,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1328,0,0,31,171,0,9,1044,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1355,0,0,25,0,0,13,1062,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1382,0,0,31,0,0,13,1071,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1409,0,0,26,147,0,9,1101,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1436,0,0,32,172,0,9,1107,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1463,0,0,26,0,0,13,1125,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1490,0,0,32,0,0,13,1134,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1517,0,0,27,147,0,9,1163,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1544,0,0,33,172,0,9,1169,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1571,0,0,27,0,0,13,1187,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1598,0,0,33,0,0,13,1196,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1625,0,0,28,147,0,9,1225,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1652,0,0,34,172,0,9,1231,0,0,3,3,0,1,0,1,3,0,0,1,3,0,0,1,3,0,0,
1679,0,0,28,0,0,13,1249,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1706,0,0,34,0,0,13,1258,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1733,0,0,65,39,0,5,1277,0,0,0,0,0,1,0,
1748,0,0,66,93,0,5,1287,0,0,1,1,0,1,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                    */
/************************************************************************/
/* PROGRAM NAME          : ARBMTEND.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 23-FEB-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                                         */
/*  FUNCTION             :                                              */
/*                                                                       */
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
//#include "winexecc.h"

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
			p_language_id		   [3],
            nd_gl_interface_method [4]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[4]; } nd_gl_interface_method;


   /* VARCHAR  ar_interface_code      [3]; */ 
struct { unsigned short len; unsigned char arr[3]; } ar_interface_code;


   /* VARCHAR  ar_customer_cust_code  [10],
            d_doc_type_code        [7],
            d_doc_num              [9],
            d_rowid                [31],
            d_dummy                [3][10]; */ 
struct { unsigned short len; unsigned char arr[10]; } ar_customer_cust_code;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num;

struct { unsigned short len; unsigned char arr[31]; } d_rowid;

struct { unsigned short len; unsigned char arr[10]; } d_dummy[3];


       int  curr_acc_month   = 0,
            curr_acc_year    = 0,
            num_acc_period   = 0;


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
   char mesg1[50];
   if (argc != 5)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(g_pgm_id,"ARBMTEND");
 
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   strcpy(g_facility_id,argv[4]);
  

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      sprintf(mesg1,"Error is %s\n",sqlca.sqlerrm.sqlerrmc);
      disp_message(ERR_MESG,mesg1);
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   set_meduser_role();

   	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;
   
   chk_active();

   start_prog_control();
   start_prog_msg();

   fetch_ar_param();

   if (curr_acc_month == num_acc_period)
   {
      err_mesg("",1,"AR2140");
      proc_exit();
   }
    
   nd_gl_interface_method.arr[0]    = '\0';
   nd_gl_interface_method.len       = 0;

   /* EXEC SQL SELECT operating_facility_id,
				   PARAM1
              INTO :nd_facility_id,
				   :nd_gl_interface_method
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARBMTEND'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 into :b0,:b1  from SY\
_PROG_PARAM where ((PGM_ID='ARBMTEND' and SESSION_ID=:b2) and PGM_DATE=:b3)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_gl_interface_method;
   sqlstm.sqhstl[1] = (unsigned int  )6;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[2] = (unsigned int  )18;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[3] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   nd_gl_interface_method.arr[nd_gl_interface_method.len] = '\0';

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   delete_prog_param();

   lock_tables();

   declare_cursors();

   rec_exists = 0;

   if (check_inv_hdr())
       disp_mesg("",1,"AR2080");
   if (check_dn_hdr())
       disp_mesg("",1,"AR2090");
   if (check_cn_hdr())
       disp_mesg("",1,"AR2100");
   if (check_adj_hdr())
       disp_mesg("",1,"AR2110");
   if (check_rec_hdr())
       disp_mesg("",1,"AR2120");
   if (check_pay_hdr())
       disp_mesg("",1,"AR2130");
 
   if (rec_exists)
   {
        end_prog_control();
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
}


        proc_exit();
   }
/*----- Marked For Deletion to avoid deleting the records----*/
/*----------------- From the Transactions -------------------*/
 /*   delete_recs();  */
/*------------------------------------------------------------*/
   update_ar_customer(); 
   update_ar_parameter();

   end_prog_msg();
   end_prog_control();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

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



}

lock_tables()
{

   /* EXEC SQL LOCK TABLE AR_CUSTOMER
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CUSTOMER IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2190");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_CUSTOMER",0,"");

   /* EXEC SQL LOCK TABLE AR_PARAMETER
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_PARAMETER IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )81;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2290");
   else if (OERROR)
         err_mesg("LOCK failed on table AR_PARAMETER",0,"");

   /* EXEC SQL LOCK TABLE AR_INV_HDR
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_INV_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )96;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_INV_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )111;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_DN_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )126;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_DN_INV_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )141;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_DN_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )156;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CN_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )171;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CN_INV_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )186;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_CN_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )201;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_ADJ_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )216;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_ADJ_INV_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )231;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_ADJ_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )246;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_PAY_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )261;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_PAY_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )276;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_REC_HDR IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )291;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE AR_REC_LINE IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )306;
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
             WHERE PGM_ID     = 'ARBMTEND'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARBMTEND' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )321;
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )344;
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
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_DN_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_DN_HDR
                    WHERE POSTED_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_CN_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_CN_HDR
                    WHERE POSTED_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_ADJ_HDR_CUR CURSOR FOR   
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_ADJ_HDR
                    WHERE POSTED_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_PAY_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_PAY_HDR
                    WHERE POSTED_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_REC_HDR_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_REC_HDR
                    WHERE POSTED_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 


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
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_DN_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_DN_HDR
                    WHERE POSTED_FLAG = 'Y'
                    AND INTERFACE_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_CN_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_CN_HDR
                    WHERE POSTED_FLAG = 'Y'
                    AND INTERFACE_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_ADJ_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_ADJ_HDR
                    WHERE POSTED_FLAG = 'Y'
                    AND INTERFACE_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_PAY_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_PAY_HDR
                    WHERE POSTED_FLAG = 'Y'
                    AND INTERFACE_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 



        /* EXEC SQL DECLARE AR_REC_HDR_BAT_CUR CURSOR FOR
                  SELECT DOC_TYPE_CODE,
                         DOC_NUM,
                         ROWID
                    FROM AR_REC_HDR
                    WHERE POSTED_FLAG = 'Y'
                    AND INTERFACE_FLAG = 'Y'
                    and      ((POST_YEAR   <  :curr_acc_year ) OR
                              (POST_YEAR   =  :curr_acc_year  AND
                               POST_MONTH  <= :curr_acc_month )); */ 


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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CURRENT_ACC_MONTH ,AR_INTERFACE_CODE ,CURRENT_ACC_Y\
EAR into :b0,:b1,:b2  from AR_PARAMETER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )359;
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
			 WHERE ACC_ENTITY_ID = :nd_facility_id ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NUM_OF_ACC_PERIODS into :b0  from SY_ACC_ENTITY whe\
re ACC_ENTITY_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )386;
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
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )409;
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
  {
      return(-1);
	}
  return(0);
}

check_inv_hdr()
{

   if (ar_interface_code.arr[0] == 'B')
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_INV_HDR
               WHERE ( NVL(POSTED_FLAG,'N') = 'N' 
                  OR  INTERFACE_FLAG = 'N' )
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     ltrim(TO_CHAR(:curr_acc_year,'0009'))||
                     ltrim(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_INV_HDR where (((NVL(POSTED\
_FLAG,'N')='N' or INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||L\
TRIM(TO_CHAR(POST_MONTH,'09')))<=(ltrim(TO_CHAR(:b1,'0009'))||ltrim(TO_CHAR(:b\
2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )440;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }
   else
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_INV_HDR
               WHERE  NVL(POSTED_FLAG,'N') = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_INV_HDR where ((NVL(POSTED_\
FLAG,'N')='N' and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,\
'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )467;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }

   if (OERROR)
         err_mesg("SELECT failed on table AR_INV_HDR",0,"");

   if (!rec_exists)
         rec_exists = sqlca.sqlerrd[2];

   return(sqlca.sqlerrd[2]);
}

check_dn_hdr()
{
   if (ar_interface_code.arr[0] == 'B')
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_DN_HDR
               WHERE ( NVL(POSTED_FLAG,'N') = 'N' 
                  OR  INTERFACE_FLAG = 'N' )
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_DN_HDR where (((NVL(POSTED_\
FLAG,'N')='N' or INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LT\
RIM(TO_CHAR(POST_MONTH,'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b2\
,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )494;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }
   else
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_DN_HDR
               WHERE  NVL(POSTED_FLAG,'N') = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_DN_HDR where ((NVL(POSTED_F\
LAG,'N')='N' and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'\
09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )521;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }

   if (OERROR)
         err_mesg("SELECT failed on table AR_DN_HDR",0,"");

   if (!rec_exists)
         rec_exists = sqlca.sqlerrd[2];

   return(sqlca.sqlerrd[2]);
}

check_cn_hdr()
{
   if (ar_interface_code.arr[0] == 'B')
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_CN_HDR
               WHERE ( NVL(POSTED_FLAG,'N') = 'N' 
                  OR  INTERFACE_FLAG = 'N' )
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_CN_HDR where (((NVL(POSTED_\
FLAG,'N')='N' or INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LT\
RIM(TO_CHAR(POST_MONTH,'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b2\
,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )548;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }
   else
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_CN_HDR
               WHERE  NVL(POSTED_FLAG,'N') = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_CN_HDR where ((NVL(POSTED_F\
LAG,'N')='N' and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,'\
09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )575;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }

   if (OERROR)
         err_mesg("SELECT failed on table AR_CN_HDR",0,"");

   if (!rec_exists)
         rec_exists = sqlca.sqlerrd[2];

   return(sqlca.sqlerrd[2]);
}

check_adj_hdr()
{
   if (ar_interface_code.arr[0] == 'B')
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_ADJ_HDR
               WHERE ( NVL(POSTED_FLAG,'N') = 'N' 
                  OR  INTERFACE_FLAG = 'N' )
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_ADJ_HDR where (((NVL(POSTED\
_FLAG,'N')='N' or INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||L\
TRIM(TO_CHAR(POST_MONTH,'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b\
2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )602;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }
   else
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_ADJ_HDR
               WHERE  NVL(POSTED_FLAG,'N') = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_ADJ_HDR where ((NVL(POSTED_\
FLAG,'N')='N' and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,\
'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )629;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }

   if (OERROR)
         err_mesg("SELECT failed on table AR_ADJ_HDR",0,"");

   if (!rec_exists)
         rec_exists = sqlca.sqlerrd[2];

   return(sqlca.sqlerrd[2]);
}

check_pay_hdr()
{
   if (ar_interface_code.arr[0] == 'B')
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_PAY_HDR
               WHERE ( NVL(POSTED_FLAG,'N') = 'N' 
                  OR  INTERFACE_FLAG = 'N' )
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_PAY_HDR where (((NVL(POSTED\
_FLAG,'N')='N' or INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||L\
TRIM(TO_CHAR(POST_MONTH,'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b\
2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )656;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }
   else
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_PAY_HDR
               WHERE  NVL(POSTED_FLAG,'N') = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_PAY_HDR where ((NVL(POSTED_\
FLAG,'N')='N' and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,\
'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )683;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }

   if (OERROR)
         err_mesg("SELECT failed on table AR_PAY_HDR",0,"");

   if (!rec_exists)
         rec_exists = sqlca.sqlerrd[2];

   return(sqlca.sqlerrd[2]);

}

check_rec_hdr()
{
   if (ar_interface_code.arr[0] == 'B')
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_REC_HDR
               WHERE ( NVL(POSTED_FLAG,'N') = 'N' 
                  OR  INTERFACE_FLAG = 'N' )
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_REC_HDR where (((NVL(POSTED\
_FLAG,'N')='N' or INTERFACE_FLAG='N') and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||L\
TRIM(TO_CHAR(POST_MONTH,'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b\
2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )710;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }
   else
   {
     /* EXEC SQL SELECT 'X'
                INTO :d_dummy
                FROM AR_REC_HDR
               WHERE  NVL(POSTED_FLAG,'N') = 'N' 
                 AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                     LTRIM(TO_CHAR(POST_MONTH,'09'))
                     <= 
                     LTRIM(TO_CHAR(:curr_acc_year,'0009'))||
                     LTRIM(TO_CHAR(:curr_acc_month,'09'))
                 AND ROWNUM = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select 'X' into :b0  from AR_REC_HDR where ((NVL(POSTED_\
FLAG,'N')='N' and (LTRIM(TO_CHAR(POST_YEAR,'0009'))||LTRIM(TO_CHAR(POST_MONTH,\
'09')))<=(LTRIM(TO_CHAR(:b1,'0009'))||LTRIM(TO_CHAR(:b2,'09')))) and ROWNUM=1)";
     sqlstm.iters = (unsigned int  )3;
     sqlstm.offset = (unsigned int  )737;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)d_dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqharc[0] = (unsigned int   *)0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )sizeof(int);
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[2] = (         int  )sizeof(int);
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


   }

   if (OERROR)
         err_mesg("SELECT failed on table AR_REC_HDR",0,"");

   if (!rec_exists)
         rec_exists = sqlca.sqlerrd[2];

   return(sqlca.sqlerrd[2]);
}

delete_recs()
{
    delete_invoices();
    delete_debits();
    delete_credits();
    delete_adjus();
    delete_payments();
    delete_receipts();
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0023;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )764;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
         err_mesg("OPEN failed on cursor AR_INV_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_INV_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0029;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )791;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )818;
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
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )845;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_INV_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )872;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_DN_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )891;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_CN_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )910;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_ADJ_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )929;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_PAY_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )948;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_REC_HDR  where ROWID=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )967;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_DN_INV_HDR  where (DOC_TYPE_CO\
DE=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )986;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_CN_INV_HDR  where (DOC_TYPE_CO\
DE=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )1009;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_ADJ_INV_HDR  where (DOC_TYPE_C\
ODE=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )1032;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_INV_LINE  where (DOC_TYPE_CODE\
=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )1055;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_DN_LINE  where (DOC_TYPE_CODE=\
:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )1078;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_CN_LINE  where (DOC_TYPE_CODE=\
:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )1101;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_ADJ_LINE  where (DOC_TYPE_CODE\
=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )1124;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_PAY_LINE  where (DOC_TYPE_CODE\
=:b0 and DOC_NUM=:b1)";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )1147;
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
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_REC_LINE  where (DOC_TYPE_CODE\
=:b0 and DOC_NUM=:b1)";
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0024;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1193;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
         err_mesg("OPEN failed on cursor AR_DN_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_DN_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0030;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1220;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1247;
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
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1274;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0025;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1301;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
         err_mesg("OPEN failed on cursor AR_CN_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_CN_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0031;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1328;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1355;
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
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1382;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0026;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1409;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
         err_mesg("OPEN failed on cursor AR_ADJ_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_ADJ_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0032;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1436;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1463;
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
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1490;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0027;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1517;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
         err_mesg("OPEN failed on cursor AR_PAY_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_PAY_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0033;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1544;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1571;
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
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1598;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0028;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1625;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
         err_mesg("OPEN failed on cursor AR_REC_HDR_CUR",0,"");
   }
   else
   {
     /* EXEC SQL OPEN AR_REC_HDR_BAT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0034;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1652;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&curr_acc_year;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&curr_acc_month;
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
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1679;
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
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1706;
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


update_ar_customer()
{

   /* EXEC SQL UPDATE AR_CUSTOMER 
               SET MTD_SALES_AMT = 0; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update AR_CUSTOMER  set MTD_SALES_AMT=0";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1733;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
         err_mesg("UPDATE failed on table AR_CUSTOMER",0,"");

}

update_ar_parameter()
{
   /* EXEC SQL UPDATE AR_PARAMETER
               SET AR_INTERFACE_CODE   = :nd_gl_interface_method,
                   CURRENT_ACC_MONTH   = NVL(CURRENT_ACC_MONTH,0) + 1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update AR_PARAMETER  set AR_INTERFACE_CODE=:b0,CURRENT_ACC\
_MONTH=(NVL(CURRENT_ACC_MONTH,0)+1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1748;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_gl_interface_method;
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


        
   if (OERROR)
         err_mesg("UPDATE failed on table AR_PARAMETER",0,"");

}

