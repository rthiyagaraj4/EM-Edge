
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRWHODT.pc"
};


static unsigned int sqlctx = 1288616411;


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
            void  *sqhstv[22];
   unsigned int   sqhstl[22];
            int   sqhsts[22];
            void  *sqindv[22];
            int   sqinds[22];
   unsigned int   sqharm[22];
   unsigned int   *sqharc[22];
   unsigned short  sqadto[22];
   unsigned short  sqtdso[22];
} sqlstm = {12,22};

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
"select sequence_no ,specimen_no ,ltrim(rtrim(upper(log_table_name))) ,to_cha\
r(time_stamp,'dd/mm/yy hh24:mi') ,user_id  from rl_specimen_log where (SPECIME\
N_NO=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) order by sequence_no       \
     ";

 static const char *sq0004 = 
"select GROUP_TEST_CODE ,TEST_CODE ,ORGANISM_CODE ,B_GROUP_TEST_CODE ,B_TEST_\
CODE ,LINE_NO ,RESULT_COMMENT_CODE1 ,RESULT_COMMENT_DESC1 ,MODIFIED_BY_ID ,TO_\
CHAR(MODIFIED_DATE,'DD/MM/YY HH24:MI') MODIFIED_DATE  from RL_RESULT_ORGANISM_\
TESTS_DTL where (SPECIMEN_NO=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1)    \
       ";

 static const char *sq0005 = 
"select RESULT_TEXT ,MODIFIED_BY_ID ,TO_CHAR(MODIFIED_DATE,'DD/MM/YY HH24:MI'\
) MODIFIED_DATE  from RL_ORGANISM_TESTS_RESULT_TEXT where ((((((SPECIMEN_NO=TO\
_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) and GROUP_TEST_CODE=:b2) and TEST_\
CODE=:b3) and ORGANISM_CODE=:b4) and B_GROUP_TEST_CODE=:b5) and B_TEST_CODE=:b\
6)           ";

 static const char *sq0044 = 
"select sequence_no ,specimen_no ,ltrim(rtrim(upper(log_table_name))) ,to_cha\
r(time_stamp,'dd/mm/yy hh24:mi') ,user_id  from rl_specimen_log where (SPECIME\
N_NO=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) order by sequence_no       \
     ";

 static const char *sq0047 = 
"select test_code ,TO_CHAR(created_date_time,'DD/MM/YY HH24:MI') ,review_done\
_by ,TO_CHAR(reviewed_date_time,'DD/MM/YY HH24:MI') ,review_type  from RL_CA_R\
ES_REVIEW_DONE_LOG where ((SPECIMEN_NO=TO_NUMBER(:b0) and SEQUENCE_NO=TO_NUMBE\
R(:b1)) and OPERATING_FACILITY_ID=:b2) order by sequence_no            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,384,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,443,0,0,0,0,0,1,0,
51,0,0,3,0,0,13,508,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
86,0,0,4,0,0,13,559,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
141,0,0,6,213,0,6,587,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
168,0,0,5,0,0,13,611,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
195,0,0,7,219,0,6,623,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
222,0,0,3,237,0,9,648,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
245,0,0,3,0,0,15,688,0,0,0,0,0,1,0,
260,0,0,4,317,0,9,698,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
283,0,0,5,323,0,9,785,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
326,0,0,5,0,0,15,802,0,0,0,0,0,1,0,
341,0,0,8,701,0,4,1061,0,0,22,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
444,0,0,9,239,0,6,1147,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
471,0,0,10,235,0,6,1156,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
498,0,0,11,235,0,6,1165,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
525,0,0,12,213,0,6,1174,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
552,0,0,13,286,0,4,1211,0,0,7,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,1,9,0,0,
595,0,0,14,286,0,4,1257,0,0,7,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,1,9,0,0,
638,0,0,15,181,0,4,1288,0,0,10,7,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,
1,4,0,0,1,4,0,0,2,3,0,0,2,3,0,0,2,3,0,0,
693,0,0,16,393,0,4,1473,0,0,10,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
748,0,0,17,213,0,6,1507,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
775,0,0,18,392,0,4,1540,0,0,10,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
830,0,0,19,213,0,6,1574,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
857,0,0,20,424,0,4,1677,0,0,13,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
924,0,0,21,213,0,6,1721,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
951,0,0,22,550,0,4,1797,0,0,16,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
1030,0,0,23,213,0,6,1837,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1057,0,0,24,437,0,4,1917,0,0,13,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1124,0,0,25,213,0,6,1955,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1151,0,0,26,500,0,4,2017,0,0,16,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
1230,0,0,27,213,0,6,2075,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1257,0,0,28,405,0,4,2146,0,0,12,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1320,0,0,29,213,0,6,2183,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1347,0,0,30,290,0,4,2314,0,0,8,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
1394,0,0,31,213,0,6,2341,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1421,0,0,32,411,0,4,2419,0,0,12,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1484,0,0,33,213,0,6,2459,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1511,0,0,34,94,0,4,2524,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1538,0,0,35,102,0,4,2545,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1565,0,0,36,102,0,4,2570,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1592,0,0,37,116,0,4,2602,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1619,0,0,38,104,0,4,2625,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1646,0,0,39,155,0,6,2682,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
1669,0,0,40,185,0,6,2740,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1696,0,0,41,158,0,4,2781,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1731,0,0,42,163,0,4,3249,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1766,0,0,43,149,0,4,3267,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1797,0,0,44,237,0,9,3297,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1820,0,0,44,0,0,15,3320,0,0,0,0,0,1,0,
1835,0,0,44,0,0,13,3338,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1870,0,0,45,117,0,4,3365,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1897,0,0,46,168,0,4,3383,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1924,0,0,47,303,0,9,3410,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1951,0,0,47,0,0,13,3434,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1986,0,0,48,217,0,6,3452,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
2013,0,0,49,219,0,6,3461,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
2040,0,0,47,0,0,15,3476,0,0,0,0,0,1,0,
2055,0,0,50,111,0,4,3491,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2082,0,0,51,184,0,4,3530,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
2117,0,0,52,87,0,4,3541,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2144,0,0,53,126,0,4,3550,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2171,0,0,54,227,0,6,3557,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
2198,0,0,55,156,0,4,3568,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2225,0,0,56,229,0,6,3578,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
2252,0,0,57,193,0,4,3600,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
2283,0,0,58,235,0,6,3614,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
2310,0,0,59,212,0,4,3647,0,0,7,5,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,3,0,0,
2353,0,0,60,220,0,4,3678,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,
2396,0,0,61,222,0,4,3692,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,
2439,0,0,62,224,0,4,3706,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,
2482,0,0,63,228,0,4,3721,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,
2525,0,0,64,224,0,4,3735,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,
2568,0,0,65,120,0,6,3751,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2591,0,0,66,136,0,6,3761,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


#include <stdio.h>   
#include <string.h>
/* #include <ot.h> */ 
#include "gl.h"
     
#define NODATAFOUND (sqlca.sqlcode == 1403)  
#define OERROR (sqlca.sqlcode < 0) 
#define ESC 0x1B
 
/* EXEC SQL BEGIN DECLARE SECTION; */ 
    

    /* VARCHAR		nd_operating_facility_id   [3],
	            uid_pwd			           [91],
				d_session_id	[16],
				d_pgm_date		[20],
				rep_date		[20],
				rep_date1		[20],
				//comp_name		[50],  
				comp_name		[100],  
				oper_id			[31],
				d_curr_pgm_name	[25],
				nd_specimen_no	[21],
				d_test_code		[11],
				d_section_code	[2], 
				d_category_yn	[2],
				d_category		[50]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[20]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date1;

struct { unsigned short len; unsigned char arr[100]; } comp_name;

struct { unsigned short len; unsigned char arr[31]; } oper_id;

struct { unsigned short len; unsigned char arr[25]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[21]; } nd_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_section_code;

struct { unsigned short len; unsigned char arr[2]; } d_category_yn;

struct { unsigned short len; unsigned char arr[50]; } d_category;


/* Added by Durai Rajkumar against ML-SD-CRF-20241 */

/* VARCHAR			bi_group_test_code		[11],
				bi_test_code			[11],
				bi_organism_code		[6],
				bi_b_group_test_code	[11],
				bi_b_test_code			[11],
				bi_line_no				[5],
				bi_result_comment_code1	[5],
				bi_result_comment_desc1	[41],
				bi_user_id				[31],
				bi_time_stamp           [18],
				bi_time_stamp1          [18],
				bi_result_text          [4001],
				bi_rt_user_id			[31],
				bi_rt_time_stamp		[18],
				bi_rt_time_stamp1		[18],
				lv_bi_organism_code		[6],
				lv_bi_group_test_code	[11],
				lv_result_text			[4001],
				lv_bi_test_code			[11]; */ 
struct { unsigned short len; unsigned char arr[11]; } bi_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } bi_test_code;

struct { unsigned short len; unsigned char arr[6]; } bi_organism_code;

struct { unsigned short len; unsigned char arr[11]; } bi_b_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } bi_b_test_code;

struct { unsigned short len; unsigned char arr[5]; } bi_line_no;

struct { unsigned short len; unsigned char arr[5]; } bi_result_comment_code1;

struct { unsigned short len; unsigned char arr[41]; } bi_result_comment_desc1;

struct { unsigned short len; unsigned char arr[31]; } bi_user_id;

struct { unsigned short len; unsigned char arr[18]; } bi_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } bi_time_stamp1;

struct { unsigned short len; unsigned char arr[4001]; } bi_result_text;

struct { unsigned short len; unsigned char arr[31]; } bi_rt_user_id;

struct { unsigned short len; unsigned char arr[18]; } bi_rt_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } bi_rt_time_stamp1;

struct { unsigned short len; unsigned char arr[6]; } lv_bi_organism_code;

struct { unsigned short len; unsigned char arr[11]; } lv_bi_group_test_code;

struct { unsigned short len; unsigned char arr[4001]; } lv_result_text;

struct { unsigned short len; unsigned char arr[11]; } lv_bi_test_code;

				
int            line_no;

/* Ends against ML-SD-CRF-20241 */

	/* variables for table rl_sequence_log */
	/* VARCHAR		d_sequence_no			[10],
				d_specimen_no			[21],	
				d_log_table_name		[31],
				d_time_stamp			[18],
				d_time_stamp1			[18], //added for globalisation
				d_user_id				[31],
				nd_last_table_name		[31]; */ 
struct { unsigned short len; unsigned char arr[10]; } d_sequence_no;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } d_log_table_name;

struct { unsigned short len; unsigned char arr[18]; } d_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } d_time_stamp1;

struct { unsigned short len; unsigned char arr[31]; } d_user_id;

struct { unsigned short len; unsigned char arr[31]; } nd_last_table_name;

				

	/* variables for patient informations */
	/* VARCHAR		d_patient_id			[31],
				d_episode_type			[2],
				d_patient_name			[240],
				d_patient_name_1		[240], /o Variable declared to store name after splito/
				d_patient_name_2		[240], /o Variable declared to store name after splito/
				d_patient_name_3		[240],
				d_patient_name_4		[240],
				d_sex					[11],
				d_age					[12],
				d_dob					[12],
				d_dob1					[12]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_1;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_2;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_3;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_4;

struct { unsigned short len; unsigned char arr[11]; } d_sex;

struct { unsigned short len; unsigned char arr[12]; } d_age;

struct { unsigned short len; unsigned char arr[12]; } d_dob;

struct { unsigned short len; unsigned char arr[12]; } d_dob1;
 //added for globalisation
		 		

	/* variables for table rl_request_header_log */				
	/* VARCHAR		rh_source_code			[11],
				rh_consultant_code		[16],
				rh_extra_copies_to		[16],
				rh_urgent_indicator		[10],
				rh_no_of_slides			[3],
				rh_specimen_type_code	[5],
				rh_ref_specimen_no		[21],
				rh_request_comment_desc1 [41],
				rh_request_comment_desc2 [41],
				rh_request_comment_desc3 [41],
				rh_spec_colltd_date_time [18],
				rh_spec_colltd_date_time1 [18], //added for globalisation
				rh_spec_regd_date_time   [18],
				rh_spec_regd_date_time1   [18],//added for globalisation
				rh_spec_recd_date_time   [18],
				rh_spec_recd_date_time1   [18],//added for globalisation
				rh_user					 [31],
				rh_action				 [2],
				rh_time_stamp			 [18],	
				rh_time_stamp1			 [18]; */ 
struct { unsigned short len; unsigned char arr[11]; } rh_source_code;

struct { unsigned short len; unsigned char arr[16]; } rh_consultant_code;

struct { unsigned short len; unsigned char arr[16]; } rh_extra_copies_to;

struct { unsigned short len; unsigned char arr[10]; } rh_urgent_indicator;

struct { unsigned short len; unsigned char arr[3]; } rh_no_of_slides;

struct { unsigned short len; unsigned char arr[5]; } rh_specimen_type_code;

struct { unsigned short len; unsigned char arr[21]; } rh_ref_specimen_no;

struct { unsigned short len; unsigned char arr[41]; } rh_request_comment_desc1;

struct { unsigned short len; unsigned char arr[41]; } rh_request_comment_desc2;

struct { unsigned short len; unsigned char arr[41]; } rh_request_comment_desc3;

struct { unsigned short len; unsigned char arr[18]; } rh_spec_colltd_date_time;

struct { unsigned short len; unsigned char arr[18]; } rh_spec_colltd_date_time1;

struct { unsigned short len; unsigned char arr[18]; } rh_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[18]; } rh_spec_regd_date_time1;

struct { unsigned short len; unsigned char arr[18]; } rh_spec_recd_date_time;

struct { unsigned short len; unsigned char arr[18]; } rh_spec_recd_date_time1;

struct { unsigned short len; unsigned char arr[31]; } rh_user;

struct { unsigned short len; unsigned char arr[2]; } rh_action;

struct { unsigned short len; unsigned char arr[18]; } rh_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } rh_time_stamp1;
// added for globalisation	
				

	/* variables for table rl_request_detail_log */
	/* VARCHAR		rd_test_code			 [11],
				rd_numeric_result		 [16],
				rd_user					 [31], 
				rd_action				 [2],	
				rd_time_stamp			 [18],
				rd_time_stamp1			 [18],// added for globalisation 
				rd_cancel_code           [5],
				rd_cancelled_yn			 [2], 
				rd_cancel_remarks        [200], //SD-CRF-20064  
				rd_cancel_desc           [41]; */ 
struct { unsigned short len; unsigned char arr[11]; } rd_test_code;

struct { unsigned short len; unsigned char arr[16]; } rd_numeric_result;

struct { unsigned short len; unsigned char arr[31]; } rd_user;

struct { unsigned short len; unsigned char arr[2]; } rd_action;

struct { unsigned short len; unsigned char arr[18]; } rd_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } rd_time_stamp1;

struct { unsigned short len; unsigned char arr[5]; } rd_cancel_code;

struct { unsigned short len; unsigned char arr[2]; } rd_cancelled_yn;

struct { unsigned short len; unsigned char arr[200]; } rd_cancel_remarks;

struct { unsigned short len; unsigned char arr[41]; } rd_cancel_desc;

				

	/* variables for table rl_ole_result_text_log */
	/* VARCHAR		ot_group_test_code		 [11],
				ot_test_code			 [11],
				ot_template    		     [16],
				ot_user					 [31], 
				ot_action				 [2],	
				ot_time_stamp			 [18],
				ot_time_stamp1			 [18]; */ 
struct { unsigned short len; unsigned char arr[11]; } ot_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } ot_test_code;

struct { unsigned short len; unsigned char arr[16]; } ot_template;

struct { unsigned short len; unsigned char arr[31]; } ot_user;

struct { unsigned short len; unsigned char arr[2]; } ot_action;

struct { unsigned short len; unsigned char arr[18]; } ot_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } ot_time_stamp1;
// added for globalisation
	
	/*----Added on 12-02-2004------*/
	int			l_ole_log_cnt1 = 0,
			    l_ole_log_cnt2 = 0;
	/*-----------------------------*/


	/* variables for table rl_result_snomed_log */
	/* VARCHAR		rs_group_test_code		 [11], 
				rs_test_code			 [11],	 
				rs_snomed_code			 [21],
				rs_snomed_code2			 [21],
				rs_user					 [31], 
				rs_action				 [2], 
				rs_time_stamp			 [18],
				rs_time_stamp1			 [18]; */ 
struct { unsigned short len; unsigned char arr[11]; } rs_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } rs_test_code;

struct { unsigned short len; unsigned char arr[21]; } rs_snomed_code;

struct { unsigned short len; unsigned char arr[21]; } rs_snomed_code2;

struct { unsigned short len; unsigned char arr[31]; } rs_user;

struct { unsigned short len; unsigned char arr[2]; } rs_action;

struct { unsigned short len; unsigned char arr[18]; } rs_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } rs_time_stamp1;
// added for globalisation
	
	/*----Added on 12-02-2004------*/
	int			l_snomed_log_cnt1 = 0,
			    l_snomed_log_cnt2 = 0;
	/*-----------------------------*/

	/* variables for table rl_test_result_log */
	/* VARCHAR		tr_group_test_code		 [11],	
				tr_test_code			 [11],	
				tr_result				 [16],
				tr_result_desc1			 [41],
				tr_result_desc2			 [41],
				tr_result_desc3			 [41],
				tr_result_desc4			 [41],
				tr_user					 [31],
				tr_action				 [2],
				tr_time_stamp			 [18],
				tr_time_stamp1			 [18]; */ 
struct { unsigned short len; unsigned char arr[11]; } tr_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } tr_test_code;

struct { unsigned short len; unsigned char arr[16]; } tr_result;

struct { unsigned short len; unsigned char arr[41]; } tr_result_desc1;

struct { unsigned short len; unsigned char arr[41]; } tr_result_desc2;

struct { unsigned short len; unsigned char arr[41]; } tr_result_desc3;

struct { unsigned short len; unsigned char arr[41]; } tr_result_desc4;

struct { unsigned short len; unsigned char arr[31]; } tr_user;

struct { unsigned short len; unsigned char arr[2]; } tr_action;

struct { unsigned short len; unsigned char arr[18]; } tr_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } tr_time_stamp1;
// added for globalisation 

	/* variables for table rl_result_organism_log */
	/* VARCHAR		or_group_test_code		 [11], 
				or_test_code			 [11], 
				or_organism_code		 [5],
				or_result_comment_desc	 [41], 
				or_user					 [31], 
				or_action				 [2], 
				or_time_stamp			 [18],
				or_time_stamp1			 [18]; */ 
struct { unsigned short len; unsigned char arr[11]; } or_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } or_test_code;

struct { unsigned short len; unsigned char arr[5]; } or_organism_code;

struct { unsigned short len; unsigned char arr[41]; } or_result_comment_desc;

struct { unsigned short len; unsigned char arr[31]; } or_user;

struct { unsigned short len; unsigned char arr[2]; } or_action;

struct { unsigned short len; unsigned char arr[18]; } or_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } or_time_stamp1;
// added for globalisation

	/*----Added on 12-02-2004------*/
	int			l_org_log_cnt1 = 0,
			    l_org_log_cnt2 = 0;
	/*-----------------------------*/

	/* variables for table rl_result_organism_dtl_log */
	/* VARCHAR		od_group_test_code		 [11], 
				od_test_code			 [11], 
				od_organism_code		 [5], 
				od_antibiotic_group_code [2], 
				od_antibiotic_code		 [5],
				od_sensitivity_ind		 [13],
				od_report_yn			 [2], 
				od_user					 [31], 
				od_action				 [2], 
				od_time_stamp			 [18],
				od_time_stamp1			 [18]; */ 
struct { unsigned short len; unsigned char arr[11]; } od_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } od_test_code;

struct { unsigned short len; unsigned char arr[5]; } od_organism_code;

struct { unsigned short len; unsigned char arr[2]; } od_antibiotic_group_code;

struct { unsigned short len; unsigned char arr[5]; } od_antibiotic_code;

struct { unsigned short len; unsigned char arr[13]; } od_sensitivity_ind;

struct { unsigned short len; unsigned char arr[2]; } od_report_yn;

struct { unsigned short len; unsigned char arr[31]; } od_user;

struct { unsigned short len; unsigned char arr[2]; } od_action;

struct { unsigned short len; unsigned char arr[18]; } od_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } od_time_stamp1;
// added for globalisation 

	/*-----Added on 12-02-2004-------*/
	int			l_org_dtl_log_cnt1 = 0,
				l_org_dtl_log_cnt2 = 0;
	/*-------------------------------*/

	/* variables for table rl_result_text_log */
	/* VARCHAR		rt_group_test_code		 [11], 
				rt_test_code			 [11], 
				rt_result_text			 [4001],
				rt_user					 [31], 
				rt_action				 [2], 
				rt_time_stamp			 [18],
				rt_time_stamp1			 [18]; */ 
struct { unsigned short len; unsigned char arr[11]; } rt_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } rt_test_code;

struct { unsigned short len; unsigned char arr[4001]; } rt_result_text;

struct { unsigned short len; unsigned char arr[31]; } rt_user;

struct { unsigned short len; unsigned char arr[2]; } rt_action;

struct { unsigned short len; unsigned char arr[18]; } rt_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } rt_time_stamp1;
// added for globalisation sunil	
	
	/*----Added on 12-02-2004------*/
	int			l_text_log_cnt1 = 0,
				l_text_log_cnt2 = 0;
	/*-----------------------------*/

	/* variables for code description */
	/* VARCHAR		nd_test_desc			 [41],
				nd_group_desc			 [41],
				nd_spec_desc			 [41],
				nd_snomed_desc			 [41],
				nd_snomed_desc2			 [41],

				nd_group_code			 [11],
				nd_test_code			 [11],
				nd_spec_code			 [5],
   			    nd_snomed_code			 [21],
   			    nd_snomed_code2			 [21]; */ 
struct { unsigned short len; unsigned char arr[41]; } nd_test_desc;

struct { unsigned short len; unsigned char arr[41]; } nd_group_desc;

struct { unsigned short len; unsigned char arr[41]; } nd_spec_desc;

struct { unsigned short len; unsigned char arr[41]; } nd_snomed_desc;

struct { unsigned short len; unsigned char arr[41]; } nd_snomed_desc2;

