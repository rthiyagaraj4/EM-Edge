
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
    "C:\\AR10.2\\arractsm.pc"
};


static unsigned long sqlctx = 141983475;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {10,11};

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
"select A.CUST_CODE ,A.SHORT_NAME ,sum(NVL(B.AMOUNT,0)) ,B.TRN_TYPE_CODE  fro\
m AR_CUSTOMER A ,AR_CUST_TRN B where (((A.CUST_CODE=B.CUST_CODE(+) and (LTRIM(\
TO_CHAR(B.POST_YEAR(+),'0009'))||LTRIM(TO_CHAR(B.POST_MONTH(+),'09'))) between\
 (:b0||:b1) and (:b2||:b3)) and A.CUST_CODE(+) between :b4 and :b5) and B.DOC_\
DATE(+) between TO_DATE(:b6,'YYYYMMDD') and TO_DATE(:b7,'YYYYMMDD')) group by \
A.CUST_CODE,A.SHORT_NAME,B.TRN_TYPE_CODE order by A.CUST_CODE,B.TRN_TYPE_CODE \
           ";

 static const char *sq0006 = 
"select NVL(sum(AMOUNT),0)  from AR_CUST_TRN where (CUST_CODE=:b0 and (POST_Y\
EAR<:b1 or (POST_YEAR=:b1 and POST_MONTH<:b3)))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,282,0,4,198,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
64,0,0,2,249,0,4,256,0,0,9,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,3,0,0,1,9,0,0,
115,0,0,3,91,0,2,333,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
138,0,0,4,0,0,30,345,0,0,0,0,0,1,0,
153,0,0,5,477,0,9,562,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
200,0,0,6,134,0,9,571,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
231,0,0,5,0,0,13,600,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
262,0,0,6,0,0,13,635,0,0,1,0,0,1,0,2,4,0,0,
281,0,0,7,0,0,27,1230,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
312,0,0,5,0,0,15,1240,0,0,0,0,0,1,0,
};


/* Date :- 10-Jun-2002  */

#include <stdio.h>
#include <string.h>
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
		   xm			[3],
		   xy			[5],
		   xfm			[3],
		   xfy			[5],
		   xtm			[3],
		   xty			[5],
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

struct { unsigned short len; unsigned char arr[3]; } xm;

struct { unsigned short len; unsigned char arr[5]; } xy;

struct { unsigned short len; unsigned char arr[3]; } xfm;

struct { unsigned short len; unsigned char arr[5]; } xfy;

struct { unsigned short len; unsigned char arr[3]; } xtm;

struct { unsigned short len; unsigned char arr[5]; } xty;

struct { unsigned short len; unsigned char arr[8]; } fm_ym;

struct { unsigned short len; unsigned char arr[8]; } to_ym;

struct { unsigned short len; unsigned char arr[8]; } p_ym;

struct { unsigned short len; unsigned char arr[3]; } nd_post_month;

struct { unsigned short len; unsigned char arr[5]; } nd_post_year;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;


   /* VARCHAR nd_facility_id                [3],
		   nd_session_id                 [16],
           nd_fm_cust_code               [12],
           nd_to_cust_code               [12],
		   fmcust						 [9],
		   tocust						 [9],
		   fmalpha						 [11],
		   toalpha						 [11],
           nd_fm_alpha_code              [11],
           nd_to_alpha_code              [11],
           nd_fm_doc_date                [13],
           nd_to_doc_date                [13],
		   nd_report_type				 [2],
           nd_order                      [11]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[12]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[9]; } fmcust;

struct { unsigned short len; unsigned char arr[9]; } tocust;

struct { unsigned short len; unsigned char arr[11]; } fmalpha;

struct { unsigned short len; unsigned char arr[11]; } toalpha;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_alpha_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_alpha_code;

struct { unsigned short len; unsigned char arr[13]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[2]; } nd_report_type;

struct { unsigned short len; unsigned char arr[11]; } nd_order;


   /* VARCHAR ar_customer_cust_code         [9],
           ar_customer_long_name         [16],
           ar_cust_alpha_code            [11],
           ar_misc_customer_flag         [2],
		   ar_trn_type_code              [2],  
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
		   ar_customer_old_code          [9],
		   ar_customer_old_name          [16]; */ 
