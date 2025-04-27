
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
           char  filnam[34];
};
static const struct sqlcxp sqlfpn =
{
    33,
    "Y:\\trunk\\eHIS2Tier\\RL\\RLIWDRES.pc"
};


static unsigned long sqlctx = 1193584573;


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
            void  *sqhstv[20];
   unsigned int   sqhstl[20];
            int   sqhsts[20];
            void  *sqindv[20];
            int   sqinds[20];
   unsigned int   sqharm[20];
   unsigned int   *sqharc[20];
   unsigned short  sqadto[20];
   unsigned short  sqtdso[20];
} sqlstm = {10,20};

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
"select SOURCE_CODE ,CONSULTANT_CODE ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY\
 HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') ,SECTION_CODE ,REQUEST_COMME\
NT_CODE1 ,REQUEST_COMMENT_CODE2 ,REQUEST_COMMENT_CODE3 ,REQUEST_COMMENT_DESC1 \
,REQUEST_COMMENT_DESC2 ,REQUEST_COMMENT_DESC3 ,EXTRA_COPIES_TO ,SPECIMEN_TYPE_\
CODE ,ADDED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH24:MI') ,MODIFIED_BY_ID ,T\
O_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI') ,URGENT_INDICATOR ,EPISODE_TYPE ,OR\
DERED_FACILITY_ID  from RL_REQUEST_HEADER where (((PATIENT_ID=:b0 and SPECIMEN\
_NO=:b1) and OPERATING_FACILITY_ID=:b2) and NVL(CANCELLED_YN,'N')<>'Y')       \
    ";

 static const char *sq0018 = 
"select TEST_CODE ,NVL(RESULT_STATUS,'O') ,DECODE(GROUP_TEST_YN,'Y','G','I') \
 from RL_REQUEST_DETAIL where ((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPER\
ATING_FACILITY_ID=:b2) and NVL(RESULT_STATUS,' ')='R') and NVL(CANCELLED_YN,'N\
')<>'Y')           ";

 static const char *sq0019 = 
"select GROUP_TEST_CODE ,TEST_CODE ,NVL(NUMERIC_PREFIX,'+') ,NUMERIC_RESULT ,\
RESULT_COMMENT_DESC1 ,RESULT_COMMENT_DESC2 ,RESULT_COMMENT_DESC3 ,RESULT_COMME\
NT_DESC4 ,NVL(STATUS,'O') ,NVL(TECH_STATUS,'*') ,NVL(DELTA_STATUS,'*') ,NVL(QL\
TY_STATUS,'*') ,NVL(CMNT_STATUS,'*') ,NVL(PATH_STATUS,'*') ,ROWID  from RL_TES\
T_RESULT where ((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_\
ID=:b2) and NVL(CANCELLED_YN,'N')<>'Y') and GROUP_TEST_CODE in (select TEST_CO\
DE  from RL_REQUEST_DETAIL where ((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and O\
PERATING_FACILITY_ID=:b2) and NVL(RESULT_STATUS,'O') in ('P','R')) and NVL(CAN\
CELLED_YN,'N')<>'Y'))) order by GROUP_SEQ_NO,TEST_SEQ_NO            ";

 static const char *sq0030 = 
"select SNOMED_CODE  from RL_RESULT_SNOMED where ((((PATIENT_ID=:b0 and SPECI\
MEN_NO=:b1) and OPERATING_FACILITY_ID=:b2) and GROUP_TEST_CODE=:b3) and TEST_C\
ODE=:b4) order by SNOMED_CODE            ";

 static const char *sq0032 = 
"select ORGANISM_CODE ,RESULT_COMMENT_DESC  from RL_RESULT_ORGANISM where (((\
(PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID=:b2) and GROUP_\
TEST_CODE=:b3) and TEST_CODE=:b4)           ";

 static const char *sq0034 = 
"select LONG_DESC  from RL_ORGANISM_CODE where ORGANISM_CODE=:b0           ";

 static const char *sq0035 = 
"select LONG_DESC  from RL_ANTIBIOTIC_CODE where ANTIBIOTIC_CODE=:b0         \
  ";

 static const char *sq0033 = 
"select ANTIBIOTIC_CODE ,SENSITIVITY_IND ,REPORT_YN  from RL_RESULT_ORGANISM_\
DTL where (((((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID\
=:b2) and GROUP_TEST_CODE=:b3) and TEST_CODE=:b4) and ORGANISM_CODE=:b5) and S\
ENSITIVITY_IND in ('S','R','I')) and REPORT_YN='Y') order by REPORT_YN desc ,S\
ENSITIVITY_IND desc             ";

 static const char *sq0021 = 
"select SHORT_NAME ,SEX ,NATIONALITY_CODE ,ROUND((TO_DATE(:b0,'DD/MM/YYYY HH2\
4:MI')-DATE_OF_BIRTH)) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY')  from MP_PATIENT_MAS\
T where PATIENT_ID=:b1           ";

 static const char *sq0022 = 
"select SHORT_NAME ,SEX ,NATIONALITY_CODE ,ROUND((TO_DATE(:b0,'DD/MM/YYYY HH2\
4:MI')-DATE_OF_BIRTH)) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY')  from RL_PATIENT_MAS\
T where PATIENT_ID=:b1           ";

 static const char *sq0023 = 
"select SPECIMEN_DESC  from RL_SPECIMEN_TYPE_CODE where SPECIMEN_TYPE_CODE=:b\
0           ";

 static const char *sq0025 = 
"select LONG_DESC ,NUMERIC_RESULT_YN ,AGE_SEX_RANGE_YN ,FUNCTION_YN ,PRINT_NA\
ME_YN ,LOW_VALUE_NORMAL ,HIGH_VALUE_NORMAL ,GROUP_TEST_YN ,TEXT_BLOCK_YN ,CULT\
URE_TEST_YN ,SNOMED_YN ,TEST_UNITS ,NVL(NO_OF_DECIMALS,0) ,NVL(SIGNIFICANT_DIG\
IT,0) ,REF_RANGE_COMMENT ,NVL(INHIBIT_REPORT_YN,'N')  from RL_TEST_CODE where \
TEST_CODE=:b0           ";

 static const char *sq0024 = 
"select LONG_NAME  from RL_SECTION_CODE where SECTION_CODE=:b0           ";

 static const char *sq0026 = 
"select LOW_VALUE_NORMAL ,HIGH_VALUE_NORMAL  from RL_AGE_SEX_RANGE where ((TE\
ST_CODE=:b0 and SEX=:b1) and :b2 between CALC_MIN_AGE_IN_DAYS and CALC_MAX_AGE\
_IN_DAYS)           ";

 static const char *sq0027 = 
"select COMMENT_TEXT  from RL_COMMENTS_FOR_TEST where TEST_CODE=:b0 order by \
SEQ_NO            ";

 static const char *sq0031 = 
"select DESCRIPTION_1 ,DESCRIPTION_2 ,DESCRIPTION_3 ,DESCRIPTION_4 ,DESCRIPTI\
ON_5 ,PRINT_YN  from RL_SNOMED_CODE where SNOMED_MARKER_CODE=:b0           ";

 static const char *sq0028 = 
"select RESULT_TEXT RESULT_TEXT_LINE1 ,RESULT_TEXT RESULT_TEXT_LINE2 ,RESULT_\
TEXT RESULT_TEXT_LINE3 ,RESULT_TEXT RESULT_TEXT_LINE4 ,RESULT_TEXT RESULT_TEXT\
_LINE5 ,RESULT_TEXT RESULT_TEXT_LINE6 ,RESULT_TEXT RESULT_TEXT_LINE7 ,RESULT_T\
EXT RESULT_TEXT_LINE8 ,RESULT_TEXT RESULT_TEXT_LINE9 ,RESULT_TEXT RESULT_TEXT_\
LINE10  from RL_RESULT_TEXT where ((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and \
OPERATING_FACILITY_ID=:b2) and GROUP_TEST_CODE=:b3) and TEST_CODE=:b4) order b\
y SERIAL_NO            ";

 static const char *sq0020 = 
"select OPERAND_1 ,OPERAND_1_TYPE ,OPERATOR_1 ,OPERAND_2 ,OPERAND_2_TYPE ,OPE\
RATOR_2  from RL_FUNCTION where TEST_CODE=:b0 order by SEQ_NUMBER            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,290,0,0,0,0,0,1,0,
20,0,0,2,243,0,3,365,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
79,0,0,3,0,0,29,397,0,0,0,0,0,1,0,
94,0,0,4,177,0,4,418,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,
0,0,1,9,0,0,
137,0,0,5,157,0,4,445,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
172,0,0,6,0,0,17,557,0,0,1,1,0,1,0,1,9,0,0,
191,0,0,6,0,0,45,563,0,0,0,0,0,1,0,
206,0,0,6,0,0,13,570,0,0,1,0,0,1,0,2,9,0,0,
225,0,0,7,42,0,4,601,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
248,0,0,8,49,0,4,604,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
275,0,0,9,59,0,4,611,0,0,4,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,2,9,0,0,
306,0,0,10,45,0,4,634,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
333,0,0,11,49,0,4,638,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
360,0,0,12,55,0,4,642,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
383,0,0,13,57,0,4,648,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
410,0,0,14,53,0,4,659,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
437,0,0,15,52,0,4,685,0,0,4,3,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,2,9,0,0,
468,0,0,16,0,0,27,700,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
499,0,0,17,0,0,15,958,0,0,0,0,0,1,0,
514,0,0,17,626,0,9,967,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
541,0,0,17,0,0,13,1018,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
636,0,0,18,251,0,9,1069,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
663,0,0,18,0,0,13,1085,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
690,0,0,19,690,0,9,1106,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
729,0,0,19,0,0,13,1148,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,
804,0,0,30,195,0,9,1505,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
839,0,0,30,0,0,13,1517,0,0,1,0,0,1,0,2,9,0,0,
858,0,0,32,198,0,9,1668,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
893,0,0,32,0,0,13,1682,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
916,0,0,34,74,0,9,1696,0,0,1,1,0,1,0,1,9,0,0,
935,0,0,34,0,0,13,1703,0,0,1,0,0,1,0,2,9,0,0,
954,0,0,35,78,0,9,1715,0,0,1,1,0,1,0,1,9,0,0,
973,0,0,35,0,0,13,1722,0,0,1,0,0,1,0,2,9,0,0,
992,0,0,33,342,0,9,1734,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1031,0,0,33,0,0,13,1749,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1058,0,0,21,187,0,9,1775,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1081,0,0,21,0,0,13,1803,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1116,0,0,22,187,0,9,1815,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1139,0,0,22,0,0,13,1816,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1174,0,0,23,88,0,9,1842,0,0,1,1,0,1,0,1,9,0,0,
1193,0,0,23,0,0,13,1850,0,0,1,0,0,1,0,2,9,0,0,
1212,0,0,25,334,0,9,1867,0,0,1,1,0,1,0,1,9,0,0,
1231,0,0,25,0,0,13,1905,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,
0,2,9,0,0,
1310,0,0,36,103,0,4,1957,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1341,0,0,37,74,0,4,1965,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1364,0,0,38,103,0,4,1972,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1395,0,0,24,72,0,9,1989,0,0,1,1,0,1,0,1,9,0,0,
1414,0,0,24,0,0,13,1997,0,0,1,0,0,1,0,2,9,0,0,
1433,0,0,26,174,0,9,2011,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1460,0,0,26,0,0,13,2022,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1483,0,0,27,94,0,9,2036,0,0,1,1,0,1,0,1,9,0,0,
1502,0,0,27,0,0,13,2048,0,0,1,0,0,1,0,2,9,0,0,
1521,0,0,31,151,0,9,2090,0,0,1,1,0,1,0,1,9,0,0,
1540,0,0,31,0,0,13,2109,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
1579,0,0,28,489,0,9,2235,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1614,0,0,28,0,0,13,2265,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1669,0,0,39,146,0,4,2307,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1704,0,0,20,153,0,9,2355,0,0,1,1,0,1,0,1,9,0,0,
1723,0,0,20,0,0,13,2378,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
1762,0,0,17,0,0,15,2400,0,0,0,0,0,1,0,
1777,0,0,18,0,0,15,2401,0,0,0,0,0,1,0,
1792,0,0,19,0,0,15,2402,0,0,0,0,0,1,0,
1807,0,0,21,0,0,15,2403,0,0,0,0,0,1,0,
1822,0,0,23,0,0,15,2404,0,0,0,0,0,1,0,
1837,0,0,24,0,0,15,2405,0,0,0,0,0,1,0,
1852,0,0,25,0,0,15,2406,0,0,0,0,0,1,0,
1867,0,0,26,0,0,15,2407,0,0,0,0,0,1,0,
1882,0,0,27,0,0,15,2408,0,0,0,0,0,1,0,
1897,0,0,28,0,0,15,2409,0,0,0,0,0,1,0,
1912,0,0,29,0,0,15,2410,0,0,0,0,0,1,0,
1927,0,0,30,0,0,15,2411,0,0,0,0,0,1,0,
1942,0,0,31,0,0,15,2412,0,0,0,0,0,1,0,
1957,0,0,32,0,0,15,2413,0,0,0,0,0,1,0,
1972,0,0,33,0,0,15,2414,0,0,0,0,0,1,0,
1987,0,0,34,0,0,15,2415,0,0,0,0,0,1,0,
2002,0,0,35,0,0,15,2416,0,0,0,0,0,1,0,
2017,0,0,22,0,0,15,2417,0,0,0,0,0,1,0,
2032,0,0,40,58,0,4,2431,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.6                                                  */
/************************************************************************/
/* PROGRAM NAME          : RLIWDRES                                     */
/* DESCRIPTION		     : Test Results report                          */
/* AUTHOR                : S. SHEELVANT                                 */
/* DATE WRITTEN          : 05-JUN-1998                                  */
/*                                                                      */
/* CALLED FROM           : rlispcmn.frm                                 */
/*                                                                      */
/* FUNCTION              :                                              */
/*                                                                      */
/* TABLE DETAILS	 	 : RL_REQUEST_HEADER,RL_REQUEST_DETAIL,         */
/*                         RL_TEST_RESULT,RL_PRINT_CONTROL_HDR	        */
/*                                                                      */
/* MODIFIED BY           : HAMEED                                       */
/* MODIFIED ON		     : 29-MAY-2003                                  */
/* MODIFIED BY           : SHRUTI [ordered_facility_id)                                       */
/* MODIFIED ON		     : 04-SEPT-2003                                  */
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include "gl.h"
#define NODATAFOUND              	(sqlca.sqlcode == 1403)
#define OERROR 				(sqlca.sqlcode < 0)
#define LAST_ROW 				(sqlca.sqlcode == 1403)
#define NOT_FOUND 			(sqlca.sqlerrd[2] == 0)
#define TABLE_ALREADY_EXISTS 		(sqlca.sqlcode == -955)
#define RESOURCE_BUSY        		(sqlca.sqlcode == -54)
#define INIT_MESG "Fetching Results..."
#define ONLINE_PRINTING
/*
#define DEBUG 				0
*/
#define SPOOL_DIR			""	



