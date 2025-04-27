
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
           char  filnam[59];
};
static const struct sqlcxp sqlfpn =
{
    58,
    "D:\\WORK\\ML-MMOH-CRF-0752.6-US001\\Proc\\RLREPIDM\\RLREPIDM.pc"
};


static unsigned long sqlctx = 1143608861;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {10,14};

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

 static const char *sq0012 = 
"ECIMEN_NO)) and B.TEST_CODE=NVL(:b9,B.TEST_CODE)) and B.ORGANISM_CODE=NVL(:b\
10,B.ORGANISM_CODE)) and SOURCE_TYPE=DECODE(NVL(:b11,SOURCE_TYPE),'C','C','W',\
'W','R','E','E','E')) order by A.SOURCE_CODE,A.PATIENT_ID,A.SPECIMEN_NO,B.TEST\
_CODE,B.ORGANISM_CODE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,539,187,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,541,238,0,0,0,0,0,1,0,
51,0,0,3,0,0,544,247,0,0,0,0,0,1,0,
66,0,0,4,120,0,518,258,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
89,0,0,5,136,0,518,273,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
112,0,0,6,200,0,516,298,0,0,1,0,0,1,0,2,9,0,0,
131,0,0,7,243,0,516,317,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
194,0,0,8,91,0,514,362,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
217,0,0,9,0,0,544,370,0,0,0,0,0,1,0,
232,0,0,10,158,0,516,380,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
267,0,0,11,0,0,544,404,0,0,0,0,0,1,0,
282,0,0,12,1289,0,521,447,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
345,0,0,13,0,0,544,455,0,0,0,0,0,1,0,
360,0,0,14,191,0,518,539,0,0,3,3,0,1,0,3,9,0,0,1,9,0,0,1,9,0,0,
387,0,0,15,255,0,518,569,0,0,3,3,0,1,0,3,9,0,0,1,9,0,0,1,9,0,0,
414,0,0,12,0,0,525,737,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
485,0,0,16,0,0,544,793,0,0,0,0,0,1,0,
500,0,0,17,0,0,544,852,0,0,0,0,0,1,0,
515,0,0,18,0,0,544,895,0,0,0,0,0,1,0,
530,0,0,19,136,0,516,904,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
565,0,0,20,0,0,544,921,0,0,0,0,0,1,0,
580,0,0,21,124,0,516,930,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
615,0,0,22,0,0,544,947,0,0,0,0,0,1,0,
630,0,0,23,130,0,516,959,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
657,0,0,24,0,0,544,975,0,0,0,0,0,1,0,
672,0,0,25,120,0,516,986,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
699,0,0,26,0,0,544,1002,0,0,0,0,0,1,0,
714,0,0,27,97,0,516,1012,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
741,0,0,28,0,0,544,1028,0,0,0,0,0,1,0,
756,0,0,29,181,0,516,1037,0,0,5,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,
0,
791,0,0,30,0,0,544,1057,0,0,0,0,0,1,0,
806,0,0,31,181,0,516,1066,0,0,5,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,
0,
841,0,0,32,0,0,544,1084,0,0,0,0,0,1,0,
856,0,0,33,100,0,518,1148,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
879,0,0,34,156,0,518,1284,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
906,0,0,35,156,0,518,1307,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
933,0,0,36,101,0,518,1488,0,0,1,1,0,1,0,2,3,0,0,
952,0,0,37,49,0,516,1501,0,0,1,0,0,1,0,2,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	         : rlrepidm.pc
   Author        : S.Sheelvant 
   Date Created  : 25/03/1997
   Last Modified : 25/03/1997

   Modified by   : HAMEED 
   Reason        : For eHIS upgrade

*  Ver 1.10.01
   
*  Purpose       : To generate a report for INFECTION REPORT. 

*  Input Parameters : 
                      Command line inputs
		              1. Usr_id/Password
                      2. Session id
		              3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      5. Range of Process Dates 

*  Table Accessed :   RL_RESULT_ORGANISM, RL_RESULT_ORGANISM_DTL,
			          RL_REQUEST_HEADER, 
		              PATIENT MASTERS, SOURCE MASTERS.

*  Output File    :   rlrepidm.lis
   ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <gl.h>

#define MAX_LINES 40
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define ESC 0x1B
#define VER  "VER : 1.10.01\n"
#define REP_WIDTH 125
/*
#define DEBUG 1 
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* increased the length all varchar variables by one to take care */
    /* for null termination */
	/* VARCHAR     nd_operating_facility_id    [3],
	            uid_pwd		                [91],
                nd_file_name                [151],
                nd_user	                    [31],
                nd_file_no                  [15],
                nd_printer_name             [16],
				d_version_no			    [20],
				d_version  			        [20],


        /o Variables to recieve data from specimen register cursoro/ 
		d_patient_id            [21],
		d_source_code           [11],
        d_specimen_no           [21],
		d_spec_regd_date_time   [17],
		d_spec_regd_date_time1   [17],
		d_test_code             [11],
        d_organism_code         [5],
		d_antibiotic_code       [5],
        d_sensitivity_ind       [2],

		d_patient_name          [240],
		d_patient_name_1		[240],
		d_patient_name_2        [240],
		d_patient_name_3        [240],
		d_patient_name_4        [240],
		d_episode_type          [2],
		d_source_type			[2],
        d_source_desc           [31],
        d_sex                   [2],
		d_dob			[9],
		d_dob1			[9],
        d_long_desc             [100], /oModified By Manoj S for ML-MMOH-CRF-0752.6o/
		d_long_desc_orgnsm      [41],
		d_long_desc_antib       [41],
		d_category_code         [5],
		d_category_year         [5],
		d_category_num          [16],
		rl_ordered_facility_id	[3],

                /o input parameters to main() o/
        nd_session_id      	[16],
		nd_pgm_date	   	[20],

		/o input parameters through from SY_PROG_PARAM o/
 		nd_fr_process_date    	[11],
 		nd_fr_process_date1    	[11],
		nd_to_process_date    	[11],
		nd_to_process_date1    	[11],
		nd_fr_specimen_no       [21],
		nd_to_specimen_no       [21],
		nd_test_code            [11],
        nd_dept                 [2],
		nd_source_type          [2],
		nd_source_code          [11],
		nd_organism_code        [5],
		rl_func_ctl          [20],/oAdded by Nandhini against ML-MMOH-CRF-576o/


		/o for header routine o/
	    //d_acc_entity_name        [61],
		d_acc_entity_name        [300],
		d_user                   [31],
		d_sysdate                [17],
		/o For conversiono/
		l_translated_value		 [100],
		language_id			[5],
		d_sysdate1                [17]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[31]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_printer_name;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[11]; } d_source_code;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[17]; } d_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[17]; } d_spec_regd_date_time1;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[5]; } d_organism_code;

struct { unsigned short len; unsigned char arr[5]; } d_antibiotic_code;

struct { unsigned short len; unsigned char arr[2]; } d_sensitivity_ind;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_1;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_2;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_3;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_4;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[2]; } d_source_type;

struct { unsigned short len; unsigned char arr[31]; } d_source_desc;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[9]; } d_dob;

struct { unsigned short len; unsigned char arr[9]; } d_dob1;

struct { unsigned short len; unsigned char arr[100]; } d_long_desc;

struct { unsigned short len; unsigned char arr[41]; } d_long_desc_orgnsm;

struct { unsigned short len; unsigned char arr[41]; } d_long_desc_antib;

struct { unsigned short len; unsigned char arr[5]; } d_category_code;

struct { unsigned short len; unsigned char arr[5]; } d_category_year;

struct { unsigned short len; unsigned char arr[16]; } d_category_num;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_process_date;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_process_date1;

struct { unsigned short len; unsigned char arr[11]; } nd_to_process_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_process_date1;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code;

struct { unsigned short len; unsigned char arr[2]; } nd_dept;

struct { unsigned short len; unsigned char arr[2]; } nd_source_type;

struct { unsigned short len; unsigned char arr[11]; } nd_source_code;

struct { unsigned short len; unsigned char arr[5]; } nd_organism_code;

struct { unsigned short len; unsigned char arr[20]; } rl_func_ctl;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;



		
        int l_count = 0;

		int  l_tab_exists = 0 ;


//added for conversion
		int i;
		char local_legend[100][100];
		char hdr_line1[REP_WIDTH+1],
		hdr_line2[REP_WIDTH+1],
		hdr_line3[REP_WIDTH+1];
		int col;
		char rep_title1[100] ;
		char rep_title2[60];
		int rec_len;



/* EXEC SQL END DECLARE SECTION; */ 


		int   l_len = 30;
		char  l_delimeter;

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

