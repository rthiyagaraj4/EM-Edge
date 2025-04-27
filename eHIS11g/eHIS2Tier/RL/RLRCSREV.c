
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRCSREV.PC"
};


static unsigned int sqlctx = 1288614683;


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
            void  *sqhstv[8];
   unsigned int   sqhstl[8];
            int   sqhsts[8];
            void  *sqindv[8];
            int   sqinds[8];
   unsigned int   sqharm[8];
   unsigned int   *sqharc[8];
   unsigned short  sqadto[8];
   unsigned short  sqtdso[8];
} sqlstm = {12,8};

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

 static const char *sq0003 = 
"select count(A.TEST_CODE) ,A.TEST_CODE ,A.REFERRED_LAB_CODE  from RL_REFERRE\
D_SPECIMENS A ,RL_REQUEST_HEADER B where (((((((A.OPERATING_FACILITY_ID=B.OPER\
ATING_FACILITY_ID and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.OPERATING_FACILITY_ID\
=:b0) and B.SPEC_REGD_DATE_TIME>=TO_DATE(:b1,'DD/MM/YYYYhh24:mi:ss')) and B.SP\
EC_REGD_DATE_TIME<TO_DATE(:b2,'DD/MM/YYYYhh24:mi:ss')) and A.SENT_DATE is  not\
 null ) and A.REFERRED_LAB_CODE is  not null ) and NVL(A.PROCESS_IN_HOUSE_YN,'\
N')<>'Y') group by A.TEST_CODE,A.REFERRED_LAB_CODE order by A.REFERRED_LAB_COD\
E,A.TEST_CODE            ";

 static const char *sq0004 = 
"select count(A.TEST_CODE) ,A.TEST_CODE ,A.REFERRED_LAB_CODE  from RL_REFERRE\
D_SPECIMENS A ,RL_REQUEST_HEADER B where ((((((((A.OPERATING_FACILITY_ID=B.OPE\
RATING_FACILITY_ID and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.OPERATING_FACILITY_I\
D=:b0) and B.SPEC_REGD_DATE_TIME>=TO_DATE(:b1,'DD/MM/YYYYhh24:mi:ss')) and B.S\
PEC_REGD_DATE_TIME<TO_DATE(:b2,'DD/MM/YYYYhh24:mi:ss')) and a.referred_lab_cod\
e=:b3) and A.SENT_DATE is  not null ) and A.REFERRED_LAB_CODE is  not null ) a\
nd NVL(A.PROCESS_IN_HOUSE_YN,'N')<>'Y') group by A.TEST_CODE,A.REFERRED_LAB_CO\
DE order by A.REFERRED_LAB_CODE,A.TEST_CODE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,120,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,232,0,0,0,0,0,1,0,
51,0,0,5,155,0,4,305,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
86,0,0,3,569,0,9,334,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
113,0,0,4,599,0,9,344,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
144,0,0,6,94,0,4,394,0,0,8,4,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
191,0,0,7,94,0,4,459,0,0,8,4,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
238,0,0,8,94,0,4,513,0,0,8,4,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
285,0,0,9,143,0,6,721,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
308,0,0,10,143,0,6,730,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
331,0,0,3,0,0,13,797,0,0,3,0,0,1,0,2,3,0,0,2,9,0,0,2,9,0,0,
358,0,0,4,0,0,13,807,0,0,3,0,0,1,0,2,3,0,0,2,9,0,0,2,9,0,0,
385,0,0,11,0,0,32,823,0,0,0,0,0,1,0,
400,0,0,12,214,0,4,837,0,0,6,3,0,1,0,2,9,0,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
439,0,0,3,0,0,15,868,0,0,0,0,0,1,0,
454,0,0,4,0,0,15,878,0,0,0,0,0,1,0,
469,0,0,13,111,0,4,895,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
496,0,0,14,95,0,4,917,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
523,0,0,15,99,0,6,966,0,0,1,1,0,1,0,1,9,0,0,
542,0,0,16,136,0,6,976,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/*
Author			:	Srikanth A
Date Creation	:	29/07/2004
Purpose			:	To report the cost summary for a given
					range of specimen registration date.
*/
#include <stdio.h>         
#include <string.h> 
#include <stdlib.h>     
#include <rl.h>         
#include <math.h> 

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define NODATAFOUND sqlca.sqlcode == 1403
#define MAX_LINES 55
#define REP_WIDTH 78

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hosp_name       [120],
			comp_name		[500],
			sql_stmt		[5000],
			oper_id			[31],
			rep_date		[20],
	        lab_name		[16],	
			er_msg			[200],
			test_name		[11],	
			tst_code		[10],
			ref_lcode		[4],
		    old_lab_code	[5],	
		    old_tst_code	[5],
			date			[20],
			date1			[20],
            date_time       [20],
            date_time1       [20],
            user_id			[91],
	        nd_pwd			[91],
			nd_session_id   [16],           		   
		    nd_file_name	[100],
            d_curr_pgm_name [15],
			nd_facility	    [3],
		    nd_fm_date      [18],
		    nd_to_date 	    [18],
		    nd_ref_code		[5],
			fcy_code	    [5],
			cur_date		[13]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[500]; } comp_name;

