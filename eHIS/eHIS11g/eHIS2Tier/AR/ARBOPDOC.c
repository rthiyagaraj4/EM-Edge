
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/AR/ARBOPDOC.PC"
};


static unsigned int sqlctx = 1288482467;


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
            void  *sqhstv[21];
   unsigned int   sqhstl[21];
            int   sqhsts[21];
            void  *sqindv[21];
            int   sqinds[21];
   unsigned int   sqharm[21];
   unsigned int   *sqharc[21];
   unsigned short  sqadto[21];
   unsigned short  sqtdso[21];
} sqlstm = {12,21};

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

 static const char *sq0010 = 
"select DOC_TYPE_CODE ,DOC_NUM ,CUST_CODE ,PMNT_TERMS_CODE ,PATIENT_ID ,BILLI\
NG_GROUP ,PENDING_AMT ,MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROU\
P_CODE ,PRODUCT_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,ROWID ,T\
O_CHAR(DOC_DATE,'DD/MM/YYYY') ,NARRATION ,POST_MONTH ,POST_YEAR ,TRN_TYPE_CODE\
 ,NVL(CONSOLIDATED_INV_YN,'N')  from AR_PENDING_DOC_TEMP where (CUST_CODE>=nvl\
(:b0,'        ') and CUST_CODE<=nvl(:b1,'~~~~~~~~'))           ";

 static const char *sq0015 = 
"select NVL(STATUS,'X') ,NVL(AR_VALID_FLAG,'X')  from GL_ACC_ENTITY_DOC_TYPE_\
VW where DOC_TYPE_CODE=:b0           ";

 static const char *sq0017 = 
"select TRN_TYPE_CODE  from AR_TRN_DOC_TYPE where (DOC_TYPE_CODE=:b0 and TRN_\
TYPE_CODE=:b1)           ";

 static const char *sq0011 = 
"select 'X'  from SY_DOC_CONTROL where ((MODULE_ID='AR' and DOC_TYPE_CODE=:b0\
) and DOC_NUM=:b1)           ";

 static const char *sq0012 = 
"select NVL(STATUS,'X') ,PATIENT_FLAG  from AR_CUSTOMER where CUST_CODE=:b0  \
         ";

 static const char *sq0013 = 
"select NVL(STATUS,'X')  from AR_PMNT_TERMS where PMNT_TERMS_CODE=:b0        \
   ";

 static const char *sq0014 = 
"select DOC_TYPE_CODE ,DOC_NUM ,AMOUNT ,LINE_NUM ,TRN_TYPE_CODE  from AR_CUST\
_TRN_TEMP where (ORG_DOC_TYPE_CODE=:b0 and ORG_DOC_NUM=:b1) for update of LINE\
_NUM nowait ";

 static const char *sq0018 = 
"select DOC_TYPE_CODE ,DOC_NUM ,PATIENT_ID ,BILL_DOC_TYPE_CODE ,BILL_NUM ,TO_\
CHAR(BILL_DATE,'DD/MM/YYYY') ,REMARKS ,NVL(AMOUNT,0) ,TO_CHAR(TO_DATE(:b0,'DD/\
MM/YYYY'),'YYYYMMDD') ,ROWID  from AR_PATIENT_DTLS where (DOC_TYPE_CODE=:b1 an\
d DOC_NUM=:b2) order by BILL_DATE,PATIENT_ID  for update of LINE_NUM nowait ";

 static const char *sq0016 = 
"select 'X'  from SY_DOC_CONTROL where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)   \
        ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,157,0,4,226,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,
0,0,
44,0,0,2,96,0,4,262,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
67,0,0,3,0,0,29,324,0,0,0,0,0,1,0,
82,0,0,4,0,0,30,331,0,0,0,0,0,1,0,
97,0,0,5,0,0,30,347,0,0,0,0,0,1,0,
112,0,0,6,118,0,4,362,0,0,4,1,0,1,0,2,3,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
143,0,0,7,62,0,6,374,0,0,1,1,0,1,0,2,9,0,0,
162,0,0,8,44,0,4,380,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
185,0,0,9,44,0,4,384,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
208,0,0,10,451,0,9,512,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
231,0,0,10,0,0,13,568,0,0,21,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
330,0,0,15,113,0,9,629,0,0,1,1,0,1,0,1,9,0,0,
349,0,0,15,0,0,13,639,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
372,0,0,17,101,0,9,668,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
395,0,0,17,0,0,13,673,0,0,1,0,0,1,0,2,9,0,0,
414,0,0,11,105,0,9,686,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
437,0,0,11,0,0,13,691,0,0,1,0,0,1,0,2,9,0,0,
456,0,0,12,85,0,9,702,0,0,1,1,0,1,0,1,9,0,0,
475,0,0,12,0,0,13,713,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
498,0,0,13,79,0,9,731,0,0,1,1,0,1,0,1,9,0,0,
517,0,0,13,0,0,13,738,0,0,1,0,0,1,0,2,9,0,0,
536,0,0,19,71,0,4,759,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
559,0,0,20,62,0,4,778,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
582,0,0,14,166,0,9,798,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
605,0,0,21,0,0,29,804,0,0,0,0,0,1,0,
620,0,0,14,0,0,13,826,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
655,0,0,18,308,0,9,849,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
682,0,0,22,0,0,29,855,0,0,0,0,0,1,0,
697,0,0,18,0,0,13,887,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,3,0,0,2,9,0,0,
752,0,0,23,62,0,4,923,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
775,0,0,15,113,0,9,942,0,0,1,1,0,1,0,1,9,0,0,
794,0,0,15,0,0,13,952,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
817,0,0,24,56,0,5,986,0,0,2,2,0,1,0,1,3,0,0,1,9,0,0,
840,0,0,15,113,0,9,1002,0,0,1,1,0,1,0,1,9,0,0,
859,0,0,15,0,0,13,1012,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
882,0,0,17,101,0,9,1041,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
905,0,0,17,0,0,13,1046,0,0,1,0,0,1,0,2,9,0,0,
924,0,0,16,84,0,9,1059,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
947,0,0,16,0,0,13,1063,0,0,1,0,0,1,0,2,9,0,0,
966,0,0,25,126,0,3,1150,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1001,0,0,26,126,0,3,1219,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1036,0,0,27,133,0,5,1239,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1059,0,0,28,273,0,3,1253,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1098,0,0,29,1977,0,3,1288,0,0,1,1,0,1,0,1,9,0,0,
1117,0,0,30,464,0,3,1415,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1140,0,0,31,437,0,3,1453,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1163,0,0,32,104,0,5,1491,0,0,2,2,0,1,0,1,4,0,0,1,9,0,0,
1186,0,0,33,49,0,2,1500,0,0,1,1,0,1,0,1,9,0,0,
1205,0,0,34,80,0,2,1506,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1228,0,0,0,0,0,27,1517,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
1259,0,0,36,67,0,2,1576,0,0,0,0,0,1,0,
1274,0,0,37,0,0,29,1583,0,0,0,0,0,1,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                    */
/************************************************************************/
/* PROGRAM NAME          : ARBOPDOC.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 30-NOV-1992                                       */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_PENDING_DOC_TEMP      Query/Update              */
/*         2.        AR_CUST_TRN_TEMP            Query                  */
/*         3.        SY_ACC_ENTITY_DOC_TYPE      Lookup                 */
/*         4.        AR_CUSTOMER                 Lookup                 */
/*         5.        AR_PMNT_TERMS               Lookup                 */
/*         6.        BL_BLNG_GRP                 Lookup                 */
/*         7.        MP_PATIENT_MAST             Lookup                 */
/*         8.        AR_PARAMETER                Lookup                 */
/*         9.        GL_ACC_CHART                Lookup                 */
/*        10.        SY_DEPT                     Lookup                 */
/*        11.        GL_PRODUCT_LINE             Lookup                 */
/*        12.        GL_SUBLEDGER_LINE           Lookup                 */
/*        13.        GL_ACC_COMBINATION          Lookup                 */
/*        14.        ARROPDOC               Query/Insert/Delete         */
/*        15.        AR_PENDING_DOC            Insert/Lookup            */
/*        16.        AR_CUST_TRN               Insert/Lookup            */
/*        17.        SY_PROG_CONTROL           Update/Lookup            */
/*        18.        SY_PROG_MESG                 Insert                */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*                                                                      */
/************************************************************************/

    
#include <stdio.h>
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





