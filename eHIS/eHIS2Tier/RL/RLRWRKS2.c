
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
    "c:\\temp1\\rlrwrks2.pc"
};


static unsigned long sqlctx = 72627131;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {10,13};

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

 static const char *sq0011 = 
")+NVL(B.AH21,0))+NVL(B.AH22,0))+NVL(B.AH23,0))+NVL(B.AH24,0))) ADD_TOTAL  fr\
om RL_TEST_CODE A ,RL_RES_ACT_WORKLOAD_DAILY B ,RL_TEST_CODE_LANG_VW Z where (\
(((((((((A.TEST_CODE=B.TEST_CODE and A.TEST_CODE=Z.TEST_CODE) and B.RESULT_DAT\
E>=TO_DATE(:b0,'DD/MM/YYYY')) and B.RESULT_DATE<(TO_DATE(:b1,'DD/MM/YYYY')+1))\
 and B.OPERATING_FACILITY_ID=:b2) and A.SECTION_CODE between :b3 and :b4) and \
NVL(A.STATISTICS_YN,'N')='Y') and Z.LANGUAGE_ID=:b5) and nvl(B.SOURCE_TYPE,'!'\
)=nvl(:b6,nvl(B.SOURCE_TYPE,'!'))) and nvl(B.SOURCE_CODE,'!') between :b7 and \
:b8) and A.TEST_CODE in (select C.TEST_CODE  from RL_OUTST_WORK_GROUP_DTL C wh\
ere (C.OPERATING_FACILITY_ID=:b2 and C.OUTST_WORK_GROUP_CODE=nvl(:b10,C.OUTST_\
WORK_GROUP_CODE)))))  group by SECTION_CODE,TEST_CODE,LONG_DESC,RESULT_DATE,WO\
RK_UNITS,WORK_UNIT_ADD_FACTOR order by SECTION_CODE,TEST_CODE,RESULT_DATE     \
       ";

 static const char *sq0012 = 
")+NVL(B.AH21,0))+NVL(B.AH22,0))+NVL(B.AH23,0))+NVL(B.AH24,0))) ADD_TOTAL  fr\
om RL_TEST_CODE A ,RL_RES_ACT_WORKLOAD_DAILY B ,RL_TEST_CODE_LANG_VW Z where (\
((((((((A.TEST_CODE=B.TEST_CODE and A.TEST_CODE=Z.TEST_CODE) and B.RESULT_DATE\
>=TO_DATE(:b0,'DD/MM/YYYY')) and B.RESULT_DATE<(TO_DATE(:b1,'DD/MM/YYYY')+1)) \
and OPERATING_FACILITY_ID=:b2) and A.SECTION_CODE between :b3 and :b4) and NVL\
(A.STATISTICS_YN,'N')='Y') and Z.LANGUAGE_ID=:b5) and nvl(B.SOURCE_TYPE,'!')=n\
vl(:b6,nvl(B.SOURCE_TYPE,'!'))) and nvl(B.SOURCE_CODE,'!') between :b7 and :b8\
))  group by SECTION_CODE,TEST_CODE,LONG_DESC,RESULT_DATE,WORK_UNITS,WORK_UNIT\
_ADD_FACTOR order by SECTION_CODE,TEST_CODE,RESULT_DATE            ";

 static const char *sq0013 = 
")))))  group by SECTION_CODE,TEST_CODE,LONG_DESC,RESULT_DATE,WORK_UNITS,WORK\
_UNIT_ADD_FACTOR order by SECTION_CODE,TEST_CODE,RESULT_DATE            ";

 static const char *sq0014 = 
")+NVL(B.AH21,0))+NVL(B.AH22,0))+NVL(B.AH23,0))+NVL(B.AH24,0))) ADD_TOTAL  fr\
om RL_TEST_CODE A ,RL_RES_ACT_WORKLOAD_DAILY B where ((((((((A.TEST_CODE=B.TES\
T_CODE and B.RESULT_DATE>=TO_DATE(:b0,'DD/MM/YYYY')) and B.RESULT_DATE<(TO_DAT\
E(:b1,'DD/MM/YYYY')+1)) and OPERATING_FACILITY_ID=:b2) and A.SECTION_CODE betw\
een :b3 and :b4) and NVL(A.STATISTICS_YN,'N')='Y') and A.TEST_CODE in (select \
distinct TEST_CODE  from RL_REFERRED_TEST_CODE where (OPERATING_FACILITY_ID=:b\
2 and TEST_CODE=A.TEST_CODE) union select TEST_CODE  from RL_GROUP_TEST_DETAIL\
 where GROUP_TEST_CODE in (select distinct P.TEST_CODE  from RL_REFERRED_TEST_\
CODE P ,RL_TEST_CODE Q where ((P.OPERATING_FACILITY_ID=:b2 and P.TEST_CODE=Q.T\
EST_CODE) and NVL(Q.GROUP_TEST_YN,'N')='Y')))) and nvl(B.SOURCE_TYPE,'!')=nvl(\
:b7,nvl(B.SOURCE_TYPE,'!'))) and nvl(B.SOURCE_CODE,'!') between :b8 and :b9)) \
 group by SECTION_CODE,TEST_CODE,LONG_DESC,RESULT_DATE,WORK_UNITS,WORK_UNIT_AD\
D_FACTOR order by SECTION_CODE,TEST_CODE,RESULT_DATE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,202,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,226,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,235,0,0,0,0,0,1,0,
66,0,0,4,120,0,6,243,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
89,0,0,5,136,0,6,254,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
112,0,0,6,274,0,4,279,0,0,13,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
179,0,0,7,91,0,2,320,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
202,0,0,8,0,0,32,328,0,0,0,0,0,1,0,
217,0,0,9,158,0,4,338,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
252,0,0,10,0,0,32,356,0,0,0,0,0,1,0,
267,0,0,11,1887,0,9,407,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
326,0,0,12,1713,0,9,445,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
377,0,0,13,2196,0,9,504,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
440,0,0,14,2022,0,9,558,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
495,0,0,15,0,0,32,570,0,0,0,0,0,1,0,
510,0,0,16,706,0,4,730,0,0,7,5,0,1,0,2,3,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
553,0,0,17,651,0,4,757,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
596,0,0,18,651,0,4,781,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
639,0,0,19,689,0,4,803,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
682,0,0,20,128,0,4,830,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
713,0,0,21,0,0,32,844,0,0,0,0,0,1,0,
728,0,0,11,0,0,13,894,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
775,0,0,12,0,0,13,904,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
822,0,0,13,0,0,13,917,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
869,0,0,14,0,0,13,927,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
916,0,0,22,0,0,32,956,0,0,0,0,0,1,0,
931,0,0,23,135,0,6,998,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
958,0,0,24,44,0,4,1082,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
985,0,0,25,44,0,4,1107,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1012,0,0,26,135,0,6,1173,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1039,0,0,27,135,0,6,1212,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1066,0,0,28,44,0,4,1297,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1093,0,0,29,44,0,4,1322,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1120,0,0,30,0,0,32,1360,0,0,0,0,0,1,0,
1135,0,0,31,100,0,6,1576,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
1158,0,0,32,129,0,6,1602,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1185,0,0,33,127,0,6,1612,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1212,0,0,34,101,0,6,1732,0,0,1,1,0,1,0,2,3,0,0,
1231,0,0,35,49,0,4,1745,0,0,1,0,0,1,0,2,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	  : rlrwrks2.pc
   Author : S.Sheelvant 
   Date Created : 13/02/1997
   Last Modified : 13/02/1997
   Last Modified : 30/09/2002 
   Last Modified : 22/10/2007 
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
  
*  Table Accessed : RL_RES_ACT_WORKLOAD, RL_TEST_CODE

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
#define REP_WIDTH 93 // added for globalisation
/*
#define DEBUG 1
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR  nd_operating_facility_id   [30],
	         uid_pwd		            [91],
		     nd_file_name		        [150],
			 d_version_no			    [20],
			 d_version  			    [20],


        /o Variables to recieve data from RESULT_WORKLOAD cursoro/ 
        d_section_code          [20],
        d_test_code             [30],
		d_test_desc             [100],
        t_test_code             [30],   /o to perform test break o/
		t_test_desc             [80],
		d_work_units            [80],
		d_work_units1           [80],
		d_work_units_length     [80],
		d_add_work_units		[80],
		d_add_work_units1		[80],
		d_add_work_units_length	[80],
		d_period_units_length   [80],
		d_period_units          [80],
		d_no_of_tests           [80],
		d_daily_tot             [80],
		d_add_tot               [80],
		d_result_date           [81],
		d_result_date1           [81], //added for globalisation
		d_fr_month              [80],
        t_section_code          [80],  /o to perform section break o/
        t_section_desc          [81],
		t_section_ind			[86],

		

                /o input parameters to main() o/
        nd_session_id      	[16],
		nd_pgm_date	   	[20],
		nd_printer_name	   	[20],

		/o input parameters through from SY_PROG_PARAM o/
        d_section_code_fm       [20],
		d_section_code_to       [20],
		d_date_from             [21],
		d_date_to               [21],
        d_workgroup             [50],
		d_summary_yn			[20],
/o -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
		d_source_type			[33],
		d_source_fm				[30],
		d_source_to				[30],
/o -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
		d_option				[2],	/o	Added by Durai Rajkumar against ML-SD-CRF-20239	o/
		/o for header routine o/
	    //d_acc_entity_name_long        [121],
		d_acc_entity_name_long        [300],
		d_user                   [31],
		d_sysdate                [17],
		d_sysdate1                [17],
		d_sysdate2                [17],
		d_sysdate3                [17],

		/o**************** added for globalisation **********o/

		l_translated_value		[600],
		language_id				[5]; */ 
struct { unsigned short len; unsigned char arr[30]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[20]; } d_section_code;

struct { unsigned short len; unsigned char arr[30]; } d_test_code;

struct { unsigned short len; unsigned char arr[100]; } d_test_desc;

struct { unsigned short len; unsigned char arr[30]; } t_test_code;

struct { unsigned short len; unsigned char arr[80]; } t_test_desc;

struct { unsigned short len; unsigned char arr[80]; } d_work_units;

struct { unsigned short len; unsigned char arr[80]; } d_work_units1;

struct { unsigned short len; unsigned char arr[80]; } d_work_units_length;

struct { unsigned short len; unsigned char arr[80]; } d_add_work_units;

struct { unsigned short len; unsigned char arr[80]; } d_add_work_units1;

struct { unsigned short len; unsigned char arr[80]; } d_add_work_units_length;

struct { unsigned short len; unsigned char arr[80]; } d_period_units_length;

struct { unsigned short len; unsigned char arr[80]; } d_period_units;

struct { unsigned short len; unsigned char arr[80]; } d_no_of_tests;

struct { unsigned short len; unsigned char arr[80]; } d_daily_tot;

struct { unsigned short len; unsigned char arr[80]; } d_add_tot;

struct { unsigned short len; unsigned char arr[81]; } d_result_date;

struct { unsigned short len; unsigned char arr[81]; } d_result_date1;

struct { unsigned short len; unsigned char arr[80]; } d_fr_month;

struct { unsigned short len; unsigned char arr[80]; } t_section_code;

struct { unsigned short len; unsigned char arr[81]; } t_section_desc;

struct { unsigned short len; unsigned char arr[86]; } t_section_ind;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } nd_printer_name;

struct { unsigned short len; unsigned char arr[20]; } d_section_code_fm;

struct { unsigned short len; unsigned char arr[20]; } d_section_code_to;

struct { unsigned short len; unsigned char arr[21]; } d_date_from;

