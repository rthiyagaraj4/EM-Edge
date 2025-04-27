
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
           char  filnam[33];
};
static const struct sqlcxp sqlfpn =
{
    32,
    "T:\\temp\\Gl\\IQTeH-1158\\YEAREND.PC"
};


static unsigned long sqlctx = 479552197;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {10,17};

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

 static const char *sq0002 = 
"select A.MAIN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.PRODUCT_GROUP_CODE\
 ,A.PRODUCT_LINE_CODE ,A.SUBLEDGER_GROUP_CODE ,A.SUBLEDGER_LINE_CODE ,A.YEAR_B\
AL_CR ,A.YEAR_BAL_DR ,A.YEAR_BAL_CR_FC ,A.YEAR_BAL_DR_FC  from GL_PERIOD_ACC_B\
AL_LOCAL A where ((A.POST_MONTH=:b0 and A.POST_YEAR=:b1) and exists (select 'X\
'  from GL_ACC_CHART B where ((A.MAIN_ACC1_CODE=B.MAIN_ACC1_CODE and A.MAIN_AC\
C2_CODE=B.MAIN_ACC2_CODE) and NVL(ACC_NATURE_CODE,'XX')='BS')))           ";

 static const char *sq0011 = 
"select BATCH_NUM  from GL_TXN_BATCH_HDR where ((POST_MONTH=0 and POST_YEAR=:\
b0) and NVL(POSTED_FLAG,'N')='Y') for update of BATCH_NUM ";

 static const char *sq0012 = 
"select DOC_TYPE_CODE ,DOC_NUM  from GL_TXN_DOC_HDR where BATCH_NUM=:b0      \
     ";

 static const char *sq0013 = 
"select DOC_TYPE_CODE ,DOC_NUM  from GL_TXN_DOC_HDR where (((BATCH_NUM=0 and \
POST_MONTH=0) and POST_YEAR=:b0) and NVL(POSTED_FLAG,'N')='Y') for update of D\
OC_TYPE_CODE ";

 static const char *sq0016 = 
"select BATCH_NUM  from GL_TXN_BATCH_HDR where ((POST_MONTH=:b0 and POST_YEAR\
=:b1) and NVL(POSTED_FLAG,'N')='Y') for update of BATCH_NUM ";

 static const char *sq0017 = 
"select DOC_TYPE_CODE ,DOC_NUM  from GL_TXN_DOC_HDR where BATCH_NUM=:b0      \
     ";

 static const char *sq0018 = 
"select DOC_TYPE_CODE ,DOC_NUM ,NVL(MODULE_ID,'XX')  from GL_TXN_DOC_HDR wher\
e ((((BATCH_NUM=0 and POST_MONTH=:b0) and POST_YEAR=:b1) and NVL(MODULE_ID,'XX\
')='GL') and NVL(POSTED_FLAG,'N')='Y') for update of DOC_TYPE_CODE ";

 static const char *sq0019 = 
"select DOC_TYPE_CODE ,DOC_NUM ,BATCH_NUM ,NVL(MODULE_ID,'XX')  from GL_TXN_D\
OC_HDR where (((POST_MONTH=:b0 and POST_YEAR=:b1) and NVL(MODULE_ID,'XX')<>'GL\
') and NVL(POSTED_FLAG,'N')='Y') for update of DOC_TYPE_CODE ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,1230,0,3,55,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
28,0,0,2,462,0,9,134,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
51,0,0,3,382,0,4,148,0,0,17,13,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,3,0,0,1,3,0,0,
134,0,0,4,341,0,5,174,0,0,13,13,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
201,0,0,2,0,0,15,193,0,0,0,0,0,1,0,
216,0,0,5,195,0,5,215,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
239,0,0,6,195,0,5,226,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
262,0,0,7,115,0,5,244,0,0,0,0,0,1,0,
277,0,0,8,127,0,5,252,0,0,0,0,0,1,0,
292,0,0,9,115,0,5,261,0,0,0,0,0,1,0,
307,0,0,10,115,0,5,269,0,0,0,0,0,1,0,
322,0,0,2,0,0,13,290,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
381,0,0,11,134,0,9,362,0,0,1,1,0,1,0,1,3,0,0,
400,0,0,12,81,0,9,378,0,0,1,1,0,1,0,1,3,0,0,
419,0,0,14,72,0,46,392,0,0,1,1,0,1,0,1,9,0,0,
438,0,0,13,167,0,9,404,0,0,1,1,0,1,0,1,3,0,0,
457,0,0,15,70,0,46,417,0,0,1,1,0,1,0,1,9,0,0,
476,0,0,11,0,0,15,426,0,0,0,0,0,1,0,
491,0,0,12,0,0,15,427,0,0,0,0,0,1,0,
506,0,0,13,0,0,15,428,0,0,0,0,0,1,0,
521,0,0,16,136,0,9,489,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
544,0,0,17,81,0,9,496,0,0,1,1,0,1,0,1,3,0,0,
563,0,0,20,72,0,46,510,0,0,1,1,0,1,0,1,9,0,0,
582,0,0,18,221,0,9,517,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
605,0,0,21,70,0,46,532,0,0,1,1,0,1,0,1,9,0,0,
624,0,0,19,215,0,9,543,0,0,2,2,0,1,0,1,3,0,0,1,3,0,0,
647,0,0,22,70,0,46,556,0,0,1,1,0,1,0,1,9,0,0,
666,0,0,16,0,0,15,567,0,0,0,0,0,1,0,
681,0,0,17,0,0,15,568,0,0,0,0,0,1,0,
696,0,0,18,0,0,15,569,0,0,0,0,0,1,0,
711,0,0,19,0,0,15,570,0,0,0,0,0,1,0,
726,0,0,11,0,0,13,578,0,0,1,0,0,1,0,2,3,0,0,
745,0,0,12,0,0,13,594,0,0,2,0,0,1,0,2,9,0,0,2,3,0,0,
768,0,0,13,0,0,13,613,0,0,2,0,0,1,0,2,9,0,0,2,3,0,0,
791,0,0,18,0,0,13,632,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,
818,0,0,19,0,0,13,653,0,0,4,0,0,1,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,
849,0,0,16,0,0,13,675,0,0,1,0,0,1,0,2,3,0,0,
868,0,0,17,0,0,13,691,0,0,2,0,0,1,0,2,9,0,0,2,3,0,0,
};


