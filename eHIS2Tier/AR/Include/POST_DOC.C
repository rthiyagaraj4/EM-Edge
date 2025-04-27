
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
    "T:\\AR5.10\\POST_DOC.PC"
};


static unsigned long sqlctx = 159941603;


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
            void  *sqhstv[25];
   unsigned int   sqhstl[25];
            int   sqhsts[25];
            void  *sqindv[25];
            int   sqinds[25];
   unsigned int   sqharm[25];
   unsigned int   *sqharc[25];
   unsigned short  sqadto[25];
   unsigned short  sqtdso[25];
} sqlstm = {10,25};

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

 static const char *sq0006 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUC\
T_LINE_CODE ,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,NARRATION ,LINE_NUM ,n\
vl(FOREIGN_AMT,0) ,LOCAL_AMT ,CURRENCY_CODE ,EXCHG_RATE ,CUST_SUPP_CODE  from \
GL_TXN_DOC_LINE where ((BATCH_NUM=:b0 and DOC_TYPE_CODE=:b1) and DOC_NUM=:b2) \
for update of MAIN_ACC1_CODE ";

 static const char *sq0015 = 
"select SUM_ACC1_CODE ,SUM_ACC2_CODE  from GL_ACC_SUM_LINE where (MAIN_ACC1_C\
ODE=:b0 and MAIN_ACC2_CODE=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,75,0,4,125,0,0,2,0,0,1,0,2,3,0,0,2,3,0,0,
28,0,0,2,0,0,31,133,0,0,0,0,0,1,0,
43,0,0,3,0,0,30,136,0,0,0,0,0,1,0,
58,0,0,4,261,0,4,155,0,0,12,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,3,0,0,1,9,0,0,1,3,0,0,
121,0,0,5,310,0,3,195,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,
9,0,0,1,3,0,0,1,3,0,0,
168,0,0,6,339,0,9,264,0,0,3,3,0,1,0,1,3,0,0,1,9,0,0,1,3,0,0,
195,0,0,7,544,0,5,271,0,0,17,17,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,
1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,3,0,0,1,3,0,0,
278,0,0,8,537,0,5,293,0,0,17,17,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,
1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,3,0,0,1,3,0,0,
361,0,0,9,539,0,3,316,0,0,25,25,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,9,0,
0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,
0,0,
476,0,0,10,253,0,4,380,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
523,0,0,11,118,0,4,399,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
550,0,0,12,359,0,3,421,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,3,0,
0,
625,0,0,6,0,0,15,484,0,0,0,0,0,1,0,
640,0,0,13,48,0,5,488,0,0,0,0,0,1,0,
655,0,0,14,166,0,5,498,0,0,4,4,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,3,0,0,
686,0,0,15,118,0,9,537,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
709,0,0,16,544,0,5,553,0,0,17,17,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,
1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,3,0,0,1,3,0,0,
792,0,0,17,537,0,5,575,0,0,17,17,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,
1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,3,0,0,1,3,0,0,
875,0,0,6,0,0,13,608,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
946,0,0,15,0,0,13,647,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
};


/*****************************************************************************/
/*                           POST_DOC.PC                                     */
/*****************************************************************************/
      
/*
#define DEBUG
*/

#include <stdio.h>
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
/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR	sub_doc_type_code     [8],
	        sub_main_acc1_code    [8],
		sub_main_acc2_code        [6],
	        sub_sum_acc1_code     [8],
		sub_sum_acc2_code         [6],
	        sub_acc1_code         [8],
		sub_acc2_code             [6],
		sub_dept_code             [11],
		sub_product_group_code    [4],
		sub_product_line_code     [6],
		sub_subledger_group_code  [4],
		sub_subledger_line_code   [10],
		sub_acc_entity_code       [6],
		sub_doc_date              [14],
		sub_doc_ref               [12],
		sub_narration_hdr         [52],
		sub_narration             [52],
		sub_doc_nature            [4],
		sub_module_id             [4],
		sub_txn_type_desc         [6],
		sub_summ_flag             [2],
		sub_bank_recon_flag       [2],

		sub_foreign_curr_flag     [2],
        sub_cust_supp_code        [9],
		sub_currency_code         [7],

		sub_dummy                 [2]; */ 
struct { unsigned short len; unsigned char arr[8]; } sub_doc_type_code;

struct { unsigned short len; unsigned char arr[8]; } sub_main_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } sub_main_acc2_code;

struct { unsigned short len; unsigned char arr[8]; } sub_sum_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } sub_sum_acc2_code;

struct { unsigned short len; unsigned char arr[8]; } sub_acc1_code;

struct { unsigned short len; unsigned char arr[6]; } sub_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } sub_dept_code;

struct { unsigned short len; unsigned char arr[4]; } sub_product_group_code;

struct { unsigned short len; unsigned char arr[6]; } sub_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } sub_subledger_group_code;

struct { unsigned short len; unsigned char arr[10]; } sub_subledger_line_code;

struct { unsigned short len; unsigned char arr[6]; } sub_acc_entity_code;

struct { unsigned short len; unsigned char arr[14]; } sub_doc_date;

struct { unsigned short len; unsigned char arr[12]; } sub_doc_ref;

struct { unsigned short len; unsigned char arr[52]; } sub_narration_hdr;

struct { unsigned short len; unsigned char arr[52]; } sub_narration;

struct { unsigned short len; unsigned char arr[4]; } sub_doc_nature;

struct { unsigned short len; unsigned char arr[4]; } sub_module_id;

struct { unsigned short len; unsigned char arr[6]; } sub_txn_type_desc;

struct { unsigned short len; unsigned char arr[2]; } sub_summ_flag;

struct { unsigned short len; unsigned char arr[2]; } sub_bank_recon_flag;

struct { unsigned short len; unsigned char arr[2]; } sub_foreign_curr_flag;

struct { unsigned short len; unsigned char arr[9]; } sub_cust_supp_code;

struct { unsigned short len; unsigned char arr[7]; } sub_currency_code;

struct { unsigned short len; unsigned char arr[2]; } sub_dummy;


    long      	sub_batch_num,
		sub_doc_num;

    int         sub_post_month,
		sub_post_year,
		sub_curr_month,
		sub_curr_year,
		sub_line_num,
    	sub_month;

/*---- Added by Venkat on 22/12/1999 ----*/
		int  d_curr_year1;
		int  d_curr_month1;
/*---------------------------------------*/
	
    double      sub_local_amt, sub_exchg_rate,
		sub_foreign_amt;         
	char string_var[100]; /* for disp_message */	

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




/*#include "winproc.h" */

/*************************************************/
/*  The following extern variables must be       */
/*  available in the calling program             */
/*************************************************/

    extern int  d_curr_year;
    extern int  d_curr_month;
    extern int  d_num_of_acc_periods;
    extern char d_summ_flag;
/*************************************************/

int post_doc(l_batch_num,l_doc_type_code,l_doc_num,r_err_msg)

char *l_doc_type_code,
     *r_err_msg;


long l_batch_num,
     l_doc_num;

/* function returns values 0 - Success  or  -1 - Failure */

