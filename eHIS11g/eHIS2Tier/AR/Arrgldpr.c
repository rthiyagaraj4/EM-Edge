
/* Result Sets Interface */
#ifndef SQL_CRSR
#  define SQL_CRSR
  struct sql_cursor
  {
    unsigned int curocn;
    void *ptr1;
    void *ptr2;
    unsigned int magic;
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
           char  filnam[42];
};
static const struct sqlcxp sqlfpn =
{
    41,
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/AR/Arrgldpr.pc"
};


static unsigned int sqlctx = 1288485419;


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
   unsigned int   sqlcmax;
   unsigned int   sqlcmin;
   unsigned int   sqlcincr;
   unsigned int   sqlctimeout;
   unsigned int   sqlcnowait;
              int   sqfoff;
   unsigned int   sqcmod;
   unsigned int   sqfmod;
            void  *sqhstv[25];
   unsigned int   sqhstl[25];
            int   sqhsts[25];
            void  *sqindv[25];
            int   sqinds[25];
   unsigned int   sqharm[25];
   unsigned int   *sqharc[25];
   unsigned short  sqadto[25];
   unsigned short  sqtdso[25];
} sqlstm = {12,25};

/* SQLLIB Prototypes */
extern void sqlcxt (void **, unsigned int *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlcx2t(void **, unsigned int *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlbuft(void **, char *);
extern void sqlgs2t(void **, char *);
extern void sqlorat(void **, unsigned int *, void *);

/* Forms Interface */
static const int IAPSUCC = 0;
static const int IAPFAIL = 1403;
static const int IAPFTL  = 535;
extern void sqliem(unsigned char *, signed int *);

 static const char *sq0005 = 
"een (NVL(ltrim(TO_CHAR(to_number(:b16),'0009')),'  ')||NVL(ltrim(TO_CHAR(to_\
number(:b17),'09')),'  ')) and (NVL(ltrim(TO_CHAR(to_number(:b18),'0009')),'~~\
')||NVL(ltrim(TO_CHAR(to_number(:b19),'09')),'~~'))) and (:b20='ALL' or TRN_TY\
PE_CODE=:b20)) order by MAIN_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,SUBLEDGER_GROU\
P_CODE,SUBLEDGER_LINE_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,DOC_DATE,DOC_T\
YPE_CODE,DOC_NUM            ";

 static const char *sq0006 = 
"select CONCAT_POST_ACC_DESC  from GL_POSTING_ACC where CONCAT_POST_ACC_CODE=\
:b0           ";

 static const char *sq0007 = 
"select LONG_NAME  from AR_CUSTOMER where CUST_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,415,0,4,192,0,0,25,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
120,0,0,2,147,0,4,269,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
155,0,0,3,91,0,2,346,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
178,0,0,4,0,0,30,355,0,0,0,0,0,1,0,
193,0,0,5,1440,0,9,625,0,0,22,22,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
296,0,0,5,0,0,13,680,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
367,0,0,6,90,0,9,735,0,0,1,1,0,1,0,1,9,0,0,
386,0,0,6,0,0,13,740,0,0,1,0,0,1,0,2,9,0,0,
405,0,0,7,65,0,9,817,0,0,1,1,0,1,0,1,9,0,0,
424,0,0,7,0,0,13,825,0,0,1,0,0,1,0,2,9,0,0,
443,0,0,0,0,0,27,837,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/* Date :- 03-MAY-93  */
 
#include <stdio.h>
#include <string.h>
#include "gl.h"
 
  
#define OERROR (sqlca.sqlcode < 0)


#define LAST_ROW (sqlca.sqlcode == 1403)      

#define NOT_FOUND (sqlca.sqlerrd[2] == 0) 
/*
#define DEBUG 0
*/

#define MAX_LINES 55     

#define DETAIL (nd_report_type_code.arr[0] == 'D')  
//extern char OUTPUT_FILE_NAME[75];

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd			[132],
           hosp_name			[120],
           date_time			[20],
           user_id			[20],
	   nd_facility_id		[3],
           nd_pgm_date			[35]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;


   /* VARCHAR file_name_arg	[101]; */ 
struct { unsigned short len; unsigned char arr[101]; } file_name_arg;


   /* VARCHAR nd_session_id                 [16],
           fm_doc_type_code              [13],
           to_doc_type_code              [13],
           nd_trn_type_code              [5],
           nd_report_type_code           [2],
           fm_main_acc1_code             [7],
           fm_main_acc2_code             [5],
           fm_dept_code                  [11],
           fm_product_gp_code            [4],
           fm_product_line_code          [5],
           fm_sub_gp_code                [4],
           fm_sub_line_code              [9],
           fm_month                      [3],
           fm_year                       [5],
           to_main_acc1_code             [7],
           to_main_acc2_code             [5],
           to_dept_code                  [11],
           to_product_gp_code            [4],
           to_product_line_code          [5],
           to_sub_gp_code                [4],
           to_sub_line_code              [9],
           to_month                      [3],
           to_year                       [5]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } fm_doc_type_code;

struct { unsigned short len; unsigned char arr[13]; } to_doc_type_code;

struct { unsigned short len; unsigned char arr[5]; } nd_trn_type_code;

struct { unsigned short len; unsigned char arr[2]; } nd_report_type_code;

struct { unsigned short len; unsigned char arr[7]; } fm_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } fm_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } fm_dept_code;

struct { unsigned short len; unsigned char arr[4]; } fm_product_gp_code;

struct { unsigned short len; unsigned char arr[5]; } fm_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } fm_sub_gp_code;

struct { unsigned short len; unsigned char arr[9]; } fm_sub_line_code;

struct { unsigned short len; unsigned char arr[3]; } fm_month;

struct { unsigned short len; unsigned char arr[5]; } fm_year;

struct { unsigned short len; unsigned char arr[7]; } to_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } to_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } to_dept_code;

struct { unsigned short len; unsigned char arr[4]; } to_product_gp_code;

struct { unsigned short len; unsigned char arr[5]; } to_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } to_sub_gp_code;

struct { unsigned short len; unsigned char arr[9]; } to_sub_line_code;

struct { unsigned short len; unsigned char arr[3]; } to_month;

struct { unsigned short len; unsigned char arr[5]; } to_year;


  /* VARCHAR  d_ar_dis_doc_type_code        [7],
           d_ar_dis_doc_num              [9],
           d_ar_dis_doc_date             [12],
           d_ar_dis_doc_ref              [15],
           d_ar_dis_cust_code            [9],
           d_ar_dis_concat_post_acc      [50],
           d_ar_dis_narration            [51],
           d_ar_dis_post_month           [3],
           d_ar_dis_post_year            [5],
           d_ar_dis_cheque_num           [12],
           d_ar_dis_cheque_date          [12],
           d_ar_dis_trn_type_code        [5],
           post_acc_desc                 [64],
		   p_language_id			      [3],
           d_cust_long_name              [101]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_ar_dis_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_dis_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_dis_doc_date;

struct { unsigned short len; unsigned char arr[15]; } d_ar_dis_doc_ref;

struct { unsigned short len; unsigned char arr[9]; } d_ar_dis_cust_code;

struct { unsigned short len; unsigned char arr[50]; } d_ar_dis_concat_post_acc;

struct { unsigned short len; unsigned char arr[51]; } d_ar_dis_narration;

struct { unsigned short len; unsigned char arr[3]; } d_ar_dis_post_month;

struct { unsigned short len; unsigned char arr[5]; } d_ar_dis_post_year;

struct { unsigned short len; unsigned char arr[12]; } d_ar_dis_cheque_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_dis_cheque_date;

struct { unsigned short len; unsigned char arr[5]; } d_ar_dis_trn_type_code;

struct { unsigned short len; unsigned char arr[64]; } post_acc_desc;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[101]; } d_cust_long_name;
   /*   CRF-0120  */

  double   d_ar_dis_debit_amt,
           d_ar_dis_credit_amt,
           debit_amt_sum,
           credit_amt_sum,
           debit_amt_gtot,
           credit_amt_gtot;

int nd_no_of_decimal;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header: sqlca.h 24-apr-2003.12:50:58 mkandarp Exp $ sqlca.h 
 */

/* Copyright (c) 1985, 2003, Oracle Corporation.  All rights reserved.  */
 
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
 * $Header: sqlda.h 08-may-2007.05:58:33 ardesai Exp $ sqlda.h 
 */

/***************************************************************
*      The SQLDA descriptor definition                         *
*--------------------------------------------------------------*
*      VAX/3B Version                                          *
*                                                              *
* Copyright (c) 1987, 2007, Oracle. All rights reserved.  *
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
    ardesai    05/08/07  - Bug[6037057] Undef Y
    apopat     05/08/02  - [2362423] MVS PE to make lines shorter than 79
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

#ifdef Y
 # undef Y
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
  /* ub2*   */ short     *Y; /* Ptr to Arr of max lengths of ind. var. names*/
  /* ub2*   */ short     *Z; /* Ptr to Arr of cur lengths of ind. var. names*/
  };
 
typedef struct SQLDA SQLDA;
 
#endif

/* ----------------- */
/* defines for sqlda */
/* ----------------- */

#define SQLSQLDAAlloc(arg1, arg2, arg3, arg4) sqlaldt(arg1, arg2, arg3, arg4) 

#define SQLSQLDAFree(arg1, arg2) sqlclut(arg1, arg2) 




#include "winproc.h"

FILE *fp1,*fp2;
int lctr1 = 0,pctr1 =0,rec_ctr = 0;
int lctr2 = 0,pctr2 =0;

char pre_concat_post_acc[70];

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc != 6)  
   {
      disp_message(ERR_MESG, "Not enough Parameters for running this program\n");
      proc_exit(0);
   }