/*
#define DEBUG
*/

#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA (sqlca.sqlcode == 1403)
#define EQ ==
 
/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR    t_main_acc1_code        [8],
	       t_main_acc2_code        [6],
	       t_dept_code             [8],
	       t_product_group_code    [4],
	       t_product_line_code     [6],
	       t_subledger_group_code  [4],
	       t_subledger_line_code   [10],
	       t_doc_type_code         [8],
           t_summ_process_flag     [2],
	       t_module_id             [4]; */ 
struct { unsigned short len; unsigned char arr[8]; } t_main_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } t_main_acc2_code;

struct { unsigned short len; unsigned char arr[8]; } t_dept_code;

struct { unsigned short len; unsigned char arr[4]; } t_product_group_code;

struct { unsigned short len; unsigned char arr[6]; } t_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } t_subledger_group_code;

struct { unsigned short len; unsigned char arr[10]; } t_subledger_line_code;

struct { unsigned short len; unsigned char arr[8]; } t_doc_type_code;

struct { unsigned short len; unsigned char arr[2]; } t_summ_process_flag;

struct { unsigned short len; unsigned char arr[4]; } t_module_id;


int i;
extern int d_curr_year,
	       d_curr_month,
           d_num_of_acc_periods;

extern char d_summ_flag;

double t_year_bal_cr,
       t_year_bal_dr,
	   t_year_bal_cr_fc,
	   t_year_bal_dr_fc,
	   t_latest_year_bal_cr,
	   t_latest_year_bal_dr,
	   t_latest_year_bal_cr_fc,
	   t_latest_year_bal_dr_fc;

long t_batch_num,
     t_doc_num;

/* varchar testing[200]; */ 
struct { unsigned short len; unsigned char arr[200]; } testing;


/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.h;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/GL/INCLUDE/YEAREND.c-arc   1.0   Apr 19 2007 17:12:20   vcm_th  $ sqlca.h 
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



extern char g_pgm_id[];

extern char g_err_msg[];


