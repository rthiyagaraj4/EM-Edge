
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRUPDWK.pc"
};


static unsigned int sqlctx = 1288616547;


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
            void  *sqhstv[76];
   unsigned int   sqhstl[76];
            int   sqhsts[76];
            void  *sqindv[76];
            int   sqinds[76];
   unsigned int   sqharm[76];
   unsigned int   *sqharc[76];
   unsigned short  sqadto[76];
   unsigned short  sqtdso[76];
} sqlstm = {12,76};

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
"select TEST_CODE ,SEQ_NO  from RL_WORKLIST_FMT_DTL where ((OPERATING_FACILIT\
Y_ID=:b0 and SECTION_CODE=:b1) and WORKLIST_NAME=:b2) order by SEQ_NO         \
   ";

 static const char *sq0011 = 
"select WORKLIST_CUP_NO ,WORKLIST_CUP_INDICATOR ,SPECIMEN_NO ,PATIENT_ID ,(((\
(((((((((((((((((((((NVL(TEST_1_YN,' ')||NVL(TEST_2_YN,' '))||NVL(TEST_3_YN,' \
'))||NVL(TEST_4_YN,' '))||NVL(TEST_5_YN,' '))||NVL(TEST_6_YN,' '))||NVL(TEST_7\
_YN,' '))||NVL(TEST_8_YN,' '))||NVL(TEST_9_YN,' '))||NVL(TEST_10_YN,' '))||NVL\
(TEST_11_YN,' '))||NVL(TEST_12_YN,' '))||NVL(TEST_13_YN,' '))||NVL(TEST_14_YN,\
' '))||NVL(TEST_15_YN,' '))||NVL(TEST_16_YN,' '))||NVL(TEST_17_YN,' '))||NVL(T\
EST_18_YN,' '))||NVL(TEST_19_YN,' '))||NVL(TEST_20_YN,' '))||NVL(TEST_21_YN,' \
'))||NVL(TEST_22_YN,' '))||NVL(TEST_23_YN,' '))||NVL(TEST_24_YN,' '))||NVL(TES\
T_25_YN,' '))  from RL_WORKLIST_DTL where ((((OPERATING_FACILITY_ID=:b0 and SE\
CTION_CODE=:b1) and WORKLIST_NAME=:b2) and WORKLIST_NO=:b3) and WORKLIST_DATE=\
TO_DATE(:b4,'DD/MM/YYYY')) order by WORKLIST_CUP_NO            ";

 static const char *sq0013 = 
"select TEST_CODE  from RL_TEST_code where TEST_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,191,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,208,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,214,0,0,0,0,0,1,0,
66,0,0,4,180,0,4,227,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,1,9,
0,0,1,9,0,0,
109,0,0,5,91,0,2,251,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
132,0,0,6,0,0,32,259,0,0,0,0,0,1,0,
147,0,0,7,190,0,4,269,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
178,0,0,8,0,0,32,287,0,0,0,0,0,1,0,
193,0,0,10,0,0,32,312,0,0,0,0,0,1,0,
208,0,0,12,0,0,32,363,0,0,0,0,0,1,0,
223,0,0,14,0,0,32,387,0,0,0,0,0,1,0,
238,0,0,9,157,0,9,532,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
265,0,0,15,0,0,32,537,0,0,0,0,0,1,0,
280,0,0,11,841,0,9,547,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
315,0,0,16,0,0,32,552,0,0,0,0,0,1,0,
330,0,0,13,66,0,9,563,0,0,1,1,0,1,0,1,1,0,0,
349,0,0,17,0,0,32,568,0,0,0,0,0,1,0,
364,0,0,13,0,0,15,578,0,0,0,0,0,1,0,
379,0,0,18,0,0,32,583,0,0,0,0,0,1,0,
394,0,0,9,0,0,13,599,0,0,2,0,0,1,0,2,9,0,0,2,3,0,0,
417,0,0,19,0,0,32,613,0,0,0,0,0,1,0,
432,0,0,11,0,0,13,635,0,0,5,0,0,1,0,2,3,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
467,0,0,20,0,0,32,653,0,0,0,0,0,1,0,
482,0,0,13,0,0,13,672,0,0,1,0,0,1,0,2,9,0,0,
501,0,0,21,0,0,32,684,0,0,0,0,0,1,0,
516,0,0,22,204,0,4,703,0,0,8,4,0,1,0,2,1,0,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
563,0,0,23,0,0,32,724,0,0,0,0,0,1,0,
578,0,0,24,72,0,4,737,0,0,2,1,0,1,0,2,1,0,0,1,9,0,0,
601,0,0,25,0,0,32,746,0,0,0,0,0,1,0,
616,0,0,26,277,0,4,837,0,0,8,7,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,
9,0,0,1,3,0,0,1,9,0,0,
663,0,0,27,2146,0,5,853,0,0,76,76,0,1,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,
0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,
0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,
1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,
0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,
0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,
1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
1,9,0,0,1,1,0,0,1,9,0,0,
982,0,0,28,0,0,29,932,0,0,0,0,0,1,0,
997,0,0,29,0,0,32,937,0,0,0,0,0,1,0,
1012,0,0,30,131,0,4,947,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	         : rlrupdwk.pc
   Author        : Sheelvant   
   Date Created  : 07/03/1998
   Last Modified : 07/03/1998

*  Ver 1.10.01
   
*  Purpose : To Update Numeric Result of all the test that are in
	     WORKLIST DETAIL from RL_TEST_RESULT Table. Called from
	     Form rltreswl before calling result entry by specimen form
            
*  Input Parameters :  
                      Command line inputs
		              1. Usr_id/Password
                      2. Session id
		              3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4. Section Code                                   
                      5. Worklist_name                                  
                      6. Worklist Number                                
                      7. Worklist Date                                  
  
*  Table Accessed : RL_WORKLIST_FMT_DTL,RL_TEST_RESULT,
		    RL_WORKLIST_DTL

*****************************************************************************/  

#include <stdio.h>
#include <string.h>
#include <math.h>
#include "gl.h"

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define INIT_MESG "Fetching Worklist..."
#define VER  "VER : 1.10.01\n"
#define ONLINE_PRINTING 1
    
/*
#define DEBUG 
*/

    

/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR   nd_operating_facility_id     [3],
	          uid_pwd                      [91],

        /o from RL_WORKLIST_FMT_DTL o/
		d_worklist_test_code	[11],

        /o from RL_WORKLIST_DTL o/
		d_specimen_no    	[21],
		d_patient_id    	[21],
        d_req_test_yn       [26],
		d_rowid           	[61],


            /o from RL_TEST_RESULT o/     
		d_num_result            [16],
		d_res_comment           [6],

            /o from RL_QC_MATERIAL_TEST o/
		d_qc_test_code		[11],

                /o Dummy Variable o/     
	        d_req_test_code  	[11],
	        d_numeric_result_1      [16],
	        d_numeric_result_2      [16],
	        d_numeric_result_3      [16],
	        d_numeric_result_4      [16],
	        d_numeric_result_5      [16],
	        d_numeric_result_6      [16],
	        d_numeric_result_7      [16],
	        d_numeric_result_8      [16],
	        d_numeric_result_9      [16],
	        d_numeric_result_10     [16],
	        d_numeric_result_11     [16],
	        d_numeric_result_12     [16],
	        d_numeric_result_13     [16],
	        d_numeric_result_14     [16],
	        d_numeric_result_15     [16],
	        d_numeric_result_16     [16],
	        d_numeric_result_17     [16],
	        d_numeric_result_18     [16],
	        d_numeric_result_19     [16],
	        d_numeric_result_20     [16],
	        d_numeric_result_21     [16],
	        d_numeric_result_22     [16],
	        d_numeric_result_23     [16],
	        d_numeric_result_24     [16],
	        d_numeric_result_25     [16],

		
		/o input parameters to main() o/
        nd_session_id  [21],
		nd_pgm_date	   [20],

		/o******* parameters from SY_PROG_PARAM table **********o/
		nd_section_code    	[2],
		nd_worklist_name   	[11],
		nd_worklist_date   	[11],

               /o variable for cursor o/
		nd_cur_specimen_no      [21],
		nd_cur_patient_id       [21],

	       /o for header routine o/
	       //d_acc_entity_name         [41],
			d_acc_entity_name         [300],
	       d_user                    [31],
	       d_sysdate                 [20],
		   d_test_code				 [15]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[11]; } d_worklist_test_code;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[26]; } d_req_test_yn;

struct { unsigned short len; unsigned char arr[61]; } d_rowid;

struct { unsigned short len; unsigned char arr[16]; } d_num_result;

struct { unsigned short len; unsigned char arr[6]; } d_res_comment;

struct { unsigned short len; unsigned char arr[11]; } d_qc_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_req_test_code;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_1;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_2;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_3;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_4;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_5;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_6;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_7;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_8;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_9;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_10;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_11;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_12;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_13;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_14;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_15;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_16;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_17;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_18;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_19;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_20;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_21;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_22;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_23;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_24;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_25;

