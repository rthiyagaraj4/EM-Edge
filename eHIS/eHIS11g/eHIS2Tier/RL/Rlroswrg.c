
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/Rlroswrg.pc"
};


static unsigned int sqlctx = 1288616467;


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
            void  *sqhstv[7];
   unsigned int   sqhstl[7];
            int   sqhsts[7];
            void  *sqindv[7];
            int   sqinds[7];
   unsigned int   sqharm[7];
   unsigned int   *sqharc[7];
   unsigned short  sqadto[7];
   unsigned short  sqtdso[7];
} sqlstm = {12,7};

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

 static const char *sq0009 = 
"select TEST_CODE ,DECODE(CANCELLED_YN,'Y','C',NVL(RESULT_STATUS,'O')) ,NVL(g\
roup_test_yn,'N')  from RL_REQUEST_DETAIL where ((SPECIMEN_NO=:b0 and OPERATIN\
G_FACILITY_ID=:b1) and ((:b2='O' and NVL(RESULT_STATUS,'O') in ('O','H','A')) \
or (:b2='A' and NVL(RESULT_STATUS,'O')=NVL(RESULT_STATUS,'O'))))           ";

 static const char *sq0025 = 
"select test_code  from RL_GROUP_TEST_DETAIL where group_test_code=:b0       \
    ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,156,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,68,0,4,207,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
59,0,0,3,0,0,29,264,0,0,0,0,0,1,0,
74,0,0,4,0,0,32,274,0,0,0,0,0,1,0,
89,0,0,5,120,0,6,283,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
112,0,0,6,136,0,6,299,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
135,0,0,7,158,0,4,327,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
170,0,0,8,0,0,32,351,0,0,0,0,0,1,0,
185,0,0,10,0,0,32,391,0,0,0,0,0,1,0,
200,0,0,11,55,0,4,406,0,0,1,0,0,1,0,2,3,0,0,
219,0,0,12,0,0,17,651,0,0,1,1,0,1,0,1,97,0,0,
238,0,0,12,0,0,45,658,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
281,0,0,12,0,0,45,671,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
320,0,0,13,0,0,32,687,0,0,0,0,0,1,0,
335,0,0,14,203,0,4,698,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
378,0,0,15,0,0,32,723,0,0,0,0,0,1,0,
393,0,0,9,0,0,13,806,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
420,0,0,16,0,0,32,830,0,0,0,0,0,1,0,
435,0,0,12,0,0,13,841,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
458,0,0,17,0,0,32,866,0,0,0,0,0,1,0,
473,0,0,9,307,0,9,903,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
504,0,0,18,0,0,32,1120,0,0,0,0,0,1,0,
519,0,0,19,146,0,4,1129,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
546,0,0,20,0,0,32,1145,0,0,0,0,0,1,0,
561,0,0,21,0,0,32,1171,0,0,0,0,0,1,0,
576,0,0,22,100,0,6,1255,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
599,0,0,23,143,0,4,1392,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
630,0,0,24,143,0,4,1412,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
661,0,0,25,80,0,9,1437,0,0,1,1,0,1,0,1,9,0,0,
680,0,0,25,0,0,13,1467,0,0,1,0,0,1,0,2,9,0,0,
699,0,0,26,0,0,32,1486,0,0,0,0,0,1,0,
714,0,0,25,0,0,15,1493,0,0,0,0,0,1,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: rlroswrg.pc
   Author : S.Sheelvant 
   Date Created  : 22/02/1997
   Last Modified : 19/09/2000
   
   Modified      : HAMEED
   Reason        : eHIS Upgradation
*  Ver 1.10.01
   
*  Purpose : To generate a report for Outstanding Work.

*  Input Parameters : 
                      Command line inputs
		              1. Usr_id/Password
                      2. Session id
		              3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4. Preferred range of Specimen Numbers. 
  
*  Table Accessed : RL_REQUEST_HEADER,RL_REQUEST_DETAIL,
  		        MP_PATIENT_MAST, RL_PATIENT_MAST

*  Output File : rlroswrg_NUMBER.lis
 ****************************************************************************/  

#include <stdio.h>
#include <string.h>
#include <math.h>
#include "gl.h"
#define MAX_LINES 41
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ONLINE_PRINTING 1
#define ESC 0x1B
#define REP_WIDTH 132

/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR     nd_operating_facility_id [3],
	            uid_pwd		            [91],
                nd_file_name            [151],
                nd_user	                [31],
                nd_file_no              [15],
                nd_printer_name         [16],
				nd_assign_to			[31],


            /o Variables to recieve data from specimen register cursoro/ 
	            d_specimen_no           [21],
                d_spec_regd_date        [17],
		        d_test_code             [11],
                d_result_status         [2],
		        d_patient_id            [31],
                d_patient_name          [240],
		        d_episode_type          [2],
		        d_request_comment_desc1 [41],
		        d_request_comment_desc2 [41],
		        d_request_comment_desc3 [41],

                /o input parameters to main() o/
                nd_session_id      	    [16],
		        nd_pgm_date	   	        [20],
		        nd_dept                 [2],
 		        nd_fr_specimen_no       [40],//babu chaned 21 to 40 for testing 
 		        nd_to_specimen_no       [40],
		        nd_test_code            [11],
		        nd_start_date           [11],
		        nd_end_date			    [11],
		        nd_comm_code            [50],
		        nd_workgroup_code       [4],
		        nd_sp_prfx			[3],
		        nd_grp_test_yn	      [2],
		nd_referred_lab		[5],

		/o for header routine o/
	    //d_acc_entity_name      [41],
		d_acc_entity_name        [300],
		d_user                   [31],
		d_sysdate                [17],
		d_sysdate1                [17],
		l_translated_value		 [100],
		language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[31]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_printer_name;

struct { unsigned short len; unsigned char arr[31]; } nd_assign_to;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[17]; } d_spec_regd_date;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_result_status;

struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[41]; } d_request_comment_desc1;

struct { unsigned short len; unsigned char arr[41]; } d_request_comment_desc2;

struct { unsigned short len; unsigned char arr[41]; } d_request_comment_desc3;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[2]; } nd_dept;