do_prbal_year()  
{
	/* EXEC SQL INSERT INTO GL_PERIOD_ACC_BAL_LOCAL
			(MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,
			 PRODUCT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,
		     POST_MONTH,POST_YEAR,MONTH_BAL_CR,MONTH_BAL_DR,MONTH_BAL_CR_FC,MONTH_BAL_DR_FC,
			 YEAR_BAL_CR,YEAR_BAL_DR,YEAR_BAL_CR_FC,YEAR_BAL_DR_FC
			)
		    (SELECT A.MAIN_ACC1_CODE,A.MAIN_ACC2_CODE,A.DEPT_CODE,A.PRODUCT_GROUP_CODE,
					A.PRODUCT_LINE_CODE,A.SUBLEDGER_GROUP_CODE,A.SUBLEDGER_LINE_CODE,
					A.POST_MONTH,(A.POST_YEAR + 1),0,0,0,0,0,0,0,0
			   FROM GL_PERIOD_ACC_BAL_LOCAL A
              WHERE A.POST_YEAR = :d_curr_year 
                AND (A.MAIN_ACC1_CODE||A.MAIN_ACC2_CODE||A.DEPT_CODE||A.PRODUCT_GROUP_CODE||
                     A.PRODUCT_LINE_CODE||A.SUBLEDGER_GROUP_CODE||A.SUBLEDGER_LINE_CODE)
             NOT IN
            ( SELECT (B.MAIN_ACC1_CODE||B.MAIN_ACC2_CODE||B.DEPT_CODE||B.PRODUCT_GROUP_CODE||
                      B.PRODUCT_LINE_CODE||B.SUBLEDGER_GROUP_CODE||B.SUBLEDGER_LINE_CODE)
                FROM GL_PERIOD_ACC_BAL_LOCAL B
               WHERE B.POST_YEAR = (:d_curr_year + 1)
                 AND A.MAIN_ACC1_CODE = B.MAIN_ACC1_CODE
                 AND A.MAIN_ACC2_CODE = B.MAIN_ACC2_CODE
                 AND A.DEPT_CODE      = B.DEPT_CODE
                 AND A.PRODUCT_GROUP_CODE = B.PRODUCT_GROUP_CODE
                 AND A.PRODUCT_LINE_CODE  = B.PRODUCT_LINE_CODE
                 AND A.SUBLEDGER_GROUP_CODE = B.SUBLEDGER_GROUP_CODE
                 AND A.SUBLEDGER_LINE_CODE  = B.SUBLEDGER_LINE_CODE
			 )); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "insert into GL_PERIOD_ACC_BAL_LOCAL (MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_\
CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LIN\
E_CODE,POST_MONTH,POST_YEAR,MONTH_BAL_CR,MONTH_BAL_DR,MONTH_BAL_CR_FC,MONTH_\
BAL_DR_FC,YEAR_BAL_CR,YEAR_BAL_DR,YEAR_BAL_CR_FC,YEAR_BAL_DR_FC)(select A.MA\
IN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.PRODUCT_GROUP_CODE ,A.PRODUCT\
_LINE_CODE ,A.SUBLEDGER_GROUP_CODE ,A.SUBLEDGER_LINE_CODE ,A.POST_MONTH ,(A.\
POST_YEAR+1) ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0  from GL_PERIOD_ACC_BAL_LOCAL A where (\
A.POST_YEAR=:b0 and ((((((A.MAIN_ACC1_CODE||A.MAIN_ACC2_CODE)||A.DEPT_CODE)|\
|A.PRODUCT_GROUP_CODE)||A.PRODUCT_LINE_CODE)||A.SUBLEDGER_GROUP_CODE)||A.SUB\
LEDGER_LINE_CODE) not  in (select ((((((B.MAIN_ACC1_CODE||B.MAIN_ACC2_CODE)|\
|B.DEPT_CODE)||B.PRODUCT_GROUP_CODE)||B.PRODUCT_LINE_CODE)||B.SUBLEDGER_GROU\
P_CODE)||B.SUBLEDGER_LINE_CODE)  from GL_PERIOD_ACC_BAL_LOCAL B where ((((((\
(B.POST_YEAR=(:b0+1) and A.MAIN_ACC1_CODE=B.MAIN_ACC1_CODE) and A.MAIN_ACC2_\
CODE=B.MAIN_ACC2_CODE) and A.DEPT_CODE=B");
 sqlstm.stmt = ".DEPT_CODE) and A.PRODUCT_GROUP_CODE=B.PRODUCT_GROUP_CODE) a\
nd A.PRODUCT_LINE_CODE=B.PRODUCT_LINE_CODE) and A.SUBLEDGER_GROUP_CODE=B.SUBLE\
DGER_GROUP_CODE) and A.SUBLEDGER_LINE_CODE=B.SUBLEDGER_LINE_CODE))))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_curr_year;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_curr_year;
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


/*
    EXEC SQL INSERT INTO GL_PERIOD_ACC_BAL_LOCAL
	               ( MAIN_ACC1_CODE ,
		    	 MAIN_ACC2_CODE ,
		    	 DEPT_CODE ,
		    	 PRODUCT_GROUP_CODE ,
		    	 PRODUCT_LINE_CODE ,
		    	 SUBLEDGER_GROUP_CODE ,
		    	 SUBLEDGER_LINE_CODE ,
		    	 POST_MONTH ,
		    	 POST_YEAR ,
		    	 MONTH_BAL_CR ,
		    	 MONTH_BAL_DR ,
		    	 YEAR_BAL_CR ,
		    	 YEAR_BAL_DR 
		       )
	     SELECT      MAIN_ACC1_CODE ,
		    	 MAIN_ACC2_CODE ,
		    	 DEPT_CODE ,
		    	 PRODUCT_GROUP_CODE ,
		    	 PRODUCT_LINE_CODE ,
		    	 SUBLEDGER_GROUP_CODE ,
		    	 SUBLEDGER_LINE_CODE ,
		    	 POST_MONTH ,
		    	 POST_YEAR + 1,
		    	 0 ,
		    	 0 ,
		    	 0 ,
		    	 0 
	     FROM        GL_PERIOD_ACC_BAL_LOCAL
             WHERE      POST_YEAR = :d_curr_year;   
*/

    /* EXEC SQL DECLARE GL_PERIOD_YEAR CURSOR FOR
	     SELECT  A.MAIN_ACC1_CODE,
	             A.MAIN_ACC2_CODE,
	             A.DEPT_CODE,
	             A.PRODUCT_GROUP_CODE,
	             A.PRODUCT_LINE_CODE ,
	             A.SUBLEDGER_GROUP_CODE ,
	             A.SUBLEDGER_LINE_CODE,
		         A.YEAR_BAL_CR,
		         A.YEAR_BAL_DR,
			     A.YEAR_BAL_CR_FC,
			     A.YEAR_BAL_DR_FC
             FROM    GL_PERIOD_ACC_BAL_LOCAL A
	     WHERE   A.POST_MONTH  = :d_curr_month
	     AND     A.POST_YEAR   = :d_curr_year 
             AND     EXISTS (SELECT 'X' FROM GL_ACC_CHART B
			     WHERE   A.MAIN_ACC1_CODE = B.MAIN_ACC1_CODE
		             AND     A.MAIN_ACC2_CODE = B.MAIN_ACC2_CODE
			     AND     NVL(ACC_NATURE_CODE,'XX') = 'BS'); */ 


    /* EXEC SQL OPEN GL_PERIOD_YEAR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0002;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )28;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_curr_month;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_curr_year;
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



    if(OERROR)
        err_mesg("OPEN failed on cursor GL_PERIOD_YEAR",0,"");

    while(fetch_period_year()) {
	
			t_latest_year_bal_cr = t_year_bal_cr;
			t_latest_year_bal_dr = t_year_bal_dr;
			t_latest_year_bal_cr_fc = t_year_bal_cr_fc;
			t_latest_year_bal_dr_fc = t_year_bal_dr_fc;
	   for ( i=0; i<=12 ; i++)
	   {		
			
			/* EXEC SQL SELECT :t_latest_year_bal_cr + month_bal_cr,
							:t_latest_year_bal_dr + month_bal_dr,
							:t_latest_year_bal_cr_fc + month_bal_cr_fc,
							:t_latest_year_bal_dr_fc + month_bal_dr_fc
					   INTO :t_latest_year_bal_cr,
							:t_latest_year_bal_dr,
							:t_latest_year_bal_cr_fc,
							:t_latest_year_bal_dr_fc
					   FROM  GL_PERIOD_ACC_BAL_LOCAL
					  WHERE  MAIN_ACC1_CODE       =  :t_main_acc1_code
						AND  MAIN_ACC2_CODE       =  :t_main_acc2_code
						AND  DEPT_CODE            =  :t_dept_code
						AND  PRODUCT_GROUP_CODE   =  :t_product_group_code
						AND  PRODUCT_LINE_CODE    =  :t_product_line_code
						AND  SUBLEDGER_GROUP_CODE =  :t_subledger_group_code
						AND  SUBLEDGER_LINE_CODE  =  :t_subledger_line_code
						AND  POST_YEAR            =  :d_curr_year + 1
						AND  POST_MONTH           =  :i ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (:b0+month_bal_cr) ,(:b1+month_bal_dr) ,(:b2+month_\
bal_cr_fc) ,(:b3+month_bal_dr_fc) into :b0,:b1,:b2,:b3  from GL_PERIOD_ACC_BAL\
_LOCAL where ((((((((MAIN_ACC1_CODE=:b8 and MAIN_ACC2_CODE=:b9) and DEPT_CODE=\
:b10) and PRODUCT_GROUP_CODE=:b11) and PRODUCT_LINE_CODE=:b12) and SUBLEDGER_G\
ROUP_CODE=:b13) and SUBLEDGER_LINE_CODE=:b14) and POST_YEAR=(:b15+1)) and POST\
_MONTH=:b16)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&t_latest_year_bal_cr;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&t_latest_year_bal_dr;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&t_latest_year_bal_cr_fc;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&t_latest_year_bal_dr_fc;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&t_latest_year_bal_cr;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&t_latest_year_bal_dr;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&t_latest_year_bal_cr_fc;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&t_latest_year_bal_dr_fc;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&t_main_acc1_code;
   sqlstm.sqhstl[8] = (unsigned int  )10;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&t_main_acc2_code;
   sqlstm.sqhstl[9] = (unsigned int  )8;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&t_dept_code;
   sqlstm.sqhstl[10] = (unsigned int  )10;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&t_product_group_code;
   sqlstm.sqhstl[11] = (unsigned int  )6;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&t_product_line_code;
   sqlstm.sqhstl[12] = (unsigned int  )8;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&t_subledger_group_code;
   sqlstm.sqhstl[13] = (unsigned int  )6;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&t_subledger_line_code;
   sqlstm.sqhstl[14] = (unsigned int  )12;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_curr_year;
   sqlstm.sqhstl[15] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&i;
   sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
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


					
					if (NO_DATA)
					err_mesg("Balance Record not found",0,"");
					 

					if(OERROR)
						err_mesg("SELECT failed on table GL_PERIOD_ACC_BAL_LOCAL",0,"");
   
			/* EXEC SQL UPDATE GL_PERIOD_ACC_BAL_LOCAL
				 SET    YEAR_BAL_CR          =  :t_latest_year_bal_cr,
					    YEAR_BAL_DR          =  :t_latest_year_bal_dr,
						YEAR_BAL_CR_FC       =  :t_latest_year_bal_cr_fc,
						YEAR_BAL_DR_FC       =  :t_latest_year_bal_dr_fc
					 WHERE  MAIN_ACC1_CODE       =  :t_main_acc1_code
					 AND    MAIN_ACC2_CODE       =  :t_main_acc2_code
					 AND    DEPT_CODE            =  :t_dept_code
					 AND    PRODUCT_GROUP_CODE   =  :t_product_group_code
					 AND    PRODUCT_LINE_CODE    =  :t_product_line_code
					 AND    SUBLEDGER_GROUP_CODE =  :t_subledger_group_code
					 AND    SUBLEDGER_LINE_CODE  =  :t_subledger_line_code
					 AND    POST_YEAR            =  :d_curr_year + 1
					 AND    POST_MONTH           =  :i; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update GL_PERIOD_ACC_BAL_LOCAL  set YEAR_BAL_CR=:b0,YEAR_B\
AL_DR=:b1,YEAR_BAL_CR_FC=:b2,YEAR_BAL_DR_FC=:b3 where ((((((((MAIN_ACC1_CODE=:\
b4 and MAIN_ACC2_CODE=:b5) and DEPT_CODE=:b6) and PRODUCT_GROUP_CODE=:b7) and \
PRODUCT_LINE_CODE=:b8) and SUBLEDGER_GROUP_CODE=:b9) and SUBLEDGER_LINE_CODE=:\
b10) and POST_YEAR=(:b11+1)) and POST_MONTH=:b12)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )134;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&t_latest_year_bal_cr;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&t_latest_year_bal_dr;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&t_latest_year_bal_cr_fc;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&t_latest_year_bal_dr_fc;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&t_main_acc1_code;
   sqlstm.sqhstl[4] = (unsigned int  )10;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&t_main_acc2_code;
   sqlstm.sqhstl[5] = (unsigned int  )8;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&t_dept_code;
   sqlstm.sqhstl[6] = (unsigned int  )10;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&t_product_group_code;
   sqlstm.sqhstl[7] = (unsigned int  )6;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&t_product_line_code;
   sqlstm.sqhstl[8] = (unsigned int  )8;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&t_subledger_group_code;
   sqlstm.sqhstl[9] = (unsigned int  )6;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&t_subledger_line_code;
   sqlstm.sqhstl[10] = (unsigned int  )12;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_curr_year;
   sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&i;
   sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
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
	 			err_mesg("UPDATE failed on table GL_PERIOD_ACC_BAL_LOCAL",0,"");
        } /* end of for loop */
	} /* end of while fetch_period_year */ 

    /* EXEC SQL CLOSE GL_PERIOD_YEAR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )201;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
        err_mesg("CLOSE failed on cursor GL_PERIOD_YEAR",0,"");


}

do_fin_updates() 
{

#ifdef DEBUG
    printf("Inside do_fin_updates ...\n");
    printf("g_pgm_id = <%s>\n",g_pgm_id);
#endif

    if(!strcmp(g_pgm_id,"GLBMTEND")) {

#ifdef DEBUG
    printf("Updating gl_stmt_column for month end ...\n");
#endif

        /* EXEC SQL UPDATE GL_STMT_COLUMN
	         SET    FM_MM_PER = 
			DECODE(FM_MM_PER,:d_num_of_acc_periods,1,FM_MM_PER + 1),
			FM_YY_PER = DECODE(FM_MM_PER,:d_num_of_acc_periods,
					   FM_YY_PER + 1,FM_YY_PER)
	         WHERE  COLUMN_TYPE_CODE = 'MOV'
	         AND    NVL(FM_INC_FCTR_CODE,'X') = 'M'; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_STMT_COLUMN  set FM_MM_PER=DECODE(FM_MM_PER\
,:b0,1,(FM_MM_PER+1)),FM_YY_PER=DECODE(FM_MM_PER,:b0,(FM_YY_PER+1),FM_YY_PER) \
where (COLUMN_TYPE_CODE='MOV' and NVL(FM_INC_FCTR_CODE,'X')='M')";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )216;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_num_of_acc_periods;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_num_of_acc_periods;
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



	if(OERROR)
	    err_mesg("UPDATE failed on table GL_STMT_COLUMN",0,"");
    
        /* EXEC SQL UPDATE GL_STMT_COLUMN
	         SET    TO_MM_PER = 
			DECODE(TO_MM_PER,:d_num_of_acc_periods,1,TO_MM_PER + 1),
			TO_YY_PER = DECODE(TO_MM_PER,:d_num_of_acc_periods,
					   TO_YY_PER + 1,TO_YY_PER)
	         WHERE  COLUMN_TYPE_CODE = 'MOV'
	         AND    NVL(TO_INC_FCTR_CODE,'X') = 'M'; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_STMT_COLUMN  set TO_MM_PER=DECODE(TO_MM_PER\
,:b0,1,(TO_MM_PER+1)),TO_YY_PER=DECODE(TO_MM_PER,:b0,(TO_YY_PER+1),TO_YY_PER) \
where (COLUMN_TYPE_CODE='MOV' and NVL(TO_INC_FCTR_CODE,'X')='M')";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )239;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_num_of_acc_periods;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_num_of_acc_periods;
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



	if(OERROR)
	    err_mesg("UPDATE failed on table GL_STMT_COLUMN",0,"");

    }
    else {

#ifdef DEBUG
    printf("Updating gl_stmt_column for year end ...\n");
#endif

        /* EXEC SQL UPDATE GL_STMT_COLUMN
	         SET    FM_YY_PER = FM_YY_PER + 1
	         WHERE  COLUMN_TYPE_CODE = 'MOV'
	         AND    NVL(FM_INC_FCTR_CODE,'X') = 'M'; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_STMT_COLUMN  set FM_YY_PER=(FM_YY_PER+1) wh\
ere (COLUMN_TYPE_CODE='MOV' and NVL(FM_INC_FCTR_CODE,'X')='M')";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )262;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)
	    err_mesg("UPDATE failed on table GL_STMT_COLUMN",0,"");
    
        /* EXEC SQL UPDATE GL_STMT_COLUMN
	         SET    TO_MM_PER = 1,
			TO_YY_PER = TO_YY_PER + 1
	         WHERE  COLUMN_TYPE_CODE = 'MOV'
	         AND    NVL(TO_INC_FCTR_CODE,'X') = 'M'; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_STMT_COLUMN  set TO_MM_PER=1,TO_YY_PER=(TO_\
YY_PER+1) where (COLUMN_TYPE_CODE='MOV' and NVL(TO_INC_FCTR_CODE,'X')='M')";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )277;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)
	    err_mesg("UPDATE failed on table GL_STMT_COLUMN",0,"");

        /* EXEC SQL UPDATE GL_STMT_COLUMN
	         SET	FM_YY_PER = FM_YY_PER + 1
	         WHERE  COLUMN_TYPE_CODE = 'MOV'
	         AND    NVL(FM_INC_FCTR_CODE,'X') = 'Y'; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_STMT_COLUMN  set FM_YY_PER=(FM_YY_PER+1) wh\
ere (COLUMN_TYPE_CODE='MOV' and NVL(FM_INC_FCTR_CODE,'X')='Y')";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )292;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)
	    err_mesg("UPDATE failed on table GL_STMT_COLUMN",0,"");
    
        /* EXEC SQL UPDATE GL_STMT_COLUMN
	         SET    TO_YY_PER = TO_YY_PER + 1
	         WHERE  COLUMN_TYPE_CODE = 'MOV'
	         AND    NVL(TO_INC_FCTR_CODE,'X') = 'Y'; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_STMT_COLUMN  set TO_YY_PER=(TO_YY_PER+1) wh\
ere (COLUMN_TYPE_CODE='MOV' and NVL(TO_INC_FCTR_CODE,'X')='Y')";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )307;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)
	    err_mesg("UPDATE failed on table GL_STMT_COLUMN",0,"");


    } 


}

fetch_period_year() 
{

    t_year_bal_cr  = 0;
    t_year_bal_dr  = 0;
    t_year_bal_cr_fc = 0;
	t_year_bal_dr_fc = 0;
    /* EXEC SQL FETCH GL_PERIOD_YEAR
	     INTO  :t_main_acc1_code,
		   :t_main_acc2_code,
		   :t_dept_code,
		   :t_product_group_code,
		   :t_product_line_code,
		   :t_subledger_group_code,
		   :t_subledger_line_code,
		   :t_year_bal_cr,
		   :t_year_bal_dr,
		   :t_year_bal_cr_fc,
		   :t_year_bal_dr_fc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )322;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_dept_code;
    sqlstm.sqhstl[2] = (unsigned int  )10;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_product_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_product_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_subledger_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_subledger_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_year_bal_cr;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&t_year_bal_dr;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&t_year_bal_cr_fc;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&t_year_bal_dr_fc;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
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



    if(OERROR)
	err_mesg("FETCH failed on cursor GL_PERIOD_YEAR",0,"");

    if(NO_DATA)
	return 0;

	t_main_acc1_code.arr[t_main_acc1_code.len]             = '\0';
	t_main_acc2_code.arr[t_main_acc2_code.len]             = '\0';
	t_dept_code.arr[t_dept_code.len]                       = '\0';
	t_product_group_code.arr[t_product_group_code.len]     = '\0';
	t_product_line_code.arr[t_product_line_code.len]       = '\0';
	t_subledger_group_code.arr[t_subledger_group_code.len] = '\0';
	t_subledger_line_code.arr[t_subledger_line_code.len]   = '\0';

#ifdef DEBUG
    printf("Fetching posting a/c for BS \n");
    printf("Account code = %s-%s %s %s-%s %s-%s\n",t_main_acc1_code.arr,
    t_main_acc2_code.arr ,t_dept_code.arr ,t_product_group_code.arr,
    t_product_line_code.arr ,t_subledger_group_code.arr , 
    t_subledger_line_code.arr);
#endif

    return 1;


}

do_prior_post()
{

#ifdef DEBUG
    printf("BEGINING PRIOR POSTING\n");
    printf("Curr Month = %d  Curr Year = %d\n",d_curr_month,d_curr_year);
#endif

    /* EXEC SQL DECLARE BATCH_HDR_CUR CURSOR FOR
	     SELECT  BATCH_NUM
	     FROM    GL_TXN_BATCH_HDR 
	     WHERE   POST_MONTH = 0
	     AND     POST_YEAR  = :d_curr_year
	     AND     NVL(POSTED_FLAG,'N') = 'Y'
	     FOR     UPDATE OF BATCH_NUM; */ 


    /* EXEC SQL DECLARE DOC_HDR_CUR CURSOR FOR
	     SELECT  DOC_TYPE_CODE,
		     DOC_NUM
	     FROM    GL_TXN_DOC_HDR
	     WHERE   BATCH_NUM = :t_batch_num; */ 


    /* EXEC SQL DECLARE DOC_HDR_CUR1 CURSOR FOR
	     SELECT  DOC_TYPE_CODE,
		     DOC_NUM
	     FROM    GL_TXN_DOC_HDR
	     WHERE   BATCH_NUM  = 0
	     AND     POST_MONTH = 0
	     AND     POST_YEAR  = :d_curr_year
	     AND     NVL(POSTED_FLAG,'N') = 'Y'
	     FOR     UPDATE OF DOC_TYPE_CODE; */ 


    /* EXEC SQL OPEN BATCH_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )381;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_curr_year;
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



    if(OERROR)
        err_mesg("OPEN failed on cursor BATCH_HDR_CUR",0,"");

    t_summ_process_flag.arr[0] = '\0';
    t_summ_process_flag.len = 0;

    if(d_summ_flag EQ 'O') {
       t_summ_process_flag.arr[0] = 'Y';
       t_summ_process_flag.len = 1;
    }


    while(fetch_batch_hdr()) {

	/* EXEC SQL OPEN DOC_HDR_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0012;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )400;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&t_batch_num;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
	    err_mesg("OPEN failed on cursor DOC_HDR_CUR",0,"");

	while(fetch_doc()) {

            if(post_doc(t_batch_num,t_doc_type_code.arr,
			t_doc_num,g_err_msg) EQ -1) 

       	        err_mesg(g_err_msg,0,"");

	} /* end of while fetch doc_hdr */

        /* EXEC SQL UPDATE GL_TXN_BATCH_HDR
	         SET    SUMMARY_PROCESSED_FLAG = :t_summ_process_flag 
	         WHERE CURRENT OF BATCH_HDR_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_TXN_BATCH_HDR  set SUMMARY_PROCESSED_FLAG=:\
b0 where rowid = :x";
        sqlstm.iters = (unsigned int  )11;
        sqlstm.offset = (unsigned int  )419;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&t_summ_process_flag;
        sqlstm.sqhstl[0] = (unsigned int  )4;
        sqlstm.sqhsts[0] = (         int  )4;
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
            err_mesg("UPDATE failed on table GL_TXN_BATCH_HDR",0,"");

    } /* end of while fetch batch_hdr */


    t_batch_num = 0;

    /* EXEC SQL OPEN DOC_HDR_CUR1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0013;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )438;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_curr_year;
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



    if(OERROR)
        err_mesg("OPEN failed on cursor DOC_HDR_CUR1",0,"");


    while(fetch_doc_hdr1()) {

        if(post_doc(t_batch_num,t_doc_type_code.arr,
		t_doc_num,g_err_msg) EQ -1) 

            err_mesg(g_err_msg,0,"");

	    /* EXEC SQL UPDATE GL_TXN_DOC_HDR
		     SET    SUMMARY_PROCESSED_FLAG = :t_summ_process_flag 
		     WHERE CURRENT OF DOC_HDR_CUR1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update GL_TXN_DOC_HDR  set SUMMARY_PROCESSED_FLAG=:b0 wh\
ere rowid = :x";
     sqlstm.iters = (unsigned int  )13;
     sqlstm.offset = (unsigned int  )457;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&t_summ_process_flag;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )4;
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
                 err_mesg("UPDATE failed on table GL_TXN_DOC_HDR",0,"");

    } /* end of while fetch_doc_hdr1 */

    /* EXEC SQL CLOSE BATCH_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )476;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE DOC_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )491;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE DOC_HDR_CUR1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )506;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}


do_rev_fut_post()
{

#ifdef DEBUG
    printf("BEGINING REVERSE AND FUTURE POSTING\n");
    printf("Curr Month = %d  Curr Year = %d\n",d_curr_month,d_curr_year);
#endif

    t_summ_process_flag.arr[0] = '\0';
    t_summ_process_flag.len = 0;

    if(d_summ_flag EQ 'O') {
       t_summ_process_flag.arr[0] = 'Y';
       t_summ_process_flag.len = 1;
    }
 
    /* EXEC SQL DECLARE BATCH_HDR_FUTURE CURSOR FOR
	     SELECT  BATCH_NUM
	     FROM    GL_TXN_BATCH_HDR 
	     WHERE   POST_MONTH = :d_curr_month
	     AND     POST_YEAR  = :d_curr_year
	     AND     NVL(POSTED_FLAG,'N') = 'Y'
	     FOR     UPDATE OF BATCH_NUM; */ 


    /* EXEC SQL DECLARE DOC_HDR_FUTURE CURSOR FOR
	     SELECT  DOC_TYPE_CODE,
		     DOC_NUM
	     FROM    GL_TXN_DOC_HDR
	     WHERE   BATCH_NUM = :t_batch_num; */ 



    /* EXEC SQL DECLARE DOC_HDR_CUR2 CURSOR FOR
	     SELECT  DOC_TYPE_CODE,
		     DOC_NUM,
		     NVL(MODULE_ID,'XX')
	     FROM    GL_TXN_DOC_HDR
	     WHERE   BATCH_NUM  = 0
	     AND     POST_MONTH = :d_curr_month
	     AND     POST_YEAR  = :d_curr_year
	     AND     NVL(MODULE_ID,'XX')  =  'GL'
	     AND     NVL(POSTED_FLAG,'N') = 'Y'
	     FOR     UPDATE OF DOC_TYPE_CODE; */ 



    /* EXEC SQL DECLARE DOC_HDR_CUR3 CURSOR FOR
	     SELECT  DOC_TYPE_CODE,
		     DOC_NUM,
                     BATCH_NUM,
		     NVL(MODULE_ID,'XX')
	     FROM    GL_TXN_DOC_HDR
	     WHERE   POST_MONTH = :d_curr_month
	     AND     POST_YEAR  = :d_curr_year
	     AND     NVL(MODULE_ID,'XX')  !=  'GL'
	     AND     NVL(POSTED_FLAG,'N') = 'Y'
	     FOR     UPDATE OF DOC_TYPE_CODE; */ 


    /* EXEC SQL OPEN BATCH_HDR_FUTURE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0016;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )521;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_curr_month;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_curr_year;
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



    if(OERROR)
        err_mesg("OPEN failed on cursor BATCH_HDR_FUTURE",0,"");

    while(fetch_batch_hdr_fut()) {

	/* EXEC SQL OPEN DOC_HDR_FUTURE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0017;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )544;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&t_batch_num;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
	    err_mesg("OPEN failed on cursor DOC_HDR_FUTURE",0,"");

	while(fetch_doc_hdr_fut()) {

            if(post_doc(t_batch_num,t_doc_type_code.arr,
			t_doc_num,g_err_msg) EQ -1) 

       	        err_mesg(g_err_msg,0,"");

	} /* end of while fetch doc_hdr */

        /* EXEC SQL UPDATE GL_TXN_BATCH_HDR
	         SET    SUMMARY_PROCESSED_FLAG = :t_summ_process_flag 
	         WHERE CURRENT OF BATCH_HDR_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_TXN_BATCH_HDR  set SUMMARY_PROCESSED_FLAG=:\
b0 where rowid = :x";
        sqlstm.iters = (unsigned int  )11;
        sqlstm.offset = (unsigned int  )563;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&t_summ_process_flag;
        sqlstm.sqhstl[0] = (unsigned int  )4;
        sqlstm.sqhsts[0] = (         int  )4;
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



    } /* end of while fetch batch_hdr_future */


    /* EXEC SQL OPEN DOC_HDR_CUR2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0018;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )582;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_curr_month;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_curr_year;
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



    if(OERROR)
        err_mesg("OPEN failed on cursor DOC_HDR_CUR2",0,"");

    t_batch_num = 0;
   
    while(fetch_doc_hdr2()) {

        if(post_doc(t_batch_num,t_doc_type_code.arr,
		t_doc_num,g_err_msg) EQ -1) 

            err_mesg(g_err_msg,0,"");


            /* EXEC SQL UPDATE GL_TXN_DOC_HDR
	             SET    SUMMARY_PROCESSED_FLAG = :t_summ_process_flag 
	             WHERE CURRENT OF DOC_HDR_CUR2; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 17;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "update GL_TXN_DOC_HDR  set SUMMARY_PROCESSED_FLAG\
=:b0 where rowid = :x";
            sqlstm.iters = (unsigned int  )18;
            sqlstm.offset = (unsigned int  )605;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&t_summ_process_flag;
            sqlstm.sqhstl[0] = (unsigned int  )4;
            sqlstm.sqhsts[0] = (         int  )4;
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
                err_mesg("UPDATE failed on table GL_TXN_DOC_HDR",0,"");

    
    } /* end of while fetch doc_hdr2 */


    /* EXEC SQL OPEN DOC_HDR_CUR3; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0019;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )624;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_curr_month;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_curr_year;
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



    if(OERROR)
        err_mesg("OPEN failed on cursor DOC_HDR_CUR3",0,"");

    while(fetch_doc_hdr3()) {

        if(post_doc(t_batch_num,t_doc_type_code.arr,
		t_doc_num,g_err_msg) EQ -1) 

            err_mesg(g_err_msg,0,"");


            /* EXEC SQL UPDATE GL_TXN_DOC_HDR
	             SET    SUMMARY_PROCESSED_FLAG = :t_summ_process_flag 
	             WHERE CURRENT OF DOC_HDR_CUR3; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 17;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "update GL_TXN_DOC_HDR  set SUMMARY_PROCESSED_FLAG\
=:b0 where rowid = :x";
            sqlstm.iters = (unsigned int  )19;
            sqlstm.offset = (unsigned int  )647;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&t_summ_process_flag;
            sqlstm.sqhstl[0] = (unsigned int  )4;
            sqlstm.sqhsts[0] = (         int  )4;
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
                err_mesg("UPDATE failed on table GL_TXN_DOC_HDR",0,"");

    
    } /* end of while fetch doc_hdr3 */


    /* EXEC SQL CLOSE BATCH_HDR_FUTURE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )666;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE DOC_HDR_FUTURE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )681;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE DOC_HDR_CUR2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )696;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE DOC_HDR_CUR3; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )711;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}


fetch_batch_hdr()
{

    /* EXEC SQL FETCH BATCH_HDR_CUR 
	     INTO  :t_batch_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )726;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_batch_num;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
        err_mesg("FETCH failed on cursor BATCH_HDR_CUR",0,"");

    if(NO_DATA)
	return 0;
    else
	return 1;

}

fetch_doc()
{

    /* EXEC SQL FETCH DOC_HDR_CUR
	     INTO  :t_doc_type_code,
		   :t_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )745;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
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
        err_mesg("FETCH failed on cursor DOC_HDR_CUR",0,"");

    if(NO_DATA)
	return 0;

    t_doc_type_code.arr[t_doc_type_code.len] = '\0';

    return 1;
}


fetch_doc_hdr1()
{

    /* EXEC SQL FETCH DOC_HDR_CUR1
	     INTO  :t_doc_type_code,
		   :t_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )768;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
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
        err_mesg("FETCH failed on cursor DOC_HDR_CUR1",0,"");

    if(NO_DATA)
	return 0;

    t_doc_type_code.arr[t_doc_type_code.len] = '\0';

    return 1;
}


fetch_doc_hdr2()
{

    /* EXEC SQL FETCH DOC_HDR_CUR2
	     INTO  :t_doc_type_code,
		   :t_doc_num,
		   :t_module_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )791;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_module_id;
    sqlstm.sqhstl[2] = (unsigned int  )6;
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


	
    if(OERROR)
        err_mesg("FETCH failed on cursor DOC_HDR_CUR2",0,"");

    if(NO_DATA)
	return 0;

    t_doc_type_code.arr[t_doc_type_code.len] = '\0';
    t_module_id.arr[t_module_id.len]         = '\0';

    return 1;
}

fetch_doc_hdr3()
{
    t_batch_num=0;

    /* EXEC SQL FETCH DOC_HDR_CUR3
	     INTO  :t_doc_type_code,
		   :t_doc_num,
		   :t_batch_num,
		   :t_module_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )818;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_batch_num;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_module_id;
    sqlstm.sqhstl[3] = (unsigned int  )6;
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
        err_mesg("FETCH failed on cursor DOC_HDR_CUR3",0,"");

    if(NO_DATA)
	return 0;

    t_doc_type_code.arr[t_doc_type_code.len] = '\0';
    t_module_id.arr[t_module_id.len]         = '\0';

    return 1;
}


fetch_batch_hdr_fut()
{

    /* EXEC SQL FETCH BATCH_HDR_FUTURE 
	     INTO  :t_batch_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )849;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_batch_num;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
        err_mesg("FETCH failed on cursor BATCH_HDR_FUTURE",0,"");

    if(NO_DATA)
	return 0;
    else
	return 1;

}

fetch_doc_hdr_fut()
{

    /* EXEC SQL FETCH DOC_HDR_FUTURE
	     INTO  :t_doc_type_code,
		   :t_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )868;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
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
        err_mesg("FETCH failed on cursor DOC_HDR_FUTURE",0,"");

    if(NO_DATA)
	return 0;

    t_doc_type_code.arr[t_doc_type_code.len] = '\0';

    return 1;
}