{

    static int l_decl_cur = 1;

    strcpy(sub_doc_type_code.arr,l_doc_type_code);
    sub_doc_type_code.len = strlen(sub_doc_type_code.arr);

    sub_batch_num = l_batch_num;
    sub_doc_num   = l_doc_num;

#ifdef DEBUG
    disp_message(INFO_MESG,"POSTING DOCUMENT...\n");
    sprintf(string_var,"doc_type_code = %s\n",sub_doc_type_code.arr);
    disp_message(INFO_MESG,string_var);
    sprintf(string_var,"doc_num       = %ld\n\n",sub_doc_num);
    disp_message(INFO_MESG,string_var);
#endif


/*--- Added by Venkat on 22/12/1999 for selecting the -----
----- latest Acc.Month/Year from GL Parameter ------------*/
 
    
   /* EXEC SQL SELECT CURRENT_ACC_YEAR,CURRENT_ACC_MONTH
                     INTO d_curr_year1, d_curr_month1
                     FROM GL_PARAMETER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 2;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CURRENT_ACC_YEAR ,CURRENT_ACC_MONTH into :b0,:b1  f\
rom GL_PARAMETER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_year1;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_curr_month1;
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




if((d_curr_year1 != d_curr_year) || (d_curr_month1 != d_curr_month)) 
{
    disp_message(ERR_MESG,"GL Month/Year end Process in Progress,Please exit!");
	/* EXEC SQL ROLLBACK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )28;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  
   end_prog_control();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 2;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )43;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	proc_exit();
} 

 if(sqlca.sqlcode < 0) {
	strcpy(r_err_msg,"SELECT failed on table GL_PARAMETER");
	return (-1);
    }


/*---------------------------------------------------------*/


    sub_curr_year = d_curr_year;
    sub_curr_month = d_curr_month;

  

    /* EXEC SQL SELECT ACC_ENTITY_CODE,
		    to_char(DOC_DATE,'DD/MM/YYYY'),
		    DOC_REF,
		    POST_MONTH,
		    POST_YEAR,
		    DOC_NATURE,
		    MODULE_ID,
		    TXN_TYPE_DESC,
		    NARRATION
	     INTO   
		    :sub_acc_entity_code,
		    :sub_doc_date,
		    :sub_doc_ref,
		    :sub_post_month,
		    :sub_post_year,
		    :sub_doc_nature,
		    :sub_module_id,
		    :sub_txn_type_desc,
		    :sub_narration_hdr
	     FROM   GL_TXN_DOC_HDR
	     WHERE  BATCH_NUM     = :sub_batch_num
	     AND    DOC_TYPE_CODE = :sub_doc_type_code
	     AND    DOC_NUM       = :sub_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_CODE ,to_char(DOC_DATE,'DD/MM/YYYY') ,D\
OC_REF ,POST_MONTH ,POST_YEAR ,DOC_NATURE ,MODULE_ID ,TXN_TYPE_DESC ,NARRATION\
 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from GL_TXN_DOC_HDR where ((BATCH_N\
UM=:b9 and DOC_TYPE_CODE=:b10) and DOC_NUM=:b11)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )58;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_acc_entity_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_doc_date;
    sqlstm.sqhstl[1] = (unsigned int  )16;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_doc_ref;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_post_month;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_post_year;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&sub_doc_nature;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&sub_module_id;
    sqlstm.sqhstl[6] = (unsigned int  )6;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&sub_txn_type_desc;
    sqlstm.sqhstl[7] = (unsigned int  )8;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&sub_narration_hdr;
    sqlstm.sqhstl[8] = (unsigned int  )54;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&sub_batch_num;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&sub_doc_type_code;
    sqlstm.sqhstl[10] = (unsigned int  )10;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&sub_doc_num;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
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
	strcpy(r_err_msg,"SELECT failed on table GL_TXN_DOC_HDR");
	return (-1);
    }

    sub_module_id.arr[sub_module_id.len] = '\0';


    if(!strcmp(sub_module_id.arr,"GL")) {



#ifdef DEBUG
    disp_message(INFO_MESG,"Inserting into SY_DOC_CONTROL...\n");
#endif

        /* EXEC SQL INSERT INTO SY_DOC_CONTROL (
			     ACC_ENTITY_CODE,
                             MODULE_ID,
                             DOC_TYPE_CODE,
                             DOC_NUM,
                             DOC_DATE,
                             POSTED_DATE,
                             DOC_STATUS,
                             NARRATION,
                             POST_MONTH,
                             POST_YEAR,
                             CANCELLED_DATE ,
                             ADDED_BY_ID,
                             MODIFIED_BY_ID ,
                             ADDED_DATE,
                             MODIFIED_DATE	)
	         VALUES   (  :sub_acc_entity_code,
                             :sub_module_id,
                             :sub_doc_type_code,
                             :sub_doc_num,
                             to_date(:sub_doc_date,'DD/MM/YYYY'),
                             SYSDATE,
                             'P',
                             :sub_narration_hdr,
                             :sub_post_month,
                             :sub_post_year,
                             '',
                             USER,
                             USER,
                             SYSDATE,
                             SYSDATE ); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 12;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into SY_DOC_CONTROL (ACC_ENTITY_CODE,MODULE_ID\
,DOC_TYPE_CODE,DOC_NUM,DOC_DATE,POSTED_DATE,DOC_STATUS,NARRATION,POST_MONTH,PO\
ST_YEAR,CANCELLED_DATE,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE) va\
lues (:b0,:b1,:b2,:b3,to_date(:b4,'DD/MM/YYYY'),SYSDATE,'P',:b5,:b6,:b7,'',USE\
R,USER,SYSDATE,SYSDATE)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )121;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&sub_acc_entity_code;
        sqlstm.sqhstl[0] = (unsigned int  )8;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&sub_module_id;
        sqlstm.sqhstl[1] = (unsigned int  )6;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&sub_doc_type_code;
        sqlstm.sqhstl[2] = (unsigned int  )10;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&sub_doc_num;
        sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&sub_doc_date;
        sqlstm.sqhstl[4] = (unsigned int  )16;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&sub_narration_hdr;
        sqlstm.sqhstl[5] = (unsigned int  )54;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&sub_post_month;
        sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&sub_post_year;
        sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
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
	    strcpy(r_err_msg,"INSERT failed on table SY_DOC_CONTROL");
	    return (-1);
        }

    } /* end of if module_id = GL */


/*   if( (sub_post_year == sub_curr_year) &&
       (sub_post_month <= sub_curr_month))    
{*/ /* This is if loop is commented for HMC Customization*/


        if(l_decl_cur) {
    
            /* EXEC SQL DECLARE GL_TXN_LINE_CUR CURSOR FOR
	             SELECT  MAIN_ACC1_CODE,
	                     MAIN_ACC2_CODE,
	                     DEPT_CODE,
	                     PRODUCT_GROUP_CODE,
	                     PRODUCT_LINE_CODE ,
	                     SUBLEDGER_GROUP_CODE ,
	                     SUBLEDGER_LINE_CODE,
		                 NARRATION,
		                 LINE_NUM,
		                 nvl(FOREIGN_AMT,0),
		                 LOCAL_AMT,
					     CURRENCY_CODE,
					     EXCHG_RATE ,
					     CUST_SUPP_CODE
	             FROM    GL_TXN_DOC_LINE
	             WHERE   BATCH_NUM     = :sub_batch_num
		     AND     DOC_TYPE_CODE = :sub_doc_type_code
	             AND     DOC_NUM       = :sub_doc_num
	             FOR UPDATE OF MAIN_ACC1_CODE; */ 

        }
    
        /* EXEC SQL OPEN GL_TXN_LINE_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 12;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0006;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )168;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&sub_batch_num;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&sub_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )10;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&sub_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
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


      
        
		
		while(fetch_txn_line()) {
               

	    /* EXEC SQL UPDATE GL_PERIOD_ACC_BAL_LOCAL
	             SET    YEAR_BAL_DR          =  NVL(YEAR_BAL_DR,0)  + DECODE(SIGN(:sub_local_amt),1,:sub_local_amt,0),
		                YEAR_BAL_CR          =   NVL(YEAR_BAL_CR,0) + DECODE(SIGN(:sub_local_amt),1,0,ABS(:sub_local_amt)),
                        YEAR_BAL_DR_FC       =  NVL(YEAR_BAL_DR_FC,0)  + DECODE(SIGN(:sub_foreign_amt),1,:sub_foreign_amt,0),
		                YEAR_BAL_CR_FC       =   NVL(YEAR_BAL_CR_FC,0) + DECODE(SIGN(:sub_foreign_amt),1,0,ABS(:sub_foreign_amt))
	             WHERE  MAIN_ACC1_CODE       =  :sub_main_acc1_code
	             AND    MAIN_ACC2_CODE       =  :sub_main_acc2_code
	             AND    DEPT_CODE            =  :sub_dept_code
	             AND    PRODUCT_GROUP_CODE   =  :sub_product_group_code
	             AND    PRODUCT_LINE_CODE    =  :sub_product_line_code
	             AND    SUBLEDGER_GROUP_CODE =  :sub_subledger_group_code
	             AND    SUBLEDGER_LINE_CODE  =  :sub_subledger_line_code
	             AND    POST_YEAR            =  :sub_post_year
	             AND    POST_MONTH  BETWEEN :sub_post_month AND 12; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update GL_PERIOD_ACC_BAL_LOCAL  set YEAR_BAL_DR=(NVL(YEA\
R_BAL_DR,0)+DECODE(SIGN(:b0),1,:b0,0)),YEAR_BAL_CR=(NVL(YEAR_BAL_CR,0)+DECODE(\
SIGN(:b0),1,0,ABS(:b0))),YEAR_BAL_DR_FC=(NVL(YEAR_BAL_DR_FC,0)+DECODE(SIGN(:b4\
),1,:b4,0)),YEAR_BAL_CR_FC=(NVL(YEAR_BAL_CR_FC,0)+DECODE(SIGN(:b4),1,0,ABS(:b4\
))) where ((((((((MAIN_ACC1_CODE=:b8 and MAIN_ACC2_CODE=:b9) and DEPT_CODE=:b1\
0) and PRODUCT_GROUP_CODE=:b11) and PRODUCT_LINE_CODE=:b12) and SUBLEDGER_GROU\
P_CODE=:b13) and SUBLEDGER_LINE_CODE=:b14) and POST_YEAR=:b15) and POST_MONTH \
between :b16 and 12)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )195;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&sub_local_amt;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&sub_local_amt;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&sub_local_amt;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&sub_local_amt;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&sub_foreign_amt;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&sub_foreign_amt;
     sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&sub_foreign_amt;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&sub_foreign_amt;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&sub_main_acc1_code;
     sqlstm.sqhstl[8] = (unsigned int  )10;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&sub_main_acc2_code;
     sqlstm.sqhstl[9] = (unsigned int  )8;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&sub_dept_code;
     sqlstm.sqhstl[10] = (unsigned int  )13;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&sub_product_group_code;
     sqlstm.sqhstl[11] = (unsigned int  )6;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&sub_product_line_code;
     sqlstm.sqhstl[12] = (unsigned int  )8;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&sub_subledger_group_code;
     sqlstm.sqhstl[13] = (unsigned int  )6;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&sub_subledger_line_code;
     sqlstm.sqhstl[14] = (unsigned int  )12;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&sub_post_year;
     sqlstm.sqhstl[15] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&sub_post_month;
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



            if(sqlca.sqlcode < 0) {
                strcpy(r_err_msg,"UPDATE failed on table GL_PERIOD_ACC_BAL_LOCAL");
	        return (-1);
            }

	    if(sub_post_month > 0) {

	        /* EXEC SQL UPDATE GL_PERIOD_ACC_BAL_LOCAL
	                 SET    MONTH_BAL_DR         =  NVL(MONTH_BAL_DR,0) + DECODE(SIGN(:sub_local_amt),1,:sub_local_amt,0),
	                        MONTH_BAL_CR         =  NVL(MONTH_BAL_CR,0) + DECODE(SIGN(:sub_local_amt),1,0,ABS(:sub_local_amt)),
                            MONTH_BAL_DR_FC      =  NVL(MONTH_BAL_DR_FC,0)  + DECODE(SIGN(:sub_foreign_amt),1,:sub_foreign_amt,0),
   	                        MONTH_BAL_CR_FC      =  NVL(MONTH_BAL_CR_FC,0) + DECODE(SIGN(:sub_foreign_amt),1,0,ABS(:sub_foreign_amt))
	                 WHERE MAIN_ACC1_CODE        =  :sub_main_acc1_code
	                 AND    MAIN_ACC2_CODE       =  :sub_main_acc2_code
	                 AND    DEPT_CODE            =  :sub_dept_code
	                 AND    PRODUCT_GROUP_CODE   =  :sub_product_group_code
	                 AND    PRODUCT_LINE_CODE    =  :sub_product_line_code
	                 AND    SUBLEDGER_GROUP_CODE =  :sub_subledger_group_code
	                 AND    SUBLEDGER_LINE_CODE  =  :sub_subledger_line_code
	                 AND    POST_YEAR            =  :sub_post_year
	                 AND    POST_MONTH           =  :sub_post_month; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 17;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "update GL_PERIOD_ACC_BAL_LOCAL  set MONTH_BAL_DR=(NV\
L(MONTH_BAL_DR,0)+DECODE(SIGN(:b0),1,:b0,0)),MONTH_BAL_CR=(NVL(MONTH_BAL_CR,0)\
+DECODE(SIGN(:b0),1,0,ABS(:b0))),MONTH_BAL_DR_FC=(NVL(MONTH_BAL_DR_FC,0)+DECOD\
E(SIGN(:b4),1,:b4,0)),MONTH_BAL_CR_FC=(NVL(MONTH_BAL_CR_FC,0)+DECODE(SIGN(:b4)\
,1,0,ABS(:b4))) where ((((((((MAIN_ACC1_CODE=:b8 and MAIN_ACC2_CODE=:b9) and D\
EPT_CODE=:b10) and PRODUCT_GROUP_CODE=:b11) and PRODUCT_LINE_CODE=:b12) and SU\
BLEDGER_GROUP_CODE=:b13) and SUBLEDGER_LINE_CODE=:b14) and POST_YEAR=:b15) and\
 POST_MONTH=:b16)";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )278;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&sub_local_amt;
         sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&sub_local_amt;
         sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&sub_local_amt;
         sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&sub_local_amt;
         sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&sub_foreign_amt;
         sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&sub_foreign_amt;
         sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&sub_foreign_amt;
         sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&sub_foreign_amt;
         sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&sub_main_acc1_code;
         sqlstm.sqhstl[8] = (unsigned int  )10;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&sub_main_acc2_code;
         sqlstm.sqhstl[9] = (unsigned int  )8;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&sub_dept_code;
         sqlstm.sqhstl[10] = (unsigned int  )13;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&sub_product_group_code;
         sqlstm.sqhstl[11] = (unsigned int  )6;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&sub_product_line_code;
         sqlstm.sqhstl[12] = (unsigned int  )8;
         sqlstm.sqhsts[12] = (         int  )0;
         sqlstm.sqindv[12] = (         void  *)0;
         sqlstm.sqinds[12] = (         int  )0;
         sqlstm.sqharm[12] = (unsigned int  )0;
         sqlstm.sqadto[12] = (unsigned short )0;
         sqlstm.sqtdso[12] = (unsigned short )0;
         sqlstm.sqhstv[13] = (         void  *)&sub_subledger_group_code;
         sqlstm.sqhstl[13] = (unsigned int  )6;
         sqlstm.sqhsts[13] = (         int  )0;
         sqlstm.sqindv[13] = (         void  *)0;
         sqlstm.sqinds[13] = (         int  )0;
         sqlstm.sqharm[13] = (unsigned int  )0;
         sqlstm.sqadto[13] = (unsigned short )0;
         sqlstm.sqtdso[13] = (unsigned short )0;
         sqlstm.sqhstv[14] = (         void  *)&sub_subledger_line_code;
         sqlstm.sqhstl[14] = (unsigned int  )12;
         sqlstm.sqhsts[14] = (         int  )0;
         sqlstm.sqindv[14] = (         void  *)0;
         sqlstm.sqinds[14] = (         int  )0;
         sqlstm.sqharm[14] = (unsigned int  )0;
         sqlstm.sqadto[14] = (unsigned short )0;
         sqlstm.sqtdso[14] = (unsigned short )0;
         sqlstm.sqhstv[15] = (         void  *)&sub_post_year;
         sqlstm.sqhstl[15] = (unsigned int  )sizeof(int);
         sqlstm.sqhsts[15] = (         int  )0;
         sqlstm.sqindv[15] = (         void  *)0;
         sqlstm.sqinds[15] = (         int  )0;
         sqlstm.sqharm[15] = (unsigned int  )0;
         sqlstm.sqadto[15] = (unsigned short )0;
         sqlstm.sqtdso[15] = (unsigned short )0;
         sqlstm.sqhstv[16] = (         void  *)&sub_post_month;
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


    
                if(sqlca.sqlcode < 0) {
                    strcpy(r_err_msg,"UPDATE failed on table GL_PERIOD_ACC_BAL_LOCAL");
                    return (-1);
                }

	    } /* end of if sub_post_month > 0 */

	    
		/* EXEC SQL INSERT INTO GL_POSTED_TXN_CURRENT  (
                                 ACC_ENTITY_CODE,
                                 BATCH_NUM,
                                 DOC_TYPE_CODE,
                                 DOC_NUM,
                                 LINE_NUM,
                                 MAIN_ACC1_CODE,
                                 MAIN_ACC2_CODE,
                                 SUBLEDGER_GROUP_CODE,
                                 SUBLEDGER_LINE_CODE,
                                 DEPT_CODE,
                                 PRODUCT_GROUP_CODE,
                                 PRODUCT_LINE_CODE,
                                 POST_YEAR,
                                 POST_MONTH,
                                 DOC_NATURE,
                                 LOCAL_AMT,
                                 FOREIGN_AMT,
                                 DOC_DATE,
                                 DOC_REF,
                                 NARRATION,
                                 POSTED_BY_ID,
                                 POSTED_DATE,
                                 MODULE_ID,
                                 TXN_TYPE_DESC,
                                 CUST_SUPP_CODE,
								 CURRENCY_CODE , 
								 EXCHG_RATE      ) 
	            VALUES     ( :sub_acc_entity_code,	
                                 :sub_batch_num,
                                 :sub_doc_type_code,
                                 :sub_doc_num,
                                 :sub_line_num ,
                                 :sub_main_acc1_code,
                                 :sub_main_acc2_code,
                                 :sub_subledger_group_code,
                                 :sub_subledger_line_code,
                                 :sub_dept_code,
                                 :sub_product_group_code,
                                 :sub_product_line_code,
                                 :sub_post_year,
                                 :sub_post_month,
                                 :sub_doc_nature,
                                 :sub_local_amt,
                                 :sub_foreign_amt,
                                 TO_DATE(:sub_doc_date,'DD/MM/YYYY'),
                                 :sub_doc_ref,
                                 :sub_narration,
                                 USER,
                                 SYSDATE,
                                 :sub_module_id,
                                 :sub_txn_type_desc,
                                 :sub_cust_supp_code ,
								 :sub_currency_code,
								 :sub_exchg_rate) ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into GL_POSTED_TXN_CURRENT (ACC_ENTITY_CODE,BATCH_NU\
M,DOC_TYPE_CODE,DOC_NUM,LINE_NUM,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP\
_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,POST_\
YEAR,POST_MONTH,DOC_NATURE,LOCAL_AMT,FOREIGN_AMT,DOC_DATE,DOC_REF,NARRATION,PO\
STED_BY_ID,POSTED_DATE,MODULE_ID,TXN_TYPE_DESC,CUST_SUPP_CODE,CURRENCY_CODE,EX\
CHG_RATE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,\
:b14,:b15,:b16,TO_DATE(:b17,'DD/MM/YYYY'),:b18,:b19,USER,SYSDATE,:b20,:b21,:b2\
2,:b23,:b24)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )361;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&sub_acc_entity_code;
  sqlstm.sqhstl[0] = (unsigned int  )8;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&sub_batch_num;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&sub_doc_type_code;
  sqlstm.sqhstl[2] = (unsigned int  )10;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&sub_doc_num;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&sub_line_num;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&sub_main_acc1_code;
  sqlstm.sqhstl[5] = (unsigned int  )10;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&sub_main_acc2_code;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&sub_subledger_group_code;
  sqlstm.sqhstl[7] = (unsigned int  )6;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&sub_subledger_line_code;
  sqlstm.sqhstl[8] = (unsigned int  )12;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&sub_dept_code;
  sqlstm.sqhstl[9] = (unsigned int  )13;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&sub_product_group_code;
  sqlstm.sqhstl[10] = (unsigned int  )6;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&sub_product_line_code;
  sqlstm.sqhstl[11] = (unsigned int  )8;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&sub_post_year;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&sub_post_month;
  sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&sub_doc_nature;
  sqlstm.sqhstl[14] = (unsigned int  )6;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&sub_local_amt;
  sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&sub_foreign_amt;
  sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&sub_doc_date;
  sqlstm.sqhstl[17] = (unsigned int  )16;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&sub_doc_ref;
  sqlstm.sqhstl[18] = (unsigned int  )14;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&sub_narration;
  sqlstm.sqhstl[19] = (unsigned int  )54;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&sub_module_id;
  sqlstm.sqhstl[20] = (unsigned int  )6;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqhstv[21] = (         void  *)&sub_txn_type_desc;
  sqlstm.sqhstl[21] = (unsigned int  )8;
  sqlstm.sqhsts[21] = (         int  )0;
  sqlstm.sqindv[21] = (         void  *)0;
  sqlstm.sqinds[21] = (         int  )0;
  sqlstm.sqharm[21] = (unsigned int  )0;
  sqlstm.sqadto[21] = (unsigned short )0;
  sqlstm.sqtdso[21] = (unsigned short )0;
  sqlstm.sqhstv[22] = (         void  *)&sub_cust_supp_code;
  sqlstm.sqhstl[22] = (unsigned int  )11;
  sqlstm.sqhsts[22] = (         int  )0;
  sqlstm.sqindv[22] = (         void  *)0;
  sqlstm.sqinds[22] = (         int  )0;
  sqlstm.sqharm[22] = (unsigned int  )0;
  sqlstm.sqadto[22] = (unsigned short )0;
  sqlstm.sqtdso[22] = (unsigned short )0;
  sqlstm.sqhstv[23] = (         void  *)&sub_currency_code;
  sqlstm.sqhstl[23] = (unsigned int  )9;
  sqlstm.sqhsts[23] = (         int  )0;
  sqlstm.sqindv[23] = (         void  *)0;
  sqlstm.sqinds[23] = (         int  )0;
  sqlstm.sqharm[23] = (unsigned int  )0;
  sqlstm.sqadto[23] = (unsigned short )0;
  sqlstm.sqtdso[23] = (unsigned short )0;
  sqlstm.sqhstv[24] = (         void  *)&sub_exchg_rate;
  sqlstm.sqhstl[24] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[24] = (         int  )0;
  sqlstm.sqindv[24] = (         void  *)0;
  sqlstm.sqinds[24] = (         int  )0;
  sqlstm.sqharm[24] = (unsigned int  )0;
  sqlstm.sqadto[24] = (unsigned short )0;
  sqlstm.sqtdso[24] = (unsigned short )0;
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
	            strcpy(r_err_msg,"INSERT failed on table GL_POSTED_TXN_CURRENT");
	            return (-1);
                }


	     /* EXEC SQL SELECT NVL(BANK_RECONCILE_FLAG,'N')
		     INTO   :sub_bank_recon_flag
		     FROM   GL_POSTING_ACC
		     WHERE  MAIN_ACC1_CODE       =  :sub_main_acc1_code
		     AND    MAIN_ACC2_CODE       =  :sub_main_acc2_code
	             AND    DEPT_CODE            =  :sub_dept_code
	             AND    PRODUCT_GROUP_CODE   =  :sub_product_group_code
	             AND    PRODUCT_LINE_CODE    =  :sub_product_line_code
	             AND    SUBLEDGER_GROUP_CODE =  :sub_subledger_group_code
	             AND    SUBLEDGER_LINE_CODE  =  :sub_subledger_line_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 25;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select NVL(BANK_RECONCILE_FLAG,'N') into :b0  from GL_P\
OSTING_ACC where ((((((MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2) and DEPT_COD\
E=:b3) and PRODUCT_GROUP_CODE=:b4) and PRODUCT_LINE_CODE=:b5) and SUBLEDGER_GR\
OUP_CODE=:b6) and SUBLEDGER_LINE_CODE=:b7)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )476;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&sub_bank_recon_flag;
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



	      if(sqlca.sqlcode < 0 )  {
	          strcpy(r_err_msg,"SELECT failed on table GL_POSTING_ACC");
		  return (-1);
	      }

  
     if (strcmp(sub_bank_recon_flag.arr, "Y") == 0)
    {
		  /* EXEC SQL SELECT NVL(FOREIGN_CURRENCY_ACCT_YN,'N')
		     INTO   :sub_foreign_curr_flag
		     FROM   GL_ACC_CHART
		     WHERE  MAIN_ACC1_CODE       =  :sub_main_acc1_code
		     AND    MAIN_ACC2_CODE       =  :sub_main_acc2_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(FOREIGN_CURRENCY_ACCT_YN,'N') into :b0  from G\
L_ACC_CHART where (MAIN_ACC1_CODE=:b1 and MAIN_ACC2_CODE=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )523;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_foreign_curr_flag;
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



	      if(sqlca.sqlcode < 0 )  
		  {
	          strcpy(r_err_msg,"SELECT failed on table GL_ACC_CHART");
		      return (-1);
	      }
    }

   if(sub_bank_recon_flag.arr[0] == 'Y' && (strcmp(sub_doc_nature.arr,"OPN")!= 0) ) 
   {

      if  (strcmp(sub_foreign_curr_flag.arr , "Y") == 0)
	  {
	         sub_local_amt  = sub_foreign_amt;
	  }


	           /* EXEC SQL INSERT INTO GL_BB_TXN_LINE (
                                 ACC_ENTITY_CODE,
                                 MAIN_ACC1_CODE,
                                 MAIN_ACC2_CODE,
                                 DEPT_CODE,
                                 PRODUCT_GROUP_CODE,
                                 PRODUCT_LINE_CODE,
                                 SUBLEDGER_GROUP_CODE,
                                 SUBLEDGER_LINE_CODE,
                                 TXN_TYPE,
                                 DOC_DATE,
                                 DOC_REF,
                                 DOC_AMT,
                                 DOC_TYPE_CODE,
                                 DOC_NUM,
                                 RECONCILED_FLAG,
                                 POST_MONTH,
                                 POST_YEAR)
		    VALUES     ( :sub_acc_entity_code,
                                 :sub_main_acc1_code,
                                 :sub_main_acc2_code,
                                 :sub_dept_code,
                                 :sub_product_group_code,
                                 :sub_product_line_code,
                                 :sub_subledger_group_code,
                                 :sub_subledger_line_code,
                                 'P',
                                 TO_DATE(:sub_doc_date,'DD/MM/YYYY'),
                                 :sub_doc_ref,
                                 :sub_local_amt,
                                 :sub_doc_type_code,
                                 :sub_doc_num,
				 'N',
				 :sub_post_month,
				 :sub_post_year); */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 25;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "insert into GL_BB_TXN_LINE (ACC_ENTITY_CODE,MAIN_\
ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLED\
GER_GROUP_CODE,SUBLEDGER_LINE_CODE,TXN_TYPE,DOC_DATE,DOC_REF,DOC_AMT,DOC_TYPE_\
CODE,DOC_NUM,RECONCILED_FLAG,POST_MONTH,POST_YEAR) values (:b0,:b1,:b2,:b3,:b4\
,:b5,:b6,:b7,'P',TO_DATE(:b8,'DD/MM/YYYY'),:b9,:b10,:b11,:b12,'N',:b13,:b14)";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )550;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&sub_acc_entity_code;
            sqlstm.sqhstl[0] = (unsigned int  )8;
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
            sqlstm.sqhstv[8] = (         void  *)&sub_doc_date;
            sqlstm.sqhstl[8] = (unsigned int  )16;
            sqlstm.sqhsts[8] = (         int  )0;
            sqlstm.sqindv[8] = (         void  *)0;
            sqlstm.sqinds[8] = (         int  )0;
            sqlstm.sqharm[8] = (unsigned int  )0;
            sqlstm.sqadto[8] = (unsigned short )0;
            sqlstm.sqtdso[8] = (unsigned short )0;
            sqlstm.sqhstv[9] = (         void  *)&sub_doc_ref;
            sqlstm.sqhstl[9] = (unsigned int  )14;
            sqlstm.sqhsts[9] = (         int  )0;
            sqlstm.sqindv[9] = (         void  *)0;
            sqlstm.sqinds[9] = (         int  )0;
            sqlstm.sqharm[9] = (unsigned int  )0;
            sqlstm.sqadto[9] = (unsigned short )0;
            sqlstm.sqtdso[9] = (unsigned short )0;
            sqlstm.sqhstv[10] = (         void  *)&sub_local_amt;
            sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[10] = (         int  )0;
            sqlstm.sqindv[10] = (         void  *)0;
            sqlstm.sqinds[10] = (         int  )0;
            sqlstm.sqharm[10] = (unsigned int  )0;
            sqlstm.sqadto[10] = (unsigned short )0;
            sqlstm.sqtdso[10] = (unsigned short )0;
            sqlstm.sqhstv[11] = (         void  *)&sub_doc_type_code;
            sqlstm.sqhstl[11] = (unsigned int  )10;
            sqlstm.sqhsts[11] = (         int  )0;
            sqlstm.sqindv[11] = (         void  *)0;
            sqlstm.sqinds[11] = (         int  )0;
            sqlstm.sqharm[11] = (unsigned int  )0;
            sqlstm.sqadto[11] = (unsigned short )0;
            sqlstm.sqtdso[11] = (unsigned short )0;
            sqlstm.sqhstv[12] = (         void  *)&sub_doc_num;
            sqlstm.sqhstl[12] = (unsigned int  )sizeof(long);
            sqlstm.sqhsts[12] = (         int  )0;
            sqlstm.sqindv[12] = (         void  *)0;
            sqlstm.sqinds[12] = (         int  )0;
            sqlstm.sqharm[12] = (unsigned int  )0;
            sqlstm.sqadto[12] = (unsigned short )0;
            sqlstm.sqtdso[12] = (unsigned short )0;
            sqlstm.sqhstv[13] = (         void  *)&sub_post_month;
            sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
            sqlstm.sqhsts[13] = (         int  )0;
            sqlstm.sqindv[13] = (         void  *)0;
            sqlstm.sqinds[13] = (         int  )0;
            sqlstm.sqharm[13] = (unsigned int  )0;
            sqlstm.sqadto[13] = (unsigned short )0;
            sqlstm.sqtdso[13] = (unsigned short )0;
            sqlstm.sqhstv[14] = (         void  *)&sub_post_year;
            sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
            sqlstm.sqhsts[14] = (         int  )0;
            sqlstm.sqindv[14] = (         void  *)0;
            sqlstm.sqinds[14] = (         int  )0;
            sqlstm.sqharm[14] = (unsigned int  )0;
            sqlstm.sqadto[14] = (unsigned short )0;
            sqlstm.sqtdso[14] = (unsigned short )0;
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
                    strcpy(r_err_msg,"INSERT failed on table GL_BB_TXN_LINE");
                    return (-1);
                  }

	    } /* end of if bank_recon_flag = Y */


            sub_summ_flag.arr[0] = '\0';
            sub_summ_flag.len = 0;
    
