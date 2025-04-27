
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/GL/Glbcbmsl.pc"
};


static unsigned int sqlctx = 1288508107;


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
            void  *sqhstv[10];
   unsigned int   sqhstl[10];
            int   sqhsts[10];
            void  *sqindv[10];
            int   sqinds[10];
   unsigned int   sqharm[10];
   unsigned int   *sqharc[10];
   unsigned short  sqadto[10];
   unsigned short  sqtdso[10];
} sqlstm = {12,10};

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

 static const char *sq0004 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE  from GL_ACC_CHART where (((((MAIN_ACC\
1_CODE||MAIN_ACC2_CODE)>=(NVL(:b0,'      ')||NVL(:b1,'    ')) and (MAIN_ACC1_C\
ODE||MAIN_ACC2_CODE)<=(NVL(:b2,'~~~~~~')||NVL(:b3,'~~~~'))) and NVL(SUMMARY_AC\
C_FLAG,'X')<>'Y') and STATUS is null ) and SUBLEDGER_ENTRY_FLAG='Y')          \
 ";

 static const char *sq0005 = 
"select SUBLEDGER_GROUP_CODE  from GL_SUBLEDGER_GROUP where ((SUBLEDGER_GROUP\
_CODE>=NVL(:b0,'   ') and SUBLEDGER_GROUP_CODE<=NVL(:b1,'~~~')) and STATUS is \
null )           ";

 static const char *sq0006 = 
