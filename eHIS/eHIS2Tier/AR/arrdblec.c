
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
           char  filnam[39];
};
static const struct sqlcxp sqlfpn =
{
    38,
    "T:\\BL\\CRF-0120\\AR\\WIP\\Proc\\arrdblec.pc"
};


static unsigned long sqlctx = 1150833149;


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

 static const char *sq0005 = 
"select CUST_CODE ,LONG_NAME ,CUST_ALPHA_CODE ,MISC_CUSTOMER_FLAG  from AR_CU\
STOMER where (((((CUST_CODE between NVL(:b0,'        ') and NVL(:b1,'~~~~~~~~'\
) and CUST_TYPE_CODE between NVL(:b2,'  ') and NVL(:b3,'~~')) and CUST_GROUP_C\
ODE between NVL(:b4,'  ') and NVL(:b5,'~~')) and NVL(ANALYSIS_1_CODE,'X') betw\
een NVL(:b6,'        ') and NVL(:b7,'~~~~~~~~')) and NVL(ANALYSIS_2_CODE,'X') \
between NVL(:b8,'        ') and NVL(:b9,'~~~~~~~~')) and NVL(ANALYSIS_3_CODE,'\
X') between NVL(:b10,'        ') and NVL(:b11,'~~~~~~~~')) order by CUST_CODE \
           ";

 static const char *sq0006 = 
"select CUST_CODE ,LONG_NAME ,CUST_ALPHA_CODE ,MISC_CUSTOMER_FLAG  from AR_CU\
STOMER where (((((CUST_ALPHA_CODE between NVL(:b0,'        ') and NVL(:b1,'~~~\
~~~~~') and CUST_TYPE_CODE between NVL(:b2,'  ') and NVL(:b3,'~~')) and CUST_G\
ROUP_CODE between NVL(:b4,'  ') and NVL(:b5,'~~')) and NVL(ANALYSIS_1_CODE,'X'\
) between NVL(:b6,'        ') and NVL(:b7,'~~~~~~~~')) and NVL(ANALYSIS_2_CODE\
,'X') between NVL(:b8,'        ') and NVL(:b9,'~~~~~~~~')) and NVL(ANALYSIS_3_\
CODE,'X') between NVL(:b10,'        ') and NVL(:b11,'~~~~~~~~')) order by CUST\
_ALPHA_CODE,CUST_CODE            ";

 static const char *sq0007 = 
"select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_D\
ATE,'YYYYMMDD') ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,CUST_REF ,AMOUNT ,AMOUNT ,NAR\
RATION ,LTRIM(TO_CHAR(NVL(POST_MONTH,0),'09')) ,NVL(POST_YEAR,0)  from AR_CUST\
_TRN where CUST_CODE=:b0 order by POST_YEAR,POST_MONTH,DOC_DATE,DOC_TYPE_CODE,\
DOC_NUM            ";

 static const char *sq0008 = 
"select TO_CHAR(BASE_DATE,'DD/MM/YYYY') ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,MISC\
_CUST_LONG_NAME  from AR_PENDING_DOC where ((CUST_CODE=:b0 and DOC_TYPE_CODE=:\
b1) and DOC_NUM=:b2)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,513,0,4,206,0,0,25,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
120,0,0,2,249,0,4,315,0,0,9,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
171,0,0,3,91,0,2,396,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
194,0,0,4,0,0,30,405,0,0,0,0,0,1,0,
209,0,0,5,555,0,9,624,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
272,0,0,6,577,0,9,652,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
335,0,0,7,329,0,9,696,0,0,1,1,0,1,0,1,9,0,0,
354,0,0,5,0,0,13,717,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
385,0,0,6,0,0,13,726,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
416,0,0,7,0,0,13,769,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
479,0,0,8,185,0,9,805,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
506,0,0,8,0,0,13,818,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
533,0,0,9,0,0,27,1093,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/* Date :- 16-JAN-93  */
 
#include <stdio.h>
#include <string.h>
/*
#include <sqlca.h>
*/                                                              
#include "gl.h"            
/*
#define ERROR (sqlca.sqlcode < 0)
*/
                                                   
#define LAST_ROW (sqlca.sqlcode == 1403)
          
#define ESC 0x1B

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
/*
#define DEBUG 0   
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
           date_time    [20],
           user_id      [20],
		   pm			[3],
		   py			[5],
		   pfm			[3],
		   pfy			[5],
		   ptm			[3],
		   pty			[5],
		   fm_ym		[8],
		   to_ym		[8],
		   p_ym			[8],
		   nd_post_month [3],
		   nd_post_year  [5],
           nd_pgm_date  [35]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[3]; } pm;

struct { unsigned short len; unsigned char arr[5]; } py;

struct { unsigned short len; unsigned char arr[3]; } pfm;

struct { unsigned short len; unsigned char arr[5]; } pfy;

struct { unsigned short len; unsigned char arr[3]; } ptm;

struct { unsigned short len; unsigned char arr[5]; } pty;

struct { unsigned short len; unsigned char arr[8]; } fm_ym;

struct { unsigned short len; unsigned char arr[8]; } to_ym;

struct { unsigned short len; unsigned char arr[8]; } p_ym;

struct { unsigned short len; unsigned char arr[3]; } nd_post_month;

struct { unsigned short len; unsigned char arr[5]; } nd_post_year;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;


   /* VARCHAR nd_facility_id                [3],
		   nd_session_id                 [16],
		   fmcust						 [9],
		   tocust						 [9],
		   fmalpha						 [11],
		   toalpha					     [11],
           nd_fm_cust_code               [12],
           nd_to_cust_code               [12],
           nd_fm_alpha_code              [11],
           nd_to_alpha_code              [11],
           nd_fm_doc_date                [13],
           nd_to_doc_date                [13],
		   nd_report_type				 [2],
		   nd_fm_cust_type				 [3],
           nd_to_cust_type				 [3],
           nd_fm_cust_group				 [3],
           nd_to_cust_group				 [3],
           nd_fm_anal_cd1				 [9],
           nd_to_anal_cd1				 [9],
           nd_fm_anal_cd2				 [9],
           nd_to_anal_cd2				 [9],
           nd_fm_anal_cd3				 [9],
           nd_to_anal_cd3				 [9],
           nd_order                      [11]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[9]; } fmcust;

struct { unsigned short len; unsigned char arr[9]; } tocust;

struct { unsigned short len; unsigned char arr[11]; } fmalpha;

struct { unsigned short len; unsigned char arr[11]; } toalpha;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[12]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_alpha_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_alpha_code;

struct { unsigned short len; unsigned char arr[13]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[2]; } nd_report_type;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_cust_type;

struct { unsigned short len; unsigned char arr[3]; } nd_to_cust_type;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_cust_group;

struct { unsigned short len; unsigned char arr[3]; } nd_to_cust_group;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_anal_cd1;

struct { unsigned short len; unsigned char arr[9]; } nd_to_anal_cd1;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_anal_cd2;

struct { unsigned short len; unsigned char arr[9]; } nd_to_anal_cd2;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_anal_cd3;

struct { unsigned short len; unsigned char arr[9]; } nd_to_anal_cd3;

struct { unsigned short len; unsigned char arr[11]; } nd_order;


   /* VARCHAR ar_customer_cust_code         [9],
           ar_customer_long_name         [101],  -- CRF-0120
           ar_cust_alpha_code            [11],
           ar_misc_customer_flag         [2],
           cust_org_doc_type_code        [7],
           cust_org_doc_num              [9],
           cust_doc_type_code            [7],
           cust_doc_num                  [9],
           cust_doc_date                 [13],
           doc_date_prn                  [13],
           cust_ref                      [16],
           cust_amount                   [17],
           cust_narration                [51],
           misc_name                     [100],
           base_date                     [13],
           due_date                      [13],
           open_bal_date                 [15],
           close_bal_date                [15],
		   cust_print_flag               [2]; */ 
