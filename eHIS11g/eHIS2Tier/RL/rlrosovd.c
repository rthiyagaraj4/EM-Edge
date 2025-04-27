
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
           char  filnam[54];
};
static const struct sqlcxp sqlfpn =
{
    53,
    "D:\\WORK\\ML-MMOH-CRF-0582\\printoutslist\\6i\\rlrosovd.pc"
};


static unsigned long sqlctx = 2057220411;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {10,16};

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
"select A.TEST_CODE ,DECODE(A.CANCELLED_YN,'Y','C',DECODE(C.REQUEST_CHECK,'R'\
,NVL(A.RESULT_STATUS,'O'),'V')) cancelled_yn ,NVL(A.group_test_yn,'N') group_t\
est_yn ,A.reason_code ,B.average_tat ,B.average_tat_unit ,TO_CHAR((TO_DATE(:b0\
,'DD/MM/YYYY HH24:MI')+DECODE(B.average_tat_unit,'MIN',(B.average_tat/1440),'H\
RS',(B.average_tat/24),'DAY',B.average_tat)),'DD/MM/YYYY HH24:MI') expected_co\
mpletion_dt  from RL_REQUEST_DETAIL A ,RL_TEST_CODE B ,RL_REQUEST_HEADER C whe\
re ((((((A.SPECIMEN_NO=TO_NUMBER(:b1) and A.OPERATING_FACILITY_ID=:b2) and A.O\
PERATING_FACILITY_ID=C.OPERATING_FACILITY_ID) and A.SPECIMEN_NO=C.SPECIMEN_NO)\
 and A.SECTION_CODE=C.SECTION_CODE) and A.test_code=B.test_code) and A.specime\
n_no in (select specimen_no  from RL_OUTSTANDING_WORK where (((specimen_no=TO_\
NUMBER(:b1) and operating_facility_id=:b2) and (RL_OUTSTANDING_WORK.spec_regd_\
date_time+DECODE(B.AVERAGE_TAT_UNIT,'MIN',(B.AVERAGE_TAT/1440),'HRS',(B.AVERAG\
E_TAT/24),'DAY',B.AVERAGE_TAT))<SYSDATE) and B.average_tat is  not null )))   \
        ";

 static const char *sq0039 = 
"select test_code  from RL_GROUP_TEST_DETAIL where group_test_code=:b0       \
    ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,231,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,68,0,4,285,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
59,0,0,3,0,0,29,400,0,0,0,0,0,1,0,
74,0,0,4,0,0,32,410,0,0,0,0,0,1,0,
89,0,0,5,120,0,6,421,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
112,0,0,6,136,0,6,436,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
135,0,0,7,158,0,4,479,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
170,0,0,8,0,0,32,503,0,0,0,0,0,1,0,
185,0,0,9,117,0,4,513,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
212,0,0,10,0,0,32,530,0,0,0,0,0,1,0,
227,0,0,11,198,0,4,542,0,0,1,0,0,1,0,2,9,0,0,
246,0,0,13,0,0,32,675,0,0,0,0,0,1,0,
261,0,0,14,0,0,17,1030,0,0,1,1,0,1,0,1,1,0,0,
280,0,0,14,0,0,45,1038,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
359,0,0,14,0,0,45,1059,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
426,0,0,15,0,0,32,1084,0,0,0,0,0,1,0,
441,0,0,16,55,0,4,1099,0,0,1,0,0,1,0,2,3,0,0,
460,0,0,14,0,0,17,1445,0,0,1,1,0,1,0,1,1,0,0,
479,0,0,14,0,0,45,1453,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
558,0,0,14,0,0,45,1474,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
625,0,0,17,0,0,32,1496,0,0,0,0,0,1,0,
640,0,0,18,288,0,4,1506,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
691,0,0,19,0,0,32,1536,0,0,0,0,0,1,0,
706,0,0,12,0,0,13,1642,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
9,0,0,2,9,0,0,
749,0,0,20,0,0,32,1674,0,0,0,0,0,1,0,
764,0,0,14,0,0,13,1687,0,0,2,0,0,1,0,2,9,0,0,2,3,0,0,
787,0,0,21,0,0,32,1708,0,0,0,0,0,1,0,
802,0,0,14,0,0,13,1720,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
829,0,0,22,0,0,32,1748,0,0,0,0,0,1,0,
844,0,0,23,97,0,4,1763,0,0,3,2,0,1,0,1,9,0,0,1,4,0,0,2,9,0,0,
871,0,0,24,0,0,32,1776,0,0,0,0,0,1,0,
886,0,0,25,99,0,4,1795,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
913,0,0,26,0,0,32,1810,0,0,0,0,0,1,0,
928,0,0,12,1020,0,9,1901,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
963,0,0,27,152,0,6,1905,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
990,0,0,28,151,0,6,2024,0,0,2,2,0,1,0,3,1,0,0,1,9,0,0,
1013,0,0,29,0,0,32,2062,0,0,0,0,0,1,0,
1028,0,0,30,135,0,4,2071,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
1055,0,0,31,0,0,32,2087,0,0,0,0,0,1,0,
1070,0,0,32,135,0,4,2096,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
1097,0,0,33,0,0,32,2113,0,0,0,0,0,1,0,
1112,0,0,34,146,0,6,2165,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1139,0,0,35,142,0,6,2181,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1166,0,0,36,100,0,6,2442,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
1189,0,0,37,143,0,4,2633,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1220,0,0,38,143,0,4,2653,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1251,0,0,39,80,0,9,2678,0,0,1,1,0,1,0,1,9,0,0,
1270,0,0,39,0,0,13,2687,0,0,1,0,0,1,0,2,9,0,0,
1289,0,0,40,0,0,32,2706,0,0,0,0,0,1,0,
1304,0,0,39,0,0,15,2713,0,0,0,0,0,1,0,
1319,0,0,14,0,0,15,2718,0,0,0,0,0,1,0,
1334,0,0,41,101,0,6,2965,0,0,1,1,0,1,0,2,3,0,0,
1353,0,0,42,49,0,4,2978,0,0,1,0,0,1,0,2,9,0,0,
1372,0,0,43,105,0,4,3004,0,0,1,0,0,1,0,2,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: rlrosovd.pc
   Author : S.Sheelvant 
   Date Created  : 22/02/1997
   Last Modified : 19/09/2000

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

*  Output File : rlrosovd.lis
 ****************************************************************************/  

#include <stdio.h>
#include <string.h>
#include <math.h>
#include "gl.h"
//#define MAX_LINES 55
#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ESC 0x1B
#define ONLINE_PRINTING 1
#define REP_WIDTH 80 

/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR     nd_operating_facility_id   [3],
	            uid_pwd		               [91],
                nd_file_name               [151],
                nd_user	                   [15],
                nd_file_no                 [15],
                nd_printer_name            [16],
				nd_trx_ind		           [2], 
				nd_tests_status	           [2000],
				nd_req_tests	           [2000],
				nd_tests_exp_date          [2000],
				nd_assign_to			   [31],
				d_version_no			   [20],
				d_version  			       [20],
				nd_section_code            [3], 
        /o Variables to recieve data from specimen register cursoro/ 
	            d_specimen_no              [21],
                d_spec_regd_date           [31],
				d_spec_regd_date1           [31],
				d_expected_date				[31],
				d_avg_tat_unit				[5],
				old_test_code				[11],
				old_specimen_no             [21],
				d_test_code                 [11],
				d_reason_code				[5],
				d_reason_code_1				[5],
				d_reason_desc               [20],
				d_reason_code_sum			[5],


        d_result_status         [2],
		d_category_yn           [2],
		d_patient_id            [31],
		d_assign_to             [31],
		d_category_num          [19],
		d_source_code           [11],
	    d_patient_name          [240],
		d_episode_type          [2],
		d_request_comment_desc1 [41],
		d_request_comment_desc2 [41],
		d_request_comment_desc3 [41],
		l_translated_value		 [100],//added by babu for conversion
		language_id			[5],


                /o input parameters to main() o/
                nd_session_id      	[16],
		nd_pgm_date	   	        [20],
		nd_dept                 [2],
 		nd_fr_specimen_no       [21], 
 		nd_to_specimen_no       [21],
		nd_priority             [2],
		nd_out_include          [3],
		nd_test_code            [11],
		nd_start_date           [31],
		nd_start_date1          [31],
		nd_end_date				[31],
		nd_end_date1			[31],

		nd_comm_code            [5],
		nd_workgroup_code       [4],
		nd_sp_prfx				[3],
		nd_grp_test_yn	        [2],
		nd_referred_lab			[5],

		nd_fr_category_cd       [6],
		nd_fr_category_yr       [6],
		nd_fr_category_no       [16],
		nd_to_category_cd       [6],
		nd_to_category_yr       [6],
		nd_to_category_no       [16],
		nd_loc_access_type      [4],
		nd_perform_site_cd      [6],
		nd_source_type          [6],
		nd_source_code          [11],

		nd_specimen_from		[21],
		nd_specimen_to			[21],

		/o for header routine o/
	    //d_acc_entity_name        [41],
		d_acc_entity_name        [300],
		d_user                   [31],
		d_sysdate                [17],
		d_sysdate1                [17]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[15]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_printer_name;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[2000]; } nd_tests_status;

struct { unsigned short len; unsigned char arr[2000]; } nd_req_tests;

struct { unsigned short len; unsigned char arr[2000]; } nd_tests_exp_date;

struct { unsigned short len; unsigned char arr[31]; } nd_assign_to;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[3]; } nd_section_code;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } d_spec_regd_date;

struct { unsigned short len; unsigned char arr[31]; } d_spec_regd_date1;

struct { unsigned short len; unsigned char arr[31]; } d_expected_date;

struct { unsigned short len; unsigned char arr[5]; } d_avg_tat_unit;

struct { unsigned short len; unsigned char arr[11]; } old_test_code;

struct { unsigned short len; unsigned char arr[21]; } old_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[5]; } d_reason_code;

struct { unsigned short len; unsigned char arr[5]; } d_reason_code_1;

struct { unsigned short len; unsigned char arr[20]; } d_reason_desc;

struct { unsigned short len; unsigned char arr[5]; } d_reason_code_sum;

struct { unsigned short len; unsigned char arr[2]; } d_result_status;

struct { unsigned short len; unsigned char arr[2]; } d_category_yn;

struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[31]; } d_assign_to;

struct { unsigned short len; unsigned char arr[19]; } d_category_num;

struct { unsigned short len; unsigned char arr[11]; } d_source_code;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[41]; } d_request_comment_desc1;

struct { unsigned short len; unsigned char arr[41]; } d_request_comment_desc2;

struct { unsigned short len; unsigned char arr[41]; } d_request_comment_desc3;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[2]; } nd_dept;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_specimen_no;

struct { unsigned short len; unsigned char arr[2]; } nd_priority;

struct { unsigned short len; unsigned char arr[3]; } nd_out_include;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code;

struct { unsigned short len; unsigned char arr[31]; } nd_start_date;

struct { unsigned short len; unsigned char arr[31]; } nd_start_date1;

struct { unsigned short len; unsigned char arr[31]; } nd_end_date;

struct { unsigned short len; unsigned char arr[31]; } nd_end_date1;

