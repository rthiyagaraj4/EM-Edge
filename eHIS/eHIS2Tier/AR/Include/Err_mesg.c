
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
           char  filnam[26];
};
static const struct sqlcxp sqlfpn =
{
    25,
    "T:\\BL\\include\\Err_mesg.pc"
};


static unsigned long sqlctx = 1708110237;


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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,107,0,4,70,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
32,0,0,2,137,0,3,83,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
59,0,0,3,0,0,29,91,0,0,0,0,0,1,0,
74,0,0,4,116,0,5,126,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
97,0,0,5,0,0,29,135,0,0,0,0,0,1,0,
112,0,0,6,116,0,5,170,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
135,0,0,7,168,0,3,220,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
166,0,0,8,0,0,29,240,0,0,0,0,0,1,0,
181,0,0,9,183,0,3,277,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
212,0,0,10,0,0,31,358,0,0,0,0,0,1,0,
227,0,0,11,84,0,2,389,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
254,0,0,12,0,0,31,396,0,0,0,0,0,1,0,
269,0,0,13,160,0,3,402,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
304,0,0,14,172,0,3,419,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
343,0,0,15,0,0,31,440,0,0,0,0,0,1,0,
358,0,0,16,0,0,29,443,0,0,0,0,0,1,0,
373,0,0,17,84,0,5,447,0,0,1,1,0,1,0,1,9,0,0,
392,0,0,18,0,0,31,454,0,0,0,0,0,1,0,
407,0,0,19,0,0,29,457,0,0,0,0,0,1,0,
422,0,0,20,73,0,4,491,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
445,0,0,21,144,0,4,541,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
468,0,0,22,0,0,31,552,0,0,0,0,0,1,0,
483,0,0,23,0,0,31,682,0,0,0,0,0,1,0,
498,0,0,24,160,0,3,716,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
533,0,0,25,172,0,3,733,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
572,0,0,26,0,0,31,754,0,0,0,0,0,1,0,
587,0,0,27,0,0,29,757,0,0,0,0,0,1,0,
602,0,0,28,160,0,3,819,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
637,0,0,29,0,0,31,838,0,0,0,0,0,1,0,
652,0,0,30,172,0,3,841,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
691,0,0,31,0,0,31,863,0,0,0,0,0,1,0,
706,0,0,32,144,0,4,883,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
729,0,0,33,0,0,31,894,0,0,0,0,0,1,0,
};


#define	INFO_MESG		3
#define ERR_MESG		4
#define ORA_MESG		5  

#include <ctype.h>
#include <stdlib.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR		sub_message_id[9],
				sub_message_text[101],
				sub_debug_msg[101],
        		sub_pgm_id[10],
				sub_session_id[16],
				sub_pgm_date[14],
				sub_facility_id[3],
				sub_act_flag[2],
				l_facility_id[5]; */ 
struct { unsigned short len; unsigned char arr[9]; } sub_message_id;

struct { unsigned short len; unsigned char arr[101]; } sub_message_text;

struct { unsigned short len; unsigned char arr[101]; } sub_debug_msg;

struct { unsigned short len; unsigned char arr[10]; } sub_pgm_id;

struct { unsigned short len; unsigned char arr[16]; } sub_session_id;

struct { unsigned short len; unsigned char arr[14]; } sub_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } sub_facility_id;

struct { unsigned short len; unsigned char arr[2]; } sub_act_flag;

struct { unsigned short len; unsigned char arr[5]; } l_facility_id;


	 char		X_dummy;
	 char		l_mesg[100];

	 int		l_no_of_decimal;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA;
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