struct { unsigned short len; unsigned char arr[40]; } nd_fr_specimen_no;

struct { unsigned short len; unsigned char arr[40]; } nd_to_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code;

struct { unsigned short len; unsigned char arr[11]; } nd_start_date;

struct { unsigned short len; unsigned char arr[11]; } nd_end_date;

struct { unsigned short len; unsigned char arr[50]; } nd_comm_code;

struct { unsigned short len; unsigned char arr[4]; } nd_workgroup_code;

struct { unsigned short len; unsigned char arr[3]; } nd_sp_prfx;

struct { unsigned short len; unsigned char arr[2]; } nd_grp_test_yn;

struct { unsigned short len; unsigned char arr[5]; } nd_referred_lab;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;



/****** ADDED FOR GTT SPECIMENS ******/
	/* VARCHAR	id_test_code		[11],
			d_group_test_yn     [2]; */ 
struct { unsigned short len; unsigned char arr[11]; } id_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_group_test_yn;
	

char includ;
char sql_stmt[5000];
char sql_stmt1[5000];
char sql_stmt2[5000] ;

int l_count = 0;
int l_specimen_length = 0;
int l_cnt = 0;
/**********ADDDED FOR CONVERSION***************/
int i;
char local_legend[100][100];
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char rep_title1[60] ;
char rep_title2[30];
int  rec_len;

/********END*********************************/

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




#include <winproc.h>

int   line_no=0, page_no=0;
int   first_page_flag=1;
int   l_length = 0;

int   i;

long  nd_totl_specimens      = 0;
long  nd_totl_specs          = 0;
long  nd_totl_blocks         = 0;
long  nd_totl_slides         = 0;
/* summary fields for calculating No. of records */ 

void print_page_header();
void print_col_heading();
FILE *f1;
char string_var[100] ;

char d_stat = 'N';

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
  	dclr_request_header(),
	dclr_request_detail(),
  	do_report();

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
   if (sqlca.sqlcode < 0) goto err_exit;
}

  
    
   set_meduser_role();
   strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	get_legend_value(24);
	

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 
   
   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 
   
   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

   strcpy(nd_dept.arr, argv[5]);
   nd_dept.len = strlen(nd_dept.arr); 

/***
   EXEC SQL WHENEVER SQLERROR GOTO err_exit;
   EXEC SQL SELECT SPECIMEN_PREFIX INTO :nd_sp_prfx
	          FROM RL_SECTION_CODE
             WHERE SECTION_CODE = :nd_dept;
   nd_sp_prfx.arr[nd_sp_prfx.len] = '\0';
***/
   
   strcpy(nd_fr_specimen_no.arr, argv[6]);
   nd_fr_specimen_no.len = strlen(nd_fr_specimen_no.arr); 
   if(strcmp(nd_fr_specimen_no.arr,"NULL")==0)
   {   nd_fr_specimen_no.arr[0] = '\0';
       nd_fr_specimen_no.len = 0;
   }
   
   strcpy(nd_to_specimen_no.arr, argv[7]);
   nd_to_specimen_no.len = strlen(nd_to_specimen_no.arr); 
   if(strcmp(nd_to_specimen_no.arr,"NULL")==0)
   {   nd_to_specimen_no.arr[0] = '\0';
       nd_to_specimen_no.len = 0;
   }
   
   strcpy(nd_test_code.arr, argv[8]);
   nd_test_code.len = strlen(nd_test_code.arr); 
   if(strcmp(nd_test_code.arr,"NULL")==0)
   {   nd_test_code.arr[0] = '\0';
       nd_test_code.len = 0;
   }
   if(strlen(nd_test_code.arr))
   {
      /* EXEC SQL SELECT GROUP_TEST_YN INTO :nd_grp_test_yn 
	             FROM RL_TEST_CODE
		        WHERE TEST_CODE = :nd_test_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 4;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select GROUP_TEST_YN into :b0  from RL_TEST_CODE where \
TEST_CODE=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )36;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_grp_test_yn;
      sqlstm.sqhstl[0] = (unsigned int  )4;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_test_code;
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
      if (sqlca.sqlcode < 0) goto err_exit;
}


/** Commented on 18/08/2004 since test is unique across the section
				  AND SECTION_CODE = :nd_dept;
**/
      nd_grp_test_yn.arr[nd_grp_test_yn.len] = '\0';
   }
   strcpy(nd_start_date.arr, argv[9]);
   nd_start_date.len = strlen(nd_start_date.arr); 
   if(strcmp(nd_start_date.arr,"NULL")==0)
   {   nd_start_date.arr[0] = '\0';
       nd_start_date.len = 0;
   }

   strcpy(nd_comm_code.arr, argv[10]);
   nd_comm_code.len = strlen(nd_comm_code.arr); 
   if(strcmp(nd_comm_code.arr,"NULL")==0)
   {  nd_comm_code.arr[0] = '\0';
      nd_comm_code.len = 0; 
   }

   strcpy(nd_workgroup_code.arr, argv[11]);
   nd_workgroup_code.len = strlen(nd_workgroup_code.arr); 
   if(strcmp(nd_workgroup_code.arr,"NULL")==0)
   {  nd_workgroup_code.arr[0] = '\0';
      nd_workgroup_code.len = 0; 
   }
   
   /* include all or outstanding tests in report */
   includ = argv[12][0];

   strcpy(nd_referred_lab.arr, argv[13]);
   nd_referred_lab.len = strlen(nd_referred_lab.arr);

   strcpy(nd_assign_to.arr, argv[14]);
   nd_assign_to.len = strlen(nd_assign_to.arr); 

   strcpy(nd_end_date.arr, argv[15]);
   nd_end_date.len = strlen(nd_end_date.arr); 
   


   gen_file_name();

   //increment_file_no(); 
  
   get_header_dtls();
   
   dclr_request_header();

   dclr_request_detail();

   do_report();


   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )59;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
}



   fprintf(f1,"%c&|3O",ESC);

   fclose(f1);
   //h print_job();
   return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )74;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}   

