
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
           char  filnam[21];
};
static const struct sqlcxp sqlfpn =
{
    20,
    "c:\\temp1\\rlrwrksd.pc"
};


static unsigned long sqlctx = 72627275;


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

 static const char *sq0009 = 
"(:b0,'DD/MM/YYYY')) and B.RESULT_DATE<(TO_DATE(:b1,'DD/MM/YYYY')+1)) and B.O\
PERATING_FACILITY_ID=:b2) and A.SECTION_CODE between :b3 and :b4) and NVL(A.ST\
ATISTICS_YN,'N')='Y') and A.TEST_CODE in (select C.TEST_CODE  from RL_OUTST_WO\
RK_GROUP_DTL C where (C.OPERATING_FACILITY_ID=:b2 and C.OUTST_WORK_GROUP_CODE=\
nvl(:b6,C.OUTST_WORK_GROUP_CODE)))) order by A.SECTION_CODE,A.TEST_CODE,B.RESU\
LT_DATE            ";

 static const char *sq0010 = 
":b0,'DD/MM/YYYY')) and B.RESULT_DATE<(TO_DATE(:b1,'DD/MM/YYYY')+1)) and OPER\
ATING_FACILITY_ID=:b2) and A.SECTION_CODE between :b3 and :b4) and NVL(A.STATI\
STICS_YN,'N')='Y') order by A.SECTION_CODE,A.TEST_CODE,B.RESULT_DATE          \
  ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,168,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,193,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,202,0,0,0,0,0,1,0,
66,0,0,4,204,0,4,216,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,1,9,0,0,
117,0,0,5,91,0,2,245,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
140,0,0,6,0,0,32,253,0,0,0,0,0,1,0,
155,0,0,7,128,0,4,263,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
186,0,0,8,0,0,32,281,0,0,0,0,0,1,0,
201,0,0,9,1431,0,9,317,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
244,0,0,10,1258,0,9,341,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
279,0,0,11,0,0,32,351,0,0,0,0,0,1,0,
294,0,0,12,70,0,4,463,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
317,0,0,13,0,0,32,475,0,0,0,0,0,1,0,
332,0,0,9,0,0,13,517,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,
379,0,0,10,0,0,13,527,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
426,0,0,14,0,0,32,553,0,0,0,0,0,1,0,
441,0,0,15,44,0,4,618,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
468,0,0,16,44,0,4,633,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
495,0,0,17,44,0,4,698,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
522,0,0,18,44,0,4,713,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
549,0,0,19,0,0,32,748,0,0,0,0,0,1,0,
564,0,0,20,101,0,6,931,0,0,1,1,0,1,0,2,3,0,0,
583,0,0,21,49,0,4,944,0,0,1,0,0,1,0,2,9,0,0,
602,0,0,22,120,0,6,967,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
625,0,0,23,136,0,6,977,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	  : rlrwrksd.pc
   Author : S.Sheelvant 
   Date Created : 13/02/1997
   Last Modified : 13/02/1997
   Last Modified : 30/09/2002 

*  Ver 1.10.01
   
*  Purpose : To generate a report for DAILY WORKLOAD STATISTICS.

*  Input Parameters : 
                      Command line inputs
		              1. Usr_id/Password
                      2. Session id
		              3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4. Preferred range of Departments 
                      5. Range of Months 
  
*  Table Accessed : RL_RESULT_WORKLOAD, RL_TEST_CODE

*  Output File : rlrwrksd.lis
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <gl.h>

/*#include <string.h> */