struct { unsigned short len; unsigned char arr[21]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[2]; } nd_section_code;

struct { unsigned short len; unsigned char arr[11]; } nd_worklist_name;

struct { unsigned short len; unsigned char arr[11]; } nd_worklist_date;

struct { unsigned short len; unsigned char arr[21]; } nd_cur_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_cur_patient_id;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[15]; } d_test_code;


/* Fields from table SY_PROG_PARAM*/                          
int  		nd_worklist_no;

/* Fields from table RL_WORKLIST_FMT_DTL */                          
int  		d_seq_no;                                       

/* Fields from table RL_WORKLIST_DTL */                          
int			v_count = 0;
int  		d_cup_no;                                       
char 		d_cup_ind, d_num_prefix,d_result_status;
  
/* Fields from table RL_TEST_CODE */                          
char 		d_num_result_yn;          
  
/* Dummy Fields  */                                                  
int  		ic,no_of_test;                                       
int  		line_no,page_no;                                       
char 		cup_ind;                                  
char		nd_qc_code;

char      num_prefix[30];
char      result_status[30];
char      num_result[30][16];

int l_count = 0;

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

int       rec_inserted;
int       specimen_over;
char      worklist_test[26][11];
char	  string_var[300];
//char      g_facility_id[50];

/*FILE *f1;*/

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
        dclr_worklist_dtl_cur(),
  	dclr_wrklst_specimen_cur(),
        dclr_qc_matl_test_cur(),
  	do_report();
 
   if(argc < 4) {
     disp_message(ERR_MESG,"Usage rlrupdwk uid/passwd session_id pgm_date\n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   //strcpy(g_facility_id, ' ');


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

   get_params();

   dclr_worklist_dtl_cur();
   dclr_wrklst_specimen_cur();

   /*dclr_qc_matl_test_cur();*/
   
   get_header_dtls();

   do_report();


   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
   if (sqlca.sqlcode < 0) goto err_exit;
}



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
   sqlstm.offset = (unsigned int  )51;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at main() occured....\n");
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
		   PARAM4
            INTO 
		:nd_operating_facility_id,
		:nd_section_code ,  
		:nd_worklist_name,  
		:nd_worklist_no  ,
		:nd_worklist_date
        FROM SY_PROG_PARAM
	    WHERE   PGM_ID = 'RLRUPDWK'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 into :b0,:b1,:b2,:b3,:b4  from SY_PROG_PARAM where ((PGM_ID='RLRUPDWK' and \
SESSION_ID=TO_NUMBER(:b5)) and PGM_DATE=:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_worklist_no;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_worklist_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[6] = (unsigned int  )22;
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




  nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
  nd_section_code.arr[nd_section_code.len] 			    = '\0';
  nd_worklist_name.arr[nd_worklist_name.len] 			= '\0';
  nd_worklist_date.arr[nd_worklist_date.len] 			= '\0';

  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE PGM_ID = 'RLRUPDWK'
	         AND SESSION_ID = :nd_session_id
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='RLRUPDWK' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )109;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )132;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at get_params() occured....\n");
   proc_exit();
}
 

/* get the header details */
void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(LPAD(ACC_ENTITY_NAME,
	   TRUNC(15 + 0.5*LENGTH(ACC_ENTITY_NAME))),1,30),
	   USER,
	   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
       INTO :d_acc_entity_name,
	   :d_user,
	   :d_sysdate
         FROM SY_ACC_ENTITY
         WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(LPAD(ACC_ENTITY_NAME,TRUNC((15+(0.5* LENGTH(\
ACC_ENTITY_NAME))))),1,30) ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') into :\
b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )147;
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
   sqlstm.sqhstl[2] = (unsigned int  )22;
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



  d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
  d_user.arr[d_user.len]                       = '\0';
  d_sysdate.arr[d_sysdate.len]                 = '\0';

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
   sqlstm.offset = (unsigned int  )178;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}
 

/* function declares cursor RL_WORKLIST_FMT_DTL */
void dclr_worklist_dtl_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE WORKLIST_DTL_CUR CURSOR FOR
         SELECT TEST_CODE,              
         	SEQ_NO
         FROM   RL_WORKLIST_FMT_DTL                        
         WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND SECTION_CODE = :nd_section_code
	     AND WORKLIST_NAME = :nd_worklist_name              
         ORDER BY SEQ_NO ; */ 
                                     



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
   sqlstm.offset = (unsigned int  )193;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at dclr_worklist_dtl_cur() occured....\n");
   proc_exit();
}

/* function declares cursor RL_WORKLIST_DTL */
void dclr_wrklst_specimen_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE WRKLST_SPECIMEN_CUR CURSOR FOR
         SELECT WORKLIST_CUP_NO,
		WORKLIST_CUP_INDICATOR,
		SPECIMEN_NO,
            PATIENT_ID,               
	    	NVL(TEST_1_YN,' ')||
	    	NVL(TEST_2_YN,' ')||
	    	NVL(TEST_3_YN,' ')||
	    	NVL(TEST_4_YN,' ')||
	    	NVL(TEST_5_YN,' ')||
	    	NVL(TEST_6_YN,' ')||
	    	NVL(TEST_7_YN,' ')||
	    	NVL(TEST_8_YN,' ')||
	    	NVL(TEST_9_YN,' ')||
	    	NVL(TEST_10_YN,' ')||
	    	NVL(TEST_11_YN,' ')||
	    	NVL(TEST_12_YN,' ')||
	   	    NVL(TEST_13_YN,' ')||
	    	NVL(TEST_14_YN,' ')||
	   	    NVL(TEST_15_YN,' ')||
	    	NVL(TEST_16_YN,' ')||
	    	NVL(TEST_17_YN,' ')||
	    	NVL(TEST_18_YN,' ')||
	    	NVL(TEST_19_YN,' ')||
	   	    NVL(TEST_20_YN,' ')||
	    	NVL(TEST_21_YN,' ')||
	    	NVL(TEST_22_YN,' ')||
	  	    NVL(TEST_23_YN,' ')||
	    	NVL(TEST_24_YN,' ')||
	    	NVL(TEST_25_YN,' ') 
         FROM   RL_WORKLIST_DTL                        
         WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND SECTION_CODE  = :nd_section_code 
		 AND WORKLIST_NAME = :nd_worklist_name 
		 AND WORKLIST_NO   = :nd_worklist_no 
		 AND WORKLIST_DATE = TO_DATE(:nd_worklist_date,'DD/MM/YYYY')
         ORDER BY WORKLIST_CUP_NO; */ 
                             

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
   sqlstm.offset = (unsigned int  )208;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at dclr_worklist_specimen_cur() occured....\n");
   proc_exit();
}



/* function declares cursor RL_QC_MATERIAL_TEST */
void dclr_qc_matl_test_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE QC_MATRL_TST_CUR CURSOR FOR
      SELECT TEST_CODE              
      FROM   RL_TEST_code                        
      WHERE  TEST_CODE       = :nd_qc_code  ; */ 
          

   /*  Done in Do Report   */
   /*EXEC SQL WHENEVER SQLERROR GOTO err_exit;
     EXEC SQL OPEN TRN_ITEMS_CUR; */

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
   sqlstm.offset = (unsigned int  )223;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at dclr_qc_dtl_cur() occured....\n");
   proc_exit();
}