/********************************************/
/*  The following extern variables  are     */
/*  declared in the header file gl.h        */
/********************************************/

	extern char g_pgm_id[];
	extern int  end_pgm_control;
	extern char g_session_id[];
	extern char g_pgm_date[];
	extern char g_facility_id[];

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

	strcpy(sub_pgm_date.arr,g_pgm_date);
	sub_pgm_date.len = strlen(sub_pgm_date.arr);

	strcpy(sub_facility_id.arr,g_facility_id);
	sub_facility_id.len = strlen(sub_facility_id.arr);
	
	/* EXEC SQL SELECT NVL(ACTIVE_FLAG,'N') INTO :sub_act_flag
		 FROM   SY_PROG_CONTROL
		 WHERE  PGM_ID               =  :sub_pgm_id
               AND  operating_facility_id = :sub_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(ACTIVE_FLAG,'N') into :b0  from SY_PROG_CONTROL w\
here (PGM_ID=:b1 and operating_facility_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_act_flag;
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
 sqlstm.sqhstv[2] = (         void  *)&sub_facility_id;
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

		 

	if (sub_act_flag.arr =="Y") 
		err_mesg("",1,"SY2260");

	if(sqlca.sqlcode < 0) 
	    err_mesg("SELECT failed on table SY_PROG_CONTROL",0,"");
 
	if(sqlca.sqlcode == 1403) 
	 { 
		 /* EXEC SQL INSERT INTO SY_PROG_CONTROL
		 (OPERATING_FACILITY_ID,PGM_ID,ACTIVE_FLAG,START_DATE_TIME)
		 VALUES
		 (:sub_facility_id,:sub_pgm_id,'Y',to_date(:sub_pgm_date,'DDMMYYHH24MISS')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_CONTROL (OPERATING_FACILITY_ID,PGM_ID,\
ACTIVE_FLAG,START_DATE_TIME) values (:b0,:b1,'Y',to_date(:b2,'DDMMYYHH24MISS')\
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )32;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&sub_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
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
   sqlstm.sqhstv[2] = (         void  *)&sub_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )16;
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
	    err_mesg("INSERT failed on table SY_PROG_CONTROL",0,"");

		 /* EXEC SQL COMMIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )59;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	 }
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

	strcpy(sub_facility_id.arr,g_facility_id);
	sub_facility_id.len = strlen(sub_facility_id.arr);

	/* EXEC SQL UPDATE SY_PROG_CONTROL
		 SET    ACTIVE_FLAG     = 'Y',
			START_DATE_TIME = SYSDATE
		 WHERE  PGM_ID          = :sub_pgm_id
               AND  OPERATING_FACILITY_ID = :sub_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update SY_PROG_CONTROL  set ACTIVE_FLAG='Y',START_DATE_TIME=\
SYSDATE where (PGM_ID=:b0 and OPERATING_FACILITY_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )74;
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
 sqlstm.sqhstv[1] = (         void  *)&sub_facility_id;
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



	if(sqlca.sqlcode < 0) 
	    err_mesg("Performing START_PROG_CONTROL",0,"");

	/* EXEC SQL COMMIT WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )97;
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

	strcpy(sub_facility_id.arr,g_facility_id);
	sub_facility_id.len = strlen(sub_facility_id.arr);


	/* EXEC SQL UPDATE SY_PROG_CONTROL
		 SET    ACTIVE_FLAG     = 'N',
			START_DATE_TIME = SYSDATE
		 WHERE  PGM_ID          = :sub_pgm_id
		   AND  OPERATING_FACILITY_ID = :sub_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 3;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update SY_PROG_CONTROL  set ACTIVE_FLAG='N',START_DATE_TIME=\
SYSDATE where (PGM_ID=:b0 and OPERATING_FACILITY_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )112;
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
 sqlstm.sqhstv[1] = (         void  *)&sub_facility_id;
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

	strcpy(sub_facility_id.arr,g_facility_id);
	sub_facility_id.len = strlen(sub_facility_id.arr);

	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
		      ( PGM_ID,
			PGM_DATE,
			SESSION_ID,
			MSG_TYPE,
			MSG_DESC,
			MSG_DATE_TIME,
			OPERATING_FACILITY_ID
                      )
	       VALUES ( UPPER(:sub_pgm_id),
			:sub_pgm_date,
			:sub_session_id,
			'I',
			'PROGRAM STARTED',
			SYSDATE, :sub_facility_id
		      ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_TYPE\
,MSG_DESC,MSG_DATE_TIME,OPERATING_FACILITY_ID) values (UPPER(:b0),:b1,:b2,'I',\
'PROGRAM STARTED',SYSDATE,:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )135;
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
 sqlstm.sqhstv[3] = (         void  *)&sub_facility_id;
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



	if(sqlca.sqlcode < 0) 
	    err_mesg("START_PROG_MSG: Inserting into SY_PROG_MSG",0,"");

	/* EXEC SQL COMMIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )166;
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

	strcpy(sub_facility_id.arr,g_facility_id);
	sub_facility_id.len = strlen(sub_facility_id.arr);

	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
		      ( PGM_ID,
			PGM_DATE,
			SESSION_ID,
			MSG_TYPE,
			MSG_DESC,
			MSG_DATE_TIME,
			OPERATING_FACILITY_ID
                      )
	       VALUES ( UPPER(:sub_pgm_id),
			:sub_pgm_date,
			:sub_session_id,
			'I',
			'PROGRAM COMPLETED SUCCESSFULLY', 
			SYSDATE, :sub_facility_id
		      ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_TYPE\
,MSG_DESC,MSG_DATE_TIME,OPERATING_FACILITY_ID) values (UPPER(:b0),:b1,:b2,'I',\
'PROGRAM COMPLETED SUCCESSFULLY',SYSDATE,:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )181;
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
 sqlstm.sqhstv[3] = (         void  *)&sub_facility_id;
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

	strcpy(sub_facility_id.arr,g_facility_id);
	sub_facility_id.len = strlen(sub_facility_id.arr);

	/* EXEC SQL ROLLBACK WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )212;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	disp_message(ERR_MESG,l_errmsg);

	if(l_errtype)  {
	     
		if(get_message(l_errid,l_msg_desc) == -1) 
		    disp_message(ERR_MESG,l_msg_desc);
		else {
		    strcpy(app_err_msg,"APP-");
		    strncat(app_err_msg,l_errid,6);
		    strncat(app_err_msg,"-",1);
		    strncat(app_err_msg,l_msg_desc,68);
		    disp_message(ERR_MESG,app_err_msg);
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
		disp_message(ERR_MESG,sub_message_text.arr);
	 }

	/* EXEC SQL DELETE SY_PROG_PARAM
		 WHERE  PGM_ID     = :sub_pgm_id
		 AND    PGM_DATE   = :sub_pgm_date 
		 AND    SESSION_ID = :sub_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and PGM_DATE=\
:b1) and SESSION_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )227;
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
      	        disp_message(ORA_MESG,"ERR_MESG: Delete from SY_PROG_PARAM");
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 4;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )254;
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
                         MSG_DATE_TIME,
						 OPERATING_FACILITY_ID
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'I',
	                 SUBSTR(:sub_debug_msg,1,70),
                         SYSDATE, :sub_facility_id
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_DESC,MSG_DATE_TIME,OPERATING_FACILITY_ID) values (:b0,:b1,:b2,'I',SUBS\
TR(:b3,1,70),SYSDATE,:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )269;
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
    sqlstm.sqhstl[3] = (unsigned int  )103;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_facility_id;
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



   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
			 MSG_NUM,
                         MSG_DESC,
                         MSG_DATE_TIME,
						 OPERATING_FACILITY_ID
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'E',
			 :sub_message_id,
	                 SUBSTR(:sub_message_text,1,70),
                         SYSDATE, :sub_facility_id
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,OPERATING_FACILITY_ID) values (:b0,:b1,:b2,\
'E',:b3,SUBSTR(:b4,1,70),SYSDATE,:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )304;
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
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_message_text;
    sqlstm.sqhstl[4] = (unsigned int  )103;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&sub_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
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



   	 if (sqlca.sqlcode < 0) {
      	        disp_message(ORA_MESG,"ERR_MESG: Insert into SY_PROG_MSG");
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )343;
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
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )358;
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
           sqlstm.arrsiz = 6;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "update SY_PROG_CONTROL  set ACTIVE_FLAG='N',START_\
DATE_TIME=SYSDATE where PGM_ID=:b0";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )373;
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
      	        disp_message(ORA_MESG,"ERR_MESG: Updating SY_PROG_CONTROL");
                /* EXEC SQL ROLLBACK WORK; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 6;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )392;
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
            sqlstm.arrsiz = 6;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )407;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 }

         exit(0);

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

	/* EXEC SQL SELECT MESSAGE_TEXT_SYSDEF
	         INTO   :sub_message_text
	         FROM   SM_MESSAGE
	 WHERE  MESSAGE_ID = :sub_message_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select MESSAGE_TEXT_SYSDEF into :b0  from SM_MESSAGE where M\
ESSAGE_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )422;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_message_text;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_message_id;
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


    return !(strcmp(s1,s2));
}

put_val(str,num)
char *str;
double num;
{

	strcpy(l_facility_id.arr,g_facility_id);
	l_facility_id.len = strlen(l_facility_id.arr);

	/* EXEC SQL SELECT no_of_decimal
               INTO :l_no_of_decimal
	  		   FROM sm_acc_entity_param
              WHERE acc_entity_id = (SELECT acc_entity_code 
									   FROM sy_acc_entity
									  WHERE acc_entity_id = :l_facility_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select no_of_decimal into :b0  from sm_acc_entity_param wher\
e acc_entity_id=(select acc_entity_code  from sy_acc_entity where acc_entity_i\
d=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )445;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_no_of_decimal;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_facility_id;
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


      

   	if (sqlca.sqlcode < 0) 
	{
        disp_message(ORA_MESG,"ERR_MESG: Select failed in sm_acc_entity_param");
      	/* EXEC SQL ROLLBACK WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 6;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )468;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	}

	if(l_no_of_decimal==3)
	{
		sprintf(str,"%14.3f",num);
	}
	else
	{
		sprintf(str,"%15.2f",num);
	}

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

put_comma(str, l_no_of_dec)
char *str;
int  l_no_of_dec;
{
	int i,j,k;
	char str2[20];

    i=0;
    j=0;

	if(l_no_of_dec ==3)
	{
		for(k=0,i=strlen(str)-1; k <= 3 ; k++)
			str2[j++] = str[i--];
	}
	else
	{
		for(k=0,i=strlen(str)-1; k <= 2 ; k++)
			str2[j++] = str[i--];
	}

    k=0;
    while( isdigit( str[i])) 
	{
		str2[j++] = str[i--];
		k++;
		if ( k==3) 
		{
			str2[j++] = ',';
			k=0;
		}
	}	

	if(str2[j-1] == ',')
		str2[j-1] = '\0';
	else
		str2[j] = '\0';

	for (i = strlen(str2)-1, j=0; i >= 0; --i)
		str[j++] = str2[i];

    str[j] = '\0';

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

	strcpy(sub_facility_id.arr,g_facility_id);
	sub_facility_id.len = strlen(sub_facility_id.arr);

	/* EXEC SQL ROLLBACK WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )483;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	disp_message(ERR_MESG,l_errmsg);

	if(l_errtype)  {
	     
		if(get_message(l_errid,l_msg_desc) == -1) 
		    disp_message(ERR_MESG,l_msg_desc);
		else {
		    strcpy(app_err_msg,"APP-");
		    strncat(app_err_msg,l_errid,6);
		    strncat(app_err_msg,"-",1);
		    strncat(app_err_msg,l_msg_desc,68);
		    disp_message(ERR_MESG,app_err_msg);
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
		disp_message(ERR_MESG,sub_message_text.arr);
	 }

	strncpy(sub_debug_msg.arr,l_errmsg,70);
	sub_debug_msg.len = strlen(sub_debug_msg.arr);

   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
                         MSG_DESC,
                         MSG_DATE_TIME,
						 OPERATING_FACILITY_ID
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'I',
	                 SUBSTR(:sub_debug_msg,1,70),
                         SYSDATE, :sub_facility_id
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_DESC,MSG_DATE_TIME,OPERATING_FACILITY_ID) values (:b0,:b1,:b2,'I',SUBS\
TR(:b3,1,70),SYSDATE,:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )498;
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
    sqlstm.sqhstl[3] = (unsigned int  )103;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_facility_id;
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



   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
			 MSG_NUM,
                         MSG_DESC,
                         MSG_DATE_TIME,
						 OPERATING_FACILITY_ID
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'E',
			 :sub_message_id,
	                 SUBSTR(:sub_message_text,1,70),
                         SYSDATE, :sub_facility_id
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,OPERATING_FACILITY_ID) values (:b0,:b1,:b2,\
'E',:b3,SUBSTR(:b4,1,70),SYSDATE,:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )533;
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
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_message_text;
    sqlstm.sqhstl[4] = (unsigned int  )103;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&sub_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
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



   	 if (sqlca.sqlcode < 0) {
      	        disp_message(ORA_MESG,"ERR_MESG: Insert into SY_PROG_MSG");
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )572;
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
      sqlstm.arrsiz = 6;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )587;
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

	strcpy(sub_facility_id.arr,g_facility_id);
	sub_facility_id.len = strlen(sub_facility_id.arr);

	if(l_errtype)  {
	     
		if(get_message(l_errid,l_msg_desc) == -1) 
		    disp_message (ERR_MESG,l_msg_desc);
		else {
		    strcpy(app_err_msg,"APP-");
		    strncat(app_err_msg,l_errid,6);
		    strncat(app_err_msg,"-",1);
		    strncat(app_err_msg,l_msg_desc,68);
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
	}

	strncpy(sub_debug_msg.arr,l_errmsg,70);
	sub_debug_msg.len = strlen(sub_debug_msg.arr);

   	/* EXEC SQL INSERT INTO   SY_PROG_MSG 
                       ( PGM_ID,
			 PGM_DATE,
			 SESSION_ID,
                         MSG_TYPE,
                         MSG_DESC,
                         MSG_DATE_TIME,
						 OPERATING_FACILITY_ID
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'I',
	                 SUBSTR(:sub_debug_msg,1,70),
                         SYSDATE, :sub_facility_id
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_DESC,MSG_DATE_TIME,OPERATING_FACILITY_ID) values (:b0,:b1,:b2,'I',SUBS\
TR(:b3,1,70),SYSDATE,:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )602;
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
    sqlstm.sqhstl[3] = (unsigned int  )103;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_facility_id;
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



   	 if (sqlca.sqlcode < 0) {
      	        disp_message(ORA_MESG,"ERR_MESG: Insert into SY_PROG_MSG");
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )637;
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
                         MSG_DATE_TIME,
						 OPERATING_FACILITY_ID
                       )
                VALUES ( :sub_pgm_id,
			 :sub_pgm_date,
			 :sub_session_id,
                         'E',
			 :sub_message_id,
	                 SUBSTR(:sub_message_text,1,70),
                         SYSDATE,
						 :sub_facility_id
                       ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,PGM_DATE,SESSION_ID,MSG_T\
YPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,OPERATING_FACILITY_ID) values (:b0,:b1,:b2,\
'E',:b3,SUBSTR(:b4,1,70),SYSDATE,:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )652;
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
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_message_text;
    sqlstm.sqhstl[4] = (unsigned int  )103;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&sub_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
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



   	 if (sqlca.sqlcode < 0) {
      	        disp_message( ORA_MESG,"ERR_MESG: Insert into SY_PROG_MSG");
      	        /* EXEC SQL ROLLBACK WORK; */ 