struct { unsigned short len; unsigned char arr[11]; } nd_group_code;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code;

struct { unsigned short len; unsigned char arr[5]; } nd_spec_code;

struct { unsigned short len; unsigned char arr[21]; } nd_snomed_code;

struct { unsigned short len; unsigned char arr[21]; } nd_snomed_code2;

/*  variables for clinical history */
    /* VARCHAR     ch_clinical_text_code    [6],
				ch_clinical_text         [4001],
				ch_user					 [31], 
				ch_action				 [2], 
				ch_time_stamp			 [18],
				ch_time_stamp1			 [18]; */ 
struct { unsigned short len; unsigned char arr[6]; } ch_clinical_text_code;

struct { unsigned short len; unsigned char arr[4001]; } ch_clinical_text;

struct { unsigned short len; unsigned char arr[31]; } ch_user;

struct { unsigned short len; unsigned char arr[2]; } ch_action;

struct { unsigned short len; unsigned char arr[18]; } ch_time_stamp;

struct { unsigned short len; unsigned char arr[18]; } ch_time_stamp1;


/*  variables for CA REVIEW DONE LOG*/
	/* VARCHAR		ca_test_code			[11],
				ca_created_date			[21],
				ca_created_date1		[21],//added for globalisation
				ca_review_done_by		[31],
				ca_reviewed_date		[21],
				ca_reviewed_date1		[21],
				ca_review_type			[5] ,
				am_practitioner_name    [31]; */ 
struct { unsigned short len; unsigned char arr[11]; } ca_test_code;

struct { unsigned short len; unsigned char arr[21]; } ca_created_date;

struct { unsigned short len; unsigned char arr[21]; } ca_created_date1;

struct { unsigned short len; unsigned char arr[31]; } ca_review_done_by;

struct { unsigned short len; unsigned char arr[21]; } ca_reviewed_date;

struct { unsigned short len; unsigned char arr[21]; } ca_reviewed_date1;

struct { unsigned short len; unsigned char arr[5]; } ca_review_type;

struct { unsigned short len; unsigned char arr[31]; } am_practitioner_name;

  
		float 	d_months = 0;
		long	d_yrs1   = 0,
				d_mths1  = 0,
				d_mths2  = 0,
				d_days1  = 0;

	      int l_count = 0;
		  int l_len = 30; /* To split the patient Name as per the length */

/* Variables for OR_ORDER_LINE_LB*/
	/* VARCHAR		ol_order_id				[20],
				ol_order_type_code		[4],
				ol_spec_regd_by			[32],
				ol_spec_disp_by			[32],
				ol_spec_disp_date_time  [18],
				ol_spec_disp_date_time1 [18], //added for globalisation
				ol_spec_regd_date_time	[18]; */ 
struct { unsigned short len; unsigned char arr[20]; } ol_order_id;

struct { unsigned short len; unsigned char arr[4]; } ol_order_type_code;

struct { unsigned short len; unsigned char arr[32]; } ol_spec_regd_by;

struct { unsigned short len; unsigned char arr[32]; } ol_spec_disp_by;

struct { unsigned short len; unsigned char arr[18]; } ol_spec_disp_date_time;

struct { unsigned short len; unsigned char arr[18]; } ol_spec_disp_date_time1;

struct { unsigned short len; unsigned char arr[18]; } ol_spec_regd_date_time;
 /* Added by Durai Rajkumar for age calculation on 04/02/08 */

    /* VARCHAR		 ol_order_regd_by		 [32],
				 ol_order_date_time      [18],
				 ol_order_date_time1      [18], //added for globalisation
				 ol_order_start_date	 [18],
				 ol_order_start_date1	 [18]; */ 
struct { unsigned short len; unsigned char arr[32]; } ol_order_regd_by;

struct { unsigned short len; unsigned char arr[18]; } ol_order_date_time;

struct { unsigned short len; unsigned char arr[18]; } ol_order_date_time1;

struct { unsigned short len; unsigned char arr[18]; } ol_order_start_date;

struct { unsigned short len; unsigned char arr[18]; } ol_order_start_date1;
 //added for globalisation

	
	short   ol_order_id_ind;	

/* variable for RL_TEST_RESULT_LOG*/
   int 			tr_modify_log_seq_no;
   short		tr_modify_log_seq_no_ind;	

/* variable for RL_RESULT_MODIFY_REASON*/
   /* VARCHAR		rm_remark_code			[5]	,
				rm_remark_text		   [42] ,
				rm_group_test_code     [11] ,
				rm_test_code		   [11] ; */ 
struct { unsigned short len; unsigned char arr[5]; } rm_remark_code;

struct { unsigned short len; unsigned char arr[42]; } rm_remark_text;

struct { unsigned short len; unsigned char arr[11]; } rm_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } rm_test_code;

  

	/* VARCHAR		rm_clinical_text_action[10]; */ 
struct { unsigned short len; unsigned char arr[10]; } rm_clinical_text_action;


		/***************added for globalisation*************************/
	/* VARCHAR		l_translated_value		 [700],
				language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[700]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;


	int i;
		/***************added for globalisation*************************/


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

//EXEC ORACLE OPTION(HOLD_CURSOR = YES);
//EXEC ORACLE OPTION(REBIND = NO);

char l_delimeter = ' ';

#define REP_WIDTH 127
#define VER  "VER : 1.10.01\n"
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1],
	 hdr_line6[REP_WIDTH+1],
	 hdr_line7[REP_WIDTH+1];

//char rep_title1[] = "WHO DONE IT ?";
char rep_title1[200];
char rep_title2[200];
char ca_str[500];
char ca_str1[500];


FILE *f1;

char string_var[500] ;

char local_legend[70][600];//added for globalisation


int i, 
    nol = 1,
	page_no,
    line_no,
	chk_prn,
	reslt_occ = 1;
	form_hdr_rqd,
	prn_title = 1,
    g_print_room,
    g_print_group,
	print_rec = 0;

int ctr = 0,  len = 0;
int r_ctr = 0;
char l_string[300];

char d_pat_age [25];
char filename[150];
char first_time1 = 'Y'; 
char not_printed = 'N';
char hdr_printed = 'N';

char ca_prev_review_by[40];
char ca_prev_review_date[30];

char clinical_prev_time_stamp[30];
char clinical_prev_user_id[40];
char clinical_prev_action[10];
 
void proc_main(argc,argv)
int argc;
char *argv[];
{
	if(argc < 3) {
        disp_message(ERR_MESG,"RLRWHODT : Usage RLRWHODT userid/password specimen_no [test_code]\n");
        proc_exit();
    } 
  
    strcpy(g_pgm_id,"RLRWHODT");

    strcpy(d_curr_pgm_name.arr,g_pgm_id);
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr);  

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

	strcpy(nd_operating_facility_id.arr, argv[4]);
	nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

	strcpy(OUTPUT_FILE_NAME, argv[5]);

	strcpy(nd_specimen_no.arr,argv[6]);
    nd_specimen_no.len = strlen(nd_specimen_no.arr);
    
	if ( argc == 8 )
	{
	   strcpy(d_test_code.arr, argv[7]);
	   d_test_code.len  = strlen(d_test_code.arr);

	}
	else
	{
	   d_test_code.arr[0] = '\0';
	   d_test_code.len    = 0;	
	}

	 
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
        // printf("%s\n",sqlca.sqlerrm.sqlerrmc);
        proc_exit();
     } 

	set_meduser_role();

/*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';

	get_legend_value(68);

/*********************** added for globalisation ******************************/


    /*  // printf("%s (1.10.01) : Program started.\n\n",g_pgm_id); */

    fetch_sys_info();
	
    strcpy(filename,WORKING_DIR);
    //strcat(filename,"Rlrwhodt.lis");
	strcat(filename,OUTPUT_FILE_NAME);

      
    if( (f1=fopen(filename,"w")) == NULL) 
	{
        disp_message(ERR_MESG,"Errors in opening output file...\n"); 
		proc_exit();
    }  
	else
	{
	     fprintf(f1,"%c&|26A",ESC);
		 fprintf(f1,"%c&a90P",ESC);
	     fprintf(f1,"%c&|1O",ESC);
	     fprintf(f1,"%c&k4S",ESC);
	}

	decl_curs();

    page_no=1;
    line_no=1;

    do_report();
	/* Added by Durai Rajkumar against ML-SD-CRF-20241 */
	do_bio_chemical_results(); 
	fprintf(f1,"\n");
	print_space(REP_WIDTH/2, (strlen(local_legend[68])/2)+3,1);
	fprintf(f1,"** %s **",local_legend[68]);
	/* Ends against ML-SD-CRF-20241 */
    fprintf(f1,"%c&|3O",ESC);
	    
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



    return;

}

decl_curs()
{
   /* DECLARE CURSOR FOR RL_SPECIMEN_LOG */
  
  
   /* EXEC SQL DECLARE SEQ_CURSOR CURSOR FOR
			 SELECT sequence_no, 
					specimen_no, 
					ltrim(rtrim(upper(log_table_name))),
					to_char(time_stamp,'dd/mm/yy hh24:mi'),
					user_id
			   FROM rl_specimen_log
			  WHERE SPECIMEN_NO = TO_NUMBER(:nd_specimen_no)
			  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			  ORDER BY sequence_no; */ 


/* Added by Durai Rajkumar against ML-SD-CRF-20241 */
  
  /* EXEC SQL DECLARE RESULT_ORGANISM CURSOR FOR
		SELECT 
		GROUP_TEST_CODE,TEST_CODE,ORGANISM_CODE,B_GROUP_TEST_CODE,B_TEST_CODE,LINE_NO,
		RESULT_COMMENT_CODE1,RESULT_COMMENT_DESC1,MODIFIED_BY_ID,
		TO_CHAR(MODIFIED_DATE,'DD/MM/YY HH24:MI') MODIFIED_DATE
		FROM RL_RESULT_ORGANISM_TESTS_DTL
		WHERE SPECIMEN_NO = TO_NUMBER(:nd_specimen_no)
		AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 


/* EXEC SQL DECLARE RESULT_TEXT CURSOR FOR
SELECT 
RESULT_TEXT,MODIFIED_BY_ID,
TO_CHAR(MODIFIED_DATE,'DD/MM/YY HH24:MI') MODIFIED_DATE
FROM RL_ORGANISM_TESTS_RESULT_TEXT
WHERE 	SPECIMEN_NO = TO_NUMBER(:nd_specimen_no)
AND OPERATING_FACILITY_ID = :nd_operating_facility_id  
AND GROUP_TEST_CODE =  :bi_group_test_code
AND  TEST_CODE = :bi_test_code
AND  ORGANISM_CODE = :bi_organism_code
AND B_GROUP_TEST_CODE =  :bi_b_group_test_code
AND  B_TEST_CODE = :bi_b_test_code; */ 



/* Ends against ML-SD-CRF-20241 */

}