struct { unsigned short len; unsigned char arr[5]; } nd_comm_code;

struct { unsigned short len; unsigned char arr[4]; } nd_workgroup_code;

struct { unsigned short len; unsigned char arr[3]; } nd_sp_prfx;

struct { unsigned short len; unsigned char arr[2]; } nd_grp_test_yn;

struct { unsigned short len; unsigned char arr[5]; } nd_referred_lab;

struct { unsigned short len; unsigned char arr[6]; } nd_fr_category_cd;

struct { unsigned short len; unsigned char arr[6]; } nd_fr_category_yr;

struct { unsigned short len; unsigned char arr[16]; } nd_fr_category_no;

struct { unsigned short len; unsigned char arr[6]; } nd_to_category_cd;

struct { unsigned short len; unsigned char arr[6]; } nd_to_category_yr;

struct { unsigned short len; unsigned char arr[16]; } nd_to_category_no;

struct { unsigned short len; unsigned char arr[4]; } nd_loc_access_type;

struct { unsigned short len; unsigned char arr[6]; } nd_perform_site_cd;

struct { unsigned short len; unsigned char arr[6]; } nd_source_type;

struct { unsigned short len; unsigned char arr[11]; } nd_source_code;

struct { unsigned short len; unsigned char arr[21]; } nd_specimen_from;

struct { unsigned short len; unsigned char arr[21]; } nd_specimen_to;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;


/****** ADDED FOR GTT SPECIMENS ******/
	/* VARCHAR	id_test_code		[11],
			d_group_test_yn     [2]; */ 
struct { unsigned short len; unsigned char arr[11]; } id_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_group_test_yn;


    /* VARCHAR l_customer_id          [1]; */ 
struct { unsigned short len; unsigned char arr[1]; } l_customer_id;
    //added for ML-MMOH-CRF-0582			

char includ;
char sql_stmt[5000];
char sql_stmt1[5000];
char sql_stmt2[5000] ;

int l_count = 0;
int l_specimen_length = 0;
int l_cnt = 0;

int d_reason_cnt = 0;

int  l_tab_exists ;

float	d_avg_tat;

/****************ADDED FOR CONVERSION***************/
int i;
char local_legend[100][100];
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1];
int col;
char rep_title1[100] ;
char rep_title2[60];
int rec_len;

/***************END***********/

/*******For getting the test and expected  date array declarations***/

char d_test_name [100][21];
char d_test_date [100][31];
char d_exp_test_date  [100][31];
char d_exp_test_date1  [31];

char d_avg_tat_unit_d	[100][5];
char d_reason_code_d	[100][4];
char d_result_stat_d    [100][2];

//float d_avg_tat_d[100];
int d_avg_tat_d[100];


int test_counter = 0;
int i;

/****************/

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

int   line_no=0, page_no=0;
int   first_page_flag=1;

int   l_length = 0;
int i;

long  nd_totl_specimens      = 0;
long  nd_totl_specs          = 0;
long  nd_totl_blocks         = 0;
long  nd_totl_slides         = 0;
/* summary fields for calculating No. of records */ 

void print_page_header();
void print_col_heading();
FILE *f1;
char string_var[2000] ;

char d_stat = 'N';

int qq1 = 0, cntr1 = 0, z1 = 0, l_len = 0, clt1 = 0, cmp1 = 0;

char word11[2];
char local_legend[100][100];
int i;


void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
	get_category(),
  	dclr_request_header(),
	dclr_request_detail(),
  	do_report(); 

    strcpy(uid_pwd.arr, argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr); 

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
	strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	//get_legend_value(62);
	get_legend_value(64); // added by srinivas
	
	get_sm_func_cntrl(); //added for ML-MMOH-CRF-0582
	
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
	          FROM RL_SECTION_CODE_LANG_VW
             WHERE SECTION_CODE = :nd_dept
			 AND   LANGUAGE_ID = :language_id;
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
      sqlstm.sqlvsn = 10;
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
      sqlstm.sqlety = (unsigned short)256;
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


   /** Commented on 18/08/2004 since Test code is unique across the section
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


   strcpy(nd_section_code.arr, nd_dept.arr);
   nd_section_code.len = strlen(nd_section_code.arr);

   /*
   strcpy(nd_section_code.arr, argv[15]);
   nd_section_code.len = strlen(nd_section_code.arr); 
   if(strcmp(nd_section_code.arr,"NULL")==0)
   {   nd_section_code.arr[0] = '\0';
       nd_section_code.len = 0;
   }
   */
   strcpy(nd_end_date.arr, argv[15]);
   nd_end_date.len = strlen(nd_end_date.arr); 

   strcpy(nd_priority.arr, argv[16]);
   nd_priority.len = strlen(nd_priority.arr);

   strcpy(nd_out_include.arr, argv[17]);
   nd_out_include.len = strlen(nd_out_include.arr);

   strcpy(nd_fr_category_cd.arr, argv[18]);
   nd_fr_category_cd.len = strlen(nd_fr_category_cd.arr);

   strcpy(nd_fr_category_yr.arr, argv[19]);
   nd_fr_category_yr.len = strlen(nd_fr_category_yr.arr);

   strcpy(nd_fr_category_no.arr, argv[20]);
   nd_fr_category_no.len = strlen(nd_fr_category_no.arr);

   strcpy(nd_to_category_cd.arr, argv[21]);
   nd_to_category_cd.len = strlen(nd_to_category_cd.arr);

   strcpy(nd_to_category_yr.arr, argv[22]);
   nd_to_category_yr.len = strlen(nd_to_category_yr.arr);

   strcpy(nd_to_category_no.arr, argv[23]);
   nd_to_category_no.len = strlen(nd_to_category_no.arr);

   strcpy(nd_loc_access_type.arr, argv[24]);
   nd_loc_access_type.len = strlen(nd_loc_access_type.arr);

   strcpy(nd_perform_site_cd.arr, argv[25]);
   nd_perform_site_cd.len = strlen(nd_perform_site_cd.arr);

   strcpy(nd_source_type.arr, argv[26]);
   nd_source_type.len = strlen(nd_source_type.arr);

   strcpy(nd_source_code.arr, argv[27]);
   nd_source_code.len = strlen(nd_source_code.arr);

   /***
   sprintf(string_var, "[%s]  [%s]  [%s]  [%s]  [%s]   [%s]  [%s]  [%s]  ", 
			argv[1], argv[2], argv[3], argv[4], argv[5], argv[6], argv[7], argv[8]);
   disp_message(ERR_MESG, string_var);

   sprintf(string_var, "[%s]  [%s]  [%s]  [%s]  [%s]   [%s]  [%s]   [%s] [%s]", 
			argv[9], argv[10], argv[11], argv[12], argv[13], argv[14], argv[15], argv[16], argv[17]);
   disp_message(ERR_MESG, string_var);
   ***/

   gen_file_name();

   /* increment_file_no(); */

   get_header_dtls();

   get_category();

   dclr_request_header();

   dclr_request_detail();

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
   sqlstm.offset = (unsigned int  )59;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
}



//   fprintf(f1,"%c&|3O",ESC);

   fclose(f1);
   print_job();
   return;

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
   sqlstm.offset = (unsigned int  )74;
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
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLROSOVD.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLROSOVD.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )89;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLROSOVD.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LROSOVD.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )112;
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

/**********END***********/
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
/***************END***************/
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
		   AND LANGUAGE_ID =:language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
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
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )170;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}

/* get the flag if category is to be used from rl_section_ctl */

void get_category()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT NVL(CATEGORY_USED_YN,'N')
	    INTO :d_category_yn
		FROM RL_SECTION_CTL
		WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND SECTION_CODE = :nd_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(CATEGORY_USED_YN,'N') into :b0  from RL_SECTION\
_CTL where (OPERATING_FACILITY_ID=:b1 and SECTION_CODE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )185;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_category_yn;
   sqlstm.sqhstl[0] = (unsigned int  )4;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


  
  d_category_yn.arr[d_category_yn.len] = '\0';
  

  #ifdef DEBUG
   printf("d_category_yn = %s\n", d_category_yn.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )212;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_category() occured....\n");
   proc_exit();
}