int   spec_detl_printed = 0;
int   pat_detl_printed  = 0;
int   specimen_flag     = 0;
int   line_no=0, page_no=0;
int   first_page_flag=1;
int   nd_totl_specimens;

int   l_sensitive_line = 0;
int   l_specimen_count = 0;


/* summary fields for calculating No. of records */ 
void print_page_header();
void print_col_heading();
FILE *f1;
char string_var[100] ;

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
  	dclr_specimen_register(),
  	do_report();
 
   
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
   sqlstm.iters = (unsigned int  )20;
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

  

   #ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
   #endif  
   
   set_meduser_role();
	strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	get_legend_value(32);/*Added by Nandhini against ML-MMOH-CRF-576*/
			
   /* printf("rlrepidm : Program Started.\n\n"); */

   #ifdef DEBUG
    printf("I am here main() 0\n");
    fflush(stdout);
   #endif  

   get_params();
   get_function_ctl();/*Added by Nandhini against ML-MMOH-CRF-576*/

//   sprintf(string_var,"Section %s\n",nd_dept.arr);
//   disp_message(ERR_MESG,string_var) ;


   #ifdef DEBUG
    printf("I am here main() 1");
    fflush(stdout);
   #endif  
   
   gen_file_name();
   /*increment_file_no();*/
   
   get_header_dtls();

   #ifdef DEBUG
    printf("I am here main() 2");
    fflush(stdout);
   #endif  

   dclr_specimen_register();

   #ifdef DEBUG
    printf("I am here main() 3");
    fflush(stdout);
   #endif  

   do_report();

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL COMMIT WORK; */ 

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



   /* printf("rlrepidm : Program Ended.\n\n"); */

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


/************get_legend_value*******************/
get_legend_value(int cou)
 {
     
   
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLREPIDM.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLREPIDM.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLREPIDM.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LREPIDM.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )89;
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
/****************End****************/