fetch_seq_cur()
{
  d_sequence_no.arr[0]		= '\0';
  d_specimen_no.arr[0]		= '\0';
  d_log_table_name.arr[0]	= '\0';
  d_time_stamp.arr[0]		= '\0';
  d_user_id.arr[0]			= '\0';

  d_sequence_no.len			= 0;
  d_specimen_no.len			= 0;
  d_log_table_name.len		= 0;
  d_time_stamp.len			= 0;
  d_user_id.len				= 0;

  /* EXEC SQL FETCH SEQ_CURSOR INTO :d_sequence_no, 
								 :d_specimen_no,
								 :d_log_table_name,
								 :d_time_stamp,
								 :d_user_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )51;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_sequence_no;
  sqlstm.sqhstl[0] = (unsigned int  )12;
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
  sqlstm.sqhstv[2] = (         void  *)&d_log_table_name;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_time_stamp;
  sqlstm.sqhstl[3] = (unsigned int  )20;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_user_id;
  sqlstm.sqhstl[4] = (unsigned int  )33;
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
    	return 0; 
    			
  if (NODATAFOUND)
       return 0;

  d_sequence_no.arr[d_sequence_no.len] = '\0';
  d_specimen_no.arr[d_specimen_no.len] = '\0';
  d_log_table_name.arr[d_log_table_name.len] = '\0';
  d_time_stamp.arr[d_time_stamp.len]		 = '\0';
  d_user_id.arr[d_user_id.len]				 = '\0';
 
  return 1;
}

/* Added by Durai Rajkumar against ML-SD-CRF-20241 */

fetch_result_organism_cur()
{

	bi_group_test_code.arr[0]		= '\0';
	bi_test_code.arr[0]		= '\0';
	bi_organism_code.arr[0]		= '\0';
	bi_b_group_test_code.arr[0]	= '\0';
	bi_b_test_code.arr[0]		= '\0';
	bi_line_no.arr[0]           = '\0';   
	bi_result_comment_code1.arr[0]	= '\0';
	bi_result_comment_desc1.arr[0]	= '\0';
	bi_user_id.arr[0]               ='\0';
	bi_time_stamp.arr[0]            ='\0';
	bi_time_stamp1.arr[0]           ='\0'; 
	
	bi_group_test_code.len		= '\0';
	bi_test_code.len		    = '\0';
	bi_organism_code.len	    = '\0';
	bi_b_group_test_code.len	= '\0';
	bi_b_test_code.len		    = '\0';
	bi_line_no.len              = '\0';
	bi_result_comment_code1.len	= '\0';
	bi_result_comment_desc1.len = '\0';
	bi_user_id.len              = '\0';
	bi_time_stamp.len           = '\0';
	bi_time_stamp1.len          = '\0'; 
		

  /* EXEC SQL FETCH RESULT_ORGANISM INTO :bi_group_test_code,
								 :bi_test_code,
								 :bi_organism_code,
								 :bi_b_group_test_code,
								 :bi_b_test_code,
								 :bi_line_no,
								 :bi_result_comment_code1,
								 :bi_result_comment_desc1,
								 :bi_user_id,
								 :bi_time_stamp; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )86;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&bi_group_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bi_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bi_organism_code;
  sqlstm.sqhstl[2] = (unsigned int  )8;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bi_b_group_test_code;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&bi_b_test_code;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&bi_line_no;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&bi_result_comment_code1;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&bi_result_comment_desc1;
  sqlstm.sqhstl[7] = (unsigned int  )43;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&bi_user_id;
  sqlstm.sqhstl[8] = (unsigned int  )33;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&bi_time_stamp;
  sqlstm.sqhstl[9] = (unsigned int  )20;
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


							
  if(OERROR)	    
    	return 0; 
    			
  if (NODATAFOUND)
	   return 0;

    bi_group_test_code.arr[bi_group_test_code.len]		= '\0';
	bi_test_code.arr[bi_test_code.len]		    = '\0';
	bi_organism_code.arr[bi_organism_code.len]		= '\0';
	bi_b_group_test_code.arr[bi_b_group_test_code.len]	= '\0';
	bi_b_test_code.arr[bi_b_test_code.len]		    = '\0';
	bi_line_no.arr[bi_line_no.len] ='\0';
	bi_result_comment_code1.arr[bi_result_comment_code1.len]	= '\0';
  	bi_result_comment_desc1.arr[bi_result_comment_desc1.len]	= '\0';
    bi_user_id.arr[bi_user_id.len] = '\0';
	bi_time_stamp.arr[bi_time_stamp.len] = '\0';

	/* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:bi_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
			:bi_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
		END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :bi_time_stamp , 'DD/MM/YY HH24:MI' ) , :language_id , t_\
date ) ; :bi_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )141;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bi_time_stamp;
 sqlstm.sqhstl[0] = (unsigned int  )20;
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
 sqlstm.sqhstv[2] = (         void  *)&bi_time_stamp1;
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


	bi_time_stamp1.arr[bi_time_stamp1.len] = '\0';
  
  return 1;
}

fetch_result_text_cur()
{

	bi_result_text.arr[0]		= '\0';
	bi_result_text.len			= '\0';
	bi_rt_user_id.arr[0]        = '\0';
	bi_rt_user_id.len		    = '\0';
	bi_rt_time_stamp.arr[0]     = '\0';
	bi_rt_time_stamp1.arr[0]    = '\0'; 
	bi_rt_time_stamp.len	    = '\0';
	bi_rt_time_stamp1.len	    = '\0'; 
  /* EXEC SQL FETCH RESULT_TEXT INTO :bi_result_text,:bi_rt_user_id,bi_rt_time_stamp; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )168;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&bi_result_text;
  sqlstm.sqhstl[0] = (unsigned int  )4003;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bi_rt_user_id;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bi_rt_time_stamp;
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


							
  if(OERROR)	    
    	return 0; 
    			
  if (NODATAFOUND)
	   return 0;

    bi_result_text.arr[bi_result_text.len]		= '\0';
	bi_rt_user_id.arr[bi_rt_user_id.len]		= '\0';
	bi_rt_time_stamp.arr[bi_rt_time_stamp.len]	= '\0';

	/* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:bi_rt_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
			:bi_rt_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
		END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :bi_rt_time_stamp , 'DD/MM/YY HH24:MI' ) , :language_id ,\
 t_date ) ; :bi_rt_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' ) ; EN\
D ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )195;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bi_rt_time_stamp;
 sqlstm.sqhstl[0] = (unsigned int  )20;
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
 sqlstm.sqhstv[2] = (         void  *)&bi_rt_time_stamp1;
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


	bi_rt_time_stamp1.arr[bi_rt_time_stamp1.len]	= '\0';
	
  return 1;
}
/* Ends against ML-SD-CRF-20241 */

do_report()
{
	int first = 1; 
    int fetch_val = 0;
    char temp_table_name [31];
	
	form_hdr_rqd = 1;

	strcpy(nd_last_table_name.arr, "RL_REQUEST_HEADER_LOG");
	nd_last_table_name.len    = strlen(nd_last_table_name.arr);

    /* EXEC SQL OPEN SEQ_CURSOR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0003;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )222;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_specimen_no;
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
	err_mesg("OPEN failed on cursor SEQ_CURSOR",0,"");
   
    fetch_val = fetch_seq_cur();
    strcpy(temp_table_name, d_log_table_name.arr);

	strcpy(ca_prev_review_by, " ");
	strcpy(ca_prev_review_date, " ");	
	strcpy(clinical_prev_time_stamp, " ");
	strcpy(clinical_prev_user_id, " ");
	strcpy(clinical_prev_action, " ");

   	while(fetch_val)
	{	
		if (form_hdr_rqd)
		{
			form_hdr();	
			form_hdr_rqd = 0;
		}
        while(fetch_val && ( strcmp(temp_table_name, d_log_table_name.arr) == 0 ))
		{
		    do_check_table();
			fetch_val = fetch_seq_cur();
		}
		strcpy(temp_table_name, d_log_table_name.arr);
		if (first)
			chk_break(line_no);	
		else
		{	
			fprintf(f1, "\n");
			line_no++;
			chk_break(line_no);		
		}
	}

   first = 0;   

	/* EXEC SQL CLOSE seq_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )245;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/* Added by Durai Rajkumar against ML-SD-CRF-20241 */
do_bio_chemical_results()
{
	int fetch_bi_val;
	int bio_chem_rep_hdr =1;

		
 /* EXEC SQL OPEN result_organism; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0004;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )260;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_specimen_no;
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
	err_mesg("OPEN failed on cursor RESULT_ORGANISM",0,"");
    

	fetch_bi_val = fetch_result_organism_cur();


	while (fetch_bi_val)		
		
		{
			if (bio_chem_rep_hdr) 
			{
				print_bio_chem_header();
				bio_chem_rep_hdr = 0;
			}
			
			if (strcmp(lv_bi_group_test_code.arr,bi_group_test_code.arr) != 0)
			{
				print_bi_oragnism_header();
			}
			
			else if (strcmp(lv_bi_organism_code.arr,bi_organism_code.arr) != 0)		
				
			  {
				
				print_bi_oragnism_header();
			  }
			
			print_bi_oraganism_dtl();
			print_result_text();

			fetch_bi_val = fetch_result_organism_cur();
		
		}


}

print_bio_chem_header()
{

	//fprintf(f1,"Bio-Chemical Test Results:\n"); 
	fprintf(f1, "%s \n", local_legend[65]); 
	line_no++;
	chk_break(line_no);



}

print_bi_oragnism_header()
{

lv_bi_organism_code.arr[0]		= '\0';
lv_bi_organism_code.len		= '\0';
lv_bi_group_test_code.arr[0]		= '\0';
lv_bi_group_test_code.len		= '\0';
lv_bi_test_code.arr[0]		= '\0';
lv_bi_test_code.len		= '\0';
//fprintf(f1, "  GROUP : %-11.11s  TEST : %-11.11s  ORG : %-5.5s\n",bi_group_test_code.arr,bi_test_code.arr,bi_organism_code.arr); 
fprintf(f1, "%-6.6s: %-11.11s  %-5.5s: %-11.11s  %-4.4s: %-5.5s\n",
			local_legend[23], bi_group_test_code.arr, local_legend[21], bi_test_code.arr, local_legend[26], bi_organism_code.arr); 
line_no++;
chk_break(line_no);
strcpy(lv_bi_organism_code.arr,bi_organism_code.arr);
strcpy(lv_bi_group_test_code.arr,bi_group_test_code.arr);
strcpy(lv_bi_test_code.arr,bi_test_code.arr);
//bi_organism_code_code.arr[bi_organism_code.len]		= '\0';
//bi_group_test_code.arr[bi_group_test_code.len]		= '\0';
//bi_test_code.arr[bi_test_code.len]		= '\0';

}
print_bi_oraganism_dtl()
{
	//fprintf(f1, "    %-14.14s/%-10.10s  ",bi_time_stamp.arr, bi_user_id.arr); 
	fprintf(f1, "    %-14.14s/%-10.10s  ",bi_time_stamp1.arr, bi_user_id.arr);  
	//fprintf(f1, "Biochem.Group : %-11.11s   Biochem.Test : %-11.11s   RESULT : %-40.40s\n",bi_b_group_test_code.arr,bi_b_test_code.arr,bi_result_comment_desc1.arr); 
	fprintf(f1, "%-15.15s: %-11.11s  %-14.14s: %-11.11s  %-7.7s: %-40.40s\n",
				local_legend[66], bi_b_group_test_code.arr, local_legend[67], bi_b_test_code.arr, local_legend[25], bi_result_comment_desc1.arr); 
	line_no++;
	chk_break(line_no);
	
}
print_result_text()
{
int fetch_bi_res_text;
 /* EXEC SQL OPEN result_text; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )283;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_specimen_no;
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
 sqlstm.sqhstv[2] = (         void  *)&bi_group_test_code;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bi_test_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bi_organism_code;
 sqlstm.sqhstl[4] = (unsigned int  )8;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bi_b_group_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&bi_b_test_code;
 sqlstm.sqhstl[6] = (unsigned int  )13;
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


	if(OERROR)
	err_mesg("OPEN failed on cursor RESULT_TEXT",0,"");
	fetch_bi_res_text = fetch_result_text_cur();
	while(fetch_bi_res_text)
	{
	//fprintf(f1,"%-40.40s\n",bi_result_text.arr);
	//fprintf(f1, "    %-14.14s/%-10.10s  ",bi_rt_time_stamp.arr, bi_rt_user_id.arr); 
	fprintf(f1, "    %-14.14s/%-10.10s  ",bi_rt_time_stamp1.arr, bi_rt_user_id.arr);  
	//fprintf(f1, "Biochem.Group : %-11.11s   Biochem.Test : %-11.11s   RESULT TEXT :\n",bi_b_group_test_code.arr,bi_b_test_code.arr);		
	fprintf(f1, "%-15.15s: %-11.11s  %-14.14s: %-11.11s  %-12.12s:\n",
				local_legend[66], bi_b_group_test_code.arr, local_legend[67], bi_b_test_code.arr, local_legend[30]); 
	line_no++;
	chk_break(line_no);
	splitting(bi_result_text.arr);
		fetch_bi_res_text = fetch_result_text_cur();
	}
/* EXEC SQL CLOSE result_text; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 10;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )326;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/* Ends against ML-SD-CRF-20241 */

do_check_table()
{
	print_rec = 0;

	
	
    if (strcmp(d_log_table_name.arr, "RL_REQUEST_HEADER_LOG") == 0)
	{
		do_request_header();

		if (prn_title)
		{
			do_specimen_report();
			prn_title = 0;
		}

		do_report_request_header();
		hdr_printed = 'Y';

	}

	if (strcmp(d_log_table_name.arr, "RL_REQUEST_DETAIL_LOG") == 0)
	{
		do_request_detail();
		if ( print_rec > 0 ) 
		   do_report_request_detail();
	}

	if ((first_time1 == 'Y') && (not_printed == 'N') && (hdr_printed == 'Y'))
	{	
		do_clinic_hist();
		first_time1 = 'N';
		not_printed = 'Y';
	}

	if (strcmp(d_log_table_name.arr, "RL_REQUEST_DETAIL_LOG") == 0)
	{
		do_request_detail_cancel();
		if ( print_rec > 0 ) 
		   do_report_request_detail_cancel();
		

	}

	if (strcmp(d_log_table_name.arr, "RL_RESULT_TEXT_LOG") == 0)
	{
		do_result_text();
		if ( print_rec > 0 )
		{
		   do_report_result_text();
		}

		/*--------Added on 12-2-2004----------*/
		if(l_text_log_cnt1 == l_text_log_cnt2) 
		{
			do_modify_log(rt_group_test_code.arr,rt_test_code.arr); 
			l_text_log_cnt1 = 0;
			l_text_log_cnt2 = 0;
		}
		/*------------------------------------*/

	}
	
	if (strcmp(d_log_table_name.arr, "RL_RESULT_SNOMED_LOG") == 0)
	{
		do_result_snomed();
		if ((strlen(rs_snomed_code.arr) > 0) || (strlen(rs_snomed_code2.arr) > 0))
		{
			if ( print_rec > 0 )			
				{
					do_report_result_snomed();
				}
				
				/*--------Added on 12-2-2004----------*/
				if(l_snomed_log_cnt1 == l_snomed_log_cnt2) 
				{
					do_modify_log(rs_group_test_code.arr,rs_test_code.arr); 
					l_snomed_log_cnt1 = 0;
					l_snomed_log_cnt2 = 0;
				}
				/*------------------------------------*/
		}
	}
	
	if (strcmp(d_log_table_name.arr, "RL_RESULT_ORGANISM_LOG") == 0)
	{
		do_result_organism();
		if ( print_rec > 0 )
		{
			do_report_organism();
		}
		/*--------Added on 12-2-2004----------*/
		if(l_org_log_cnt1 == l_org_log_cnt2) 
		{
			do_modify_log(or_group_test_code.arr,or_test_code.arr); 
			l_org_log_cnt1 = 0;
			l_org_log_cnt2 = 0;
		}
		/*------------------------------------*/
	}
		 
	if (strcmp(d_log_table_name.arr, "RL_RESULT_ORGANISM_DTL_LOG") == 0)
	{
		do_result_organism_dtl();
		if ( print_rec > 0 )
		{
			do_report_organism_dtl();
		}
		/*--------Added on 12-2-2004----------*/
		if(l_org_dtl_log_cnt1 == l_org_dtl_log_cnt2) 
		{
			do_modify_log(od_group_test_code.arr,od_test_code.arr); 
			l_org_dtl_log_cnt1 = 0;
			l_org_dtl_log_cnt2 = 0;
		}
		/*------------------------------------*/

	}
	
	if (strcmp(d_log_table_name.arr, "RL_TEST_RESULT_LOG") == 0)
	{
		do_test_result(); 
		
		if ( print_rec > 0 )
		{
			if ( reslt_occ == 1 )  		
			{
		 		//fprintf(f1, "RESULTING \n");
		 		fprintf(f1, "%s\n", local_legend[1]); // added for globalisation
				reslt_occ++;
				line_no++;         //ML-SD-SCF-1851
			    chk_break(line_no);//ML-SD-SCF-1851		
			} 
		
			//line_no++; ML-SD-SCF-1851
			//chk_break(line_no);ML-SD-SCF-1851		

			do_report_test_result();
		}
	}

	if (strcmp(d_log_table_name.arr, "RL_OLE_RESULT_TEXT_LOG") == 0)
	{
		do_ole_result();
		if ( print_rec > 0 ) 
		{
		   do_report_ole_result();
		}
		/*--------Added on 12-2-2004----------*/
		if(l_ole_log_cnt1 == l_ole_log_cnt2) 
		{
			do_modify_log(ot_group_test_code.arr,ot_test_code.arr); 
			l_ole_log_cnt1 = 0;
			l_ole_log_cnt2 = 0;
		}
		/*------------------------------------*/

	}

	if ( strcmp(d_log_table_name.arr, "RL_TECHNICIAN_REVIEW") == 0 )
	{
		do_review_technical();
	}
	if ( strcmp(d_log_table_name.arr, "RL_ABNORMAL_REVIEW") == 0)
	{
		do_review_abnormal();
	}

	if ( strcmp(d_log_table_name.arr, "RL_NORMAL_REVIEW") == 0)	
	{
		do_review_normal();
	}

/**** TO INCLUDE THE  CA RESULT REVIEW DONE LOG IN THE WHODUNIT REPORT *****/
/**** ADDED ON 29/10/2003  *************/
	if ( strcmp(d_log_table_name.arr, "CA_RESULT_REVIEW_DONE_LOG") == 0)	
	{

	

		decl_ca_review_details();
		while(fetch_ca_review_details())
		{

		//sprintf(string_var, " %s    %s  prev %s  %s ", ca_review_done_by.arr, ca_reviewed_date.arr,
		//					ca_prev_review_by, ca_prev_review_date);
		//disp_message(ERR_MESG, string_var);

			get_practitioner_name();
			if (strcmp(ca_review_done_by.arr, ca_prev_review_by) == 0 &&
				strcmp(ca_reviewed_date.arr, ca_prev_review_date) == 0)
			{
				do_ca_review_log_same_doctor();
			}
			else
			{
		
				strcpy(ca_prev_review_by, ca_review_done_by.arr);
				strcpy(ca_prev_review_date, ca_reviewed_date.arr);
				do_ca_review_log();
			}
		}
		close_ca_review_details();
	}

}


do_request_header()
{
	rh_source_code.arr[0]			= '\0'; 
	rh_consultant_code.arr[0]		= '\0'; 
	rh_extra_copies_to.arr[0]		= '\0'; 
	rh_urgent_indicator.arr[0]		= '\0';  
	rh_no_of_slides.arr[0]			= '\0';  
	rh_specimen_type_code.arr[0]	= '\0'; 
	rh_ref_specimen_no.arr[0]		= '\0'; 
	rh_request_comment_desc1.arr[0] = '\0';  
	rh_request_comment_desc2.arr[0] = '\0'; 
	rh_request_comment_desc3.arr[0] = '\0';  
	rh_spec_colltd_date_time.arr[0] = '\0'; 
    rh_spec_regd_date_time.arr[0]	= '\0';  
	rh_spec_recd_date_time.arr[0]	= '\0';  
	rd_user.arr[0]					= '\0';
	rh_action.arr[0]				= '\0'; 
	rh_time_stamp.arr[0]			= '\0'; 
	d_patient_id.arr[0]				= '\0';
	d_episode_type.arr[0]			= '\0';
	d_section_code.arr[0]			= '\0';

	rh_source_code.len				= 0; 
	rh_consultant_code.len			= 0; 
	rh_extra_copies_to.len			= 0; 
	rh_urgent_indicator.len			= 0;  
	rh_no_of_slides.len				= 0;  
	rh_specimen_type_code.len		= 0; 
	rh_ref_specimen_no.len			= 0; 
	rh_request_comment_desc1.len	= 0;  
	rh_request_comment_desc2.len	= 0; 
	rh_request_comment_desc3.len	= 0;  
	rh_spec_colltd_date_time.len	= 0; 
    rh_spec_regd_date_time.len		= 0;  
	rh_spec_recd_date_time.len		= 0; 
	rh_user.len						= 0; 
	rh_action.len					= 0;	
	rh_time_stamp.len				= 0; 
	d_patient_id.len				= 0;
	d_episode_type.len				= 0;
	d_section_code.len				= 0;

	get_order_id(); /* added by amjad on 28/12/2005 to get order details */

//DECODE(URGENT_INDICATOR,'R','Routine','U','Urgent','S','Stat',URGENT_INDICATOR),

	/* EXEC SQL
    SELECT SOURCE_CODE, 
		   CONSULTANT_CODE, 
		   EXTRA_COPIES_TO, 
		   URGENT_INDICATOR, 
		   NO_OF_SLIDES,
		   SPECIMEN_TYPE_CODE, 
		   REF_SPECIMEN_NO,
		   REQUEST_COMMENT_DESC1, 
		   REQUEST_COMMENT_DESC2,
		   REQUEST_COMMENT_DESC3,
  		   TO_CHAR(SPEC_COLLTD_DATE_TIME, 'DD/MM/YYYY HH24:MI'),
		   TO_CHAR(SPEC_REGD_DATE_TIME,   'DD/MM/YYYY HH24:MI'),
		   TO_CHAR(SPEC_RECD_DATE_TIME,   'DD/MM/YYYY HH24:MI'),
		   SUBSTR(MODIFIED_BY_ID,1,10)"USER",
		   ACTION, 
		   TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",
		   PATIENT_ID,
		   EPISODE_TYPE,
		   section_code
	  INTO :rh_source_code,
		   :rh_consultant_code, 
		   :rh_extra_copies_to,
		   :rh_urgent_indicator,
		   :rh_no_of_slides, 
		   :rh_specimen_type_code,
		   :rh_ref_specimen_no, 
		   :rh_request_comment_desc1, 
		   :rh_request_comment_desc2,
		   :rh_request_comment_desc3, 
		   :rh_spec_colltd_date_time,
		   :rh_spec_regd_date_time,
		   :rh_spec_recd_date_time, 
		   :rh_user,
		   :rh_action,
		   :rh_time_stamp,
		   :d_patient_id,
		   :d_episode_type,
		   :d_section_code
	  FROM RL_REQUEST_HEADER_LOG
	 WHERE SPECIMEN_NO =  TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SOURCE_CODE ,CONSULTANT_CODE ,EXTRA_COPIES_TO ,URGENT\
_INDICATOR ,NO_OF_SLIDES ,SPECIMEN_TYPE_CODE ,REF_SPECIMEN_NO ,REQUEST_COMMENT\
_DESC1 ,REQUEST_COMMENT_DESC2 ,REQUEST_COMMENT_DESC3 ,TO_CHAR(SPEC_COLLTD_DATE\
_TIME,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI')\
 ,TO_CHAR(SPEC_RECD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,SUBSTR(MODIFIED_BY_ID,1,1\
0) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'DD/MM/YY HH24:MI') \"TIME_STAMP\" ,PA\
TIENT_ID ,EPISODE_TYPE ,section_code into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,\
:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18  from RL_REQUEST_HEADER_LOG w\
here ((SPECIMEN_NO=TO_NUMBER(:b19) and SEQUENCE_NO=TO_NUMBER(:b20)) and OPERAT\
ING_FACILITY_ID=:b21)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )341;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rh_source_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rh_consultant_code;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rh_extra_copies_to;
 sqlstm.sqhstl[2] = (unsigned int  )18;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rh_urgent_indicator;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rh_no_of_slides;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rh_specimen_type_code;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&rh_ref_specimen_no;
 sqlstm.sqhstl[6] = (unsigned int  )23;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&rh_request_comment_desc1;
 sqlstm.sqhstl[7] = (unsigned int  )43;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&rh_request_comment_desc2;
 sqlstm.sqhstl[8] = (unsigned int  )43;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&rh_request_comment_desc3;
 sqlstm.sqhstl[9] = (unsigned int  )43;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&rh_spec_colltd_date_time;
 sqlstm.sqhstl[10] = (unsigned int  )20;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&rh_spec_regd_date_time;
 sqlstm.sqhstl[11] = (unsigned int  )20;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&rh_spec_recd_date_time;
 sqlstm.sqhstl[12] = (unsigned int  )20;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&rh_user;
 sqlstm.sqhstl[13] = (unsigned int  )33;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&rh_action;
 sqlstm.sqhstl[14] = (unsigned int  )4;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&rh_time_stamp;
 sqlstm.sqhstl[15] = (unsigned int  )20;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[16] = (unsigned int  )33;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[17] = (unsigned int  )4;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&d_section_code;
 sqlstm.sqhstl[18] = (unsigned int  )4;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[19] = (unsigned int  )23;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[20] = (unsigned int  )12;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[21] = (unsigned int  )5;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
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
        err_mesg("SELECT failed on DO_REQUEST_HEADER table RL_REQUEST_HEADER_LOG ",0,"");

    if (NODATAFOUND)
        err_mesg("No Record found in RL_REQUEST_HEADER_LOG",0,"");

	rh_source_code.arr[rh_source_code.len]						= '\0'; 
	rh_consultant_code.arr[rh_consultant_code.len]				= '\0'; 
	rh_extra_copies_to.arr[rh_extra_copies_to.len]				= '\0'; 
	rh_urgent_indicator.arr[rh_urgent_indicator.len]			= '\0';  
	rh_no_of_slides.arr[rh_no_of_slides.len]					= '\0';  
	rh_specimen_type_code.arr[rh_specimen_type_code.len]		= '\0'; 
	rh_ref_specimen_no.arr[rh_ref_specimen_no.len]				= '\0'; 
	rh_request_comment_desc1.arr[rh_request_comment_desc1.len]	= '\0';  
	rh_request_comment_desc2.arr[rh_request_comment_desc2.len]	= '\0'; 
	rh_request_comment_desc3.arr[rh_request_comment_desc3.len]	= '\0';  
	rh_spec_colltd_date_time.arr[rh_spec_colltd_date_time.len]	= '\0'; 
    rh_spec_regd_date_time.arr[rh_spec_regd_date_time.len]		= '\0';  
	rh_spec_recd_date_time.arr[rh_spec_recd_date_time.len]		= '\0';  
	rh_user.arr[rh_user.len]									= '\0';
	rh_action.arr[rh_action.len]								= '\0'; 
	rh_time_stamp.arr[rh_time_stamp.len]						= '\0'; 
	d_patient_id.arr[d_patient_id.len]							= '\0';
	d_episode_type.arr[d_episode_type.len]						= '\0';
	d_section_code.arr[d_section_code.len]						= '\0';

	strcpy(nd_spec_code.arr, rh_specimen_type_code.arr);
	nd_spec_code.len = strlen(nd_spec_code.arr);


/**********************added for globalisation **********************/
	if (strcmp(rh_urgent_indicator.arr,"R") == 0) 
		strcpy (rh_urgent_indicator.arr, local_legend[62]);
	else if (strcmp(rh_urgent_indicator.arr,"U") == 0) 
		strcpy (rh_urgent_indicator.arr, local_legend[63]);
	else if (strcmp(rh_urgent_indicator.arr,"S") == 0)  
		strcpy (rh_urgent_indicator.arr, local_legend[64]);



// Collection Date & Time ---
	  /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rh_spec_colltd_date_time,'DD/MM/YYYY hh24:mi'), :language_id , t_date);
			:rh_spec_colltd_date_time1 := to_char(t_date,'DD/MM/YYYY hh24:mi');
		END;
	  END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :rh_spec_colltd_date_time , 'DD/MM/YYYY hh24:mi' ) , :l\
anguage_id , t_date ) ; :rh_spec_colltd_date_time1 := to_char ( t_date , 'DD/M\
M/YYYY hh24:mi' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )444;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rh_spec_colltd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )20;
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
   sqlstm.sqhstv[2] = (         void  *)&rh_spec_colltd_date_time1;
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



	  /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rh_spec_regd_date_time,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
			:rh_spec_regd_date_time1 := to_char(t_date,'DD/MM/YYYY hh24:mi');
		END;
	  END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :rh_spec_regd_date_time , 'DD/MM/YYYY HH24:MI' ) , :lan\
guage_id , t_date ) ; :rh_spec_regd_date_time1 := to_char ( t_date , 'DD/MM/YY\
YY hh24:mi' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )471;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rh_spec_regd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )20;
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
   sqlstm.sqhstv[2] = (         void  *)&rh_spec_regd_date_time1;
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



	  /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rh_spec_recd_date_time,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
			:rh_spec_recd_date_time1 := to_char(t_date,'DD/MM/YYYY hh24:mi');
		END;
	  END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :rh_spec_recd_date_time , 'DD/MM/YYYY HH24:MI' ) , :lan\
guage_id , t_date ) ; :rh_spec_recd_date_time1 := to_char ( t_date , 'DD/MM/YY\
YY hh24:mi' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )498;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rh_spec_recd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )20;
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
   sqlstm.sqhstv[2] = (         void  *)&rh_spec_recd_date_time1;
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



	  /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rh_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
			:rh_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
		END;
	  END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :rh_time_stamp , 'DD/MM/YY HH24:MI' ) , :language_id , \
t_date ) ; :rh_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )525;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rh_time_stamp;
   sqlstm.sqhstl[0] = (unsigned int  )20;
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
   sqlstm.sqhstv[2] = (         void  *)&rh_time_stamp1;
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


/**********************added for globalisation **********************/

}

do_specimen_report()
{
	if ( strcmp(d_episode_type.arr, "R") == 0) 
		do_patient_inf2();
	else
		do_patient_inf();
	
	do_patient_age();
	do_form_title();
		
}