struct { unsigned short len; unsigned char arr[5000]; } sql_stmt;

struct { unsigned short len; unsigned char arr[31]; } oper_id;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[16]; } lab_name;

struct { unsigned short len; unsigned char arr[200]; } er_msg;

struct { unsigned short len; unsigned char arr[11]; } test_name;

struct { unsigned short len; unsigned char arr[10]; } tst_code;

struct { unsigned short len; unsigned char arr[4]; } ref_lcode;

struct { unsigned short len; unsigned char arr[5]; } old_lab_code;

struct { unsigned short len; unsigned char arr[5]; } old_tst_code;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date1;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } date_time1;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[100]; } nd_file_name;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[18]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[18]; } nd_to_date;

struct { unsigned short len; unsigned char arr[5]; } nd_ref_code;

struct { unsigned short len; unsigned char arr[5]; } fcy_code;

struct { unsigned short len; unsigned char arr[13]; } cur_date;

	/***************added for globalisation*************************/
	/* varchar		l_translated_value		 [500],
	language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;


	int i;
	/***************added for globalisation*************************/
		    
int cnt_test_code=0, tot_code=0,grd_tot_code=0,er_msg_type=0;
double calc_lcy_tot =0.0, calc_fcy_tot =0.0, lcy_tot=0.0, fcy_tot=0.0 ;
double grd_fcy_tot =0.0, grd_lcy_tot =0.0,lcy_rate=0.0,fcy_rate=0.0;

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





/* global variable declaration*/

#include <winproc.h>
int	 lctr=0, d_first=1;
int	 line_no		= 0;
int	 page_no		= 1;
int	 i				= 0;
int  new_pag        = 1;
int	 ref_head		= 0;

char string_var	[200];
char rep_title2[30];
char tmpbuf[1000];
char local_legend[35][500];//added for globalisation

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1],
	 hdr_line6[REP_WIDTH+1];

//char rep_title1[] = "Referral Lab Cost Summary Report";
char rep_title1[40]; //added for globalisation

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{		
	if (argc < 9)
	 {	      	      
		  disp_message(ERR_MESG,"Usage rlrcsrev <uid/passwd> <session_id> <pgm date> <facility> <output filename> <ref_lab_code> <from date> <to date> ");
	      proc_exit();	
       }

 /*	strcpy(g_pgm_id,"RLRCSREV");	*/

    nd_fm_date.arr[0]			= '\0';
    nd_to_date.arr[0]			= '\0';
    nd_ref_code.arr[0]			= '\0';
	    		
    nd_fm_date.len			= 0;
    nd_to_date.len			= 0;
    nd_ref_code.len			= 0;

	strcpy(nd_pwd.arr,argv[1]);
	nd_pwd.len = strlen(nd_pwd.arr);

 	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
 

	/* EXEC sql connect :nd_pwd; */ 

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
 sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



    if (sqlca.sqlcode < 0 )
     {
         disp_message(ORA_MESG,"Error in connecting to Oracle");
         proc_exit();
      }
        	
    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
 
	/* ARGV[3] IS PGM DATE WHICH IS NOT REQUIRED */
	   
    strcpy(nd_facility.arr,argv[4]);
    nd_facility.len = strlen(nd_facility.arr);

	strcpy(OUTPUT_FILE_NAME, argv[5]);
		    
	strcpy(nd_ref_code.arr,argv[6]);
    nd_ref_code.len = strlen(nd_ref_code.arr);

	if (nd_ref_code.arr[0] == '!')
	 {       
	   nd_ref_code.arr[1] = '\0';
	   nd_ref_code.len  = strlen(nd_ref_code.arr);
	 }

	if (nd_fm_date.len == 0)
	 {
       nd_fm_date.arr[0] = '!';
	   nd_fm_date.arr[1] = '\0';
	 }

	if (nd_to_date.len == 0)
	 {
       nd_to_date.arr[0] = '!';
	   nd_to_date.arr[1] = '\0';
	 }

	strcpy(nd_fm_date.arr,argv[7]);
    nd_fm_date.len = strlen(nd_fm_date.arr);

	strcpy(nd_to_date.arr,argv[8]);
    nd_to_date.len = strlen(nd_to_date.arr);
	
	
	strcpy(old_lab_code.arr,"!!!!");
	old_lab_code.len  = strlen(old_lab_code.arr);

	strcpy(old_tst_code.arr,"!!!!");
	old_tst_code.len  = strlen(old_tst_code.arr);

	set_meduser_role();    
/*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/*********************** added for globalisation ******************************/
	get_legend_value(33); //added for globalisation

/*****************
    EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5
				INTO	:nd_trn_type,
						:nd_status,
						:nd_fm_date,
						:nd_to_date,
						:nd_fm_reason_code,
						:nd_to_reason_code
	      FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date;
    if (OERROR)
        disp_message("SELECT failed on table SY_PROG_PARAM Source:RLRCSREV",0,"");

    if (NODATAFOUND)
        disp_message("No Record found in SY_PROG_PARAM Source:RLRCSREV",0,"");

    nd_fm_reason_code.arr[nd_fm_reason_code.len]	= '\0';
    nd_to_reason_code.arr[nd_to_reason_code.len]	= '\0';
    nd_fm_date.arr[nd_fm_date.len]				= '\0';
    nd_to_date.arr[nd_to_date.len]				= '\0';

    EXEC SQL DELETE FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date;
   
    if (OERROR)
        disp_message("DELETE failed on table SY_PROG_PARAM Source:RLRCSREV",0,"");

************/

    gen_file_name();

	fetch_hosp_name();

    declare_cur();
    
    open_cur_val();

    print_hdr();

    end_of_rep();

	fclose(fp);
	return;

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 
 
    sprintf(string_var,"%s \n",sqlca.sqlerrm.sqlerrmc);
    disp_message(ERR_MESG,string_var);
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



}