/*   printf("APRGLDPR : Program started.\n\n");*/

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_session_id,argv[2]);
 
   strcpy(g_pgm_id,"ARRGLDPR");
   
   strcpy(g_facility_id,argv[4]);
      
  // if(sql_connect(uid_pwd.arr) == -1)
   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG, "Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ORA_MESG, "Null oracle uid/pwd\n\n\n");
      proc_exit(0);
   }

#ifdef DEBUG
  disp_message(INFO_MESG, "After connecting to oracle...\n");
#endif
   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   strcpy(file_name_arg.arr,argv[5]);


    set_meduser_role();
 	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

fm_doc_type_code.arr[0]            = '\0';
to_doc_type_code.arr[0]            = '\0';
nd_trn_type_code.arr[0]            = '\0';
nd_report_type_code.arr[0]         = '\0';
fm_main_acc1_code.arr[0]           = '\0';
fm_main_acc2_code.arr[0]           = '\0';
fm_dept_code.arr[0]                = '\0';
fm_product_gp_code.arr[0]          = '\0';
fm_product_line_code.arr[0]        = '\0';
fm_sub_gp_code.arr[0]              = '\0';
fm_sub_line_code.arr[0]            = '\0';
fm_month.arr[0]                    = '\0';
fm_year.arr[0]                     = '\0';
to_main_acc1_code.arr[0]           = '\0';
to_main_acc2_code.arr[0]           = '\0';
to_dept_code.arr[0]                = '\0';
to_product_gp_code.arr[0]          = '\0';
to_product_line_code.arr[0]        = '\0';
to_sub_gp_code.arr[0]              = '\0';
to_sub_line_code.arr[0]            = '\0';
to_month.arr[0]                    = '\0';
to_year.arr[0]                     = '\0';
nd_facility_id.arr[0]              = '\0';

