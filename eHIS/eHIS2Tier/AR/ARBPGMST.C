
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
    "C:\\AR10.2\\Arbpgmst.pc"
};


static unsigned long sqlctx = 141981387;


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

 static const char *sq0004 = 
"select CUST_TYPE_CODE  from AR_CUST_TYPE where NVL(STATUS,'N')='S'          \
 ";

 static const char *sq0005 = 
"select 'X'  from AR_CUSTOMER where CUST_TYPE_CODE=:b0           ";

 static const char *sq0007 = 
"select CUST_GROUP_CODE  from AR_CUST_GROUP where NVL(STATUS,'N')='S'        \
   ";

 static const char *sq0008 = 
"select 'X'  from AR_CUSTOMER where CUST_GROUP_CODE=:b0           ";

 static const char *sq0010 = 
"select PMNT_TERMS_CODE  from AR_PMNT_TERMS where NVL(STATUS,'N')='S'        \
   ";

 static const char *sq0011 = 
"select 'X'  from AR_CUSTOMER where PMNT_TERMS_CODE=:b0           ";

 static const char *sq0013 = 
"select LETTER_TYPE_CODE  from AR_REM_LETTER where NVL(STATUS,'N')='S'       \
    ";

 static const char *sq0014 = 
"select 'X'  from AR_CUSTOMER where REM_LETTER_CODE=:b0           ";

 static const char *sq0016 = 
"select CUST_CODE  from AR_CUSTOMER where NVL(STATUS,'N')='S'           ";

 static const char *sq0017 = 
"select 'X'  from AR_PENDING_DOC where CUST_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,92,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,144,0,4,108,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
67,0,0,3,0,0,30,142,0,0,0,0,0,1,0,
82,0,0,4,77,0,9,159,0,0,0,0,0,1,0,
97,0,0,5,64,0,9,167,0,0,1,1,0,1,0,1,9,0,0,
116,0,0,5,0,0,13,171,0,0,1,0,0,1,0,2,9,0,0,
135,0,0,5,0,0,15,178,0,0,0,0,0,1,0,
150,0,0,6,51,0,2,181,0,0,1,1,0,1,0,1,9,0,0,
169,0,0,4,0,0,15,187,0,0,0,0,0,1,0,
184,0,0,4,0,0,13,193,0,0,1,0,0,1,0,2,9,0,0,
203,0,0,7,79,0,9,221,0,0,0,0,0,1,0,
218,0,0,8,65,0,9,229,0,0,1,1,0,1,0,1,9,0,0,
237,0,0,8,0,0,13,233,0,0,1,0,0,1,0,2,9,0,0,
256,0,0,8,0,0,15,240,0,0,0,0,0,1,0,
271,0,0,9,53,0,2,243,0,0,1,1,0,1,0,1,9,0,0,
290,0,0,7,0,0,15,249,0,0,0,0,0,1,0,
305,0,0,7,0,0,13,255,0,0,1,0,0,1,0,2,9,0,0,
324,0,0,10,79,0,9,283,0,0,0,0,0,1,0,
339,0,0,11,65,0,9,291,0,0,1,1,0,1,0,1,9,0,0,
358,0,0,11,0,0,13,295,0,0,1,0,0,1,0,2,9,0,0,
377,0,0,11,0,0,15,302,0,0,0,0,0,1,0,
392,0,0,12,53,0,2,305,0,0,1,1,0,1,0,1,9,0,0,
411,0,0,10,0,0,15,311,0,0,0,0,0,1,0,
426,0,0,10,0,0,13,317,0,0,1,0,0,1,0,2,9,0,0,
445,0,0,13,80,0,9,344,0,0,0,0,0,1,0,
460,0,0,14,65,0,9,352,0,0,1,1,0,1,0,1,9,0,0,
479,0,0,14,0,0,13,356,0,0,1,0,0,1,0,2,9,0,0,
498,0,0,14,0,0,15,363,0,0,0,0,0,1,0,
513,0,0,15,54,0,2,366,0,0,1,1,0,1,0,1,9,0,0,
532,0,0,13,0,0,15,372,0,0,0,0,0,1,0,
547,0,0,13,0,0,13,378,0,0,1,0,0,1,0,2,9,0,0,
566,0,0,16,71,0,9,405,0,0,0,0,0,1,0,
581,0,0,17,62,0,9,413,0,0,1,1,0,1,0,1,9,0,0,
600,0,0,17,0,0,13,417,0,0,1,0,0,1,0,2,9,0,0,
619,0,0,17,0,0,15,424,0,0,0,0,0,1,0,
634,0,0,18,45,0,2,427,0,0,1,1,0,1,0,1,9,0,0,
653,0,0,16,0,0,15,433,0,0,0,0,0,1,0,
668,0,0,16,0,0,13,439,0,0,1,0,0,1,0,2,9,0,0,
687,0,0,19,50,0,3,467,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
718,0,0,20,91,0,2,480,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
};