do_patient_inf()
{

	d_dob.arr[0] = '\0';
	d_sex.arr[0] = '\0';
	d_patient_name.arr[0] = '\0';

	d_dob.len = 0;
	d_sex.len = 0;
	d_patient_name.len = 0;

//		   DECODE(SEX,'M','Male','F','Female','Unknown'),
		   
	/* EXEC SQL
	SELECT SUBSTR(DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG),1,25),
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   SEX,
		   /oMONTHS_BETWEEN(TO_DATE(TO_CHAR(SYSDATE, 'DD/MM/YYYY'), 'DD/MM/YYYY'),  // Commented by Durai Rajkumar for age calculation on 03/02/08o/
		   MONTHS_BETWEEN(TO_DATE(:ol_spec_regd_date_time, 'DD/MM/YYYY'),			/o Added by Durai Rajkumar for age calculation on 03/02/08 o/
						  TO_DATE(TO_CHAR(DATE_OF_BIRTH, 'DD/MM/YYYY'), 'DD/MM/YYYY')) "mths"
	  INTO :d_patient_name, :d_dob, :d_sex, :d_months
	  FROM MP_PATIENT_MAST
	 WHERE PATIENT_ID = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC\
_LANG),1,25) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX ,MONTHS_BETWEEN(TO_DATE\
(:b1,'DD/MM/YYYY'),TO_DATE(TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),'DD/MM/YYYY')) \
\"mths\" into :b2,:b3,:b4,:b5  from MP_PATIENT_MAST where PATIENT_ID=:b6";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )552;
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
 sqlstm.sqhstv[1] = (         void  *)&ol_spec_regd_date_time;
 sqlstm.sqhstl[1] = (unsigned int  )20;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_patient_name;
 sqlstm.sqhstl[2] = (unsigned int  )242;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_dob;
 sqlstm.sqhstl[3] = (unsigned int  )14;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_sex;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_months;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[6] = (unsigned int  )33;
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
        err_mesg("SELECT failed on DO_PATIENT_INF table MP_PATIENT_MAST ",0,"");

    if (NODATAFOUND)
       err_mesg("No Record found in MP_PATIENT_MAST",0,""); 


	d_dob.arr[d_dob.len] = '\0';
	d_sex.arr[d_sex.len] = '\0';
	d_patient_name.arr[d_patient_name.len] = '\0';

	if (strcmp(d_sex.arr,"M") == 0) 
		strcpy (d_sex.arr, local_legend[54]);
	else if (strcmp(d_sex.arr,"F") == 0) 
		strcpy (d_sex.arr, local_legend[55]);
	else  
		strcpy (d_sex.arr, local_legend[56]);

}


do_patient_inf2()
{

	d_dob.arr[0] = '\0';
	d_sex.arr[0] = '\0';
	d_patient_name.arr[0] = '\0';

	d_dob.len = 0;
	d_sex.len = 0;
	d_patient_name.len = 0;

//		   DECODE(SEX,'M','Male','F','Female',SEX),	
	   

	/* EXEC SQL
	SELECT SUBSTR(DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG),1,25),
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   SEX,
		   /oMONTHS_BETWEEN(TO_DATE(TO_CHAR(SYSDATE, 'DD/MM/YYYY'), 'DD/MM/YYYY'),  // Commented by Durai Rajkumar for age calculation on 03/02/08o/
		   MONTHS_BETWEEN(TO_DATE(:ol_spec_regd_date_time, 'DD/MM/YYYY'),			/o Added by Durai Rajkumar for age calculation on 03/02/08 o/
						  TO_DATE(TO_CHAR(DATE_OF_BIRTH, 'DD/MM/YYYY'), 'DD/MM/YYYY')) "mths"
	  INTO :d_patient_name, :d_dob, :d_sex, :d_months
	  FROM RL_PATIENT_MAST
	 WHERE PATIENT_ID = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC\
_LANG),1,25) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX ,MONTHS_BETWEEN(TO_DATE\
(:b1,'DD/MM/YYYY'),TO_DATE(TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),'DD/MM/YYYY')) \
\"mths\" into :b2,:b3,:b4,:b5  from RL_PATIENT_MAST where PATIENT_ID=:b6";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )595;
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
 sqlstm.sqhstv[1] = (         void  *)&ol_spec_regd_date_time;
 sqlstm.sqhstl[1] = (unsigned int  )20;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_patient_name;
 sqlstm.sqhstl[2] = (unsigned int  )242;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_dob;
 sqlstm.sqhstl[3] = (unsigned int  )14;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_sex;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_months;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[6] = (unsigned int  )33;
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


	 /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

	if (OERROR)
        err_mesg("SELECT failed on DO_PATIENT_INF2 table RL_PATIENT_MAST ",0,"");

    if (NODATAFOUND)
	    err_mesg("No Record found in RL_PATIENT_MAST",0,""); 


	d_dob.arr[d_dob.len] = '\0';
	d_sex.arr[d_sex.len] = '\0';
	d_patient_name.arr[d_patient_name.len] = '\0';

	if (strcmp(d_sex.arr,"M") == 0) 
		strcpy (d_sex.arr, local_legend[54]);
	else if (strcmp(d_sex.arr,"F") == 0) 
		strcpy (d_sex.arr, local_legend[55]);
}

do_patient_age()
{
	/* EXEC SQL
	SELECT  floor( :d_months / 12 ), 
			floor(((:d_months / 12 ) - floor( :d_months / 12 ))*12),
			round(( ((:d_months / 12 ) - floor( :d_months / 12 ))*12
				   - floor(((:d_months / 12 ) - floor( :d_months / 12 ))*12))*30)
	  INTO :d_yrs1,
		   :d_mths1,
		   :d_days1
	  FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select floor((:b0/12)) ,floor((((:b0/12)-floor((:b0/12)))* 1\
2)) ,round((((((:b0/12)-floor((:b0/12)))* 12)-floor((((:b0/12)-floor((:b0/12))\
)* 12)))* 30)) into :b7,:b8,:b9  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )638;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_months;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_months;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_months;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_months;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_months;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_months;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_months;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_yrs1;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_mths1;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_days1;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
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

 
	
	//sprintf(d_pat_age,"%2dY %2dM %2dD",d_yrs1, d_mths1, d_days1); 
	sprintf(d_pat_age,"%2d%1.1s %2d%1.1s %2d%1.1s",d_yrs1,local_legend[51], d_mths1, local_legend[52], d_days1, local_legend[53]); // added for globalisation
	/*disp_message(ORA_MESG, d_pat_age);*/
}

do_report_request_header()
{
	do_spec_desc();
	
//	get_order_id();  commented by amjad on 28/12/2005 for getting order details in do_request_header

	if (ol_order_id_ind != -1)
	 get_spec_user_info();


	if (ol_order_id_ind == -1)
		chk_break(line_no+6); 
	else
		chk_break(line_no+10); 

	 /*chk_break(line_no+6); */

	if ( strcmp(rh_action.arr, "V") == 0 )
		 //fprintf(f1, "ACKNOWLEDGE/VERIFICATION \n");  
		 fprintf(f1, "%s \n", local_legend[2]); //added for globalisation
	else
  	     //fprintf(f1, "REQUEST REGISTRATION \n");  
		 fprintf(f1, "%s \n", local_legend[3]); //added for globalisation
	
 
	fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", rh_action.arr, rh_time_stamp1.arr, rh_user.arr);
	
	/*fprintf(f1, "SOURCE   : %-12.12s DOCTOR     : %-6.6s COPY TO : %-15.15s      PRIORITY ?   : %-10.10s\n",
				 rh_source_code.arr, rh_consultant_code.arr, rh_extra_copies_to.arr, rh_urgent_indicator.arr);
	
	fprintf(f1, "%27.27s  SAMPLES  : %-12.12s SPEC. TYPE : %-37.37s REFL SPEC NO : %-15.15s\n",
				 " ", rh_no_of_slides.arr, nd_spec_desc.arr, rh_ref_specimen_no.arr);
	*/
	fprintf(f1, "%-9.9s: %-12.12s %-11.11s: %-6.6s %-8.8s: %-15.15s      %-13.13s: %-10.10s\n",
				 local_legend[4], rh_source_code.arr, local_legend[5], rh_consultant_code.arr, local_legend[6], rh_extra_copies_to.arr, local_legend[7], rh_urgent_indicator.arr);//added for globalisation
	
	fprintf(f1, "%27.27s  %-9.9s: %-12.12s %-11.11s: %-37.37s %-13.13s: %-15.15s\n",
				 " ", local_legend[8], rh_no_of_slides.arr, local_legend[9], nd_spec_desc.arr, local_legend[10], rh_ref_specimen_no.arr);//added for globalisation
	

	if (ol_order_id_ind != -1)
	{
		if ( strcmp ( rh_request_comment_desc1.arr, "\0") != 0)
		/*	fprintf(f1, "%27.27s  COMMENTS : %-40.40s  Start Order Date & Time : %-16.16s\n",
				  " ", rh_request_comment_desc1.arr, ol_order_start_date.arr);
		*/
		fprintf(f1, "%27.27s  %-9.9s: %-40.40s  %-23.23s : %-16.16s\n",
				  " ", local_legend[11], rh_request_comment_desc1.arr, local_legend[12], ol_order_start_date1.arr); // added for globalisation
		else
		/*	fprintf(f1, "%27.27s  COMMENTS : %-40.40s  Start Order Date & Time : %-16.16s\n",
				  " ", " ", ol_order_start_date.arr);

	    fprintf(f1, "%27.27s             %-40.40s  Collection Date & Time  : %-16.16s\n",
				  " "," ",rh_spec_colltd_date_time.arr);
		*/
		fprintf(f1, "%27.27s  %-9.9s: %-40.40s  %-23.23s : %-16.16s\n",
				  " ",local_legend[11], " ", local_legend[12], ol_order_start_date1.arr); // added for globalisation

	    fprintf(f1, "%27.27s             %-40.40s  %-24.24s: %-16.16s\n",
				  " "," ",local_legend[13], rh_spec_colltd_date_time1.arr); // added for globalisation
	}
	else
	{
	if ( strcmp ( rh_request_comment_desc1.arr, "\0") != 0)
	/*		fprintf(f1, "%27.27s  COMMENTS : %-40.40s  Collection Date & Time  : %-16.16s\n",
				  " ", rh_request_comment_desc1.arr, rh_spec_colltd_date_time.arr);
	*/
			fprintf(f1, "%27.27s  %-9.9s: %-40.40s  %-24.24s: %-16.16s\n",
				  " ", local_legend[11], rh_request_comment_desc1.arr, local_legend[13], rh_spec_colltd_date_time1.arr);// added for globalisation
	else
	/*	fprintf(f1, "%27.27s  COMMENTS : %-40.40s  Collection Date & Time  : %-16.16s\n",
				  " ", " ", rh_spec_colltd_date_time.arr);
	*/
		fprintf(f1, "%27.27s  %-9.9s: %-40.40s  %-24.24s: %-16.16s\n",
				  " ",local_legend[11],  " ", local_legend[13], rh_spec_colltd_date_time1.arr);//added for globalisation
	}

	
	/* Added on 11-2-2004 */	
	if (ol_order_id_ind != -1)
	 /*   fprintf(f1, "%27.27s             %-40.40s  Collected By            : %-30.30s\n",
				  " "," ",ol_spec_regd_by.arr);
	 */
	    fprintf(f1, "%27.27s             %-40.40s  %-24.24s: %-30.30s\n",
				  " "," ",local_legend[14],ol_spec_regd_by.arr); // added for globalisation
	/*-----------*/

	/* Added on 11-2-2004 */	
	if (ol_order_id_ind != -1) 
	  {
	  /*fprintf(f1, "%27.27s             %-40.40s  Dispatched Date & Time  : %-16.16s\n",
				  " "," ",ol_spec_disp_date_time.arr);
		fprintf(f1, "%27.27s             %-40.40s  Dispatched By           : %-30.30s\n",
				  " "," ",ol_spec_disp_by.arr);
	  */
	  fprintf(f1, "%27.27s             %-40.40s  %-24.24s: %-16.16s\n",
				  " "," ",local_legend[15],ol_spec_disp_date_time1.arr); //added for globalisation
		fprintf(f1, "%27.27s             %-40.40s  %-24.24s: %-30.30s\n",
				  " "," ",local_legend[16],ol_spec_disp_by.arr);//added for globalisation
	  } 
	/*-----------*/

	if ( strcmp ( rh_request_comment_desc2.arr, "\0") != 0)
	/*	fprintf(f1, "%27.27s             %-40.40s  Received Date & Time    : %-16.16s\n",
				  " ",rh_request_comment_desc2.arr, rh_spec_recd_date_time.arr);
	*/
		fprintf(f1, "%27.27s             %-40.40s  %-24.24s: %-16.16s\n",
				  " ",rh_request_comment_desc2.arr, local_legend[17], rh_spec_recd_date_time1.arr);//added for globalisation
	else
	/*	fprintf(f1, "%27.27s             %-40.40s  Received Date & Time    : %-16.16s\n",
				  " "," ",rh_spec_recd_date_time.arr);
	*/
		fprintf(f1, "%27.27s             %-40.40s  %-24.24s: %-16.16s\n",
				  " "," ",local_legend[17], rh_spec_recd_date_time1.arr);//added for globalisation
	if ( strcmp ( rh_request_comment_desc3.arr, "\0") != 0)
	/*	fprintf(f1, "%27.27s             %-40.40s  Registered Date & Time  : %-16.16s\n",
				  " ",rh_request_comment_desc3.arr, rh_spec_regd_date_time.arr);
	*/
		fprintf(f1, "%27.27s             %-40.40s  %-24.24s: %-16.16s\n",
				  " ",rh_request_comment_desc3.arr, local_legend[18], rh_spec_regd_date_time1.arr);//added for globalisation
	else
	/*	fprintf(f1, "%27.27s             %-40.40s  Registered Date & Time  : %-16.16s\n",
				  " "," ", rh_spec_regd_date_time.arr);
	*/
		fprintf(f1, "%27.27s             %-40.40s  %-24.24s: %-16.16s\n",
				  " "," ", local_legend[18], rh_spec_regd_date_time1.arr);//added for globalisation
	
	if (ol_order_id_ind == -1)
		line_no += 6;
	else
		line_no += 10;

	
	get_category_yn();
	if (d_category_yn.arr[0]	== 'Y')
	{
		get_category();

		//fprintf(f1, "                             CATEGORY : %s\n", d_category.arr);
		fprintf(f1, "%34.34s : %s\n", local_legend[19], d_category.arr);//added for globalisation

		line_no++;

	}


/* added on 01/09/2002 as per the request KNDV SITE *************/
	

	
}


do_request_detail()
{

	rd_test_code.arr[0]			= '\0'; 
	rd_numeric_result.arr[0]	= '\0'; 
	rd_user.arr[0]				= '\0'; 
	rd_action.arr[0]			= '\0'; 
	rd_time_stamp.arr[0]		= '\0'; 
	rd_cancel_code.arr[0]       = '\0';
	rd_test_code.len			= 0; 
	rd_numeric_result.len		= 0; 
	rd_user.len					= 0;  
	rd_action.len				= 0;  
	rd_time_stamp.len			= 0;  
	rd_cancel_code.len          = 0;


	/* EXEC SQL 
	SELECT TEST_CODE, NUMERIC_PREFIX||' '||NUMERIC_RESULT "RESULT", 
		SUBSTR(modified_by_id, 1, 10) "USER",
/o		   SUBSTR(ADDED_BY_ID,1,10)"USER",	 CHANGED FOR PRINTED-BY LEGEND IN REPORTo/
		   ACTION, TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",CANCEL_CODE
	  INTO :rd_test_code, :rd_numeric_result,
		   :rd_user, :rd_action, :rd_time_stamp,:rd_cancel_code
	  FROM RL_REQUEST_DETAIL_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND TEST_CODE   = NVL(:d_test_code, TEST_CODE)
	   AND NVL(action, '!') <> 'C'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TEST_CODE ,((NUMERIC_PREFIX||' ')||NUMERIC_RESULT) \"\
RESULT\" ,SUBSTR(modified_by_id,1,10) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'DD\
/MM/YY HH24:MI') \"TIME_STAMP\" ,CANCEL_CODE into :b0,:b1,:b2,:b3,:b4,:b5  fro\
m RL_REQUEST_DETAIL_LOG where ((((SPECIMEN_NO=TO_NUMBER(:b6) and SEQUENCE_NO=T\
O_NUMBER(:b7)) and OPERATING_FACILITY_ID=:b8) and TEST_CODE=NVL(:b9,TEST_CODE)\
) and NVL(action,'!')<>'C')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )693;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rd_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rd_numeric_result;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rd_user;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rd_action;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rd_time_stamp;
 sqlstm.sqhstl[4] = (unsigned int  )20;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rd_cancel_code;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[6] = (unsigned int  )23;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[7] = (unsigned int  )12;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_test_code;
 sqlstm.sqhstl[9] = (unsigned int  )13;
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
        err_mesg("SELECT failed on DO_REQUEST_DETAIL table RL_REQUEST_DETAIL_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;
    
	   /* err_mesg("No Record found in RL_REQUEST_DETAIL_LOG",0,""); */

	rd_test_code.arr[rd_test_code.len]			 = '\0'; 
	rd_numeric_result.arr[rd_numeric_result.len] = '\0'; 
	rd_user.arr[rd_user.len]					 = '\0'; 
	rd_action.arr[rd_action.len]				 = '\0'; 
	rd_time_stamp.arr[rd_time_stamp.len]		 = '\0'; 
	rd_cancel_code.arr[rd_cancel_code.len]       = '\0';

	strcpy(nd_test_code.arr, rd_test_code.arr);
	nd_test_code.len = strlen(nd_test_code.arr);

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rd_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:rd_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 22;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CON\
VERT_TO_LOCALE_DATE ( to_date ( :rd_time_stamp , 'DD/MM/YY HH24:MI' ) , :langu\
age_id , t_date ) ; :rd_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )748;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&rd_time_stamp;
            sqlstm.sqhstl[0] = (unsigned int  )20;
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
            sqlstm.sqhstv[2] = (         void  *)&rd_time_stamp1;
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





}




do_request_detail_cancel()
{
	rd_test_code.arr[0]			= '\0'; 
	rd_numeric_result.arr[0]	= '\0'; 
	rd_user.arr[0]				= '\0'; 
	rd_action.arr[0]			= '\0'; 
	rd_time_stamp.arr[0]		= '\0'; 
	rd_cancel_code.arr[0]       = '\0';

	rd_test_code.len			= 0; 
	rd_numeric_result.len		= 0; 
	rd_user.len					= 0;  
	rd_action.len				= 0;  
	rd_time_stamp.len			= 0;  
	rd_cancel_code.len          = 0;


	/* EXEC SQL 
	SELECT TEST_CODE, NUMERIC_PREFIX||' '||NUMERIC_RESULT "RESULT", 
		SUBSTR(modified_by_id, 1, 10) "USER",
/o		   SUBSTR(ADDED_BY_ID,1,10)"USER",	 CHANGED FOR PRINTED-BY LEGEND IN REPORTo/
		   ACTION, TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",CANCEL_CODE
	  INTO :rd_test_code, :rd_numeric_result,
		   :rd_user, :rd_action, :rd_time_stamp,:rd_cancel_code
	  FROM RL_REQUEST_DETAIL_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND TEST_CODE   = NVL(:d_test_code, TEST_CODE)
	   AND NVL(action, '!') = 'C'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TEST_CODE ,((NUMERIC_PREFIX||' ')||NUMERIC_RESULT) \"\
RESULT\" ,SUBSTR(modified_by_id,1,10) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'DD\
/MM/YY HH24:MI') \"TIME_STAMP\" ,CANCEL_CODE into :b0,:b1,:b2,:b3,:b4,:b5  fro\
m RL_REQUEST_DETAIL_LOG where ((((SPECIMEN_NO=TO_NUMBER(:b6) and SEQUENCE_NO=T\
O_NUMBER(:b7)) and OPERATING_FACILITY_ID=:b8) and TEST_CODE=NVL(:b9,TEST_CODE)\
) and NVL(action,'!')='C')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )775;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rd_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rd_numeric_result;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rd_user;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rd_action;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rd_time_stamp;
 sqlstm.sqhstl[4] = (unsigned int  )20;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rd_cancel_code;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[6] = (unsigned int  )23;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[7] = (unsigned int  )12;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_test_code;
 sqlstm.sqhstl[9] = (unsigned int  )13;
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
        err_mesg("SELECT failed on DO_REQUEST_DETAIL table RL_REQUEST_DETAIL_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;
    
	   /* err_mesg("No Record found in RL_REQUEST_DETAIL_LOG",0,""); */

	rd_test_code.arr[rd_test_code.len]			 = '\0'; 
	rd_numeric_result.arr[rd_numeric_result.len] = '\0'; 
	rd_user.arr[rd_user.len]					 = '\0'; 
	rd_action.arr[rd_action.len]				 = '\0'; 
	rd_time_stamp.arr[rd_time_stamp.len]		 = '\0'; 
	rd_cancel_code.arr[rd_cancel_code.len]       = '\0';

	strcpy(nd_test_code.arr, rd_test_code.arr);
	nd_test_code.len = strlen(nd_test_code.arr);

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rd_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:rd_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 22;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CON\
VERT_TO_LOCALE_DATE ( to_date ( :rd_time_stamp , 'DD/MM/YY HH24:MI' ) , :langu\
age_id , t_date ) ; :rd_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )830;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&rd_time_stamp;
            sqlstm.sqhstl[0] = (unsigned int  )20;
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
            sqlstm.sqhstv[2] = (         void  *)&rd_time_stamp1;
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




}

do_report_request_detail()
{
	    do_test_desc();

		if ( strcmp(rd_action.arr, "P") == 0 )
		   //fprintf(f1, "\nPRINTED  \n");
		   fprintf(f1, "\n%-9.9s\n", local_legend[20]);//added for globalisation

		line_no += 2;
		chk_break(line_no);

		fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", rd_action.arr, rd_time_stamp1.arr, rd_user.arr);
		//fprintf(f1, "TEST  : %-40.40s  %-15.15s \n", nd_test_desc.arr, rd_numeric_result.arr);	
		fprintf(f1, "%-6.6s: %-40.40s  %-15.15s \n", local_legend[21], nd_test_desc.arr, rd_numeric_result.arr);//added for globalisation	
		
		line_no++;


		chk_break(line_no);
	
}


do_report_request_detail_cancel()
{
	    do_test_desc();

		if ( strcmp(rd_action.arr, "P") == 0 )
		   //fprintf(f1, "\nPRINTED  \n");
		   fprintf(f1, "\n%-9.9s\n", local_legend[20]);//added for globalisation

		line_no += 2;
		chk_break(line_no);

		fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", rd_action.arr, rd_time_stamp1.arr, rd_user.arr);
		//fprintf(f1, "TEST  : %-40.40s  %-15.15s \n", nd_test_desc.arr, rd_numeric_result.arr);	
		fprintf(f1, "%-6.6s: %-40.40s  %-15.15s \n", local_legend[21], nd_test_desc.arr, rd_numeric_result.arr);//added for globalisation	
		

		line_no++;

		if (strlen(rd_cancel_code.arr) != 0 )
		{
		  get_cancel_desc();
		  //fprintf(f1,"                         CANCELLED : %-6.6s%s\n",rd_cancel_code.arr,rd_cancel_desc.arr);
		  fprintf(f1,"%34.34s: %-6.6s%s\n",local_legend[21], rd_cancel_code.arr,rd_cancel_desc.arr);//added for globalisation
	      line_no++;
		  chk_break(line_no);   //SD-CRF-20064
		  get_cancel_remarks(); //SD-CRF-20064
		  splitting_remarks();  //SD-CRF-20064
		}
		else
		{
			check_cancelled_yn();

			if (strcmp(rd_cancelled_yn.arr, "Y") == 0)
			{
			  get_cancel_desc();
			  //fprintf(f1,"                         CANCELLED : %-6.6s%s\n",rd_cancel_code.arr,rd_cancel_desc.arr);
			  fprintf(f1,"%34.34s: %-6.6s%s\n",local_legend[21], rd_cancel_code.arr,rd_cancel_desc.arr);//added for globalisation
			  line_no++;
			  chk_break(line_no);  //SD-CRF-20064
              get_cancel_remarks();//SD-CRF-20064
			  splitting_remarks(); //SD-CRF-20064
			}

		}

		chk_break(line_no);
	
}

