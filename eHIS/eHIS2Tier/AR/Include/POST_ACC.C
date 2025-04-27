
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
    "T:\\AR5.10\\POST_ACC.PC"
};


static unsigned long sqlctx = 159941315;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {10,18};

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
5,0,0,1,228,0,4,190,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
52,0,0,2,259,0,4,212,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,1,0,0,
103,0,0,3,156,0,4,249,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,1,9,0,0,
138,0,0,4,75,0,4,272,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
161,0,0,5,105,0,4,292,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
188,0,0,6,111,0,4,312,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
215,0,0,7,471,0,3,375,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,1,0,0,
302,0,0,8,263,0,4,432,0,0,9,8,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
353,0,0,9,115,0,4,462,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
380,0,0,10,369,0,3,487,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
};


/*
#define DEBUG 
*/ 
  
#define DUPLICATE (sqlca.sqlcode == -1)

/***********************************************************************/
/*               FUNCTION : process_posting_acc                        */ 
/***********************************************************************/
/*  This function is used to create monthly records in                 */ 
/*  GL_PERIOD_ACC_BAL_LOCAL. The input parameters for the function     */
/*  are :-                                                             */
/*                                                                     */ 
/*  1.  Posting Account                                                */ 
/*  2.  Flag ('Y') to indicate if it is a summary account.             */
/*  3.  No. of months in an accounting period.                         */
/*  4.  The year for which the records are to be created.              */ 
/*                                                                     */
/*  Processing Logic :-                                                */
/*  -------------------                                                */
/*  If the posting account is a normal posting account (non summary)   */
/*  then the monthly records are created directly in GL_PERIOD_ACC_    */
/*  BAL_LOCAL                                                          */
/*                                                                     */
/*  If posting account is a summary account then check is made to      */
/*  to see if it is existing in GL_POSTING_ACC. If it does not         */
/*  exist then a record is inserted in GL_POSTING_ACC. Then monthly    */
/*  records are created in GL_PERIOD_ACC_BAL_LOCAL after checking      */
/*  that no records exist for the posting account for the current      */
/*  year.                                                              */
/*                                                                     */
/***********************************************************************/

#include <math.h>
#include <string.h>
#include <stdio.h>

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

/* EXEC SQL BEGIN DECLARE SECTION; */ 

	/* VARCHAR		t_main_acc1_code[8],
			t_main_acc2_code[6],
			t_dept_code[11],
			t_product_group_code[4],
			t_product_line_code[6],
			t_subledger_group_code[4],
			t_subledger_line_code[10],
			t_summary_acc_flag[2],
			t_status[2],
			t_dummy[2],
			t_main_desc[16],
			nd_acc_entity[4],
			t_dept_desc[46],
			t_prod_desc[46],
			t_sleg_desc[46],
		        t_default_dept_code[11],
                        t_default_prod_group_code[4],
                        t_default_prod_line_code[6],
                        t_default_sleg_group_code[4],
                        t_default_sleg_line_code[10],
                        t_default_dept_desc[46],
                        t_default_prod_desc[46],
                        t_default_sleg_desc[46],
                        t_concat_main_code[12],
                        t_concat_prod_code[8],
                        t_concat_sleg_code[12],
                        t_concat_post_acc_code[42],
						t_concat_post_acc_desc[65]; */ 
struct { unsigned short len; unsigned char arr[8]; } t_main_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } t_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } t_dept_code;

struct { unsigned short len; unsigned char arr[4]; } t_product_group_code;

struct { unsigned short len; unsigned char arr[6]; } t_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } t_subledger_group_code;

struct { unsigned short len; unsigned char arr[10]; } t_subledger_line_code;

struct { unsigned short len; unsigned char arr[2]; } t_summary_acc_flag;

struct { unsigned short len; unsigned char arr[2]; } t_status;

struct { unsigned short len; unsigned char arr[2]; } t_dummy;

struct { unsigned short len; unsigned char arr[16]; } t_main_desc;

struct { unsigned short len; unsigned char arr[4]; } nd_acc_entity;

struct { unsigned short len; unsigned char arr[46]; } t_dept_desc;

struct { unsigned short len; unsigned char arr[46]; } t_prod_desc;

struct { unsigned short len; unsigned char arr[46]; } t_sleg_desc;

