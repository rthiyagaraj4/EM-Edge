
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
           char  filnam[38];
};
static const struct sqlcxp sqlfpn =
{
    37,
    "c:\\madhu\\billing\\arrorprt\\arrorprt.pc"
};


static unsigned long sqlctx = 1019958949;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {10,11};

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

 static const char *sq0007 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,CUST_CODE ,DO\
C_REF ,NVL(AMT_LOCAL,0) ,BANK_DESC ,CHEQUE_NUM ,TO_CHAR(CHEQUE_DATE,'DD/MM/YYY\
Y') ,NARRATION ,ROWID  from AR_CASHIER where ((((((((DOC_TYPE_CODE>=NVL(:b0,' \
     ') and DOC_TYPE_CODE<=NVL(:b1,'~~~~~~')) and DOC_NUM>=NVL(:b2,0)) and DOC\
_NUM<=NVL(:b3,99999999)) and OPERATING_FACILITY_ID=:b4) and NVL(DOC_DATE,SYSDA\
TE)>=NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))) and NVL(DO\
C_DATE,SYSDATE)<=NVL(TO_DATE(:b6,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))\
) and NVL(POSTED_FLAG,'N')='N') and NVL(PRINT_FLAG,'N')='N') order by DOC_TYPE\
_CODE,DOC_NUM            ";

 static const char *sq0008 = 
"select DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINESE,LONG_NAME)  from \
AR_CUSTOMER where CUST_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,193,0,4,207,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,1,9,0,0,
56,0,0,2,175,0,4,265,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
87,0,0,3,91,0,2,287,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
110,0,0,4,0,0,30,302,0,0,0,0,0,1,0,
125,0,0,5,0,0,27,308,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
156,0,0,6,202,0,4,334,0,0,8,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,1,9,0,0,
203,0,0,7,647,0,9,409,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
246,0,0,7,0,0,13,454,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
305,0,0,8,118,0,9,493,0,0,1,1,0,1,0,1,9,0,0,
324,0,0,8,0,0,13,501,0,0,1,0,0,1,0,2,9,0,0,
343,0,0,9,111,0,5,602,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
370,0,0,10,0,0,29,612,0,0,0,0,0,1,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                   */
/************************************************************************/
/* PROGRAM NAME          : ARRORPRT.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 10-APR-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                                */
/*                                                                          */
/*  FUNCTION             :                                                */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_CASHIER               Query/Update             */
/*         2.        SY_PROG_CONTROL           Update/Lookup            */
/*         3.        SY_PROG_MESG                Insert                 */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include "gl.h"
char string_var[100];

/*
#define OERROR (sqlca.sqlcode < 0)
*/

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define DEST_NAME "arrorprt.lis"

#define MAX_LINES 13
#define ESC 0x1B
/*
#define DEBUG 1
*/
#define SKIP_1 5
#define SKIP_2 68
#define SKIP_3 3
#define SKIP_4 15
#define SKIP_5 25
#define SKIP_6 15
#define SKIP_7 3
#define SKIP_8 13
#define SKIP_9 9

 
/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
		   facility_name[120], //added by madhusudhan for GDOH-CRF-0107 ON 03/01/2017
           date_time    [20],
		   cur_str      [8],
		   sub_cur_str	[8],
           user_id      [20],
           nd_pgm_date  [35],
		   d_curr_pgm_name  [15]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[120]; } facility_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;


   /* VARCHAR nd_facility_id   [3],
           nd_session_id    [16],
           nd_fm_doc_type   [7],
           nd_to_doc_type   [7],
           nd_fm_doc_num    [10],
           nd_to_doc_num    [10],
           nd_fm_doc_date   [12],
           nd_to_doc_date   [12]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;


   /* VARCHAR d_bl_doc_type_code     [7],
           d_bl_doc_num           [10],
           d_bl_doc_date          [12],
           d_bl_cust_code         [9],
           d_bl_doc_ref           [16],
           d_bl_bank_desc         [31],
           d_bl_cheque_num        [11],
           d_bl_cheque_date       [12],
           d_bl_rowid             [31],
           d_bl_narration         [51],
           d_ar_cust_long_name    [101]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_bl_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_bl_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_bl_doc_date;

struct { unsigned short len; unsigned char arr[9]; } d_bl_cust_code;

struct { unsigned short len; unsigned char arr[16]; } d_bl_doc_ref;

struct { unsigned short len; unsigned char arr[31]; } d_bl_bank_desc;

struct { unsigned short len; unsigned char arr[11]; } d_bl_cheque_num;

struct { unsigned short len; unsigned char arr[12]; } d_bl_cheque_date;

struct { unsigned short len; unsigned char arr[31]; } d_bl_rowid;

struct { unsigned short len; unsigned char arr[51]; } d_bl_narration;

struct { unsigned short len; unsigned char arr[101]; } d_ar_cust_long_name;
   /*   CRF-0120  */
   /* VARCHAR  p_language_id[4]; */ 