declare_cur()
{

	sql_stmt.arr[0] = '\0';
	sql_stmt.len    = 0;

	if (nd_ref_code.arr[0] == '!')	
	   {			    
		
		 /* EXEC SQL DECLARE VAL_CUR CURSOR FOR	
		     SELECT COUNT(A.TEST_CODE), A.TEST_CODE, A.REFERRED_LAB_CODE 
		     FROM RL_REFERRED_SPECIMENS A, RL_REQUEST_HEADER B 
		     WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND 
		     A.SPECIMEN_NO = B.SPECIMEN_NO 
		     AND A.OPERATING_FACILITY_ID = :nd_facility    	
		     AND B.SPEC_REGD_DATE_TIME >= TO_DATE(:nd_fm_date, 'DD/MM/YYYYhh24:mi:ss')
		     AND B.SPEC_REGD_DATE_TIME < TO_DATE(:nd_to_date, 'DD/MM/YYYYhh24:mi:ss')		     
		     AND A.SENT_DATE IS NOT NULL  
		     AND A.REFERRED_LAB_CODE IS NOT NULL 
		     AND NVL(A.PROCESS_IN_HOUSE_YN,'N') <> 'Y' 
		     GROUP BY A.TEST_CODE,A.REFERRED_LAB_CODE 	
             ORDER BY A.REFERRED_LAB_CODE,A.TEST_CODE; */ 
 


			if (OERROR)
			  {	
				 disp_message(ERR_MESG,"Declare Cursor failed in RLRCSREV");
		      }
	    }
     else
	    {
	   	
		/* EXEC SQL DECLARE REF_LAB_VAL_CUR CURSOR FOR	
		     SELECT COUNT(A.TEST_CODE), A.TEST_CODE, A.REFERRED_LAB_CODE 
		     FROM RL_REFERRED_SPECIMENS A, RL_REQUEST_HEADER B 
		     WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND 
		     A.SPECIMEN_NO = B.SPECIMEN_NO 
		     AND A.OPERATING_FACILITY_ID = :nd_facility    	
		     AND B.SPEC_REGD_DATE_TIME >= TO_DATE(:nd_fm_date, 'DD/MM/YYYYhh24:mi:ss')
		     AND B.SPEC_REGD_DATE_TIME < TO_DATE(:nd_to_date, 'DD/MM/YYYYhh24:mi:ss')
		     AND a.referred_lab_code = :nd_ref_code 					
		     AND A.SENT_DATE IS NOT NULL  
		     AND A.REFERRED_LAB_CODE IS NOT NULL 
		     AND NVL(A.PROCESS_IN_HOUSE_YN,'N') <> 'Y' 
		     GROUP BY A.TEST_CODE,A.REFERRED_LAB_CODE 	
             ORDER BY A.REFERRED_LAB_CODE,A.TEST_CODE; */ 
 


			if (OERROR)
			  {	
				disp_message(ERR_MESG,"Declare Cursor failed in RLRCSREV");
		      }
	
	    }

}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    date.arr[0]		 = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    date.len		 = 0;
    user_id.len      = 0;