#include "winproc.h"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR  nd_facility_id   [3],
			uid_pwd[132],
			nd_pgm_date[35]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;


   /* VARCHAR nd_session_id                 [16],
	   nd_fm_cust_code               [12],
	   nd_fm_doc_type                [8],
	   nd_to_cust_code               [12],
	   nd_to_doc_type                [8],
	   	p_language_id			    [3],

	   d_pend_doc_type_code          [8],
	   d_check_doc_type_code         [8],
	   d_pend_doc_num                [12],
	   d_pend_cust_code              [12],
	   d_pend_pmnt_terms_code        [4],
	   d_pend_patient_id             [21],
	   d_pend_billing_group          [5],   -- CRF-0120
	   d_customer_status             [4],
	   d_customer_patient_flag       [4],
	   d_pmnt_terms_status           [4],
       d_cust_trn_temp_doc_type      [8],
	   d_cust_trn_temp_doc_num       [12],
	   d_pend_rowid                  [31],
	   d_pend_doc_date               [12],
	   d_pend_narration              [52],
	   d_pend_post_month             [4],
	   d_pend_post_year              [5],
 
	   d_cust_trn_rowid              [31],
	   d_cust_trn_line_num           [8],
	   d_sy_acc_bl_instal_flag       [4],
	   d_sy_acc_mp_instal_flag       [4],
	   nd_error_flag                 [4],
	   dummy                         [10][10],
	   d_ar_acc_status               [4],
	   d_ar_acc_valid_flag           [4],

	   d_main_acc1_code              [8],
	   d_main_acc2_code              [8],
	   d_dept_code                   [11],
	   d_product_group_code          [4],
	   d_product_line_code           [8],
	   d_subledger_group_code        [4],
	   d_subledger_line_code         [12],
	   d_bl_blng_grp_status          [2],


	    nd_acc_entity_code             [5],
	    p_operational_modules          [300],
		d_consolidated_yn              [2],
		d_module_valid_id              [3],
		


	   d_pend_trn_type_code          [3],
	   d_check_trn_type_code         [3],
	   d_cust_trn_type_code          [3],
	   d_consolidated_inv_yn         [2], 

	   d_ar_trn_type_code            [3],

	   ar_pat_doc_type_code          [7],
	   ar_pat_doc_num                [9],
	   ar_pat_patient_id             [21],
	   ar_pat_bill_doc_type_code     [7],
	   ar_pat_bill_num               [9],
	   ar_pat_remarks                [16],
	   ar_pat_bill_date              [12],
	   ar_pat_rowid                  [31]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[8]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[12]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[8]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[8]; } d_pend_doc_type_code;

struct { unsigned short len; unsigned char arr[8]; } d_check_doc_type_code;

struct { unsigned short len; unsigned char arr[12]; } d_pend_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_pend_cust_code;

struct { unsigned short len; unsigned char arr[4]; } d_pend_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[21]; } d_pend_patient_id;

struct { unsigned short len; unsigned char arr[5]; } d_pend_billing_group;

struct { unsigned short len; unsigned char arr[4]; } d_customer_status;

struct { unsigned short len; unsigned char arr[4]; } d_customer_patient_flag;

struct { unsigned short len; unsigned char arr[4]; } d_pmnt_terms_status;

struct { unsigned short len; unsigned char arr[8]; } d_cust_trn_temp_doc_type;

struct { unsigned short len; unsigned char arr[12]; } d_cust_trn_temp_doc_num;

struct { unsigned short len; unsigned char arr[31]; } d_pend_rowid;

struct { unsigned short len; unsigned char arr[12]; } d_pend_doc_date;

struct { unsigned short len; unsigned char arr[52]; } d_pend_narration;

struct { unsigned short len; unsigned char arr[4]; } d_pend_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_pend_post_year;

struct { unsigned short len; unsigned char arr[31]; } d_cust_trn_rowid;

struct { unsigned short len; unsigned char arr[8]; } d_cust_trn_line_num;

struct { unsigned short len; unsigned char arr[4]; } d_sy_acc_bl_instal_flag;

struct { unsigned short len; unsigned char arr[4]; } d_sy_acc_mp_instal_flag;

struct { unsigned short len; unsigned char arr[4]; } nd_error_flag;

struct { unsigned short len; unsigned char arr[10]; } dummy[10];

struct { unsigned short len; unsigned char arr[4]; } d_ar_acc_status;

struct { unsigned short len; unsigned char arr[4]; } d_ar_acc_valid_flag;

struct { unsigned short len; unsigned char arr[8]; } d_main_acc1_code;

struct { unsigned short len; unsigned char arr[8]; } d_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } d_dept_code;

struct { unsigned short len; unsigned char arr[4]; } d_product_group_code;

struct { unsigned short len; unsigned char arr[8]; } d_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } d_subledger_group_code;

struct { unsigned short len; unsigned char arr[12]; } d_subledger_line_code;

struct { unsigned short len; unsigned char arr[2]; } d_bl_blng_grp_status;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[300]; } p_operational_modules;

struct { unsigned short len; unsigned char arr[2]; } d_consolidated_yn;

struct { unsigned short len; unsigned char arr[3]; } d_module_valid_id;

struct { unsigned short len; unsigned char arr[3]; } d_pend_trn_type_code;

struct { unsigned short len; unsigned char arr[3]; } d_check_trn_type_code;

struct { unsigned short len; unsigned char arr[3]; } d_cust_trn_type_code;

struct { unsigned short len; unsigned char arr[2]; } d_consolidated_inv_yn;

struct { unsigned short len; unsigned char arr[3]; } d_ar_trn_type_code;

struct { unsigned short len; unsigned char arr[7]; } ar_pat_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_doc_num;

struct { unsigned short len; unsigned char arr[21]; } ar_pat_patient_id;

struct { unsigned short len; unsigned char arr[7]; } ar_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_bill_num;

struct { unsigned short len; unsigned char arr[16]; } ar_pat_remarks;

struct { unsigned short len; unsigned char arr[12]; } ar_pat_bill_date;

struct { unsigned short len; unsigned char arr[31]; } ar_pat_rowid;


   double  d_pend_pending_amt,
	   nd_dtl_tot_amt,
	   d_cust_trn_temp_amount,
	   ar_pat_amount,
	   ar_pat_alloc_amt,
	   ar_pat_tot_amt;

   int     d_sy_num_acc_per,
	   proc_rep_flag,
	   ar_pat_line_num;

	int    bl_instal_flag ,  mp_instal_flag, nd_no_of_decimal;


   long    d_pend_doc_date_yyyymmdd;

/* EXEC SQL END DECLARE SECTION; */ 
  

int g_err_typ;

char g_err_id[10],
     g_err_msg[80];

int  d_curr_year;
int  d_curr_month;
int  d_num_of_acc_periods;
char d_summ_flag;



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

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"ARBOPDOC");

   strcpy(g_facility_id,argv[4]);

   if(sql_connect() == -1)
   {
      sprintf(mesg1,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0){
	 sprintf(mesg1,"Null oracle uid/pwd\n\n\n");
	 disp_message(ERR_MESG,mesg1);
	 }
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
       

   set_meduser_role();

	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;
   
   chk_active();

   nd_fm_cust_code.arr[0]       = '\0';
   nd_fm_doc_type.arr[0]        = '\0';
   nd_to_cust_code.arr[0]       = '\0';
   nd_to_doc_type.arr[0]        = '\0';

   nd_fm_cust_code.len          = 0;
   nd_fm_doc_type.len           = 0;
   nd_to_cust_code.len          = 0;
   nd_to_doc_type.len           = 0;

   proc_rep_flag                = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID ,PARAM1,PARAM2,PARAM3
	      INTO :nd_facility_id, :nd_fm_cust_code,
		   :nd_to_cust_code,
		   :proc_rep_flag
	      FROM SY_PROG_PARAM
	     WHERE PGM_ID     = 'ARROPDOC'
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 into \
:b0,:b1,:b2,:b3  from SY_PROG_PARAM where ((PGM_ID='ARROPDOC' and SESSION_ID=:\
b4) and PGM_DATE=:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&proc_rep_flag;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
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
   sqlstm.sqhstl[5] = (unsigned int  )37;
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

   if (NOT_FOUND)
	err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_fm_cust_code.arr[nd_fm_cust_code.len]        = '\0';
   nd_fm_doc_type.arr[nd_fm_doc_type.len]          = '\0';
   nd_to_cust_code.arr[nd_to_cust_code.len]        = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]          = '\0';

   start_prog_control();
   start_prog_msg();
   
   strcpy(nd_error_flag.arr,"N");
   nd_error_flag.len = 1;

   delete_records();
  
   fetch_acc_entity_flag();

   declare_cursor();

   open_pend_tmp_cur();

   while (fetch_cur())
   {
	/* EXEC SQL SELECT  ROWID
		   INTO  :d_pend_rowid
		   FROM  AR_PENDING_DOC_TEMP
		  WHERE  ROWID = :d_pend_rowid
		    FOR  UPDATE OF ERROR_FLAG NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ROWID into :b0  from AR_PENDING_DOC_TEMP where ROWID=\
:b0 for update of ERROR_FLAG nowait ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )44;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_pend_rowid;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_pend_rowid;
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
}


     
	if (RESOURCE_BUSY)
	      continue;
	if (OERROR)
	   err_mesg("SELECT failed on table AR_PENDING_DOC_TEMP",0,"");

	if (sqlca.sqlerrd[2] == 0)
	      continue;

	strcpy(nd_error_flag.arr,"N");
	nd_error_flag.len = 1;
 
	validate_pending_doc();
   
	if (d_pend_trn_type_code.arr[0] == '1' &&
	     		(strcmp(d_consolidated_inv_yn.arr , "Y") == 0))


		        /*d_customer_patient_flag.arr[0] == 'Y') */

	{
	     ar_pat_tot_amt = 0;

	     if (!open_patient_dtls())
		  continue;

	     ar_pat_line_num = 1;

	     while (fetch_patient_dtls())
	     {
		  validate_patient_dtls();
		  update_pat_dtls();
	     }

	     if ((ar_pat_line_num != 1) &&
		(doubcmp(ar_pat_tot_amt,d_pend_pending_amt) != 0))
		   error_insert_pat(" HDR","AR2180","");
	}
  
	if (!open_cust_trn_temp())
	      continue;

	nd_dtl_tot_amt  =  0;
	while (fetch_cust_trn_temp())
	{
	    validate_cust_trn();
	    nd_dtl_tot_amt += d_cust_trn_temp_amount;
	}

/*        if (nd_dtl_tot_amt != d_pend_pending_amt)*/

	if (doubcmp(nd_dtl_tot_amt,d_pend_pending_amt) != 0)
	   error_insert(" HDR","AR1200");

	update_err_flg();
	if (nd_error_flag.arr[0]  ==  'N')
	     doc_post();
	/* EXEC SQL COMMIT WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )67;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
	    err_mesg("COMMIT failed",0,"");
   }

   if (proc_rep_flag == 3)
   {
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )82;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
	err_mesg("COMMIT failed",0,"");

  /*  run_report(); */

    if(sql_connect() == -1)
    {
      disp_message(ERR_MESG,"Error in connecting to Oracle - 2 time");
      proc_exit();
    }
   }

/*   delete_records();*/
   end_prog_msg();
   end_prog_control();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )97;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



} 

