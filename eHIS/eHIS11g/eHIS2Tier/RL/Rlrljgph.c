
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/Rlrljgph.pc"
};


static unsigned int sqlctx = 1288614971;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {12,17};

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
"select TO_CHAR(result_value) ,TO_CHAR(B.result_date_time,'dd/mm/yyyy hh24:mi\
') ,DECODE(B.quality_status,'R','Rejected','Accepted')  from RL_TEST_QUALITY_M\
AST A ,RL_TEST_QUALITY_RESULTS B where (((((((((((((A.OPERATING_FACILITY_ID=:b\
0 and B.OPERATING_FACILITY_ID=:b0) and A.qlty_code=:b2) and A.qlty_code=B.qlty\
_code) and A.section_code=:b3) and A.section_code=B.section_code) and A.batch_\
id=:b4) and A.batch_id=B.batch_id) and A.inst_code=:b5) and A.inst_code=B.inst\
_code) and A.test_code=:b6) and A.test_code=B.test_code) and B.result_date_tim\
e>=TO_DATE(:b7,'DD/MM/YYYYHH24:MI')) and B.result_date_time<(TO_DATE(:b8,'DD/M\
M/YYYYHH24:MI')+1)) order by B.result_date_time            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,283,167,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,286,210,0,0,0,0,0,1,0,
51,0,0,3,219,0,262,327,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
78,0,0,4,684,0,260,369,0,0,17,6,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
161,0,0,5,681,0,265,442,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
212,0,0,5,0,0,271,458,0,0,0,0,0,1,0,
227,0,0,5,0,0,269,480,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
254,0,0,6,158,0,260,519,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
289,0,0,7,155,0,262,614,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
312,0,0,8,100,0,260,678,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
339,0,0,9,130,0,260,704,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,
374,0,0,10,120,0,260,730,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
405,0,0,11,163,0,260,752,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
440,0,0,12,175,0,260,783,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,
479,0,0,13,109,0,258,814,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
502,0,0,14,130,0,260,860,0,0,8,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2,9,0,0,2,3,0,0,2,3,0,0,
549,0,0,15,88,0,260,911,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
576,0,0,16,120,0,262,938,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
599,0,0,17,136,0,262,948,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/*

**   Last Modified by : HAMEED

*/
#include <stdio.h>   
#include <string.h>
#include <malloc.h>
#include "rl.h"
#include "rl.h"      

#define REP_WIDTH 78
#define VER  "VER : 1.10.01\n"
#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403) 
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR nd_operating_facility_id   [3],
	        uid_pwd					   [91],
		    d_pgm_date				   [14],
            rep_date				   [20],
            rep_date1				   [20],
            comp_name				   [1000],
            oper_id					   [21],
            d_curr_pgm_name			   [15],
			nd_session_id			   [31],
			nd_pgm_date				   [21],
			nd_trx_ind		           [2]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date1;

struct { unsigned short len; unsigned char arr[1000]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[31]; } nd_session_id;

struct { unsigned short len; unsigned char arr[21]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;



	/* VARCHAR	nd_section_code			[2],
			nd_test_code			[6],
			nd_quality_code			[5],
			nd_fm_process_date		[20],
			nd_to_process_date		[20],
			nd_batch_id				[31],
			nd_inst_code			[10]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_section_code;

struct { unsigned short len; unsigned char arr[6]; } nd_test_code;

struct { unsigned short len; unsigned char arr[5]; } nd_quality_code;

struct { unsigned short len; unsigned char arr[20]; } nd_fm_process_date;

struct { unsigned short len; unsigned char arr[20]; } nd_to_process_date;

struct { unsigned short len; unsigned char arr[31]; } nd_batch_id;

struct { unsigned short len; unsigned char arr[10]; } nd_inst_code;


	/* VARCHAR nd_test_name			[61],
			nd_section_name			[41],
			nd_quality_name			[41],
			nd_test_units			[30],
			nd_test_units_desc		[41],
			nd_inst_name			[41]; */ 
struct { unsigned short len; unsigned char arr[61]; } nd_test_name;

struct { unsigned short len; unsigned char arr[41]; } nd_section_name;

struct { unsigned short len; unsigned char arr[41]; } nd_quality_name;

struct { unsigned short len; unsigned char arr[30]; } nd_test_units;

struct { unsigned short len; unsigned char arr[41]; } nd_test_units_desc;

struct { unsigned short len; unsigned char arr[41]; } nd_inst_name;
 