struct { unsigned short len; unsigned char arr[9]; } ar_customer_cust_code;

struct { unsigned short len; unsigned char arr[101]; } ar_customer_long_name;

struct { unsigned short len; unsigned char arr[11]; } ar_cust_alpha_code;

struct { unsigned short len; unsigned char arr[2]; } ar_misc_customer_flag;

struct { unsigned short len; unsigned char arr[7]; } cust_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } cust_org_doc_num;

struct { unsigned short len; unsigned char arr[7]; } cust_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } cust_doc_num;

struct { unsigned short len; unsigned char arr[13]; } cust_doc_date;

struct { unsigned short len; unsigned char arr[13]; } doc_date_prn;

struct { unsigned short len; unsigned char arr[16]; } cust_ref;

struct { unsigned short len; unsigned char arr[17]; } cust_amount;

struct { unsigned short len; unsigned char arr[51]; } cust_narration;

struct { unsigned short len; unsigned char arr[100]; } misc_name;

struct { unsigned short len; unsigned char arr[13]; } base_date;

struct { unsigned short len; unsigned char arr[13]; } due_date;

struct { unsigned short len; unsigned char arr[15]; } open_bal_date;

struct { unsigned short len; unsigned char arr[15]; } close_bal_date;

struct { unsigned short len; unsigned char arr[2]; } cust_print_flag;

   
   /* VARCHAR p_language_id				 [4]; */ 
struct { unsigned short len; unsigned char arr[4]; } p_language_id;


   double  amount,
           running_amt,
           opening_amt;
   
   int nd_fm_post_month,
	   nd_fm_post_year,
	   nd_to_post_month,
	   nd_to_post_year,
	   nd_no_of_decimal;
	   /*
	   nd_post_month,
	   nd_post_year;
		*/
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





#include "winproc.h"

FILE *fp;
int lctr = 0,pctr =0,cust_trn_ctr = 0;

int open_print_flag = 0;

/****added by nitin *****/
double g_tot_dr_amt,
       g_tot_cr_amt,
       g_tot_bal_amt;