/************get_legend_value*******************/
get_legend_value(int cou)
 {
    
	/* EXEC SQL EXECUTE
	BEGIN
	 
	 SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLROSWRG.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLROSWRG.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )89;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLROSWRG.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LROSWRG.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )112;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
/************END*************/




/* get the header details */

void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT ACC_ENTITY_NAME, /o description of the institution o/
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	    INTO :d_acc_entity_name,
		   :d_user,
		   :d_sysdate
            FROM SY_ACC_ENTITY_LANG_VW
            WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b\
3 and LANGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )135;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
  d_user.arr[d_user.len]                       = '\0';
  d_sysdate.arr[d_sysdate.len]                 = '\0';

  #ifdef DEBUG
   printf("d_acc_entity_name = %s\n", d_acc_entity_name.arr);
   printf("d_user = %s\n", d_user.arr);
   printf("d_sysdate = %s\n", d_sysdate.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )170;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}
/*--------------------------------- REQUEST DETAIL CURSOR -------------------*/
void dclr_request_detail()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


/*-------------- the following to be commented to get cancelled tests in report ---*/
/*
  EXEC SQL DECLARE REQUEST_DETAIL CURSOR FOR
     SELECT TEST_CODE,NVL(RESULT_STATUS,'O'), NVL(group_test_yn, 'N')
     FROM   RL_REQUEST_DETAIL
     WHERE  SPECIMEN_NO = :d_specimen_no  
     AND    ((:includ = 'O' AND NVL(RESULT_STATUS,'O') IN ('O','H','A')) OR
	     (:includ = 'A' AND NVL(RESULT_STATUS,'O') 
					= NVL(RESULT_STATUS,'O')))
	 AND NVL(cancelled_yn, 'N') <> 'Y'; */

/* -------------------the following to be uncommented to get cancelled test in report */

  /* EXEC SQL DECLARE REQUEST_DETAIL CURSOR FOR
     SELECT TEST_CODE,DECODE(CANCELLED_YN,'Y','C',NVL(RESULT_STATUS,'O')), NVL(group_test_yn, 'N')
     FROM   RL_REQUEST_DETAIL
     WHERE  SPECIMEN_NO = :d_specimen_no  
     AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND    ((:includ = 'O' AND NVL(RESULT_STATUS,'O') IN ('O','H','A')) OR
	     (:includ = 'A' AND NVL(RESULT_STATUS,'O') 
					= NVL(RESULT_STATUS,'O'))); */ 