struct { unsigned short len; unsigned char arr[21]; } d_date_to;

struct { unsigned short len; unsigned char arr[50]; } d_workgroup;

struct { unsigned short len; unsigned char arr[20]; } d_summary_yn;

struct { unsigned short len; unsigned char arr[33]; } d_source_type;

struct { unsigned short len; unsigned char arr[30]; } d_source_fm;

struct { unsigned short len; unsigned char arr[30]; } d_source_to;

struct { unsigned short len; unsigned char arr[2]; } d_option;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name_long;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate2;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate3;

struct { unsigned short len; unsigned char arr[600]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;



/* -- from here added by sunil on 18/10/2007 as per SD-CRF-20071 --- */
	int sec_tot_blk		=0,
		sec_tot_he_sld 	=0,
		sec_tot_spl_stn	=0,
		sec_tot_ctl_sld	=0,
		sec_tot_smear	=0,
		sec_tot			=0;
/* -- upto here added by sunil on 18/10/2007 as per SD-CRF-20071 --- */

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
void print_section_desc(int nn);
FILE *f1;

char string_var[200];

char local_legend[50][600]; // added for globalisation
/*************************** added for globalisation ************/
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char rep_title1[60] ;
char rep_title2[30];
/*************************** added for globalisation ************/


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
     disp_message(ORA_MESG,"Usage rlrwrks2 uid/passwd session_id pgm_date\n");
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

   get_legend_value(38);

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


get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRWRKS2.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRWRKS2.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )32;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRWRKS2.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLRWRKS2.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )89;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[0] = (unsigned int  )602;
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
		   PARAM6,
/o -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
		   PARAM7,
		   nvl(PARAM8,'!'),
		   nvl(PARAM9,'~'),
/o -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
           PARAM10			/o	Added by Durai Rajkumar against ML-SD-CRF-20239	o/
        INTO  :nd_operating_facility_id,
		      :d_section_code_fm, 
			  :d_section_code_to,
		      :d_date_from,
			  :d_date_to,
			  :d_workgroup,
			  :d_summary_yn,
/o -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
			  :d_source_type,
			  :d_source_fm,
			  :d_source_to,
/o -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
			  :d_option		/o	Added by Durai Rajkumar against ML-SD-CRF-20239	o/
         FROM SY_PROG_PARAM
	    WHERE PGM_ID = 'RLRWRKSD'
		  AND SESSION_ID = TO_NUMBER(:nd_session_id)
		  AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,nvl(PARAM8,'!') ,nvl(PARAM9,'~') ,PARAM10 into :b0\
,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from SY_PROG_PARAM where ((PGM_ID='\
RLRWRKSD' and SESSION_ID=TO_NUMBER(:b11)) and PGM_DATE=:b12)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )112;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )32;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_section_code_fm;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_section_code_to;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_date_from;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_date_to;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_workgroup;
   sqlstm.sqhstl[5] = (unsigned int  )52;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_summary_yn;
   sqlstm.sqhstl[6] = (unsigned int  )22;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_source_type;
   sqlstm.sqhstl[7] = (unsigned int  )35;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_source_fm;
   sqlstm.sqhstl[8] = (unsigned int  )32;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_source_to;
   sqlstm.sqhstl[9] = (unsigned int  )32;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_option;
   sqlstm.sqhstl[10] = (unsigned int  )4;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[11] = (unsigned int  )18;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[12] = (unsigned int  )22;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='RLRWRKSD' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )179;
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )202;
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
            FROM SY_ACC_ENTITY_LANG_VW
            WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b\