#ifdef DEBUG
    sprintf(string_var,"POST_DOC: Summary flag = %c\n",d_summ_flag);
    disp_message(INFO_MESG,string_var);
#endif

	    if(d_summ_flag == 'O') {
    
	         sub_summ_flag.arr[0] = 'Y';
	         sub_summ_flag.len = 1;
    
	         if(process_summ(r_err_msg) == -1)
		     return (-1);
	    }

        } /* end of while fetch_txn_line() */

        /* EXEC SQL CLOSE GL_TXN_LINE_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 25;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )625;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  /*}*/ /* This is if loop is commented for HMC Customization*//* end if current post month-year */

    /* EXEC SQL UPDATE GL_PARAMETER
	     SET ALLOC_JV_GEN_FLAG = NULL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update GL_PARAMETER  set ALLOC_JV_GEN_FLAG=null ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )640;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(sqlca.sqlcode < 0) {
         strcpy(r_err_msg,"UPDATE failed on table GL_PARAMETER");
         return (-1);
    }

    if(strcmp(sub_module_id.arr,"GL")) { /* for all other modules */

	/* EXEC SQL UPDATE GL_TXN_DOC_HDR
		 SET    POSTED_FLAG = 'Y',
			POSTED_BY   = USER,
			POSTED_DATE = SYSDATE,
			SUMMARY_PROCESSED_FLAG = :sub_summ_flag
	         WHERE  BATCH_NUM     = :sub_batch_num
	         AND    DOC_TYPE_CODE = :sub_doc_type_code
	         AND    DOC_NUM       = :sub_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update GL_TXN_DOC_HDR  set POSTED_FLAG='Y',POSTED_BY=USER,PO\
STED_DATE=SYSDATE,SUMMARY_PROCESSED_FLAG=:b0 where ((BATCH_NUM=:b1 and DOC_TYP\
E_CODE=:b2) and DOC_NUM=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )655;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sub_summ_flag;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_batch_num;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&sub_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )10;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&sub_doc_num;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
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



	if(sqlca.sqlcode < 0) {
             strcpy(r_err_msg,"UPDATE failed on table GL_TXN_DOC_HDR");
             return (-1);
        }

    }

    return 0;

} /**** end function post_doc ****/