/* EXEC SQL SELECT ACCOUNTING_NAME, 
				TO_CHAR(SYSDATE,'DD/MM/RRRR'),
				TO_CHAR(SYSDATE,'HH24:MI:SS'),
				USER
           INTO :hosp_name, 
				:date,
				:date_time, 
				:user_id
           FROM SY_ACC_ENTITY
          WHERE ACC_ENTITY_ID = :nd_facility; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 5;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/RRRR') ,TO_CHA\
R(SYSDATE,'HH24:MI:SS') ,USER into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY where A\
CC_ENTITY_ID=:b4";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )51;
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
sqlstm.sqhstv[1] = (         void  *)&date;
sqlstm.sqhstl[1] = (unsigned int  )22;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&date_time;
sqlstm.sqhstl[2] = (unsigned int  )22;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&user_id;
sqlstm.sqhstl[3] = (unsigned int  )93;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_facility;
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
		disp_message(ERR_MESG,"SELECT failed on table SY_ACC_ENTITY");

    hosp_name.arr[hosp_name.len]           = '\0';
    date_time.arr[date_time.len]           = '\0';
    date.arr[date.len]					   = '\0';
    user_id.arr[user_id.len]               = '\0';

}


open_cur_val() 
{

	if (nd_ref_code.arr[0] == '!')	
	   {			
		/* EXEC SQL OPEN VAL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0003;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )86;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[1] = (unsigned int  )20;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[2] = (unsigned int  )20;
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

  

		  if (OERROR)
			{	
				disp_message(ERR_MESG,"Open cursor failed on VAL_CUR");
				return 0;
		    }
	   }
    else
	   {
		/* EXEC SQL OPEN REF_LAB_VAL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0004;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )113;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[1] = (unsigned int  )20;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[2] = (unsigned int  )20;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_ref_code;
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

 

			if (OERROR)
			{	
	 			disp_message(ERR_MESG,"Open cursor failed on REF_LAB_VAL_CUR");
				return 0;
			}
	  }
	return 1;
}

print_hdr()
{
    unsigned int status;
	char space[4];

	strcpy(space,"   ");
	space[4] = '\0';

	print_head();
			
    while (fetch_dtl())
    {	   	   
       if (d_first == 1)
		{		  	        
			status = fetch_lab_desc();
			if (status == 0)
			 {
			  continue;
		     }
			 			 

	       /* print the referral lab desc */
	          print_lab();
	       /* get the test details */
               status = fetch_test_desc();
               if (status == 0)
				{
					continue;
				}
			/* get the ccy, rate details */
               status = fetch_ccy_details();
               if (status == 0)
				{
					continue;
				}
	
              calc_lcy_tot = cnt_test_code * lcy_rate;
			  calc_fcy_tot = cnt_test_code * fcy_rate;

	     /* EXEC SQL SELECT ROUND(:calc_lcy_tot,2), 
						 ROUND(:calc_fcy_tot,2), 
						 ROUND(:lcy_rate,2),
						 ROUND(:fcy_rate,2) 
				    INTO :calc_lcy_tot, 
						 :calc_fcy_tot,
						 :lcy_rate,
						 :fcy_rate
				    FROM DUAL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select ROUND(:b0,2) ,ROUND(:b1,2) ,ROUND(:b2,2) ,ROUND(\
:b3,2) into :b0,:b1,:b2,:b3  from DUAL ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )144;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&calc_lcy_tot;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&calc_fcy_tot;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&lcy_rate;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&fcy_rate;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&calc_lcy_tot;
      sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&calc_fcy_tot;
      sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&lcy_rate;
      sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&fcy_rate;
      sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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

 

         fprintf(fp," %-14s %5d %9.2f %10.2f   %5s %9.2f %12.2f \n",test_name.arr,cnt_test_code,lcy_rate,calc_lcy_tot,fcy_code.arr,fcy_rate,calc_fcy_tot);
		 lctr = lctr+1;   	

		 /* compute total count, total lcy, total fcy and cumulate grand lcy, fcy */

		 tot_code     += cnt_test_code;
		 lcy_tot	  += calc_lcy_tot;
		 fcy_tot	  += calc_fcy_tot;
		 grd_lcy_tot  += calc_lcy_tot;
		 grd_fcy_tot  += calc_fcy_tot;	
		 grd_tot_code += cnt_test_code;

         /* copy the contents of referral lab to old_var here, for first time old_ref keeps changing for unique referral */

		 strcpy(old_lab_code.arr,ref_lcode.arr);
		 old_lab_code.len=strlen(old_lab_code.arr);

		 strcpy(old_tst_code.arr,tst_code.arr);
		 old_tst_code.len=strlen(old_tst_code.arr);

	     /* reset the flag of d_first here */
         d_first = 0;
	   }
    
	if (strcmp(old_lab_code.arr, ref_lcode.arr) != 0)
	   {		  	   
           /* print total here by calling print_total() */

	       print_total();
	       lctr=lctr+2;   	
           check_page_end(4,0);
	       
	       /* print each of the test details here */
			status = fetch_lab_desc();
			if (status == 0)
			{
				continue;
			}
	       /* print the referral lab desc */
			  print_lab();
	       /* get the test details */
            status = fetch_test_desc();
	        if (status == 0)
	          {
				continue;
			  }
		   /* get the ccy, rate details */
            status = fetch_ccy_details();
			if (status == 0)
	          {
				continue;
			  }
            calc_lcy_tot = cnt_test_code * lcy_rate;
	        calc_fcy_tot = cnt_test_code * fcy_rate;

	        /* EXEC SQL SELECT ROUND(:calc_lcy_tot,2),
							ROUND(:calc_fcy_tot,2),
							ROUND(:lcy_rate,2),
							ROUND(:fcy_rate,2) 
					   INTO :calc_lcy_tot,
						    :calc_fcy_tot,
							:lcy_rate,
							:fcy_rate
					   FROM DUAL; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 12;
         sqlstm.arrsiz = 8;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select ROUND(:b0,2) ,ROUND(:b1,2) ,ROUND(:b2,2) ,ROU\
ND(:b3,2) into :b0,:b1,:b2,:b3  from DUAL ";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )191;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)4352;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&calc_lcy_tot;
         sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&calc_fcy_tot;
         sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&lcy_rate;
         sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&fcy_rate;
         sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&calc_lcy_tot;
         sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&calc_fcy_tot;
         sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&lcy_rate;
         sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&fcy_rate;
         sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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

 

		fprintf(fp," %-14s %5d %9.2f %10.2f   %5s %9.2f %12.2f \n",test_name.arr,cnt_test_code,lcy_rate,calc_lcy_tot,fcy_code.arr,fcy_rate,calc_fcy_tot);

		lctr = lctr+1;   	
		check_page_end(4,0);

		/* compute total count, total lcy, total fcy and cumulate grand lcy, fcy */

		tot_code     += cnt_test_code;
		lcy_tot      += calc_lcy_tot;
		fcy_tot      += calc_fcy_tot;
		grd_lcy_tot  += calc_lcy_tot;
		grd_fcy_tot  += calc_fcy_tot;	
		grd_tot_code += cnt_test_code;

        /* copy the contents of referral lab to old_var here, for first time old_ref keeps changing for unique referral */
		strcpy(old_lab_code.arr,ref_lcode.arr);
		old_lab_code.len=strlen(old_lab_code.arr);      

		strcpy(old_tst_code.arr,tst_code.arr);
		old_tst_code.len=strlen(old_tst_code.arr);      
	   }
	  else
	   {
		 if (strcmp(old_tst_code.arr, tst_code.arr) != 0)
		  {	
			 
           /* This is same lab code, but different test code */  
			/* get the test details */
               status = fetch_test_desc();
				if (status == 0)
				{
					continue;
				}
			 
		   /* get the ccy, rate details */

           status = fetch_ccy_details();
			if (status == 0)
	          {
				continue;
			  }
				calc_lcy_tot = cnt_test_code * lcy_rate;
				calc_fcy_tot = cnt_test_code * fcy_rate;

			/* EXEC SQL SELECT ROUND(:calc_lcy_tot,2),
			                ROUND(:calc_fcy_tot,2), 
							ROUND(:lcy_rate,2), 
							ROUND(:fcy_rate,2)
					   INTO :calc_lcy_tot,
							:calc_fcy_tot,
							:lcy_rate,
							:fcy_rate
					   FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ROUND(:b0,2) ,ROUND(:b1,2) ,ROUND(:b2,2) ,ROUND(:b3\
,2) into :b0,:b1,:b2,:b3  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )238;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&calc_lcy_tot;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&calc_fcy_tot;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&lcy_rate;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&fcy_rate;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&calc_lcy_tot;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&calc_fcy_tot;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&lcy_rate;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&fcy_rate;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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

       

			fprintf(fp," %-14s %5d %9.2f %10.2f   %5s %9.2f %12.2f \n",test_name.arr,cnt_test_code,lcy_rate,calc_lcy_tot,fcy_code.arr,fcy_rate,calc_fcy_tot);
			lctr=lctr+1;   	

			check_page_end(4,0);  

			/* compute total count, total lcy, total fcy and cumulate grand lcy, fcy */

			tot_code     += cnt_test_code;
			lcy_tot      += calc_lcy_tot;
			fcy_tot      += calc_fcy_tot;
			grd_lcy_tot  += calc_lcy_tot;
			grd_fcy_tot  += calc_fcy_tot;	
			grd_tot_code += cnt_test_code;

			/* copy the contents of referral lab to old_var here, for first time old_ref keeps changing for unique referral */
			strcpy(old_lab_code.arr,ref_lcode.arr);
			old_lab_code.len=strlen(old_lab_code.arr);  
			strcpy(old_tst_code.arr,tst_code.arr);
			old_tst_code.len=strlen(old_tst_code.arr);          
		   }	
	   }
    }
    if (d_first == 0)
    {
	  print_total();
	  lctr=lctr+1;   	
	  check_page_end(4,0);
	  print_grand_total();
    }

    close_dtl();
}