get_function_ctl() /*Added by Nandhini against ML-MMOH-CRF-576*/
{     
 	rl_func_ctl.arr[0] ='\0';
	rl_func_ctl.len=0;
	
	/* EXEC SQL SELECT NVL(VALUE_1,'N') INTO :rl_func_ctl
	FROM SM_FUNCTION_CONTROL,SM_SITE_PARAM
	WHERE SM_FUNCTION_CONTROL.SITE_ID=SM_SITE_PARAM.CUSTOMER_ID
	AND MODULE_ID='RL' AND FUNCTIONALITY_ID='RL_INFECTION_ORG_SDD'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(VALUE_1,'N') into :b0  from SM_FUNCTION_CONTROL ,\
SM_SITE_PARAM where ((SM_FUNCTION_CONTROL.SITE_ID=SM_SITE_PARAM.CUSTOMER_ID an\
d MODULE_ID='RL') and FUNCTIONALITY_ID='RL_INFECTION_ORG_SDD')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )112;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_func_ctl;
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


	
	if (OERROR)
         disp_message(ORA_MESG,"Select failed on table SM_SITE_PARAM");

	  rl_func_ctl.arr[rl_func_ctl.len]	= '\0';

} 


/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT 
		         OPERATING_FACILITY_ID,
				 PARAM2,
		         PARAM3,
		         PARAM4,
		         PARAM5,
		         PARAM6,
		         PARAM7,
				 PARAM8,
				 PARAM9,
				 PARAM10
            INTO 
                 :nd_operating_facility_id,
				 :nd_fr_process_date,
                 :nd_to_process_date,
		         :nd_dept,
				 :nd_source_type,
				 :nd_source_code,
				 :nd_organism_code,
				 :nd_fr_specimen_no,
				 :nd_to_specimen_no,
				 :nd_test_code
            FROM  SY_PROG_PARAM
	        WHERE PGM_ID = 'RLREPIDM'
		      AND SESSION_ID = TO_NUMBER(:nd_session_id)
		      AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM2 ,PARAM3 ,PARAM4 ,PARA\
M5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:\
b7,:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='RLREPIDM' and SESSION_ID=TO_NUM\
BER(:b10)) and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )131;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_process_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_process_date;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_dept;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_source_type;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_source_code;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_organism_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fr_specimen_no;
   sqlstm.sqhstl[7] = (unsigned int  )23;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_specimen_no;
   sqlstm.sqhstl[8] = (unsigned int  )23;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_test_code;
   sqlstm.sqhstl[9] = (unsigned int  )13;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[11] = (unsigned int  )22;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



   nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
   nd_fr_process_date.arr[nd_fr_process_date.len]   = '\0';
   nd_to_process_date.arr[nd_to_process_date.len]   = '\0';
   nd_source_type.arr[nd_source_type.len]           = '\0';
   nd_source_code.arr[nd_source_code.len]           = '\0';
   nd_organism_code.arr[nd_organism_code.len]       = '\0';
   nd_fr_specimen_no.arr[nd_fr_specimen_no.len]     = '\0';
   nd_to_specimen_no.arr[nd_to_specimen_no.len]     = '\0';
   nd_test_code.arr[nd_test_code.len]               = '\0';

  #ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf("nd_fr_process_date :%s\n", nd_fr_process_date.arr);
   printf("nd_to_process_date : %s\n", nd_to_process_date.arr);
  #endif

  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE PGM_ID = 'RLREPIDM'
	         AND SESSION_ID = :nd_session_id
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='RLREPIDM' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )194;
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
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )217;
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
	        INTO :d_acc_entity_name,
		    :d_user,
		    :d_sysdate
            FROM SY_ACC_ENTITY_LANG_VW
            WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			AND   LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b\
3 and LANGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )232;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )267;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}
 

/* function declares SPECIMEN_REGISTER cursor */
void dclr_specimen_register()
{ 
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL DECLARE SPECIMEN_REGISTER CURSOR FOR
     SELECT A.PATIENT_ID,A.SPECIMEN_NO,A.SOURCE_TYPE,
	        TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YY'),
	        A.SOURCE_CODE,A.EPISODE_TYPE,
	        B.ORGANISM_CODE, B.TEST_CODE,
	        C.ANTIBIOTIC_CODE, C.SENSITIVITY_IND,a.CATEGORY_CODE,a.CATEGORY_YEAR,a.CATEGORY_NUMBER,
			A.ORDERED_FACILITY_ID
       FROM RL_RESULT_ORGANISM B, RL_RESULT_ORGANISM_DTL C,
	        RL_REQUEST_HEADER  A
      WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SECTION_CODE = :nd_dept
	    AND B.PATIENT_ID  = C.PATIENT_ID 
        AND B.SPECIMEN_NO = C.SPECIMEN_NO 
		AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id 
        AND B.PATIENT_ID  = A.PATIENT_ID
        AND B.SPECIMEN_NO = A.SPECIMEN_NO
		AND C.ORGANISM_CODE = B.ORGANISM_CODE
		AND C.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND NVL(C.SENSITIVITY_IND,'!') IN ('S','I','R','D')/oAdded by lo/
	    AND NVL(A.CANCELLED_YN,'N') != 'Y'
        AND TRUNC(B.ADDED_DATE) 
	        BETWEEN TRUNC(TO_DATE(NVL(:nd_fr_process_date,TO_CHAR(B.ADDED_DATE,'DD/MM/YYYY')),'DD/MM/YYYY'))
               AND TRUNC(TO_DATE(NVL(:nd_to_process_date,TO_CHAR(B.ADDED_DATE,'DD/MM/YYYY')),'DD/MM/YYYY')) 
				AND A.SOURCE_CODE = NVL(:nd_source_code,A.SOURCE_CODE)
				AND B.SPECIMEN_NO 
		        BETWEEN NVL(:nd_fr_specimen_no, B.SPECIMEN_NO)
				AND NVL(:nd_to_specimen_no, B.SPECIMEN_NO)
				AND B.TEST_CODE = NVL(:nd_test_code, B.TEST_CODE)
				AND B.ORGANISM_CODE = NVL(:nd_organism_code,B.ORGANISM_CODE)
        AND SOURCE_TYPE = DECODE(NVL(:nd_source_type,SOURCE_TYPE),'C','C','W','W','R','E','E','E')
      ORDER BY A.SOURCE_CODE,A.PATIENT_ID,A.SPECIMEN_NO,B.TEST_CODE,B.ORGANISM_CODE; */ 
 

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN SPECIMEN_REGISTER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select A.PATIENT_ID ,A.SPECIMEN_NO ,A.SOURCE_TYPE ,TO_CHAR(A.SPEC_REGD\
_DATE_TIME,'DD/MM/YY') ,A.SOURCE_CODE ,A.EPISODE_TYPE ,B.ORGANISM_CODE ,B.TE\
ST_CODE ,C.ANTIBIOTIC_CODE ,C.SENSITIVITY_IND ,a.CATEGORY_CODE ,a.CATEGORY_Y\
EAR ,a.CATEGORY_NUMBER ,A.ORDERED_FACILITY_ID  from RL_RESULT_ORGANISM B ,RL\
_RESULT_ORGANISM_DTL C ,RL_REQUEST_HEADER A where ((((((((((((((((A.OPERATIN\
G_FACILITY_ID=:b0 and A.SECTION_CODE=:b1) and B.PATIENT_ID=C.PATIENT_ID) and\
 B.SPECIMEN_NO=C.SPECIMEN_NO) and B.OPERATING_FACILITY_ID=:b0) and B.PATIENT\
_ID=A.PATIENT_ID) and B.SPECIMEN_NO=A.SPECIMEN_NO) and C.ORGANISM_CODE=B.ORG\
ANISM_CODE) and C.OPERATING_FACILITY_ID=:b0) and NVL(C.SENSITIVITY_IND,'!') \
in ('S','I','R','D')) and NVL(A.CANCELLED_YN,'N')<>'Y') and TRUNC(B.ADDED_DA\
TE) between TRUNC(TO_DATE(NVL(:b4,TO_CHAR(B.ADDED_DATE,'DD/MM/YYYY')),'DD/MM\
/YYYY')) and TRUNC(TO_DATE(NVL(:b5,TO_CHAR(B.ADDED_DATE,'DD/MM/YYYY')),'DD/M\
M/YYYY'))) and A.SOURCE_CODE=NVL(:b6,A.SOURCE_CODE)) and B.SPECIMEN_NO betwe\
en NVL(:b7,B.SPECIMEN_NO) and NVL(:b8,B.SP");
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )282;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_dept;
   sqlstm.sqhstl[1] = (unsigned int  )4;
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
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fr_process_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_process_date;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_source_code;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fr_specimen_no;
   sqlstm.sqhstl[7] = (unsigned int  )23;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_specimen_no;
   sqlstm.sqhstl[8] = (unsigned int  )23;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_test_code;
   sqlstm.sqhstl[9] = (unsigned int  )13;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_organism_code;
   sqlstm.sqhstl[10] = (unsigned int  )7;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_source_type;
   sqlstm.sqhstl[11] = (unsigned int  )4;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


  #ifdef DEBUG
    printf("leaving dclr_specimen_register()\n");
  #endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )345;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_specimen_register() occured....\n");
   proc_exit();
}


/* prints the master-detail record until the cursor is empty */
void do_report()
{

  void print_rep_header();
  void prepare_new_page();
  void print_detl_rec();
  void end_report();
  void get_ward_desc();
  void get_clinic_desc();
  void get_organism_desc();
  void get_referral_source_desc();
  int  get_patient_dtl(); 
  void get_referral_patient_dtl();
   int i = 0;
  int fetch_specimen_register();
  int still_rec_left;
  
  /* Variables used to control the breaks -------------------*/
  char temp_source_code[11];
  char temp_patient_id [21]; //Changed from 11  against scf BSP30453-SCF-0146
  char temp_specimen_no [21];
  char temp_org_code[5];
  char temp_test_code[11];

  first_page_flag = 1;
  
  print_rep_header();   /* once for the report */

  first_page_flag = 0;
  
  page_no += 1; /* icrement by 1 as it is moving to second page */


  line_no = 0; //05.09.2005

/*  line_no = 11;  05.09.2005 */

  print_page_header();
  print_col_heading();
  
/*  line_no +=6; */ /*incr. by 4 as col. headings occupy 4 lines */ 

  /* read the first cursor record */
  still_rec_left = fetch_specimen_register();
  
  while(still_rec_left)
  {
     if(strcmp(d_source_type.arr,"W")==0)
        get_ward_desc();
     else
     if(strcmp(d_source_type.arr,"C")==0)
        get_clinic_desc();
     else
     if(strcmp(d_source_type.arr,"E")==0)
        get_referral_source_desc();

     fprintf(f1,"%-30s\n\n",d_long_desc.arr);
     line_no += 2;
     strcpy(temp_source_code,d_source_code.arr);

     /* Loop to control break by source ---------------------------------*/
     while(still_rec_left && strcmp(temp_source_code,d_source_code.arr)==0)
     {
        if(strcmp(d_episode_type.arr,"I")==0||strcmp(d_episode_type.arr,"O")==0 || strcmp(d_episode_type.arr,"H")==0)
        { 
	   	   i=get_patient_dtl();
           
        } 
        else
           if(strcmp(d_episode_type.arr,"R")==0)
              get_referral_patient_dtl();

        l_delimeter = ' ';
		rl_split_text(d_patient_name.arr, l_delimeter, l_len, d_patient_name_1.arr,
			          d_patient_name_2.arr, d_patient_name_3.arr, d_patient_name_4.arr);

		 //Added by babu for globalization
			/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//------Commented aginst leap year date problem in thai
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_dob,'DD/MM/YY HH24:MI'), :language_id , t_date);
				//:d_dob1 := to_char(t_date,'DD/MM/YY');
				//------Added aginst leap year date problem in thai
				:d_dob1 :=sm_convert_date_2t(to_date(:d_dob,'DD/MM/YYYY'),:language_id);
				:d_dob1:=TO_CHAR(TO_DATE(:d_dob1,'DD/MM/YYYY'),'DD/MM/YY');
				END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN :d_dob1 := sm_convert_date_2t \
( to_date ( :d_dob , 'DD/MM/YYYY' ) , :language_id ) ; :d_dob1 := TO_CHAR ( TO\
_DATE ( :d_dob1 , 'DD/MM/YYYY' ) , 'DD/MM/YY' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )360;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_dob1;
   sqlstm.sqhstl[0] = (unsigned int  )11;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_dob;
   sqlstm.sqhstl[1] = (unsigned int  )11;
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



		//End
		fprintf(f1,"%-21s%-42s%-11s%-4s",
 	               d_patient_id.arr, d_patient_name_1.arr,d_dob1.arr,
	               d_sex.arr);
        specimen_flag = 0;
	    strcpy(temp_patient_id,d_patient_id.arr);

		/* Loop to control break by Patient ID --------------------------*/
	    while(still_rec_left 
		      && (strcmp(temp_source_code,d_source_code.arr)==0) 
			  && strcmp(temp_patient_id,d_patient_id.arr)==0)
	    {
             spec_detl_printed = 0;
	         if(specimen_flag == 1)
		        fprintf(f1,"%-78s"," ");

             //Added by babu for globalization
			/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//------Commented aginst leap year date problem in thai
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:d_spec_regd_date_time1 := to_char(t_date,'DD/MM/YY');
				//------Added aginst leap year date problem in thai
				:d_spec_regd_date_time1 :=sm_convert_date_2t(to_date(:d_spec_regd_date_time,'DD/MM/YYYY'),:language_id);
				:d_spec_regd_date_time1:=TO_CHAR(TO_DATE(:d_spec_regd_date_time1,'DD/MM/YYYY'),'DD/MM/YY');
				END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN :d_spec_regd_date_time1 := sm_\
convert_date_2t ( to_date ( :d_spec_regd_date_time , 'DD/MM/YYYY' ) , :languag\
e_id ) ; :d_spec_regd_date_time1 := TO_CHAR ( TO_DATE ( :d_spec_regd_date_time\
1 , 'DD/MM/YYYY' ) , 'DD/MM/YY' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )387;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time1;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_spec_regd_date_time;
   sqlstm.sqhstl[1] = (unsigned int  )19;
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



		//End
			 fprintf(f1,"%-16s%-12s",
	          	        d_specimen_no.arr,d_spec_regd_date_time1.arr);
			 
			 l_specimen_count++;
			 
//05.09.2005 line_no++;

			 if (strlen(d_category_num.arr))
				{
				fprintf(f1,"%5.5s/%-4.4s/%-16.16s",
				d_category_code.arr,d_category_year.arr,
				d_category_num.arr);
//05.09.2005 	line_no += 1;
				}

			 fprintf(f1,"\n");
             if(specimen_flag != 1)  // Added by Durai Rajkumar against IN009477 on 03-Apr-09 
			 fprintf(f1,"%-21s%-30s\n"," ",d_patient_name_2.arr);
//05.09.2005 line_no += 1;
			 line_no += 2; //05.09.2005 

             if(line_no >= MAX_LINES)
                prepare_new_page();
			           
			 specimen_flag = 1;
         	 strcpy(temp_specimen_no,d_specimen_no.arr);

             /* Loop to control break by Specimen No. -------------------*/
             while(still_rec_left && 
		          (strcmp(temp_source_code,d_source_code.arr)==0) &&
		          (strcmp(temp_patient_id,d_patient_id.arr)==0) &&
		          (strcmp(temp_specimen_no,d_specimen_no.arr)==0))
	         {
			   strcpy(temp_test_code,d_test_code.arr);
		       fprintf(f1,"%-4.4s    --->  %-11.11s\n",local_legend[30],d_test_code.arr);
			   line_no++;
               if(line_no >= MAX_LINES)
                  prepare_new_page();


			   /* Loop to control break by test ---------------------*/
	           while(still_rec_left && 
		            (strcmp(temp_source_code,d_source_code.arr)==0) &&
		            (strcmp(temp_patient_id,d_patient_id.arr)==0) &&
		            (strcmp(temp_specimen_no,d_specimen_no.arr)==0) &&
			        (strcmp(temp_test_code,d_test_code.arr)==0))
   		     
			   { 
			     strcpy(temp_org_code,d_organism_code.arr);
		
				 get_organism_desc();
				 fprintf(f1,"%-7.7s ---> %-14.14s%-100.100s%-40.40s\n",local_legend[2],d_organism_code.arr,d_long_desc_orgnsm.arr);/*Modified by Nandhini against ML-MMOH-SCF-0543*/
			     line_no++;

				 /* Loop to control break by source ---------------------*/
 	             while(still_rec_left && 
		              (strcmp(temp_source_code,d_source_code.arr)==0) &&
		              (strcmp(temp_patient_id,d_patient_id.arr)==0) &&
		              (strcmp(temp_specimen_no,d_specimen_no.arr)==0) &&
                      (strcmp(temp_test_code,d_test_code.arr)==0) &&
				      (strcmp(temp_org_code,d_organism_code.arr)==0))
	             { 
                 
                     if(line_no >= MAX_LINES)
                     {
                        prepare_new_page();
						if(l_tab_exists) 
						{
							spec_detl_printed = 0;
	                        print_detl_rec();
						}
						else
						    print_detl_rec_ah();

                     }
                     else 
					 {
						if(l_tab_exists) 
							print_detl_rec();
						else
							print_detl_rec_ah();
					 }

                     still_rec_left = fetch_specimen_register();
			     }
				 fprintf(f1,"\n");
				 line_no++;
				 l_sensitive_line = 0;
				 spec_detl_printed = 0;

                 if(line_no >= MAX_LINES)
                   prepare_new_page();

			   }
             }
		     fprintf(f1,"\n");
		     line_no++;

             if(line_no >= MAX_LINES)
               prepare_new_page();

		} 
	    fprintf(f1,"\n");
	    line_no++;

        if(line_no >= MAX_LINES)
          prepare_new_page();

	 }
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

   line_no = 0; //05.09.2005  

   fprintf(f1,"");
   print_page_header();
   print_col_heading(); 
   fprintf(f1,"%-30s\n\n",d_long_desc.arr);
   line_no += 2; //05.09.2005  
//05.09.2005  line_no = 13;
}

/* fetches the next record from SPECIMEN REGISTER CURSOR */
/* returns 0 if the end of cursor is reached else returns 1. */
int fetch_specimen_register()
{

  d_category_code.arr[0]      = '\0';
  d_category_year.arr[0]      = '\0';
  d_category_num.arr[0]       = '\0';
  rl_ordered_facility_id.arr[0]	  = '\0';

  d_category_code.len      = 0;
  d_category_year.len      = 0;
  d_category_num.len       = 0;
  rl_ordered_facility_id.len = 0;


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH SPECIMEN_REGISTER INTO
		:d_patient_id,
	    :d_specimen_no,
		:d_source_type,
		:d_spec_regd_date_time,
		:d_source_code,
		:d_episode_type,
		:d_organism_code,
		:d_test_code,
		:d_antibiotic_code,
		:d_sensitivity_ind,
		:d_category_code,
		:d_category_year,
		:d_category_num,
		:rl_ordered_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )414;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
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
  sqlstm.sqhstv[2] = (         void  *)&d_source_type;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_spec_regd_date_time;
  sqlstm.sqhstl[3] = (unsigned int  )19;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_source_code;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[5] = (unsigned int  )4;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_organism_code;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_test_code;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_antibiotic_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_sensitivity_ind;
  sqlstm.sqhstl[9] = (unsigned int  )4;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_category_code;
  sqlstm.sqhstl[10] = (unsigned int  )7;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_category_year;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_category_num;
  sqlstm.sqhstl[12] = (unsigned int  )18;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&rl_ordered_facility_id;
  sqlstm.sqhstl[13] = (unsigned int  )5;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}




   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_patient_id.arr[d_patient_id.len]        = '\0';
  d_specimen_no.arr[d_specimen_no.len]      = '\0';
  d_source_type.arr[d_source_type.len]		= '\0';
  d_spec_regd_date_time.arr[d_spec_regd_date_time.len] = '\0';
  d_source_code.arr[d_source_code.len]      = '\0';
  d_episode_type.arr[d_episode_type.len]    = '\0';
  d_organism_code.arr[d_organism_code.len]  = '\0';
  d_test_code.arr[d_test_code.len]          = '\0';
  d_antibiotic_code.arr[d_antibiotic_code.len] = '\0';
  d_sensitivity_ind.arr[d_sensitivity_ind.len] = '\0';
  d_category_code.arr[d_category_code.len]  = '\0';
  d_category_year.arr[d_category_year.len]  = '\0';
  d_category_num.arr[d_category_num.len]    = '\0';
  rl_ordered_facility_id.arr[rl_ordered_facility_id.len]	= '\0';

#ifdef DEBUG
 printf("d_specimen_no = %s\n",d_specimen_no.arr);
 printf("d_patient_id = %s\n",d_patient_id.arr);
 printf("d_source_type = %s\n",d_source_type.arr);
 printf("d_episode_type = %s\n",d_episode_type.arr);
 printf("d_spec_regd_date_time = %s\n",d_spec_regd_date_time.arr);
 printf("d_source_code = %s\n",d_source_code.arr);
 printf("d_organism_code = %s\n",d_organism_code.arr);
 printf("d_test_code = %s\n",d_test_code.arr);
 printf("d_antibiotic_code = %s\n",d_antibiotic_code.arr);
 printf("d_sensitivity_ind = %s\n",d_sensitivity_ind.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )485;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_specimen_register() occured....\n");
   proc_exit();
}
/* print the finishing line of the report */
void end_report()
{
  fprintf(f1,"\n\n\n%-13.13s : %d\n" ,local_legend[3], l_specimen_count);

  fprintf(f1,"\n\n\n");
  fprintf(f1,"\n");
  fprintf(f1,"                                                   ");
  fprintf(f1,"** %s **",local_legend[4]);
  fprintf(f1,"");
}

/* to print the detailed record */
void print_detl_rec()      ////modified the procedure on 16.08.2005
{
    if(spec_detl_printed == 0)       
    {
       spec_detl_printed = 1;
	   if(line_no + 2 >= MAX_LINES)
         prepare_new_page();

	   fprintf(f1,"%-45s%-20.20s\n"," ",local_legend[31]);
	   
	if(strcmp(rl_func_ctl.arr,"Y")==0)/*Added by Nandhini against ML-MMOH-CRF-576*/
	{
	  fprintf(f1,"%-42s%-9.9s  %-12.12s  %-9.9s  %-9.9s\n"," " ,local_legend[24],local_legend[26],local_legend[25],local_legend[32]);//*Added by Nandhini against ML-MMOH-CRF-576*/
	  }
	else
	{
	  fprintf(f1,"%-42s%-9.9s  %-12.12s  %-9.9s  %-9.9s\n"," " ,local_legend[24],local_legend[26],local_legend[25]);
	  }	  
	  line_no = line_no + 2; 
	  }
	 get_antibiotic_desc();

//////	fprintf(f1,"%-6s%-40s",d_antibiotic_code.arr,d_long_desc_antib.arr);

	fprintf(f1,"%-40s",d_long_desc_antib.arr);

    if(strcmp(d_sensitivity_ind.arr,"S") == 0)  
		fprintf(f1,"%-2s%-2s"," ",d_sensitivity_ind.arr);
    else if(strcmp(d_sensitivity_ind.arr,"I") == 0)  
		fprintf(f1,"%-13s%-2s"," ",d_sensitivity_ind.arr);
    else if(strcmp(d_sensitivity_ind.arr,"R") == 0)  
		fprintf(f1,"%-27s%-2s"," ",d_sensitivity_ind.arr);	
	else if(strcmp(d_sensitivity_ind.arr,"D")== 0) /*Added by Nandhini against ML-MMOH-CRF-576*/
	fprintf(f1,"%-38s%-2s"," ",d_sensitivity_ind.arr);	
   
    fprintf(f1,"\n");
    line_no++;

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )500;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}
print_detl_rec_ah()
{
    if(spec_detl_printed == 0)       
    {
       spec_detl_printed = 1;
       //fprintf(f1,"%-14.14s%-10s%-12s\n","Sensitivities",d_antibiotic_code.arr,d_sensitivity_ind.arr);
       //line_no++;
	   fprintf(f1,"%-14.14s%-6s%-2s","Sensitivities",d_antibiotic_code.arr,d_sensitivity_ind.arr);
	   l_sensitive_line = 1;
    }
    else
    {  
	   if (l_sensitive_line == 14)
	   {
	      l_sensitive_line = 0;
		  fprintf(f1, "\n");
		  fprintf(f1,"%-14.14s"," ");
		  line_no++;
       }

	   if (l_sensitive_line == 0) 
	   {
		  fprintf(f1,"%-6s%-2s",d_antibiotic_code.arr,d_sensitivity_ind.arr);
		  l_sensitive_line++;
	   }
	   else if (l_sensitive_line != 0) 
       {
	      fprintf(f1,"%s%-6s%-2s",",",d_antibiotic_code.arr,d_sensitivity_ind.arr);
		  l_sensitive_line++;
	   }

       //fprintf(f1,"%-6s%-2s",d_antibiotic_code.arr,d_sensitivity_ind.arr);
       //line_no++;
    }

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )515;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}


