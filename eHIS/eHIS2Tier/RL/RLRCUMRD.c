
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
           char  filnam[45];
};
static const struct sqlcxp sqlfpn =
{
    44,
    "d:\\durai\\proc\\facility_corr_proc\\rlrcumrd.pc"
};


static unsigned long sqlctx = 1033704645;


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

 static const char *sq0006 = 
"EPISODE_TYPE order by TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss') \
           ";

 static const char *sq0007 = 
"EPISODE_TYPE order by TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss') \
desc             ";

 static const char *sq0005 = 
"select TEST_CODE1 ,TEST_CODE2 ,TEST_CODE3 ,TEST_CODE4 ,TEST_CODE5 ,TO_CHAR(T\
O_DATE(NVL(:b0,'00010101'),'YYYYMMDD'),'DD/MM/YYYY') ,TO_CHAR(TO_DATE(NVL(:b1,\
'47120101'),'YYYYMMDD'),'DD/MM/YYYY')  from RL_CUMM_PARAM where ((OPERATING_FA\
CILITY_ID=:b2 and PATIENT_ID=:b3) and SESSION_ID=:b4) order by LINE_NUM       \
     ";

 static const char *sq0008 = 
"select (('('||A.SPECIMEN_NO)||')') ,A.TEST_CODE ,TO_CHAR(C.SPEC_REGD_DATE_TI\
ME,'DD-MON-RR HH24:MI:ss') ,decode(A.NUMERIC_PREFIX,'-',('-'||A.NUMERIC_RESULT\
),(' '||nvl(A.NUMERIC_RESULT,'..')))  from RL_TEST_RESULT A ,RL_REQUEST_DETAIL\
 B ,RL_REQUEST_HEADER C where (((((((((((A.SPECIMEN_NO=C.SPECIMEN_NO and C.PAT\
IENT_ID=:b0) and TO_DATE(C.SPEC_REGD_DATE_TIME,'DD-MON-YY') between TO_DATE(NV\
L(:b1,'00010101'),'YYYYMMDD') and TO_DATE(NVL(:b2,'47120101'),'YYYYMMDD')) and\
 A.OPERATING_FACILITY_ID=:b3) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY\
_ID) and A.TEST_CODE in (:b4,:b5,:b6,:b7,:b8)) and B.SPECIMEN_NO=C.SPECIMEN_NO\
) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.GROUP_TEST_CODE=B.TEST_CODE) and NVL(\
A.CANCELLED_YN,'N')<>'Y') and NVL(A.status,'O') in ('R','P')) and NVL(B.RESULT\
_STATUS,'O') in ('R','P')) order by TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR H\
H24:MI:ss')            ";

 static const char *sq0009 = 
"select (('('||A.SPECIMEN_NO)||')') ,A.TEST_CODE ,TO_CHAR(C.SPEC_REGD_DATE_TI\
ME,'DD-MON-RR HH24:MI:ss') ,decode(A.NUMERIC_PREFIX,'-',('-'||A.NUMERIC_RESULT\
),(' '||nvl(A.NUMERIC_RESULT,'..')))  from RL_TEST_RESULT A ,RL_REQUEST_DETAIL\
 B ,RL_REQUEST_HEADER C where (((((((((((A.SPECIMEN_NO=C.SPECIMEN_NO and C.PAT\
IENT_ID=:b0) and TO_DATE(C.SPEC_REGD_DATE_TIME,'DD-MON-YY') between TO_DATE(NV\
L(:b1,'00010101'),'YYYYMMDD') and TO_DATE(NVL(:b2,'47120101'),'YYYYMMDD')) and\
 A.OPERATING_FACILITY_ID=:b3) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY\
_ID) and A.TEST_CODE in (:b4,:b5,:b6,:b7,:b8)) and B.SPECIMEN_NO=C.SPECIMEN_NO\
) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.GROUP_TEST_CODE=B.TEST_CODE) and NVL(\
A.CANCELLED_YN,'N')<>'Y') and NVL(A.status,'O') in ('R','P')) and NVL(B.RESULT\
_STATUS,'O') in ('R','P')) order by TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR H\
H24:MI:ss') desc             ";

 static const char *sq0010 = 
"select DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_loc_lang,SHORT_NAME)) SHORT\
_NAME  from SY_PHYSICIAN_MAST where (FACILITY_ID=nvl(:b1,:b2) and PHYSICIAN_ID\
=:b3)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,319,0,0,0,0,0,1,0,
20,0,0,2,0,0,27,333,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
51,0,0,3,120,0,6,345,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
74,0,0,4,136,0,6,360,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
97,0,0,12,101,0,2,548,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
124,0,0,5,0,0,13,580,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,
167,0,0,13,79,0,4,620,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
190,0,0,6,1111,0,9,653,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
221,0,0,7,1117,0,9,656,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
252,0,0,5,315,0,9,664,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
287,0,0,6,0,0,13,680,0,0,2,0,0,1,0,2,9,0,0,2,1,0,0,
310,0,0,7,0,0,13,687,0,0,2,0,0,1,0,2,9,0,0,2,1,0,0,
333,0,0,8,879,0,9,706,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
384,0,0,9,885,0,9,709,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
435,0,0,8,0,0,13,728,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
466,0,0,9,0,0,13,734,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
497,0,0,10,170,0,9,803,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
528,0,0,10,0,0,13,811,0,0,1,0,0,1,0,2,9,0,0,
547,0,0,14,168,0,4,861,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
582,0,0,15,522,0,4,916,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,
9,0,0,1,9,0,0,
625,0,0,16,0,0,32,939,0,0,0,0,0,1,0,
640,0,0,17,522,0,4,960,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,
9,0,0,1,9,0,0,
683,0,0,18,0,0,32,985,0,0,0,0,0,1,0,
698,0,0,19,156,0,6,1089,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
721,0,0,20,101,0,6,1163,0,0,1,1,0,1,0,2,3,0,0,
740,0,0,21,49,0,4,1176,0,0,1,0,0,1,0,2,9,0,0,
759,0,0,22,88,0,4,1202,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : RLRCUMRD                                     */
/* AUTHOR                : ROBERT JOSEPH                               */
/* DATE WRITTEN          : 22-JAN-2005                                   */
/*                                                                      */
/* CALLED FROM           : RLRCUMRP                                              */
/*                                                                      */
/* FUNCTION              :                                               */
/*                                                                      */
/* TABLE DETAILS                                                        */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <malloc.h>
#include "gl.h"
#define VIEW_REPORT 1 
#define INIT_MESG "Report Generation in Progress" 
#define VER  "VER : 1.10.01\n"
#define ESC 0x1B

/*
#define ERROR (sqlca.sqlcode < 0)
*/
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define CR fprintf(fp,"\n");
#define MAX_LINES 42
#define REP_WIDTH 300
#define NODATAFOUND sqlca.sqlcode==1403

/* EXEC SQL BEGIN DECLARE SECTION; */ 