int    g_tot_print_flag;
/***********************/
char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{ 
   strcpy(filename,WORKING_DIR);
   strcpy(OUTPUT_FILE_NAME,argv[5]);
   strcat(filename,OUTPUT_FILE_NAME);

   //strcat(filename,"arrdblec.lis");

   if (argc != 6)
   {
     disp_message(ERR_MESG,"Not enough Parameters for running this program");
     proc_exit();
   }


   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"ARRDBLEC");

   if(sql_connect() == -1)
   {
      if (uid_pwd.len == 0)
         disp_message(ORA_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);
   strcpy(g_facility_id,argv[4]);

   
   set_meduser_role();                 
   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;
 
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   nd_fm_cust_code.arr[0]        = '\0';
   nd_to_cust_code.arr[0]        = '\0';
   nd_fm_alpha_code.arr[0]       = '\0';
   nd_to_alpha_code.arr[0]       = '\0';
   nd_fm_doc_date.arr[0]         = '\0';
   nd_to_doc_date.arr[0]         = '\0';
   nd_order.arr[0]               = '\0';
   nd_report_type.arr[0]		 = '\0';

   nd_fm_cust_type.arr[0]        = '\0';
   nd_to_cust_type.arr[0]        = '\0';
   nd_fm_cust_group.arr[0]       = '\0';
   nd_to_cust_group.arr[0]       = '\0';
   nd_fm_anal_cd1.arr[0]         = '\0';
   nd_to_anal_cd1.arr[0]         = '\0';
   nd_fm_anal_cd2.arr[0]         = '\0';
   nd_to_anal_cd2.arr[0]         = '\0';
   nd_fm_anal_cd3.arr[0]         = '\0';
   nd_to_anal_cd3.arr[0]         = '\0';


   nd_fm_cust_type.len           = 0;
   nd_to_cust_type.len           = 0;
   nd_fm_cust_group.len          = 0;
   nd_to_cust_group.len          = 0;
   nd_fm_anal_cd1.len            = 0;
   nd_to_anal_cd1.len            = 0;
   nd_fm_anal_cd2.len            = 0;
   nd_to_anal_cd2.len            = 0;
   nd_fm_anal_cd3.len            = 0;
   nd_to_anal_cd3.len            = 0;
   nd_fm_cust_code.len           = 0;
   nd_to_cust_code.len           = 0;
   nd_fm_alpha_code.len          = 0;
   nd_to_alpha_code.len          = 0;
   nd_fm_doc_date.len            = 0;
   nd_to_doc_date.len            = 0;
   nd_order.len                  = 0;
   nd_report_type.len			 = 0;
   

   /* EXEC SQL SELECT operating_facility_id,
				   NVL(PARAM1,'!!!!!!!!'),
				   NVL(PARAM2,'~~~~~~~~'),
				   NVL(PARAM3,'!!!!!!!!!!'),
				   NVL(PARAM4,'~~~~~~~~~~'),
                   NVL(PARAM5,'18000101'),
                   NVL(PARAM6,'47121231'),
                   PARAM7,
/o------ Added on 21/12/1998 to Enhance the Report -----o/
				   PARAM8,
				   PARAM9,
				   PARAM10,
				   PARAM11,
				   PARAM12,
				   PARAM13,
                   PARAM14,
                   PARAM15,
                   PARAM16,
                   PARAM17,
                   PARAM18,
                   PARAM19,
                   PARAM20,
                   PARAM21,
                   PARAM22
              INTO :nd_facility_id,
				   :nd_fm_cust_code,
                   :nd_to_cust_code,
                   :nd_fm_alpha_code,
                   :nd_to_alpha_code,
                   :nd_fm_doc_date,
                   :nd_to_doc_date,
                   :nd_order,
/o------ Added on 21/12/1998 to Enhance the Report -----o/
				   :pfm,
				   :pfy,
				   :ptm,
				   :pty,
				   /o
				   :nd_fm_post_month,
				   :nd_fm_post_year,
				   :nd_to_post_month,
				   :nd_to_post_year,
				   o/
				   :nd_report_type,
				   :nd_fm_cust_type,
                   :nd_to_cust_type,
                   :nd_fm_cust_group,
                   :nd_to_cust_group,
                   :nd_fm_anal_cd1,
                   :nd_to_anal_cd1,
                   :nd_fm_anal_cd2,
                   :nd_to_anal_cd2,
                   :nd_fm_anal_cd3,
                   :nd_to_anal_cd3
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRDBLPM'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,NVL(PARAM1,'!!!!!!!!') ,NVL(\
PARAM2,'~~~~~~~~') ,NVL(PARAM3,'!!!!!!!!!!') ,NVL(PARAM4,'~~~~~~~~~~') ,NVL(PA\
RAM5,'18000101') ,NVL(PARAM6,'47121231') ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PAR\
AM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,\
PARAM20 ,PARAM21 ,PARAM22 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b\
11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20,:b21,:b22  from SY_PROG_PARAM \
where ((PGM_ID='ARRDBLPM' and SESSION_ID=:b23) and PGM_DATE=:b24)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_alpha_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_alpha_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[5] = (unsigned int  )15;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[6] = (unsigned int  )15;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_order;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&pfm;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&pfy;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&ptm;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&pty;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_report_type;
   sqlstm.sqhstl[12] = (unsigned int  )4;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_fm_cust_type;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_to_cust_type;
   sqlstm.sqhstl[14] = (unsigned int  )5;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_fm_cust_group;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_to_cust_group;
   sqlstm.sqhstl[16] = (unsigned int  )5;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_fm_anal_cd1;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_to_anal_cd1;
   sqlstm.sqhstl[18] = (unsigned int  )11;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_fm_anal_cd2;
   sqlstm.sqhstl[19] = (unsigned int  )11;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_to_anal_cd2;
   sqlstm.sqhstl[20] = (unsigned int  )11;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_fm_anal_cd3;
   sqlstm.sqhstl[21] = (unsigned int  )11;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_to_anal_cd3;
   sqlstm.sqhstl[22] = (unsigned int  )11;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[23] = (unsigned int  )18;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[24] = (unsigned int  )37;
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



   if (ERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_fm_cust_code.arr[nd_fm_cust_code.len]        = '\0';
   nd_to_cust_code.arr[nd_to_cust_code.len]        = '\0';
   nd_fm_alpha_code.arr[nd_fm_alpha_code.len]      = '\0';
   nd_to_alpha_code.arr[nd_to_alpha_code.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]          = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]          = '\0';
   nd_order.arr[nd_order.len]                      = '\0';
   nd_report_type.arr[nd_report_type.len]		   = '\0';

   pfm.arr[pfm.len]        = '\0';
   pfy.arr[pfy.len]        = '\0';
   ptm.arr[ptm.len]        = '\0';
   pty.arr[pty.len]        = '\0';
   nd_fm_cust_type.arr[nd_fm_cust_type.len]        = '\0';
   nd_to_cust_type.arr[nd_to_cust_type.len]        = '\0';
   nd_fm_cust_group.arr[nd_fm_cust_group.len]      = '\0';
   nd_to_cust_group.arr[nd_to_cust_group.len]      = '\0';
   nd_fm_anal_cd1.arr[nd_fm_anal_cd1.len]          = '\0';
   nd_to_anal_cd1.arr[nd_to_anal_cd1.len]          = '\0';
   nd_fm_anal_cd2.arr[nd_fm_anal_cd2.len]          = '\0';
   nd_to_anal_cd2.arr[nd_to_anal_cd2.len]          = '\0';
   nd_fm_anal_cd3.arr[nd_fm_anal_cd3.len]          = '\0';
   nd_to_anal_cd3.arr[nd_to_anal_cd3.len]          = '\0';


   start_prog_msg();

   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';
   open_bal_date.arr[0]  = '\0';
   close_bal_date.arr[0] = '\0';
   cust_print_flag.arr[0] = '\0';


   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;
   open_bal_date.len  = 0;
   close_bal_date.len = 0;
   cust_print_flag.len = 0;

/*-- Y2K corrections. Format for Year changed from YY to YYYY VSK 14/11/1999 */

   /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   USER,
                   TO_CHAR(TO_DATE(:nd_fm_doc_date,'YYYYMMDD'),'DD/MM/YYYY'),
                   TO_CHAR(TO_DATE(:nd_to_doc_date,'YYYYMMDD'),'DD/MM/YYYY'),
		   NO_OF_DECIMAL
              INTO :hosp_name, :date_time, :user_id,
                   :open_bal_date, :close_bal_date,:nd_no_of_decimal
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER ,TO_CHAR(TO_DATE(:b0,'YYYYMMDD'),'DD/MM/YYYY') ,TO_CHAR(TO_DATE(:b1,\
'YYYYMMDD'),'DD/MM/YYYY') ,NO_OF_DECIMAL into :b2,:b3,:b4,:b5,:b6,:b7  from SY\
_ACC_ENTITY where ACC_ENTITY_ID=:b8";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )120;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[0] = (unsigned int  )15;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&hosp_name;
   sqlstm.sqhstl[2] = (unsigned int  )122;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&date_time;
   sqlstm.sqhstl[3] = (unsigned int  )22;
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
   sqlstm.sqhstv[5] = (         void  *)&open_bal_date;
   sqlstm.sqhstl[5] = (unsigned int  )17;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&close_bal_date;
   sqlstm.sqhstl[6] = (unsigned int  )17;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[8] = (unsigned int  )5;
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



   if (ERROR)
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';
   open_bal_date.arr[open_bal_date.len]   = '\0';
   close_bal_date.arr[close_bal_date.len] = '\0';

   g_tot_dr_amt = g_tot_cr_amt = g_tot_bal_amt = 0;

   open_files();
   
   declare_cursors();

   g_tot_print_flag = 0;

   while(fetch_customer())
   {
        running_amt  = 0;
        opening_amt = 0;
        open_print_flag = 0;
        g_tot_print_flag = 1;

        open_cust_trn();
           
        while(fetch_cust_trn())
        {

              strcpy(p_ym.arr,nd_post_year.arr);
			  strcat(p_ym.arr,nd_post_month.arr);
			 
			  strcpy(to_ym.arr,pty.arr);
			  strcat(to_ym.arr,ptm.arr);

			  strcpy(fm_ym.arr,pfy.arr);
			  strcat(fm_ym.arr,pfm.arr);



             if ((atoi(cust_doc_date.arr) > atoi(nd_to_doc_date.arr))
			 ||
			     (atoi(p_ym.arr) > atoi(to_ym.arr))) 
                         break;
             if ((atoi(cust_doc_date.arr) < atoi(nd_fm_doc_date.arr))
			 ||
				 (atoi(p_ym.arr) < atoi(fm_ym.arr)))
             {
                    opening_amt += amount;
                    continue;
             }
             else if (open_print_flag == 0)
             {
                    print_header();
                    open_print_flag = 1;
                    running_amt = opening_amt;
             }

             running_amt += amount; 
             fetch_ar_pending_doc();
             print_details();
        }
        if (open_print_flag == 0)
        {
            print_header();
            running_amt = opening_amt;
        }
        print_footer();
    }
    print_end();

    /* EXEC SQL DELETE FROM SY_PROG_PARAM
                   WHERE PGM_ID     = 'ARRDBLPM'
                     AND SESSION_ID = :nd_session_id
                     AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRDBLPM' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )171;
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



    if (ERROR)
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

    end_prog_msg();
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )194;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return;
}

open_files()   
{
   char		text_msg[101];

   if ((fp = fopen(filename,"w")) == NULL)
   {
        sprintf(text_msg,"Error While Opening File %s",filename);
        err_mesg(text_msg,0,"");
		proc_exit();

		//err_mesg("\nError while opening File arrdblec.lis\n",0,"");
        //proc_exit();
   }

   print_title();
   print_head();

}

print_title()
{
  void print_hospital_name();
  /*
  fprintf(fp,
"\n\nMDL : AR                                               %-30s                                      %-16s\n",
      hosp_name.arr,date_time.arr);
  */   
   fprintf(fp,"%cM",ESC);
   print_hospital_name(139,"AR",hosp_name.arr,date_time.arr);

   fprintf(fp,"OPR : %-10s \n", user_id.arr);
  fprintf(fp,
"REP : %-8s                                   %-28s                                               PAGE : %4d\n",
    g_pgm_id,"     DEBTOR'S LEDGER - BY PERIOD",++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------\n");
//fprintf(fp,"VER : 1.10.01\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"                REPORT ORDER         : %s\n\n",
(nd_order.arr[0]  =='C')?"CUST CODE":"ALPHA CODE");
//////

if(strcmp(nd_fm_cust_code.arr,"!!!!!!!!")== 0)
   strcpy(fmcust.arr,"LOWEST");
else
   strcpy(fmcust.arr,nd_fm_cust_code.arr);
if(strcmp(nd_to_cust_code.arr,"~~~~~~~~")== 0)
   strcpy(tocust.arr,"HIGHEST");
else
   strcpy(tocust.arr,nd_to_cust_code.arr);

if(strcmp(nd_fm_alpha_code.arr,"!!!!!!!!!!")== 0)
   strcpy(fmalpha.arr,"LOWEST");
else
   strcpy(fmalpha.arr,nd_fm_alpha_code.arr);

if(strcmp(nd_to_alpha_code.arr,"~~~~~~~~~~")== 0)
   strcpy(toalpha.arr,"HIGHEST");
else
   strcpy(toalpha.arr,nd_to_alpha_code.arr);

//////
fprintf(fp,"                %-10s     FROM  : %-10s\n",
(nd_order.arr[0]  =='C')?"CUST CODE":"ALPHA CODE",
(nd_order.arr[0]  =='C')?fmcust.arr:fmalpha.arr); 
fprintf(fp,"                %-10s     TO    : %-10s\n\n","",
(nd_order.arr[0]  =='C')?tocust.arr:toalpha.arr); 

fprintf(fp,"                DOCUMENT DATE  FROM  : %-10s\n",open_bal_date.arr);
fprintf(fp,"                               TO    : %-10s\n\n",close_bal_date.arr);

fprintf(fp,"                CUST TYPE      FROM  : %s\n",nd_fm_cust_type.arr);
fprintf(fp,"                               TO    : %s\n\n",nd_to_cust_type.arr);
fprintf(fp,"                CUST GROUP     FROM  : %s\n",nd_fm_cust_group.arr);
fprintf(fp,"                               TO    : %s\n\n",nd_to_cust_group.arr);
fprintf(fp,"                ANALYSIS CODE1 FROM  : %s\n",nd_fm_anal_cd1.arr);
fprintf(fp,"                               TO    : %s\n\n",nd_to_anal_cd1.arr);
fprintf(fp,"                ANALYSIS CODE2 FROM  : %s\n",nd_fm_anal_cd2.arr);
fprintf(fp,"                               TO    : %s\n\n",nd_to_anal_cd2.arr);
fprintf(fp,"                ANALYSIS CODE3 FROM  : %s\n",nd_fm_anal_cd3.arr);
fprintf(fp,"                               TO    : %s\n\n",nd_to_anal_cd3.arr);



/*----------- Added on 21/12/1998 For Enhancement ------------------------------*/
fprintf(fp,"               POST MONTH/YEAR FROM  : %-2s/%-5s\n",pfm.arr,pfy.arr);
fprintf(fp,"                               TO    : %-2s/%-5s\n\n",ptm.arr,pty.arr);
if(strcmp(nd_report_type.arr,"D")==0){
fprintf(fp,"                       REPORT TYPE   : DETAIL\n");
}
if(strcmp(nd_report_type.arr,"S")==0){
fprintf(fp,"                       REPORT TYPE   : SUMMARY\n");
}
/*------------------------------------------------------------------------------*/
  fflush(fp);
}
 