struct { unsigned short len; unsigned char arr[4]; } p_language_id;

   double  d_bl_amt_local;

   int nd_no_of_decimal;

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
int lctr = 0,pctr =0;
char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{
	strcpy(filename,WORKING_DIR);
	strcpy(OUTPUT_FILE_NAME,argv[5]);
	strcat(filename,OUTPUT_FILE_NAME);

	//strcat(filename,"blrrclst.lis");

   if (argc < 6)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

strcpy(g_pgm_id,"ARRORPRT");

   strcpy(d_curr_pgm_name.arr,g_pgm_id); 
   d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

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

 
   /*if (argc != 8)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
      proc_exit();
   }

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); */

/*
   strcpy(g_session_id,argv[2]);
   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);
*/

  /* strcpy(g_pgm_id,"ARRORPRT");

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ORA_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   } */

#ifdef DEBUG
  disp_message(ERR_MESG,"After connecting to oracle...\n");
#endif
   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
strcpy(g_facility_id,argv[4]);
  set_meduser_role();
     strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;

/*
   chk_active();
*/
/*   strcpy(g_pgm_date,argv[3]);
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);*/

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   nd_facility_id.arr[0] = '\0';


   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   nd_facility_id.len       = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID ,PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6
              INTO :nd_facility_id, :nd_fm_doc_type, :nd_fm_doc_num, :nd_fm_doc_date,
                   :nd_to_doc_type, :nd_to_doc_num, :nd_to_doc_date 
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRORPRT'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where \
((PGM_ID='ARRORPRT' and SESSION_ID=:b7) and PGM_DATE=:b8)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_type;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_type;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[6] = (unsigned int  )14;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[8] = (unsigned int  )37;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';
   nd_facility_id.arr[nd_facility_id.len]        = '\0';


/* #ifdef DEBUG */
   sprintf(string_var,"fr type is <%d> - <%s>\n",nd_fm_doc_type.len ,nd_fm_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to type is <%d> - <%s>\n",nd_to_doc_type.len ,nd_to_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fr num  is <%d> - <%s>\n",nd_fm_doc_num.len ,nd_fm_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to num  is <%d> - <%s>\n",nd_to_doc_num.len ,nd_to_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fr dt   is <%d> - <%s>\n",nd_fm_doc_date.len ,nd_fm_doc_date.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to dt   is <%d> - <%s>\n",nd_to_doc_date.len ,nd_to_doc_date.arr);
   disp_message(INFO_MESG,string_var);
   //added by madhusudhan for GDOH-CRF-0107 ON 03/01/2017
   sprintf(string_var,"facility id   is <%d> - <%s>\n",nd_facility_id.len ,nd_facility_id.arr);
   disp_message(INFO_MESG,string_var);
/* #endif */

/*
   start_prog_control();
*/
   start_prog_msg();

   fetch_detls();

   open_files();
   
   declare_cursors();

   while(fetch_rec())
   {
  
/*-- Rowid was giving problem. So it has been replaced by doc_type_code
     and doc_num. VSK 16/11/1999 */
	   
        /* EXEC SQL SELECT ROWID
                 INTO   :d_bl_rowid
                 FROM   AR_CASHIER
//				 WHERE  ROWID = :d_bl_rowid
                 WHERE  DOC_TYPE_CODE  = :d_bl_doc_type_code 
				 AND    OPERATING_FACILITY_ID =:nd_facility_id //added by madhusudhan for GDOH-CRF-0107 ON 03/01/2017
				 AND	DOC_NUM = :d_bl_doc_num
                 AND    NVL(PRINT_FLAG,'N') = 'N'
                 FOR    UPDATE OF PRINT_FLAG NOWAIT; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 9;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select ROWID into :b0  from AR_CASHIER where (((DOC_T\
YPE_CODE=:b1 and OPERATING_FACILITY_ID=:b2) and DOC_NUM=:b3) and NVL(PRINT_FLA\
G,'N')='N') for update of PRINT_FLAG nowait ";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )56;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_bl_rowid;
        sqlstm.sqhstl[0] = (unsigned int  )33;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_bl_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[2] = (unsigned int  )5;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_bl_doc_num;
        sqlstm.sqhstl[3] = (unsigned int  )12;
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



       if(sqlca.sqlcode == -54 || sqlca.sqlerrd[2] == 0)
           continue;
       else if(OERROR)
           err_mesg("Lock failed on table AR_CASHIER",0,"");

        fetch_cust_dets();
        print_rec();
        update_rec();
   }

   fclose(fp);

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
                  WHERE PGM_ID     = 'ARRORPRT'
                    AND SESSION_ID = :nd_session_id
                    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRORPRT' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )87;
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
   sqlstm.sqhstl[1] = (unsigned int  )37;
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
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");



   end_prog_msg();

/*
   end_prog_control();
*/

   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )110;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   return;
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )125;
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

fetch_detls()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"In fetch det\n");
#endif
   hosp_name.arr[0]      = '\0';
   facility_name.arr[0]  = '\0'; //added by madhusudhan for GDOH-CRF-0107 ON 03/01/2017
   date_time.arr[0]      = '\0';
   cur_str.arr[0]        = '\0';
   sub_cur_str.arr[0]    = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   facility_name.len  = 0; //added by madhusudhan for GDOH-CRF-0107 ON 03/01/2017
   date_time.len      = 0;
   cur_str.len        = 0;
   sub_cur_str.len    = 0;
   user_id.len        = 0;
 
   /* EXEC SQL SELECT ACC_ENTITY_NAME,ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY'), BASE_CURRENCY,
                   USER,BASE_CURRENCY_DEC, NO_OF_DECIMAL
              INTO :facility_name,:hosp_name, :date_time, :cur_str, :user_id,
			       :sub_cur_str , nd_no_of_decimal
              FROM SY_ACC_ENTITY
			  where   ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'\
DD/MM/YYYY') ,BASE_CURRENCY ,USER ,BASE_CURRENCY_DEC ,NO_OF_DECIMAL into :b0,:\
b1,:b2,:b3,:b4,:b5,:b6  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )156;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&facility_name;
   sqlstm.sqhstl[0] = (unsigned int  )122;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&hosp_name;
   sqlstm.sqhstl[1] = (unsigned int  )122;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&date_time;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&cur_str;
   sqlstm.sqhstl[3] = (unsigned int  )10;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&user_id;
   sqlstm.sqhstl[4] = (unsigned int  )22;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&sub_cur_str;
   sqlstm.sqhstl[5] = (unsigned int  )10;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_facility_id;
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


;

   if (OERROR)
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   facility_name.arr[facility_name.len]   = '\0';//added by madhusudhan for GDOH-CRF-0107 ON 03/01/2017
   date_time.arr[date_time.len]           = '\0';
   cur_str.arr[cur_str.len]               = '\0';
   sub_cur_str.arr[sub_cur_str.len]       = '\0';
   user_id.arr[user_id.len]               = '\0';

}

open_files()
{
   
   //strcpy(filename,WORKING_DIR);
   //strcat(filename,DEST_NAME);
   char		txt_msg[101];   

   if ((fp = fopen(filename,"w")) == NULL)
   {
        sprintf(txt_msg,"Error While Opening File %s",filename);
		err_mesg(txt_msg,0,"");
		//err_mesg("\nError while opening File arrrmltr.lis\n",0,"");
        proc_exit();
   }

#ifdef DEBUG
   disp_message(INFO_MESG,"After opening file\n");
#endif
}

declare_cursors()
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside declare cursors\n");
#endif

/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY VSK 14/11/1999 */

   /* EXEC SQL DECLARE AR_CASHIER_CUR CURSOR FOR
             SELECT DOC_TYPE_CODE,
                    DOC_NUM,
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    CUST_CODE,
                    DOC_REF,
                    NVL(AMT_LOCAL,0),
                    BANK_DESC,
                    CHEQUE_NUM,
                    TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY'),
                    NARRATION,
                    ROWID
               FROM AR_CASHIER
              WHERE  DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
				AND OPERATING_FACILITY_ID =:nd_facility_id //added by madhusudhan for GDOH-CRF-0107 ON 03/01/2017
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
                AND  NVL(POSTED_FLAG,'N') = 'N'
                AND NVL(PRINT_FLAG,'N')  = 'N'
              ORDER BY DOC_TYPE_CODE,DOC_NUM; */ 


    /* EXEC SQL OPEN AR_CASHIER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )203;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )12;
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
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[5] = (unsigned int  )14;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[6] = (unsigned int  )14;
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
         err_mesg("OPEN failed on cursor AR_CASHIER_CUR",0,"");

    /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
              SELECT DECODE(CHINESE_REPORTING_FLAG,'Y',
                     LONG_NAME_CHINESE,LONG_NAME)
                FROM AR_CUSTOMER
               WHERE CUST_CODE = :d_bl_cust_code; */ 


	fprintf(fp,"%c(s4099T",ESC); 	/* To set the font name			*/
  	fprintf(fp,"%c&l8D",ESC); 	/* To set vertical lines per inch 	*/
	fprintf(fp,"%c(s12H",ESC); 	/* To set the font 			*/
	fprintf(fp,"%c&l6E",ESC); 	/* To Set the Top margin  		*/
} 
 
