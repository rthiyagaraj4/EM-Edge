
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRWLRES.pc"
};


static unsigned int sqlctx = 1288616771;


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
            void  *sqhstv[58];
   unsigned int   sqhstl[58];
            int   sqhsts[58];
            void  *sqindv[58];
            int   sqinds[58];
   unsigned int   sqharm[58];
   unsigned int   *sqharc[58];
   unsigned short  sqadto[58];
   unsigned short  sqtdso[58];
} sqlstm = {12,58};

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

 static const char *sq0015 = 
"select TEST_CODE  from RL_REQUEST_DETAIL where ((PATIENT_ID=:b0 and SPECIMEN\
_NO=:b1) and OPERATING_FACILITY_ID=:b2) order by TEST_CODE            ";

 static const char *sq0022 = 
"select TEST_CODE  from RL_TEST_QUALITY_MAST where ((OPERATING_FACILITY_ID=:b\
0 and SECTION_CODE=:b1) and QLTY_CODE=:b2)           ";

 static const char *sq0013 = 
"select TEST_CODE ,SEQ_NO ,TEST_INDICATOR  from RL_WORKLIST_FMT_DTL where (OP\
ERATING_FACILITY_ID=:b0 and WORKLIST_NAME=:b1) order by SEQ_NO            ";

 static const char *sq0024 = 
"select TEST_CODE  from RL_TEST_CODE where TEST_CODE=:b0           ";

 static const char *sq0020 = 
"select WORKLIST_CUP_NO ,SPECIMEN_NO ,PATIENT_ID ,WORKLIST_CUP_INDICATOR ,TES\
T_1_YN ,TEST_2_YN ,TEST_3_YN ,TEST_4_YN ,TEST_5_YN ,TEST_6_YN ,TEST_7_YN ,TEST\
_8_YN ,TEST_9_YN ,TEST_10_YN ,TEST_11_YN ,TEST_12_YN ,TEST_13_YN ,TEST_14_YN ,\
TEST_15_YN ,TEST_16_YN ,TEST_17_YN ,TEST_18_YN ,TEST_19_YN ,TEST_20_YN ,TEST_2\
1_YN ,TEST_22_YN ,TEST_23_YN ,TEST_24_YN ,TEST_25_YN  from RL_WORKLIST_DTL whe\
re (((OPERATING_FACILITY_ID=:b0 and WORKLIST_NAME=:b1) and WORKLIST_NO=TO_NUMB\
ER(:b2)) and TO_CHAR(WORKLIST_DATE,'DD/MM/YYYY')=TO_CHAR(TO_DATE(:b3,'DD/MM/YY\
YY'),'DD/MM/YYYY')) order by WORKLIST_CUP_NO            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,302,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,359,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,379,0,0,0,0,0,1,0,
66,0,0,4,64,0,4,388,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
89,0,0,5,0,0,32,402,0,0,0,0,0,1,0,
104,0,0,6,305,0,4,420,0,0,16,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,
183,0,0,7,91,0,2,487,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
206,0,0,8,0,0,32,495,0,0,0,0,0,1,0,
221,0,0,9,190,0,4,505,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
252,0,0,10,0,0,32,529,0,0,0,0,0,1,0,
267,0,0,11,1449,0,4,577,0,0,58,3,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,
0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,
0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,
3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,
2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,
0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
514,0,0,12,0,0,32,715,0,0,0,0,0,1,0,
529,0,0,14,0,0,32,747,0,0,0,0,0,1,0,
544,0,0,16,0,0,32,769,0,0,0,0,0,1,0,
559,0,0,15,146,0,9,777,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
586,0,0,17,0,0,32,781,0,0,0,0,0,1,0,
601,0,0,15,0,0,13,792,0,0,1,0,0,1,0,2,9,0,0,
620,0,0,18,0,0,32,810,0,0,0,0,0,1,0,
635,0,0,15,0,0,15,818,0,0,0,0,0,1,0,
650,0,0,19,0,0,32,822,0,0,0,0,0,1,0,
665,0,0,21,0,0,32,884,0,0,0,0,0,1,0,
680,0,0,23,0,0,32,906,0,0,0,0,0,1,0,
695,0,0,25,0,0,32,933,0,0,0,0,0,1,0,
710,0,0,22,129,0,9,1102,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,1,0,0,
737,0,0,26,0,0,32,1106,0,0,0,0,0,1,0,
752,0,0,13,150,0,9,1116,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
775,0,0,27,114,0,4,1117,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,
802,0,0,28,0,0,32,1124,0,0,0,0,0,1,0,
817,0,0,24,66,0,9,1133,0,0,1,1,0,1,0,1,1,0,0,
836,0,0,29,0,0,32,1138,0,0,0,0,0,1,0,
851,0,0,20,600,0,9,1148,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
882,0,0,30,0,0,32,1153,0,0,0,0,0,1,0,
897,0,0,22,0,0,15,1162,0,0,0,0,0,1,0,
912,0,0,31,0,0,32,1166,0,0,0,0,0,1,0,
927,0,0,24,0,0,15,1175,0,0,0,0,0,1,0,
942,0,0,32,0,0,32,1180,0,0,0,0,0,1,0,
957,0,0,13,0,0,13,1208,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,
984,0,0,33,0,0,32,1236,0,0,0,0,0,1,0,
999,0,0,22,0,0,13,1249,0,0,1,0,0,1,0,2,9,0,0,
1018,0,0,34,0,0,32,1272,0,0,0,0,0,1,0,
1033,0,0,24,0,0,13,1289,0,0,1,0,0,1,0,2,9,0,0,
1052,0,0,35,0,0,32,1312,0,0,0,0,0,1,0,
1067,0,0,20,0,0,13,1332,0,0,29,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,
2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,
0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,
0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,
1198,0,0,36,0,0,32,1418,0,0,0,0,0,1,0,
1213,0,0,37,32,0,4,1470,0,0,1,0,0,1,0,2,9,0,0,
1232,0,0,38,203,0,4,1475,0,0,6,5,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,
1271,0,0,39,0,0,32,1556,0,0,0,0,0,1,0,
1286,0,0,40,324,0,4,1734,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1345,0,0,41,0,0,32,1815,0,0,0,0,0,1,0,
1360,0,0,42,115,0,4,1899,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1387,0,0,43,0,0,32,1914,0,0,0,0,0,1,0,
1402,0,0,44,115,0,4,1926,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1429,0,0,45,0,0,32,1939,0,0,0,0,0,1,0,
1444,0,0,46,115,0,4,1951,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1471,0,0,47,0,0,32,1964,0,0,0,0,0,1,0,
1486,0,0,48,172,0,4,2008,0,0,6,4,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1525,0,0,49,0,0,32,2032,0,0,0,0,0,1,0,
1540,0,0,50,154,0,4,2263,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1575,0,0,51,0,0,32,2289,0,0,0,0,0,1,0,
1590,0,0,52,154,0,4,2298,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1625,0,0,53,0,0,32,2325,0,0,0,0,0,1,0,
1640,0,0,54,154,0,4,2334,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1675,0,0,55,0,0,32,2362,0,0,0,0,0,1,0,
1690,0,0,56,0,0,29,2445,0,0,0,0,0,1,0,
1705,0,0,57,57,0,4,3075,0,0,1,0,0,1,0,2,9,0,0,
1724,0,0,58,100,0,4,3078,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,4,0,0,
1751,0,0,59,99,0,4,3106,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/***************************************************************************** 

*  File	         : rlrwlres.pc
   Author        : Sheelvant   
   Date Created  : 03/10/1996
   Last Modified : 19/09/2000    ( Sheelvant )

*  Ver 1.10.01
   
*  Purpose : To Create Worklist Date for the given Specimen Range     
            
*  Input Parameters : 
                      Command line inputs
		              1. Usr_id/Password
                      2. Session id
		              3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4. Preferred range of Specimen Numbers            
                      5. Criteria Flag                                  
                      6. Section Code                                   
                      7. Worklist_name                                  
                      8. Worklist Number                                
                      9. Worklist Date                                  
                      9. User Id                                        
  
*  Table Accessed : RL_WORKLIST_FMT_HDR,RL_WORKLIST_FMT_DTL,RL_TEST_RESULT,
		    RL_WORKLIST_DTL

*****************************************************************************/  

#include <stdio.h>
#include <string.h>
#include <math.h>

#define ESC 0x1B
#define MAX_LINES 45
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ONLINE_PRINTING 1
/*
#define DEBUG 
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR   nd_operating_facility_id   [3],
	          uid_pwd		             [91],
			  nd_file_name               [150], 
 
 		/o from RL_WORKLIST_FMT_HDR o/
		d_worklist_name         [11],
        d_criteria_flag   	    [2],
		d_cup_indicators_1      [51],
		d_cup_indicators_2      [51],
		d_cup_indicators_3      [51],
		d_cup_indicators_4      [51],
		d_cup_indicators_5      [51],
		d_added_by_id           [51],
		rowid_wrk               [31],
		
        /o from RL_WORKLIST_FMT_DTL o/
		d_worklist_test_code	[11],
		d_test_indicator	    [2],

        /o from RL_REQUEST_DETAIL   o/
		d_req_dtl_test		    [11],

        /o from RL_TEST_RESULT o/     
		d_specimen_no           [21],
		d_prt_cup_no			[30],
		d_patient_id            [31],
		d_req_test_code		[11],
		d_num_result		[16],
		d_comm_result		[16],
		d_test_result		[16],

        /o from RL_QC_MATERIAL_TEST o/
		d_qc_test_code		[11],

        /o from PATIENT MASTERS     o/
		d_date_of_birth		[11],
		d_short_name   		[61],
                d_nation                [5],
				d_sex                   [2],
				d_pat_mark              [2],
				d_worklist_marker       [11],

        /o from RL_REQUEST_HEADER   o/
		d_source_code 		    [11],
		d_episode_type          [2],
		d_spec_regd_date_time   [17],
		d_consultant_code		[16],
		d_urgent_indicator      [2],
		d_request_comment_code1 [5],
		d_request_comment_code2 [5],
		d_request_comment_code3 [5],

		/o from RL_REQUEST_COMMENT_CODE   o/
		d_request_comment_desc1 [42],  
		d_request_comment_desc2 [42],  
		d_request_comment_desc3 [42],  

        /o from RL_WORKLIST_DTL for printing only     o/
		d_prt_specimen_no	[21],
		d_prt_patient_id	[31],
		d_print_cup_indicator   [2],

        /o from RL_TEST_QUALITY_MAST o/
		d_qlty_test             [11],

        /o Dummy Variable o/     
	    nd_chk_test_code	    [11],
		nd_ins_specimen_no      [21], 
		nd_ins_patient_id       [31], 


		/o  For Patient Age SYSDATE, MTHS o/
			today				[30],
			t_days				[30],
			mths				[30],
			mths1				[30],
			t_age				[30],

		
		/o input parameters to main() o/
        nd_session_id      [16],
		nd_pgm_date	       [20],
		nd_file_no	       [15],

		/o******* parameters from SY_PROG_PARAM table **********o/
		nd_section_code    	[2],
		nd_worklist_name   	[11],
		nd_worklist_date   	[11],
		nd_criteria_flag   	[2],
		nd_fr_specimen_no  	[21],
		nd_to_specimen_no  	[21],
		nd_print_yn             [2],
		nd_user_id              [31],
		rp_worklist_name        [11],     
		rp_worklist_date        [11],
		rp_reprint              [8],

               /o variable for cursor o/
		nd_cur_specimen_no      [21],
		nd_cur_patient_id       [31],

	       /o for header routine o/
	       //d_acc_entity_name         [41],
		   d_acc_entity_name         [300],
	       d_user                    [31],
	       d_sysdate                 [20],

               /o Fields from table RL_SECTION__CODE o/
	       d_printer_name            [16],

	       /o Fields used in get_test_result o/
               t_worklist_test           [11],
	       t_numeric_result          [16],
	       t_result_comment          [5],

/o  New Fields from RL_WORKLIST_FMT_HDR  o/
		nd_cup_number		    [32],
		nd_cup_indr				[32],
		nd_spec_no				[32],
		nd_wl_marker			[32],
		nd_pat_id			    [32],
		nd_pat_name	     		[61],
		nd_age					[32],
		nd_dob					[32],
		nd_sex					[32],
		nd_source				[32],
		nd_consultant			[32],
		nd_urgency				[32],
		nd_comm_1				[32],
		nd_comm_2				[32],
		nd_comm_3				[32],
		nd_spec_date			[32],
		nd_heading				[20]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[11]; } d_worklist_name;

struct { unsigned short len; unsigned char arr[2]; } d_criteria_flag;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_1;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_2;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_3;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_4;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_5;

struct { unsigned short len; unsigned char arr[51]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[31]; } rowid_wrk;

struct { unsigned short len; unsigned char arr[11]; } d_worklist_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_test_indicator;

struct { unsigned short len; unsigned char arr[11]; } d_req_dtl_test;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[30]; } d_prt_cup_no;

struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[11]; } d_req_test_code;

struct { unsigned short len; unsigned char arr[16]; } d_num_result;

struct { unsigned short len; unsigned char arr[16]; } d_comm_result;

struct { unsigned short len; unsigned char arr[16]; } d_test_result;

struct { unsigned short len; unsigned char arr[11]; } d_qc_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[61]; } d_short_name;

struct { unsigned short len; unsigned char arr[5]; } d_nation;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[2]; } d_pat_mark;

struct { unsigned short len; unsigned char arr[11]; } d_worklist_marker;

struct { unsigned short len; unsigned char arr[11]; } d_source_code;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[17]; } d_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[16]; } d_consultant_code;

struct { unsigned short len; unsigned char arr[2]; } d_urgent_indicator;

struct { unsigned short len; unsigned char arr[5]; } d_request_comment_code1;

struct { unsigned short len; unsigned char arr[5]; } d_request_comment_code2;

struct { unsigned short len; unsigned char arr[5]; } d_request_comment_code3;

struct { unsigned short len; unsigned char arr[42]; } d_request_comment_desc1;

struct { unsigned short len; unsigned char arr[42]; } d_request_comment_desc2;

struct { unsigned short len; unsigned char arr[42]; } d_request_comment_desc3;

struct { unsigned short len; unsigned char arr[21]; } d_prt_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } d_prt_patient_id;

struct { unsigned short len; unsigned char arr[2]; } d_print_cup_indicator;

struct { unsigned short len; unsigned char arr[11]; } d_qlty_test;

struct { unsigned short len; unsigned char arr[11]; } nd_chk_test_code;

struct { unsigned short len; unsigned char arr[21]; } nd_ins_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } nd_ins_patient_id;

struct { unsigned short len; unsigned char arr[30]; } today;

struct { unsigned short len; unsigned char arr[30]; } t_days;

struct { unsigned short len; unsigned char arr[30]; } mths;

struct { unsigned short len; unsigned char arr[30]; } mths1;

struct { unsigned short len; unsigned char arr[30]; } t_age;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[2]; } nd_section_code;

struct { unsigned short len; unsigned char arr[11]; } nd_worklist_name;

struct { unsigned short len; unsigned char arr[11]; } nd_worklist_date;

struct { unsigned short len; unsigned char arr[2]; } nd_criteria_flag;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_specimen_no;

struct { unsigned short len; unsigned char arr[2]; } nd_print_yn;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[11]; } rp_worklist_name;

struct { unsigned short len; unsigned char arr[11]; } rp_worklist_date;

struct { unsigned short len; unsigned char arr[8]; } rp_reprint;

struct { unsigned short len; unsigned char arr[21]; } nd_cur_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } nd_cur_patient_id;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[16]; } d_printer_name;

struct { unsigned short len; unsigned char arr[11]; } t_worklist_test;

struct { unsigned short len; unsigned char arr[16]; } t_numeric_result;

struct { unsigned short len; unsigned char arr[5]; } t_result_comment;

struct { unsigned short len; unsigned char arr[32]; } nd_cup_number;

struct { unsigned short len; unsigned char arr[32]; } nd_cup_indr;

struct { unsigned short len; unsigned char arr[32]; } nd_spec_no;

struct { unsigned short len; unsigned char arr[32]; } nd_wl_marker;

struct { unsigned short len; unsigned char arr[32]; } nd_pat_id;

struct { unsigned short len; unsigned char arr[61]; } nd_pat_name;

struct { unsigned short len; unsigned char arr[32]; } nd_age;

struct { unsigned short len; unsigned char arr[32]; } nd_dob;

struct { unsigned short len; unsigned char arr[32]; } nd_sex;

struct { unsigned short len; unsigned char arr[32]; } nd_source;

struct { unsigned short len; unsigned char arr[32]; } nd_consultant;

struct { unsigned short len; unsigned char arr[32]; } nd_urgency;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_1;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_2;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_3;

struct { unsigned short len; unsigned char arr[32]; } nd_spec_date;

struct { unsigned short len; unsigned char arr[20]; } nd_heading;


float mt				;

/* Fields from table SY_PROG_PARAM*/                          
int  		nd_worklist_no;
int             rp_worklist_no;
/* Fields from table RL_WORKLIST_FMT_HDR */                          
int  		d_worklist_no, d_no_of_cups,d_line_spacing;