fm_doc_type_code.len               = 0;
to_doc_type_code.len               = 0;
nd_trn_type_code.len               = 0;
nd_report_type_code.len            = 0;
fm_main_acc1_code.len              = 0;
fm_main_acc2_code.len              = 0;
fm_dept_code.len                   = 0;
fm_product_gp_code.len             = 0;
fm_product_line_code.len           = 0;
fm_sub_gp_code.len                 = 0;
fm_sub_line_code.len               = 0;
fm_month.len                       = 0;
fm_year.len                        = 0;
to_main_acc1_code.len              = 0;
to_main_acc2_code.len              = 0;
to_dept_code.len                   = 0;
to_product_gp_code.len             = 0;
to_product_line_code.len           = 0;
to_sub_gp_code.len                 = 0;
to_sub_line_code.len               = 0;
to_month.len                       = 0;
to_year.len                        = 0;
nd_facility_id.len                 = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
                   PARAM1, PARAM2, PARAM3, PARAM6,
                   PARAM7, PARAM8, PARAM9, PARAM10,
                   PARAM11, PARAM12, PARAM13, PARAM14,
                   PARAM15, PARAM16, PARAM17, PARAM18,
                   PARAM19, PARAM20, PARAM21, PARAM22,
                   PARAM23, PARAM24
              INTO :nd_facility_id,
		   :fm_doc_type_code,
                   :to_doc_type_code,
                   :nd_trn_type_code,
                   :nd_report_type_code,
                   :fm_main_acc1_code,
                   :fm_main_acc2_code,
                   :fm_dept_code,
                   :fm_product_gp_code,
                   :fm_product_line_code,
                   :fm_sub_gp_code,
                   :fm_sub_line_code,
                   :fm_month,
                   :fm_year,
                   :to_main_acc1_code,
                   :to_main_acc2_code,
                   :to_dept_code,
                   :to_product_gp_code,
                   :to_product_line_code,
                   :to_sub_gp_code, 
                   :to_sub_line_code,
                   :to_month,
                   :to_year
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRGLDPR'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM\
15 ,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 ,PARAM21 ,PARAM22 ,PARAM23 ,PA\
RAM24 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b\
15,:b16,:b17,:b18,:b19,:b20,:b21,:b22  from SY_PROG_PARAM where ((PGM_ID='ARRG\
LDPR' and SESSION_ID=:b23) and PGM_DATE=:b24)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&fm_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&to_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )15;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_trn_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_report_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&fm_main_acc1_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&fm_main_acc2_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&fm_dept_code;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&fm_product_gp_code;
   sqlstm.sqhstl[8] = (unsigned int  )6;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&fm_product_line_code;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&fm_sub_gp_code;
   sqlstm.sqhstl[10] = (unsigned int  )6;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&fm_sub_line_code;
   sqlstm.sqhstl[11] = (unsigned int  )11;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&fm_month;
   sqlstm.sqhstl[12] = (unsigned int  )5;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&fm_year;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&to_main_acc1_code;
   sqlstm.sqhstl[14] = (unsigned int  )9;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&to_main_acc2_code;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&to_dept_code;
   sqlstm.sqhstl[16] = (unsigned int  )13;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&to_product_gp_code;
   sqlstm.sqhstl[17] = (unsigned int  )6;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&to_product_line_code;
   sqlstm.sqhstl[18] = (unsigned int  )7;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&to_sub_gp_code;
   sqlstm.sqhstl[19] = (unsigned int  )6;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&to_sub_line_code;
   sqlstm.sqhstl[20] = (unsigned int  )11;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&to_month;
   sqlstm.sqhstl[21] = (unsigned int  )5;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&to_year;
   sqlstm.sqhstl[22] = (unsigned int  )7;
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



   
   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");  

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");


fm_doc_type_code.arr[fm_doc_type_code.len]		= '\0';
to_doc_type_code.arr[to_doc_type_code.len]		= '\0';
nd_trn_type_code.arr[nd_trn_type_code.len]		= '\0';
nd_report_type_code.arr[nd_report_type_code.len]	= '\0';
fm_main_acc1_code.arr[fm_main_acc1_code.len]		= '\0';
fm_main_acc2_code.arr[fm_main_acc2_code.len]		= '\0';
fm_dept_code.arr[fm_dept_code.len]			= '\0';
fm_product_gp_code.arr[fm_product_gp_code.len]		= '\0';
fm_product_line_code.arr[fm_product_line_code.len]	= '\0';
fm_sub_gp_code.arr[fm_sub_gp_code.len]			= '\0';
fm_sub_line_code.arr[fm_sub_line_code.len]		= '\0';
fm_month.arr[fm_month.len]				= '\0';
fm_year.arr[fm_year.len]				= '\0';
to_main_acc1_code.arr[to_main_acc1_code.len]		= '\0';
to_main_acc2_code.arr[to_main_acc2_code.len]		= '\0';
to_dept_code.arr[to_dept_code.len]			= '\0';
to_product_gp_code.arr[to_product_gp_code.len]		= '\0';
to_product_line_code.arr[to_product_line_code.len]	= '\0';
to_sub_gp_code.arr[to_sub_gp_code.len]			= '\0';
to_sub_line_code.arr[to_sub_line_code.len]		= '\0';
to_month.arr[to_month.len]				= '\0';
to_year.arr[to_year.len]				= '\0';
nd_facility_id.arr[nd_facility_id.len]			= '\0';

   start_prog_msg();

   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0; 
   date_time.len      = 0;
   user_id.len        = 0;

   /* EXEC SQL SELECT ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   USER,NO_OF_DECIMAL
              INTO :hosp_name, :date_time, :user_id, :nd_no_of_decimal
              FROM SY_ACC_ENTITY
			  WHERE ACC_ENTITY_ID=:nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER ,NO_OF_DECIMAL into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY where ACC_EN\
TITY_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )120;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&hosp_name;
   sqlstm.sqhstl[0] = (unsigned int  )122;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&date_time;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&user_id;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
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



   if (OERROR)
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");
 
   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';

   open_files();
   
   declare_cursors();

   strcpy(pre_concat_post_acc,"");

   debit_amt_sum  = 0;
   credit_amt_sum = 0;
   debit_amt_gtot = 0;
   credit_amt_gtot= 0;

   while(fetch_cur())
   {
      if (rec_ctr == 0)
          print_dtl_hdr();
      rec_ctr ++;
      if (strcmp(pre_concat_post_acc,d_ar_dis_concat_post_acc.arr))
      {
#ifdef DEBUG
  disp_message(INFO_MESG, "Posting acc varies\n");
#endif
           print_dtl_footer();

if(nd_report_type_code.arr[0] == 'S') {
           print_sum();
		   }
           debit_amt_sum  = 0;
           credit_amt_sum = 0;


           print_dtl_hdr();


           strcpy(pre_concat_post_acc,d_ar_dis_concat_post_acc.arr);
      }


      print_dtl();


   }

#ifdef DEBUG
   disp_message(INFO_MESG, "After while fetch_cur \n");
#endif


   print_dtl_footer();
 if(nd_report_type_code.arr[0] == 'S') {
   print_sum();
   }
   
   print_grand_totals_dtl();

if(nd_report_type_code.arr[0] == 'S') {

   print_grand_totals_sum();
   }

   if DETAIL
   print_end(1);
if(nd_report_type_code.arr[0] == 'S') {
   print_end(2);
}
    /* EXEC SQL DELETE FROM SY_PROG_PARAM
                   WHERE PGM_ID     = 'ARRGLDPR'
                     AND SESSION_ID = :nd_session_id
                     AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRGLDPR' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )155;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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



    if (OERROR)
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

    end_prog_msg();
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )178;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


/*    printf("ARRGLDPR : Program ended.\n\n");*/
//    return(0);
}