do_result_snomed()
{
	rs_group_test_code.arr[0]		= '\0'; 
	rs_test_code.arr[0]				= '\0'; 
	rs_snomed_code.arr[0]			= '\0'; 
	rs_snomed_code2.arr[0]			= '\0'; 
	rs_user.arr[0]					= '\0';  
	rs_action.arr[0]				= '\0';  
	rs_time_stamp.arr[0]			= '\0'; 

	rs_group_test_code.len			= 0;
	rs_test_code.len				= 0;
	rs_snomed_code.len				= 0;
	rs_snomed_code2.len				= 0;
	rs_user.len						= 0;
	rs_action.len					= 0;
	rs_time_stamp.len				= 0;
	

	/* EXEC SQL
	SELECT GROUP_TEST_CODE, TEST_CODE, SNOMED_CODE, SNOMED_CODE_2, 
		   SUBSTR(ADDED_BY_ID,1,10)"USER",
		   ACTION, TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",
		   MODIFY_LOG_SEQ_NO
	  INTO :rs_group_test_code, :rs_test_code, :rs_snomed_code, :rs_snomed_code2,
		   :rs_user, :rs_action, :rs_time_stamp,
		   :tr_modify_log_seq_no INDICATOR :tr_modify_log_seq_no_ind
	  FROM RL_RESULT_SNOMED_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND (    GROUP_TEST_CODE = nvl(:d_test_code, GROUP_TEST_CODE)
	         OR TEST_CODE  = NVL(:d_test_code, TEST_CODE )); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GROUP_TEST_CODE ,TEST_CODE ,SNOMED_CODE ,SNOMED_CODE_\
2 ,SUBSTR(ADDED_BY_ID,1,10) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'DD/MM/YY HH2\
4:MI') \"TIME_STAMP\" ,MODIFY_LOG_SEQ_NO into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7:\
b8  from RL_RESULT_SNOMED_LOG where (((SPECIMEN_NO=TO_NUMBER(:b9) and SEQUENCE\
_NO=TO_NUMBER(:b10)) and OPERATING_FACILITY_ID=:b11) and (GROUP_TEST_CODE=nvl(\
:b12,GROUP_TEST_CODE) or TEST_CODE=NVL(:b12,TEST_CODE)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )857;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rs_group_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rs_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rs_snomed_code;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rs_snomed_code2;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rs_user;
 sqlstm.sqhstl[4] = (unsigned int  )33;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rs_action;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&rs_time_stamp;
 sqlstm.sqhstl[6] = (unsigned int  )20;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)&tr_modify_log_seq_no_ind;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[8] = (unsigned int  )23;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[9] = (unsigned int  )12;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_test_code;
 sqlstm.sqhstl[11] = (unsigned int  )13;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_test_code;
 sqlstm.sqhstl[12] = (unsigned int  )13;
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
}



	/*-------- Added on 12-2-2004 ---------*/
	if (l_snomed_log_cnt1 == l_snomed_log_cnt2)
		get_snomed_seq_cnt();
    /*-------------------------------------*/

    if (OERROR)
        err_mesg("SELECT failed on DO_RESULT_SNOMED table RL_RESULT_SNOMED_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;
		

        /* err_mesg("No Record found in RL_RESULT_SNOMED_LOG",0,""); */

	rs_group_test_code.arr[rs_group_test_code.len]		= '\0'; 
	rs_test_code.arr[rs_test_code.len]					= '\0'; 
	rs_snomed_code.arr[rs_snomed_code.len]				= '\0'; 
	rs_snomed_code2.arr[rs_snomed_code2.len]			= '\0'; 
	rs_user.arr[rs_user.len]							= '\0';  
	rs_action.arr[rs_action.len]						= '\0';  
	rs_time_stamp.arr[rs_time_stamp.len]				= '\0'; 

	strcpy(nd_snomed_code.arr, rs_snomed_code.arr);
	nd_snomed_code.len = strlen(nd_snomed_code.arr);
	strcpy(nd_snomed_code2.arr, rs_snomed_code2.arr);
	nd_snomed_code2.len = strlen(nd_snomed_code2.arr);

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rs_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:rs_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 22;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CON\
VERT_TO_LOCALE_DATE ( to_date ( :rs_time_stamp , 'DD/MM/YY HH24:MI' ) , :langu\
age_id , t_date ) ; :rs_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )924;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&rs_time_stamp;
            sqlstm.sqhstl[0] = (unsigned int  )20;
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
            sqlstm.sqhstv[2] = (         void  *)&rs_time_stamp1;
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




}

do_report_result_snomed()
{
		if (strlen(rs_snomed_code.arr) > 0)
		{
			do_snomed_desc();
			fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", rs_action.arr, rs_time_stamp1.arr, rs_user.arr);
			/*fprintf(f1, "GROUP : %-11.11s TEST : %-11.11s SNOMED : %-20.20s  %-30.30s\n",
					 rs_group_test_code.arr, rs_test_code.arr, rs_snomed_code.arr, 
					 nd_snomed_desc.arr);
			*/
			fprintf(f1, "%-6.6s: %-11.11s %-5.5s: %-11.11s %-7.7s: %-20.20s  %-30.30s\n",
					 local_legend[23], rs_group_test_code.arr, local_legend[21], rs_test_code.arr, local_legend[24], rs_snomed_code.arr, 
					 nd_snomed_desc.arr);//added for globalisation
			line_no++;
			chk_break(line_no);
		}
// ----------- added on 07.10.2002 ------------------
		if (strlen(nd_snomed_code2.arr) > 0)
		{
			do_snomed_desc2();
		/*	fprintf(f1, "%-67.67s SNOMED : %-20.20s  %-30.30s\n",
				 " ", rs_snomed_code2.arr, nd_snomed_desc2.arr);
		*/
			fprintf(f1, "%-67.67s %-7.7s: %-20.20s  %-30.30s\n",
				 " ", local_legend[24], rs_snomed_code2.arr, nd_snomed_desc2.arr);//added for globalisation
			line_no++;
			chk_break(line_no);
		}
// ----------- upto here -------------
		/* -------Added on 12-02-2004---------*/
		if (tr_modify_log_seq_no_ind != -1 && strcmp(rs_action.arr,"M") == 0)
		{ 
		  l_snomed_log_cnt2 = l_snomed_log_cnt2 + 1;
		}
		/*------------------------------------*/
}		

do_test_result()
{

	tr_group_test_code.arr[0]		= '\0'; 
	tr_test_code.arr[0]				= '\0';  
	tr_result.arr[0]				= '\0';  
	tr_result_desc1.arr[0]			= '\0'; 
	tr_result_desc2.arr[0]			= '\0';  
	tr_result_desc3.arr[0]			= '\0';  
	tr_result_desc4.arr[0]			= '\0'; 
	tr_user.arr[0]					= '\0';  
	tr_action.arr[0]				= '\0';  
	tr_time_stamp.arr[0]			= '\0'; 


	tr_group_test_code.len			= 0; 
	tr_test_code.len				= 0;  
	tr_result.len					= 0;  
	tr_result_desc1.len				= 0; 
	tr_result_desc2.len				= 0;  
	tr_result_desc3.len				= 0;  
	tr_result_desc4.len				= 0; 
	tr_user.len						= 0;  
	tr_action.len					= 0;  
	tr_time_stamp.len				= 0; 
	

	/* EXEC SQL
	SELECT GROUP_TEST_CODE, TEST_CODE, NUMERIC_PREFIX ||' '||NUMERIC_RESULT "RESULT",
		   RESULT_COMMENT_DESC1, RESULT_COMMENT_DESC2,
		   RESULT_COMMENT_DESC3, RESULT_COMMENT_DESC4,
		   SUBSTR(MODIFIED_BY_ID,1,10) "USER",
		   ACTION, TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",
		   MODIFY_LOG_SEQ_NO
	  INTO :tr_group_test_code, :tr_test_code, :tr_result, :tr_result_desc1,
		   :tr_result_desc2, :tr_result_desc3, :tr_result_desc4,
		   :tr_user, :tr_action, :tr_time_stamp,
		   :tr_modify_log_seq_no INDICATOR :tr_modify_log_seq_no_ind
	  FROM RL_TEST_RESULT_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO	= TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND (    GROUP_TEST_CODE = nvl(:d_test_code, GROUP_TEST_CODE)
	         OR TEST_CODE  = NVL(:d_test_code, TEST_CODE )); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GROUP_TEST_CODE ,TEST_CODE ,((NUMERIC_PREFIX||' ')||N\
UMERIC_RESULT) \"RESULT\" ,RESULT_COMMENT_DESC1 ,RESULT_COMMENT_DESC2 ,RESULT_\
COMMENT_DESC3 ,RESULT_COMMENT_DESC4 ,SUBSTR(MODIFIED_BY_ID,1,10) \"USER\" ,ACT\
ION ,TO_CHAR(TIME_STAMP,'DD/MM/YY HH24:MI') \"TIME_STAMP\" ,MODIFY_LOG_SEQ_NO \
into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10:b11  from RL_TEST_RESULT_LOG\
 where (((SPECIMEN_NO=TO_NUMBER(:b12) and SEQUENCE_NO=TO_NUMBER(:b13)) and OPE\
RATING_FACILITY_ID=:b14) and (GROUP_TEST_CODE=nvl(:b15,GROUP_TEST_CODE) or TES\
T_CODE=NVL(:b15,TEST_CODE)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )951;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&tr_group_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&tr_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&tr_result;
 sqlstm.sqhstl[2] = (unsigned int  )18;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&tr_result_desc1;
 sqlstm.sqhstl[3] = (unsigned int  )43;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&tr_result_desc2;
 sqlstm.sqhstl[4] = (unsigned int  )43;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&tr_result_desc3;
 sqlstm.sqhstl[5] = (unsigned int  )43;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&tr_result_desc4;
 sqlstm.sqhstl[6] = (unsigned int  )43;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&tr_user;
 sqlstm.sqhstl[7] = (unsigned int  )33;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&tr_action;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&tr_time_stamp;
 sqlstm.sqhstl[9] = (unsigned int  )20;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)&tr_modify_log_seq_no_ind;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[11] = (unsigned int  )23;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[12] = (unsigned int  )12;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[13] = (unsigned int  )5;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_test_code;
 sqlstm.sqhstl[14] = (unsigned int  )13;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&d_test_code;
 sqlstm.sqhstl[15] = (unsigned int  )13;
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
        err_mesg("SELECT failed on DO_TEST_RESULT table RL_TEST_RESULT_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;
		

      /*  err_mesg("No Record found in RL_TEST_RESULT_LOG",0,""); */

	tr_group_test_code.arr[tr_group_test_code.len]		= '\0'; 
	tr_test_code.arr[tr_test_code.len]					= '\0';  
	tr_result.arr[tr_result.len]						= '\0';  
	tr_result_desc1.arr[tr_result_desc1.len]			= '\0'; 
	tr_result_desc2.arr[tr_result_desc2.len]			= '\0';  
	tr_result_desc3.arr[tr_result_desc3.len]			= '\0';  
	tr_result_desc4.arr[tr_result_desc4.len]			= '\0'; 
	tr_user.arr[tr_user.len]							= '\0';  
	tr_action.arr[tr_action.len]						= '\0';  
	tr_time_stamp.arr[tr_time_stamp.len]				= '\0'; 

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:tr_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:tr_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 22;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CON\
VERT_TO_LOCALE_DATE ( to_date ( :tr_time_stamp , 'DD/MM/YY HH24:MI' ) , :langu\
age_id , t_date ) ; :tr_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1030;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&tr_time_stamp;
            sqlstm.sqhstl[0] = (unsigned int  )20;
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
            sqlstm.sqhstv[2] = (         void  *)&tr_time_stamp1;
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



					
}

do_report_test_result()
{
	
		fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", tr_action.arr, tr_time_stamp1.arr, tr_user.arr);
	
		/*fprintf(f1, "GROUP : %-10.10s  TEST : %-10.10s  RESULT : %-7.7s ",
				tr_group_test_code.arr, tr_test_code.arr, tr_result.arr);
		*/
		fprintf(f1, "%-6.6s: %-10.10s  %-5.5s: %-10.10s  %-7.7s: %-7.7s ",
				local_legend[23], tr_group_test_code.arr, local_legend[21], tr_test_code.arr, local_legend[25], tr_result.arr);//added for globalisation
		if ( strcmp(tr_result_desc1.arr, "\0") != 0)
		{
			fprintf(f1, " %-40.40s\n", tr_result_desc1.arr);
			line_no++;
			chk_break(line_no);
		}
		else
		{
			fprintf(f1, "\n");
			line_no++;
			chk_break(line_no);
		}

		if ( strcmp (tr_result_desc2.arr, "\0") != 0)
		{
		
			fprintf(f1, "%-76.76s%-40.40s\n", " ", tr_result_desc2.arr);
			line_no++;
			chk_break(line_no);
		}

		if ( strcmp (tr_result_desc3.arr, "\0") != 0)
		{
			fprintf(f1, "%-76.76s%-40.40s\n", " ", tr_result_desc3.arr);
			line_no++;
			chk_break(line_no);
		}

		if ( strcmp (tr_result_desc4.arr, "\0") != 0)
		{
			fprintf(f1, "%-76.76s%-40.40s\n", " ", tr_result_desc4.arr); 
			line_no++;
			chk_break(line_no);
		}
		/* -- Added on 12-2-2004 ---*/						
			do_modify_log(tr_group_test_code.arr,tr_test_code.arr);  
		/* -------------------------*/
	
}

do_result_organism()
{
	or_group_test_code.arr[0]		= '\0'; 
	or_test_code.arr[0]				= '\0';  
	or_organism_code.arr[0]			= '\0'; 
	or_result_comment_desc.arr[0]	= '\0'; 
	or_user.arr[0]					= '\0'; 
	or_action.arr[0]				= '\0'; 
	or_time_stamp.arr[0]			= '\0'; 

	or_group_test_code.len = 0; 
	or_test_code.len = 0;  
	or_organism_code.len = 0; 
	or_result_comment_desc.len = 0;  
	or_user.len = 0;  
	or_action.len = 0;  
	or_time_stamp.len = 0; 
	
	/* EXEC SQL
	SELECT GROUP_TEST_CODE, TEST_CODE, ORGANISM_CODE, RESULT_COMMENT_DESC,
		   SUBSTR(MODIFIED_BY_ID,1,10)"USER",
		   ACTION, TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",
		   MODIFY_LOG_SEQ_NO
	  INTO :or_group_test_code, :or_test_code, :or_organism_code,
		   :or_result_comment_desc, :or_user, :or_action, :or_time_stamp,
		   :tr_modify_log_seq_no INDICATOR :tr_modify_log_seq_no_ind
	  FROM RL_RESULT_ORGANISM_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO	= TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND (    GROUP_TEST_CODE = nvl(:d_test_code, GROUP_TEST_CODE)
	         OR TEST_CODE  = NVL(:d_test_code, TEST_CODE )); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GROUP_TEST_CODE ,TEST_CODE ,ORGANISM_CODE ,RESULT_COM\
MENT_DESC ,SUBSTR(MODIFIED_BY_ID,1,10) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'D\
D/MM/YY HH24:MI') \"TIME_STAMP\" ,MODIFY_LOG_SEQ_NO into :b0,:b1,:b2,:b3,:b4,:\
b5,:b6,:b7:b8  from RL_RESULT_ORGANISM_LOG where (((SPECIMEN_NO=TO_NUMBER(:b9)\
 and SEQUENCE_NO=TO_NUMBER(:b10)) and OPERATING_FACILITY_ID=:b11) and (GROUP_T\
EST_CODE=nvl(:b12,GROUP_TEST_CODE) or TEST_CODE=NVL(:b12,TEST_CODE)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1057;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&or_group_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&or_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&or_organism_code;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&or_result_comment_desc;
 sqlstm.sqhstl[3] = (unsigned int  )43;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&or_user;
 sqlstm.sqhstl[4] = (unsigned int  )33;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&or_action;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&or_time_stamp;
 sqlstm.sqhstl[6] = (unsigned int  )20;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)&tr_modify_log_seq_no_ind;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[8] = (unsigned int  )23;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[9] = (unsigned int  )12;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_test_code;
 sqlstm.sqhstl[11] = (unsigned int  )13;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_test_code;
 sqlstm.sqhstl[12] = (unsigned int  )13;
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
}



     /*-------- Added on 12-2-2004 ---------*/
	if (l_org_log_cnt1 == l_org_log_cnt2)
		get_org_seq_cnt();
    /*-------------------------------------*/

    if (OERROR)
        err_mesg("SELECT failed on DO_RESULT_ORGANISM table RL_RESULT_ORGANISM_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;

       /*  err_mesg("No Record found in RL_RESULT_ORGANISM_LOG",0,""); */

	or_group_test_code.arr[or_group_test_code.len]			= '\0'; 
	or_test_code.arr[or_test_code.len]						= '\0';  
	or_organism_code.arr[or_organism_code.len]				= '\0'; 
	or_result_comment_desc.arr[or_result_comment_desc.len]	= '\0'; 
	or_user.arr[or_user.len]								= '\0'; 
	or_action.arr[or_action.len]							= '\0'; 
	or_time_stamp.arr[or_time_stamp.len]					= '\0'; 

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:or_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:or_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 22;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CON\
VERT_TO_LOCALE_DATE ( to_date ( :or_time_stamp , 'DD/MM/YY HH24:MI' ) , :langu\
age_id , t_date ) ; :or_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1124;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&or_time_stamp;
            sqlstm.sqhstl[0] = (unsigned int  )20;
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
            sqlstm.sqhstv[2] = (         void  *)&or_time_stamp1;
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



}

do_report_organism()
{
		fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", or_action.arr, or_time_stamp1.arr, or_user.arr);
		/*fprintf(f1, "GROUP : %-10.10s  TEST : %-10.10s  ORG : %-4.4s  %-40.40s \n",
				or_group_test_code.arr, or_test_code.arr, or_organism_code.arr,
				or_result_comment_desc.arr);
		*/
		fprintf(f1, "%-6.6s: %-10.10s  %-5.5s: %-10.10s  %-4.4s: %-4.4s  %-40.40s \n",
				local_legend[23], or_group_test_code.arr, local_legend[21], or_test_code.arr, local_legend[26], or_organism_code.arr,
				or_result_comment_desc.arr);//added for globalision
		line_no++;
		chk_break(line_no);
		
		/* -------Added on 12-02-2004---------*/
		if (tr_modify_log_seq_no_ind != -1 && strcmp(or_action.arr,"M") == 0)
		{ 
		  l_org_log_cnt2 = l_org_log_cnt2 + 1;
		}
		/*------------------------------------*/
		
}


do_result_organism_dtl()
{
	od_group_test_code.arr[0]			= '\0'; 
	od_test_code.arr[0]					= '\0';  
	od_organism_code.arr[0]				= '\0';  
	od_antibiotic_group_code.arr[0]		= '\0'; 
	od_antibiotic_code.arr[0]			= '\0';	
	od_sensitivity_ind.arr[0]			= '\0'; 
	od_report_yn.arr[0]					= '\0';  
	od_user.arr[0]						= '\0';  
	od_action.arr[0]					= '\0';  
	od_time_stamp.arr[0]				= '\0'; 
	od_time_stamp1.arr[0]				= '\0'; /* Added by Durai Rajkumar against ML-SD-CRF-20241 */

	od_group_test_code.len				= 0; 
	od_test_code.len					= 0;  
	od_organism_code.len				= 0;  
	od_antibiotic_group_code.len		= 0;  
	od_antibiotic_code.len				= 0;
	od_sensitivity_ind.len				= 0; 
	od_report_yn.len					= 0;  
	od_user.len							= 0;  
	od_action.len						= 0;  
	od_time_stamp.len					= 0; 
	od_time_stamp1.len					= 0; /* Added by Durai Rajkumar against ML-SD-CRF-20241 */

	//DECODE(SENSITIVITY_IND,'S','Sensitive','R','Resistance','I','Intermediate','P','Positive','N','Negative', SENSITIVITY_IND),
	
	/* EXEC SQL 
	SELECT GROUP_TEST_CODE,
		   TEST_CODE, 
		   ORGANISM_CODE, 
		   ANTIBIOTIC_CODE,
		   ANTIBIOTIC_GROUP_CODE,
		   SENSITIVITY_IND,
		   REPORT_YN, 
		   SUBSTR(ADDED_BY_ID,1,10)"USER",
		   ACTION, 
		   TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",
		   MODIFY_LOG_SEQ_NO
	  INTO :od_group_test_code,
		   :od_test_code, 
		   :od_organism_code,
		   :od_antibiotic_code,
		   :od_antibiotic_group_code, 
		   :od_sensitivity_ind,
		   :od_report_yn, 
		   :od_user, 
		   :od_action, 
		   :od_time_stamp,
		   :tr_modify_log_seq_no INDICATOR :tr_modify_log_seq_no_ind
	  FROM RL_RESULT_ORGANISM_DTL_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND (    GROUP_TEST_CODE = nvl(:d_test_code, GROUP_TEST_CODE)
	         OR TEST_CODE  = NVL(:d_test_code, TEST_CODE )); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GROUP_TEST_CODE ,TEST_CODE ,ORGANISM_CODE ,ANTIBIOTIC\
_CODE ,ANTIBIOTIC_GROUP_CODE ,SENSITIVITY_IND ,REPORT_YN ,SUBSTR(ADDED_BY_ID,1\
,10) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'DD/MM/YY HH24:MI') \"TIME_STAMP\" ,\
MODIFY_LOG_SEQ_NO into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10:b11  from \
RL_RESULT_ORGANISM_DTL_LOG where (((SPECIMEN_NO=TO_NUMBER(:b12) and SEQUENCE_N\
O=TO_NUMBER(:b13)) and OPERATING_FACILITY_ID=:b14) and (GROUP_TEST_CODE=nvl(:b\
15,GROUP_TEST_CODE) or TEST_CODE=NVL(:b15,TEST_CODE)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1151;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&od_group_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&od_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&od_organism_code;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&od_antibiotic_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&od_antibiotic_group_code;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&od_sensitivity_ind;
 sqlstm.sqhstl[5] = (unsigned int  )15;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&od_report_yn;
 sqlstm.sqhstl[6] = (unsigned int  )4;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&od_user;
 sqlstm.sqhstl[7] = (unsigned int  )33;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&od_action;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&od_time_stamp;
 sqlstm.sqhstl[9] = (unsigned int  )20;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)&tr_modify_log_seq_no_ind;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[11] = (unsigned int  )23;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[12] = (unsigned int  )12;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[13] = (unsigned int  )5;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_test_code;
 sqlstm.sqhstl[14] = (unsigned int  )13;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&d_test_code;
 sqlstm.sqhstl[15] = (unsigned int  )13;
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



	/*-------- Added on 12-2-2004 ---------*/
	if (l_org_dtl_log_cnt1 == l_org_dtl_log_cnt2)
		get_org_dtl_seq_cnt();
    /*-------------------------------------*/ 

    if (OERROR)
        err_mesg("SELECT failed on DO_RESULT_ORGANISM_DTL table RL_RESULT_ORGANISM_DTL_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;

       /*  err_mesg("No Record found in RL_RESULT_ORGANISM_DTL_LOG",0,""); */

	od_group_test_code.arr[od_group_test_code.len]				= '\0'; 
	od_test_code.arr[od_test_code.len]							= '\0';  
	od_organism_code.arr[od_organism_code.len]					= '\0';  
	od_antibiotic_group_code.arr[od_antibiotic_group_code.len]	= '\0'; 
	od_antibiotic_code.arr[od_antibiotic_code.len]				= '\0';
	od_sensitivity_ind.arr[od_sensitivity_ind.len]				= '\0'; 
	od_report_yn.arr[od_report_yn.len]							= '\0';  
	od_user.arr[od_user.len]									= '\0';  
	od_action.arr[od_action.len]								= '\0';  
	od_time_stamp.arr[od_time_stamp.len]						= '\0'; 

/*** added for globalisation*************************************/

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				/o Commented & added by Durai Rajkumar against ML-SD-CRF-20241
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:od_time_stamp,'DD/MM/YYYY'), :language_id , t_date);
				:od_time_stamp1 := to_char(t_date,'DD/MM/YYYY');  o/
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:od_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:od_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 22;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CON\
VERT_TO_LOCALE_DATE ( to_date ( :od_time_stamp , 'DD/MM/YY HH24:MI' ) , :langu\
age_id , t_date ) ; :od_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1230;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&od_time_stamp;
            sqlstm.sqhstl[0] = (unsigned int  )20;
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
            sqlstm.sqhstv[2] = (         void  *)&od_time_stamp1;
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


			od_time_stamp1.arr[od_time_stamp1.len]				= '\0';

	if (strcmp(od_sensitivity_ind.arr,"S") == 0) 
		strcpy (od_sensitivity_ind.arr, local_legend[57]);
	else if (strcmp(od_sensitivity_ind.arr,"R") == 0) 
		strcpy (od_sensitivity_ind.arr, local_legend[58]);
	else if (strcmp(od_sensitivity_ind.arr,"I") == 0)  
		strcpy (od_sensitivity_ind.arr, local_legend[59]);
	else if (strcmp(od_sensitivity_ind.arr,"P") == 0)  
		strcpy (od_sensitivity_ind.arr, local_legend[60]);
	else if (strcmp(od_sensitivity_ind.arr,"N") == 0)  
		strcpy (od_sensitivity_ind.arr, local_legend[61]);
/*** added for globalisation*************************************/


}