/* checking site specific for ML-MMOH-CRF-0582 */
 get_sm_func_cntrl()
{
	l_customer_id.arr[0]		= '\0';
	l_customer_id.len		= 0;

	/* EXEC SQL SELECT NVL(VALUE_1,'N')
			INTO :l_customer_id
			FROM SM_FUNCTION_CONTROL,SM_SITE_PARAM
			WHERE SM_FUNCTION_CONTROL.SITE_ID=SM_SITE_PARAM.CUSTOMER_ID
		    AND MODULE_ID='RL'
			AND FUNCTIONALITY_ID = 'RL_ASSIGN_TO_USERS'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(VALUE_1,'N') into :b0  from SM_FUNCTION_CONTROL ,\
SM_SITE_PARAM where ((SM_FUNCTION_CONTROL.SITE_ID=SM_SITE_PARAM.CUSTOMER_ID an\
d MODULE_ID='RL') and FUNCTIONALITY_ID='RL_ASSIGN_TO_USERS')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )227;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_customer_id;
 sqlstm.sqhstl[0] = (unsigned int  )3;
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


			
	l_customer_id.arr[l_customer_id.len]	= '\0';
		
	    

	if (OERROR)
         disp_message(ORA_MESG,"Select failed on table SM_SITE_PARAM");

	  

}
// end  ML-MMOH-CRF-0582 

/*--------------------------------- REQUEST DETAIL CURSOR -------------------*/
void dclr_request_detail()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

/*********
  EXEC SQL DECLARE REQUEST_DETAIL CURSOR FOR
     SELECT TEST_CODE,DECODE(CANCELLED_YN,'Y','C',NVL(RESULT_STATUS,'O')),
     NVL(group_test_yn, 'N')
     FROM   RL_REQUEST_DETAIL
     WHERE  SPECIMEN_NO = :d_specimen_no  
	 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
     AND    ((:includ = 'O' AND NVL(RESULT_STATUS,'O') IN ('O','H','A')) OR
	     (:includ = 'A' AND NVL(RESULT_STATUS,'O') 
					= NVL(RESULT_STATUS,'O')));
***********************/
/*	 AND NVL(cancelled_yn, 'N') <> 'Y';*/

/*******if declare is required w/o the expcted completion date then use this query

  EXEC SQL DECLARE REQUEST_DETAIL CURSOR FOR
     SELECT A.TEST_CODE,
	 		DECODE(A.CANCELLED_YN,'Y','C',NVL(A.RESULT_STATUS,'O')) cancelled_yn, 
				NVL(A.group_test_yn, 'N') group_test_yn,
				DECODE(average_tat_unit,'MIN',(average_tat/1440),
				                        'HRS',(average_tat/24),
						   'DAY',average_tat) average_tat, average_tat_unit
     FROM   RL_REQUEST_DETAIL A, RL_TEST_CODE B
     WHERE  SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
     AND OPERATING_FACILITY_ID = :nd_operating_facility_id	 
	 AND A.test_code = B.test_code
	 AND A.specimen_no IN (SELECT specimen_no 
						FROM RL_OUTSTANDING_WORK
						WHERE specimen_no = TO_NUMBER(:d_specimen_no)
						AND operating_facility_id = :nd_operating_facility_id
						AND ( (RL_OUTSTANDING_WORK.spec_regd_date_time + B.average_tat)
								< SYSDATE)
								AND B.average_tat IS NOT NULL)
	  AND    ((:includ = 'O' AND NVL(RESULT_STATUS,'O') IN ('O','H','A')) OR
	     (:includ = 'A' AND NVL(RESULT_STATUS,'O') 
					= NVL(RESULT_STATUS,'O')
					));


*******************************************/

/****to get the expected completion date in the declare statement itself, use this query********/

  /* EXEC SQL DECLARE REQUEST_DETAIL CURSOR FOR
     SELECT	A.TEST_CODE,
     DECODE(A.CANCELLED_YN,'Y','C',DECODE(C.REQUEST_CHECK,'R',NVL(A.RESULT_STATUS,'O'),'V')) cancelled_yn, 
			NVL(A.group_test_yn, 'N') group_test_yn,
			A.reason_code,
			B.average_tat, B.average_tat_unit,
						   TO_CHAR((TO_DATE(:d_spec_regd_date,'DD/MM/YYYY HH24:MI')+
						   (DECODE(B.average_tat_unit,'MIN',(B.average_tat/1440),
				                        'HRS',(B.average_tat/24),
						   'DAY',B.average_tat))),'DD/MM/YYYY HH24:MI') expected_completion_dt
     FROM   RL_REQUEST_DETAIL A, RL_TEST_CODE B , RL_REQUEST_HEADER C
     WHERE  A.SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
     AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id	 
	 AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID		
	 AND A.SPECIMEN_NO = C.SPECIMEN_NO
	 AND A.SECTION_CODE = C.SECTION_CODE
	 AND A.test_code = B.test_code
	 AND A.specimen_no IN (SELECT specimen_no 
						FROM RL_OUTSTANDING_WORK
						WHERE specimen_no = TO_NUMBER(:d_specimen_no)
						AND operating_facility_id = :nd_operating_facility_id
						AND ( (RL_OUTSTANDING_WORK.spec_regd_date_time + 
						DECODE(B.AVERAGE_TAT_UNIT,'MIN',B.AVERAGE_TAT/1440, 
						'HRS',B.AVERAGE_TAT/24,'DAY',B.AVERAGE_TAT))
//						B.average_tat)
								< SYSDATE)
								AND B.average_tat IS NOT NULL); */ 


  
  /* commented the below cursor and added above cursor by srinivas 
  EXEC SQL DECLARE REQUEST_DETAIL CURSOR FOR
     SELECT	A.TEST_CODE,
     DECODE(A.CANCELLED_YN,'Y','C',NVL(A.RESULT_STATUS,'O')) cancelled_yn, 
			NVL(A.group_test_yn, 'N') group_test_yn,
			A.reason_code,
			B.average_tat, B.average_tat_unit,
						   TO_CHAR((TO_DATE(:d_spec_regd_date,'DD/MM/YYYY HH24:MI')+
						   (DECODE(B.average_tat_unit,'MIN',(B.average_tat/1440),
				                        'HRS',(B.average_tat/24),
						   'DAY',B.average_tat))),'DD/MM/YYYY HH24:MI') expected_completion_dt
     FROM   RL_REQUEST_DETAIL A, RL_TEST_CODE B
     WHERE  SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
     AND OPERATING_FACILITY_ID = :nd_operating_facility_id	 
	 AND A.test_code = B.test_code
	 AND A.specimen_no IN (SELECT specimen_no 
						FROM RL_OUTSTANDING_WORK
						WHERE specimen_no = TO_NUMBER(:d_specimen_no)
						AND operating_facility_id = :nd_operating_facility_id
						AND ( (RL_OUTSTANDING_WORK.spec_regd_date_time + 
						DECODE(B.AVERAGE_TAT_UNIT,'MIN',B.AVERAGE_TAT/1440, 
						'HRS',B.AVERAGE_TAT/24,'DAY',B.AVERAGE_TAT))
//						B.average_tat)
								< SYSDATE)
								AND B.average_tat IS NOT NULL);   */

//	  AND    ((:includ = 'O' AND NVL(RESULT_STATUS,'O') IN ('O','H','A')) OR
//	     (:includ = 'A' AND NVL(RESULT_STATUS,'O') 
//					= NVL(RESULT_STATUS,'O')
//					));

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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )246;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_request_detail() occured....\n");
   proc_exit();
}

/*--------------------------------- REQUEST DETAIL Group by Reason Code -------------------*/
void dclr_rqst_dtl_rsngrp()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