/******************************************************************************/
/* OCS MEDICOM VER 1.0                                                         */
/******************************************************************************/
/* PROGRAM NAME     : ARBPGMST                                                */
/* AUTHOR           :                                                         */
/* DATE WRITTEN     : Tue Dec 01 12:40:08 OMAN 1992                           */
/*                                                                                              */
/* CALLED FROM      : form- ARBPGMST                                          */
/*                                                                             */
/* INPUT PARAMETERS : SESSION_ID                                              */
/*                                                                            */
/* INPUT TAKEN FROM : 1. TABLE_ID                                             */
/* SY_PROG_PARAM                                                              */
/*                                                                                */
/* TABLED ACCESSED/ : AR_CUSTOMER                                             */
/*        UPDATED     AR_PENDING_DOC_TEMP                                     */
/*                    AR_PENDING_DOC                                          */
/*                    AR_CUST_TYPE                                            */
/*                    AR_CUST_GROUP                                           */
/*                    AR_PMNT_TERMS                                           */
/*                    AR_REM_LETTERS                                          */
/*                    AR_PURGE_MSG                                            */
/*                                                                            */
/* FUNCTION         : This program purges (deletes) suspended rows from tables*/
/*                    AR_CUST_TYPE,AR_CUST_GROUP, AR_PMNT_TERMS,AR_REM_LETTER,*/
/*                    AR_CUSTOMER                                             */
/*                    after checking references in corresponding tables.      */
/*                    Errors are logged (inserted) into table AR_PURGE_MSG.   */
/*                                                                            */
/******************************************************************************/


#include <stdio.h>
#include <string.h>
#include <gl.h>

#define VIEW_LOG_FILE   1  

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* varchar uid_pwd[15],
        d_session_id[16],
        d_pgm_date[12]; */ 
struct { unsigned short len; unsigned char arr[15]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[12]; } d_pgm_date;


/* varchar d_msg_num[9]; */ 
struct { unsigned short len; unsigned char arr[9]; } d_msg_num;

/* varchar d_msg_desc[71]; */ 
struct { unsigned short len; unsigned char arr[71]; } d_msg_desc;

/* varchar d_table_id[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_table_id;

/* varchar d_master_code[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_master_code;

/* varchar d_cust_type_code[3]; */ 
struct { unsigned short len; unsigned char arr[3]; } d_cust_type_code;

/* varchar d_cust_group_code[3]; */ 
struct { unsigned short len; unsigned char arr[3]; } d_cust_group_code;

/* varchar d_letter_type_code[3]; */ 
struct { unsigned short len; unsigned char arr[3]; } d_letter_type_code;

/* varchar d_pmnt_terms_code[3]; */ 
struct { unsigned short len; unsigned char arr[3]; } d_pmnt_terms_code;

/* varchar d_cust_code[9]; */ 
struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

/* varchar d_dummy[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_dummy;
                               /* for fetching the cursors */
/* varchar nd_facility_id[3]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


/* EXEC SQL END DECLARE SECTION; */ 


// EXEC ORACLE OPTION(HOLD_CURSOR = YES);
// EXEC ORACLE OPTION(REBIND = NO);

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

int can_delete;

void proc_main(argc,argv)
int argc;
char *argv[];

