
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
           char  filnam[24];
};
static const struct sqlcxp sqlfpn =
{
    23,
    "c:\\rlrshist\\rlrshist.pc"
};


static unsigned long sqlctx = 583155723;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {10,17};

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

 static const char *sq0017 = 
"select A.section_code ,DECODE(A.urgent_indicator,'R',:b0,'S',:b1,'U',:b2,:b0\
) ,to_char(A.spec_regd_date_time,'dd/mm/yyyy') ,to_number(to_char(A.spec_regd_\
date_time,'sssss')) ,A.specimen_no ,A.status  from rl_request_header A where (\
((((((A.operating_facility_id=:b4 and A.SPEC_REGD_DATE_TIME>=to_date(:b5,'dd/m\
m/yyyy hh24:mi')) and A.SPEC_REGD_DATE_TIME<to_date(:b6,'dd/mm/yyyy hh24:mi'))\
 and A.section_code between NVL(:b7,'!') and NVL(:b8,'~')) and A.source_type=d\
ecode(:b9,'!',a.source_type,:b9)) and A.source_code=decode(:b11,'~~~~~~',a.sou\
rce_code,:b11)) and A.URGENT_INDICATOR=decode(:b13,'!',a.URGENT_INDICATOR,:b13\
)) and NVL(A.cancelled_yn,'N')<>'Y') order by 1,TRUNC(A.spec_regd_date_time),2\
            ";

 static const char *sq0018 = 
"select A.section_code ,DECODE(A.urgent_indicator,'R',:b0,'S',:b1,'U',:b2,:b0\
) ,to_char(A.spec_regd_date_time,'dd/mm/yyyy') ,to_number(to_char(A.spec_regd_\
date_time,'sssss')) ,A.specimen_no ,B.test_code ,B.result_status  from rl_requ\
est_detail B ,rl_request_header A where (((((((((((B.specimen_no=A.specimen_no\
 and B.operating_facility_id=:b4) and B.operating_facility_id=A.operating_faci\
lity_id) and B.test_code=decode(:b5,'~~~~~~~~~~',B.test_code,:b5)) and A.SPEC_\
REGD_DATE_TIME>=to_date(:b7,'dd/mm/yyyy hh24:mi')) and A.SPEC_REGD_DATE_TIME<t\
o_date(:b8,'dd/mm/yyyy hh24:mi')) and A.section_code between NVL(:b9,'!') and \
NVL(:b10,'~')) and A.source_type=decode(:b11,'!',A.source_type,:b11)) and A.so\
urce_code=decode(:b13,'~~~~~~',A.source_code,:b13)) and A.urgent_indicator=dec\
ode(:b15,'!',A.urgent_indicator,:b15)) and NVL(A.cancelled_yn,'N')<>'Y') and N\
VL(B.cancelled_yn,'N')<>'Y') order by 1,TRUNC(A.spec_regd_date_time),2        \
    ";

 static const char *sq0019 = 
"select A.section_code ,DECODE(A.urgent_indicator,'R',:b0,'S',:b1,'U',:b2,:b0\
) ,to_char(A.spec_regd_date_time,'dd/mm/yyyy') ,to_number(to_char(A.spec_regd_\
date_time,'sssss')) ,A.specimen_no ,B.test_code ,B.status  from rl_test_result\
 B ,rl_request_header A where (((((((((((B.specimen_no=A.specimen_no and B.ope\
rating_facility_id=:b4) and B.operating_facility_id=A.operating_facility_id) a\
nd B.test_code=decode(:b5,'~~~~~~~~~~',B.test_code,:b5)) and A.spec_regd_date_\
time>=to_date(:b7,'dd/mm/yyyy hh24:mi')) and A.SPEC_REGD_DATE_TIME<to_date(:b8\
,'dd/mm/yyyy hh24:mi')) and A.section_code between NVL(:b9,'!') and NVL(:b10,'\
~')) and A.source_type=decode(:b11,'!',A.source_type,:b11)) and A.source_code=\
decode(:b13,'~~~~~~',a.source_code,:b13)) and A.urgent_indicator=decode(:b15,'\
!',A.urgent_indicator,:b15)) and NVL(A.cancelled_yn,'N')<>'Y') and NVL(B.cance\
lled_yn,'N')<>'Y') order by 1,TRUNC(A.spec_regd_date_time),2            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,208,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,232,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,240,0,0,0,0,0,1,0,
66,0,0,4,140,0,6,269,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
93,0,0,5,140,0,6,286,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
120,0,0,6,156,0,6,312,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
143,0,0,7,187,0,4,406,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
186,0,0,8,109,0,2,442,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
209,0,0,9,0,0,32,450,0,0,0,0,0,1,0,
224,0,0,10,150,0,4,467,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
259,0,0,11,0,0,32,491,0,0,0,0,0,1,0,
274,0,0,12,120,0,6,645,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
297,0,0,13,136,0,6,660,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
320,0,0,14,269,0,4,690,0,0,5,1,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,1,9,0,0,
355,0,0,15,203,0,4,704,0,0,4,0,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,
386,0,0,16,0,0,32,718,0,0,0,0,0,1,0,
401,0,0,17,712,0,9,751,0,0,15,15,0,1,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
476,0,0,18,938,0,9,782,0,0,17,17,0,1,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
559,0,0,19,928,0,9,812,0,0,17,17,0,1,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
642,0,0,20,0,0,32,823,0,0,0,0,0,1,0,
657,0,0,17,0,0,13,852,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,
696,0,0,18,0,0,13,864,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
739,0,0,19,0,0,13,876,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
782,0,0,17,0,0,15,909,0,0,0,0,0,1,0,
797,0,0,18,0,0,15,915,0,0,0,0,0,1,0,
812,0,0,19,0,0,15,920,0,0,0,0,0,1,0,
827,0,0,21,0,0,32,926,0,0,0,0,0,1,0,
842,0,0,22,201,0,4,939,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
873,0,0,23,227,0,4,953,0,0,5,4,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
908,0,0,24,108,0,4,967,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,
935,0,0,25,100,0,4,1178,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
962,0,0,26,94,0,4,1192,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
989,0,0,27,148,0,6,1311,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1016,0,0,28,101,0,6,1395,0,0,1,1,0,1,0,2,3,0,0,
1035,0,0,29,49,0,4,1408,0,0,1,0,0,1,0,2,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: rlrshist.pc
   Author : Amjad Saiyed
   Date Created  : 10/06/2001
   Last Modified : 10/06/2001

*  Ver 1.10.01
   
*  Purpose : To generate a report for Shift Wise Statistics of Specimens Received 

*  Input Parameters :    
              Command line inputs
	
		      1. Usr_id/Password
              2. Session id
		      3. Program Date
                 Parameters from SY_PROG_PARAM table 
              4. Preferred range of Section Codes.
  
*  Table Accessed : RL_REQUEST_HEADER,RL_TEST_RESULT,
					RL_SECTION_CODE, RL_ONLINE_INSTRUMENT,
					RL_ONLINE_INSTRUMENT_TEST,
					OP_CLINIC, IP_WARD, RL_REFERRAL
		    

*  Output File : rlrshist.lis
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <rl.h> 
#include <gl.h>
#define REP_WIDTH 78
#define MAX_LINES 50
#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 