/**  
  EXEC SQL DECLARE RQST_DTL_RSNGRP CURSOR FOR
     SELECT	A.REASON_CODE, COUNT(*)
     FROM   RL_REQUEST_DETAIL A, RL_OUTSTANDING_WORK B , RL_TEST_CODE C 
     WHERE  A.SPECIMEN_NO = B.SPECIMEN_NO
	 AND A.SPECIMEN_NO BETWEEN TO_NUMBER(:nd_specimen_from)
	 AND TO_NUMBER(:nd_specimen_to)
	 AND A.TEST_CODE = C.TEST_CODE
	 AND ((B.spec_regd_date_time + 
     DECODE(C.AVERAGE_TAT_UNIT,'MIN',C.AVERAGE_TAT/1440, 'HRS',C.AVERAGE_TAT/24,
	        'DAY',C.AVERAGE_TAT)) < SYSDATE)
     AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
     AND    ((:includ = 'O' AND NVL(RESULT_STATUS,'O') IN ('O','H','A')) OR
	     (:includ = 'A' AND NVL(RESULT_STATUS,'O')
					= NVL(RESULT_STATUS,'O')))
	 AND NVL(CANCELLED_YN, 'N') != 'Y'
	 GROUP BY REASON_CODE;

   EXEC SQL WHENEVER SQLERROR GOTO err_exit;

   EXEC SQL OPEN RQST_DTL_RSNGRP;
**/ 
  strcpy(sql_stmt,
    "SELECT RL_REQUEST_DETAIL.REASON_CODE, COUNT(*) \
      FROM RL_OUTSTANDING_WORK , RL_REQUEST_DETAIL, RL_TEST_CODE \
      WHERE RL_REQUEST_DETAIL.OPERATING_FACILITY_ID = :nd_operating_facility_id \
	  AND RL_REQUEST_DETAIL.OPERATING_FACILITY_ID = RL_OUTSTANDING_WORK.OPERATING_FACILITY_ID \
	  AND RL_REQUEST_DETAIL.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
	  AND RL_OUTSTANDING_WORK.SPECIMEN_NO \
                       BETWEEN TO_NUMBER(:nd_specimen_from) \
                           AND TO_NUMBER(:nd_specimen_to) \
      AND RL_REQUEST_DETAIL.TEST_CODE = RL_TEST_CODE.TEST_CODE \
	  AND RL_TEST_CODE.AVERAGE_TAT IS NOT NULL \
      AND ((RL_OUTSTANDING_WORK.spec_regd_date_time +  \
      DECODE(RL_TEST_CODE.AVERAGE_TAT_UNIT,'MIN',RL_TEST_CODE.AVERAGE_TAT/1440, \
	                                       'HRS',RL_TEST_CODE.AVERAGE_TAT/24, \
	                                       'DAY',RL_TEST_CODE.AVERAGE_TAT)) < SYSDATE) \
 	  AND RL_OUTSTANDING_WORK.URGENT_INDICATOR = \
	      DECODE(:nd_priority, 'A', RL_OUTSTANDING_WORK.URGENT_INDICATOR, :nd_priority) \
		AND NVL(RL_OUTSTANDING_WORK.PERFORM_SITE_CODE, '!!') = DECODE(:nd_loc_access_type, \
				'SA', DECODE(:nd_perform_site_cd,'NULL',NVL(RL_OUTSTANDING_WORK.PERFORM_SITE_CODE, '!!'),:nd_perform_site_cd),\
				'SS', DECODE(:nd_perform_site_cd,'NULL','!!',:nd_perform_site_cd), \
				 DECODE(:nd_perform_site_cd, 'NULL', NVL(RL_OUTSTANDING_WORK.PERFORM_SITE_CODE, '!!'),\
				 																						 :nd_perform_site_cd))\
			      AND NVL(CANCELLED_YN, 'N') != 'Y' \
      AND RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME >= \
              TO_DATE(:nd_start_date,'DD/MM/YYYYHH24MI')");
/* changed  the condition DECODE(:nd_perform_site_cd,'NULL','!!',:nd_perform_site_cd) to
   DECODE(:nd_perform_site_cd, 'NULL', NVL(RL_OUTSTANDING_WORK.PERFORM_SITE_CODE, '!!'), :nd_perform_site_cd)) 
   on 27/08/2007 against the ML-SD-SCF-1858 */
  if (strcmp(nd_end_date.arr, "NULL") != 0)
  {
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME < \
			  TO_DATE(:nd_end_date, 'DD/MM/YYYYHH24MI') + 1 ");
  }

	/***
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN ");
	strcat(sql_stmt, "( SELECT SPECIMEN_NO FROM RL_TEST_RESULT \
					   WHERE RL_TEST_RESULT.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
					   AND RL_TEST_RESULT.TEST_CODE IN ");
	strcat(sql_stmt, "(SELECT TEST_CODE FROM RL_TEST_CODE \
	                   WHERE SECTION_CODE = '");
	strcat(sql_stmt, nd_dept.arr);
	strcat(sql_stmt, "' AND AVERAGE_TAT IS NOT NULL \
	                    AND SYSDATE > RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME + \
						DECODE(RL_TEST_CODE.AVERAGE_TAT_UNIT , 'MIN', \
						RL_TEST_CODE.AVERAGE_TAT/1440, 'HRS', \
						RL_TEST_CODE.AVERAGE_TAT/24, 'DAY' ,\
						RL_TEST_CODE.AVERAGE_TAT)))");
	***/
  
  strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SECTION_CODE = '");
  strcat(sql_stmt, nd_dept.arr);
  strcat(sql_stmt, "'");

  if (strcmp(nd_source_type.arr,"NULL") != 0)
  {
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SOURCE_TYPE = '");
	strcat(sql_stmt, nd_source_type.arr);
	strcat(sql_stmt, "' AND RL_OUTSTANDING_WORK.SOURCE_CODE = '");
	strcat(sql_stmt, nd_source_code.arr);
	strcat(sql_stmt, "'");
  }

  if (strcmp(nd_fr_category_cd.arr, "NULL") != 0 && strcmp(nd_fr_category_yr.arr, "NULL") != 0
      && strcmp(nd_fr_category_no.arr , "NULL") != 0)
  {
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.CATEGORY_NUMBER BETWEEN '");
	strcat(sql_stmt, nd_fr_category_no.arr);
	strcat(sql_stmt, "' AND '");
	strcat(sql_stmt, nd_to_category_no.arr);
	strcat(sql_stmt, "'");
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.CATEGORY_YEAR BETWEEN '");
	strcat(sql_stmt, nd_fr_category_yr.arr);
	strcat(sql_stmt, "' AND '");
	strcat(sql_stmt, nd_to_category_yr.arr);
	strcat(sql_stmt, "' AND RL_OUTSTANDING_WORK.CATEGORY_CODE BETWEEN '");
	strcat(sql_stmt, nd_fr_category_cd.arr);
	strcat(sql_stmt, "' AND '");
	strcat(sql_stmt, nd_to_category_cd.arr);
	strcat(sql_stmt, "'");
  }

  if (strcmp(l_customer_id.arr,"Y") != 0)  //added for ml-mmoh-crf-0582
  {//added for ml-mmoh-crf-0582
  if(strcmp(nd_assign_to.arr,"NULL") != 0)    
 	strcat(sql_stmt,
		   " AND RL_OUTSTANDING_WORK.ASSIGN_TO = NVL(:nd_assign_to, RL_OUTSTANDING_WORK.ASSIGN_TO) ");
		   
  }  //added for ml-mmoh-crf-0582
  
  //added for ml-mmoh-crf-0582
  if  (strcmp(l_customer_id.arr,"Y") == 0)  
  {
  //disp_message(ERR_MESG,"1"); 
  
  if(strcmp(nd_assign_to.arr,"NULL") != 0)  
  {
  //disp_message(ERR_MESG,"2"); 
 
 strcat(sql_stmt,
		   " AND ( RL_OUTSTANDING_WORK.ASSIGN_TO = nvl(:nd_assign_to,assign_to) OR \
			          (RL_OUTSTANDING_WORK.specimen_no in (SELECT SPECIMEN_NO\
					  FROM RL_ASSIGN_TO_USERS \
					  WHERE SECTION_CODE = '");
					  strcat(sql_stmt, nd_dept.arr);
					  strcat(sql_stmt, "'");
					  strcat(sql_stmt, " AND NVL(DEFAULT_YN,'N')=");
					
					  strcat(sql_stmt, "'");
					  strcat(sql_stmt, "N'");
					  strcat(sql_stmt, " AND OPERATING_FACILITY_ID =");
					  strcat(sql_stmt, "'");
					  strcat(sql_stmt, nd_operating_facility_id.arr);
					  strcat(sql_stmt, "'");
					  strcat(sql_stmt, " AND USER_ID =");
					  strcat(sql_stmt, "'");
					  strcat(sql_stmt, nd_assign_to.arr);
					  strcat(sql_stmt, "'");
					  strcat(sql_stmt, ")))");
					
  }
  }
  //end  for ml-mmoh-crf-0582
     
  if(strcmp(nd_comm_code.arr,"NULL") != 0) 
     strcat(sql_stmt," AND NVL(RL_OUTSTANDING_WORK.REQUEST_COMMENT_CODE1,'NULL') = :nd_comm_code ");
  else
     strcat(sql_stmt, " AND :nd_comm_code = :nd_comm_code ");     

  if (includ == 'O' && strcmp(nd_out_include.arr ,"N") == 0)
  {
     strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO NOT IN \
	                    (SELECT SPECIMEN_NO FROM RL_TECHNICIAN_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
						UNION \
						SELECT SPECIMEN_NO FROM RL_ABNORMAL_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
						UNION \
						SELECT SPECIMEN_NO FROM RL_NORMAL_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id ) ");
  }
  else if (includ == 'O' && strcmp(nd_out_include.arr,"T") == 0)
  {
	 strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN \
	                    (SELECT SPECIMEN_NO FROM RL_TECHNICIAN_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id ) ");
  }
  else if (includ == 'O' && strcmp(nd_out_include.arr,"B") == 0)
  {
     strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN \
	                    (SELECT SPECIMEN_NO FROM RL_ABNORMAL_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id ) ");
  }
  else if (includ == 'O' && strcmp(nd_out_include.arr,"M") == 0)
  {
     strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN \
	                    (SELECT	SPECIMEN_NO FROM RL_NORMAL_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id ) ");
  }
  else if (includ == 'O' && strcmp(nd_out_include.arr,"V") == 0)  
 {
	
	strcat(sql_stmt, "  AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN \
	                    (SELECT	RL_REQUEST_HEADER.SPECIMEN_NO FROM RL_REQUEST_HEADER, RL_REQUEST_DETAIL \
						WHERE RL_REQUEST_HEADER.OPERATING_FACILITY_ID = :nd_operating_facility_id \
						AND RL_REQUEST_HEADER.SPECIMEN_NO=RL_REQUEST_DETAIL.SPECIMEN_NO \
						AND RL_REQUEST_HEADER.REQUEST_CHECK ='V' \
						AND NVL(RL_REQUEST_DETAIL.cancelled_yn, 'N') <> 'Y' \
						AND RL_REQUEST_HEADER.SECTION_CODE= '");

	strcat(sql_stmt, nd_dept.arr);
    strcat(sql_stmt, "')");
 } 

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
	 strcat(sql_stmt,
	    " AND NVL(A.STATUS,'O') IN ('O','A','H') ");

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

  strcat(sql_stmt," GROUP BY RL_REQUEST_DETAIL.REASON_CODE ORDER BY RL_REQUEST_DETAIL.REASON_CODE");

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    
  /* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )261;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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



  /* EXEC SQL DECLARE RQST_DTL_RSNGRP CURSOR FOR S; */ 



if (strcmp(nd_end_date.arr, "NULL") != 0)
{

  /* EXEC SQL OPEN RQST_DTL_RSNGRP USING
		:nd_operating_facility_id,
 		:nd_specimen_from  ,
 		:nd_specimen_to    ,
		:nd_priority       ,
		:nd_priority       ,
		:nd_loc_access_type,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_start_date     ,
		:nd_end_date	   ,
		:nd_assign_to	   ,
		:nd_comm_code      ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )280;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_specimen_from;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_specimen_to;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_priority;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_priority;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_loc_access_type;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[7] = (unsigned int  )8;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[8] = (unsigned int  )8;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[9] = (unsigned int  )8;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[10] = (unsigned int  )8;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[11] = (unsigned int  )8;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_start_date;
  sqlstm.sqhstl[12] = (unsigned int  )33;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_end_date;
  sqlstm.sqhstl[13] = (unsigned int  )33;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_assign_to;
  sqlstm.sqhstl[14] = (unsigned int  )33;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_comm_code;
  sqlstm.sqhstl[15] = (unsigned int  )7;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


}
else
{

  /* EXEC SQL OPEN RQST_DTL_RSNGRP USING
		:nd_operating_facility_id,
 		:nd_specimen_from  ,
 		:nd_specimen_to    ,
		:nd_priority       ,
        :nd_priority       ,
		:nd_loc_access_type,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_start_date     ,
		:nd_assign_to	   ,
		:nd_comm_code      ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )359;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_specimen_from;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_specimen_to;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_priority;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_priority;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_loc_access_type;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[7] = (unsigned int  )8;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[8] = (unsigned int  )8;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[9] = (unsigned int  )8;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_start_date;
  sqlstm.sqhstl[10] = (unsigned int  )33;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_assign_to;
  sqlstm.sqhstl[11] = (unsigned int  )33;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_comm_code;
  sqlstm.sqhstl[12] = (unsigned int  )7;
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



}

//++++

  #ifdef DEBUG
    printf("leaving dclr_rqst_dtl_rsngrp()\n");
  #endif
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )426;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_rqst_dtl_rsngrp() occured....\n");
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(specimen_length,15) into :b0  from RL_PARAM ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )441;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
  	 strcpy(nd_start_date.arr,"01/01/19000000");
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
            TO_CHAR(RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI'), \
			RL_OUTSTANDING_WORK.ASSIGN_TO \
      FROM RL_OUTSTANDING_WORK \
      WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
	  AND RL_OUTSTANDING_WORK.SPECIMEN_NO \
                       BETWEEN TO_NUMBER(:nd_fr_specimen_no) \
                           AND TO_NUMBER(:nd_to_specimen_no) \
 	  AND RL_OUTSTANDING_WORK.URGENT_INDICATOR = \
	      DECODE(:nd_priority, 'A', RL_OUTSTANDING_WORK.URGENT_INDICATOR, :nd_priority) \
	  AND NVL(RL_OUTSTANDING_WORK.PERFORM_SITE_CODE, '!!') = DECODE(:nd_loc_access_type, \
				'SA', DECODE(:nd_perform_site_cd,'NULL',NVL(RL_OUTSTANDING_WORK.PERFORM_SITE_CODE, '!!'),:nd_perform_site_cd),\
				'SS', DECODE(:nd_perform_site_cd,'NULL','!!',:nd_perform_site_cd), \
				 DECODE(:nd_perform_site_cd, 'NULL', NVL(RL_OUTSTANDING_WORK.PERFORM_SITE_CODE, '!!'),\
	  																						 :nd_perform_site_cd))\
     AND RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME BETWEEN \
	         TO_DATE(:nd_start_date,'DD/MM/YYYYHH24MI') \
	     AND TO_DATE(:nd_end_date, 'DD/MM/YYYYHH24MI')");
/**
      AND RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME >= \
              TO_DATE(:nd_start_date,'DD/MM/YYYYHH24MI')");

  if (strcmp(nd_end_date.arr, "NULL") != 0)
  {
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME < \
			  TO_DATE(:nd_end_date, 'DD/MM/YYYYHH24MI') + 1 ");
  }

**/
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN ");
	/**
	strcat(sql_stmt, "( SELECT SPECIMEN_NO FROM RL_TEST_RESULT \
					   WHERE RL_TEST_RESULT.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
					   AND RL_TEST_RESULT.TEST_CODE IN ");
	**/
	strcat(sql_stmt, "( SELECT SPECIMEN_NO FROM RL_REQUEST_DETAIL \
				   WHERE RL_REQUEST_DETAIL.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
				   AND RL_REQUEST_DETAIL.TEST_CODE IN ");
	strcat(sql_stmt, "(SELECT TEST_CODE FROM RL_TEST_CODE \
	                   WHERE SECTION_CODE = '");
	strcat(sql_stmt, nd_dept.arr);
	strcat(sql_stmt, "' AND AVERAGE_TAT IS NOT NULL \
	                    AND SYSDATE > RL_OUTSTANDING_WORK.SPEC_REGD_DATE_TIME + \
						DECODE(RL_TEST_CODE.AVERAGE_TAT_UNIT , 'MIN', \
						RL_TEST_CODE.AVERAGE_TAT/1440, 'HRS', \
						RL_TEST_CODE.AVERAGE_TAT/24, 'DAY' ,\
						RL_TEST_CODE.AVERAGE_TAT)) AND NVL(CANCELLED_YN, 'N') <> 'Y')");

    /***
    strcat(sql_stmt, " AND (RL_OUTSTANDING_WORK.SPECIMEN_NO) IN ");

    strcat(sql_stmt, "( SELECT RQH.SPECIMEN_NO FROM RL_REQUEST_HEADER RQH \
   	                  WHERE RQH.SPECIMEN_NO = RL_OUTSTANDING_WORK.SPECIMEN_NO \
    			      AND RQH.SECTION_CODE = '");
    ***/
  
  strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SECTION_CODE = '");
  strcat(sql_stmt, nd_dept.arr);
  strcat(sql_stmt, "'");

  if (strcmp(nd_source_type.arr,"NULL") != 0)
  {
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SOURCE_TYPE = '");
	strcat(sql_stmt, nd_source_type.arr);
	strcat(sql_stmt, "' AND RL_OUTSTANDING_WORK.SOURCE_CODE = '");
	strcat(sql_stmt, nd_source_code.arr);
	strcat(sql_stmt, "'");
  }

  if (strcmp(nd_fr_category_cd.arr, "NULL") != 0 && strcmp(nd_fr_category_yr.arr, "NULL") != 0
      && strcmp(nd_fr_category_no.arr , "NULL") != 0)
  {
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.CATEGORY_NUMBER BETWEEN '");
	strcat(sql_stmt, nd_fr_category_no.arr);
	strcat(sql_stmt, "' AND '");
	strcat(sql_stmt, nd_to_category_no.arr);
	strcat(sql_stmt, "'");
	strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.CATEGORY_YEAR BETWEEN '");
	strcat(sql_stmt, nd_fr_category_yr.arr);
	strcat(sql_stmt, "' AND '");
	strcat(sql_stmt, nd_to_category_yr.arr);
	strcat(sql_stmt, "' AND RL_OUTSTANDING_WORK.CATEGORY_CODE BETWEEN '");
	strcat(sql_stmt, nd_fr_category_cd.arr);
	strcat(sql_stmt, "' AND '");
	strcat(sql_stmt, nd_to_category_cd.arr);
	strcat(sql_stmt, "'");
  }

  if(strcmp(nd_assign_to.arr,"NULL") != 0)    
 	strcat(sql_stmt,
		   " AND RL_OUTSTANDING_WORK.ASSIGN_TO = NVL(:nd_assign_to, RL_OUTSTANDING_WORK.ASSIGN_TO) ");
     
  if(strcmp(nd_comm_code.arr,"NULL") != 0) 
     strcat(sql_stmt," AND NVL(RL_OUTSTANDING_WORK.REQUEST_COMMENT_CODE1,'NULL') = :nd_comm_code ");
  else
     strcat(sql_stmt, " AND :nd_comm_code = :nd_comm_code ");     

  if (includ == 'O' && strcmp(nd_out_include.arr ,"N") == 0)
  {
     strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO NOT IN \
	                    (SELECT SPECIMEN_NO FROM RL_TECHNICIAN_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
						UNION \
						SELECT SPECIMEN_NO FROM RL_ABNORMAL_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
						UNION \
						SELECT SPECIMEN_NO FROM RL_NORMAL_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id ) ");
  }
  else if (includ == 'O' && strcmp(nd_out_include.arr,"T") == 0)
  {
	 strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN \
	                    (SELECT SPECIMEN_NO FROM RL_TECHNICIAN_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id ) ");
  }
  else if (includ == 'O' && strcmp(nd_out_include.arr,"B") == 0)
  {
     strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN \
	                    (SELECT SPECIMEN_NO FROM RL_ABNORMAL_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id ) ");
  }
  else if (includ == 'O' && strcmp(nd_out_include.arr,"M") == 0)
  {
     strcat(sql_stmt, " AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN \
	                    (SELECT	SPECIMEN_NO FROM RL_NORMAL_REVIEW \
						WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id ) ");
  }
  else if (includ == 'O' && strcmp(nd_out_include.arr,"V") == 0)  
 {
	

	strcat(sql_stmt, "  AND RL_OUTSTANDING_WORK.SPECIMEN_NO IN \
	                    (SELECT	RL_REQUEST_HEADER.SPECIMEN_NO FROM RL_REQUEST_HEADER, RL_REQUEST_DETAIL \
						WHERE RL_REQUEST_HEADER.OPERATING_FACILITY_ID = :nd_operating_facility_id \
						AND RL_REQUEST_HEADER.SPECIMEN_NO=RL_REQUEST_DETAIL.SPECIMEN_NO \
						AND RL_REQUEST_HEADER.REQUEST_CHECK ='V' \
						AND NVL(RL_REQUEST_DETAIL.cancelled_yn, 'N') <> 'Y' \
						AND RL_REQUEST_HEADER.SECTION_CODE= '");

	strcat(sql_stmt, nd_dept.arr);
    strcat(sql_stmt, "')");
 } 

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
	 strcat(sql_stmt,
	    " AND NVL(A.STATUS,'O') IN ('O','A','H') ");

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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )460;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
		:nd_priority       ,
		:nd_priority       ,
		:nd_loc_access_type,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_start_date     ,
		:nd_end_date	   ,
		:nd_assign_to	   ,
		:nd_comm_code      ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )479;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_fr_specimen_no;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_specimen_no;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_priority;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_priority;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_loc_access_type;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[7] = (unsigned int  )8;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[8] = (unsigned int  )8;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[9] = (unsigned int  )8;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[10] = (unsigned int  )8;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[11] = (unsigned int  )8;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_start_date;
  sqlstm.sqhstl[12] = (unsigned int  )33;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_end_date;
  sqlstm.sqhstl[13] = (unsigned int  )33;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_assign_to;
  sqlstm.sqhstl[14] = (unsigned int  )33;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_comm_code;
  sqlstm.sqhstl[15] = (unsigned int  )7;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


}
else
{

  /* EXEC SQL OPEN REQUEST_HEADER USING
		:nd_operating_facility_id,
 		:nd_fr_specimen_no ,
 		:nd_to_specimen_no ,
		:nd_priority       ,
        :nd_priority       ,
		:nd_loc_access_type,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_perform_site_cd,
		:nd_start_date     ,
		:nd_assign_to	   ,
		:nd_comm_code      ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )558;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_fr_specimen_no;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_specimen_no;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_priority;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_priority;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_loc_access_type;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[7] = (unsigned int  )8;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[8] = (unsigned int  )8;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_perform_site_cd;
  sqlstm.sqhstl[9] = (unsigned int  )8;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_start_date;
  sqlstm.sqhstl[10] = (unsigned int  )33;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_assign_to;
  sqlstm.sqhstl[11] = (unsigned int  )33;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_comm_code;
  sqlstm.sqhstl[12] = (unsigned int  )7;
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



}


  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
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


   disp_message(ORA_MESG,"Oracle error at dclr_request_header() occured....\n");
   proc_exit();
}


void get_request_header()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT request_comment_desc1, request_comment_desc2,request_comment_desc3,
				  episode_type, patient_id,source_code,
				  category_code||category_year||category_number category_num
			 INTO :d_request_comment_desc1, :d_request_comment_desc2,
				  :d_request_comment_desc3, :d_episode_type, :d_patient_id,:d_source_code,
				  :d_category_num
				 
			 FROM RL_REQUEST_HEADER
			WHERE specimen_no = :d_specimen_no
			AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select request_comment_desc1 ,request_comment_desc2 ,reques\
t_comment_desc3 ,episode_type ,patient_id ,source_code ,((category_code||categ\
ory_year)||category_number) category_num into :b0,:b1,:b2,:b3,:b4,:b5,:b6  fro\
m RL_REQUEST_HEADER where (specimen_no=:b7 and OPERATING_FACILITY_ID=:b8)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )640;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
  sqlstm.sqhstv[5] = (         void  *)&d_source_code;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_category_num;
  sqlstm.sqhstl[6] = (unsigned int  )21;
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
  sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[8] = (unsigned int  )5;
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


            
  d_patient_id.arr[d_patient_id.len]='\0';
  d_source_code.arr[d_source_code.len]='\0';
  d_episode_type.arr[d_episode_type.len]='\0';
  d_request_comment_desc1.arr[d_request_comment_desc1.len] = '\0';
  d_request_comment_desc2.arr[d_request_comment_desc2.len] = '\0';
  d_request_comment_desc3.arr[d_request_comment_desc3.len] = '\0';
  d_category_num.arr[d_category_num.len]='\0';


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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )691;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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

  strcpy(nd_specimen_from.arr, d_specimen_no.arr);
  nd_specimen_from.len = strlen(nd_specimen_from.arr);
  nd_specimen_from.arr[nd_specimen_from.len] = '\0';
  
  while(still_rec_left)
  {

	   /***
	   if(line_no >= (MAX_LINES - 3))
       {  
		  fprintf(f1,"%c(s4B",ESC);
		  fprintf(f1,"\nC - Rejected ,O - Outstanding,H - Hold,A - Reviews");

	      fprintf(f1,"\nI - Interval Tests,R - Resulted,P - Printed");
	
		  
		  fprintf(f1,"%c(s-3B",ESC);
		  fprintf(f1,"\n");
          prepare_new_page();
	      print_detl_rec();
       }
       else
	   ***/ 
       print_detl_rec();

       still_rec_left = fetch_request_header();

  }

  #ifdef DEBUG
      printf("entered do_report outside while()\n");
      fflush(stdout);
  #endif
  
  strcpy(nd_specimen_to.arr, d_specimen_no.arr);
  nd_specimen_to.len = strlen(nd_specimen_to.arr);
  nd_specimen_to.arr[nd_specimen_to.len] = '\0';
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
   d_avg_tat_unit.arr[0]	= '\0';
   d_avg_tat_unit.len		= 0;
   d_expected_date.arr[0]	= '\0';
   d_expected_date.len		= 0;
   d_reason_code.arr[0]     = '\0';
   d_reason_code.len        = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH REQUEST_DETAIL INTO
		 :d_test_code,
		 :d_result_status,
		 :d_group_test_yn,
		 :d_reason_code,
 		 :d_avg_tat,
		 :d_avg_tat_unit,
		 :d_expected_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )706;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
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
  sqlstm.sqhstv[3] = (         void  *)&d_reason_code;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_avg_tat;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(float);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_avg_tat_unit;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_expected_date;
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
  d_avg_tat_unit.arr[d_avg_tat_unit.len]	= '\0';
  d_expected_date.arr[d_expected_date.len]	= '\0';
  d_reason_code.arr[d_reason_code.len]      = '\0';


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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )749;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_detail() occured....\n");
   proc_exit();
}

