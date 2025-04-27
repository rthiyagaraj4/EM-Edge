
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
           char  filnam[18];
};
static const struct sqlcxp sqlfpn =
{
    17,
    "T:\\AR5.10\\POST.PC"
};


static unsigned long sqlctx = 9996107;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {10,13};

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
5,0,0,1,305,0,4,173,0,0,10,7,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
60,0,0,2,397,0,4,215,0,0,13,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
127,0,0,3,227,0,4,337,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
174,0,0,4,52,0,4,365,0,0,1,0,0,1,0,2,3,0,0,
193,0,0,5,278,0,4,379,0,0,10,9,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
};


/*
#define DEBUG
*/
  
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
  

	/* VARCHAR	sub_main_acc1_code[8],
			sub_main_acc2_code[6],
			sub_dept_code[11],
			sub_product_group_code[4],
			sub_product_line_code[6],
			sub_subledger_group_code[4],
			sub_subledger_line_code[10],
			sub_summary_acc_flag[2],
			sub_bank_recon_flag[2],
			sub_status[2],
			sub_dummy[2],
			module_valid_id[3],
			ar_valid_flag[2],
			ap_valid_flag[2],
			gl_valid_flag[2],
			fa_valid_flag[2],
			bl_valid_flag[2],
			py_valid_flag[2],
			st_valid_flag[2],
			ss_valid_flag[2],
			foreign_currency_flag[2],
			foreign_currency_code[5]; */ 
struct { unsigned short len; unsigned char arr[8]; } sub_main_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } sub_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } sub_dept_code;

struct { unsigned short len; unsigned char arr[4]; } sub_product_group_code;

struct { unsigned short len; unsigned char arr[6]; } sub_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } sub_subledger_group_code;

struct { unsigned short len; unsigned char arr[10]; } sub_subledger_line_code;

struct { unsigned short len; unsigned char arr[2]; } sub_summary_acc_flag;

struct { unsigned short len; unsigned char arr[2]; } sub_bank_recon_flag;

struct { unsigned short len; unsigned char arr[2]; } sub_status;

struct { unsigned short len; unsigned char arr[2]; } sub_dummy;

struct { unsigned short len; unsigned char arr[3]; } module_valid_id;

struct { unsigned short len; unsigned char arr[2]; } ar_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } ap_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } gl_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } fa_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } bl_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } py_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } st_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } ss_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } foreign_currency_flag;

struct { unsigned short len; unsigned char arr[5]; } foreign_currency_code;

			
            
	int     sub_curr_year,sub_post_year,sub_post_month;

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

/***********************************************************************/
/*               FUNCTION : validate_posting_acc                       */ 
/***********************************************************************/
/*                                                                     */ 
/*  This function is used to validate the posting account as per       */
/*  the common logic. The inputs to the function are :                 */
/*                                                                     */ 
/*     - main account code 1                                           */ 
/*     - main account code 2                                           */ 
/*     - department code                                               */ 
/*     - product group code                                            */ 
/*     - product line code                                             */ 
/*     - subledger group code                                          */ 
/*     - subledger line code                                           */ 
/*     - check for bank reconciliation                                 */ 
/*     - error type  (used to return error type to the calling funct.) */ 
/*     - error id    (used to return error id to the calling function) */ 
/*     - error message (used to return error message to calling funct) */ 
/*                                                                     */ 
/***********************************************************************/

validate_posting_acct( l_main_acc1_code,
		       l_main_acc2_code,
		       l_dept_code,
		       l_product_group_code,
		       l_product_line_code,
		       l_subledger_group_code,
		       l_subledger_line_code,
		       l_bank_reconcile,
		       l_module_valid_id,
			   l_post_year,
			   l_post_month,
		       r_err_typ,
		       r_err_id,
		       r_err_msg
			   )

char l_main_acc1_code[],
     l_main_acc2_code[],
     l_dept_code[],
     l_product_group_code[],
     l_product_line_code[],
     l_subledger_group_code[],
     l_subledger_line_code[],
     l_bank_reconcile,
     l_module_valid_id[];

int *r_err_typ,
     l_post_year, 
	 l_post_month;

char *r_err_id,
     *r_err_msg;
 