// MAX_LINES changed 56 to 55 on 30.09.2002

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ESC 0x1B
/*
#define DEBUG 1
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR  nd_operating_facility_id   [3],
	         uid_pwd		            [91],
		     nd_file_name		        [150],
			 d_version_no			    [20],
			 d_version  			    [20],


        /o Variables to recieve data from RESULT_WORKLOAD cursoro/ 
        d_section_code          [2],
        d_test_code             [11],
		d_test_desc             [41],
        t_test_code             [11],   /o to perform test break o/
		t_test_desc             [41],
		d_work_units            [8],
		d_work_units1           [8],
		d_work_units_length     [5],
		d_add_work_units		[8],
		d_add_work_units1		[8],
		d_add_work_units_length	[8],
		d_period_units_length   [20],
		d_period_units          [20],
		d_no_of_tests           [6],
		d_daily_tot             [6],
		d_add_tot               [6],
		d_result_date           [11],
		d_fr_month              [3],
        t_section_code          [2],  /o to perform section break o/
        t_section_desc          [41],



                /o input parameters to main() o/
        nd_session_id      	[16],
		nd_pgm_date	   	[20],
		nd_printer_name	   	[20],

		/o input parameters through from SY_PROG_PARAM o/
        d_section_code_fm       [2],
		d_section_code_to       [2],
		d_date_from             [11],
		d_date_to               [11],
        d_workgroup             [5],
		d_summary_yn			[2],

		/o for header routine o/
	    //d_acc_entity_name_long        [61],
		d_acc_entity_name_long        [300],
		d_user                   [31],
		d_sysdate                [17],

		/o**************** variables added for label_cur cursor **********o/

		l_translated_value		[100],
		language_id				[5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[2]; } d_section_code;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[41]; } d_test_desc;

struct { unsigned short len; unsigned char arr[11]; } t_test_code;

struct { unsigned short len; unsigned char arr[41]; } t_test_desc;

struct { unsigned short len; unsigned char arr[8]; } d_work_units;

struct { unsigned short len; unsigned char arr[8]; } d_work_units1;

struct { unsigned short len; unsigned char arr[5]; } d_work_units_length;

struct { unsigned short len; unsigned char arr[8]; } d_add_work_units;

struct { unsigned short len; unsigned char arr[8]; } d_add_work_units1;

struct { unsigned short len; unsigned char arr[8]; } d_add_work_units_length;

struct { unsigned short len; unsigned char arr[20]; } d_period_units_length;

struct { unsigned short len; unsigned char arr[20]; } d_period_units;

struct { unsigned short len; unsigned char arr[6]; } d_no_of_tests;

struct { unsigned short len; unsigned char arr[6]; } d_daily_tot;

struct { unsigned short len; unsigned char arr[6]; } d_add_tot;

struct { unsigned short len; unsigned char arr[11]; } d_result_date;

struct { unsigned short len; unsigned char arr[3]; } d_fr_month;

struct { unsigned short len; unsigned char arr[2]; } t_section_code;

struct { unsigned short len; unsigned char arr[41]; } t_section_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } nd_printer_name;

struct { unsigned short len; unsigned char arr[2]; } d_section_code_fm;

struct { unsigned short len; unsigned char arr[2]; } d_section_code_to;

struct { unsigned short len; unsigned char arr[11]; } d_date_from;

struct { unsigned short len; unsigned char arr[11]; } d_date_to;

struct { unsigned short len; unsigned char arr[5]; } d_workgroup;

struct { unsigned short len; unsigned char arr[2]; } d_summary_yn;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name_long;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;


        int l_count  = 0;

    	int  l_tab_exists ;
		double period_units1 = 0;

	int i; // added for globalisation

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




#include <winproc.h>

int   line_no=0, page_no=1;
long dept_no_of_tests = 0;
long dept_add_tot = 0;
double dept_total_units = 0;
long test_no_of_tests = 0;
long test_add_tot = 0;
double test_total_units = 0;

int test_printed = 0;
int fr_month = 0;
int test_start = 1;
int wu_line	   = 0;

/* summary fields for calculating No. of records */ 
void print_page_header();
void print_col_heading();
void print_section_desc();
FILE *f1;
char string_var[100];

char local_legend[15][100]; // added for globalisation


void proc_main(argc, argv)
int argc;
char *argv[];
{
  char command_line[300];
  void  get_params(),
  	get_header_dtls(),
  	dclr_result_workload(),
  	do_report();
	
   
   if(argc < 4) {
     disp_message(ORA_MESG,"Usage rlrwrksd uid/passwd session_id pgm_date\n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   strcpy(OUTPUT_FILE_NAME, argv[5]);


   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CONNECT :uid_pwd; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
   sqlstm.sqhstl[0] = (unsigned int  )93;
   sqlstm.sqhsts[0] = (         int  )93;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}

  

   set_meduser_role();

/******* from here added for globalisation ********/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/******* upto here added for globalisation ********/


   gen_file_name();

   get_params();

	get_legend_value(19);

   get_header_dtls();
   
   dclr_result_workload();
   
   do_report();
   

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
}



   fprintf(f1,"%cE",ESC);

   fclose(f1);
   return ;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}   




/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
           PARAM1,
		   PARAM2,
		   PARAM3,
		   PARAM4,
		   PARAM5,
		   PARAM6
        INTO  :nd_operating_facility_id,
		      :d_section_code_fm, 
			  :d_section_code_to,
		      :d_date_from,
			  :d_date_to,
			  :d_workgroup,
			  :d_summary_yn
         FROM SY_PROG_PARAM
	    WHERE PGM_ID = 'RLRWRKSD'
		  AND SESSION_ID = TO_NUMBER(:nd_session_id)
		  AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where \
((PGM_ID='RLRWRKSD' and SESSION_ID=TO_NUMBER(:b7)) and PGM_DATE=:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_section_code_fm;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_section_code_to;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_date_from;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_date_to;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_workgroup;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_summary_yn;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[8] = (unsigned int  )22;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



   nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
   d_section_code_fm.arr[d_section_code_fm.len]     = '\0';
   d_section_code_to.arr[d_section_code_to.len]     = '\0';
   d_date_from.arr[d_date_from.len]   = '\0';
   d_date_to.arr[d_date_to.len]   = '\0';
   d_workgroup.arr[d_workgroup.len] = '\0';
   d_summary_yn.arr[d_summary_yn.len] = '\0';

  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE PGM_ID = 'RLRWRKSD'
	         AND SESSION_ID = :nd_session_id
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='RLRWRKSD' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )117;
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
   sqlstm.sqhstl[1] = (unsigned int  )22;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )140;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_params() occured....\n");
   proc_exit();
}


/* get the header details */
void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT ACC_ENTITY_NAME, /o description of the institution o/
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	    INTO :d_acc_entity_name_long,
		 :d_user,
		 :d_sysdate
            FROM SY_ACC_ENTITY
            WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )155;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name_long;
   sqlstm.sqhstl[0] = (unsigned int  )302;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_user;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
   sqlstm.sqhstl[2] = (unsigned int  )19;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_acc_entity_name_long.arr[d_acc_entity_name_long.len] = '\0';
  d_user.arr[d_user.len]                       = '\0';
  d_sysdate.arr[d_sysdate.len]                 = '\0';

  
  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )186;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}
 