void get_ward_desc()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT LONG_DESC 
			INTO   :d_long_desc
			 FROM   IP_NURSING_UNIT_LANG_VW
			WHERE  FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
			AND NURSING_UNIT_CODE = :d_source_code
			AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from IP_NURSING_UNIT_LANG_VW wh\
ere ((FACILITY_ID=nvl(:b1,:b2) and NURSING_UNIT_CODE=:b3) and LANGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )530;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_long_desc;
   sqlstm.sqhstl[0] = (unsigned int  )102;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_ordered_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
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
   sqlstm.sqhstv[3] = (         void  *)&d_source_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
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



  d_long_desc.arr[d_long_desc.len]     = '\0';

  #ifdef DEBUG
   printf("d_long_desc = %s\n", d_long_desc.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )565;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_ward_desc() occured....\n");
   proc_exit();
}

/* Function to fetch the CLINIC DESCRIPTION */
void get_clinic_desc()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT LONG_DESC 
	        INTO   :d_long_desc
            FROM   OP_CLINIC_LANG_VW 
	        WHERE  FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
		    AND CLINIC_CODE = :d_source_code
			AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from OP_CLINIC_LANG_VW where ((\
FACILITY_ID=nvl(:b1,:b2) and CLINIC_CODE=:b3) and LANGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )580;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_long_desc;
   sqlstm.sqhstl[0] = (unsigned int  )102;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_ordered_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
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
   sqlstm.sqhstv[3] = (         void  *)&d_source_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
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



  d_long_desc.arr[d_long_desc.len]     = '\0';

  #ifdef DEBUG
   printf("d_long_desc = %s\n", d_long_desc.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )615;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_clinic_desc() occured....\n");
   proc_exit();
}