{
               struct sqlexd sqlstm;
               sqlstm.sqlvsn = 10;
               sqlstm.arrsiz = 6;
               sqlstm.sqladtp = &sqladt;
               sqlstm.sqltdsp = &sqltds;
               sqlstm.iters = (unsigned int  )1;
               sqlstm.offset = (unsigned int  )691;
               sqlstm.cud = sqlcud0;
               sqlstm.sqlest = (unsigned char  *)&sqlca;
               sqlstm.sqlety = (unsigned short)256;
               sqlstm.occurs = (unsigned int  )0;
               sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	 }
      return(0);
}


/******************************************************************

This below two procedure is moved from Comma.C to Err_message.c on 
19/12/2002 by Harish for HMC customization.

Purpose :	Dynamic no of decimals from table SM_ACC_ENTITY_PARAM

*******************************************************************/
format_amt(str)
char	*str;
{
	strcpy(l_facility_id.arr,g_facility_id);
	l_facility_id.len = strlen(l_facility_id.arr);

	/* EXEC SQL SELECT no_of_decimal
               INTO :l_no_of_decimal
	  		   FROM sm_acc_entity_param
              WHERE acc_entity_id = (SELECT acc_entity_code 
									   FROM sy_acc_entity
									  WHERE acc_entity_id = :l_facility_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select no_of_decimal into :b0  from sm_acc_entity_param wher\
e acc_entity_id=(select acc_entity_code  from sy_acc_entity where acc_entity_i\
d=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )706;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_no_of_decimal;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_facility_id;
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


      

   	if (sqlca.sqlcode < 0) 
	{
        disp_message(ORA_MESG,"ERR_MESG: Select failed in sm_acc_entity_param");
      	/* EXEC SQL ROLLBACK WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 6;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )729;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	}

	if(strlen(str) == 0)
	{
		if(l_no_of_decimal == 2)
		{
			strcpy(str, "0.00");
		}
		else if(l_no_of_decimal == 3)
		{
			strcpy(str, "0.000");
		}
	}
	else 
	{      
		u_ltrim(str);
		str = check_decimal(str,l_no_of_decimal);
		str = put_comma(str,l_no_of_decimal);
    }
	
	return str;
}


/* checks if decimal point if there in the amount string. If not present */
/* appends the string ".00" to the input string.		          */
check_decimal(str,l_decimal)
char str[100];
int  l_decimal;
{
	char *chk_dcml;
	char str_tmp[100];
	char l_mesg[100];
 
	//sprintf(l_mesg,"%s",strncmp(str, ".", 1));

	if(strncmp(str, ".", 1) == 0)
	{
		strcpy(str_tmp, "0");
		strcat(str_tmp, str);
		strcpy(str, str_tmp);
	}

	chk_dcml = strrchr(str, '.');

	//if no decimal placess put decimal points and two zeros 
	if(l_decimal == 3)
	{
		if(chk_dcml == NULL) 
		{
			strcat(str,".000");
		}
		else if(strlen(chk_dcml) < 2)
			strcat(str, "000");
		else if(strlen(chk_dcml) < 3)
			strcat(str, "00");
		else if(strlen(chk_dcml) < 4)
			strcat(str, "0");	
	}
	else
	{
		if(chk_dcml == NULL) 
		{
			strcat(str,".00");
		}
		else if(strlen(chk_dcml) < 2)
			strcat(str, "00");

		else if(strlen(chk_dcml) < 3)
			strcat(str, "0");
	}

	//disp_message(ERR_MESG,str);
	return str;
}


u_ltrim (in_str)
char *in_str;
{
int len,i=0,j=0;
char out_str[60];

     len = strlen (in_str);
     while ( in_str[i] == ' ' && i <= len)
	// Incrementing pointer to first no blank character      
           i++;         

     if ( i <= len )
     {
        for (j=0;i<= len; i++,j++)
            out_str[j] = in_str[i];
        out_str[++j] = '\0';
     }
     else
        out_str[0] = '\0';

     strcpy (in_str, out_str);
}