struct { unsigned short len; unsigned char arr[9]; } ar_customer_cust_code;

struct { unsigned short len; unsigned char arr[16]; } ar_customer_long_name;

struct { unsigned short len; unsigned char arr[11]; } ar_cust_alpha_code;

struct { unsigned short len; unsigned char arr[2]; } ar_misc_customer_flag;

struct { unsigned short len; unsigned char arr[2]; } ar_trn_type_code;

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

struct { unsigned short len; unsigned char arr[9]; } ar_customer_old_code;

struct { unsigned short len; unsigned char arr[16]; } ar_customer_old_name;


   /* VARCHAR p_language_id				 [4]; */ 
struct { unsigned short len; unsigned char arr[4]; } p_language_id;



   double  ar_amount,
           running_amt,
		   ar_close_bal,
           opening_amt,
		   ar_open_bal,
		   tot_db_amt,
		   tot_cr_amt;
   
   int nd_fm_post_month,
	   nd_fm_post_year,
	   nd_to_post_month,
	   nd_no_of_decimal,
	   nd_to_post_year;

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
int lctr = 0,pctr =0,cust_trn_ctr = 0, fctr =0;

int open_print_flag = 0;


double 
	   ar_inv_amt,
	   ar_dn_amt,
	   ar_cn_amt,
	   ar_adj_amt,
	   ar_rec_amt,
	   ar_ref_amt,
	   ar_temp_tot,
	   g_ar_inv_amt,
	   g_ar_dn_amt,
	   g_ar_cn_amt,
	   g_ar_adj_amt,
	   g_ar_rec_amt,
	   g_ar_ref_amt,
	   ar_pg_tot_amt,
	   g_tot_dr_amt,
       g_tot_cr_amt,
	   g_ar_open_bal,
	   g_ar_close_bal,
	   g_ar_pg_tot_amt,
       g_tot_bal_amt,
	   amount;

int    g_tot_print_flag;

char filename[150];
char string_var [200];