open_files()
{
 char filename[150];
 char text_msg[101];
#ifdef DEBUG
  disp_message(INFO_MESG, "Inside open files\n");
#endif
if DETAIL
{    
   
   //strcpy(OUTPUT_FILE_NAME,"ARRGLPDT.LIS");
   
   strcpy(filename, WORKING_DIR);
   strcpy(OUTPUT_FILE_NAME,file_name_arg.arr);

   strcat(filename, OUTPUT_FILE_NAME); 

   if ((fp1 = fopen(filename,"w")) == NULL)
   {
        sprintf(text_msg,"Error While Opening File %s",filename);
		err_mesg(text_msg,0,"");
		//err_mesg("\nError while opening File arrglpdt.lis\n",0,"");
        proc_exit(0);
   }

   print_title(1);
   print_head(1);
}   
 
 if(nd_report_type_code.arr[0] == 'S')
 {
   //strcpy(OUTPUT_FILE_NAME,"ARRGLPSM.LIS");

   strcpy(filename, WORKING_DIR);
   strcpy(OUTPUT_FILE_NAME,file_name_arg.arr);
   strcat(filename, OUTPUT_FILE_NAME); 

   if ((fp2 = fopen(filename,"w")) == NULL)
   {
        sprintf(text_msg,"Error While Opening File %s",filename);
		err_mesg(text_msg,0,"");
        //err_mesg("\nError while opening File arrglpsm.lis\n",0,"");
        proc_exit(0);
   }

   print_title(2);
   print_head(2);
 }
#ifdef DEBUG
   disp_message(INFO_MESG, "After opening file\n");
#endif
} 