"select SUBLEDGER_LINE_CODE  from GL_SUBLEDGER_LINE where (((SUBLEDGER_GROUP_\
CODE=:b0 and (SUBLEDGER_GROUP_CODE||SUBLEDGER_LINE_CODE)>=(NVL(:b1,'   ')||NVL\
(:b2,'        '))) and (SUBLEDGER_GROUP_CODE||SUBLEDGER_LINE_CODE)<=(NVL(:b3,'\
~~~')||NVL(:b4,'~~~~~~~~'))) and STATUS is null )           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,190,0,4,147,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
60,0,0,2,0,0,29,232,0,0,0,0,0,1,0,
75,0,0,3,0,0,30,237,0,0,0,0,0,1,0,
90,0,0,7,61,0,4,285,0,0,1,0,0,1,0,2,9,0,0,
109,0,0,4,311,0,9,301,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
140,0,0,4,0,0,13,314,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
163,0,0,5,171,0,9,331,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
186,0,0,5,0,0,13,341,0,0,1,0,0,1,0,2,9,0,0,
205,0,0,6,292,0,9,362,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
240,0,0,6,0,0,13,372,0,0,1,0,0,1,0,2,9,0,0,
259,0,0,0,0,0,27,394,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
290,0,0,9,91,0,2,403,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
313,0,0,10,154,0,4,414,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
348,0,0,11,127,0,3,427,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                     */
/************************************************************************/
/* PROGRAM NAME          : GLBCBMSL.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 14-FEB-1993                                  */
/*                                                                      */
/* CONVERTED BY 		 : C. Ganesan ( 28/01/96 )                      */
/*                                                                      */
/* CALLED FROM           :                                               */
/*                                                                      */
/*  FUNCTION             :   Creates combination of records in          */
/*                           GL_MAIN_SUBLEDGER                          */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*          1.        GL_MAIN_SUBLEDGER       Query/Insert              */
/*          2.        GL_ACC_CHART               Lookup                 */
/*          4.        GL_PARAMETER               Lookup                 */
/*          5.        GL_SUBLEDGER_GROUP         Lookup                 */
/*          6.        GL_SUBLEDGER_LINE          Lookup                 */
/*          7.        SY_PROG_MSG                Insert                 */
/*          8.        SY_PROG_CONTROL         Query/Update              */
/*                                                                      */
/*  PARAMETERS           :                                              */
/*                                                                      */
/*      S. No.       Field Names                Default Values          */
/*                                                                      */
/*          1.  MAIN_ACC1_CODE From                Spaces               */
/*          2.  MAIN_ACC1_CODE To                 '~~~~~~'              */
/*          3.  MAIN_ACC2_CODE From                Spaces               */
/*          4.  MAIN_ACC2_CODE To                  '~~~~'               */
/*          5.  SUBLEDGER_GROUP_CODE From          Spaces               */
/*          6.  SUBLEDGER_GROUP_CODE To            '~~~'                */
/*          7.  SUBLEDGER_LINE_CODE From           Spaces               */
/*          8.  SUBLEDGER_LINE_CODE To            '~~~~~~~~'            */
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
#define VIEW_LOG_FILE   1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd[40]; */ 
struct { unsigned short len; unsigned char arr[40]; } uid_pwd;
  
                                                   /* LENGTH */
   /* VARCHAR  nd_session_id                [16],      
            nd_fm_main_acc1_code         [8],       /o   6    o/
            nd_to_main_acc1_code         [8],       /o   6    o/
            nd_fm_main_acc2_code         [6],       /o   4    o/
            nd_to_main_acc2_code         [6],       /o   4    o/
            nd_fm_subledger_group_code   [4],       /o   3    o/
            nd_to_subledger_group_code   [4],       /o   3    o/
            nd_fm_subledger_line_code    [10],      /o   8    o/
            nd_to_subledger_line_code    [10],      /o   8    o/
 
            d_subledger_applicable_flag  [2],       /o   1    o/
            d_main_acc1_code             [8],       /o   6    o/
            d_main_acc2_code             [6],       /o   4    o/
            d_subledger_group_code       [4],       /o   3    o/
            d_subledger_line_code        [10],      /o   8    o/
	    d_pgm_date                   [14],      /o   12   o/
            dummy                        [10][10]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[8]; } nd_fm_main_acc1_code;

struct { unsigned short len; unsigned char arr[8]; } nd_to_main_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } nd_fm_main_acc2_code;

struct { unsigned short len; unsigned char arr[6]; } nd_to_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } nd_fm_subledger_group_code;

struct { unsigned short len; unsigned char arr[4]; } nd_to_subledger_group_code;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_subledger_line_code;

struct { unsigned short len; unsigned char arr[10]; } nd_to_subledger_line_code;

struct { unsigned short len; unsigned char arr[2]; } d_subledger_applicable_flag;

struct { unsigned short len; unsigned char arr[8]; } d_main_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } d_main_acc2_code;

struct { unsigned short len; unsigned char arr[4]; } d_subledger_group_code;

struct { unsigned short len; unsigned char arr[10]; } d_subledger_line_code;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[10]; } dummy[10];

 
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





#include "winproc.h"

void declare_cursors(),
     fetch_param(),
     open_acc_chart_cur(),
     open_subledger_group(),
     open_subledger_line(),
     del_param(),
     insert_combination();

int fetch_acc_chart(),
    fetch_subledger_group(),
    fetch_subledger_line(),
    sql_connect();


void chk_active();
void start_prog_msg();
void start_prog_control();
void end_prog_msg();
void end_prog_control();
void err_mesg(char *, int, char *);
int  get_message(char *, char *);


     
void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc != 5)
   {
      disp_message ( ERR_MESG, "Usage glbcbmsl uid/passwd session_id pgm_date facility_id");
      proc_exit();
   }

   
   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);
   strcpy(g_pgm_id,"GLBCBMSL");

  
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

   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,
                   PARAM5,PARAM6,PARAM7,PARAM8
              INTO :nd_fm_main_acc1_code,
                   :nd_fm_main_acc2_code,
                   :nd_to_main_acc1_code,
                   :nd_to_main_acc2_code,
                   :nd_fm_subledger_group_code,
                   :nd_fm_subledger_line_code,
                   :nd_to_subledger_group_code,
                   :nd_to_subledger_line_code
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'GLBCBMSL' 
               AND SESSION_ID = :nd_session_id 
	       AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_PARAM where ((P\
GM_ID='GLBCBMSL' and SESSION_ID=:b8) and PGM_DATE=:b9)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_subledger_group_code;
   sqlstm.sqhstl[4] = (unsigned int  )6;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_subledger_line_code;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_subledger_group_code;
   sqlstm.sqhstl[6] = (unsigned int  )6;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_subledger_line_code;
   sqlstm.sqhstl[7] = (unsigned int  )12;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[8] = (unsigned int  )18;
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
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
      sprintf (err_msg, "Session_id <%s> & Pgm_id GLBCBMSL\n",nd_session_id.arr);
      disp_message ( ERR_MESG, err_msg);
      err_mesg("Record not existing in Parameter Table\n",0,"");
    } 

 nd_fm_main_acc1_code.arr[nd_fm_main_acc1_code.len]             = '\0';
 nd_to_main_acc1_code.arr[nd_to_main_acc1_code.len]             = '\0';
 nd_fm_main_acc2_code.arr[nd_fm_main_acc2_code.len]             = '\0';
 nd_to_main_acc2_code.arr[nd_to_main_acc2_code.len]             = '\0';
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
   printf("subledger gr fr is <%s>\n",nd_fm_subledger_group_code.arr);
   printf("subledger gr to is <%s>\n",nd_to_subledger_group_code.arr);
   printf("subledger ln fr is <%s>\n",nd_fm_subledger_line_code.arr);
   printf("subledger ln to is <%s>\n",nd_to_subledger_line_code.arr);
#endif

*/

   start_prog_control();
   
   start_prog_msg();
   
   fetch_param();
  
   declare_cursors();
   

    if (SL_APPL)
    {
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
          open_subledger_group();
            while (fetch_subledger_group())
            {
                open_subledger_line();
                while (fetch_subledger_line())
                {
                  insert_combination();
                }
            }
        }
        /* EXEC SQL COMMIT WORK; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 10;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )60;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    }
    end_prog_msg();
    end_prog_control();
    del_param();
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )75;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return;
}
 
void declare_cursors()
{

    /* EXEC SQL DECLARE   GL_ACC_CHART_CUR CURSOR FOR
              SELECT   MAIN_ACC1_CODE,
                       MAIN_ACC2_CODE
                FROM   GL_ACC_CHART
               WHERE   MAIN_ACC1_CODE||MAIN_ACC2_CODE >= 
                               NVL(:nd_fm_main_acc1_code,'      ')||
                               NVL(:nd_fm_main_acc2_code,'    ')
                 AND   MAIN_ACC1_CODE||MAIN_ACC2_CODE <= 
                               NVL(:nd_to_main_acc1_code,'~~~~~~')||
                               NVL(:nd_to_main_acc2_code,'~~~~')
                 AND   NVL(SUMMARY_ACC_FLAG,'X')  != 'Y'
                 AND   STATUS IS NULL
                 AND   SUBLEDGER_ENTRY_FLAG = 'Y'; */ 


    /* EXEC SQL DECLARE   GL_SUBLEDGER_GROUP_CUR CURSOR FOR
              SELECT   SUBLEDGER_GROUP_CODE
                FROM   GL_SUBLEDGER_GROUP
               WHERE   SUBLEDGER_GROUP_CODE >=
                              NVL(:nd_fm_subledger_group_code,'   ')
                 AND   SUBLEDGER_GROUP_CODE <=
                              NVL(:nd_to_subledger_group_code,'~~~')
                 AND   STATUS IS NULL; */ 


    /* EXEC SQL DECLARE   GL_SUBLEDGER_LINE_CUR CURSOR FOR
              SELECT   SUBLEDGER_LINE_CODE
                FROM   GL_SUBLEDGER_LINE
               WHERE   SUBLEDGER_GROUP_CODE = :d_subledger_group_code
                 AND   SUBLEDGER_GROUP_CODE || SUBLEDGER_LINE_CODE >=
                              NVL(:nd_fm_subledger_group_code,'   ')||
                              NVL(:nd_fm_subledger_line_code,'        ')
                 AND   SUBLEDGER_GROUP_CODE || SUBLEDGER_LINE_CODE <=
                              NVL(:nd_to_subledger_group_code,'~~~')||
                              NVL(:nd_to_subledger_line_code,'~~~~~~~~')
                 AND   STATUS IS NULL; */ 

}