	/* VARCHAR nd_std_deviation		[20],
			nd_cf_variation			[20],
			nd_mean_value			[20],
			nd_1_sd					[20],
			nd_2_sd					[20],
			nd_3_sd					[20],
			nd_4_sd					[20],
			nd_m1_sd				[20],
			nd_m2_sd				[20],
			nd_m3_sd				[20],
			nd_m4_sd				[20],
			nd_result_value			[20],
			nd_result_date			[20],
			nd_result_date1			[20], //added for globalisation
			nd_quality_status		[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } nd_std_deviation;

struct { unsigned short len; unsigned char arr[20]; } nd_cf_variation;

struct { unsigned short len; unsigned char arr[20]; } nd_mean_value;

struct { unsigned short len; unsigned char arr[20]; } nd_1_sd;

struct { unsigned short len; unsigned char arr[20]; } nd_2_sd;

struct { unsigned short len; unsigned char arr[20]; } nd_3_sd;

struct { unsigned short len; unsigned char arr[20]; } nd_4_sd;

struct { unsigned short len; unsigned char arr[20]; } nd_m1_sd;

struct { unsigned short len; unsigned char arr[20]; } nd_m2_sd;

struct { unsigned short len; unsigned char arr[20]; } nd_m3_sd;

struct { unsigned short len; unsigned char arr[20]; } nd_m4_sd;

struct { unsigned short len; unsigned char arr[20]; } nd_result_value;

struct { unsigned short len; unsigned char arr[20]; } nd_result_date;

struct { unsigned short len; unsigned char arr[20]; } nd_result_date1;

struct { unsigned short len; unsigned char arr[20]; } nd_quality_status;



	/* VARCHAR	r_rslt					[30],
		    v_numeric_result		[30],
			l_translated_value		 [500],//added for globalisation
			language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[30]; } r_rslt;

struct { unsigned short len; unsigned char arr[30]; } v_numeric_result;

struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;
//added for globalisation

	int v_no_of_decimals = 0;
	int l_exist_decimals = 0;
	int l_inst_decimals = 0;

    int l_count = 0;
	int i; //added for globalisation
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

/* EXEC ORACLE OPTION(HOLD_CURSOR = YES); */ 

//EXEC ORACLE OPTION(REBIND = NO);


char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char string_var[1000];

char local_legend[35][500];//added for globalisation

//char rep_title1[] = "Levey Jennings Chart";
char rep_title1[40]; //added for globalisation
char rep_title2[30];
char item_title[30];


int end_pgm_control = 0;

FILE *f1;

int page_no,
    line_no;

char filename[150];

float l_result = 0;
char *l_string;
char g_facility_id[50];

void proc_main(argc,argv)
int argc;
char *argv[];
{

   if(argc < 8) {
     disp_message(ORA_MESG,"Usage rlrljgph uid/passwd session_id pgm_date section quality process from & to \n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

	strcpy(g_facility_id, nd_operating_facility_id.arr);
   
   strcpy(nd_section_code.arr, argv[5]);
   nd_section_code.len = strlen(nd_section_code.arr);

   strcpy(nd_quality_code.arr, argv[6]);
   nd_quality_code.len = strlen(nd_quality_code.arr);

   strcpy(nd_fm_process_date.arr, argv[7]);
   nd_fm_process_date.len = strlen(nd_fm_process_date.arr);

   strcpy(nd_to_process_date.arr, argv[8]);
   nd_to_process_date.len = strlen(nd_to_process_date.arr);

/*
   strcpy(nd_test_code.arr, argv[4]);
   nd_test_code.len = strlen(nd_test_code.arr);
   
   strcpy(nd_batch_id.arr, argv[8]);
   nd_batch_id.len = strlen(nd_batch_id.arr);

//   strcpy(nd_inst_code.arr, argv[9]);
//   nd_inst_code.len = strlen(nd_inst_code.arr);

   strcpy(nd_inst_code.arr, "INST 1");
   nd_inst_code.len = strlen(nd_inst_code.arr);
*/

	/* EXEC SQL CONNECT :uid_pwd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )10;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
 sqlstm.sqlcmax = (unsigned int )100;
 sqlstm.sqlcmin = (unsigned int )2;
 sqlstm.sqlcincr = (unsigned int )1;
 sqlstm.sqlctimeout = (unsigned int )0;
 sqlstm.sqlcnowait = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR) 
	{
        disp_message(ORA_MESG,"Unable to connect to oracle.\n");
        proc_exit();
    }
    
    set_meduser_role();

/*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/*********************** added for globalisation ******************************/

    get_params();
	
	get_legend_value(33); //added for globalisation

	fetch_sys_info();

    strcpy(filename,WORKING_DIR);
    strcat(filename,"rlrljgph.lis");


    if( (f1=fopen(filename,"w")) == NULL)
	{
        disp_message(ERR_MESG,"Error in opening output file...\n");
		proc_exit();
    }

    page_no=1;
    line_no=1;

	fetch_sys_info();

    do_report();

    print_end_of_rep();

    fclose(f1);

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	print_job();

    return;

}


do_report()
{
	get_quality_std_values();

	line_no = 65;

	chk_break(1, 'N');

	print_std_values();

	line_no = 65;

	dclr_quality_cur();	
	while(fetch_quality_cur())
	{

		chk_break(1, 'Y');
		print_dtls();

	}

	close_quality_cur();

}

print_param_values() 
{

//    fprintf(f1, "Section			:	 %-1.1s %s\n", nd_section_code.arr, 
    fprintf(f1, "%-30.30s:	 %-1.1s %s\n", local_legend[1], nd_section_code.arr, //added for globalisation
								nd_section_name.arr);
//	fprintf(f1, "Quality			:	 %-1.1s %s\n", nd_quality_code.arr,
	fprintf(f1, "%-30.30s:	 %-1.1s %s\n", local_legend[2], nd_quality_code.arr, //added for globalisation
									nd_quality_name.arr);
//	fprintf(f1, "Test			:	 %s %s\n", nd_test_code.arr,
	fprintf(f1, "%-30.30s:	 %s %s\n", local_legend[3], nd_test_code.arr, //added for globalisation
								nd_test_name.arr);
//	fprintf(f1, "Test Units		:	 %s\n", nd_test_units_desc.arr);
	fprintf(f1, "%-30.30s:	 %s\n", local_legend[4], nd_test_units_desc.arr);//added for globalisation
//	fprintf(f1, "Batch ID		:	 %s\n", nd_batch_id.arr);
//	fprintf(f1, "Batch/Lot No.	:	 %s\n", nd_batch_id.arr);
	fprintf(f1, "%-30.30s:	 %s\n", local_legend[5], nd_batch_id.arr);//added for globalisation
//	fprintf(f1, "Instrument		:	 %s %s\n\n", nd_inst_code.arr,
	fprintf(f1, "%-30.30s:	 %s %s\n\n", local_legend[6], nd_inst_code.arr, //added for globalisation
								nd_inst_name.arr);			
	line_no += 7;
}

print_std_values()
{
	get_test_name();
	get_section_name();
	get_instrument_name();
	get_quality_name();

//    fprintf(f1, "Section			:	 %-1.1s %s\n", nd_section_code.arr, 
    fprintf(f1, "%-30.30s:	 %-1.1s %s\n", local_legend[1], nd_section_code.arr, //added for globalisation
								nd_section_name.arr);
//	fprintf(f1, "Quality			:	 %-1.1s %s\n", nd_quality_code.arr,
	fprintf(f1, "%-30.30s:	 %-1.1s %s\n", local_legend[2], nd_quality_code.arr, //added for globalisation
								nd_quality_name.arr);
//	fprintf(f1, "Test			:	 %s %s\n", nd_test_code.arr,
	fprintf(f1, "%-30.30s:	 %s %s\n", local_legend[3], nd_test_code.arr, //added for globalisation
								nd_test_name.arr);
//	fprintf(f1, "Test Units		:	 %s\n", nd_test_units_desc.arr);
	fprintf(f1, "%-30.30s:	 %s\n", local_legend[4], nd_test_units_desc.arr);//added for globalisation
//	fprintf(f1, "Batch ID		:	 %s\n", nd_batch_id.arr);
//	fprintf(f1, "Batch/Lot No.  :	 %s\n", nd_batch_id.arr);
	fprintf(f1, "%-30.30s:	 %s\n", local_legend[5], nd_batch_id.arr);//added for globalisation
//	fprintf(f1, "Instrument		:	 %s %s\n\n", nd_inst_code.arr,
	fprintf(f1, "%-30.30s:	 %s %s\n\n", local_legend[6], nd_inst_code.arr, //added for globalisation
								nd_inst_name.arr);			


// 	fprintf(f1, "Control Parameters \n\n");
 	fprintf(f1, "%s \n\n", local_legend[7]);

    add_zero_after_result(nd_std_deviation.arr);
 	fprintf(f1, "SD 	- %-10.10s\n", nd_std_deviation.arr);
	add_zero_after_result(nd_cf_variation.arr);
	fprintf(f1, "CV 	- %-10.10s\n", nd_cf_variation.arr);

	add_zero_after_result(nd_4_sd.arr);
	fprintf(f1, "4SD	- %-10.10s\n", nd_4_sd.arr);
	add_zero_after_result(nd_3_sd.arr);
	fprintf(f1, "3SD	- %-10.10s\n", nd_3_sd.arr);
	add_zero_after_result(nd_2_sd.arr);
	fprintf(f1, "2SD	- %-10.10s\n", nd_2_sd.arr);
	add_zero_after_result(nd_1_sd.arr);
	fprintf(f1, "1SD	- %-10.10s\n", nd_1_sd.arr);
	
	add_zero_after_result(nd_mean_value.arr);
	fprintf(f1, "MEAN	- %-10.10s\n", nd_mean_value.arr);

	add_zero_after_result(nd_m1_sd.arr);
	fprintf(f1, "-1SD	- %-10.10s\n", nd_m1_sd.arr);
	add_zero_after_result(nd_m2_sd.arr);
	fprintf(f1, "-2SD	- %-10.10s\n", nd_m2_sd.arr);
	add_zero_after_result(nd_m3_sd.arr);
	fprintf(f1, "-3SD	- %-10.10s\n", nd_m3_sd.arr);
	add_zero_after_result(nd_m4_sd.arr);
	fprintf(f1, "-4SD	- %-10.10s\n", nd_m4_sd.arr);

	line_no += 20;
}

print_dtls()
{
        /* EXEC SQL EXECUTE
			DECLARE
				t_date   date;
			BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_result_date,'dd/mm/yyyy hh24:mi'), :language_id , t_date);
				:nd_result_date1 := to_char(t_date,'dd/mm/yyyy hh24:mi');
			END;
		END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT\
_TO_LOCALE_DATE ( to_date ( :nd_result_date , 'dd/mm/yyyy hh24:mi' ) , :langua\
ge_id , t_date ) ; :nd_result_date1 := to_char ( t_date , 'dd/mm/yyyy hh24:mi'\
 ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )51;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_result_date;
        sqlstm.sqhstl[0] = (unsigned int  )22;
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
        sqlstm.sqhstv[2] = (         void  *)&nd_result_date1;
        sqlstm.sqhstl[2] = (unsigned int  )22;
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



	add_zero_after_result(nd_result_value.arr);
	fprintf(f1, "%-16.16s        %-20.20s   %-20.20s\n", nd_result_date1.arr, nd_result_value.arr, nd_quality_status.arr);
	line_no++;
}

get_quality_std_values()
{

	nd_std_deviation.arr[0]			= '\0';
	nd_cf_variation.arr[0]			= '\0';
	nd_mean_value.arr[0]			= '\0';
	nd_1_sd.arr[0]					= '\0';
	nd_2_sd.arr[0]					= '\0';
	nd_3_sd.arr[0]					= '\0';
	nd_4_sd.arr[0]					= '\0';
	nd_m1_sd.arr[0]					= '\0';
	nd_m2_sd.arr[0]					= '\0';
	nd_m3_sd.arr[0]					= '\0';
	nd_m4_sd.arr[0]					= '\0';

	nd_std_deviation.len			= 0;
	nd_cf_variation.len				= 0;
	nd_mean_value.len				= 0;
	nd_1_sd.len						= 0;
	nd_2_sd.len						= 0;
	nd_3_sd.len						= 0;
	nd_4_sd.len						= 0;
	nd_m1_sd.len					= 0;
	nd_m2_sd.len					= 0;
	nd_m3_sd.len					= 0;
	nd_m4_sd.len					= 0;

	
	/* EXEC SQL SELECT  TO_CHAR(std_deviation), TO_CHAR(cf_variation),
			TO_CHAR(mean_value), 
			TO_CHAR(A.mean_value + (1 * A.std_deviation)),
			TO_CHAR(A.mean_value + (2 * A.std_deviation)),
			TO_CHAR(A.mean_value + (3 * A.std_deviation)),
			TO_CHAR(A.mean_value + (4 * A.std_deviation)),
			TO_CHAR(A.mean_value + (-1 * A.std_deviation)),
			TO_CHAR(A.mean_value + (-2 * A.std_deviation)),
			TO_CHAR(A.mean_value + (-3 * A.std_deviation)),
			TO_CHAR(A.mean_value + (-4 * A.std_deviation))
	INTO    :nd_std_deviation, :nd_cf_variation,
			:nd_mean_value, 
			:nd_1_sd, :nd_2_sd, :nd_3_sd, :nd_4_sd,
			:nd_m1_sd, :nd_m2_sd, :nd_m3_sd, :nd_m4_sd
		FROM RL_TEST_QUALITY_MAST A
	    WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.qlty_code = :nd_quality_code
		AND A.section_code = :nd_section_code
		AND A.batch_id = :nd_batch_id
		AND A.inst_code = :nd_inst_code
		AND A.test_code = :nd_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(std_deviation) ,TO_CHAR(cf_variation) ,TO_CHA\
R(mean_value) ,TO_CHAR((A.mean_value+(1* A.std_deviation))) ,TO_CHAR((A.mean_v\
alue+(2* A.std_deviation))) ,TO_CHAR((A.mean_value+(3* A.std_deviation))) ,TO_\
CHAR((A.mean_value+(4* A.std_deviation))) ,TO_CHAR((A.mean_value+((-1)* A.std_\
deviation))) ,TO_CHAR((A.mean_value+((-2)* A.std_deviation))) ,TO_CHAR((A.mean\
_value+((-3)* A.std_deviation))) ,TO_CHAR((A.mean_value+((-4)* A.std_deviation\
))) into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from RL_TEST_QUALITY_MA\
ST A where (((((A.OPERATING_FACILITY_ID=:b11 and A.qlty_code=:b12) and A.secti\
on_code=:b13) and A.batch_id=:b14) and A.inst_code=:b15) and A.test_code=:b16)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )78;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_std_deviation;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_cf_variation;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_mean_value;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_1_sd;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_2_sd;
 sqlstm.sqhstl[4] = (unsigned int  )22;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_3_sd;
 sqlstm.sqhstl[5] = (unsigned int  )22;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_4_sd;
 sqlstm.sqhstl[6] = (unsigned int  )22;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_m1_sd;
 sqlstm.sqhstl[7] = (unsigned int  )22;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_m2_sd;
 sqlstm.sqhstl[8] = (unsigned int  )22;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_m3_sd;
 sqlstm.sqhstl[9] = (unsigned int  )22;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_m4_sd;
 sqlstm.sqhstl[10] = (unsigned int  )22;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[11] = (unsigned int  )5;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_quality_code;
 sqlstm.sqhstl[12] = (unsigned int  )7;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_batch_id;
 sqlstm.sqhstl[14] = (unsigned int  )33;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_inst_code;
 sqlstm.sqhstl[15] = (unsigned int  )12;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_test_code;
 sqlstm.sqhstl[16] = (unsigned int  )8;
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




    if(OERROR)
	    err_mesg("SELECT failed on table  RL_TEST_QUALITY_MAST",0,"");


	if (NO_DATA_FOUND)
		err_mesg("SELECT failed on table  RL_TEST_QUALITY_MAST",0,"");

	nd_std_deviation.arr[nd_std_deviation.len]			= '\0';
	nd_cf_variation.arr[nd_cf_variation.len]			= '\0';
	nd_mean_value.arr[nd_mean_value.len]				= '\0';
	nd_1_sd.arr[nd_1_sd.len]							= '\0';
	nd_2_sd.arr[nd_2_sd.len]							= '\0';
	nd_3_sd.arr[nd_3_sd.len]							= '\0';
	nd_4_sd.arr[nd_4_sd.len]							= '\0';
	nd_m1_sd.arr[nd_m1_sd.len]							= '\0';
	nd_m2_sd.arr[nd_m2_sd.len]							= '\0';
	nd_m3_sd.arr[nd_m3_sd.len]							= '\0';
	nd_m4_sd.arr[nd_m4_sd.len]							= '\0';


}

/********* DECLARE TEST_CURSOR **********/
dclr_quality_cur()
{
	

	/* EXEC SQL DECLARE quality_cursor CURSOR FOR
		SELECT TO_CHAR(result_value), 
	    TO_CHAR(B.result_date_time,'dd/mm/yyyy hh24:mi'),
		DECODE( B.quality_status, 'R', 'Rejected', 'Accepted')
		FROM RL_TEST_QUALITY_MAST A, RL_TEST_QUALITY_RESULTS B
		WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.qlty_code = :nd_quality_code
		AND A.qlty_code = B.qlty_code
		AND A.section_code = :nd_section_code
		AND A.section_code = B.section_code
		AND A.batch_id	= :nd_batch_id
		AND A.batch_id = B.batch_id
		AND A.inst_code = :nd_inst_code
		AND A.inst_code = B.inst_code
		AND A.test_code = :nd_test_code
		AND A.test_code = B.test_code
		AND B.result_date_time >=
		TO_DATE(:nd_fm_process_date, 'DD/MM/YYYYHH24:MI')
		AND B.result_date_time <
		TO_DATE(:nd_to_process_date, 'DD/MM/YYYYHH24:MI') + 1
		ORDER BY B.result_date_time; */ 


	 /* EXEC SQL OPEN quality_cursor; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0005;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )161;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_quality_code;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_batch_id;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_inst_code;
  sqlstm.sqhstl[5] = (unsigned int  )12;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_test_code;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fm_process_date;
  sqlstm.sqhstl[7] = (unsigned int  )22;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_process_date;
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
}



    if(OERROR)
	    err_mesg("Declare failed at dclr_quality_cur",0,"");


	#ifdef DEBUG
		printf("leaving dclr_quality_cur()\n");
		fflush(stdout);
	#endif
 }

close_quality_cur()
{
	

    /* EXEC SQL CLOSE quality_cursor; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )212;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	    err_mesg("Close failed at close_quality_cur",0,"");

	#ifdef DEBUG
		printf("leaving close_test_cur()\n");
		fflush(stdout);
	#endif
 }

/********************* FETCH SPECIMEN CURSOR ************************/
fetch_quality_cur()
{
	
	nd_result_value.arr[0]		= '\0';
	nd_result_value.len			= 0;
	nd_result_date.arr[0]			= '\0';
	nd_result_date.len			= 0;
	nd_quality_status.arr[0]	= '\0';
	nd_quality_status.len		= 0;

	/* EXEC SQL FETCH quality_cursor
			 INTO :nd_result_value, :nd_result_date, :nd_quality_status; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )227;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&nd_result_value;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_result_date;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_quality_status;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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
	    err_mesg("FETCH failed on cursor QUALITY_CURSOR CURSOR",0,"");

    if(NO_DATA_FOUND)
		return 0;

	nd_result_value.arr[nd_result_value.len]				= '\0';
	nd_result_date.arr[nd_result_date.len]					= '\0';
	nd_quality_status.arr[nd_quality_status.len]			= '\0';

	return 1;
}

/********************* PRINT END OF REPORT ************************/
print_end_of_rep()
{
    int col;
    char buff[REP_WIDTH+1];


    memset(buff,' ',REP_WIDTH-11);
    col = (int)(REP_WIDTH-19)/2;

    strncpy(buff+col,"** END OF REPORT **",19);

    fprintf(f1,"\n%s\n",buff);
		fprintf(f1,"\f");  // 28.04.2003 added  

}


/********************* FETCH HOSPITAL NAME ************************/
fetch_sys_info()
{

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
	     INTO   :comp_name,
		    :rep_date,
		    :oper_id
	     FROM   SY_ACC_ENTITY_lang_vw
		 WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		 and language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )254;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )1002;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&oper_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
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
    sqlstm.sqhstv[4] = (         void  *)&language_id;
    sqlstm.sqhstl[4] = (unsigned int  )7;
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



    if(OERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';
}

print_job()
{
	if (strcmp(nd_trx_ind.arr,"Y") == 0)

		 PrintDocument
			   (
				uid_pwd.arr,		//char	*PUidPwd;
				nd_session_id.arr,	//char	*PSessionID;
				nd_operating_facility_id.arr,	//char	*PFacilityID;
				"RL",				//char	*PModuleID;
				"RLROSWRG",			//char	*PDocumentID;
				filename,			//char	*POnlinePrintFileNames;
				"O",				//char	*PLocationTypes;
				nd_section_code.arr,				//char	*PLocationCodes;
				1,					//int		PNumOfCopies;
				1,					//int		PPageFrom;
				9999					//int		PPageTo;
			   );
						   

	else 

		 PrintDocument
			   (
				uid_pwd.arr,		//char	*PUidPwd;
				nd_session_id.arr,	//char	*PSessionID;
				nd_operating_facility_id.arr,	//char	*PFacilityID;
				"RL",				//char	*PModuleID;
				"RLROSWRG",			//char	*PDocumentID;
				filename,			//char	*POnlinePrintFileNames;
				"O",				//char	*PLocationTypes;
				"~",				//char	*PLocationCodes;
				1,					//int		PNumOfCopies;
				1,					//int		PPageFrom;
				9999					//int		PPageTo;
			   );  
}

/********************* CHECK PAGE BREAK ************************/
chk_break(nol, l_flag)
int nol;
char l_flag;
{

	if(line_no + nol >= 63)
	{
       line_no = 1;
	   form_hdr();

	   if (l_flag == 'Y')
			print_param_values();
			put_hdr();
	}
}

/********************* FORM HDR ************************/
form_hdr()
{

    static int first = 1;
    char buf[15];
    int col;

        strcpy(rep_title2,"");

    if(first) 
	{
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
        memset(hdr_line4,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL : RL",8);
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));
 
		  /* EXEC SQL EXECUTE
			DECLARE
				t_date   date;
			BEGIN
				t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				:rep_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
			END;
		  END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . G\
ET_CURRENT_DATE ( :language_id ) ; :rep_date1 := to_char ( t_date , 'DD/MM/YYY\
Y HH24:MI' ) ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )289;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&language_id;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_date1;
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
}



        col = (REP_WIDTH-strlen(rep_date1.arr));
        strcpy(hdr_line1+col,rep_date1.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRLJGPH",14);
    strcpy(rep_title1,local_legend[8]); //added for globalisation
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    //sprintf(buf,"PAGE : %4d",page_no++);
    sprintf(buf,"%-4.4s : %4d",local_legend[9],page_no++); //added for globalisation
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

    col = (int)(REP_WIDTH-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    if(first)
        fprintf(f1,"%s\n",hdr_line1);
    else
	  {
	    fprintf(f1,"\n");
        fprintf(f1,"\f%s\n",hdr_line1);
	  }
    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
    fprintf(f1,"%s\n",hdr_line4);
    fprintf(f1,"%s\n",hdr_line5);

    first = 0;
}

/********************* REPORT HEADER ************************/
put_hdr()
{
   
//   fprintf(f1,"Result Date             Value                  Status\n");
   fprintf(f1,"%-15.15s         %-11.11s            %-13.13s\n", local_legend[10], local_legend[11], local_legend[12] ); //added for globalisation
   fprintf(f1, "--------------------------------------------------------------------------------\n");
   
   line_no += 2;

}

/********* GET SECTION_NAME  **********/
 get_section_name()
 {
    nd_section_name.arr[0]	= '\0';
	nd_section_name.len		= 0;


	/* EXEC SQL SELECT long_name
	INTO :nd_section_name
	FROM RL_SECTION_CODE_lang_vw
	WHERE section_code = :nd_section_code
	and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_name into :b0  from RL_SECTION_CODE_lang_vw wher\
e (section_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )312;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_section_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
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



#ifdef DEBUG
    printf("leaving dclr_section_cur()\n");
    fflush(stdout);
#endif

	nd_section_name.arr[nd_section_name.len]	= '\0';

 }


/********* GET TEST_NAME  **********/
  get_test_name()
  {
    nd_test_name.arr[0]		= '\0';
	nd_test_name.len		= 0;
	nd_test_units.arr[0]	= '\0';
	nd_test_units.len		= 0;


//	EXEC SQL SELECT short_desc
	/* EXEC SQL SELECT long_desc, test_units, no_of_decimals
	INTO :nd_test_name, :nd_test_units, v_no_of_decimals
	FROM RL_TEST_CODE_lang_vw 
	WHERE test_code = :nd_test_code
	and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc ,test_units ,no_of_decimals into :b0,:b1,:b\
2  from RL_TEST_CODE_lang_vw where (test_code=:b3 and language_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )339;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_test_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_test_units;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&v_no_of_decimals;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_test_code;
 sqlstm.sqhstl[3] = (unsigned int  )8;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&language_id;
 sqlstm.sqhstl[4] = (unsigned int  )7;
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



#ifdef DEBUG
    printf("leaving dclr_source_cur()\n");
    fflush(stdout);
#endif

	nd_test_name.arr[nd_test_name.len]		= '\0';
	nd_test_units.arr[nd_test_units.len]	= '\0';

    get_test_units_desc_from_sy_uom();  //// 20.02.2006

  }


/********* GET QUALITY_NAME  **********/
 get_quality_name()
 {
    nd_quality_name.arr[0]	= '\0';
	nd_quality_name.len		= 0;


	/* EXEC SQL SELECT long_desc
	INTO :nd_quality_name
	FROM RL_QUALITY_CODE_lang_vw
	WHERE section_code = :nd_section_code
	AND qlty_code = :nd_quality_code
	and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_QUALITY_CODE_lang_vw wher\
e ((section_code=:b1 and qlty_code=:b2) and language_id=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )374;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_quality_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_quality_code;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&language_id;
 sqlstm.sqhstl[3] = (unsigned int  )7;
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



#ifdef DEBUG
    printf("leaving dclr_section_cur()\n");
    fflush(stdout);
#endif

	nd_quality_name.arr[nd_quality_name.len]	= '\0';

 }

/********* GET INSTRUMENT_NAME  **********/
 get_instrument_name()
 {
    nd_inst_name.arr[0]	= '\0';
	nd_inst_name.len		= 0;

	/* EXEC SQL SELECT long_desc
	INTO :nd_inst_name
	FROM RL_ONLINE_INSTRUMENT_lang_vw
	WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND section_code = :nd_section_code
	AND instrument_code = :nd_inst_code
	and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_ONLINE_INSTRUMENT_lang_vw\
 where (((OPERATING_FACILITY_ID=:b1 and section_code=:b2) and instrument_code=\
:b3) and language_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )405;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_inst_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_inst_code;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&language_id;
 sqlstm.sqhstl[4] = (unsigned int  )7;
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



#ifdef DEBUG
    printf("leaving dclr_section_cur()\n");
    fflush(stdout);
#endif

	nd_inst_name.arr[nd_inst_name.len]	= '\0';

 }

/************* get_params ***************/
get_params()
{
	nd_test_code.arr[0]			= '\0' ;
	nd_test_code.len			= 0;
	nd_batch_id.arr[0]			= '\0';
	nd_batch_id.len				= 0;
	nd_inst_code.arr[0]			= '\0';
	nd_inst_code.len			= 0;

   if(OERROR)
      disp_message(ORA_MESG,"get parameter function using : \n");

   /* read the parameter record */
   /* EXEC SQL SELECT 
               OPERATING_FACILITY_ID,
               PARAM1,
			   PARAM2,
			   PARAM3
   	     INTO 
		    :nd_operating_facility_id,
			:nd_test_code,
			:nd_batch_id,
			:nd_inst_code
         FROM SY_PROG_PARAM
	     WHERE  UPPER(PGM_ID) = 'RLRLJGPH'
		 AND SESSION_ID = TO_NUMBER(:nd_session_id)
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 into \
:b0,:b1,:b2,:b3  from SY_PROG_PARAM where ((UPPER(PGM_ID)='RLRLJGPH' and SESSI\
ON_ID=TO_NUMBER(:b4)) and PGM_DATE=:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )440;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_test_code;
   sqlstm.sqhstl[1] = (unsigned int  )8;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_batch_id;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_inst_code;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[4] = (unsigned int  )33;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[5] = (unsigned int  )23;
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


	
   if(OERROR)
      disp_message(ORA_MESG,"get_parameter_function2 : \n");
   

	nd_test_code.arr[nd_test_code.len]			= '\0' ;
	nd_batch_id.arr[nd_batch_id.len]			= '\0';
	nd_inst_code.arr[nd_inst_code.len]			= '\0';


  #ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" nd_test_code = %s\n",nd_test_code.arr);
   getchar();  
	#endif
  /* delete the parameter record */
   
   /* EXEC SQL DELETE FROM SY_PROG_PARAM
	        WHERE  UPPER(PGM_ID) = 'RLRLJGPH'
	        AND    SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND    PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLRLJGP\
H' and SESSION_ID=TO_NUMBER(:b0)) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )479;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[1] = (unsigned int  )23;
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
      disp_message(ORA_MESG,"delete on sy_prog_param failed : \n");

}
/*--------------------------------------------------------------------------------*/
add_zero_after_result(char *t_str)
{
	int i = 0;
	char rslt[21];
	int l_decimal_position = 0;
	float l_r_value = 0;
	char s_r_value[20];

    	strcpy(rslt, t_str);

		strcpy(r_rslt.arr, t_str);
		r_rslt.len = strlen(r_rslt.arr);

		l_r_value = atof(r_rslt.arr);
	
		if (l_r_value > 0  &&  l_r_value < 1)
		{
			if (r_rslt.arr[0] != '0')
			{
				strcpy(s_r_value, "0");
				strcat(s_r_value, r_rslt.arr);

				strcpy(r_rslt.arr, s_r_value);
				r_rslt.len = strlen(r_rslt.arr);

			}
		}

		v_numeric_result.arr[0]		= '\0';
		v_numeric_result.len		= 0;

		l_exist_decimals = 0;
		l_inst_decimals = 0;


		
		/* EXEC SQL SELECT TO_NUMBER(:r_rslt) - FLOOR(TO_NUMBER(:r_rslt)),
						LENGTH(SUBSTR(:r_rslt, INSTR(:r_rslt, '.') + 1)), INSTR(:r_rslt, '.')
				 INTO :v_numeric_result, :l_exist_decimals, :l_inst_decimals
				 FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (TO_NUMBER(:b0)-FLOOR(TO_NUMBER(:b0))) ,LENGTH(SUBST\
R(:b0,(INSTR(:b0,'.')+1))) ,INSTR(:b0,'.') into :b5,:b6,:b7  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )502;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&r_rslt;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&r_rslt;
  sqlstm.sqhstl[1] = (unsigned int  )32;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&r_rslt;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&r_rslt;
  sqlstm.sqhstl[3] = (unsigned int  )32;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&r_rslt;
  sqlstm.sqhstl[4] = (unsigned int  )32;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&v_numeric_result;
  sqlstm.sqhstl[5] = (unsigned int  )32;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_exist_decimals;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_inst_decimals;
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



	
		v_numeric_result.arr[v_numeric_result.len]	= '\0';

		if (l_inst_decimals == 0)
			l_exist_decimals = 0;

		l_decimal_position = l_exist_decimals;


		for (i = l_exist_decimals;i < v_no_of_decimals; i++)
		{

				
				if (l_decimal_position == 0)
					strcat(r_rslt.arr, ".");				
	
				strcat(r_rslt.arr, "0");

				l_decimal_position++;

		}

		r_rslt.len = strlen(r_rslt.arr);

	
		for (i = 0; i < 10; i++)
		{
			rslt[i] = r_rslt.arr[i];
		}

		rslt[i] = '\0';

	    strcpy(r_rslt.arr, rslt);
	    r_rslt.len = strlen(r_rslt.arr);

    	strcpy(t_str, r_rslt.arr);

}

/*--------- added the below on 20.02.2006 -------------------------------------*/
get_test_units_desc_from_sy_uom()
{

   nd_test_units_desc.arr[0]		= '\0';      
   nd_test_units_desc.len		= 0;

   /* EXEC SQL SELECT  short_desc
			  INTO :nd_test_units_desc
		  	  FROM SY_UOM_lang_vw
			 WHERE uom_code = :nd_test_units
			 and language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from SY_UOM_lang_vw where (uom\
_code=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )549;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_test_units_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_test_units;
   sqlstm.sqhstl[1] = (unsigned int  )32;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&language_id;
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



	if (NO_DATA_FOUND)
	{
		strcpy(nd_test_units_desc.arr,nd_test_units.arr);    
		nd_test_units_desc.len = strlen(nd_test_units_desc.arr);
//		rl_tst_cd_test_units_desc.arr[rl_tst_cd_test_units_desc.len]	= '\0';

	}

    if (OERROR)
	{
		strcpy(nd_test_units_desc.arr,nd_test_units.arr);    
		nd_test_units_desc.len = strlen(nd_test_units_desc.arr);
	}

	nd_test_units_desc.arr[nd_test_units_desc.len]	= '\0';

}
/*------------------------------------------------------------*/
/****************************** added for globalisation *****************************/
get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRLJGPH.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRLJGPH.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )576;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRLJGPH.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRLJGPH.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )599;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )502;
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

