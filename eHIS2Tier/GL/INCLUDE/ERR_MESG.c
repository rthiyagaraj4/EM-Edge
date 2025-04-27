
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
           char  filnam[28];
};
static const struct sqlcxp sqlfpn =
{
    27,
    "T:\\temp\\Finance\\ERR_MESG.PC"
};


static unsigned long sqlctx = 1862135395;


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
            void  *sqhstv[5];
   unsigned int   sqhstl[5];
            int   sqhsts[5];
            void  *sqindv[5];
            int   sqinds[5];
   unsigned int   sqharm[5];
   unsigned int   *sqharc[5];
   unsigned short  sqadto[5];
   unsigned short  sqtdso[5];
} sqlstm = {10,5};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,75,0,4,78,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
28,0,0,2,84,0,5,127,0,0,1,1,0,1,0,1,9,0,0,
47,0,0,3,0,0,29,137,0,0,0,0,0,1,0,
62,0,0,4,84,0,5,168,0,0,1,1,0,1,0,1,9,0,0,
81,0,0,5,135,0,3,214,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
108,0,0,6,0,0,29,233,0,0,0,0,0,1,0,
123,0,0,7,150,0,3,267,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
150,0,0,8,0,0,31,344,0,0,0,0,0,1,0,
165,0,0,9,84,0,2,380,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
192,0,0,10,0,0,31,390,0,0,0,0,0,1,0,
207,0,0,11,134,0,3,396,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
238,0,0,12,146,0,3,412,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
273,0,0,13,0,0,31,435,0,0,0,0,0,1,0,
288,0,0,14,0,0,29,438,0,0,0,0,0,1,0,
303,0,0,15,84,0,5,442,0,0,1,1,0,1,0,1,9,0,0,
322,0,0,16,0,0,31,452,0,0,0,0,0,1,0,
337,0,0,17,0,0,29,455,0,0,0,0,0,1,0,
352,0,0,18,63,0,4,489,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
375,0,0,19,0,0,31,612,0,0,0,0,0,1,0,
390,0,0,20,134,0,3,652,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
421,0,0,21,0,0,31,673,0,0,0,0,0,1,0,
436,0,0,22,146,0,3,676,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
471,0,0,23,0,0,31,699,0,0,0,0,0,1,0,
486,0,0,24,0,0,29,702,0,0,0,0,0,1,0,
501,0,0,25,134,0,3,766,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
532,0,0,26,0,0,31,787,0,0,0,0,0,1,0,
547,0,0,27,146,0,3,790,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
582,0,0,28,0,0,31,813,0,0,0,0,0,1,0,
};


#include <ctype.h> 
#include <stdio.h>
//#include "sqlproto.h"
#include <string.h>
  
  
 /*---------------------------------*/  
#define PC_START		1
#define PC_END			2
#define	INFO_MESG		3
#define ERR_MESG		4
#define ORA_MESG		5  

void proc_main (int, char **);
void disp_message ( int, char *);
void open_log_file();
void proc_exit();
/*-----------------------------------*/ 

char string_var[100];
/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR  sub_message_id[8],
		 sub_message_text[80],
		 sub_debug_msg[80],
        	 sub_pgm_id[10],
		 sub_session_id[16],
		 sub_active_flag[2],
		 sub_pgm_date[14]; */ 
struct { unsigned short len; unsigned char arr[8]; } sub_message_id;

struct { unsigned short len; unsigned char arr[80]; } sub_message_text;

struct { unsigned short len; unsigned char arr[80]; } sub_debug_msg;

struct { unsigned short len; unsigned char arr[10]; } sub_pgm_id;

struct { unsigned short len; unsigned char arr[16]; } sub_session_id;

struct { unsigned short len; unsigned char arr[2]; } sub_active_flag;

struct { unsigned short len; unsigned char arr[14]; } sub_pgm_date;


/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/GL/INCLUDE/ERR_MESG.c-arc   1.0   Apr 19 2007 17:12:20   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/GL/INCLUDE/ERR_MESG.c-arc   1.0   Apr 19 2007 17:12:20   vcm_th  $ sqlda.h 
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




 
 