/* prints the master-detail record until the cursor is empty */
void do_report()
{
  void open_wrklst_dtl_cursor();
  void open_wrklst_specimen_cursor();
  void open_qc_matrl_cursor();
  void close_qc_matrl_cursor();
  void initialize_worklist_array();
  void initialize_wrklst_specm_array();
  void get_result_dtls();
  void get_test_details();
  void upd_worklist_dtl();
  int fetch_wrklst_specimen_cur();
  int fetch_worklist_dtl_cur();
  int fetch_qc_matrl_cur();
  int still_wrk_test_left;
  int still_qc_left;
  int still_wrk_specimen_left;
  int rec_no;

    initialize_worklist_array();

    open_wrklst_dtl_cursor();
    open_wrklst_specimen_cursor();

    still_wrk_test_left = fetch_worklist_dtl_cur();

    no_of_test=0;
    while(still_wrk_test_left)    /* Worklist Test Details */
    {
      no_of_test+=1;
      strcpy(worklist_test[d_seq_no-1],d_worklist_test_code.arr);
  
	
      still_wrk_test_left = fetch_worklist_dtl_cur();
    }

  
    rec_inserted=1;
    specimen_over=1;
    still_wrk_specimen_left = fetch_wrklst_specimen_cur();


    while (still_wrk_specimen_left)
	{
      /* Check whether it is patient specimen or QC */
      if (d_cup_ind == 'P')
      {
	if(d_specimen_no.len != 0)
	{
         for (ic=0;ic<no_of_test;ic++)
         {
	   if (d_req_test_yn.arr[ic] == '\0') 
	      break;
           else
	   {
		 

// Newly added on 20/11/2002 to refresh the worklist 
//if the test is added from any other function
		 if (d_req_test_yn.arr[ic] == 'N') 
		 {
			d_test_code.arr[0]			= '\0';
			d_test_code.len				= 0;

			strcpy(d_test_code.arr, worklist_test[ic]);
			d_test_code.len = strlen(d_test_code.arr);

			check_test_ordered_yn();
		 }
// Upto here Newly added on 20/11/2002 to refresh the worklist 
//if the test is added from any other function

		
	     if (d_req_test_yn.arr[ic] != 'N') 
	     {

               strcpy(d_req_test_code.arr, worklist_test[ic]);
               d_req_test_code.len = strlen(d_req_test_code.arr);

              
	       get_test_details();
 
 /* Initialising so that the old values are not carried */
                 d_num_result.arr[0]    = '\0';
                 d_res_comment.arr[0]   = '\0';
                 d_num_result.len       = 0;
                 d_res_comment.len      = 0;

               get_result_dtls();

	       if (d_num_result_yn == 'Y')
	       {
				if (strlen(d_num_result.arr)) 
			    {
					num_prefix[ic]=d_num_prefix;
					strcpy(num_result[ic],d_num_result.arr);
                 }
		//		else
		//		{
		//			num_prefix[ic]=' ';
		//			strcpy(num_result[ic],d_res_comment.arr);
        //        }
           }
// comment is removed on 20/11/2002
/********** changed on 05/09/2002 for worklist all result components
	now the result comment will be in different field */
	       else
	       {
	         num_prefix[ic]=' ';
	         strcpy(num_result[ic],d_res_comment.arr);
           }
/********** upto here added on 05/09/2002 *****************/

	       result_status[ic]=d_result_status;

   	     }
	     else
	     {
	       num_prefix[ic]=' ';
	       result_status[ic]= 'N';
	       strcpy(num_result[ic],"     ");
   	     }
   	   }
   	 }
	 upd_worklist_dtl();
        }
      }
      initialize_wrklst_specm_array();
      still_wrk_specimen_left = fetch_wrklst_specimen_cur();
   } 
}



/*This Procedure to open Worklist Cursor */
void open_wrklst_dtl_cursor()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN WORKLIST_DTL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[2] = (unsigned int  )13;
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
   sqlstm.offset = (unsigned int  )265;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error while Opening work list dtl cur occured...\n");
  proc_exit();
}


/*This Procedure to open worklist Specimen Cursor */ 
void open_wrklst_specimen_cursor()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN WRKLST_SPECIMEN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )280;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_worklist_no;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_worklist_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
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
   sqlstm.offset = (unsigned int  )315;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error while Opening Wrklst Specimen Cur() occured....\n");
  proc_exit();
}



/*This Procedure to open QC Material Test Cursor */
void open_qc_matrl_cursor()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN QC_MATRL_TST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0013;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )330;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_qc_code;
   sqlstm.sqhstl[0] = (unsigned int  )1;
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
   sqlstm.offset = (unsigned int  )349;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error while Opening QC Matrl Cur() occured....\n");
  proc_exit();
}


/*This Procedure to Close QC Material Test Cursor */
void close_qc_matrl_cursor()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CLOSE QC_MATRL_TST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )364;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
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
   sqlstm.offset = (unsigned int  )379;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error while Close QC Matrl Cur() occured....\n");
  proc_exit();
}


/* fetches the next record from CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_worklist_dtl_cur()
{

  d_worklist_test_code.arr[0]                                   = '\0';
  d_worklist_test_code.len                                      = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH WORKLIST_DTL_CUR INTO
		:d_worklist_test_code,  
		:d_seq_no ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )394;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_worklist_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_seq_no;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
    return 0;


  d_worklist_test_code.arr[d_worklist_test_code .len]		= '\0';

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
   sqlstm.offset = (unsigned int  )417;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at fetch_wrklst_dtl_cur() occured....\n");
   proc_exit();

}

/* fetches the next record from CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_wrklst_specimen_cur()
{

  d_specimen_no.arr[0]		 			= '\0';
  d_patient_id.arr[0]		 			= '\0';
  d_req_test_yn.arr[0]		 			= '\0';

  d_specimen_no.len		 			= 0;
  d_patient_id.len                		    	= 0;
  d_req_test_yn.len                		    	= 0;


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH WRKLST_SPECIMEN_CUR INTO
		:d_cup_no,       
		:d_cup_ind,       
		:d_specimen_no,  
		:d_patient_id,
		:d_req_test_yn; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )432;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_cup_no;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_cup_ind;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_req_test_yn;
  sqlstm.sqhstl[4] = (unsigned int  )28;
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



  if (NODATAFOUND)
    return 0;

  d_specimen_no.arr[d_specimen_no.len]			= '\0';
  d_patient_id.arr[d_patient_id.len]			= '\0';
  d_req_test_yn.arr[d_req_test_yn.len]			= '\0';

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
   sqlstm.offset = (unsigned int  )467;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at fetch_wrklst_specimen_cur() occured....\n");
   proc_exit();

}



/* fetches the next record from QC Material Test CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_qc_matrl_cur()
{

  d_qc_test_code.arr[0]	 			= '\0';

  d_qc_test_code.len                            = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH QC_MATRL_TST_CUR INTO
		:d_qc_test_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )482;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_qc_test_code;
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



  if (NODATAFOUND)
    return 0;

  d_qc_test_code.arr[d_qc_test_code .len]	 		= '\0';

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
   sqlstm.offset = (unsigned int  )501;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at fetch_qc_matrl_cur() occured....\n");
   proc_exit();

}


/* get the numeric prefix and numeric result for the test code */
/* from RL_TEST_RESULT */
void get_result_dtls()
{
  d_num_result.arr[0]		 			= '\0';
  d_res_comment.arr[0]		 			= '\0';
  

  d_num_result.len	       	                        = 0;
  d_res_comment.len	       	                        = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT NUMERIC_PREFIX,                
		   NUMERIC_RESULT, 
		   RESULT_COMMENT_CODE1,
		   STATUS
	    INTO   :d_num_prefix,       
		   :d_num_result,
		   :d_res_comment ,
		   :d_result_status
            FROM   RL_TEST_RESULT 
	    WHERE PATIENT_ID  = :d_patient_id and
		  SPECIMEN_NO = :d_specimen_no
          AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND TEST_CODE   = :d_req_test_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NUMERIC_PREFIX ,NUMERIC_RESULT ,RESULT_COMMENT_CODE\
1 ,STATUS into :b0,:b1,:b2,:b3  from RL_TEST_RESULT where (((PATIENT_ID=:b4 an\
d SPECIMEN_NO=:b5) and OPERATING_FACILITY_ID=:b6) and TEST_CODE=:b7)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )516;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_num_prefix;
   sqlstm.sqhstl[0] = (unsigned int  )1;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_num_result;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_res_comment;
   sqlstm.sqhstl[2] = (unsigned int  )8;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_result_status;
   sqlstm.sqhstl[3] = (unsigned int  )1;
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
   sqlstm.sqhstv[7] = (         void  *)&d_req_test_code;
   sqlstm.sqhstl[7] = (unsigned int  )13;
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



  d_num_result.arr[d_num_result.len] 		= '\0';
  d_res_comment.arr[d_res_comment.len] 		= '\0';

  return;

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
   sqlstm.offset = (unsigned int  )563;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at get_result_dtls() occured....\n");
   proc_exit();
}
 


/* get NUMERIC_RESULT_YN  from RL_TEST_CODE  */
void get_test_details()
{
   d_num_result_yn=' ';

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT NUMERIC_RESULT_YN              
	        INTO   :d_num_result_yn     
            FROM   RL_TEST_CODE   
	        WHERE  TEST_CODE   = :d_req_test_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NUMERIC_RESULT_YN into :b0  from RL_TEST_CODE where\
 TEST_CODE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )578;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_num_result_yn;
   sqlstm.sqhstl[0] = (unsigned int  )1;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_req_test_code;
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



  return;

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
   sqlstm.offset = (unsigned int  )601;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at get_test_details() occured....\n");
   proc_exit();
}
 



/* to initialize worklist array with some default value */
void initialize_worklist_array()
{
  int    i;

  for (i=0;i<25;i++)
  {
    strcpy(worklist_test[i], "     ");
  }

}


/* to initialize worklist specimen_array with some default value */
void initialize_wrklst_specm_array()
{
  int    i;

  for (i=0;i<25;i++)
  {
    strcpy(num_result[i], "     ");
    num_prefix[i]=' ';
    result_status[i]=' ';
  }

}