long nd_file_no            = 0;

   /* VARCHAR nd_operating_facility_id         [3],
           uid_pwd                          [132],
           d_curr_pgm_name                  [15],
           nd_file_name                     [200],
           //hosp_name                        [120],
		   hosp_name                        [300],
           date_time                        [26],
           date_time1                        [26],
		   user_id                          [40],
		   d_version_no			            [20],
		   d_version  			            [20]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[200]; } nd_file_name;

struct { unsigned short len; unsigned char arr[300]; } hosp_name;

struct { unsigned short len; unsigned char arr[26]; } date_time;

struct { unsigned short len; unsigned char arr[26]; } date_time1;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;


   /* VARCHAR nd_rowid                         [31],
           nd_dt_fm                         [17],
           nd_dt_to                         [17],
           nd_patient_id                    [21],
           nd_session_id                    [16],
		   lb_date_time						[20],
           nd_dt_fm_prn                     [17],
           nd_dt_to_prn                     [17],
           nd_test_code						[11],
           nd_test_code1                    [11],
           nd_test_code2                    [11],
           nd_test_code3                    [11],
           nd_test_code4                    [11],
           nd_test_code5                    [11],
           nd_test_code6                    [11],
           nd_test_code7                    [11],
		   tst1								[11],	
           tst2								[11],
		    tst3								[11],
			tst4								[11],
				tst5								[11],
           lb_hdr_test_num                  [21],
           lb_hdr_consultant_code           [16],
           lb_hdr_spec_regd_date_time       [21],
		   l_actual_dob_yn					[2], 

           lb_tst_test_code                 [11],
		   lb_specimen_no					[15],
           lb_tst_numeric_prefix            [2],
           lb_tst_numeric_result            [16],
		   spec_time						[21],
            a								[14],						
           lb_loc_test_code                 [11],
           lb_loc_test_code_units           [11],
		   lb_loc_test_code_units_desc      [41],
          
           lb_pat_name_loc_lang             [61],
           lb_pat_short_name                [61],
           lb_pat_sex                       [2],
           nd_asc_desc                      [2],
		   rl_ordered_facility_id			[3],
		   l_operating_facility_id          [3],
           lb_consultant_long_name          [61],
		   l_translated_value		 [100],
		   language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_rowid;

struct { unsigned short len; unsigned char arr[17]; } nd_dt_fm;

struct { unsigned short len; unsigned char arr[17]; } nd_dt_to;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } lb_date_time;

struct { unsigned short len; unsigned char arr[17]; } nd_dt_fm_prn;

struct { unsigned short len; unsigned char arr[17]; } nd_dt_to_prn;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code1;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code2;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code3;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code4;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code5;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code6;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code7;

struct { unsigned short len; unsigned char arr[11]; } tst1;

struct { unsigned short len; unsigned char arr[11]; } tst2;

struct { unsigned short len; unsigned char arr[11]; } tst3;

struct { unsigned short len; unsigned char arr[11]; } tst4;

struct { unsigned short len; unsigned char arr[11]; } tst5;

struct { unsigned short len; unsigned char arr[21]; } lb_hdr_test_num;

struct { unsigned short len; unsigned char arr[16]; } lb_hdr_consultant_code;

struct { unsigned short len; unsigned char arr[21]; } lb_hdr_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[2]; } l_actual_dob_yn;

struct { unsigned short len; unsigned char arr[11]; } lb_tst_test_code;

struct { unsigned short len; unsigned char arr[15]; } lb_specimen_no;

struct { unsigned short len; unsigned char arr[2]; } lb_tst_numeric_prefix;

struct { unsigned short len; unsigned char arr[16]; } lb_tst_numeric_result;

struct { unsigned short len; unsigned char arr[21]; } spec_time;

struct { unsigned short len; unsigned char arr[14]; } a;

struct { unsigned short len; unsigned char arr[11]; } lb_loc_test_code;

struct { unsigned short len; unsigned char arr[11]; } lb_loc_test_code_units;

struct { unsigned short len; unsigned char arr[41]; } lb_loc_test_code_units_desc;

struct { unsigned short len; unsigned char arr[61]; } lb_pat_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } lb_pat_short_name;

struct { unsigned short len; unsigned char arr[2]; } lb_pat_sex;

struct { unsigned short len; unsigned char arr[2]; } nd_asc_desc;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[3]; } l_operating_facility_id;

struct { unsigned short len; unsigned char arr[61]; } lb_consultant_long_name;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;



   char    nd_tst_cd_arr                    [8][11],
           nd_tst_units                     [8][16];

   char	   lb_trn_hdr_episode_type;

   int     no_of_dtl_recs = 0;

   int     lb_pat_age_y,
           lb_pat_age_m,
           lb_pat_age_d;
   int     l_ret_run_rep;
   int     l_count = 0;
    
   int     l_tab_exists ;
   int tcnt;
   int j=0;
int exist=0;
int i;
	char local_legend[100][100],
		 hdr_line1[REP_WIDTH+1],
		 hdr_line2[REP_WIDTH+1],
		 hdr_line3[REP_WIDTH+1];
	int col;
	char rep_title1[100] ;
	char rep_title2[60];
	int rec_len;


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
char string_var[100];

char *center();
struct
{
     char time_arr[40];
       char time_form[40];
 } nd_time_arr_form[200];

struct
{ 
char tst_arr[40];
char tst_form[40];
}nd_tst_cd_arr_form [100];

FILE *fp;
char prev_group_test[6];

int i = 0,rec_ctr = 0,lctr = 0,pctr = 0,dtl_ctr = 0,k=0,tstcntr=0;

void proc_main(argc,argv)
char *argv[];
int argc;
{
  char cmd [120];
  void print_rep_header() ;
  void print_page_header() ;
  int i = 0;
  /*
   if (argc < 5)
   {
    int i = 0;
      disp_message(ERR_MESG, "Not enough Parameters for running this program\n");
      disp_message(ERR_MESG, "Exiting...\n\007\007\007\007\007\007\007\007");
      sprintf(string_var, "No of parameters passed is <%d>\n",argc);
      disp_message(ERR_MESG, string_var);
      disp_message("The following are the parameters :-\n");
      for(i=0;i<argc;i++) sprintf(string_var, "argv[ %d ] --> <%s>\n",i,argv[i]);
      disp_message(ERR_MESG, string_var);
      proc_exit();
   }
   */


   strcpy(g_pgm_id,"RLRCUMRD");

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);
   
   strcpy(nd_operating_facility_id.arr,argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

   strcpy(OUTPUT_FILE_NAME, argv[5]);
   
   strcpy(nd_patient_id.arr,argv[6]);
   nd_patient_id.len = strlen(nd_patient_id.arr);

   strcpy(nd_asc_desc.arr,argv[7]);
   nd_asc_desc.len = strlen(nd_asc_desc.arr);
   
   strcpy(nd_dt_fm.arr,argv[8]);
   nd_dt_fm.len = strlen(nd_dt_fm.arr);

   strcpy(nd_dt_to.arr,argv[9]);
   nd_dt_to.len = strlen(nd_dt_to.arr);

   strcpy(d_curr_pgm_name.arr,g_pgm_id); 
   d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 
   
   if(sql_connect(argv[1]) == -1)
   {
      disp_message(ORA_MESG, "Error in connecting to Oracle\n");
      proc_exit();
   }

   set_meduser_role();
   strcpy(language_id.arr,l_language_id.arr);
   language_id.len =l_language_id.len;
   language_id.arr[l_language_id.len]='\0';
   get_legend_value(24);
   
   declare_curs();
   
   gen_file_no();
   
   fetch_hosp_name();
      

   lctr = 0,pctr = 0;
   print_rep_header() ;

    open_hdr();

      while(fetch_hdr())
      {
	  rec_ctr ++;
	  
      if (rec_ctr == 1 )
	      fetch_print_hdr_dtls();
	   strcpy(nd_time_arr_form[j].time_arr,lb_hdr_spec_regd_date_time.arr);
	     fprintf(fp,"%20s",lb_hdr_spec_regd_date_time.arr);
         j=j+1;
        
      tcnt=tcnt+1;   
	   }
 	  fprintf(fp,"\n");
	  lctr=lctr+1;
     fprint_repeat(fp,'-',rec_ctr*20+20);
	 
	 open_cumm();
  while (fetch_cumm_param())
   { 
  open_tst_result();          
    while(fetch_tst_result())
       {
	     
         
       if(strcmp(a.arr,lb_tst_test_code.arr)==0)
          {
		   	
            for (i=0;i<tcnt;i++)
    			{
               if(strcmp(nd_time_arr_form[i].time_arr,spec_time.arr)==0)
				       {
					   move_to_column(k,i+1);
                     
                    fprintf(fp,"%7s%-13s",lb_tst_numeric_result.arr,lb_specimen_no.arr);
					k=i+1;
                      }   
                      
                     
				}
            }


			else
			{
			fetch_test_units();
			if(tstcntr>0)
					CR;CR;
					lctr=lctr+2;
			    if(lctr+3 > MAX_LINES )
					  {
					   //fprintf(fp,"\f");
					   fetch_print_hdr_dtls();get_page_head_time();CR;
                      fprint_repeat(fp,'-',rec_ctr*20+20);CR;
					   }                 
             
			 fprintf(fp,"%-10s%-10s ",lb_tst_test_code.arr,lb_loc_test_code_units_desc.arr);
			 k=0;
			 
              for (i=0;i<tcnt;i++)
    		 	 {
                 
                      if(strcmp(nd_time_arr_form[i].time_arr,spec_time.arr)==0)
				       {
             
                 move_to_column(k,i+1);
                     
                    fprintf(fp,"%7s%-13s",lb_tst_numeric_result.arr,lb_specimen_no.arr);
					k=i+1;
                     
				    }  
					   
                   }
				  tstcntr=tstcntr+1; 
				   
		     }
                   strcpy(a.arr,lb_tst_test_code.arr);   

			     
	
            
	 }



        }


   if (rec_ctr)
   end_of_rep();
   fclose(fp);
   delete_cumm_param();

   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
       err_mesg("ROLLBACK WORK RELEASE failed",0,"");

    
   return;
}