print_head()
{
  void print_hospital_name();
  /*
  fprintf(fp,
"\fMDL : AR                                               %-30s                                      %-16s\n",
      hosp_name.arr,date_time.arr);
  */
  fprintf(fp,"\f");
  fprintf(fp,"%cM",ESC);
  print_hospital_name(139,"AR",hosp_name.arr,date_time.arr);
  fprintf(fp,"OPR : %-10s \n", user_id.arr);
  fprintf(fp,
"REP : %-8s                                  %-28s                                                PAGE : %4d\n",
    g_pgm_id,"     DEBTOR'S LEDGER - BY PERIOD",++pctr);
  fprintf(fp,
"                                                 FOR THE PERIOD FROM %s/%s TO %s/%s\n",
//    open_bal_date.arr,close_bal_date.arr);
    pfm.arr,pfy.arr,ptm.arr,pty.arr);

fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,
"DOC DATE   DOC TYPE & NO   NARRATION                                                    DEBIT AMT          CREDIT AMT         BALANCE AMT\n");
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------\n\n");
  fflush(fp);
  lctr = 7;

  if (strcmp(cust_print_flag.arr , "Y")  ==  0)
 {
   fprintf(fp,"\nCUSTOMER : %-8s %-40s %-10s\n",
    ar_customer_cust_code.arr, ar_customer_long_name.arr, ar_cust_alpha_code.arr);

	lctr += 2;
 }

}