fetch_rec()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside fetch rec\n");
#endif
   d_bl_doc_type_code.arr[0] = '\0';
   d_bl_doc_num.arr[0]       = '\0';
   d_bl_doc_date.arr[0]      = '\0';
   d_bl_cust_code.arr[0]     = '\0';
   d_bl_doc_ref.arr[0]       = '\0';
   d_bl_bank_desc.arr[0]     = '\0';
   d_bl_cheque_num.arr[0]    = '\0';
   d_bl_cheque_date.arr[0]   = '\0';
   d_bl_narration.arr[0]     = '\0';
   d_bl_rowid.arr[0]         = '\0';

   d_bl_doc_type_code.len    = 0;
   d_bl_doc_num.len          = 0;
   d_bl_doc_date.len         = 0;
   d_bl_cust_code.len        = 0;
   d_bl_doc_ref.len          = 0;
   d_bl_bank_desc.len        = 0;
   d_bl_cheque_num.len       = 0;
   d_bl_cheque_date.len      = 0;
   d_bl_narration.len        = 0;
   d_bl_rowid.len            = 0;

   d_bl_amt_local            = 0;

   /* EXEC SQL FETCH AR_CASHIER_CUR
             INTO :d_bl_doc_type_code,
                  :d_bl_doc_num,
                  :d_bl_doc_date,
                  :d_bl_cust_code,
                  :d_bl_doc_ref,
                  :d_bl_amt_local,
                  :d_bl_bank_desc,
                  :d_bl_cheque_num,
                  :d_bl_cheque_date,
                  :d_bl_narration,
                  :d_bl_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )246;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_bl_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_bl_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )12;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_bl_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_bl_cust_code;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_bl_doc_ref;
   sqlstm.sqhstl[4] = (unsigned int  )18;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_bl_amt_local;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_bl_bank_desc;
   sqlstm.sqhstl[6] = (unsigned int  )33;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_bl_cheque_num;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_bl_cheque_date;
   sqlstm.sqhstl[8] = (unsigned int  )14;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_bl_narration;
   sqlstm.sqhstl[9] = (unsigned int  )53;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_bl_rowid;
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
}



    if (OERROR)
         err_mesg("FETCH failed on cursor AR_CASHIER_CUR",0,"");

    d_bl_doc_type_code.arr[d_bl_doc_type_code.len] = '\0';
    d_bl_doc_num.arr[d_bl_doc_num.len]             = '\0';
    d_bl_doc_date.arr[d_bl_doc_date.len]           = '\0';
    d_bl_cust_code.arr[d_bl_cust_code.len]         = '\0';
    d_bl_doc_ref.arr[d_bl_doc_ref.len]             = '\0';
    d_bl_bank_desc.arr[d_bl_bank_desc.len]         = '\0';
    d_bl_cheque_num.arr[d_bl_cheque_num.len]       = '\0';
    d_bl_cheque_date.arr[d_bl_cheque_date.len]     = '\0';
    d_bl_narration.arr[d_bl_narration.len]         = '\0';
    d_bl_rowid.arr[d_bl_rowid.len]                 = '\0';

    if (LAST_ROW)
        return(0);
    else
        return(1);
}

fetch_cust_dets()
{
#ifdef DEBUG
  disp_message(INFO_MESG,"Inside fetch cust dets\n");
#endif

    /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )305;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_bl_cust_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
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

    d_ar_cust_long_name.arr[0]          = '\0';
    d_ar_cust_long_name.len             = 0;

    /* EXEC SQL FETCH AR_CUSTOMER_CUR
              INTO :d_ar_cust_long_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )324;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_cust_long_name;
    sqlstm.sqhstl[0] = (unsigned int  )103;
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
         err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

     d_ar_cust_long_name.arr[d_ar_cust_long_name.len] = '\0';

}

print_rec()
{
   char out_str[10][133];
   char s_amt[20];
   int  length_str[10];
   int  i = 0,no_of_lines = 0;

#ifdef DEBUG
  disp_message(INFO_MESG,"inside print rec\n");
#endif

/*
   fprintf(fp,"\f");
*/
  fprintf(fp ,"   %-30s\n\n  ",facility_name.arr ); 
  fprintf(fp , "\n\n");
 
   if ( nd_no_of_decimal == 3)
     sprintf(s_amt,"%15.3f",d_bl_amt_local);
   else   
     sprintf(s_amt,"%15.2f",d_bl_amt_local);
   
   format_amt(s_amt,nd_no_of_decimal);
 

   for(i=0;i<SKIP_1;i++) fprintf(fp,"\n");
   for(i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%-6s/%-8s\n\n",d_bl_doc_type_code.arr,
                             d_bl_doc_num.arr);
   for(i=0;i<SKIP_2;i++) fprintf(fp," ");
   fprintf(fp,"%10s\n",d_bl_doc_date.arr);
   for(i=0;i<SKIP_3;i++) fprintf(fp,"\n");
   fprintf(fp,"%80s\n\n\n",s_amt);
   for(i=0;i<SKIP_4;i++) fprintf(fp," ");
   fprintf(fp,"%-40s\n\n",d_ar_cust_long_name.arr);
   length_str[0] = 45;
   for (i =1;i<10;i++) 
      length_str[i] = 80; 
   for (i =1;i<10;i++) 
      strcpy(out_str[i],"");
      
   no_of_lines = print_in_words(d_bl_amt_local,length_str,sub_cur_str.arr,out_str,nd_no_of_decimal); 
   
  
   if(d_bl_amt_local)
     fprintf(fp, "%-6s", cur_str.arr);
   for(i=0;i<SKIP_5;i++) fprintf(fp," ");
   if(strlen(out_str[1]))
       strcat(out_str[1],")");
   else
       strcat(out_str[0],")");
   fprintf(fp,"   %s  (%s\n\n",s_amt,out_str[0]);
   fprintf(fp,"    %s\n\n",out_str[1]);

   for(i=0;i<SKIP_6;i++) fprintf(fp," ");
   fprintf(fp,"%s\n",d_bl_narration.arr);

   for(i=0;i<SKIP_7;i++) fprintf(fp,"\n");
   for(i=0;i<SKIP_8;i++) fprintf(fp," ");
   fprintf(fp,"CHEQUE\n\n");
   for(i=0;i<SKIP_8;i++) fprintf(fp," ");
   fprintf(fp,"%s\n",d_bl_cheque_num.arr);
   for(i=0;i<SKIP_8;i++) fprintf(fp," ");
   fprintf(fp,"%s\n",d_bl_cheque_date.arr);
   for(i=0;i<SKIP_8;i++) fprintf(fp," ");
   fprintf(fp,"%s\n",d_bl_bank_desc.arr);
   for(i=0;i<SKIP_9;i++) fprintf(fp,"\n");
   fflush(fp); 