/*---------------------------------------------------------------------------*/
/*  Fetching rows from REQUEST_DETAIL for the Reason Code Summary */
int fetch_rqst_dtl_rsngrp()
{
   d_reason_code_sum.arr[0]	= '\0';
   d_reason_code_sum.len		= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH RQST_DTL_RSNGRP INTO
		 :d_reason_code_sum,
		 :d_reason_cnt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )764;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_reason_code_sum;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_reason_cnt;
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



   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_reason_code_sum.arr[d_reason_code_sum.len]='\0';


#ifdef DEBUG
 printf("d_reason_code_sum= %s\n",d_reason_code_sum.arr);
#endif
return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )787;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_rqst_dtl_rsngrp() occured....\n");
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
		:d_spec_regd_date,
		:d_assign_to; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )802;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_spec_regd_date;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_assign_to;
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


		
   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_specimen_no.arr[d_specimen_no.len]      = '\0';
  d_spec_regd_date.arr[d_spec_regd_date.len]    = '\0';
  d_assign_to.arr[d_assign_to.len]    = '\0';
  

#ifdef DEBUG
 printf("d_specimen_no = %s\n",d_specimen_no.arr);
 printf("d_spec_regd_date = %s\n",d_spec_regd_date.arr);
 printf("d_assign_to = %s\n",d_assign_to.arr);
  
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )829;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_header() occured....\n");
   proc_exit();
}