/* INPUT PARAMETERS TO MAIN */

	/* VARCHAR  nd_operating_facility_id [3],
	         uid_pwd		          [91],
		     nd_user_id               [31],
		     nd_session_id            [16],
		     nd_pgm_date	          [20], 
		     nd_user                  [15],
             nd_file_no               [15],
		     nd_file_name		      [150],
			 d_version_no			  [20],
			 l_malaysia_yn            [2],
			 d_version  			  [20],
			 l_translated_value		 [100],
		       language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[2]; } l_malaysia_yn;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;



/* Fields from table RL_SECTION_CODE */
	 /* varchar      d_printer_name            [16]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_printer_name;


/* Fields from table SY_ACC_ENTITY*/
	/* varchar 	d_acc_entity_name        [300],
				//d_acc_entity_name        [61], 
				d_user                   [21],
				d_sysdate                [17],
				d_sysdate1                [17]; */ 
struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;


 /*INPUT PARAMETERS FROM SY_PROG_PARAM TABLE */
	/* varchar nd_fm_section_code			[2],
			nd_to_section_code			[2],
	 		nd_fm_date					[17],	/o Modified length 11 to 17 against CRF-20236 by Durai Rajkumar on 24-Nov-08 o/
			nd_fm_date1					[17],	/o Modified length 11 to 17 against CRF-20236 by Durai Rajkumar on 24-Nov-08 o/
			nd_to_date					[17],	/o Modified length 11 to 17 against CRF-20236 by Durai Rajkumar on 24-Nov-08 o/
			nd_to_date1					[17],	/o Modified length 11 to 17 against CRF-20236 by Durai Rajkumar on 24-Nov-08 o/
			nd_source_type				[2],
			nd_source_from				[10],
			nd_priority					[2],
			nd_test_code				[11],
			nd_test_desc				[61],	/o Added by Durai Rajkumar against CRF-20236 on 24-Nov-08 o/
			nd_group_test_yn			[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_fm_section_code;

struct { unsigned short len; unsigned char arr[2]; } nd_to_section_code;

struct { unsigned short len; unsigned char arr[17]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[17]; } nd_fm_date1;

struct { unsigned short len; unsigned char arr[17]; } nd_to_date;

struct { unsigned short len; unsigned char arr[17]; } nd_to_date1;

struct { unsigned short len; unsigned char arr[2]; } nd_source_type;

struct { unsigned short len; unsigned char arr[10]; } nd_source_from;

struct { unsigned short len; unsigned char arr[2]; } nd_priority;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code;

struct { unsigned short len; unsigned char arr[61]; } nd_test_desc;

struct { unsigned short len; unsigned char arr[2]; } nd_group_test_yn;



/* SQL statement storing in this Variable */
   char sql_stmt	[500] ;

	/* varchar d_section_code			[2],
            d_urgent_indicator      [10],
			d_prev_urgent_ind       [10],
			d_section_desc			[41],
			d_prev_section_code		[2],
			d_specimen_no			[21],
			d_specimen_date			[11],
			d_prev_specimen_date	[11],
			d_prev_specimen_date1	[11],
			d_print_specimen_date	[11],
			d_test_code				[11],
			d_status				[2],
			l_hmc_yn                [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_section_code;

struct { unsigned short len; unsigned char arr[10]; } d_urgent_indicator;

struct { unsigned short len; unsigned char arr[10]; } d_prev_urgent_ind;

struct { unsigned short len; unsigned char arr[41]; } d_section_desc;

struct { unsigned short len; unsigned char arr[2]; } d_prev_section_code;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } d_specimen_date;

struct { unsigned short len; unsigned char arr[11]; } d_prev_specimen_date;

struct { unsigned short len; unsigned char arr[11]; } d_prev_specimen_date1;

struct { unsigned short len; unsigned char arr[11]; } d_print_specimen_date;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_status;

struct { unsigned short len; unsigned char arr[2]; } l_hmc_yn;


long l_shift_1_start_time,
	 l_shift_2_start_time,
	 l_shift_3_start_time;

long l_specimen_time;

long l_analyzer_count;

int l_count = 0;

int  l_tab_exists ;
int i;
char local_legend[100][100];


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
 
char string_var[100] ;

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char rep_title1[60] ;
char rep_title2[40];
int rec_len;

int line_no = 0;
int page_no = 0 ;

int d_request_1 = 0, d_analyzer_1 = 0, d_reported_1 = 0,
	d_request_2 = 0, d_analyzer_2 = 0, d_reported_2 = 0,
	d_request_3 = 0, d_analyzer_3 = 0, d_reported_3 = 0;

long t_request_1 = 0, t_analyzer_1 = 0, t_reported_1 = 0,
	t_request_2 = 0, t_analyzer_2 = 0, t_reported_2 = 0,
	t_request_3 = 0, t_analyzer_3 = 0, t_reported_3 = 0;

long g_request_1 = 0, g_analyzer_1 = 0, g_reported_1 = 0,
	g_request_2 = 0, g_analyzer_2 = 0, g_reported_2 = 0,
	g_request_3 = 0, g_analyzer_3 = 0, g_reported_3 = 0;


FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
    void gen_file_name() ;
    void get_header_dtls() ;
	void get_shifts();

   if(argc < 14) {
     disp_message(ORA_MESG,"Usage rlrshist uid/passwd pgm_date from section code to section code from date to date\n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr); 

   strcpy(OUTPUT_FILE_NAME, argv[5]);

   strcpy(nd_fm_section_code.arr, argv[6]);
   nd_fm_section_code.len = strlen(nd_fm_section_code.arr); 

   strcpy(nd_to_section_code.arr, argv[7]);
   nd_to_section_code.len =	 strlen(nd_to_section_code.arr); 

   strcpy(nd_fm_date.arr, argv[8]);
   nd_fm_date.len = strlen(nd_fm_date.arr); 

   strcpy(nd_to_date.arr, argv[9]);
   nd_to_date.len = strlen(nd_to_date.arr); 

   strcpy(nd_source_type.arr,argv[10]);
   nd_source_type.len = strlen(nd_source_type.arr);
   				
   strcpy(nd_source_from.arr,argv[11]);
   nd_source_from.len = strlen(nd_source_from.arr);
      
   strcpy(nd_priority.arr,argv[12]);
   nd_priority.len = strlen(nd_priority.arr);

   strcpy(nd_test_code.arr,argv[13]);
   nd_test_code.len = strlen(nd_test_code.arr);
   				
   strcpy(nd_group_test_yn.arr,argv[14]);
   nd_group_test_yn.len = strlen(nd_group_test_yn.arr); 
   				

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

  

   if(OERROR)
      disp_message(ORA_MESG,"Failed to connect using : \n");

    #ifdef DEBUG
      printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
    #endif  
    
	set_meduser_role();
	strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	get_legend_value(29);
	get_shifts();

	get_header_dtls() ;

	gen_file_name(); 

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


/********************* CHECK PAGE BREAK ************************/
chk_break(nol)
{
   if ((line_no + nol) >= MAX_LINES)
   {
	 form_hdr();
	 print_column_heading();
   }
}

/********************* FORM HDR ************************/
form_hdr()
{

    static int first = 1;
    char buf[15];
    int col;
    
        strcpy(rep_title2, local_legend[14] );
        //Added by babu---------
		
        
		
		/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				/o Added time portion against CRF-20236 by Durai Rajkumar on 24-Nov-08 o/
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_fm_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:nd_fm_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:nd_fm_date1 :=sm_convert_datetime_2t(to_date(:nd_fm_date,'DD/MM/YYYY HH24:MI'),:language_id);
				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :nd_fm_date1 := sm_convert_date\
time_2t ( to_date ( :nd_fm_date , 'DD/MM/YYYY HH24:MI' ) , :language_id ) ; EN\
D ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )66;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_fm_date1;
  sqlstm.sqhstl[0] = (unsigned int  )19;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
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
		strcat(rep_title2, " ");
		strcat(rep_title2, nd_fm_date1.arr);
        strcat(rep_title2, " ");
		strcat(rep_title2,  local_legend[4] );
		/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				/o Added time portion against CRF-20236 by Durai Rajkumar on 24-Nov-08 o/
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_to_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:nd_to_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:nd_to_date1 :=sm_convert_datetime_2t(to_date(:nd_to_date,'DD/MM/YYYY HH24:MI'),:language_id);
				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :nd_to_date1 := sm_convert_date\