print_end()
{  

  VARCHAR s_tot_dr_amt[20], s_tot_cr_amt[20], s_tot_bal_amt[20], s_tot_bal_amt1[20];

  if (lctr > 56) print_head();
 
  if(g_tot_print_flag) {
      
      if (nd_no_of_decimal==3)
         sprintf(s_tot_dr_amt,"%16.3f",g_tot_dr_amt);
      else
	 sprintf(s_tot_dr_amt,"%16.2f",g_tot_dr_amt);

      ltrim(s_tot_dr_amt);	  
      //put_comma(s_tot_dr_amt);
      format_amt(s_tot_dr_amt,nd_no_of_decimal);

      if (nd_no_of_decimal==3)
         sprintf(s_tot_cr_amt,"%16.3f",g_tot_cr_amt);
      else
	 sprintf(s_tot_cr_amt,"%16.2f",g_tot_cr_amt);
      ltrim(s_tot_cr_amt);	  
      //put_comma(s_tot_cr_amt);
      format_amt(s_tot_cr_amt,nd_no_of_decimal);

      if (nd_no_of_decimal==3)
         sprintf(s_tot_bal_amt,"%16.3f",g_tot_bal_amt);
      else
	 sprintf(s_tot_bal_amt,"%16.2f",g_tot_bal_amt);
      ltrim(s_tot_bal_amt);	   
      //put_comma(s_tot_bal_amt);
      format_amt(s_tot_bal_amt,nd_no_of_decimal);    

      if (g_tot_bal_amt > 0 )
           fprintf(fp,"\n\n                               GRAND TOTAL  ---------->                          %16s    %16s    %16s\n\n",s_tot_dr_amt,s_tot_cr_amt,s_tot_bal_amt);
      else if (g_tot_bal_amt==0)
           fprintf(fp,"\n\n                               GRAND TOTAL  ---------->                          %16s    %16s    %16s\n\n",s_tot_dr_amt,s_tot_cr_amt,s_tot_bal_amt);
      else
           fprintf(fp,"\n\n                               GRAND TOTAL  ---------->                          %16s    %16s    %16sCR\n\n",s_tot_dr_amt,s_tot_cr_amt,s_tot_bal_amt);
  
      lctr += 2;
      if (lctr > 56) print_head();
  }
 
fprintf(fp,
"\n\n\n                                                      **   END  OF  REPORT   ** \n\n");
  fprintf(fp,"%c@",ESC);
  fflush(fp);
  fclose(fp);
}