/* ---------------------------------------------- */

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  #ifdef DEBUG
    printf("leaving dclr_request_detail()\n");
  #endif
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )185;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_request_detail() occured....\n");
   proc_exit();
}
/*------------------------------------REQUEST_HEADER CURSOR------------------*/ 
void dclr_request_header()
{

  if(nd_workgroup_code.len == 0)
  {
     if(nd_test_code.len == 0)
		nd_grp_test_yn.arr[0] == 'Y';
  }


  /* EXEC SQL SELECT NVL(specimen_length, 15)
	     INTO :l_specimen_length
	     FROM RL_PARAM; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(specimen_length,15) into :b0  from RL_PARAM ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )200;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_specimen_length;
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



  
  l_length = l_specimen_length -  strlen(nd_sp_prfx.arr);

  if(strlen(nd_fr_specimen_no.arr) == 0)
  {
      //strcpy(nd_fr_specimen_no.arr,nd_sp_prfx.arr);
	  
	  strcpy(nd_fr_specimen_no.arr,"00");

	for (i=1; i<= l_length; i++)
	{
  	   strcat(nd_fr_specimen_no.arr,"0");
	}

      nd_fr_specimen_no.len = strlen(nd_fr_specimen_no.arr);
  }

  if(strlen(nd_to_specimen_no.arr) == 0)
  {
     //strcpy(nd_to_specimen_no.arr,nd_sp_prfx.arr);

	 strcpy(nd_to_specimen_no.arr,"99");
	
	for (i=1; i<= l_length; i++)
	{
  	   strcat(nd_to_specimen_no.arr,"9");
	}
      nd_to_specimen_no.len = strlen(nd_to_specimen_no.arr);

  }
  
  if(strlen(nd_start_date.arr) == 0)
  {
  	 strcpy(nd_start_date.arr,"01/01/1900");
	 nd_start_date.len = strlen(nd_start_date.arr);
  
  }

  if(strlen(nd_comm_code.arr) == 0)
  {
  	 strcpy(nd_comm_code.arr,"NULL");
	 nd_comm_code.len = strlen(nd_comm_code.arr);
  }

  if(strlen(nd_referred_lab.arr) == 0)
  {
  	 strcpy(nd_referred_lab.arr,"NULL");
	 nd_referred_lab.len = strlen(nd_referred_lab.arr);
  }  

  
  strcpy(sql_stmt,
    "SELECT RL_OUTSTANDING_WORK.SPECIMEN_NO, \
            TO_CHAR(RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') \
       FROM RL_OUTSTANDING_WORK \
      WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
	  AND RL_OUTSTANDING_WORK.SPECIMEN_NO \
                       BETWEEN TO_NUMBER(:nd_fr_specimen_no) \
                           AND TO_NUMBER(:nd_to_specimen_no) \
	    AND RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME >= \
              TO_DATE(:nd_start_date,'DD/MM/YYYY') ");

  strcat(sql_stmt, " AND (RL_OUTSTANDING_WORK.SPECIMEN_NO) IN ");

  strcat(sql_stmt, "( SELECT RQH.SPECIMEN_NO FROM RL_REQUEST_HEADER RQH \
	                  WHERE RQH.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
				      AND RQH.SECTION_CODE = '");
   
  strcat(sql_stmt, nd_dept.arr);
  strcat(sql_stmt, "')");

  
  if (strcmp(nd_end_date.arr, "NULL") != 0)
  {
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME < \
			  TO_DATE(:nd_end_date, 'DD/MM/YYYY') + 1 ");
  }
  	     
		 if(strcmp(nd_assign_to.arr,"NULL") != 0)    
 	    strcat(sql_stmt,
		" AND RL_OUTSTANDING_WORK.ASSIGN_TO = NVL(:nd_assign_to, RL_OUTSTANDING_WORK.ASSIGN_TO) ");

  if(strcmp(nd_comm_code.arr,"NULL") != 0) 
     strcat(sql_stmt," AND NVL(RL_OUTSTANDING_WORK.REQUEST_COMMENT_CODE1,'NULL') = :nd_comm_code ");
  else
     strcat(sql_stmt,
	   " AND :nd_comm_code = :nd_comm_code ");     

if (strlen(nd_workgroup_code.arr) || strlen(nd_test_code.arr)
		|| strcmp(nd_referred_lab.arr,"NULL") != 0) 
{
  
   strcat(sql_stmt,
      " AND (RL_OUTSTANDING_WORK.SPECIMEN_NO) IN ");

  if(nd_workgroup_code.len == 0)
  {
     if(nd_test_code.len)
	 {
	    if(nd_grp_test_yn.arr[0] == 'Y')
		{
           strcat(sql_stmt,
           "( SELECT A.SPECIMEN_NO \
                FROM RL_REQUEST_DETAIL A \
               WHERE A.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
				 AND OPERATING_FACILITY_ID = '");
				 strcat(sql_stmt, nd_operating_facility_id.arr);
				 strcat(sql_stmt, "'");
				 strcat(sql_stmt, " AND A.TEST_CODE = '");
	       strcat(sql_stmt,nd_test_code.arr);
	       strcat(sql_stmt,"' ");
	       strcat(sql_stmt,
	       " AND NVL(A.RESULT_STATUS,'O') IN ('O','A','H') ");

		   if (strcmp(nd_referred_lab.arr, "NULL") != 0)
		   {
			  strcat(sql_stmt, " and a.referred_lab_code = '");
			  strcat(sql_stmt,nd_referred_lab.arr);
			  strcat(sql_stmt,"' ");
		   }

		   strcat(sql_stmt, " )");

		}
		else
		{
		   if (strcmp(nd_referred_lab.arr, "NULL") == 0)
		   {
              strcat(sql_stmt,
                  "( SELECT A.SPECIMEN_NO \
                    FROM RL_TEST_RESULT A \
                    WHERE A.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
				 AND OPERATING_FACILITY_ID = '");
				 strcat(sql_stmt, nd_operating_facility_id.arr);
				 strcat(sql_stmt, "'");
				 strcat(sql_stmt, " AND A.TEST_CODE = '");
	         strcat(sql_stmt,nd_test_code.arr);
	         strcat(sql_stmt,"' ");
	         strcat(sql_stmt,
	              " AND NVL(A.STATUS,'O') IN ('O','A','H') \
		          )");
		  }
		  else
		  {
              strcat(sql_stmt,
                  "( SELECT A.SPECIMEN_NO \
                    FROM RL_TEST_RESULT A \
                    WHERE A.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
				 AND OPERATING_FACILITY_ID = '");
				 strcat(sql_stmt, nd_operating_facility_id.arr);
				 strcat(sql_stmt, "'");
				 strcat(sql_stmt, " AND A.TEST_CODE = '");
	         strcat(sql_stmt,nd_test_code.arr);
	         strcat(sql_stmt,"' ");
	         strcat(sql_stmt,
	              " AND NVL(A.STATUS,'O') IN ('O','A','H') \
				    AND (A.SPECIMEN_NO, A.GROUP_TEST_CODE) IN \
		                 ( select z.specimen_no, z.test_code \
						 from rl_request_detail z \
						 where z.specimen_no = rl_outstanding_work.specimen_no \
				 AND OPERATING_FACILITY_ID = '");
				 strcat(sql_stmt, nd_operating_facility_id.arr);
				 strcat(sql_stmt, "'");
				 strcat(sql_stmt, " AND Z.TEST_CODE = '");
			 strcat(sql_stmt, nd_test_code.arr);
			 strcat(sql_stmt,", ");
			 strcat(sql_stmt," and z.referred_lab_code = '");
			 strcat(sql_stmt,nd_referred_lab.arr);
			 strcat(sql_stmt,"' ");
		     strcat(sql_stmt," )");

		  }

		}
	 }
	 else
	 {
	     strcat(sql_stmt, " ( select a.specimen_no from rl_request_detail a \
               where a.specimen_no = rl_outstanding_work.specimen_no \
				 AND OPERATING_FACILITY_ID = '");
				 strcat(sql_stmt, nd_operating_facility_id.arr);
				 strcat(sql_stmt, "'");
			   strcat(sql_stmt, " and nvl(a.result_status,'O') in ('O','A','H') ");

		if (strcmp(nd_referred_lab.arr, "NULL") != 0)
		{
			strcat(sql_stmt, " and a.referred_lab_code = '") ;
			strcat(sql_stmt,nd_referred_lab.arr);
			strcat(sql_stmt,"' ");
		}

	  strcat(sql_stmt," )");
	               
	 }
	 
  }
  else
  {
     strcat(sql_stmt,
     "( SELECT A.SPECIMEN_NO \
          FROM RL_TEST_RESULT A \
         WHERE A.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
				 AND OPERATING_FACILITY_ID = '");
				 strcat(sql_stmt, nd_operating_facility_id.arr);
				 strcat(sql_stmt, "'");
		   strcat(sql_stmt, " AND A.TEST_CODE IN ( \
		                         SELECT B.TEST_CODE \
								   FROM RL_OUTST_WORK_GROUP_DTL B \
								  WHERE B.OPERATING_FACILITY_ID = '");
							 strcat(sql_stmt, nd_operating_facility_id.arr);
							 strcat(sql_stmt, "'");
							 strcat(sql_stmt, " AND B.OUTST_WORK_GROUP_CODE = '");
	 strcat(sql_stmt,nd_workgroup_code.arr);
	 strcat(sql_stmt,"') ");
	 strcat(sql_stmt, " AND NVL(A.STATUS,'O') IN ('O','A','H') ");

  	  if (strcmp(nd_referred_lab.arr, "NULL") != 0)
	  {
	  	  strcat(sql_stmt, " and (a.specimen_no, a.group_test_code) in \
                        ( select z.specimen_no, z.test_code \
						 from rl_request_detail z \
						 where z.specimen_no = rl_outstanding_work.specimen_no \
							 AND z.OPERATING_FACILITY_ID = '");
						 strcat(sql_stmt, nd_operating_facility_id.arr);
							strcat(sql_stmt, "'");
			strcat(sql_stmt, "  and z.referred_lab_code = '") ;
			strcat(sql_stmt,nd_referred_lab.arr);
			strcat(sql_stmt,"' ");
		}

	  strcat(sql_stmt," )");  
  }    


}


strcat(sql_stmt," ORDER BY RL_OUTSTANDING_WORK.SPECIMEN_NO");
 
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    
  /* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )219;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)sql_stmt;
  sqlstm.sqhstl[0] = (unsigned int  )5000;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  /* EXEC SQL DECLARE REQUEST_HEADER CURSOR FOR S; */ 

  
  if (strcmp(nd_end_date.arr, "NULL") != 0)
  {
		
		/* EXEC SQL OPEN REQUEST_HEADER USING
		:nd_operating_facility_id,
 		:nd_fr_specimen_no ,
 		:nd_to_specimen_no ,
		:nd_start_date     ,
		:nd_start_date     ,
		:nd_assign_to	   ,
		:nd_comm_code      ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )238;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_fr_specimen_no;
  sqlstm.sqhstl[1] = (unsigned int  )42;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_specimen_no;
  sqlstm.sqhstl[2] = (unsigned int  )42;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_start_date;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_start_date;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_assign_to;
  sqlstm.sqhstl[5] = (unsigned int  )33;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_comm_code;
  sqlstm.sqhstl[6] = (unsigned int  )52;
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
		
		
		/* EXEC SQL OPEN REQUEST_HEADER USING
		:nd_operating_facility_id,
 		:nd_fr_specimen_no ,
 		:nd_to_specimen_no ,
		:nd_start_date     ,
		:nd_assign_to	   ,
		:nd_comm_code      ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )281;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_fr_specimen_no;
  sqlstm.sqhstl[1] = (unsigned int  )42;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_specimen_no;
  sqlstm.sqhstl[2] = (unsigned int  )42;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_start_date;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_assign_to;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_comm_code;
  sqlstm.sqhstl[5] = (unsigned int  )52;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  }
  
  
  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   
   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )320;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   
   disp_message(ORA_MESG,"Oracle error at dclr_request_header() occured....\n");
   proc_exit();
}


void get_request_header()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT request_comment_desc1, request_comment_desc2,
				  request_comment_desc3, episode_type, patient_id
			 INTO :d_request_comment_desc1, :d_request_comment_desc2,
				  :d_request_comment_desc3, :d_episode_type, :d_patient_id
			 FROM RL_REQUEST_HEADER
			WHERE specimen_no = :d_specimen_no
			AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select request_comment_desc1 ,request_comment_desc2 ,reques\
t_comment_desc3 ,episode_type ,patient_id into :b0,:b1,:b2,:b3,:b4  from RL_RE\
QUEST_HEADER where (specimen_no=:b5 and OPERATING_FACILITY_ID=:b6)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )335;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_request_comment_desc1;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_request_comment_desc2;
  sqlstm.sqhstl[1] = (unsigned int  )43;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_request_comment_desc3;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )5;
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


            
  d_patient_id.arr[d_patient_id.len]='\0';
  d_episode_type.arr[d_episode_type.len]='\0';
  d_request_comment_desc1.arr[d_request_comment_desc1.len] = '\0';
  d_request_comment_desc2.arr[d_request_comment_desc2.len] = '\0';
  d_request_comment_desc3.arr[d_request_comment_desc3.len] = '\0';


 return;

  #ifdef DEBUG
      printf("d_patient_id = %s\n",d_patient_id.arr);
	  printf("d_episode_type = %s\n",d_episode_type.arr);
      fflush(stdout);
  #endif

  err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )378;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_request_header() occured....\n");
   proc_exit();
}
   
/* prints the master-detail record until the cursor is empty */
void do_report()
{
  void print_rep_header();
  void prepare_new_page();
  void print_detl_rec();
  void end_report();
  int fetch_request_header();
  int fetch_group_curs();
  int still_rec_left;


  first_page_flag = 1;
  print_rep_header();  /* once for the report */
  first_page_flag = 0;
  
  page_no += 1; /* icrement by 1 as it is moving to second page */

  line_no = 0;

/*  line_no = 11;   */

  print_page_header();
  print_col_heading();
  
/*  line_no +=4;  */   /*incr. by 4 as col. headings occupy 4 lines */ 

  /* read the first cursor record */
  
  still_rec_left = fetch_request_header();

  while(still_rec_left)
  {

       if(line_no >= MAX_LINES)
       {
          prepare_new_page();
          print_detl_rec();
       }
       else 
          print_detl_rec();

       still_rec_left = fetch_request_header();

  }

  #ifdef DEBUG
      printf("entered do_report outside while()\n");
      fflush(stdout);
  #endif
  end_report();
}

/* prepares for the new page */
void prepare_new_page()
{
   #if DEBUG
     printf("entered prepare_new_page\n");
     fflush(stdout);
   #endif

   page_no += 1; /* incr. by 1 to move to subsequent pages */
   fprintf(f1,"\f");
   line_no = 0;
   print_page_header();
   print_col_heading(); 

/*   line_no = 11;*/

}
/*---------------------------------------------------------------------------*/
/*  Fetching rows from REQUEST_DETAIL for the REQUEST_HEADER read */
int fetch_request_detail()
{
   d_group_test_yn.arr[0]	= '\0';
   d_group_test_yn.len		= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH REQUEST_DETAIL INTO
		 :d_test_code,
		 :d_result_status,
		 :d_group_test_yn; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )393;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_result_status;
  sqlstm.sqhstl[1] = (unsigned int  )4;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_group_test_yn;
  sqlstm.sqhstl[2] = (unsigned int  )4;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_test_code.arr[d_test_code.len]='\0';
  d_result_status.arr[d_result_status.len]='\0';
  d_group_test_yn.arr[d_group_test_yn.len]	= '\0';


#ifdef DEBUG
 printf("d_test_code= %s\n",d_test_code.arr);
 printf("d_result_status = %s\n",d_result_status.arr);
#endif
return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )420;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_detail() occured....\n");
   proc_exit();
}
/*---------------------------------------------------------------------------*/
/* fetches the next record from REQUEST_HEADER CURSOR */
/* returns 0 if the end of cursor is reached else returns 1. */
int fetch_request_header()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH REQUEST_HEADER INTO
                :d_specimen_no,
		:d_spec_regd_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )435;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_spec_regd_date;
  sqlstm.sqhstl[1] = (unsigned int  )19;
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


		
   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_specimen_no.arr[d_specimen_no.len]      = '\0';
  d_spec_regd_date.arr[d_spec_regd_date.len]    = '\0';
  