/********* GET EXPECTED COMPLETION DATE  **********/

  get_expected_completion_dt()
  {
    d_expected_date.arr[0]	= '\0';
	d_expected_date.len		= 0;
		

 	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	  /* EXEC SQL SELECT TO_CHAR((TO_DATE(:d_spec_regd_date,'DD/MM/YYYY HH24:MI')+:d_avg_tat),'DD/MM/YYYY HH24:MI') 
	           INTO :d_expected_date
			   FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY HH24:MI')+:b1),'DD\
/MM/YYYY HH24:MI') into :b2  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )844;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_avg_tat;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(float);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_expected_date;
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


#ifdef DEBUG
    printf("leaving dclr_section_cur()\n");
    fflush(stdout);
#endif

	d_expected_date.arr[d_expected_date.len]	= '\0';	

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )871;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_expected_completion_dt() occured....\n");
   proc_exit();	
  }
  
/** Get the Overdue Reason description **/
void get_reason_desc(d_code)
char *d_code;
{

	strcpy(d_reason_code_1.arr,d_code);
	
	d_reason_code_1.len = strlen(d_reason_code_1.arr);
	d_reason_code_1.arr[d_reason_code_1.len] = '\0';
		 
	d_reason_desc.arr[0] = '\0';
	d_reason_desc.len    = 0;

 	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL SELECT SHORT_DESC
	INTO :d_reason_desc
	FROM RL_REASON_CODE_LANG_VW
	WHERE REASON_CODE = :d_reason_code_1
	AND   LANGUAGE_ID = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_DESC into :b0  from RL_REASON_CODE_LANG_VW wher\
e (REASON_CODE=:b1 and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )886;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_reason_desc;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_reason_code_1;
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


	
	d_reason_desc.arr[d_reason_desc.len] = '\0';
	
//	sprintf(string_var,"Length : %d  In value: %s Copied : %s Reason: %s\n",d_reason_desc.len,d_code, d_reason_code_1.arr,d_reason_desc.arr);
//	disp_message(ERR_MESG,string_var) ;
	
	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )913;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_reason_desc() occured....\n");
   proc_exit();	

}
/*---------------------------------------------------------------------------*/
/* print the finishing line of the report */
void end_report()
{ 
  
   fprintf(f1,"%c(s4B",ESC);
   //fprintf(f1,"\n\nC - Rejected ,O - Outstanding,H - Hold,A - Reviews");
   //fprintf(f1,"\nI - Interval Tests,R - Resulted,P - Printed");
   fprintf(f1,"\nC - %-8.8s ,O - %-11.11s,H - %-4.4s,A - %-7.7s",local_legend[2],local_legend[3],local_legend[4],local_legend[5]);
   //fprintf(f1,"\nI - %-14.14s,R - %-8.8s,P - %-7.7s",local_legend[6],local_legend[7],local_legend[8]);
   //commented the above statement and added the below statement for adding the one legend 'Verification' added by srinivas
   fprintf(f1,"\nI - %-14.14s,R - %-8.8s,P - %-7.7s,V - %-13.13s",local_legend[6],local_legend[7],local_legend[8],local_legend[64]);
	 
   
   fprintf(f1,"%c(s-3B",ESC);
   fprintf(f1,"\n");
   fprintf(f1,"\f");
   close_request_header();
   page_no++;
   print_page_header();

   dclr_rqst_dtl_rsngrp();
  
   fprintf(f1,"\n\n%-7.7s\n",local_legend[27]);
   fprintf(f1,"=======\n");

  while(fetch_rqst_dtl_rsngrp())
  {
	if (d_reason_cnt)
	{
		get_reason_desc(d_reason_code_sum.arr);

		if (strlen(d_reason_desc.arr) == 0)
			strcpy(d_reason_desc.arr, local_legend[62]);

		fprintf(f1,"\n%-8s %-20s   %d", d_reason_code_sum.arr, d_reason_desc.arr,d_reason_cnt);
	}
  }

  fprintf(f1,"\n\n");
  fprintf(f1,"\n");
  fprintf(f1,"                         ");
  fprintf(f1,"** %s **",local_legend[16]);
  fprintf(f1,"\f");
}

/*---------------------------------------------------------------------------*/
/* to print the detailed record */
void print_detl_rec()
{   
    int  get_in_patient_dtl(); 
    void get_referral_patient_dtl();
	void get_request_header();	

    int i= 0,j =0, k=0,cnt = 21, cnt1 = 0;
	char flag[1] ;
    nd_req_tests.arr[0] = '\0';
	nd_tests_status.arr[0] = '\0';
	nd_tests_exp_date.arr[0] = '\0';

	/****Initialization getting the tests and the expected date *****/
		for (k = 0; k < 100; k++)
		{
		   d_test_name[k][0] = '\0';
		   d_test_date[k][0] = '\0';
		   d_exp_test_date[k][0] = '\0';
		   d_avg_tat_unit_d [k][0] = '\0';
		   d_reason_code_d[k][0] = '\0';
		   d_result_stat_d[k][0] = '\0';

		}
			test_counter = 0;

	/****************************************************************/

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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )928;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date;
    sqlstm.sqhstl[0] = (unsigned int  )33;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}

 
  
    chk_break(5);

			/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_spec_regd_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:d_spec_regd_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:d_spec_regd_date1 :=sm_convert_datetime_2t(to_date(:d_spec_regd_date,'DD/MM/YYYY HH24:MI'),:language_id);
				END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN :d_spec_regd_date1 := sm_conve\
rt_datetime_2t ( to_date ( :d_spec_regd_date , 'DD/MM/YYYY HH24:MI' ) , :langu\
age_id ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )963;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date1;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_spec_regd_date;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



	fprintf(f1,"\n%-16.16s%-18s",d_specimen_no.arr,d_spec_regd_date1.arr);
	// fprintf(f1,"%-10.10s %-24.24s",d_patient_id.arr,d_patient_name.arr);
	fprintf(f1,"%-6s %-12.12s\n",d_source_code.arr,d_assign_to.arr);

	fprintf(f1,"%-10.10s:%-23.21s%-4.4s: %-59.59s\n",local_legend[17],d_patient_id.arr,local_legend[18],d_patient_name.arr);
	  
	line_no += 3 ;
    
    if (strcmp(d_category_yn.arr,"Y") == 0)
	{ 
	  chk_break(3);

	  fprintf(f1,"%c(s4B",ESC);
      fprintf(f1,"\n%-11.11s: ",local_legend[20]);
      fprintf(f1,"%c(s-3B",ESC); 
	  fprintf(f1,"%-18s\n",d_category_num.arr); 
//06.09.2005      line_no += 1 ;
      line_no += 2;
     }

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
	   
     /* code commented here for comment desc*/
       /* concatenate for the tests*/
	   strcat(nd_req_tests.arr,d_test_code.arr);
	   strcat(nd_req_tests.arr," ");
 
     /* concatenate for the tests suffixed by the status*/
	   strcat(nd_tests_status.arr,d_test_code.arr);
	   strcat(nd_tests_status.arr,"-");
       strcat(nd_tests_status.arr,d_result_status.arr);
       strcat(nd_tests_status.arr," ");	

		/* Added on 29/02/2004 For getting the tests and the expected completion date  ***/

		//get_expected_completion_dt();
		strcpy(d_test_name[test_counter],d_test_code.arr);
		strcpy(d_test_date[test_counter],d_spec_regd_date.arr);
		strcpy(d_exp_test_date[test_counter],d_expected_date.arr);
		strcpy(d_avg_tat_unit_d[test_counter],d_avg_tat_unit.arr);
		d_avg_tat_d[test_counter] = d_avg_tat;
		strcpy(d_reason_code_d[test_counter],d_reason_code.arr);
		strcpy(d_result_stat_d[test_counter], d_result_status.arr);
		test_counter++;

    }
	 
	 chk_break(4);

     fprintf(f1,"%c(s4B",ESC);
     fprintf(f1,"%-15.15s:",local_legend[21]);
     
	 //fprintf(f1,"%c(s-3B",ESC);
	 //fprintf(f1,"%-50.50s",nd_req_tests.arr);

	 split_test_line(nd_req_tests.arr, 59);
	  
	 fprintf(f1,"\n");
	 fprintf(f1,"%c(s4B",ESC);
	 fprintf(f1,"%-6.6s:",local_legend[22]);
	 
	 //fprintf(f1,"%c(s-3B",ESC); 
	 //fprintf(f1,"%-50.50s",nd_tests_status.arr);
	 
	 split_test_line(nd_tests_status.arr, 68);

     fprintf(f1, "\n");

//06.09.2005	 line_no = line_no + 1;
	 line_no = line_no + 2;

	/**printing the expected completion date*/
	
	fprintf(f1, "%-4.4s            %-16.16s  %-7.7s   %-6.6s\n",local_legend[23],local_legend[24],local_legend[25],local_legend[26]);
	fprintf(f1, "--------------------------------------------------\n");
	
	line_no = line_no + 2;

	for(k=0;k<test_counter;k++)
	{

	 chk_break(3);

	 get_reason_desc(d_reason_code_d[k]);

	 fprintf(f1,"%c(s4B",ESC);
	 //fprintf(f1,"Status: ");
	 fprintf(f1,"%c(s-3B",ESC);  	 	 
	 
	//added
	strcpy(d_exp_test_date1, d_exp_test_date[k]);
	
	 //added
	 /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				:d_exp_test_date1 :=sm_convert_datetime_2t(to_date(:d_exp_test_date1,'DD/MM/YYYY HH24:MI'),:language_id);
				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :d_exp_test_date1 := sm_convert\
_datetime_2t ( to_date ( :d_exp_test_date1 , 'DD/MM/YYYY HH24:MI' ) , :languag\
e_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )990;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)d_exp_test_date1;
  sqlstm.sqhstl[0] = (unsigned int  )31;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



		
	/* 
	 fprintf(f1,"%-15s %-17s %d %-5s %5s %16s",
	         d_test_name[k],d_exp_test_date[k], d_avg_tat_d[k],d_avg_tat_unit_d[k], 
			 d_reason_code_d[k],d_reason_desc.arr);
	 */

	 fprintf(f1,"%-15s %-17s %d %-5s %5s %16s",
	         d_test_name[k],d_exp_test_date1, d_avg_tat_d[k],d_avg_tat_unit_d[k], 
			 d_reason_code_d[k],d_reason_desc.arr);


	 if (strcmp(d_result_stat_d[k], "O") == 0)
		fprintf(f1, "- %-10s", local_legend[28]);
     
	 fprintf(f1, "\n");

	 line_no = line_no + 1;
	 }

/*******************************************************/    
/*	 nd_req_tests.arr[0] = '\0';
	 nd_tests_status.arr[0] = '\0';	*/

return;