sql_connect(l_nd_ap_uid_pwd)
char l_nd_ap_uid_pwd[];
{
  strcpy(uid_pwd.arr,l_nd_ap_uid_pwd);
  uid_pwd.len = strlen(uid_pwd.arr);

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )20;
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

/***********added by babu for globalization***************/
get_legend_value(int cou)
 {
     
   
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRCUMRP.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRCUMRP.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRCUMRP.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRCUMRP.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )74;
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
/**********PRINT SPACE*************/
print_space(int aa, int bb, int cc)
{
	if (cc ==1)
	{
  		for(i=1;i <= (aa - bb) ;i++)
		{
			fprintf(fp,"%s"," ");
		}	
	}
	else if (cc ==0)
	{
  		for(i= (aa - bb);i <= aa ;i++)
		{
			fprintf(fp,"%s","-");
		}	
	}
}

/***********END PRINT SPACE***************/

declare_curs()
{       
    /* EXEC SQL DECLARE LB_CUMM_PARAM_CUR CURSOR FOR
              SELECT TEST_CODE1,
                     TEST_CODE2,
                     TEST_CODE3,
                     TEST_CODE4,
                     TEST_CODE5,
               /o      TEST_CODE6,
                     TEST_CODE7, o/    
                     TO_CHAR(TO_DATE(NVL(:nd_dt_fm,'00010101'),'YYYYMMDD'),'DD/MM/YYYY'),
                     TO_CHAR(TO_DATE(NVL(:nd_dt_to,'47120101'),'YYYYMMDD'),'DD/MM/YYYY')
                FROM RL_CUMM_PARAM
               WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			     AND PATIENT_ID = :nd_patient_id
                 AND SESSION_ID = :nd_session_id
            ORDER BY LINE_NUM; */ 


 


  
/* EXEC SQL DECLARE LB_TRN_HDR_CUR_A CURSOR FOR
            SELECT DISTINCT TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss'),EPISODE_TYPE
                FROM RL_TEST_RESULT A, RL_REQUEST_DETAIL B,RL_REQUEST_HEADER C
               WHERE A.SPECIMEN_NO = C.SPECIMEN_NO 
	       AND		    C.PATIENT_ID= :nd_patient_id
		  AND TO_DATE(C.SPEC_REGD_DATE_TIME,'DD-MON-YY') between 
		  TO_DATE(NVL(:nd_dt_fm,'00010101'),'YYYYMMDD')
                 AND TO_DATE(NVL(:nd_dt_to,'47120101'),'YYYYMMDD')
			     AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID 
				AND B.SPECIMEN_NO = C.SPECIMEN_NO
				 AND A.SPECIMEN_NO = B.SPECIMEN_NO   						
				 	 AND A.GROUP_TEST_CODE = B.TEST_CODE
					 	AND (A.TEST_CODE IN ( select test_code1 from rl_cumm_param)
						or A.TEST_CODE IN (select test_code2 from rl_cumm_param)
						or A.TEST_CODE IN (select test_code3 from rl_cumm_param)
						or A.TEST_CODE IN (select test_code4 from rl_cumm_param)
						or A.TEST_CODE IN (select test_code5 from rl_cumm_param))
			     AND NVL(A.CANCELLED_YN,'N') != 'Y' 
				 AND NVL(A.status, 'O') IN ('R','P')
				 AND NVL(B.RESULT_STATUS, 'O') IN ('R', 'P')
				 group by  TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss'),EPISODE_TYPE
				ORDER BY TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss') ; */ 


  
/* EXEC SQL DECLARE LB_TRN_HDR_CUR_D CURSOR FOR
            SELECT DISTINCT TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss'),EPISODE_TYPE
                FROM RL_TEST_RESULT A, RL_REQUEST_DETAIL B,RL_REQUEST_HEADER C
               WHERE A.SPECIMEN_NO = C.SPECIMEN_NO 
	       AND		    C.PATIENT_ID= :nd_patient_id
		  AND TO_DATE(C.SPEC_REGD_DATE_TIME,'DD-MON-YY') between 
		  TO_DATE(NVL(:nd_dt_fm,'00010101'),'YYYYMMDD')
                 AND TO_DATE(NVL(:nd_dt_to,'47120101'),'YYYYMMDD')
			     AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID 
				 AND B.SPECIMEN_NO = C.SPECIMEN_NO
				 AND A.SPECIMEN_NO = B.SPECIMEN_NO
				 	 AND A.GROUP_TEST_CODE = B.TEST_CODE
				AND (A.TEST_CODE IN ( select test_code1 from rl_cumm_param)
						or A.TEST_CODE IN (select test_code2 from rl_cumm_param)
						or A.TEST_CODE IN (select test_code3 from rl_cumm_param)
						or A.TEST_CODE IN (select test_code4 from rl_cumm_param)
						or A.TEST_CODE IN (select test_code5 from rl_cumm_param))
			     AND NVL(A.CANCELLED_YN,'N') != 'Y' 
				 AND NVL(A.status, 'O') IN ('R','P')
				 AND NVL(B.RESULT_STATUS, 'O') IN ('R', 'P')
				 group by  TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss'),EPISODE_TYPE
				ORDER BY  TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss') desc; */ 


/* EXEC SQL DECLARE LB_TRN_EXPL_CURA CURSOR FOR
                       SELECT 
					  // C.PATIENT_ID,
					   '('||A.SPECIMEN_NO||')',
					   A.TEST_CODE, 
					   TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss'),
                    decode(A.NUMERIC_PREFIX,'-','-' || A.NUMERIC_RESULT,' ' || nvl(A.NUMERIC_RESULT,'..'))  
                FROM RL_TEST_RESULT A, RL_REQUEST_DETAIL B,RL_REQUEST_HEADER C
               WHERE A.SPECIMEN_NO = C.SPECIMEN_NO 
	       AND C.PATIENT_ID= :nd_patient_id
		  AND TO_DATE(C.SPEC_REGD_DATE_TIME,'DD-MON-YY') BETWEEN
		 		  TO_DATE(NVL(:nd_dt_fm,'00010101'),'YYYYMMDD')
                 AND TO_DATE(NVL(:nd_dt_to,'47120101'),'YYYYMMDD')
			     AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID   
				AND A.TEST_CODE IN (
			     :nd_test_code1,
                       :nd_test_code2,
                       :nd_test_code3,
                       :nd_test_code4,
                       :nd_test_code5
      						)
				 AND B.SPECIMEN_NO = C.SPECIMEN_NO
				 AND A.SPECIMEN_NO = B.SPECIMEN_NO
				 AND A.GROUP_TEST_CODE = B.TEST_CODE
			     AND NVL(A.CANCELLED_YN,'N') != 'Y' 
				 AND NVL(A.status, 'O') IN ('R','P')
				 AND NVL(B.RESULT_STATUS, 'O') IN ('R', 'P') 
				ORDER BY TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss') ; */ 


/* EXEC SQL DECLARE LB_TRN_EXPL_CURD CURSOR FOR
                       SELECT 
					  // C.PATIENT_ID,
					   '('||A.SPECIMEN_NO||')',
					   A.TEST_CODE, 
					   TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss'),
                    decode(A.NUMERIC_PREFIX,'-','-' || A.NUMERIC_RESULT,' ' || nvl(A.NUMERIC_RESULT,'..'))  
                FROM RL_TEST_RESULT A, RL_REQUEST_DETAIL B,RL_REQUEST_HEADER C
               WHERE A.SPECIMEN_NO = C.SPECIMEN_NO 
	       AND C.PATIENT_ID= :nd_patient_id
		  AND TO_DATE(C.SPEC_REGD_DATE_TIME,'DD-MON-YY') BETWEEN
		 		  TO_DATE(NVL(:nd_dt_fm,'00010101'),'YYYYMMDD')
                 AND TO_DATE(NVL(:nd_dt_to,'47120101'),'YYYYMMDD')
			     AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID   
				AND A.TEST_CODE IN (
			     :nd_test_code1,
                       :nd_test_code2,
                       :nd_test_code3,
                       :nd_test_code4,
                       :nd_test_code5
      						)
				 AND B.SPECIMEN_NO = C.SPECIMEN_NO
				 AND A.SPECIMEN_NO = B.SPECIMEN_NO
				 AND A.GROUP_TEST_CODE = B.TEST_CODE
			     AND NVL(A.CANCELLED_YN,'N') != 'Y' 
				 AND NVL(A.status, 'O') IN ('R','P')
				 AND NVL(B.RESULT_STATUS, 'O') IN ('R', 'P') 
				ORDER BY TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss') DESC ; */ 





    /* EXEC SQL DECLARE SY_PHYSICIAN_MAST_CUR CURSOR FOR
              SELECT DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) SHORT_NAME
                FROM SY_PHYSICIAN_MAST
               WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
				 AND PHYSICIAN_ID = :lb_hdr_consultant_code; */ 


    /* EXEC SQL DECLARE LB_TEST_CODE_CUR CURSOR FOR
              SELECT TEST_UNITS
                FROM RL_TEST_CODE
               WHERE TEST_CODE = :lb_loc_test_code; */ 

}