#ifdef DEBUG
 printf("d_specimen_no = %s\n",d_specimen_no.arr);
 printf("d_spec_regd_date = %s\n",d_spec_regd_date.arr);
  
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )458;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_header() occured....\n");
   proc_exit();
}
/*---------------------------------------------------------------------------*/
/* print the finishing line of the report */
void end_report()
{
  fprintf(f1,"\n\n\n");
  fprintf(f1,"\n");
  fprintf(f1,"                                                   ");
  fprintf(f1,"** %s **",local_legend[2]);
  fprintf(f1,"\f");
}

/*---------------------------------------------------------------------------*/
/* to print the detailed record */
void print_detl_rec()
{   
    int  get_in_patient_dtl(); 
    void get_referral_patient_dtl();
	void get_request_header();

    int i= 0,j =0, cnt = 35, cnt1 = 0 ;
	char flag[1] ;

	/************* FINE TUNING QUERY CHANGED ON 09/08/1999 ********************/
	get_request_header();

    if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0 ||
		strcmp(d_episode_type.arr,"H")==0)
          i = get_in_patient_dtl();
    else
	    if(strcmp(d_episode_type.arr,"R")==0)
            get_referral_patient_dtl();

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL OPEN REQUEST_DETAIL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )473;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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
    sqlstm.sqhstv[2] = (         void  *)&includ;
    sqlstm.sqhstl[2] = (unsigned int  )1;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&includ;
    sqlstm.sqhstl[3] = (unsigned int  )1;
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

 
    fprintf(f1,"\n%-16.16s%-18s",d_specimen_no.arr,d_spec_regd_date.arr);
	line_no += 1 ;

    strcpy(flag,"F") ;

    while(fetch_request_detail())
    {

		check_gtt_specimen_test();

		if (d_stat == 'Y')
		{
			if ((d_result_status.arr[0]	== 'R') || 
				(d_result_status.arr[0]	== 'P'))
			{
				strcpy(d_result_status.arr, "I");
				d_result_status.len = strlen(d_result_status.arr);
			}
		}
	   
        if(cnt >= 69)
	    {

	      cnt1 += 1 ;

		  if (cnt1 == 1 )
		  {
//		     fprintf(f1,"%-*s",(6-j)*8,"");	


			fprintf(f1,"%-*s",(80-cnt),"");

	         fprintf(f1,"%-15.15s %-30.30s\n",d_patient_id.arr,d_patient_name.arr);		  
			 line_no += 1 ;
			 cnt = 35 ;
			 fprintf(f1,"%-34.34s"," ");      
		  }
		  else
		  {

			if(cnt1 == 2)
			{

				if (strlen(d_request_comment_desc1.arr) != 0)
                {
				    fprintf(f1,"%-*s",(6-j)*8,"");
                    fprintf(f1,"                    ");
                    fprintf(f1,"%-40s\n",d_request_comment_desc1.arr);
					line_no += 1 ;
					cnt = 35 ;
					fprintf(f1,"%-34.34s"," ");      
                }

				else
				{

				   if (strlen(d_request_comment_desc2.arr) != 0)
                   {
	
                     fprintf(f1,"%-*s",(6-j)*8,"");
                     fprintf(f1,"                    ");
                     fprintf(f1,"%-40s\n",d_request_comment_desc2.arr);
					 line_no += 1 ;
					 cnt = 35 ;
					 strcpy(flag,"T") ;
					 fprintf(f1,"%-34.34s"," ");      
                   }
				   else
				   {
				     if( cnt >= 129)
			         {
			            fprintf(f1,"\n");
                        cnt = 35 ;
				        line_no += 1 ;
						fprintf(f1,"%-34.34s"," ");      
					 }
				   }

				}

			}

			else
			{
			  if (( cnt1 == 3) && (strcmp(flag,"F") == 0) )
			  {
                  if (strlen(d_request_comment_desc2.arr) != 0)
                  {
                     fprintf(f1,"%-*s",(6-j)*8,"");
                     fprintf(f1,"                    ");
                     fprintf(f1,"%-40s\n",d_request_comment_desc2.arr);
					 line_no += 1 ;
					 cnt = 35 ;
					 fprintf(f1,"%-34.34s"," ");      
                  }
				  else
				  {
				     if( cnt >= 129)
			         {
			            fprintf(f1,"\n");
                        cnt = 35 ;
				        line_no += 1 ;
						fprintf(f1,"%-34.34s"," ");      
					 }
				   }


			  }
			  
			}	
			
		  }
		
		  j = 0 ;

		  if ( cnt1 > 3 )
          {    
  		     if( cnt >= 129)
			 {
			    fprintf(f1,"\n");
                cnt = 35 ;
				line_no += 1 ;
				fprintf(f1,"%-34.34s"," ");      
			 }
		  }


      }
   

	   fprintf(f1,"%s %-2s",d_test_code.arr,d_result_status.arr);	
	   
	   j += 1;
	   //cnt = cnt + 8 ;

	   cnt = cnt + strlen(d_test_code.arr) + 1;
	   cnt = cnt + strlen(d_result_status.arr) + 1;

    }


	if( cnt1 == 0 )
	{
//	   fprintf(f1,"%-*s",(6-j)*8,"");

	   fprintf(f1,"%-*s",(80-cnt),"");

       fprintf(f1,"%-15.15s %-30.30s\n",d_patient_id.arr,d_patient_name.arr);

	   line_no += 1; 
	}


	if( cnt1 < 2)
	{
          if (strlen(d_request_comment_desc1.arr) != 0)
          {
            if (( cnt > 25) && (cnt1 >= 1))
            {
                fprintf(f1,"%-*s",(89-cnt),"");
                fprintf(f1,"%-40s\n",d_request_comment_desc1.arr);
            }
            else
            {
                fprintf(f1,"%-90.90s%-40s\n"," ",d_request_comment_desc1.arr);
            }

            line_no += 1;
          }

	}

    if( cnt1 < 3)
	{

           if (strlen(d_request_comment_desc2.arr) != 0)
           {
		   


              if ((cnt > 25) && (cnt1 >= 2) && (strcmp(flag,"F") == 0))
              {

			  
                 fprintf(f1,"%-*s",(89-cnt),"");
                 fprintf(f1,"%-40s\n",d_request_comment_desc2.arr);
              }
              else
              {
			     if (strcmp(flag,"F") == 0)
                      fprintf(f1,"%-90.90s%-40s\n"," ",d_request_comment_desc2.arr);
              }

              line_no += 1;
           }
	}
	else
	{
	  fprintf(f1,"\n");
	  line_no += 1 ;
	}

	if (strcmp(flag,"T") == 0)
	{

	  strcpy(flag,"F");
	  fprintf(f1,"\n");
	  line_no += 1 ;

	 }