/* Fields from table RL_WORKLIST_FMT_DTL */                          
int  		d_seq_no; 
int             d_no_of_tests;
int			tests;

/* Fields from table RL_WORKLIST_DTL */                          
char            d_prt_test_1_yn,d_prt_test_2_yn,d_prt_test_3_yn,
                d_prt_test_4_yn,d_prt_test_5_yn,d_prt_test_6_yn,
                d_prt_test_7_yn,d_prt_test_8_yn,d_prt_test_9_yn,
                d_prt_test_10_yn,d_prt_test_11_yn,d_prt_test_12_yn,
                d_prt_test_13_yn,d_prt_test_14_yn,d_prt_test_15_yn,
                d_prt_test_16_yn,d_prt_test_17_yn,d_prt_test_18_yn,
                d_prt_test_19_yn,d_prt_test_20_yn,d_prt_test_21_yn,
                d_prt_test_22_yn,d_prt_test_23_yn,d_prt_test_24_yn,
                d_prt_test_25_yn;
  
  
/* Dummy Fields  */                                                  
int  		ic;                                       
int  		line_no,page_no,no_of_tests,tests_on_page;
char            test_exists_in_specimen;
char            sql_stmt[5000];
char 		cup_ind;                                  
char		nd_qc_code;
char            dummy_test_array[25];
char            cup_indicator[250];
char            file_name[50],
		file_name2[50];

int stimulate = 0;
int num[16];
int cou[16];
char word[16][32];
char str_word[16][32];
char temp_word[32];
char detail[16][44];

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
int       mandatory_tests_exist;
int       worklist_mandatory_tests_exist;
char      worklist_test[25][11];
char      worklist_ind[25][2];
char      mandatory_ind[25];
char      chk_mand_test[25];
char      string_var[200];
char      uline[6] = "_____";
int       print_line;
int       test_ctr;
int       maxx = 0;

int i =  0;
int j = 0 ;
int k = 0;
int ctr = 0;
int str_len = 0 ;
int total = 0 ;
int tot_tests = 0;
char g_facility_id[50];

FILE *f1,*f2;

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
	dclr_request_detail_cur(),
        dclr_worklist_dtl_cur(),
        dclr_worklist_prt_dtl_cur(),
        dclr_qc_matl_test_cur(),
  	get_worklist_hdr(),
	dclr_qlty_tests_cur(),
  	do_report();
	//get_dept_printer();

	void print_hyphen(FILE *);
	void patient_age();
	void print_dtl(FILE *);
	void sorting();
	void reverse_sort();
	void prepare_heading(FILE *);

   if(argc < 4) {
     disp_message(ERR_MESG,"Usage rlrwlres uid/passwd session_id pgm_date\n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 


   strcpy(g_facility_id,' ');

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

  

   #ifdef DEBUG
      printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
   #endif  
   
   set_meduser_role();

/*   printf("rlrwlres : Program Started.\n\n"); 
*/

   get_params();
   gen_file_name();

   strcpy(file_name,WORKING_DIR);
   strcat(file_name,"rlrwlre2.lis");

/*   increment_file_no();
   sprintf(file_name, "a%s",nd_file_name);
   sprintf(file_name2,"b%s",nd_file_name);
*/

  if((f2 = fopen(file_name, "w")) == NULL) 
   {
     sprintf(string_var,".... Error opening output file ....<%s>\n",file_name);
	 disp_message(ERR_MESG,string_var) ;
     proc_exit();
   } 
   else
   {
	     fprintf(f2,"%c&|26A",ESC);
		 fprintf(f2,"%c&a90P",ESC);
	     fprintf(f2,"%c&|1O",ESC);
	     fprintf(f2,"%c&k4S",ESC);
   }

   if(strcmp(rp_reprint.arr,"REPRINT") == 0)
   {
      strcpy(nd_worklist_name.arr,rp_worklist_name.arr);
      nd_worklist_name.len = strlen(rp_worklist_name.arr);
      nd_worklist_no = rp_worklist_no;
      strcpy(nd_worklist_date.arr,rp_worklist_date.arr);
      nd_worklist_date.len = strlen(rp_worklist_date.arr);
   }

   dclr_worklist_dtl_cur();
   dclr_qc_matl_test_cur();
   dclr_worklist_prt_dtl_cur();
   
   get_worklist_hdr();

   get_header_dtls();
   dclr_qlty_tests_cur();
   do_report();
   //get_dept_printer();
   
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



   /*printf("rlrwlres : Program Ended.\n\n"); */

   /***** TO RESET THE PRINTER *********/
   fprintf(f1,"%cE",ESC);
   fprintf(f2,"%cE",ESC);

   /**** FOR REVERSING THE LANDSCAPE PRINTING 
   fprintf(f1,"%c&|3O",ESC);
   fprintf(f2,"%c&|3O",ESC);
   **********/

   fclose(f1);
   fclose(f2);
   
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


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}   

/* get the printer name */
void get_dept_printer()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT  '1' INTO :d_printer_name
            FROM    RL_SECTION_CODE
	    WHERE   SECTION_CODE = :nd_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select '1' into :b0  from RL_SECTION_CODE where SECTION_CO\
DE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_printer_name;
   sqlstm.sqhstl[0] = (unsigned int  )18;
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
   sqlstm.sqphsv = sqlstm.sqhstv;
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



  d_printer_name.arr[d_printer_name.len] = '\0';

#ifdef DEBUG
   printf("d_printer_name = %s\n", d_printer_name.arr);
#endif

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
   sqlstm.offset = (unsigned int  )89;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_dept_printer() occured....\n");
   proc_exit();
}

/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
		rp_worklist_name.arr[0] = '\0';
		rp_worklist_name.len = 0;
		rp_worklist_date.arr[0] = '\0';
		rp_worklist_date.len = 0;
		rp_reprint.arr[0] = '\0';
		rp_reprint.len = 0;

   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
           PARAM1,
		   PARAM2,
		   PARAM3,
		   PARAM4,
		   PARAM5,
		   PARAM6,
		   PARAM7,
		   PARAM8,
		   UPPER(PARAM9),
		   PARAM10,
		   PARAM11,
		   PARAM12,
		   PARAM13
           INTO 
		   :nd_operating_facility_id,
		   :nd_section_code ,  
		   :nd_worklist_name,  
		   :nd_worklist_no  ,
		   :nd_worklist_date,
		   :nd_criteria_flag,
		   :nd_fr_specimen_no,
		   :nd_to_specimen_no,
		   :nd_print_yn,
		   :nd_user_id,
		   :rp_worklist_name,     
		   :rp_worklist_no,
		   :rp_worklist_date,
		   :rp_reprint
            FROM SY_PROG_PARAM
	        WHERE   PGM_ID = 'RLRWLRES'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,UPPER(PARAM9) ,PARAM10 ,PARAM11 ,PARAM12 ,\
PARAM13 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13  from\
 SY_PROG_PARAM where ((PGM_ID='RLRWLRES' and SESSION_ID=TO_NUMBER(:b14)) and P\
GM_DATE=:b15)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )104;
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
   sqlstm.sqhstv[5] = (         void  *)&nd_criteria_flag;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fr_specimen_no;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_specimen_no;
   sqlstm.sqhstl[7] = (unsigned int  )23;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_print_yn;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_user_id;
   sqlstm.sqhstl[9] = (unsigned int  )33;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&rp_worklist_name;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&rp_worklist_no;
   sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&rp_worklist_date;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&rp_reprint;
   sqlstm.sqhstl[13] = (unsigned int  )10;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[14] = (unsigned int  )18;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[15] = (unsigned int  )22;
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



  nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
  nd_section_code.arr[nd_section_code.len] 			= '\0';
  nd_worklist_name.arr[nd_worklist_name.len] 			= '\0';
  nd_worklist_date.arr[nd_worklist_date.len] 			= '\0';
  nd_criteria_flag.arr[nd_criteria_flag.len] 			= '\0';
  nd_fr_specimen_no.arr[nd_fr_specimen_no.len] 			= '\0';
  nd_to_specimen_no.arr[nd_to_specimen_no.len] 			= '\0';
  nd_print_yn.arr[nd_print_yn.len] 				= '\0';
  nd_user_id.arr[nd_user_id.len] 				= '\0';
  rp_worklist_name.arr[rp_worklist_name.len]			= '\0';     
  rp_worklist_date.arr[rp_worklist_date.len]			= '\0';
  rp_reprint.arr[rp_reprint.len]				= '\0';


#ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" nd_section_code = %s\n",nd_section_code.arr);
   printf(" nd_worklist_name = %s\n",nd_worklist_name.arr);
   printf(" nd_worklist_no = %d\n",nd_worklist_no);
   printf(" nd_worklist_date = %s\n",nd_worklist_date.arr);
   printf(" nd_criteria_flag = %s\n",nd_criteria_flag.arr);
   printf(" nd_fr_specimen_no = %s\n",nd_fr_specimen_no.arr);
   printf(" nd_to_specimen_no = %s\n",nd_to_specimen_no.arr);
   printf(" nd_print_yn = %s\n",nd_print_yn.arr);
   printf(" nd_user_id = %s\n",nd_user_id.arr);
   printf(" rp_worklist_name = %s\n",rp_worklist_name.arr);     
   printf(" rp_worklist_no = %d\n",rp_worklist_no);
   printf(" rp_worklist_date = %s\n",rp_worklist_date.arr);
   printf(" rp_reprint = %s\n",rp_reprint.arr);
#endif
  
  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	        WHERE PGM_ID = 'RLRWLRES'
	        AND SESSION_ID = :nd_session_id
		    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='RLRWLRES' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )183;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )206;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(LPAD(ACC_ENTITY_NAME,TRUNC((15+(0.5* LENGTH(\
ACC_ENTITY_NAME))))),1,30) ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') into :\
b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )221;
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
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )252;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}
 