/*  added on 06.10.2002 srinivas ****** */

/* Function to fetch the ORGANISM DESCRIPTION */

void get_organism_desc()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT LONG_DESC 
	        INTO   :d_long_desc_orgnsm
            FROM   RL_ORGANISM_CODE_LANG_VW
	        WHERE  ltrim(rtrim(ORGANISM_CODE)) = ltrim(rtrim(:d_organism_code))
			AND    LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RL_ORGANISM_CODE_LANG_VW w\
here (ltrim(rtrim(ORGANISM_CODE))=ltrim(rtrim(:b1)) and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )630;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_long_desc_orgnsm;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_organism_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_long_desc_orgnsm.arr[d_long_desc_orgnsm.len]     = '\0';

  #ifdef DEBUG
   printf("d_long_desc_orgnsm = %s\n", d_long_desc_orgnsm.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )657;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_organism_desc() occured....\n");
   proc_exit();
}

/* upto here ********* */

////////// added the following procedure on 16.08.2005
get_antibiotic_desc()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT LONG_DESC 
	        INTO   :d_long_desc_antib
            FROM   RL_ANTIBIOTIC_CODE_LANG_VW
	        WHERE  ANTIBIOTIC_CODE = ltrim(rtrim(:d_antibiotic_code))
			AND    LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RL_ANTIBIOTIC_CODE_LANG_VW\
 where (ANTIBIOTIC_CODE=ltrim(rtrim(:b1)) and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )672;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_long_desc_antib;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_antibiotic_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_long_desc_antib.arr[d_long_desc_antib.len]     = '\0';

  #ifdef DEBUG
   printf("d_long_desc_antib = %s\n", d_long_desc_antib.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )699;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_antibiotic_desc() occured....\n");
   proc_exit();
}