do_report_organism_dtl()
{
		fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", od_action.arr, od_time_stamp1.arr, od_user.arr);
		/*fprintf(f1, "GROUP : %-10.10s  TEST : %-10.10s  ORG : %-4.4s  ANT.GROUP : %-1.1s  ANT : %-4.4s  %-12.12s REP ? %-1.1s\n",
				od_group_test_code.arr, od_test_code.arr, od_organism_code.arr,
				od_antibiotic_group_code.arr, od_antibiotic_code.arr, od_sensitivity_ind.arr, od_report_yn.arr);
		*/
		fprintf(f1, "%-6.6s: %-10.10s  %-5.5s: %-10.10s  %-4.4s: %-4.4s  %-10.10s: %-1.1s  %-4.4s: %-4.4s  %-12.12s %-4.4s? %-1.1s\n",
				local_legend[23], od_group_test_code.arr, local_legend[21], od_test_code.arr, local_legend[26], od_organism_code.arr,
				local_legend[27], od_antibiotic_group_code.arr, local_legend[28], od_antibiotic_code.arr, od_sensitivity_ind.arr, local_legend[29], od_report_yn.arr);//added for globalisation
		line_no++;
		chk_break(line_no);

		/* -------Added on 12-02-2004---------*/
		if (tr_modify_log_seq_no_ind != -1 && strcmp(od_action.arr,"M") == 0)
		{ 
		  l_org_dtl_log_cnt2 = l_org_dtl_log_cnt2 + 1;
		}
		/*------------------------------------*/

	
}

do_result_text()
{
	rt_group_test_code.arr[0]			= '\0'; 
	rt_test_code.arr[0]					= '\0';  
	rt_result_text.arr[0]				= '\0'; 
	rt_user.arr[0]						= '\0';  
	rt_action.arr[0]					= '\0';  
	rt_time_stamp.arr[0]				= '\0'; 
	rt_time_stamp1.arr[0]				= '\0';

	rt_group_test_code.len				= 0;
	rt_test_code.len					= 0; 
	rt_result_text.len					= 0;
	rt_user.len							= 0; 
	rt_action.len						= 0;
	rt_time_stamp.len					= 0;
	rt_time_stamp1.len					= 0;


	/* EXEC SQL
	SELECT GROUP_TEST_CODE, TEST_CODE, RESULT_TEXT, SUBSTR(MODIFIED_BY_ID,1,10) "USER",
		   ACTION, TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",
		   MODIFY_LOG_SEQ_NO
	  INTO :rt_group_test_code, :rt_test_code, :rt_result_text,
		   :rt_user, :rt_action, :rt_time_stamp,
		   :tr_modify_log_seq_no INDICATOR :tr_modify_log_seq_no_ind
	  FROM RL_RESULT_TEXT_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND (    GROUP_TEST_CODE = nvl(:d_test_code, GROUP_TEST_CODE)
	         OR TEST_CODE  = NVL(:d_test_code, TEST_CODE )); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GROUP_TEST_CODE ,TEST_CODE ,RESULT_TEXT ,SUBSTR(MODIF\
IED_BY_ID,1,10) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'DD/MM/YY HH24:MI') \"TIM\
E_STAMP\" ,MODIFY_LOG_SEQ_NO into :b0,:b1,:b2,:b3,:b4,:b5,:b6:b7  from RL_RESU\
LT_TEXT_LOG where (((SPECIMEN_NO=TO_NUMBER(:b8) and SEQUENCE_NO=TO_NUMBER(:b9)\
) and OPERATING_FACILITY_ID=:b10) and (GROUP_TEST_CODE=nvl(:b11,GROUP_TEST_COD\
E) or TEST_CODE=NVL(:b11,TEST_CODE)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1257;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rt_group_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rt_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rt_result_text;
 sqlstm.sqhstl[2] = (unsigned int  )4003;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rt_user;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rt_action;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rt_time_stamp;
 sqlstm.sqhstl[5] = (unsigned int  )20;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)&tr_modify_log_seq_no_ind;
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
 sqlstm.sqhstv[8] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[8] = (unsigned int  )12;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[9] = (unsigned int  )5;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_test_code;
 sqlstm.sqhstl[10] = (unsigned int  )13;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_test_code;
 sqlstm.sqhstl[11] = (unsigned int  )13;
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
}



     /*-------- Added on 12-2-2004 ---------*/
	if (l_text_log_cnt1 == l_text_log_cnt2)
		get_text_seq_cnt();
    /*-------------------------------------*/

    if (OERROR)
        err_mesg("SELECT failed on DO_RESULT_TEXT table RL_RESULT_TEXT_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;

       /*  err_mesg("No Record found in RL_RESULT_TEXT_LOG",0,""); */


	rt_group_test_code.arr[rt_group_test_code.len]			= '\0'; 
	rt_test_code.arr[rt_test_code.len]						= '\0';  
	rt_result_text.arr[rt_result_text.len]					= '\0'; 
	rt_user.arr[rt_user.len]								= '\0';  
	rt_action.arr[rt_action.len]							= '\0';  
	rt_time_stamp.arr[rt_time_stamp.len]					= '\0'; 

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				/o Commented & added by Durai Rajkumar against ML-SD-CRF-20241 
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rt_time_stamp,'DD/MM/YYYY'), :language_id , t_date);
				:rt_time_stamp1 := to_char(t_date,'DD/MM/YYYY'); o/
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rt_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:rt_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 22;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CON\
VERT_TO_LOCALE_DATE ( to_date ( :rt_time_stamp , 'DD/MM/YY HH24:MI' ) , :langu\
age_id , t_date ) ; :rt_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1320;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&rt_time_stamp;
            sqlstm.sqhstl[0] = (unsigned int  )20;
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
            sqlstm.sqhstv[2] = (         void  *)&rt_time_stamp1;
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


			rt_time_stamp1.arr[rt_time_stamp1.len]					= '\0';

	 
}


do_report_result_text()
{
		fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", rt_action.arr, rt_time_stamp1.arr, rt_user.arr);
		//fprintf(f1, "GROUP : %-10.10s  TEST : %-10.10s RESULT TEXT \n", rt_group_test_code.arr, rt_test_code.arr );
		fprintf(f1, "%-6.6s: %-10.10s  %-5.5s: %-10.10s %-12.12s :\n", 
					local_legend[23], rt_group_test_code.arr, local_legend[21], rt_test_code.arr, local_legend[30] );//added for globalisation
		line_no++;
		chk_break(line_no);

		/* to print the result text */
		//splitting(); /* Commented by Durai Rajkumar against ML-SD-CRF-20241 */
		splitting(rt_result_text.arr); /* Added by Durai Rajkumar against ML-SD-CRF-20241

		/* -------Added on 12-02-2004---------*/
////		if (tr_modify_log_seq_no_ind != -1 && strcmp(rt_action.arr,"M") == 0)
		if (tr_modify_log_seq_no_ind != -1 )
		{ 
		    l_text_log_cnt2  = l_text_log_cnt2 + 1;
		}
		/*------------------------------------*/

    
}

do_review_technical()
{
	//fprintf(f1, "TECHNICAL REVIEW\n");
	fprintf(f1, "%s\n", local_legend[31]);//added for globalisation
	fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  \n", "R", d_time_stamp.arr, d_user_id.arr);
	line_no += 2;
	chk_break(line_no);
}

do_review_abnormal()
{
	//fprintf(f1, "ABNORMAL REVIEW\n");
	fprintf(f1, "%s\n", local_legend[32]);//added for globalisation
	fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  \n", "R", d_time_stamp.arr, d_user_id.arr);
	line_no += 2;
	chk_break(line_no);
}

do_review_normal()
{
	//fprintf(f1, "NORMAL REVIEW\n");
	fprintf(f1, "%s\n", local_legend[33]);//added for globalisation
	fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  \n", "R", d_time_stamp.arr, d_user_id.arr);
	line_no += 2;
	chk_break(line_no);
}

do_ca_review_log()
{
	//fprintf(f1, "CLINICIAN REVIEW\n");
	fprintf(f1, "%s\n", local_legend[34]);//added for globalisation

	strcpy(ca_str1, "");
	strcpy(ca_str, "");

	if (strcmp(ca_review_type.arr, "O") == 0)
	{
		//strcpy(ca_str1, "ORD DOCTOR : ");
		strcpy(ca_str1, local_legend[35]); //added for globalisation

	}
	else
	{
		//strcpy(ca_str1, "ATT DOCTOR : ");
		strcpy(ca_str1, local_legend[36]); //added for globalisation
	}

	
	/*sprintf(ca_str, "R/%-14.14s   TEST : %-30.30s   %s%s"  ,  ca_reviewed_date.arr,  ca_test_code.arr,
					ca_str1, am_practitioner_name.arr);
	*/
	sprintf(ca_str, "R/%-14.14s   %-5.5s: %-30.30s   %s :%s"  ,  ca_reviewed_date1.arr, local_legend[21], ca_test_code.arr,
					ca_str1, am_practitioner_name.arr);//added for globalisation
	
	fprintf(f1, "%s\n", ca_str);

	line_no += 2;

}

do_ca_review_log_same_doctor()
{
	
	
	//sprintf(ca_str, "  %-14.14s   TEST : %-10.10s		"  ,  " ",  ca_test_code.arr);
	sprintf(ca_str, "  %-14.14s   %-5.5s: %-10.10s		"  ,  " ", local_legend[21], ca_test_code.arr);//added for globalisation

	fprintf(f1, "%s\n", ca_str);

	line_no += 1;

}

/* ---------------- code added for KN ENHANCEMENT ------------------------------ */

do_clinical_history()
{
	ch_clinical_text_code.arr[0]		= '\0'; 
	ch_clinical_text.arr[0]             = '\0';
	ch_user.arr[0]						= '\0';  
	ch_action.arr[0]					= '\0';  
	ch_time_stamp.arr[0]				= '\0'; 
	
	ch_clinical_text_code.len		= 0; 
	ch_clinical_text.len            = 0;
	ch_user.len					= 0;  
	ch_action.len   				= 0;  
	ch_time_stamp.len    			= 0; 
	

	/* EXEC SQL
	SELECT CLINICAL_TEXT_CODE, CLINICAL_TEXT, SUBSTR(MODIFIED_BY_ID,1,10) "USER",
		   ACTION, TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP"
	  INTO :ch_clinical_text_code, :ch_clinical_text,
		   :ch_user, :ch_action, :ch_time_stamp
	  FROM RL_PATIENT_CLINICAL_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CLINICAL_TEXT_CODE ,CLINICAL_TEXT ,SUBSTR(MODIFIED_BY\
_ID,1,10) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'DD/MM/YY HH24:MI') \"TIME_STAM\
P\" into :b0,:b1,:b2,:b3,:b4  from RL_PATIENT_CLINICAL_LOG where ((SPECIMEN_NO\
=TO_NUMBER(:b5) and SEQUENCE_NO=TO_NUMBER(:b6)) and OPERATING_FACILITY_ID=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1347;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ch_clinical_text_code;
 sqlstm.sqhstl[0] = (unsigned int  )8;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ch_clinical_text;
 sqlstm.sqhstl[1] = (unsigned int  )4003;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ch_user;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ch_action;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&ch_time_stamp;
 sqlstm.sqhstl[4] = (unsigned int  )20;
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
 sqlstm.sqhstv[6] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[6] = (unsigned int  )12;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[7] = (unsigned int  )5;
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



    if (OERROR)
        err_mesg("SELECT failed on DO_CLINICAL_HISTORY table RL_PATIENT_CLINICAL_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;

       /*  err_mesg("No Record found in RL_PATIENT_CLINICAL_LOG",0,""); */


	ch_clinical_text_code.arr[ch_clinical_text_code.len]    = '\0'; 
	ch_clinical_text.arr[ch_clinical_text.len]              = '\0';
	ch_user.arr[ch_user.len]								= '\0';  
	ch_action.arr[ch_action.len]							= '\0';  
	ch_time_stamp.arr[ch_time_stamp.len]					= '\0'; 
 
    /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:ch_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
			:ch_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
		END;
	END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_\
LOCALE_DATE ( to_date ( :ch_time_stamp , 'DD/MM/YY HH24:MI' ) , :language_id ,\
 t_date ) ; :ch_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' ) ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1394;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&ch_time_stamp;
    sqlstm.sqhstl[0] = (unsigned int  )20;
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
    sqlstm.sqhstv[2] = (         void  *)&ch_time_stamp1;
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



}


do_report_clinical_history()
{

		if (strcmp(clinical_prev_time_stamp, ch_time_stamp.arr) == 0 &&
			strcmp(clinical_prev_user_id, ch_user.arr) == 0 &&
			strcmp(clinical_prev_action, ch_action.arr) == 0)
		{
		}
		else
		{

				//fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", ch_action.arr, ch_time_stamp.arr, ch_user.arr);
				fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", ch_action.arr, ch_time_stamp1.arr, ch_user.arr);
				//fprintf(f1, "CLINICAL HISTORY :  \n");
				fprintf(f1, "%s :  \n",local_legend[37]);//added for globalisation
				line_no++;
				chk_break(line_no);
				strcpy(clinical_prev_time_stamp, ch_time_stamp.arr);
				strcpy(clinical_prev_user_id, ch_user.arr);
				strcpy(clinical_prev_action, ch_action.arr);
		}


		/* to print the clinical history  */
		
				ctr = 0;
				r_ctr = 0;
	
		len = strlen(ch_clinical_text.arr);

		split_text(ch_clinical_text.arr, 80, l_string, &r_ctr);
		chk_break(1);
		fprintf(f1,"                             %s\n",l_string);
		
		line_no++;
        strcpy(l_string,"");   
		while(r_ctr < len)
		{	
			chk_break(1);
			split_text(ch_clinical_text.arr, 80, l_string, &r_ctr);
			fprintf(f1,"                             %s\n",l_string);
		    strcpy(l_string,"");  
			line_no++;

		}

}


do_ole_result()
{
	ot_group_test_code.arr[0]			= '\0'; 
	ot_test_code.arr[0]			= '\0'; 
	ot_template.arr[0]	= '\0'; 
	ot_user.arr[0]				= '\0'; 
	ot_action.arr[0]			= '\0'; 
	ot_time_stamp.arr[0]		= '\0'; 
	
	ot_group_test_code.len			= 0; 
	ot_test_code.len			= 0; 
	ot_template.len		= 0; 
	ot_user.len					= 0;  
	ot_action.len				= 0;  
	ot_time_stamp.len			= 0;  
	

	/* EXEC SQL 
	SELECT GROUP_TEST_CODE,TEST_CODE, TEMPLATE_NAME,
		SUBSTR(modified_by_id, 1, 10) "USER",
		   ACTION, TO_CHAR(TIME_STAMP, 'DD/MM/YY HH24:MI')"TIME_STAMP",
		   MODIFY_LOG_SEQ_NO
	  INTO :ot_group_test_code,:ot_test_code, :ot_template,
		   :ot_user, :ot_action, :ot_time_stamp,
		   :tr_modify_log_seq_no INDICATOR :tr_modify_log_seq_no_ind
	  FROM RL_OLE_RESULT_TEXT_LOG
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND (    GROUP_TEST_CODE = nvl(:d_test_code, GROUP_TEST_CODE)
	         OR TEST_CODE  = NVL(:d_test_code, TEST_CODE )); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GROUP_TEST_CODE ,TEST_CODE ,TEMPLATE_NAME ,SUBSTR(mod\
ified_by_id,1,10) \"USER\" ,ACTION ,TO_CHAR(TIME_STAMP,'DD/MM/YY HH24:MI') \"T\
IME_STAMP\" ,MODIFY_LOG_SEQ_NO into :b0,:b1,:b2,:b3,:b4,:b5,:b6:b7  from RL_OL\
E_RESULT_TEXT_LOG where (((SPECIMEN_NO=TO_NUMBER(:b8) and SEQUENCE_NO=TO_NUMBE\
R(:b9)) and OPERATING_FACILITY_ID=:b10) and (GROUP_TEST_CODE=nvl(:b11,GROUP_TE\
ST_CODE) or TEST_CODE=NVL(:b11,TEST_CODE)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1421;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ot_group_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ot_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ot_template;
 sqlstm.sqhstl[2] = (unsigned int  )18;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ot_user;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&ot_action;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&ot_time_stamp;
 sqlstm.sqhstl[5] = (unsigned int  )20;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)&tr_modify_log_seq_no_ind;
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
 sqlstm.sqhstv[8] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[8] = (unsigned int  )12;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[9] = (unsigned int  )5;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_test_code;
 sqlstm.sqhstl[10] = (unsigned int  )13;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_test_code;
 sqlstm.sqhstl[11] = (unsigned int  )13;
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
}



	/*-------- Added on 12-2-2004 ---------*/
	if (l_ole_log_cnt1 == l_ole_log_cnt2)
		get_ole_seq_cnt();
    /*-------------------------------------*/

    if (OERROR)
        err_mesg("SELECT failed on DO_OLE_RESULT table RL_OLE_RESULT_TEXT_LOG ",0,"");

    if (NODATAFOUND)
		print_rec = 0;
	else
		print_rec = 1;
    
	   /* err_mesg("No Record found in RL_OLE_RESULT_TEXT_LOG",0,""); */

	ot_test_code.arr[ot_test_code.len]			 = '\0'; 
	ot_template.arr[ot_template.len] = '\0'; 
	ot_user.arr[ot_user.len]					 = '\0'; 
	ot_action.arr[ot_action.len]				 = '\0'; 
	ot_time_stamp.arr[ot_time_stamp.len]		 = '\0'; 
	

	strcpy(nd_test_code.arr, ot_test_code.arr);
	nd_test_code.len = strlen(nd_test_code.arr);

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:ot_time_stamp,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:ot_time_stamp1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 22;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CON\
VERT_TO_LOCALE_DATE ( to_date ( :ot_time_stamp , 'DD/MM/YY HH24:MI' ) , :langu\
age_id , t_date ) ; :ot_time_stamp1 := to_char ( t_date , 'DD/MM/YY HH24:MI' )\
 ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )1484;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&ot_time_stamp;
            sqlstm.sqhstl[0] = (unsigned int  )20;
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
            sqlstm.sqhstv[2] = (         void  *)&ot_time_stamp1;
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




}


do_report_ole_result()
{
	    do_test_desc();

		fprintf(f1, "%-1.1s/%-14.14s/%-10.10s  ", ot_action.arr, ot_time_stamp1.arr, ot_user.arr);
		/*fprintf(f1, "GROUP : %-11.11s TEST : %-11.11s WP DOCUMENT : %-15.15s  \n",
				 ot_group_test_code.arr, nd_test_desc.arr, ot_template.arr);
		*/
		fprintf(f1, "%-6.6s: %-11.11s %-5.5s: %-11.11s %-12.12: %-15.15s  \n",
				 local_legend[23], ot_group_test_code.arr, local_legend[21], nd_test_desc.arr, local_legend[38], ot_template.arr);//added for globalisation
		line_no++;
		chk_break(line_no);
		
		/* -------Added on 12-02-2004---------*/
		if (tr_modify_log_seq_no_ind != -1 && strcmp(ot_action.arr,"M") == 0)
		{ 
		    l_ole_log_cnt2  = l_ole_log_cnt2 + 1;
		}
		/*------------------------------------*/
}


/* ----------------------- end of code added by Ananthi on 12/06/2002 -----------------------*/

/*
do_group_desc()
{
	nd_group_desc.arr[0] = '\0';
	nd_group_desc.len = 0;

	EXEC SQL
	SELECT LONG_DESC
	  INTO :nd_group_desc
	  FROM RL_TEST_CODE_lang_vw
	 WHERE TEST_CODE = :nd_group_code
	 and language_id = :language_id;

   if (OERROR)
        err_mesg("SELECT failed on DO_GROUP_DESC table RL_TEST_CODE ",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in RL_TEST_CODE",0,"");

	nd_group_desc.arr[nd_group_desc.len] = '\0';
} */