/* get the WORKLIST Header detail from RL_WORKLIST_FMT_HDR */
/* delete the record after reading it.                     */
void get_worklist_hdr()
{

   nd_cup_number.arr[0] = '\0';
   nd_cup_number.len = 0 ;
   nd_cup_indr.arr[0] = '\0';
   nd_cup_indr.len = 0 ;
   nd_spec_no.arr[0] = '\0';
   nd_spec_no.len = 0 ;
   nd_wl_marker.arr[0] = '\0';
   nd_wl_marker.len = 0 ;
   nd_pat_id.arr[0] = '\0';
   nd_pat_id.len = 0 ;
   nd_pat_name.arr[0] = '\0';
   nd_pat_name.len = 0 ;
   nd_source.arr[0] = '\0';
   nd_source.len = 0 ;
   nd_consultant.arr[0] = '\0';
   nd_consultant.len = 0 ;
   nd_urgency.arr[0] = '\0';
   nd_urgency.len = 0 ;	
   nd_comm_1.arr[0] = '\0';
   nd_comm_1.len = 0 ;	
   nd_comm_2.arr[0] = '\0';
   nd_comm_2.len = 0 ;	
   nd_comm_3.arr[0] = '\0';
   nd_comm_3.len = 0 ;	
   nd_spec_date.arr[0] = '\0';
   nd_spec_date.len = 0 ;	

    for (i=0;i<16;i++)
    {
	   num[i] = 0;
	   cou[i] = 0;
	  
	   strcpy(word[i],"0");
    }

   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT NO_OF_CUPS,
		   LINE_SPACING,
		   CUP_INDICATOR_1,
		   CUP_INDICATOR_2,
		   CUP_INDICATOR_3,
		   CUP_INDICATOR_4,
		   CUP_INDICATOR_5, 
		 NVL(row_cup_number,0), NVL(col_cup_number,0),
		 NVL(l_cup_number,'0'), NVL(row_cup_indr,0), NVL(col_cup_indr,0),
		 NVL(l_cup_indr,'0'),NVL(row_wl_marker,0), NVL(col_wl_marker,0),
		 NVL(l_wl_marker,'0'), NVL(row_spec_no,0), NVL(col_spec_no,0),
		 NVL(l_spec_no,'0'),  NVL(row_patient_id,0), NVL(col_patient_id,0),
		 NVL(l_patient_id,'0'), NVL(row_pat_name,0), NVL(col_pat_name,0),
		 NVL(l_pat_name,'0'),NVL(row_age,0), NVL(col_age,0), NVL(l_age,'0'),
		 NVL(row_dob,0), NVL(col_dob,0), NVL(l_dob,'0'), NVL(row_sex,0), NVL(col_sex,0),
		 NVL(l_sex,'0'), NVL(row_source,0), NVL(col_source,0), NVL(l_source,'0'),
		 NVL(row_consultant,0), NVL(col_consultant,0), NVL(l_consultant,'0'),
		 NVL(row_urgency,0), NVL(col_urgency,0), NVL(l_urgency,'0'),
		 NVL(row_comm_1,0), NVL(col_comm_1,0),NVL(l_comm_1,'0'), NVL(row_comm_2,0),
		 NVL(col_comm_2,0), NVL(l_comm_2,0), NVL(row_comm_3,0), NVL(col_comm_3,0),
 	     NVL(l_comm_3,'0'), NVL(row_spec_date,0), NVL(col_spec_date,0),
  	     NVL(l_spec_date,'0')
            INTO 
		:d_no_of_cups,
		:d_line_spacing,
		:d_cup_indicators_1,
		:d_cup_indicators_2,
		:d_cup_indicators_3,
		:d_cup_indicators_4,
		:d_cup_indicators_5,
 :num[0], :cou[0], :nd_cup_number,
 :num[1], :cou[1], :nd_cup_indr,
 :num[2], :cou[2], :nd_wl_marker,
 :num[3], :cou[3], :nd_spec_no,
 :num[4], :cou[4], :nd_pat_id,
 :num[5], :cou[5], :nd_pat_name,
 :num[6], :cou[6], :nd_age,
 :num[7], :cou[7], :nd_dob,
 :num[8], :cou[8], :nd_sex,
 :num[9], :cou[9], :nd_source,
 :num[10], :cou[10], :nd_consultant,
 :num[11], :cou[11], :nd_urgency,
 :num[12], :cou[12], :nd_comm_1,
 :num[13], :cou[13], :nd_comm_2,
 :num[14], :cou[14], :nd_comm_3,
 :num[15], :cou[15], :nd_spec_date
            FROM RL_WORKLIST_FMT_HDR
	    WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND SECTION_CODE  = :nd_section_code 
	      AND WORKLIST_NAME = :nd_worklist_name; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select NO_OF_CUPS ,LINE_SPACING ,CUP_INDICATOR_1 ,CUP_INDICATOR_2 ,CUP\
_INDICATOR_3 ,CUP_INDICATOR_4 ,CUP_INDICATOR_5 ,NVL(row_cup_number,0) ,NVL(c\
ol_cup_number,0) ,NVL(l_cup_number,'0') ,NVL(row_cup_indr,0) ,NVL(col_cup_in\
dr,0) ,NVL(l_cup_indr,'0') ,NVL(row_wl_marker,0) ,NVL(col_wl_marker,0) ,NVL(\
l_wl_marker,'0') ,NVL(row_spec_no,0) ,NVL(col_spec_no,0) ,NVL(l_spec_no,'0')\
 ,NVL(row_patient_id,0) ,NVL(col_patient_id,0) ,NVL(l_patient_id,'0') ,NVL(r\
ow_pat_name,0) ,NVL(col_pat_name,0) ,NVL(l_pat_name,'0') ,NVL(row_age,0) ,NV\
L(col_age,0) ,NVL(l_age,'0') ,NVL(row_dob,0) ,NVL(col_dob,0) ,NVL(l_dob,'0')\
 ,NVL(row_sex,0) ,NVL(col_sex,0) ,NVL(l_sex,'0') ,NVL(row_source,0) ,NVL(col\
_source,0) ,NVL(l_source,'0') ,NVL(row_consultant,0) ,NVL(col_consultant,0) \
,NVL(l_consultant,'0') ,NVL(row_urgency,0) ,NVL(col_urgency,0) ,NVL(l_urgenc\
y,'0') ,NVL(row_comm_1,0) ,NVL(col_comm_1,0) ,NVL(l_comm_1,'0') ,NVL(row_com\
m_2,0) ,NVL(col_comm_2,0) ,NVL(l_comm_2,0) ,NVL(row_comm_3,0) ,NVL(col_comm_\
3,0) ,NVL(l_comm_3,'0') ,NVL(row_spec_date");
   sqlstm.stmt = ",0) ,NVL(col_spec_date,0) ,NVL(l_spec_date,'0') into :b0,:\
b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b1\
8,:b19,:b20,:b21,:b22,:b23,:b24,:b25,:b26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,:\
b34,:b35,:b36,:b37,:b38,:b39,:b40,:b41,:b42,:b43,:b44,:b45,:b46,:b47,:b48,:b49\
,:b50,:b51,:b52,:b53,:b54  from RL_WORKLIST_FMT_HDR where ((OPERATING_FACILITY\
_ID=:b55 and SECTION_CODE=:b56) and WORKLIST_NAME=:b57)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )267;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_no_of_cups;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_line_spacing;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cup_indicators_1;
   sqlstm.sqhstl[2] = (unsigned int  )53;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_cup_indicators_2;
   sqlstm.sqhstl[3] = (unsigned int  )53;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_cup_indicators_3;
   sqlstm.sqhstl[4] = (unsigned int  )53;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_cup_indicators_4;
   sqlstm.sqhstl[5] = (unsigned int  )53;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_cup_indicators_5;
   sqlstm.sqhstl[6] = (unsigned int  )53;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&num[0];
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&cou[0];
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_cup_number;
   sqlstm.sqhstl[9] = (unsigned int  )34;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&num[1];
   sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&cou[1];
   sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_cup_indr;
   sqlstm.sqhstl[12] = (unsigned int  )34;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&num[2];
   sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&cou[2];
   sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_wl_marker;
   sqlstm.sqhstl[15] = (unsigned int  )34;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&num[3];
   sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&cou[3];
   sqlstm.sqhstl[17] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_spec_no;
   sqlstm.sqhstl[18] = (unsigned int  )34;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&num[4];
   sqlstm.sqhstl[19] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&cou[4];
   sqlstm.sqhstl[20] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_pat_id;
   sqlstm.sqhstl[21] = (unsigned int  )34;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&num[5];
   sqlstm.sqhstl[22] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&cou[5];
   sqlstm.sqhstl[23] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_pat_name;
   sqlstm.sqhstl[24] = (unsigned int  )63;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&num[6];
   sqlstm.sqhstl[25] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&cou[6];
   sqlstm.sqhstl[26] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&nd_age;
   sqlstm.sqhstl[27] = (unsigned int  )34;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&num[7];
   sqlstm.sqhstl[28] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&cou[7];
   sqlstm.sqhstl[29] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&nd_dob;
   sqlstm.sqhstl[30] = (unsigned int  )34;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&num[8];
   sqlstm.sqhstl[31] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&cou[8];
   sqlstm.sqhstl[32] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&nd_sex;
   sqlstm.sqhstl[33] = (unsigned int  )34;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&num[9];
   sqlstm.sqhstl[34] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&cou[9];
   sqlstm.sqhstl[35] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&nd_source;
   sqlstm.sqhstl[36] = (unsigned int  )34;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&num[10];
   sqlstm.sqhstl[37] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&cou[10];
   sqlstm.sqhstl[38] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&nd_consultant;
   sqlstm.sqhstl[39] = (unsigned int  )34;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&num[11];
   sqlstm.sqhstl[40] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&cou[11];
   sqlstm.sqhstl[41] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqhstv[42] = (         void  *)&nd_urgency;
   sqlstm.sqhstl[42] = (unsigned int  )34;
   sqlstm.sqhsts[42] = (         int  )0;
   sqlstm.sqindv[42] = (         void  *)0;
   sqlstm.sqinds[42] = (         int  )0;
   sqlstm.sqharm[42] = (unsigned int  )0;
   sqlstm.sqadto[42] = (unsigned short )0;
   sqlstm.sqtdso[42] = (unsigned short )0;
   sqlstm.sqhstv[43] = (         void  *)&num[12];
   sqlstm.sqhstl[43] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[43] = (         int  )0;
   sqlstm.sqindv[43] = (         void  *)0;
   sqlstm.sqinds[43] = (         int  )0;
   sqlstm.sqharm[43] = (unsigned int  )0;
   sqlstm.sqadto[43] = (unsigned short )0;
   sqlstm.sqtdso[43] = (unsigned short )0;
   sqlstm.sqhstv[44] = (         void  *)&cou[12];
   sqlstm.sqhstl[44] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[44] = (         int  )0;
   sqlstm.sqindv[44] = (         void  *)0;
   sqlstm.sqinds[44] = (         int  )0;
   sqlstm.sqharm[44] = (unsigned int  )0;
   sqlstm.sqadto[44] = (unsigned short )0;
   sqlstm.sqtdso[44] = (unsigned short )0;
   sqlstm.sqhstv[45] = (         void  *)&nd_comm_1;
   sqlstm.sqhstl[45] = (unsigned int  )34;
   sqlstm.sqhsts[45] = (         int  )0;
   sqlstm.sqindv[45] = (         void  *)0;
   sqlstm.sqinds[45] = (         int  )0;
   sqlstm.sqharm[45] = (unsigned int  )0;
   sqlstm.sqadto[45] = (unsigned short )0;
   sqlstm.sqtdso[45] = (unsigned short )0;
   sqlstm.sqhstv[46] = (         void  *)&num[13];
   sqlstm.sqhstl[46] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[46] = (         int  )0;
   sqlstm.sqindv[46] = (         void  *)0;
   sqlstm.sqinds[46] = (         int  )0;
   sqlstm.sqharm[46] = (unsigned int  )0;
   sqlstm.sqadto[46] = (unsigned short )0;
   sqlstm.sqtdso[46] = (unsigned short )0;
   sqlstm.sqhstv[47] = (         void  *)&cou[13];
   sqlstm.sqhstl[47] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[47] = (         int  )0;
   sqlstm.sqindv[47] = (         void  *)0;
   sqlstm.sqinds[47] = (         int  )0;
   sqlstm.sqharm[47] = (unsigned int  )0;
   sqlstm.sqadto[47] = (unsigned short )0;
   sqlstm.sqtdso[47] = (unsigned short )0;
   sqlstm.sqhstv[48] = (         void  *)&nd_comm_2;
   sqlstm.sqhstl[48] = (unsigned int  )34;
   sqlstm.sqhsts[48] = (         int  )0;
   sqlstm.sqindv[48] = (         void  *)0;
   sqlstm.sqinds[48] = (         int  )0;
   sqlstm.sqharm[48] = (unsigned int  )0;
   sqlstm.sqadto[48] = (unsigned short )0;
   sqlstm.sqtdso[48] = (unsigned short )0;
   sqlstm.sqhstv[49] = (         void  *)&num[14];
   sqlstm.sqhstl[49] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[49] = (         int  )0;
   sqlstm.sqindv[49] = (         void  *)0;
   sqlstm.sqinds[49] = (         int  )0;
   sqlstm.sqharm[49] = (unsigned int  )0;
   sqlstm.sqadto[49] = (unsigned short )0;
   sqlstm.sqtdso[49] = (unsigned short )0;
   sqlstm.sqhstv[50] = (         void  *)&cou[14];
   sqlstm.sqhstl[50] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[50] = (         int  )0;
   sqlstm.sqindv[50] = (         void  *)0;
   sqlstm.sqinds[50] = (         int  )0;
   sqlstm.sqharm[50] = (unsigned int  )0;
   sqlstm.sqadto[50] = (unsigned short )0;
   sqlstm.sqtdso[50] = (unsigned short )0;
   sqlstm.sqhstv[51] = (         void  *)&nd_comm_3;
   sqlstm.sqhstl[51] = (unsigned int  )34;
   sqlstm.sqhsts[51] = (         int  )0;
   sqlstm.sqindv[51] = (         void  *)0;
   sqlstm.sqinds[51] = (         int  )0;
   sqlstm.sqharm[51] = (unsigned int  )0;
   sqlstm.sqadto[51] = (unsigned short )0;
   sqlstm.sqtdso[51] = (unsigned short )0;
   sqlstm.sqhstv[52] = (         void  *)&num[15];
   sqlstm.sqhstl[52] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[52] = (         int  )0;
   sqlstm.sqindv[52] = (         void  *)0;
   sqlstm.sqinds[52] = (         int  )0;
   sqlstm.sqharm[52] = (unsigned int  )0;
   sqlstm.sqadto[52] = (unsigned short )0;
   sqlstm.sqtdso[52] = (unsigned short )0;
   sqlstm.sqhstv[53] = (         void  *)&cou[15];
   sqlstm.sqhstl[53] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[53] = (         int  )0;
   sqlstm.sqindv[53] = (         void  *)0;
   sqlstm.sqinds[53] = (         int  )0;
   sqlstm.sqharm[53] = (unsigned int  )0;
   sqlstm.sqadto[53] = (unsigned short )0;
   sqlstm.sqtdso[53] = (unsigned short )0;
   sqlstm.sqhstv[54] = (         void  *)&nd_spec_date;
   sqlstm.sqhstl[54] = (unsigned int  )34;
   sqlstm.sqhsts[54] = (         int  )0;
   sqlstm.sqindv[54] = (         void  *)0;
   sqlstm.sqinds[54] = (         int  )0;
   sqlstm.sqharm[54] = (unsigned int  )0;
   sqlstm.sqadto[54] = (unsigned short )0;
   sqlstm.sqtdso[54] = (unsigned short )0;
   sqlstm.sqhstv[55] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[55] = (unsigned int  )5;
   sqlstm.sqhsts[55] = (         int  )0;
   sqlstm.sqindv[55] = (         void  *)0;
   sqlstm.sqinds[55] = (         int  )0;
   sqlstm.sqharm[55] = (unsigned int  )0;
   sqlstm.sqadto[55] = (unsigned short )0;
   sqlstm.sqtdso[55] = (unsigned short )0;
   sqlstm.sqhstv[56] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[56] = (unsigned int  )4;
   sqlstm.sqhsts[56] = (         int  )0;
   sqlstm.sqindv[56] = (         void  *)0;
   sqlstm.sqinds[56] = (         int  )0;
   sqlstm.sqharm[56] = (unsigned int  )0;
   sqlstm.sqadto[56] = (unsigned short )0;
   sqlstm.sqtdso[56] = (unsigned short )0;
   sqlstm.sqhstv[57] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[57] = (unsigned int  )13;
   sqlstm.sqhsts[57] = (         int  )0;
   sqlstm.sqindv[57] = (         void  *)0;
   sqlstm.sqinds[57] = (         int  )0;
   sqlstm.sqharm[57] = (unsigned int  )0;
   sqlstm.sqadto[57] = (unsigned short )0;
   sqlstm.sqtdso[57] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
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




  d_cup_indicators_1.arr[d_cup_indicators_1.len]		= '\0';
  d_cup_indicators_2.arr[d_cup_indicators_2.len]		= '\0';
  d_cup_indicators_3.arr[d_cup_indicators_3.len]		= '\0';
  d_cup_indicators_4.arr[d_cup_indicators_4.len]		= '\0';
  d_cup_indicators_5.arr[d_cup_indicators_5.len]		= '\0';

  strcpy(cup_indicator,d_cup_indicators_1.arr);
  strcat(cup_indicator,d_cup_indicators_2.arr);
  strcat(cup_indicator,d_cup_indicators_3.arr);
  strcat(cup_indicator,d_cup_indicators_4.arr);
  strcat(cup_indicator,d_cup_indicators_5.arr);

  /*strncpy(cup_indicator,d_cup_indicators_1.arr,d_cup_indicators_1.len);
  strncpy(cup_indicator+d_cup_indicators_2.len,d_cup_indicators_1.arr,d_cup_indicators_2.len);
  strncpy(cup_indicator+d_cup_indicators_2.len,d_cup_indicators_1.arr,d_cup_indicators_3.len);
  strncpy(cup_indicator+d_cup_indicators_2.len,d_cup_indicators_1.arr,d_cup_indicators_4.len);
  strncpy(cup_indicator+d_cup_indicators_2.len,d_cup_indicators_1.arr,d_cup_indicators_5.len); */

  nd_cup_number.arr[nd_cup_number.len] = '\0';
  nd_cup_indr.arr[nd_cup_indr.len]	   = '\0';
  nd_spec_no.arr[nd_spec_no.len]	   = '\0';
  nd_wl_marker.arr[nd_wl_marker.len]   = '\0';
  nd_pat_id.arr[nd_pat_id.len] = '\0';
  nd_pat_name.arr[nd_pat_name.len]     = '\0';
  nd_age.arr[nd_age.len]			   = '\0';
  nd_dob.arr[nd_dob.len]			   = '\0';
  nd_sex.arr[nd_sex.len]			   = '\0';
  nd_source.arr[nd_source.len]		   = '\0';
  nd_consultant.arr[nd_consultant.len] = '\0';
  nd_urgency.arr[nd_urgency.len]	   = '\0';
  nd_comm_1.arr[nd_comm_1.len]	       = '\0';
  nd_comm_2.arr[nd_comm_2.len]	       = '\0';
  nd_comm_3.arr[nd_comm_3.len]	       = '\0';
  nd_spec_date.arr[nd_spec_date.len]   = '\0';


#ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" d_cup_indicators_1 = %s\n",d_cup_indicators_1.arr);
   printf(" d_cup_indicators_2 = %s\n",d_cup_indicators_2.arr);
   printf(" d_cup_indicators_3 = %s\n",d_cup_indicators_3.arr);
   printf(" d_cup_indicators_4 = %s\n",d_cup_indicators_4.arr);
   printf(" d_cup_indicators_5 = %s\n",d_cup_indicators_5.arr);
   printf(" cup_indicator = %s\n",cup_indicator);

#endif

   strcpy(word[0], nd_cup_number.arr);
   strcpy(word[1], nd_cup_indr.arr);
   strcpy(word[2], nd_wl_marker.arr);
   strcpy(word[3], nd_spec_no.arr);
   strcpy(word[4], nd_pat_id.arr);
   strcpy(word[5], nd_pat_name.arr);
   strcpy(word[6], nd_age.arr);
   strcpy(word[7], nd_dob.arr);
   strcpy(word[8], nd_sex.arr);
   strcpy(word[9], nd_source.arr);
   strcpy(word[10], nd_consultant.arr);
   strcpy(word[11], nd_urgency.arr);
   strcpy(word[12], nd_comm_1.arr);
   strcpy(word[13], nd_comm_2.arr);
   strcpy(word[14], nd_comm_3.arr);
   strcpy(word[15], nd_spec_date.arr);

   strcpy(str_word[0], "nd_cup_number");
   strcpy(str_word[1], "nd_cup_indr");
   strcpy(str_word[2], "nd_wl_marker");
   strcpy(str_word[3], "nd_spec_no");
   strcpy(str_word[4], "nd_pat_id");
   strcpy(str_word[5], "nd_pat_name");
   strcpy(str_word[6], "nd_age");
   strcpy(str_word[7], "nd_dob");
   strcpy(str_word[8], "nd_sex");
   strcpy(str_word[9], "nd_source");
   strcpy(str_word[10], "nd_consultant");
   strcpy(str_word[11], "nd_urgency");
   strcpy(str_word[12], "nd_comm_1");
   strcpy(str_word[13], "nd_comm_2");
   strcpy(str_word[14], "nd_comm_3");
   strcpy(str_word[15], "nd_spec_date");
  

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )514;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_worklist_hdr() occured....\n");
   proc_exit();
}
 