declare_cursors()
{
   if (nd_order.arr[0]  =='C')
   {
   /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
             SELECT CUST_CODE, LONG_NAME, CUST_ALPHA_CODE,
                    MISC_CUSTOMER_FLAG
               FROM AR_CUSTOMER
              WHERE CUST_CODE BETWEEN NVL(:nd_fm_cust_code,'        ')
                AND NVL(:nd_to_cust_code,'~~~~~~~~')
			    AND CUST_TYPE_CODE BETWEEN NVL(:nd_fm_cust_type,'  ')
                    AND NVL(:nd_to_cust_type,'~~')
                AND CUST_GROUP_CODE BETWEEN NVL(:nd_fm_cust_group,'  ')
                    AND NVL(:nd_to_cust_group,'~~')
                AND NVL(ANALYSIS_1_CODE,'X')  
                    BETWEEN NVL(:nd_fm_anal_cd1,'        ')
                      AND NVL(:nd_to_anal_cd1,'~~~~~~~~')
                AND NVL(ANALYSIS_2_CODE,'X')
                    BETWEEN NVL(:nd_fm_anal_cd2,'        ')
                      AND NVL(:nd_to_anal_cd2,'~~~~~~~~')
                AND NVL(ANALYSIS_3_CODE,'X')
                    BETWEEN NVL(:nd_fm_anal_cd3,'        ')
                      AND NVL(:nd_to_anal_cd3,'~~~~~~~~')
              ORDER BY CUST_CODE; */ 


   /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )209;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[0] = (unsigned int  )14;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_cust_type;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_cust_type;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_cust_group;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_cust_group;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_anal_cd1;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_anal_cd1;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_anal_cd2;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_anal_cd2;
   sqlstm.sqhstl[9] = (unsigned int  )11;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_fm_anal_cd3;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_to_anal_cd3;
   sqlstm.sqhstl[11] = (unsigned int  )11;
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



   if (ERROR)
         err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");
   }
   else
   {
   /* EXEC SQL DECLARE AR_CUSTOMER_CUR_ALPH CURSOR FOR
             SELECT CUST_CODE, LONG_NAME, CUST_ALPHA_CODE,
                    MISC_CUSTOMER_FLAG
               FROM AR_CUSTOMER
              WHERE CUST_ALPHA_CODE BETWEEN NVL(:nd_fm_alpha_code,'        ')
                AND NVL(:nd_to_alpha_code,'~~~~~~~~')
				AND CUST_TYPE_CODE BETWEEN NVL(:nd_fm_cust_type,'  ')
                    AND NVL(:nd_to_cust_type,'~~')
                AND CUST_GROUP_CODE BETWEEN NVL(:nd_fm_cust_group,'  ')
                    AND NVL(:nd_to_cust_group,'~~')
                AND NVL(ANALYSIS_1_CODE,'X')
                    BETWEEN NVL(:nd_fm_anal_cd1,'        ')
                      AND NVL(:nd_to_anal_cd1,'~~~~~~~~')
                AND NVL(ANALYSIS_2_CODE,'X')
                    BETWEEN NVL(:nd_fm_anal_cd2,'        ')
                      AND NVL(:nd_to_anal_cd2,'~~~~~~~~')
                AND NVL(ANALYSIS_3_CODE,'X')
                    BETWEEN NVL(:nd_fm_anal_cd3,'        ')
                      AND NVL(:nd_to_anal_cd3,'~~~~~~~~')
              ORDER BY CUST_ALPHA_CODE,CUST_CODE; */ 


   /* EXEC SQL OPEN AR_CUSTOMER_CUR_ALPH; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )272;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_alpha_code;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_alpha_code;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_cust_type;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_cust_type;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_cust_group;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_cust_group;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_anal_cd1;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_anal_cd1;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_anal_cd2;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_anal_cd2;
   sqlstm.sqhstl[9] = (unsigned int  )11;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_fm_anal_cd3;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_to_anal_cd3;
   sqlstm.sqhstl[11] = (unsigned int  )11;
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



   if (ERROR)
         err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR_ALPH",0,"");
   }

   /* EXEC SQL DECLARE AR_CUST_TRN_CUR CURSOR FOR
             SELECT ORG_DOC_TYPE_CODE, ORG_DOC_NUM,
                    DOC_TYPE_CODE, DOC_NUM,
                    TO_CHAR(DOC_DATE,'YYYYMMDD'),
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    CUST_REF, AMOUNT, AMOUNT,
                    NARRATION,
					LTRIM(TO_CHAR(NVL(POST_MONTH,0),'09')),
					NVL(POST_YEAR,0)
               FROM AR_CUST_TRN
              WHERE CUST_CODE = :ar_customer_cust_code 
			  /o
			  AND
			         LTRIM(TO_CHAR(POST_YEAR,'0009'))||
					 LTRIM(TO_CHAR(POST_MONTH,'09'))
					 BETWEEN 
					 LTRIM(TO_CHAR(:nd_fm_post_year,'0009'))||
					 LTRIM(TO_CHAR(:nd_fm_post_month,'09'))
					 AND
					 LTRIM(TO_CHAR(:nd_to_post_year,'0009'))||
					 LTRIM(TO_CHAR(:nd_to_post_month,'09'))
					 o/
              ORDER BY POST_YEAR,POST_MONTH,
					DOC_DATE,DOC_TYPE_CODE,DOC_NUM; */ 


   /* EXEC SQL DECLARE AR_PENDING_CUR CURSOR FOR
             SELECT TO_CHAR(BASE_DATE,'DD/MM/YYYY'),
                    TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                    MISC_CUST_LONG_NAME
               FROM AR_PENDING_DOC
              WHERE CUST_CODE     = :ar_customer_cust_code
		AND DOC_TYPE_CODE = :cust_org_doc_type_code
                AND DOC_NUM       = :cust_org_doc_num; */ 


}