process_summ(l_err_msg)
char *l_err_msg;
{

    static int decl_cur = 1;

    if(decl_cur) {

	/* EXEC SQL DECLARE GL_ACC_SUM_LINE_CUR CURSOR FOR
		 SELECT  SUM_ACC1_CODE,
			 SUM_ACC2_CODE
		 FROM    GL_ACC_SUM_LINE
		 WHERE   MAIN_ACC1_CODE = :sub_main_acc1_code
		 AND     MAIN_ACC2_CODE = :sub_main_acc2_code; */ 


	decl_cur = 0;

    }

    /* EXEC SQL OPEN GL_ACC_SUM_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0015;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )686;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_main_acc2_code;
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



    while(fetch_summ_acc()) {

            process_posting_acc(sub_sum_acc1_code.arr,
			     sub_sum_acc2_code.arr,
			     sub_dept_code.arr,
	                     sub_product_group_code.arr,
	                     sub_product_line_code.arr,
	                     sub_subledger_group_code.arr,
	                     sub_subledger_line_code.arr,
			     'Y',
			     d_num_of_acc_periods,
	                     sub_post_year);


	       /* EXEC SQL UPDATE GL_PERIOD_ACC_BAL_LOCAL
	                SET    YEAR_BAL_DR          =  NVL(YEAR_BAL_DR,0)  + DECODE(SIGN(:sub_local_amt),1,:sub_local_amt,0),
	                       YEAR_BAL_CR          =  NVL(YEAR_BAL_CR,0) + DECODE(SIGN(:sub_local_amt),1,0,ABS(:sub_local_amt)),
						   YEAR_BAL_DR_FC       =  NVL(YEAR_BAL_DR_FC,0)  + DECODE(SIGN(:sub_foreign_amt),1,:sub_foreign_amt,0),
	                       YEAR_BAL_CR_FC       =  NVL(YEAR_BAL_CR_FC,0) + DECODE(SIGN(:sub_foreign_amt),1,0,ABS(:sub_foreign_amt))
	                WHERE  MAIN_ACC1_CODE       =  :sub_sum_acc1_code
	                AND    MAIN_ACC2_CODE       =  :sub_sum_acc2_code
	                AND    DEPT_CODE            =  :sub_dept_code
	                AND    PRODUCT_GROUP_CODE   =  :sub_product_group_code
	                AND    PRODUCT_LINE_CODE    =  :sub_product_line_code
	                AND    SUBLEDGER_GROUP_CODE =  :sub_subledger_group_code
	                AND    SUBLEDGER_LINE_CODE  =  :sub_subledger_line_code
	                AND    POST_YEAR            =  :sub_post_year
	                AND    POST_MONTH  BETWEEN :sub_post_month AND 12; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 25;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update GL_PERIOD_ACC_BAL_LOCAL  set YEAR_BAL_DR=(NVL(\
YEAR_BAL_DR,0)+DECODE(SIGN(:b0),1,:b0,0)),YEAR_BAL_CR=(NVL(YEAR_BAL_CR,0)+DECO\
DE(SIGN(:b0),1,0,ABS(:b0))),YEAR_BAL_DR_FC=(NVL(YEAR_BAL_DR_FC,0)+DECODE(SIGN(\
:b4),1,:b4,0)),YEAR_BAL_CR_FC=(NVL(YEAR_BAL_CR_FC,0)+DECODE(SIGN(:b4),1,0,ABS(\
:b4))) where ((((((((MAIN_ACC1_CODE=:b8 and MAIN_ACC2_CODE=:b9) and DEPT_CODE=\
:b10) and PRODUCT_GROUP_CODE=:b11) and PRODUCT_LINE_CODE=:b12) and SUBLEDGER_G\
ROUP_CODE=:b13) and SUBLEDGER_LINE_CODE=:b14) and POST_YEAR=:b15) and POST_MON\
TH between :b16 and 12)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )709;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&sub_local_amt;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&sub_local_amt;
        sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&sub_local_amt;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&sub_local_amt;
        sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&sub_foreign_amt;
        sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&sub_foreign_amt;
        sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&sub_foreign_amt;
        sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&sub_foreign_amt;
        sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&sub_sum_acc1_code;
        sqlstm.sqhstl[8] = (unsigned int  )10;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&sub_sum_acc2_code;
        sqlstm.sqhstl[9] = (unsigned int  )8;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&sub_dept_code;
        sqlstm.sqhstl[10] = (unsigned int  )13;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&sub_product_group_code;
        sqlstm.sqhstl[11] = (unsigned int  )6;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&sub_product_line_code;
        sqlstm.sqhstl[12] = (unsigned int  )8;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&sub_subledger_group_code;
        sqlstm.sqhstl[13] = (unsigned int  )6;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&sub_subledger_line_code;
        sqlstm.sqhstl[14] = (unsigned int  )12;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&sub_post_year;
        sqlstm.sqhstl[15] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&sub_post_month;
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



               if(sqlca.sqlcode < 0) {
                   strcpy(l_err_msg,"UPDATE failed on table GL_PERIOD_ACC_BAL_LOCAL");
	           return (-1);
               }

	       if(sub_post_month > 0) {

	           /* EXEC SQL UPDATE GL_PERIOD_ACC_BAL_LOCAL
	                SET   MONTH_BAL_DR          =  NVL(MONTH_BAL_DR,0) + DECODE(SIGN(:sub_local_amt),1,:sub_local_amt,0),
	                      MONTH_BAL_CR          =  NVL(MONTH_BAL_CR,0) + DECODE(SIGN(:sub_local_amt),1,0,ABS(:sub_local_amt)),
	                      MONTH_BAL_DR_FC       =  NVL(MONTH_BAL_DR_FC,0) + DECODE(SIGN(:sub_foreign_amt),1,:sub_foreign_amt,0),
	                      MONTH_BAL_CR_FC       =  NVL(MONTH_BAL_CR_FC,0) + DECODE(SIGN(:sub_foreign_amt),1,0,ABS(:sub_foreign_amt))

	                WHERE  MAIN_ACC1_CODE       =  :sub_sum_acc1_code
	                AND    MAIN_ACC2_CODE       =  :sub_sum_acc2_code
	                AND    DEPT_CODE            =  :sub_dept_code
	                AND    PRODUCT_GROUP_CODE   =  :sub_product_group_code
	                AND    PRODUCT_LINE_CODE    =  :sub_product_line_code
	                AND    SUBLEDGER_GROUP_CODE =  :sub_subledger_group_code
	                AND    SUBLEDGER_LINE_CODE  =  :sub_subledger_line_code
	                AND    POST_YEAR            =  :sub_post_year
	                AND    POST_MONTH           =  :sub_post_month; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 25;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "update GL_PERIOD_ACC_BAL_LOCAL  set MONTH_BAL_DR=\
(NVL(MONTH_BAL_DR,0)+DECODE(SIGN(:b0),1,:b0,0)),MONTH_BAL_CR=(NVL(MONTH_BAL_CR\
,0)+DECODE(SIGN(:b0),1,0,ABS(:b0))),MONTH_BAL_DR_FC=(NVL(MONTH_BAL_DR_FC,0)+DE\
CODE(SIGN(:b4),1,:b4,0)),MONTH_BAL_CR_FC=(NVL(MONTH_BAL_CR_FC,0)+DECODE(SIGN(:\
b4),1,0,ABS(:b4))) where ((((((((MAIN_ACC1_CODE=:b8 and MAIN_ACC2_CODE=:b9) an\
d DEPT_CODE=:b10) and PRODUCT_GROUP_CODE=:b11) and PRODUCT_LINE_CODE=:b12) and\
 SUBLEDGER_GROUP_CODE=:b13) and SUBLEDGER_LINE_CODE=:b14) and POST_YEAR=:b15) \
and POST_MONTH=:b16)";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )792;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&sub_local_amt;
            sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&sub_local_amt;
            sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqhstv[2] = (         void  *)&sub_local_amt;
            sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[2] = (         int  )0;
            sqlstm.sqindv[2] = (         void  *)0;
            sqlstm.sqinds[2] = (         int  )0;
            sqlstm.sqharm[2] = (unsigned int  )0;
            sqlstm.sqadto[2] = (unsigned short )0;
            sqlstm.sqtdso[2] = (unsigned short )0;
            sqlstm.sqhstv[3] = (         void  *)&sub_local_amt;
            sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[3] = (         int  )0;
            sqlstm.sqindv[3] = (         void  *)0;
            sqlstm.sqinds[3] = (         int  )0;
            sqlstm.sqharm[3] = (unsigned int  )0;
            sqlstm.sqadto[3] = (unsigned short )0;
            sqlstm.sqtdso[3] = (unsigned short )0;
            sqlstm.sqhstv[4] = (         void  *)&sub_foreign_amt;
            sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[4] = (         int  )0;
            sqlstm.sqindv[4] = (         void  *)0;
            sqlstm.sqinds[4] = (         int  )0;
            sqlstm.sqharm[4] = (unsigned int  )0;
            sqlstm.sqadto[4] = (unsigned short )0;
            sqlstm.sqtdso[4] = (unsigned short )0;
            sqlstm.sqhstv[5] = (         void  *)&sub_foreign_amt;
            sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[5] = (         int  )0;
            sqlstm.sqindv[5] = (         void  *)0;
            sqlstm.sqinds[5] = (         int  )0;
            sqlstm.sqharm[5] = (unsigned int  )0;
            sqlstm.sqadto[5] = (unsigned short )0;
            sqlstm.sqtdso[5] = (unsigned short )0;
            sqlstm.sqhstv[6] = (         void  *)&sub_foreign_amt;
            sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[6] = (         int  )0;
            sqlstm.sqindv[6] = (         void  *)0;
            sqlstm.sqinds[6] = (         int  )0;
            sqlstm.sqharm[6] = (unsigned int  )0;
            sqlstm.sqadto[6] = (unsigned short )0;
            sqlstm.sqtdso[6] = (unsigned short )0;
            sqlstm.sqhstv[7] = (         void  *)&sub_foreign_amt;
            sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
            sqlstm.sqhsts[7] = (         int  )0;
            sqlstm.sqindv[7] = (         void  *)0;
            sqlstm.sqinds[7] = (         int  )0;
            sqlstm.sqharm[7] = (unsigned int  )0;
            sqlstm.sqadto[7] = (unsigned short )0;
            sqlstm.sqtdso[7] = (unsigned short )0;
            sqlstm.sqhstv[8] = (         void  *)&sub_sum_acc1_code;
            sqlstm.sqhstl[8] = (unsigned int  )10;
            sqlstm.sqhsts[8] = (         int  )0;
            sqlstm.sqindv[8] = (         void  *)0;
            sqlstm.sqinds[8] = (         int  )0;
            sqlstm.sqharm[8] = (unsigned int  )0;
            sqlstm.sqadto[8] = (unsigned short )0;
            sqlstm.sqtdso[8] = (unsigned short )0;
            sqlstm.sqhstv[9] = (         void  *)&sub_sum_acc2_code;
            sqlstm.sqhstl[9] = (unsigned int  )8;
            sqlstm.sqhsts[9] = (         int  )0;
            sqlstm.sqindv[9] = (         void  *)0;
            sqlstm.sqinds[9] = (         int  )0;
            sqlstm.sqharm[9] = (unsigned int  )0;
            sqlstm.sqadto[9] = (unsigned short )0;
            sqlstm.sqtdso[9] = (unsigned short )0;
            sqlstm.sqhstv[10] = (         void  *)&sub_dept_code;
            sqlstm.sqhstl[10] = (unsigned int  )13;
            sqlstm.sqhsts[10] = (         int  )0;
            sqlstm.sqindv[10] = (         void  *)0;
            sqlstm.sqinds[10] = (         int  )0;
            sqlstm.sqharm[10] = (unsigned int  )0;
            sqlstm.sqadto[10] = (unsigned short )0;
            sqlstm.sqtdso[10] = (unsigned short )0;
            sqlstm.sqhstv[11] = (         void  *)&sub_product_group_code;
            sqlstm.sqhstl[11] = (unsigned int  )6;
            sqlstm.sqhsts[11] = (         int  )0;
            sqlstm.sqindv[11] = (         void  *)0;
            sqlstm.sqinds[11] = (         int  )0;
            sqlstm.sqharm[11] = (unsigned int  )0;
            sqlstm.sqadto[11] = (unsigned short )0;
            sqlstm.sqtdso[11] = (unsigned short )0;
            sqlstm.sqhstv[12] = (         void  *)&sub_product_line_code;
            sqlstm.sqhstl[12] = (unsigned int  )8;
            sqlstm.sqhsts[12] = (         int  )0;
            sqlstm.sqindv[12] = (         void  *)0;
            sqlstm.sqinds[12] = (         int  )0;
            sqlstm.sqharm[12] = (unsigned int  )0;
            sqlstm.sqadto[12] = (unsigned short )0;
            sqlstm.sqtdso[12] = (unsigned short )0;
            sqlstm.sqhstv[13] = (         void  *)&sub_subledger_group_code;
            sqlstm.sqhstl[13] = (unsigned int  )6;
            sqlstm.sqhsts[13] = (         int  )0;
            sqlstm.sqindv[13] = (         void  *)0;
            sqlstm.sqinds[13] = (         int  )0;
            sqlstm.sqharm[13] = (unsigned int  )0;
            sqlstm.sqadto[13] = (unsigned short )0;
            sqlstm.sqtdso[13] = (unsigned short )0;
            sqlstm.sqhstv[14] = (         void  *)&sub_subledger_line_code;
            sqlstm.sqhstl[14] = (unsigned int  )12;
            sqlstm.sqhsts[14] = (         int  )0;
            sqlstm.sqindv[14] = (         void  *)0;
            sqlstm.sqinds[14] = (         int  )0;
            sqlstm.sqharm[14] = (unsigned int  )0;
            sqlstm.sqadto[14] = (unsigned short )0;
            sqlstm.sqtdso[14] = (unsigned short )0;
            sqlstm.sqhstv[15] = (         void  *)&sub_post_year;
            sqlstm.sqhstl[15] = (unsigned int  )sizeof(int);
            sqlstm.sqhsts[15] = (         int  )0;
            sqlstm.sqindv[15] = (         void  *)0;
            sqlstm.sqinds[15] = (         int  )0;
            sqlstm.sqharm[15] = (unsigned int  )0;
            sqlstm.sqadto[15] = (unsigned short )0;
            sqlstm.sqtdso[15] = (unsigned short )0;
            sqlstm.sqhstv[16] = (         void  *)&sub_post_month;
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


    
                   if(sqlca.sqlcode < 0) {
                       strcpy(l_err_msg,"UPDATE failed on table GL_PERIOD_ACC_BAL_LOCAL");
                       return (-1);
                   }

		} /* end of if post_month > 0 */

    } /* end of while fetch_summ_acc() */


} /**** end of function process_summ() ****/