void fetch_param()
{
  d_subledger_applicable_flag.arr[0]     = '\0';
  d_subledger_applicable_flag.len        = 0;

   /* EXEC SQL SELECT   SUBLEDGER_APPLICABLE_FLAG
              INTO   :d_subledger_applicable_flag
              FROM   GL_PARAMETER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBLEDGER_APPLICABLE_FLAG into :b0  from GL_PARAMET\
ER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )90;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_subledger_applicable_flag;
   sqlstm.sqhstl[0] = (unsigned int  )4;
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



    if (OERROR) err_mesg("Error while Fetching Parameters..",0,"");

    d_subledger_applicable_flag.arr[d_subledger_applicable_flag.len]     = '\0';

    if (NOT_FOUND)
    {
       err_mesg("No Record Exists in GL_PARAMETER",0,"");
    }
}

void open_acc_chart_cur()
{
    /* EXEC SQL OPEN GL_ACC_CHART_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )109;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
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

    d_main_acc1_code.len          = 0;
    d_main_acc2_code.len          = 0;

    /* EXEC SQL FETCH   GL_ACC_CHART_CUR
              INTO   :d_main_acc1_code,
                     :d_main_acc2_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )140;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
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



    if (OERROR) err_mesg("Error while Fetching GL_ACC_CHART_CURSOR..",0,"");

    d_main_acc1_code.arr[d_main_acc1_code.len]             = '\0';
    d_main_acc2_code.arr[d_main_acc2_code.len]             = '\0';
 
    if (LAST_ROW)
        return (0);
    else
        return (1);
}

void open_subledger_group()
{
   /* EXEC SQL OPEN GL_SUBLEDGER_GROUP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )163;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_subledger_group_code;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_subledger_group_code;
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



   if (OERROR) err_mesg("Error while opening GL_SUBLEDGER_GROUP_CUR",0,"");
}

int fetch_subledger_group()
{
    d_subledger_group_code.arr[0] = '\0';
    d_subledger_group_code.len    = 0;

    /* EXEC SQL FETCH   GL_SUBLEDGER_GROUP_CUR
              INTO   :d_subledger_group_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )186;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
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



    if (OERROR) err_mesg("Error while fetching GL_SUBLEDGER_GROUP_CUR",0,"");
  
    d_subledger_group_code.arr[d_subledger_group_code.len] = '\0';
/*
#ifdef DEBUG
   printf("Subledger gr is <%s> <%d>\n",d_subledger_group_code.arr,
                     d_subledger_group_code.len);
#endif
*/

    if (LAST_ROW)
       return(0);
    else 
       return(1); 
}