print_title(rep_no)   
int rep_no; 
{
 FILE *l_fp;
 char rep_name[10], rep_head[60],l_post_acc[60];
 int l_pctr;

 void print_hospital_name(); 

#ifdef DEBUG
  sprintf(string_var, "Inside print title rep no <%d>\n",rep_no);
  disp_message(INFO_MESG, string_var);
#endif  

 l_fp = (rep_no == 1)?fp1:fp2;
 strcpy(rep_name,(rep_no == 1)?"ARRGLPDT":"ARRGLPSM");
 strcpy(rep_head,(rep_no == 1)?
    "    GL DISTRIBUTION REPORT  ":
    "GL DISTRIBUTION REPORT SUMMARY");

 l_pctr = (rep_no == 1)?++pctr1:++pctr2;

/* 
  fprintf(l_fp,
"\n\nMDL : AR                                            %-30s                                   %-20s\n",
      hosp_name.arr,date_time.arr);
*/  
  
  print_hospital_name(133,"AR",hosp_name.arr,date_time.arr);
  fprintf(l_fp,"OPR : %-10s \n", user_id.arr);
  fprintf(l_fp,
"REP : %-8s                                   %-30s                                           PAGE : %4d\n",
    rep_name,rep_head,l_pctr);
fprintf(l_fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
//fprintf(l_fp,"VER : 1.10.01\n");
fflush(l_fp);

fprintf(l_fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");

fprintf(l_fp,"                DOCUMENT TYPE   FROM : %s\n",
                                            fm_doc_type_code.arr);
fprintf(l_fp,"                                TO   : %s\n\n",
                                            to_doc_type_code.arr);
sprintf(l_post_acc,"%-6s-%-4s %-6s %3s-%4s %3s-%8s",
                             fm_main_acc1_code.arr,
                             fm_main_acc2_code.arr,
                             fm_dept_code.arr,
                             fm_product_gp_code.arr,
                             fm_product_line_code.arr,
                             fm_sub_gp_code.arr,
                             fm_sub_line_code.arr);
fprintf(l_fp,"                POSTING ACCOUNT FROM : %s\n",l_post_acc);
sprintf(l_post_acc,"%-6s-%-4s %-6s %3s-%4s %3s-%8s",
                             to_main_acc1_code.arr,
                             to_main_acc2_code.arr,
                             to_dept_code.arr,
                             to_product_gp_code.arr,
                             to_product_line_code.arr,
                             to_sub_gp_code.arr,
                             to_sub_line_code.arr);
fprintf(l_fp,"                                TO   : %s\n\n",l_post_acc);
fprintf(l_fp,"                POST MONTH/YEAR FROM : %-2s/%-4s\n",
                              fm_month.arr, fm_year.arr);
fprintf(l_fp,"                                TO   : %-2s/%-4s\n\n",
                              to_month.arr, to_year.arr);
fprintf(l_fp,"                TRANSACTION TYPE     : %s\n\n",
                              nd_trn_type_code.arr);
fprintf(l_fp,"                REPORT TYPE          : %s\n\n",
                              nd_report_type_code.arr);

  fflush(l_fp);
}

print_head(rep_no)
int rep_no;
{
 FILE *l_fp;
 char rep_name[10], rep_head[60];
 int l_pctr;

 void print_hospital_name();
 
#ifdef DEBUG
   sprintf(string_var, "Inside print_head  rep no <%d>\n",rep_no);
   disp_message(INFO_MESG, string_var);
#endif
 
 l_fp = (rep_no == 1)?fp1:fp2;
 strcpy(rep_name,(rep_no == 1)?"ARRGLPDT":"ARRGLPSM"); 
 strcpy(rep_head,(rep_no == 1)?
    "    GL DISTRIBUTION REPORT  ":
    "GL DISTRIBUTION REPORT SUMMARY");

 l_pctr = (rep_no == 1)?++pctr1:++pctr2;


  /*
  fprintf(l_fp,
"\fMDL : AR                                            %-30s                                   %-20s\n",
      hosp_name.arr,date_time.arr);
  */
  
  fprintf(l_fp,"\f");
  print_hospital_name(133,"AR",hosp_name.arr,date_time.arr);

     fprintf(l_fp,"OPR : %-10s \n", user_id.arr);
  fprintf(l_fp,
"REP : %-8s                                   %-30s                                           PAGE : %4d\n",
    rep_name,rep_head,l_pctr);

fprintf(l_fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");

if (rep_no == 1)
      fprintf(l_fp,
      "  DOC DATE  DOC TYPE & NO.   TXN CUSTOMER CODE & NAME                              CUSTOMER REF          DEBIT AMT         CREDIT AMT\n");
 else
      fprintf(l_fp,
      "<---------- POSTING ACCOUNT --------->                                  DEBIT AMOUNT       CREDIT AMOUNT             BALANCE\n");

if (rep_no == 1)
      fprintf(l_fp,"    CHEQUE NUMBER & DATE         PERIOD  NARRATION \n");

fprintf(l_fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n\n");
  fflush(l_fp);

 if (rep_no == 1)
    lctr1 =7;
 else
    lctr2 =7;
}

print_end(rep_no)
int rep_no;
{
 FILE *l_fp;
 l_fp = (rep_no == 1)?fp1:fp2;

#ifdef DEBUG
  sprintf(string_var, "Inside print end rep no <%d>\n",rep_no);
  disp_message(INFO_MESG, string_var);  
#endif

fprintf(l_fp,
"\n\n\n                                                      **   END  OF  REPORT   ** \n\n");
  fflush(l_fp);
  fclose(l_fp);

}

declare_cursors()
{
#ifdef DEBUG
   disp_message(INFO_MESG, "Inside declare cursors\n");
#endif

   /* EXEC SQL DECLARE AR_GL_DIS_CUR CURSOR FOR
             SELECT DOC_TYPE_CODE,
                    DOC_NUM,
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    DOC_REF,
                    CUST_CODE,
                    MAIN_ACC1_CODE || '-' ||
                    MAIN_ACC2_CODE ||' '||
                    DEPT_CODE      ||' '||
                    PRODUCT_GROUP_CODE  ||'-'||
                    PRODUCT_LINE_CODE   ||' '||
                    SUBLEDGER_GROUP_CODE ||'-'||
                    SUBLEDGER_LINE_CODE,
                    DEBIT_AMT,
                    CREDIT_AMT,
                    NARRATION,
                    POST_MONTH,
                    POST_YEAR,
                    CHEQUE_NUM,
                    TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY'),
                    TRN_TYPE_CODE
               FROM AR_GL_DISTRBN
              WHERE DOC_TYPE_CODE        BETWEEN
               NVL(:fm_doc_type_code,' ') AND NVL(:to_doc_type_code,'~~~~~~~~~~')
                AND MAIN_ACC1_CODE       BETWEEN 
               NVL(:fm_main_acc1_code,' ') AND NVL(:to_main_acc1_code,'~~~~~~~')
                AND MAIN_ACC2_CODE       BETWEEN
               NVL(:fm_main_acc2_code,' ') AND NVL(:to_main_acc2_code,'~~~~~~~')
                AND DEPT_CODE            BETWEEN
                       NVL(:fm_dept_code,' ') AND NVL(:to_dept_code,'~~~~~~~')
                AND SUBLEDGER_GROUP_CODE BETWEEN
               NVL(:fm_sub_gp_code,' ') AND NVL(:to_sub_gp_code,'~~~~~~~~~~')
                AND SUBLEDGER_LINE_CODE  BETWEEN
               NVL(:fm_sub_line_code,' ') AND NVL(:to_sub_line_code,'~~~~~~~~~')
                AND PRODUCT_GROUP_CODE   BETWEEN
               NVL(:fm_product_gp_code,' ') AND NVL(:to_product_gp_code,'~~~~~~~')
                AND PRODUCT_LINE_CODE    BETWEEN
               NVL(:fm_product_line_code,' ') AND NVL(:to_product_line_code,'~~~~~~~')
                AND LTRIM(TO_CHAR(POST_YEAR,'0009'))||
                    LTRIM(TO_CHAR(POST_MONTH,'09')) BETWEEN
                       NVL(ltrim(TO_CHAR(to_number(:fm_year),'0009')),'  ')||
                       NVL(ltrim(TO_CHAR(to_number(:fm_month),'09')),'  ')
                    AND
                       NVL(ltrim(TO_CHAR(to_number(:to_year),'0009')),'~~')||
                       NVL(ltrim(TO_CHAR(to_number(:to_month),'09')),'~~')
                AND (:nd_trn_type_code = 'ALL'      OR
                    TRN_TYPE_CODE  = :nd_trn_type_code
                    )
              ORDER BY MAIN_ACC1_CODE,      MAIN_ACC2_CODE,
                       DEPT_CODE,           SUBLEDGER_GROUP_CODE,
                       SUBLEDGER_LINE_CODE, PRODUCT_GROUP_CODE,
                       PRODUCT_LINE_CODE,   DOC_DATE,
                       DOC_TYPE_CODE,       DOC_NUM; */ 


   /* EXEC SQL OPEN AR_GL_DIS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF\
 ,CUST_CODE ,((((((((((((MAIN_ACC1_CODE||'-')||MAIN_ACC2_CODE)||' ')||DEPT_C\
ODE)||' ')||PRODUCT_GROUP_CODE)||'-')||PRODUCT_LINE_CODE)||' ')||SUBLEDGER_G\
ROUP_CODE)||'-')||SUBLEDGER_LINE_CODE) ,DEBIT_AMT ,CREDIT_AMT ,NARRATION ,PO\
ST_MONTH ,POST_YEAR ,CHEQUE_NUM ,TO_CHAR(CHEQUE_DATE,'DD/MM/YYYY') ,TRN_TYPE\
_CODE  from AR_GL_DISTRBN where (((((((((DOC_TYPE_CODE between NVL(:b0,' ') \
and NVL(:b1,'~~~~~~~~~~') and MAIN_ACC1_CODE between NVL(:b2,' ') and NVL(:b\
3,'~~~~~~~')) and MAIN_ACC2_CODE between NVL(:b4,' ') and NVL(:b5,'~~~~~~~')\
) and DEPT_CODE between NVL(:b6,' ') and NVL(:b7,'~~~~~~~')) and SUBLEDGER_G\
ROUP_CODE between NVL(:b8,' ') and NVL(:b9,'~~~~~~~~~~')) and SUBLEDGER_LINE\
_CODE between NVL(:b10,' ') and NVL(:b11,'~~~~~~~~~')) and PRODUCT_GROUP_COD\
E between NVL(:b12,' ') and NVL(:b13,'~~~~~~~')) and PRODUCT_LINE_CODE betwe\
en NVL(:b14,' ') and NVL(:b15,'~~~~~~~')) and (LTRIM(TO_CHAR(POST_YEAR,'0009\
'))||LTRIM(TO_CHAR(POST_MONTH,'09'))) betw");
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )193;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&fm_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )15;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&to_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&fm_main_acc1_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&to_main_acc1_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&fm_main_acc2_code;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&to_main_acc2_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&fm_dept_code;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&to_dept_code;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&fm_sub_gp_code;
   sqlstm.sqhstl[8] = (unsigned int  )6;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&to_sub_gp_code;
   sqlstm.sqhstl[9] = (unsigned int  )6;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&fm_sub_line_code;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&to_sub_line_code;
   sqlstm.sqhstl[11] = (unsigned int  )11;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&fm_product_gp_code;
   sqlstm.sqhstl[12] = (unsigned int  )6;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&to_product_gp_code;
   sqlstm.sqhstl[13] = (unsigned int  )6;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&fm_product_line_code;
   sqlstm.sqhstl[14] = (unsigned int  )7;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&to_product_line_code;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&fm_year;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&fm_month;
   sqlstm.sqhstl[17] = (unsigned int  )5;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&to_year;
   sqlstm.sqhstl[18] = (unsigned int  )7;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&to_month;
   sqlstm.sqhstl[19] = (unsigned int  )5;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_trn_type_code;
   sqlstm.sqhstl[20] = (unsigned int  )7;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_trn_type_code;
   sqlstm.sqhstl[21] = (unsigned int  )7;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
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



   if (OERROR)
         err_mesg("OPEN failed on cursor AR_GL_DIS_CUR",0,"");

   /* EXEC SQL DECLARE GL_POSTING_ACC_CUR  CURSOR FOR
             SELECT CONCAT_POST_ACC_DESC
               FROM GL_POSTING_ACC
              WHERE CONCAT_POST_ACC_CODE = :d_ar_dis_concat_post_acc; */ 

              
   /* EXEC SQL DECLARE AR_CUSTOMER_CUR  CURSOR FOR
             SELECT LONG_NAME
               FROM AR_CUSTOMER
              WHERE CUST_CODE = :d_ar_dis_cust_code; */ 


#ifdef DEBUG
   disp_message(INFO_MESG, "After decl cursors\n");
#endif
}

fetch_cur()
{
#ifdef DEBUG
   disp_message(INFO_MESG, "Inside fetch cur\n");
#endif

d_ar_dis_doc_type_code.arr[0]       = '\0';
d_ar_dis_doc_num.arr[0]             = '\0';
d_ar_dis_doc_date.arr[0]            = '\0';
d_ar_dis_doc_ref.arr[0]             = '\0';
d_ar_dis_cust_code.arr[0]           = '\0';
d_ar_dis_concat_post_acc.arr[0]     = '\0';
d_ar_dis_narration.arr[0]           = '\0';
d_ar_dis_post_month.arr[0]          = '\0';
d_ar_dis_post_year.arr[0]           = '\0';
d_ar_dis_cheque_num.arr[0]          = '\0';
d_ar_dis_cheque_date.arr[0]         = '\0';
d_ar_dis_trn_type_code.arr[0]       = '\0';

d_ar_dis_doc_type_code.len          = 0;
d_ar_dis_doc_num.len                = 0;
d_ar_dis_doc_date.len               = 0;
d_ar_dis_doc_ref.len                = 0;
d_ar_dis_cust_code.len              = 0;
d_ar_dis_concat_post_acc.len        = 0;
d_ar_dis_narration.len              = 0;
d_ar_dis_post_month.len             = 0;
d_ar_dis_post_year.len              = 0;
d_ar_dis_cheque_num.len             = 0;
d_ar_dis_cheque_date.len            = 0;
d_ar_dis_trn_type_code.len          = 0;

d_ar_dis_debit_amt                  = 0;
d_ar_dis_credit_amt                 = 0;

   /* EXEC SQL FETCH AR_GL_DIS_CUR
             INTO :d_ar_dis_doc_type_code,
                  :d_ar_dis_doc_num,
                  :d_ar_dis_doc_date,
                  :d_ar_dis_doc_ref,
                  :d_ar_dis_cust_code,
                  :d_ar_dis_concat_post_acc,
                  :d_ar_dis_debit_amt,
                  :d_ar_dis_credit_amt,
                  :d_ar_dis_narration,
                  :d_ar_dis_post_month,
                  :d_ar_dis_post_year,
                  :d_ar_dis_cheque_num,
                  :d_ar_dis_cheque_date,
                  :d_ar_dis_trn_type_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )296;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_dis_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_dis_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_dis_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_dis_doc_ref;
   sqlstm.sqhstl[3] = (unsigned int  )17;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ar_dis_cust_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_ar_dis_concat_post_acc;
   sqlstm.sqhstl[5] = (unsigned int  )52;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_ar_dis_debit_amt;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_ar_dis_credit_amt;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_ar_dis_narration;
   sqlstm.sqhstl[8] = (unsigned int  )53;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_ar_dis_post_month;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_ar_dis_post_year;
   sqlstm.sqhstl[10] = (unsigned int  )7;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_ar_dis_cheque_num;
   sqlstm.sqhstl[11] = (unsigned int  )14;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_ar_dis_cheque_date;
   sqlstm.sqhstl[12] = (unsigned int  )14;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_ar_dis_trn_type_code;
   sqlstm.sqhstl[13] = (unsigned int  )7;
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



      if (OERROR)
         err_mesg("FETCH failed on cursor AR_GL_DIS_CUR",0,"");


d_ar_dis_doc_type_code.arr[d_ar_dis_doc_type_code.len]		= '\0';
d_ar_dis_doc_num.arr[d_ar_dis_doc_num.len]			= '\0';
d_ar_dis_doc_date.arr[d_ar_dis_doc_date.len]			= '\0';
d_ar_dis_doc_ref.arr[d_ar_dis_doc_ref.len]			= '\0';
d_ar_dis_cust_code.arr[d_ar_dis_cust_code.len]			= '\0';
d_ar_dis_concat_post_acc.arr[d_ar_dis_concat_post_acc.len]	= '\0';
d_ar_dis_narration.arr[d_ar_dis_narration.len]			= '\0';
d_ar_dis_post_month.arr[d_ar_dis_post_month.len]		= '\0';
d_ar_dis_post_year.arr[d_ar_dis_post_year.len]			= '\0';
d_ar_dis_cheque_num.arr[d_ar_dis_cheque_num.len]		= '\0';
d_ar_dis_cheque_date.arr[d_ar_dis_cheque_date.len]		= '\0';
d_ar_dis_trn_type_code.arr[d_ar_dis_trn_type_code.len]		= '\0';

if (pre_concat_post_acc[0] == '\0')
    strcpy(pre_concat_post_acc,d_ar_dis_concat_post_acc.arr);

#ifdef DEBUG
   disp_message(INFO_MESG, "After fetching rec\n");
#endif

   if (LAST_ROW)
       return (0);
   else
       return (1);
}

print_dtl_hdr()
{
#ifdef DEBUG
   disp_message(INFO_MESG, "In print dtl hdr\n");
#endif
 if DETAIL
  if (lctr1 > MAX_LINES)
     print_head(1);

  /* EXEC SQL OPEN GL_POSTING_ACC_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0006;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )367;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_ar_dis_concat_post_acc;
  sqlstm.sqhstl[0] = (unsigned int  )52;
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



  if (OERROR)
         err_mesg("OPEN failed on cursor GL_POSTING_ACC_CUR",0,"");

  /* EXEC SQL FETCH GL_POSTING_ACC_CUR
            INTO :post_acc_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )386;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&post_acc_desc;
  sqlstm.sqhstl[0] = (unsigned int  )66;
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



  if (OERROR)
         err_mesg("FETCH failed on cursor GL_POSTING_ACC_CUR",0,"");

  if DETAIL
  {
     fprintf(fp1,"POSTING A/C : %s\n",d_ar_dis_concat_post_acc.arr);
     fprintf(fp1,"DESCRIPTION : %s\n\n",post_acc_desc.arr);
     lctr1+=3;
   }

}

print_dtl()
{
#ifdef DEBUG
   disp_message(INFO_MESG, "Inside print dtl\n");
#endif

  if DETAIL
    if (lctr1 > MAX_LINES)
       print_head(1);

   fetch_cust_name();

#ifdef DEBUG
  disp_message(INFO_MESG, "After fetching cust name \n");
#endif
   if DETAIL
   {

  
   fprintf(fp1,"  %-10s %-6s %8s %-3s %-8s %-40.40s %-15s  ",
          d_ar_dis_doc_date.arr,
          d_ar_dis_doc_type_code.arr,
          d_ar_dis_doc_num.arr,
          d_ar_dis_trn_type_code.arr,
          d_ar_dis_cust_code.arr,
          d_cust_long_name.arr,
          d_ar_dis_doc_ref.arr);

   
   print_formated(d_ar_dis_debit_amt,fp1);
   fprintf(fp1,"   ");
      
   print_formated(d_ar_dis_credit_amt,fp1); 
   fprintf(fp1,"\n");
   lctr1++;
 
   fprintf(fp1,"    %-10s      %-10s  %2s/ %4s  %-50.50s\n",
          d_ar_dis_cheque_num.arr,
          d_ar_dis_cheque_date.arr,
          d_ar_dis_post_month.arr,
          d_ar_dis_post_year.arr,
          d_ar_dis_narration.arr);
   lctr1++;
   }
#ifdef DEBUG
   disp_message(INFO_MESG, "After printing 2 lines\n");
#endif

  debit_amt_sum  += d_ar_dis_debit_amt;
  credit_amt_sum += d_ar_dis_credit_amt;

#ifdef DEBUG
  disp_message(INFO_MESG, "Dtl print over\n");
#endif
}

fetch_cust_name()
{
#ifdef DEBUG
   disp_message(INFO_MESG, "Inside fetch cust_name\n");
#endif

   /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )405;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_dis_cust_code;
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



   if (OERROR)
         err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");
  
   d_cust_long_name.arr[0] = '\0';
   d_cust_long_name.len    = 0;
 
   /* EXEC SQL FETCH AR_CUSTOMER_CUR
             INTO :d_cust_long_name; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )424;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_cust_long_name;
   sqlstm.sqhstl[0] = (unsigned int  )103;
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



   if (OERROR)
         err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

   d_cust_long_name.arr[d_cust_long_name.len] = '\0';

}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )443;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqlcmax = (unsigned int )100;
  sqlstm.sqlcmin = (unsigned int )2;
  sqlstm.sqlcincr = (unsigned int )1;
  sqlstm.sqlctimeout = (unsigned int )0;
  sqlstm.sqlcnowait = (unsigned int )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}


print_dtl_footer()
{
int i = 0;

#ifdef DEBUG
   disp_message(INFO_MESG, "Inside print dtl footer\n");
#endif

  if DETAIL
  {
  if (lctr1 > MAX_LINES)
     print_head(1);
  
  fprintf(fp1,"\n");
  for (i=0;i<100;i++) fprintf(fp1," ");
  for (i = 0;i<15;i++) fprintf(fp1,"-");
  fprintf(fp1,"    ");
  for (i = 0;i<15;i++) fprintf(fp1,"-");
  fprintf(fp1,"\n");
  for (i=0;i<76;i++) fprintf(fp1," ");
  fprintf(fp1,"ACCOUNT TOTALS          ");
  
  print_formated(debit_amt_sum,fp1);

  fprintf(fp1,"   ");               
  print_formated(credit_amt_sum,fp1);
  fprintf(fp1,"\n");
  for (i=0;i<100;i++) fprintf(fp1," ");
  for (i = 0;i<15;i++) fprintf(fp1,"-");
  fprintf(fp1,"    ");
  for (i = 0;i<15;i++) fprintf(fp1,"-");
  fprintf(fp1,"\n");
  for (i=0;i<76;i++) fprintf(fp1," ");
  fprintf(fp1,"ACCOUNT ACTIVITY        ");
  print_formated(debit_amt_sum -  credit_amt_sum,fp1);
  fprintf(fp1,"\n");
  for (i = 0;i<100;i++) fprintf(fp1," ");
  for (i = 0;i<15;i++) fprintf(fp1,"=");   
  fprintf(fp1,"\n\n");  
  }

  debit_amt_gtot += debit_amt_sum;
  credit_amt_gtot += credit_amt_sum;

  lctr1+=6;
}

print_sum()
{
#ifdef DEBUG
  disp_message(INFO_MESG, "Inside print summ\n");
#endif

  if (lctr2 > MAX_LINES)
     print_head(2);

  fprintf(fp2,"%-70s",pre_concat_post_acc);
  print_formated(debit_amt_sum,fp2);
  fprintf(fp2,"    ");
  print_formated(credit_amt_sum,fp2);
  fprintf(fp2,"    ");
  print_formated(debit_amt_sum - credit_amt_sum,fp2);
  fprintf(fp2,"\n");
  fprintf(fp2,"%s\n\n",post_acc_desc.arr);
  lctr2+=3;
}

print_grand_totals_dtl()
{
int i = 0;

#ifdef DEBUG
  disp_message(INFO_MESG, "Inside print grand totals dtl\n");
#endif

  if DETAIL
  {
  if (lctr1 > MAX_LINES)
     print_head(1);
  
  fprintf(fp1,"\n");
  for (i=0;i<100;i++) fprintf(fp1," ");
  for (i = 0;i<15;i++) fprintf(fp1,"-");
  fprintf(fp1,"    ");
  for (i = 0;i<15;i++) fprintf(fp1,"-");
  fprintf(fp1,"\n");
  for (i=0;i<75;i++) fprintf(fp1," ");
  fprintf(fp1," GRAND  TOTALS           ");
  print_formated(debit_amt_gtot,fp1);
  fprintf(fp1,"   ");
  print_formated(credit_amt_gtot,fp1);
  fprintf(fp1,"\n");
  for (i=0;i<100;i++) fprintf(fp1," ");
  for (i = 0;i<15;i++) fprintf(fp1,"="); 
  fprintf(fp1,"    ");
  for (i = 0;i<15;i++) fprintf(fp1,"=");  
  fprintf(fp1,"\n");

  lctr1+=5;
  }
}

print_grand_totals_sum()
{
int i = 0;

#ifdef DEBUG
   disp_message(INFO_MESG, "Inside print grand totals sum\n");
#endif

  if (lctr2 > MAX_LINES)
     print_head(2);
  
  fprintf(fp2,"\n");
  for (i=0;i<70;i++) fprintf(fp2," ");
  for (i = 0;i<15;i++) fprintf(fp2,"-");
  fprintf(fp2,"    ");
  for (i = 0;i<15;i++) fprintf(fp2,"-");
  fprintf(fp2,"     ");
  for (i = 0;i<15;i++) fprintf(fp2,"-"); 
  fprintf(fp2,"\n");
  for (i=0;i<48;i++) fprintf(fp2," ");
  fprintf(fp2," GRAND  TOTALS        ");
  print_formated(debit_amt_gtot,fp2);
  fprintf(fp2,"    ");
  print_formated(credit_amt_gtot,fp2); 
  fprintf(fp2,"    ");
  print_formated(debit_amt_gtot - credit_amt_gtot,fp2);
  fprintf(fp2,"\n");
  for (i=0;i<70;i++) fprintf(fp2," ");
  for (i = 0;i<15;i++) fprintf(fp2,"-");
  fprintf(fp2,"    ");
  for (i = 0;i<15;i++) fprintf(fp2,"-");
  fprintf(fp2,"     ");
  for (i = 0;i<15;i++) fprintf(fp2,"-");
  fprintf(fp2,"\n");

  lctr1+=5;  
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

	if (nd_report_type_code.arr[0]=='S')
	  {
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

			fprintf(fp2,"MDL : %2s",nd_mod_id);	

			for(i = len1; i < pos ; fprintf(fp2," "),i++);	

			fprintf(fp2,"%s",nd_hospital_name);	

			for(i = i + (len * 2) ; i < pos_date + 1; fprintf(fp2," "),i++);	

			fprintf(fp2,"%s\n",nd_date);		
       }

    else
	   {
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

			fprintf(fp1,"MDL : %2s",nd_mod_id);	

			for(i = len1; i < pos ; fprintf(fp1," "),i++);	

			fprintf(fp1,"%s",nd_hospital_name);	

			for(i = i + (len * 2) ; i < pos_date + 1; fprintf(fp1," "),i++);	

			fprintf(fp1,"%s\n",nd_date);		
       }

}


print_formated(loc_amount,l_fp)
double loc_amount;
FILE *l_fp;
{      
   char out_str[30],out_str1[30];

   if (nd_no_of_decimal == 3)
     sprintf(out_str,"%11.3f",loc_amount);    
   else
     sprintf(out_str,"%11.2f",loc_amount);    

   format_amt(out_str,nd_no_of_decimal);
  
   if (loc_amount == 0)
     fprintf(l_fp,"%14s  ","");
   else if (loc_amount > 0)
       fprintf(l_fp,"%14s  ",out_str);
   else
      fprintf(l_fp,"%14sCR",out_str);
/*      
   if (loc_amount >= 0)
       fprintf(l_fp,"%14s  ",out_str);
   else
      fprintf(l_fp,"%14sCR",out_str);

   if (loc_amount > 0)                          
   {
      sprintf(out_str,"%10.2f",loc_amount);
      ltrim(out_str); 
	  
	  //put_comma(out_str);
	  
	  
	  format_amt(out_str);

	  if (strcmp(out_str,"0.00") ==0)   
	    {
		   fprintf(l_fp,"%-13s  ","");
        }
      else     
		{
           sprintf(out_str1,"%13s",out_str); 
	       fprintf(l_fp,"%-13s  ",out_str1);
        }
   }
   else 
    {       
      sprintf(out_str,"%10.2f",-loc_amount);
      ltrim(out_str); 
	  
	 //put_comma(out_str);
	   format_amt(out_str);

       if (strcmp(out_str,"0.00") == 0)  
	      {
		    fprintf(l_fp,"%-13s  ","");
          }
       else
		  {
	         sprintf(out_str1,"%13s",out_str);  
             fprintf(l_fp,"%-13sCR",out_str1);    
           }
    }
*/
}  

error_insert()
{
/* This function is defined since ap_func.pc */
/* will be used as a sub routine             */
}