time_2t ( to_date ( :nd_to_date , 'DD/MM/YYYY HH24:MI' ) , :language_id ) ; EN\
D ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )93;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_to_date1;
  sqlstm.sqhstl[0] = (unsigned int  )19;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
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


		strcat(rep_title2, " ");
		strcat(rep_title2, nd_to_date1.arr);
       
		
    if(first) 
	{
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
        memset(hdr_line4,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL:RL",6);
		col = (int)(REP_WIDTH - strlen(d_acc_entity_name.arr))/2;
        //strncpy(hdr_line1 + col-1 ,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr)); 
		strncpy(hdr_line1 + col ,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));// Added by srinivas
        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				t_date:=GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				END;

			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE\
 . GET_CURRENT_DATE ( :language_id ) ; :d_sysdate1 := to_char ( t_date , 'DD/M\
M/YYYY HH24:MI' ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )120;
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
        sqlstm.sqhstv[1] = (         void  *)&d_sysdate1;
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
}


		col = (REP_WIDTH-strlen(d_sysdate1.arr));
		strcpy(hdr_line1+col,d_sysdate1.arr);
    
        strncpy(hdr_line2,"OPR:",4);
        strcpy(hdr_line2+4,d_user.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP:RLRSHIST",12);
    strcpy(rep_title1, local_legend[21] );
	col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"%s : %4d",local_legend[1],page_no++);
	strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);
    col = (int)(REP_WIDTH-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    if(first)
        fprintf(f1,"%s\n",hdr_line1);
    else
        fprintf(f1,"\f\n%s\n",hdr_line1);

    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
    fprintf(f1,"%s\n",hdr_line4);
    fprintf(f1,"%s\n",hdr_line5);

    first = 0;
	line_no = 5;
return 1;
}

/********************* PRINT END OF REPORT ************************/
print_end_of_rep()
{
    int col;
    char buff[REP_WIDTH+1];

    memset(buff,' ',REP_WIDTH+1);
    col = (int)(REP_WIDTH-19)/2;

    strncpy(buff+col,"** END OF REPORT **",19);
    fprintf(f1,"\n%s\n",buff);
}

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


/************* get_params ***************/
void get_params()
{
	nd_fm_section_code.arr[0] 		= '\0';
	nd_fm_section_code.len			= 0 ;
	nd_to_section_code.arr[0]		= '\0' ;
	nd_to_section_code.len			= 0;
	nd_fm_date.arr[0]				= '\0' ;
	nd_fm_date.len					= 0 ;
	nd_to_date.arr[0]				= '\0' ;
	nd_to_date.len					= 0 ;	

   if(OERROR)
      disp_message(ORA_MESG,"get parameter function using : \n");

   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
                   PARAM1,
				   PARAM2,
				   PARAM3,
				   PARAM4
		    INTO 
				:nd_operating_facility_id,
				:nd_fm_section_code ,  
				:nd_to_section_code ,
				:nd_fm_date ,
				:nd_to_date 
         FROM SY_PROG_PARAM
	     WHERE   UPPER(PGM_ID) = 'RLRSHIST'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 into :b0,:b1,:b2,:b3,:b4  from SY_PROG_PARAM where ((UPPER(PGM_ID)='RLRSHIS\
T' and SESSION_ID=TO_NUMBER(:b5)) and PGM_DATE=:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )143;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_section_code;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[3] = (unsigned int  )19;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[4] = (unsigned int  )19;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[5] = (unsigned int  )18;
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



   
	/*strcpy(first_date.arr,nd_fm_date.arr) ;*/
   if(OERROR)
      disp_message(ORA_MESG,"get_parameter_function2 : \n");
   
  nd_fm_section_code.arr[nd_fm_section_code.len] 		= '\0';
  nd_to_section_code.arr[nd_to_section_code.len]		= '\0';
  nd_fm_date.arr[nd_fm_date.len]						= '\0';
  nd_to_date.arr[nd_to_date.len]						= '\0';

  #ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" nd_fm_section_code = %s\n",nd_fm_section_code.arr);
   printf(" nd_to_section_code = %s\n",nd_to_section_code.arr);
   printf(" nd_fm_date = %s\n",nd_fm_date.arr);
   printf(" nd_to_date = %s\n",nd_to_date.arr);
   getchar();  
#endif
  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
	   WHERE UPPER(PGM_ID) = 'RLRSHIST'
	         AND SESSION_ID = TO_NUMBER(:nd_session_id)
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLRSHIS\
T' and SESSION_ID=TO_NUMBER(:b0)) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )186;
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
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )209;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_params() occured....\n");
   proc_exit();
}

/************ GET_HEADER_DETAILS****************/
void get_header_dtls()
{
     d_acc_entity_name.arr[0]   = '\0';
	 d_acc_entity_name.len		= 0;
	 d_user.arr[0]				= '\0';
	 d_user.len                 = 0;
	 d_sysdate.arr[0]			= '\0';
	 d_sysdate.len              = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL SELECT ACC_ENTITY_NAME,
		       USER,
		       TO_CHAR(SYSDATE, 'DD/MM/YYYY')
	    INTO :d_acc_entity_name,
		 :d_user,
		 :d_sysdate
             FROM SY_ACC_ENTITY_LANG_VW
             WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			 AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY'\
) into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b3 and LA\
NGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )224;
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
   sqlstm.sqhstl[1] = (unsigned int  )23;
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
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )259;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}

/*************** GENERATE FILE NAME ***************/
void gen_file_name()
{

 	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_file_name.arr,"rlrshist.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);

	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
}