/* UPDATE RL_WORKLIST_DTL */
void upd_worklist_dtl()    
{
  strcpy(d_numeric_result_1.arr,num_result[0]);
  d_numeric_result_1.len= strlen(d_numeric_result_1.arr);
  strcpy(d_numeric_result_2.arr,num_result[1]);
  d_numeric_result_2.len= strlen(d_numeric_result_2.arr) ;
  strcpy(d_numeric_result_3.arr,num_result[2]);
  d_numeric_result_3.len = strlen(d_numeric_result_3.arr) ;
  strcpy(d_numeric_result_4.arr,num_result[3]);
  d_numeric_result_4.len = strlen(d_numeric_result_4.arr) ;
  strcpy(d_numeric_result_5.arr,num_result[4]);
  d_numeric_result_5.len = strlen(d_numeric_result_5.arr) ;
  strcpy(d_numeric_result_6.arr,num_result[5]);
  d_numeric_result_6.len = strlen(d_numeric_result_6.arr) ;
  strcpy(d_numeric_result_7.arr,num_result[6]);
  d_numeric_result_7.len = strlen(d_numeric_result_7.arr) ;
  strcpy(d_numeric_result_8.arr,num_result[7]);
  d_numeric_result_8.len = strlen(d_numeric_result_8.arr) ;
  strcpy(d_numeric_result_9.arr,num_result[8]);
  d_numeric_result_9.len = strlen(d_numeric_result_9.arr) ;
  strcpy(d_numeric_result_10.arr,num_result[9]);
  d_numeric_result_10.len = strlen(d_numeric_result_10.arr) ;
  strcpy(d_numeric_result_11.arr,num_result[10]);
  d_numeric_result_11.len = strlen(d_numeric_result_11.arr) ;
  strcpy(d_numeric_result_12.arr,num_result[11]);
  d_numeric_result_12.len = strlen(d_numeric_result_12.arr) ;
  strcpy(d_numeric_result_13.arr,num_result[12]);
  d_numeric_result_13.len = strlen(d_numeric_result_13.arr) ;
  strcpy(d_numeric_result_14.arr,num_result[13]);
  d_numeric_result_14.len = strlen(d_numeric_result_14.arr) ;
  strcpy(d_numeric_result_15.arr,num_result[14]);
  d_numeric_result_15.len = strlen(d_numeric_result_15.arr) ;
  strcpy(d_numeric_result_16.arr,num_result[15]);
  d_numeric_result_16.len = strlen(d_numeric_result_16.arr) ;
  strcpy(d_numeric_result_17.arr,num_result[16]);
  d_numeric_result_17.len = strlen(d_numeric_result_17.arr) ;
  strcpy(d_numeric_result_18.arr,num_result[17]);
  d_numeric_result_18.len = strlen(d_numeric_result_18.arr) ;
  strcpy(d_numeric_result_19.arr,num_result[18]);
  d_numeric_result_19.len = strlen(d_numeric_result_19.arr) ;
  strcpy(d_numeric_result_20.arr,num_result[19]);
  d_numeric_result_20.len = strlen(d_numeric_result_20.arr) ;
  strcpy(d_numeric_result_21.arr,num_result[20]);
  d_numeric_result_21.len = strlen(d_numeric_result_21.arr) ;
  strcpy(d_numeric_result_22.arr,num_result[21]);
  d_numeric_result_22.len = strlen(d_numeric_result_22.arr) ;
  strcpy(d_numeric_result_23.arr,num_result[22]);
  d_numeric_result_23.len = strlen(d_numeric_result_23.arr) ;
  strcpy(d_numeric_result_24.arr,num_result[23]);
  d_numeric_result_24.len = strlen(d_numeric_result_24.arr) ;
  strcpy(d_numeric_result_25.arr,num_result[24]);
  d_numeric_result_25.len = strlen(d_numeric_result_25.arr) ;

  /* EXEC SQL WHENEVER SQLERROR GO TO err_exit; */ 

  /* EXEC SQL SELECT rowid into :d_rowid   
	       FROM RL_WORKLIST_DTL
           WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		   AND SECTION_CODE  = :nd_section_code AND
		   WORKLIST_NAME = :nd_worklist_name AND
	  	   WORKLIST_NO   = :nd_worklist_no AND
           WORKLIST_DATE = TO_DATE(:nd_worklist_date,'DD/MM/YYYY') AND
		   WORKLIST_CUP_NO = :d_cup_no  AND
		   SPECIMEN_NO   = :d_specimen_no
           FOR UPDATE OF NUMERIC_1_PREFIX NOWAIT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select rowid into :b0  from RL_WORKLIST_DTL where ((((((OPE\
RATING_FACILITY_ID=:b1 and SECTION_CODE=:b2) and WORKLIST_NAME=:b3) and WORKLI\
ST_NO=:b4) and WORKLIST_DATE=TO_DATE(:b5,'DD/MM/YYYY')) and WORKLIST_CUP_NO=:b\
6) and SPECIMEN_NO=:b7) for update of NUMERIC_1_PREFIX nowait ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )616;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_rowid;
  sqlstm.sqhstl[0] = (unsigned int  )63;
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
  sqlstm.sqhstv[3] = (         void  *)&nd_worklist_name;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_worklist_no;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_worklist_date;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_cup_no;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[7] = (unsigned int  )23;
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



		  d_rowid.arr[d_rowid.len] = '\0';


  /* EXEC SQL WHENEVER SQLERROR GO TO err_exit; */ 


  /* EXEC SQL UPDATE RL_WORKLIST_DTL         
	   SET NUMERIC_1_PREFIX = substr(:num_prefix,1,1),
	       NUMERIC_1_RESULT = :d_numeric_result_1,    
	       TEST_1_YN        = substr(:result_status,1,1),
	       NUMERIC_2_PREFIX = substr(:num_prefix,2,1),
	       NUMERIC_2_RESULT = :d_numeric_result_2,    
	       TEST_2_YN        = substr(:result_status,2,1),
	       NUMERIC_3_PREFIX = substr(:num_prefix,3,1),
	       NUMERIC_3_RESULT = :d_numeric_result_3,    
	       TEST_3_YN        = substr(:result_status,3,1),
	       NUMERIC_4_PREFIX = substr(:num_prefix,4,1),
	       NUMERIC_4_RESULT = :d_numeric_result_4,    
	       TEST_4_YN        = substr(:result_status,4,1),
	       NUMERIC_5_PREFIX = substr(:num_prefix,5,1),
	       NUMERIC_5_RESULT = :d_numeric_result_5,    
	       TEST_5_YN        = substr(:result_status,5,1),
	       NUMERIC_6_PREFIX = substr(:num_prefix,6,1),
	       NUMERIC_6_RESULT = :d_numeric_result_6,    
	       TEST_6_YN        = substr(:result_status,6,1),
	       NUMERIC_7_PREFIX = substr(:num_prefix,7,1),
	       NUMERIC_7_RESULT = :d_numeric_result_7,    
	       TEST_7_YN        = substr(:result_status,7,1),
	       NUMERIC_8_PREFIX = substr(:num_prefix,8,1),
	       NUMERIC_8_RESULT = :d_numeric_result_8,    
	       TEST_8_YN        = substr(:result_status,8,1),
	       NUMERIC_9_PREFIX = substr(:num_prefix,9,1),
	       NUMERIC_9_RESULT = :d_numeric_result_9,    
	       TEST_9_YN        = substr(:result_status,9,1),
	       NUMERIC_10_PREFIX = substr(:num_prefix,10,1),
	       NUMERIC_10_RESULT = :d_numeric_result_10,    
	       TEST_10_YN        = substr(:result_status,10,1),
	       NUMERIC_11_PREFIX = substr(:num_prefix,11,1),
	       NUMERIC_11_RESULT = :d_numeric_result_11,    
	       TEST_11_YN        = substr(:result_status,11,1),
	       NUMERIC_12_PREFIX = substr(:num_prefix,12,1),
	       NUMERIC_12_RESULT = :d_numeric_result_12,    
	       TEST_12_YN        = substr(:result_status,12,1),
	       NUMERIC_13_PREFIX = substr(:num_prefix,13,1),
	       NUMERIC_13_RESULT = :d_numeric_result_13,    
	       TEST_13_YN        = substr(:result_status,13,1),
	       NUMERIC_14_PREFIX = substr(:num_prefix,14,1),
	       NUMERIC_14_RESULT = :d_numeric_result_14,    
	       TEST_14_YN        = substr(:result_status,14,1),
	       NUMERIC_15_PREFIX = substr(:num_prefix,15,1),
	       NUMERIC_15_RESULT = :d_numeric_result_15,    
	       TEST_15_YN        = substr(:result_status,15,1),
	       NUMERIC_16_PREFIX = substr(:num_prefix,16,1),
	       NUMERIC_16_RESULT = :d_numeric_result_16,    
	       TEST_16_YN        = substr(:result_status,16,1),
	       NUMERIC_17_PREFIX = substr(:num_prefix,17,1),
	       NUMERIC_17_RESULT = :d_numeric_result_17,    
	       TEST_17_YN        = substr(:result_status,17,1),
	       NUMERIC_18_PREFIX = substr(:num_prefix,18,1),
	       NUMERIC_18_RESULT = :d_numeric_result_18,    
	       TEST_18_YN        = substr(:result_status,18,1),
	       NUMERIC_19_PREFIX = substr(:num_prefix,19,1),
	       NUMERIC_19_RESULT = :d_numeric_result_19,    
	       TEST_19_YN        = substr(:result_status,19,1),
	       NUMERIC_20_PREFIX = substr(:num_prefix,20,1),
	       NUMERIC_20_RESULT = :d_numeric_result_20,    
	       TEST_20_YN        = substr(:result_status,20,1),
	       NUMERIC_21_PREFIX = substr(:num_prefix,21,1),
	       NUMERIC_21_RESULT = :d_numeric_result_21,    
	       TEST_21_YN        = substr(:result_status,21,1),
	       NUMERIC_22_PREFIX = substr(:num_prefix,22,1),
	       NUMERIC_22_RESULT = :d_numeric_result_22,    
	       TEST_22_YN        = substr(:result_status,22,1),
	       NUMERIC_23_PREFIX = substr(:num_prefix,23,1),
	       NUMERIC_23_RESULT = :d_numeric_result_23,    
	       TEST_23_YN        = substr(:result_status,23,1),
	       NUMERIC_24_PREFIX = substr(:num_prefix,24,1),
	       NUMERIC_24_RESULT = :d_numeric_result_24,    
	       TEST_24_YN        = substr(:result_status,24,1),
	       NUMERIC_25_PREFIX = substr(:num_prefix,25,1),
	       NUMERIC_25_RESULT = :d_numeric_result_25,   
	       TEST_25_YN        = substr(:result_status,25,1)
           WHERE rowid = :d_rowid; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 76;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "update RL_WORKLIST_DTL  set NUMERIC_1_PREFIX=substr(:b0,1,1),NUMERIC_1_\
RESULT=:b1,TEST_1_YN=substr(:b2,1,1),NUMERIC_2_PREFIX=substr(:b0,2,1),NUMERI\
C_2_RESULT=:b4,TEST_2_YN=substr(:b2,2,1),NUMERIC_3_PREFIX=substr(:b0,3,1),NU\
MERIC_3_RESULT=:b7,TEST_3_YN=substr(:b2,3,1),NUMERIC_4_PREFIX=substr(:b0,4,1\
),NUMERIC_4_RESULT=:b10,TEST_4_YN=substr(:b2,4,1),NUMERIC_5_PREFIX=substr(:b\
0,5,1),NUMERIC_5_RESULT=:b13,TEST_5_YN=substr(:b2,5,1),NUMERIC_6_PREFIX=subs\
tr(:b0,6,1),NUMERIC_6_RESULT=:b16,TEST_6_YN=substr(:b2,6,1),NUMERIC_7_PREFIX\
=substr(:b0,7,1),NUMERIC_7_RESULT=:b19,TEST_7_YN=substr(:b2,7,1),NUMERIC_8_P\
REFIX=substr(:b0,8,1),NUMERIC_8_RESULT=:b22,TEST_8_YN=substr(:b2,8,1),NUMERI\
C_9_PREFIX=substr(:b0,9,1),NUMERIC_9_RESULT=:b25,TEST_9_YN=substr(:b2,9,1),N\
UMERIC_10_PREFIX=substr(:b0,10,1),NUMERIC_10_RESULT=:b28,TEST_10_YN=substr(:\
b2,10,1),NUMERIC_11_PREFIX=substr(:b0,11,1),NUMERIC_11_RESULT=:b31,TEST_11_Y\
N=substr(:b2,11,1),NUMERIC_12_PREFIX=substr(:b0,12,1),NUMERIC_12_RESULT=:b34\
,TEST_12_YN=substr(:b2,12,1),NUMERIC_13_P");
  sqlbuft((void **)0, 
    "REFIX=substr(:b0,13,1),NUMERIC_13_RESULT=:b37,TEST_13_YN=substr(:b2,13,\
1),NUMERIC_14_PREFIX=substr(:b0,14,1),NUMERIC_14_RESULT=:b40,TEST_14_YN=subs\
tr(:b2,14,1),NUMERIC_15_PREFIX=substr(:b0,15,1),NUMERIC_15_RESULT=:b43,TEST_\
15_YN=substr(:b2,15,1),NUMERIC_16_PREFIX=substr(:b0,16,1),NUMERIC_16_RESULT=\
:b46,TEST_16_YN=substr(:b2,16,1),NUMERIC_17_PREFIX=substr(:b0,17,1),NUMERIC_\
17_RESULT=:b49,TEST_17_YN=substr(:b2,17,1),NUMERIC_18_PREFIX=substr(:b0,18,1\
),NUMERIC_18_RESULT=:b52,TEST_18_YN=substr(:b2,18,1),NUMERIC_19_PREFIX=subst\
r(:b0,19,1),NUMERIC_19_RESULT=:b55,TEST_19_YN=substr(:b2,19,1),NUMERIC_20_PR\
EFIX=substr(:b0,20,1),NUMERIC_20_RESULT=:b58,TEST_20_YN=substr(:b2,20,1),NUM\
ERIC_21_PREFIX=substr(:b0,21,1),NUMERIC_21_RESULT=:b61,TEST_21_YN=substr(:b2\
,21,1),NUMERIC_22_PREFIX=substr(:b0,22,1),NUMERIC_22_RESULT=:b64,TEST_22_YN=\
substr(:b2,22,1),NUMERIC_23_PREFIX=substr(:b0,23,1),NUMERIC_23_RESULT=:b67,T\
EST_23_YN=substr(:b2,23,1),NUMERIC_24_PREFIX=substr(:b0,24,1),NUMERIC_24_RES\
ULT=:b70,TEST_24_YN=substr(:b2,24,1),NUME");
  sqlstm.stmt = "RIC_25_PREFIX=substr(:b0,25,1),NUMERIC_25_RESULT=:b73,TEST_\
25_YN=substr(:b2,25,1) where rowid=:b75";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )663;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)num_prefix;
  sqlstm.sqhstl[0] = (unsigned int  )30;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_numeric_result_1;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)result_status;
  sqlstm.sqhstl[2] = (unsigned int  )30;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)num_prefix;
  sqlstm.sqhstl[3] = (unsigned int  )30;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_numeric_result_2;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)result_status;
  sqlstm.sqhstl[5] = (unsigned int  )30;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)num_prefix;
  sqlstm.sqhstl[6] = (unsigned int  )30;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_numeric_result_3;
  sqlstm.sqhstl[7] = (unsigned int  )18;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)result_status;
  sqlstm.sqhstl[8] = (unsigned int  )30;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)num_prefix;
  sqlstm.sqhstl[9] = (unsigned int  )30;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_numeric_result_4;
  sqlstm.sqhstl[10] = (unsigned int  )18;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)result_status;
  sqlstm.sqhstl[11] = (unsigned int  )30;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)num_prefix;
  sqlstm.sqhstl[12] = (unsigned int  )30;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_numeric_result_5;
  sqlstm.sqhstl[13] = (unsigned int  )18;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)result_status;
  sqlstm.sqhstl[14] = (unsigned int  )30;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)num_prefix;
  sqlstm.sqhstl[15] = (unsigned int  )30;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_numeric_result_6;
  sqlstm.sqhstl[16] = (unsigned int  )18;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)result_status;
  sqlstm.sqhstl[17] = (unsigned int  )30;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)num_prefix;
  sqlstm.sqhstl[18] = (unsigned int  )30;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&d_numeric_result_7;
  sqlstm.sqhstl[19] = (unsigned int  )18;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)result_status;
  sqlstm.sqhstl[20] = (unsigned int  )30;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqhstv[21] = (         void  *)num_prefix;
  sqlstm.sqhstl[21] = (unsigned int  )30;
  sqlstm.sqhsts[21] = (         int  )0;
  sqlstm.sqindv[21] = (         void  *)0;
  sqlstm.sqinds[21] = (         int  )0;
  sqlstm.sqharm[21] = (unsigned int  )0;
  sqlstm.sqadto[21] = (unsigned short )0;
  sqlstm.sqtdso[21] = (unsigned short )0;
  sqlstm.sqhstv[22] = (         void  *)&d_numeric_result_8;
  sqlstm.sqhstl[22] = (unsigned int  )18;
  sqlstm.sqhsts[22] = (         int  )0;
  sqlstm.sqindv[22] = (         void  *)0;
  sqlstm.sqinds[22] = (         int  )0;
  sqlstm.sqharm[22] = (unsigned int  )0;
  sqlstm.sqadto[22] = (unsigned short )0;
  sqlstm.sqtdso[22] = (unsigned short )0;
  sqlstm.sqhstv[23] = (         void  *)result_status;
  sqlstm.sqhstl[23] = (unsigned int  )30;
  sqlstm.sqhsts[23] = (         int  )0;
  sqlstm.sqindv[23] = (         void  *)0;
  sqlstm.sqinds[23] = (         int  )0;
  sqlstm.sqharm[23] = (unsigned int  )0;
  sqlstm.sqadto[23] = (unsigned short )0;
  sqlstm.sqtdso[23] = (unsigned short )0;
  sqlstm.sqhstv[24] = (         void  *)num_prefix;
  sqlstm.sqhstl[24] = (unsigned int  )30;
  sqlstm.sqhsts[24] = (         int  )0;
  sqlstm.sqindv[24] = (         void  *)0;
  sqlstm.sqinds[24] = (         int  )0;
  sqlstm.sqharm[24] = (unsigned int  )0;
  sqlstm.sqadto[24] = (unsigned short )0;
  sqlstm.sqtdso[24] = (unsigned short )0;
  sqlstm.sqhstv[25] = (         void  *)&d_numeric_result_9;
  sqlstm.sqhstl[25] = (unsigned int  )18;
  sqlstm.sqhsts[25] = (         int  )0;
  sqlstm.sqindv[25] = (         void  *)0;
  sqlstm.sqinds[25] = (         int  )0;
  sqlstm.sqharm[25] = (unsigned int  )0;
  sqlstm.sqadto[25] = (unsigned short )0;
  sqlstm.sqtdso[25] = (unsigned short )0;
  sqlstm.sqhstv[26] = (         void  *)result_status;
  sqlstm.sqhstl[26] = (unsigned int  )30;
  sqlstm.sqhsts[26] = (         int  )0;
  sqlstm.sqindv[26] = (         void  *)0;
  sqlstm.sqinds[26] = (         int  )0;
  sqlstm.sqharm[26] = (unsigned int  )0;
  sqlstm.sqadto[26] = (unsigned short )0;
  sqlstm.sqtdso[26] = (unsigned short )0;
  sqlstm.sqhstv[27] = (         void  *)num_prefix;
  sqlstm.sqhstl[27] = (unsigned int  )30;
  sqlstm.sqhsts[27] = (         int  )0;
  sqlstm.sqindv[27] = (         void  *)0;
  sqlstm.sqinds[27] = (         int  )0;
  sqlstm.sqharm[27] = (unsigned int  )0;
  sqlstm.sqadto[27] = (unsigned short )0;
  sqlstm.sqtdso[27] = (unsigned short )0;
  sqlstm.sqhstv[28] = (         void  *)&d_numeric_result_10;
  sqlstm.sqhstl[28] = (unsigned int  )18;
  sqlstm.sqhsts[28] = (         int  )0;
  sqlstm.sqindv[28] = (         void  *)0;
  sqlstm.sqinds[28] = (         int  )0;
  sqlstm.sqharm[28] = (unsigned int  )0;
  sqlstm.sqadto[28] = (unsigned short )0;
  sqlstm.sqtdso[28] = (unsigned short )0;
  sqlstm.sqhstv[29] = (         void  *)result_status;
  sqlstm.sqhstl[29] = (unsigned int  )30;
  sqlstm.sqhsts[29] = (         int  )0;
  sqlstm.sqindv[29] = (         void  *)0;
  sqlstm.sqinds[29] = (         int  )0;
  sqlstm.sqharm[29] = (unsigned int  )0;
  sqlstm.sqadto[29] = (unsigned short )0;
  sqlstm.sqtdso[29] = (unsigned short )0;
  sqlstm.sqhstv[30] = (         void  *)num_prefix;
  sqlstm.sqhstl[30] = (unsigned int  )30;
  sqlstm.sqhsts[30] = (         int  )0;
  sqlstm.sqindv[30] = (         void  *)0;
  sqlstm.sqinds[30] = (         int  )0;
  sqlstm.sqharm[30] = (unsigned int  )0;
  sqlstm.sqadto[30] = (unsigned short )0;
  sqlstm.sqtdso[30] = (unsigned short )0;
  sqlstm.sqhstv[31] = (         void  *)&d_numeric_result_11;
  sqlstm.sqhstl[31] = (unsigned int  )18;
  sqlstm.sqhsts[31] = (         int  )0;
  sqlstm.sqindv[31] = (         void  *)0;
  sqlstm.sqinds[31] = (         int  )0;
  sqlstm.sqharm[31] = (unsigned int  )0;
  sqlstm.sqadto[31] = (unsigned short )0;
  sqlstm.sqtdso[31] = (unsigned short )0;
  sqlstm.sqhstv[32] = (         void  *)result_status;
  sqlstm.sqhstl[32] = (unsigned int  )30;
  sqlstm.sqhsts[32] = (         int  )0;
  sqlstm.sqindv[32] = (         void  *)0;
  sqlstm.sqinds[32] = (         int  )0;
  sqlstm.sqharm[32] = (unsigned int  )0;
  sqlstm.sqadto[32] = (unsigned short )0;
  sqlstm.sqtdso[32] = (unsigned short )0;
  sqlstm.sqhstv[33] = (         void  *)num_prefix;
  sqlstm.sqhstl[33] = (unsigned int  )30;
  sqlstm.sqhsts[33] = (         int  )0;
  sqlstm.sqindv[33] = (         void  *)0;
  sqlstm.sqinds[33] = (         int  )0;
  sqlstm.sqharm[33] = (unsigned int  )0;
  sqlstm.sqadto[33] = (unsigned short )0;
  sqlstm.sqtdso[33] = (unsigned short )0;
  sqlstm.sqhstv[34] = (         void  *)&d_numeric_result_12;
  sqlstm.sqhstl[34] = (unsigned int  )18;
  sqlstm.sqhsts[34] = (         int  )0;
  sqlstm.sqindv[34] = (         void  *)0;
  sqlstm.sqinds[34] = (         int  )0;
  sqlstm.sqharm[34] = (unsigned int  )0;
  sqlstm.sqadto[34] = (unsigned short )0;
  sqlstm.sqtdso[34] = (unsigned short )0;
  sqlstm.sqhstv[35] = (         void  *)result_status;
  sqlstm.sqhstl[35] = (unsigned int  )30;
  sqlstm.sqhsts[35] = (         int  )0;
  sqlstm.sqindv[35] = (         void  *)0;
  sqlstm.sqinds[35] = (         int  )0;
  sqlstm.sqharm[35] = (unsigned int  )0;
  sqlstm.sqadto[35] = (unsigned short )0;
  sqlstm.sqtdso[35] = (unsigned short )0;
  sqlstm.sqhstv[36] = (         void  *)num_prefix;
  sqlstm.sqhstl[36] = (unsigned int  )30;
  sqlstm.sqhsts[36] = (         int  )0;
  sqlstm.sqindv[36] = (         void  *)0;
  sqlstm.sqinds[36] = (         int  )0;
  sqlstm.sqharm[36] = (unsigned int  )0;
  sqlstm.sqadto[36] = (unsigned short )0;
  sqlstm.sqtdso[36] = (unsigned short )0;
  sqlstm.sqhstv[37] = (         void  *)&d_numeric_result_13;
  sqlstm.sqhstl[37] = (unsigned int  )18;
  sqlstm.sqhsts[37] = (         int  )0;
  sqlstm.sqindv[37] = (         void  *)0;
  sqlstm.sqinds[37] = (         int  )0;
  sqlstm.sqharm[37] = (unsigned int  )0;
  sqlstm.sqadto[37] = (unsigned short )0;
  sqlstm.sqtdso[37] = (unsigned short )0;
  sqlstm.sqhstv[38] = (         void  *)result_status;
  sqlstm.sqhstl[38] = (unsigned int  )30;
  sqlstm.sqhsts[38] = (         int  )0;
  sqlstm.sqindv[38] = (         void  *)0;
  sqlstm.sqinds[38] = (         int  )0;
  sqlstm.sqharm[38] = (unsigned int  )0;
  sqlstm.sqadto[38] = (unsigned short )0;
  sqlstm.sqtdso[38] = (unsigned short )0;
  sqlstm.sqhstv[39] = (         void  *)num_prefix;
  sqlstm.sqhstl[39] = (unsigned int  )30;
  sqlstm.sqhsts[39] = (         int  )0;
  sqlstm.sqindv[39] = (         void  *)0;
  sqlstm.sqinds[39] = (         int  )0;
  sqlstm.sqharm[39] = (unsigned int  )0;
  sqlstm.sqadto[39] = (unsigned short )0;
  sqlstm.sqtdso[39] = (unsigned short )0;
  sqlstm.sqhstv[40] = (         void  *)&d_numeric_result_14;
  sqlstm.sqhstl[40] = (unsigned int  )18;
  sqlstm.sqhsts[40] = (         int  )0;
  sqlstm.sqindv[40] = (         void  *)0;
  sqlstm.sqinds[40] = (         int  )0;
  sqlstm.sqharm[40] = (unsigned int  )0;
  sqlstm.sqadto[40] = (unsigned short )0;
  sqlstm.sqtdso[40] = (unsigned short )0;
  sqlstm.sqhstv[41] = (         void  *)result_status;
  sqlstm.sqhstl[41] = (unsigned int  )30;
  sqlstm.sqhsts[41] = (         int  )0;
  sqlstm.sqindv[41] = (         void  *)0;
  sqlstm.sqinds[41] = (         int  )0;
  sqlstm.sqharm[41] = (unsigned int  )0;
  sqlstm.sqadto[41] = (unsigned short )0;
  sqlstm.sqtdso[41] = (unsigned short )0;
  sqlstm.sqhstv[42] = (         void  *)num_prefix;
  sqlstm.sqhstl[42] = (unsigned int  )30;
  sqlstm.sqhsts[42] = (         int  )0;
  sqlstm.sqindv[42] = (         void  *)0;
  sqlstm.sqinds[42] = (         int  )0;
  sqlstm.sqharm[42] = (unsigned int  )0;
  sqlstm.sqadto[42] = (unsigned short )0;
  sqlstm.sqtdso[42] = (unsigned short )0;
  sqlstm.sqhstv[43] = (         void  *)&d_numeric_result_15;
  sqlstm.sqhstl[43] = (unsigned int  )18;
  sqlstm.sqhsts[43] = (         int  )0;
  sqlstm.sqindv[43] = (         void  *)0;
  sqlstm.sqinds[43] = (         int  )0;
  sqlstm.sqharm[43] = (unsigned int  )0;
  sqlstm.sqadto[43] = (unsigned short )0;
  sqlstm.sqtdso[43] = (unsigned short )0;
  sqlstm.sqhstv[44] = (         void  *)result_status;
  sqlstm.sqhstl[44] = (unsigned int  )30;
  sqlstm.sqhsts[44] = (         int  )0;
  sqlstm.sqindv[44] = (         void  *)0;
  sqlstm.sqinds[44] = (         int  )0;
  sqlstm.sqharm[44] = (unsigned int  )0;
  sqlstm.sqadto[44] = (unsigned short )0;
  sqlstm.sqtdso[44] = (unsigned short )0;
  sqlstm.sqhstv[45] = (         void  *)num_prefix;
  sqlstm.sqhstl[45] = (unsigned int  )30;
  sqlstm.sqhsts[45] = (         int  )0;
  sqlstm.sqindv[45] = (         void  *)0;
  sqlstm.sqinds[45] = (         int  )0;
  sqlstm.sqharm[45] = (unsigned int  )0;
  sqlstm.sqadto[45] = (unsigned short )0;
  sqlstm.sqtdso[45] = (unsigned short )0;
  sqlstm.sqhstv[46] = (         void  *)&d_numeric_result_16;
  sqlstm.sqhstl[46] = (unsigned int  )18;
  sqlstm.sqhsts[46] = (         int  )0;
  sqlstm.sqindv[46] = (         void  *)0;
  sqlstm.sqinds[46] = (         int  )0;
  sqlstm.sqharm[46] = (unsigned int  )0;
  sqlstm.sqadto[46] = (unsigned short )0;
  sqlstm.sqtdso[46] = (unsigned short )0;
  sqlstm.sqhstv[47] = (         void  *)result_status;
  sqlstm.sqhstl[47] = (unsigned int  )30;
  sqlstm.sqhsts[47] = (         int  )0;
  sqlstm.sqindv[47] = (         void  *)0;
  sqlstm.sqinds[47] = (         int  )0;
  sqlstm.sqharm[47] = (unsigned int  )0;
  sqlstm.sqadto[47] = (unsigned short )0;
  sqlstm.sqtdso[47] = (unsigned short )0;
  sqlstm.sqhstv[48] = (         void  *)num_prefix;
  sqlstm.sqhstl[48] = (unsigned int  )30;
  sqlstm.sqhsts[48] = (         int  )0;
  sqlstm.sqindv[48] = (         void  *)0;
  sqlstm.sqinds[48] = (         int  )0;
  sqlstm.sqharm[48] = (unsigned int  )0;
  sqlstm.sqadto[48] = (unsigned short )0;
  sqlstm.sqtdso[48] = (unsigned short )0;
  sqlstm.sqhstv[49] = (         void  *)&d_numeric_result_17;
  sqlstm.sqhstl[49] = (unsigned int  )18;
  sqlstm.sqhsts[49] = (         int  )0;
  sqlstm.sqindv[49] = (         void  *)0;
  sqlstm.sqinds[49] = (         int  )0;
  sqlstm.sqharm[49] = (unsigned int  )0;
  sqlstm.sqadto[49] = (unsigned short )0;
  sqlstm.sqtdso[49] = (unsigned short )0;
  sqlstm.sqhstv[50] = (         void  *)result_status;
  sqlstm.sqhstl[50] = (unsigned int  )30;
  sqlstm.sqhsts[50] = (         int  )0;
  sqlstm.sqindv[50] = (         void  *)0;
  sqlstm.sqinds[50] = (         int  )0;
  sqlstm.sqharm[50] = (unsigned int  )0;
  sqlstm.sqadto[50] = (unsigned short )0;
  sqlstm.sqtdso[50] = (unsigned short )0;
  sqlstm.sqhstv[51] = (         void  *)num_prefix;
  sqlstm.sqhstl[51] = (unsigned int  )30;
  sqlstm.sqhsts[51] = (         int  )0;
  sqlstm.sqindv[51] = (         void  *)0;
  sqlstm.sqinds[51] = (         int  )0;
  sqlstm.sqharm[51] = (unsigned int  )0;
  sqlstm.sqadto[51] = (unsigned short )0;
  sqlstm.sqtdso[51] = (unsigned short )0;
  sqlstm.sqhstv[52] = (         void  *)&d_numeric_result_18;
  sqlstm.sqhstl[52] = (unsigned int  )18;
  sqlstm.sqhsts[52] = (         int  )0;
  sqlstm.sqindv[52] = (         void  *)0;
  sqlstm.sqinds[52] = (         int  )0;
  sqlstm.sqharm[52] = (unsigned int  )0;
  sqlstm.sqadto[52] = (unsigned short )0;
  sqlstm.sqtdso[52] = (unsigned short )0;
  sqlstm.sqhstv[53] = (         void  *)result_status;
  sqlstm.sqhstl[53] = (unsigned int  )30;
  sqlstm.sqhsts[53] = (         int  )0;
  sqlstm.sqindv[53] = (         void  *)0;
  sqlstm.sqinds[53] = (         int  )0;
  sqlstm.sqharm[53] = (unsigned int  )0;
  sqlstm.sqadto[53] = (unsigned short )0;
  sqlstm.sqtdso[53] = (unsigned short )0;
  sqlstm.sqhstv[54] = (         void  *)num_prefix;
  sqlstm.sqhstl[54] = (unsigned int  )30;
  sqlstm.sqhsts[54] = (         int  )0;
  sqlstm.sqindv[54] = (         void  *)0;
  sqlstm.sqinds[54] = (         int  )0;
  sqlstm.sqharm[54] = (unsigned int  )0;
  sqlstm.sqadto[54] = (unsigned short )0;
  sqlstm.sqtdso[54] = (unsigned short )0;
  sqlstm.sqhstv[55] = (         void  *)&d_numeric_result_19;
  sqlstm.sqhstl[55] = (unsigned int  )18;
  sqlstm.sqhsts[55] = (         int  )0;
  sqlstm.sqindv[55] = (         void  *)0;
  sqlstm.sqinds[55] = (         int  )0;
  sqlstm.sqharm[55] = (unsigned int  )0;
  sqlstm.sqadto[55] = (unsigned short )0;
  sqlstm.sqtdso[55] = (unsigned short )0;
  sqlstm.sqhstv[56] = (         void  *)result_status;
  sqlstm.sqhstl[56] = (unsigned int  )30;
  sqlstm.sqhsts[56] = (         int  )0;
  sqlstm.sqindv[56] = (         void  *)0;
  sqlstm.sqinds[56] = (         int  )0;
  sqlstm.sqharm[56] = (unsigned int  )0;
  sqlstm.sqadto[56] = (unsigned short )0;
  sqlstm.sqtdso[56] = (unsigned short )0;
  sqlstm.sqhstv[57] = (         void  *)num_prefix;
  sqlstm.sqhstl[57] = (unsigned int  )30;
  sqlstm.sqhsts[57] = (         int  )0;
  sqlstm.sqindv[57] = (         void  *)0;
  sqlstm.sqinds[57] = (         int  )0;
  sqlstm.sqharm[57] = (unsigned int  )0;
  sqlstm.sqadto[57] = (unsigned short )0;
  sqlstm.sqtdso[57] = (unsigned short )0;
  sqlstm.sqhstv[58] = (         void  *)&d_numeric_result_20;
  sqlstm.sqhstl[58] = (unsigned int  )18;
  sqlstm.sqhsts[58] = (         int  )0;
  sqlstm.sqindv[58] = (         void  *)0;
  sqlstm.sqinds[58] = (         int  )0;
  sqlstm.sqharm[58] = (unsigned int  )0;
  sqlstm.sqadto[58] = (unsigned short )0;
  sqlstm.sqtdso[58] = (unsigned short )0;
  sqlstm.sqhstv[59] = (         void  *)result_status;
  sqlstm.sqhstl[59] = (unsigned int  )30;
  sqlstm.sqhsts[59] = (         int  )0;
  sqlstm.sqindv[59] = (         void  *)0;
  sqlstm.sqinds[59] = (         int  )0;
  sqlstm.sqharm[59] = (unsigned int  )0;
  sqlstm.sqadto[59] = (unsigned short )0;
  sqlstm.sqtdso[59] = (unsigned short )0;
  sqlstm.sqhstv[60] = (         void  *)num_prefix;
  sqlstm.sqhstl[60] = (unsigned int  )30;
  sqlstm.sqhsts[60] = (         int  )0;
  sqlstm.sqindv[60] = (         void  *)0;
  sqlstm.sqinds[60] = (         int  )0;
  sqlstm.sqharm[60] = (unsigned int  )0;
  sqlstm.sqadto[60] = (unsigned short )0;
  sqlstm.sqtdso[60] = (unsigned short )0;
  sqlstm.sqhstv[61] = (         void  *)&d_numeric_result_21;
  sqlstm.sqhstl[61] = (unsigned int  )18;
  sqlstm.sqhsts[61] = (         int  )0;
  sqlstm.sqindv[61] = (         void  *)0;
  sqlstm.sqinds[61] = (         int  )0;
  sqlstm.sqharm[61] = (unsigned int  )0;
  sqlstm.sqadto[61] = (unsigned short )0;
  sqlstm.sqtdso[61] = (unsigned short )0;
  sqlstm.sqhstv[62] = (         void  *)result_status;
  sqlstm.sqhstl[62] = (unsigned int  )30;
  sqlstm.sqhsts[62] = (         int  )0;
  sqlstm.sqindv[62] = (         void  *)0;
  sqlstm.sqinds[62] = (         int  )0;
  sqlstm.sqharm[62] = (unsigned int  )0;
  sqlstm.sqadto[62] = (unsigned short )0;
  sqlstm.sqtdso[62] = (unsigned short )0;
  sqlstm.sqhstv[63] = (         void  *)num_prefix;
  sqlstm.sqhstl[63] = (unsigned int  )30;
  sqlstm.sqhsts[63] = (         int  )0;
  sqlstm.sqindv[63] = (         void  *)0;
  sqlstm.sqinds[63] = (         int  )0;
  sqlstm.sqharm[63] = (unsigned int  )0;
  sqlstm.sqadto[63] = (unsigned short )0;
  sqlstm.sqtdso[63] = (unsigned short )0;
  sqlstm.sqhstv[64] = (         void  *)&d_numeric_result_22;
  sqlstm.sqhstl[64] = (unsigned int  )18;
  sqlstm.sqhsts[64] = (         int  )0;
  sqlstm.sqindv[64] = (         void  *)0;
  sqlstm.sqinds[64] = (         int  )0;
  sqlstm.sqharm[64] = (unsigned int  )0;
  sqlstm.sqadto[64] = (unsigned short )0;
  sqlstm.sqtdso[64] = (unsigned short )0;
  sqlstm.sqhstv[65] = (         void  *)result_status;
  sqlstm.sqhstl[65] = (unsigned int  )30;
  sqlstm.sqhsts[65] = (         int  )0;
  sqlstm.sqindv[65] = (         void  *)0;
  sqlstm.sqinds[65] = (         int  )0;
  sqlstm.sqharm[65] = (unsigned int  )0;
  sqlstm.sqadto[65] = (unsigned short )0;
  sqlstm.sqtdso[65] = (unsigned short )0;
  sqlstm.sqhstv[66] = (         void  *)num_prefix;
  sqlstm.sqhstl[66] = (unsigned int  )30;
  sqlstm.sqhsts[66] = (         int  )0;
  sqlstm.sqindv[66] = (         void  *)0;
  sqlstm.sqinds[66] = (         int  )0;
  sqlstm.sqharm[66] = (unsigned int  )0;
  sqlstm.sqadto[66] = (unsigned short )0;
  sqlstm.sqtdso[66] = (unsigned short )0;
  sqlstm.sqhstv[67] = (         void  *)&d_numeric_result_23;
  sqlstm.sqhstl[67] = (unsigned int  )18;
  sqlstm.sqhsts[67] = (         int  )0;
  sqlstm.sqindv[67] = (         void  *)0;
  sqlstm.sqinds[67] = (         int  )0;
  sqlstm.sqharm[67] = (unsigned int  )0;
  sqlstm.sqadto[67] = (unsigned short )0;
  sqlstm.sqtdso[67] = (unsigned short )0;
  sqlstm.sqhstv[68] = (         void  *)result_status;
  sqlstm.sqhstl[68] = (unsigned int  )30;
  sqlstm.sqhsts[68] = (         int  )0;
  sqlstm.sqindv[68] = (         void  *)0;
  sqlstm.sqinds[68] = (         int  )0;
  sqlstm.sqharm[68] = (unsigned int  )0;
  sqlstm.sqadto[68] = (unsigned short )0;
  sqlstm.sqtdso[68] = (unsigned short )0;
  sqlstm.sqhstv[69] = (         void  *)num_prefix;
  sqlstm.sqhstl[69] = (unsigned int  )30;
  sqlstm.sqhsts[69] = (         int  )0;
  sqlstm.sqindv[69] = (         void  *)0;
  sqlstm.sqinds[69] = (         int  )0;
  sqlstm.sqharm[69] = (unsigned int  )0;
  sqlstm.sqadto[69] = (unsigned short )0;
  sqlstm.sqtdso[69] = (unsigned short )0;
  sqlstm.sqhstv[70] = (         void  *)&d_numeric_result_24;
  sqlstm.sqhstl[70] = (unsigned int  )18;
  sqlstm.sqhsts[70] = (         int  )0;
  sqlstm.sqindv[70] = (         void  *)0;
  sqlstm.sqinds[70] = (         int  )0;
  sqlstm.sqharm[70] = (unsigned int  )0;
  sqlstm.sqadto[70] = (unsigned short )0;
  sqlstm.sqtdso[70] = (unsigned short )0;
  sqlstm.sqhstv[71] = (         void  *)result_status;
  sqlstm.sqhstl[71] = (unsigned int  )30;
  sqlstm.sqhsts[71] = (         int  )0;
  sqlstm.sqindv[71] = (         void  *)0;
  sqlstm.sqinds[71] = (         int  )0;
  sqlstm.sqharm[71] = (unsigned int  )0;
  sqlstm.sqadto[71] = (unsigned short )0;
  sqlstm.sqtdso[71] = (unsigned short )0;
  sqlstm.sqhstv[72] = (         void  *)num_prefix;
  sqlstm.sqhstl[72] = (unsigned int  )30;
  sqlstm.sqhsts[72] = (         int  )0;
  sqlstm.sqindv[72] = (         void  *)0;
  sqlstm.sqinds[72] = (         int  )0;
  sqlstm.sqharm[72] = (unsigned int  )0;
  sqlstm.sqadto[72] = (unsigned short )0;
  sqlstm.sqtdso[72] = (unsigned short )0;
  sqlstm.sqhstv[73] = (         void  *)&d_numeric_result_25;
  sqlstm.sqhstl[73] = (unsigned int  )18;
  sqlstm.sqhsts[73] = (         int  )0;
  sqlstm.sqindv[73] = (         void  *)0;
  sqlstm.sqinds[73] = (         int  )0;
  sqlstm.sqharm[73] = (unsigned int  )0;
  sqlstm.sqadto[73] = (unsigned short )0;
  sqlstm.sqtdso[73] = (unsigned short )0;
  sqlstm.sqhstv[74] = (         void  *)result_status;
  sqlstm.sqhstl[74] = (unsigned int  )30;
  sqlstm.sqhsts[74] = (         int  )0;
  sqlstm.sqindv[74] = (         void  *)0;
  sqlstm.sqinds[74] = (         int  )0;
  sqlstm.sqharm[74] = (unsigned int  )0;
  sqlstm.sqadto[74] = (unsigned short )0;
  sqlstm.sqtdso[74] = (unsigned short )0;
  sqlstm.sqhstv[75] = (         void  *)&d_rowid;
  sqlstm.sqhstl[75] = (unsigned int  )63;
  sqlstm.sqhsts[75] = (         int  )0;
  sqlstm.sqindv[75] = (         void  *)0;
  sqlstm.sqinds[75] = (         int  )0;
  sqlstm.sqharm[75] = (unsigned int  )0;
  sqlstm.sqadto[75] = (unsigned short )0;
  sqlstm.sqtdso[75] = (unsigned short )0;
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




/* EXEC SQL COMMIT WORK; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 76;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )982;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
if (sqlca.sqlcode < 0) goto err_exit;
}


  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 76;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )997;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ERR_MESG,"Oracle error at Update Worklist Detail occured....\n");
   proc_exit();

}
/*--------------------------------------------------------------------------------*/
check_test_ordered_yn()
{
	v_count = 0;

	/* EXEC SQL SELECT COUNT(*)
	INTO :v_count
	FROM RL_TEST_RESULT
	WHERE specimen_no = TO_NUMBER(:d_specimen_no)
	AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND test_code = :d_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 76;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(*)  into :b0  from RL_TEST_RESULT where ((speci\
men_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and test_code=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1012;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&v_count;
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
 sqlstm.sqhstl[3] = (unsigned int  )17;
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



	if (v_count > 0)
	{
		d_req_test_yn.arr[ic] = 'Y';
	}

}
/*--------------------------------------------------------------------------------*/

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