print_total()
{
	char space[4],loc_legend1[9],loc_legend3[5],loc_legend4[5],loc_legend5[5];

    strcpy(loc_legend1,"        ");
    loc_legend1[9]='\0';

	strcpy(loc_legend3,"    ");
    loc_legend3[5]='\0';

	strcpy(loc_legend4,"    ");
    loc_legend4[5]='\0';

	strcpy(loc_legend5,"    ");
    loc_legend5[5]='\0';


	strcpy(space,"   ");
	space[4] = '\0';

	check_page_end(3,0);
	fill_dash(78);	
//	fprintf(fp,"TOTAL%16d %20.2f     %26.2f \n",tot_code,lcy_tot,fcy_tot);		
	fprintf(fp,"%-5.5s%16d %20.2f     %26.2f \n",local_legend[2], tot_code,lcy_tot,fcy_tot);	//added for globalisation	
	fprintf(fp,"\n");
	fill_dash(78);
	tot_code=0;
	lcy_tot = 0.0;
	fcy_tot = 0.0;
	lctr=lctr+3; 	
}   

print_grand_total()
{
	char space[4],loc_legend1[9],loc_legend3[5],loc_legend4[5],loc_legend5[5];

    strcpy(loc_legend1,"        ");
    loc_legend1[9]='\0';

	strcpy(loc_legend3,"    ");
    loc_legend1[5]='\0';

	strcpy(loc_legend4,"    ");
    loc_legend1[5]='\0';

	strcpy(loc_legend5,"    ");
    loc_legend1[5]='\0';


	strcpy(space,"   ");
	space[4] = '\0';

    check_page_end(5,0);
	fill_dash(78);
//	fprintf(fp,"GRAND TOTAL%10d %20.2f     %26.2f \n",grd_tot_code,grd_lcy_tot,grd_fcy_tot);
	fprintf(fp,"%-11.11s%10d %20.2f     %26.2f \n",local_legend[3], grd_tot_code,grd_lcy_tot,grd_fcy_tot);// added for globalisation
	fprintf(fp,"\n");
	fill_dash(78);
}   