/* function declares cursor RL_WORKLIST_FMT_DTL */
void dclr_worklist_dtl_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE WORKLIST_DTL_CUR CURSOR FOR
         SELECT TEST_CODE,              
         	SEQ_NO,                        
	        TEST_INDICATOR             

         FROM   RL_WORKLIST_FMT_DTL                        
         WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND WORKLIST_NAME = :nd_worklist_name              
         ORDER BY SEQ_NO ; */ 
                                     

   /*  Done in Do Report   */
   /*EXEC SQL WHENEVER SQLERROR GOTO err_exit;
     EXEC SQL OPEN TRN_ITEMS_CUR; */

#ifdef DEBUG
    printf("leaving dclr_worklist_dtl_cur()\n");
    fflush(stdout);
#endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )529;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_worklist_dtl_cur() occured....\n");
   proc_exit();
}

void dclr_request_detail_cur()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE REQUEST_DETAIL CURSOR FOR
         SELECT TEST_CODE              
           FROM RL_REQUEST_DETAIL
          WHERE PATIENT_ID = :d_prt_patient_id
	      AND SPECIMEN_NO = :d_prt_specimen_no
          AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		  ORDER BY TEST_CODE; */ 
                                     
#ifdef DEBUG
    printf("leaving dclr_request_detail_cur()\n");
    fflush(stdout);
#endif
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )544;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_request_detail_cur() occured....\n");
   proc_exit();
}

void open_request_detail_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN REQUEST_DETAIL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0015;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )559;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_prt_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_prt_specimen_no;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )586;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while open_request_detail_cur occured...\n");
   proc_exit();
}

int fetch_request_detail_cur()
{
  d_req_dtl_test.arr[0]    = '\0';
  d_req_dtl_test.len       = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH REQUEST_DETAIL INTO :d_req_dtl_test; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 58;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )601;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_req_dtl_test;
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
  d_req_dtl_test.arr[d_req_dtl_test.len]		= '\0';
#ifdef DEBUG
   printf("********* Details from RL_REQUEST_DETAIL**************\n");
   printf(" d_req_dtl_test= %s\n", d_req_dtl_test.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )620;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_detail_cur() occured....\n");
   proc_exit();
}

void close_request_detail_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CLOSE REQUEST_DETAIL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )635;
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
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )650;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Close_request_detail_Cur() occured....\n");
   proc_exit();
}

/* function declares cursor RL_WORKLIST_DTL */
/* Used for Printing Worklist               */
void dclr_worklist_prt_dtl_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE WORKLIST_PRT_DTL_CUR CURSOR FOR
         SELECT WORKLIST_CUP_NO,        
         	SPECIMEN_NO,                   
	        PATIENT_ID,              
		    WORKLIST_CUP_INDICATOR,
	    	TEST_1_YN,
	    	TEST_2_YN,
	    	TEST_3_YN,
	    	TEST_4_YN,
	    	TEST_5_YN,
	    	TEST_6_YN,
	    	TEST_7_YN,
	    	TEST_8_YN,
	    	TEST_9_YN,
	    	TEST_10_YN,
	    	TEST_11_YN,
	    	TEST_12_YN,
	   	    TEST_13_YN,
	    	TEST_14_YN,
	   	    TEST_15_YN,
	    	TEST_16_YN,
	    	TEST_17_YN,
	    	TEST_18_YN,
	    	TEST_19_YN,
	   	    TEST_20_YN,
	    	TEST_21_YN,
	    	TEST_22_YN,
	  	    TEST_23_YN,
	    	TEST_24_YN,
	    	TEST_25_YN 
          FROM RL_WORKLIST_DTL                        
          WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND WORKLIST_NAME = :nd_worklist_name 
	      AND WORKLIST_NO   = TO_NUMBER(:nd_worklist_no) 
          AND TO_CHAR(WORKLIST_DATE,'DD/MM/YYYY') = 
  	      TO_CHAR(TO_DATE(:nd_worklist_date,'DD/MM/YYYY'),'DD/MM/YYYY')
          ORDER BY WORKLIST_CUP_NO; */ 
                             
	      /*AND SPECIMEN_NO IS NOT NULL*/

   /*  Done in Do Report   */
   /*EXEC SQL WHENEVER SQLERROR GOTO err_exit;
     EXEC SQL OPEN TRN_ITEMS_CUR; */

#ifdef DEBUG
    printf("leaving dclr_worklist_prt_dtl_cur()\n");
    fflush(stdout);
#endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )665;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_worklist_prt_dtl_cur() occured....\n");
   proc_exit();
}

void dclr_qlty_tests_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DECLARE QLTY_TESTS_CUR CURSOR FOR
         SELECT TEST_CODE              
         FROM   RL_TEST_QUALITY_MAST                        
         WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND SECTION_CODE = :nd_section_code
	     AND  QLTY_CODE    = :nd_qc_code; */ 


   #ifdef DEBUG
       printf("leaving dclr_qlty_tests_cur()\n");
       fflush(stdout);
   #endif
   return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )680;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_qlty_tests_cur() occured....\n");
   proc_exit();
}
      
/* function declares cursor RL_QC_MATERIAL_TEST */
void dclr_qc_matl_test_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE QC_MATRL_TST_CUR CURSOR FOR
      SELECT TEST_CODE              
      FROM   RL_TEST_CODE                        
      WHERE  TEST_CODE       = :nd_qc_code  ; */ 
          

   /*  Done in Do Report   */
   /*EXEC SQL WHENEVER SQLERROR GOTO err_exit;
     EXEC SQL OPEN TRN_ITEMS_CUR; */

#ifdef DEBUG
    printf("leaving dclr_qc_matrl_tst_cur()\n");
    fflush(stdout);
#endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )695;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_worklist_dtl_cur() occured....\n");
   proc_exit();
}

/* prints the master-detail record until the cursor is empty */
void do_report()
{
  void open_qlty_tests_cur();
  void close_qlty_tests_cur();
  void open_wrklst_dtl_cursor();
  /*void open_qc_matrl_cursor();*/
  /*void close_qc_matrl_cursor();*/
  void initialize_worklist_array();
  void copy_dummy_array();
  void print_worklist();
  int fetch_worklist_dtl_cur();
  int fetch_qlty_tests_cur();
  /*int fetch_qc_matrl_cur();*/
  int still_wrk_test_left;
  int still_qc_left;
  int still_qlty_tests_left =0;
  int rec_no;
  int broken = 0;

    initialize_worklist_array();
    open_wrklst_dtl_cursor();

    worklist_mandatory_tests_exist = 0;

    still_wrk_test_left = fetch_worklist_dtl_cur();
    while(still_wrk_test_left)    /* Worklist Test Details */
    {
      strcpy(worklist_test[d_seq_no-1],d_worklist_test_code.arr);
      if (d_test_indicator.arr[0] == 'M' || d_test_indicator.arr[0] == 'O')
      {
	if(d_test_indicator.arr[0] == 'M')
	   worklist_mandatory_tests_exist = 1;

        strcpy(worklist_ind[d_seq_no-1],d_test_indicator.arr);
        chk_mand_test[d_seq_no-1]=d_test_indicator.arr[0];
      }
      else
      {
        strcpy(worklist_ind[d_seq_no-1]," ");
        chk_mand_test[d_seq_no-1]='N';
      }
      still_wrk_test_left = fetch_worklist_dtl_cur();
    }
    print_worklist();
}

/* function to print the worklist */
void print_worklist()
{  
     int still_prt_specimen_left;
     void open_wrklst_prt_dtl_cur();
     void print_master_rec(FILE *);
     void print_col_heading(FILE *); 
     int fetch_specimen_prt_cur();
     void prepare_new_page(FILE *);
     void print_footer_rec(FILE *);
     void end_report(FILE *);                   
     void print_detl_rec();
	 void get_request_comment1();
	 void get_request_comment2();
	 void get_request_comment3();
	 void spacing(FILE *);

     line_no = 0;

     if (rec_inserted == 0 || strcmp(rp_reprint.arr,"REPRINT")==0)
     {
       page_no +=1;
       no_of_tests = 0;
       if(strcmp(rp_reprint.arr,"REPRINT") == 0)
       {
         strcpy(nd_worklist_name.arr,rp_worklist_name.arr);
	     nd_worklist_name.len = strlen(rp_worklist_name.arr);
	     nd_worklist_no = rp_worklist_no;
	     strcpy(nd_worklist_date.arr,rp_worklist_date.arr);
	     nd_worklist_date.len = strlen(rp_worklist_date.arr);
       }
       open_wrklst_prt_dtl_cur();
       
       tests_on_page = 16;
       
       print_master_rec(f1);
       print_col_heading(f1); 

       tests_on_page = 25;

       if(d_no_of_tests > 16)
       {
	  print_master_rec(f2);
	  print_col_heading(f2);
       }
       
       still_prt_specimen_left = fetch_specimen_prt_cur();

       /* process until first level break group arises */
       while(still_prt_specimen_left) 
       {
          if((line_no + d_line_spacing) >= MAX_LINES)
	  {
            page_no += 1;
	    no_of_tests = 0;
	    print_footer_rec(f1);
            prepare_new_page(f1);
            tests_on_page = 16;
            print_master_rec(f1);
            print_col_heading(f1); 
            tests_on_page = 25;
	         if(d_no_of_tests > 16)
	         {
	           print_footer_rec(f2);
               prepare_new_page(f2);
	           print_master_rec(f2);
	           print_col_heading(f2);
             }
	   }
          print_detl_rec();
          line_no += d_line_spacing;

		   if(d_no_of_tests > 16)
		    spacing(f2);
		   else
			spacing(f1);

          still_prt_specimen_left = fetch_specimen_prt_cur();
       }
       if((line_no + d_line_spacing) >= MAX_LINES)
       {
         page_no += 1;
         prepare_new_page(f1);
         print_footer_rec(f1);
         end_report(f1);
	 if(d_no_of_tests > 16)
	 {
            prepare_new_page(f2);
            print_footer_rec(f2);
            end_report(f2);
         }
        }
        else 
        {
	  for(;line_no < MAX_LINES;line_no++)
	  {
	     fprintf(f1,"\n");
	     if(d_no_of_tests > 16)
	     {
	        fprintf(f2,"\n");
             }
          }
          print_footer_rec(f1);
          end_report(f1);
	  if(d_no_of_tests > 16)
	  {
	     print_footer_rec(f2);
             end_report(f2);
          }
        } 
     }
}