/* EXEC SQL BEGIN DECLARE SECTION; */ 



   /* VARCHAR 	nd_operating_facility_id		[3],
	   	    uid_pwd					        [132],
           	d_curr_pgm_name                 [15],
           	nd_file_name                    [151],
	   	    today		    			    [20],
           	nd_user	                    	[21],
           	nd_file_no                      [15]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } today;

struct { unsigned short len; unsigned char arr[21]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;


   /* VARCHAR 	nd_hosp_no                       	[21],	 /o Patient ID o/
           	nd_spec_no                       	[20],
           	nd_cntrl_rowid                   	[31],

           	c_req_dtl_test_code              	[6],/o Used in o/ 
           	c_group_test_yn                  	[2],/o Update_rl_request_detailo/
           	c_count                          	[3],/o-----o/
           	c_spec_no                        	[10],
           	sql_stmt                         	[200],

           	p_print_name_yn                  	[2],
	   	    p_test_desc                      	[41],
           	p_grp_status                     	[2],

		   rl_ordered_facility_id				[3],
           rl_hdr_source_code               	[11],
           rl_hdr_consultant_code           	[16],
           rl_hdr_spec_regd_date_time       	[17],
           rl_hdr_current_date_time         	[17],
           rl_hdr_section_code              	[2],
           rl_hdr_request_comment_code1     	[5],
           rl_hdr_request_comment_code2     	[5],
           rl_hdr_request_comment_code3     	[5],
           rl_hdr_request_comment_desc1     	[41],
           rl_hdr_request_comment_desc2     	[41],
           rl_hdr_request_comment_desc3     	[41],
           rl_hdr_extra_copies_to           	[16],
           rl_hdr_specimen_type_code        	[5],
           rl_hdr_added_by_id               	[31],
           rl_hdr_added_date                	[16],
           rl_hdr_modified_by_id            	[31],
           rl_hdr_modified_date             	[16],
 	       rl_hdr_episode_type		    	    [2],
 	       rl_hdr_urgent_indicator	    		[2],

           rl_dtl_test_code_reqd	    		[6],
           rl_dtl_test_code                 [7][6],
           rl_dtl_result_status             [7][2],
           rl_dtl_group_test_flag           [7][2],

           rl_tst_group_test_code           [6],
           rl_tst_test_code                 [6],
           rl_tst_numeric_prefix            [2],
           rl_tst_numeric_result            [6],
           rl_tst_result_comment_desc1      [41],
           rl_tst_result_comment_desc2      [41],
           rl_tst_result_comment_desc3      [41],
           rl_tst_result_comment_desc4      [41],
	       rl_tst_status                [2],
  	       rl_tst_tech_status		    [2],
  	       rl_tst_delta_status		    [2],
  	       rl_tst_qlty_status		    [2],
  	       rl_tst_cmnt_status		    [2],
  	       rl_tst_path_status		    [2],
           rl_tst_rowid                     [31],

           rl_loc_test_code                 [6],
           rl_loc_long_desc                 [41],

           rl_pat_long_name                 [61],
           rl_pat_short_name                [61],
           rl_pat_sex                       [2],
           rl_pat_nationality               [4],
           rl_pat_dob_no_of_days            [10],
           rl_pat_date_of_birth             [16],
           rl_pat_blood_group               [3],
           rl_pat_g6pd                      [6],
           rl_pat_sicc                      [6],
           rl_pat_hbl4_1                    [6],
           rl_pat_hbl4_2                    [6],

           rl_spc_specimen_desc             [41],

           rl_source_short_name             [41],    	 /o long name o/
           rl_consultant_short_name         [41], 	 /o long name o/
           rl_section_short_name            [41],  

           rl_tst_cd_short_desc             [41],
           rl_tst_cd_numeric_result_yn      [2],
           rl_tst_cd_age_sex_range_yn       [2],
           rl_tst_cd_function_yn            [2],
           rl_tst_cd_print_report_yn        [2],
           rl_tst_cd_low_value_normal       [16],
           rl_tst_cd_high_value_normal      [16],
           rl_tst_cd_result_name_text       [11],
           rl_tst_cd_group_test_yn          [2],
           rl_tst_cd_text_block_yn          [2],
           rl_tst_cd_culture_test_yn        [2],
           rl_tst_cd_snomed_yn              [2],
           rl_tst_cd_test_units             [11],
		   rl_tst_cd_test_units_desc        [41],
		   rl_test_units			        [41],
           rl_tst_cd_range_cmt              [41],
           rl_tst_cd_inhibit_yn             [2],

           rl_tst_range_low_val_nml    		[16],
           rl_tst_range_high_val_nml   		[16],

           rl_comm_for_test_comm_text    	[41],

           rl_res_result_text1              [71],
           rl_res_result_text2              [71],
           rl_res_result_text3              [71],
           rl_res_result_text4              [71],
           rl_res_result_text5              [71],
           rl_res_result_text6              [71],
           rl_res_result_text7              [71],
           rl_res_result_text8              [71],
           rl_res_result_text9              [71],
           rl_res_result_text10             [71],

           rl_func_operand_1                [6],
           rl_func_operand_1_type           [2],
           rl_func_operator_1               [2],
           rl_func_operand_2                [6],
           rl_func_operand_2_type           [2],
           rl_func_operator_2               [2],
  
           rl_func_value                    [6],

           rl_calc_str                      [400],
           rl_func_str                      [400],

           rl_res_organism_code             [5],
           rl_res_comment_desc              [41],

           rl_res_organism_code_desc        [41],

           rl_res_dtl_antibiotic_code       [5],
           rl_res_dtl_antibiotic_desc       [41],
           rl_res_dtl_sensitivity_ind       [2],
           rl_res_dtl_report_yn             [2],
	   
	       sy_acc_entity_name 		        [81],
           rl_res_snomed_code               [11],
	       rl_param_print_start		        [2],
	       op_clinic_lab_print_reqd_yn	    [2],

           rl_snomed_desc1                  [41],
           rl_snomed_desc2                  [41],
           rl_snomed_desc3                  [41],
           rl_snomed_desc4                  [41],
           rl_snomed_desc5                  [41],
           rl_snomed_print_yn               [2],

	   result_line                      [100],
	   result_status                    [2],
	   result_tech_status               [2],
	   result_delta_status              [2],
	   result_qlty_status               [2],
	   result_cmnt_status               [2],
	   result_path_status               [2],

        p_function_yn                 [2],
	    p_test_units                  [11],
  	    d_loc_str 			          [20], 
  	    d_l_str 			    	  [20], 
  	    d_dec_part			          [20],
  	    d_int_part			          [20],
  	    d_sig_part			          [20]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd_hosp_no;

struct { unsigned short len; unsigned char arr[20]; } nd_spec_no;

struct { unsigned short len; unsigned char arr[31]; } nd_cntrl_rowid;

struct { unsigned short len; unsigned char arr[6]; } c_req_dtl_test_code;

struct { unsigned short len; unsigned char arr[2]; } c_group_test_yn;

struct { unsigned short len; unsigned char arr[3]; } c_count;

struct { unsigned short len; unsigned char arr[10]; } c_spec_no;

struct { unsigned short len; unsigned char arr[200]; } sql_stmt;

struct { unsigned short len; unsigned char arr[2]; } p_print_name_yn;

struct { unsigned short len; unsigned char arr[41]; } p_test_desc;

struct { unsigned short len; unsigned char arr[2]; } p_grp_status;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[11]; } rl_hdr_source_code;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_consultant_code;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_current_date_time;

struct { unsigned short len; unsigned char arr[2]; } rl_hdr_section_code;

struct { unsigned short len; unsigned char arr[5]; } rl_hdr_request_comment_code1;

struct { unsigned short len; unsigned char arr[5]; } rl_hdr_request_comment_code2;

struct { unsigned short len; unsigned char arr[5]; } rl_hdr_request_comment_code3;

struct { unsigned short len; unsigned char arr[41]; } rl_hdr_request_comment_desc1;

struct { unsigned short len; unsigned char arr[41]; } rl_hdr_request_comment_desc2;

struct { unsigned short len; unsigned char arr[41]; } rl_hdr_request_comment_desc3;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_extra_copies_to;

struct { unsigned short len; unsigned char arr[5]; } rl_hdr_specimen_type_code;

struct { unsigned short len; unsigned char arr[31]; } rl_hdr_added_by_id;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_added_date;

struct { unsigned short len; unsigned char arr[31]; } rl_hdr_modified_by_id;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_modified_date;

struct { unsigned short len; unsigned char arr[2]; } rl_hdr_episode_type;

struct { unsigned short len; unsigned char arr[2]; } rl_hdr_urgent_indicator;

struct { unsigned short len; unsigned char arr[6]; } rl_dtl_test_code_reqd;

struct { unsigned short len; unsigned char arr[6]; } rl_dtl_test_code[7];

struct { unsigned short len; unsigned char arr[2]; } rl_dtl_result_status[7];

struct { unsigned short len; unsigned char arr[2]; } rl_dtl_group_test_flag[7];

struct { unsigned short len; unsigned char arr[6]; } rl_tst_group_test_code;

struct { unsigned short len; unsigned char arr[6]; } rl_tst_test_code;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_numeric_prefix;

struct { unsigned short len; unsigned char arr[6]; } rl_tst_numeric_result;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_result_comment_desc1;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_result_comment_desc2;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_result_comment_desc3;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_result_comment_desc4;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_tech_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_delta_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_qlty_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cmnt_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_path_status;

struct { unsigned short len; unsigned char arr[31]; } rl_tst_rowid;

struct { unsigned short len; unsigned char arr[6]; } rl_loc_test_code;

struct { unsigned short len; unsigned char arr[41]; } rl_loc_long_desc;

struct { unsigned short len; unsigned char arr[61]; } rl_pat_long_name;

struct { unsigned short len; unsigned char arr[61]; } rl_pat_short_name;

struct { unsigned short len; unsigned char arr[2]; } rl_pat_sex;

struct { unsigned short len; unsigned char arr[4]; } rl_pat_nationality;

struct { unsigned short len; unsigned char arr[10]; } rl_pat_dob_no_of_days;

struct { unsigned short len; unsigned char arr[16]; } rl_pat_date_of_birth;

struct { unsigned short len; unsigned char arr[3]; } rl_pat_blood_group;

struct { unsigned short len; unsigned char arr[6]; } rl_pat_g6pd;

struct { unsigned short len; unsigned char arr[6]; } rl_pat_sicc;

struct { unsigned short len; unsigned char arr[6]; } rl_pat_hbl4_1;

struct { unsigned short len; unsigned char arr[6]; } rl_pat_hbl4_2;

struct { unsigned short len; unsigned char arr[41]; } rl_spc_specimen_desc;

struct { unsigned short len; unsigned char arr[41]; } rl_source_short_name;

struct { unsigned short len; unsigned char arr[41]; } rl_consultant_short_name;

struct { unsigned short len; unsigned char arr[41]; } rl_section_short_name;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_cd_short_desc;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_numeric_result_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_age_sex_range_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_function_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_print_report_yn;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_cd_low_value_normal;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_cd_high_value_normal;

struct { unsigned short len; unsigned char arr[11]; } rl_tst_cd_result_name_text;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_group_test_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_text_block_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_culture_test_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_snomed_yn;

struct { unsigned short len; unsigned char arr[11]; } rl_tst_cd_test_units;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_cd_test_units_desc;

struct { unsigned short len; unsigned char arr[41]; } rl_test_units;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_cd_range_cmt;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_inhibit_yn;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_range_low_val_nml;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_range_high_val_nml;

struct { unsigned short len; unsigned char arr[41]; } rl_comm_for_test_comm_text;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text1;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text2;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text3;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text4;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text5;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text6;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text7;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text8;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text9;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text10;

struct { unsigned short len; unsigned char arr[6]; } rl_func_operand_1;

struct { unsigned short len; unsigned char arr[2]; } rl_func_operand_1_type;

struct { unsigned short len; unsigned char arr[2]; } rl_func_operator_1;

struct { unsigned short len; unsigned char arr[6]; } rl_func_operand_2;

struct { unsigned short len; unsigned char arr[2]; } rl_func_operand_2_type;

struct { unsigned short len; unsigned char arr[2]; } rl_func_operator_2;

struct { unsigned short len; unsigned char arr[6]; } rl_func_value;

struct { unsigned short len; unsigned char arr[400]; } rl_calc_str;

struct { unsigned short len; unsigned char arr[400]; } rl_func_str;

struct { unsigned short len; unsigned char arr[5]; } rl_res_organism_code;

struct { unsigned short len; unsigned char arr[41]; } rl_res_comment_desc;

struct { unsigned short len; unsigned char arr[41]; } rl_res_organism_code_desc;

struct { unsigned short len; unsigned char arr[5]; } rl_res_dtl_antibiotic_code;

struct { unsigned short len; unsigned char arr[41]; } rl_res_dtl_antibiotic_desc;

struct { unsigned short len; unsigned char arr[2]; } rl_res_dtl_sensitivity_ind;

struct { unsigned short len; unsigned char arr[2]; } rl_res_dtl_report_yn;

struct { unsigned short len; unsigned char arr[81]; } sy_acc_entity_name;

struct { unsigned short len; unsigned char arr[11]; } rl_res_snomed_code;

struct { unsigned short len; unsigned char arr[2]; } rl_param_print_start;

struct { unsigned short len; unsigned char arr[2]; } op_clinic_lab_print_reqd_yn;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc1;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc2;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc3;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc4;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc5;

struct { unsigned short len; unsigned char arr[2]; } rl_snomed_print_yn;

struct { unsigned short len; unsigned char arr[100]; } result_line;

struct { unsigned short len; unsigned char arr[2]; } result_status;

struct { unsigned short len; unsigned char arr[2]; } result_tech_status;

struct { unsigned short len; unsigned char arr[2]; } result_delta_status;

struct { unsigned short len; unsigned char arr[2]; } result_qlty_status;

struct { unsigned short len; unsigned char arr[2]; } result_cmnt_status;

struct { unsigned short len; unsigned char arr[2]; } result_path_status;

struct { unsigned short len; unsigned char arr[2]; } p_function_yn;

struct { unsigned short len; unsigned char arr[11]; } p_test_units;

struct { unsigned short len; unsigned char arr[20]; } d_loc_str;

struct { unsigned short len; unsigned char arr[20]; } d_l_str;

struct { unsigned short len; unsigned char arr[20]; } d_dec_part;

struct { unsigned short len; unsigned char arr[20]; } d_int_part;

struct { unsigned short len; unsigned char arr[20]; } d_sig_part;


   int	no_of_dtl_recs = 0,
        rl_tst_cd_no_of_decimals = 0,
	   	sy_ref_no_of_copies = 0,
        rl_tst_cd_significant_digit = 0,
	   	result_line_no = 0,
		d_dec_pos = 0,
	   	d_after_sig_digit = 0,
	   	p_significant_digit = 0,
	   	p_no_of_decimals = 0;

   int l_count = 0;

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

FILE *rad_fp;
FILE *fp;
int  status_prn   = 0, pgm_flg  = 0,tst_cd_ind = 1;
int copy = 0;
int numeric_value_flag = FALSE;
int  MAX_LINES = 27;
char file_name[150];
char extra_file_name[151];
char lab_file_name[151];
char prev_group_test [6],
     rl_curr_status  [4];

int i = 0,rec_ctr = 0,lctr = 0,pctr = 0;
int spc_first = 0,    ind_test_prn   = 0;
int sleep_sec = 0;
int group_printed = 0;
int group = 0;
int test_printed = 0;
int test_result_found = 0;
char text_line[100];
char test_description[41];
//char g_facility_id[50];

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc < 4)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
      disp_message(ERR_MESG,"Exiting...\n\007\007\007");
      disp_message(ERR_MESG,"rliwdres : uid/password <patient_id> <spec.no> \n");
      proc_exit();
   }
   strcpy(nd_spec_no.arr,argv[3]);
   nd_spec_no.len = strlen(argv[3]);
   strcpy(nd_hosp_no.arr,argv[2]);
   nd_hosp_no.len = strlen(argv[2]);
   strcpy(nd_operating_facility_id.arr,argv[4]);
   nd_operating_facility_id.len = strlen(argv[4]);

   //strcpy(g_facility_id, nd_operating_facility_id.arr);

   /* strcpy(g_facility_id, nd_operating_facility_id.arr); */

   if(sql_connect(argv[1]) == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle\n");
      proc_exit();
   }

   set_meduser_role();

   declare_curs();
   gen_file_name();

   process_rec();

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