fetch_txn_line()
{

  sub_exchg_rate = 0;

    /* EXEC SQL FETCH GL_TXN_LINE_CUR INTO	
        :sub_main_acc1_code,
		:sub_main_acc2_code,
		:sub_dept_code,
		:sub_product_group_code,
		:sub_product_line_code,
		:sub_subledger_group_code,
		:sub_subledger_line_code,
		:sub_narration,
		:sub_line_num,
		:sub_foreign_amt,
		:sub_local_amt,
		:sub_currency_code,
		:sub_exchg_rate,
		:sub_cust_supp_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )875;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sub_dept_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&sub_product_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&sub_product_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&sub_subledger_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&sub_subledger_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&sub_narration;
    sqlstm.sqhstl[7] = (unsigned int  )54;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&sub_line_num;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&sub_foreign_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&sub_local_amt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&sub_currency_code;
    sqlstm.sqhstl[11] = (unsigned int  )9;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&sub_exchg_rate;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&sub_cust_supp_code;
    sqlstm.sqhstl[13] = (unsigned int  )11;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
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
	    err_mesg("FETCH failed on cursor GL_TXN_LINE_CUR",0,"");

        if(sqlca.sqlcode == 1403) 
		return 0;
	
	sub_main_acc1_code.arr[sub_main_acc1_code.len] = '\0';
	sub_main_acc2_code.arr[sub_main_acc2_code.len] = '\0';
	sub_dept_code.arr[sub_dept_code.len] = '\0';
	sub_product_group_code.arr[sub_product_group_code.len] = '\0';
	sub_product_line_code.arr[sub_product_line_code.len] = '\0';
	sub_subledger_group_code.arr[sub_subledger_group_code.len] = '\0';
	sub_subledger_line_code.arr[sub_subledger_line_code.len] = '\0';
	sub_currency_code.arr[sub_currency_code.len] = '\0';
	sub_cust_supp_code.arr[sub_cust_supp_code.len] = '\0';

	return 1;

}

fetch_summ_acc()
{

    /* EXEC SQL FETCH GL_ACC_SUM_LINE_CUR INTO	
                :sub_sum_acc1_code,
		:sub_sum_acc2_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )946;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sub_sum_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_sum_acc2_code;
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



	if(sqlca.sqlcode < 0)
	    err_mesg("FETCH failed on cursor GL_ACC_SUM_LINE_CUR",0,"");

        if(sqlca.sqlcode == 1403) 
		return 0;
	
	sub_sum_acc1_code.arr[sub_sum_acc1_code.len] = '\0';
	sub_sum_acc2_code.arr[sub_sum_acc2_code.len] = '\0';

#ifdef DEBUG
    sprintf(string_var,"summ_acc1_code = <%s> summ_acc2_code = <%s>\n",sub_sum_acc1_code.arr,sub_sum_acc2_code.arr);
    disp_message(INFO_MESG,string_var);
#endif

	return 1;

}