/*This Procedure to open Quality Tests Cursor */
void open_qlty_tests_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN QLTY_TESTS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0022;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )710;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_qc_code;
   sqlstm.sqhstl[2] = (unsigned int  )1;
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
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )737;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Opening qlty tests cur occured...\n");
   proc_exit();
}


/*This Procedure to open Worklist Cursor */
void open_wrklst_dtl_cursor()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN WORKLIST_DTL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0013;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )752;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_worklist_name;
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


   /* EXEC SQL SELECT NVL(COUNT(*),0) INTO :d_no_of_tests
	      FROM RL_WORKLIST_FMT_DTL
             WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND WORKLIST_NAME = :nd_worklist_name; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(count(*) ,0) into :b0  from RL_WORKLIST_FMT_DTL\
 where (OPERATING_FACILITY_ID=:b1 and WORKLIST_NAME=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )775;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_no_of_tests;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )802;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Opening work list dtl cur occured...\n");
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
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0024;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )817;
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
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )836;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Opening QC Matrl Cur() occured....\n");
   proc_exit();
}


/*This Procedure to open Worklist Detail Printing Cursor */
void open_wrklst_prt_dtl_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN WORKLIST_PRT_DTL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0020;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )851;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_worklist_no;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_worklist_date;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )882;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Opening Wrklst prt dtl Cur() occured....\n");
   proc_exit();
}

/*This Procedure to Qlty Tests Cursor */
void close_qlty_tests_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CLOSE QLTY_TESTS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )897;
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
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )912;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Close Qlty Tests Cur() occured....\n");
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
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )927;
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
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )942;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Close QC Matrl Cur() occured....\n");
   proc_exit();
}


/* prepares for the new page */
void prepare_new_page(afp)
FILE *afp;
{
   fprintf(afp,"");
   line_no = 0;
}


/* fetches the next record from CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_worklist_dtl_cur()
{

  d_worklist_test_code.arr[0]                                   = '\0';
  d_test_indicator.arr[0]                                       = '\0';
 
  d_worklist_test_code.len                                      = 0;
  d_test_indicator.len                                          = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH WORKLIST_DTL_CUR INTO
		:d_worklist_test_code,  
		:d_seq_no ,             
		:d_test_indicator; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 58;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )957;
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
  sqlstm.sqhstv[2] = (         void  *)&d_test_indicator;
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


  d_worklist_test_code.arr[d_worklist_test_code .len]		= '\0';
  d_test_indicator.arr[d_test_indicator.len]			= '\0';


#ifdef DEBUG
   printf("********* Details from RL_WORKLIST_FMT_DTL**************\n");
   printf(" d_worklist_test_code= %s\n", d_worklist_test_code.arr);
   printf(" d_test_indicator= %s\n", d_test_indicator.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )984;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_wrklst_dtl_cur() occured....\n");
   proc_exit();

}

/* Function to fetch data from QLTY_TEST_CUR  */
int fetch_qlty_tests_cur()
{
  d_qlty_test.arr[0]                         = '\0';
  d_qlty_test.len                            = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH QLTY_TESTS_CUR INTO
		:d_qlty_test; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 58;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )999;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_qlty_test;
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

  d_qlty_test.arr[d_qlty_test .len]	 		= '\0';


#ifdef DEBUG
   printf("********* Details from RL_QC_MATERIAL_TEST *************\n");
   printf(" d_qlty_test= %s\n", d_qlty_test.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1018;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_qlty_test_cur() occured....\n");
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
  sqlstm.arrsiz = 58;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1033;
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



#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif


  if (NODATAFOUND)
    return 0;

  d_qc_test_code.arr[d_qc_test_code .len]	 		= '\0';


#ifdef DEBUG
   printf("********* Details from RL_QC_MATERIAL_TEST *************\n");
   printf(" d_qc_test_code= %s\n", d_qc_test_code.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1052;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_qc_matrl_cur() occured....\n");
   proc_exit();

}


/* fetches the next record from CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_specimen_prt_cur()
{

  d_prt_specimen_no.arr[0]		 		= '\0';
  d_prt_patient_id.arr[0]		 		= '\0';

  d_prt_specimen_no.len		 			= 0;
  d_prt_patient_id.len                		    	= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH WORKLIST_PRT_DTL_CUR INTO
		:d_prt_cup_no,       
		:d_prt_specimen_no,  
		:d_prt_patient_id,
		:d_print_cup_indicator,
		:d_prt_test_1_yn,
		:d_prt_test_2_yn,
		:d_prt_test_3_yn,
		:d_prt_test_4_yn,
		:d_prt_test_5_yn,
		:d_prt_test_6_yn,
		:d_prt_test_7_yn,
		:d_prt_test_8_yn,
		:d_prt_test_9_yn,
		:d_prt_test_10_yn,
		:d_prt_test_11_yn,
		:d_prt_test_12_yn,
		:d_prt_test_13_yn,
		:d_prt_test_14_yn,
		:d_prt_test_15_yn,
		:d_prt_test_16_yn,
		:d_prt_test_17_yn,
		:d_prt_test_18_yn,
		:d_prt_test_19_yn,
		:d_prt_test_20_yn,
		:d_prt_test_21_yn,
		:d_prt_test_22_yn,
		:d_prt_test_23_yn,
		:d_prt_test_24_yn,
		:d_prt_test_25_yn; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 58;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1067;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_prt_cup_no;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_prt_specimen_no;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_prt_patient_id;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_print_cup_indicator;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_prt_test_1_yn;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_prt_test_2_yn;
  sqlstm.sqhstl[5] = (unsigned int  )1;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_prt_test_3_yn;
  sqlstm.sqhstl[6] = (unsigned int  )1;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_prt_test_4_yn;
  sqlstm.sqhstl[7] = (unsigned int  )1;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_prt_test_5_yn;
  sqlstm.sqhstl[8] = (unsigned int  )1;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_prt_test_6_yn;
  sqlstm.sqhstl[9] = (unsigned int  )1;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_prt_test_7_yn;
  sqlstm.sqhstl[10] = (unsigned int  )1;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_prt_test_8_yn;
  sqlstm.sqhstl[11] = (unsigned int  )1;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_prt_test_9_yn;
  sqlstm.sqhstl[12] = (unsigned int  )1;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_prt_test_10_yn;
  sqlstm.sqhstl[13] = (unsigned int  )1;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_prt_test_11_yn;
  sqlstm.sqhstl[14] = (unsigned int  )1;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_prt_test_12_yn;
  sqlstm.sqhstl[15] = (unsigned int  )1;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_prt_test_13_yn;
  sqlstm.sqhstl[16] = (unsigned int  )1;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_prt_test_14_yn;
  sqlstm.sqhstl[17] = (unsigned int  )1;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&d_prt_test_15_yn;
  sqlstm.sqhstl[18] = (unsigned int  )1;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&d_prt_test_16_yn;
  sqlstm.sqhstl[19] = (unsigned int  )1;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&d_prt_test_17_yn;
  sqlstm.sqhstl[20] = (unsigned int  )1;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqhstv[21] = (         void  *)&d_prt_test_18_yn;
  sqlstm.sqhstl[21] = (unsigned int  )1;
  sqlstm.sqhsts[21] = (         int  )0;
  sqlstm.sqindv[21] = (         void  *)0;
  sqlstm.sqinds[21] = (         int  )0;
  sqlstm.sqharm[21] = (unsigned int  )0;
  sqlstm.sqadto[21] = (unsigned short )0;
  sqlstm.sqtdso[21] = (unsigned short )0;
  sqlstm.sqhstv[22] = (         void  *)&d_prt_test_19_yn;
  sqlstm.sqhstl[22] = (unsigned int  )1;
  sqlstm.sqhsts[22] = (         int  )0;
  sqlstm.sqindv[22] = (         void  *)0;
  sqlstm.sqinds[22] = (         int  )0;
  sqlstm.sqharm[22] = (unsigned int  )0;
  sqlstm.sqadto[22] = (unsigned short )0;
  sqlstm.sqtdso[22] = (unsigned short )0;
  sqlstm.sqhstv[23] = (         void  *)&d_prt_test_20_yn;
  sqlstm.sqhstl[23] = (unsigned int  )1;
  sqlstm.sqhsts[23] = (         int  )0;
  sqlstm.sqindv[23] = (         void  *)0;
  sqlstm.sqinds[23] = (         int  )0;
  sqlstm.sqharm[23] = (unsigned int  )0;
  sqlstm.sqadto[23] = (unsigned short )0;
  sqlstm.sqtdso[23] = (unsigned short )0;
  sqlstm.sqhstv[24] = (         void  *)&d_prt_test_21_yn;
  sqlstm.sqhstl[24] = (unsigned int  )1;
  sqlstm.sqhsts[24] = (         int  )0;
  sqlstm.sqindv[24] = (         void  *)0;
  sqlstm.sqinds[24] = (         int  )0;
  sqlstm.sqharm[24] = (unsigned int  )0;
  sqlstm.sqadto[24] = (unsigned short )0;
  sqlstm.sqtdso[24] = (unsigned short )0;
  sqlstm.sqhstv[25] = (         void  *)&d_prt_test_22_yn;
  sqlstm.sqhstl[25] = (unsigned int  )1;
  sqlstm.sqhsts[25] = (         int  )0;
  sqlstm.sqindv[25] = (         void  *)0;
  sqlstm.sqinds[25] = (         int  )0;
  sqlstm.sqharm[25] = (unsigned int  )0;
  sqlstm.sqadto[25] = (unsigned short )0;
  sqlstm.sqtdso[25] = (unsigned short )0;
  sqlstm.sqhstv[26] = (         void  *)&d_prt_test_23_yn;
  sqlstm.sqhstl[26] = (unsigned int  )1;
  sqlstm.sqhsts[26] = (         int  )0;
  sqlstm.sqindv[26] = (         void  *)0;
  sqlstm.sqinds[26] = (         int  )0;
  sqlstm.sqharm[26] = (unsigned int  )0;
  sqlstm.sqadto[26] = (unsigned short )0;
  sqlstm.sqtdso[26] = (unsigned short )0;
  sqlstm.sqhstv[27] = (         void  *)&d_prt_test_24_yn;
  sqlstm.sqhstl[27] = (unsigned int  )1;
  sqlstm.sqhsts[27] = (         int  )0;
  sqlstm.sqindv[27] = (         void  *)0;
  sqlstm.sqinds[27] = (         int  )0;
  sqlstm.sqharm[27] = (unsigned int  )0;
  sqlstm.sqadto[27] = (unsigned short )0;
  sqlstm.sqtdso[27] = (unsigned short )0;
  sqlstm.sqhstv[28] = (         void  *)&d_prt_test_25_yn;
  sqlstm.sqhstl[28] = (unsigned int  )1;
  sqlstm.sqhsts[28] = (         int  )0;
  sqlstm.sqindv[28] = (         void  *)0;
  sqlstm.sqinds[28] = (         int  )0;
  sqlstm.sqharm[28] = (unsigned int  )0;
  sqlstm.sqadto[28] = (unsigned short )0;
  sqlstm.sqtdso[28] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
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


  d_prt_specimen_no.arr[d_prt_specimen_no.len]			= '\0';
  d_prt_patient_id.arr[d_prt_patient_id.len]			= '\0';
  d_print_cup_indicator.arr[d_print_cup_indicator.len]          = '\0';


#ifdef DEBUG 
   printf("********* Details from RL_WORKLIST_DTL******************\n");
   printf(" d_prt_cup_no        = %d\n",d_prt_cup_no);
   printf(" d_prt_specimen_no   = <%s>\n",d_prt_specimen_no.arr);
   printf(" d_prt_patient_id    = %s\n",d_prt_patient_id.arr);
   printf(" d_prt_test_1_yn     = %c\n",d_prt_test_1_yn);
   printf(" d_prt_test_2_yn     = %c\n",d_prt_test_2_yn);
   printf(" d_prt_test_3_yn     = %c\n",d_prt_test_3_yn);
   printf(" d_prt_test_4_yn     = %c\n",d_prt_test_4_yn);
   printf(" d_prt_test_5_yn     = %c\n",d_prt_test_5_yn);
   printf(" d_prt_test_6_yn     = %c\n",d_prt_test_6_yn);
   printf(" d_prt_test_7_yn     = %c\n",d_prt_test_7_yn);
   printf(" d_prt_test_8_yn     = %c\n",d_prt_test_8_yn);
   printf(" d_prt_test_9_yn     = %c\n",d_prt_test_9_yn);
   printf(" d_prt_test_10_yn     = %c\n",d_prt_test_10_yn);
   printf(" d_prt_test_11_yn     = %c\n",d_prt_test_11_yn);
   printf(" d_prt_test_12_yn     = %c\n",d_prt_test_12_yn);
   printf(" d_prt_test_13_yn     = %c\n",d_prt_test_13_yn);
   printf(" d_prt_test_14_yn     = %c\n",d_prt_test_14_yn);
   printf(" d_prt_test_15_yn     = %c\n",d_prt_test_15_yn);
   printf(" d_prt_test_16_yn     = %c\n",d_prt_test_16_yn);
   printf(" d_prt_test_17_yn     = %c\n",d_prt_test_17_yn);
   printf(" d_prt_test_18_yn     = %c\n",d_prt_test_18_yn);
   printf(" d_prt_test_19_yn     = %c\n",d_prt_test_19_yn);
   printf(" d_prt_test_20_yn     = %c\n",d_prt_test_20_yn);
   printf(" d_prt_test_21_yn     = %c\n",d_prt_test_21_yn);
   printf(" d_prt_test_22_yn     = %c\n",d_prt_test_22_yn);
   printf(" d_prt_test_23_yn     = %c\n",d_prt_test_23_yn);
   printf(" d_prt_test_24_yn     = %c\n",d_prt_test_24_yn);
   printf(" d_prt_test_25_yn     = %c\n",d_prt_test_25_yn);
#endif

#ifdef DEBUG
   printf("********* Details from RL_WORKLIST_DTL******************\n");
   printf(" length of specimen  = %d\n",d_prt_specimen_no.len);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1198;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_prt_specimen_cur() occured....\n");
   proc_exit();

}



/* to initialize worklist array with some default value */
void initialize_worklist_array()
{
  int    i;

  for (i=0;i<25;i++)
  {
    strcpy(worklist_test[i], "     ");
    strcpy(worklist_ind[i]," ");
    chk_mand_test[i]=' ';
  }

}


/* to copy the worklist test indicators array to some dummy array     */
/* before checking whether all tests is there in specimen     */
void copy_dummy_array()                 
{
  int    i;

  for (i=0;i<d_no_of_tests;i++)
  {
    /*dummy_test_array[i]=chk_mand_test[i]; */
    mandatory_ind[i] = ' ';
    dummy_test_array[i]='N';
  }

}

/* print the master record */
void print_master_rec(afp)
FILE *afp;
{
  int    i;
  int    j;
  char l_str[2];

  fprintf(afp,"\n");
  fprintf(afp,"%-10s WORKLIST",nd_worklist_name.arr);
  fprintf(afp,"\n");
  fprintf(afp,"WORKLIST NUMBER : %-5d   ", nd_worklist_no);
  fprintf(afp,"DATE : %-10s        ", nd_worklist_date.arr);

  /* EXEC SQL SELECT USER INTO :nd_user_id FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 58;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select USER into :b0  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1213;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_user_id;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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


  nd_user_id.arr[nd_user_id.len]   =  '\0';

  d_added_by_id.arr[0] = '\0';
  d_added_by_id.len    = 0;
  /* EXEC SQL SELECT ADDED_BY_ID into :d_added_by_id
	     FROM RL_WORKLIST_HDR
            WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND SECTION_CODE  = :nd_section_code 
	        AND WORKLIST_NAME = :nd_worklist_name
	        AND WORKLIST_NO   = :nd_worklist_no
	        AND TRUNC(WORKLIST_DATE) = TO_DATE(:nd_worklist_date,
						  'DD/MM/YYYY'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 58;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select ADDED_BY_ID into :b0  from RL_WORKLIST_HDR where (((\
(OPERATING_FACILITY_ID=:b1 and SECTION_CODE=:b2) and WORKLIST_NAME=:b3) and WO\
RKLIST_NO=:b4) and TRUNC(WORKLIST_DATE)=TO_DATE(:b5,'DD/MM/YYYY'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1232;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_added_by_id;
  sqlstm.sqhstl[0] = (unsigned int  )53;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
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


  d_added_by_id.arr[d_added_by_id.len] = '\0';

  fprintf(afp,"CREATED BY : %-20s ",d_added_by_id.arr);

  if(strcmp(rp_reprint.arr,"REPRINT") == 0)
     fprintf(afp,"REPRINTED ON : %-10s",d_sysdate.arr);
  else
     fprintf(afp,"  PRINTED ON : %-10s",d_sysdate.arr);
     
  fprintf(afp," ");
  fprintf(afp,"PAGE : %4d", page_no);               
  if(tests_on_page > 16)
     fprintf(afp," B");
  else
     fprintf(afp," A");
  fprintf(afp,"\n\n");
  i = no_of_tests;
  line_no += 12;
  /***** IF THE TESTS HAS TO PRINT IN THE RIGHT SIDE
	    THE NEXT PORTION (NEWLY ADDED PART)  HAS TO BE COMMENTED
		OTHER WISE IT WILL PRINT IN LEFT SIDE
		VERY NEXT TO LAST COLUMN OF 
        LINE 1   ******/
/********* N E W L Y A D D E D *******/
sorting();
j = 15;
while(j >= 0)
{
	
	if (num[j] == 1)
	{
	    tests = 0;
		tests = cou[j];
		tot_tests = get_col_length(j);
		tests = tests + tot_tests + 1;
		break;
	
	}

	j--;

}
/********  UPTO HERE  FOR TEST CODE PRINTING IN LEFT SIDE ******/

/***** THIS COMMENTED PORTION HAS TO MAKE EFFECTIVE
		IF THE TESTS HAS TO PRINT IN RIGHT SIDE *****/ 

/*
  if (d_no_of_tests > 16)
	  tests = 132 - ((16 * 6) - 1);
  else
      tests = 132 - ((d_no_of_tests * 6) - 1);
*/


  for (j=0;j<5;j++)
  {
/*    fprintf(afp,"                                        ");*/

	 fprintf(afp, "%*.*s", tests, tests, "");

    for (no_of_tests = i ; no_of_tests < tests_on_page ; no_of_tests++)
    {
      sprintf(l_str,"%c",worklist_test[no_of_tests][j]);
      fprintf(afp,"%1s     ",l_str);
    }
    fprintf(afp,"\n");
  }

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1271;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_master_rec() occured....\n");
   proc_exit();
}


/******** GETTING COLUMN LENGTH   ********/
int get_col_length(col_no)
int col_no ;
{

 int str_len = 0;
 
 if (strcmp(str_word[col_no],"nd_cup_number") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 3)
   	   return str_len;
	else 
	   return 3 ;
 }
 else if (strcmp(str_word[col_no],"nd_cup_indr") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 1)
   	   return str_len;
	else 
	   return 1 ;
 }
 else if (strcmp(str_word[col_no],"nd_wl_marker") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 1)
   	   return str_len;
	else 
	   return 1 ;
 }
 
 else if (strcmp(str_word[col_no],"nd_spec_no") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 9)
   	   return str_len;
	else 
	   return 9 ;
 }
 else if (strcmp(str_word[col_no],"nd_pat_id") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 30)
   	   return str_len;
	else 
	   return 30 ;
 }
 else if (strcmp(str_word[col_no],"nd_pat_name") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 30)
   	   return str_len;
	else 
	   return 30 ;
 }
 else if (strcmp(str_word[col_no],"nd_age") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 9)
   	   return str_len;
	else 
	   return 9 ;
 }
 else if (strcmp(str_word[col_no],"nd_dob") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 10)
   	   return str_len;
	else 
	   return 10 ;
 }
 else if (strcmp(str_word[col_no],"nd_sex") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 1)
   	   return str_len;
	else 
	   return 1 ;
 }
 else if (strcmp(str_word[col_no],"nd_source") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 4)
   	   return str_len;
	else 
	   return 4 ;
 }
 else if (strcmp(str_word[col_no],"nd_consultant") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 6)
   	   return str_len;
	else 
	   return 6 ;
 }
 else if (strcmp(str_word[col_no],"nd_urgency") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 1)
   	   return str_len;
	else 
	   return 1 ;
 }
 else if (strcmp(str_word[col_no],"nd_comm_1") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 40)
   	   return str_len;
	else 
	   return 40 ;
 }
 else if (strcmp(str_word[col_no],"nd_comm_2") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 40)
   	   return str_len;
	else 
	   return 40 ;
 }
 else if (strcmp(str_word[col_no],"nd_comm_3") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 40)
   	   return str_len;
	else 
	   return 40 ;
 }
 else if (strcmp(str_word[col_no],"nd_spec_date") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 19)
   	   return str_len;
	else 
	   return 19 ;
 }

}