char pm[3];
char py[5];
char t_cust[9];
void proc_main(argc,argv)
char *argv[];
int argc;
{
   strcpy(filename,WORKING_DIR);
   strcpy(OUTPUT_FILE_NAME,argv[5]);

   //strcat(filename,"arractsm.lis");
   strcat(filename,OUTPUT_FILE_NAME);

   if (argc != 6)
   {
     disp_message(ERR_MESG,"Not enough Parameters for running this program");
     proc_exit();
   }


   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"ARRACTSM");

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
                   NVL(PARAM3,'18000101'),
                   NVL(PARAM4,'47121231'),
				   PARAM5,
				   PARAM6,
				   PARAM7,
				   PARAM8
              INTO :nd_facility_id,
				   :nd_fm_cust_code,
                   :nd_to_cust_code,
                   :nd_fm_doc_date,
                   :nd_to_doc_date,
				   :xfm,
				   :xfy,
				   :xtm,
				   :xty
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRACTSM'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,NVL(PARAM1,'!!!!!!!!') ,NVL(\
PARAM2,'~~~~~~~~') ,NVL(PARAM3,'18000101') ,NVL(PARAM4,'47121231') ,PARAM5 ,PA\
RAM6 ,PARAM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from SY_PROG_PA\
RAM where ((PGM_ID='ARRACTSM' and SESSION_ID=:b9) and PGM_DATE=:b10)";
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
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )15;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )15;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&xfm;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&xfy;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&xtm;
   sqlstm.sqhstl[7] = (unsigned int  )5;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&xty;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[10] = (unsigned int  )37;
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

   xfm.arr[xfm.len]        = '\0';
   xfy.arr[xfy.len]        = '\0';
   xtm.arr[xtm.len]        = '\0';
   xty.arr[xty.len]        = '\0';

   start_prog_msg();

   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';
   open_bal_date.arr[0]  = '\0';
   close_bal_date.arr[0] = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;
   open_bal_date.len  = 0;
   close_bal_date.len = 0;

   /* EXEC SQL SELECT ACC_ENTITY_NAME , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   USER,
                   TO_CHAR(TO_DATE(:nd_fm_doc_date,'YYYYMMDD'),'DD/MM/YYYY'),
                   TO_CHAR(TO_DATE(:nd_to_doc_date,'YYYYMMDD'),'DD/MM/YYYY'),
		   NO_OF_DECIMAL
              INTO :hosp_name, :date_time, :user_id,
                   :open_bal_date, :close_bal_date,:nd_no_of_decimal
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER ,TO_CHAR(TO_DATE(:b0,'YYYYMMDD'),'DD/MM/YYYY') ,TO_CHAR(TO_DATE(:b1,\
'YYYYMMDD'),'DD/MM/YYYY') ,NO_OF_DECIMAL into :b2,:b3,:b4,:b5,:b6,:b7  from SY\
_ACC_ENTITY where ACC_ENTITY_ID=:b8";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )64;
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

   ar_amount   = 0;
   ar_inv_amt = ar_dn_amt = ar_cn_amt = ar_adj_amt = 0;
   ar_rec_amt = ar_ref_amt = 0;
   g_ar_inv_amt = g_ar_dn_amt = g_ar_cn_amt = ar_adj_amt = 0;
   g_ar_rec_amt = g_ar_ref_amt = 0;
   ar_pg_tot_amt = g_ar_open_bal = g_ar_close_bal = g_ar_pg_tot_amt = 0;
   ar_open_bal = ar_close_bal = fctr = ar_temp_tot = 0;

   open_files();   
   
   declare_cursors();

   open_ar_cust_trn();

/*-------------------------------------------*/             
    while(fetch_cust_trn())
    {
		     
		if (lctr > 56) print_head();

/*			fprintf(fp,
			"%-10s  %-41s%-10s ",
			ar_customer_cust_code.arr,ar_customer_long_name.arr); */


		if (fctr < 1) 
		{ 
			 strcpy(ar_customer_old_code.arr,ar_customer_cust_code.arr);
			 
             strcpy(ar_customer_old_name.arr,ar_customer_long_name.arr);
			 fctr = 99;
			 op_open_bal_cur();
			 fetch_open_bal();
		}

        

	   if (strcmp(ar_customer_cust_code.arr, ar_customer_old_code.arr) != 0 ) 

		  { 	
	        print_details();
			op_open_bal_cur();
			fetch_open_bal();
			strcpy(ar_customer_old_code.arr,ar_customer_cust_code.arr);
			strcpy(ar_customer_old_name.arr,ar_customer_long_name.arr);
			cal_total();
	       }

       else
	   if (strcmp(ar_customer_cust_code.arr, ar_customer_old_code.arr) == 0 ) 
           cal_total();	   	   
   
      }
	     
        print_footer();
    
    print_end();

    /* EXEC SQL DELETE FROM SY_PROG_PARAM
                   WHERE PGM_ID     = 'ARRACTSM'
                     AND SESSION_ID = :nd_session_id
                     AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRACTSM' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )115;
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

	close_cur();
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )138;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return;
}

cal_total()
 {
			  ar_pg_tot_amt += ar_amount;
 
			  if (strcmp(ar_trn_type_code.arr,"1") == 0)

			  {
				ar_inv_amt += ar_amount;

		  
				g_ar_inv_amt += ar_amount;
              }
			  if (strcmp(ar_trn_type_code.arr,"2") == 0)
			  {

			    ar_dn_amt += ar_amount;
				g_ar_dn_amt += ar_amount;
			  }
			  if (strcmp(ar_trn_type_code.arr,"3") == 0)
			  {
				ar_cn_amt += ar_amount;
				g_ar_cn_amt += ar_amount;
			  }
    		  if (strcmp(ar_trn_type_code.arr,"4") == 0)
			  {
				ar_adj_amt += ar_amount;
				g_ar_adj_amt += ar_amount;
			  }
			  if 	 (strcmp(ar_trn_type_code.arr,"5") == 0)
			  {
				ar_rec_amt += ar_amount;
				g_ar_rec_amt += ar_amount;
			  }
			  if 	 (strcmp(ar_trn_type_code.arr,"6") == 0)
			  {
				ar_ref_amt += ar_amount;
				g_ar_ref_amt += ar_amount;
			  }
 		 

  }
       

open_files()
{
   char   text_mesg[101]; 

   if ((fp = fopen(filename,"w")) == NULL)
   {
        
		sprintf(text_mesg,"Error While Opening File %s",filename);
		err_mesg(text_mesg,0,"");
		//err_mesg("\nError while opening File arractsm.lis\n",0,"");
        proc_exit();
   }

   print_title();
   print_head();

}

print_title()
{  
  char nd_open_bal_date[10], nd_close_bal_date[10];     
  void print_hospital_name();
  /*
  fprintf(fp,
"\n\nMDL : AR                                                                  %-30s                                                                  %-16s\n",
      hosp_name.arr,date_time.arr);
  */
   fprintf(fp,"%cg",ESC);
   print_hospital_name(203,"AR",hosp_name.arr,date_time.arr);

     fprintf(fp,"OPR : %-10s \n", user_id.arr);
  fprintf(fp,
"REP : %-8s                                                                      %-28s                                                                       PAGE : %4d\n",
    g_pgm_id,"DEBTOR'S ACTIVITY - SUMMARY BY PERIOD",++pctr);