do_test_desc()
{
	nd_test_desc.arr[0] = '\0';
	nd_test_desc.len = 0;

	/* EXEC SQL
	SELECT LONG_DESC 
	  INTO :nd_test_desc
	  FROM RL_TEST_CODE_lang_vw
	 WHERE TEST_CODE = :nd_test_code
	 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from RL_TEST_CODE_lang_vw where (\
TEST_CODE=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1511;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_test_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
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



	if (OERROR)
	    err_mesg("SELECT failed on DO_TEST_DESC table RL_TEST_CODE ",0,"");

    if (NODATAFOUND)
		err_mesg("No Record found in RL_TEST_CODE",0,""); 

	nd_test_desc.arr[nd_test_desc.len] = '\0';
}

do_snomed_desc()
{
	nd_snomed_desc.arr[0] = '\0';
	nd_snomed_desc.len = 0;
	
	/* EXEC SQL 
	SELECT DESCRIPTION_1
	  INTO :nd_snomed_desc
	  FROM RL_SNOMED_CODE_lang_vw
	 WHERE SNOMED_CODE = :nd_snomed_code
	 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DESCRIPTION_1 into :b0  from RL_SNOMED_CODE_lang_vw w\
here (SNOMED_CODE=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1538;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_snomed_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_snomed_code;
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



	if (OERROR)
        err_mesg("SELECT failed on DO_SNOMED_DESC table RL_SNOMED_CODE ",0,"");

    if (NODATAFOUND)
		err_mesg("No Record found in RL_SNOMED_CODE",0,""); 

    nd_snomed_desc.arr[nd_snomed_desc.len] = '\0';
	 
	  	
}

// -------------   added on 07.10.2002  --------------

do_snomed_desc2()
{
	nd_snomed_desc2.arr[0] = '\0';
	nd_snomed_desc2.len = 0;
	
	/* EXEC SQL 
	SELECT DESCRIPTION_1
	  INTO :nd_snomed_desc2
	  FROM RL_SNOMED_CODE_lang_vw
	 WHERE SNOMED_CODE = :nd_snomed_code2
	 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DESCRIPTION_1 into :b0  from RL_SNOMED_CODE_lang_vw w\
here (SNOMED_CODE=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1565;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_snomed_desc2;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_snomed_code2;
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



	if (OERROR)
        err_mesg("SELECT failed on DO_SNOMED_DESC table RL_SNOMED_CODE ",0,"");

    if (NODATAFOUND)
		err_mesg("No Record found in RL_SNOMED_CODE",0,""); 

    nd_snomed_desc2.arr[nd_snomed_desc2.len] = '\0';
	 
	  	
}

//  -------------- upto here --------------

do_spec_desc()
{
	nd_spec_desc.arr[0] = '\0';
	nd_spec_desc.len = 0;

    if (strcmp(nd_spec_code.arr, "\0") == 0 )
	{
		strcpy(nd_spec_desc.arr, ".");
		nd_spec_desc.len = strlen(nd_spec_desc.arr);
	}
	else
	{
	   /* EXEC SQL
	   SELECT SPECIMEN_DESC
	     INTO :nd_spec_desc
	     FROM RL_SPECIMEN_TYPE_CODE_lang_vw
	    WHERE SPECIMEN_TYPE_CODE = :nd_spec_code
		and language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SPECIMEN_DESC into :b0  from RL_SPECIMEN_TYPE_CODE\
_lang_vw where (SPECIMEN_TYPE_CODE=:b1 and language_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1592;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_spec_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_code;
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
}



       if (OERROR)
        err_mesg("SELECT failed on DO_SPEC_DESC table RL_SPECIMEN_TYPE_CODE ",0,"");

       if (NODATAFOUND)
			err_mesg("No Record found in RL_SPECIMEN_TYPE_CODE",0,"");

	   nd_spec_desc.arr[nd_spec_desc.len] = '\0';
	}
}
  

get_cancel_desc()
{
	rd_cancel_desc.arr[0] = '\0';
	rd_cancel_desc.len = 0;

	/* EXEC SQL
	SELECT LONG_DESC
	  INTO :rd_cancel_desc
	  FROM RL_CANCELLATION_CODE_lang_vw
	 WHERE CANCEL_CODE = :rd_cancel_code
	 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from RL_CANCELLATION_CODE_lang_vw\
 where (CANCEL_CODE=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1619;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rd_cancel_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rd_cancel_code;
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
}



   if (OERROR)
        err_mesg("SELECT failed on GET_CANCEL_DESC table RL_CANCELLATION_CODE ",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in RL_CANCELLATION_CODE",0,"");

	rd_cancel_desc.arr[rd_cancel_desc.len] = '\0';
} 


chk_break(nol)
{
	//if((line_no + 1) >= 56) ML-SD-SCF-1851
	//if((line_no + 1) >= 46) //ML-SD-SCF-1851		
	  if((line_no + 1) >= 43) //ML-SD-SCF-2182		
	{
       line_no = 1;
	   fprintf(f1, "\f");
	   form_hdr();
	   do_form_title();
 	}
}

form_hdr()
{

    static int first = 1;
    char buf[15];
    int col;

    if(first)
	 {
 /*       memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL : RL",8);
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));
        col = (REP_WIDTH-(strlen(rep_date.arr)+3));
        strcpy(hdr_line1+col,rep_date.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);
*/
		memset(hdr_line1,' ',REP_WIDTH+1);
		strncpy(hdr_line1,"MDL : RL",8);
		col = (int)(REP_WIDTH - strlen(comp_name.arr))/2;
		strncpy(hdr_line1 + col -1,comp_name.arr,strlen(comp_name.arr));
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
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET\
_CURRENT_DATE ( :language_id ) ; :rep_date1 := to_char ( t_date , 'DD/MM/YYYY \
HH24:MI' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1646;
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
		/* strcpy(hdr_line1+col+1,rep_date1.arr); -- Commented by Durai Rajkumar against ML-SD-CRF-20241 */
		strcpy(hdr_line1+col,rep_date1.arr); /* Added by Durai Rajkumar against ML-SD-CRF-20241 */
     }
		fprintf(f1,"\n");	
		fprintf(f1,hdr_line1);
		fprintf(f1,"\n");	

	memset(hdr_line2,' ',REP_WIDTH+1);
    strncpy(hdr_line2,"OPR :",5);
    strcpy(hdr_line2+6,oper_id.arr);
	fprintf(f1,hdr_line2);
	fprintf(f1,"\n");	

	memset(hdr_line3,' ',REP_WIDTH+1);
    strncpy(hdr_line3,"REP : RLRWHODT",14);
	strcpy(rep_title1, local_legend[50] );
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"%s : %4d",local_legend[49],page_no++);
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);
	fprintf(f1,hdr_line3);
	fprintf(f1,"\n");	

	memset(hdr_line5,'-',REP_WIDTH);
	fprintf(f1,"%s\n",hdr_line5);


/*    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRWHODT",14);
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"PAGE : %4d",page_no++);
    strcpy(hdr_line3+(REP_WIDTH-(strlen(buf)+5)),buf);

      
    fprintf(f1,"\n%s\n",hdr_line1);
    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
	fprintf(f1,"%s\n",hdr_line5);
*/
//	line_no += 4;
	line_no += 5; /* added on 30/01/2008 against scf 2182 */
	first = 0;
   }
 
do_form_title()
{

   /* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_dob,'DD/MM/YYYY'), :language_id , t_date);
		:d_dob1 := to_char(t_date,'DD/MM/YYYY');
	END;
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :d_dob , 'DD/MM/YYYY' ) , :language_id , t_date ) ; :d_\
dob1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1669;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_dob;
   sqlstm.sqhstl[0] = (unsigned int  )14;
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
   sqlstm.sqhstv[2] = (         void  *)&d_dob1;
   sqlstm.sqhstl[2] = (unsigned int  )14;
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





	if (ol_order_id_ind != -1)  
	{
///03.07.2006 fprintf(f1,"ORDER ID    : %-15.15s ORDER REG. BY : %-50.50sORDER START DATE : %-16.16s\n\n",ol_order_id.arr,ol_order_regd_by.arr,ol_order_start_date.arr);	
		//fprintf(f1,"ORDER ID    : %-15.15s ORDER REG. BY : %-50.50s  ORDER DATE : %-16.16s\n\n",ol_order_id.arr,ol_order_regd_by.arr,ol_order_date_time.arr);	
		fprintf(f1,"%-12.12s: %-15.15s %-14.14s: %-50.50s  %-11.11s: %-16.16s\n\n",
		local_legend[39], ol_order_id.arr,local_legend[40], ol_order_regd_by.arr,local_legend[41], ol_order_date_time1.arr);	//added for globalisation
		line_no += 2;
	}

	l_delimeter = ' ';
	rl_split_text(d_patient_name.arr,l_delimeter,l_len,d_patient_name_1.arr,
	              d_patient_name_2.arr,d_patient_name_3.arr,d_patient_name_4.arr);

	/*fprintf(f1, "SPECIMEN NO : %-15.15s PATIENT ID    : %-20.20s NAME : %-32.32s   AGE : %-11.11s\n",
				 d_specimen_no.arr, d_patient_id.arr, d_patient_name_1.arr, d_pat_age);
	*/
	fprintf(f1, "%-12.12s: %-15.15s %-14.14s: %-20.20s %-5.5s: %-32.32s   %-4.4s: %-11.11s\n",
				 local_legend[42], nd_specimen_no.arr, local_legend[43], d_patient_id.arr, local_legend[44], d_patient_name_1.arr, local_legend[45], d_pat_age);//added for globalisation
	fprintf(f1, "%-73.73s %-32.32s\n"," ",d_patient_name_2.arr);
	//fprintf(f1, "%-67.67s SEX : %-6.6s %-27.27s DOB : %-10.10s\n"," ",d_sex.arr, " ",d_dob.arr);
	fprintf(f1, "%-67.67s %-4.4s: %-6.6s %-27.27s %-4.4s: %-10.10s\n"," ",local_legend[46], d_sex.arr, " ",local_legend[47], d_dob1.arr);
	fprintf(f1,"%s\n",hdr_line5);
//	line_no += 3;
	line_no += 4; /* added on 30/01/2008 against scf 2182 */
}


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
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1696;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )102;
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
    sqlstm.sqhstl[2] = (unsigned int  )33;
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

/*** Commented by Durai Rajkumar against ML-SD-CRF-20241
splitting()
{
   	char word[2];
	int 	textlen = 0, z = 0, clt = 0, cntr = 1, qq = 0, cmp = 0;
	char word1[2];
	strcpy(word1,"F");
 
    textlen  = strlen(rt_result_text.arr);

     
         while(z<textlen)
         {
		 		  	
		 
             word[0] = rt_result_text.arr[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
   		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		     }


  		      if(cntr >= 71)
		      {
		   	
			     cmp = cntr;
			     while((rt_result_text.arr[z] != 32) && (cmp > 1))
			     {

			         z--;
				     cmp--;
				  
			      }

				  qq = z;
				  			   
			      word[0] = rt_result_text.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			   
		
		       }


				if (((z == textlen) || (z == textlen - 1)) && (strcmp(word1,"F") == 0))
				{
	
				   fprintf(f1, "%-44.44s", " ");				   
				   for(i=clt;i < z + 1;i++)
		           {
		              fprintf(f1,"%c",rt_result_text.arr[i]);
				   }
			       fprintf(f1,"\n");
			  	   line_no++;
				   chk_break(line_no);

				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
				}

			
		       if (strcmp(word1,"N") == 0) 
		       {
				
				  fprintf(f1, "%-44.44s", " ");				   
		          for(i=clt;i<=qq;i++)
		          {
			         fprintf(f1,"%c",rt_result_text.arr[i]);
					
			      }
				   line_no++;          //SD-CRF-20064  SPLITTING PROBLEM
				   chk_break(line_no); //SD-CRF-20064 SPLITTING PROBLEM

			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		       if (strcmp(word1,"T") == 0)
		       {

			      fprintf(f1, "%-44.44s", " ");				   
									 
			      for(i=clt;i<= qq;i++)
		          {
		             fprintf(f1,"%c",rt_result_text.arr[i]);
				
			      }

			       fprintf	(f1,"\n");
				   line_no++;
				   chk_break(line_no);

			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }


		        if (strcmp(word1,"W") == 0)
		        {
		 										 
				   fprintf(f1, "%-44.44s", " ");				   
			       for(i=clt;i < clt + 70;i++)
		           {
		              fprintf(f1,"%c",rt_result_text.arr[i]);
				
			       }

			       fprintf(f1,"\n");
				   line_no++;
				   chk_break(line_no);

				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

		    cntr += 1;
	        z++ ;
          }

		
}
*** Ends against ML-SD-CRF-20241  ***/

/* Added by Durai Rajkumar against ML-SD-CRF-20241 */
splitting(lv_result_text)