{
    char mesg1[50];
    if(argc !=5) {
        disp_message(ERR_MESG,"ARBPGMST: Usage arbpgmst userid/password session_id pgm_date facility_id");
        proc_exit();
    }

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);

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
    sqlstm.sqhstl[0] = (unsigned int  )17;
    sqlstm.sqhsts[0] = (         int  )17;
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

    

    if(OERROR) {
        disp_message(ERR_MESG,"Unable to connect to oracle.");
        sprintf(mesg1,"%s\n",sqlca.sqlerrm.sqlerrmc);
        disp_message(ERR_MESG,mesg1);
        proc_exit();
    }
        
    /****** COPY THE NAME OF THE PROGRAM HERE *********/

    strcpy(g_pgm_id,"ARBPGMST");

	set_meduser_role();
	chk_active();
   
    /* EXEC SQL SELECT operating_facility_id,PARAM1
         INTO   nd_facility_id,:d_table_id
         FROM   SY_PROG_PARAM
         WHERE  PGM_ID = 'ARBPGMST'
         AND    PGM_DATE = :d_pgm_date
         AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select operating_facility_id ,PARAM1 into :b0,:b1  from S\
Y_PROG_PARAM where ((PGM_ID='ARBPGMST' and PGM_DATE=:b2) and SESSION_ID=TO_NUM\
BER(:b3))";
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
    sqlstm.sqhstv[1] = (         void  *)&d_table_id;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_session_id;
    sqlstm.sqhstl[3] = (unsigned int  )18;
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



    if(OERROR || NO_DATA_FOUND)
        err_mesg("Reading parameters from SY_PROG_PARAM",0,"");

    d_table_id.arr[d_table_id.len] = '\0';

    start_prog_control();
    start_prog_msg();

    /* BASED ON TABLE_ID CALL APPROPRIATE PURGING FUNCTION */

    if     (!strcmp(d_table_id.arr,"AR_CUST_TYPE"))
        purge_cust_type();
    else if(!strcmp(d_table_id.arr,"AR_CUST_GROUP"))
        purge_cust_group();
    else if(!strcmp(d_table_id.arr,"AR_PMNT_TERMS"))
        purge_pmnt_terms();
    else if(!strcmp(d_table_id.arr,"AR_REM_LETTER"))
        purge_rem_letter();
    else if(!strcmp(d_table_id.arr,"AR_CUSTOMER"))
        purge_customer();
    else 
        err_mesg("Invalid Table Id",0,"");

    end_prog_msg();
    end_prog_control();
    del_param();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )67;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
} /* end of main */