err_exit:

   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1013;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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

   /* EXEC SQL SELECT SUBSTR(DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) ,1,24)
	           INTO :d_patient_name
            FROM RL_PATIENT_MAST
	    WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_lo\
c_lang,SHORT_NAME)),1,24) into :b1  from RL_PATIENT_MAST where PATIENT_ID=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1028;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1055;
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
int get_in_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) ,1,24) INTO
	           :d_patient_name
            FROM MP_PATIENT_MAST 
	    WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_lo\
c_lang,SHORT_NAME)),1,24) into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1070;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1097;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
  char nd_dept_desc[10],
       nd_fr_specimen_desc[21],
       nd_to_specimen_desc[21],
	   nd_priority_desc[30],
	   nd_start_date_desc[31],
	   nd_end_date_desc[31],
	   nd_assign_to_desc[31],
	   nd_workgroup_desc[5],
	   nd_test_code_desc[11],
	   nd_ref_lab_desc[10],
	   nd_fr_category_desc[50],
	   nd_to_category_desc[50],
	   nd_perform_site_desc[10],
	   nd_source_type_desc[10],
	   nd_source_code_desc[10],
	   nd_include_option_desc[200],
	   l_temp[50];
char str_var[100];
char str_var1[100];
int i;
  strcpy(nd_dept_desc, nd_dept.arr);

  if(strcmp(nd_fr_specimen_no.arr, "!!!!!!!!!") == 0)
    strcpy(nd_fr_specimen_desc, local_legend[49]);
    else strcpy(nd_fr_specimen_desc, nd_fr_specimen_no.arr);

  if(strcmp(nd_to_specimen_no.arr, "~~~~~~~~~") == 0)
    strcpy(nd_to_specimen_desc, local_legend[50]);
  else 
    strcpy(nd_to_specimen_desc, nd_to_specimen_no.arr);

  if (strcmp(nd_priority.arr, "A") == 0)
    strcpy(nd_priority_desc, local_legend[48]);
  else if (strcmp(nd_priority.arr, "R") == 0)
	strcpy(nd_priority_desc, local_legend[51]);
  else if (strcmp(nd_priority.arr, "U") == 0)
	strcpy(nd_priority_desc, local_legend[52]);
  else if (strcmp(nd_priority.arr, "S") == 0)
	strcpy(nd_priority_desc, local_legend[53]);

  if (strlen(nd_start_date.arr) == 0) 
    strcpy(nd_start_date_desc, local_legend[49]);
  else
	/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_start_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:nd_start_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:nd_start_date1 :=sm_convert_datetime_2t(to_date(:nd_start_date,'DD/MM/YYYY HH24:MI'),:language_id);
				END;
			END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_start_date1 := sm_convert_da\
tetime_2t ( to_date ( :nd_start_date , 'DD/MM/YYYY HH24:MI' ) , :language_id )\
 ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1112;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_start_date1;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_start_date;
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



	strcpy(nd_start_date_desc, nd_start_date1.arr);

  if (strlen(nd_end_date.arr) == 0) 
    strcpy(nd_end_date_desc, local_legend[49]);
  else
	/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_end_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:nd_end_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:nd_end_date1 :=sm_convert_datetime_2t(to_date(:nd_end_date,'DD/MM/YYYY HH24:MI'),:language_id);

				END;
			END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_end_date1 := sm_convert_date\
time_2t ( to_date ( :nd_end_date , 'DD/MM/YYYY HH24:MI' ) , :language_id ) ; E\
ND ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1139;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_end_date1;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_end_date;
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



	strcpy(nd_end_date_desc, nd_end_date1.arr);

  if (strcmp(nd_assign_to.arr, "NULL") == 0)
	strcpy(nd_assign_to_desc, "");
  else
	strcpy(nd_assign_to_desc, nd_assign_to.arr);

  if (strcmp(nd_workgroup_code.arr, "NULL") == 0)
    strcpy(nd_assign_to_desc, "");
  else
	strcpy(nd_workgroup_desc, nd_workgroup_code.arr);

  if (strcmp(nd_test_code.arr, "NULL") == 0 )
	strcpy(nd_test_code_desc, "");
  else
    strcpy(nd_test_code_desc, nd_test_code.arr);

  if (strcmp(nd_referred_lab.arr, "NULL") == 0)
	strcpy(nd_ref_lab_desc, "");
  else
	strcpy(nd_ref_lab_desc, nd_referred_lab.arr);

  if (strcmp(nd_fr_category_cd.arr, "NULL") == 0)
    strcpy(nd_fr_category_desc, "");
  else
    {
	sprintf(l_temp, "%s %s %s", nd_fr_category_cd.arr, nd_fr_category_yr.arr, nd_fr_category_no.arr);
	strcpy(nd_fr_category_desc, l_temp);
    }
  
  if (strcmp(nd_to_category_cd.arr, "NULL") == 0)
    strcpy(nd_to_category_desc , "");
  else
    {
	sprintf(l_temp, "%s %s %s", nd_to_category_cd.arr, nd_to_category_yr.arr, nd_to_category_no.arr);
	strcpy(nd_to_category_desc, l_temp);
    }    

  if (strcmp(nd_perform_site_cd.arr, "NULL") == 0)
    strcpy(nd_perform_site_desc, "");
  else
    strcpy(nd_perform_site_desc, nd_perform_site_cd.arr);

  if (includ == 'A') 
  {
    strcpy(nd_include_option_desc, local_legend[48]);
  }
  else
    if (includ == 'O' && strcmp(nd_out_include.arr, "A") == 0)
	{
	  strcpy(nd_include_option_desc, local_legend[54]);
	}
	else if (includ = 'O' && strcmp(nd_out_include.arr, "N") == 0)
	{
      strcpy(nd_include_option_desc, local_legend[55]);
	}
	else if (includ = 'O' && strcmp(nd_out_include.arr, "T") == 0)
	{
      strcpy(nd_include_option_desc, local_legend[56]);
	}
	else if (includ = 'O' && strcmp(nd_out_include.arr, "B") == 0)
	{
      strcpy(nd_include_option_desc, local_legend[57]);
	}
	else if (includ = 'O' && strcmp(nd_out_include.arr, "M") == 0)
	{
      strcpy(nd_include_option_desc, local_legend[58]);
	}
	else if (includ = 'O' && strcmp(nd_out_include.arr, "V") == 0)
	{
	
      strcpy(nd_include_option_desc, local_legend[63]);
	
	}

  if (strcmp(nd_source_type.arr, "NULL") == 0 )
	{
		strcpy(nd_source_type_desc, "");
	}
  else
	{
		if (strcmp(nd_source_type.arr, "W") == 0)
		{
			strcpy(nd_source_type_desc, local_legend[59]);
		}
		else if (strcmp(nd_source_type.arr, "C") == 0)
		{
			strcpy(nd_source_type_desc, local_legend[60]);
		}
		else if (strcmp(nd_source_type.arr, "E") == 0)
		{
			strcpy(nd_source_type_desc, local_legend[61]);
		}

	}

  if (strcmp(nd_source_code.arr, "NULL") == 0 )
	{
		strcpy(nd_source_code_desc, "");
	}
  else
	{
		strcpy(nd_source_code_desc, nd_source_code.arr);
	}

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
  /*fprintf(f1,"        ");
  fprintf(f1,"INPUT PARAMETERS :\n");
  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  fprintf(f1,"                ");*/
  rec_len = strlen(local_legend[29]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"%s:\n", local_legend[29]);//added for glob
  print_space(40, rec_len,1);//added for globalisation
  print_space(40, rec_len,0);//added for globalisation
  
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n",local_legend[30], nd_dept_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%s",local_legend[31]);
  rec_len = strlen(local_legend[32]);
  col = 46 - (strlen(local_legend[31]) +16);
  col = col - rec_len;
  sprintf(str_var,"%d",col);
   for(i=1;i <= col ;i++)
		{
			fprintf(f1,"%s"," ");
		}	
fprintf(f1,"%s : %s\n",local_legend[32],nd_fr_specimen_desc);
  fprintf(f1,"                ");
  rec_len = strlen(local_legend[33]);
  for(i=1;i <= 30-rec_len ;i++)
		{
			fprintf(f1,"%s"," ");
		}	

  
  fprintf(f1,"%s : %s\n", local_legend[33],nd_to_specimen_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n",local_legend[34], nd_priority_desc);
  fprintf(f1,"                ");
  		
  fprintf(f1,"%-30.30s : %s\n",local_legend[35], nd_start_date_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n",local_legend[36], nd_end_date_desc);
  fprintf(f1,"                ");
  
  fprintf(f1,"%s",local_legend[37]);
  rec_len = strlen(local_legend[32]);
  col = 46 - (strlen(local_legend[37]) +16);
  col = col - rec_len;
  sprintf(str_var1,"%d",col);
   for(i=1;i <= col ;i++)
		{
			fprintf(f1,"%s"," ");
		}	
fprintf(f1,"%s : %s\n",local_legend[32],nd_fr_category_desc);
    

  //fprintf(f1,"%s : %s\n", local_legend[33],nd_to_category_desc);
  fprintf(f1,"                ");
  rec_len = strlen(local_legend[33]);
  for(i=1;i <= 30-rec_len ;i++)
		{
			fprintf(f1,"%s"," ");
		}	

  
  fprintf(f1,"%s : %s\n", local_legend[33],nd_to_category_desc);
  
  
  
  
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n",local_legend[38], nd_assign_to_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n",local_legend[39], nd_workgroup_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n",local_legend[40], nd_test_code_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n",local_legend[41], nd_ref_lab_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n",local_legend[42], nd_perform_site_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n", local_legend[43],nd_source_type_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n", local_legend[44],nd_source_code_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-30.30s : %s\n", local_legend[45],nd_include_option_desc);
  fprintf(f1,"\n");
  fprintf(f1,"\f");
}