delete_cumm_param()
{
    /* EXEC SQL DELETE
               FROM RL_CUMM_PARAM
              WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			    AND PATIENT_ID = :nd_patient_id
                AND SESSION_ID = :nd_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from RL_CUMM_PARAM  where ((OPERATING_FACILITY_ID\
=:b0 and PATIENT_ID=:b1) and SESSION_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )97;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
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
       err_mesg("DELETE failed on table LB_CUMM_PARAM",0,"");
}

fetch_cumm_param()
{
  nd_test_code1.arr[0]          = '\0';
  nd_test_code2.arr[0]          = '\0';
  nd_test_code3.arr[0]          = '\0';
  nd_test_code4.arr[0]          = '\0';
  nd_test_code5.arr[0]          = '\0';
  nd_test_code6.arr[0]          = '\0';
  nd_test_code7.arr[0]          = '\0';
  nd_dt_fm_prn.arr[0]           = '\0';
  nd_dt_to_prn.arr[0]           = '\0';

  nd_test_code1.len             = 0;
  nd_test_code2.len             = 0;
  nd_test_code3.len             = 0;
  nd_test_code4.len             = 0;
  nd_test_code5.len             = 0;
  nd_test_code6.len             = 0;
  nd_test_code7.len             = 0;
  nd_dt_fm_prn.len              = 0;
  nd_dt_to_prn.len              = 0;


    /* EXEC SQL FETCH LB_CUMM_PARAM_CUR
              INTO :nd_test_code1,
                   :nd_test_code2,
                   :nd_test_code3,
                   :nd_test_code4,
                   :nd_test_code5,
                   :nd_dt_fm_prn,
                   :nd_dt_to_prn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )124;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_test_code1;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_test_code2;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_test_code3;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_test_code4;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_test_code5;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_dt_fm_prn;
    sqlstm.sqhstl[5] = (unsigned int  )19;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_dt_to_prn;
    sqlstm.sqhstl[6] = (unsigned int  )19;
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
}



    if (OERROR)
         err_mesg("OPEN failed on cursor LB_CUMM_PARAM_CUR",0,"");

    nd_test_code1.arr[nd_test_code1.len] = '\0';
    nd_test_code2.arr[nd_test_code2.len] = '\0';
    nd_test_code3.arr[nd_test_code3.len] = '\0';
    nd_test_code4.arr[nd_test_code4.len] = '\0';
    nd_test_code5.arr[nd_test_code5.len] = '\0';
    nd_dt_fm_prn.arr[nd_dt_fm_prn.len] = '\0';
    nd_dt_to_prn.arr[nd_dt_to_prn.len] = '\0';

    strcpy(nd_tst_cd_arr[0],nd_test_code1.arr);
    strcpy(nd_tst_cd_arr[1],nd_test_code2.arr);
    strcpy(nd_tst_cd_arr[2],nd_test_code3.arr);
    strcpy(nd_tst_cd_arr[3],nd_test_code4.arr);
    strcpy(nd_tst_cd_arr[4],nd_test_code5.arr);
	/*
    strcpy(nd_tst_cd_arr[5],nd_test_code6.arr);
    strcpy(nd_tst_cd_arr[6],nd_test_code7.arr);
	*/

    return(LAST_ROW?0:1);
}

