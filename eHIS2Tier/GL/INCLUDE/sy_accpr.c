
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
    "T:\\TEMP\\Finance\\sy_accpr.pc"
};


static unsigned long sqlctx = 1862152139;


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
            void  *sqhstv[9];
   unsigned int   sqhstl[9];
            int   sqhsts[9];
            void  *sqindv[9];
            int   sqinds[9];
   unsigned int   sqharm[9];
   unsigned int   *sqharc[9];
   unsigned short  sqadto[9];
   unsigned short  sqtdso[9];
} sqlstm = {10,9};

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
5,0,0,1,192,0,4,81,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
40,0,0,2,275,0,4,164,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,1,9,0,0,
91,0,0,3,183,0,4,254,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,3,
0,0,1,3,0,0,
134,0,0,4,183,0,4,336,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
3,0,0,1,3,0,0,
};



/*-- Function sy_accpr.pc */

 
#define PC_START		1
#define PC_END			2
#define	INFO_MESG		3
#define ERR_MESG		4
#define ORA_MESG		5  

#include <stdio.h>
#include <string.h> 
#include <ctype.h>

#define OERROR        (sqlca.sqlcode < 0)
#define NOT_FOUND     (sqlca.sqlerrd[2] == 0)
#define TOO_MANY_ROWS  (sqlca.sqlcode == -2112)

/* EXEC SQL BEGIN DECLARE SECTION; */ 


extern /* VARCHAR acc_post_year[5]; */ 
struct { unsigned short len; unsigned char arr[5]; } acc_post_year;

extern /* VARCHAR acc_post_month[3]; */ 
struct { unsigned short len; unsigned char arr[3]; } acc_post_month;

extern /* VARCHAR acc_desc[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } acc_desc;

extern /* VARCHAR acc_start_date[11]; */ 
struct { unsigned short len; unsigned char arr[11]; } acc_start_date;

extern /* VARCHAR acc_end_date[11]; */ 
struct { unsigned short len; unsigned char arr[11]; } acc_end_date;

extern /* VARCHAR cal_post_year[5]; */ 
struct { unsigned short len; unsigned char arr[5]; } cal_post_year;

extern /* VARCHAR cal_post_month[3]; */ 
struct { unsigned short len; unsigned char arr[3]; } cal_post_month;


/* VARCHAR   v_date[11]; */ 
struct { unsigned short len; unsigned char arr[11]; } v_date;

int   v_month,v_year;


/* EXEC SQL END DECLARE SECTION; */ 

/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/GL/INCLUDE/sy_accpr.c-arc   1.0   Apr 19 2007 17:12:20   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/GL/INCLUDE/sy_accpr.c-arc   1.0   Apr 19 2007 17:12:20   vcm_th  $ sqlda.h 
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






void get_acc_mth_yr(char *);
void get_all_acc_per_details(char *);
void get_acc_period_details(int, int);
void get_cal_period_details(int, int);


/***************************************************************************
 *																		   *
 * FUNCTION	NAME 	: get_acc_mth_yr 									   *									   
 *																		   *
 * DESCRIPTION		: Procedure to find the Accounting Month and Year	   *
 *					  based on the date given as input from the table	   *
 *                    sy_acc_period_defn.								   *
 *																		   *
 * INPUT(S)			: l_pat_date   - Input date for deciding Acc Mth and Yr*
 *																		   *
 * OUTPUT(S)		: v_acc_mth- Account Month for the Date				   *
 *					  v_acc_yr - Account Year  for the Date				   *
 *					  v_acc_desc - Account Period description			   *
 *																		   *
 * CREATED BY		: V. Srikanth. 										   *
 *																		   *
 * CREATION DATE	: 24/09/1999										   *
 *																		   *
 ***************************************************************************/