void open_subledger_line()
{
   /* EXEC SQL OPEN GL_SUBLEDGER_LINE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )205;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_subledger_group_code;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_subledger_group_code;
   sqlstm.sqhstl[1] = (unsigned int  )6;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_subledger_line_code;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_subledger_group_code;
   sqlstm.sqhstl[3] = (unsigned int  )6;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_subledger_line_code;
   sqlstm.sqhstl[4] = (unsigned int  )12;
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



   if (OERROR) err_mesg("Error while opening GL_SUBLEDGER_LINE_CUR",0,"");
}

int fetch_subledger_line()
{
    d_subledger_line_code.arr[0]  = '\0';
    d_subledger_line_code.len     = 0;

    /* EXEC SQL FETCH   GL_SUBLEDGER_LINE_CUR
              INTO   :d_subledger_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )240;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_subledger_line_code;
    sqlstm.sqhstl[0] = (unsigned int  )12;
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
 
   d_subledger_line_code.arr[d_subledger_line_code.len]  = '\0';
/*  
#ifdef DEBUG
   printf("Subledger ln is <%s> <%d>\n",d_subledger_line_code.arr,
                     d_subledger_line_code.len);
#endif
*/

   if (LAST_ROW)
      return(0);
   else 
      return(1); 
}

int sql_connect()
{

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )259;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

void del_param()
{
	/* EXEC SQL DELETE SY_PROG_PARAM
	         WHERE  PGM_ID     = 'GLBCBMSL' 
		 AND    SESSION_ID = :nd_session_id 
	         AND    PGM_DATE   = :d_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='GLBCBMSL' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )290;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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

void insert_combination()
{
 
    /* EXEC SQL SELECT 'X' 
               INTO :dummy
               FROM GL_MAIN_SUBLEDGER
              WHERE MAIN_ACC1_CODE = :d_main_acc1_code
                AND MAIN_ACC2_CODE = :d_main_acc2_code
                AND SUBLEDGER_GROUP_CODE = :d_subledger_group_code
                AND SUBLEDGER_LINE_CODE = :d_subledger_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select 'X' into :b0  from GL_MAIN_SUBLEDGER where (((MAIN\
_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and SUBLEDGER_GROUP_CODE=:b3) and SUBLE\
DGER_LINE_CODE=:b4)";
    sqlstm.iters = (unsigned int  )10;
    sqlstm.offset = (unsigned int  )313;
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
    sqlstm.sqhstv[1] = (         void  *)&d_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )10;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )8;
    sqlstm.sqhsts[2] = (         int  )8;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_subledger_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )6;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_subledger_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )12;
    sqlstm.sqhsts[4] = (         int  )12;
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
         err_mesg("SELECT failed on table GL_MAIN_SUBLEDGER",0,"");
        
    if (NOT_FOUND)
    {
       /* EXEC SQL INSERT INTO GL_MAIN_SUBLEDGER
                     (
                       MAIN_ACC1_CODE,
                       MAIN_ACC2_CODE,
                       SUBLEDGER_GROUP_CODE,
                       SUBLEDGER_LINE_CODE
                     )
               VALUES 
                     (
                       :d_main_acc1_code,
                       :d_main_acc2_code,
                       :d_subledger_group_code,
                       :d_subledger_line_code
                     ); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 10;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "insert into GL_MAIN_SUBLEDGER (MAIN_ACC1_CODE,MAIN_ACC\
2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE) values (:b0,:b1,:b2,:b3)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )348;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
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
       sqlstm.sqhstv[2] = (         void  *)&d_subledger_group_code;
       sqlstm.sqhstl[2] = (unsigned int  )6;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&d_subledger_line_code;
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


         if (OERROR)
               err_mesg("INSERT failed on table GL_MAIN_SUBLEDGER",0,"");
      }

}