/* Function to fetch the REFERRL SOURCE DESCRIPTION */
void get_referral_source_desc()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT LONG_DESC 
	    INTO   :d_long_desc
            FROM   RL_REFERRAL_LANG_VW 
	    WHERE  REFERRAL_CODE = :d_source_code
		AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RL_REFERRAL_LANG_VW where \
(REFERRAL_CODE=:b1 and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )714;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_long_desc;
   sqlstm.sqhstl[0] = (unsigned int  )102;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_source_code;
   sqlstm.sqhstl[1] = (unsigned int  )13;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_long_desc.arr[d_long_desc.len]     = '\0';

  #ifdef DEBUG
   printf("d_long_desc = %s\n", d_long_desc.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )741;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_referral_source_desc() occured....\n");
   proc_exit();
}

/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) SHORT_NAME, 
			SEX,
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY')
	       INTO   :d_patient_name, :d_sex, :d_dob
           FROM   RL_PATIENT_MAST
	       WHERE  PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_loc_lang,S\
HORT_NAME)) SHORT_NAME ,SEX ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') into :b1,:b2,:b\
3  from RL_PATIENT_MAST where PATIENT_ID=:b4";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )756;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
  sqlstm.sqhstv[2] = (         void  *)&d_sex;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_dob;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
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


		   /* AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */

  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_sex.arr[d_sex.len] = '\0';
  d_dob.arr[d_dob.len] = '\0';

  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )791;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_referral_patient_dtl() occured....\n");
   proc_exit();
}

/* Function to fetch the INPATIENT details */
int get_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) SHORT_NAME, 
			SEX,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY')
	        INTO   :d_patient_name, :d_sex, :d_dob
            FROM   MP_PATIENT_MAST 
	        WHERE  PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_loc_lang,\
SHORT_NAME)) SHORT_NAME ,SEX ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') into :b1,:b2,:\
b3  from MP_PATIENT_MAST where PATIENT_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )806;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqhstv[2] = (         void  *)&d_sex;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_dob;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[4] = (unsigned int  )23;
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


  if(NODATAFOUND)
     return 0;
  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_sex.arr[d_sex.len] = '\0';
  d_dob.arr[d_dob.len] = '\0';
  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )841;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_patient_dtl() occured....\n");
   proc_exit();
}
    