/* to print the detailed record */
void print_detl_rec()
{ 
    void print_detl_line(FILE *);
	void print_detl(FILE *);
	void print_all_tests(FILE *);		
    int i;
    int j = 0;
    int  get_in_patient_dtl();
	void get_general_patient_dtl(),
	 get_referral_patient_dtl();



    d_source_code.arr[0]		 		= '\0';
    d_source_code.len		 			= 0;
	d_consultant_code.arr[0]				= '\0';
	d_consultant_code.len				= 0;
	d_urgent_indicator.arr[0]				= '\0';
	d_urgent_indicator.len				= 0;
	d_request_comment_code1.arr[0] 		= '\0';
	d_request_comment_code1.len			= 0;
	d_request_comment_code2.arr[0] 		= '\0';
	d_request_comment_code2.len			= 0;
	d_request_comment_code3.arr[0] 		= '\0';
	d_request_comment_code3.len			= 0;

    d_episode_type.arr[0]                               = '\0';
    d_episode_type.len                                  = 0;
    d_spec_regd_date_time.arr[0]                        = '\0';
    d_spec_regd_date_time.len                           = 0;

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT SOURCE_CODE,
		    EPISODE_TYPE,
			CONSULTANT_CODE,
			URGENT_INDICATOR,
			REQUEST_COMMENT_CODE1,
			REQUEST_COMMENT_CODE2,
			REQUEST_COMMENT_CODE3,
		    TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI')
	       INTO :d_source_code,
		    :d_episode_type,
			:d_consultant_code,
			:d_urgent_indicator,
			:d_request_comment_code1,
			:d_request_comment_code2,
			:d_request_comment_code3,
		    :d_spec_regd_date_time
	       FROM RL_REQUEST_HEADER   
	       WHERE PATIENT_ID  = :d_prt_patient_id  
		   AND SPECIMEN_NO = :d_prt_specimen_no
		   AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 58;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SOURCE_CODE ,EPISODE_TYPE ,CONSULTANT_CODE ,URGENT\
_INDICATOR ,REQUEST_COMMENT_CODE1 ,REQUEST_COMMENT_CODE2 ,REQUEST_COMMENT_CODE\
3 ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') into :b0,:b1,:b2,:b3,:b4,\
:b5,:b6,:b7  from RL_REQUEST_HEADER where ((PATIENT_ID=:b8 and SPECIMEN_NO=:b9\
) and OPERATING_FACILITY_ID=:b10)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1286;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_source_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_consultant_code;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_urgent_indicator;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_request_comment_code1;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_request_comment_code2;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_request_comment_code3;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[7] = (unsigned int  )19;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_prt_patient_id;
    sqlstm.sqhstl[8] = (unsigned int  )33;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_prt_specimen_no;
    sqlstm.sqhstl[9] = (unsigned int  )23;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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


    
    d_source_code.arr[d_source_code.len] 		= '\0';
    d_episode_type.arr[d_episode_type.len]              = '\0';
    d_spec_regd_date_time.arr[d_spec_regd_date_time.len]= '\0';
	d_consultant_code.arr[d_consultant_code.len] = '\0';
	d_urgent_indicator.arr[d_urgent_indicator.len] ='\0';
	d_request_comment_code1.arr[d_request_comment_code1.len] = '\0';
	d_request_comment_code2.arr[d_request_comment_code2.len] = '\0';
	d_request_comment_code3.arr[d_request_comment_code3.len] = '\0';

    d_short_name.arr[0]		 			= '\0';
    d_date_of_birth.arr[0]		 		= '\0';
    d_nation.arr[0]                                     = '\0';

    d_short_name.len		 			= 0;
    d_date_of_birth.len                		    	= 0;
    d_nation.len                                        = 0;

	get_request_comment1();
	get_request_comment2(); 
 	get_request_comment3(); 

/************ ACTUAL ROYAL VERSION
    if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0
		|| strcmp(d_episode_type.arr,"H")==0)
    {
       i = get_in_patient_dtl();
       if(i==0)
	 get_general_patient_dtl();
    }
    else
       if(strcmp(d_episode_type.arr,"R")==0) 
         get_referral_patient_dtl();
**************/

/** ACTUAL S.A VERSION  ****/
if(   strcmp(d_episode_type.arr,"I")==0 
	   || strcmp(d_episode_type.arr,"O")==0
	   || strcmp(d_episode_type.arr,"H")==0 )
    {
       i = get_in_patient_dtl();
       
    }
    else
       if(strcmp(d_episode_type.arr,"R")==0) 
         get_referral_patient_dtl();


    no_of_tests = 16;
    test_ctr=0;
    print_detl_line(f1);
    no_of_tests = 25;
    if(d_no_of_tests > 16) 
       print_detl_line(f2);

    print_all_tests(f1);

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1345;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}

/*
void print_detl_rec()
{ 
    void print_detl_line(FILE *);
	void print_detl(FILE *);
	void print_all_tests(FILE *);		
    int i;
    int j = 0;
    int  get_in_patient_dtl();
    void get_general_patient_dtl(),
	 get_referral_patient_dtl();

    d_source_code.arr[0]		 		= '\0';
    d_source_code.len		 			= 0;
    d_episode_type.arr[0]                               = '\0';
    d_episode_type.len                                  = 0;
    d_spec_regd_date_time.arr[0]                        = '\0';
    d_spec_regd_date_time.len                           = 0;

    EXEC SQL WHENEVER SQLERROR GOTO err_exit;
    EXEC SQL SELECT SOURCE_CODE,
		    EPISODE_TYPE,
		    TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM')
	       INTO :d_source_code,
		    :d_episode_type,
		    :d_spec_regd_date_time
	       FROM RL_REQUEST_HEADER   
	       WHERE PATIENT_ID  = :d_prt_patient_id  
		   AND SPECIMEN_NO = :d_prt_specimen_no
		   AND OPERATING_FACILITY_ID = :nd_operating_facility_id;
    
    d_source_code.arr[d_source_code.len] 		= '\0';
    d_episode_type.arr[d_episode_type.len]              = '\0';
    d_spec_regd_date_time.arr[d_spec_regd_date_time.len]= '\0';

    d_short_name.arr[0]		 			= '\0';
    d_date_of_birth.arr[0]		 		= '\0';
    d_nation.arr[0]                                     = '\0';

    d_short_name.len		 			= 0;
    d_date_of_birth.len                		    	= 0;
    d_nation.len                                        = 0;

	get_request_comment1();
	get_request_comment2(); 
 	get_request_comment3();

	if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0 || strcmp(d_episode_type.arr,"H")==0)
    {
       i = get_in_patient_dtl();
       
    }
    else
       if(strcmp(d_episode_type.arr,"R")==0) 
         get_referral_patient_dtl();

    no_of_tests = 16;
    test_ctr=0;
    print_detl_line(f1);
    no_of_tests = 25;
    if(d_no_of_tests > 16) 
       print_detl_line(f2);
return;

err_exit:
   EXEC SQL WHENEVER SQLERROR CONTINUE;
   EXEC SQL ROLLBACK WORK RELEASE;
   disp_message(ORA_MESG,"Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}
*/