open_cust_trn()
{
   /* EXEC SQL OPEN AR_CUST_TRN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )335;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
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


 
   if (ERROR)
         err_mesg("OPEN failed on cursor AR_CUST_TRN_CUR",0,"");
}

fetch_customer()
{

ar_customer_cust_code.arr     [0] = '\0';
ar_customer_long_name.arr     [0] = '\0';
ar_cust_alpha_code.arr        [0] = '\0';
ar_misc_customer_flag.arr     [0] = '\0';

ar_customer_cust_code.len         = 0;
ar_customer_long_name.len         = 0;
ar_cust_alpha_code.len            = 0;
ar_misc_customer_flag.len         = 0;

   if (nd_order.arr[0]  =='C')
   {
       /* EXEC SQL FETCH AR_CUSTOMER_CUR
                 INTO :ar_customer_cust_code, :ar_customer_long_name,
                      :ar_cust_alpha_code,:ar_misc_customer_flag; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 25;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )354;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
       sqlstm.sqhstl[0] = (unsigned int  )11;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&ar_customer_long_name;
       sqlstm.sqhstl[1] = (unsigned int  )103;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&ar_cust_alpha_code;
       sqlstm.sqhstl[2] = (unsigned int  )13;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&ar_misc_customer_flag;
       sqlstm.sqhstl[3] = (unsigned int  )4;
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



       if (ERROR)
             err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");
    }
    else
    {
       /* EXEC SQL FETCH AR_CUSTOMER_CUR_ALPH
                 INTO :ar_customer_cust_code, :ar_customer_long_name,
                      :ar_cust_alpha_code,:ar_misc_customer_flag; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 25;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )385;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
       sqlstm.sqhstl[0] = (unsigned int  )11;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&ar_customer_long_name;
       sqlstm.sqhstl[1] = (unsigned int  )103;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&ar_cust_alpha_code;
       sqlstm.sqhstl[2] = (unsigned int  )13;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&ar_misc_customer_flag;
       sqlstm.sqhstl[3] = (unsigned int  )4;
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



       if (ERROR)
             err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR_ALPH",0,"");
     }

ar_customer_cust_code.arr[ar_customer_cust_code.len] = '\0';
ar_customer_long_name.arr[ar_customer_long_name.len] = '\0';
ar_cust_alpha_code.arr[ar_cust_alpha_code.len]       = '\0';
ar_misc_customer_flag.arr[ar_misc_customer_flag.len] = '\0';

if (LAST_ROW)
   return(0);
else
   return(1);
}

fetch_cust_trn()
{
   cust_org_doc_type_code.arr    [0] = '\0';
   cust_org_doc_num.arr          [0] = '\0';
   cust_doc_type_code.arr        [0] = '\0';
   cust_doc_num.arr              [0] = '\0';
   cust_doc_date.arr             [0] = '\0';
   doc_date_prn.arr              [0] = '\0';
   cust_ref.arr                  [0] = '\0';
   cust_amount.arr               [0] = '\0';
   cust_narration.arr            [0] = '\0';

   cust_org_doc_type_code.len        = 0;
   cust_org_doc_num.len              = 0;
   cust_doc_type_code.len            = 0;
   cust_doc_num.len                  = 0;
   cust_doc_date.len                 = 0;
   doc_date_prn.len                  = 0;
   cust_ref.len                      = 0;
   cust_amount.len                   = 0;
   cust_narration.len                = 0;

   amount   = 0;

   /* EXEC SQL FETCH AR_CUST_TRN_CUR
             INTO :cust_org_doc_type_code, :cust_org_doc_num,
                  :cust_doc_type_code, :cust_doc_num,
                  :cust_doc_date, :doc_date_prn, :cust_ref, :cust_amount,
                  :amount, :cust_narration,
				  :nd_post_month,
				  :nd_post_year; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )416;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&cust_org_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&cust_org_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&cust_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&cust_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&cust_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )15;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&doc_date_prn;
   sqlstm.sqhstl[5] = (unsigned int  )15;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&cust_ref;
   sqlstm.sqhstl[6] = (unsigned int  )18;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&cust_amount;
   sqlstm.sqhstl[7] = (unsigned int  )19;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&amount;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&cust_narration;
   sqlstm.sqhstl[9] = (unsigned int  )53;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_post_month;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_post_year;
   sqlstm.sqhstl[11] = (unsigned int  )7;
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



   if (ERROR)
         err_mesg("FETCH failed on cursor AR_CUST_TRN",0,"");

   cust_org_doc_type_code.arr[cust_org_doc_type_code.len] = '\0';
   cust_org_doc_num.arr[cust_org_doc_num.len]             = '\0';
   cust_doc_type_code.arr[cust_doc_type_code.len]         = '\0';
   cust_doc_num.arr[cust_doc_num.len]                     = '\0';
   cust_doc_date.arr[cust_doc_date.len]                   = '\0';
   doc_date_prn.arr[doc_date_prn.len]                     = '\0';
   cust_ref.arr[cust_ref.len]                             = '\0';
   cust_amount.arr[cust_amount.len]                       = '\0';
   cust_narration.arr[cust_narration.len]                 = '\0';

   nd_post_month.arr[nd_post_month.len]                       = '\0';
   nd_post_year.arr[nd_post_year.len]                       = '\0';

   cust_trn_ctr++;

if (LAST_ROW)
   return(0);
else
   return(1);

}

fetch_ar_pending_doc()
{

   /* EXEC SQL OPEN AR_PENDING_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )479;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
   sqlstm.sqhstl[0] = (unsigned int  )11;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&cust_org_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&cust_org_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
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



   if (ERROR)
         err_mesg("OPEN failed on cursor AR_PENDING_CUR",0,"");

   base_date.arr[0] = '\0';
   due_date.arr[0]  = '\0';
   misc_name.arr[0] = '\0';

   base_date.len    = 0;
   due_date.len     = 0;
   misc_name.len    = 0;

   /* EXEC SQL FETCH AR_PENDING_CUR
             INTO :base_date,
                  :due_date,
                  :misc_name; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )506;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&base_date;
   sqlstm.sqhstl[0] = (unsigned int  )15;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&due_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&misc_name;
   sqlstm.sqhstl[2] = (unsigned int  )102;
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


   if (ERROR)
         err_mesg("FETCH failed on cursor AR_PENDING_CUR",0,"");

   base_date.arr[base_date.len] = '\0';
   due_date.arr[due_date.len]   = '\0';
   misc_name.arr[misc_name.len] = '\0';

}


print_details()
{
  char out_str[35],out_str1[35],misc_flag;
 
  if (lctr > 56) print_head();

  if (strcmp(cust_doc_type_code.arr,cust_org_doc_type_code.arr) == 0 &&
         strcmp(cust_doc_num.arr,cust_org_doc_num.arr) == 0)
          misc_flag = 'Y';
  else
          misc_flag = 'N';

 

  fprintf(fp,"%-10s %6s/%-8.8s %-50.50s",
doc_date_prn.arr,cust_doc_type_code.arr,cust_doc_num.arr,cust_narration.arr);

   if (amount > 0)
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%16.3f",amount);
      else 
	 sprintf(out_str,"%16.2f",amount);
      ltrim(out_str);	  
      //put_comma(out_str);
      format_amt(out_str,nd_no_of_decimal);

      sprintf(out_str1,"%20s",out_str);
      fprintf(fp,"%-20s",out_str1);
      fprintf(fp,"%20s"," ");
      g_tot_dr_amt += amount;
   }
   else
   {
      fprintf(fp,"%20s"," ");
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%16.3f",-amount);
      else
	 sprintf(out_str,"%16.2f",-amount);

      ltrim(out_str);	  
      //put_comma(out_str);
      format_amt(out_str,nd_no_of_decimal);

      sprintf(out_str1,"%20s",out_str);
      fprintf(fp,"%-20s",out_str1);
      g_tot_cr_amt += -amount;
   }

if (running_amt >= 0)
{
   if (nd_no_of_decimal==3)
     sprintf(out_str,"%16.3f",running_amt);
   else
     sprintf(out_str,"%16.2f",running_amt);
   ltrim(out_str);   
   //put_comma(out_str);
   format_amt(out_str,nd_no_of_decimal);

   sprintf(out_str1,"%20s",out_str);
   fprintf(fp,"%-20s\n",out_str1);
}
else
{
   if (nd_no_of_decimal==3)
      sprintf(out_str,"%16.3f",-running_amt);
   else
      sprintf(out_str,"%16.2f",-running_amt);

   ltrim(out_str);   
   //put_comma(out_str);
   format_amt(out_str,nd_no_of_decimal);

   sprintf(out_str1,"%20s",out_str);
   fprintf(fp,"%-20sCR\n",out_str1);
}



/*
&DOC_DATE &DOC_TYPE_CODE &DOC_NUM &ND_DUE_DATE &CUST_REF &ND_REF_DATE &ND_DEBIT &ND_CREDIT &AMOUNT
*/
  /*lctr ++;

  if (lctr > 56) print_head();
  fprintf(fp,"           NARRATION : %-50.50s",cust_narration.arr);*/


  /*if  (strcmp(cust_doc_type_code.arr,cust_org_doc_type_code.arr) &&
       strcmp(cust_doc_num.arr,cust_org_doc_num.arr))
  {
      fprintf(fp,"   ORG DOC TYPE/NUM  : %s/%s\n",
                     cust_org_doc_type_code.arr,cust_org_doc_num.arr);
  }
  else
      fprintf(fp,"\n");
  lctr ++;
  if (lctr > 56) print_head();
  if (ar_misc_customer_flag.arr[0] == 'Y')
  {
     fprintf(fp,"           MISC NAME : %-40.40s\n",misc_name.arr);
     lctr ++;
  }*/
  fprintf(fp,"\n");
  lctr ++;
}