/********************************************/
/*  The following extern variables  are     */
/*  declared in the header file gl.h        */
/********************************************/

	extern char g_pgm_id[];
	extern int  end_pgm_control;
	extern char g_session_id[];
	extern char g_pgm_date[];

 /*******************************************/



/***********************************************************************/
/*               FUNCTION : chk_active                                 */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function checks if the  ACTIVE_FLAG in SY_PROG_CONTROL        */
/*  is not set to 'Y'  for the program_id available in extern variable */
/*  g_pgm_id.                                                          */ 
/*                                                                     */ 
/*  It calls function err_mesg if any oracle error occurs.             */
/*                                                                     */
/*  This function should be  called at the begining of the pro*c       */ 
/*                                                                     */
/***********************************************************************/

chk_active()
{

     
        strcpy(sub_pgm_id.arr,g_pgm_id);
	sub_pgm_id.len = strlen(sub_pgm_id.arr);

	/*EXEC SQL SELECT 'X' 
		 FROM   SY_PROG_CONTROL
		 WHERE  PGM_ID               =  :sub_pgm_id
		 AND    NVL(ACTIVE_FLAG,'N') <> 'Y';*/


   /* EXEC SQL SELECT NVL(ACTIVE_FLAG,'N') 
          into  :sub_active_flag
		 FROM   SY_PROG_CONTROL
		 WHERE  PGM_ID               =  :sub_pgm_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 2;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(ACTIVE_FLAG,'N') into :b0  from SY_PROG_CONTROL\
 where PGM_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&sub_active_flag;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&sub_pgm_id;
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



		  
		 
    if (strcmp(sub_active_flag.arr , "Y") == 0)
        err_mesg("Program being run by another user. Cannot Proceed .......",0,"");


	if(sqlca.sqlcode < 0) 
	    err_mesg("SELECT failed on table SY_PROG_CONTROL",0,"");

	if(sqlca.sqlcode == 1403) 
	    err_mesg("SELECT failed on table SY_PROG_CONTROL",1,"SY2260");

}
 /**************** END FUNCTION CHK_ACTIVE ****************************/


/***********************************************************************/
/*               FUNCTION : start_prog_control                         */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function sets the field ACTIVE_FLAG in SY_PROG_CONTROL to 'Y' */
/*  for the program_id available in extern variable g_pgm_id.          */ 
/*                                                                     */ 
/*  It calls function err_mesg if any oracle error occurs.             */
/*                                                                     */
/*  This function should be  called at the begining of the pro*c       */ 
/*  program as it commits the change to the table immediately.         */ 
/*                                                                     */
/*  On successful execution of the function it sets the extern         */
/*  variable end_pgm_control  to 1. This is to ensure that the         */
/*  err_mesg function does not perform end_prog_control unless         */
/*  the start_prog_control is sucessful.                               */
/*                                                                     */
/***********************************************************************/

start_prog_control()
{
	end_pgm_control = 0;

        strcpy(sub_pgm_id.arr,g_pgm_id);
	sub_pgm_id.len = strlen(sub_pgm_id.arr);

    

	/* EXEC SQL UPDATE SY_PROG_CONTROL
		 SET    ACTIVE_FLAG     = 'Y',
			START_DATE_TIME = SYSDATE
		 WHERE  PGM_ID          = :sub_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update SY_PROG_CONTROL  set ACTIVE_FLAG='Y',START_DATE_TIME=\
SYSDATE where PGM_ID=:b0";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )28;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
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




 
	if(sqlca.sqlcode < 0) 
	    err_mesg("Performing START_PROG_CONTROL",0,"");

	/* EXEC SQL COMMIT WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )47;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(sqlca.sqlcode < 0) 
	    err_mesg("Commiting for start_prog_control",0,"");

	end_pgm_control = 1;
}
 /**************** END FUNCTION START_PROG_CONTROL ********************/



/***********************************************************************/
/*               FUNCTION : end_prog_control                           */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function sets the field ACTIVE_FLAG in SY_PROG_CONTROL to 'N' */
/*  for the program_id available in extern variable g_pgm_id.          */ 
/*                                                                     */ 
/*  It calls function err_mesg if any oracle error occurs.             */
/*                                                                     */
/*  In case of an error it resets the extern variable end_pgm_control  */
/*  so that the err_mesg function does not perform the end_prog_control*/
/*  function again.                                                    */
/*                                                                     */
/***********************************************************************/

end_prog_control()
{
        strcpy(sub_pgm_id.arr,g_pgm_id);
	sub_pgm_id.len = strlen(sub_pgm_id.arr);

	/* EXEC SQL UPDATE SY_PROG_CONTROL
		 SET    ACTIVE_FLAG     = 'N',
			START_DATE_TIME = SYSDATE
		 WHERE  PGM_ID          = :sub_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update SY_PROG_CONTROL  set ACTIVE_FLAG='N',START_DATE_TIME=\
SYSDATE where PGM_ID=:b0";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )62;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
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



   	if (sqlca.sqlcode < 0) {
	   end_pgm_control = 0; 
	   err_mesg("END_PROG_CONTROL: Updating SY_PROG_CONTROL",0,"");
         }

}

/******************* END FUNCTION END_PROG_CONTROL ********************/




/***********************************************************************/
/*               FUNCTION : start_prog_msg                             */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function inserts a row into the table SY_PROG_MSG             */
/*  for the program_id available in extern variable g_pgm_id to        */ 
/*  indicate the start of the program.                                 */ 
/*                                                                     */ 
/*  This function should be  called at the begining of the pro*c       */ 
/*  program immediately after the start_prog_control as it commits     */ 
/*  the message to the database after inserting.                       */ 
/*                                                                     */ 
/*  It calls function err_mesg if any oracle error occurs.             */
/*                                                                     */
/***********************************************************************/



start_prog_msg() 
{ 
        strcpy(sub_pgm_id.arr,g_pgm_id);
	sub_pgm_id.len = strlen(sub_pgm_id.arr);

        strcpy(sub_session_id.arr,g_session_id);
	sub_session_id.len = strlen(sub_session_id.arr);

	strcpy(sub_pgm_date.arr,g_pgm_date);
	sub_pgm_date.len = strlen(sub_pgm_date.arr);

	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
		      ( PGM_ID,
			PGM_DATE,
			SESSION_ID,
			MSG_TYPE,
			MSG_DESC,
			MSG_DATE_TIME
                      )
	       VALUES ( :sub_pgm_id,
			:sub_pgm_date,
			:sub_session_id,
			'I',
			'PROGRAM STARTED',
			SYSDATE
		      ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_TYPE\
,MSG_DESC,MSG_DATE_TIME) values (:b0,:b1,:b2,'I','PROGRAM STARTED',SYSDATE)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )81;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
 sqlstm.sqhstl[1] = (unsigned int  )16;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
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



	if(sqlca.sqlcode < 0) 
	    err_mesg("START_PROG_MSG: Inserting into SY_PROG_MSG",0,"");

	/* EXEC SQL COMMIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )108;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(sqlca.sqlcode < 0) 
	    err_mesg("START_PROG_MSG: Commiting record in SY_PROG_MSG",0,"");

}

/******************* END FUNCTION START_PROG_MSG **********************/


/***********************************************************************/
/*               FUNCTION : end_prog_msg                               */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function inserts a row into the table SY_PROG_MSG             */
/*  for the program_id available in extern variable g_pgm_id to        */ 
/*  indicate the end of the program.                                   */ 
/*                                                                     */ 
/*  It calls function err_mesg if any oracle error occurs.             */
/*                                                                     */
/***********************************************************************/

end_prog_msg()
{

        strcpy(sub_pgm_id.arr,g_pgm_id);
	sub_pgm_id.len = strlen(sub_pgm_id.arr);

        strcpy(sub_session_id.arr,g_session_id);
	sub_session_id.len = strlen(sub_session_id.arr);

	strcpy(sub_pgm_date.arr,g_pgm_date);
	sub_pgm_date.len = strlen(sub_pgm_date.arr);

	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
		      ( PGM_ID,
			PGM_DATE,
			SESSION_ID,
			MSG_TYPE,
			MSG_DESC,
			MSG_DATE_TIME
                      )
	       VALUES ( :sub_pgm_id,
			:sub_pgm_date,
			:sub_session_id,
			'I',
			'PROGRAM COMPLETED SUCCESSFULLY', 
			SYSDATE
		      ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_TYPE\
,MSG_DESC,MSG_DATE_TIME) values (:b0,:b1,:b2,'I','PROGRAM COMPLETED SUCCESSFUL\
LY',SYSDATE)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )123;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
 sqlstm.sqhstl[1] = (unsigned int  )16;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
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



   	if (sqlca.sqlcode < 0) 
      	    err_mesg("END_PROG_MSG: Inserting into SY_PROG_MSG",0,"");
}

/******************* END FUNCTION END_PROG_MSG ************************/



/***********************************************************************/
/*               FUNCTION : err_mesg                                   */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function processes all oracle and application error           */
/*  messages. It is called with the following parameters               */ 
/*                                                                     */ 
/*  - a character string containing a message about the processing     */ 
/*    taking place when the error occured.                             */ 
/*  - an integer specifying the error type :                           */ 
/*                  1 - application error                              */ 
/*                  0 - oracle error                                   */ 
/*  - a character string containing the message id in case of an       */ 
/*    application error, or a null string for oracle errors.           */ 
/*                                                                     */ 
/*  Function get_message is called to retrive the message for          */ 
/*  application errors.                                                */
/*                                                                     */
/*  After processing error message it inserts a record into            */
/*  SY_PROG_MSG.                                                       */
/*                                                                     */
/*  If start_prog_control has been done then it updates                */
/*  SY_PROG_CONTROL to reset the active_flag to 'N'.                   */
/*                                                                     */
/***********************************************************************/


err_mesg(l_errmsg,l_errtype,l_errid) 
int l_errtype;
char l_errmsg[],
     l_errid[];

/*  l_errtype = 1 for application errors  */
/*            = 0 for oracle errors       */

{
        char l_msg_desc[70];

	long l_sqlcode;
	char app_err_msg[79];

	l_sqlcode = sqlca.sqlcode;
	app_err_msg[0]='\0';

        strcpy(sub_pgm_id.arr,g_pgm_id);
	sub_pgm_id.len = strlen(sub_pgm_id.arr);

        strcpy(sub_session_id.arr,g_session_id);
	sub_session_id.len = strlen(sub_session_id.arr);

	strcpy(sub_pgm_date.arr,g_pgm_date);
	sub_pgm_date.len = strlen(sub_pgm_date.arr);

	/* EXEC SQL ROLLBACK WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )150;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	sprintf(string_var,"%s\n",l_errmsg);
	disp_message(INFO_MESG,string_var);

	if(l_errtype)  {
	     
		if(get_message(l_errid,l_msg_desc) == -1) 
		   { sprintf(string_var,"%s\n",l_msg_desc);
		    disp_message(INFO_MESG,string_var);
		    }
		else {
		    strcpy(app_err_msg,"APP-");
		    strncat(app_err_msg,l_errid,6);
		    strncat(app_err_msg,"-",1);
		    strncat(app_err_msg,l_msg_desc,68);
		    sprintf(string_var,"%s\n",app_err_msg);
		    disp_message(INFO_MESG,string_var);
		}

		strcpy(sub_message_id.arr,l_errid);
		sub_message_id.len = strlen(sub_message_id.arr);
		strcpy(sub_message_text.arr,l_msg_desc);
		sub_message_text.len = strlen(sub_message_text.arr);


	}
	else  {
		strcpy(sub_message_text.arr,sqlca.sqlerrm.sqlerrmc);
		sub_message_text.len = strlen(sub_message_text.arr);
		sprintf(sub_message_id.arr,"%d",l_sqlcode);
		sub_message_id.len = strlen(sub_message_id.arr);
		sprintf(string_var,"%s\n",sub_message_text.arr);
		disp_message(INFO_MESG,string_var);
	 }

	/* EXEC SQL DELETE SY_PROG_PARAM
		 WHERE  PGM_ID     = :sub_pgm_id
		 AND    PGM_DATE   = :sub_pgm_date 
		 AND    SESSION_ID = :sub_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and PGM_DATE=\
:b1) and SESSION_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )165;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
 sqlstm.sqhstl[1] = (unsigned int  )16;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
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



   	 if (sqlca.sqlcode < 0) {
      	        sprintf(string_var,"\n%s\n","ERR_MESG: Delete from SY_PROG_PARAM");
      	        disp_message(ORA_MESG,string_var);
      	        sprintf(string_var,"\n<%s>\n",sqlca.sqlerrm.sqlerrmc);
      	        disp_message(ORA_MESG,string_var);
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 3;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )192;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	 }

	strncpy(sub_debug_msg.arr,l_errmsg,70);
	sub_debug_msg.len = strlen(sub_debug_msg.arr);

   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
                         MSG_DESC,
                         MSG_DATE_TIME
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'I',
	                 SUBSTR(:sub_debug_msg,1,70),
                         SYSDATE
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_DESC,MSG_DATE_TIME) values (:b0,:b1,:b2,'I',SUBSTR(:b3,1,70),SYSDATE)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )207;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
    sqlstm.sqhstl[0] = (unsigned int  )12;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
    sqlstm.sqhstl[1] = (unsigned int  )16;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_debug_msg;
    sqlstm.sqhstl[3] = (unsigned int  )82;
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



   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
			 MSG_NUM,
                         MSG_DESC,
                         MSG_DATE_TIME
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'E',
			 :sub_message_id,
	                 SUBSTR(:sub_message_text,1,70),
                         SYSDATE
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME) values (:b0,:b1,:b2,'E',:b3,SUBSTR(:b4,1,7\
0),SYSDATE)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )238;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
    sqlstm.sqhstl[0] = (unsigned int  )12;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
    sqlstm.sqhstl[1] = (unsigned int  )16;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_message_id;
    sqlstm.sqhstl[3] = (unsigned int  )10;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_message_text;
    sqlstm.sqhstl[4] = (unsigned int  )82;
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



   	 if (sqlca.sqlcode < 0) {
      	        sprintf(string_var,"\n%s\n","ERR_MESG: Insert into SY_PROG_MSG");
      	        disp_message(ORA_MESG,string_var);
      	        sprintf(string_var,"\n<%s>\n",sqlca.sqlerrm.sqlerrmc);
      	        disp_message(ORA_MESG,string_var);
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 5;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )273;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	 }

	 /* EXEC SQL COMMIT WORK; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )288;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 if(end_pgm_control) {

      	    /* EXEC SQL UPDATE SY_PROG_CONTROL
                      SET   ACTIVE_FLAG     = 'N',
                            START_DATE_TIME = SYSDATE
                     WHERE  PGM_ID          = :sub_pgm_id; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 5;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "update SY_PROG_CONTROL  set ACTIVE_FLAG='N',START_\
DATE_TIME=SYSDATE where PGM_ID=:b0";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )303;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
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



   	    if (sqlca.sqlcode < 0) {
      	        sprintf(string_var,"\n%s\n","ERR_MESG: Updating SY_PROG_CONTROL");
      	        disp_message(ORA_MESG,string_var);
                sprintf(string_var,"\n<%s>\n",sqlca.sqlerrm.sqlerrmc);
                disp_message(ORA_MESG,string_var);
                /* EXEC SQL ROLLBACK WORK; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 5;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )322;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


             }

            /* EXEC SQL COMMIT WORK; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 5;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )337;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 }

         proc_exit() ;

}

/*********************** END FUNCTION ERR_MESG ************************/


/***********************************************************************/
/*               FUNCTION : get_message                                */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function retrives the appropriate error message from the      */
/*  MESSAGE table. The inputs to the function are                      */
/*                                                                     */ 
/*     - a character pointer to the message_id                         */ 
/*     - a character pointer to store the retrived message             */ 
/*                                                                     */ 
/*  If an oracle error occurs when retriving the message, The          */
/*  message_id will contain the oracle error number and the            */
/*  message description the oracle error message.                      */ 
/*                                                                     */
/***********************************************************************/

get_message(l_errid,l_msg_desc)
char *l_errid, *l_msg_desc;
{

	strcpy(sub_message_id.arr,l_errid);
	sub_message_id.len = strlen(sub_message_id.arr);

	/* EXEC SQL SELECT MESSAGE_TEXT
	         INTO   :sub_message_text
	         FROM   MESSAGE
	 WHERE  MESSAGE_ID = :sub_message_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select MESSAGE_TEXT into :b0  from MESSAGE where MESSAGE_ID=\
:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )352;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_message_text;
 sqlstm.sqhstl[0] = (unsigned int  )82;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_message_id;
 sqlstm.sqhstl[1] = (unsigned int  )10;
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



        if(sqlca.sqlcode < 0 || sqlca.sqlcode == 1403) {
	    strcpy(l_msg_desc,sqlca.sqlerrm.sqlerrmc);
	    sprintf(l_errid,"%d",sqlca.sqlcode);
	    return -1;
	}
        else {
	    sub_message_text.arr[sub_message_text.len] = '\0';
	    strcpy(l_msg_desc,sub_message_text.arr);
	    return 0;
	}
}

/*********************** END FUNCTION GET_MESSAGE *********************/


int equal(d1,d2) 
double d1,d2;
{
    char s1[20],s2[20];
    double zero;

    zero = (double) 0.00;

    sprintf(s1,"%15.2f",d1);
    l_ltrim(s1);
    if(!strcmp(s1,"-0.00"))
	strcpy(s1,"0.00");

    sprintf(s2,"%15.2f",d2);
    l_ltrim(s2);
    if(!strcmp(s2,"-0.00"))
	strcpy(s2,"0.00");

/*
    sprintf(string_var,"S1 = <%s>\n",s1);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"S2 = <%s>\n",s2);        
    disp_message(INFO_MESG,string_var);
*/

    return !(strcmp(s1,s2));
}

put_val(str,num)
char *str;
double num;
{
    sprintf(str,"%15.2f",num);
}


l_ltrim(s)
char *s;
{

    char s1[20];
    int i;

    strcpy(s1,s);

    for(i=0;s1[i] == ' '; i++);

    while(s1[i]) 
	*s++ = s1[i++];

    *s = '\0';
}

/***********************************************************************/
/*               FUNCTION : disp_mesg                                  */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function processes all oracle and application error           */
/*  messages. It is called with the following parameters               */ 
/*                                                                     */ 
/*  - a character string containing a message about the processing     */ 
/*    taking place when the error occured.                             */ 
/*  - an integer specifying the error type :                           */ 
/*                  1 - application error                              */ 
/*                  0 - oracle error                                   */ 
/*  - a character string containing the message id in case of an       */ 
/*    application error, or a null string for oracle errors.           */ 
/*                                                                     */ 
/*  Function get_message is called to retrive the message for          */ 
/*  application errors.                                                */
/*                                                                     */
/*  After processing error message it inserts a record into            */
/*  SY_PROG_MSG.                                                       */
/*                                                                     */
/***********************************************************************/


disp_mesg(l_errmsg,l_errtype,l_errid)
int l_errtype;
char l_errmsg[],
     l_errid[];

/*  l_errtype = 1 for application errors  */
/*            = 0 for oracle errors       */

{
        char l_msg_desc[70];

	long l_sqlcode;
	char app_err_msg[79];

	l_sqlcode = sqlca.sqlcode;
	app_err_msg[0]='\0';

        strcpy(sub_pgm_id.arr,g_pgm_id);
	sub_pgm_id.len = strlen(sub_pgm_id.arr);

        strcpy(sub_session_id.arr,g_session_id);
	sub_session_id.len = strlen(sub_session_id.arr);

	strcpy(sub_pgm_date.arr,g_pgm_date);
	sub_pgm_date.len = strlen(sub_pgm_date.arr);

	/* EXEC SQL ROLLBACK WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )375;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	sprintf(string_var,"%s\n",l_errmsg);
	disp_message(INFO_MESG,string_var);

	if(l_errtype)  {
	     
		if(get_message(l_errid,l_msg_desc) == -1) 
		    {
		    sprintf(string_var,"%s\n",l_msg_desc);
		    disp_message(INFO_MESG,string_var);
		    }
		else {
		    strcpy(app_err_msg,"APP-");
		    strncat(app_err_msg,l_errid,6);
		    strncat(app_err_msg,"-",1);
		    strncat(app_err_msg,l_msg_desc,68);
		    sprintf(string_var,"%s\n",app_err_msg);
		    disp_message(INFO_MESG,string_var);
		}

		strcpy(sub_message_id.arr,l_errid);
		sub_message_id.len = strlen(sub_message_id.arr);
		strcpy(sub_message_text.arr,l_msg_desc);
		sub_message_text.len = strlen(sub_message_text.arr);


	}
	else  {
		strcpy(sub_message_text.arr,sqlca.sqlerrm.sqlerrmc);
		sub_message_text.len = strlen(sub_message_text.arr);
		sprintf(sub_message_id.arr,"%d",l_sqlcode);
		sub_message_id.len = strlen(sub_message_id.arr);
		sprintf(string_var,"%s\n",sub_message_text.arr);
		disp_message(INFO_MESG,string_var);
	 }

	strncpy(sub_debug_msg.arr,l_errmsg,70);
	sub_debug_msg.len = strlen(sub_debug_msg.arr);

   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
                         MSG_DESC,
                         MSG_DATE_TIME
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'I',
	                 SUBSTR(:sub_debug_msg,1,70),
                         SYSDATE
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_DESC,MSG_DATE_TIME) values (:b0,:b1,:b2,'I',SUBSTR(:b3,1,70),SYSDATE)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )390;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
    sqlstm.sqhstl[0] = (unsigned int  )12;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
    sqlstm.sqhstl[1] = (unsigned int  )16;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_debug_msg;
    sqlstm.sqhstl[3] = (unsigned int  )82;
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



   	 if (sqlca.sqlcode < 0) {
      	        sprintf(string_var,"\n%s\n","ERR_MESG: Insert into SY_PROG_MSG");
      	        disp_message(ORA_MESG,string_var);
      	        sprintf(string_var,"\n<%s>\n",sqlca.sqlerrm.sqlerrmc);
      	        disp_message(ORA_MESG,string_var);
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 5;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )421;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	 }

   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
			 MSG_NUM,
                         MSG_DESC,
                         MSG_DATE_TIME
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'E',
			 :sub_message_id,
	                 SUBSTR(:sub_message_text,1,70),
                         SYSDATE
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME) values (:b0,:b1,:b2,'E',:b3,SUBSTR(:b4,1,7\
0),SYSDATE)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )436;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
    sqlstm.sqhstl[0] = (unsigned int  )12;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
    sqlstm.sqhstl[1] = (unsigned int  )16;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_message_id;
    sqlstm.sqhstl[3] = (unsigned int  )10;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_message_text;
    sqlstm.sqhstl[4] = (unsigned int  )82;
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



   	 if (sqlca.sqlcode < 0) {
      	        sprintf(string_var,"\n%s\n","ERR_MESG: Insert into SY_PROG_MSG");
      	        disp_message(ORA_MESG,string_var);
      	        sprintf(string_var,"\n<%s>\n",sqlca.sqlerrm.sqlerrmc);
      	        disp_message(ORA_MESG,string_var);
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 5;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )471;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	 }

      /* EXEC SQL COMMIT WORK; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )486;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      return(0);
}

/*********************** END FUNCTION DISP_MESG ************************/

log_err_mesg(l_errmsg,l_errtype,l_errid)
int l_errtype;
char l_errmsg[],
     l_errid[];
/*  l_errtype = 1 for application errors  */
/*            = 0 for oracle errors       */
{
        char l_msg_desc[70];

	long l_sqlcode;
	char app_err_msg[79];

	l_sqlcode = sqlca.sqlcode;
	app_err_msg[0]='\0';

        strcpy(sub_pgm_id.arr,g_pgm_id);
	sub_pgm_id.len = strlen(sub_pgm_id.arr);

        strcpy(sub_session_id.arr,g_session_id);
	sub_session_id.len = strlen(sub_session_id.arr);

	strcpy(sub_pgm_date.arr,g_pgm_date);
	sub_pgm_date.len = strlen(sub_pgm_date.arr);

	if(l_errtype)  {
	     
		if(get_message(l_errid,l_msg_desc) == -1) 
		   { sprintf(string_var,"%s\n",l_msg_desc);
		    disp_message(ERR_MESG,string_var);
		    }
		else {
		    strcpy(app_err_msg,"APP-");
		    strncat(app_err_msg,l_errid,6);
		    strncat(app_err_msg,"-",1);
		    strncat(app_err_msg,l_msg_desc,68);
/*		    sprintf(string_var,"%s\n",app_err_msg);
			disp_message(ERR_MESG,string_var);*/
		}

		strcpy(sub_message_id.arr,l_errid);
		sub_message_id.len = strlen(sub_message_id.arr);
		strcpy(sub_message_text.arr,l_msg_desc);
		sub_message_text.len = strlen(sub_message_text.arr);


	}
	else  {
		strcpy(sub_message_text.arr,sqlca.sqlerrm.sqlerrmc);
		sub_message_text.len = strlen(sub_message_text.arr);
		sprintf(sub_message_id.arr,"%d",l_sqlcode);
		sub_message_id.len = strlen(sub_message_id.arr);
/*		sprintf(string_var,"%s\n",sub_message_text.arr);
	    disp_message(INFO_MESG,string_var); */
	}

	strncpy(sub_debug_msg.arr,l_errmsg,70);
	sub_debug_msg.len = strlen(sub_debug_msg.arr);

   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
                         MSG_DESC,
                         MSG_DATE_TIME
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'I',
	                 SUBSTR(:sub_debug_msg,1,70),
                         SYSDATE
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_DESC,MSG_DATE_TIME) values (:b0,:b1,:b2,'I',SUBSTR(:b3,1,70),SYSDATE)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )501;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
    sqlstm.sqhstl[0] = (unsigned int  )12;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
    sqlstm.sqhstl[1] = (unsigned int  )16;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_debug_msg;
    sqlstm.sqhstl[3] = (unsigned int  )82;
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



   	 if (sqlca.sqlcode < 0) {
      	        sprintf(string_var,"\n%s\n","ERR_MESG: Insert into SY_PROG_MSG");
      	        disp_message(ORA_MESG,string_var);
      	        sprintf(string_var,"\n<%s>\n",sqlca.sqlerrm.sqlerrmc);
      	        disp_message(ORA_MESG,string_var);
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 5;
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


   	    }

   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 	PGM_DATE,
				 SESSION_ID,
                         MSG_TYPE,
				 MSG_NUM,
                         MSG_DESC,
                         MSG_DATE_TIME
                       )
	                VALUES ( :sub_pgm_id,
				 :sub_pgm_date,
				 :sub_session_id,
                         'E',
				 :sub_message_id,
	                 	 SUBSTR(:sub_message_text,1,70),
                         SYSDATE
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME) values (:b0,:b1,:b2,'E',:b3,SUBSTR(:b4,1,7\
0),SYSDATE)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )547;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_pgm_id;
    sqlstm.sqhstl[0] = (unsigned int  )12;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_pgm_date;
    sqlstm.sqhstl[1] = (unsigned int  )16;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_message_id;
    sqlstm.sqhstl[3] = (unsigned int  )10;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_message_text;
    sqlstm.sqhstl[4] = (unsigned int  )82;
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



   	 if (sqlca.sqlcode < 0) {
      	        sprintf(string_var,"\n%s\n","ERR_MESG: Insert into SY_PROG_MSG");
      	        disp_message(ORA_MESG,string_var);
      	        sprintf(string_var,"\n<%s>\n",sqlca.sqlerrm.sqlerrmc);
      	        disp_message(INFO_MESG,string_var);
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 5;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )582;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	 }
      return(0);
}