end_of_rep()
{
	check_page_end(3,0);
//	fprintf(fp,"\n\n %15s   ***  END OF REPORT ***\n\f"," ");
	fprintf(fp,"\n\n %15s   ***  %s ***\n\f"," ", local_legend[4]);//added for globalisation
	fflush(fp);
}

print_head()
{
	char loc_legend1[10];
	char loc_legend2[5];
	char loc_legend3[5];
	char loc_legend4[6];
	char loc_legend5[9];
	char space[4];
	
	print_page_title();

	if (ref_head)
	   { 
			print_lab();
			ref_head = 0;
	   }

//	strcpy(loc_legend1,"Test Name");
	strcpy(loc_legend1,local_legend[5]); //added for globalisation
	loc_legend1[9] = '\0';

//	strcpy(loc_legend2,"Sent");
	strcpy(loc_legend2,local_legend[6]); //added for globalisation
	loc_legend2[4] = '\0';

//	strcpy(loc_legend3,"Cost");
	strcpy(loc_legend3,local_legend[7]); //added for globalisation
	loc_legend3[4] = '\0';

//	strcpy(loc_legend4,"Total");
	strcpy(loc_legend4,local_legend[2]); //added for globalisation
	loc_legend4[5] = '\0';

//	strcpy(loc_legend5,"FCY");
	strcpy(loc_legend5,local_legend[8]); //added for globalisation
	loc_legend5[8] = '\0';

	strcpy(space,"   ");  
	space[4] = '\0';

	fill_dash(78);
	fprintf(fp,"		           Local \n");
	fprintf(fp,"%24.24s \n", local_legend[9]); // added for globalisation
	fprintf(fp,"%-16s %-9s %-7s  %-8s   %-6s  %-8s    %-18s \n",
			    loc_legend1, loc_legend2, loc_legend3,loc_legend4,
				loc_legend5,loc_legend3, loc_legend4);
					
	fill_dash(78);
	lctr = 8;	
}