fprintf(fp,
"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
//fprintf(fp,"VER : 1.10.01\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
//printf(fp,"                REPORT ORDER         : %s\n\n",

if(strcmp(nd_fm_cust_code.arr,"!!!!!!!!")== 0)
   strcpy(fmcust.arr,"LOWEST");
else
   strcpy(fmcust.arr,nd_fm_cust_code.arr);
if(strcmp(nd_to_cust_code.arr,"~~~~~~~~")== 0)
   strcpy(tocust.arr,"HIGHEST");
else
   strcpy(tocust.arr,nd_to_cust_code.arr);


if (strcmp(open_bal_date.arr , "01/01/1800") == 0)
	strcpy(nd_open_bal_date,"LOWEST");
  else
	strcpy(nd_open_bal_date,open_bal_date.arr);

  if (strcmp(close_bal_date.arr , "31/12/4712") == 0)
	strcpy(nd_close_bal_date,"HIGHEST");
  else
	strcpy(nd_close_bal_date,close_bal_date.arr);



fprintf(fp,"                 CUSTOMER CODE FROM  : %-10s\n",fmcust.arr);
fprintf(fp,"                               TO    : %-10s\n\n",tocust.arr);


fprintf(fp,"                 DOCUMENT DATE FROM  : %-10s\n",nd_open_bal_date);
fprintf(fp,"                               TO    : %-10s\n\n",nd_close_bal_date);

fprintf(fp,"               POST MONTH/YEAR FROM  : %-2s/%-5s\n",xfm.arr,xfy.arr);
fprintf(fp,"                               TO    : %-2s/%-5s\n\n",xtm.arr,xty.arr);

/*------------------------------------------------------------------------------*/
  fflush(fp);
}