fetch_acc_entity_flag()
{
                
   
   /*EXEC SQL SELECT BL_INSTAL_FLAG,  MP_INSTAL_FLAG, NUM_OF_ACC_PERIODS
	      INTO :d_sy_acc_bl_instal_flag, :d_sy_acc_mp_instal_flag,
		   :d_sy_num_acc_per
	      FROM SY_ACC_ENTITY;*/



	   /* EXEC SQL SELECT  NUM_OF_ACC_PERIODS , ACC_ENTITY_CODE,
	                    NO_OF_DECIMAL
              INTO   :d_sy_num_acc_per, :nd_acc_entity_code,
			         :nd_no_of_decimal
              FROM SY_ACC_ENTITY
		   where   ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NUM_OF_ACC_PERIODS ,ACC_ENTITY_CODE ,NO_OF_DECIMAL\
 into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )112;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_sy_num_acc_per;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_acc_entity_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_no_of_decimal;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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




   if (OERROR)
	err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");


	/* EXEC SQL EXECUTE 
            BEGIN
	         GET_INSTALLED_MODULES(:p_operational_modules);
            END;
    END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin GET_INSTALLED_MODULES ( :p_operational_modules ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )143;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_operational_modules;
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

 

	/* EXEC SQL SELECT INSTR(:p_operational_modules , 'BL|')
	         into   :bl_instal_flag 
			from dual ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INSTR(:b0,'BL|') into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )162;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_operational_modules;
 sqlstm.sqhstl[0] = (unsigned int  )302;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_instal_flag;
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



	/* EXEC SQL SELECT INSTR(:p_operational_modules , 'MP|')
	         into   :mp_instal_flag
			from dual ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INSTR(:b0,'MP|') into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )185;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_operational_modules;
 sqlstm.sqhstl[0] = (unsigned int  )302;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&mp_instal_flag;
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



   
	 if (bl_instal_flag > 0 )
	 {
         strcpy(d_sy_acc_bl_instal_flag.arr , "Y");
	  }
	else
	{

          strcpy(d_sy_acc_bl_instal_flag.arr , "N");   
	 }

	  if (mp_instal_flag > 0 )
	 {
         strcpy(d_sy_acc_mp_instal_flag.arr , "Y");
	  }
	else
	{

          strcpy(d_sy_acc_mp_instal_flag.arr , "N");   
	 }




   
}

declare_cursor()
{

   /* EXEC SQL DECLARE AR_PENDING_DOC_TEMP_CUR CURSOR FOR
	     SELECT DOC_TYPE_CODE,
		    DOC_NUM,
		    CUST_CODE,
		    PMNT_TERMS_CODE,
		    PATIENT_ID,
		    BILLING_GROUP,
		    PENDING_AMT,
		    MAIN_ACC1_CODE,
		    MAIN_ACC2_CODE,
		    DEPT_CODE,
		    PRODUCT_GROUP_CODE,
		    PRODUCT_LINE_CODE,
		    SUBLEDGER_GROUP_CODE,
		    SUBLEDGER_LINE_CODE,
		    ROWID,
		    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
		    NARRATION,
		    POST_MONTH,
		    POST_YEAR,
		    TRN_TYPE_CODE,
			NVL(CONSOLIDATED_INV_YN,'N')
	       FROM AR_PENDING_DOC_TEMP
	      WHERE CUST_CODE >= nvl(:nd_fm_cust_code,'        ')
		AND CUST_CODE <= nvl(:nd_to_cust_code,'~~~~~~~~'); */ 


   /* EXEC SQL DECLARE SY_DOC_CONTROL_CUR CURSOR FOR
	     SELECT 'X'
	       FROM SY_DOC_CONTROL
	      WHERE MODULE_ID     = 'AR'
		AND DOC_TYPE_CODE = :d_pend_doc_type_code
		AND DOC_NUM       = :d_pend_doc_num; */ 


   /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
	     SELECT NVL(STATUS,'X'),
		    PATIENT_FLAG  
	       FROM AR_CUSTOMER
	      WHERE CUST_CODE        = :d_pend_cust_code; */ 


   /* EXEC SQL DECLARE AR_PMNT_TERMS_CUR CURSOR FOR
	     SELECT NVL(STATUS,'X')
	       FROM AR_PMNT_TERMS
	      WHERE PMNT_TERMS_CODE = :d_pend_pmnt_terms_code; */ 


   /* EXEC SQL DECLARE AR_CUST_TRN_TEMP_CUR CURSOR FOR
	     SELECT DOC_TYPE_CODE,
		    DOC_NUM,
		    AMOUNT,
		    LINE_NUM,
		    TRN_TYPE_CODE
	       FROM AR_CUST_TRN_TEMP
	      WHERE ORG_DOC_TYPE_CODE = :d_pend_doc_type_code
		AND ORG_DOC_NUM       = :d_pend_doc_num
		FOR UPDATE OF LINE_NUM NOWAIT; */ 


   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
	     SELECT NVL(STATUS,'X'),
		    NVL(AR_VALID_FLAG,'X')
	       FROM GL_ACC_ENTITY_DOC_TYPE_VW
	      WHERE DOC_TYPE_CODE   = :d_check_doc_type_code; */ 


   /* EXEC SQL DECLARE SY_DOC_CONTROL_TRN_CUR CURSOR FOR
	     SELECT 'X'
	       FROM SY_DOC_CONTROL
	      WHERE DOC_TYPE_CODE     = :d_cust_trn_temp_doc_type
		AND DOC_NUM           = :d_cust_trn_temp_doc_num; */ 


   /* EXEC SQL DECLARE AR_TRN_DOC_TYPE_CUR CURSOR FOR
	     SELECT TRN_TYPE_CODE
	       FROM AR_TRN_DOC_TYPE
	      WHERE DOC_TYPE_CODE = :d_check_doc_type_code
		AND TRN_TYPE_CODE = :d_check_trn_type_code; */ 


   /* EXEC SQL DECLARE AR_PATIENT_DTLS_CUR CURSOR FOR
	     SELECT DOC_TYPE_CODE,
		    DOC_NUM,
		    PATIENT_ID,
		    BILL_DOC_TYPE_CODE,
		    BILL_NUM,
		    TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
		    REMARKS,
		    NVL(AMOUNT,0),
		    TO_CHAR(TO_DATE(:d_pend_doc_date,'DD/MM/YYYY'),'YYYYMMDD'),
		    ROWID
	       FROM AR_PATIENT_DTLS
	      WHERE DOC_TYPE_CODE = :d_pend_doc_type_code
		AND DOC_NUM       = :d_pend_doc_num
	      ORDER BY BILL_DATE, PATIENT_ID
		FOR UPDATE OF LINE_NUM NOWAIT; */ 


}