/* function declares RESULT_WORKLOAD cursor */
void dclr_result_workload()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  if (d_workgroup.arr[0] != '\0')
  {
   /* EXEC SQL DECLARE RESULT_WORKLOAD CURSOR FOR
     SELECT A.SECTION_CODE,A.TEST_CODE,A.LONG_DESC,
     NVL(A.WORK_UNITS,0),nvl(a.WORK_UNIT_ADD_FACTOR,0),TO_CHAR(B.RESULT_DATE,'DD/MM/YYYY') RESULT_DATE,
     TO_CHAR((NVL(B.H1,0) + NVL(B.H2,0) + NVL(B.H3,0) + NVL(B.H4,0) + NVL(B.H5,0) + NVL(B.H6,0)+
     NVL(B.H7,0) + NVL(B.H8,0) + NVL(B.H9,0) + NVL(B.H10,0)+ NVL(B.H11,0) + NVL(B.H12,0)+
     NVL(B.H13,0) + NVL(B.H14,0) + NVL(B.H15,0) + NVL(B.H16,0)+ NVL(B.H17,0) + NVL(B.H18,0)+
     NVL(B.H19,0) + NVL(B.H20,0) + NVL(B.H21,0) + NVL(B.H22,0)+ NVL(B.H23,0) + NVL(B.H24,0))) DAILY_TOTAL,
     TO_CHAR(( NVL(B.AH1,0) + NVL(B.AH2,0) + NVL(B.AH3,0) + NVL(B.AH4,0) + NVL(B.AH5,0) + NVL(B.AH6,0)+
     NVL(B.AH7,0) + NVL(B.AH8,0) + NVL(B.AH9,0) + NVL(B.AH10,0)+ NVL(B.AH11,0) + NVL(B.AH12,0)+
     NVL(B.AH13,0) + NVL(B.AH14,0) + NVL(B.AH15,0) + NVL(B.AH16,0)+ NVL(B.AH17,0) + NVL(B.AH18,0)+
     NVL(B.AH19,0) + NVL(B.AH20,0) + NVL(B.AH21,0) + NVL(B.AH22,0)+ NVL(B.AH23,0) + NVL(B.AH24,0))) ADD_TOTAL
     FROM   RL_TEST_CODE A, RL_RESULT_WORKLOAD_DAILY B
     WHERE  A.TEST_CODE = B.TEST_CODE
     AND B.RESULT_DATE  >= TO_DATE(:d_date_from,'DD/MM/YYYY')
     AND B.RESULT_DATE  < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
     AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND A.SECTION_CODE BETWEEN :d_section_code_fm 
     AND :d_section_code_to
     AND  NVL(A.STATISTICS_YN,'N') = 'Y' 
     AND A.TEST_CODE in (select C.TEST_CODE from RL_OUTST_WORK_GROUP_DTL C 
     where C.OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND C.OUTST_WORK_GROUP_CODE = nvl(:d_workgroup,C.OUTST_WORK_GROUP_CODE))
     ORDER BY  A.SECTION_CODE, A.TEST_CODE,B.RESULT_DATE; */ 

	 /* EXEC SQL OPEN RESULT_WORKLOAD; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select A.SECTION_CODE ,A.TEST_CODE ,A.LONG_DESC ,NVL(A.WORK_UNITS,0) ,n\
vl(a.WORK_UNIT_ADD_FACTOR,0) ,TO_CHAR(B.RESULT_DATE,'DD/MM/YYYY') RESULT_DAT\
E ,TO_CHAR((((((((((((((((((((((((NVL(B.H1,0)+NVL(B.H2,0))+NVL(B.H3,0))+NVL(\
B.H4,0))+NVL(B.H5,0))+NVL(B.H6,0))+NVL(B.H7,0))+NVL(B.H8,0))+NVL(B.H9,0))+NV\
L(B.H10,0))+NVL(B.H11,0))+NVL(B.H12,0))+NVL(B.H13,0))+NVL(B.H14,0))+NVL(B.H1\
5,0))+NVL(B.H16,0))+NVL(B.H17,0))+NVL(B.H18,0))+NVL(B.H19,0))+NVL(B.H20,0))+\
NVL(B.H21,0))+NVL(B.H22,0))+NVL(B.H23,0))+NVL(B.H24,0))) DAILY_TOTAL ,TO_CHA\
R((((((((((((((((((((((((NVL(B.AH1,0)+NVL(B.AH2,0))+NVL(B.AH3,0))+NVL(B.AH4,\
0))+NVL(B.AH5,0))+NVL(B.AH6,0))+NVL(B.AH7,0))+NVL(B.AH8,0))+NVL(B.AH9,0))+NV\
L(B.AH10,0))+NVL(B.AH11,0))+NVL(B.AH12,0))+NVL(B.AH13,0))+NVL(B.AH14,0))+NVL\
(B.AH15,0))+NVL(B.AH16,0))+NVL(B.AH17,0))+NVL(B.AH18,0))+NVL(B.AH19,0))+NVL(\
B.AH20,0))+NVL(B.AH21,0))+NVL(B.AH22,0))+NVL(B.AH23,0))+NVL(B.AH24,0))) ADD_\
TOTAL  from RL_TEST_CODE A ,RL_RESULT_WORKLOAD_DAILY B where ((((((A.TEST_CO\
DE=B.TEST_CODE and B.RESULT_DATE>=TO_DATE");
  sqlstm.stmt = sq0009;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )201;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_date_from;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_date_to;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_section_code_fm;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_section_code_to;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_workgroup;
  sqlstm.sqhstl[6] = (unsigned int  )7;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


		}
  else
  {
   /* EXEC SQL DECLARE RESULT_WORKLOAD1 CURSOR FOR
     SELECT A.SECTION_CODE,A.TEST_CODE,A.LONG_DESC,
     NVL(A.WORK_UNITS,0),nvl(a.WORK_UNIT_ADD_FACTOR,0),TO_CHAR(B.RESULT_DATE,'DD/MM/YYYY') RESULT_DATE,
     TO_CHAR((NVL(B.H1,0) + NVL(B.H2,0) + NVL(B.H3,0) + NVL(B.H4,0) + NVL(B.H5,0) + NVL(B.H6,0)+
     NVL(B.H7,0) + NVL(B.H8,0) + NVL(B.H9,0) + NVL(B.H10,0)+ NVL(B.H11,0) + NVL(B.H12,0)+
     NVL(B.H13,0) + NVL(B.H14,0) + NVL(B.H15,0) + NVL(B.H16,0)+ NVL(B.H17,0) + NVL(B.H18,0)+
     NVL(B.H19,0) + NVL(B.H20,0) + NVL(B.H21,0) + NVL(B.H22,0)+ NVL(B.H23,0) + NVL(B.H24,0))) DAILY_TOTAL,
     TO_CHAR(( NVL(B.AH1,0) + NVL(B.AH2,0) + NVL(B.AH3,0) + NVL(B.AH4,0) + NVL(B.AH5,0) + NVL(B.AH6,0)+
     NVL(B.AH7,0) + NVL(B.AH8,0) + NVL(B.AH9,0) + NVL(B.AH10,0)+ NVL(B.AH11,0) + NVL(B.AH12,0)+
     NVL(B.AH13,0) + NVL(B.AH14,0) + NVL(B.AH15,0) + NVL(B.AH16,0)+ NVL(B.AH17,0) + NVL(B.AH18,0)+
     NVL(B.AH19,0) + NVL(B.AH20,0) + NVL(B.AH21,0) + NVL(B.AH22,0)+ NVL(B.AH23,0) + NVL(B.AH24,0))) ADD_TOTAL
     FROM   RL_TEST_CODE A, RL_RESULT_WORKLOAD_DAILY B
     WHERE  A.TEST_CODE = B.TEST_CODE
     AND B.RESULT_DATE  >= TO_DATE(:d_date_from,'DD/MM/YYYY')
     AND B.RESULT_DATE < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
     AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND A.SECTION_CODE BETWEEN :d_section_code_fm 
		       AND :d_section_code_to
       AND  NVL(A.STATISTICS_YN,'N') = 'Y' 
     ORDER BY  A.SECTION_CODE, A.TEST_CODE,B.RESULT_DATE; */ 

	 /* EXEC SQL OPEN RESULT_WORKLOAD1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select A.SECTION_CODE ,A.TEST_CODE ,A.LONG_DESC ,NVL(A.WORK_UNITS,0) ,n\
vl(a.WORK_UNIT_ADD_FACTOR,0) ,TO_CHAR(B.RESULT_DATE,'DD/MM/YYYY') RESULT_DAT\
E ,TO_CHAR((((((((((((((((((((((((NVL(B.H1,0)+NVL(B.H2,0))+NVL(B.H3,0))+NVL(\
B.H4,0))+NVL(B.H5,0))+NVL(B.H6,0))+NVL(B.H7,0))+NVL(B.H8,0))+NVL(B.H9,0))+NV\
L(B.H10,0))+NVL(B.H11,0))+NVL(B.H12,0))+NVL(B.H13,0))+NVL(B.H14,0))+NVL(B.H1\
5,0))+NVL(B.H16,0))+NVL(B.H17,0))+NVL(B.H18,0))+NVL(B.H19,0))+NVL(B.H20,0))+\
NVL(B.H21,0))+NVL(B.H22,0))+NVL(B.H23,0))+NVL(B.H24,0))) DAILY_TOTAL ,TO_CHA\
R((((((((((((((((((((((((NVL(B.AH1,0)+NVL(B.AH2,0))+NVL(B.AH3,0))+NVL(B.AH4,\
0))+NVL(B.AH5,0))+NVL(B.AH6,0))+NVL(B.AH7,0))+NVL(B.AH8,0))+NVL(B.AH9,0))+NV\
L(B.AH10,0))+NVL(B.AH11,0))+NVL(B.AH12,0))+NVL(B.AH13,0))+NVL(B.AH14,0))+NVL\
(B.AH15,0))+NVL(B.AH16,0))+NVL(B.AH17,0))+NVL(B.AH18,0))+NVL(B.AH19,0))+NVL(\
B.AH20,0))+NVL(B.AH21,0))+NVL(B.AH22,0))+NVL(B.AH23,0))+NVL(B.AH24,0))) ADD_\
TOTAL  from RL_TEST_CODE A ,RL_RESULT_WORKLOAD_DAILY B where (((((A.TEST_COD\
E=B.TEST_CODE and B.RESULT_DATE>=TO_DATE(");
  sqlstm.stmt = sq0010;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )244;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_date_from;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_date_to;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_section_code_fm;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_section_code_to;
  sqlstm.sqhstl[4] = (unsigned int  )4;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


  }



   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )279;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_result_workload() occured....\n");
   proc_exit();
}

/* prints the master-detail record until the cursor is empty */
void do_report()
{
  void print_rep_header();
  void prepare_new_page(); 
  void print_detl_rec();
  void end_report();
  void print_test_total();
  void print_section_total();
  int fetch_result_workload();
  int still_rec_left;


  print_rep_header(); /*  once for the report */
  
  page_no += 1; /* icrement by 1 as it is moving to second page */
 
  print_page_header();
  
  /* read the first cursor record */
  
  still_rec_left = fetch_result_workload();

  print_section_desc();
  print_col_heading();
  line_no = 6;
    
  while(still_rec_left)
  {
    strcpy(t_section_code.arr,d_section_code.arr);
    t_section_code.len = strlen(d_section_code.arr);
	
	strcpy(t_test_code.arr,d_test_code.arr);
    t_test_code.len = strlen(d_test_code.arr);
	test_start = 1;
	wu_line    = 0;
    while(still_rec_left && (strcmp(d_section_code.arr,t_section_code.arr)==0) && (strcmp(d_test_code.arr,t_test_code.arr)==0))
    {
		if(line_no >= MAX_LINES)
			prepare_new_page();

		print_detl_rec();
        still_rec_left = fetch_result_workload();
    }

    if (strcmp(d_test_code.arr,t_test_code.arr) != 0)
	{

		fprintf(f1, "\n");
		line_no++;
		chk_break(3);
		print_test_total();
	}

    if (strcmp(d_section_code.arr,t_section_code.arr) != 0)
	{
		fprintf(f1, "\n");
		line_no++;
		chk_break(3);
		print_section_total();
		
	//	if(still_rec_left)
	//		prepare_new_page();

		if (line_no + 3 < MAX_LINES)
		{
			fprintf(f1, "\n\n\n");
			line_no += 3;
		}
		else
			prepare_new_page();
		

	}

  }


  end_report();
}

void print_test_total()
{
//     fprintf(f1,"\n************** T E S T   T O T A L **************");
	 fprintf(f1, "\n************** %s **************", local_legend[1]); // added for globalisation
     fprintf(f1,"%16ld%12ld%15.0f\n\n",test_no_of_tests,test_add_tot,test_total_units);
     test_no_of_tests = 0;
     test_add_tot = 0;
     test_total_units = 0;

	 line_no += 3;
}

void print_section_total()
{
 //fprintf(f1,"\n****** D E P A R T M E N T   T O T A L   ********");
 fprintf(f1, "****** %s   ********\n", local_legend[2]); // added for globalisation
 fprintf(f1,"%16ld%12ld%15.0f\n\n",dept_no_of_tests,dept_add_tot,dept_total_units);
 dept_no_of_tests = 0;
 dept_add_tot = 0;
 dept_total_units = 0;
 line_no += 3;
}

void print_section_desc()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT LONG_NAME /o description of the section o/
	    INTO :t_section_desc
            FROM RL_SECTION_CODE
	    WHERE SECTION_CODE = :d_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_NAME into :b0  from RL_SECTION_CODE where SECT\
ION_CODE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )294;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&t_section_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  t_section_desc.arr[t_section_desc.len] = '\0';
  fprintf(f1,"%-40s\n",t_section_desc.arr);
 
  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )317;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_section_desc() occured....\n");
   proc_exit();
}
   