void get_request_comment1()
{

 d_request_comment_desc1.arr[0] = '\0';
 d_request_comment_desc1.len = 0;
                                                                                                            
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT request_comment
               INTO :d_request_comment_desc1
			FROM RL_REQUEST_COMMENT_CODE
                        WHERE section_code = :nd_section_code
						AND request_comment_code =
						 :d_request_comment_code1 ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 58;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select request_comment into :b0  from RL_REQUEST_COMMENT_\
CODE where (section_code=:b1 and request_comment_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1360;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_request_comment_desc1;
    sqlstm.sqhstl[0] = (unsigned int  )44;
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
    sqlstm.sqhstv[2] = (         void  *)&d_request_comment_code1;
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


						

    d_request_comment_desc1.arr[d_request_comment_desc1.len] = '\0';

	
	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1387;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_request_comment1() occured....\n");
   proc_exit();
}

void get_request_comment2()
{

 d_request_comment_desc2.arr[0] = '\0';
 d_request_comment_desc2.len = 0;

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT REQUEST_COMMENT
               INTO :d_request_comment_desc2
			FROM RL_REQUEST_COMMENT_CODE
			WHERE request_comment_code = 
                                :d_request_comment_code2
                         AND section_code =  :nd_section_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 58;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select REQUEST_COMMENT into :b0  from RL_REQUEST_COMMENT_\
CODE where (request_comment_code=:b1 and section_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1402;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_request_comment_desc2;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_request_comment_code2;
    sqlstm.sqhstl[1] = (unsigned int  )7;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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



    d_request_comment_desc2.arr[d_request_comment_desc2.len] = '\0';

	return ;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1429;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_request_comment2() occured....\n");
   proc_exit();
}

void get_request_comment3()
{

 d_request_comment_desc3.arr[0] = '\0';
 d_request_comment_desc3.len = 0;

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT REQUEST_COMMENT
               INTO :d_request_comment_desc3
			FROM RL_REQUEST_COMMENT_CODE
			WHERE request_comment_code = 
                                :d_request_comment_code3
                         AND section_code =  :nd_section_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 58;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select REQUEST_COMMENT into :b0  from RL_REQUEST_COMMENT_\
CODE where (request_comment_code=:b1 and section_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1444;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_request_comment_desc3;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_request_comment_code3;
    sqlstm.sqhstl[1] = (unsigned int  )7;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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



    d_request_comment_desc3.arr[d_request_comment_desc3.len] = '\0';

	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1471;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_request_comment3() occured....\n");
   proc_exit();
}

int space_or_line(prt_yn,ind)
char prt_yn;
char ind;
{
    test_ctr++;
    if(prt_yn == 'Y')
       return 1;
    else
    {
       if(prt_yn == 'N') 
       {
    	  if(ind == 'O' || ind == 'M')
	     return 0;
          else
             return 1;
       }
    }
}

void get_test_result(i)
int i;
{
   t_worklist_test.arr[0] = '\0';
   t_numeric_result.arr[0] = '\0';
   t_result_comment.arr[0] = '\0';
   t_worklist_test.len = 0;
   t_numeric_result.len = 0;
   t_result_comment.len = 0;
   strcpy(t_worklist_test.arr,worklist_test[i]);
   t_worklist_test.len = strlen(t_worklist_test.arr);
   if(print_line && (strcmp(t_worklist_test.arr,"     ") != 0))
      strcpy(uline,"_____");
   else
      strcpy(uline,"     ");

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


 if(strcmp(t_worklist_test.arr,"     ") != 0)
 {
   /* EXEC SQL SELECT NUMERIC_RESULT,RESULT_COMMENT_CODE1 
	      INTO :t_numeric_result,:t_result_comment
	      FROM RL_TEST_RESULT
             WHERE PATIENT_ID  = :d_prt_patient_id
	         AND SPECIMEN_NO = :d_prt_specimen_no
             AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	         AND TEST_CODE   = :t_worklist_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NUMERIC_RESULT ,RESULT_COMMENT_CODE1 into :b0,:b1  \
from RL_TEST_RESULT where (((PATIENT_ID=:b2 and SPECIMEN_NO=:b3) and OPERATING\
_FACILITY_ID=:b4) and TEST_CODE=:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1486;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&t_numeric_result;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&t_result_comment;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_prt_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_prt_specimen_no;
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
   sqlstm.sqhstv[5] = (         void  *)&t_worklist_test;
   sqlstm.sqhstl[5] = (unsigned int  )13;
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



   t_numeric_result.arr[t_numeric_result.len] = '\0';
   t_result_comment.arr[t_result_comment.len] = '\0';
 }
/*   printf("t_worklist_test = %s l = %d t_numeric_result = %s l = %d  t_result_comment = %s l = %d \n",t_worklist_test.arr,t_worklist_test.len,
t_numeric_result.arr,t_numeric_result.len,
t_result_comment.arr,t_result_comment.len);
getchar(); */
   if(t_numeric_result.len)
      strcpy(uline,t_numeric_result.arr);
   else
      if(t_result_comment.len)
         strcpy(uline,t_result_comment.arr);
  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1525;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_test_result() occured....\n");
   proc_exit();
}

void print_detl_line(afp)
FILE *afp;
{
	/*void get_test_result();
	void open_request_detail_cur();
    int fetch_request_detail_cur();
    void close_request_detail_cur();
    int space_or_line();
    int i=0,r=0;*/

	print_dtl(afp);

    /*
	fprintf(afp,"%3d ", d_prt_cup_no);
    fprintf(afp,"%c",d_print_cup_indicator.arr[0]);
    fprintf(afp," %-10s",d_prt_specimen_no.arr);
    fprintf(afp,"%-13s",d_prt_patient_id.arr);
    fprintf(afp,"%-5s      ", d_source_code.arr);

  if( no_of_tests < 25 )
  { 
    print_line = 0;
    print_line = space_or_line(d_prt_test_1_yn,worklist_ind[0][0]);
    get_test_result(0);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_2_yn,worklist_ind[1][0]);
    get_test_result(1);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_3_yn,worklist_ind[2][0]);
    get_test_result(2);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_4_yn,worklist_ind[3][0]);
    get_test_result(3);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_5_yn,worklist_ind[4][0]);
    get_test_result(4);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_6_yn,worklist_ind[5][0]);
    get_test_result(5);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_7_yn,worklist_ind[6][0]);
    get_test_result(6);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_8_yn,worklist_ind[7][0]);
    get_test_result(7);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_9_yn,worklist_ind[8][0]);
    get_test_result(8);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_10_yn,worklist_ind[9][0]);
    get_test_result(9);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_11_yn,worklist_ind[10][0]);
    get_test_result(10);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_12_yn,worklist_ind[11][0]);
    get_test_result(11);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_13_yn,worklist_ind[12][0]);
    get_test_result(12);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_14_yn,worklist_ind[13][0]);
    get_test_result(13);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_15_yn,worklist_ind[14][0]);
    get_test_result(14);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_16_yn,worklist_ind[15][0]);
    get_test_result(15);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
   }
   else
   {
    print_line = 0;
    print_line = space_or_line(d_prt_test_17_yn,worklist_ind[16][0]);
    get_test_result(16);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_18_yn,worklist_ind[17][0]);
    get_test_result(17);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_19_yn,worklist_ind[18][0]);
    get_test_result(18);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_20_yn,worklist_ind[19][0]);
    get_test_result(19);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_21_yn,worklist_ind[20][0]);
    get_test_result(20);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_22_yn,worklist_ind[21][0]);
    get_test_result(21);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_23_yn,worklist_ind[22][0]);
    get_test_result(22);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_24_yn,worklist_ind[23][0]);
    get_test_result(23);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_25_yn,worklist_ind[24][0]);
    get_test_result(24);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       fprintf(afp,"%-6s",uline);
  }
    fprintf(afp,"\n");
  
    fprintf(afp,"      %5s ",d_spec_regd_date_time.arr);
    fprintf(afp,"%-15s %-10s", d_short_name.arr,d_date_of_birth.arr);
    fprintf(afp,"\n");

    fprintf(afp,"      ");
    open_request_detail_cur();
    r = fetch_request_detail_cur();
    while(r)
    {
       fprintf(afp,"%-5.5s ",d_req_dtl_test.arr);
       r = fetch_request_detail_cur();
    }
    fprintf(afp,"\n");
    line_no++;
    close_request_detail_cur();
    for (i=0;i<d_line_spacing;i++)
      fprintf(afp,"\n");
	*/
}

/* Function to fetch the GENERAL PATIENT details */
void get_general_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(SHORT_NAME,1,15),
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   NATIONALITY_CODE,
		   SEX 
	      INTO :d_short_name, 
		   :d_date_of_birth,
		   :d_nation,
		   :d_sex
              FROM MP_PATIENT_MAST 
	     WHERE PATIENT_ID = :d_prt_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(SHORT_NAME,1,15) ,TO_CHAR(DATE_OF_BIRTH,'DD/\
MM/YYYY') ,NATIONALITY_CODE ,SEX into :b0,:b1,:b2,:b3  from MP_PATIENT_MAST wh\
ere PATIENT_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1540;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_short_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_nation;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_sex;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_prt_patient_id;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_short_name.arr[d_short_name.len]     = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]                       = '\0';
  d_nation.arr[d_nation.len]                 = '\0';
  d_sex.arr[d_sex.len]					= '\0';

  patient_age();

  #ifdef DEBUG
   printf("d_short_name= %s\n", d_short_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1575;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_general_patient_dtl() occured....\n");
   proc_exit();
}

/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(SHORT_NAME,1,15), 
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   NATIONALITY_CODE,
		   SEX
	      INTO :d_short_name,
		   :d_date_of_birth,
		   :d_nation,
		   :d_sex
          FROM RL_PATIENT_MAST 
	      WHERE PATIENT_ID = :d_prt_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(SHORT_NAME,1,15) ,TO_CHAR(DATE_OF_BIRTH,'DD/\
MM/YYYY') ,NATIONALITY_CODE ,SEX into :b0,:b1,:b2,:b3  from RL_PATIENT_MAST wh\
ere PATIENT_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1590;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_short_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_nation;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_sex;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_prt_patient_id;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


		  /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id;*/

  d_short_name.arr[d_short_name.len]     = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]                       = '\0';
  d_nation.arr[d_nation.len]                 = '\0';
  d_sex.arr[d_sex.len]					= '\0';

  patient_age();

  #ifdef DEBUG
   printf("d_short_name= %s\n", d_short_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1625;
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

   /* EXEC SQL SELECT SUBSTR(SHORT_NAME,1,15),
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   NATIONALITY_CODE ,
		   SEX
	      INTO :d_short_name,
		   :d_date_of_birth,
		   :d_nation,
		   :d_sex
              FROM MP_PATIENT_MAST 
	     WHERE PATIENT_ID = :d_prt_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(SHORT_NAME,1,15) ,TO_CHAR(DATE_OF_BIRTH,'DD/\
MM/YYYY') ,NATIONALITY_CODE ,SEX into :b0,:b1,:b2,:b3  from MP_PATIENT_MAST wh\
ere PATIENT_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1640;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_short_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_nation;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_sex;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_prt_patient_id;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
    return 0;
  d_short_name.arr[d_short_name.len]     = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]                       = '\0';
  d_nation.arr[d_nation.len]                 = '\0';
  d_sex.arr[d_sex.len]					= '\0';

  patient_age();

  #ifdef DEBUG
   printf("d_short_name= %s\n", d_short_name.arr);
  #endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1675;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_in_patient_dtl() occured....\n");
   proc_exit();
}


/* print the heading */
void print_col_heading(afp)
FILE *afp;
{
 prepare_heading(afp);

 /*
 fprintf(afp,"\n");
 fprintf(afp,"CUP   SPECIMEN  HOSPITAL NO. SRCE \n");
 fprintf(afp,"------------------------------------------------------------");
 fprintf(afp,"------------------------------------------------------------");
 fprintf(afp,"----------------");
 fprintf(afp,"\n");
 */

}



/* to print the last line of the report */
void print_footer_rec(afp)
FILE *afp;
{
/*  fprintf(afp,"\n\n\n");*/
  fprintf(afp,"------------------------------------------------------------");
  fprintf(afp,"------------------------------------------------------------");
  fprintf(afp,"----------------");
  fprintf(afp,"\n\n");
  fprintf(afp,"ENTERED BY : ________________________________________       ");
  fprintf(afp,"DATE : _________");
  fprintf(afp,"\n");
  fprintf(afp,"------------------------------------------------------------");
  fprintf(afp,"------------------------------------------------------------");
  fprintf(afp,"----------------");

}



/* to print the last line of the report */
void end_report(afp)
FILE *afp;
{
  fprintf(afp,"\n");
  fprintf(afp,"");
}

gen_file_name()
{
 	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 strcat(nd_file_name.arr,"rlrwlre1.lis");
	 nd_file_name.len = strlen(nd_file_name.arr);
	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
   else
   {
	     fprintf(f1,"%c&|26A",ESC);
		 fprintf(f1,"%c&a90P",ESC);
	     fprintf(f1,"%c&|1O",ESC);
	     fprintf(f1,"%c&k4S",ESC);
   }
}


increment_file_no()
{
/* EXEC SQL UPDATE RL_PARAM
		 SET PRINT_FILE_NO = NVL(PRINT_FILE_NO,0) + 1;*/

if (OERROR)
       disp_message(ERR_MESG,"Update failed on table RL_PARAM");

/* EXEC SQL COMMIT WORK; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 58;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1690;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      if (OERROR)
         disp_message(ERR_MESG,"COMMIT failed");
}

/*------------------ REVERSE SORT ARRAY ------------------*/
void reverse_sort()
{

  for(i=0;i<16;i++)
  {
    if (strcmp(str_word[i],"nd_cup_number") == 0)
		strcpy(detail[i], d_prt_cup_no.arr);	
	else if(strcmp(str_word[i],"nd_cup_indr") == 0) 
		strcpy(detail[i], d_print_cup_indicator.arr);
    else if(strcmp(str_word[i],"nd_wl_marker") == 0) 
		strcpy(detail[i], d_pat_mark.arr);
	else if(strcmp(str_word[i],"nd_spec_no") == 0) 
		strcpy(detail[i], d_prt_specimen_no.arr);
	else if(strcmp(str_word[i],"nd_pat_id") == 0) 
		strcpy(detail[i], d_prt_patient_id.arr);
	else if(strcmp(str_word[i],"nd_pat_name") == 0) 
		strcpy(detail[i], d_short_name.arr);
	else if(strcmp(str_word[i],"nd_age") == 0) 
		strcpy(detail[i], t_age.arr);
	else if(strcmp(str_word[i],"nd_dob") == 0) 
		strcpy(detail[i], d_date_of_birth.arr);
	else if(strcmp(str_word[i],"nd_sex") == 0) 
		strcpy(detail[i], d_sex.arr);
	else if(strcmp(str_word[i],"nd_source") == 0) 
		strcpy(detail[i], d_source_code.arr);
	else if(strcmp(str_word[i],"nd_consultant") == 0) 
		strcpy(detail[i], d_consultant_code.arr);
	else if(strcmp(str_word[i],"nd_urgency") == 0) 
		strcpy(detail[i], d_urgent_indicator.arr);
	else if(strcmp(str_word[i],"nd_comm_1") == 0) 
		strcpy(detail[i], d_request_comment_desc1.arr);
	else if(strcmp(str_word[i],"nd_comm_2") == 0) 
		strcpy(detail[i], d_request_comment_desc2.arr);
	else if(strcmp(str_word[i],"nd_comm_3") == 0) 
		strcpy(detail[i], d_request_comment_desc3.arr);
	else if(strcmp(str_word[i],"nd_spec_date") == 0) 
		strcpy(detail[i], d_spec_regd_date_time.arr);
  }


}

/*------------------ S O R T I N G ------------------*/
void sorting()
{
	maxx = num[0] ;

	for(i=0;i<16;i++)
	{
		for(j=i+1;j<16;j++)
		{
			if (((num[j] < num[i]) || (num[i] == 0))  && (num[j] > 0))
			{
				total  = num[i];
				num[i] = num[j];
				num[j] = total;

				total  = cou[i];
				cou[i] = cou[j];
				cou[j] = total;
			
				strcpy(temp_word,word[i]);
				strcpy(word[i], word[j]);
				strcpy(word[j], temp_word);

				strcpy(temp_word,detail[i]);
				strcpy(detail[i], detail[j]);
				strcpy(detail[j], temp_word);

				strcpy(temp_word,str_word[i]);
				strcpy(str_word[i], str_word[j]);
				strcpy(str_word[j], temp_word);


			}
			else if (num[j] > num[i])
			  maxx = num[j];
		
		}	
	
	}


	for(i=0;i<16;i++)
	{
		for(j=i+1;j<16;j++)
		{
			if ((num[j] == num[i]) && (num[j] > 0))
			{
				if (((cou[j] < cou[i]) || (cou[i] == 0)) && (cou[j] > 0))
				{
				   total = cou[i];
				   cou[i] = cou[j];
				   cou[j] = total;

				   strcpy(temp_word,word[i]);
				   strcpy(word[i], word[j]);
				   strcpy(word[j], temp_word);

				   strcpy(temp_word,detail[i]);
				   strcpy(detail[i], detail[j]);
				   strcpy(detail[j], temp_word);

				   strcpy(temp_word,str_word[i]);
			  	   strcpy(str_word[i], str_word[j]);
				   strcpy(str_word[j], temp_word);

				}

			}
		
		}	
	
	}

	
}

/*-----------------------------------------------------*/
void print_dtl(afp)
FILE *afp;
{

	char fl_ag[3];
	total = 0;
	ctr   = 1;
	strcpy(fl_ag, "F");
	reverse_sort();
	sorting();

	for(i=1;i<=16;i++)
	{

	 
	   k = i;

	   for (j=0;j<16;j++)
	   {
		
		  
	      if (num[j] == ctr)
	      {

			  str_len = strlen(detail[j])  ;

/*			  if ((strcmp(fl_ag,"F") == 0) && (str_len > 0) )*/
		/**** CHANGED ON 13/12/1999 BECAUSE PREVIOUS COMMENTED IS FAILING
			  BECAUSE OF VALUE IN str_len can be null AND
			  IT WILL NOT SKIP THE LINE *****/

			  if ((strcmp(fl_ag,"F") == 0))
			  	strcpy(fl_ag, "T");
			
			  									 		
			  if ((j > 0) && (num[j - 1] == num[j]))
			  {
			      total = cou[j - 1] ;
			       str_len = strlen(detail[j - 1])  ;
			  }
			
			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {
			     fprintf(afp,"%*s",(cou[j]   - (total + str_len)),"");
  		         fprintf(afp,"%s", detail[j]);
                     /*
				 stimulate = (cou[j]   - (total + str_len));
				 stimulate = stimulate + strlen(detail[j] + 1) ;
                      */
                 tot_tests = get_col_length(j);
                 stimulate = (cou[j]   + tot_tests);

				 /***** IF THE TESTS HAS TO PRINT IN THE RIGHT SIDE
					    THE NEXT LINE HAS TO BE COMMENTED
						OTHER WISE IT WILL PRINT IN LEFT SIDE
						VERY NEXT TO LAST COLUMN OF 
						LINE 1   ******/

                 stimulate = stimulate - (cou[j] + strlen(detail[j]));
                                                
			  }
			  else
			  {
				fprintf(afp,"%*s", cou[j] - 1, "");
				fprintf(afp,"%s", detail[j]);
          /*
				stimulate = (cou[j]   - 1);
				stimulate = stimulate + strlen(detail[j] + 1) ;
           */
                tot_tests = get_col_length(j);
                stimulate = (cou[j]   + tot_tests);

		   /***** IF THE TESTS HAS TO PRINT IN THE RIGHT SIDE
		  	    THE NEXT LINE HAS TO BE COMMENTED
				OTHER WISE IT WILL PRINT IN LEFT SIDE
				VERY NEXT TO LAST COLUMN OF 
				LINE 1   ******/

                stimulate = stimulate - (cou[j] + strlen(detail[j]));

			  }
			  

			  k = j ;		   
			  str_len = 0;

 	/*	     if ((strlen(detail[j]) > 0) && (flag = 'F') && (num[j] > 0))
  			      flag = 'T';	  */

			  
	      }
		
      }
	
	   i = k;
	   
	   if ((num[i] > 0) && (maxx >= num[i]))
	   {

		  if (num[i] == 1)
		  {

			print_hyphen(afp);
			stimulate = 0;
		  }
		  	
	      if (strcmp(fl_ag,"T") == 0)
		  {
		    
			fprintf(afp,"\n");
		    line_no++;
			strcpy(fl_ag, "F");
		  }
	      total = 0;


	  }

	   ctr = ctr + 1 ;
	   strcpy(fl_ag,"F");

	}

}

void print_hyphen(afp)
FILE *afp;
{
	void get_test_result();
	int space_or_line();
        int i=0,r=0;

  fprintf(afp," ");

  /***** IF THE TESTS HAS TO PRINT IN THE RIGHT SIDE
	    THE NEXT TWO LINES HAS TO BE COMMENTED
		OTHER WISE IT WILL PRINT IN LEFT SIDE
		VERY NEXT TO LAST COLUMN OF 
		LINE 1   ******/

  fprintf(afp," ");

  tests = stimulate ;

  /*** THIS COMMENT PORTION HAS TO BE REMOVED 
     IT THE TESTS HAS TO PRINT IN THE RIGHT
	 SIDE   *****/


/*
  if (d_no_of_tests > 16)
       tests = (132 - ((16 * 6) - 1)) - stimulate ;
  else
       tests = (132 - ((d_no_of_tests * 6) - 1)) - stimulate ;
*/


  fprintf(afp, "%*.*s", tests, tests, "");
  

  if( no_of_tests < 25 )
  { 
  	print_line = 0;
    print_line = space_or_line(d_prt_test_1_yn,worklist_ind[0][0]);
    get_test_result(0);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_2_yn,worklist_ind[1][0]);
	get_test_result(1);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_3_yn,worklist_ind[2][0]);
	get_test_result(2);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_4_yn,worklist_ind[3][0]);
	get_test_result(3);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_5_yn,worklist_ind[4][0]);
	get_test_result(4);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_6_yn,worklist_ind[5][0]);
	get_test_result(5);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_7_yn,worklist_ind[6][0]);
	get_test_result(6);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_8_yn,worklist_ind[7][0]);
	get_test_result(7);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_9_yn,worklist_ind[8][0]);
	get_test_result(8);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_10_yn,worklist_ind[9][0]);
	get_test_result(9);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_11_yn,worklist_ind[10][0]);
	get_test_result(10);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_12_yn,worklist_ind[11][0]);
	get_test_result(11);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_13_yn,worklist_ind[12][0]);
	get_test_result(12);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_14_yn,worklist_ind[13][0]);
	get_test_result(13);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_15_yn,worklist_ind[14][0]);
	get_test_result(14);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_16_yn,worklist_ind[15][0]);
	get_test_result(15);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-5.5s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-5.5s",uline);
   }
   else
   {
    print_line = 0;
    print_line = space_or_line(d_prt_test_17_yn,worklist_ind[16][0]);
	get_test_result(16);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_18_yn,worklist_ind[17][0]);
	get_test_result(17);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_19_yn,worklist_ind[18][0]);
	get_test_result(18);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_20_yn,worklist_ind[19][0]);
	get_test_result(19);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_21_yn,worklist_ind[20][0]);
	get_test_result(20);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_22_yn,worklist_ind[21][0]);
	get_test_result(21);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_23_yn,worklist_ind[22][0]);
	get_test_result(22);
    if(print_line  &&  test_ctr <= d_no_of_tests)
		fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_24_yn,worklist_ind[23][0]);
	get_test_result(23);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
    print_line = 0;
    print_line = space_or_line(d_prt_test_25_yn,worklist_ind[24][0]);
	get_test_result(24);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s",uline);
    else
       if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s",uline);
  }
  

}