/* to print page headers the header details */ 
void print_page_header()
{
 register int i;
 int spc_len;
 char  nd_fr_process_date_desc[100],
       nd_to_process_date_desc[100];
	   
	   char buf[15];

  if(strcmp(nd_fr_process_date.arr, "01/01/1800") == 0)
    strcpy(nd_fr_process_date_desc, "LOWEST");
    else strcpy(nd_fr_process_date_desc, nd_fr_process_date.arr);

  if(strcmp(nd_to_process_date.arr, "31/12/4712") == 0)
    strcpy(nd_to_process_date_desc, "HIGHEST");
    else strcpy(nd_to_process_date_desc, nd_to_process_date.arr);

 fprintf(f1,"%c&l1O",ESC);
 fprintf(f1,"%c&k4S",ESC);
 /*
 fprintf(f1,"MDL : RL");
 fprintf(f1,"                             ");  
 fprintf(f1,"%-30.30s", d_acc_entity_name.arr);
 fprintf(f1,"                         ");  
 fprintf(f1,"%s", d_sysdate.arr);
 */
  /*****commented for globalization
  fprintf(f1,"\n");
  fprintf(f1,"MDL : RL");
  ************End Comments**/
  
  /* From here ML_SD-SCF-1850
     spc_len = (88 - (strlen(d_acc_entity_name.arr)))/2; 
     for(i=1;i<=spc_len;i++)
     fprintf(f1," ");    
     fprintf(f1,"%-60.60s", d_acc_entity_name.arr);
     for(i=1;i<=spc_len;i++)
     fprintf(f1," ");
     fprintf(f1,"%s", d_sysdate.arr); 
   Upto here ML_SD-SCF-1850*/
   
  /*************COMMENTED FOR CONVERSION
  // changed from here ML_SD-SCF-1850
  spc_len = (132- (strlen(d_acc_entity_name.arr)))/2;
  for(i=1;i<=spc_len-8;i++) // 8 characters for printing module id
  fprintf(f1," ");    
  fprintf(f1,"%s", d_acc_entity_name.arr);
  for(i=1;i<=spc_len-18;i++) 
  fprintf(f1," ");
  fprintf(f1,"%s", d_sysdate.arr);
  // changed upto here ML_SD-SCF-1850
  ****************************END COMMENTS*****/
  /**********************Added by babu for globalization****************************/
	  fprintf(f1,"\n");
	  memset(hdr_line1,' ',REP_WIDTH+1);
        strncpy(hdr_line1,"MDL:RL",6);
        col = (int)(REP_WIDTH - strlen(d_acc_entity_name.arr))/2;
        strncpy(hdr_line1 + col -1,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//------Commented aginst leap year date problem in thai
				//t_date:=GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				//------Added aginst leap year date problem in thai
				:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
				END;
			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 14;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert\
_datetime_2t ( SYSDATE , :language_id ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )856;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
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
		strcpy(hdr_line1+col,d_sysdate1.arr);

fprintf(f1,hdr_line1);
/**********************end by babu for globalization****************************/  

fprintf(f1,"\n");
/***********commented by babu for globalization
 fprintf(f1,"OPR : %-15.15s", d_user.arr);
 //fprintf(f1,"                 INFECTION REPORT                                        ");ML_SD-SCF-1850 
   fprintf(f1,"                                     INFECTION REPORT                                            ");
  fprintf(f1,"Page : %4d", page_no);
 fprintf(f1,"\n");
******************End Globalization******************************************/

/**********ADDED BY BABU FOR GLOBALIZATION******************************/

  memset(hdr_line2,' ',REP_WIDTH+1);
  strncpy(hdr_line2,"OPR:",4);
  strncpy(hdr_line2+4,d_user.arr,strlen(d_user.arr));
  strcpy(rep_title1, local_legend[8] );
  col = (int)(REP_WIDTH-strlen(rep_title1))/2;
  strncpy(hdr_line2+col,rep_title1,strlen(rep_title1));
  sprintf(buf,"%s : %4d",local_legend[1],page_no);
  strcpy(hdr_line2+(REP_WIDTH-strlen(buf)),buf);
  fprintf(f1,hdr_line2);
  fprintf(f1,"\n");
 /*************END BABU*******************************/
 /*****************COMMENTED BY BABU FOR GLOBALIZATION
 //fprintf(f1,"REP : RLREPIDM                 ");ML_SD-SCF-1850
   fprintf(f1,"REP : RLREPIDM                                  ");
 fprintf(f1,"FOR THE PERIOD %10s - %10s\n",nd_fr_process_date_desc,
					   nd_to_process_date_desc); 
 fprintf(f1,"\n");
 *****************END GLOBALIZATION*****************/
 /*************ADDED BY BABU FOR GLOBALIZATION**********/
    memset(hdr_line3,' ',REP_WIDTH+1);
    strncpy(hdr_line3,"REP : RLREPIDM",14);
   	sprintf(buf,"%s %-10.10s - %-10.10s",local_legend[9],nd_fr_process_date1.arr,nd_to_process_date1.arr); 
    col = (int)(REP_WIDTH-strlen(buf))/2;
    strcpy(hdr_line3+col,buf);
	fprintf(f1,hdr_line3);
	fprintf(f1,"\n");
  /***************END GLOBALIZATION***************/
 
 
 fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"----------------------------------------------------------------");
 fprintf(f1,"\n");

 line_no += 6; // 05.09.2005

}


/* print the heading */
void print_col_heading()
{

 /* line 1 */
fprintf(f1,"%-10.10s           <----------------%-7.7s--------------->   ",local_legend[10],local_legend[11]);
fprintf(f1,"%-6.6s    %-3.3s  %-8.8s      %-8.8s    %-15.15s\n",local_legend[12],local_legend[13],local_legend[14],local_legend[15],local_legend[16]);
//fprintf(f1,"%-78.78sTEST   ORGANISM  ANTIBIOTIC\n"," ");
fprintf(f1,"%-78.78s\n"," ");
 /* line 2 */
fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"----------------------------------------------------------------");
 fprintf(f1,"\n");

 line_no += 3; // 05.09.2005

}

/*--------------------------------------------------------------------------*/
gen_file_name()
{
     /*nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
     EXEC SQL SELECT 
	          LOWER(USER)
	          INTO   :nd_user
	          FROM   RL_PARAM;

     if (OERROR)
         err_mesg("Fetch failed on table RL_PARAM",0,"");
      
     nd_file_no.arr[nd_file_no.len] = '\0';
     nd_user.arr[nd_user.len] = '\0';
     sprintf(nd_file_name.arr,"rlrepidm_%s.lis",nd_file_no.arr);*/

   	 /* For a constant file name (4 lines)  */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_file_name.arr,"rlrepidm.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);
	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
       disp_message(ERR_MESG,string_var) ;
	   proc_exit();
     }

}