fetch_test_units()
{


        lb_loc_test_code_units.arr[0] = '\0';
        lb_loc_test_code_units.len    = 0;

        /* EXEC SQL SELECT '('||TEST_UNITS||')' into :lb_loc_test_code_units
                FROM RL_TEST_CODE
               WHERE TEST_CODE =:lb_tst_test_code ; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 7;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select (('('||TEST_UNITS)||')') into :b0  from RL_TES\
T_CODE where TEST_CODE=:b1";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )167;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&lb_loc_test_code_units;
        sqlstm.sqhstl[0] = (unsigned int  )13;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&lb_tst_test_code;
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
}



      
        lb_loc_test_code_units.arr[lb_loc_test_code_units.len] = '\0';

		get_test_units_desc_from_sy_uom(); ////19.02.2006

}

gen_file_no()
{
	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_file_name.arr,"rlrcumrd.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);

	 if ((fp = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
}

open_hdr()
{

if (strcmp(nd_asc_desc.arr,"A") == 0)
   
    /* EXEC SQL OPEN LB_TRN_HDR_CUR_A; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select distinct TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss')\
 ,EPISODE_TYPE  from RL_TEST_RESULT A ,RL_REQUEST_DETAIL B ,RL_REQUEST_HEADE\
R C where (((((((((((A.SPECIMEN_NO=C.SPECIMEN_NO and C.PATIENT_ID=:b0) and T\
O_DATE(C.SPEC_REGD_DATE_TIME,'DD-MON-YY') between TO_DATE(NVL(:b1,'00010101'\
),'YYYYMMDD') and TO_DATE(NVL(:b2,'47120101'),'YYYYMMDD')) and A.OPERATING_F\
ACILITY_ID=:b3) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and B.S\
PECIMEN_NO=C.SPECIMEN_NO) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.GROUP_TEST_\
CODE=B.TEST_CODE) and ((((A.TEST_CODE in (select test_code1  from rl_cumm_pa\
ram ) or A.TEST_CODE in (select test_code2  from rl_cumm_param )) or A.TEST_\
CODE in (select test_code3  from rl_cumm_param )) or A.TEST_CODE in (select \
test_code4  from rl_cumm_param )) or A.TEST_CODE in (select test_code5  from\
 rl_cumm_param ))) and NVL(A.CANCELLED_YN,'N')<>'Y') and NVL(A.status,'O') i\
n ('R','P')) and NVL(B.RESULT_STATUS,'O') in ('R','P')) group by TO_CHAR(C.S\
PEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss'),");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )190;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_dt_fm;
    sqlstm.sqhstl[1] = (unsigned int  )19;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_dt_to;
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
}


else
if (strcmp(nd_asc_desc.arr,"D") == 0)
    /* EXEC SQL OPEN LB_TRN_HDR_CUR_D; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select distinct TO_CHAR(C.SPEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss')\
 ,EPISODE_TYPE  from RL_TEST_RESULT A ,RL_REQUEST_DETAIL B ,RL_REQUEST_HEADE\
R C where (((((((((((A.SPECIMEN_NO=C.SPECIMEN_NO and C.PATIENT_ID=:b0) and T\
O_DATE(C.SPEC_REGD_DATE_TIME,'DD-MON-YY') between TO_DATE(NVL(:b1,'00010101'\
),'YYYYMMDD') and TO_DATE(NVL(:b2,'47120101'),'YYYYMMDD')) and A.OPERATING_F\
ACILITY_ID=:b3) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and B.S\
PECIMEN_NO=C.SPECIMEN_NO) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.GROUP_TEST_\
CODE=B.TEST_CODE) and ((((A.TEST_CODE in (select test_code1  from rl_cumm_pa\
ram ) or A.TEST_CODE in (select test_code2  from rl_cumm_param )) or A.TEST_\
CODE in (select test_code3  from rl_cumm_param )) or A.TEST_CODE in (select \
test_code4  from rl_cumm_param )) or A.TEST_CODE in (select test_code5  from\
 rl_cumm_param ))) and NVL(A.CANCELLED_YN,'N')<>'Y') and NVL(A.status,'O') i\
n ('R','P')) and NVL(B.RESULT_STATUS,'O') in ('R','P')) group by TO_CHAR(C.S\
PEC_REGD_DATE_TIME,'DD-MON-RR HH24:MI:ss'),");
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )221;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_dt_fm;
    sqlstm.sqhstl[1] = (unsigned int  )19;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_dt_to;
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
}



    if (OERROR)
         err_mesg("OPEN failed on cursor LB_TRN_HDR_CUR",0,"");
}

open_cumm()
{
   /* EXEC SQL OPEN LB_CUMM_PARAM_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )252;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_dt_fm;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_dt_to;
   sqlstm.sqhstl[1] = (unsigned int  )19;
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
   sqlstm.sqhstv[3] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[4] = (unsigned int  )18;
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
         err_mesg("OPEN failed on cursor LB_CUMM_PARAM_CUR",0,"");
  }

fetch_hdr()
{
 
  lb_hdr_spec_regd_date_time.arr[0] = '\0';


 
  lb_hdr_spec_regd_date_time.len    = 0;

if (strcmp(nd_asc_desc.arr,"A") == 0)
    /* EXEC SQL FETCH LB_TRN_HDR_CUR_A
			INTO 
			   :lb_hdr_spec_regd_date_time,
			   :lb_trn_hdr_episode_type; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )287;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&lb_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&lb_trn_hdr_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )1;
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


			   

else if (strcmp(nd_asc_desc.arr,"D") == 0)
    /* EXEC SQL FETCH LB_TRN_HDR_CUR_D
              INTO 
			   :lb_hdr_spec_regd_date_time,
			   :lb_trn_hdr_episode_type; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )310;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&lb_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&lb_trn_hdr_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )1;
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
        err_mesg("FETCH failed on cursor LB_TRN_HDR_CUR",0,"");

    lb_hdr_spec_regd_date_time.arr[lb_hdr_spec_regd_date_time.len] = '\0';


    return (LAST_ROW?0:1);
}

open_tst_result()
{
if (strcmp(nd_asc_desc.arr,"A") == 0)
    /* EXEC SQL OPEN LB_TRN_EXPL_CURA; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )333;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_dt_fm;
    sqlstm.sqhstl[1] = (unsigned int  )19;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_dt_to;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_test_code1;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_test_code2;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_test_code3;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_test_code4;
    sqlstm.sqhstl[7] = (unsigned int  )13;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_test_code5;
    sqlstm.sqhstl[8] = (unsigned int  )13;
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


else
if (strcmp(nd_asc_desc.arr,"D") == 0)
/* EXEC SQL OPEN LB_TRN_EXPL_CURD; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 9;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = sq0009;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )384;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
sqlstm.sqhstl[0] = (unsigned int  )23;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_dt_fm;
sqlstm.sqhstl[1] = (unsigned int  )19;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_dt_to;
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
sqlstm.sqhstv[4] = (         void  *)&nd_test_code1;
sqlstm.sqhstl[4] = (unsigned int  )13;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&nd_test_code2;
sqlstm.sqhstl[5] = (unsigned int  )13;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nd_test_code3;
sqlstm.sqhstl[6] = (unsigned int  )13;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&nd_test_code4;
sqlstm.sqhstl[7] = (unsigned int  )13;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&nd_test_code5;
sqlstm.sqhstl[8] = (unsigned int  )13;
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



    if (OERROR)
         err_mesg("OPEN failed on cursor LB_TRN_EXPL_CUR",0,"");
}

fetch_tst_result()
{
  lb_tst_test_code.arr[0]      = '\0';
 spec_time.arr[0] = '\0';
 lb_specimen_no.arr[0]= '\0';
  lb_tst_numeric_result.arr[0] = '\0';

  lb_tst_test_code.len         = 0;
  lb_specimen_no.len		=0;	
  spec_time.len    = 0;
  lb_tst_numeric_result.len    = 0;

if (strcmp(nd_asc_desc.arr,"A") == 0)
    /* EXEC SQL FETCH LB_TRN_EXPL_CURA
              INTO :lb_specimen_no,
			  :lb_tst_test_code,
			  	:spec_time,
                 :lb_tst_numeric_result; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )435;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&lb_specimen_no;
    sqlstm.sqhstl[0] = (unsigned int  )17;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&lb_tst_test_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&spec_time;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&lb_tst_numeric_result;
    sqlstm.sqhstl[3] = (unsigned int  )18;
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


else if (strcmp(nd_asc_desc.arr,"D") == 0)
			/* EXEC SQL FETCH LB_TRN_EXPL_CURD
              INTO :lb_specimen_no,
			  :lb_tst_test_code,
			  	:spec_time,
                 :lb_tst_numeric_result; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )466;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&lb_specimen_no;
   sqlstm.sqhstl[0] = (unsigned int  )17;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&lb_tst_test_code;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&spec_time;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&lb_tst_numeric_result;
   sqlstm.sqhstl[3] = (unsigned int  )18;
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
         err_mesg("FETCH failed on cursor LB_TRN_EXPL_CUR",0,"");

    lb_tst_test_code.arr[lb_tst_test_code.len] = '\0';
	lb_specimen_no.arr[lb_specimen_no.len]	='\0';
    spec_time.arr[spec_time.len] = '\0';
    lb_tst_numeric_result.arr[lb_tst_numeric_result.len] = '\0';


    return (LAST_ROW?0:1);
}

/*
print_dtls()
{
   int i = 0,j = 0;

   fprintf(fp,"%-16.16s ",lb_hdr_spec_regd_date_time.arr);
   fprintf(fp,"%-2.2s ",l_operating_facility_id.arr);     
   fprintf(fp,"%-15.15s ",lb_hdr_test_num.arr);

    fprintf(fp,"\n");
    lctr++;
}
*/
fetch_print_hdr_dtls()
{
lctr=0;
   fetch_pat_name();
   fetch_consultant();
   print_page_header();

   //fprint_repeat(fp,'-',162);CR;
   fprintf(fp,"%-10.10s      : %-21s   %-4.4s : %s",local_legend[2],nd_patient_id.arr,
               local_legend[3],lb_pat_short_name.arr);CR;
   fprintf(fp,"%-7.7s         : %1s/%1s%3d %-1.1s %2d %-1.1s %2d %-1.1s",local_legend[5],
               lb_pat_sex.arr,l_actual_dob_yn.arr, lb_pat_age_y,local_legend[12],lb_pat_age_m,local_legend[13],lb_pat_age_d,local_legend[14]);CR;
   fprint_repeat(fp,'-',162);CR;
fprintf(fp,"%-4.4s(%-5.5s)",local_legend[6],local_legend[7]);

lctr=lctr+10;
   
}

fetch_pat_name()
{
    int  get_patient_dtl(); 
	void get_referral_patient_dtl();
    int i = 0;
	char st[2];
	st[0] = lb_trn_hdr_episode_type;
	st[1] = '\0';
    if(lb_trn_hdr_episode_type == 'I' || lb_trn_hdr_episode_type == 'O' ||  lb_trn_hdr_episode_type == 'H')
    {
	  i=get_patient_dtl();
    } 
    else
    if(lb_trn_hdr_episode_type == 'R')
      get_referral_patient_dtl();
    }

fetch_consultant()
{
    /* EXEC SQL OPEN SY_PHYSICIAN_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )497;
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
    sqlstm.sqhstv[3] = (         void  *)&lb_hdr_consultant_code;
    sqlstm.sqhstl[3] = (unsigned int  )18;
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
         err_mesg("OPEN failed on cursor SY_PHYSICIAN_MAST_CUR",0,"");

    lb_consultant_long_name.arr[0] = '\0';
    lb_consultant_long_name.len    = 0;

    /* EXEC SQL FETCH SY_PHYSICIAN_MAST_CUR
              INTO lb_consultant_long_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )528;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&lb_consultant_long_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
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
         err_mesg("FETCH failed on cursor SY_PHYSICIAN_MAST_CUR",0,"");
   
    lb_consultant_long_name.arr[lb_consultant_long_name.len] = '\0';
}

fprint_repeat(l_fp,l_prn_chr,l_no)
FILE *l_fp;
char l_prn_chr;
int  l_no;
{
   int l_i = 0;

   for (l_i = 0;l_i < l_no;l_i++)
        fputc(l_prn_chr,l_fp);
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

rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';

    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, 'DATE :'||TO_CHAR(SYSDATE,'DD/MM/YY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY_LANG_VW
               WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			   AND   LANGUAGE_ID = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,('DATE :'||TO_CHAR(SYSDATE,'DD/MM\
/YY HH24:MI')) ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_E\
NTITY_ID=:b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )547;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&hosp_name;
    sqlstm.sqhstl[0] = (unsigned int  )302;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&date_time;
    sqlstm.sqhstl[1] = (unsigned int  )28;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&user_id;
    sqlstm.sqhstl[2] = (unsigned int  )42;
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



    if (OERROR)
      err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

    hosp_name.arr[hosp_name.len]           = '\0';
    date_time.arr[date_time.len]           = '\0';
    user_id.arr[user_id.len]               = '\0';
}

char *center(l_str,no)
char l_str[];
int no;
{
  char *arr;
  arr = (char *) ((malloc) (no+5));
  sprintf(arr,"%*s%s%*s",(no>>1)-(strlen(l_str)>>1),"",l_str,
          no-strlen(l_str)-((no>>1)-(strlen(l_str)>>1)),""); 
  return(arr);
}

end_of_rep()
{
    CR;
	fprintf(fp,"\n");
	   fprint_repeat(fp,'-',rec_ctr*20+20);CR;
	fprintf(fp,"\n");
        fprintf(fp,center("***  %-13.13s  ***",local_legend[8],132));

    CR;
}


/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{

    lb_pat_short_name.arr[0]     = '\0';
    lb_pat_sex.arr[0]            = '\0';
	l_actual_dob_yn.arr[0]		 = '\0';

    lb_pat_short_name.len         = 0;
    lb_pat_sex.len				  = 0;
	l_actual_dob_yn.len			  = 0;
	
    lb_pat_age_y = 0;
    lb_pat_age_m = 0;
    lb_pat_age_d = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT SUBSTR(SHORT_NAME,1,25), 			SEX,
           TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) yrs,
           TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)) -
                 TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) * 12 mnths,
           TRUNC(((MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH) -
                  TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) * 12) -
           TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH) -
                  TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) * 12)) * 30),
			DECODE(actual_dob_yn, 'Y', ' ', '*')
	    INTO   :lb_pat_short_name,:lb_pat_sex,:lb_pat_age_y,:lb_pat_age_m,:lb_pat_age_d,
				:l_actual_dob_yn
            FROM   RL_PATIENT_MAST  
	    WHERE  PATIENT_ID = :nd_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SUBSTR(SHORT_NAME,1,25) ,SEX ,TRUNC((MONTHS_BETWEEN(\
SYSDATE,DATE_OF_BIRTH)/12)) yrs ,(TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH))\
-(TRUNC((MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12))* 12)) mnths ,TRUNC((((MONT\
HS_BETWEEN(SYSDATE,DATE_OF_BIRTH)-(TRUNC((MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH\
)/12))* 12))-TRUNC((MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)-(TRUNC((MONTHS_BETWE\
EN(SYSDATE,DATE_OF_BIRTH)/12))* 12))))* 30)) ,DECODE(actual_dob_yn,'Y',' ','*'\
) into :b0,:b1,:b2,:b3,:b4,:b5  from RL_PATIENT_MAST where PATIENT_ID=:b6";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )582;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lb_pat_short_name;
  sqlstm.sqhstl[0] = (unsigned int  )63;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lb_pat_sex;
  sqlstm.sqhstl[1] = (unsigned int  )4;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lb_pat_age_y;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&lb_pat_age_m;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&lb_pat_age_d;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_actual_dob_yn;
  sqlstm.sqhstl[5] = (unsigned int  )4;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )23;
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


		/* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

    lb_pat_short_name.arr[lb_pat_short_name.len] = '\0';
    lb_pat_sex.arr[lb_pat_sex.len]				 = '\0';
	l_actual_dob_yn.arr[l_actual_dob_yn.len]	 = '\0';

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
   sqlstm.offset = (unsigned int  )625;
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
    lb_pat_short_name.arr[0]     = '\0';
    lb_pat_sex.arr[0]            = '\0';
	l_actual_dob_yn.arr[0]		 = '\0';
	
    lb_pat_short_name.len         = 0;
    lb_pat_sex.len				  = 0;
	l_actual_dob_yn.len			  = 0;

    lb_pat_age_y = 0;
    lb_pat_age_m = 0;
    lb_pat_age_d = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(SHORT_NAME,1,25),
			SEX,
           TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) yrs,
           TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)) -
                 TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) * 12 mnths,
           TRUNC(((MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH) -
                  TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) * 12) -
           TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH) -
                  TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12) * 12)) * 30),
				  DECODE(actual_dob_yn, 'Y', ' ', '*')
	    INTO   :lb_pat_short_name,:lb_pat_sex,:lb_pat_age_y,:lb_pat_age_m,:lb_pat_age_d,
				:l_actual_dob_yn
            FROM   MP_PATIENT_MAST 
	    WHERE  PATIENT_ID = :nd_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(SHORT_NAME,1,25) ,SEX ,TRUNC((MONTHS_BETWEEN\
(SYSDATE,DATE_OF_BIRTH)/12)) yrs ,(TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)\
)-(TRUNC((MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)/12))* 12)) mnths ,TRUNC((((MON\
THS_BETWEEN(SYSDATE,DATE_OF_BIRTH)-(TRUNC((MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRT\
H)/12))* 12))-TRUNC((MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)-(TRUNC((MONTHS_BETW\
EEN(SYSDATE,DATE_OF_BIRTH)/12))* 12))))* 30)) ,DECODE(actual_dob_yn,'Y',' ','*\
') into :b0,:b1,:b2,:b3,:b4,:b5  from MP_PATIENT_MAST where PATIENT_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )640;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&lb_pat_short_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&lb_pat_sex;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&lb_pat_age_y;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&lb_pat_age_m;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&lb_pat_age_d;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_actual_dob_yn;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[6] = (unsigned int  )23;
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


  if(NODATAFOUND)
     return 0;

    lb_pat_short_name.arr[lb_pat_short_name.len] = '\0';
    lb_pat_sex.arr[lb_pat_sex.len]				 = '\0';
	l_actual_dob_yn.arr[l_actual_dob_yn.len]	 = '\0';

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
   sqlstm.offset = (unsigned int  )683;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_patient_dtl() occured....\n");
   proc_exit();
}

/* ================ PRINT REPORT HEADER ONCE FOR THE REPORT =========*/
void print_rep_header()
{
  char nd_fr_process_date_desc[11],
       nd_to_process_date_desc[11];
	   

  if(strcmp(nd_dt_fm.arr, "01/01/1800") == 0)
    strcpy(nd_fr_process_date_desc, "LOWEST");
    else strcpy(nd_fr_process_date_desc, nd_dt_fm.arr);

  if(strcmp(nd_dt_to.arr, "31/12/4712") == 0)
      strcpy(nd_to_process_date_desc, "HIGHEST");
    else strcpy(nd_to_process_date_desc, nd_dt_to.arr);

  #ifdef DEBUG
      printf("before report header()\n");
  #endif

  print_page_header();

  #ifdef DEBUG
      printf("after page header()\n");  
  #endif
  //fprintf(fp,"--------------------------------------------------------------------");
  //fprintf(fp,"----------------------------------------------------------------");
  fprintf(fp,"\n");

  get_version_no();   ///// added 01.07.2003

////// 01.07.2003  fprintf(fp,VER);

  fprintf(fp,"%s\n",d_version.arr);

  fprintf(fp,"\n\n\n\n");
  /**********Commented by babu for globalization
  fprintf(fp,"        ");
  fprintf(fp,"INPUT PARAMETERS :\n");
  fprintf(fp,"        ");
  fprintf(fp,"------------------\n\n");
  fprintf(fp,"                ");
  fprintf(fp,"PATIENT ID        : %s\n", nd_patient_id.arr);
  fprintf(fp,"\n");
  fprintf(fp,"                ");
  fprintf(fp,"PERIOD       FROM : %s\n", nd_fr_process_date_desc);
  fprintf(fp,"                ");
  fprintf(fp,"               TO : %s\n", nd_to_process_date_desc); 
  ****************END ******************************/
/****************ADDED BY BABU FOR GLOBALIZATION*****************/


  rec_len = strlen(local_legend[4]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(fp,"%s :\n",local_legend[4]);
  rec_len = strlen(local_legend[4]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  print_space(40, rec_len,0);//added for globalisation
  fprintf(fp,"\n");

  rec_len = strlen(local_legend[2]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(fp,"%s : %s\n",local_legend[2],nd_patient_id.arr);
  

  rec_len = strlen(local_legend[9]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(fp,"%s : %s\n",local_legend[9],nd_fr_process_date_desc);
  rec_len = strlen(local_legend[10]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(fp,"%s : %s\n",local_legend[10],nd_to_process_date_desc);



  fprintf(fp,"\f");
}

/*=============== print_page_header =================*/
void print_page_header()
{

char buf[100];
fprintf(fp,"%c&l1O",ESC);
fprintf(fp, "%c(s14H", ESC);// Reduce the font size

/****************Commented by babu  for globalization
   fprintf(fp,"%sMDL : RL%s%s\n",
      (pctr > 1)?"\f":"",center(hosp_name.arr,152-date_time.len),date_time.arr);
   fprintf(fp,"OPR : %-10s \n", user_id.arr);
   fprintf(fp,"REP : %-8s%sPAGE : %4d\n",g_pgm_id,
        center("Cumulative Summary Report with Date/Time in X-axis",126),pctr);
   fprint_repeat(fp,'-',162);CR;
   *****************************END***********************/
   /**********************Added by babu for globalization****************************/
		
		memset(hdr_line1,' ',REP_WIDTH+1);
        strncpy(hdr_line1,"MDL:RL",6);
        col = (int)(REP_WIDTH - strlen(hosp_name.arr))/2;
        strncpy(hdr_line1 + col -1,hosp_name.arr,strlen(hosp_name.arr));
        
		/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				t_date:=GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				:date_time1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET\
_CURRENT_DATE ( :language_id ) ; :date_time1 := to_char ( t_date , 'DD/MM/YYYY\
 HH24:MI' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )698;
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
  sqlstm.sqhstv[1] = (         void  *)&date_time1;
  sqlstm.sqhstl[1] = (unsigned int  )28;
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


		col = (REP_WIDTH-strlen(date_time1.arr));
		
		strcpy(hdr_line1+col,date_time1.arr);
		
		fprintf(fp,hdr_line1);
		fprintf(fp,"\n");

/**********************end by babu for globalization****************************/  
 /**********************Added by babu for globalization****************************/
 memset(hdr_line2,' ',REP_WIDTH+1);
  
  strncpy(hdr_line2,"OPR:",4);
  strncpy(hdr_line2+4,user_id.arr,strlen(user_id.arr));
  strcpy(rep_title1, local_legend[11] );
  col = (int)(REP_WIDTH-strlen(rep_title1))/2;
  strncpy(hdr_line2+col,rep_title1,strlen(rep_title1));

  sprintf(buf,"%s : %4d",local_legend[1],pctr++);
  
  strcpy(hdr_line2+(REP_WIDTH-strlen(buf)),buf);//babu
  
  fprintf(fp,hdr_line2);
  
  fprintf(fp,"\n");
  fprintf(fp,"REP:RLRCUMRD");
  
  fprintf(fp,"\n");
  

/**********************end by babu for globalization****************************/  

  
}

////////////////// 

move_to_column(col_printed,col_to_be_printed) /* this is to obtain required blank space */
int col_printed,col_to_be_printed;
{
	int i;
	for(i=0;i<(col_to_be_printed-(col_printed+1))*20;i++)fprintf(fp," ");
}

get_page_head_time()
{
 open_hdr();

      while(fetch_hdr())
      {
	  
	     fprintf(fp,"%20s",lb_hdr_spec_regd_date_time.arr);
         
	   }
}
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
  sqlstm.offset = (unsigned int  )721;
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
     sqlstm.offset = (unsigned int  )740;
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

/*--------- added the below on 19.02.2006 -------------------------------------*/
get_test_units_desc_from_sy_uom()
{

   lb_loc_test_code_units_desc.arr[0]		= '\0';        
   lb_loc_test_code_units_desc.len		= 0;

   /* EXEC SQL SELECT  short_desc
			  INTO :lb_loc_test_code_units_desc
		  	  FROM SY_UOM_LANG_VW
			 WHERE uom_code = :lb_loc_test_code_units
			 AND   LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from SY_UOM_LANG_VW where (uom\
_code=:b1 and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )759;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&lb_loc_test_code_units_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&lb_loc_test_code_units;
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



	if (NODATAFOUND)
	{
		strcpy(lb_loc_test_code_units_desc.arr,lb_loc_test_code_units.arr);    
		lb_loc_test_code_units_desc.len = strlen(lb_loc_test_code_units_desc.arr);
//		rl_tst_cd_test_units_desc.arr[rl_tst_cd_test_units_desc.len]	= '\0';

	}

    if (OERROR)
	{
		strcpy(lb_loc_test_code_units_desc.arr,lb_loc_test_code_units.arr);    
		lb_loc_test_code_units_desc.len = strlen(lb_loc_test_code_units_desc.arr);
	}

	lb_loc_test_code_units_desc.arr[lb_loc_test_code_units_desc.len]	= '\0';

}
/*------------------------------------------------------------*/