/*----------------------------------------------------------*/
process_rec()
{  int i = 0;
   int j = 0,corr_stat = 0;
   char test[6],group_test[6];
       lctr = 0;
       pctr = 0;
       rec_ctr = 0;
       copy = 0;
       open_hdr();
       if(fetch_hdr())
       {
           fetch_other_dtls();
           fetch_dtl();
           copy++;
           open_tst_result();
           strcpy(prev_group_test,"");
           rec_ctr = 0;
           fflush(fp);
	       i = fetch_tst_result();
           while (i)
           {
	          group_printed = 0;
	          group = 0;
              strcpy(group_test, rl_tst_group_test_code.arr);
              strcpy(test,rl_tst_test_code.arr);
	          if(strcmp(group_test,test) !=0)
		         group = 1;
              while(i && strcmp(group_test,rl_tst_group_test_code.arr)==0)
	          {  test_printed = 0;
                 rec_ctr ++;
                 print_dtls();
	             i = fetch_tst_result();
              }
           }
   	       fclose(fp);
	       if(rec_ctr)
	          insert_rl_result_line();
       } 
}
/*------------------------------------------------------------*/
insert_rl_result_line()
{  
   if ((fp = fopen(nd_file_name.arr,"r")) == NULL)
   {
       disp_message(ERR_MESG,"Error while opening file \n");
       proc_exit();
   }
   result_line_no = 0;
   while(fgets(result_line.arr,90,fp))
     {
       result_line.len = strlen(result_line.arr) ;

       if((result_line.len) && (result_line.arr[0] != '\n'))
       {
       result_status.arr[0] = result_line.arr[strlen(result_line.arr)-7];
       result_tech_status.arr[0]  = result_line.arr[strlen(result_line.arr)-6];
       result_delta_status.arr[0] = result_line.arr[strlen(result_line.arr)-5];
       result_qlty_status.arr[0]  = result_line.arr[strlen(result_line.arr)-4];
       result_cmnt_status.arr[0]  = result_line.arr[strlen(result_line.arr)-3];
       result_path_status.arr[0]  = result_line.arr[strlen(result_line.arr)-2];
       result_status.len          = 1;
       result_tech_status.len     = 1;
       result_delta_status.len    = 1;
       result_qlty_status.len     = 1;
       result_cmnt_status.len     = 1;
       result_path_status.len     = 1;
       result_line_no++;
       
       /* EXEC SQL INSERT INTO RL_RESULT_LINE
		       (OPERATING_FACILITY_ID,USER_ID,SPECIMEN_NO,LINE_NO,
			   TEXT,STATUS,TECH_STATUS,DELTA_STATUS,QLTY_STATUS,
			   CMNT_STATUS,PATH_STATUS)
		VALUES (:nd_operating_facility_id,USER,
	            to_number(:nd_spec_no),
		        :result_line_no,
		        substr(:result_line,1,length(:result_line) - 7),
	            :result_status, :result_tech_status, 
			    :result_delta_status, :result_qlty_status, 
			    :result_cmnt_status, :result_path_status); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 11;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "insert into RL_RESULT_LINE (OPERATING_FACILITY_ID,USER\
_ID,SPECIMEN_NO,LINE_NO,TEXT,STATUS,TECH_STATUS,DELTA_STATUS,QLTY_STATUS,CMNT_\
STATUS,PATH_STATUS) values (:b0,USER,to_number(:b1),:b2,substr(:b3,1,(length(:\
b3)-7)),:b5,:b6,:b7,:b8,:b9,:b10)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )20;
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
       sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
       sqlstm.sqhstl[1] = (unsigned int  )22;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&result_line_no;
       sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&result_line;
       sqlstm.sqhstl[3] = (unsigned int  )102;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&result_line;
       sqlstm.sqhstl[4] = (unsigned int  )102;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&result_status;
       sqlstm.sqhstl[5] = (unsigned int  )4;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&result_tech_status;
       sqlstm.sqhstl[6] = (unsigned int  )4;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&result_delta_status;
       sqlstm.sqhstl[7] = (unsigned int  )4;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&result_qlty_status;
       sqlstm.sqhstl[8] = (unsigned int  )4;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&result_cmnt_status;
       sqlstm.sqhstl[9] = (unsigned int  )4;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&result_path_status;
       sqlstm.sqhstl[10] = (unsigned int  )4;
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
}



       result_line.arr[0]          = '\0';
       result_line.len             = 0;
       result_status.arr[0]        ='\0';
       result_status.len           = 0;
       result_tech_status.arr[0]   ='\0';
       result_tech_status.len      = 0;
       result_delta_status.arr[0]  ='\0';
       result_delta_status.len     = 0;
       result_qlty_status.arr[0]   ='\0';
       result_qlty_status.len      = 0;
       result_cmnt_status.arr[0]   ='\0';
       result_cmnt_status.len      = 0;
       result_path_status.arr[0]   ='\0';
       result_path_status.len      = 0;
       if (OERROR)
         err_mesg("INSERT failed on table RL_RESULT_LINE",0,"");
       }
     }       
   if (result_line_no)
     {
     /* EXEC SQL COMMIT WORK; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )79;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     if (OERROR)
         err_mesg("COMMIT failed on table RL_RESULT_LINE",0,"");
     }
   fclose(fp);
}
/*---------------------------------------------------------------------*/
print_group_test_desc()
{
   char group_result[10];
   p_print_name_yn.arr[0] = '\0';
   p_test_desc.arr[0]     = '\0';
   p_function_yn.arr[0]   = '\0';
   p_test_units.arr[0]    = '\0';
   p_test_desc.len        = 0;
   p_print_name_yn.len    = 0;
   p_function_yn.len      = 0;
   p_test_units.len       = 0;
   p_significant_digit    = 0;
   p_no_of_decimals       = 0;

   /* EXEC SQL SELECT LONG_DESC,NVL(PRINT_NAME_YN,'N'),NVL(FUNCTION_YN,'N'),
		           SIGNIFICANT_DIGIT,NO_OF_DECIMALS,TEST_UNITS
	        INTO   :p_test_desc,:p_print_name_yn,:p_function_yn,
		           :p_significant_digit,:p_no_of_decimals,:p_test_units
	        FROM   RL_TEST_CODE 
	        WHERE  TEST_CODE = :rl_tst_group_test_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC ,NVL(PRINT_NAME_YN,'N') ,NVL(FUNCTION_YN,\
'N') ,SIGNIFICANT_DIGIT ,NO_OF_DECIMALS ,TEST_UNITS into :b0,:b1,:b2,:b3,:b4,:\
b5  from RL_TEST_CODE where TEST_CODE=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )94;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&p_test_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_print_name_yn;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_function_yn;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&p_significant_digit;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&p_no_of_decimals;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&p_test_units;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&rl_tst_group_test_code;
   sqlstm.sqhstl[6] = (unsigned int  )8;
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
      err_mesg("Select failed on table RL_TEST_CODE in print_group_test_desc",
	            0,"");

   p_test_desc.arr[p_test_desc.len]         = '\0';
   p_print_name_yn.arr[p_print_name_yn.len] = '\0';
   p_function_yn.arr[p_function_yn.len]     = '\0';
   p_test_units.arr[p_test_units.len]       = '\0';

   if(p_function_yn.arr[0] == 'Y')
   {
      group_result[0] = '\0';
      calc_func_and_prn(rl_tst_group_test_code.arr,group_result);
   } 
   
   if(strlen(p_test_desc.arr) > 35)
      p_test_desc.arr[35] = '\0';

   p_print_name_yn.arr[p_print_name_yn.len]='\0';
   
   p_grp_status.arr[0]     = '\0';
   /* EXEC SQL SELECT NVL(RESULT_STATUS,'O') 
	    INTO   :p_grp_status
	    FROM   RL_REQUEST_DETAIL
	    WHERE  PATIENT_ID  = :nd_hosp_no 
	    AND    SPECIMEN_NO = :nd_spec_no 
	    AND    TEST_CODE = :rl_tst_group_test_code
		AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(RESULT_STATUS,'O') into :b0  from RL_REQUEST_DE\
TAIL where (((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and TEST_CODE=:b3) and OPERA\
TING_FACILITY_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )137;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&p_grp_status;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
   sqlstm.sqhstl[3] = (unsigned int  )8;
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


   if (OERROR)
      err_mesg(
	  "Select failed on RL_REQUEST_DETAIL in print_group_test_desc", 0,"");

   p_grp_status.arr[p_grp_status.len] ='\0';

   if(strcmp(p_print_name_yn.arr,"Y")==0)
      fprintf(fp,"%-37s",p_test_desc.arr);

   if(p_function_yn.arr[0] == 'Y' && test_result_found == 1)
      if(strlen(group_result))
      {
		fprintf(fp,"%-10s",group_result);
		if(p_test_units.len)
		{
			get_test_units_desc_from_sy_uom(p_test_units.arr); //// 19.02.2006
////////19.02.2006	fprintf(fp,"%-10s",p_test_units.arr);
		    fprintf(fp,"%-10s",rl_tst_cd_test_units_desc.arr);  /// 19.02.2006
		}
      }

   if(p_print_name_yn.arr[0] == 'Y' || strlen(group_result))
   {
      fprintf(fp,"%c     \n",p_grp_status.arr[0]);
      page_break(1);
   }

   if(strcmp(p_print_name_yn.arr,"Y")==0)
   {
      fprintf(fp,"-----------------------------------      \n");
      page_break(1);
   } 
}
/*------------------------------------------------------------*/
calc_func_and_prn(l_str,l_str2)
char l_str[],l_str2[];
{
   int func_ctr = 0;

   strcpy(rl_loc_test_code.arr,l_str);
   rl_loc_test_code.len = strlen(rl_loc_test_code.arr);
   open_function_cur();
   strcpy(rl_func_str.arr,"");
   while (fetch_function_cur())
   {
        func_ctr ++;
        strcpy(rl_func_value.arr,rl_func_operand_1.arr);
        test_result_found = 1;
        if (rl_func_operand_1_type.arr[0] == 'T')
             get_rl_test_result(rl_func_operand_1.arr);

	if(test_result_found == 0)
	{
	   l_str2[0] = '\0'; 
	   break;
        }
        strcat(rl_func_str.arr,rl_func_value.arr);
        strcat(rl_func_str.arr," ");

        if (func_ctr != 1)
             calculate_value();

        if (rl_func_operator_1.len == 0)
             break;

        strcat(rl_func_str.arr,rl_func_operator_1.arr);
        strcat(rl_func_str.arr," ");
        strcpy(rl_func_value.arr,rl_func_operand_2.arr);

        test_result_found = 1;

        if (rl_func_operand_2_type.arr[0] == 'T')
             get_rl_test_result(rl_func_operand_2.arr);

	if(test_result_found == 0)
	{
	   l_str2[0] = '\0'; 
	   break;
        }

        strcat(rl_func_str.arr,rl_func_value.arr);
        strcat(rl_func_str.arr," ");
        calculate_value();

        if (rl_func_operator_2.len == 0)
             break;

        strcat(rl_func_str.arr,rl_func_operator_2.arr);
        strcat(rl_func_str.arr," ");
   }
   ltrim(rl_func_str.arr); 
   rtrim(rl_func_str.arr); 
   
   rl_func_str.arr[9] = '\0';
   if (rl_tst_cd_no_of_decimals != 0 ||
             rl_tst_cd_significant_digit != 0)
      get_deci_sig_dig(rl_func_str.arr, p_no_of_decimals, p_significant_digit);
   rl_func_str.arr[5] = '\0';
   sprintf(l_str2,"%-10s",rl_func_str.arr);
}
/*--------------------------------------------------------------------*/
calculate_value()
{
    sprintf(rl_calc_str.arr,"SELECT %s FROM DUAL",rl_func_str.arr);
    rl_calc_str.len = strlen(rl_calc_str.arr);
    /* EXEC SQL PREPARE STR1 FROM :rl_calc_str; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )172;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_calc_str;
    sqlstm.sqhstl[0] = (unsigned int  )402;
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
         err_mesg("PREPARE failed on table DUAL");

    /* EXEC SQL DECLARE CUR1 CURSOR FOR STR1; */ 


    /* EXEC SQL OPEN CUR1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )191;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor CUR1");

    rl_func_str.arr[0] = '\0';
    rl_func_str.len    = 0;

    /* EXEC SQL FETCH CUR1
              INTO :rl_func_str; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )206;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_func_str;
    sqlstm.sqhstl[0] = (unsigned int  )402;
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
         err_mesg("FETCH failed on cursor CUR1");

    rl_func_str.arr[rl_func_str.len] = '\0';
    strcat(rl_func_str.arr," ");
}
/*------------------------------------------------------------*/
get_deci_sig_dig(loc_str,no_of_dec,signif)
                 char *loc_str;
                 int no_of_dec,signif;
{
  char significant_digits_applied_yn = 'N';
  d_dec_pos = 0;
  d_after_sig_digit = 0;  

  d_loc_str.arr[0] = '\0';
  d_dec_part.arr[0] = '\0';
  d_int_part.arr[0] = '\0';
  d_sig_part.arr[0] = '\0';

  d_loc_str.len     = 0;
  d_dec_part.len    = 0;
  d_int_part.len    = 0;
  d_sig_part.len    = 0;

  strcpy(d_loc_str.arr,loc_str);
  d_loc_str.len = strlen(d_loc_str.arr);
/*--- The following IF splits the result into two parts : INTEGER & DECIMAL ---*/
  /* EXEC SQL SELECT INSTR(:d_loc_str,'.') INTO :d_dec_pos FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select INSTR(:b0,'.') into :b1  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )225;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_loc_str;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_dec_pos;
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


  if(d_dec_pos > 0)
  {
      /* EXEC SQL SELECT SUBSTR(:d_loc_str,1,:d_dec_pos - 1) 
		 INTO :d_int_part
		 FROM DUAL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 11;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select SUBSTR(:b0,1,(:b1-1)) into :b2  from DUAL ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )248;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_loc_str;
      sqlstm.sqhstl[0] = (unsigned int  )22;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_dec_pos;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_int_part;
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


      d_int_part.arr[d_int_part.len] = '\0';

      if(strlen(d_loc_str.arr) > d_dec_pos )
      {
         /* EXEC SQL SELECT SUBSTR(:d_loc_str,:d_dec_pos + 1,LENGTH(:d_loc_str)) 
	  	    INTO :d_dec_part
		    FROM DUAL; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 11;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select SUBSTR(:b0,(:b1+1),LENGTH(:b0)) into :b3  fro\
m DUAL ";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )275;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&d_loc_str;
         sqlstm.sqhstl[0] = (unsigned int  )22;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&d_dec_pos;
         sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&d_loc_str;
         sqlstm.sqhstl[2] = (unsigned int  )22;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&d_dec_part;
         sqlstm.sqhstl[3] = (unsigned int  )22;
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


         d_dec_part.arr[d_dec_part.len] = '\0';
      }
  }
  else
  {
     strcpy(d_int_part.arr,d_loc_str.arr);
     d_int_part.len = strlen(d_int_part.arr);
  }
/*--- This IF is to take care of the INTEGER part of the Result ---*/
  if(strlen(d_int_part.arr))
  {
    if(signif > 0)
    {
       if(strlen(d_int_part.arr) <= signif)
       {
          strcpy(d_l_str.arr,d_int_part.arr);
       }
       else
       {
	  significant_digits_applied_yn = 'Y';
	  /* EXEC SQL SELECT SUBSTR(:d_int_part,1,:p_significant_digit)
		     INTO :d_sig_part
		     FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(:b0,1,:b1) into :b2  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )306;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_int_part;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_significant_digit;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sig_part;
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


          d_sig_part.arr[d_sig_part.len] = '\0';
	  /* EXEC SQL SELECT SUBSTR(:d_int_part,:p_significant_digit + 1,1) 
		     INTO :d_after_sig_digit FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(:b0,(:b1+1),1) into :b2  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )333;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_int_part;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_significant_digit;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_after_sig_digit;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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


	  if(d_after_sig_digit >= 5)
	  {
	     /* EXEC SQL SELECT TO_CHAR(TO_NUMBER(:d_sig_part) + 1)
			INTO :d_sig_part FROM DUAL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 11;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select TO_CHAR((TO_NUMBER(:b0)+1)) into :b0  from DUAL ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )360;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_sig_part;
      sqlstm.sqhstl[0] = (unsigned int  )22;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_sig_part;
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


             d_sig_part.arr[d_sig_part.len] = '\0'; 
          }
	  if(d_after_sig_digit == 9)
	  {
             /* EXEC SQL SELECT RPAD(:d_sig_part,LENGTH(:d_int_part)+1,'0')
	   	        INTO :d_l_str FROM DUAL; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 10;
             sqlstm.arrsiz = 11;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = "select RPAD(:b0,(LENGTH(:b1)+1),'0') into :b2  f\
rom DUAL ";
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )383;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)256;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqhstv[0] = (         void  *)&d_sig_part;
             sqlstm.sqhstl[0] = (unsigned int  )22;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_int_part;
             sqlstm.sqhstl[1] = (unsigned int  )22;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_l_str;
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


             d_l_str.arr[d_l_str.len] = '\0'; 
	     if(d_l_str.len > 5)
	     {
		strcpy(d_l_str.arr,loc_str);
		d_l_str.len = strlen(d_l_str.arr);
             }
          }
	  else
	  {
             /* EXEC SQL SELECT RPAD(:d_sig_part,LENGTH(:d_int_part),'0')
	   	        INTO :d_l_str FROM DUAL; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 10;
             sqlstm.arrsiz = 11;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = "select RPAD(:b0,LENGTH(:b1),'0') into :b2  from \
DUAL ";
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )410;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)256;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqhstv[0] = (         void  *)&d_sig_part;
             sqlstm.sqhstl[0] = (unsigned int  )22;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_int_part;
             sqlstm.sqhstl[1] = (unsigned int  )22;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_l_str;
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


          }
          d_l_str.arr[d_l_str.len] = '\0'; 
       }
    }
    else
    {
       strcpy(d_l_str.arr,d_int_part.arr);
    }
  }         
/*--- This IF is to take care of the DECIMAL part of the Result ---*/

if(strlen(d_dec_part.arr) && significant_digits_applied_yn == 'N')
{
  if(no_of_dec > 0)
  {
     strcpy(d_l_str.arr,strcat(d_l_str.arr,"."));
     d_l_str.len = strlen(d_l_str.arr);
     if(strlen(d_dec_part.arr) <= no_of_dec) 
     {
        strcpy(d_l_str.arr,strcat(d_l_str.arr,d_dec_part.arr));
	d_l_str.len = strlen(d_l_str.arr);
     }
     else
     {
        /* EXEC SQL SELECT :d_l_str || SUBSTR(:d_dec_part,1,:p_no_of_decimals)
                   INTO :d_l_str FROM DUAL; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 11;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select (:b0||SUBSTR(:b1,1,:b2)) into :b0  from DUAL ";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )437;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_l_str;
        sqlstm.sqhstl[0] = (unsigned int  )22;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_dec_part;
        sqlstm.sqhstl[1] = (unsigned int  )22;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&p_no_of_decimals;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_l_str;
        sqlstm.sqhstl[3] = (unsigned int  )22;
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


        d_l_str.arr[d_l_str.len] = '\0';
     }
  }
}
  strcpy(loc_str,d_l_str.arr);
}
/*-----------------------------------------------------*/
sql_connect(l_nd_ap_uid_pwd)
char l_nd_ap_uid_pwd[];
{
  strcpy(uid_pwd.arr,l_nd_ap_uid_pwd);
  uid_pwd.len = strlen(uid_pwd.arr);

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )468;
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
/*-----------------------------------------------------*/
declare_curs()
{
    /* EXEC SQL DECLARE RL_REQ_HDR_CUR CURSOR FOR
              SELECT SOURCE_CODE,
                     CONSULTANT_CODE,
                     TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
                     TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                     SECTION_CODE,
                     REQUEST_COMMENT_CODE1,
                     REQUEST_COMMENT_CODE2,
                     REQUEST_COMMENT_CODE3,
                     REQUEST_COMMENT_DESC1,
                     REQUEST_COMMENT_DESC2,
                     REQUEST_COMMENT_DESC3,
                     EXTRA_COPIES_TO,
                     SPECIMEN_TYPE_CODE,					 
                     ADDED_BY_ID,
                     TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH24:MI'),
                     MODIFIED_BY_ID,
                     TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI'),
		     URGENT_INDICATOR,
		     EPISODE_TYPE,
			 ORDERED_FACILITY_ID
                FROM RL_REQUEST_HEADER
               WHERE PATIENT_ID = :nd_hosp_no
                 AND SPECIMEN_NO = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND NVL(CANCELLED_YN,'N') != 'Y'; */ 


    /* EXEC SQL DECLARE RL_REQ_DTL_CUR CURSOR FOR
              SELECT TEST_CODE,
                     NVL(RESULT_STATUS,'O'),
                     DECODE(GROUP_TEST_YN,'Y','G','I')
                FROM RL_REQUEST_DETAIL
               WHERE PATIENT_ID = :nd_hosp_no
                 AND SPECIMEN_NO = :nd_spec_no 
		         AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND NVL(RESULT_STATUS,' ') = 'R'
		         AND NVL(CANCELLED_YN,'N') != 'Y'; */ 


    /* EXEC SQL DECLARE RL_TEST_RESULT_CUR CURSOR FOR
              SELECT GROUP_TEST_CODE,
                     TEST_CODE,
                     NVL(NUMERIC_PREFIX,'+'),
                     NUMERIC_RESULT,
                     RESULT_COMMENT_DESC1,
                     RESULT_COMMENT_DESC2,
                     RESULT_COMMENT_DESC3,
                     RESULT_COMMENT_DESC4,
		             NVL(STATUS,'O'),
		             NVL(TECH_STATUS,'*'),
		             NVL(DELTA_STATUS,'*'),
		             NVL(QLTY_STATUS,'*'),
		             NVL(CMNT_STATUS,'*'),
		             NVL(PATH_STATUS,'*'),
                     ROWID
                FROM RL_TEST_RESULT
               WHERE PATIENT_ID = :nd_hosp_no
                 AND SPECIMEN_NO = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND NVL(CANCELLED_YN,'N') != 'Y'
		         AND GROUP_TEST_CODE IN
		              (SELECT TEST_CODE
                       FROM RL_REQUEST_DETAIL
                       WHERE PATIENT_ID = :nd_hosp_no
                       AND SPECIMEN_NO = :nd_spec_no
					   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		               AND NVL(RESULT_STATUS,'O') IN ('P','R')
		               AND NVL(CANCELLED_YN,'N') != 'Y' )
               ORDER BY GROUP_SEQ_NO,TEST_SEQ_NO; */ 


    /* EXEC SQL DECLARE RL_FUNCTION_CUR CURSOR FOR
              SELECT OPERAND_1,
                     OPERAND_1_TYPE,
                     OPERATOR_1,
                     OPERAND_2,
                     OPERAND_2_TYPE,
                     OPERATOR_2
                FROM RL_FUNCTION
               WHERE TEST_CODE = :rl_loc_test_code
               ORDER BY SEQ_NUMBER; */ 


    /* EXEC SQL DECLARE RL_PAT_MAST_CUR CURSOR FOR
              SELECT SHORT_NAME,
                     SEX,
                     NATIONALITY_CODE,
                     ROUND(TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI') - DATE_OF_BIRTH),
                     TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') 
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :nd_hosp_no; */ 

    
    /* EXEC SQL DECLARE RL_PAT_MAST3_CUR CURSOR FOR
              SELECT SHORT_NAME,
                     SEX,
                     NATIONALITY_CODE,
				     ROUND(TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI') - DATE_OF_BIRTH),
                     TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') 
                FROM RL_PATIENT_MAST
               WHERE PATIENT_ID = :nd_hosp_no; */ 

			   /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

    /* EXEC SQL DECLARE RL_SPECIMEN_TYPE_CODE_CUR CURSOR FOR
              SELECT SPECIMEN_DESC
                FROM RL_SPECIMEN_TYPE_CODE
               WHERE SPECIMEN_TYPE_CODE = :rl_hdr_specimen_type_code; */ 


    /* EXEC SQL DECLARE RL_SECTION_CUR CURSOR FOR
              SELECT LONG_NAME
                FROM RL_SECTION_CODE
               WHERE SECTION_CODE = :rl_hdr_section_code; */ 


    /* EXEC SQL DECLARE RL_TEST_CODE_CUR CURSOR FOR
              SELECT LONG_DESC,
                     NUMERIC_RESULT_YN,
                     AGE_SEX_RANGE_YN,
                     FUNCTION_YN,
                     PRINT_NAME_YN,
                     LOW_VALUE_NORMAL,
                     HIGH_VALUE_NORMAL,
                     GROUP_TEST_YN,
                     TEXT_BLOCK_YN,
                     CULTURE_TEST_YN,
                     SNOMED_YN,
                     TEST_UNITS,
                     NVL(NO_OF_DECIMALS,0),
                     NVL(SIGNIFICANT_DIGIT,0),
                     REF_RANGE_COMMENT,
					 NVL(INHIBIT_REPORT_YN,'N')
                FROM RL_TEST_CODE
               WHERE TEST_CODE = :rl_loc_test_code; */ 

                 

    /* EXEC SQL DECLARE RL_AGE_SEX_RANGE_CUR CURSOR FOR
              SELECT LOW_VALUE_NORMAL,
                     HIGH_VALUE_NORMAL
                FROM RL_AGE_SEX_RANGE
               WHERE TEST_CODE = :rl_tst_test_code
                 AND SEX       = :rl_pat_sex
                 AND :rl_pat_dob_no_of_days
                       BETWEEN CALC_MIN_AGE_IN_DAYS  AND 
                          CALC_MAX_AGE_IN_DAYS; */ 


    /* EXEC SQL DECLARE RL_COMM_FOR_TEST_CUR CURSOR FOR
             SELECT COMMENT_TEXT
             FROM RL_COMMENTS_FOR_TEST
             WHERE TEST_CODE = :rl_tst_test_code
	       ORDER BY SEQ_NO; */ 


    /* EXEC SQL DECLARE RL_RESULT_TEXT_CUR CURSOR FOR
             SELECT  RESULT_TEXT RESULT_TEXT_LINE1,
                     RESULT_TEXT RESULT_TEXT_LINE2,
                     RESULT_TEXT RESULT_TEXT_LINE3,
                     RESULT_TEXT RESULT_TEXT_LINE4,
                     RESULT_TEXT RESULT_TEXT_LINE5,
                     RESULT_TEXT RESULT_TEXT_LINE6,
                     RESULT_TEXT RESULT_TEXT_LINE7,
                     RESULT_TEXT RESULT_TEXT_LINE8,
                     RESULT_TEXT RESULT_TEXT_LINE9,
                     RESULT_TEXT RESULT_TEXT_LINE10
                FROM RL_RESULT_TEXT
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
            ORDER BY SERIAL_NO; */ 


    /* EXEC SQL DECLARE RL_TEST_RESULT_CUR2 CURSOR FOR
              SELECT NUMERIC_RESULT
                FROM RL_TEST_RESULT
               WHERE PATIENT_ID     = :nd_hosp_no
                 AND SPECIMEN_NO    = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND TEST_CODE      = :rl_loc_test_code; */ 


    /* EXEC SQL DECLARE RL_RESULT_SNOMED_CUR CURSOR FOR
              SELECT SNOMED_CODE
                FROM RL_RESULT_SNOMED
               WHERE PATIENT_ID     = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
	       ORDER BY SNOMED_CODE; */ 


    /* EXEC SQL DECLARE RL_SNOMED_CODE_CUR CURSOR FOR
              SELECT DESCRIPTION_1,
                     DESCRIPTION_2,
                     DESCRIPTION_3,
                     DESCRIPTION_4,
                     DESCRIPTION_5,
		     PRINT_YN
                FROM RL_SNOMED_CODE
               WHERE SNOMED_MARKER_CODE= :rl_res_snomed_code; */ 

//			     AND OPERATING_FACILITY_ID = :nd_operating_facility_id;

    /* EXEC SQL DECLARE RL_RESULT_ORGANISM_CUR CURSOR FOR
              SELECT ORGANISM_CODE,
                     RESULT_COMMENT_DESC
                FROM RL_RESULT_ORGANISM
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code; */ 


    /* EXEC SQL DECLARE RL_RESULT_ORGANISM_DTL_CUR CURSOR FOR
              SELECT ANTIBIOTIC_CODE,
                     SENSITIVITY_IND,
		             REPORT_YN
                FROM RL_RESULT_ORGANISM_DTL
               WHERE PATIENT_ID     = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
                 AND ORGANISM_CODE   = :rl_res_organism_code
		 AND SENSITIVITY_IND IN ('S','R','I')
		 AND REPORT_YN = 'Y'
               ORDER BY REPORT_YN DESC, SENSITIVITY_IND DESC; */ 

		 

    /* EXEC SQL DECLARE RL_ORGANISM_CODE_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM RL_ORGANISM_CODE
               WHERE ORGANISM_CODE = :rl_res_organism_code; */ 


    /* EXEC SQL DECLARE RL_ANTIBIOTIC_CODE_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM RL_ANTIBIOTIC_CODE
               WHERE ANTIBIOTIC_CODE = :rl_res_dtl_antibiotic_code; */ 

}

/*-----------------------------------------------------*/
gen_file_name()
{
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
     sprintf(nd_file_name.arr,"rlilbres.lis");
     nd_file_name.len = strlen(nd_file_name.arr);
     strcpy(file_name,nd_file_name.arr);
   if ((fp = fopen(nd_file_name.arr,"w")) == NULL)
   {
       disp_message(ERR_MESG,"Error while opening file \n");
       proc_exit();
   }

}
/*-----------------------------------------------------*/
close_hdr()
{
    /* EXEC SQL CLOSE RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )499;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("CLOSE failed on cursor RL_REQ_HDR_CUR",0,"");
}

/*-----------------------------------------------------*/
open_hdr()
{
    /* EXEC SQL OPEN RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0017;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )514;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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
         err_mesg("OPEN failed on cursor RL_REQ_HDR_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_hdr()
{
  rl_hdr_source_code.arr[0]            = '\0';
  rl_hdr_consultant_code.arr[0]        = '\0';
  rl_hdr_spec_regd_date_time.arr[0]    = '\0';
  rl_hdr_current_date_time.arr[0]      = '\0';
  rl_hdr_section_code.arr[0]           = '\0';
  rl_hdr_request_comment_code1.arr[0]  = '\0';
  rl_hdr_request_comment_code2.arr[0]  = '\0';
  rl_hdr_request_comment_code3.arr[0]  = '\0';
  rl_hdr_request_comment_desc1.arr[0]  = '\0';
  rl_hdr_request_comment_desc2.arr[0]  = '\0';
  rl_hdr_request_comment_desc3.arr[0]  = '\0';
  rl_hdr_extra_copies_to.arr[0]        = '\0';
  rl_hdr_specimen_type_code.arr[0]     = '\0';
  rl_hdr_added_by_id.arr[0]            = '\0';
  rl_hdr_added_date.arr[0]             = '\0';
  rl_hdr_modified_by_id.arr[0]         = '\0';
  rl_hdr_modified_date.arr[0]          = '\0';
  rl_hdr_episode_type.arr[0]           = '\0';
  rl_hdr_urgent_indicator.arr[0]       = '\0';
  rl_ordered_facility_id.arr[0]		   = '\0';

  rl_hdr_source_code.len               = 0;
  rl_hdr_consultant_code.len           = 0;
  rl_hdr_spec_regd_date_time.len       = 0;
  rl_hdr_current_date_time.len         = 0;
  rl_hdr_section_code.len              = 0;
  rl_hdr_request_comment_code1.len     = 0;
  rl_hdr_request_comment_code2.len     = 0;
  rl_hdr_request_comment_code3.len     = 0;
  rl_hdr_request_comment_desc1.len     = 0;
  rl_hdr_request_comment_desc2.len     = 0;
  rl_hdr_request_comment_desc3.len     = 0;
  rl_hdr_extra_copies_to.len           = 0;
  rl_hdr_specimen_type_code.len        = 0;
  rl_hdr_added_by_id.len               = 0;
  rl_hdr_added_date.len                = 0;
  rl_hdr_modified_by_id.len            = 0;
  rl_hdr_modified_date.len             = 0;
  rl_hdr_episode_type.len			   = 0;
  rl_hdr_urgent_indicator.len	       = 0;
  rl_ordered_facility_id.len		   = 0;

    /* EXEC SQL FETCH RL_REQ_HDR_CUR
              INTO :rl_hdr_source_code,
                   :rl_hdr_consultant_code,
                   :rl_hdr_spec_regd_date_time,
                   :rl_hdr_current_date_time,
                   :rl_hdr_section_code,
                   :rl_hdr_request_comment_code1,
                   :rl_hdr_request_comment_code2,
                   :rl_hdr_request_comment_code3,
                   :rl_hdr_request_comment_desc1,
                   :rl_hdr_request_comment_desc2,
                   :rl_hdr_request_comment_desc3,
                   :rl_hdr_extra_copies_to,
                   :rl_hdr_specimen_type_code,
                   :rl_hdr_added_by_id,
                   :rl_hdr_added_date,
                   :rl_hdr_modified_by_id,
                   :rl_hdr_modified_date,
  		   :rl_hdr_urgent_indicator,
  		   :rl_hdr_episode_type,
		   :rl_ordered_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )541;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_source_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_hdr_consultant_code;
    sqlstm.sqhstl[1] = (unsigned int  )18;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[2] = (unsigned int  )19;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_hdr_current_date_time;
    sqlstm.sqhstl[3] = (unsigned int  )19;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_hdr_section_code;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_hdr_request_comment_code1;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_hdr_request_comment_code2;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_hdr_request_comment_code3;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_hdr_request_comment_desc1;
    sqlstm.sqhstl[8] = (unsigned int  )43;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rl_hdr_request_comment_desc2;
    sqlstm.sqhstl[9] = (unsigned int  )43;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rl_hdr_request_comment_desc3;
    sqlstm.sqhstl[10] = (unsigned int  )43;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rl_hdr_extra_copies_to;
    sqlstm.sqhstl[11] = (unsigned int  )18;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rl_hdr_specimen_type_code;
    sqlstm.sqhstl[12] = (unsigned int  )7;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rl_hdr_added_by_id;
    sqlstm.sqhstl[13] = (unsigned int  )33;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rl_hdr_added_date;
    sqlstm.sqhstl[14] = (unsigned int  )18;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&rl_hdr_modified_by_id;
    sqlstm.sqhstl[15] = (unsigned int  )33;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&rl_hdr_modified_date;
    sqlstm.sqhstl[16] = (unsigned int  )18;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&rl_hdr_urgent_indicator;
    sqlstm.sqhstl[17] = (unsigned int  )4;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&rl_hdr_episode_type;
    sqlstm.sqhstl[18] = (unsigned int  )4;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&rl_ordered_facility_id;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
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
        err_mesg("FETCH failed on cursor RL_REQ_HDR_CUR",0,"");

    rl_hdr_source_code.arr[rl_hdr_source_code.len]		 	= '\0';
    rl_hdr_consultant_code.arr[rl_hdr_consultant_code.len]		= '\0';
    rl_hdr_spec_regd_date_time.arr[rl_hdr_spec_regd_date_time.len] 	= '\0';
    rl_hdr_current_date_time.arr[rl_hdr_current_date_time.len] 		= '\0';
    rl_hdr_section_code.arr[rl_hdr_section_code.len] 			= '\0';
    rl_hdr_request_comment_code1.arr[rl_hdr_request_comment_code1.len] = '\0';
    rl_hdr_request_comment_code2.arr[rl_hdr_request_comment_code2.len] = '\0';
    rl_hdr_request_comment_code3.arr[rl_hdr_request_comment_code3.len] = '\0';
    rl_hdr_request_comment_desc1.arr[rl_hdr_request_comment_desc1.len] = '\0';
    rl_hdr_request_comment_desc2.arr[rl_hdr_request_comment_desc2.len] = '\0';
    rl_hdr_request_comment_desc3.arr[rl_hdr_request_comment_desc3.len] = '\0';
    rl_hdr_extra_copies_to.arr[rl_hdr_extra_copies_to.len]             = '\0';
    rl_hdr_specimen_type_code.arr[rl_hdr_specimen_type_code.len]       = '\0';
    rl_hdr_added_by_id.arr[rl_hdr_added_by_id.len]                     = '\0';
    rl_hdr_added_date.arr[rl_hdr_added_date.len]                       = '\0';
    rl_hdr_modified_by_id.arr[rl_hdr_modified_by_id.len]               = '\0';
    rl_hdr_modified_date.arr[rl_hdr_modified_date.len]                 = '\0';
    rl_hdr_episode_type.arr[rl_hdr_episode_type.len]		           = '\0';
    rl_hdr_urgent_indicator.arr[rl_hdr_urgent_indicator.len]	       = '\0';
	rl_ordered_facility_id.arr[rl_ordered_facility_id.len]			   = '\0';
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

fetch_dtl()
{
    /* EXEC SQL OPEN RL_REQ_DTL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0018;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )636;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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
         err_mesg("OPEN failed on cursor RL_REQ_DTL_CUR",0,"");

    for (i=0;i<6;i++)
    {
        rl_dtl_test_code[i].arr[0]         = '\0';
        rl_dtl_result_status[i].arr[0]     = '\0';
        rl_dtl_group_test_flag[i].arr[0]   = '\0';

        rl_dtl_test_code[i].len            = 0;
        rl_dtl_result_status[i].len        = 0;
        rl_dtl_group_test_flag[i].len      = 0;
    }

    /* EXEC SQL FETCH RL_REQ_DTL_CUR
              INTO :rl_dtl_test_code,
                   :rl_dtl_result_status,
                   :rl_dtl_group_test_flag; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )7;
    sqlstm.offset = (unsigned int  )663;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)rl_dtl_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )8;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqharc[0] = (unsigned int   *)0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)rl_dtl_result_status;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )4;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqharc[1] = (unsigned int   *)0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)rl_dtl_group_test_flag;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )4;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqharc[2] = (unsigned int   *)0;
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
         err_mesg("FETCH failed on cursor RL_REQ_DTL_CUR",0,"");

    no_of_dtl_recs = sqlca.sqlerrd[2];

    for (i=0;i<sqlca.sqlerrd[2];i++)
    {
        rl_dtl_test_code[i].arr[rl_dtl_test_code[i].len]         = '\0';
        rl_dtl_result_status[i].arr[rl_dtl_result_status[i].len] = '\0';
        rl_dtl_group_test_flag[i].arr[rl_dtl_group_test_flag[i].len]  = '\0';
    }
}
/*-----------------------------------------------------*/

open_tst_result()
{
    /* EXEC SQL OPEN RL_TEST_RESULT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0019;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )690;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[4] = (unsigned int  )22;
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
         err_mesg("OPEN failed on cursor RL_TEST_RESULT_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_tst_result()
{

  rl_tst_group_test_code.arr[0]      	  = '\0';
  rl_tst_test_code.arr[0]     	 	  = '\0';
  rl_tst_numeric_prefix.arr[0] 	          = '\0';
  rl_tst_numeric_result.arr[0]            = '\0';
  rl_tst_result_comment_desc1.arr[0]      = '\0';
  rl_tst_result_comment_desc2.arr[0]      = '\0';
  rl_tst_result_comment_desc3.arr[0]      = '\0';
  rl_tst_result_comment_desc4.arr[0]      = '\0';
  rl_tst_status.arr[0] 			  = '\0';
  rl_tst_tech_status.arr[0] 	 	  = '\0';
  rl_tst_delta_status.arr[0] 		  = '\0';
  rl_tst_qlty_status.arr[0] 		  = '\0';
  rl_tst_cmnt_status.arr[0] 		  = '\0';
  rl_tst_path_status.arr[0] 		  = '\0';
  rl_tst_rowid.arr[0]                     = '\0';

  rl_tst_group_test_code.len              = 0;
  rl_tst_test_code.len         		  = 0;
  rl_tst_numeric_prefix.len         	  = 0;
  rl_tst_numeric_result.len 	          = 0;
  rl_tst_result_comment_desc1.len         = 0;
  rl_tst_result_comment_desc2.len         = 0;
  rl_tst_result_comment_desc3.len         = 0;
  rl_tst_result_comment_desc4.len         = 0;
  rl_tst_status.len 			  = 0;
  rl_tst_tech_status.len 	 	  = 0;
  rl_tst_delta_status.len 		  = 0;
  rl_tst_qlty_status.len 		  = 0;
  rl_tst_cmnt_status.len 		  = 0;
  rl_tst_path_status.len 		  = 0;
  rl_tst_rowid.len                        = 0;

    /* EXEC SQL FETCH RL_TEST_RESULT_CUR
              INTO :rl_tst_group_test_code,
                   :rl_tst_test_code,
                   :rl_tst_numeric_prefix,
                   :rl_tst_numeric_result,
                   :rl_tst_result_comment_desc1,
                   :rl_tst_result_comment_desc2,
                   :rl_tst_result_comment_desc3,
                   :rl_tst_result_comment_desc4,
		   :rl_tst_status,
		   :rl_tst_tech_status,
		   :rl_tst_delta_status,
		   :rl_tst_qlty_status,
		   :rl_tst_cmnt_status,
		   :rl_tst_path_status,
                   :rl_tst_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )729;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_tst_numeric_prefix;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_numeric_result;
    sqlstm.sqhstl[3] = (unsigned int  )8;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_result_comment_desc1;
    sqlstm.sqhstl[4] = (unsigned int  )43;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_tst_result_comment_desc2;
    sqlstm.sqhstl[5] = (unsigned int  )43;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_tst_result_comment_desc3;
    sqlstm.sqhstl[6] = (unsigned int  )43;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_tst_result_comment_desc4;
    sqlstm.sqhstl[7] = (unsigned int  )43;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_tst_status;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rl_tst_tech_status;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rl_tst_delta_status;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rl_tst_qlty_status;
    sqlstm.sqhstl[11] = (unsigned int  )4;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rl_tst_cmnt_status;
    sqlstm.sqhstl[12] = (unsigned int  )4;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rl_tst_path_status;
    sqlstm.sqhstl[13] = (unsigned int  )4;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rl_tst_rowid;
    sqlstm.sqhstl[14] = (unsigned int  )33;
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
}



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_TEST_RESULT_CUR",0,"");

    rl_tst_group_test_code.arr[rl_tst_group_test_code.len] = '\0';
    rl_tst_test_code.arr[rl_tst_test_code.len] = '\0';
    rl_tst_numeric_prefix.arr[rl_tst_numeric_prefix.len] = '\0';
    rl_tst_numeric_result.arr[rl_tst_numeric_result.len] = '\0';
    rl_tst_result_comment_desc1.arr[rl_tst_result_comment_desc1.len] = '\0';
    rl_tst_result_comment_desc2.arr[rl_tst_result_comment_desc2.len] = '\0';
    rl_tst_result_comment_desc3.arr[rl_tst_result_comment_desc3.len] = '\0';
    rl_tst_result_comment_desc4.arr[rl_tst_result_comment_desc4.len] = '\0';
    rl_tst_rowid.arr[rl_tst_rowid.len] = '\0';
    rl_tst_status.arr[rl_tst_status.len]= '\0';

    rl_tst_tech_status.arr[rl_tst_tech_status.len] = '\0'; 
    rl_tst_delta_status.arr[rl_tst_delta_status.len] = '\0'; 
    rl_tst_qlty_status.arr[rl_tst_qlty_status.len] = '\0'; 
    rl_tst_cmnt_status.arr[rl_tst_cmnt_status.len] = '\0'; 
    rl_tst_path_status.arr[rl_tst_path_status.len] = '\0'; 

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

print_dtls()
{
    int next_line = 0;
    char range_cmnt_print_flag = 'N';
    char l_str [100],l_str1[100];
    int agesex_range_flag = FALSE;
    int path_review_flag = FALSE;
    numeric_value_flag = FALSE;
    strcpy(l_str,"");
    page_break(0);
    fetch_test_code(rl_tst_test_code.arr);
	if(rl_tst_cd_inhibit_yn.arr[0] == 'N')
	{
    spc_first = 1;
    fflush(fp);
    ind_test_prn = 0;
    if(rl_tst_cd_print_report_yn.arr[0] == 'Y')
        sprintf(l_str,"%-37.37s",rl_tst_cd_short_desc.arr);
    else
        sprintf(l_str,"%-37s"," ");
    strcpy(text_line,l_str);
    strcpy(test_description,l_str);
    if (rl_tst_cd_numeric_result_yn.arr[0] == 'Y')
    {
	if (rl_tst_numeric_result.len)
	{
	  numeric_value_flag = TRUE;
	  if(rl_tst_numeric_prefix.arr[0] == '+')
	  {
             sprintf(l_str,"%s%-10s",l_str,rl_tst_numeric_result.arr);
          }
	  else
	  {
             sprintf(l_str,"%s%c%-10s",l_str,rl_tst_numeric_prefix.arr[0],
					     rl_tst_numeric_result.arr);
          }
          strcpy(l_str1,l_str);
          ltrim(l_str1);
          rtrim(l_str1); 

   		  get_test_units_desc_from_sy_uom(rl_tst_cd_test_units.arr); //// 19.02.2006

/// 19.02.2006          sprintf(l_str,"%s%-10s",l_str,rl_tst_cd_test_units.arr);

          sprintf(l_str,"%s%-10s",l_str,rl_tst_cd_test_units_desc.arr); /// 19.02.2006

          if (rl_tst_cd_age_sex_range_yn.arr[0] == 'Y')
          {
	     if(rl_pat_sex.arr[0] == 'M' || rl_pat_sex.arr[0] == 'F')
                fetch_age_sex_range();
             if (rl_tst_range_low_val_nml.len  ||
                 rl_tst_range_high_val_nml.len )
	       {
                  sprintf(l_str,"%s( %-4s - %-4s )",l_str,
                    rl_tst_range_low_val_nml.arr,
                    rl_tst_range_high_val_nml.arr);
		  agesex_range_flag = TRUE;
               }
	     else
	     {
	  	    if(rl_tst_cd_range_cmt.len)
		    {
               range_cmnt_print_flag = 'Y';
             }
		 }
       }
	 else
	   {
	      if(rl_tst_cd_range_cmt.len)
	      {
                 range_cmnt_print_flag = 'Y';
          }
       }
        strcpy(l_str1,l_str);
        ltrim(l_str1);
        rtrim(l_str1);
	if(group && !group_printed)
	{
	   print_group_test_desc();
	   group_printed = 1;
        }
	next_line = 0;
	if(range_cmnt_print_flag == 'Y')
	{
	   if(strlen(rl_tst_cd_range_cmt.arr) <= ( 77 - strlen(l_str)))
	   {
	      sprintf(l_str,"%s%s",l_str,rl_tst_cd_range_cmt.arr);
           }
	   else
	      next_line = 1;
        }
        print_line(l_str);
	test_printed  = 1;
	if(next_line == 1)
	{
	   sprintf(l_str,"%-37.37s%-40s"," ",rl_tst_cd_range_cmt.arr);
           print_line(l_str);
        }
      }
    }
     print_comment_desc1234();
     print_test_comments();
     if(rl_tst_cd_culture_test_yn.arr[0] == 'Y')
	print_culture();
     if (rl_tst_cd_text_block_yn.arr[0] == 'Y') /* optional result text */
     {
        open_result_text();
        while(fetch_result_text())
	  print_result_text();
     }
     if (rl_tst_cd_snomed_yn.arr[0] == 'Y') 	/*  optional snomed text */
          print_snomed();
     fflush(fp);
   }/* endif for inhibit_yn */
}
/*-----------------------------------------------------*/
print_range_comment(int agesex_range_flag,int path_review_flag)
{
  if (rl_tst_cd_range_cmt.len) 	 /* optional Range comment */
    {
     if (agesex_range_flag == TRUE ||
	 path_review_flag == TRUE )
	 ;
     else
     {
       if(group && !group_printed)
       {
	  print_group_test_desc();
	  group_printed = 1;
       }
       if(test_printed)
       {  numeric_value_flag = TRUE;
          print_line_check(rl_tst_cd_range_cmt.arr);
       }
       else
       {
	  numeric_value_flag = FALSE;
	  sprintf(text_line,"%-37.37s%-40s",test_description,
				rl_tst_cd_range_cmt.arr);
	  print_line_check(text_line);
	  test_printed = 1;
       }
     }
    }
}
/*-----------------------------------------------------*/
print_test_comments()
{
open_comments();
while(fetch_comments())
  {
  if (rl_comm_for_test_comm_text.len)
     {
       if(group && !group_printed)
       {
	  print_group_test_desc();
	  group_printed = 1;
       }
       if(test_printed)
       {  numeric_value_flag = TRUE;
          print_line_check(rl_comm_for_test_comm_text.arr);
       }
       else
       {
	  numeric_value_flag = FALSE;
	  sprintf(text_line,"%-37.37s%s",test_description,
			   rl_comm_for_test_comm_text.arr);
	  print_line_check(text_line);
	  test_printed = 1;
       }
     }
  }
}
/*-----------------------------------------------------*/

print_result_text()
{
   if(rl_res_result_text1.len || rl_res_result_text2.len || 
      rl_res_result_text3.len || rl_res_result_text4.len || 
      rl_res_result_text5.len || rl_res_result_text6.len || 
      rl_res_result_text7.len || rl_res_result_text8.len || 
      rl_res_result_text9.len || rl_res_result_text10.len )
   {
      if(group && !group_printed)
      {   print_group_test_desc();
	  group_printed = 1;
      }
      if(!test_printed  && strlen(test_description))
      {     numeric_value_flag = FALSE;  
	    sprintf(text_line,"%37.37s%-40s",test_description," ");
            print_line_check(text_line);
	    test_printed = 1;
      }
   
    		if (rl_res_result_text1.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		  	print_line(rl_res_result_text1.arr);
		  }
    		if (rl_res_result_text2.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		        print_line(rl_res_result_text2.arr);
		  }
    		if (rl_res_result_text3.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		  	 print_line(rl_res_result_text3.arr);
		  }
    		if (rl_res_result_text4.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text4.arr);
		  }
    		if (rl_res_result_text5.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text5.arr);
		  }
    		if (rl_res_result_text6.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text6.arr);
		  }
    		if (rl_res_result_text7.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text7.arr);
		  }
    		if (rl_res_result_text8.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text8.arr);
		  }
    		if (rl_res_result_text9.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text9.arr);
		  }
    		if (rl_res_result_text10.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		  	print_line(rl_res_result_text10.arr);
		  }
            	fflush(fp);
   }
}
/*-----------------------------------------------------*/
print_line(char *t_str)
{
         fprintf(fp,"%s%c%c%c%c%c%c\n",t_str,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
         page_break(1);
}
/*-----------------------------------------------------*/
print_line_check(char *t_str)
{
       if (numeric_value_flag == TRUE)
	  {
	  fprint_repeat(fp,' ',37);
	  print_line(t_str);
	  numeric_value_flag = TRUE;
	  }
       else  
         {
	   print_line(t_str);
	   numeric_value_flag = TRUE;
	 }
}
/*-----------------------------------------------------*/

print_snomed()
{
int ctr = 0;
char prev_snomed_print_yn = 'N';
    open_result_snomed();
    while (fetch_rl_result_snomed())
    {
        if (fetch_snomed_desc12345())
        {
	    if (rl_snomed_print_yn.arr[0] == 'Y')
            {   
		print_snomed_desc12345();
	    }
	    else
	    {
	      if(group && !group_printed)
	      {   print_group_test_desc();
		  group_printed = 1;
              }
	      if(!test_printed)
	      {
		fprintf(fp,"%-37.37s%c%c%c%c%c%c\n",test_description,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
		test_printed = 1;
              }
	      print_line(rl_res_snomed_code.arr);
           }
	ctr++;
        }
    }
}
/*-----------------------------------------------------*/

open_result_snomed()
{
    /* EXEC SQL OPEN RL_RESULT_SNOMED_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0030;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )804;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )8;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
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
         err_mesg("OPEN failed on cursor RL_RESULT_SNOMED_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_rl_result_snomed()
{
    rl_res_snomed_code.arr[0]     = '\0';
    rl_res_snomed_code.len        = 0;

    /* EXEC SQL FETCH RL_RESULT_SNOMED_CUR
              INTO :rl_res_snomed_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )839;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_snomed_code;
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



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_RESULT_SNOMED_CUR",0,"");

    rl_res_snomed_code.arr[rl_res_snomed_code.len] = '\0';
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

print_culture()
{
    char temp_sens_ind;
    char temp_line[81];
    char temp_report_yn;
    int still_org_dtl_left;
    int print_anti_flag = 0;
    int change_flag = 0;

    open_result_organism();
    while(fetch_result_org())
    {
       if (rl_res_comment_desc.len)
       {  
	  if(group && !group_printed)
          {
	     print_group_test_desc();
	     group_printed = 1;
          }
          if(test_printed)
          {  numeric_value_flag = TRUE;
             print_line_check(rl_res_comment_desc.arr);
          }
          else
          {
	     numeric_value_flag = FALSE;
	     sprintf(text_line,"%-37.37s%-40s",test_description,
	   		    rl_res_comment_desc.arr);
	     print_line_check(text_line);
	     test_printed = 1;
          }
       }
       fetch_org_desc();
       if (rl_res_organism_code_desc.len)
       {
	  if(group && !group_printed)
          {
	     print_group_test_desc();
	     group_printed = 1;
          }
          if(test_printed)
          {  
	     numeric_value_flag = TRUE;
             print_line_check(rl_res_organism_code_desc.arr);
          }
          else
          {
	     numeric_value_flag = FALSE;
	     sprintf(text_line,"%-37.37s%-40s",test_description,
	   		    rl_res_organism_code_desc.arr);
	     print_line_check(text_line);
	     test_printed = 1;
          }
       }
       temp_sens_ind = '\0';
       open_result_organism_dtl();
       temp_line[0] = '\0';
       still_org_dtl_left = fetch_result_org_dtl(); 
       while(still_org_dtl_left)
       {
	  strcpy(temp_line,"");
	  temp_sens_ind = rl_res_dtl_sensitivity_ind.arr[0];
	  if(temp_sens_ind == 'S')
	     sprintf(temp_line,"%-37.37s","Sensitive To :-");
          else
	     if(temp_sens_ind == 'R')
	        sprintf(temp_line,"%-37.37s","Resistant To :-");
             else
	        if(temp_sens_ind == 'I')
	           sprintf(temp_line,"%-37.37s","Intermediate :-");

	  print_anti_flag = 0;
	  change_flag = 0;
          while(still_org_dtl_left && temp_sens_ind == 
					    rl_res_dtl_sensitivity_ind.arr[0])
          {
	       temp_report_yn = rl_res_dtl_report_yn.arr[0];
               if(temp_sens_ind == 'R' && temp_report_yn == 'N')
		    sprintf(temp_line,"%-37.37s","Resistant To :- (Held)");
               else
		 if(temp_sens_ind == 'S' && temp_report_yn == 'N')
		    sprintf(temp_line,"%-37.37s","Sensitive To :- (Held)");
                 else
		    if(temp_sens_ind == 'I' && temp_report_yn == 'N')
		       sprintf(temp_line,"%-37.37s","Intermediate :- (Held)");
             while(still_org_dtl_left && temp_sens_ind == 
					    rl_res_dtl_sensitivity_ind.arr[0]
		   && temp_report_yn == rl_res_dtl_report_yn.arr[0]) 
             {
               fetch_antibiotic_desc();
	       change_flag = 0;
               if((77 - strlen(temp_line)) > 
				  (strlen(rl_res_dtl_antibiotic_desc.arr) + 1))
               {
		   strcat(temp_line,rl_res_dtl_antibiotic_desc.arr);
		   strcat(temp_line,",");
		   print_anti_flag = 0;
               }
	       else
	       {
		   print_line(temp_line);
		   strcpy(temp_line,"");
		   sprintf(temp_line,"%-37.37s"," ");
		   strcat(temp_line,rl_res_dtl_antibiotic_desc.arr);
		   strcat(temp_line,",");
		   print_anti_flag = 1;
               }
               still_org_dtl_left = fetch_result_org_dtl();
	       if(temp_sens_ind != rl_res_dtl_sensitivity_ind.arr[0] ||
		  temp_report_yn != rl_res_dtl_report_yn.arr[0])
		 if(print_anti_flag == 1)
		    change_flag = 1;
             }
	     if(print_anti_flag == 0 || change_flag == 1)
	     {
	        temp_line[strlen(temp_line) - 1] = '\0';
	        print_line(temp_line);
             }
          }
       }
    }
}
/*-----------------------------------------------------*/

scan_and_prnt(l_str)
char *l_str;
{
   for(;*l_str != '\0';l_str++)
   {
     fprintf(fp,"%c",*l_str);
     if (*l_str == '\n')
        page_break(1);
   }
   fprintf(fp,"\n");
   page_break(1);
}
/*-----------------------------------------------------*/

open_result_organism()
{
    /* EXEC SQL OPEN RL_RESULT_ORGANISM_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0032;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )858;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )8;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
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
         err_mesg("OPEN failed on cursor RL_RESULT_ORGANISM_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_result_org()
{
    rl_res_organism_code.arr[0]   = '\0';
    rl_res_comment_desc.arr[0]    = '\0';

    rl_res_organism_code.len      = 0;
    rl_res_comment_desc.len       = 0;

    /* EXEC SQL FETCH RL_RESULT_ORGANISM_CUR
              INTO :rl_res_organism_code,
                   :rl_res_comment_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )893;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_organism_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_res_comment_desc;
    sqlstm.sqhstl[1] = (unsigned int  )43;
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
         err_mesg("FETCH failed on cursor RL_RESULT_ORGANISM_CUR",0,"");

    rl_res_organism_code.arr[rl_res_organism_code.len] = '\0';
    rl_res_comment_desc.arr[rl_res_comment_desc.len] = '\0';
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

fetch_org_desc()
{
    /* EXEC SQL OPEN RL_ORGANISM_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0034;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )916;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_organism_code;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor RL_ORGANISM_CODE_CUR",0,"");

    rl_res_organism_code_desc.arr[0] = '\0';
    rl_res_organism_code_desc.len    = 0;

    /* EXEC SQL FETCH RL_ORGANISM_CODE_CUR
              INTO :rl_res_organism_code_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )935;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_organism_code_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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



    rl_res_organism_code_desc.arr[rl_res_organism_code_desc.len] = '\0';

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_ORGANISM_CODE_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_antibiotic_desc()
{
    /* EXEC SQL OPEN RL_ANTIBIOTIC_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0035;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )954;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_dtl_antibiotic_code;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor RL_ANTIBIOTIC_CODE_CUR",0,"");

    rl_res_dtl_antibiotic_desc.arr[0] = '\0';
    rl_res_dtl_antibiotic_desc.len    = 0;

    /* EXEC SQL FETCH RL_ANTIBIOTIC_CODE_CUR
              INTO :rl_res_dtl_antibiotic_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )973;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_dtl_antibiotic_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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



    rl_res_dtl_antibiotic_desc.arr[rl_res_dtl_antibiotic_desc.len] = '\0';

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_ANTIBIOTIC_CODE_CUR",0,"");
}
/*-----------------------------------------------------*/

open_result_organism_dtl()
{
    /* EXEC SQL OPEN RL_RESULT_ORGANISM_DTL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0033;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )992;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )8;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_res_organism_code;
    sqlstm.sqhstl[5] = (unsigned int  )7;
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
         err_mesg("OPEN failed on cursor RL_RESULT_ORGANISM_DTL_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_result_org_dtl()
{
    rl_res_dtl_antibiotic_code.arr[0]   = '\0';
    rl_res_dtl_sensitivity_ind.arr[0]   = '\0';

    rl_res_dtl_antibiotic_code.len      = 0;
    rl_res_dtl_sensitivity_ind.len      = 0;

    /* EXEC SQL FETCH RL_RESULT_ORGANISM_DTL_CUR
              INTO :rl_res_dtl_antibiotic_code,
                   :rl_res_dtl_sensitivity_ind,
		   :rl_res_dtl_report_yn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1031;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_dtl_antibiotic_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_res_dtl_sensitivity_ind;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_res_dtl_report_yn;
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
}



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_RESULT_ORGANISM_DTL_CUR",0,"");

    rl_res_dtl_antibiotic_code.arr[rl_res_dtl_antibiotic_code.len] = '\0';
    rl_res_dtl_sensitivity_ind.arr[rl_res_dtl_sensitivity_ind.len] = '\0';
    rl_res_dtl_report_yn.arr[rl_res_dtl_report_yn.len]             = '\0';

    return (LAST_ROW?0:1);
}

/*-----------------------------------------------------*/
fetch_other_dtls()
{
   fetch_pat_name();
   fetch_spec_desc();
   fetch_consultant();
   fetch_section();
}
/*-----------------------------------------------------*/
fetch_pat_name()
{
    /* EXEC SQL OPEN RL_PAT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0021;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1058;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
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



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_PAT_MAST_CUR",0,"");

    rl_pat_long_name.arr[0]     = '\0';
    rl_pat_short_name.arr[0]     = '\0';
    rl_pat_sex.arr[0]           = '\0';
    rl_pat_nationality.arr[0]           = '\0';
    rl_pat_dob_no_of_days.arr[0]           = '\0';
    rl_pat_date_of_birth.arr[0]            = '\0';
    rl_pat_blood_group.arr[0]              = '\0';
    rl_pat_g6pd.arr[0]              = '\0';
    rl_pat_sicc.arr[0]              = '\0';
    rl_pat_hbl4_1.arr[0]              = '\0';
    rl_pat_hbl4_2.arr[0]              = '\0';

    rl_pat_long_name.len         = 0;
    rl_pat_short_name.len         = 0;
    rl_pat_sex.len         = 0;
    rl_pat_nationality.len         = 0;
    rl_pat_dob_no_of_days.len         = 0;
    rl_pat_date_of_birth.len          = 0;
    rl_pat_g6pd.len                   = 0;
    rl_pat_sicc.len                   = 0;
    rl_pat_hbl4_1.len                   = 0;
    rl_pat_hbl4_2.len                   = 0;

    /* EXEC SQL FETCH RL_PAT_MAST_CUR
              INTO :rl_pat_short_name,
                   :rl_pat_sex,
                   :rl_pat_nationality,
                   :rl_pat_dob_no_of_days,
                   :rl_pat_date_of_birth; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1081;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_pat_short_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_pat_sex;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_pat_nationality;
    sqlstm.sqhstl[2] = (unsigned int  )6;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_pat_dob_no_of_days;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_pat_date_of_birth;
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
       err_mesg("Error with MP_PATIENT_MAST fetch",0,"");
    else
	   if(NODATAFOUND)
	   {
                /* EXEC SQL OPEN RL_PAT_MAST3_CUR; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 20;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = sq0022;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )1116;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
                sqlstm.sqhstl[0] = (unsigned int  )19;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
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


    		/* EXEC SQL FETCH RL_PAT_MAST3_CUR
              	         INTO   :rl_pat_short_name,
                   		:rl_pat_sex,
                   		:rl_pat_nationality,
                   		:rl_pat_dob_no_of_days,
                   		:rl_pat_date_of_birth; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 20;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1139;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_pat_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )63;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_pat_sex;
      sqlstm.sqhstl[1] = (unsigned int  )4;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&rl_pat_nationality;
      sqlstm.sqhstl[2] = (unsigned int  )6;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_pat_dob_no_of_days;
      sqlstm.sqhstl[3] = (unsigned int  )12;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&rl_pat_date_of_birth;
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
                  err_mesg("Error with RL_PATIENT_MAST fetch",0,"");	
               else
	          if(NODATAFOUND)
                        ;
       }
    rl_pat_long_name.arr[rl_pat_long_name.len] = '\0';
    rl_pat_short_name.arr[rl_pat_short_name.len] = '\0';
    rl_pat_long_name.arr[rl_pat_long_name.len] = '\0';
    rl_pat_short_name.arr[rl_pat_short_name.len] = '\0';
    rl_pat_sex.arr[rl_pat_sex.len] = '\0';
    rl_pat_nationality.arr[rl_pat_nationality.len] = '\0';
    rl_pat_dob_no_of_days.arr[rl_pat_dob_no_of_days.len] = '\0';
    rl_pat_date_of_birth.arr[rl_pat_date_of_birth.len]   = '\0';

}

/*-----------------------------------------------------*/
fetch_spec_desc()
{
    /* EXEC SQL OPEN RL_SPECIMEN_TYPE_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0023;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1174;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_specimen_type_code;
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



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_SPECIMEN_TYPE_CODE_CUR",0,"");

    rl_spc_specimen_desc.arr[0] = '\0';
    rl_spc_specimen_desc.len    = 0;

    /* EXEC SQL FETCH RL_SPECIMEN_TYPE_CODE_CUR
              INTO :rl_spc_specimen_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1193;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_spc_specimen_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
         err_mesg("FETCH failed on cursor RL_SPECIMEN_TYPE_CODE_CUR",0,"");

    rl_spc_specimen_desc.arr[rl_spc_specimen_desc.len] = '\0';

}
/*-----------------------------------------------------*/

fetch_test_code(loc_tst_code)
char loc_tst_code[];
{
    strcpy(rl_loc_test_code.arr,loc_tst_code);
    rl_loc_test_code.len  =  strlen(rl_loc_test_code.arr);

    /* EXEC SQL OPEN RL_TEST_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0025;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1212;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_loc_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
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
         err_mesg("OPEN failed on cursor RL_TEST_CODE_CUR",0,"");

    rl_tst_cd_short_desc.arr[0]         = '\0';
    rl_tst_cd_numeric_result_yn.arr[0]  = '\0';
    rl_tst_cd_age_sex_range_yn.arr[0]   = '\0';
    rl_tst_cd_function_yn.arr[0]        = '\0';
    rl_tst_cd_print_report_yn.arr[0]    = '\0';
    rl_tst_cd_low_value_normal.arr[0]   = '\0';
    rl_tst_cd_high_value_normal.arr[0]  = '\0';
    rl_tst_cd_test_units.arr[0]   = '\0';
    rl_tst_cd_group_test_yn.arr[0]      = '\0';
    rl_tst_cd_text_block_yn.arr[0]      = '\0';
    rl_tst_cd_culture_test_yn.arr[0]    = '\0';
    rl_tst_cd_snomed_yn.arr[0]          = '\0';
    rl_tst_cd_range_cmt.arr[0]          = '\0';
    rl_tst_cd_inhibit_yn.arr[0]         = '\0';

    rl_tst_cd_short_desc.len            = 0;
    rl_tst_cd_numeric_result_yn.len     = 0;
    rl_tst_cd_age_sex_range_yn.len      = 0;
    rl_tst_cd_function_yn.len           = 0;
    rl_tst_cd_print_report_yn.len       = 0;
    rl_tst_cd_low_value_normal.len      = 0;
    rl_tst_cd_high_value_normal.len     = 0;
    rl_tst_cd_test_units.len      = 0;
    rl_tst_cd_group_test_yn.len         = 0;
    rl_tst_cd_text_block_yn.len         = 0;
    rl_tst_cd_culture_test_yn.len       = 0;
    rl_tst_cd_snomed_yn.len             = 0;
    rl_tst_cd_range_cmt.len             = 0;
    rl_tst_cd_inhibit_yn.len            = 0;

    rl_tst_cd_no_of_decimals = 0;
    rl_tst_cd_significant_digit = 0;

    /* EXEC SQL FETCH RL_TEST_CODE_CUR
              INTO :rl_tst_cd_short_desc,
                   :rl_tst_cd_numeric_result_yn,
                   :rl_tst_cd_age_sex_range_yn,
                   :rl_tst_cd_function_yn,
                   :rl_tst_cd_print_report_yn,
                   :rl_tst_cd_low_value_normal,
                   :rl_tst_cd_high_value_normal,
                   :rl_tst_cd_group_test_yn,
                   :rl_tst_cd_text_block_yn,
                   :rl_tst_cd_culture_test_yn,
                   :rl_tst_cd_snomed_yn,
                   :rl_tst_cd_test_units,
                   :rl_tst_cd_no_of_decimals,
                   :rl_tst_cd_significant_digit,
                   :rl_tst_cd_range_cmt,
				   :rl_tst_cd_inhibit_yn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1231;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_cd_short_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_tst_cd_numeric_result_yn;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_tst_cd_age_sex_range_yn;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_cd_function_yn;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_cd_print_report_yn;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_tst_cd_low_value_normal;
    sqlstm.sqhstl[5] = (unsigned int  )18;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_tst_cd_high_value_normal;
    sqlstm.sqhstl[6] = (unsigned int  )18;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_tst_cd_group_test_yn;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_tst_cd_text_block_yn;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rl_tst_cd_culture_test_yn;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rl_tst_cd_snomed_yn;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rl_tst_cd_test_units;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rl_tst_cd_no_of_decimals;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rl_tst_cd_significant_digit;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rl_tst_cd_range_cmt;
    sqlstm.sqhstl[14] = (unsigned int  )43;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&rl_tst_cd_inhibit_yn;
    sqlstm.sqhstl[15] = (unsigned int  )4;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
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
         err_mesg("FETCH failed on cursor RL_TEST_CODE_CUR",0,"");

    rl_tst_cd_short_desc.arr[rl_tst_cd_short_desc.len] = '\0';
    if(strlen(rl_tst_cd_short_desc.arr) > 35)
	rl_tst_cd_short_desc.arr[35]='\0';

    rl_tst_cd_numeric_result_yn.arr[rl_tst_cd_numeric_result_yn.len] = '\0';
    rl_tst_cd_age_sex_range_yn.arr[rl_tst_cd_age_sex_range_yn.len] = '\0';
    rl_tst_cd_function_yn.arr[rl_tst_cd_function_yn.len] = '\0';
    rl_tst_cd_print_report_yn.arr[rl_tst_cd_print_report_yn.len] = '\0';
    rl_tst_cd_low_value_normal.arr[rl_tst_cd_low_value_normal.len] = '\0';
    rl_tst_cd_high_value_normal.arr[rl_tst_cd_high_value_normal.len] = '\0';
    rl_tst_cd_test_units.arr[rl_tst_cd_test_units.len] = '\0';
    rl_tst_cd_group_test_yn.arr[rl_tst_cd_group_test_yn.len] = '\0';
    rl_tst_cd_text_block_yn.arr[rl_tst_cd_text_block_yn.len] = '\0';
    rl_tst_cd_culture_test_yn.arr[rl_tst_cd_culture_test_yn.len] = '\0';
    rl_tst_cd_snomed_yn.arr[rl_tst_cd_snomed_yn.len] = '\0';
    rl_tst_cd_range_cmt.arr[rl_tst_cd_range_cmt.len] = '\0';
    rl_tst_cd_inhibit_yn.arr[rl_tst_cd_inhibit_yn.len] = '\0';

    rl_tst_cd_no_of_decimals = rl_tst_cd_no_of_decimals>4?4:
                         rl_tst_cd_no_of_decimals;
    rl_tst_cd_significant_digit = rl_tst_cd_no_of_decimals>5?5:
                         rl_tst_cd_significant_digit;

    if (sqlca.sqlerrd[2]) tst_cd_ind = 1;
    return (sqlca.sqlerrd[2]);
}
/*-----------------------------------------------------*/
fetch_consultant()
{
    if (rl_hdr_episode_type.arr[0] == 'I') 
      {
      /* EXEC SQL  SELECT FULL_NAME
		  INTO :rl_consultant_short_name
                  FROM SY_PHYSICIAN_MAST
                 WHERE FACILITY_ID = NVL(:rl_ordered_facility_id, :nd_operating_facility_id)
				 AND PHYSICIAN_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 20;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST where\
 (FACILITY_ID=NVL(:b1,:b2) and PHYSICIAN_ID=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1310;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_consultant_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
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
      sqlstm.sqhstv[3] = (         void  *)&rl_hdr_consultant_code;
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


      }
    else if (rl_hdr_episode_type.arr[0] == 'R' || rl_hdr_episode_type.arr[0] == 'H') 
      {
      /* EXEC SQL  SELECT LONG_NAME
		  INTO :rl_consultant_short_name
                  FROM RL_CONSULTANTS
                 WHERE REF_CONSULTANT_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 20;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select LONG_NAME into :b0  from RL_CONSULTANTS where RE\
F_CONSULTANT_ID=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1341;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_consultant_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_hdr_consultant_code;
      sqlstm.sqhstl[1] = (unsigned int  )18;
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


      }
    else if (rl_hdr_episode_type.arr[0] == 'O') 
      {
      /* EXEC SQL  SELECT FULL_NAME
		  INTO :rl_consultant_short_name
                  FROM SY_PHYSICIAN_MAST
                  WHERE FACILITY_ID = NVL(:rl_ordered_facility_id, :nd_operating_facility_id)
				  AND PHYSICIAN_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 20;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST where\
 (FACILITY_ID=NVL(:b1,:b2) and PHYSICIAN_ID=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1364;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_consultant_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
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
      sqlstm.sqhstv[3] = (         void  *)&rl_hdr_consultant_code;
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


      }
    else
       err_mesg("Invalid Episode type in Request Header",0,"");
	      
    if (OERROR)
         err_mesg("FETCH failed on CONSULTANT Master ",0,"");

    rl_consultant_short_name.arr[rl_consultant_short_name.len] = '\0';
}
/*-----------------------------------------------------*/
fetch_section()
{
    /* EXEC SQL OPEN RL_SECTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0024;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1395;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_section_code;
    sqlstm.sqhstl[0] = (unsigned int  )4;
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
         err_mesg("OPEN failed on cursor RL_SECTION_CUR",0,"");

    rl_section_short_name.arr[0] 	= '\0';
    rl_section_short_name.len		= 0;

    /* EXEC SQL FETCH RL_SECTION_CUR
              INTO :rl_section_short_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1414;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_section_short_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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



    rl_section_short_name.arr[rl_section_short_name.len] = '\0';

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_SECTION_CUR",0,"");

}
/*-----------------------------------------------------*/

fetch_age_sex_range()
{

    /* EXEC SQL OPEN RL_AGE_SEX_RANGE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0026;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1433;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_pat_sex;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_pat_dob_no_of_days;
    sqlstm.sqhstl[2] = (unsigned int  )12;
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
         err_mesg("OPEN failed on cursor RL_AGE_SEX_RANGE_CUR",0,"");

   rl_tst_range_low_val_nml.arr[0]      = '\0';
   rl_tst_range_high_val_nml.arr[0]      = '\0';

   rl_tst_range_low_val_nml.len         = 0;
   rl_tst_range_high_val_nml.len         = 0;

    /* EXEC SQL FETCH RL_AGE_SEX_RANGE_CUR
              INTO :rl_tst_range_low_val_nml,
                   :rl_tst_range_high_val_nml; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1460;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_range_low_val_nml;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_tst_range_high_val_nml;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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
         err_mesg("FETCH failed on cursor RL_AGE_SEX_RANGE_CUR",0,"");

   rl_tst_range_low_val_nml.arr[rl_tst_range_low_val_nml.len] = '\0';
    rl_tst_range_high_val_nml.arr[rl_tst_range_high_val_nml.len] = '\0';
}
/*-----------------------------------------------------*/

open_comments()
{
    /* EXEC SQL OPEN RL_COMM_FOR_TEST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0027;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1483;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
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
         err_mesg("OPEN failed on cursor RL_COMM_FOR_TEST_CUR",0,"");
}
/*-----------------------------------------------------*/
fetch_comments()
{

   rl_comm_for_test_comm_text.arr[0]     = '\0';
   rl_comm_for_test_comm_text.len        = 0;

    /* EXEC SQL FETCH RL_COMM_FOR_TEST_CUR
              INTO :rl_comm_for_test_comm_text; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1502;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_comm_for_test_comm_text;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
         err_mesg("FETCH failed on cursor RL_COMM_FOR_TEST_CUR",0,"");

   rl_comm_for_test_comm_text.arr[rl_comm_for_test_comm_text.len] = '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
print_comment_desc1234()
{
  if (rl_tst_result_comment_desc1.len || rl_tst_result_comment_desc2.len ||
     rl_tst_result_comment_desc3.len || rl_tst_result_comment_desc4.len)
  {  
     if(group && !group_printed)
     {   print_group_test_desc();
	 group_printed = 1;
     }
     if(test_printed)
	 numeric_value_flag = TRUE;
     else
	{
	 numeric_value_flag = FALSE;
         fprintf(fp,"%-37.37s",test_description);
	 test_printed = 1;
        }
    if (rl_tst_result_comment_desc1.len != 0)
         print_line_check(rl_tst_result_comment_desc1.arr);
    if (rl_tst_result_comment_desc2.len != 0)
         print_line_check(rl_tst_result_comment_desc2.arr);
    if (rl_tst_result_comment_desc3.len != 0)
         print_line_check(rl_tst_result_comment_desc3.arr);
    if (rl_tst_result_comment_desc4.len != 0)
         print_line_check(rl_tst_result_comment_desc4.arr);
  }
}
/*-----------------------------------------------------*/

fetch_snomed_desc12345()
{
    /* EXEC SQL OPEN RL_SNOMED_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0031;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1521;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_snomed_code;
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



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_SNOMED_CODE_CUR",0,"");

    rl_snomed_desc1.arr[0]          = '\0';
    rl_snomed_desc2.arr[0]          = '\0';
    rl_snomed_desc3.arr[0]          = '\0';
    rl_snomed_desc4.arr[0]          = '\0';
    rl_snomed_desc5.arr[0]          = '\0';
    rl_snomed_print_yn.arr[0]       = '\0';

    rl_snomed_desc1.len             = 0;
    rl_snomed_desc2.len             = 0;
    rl_snomed_desc3.len             = 0;
    rl_snomed_desc4.len             = 0;
    rl_snomed_desc5.len             = 0;
    rl_snomed_print_yn.len	    = 0;

    /* EXEC SQL FETCH RL_SNOMED_CODE_CUR
              INTO :rl_snomed_desc1,
                   :rl_snomed_desc2,
                   :rl_snomed_desc3,
                   :rl_snomed_desc4,
                   :rl_snomed_desc5,
    		   :rl_snomed_print_yn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1540;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_snomed_desc1;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_snomed_desc2;
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_snomed_desc3;
    sqlstm.sqhstl[2] = (unsigned int  )43;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_snomed_desc4;
    sqlstm.sqhstl[3] = (unsigned int  )43;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_snomed_desc5;
    sqlstm.sqhstl[4] = (unsigned int  )43;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_snomed_print_yn;
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



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_SNOMED_CODE_CUR",0,"");

    rl_snomed_desc1.arr[rl_snomed_desc1.len] = '\0';
    rl_snomed_desc2.arr[rl_snomed_desc2.len] = '\0';
    rl_snomed_desc3.arr[rl_snomed_desc3.len] = '\0';
    rl_snomed_desc4.arr[rl_snomed_desc4.len] = '\0';
    rl_snomed_desc5.arr[rl_snomed_desc5.len] = '\0';
    rl_snomed_print_yn.arr[rl_snomed_print_yn.len] = '\0';

   return (sqlca.sqlerrd[2]);
}
/*-----------------------------------------------------*/
print_snomed_desc12345()
{
  if(rl_snomed_desc1.len || rl_snomed_desc2.len||
     rl_snomed_desc3.len || rl_snomed_desc4.len|| 
     rl_snomed_desc5.len)
  {
    if(group && !group_printed)
    {   print_group_test_desc();
	group_printed = 1;
    }
    if(!test_printed)
    {
       fprintf(fp,"%-37.37s%c%c%c%c%c%c\n",test_description,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
       test_printed = 1;
    }
    if (rl_snomed_desc1.len != 0)
    {
         fprint_repeat(fp,' ',37);
         fprintf(fp,"%s%c%c%c%c%c%c\n",rl_snomed_desc1.arr,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
         page_break(1);
    }
    if (rl_snomed_desc2.len != 0)
    {
         fprint_repeat(fp,' ',37);
         fprintf(fp,"%s%c%c%c%c%c%c\n",rl_snomed_desc2.arr,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
         page_break(1);
    }
    if (rl_snomed_desc3.len != 0)
    {
         fprint_repeat(fp,' ',37);
         fprintf(fp,"%s%c%c%c%c%c%c\n",rl_snomed_desc3.arr,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
         page_break(1);
    }
    if (rl_snomed_desc4.len != 0)
    {
         fprint_repeat(fp,' ',37);
         fprintf(fp,"%s%c%c%c%c%c%c\n",rl_snomed_desc4.arr,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
         page_break(1);
    }
    if (rl_snomed_desc5.len != 0)
    {
         fprint_repeat(fp,' ',37);
         fprintf(fp,"%s%c%c%c%c%c%c\n",rl_snomed_desc5.arr,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
         page_break(1);
    }
  }
}
/*-----------------------------------------------------*/

fprint_repeat(l_fp,l_prn_chr,l_no)
FILE *l_fp;
char l_prn_chr;
int  l_no;
{
   int l_i = 0;

   for (l_i = 0;l_i < l_no;l_i++)
        fputc(l_prn_chr,l_fp);
}
/*-----------------------------------------------------*/

page_break(l_skip)
int l_skip;
{
    lctr+= l_skip;
}
/*-----------------------------------------------------*/
open_result_text()
{
    /* EXEC SQL OPEN RL_RESULT_TEXT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0028;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1579;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )8;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
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
         err_mesg("OPEN failed on cursor RL_RESULT_TEXT_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_result_text()
{
    rl_res_result_text1.arr[0]  = '\0';
    rl_res_result_text1.len     = 0;
    rl_res_result_text2.arr[0]  = '\0';
    rl_res_result_text2.len     = 0;
    rl_res_result_text3.arr[0]  = '\0';
    rl_res_result_text3.len     = 0;
    rl_res_result_text4.arr[0]  = '\0';
    rl_res_result_text4.len     = 0;
    rl_res_result_text5.arr[0]  = '\0';
    rl_res_result_text5.len     = 0;
    rl_res_result_text6.arr[0]  = '\0';
    rl_res_result_text6.len     = 0;
    rl_res_result_text7.arr[0]  = '\0';
    rl_res_result_text7.len     = 0;
    rl_res_result_text8.arr[0]  = '\0';
    rl_res_result_text8.len     = 0;
    rl_res_result_text9.arr[0]  = '\0';
    rl_res_result_text9.len     = 0;
    rl_res_result_text10.arr[0]  = '\0';
    rl_res_result_text10.len     = 0;

    /* EXEC SQL FETCH RL_RESULT_TEXT_CUR
              INTO :rl_res_result_text1,
                   :rl_res_result_text2,
                   :rl_res_result_text3,
                   :rl_res_result_text4,
                   :rl_res_result_text5,
                   :rl_res_result_text6,
                   :rl_res_result_text7,
                   :rl_res_result_text8,
                   :rl_res_result_text9,
                   :rl_res_result_text10
	      ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1614;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_result_text1;
    sqlstm.sqhstl[0] = (unsigned int  )73;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_res_result_text2;
    sqlstm.sqhstl[1] = (unsigned int  )73;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_res_result_text3;
    sqlstm.sqhstl[2] = (unsigned int  )73;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_res_result_text4;
    sqlstm.sqhstl[3] = (unsigned int  )73;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_res_result_text5;
    sqlstm.sqhstl[4] = (unsigned int  )73;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_res_result_text6;
    sqlstm.sqhstl[5] = (unsigned int  )73;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_res_result_text7;
    sqlstm.sqhstl[6] = (unsigned int  )73;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_res_result_text8;
    sqlstm.sqhstl[7] = (unsigned int  )73;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_res_result_text9;
    sqlstm.sqhstl[8] = (unsigned int  )73;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rl_res_result_text10;
    sqlstm.sqhstl[9] = (unsigned int  )73;
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
}



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_RESULT_TEXT_CUR",0,"");

    rl_res_result_text1.arr[rl_res_result_text1.len] = '\0';
    rl_res_result_text2.arr[rl_res_result_text2.len] = '\0';
    rl_res_result_text3.arr[rl_res_result_text3.len] = '\0';
    rl_res_result_text4.arr[rl_res_result_text4.len] = '\0';
    rl_res_result_text5.arr[rl_res_result_text5.len] = '\0';
    rl_res_result_text6.arr[rl_res_result_text6.len] = '\0';
    rl_res_result_text7.arr[rl_res_result_text7.len] = '\0';
    rl_res_result_text8.arr[rl_res_result_text8.len] = '\0';
    rl_res_result_text9.arr[rl_res_result_text9.len] = '\0';
    rl_res_result_text10.arr[rl_res_result_text10.len] = '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
get_rl_test_result(l_test_code)
char l_test_code[];
{
    test_result_found = 1;
    strcpy(rl_loc_test_code.arr,l_test_code);
    rl_loc_test_code.len = strlen(rl_loc_test_code.arr);

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


    rl_func_value.arr[0] = '\0';
    rl_func_value.len    = 0;

    /* EXEC SQL SELECT NUMERIC_RESULT INTO :rl_func_value
               FROM RL_TEST_RESULT
              WHERE PATIENT_ID      = :nd_hosp_no
                AND SPECIMEN_NO     = :nd_spec_no
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                AND TEST_CODE       = :rl_loc_test_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NUMERIC_RESULT into :b0  from RL_TEST_RESULT where\
 (((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) and TES\
T_CODE=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1669;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_func_value;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
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
    sqlstm.sqhstv[4] = (         void  *)&rl_loc_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )8;
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
    {
       disp_message(ERR_MESG,"Error occurred at get_rl_test_result() no_data_found");
       proc_exit();
    }

    rl_func_value.arr[rl_func_value.len] = '\0';

    if(strlen(rl_func_value.arr) == 0)
       test_result_found = 0;
return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   disp_message(ERR_MESG,"Error occurred at get_rl_test_result()");
   return;

}
/*-----------------------------------------------------*/
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
/*-----------------------------------------------------*/

rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
}
/*-----------------------------------------------------*/
open_function_cur()
{
    /* EXEC SQL OPEN RL_FUNCTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0020;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1704;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_loc_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
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
         err_mesg("OPEN failed on cursor RL_FUNCTION_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_function_cur()
{
    rl_func_operand_1.arr[0]          = '\0';
    rl_func_operand_1_type.arr[0]     = '\0';
    rl_func_operator_1.arr[0]         = '\0';
    rl_func_operand_2.arr[0]          = '\0';
    rl_func_operand_2_type.arr[0]     = '\0';
    rl_func_operator_2.arr[0]         = '\0';

    rl_func_operand_1.len             = 0;
    rl_func_operand_1_type.len        = 0;
    rl_func_operator_1.len            = 0;
    rl_func_operand_2.len             = 0;
    rl_func_operand_2_type.len        = 0;
    rl_func_operator_2.len            = 0;

    /* EXEC SQL FETCH RL_FUNCTION_CUR
              INTO :rl_func_operand_1,
                   :rl_func_operand_1_type,
                   :rl_func_operator_1,
                   :rl_func_operand_2,
                   :rl_func_operand_2_type,
                   :rl_func_operator_2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1723;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_func_operand_1;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_func_operand_1_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_func_operator_1;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_func_operand_2;
    sqlstm.sqhstl[3] = (unsigned int  )8;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_func_operand_2_type;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_func_operator_2;
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



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_FUNCTION_CUR",0,"");

    rl_func_operand_1.arr[rl_func_operand_1.len]           = '\0';
    rl_func_operand_1_type.arr[rl_func_operand_1_type.len] = '\0';
    rl_func_operator_1.arr[rl_func_operator_1.len]         = '\0';
    rl_func_operand_2.arr[rl_func_operand_2.len]           = '\0';
    rl_func_operand_2_type.arr[rl_func_operand_2_type.len] = '\0';
    rl_func_operator_2.arr[rl_func_operator_2.len]         = '\0';
    return (LAST_ROW?0:1);
}
/*--------------------------------------------------------------------*/
close_all_cur()
{
    /* EXEC SQL CLOSE RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1762;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_REQ_DTL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1777;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_TEST_RESULT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1792;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_PAT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1807;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_SPECIMEN_TYPE_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1822;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_SECTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1837;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_TEST_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1852;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_AGE_SEX_RANGE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1867;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_COMM_FOR_TEST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1882;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_RESULT_TEXT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1897;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_TEST_RESULT_CUR2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1912;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_RESULT_SNOMED_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1927;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_SNOMED_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1942;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_RESULT_ORGANISM_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1957;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_RESULT_ORGANISM_DTL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1972;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_ORGANISM_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1987;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_ANTIBIOTIC_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2002;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_PAT_MAST3_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2017;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}
/*--------- added the below on 19.02.2006 -------------------------------------*/
get_test_units_desc_from_sy_uom(l_test_units)
char l_test_units[];
{

   rl_tst_cd_test_units_desc.arr[0]		= '\0';      
   rl_tst_cd_test_units_desc.len		= 0;

   strcpy(rl_test_units.arr,l_test_units);
   rl_test_units.len = strlen(rl_test_units.arr);

   /* EXEC SQL SELECT  short_desc
			  INTO :rl_tst_cd_test_units_desc
		  	  FROM SY_UOM
			 WHERE uom_code = :rl_test_units; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from SY_UOM where uom_code=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2032;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_tst_cd_test_units_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_test_units;
   sqlstm.sqhstl[1] = (unsigned int  )43;
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



	if (NODATAFOUND)
	{
		strcpy(rl_tst_cd_test_units_desc.arr,rl_test_units.arr);    
		rl_tst_cd_test_units_desc.len = strlen(rl_tst_cd_test_units_desc.arr);
//		rl_tst_cd_test_units_desc.arr[rl_tst_cd_test_units_desc.len]	= '\0';

	}

    if (OERROR)
	{
		strcpy(rl_tst_cd_test_units_desc.arr,rl_test_units.arr);    
		rl_tst_cd_test_units_desc.len = strlen(rl_tst_cd_test_units_desc.arr);
	}

	rl_tst_cd_test_units_desc.arr[rl_tst_cd_test_units_desc.len]	= '\0';

}
/*------------------------------------------------------------*/