open_pend_tmp_cur()
{
   /* EXEC SQL OPEN AR_PENDING_DOC_TEMP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0010;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )208;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[0] = (unsigned int  )14;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )14;
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
	err_mesg("OPEN failed on cursor AR_PENDING_DOC_TEMP_CUR",0,"");
}

fetch_cur()
{
    d_pend_doc_type_code.arr[0]   = '\0';
    d_pend_doc_num.arr[0]         = '\0';
    d_pend_cust_code.arr[0]       = '\0';
    d_pend_pmnt_terms_code.arr[0] = '\0';
    d_pend_patient_id.arr[0]      = '\0';
    d_pend_billing_group.arr[0]   = '\0';

    d_main_acc1_code.arr[0]       = '\0';
    d_main_acc2_code.arr[0]       = '\0';
    d_dept_code.arr[0]            = '\0';
    d_product_group_code.arr[0]   = '\0';
    d_product_line_code.arr[0]    = '\0';
    d_subledger_group_code.arr[0] = '\0';
    d_subledger_line_code.arr[0]  = '\0';

    d_pend_doc_date.arr[0]        = '\0';
    d_pend_narration.arr[0]       = '\0';
    d_pend_post_month.arr[0]      = '\0';
    d_pend_post_year.arr[0]       = '\0';

    d_pend_trn_type_code.arr[0]   = '\0';
	d_consolidated_inv_yn.arr[0]  = '\0';

    d_pend_doc_type_code.len   = 0;
    d_pend_doc_num.len         = 0;
    d_pend_cust_code.len       = 0;
    d_pend_pmnt_terms_code.len = 0;
    d_pend_patient_id.len      = 0;
    d_pend_billing_group.len   = 0;

    d_main_acc1_code.len       = 0;
    d_main_acc2_code.len       = 0;
    d_dept_code.len            = 0;
    d_product_group_code.len   = 0;
    d_product_line_code.len    = 0;
    d_subledger_group_code.len = 0;
    d_subledger_line_code.len  = 0;
    d_pend_doc_date.len        = 0;
    d_pend_narration.len       = 0;
    d_pend_post_month.len      = 0;
    d_pend_post_year.len       = 0;

    d_pend_trn_type_code.len   = 0;
	d_consolidated_inv_yn.len   = 0;

    d_pend_pending_amt         = 0;


	 /* EXEC SQL FETCH AR_PENDING_DOC_TEMP_CUR
	      INTO :d_pend_doc_type_code,
		   :d_pend_doc_num,
		   :d_pend_cust_code,
		   :d_pend_pmnt_terms_code,
		   :d_pend_patient_id,
		   :d_pend_billing_group,
		   :d_pend_pending_amt,
		   :d_main_acc1_code,
		   :d_main_acc2_code,
		   :d_dept_code,
		   :d_product_group_code,
		   :d_product_line_code,
		   :d_subledger_group_code,
		   :d_subledger_line_code,
		   :d_pend_rowid,
		   :d_pend_doc_date,
		   :d_pend_narration,
		   :d_pend_post_month,
		   :d_pend_post_year,
		   :d_pend_trn_type_code,
		   :d_consolidated_inv_yn; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )231;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )10;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
  sqlstm.sqhstl[1] = (unsigned int  )14;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_pend_cust_code;
  sqlstm.sqhstl[2] = (unsigned int  )14;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_pend_pmnt_terms_code;
  sqlstm.sqhstl[3] = (unsigned int  )6;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_pend_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_pend_billing_group;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_pend_pending_amt;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_main_acc1_code;
  sqlstm.sqhstl[7] = (unsigned int  )10;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_main_acc2_code;
  sqlstm.sqhstl[8] = (unsigned int  )10;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_dept_code;
  sqlstm.sqhstl[9] = (unsigned int  )13;
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
  sqlstm.sqhstl[11] = (unsigned int  )10;
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
  sqlstm.sqhstl[13] = (unsigned int  )14;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_pend_rowid;
  sqlstm.sqhstl[14] = (unsigned int  )33;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_pend_doc_date;
  sqlstm.sqhstl[15] = (unsigned int  )14;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_pend_narration;
  sqlstm.sqhstl[16] = (unsigned int  )54;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_pend_post_month;
  sqlstm.sqhstl[17] = (unsigned int  )6;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&d_pend_post_year;
  sqlstm.sqhstl[18] = (unsigned int  )7;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&d_pend_trn_type_code;
  sqlstm.sqhstl[19] = (unsigned int  )5;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&d_consolidated_inv_yn;
  sqlstm.sqhstl[20] = (unsigned int  )4;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
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
	err_mesg("FETCH failed on cursor AR_PENDING_DOC_TEMP_CUR",0,"");

    d_pend_doc_type_code.arr[d_pend_doc_type_code.len]     = '\0';
    d_pend_doc_num.arr[d_pend_doc_num.len]                 = '\0';
    d_pend_cust_code.arr[d_pend_cust_code.len]             = '\0';
    d_pend_pmnt_terms_code.arr[d_pend_pmnt_terms_code.len] = '\0';
    d_pend_patient_id.arr[d_pend_patient_id.len]           = '\0';
    d_pend_billing_group.arr[d_pend_billing_group.len]     = '\0';

    d_main_acc1_code.arr[d_main_acc1_code.len]             = '\0';
    d_main_acc2_code.arr[d_main_acc2_code.len]             = '\0';
    d_dept_code.arr[d_dept_code.len]                       = '\0';
    d_product_group_code.arr[d_product_group_code.len]     = '\0';
    d_product_line_code.arr[d_product_line_code.len]       = '\0';
    d_subledger_group_code.arr[d_subledger_group_code.len] = '\0';
    d_subledger_line_code.arr[d_subledger_line_code.len]   = '\0';
    d_pend_rowid.arr[d_pend_rowid.len]                     = '\0';

    d_pend_doc_date.arr[d_pend_doc_date.len]               = '\0';
    d_pend_narration.arr[d_pend_narration.len]             = '\0';
    d_pend_post_month.arr[d_pend_post_month.len]           = '\0';
    d_pend_post_year.arr[d_pend_post_year.len]             = '\0';

    d_pend_trn_type_code.arr[d_pend_trn_type_code.len]     = '\0';
	d_consolidated_inv_yn.arr[d_consolidated_inv_yn.len]   = '\0';

    if (LAST_ROW)
	 return (0);
    else 
	 return (1);
}

validate_pending_doc()
{
   strcpy(d_check_doc_type_code.arr,d_pend_doc_type_code.arr);
   d_check_doc_type_code.len = strlen(d_check_doc_type_code.arr);

   /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0015;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )330;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_check_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )10;
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


 
   if (OERROR) err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,"");

   d_ar_acc_status.arr[0]     = '\0';
   d_ar_acc_valid_flag.arr[0] = '\0';

   d_ar_acc_valid_flag.len = 0;
   d_ar_acc_status.len     = 0;

   /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
	     INTO :d_ar_acc_status,
		  :d_ar_acc_valid_flag; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )349;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_acc_status;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_acc_valid_flag;
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


   
   if (OERROR)
	err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,""); 

   d_ar_acc_status.arr[d_ar_acc_status.len]         = '\0';
   d_ar_acc_valid_flag.arr[d_ar_acc_valid_flag.len] = '\0';

   if (NOT_FOUND)
	 error_insert(" HDR","SY1610");
   else
   {
      if (d_ar_acc_valid_flag.arr[0] != 'Y')
	    error_insert(" HDR","SY1700");
      if (d_ar_acc_status.arr[0] == 'S')
	    error_insert(" HDR","SY1640");
   } 

   d_ar_trn_type_code.arr[0] = '\0';
   d_ar_trn_type_code.len    = 0;

   strcpy(d_check_trn_type_code.arr,d_pend_trn_type_code.arr);
   d_check_trn_type_code.len = strlen(d_check_trn_type_code.arr);

   strcpy(d_check_doc_type_code.arr,d_pend_doc_type_code.arr);
   d_check_doc_type_code.len = strlen(d_check_doc_type_code.arr);

   /* EXEC SQL OPEN AR_TRN_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0017;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )372;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_check_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_check_trn_type_code;
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
	 err_mesg("OPEN failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   /* EXEC SQL FETCH AR_TRN_DOC_TYPE_CUR
	     INTO :d_ar_trn_type_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )395;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_trn_type_code;
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



   d_ar_trn_type_code.arr[d_ar_trn_type_code.len] = '\0';

   if (OERROR)
	 err_mesg("FETCH failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   if (NOT_FOUND)
	 error_insert(" HDR","AR2030");

   /****  AR_PENDING_DOC Validation   ******/

   /* EXEC SQL OPEN SY_DOC_CONTROL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )414;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )14;
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
	err_mesg("OPEN failed on cursor SY_DOC_CONTROL_CUR",0,"");

   /* EXEC SQL FETCH SY_DOC_CONTROL_CUR
	     INTO :dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )437;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)dummy;
   sqlstm.sqhstl[0] = (unsigned int  )12;
   sqlstm.sqhsts[0] = (         int  )12;
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


   
   if (OERROR)
	err_mesg("FETCH failed on cursor SY_DOC_CONTROL_CUR",0,"");

   if (!NOT_FOUND)   /*   Record Exists   */
	error_insert(" HDR","AR1080");
  
   /****   AR_CUSTOMER Validation   *****/
  
   /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )456;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pend_cust_code;
   sqlstm.sqhstl[0] = (unsigned int  )14;
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
	err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");

   d_customer_status.arr[0]       = '\0';
   d_customer_patient_flag.arr[0] = '\0';

   d_customer_status.len       = 0;
   d_customer_patient_flag.len = 0;

   /* EXEC SQL FETCH AR_CUSTOMER_CUR
	     INTO :d_customer_status,
		  :d_customer_patient_flag; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )475;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_customer_status;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_customer_patient_flag;
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



   d_customer_status.arr[d_customer_status.len] = '\0';
   d_customer_patient_flag.arr[d_customer_patient_flag.len] = '\0';

   if (OERROR)
	err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

   if (NOT_FOUND)
	error_insert(" HDR","AR1210");
   else
     if (d_customer_status.arr[0] == 'S')
	error_insert(" HDR","AR1220");

   /****   AR_PMNT_TERMS  Validation   *****/

   /* EXEC SQL OPEN AR_PMNT_TERMS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0013;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )498;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pend_pmnt_terms_code;
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
	err_mesg("OPEN failed on cursor AR_PMNT_TERMS_CUR",0,"");

   d_pmnt_terms_status.arr[0] = '\0';
   d_pmnt_terms_status.len    = 0;

   /* EXEC SQL FETCH AR_PMNT_TERMS_CUR
	     INTO :d_pmnt_terms_status; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )517;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_pmnt_terms_status;
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



   d_pmnt_terms_status.arr[d_pmnt_terms_status.len] = '\0';
   if (OERROR)
	err_mesg("FETCH failed on cursor AR_PMNT_TERMS_CUR",0,"");
   if (NOT_FOUND)
	error_insert(" HDR","AR1240");
   else
      if (d_pmnt_terms_status.arr[0] == 'S')
	   error_insert(" HDR","AR1250");

   /****   PATIENT_MAST & BL_BLNG_GRP Validation    *****/

   if (d_customer_patient_flag.arr[0] == 'Y' && d_consolidated_inv_yn.arr[0]=='N')
   {
      if (d_sy_acc_bl_instal_flag.arr[0] == 'Y')
      {
	  d_bl_blng_grp_status.arr[0] = '\0';
	  d_bl_blng_grp_status.len    = 0;

	  /* EXEC SQL SELECT NVL(STATUS,'X')
		     INTO :d_bl_blng_grp_status
		     FROM BL_BLNG_GRP
		    WHERE BLNG_GRP_ID  = :d_pend_billing_group; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(STATUS,'X') into :b0  from BL_BLNG_GRP where BL\
NG_GRP_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )536;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_bl_blng_grp_status;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pend_billing_group;
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



	  d_bl_blng_grp_status.arr[d_bl_blng_grp_status.len] = '\0';

	  if (OERROR)
	      err_mesg("SELECT failed on table BL_BLNG_GRP",0,"");

	  if (NOT_FOUND)
	     error_insert(" HDR","SY0110");
	  else if (d_bl_blng_grp_status.arr[0] == 'S')
	     error_insert(" HDR","BL0026");

      }
      if (d_sy_acc_mp_instal_flag.arr[0] == 'Y')
      {

	  /* EXEC SQL SELECT 'X'
		     INTO :dummy
		     FROM MP_PATIENT_MAST
		    WHERE PATIENT_ID  = :d_pend_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select 'X' into :b0  from MP_PATIENT_MAST where PATIENT_ID\
=:b1";
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )559;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)dummy;
   sqlstm.sqhstl[0] = (unsigned int  )12;
   sqlstm.sqhsts[0] = (         int  )12;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqharc[0] = (unsigned int   *)0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pend_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )23;
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
	     err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

	  if (NOT_FOUND)
	     error_insert(" HDR","SY2021");
      }
   }
   if (atoi(d_pend_post_month.arr) > d_sy_num_acc_per)
	   error_insert(" HDR","GL2290");

   validate_posting();
}

open_cust_trn_temp()
{
   /* EXEC SQL OPEN AR_CUST_TRN_TEMP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0014;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )582;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )14;
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



   if (RESOURCE_BUSY)
   {
     error_insert(" HDR","AR2070");
     update_err_flg();
     /* EXEC SQL COMMIT WORK; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 21;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )605;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     return (0);
   }
   else if (OERROR)
	err_mesg("OPEN failed on cursor AR_CUST_TRN_TEMP_CUR",0,"");
   return (1);
}
 
fetch_cust_trn_temp()
{
   d_cust_trn_temp_doc_type.arr[0] = '\0';
   d_cust_trn_temp_doc_num.arr[0]       = '\0';
   d_cust_trn_line_num.arr[0]           = '\0';
   d_cust_trn_type_code.arr[0]          = '\0';

   d_cust_trn_temp_doc_type.len    = 0;
   d_cust_trn_temp_doc_num.len          = 0;
   d_cust_trn_line_num.len              = 0;
   d_cust_trn_type_code.len             = 0;

   d_cust_trn_temp_amount               = 0;

   /* EXEC SQL FETCH AR_CUST_TRN_TEMP_CUR
	     INTO :d_cust_trn_temp_doc_type,
		  :d_cust_trn_temp_doc_num,
		  :d_cust_trn_temp_amount,
		  :d_cust_trn_line_num,
		  :d_cust_trn_type_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )620;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_cust_trn_temp_doc_type;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_cust_trn_temp_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cust_trn_temp_amount;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_cust_trn_line_num;
   sqlstm.sqhstl[3] = (unsigned int  )10;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_cust_trn_type_code;
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



   d_cust_trn_temp_doc_type.arr[d_cust_trn_temp_doc_type.len] = '\0';
   d_cust_trn_temp_doc_num.arr[d_cust_trn_temp_doc_num.len]             = '\0';
   d_cust_trn_line_num.arr[d_cust_trn_line_num.len]                     = '\0';
   d_cust_trn_type_code.arr[d_cust_trn_type_code.len]                   = '\0';

   if (OERROR)
	err_mesg("FETCH failed on cursor AR_CUST_TRN_TEMP_CUR",0,"");

   if (LAST_ROW)
       return (0);
   else 
       return (1);
}

open_patient_dtls()
{
   /* EXEC SQL OPEN AR_PATIENT_DTLS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0018;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )655;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_date;
   sqlstm.sqhstl[0] = (unsigned int  )14;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )10;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_pend_doc_num;
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



   if (RESOURCE_BUSY)
   {
     error_insert(" HDR","AR2070");
     update_err_flg();
     /* EXEC SQL COMMIT WORK; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 21;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )682;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     return (0);
   }
   else if (OERROR)
	err_mesg("OPEN failed on cursor AR_PATIENT_DTLS_CUR",0,"");

   return (1);
}

fetch_patient_dtls()
{
ar_pat_doc_type_code.arr[0]       = '\0';
ar_pat_doc_num.arr[0]             = '\0';
ar_pat_patient_id.arr[0]          = '\0';
ar_pat_bill_doc_type_code.arr[0]  = '\0';
ar_pat_bill_num.arr[0]            = '\0';
ar_pat_bill_date.arr[0]           = '\0';
ar_pat_remarks.arr[0]             = '\0';
ar_pat_rowid.arr[0]               = '\0';

ar_pat_doc_type_code.len          = 0;
ar_pat_doc_num.len                = 0;
ar_pat_patient_id.len             = 0;
ar_pat_bill_doc_type_code.len     = 0;
ar_pat_bill_num.len               = 0;
ar_pat_bill_date.len              = 0;
ar_pat_remarks.len                = 0;
ar_pat_rowid.len                  = 0;

ar_pat_amount                     = 0;
d_pend_doc_date_yyyymmdd          = 0;

   /* EXEC SQL FETCH AR_PATIENT_DTLS_CUR
	     INTO :ar_pat_doc_type_code,
		  :ar_pat_doc_num,
		  :ar_pat_patient_id,
		  :ar_pat_bill_doc_type_code,
		  :ar_pat_bill_num,
		  :ar_pat_bill_date,
		  :ar_pat_remarks,
		  :ar_pat_amount,
		  :d_pend_doc_date_yyyymmdd,
		  :ar_pat_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )697;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&ar_pat_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_pat_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_pat_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_pat_bill_num;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ar_pat_bill_date;
   sqlstm.sqhstl[5] = (unsigned int  )14;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ar_pat_remarks;
   sqlstm.sqhstl[6] = (unsigned int  )18;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ar_pat_amount;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_pend_doc_date_yyyymmdd;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&ar_pat_rowid;
   sqlstm.sqhstl[9] = (unsigned int  )33;
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



   if (OERROR)
       err_mesg("FETCH failed on cursor AR_PATIENT_DTLS_CUR",0,"");

ar_pat_doc_type_code.arr[ar_pat_doc_type_code.len]           = '\0';
ar_pat_doc_num.arr[ar_pat_doc_num.len]                       = '\0';
ar_pat_patient_id.arr[ar_pat_patient_id.len]                 = '\0';
ar_pat_bill_doc_type_code.arr[ar_pat_bill_doc_type_code.len] = '\0';
ar_pat_bill_num.arr[ar_pat_bill_num.len]                     = '\0';
ar_pat_bill_date.arr[ar_pat_bill_date.len]                   = '\0';
ar_pat_remarks.arr[ar_pat_remarks.len]                       = '\0';
ar_pat_rowid.arr[ar_pat_rowid.len]                           = '\0';

   if (LAST_ROW)
       return (0);
   else 
       return (1);
}

validate_patient_dtls()
{
   if (ar_pat_patient_id.len == 0)
	    error_insert_pat(" HDR","SY1470","Field = PATIENT NO ");
   else if (d_sy_acc_mp_instal_flag.arr[0] == 'Y')
   {
	/* EXEC SQL SELECT 'X'
		   INTO :dummy
		   FROM MP_PATIENT_MAST
		  WHERE PATIENT_ID  = :ar_pat_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 21;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select 'X' into :b0  from MP_PATIENT_MAST where PATIENT_ID=:\
b1";
 sqlstm.iters = (unsigned int  )10;
 sqlstm.offset = (unsigned int  )752;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)dummy;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )12;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqharc[0] = (unsigned int   *)0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ar_pat_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )23;
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
	     err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

	 if (NOT_FOUND)
	    error_insert_pat(" HDR","SY2021","");
   }

   if (ar_pat_bill_doc_type_code.len == 0)
	 error_insert_pat(" HDR","SY1470","Field = BILL DOC TYPE ");
   else
   {
	 strcpy(d_check_doc_type_code.arr,ar_pat_bill_doc_type_code.arr);
	 d_check_doc_type_code.len = strlen(d_check_doc_type_code.arr);

	 /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0015;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )775;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_check_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )10;
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
	     err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,"");

	 d_ar_acc_status.arr[0]     = '\0';
	 d_ar_acc_valid_flag.arr[0] = '\0';
	 d_ar_acc_valid_flag.len = 0;
	 d_ar_acc_status.len     = 0;

	 /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
		   INTO :d_ar_acc_status,
			:d_ar_acc_valid_flag; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )794;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_ar_acc_status;
  sqlstm.sqhstl[0] = (unsigned int  )6;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_ar_acc_valid_flag;
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


	 if (OERROR)
	     err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,""); 
	 d_ar_acc_status.arr[d_ar_acc_status.len]         = '\0';
	 d_ar_acc_valid_flag.arr[d_ar_acc_valid_flag.len] = '\0';

	 if (NOT_FOUND)
	       error_insert_pat(" HDR","SY1610","");
	 else
	 {
	      if (d_ar_acc_status.arr[0] == 'S')
		    error_insert_pat(" HDR","SY1640","");
	   } 
      }

      if (atol(ar_pat_bill_date.arr) > d_pend_doc_date_yyyymmdd)
	    error_insert_pat(" HDR","AR1170","");

      if (ar_pat_bill_num.len == 0)
	    error_insert_pat(" HDR","SY1470","Field = BILL NUM ");
      if (ar_pat_bill_date.len == 0)
	    error_insert_pat(" HDR","SY1470","Field = BILL DATE ");
     /* if (ar_pat_remarks.len == 0)
	    error_insert_pat(" HDR","SY1470","Field = REMARKS ");*/
      if (ar_pat_amount == 0)
	    error_insert_pat(" HDR","SY1470","Field = AMOUNT ");

  ar_pat_tot_amt += ar_pat_amount;
}

update_pat_dtls()
{
    /* EXEC SQL UPDATE AR_PATIENT_DTLS
		SET LINE_NUM = :ar_pat_line_num
	      WHERE ROWID    = :ar_pat_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_PATIENT_DTLS  set LINE_NUM=:b0 where ROWID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )817;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&ar_pat_line_num;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&ar_pat_rowid;
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
}



     if (OERROR)
	 err_mesg("UPDATE failed on table AR_PATIENT_DTLS",0,"");

    ar_pat_line_num ++;

}

validate_cust_trn()
{
   strcpy(d_check_doc_type_code.arr,d_cust_trn_temp_doc_type.arr);
   d_check_doc_type_code.len = strlen(d_check_doc_type_code.arr);

   /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0015;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )840;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_check_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )10;
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


 
   if (OERROR) err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,"");

   d_ar_acc_status.arr[0]     = '\0';
   d_ar_acc_valid_flag.arr[0] = '\0';

   d_ar_acc_valid_flag.len = 0;
   d_ar_acc_status.len     = 0;

   /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
	     INTO :d_ar_acc_status,
		  :d_ar_acc_valid_flag; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )859;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_acc_status;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_acc_valid_flag;
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


   
   if (OERROR)
	err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,""); 

   d_ar_acc_status.arr[d_ar_acc_status.len]         = '\0';
   d_ar_acc_valid_flag.arr[d_ar_acc_valid_flag.len] = '\0';

   if (NOT_FOUND)
	 error_insert(d_cust_trn_line_num.arr,"SY1610");
   else
   {
      if (d_ar_acc_valid_flag.arr[0] != 'Y')
	    error_insert(d_cust_trn_line_num.arr,"SY1700");
      if (d_ar_acc_status.arr[0] == 'S')
	    error_insert(d_cust_trn_line_num.arr,"SY1640");
    }

   d_ar_trn_type_code.arr[0] = '\0';
   d_ar_trn_type_code.len    = 0;

   strcpy(d_check_trn_type_code.arr,d_cust_trn_type_code.arr);
   d_check_trn_type_code.len = strlen(d_check_trn_type_code.arr);

   strcpy(d_check_doc_type_code.arr,d_cust_trn_temp_doc_type.arr);
   d_check_doc_type_code.len = strlen(d_check_doc_type_code.arr);

   /* EXEC SQL OPEN AR_TRN_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0017;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )882;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_check_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_check_trn_type_code;
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
	 err_mesg("OPEN failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   /* EXEC SQL FETCH AR_TRN_DOC_TYPE_CUR
	     INTO :d_ar_trn_type_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )905;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_trn_type_code;
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



   d_ar_trn_type_code.arr[d_ar_trn_type_code.len] = '\0';

   if (OERROR)
	 err_mesg("FETCH failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   if (NOT_FOUND)
	 error_insert(d_cust_trn_line_num.arr,"AR2030");

   /****   CUST_TRN   Validation   ****/

     /* EXEC SQL OPEN SY_DOC_CONTROL_TRN_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 21;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0016;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )924;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_cust_trn_temp_doc_type;
     sqlstm.sqhstl[0] = (unsigned int  )10;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_cust_trn_temp_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )14;
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
	err_mesg("OPEN failed on cursor SY_DOC_CONTROL_TRN_CUR",0,"");

     /* EXEC SQL FETCH SY_DOC_CONTROL_TRN_CUR
	       INTO :dummy; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 21;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )10;
     sqlstm.offset = (unsigned int  )947;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)dummy;
     sqlstm.sqhstl[0] = (unsigned int  )12;
     sqlstm.sqhsts[0] = (         int  )12;
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


     if (OERROR)
	err_mesg("FETCH failed on cursor SY_DOC_CONTROL_TRN_CUR",0,"");

     if (!NOT_FOUND)
	error_insert(d_cust_trn_line_num.arr,"AR1080");
/*
	ar_pat_alloc_amt = 0;
	
if (strcmp(d_consolidated_inv_yn.arr , "Y") == 0)
   {	
	if ((strcmp( d_cust_trn_temp_doc_type.arr, d_pend_doc_type_code.arr) != 0)
	&& (strcmp( d_cust_trn_temp_doc_num.arr, d_pend_doc_num.arr) != 0))

      {	
	  EXEC SQL SELECT sum(nvl(amount,0)) INTO
			   :ar_pat_alloc_amt
			   FROM
	           ar_patient_alloc_dtls
			   WHERE 
			   doc_type_code = :d_pend_doc_type_code and
			   doc_num = :d_pend_doc_num;

	 if (OERROR)
		err_mesg("SELECT  failed on AR_PATIENT_ALLOC_DTLS",0,"");

	 if (NOT_FOUND)
		error_insert(" PAT","SY1470");


	if (doubcmp(d_cust_trn_temp_amount,ar_pat_alloc_amt) != 0)
	   error_insert(" PAT","AR2180");
	  }
   }
*/
}

error_insert(line_no,msg_id)
char line_no[],msg_id[];
{
   /* EXEC SQL BEGIN DECLARE SECTION; */ 

     /* VARCHAR ar_line_no[5],
	     ar_err_code[7],
	     l_ar_doc_error_text[71]; */ 
struct { unsigned short len; unsigned char arr[5]; } ar_line_no;

struct { unsigned short len; unsigned char arr[7]; } ar_err_code;

struct { unsigned short len; unsigned char arr[71]; } l_ar_doc_error_text;

   /* EXEC SQL END DECLARE SECTION; */ 


   char l_ch_payable_amt  [25],
	l_ch_tot_amt      [25];

   if (strcmp(line_no," HDR") == 0)
       strcpy(ar_line_no.arr,"   0");
   else 
       sprintf(ar_line_no.arr,"%4d",atoi(line_no) + 10);

   ar_line_no.len = strlen(ar_line_no.arr);

   strcpy(ar_err_code.arr,msg_id);
   ar_err_code.len = strlen(ar_err_code.arr);

   l_ar_doc_error_text.arr[0] = '\0';
   l_ar_doc_error_text.len    = 0;

   if (strcmp(ar_err_code.arr,"AR1200") == 0)
   {
       if (nd_no_of_decimal == 3)
	    {
		   sprintf(l_ch_payable_amt,"%19.3f",d_pend_pending_amt);
		   sprintf(l_ch_tot_amt,"%19.3f",nd_dtl_tot_amt);
        }
	   else
	    {
		   sprintf(l_ch_payable_amt,"%19.2f",d_pend_pending_amt);
		   sprintf(l_ch_tot_amt,"%19.2f",nd_dtl_tot_amt);
        }
/*
       ltrim(l_ch_payable_amt);
       ltrim(l_ch_tot_amt);
*/
       format_amt(l_ch_payable_amt,nd_no_of_decimal);
       format_amt(l_ch_tot_amt,nd_no_of_decimal);

       sprintf(l_ar_doc_error_text.arr,"Doc Amt = %s Sum of Trn Amt = %s ",
		   l_ch_payable_amt,l_ch_tot_amt);
       l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);
   }

   /* EXEC SQL INSERT INTO AR_DOC_ERROR
		   (PGM_ID,
		    DOC_TYPE_CODE,    DOC_NUM,
		    LINE_NUM,         ERROR_CODE,
		    ERROR_TEXT)
	    VALUES ('ARBOPDOC',:d_pend_doc_type_code,   :d_pend_doc_num,
		    :ar_line_no,      :ar_err_code,
		    :l_ar_doc_error_text); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (PGM_ID,DOC_TYPE_CODE,DOC_NUM,LIN\
E_NUM,ERROR_CODE,ERROR_TEXT) values ('ARBOPDOC',:b0,:b1,:b2,:b3,:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )966;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_line_no;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_err_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_ar_doc_error_text;
   sqlstm.sqhstl[4] = (unsigned int  )73;
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
   {
     err_mesg("INSERT failed on table AR_DOC_ERROR",0,"");
  }

   strcpy(nd_error_flag.arr,"Y");
   nd_error_flag.len = 1;
}

error_insert_pat(line_no,msg_id,msg_txt)
char line_no[],msg_id[],msg_txt[];
{
   /* EXEC SQL BEGIN DECLARE SECTION; */ 

     /* VARCHAR ar_line_no[5],
	     ar_err_code[7],
	     l_ar_doc_error_text[71]; */ 
struct { unsigned short len; unsigned char arr[5]; } ar_line_no;

struct { unsigned short len; unsigned char arr[7]; } ar_err_code;

struct { unsigned short len; unsigned char arr[71]; } l_ar_doc_error_text;

   /* EXEC SQL END DECLARE SECTION; */ 


   char l_ch_payable_amt  [25],
	l_ch_tot_amt      [25];

   strcpy(ar_line_no.arr,"   1");

   ar_line_no.len = strlen(ar_line_no.arr);

   strcpy(ar_err_code.arr,msg_id);
   ar_err_code.len = strlen(ar_err_code.arr);

   l_ar_doc_error_text.arr[0] = '\0';
   l_ar_doc_error_text.len    = 0;

   if (strcmp(ar_err_code.arr,"AR2180") == 0)
   {
	   if (nd_no_of_decimal == 3)
	   {
		   sprintf(l_ch_payable_amt,"%19.3f",d_pend_pending_amt);
		   sprintf(l_ch_tot_amt,"%19.3f",ar_pat_tot_amt);
       }
       else
	   {
		   sprintf(l_ch_payable_amt,"%19.2f",d_pend_pending_amt);
		   sprintf(l_ch_tot_amt,"%19.2f",ar_pat_tot_amt);
       }

//       ltrim(l_ch_payable_amt);
  //     ltrim(l_ch_tot_amt);
 
       format_amt(l_ch_payable_amt,nd_no_of_decimal);
       format_amt(l_ch_tot_amt,nd_no_of_decimal);

       sprintf(l_ar_doc_error_text.arr,
		 "Doc Amt = %s Sum of Patient Line Amt = %s ",
		   l_ch_payable_amt,l_ch_tot_amt);
   }
   else
       sprintf(l_ar_doc_error_text.arr,"%sin PATIENT DTLS Line %d ",msg_txt,
			 ar_pat_line_num);
   
   l_ar_doc_error_text.len = strlen(l_ar_doc_error_text.arr);

   /* EXEC SQL INSERT INTO AR_DOC_ERROR
		   (PGM_ID,
		    DOC_TYPE_CODE,    DOC_NUM,
		    LINE_NUM,         ERROR_CODE,
		    ERROR_TEXT)
	    VALUES ('ARBOPDOC',:d_pend_doc_type_code,   :d_pend_doc_num,
		    :ar_line_no,      :ar_err_code,
		    :l_ar_doc_error_text); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_DOC_ERROR (PGM_ID,DOC_TYPE_CODE,DOC_NUM,LIN\
E_NUM,ERROR_CODE,ERROR_TEXT) values ('ARBOPDOC',:b0,:b1,:b2,:b3,:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1001;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_line_no;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_err_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_ar_doc_error_text;
   sqlstm.sqhstl[4] = (unsigned int  )73;
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
   {
     err_mesg("INSERT failed on table AR_DOC_ERROR",0,"");
  }

   strcpy(nd_error_flag.arr,"Y");
   nd_error_flag.len = 1;
}

update_err_flg()
{
   /* EXEC SQL UPDATE AR_PENDING_DOC_TEMP 
	       SET ERROR_FLAG    = :nd_error_flag,
		   DISCOUNT_AMT  = NVL(DISCOUNT_AMT,0),
		   ALLOCATED_AMT = 0,
		   LAST_UPD_DATE = SYSDATE
	     WHERE ROWID      = :d_pend_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update AR_PENDING_DOC_TEMP  set ERROR_FLAG=:b0,DISCOUNT_AM\
T=NVL(DISCOUNT_AMT,0),ALLOCATED_AMT=0,LAST_UPD_DATE=SYSDATE where ROWID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1036;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_error_flag;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pend_rowid;
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
}



   if (OERROR)
	err_mesg("UPDATE failed on table AR_PENDING_DOC_TEMP...");

}

doc_post()
{
    /* EXEC SQL INSERT INTO  SY_DOC_CONTROL 
	     (
	      MODULE_ID,
	      DOC_TYPE_CODE,
	      DOC_NUM,  
	      DOC_DATE,
	      POSTED_DATE,
	      DOC_STATUS,
	      NARRATION ,
	      POST_MONTH,
	      POST_YEAR ,
	      ADDED_BY_ID,
	      ADDED_DATE,
	      MODIFIED_BY_ID,
	      MODIFIED_DATE
	     )
	     VALUES
	     (
	      'AR',
	      :d_pend_doc_type_code,
	      :d_pend_doc_num,
	      TO_DATE(:d_pend_doc_date,'DD/MM/YYYY'),
	      SYSDATE,
	      'P',
	      :d_pend_narration,
	      :d_pend_post_month,
	      :d_pend_post_year,
	       USER,
	       SYSDATE,
	       USER,
	       SYSDATE); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_DOC_CONTROL (MODULE_ID,DOC_TYPE_CODE,DOC_N\
UM,DOC_DATE,POSTED_DATE,DOC_STATUS,NARRATION,POST_MONTH,POST_YEAR,ADDED_BY_ID,\
ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE) values ('AR',:b0,:b1,TO_DATE(:b2,'DD/\
MM/YYYY'),SYSDATE,'P',:b3,:b4,:b5,USER,SYSDATE,USER,SYSDATE)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1059;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )14;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_pend_doc_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_pend_narration;
    sqlstm.sqhstl[3] = (unsigned int  )54;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_pend_post_month;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_pend_post_year;
    sqlstm.sqhstl[5] = (unsigned int  )7;
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
	err_mesg("INSERT failed on table SY_DOC_CONTROL",0,"");
           
    /* EXEC SQL INSERT INTO AR_PENDING_DOC
		(ACC_ENTITY_CODE,
		    DOC_TYPE_CODE,
		    DOC_NUM,
		    LAST_DOC_LINE_NUM,
		    CUST_CODE,
		    DOC_DATE,
		    NARRATION,
		    BASE_DATE,
		    DUE_DATE,
		    GROSS_AMT,
		    PAYABLE_AMT,
		    DISCOUNT_AMT,
		    PENDING_AMT,
		    ALLOCATED_AMT,
		    CURRENCY_CODE,
		    EXCHG_RATE,
		    PMNT_TERMS_CODE,
		    SETTLEMENT_DATE,
		    SETTLEMENT_PERC,
		    CUST_REF,
		    PATIENT_ID,
		    BILLING_GROUP,
		    BILL_NUM,
		    BILL_DATE,
		    DOCTOR_FEE_AMT,
		    MAIN_ACC1_CODE,
		    MAIN_ACC2_CODE,
		    SUBLEDGER_GROUP_CODE,
		    SUBLEDGER_LINE_CODE,
		    DEPT_CODE,
		    PRODUCT_GROUP_CODE,
		    PRODUCT_LINE_CODE,
		    POST_MONTH,
		    POST_YEAR,
		    MISC_CUST_LONG_NAME,
		    MISC_CUST_SHORT_NAME,
		    MISC_CUST_ADD1_DESC,
		    MISC_CUST_ADD2_DESC,
		    MISC_CUST_ADD3_DESC,
		    MISC_CUST_ZIP_DESC,
		    MISC_CUST_LONG_NAME_CHINESE,
		    MISC_CUST_SHORT_NAME_CHINESE,
		    MISC_CUST_ADD1_DESC_CHINESE,
		    MISC_CUST_ADD2_DESC_CHINESE,
		    MISC_CUST_ADD3_DESC_CHINESE,
		    MISC_CUST_ZIP_DESC_CHINESE,
		    TEL_NUM,
		    CONTACT_NAME,
		    CONTACT_NAME_TITLE,
		    ERROR_FLAG,
		    BILL_DOC_TYPE_CODE,
		    TRN_TYPE_CODE,
		    LAST_UPD_DATE,
		    BILL_TYPE_CODE,
			EPISODE_TYPE,
		    EPISODE_ID,
		    VISIT_ID,
			MARKUP_AMT,
			CONSOLIDATED_INV_YN,
			MODULE_ID)
			(SELECT ACC_ENTITY_CODE,
		    DOC_TYPE_CODE,
		    DOC_NUM,
		    LAST_DOC_LINE_NUM,
		    CUST_CODE,
		    DOC_DATE,
		    NARRATION,
		    BASE_DATE,
		    DUE_DATE,
		    GROSS_AMT,
		    PAYABLE_AMT,
		    DISCOUNT_AMT,
		    PENDING_AMT,
		    ALLOCATED_AMT,
		    CURRENCY_CODE,
		    EXCHG_RATE,
		    PMNT_TERMS_CODE,
		    SETTLEMENT_DATE,
		    SETTLEMENT_PERC,
		    CUST_REF,
		    PATIENT_ID,
		    BILLING_GROUP,
		    BILL_NUM,
		    BILL_DATE,
		    DOCTOR_FEE_AMT,
		    MAIN_ACC1_CODE,
		    MAIN_ACC2_CODE,
		    SUBLEDGER_GROUP_CODE,
		    SUBLEDGER_LINE_CODE,
		    DEPT_CODE,
		    PRODUCT_GROUP_CODE,
		    PRODUCT_LINE_CODE,
		    POST_MONTH,
		    POST_YEAR,
		    MISC_CUST_LONG_NAME,
		    MISC_CUST_SHORT_NAME,
		    MISC_CUST_ADD1_DESC,
		    MISC_CUST_ADD2_DESC,
		    MISC_CUST_ADD3_DESC,
		    MISC_CUST_ZIP_DESC,
		    MISC_CUST_LONG_NAME_CHINESE,
		    MISC_CUST_SHORT_NAME_CHINESE,
		    MISC_CUST_ADD1_DESC_CHINESE,
		    MISC_CUST_ADD2_DESC_CHINESE,
		    MISC_CUST_ADD3_DESC_CHINESE,
		    MISC_CUST_ZIP_DESC_CHINESE,
		    TEL_NUM,
		    CONTACT_NAME,
		    CONTACT_NAME_TITLE,
		    ERROR_FLAG,
		    BILL_DOC_TYPE_CODE,
		    TRN_TYPE_CODE,
		    LAST_UPD_DATE,
		    BILL_TYPE_CODE,
			EPISODE_TYPE,
		    EPISODE_ID,
		    VISIT_ID,
			MARKUP_AMT,
			CONSOLIDATED_INV_YN,
			MODULE_ID
		    FROM AR_PENDING_DOC_TEMP
	      WHERE ROWID = :d_pend_rowid); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "insert into AR_PENDING_DOC (ACC_ENTITY_CODE,DOC_TYPE_CODE,DOC_NUM,LAS\
T_DOC_LINE_NUM,CUST_CODE,DOC_DATE,NARRATION,BASE_DATE,DUE_DATE,GROSS_AMT,PAY\
ABLE_AMT,DISCOUNT_AMT,PENDING_AMT,ALLOCATED_AMT,CURRENCY_CODE,EXCHG_RATE,PMN\
T_TERMS_CODE,SETTLEMENT_DATE,SETTLEMENT_PERC,CUST_REF,PATIENT_ID,BILLING_GRO\
UP,BILL_NUM,BILL_DATE,DOCTOR_FEE_AMT,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER\
_GROUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CO\
DE,POST_MONTH,POST_YEAR,MISC_CUST_LONG_NAME,MISC_CUST_SHORT_NAME,MISC_CUST_A\
DD1_DESC,MISC_CUST_ADD2_DESC,MISC_CUST_ADD3_DESC,MISC_CUST_ZIP_DESC,MISC_CUS\
T_LONG_NAME_CHINESE,MISC_CUST_SHORT_NAME_CHINESE,MISC_CUST_ADD1_DESC_CHINESE\
,MISC_CUST_ADD2_DESC_CHINESE,MISC_CUST_ADD3_DESC_CHINESE,MISC_CUST_ZIP_DESC_\
CHINESE,TEL_NUM,CONTACT_NAME,CONTACT_NAME_TITLE,ERROR_FLAG,BILL_DOC_TYPE_COD\
E,TRN_TYPE_CODE,LAST_UPD_DATE,BILL_TYPE_CODE,EPISODE_TYPE,EPISODE_ID,VISIT_I\
D,MARKUP_AMT,CONSOLIDATED_INV_YN,MODULE_ID)(select ACC_ENTITY_CODE ,DOC_TYPE\
_CODE ,DOC_NUM ,LAST_DOC_LINE_NUM ,CUST_COD");
    sqlstm.stmt = "E ,DOC_DATE ,NARRATION ,BASE_DATE ,DUE_DATE ,GROSS_AMT ,P\
AYABLE_AMT ,DISCOUNT_AMT ,PENDING_AMT ,ALLOCATED_AMT ,CURRENCY_CODE ,EXCHG_RAT\
E ,PMNT_TERMS_CODE ,SETTLEMENT_DATE ,SETTLEMENT_PERC ,CUST_REF ,PATIENT_ID ,BI\
LLING_GROUP ,BILL_NUM ,BILL_DATE ,DOCTOR_FEE_AMT ,MAIN_ACC1_CODE ,MAIN_ACC2_CO\
DE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,\
PRODUCT_LINE_CODE ,POST_MONTH ,POST_YEAR ,MISC_CUST_LONG_NAME ,MISC_CUST_SHORT\
_NAME ,MISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,MISC_CUST_ADD3_DESC ,MISC_CUS\
T_ZIP_DESC ,MISC_CUST_LONG_NAME_CHINESE ,MISC_CUST_SHORT_NAME_CHINESE ,MISC_CU\
ST_ADD1_DESC_CHINESE ,MISC_CUST_ADD2_DESC_CHINESE ,MISC_CUST_ADD3_DESC_CHINESE\
 ,MISC_CUST_ZIP_DESC_CHINESE ,TEL_NUM ,CONTACT_NAME ,CONTACT_NAME_TITLE ,ERROR\
_FLAG ,BILL_DOC_TYPE_CODE ,TRN_TYPE_CODE ,LAST_UPD_DATE ,BILL_TYPE_CODE ,EPISO\
DE_TYPE ,EPISODE_ID ,VISIT_ID ,MARKUP_AMT ,CONSOLIDATED_INV_YN ,MODULE_ID  fro\
m AR_PENDING_DOC_TEMP where ROWID=:b0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1098;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_rowid;
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



    if (OERROR)
	err_mesg("INSERT failed on table AR_PENDING_DOC",0,"");

    /* EXEC SQL INSERT INTO AR_CUST_TRN
		(ACC_ENTITY_CODE,
		    CUST_CODE,
		    ORG_DOC_TYPE_CODE,
		    ORG_DOC_NUM,
		    LINE_NUM,
		    DOC_TYPE_CODE,
		    DOC_NUM,
		    DOC_DATE,
		    NARRATION,
		    AMOUNT,
		    LINE_TYPE_CODE,
		    CUST_REF,
		    TRN_TYPE_CODE,
			POST_MONTH,
			POST_YEAR)
	     (SELECT ACC_ENTITY_CODE,
		    CUST_CODE,
		    ORG_DOC_TYPE_CODE,
		    ORG_DOC_NUM,
		    LINE_NUM,
		    DOC_TYPE_CODE,
		    DOC_NUM,
		    DOC_DATE,
		    NARRATION,
		    AMOUNT,
		    LINE_TYPE_CODE,
		    CUST_REF,
		    TRN_TYPE_CODE,
			POST_MONTH,
			POST_YEAR
	     FROM AR_CUST_TRN_TEMP
	      WHERE ORG_DOC_TYPE_CODE = :d_pend_doc_type_code
		AND ORG_DOC_NUM       = :d_pend_doc_num); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into AR_CUST_TRN (ACC_ENTITY_CODE,CUST_CODE,ORG_DO\
C_TYPE_CODE,ORG_DOC_NUM,LINE_NUM,DOC_TYPE_CODE,DOC_NUM,DOC_DATE,NARRATION,AMOU\
NT,LINE_TYPE_CODE,CUST_REF,TRN_TYPE_CODE,POST_MONTH,POST_YEAR)(select ACC_ENTI\
TY_CODE ,CUST_CODE ,ORG_DOC_TYPE_CODE ,ORG_DOC_NUM ,LINE_NUM ,DOC_TYPE_CODE ,D\
OC_NUM ,DOC_DATE ,NARRATION ,AMOUNT ,LINE_TYPE_CODE ,CUST_REF ,TRN_TYPE_CODE ,\
POST_MONTH ,POST_YEAR  from AR_CUST_TRN_TEMP where (ORG_DOC_TYPE_CODE=:b0 and \
ORG_DOC_NUM=:b1))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1117;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )14;
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
	err_mesg("INSERT failed on table AR_CUST_TRN",0,"");

    /* EXEC SQL INSERT INTO  SY_DOC_CONTROL 
	     (
	      MODULE_ID,
	      DOC_TYPE_CODE,
	      DOC_NUM,  
	      DOC_DATE,
	      POSTED_DATE,
	      DOC_STATUS,
	      NARRATION ,
	      POST_MONTH,
	      POST_YEAR ,
	      ADDED_BY_ID,
	      ADDED_DATE,
	      MODIFIED_BY_ID,
	      MODIFIED_DATE
	     )
	     SELECT 'AR',
		    DOC_TYPE_CODE,
		    DOC_NUM,
		    DOC_DATE,
		    SYSDATE, 
		    'P',
		    NARRATION,
		    POST_MONTH,
		    POST_YEAR,
		    USER,
		    SYSDATE,
		    USER,
		    SYSDATE
	       FROM AR_CUST_TRN_TEMP
	      WHERE ORG_DOC_TYPE_CODE = :d_pend_doc_type_code
		AND ORG_DOC_NUM       = :d_pend_doc_num
		AND ORG_DOC_TYPE_CODE <> DOC_TYPE_CODE
		AND ORG_DOC_NUM       <> DOC_NUM; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_DOC_CONTROL (MODULE_ID,DOC_TYPE_CODE,DOC_N\
UM,DOC_DATE,POSTED_DATE,DOC_STATUS,NARRATION,POST_MONTH,POST_YEAR,ADDED_BY_ID,\
ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE)select 'AR' ,DOC_TYPE_CODE ,DOC_NUM ,D\
OC_DATE ,SYSDATE ,'P' ,NARRATION ,POST_MONTH ,POST_YEAR ,USER ,SYSDATE ,USER ,\
SYSDATE  from AR_CUST_TRN_TEMP where (((ORG_DOC_TYPE_CODE=:b0 and ORG_DOC_NUM=\
:b1) and ORG_DOC_TYPE_CODE<>DOC_TYPE_CODE) and ORG_DOC_NUM<>DOC_NUM)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1140;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )14;
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
	err_mesg("INSERT failed on table SY_DOC_CONTROL - for CUST_TRN",0,"");

    /* EXEC SQL UPDATE AR_CUSTOMER
		SET OUTSTANDING_BALANCE_AMT = 
		       NVL(OUTSTANDING_BALANCE_AMT,0) +
		       :d_pend_pending_amt
	      WHERE CUST_CODE        = :d_pend_cust_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_CUSTOMER  set OUTSTANDING_BALANCE_AMT=(NVL(OUTS\
TANDING_BALANCE_AMT,0)+:b0) where CUST_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1163;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_pending_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_pend_cust_code;
    sqlstm.sqhstl[1] = (unsigned int  )14;
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
	err_mesg("UPDATE failed on table AR_CUSTOMER",0,"");

    /* EXEC SQL DELETE AR_PENDING_DOC_TEMP 
	      WHERE ROWID = :d_pend_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from AR_PENDING_DOC_TEMP  where ROWID=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1186;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_rowid;
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



    if (OERROR)
	err_mesg("DELETE failed on table AR_PENDING_DOC_TEMP",0,"");

    /* EXEC SQL DELETE AR_CUST_TRN_TEMP
	      WHERE ORG_DOC_TYPE_CODE = :d_pend_doc_type_code
		AND ORG_DOC_NUM       = :d_pend_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from AR_CUST_TRN_TEMP  where (ORG_DOC_TYPE_CODE=:\
b0 and ORG_DOC_NUM=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1205;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pend_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_pend_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )14;
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
	err_mesg("DELETE failed on table AR_CUST_TRN_TEMP",0,"");

}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )1228;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqlcmax = (unsigned int )100;
  sqlstm.sqlcmin = (unsigned int )2;
  sqlstm.sqlcincr = (unsigned int )1;
  sqlstm.sqlctimeout = (unsigned int )0;
  sqlstm.sqlcnowait = (unsigned int )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}
 
validate_posting() 
{  
   strcpy(d_module_valid_id.arr , "AR");

   if(validate_posting_acct( d_main_acc1_code.arr,
			     d_main_acc2_code.arr,
			     d_dept_code.arr,
			     d_product_group_code.arr,
			     d_product_line_code.arr,
			     d_subledger_group_code.arr,
			     d_subledger_line_code.arr,
			     'Y',   /* For chking Bank Reconcile */
				 d_module_valid_id.arr ,
			     atol(d_pend_post_year.arr),
				 atol(d_pend_post_month.arr),
				 &g_err_typ,
			     g_err_id,
			     g_err_msg
			  ) ==  -1)
   {
	  if(g_err_typ == 0)
		err_mesg(g_err_msg,0,"");
	  else 
	  {
	     error_insert(" HDR",g_err_id);
	  }
       }
}