return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )504;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG, "Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}

/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) ,1,25) SHORT_NAME
			INTO :d_patient_name
            FROM RL_PATIENT_MAST
	    WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_lo\
c_lang,SHORT_NAME)),1,25) SHORT_NAME into :b1  from RL_PATIENT_MAST where PATI\
ENT_ID=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )519;
   sqlstm.selerr = (unsigned short)1;
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
   sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[1] = (unsigned int  )242;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )33;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


		/* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

  d_patient_name.arr[d_patient_name.len]     = '\0';

  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )546;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_referral_patient_dtl() occured....\n");
   proc_exit();
}

/* Function to fetch the INPATIENT details */
int get_in_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /*EXEC SQL SELECT SUBSTR(DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_LOC_LANG, SHORT_NAME)) ,1,25) SHORT_NAME
			INTO  :d_patient_name
            FROM MP_PATIENT_MAST 
	    WHERE PATIENT_ID = :d_patient_id;*/

  if (NODATAFOUND)
    return 0;
  d_patient_name.arr[d_patient_name.len]     = '\0';

  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )561;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_in_patient_dtl() occured....\n");
   proc_exit();
}
    
    
/*---------------------------------------------------------------------------*/
/* to print the header page for the report */
void print_rep_header()
{
  char nd_fr_specimen_desc[21],
       nd_to_specimen_desc[21];

  if(strcmp(nd_fr_specimen_no.arr, "!!!!!!!!!") == 0)
    strcpy(nd_fr_specimen_desc, "LOWEST");
    else strcpy(nd_fr_specimen_desc, nd_fr_specimen_no.arr);

  if(strcmp(nd_to_specimen_no.arr, "~~~~~~~~~") == 0)
    strcpy(nd_to_specimen_desc, "HIGHEST");
    else strcpy(nd_to_specimen_desc, nd_to_specimen_no.arr);

  #ifdef DEBUG
      printf("before report header()\n");
  #endif
  page_no++;
  print_page_header();

  #ifdef DEBUG
      printf("after page header()\n");
  #endif
  fprintf(f1,VER);
  fprintf(f1,"\n\n\n\n");
  //fprintf(f1,"        ");
  //fprintf(f1,"INPUT PARAMETERS :\n");
  
  rec_len = strlen(local_legend[3]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s:\n", local_legend[3]);//added for glob
  print_space(40, rec_len,1);//added for globalisation
  print_space(40, rec_len,0);//added for globalisation
  //fprintf(f1,"        ");
  //fprintf(f1,"------------------\n\n");
  //fprintf(f1,"                ");
  fprintf(f1,"\n\n");
  //fprintf(f1,"SPECIMEN NO. FROM : %s\n", nd_fr_specimen_desc);
  //fprintf(f1,"                ");
  rec_len = strlen(local_legend[4]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s :%s\n",local_legend[4],nd_fr_specimen_desc);
  fprintf(f1,"\n");
  rec_len = strlen(local_legend[5]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s :%s\n",local_legend[5],nd_to_specimen_desc);
  //fprintf(f1,"               TO : %s\n", nd_to_specimen_desc);
  fprintf(f1,"\n");
  fprintf(f1,"\f");
}


/* to print page headers the header details */ 
void print_page_header()
{
 register int i;
 char nd_fr_specimen_desc[21],
       nd_to_specimen_desc[21];
 char buf[15];

 int col;

char s1[10];
memset(hdr_line1,' ',REP_WIDTH+1);
  if(strcmp(nd_fr_specimen_no.arr, "!!!!!!!!!") == 0)
    strcpy(nd_fr_specimen_desc, "LOWEST");
    else strcpy(nd_fr_specimen_desc, nd_fr_specimen_no.arr);

  if(strcmp(nd_to_specimen_no.arr, "~~~~~~~~~") == 0)
    strcpy(nd_to_specimen_desc, "HIGHEST");
    else strcpy(nd_to_specimen_desc,nd_to_specimen_no.arr);

  
	strncpy(hdr_line1,"MDL:RL",6);
        col = (int)(REP_WIDTH - strlen(d_acc_entity_name.arr))/2;
        strncpy(hdr_line1 + col -1,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
        
		/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
					BEGIN
				//t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert_datet\
ime_2t ( SYSDATE , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )576;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_sysdate1;
  sqlstm.sqhstl[0] = (unsigned int  )19;
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


		col = (REP_WIDTH-strlen(d_sysdate1.arr));
		strcpy(hdr_line1+col+1,d_sysdate1.arr);
    
/*************added by babu****************/

memset(hdr_line2,' ',REP_WIDTH+1);
    strncpy(hdr_line2,"OPR:",4);
    strncpy(hdr_line2+4,d_user.arr,strlen(d_user.arr));
	strcpy(rep_title1, local_legend[6] );
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line2+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"%s : %4d",local_legend[1],page_no);
    strcpy(hdr_line2+(REP_WIDTH-strlen(buf)),buf);
	
/*********************END********************/
fprintf(f1,"\n");
fprintf(f1,hdr_line1);
fprintf(f1,"\n");
fprintf(f1,hdr_line2);
fprintf(f1,"\n");
fprintf(f1,"REP : RLROSWRG");
fprintf(f1,"\n");
 line_no += 4;
fprintf(f1,"--------------------------------------------------------------------");
fprintf(f1,"----------------------------------------------------------------");
}




/* print the heading */
void print_col_heading()
{
 
 
 fprintf(f1,"\n");
/* col headings here */
/*****
 fprintf(f1,"<-----SPECIMEN----->  T E S T S   O R D E R E D   A N D   S T A T U S PATIENT NUMBER              PATIENT'S NAME---------------->\n");
 fprintf(f1,"NUMBER      DATE\n");
 *****/
 fprintf(f1, "<-----%-8.8s----->        %-9.9s   %-13.13s   %-5.5s   %-11.11s %-14.14s  %-14.14s---------------->\n",local_legend[7],local_legend[8],local_legend[9],local_legend[10],local_legend[11],local_legend[12],local_legend[13]);
 fprintf(f1, "%-6.6s    %-4.4s\n",local_legend[14],local_legend[15]);
 fprintf(f1,"====================================================================");
 fprintf(f1,"================================================================");
 fprintf(f1,"\n");

 line_no += 4;
}

/*--------------------------------------------------------------------------*/
gen_file_name()
{
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
	 strcpy(nd_file_name.arr,WORKING_DIR);
	 strcat(nd_file_name.arr,"rlroswrg.lis");
     
     if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
	 {
	     fprintf(f1,"%c&|26A",ESC);
		 fprintf(f1,"%c&a90P",ESC);
	     fprintf(f1,"%c&|1O",ESC);
	     fprintf(f1,"%c&k4S",ESC);
	 }


}
/*--------------------------------------------------------------------------*/
/***************** 01.07.2003
increment_file_no()
{
EXEC SQL UPDATE RL_PARAM
		SET PRINT_FILE_NO = NVL(PRINT_FILE_NO,0) + 1;
if (OERROR)
       err_mesg("Update failed on table RL_PARAM",0,"");

EXEC SQL COMMIT WORK;
      if (OERROR)
         err_mesg("COMMIT failed",0,"");
}
*************/
/*--------------------------------------------------------------------------*/
/*************** 01.07.2003
print_job()
{
char command_line[500];

     nd_printer_name.arr[0]   = '\0';
     nd_printer_name.len      = 0;
     
	 EXEC SQL SELECT PRINTER_NAME
	        INTO :nd_printer_name
	        FROM RL_SECTION_CODE
	       WHERE SECTION_CODE LIKE :nd_dept;

     if (OERROR)
         err_mesg("Fetch failed on table RL_SECTION_CODE",0,"");
      
     nd_printer_name.arr[nd_printer_name.len] = '\0';

     sprintf(command_line,"lp -s -d %s rlroswrg_%s.lis ",nd_printer_name.arr,nd_file_no.arr);
  system(command_line);
}
***************/
chk_break(int lin)
{
   if ((line_no + lin) >= MAX_LINES)
   {
     fprintf(f1,"");
	 print_page_header();
	 line_no = 1;
   }
}

check_gtt_specimen_test()
{

	if (d_group_test_yn.arr[0]	== 'Y')
	{
		declare_group_curs();
		while(fetch_group_curs())
		{
		   /* EXEC SQL SELECT COUNT(*)
		    INTO :l_count
		    FROM RL_INTERVAL_TEST_SPECIMENS
		    WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND test_code = :id_test_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_SPECIME\
NS where ((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and test_\
code=:b3)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )599;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&l_count;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_specimen_no;
     sqlstm.sqhstl[1] = (unsigned int  )23;
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
     sqlstm.sqhstv[3] = (         void  *)&id_test_code;
     sqlstm.sqhstl[3] = (unsigned int  )13;
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



			if (l_count > 0)
			{
				d_stat = 'Y';
				break;
			}
			else
				d_stat = 'N';
		
		}	
		close_group_curs();
	}
	else
	{
		   /* EXEC SQL SELECT COUNT(*)
		    INTO :l_count
		    FROM RL_INTERVAL_TEST_SPECIMENS
		    WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND test_code = :d_test_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_SPECIME\
NS where ((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and test_\
code=:b3)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )630;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&l_count;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_specimen_no;
     sqlstm.sqhstl[1] = (unsigned int  )23;
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
     sqlstm.sqhstv[3] = (         void  *)&d_test_code;
     sqlstm.sqhstl[3] = (unsigned int  )13;
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



			if (l_count > 0)
			{
				d_stat = 'Y';
			}
			else
				d_stat = 'N';

	}

}

declare_group_curs()
{
	/* EXEC SQL DECLARE group_curs CURSOR FOR
		SELECT test_code 
		FROM RL_GROUP_TEST_DETAIL
		WHERE group_test_code = :d_test_code; */ 


	/* EXEC SQL OPEN group_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0025;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )661;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&d_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
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


}

print_space(int aa, int bb, int cc)
{
	if (cc ==1)
	{
  		for(i=1;i <= (aa - bb) ;i++)
		{
			fprintf(f1,"%s"," ");
		}	
	}
	else if (cc ==0)
	{
  		for(i= (aa - bb);i <= aa ;i++)
		{
			fprintf(f1,"%s","-");
		}	
	}
}




int fetch_group_curs()
{
   id_test_code.arr[0]		= '\0';
   id_test_code.len			= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH group_curs INTO
		 :id_test_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )680;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&id_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  id_test_code.arr[id_test_code.len]='\0';


#ifdef DEBUG
 printf("id_test_code= %s\n",id_test_code.arr);
#endif
return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )699;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_curs() occured....\n");
   proc_exit();
}
close_group_curs()
{

	/* EXEC SQL CLOSE group_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )714;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/*---------------------------------------------------------------------------*/

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