purge_cust_type()
{

        /* EXEC SQL DECLARE AR_CUST_TYPE_CUR CURSOR FOR
            SELECT CUST_TYPE_CODE 
            FROM   AR_CUST_TYPE
            WHERE  NVL(STATUS,'N') = 'S'; */ 


        /* EXEC SQL DECLARE AR_CUSTOMER_CUR1 CURSOR FOR
             SELECT 'X' 
             FROM   AR_CUSTOMER
             WHERE  CUST_TYPE_CODE = :d_cust_type_code; */ 


        /* EXEC SQL OPEN AR_CUST_TYPE_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0004;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )82;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        if(OERROR)
            err_mesg("OPEN failed on cursor AR_CUST_TYPE_CUR",0,"");

        while(fetch_cust_type()) {
            
            can_delete = TRUE;

            /* EXEC SQL OPEN AR_CUSTOMER_CUR1; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0005;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )97;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_cust_type_code;
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


            if(OERROR) 
                err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR1",0,"");

            /* EXEC SQL FETCH AR_CUSTOMER_CUR1 INTO  :d_dummy; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )116;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_dummy;
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


            if(OERROR) 
                err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR1",0,"");

            if(sqlca.sqlcode EQ 0) 
                log_mesg("AR1500");

            /* EXEC SQL CLOSE AR_CUSTOMER_CUR1; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )135;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if (can_delete) {
               /* EXEC SQL DELETE FROM AR_CUST_TYPE
                    WHERE  CUST_TYPE_CODE = :d_cust_type_code; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_CUST_TYPE  where CUST_TYPE_COD\
E=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )150;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqhstv[0] = (         void  *)&d_cust_type_code;
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


                if(OERROR)
                    err_mesg("DELETE failed on table AR_CUST_TYPE",0,"");
            }
        } /* end of while */
        /* EXEC SQL CLOSE AR_CUST_TYPE_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )169;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


} /* end of purge_cust_type */

fetch_cust_type()
{

    /* EXEC SQL FETCH AR_CUST_TYPE_CUR INTO  :d_cust_type_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )184;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_type_code;
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



    if(OERROR)
    err_mesg("FETCH failed on cursor AR_CUST_TYPE_CUR",0,"");

    if(NO_DATA_FOUND) return 0;
    
    d_cust_type_code.arr[d_cust_type_code.len] = '\0';

    strcpy(d_master_code.arr,d_cust_type_code.arr);
    d_master_code.len = strlen(d_master_code.arr);

    return 1;
}

purge_cust_group()
{

        /* EXEC SQL DECLARE AR_CUST_GROUP_CUR CURSOR FOR
            SELECT CUST_GROUP_CODE 
            FROM   AR_CUST_GROUP
            WHERE  NVL(STATUS,'N') = 'S'; */ 


        /* EXEC SQL DECLARE AR_CUSTOMER_CUR2 CURSOR FOR 
            SELECT 'X' 
             FROM   AR_CUSTOMER
             WHERE  CUST_GROUP_CODE = :d_cust_group_code; */ 


        /* EXEC SQL OPEN AR_CUST_GROUP_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
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
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        if(OERROR)
            err_mesg("OPEN failed on cursor AR_CUST_GROUP_CUR",0,"");

        while (fetch_cust_group()) {

            can_delete = TRUE;

            /* EXEC SQL OPEN AR_CUSTOMER_CUR2; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0008;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )218;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_cust_group_code;
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


            if(OERROR) 
                err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR2",0,"");

            /* EXEC SQL FETCH AR_CUSTOMER_CUR2 INTO  :d_dummy; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )237;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_dummy;
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


            if(OERROR) 
                err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR2",0,"");

            if(sqlca.sqlcode EQ 0) 
                log_mesg("AR1510");

            /* EXEC SQL CLOSE AR_CUSTOMER_CUR2; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )256;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if (can_delete) {
               /* EXEC SQL DELETE FROM AR_CUST_GROUP
                    WHERE  CUST_GROUP_CODE = :d_cust_group_code; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.stmt = "delete  from AR_CUST_GROUP  where CUST_GROUP_C\
ODE=:b0";
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )271;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlstm.sqhstv[0] = (         void  *)&d_cust_group_code;
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


                if(OERROR)
                    err_mesg("DELETE failed on table AR_CUST_GROUP",0,"");
            }
        } /* end of while */
        /* EXEC SQL CLOSE AR_CUST_GROUP_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )290;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


} /* end of purge_cust_group */

fetch_cust_group()
{

    /* EXEC SQL FETCH AR_CUST_GROUP_CUR
         INTO  :d_cust_group_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )305;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_group_code;
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



    if(OERROR)
    err_mesg("FETCH failed on cursor AR_CUST_GROUP_CUR",0,"");

    if(NO_DATA_FOUND) return 0;
    
    d_cust_group_code.arr[d_cust_group_code.len] = '\0';

    strcpy(d_master_code.arr,d_cust_group_code.arr);
    d_master_code.len = strlen(d_master_code.arr);

    return 1;
} /* end of fetch_cust_group */

purge_pmnt_terms()
{
        /* EXEC SQL DECLARE AR_PMNT_TERMS_CUR CURSOR FOR
                 SELECT PMNT_TERMS_CODE 
                 FROM   AR_PMNT_TERMS
                 WHERE  NVL(STATUS,'N') = 'S'; */ 


        /* EXEC SQL DECLARE AR_CUSTOMER_CUR3 CURSOR FOR 
                 SELECT 'X' 
                 FROM   AR_CUSTOMER
                 WHERE  PMNT_TERMS_CODE = :d_pmnt_terms_code; */ 


        /* EXEC SQL OPEN AR_PMNT_TERMS_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0010;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )324;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        if(OERROR)
            err_mesg("OPEN failed on cursor AR_CUST_TYPE_CUR",0,"");

        while (fetch_pmnt_terms()) {

            can_delete = TRUE;

            /* EXEC SQL OPEN AR_CUSTOMER_CUR3; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0011;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )339;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_pmnt_terms_code;
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


            if(OERROR) 
                err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR2",0,"");

            /* EXEC SQL FETCH AR_CUSTOMER_CUR3 INTO  :d_dummy; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )358;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_dummy;
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


            if(OERROR) 
                err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR2",0,"");

            if(sqlca.sqlcode EQ 0) 
                log_mesg("AR1520");

            /* EXEC SQL CLOSE AR_CUSTOMER_CUR3; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )377;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if (can_delete) {
                /* EXEC SQL DELETE FROM AR_PMNT_TERMS
                        WHERE  PMNT_TERMS_CODE = :d_pmnt_terms_code; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 4;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = "delete  from AR_PMNT_TERMS  where PMNT_TERMS_\
CODE=:b0";
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )392;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&d_pmnt_terms_code;
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


                if(OERROR) 
                    err_mesg("DELETE failed on table AR_PMNT_TERMS",0,"");
            }
        } /* end of while */
        /* EXEC SQL CLOSE AR_PMNT_TERMS_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )411;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


} /* end of purge_pmnt_terms */

fetch_pmnt_terms()
{

    /* EXEC SQL FETCH AR_PMNT_TERMS_CUR INTO  :d_pmnt_terms_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )426;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pmnt_terms_code;
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



    if(OERROR)
    err_mesg("FETCH failed on cursor AR_PMNT_TERMS_CUR",0,"");

    if(NO_DATA_FOUND) return 0;
    
    d_pmnt_terms_code.arr[d_pmnt_terms_code.len] = '\0';

    strcpy(d_master_code.arr,d_pmnt_terms_code.arr);
    d_master_code.len = strlen(d_master_code.arr);

    return 1;
} /* end of fetch_pmnt_terms */

purge_rem_letter()
{
        /* EXEC SQL DECLARE AR_REM_LETTER_CUR CURSOR FOR
            SELECT LETTER_TYPE_CODE 
            FROM   AR_REM_LETTER
            WHERE  NVL(STATUS,'N') = 'S'; */ 


        /* EXEC SQL DECLARE AR_CUSTOMER_CUR4 CURSOR FOR
            SELECT 'X' 
             FROM   AR_CUSTOMER
             WHERE  REM_LETTER_CODE = :d_letter_type_code; */ 


        /* EXEC SQL OPEN AR_REM_LETTER_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0013;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )445;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        if(OERROR)
            err_mesg("OPEN failed on cursor AR_REM_LETTER",0,"");

        while (fetch_rem_letter()) {

            can_delete = TRUE;

            /* EXEC SQL OPEN AR_CUSTOMER_CUR4; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0014;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )460;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_letter_type_code;
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


            if(OERROR) 
                err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR4",0,"");

            /* EXEC SQL FETCH AR_CUSTOMER_CUR4 INTO  :d_dummy; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )479;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_dummy;
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


            if(OERROR) 
                err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR4",0,"");

            if(sqlca.sqlcode EQ 0) 
                log_mesg("AR1550");

            /* EXEC SQL CLOSE AR_CUSTOMER_CUR4; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )498;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if (can_delete) {
                /* EXEC SQL DELETE FROM AR_REM_LETTER
                        WHERE  LETTER_TYPE_CODE = :d_letter_type_code; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 4;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = "delete  from AR_REM_LETTER  where LETTER_TYPE\
_CODE=:b0";
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )513;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&d_letter_type_code;
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


                if(OERROR) 
                    err_mesg("DELETE failed on table AR_REM_LETTER",0,"");
            }
        } /* end of while */
        /* EXEC SQL CLOSE AR_REM_LETTER_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )532;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


} /* end of purge_rem_letter */

fetch_rem_letter()
{

    /* EXEC SQL FETCH AR_REM_LETTER_CUR INTO  :d_letter_type_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )547;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_letter_type_code;
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



    if(OERROR)
    err_mesg("FETCH failed on cursor AR_REM_LETTER_CUR",0,"");

    if(NO_DATA_FOUND) return 0;
    
    d_letter_type_code.arr[d_letter_type_code.len] = '\0';

    strcpy(d_master_code.arr,d_letter_type_code.arr);
    d_master_code.len = strlen(d_master_code.arr);

    return 1;
} /* end of fetch_rem_letter */

purge_customer()
{ 
        /* EXEC SQL DECLARE AR_CUSTOMER_CUR5 CURSOR FOR
            SELECT CUST_CODE
            FROM   AR_CUSTOMER
            WHERE  NVL(STATUS,'N') = 'S'; */ 


        /* EXEC SQL DECLARE AR_PENDING_DOC_CUR2 CURSOR FOR
             SELECT 'X' 
             FROM   AR_PENDING_DOC
             WHERE  CUST_CODE = :d_cust_code; */ 


        /* EXEC SQL OPEN AR_CUSTOMER_CUR5; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0016;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )566;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        if(OERROR)
            err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR5",0,"");

        while (fetch_customer()) {

            can_delete = TRUE;

            /* EXEC SQL OPEN AR_PENDING_DOC_CUR2; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0017;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )581;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
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


            if(OERROR) 
                err_mesg("OPEN failed on cursor AR_PENDING_DOC_CUR2",0,"");

            /* EXEC SQL FETCH AR_PENDING_DOC_CUR2 INTO  :d_dummy; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )600;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_dummy;
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


            if(OERROR) 
                err_mesg("FETCH failed on cursor AR_PENDING_DOC_CUR2",0,"");

            if(sqlca.sqlcode EQ 0) 
                log_mesg("AR1570");

            /* EXEC SQL CLOSE AR_PENDING_DOC_CUR2; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 4;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )619;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if (can_delete) {
                /* EXEC SQL DELETE FROM AR_CUSTOMER
                        WHERE  CUST_CODE = :d_cust_code; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 4;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = "delete  from AR_CUSTOMER  where CUST_CODE=:b0";
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )634;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
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


                if(OERROR)
                    err_mesg("DELETE failed on table AR_CUSTOMER",0,"");
            }
        } /* end of while */
        /* EXEC SQL CLOSE AR_CUSTOMER_CUR5; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )653;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


} /* end of purge_customer */

fetch_customer()
{

    /* EXEC SQL FETCH AR_CUSTOMER_CUR5
         INTO  :d_cust_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )668;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
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



    if(OERROR)
    err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR5",0,"");

    if(NO_DATA_FOUND) return 0;
    
    d_cust_code.arr[d_cust_code.len] = '\0';

    strcpy(d_master_code.arr,d_cust_code.arr);
    d_master_code.len = strlen(d_master_code.arr);

    return 1;
} /* end of fetch_customer */


log_mesg(l_errid)
char *l_errid;
{
    can_delete = FALSE;
    strcpy(d_msg_num.arr,l_errid);

    get_message(d_msg_num.arr,d_msg_desc.arr);

    d_msg_num.len = strlen(d_msg_num.arr);
    d_msg_desc.len = strlen(d_msg_desc.arr);

    /* EXEC SQL INSERT INTO AR_PURGE_MSG
         VALUES (:d_table_id,
             :d_master_code,
             :d_msg_num,
             :d_msg_desc
            ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into AR_PURGE_MSG  values (:b0,:b1,:b2,:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )687;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_table_id;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_master_code;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_msg_num;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_msg_desc;
    sqlstm.sqhstl[3] = (unsigned int  )73;
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



    if(OERROR) 
    err_mesg("INSERT failed on table AR_PURGE_MSG",0,"");
} /* end of log_mesg */

del_param()
{
    /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE  PGM_ID     = 'ARBPGMST' 
             AND    PGM_DATE = :d_pgm_date
             AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARBPGMST' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )718;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )14;
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


    if(OERROR) 
    err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 

} /* end of log_mesg */