3 and LANGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )217;
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
   sqlstm.sqhstl[3] = (unsigned int  )32;
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )252;
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

 if (strcmp(d_option.arr,"R") != 0)		/*	Added by Durai Rajkumar against ML-SD-SCF-20239	*/
 {
  if (d_workgroup.arr[0] != '\0')
  {
   /* EXEC SQL DECLARE RESULT_WORKLOAD CURSOR FOR
     SELECT SECTION_CODE, TEST_CODE, LONG_DESC, WORK_UNITS, WORK_UNIT_ADD_FACTOR, RESULT_DATE,
	 SUM(DAILY_TOTAL) DAILY_TOTAL, SUM(ADD_TOTAL) ADD_TOTAL
	 FROM
	 (
	 SELECT A.SECTION_CODE,A.TEST_CODE,Z.LONG_DESC,
     NVL(A.WORK_UNITS,0) WORK_UNITS, nvl(a.WORK_UNIT_ADD_FACTOR,0) WORK_UNIT_ADD_FACTOR,
	 TO_CHAR(B.RESULT_DATE,'DD/MM/YYYY') RESULT_DATE,
     TO_CHAR((NVL(B.H1,0) + NVL(B.H2,0) + NVL(B.H3,0) + NVL(B.H4,0) + NVL(B.H5,0) + NVL(B.H6,0)+
     NVL(B.H7,0) + NVL(B.H8,0) + NVL(B.H9,0) + NVL(B.H10,0)+ NVL(B.H11,0) + NVL(B.H12,0)+
     NVL(B.H13,0) + NVL(B.H14,0) + NVL(B.H15,0) + NVL(B.H16,0)+ NVL(B.H17,0) + NVL(B.H18,0)+
     NVL(B.H19,0) + NVL(B.H20,0) + NVL(B.H21,0) + NVL(B.H22,0)+ NVL(B.H23,0) + NVL(B.H24,0))) DAILY_TOTAL,
     TO_CHAR(( NVL(B.AH1,0) + NVL(B.AH2,0) + NVL(B.AH3,0) + NVL(B.AH4,0) + NVL(B.AH5,0) + NVL(B.AH6,0)+
     NVL(B.AH7,0) + NVL(B.AH8,0) + NVL(B.AH9,0) + NVL(B.AH10,0)+ NVL(B.AH11,0) + NVL(B.AH12,0)+
     NVL(B.AH13,0) + NVL(B.AH14,0) + NVL(B.AH15,0) + NVL(B.AH16,0)+ NVL(B.AH17,0) + NVL(B.AH18,0)+
     NVL(B.AH19,0) + NVL(B.AH20,0) + NVL(B.AH21,0) + NVL(B.AH22,0)+ NVL(B.AH23,0) + NVL(B.AH24,0))) ADD_TOTAL
     FROM   RL_TEST_CODE A, RL_RES_ACT_WORKLOAD_DAILY B, RL_TEST_CODE_LANG_VW Z
     WHERE  A.TEST_CODE = B.TEST_CODE
	 AND A.TEST_CODE = Z.TEST_CODE
     AND B.RESULT_DATE  >= TO_DATE(:d_date_from,'DD/MM/YYYY')
     AND B.RESULT_DATE  < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
     AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND A.SECTION_CODE BETWEEN :d_section_code_fm 
     AND :d_section_code_to
     AND  NVL(A.STATISTICS_YN,'N') = 'Y'
 	 AND Z.LANGUAGE_ID = :language_id
/o -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
	 AND nvl(B.SOURCE_TYPE,'!') = nvl(:d_source_type,nvl(B.SOURCE_TYPE,'!')) 
	 AND nvl(B.SOURCE_CODE,'!') BETWEEN :d_source_fm
	 AND :d_source_to
/o -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
     AND A.TEST_CODE in (select C.TEST_CODE from RL_OUTST_WORK_GROUP_DTL C 
     where C.OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND C.OUTST_WORK_GROUP_CODE = nvl(:d_workgroup,C.OUTST_WORK_GROUP_CODE))
	 )
	 GROUP BY SECTION_CODE, TEST_CODE, LONG_DESC, RESULT_DATE, WORK_UNITS, WORK_UNIT_ADD_FACTOR
     ORDER BY  SECTION_CODE, TEST_CODE,RESULT_DATE; */ 

	 /* EXEC SQL OPEN RESULT_WORKLOAD; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select SECTION_CODE ,TEST_CODE ,LONG_DESC ,WORK_UNITS ,WORK_UNIT_ADD_FA\
CTOR ,RESULT_DATE ,sum(DAILY_TOTAL) DAILY_TOTAL ,sum(ADD_TOTAL) ADD_TOTAL  f\
rom (select A.SECTION_CODE ,A.TEST_CODE ,Z.LONG_DESC ,NVL(A.WORK_UNITS,0) WO\
RK_UNITS ,nvl(a.WORK_UNIT_ADD_FACTOR,0) WORK_UNIT_ADD_FACTOR ,TO_CHAR(B.RESU\
LT_DATE,'DD/MM/YYYY') RESULT_DATE ,TO_CHAR((((((((((((((((((((((((NVL(B.H1,0\
)+NVL(B.H2,0))+NVL(B.H3,0))+NVL(B.H4,0))+NVL(B.H5,0))+NVL(B.H6,0))+NVL(B.H7,\
0))+NVL(B.H8,0))+NVL(B.H9,0))+NVL(B.H10,0))+NVL(B.H11,0))+NVL(B.H12,0))+NVL(\
B.H13,0))+NVL(B.H14,0))+NVL(B.H15,0))+NVL(B.H16,0))+NVL(B.H17,0))+NVL(B.H18,\
0))+NVL(B.H19,0))+NVL(B.H20,0))+NVL(B.H21,0))+NVL(B.H22,0))+NVL(B.H23,0))+NV\
L(B.H24,0))) DAILY_TOTAL ,TO_CHAR((((((((((((((((((((((((NVL(B.AH1,0)+NVL(B.\
AH2,0))+NVL(B.AH3,0))+NVL(B.AH4,0))+NVL(B.AH5,0))+NVL(B.AH6,0))+NVL(B.AH7,0)\
)+NVL(B.AH8,0))+NVL(B.AH9,0))+NVL(B.AH10,0))+NVL(B.AH11,0))+NVL(B.AH12,0))+N\
VL(B.AH13,0))+NVL(B.AH14,0))+NVL(B.AH15,0))+NVL(B.AH16,0))+NVL(B.AH17,0))+NV\
L(B.AH18,0))+NVL(B.AH19,0))+NVL(B.AH20,0)");
  sqlstm.stmt = sq0011;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )267;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_date_from;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_date_to;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_section_code_fm;
  sqlstm.sqhstl[3] = (unsigned int  )22;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_section_code_to;
  sqlstm.sqhstl[4] = (unsigned int  )22;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&language_id;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_source_type;
  sqlstm.sqhstl[6] = (unsigned int  )35;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_source_fm;
  sqlstm.sqhstl[7] = (unsigned int  )32;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_source_to;
  sqlstm.sqhstl[8] = (unsigned int  )32;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[9] = (unsigned int  )32;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_workgroup;
  sqlstm.sqhstl[10] = (unsigned int  )52;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


		}
  else
  {
   /* EXEC SQL DECLARE RESULT_WORKLOAD1 CURSOR FOR
     SELECT SECTION_CODE, TEST_CODE, LONG_DESC, WORK_UNITS, WORK_UNIT_ADD_FACTOR, RESULT_DATE,
	 SUM(DAILY_TOTAL) DAILY_TOTAL, SUM(ADD_TOTAL) ADD_TOTAL
	 FROM
	 (
	 SELECT A.SECTION_CODE,A.TEST_CODE,Z.LONG_DESC,
     NVL(A.WORK_UNITS,0) WORK_UNITS, nvl(a.WORK_UNIT_ADD_FACTOR,0) WORK_UNIT_ADD_FACTOR,
	 TO_CHAR(B.RESULT_DATE,'DD/MM/YYYY') RESULT_DATE,
     TO_CHAR((NVL(B.H1,0) + NVL(B.H2,0) + NVL(B.H3,0) + NVL(B.H4,0) + NVL(B.H5,0) + NVL(B.H6,0)+
     NVL(B.H7,0) + NVL(B.H8,0) + NVL(B.H9,0) + NVL(B.H10,0)+ NVL(B.H11,0) + NVL(B.H12,0)+
     NVL(B.H13,0) + NVL(B.H14,0) + NVL(B.H15,0) + NVL(B.H16,0)+ NVL(B.H17,0) + NVL(B.H18,0)+
     NVL(B.H19,0) + NVL(B.H20,0) + NVL(B.H21,0) + NVL(B.H22,0)+ NVL(B.H23,0) + NVL(B.H24,0))) DAILY_TOTAL,
     TO_CHAR(( NVL(B.AH1,0) + NVL(B.AH2,0) + NVL(B.AH3,0) + NVL(B.AH4,0) + NVL(B.AH5,0) + NVL(B.AH6,0)+
     NVL(B.AH7,0) + NVL(B.AH8,0) + NVL(B.AH9,0) + NVL(B.AH10,0)+ NVL(B.AH11,0) + NVL(B.AH12,0)+
     NVL(B.AH13,0) + NVL(B.AH14,0) + NVL(B.AH15,0) + NVL(B.AH16,0)+ NVL(B.AH17,0) + NVL(B.AH18,0)+
     NVL(B.AH19,0) + NVL(B.AH20,0) + NVL(B.AH21,0) + NVL(B.AH22,0)+ NVL(B.AH23,0) + NVL(B.AH24,0))) ADD_TOTAL
     FROM   RL_TEST_CODE A, RL_RES_ACT_WORKLOAD_DAILY B, RL_TEST_CODE_LANG_VW Z
     WHERE  A.TEST_CODE = B.TEST_CODE
	 AND A.TEST_CODE = Z.TEST_CODE
     AND B.RESULT_DATE  >= TO_DATE(:d_date_from,'DD/MM/YYYY')
     AND B.RESULT_DATE < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
     AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND A.SECTION_CODE BETWEEN :d_section_code_fm 
		       AND :d_section_code_to
     AND  NVL(A.STATISTICS_YN,'N') = 'Y' 
 	 AND Z.LANGUAGE_ID = :language_id
/o -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
	 AND nvl(B.SOURCE_TYPE,'!') = nvl(:d_source_type,nvl(B.SOURCE_TYPE,'!')) 
	 AND nvl(B.SOURCE_CODE,'!') BETWEEN :d_source_fm
	 AND :d_source_to
	 )
	 GROUP BY SECTION_CODE, TEST_CODE, LONG_DESC, RESULT_DATE, WORK_UNITS, WORK_UNIT_ADD_FACTOR
/o -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
     ORDER BY  SECTION_CODE, TEST_CODE,RESULT_DATE; */ 

	 /* EXEC SQL OPEN RESULT_WORKLOAD1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select SECTION_CODE ,TEST_CODE ,LONG_DESC ,WORK_UNITS ,WORK_UNIT_ADD_FA\
CTOR ,RESULT_DATE ,sum(DAILY_TOTAL) DAILY_TOTAL ,sum(ADD_TOTAL) ADD_TOTAL  f\
rom (select A.SECTION_CODE ,A.TEST_CODE ,Z.LONG_DESC ,NVL(A.WORK_UNITS,0) WO\
RK_UNITS ,nvl(a.WORK_UNIT_ADD_FACTOR,0) WORK_UNIT_ADD_FACTOR ,TO_CHAR(B.RESU\
LT_DATE,'DD/MM/YYYY') RESULT_DATE ,TO_CHAR((((((((((((((((((((((((NVL(B.H1,0\
)+NVL(B.H2,0))+NVL(B.H3,0))+NVL(B.H4,0))+NVL(B.H5,0))+NVL(B.H6,0))+NVL(B.H7,\
0))+NVL(B.H8,0))+NVL(B.H9,0))+NVL(B.H10,0))+NVL(B.H11,0))+NVL(B.H12,0))+NVL(\
B.H13,0))+NVL(B.H14,0))+NVL(B.H15,0))+NVL(B.H16,0))+NVL(B.H17,0))+NVL(B.H18,\
0))+NVL(B.H19,0))+NVL(B.H20,0))+NVL(B.H21,0))+NVL(B.H22,0))+NVL(B.H23,0))+NV\
L(B.H24,0))) DAILY_TOTAL ,TO_CHAR((((((((((((((((((((((((NVL(B.AH1,0)+NVL(B.\
AH2,0))+NVL(B.AH3,0))+NVL(B.AH4,0))+NVL(B.AH5,0))+NVL(B.AH6,0))+NVL(B.AH7,0)\
)+NVL(B.AH8,0))+NVL(B.AH9,0))+NVL(B.AH10,0))+NVL(B.AH11,0))+NVL(B.AH12,0))+N\
VL(B.AH13,0))+NVL(B.AH14,0))+NVL(B.AH15,0))+NVL(B.AH16,0))+NVL(B.AH17,0))+NV\
L(B.AH18,0))+NVL(B.AH19,0))+NVL(B.AH20,0)");
  sqlstm.stmt = sq0012;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )326;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_date_from;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_date_to;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_section_code_fm;
  sqlstm.sqhstl[3] = (unsigned int  )22;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_section_code_to;
  sqlstm.sqhstl[4] = (unsigned int  )22;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&language_id;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_source_type;
  sqlstm.sqhstl[6] = (unsigned int  )35;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_source_fm;
  sqlstm.sqhstl[7] = (unsigned int  )32;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_source_to;
  sqlstm.sqhstl[8] = (unsigned int  )32;
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


  }
 }
 else   /*	Added by Durai Rajkumar against ML-SD-CRF-20239	*/
 {
 if (d_workgroup.arr[0] != '\0')
  {
   /* EXEC SQL DECLARE RESULT_WORKLOAD3 CURSOR FOR
     SELECT SECTION_CODE, TEST_CODE, LONG_DESC, WORK_UNITS, WORK_UNIT_ADD_FACTOR, RESULT_DATE,
	 SUM(DAILY_TOTAL) DAILY_TOTAL, SUM(ADD_TOTAL) ADD_TOTAL
	 FROM
	 (
	 SELECT A.SECTION_CODE,A.TEST_CODE,A.LONG_DESC,
     NVL(A.WORK_UNITS,0) WORK_UNITS, nvl(a.WORK_UNIT_ADD_FACTOR,0) WORK_UNIT_ADD_FACTOR,
	 TO_CHAR(B.RESULT_DATE,'DD/MM/YYYY') RESULT_DATE,
     TO_CHAR((NVL(B.H1,0) + NVL(B.H2,0) + NVL(B.H3,0) + NVL(B.H4,0) + NVL(B.H5,0) + NVL(B.H6,0)+
     NVL(B.H7,0) + NVL(B.H8,0) + NVL(B.H9,0) + NVL(B.H10,0)+ NVL(B.H11,0) + NVL(B.H12,0)+
     NVL(B.H13,0) + NVL(B.H14,0) + NVL(B.H15,0) + NVL(B.H16,0)+ NVL(B.H17,0) + NVL(B.H18,0)+
     NVL(B.H19,0) + NVL(B.H20,0) + NVL(B.H21,0) + NVL(B.H22,0)+ NVL(B.H23,0) + NVL(B.H24,0))) DAILY_TOTAL,
     TO_CHAR(( NVL(B.AH1,0) + NVL(B.AH2,0) + NVL(B.AH3,0) + NVL(B.AH4,0) + NVL(B.AH5,0) + NVL(B.AH6,0)+
     NVL(B.AH7,0) + NVL(B.AH8,0) + NVL(B.AH9,0) + NVL(B.AH10,0)+ NVL(B.AH11,0) + NVL(B.AH12,0)+
     NVL(B.AH13,0) + NVL(B.AH14,0) + NVL(B.AH15,0) + NVL(B.AH16,0)+ NVL(B.AH17,0) + NVL(B.AH18,0)+
     NVL(B.AH19,0) + NVL(B.AH20,0) + NVL(B.AH21,0) + NVL(B.AH22,0)+ NVL(B.AH23,0) + NVL(B.AH24,0))) ADD_TOTAL
     FROM   RL_TEST_CODE A, RL_RES_ACT_WORKLOAD_DAILY B
     WHERE  A.TEST_CODE = B.TEST_CODE
	 AND B.RESULT_DATE  >= TO_DATE(:d_date_from,'DD/MM/YYYY')
     AND B.RESULT_DATE  < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
     AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND A.SECTION_CODE BETWEEN :d_section_code_fm 
     AND :d_section_code_to
     AND  NVL(A.STATISTICS_YN,'N') = 'Y'
/o -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
	 AND nvl(B.SOURCE_TYPE,'!') = nvl(:d_source_type,nvl(B.SOURCE_TYPE,'!')) 
	 AND nvl(B.SOURCE_CODE,'!') BETWEEN :d_source_fm
	 AND :d_source_to
/o -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
/o	Added by Durai Rajkumar against ML-SD-CRF-20239	o/

	AND A.TEST_CODE IN (SELECT DISTINCT TEST_CODE
	    	            FROM RL_REFERRED_TEST_CODE
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
						AND TEST_CODE = A.TEST_CODE
				        union
				        SELECT TEST_CODE 
				        FROM RL_GROUP_TEST_DETAIL
				        WHERE GROUP_TEST_CODE IN (SELECT DISTINCT P.TEST_CODE
												  FROM RL_REFERRED_TEST_CODE P ,RL_TEST_CODE Q
												  WHERE P.OPERATING_FACILITY_ID = :nd_operating_facility_id
												  AND P.TEST_CODE = Q.TEST_CODE
												  AND NVL(Q.GROUP_TEST_YN,'N') = 'Y'
												  )
                        )
/o	Ends against ML-SD-CRF-20239	o/
	 AND A.TEST_CODE in (select C.TEST_CODE from RL_OUTST_WORK_GROUP_DTL C 
     where C.OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND C.OUTST_WORK_GROUP_CODE = nvl(:d_workgroup,C.OUTST_WORK_GROUP_CODE))
	 )
	 GROUP BY SECTION_CODE, TEST_CODE, LONG_DESC, RESULT_DATE, WORK_UNITS, WORK_UNIT_ADD_FACTOR
     ORDER BY  SECTION_CODE, TEST_CODE,RESULT_DATE; */ 

	 /* EXEC SQL OPEN RESULT_WORKLOAD3; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select SECTION_CODE ,TEST_CODE ,LONG_DESC ,WORK_UNITS ,WORK_UNIT_ADD_FA\
CTOR ,RESULT_DATE ,sum(DAILY_TOTAL) DAILY_TOTAL ,sum(ADD_TOTAL) ADD_TOTAL  f\
rom (select A.SECTION_CODE ,A.TEST_CODE ,A.LONG_DESC ,NVL(A.WORK_UNITS,0) WO\
RK_UNITS ,nvl(a.WORK_UNIT_ADD_FACTOR,0) WORK_UNIT_ADD_FACTOR ,TO_CHAR(B.RESU\
LT_DATE,'DD/MM/YYYY') RESULT_DATE ,TO_CHAR((((((((((((((((((((((((NVL(B.H1,0\
)+NVL(B.H2,0))+NVL(B.H3,0))+NVL(B.H4,0))+NVL(B.H5,0))+NVL(B.H6,0))+NVL(B.H7,\
0))+NVL(B.H8,0))+NVL(B.H9,0))+NVL(B.H10,0))+NVL(B.H11,0))+NVL(B.H12,0))+NVL(\
B.H13,0))+NVL(B.H14,0))+NVL(B.H15,0))+NVL(B.H16,0))+NVL(B.H17,0))+NVL(B.H18,\
0))+NVL(B.H19,0))+NVL(B.H20,0))+NVL(B.H21,0))+NVL(B.H22,0))+NVL(B.H23,0))+NV\
L(B.H24,0))) DAILY_TOTAL ,TO_CHAR((((((((((((((((((((((((NVL(B.AH1,0)+NVL(B.\
AH2,0))+NVL(B.AH3,0))+NVL(B.AH4,0))+NVL(B.AH5,0))+NVL(B.AH6,0))+NVL(B.AH7,0)\
)+NVL(B.AH8,0))+NVL(B.AH9,0))+NVL(B.AH10,0))+NVL(B.AH11,0))+NVL(B.AH12,0))+N\
VL(B.AH13,0))+NVL(B.AH14,0))+NVL(B.AH15,0))+NVL(B.AH16,0))+NVL(B.AH17,0))+NV\
L(B.AH18,0))+NVL(B.AH19,0))+NVL(B.AH20,0)");
  sqlbuft((void **)0, 
    ")+NVL(B.AH21,0))+NVL(B.AH22,0))+NVL(B.AH23,0))+NVL(B.AH24,0))) ADD_TOTA\
L  from RL_TEST_CODE A ,RL_RES_ACT_WORKLOAD_DAILY B where (((((((((A.TEST_CO\
DE=B.TEST_CODE and B.RESULT_DATE>=TO_DATE(:b0,'DD/MM/YYYY')) and B.RESULT_DA\
TE<(TO_DATE(:b1,'DD/MM/YYYY')+1)) and B.OPERATING_FACILITY_ID=:b2) and A.SEC\
TION_CODE between :b3 and :b4) and NVL(A.STATISTICS_YN,'N')='Y') and nvl(B.S\
OURCE_TYPE,'!')=nvl(:b5,nvl(B.SOURCE_TYPE,'!'))) and nvl(B.SOURCE_CODE,'!') \
between :b6 and :b7) and A.TEST_CODE in (select distinct TEST_CODE  from RL_\
REFERRED_TEST_CODE where (OPERATING_FACILITY_ID=:b2 and TEST_CODE=A.TEST_COD\
E) union select TEST_CODE  from RL_GROUP_TEST_DETAIL where GROUP_TEST_CODE i\
n (select distinct P.TEST_CODE  from RL_REFERRED_TEST_CODE P ,RL_TEST_CODE Q\
 where ((P.OPERATING_FACILITY_ID=:b2 and P.TEST_CODE=Q.TEST_CODE) and NVL(Q.\
GROUP_TEST_YN,'N')='Y')))) and A.TEST_CODE in (select C.TEST_CODE  from RL_O\
UTST_WORK_GROUP_DTL C where (C.OPERATING_FACILITY_ID=:b2 and C.OUTST_WORK_GR\
OUP_CODE=nvl(:b11,C.OUTST_WORK_GROUP_CODE");
  sqlstm.stmt = sq0013;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )377;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_date_from;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_date_to;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_section_code_fm;
  sqlstm.sqhstl[3] = (unsigned int  )22;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_section_code_to;
  sqlstm.sqhstl[4] = (unsigned int  )22;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_source_type;
  sqlstm.sqhstl[5] = (unsigned int  )35;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_source_fm;
  sqlstm.sqhstl[6] = (unsigned int  )32;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_source_to;
  sqlstm.sqhstl[7] = (unsigned int  )32;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[8] = (unsigned int  )32;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[9] = (unsigned int  )32;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[10] = (unsigned int  )32;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_workgroup;
  sqlstm.sqhstl[11] = (unsigned int  )52;
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


		}
  else
  {
   /* EXEC SQL DECLARE RESULT_WORKLOAD4 CURSOR FOR
     SELECT SECTION_CODE, TEST_CODE, LONG_DESC, WORK_UNITS, WORK_UNIT_ADD_FACTOR, RESULT_DATE,
	 SUM(DAILY_TOTAL) DAILY_TOTAL, SUM(ADD_TOTAL) ADD_TOTAL
	 FROM
	 (
	 SELECT A.SECTION_CODE,A.TEST_CODE,A.LONG_DESC,
     NVL(A.WORK_UNITS,0) WORK_UNITS, nvl(a.WORK_UNIT_ADD_FACTOR,0) WORK_UNIT_ADD_FACTOR,
	 TO_CHAR(B.RESULT_DATE,'DD/MM/YYYY') RESULT_DATE,
     TO_CHAR((NVL(B.H1,0) + NVL(B.H2,0) + NVL(B.H3,0) + NVL(B.H4,0) + NVL(B.H5,0) + NVL(B.H6,0)+
     NVL(B.H7,0) + NVL(B.H8,0) + NVL(B.H9,0) + NVL(B.H10,0)+ NVL(B.H11,0) + NVL(B.H12,0)+
     NVL(B.H13,0) + NVL(B.H14,0) + NVL(B.H15,0) + NVL(B.H16,0)+ NVL(B.H17,0) + NVL(B.H18,0)+
     NVL(B.H19,0) + NVL(B.H20,0) + NVL(B.H21,0) + NVL(B.H22,0)+ NVL(B.H23,0) + NVL(B.H24,0))) DAILY_TOTAL,
     TO_CHAR(( NVL(B.AH1,0) + NVL(B.AH2,0) + NVL(B.AH3,0) + NVL(B.AH4,0) + NVL(B.AH5,0) + NVL(B.AH6,0)+
     NVL(B.AH7,0) + NVL(B.AH8,0) + NVL(B.AH9,0) + NVL(B.AH10,0)+ NVL(B.AH11,0) + NVL(B.AH12,0)+
     NVL(B.AH13,0) + NVL(B.AH14,0) + NVL(B.AH15,0) + NVL(B.AH16,0)+ NVL(B.AH17,0) + NVL(B.AH18,0)+
     NVL(B.AH19,0) + NVL(B.AH20,0) + NVL(B.AH21,0) + NVL(B.AH22,0)+ NVL(B.AH23,0) + NVL(B.AH24,0))) ADD_TOTAL
     FROM   RL_TEST_CODE A, RL_RES_ACT_WORKLOAD_DAILY B
     WHERE  A.TEST_CODE = B.TEST_CODE
     AND B.RESULT_DATE  >= TO_DATE(:d_date_from,'DD/MM/YYYY')
     AND B.RESULT_DATE < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
     AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND A.SECTION_CODE BETWEEN :d_section_code_fm 
		       AND :d_section_code_to
     AND  NVL(A.STATISTICS_YN,'N') = 'Y' 

/o	Added by Durai Rajkumar against ML-SD-CRF-20239	o/

	AND A.TEST_CODE IN (SELECT DISTINCT TEST_CODE
	    	            FROM RL_REFERRED_TEST_CODE
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
						AND TEST_CODE = A.TEST_CODE
				        union
				        SELECT TEST_CODE 
				        FROM RL_GROUP_TEST_DETAIL
				        WHERE GROUP_TEST_CODE IN (SELECT DISTINCT P.TEST_CODE
												  FROM RL_REFERRED_TEST_CODE P ,RL_TEST_CODE Q
												  WHERE P.OPERATING_FACILITY_ID = :nd_operating_facility_id
												  AND P.TEST_CODE = Q.TEST_CODE
												  AND NVL(Q.GROUP_TEST_YN,'N') = 'Y'
												  )
                        )
/o	Ends against ML-SD-CRF-20239	o/

/o -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
	 AND nvl(B.SOURCE_TYPE,'!') = nvl(:d_source_type,nvl(B.SOURCE_TYPE,'!')) 
	 AND nvl(B.SOURCE_CODE,'!') BETWEEN :d_source_fm  AND :d_source_to	 )
	 
	 GROUP BY SECTION_CODE, TEST_CODE, LONG_DESC, RESULT_DATE, WORK_UNITS, WORK_UNIT_ADD_FACTOR
/o -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- o/
     ORDER BY  SECTION_CODE, TEST_CODE,RESULT_DATE; */ 

	 /* EXEC SQL OPEN RESULT_WORKLOAD4; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select SECTION_CODE ,TEST_CODE ,LONG_DESC ,WORK_UNITS ,WORK_UNIT_ADD_FA\
CTOR ,RESULT_DATE ,sum(DAILY_TOTAL) DAILY_TOTAL ,sum(ADD_TOTAL) ADD_TOTAL  f\
rom (select A.SECTION_CODE ,A.TEST_CODE ,A.LONG_DESC ,NVL(A.WORK_UNITS,0) WO\
RK_UNITS ,nvl(a.WORK_UNIT_ADD_FACTOR,0) WORK_UNIT_ADD_FACTOR ,TO_CHAR(B.RESU\
LT_DATE,'DD/MM/YYYY') RESULT_DATE ,TO_CHAR((((((((((((((((((((((((NVL(B.H1,0\
)+NVL(B.H2,0))+NVL(B.H3,0))+NVL(B.H4,0))+NVL(B.H5,0))+NVL(B.H6,0))+NVL(B.H7,\
0))+NVL(B.H8,0))+NVL(B.H9,0))+NVL(B.H10,0))+NVL(B.H11,0))+NVL(B.H12,0))+NVL(\
B.H13,0))+NVL(B.H14,0))+NVL(B.H15,0))+NVL(B.H16,0))+NVL(B.H17,0))+NVL(B.H18,\
0))+NVL(B.H19,0))+NVL(B.H20,0))+NVL(B.H21,0))+NVL(B.H22,0))+NVL(B.H23,0))+NV\
L(B.H24,0))) DAILY_TOTAL ,TO_CHAR((((((((((((((((((((((((NVL(B.AH1,0)+NVL(B.\
AH2,0))+NVL(B.AH3,0))+NVL(B.AH4,0))+NVL(B.AH5,0))+NVL(B.AH6,0))+NVL(B.AH7,0)\
)+NVL(B.AH8,0))+NVL(B.AH9,0))+NVL(B.AH10,0))+NVL(B.AH11,0))+NVL(B.AH12,0))+N\
VL(B.AH13,0))+NVL(B.AH14,0))+NVL(B.AH15,0))+NVL(B.AH16,0))+NVL(B.AH17,0))+NV\
L(B.AH18,0))+NVL(B.AH19,0))+NVL(B.AH20,0)");
  sqlstm.stmt = sq0014;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )440;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_date_from;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_date_to;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_section_code_fm;
  sqlstm.sqhstl[3] = (unsigned int  )22;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_section_code_to;
  sqlstm.sqhstl[4] = (unsigned int  )22;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )32;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )32;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_source_type;
  sqlstm.sqhstl[7] = (unsigned int  )35;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_source_fm;
  sqlstm.sqhstl[8] = (unsigned int  )32;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_source_to;
  sqlstm.sqhstl[9] = (unsigned int  )32;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
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



   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )495;
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
  void prepare_new_page(int nn); 
  void print_detl_rec();
  void end_report();
  void print_test_total();
  int fetch_result_workload();
  int still_rec_left;


  print_rep_header(); /*  once for the report */
  
  page_no += 1; /* icrement by 1 as it is moving to second page */
 
  print_page_header();
  
  /* read the first cursor record */
  
  still_rec_left = fetch_result_workload();

  print_col_heading();
  print_section_desc(0);
  line_no = 9; /* line no changed from 6 by sunil on 16-10-2007 */
    
  while(still_rec_left)
  {
  /* -- added from here  by sunil on 16-10-2007--- */
	   if (strcmp(d_section_code.arr,t_section_code.arr) != 0)
		{
			if (line_no > 9)
			{
				if (line_no + 3 < MAX_LINES)
				{
					print_section_desc(0);
					line_no += 1;
				}
				else
					prepare_new_page(0);
			}
		}
  /* -- added upto here  by sunil on 16-10-2007--- */
    strcpy(t_section_code.arr,d_section_code.arr);
    t_section_code.len = strlen(d_section_code.arr);
	
	strcpy(t_test_code.arr,d_test_code.arr);
    t_test_code.len = strlen(d_test_code.arr);
	test_start = 1;
	wu_line    = 0;


    while(still_rec_left && (strcmp(d_section_code.arr,t_section_code.arr)==0) && (strcmp(d_test_code.arr,t_test_code.arr)==0))
    {
		if(line_no >= MAX_LINES)
			prepare_new_page(0);

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
	//		prepare_new_page(0);

		if (line_no + 3 < MAX_LINES)
		{
			fprintf(f1, "\n\n\n");
			line_no += 3;
		}
		else
			prepare_new_page(0);
		
	}
  }
  end_report();
}

void print_test_total()
{
     //fprintf(f1,"\n************** T E S T   T O T A L **************");
     fprintf(f1,"************** %s **************\n", local_legend[1]); //added for globalisation
     fprintf(f1,"%12ld%8ld%22.0f\n\n",test_no_of_tests,test_add_tot,test_total_units);
     test_no_of_tests = 0;
     test_add_tot = 0;
     test_total_units = 0;

	 line_no += 3;
}

print_section_total()
{
	/* -- from here added by sunil on 18/10/2007 as per SD-CRF-20071 --- */
	if ((strcmp(t_section_ind.arr,"SA") == 0) ||(strcmp(t_section_ind.arr,"AT") == 0))
	{
		double sec_dept_tot =0;
		if (strcmp(t_section_ind.arr,"SA") == 0)
		{
		print_sec_tot_h1();
		print_sec_tot_h2();
		print_sec_tot_cc();
		sec_tot = sec_tot_ctl_sld + sec_tot_blk + sec_tot_he_sld + sec_tot_spl_stn;
		}
		else
		{
		print_sec_tot_cy();
		print_sec_tot_cc();
		sec_tot =  sec_tot_smear + sec_tot_spl_stn;
		}
		sec_dept_tot = dept_total_units + sec_tot;
		//fprintf(f1,"\n****** D E P A R T M E N T   T O T A L   ********");
		fprintf(f1,"****** %s   ********\n", local_legend[2]); // added for globalisation
		fprintf(f1,"%12ld%8ld%12d%10.0f\n\n",dept_no_of_tests,dept_add_tot,sec_tot,sec_dept_tot);
//		fprintf(f1,"\n                                     Workload");
//		fprintf(f1,"%16s%5d\n",t_section_desc.arr,sec_tot);
		dept_no_of_tests = 0;
		dept_add_tot = 0;
		dept_total_units = 0;
		line_no += 3;
	}
	else
	/* -- upto here added by sunil on 18/10/2007 as per SD-CRF-20071 --- */
	{
	//fprintf(f1,"\n****** D E P A R T M E N T   T O T A L   ********");
	fprintf(f1,"****** %s   ********\n", local_legend[2]);// added for globalisation
//	fprintf(f1,"%16ld%12ld%15.0f\n\n",dept_no_of_tests,dept_add_tot,dept_total_units);
	fprintf(f1,"%12ld%8ld%22.0f\n\n",dept_no_of_tests,dept_add_tot,dept_total_units);
	dept_no_of_tests = 0;
	dept_add_tot = 0;
	dept_total_units = 0;
	line_no += 3;
	}
}

/* -- from here added by sunil on 18/10/2007 as per SD-CRF-20071 --- */
print_sec_tot_h1()
{ 
 //   sprintf(string_var,"%s",t_section_code);
//	disp_message(ERR_MESG,string_var);

	/* EXEC SQL SELECT NVL(SUM(NVL(NO_OF_CONTROL_SLIDES, 0)), 0), COUNT(1)
	INTO :sec_tot_ctl_sld, :sec_tot_blk
	FROM RL_SAMPLE_DETAILS A, RL_BLOCKS_FOR_SAMPLE B	
	WHERE A.operating_facility_id = :nd_operating_facility_id
	AND A.specimen_no = B.specimen_no
	AND A.operating_facility_id = B.operating_facility_id
	AND (A.specimen_no, A.operating_facility_id)
		IN (SELECT C.specimen_no, C.operating_facility_id	
		from rl_request_detail c, rl_test_result D
		WHERE C.released_date >= TO_DATE(:d_date_from, 'DD/MM/YYYY')
		AND C.released_date < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
		AND C.operating_facility_id = :nd_operating_facility_id
		AND D.patient_id = C.patient_id
		AND D.specimen_no = C.specimen_no
		AND D.operating_facility_id = C.operating_facility_id
		AND NVL(C.result_status, 'O') IN ('R', 'P')
		AND C.section_code = :t_section_code); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(sum(NVL(NO_OF_CONTROL_SLIDES,0)),0) ,count(1) int\
o :b0,:b1  from RL_SAMPLE_DETAILS A ,RL_BLOCKS_FOR_SAMPLE B where (((A.operati\
ng_facility_id=:b2 and A.specimen_no=B.specimen_no) and A.operating_facility_i\
d=B.operating_facility_id) and (A.specimen_no,A.operating_facility_id) in (sel\
ect C.specimen_no ,C.operating_facility_id  from rl_request_detail c ,rl_test_\
result D where (((((((C.released_date>=TO_DATE(:b3,'DD/MM/YYYY') and C.release\
d_date<(TO_DATE(:b4,'DD/MM/YYYY')+1)) and C.operating_facility_id=:b2) and D.p\
atient_id=C.patient_id) and D.specimen_no=C.specimen_no) and D.operating_facil\
ity_id=C.operating_facility_id) and NVL(C.result_status,'O') in ('R','P')) and\
 C.section_code=:b6)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )510;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sec_tot_ctl_sld;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sec_tot_blk;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_date_from;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_date_to;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&t_section_code;
 sqlstm.sqhstl[6] = (unsigned int  )82;
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


 //   sprintf(string_var,"%d   %d",sec_tot_ctl_sld,sec_tot_blk);
//	disp_message(ERR_MESG,string_var);
}

print_sec_tot_h2()
{
//	disp_message(ORA_MESG,"inside H2 before sql qry...\n");
 //   sprintf(string_var,"%s",t_section_code);
//	disp_message(ERR_MESG,string_var);

	/* EXEC SQL SELECT COUNT(1)
	INTO :sec_tot_he_sld
	FROM RL_TASK_MAST A, RL_SAMPLE_TASK_DTL B
	WHERE B.operating_facility_id = :nd_operating_facility_id
	AND A.task_code = B.task_code
	AND A.section_code = :t_section_code
	AND NVL(A.slide_yn, 'N') = 'Y'
	AND (B.specimen_no, B.operating_facility_id)
		IN (SELECT C.specimen_no, C.operating_facility_id	
		from rl_request_detail c, rl_test_result D
		WHERE C.released_date >= TO_DATE(:d_date_from, 'DD/MM/YYYY')
		AND C.released_date < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
		AND C.operating_facility_id = :nd_operating_facility_id
		AND D.patient_id = C.patient_id
		AND D.specimen_no = C.specimen_no
		AND D.operating_facility_id = C.operating_facility_id
		AND NVL(C.result_status, 'O') IN ('R', 'P')
		AND C.section_code = :t_section_code); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_TASK_MAST A ,RL_SAMPLE_TAS\
K_DTL B where ((((B.operating_facility_id=:b1 and A.task_code=B.task_code) and\
 A.section_code=:b2) and NVL(A.slide_yn,'N')='Y') and (B.specimen_no,B.operati\
ng_facility_id) in (select C.specimen_no ,C.operating_facility_id  from rl_req\
uest_detail c ,rl_test_result D where (((((((C.released_date>=TO_DATE(:b3,'DD/\
MM/YYYY') and C.released_date<(TO_DATE(:b4,'DD/MM/YYYY')+1)) and C.operating_f\
acility_id=:b1) and D.patient_id=C.patient_id) and D.specimen_no=C.specimen_no\
) and D.operating_facility_id=C.operating_facility_id) and NVL(C.result_status\
,'O') in ('R','P')) and C.section_code=:b2)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )553;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sec_tot_he_sld;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&t_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )82;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_date_from;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_date_to;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&t_section_code;
 sqlstm.sqhstl[6] = (unsigned int  )82;
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


//	disp_message(ORA_MESG,"inside H2 after sql qry...\n");

}

print_sec_tot_cy()
{
	/* EXEC SQL SELECT COUNT(1)
	INTO :sec_tot_smear
	FROM RL_TASK_MAST A, RL_SAMPLE_TASK_DTL B
	WHERE B.operating_facility_id = :nd_operating_facility_id
	AND A.task_code = B.task_code
	AND A.section_code = :t_section_code
	AND NVL(A.slide_yn, 'N') = 'Y'
	AND (B.specimen_no, B.operating_facility_id)
		IN (SELECT C.specimen_no, C.operating_facility_id	
		from rl_request_detail c, rl_test_result D
		WHERE C.released_date >= TO_DATE(:d_date_from, 'DD/MM/YYYY')
		AND C.released_date < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
		AND C.operating_facility_id = :nd_operating_facility_id
		AND D.patient_id = C.patient_id
		AND D.specimen_no = C.specimen_no
		AND D.operating_facility_id = C.operating_facility_id
		AND NVL(C.result_status, 'O') IN ('R', 'P')
		AND C.section_code = :t_section_code); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_TASK_MAST A ,RL_SAMPLE_TAS\
K_DTL B where ((((B.operating_facility_id=:b1 and A.task_code=B.task_code) and\
 A.section_code=:b2) and NVL(A.slide_yn,'N')='Y') and (B.specimen_no,B.operati\
ng_facility_id) in (select C.specimen_no ,C.operating_facility_id  from rl_req\
uest_detail c ,rl_test_result D where (((((((C.released_date>=TO_DATE(:b3,'DD/\
MM/YYYY') and C.released_date<(TO_DATE(:b4,'DD/MM/YYYY')+1)) and C.operating_f\
acility_id=:b1) and D.patient_id=C.patient_id) and D.specimen_no=C.specimen_no\
) and D.operating_facility_id=C.operating_facility_id) and NVL(C.result_status\
,'O') in ('R','P')) and C.section_code=:b2)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )596;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sec_tot_smear;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&t_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )82;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_date_from;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_date_to;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&t_section_code;
 sqlstm.sqhstl[6] = (unsigned int  )82;
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

print_sec_tot_cc()
{
	/* EXEC SQL SELECT COUNT(1)
	INTO :sec_tot_spl_stn
	FROM RL_TASK_MAST A, RL_SAMPLE_TASK_DTL B
	WHERE B.operating_facility_id = :nd_operating_facility_id
	AND A.task_code = B.task_code
	AND A.section_code = :t_section_code
	AND NVL(A.slide_yn, 'N') = 'Y'
	AND NVL(A.special_stain_yn, 'N') = 'Y'
	AND (B.specimen_no, B.operating_facility_id)
		IN (SELECT C.specimen_no, C.operating_facility_id	
			from rl_request_detail c, rl_test_result D
			WHERE C.released_date >= TO_DATE(:d_date_from, 'DD/MM/YYYY')
			AND C.released_date < TO_DATE(:d_date_to,'DD/MM/YYYY') + 1
			AND C.operating_facility_id = :nd_operating_facility_id
			AND D.patient_id = C.patient_id
			AND D.specimen_no = C.specimen_no
			AND D.operating_facility_id = C.operating_facility_id
			AND NVL(C.result_status, 'O') IN ('R', 'P')
			AND C.section_code = :t_section_code); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_TASK_MAST A ,RL_SAMPLE_TAS\
K_DTL B where (((((B.operating_facility_id=:b1 and A.task_code=B.task_code) an\
d A.section_code=:b2) and NVL(A.slide_yn,'N')='Y') and NVL(A.special_stain_yn,\
'N')='Y') and (B.specimen_no,B.operating_facility_id) in (select C.specimen_no\
 ,C.operating_facility_id  from rl_request_detail c ,rl_test_result D where ((\
(((((C.released_date>=TO_DATE(:b3,'DD/MM/YYYY') and C.released_date<(TO_DATE(:\
b4,'DD/MM/YYYY')+1)) and C.operating_facility_id=:b1) and D.patient_id=C.patie\
nt_id) and D.specimen_no=C.specimen_no) and D.operating_facility_id=C.operatin\
g_facility_id) and NVL(C.result_status,'O') in ('R','P')) and C.section_code=:\
b2)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )639;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sec_tot_spl_stn;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&t_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )82;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_date_from;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_date_to;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&t_section_code;
 sqlstm.sqhstl[6] = (unsigned int  )82;
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
/* -- upto here added by sunil on 18/10/2007 as per SD-CRF-20071 --- */

void print_section_desc(int nn)
{
	if (nn ==0) /* -- if condition added by sunil on 17/10/2007 as per SD-CRF-20071 --- */
	{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL SELECT LONG_NAME, USE_SAMPLE_ANATOMY_IND /o description of the section o/
		    INTO :t_section_desc, :t_section_ind
			FROM RL_SECTION_CODE_LANG_VW
			WHERE SECTION_CODE = :d_section_code
			AND LANGUAGE_ID = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_NAME ,USE_SAMPLE_ANATOMY_IND into :b0,:b1  from \
RL_SECTION_CODE_LANG_VW where (SECTION_CODE=:b2 and LANGUAGE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )682;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&t_section_desc;
 sqlstm.sqhstl[0] = (unsigned int  )83;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&t_section_ind;
 sqlstm.sqhstl[1] = (unsigned int  )88;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	t_section_desc.arr[t_section_desc.len] = '\0';
	t_section_ind.arr[t_section_ind.len] = '\0';

	fprintf(f1,"%-40s\n",t_section_desc.arr);
	fprintf(f1, "\n"); /* added by sunil on 16-10-2007 */
	return;
	err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )713;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at print_section_desc() occured....\n");
	proc_exit();
	}
	else
	fprintf(f1,"%-40s\n",t_section_desc.arr);
	fprintf(f1, "\n"); /* added by sunil on 16-10-2007 */
}
   
/* prepares for the new page */
void prepare_new_page(int nn)
{
   page_no += 1; /* incr. by 1 to move to subsequent pages */
   fprintf(f1,"\f");
   print_page_header();
   print_col_heading(); 
   print_section_desc(nn); 
   line_no = 9; /* line no changed from 6 by sunil on 16-10-2007 */
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
  d_result_date1.arr[0]   = '\0';	/*	Added by Durai Rajkumar against ML-SD-SCF-20239	*/

  d_section_code.len = 0;
  d_test_code.len = 0;
  d_test_desc.len = 0;
  d_work_units.len = 0;
  d_add_work_units.len = 0;
  d_daily_tot.len = 0;
  d_add_tot.len = 0;
  d_result_date.len = 0;
  d_result_date1.len = 0;			/*	Added by Durai Rajkumar against ML-SD-SCF-20239	*/


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   
if (strcmp(d_option.arr,"R") != 0)		/*	Added by Durai Rajkumar against ML-SD-SCF-20239	*/
{
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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )728;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_section_code;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )32;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_test_desc;
  sqlstm.sqhstl[2] = (unsigned int  )102;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_work_units;
  sqlstm.sqhstl[3] = (unsigned int  )82;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_add_work_units;
  sqlstm.sqhstl[4] = (unsigned int  )82;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_result_date;
  sqlstm.sqhstl[5] = (unsigned int  )83;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_daily_tot;
  sqlstm.sqhstl[6] = (unsigned int  )82;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_add_tot;
  sqlstm.sqhstl[7] = (unsigned int  )82;
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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )775;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_section_code;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )32;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_test_desc;
  sqlstm.sqhstl[2] = (unsigned int  )102;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_work_units;
  sqlstm.sqhstl[3] = (unsigned int  )82;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_add_work_units;
  sqlstm.sqhstl[4] = (unsigned int  )82;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_result_date;
  sqlstm.sqhstl[5] = (unsigned int  )83;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_daily_tot;
  sqlstm.sqhstl[6] = (unsigned int  )82;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_add_tot;
  sqlstm.sqhstl[7] = (unsigned int  )82;
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


}
else									/*	Added by Durai Rajkumar against ML-SD-SCF-20239	*/
{
  if (d_workgroup.arr[0] != '\0')
  /* EXEC SQL FETCH RESULT_WORKLOAD3 INTO
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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )822;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_section_code;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )32;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_test_desc;
  sqlstm.sqhstl[2] = (unsigned int  )102;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_work_units;
  sqlstm.sqhstl[3] = (unsigned int  )82;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_add_work_units;
  sqlstm.sqhstl[4] = (unsigned int  )82;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_result_date;
  sqlstm.sqhstl[5] = (unsigned int  )83;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_daily_tot;
  sqlstm.sqhstl[6] = (unsigned int  )82;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_add_tot;
  sqlstm.sqhstl[7] = (unsigned int  )82;
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
  /* EXEC SQL FETCH RESULT_WORKLOAD4 INTO
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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )869;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_section_code;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )32;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_test_desc;
  sqlstm.sqhstl[2] = (unsigned int  )102;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_work_units;
  sqlstm.sqhstl[3] = (unsigned int  )82;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_add_work_units;
  sqlstm.sqhstl[4] = (unsigned int  )82;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_result_date;
  sqlstm.sqhstl[5] = (unsigned int  )83;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_daily_tot;
  sqlstm.sqhstl[6] = (unsigned int  )82;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_add_tot;
  sqlstm.sqhstl[7] = (unsigned int  )82;
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
d_result_date1.arr[d_result_date1.len]    = '\0';	/*	Added by Durai Rajkumar against ML-SD-SCF-20239	*/     

return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )916;
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
int rec_len;
  fprintf(f1,"\n\n\n");
  /*	Commented & added by Durai Rajkumar against ML-SD-CRF-20239	*/
  //fprintf(f1,"                                                   ");
  //fprintf(f1,"** End of Report **");
  rec_len = strlen(local_legend[3]);
  print_space(REP_WIDTH/2, (rec_len/2)+3,1);
  /* Ends against ML-SD-CRF-20239	*/
  fprintf(f1,"** %s **",local_legend[3]);
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


            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_result_date,'DD/MM/YYYY'), :language_id , t_date);
				//:d_result_date1 := to_char(t_date,'DD/MM/YYYY');
				:d_result_date1 :=sm_convert_date_2t(to_date(:d_result_date,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 13;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN :d_result_date1 := sm\
_convert_date_2t ( to_date ( :d_result_date , 'DD/MM/YYYY ' ) , :language_id )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )931;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_result_date1;
            sqlstm.sqhstl[0] = (unsigned int  )83;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&d_result_date;
            sqlstm.sqhstl[1] = (unsigned int  )83;
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



 //      fprintf(f1,"%-41.41s%-11.11s %12.12s%12.12s%15.0f\n", -- modified this line by Sunil on 23-10-2007 ---
       /*fprintf(f1,"%-41.41s%-11.11s %8.8s%8.8s%22.0f\n",        Commented & added by Durai Rajkumar against ML-SD-SCF-20239 */
	     fprintf(f1,"%-42.42s%-11.11s %8.8s%8.8s%22.0f\n",
					               d_test_desc.arr,
                                   d_result_date1.arr,
								   d_daily_tot.arr,
					               d_add_tot.arr,		
					               period_units);

/********s
				d_period_units_length.arr[0] = '\0';
				d_period_units_length.len = 0;

				period_units1 = period_units;
				EXEC SQL SELECT to_char(:period_units1) 
				            INTO :d_period_units
							FROM DUAL;
				d_period_units.arr[d_period_units.len] = '\0';

				EXEC SQL SELECT :d_period_units - TRUNC(:d_period_units)
				           INTO :d_period_units_length
						   FROM DUAL;

				d_period_units_length.arr[d_period_units_length.len] = '\0';


            EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_result_date,'DD/MM/YYYY'), :language_id , t_date);
				//:d_result_date1 := to_char(t_date,'DD/MM/YYYY');
				:d_result_date1 :=sm_convert_date_2t(to_date(:d_result_date,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC;



				if(atoi(d_period_units_length.arr) > 0 ) 
				   fprintf(f1,"%-41.41s%-11.11s %12.12s%12.12s%15.3f\n",
											   d_test_desc.arr,
											   d_result_date1.arr,
											   d_daily_tot.arr,
											   d_add_tot.arr,		
											   period_units);
				else
				{
				   fprintf(f1,"%-41.41s%-11.11s %12.12s%12.12s%15s\n",
											   d_test_desc.arr,
											   d_result_date1.arr,
											   d_daily_tot.arr,
											   d_add_tot.arr,		
											   d_period_units.arr);
				}
*********************s*/

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
				d_work_units_length.arr[0] = '\0';
				d_work_units_length.len = 0;
				/* EXEC SQL SELECT :d_work_units - TRUNC(:d_work_units)
				           INTO :d_work_units_length
						   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (:b0-TRUNC(:b0)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )958;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_work_units;
    sqlstm.sqhstl[0] = (unsigned int  )82;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_work_units;
    sqlstm.sqhstl[1] = (unsigned int  )82;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_work_units_length;
    sqlstm.sqhstl[2] = (unsigned int  )82;
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
					/*	Commented & added by Durai Rajkumar against ML-SD-SCF-20239	
					//fprintf(f1,"%s: %10.3f ", local_legend[4], atof((char *)d_work_units.arr)); // added for globalisation */
					fprintf(f1,"%s:%8.3f ", local_legend[4], atof((char *)d_work_units.arr));
				else
				{
//disp_message(ERR_MESG,d_work_units.arr);
					/*fprintf(f1,"Work Units: %10f Addl: %10.3f",
								atof((char *)d_work_units.arr),
							    atof((char *)d_add_work_units.arr));*/
					//fprintf(f1,"Work Units: %-10.10s ",	d_work_units.arr);
					/*	Commented & added by Durai Rajkumar against ML-SD-SCF-20239	
					//fprintf(f1,"%s: %-10.10s ", local_legend[4], d_work_units.arr); //added for globalisation */
					fprintf(f1,"%s:%-8.8s ", local_legend[4], d_work_units.arr);
				}

				d_add_work_units_length.arr[0] = '\0';
				d_add_work_units_length.len = 0;
				/* EXEC SQL SELECT :d_add_work_units - TRUNC(:d_add_work_units)
				           INTO :d_add_work_units_length
						   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (:b0-TRUNC(:b0)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )985;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_add_work_units;
    sqlstm.sqhstl[0] = (unsigned int  )82;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_add_work_units;
    sqlstm.sqhstl[1] = (unsigned int  )82;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_add_work_units_length;
    sqlstm.sqhstl[2] = (unsigned int  )82;
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
					/*	Commented & added by Durai Rajkumar against ML-SD-SCF-20239	
					//fprintf(f1,"%s: %10.3f", local_legend[5], atof((char *)d_add_work_units.arr)); // added for globalisation */
					fprintf(f1,"%s:%10.3f", local_legend[5], atof((char *)d_add_work_units.arr));
				else
				{
					//fprintf(f1,"Addl: %-10.10s", d_add_work_units.arr);
					/*	Commented & added by Durai Rajkumar against ML-SD-SCF-20239	
					//fprintf(f1,"%s: %-10.10s", local_legend[5], d_add_work_units.arr); */
					fprintf(f1,"%s:%-10.10s", local_legend[5], d_add_work_units.arr);
				}

/**********s
				d_period_units_length.arr[0] = '\0';
				d_period_units_length.len = 0;
//				strcpy(d_period_units.arr,_fcvt(period_units));

				period_units1 = period_units;
				EXEC SQL SELECT to_char(:period_units1) 
				            INTO :d_period_units
							FROM DUAL;
				d_period_units.arr[d_period_units.len] = '\0';

				EXEC SQL SELECT :d_period_units - TRUNC(:d_period_units)
				           INTO :d_period_units_length
						   FROM DUAL;

				d_period_units_length.arr[d_period_units_length.len] = '\0';


            EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_result_date,'DD/MM/YYYY'), :language_id , t_date);
				//:d_result_date1 := to_char(t_date,'DD/MM/YYYY');
				:d_result_date1 :=sm_convert_date_2t(to_date(:d_result_date,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC;


				if(atoi(d_period_units_length.arr) > 0 ) 
					fprintf(f1,"%-2.2s%-11.11s %12.12s%12.12s%15.3f\n",
										   " ",
										   d_result_date1.arr,
										   d_daily_tot.arr,
										   d_add_tot.arr,		
										   period_units); 
				else
				{
					fprintf(f1,"%-2.2s%-11.11s %12.12s%12.12s%15s\n",
										   " ",
										   d_result_date1.arr,
										   d_daily_tot.arr,
										   d_add_tot.arr,		
										   d_period_units.arr);
				}
***************************s*/

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_result_date,'DD/MM/YYYY'), :language_id , t_date);
				//:d_result_date1 := to_char(t_date,'DD/MM/YYYY');
				:d_result_date1 :=sm_convert_date_2t(to_date(:d_result_date,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 13;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN :d_result_date1 := sm\
_convert_date_2t ( to_date ( :d_result_date , 'DD/MM/YYYY ' ) , :language_id )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1012;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_result_date1;
            sqlstm.sqhstl[0] = (unsigned int  )83;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&d_result_date;
            sqlstm.sqhstl[1] = (unsigned int  )83;
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




        //      fprintf(f1,"%-2.2s%-11.11s %12.12s%12.12s%15.0f\n", -- modified this line by Sunil on 23-10-2007 ---
				/*fprintf(f1,"%-2.2s%-11.11s %8.8s%8.8s%22.0f\n",      Commented & added by Durai Rajkumar against ML-SD-SCF-20239*/
				fprintf(f1,"%-1.1s%-11.11s %8.8s%8.8s%22.0f\n",
									   " ",
									   d_result_date1.arr,
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
									   d_result_date1.arr,
									   d_daily_tot.arr,
									   d_add_tot.arr,		
									   period_units);
				}
				else
				{ 
*/

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_result_date,'DD/MM/YYYY'), :language_id , t_date);
				//:d_result_date1 := to_char(t_date,'DD/MM/YYYY');
				:d_result_date1 :=sm_convert_date_2t(to_date(:d_result_date,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 13;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN :d_result_date1 := sm\
_convert_date_2t ( to_date ( :d_result_date , 'DD/MM/YYYY ' ) , :language_id )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1039;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_result_date1;
            sqlstm.sqhstl[0] = (unsigned int  )83;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&d_result_date;
            sqlstm.sqhstl[1] = (unsigned int  )83;
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




        //      fprintf(f1,"%-41.41s%-11.11s %12.12s%12.12s%15.0f\n", -- modified this line by Sunil on 23-10-2007 ---
				/*fprintf(f1,"%-41.41s%-11.11s %8.8s%8.8s%22.0f\n",  Commented & added by Durai Rajkumar against ML-SD-SCF-20239 */
				  fprintf(f1,"%-42.42s%-11.11s %8.8s%8.8s%22.0f\n",
									   " ",
									   d_result_date1.arr,
									   d_daily_tot.arr,
									   d_add_tot.arr,		
									   period_units);
/********************s
				d_period_units_length.arr[0] = '\0';
				d_period_units_length.len = 0;

				period_units1 = period_units;
				EXEC SQL SELECT to_char(:period_units1) 
				            INTO :d_period_units
							FROM DUAL;
				d_period_units.arr[d_period_units.len] = '\0';

				EXEC SQL SELECT :d_period_units - TRUNC(:d_period_units)
				           INTO :d_period_units_length
						   FROM DUAL;

				d_period_units_length.arr[d_period_units_length.len] = '\0';


            EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_result_date,'DD/MM/YYYY'), :language_id , t_date);
				//:d_result_date1 := to_char(t_date,'DD/MM/YYYY');
				:d_result_date1 :=sm_convert_date_2t(to_date(:d_result_date,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC;


				if(atoi(d_period_units_length.arr) > 0 ) 
					fprintf(f1,"%-41.41s%-11.11s %12.12s%12.12s%15.3f\n",
										   " ",
										   d_result_date1.arr,
										   d_daily_tot.arr,
										   d_add_tot.arr,		
										   period_units);
				else
				{
					fprintf(f1,"%-41.41s%-11.11s %12.12s%12.12s%15s\n",
										   " ",
										   d_result_date1.arr,
										   d_daily_tot.arr,
										   d_add_tot.arr,		
										   d_period_units.arr);
				}
***************************/
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

/********28.02.2006
       fprintf(f1,"Work Units: %-10.3f Addl: %10.3f",
							atof((char *)d_work_units.arr),
						    atof((char *)d_add_work_units.arr));
*************/
				d_work_units_length.arr[0] = '\0';
				d_work_units_length.len = 0;
				/* EXEC SQL SELECT :d_work_units - TRUNC(:d_work_units)
				           INTO :d_work_units_length
						   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (:b0-TRUNC(:b0)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1066;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_work_units;
    sqlstm.sqhstl[0] = (unsigned int  )82;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_work_units;
    sqlstm.sqhstl[1] = (unsigned int  )82;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_work_units_length;
    sqlstm.sqhstl[2] = (unsigned int  )82;
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
				/*	Commented & added by Durai Rajkumar against ML-SD-SCF-20239	
					fprintf(f1,"%s: %10.3f ",
								local_legend[4], atof((char *)d_work_units.arr));//added for globalisation */
					fprintf(f1,"%s:%8.3f ",local_legend[4], atof((char *)d_work_units.arr));
				else
				{
//disp_message(ERR_MESG,d_work_units.arr);
					/*fprintf(f1,"Work Units: %10f Addl: %10.3f",
								atof((char *)d_work_units.arr),
							    atof((char *)d_add_work_units.arr));*/
					//fprintf(f1,"Work Units: %-10.10s ",	d_work_units.arr);
					/*	Commented & added by Durai Rajkumar against ML-SD-SCF-20239 
					fprintf(f1,"%s: %-10.10s ", local_legend[4], d_work_units.arr); //added for globalisation */
					fprintf(f1,"%s:%-8.8s ", local_legend[4], d_work_units.arr);
				}

				d_add_work_units_length.arr[0] = '\0';
				d_add_work_units_length.len = 0;
				/* EXEC SQL SELECT :d_add_work_units - TRUNC(:d_add_work_units)
				           INTO :d_add_work_units_length
						   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (:b0-TRUNC(:b0)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1093;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_add_work_units;
    sqlstm.sqhstl[0] = (unsigned int  )82;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_add_work_units;
    sqlstm.sqhstl[1] = (unsigned int  )82;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_add_work_units_length;
    sqlstm.sqhstl[2] = (unsigned int  )82;
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
					/*	Commented & added by Durai Rajkumar against ML-SD-SCF-20239	
					//fprintf(f1,"%sl: %10.3f", local_legend[5], atof((char *)d_add_work_units.arr));//added for globalisation */
					fprintf(f1,"%sl:%10.3f", local_legend[5], atof((char *)d_add_work_units.arr));
				else
				{
					//fprintf(f1,"Addl: %-10.10s", d_add_work_units.arr);
					/*	Commented & added by Durai Rajkumar against ML-SD-SCF-20239	
					//fprintf(f1,"%s: %-10.10s", local_legend[5], d_add_work_units.arr);//added for globalisation */
					fprintf(f1,"%s:%-10.10s", local_legend[5], d_add_work_units.arr);
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1120;
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

  char nd_source_type_desc[16]; 

  char nd_fr_source_desc[16],
       nd_to_source_desc[16];
  char nd_option[30];

int rec_len; //added for globalisation


  if(strcmp(d_section_code_fm.arr, "!") == 0)
    //strcpy(nd_fr_section_desc, "LOWEST");
    strcpy(nd_fr_section_desc, local_legend[28]); // added for globalisation
    else strcpy(nd_fr_section_desc, d_section_code_fm.arr);

  if(strcmp(d_section_code_to.arr, "~") == 0)
    //strcpy(nd_to_section_desc, "HIGHEST");
    strcpy(nd_to_section_desc, local_legend[29]); // added for globalisation
    else strcpy(nd_to_section_desc, d_section_code_to.arr);

  if (strlen(d_workgroup.arr) == 0)
    //strcpy(nd_workgroup_desc, "ALL");
    strcpy(nd_workgroup_desc, local_legend[30]); // added for globalisation
    else strcpy(nd_workgroup_desc, d_workgroup.arr);

  if (strcmp(d_summary_yn.arr, "Y") == 0) 
    //strcpy(nd_sum_det, "Summary");
    strcpy(nd_sum_det, local_legend[31]); // added for globalisation
  else
    //strcpy(nd_sum_det, "Detail");
    strcpy(nd_sum_det, local_legend[32]); // added for globalisation
/* -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- */

 //   sprintf(string_var,"%s",nd_sum_det);
//	disp_message(ERR_MESG,string_var);

  if(strcmp(d_source_fm.arr, "!") == 0)
    //strcpy(nd_fr_source_desc, "LOWEST");
    strcpy(nd_fr_source_desc, local_legend[28]); // added for globalisation
    else strcpy(nd_fr_source_desc, d_source_fm.arr);

  if(strcmp(d_source_to.arr, "~") == 0)
    //strcpy(nd_to_source_desc, "HIGHEST");
    strcpy(nd_to_source_desc, local_legend[29]); // added for globalisation
    else strcpy(nd_to_source_desc, d_source_to.arr);

  if (strlen(d_source_type.arr) == 0)
    //strcpy(nd_source_type_desc, "ALL");
    strcpy(nd_source_type_desc, local_legend[30]); // added for globalisation
    else 
		{
	 /*	Added by Durai Rajkumar against ML-SD-CRF-20239	*/
	 if (strcmp(d_source_type.arr, "E") == 0)
        strcpy(nd_source_type_desc, local_legend[36]); 
     else if (strcmp(d_source_type.arr, "C") == 0)
        strcpy(nd_source_type_desc, local_legend[37]); 
	else if (strcmp(d_source_type.arr, "W") == 0)
        strcpy(nd_source_type_desc, local_legend[38]); 
     }	
	/*	strcpy(nd_source_type_desc, d_source_type.arr);	Commented by Durai Rajkumar against ML-SD-CRF-20239	*/
/* -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- */    

  /*	Added by Durai Rajkumar against ML-SD-CRF-20239	*/
 if (strcmp(d_option.arr,"A") == 0)
	strcpy(nd_option,local_legend[33]);
	else strcpy(nd_option,local_legend[34]);
/*	Ends against ML-SD-CRF-20239	*/

  print_page_header();


  get_version_no();   ///// added 01.07.2003

/////////// 01.07.2003   fprintf(f1,VER);

  fprintf(f1,"%s\n",d_version.arr);

  fprintf(f1,"\n\n\n\n");
  //fprintf(f1,"        ");
  //fprintf(f1,"INPUT PARAMETERS :\n");
  //disp_message(ERR_MESG,local_legend[6]);
  rec_len = strlen(local_legend[6]);//added for globalisation
  print_space(30, rec_len,1);//added for globalisation
  fprintf(f1,"%s:\n", local_legend[6]); 
  //fprintf(f1,"        ");
  //fprintf(f1,"------------------\n\n");
  print_space(30, rec_len,1);//added for globalisation
  print_space(30, rec_len,0);//added for globalisation
  fprintf(f1,"\n\n");
  //fprintf(f1,"                ");
  //fprintf(f1,"SECTION  FROM : %s\n", nd_fr_section_desc);
  rec_len = strlen(local_legend[7]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[7], nd_fr_section_desc); // added for globalisation
  //fprintf(f1,"                         TO   : %s\n\n", nd_to_section_desc);
  rec_len = strlen(local_legend[8]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n\n", local_legend[8], nd_to_section_desc);// added for globalisation
  //fprintf(f1,"                ");
  //fprintf(f1,"PERIOD   From : %s  To : %s\n",d_date_from.arr,d_date_to.arr);
  rec_len = strlen(local_legend[9]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
/*            EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_date_from,'DD/MM/YYYY'), :language_id , t_date);
				//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY');
				:d_sysdate1 :=sm_convert_date_2t(to_date(:d_date_from,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC;

            EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_date_to,'DD/MM/YYYY'), :language_id , t_date);
				//:d_sysdate2 := to_char(t_date,'DD/MM/YYYY');
				:d_sysdate2 :=sm_convert_date_2t(to_date(:d_date_to,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC;
*/
  fprintf(f1,"%s: %s  %s: %s\n", local_legend[9], d_sysdate1.arr, local_legend[8], d_sysdate2.arr);// added for globalisation
  //fprintf(f1,"                ");
  //fprintf(f1,"WORKGROUP     : %s\n\n", nd_workgroup_desc);
  rec_len = strlen(local_legend[10]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n\n", local_legend[10], nd_workgroup_desc);// added for globalisation
  //fprintf(f1,"                ");
/*  fprintf(f1,"WORKLOAD TYPE : %s\n", "Actual"); -- from here added by sunil on 12/10/2007 as per SD-CRF-20071 --- */
  //fprintf(f1,"SOURCE TYPE   : %s\n", nd_source_type_desc);
  rec_len = strlen(local_legend[11]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[11], nd_source_type_desc); //added for globalisation
  //fprintf(f1,"                ");
  //fprintf(f1,"SOURCE  FROM  : %s\n", nd_fr_source_desc);
  rec_len = strlen(local_legend[12]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[12], nd_fr_source_desc);//added for globalisation
//  fprintf(f1,"                         TO   : %s\n\n", nd_to_source_desc);
  rec_len = strlen(local_legend[8]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n\n", local_legend[8], nd_to_source_desc);//added for globalisation
/* -- upto here added by sunil on 12/10/2007 as per SD-CRF-20071 --- */
  /*	Added by Durai Rajkumar against ML-SD-CRF-20239	*/
  rec_len = strlen(local_legend[35]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[35], nd_option); //added for globalisation
  /*	Ends against ML-SD-CRF-20239	*/

//  fprintf(f1,"                ");
  //fprintf(f1,"REPORT TYPE   : %s\n", nd_sum_det);
  rec_len = strlen(local_legend[13]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[13], nd_sum_det); //added for globalisation
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

 char buf[15]; //added for globalisation
 int col;// added for globalisation


  if(strcmp(d_section_code_fm.arr, "!!!!!!!!!") == 0)
    //strcpy(nd_fr_section_desc, "LOWEST");
    strcpy(nd_fr_section_desc, local_legend[28]); //added for globalisation
    else strcpy(nd_fr_section_desc, d_section_code_fm.arr);

  if(strcmp(d_section_code_to.arr, "~~~~~~~~~") == 0)
    //strcpy(nd_to_section_desc, "HIGHEST");
    strcpy(nd_to_section_desc, local_legend[29]); //added for globalisation
    else strcpy(nd_to_section_desc, d_section_code_to.arr);

//fprintf(f1,"%c&l1O",ESC);
fprintf(f1,"%c&k4S",ESC);
/*
 fprintf(f1,"MDL : RL  ");
 fprintf(f1,"%-61.61s",d_acc_entity_name_long.arr);
 fprintf(f1,"   ");  
 fprintf(f1,"%s", d_sysdate.arr);
 fprintf(f1,"\n"); 
 fprintf(f1,"OPR : %-21.21s", d_user.arr);
 //fprintf(f1,"                 WORKLOAD STATISTICS                ");  
 fprintf(f1,"%s", local_legend[14]); // added for globalisation
 //fprintf(f1,"Page : %4d", page_no);
 fprintf(f1,"%s: %4d", local_legend[15], page_no); //added for globalisation
 fprintf(f1,"\n");
*/
  memset(hdr_line1,' ',REP_WIDTH+1);
  strncpy(hdr_line1,"MDL:RL",6);
  col = (int)(REP_WIDTH - strlen(d_acc_entity_name_long.arr))/2;
  strncpy(hdr_line1 + col -1,d_acc_entity_name_long.arr,strlen(d_acc_entity_name_long.arr));
  /* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		//t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
		//:d_sysdate3 := to_char(t_date,'DD/MM/YYYY HH24:MI');
		:d_sysdate3 :=sm_convert_datetime_2t(SYSDATE,:language_id);
	END;
  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate3 := sm_convert_datet\
ime_2t ( SYSDATE , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1135;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_sysdate3;
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


	col = (REP_WIDTH-strlen(d_sysdate3.arr));
	strcpy(hdr_line1+col+1,d_sysdate3.arr);
  fprintf(f1,"\n");	
  fprintf(f1,hdr_line1);
  fprintf(f1,"\n");	

	memset(hdr_line2,' ',REP_WIDTH+1);
    strncpy(hdr_line2,"OPR:",4);
    strncpy(hdr_line2+4,d_user.arr,strlen(d_user.arr));
	strcpy(rep_title1, local_legend[14] );
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line2+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"%s : %4d",local_legend[15],page_no);
    strcpy(hdr_line2+(REP_WIDTH-strlen(buf)),buf);
  fprintf(f1,hdr_line2);
  fprintf(f1,"\n");	

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_date_from,'DD/MM/YYYY'), :language_id , t_date);
				//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY');
				:d_sysdate1 :=sm_convert_date_2t(to_date(:d_date_from,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 13;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_con\
vert_date_2t ( to_date ( :d_date_from , 'DD/MM/YYYY ' ) , :language_id ) ; END\
 ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1158;
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
            sqlstm.sqhstv[1] = (         void  *)&d_date_from;
            sqlstm.sqhstl[1] = (unsigned int  )23;
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



            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_date_to,'DD/MM/YYYY'), :language_id , t_date);
				//:d_sysdate2 := to_char(t_date,'DD/MM/YYYY');
				:d_sysdate2 :=sm_convert_date_2t(to_date(:d_date_to,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 13;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate2 := sm_con\
vert_date_2t ( to_date ( :d_date_to , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1185;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_sysdate2;
            sqlstm.sqhstl[0] = (unsigned int  )19;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&d_date_to;
            sqlstm.sqhstl[1] = (unsigned int  )23;
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


/*
 fprintf(f1,"REP : RLRWRKS2");
 //fprintf(f1,"                   ");
 //fprintf(f1,"For The Period  %-10.10s To %-10.10s ",d_date_from.arr,d_date_to.arr);
 fprintf(f1,"%22.22s  %-10.10s %5.5s %-10.10s ",local_legend[16], d_date_from.arr, local_legend[8], d_date_to.arr); // added for globalisation
 fprintf(f1,"\n");
*/
	memset(hdr_line3,' ',REP_WIDTH+1);
    strncpy(hdr_line3,"REP:RLRWRKS2",12);

	strcpy(rep_title2, local_legend[16] );
	strcat(rep_title2, " ");
	strcat(rep_title2, d_sysdate1.arr);
	strcat(rep_title2, " ");
	strcat(rep_title2, local_legend[8]);
	strcat(rep_title2, " ");
	strcat(rep_title2, d_sysdate2.arr);

	col = (int)(REP_WIDTH-strlen(rep_title2))/2;
	strcpy(hdr_line3+col,rep_title2);
  fprintf(f1,hdr_line3);
  fprintf(f1,"\n");	

 fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"--------------------------");
 fprintf(f1,"\n");
}

/* print the heading */
void print_col_heading()
{
 //fprintf(f1,"RESULT DATE TEST CODE  TEST DESCRIPTION                          WORK UNITS  ADD.WORK UNITS   ADD. WORK        NO.OF TESTS    TOTAL UNITS\n"); 
 if (d_summary_yn.arr[0] == 'N')
 {
 //fprintf(f1,"TEST DESCRIPTION                         RESULT DATE  NO.OF TESTS   ADD. WORK    TOTAL UNITS\n"); 
   //fprintf(f1,"TEST DESCRIPTION                          RESULT        NO.OF    ADD.    ANATOMY     TOTAL\n");
   fprintf(f1,"%-16.16s                          %-6.6s     %-9.9s    %-4.4s    %-7.7s      %-5.5s\n", local_legend[17], local_legend[18], local_legend[20], local_legend[22], local_legend[24], local_legend[26]); //added for globalisation
   //fprintf(f1,"                                          DATE          TESTS    WORK    WORKLOAD    UNITS\n"); 
   fprintf(f1,"                                          %-4.4s       %-5.5s        %-4.4s    %-8.8s    %-5.5S\n", local_legend[19], local_legend[21], local_legend[23],  local_legend[25],local_legend[27] ); // added for globalisation
 }
 else
 //fprintf(f1,"TEST DESCRIPTION                                      NO.OF TESTS   ADD. WORK    TOTAL UNITS\n"); 
 {
   //fprintf(f1,"TEST DESCRIPTION                                        NO.OF    ADD.    ANATOMY     TOTAL\n");
   fprintf(f1,"%-16.16s                                     %-9.9s    %-4.4s    %-7.7s      %-5.5s\n", local_legend[17], local_legend[20], local_legend[22], local_legend[24], local_legend[26]); //added for globalisation
   //fprintf(f1,"                                                        TESTS    WORK    WORKLOAD    UNITS\n"); 
   fprintf(f1,"                                                     %-5.5s        %-4.4s    %-8.8s     %-5.5s\n", local_legend[21], local_legend[23],  local_legend[25],local_legend[27] ); // added for globalisation
 }
 fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"--------------------------");
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

	 //strcpy(OUTPUT_FILE_NAME,"rlrwrksd.lis");
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
	    prepare_new_page(1);
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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1212;
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
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1231;
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

/*** added for globalisation ******/
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
/*** added for globalisation ******/


#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