{

    static int first = 1;

    *r_err_typ = 0;

    

    strcpy(sub_main_acc1_code.arr,        l_main_acc1_code);
    strcpy(sub_main_acc2_code.arr,        l_main_acc2_code);
    strcpy(sub_dept_code.arr,             l_dept_code);
    strcpy(sub_product_group_code.arr,    l_product_group_code);
    strcpy(sub_product_line_code.arr,     l_product_line_code);
    strcpy(sub_subledger_group_code.arr,  l_subledger_group_code);
    strcpy(sub_subledger_line_code.arr,   l_subledger_line_code);
    strcpy(module_valid_id.arr,   l_module_valid_id);
	sub_post_year = l_post_year;
	sub_post_month = l_post_month;

    sub_main_acc1_code.len       = strlen(sub_main_acc1_code.arr);
    sub_main_acc2_code.len       = strlen(sub_main_acc2_code.arr);
    sub_dept_code.len            = strlen(sub_dept_code.arr);
    sub_product_group_code.len   = strlen(sub_product_group_code.arr);
    sub_product_line_code.len    = strlen(sub_product_line_code.arr);
    sub_subledger_group_code.len = strlen(sub_subledger_group_code.arr);
    sub_subledger_line_code.len  = strlen(sub_subledger_line_code.arr);
    module_valid_id.len  = strlen(module_valid_id.arr);
  

#ifdef DEBUG
    sprintf(string_var,"Main_acc1_code        = %s\n",sub_main_acc1_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Main_acc2_code        = %s\n",sub_main_acc2_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Dept_code             = %s\n",sub_dept_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Product_group_code    = %s\n",sub_product_group_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Product_line_code     = %s\n",sub_product_line_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Subledger group code  = %s\n",sub_subledger_group_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Subledger line code   = %s\n",sub_subledger_line_code.arr);
    disp_message(INFO_MESG,string_var);

    sprintf(string_var,"Main_acc1_code        = %d\n",sub_main_acc1_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Main_acc2_code        = %d\n",sub_main_acc2_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Dept_code             = %d\n",sub_dept_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Product_group_code    = %d\n",sub_product_group_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Product_line_code     = %d\n",sub_product_line_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Subledger group code  = %d\n",sub_subledger_group_code.len);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"Subledger line code   = %d\n",sub_subledger_line_code.len);
    disp_message(INFO_MESG,string_var);
#endif

    /* EXEC SQL SELECT NVL(SUMMARY_ACC_FLAG,'N'),
                    NVL(BANK_RECONCILE_FLAG,'N'),
                    NVL(STATUS,'N')
	     INTO   :sub_summary_acc_flag,
		        :sub_bank_recon_flag,
		        :sub_status
	     FROM   GL_POSTING_ACC
	     WHERE  MAIN_ACC1_CODE       = :sub_main_acc1_code 
	     AND    MAIN_ACC2_CODE       = :sub_main_acc2_code 
	     AND    DEPT_CODE            = :sub_dept_code 
	     AND    PRODUCT_GROUP_CODE   = :sub_product_group_code 
	     AND    PRODUCT_LINE_CODE    = :sub_product_line_code 
	     AND    SUBLEDGER_GROUP_CODE = :sub_subledger_group_code
	     AND    SUBLEDGER_LINE_CODE  = :sub_subledger_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(SUMMARY_ACC_FLAG,'N') ,NVL(BANK_RECONCILE_FLAG\
,'N') ,NVL(STATUS,'N') into :b0,:b1,:b2  from GL_POSTING_ACC where ((((((MAIN_\
ACC1_CODE=:b3 and MAIN_ACC2_CODE=:b4) and DEPT_CODE=:b5) and PRODUCT_GROUP_COD\
E=:b6) and PRODUCT_LINE_CODE=:b7) and SUBLEDGER_GROUP_CODE=:b8) and SUBLEDGER_\
LINE_CODE=:b9)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_summary_acc_flag;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_bank_recon_flag;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_status;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_main_acc1_code;
    sqlstm.sqhstl[3] = (unsigned int  )10;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_main_acc2_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&sub_dept_code;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&sub_product_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&sub_product_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )8;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&sub_subledger_group_code;
    sqlstm.sqhstl[8] = (unsigned int  )6;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&sub_subledger_line_code;
    sqlstm.sqhstl[9] = (unsigned int  )12;
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



    if(sqlca.sqlcode < 0) {
	strcpy(r_err_msg,"SELECT failed on table  GL_POSTING_ACC");
	*r_err_typ = 0;
	return (-1);
    }

    if(sqlca.sqlcode == 1403) {
       strcpy(r_err_id,"GL1430");
       *r_err_typ = 1;
       return (-1);
    }

    if(sub_status.arr[0] == 'S') {
        strcpy(r_err_id,"GL1370");
        *r_err_typ = 1;
        return (-1);
    }

    /* Checking if this is a summary account */

    if(sub_summary_acc_flag.arr[0] == 'Y') {
	strcpy(r_err_id,"GL1540");
	*r_err_typ = 1;
	return (-1);
    }


	/* EXEC SQL SELECT NVL(AR_VALID_FLAG,'N'),
                      NVL(AP_VALID_FLAG,'N'),
                      NVL(GL_VALID_FLAG,'N'),
                      NVL(FA_VALID_FLAG,'N'),
                      NVL(BL_VALID_FLAG,'N'),
                      NVL(PY_VALID_FLAG,'N'),
                      NVL(ST_VALID_FLAG,'N'),
                      NVL(SS_VALID_FLAG,'N'),
                      NVL(FOREIGN_CURRENCY_ACCT_YN, 'N'),
                      NVL(CURRENCY_CODE , '#$@%'),
                      NVL(STATUS, 'N')                  
	     INTO         :ar_valid_flag,
                      :ap_valid_flag,
                      :gl_valid_flag,
                      :fa_valid_flag,
                      :bl_valid_flag,
                      :py_valid_flag,
                      :st_valid_flag,
                      :ss_valid_flag,
                      :foreign_currency_flag,
                      :foreign_currency_code,
                      :sub_status
	     FROM   GL_ACC_CHART
	     WHERE  MAIN_ACC1_CODE       = :sub_main_acc1_code 
	     AND    MAIN_ACC2_CODE       = :sub_main_acc2_code ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(AR_VALID_FLAG,'N') ,NVL(AP_VALID_FLAG,'N') ,NVL(G\
L_VALID_FLAG,'N') ,NVL(FA_VALID_FLAG,'N') ,NVL(BL_VALID_FLAG,'N') ,NVL(PY_VALI\
D_FLAG,'N') ,NVL(ST_VALID_FLAG,'N') ,NVL(SS_VALID_FLAG,'N') ,NVL(FOREIGN_CURRE\
NCY_ACCT_YN,'N') ,NVL(CURRENCY_CODE,'#$@%') ,NVL(STATUS,'N') into :b0,:b1,:b2,\
:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from GL_ACC_CHART where (MAIN_ACC1_CODE=:b11\
 and MAIN_ACC2_CODE=:b12)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )60;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ar_valid_flag;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ap_valid_flag;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&gl_valid_flag;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&fa_valid_flag;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_valid_flag;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&py_valid_flag;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&st_valid_flag;
 sqlstm.sqhstl[6] = (unsigned int  )4;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&ss_valid_flag;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&foreign_currency_flag;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&foreign_currency_code;
 sqlstm.sqhstl[9] = (unsigned int  )7;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&sub_status;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&sub_main_acc1_code;
 sqlstm.sqhstl[11] = (unsigned int  )10;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&sub_main_acc2_code;
 sqlstm.sqhstl[12] = (unsigned int  )8;
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



    if(sqlca.sqlcode < 0) {
	strcpy(r_err_msg,"SELECT failed on table  GL_ACC_CHART");
	*r_err_typ = 0;
	return (-1);
    }

    if(sqlca.sqlcode == 1403) {
       strcpy(r_err_id,"GL1430");
       *r_err_typ = 1;
       return (-1);
    }

    if(sub_status.arr[0] == 'S') {
        strcpy(r_err_id,"GL1370");
        *r_err_typ = 1;
        return (-1);
    }

 

    if   ((strcmp(module_valid_id.arr, "AR") == 0) && 
          (strcmp(ar_valid_flag.arr, "N") == 0)) 
     {
        strcpy(r_err_id,"GL6053");
        *r_err_typ = 1;
        return (-1);
     }

    if   ((strcmp(module_valid_id.arr, "AP") == 0) && 
          (strcmp(ap_valid_flag.arr , "N") == 0))
     {
        strcpy(r_err_id,"GL6053");
        *r_err_typ = 1;
        return (-1);
     }

    if  ((strcmp(module_valid_id.arr, "BL") == 0) && 
         (strcmp(bl_valid_flag.arr , "N") == 0))
     {
        strcpy(r_err_id,"GL6053");
        *r_err_typ = 1;
        return (-1);
     }

    if ((strcmp(module_valid_id.arr, "FA") == 0) && 
        (strcmp(fa_valid_flag.arr , "N") == 0))
     {
        strcpy(r_err_id,"GL6053");
        *r_err_typ = 1;
        return (-1);
     }

    if ((strcmp(module_valid_id.arr, "ST") == 0) && 
        (strcmp(st_valid_flag.arr , "N") == 0))
     {
        strcpy(r_err_id,"GL6053");
        *r_err_typ = 1;
        return (-1);
     }

    if ((strcmp(module_valid_id.arr, "PY") == 0) && 
        (strcmp(py_valid_flag.arr , "N") == 0))
     {
        strcpy(r_err_id,"GL6053");
        *r_err_typ = 1;
        return (-1);
     }

    if ((strcmp(module_valid_id.arr, "SS") == 0) && 
         (strcmp(ss_valid_flag.arr , "N") == 0))
     {
        strcpy(r_err_id,"GL6053");
        *r_err_typ = 1;
        return (-1);
     }  

/* 20/02/2003-------------------------------*/
  
   if (module_valid_id.arr[0] == '\0') 
   {
        strcpy(r_err_id,"SM1033");
        *r_err_typ = 1;
        return (-1);
   }
  
/* End 20/02/2003-------------------------------*/


    if( (l_bank_reconcile == 'Y') && (sub_bank_recon_flag.arr[0] == 'Y') ) 

	{

      #ifdef DEBUG
         disp_message(INFO_MESG,"Checking for bank reconcile...\n");
      #endif

	/* EXEC SQL SELECT 'X'
		 INTO   :sub_dummy
		 FROM   GL_BB_TXN_HDR
	         WHERE  MAIN_ACC1_CODE       = :sub_main_acc1_code 
	         AND    MAIN_ACC2_CODE       = :sub_main_acc2_code 
	         AND    DEPT_CODE            = :sub_dept_code 
	         AND    PRODUCT_GROUP_CODE   = :sub_product_group_code 
	         AND    PRODUCT_LINE_CODE    = :sub_product_line_code 
	         AND    SUBLEDGER_GROUP_CODE = :sub_subledger_group_code
	         AND    SUBLEDGER_LINE_CODE  = :sub_subledger_line_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select 'X' into :b0  from GL_BB_TXN_HDR where ((((((MAIN_ACC\
1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and PRODUCT_GROUP_CODE=:\
b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:b6) and SUBLEDGER_LIN\
E_CODE=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )127;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_dummy;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_main_acc1_code;
 sqlstm.sqhstl[1] = (unsigned int  )10;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&sub_main_acc2_code;
 sqlstm.sqhstl[2] = (unsigned int  )8;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&sub_dept_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&sub_product_group_code;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&sub_product_line_code;
 sqlstm.sqhstl[5] = (unsigned int  )8;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&sub_subledger_group_code;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&sub_subledger_line_code;
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



        if(sqlca.sqlcode < 0) {
            strcpy(r_err_msg,"SELECT failed on table  GL_BB_TXN_HDR");
            *r_err_typ = 0;
            return (-1);
	}

	if(sqlca.sqlcode == 1403) {
	    strcpy(r_err_id,"GL2310");
	    *r_err_typ = 1;
	    return (-1);
        }


    }

    if(first) {

	/* EXEC SQL SELECT CURRENT_ACC_YEAR
		 INTO   :sub_curr_year
		 FROM   GL_PARAMETER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CURRENT_ACC_YEAR into :b0  from GL_PARAMETER ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )174;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_curr_year;
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



	if(sqlca.sqlcode < 0)
	    err_mesg("SELECT failed on table GL_PARAMETER",0,"");

	first = 0;

    }   


    /* EXEC ORACLE OPTION (SELECT_ERROR=NO); */ 


    /* EXEC SQL SELECT 'X'
	 INTO   :sub_dummy
	 FROM   GL_PERIOD_ACC_BAL_LOCAL
                WHERE  MAIN_ACC1_CODE       = :sub_main_acc1_code 
                AND    MAIN_ACC2_CODE       = :sub_main_acc2_code 
                AND    DEPT_CODE            = :sub_dept_code 
                AND    PRODUCT_GROUP_CODE   = :sub_product_group_code 
                AND    PRODUCT_LINE_CODE    = :sub_product_line_code 
                AND    SUBLEDGER_GROUP_CODE = :sub_subledger_group_code
                AND    SUBLEDGER_LINE_CODE  = :sub_subledger_line_code
                AND    POST_YEAR            = :sub_post_year
				AND    POST_MONTH           = :sub_post_month; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select 'X' into :b0  from GL_PERIOD_ACC_BAL_LOCAL where (\
(((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_CODE=:b3) and PRODU\
CT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GROUP_CODE=:b6) an\
d SUBLEDGER_LINE_CODE=:b7) and POST_YEAR=:b8) and POST_MONTH=:b9)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )193;
    sqlstm.selerr = (unsigned short)0;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_main_acc1_code;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_main_acc2_code;
    sqlstm.sqhstl[2] = (unsigned int  )8;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_dept_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_product_group_code;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&sub_product_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )8;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&sub_subledger_group_code;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&sub_subledger_line_code;
    sqlstm.sqhstl[7] = (unsigned int  )12;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&sub_post_year;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&sub_post_month;
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



    if(sqlca.sqlcode < 0) {
        strcpy(r_err_msg,"SELECT failed on table GL_PERIOD_ACC_BAL_LOCAL");
        *r_err_typ = 0;
        return (-1);
    }

    if(sqlca.sqlcode == 1403) {
        strcpy(r_err_id,"GL2530");
        *r_err_typ = 1;
        return (-1);
    }

    /* EXEC ORACLE OPTION (SELECT_ERROR=YES); */ 


}