char lv_result_text[4001];    	    
{
    
	char word[2];
	int 	textlen = 0, z = 0, clt = 0, cntr = 1, qq = 0, cmp = 0;
	char word1[2];


	strcpy(word1,"F");

  
	textlen  = strlen(lv_result_text);

     
         while(z<textlen)
         {
		 		  	
		 
             word[0] = lv_result_text[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
   		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		     }


  		      if(cntr >= 71)
		      {
		   	
			     cmp = cntr;
			     while((lv_result_text[z] != 32) && (cmp > 1))
			     {

			         z--;
				     cmp--;
				  
			      }

				  qq = z;
				  			   
			      word[0] = lv_result_text[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			   
		
		       }


				if (((z == textlen) || (z == textlen - 1)) && (strcmp(word1,"F") == 0))
				{
	
				   fprintf(f1, "%-44.44s", " ");				   
				   for(i=clt;i < z + 1;i++)
		           {
		              fprintf(f1,"%c",lv_result_text[i]);
				   }
			       fprintf(f1,"\n");
			  	   line_no++;
				   chk_break(line_no);

				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
				}

			
		       if (strcmp(word1,"N") == 0) 
		       {
				
				  fprintf(f1, "%-44.44s", " ");				   
		          for(i=clt;i<=qq;i++)
		          {
			         fprintf(f1,"%c",lv_result_text[i]);
					
			      }
				   line_no++;          //SD-CRF-20064  SPLITTING PROBLEM
				   chk_break(line_no); //SD-CRF-20064 SPLITTING PROBLEM

			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		       if (strcmp(word1,"T") == 0)
		       {

			      fprintf(f1, "%-44.44s", " ");				   
									 
			      for(i=clt;i<= qq;i++)
		          {
		             fprintf(f1,"%c",lv_result_text[i]);
				
			      }

			       fprintf	(f1,"\n");
				   line_no++;
				   chk_break(line_no);

			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }


		        if (strcmp(word1,"W") == 0)
		        {
		 										 
				   fprintf(f1, "%-44.44s", " ");				   
			       for(i=clt;i < clt + 70;i++)
		           {
		              fprintf(f1,"%c",lv_result_text[i]);
				
			       }

			       fprintf(f1,"\n");
				   line_no++;
				   chk_break(line_no);

				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

		    cntr += 1;
	        z++ ;
          }

		
}

/* Ends against ML-SD-CRF-20241 */

splitting_remarks()  //SD-CRF-20064----new
{
   	char word[2];
	int 	textlen = 0, z = 0, clt = 0, cntr = 1, qq = 0, cmp = 0;
	char word1[2];
    strcpy(word1,"F");

    textlen  = strlen(rd_cancel_remarks.arr);

     
         while(z<textlen)
         {
		 		  	
		 
             word[0] = rd_cancel_remarks.arr[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
   		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		     }


  		      if(cntr >= 71)
		      {
		   	
			     cmp = cntr;
			     while((rd_cancel_remarks.arr[z] != 32) && (cmp > 1))
			     {

			         z--;
				     cmp--;
				  
			      }

				  qq = z;
				  			   
			      word[0] = rd_cancel_remarks.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			   
		
		       }


				if (((z == textlen) || (z == textlen - 1)) && (strcmp(word1,"F") == 0))
				{
	
				   fprintf(f1, "%-44.44s", " ");				   
				   for(i=clt;i < z + 1;i++)
		           {
		              fprintf(f1,"%c",rd_cancel_remarks.arr[i]);
				   }
			       fprintf(f1,"\n");
			  	   line_no++;
				   chk_break(line_no);

				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
				}

			
		       if (strcmp(word1,"N") == 0) 
		       {
				
				  fprintf(f1, "%-44.44s", " ");				   
		          for(i=clt;i<=qq;i++)
		          {
			         fprintf(f1,"%c",rd_cancel_remarks.arr[i]);
					
			      }
   			      line_no++;          //SD-CRF-20064  SPLITTING PROBLEM
			      chk_break(line_no); //SD-CRF-20064 SPLITTING PROBLEM
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		       if (strcmp(word1,"T") == 0)
		       {

			      fprintf(f1, "%-44.44s", " ");				   
									 
			      for(i=clt;i<= qq;i++)
		          {
		             fprintf(f1,"%c",rd_cancel_remarks.arr[i]);
				
			      }

			       fprintf	(f1,"\n");
				   line_no++;
				   chk_break(line_no);

			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }


		        if (strcmp(word1,"W") == 0)
		        {
		 										 
				   fprintf(f1, "%-44.44s", " ");				   
			       for(i=clt;i < clt + 70;i++)
		           {
		              fprintf(f1,"%c",rd_cancel_remarks.arr[i]);
				
			       }

			       fprintf(f1,"\n");
				   line_no++;
				   chk_break(line_no);

				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

		    cntr += 1;
	        z++ ;
          }

		
}

   

check_cancelled_yn()
{

	rd_cancelled_yn.arr[0]	=	'\0';
	rd_cancelled_yn.len		= 0;

	rd_cancel_code.arr[0]	= '\0';
	rd_cancel_code.len		= 0;

	/* EXEC SQL SELECT NVL(cancelled_yn, 'N'), cancel_code
			 INTO :rd_cancelled_yn, :rd_cancel_code
			 FROM RL_REQUEST_DETAIL
			 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND test_code = :nd_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(cancelled_yn,'N') ,cancel_code into :b0,:b1  from\
 RL_REQUEST_DETAIL where ((specimen_no=TO_NUMBER(:b2) and OPERATING_FACILITY_I\
D=:b3) and test_code=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1731;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rd_cancelled_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rd_cancel_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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
 sqlstm.sqhstv[4] = (         void  *)&nd_test_code;
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



	rd_cancelled_yn.arr[rd_cancelled_yn.len]	= '\0';
	rd_cancel_code.arr[rd_cancel_code.len]		= '\0';

}

get_cancel_remarks()//SD-CRF-20064 ---new
{

	rd_cancel_remarks.arr[0]	=	'\0';
	rd_cancel_remarks.len		= 0;

	/* EXEC SQL SELECT NVL(cancel_remarks, '!!')
			 INTO :rd_cancel_remarks
			 FROM RL_REQUEST_DETAIL
			 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND test_code = :nd_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(cancel_remarks,'!!') into :b0  from RL_REQUEST_DE\
TAIL where ((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and tes\
t_code=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1766;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rd_cancel_remarks;
 sqlstm.sqhstl[0] = (unsigned int  )202;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_test_code;
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



	rd_cancel_remarks.arr[rd_cancel_remarks.len]	= '\0';

}




/*-------------------  code added for KN ENHANCEMENT ------------------------- */
do_clinic_hist()
{
	
  
   /* EXEC SQL DECLARE SEQ_CURSOR1 CURSOR FOR
			 SELECT sequence_no, 
					specimen_no, 
					ltrim(rtrim(upper(log_table_name))),
					to_char(time_stamp,'dd/mm/yy hh24:mi'),
					user_id
			   FROM rl_specimen_log
			  WHERE SPECIMEN_NO = TO_NUMBER(:nd_specimen_no)
			  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			  ORDER BY sequence_no; */ 


	/* EXEC SQL OPEN SEQ_CURSOR1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0044;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1797;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_specimen_no;
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
		err_mesg("OPEN failed on cursor SEQ_CURSOR",0,"");

	while(fetch_seq_cur1())
	{	
    
		if (strcmp(d_log_table_name.arr, "RL_PATIENT_CLINICAL_LOG") == 0)

	    {
		     print_rec = 0;
		
			do_clinical_history();
			if ( print_rec > 0 )
			   do_report_clinical_history();    
	
		}
	
	}
		fprintf(f1, "\n");
		line_no++;

	/* EXEC SQL CLOSE seq_cursor1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1820;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

fetch_seq_cur1()
{
  d_sequence_no.arr[0]		= '\0';
  d_specimen_no.arr[0]		= '\0';
  d_log_table_name.arr[0]	= '\0';
  d_time_stamp.arr[0]		= '\0';
  d_user_id.arr[0]			= '\0';
  
  d_sequence_no.len			= 0;
  d_specimen_no.len			= 0;
  d_log_table_name.len		= 0;
  d_time_stamp.len			= 0;
  d_user_id.len				= 0;
 
  /* EXEC SQL FETCH SEQ_CURSOR1 INTO :d_sequence_no, 
								 :d_specimen_no,
								 :d_log_table_name,
								 :d_time_stamp,
								 :d_user_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1835;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_sequence_no;
  sqlstm.sqhstl[0] = (unsigned int  )12;
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
  sqlstm.sqhstv[2] = (         void  *)&d_log_table_name;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_time_stamp;
  sqlstm.sqhstl[3] = (unsigned int  )20;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_user_id;
  sqlstm.sqhstl[4] = (unsigned int  )33;
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
    	return 0; 
    			
  if (NODATAFOUND)
       return 0;

  d_sequence_no.arr[d_sequence_no.len] = '\0';
  d_specimen_no.arr[d_specimen_no.len] = '\0';
  d_log_table_name.arr[d_log_table_name.len] = '\0';
  d_time_stamp.arr[d_time_stamp.len]		 = '\0';
  d_user_id.arr[d_user_id.len]				 = '\0';
   
  return 1;
}
/* ------------------------- --------------------------------*/
get_category_yn()
{
	
	d_category_yn.arr[0]		= '\0';
	d_category_yn.len			= 0;

	/* EXEC SQL SELECT NVL(category_used_yn, 'N') 
			 INTO :d_category_yn
			 FROM RL_SECTION_CTL
			 WHERE section_code = :d_section_code
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(category_used_yn,'N') into :b0  from RL_SECTION_C\
TL where (section_code=:b1 and OPERATING_FACILITY_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1870;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_category_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
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



	
	d_category_yn.arr[d_category_yn.len]		= '\0';


}
/* ------------------------- --------------------------------*/
get_category()
{

	d_category.arr[0]			= '\0';
	d_category.len				= 0;

	/* EXEC SQL SELECT category_code || '/' || category_year || '/' ||
					category_number
			 INTO :d_category
			 FROM RL_REQUEST_HEADER
			 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ((((category_code||'/')||category_year)||'/')||catego\
ry_number) into :b0  from RL_REQUEST_HEADER where (specimen_no=TO_NUMBER(:b1) \
and OPERATING_FACILITY_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1897;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_category;
 sqlstm.sqhstl[0] = (unsigned int  )52;
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


			 
	d_category.arr[d_category.len]		= '\0';	 
}		
/* ------------------------- end of code added --------------------------------*/

/* --added on 29/10/2003----------------------- --------------------------------*/
decl_ca_review_details()
{
   /* DECLARE CURSOR FOR CA_RESULT_REVIEW_DONE_LOG */
  
  
   /* EXEC SQL DECLARE ca_review_log CURSOR FOR
			 SELECT test_code, TO_CHAR(created_date_time, 'DD/MM/YY HH24:MI'),
					review_done_by, TO_CHAR(reviewed_date_time, 'DD/MM/YY HH24:MI'),
					 review_type
			   FROM RL_CA_RES_REVIEW_DONE_LOG
			   WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
			   AND SEQUENCE_NO	= TO_NUMBER(:d_sequence_no)
			   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			   ORDER BY sequence_no; */ 


	/* EXEC SQL OPEN ca_review_log; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0047;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1924;
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
 sqlstm.sqhstv[1] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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



	if(OERROR)
	{
        disp_message(ORA_MESG,"Error occured in open_ca_review_details");
    }


}
/* ------------------------- --------------------------------*/
fetch_ca_review_details()
{
  ca_test_code.arr[0]		= '\0';
  ca_created_date.arr[0]	= '\0';
  ca_review_done_by.arr[0]	= '\0';
  ca_reviewed_date.arr[0]	= '\0';
  ca_review_type.arr[0]		= '\0';

  ca_test_code.len			= 0;
  ca_created_date.len		= 0;
  ca_review_done_by.len		= 0;
  ca_reviewed_date.len		= 0;
  ca_review_type.len		= 0;

  /* EXEC SQL FETCH ca_review_log INTO :ca_test_code,
								 :ca_created_date,
								 :ca_review_done_by,
								 :ca_reviewed_date,
								 :ca_review_type; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1951;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&ca_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&ca_created_date;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&ca_review_done_by;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&ca_reviewed_date;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&ca_review_type;
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
    	return 0; 
    			
  if (NODATAFOUND)
       return 0;

  ca_test_code.arr[ca_test_code.len]			= '\0';
  ca_created_date.arr[ca_created_date.len]		= '\0';
  ca_review_done_by.arr[ca_review_done_by.len]  = '\0';
  ca_reviewed_date.arr[ca_reviewed_date.len]	= '\0';
  ca_review_type.arr[ca_review_type.len]		= '\0';
 
             /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:ca_created_date,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:ca_created_date1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 22;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CO\
NVERT_TO_LOCALE_DATE ( to_date ( :ca_created_date , 'DD/MM/YY HH24:MI' ) , :la\
nguage_id , t_date ) ; :ca_created_date1 := to_char ( t_date , 'DD/MM/YY HH24:\
MI' ) ; END ;";
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )1986;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqhstv[0] = (         void  *)&ca_created_date;
             sqlstm.sqhstl[0] = (unsigned int  )23;
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
             sqlstm.sqhstv[2] = (         void  *)&ca_created_date1;
             sqlstm.sqhstl[2] = (unsigned int  )23;
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
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:ca_reviewed_date,'DD/MM/YY HH24:MI'), :language_id , t_date);
				:ca_reviewed_date1 := to_char(t_date,'DD/MM/YY HH24:MI');
				END;
			END-EXEC; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 22;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CO\
NVERT_TO_LOCALE_DATE ( to_date ( :ca_reviewed_date , 'DD/MM/YY HH24:MI' ) , :l\
anguage_id , t_date ) ; :ca_reviewed_date1 := to_char ( t_date , 'DD/MM/YY HH2\
4:MI' ) ; END ;";
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )2013;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqhstv[0] = (         void  *)&ca_reviewed_date;
             sqlstm.sqhstl[0] = (unsigned int  )23;
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
             sqlstm.sqhstv[2] = (         void  *)&ca_reviewed_date1;
             sqlstm.sqhstl[2] = (unsigned int  )23;
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



  
  return 1;
}
/* ------------------------- --------------------------------*/
close_ca_review_details()
{
	/* EXEC SQL CLOSE ca_review_log; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2040;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)
	{
        disp_message(ORA_MESG,"Error occured in close_ca_review_details");
    }

}
/* ---------------- Get Practitioner Name -------------------*/
get_practitioner_name()
{

  am_practitioner_name.arr[0] = '\0';
  am_practitioner_name.len    = 0;

  /* EXEC SQL SELECT practitioner_name 
             INTO :am_practitioner_name
             FROM am_practitioner_lang_vw
			WHERE practitioner_id = :ca_review_done_by
			and language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select practitioner_name into :b0  from am_practitioner_lan\
g_vw where (practitioner_id=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2055;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&am_practitioner_name;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&ca_review_done_by;
  sqlstm.sqhstl[1] = (unsigned int  )33;
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
        err_mesg("SELECT failed on AM_PRACTITIONER table AM_PRACTITIONER_NAME ",0,"");


  am_practitioner_name.arr[am_practitioner_name.len] = '\0';
  

}
/* ------------------------- --------------------------------*/
/* Added on 11-2-2004 */

get_order_id()
{
 ol_order_id.arr[0] = '\0';
 ol_order_id.len    = 0;

/* added by amjad on 28/12/2005 for other order details */
 ol_order_type_code.arr[0] = '\0';
 ol_order_type_code.len    = 0;

 ol_order_regd_by.arr[0] = '\0';
 ol_order_regd_by.len = 0;

 ol_order_start_date.arr[0] = '\0';
 ol_order_start_date.len = 0;

 ol_order_date_time.arr[0] = '\0';
 ol_order_date_time.len = 0;

 ol_spec_regd_date_time.arr[0]	= '\0'; /* Added by Durai Rajkumar for age calculation on 03/02/08 */
 ol_spec_regd_date_time.len		= 0;	/* Added by Durai Rajkumar for age calculation on 03/02/08 */

/* Order ID */
 /* EXEC SQL SELECT ORDER_ID,ORDER_TYPE_CODE,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY')
	  INTO :ol_order_id INDICATOR :ol_order_id_ind,:ol_order_type_code,:ol_spec_regd_date_time
	  FROM  RL_REQUEST_HEADER
	  WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	  AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ORDER_ID ,ORDER_TYPE_CODE ,TO_CHAR(SPEC_REGD_DATE_TIM\
E,'DD/MM/YYYY') into :b0:b1,:b2,:b3  from RL_REQUEST_HEADER where (SPECIMEN_NO\
=TO_NUMBER(:b4) and OPERATING_FACILITY_ID=:b5)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2082;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ol_order_id;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)&ol_order_id_ind;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ol_order_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ol_spec_regd_date_time;
 sqlstm.sqhstl[2] = (unsigned int  )20;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[3] = (unsigned int  )23;
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


 
ol_order_id.arr[ol_order_id.len] = '\0';
ol_order_type_code.arr[ol_order_type_code.len] = '\0';
ol_spec_regd_date_time.arr[ol_spec_regd_date_time.len] = '\0'; /*Added by Durai Rajkumar for age calculation on 03/02/08 */
 
/* Order Regd By */
 /* EXEC SQL SELECT added_by_id
	  INTO :ol_order_regd_by
	  FROM OR_ORDER
	  WHERE ORDER_TYPE_CODE = :ol_order_type_code 
	  AND ORDER_ID = :ol_order_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select added_by_id into :b0  from OR_ORDER where (ORDER_TYPE\
_CODE=:b1 and ORDER_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2117;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ol_order_regd_by;
 sqlstm.sqhstl[0] = (unsigned int  )34;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ol_order_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ol_order_id;
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


 
ol_order_regd_by.arr[ol_order_regd_by.len] = '\0';

/* Order Date */
 /* EXEC SQL SELECT TO_CHAR(ord_date_time, 'DD/MM/RRRR HH24:MI')
	  INTO :ol_order_date_time
	  FROM OR_ORDER_HIS_VW
	  WHERE ORDER_TYPE_CODE = :ol_order_type_code 
	  AND ORDER_ID = :ol_order_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(ord_date_time,'DD/MM/RRRR HH24:MI') into :b0 \
 from OR_ORDER_HIS_VW where (ORDER_TYPE_CODE=:b1 and ORDER_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2144;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ol_order_date_time;
 sqlstm.sqhstl[0] = (unsigned int  )20;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ol_order_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ol_order_id;
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


 
ol_order_date_time.arr[ol_order_date_time.len] = '\0';
	  /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:ol_order_date_time,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
			:ol_order_date_time1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
		END;
	  END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :ol_order_date_time , 'DD/MM/YYYY HH24:MI' ) , :languag\
e_id , t_date ) ; :ol_order_date_time1 := to_char ( t_date , 'DD/MM/YYYY HH24:\
MI' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2171;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ol_order_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )20;
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
   sqlstm.sqhstv[2] = (         void  *)&ol_order_date_time1;
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




/* Order Start Date */
 /* EXEC SQL SELECT to_char(start_date_time,'dd/mm/yyyy hh24:mi')
	  INTO :ol_order_start_date
	  FROM OR_ORDER_LINE_HIS_VW
	  WHERE ORDER_TYPE_CODE = :ol_order_type_code 
	  AND ORDER_ID = :ol_order_id
	  AND ORDER_LINE_NUM = 1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select to_char(start_date_time,'dd/mm/yyyy hh24:mi') into :b\
0  from OR_ORDER_LINE_HIS_VW where ((ORDER_TYPE_CODE=:b1 and ORDER_ID=:b2) and\
 ORDER_LINE_NUM=1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2198;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ol_order_start_date;
 sqlstm.sqhstl[0] = (unsigned int  )20;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ol_order_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ol_order_id;
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


 
ol_order_start_date.arr[ol_order_start_date.len] = '\0';

	// Start Order Date & Time ---
	  /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:ol_order_start_date,'dd/mm/yyyy hh24:mi'), :language_id , t_date);
			:ol_order_start_date1 := to_char(t_date,'dd/mm/yyyy hh24:mi');
		END;
	  END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :ol_order_start_date , 'dd/mm/yyyy hh24:mi' ) , :langua\
ge_id , t_date ) ; :ol_order_start_date1 := to_char ( t_date , 'dd/mm/yyyy hh2\
4:mi' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2225;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ol_order_start_date;
   sqlstm.sqhstl[0] = (unsigned int  )20;
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
   sqlstm.sqhstv[2] = (         void  *)&ol_order_start_date1;
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


}


get_spec_user_info()
{
 ol_spec_regd_by.arr[0] = '\0';
 ol_spec_regd_by.len    = 0;

 ol_spec_disp_by.arr[0] = '\0';
 ol_spec_disp_by.len    = 0;

 ol_spec_disp_date_time.arr[0] = '\0';
 ol_spec_disp_date_time.len    = 0;

 /* EXEC SQL SELECT SPECIMEN_COLLECTED_BY,
		 SPECIMEN_DISPATCHED_BY,		 		 
		 TO_CHAR(SPECIMEN_DISPATCH_DATE_TIME, 'DD/MM/YYYY HH24:MI')
	  INTO	 :ol_spec_regd_by,
		 :ol_spec_disp_by,
		 :ol_spec_disp_date_time
	  FROM   OR_ORDER_LINE_LB
	  WHERE ORDER_ID = :ol_order_id
	  AND	ORDER_LINE_NUM = 1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SPECIMEN_COLLECTED_BY ,SPECIMEN_DISPATCHED_BY ,TO_CHA\
R(SPECIMEN_DISPATCH_DATE_TIME,'DD/MM/YYYY HH24:MI') into :b0,:b1,:b2  from OR_\
ORDER_LINE_LB where (ORDER_ID=:b3 and ORDER_LINE_NUM=1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2252;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ol_spec_regd_by;
 sqlstm.sqhstl[0] = (unsigned int  )34;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ol_spec_disp_by;
 sqlstm.sqhstl[1] = (unsigned int  )34;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ol_spec_disp_date_time;
 sqlstm.sqhstl[2] = (unsigned int  )20;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ol_order_id;
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

	

 ol_spec_regd_by.arr[ol_spec_regd_by.len] = '\0';
 ol_spec_disp_by.arr[ol_spec_disp_by.len] = '\0';
 ol_spec_disp_date_time.arr[ol_spec_disp_date_time.len] = '\0';

   /* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:ol_spec_disp_date_time,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
		:ol_spec_disp_date_time1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
	END;
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :ol_spec_disp_date_time , 'DD/MM/YYYY HH24:MI' ) , :lan\
guage_id , t_date ) ; :ol_spec_disp_date_time1 := to_char ( t_date , 'DD/MM/YY\
YY HH24:MI' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2283;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ol_spec_disp_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )20;
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
   sqlstm.sqhstv[2] = (         void  *)&ol_spec_disp_date_time1;
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


}

/* ------------------------- --------------------------------*/
/* Added on 11-2-2004 */

do_modify_log(char *group_test,char *test)
{	


if (tr_modify_log_seq_no_ind != -1 )  
	{			
	
	strcpy(rm_group_test_code.arr,test);		
	rm_group_test_code.len = strlen(rm_group_test_code.arr);	

	strcpy(rm_test_code.arr,test);		
	rm_test_code.len = strlen(rm_test_code.arr);	

			
		rm_remark_code.arr[0]		= '\0';	
		rm_remark_text.arr[0]		= '\0';

		rm_remark_code.len		= 0;	
		rm_remark_text.len		= 0;

      /* EXEC SQL 
	SELECT REMARK_CODE, REMARK_TEXT
	  INTO :rm_remark_code,:rm_remark_text
	  FROM RL_RESULT_MODIFY_REASON
	 WHERE SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
           AND OPERATING_FACILITY_ID = :nd_operating_facility_id
           AND (  GROUP_TEST_CODE = :rm_group_test_code 
		            OR  TEST_CODE = :rm_test_code)
		   AND MODIFY_LOG_SEQ_NO = :tr_modify_log_seq_no; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 22;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select REMARK_CODE ,REMARK_TEXT into :b0,:b1  from RL_R\
ESULT_MODIFY_REASON where (((SPECIMEN_NO=TO_NUMBER(:b2) and OPERATING_FACILITY\
_ID=:b3) and (GROUP_TEST_CODE=:b4 or TEST_CODE=:b5)) and MODIFY_LOG_SEQ_NO=:b6\
)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2310;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rm_remark_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rm_remark_text;
      sqlstm.sqhstl[1] = (unsigned int  )44;
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
      sqlstm.sqhstv[4] = (         void  *)&rm_group_test_code;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&rm_test_code;
      sqlstm.sqhstl[5] = (unsigned int  )13;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&tr_modify_log_seq_no;
      sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
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



		rm_remark_code.arr[rm_remark_code.len]	= '\0';	
		rm_remark_text.arr[rm_remark_text.len]	= '\0';


       if (OERROR)
        err_mesg("SELECT failed on DO_RESULT_MODIFY_REASON table RL_RESULT_MODIFY_REASON ",0,"");


		//fprintf(f1, "REASON FOR MODIFICATION : %-40.40s\n", rm_remark_text.arr); 
		fprintf(f1, "%-24.24s: %-40.40s\n", local_legend[48], rm_remark_text.arr); 
		line_no++;				
		chk_break(line_no);

	}
}


/*---------------- Added on 12-2-2004 -----------------------*/
/// corrected for top sql reported from ML on 01.10.2007
get_text_seq_cnt() 
{
	/* EXEC SQL
	SELECT count(1)
	  INTO :l_text_log_cnt1
	  FROM RL_RESULT_TEXT_LOG
	 WHERE SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND SPECIMEN_NO = TO_NUMBER(:d_specimen_no)	   
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND MODIFY_LOG_SEQ_NO = :tr_modify_log_seq_no
	   AND (    GROUP_TEST_CODE = :rt_group_test_code
	              OR TEST_CODE  = :rt_test_code); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_TEXT_LOG where ((((\
SEQUENCE_NO=TO_NUMBER(:b1) and SPECIMEN_NO=TO_NUMBER(:b2)) and OPERATING_FACIL\
ITY_ID=:b3) and MODIFY_LOG_SEQ_NO=:b4) and (GROUP_TEST_CODE=:b5 or TEST_CODE=:\
b6))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2353;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_text_log_cnt1;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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
 sqlstm.sqhstv[4] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rt_group_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&rt_test_code;
 sqlstm.sqhstl[6] = (unsigned int  )13;
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

get_snomed_seq_cnt()
{
      /* EXEC SQL
    SELECT COUNT(1)
	  INTO :l_snomed_log_cnt1
	  FROM RL_RESULT_SNOMED_LOG
	 WHERE SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND SPECIMEN_NO = TO_NUMBER(:d_specimen_no)	   
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND MODIFY_LOG_SEQ_NO = :tr_modify_log_seq_no
	   AND (    GROUP_TEST_CODE = :rs_group_test_code
	         OR TEST_CODE  = :rs_test_code); */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 22;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_SNOMED_LOG whe\
re ((((SEQUENCE_NO=TO_NUMBER(:b1) and SPECIMEN_NO=TO_NUMBER(:b2)) and OPERATIN\
G_FACILITY_ID=:b3) and MODIFY_LOG_SEQ_NO=:b4) and (GROUP_TEST_CODE=:b5 or TEST\
_CODE=:b6))";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2396;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_snomed_log_cnt1;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_sequence_no;
      sqlstm.sqhstl[1] = (unsigned int  )12;
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
      sqlstm.sqhstv[4] = (         void  *)&tr_modify_log_seq_no;
      sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&rs_group_test_code;
      sqlstm.sqhstl[5] = (unsigned int  )13;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&rs_test_code;
      sqlstm.sqhstl[6] = (unsigned int  )13;
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

get_org_seq_cnt()
{
	/* EXEC SQL
	SELECT count(1)
	  INTO :l_org_log_cnt1
	  FROM RL_RESULT_ORGANISM_LOG
	 WHERE SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND MODIFY_LOG_SEQ_NO = :tr_modify_log_seq_no
	   AND (    GROUP_TEST_CODE = :or_group_test_code
	         OR TEST_CODE  = :or_test_code); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_ORGANISM_LOG where \
((((SEQUENCE_NO=TO_NUMBER(:b1) and SPECIMEN_NO=TO_NUMBER(:b2)) and OPERATING_F\
ACILITY_ID=:b3) and MODIFY_LOG_SEQ_NO=:b4) and (GROUP_TEST_CODE=:b5 or TEST_CO\
DE=:b6))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2439;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_org_log_cnt1;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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
 sqlstm.sqhstv[4] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&or_group_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&or_test_code;
 sqlstm.sqhstl[6] = (unsigned int  )13;
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

get_org_dtl_seq_cnt()
{
	/* EXEC SQL 
	SELECT COUNT(1)
	  INTO :l_org_dtl_log_cnt1
	  FROM RL_RESULT_ORGANISM_DTL_LOG
	 WHERE SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND SPECIMEN_NO = TO_NUMBER(:d_specimen_no)	   
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND MODIFY_LOG_SEQ_NO = :tr_modify_log_seq_no
	   AND (    GROUP_TEST_CODE = :od_group_test_code
	         OR TEST_CODE  = :od_test_code); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_ORGANISM_DTL_LOG wh\
ere ((((SEQUENCE_NO=TO_NUMBER(:b1) and SPECIMEN_NO=TO_NUMBER(:b2)) and OPERATI\
NG_FACILITY_ID=:b3) and MODIFY_LOG_SEQ_NO=:b4) and (GROUP_TEST_CODE=:b5 or TES\
T_CODE=:b6))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2482;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_org_dtl_log_cnt1;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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
 sqlstm.sqhstv[4] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&od_group_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&od_test_code;
 sqlstm.sqhstl[6] = (unsigned int  )13;
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

get_ole_seq_cnt()
{
	/* EXEC SQL 
	SELECT count(1)
	  INTO :l_ole_log_cnt1
	  FROM RL_OLE_RESULT_TEXT_LOG
	 WHERE SEQUENCE_NO = TO_NUMBER(:d_sequence_no)
	   AND SPECIMEN_NO = TO_NUMBER(:d_specimen_no)	   
	   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND MODIFY_LOG_SEQ_NO = :tr_modify_log_seq_no
	   AND (    GROUP_TEST_CODE = :ot_group_test_code
	         OR TEST_CODE  = :ot_test_code); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_OLE_RESULT_TEXT_LOG where \
((((SEQUENCE_NO=TO_NUMBER(:b1) and SPECIMEN_NO=TO_NUMBER(:b2)) and OPERATING_F\
ACILITY_ID=:b3) and MODIFY_LOG_SEQ_NO=:b4) and (GROUP_TEST_CODE=:b5 or TEST_CO\
DE=:b6))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2525;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_ole_log_cnt1;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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
 sqlstm.sqhstv[4] = (         void  *)&tr_modify_log_seq_no;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&ot_group_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&ot_test_code;
 sqlstm.sqhstl[6] = (unsigned int  )13;
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
/*---------------- ---------------- -----------------------*/

/****************************** added for globalisation *****************************/
get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRWHODT.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRWHODT.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2568;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRWHODT.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRWHODT.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2591;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )702;
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

/*************************** added for globalisation*************************************/