void get_acc_mth_yr(l_pat_date)
char l_pat_date [];
{

char st_var[150];

strcpy(v_date.arr,l_pat_date);
v_date.len = strlen(v_date.arr);

acc_post_year.arr[0] = '\0';
acc_post_year.len = 0;
acc_post_month.arr[0] = '\0';
acc_post_month.len = 0;
acc_desc.arr[0] = '\0';
acc_desc.len = 0;


/* EXEC SQL SELECT	ACC_PER_YEAR,
	       	ACC_PER_MONTH,
	       	ACC_PER_DESC
	INTO	:acc_post_year,
		    :acc_post_month,
		    :acc_desc
	FROM   	SY_ACC_PERIOD_DEFN
	WHERE   ACC_PER_START_DATE <= TO_DATE(:v_date,'DD/MM/YYYY') AND
			ACC_PER_END_DATE   >= TO_DATE(:v_date,'DD/MM/YYYY'); */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 5;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select ACC_PER_YEAR ,ACC_PER_MONTH ,ACC_PER_DESC into :b0,:b1\
,:b2  from SY_ACC_PERIOD_DEFN where (ACC_PER_START_DATE<=TO_DATE(:b3,'DD/MM/YY\
YY') and ACC_PER_END_DATE>=TO_DATE(:b3,'DD/MM/YYYY'))";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )5;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&acc_post_year;
sqlstm.sqhstl[0] = (unsigned int  )7;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&acc_post_month;
sqlstm.sqhstl[1] = (unsigned int  )5;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&acc_desc;
sqlstm.sqhstl[2] = (unsigned int  )18;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&v_date;
sqlstm.sqhstl[3] = (unsigned int  )13;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&v_date;
sqlstm.sqhstl[4] = (unsigned int  )13;
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

  

if (NOT_FOUND)
{
	sprintf(st_var,"Acc. Period for Date %s not found",v_date.arr);
	err_mesg(st_var,0,"");
}

if (OERROR)
{
	if (TOO_MANY_ROWS)
	{
		sprintf(st_var,"More than 1 Acc. Period Exist for Date %s",v_date.arr);
		err_mesg(st_var,0,"");
	}
	else
		err_mesg("SELECT failed on table SY_ACC_PERIOD_DEFN",0,"");
}

acc_post_year.arr[acc_post_year.len] = '\0';
acc_post_month.arr[acc_post_month.len] = '\0';
acc_desc.arr[acc_desc.len] = '\0';

}


/***************************************************************************
 *																		   *
 * FUNCTION	NAME 	: get_all_acc_per_details 									   *									   
 *																		   *
 * DESCRIPTION		: Procedure to return all the details from			   *
 *					  sy_acc_period_defn that belongs to the date          * 
 *                    given as input to it.							       *
 *																		   *
 * INPUT(S)			: l_pat_date   - Input date for deciding Acc Mth and Yr*
 *																		   *
 * OUTPUT(S)		: v_acc_mth- Account Month for the Date				   *
 *					  v_acc_yr - Account Year  for the Date				   *
 *					  v_acc_desc - Account Period description			   *
 *					  v_start_date -- start date		                   *
 * 					  v_end_date   -- end date                             *
 * 					  v_cal_yr     -- Calendar year for the Date           *
 * 					  v_cal_mth    -- Calendar month for the Date		   *
 *																		   *
 * CREATED BY		: V. Srikanth. 										   *
 *																		   *
 * CREATION DATE	: 29/09/1999										   *
 *																		   *
 ***************************************************************************/

void get_all_acc_per_details(l_pat_date)
char l_pat_date [];
{

char st_var[150];

strcpy(v_date.arr,l_pat_date);
v_date.len = strlen(v_date.arr);

acc_post_year.arr[0] = '\0';
acc_post_year.len = 0;
acc_post_month.arr[0] = '\0';
acc_post_month.len = 0;
acc_desc.arr[0] = '\0';
acc_desc.len = 0;
acc_start_date.arr[0] = '\0';
acc_start_date.len = 0;
acc_end_date.arr[0] = '\0';
acc_end_date.len = 0;
cal_post_year.arr[0] = '\0';
cal_post_year.len = 0;
cal_post_month.arr[0] = '\0';
cal_post_month.len = 0;


/* EXEC SQL SELECT	ACC_PER_YEAR,
	       	ACC_PER_MONTH,
	       	ACC_PER_DESC,
			ACC_PER_START_DATE,
			ACC_PER_END_DATE,
			CAL_PER_YEAR,
			CAL_PER_MONTH
	INTO	:acc_post_year,
		    :acc_post_month,
		    :acc_desc,
			:acc_start_date,
			:acc_end_date,
			:cal_post_year,
			:cal_post_month
	FROM   	SY_ACC_PERIOD_DEFN
	WHERE   ACC_PER_START_DATE <= TO_DATE(:v_date,'DD/MM/YYYY') AND
			ACC_PER_END_DATE   >= TO_DATE(:v_date,'DD/MM/YYYY'); */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 9;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select ACC_PER_YEAR ,ACC_PER_MONTH ,ACC_PER_DESC ,ACC_PER_STA\
RT_DATE ,ACC_PER_END_DATE ,CAL_PER_YEAR ,CAL_PER_MONTH into :b0,:b1,:b2,:b3,:b\
4,:b5,:b6  from SY_ACC_PERIOD_DEFN where (ACC_PER_START_DATE<=TO_DATE(:b7,'DD/\
MM/YYYY') and ACC_PER_END_DATE>=TO_DATE(:b7,'DD/MM/YYYY'))";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )40;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&acc_post_year;
sqlstm.sqhstl[0] = (unsigned int  )7;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&acc_post_month;
sqlstm.sqhstl[1] = (unsigned int  )5;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&acc_desc;
sqlstm.sqhstl[2] = (unsigned int  )18;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&acc_start_date;
sqlstm.sqhstl[3] = (unsigned int  )13;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&acc_end_date;
sqlstm.sqhstl[4] = (unsigned int  )13;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&cal_post_year;
sqlstm.sqhstl[5] = (unsigned int  )7;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&cal_post_month;
sqlstm.sqhstl[6] = (unsigned int  )5;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&v_date;
sqlstm.sqhstl[7] = (unsigned int  )13;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&v_date;
sqlstm.sqhstl[8] = (unsigned int  )13;
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

  

if (NOT_FOUND)
{
	sprintf(st_var,"Acc. Period for Date %s not found",v_date.arr);
	err_mesg(st_var,0,"");
}

if (OERROR)
{
	if (TOO_MANY_ROWS)
	{
		sprintf(st_var,"More than 1 Acc. Period Exist for Date %s",v_date.arr);
		err_mesg(st_var,0,"");
	}
	else
		err_mesg("SELECT failed on table SY_ACC_PERIOD_DEFN",0,"");
}

acc_post_year.arr[acc_post_year.len] = '\0';
acc_post_month.arr[acc_post_month.len] = '\0';
acc_desc.arr[acc_desc.len] = '\0';
acc_start_date.arr[acc_start_date.len] = '\0';
acc_end_date.arr[acc_end_date.len] = '\0';
cal_post_year.arr[cal_post_year.len] = '\0';
cal_post_month.arr[cal_post_month.len] = '\0';

}