/* to print the header page for the report */
void print_rep_header()
{
  char nd_fr_process_date_desc[11],
       nd_to_process_date_desc[11];

  char nd_source_desc[11];
  char nd_organism_desc[11];
  
  char nd_fr_specimen_desc[21],
       nd_to_specimen_desc[21];

  char nd_test_desc[11];
 
  if(strcmp(nd_fr_process_date.arr, "01/01/1800") == 0)
    /*strcpy(nd_fr_process_date_desc, local_legend[27]);  -- Commented & Added by Durai Rajkumar against IN009477 on 03-Apr-09 */ 
    strcpy(nd_fr_process_date1.arr, local_legend[27]);
	else 
	  //Added by babu for globalization
		/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				
				//------Commented aginst leap year date problem in thai
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_fr_process_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:nd_fr_process_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				//------Added aginst leap year date problem in thai
				:nd_fr_process_date1 :=sm_convert_datetime_2t(to_date(:nd_fr_process_date,'DD/MM/YYYY HH24:MI'),:language_id);

				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :nd_fr_process_date1 := sm_conv\
ert_datetime_2t ( to_date ( :nd_fr_process_date , 'DD/MM/YYYY HH24:MI' ) , :la\
nguage_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )879;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_fr_process_date1;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fr_process_date;
  sqlstm.sqhstl[1] = (unsigned int  )13;
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



		//End
  
	strcpy(nd_fr_process_date_desc, nd_fr_process_date1.arr);

  if(strcmp(nd_to_process_date.arr, "31/12/4712") == 0)
    /*strcpy(nd_to_process_date_desc, local_legend[28]);   -- Commented & Added by Durai Rajkumar against IN009477 on 03-Apr-09 */
    strcpy(nd_to_process_date1.arr, local_legend[28]);
	else 
	//Added by babu for globalization
		/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//------Commented aginst leap year date problem in thai
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_to_process_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:nd_to_process_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				//------Added aginst leap year date problem in thai
				:nd_to_process_date1 :=sm_convert_datetime_2t(to_date(:nd_to_process_date,'DD/MM/YYYY HH24:MI'),:language_id);
				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :nd_to_process_date1 := sm_conv\
ert_datetime_2t ( to_date ( :nd_to_process_date , 'DD/MM/YYYY HH24:MI' ) , :la\
nguage_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )906;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_to_process_date1;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_process_date;
  sqlstm.sqhstl[1] = (unsigned int  )13;
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



		//End
	
	strcpy(nd_to_process_date_desc, nd_to_process_date1.arr);

  if (strlen(nd_fr_specimen_no.arr) == 0)
     strcpy(nd_fr_specimen_desc, local_legend[29]);
  else
     strcpy(nd_fr_specimen_desc, nd_fr_specimen_no.arr);

  if (strlen(nd_to_specimen_no.arr) == 0)
     strcpy(nd_to_specimen_desc, local_legend[29]);
  else
     strcpy(nd_to_specimen_desc, nd_to_specimen_no.arr);

  if(strlen(nd_test_code.arr) == 0)
      strcpy(nd_test_desc, local_legend[29]);
    else strcpy(nd_test_desc,nd_test_code.arr);

  if(strlen(nd_source_code.arr) == 0)
      strcpy(nd_source_desc, local_legend[29]);
    else strcpy(nd_source_desc,nd_source_code.arr);

  if(strlen(nd_organism_code.arr) == 0)
      strcpy(nd_organism_desc, local_legend[29]);
    else strcpy(nd_organism_desc,nd_organism_code.arr);

  #ifdef DEBUG
      printf("before report header()\n");
  #endif
  page_no++;
  print_page_header();

  #ifdef DEBUG
      printf("after page header()\n");
  #endif

  get_version_no();   ///// added 01.07.2003

//////// 01.07.2003  fprintf(f1,VER);

  fprintf(f1,"%s\n",d_version.arr);

  fprintf(f1,"\n\n\n\n");
  
  /***************commented by babu for globalization
  fprintf(f1,"        ");
  fprintf(f1,"INPUT PARAMETERS :\n");
  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  fprintf(f1,"                ");
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  fprintf(f1,"DATE FROM         : %s\n", nd_fr_process_date_desc);
  fprintf(f1,"                ");
  fprintf(f1,"     TO           : %s\n", nd_to_process_date_desc); 
  fprintf(f1,"                ");
  fprintf(f1,"SPECIMEN FROM     : %s\n", nd_fr_specimen_desc);
  fprintf(f1,"                ");
  fprintf(f1,"         TO       : %s\n", nd_to_specimen_desc); 
  fprintf(f1,"                ");
  fprintf(f1,"SOURCE CODE       : %s\n", nd_source_desc);
  fprintf(f1,"                ");
  fprintf(f1,"TEST CODE         : %s\n", nd_test_desc);
  fprintf(f1,"                ");
  fprintf(f1,"ORGANISM CODE     : %s\n\n\n\n\n\n", nd_organism_desc);
  fprintf(f1,"                S - Sensitive\n");
  fprintf(f1,"                R - Resistant\n");
  fprintf(f1,"                I - Intermediate\n");
  
**********************END***************************/

/******************Added by babu for globalization*********************/
  
  
  rec_len = strlen(local_legend[17]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s :\n",local_legend[17]);
  print_space(40, rec_len,1);//added for globalisation
  print_space(40, rec_len,0);//added for globalisation
  fprintf(f1,"\n");
  rec_len = strlen(local_legend[18]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n",local_legend[18],nd_fr_process_date_desc);
  rec_len = strlen(local_legend[19]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n",local_legend[19],nd_to_process_date_desc);
  rec_len = strlen(local_legend[20]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n",local_legend[20],nd_fr_specimen_desc);
  rec_len = strlen(local_legend[19]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n",local_legend[19],nd_to_specimen_desc);
  rec_len = strlen(local_legend[21]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n",local_legend[21],nd_source_desc);
  rec_len = strlen(local_legend[22]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n",local_legend[22],nd_test_desc);
  rec_len = strlen(local_legend[23]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n",local_legend[23],nd_organism_desc);
  fprintf(f1,"\n\n\n\n\n");
  rec_len = strlen(local_legend[23]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"S - %s\n",local_legend[24]);
  rec_len = strlen(local_legend[23]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"R - %s\n",local_legend[25]);
  rec_len = strlen(local_legend[23]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"I - %s\n",local_legend[26]);
   print_space(40, rec_len,1);//added for globalisation
   if(strcmp(rl_func_ctl.arr,"Y")==0)/*Added by Nandhini against ML-MMOH-CRF-576*/
    fprintf(f1,"D - %s\n",local_legend[32]);/*---Added by Nandhini against ML-MMOH-CRF-576*/
  /************************END************************************/
fprintf(f1,"");

}

/*--------------------------------------------------------------------------*/
/******************** COMMENTED SINCE THIS IS NOT GETTING CALLING ANY WHERE
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
*********************/
/*--------------------------------------------------------------------------*/
/**********PRINT SPACE*************/
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
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )933;
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
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )952;
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


#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