print_head()
{
  void print_hospital_name(); 
  /*
  fprintf(fp,
"\fMDL : AR                                                                    %-30s                                                                                    %-16s\n",
      hosp_name.arr,date_time.arr);
  */
   fprintf(fp,"\f");
   fprintf(fp,"%cg",ESC);
   print_hospital_name(203,"AR",hosp_name.arr,date_time.arr);


     fprintf(fp,"OPR : %-10s \n", user_id.arr);
  fprintf(fp,
"REP : %-8s                                                                      %-28s                                                                       PAGE : %4d\n",
    g_pgm_id,"DEBTOR'S ACTVITY  - SUMMARY BY PERIOD",++pctr);
  fprintf(fp,
"                                                                                    FOR THE PERIOD FROM %s/%s TO %s/%s\n",
   xfm.arr,xfy.arr,xtm.arr,xty.arr);

fprintf(fp,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"CUSTOMER    CUSTOMER NAME              OPENING BALANCE       INVOICES        DEBIT NOTES       CREDIT NOTES        ADJUSTMENTS           RECEIPTS            REFUNDS              TOTAL     CLOSING BALANCE\n");
fprintf(fp,"CODE                                   AS OF %-2s/%-4s                                                                                                                                         AS OF %-2s/%-4s \n",xfm.arr,xfy.arr,xtm.arr,xty.arr);
fprintf(fp,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
  fflush(fp);
  lctr = 10;
}

print_end()
{

 
//  if (lctr > 56) print_head();

 

fprintf(fp,
"\n\n\n                                                                                          **   END  OF  REPORT   ** \n\n");
  fprintf(fp,"%c@",ESC);
  fflush(fp);
  fclose(fp);
}

declare_cursors()
{


   /* EXEC SQL DECLARE  AR_CUST_TRN_CUR CURSOR FOR
             SELECT  A.CUST_CODE,
			         A.SHORT_NAME,
					 SUM(NVL(B.AMOUNT,0)), 
                     B.TRN_TYPE_CODE
               FROM 
					 AR_CUSTOMER A,
					 AR_CUST_TRN B
              WHERE  A.CUST_CODE = B.CUST_CODE (+) AND
			         LTRIM(TO_CHAR(B.POST_YEAR (+) ,'0009'))||
					 LTRIM(TO_CHAR(B.POST_MONTH (+) ,'09'))
					 BETWEEN 
					 :xfy||:xfm
					 AND
					 :xty||:xtm
					 AND
					 A.CUST_CODE (+)  BETWEEN 
					 :nd_fm_cust_code AND :nd_to_cust_code  
					 AND  
					 B.DOC_DATE (+) BETWEEN
                     TO_DATE(:nd_fm_doc_date,'YYYYMMDD') 
                     AND
					 TO_DATE(:nd_to_doc_date, 'YYYYMMDD')
			  GROUP BY 
			         A.CUST_CODE,
			         A.SHORT_NAME,
					 B.TRN_TYPE_CODE 
              ORDER BY 
			         A.CUST_CODE,
					 B.TRN_TYPE_CODE; */ 



   /* EXEC SQL DECLARE OPEN_BAL_CUR CURSOR FOR
	    SELECT  NVL(SUM(AMOUNT),0)
	    FROM    AR_CUST_TRN
	    WHERE   CUST_CODE = :ar_customer_cust_code
	    AND     ((POST_YEAR < :xfy) OR
		(POST_YEAR = :xfy AND POST_MONTH < :xfm)); */ 


 
}

open_ar_cust_trn()
{
    /* EXEC SQL OPEN AR_CUST_TRN_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )153;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&xfy;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&xfm;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&xty;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&xtm;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fm_cust_code;
    sqlstm.sqhstl[4] = (unsigned int  )14;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_cust_code;
    sqlstm.sqhstl[5] = (unsigned int  )14;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[6] = (unsigned int  )15;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[7] = (unsigned int  )15;
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


 
   if (ERROR)
         err_mesg("OPEN failed on cursor AR_CUST_TRN_CUR",0,"");

}

op_open_bal_cur()
{
   /* EXEC SQL OPEN OPEN_BAL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )200;
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
   sqlstm.sqhstv[1] = (         void  *)&xfy;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&xfy;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&xfm;
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


    if (ERROR)
         err_mesg("OPEN failed on cursor OPEN_BAL_CUR",0,"");
}


fetch_cust_trn()
{
   ar_customer_cust_code.arr[0] = '\0';
   ar_customer_long_name.arr[0] = '\0';
   ar_trn_type_code.arr[0]      = '\0';
   cust_doc_num.arr[0]          = '\0';
   cust_doc_date.arr[0]         = '\0';
   doc_date_prn.arr[0]          = '\0';
   cust_ref.arr[0]              = '\0';
   cust_amount.arr[0]           = '\0';
   cust_narration.arr[0]        = '\0';

   ar_customer_cust_code.len    = 0;
   ar_customer_long_name.len    = 0;
   ar_trn_type_code.len         = 0;
   cust_doc_num.len             = 0;
   cust_doc_date.len            = 0;
   doc_date_prn.len             = 0;
   cust_ref.len                 = 0;
   cust_amount.len              = 0;
   cust_narration.len           = 0;
   ar_amount					= 0;

   /* EXEC SQL FETCH AR_CUST_TRN_CUR
             INTO :ar_customer_cust_code,
                  :ar_customer_long_name,
				  :ar_amount,
                  :ar_trn_type_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )231;
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
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_amount;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_trn_type_code;
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
         err_mesg("FETCH failed on cursor AR_CUST_TRN",0,"");

   ar_customer_cust_code.arr[ar_customer_cust_code.len]   = '\0';
   ar_customer_long_name.arr[ar_customer_long_name.len]   = '\0';
   ar_trn_type_code.arr[ar_trn_type_code.len]             = '\0';
   cust_doc_num.arr[cust_doc_num.len]                     = '\0';
   cust_doc_date.arr[cust_doc_date.len]                   = '\0';
   doc_date_prn.arr[doc_date_prn.len]                     = '\0';
   cust_ref.arr[cust_ref.len]                             = '\0';
   cust_amount.arr[cust_amount.len]                       = '\0';
   cust_narration.arr[cust_narration.len]                 = '\0';
   nd_post_month.arr[nd_post_month.len]                   = '\0';
   nd_post_year.arr[nd_post_year.len]                     = '\0';
   

if (LAST_ROW)
   return(0);
else
   return(1);

}

fetch_open_bal()
{
    ar_open_bal = 0;

    /* EXEC SQL FETCH OPEN_BAL_CUR 
	     INTO  :ar_open_bal; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )262;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&ar_open_bal;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
	err_mesg("FETCH failed on cursor OPEN_BAL_CUR",0,"");

    g_ar_open_bal += ar_open_bal; 


}
 
print_details()
{
 
 char out_str[200],out_str1[200];

if (lctr > 56) print_head();

fprintf(fp,"\n%-8s %-15.15s         ",
ar_customer_old_code.arr, ar_customer_old_name.arr);

/*--------- Opening Balance  ---------------*/
if (ar_open_bal >= 0)
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",ar_open_bal);
      else
         sprintf(out_str,"%14.2f",ar_open_bal);
   
      //sprintf(out_str,"%14.2f",ar_open_bal);
      //ltrim(out_str);

      format_amt(out_str,nd_no_of_decimal);
      sprintf(out_str1,"%17s",out_str);
      fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
    if (nd_no_of_decimal==3)
      sprintf(out_str,"%14.3f",-ar_open_bal);
    else
      sprintf(out_str,"%14.2f",-ar_open_bal);

    //ltrim(out_str);
      format_amt(out_str,nd_no_of_decimal);
      sprintf(out_str1,"%17s",out_str);
      fprintf(fp,"%-17sCR",out_str1);
   }
/*--------- Invoice Amt  ---------------*/


if (ar_inv_amt >= 0)
   { 
     if (nd_no_of_decimal==3)
        sprintf(out_str,"%14.3f",ar_inv_amt);
     else
	sprintf(out_str,"%14.2f",ar_inv_amt);

   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s  ",out_str);
   fprintf(fp,"%-17s",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",-ar_inv_amt);
      else 
         sprintf(out_str,"%14.2f",-ar_inv_amt);

  // ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Debit Note Amt  ---------------*/
if (ar_dn_amt >= 0)
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",ar_dn_amt);
      else
	 sprintf(out_str,"%14.2f",ar_dn_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str); 
   fprintf(fp,"%-17s  ",out_str1);         
   }
else
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",-ar_dn_amt);
      else
	 sprintf(out_str,"%14.2f",-ar_dn_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);   
   }

/*--------- Credit Note Amt  ---------------*/

if (ar_cn_amt >= 0)
   {
     if (nd_no_of_decimal==3)
        sprintf(out_str,"%14.3f",ar_cn_amt);
     else
	sprintf(out_str,"%14.2f",ar_cn_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",-ar_cn_amt);
      else
	 sprintf(out_str,"%14.2f",-ar_cn_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Adj Note Amt  ---------------*/
if (ar_adj_amt >= 0)
   {
       if (nd_no_of_decimal==3)
           sprintf(out_str,"%14.3f",ar_adj_amt);
       else 	    
	   sprintf(out_str,"%14.2f",ar_adj_amt);

   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",-ar_adj_amt);
      else
	  sprintf(out_str,"%14.2f",-ar_adj_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Receipt Amt  ---------------*/

if (ar_rec_amt >= 0)
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",ar_rec_amt);
      else
	 sprintf(out_str,"%14.2f",ar_rec_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",-ar_rec_amt);
      else
	  sprintf(out_str,"%14.2f",-ar_rec_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Refund Amt  ---------------*/
if (ar_ref_amt >= 0)
   {
      if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",ar_ref_amt);
      else 
	  sprintf(out_str,"%14.2f",ar_ref_amt);

   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",-ar_ref_amt);
      else
	 sprintf(out_str,"%14.2f",-ar_ref_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Total Amt  ---------------*/

if (ar_pg_tot_amt >= 0)
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",ar_pg_tot_amt);
      else 
	 sprintf(out_str,"%14.2f",ar_pg_tot_amt);
   ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",-ar_pg_tot_amt);
      else
	 sprintf(out_str,"%14.2f",-ar_pg_tot_amt);
   
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Closing Balance  ---------------*/

ar_close_bal = ar_open_bal + ar_pg_tot_amt;

if (ar_close_bal >= 0)
   {
       if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",ar_close_bal);
       else
	  sprintf(out_str,"%14.2f",ar_close_bal);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
       if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",-ar_close_bal);
       else 
	  sprintf(out_str,"%14.2f",-ar_close_bal);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

fprintf(fp,"\n");

 g_ar_pg_tot_amt += ar_pg_tot_amt;
 

 ar_open_bal = 0;
 ar_inv_amt  = 0;
 ar_dn_amt   = 0;
 ar_cn_amt   = 0;
 ar_adj_amt  = 0;
 ar_rec_amt  = 0;
 ar_ref_amt  = 0;
 ar_pg_tot_amt =  0;
 ar_close_bal  = 0;


 lctr += 2;


}

print_grand_total()
{
 
 char out_str[200],out_str1[200];

fprintf(fp,"\n");


fprintf(fp,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,"\nGrand Total                      ");

/*--------- Opening Balance  ---------------*/
if (g_ar_open_bal >= 0)
   {
       if (nd_no_of_decimal==3)
           sprintf(out_str,"%14.3f",g_ar_open_bal);
       else
	   sprintf(out_str,"%14.2f",g_ar_open_bal);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",-g_ar_open_bal);
      else
	  sprintf(out_str,"%14.2f",-g_ar_open_bal);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }
/*--------- Invoice Amt  ---------------*/

if (g_ar_inv_amt >= 0)
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",g_ar_inv_amt);
      else
	 sprintf(out_str,"%14.2f",g_ar_inv_amt);

   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s  ",out_str);
   fprintf(fp,"%-17s",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",-g_ar_inv_amt);
      else
	  sprintf(out_str,"%14.2f",-g_ar_inv_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Debit Note Amt  ---------------*/
if (g_ar_dn_amt >= 0)
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",g_ar_dn_amt);
      else
	 sprintf(out_str,"%14.2f",g_ar_dn_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",-g_ar_dn_amt);
      else
	  sprintf(out_str,"%14.2f",-g_ar_dn_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Credit Note Amt  ---------------*/

if (g_ar_cn_amt >= 0)
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",g_ar_cn_amt);
      else 
	 sprintf(out_str,"%14.2f",g_ar_cn_amt);

   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
       if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",-g_ar_cn_amt);
       else
	  sprintf(out_str,"%14.2f",-g_ar_cn_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Adj Note Amt  ---------------*/
if (g_ar_adj_amt >= 0)
   {
       if (nd_no_of_decimal==3)
           sprintf(out_str,"%14.3f",g_ar_adj_amt);
       else 
	   sprintf(out_str,"%14.2f",g_ar_adj_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
        if (nd_no_of_decimal==3)
	   sprintf(out_str,"%14.3f",-g_ar_adj_amt);
        else
	   sprintf(out_str,"%14.2f",-g_ar_adj_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Receipt Amt  ---------------*/

if (g_ar_rec_amt >= 0)
   {
       if (nd_no_of_decimal==3)
           sprintf(out_str,"%14.3f",g_ar_rec_amt);
       else
	   sprintf(out_str,"%14.2f",g_ar_rec_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",-g_ar_rec_amt);
      else
         sprintf(out_str,"%14.2f",-g_ar_rec_amt);

   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Refund Amt  ---------------*/
if (g_ar_ref_amt >= 0)
   {
       if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",g_ar_ref_amt);
       else
	  sprintf(out_str,"%14.2f",g_ar_ref_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
      if (nd_no_of_decimal==3)
         sprintf(out_str,"%14.3f",-g_ar_ref_amt);
      else
	 sprintf(out_str,"%14.2f",-g_ar_ref_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Total Amt  ---------------*/

if (g_ar_pg_tot_amt >= 0)
   {
        if (nd_no_of_decimal==3)
	    sprintf(out_str,"%14.3f",g_ar_pg_tot_amt);
        else
	    sprintf(out_str,"%14.2f",g_ar_pg_tot_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
        if (nd_no_of_decimal==3)
	    sprintf(out_str,"%14.3f",-g_ar_pg_tot_amt);
        else
	    sprintf(out_str,"%14.2f",-g_ar_pg_tot_amt);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

/*--------- Closing Balance  ---------------*/

g_ar_close_bal = g_ar_open_bal + g_ar_pg_tot_amt;
if (g_ar_close_bal >= 0)
   {
        if (nd_no_of_decimal==3)
	    sprintf(out_str,"%14.3f",g_ar_close_bal);
        else
	    sprintf(out_str,"%14.2f",g_ar_close_bal);

   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17s  ",out_str1); 
   }
else
   {
       if (nd_no_of_decimal==3)
          sprintf(out_str,"%14.3f",-g_ar_close_bal);
       else
	  sprintf(out_str,"%14.2f",-g_ar_close_bal);
   //ltrim(out_str);
   format_amt(out_str,nd_no_of_decimal);
   sprintf(out_str1,"%17s",out_str);
   fprintf(fp,"%-17sCR",out_str1);
   }

fprintf(fp,"\n");

fprintf(fp,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
 g_ar_open_bal = 0;
 g_ar_inv_amt  = 0;
 g_ar_dn_amt   = 0;
 g_ar_cn_amt   = 0;
 g_ar_adj_amt  = 0;
 g_ar_rec_amt  = 0;
 g_ar_ref_amt  = 0;
 g_ar_pg_tot_amt =  0;
 g_ar_close_bal  = 0;


 lctr += 2;

   
}

print_footer()
{

    print_details();

    print_grand_total();
fprintf(fp,"\n");

  lctr += 2;
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

    len1 = (len % 2);
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
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )281;
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

close_cur()
{
    
   /* EXEC SQL CLOSE AR_CUST_TRN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )312;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
	if (OERROR) 
	{
      disp_message (ORA_MESG, "CLOSE failed ON AR_CUST_TRN_CUR");
      proc_exit();
	}           
}