struct { unsigned short len; unsigned char arr[11]; } t_default_dept_code;

struct { unsigned short len; unsigned char arr[4]; } t_default_prod_group_code;

struct { unsigned short len; unsigned char arr[6]; } t_default_prod_line_code;

struct { unsigned short len; unsigned char arr[4]; } t_default_sleg_group_code;

struct { unsigned short len; unsigned char arr[10]; } t_default_sleg_line_code;

struct { unsigned short len; unsigned char arr[46]; } t_default_dept_desc;

struct { unsigned short len; unsigned char arr[46]; } t_default_prod_desc;

struct { unsigned short len; unsigned char arr[46]; } t_default_sleg_desc;

struct { unsigned short len; unsigned char arr[12]; } t_concat_main_code;

struct { unsigned short len; unsigned char arr[8]; } t_concat_prod_code;

struct { unsigned short len; unsigned char arr[12]; } t_concat_sleg_code;

struct { unsigned short len; unsigned char arr[42]; } t_concat_post_acc_code;

struct { unsigned short len; unsigned char arr[65]; } t_concat_post_acc_desc;


	int		t_month,
			t_year,
			t_cnt;

	char            t_default_delimiter,
			t_bank_recon_flag;

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

 
/* #include "winproc.h" */
                       
char string_var[100]; /* for disp_message() */                       
int g_num_of_acc_periods;

process_posting_acc  ( l_main_acc1_code,
		       l_main_acc2_code,
		       l_dept_code,
		       l_product_group_code,
		       l_product_line_code,
		       l_subledger_group_code,
		       l_subledger_line_code,
		       l_summary_acc_flag,
		       l_num_of_acc_periods,
		       l_year)

char l_main_acc1_code[],
     l_main_acc2_code[],
     l_dept_code[],
     l_product_group_code[],
     l_product_line_code[],
     l_subledger_group_code[],
     l_subledger_line_code[],
     l_summary_acc_flag;

int l_num_of_acc_periods,
    l_year;

{

    t_year = l_year;
    g_num_of_acc_periods = l_num_of_acc_periods;

    strcpy(t_main_acc1_code.arr,        l_main_acc1_code);
    strcpy(t_main_acc2_code.arr,        l_main_acc2_code);
    strcpy(t_dept_code.arr,             l_dept_code);
    strcpy(t_product_group_code.arr,    l_product_group_code);
    strcpy(t_product_line_code.arr,     l_product_line_code);
    strcpy(t_subledger_group_code.arr,  l_subledger_group_code);
    strcpy(t_subledger_line_code.arr,   l_subledger_line_code);

    t_main_acc1_code.len       = strlen(t_main_acc1_code.arr);
    t_main_acc2_code.len       = strlen(t_main_acc2_code.arr);
    t_dept_code.len            = strlen(t_dept_code.arr);
    t_product_group_code.len   = strlen(t_product_group_code.arr);
    t_product_line_code.len    = strlen(t_product_line_code.arr);
    t_subledger_group_code.len = strlen(t_subledger_group_code.arr);
    t_subledger_line_code.len  = strlen(t_subledger_line_code.arr);

#ifdef DEBUG
    sprintf(string_var,"Main_acc1_code        = %s\n",t_main_acc1_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Main_acc2_code        = %s\n",t_main_acc2_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Dept_code             = %s\n",t_dept_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Product_group_code    = %s\n",t_product_group_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Product_line_code     = %s\n",t_product_line_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Subledger group code  = %s\n",t_subledger_group_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Subledger line code   = %s\n",t_subledger_line_code.arr);
    disp_message(INFO_MESG,string_var);

    sprintf(string_var,"Main_acc1_code        = %d\n",t_main_acc1_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Main_acc2_code        = %d\n",t_main_acc2_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Dept_code             = %d\n",t_dept_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Product_group_code    = %d\n",t_product_group_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Product_line_code     = %d\n",t_product_line_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Subledger group code  = %d\n",t_subledger_group_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Subledger line code   = %d\n",t_subledger_line_code.len);
    disp_message(INFO_MESG,string_var);
#endif

    if(l_summary_acc_flag == 'Y')
	    chk_summary();
    else
        ins_period_bal();

}