print_header()
{
  char out_str[200],out_str1[200];

  if (lctr > 56) print_head();

fprintf(fp,"\nCUSTOMER : %-8s %-40.40s %-10s\n",
ar_customer_cust_code.arr, ar_customer_long_name.arr, ar_cust_alpha_code.arr);

strcpy(cust_print_flag.arr , "Y");


/*
&CUST_CODE &LONG_NAME &CUST_ALPHA_CODE
*/
fprintf(fp,
"\n                                                OPENING BALANCE AS OF %-2s/%-4s        --------->                      ",
pfm.arr,pfy.arr);
if (opening_amt >= 0)
{
   if (nd_no_of_decimal==3)
      sprintf(out_str,"%17.3f",opening_amt);
   else
      sprintf(out_str,"%17.2f",opening_amt);
   ltrim(out_str);   
   //put_comma(out_str);
   format_amt(out_str,nd_no_of_decimal);

   sprintf(out_str1,"%20s",out_str);
   fprintf(fp,"%-20s\n\n",out_str1);
}
else
{
   if (nd_no_of_decimal==3)
      sprintf(out_str,"%17.3f",-opening_amt);
   else 
      sprintf(out_str,"%17.2f",-opening_amt);

   ltrim(out_str);   
   //put_comma(out_str);
   format_amt(out_str,nd_no_of_decimal);

   sprintf(out_str1,"%20s",out_str);
   fprintf(fp,"%-20sCR\n\n",out_str1);
}
  lctr += 5;
}

print_footer()
{

  char out_str[200],out_str1[200];

  if (lctr > 56) print_head();
fprintf(fp,
"\n                                                CLOSING BALANCE AS OF %-2s/%-4s        --------->                      ",
ptm.arr,pty.arr);

if (running_amt >= 0)
{
    if (nd_no_of_decimal==3)
      sprintf(out_str,"%17.3f",running_amt);
    else
      sprintf(out_str,"%17.2f",running_amt);

    ltrim(out_str);	
    //put_comma(out_str);
    format_amt(out_str,nd_no_of_decimal);

    sprintf(out_str1,"%20s",out_str);
    fprintf(fp,"%-20s\n",out_str1);
}
else
{
    if (nd_no_of_decimal==3)
       sprintf(out_str,"%17.3f",-running_amt);
    else
       sprintf(out_str,"%17.2f",-running_amt);

    ltrim(out_str);	
    //put_comma(out_str);
    format_amt(out_str,nd_no_of_decimal);

    sprintf(out_str1,"%20s",out_str);
    fprintf(fp,"%-20sCR\n",out_str1);
}

g_tot_bal_amt += running_amt;

strcpy(cust_print_flag.arr , "N");

fprintf(fp,"\n\n");

  lctr += 4;

  

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


void print_hospital_name(nd_rep_width    ,
                         nd_mod_id       ,
                         nd_hospital_name,
                         nd_date          )
int  nd_rep_width;
char nd_mod_id[3];
char nd_hospital_name[31];
char nd_date[17];
{
	int i = 0 , pos = 0 , len = 0, len_date = 0 , pos_date = 0, len1=0;

    /*Find the length of Hospital Name*/
    for(len = 0; nd_hospital_name[len] != '\0'; len++);

    /*Find the length of Date*/
    for(len_date = 0; nd_date[len_date] != '\0'; len_date++);

    len1=(len % 2);
    if (len1==0)
       len1=9;
    else
       len1=10;

    len = len / 2;

    pos = (nd_rep_width / 2	) - len;

	pos_date = nd_rep_width - len_date;

	fprintf(fp,"MDL : %2s",nd_mod_id);

	for(i = len1; i < pos ; fprintf(fp," "),i++);

	fprintf(fp,"%s",nd_hospital_name);

	for(i = i + (len * 2) ; i < pos_date + 1; fprintf(fp," "),i++);

    fprintf(fp,"%s\n",nd_date);
}


sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )533;
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

/*put_comma(str)
char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10];
  strcpy(arr,str);
  strncpy(l_str1,arr + (strlen(arr) - 2),2);
  l_str1[2] = '\0';
  arr[strlen(str)-3] = '\0';
  i = strlen(arr);
  j = i;
  k = j/3;
  l = k;
  m = i - (l*3);
  if (i > 3)
  {
      for (a=0;a<m;a++)
         o_arr[a] = arr[a];
   if (m)
   {
     o_arr[m] = ','; b=m+1;
   }
   else b = m;
  for (c=1,a=m;arr[a]!= '\0';a++,b++)
  {
     o_arr[b] = arr[a]; 
     c++;
     if (c > 3 && arr[a+1] != '\0')
     {
       o_arr[++b] = ','; c = 1;
     }
   }
   o_arr[b] = '\0';
  }
  else
      strcpy(o_arr,arr);
   sprintf(str,"%s.%s",o_arr,l_str1);
} */