print_page_title()
{
	static int first = 1;
    char buf[15];
    int col;
	
    strcpy(rep_title2,"");

    memset(hdr_line1,' ',REP_WIDTH+1);
    memset(hdr_line2,' ',REP_WIDTH+1);
    memset(hdr_line4,' ',REP_WIDTH+1);
	
	hdr_line5[REP_WIDTH] = '\0';
	memset(hdr_line6,' ',REP_WIDTH);
	hdr_line5[REP_WIDTH] = '\0';

    /*
    strncpy(hdr_line1,"MDL : RL",19);
    col = (int)(REP_WIDTH-strlen(comp_name.arr))/2; 
    strncpy(&hdr_line1[22],hosp_name.arr,strlen(hosp_name.arr));
	strncpy(&hdr_line1[58],date.arr,strlen(date.arr));
    col = (REP_WIDTH-strlen(date_time.arr));
    strcpy(&hdr_line1[70],date_time.arr);
    
    strncpy(hdr_line2,"OPR :",20);
    strcpy(&hdr_line2[6],user_id.arr);

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRCOSTR",20);
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3[22],rep_title1,strlen(rep_title1));
    sprintf(buf,"PAGE : %4d",page_no++);
    strcpy(hdr_line3[70],buf);
    
    
    if(d_first)
        fprintf(fp,"%s\n",hdr_line1);
    else
        fprintf(fp,"\f%s\n",hdr_line1);
	*/

	strcpy(buf,"MDL : RL");
	buf[9] = '\0';

//	fprintf(fp,"%-20s %-36s %-10s %-9s\n",buf,hosp_name.arr,date.arr,date_time.arr);
  /* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
		:date1 := to_char(t_date,'DD/MM/YYYY');
	END;
  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET\
_CURRENT_DATE ( :language_id ) ; :date1 := to_char ( t_date , 'DD/MM/YYYY' ) ;\
 END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )285;
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
  sqlstm.sqhstv[1] = (         void  *)&date1;
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



  /* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
		:date1 := to_char(t_date,'HH24:MI:SS');
	END;
  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET\
_CURRENT_DATE ( :language_id ) ; :date1 := to_char ( t_date , 'HH24:MI:SS' ) ;\
 END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )308;
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
  sqlstm.sqhstv[1] = (         void  *)&date1;
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


	fprintf(fp,"%-20s %-36s %-10s %-9s\n",buf,hosp_name.arr,date1.arr,date_time1.arr);
	
	strcpy(buf,"OPR :");
	buf[10] = '\0';

	fprintf(fp,"%-5s %-40s\n",buf,user_id.arr);

	
//    fprintf(fp,"REP : RLRCSREV	  Ref. Out Test Cost Vs. Rev Report - Summary        PAGE : %d\n",page_no++);    
    fprintf(fp,"REP : RLRCSREV	  %-41.41s          %-4.4s : %d\n",local_legend[10], local_legend[11], page_no++);  //added for globalisation  
	lctr += 6; 

    first = 0;
}
 
fill_dash(flg)
{
  int ini_lp1;
  for (ini_lp1=1;ini_lp1<=flg;ini_lp1++)
	fprintf(fp,"%s","-");
	fprintf(fp,"\n");
}

check_page_end(l_lead_lines, l_print_flag)
int l_lead_lines;
int	l_print_flag;
{
	if(l_print_flag==1)
		l_lead_lines=l_lead_lines+10;

	if((lctr+l_lead_lines)> MAX_LINES) 
	{
		fprintf(fp,"\f");
		print_head();
	}	
}

print_spaces(l_length)
double l_length;
{
   int ini_lp2;
	for(ini_lp2=0;ini_lp2<l_length;ini_lp2++)
	{
		fprintf(fp," ");
	}
}

int fetch_dtl()
{
	ref_lcode.arr[0]	= '\0';
	tst_code.arr[0]	    = '\0';

	tst_code.len		= 0;
	ref_lcode.len		= 0;

	cnt_test_code       = 0;

	if (nd_ref_code.arr[0] == '!')	
	   {			
	      /* EXEC SQL FETCH VAL_CUR
                   INTO	:cnt_test_code,
	 					:tst_code,
						:ref_lcode; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 8;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )331;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&cnt_test_code;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&tst_code;
       sqlstm.sqhstl[1] = (unsigned int  )12;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&ref_lcode;
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

 

	     if (NODATAFOUND)
		    return 0;
	   } 
    else
	   {
	      /* EXEC SQL FETCH REF_LAB_VAL_CUR
		           INTO	:cnt_test_code,
				        :tst_code,
				        :ref_lcode; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 8;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )358;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&cnt_test_code;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&tst_code;
       sqlstm.sqhstl[1] = (unsigned int  )12;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&ref_lcode;
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

 

	     if (NODATAFOUND)
			return 0;
		    
        }

		ref_lcode.arr[ref_lcode.len]		= '\0';
		tst_code.arr[tst_code.len]			= '\0';
	    return 1;

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 
 
    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )385;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ERR_MESG,"Oracle error at fetch_dtl() occured...");
    proc_exit();
}

int fetch_ccy_details()
{	
	fcy_code.arr[0]	= '\0';	
	fcy_code.len	= 0;
	
	lcy_rate = 0.0;
	fcy_rate = 0.0;

    
    /* EXEC SQL SELECT NVL(FOREIGN_CURR_CODE,'XXX'), 
			        NVL(LOCAL_CURR_RATE,0.0), 
	  	            NVL(FOREIGN_CURR_RATE,0.0)
               INTO :fcy_code, :lcy_rate, :fcy_rate
               FROM RL_REFERRED_TEST_CODE
              WHERE	TEST_CODE		=  :tst_code 
			    AND REFERRED_LAB_CODE	  =  :ref_lcode
			    AND OPERATING_FACILITY_ID =  :nd_facility; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(FOREIGN_CURR_CODE,'XXX') ,NVL(LOCAL_CURR_RATE,\
0.0) ,NVL(FOREIGN_CURR_RATE,0.0) into :b0,:b1,:b2  from RL_REFERRED_TEST_CODE \
where ((TEST_CODE=:b3 and REFERRED_LAB_CODE=:b4) and OPERATING_FACILITY_ID=:b5\
)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )400;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&fcy_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&lcy_rate;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&fcy_rate;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&tst_code;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&ref_lcode;
    sqlstm.sqhstl[4] = (unsigned int  )6;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility;
    sqlstm.sqhstl[5] = (unsigned int  )5;
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



     if (OERROR) 
  	  {
	 	 sprintf(string_var,"For %s %s Fetch_Ccy_Details() Returned -> %s\n", ref_lcode.arr,tst_code.arr, sqlca.sqlerrm.sqlerrmc);
		 disp_message(ERR_MESG, string_var);
		 return 0;
	  }
	 /*
     if ((lcy_rate == 0)||(fcy_rate == 0))
	 {
		sprintf(string_var,"For %s %s Fetch_Ccy_Details() Returned -> zero \n", ref_lcode.arr,tst_code.arr);
		disp_message(ERR_MESG, string_var);
		return 0;
	 }
	 */
    fcy_code.arr[fcy_code.len]           = '\0';
    return 1;
}