/* ------------ P R I N T T E S T S --------*/
void print_all_tests(f1)
FILE *f1;
{

    void open_request_detail_cur();
    int fetch_request_detail_cur();
    void close_request_detail_cur();

	int print_line = 0;
    int i=0,r=0;

    open_request_detail_cur();
    r = fetch_request_detail_cur();
    while(r)
    {
       fprintf(f1,"%-5.5s ",d_req_dtl_test.arr);
       r = fetch_request_detail_cur();
    }
    fprintf(f1,"\n");
    line_no++;
    close_request_detail_cur();

	return;

}


/*------------------ H E A D I N G ------------------*/
void prepare_heading(afp)
FILE *afp;
{

    char heading[60] ;
	int length = 0;

	sorting();

		
    total = 0;
	ctr   = 1;

	for(i=1;i<=16;i++)
	{
	 
	   k = i;

	   for (j=0;j<16;j++)
	   {
		
		
	      if (num[j] == ctr) 
	      {
					
			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {

			      total = cou[j - 1] ;
				  str_len = strlen(word[j - 1])  ;
				  
			  }
			
			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {
			     fprintf(afp,"%*s",(cou[j]   - (total + str_len)),"");
  		         fprintf(afp,"%s", word[j]);
			  }
			  else
			  {
				fprintf(afp,"%*s", cou[j] - 1, "");
				fprintf(afp,"%s", word[j]);
			  }

			  k = j ;		   
			  str_len = 0;
			  
	      }

		  

      }
	
	   i = k;

	   if ((num[i] > 0) && (num[i] <= maxx))
	   {
     
		  fprintf(afp,"\n");
	      fprintf(afp,"-----------------------------------");
	      fprintf(afp,"-----------------------------------");
	      fprintf(afp,"-----------------------------------");
	      fprintf(afp,"---------------------------");
	      fprintf(afp,"\n");
		  total = 0;
		  line_no += 2;

	  }

	   ctr = ctr + 1 ;

	}


	return ;
}


/*----------- S P A C I N G ------------*/
void spacing(afp)
FILE *afp;
{
	 
    for (i=0;i<d_line_spacing;i++)
      fprintf(afp,"\n");
}

/*-------------   Age of Patient in Years, Months, Days --------------*/

 void patient_age()
 {

		 float  lone = 0;
		 float  num1 = 0, yrs = 0, 
				tmp_mths = 0, 
				tmp_days = 0;

		 char st_r[50];

	today.arr[0] = '\0';
	today.len = 0;

	mths.arr[0]  = '\0';
	mths.len  = 0;

	
	/* EXEC SQL SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') INTO :today
            FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 58;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1705;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&today;
 sqlstm.sqhstl[0] = (unsigned int  )32;
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

                                        

    /* EXEC SQL SELECT ABS(MONTHS_BETWEEN(
		TO_DATE(:today,'DD/MM/YYYY'), 
		TO_DATE(:d_date_of_birth, 'DD/MM/YYYY')))
			INTO :mt FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 58;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ABS(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),TO_DA\
TE(:b1,'DD/MM/YYYY'))) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1724;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&today;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&mt;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(float);
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



			sprintf(mths.arr,"%f",mt);
			strcpy(mths1.arr, mths.arr);

        	today.arr[today.len] = '\0';
							
			lone = atoi(strtok(mths1.arr, ".")) ;

		   if (lone > 0) 
		   {
			  num1 = lone/12 ;
			  sprintf(t_age.arr, "%f", num1);
			  yrs = atoi(strtok(t_age.arr, ".")) ;
		   }
		   else
			  yrs = 0;
            
			tmp_mths   = atoi(mths1.arr) - (yrs * 12) ;
			sprintf(t_age.arr, "%f", tmp_mths);
			tmp_mths   = atoi(strtok(t_age.arr, "."));

			if ((tmp_mths == 0)  && (yrs ==0))
			{

				/* EXEC SQL SELECT TO_CHAR(ROUND((TO_DATE(:today,'DD/MM/YYYY') -
					TO_DATE(:d_date_of_birth, 'DD/MM/YYYY')),3))
					INTO :t_days FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 58;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ROUND((TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:\
b1,'DD/MM/YYYY')),3)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1751;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&today;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_days;
    sqlstm.sqhstl[2] = (unsigned int  )32;
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



					tmp_days = atoi(strtok(t_days.arr,"."));
			}
			else
				tmp_days = (atof(mths.arr) - atoi(mths1.arr)) * 31 ;
				
			sprintf(st_r, "%f", yrs);
			strcpy(t_age.arr, strtok(st_r, "."));
			sprintf(st_r, " %f", tmp_mths);
			strcat(t_age.arr, strtok(st_r, "."));
			sprintf(st_r, " %f", tmp_days);
			strcat(t_age.arr, strtok(st_r, "."));
				
 }

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