/* prepares for the new page */
void prepare_new_page()
{
   
   page_no += 1; /* incr. by 1 to move to subsequent pages */
   fprintf(f1,"\f");
   print_page_header();
   print_section_desc();
   print_col_heading(); 
   line_no = 6;
}

/* fetches the next record from SPECIMEN REGISTER CURSOR */
/* returns 0 if the end of cursor is reached else returns 1. */
int fetch_result_workload()
{
  d_section_code.arr[0] = '\0';
  d_test_code.arr[0] = '\0';
  d_test_desc.arr[0] = '\0';
  d_work_units.arr[0]= '\0';
  d_add_work_units.arr[0]= '\0';
  d_daily_tot.arr[0] = '\0';
  d_add_tot.arr[0]   = '\0';
  d_result_date.arr[0]   = '\0';

  d_section_code.len = 0;
  d_test_code.len = 0;
  d_test_desc.len = 0;
  d_work_units.len = 0;
  d_add_work_units.len = 0;
  d_daily_tot.len = 0;
  d_add_tot.len = 0;
  d_result_date.len = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   
  if (d_workgroup.arr[0] != '\0')
  /* EXEC SQL FETCH RESULT_WORKLOAD INTO
		    d_section_code,
            d_test_code,
		    d_test_desc,
		    d_work_units,
			d_add_work_units,
		    d_result_date,
		    d_daily_tot,      
		    d_add_tot; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )332;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_section_code;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_test_desc;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_work_units;
  sqlstm.sqhstl[3] = (unsigned int  )10;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_add_work_units;
  sqlstm.sqhstl[4] = (unsigned int  )10;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_result_date;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_daily_tot;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_add_tot;
  sqlstm.sqhstl[7] = (unsigned int  )8;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


else
  /* EXEC SQL FETCH RESULT_WORKLOAD1 INTO
		    d_section_code,
            d_test_code,
		    d_test_desc,
		    d_work_units,
			d_add_work_units,
		    d_result_date,
		    d_daily_tot,      
		    d_add_tot; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )379;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_section_code;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_test_desc;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_work_units;
  sqlstm.sqhstl[3] = (unsigned int  )10;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_add_work_units;
  sqlstm.sqhstl[4] = (unsigned int  )10;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_result_date;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_daily_tot;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_add_tot;
  sqlstm.sqhstl[7] = (unsigned int  )8;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
    return 0;

d_section_code.arr[d_section_code.len] = '\0';
d_test_code.arr[d_test_code.len]    = '\0';
d_test_desc.arr[d_test_desc.len]    = '\0';
d_work_units.arr[d_work_units.len]  = '\0';
d_add_work_units.arr[d_add_work_units.len]  = '\0';
d_daily_tot.arr[d_daily_tot.len]    = '\0';      
d_add_tot.arr[d_add_tot.len]    = '\0';    
d_result_date.arr[d_result_date.len]    = '\0';     

return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )426;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_result_workload() occured....\n");
   proc_exit();
}
/* print the finishing line of the report */

void end_report()
{
  fprintf(f1,"\n\n\n");
  fprintf(f1,"                                                   ");
  //fprintf(f1,"** End of Report **");
  fprintf(f1, "%s\n", local_legend[3]); // added for globalisation
  fprintf(f1,"\f");
}

/* to print the detailed record */
void print_detl_rec()
{   
    double period_tests = 0;
    double period_units = 0;
    int i;
    long tests[12];
    char msg[100];
 
    period_tests = atof((char *)d_work_units.arr)  *  atof((char * ) d_daily_tot.arr);
    period_units = atof((char *)d_add_work_units.arr)  *  atof((char * ) d_add_tot.arr);
    period_units = period_tests + period_units;
    
	if (period_units > 0) 
    { 
	if (d_summary_yn.arr[0] == 'N')
	{
	   if (test_start) 
	   {
	   test_start = 0;
       fprintf(f1,"%-41.41s%-11.11s %12.12s%12.12s%15.0f\n",
					               d_test_desc.arr,
                                   d_result_date.arr,
								   d_daily_tot.arr,
					               d_add_tot.arr,		
					               period_units);

/*  commented 30.09.2002
			if (wu_line == 0)
			{
				wu_line = 1;
				fprintf(f1,"Work Units: %10.3f Addl: %10.3f",
							atof((char *)d_work_units.arr),
						    atof((char *)d_add_work_units.arr));
			} 
*/
		}
		else
		{
// 30.09.2002
			if (wu_line == 0)
			{
				wu_line = 1;
/*******01.03.2006
				fprintf(f1,"Work Units: %10.3f Addl: %10.3f",
							atof((char *)d_work_units.arr),
						    atof((char *)d_add_work_units.arr));
***********/
				d_work_units_length.arr[0] = '\0';
				d_work_units_length.len = 0;
				/* EXEC SQL SELECT :d_work_units - TRUNC(:d_work_units)
				           INTO :d_work_units_length
						   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (:b0-TRUNC(:b0)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )441;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_work_units;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_work_units;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_work_units_length;
    sqlstm.sqhstl[2] = (unsigned int  )7;
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



				d_work_units_length.arr[d_work_units_length.len] = '\0';

				if(atoi(d_work_units_length.arr) > 0 ) 
					//fprintf(f1,"Work Units: %10.3f ", atof((char *)d_work_units.arr));
					fprintf(f1,"%-10.10s: %10.3f ", local_legend[4], atof((char *)d_work_units.arr)); // added for globalisation
				else
					//fprintf(f1,"Work Units: %-10.10s ",	d_work_units.arr);
					fprintf(f1,"%-10.10s: %-10.10s ", local_legend[4], d_work_units.arr);// added for globalisation

				d_add_work_units_length.arr[0] = '\0';
				d_add_work_units_length.len = 0;
				/* EXEC SQL SELECT :d_add_work_units - TRUNC(:d_add_work_units)
				           INTO :d_add_work_units_length
						   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (:b0-TRUNC(:b0)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )468;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_add_work_units;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_add_work_units;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_add_work_units_length;
    sqlstm.sqhstl[2] = (unsigned int  )10;
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



				d_add_work_units_length.arr[d_add_work_units_length.len] = '\0';

				if(atoi(d_add_work_units_length.arr) > 0 ) 
					//fprintf(f1,"Addl: %10.3f",atof((char *)d_add_work_units.arr));
					fprintf(f1,"%-4.4s: %10.3f",local_legend[5], atof((char *)d_add_work_units.arr)); // added for globalisation
				else
					//fprintf(f1,"Addl: %-10.10s", d_add_work_units.arr);
					fprintf(f1,"%-4.4s: %-10.10s", local_legend[5], d_add_work_units.arr);// added for globalisation

				fprintf(f1,"%-2.2s%-11.11s %12.12s%12.12s%15.0f\n",
									   " ",
									   d_result_date.arr,
									   d_daily_tot.arr,
									   d_add_tot.arr,		
									   period_units);

			} 
// upto here
            else
			{
/*
				if (wu_line == 1)
				{	
				wu_line = 2;
				fprintf(f1,"%-2.2s%-11.11s %12.12s%12.12s%15.3f\n",
									   " ",
									   d_result_date.arr,
									   d_daily_tot.arr,
									   d_add_tot.arr,		
									   period_units);
				}
				else
				{ 
*/
				fprintf(f1,"%-41.41s%-11.11s %12.12s%12.12s%15.0f\n",
									   " ",
									   d_result_date.arr,
									   d_daily_tot.arr,
									   d_add_tot.arr,		
									   period_units);
//				}
			 }
		 }
       line_no = line_no + 1;
	  }
//  in this case following will not be executed
	else		
	{
     if (test_start) 
	   {
	   test_start = 0;
	   fprintf(f1,"%-41.41s\n",d_test_desc.arr);

/************01.03.2006
       fprintf(f1,"Work Units: %10.3f Addl: %10.3f",
							atof((char *)d_work_units.arr),
						    atof((char *)d_add_work_units.arr));
*****************/

				d_work_units_length.arr[0] = '\0';
				d_work_units_length.len = 0;
				/* EXEC SQL SELECT :d_work_units - TRUNC(:d_work_units)
				           INTO :d_work_units_length
						   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (:b0-TRUNC(:b0)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )495;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_work_units;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_work_units;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_work_units_length;
    sqlstm.sqhstl[2] = (unsigned int  )7;
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



				d_work_units_length.arr[d_work_units_length.len] = '\0';

				if(atoi(d_work_units_length.arr) > 0 ) 
					//fprintf(f1,"Work Units: %10.3f ", atof((char *)d_work_units.arr));
					fprintf(f1,"%-10.10s: %10.3f ", local_legend[4], atof((char *)d_work_units.arr)); //added for globalisation
				else
					//fprintf(f1,"Work Units: %-10.10s ", d_work_units.arr);
					fprintf(f1,"%-10.10s: %-10.10s ", local_legend[4], d_work_units.arr); //added for globalisation

				d_add_work_units_length.arr[0] = '\0';
				d_add_work_units_length.len = 0;
				/* EXEC SQL SELECT :d_add_work_units - TRUNC(:d_add_work_units)
				           INTO :d_add_work_units_length
						   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (:b0-TRUNC(:b0)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )522;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_add_work_units;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_add_work_units;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_add_work_units_length;
    sqlstm.sqhstl[2] = (unsigned int  )10;
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



				d_add_work_units_length.arr[d_add_work_units_length.len] = '\0';

				if(atoi(d_add_work_units_length.arr) > 0 ) 
					//fprintf(f1,"Addl: %10.3f",atof((char *)d_add_work_units.arr));
					fprintf(f1,"%-4.4s: %10.3f", local_legend[5], atof((char *)d_add_work_units.arr));//added for globalisation
				else
				{
					//fprintf(f1,"Addl: %-10.10s", d_add_work_units.arr);
					fprintf(f1,"%-4.4s: %10.3f", local_legend[5], d_add_work_units.arr);//added for globalisation
				}


		line_no++;
		}
    }

// upto here 

       test_no_of_tests = test_no_of_tests + atof((char * ) d_daily_tot.arr);
       test_add_tot     = test_add_tot + atof((char * ) d_add_tot.arr);
	   test_total_units = test_total_units + period_units;

       dept_no_of_tests = dept_no_of_tests + atof((char * ) d_daily_tot.arr);
       dept_add_tot     = dept_add_tot + atof((char * ) d_add_tot.arr);
	   dept_total_units = dept_total_units + period_units;
    }
 
return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )549;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}


/* to print the header page for the report */
void print_rep_header()
{
  char nd_fr_section_desc[16],
       nd_to_section_desc[16];

  char nd_workgroup_desc[16];

  char nd_sum_det[30];


  if(strcmp(d_section_code_fm.arr, "!") == 0)
    strcpy(nd_fr_section_desc, "LOWEST");
    else strcpy(nd_fr_section_desc, d_section_code_fm.arr);

  if(strcmp(d_section_code_to.arr, "~") == 0)
    strcpy(nd_to_section_desc, "HIGHEST");
    else strcpy(nd_to_section_desc, d_section_code_to.arr);

  if (strlen(d_workgroup.arr) == 0)
    strcpy(nd_workgroup_desc, "ALL");
    else strcpy(nd_workgroup_desc, d_workgroup.arr);

  if (strcmp(d_summary_yn.arr, "Y") == 0) 
    strcpy(nd_sum_det, "Summary");
  else
    strcpy(nd_sum_det, "Detail");
	
  print_page_header();


  get_version_no();   ///// added 01.07.2003

/////////// 01.07.2003   fprintf(f1,VER);

  fprintf(f1,"%s\n",d_version.arr);

  fprintf(f1,"\n\n\n\n");
  fprintf(f1,"        ");
  //fprintf(f1,"INPUT PARAMETERS :\n");  
  fprintf(f1,"%s:\n", local_legend[6]);
  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  fprintf(f1,"                ");
  //fprintf(f1,"SECTION  FROM : %s\n", nd_fr_section_desc);
  fprintf(f1,"%-13.13s: %s\n", local_legend[7], nd_fr_section_desc);//added for globalisation
  //fprintf(f1,"                         TO   : %s\n\n", nd_to_section_desc);
  fprintf(f1,"%-30.3s: %s\n\n", local_legend[20], nd_to_section_desc);//added for globalisation
  fprintf(f1,"                ");
  //fprintf(f1,"PERIOD   From : %s  To : %s\n",d_date_from.arr,d_date_to.arr);
  fprintf(f1,"%-13.13s: %s  %-3.3s: %s\n",local_legend[8], d_date_from.arr, local_legend[20], d_date_to.arr);//added for globalisation
  fprintf(f1,"                ");
  //fprintf(f1,"WORKGROUP     : %s\n", nd_workgroup_desc);
  fprintf(f1,"%-14.14s: %s\n", local_legend[9], nd_workgroup_desc);//added for globalisation
  fprintf(f1,"                ");
  //fprintf(f1,"WORKLOAD TYPE : %s\n", "Raw Count");
  fprintf(f1,"%-14.14s: %-9.9s\n", local_legend[10], local_legend[21]);//added for globalisation
  fprintf(f1,"                ");
  //fprintf(f1,"REPORT TYPE   : %s\n", nd_sum_det);
  fprintf(f1,"%-14.14s: %s\n", local_legend[11], nd_sum_det); //added for globalisation
  fprintf(f1,"\f");
}


/* to print page headers the header details */ 
void print_page_header()
{
 register int i;
  char nd_fr_section_desc[16],
       nd_to_section_desc[16],
       nd_fr_process_date_desc[11],
       nd_to_process_date_desc[11];

  if(strcmp(d_section_code_fm.arr, "!!!!!!!!!") == 0)
    strcpy(nd_fr_section_desc, "LOWEST");
    else strcpy(nd_fr_section_desc, d_section_code_fm.arr);

  if(strcmp(d_section_code_to.arr, "~~~~~~~~~") == 0)
    strcpy(nd_to_section_desc, "HIGHEST");
    else strcpy(nd_to_section_desc, d_section_code_to.arr);

//fprintf(f1,"%c&l1O",ESC);
fprintf(f1,"%c&k4S",ESC);

 fprintf(f1,"MDL : RL  ");
 fprintf(f1,"%-61.61s",d_acc_entity_name_long.arr);
 fprintf(f1,"   ");  
 fprintf(f1,"%s", d_sysdate.arr);
 fprintf(f1,"\n");
 fprintf(f1,"OPR : %-21.21s", d_user.arr);
 //fprintf(f1,"      WORKLOAD STATISTICS - Rawcount             ");  
 fprintf(f1,"      %-30.30s             ", local_legend[12]); // added for globalisation
 //fprintf(f1,"Page : %4d", page_no);
 fprintf(f1,"%-4.4s: %4d", local_legend[13], page_no); // added for globalisation
 fprintf(f1,"\n");
 fprintf(f1,"REP : RLRWRKSD");
 fprintf(f1,"                   ");
 //fprintf(f1,"For The Period  %-11s To %-11s ",d_date_from.arr,d_date_to.arr);
 fprintf(f1,"%-14.14s  %-11s To %-11s ", local_legend[14],d_date_from.arr,d_date_to.arr); // added for globalisation
 fprintf(f1,"\n");

 fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"----------------------------------------------------------------");
 fprintf(f1,"\n");
}

/* print the heading */
void print_col_heading()
{
 //fprintf(f1,"RESULT DATE TEST CODE  TEST DESCRIPTION                          WORK UNITS  ADD.WORK UNITS   ADD. WORK        NO.OF TESTS    TOTAL UNITS\n"); 
 if (d_summary_yn.arr[0] == 'N')
 //fprintf(f1,"TEST DESCRIPTION                         RESULT DATE  NO.OF TESTS   ADD. WORK    TOTAL UNITS\n"); 
 fprintf(f1,"%-40.40s %-11.11s %-11.11s %-9.9s %-11.11s\n", local_legend[15], local_legend[16], local_legend[17], local_legend[18], local_legend[19]); //added for globalisation
 else
 //fprintf(f1,"TEST DESCRIPTION                                      NO.OF TESTS   ADD. WORK    TOTAL UNITS\n"); 
 fprintf(f1,"%-53.53s %-11.11s %-11.11s %-9.9s %-11.11s\n", local_legend[15], local_legend[17], local_legend[18], local_legend[19]); //added for globalisation
 fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"----------------------------------------------------------------");
 fprintf(f1,"\n");
}
/*--------------------------------------------------------------------------*/
gen_file_name()
{
     /*nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
     EXEC SQL SELECT DECODE(PRINT_FILE_NO,NULL,'0',TO_CHAR(PRINT_FILE_NO)),
		     LOWER(USER)
	      INTO   :nd_file_no,
		     :nd_user
	      FROM   RL_PARAM;

     if (OERROR)
         err_mesg("Fetch failed on table RL_PARAM",0,"");
      
     nd_file_no.arr[nd_file_no.len] = '\0';
     nd_user.arr[nd_user.len] = '\0';
     sprintf(nd_file_name.arr,"rlrhpwkl_%s.lis",nd_file_no.arr);*/

     
	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_file_name.arr,"rlrwrksd.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);
	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }

}
/*-----------------------------------------------------*/
chk_break(int nol)
{

	if((line_no + nol) >= MAX_LINES) 
	{
	    prepare_new_page();
 	}
}
/*-----------------------------------------------------*/

////////////////// 

get_version_no()
{

////////    This function is used to get the version number of the product.
///////      Added by Srinivas on 1 July 2003

     d_version_no.arr[0] = '\0';
     d_version_no.len    =  0;

     strcpy(d_version.arr,"VER : ");

	 /* EXEC SQL EXECUTE 
	      begin
			if SM_INSTALLATION_TAB_CHECK THEN
			   :l_tab_exists := 1;
			else
			   :l_tab_exists := 0;
			end if;
		  end;
	 END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )564;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_tab_exists;
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




    if (l_tab_exists) 
    {
	    /* EXEC SQL SELECT VERSION_NO INTO :d_version_no 
                 FROM   SM_INSTALLATION; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )583;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_version_no;
     sqlstm.sqhstl[0] = (unsigned int  )22;
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

 
        d_version_no.arr[d_version_no.len] = '\0';
    }
    else
	    strcpy(d_version_no.arr,"2.1");

	    strcat(d_version.arr,d_version_no.arr);


    if (OERROR)
	{
	    strcpy(d_version_no.arr,"2.1");
	    strcat(d_version.arr,d_version_no.arr);
    }

}
//////////// UPTO HERE   

/******** added for globalisation ******************/
get_legend_value(int cou)
 {

	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRWRKSD.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRWRKSD.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )602;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
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



	for (i=1; i<=cou; i++)
	{
		l_translated_value.arr[0]		= '\0';
	
		/* EXEC SQL EXECUTE
		BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRWRKSD.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'021'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLRWRKSD.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '021' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )625;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&i;
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


	
		l_translated_value.arr[l_translated_value.len] = '\0';

		//sp_message(ERR_MESG,l_translated_value.arr);

		strcpy(local_legend[i],l_translated_value.arr);
	}
 }
/******** upto here added for globalisation ******************/



#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