/*********** PRINT REPORT HEADER **************/
void print_rep_header()
{
  char nd_fm_section_desc[10],
       nd_to_section_desc[10],
	   nd_source_type_desc[10],
	   nd_source_from_desc[10],
	   nd_priority_desc[10],
	   nd_test_code_desc[11];	/* Added by Durai Rajkumar against CRF-20236 on 24-Nov-08 */

  form_hdr();

  if (strcmp(nd_fm_section_code.arr, "!") == 0)
       strcpy(nd_fm_section_desc, "LOWEST");
  else strcpy(nd_fm_section_desc, nd_fm_section_code.arr);

 
  if (strcmp(nd_to_section_code.arr, "~") == 0)
       strcpy(nd_to_section_desc, "HIGHEST");
  else strcpy(nd_to_section_desc, nd_to_section_code.arr);

  if (strcmp(nd_source_type.arr, "!") == 0)
       strcpy(nd_source_type_desc, local_legend[26]);
  else
	   strcpy(nd_source_type_desc, nd_source_type.arr);

  if (strcmp(nd_source_from.arr, "~~~~~~") == 0)
       strcpy(nd_source_from_desc, local_legend[26]);
  else
       strcpy(nd_source_from_desc,nd_source_from.arr );

  if (strcmp(nd_priority.arr, "!") == 0)
       strcpy(nd_priority_desc, local_legend[26]);
  else
       strcpy(nd_priority_desc,nd_priority.arr);
  
  /* Added by Durai Rajkumar against CRF-20236 on 24-Nov-08 */
  if (strcmp(nd_test_code.arr, "~~~~~~~~~~") == 0)
	 strcpy(nd_test_code_desc, local_legend[26]);
  else
    strcpy(nd_test_code_desc,nd_test_code.arr);
  /* Ends against CRF-20236 */
  get_version_no();  
  
  fprintf(f1,"%s\n",d_version.arr);

  fprintf(f1,"\n\n\n\n");
  //fprintf(f1,"        ");
  //fprintf(f1,"%s :\n",local_legend[2]);
  //fprintf(f1,"        ");
  //fprintf(f1,"------------------\n\n");
  //fprintf(f1,"                ");
  rec_len = strlen(local_legend[2]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  fprintf(f1,"%s:\n", local_legend[2]);//added for glob
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  print_space(20, rec_len,0);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  fprintf(f1,"\n\n");
  //fprintf(f1,"                               ");
  rec_len = strlen(local_legend[3]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  //fprintf(f1,"DEPARTMENT FROM : %s\n",local_legend[12], nd_fm_section_desc)
  fprintf(f1,"%s : %s\n",local_legend[3], nd_fm_section_desc); 
  rec_len = strlen(local_legend[4]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  //fprintf(f1,"TO : %s\n", nd_to_section_desc);
  fprintf(f1,"%s : %s\n", local_legend[4],nd_to_section_desc);
  //fprintf(f1,"                ");
  //fprintf(f1,"PERIOD       FROM : %s\n", nd_fm_date1.arr);
  rec_len = strlen(local_legend[25]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  
  fprintf(f1,"%s : %s\n",local_legend[25], nd_fm_date1.arr);
  //fprintf(f1,"                               ");
  //fprintf(f1,"TO : %s\n", nd_to_date.arr);
  //fprintf(f1,"                      ");
  rec_len = strlen(local_legend[4]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  fprintf(f1,"%s : %s\n",local_legend[4], nd_to_date1.arr);
  rec_len = strlen(local_legend[15]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  fprintf(f1,"%s : %s\n",local_legend[15], nd_source_type_desc);
  //fprintf(f1,"                      ");
  rec_len = strlen(local_legend[15]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  fprintf(f1,"%s : %s\n",local_legend[16], nd_source_from_desc);
  //fprintf(f1,"                         ");
  rec_len = strlen(local_legend[17]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation	/* Modified length 40 to 20 against CRF-20236 by Durai Rajkumar on 24-Nov-08 */
  fprintf(f1,"%s : %s\n",local_legend[17], nd_priority_desc);
  /* Added by Durai Rajkumar against CRF-20236 on 24-Nov-08 */
  rec_len = strlen(local_legend[29]);//added for globalisation
  print_space(20, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s",local_legend[29], nd_test_code_desc);
  if (strcmp(nd_test_code.arr, "~~~~~~~~~~") != 0)
  get_test_desc();
  fprintf(f1,"   %s\n",nd_test_desc.arr);
  /*Ends against CRF-20236 */
  fprintf(f1,"\n");
}

/***************PRINT  COLUMN HEADING *************/
print_column_heading()
{
 if (strcmp(l_malaysia_yn.arr, "Y") == 0)
 {
   fprintf(f1,"%-4.4s       %-8.8s       %-5.5s 1              %-5.5s 2             %-5.5s 3\n",local_legend[5],local_legend[17],local_legend[6],local_legend[6],local_legend[6]);
   fprintf(f1,"------------------------------------------------------------------------------\n");
   fprintf(f1,"                      <- %10.10s->     <- %10.10s->     <- %10.10s->\n",local_legend[7],local_legend[7],local_legend[7]);
   fprintf(f1,"                     %-3.3s        %-4.4s     %-3.3s        %-4.4s     %-3.3s        %-4.4s\n",local_legend[18],local_legend[19],local_legend[18],local_legend[19],local_legend[18],local_legend[19]);
   fprintf(f1,"------------------------------------------------------------------------------\n");
 }
 else
 {
   fprintf(f1,"%-4.4s                     %-5.5s 1              %-5.5s 2             %-5.5s 3\n",local_legend[5],local_legend[6],local_legend[6],local_legend[6]);
   fprintf(f1,"------------------------------------------------------------------------------\n");
   fprintf(f1,"                      <- %10.10s->     <- %10.10s->     <- %10.10s->\n",local_legend[7],local_legend[7],local_legend[7]);
   fprintf(f1,"                      %-3.3s  %-4.4s  %-4.4s     %-3.3s  %-4.4s  %-4.4s     %-3.3s  %-4.4s  %-4.4s\n",local_legend[18],local_legend[19],local_legend[20],local_legend[18],local_legend[19],local_legend[20],local_legend[18],local_legend[19],local_legend[20]);
   fprintf(f1,"------------------------------------------------------------------------------\n");
 }

 line_no += 5;
return 1;
}

/************get_legend_value*******************/
get_legend_value(int cou)
 {
     
   
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRSHIST.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRSHIST.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )274;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRSHIST.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRSHIST.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )297;
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

	//disp_message(ERR_MESG,local_legend[i]);

	}
	

 }

/**********end********************8/
/************* get_shifts ***************/
void get_shifts()
{

	l_shift_1_start_time = 0;
	l_shift_2_start_time = 0;
	l_shift_3_start_time = 0;
	l_hmc_yn.arr[0]      = '\0';
	l_hmc_yn.len         = 0;

   /* EXEC SQL SELECT to_number(to_char(A.shift_1_start_time,'SSSSS')), 
				   to_number(to_char(A.shift_2_start_time,'SSSSS')), 
	     		   to_number(to_char(A.shift_3_start_time,'SSSSS')),
				   NVL(B.hmc_yn, 'N') 
			INTO   :l_shift_1_start_time, 
				   :l_shift_2_start_time,
      		       :l_shift_3_start_time,
				   :l_hmc_yn
	        FROM   rl_param B, RL_PARAM_FOR_FACILITY A
	   WHERE operating_facility_id = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select to_number(to_char(A.shift_1_start_time,'SSSSS')) ,t\
o_number(to_char(A.shift_2_start_time,'SSSSS')) ,to_number(to_char(A.shift_3_s\
tart_time,'SSSSS')) ,NVL(B.hmc_yn,'N') into :b0,:b1,:b2,:b3  from rl_param B ,\
RL_PARAM_FOR_FACILITY A where operating_facility_id=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )320;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_shift_1_start_time;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_shift_2_start_time;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_shift_3_start_time;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_hmc_yn;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
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



   if(OERROR)
   {
		/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	   /* EXEC SQL SELECT to_number(to_char(shift_1_start_time,'SSSSS')), 
				       to_number(to_char(shift_2_start_time,'SSSSS')), 
               		   to_number(to_char(shift_3_start_time,'SSSSS')),
			     	   NVL(hmc_yn, 'N') 
				INTO   :l_shift_1_start_time, 
					   :l_shift_2_start_time,
      				   :l_shift_3_start_time,
					   :l_hmc_yn
				  FROM RL_PARAM; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select to_number(to_char(shift_1_start_time,'SSSSS')) ,to\
_number(to_char(shift_2_start_time,'SSSSS')) ,to_number(to_char(shift_3_start_\
time,'SSSSS')) ,NVL(hmc_yn,'N') into :b0,:b1,:b2,:b3  from RL_PARAM ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )355;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_shift_1_start_time;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_shift_2_start_time;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_shift_3_start_time;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_hmc_yn;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


   }
   l_hmc_yn.arr[l_hmc_yn.len] = '\0';
return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )386;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"No Shifts Defined...Exiting..\n");
   proc_exit();
}

/********* DECLARE SHIFT CURSOR **********/
 dclr_shift_cursor()
 {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	if (strcmp(nd_test_code.arr,"~~~~~~~~~~") == 0) 
	{
		/* EXEC SQL DECLARE shift_cursor0 CURSOR FOR
                 SELECT A.section_code, 
						DECODE(A.urgent_indicator, 'R', :local_legend[22],'S',:local_legend[23],'U',:local_legend[24], :local_legend[22]),
						to_char(A.spec_regd_date_time,'dd/mm/yyyy'),
                        to_number(to_char(A.spec_regd_date_time,'sssss')),
                        A.specimen_no,
                 		A.status
                 FROM   rl_request_header A
                 WHERE  A.operating_facility_id = :nd_operating_facility_id
                 AND    A.SPEC_REGD_DATE_TIME >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi')		/o Time Portion is added against CRF-20236o/
                 --AND    A.SPEC_REGD_DATE_TIME < to_date(:nd_to_date,'dd/mm/yyyy hh24:mi') + 1	/o Time Portion is added against CRF-20236o/
				 AND    A.SPEC_REGD_DATE_TIME < to_date(:nd_to_date,'dd/mm/yyyy hh24:mi') --MODIFIED AGAINIST DATE RANGE ISSUE	ON 01/12/2010
                 AND    A.section_code BETWEEN NVL(:nd_fm_section_code, '!')
								  AND NVL(:nd_to_section_code, '~')
                 AND    A.source_type = decode(:nd_source_type,'!',a.source_type,:nd_source_type)
                 AND    A.source_code = decode(:nd_source_from,'~~~~~~',a.source_code,:nd_source_from)
                 AND    A.URGENT_INDICATOR = decode(:nd_priority,'!',a.URGENT_INDICATOR,:nd_priority)
                 AND    NVL(A.cancelled_yn,'N') <> 'Y'
                 ORDER BY 1, TRUNC(A.spec_regd_date_time), 2; */ 


		/* EXEC SQL OPEN shift_cursor0; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0017;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )401;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)local_legend[22];
  sqlstm.sqhstl[0] = (unsigned int  )100;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)local_legend[23];
  sqlstm.sqhstl[1] = (unsigned int  )100;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)local_legend[24];
  sqlstm.sqhstl[2] = (unsigned int  )100;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)local_legend[22];
  sqlstm.sqhstl[3] = (unsigned int  )100;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[5] = (unsigned int  )19;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[6] = (unsigned int  )19;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fm_section_code;
  sqlstm.sqhstl[7] = (unsigned int  )4;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_section_code;
  sqlstm.sqhstl[8] = (unsigned int  )4;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_source_type;
  sqlstm.sqhstl[9] = (unsigned int  )4;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_source_type;
  sqlstm.sqhstl[10] = (unsigned int  )4;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_source_from;
  sqlstm.sqhstl[11] = (unsigned int  )12;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_source_from;
  sqlstm.sqhstl[12] = (unsigned int  )12;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_priority;
  sqlstm.sqhstl[13] = (unsigned int  )4;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_priority;
  sqlstm.sqhstl[14] = (unsigned int  )4;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
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
		if (strcmp(nd_group_test_yn.arr,"G") == 0) 
		{
		/* EXEC SQL DECLARE shift_cursor1 CURSOR FOR
                 SELECT A.section_code, 
						DECODE(A.urgent_indicator, 'R', :local_legend[22],'S',:local_legend[23],'U',:local_legend[24], :local_legend[22]),
                        to_char(A.spec_regd_date_time,'dd/mm/yyyy'),
                        to_number(to_char(A.spec_regd_date_time,'sssss')),
                        A.specimen_no,
                        B.test_code,
                        B.result_status
                 FROM   rl_request_detail B,rl_request_header A
                 WHERE  B.specimen_no = A.specimen_no
                 AND    B.operating_facility_id = :nd_operating_facility_id
                 AND    B.operating_facility_id = A.operating_facility_id
                 AND    B.test_code = decode(:nd_test_code,'~~~~~~~~~~', B.test_code,:nd_test_code)
                 AND    A.SPEC_REGD_DATE_TIME >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi')		/o Time Portion is added against CRF-20236o/
                 --AND    A.SPEC_REGD_DATE_TIME < to_date(:nd_to_date,'dd/mm/yyyy hh24:mi') + 1	/o Time Portion is added against CRF-20236o/
				 AND    A.SPEC_REGD_DATE_TIME < to_date(:nd_to_date,'dd/mm/yyyy hh24:mi') --MODIFIED AGAINIST DATE RANGE ISSUE	ON 01/12/2010
                 AND    A.section_code BETWEEN NVL(:nd_fm_section_code, '!')
								  AND NVL(:nd_to_section_code, '~')
                 AND    A.source_type = decode(:nd_source_type,'!', A.source_type,:nd_source_type)
                 AND    A.source_code = decode(:nd_source_from,'~~~~~~', A.source_code,:nd_source_from)
                 AND    A.urgent_indicator = decode(:nd_priority,'!',A.urgent_indicator,:nd_priority)
                 AND    NVL(A.cancelled_yn,'N') <> 'Y'
                 AND    NVL(B.cancelled_yn,'N') <> 'Y'
                 ORDER BY 1, TRUNC(A.spec_regd_date_time), 2; */ 


		/* EXEC SQL OPEN shift_cursor1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0018;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )476;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)local_legend[22];
  sqlstm.sqhstl[0] = (unsigned int  )100;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)local_legend[23];
  sqlstm.sqhstl[1] = (unsigned int  )100;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)local_legend[24];
  sqlstm.sqhstl[2] = (unsigned int  )100;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)local_legend[22];
  sqlstm.sqhstl[3] = (unsigned int  )100;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_test_code;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_test_code;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[7] = (unsigned int  )19;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[8] = (unsigned int  )19;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fm_section_code;
  sqlstm.sqhstl[9] = (unsigned int  )4;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_to_section_code;
  sqlstm.sqhstl[10] = (unsigned int  )4;
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
  sqlstm.sqhstv[12] = (         void  *)&nd_source_type;
  sqlstm.sqhstl[12] = (unsigned int  )4;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_source_from;
  sqlstm.sqhstl[13] = (unsigned int  )12;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_source_from;
  sqlstm.sqhstl[14] = (unsigned int  )12;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_priority;
  sqlstm.sqhstl[15] = (unsigned int  )4;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_priority;
  sqlstm.sqhstl[16] = (unsigned int  )4;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


		}
		else
		if (strcmp(nd_group_test_yn.arr,"I") == 0) 
			{
			/* EXEC SQL DECLARE shift_cursor2 CURSOR FOR
                     SELECT A.section_code, 
							DECODE(A.urgent_indicator, 'R', :local_legend[22],'S',:local_legend[23],'U',:local_legend[24], :local_legend[22]),
							to_char(A.spec_regd_date_time, 'dd/mm/yyyy'),
                            to_number(to_char(A.spec_regd_date_time,'sssss')),
                            A.specimen_no,
                            B.test_code,
                            B.status
                     FROM   rl_test_result B, rl_request_header A
                     WHERE  B.specimen_no = A.specimen_no
                     AND    B.operating_facility_id = :nd_operating_facility_id
                     AND    B.operating_facility_id = A.operating_facility_id
                     AND    B.test_code = decode(:nd_test_code,'~~~~~~~~~~', B.test_code,:nd_test_code)
                     AND    A.spec_regd_date_time >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi')		/o Time Portion is added against CRF-20236o/
                     --AND    A.spec_regd_date_time < to_date(:nd_to_date,'dd/mm/yyyy hh24:mi') + 1	/o Time Portion is added against CRF-20236o/
					 AND    A.SPEC_REGD_DATE_TIME < to_date(:nd_to_date,'dd/mm/yyyy hh24:mi') --MODIFIED AGAINIST DATE RANGE ISSUE	ON 01/12/2010
                     AND    A.section_code BETWEEN NVL(:nd_fm_section_code, '!')
									  AND NVL(:nd_to_section_code, '~')
                     AND    A.source_type = decode(:nd_source_type,'!', A.source_type,:nd_source_type)
                     AND    A.source_code = decode(:nd_source_from,'~~~~~~',a.source_code,:nd_source_from)
                     AND    A.urgent_indicator = decode(:nd_priority,'!', A.urgent_indicator, :nd_priority)
                     AND    NVL(A.cancelled_yn,'N') <> 'Y'
                     AND    NVL(B.cancelled_yn,'N') <> 'Y'
                     ORDER BY 1, TRUNC(A.spec_regd_date_time), 2; */ 


			/* EXEC SQL OPEN shift_cursor2; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0019;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )559;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)local_legend[22];
   sqlstm.sqhstl[0] = (unsigned int  )100;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)local_legend[23];
   sqlstm.sqhstl[1] = (unsigned int  )100;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)local_legend[24];
   sqlstm.sqhstl[2] = (unsigned int  )100;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)local_legend[22];
   sqlstm.sqhstl[3] = (unsigned int  )100;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_test_code;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_test_code;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[7] = (unsigned int  )19;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[8] = (unsigned int  )19;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_fm_section_code;
   sqlstm.sqhstl[9] = (unsigned int  )4;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_section_code;
   sqlstm.sqhstl[10] = (unsigned int  )4;
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
   sqlstm.sqhstv[12] = (         void  *)&nd_source_type;
   sqlstm.sqhstl[12] = (unsigned int  )4;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_source_from;
   sqlstm.sqhstl[13] = (unsigned int  )12;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_source_from;
   sqlstm.sqhstl[14] = (unsigned int  )12;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_priority;
   sqlstm.sqhstl[15] = (unsigned int  )4;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_priority;
   sqlstm.sqhstl[16] = (unsigned int  )4;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


		   }
		   }

#ifdef DEBUG
    printf("leaving dclr_shift_cursor_cur()\n");
    fflush(stdout);
#endif
  return 1;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )642;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_shift_cursor_cur() occured....\n");
   proc_exit();	
  }

/*********** FETCH SHIFT CURSOR **********/
int fetch_shift_cursor()
{

	d_section_code.arr[0]		= '\0';
	d_section_code.len			= 0;

	d_urgent_indicator.arr[0]	= '\0';
	d_urgent_indicator.len		= 0;

	d_specimen_date.arr[0]		= '\0';
	d_specimen_date.len			= 0;
		
	d_specimen_no.arr[0]		= '\0';
	d_specimen_no.len			= 0;
	
	l_specimen_time = 0;

	d_test_code.arr[0]		    = '\0';
	d_test_code.len		    = 0;


	if (strcmp(nd_test_code.arr,"~~~~~~~~~~") == 0) 
	{
	    /* EXEC SQL FETCH shift_cursor0
		          INTO	:d_section_code,
				        :d_urgent_indicator,
						:d_specimen_date,
						:l_specimen_time,
					    :d_specimen_no,
						:d_status; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )657;
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
     sqlstm.sqhstv[1] = (         void  *)&d_urgent_indicator;
     sqlstm.sqhstl[1] = (unsigned int  )12;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_specimen_date;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&l_specimen_time;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_specimen_no;
     sqlstm.sqhstl[4] = (unsigned int  )23;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_status;
     sqlstm.sqhstl[5] = (unsigned int  )4;
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

 
	}
	else
	{		
		if (strcmp(nd_group_test_yn.arr,"G") == 0) 
		{
		/* EXEC SQL FETCH shift_cursor1
              INTO	:d_section_code,
			        :d_urgent_indicator,
					:d_specimen_date,
					:l_specimen_time,
				    :d_specimen_no,
					:d_test_code,
					:d_status; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )696;
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
  sqlstm.sqhstv[1] = (         void  *)&d_urgent_indicator;
  sqlstm.sqhstl[1] = (unsigned int  )12;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_specimen_date;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_specimen_time;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_test_code;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_status;
  sqlstm.sqhstl[6] = (unsigned int  )4;
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

 
		}
		else
			if (strcmp(nd_group_test_yn.arr,"I") == 0) 
			{
		    /* EXEC SQL FETCH shift_cursor2
			      INTO	:d_section_code,
				        :d_urgent_indicator,
						:d_specimen_date,
						:l_specimen_time,
						:d_specimen_no,
						:d_test_code,
						:d_status; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 17;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )739;
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
      sqlstm.sqhstv[1] = (         void  *)&d_urgent_indicator;
      sqlstm.sqhstl[1] = (unsigned int  )12;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_specimen_date;
      sqlstm.sqhstl[2] = (unsigned int  )13;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_specimen_time;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_specimen_no;
      sqlstm.sqhstl[4] = (unsigned int  )23;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_test_code;
      sqlstm.sqhstl[5] = (unsigned int  )13;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_status;
      sqlstm.sqhstl[6] = (unsigned int  )4;
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

 
			}
	}

	if (OERROR)
        err_mesg(ORA_MESG,"FETCH failed on cursor RL_SHIFT_WISE_STATISTICS");

	if (NO_DATA_FOUND)
		return 0;
	
	d_section_code.arr[d_section_code.len]			= '\0';
	d_urgent_indicator.arr[d_urgent_indicator.len]  = '\0';
	d_specimen_date.arr[d_specimen_date.len]		= '\0';
	d_specimen_no.arr[d_specimen_no.len]			= '\0';
	d_test_code.arr[d_test_code.len]				= '\0';
	d_status.arr[d_status.len]						= '\0';

	return 1;
}

close_shift_cursor()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	if (strcmp(nd_test_code.arr,"~~~~~~~~~~") == 0) 
	{
		/* EXEC SQL CLOSE shift_cursor0; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )782;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
  if (sqlca.sqlcode < 0) goto err_exit;
}


	}
	else
	{
		if (strcmp(nd_group_test_yn.arr,"G") == 0) 
		{
			/* EXEC SQL CLOSE shift_cursor1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )797;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
}


		}
		else
		if (strcmp(nd_group_test_yn.arr,"I") == 0) 
		{
			/* EXEC SQL CLOSE shift_cursor2; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )812;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
}


		}
	}
	return 1;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )827;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_shift_cursor_cur() occured....\n");
   proc_exit();	
}


/*********** Get Analyzer Count **********/
int get_analyzer_count()
{
	l_analyzer_count = 0;

	if (strcmp(nd_test_code.arr,"~~~~~~~~~~") == 0) 
	{
	    /* EXEC SQL SELECT COUNT(1)
				  INTO	:l_analyzer_count
				  FROM RL_ONLINE_INSTRUMENT_TEST
				 WHERE operating_facility_id = :nd_operating_facility_id
				   AND test_code IN
								  (SELECT test_code
									 FROM RL_TEST_RESULT
									WHERE specimen_no = :d_specimen_no
									  AND operating_facility_id = :nd_operating_facility_id); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select count(1) into :b0  from RL_ONLINE_INSTRUMENT_TEST\
 where (operating_facility_id=:b1 and test_code in (select test_code  from RL_\
TEST_RESULT where (specimen_no=:b2 and operating_facility_id=:b1)))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )842;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&l_analyzer_count;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
     sqlstm.sqhstv[2] = (         void  *)&d_specimen_no;
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
	else
	{		
		if (strcmp(nd_group_test_yn.arr,"G") == 0)
		{
	    /* EXEC SQL SELECT COUNT(1)
				  INTO	:l_analyzer_count
				  FROM RL_ONLINE_INSTRUMENT_TEST
				 WHERE operating_facility_id = :nd_operating_facility_id
				   AND test_code IN
								  (SELECT test_code
									 FROM RL_TEST_RESULT
									WHERE specimen_no = :d_specimen_no
									  AND operating_facility_id = :nd_operating_facility_id
									  AND group_test_code = :d_test_code); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select count(1) into :b0  from RL_ONLINE_INSTRUMENT_TEST\
 where (operating_facility_id=:b1 and test_code in (select test_code  from RL_\
TEST_RESULT where ((specimen_no=:b2 and operating_facility_id=:b1) and group_t\
est_code=:b4)))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )873;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&l_analyzer_count;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
     sqlstm.sqhstv[2] = (         void  *)&d_specimen_no;
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
     sqlstm.sqhstv[4] = (         void  *)&d_test_code;
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
}


		}
		else
			if (strcmp(nd_group_test_yn.arr,"I") == 0)
			{
			/* EXEC SQL SELECT COUNT(1)
				  INTO	:l_analyzer_count
				  FROM RL_ONLINE_INSTRUMENT_TEST
				 WHERE operating_facility_id = :nd_operating_facility_id
				   AND test_code = :d_test_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select count(1) into :b0  from RL_ONLINE_INSTRUMENT_TEST w\
here (operating_facility_id=:b1 and test_code=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )908;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_analyzer_count;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
   sqlstm.sqhstv[2] = (         void  *)&d_test_code;
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
}


			}
	}

	if (OERROR)
        l_analyzer_count = 0;

	if (NO_DATA_FOUND)
		l_analyzer_count = 0;
	
	return 1;
}


/*********** Do Count **********/
int do_count()
{
	get_analyzer_count();

	if ((l_specimen_time >= l_shift_1_start_time) && 
		(l_specimen_time < l_shift_2_start_time))
	 {
		d_request_1 += 1;

		if (l_analyzer_count > 0)
		{
		  d_analyzer_1 += 1;
		}
	
		if ((strcmp(d_status.arr,"R") == 0) || (strcmp(d_status.arr,"P") == 0))
		{
			d_reported_1 += 1; 
		}
	 }
	else 
	if ((l_specimen_time >= l_shift_2_start_time) && 
		(l_specimen_time < l_shift_3_start_time))
	 {
		d_request_2 += 1;
		
		if (l_analyzer_count > 0)
		  {
			 d_analyzer_2 += 1;
		  }
			
		if ((strcmp(d_status.arr,"R") == 0) || (strcmp(d_status.arr,"P") == 0))
		{
			d_reported_2 += 1; 
		}
	 }
	 else
		{
		d_request_3 += 1;
		
		if (l_analyzer_count > 0)
		  {
			 d_analyzer_3 += 1;
		  }
			
		if ((strcmp(d_status.arr,"R") == 0) || (strcmp(d_status.arr,"P") == 0))
		{
			d_reported_3 += 1; 
		}
		}
		
return 1;
}

/********************* DO REPORT ************************/
do_report()
{
	char first_time = 'Y';
      
	d_prev_section_code.arr[0]	= '\0';
	d_prev_section_code.len		= 0;

	d_prev_specimen_date.arr[0]	= '\0';
	d_prev_specimen_date.len		= '\0';

	d_print_specimen_date.arr[0] = '\0';
	d_print_specimen_date.len = '\0';

	page_no = 1;
	line_no = 1;

	print_rep_header();
	line_no = 59;
	chk_break(1);
	d_request_1  = 0;
	d_request_2  = 0; 
	d_request_3  = 0; 
	d_analyzer_1 = 0;
	d_analyzer_2 = 0;
	d_analyzer_3 = 0;
	d_reported_1 = 0;
	d_reported_2 = 0;
	d_reported_3 = 0;

	t_request_1 = 0;
	t_analyzer_1 = 0;
	t_reported_1 = 0;
	t_request_2 = 0;
	t_analyzer_2 = 0;
	t_reported_2 = 0;
	t_request_3 = 0;
	t_analyzer_3 = 0;
	t_reported_3 = 0;

	g_request_1 = 0;
	g_analyzer_1 = 0;
	g_reported_1 = 0;
	g_request_2 = 0;
	g_analyzer_2 = 0;
	g_reported_2 = 0;
	g_request_3 = 0;
	g_analyzer_3 = 0;
	g_reported_3 = 0;

    dclr_shift_cursor();
   
   while(fetch_shift_cursor())
   {

//   disp_message(ERR_MESG,d_specimen_date.arr);

	   if (strcmp(d_prev_section_code.arr, d_section_code.arr) != 0)
	   {
		   strcpy(d_prev_section_code.arr, d_section_code.arr);
		   d_prev_section_code.len = strlen(d_prev_section_code.arr);


		   if (first_time == 'N')
			{
	    	   print_dtl();
			   print_total();
          	   strcpy(d_print_specimen_date.arr,"");
		       d_print_specimen_date.len = strlen(d_print_specimen_date.arr);
			   strcpy(d_prev_urgent_ind.arr,"");
			   d_prev_urgent_ind.len = strlen(d_prev_urgent_ind.arr);
      	    }

		   strcpy(d_prev_specimen_date.arr,d_specimen_date.arr);
		   d_prev_specimen_date.len = strlen(d_prev_specimen_date.arr);
		   strcpy(d_prev_urgent_ind.arr, d_urgent_indicator.arr);
		   d_prev_urgent_ind.len = strlen(d_prev_urgent_ind.arr);

		   get_section_desc();
		   print_dept_dtl();
		   first_time = 'N';
//		   disp_message(ERR_MESG,"Print DEPT ");
		}
 	   else	
		{
			if (strcmp(d_prev_specimen_date.arr, d_specimen_date.arr) != 0)
				{
//   disp_message(ERR_MESG,"Print Dtl inside loop");

			      print_dtl();			

			      strcpy(d_prev_specimen_date.arr,d_specimen_date.arr);
				  d_prev_specimen_date.len = strlen(d_prev_specimen_date.arr);

			      strcpy(d_prev_urgent_ind.arr, d_urgent_indicator.arr);
			      d_prev_urgent_ind.len = strlen(d_prev_urgent_ind.arr);

				}
				else
				{
                 if ( ( strcmp(l_malaysia_yn.arr, "Y") == 0)  && (strcmp(d_prev_urgent_ind.arr, d_urgent_indicator.arr) != 0 ) )
				 {
                   print_dtl();			
				   strcpy(d_prev_urgent_ind.arr, d_urgent_indicator.arr);
				   d_prev_urgent_ind.len = strlen(d_prev_urgent_ind.arr);
				 }
				}
		}

	do_count();  

  }

   print_dtl();			

   print_total();

   print_grand_total();

   close_shift_cursor();

return 1;
}

/************** PRINT DEPARTMENT COLUMN HEADING ***************/
print_dept_dtl()
{
	chk_break(1);
	fprintf(f1,"%-10.10s : %-40s\n",local_legend[9],d_section_desc.arr);
	fprintf(f1,"-----------------------------------\n");
    line_no += 2 ;
	return 1;
}

get_section_desc()
{
	d_section_desc.arr[0]	= '\0';
	d_section_desc.len		= 0;

	/* EXEC SQL SELECT long_name 
			 INTO :d_section_desc
			 FROM RL_SECTION_CODE_LANG_VW
			 WHERE section_code = :d_section_code
			 AND language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_name into :b0  from RL_SECTION_CODE_LANG_VW wher\
e (section_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )935;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_section_desc;
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



	d_section_desc.arr[d_section_desc.len]		= '\0';
return 1;
}
get_test_desc()
{
	nd_test_desc.arr[0]	= '\0';
	nd_test_desc.len		= 0;

	 /* EXEC SQL SELECT long_desc
			 INTO :nd_test_desc
			 FROM  rl_test_code_lang_vw
			 WHERE test_code   = :nd_test_code
			   AND language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_desc into :b0  from rl_test_code_lang_vw where \
(test_code=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )962;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_test_desc;
  sqlstm.sqhstl[0] = (unsigned int  )63;
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


	nd_test_desc.arr[nd_test_desc.len]		= '\0';
return 1;
}

print_total()
{
	chk_break(6);

	fprintf(f1,"            ------------------------------------------------------------------\n");

	fprintf(f1,"%-5.5s        ",local_legend[10]);
	if (strcmp(l_malaysia_yn.arr, "Y") == 0)
	{
	  fprintf(f1,"%-8s", " ");
	  fprintf(f1,"%4d  %4s  %4d",
			  t_request_1, " ", t_reported_1);
	  fprintf(f1,"    %4d  %4s  %4d",
			  t_request_2, " ", t_reported_2);
	  fprintf(f1,"    %4d  %4s  %4d\n",
			  t_request_3, " ", t_reported_3);				       

	}
	else
	{
	  fprintf(f1,"%4d  %4d  %4d",
			  t_request_1, t_analyzer_1, t_reported_1);
	  fprintf(f1,"    %4d  %4d  %4d",
			t_request_2, t_analyzer_2, t_reported_2);
	  fprintf(f1,"    %4d  %4d  %4d\n",
			  t_request_3, t_analyzer_3, t_reported_3);				       
	}
	fprintf(f1,"            ------------------------------------------------------------------\n");

	line_no += 3;

	g_request_1 += t_request_1;
	g_analyzer_1 += t_analyzer_1;
    g_reported_1 += t_reported_1;

	g_request_2 += t_request_2;
	g_analyzer_2 += t_analyzer_2;
    g_reported_2 += t_reported_2;

	g_request_3 += t_request_3;
	g_analyzer_3 += t_analyzer_3;
    g_reported_3 += t_reported_3;

	t_request_1 = 0;
	t_analyzer_1 = 0;
	t_reported_1 = 0;
	t_request_2 = 0;
	t_analyzer_2 = 0;
	t_reported_2 = 0;
	t_request_3 = 0;
	t_analyzer_3 = 0;
	t_reported_3 = 0;
return 1;
}


print_grand_total()
{
	chk_break(5);

	fprintf(f1, "\n\n");

	fprintf(f1,"            ------------------------------------------------------------------\n");
	fprintf(f1,"%-11.11s",local_legend[11]);

	if (strcmp(l_malaysia_yn.arr, "Y") == 0)
	{
	  fprintf(f1,"%-8s", " ");
	  fprintf(f1,"%6ld%6s%6ld",
			  g_request_1, " ", g_reported_1);
	  fprintf(f1,"  %6ld%6s%6ld",
			  g_request_2, " ", g_reported_2);
	  fprintf(f1,"  %6ld%6s%6d\n",
			  g_request_3, " ", g_reported_3);				       
	}
	else
	{
	  fprintf(f1,"%6ld%6ld%6ld",
			  g_request_1, g_analyzer_1, g_reported_1);
	  fprintf(f1,"  %6ld%6ld%6ld",
			  g_request_2, g_analyzer_2, g_reported_2);
	  fprintf(f1,"  %6ld%6ld%6d\n",
			  g_request_3, g_analyzer_3, g_reported_3);				       
	}
	fprintf(f1,"            ------------------------------------------------------------------\n");

	line_no += 3;

	g_request_1 = 0;
	g_analyzer_1 = 0;
	g_reported_1 = 0;
	g_request_2 = 0;
	g_analyzer_2 = 0;
	g_reported_2 = 0;
	g_request_3 = 0;
	g_analyzer_3 = 0;
	g_reported_3 = 0;

return 1;
}

print_dtl()
{
	chk_break(1);
	if (strcmp(l_malaysia_yn.arr, "Y") == 0)
	{
//sprintf(string_var, "s %s s %s", d_prev_specimen_date.arr, d_specimen_date.arr);
//disp_message(ERR_MESG, string_var);
      if (strcmp(d_print_specimen_date.arr, d_prev_specimen_date.arr) != 0)
	  {
        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_prev_specimen_date,'DD/MM/YYYY'), :language_id , t_date);
				//:d_prev_specimen_date1 := to_char(t_date,'DD/MM/YYYY');
				:d_prev_specimen_date1 :=sm_convert_date_2t(to_date(:d_prev_specimen_date,'DD/MM/YYYY'),:language_id);
				END;
			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN :d_prev_specimen_date1 :=\
 sm_convert_date_2t ( to_date ( :d_prev_specimen_date , 'DD/MM/YYYY' ) , :lang\
uage_id ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )989;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_prev_specimen_date1;
        sqlstm.sqhstl[0] = (unsigned int  )13;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_prev_specimen_date;
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


		fprintf(f1, "%-10s %-8.8s  %4d  %4s  %4d",
			d_prev_specimen_date1.arr, d_prev_urgent_ind.arr, 
			d_request_1, " ", d_reported_1);

	  }
	  else
	  {
        fprintf(f1, "%-10s %-8.8s  %4d  %4s  %4d",
			" ", d_prev_urgent_ind.arr, //HERE
			d_request_1, " ", d_reported_1);
	  }
	  fprintf(f1, "    %4d  %4s  %4d",
			d_request_2, " ", d_reported_2);
	  fprintf(f1, "    %4d  %4s  %4d\n",
			d_request_3, " ", d_reported_3);				       

	}
	else
	{
      fprintf(f1, "%-10s   %4d  %4d  %4d",
			d_prev_specimen_date.arr, 
			d_request_1, d_analyzer_1, d_reported_1);
	fprintf(f1, "    %4d  %4d  %4d",
			d_request_2, d_analyzer_2, d_reported_2);
	fprintf(f1, "    %4d  %4d  %4d\n",
			d_request_3, d_analyzer_3, d_reported_3);				       

	}

    strcpy(d_print_specimen_date.arr, d_prev_specimen_date.arr);
	d_print_specimen_date.len = strlen(d_print_specimen_date.arr);

	t_request_1 += d_request_1;
	t_request_2 += d_request_2;  
	t_request_3 += d_request_3;  

	t_analyzer_1 += d_analyzer_1; 
	t_analyzer_2 += d_analyzer_2; 
	t_analyzer_3 += d_analyzer_3; 

	t_reported_1 += d_reported_1; 
	t_reported_2 += d_reported_2; 
	t_reported_3 += d_reported_3; 	

	
	d_request_1  = 0;
	d_request_2  = 0; 
	d_request_3  = 0; 
	d_analyzer_1 = 0;
	d_analyzer_2 = 0;
	d_analyzer_3 = 0;
	d_reported_1 = 0;
	d_reported_2 = 0;
	d_reported_3 = 0;

	line_no++;

return 1;
}


get_version_no()
{

////////    This function is used to get the version number of the product.
///////      Added by Srinivas on 1 July 2003

     d_version_no.arr[0] = '\0';
     d_version_no.len    =  0;
	 l_malaysia_yn.arr[0] = '\0';
	 l_malaysia_yn.len    = 0;

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
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1016;
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
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1035;
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

    if (l_tab_exists && strcmp(l_hmc_yn.arr, "Y") != 0 ) 
      strcpy(l_malaysia_yn.arr,"Y");
	else
	  strcpy(l_malaysia_yn.arr,"N");


    if (OERROR)
	{
	    strcpy(d_version_no.arr,"2.1");
	    strcat(d_version.arr,d_version_no.arr);
    }

return 1;
}
//////////// UPTO HERE   




#undef DEBUG
#undef OERROR
#undef NO_DATA_FOUND
#undef MAX_LINES
#undef VER