/*
sprintf(string_var,"Document ->  %s / %s \n Dt -> %s Cust -> %s Doc ref -> %s Amount -> %f \ \n Bank desc -> %s chk dtls -> %s %s\n",
disp_message(INFO_MESG,string_var);
   d_bl_doc_type_code.arr,
   d_bl_doc_num.arr,
   d_bl_doc_date.arr,
   d_bl_cust_code.arr,
   d_bl_doc_ref.arr,
   d_bl_amt_local,
   d_bl_bank_desc.arr,
   d_bl_cheque_num.arr,
   d_bl_cheque_date.arr);
sprintf(string_var,"Cust name is <%s>\n",d_ar_cust_long_name.arr); 
disp_message(INFO_MESG,string_var);
*/
}

update_rec()
{

/*-- Rowid was giving problem. So it has been replaced by doc_type_code
     and doc_num. VSK 16/11/1999 */

    /* EXEC SQL UPDATE AR_CASHIER
                SET PRINT_FLAG = 'Y'
//				WHERE ROWID = :d_bl_rowid
              WHERE  DOC_TYPE_CODE  = :d_bl_doc_type_code 
			  AND    OPERATING_FACILITY_ID =:nd_facility_id //added by madhusudhan for GDOH-CRF-0107 ON 03/01/2017
			  and    DOC_NUM = :d_bl_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_CASHIER  set PRINT_FLAG='Y' where ((DOC_TYPE_CO\
DE=:b0 and OPERATING_FACILITY_ID=:b1) and DOC_NUM=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )343;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_bl_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
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
    sqlstm.sqhstv[2] = (         void  *)&d_bl_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )12;
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
         err_mesg("UPDATE failed on table AR_CASHIER",0,"");

    /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )370;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT failed",0,""); 
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


rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
}