/***************************************************************************
 *																		   *
 * FUNCTION	NAME 	: get_cal_period_details							   *									   
 *																		   *
 * DESCRIPTION		: Procedure to find the Accounting start date, end date*
 *			          acc desc, Accounting year, month based on the input  *
 *			          Cal.Month and Year from the table sy_acc_period_defn.*
 *																		   *
 * INPUT(S)			: l_cal_yr   - Calendar Year						   *
 *                    l_cal_mth  - Calendar Month                          *
 *																		   *
 * OUTPUT(S)		: v_acc_mth- Accounting Month						   *
 *					  v_acc_yr - Accountint Year						   *
 *					  v_acc_desc - Account Period description			   *
 *					  v_start_date -- start date		                   *
 * 					  v_end_date   -- end date                             *
 *																		   *
 * CREATED BY		: V. Srikanth. 										   *
 *																		   *
 * CREATION DATE	: 29/09/1999										   *
 *																		   *
 ***************************************************************************/

void get_cal_period_details(l_cal_yr,l_cal_mth)
int l_cal_yr;
int l_cal_mth;
{

char st_var[150];

v_year = l_cal_yr;
v_month = l_cal_mth;

acc_post_year.arr[0] = '\0';
acc_post_year.len = 0;
acc_post_month.arr[0] = '\0';
acc_post_month.len = 0;
acc_desc.arr[0] = '\0';
acc_desc.len = 0;
acc_start_date.arr[0] = '\0';
acc_start_date.len = 0;
acc_end_date.arr[0] = '\0';
acc_end_date.len = 0;


/* EXEC SQL SELECT	ACC_PER_YEAR,
	       	ACC_PER_MONTH,
	       	ACC_PER_DESC,
			ACC_PER_START_DATE,
			ACC_PER_END_DATE
	INTO	:acc_post_year,
		    :acc_post_month,
		    :acc_desc,
			:acc_start_date,
			:acc_end_date
	FROM   	SY_ACC_PERIOD_DEFN
	WHERE   CAL_PER_YEAR = :v_year AND
			CAL_PER_MONTH = :v_month; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 9;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select ACC_PER_YEAR ,ACC_PER_MONTH ,ACC_PER_DESC ,ACC_PER_STA\
RT_DATE ,ACC_PER_END_DATE into :b0,:b1,:b2,:b3,:b4  from SY_ACC_PERIOD_DEFN wh\
ere (CAL_PER_YEAR=:b5 and CAL_PER_MONTH=:b6)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )91;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&acc_post_year;
sqlstm.sqhstl[0] = (unsigned int  )7;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&acc_post_month;
sqlstm.sqhstl[1] = (unsigned int  )5;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&acc_desc;
sqlstm.sqhstl[2] = (unsigned int  )18;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&acc_start_date;
sqlstm.sqhstl[3] = (unsigned int  )13;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&acc_end_date;
sqlstm.sqhstl[4] = (unsigned int  )13;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&v_year;
sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&v_month;
sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
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



if (NOT_FOUND)
{
	sprintf(st_var,"Record for Cal. period << %d/%d >> not found",l_cal_mth,l_cal_yr);
	err_mesg(st_var,0,"");
}

if (OERROR)
{
	if (TOO_MANY_ROWS)
	{
		sprintf(st_var,"More than 1 record Exists for Cal. Period << %d/%d >>",l_cal_mth,l_cal_yr);
		err_mesg(st_var,0,"");
	}
	else
		err_mesg("SELECT failed on table SY_ACC_PERIOD_DEFN",0,"");
}

acc_post_year.arr[acc_post_year.len] = '\0';
acc_post_month.arr[acc_post_month.len] = '\0';
acc_desc.arr[acc_desc.len] = '\0';
acc_start_date.arr[acc_start_date.len] = '\0';
acc_end_date.arr[acc_end_date.len] = '\0';
}

/***************************************************************************
 *																		   *
 * FUNCTION	NAME 	: get_acc_period_details							   *									   
 *																		   *
 * DESCRIPTION		: Procedure to find the Accounting start date, end date*
 *			          acc desc, Calendar year, month based on the input    *
 *			          Acc.Month and Year from the table sy_acc_period_defn.*
 *																		   *
 * INPUT(S)			: l_acc_yr   - Accounting Year						   *
 *                    l_acc_mth  - Accounting Month                        *
 *																		   *
 * OUTPUT(S)		: v_cal_mth- Calendar Month							   *
 *					  v_cal_yr - Calendar Year							   *
 *					  v_acc_desc - Account Period description			   *
 *					  v_start_date -- start date		                   *
 * 					  v_end_date   -- end date                             *
 *																		   *
 * CREATED BY		: V. Srikanth. 										   *
 *																		   *
 * CREATION DATE	: 29/09/1999										   *
 *																		   *
 ***************************************************************************/

void get_acc_period_details(l_acc_yr,l_acc_mth)
int l_acc_yr;
int l_acc_mth;
{

char st_var[150];

v_month = l_acc_mth;
v_year = l_acc_yr;

cal_post_year.arr[0] = '\0';
cal_post_year.len = 0;
cal_post_month.arr[0] = '\0';
cal_post_month.len = 0;
acc_desc.arr[0] = '\0';
acc_desc.len = 0;
acc_start_date.arr[0] = '\0';
acc_start_date.len = 0;
acc_end_date.arr[0] = '\0';
acc_end_date.len = 0;

 /* EXEC SQL SELECT	CAL_PER_YEAR,
	       	CAL_PER_MONTH,
	       	ACC_PER_DESC,
			ACC_PER_START_DATE,
			ACC_PER_END_DATE
	INTO	:cal_post_year,
		    :cal_post_month,
		    :acc_desc,
			:acc_start_date,
			:acc_end_date
	FROM   	SY_ACC_PERIOD_DEFN
	WHERE   ACC_PER_YEAR = :v_year AND
			ACC_PER_MONTH = :v_month; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CAL_PER_YEAR ,CAL_PER_MONTH ,ACC_PER_DESC ,ACC_PER_ST\
ART_DATE ,ACC_PER_END_DATE into :b0,:b1,:b2,:b3,:b4  from SY_ACC_PERIOD_DEFN w\
here (ACC_PER_YEAR=:b5 and ACC_PER_MONTH=:b6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )134;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cal_post_year;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cal_post_month;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&acc_desc;
 sqlstm.sqhstl[2] = (unsigned int  )18;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&acc_start_date;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&acc_end_date;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&v_year;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&v_month;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
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

 

if (NOT_FOUND)
{
	sprintf(st_var,"Record for Acc. period << %d/%d >> not found",l_acc_mth,l_acc_yr);
	err_mesg(st_var,0,"");
}

if (OERROR)
{
	if (TOO_MANY_ROWS)
	{
		sprintf(st_var,"More than 1 record Exists for Acc. Period << %d/%d >>",l_acc_mth,l_acc_yr);
		err_mesg(st_var,0,"");
	}
	else
		err_mesg("SELECT failed on table SY_ACC_PERIOD_DEFN",0,"");
}

cal_post_year.arr[cal_post_year.len] = '\0';
cal_post_month.arr[cal_post_month.len] = '\0';
acc_desc.arr[acc_desc.len] = '\0';
acc_start_date.arr[acc_start_date.len] = '\0';
acc_end_date.arr[acc_end_date.len] = '\0';
}