close_dtl() 
{	
    if (strcmp(nd_ref_code.arr,"!") == 0)	
	 {
		/* EXEC SQL CLOSE VAL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )439;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   
		 if (OERROR)
			{	
		  	   disp_message(ERR_MESG,"Close failed on cursor VAL_CUR");
			   return 0;			   				
		    }
	 }
	else
	 {
		/* EXEC SQL CLOSE REF_LAB_VAL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )454;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
   
		if (OERROR)
			{	
		  	   disp_message(ERR_MESG,"Close failed on cursor REF_LAB_VAL_CUR");
			   return 0;
		    }
	 }
	 return 1;
}


unsigned int fetch_lab_desc()
{
    lab_name.arr[0]	= '\0';	
    lab_name.len	= 0;
      		
   /* EXEC SQL SELECT SHORT_DESC
              INTO :lab_name
              FROM RL_REFERRED_LAB_CODE_lang_vw
             WHERE REFERRED_LAB_CODE = :ref_lcode
			 and language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from RL_REFERRED_LAB_CODE_lang\
_vw where (REFERRED_LAB_CODE=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )469;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&lab_name;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ref_lcode;
   sqlstm.sqhstl[1] = (unsigned int  )6;
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

 

    if (OERROR) 
	{
	    sprintf(string_var,"For %s Fetch_Lab_Desc() Returned -> %s\n", ref_lcode.arr, sqlca.sqlerrm.sqlerrmc);
	    disp_message(ERR_MESG, string_var);			      
	    return 0;
	}
	lab_name.arr[lab_name.len]  = '\0';

	return 1;
}

int fetch_test_desc()
{
    test_name.arr[0]	= '\0';	
    test_name.len		= 0;
	
   /* EXEC SQL SELECT SHORT_DESC
               INTO :test_name
               FROM RL_TEST_CODE_lang_vw
              WHERE TEST_CODE = :tst_code
			  and language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from RL_TEST_CODE_lang_vw wher\
e (TEST_CODE=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )496;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&test_name;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&tst_code;
   sqlstm.sqhstl[1] = (unsigned int  )12;
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

 

    if (OERROR) 
	{
	      sprintf(string_var,"For %s Fetch_Test_Desc() Returned -> %s\n", tst_code.arr, sqlca.sqlerrm.sqlerrmc);
	      disp_message(ERR_MESG, string_var);		      
	      return 0;
	}

	test_name.arr[test_name.len]           = '\0';
	return 1;
}


print_lab()
{
//	fprintf(fp,"Referral Lab Name : %s",lab_name.arr);		
	fprintf(fp,"%-17.17s : %s",local_legend[12], lab_name.arr); //added for globalisation		
	fprintf(fp,"\n                     \n");
	lctr += 2;
}

gen_file_name()
{
     char	file_var[200];

     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;

	 strcpy(nd_file_name.arr,WORKING_DIR);

	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 
    if ((fp = fopen(nd_file_name.arr,"w")) == NULL) 
     {     
	   sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var);
       proc_exit();
     }
	 
}
/*************************** added for globalisation*************************************/

get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND ('DF',:language_id,'RLRCOSTR.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( 'DF' , :lan\
guage_id , 'RLRCOSTR.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )523;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRCOSTR.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRCOSTR.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )542;
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


/*************************** added for globalisation*************************************/