run_report()
{
  char l_run_string[300],l_messg_str[132];
  int  l_ret_run_rep;

  sprintf(l_run_string,"r25run %s %s no \
  batch=yes desname=arbopdoc.lis session_id=%s pgm_date=%s PGM_ID=%s",
  "arropdoc",uid_pwd.arr,nd_session_id.arr,g_pgm_date,"ARBOPDOC");

  l_ret_run_rep = WinExec(l_run_string,SW_SHOWNORMAL);

  if (l_ret_run_rep)
  {
     sprintf(l_messg_str,"RUNREP - arropdoc session = %s failed \
return value %d",nd_session_id.arr,l_ret_run_rep);
     err_mesg(l_messg_str,1,"");
  }
}

delete_records()
{
    while (1)
    {
       /* EXEC SQL DELETE FROM AR_DOC_ERROR
		      WHERE PGM_ID = 'ARBOPDOC'
			AND ROWNUM < 500; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 21;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "delete  from AR_DOC_ERROR  where (PGM_ID='ARBOPDOC' an\
d ROWNUM<500)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1259;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



       if (OERROR)
	    err_mesg("DELETE failed on table AR_DOC_ERROR",0,"");

       /* EXEC SQL COMMIT WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 21;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1274;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


       if (NOT_FOUND)
	     break;
    }
}

doubcmp(_doub1,_doub2)
double _doub1,_doub2;
{
  char _doub_str1[25],_doub_str2[25];
  if (nd_no_of_decimal == 3) 
    {
  sprintf(_doub_str1,"%15.3f",_doub1);
  sprintf(_doub_str2,"%15.3f",_doub2);
  ltrim(_doub_str1);
  ltrim(_doub_str2);
  if (strcmp(_doub_str1,"-0.000") == 0)
     strcpy(_doub_str1,"0.000");
  if (strcmp(_doub_str2,"-0.000") == 0)
     strcpy(_doub_str2,"0.000");

    }
  else
   {
  sprintf(_doub_str1,"%15.2f",_doub1);
  sprintf(_doub_str2,"%15.2f",_doub2);
  ltrim(_doub_str1);
  ltrim(_doub_str2);
  if (strcmp(_doub_str1,"-0.00") == 0)
     strcpy(_doub_str1,"0.00");
  if (strcmp(_doub_str2,"-0.00") == 0)
     strcpy(_doub_str2,"0.00");

   }
  
  return(strcmp(_doub_str1,_doub_str2));
}

ltrim(l_str)
char *l_str;
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}