chk_summary()
{

static int first = 1;

#ifdef DEBUG
    disp_message(INFO_MESG,"Checking if SUMMARY account exists in GL_POSTING_ACC\n");
#endif

    /* EXEC SQL SELECT 'X'
	     INTO   :t_dummy
	     FROM   GL_POSTING_ACC
    	     WHERE  MAIN_ACC1_CODE       = :t_main_acc1_code
    	     AND    MAIN_ACC2_CODE       = :t_main_acc2_code
    	     AND    DEPT_CODE            = :t_dept_code
    	     AND    PRODUCT_GROUP_CODE   = :t_product_group_code
    	     AND    PRODUCT_LINE_CODE    = :t_product_line_code
    	     AND    SUBLEDGER_GROUP_CODE = :t_subledger_group_code
    	     AND    SUBLEDGER_LINE_CODE  = :t_subledger_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select 'X' into :b0  from GL_POSTING_ACC where ((((((MAIN\
_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and PRODUCT_GROUP_CO\
DE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:b6) and SUBLEDGER\
_LINE_CODE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )8;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_product_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_product_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )8;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_subledger_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_subledger_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )12;
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



    if(sqlca.sqlcode < 0)  
        err_mesg("SELECT failed on table  GL_POSTING_ACC",0,"");

    if(sqlca.sqlcode == 1403) {

        if(first) {

#ifdef DEBUG
    disp_message(INFO_MESG,"Selecting Default descriptions ...\n");
#endif

            /* EXEC SQL SELECT DEFAULT_DEPT_CODE,
                            DEFAULT_PROD_GROUP_CODE,
                            DEFAULT_PROD_LINE_CODE,
                            DEFAULT_SLEG_GROUP_CODE,
                            DEFAULT_SLEG_LINE_CODE,
                            DEFAULT_DEPT_DESC,
                            DEFAULT_PROD_DESC,
                            DEFAULT_SLEG_DESC,
                            DEFAULT_DELIMITER
		     INTO   :t_default_dept_code,
                            :t_default_prod_group_code,
                            :t_default_prod_line_code,
                            :t_default_sleg_group_code,
                            :t_default_sleg_line_code,
                            :t_default_dept_desc,
                            :t_default_prod_desc,
                            :t_default_sleg_desc,
                            :t_default_delimiter
		     FROM   GL_PARAMETER; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 9;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "select DEFAULT_DEPT_CODE ,DEFAULT_PROD_GROUP_CODE\
 ,DEFAULT_PROD_LINE_CODE ,DEFAULT_SLEG_GROUP_CODE ,DEFAULT_SLEG_LINE_CODE ,DEF\
AULT_DEPT_DESC ,DEFAULT_PROD_DESC ,DEFAULT_SLEG_DESC ,DEFAULT_DELIMITER into :\
b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from GL_PARAMETER ";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )52;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&t_default_dept_code;
            sqlstm.sqhstl[0] = (unsigned int  )13;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&t_default_prod_group_code;
            sqlstm.sqhstl[1] = (unsigned int  )6;
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqhstv[2] = (         void  *)&t_default_prod_line_code;
            sqlstm.sqhstl[2] = (unsigned int  )8;
            sqlstm.sqhsts[2] = (         int  )0;
            sqlstm.sqindv[2] = (         void  *)0;
            sqlstm.sqinds[2] = (         int  )0;
            sqlstm.sqharm[2] = (unsigned int  )0;
            sqlstm.sqadto[2] = (unsigned short )0;
            sqlstm.sqtdso[2] = (unsigned short )0;
            sqlstm.sqhstv[3] = (         void  *)&t_default_sleg_group_code;
            sqlstm.sqhstl[3] = (unsigned int  )6;
            sqlstm.sqhsts[3] = (         int  )0;
            sqlstm.sqindv[3] = (         void  *)0;
            sqlstm.sqinds[3] = (         int  )0;
            sqlstm.sqharm[3] = (unsigned int  )0;
            sqlstm.sqadto[3] = (unsigned short )0;
            sqlstm.sqtdso[3] = (unsigned short )0;
            sqlstm.sqhstv[4] = (         void  *)&t_default_sleg_line_code;
            sqlstm.sqhstl[4] = (unsigned int  )12;
            sqlstm.sqhsts[4] = (         int  )0;
            sqlstm.sqindv[4] = (         void  *)0;
            sqlstm.sqinds[4] = (         int  )0;
            sqlstm.sqharm[4] = (unsigned int  )0;
            sqlstm.sqadto[4] = (unsigned short )0;
            sqlstm.sqtdso[4] = (unsigned short )0;
            sqlstm.sqhstv[5] = (         void  *)&t_default_dept_desc;
            sqlstm.sqhstl[5] = (unsigned int  )48;
            sqlstm.sqhsts[5] = (         int  )0;
            sqlstm.sqindv[5] = (         void  *)0;
            sqlstm.sqinds[5] = (         int  )0;
            sqlstm.sqharm[5] = (unsigned int  )0;
            sqlstm.sqadto[5] = (unsigned short )0;
            sqlstm.sqtdso[5] = (unsigned short )0;
            sqlstm.sqhstv[6] = (         void  *)&t_default_prod_desc;
            sqlstm.sqhstl[6] = (unsigned int  )48;
            sqlstm.sqhsts[6] = (         int  )0;
            sqlstm.sqindv[6] = (         void  *)0;
            sqlstm.sqinds[6] = (         int  )0;
            sqlstm.sqharm[6] = (unsigned int  )0;
            sqlstm.sqadto[6] = (unsigned short )0;
            sqlstm.sqtdso[6] = (unsigned short )0;
            sqlstm.sqhstv[7] = (         void  *)&t_default_sleg_desc;
            sqlstm.sqhstl[7] = (unsigned int  )48;
            sqlstm.sqhsts[7] = (         int  )0;
            sqlstm.sqindv[7] = (         void  *)0;
            sqlstm.sqinds[7] = (         int  )0;
            sqlstm.sqharm[7] = (unsigned int  )0;
            sqlstm.sqadto[7] = (unsigned short )0;
            sqlstm.sqtdso[7] = (unsigned short )0;
            sqlstm.sqhstv[8] = (         void  *)&t_default_delimiter;
            sqlstm.sqhstl[8] = (unsigned int  )1;
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


             
	    if(sqlca.sqlcode < 0)
	        err_mesg("SELECT failed on table GL_PARAMETER",0,"");
    

	    t_default_dept_code.arr[t_default_dept_code.len]             = '\0';
            t_default_prod_group_code.arr[t_default_prod_group_code.len] = '\0';
            t_default_prod_line_code.arr[t_default_prod_line_code.len]   = '\0';
            t_default_sleg_group_code.arr[t_default_sleg_group_code.len] = '\0';
            t_default_sleg_line_code.arr[t_default_sleg_line_code.len]   = '\0';
            t_default_dept_desc.arr[t_default_dept_desc.len]             = '\0';
            t_default_prod_desc.arr[t_default_prod_desc.len]             = '\0';
            t_default_sleg_desc.arr[t_default_sleg_desc.len]             = '\0';

	    first = 0;

	} /* end of if first */ 
    
        /* EXEC SQL SELECT ACC_ENTITY_CODE,
		                SHORT_DESC,
		                BANK_RECONCILE_FLAG
	         INTO   :nd_acc_entity,
			        :t_main_desc,
		            :t_bank_recon_flag
	         FROM   GL_ACC_CHART 
	         WHERE  MAIN_ACC1_CODE = :t_main_acc1_code
	         AND    MAIN_ACC2_CODE = :t_main_acc2_code
			 AND    ROWNUM =1; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 9;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select ACC_ENTITY_CODE ,SHORT_DESC ,BANK_RECONCILE_FL\
AG into :b0,:b1,:b2  from GL_ACC_CHART where ((MAIN_ACC1_CODE=:b3 and MAIN_ACC\
2_CODE=:b4) and ROWNUM=1)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )103;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity;
        sqlstm.sqhstl[0] = (unsigned int  )6;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&t_main_desc;
        sqlstm.sqhstl[1] = (unsigned int  )18;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&t_bank_recon_flag;
        sqlstm.sqhstl[2] = (unsigned int  )1;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&t_main_acc1_code;
        sqlstm.sqhstl[3] = (unsigned int  )10;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&t_main_acc2_code;
        sqlstm.sqhstl[4] = (unsigned int  )8;
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


    
        if(sqlca.sqlcode < 0)
	     err_mesg("SELECT failed on table GL_ACC_CHART",0,"");
    
	    nd_acc_entity.arr[nd_acc_entity.len] = '\0' ;
        t_main_desc.arr[t_main_desc.len] = '\0';

#ifdef DEBUG
    sprintf(string_var,"main_desc = <%s>    length = <%d>\n",t_main_desc.arr,t_main_desc.len);
    disp_message(INFO_MESG,string_var);
#endif
    
    
        /* EXEC SQL SELECT SHORT_DESC INTO :t_dept_desc
	         FROM   SY_DEPT
	         WHERE  DEPT_CODE = :t_dept_code 
			 AND ROWNUM=1; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 9;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select SHORT_DESC into :b0  from SY_DEPT where (DEPT_\
CODE=:b1 and ROWNUM=1)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )138;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&t_dept_desc;
        sqlstm.sqhstl[0] = (unsigned int  )48;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&t_dept_code;
        sqlstm.sqhstl[1] = (unsigned int  )13;
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
	     err_mesg("SELECT failed on table SY_DEPT",0,"");
    
        if(sqlca.sqlcode == 1403 || t_dept_desc.len == 0)  {
	    strcpy(t_dept_desc.arr,t_default_dept_desc.arr);
	    t_dept_desc.len = strlen(t_dept_desc.arr);
	}
        else
	    t_dept_desc.arr[t_dept_desc.len] = '\0';

#ifdef DEBUG
    sprintf(string_var,"dept_desc = <%s>    length = <%d>\n",t_dept_desc.arr,t_dept_desc.len);
    disp_message(INFO_MESG,string_var);
#endif
    
        /* EXEC SQL SELECT SHORT_DESC INTO :t_prod_desc
	         FROM   GL_PRODUCT_LINE
	         WHERE  PRODUCT_GROUP_CODE = :t_product_group_code
	         AND    PRODUCT_LINE_CODE  = :t_product_line_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 9;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select SHORT_DESC into :b0  from GL_PRODUCT_LINE wher\
e (PRODUCT_GROUP_CODE=:b1 and PRODUCT_LINE_CODE=:b2)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )161;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&t_prod_desc;
        sqlstm.sqhstl[0] = (unsigned int  )48;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&t_product_group_code;
        sqlstm.sqhstl[1] = (unsigned int  )6;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&t_product_line_code;
        sqlstm.sqhstl[2] = (unsigned int  )8;
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
	     err_mesg("SELECT failed on table GL_PRODUCT_LINE",0,"");
    
        if(sqlca.sqlcode == 1403 || t_prod_desc.len == 0) {
	    strcpy(t_prod_desc.arr,t_default_prod_desc.arr);
	    t_prod_desc.len = strlen(t_prod_desc.arr);
	}
        else
	    t_prod_desc.arr[t_prod_desc.len] = '\0';
    
#ifdef DEBUG
    sprintf("prod_desc = <%s>    length = <%d>\n",t_prod_desc.arr,t_prod_desc.len);
    disp_message(INFO_MESG,string_var);
#endif

        /* EXEC SQL SELECT SHORT_DESC INTO :t_sleg_desc
	         FROM   GL_SUBLEDGER_LINE
	         WHERE  SUBLEDGER_GROUP_CODE = :t_subledger_group_code
	         AND    SUBLEDGER_LINE_CODE  = :t_subledger_line_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 9;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select SHORT_DESC into :b0  from GL_SUBLEDGER_LINE wh\
ere (SUBLEDGER_GROUP_CODE=:b1 and SUBLEDGER_LINE_CODE=:b2)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )188;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&t_sleg_desc;
        sqlstm.sqhstl[0] = (unsigned int  )48;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&t_subledger_group_code;
        sqlstm.sqhstl[1] = (unsigned int  )6;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&t_subledger_line_code;
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


    
        if(sqlca.sqlcode < 0)
	     err_mesg("SELECT failed on table GL_SUBLEDGER_LINE",0,"");
    
        if(sqlca.sqlcode == 1403 || t_sleg_desc.len == 0) {
	    strcpy(t_sleg_desc.arr,t_default_sleg_desc.arr);
	    t_sleg_desc.len = strlen(t_sleg_desc.arr);
	}
        else
	    t_sleg_desc.arr[t_sleg_desc.len] = '\0';

#ifdef DEBUG
    sprintf("sleg_desc = <%s>    length = <%d>\n",t_sleg_desc.arr,t_sleg_desc.len);
    disp_message(INFO_MESG,string_var);
#endif
    
        sprintf(t_concat_main_code.arr,"%s%s",t_main_acc1_code.arr,t_main_acc2_code.arr);
	t_concat_main_code.len = strlen(t_concat_main_code.arr);
    
        sprintf(t_concat_prod_code.arr,"%s%s",t_product_group_code.arr,t_product_line_code.arr);

	t_concat_prod_code.len = strlen(t_concat_prod_code.arr);
    
        sprintf(t_concat_sleg_code.arr,"%s%s",t_subledger_group_code.arr,t_subledger_line_code.arr);

	t_concat_sleg_code.len = strlen(t_concat_sleg_code.arr);

        sprintf(t_concat_post_acc_code.arr, "%s-%s %s %s-%s %s-%s",
	       t_main_acc1_code.arr,t_main_acc2_code.arr, t_dept_code.arr,
	       t_product_group_code.arr,t_product_line_code.arr,
	       t_subledger_group_code.arr,t_subledger_line_code.arr);
    
	t_concat_post_acc_code.len = strlen(t_concat_post_acc_code.arr);

        sprintf(t_concat_post_acc_desc.arr,"%s%c%s%c%s%c%s",
	       t_main_desc.arr,t_default_delimiter,
	       t_dept_desc.arr,t_default_delimiter,
	       t_prod_desc.arr,t_default_delimiter,
	       t_sleg_desc.arr);

	t_concat_post_acc_desc.len=strlen(t_concat_post_acc_desc.arr);

#ifdef DEBUG
    sprintf(string_var,"concat main code = <%s>  length = <%d> \n",t_concat_main_code.arr,t_concat_main_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"concat prod code = <%s>  length = <%d> \n",t_concat_prod_code.arr,t_concat_prod_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"concat sleg code = <%s>  length = <%d> \n",t_concat_sleg_code.arr,t_concat_sleg_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"concat acct code = <%s>  length = <%d> \n",t_concat_post_acc_code.arr,t_concat_post_acc_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"concat acct desc = <%s> \n",t_concat_post_acc_desc.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Length           = <%d> \n",t_concat_post_acc_desc.len);
    disp_message(INFO_MESG,string_var);

    disp_message(INFO_MESG,"Creating record in GL_POSTING_ACC\n");
#endif
   
        /* EXEC SQL INSERT INTO GL_POSTING_ACC (
                             ACC_ENTITY_CODE,
                             MAIN_ACC1_CODE,
                             MAIN_ACC2_CODE,
                             DEPT_CODE,
                             PRODUCT_GROUP_CODE,
                             PRODUCT_LINE_CODE,
                             SUBLEDGER_GROUP_CODE,
                             SUBLEDGER_LINE_CODE,
                             CONCAT_MAIN_CODE,
                             CONCAT_PROD_CODE,
                             CONCAT_SLEG_CODE,
                             CONCAT_POST_ACC_CODE,
                             MAIN_DESC,
                             DEPT_DESC,
                             PROD_DESC,
                             SLEG_DESC,
                             CONCAT_POST_ACC_DESC,
                             SUMMARY_ACC_FLAG,
                             BANK_RECONCILE_FLAG,
                             STATUS,
							 ADDED_BY_ID,
							 ADDED_DATE )
    
	         VALUES   (  :nd_acc_entity,
    	                     :t_main_acc1_code,
    	                     :t_main_acc2_code,
    	                     :t_dept_code,
    	                     :t_product_group_code,
    	                     :t_product_line_code,
    	                     :t_subledger_group_code,
    	                     :t_subledger_line_code,
                             :t_concat_main_code,
                             :t_concat_prod_code ,
			     :t_concat_sleg_code,
                             :t_concat_post_acc_code,
                             :t_main_desc,
                             :t_dept_desc,
                             :t_prod_desc,
                             :t_sleg_desc,
                             :t_concat_post_acc_desc,
			     'Y',
                             :t_bank_recon_flag,
							 '',
							 USER,
							 SYSDATE

		           ); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 18;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into GL_POSTING_ACC (ACC_ENTITY_CODE,MAIN_ACC1\
_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLEDGER_\
GROUP_CODE,SUBLEDGER_LINE_CODE,CONCAT_MAIN_CODE,CONCAT_PROD_CODE,CONCAT_SLEG_C\
ODE,CONCAT_POST_ACC_CODE,MAIN_DESC,DEPT_DESC,PROD_DESC,SLEG_DESC,CONCAT_POST_A\
CC_DESC,SUMMARY_ACC_FLAG,BANK_RECONCILE_FLAG,STATUS,ADDED_BY_ID,ADDED_DATE) va\
lues (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b\
16,'Y',:b17,'',USER,SYSDATE)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )215;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity;
        sqlstm.sqhstl[0] = (unsigned int  )6;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&t_main_acc1_code;
        sqlstm.sqhstl[1] = (unsigned int  )10;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&t_main_acc2_code;
        sqlstm.sqhstl[2] = (unsigned int  )8;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&t_dept_code;
        sqlstm.sqhstl[3] = (unsigned int  )13;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&t_product_group_code;
        sqlstm.sqhstl[4] = (unsigned int  )6;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&t_product_line_code;
        sqlstm.sqhstl[5] = (unsigned int  )8;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&t_subledger_group_code;
        sqlstm.sqhstl[6] = (unsigned int  )6;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&t_subledger_line_code;
        sqlstm.sqhstl[7] = (unsigned int  )12;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&t_concat_main_code;
        sqlstm.sqhstl[8] = (unsigned int  )14;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&t_concat_prod_code;
        sqlstm.sqhstl[9] = (unsigned int  )10;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&t_concat_sleg_code;
        sqlstm.sqhstl[10] = (unsigned int  )14;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&t_concat_post_acc_code;
        sqlstm.sqhstl[11] = (unsigned int  )44;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&t_main_desc;
        sqlstm.sqhstl[12] = (unsigned int  )18;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&t_dept_desc;
        sqlstm.sqhstl[13] = (unsigned int  )48;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&t_prod_desc;
        sqlstm.sqhstl[14] = (unsigned int  )48;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&t_sleg_desc;
        sqlstm.sqhstl[15] = (unsigned int  )48;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&t_concat_post_acc_desc;
        sqlstm.sqhstl[16] = (unsigned int  )67;
        sqlstm.sqhsts[16] = (         int  )0;
        sqlstm.sqindv[16] = (         void  *)0;
        sqlstm.sqinds[16] = (         int  )0;
        sqlstm.sqharm[16] = (unsigned int  )0;
        sqlstm.sqadto[16] = (unsigned short )0;
        sqlstm.sqtdso[16] = (unsigned short )0;
        sqlstm.sqhstv[17] = (         void  *)&t_bank_recon_flag;
        sqlstm.sqhstl[17] = (unsigned int  )1;
        sqlstm.sqhsts[17] = (         int  )0;
        sqlstm.sqindv[17] = (         void  *)0;
        sqlstm.sqinds[17] = (         int  )0;
        sqlstm.sqharm[17] = (unsigned int  )0;
        sqlstm.sqadto[17] = (unsigned short )0;
        sqlstm.sqtdso[17] = (unsigned short )0;
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



    
        if(sqlca.sqlcode < 0 && !DUPLICATE)
	     err_mesg("INSERT failed on table GL_POSTING_ACC",0,"");

    } /* end of if posting_acc not exists */

    t_cnt = 0;

    /* EXEC SQL SELECT COUNT(*)
	     INTO   :t_cnt
	     FROM   GL_PERIOD_ACC_BAL_LOCAL
    	     WHERE  MAIN_ACC1_CODE       = :t_main_acc1_code
    	     AND    MAIN_ACC2_CODE       = :t_main_acc2_code
    	     AND    DEPT_CODE            = :t_dept_code
    	     AND    PRODUCT_GROUP_CODE   = :t_product_group_code
    	     AND    PRODUCT_LINE_CODE    = :t_product_line_code
    	     AND    SUBLEDGER_GROUP_CODE = :t_subledger_group_code
    	     AND    SUBLEDGER_LINE_CODE  = :t_subledger_line_code
	     AND    POST_YEAR            = :t_year; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from GL_PERIOD_ACC_BAL_LOCAL w\
here (((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and \
PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:b\
6) and SUBLEDGER_LINE_CODE=:b7) and POST_YEAR=:b8)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )302;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_cnt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )8;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_product_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_product_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )8;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_subledger_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_subledger_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )12;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&t_year;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
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



    if(sqlca.sqlcode < 0)
       err_mesg("SELECT failed on table GL_PERIOD_ACC_BAL_LOCAL",0,"");

#ifdef DEBUG
    sprintf(string_var,"t_cnt = %d\n",t_cnt);
    disp_message(INFO_MESG,string_var);
#endif

    if(!t_cnt)
	ins_period_bal();

}


ins_period_bal()
{


        /* EXEC SQL SELECT ACC_ENTITY_CODE
		          INTO   :nd_acc_entity
			 FROM   GL_ACC_CHART 
	         WHERE  MAIN_ACC1_CODE = :t_main_acc1_code
	         AND    MAIN_ACC2_CODE = :t_main_acc2_code
			 AND    ROWNUM = 1; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 18;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select ACC_ENTITY_CODE into :b0  from GL_ACC_CHART wh\
ere ((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and ROWNUM=1)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )353;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity;
        sqlstm.sqhstl[0] = (unsigned int  )6;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&t_main_acc1_code;
        sqlstm.sqhstl[1] = (unsigned int  )10;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&t_main_acc2_code;
        sqlstm.sqhstl[2] = (unsigned int  )8;
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
	     err_mesg("SELECT failed on table GL_ACC_CHART",0,"");


	 nd_acc_entity.arr[nd_acc_entity.len] = '\0';

	    
	
	
	for(t_month = 0; t_month <= g_num_of_acc_periods; t_month++) {

#ifdef DEBUG
    sprintf(string_var,"Creating a record in GL_PERIOD_ACC_BAL_LOCAL FOR MONTH %d\n",t_month);
    disp_message(INFO_MESG,string_var);
#endif



	/* EXEC SQL INSERT INTO GL_PERIOD_ACC_BAL_LOCAL (
	                 ACC_ENTITY_CODE,
	    	         MAIN_ACC1_CODE ,
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
		    	     YEAR_BAL_DR ,
					 MONTH_BAL_CR_FC,
				     MONTH_BAL_DR_FC,
					 YEAR_BAL_CR_FC ,
					 YEAR_BAL_DR_FC )
           	     VALUES (:nd_acc_entity,
				      :t_main_acc1_code,
		    	     :t_main_acc2_code,
		    	     :t_dept_code,
		    	     :t_product_group_code,
		    	     :t_product_line_code,
		    	     :t_subledger_group_code,
		    	     :t_subledger_line_code,
		    	     :t_month,
		    	     :t_year,
		    	     0,
		    	     0,
		    	     0,
		    	     0,
					 0,
					 0,
					 0,
					 0 ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into GL_PERIOD_ACC_BAL_LOCAL (ACC_ENTITY_CODE,MAIN_AC\
C1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLEDGE\
R_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_MONTH,POST_YEAR,MONTH_BAL_CR,MONTH_BAL_D\
R,YEAR_BAL_CR,YEAR_BAL_DR,MONTH_BAL_CR_FC,MONTH_BAL_DR_FC,YEAR_BAL_CR_FC,YEAR_\
BAL_DR_FC) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,0,0,0,0,0,0,0,0)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )380;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity;
 sqlstm.sqhstl[0] = (unsigned int  )6;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&t_main_acc1_code;
 sqlstm.sqhstl[1] = (unsigned int  )10;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&t_main_acc2_code;
 sqlstm.sqhstl[2] = (unsigned int  )8;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&t_dept_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&t_product_group_code;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&t_product_line_code;
 sqlstm.sqhstl[5] = (unsigned int  )8;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&t_subledger_group_code;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&t_subledger_line_code;
 sqlstm.sqhstl[7] = (unsigned int  )12;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&t_month;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&t_year;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
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



	    if(DUPLICATE)
		break;

	    if(sqlca.sqlcode < 0)
		err_mesg("INSERT failed on table GL_PERIOD_ACC_BAL_LOCAL",0,"");

    }

}