/* to print page headers the header details */ 
void print_page_header()
{
 register int i;
 char nd_fr_specimen_desc[21],
       nd_to_specimen_desc[21];
	   char buf[100];

  if(strcmp(nd_fr_specimen_no.arr, "!!!!!!!!!") == 0)
    strcpy(nd_fr_specimen_desc, "LOWEST");
    else strcpy(nd_fr_specimen_desc, nd_fr_specimen_no.arr);

  if(strcmp(nd_to_specimen_no.arr, "~~~~~~~~~") == 0)
    strcpy(nd_to_specimen_desc, "HIGHEST");
    else strcpy(nd_to_specimen_desc,nd_to_specimen_no.arr);

 /**********Commented by babu for globalization
 fprintf(f1,"\nMDL : RL    ");
 fprintf(f1,"          ");  
 fprintf(f1,"%-30.30s", d_acc_entity_name.arr);
 fprintf(f1,"          ");  
 fprintf(f1,"%s", d_sysdate.arr);
 fprintf(f1,"\n");
 fprintf(f1,"OPR : %s", d_user.arr);
 fprintf(f1,"               ");  
 fprintf(f1,"OUTSTANDING OVERDUE ");
 fprintf(f1,"               ");  
 fprintf(f1,"Page:%4d", page_no);
 fprintf(f1,"\n");
 fprintf(f1,"REP : RLROSOVD");
 fprintf(f1,"\n");
*****************END***************************/
/**********************Added by babu for globalization****************************/
		memset(hdr_line1,' ',REP_WIDTH+1);
        strncpy(hdr_line1,"MDL:RL",6);
        col = (int)(REP_WIDTH - strlen(d_acc_entity_name.arr))/2;
        strncpy(hdr_line1 + col -1,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//t_date:=GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
				END;
			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 16;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert\
_datetime_2t ( SYSDATE , :language_id ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1166;
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
		strcpy(hdr_line1+col-4,d_sysdate1.arr);

		  memset(hdr_line2,' ',REP_WIDTH+1);
		  strncpy(hdr_line2,"OPR:",4);
		  strncpy(hdr_line2+4,d_user.arr,strlen(d_user.arr));
		  strcpy(rep_title1, local_legend[46] );
		  col = (int)(REP_WIDTH-strlen(rep_title1))/2;
		  strncpy(hdr_line2+col,rep_title1,strlen(rep_title1));

		  sprintf(buf,"%s : %4d",local_legend[1],page_no);
		  strcpy(hdr_line2+(REP_WIDTH-4-strlen(buf)),buf);
   
   fprintf(f1,"\n");
   fprintf(f1,hdr_line1);
   fprintf(f1,"\n");
   fprintf(f1,hdr_line2);
   fprintf(f1,"\n");
   fprintf(f1,"REP:RLROSOVD");
   fprintf(f1,"\n");
   fprintf(f1,"\n");
 



/**********************end by babu for globalization****************************/  




 //line_no += 4;
 line_no += 5;
}


/* print the heading */
void print_col_heading()
{
 
/* col headings here */
 
 fprintf(f1,"%c(s4B",ESC);
 fprintf(f1, "%-11.11s     %-9.9s    %-5.5s %-9.9s\n",local_legend[31],local_legend[47],local_legend[44],local_legend[38]);
 fprintf(f1, "------------------------------------------------------------------------------\n");
 fprintf(f1,"%c(s-3B",ESC); 
//06.09.2005 line_no += 3;
 line_no += 2;
}

/*--------------------------------------------------------------------------*/
gen_file_name()
{
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
	 strcpy(OUTPUT_FILE_NAME,"rlrosovd.lis");
	 strcpy(nd_file_name.arr,WORKING_DIR);
	 strcat(nd_file_name.arr,"rlrosovd.lis");
     
     if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
	 /*{
	     fprintf(f1,"%c&|26A",ESC);
		 fprintf(f1,"%c&a90P",ESC);
	     fprintf(f1,"%c&|1O",ESC);
	     fprintf(f1,"%c&k4S",ESC);
	 }*/


}
/*--------------------------------------------------------------------------*/
/************* 01.07.2003
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
***********/
/*--------------------------------------------------------------------------*/

/********************** 09.02.2004
print_job()
{
char command_line[500];

     nd_printer_name.arr[0]   = '\0';
     nd_printer_name.len      = 0;
/// 01.07.2003
//     EXEC SQL SELECT PRINTER_NAME
//	        INTO :nd_printer_name
//	        FROM RL_SECTION_CODE_LANG_VW
//	       WHERE SECTION_CODE LIKE :nd_dept
			AND  LANGUAGE_ID = :language_id;
/// 
     if (OERROR)
         err_mesg("Fetch failed on table RL_SECTION_CODE",0,"");
      
     nd_printer_name.arr[nd_printer_name.len] = '\0';

     sprintf(command_line,"lp -s -d %s rlrosovd_%s.lis ",nd_printer_name.arr,nd_file_no.arr);
  system(command_line);
}
***************************/


print_job()
{
	if (strcmp(nd_trx_ind.arr,"Y") == 0)

		 PrintDocument
			   (
				uid_pwd.arr,		//char	*PUidPwd;
				nd_session_id.arr,	//char	*PSessionID;
				nd_operating_facility_id.arr,	//char	*PFacilityID;
				"RL",				//char	*PModuleID;
				"RLROSOVD",			//char	*PDocumentID;
				nd_file_name.arr,			//char	*POnlinePrintFileNames;
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
				"RLROSOVD",			//char	*PDocumentID;
				nd_file_name.arr,			//char	*POnlinePrintFileNames;
				"O",				//char	*PLocationTypes;
				"~",				//char	*PLocationCodes;
				1,					//int		PNumOfCopies;
				1,					//int		PPageFrom;
				9999					//int		PPageTo;
			   );  
}


chk_break(int lin)
{
   if ((line_no + lin) >= (MAX_LINES - 3 ))
   { 
	 fprintf(f1,"%c(s4B",ESC);
     fprintf(f1,"\nC - %-8.8s ,O - %-11.11s,H - %-4.4s,A - %-7.7s",local_legend[2],local_legend[3],local_legend[4],local_legend[5]);
	 //fprintf(f1,"\nI - %-14.14s,R - %-8.8s,P - %-7.7s",local_legend[6],local_legend[7],local_legend[8]);
	 //commented the above statement and added the below statement for adding the one legend 'Verification'  added by srinivas
	 fprintf(f1,"\nI - %-14.14s,R - %-8.8s,P - %-7.7s,V - %-13.13s",local_legend[6],local_legend[7],local_legend[8],local_legend[64]);
	 fprintf(f1,"%c(s-3B",ESC); 
     //fprintf(f1,"");
	 fprintf(f1,"\n");

	 prepare_new_page();
	 
	 //print_page_header();
	 //line_no = 1;
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
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_SPECIME\
NS where ((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and test_\
code=:b3)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1189;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
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
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_SPECIME\
NS where ((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and test_\
code=:b3)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1220;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0039;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1251;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
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

int fetch_group_curs()
{
   id_test_code.arr[0]		= '\0';
   id_test_code.len			= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH group_curs INTO
		 :id_test_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1270;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1289;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1304;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

close_request_header()
{
	/* EXEC SQL CLOSE REQUEST_HEADER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1319;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/*---------------------------------------------------------------------------*/
fprint_repeat(l_fp,l_prn_chr,l_no)
FILE *l_fp;
char l_prn_chr;
int  l_no;
{
   int l_i = 0;
   
   for (l_i = 0;l_i < l_no;l_i++)
        fputc(l_prn_chr,l_fp);
}


/*------------------------------------------------------------*/
/* SPLITTING THE TEST CODES INTO 50 CHARACTERS              */
/*------------------------------------------------------------*/

split_test_line(l_test_line, l_max)
char *l_test_line;
int l_max;
{
  
	char word[2];
	char w_flag ;

    strcpy(word11,"F");

	w_flag = 'T';

	l_len = strlen(l_test_line);


		z1 = 0;
		clt1 = 0;
		strcpy(word11,"F");
		cntr1 = 1;
		qq1 = 0;

         while(z1<l_len)
         {
		 		  	
		 
             word[0] = l_test_line[z1];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
   
		       cntr1 = 0;
		       strcpy(word11,"N");
		       qq1 = z1 ;
		      }


  		      if(cntr1 >= l_max+1)
		      {
		   	
			     cmp1 = cntr1;
			     while((l_test_line[z1] != 32) && (cmp1 > 1))
			     {

			         z1--;
				     cmp1--;
				  
			      }

				  qq1 = z1;
				  			   
			      word[0] = l_test_line[z1];
   			      word[1] = '\0';
		
		  	      if (cmp1 == 1)
				     strcpy(word11,"W");
			      else
			         strcpy(word11,"T");
			   
		
		       }


				if (((z1 == l_len) || (z1 == l_len - 1)) && (strcmp(word11,"F") == 0))
				{
	
				   fprintf(f1,"%c(s-3B",ESC);
				   fprint_repeat(f1,' ',1);		   
				   for(i=clt1;i < z1 + 1;i++)
		           {
						if(l_test_line[i] == '\n')
						{

							    w_flag = 'F';
 						 }

						fprintf(f1,"%c",l_test_line[i]);
			
			       }

				   if (w_flag == 'T')
				   {
				   };

			       fprintf	(f1,"\n");
				   line_no = line_no + 1;
				   chk_break(1);
				   fprint_repeat(f1,' ',75-l_max);
				   cntr1 = 0 ;
				   clt1 = clt1 + l_max;
				   z1 = clt1 ;
			       qq1 = 0;
				   strcpy(word11,"F");


				}

			
		       if (strcmp(word11,"N") == 0) 
		       {
				
		          fprintf(f1,"%c(s-3B",ESC);
				  fprint_repeat(f1,' ',1);
				  
				  for(i=clt1;i<=qq1;i++)
		          {
			         if(l_test_line[i] == '\n')
					{
						  
								w_flag = 'F';

				    }

				    fprintf(f1,"%c",l_test_line[i]);
					
			      }

				  if (w_flag == 'T')
				  {
				  };
					
			      strcpy(word11,"F");
			      cntr1 = 0 ;
			      clt1 = qq1 + 1;
		          qq1 = 0;
	   	       }

		       if (strcmp(word11,"T") == 0)
		       {
		 										 
			      fprintf(f1,"%c(s-3B",ESC);
				  fprint_repeat(f1,' ',1);
				  
				  for(i=clt1;i<= qq1;i++)
		          {
		             if(l_test_line[i] == '\n')
					 {
								w_flag = 'F';
					  }

					  fprintf(f1,"%c",l_test_line[i]);
				
			      }

				  if (w_flag == 'T')
				  {
				  };


			       fprintf	(f1,"\n");
				   line_no = line_no + 1;
				   chk_break(1);
				   fprint_repeat(f1,' ', 75-l_max);

			       cntr1 = 0 ;
				   clt1 = qq1 + 1 ;
			       qq1 = 0;
				   strcpy(word11,"F");

				
		        }


		        if (strcmp(word11,"W") == 0)
		        {
		 										 
			       fprintf(f1,"%c(s-3B",ESC);
				   fprint_repeat(f1,' ',1);

				   for(i=clt1;i < clt1 + l_max;i++)
		           {
		              if(l_test_line[i] == '\n')
						{

								w_flag = 'F';
						}

						fprintf(f1,"%c",l_test_line[i]);
				
			       }

				   if (w_flag = 'T')
				   {
				   };

			       fprintf(f1,"\n");
				   line_no = line_no + 1;
				   chk_break(1);
				   fprint_repeat(f1,' ',75-l_max);
				   cntr1 = 0 ;
				   clt1 = clt1 + l_max ;
				   z1 = clt1 ;
			       qq1 = 0;
				   strcpy(word11,"F");

				
		        }

			w_flag = 'T';	  
	        cntr1 += 1;
	        z1++ ;
          }

       fflush(f1);

#ifdef DEBUG
   printf("test_code Desc = %s\n", l_test_line);
#endif

if (OERROR)
	  disp_message(ERR_MESG, "SPLITTING failed ");

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
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1334;
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
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1353;
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

/**************************select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N')
	          INTO   :nd_trx_ind
	          FROM   sy_online_print_id
              WHERE  ONLINE_PRINT_NAME = 'RLROSOVD'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where ONLINE_PRINT_NAME='RLROSOVD'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1372;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
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



	if(OERROR)
	{
	    disp_message(ERR_MESG,"SELECT failed on  SY_ON_LINE_PRINT_ID");
		proc_exit();
	}

	nd_trx_ind.arr[nd_trx_ind.len]			= '\0';


    if(NO_DATA_FOUND)
		return 0;

		
	return 1;

}

//// #define ONLINE_PRINTING 0


#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
