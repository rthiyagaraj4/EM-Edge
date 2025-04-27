
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
           char  filnam[20];
};
static const struct sqlcxp sqlfpn =
{
    19,
    "c:\\temp\\rlrtrerp.pc"
};


static unsigned long sqlctx = 36389467;


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
            void  *sqhstv[23];
   unsigned int   sqhstl[23];
            int   sqhsts[23];
            void  *sqindv[23];
            int   sqinds[23];
   unsigned int   sqharm[23];
   unsigned int   *sqharc[23];
   unsigned short  sqadto[23];
   unsigned short  sqtdso[23];
} sqlstm = {10,23};

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
"select SPECIMEN_NO ,PATIENT_ID ,EPISODE_TYPE ,SOURCE_CODE ,SOURCE_TYPE ,TO_C\
HAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD\
/MM/YYYY') ,CATEGORY_CODE ,CATEGORY_YEAR ,CATEGORY_NUMBER ,ORDERED_FACILITY_ID\
  from RL_REQUEST_HEADER where (((((((SPECIMEN_NO between NVL(:b0,0) and NVL(:\
b1,TO_NUMBER(:b2)) and SECTION_CODE=:b3) and OPERATING_FACILITY_ID=:b4) and SP\
EC_REGD_DATE_TIME>to_date(:b5,'DD/MM/YYYY')) and SPEC_REGD_DATE_TIME<(to_date(\
:b6,'DD/MM/YYYY')+1)) and SOURCE_CODE=NVL(:b7,SOURCE_CODE)) and SOURCE_TYPE=DE\
CODE(NVL(:b8,SOURCE_TYPE),'C','C','W','W','R','E','E','E')) and NVL(CANCELLED_\
YN,'N')<>'Y')           ";

 static const char *sq0014 = 
"select NVL(NUMERIC_PREFIX,'+') ,NUMERIC_RESULT ,RESULT_COMMENT_DESC1 ,RESULT\
_COMMENT_DESC2 ,RESULT_COMMENT_DESC3 ,RESULT_COMMENT_DESC4  from RL_TEST_RESUL\
T where (((((SPECIMEN_NO=:b0 and OPERATING_FACILITY_ID=:b1) and TEST_CODE=:b2)\
 and NVL(CANCELLED_YN,'N')<>'Y') and NUMERIC_RESULT is  not null ) and (DECODE\
(NUMERIC_PREFIX,'-',((-1)* NUMERIC_RESULT),NUMERIC_RESULT) between (TO_NUMBER(\
:b3)-((ABS(TO_NUMBER(:b3))* TO_NUMBER(:b5))/100)) and TO_NUMBER(:b3) or (DECOD\
E(NUMERIC_PREFIX,'-',((-1)* NUMERIC_RESULT),NUMERIC_RESULT) between TO_NUMBER(\
:b7) and (TO_NUMBER(:b7)+(ABS(TO_NUMBER(:b7))* (TO_NUMBER(:b5)/100))) and (NUM\
ERIC_RESULT is  not null  or (((DECODE(NVL(:b11,'A'),'A','A',RESULT_COMMENT_CO\
DE1)=NVL(:b11,'A') and DECODE(NVL(:b13,'B'),'B','B',RESULT_COMMENT_CODE2)=NVL(\
:b13,'B')) and DECODE(NVL(:b15,'C'),'C','C',RESULT_COMMENT_CODE3)=NVL(:b15,'C'\
)) and DECODE(NVL(:b17,'D'),'D','D',RESULT_COMMENT_CODE4)=NVL(:b17,'D')))))) o\
rder by TO_NUMBER(NUMERIC_RESULT)            ";

 static const char *sq0015 = 
"select NVL(NUMERIC_PREFIX,'+') ,NUMERIC_RESULT ,RESULT_COMMENT_DESC1 ,RESULT\
_COMMENT_DESC2 ,RESULT_COMMENT_DESC3 ,RESULT_COMMENT_DESC4  from RL_TEST_RESUL\
T where (((((SPECIMEN_NO=:b0 and OPERATING_FACILITY_ID=:b1) and TEST_CODE=:b2)\
 and NVL(CANCELLED_YN,'N')<>'Y') and NUMERIC_RESULT is  not null ) and (DECODE\
(NUMERIC_PREFIX,'-',((-1)* NUMERIC_RESULT),NUMERIC_RESULT) between (TO_NUMBER(\
:b3)-((ABS(TO_NUMBER(:b3))* TO_NUMBER(:b5))/100)) and TO_NUMBER(:b3) or (DECOD\
E(NUMERIC_PREFIX,'-',((-1)* NUMERIC_RESULT),NUMERIC_RESULT) between TO_NUMBER(\
:b7) and (TO_NUMBER(:b7)+(ABS(TO_NUMBER(:b7))* (TO_NUMBER(:b5)/100))) and (((D\
ECODE(NVL(:b11,'A'),'A','A',RESULT_COMMENT_CODE1)=NVL(:b11,'A') and DECODE(NVL\
(:b13,'B'),'B','B',RESULT_COMMENT_CODE2)=NVL(:b13,'B')) and DECODE(NVL(:b15,'C\
'),'C','C',RESULT_COMMENT_CODE3)=NVL(:b15,'C')) and DECODE(NVL(:b17,'D'),'D','\
D',RESULT_COMMENT_CODE4)=NVL(:b17,'D'))))) order by TO_NUMBER(NUMERIC_RESULT) \
           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,284,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,55,0,4,308,0,0,1,0,0,1,0,2,3,0,0,
55,0,0,3,0,0,30,353,0,0,0,0,0,1,0,
70,0,0,4,0,0,32,360,0,0,0,0,0,1,0,
85,0,0,5,120,0,6,371,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
108,0,0,6,136,0,6,382,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
131,0,0,7,403,0,4,434,0,0,23,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
238,0,0,8,98,0,2,569,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
261,0,0,9,0,0,32,578,0,0,0,0,0,1,0,
276,0,0,10,150,0,4,587,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
311,0,0,11,0,0,32,611,0,0,0,0,0,1,0,
326,0,0,12,646,0,9,651,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
377,0,0,13,0,0,32,656,0,0,0,0,0,1,0,
392,0,0,16,0,0,32,776,0,0,0,0,0,1,0,
407,0,0,17,226,0,4,796,0,0,8,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,
454,0,0,18,0,0,32,849,0,0,0,0,0,1,0,
469,0,0,19,211,0,4,858,0,0,7,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,
512,0,0,20,0,0,32,905,0,0,0,0,0,1,0,
527,0,0,21,57,0,4,929,0,0,1,0,0,1,0,2,9,0,0,
546,0,0,22,100,0,4,932,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,4,0,0,
573,0,0,23,99,0,4,962,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
600,0,0,12,0,0,15,1084,0,0,0,0,0,1,0,
615,0,0,12,0,0,13,1102,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
674,0,0,24,0,0,32,1137,0,0,0,0,0,1,0,
689,0,0,25,67,0,4,1148,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
712,0,0,14,0,0,15,1164,0,0,0,0,0,1,0,
727,0,0,15,0,0,15,1166,0,0,0,0,0,1,0,
742,0,0,14,979,0,9,1176,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
833,0,0,14,0,0,13,1192,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,
872,0,0,15,945,0,9,1217,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
963,0,0,15,0,0,13,1233,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,
1002,0,0,26,0,0,32,1256,0,0,0,0,0,1,0,
1017,0,0,27,0,0,32,1316,0,0,0,0,0,1,0,
1032,0,0,28,131,0,6,1362,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1059,0,0,29,283,0,4,1582,0,0,9,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1110,0,0,30,0,0,32,1606,0,0,0,0,0,1,0,
1125,0,0,31,110,0,4,1644,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1156,0,0,32,0,0,32,1663,0,0,0,0,0,1,0,
1171,0,0,33,137,0,4,1690,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1206,0,0,34,125,0,4,1698,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1241,0,0,35,98,0,4,1706,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1268,0,0,36,98,0,4,1713,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1295,0,0,37,0,0,32,1731,0,0,0,0,0,1,0,
1310,0,0,38,100,0,4,1743,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1337,0,0,39,0,0,32,1755,0,0,0,0,0,1,0,
1352,0,0,40,129,0,6,1772,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1379,0,0,41,128,0,6,1791,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1406,0,0,42,100,0,6,2048,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
1429,0,0,43,101,0,6,2114,0,0,1,1,0,1,0,2,3,0,0,
1448,0,0,44,49,0,4,2127,0,0,1,0,0,1,0,2,9,0,0,
1467,0,0,45,88,0,4,2154,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/***************************************************************************** 
*  File	         : rlrtrerp.pc
   Author        : 
   Date Created  : 
   Last Modified : 

   last Modified :Robert -(For changing to variance report)

*  Ver 1.10.01  
   
*  Purpose : To Generate Test Result trend Report
            
*  Input Parameters : 
                      Command line inputs
		              1. Usr_id/Password
                      2. Session id  
		              3. Program Date

                      Parameters from SY_PROG_PARAM table 
  
*  Tables Accessed :     

*****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include "gl.h"

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ESC 0x1B
#define REP_WIDTH 80
/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* increased the length all varchar variables by one to take care */
    /* for null termination */
	/* VARCHAR     nd_operating_facility_id [3],
	            uid_pwd		            [91],
				nd_file_name            [150] ,
                nd_file_no              [15],
                nd_session_id      	    [16],
		        nd_pgm_date	   	        [20],
				d_version_no			[20],
				d_version  			    [20],

        /o Specimen Information o/
	    d_specimen_no           [21],
		d_patient_id            [31],
		
		d_source_code           [12],
		nd_source_code           [12],
		d_src_type				[2],
        d_episode_type          [2],
		d_spec_date		[21],
		d_spec_date1    [21],
		l_spec_date		[21],
		
		/o Primary test result o/
		d_numeric_result	        [16],
		d_numeric_prefix            [3],
                d_rc_1         		[41],
                d_rc_2         		[41],
                d_rc_3         		[41],
                d_rc_4         		[41],

		/o Secondary test result o/
		        s_numeric_result	[16],
                s_rc_1         		[41],
                s_rc_2         		[41],
                s_rc_3         		[41],
                s_rc_4         		[41],

		/o  Patient Master details  o/
		d_short_name            [240],
		
		d_patient_name_1		[240],
		d_patient_name_2		[240],
		d_patient_name_3		[240],
		d_patient_name_4		[240],
		
		d_date_of_birth         [11],
		d_sex                   [2],
		d_nation		[8],
		d_bldg_num		[5],
		d_flat_num		[5],
		d_way_num		[5],
		d_block_num		[5],
		d_street_name		[24],
		d_landmark		[41],
		d_town_name		[21],
		d_res_wilayat_name	[21],
        d_res_tel_num           [21],
        d_other_contact_num     [21],
		d_actual_dob_yn				  [2], 

		/o******* parameters from SY_PROG_PARAM table **********o/
		nd_fr_date			[31],
		nd_fr_date1         [31],
		nd_to_date			[31],
		nd_to_date1         [31],
		nd_section_code    	[2],
		nd_test_code		[11],
		nd_test_desc        [41],
		nd_variance				[6],
		nd_num_rslt			[16],		
		nd_op2				[4],
		nd_rcc1				[5],
		nd_rcc2				[5],
		nd_rcc3				[5],
		nd_rcc4				[5],
		nd_sec_test			[11],
		nd_sec_test_desc    [41],
		nd_third_test		[11],
		nd_third_test_desc  [41],
		nd_fourth_test		[11],
		nd_fourth_test_desc [41],
		nd_fifth_test		[11],
		nd_fifth_test_desc  [41],
		nd_episode_type     [2],

        nd_src_type             [2],
        nd_src_code             [7],		
        nd_src_desc             [61],
		nd_source_desc          [16],
		d_location				[11],

        nd_test                 [11],
		nd_description          [41],
		nd_test_units			[11],
		nd_test_units_desc		[41],

/oadded by Shruti on 04/01/2004 as per front end changeso/
		nd_num_rslt_to			[16],
		nd_specimen_from        [21], 
		nd_specimen_to          [21],

		/o for header routine o/
	    //d_acc_entity_name        [61],
		d_acc_entity_name        [300],
		d_user                   [21],
		d_sysdate                [17],
		d_sysdate1               [17],

/o added by Amjad on 16/7/2002 for KN ENHANCEMENTo/

		d_category_code         [5],
		d_category_year         [5],
		d_category_num          [16],


	/o added by Ananthi on 18/6/2002 for KN ENHANCEMENTo/

		nd_fr_specimen_no       [21], 
		nd_to_specimen_no       [21],

	/o added by Shruti on 04/09/2003 for ordered_facility_ido/
		rl_ordered_facility_id	[3],

    /o end of code added on 18/6/2002o/


    /o Printer destination from RL_SECTION_CODE o/
	        d_printer_name            [16],
			d_dept_desc				  [41],
            d_specimen_prefix         [2]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[12]; } d_source_code;

struct { unsigned short len; unsigned char arr[12]; } nd_source_code;

struct { unsigned short len; unsigned char arr[2]; } d_src_type;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_spec_date;

struct { unsigned short len; unsigned char arr[21]; } d_spec_date1;

struct { unsigned short len; unsigned char arr[21]; } l_spec_date;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result;

struct { unsigned short len; unsigned char arr[3]; } d_numeric_prefix;

struct { unsigned short len; unsigned char arr[41]; } d_rc_1;

struct { unsigned short len; unsigned char arr[41]; } d_rc_2;

struct { unsigned short len; unsigned char arr[41]; } d_rc_3;

struct { unsigned short len; unsigned char arr[41]; } d_rc_4;

struct { unsigned short len; unsigned char arr[16]; } s_numeric_result;

struct { unsigned short len; unsigned char arr[41]; } s_rc_1;

struct { unsigned short len; unsigned char arr[41]; } s_rc_2;

struct { unsigned short len; unsigned char arr[41]; } s_rc_3;

struct { unsigned short len; unsigned char arr[41]; } s_rc_4;

struct { unsigned short len; unsigned char arr[240]; } d_short_name;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_1;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_2;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_3;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_4;

struct { unsigned short len; unsigned char arr[11]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[8]; } d_nation;

struct { unsigned short len; unsigned char arr[5]; } d_bldg_num;

struct { unsigned short len; unsigned char arr[5]; } d_flat_num;

struct { unsigned short len; unsigned char arr[5]; } d_way_num;

struct { unsigned short len; unsigned char arr[5]; } d_block_num;

struct { unsigned short len; unsigned char arr[24]; } d_street_name;

struct { unsigned short len; unsigned char arr[41]; } d_landmark;

struct { unsigned short len; unsigned char arr[21]; } d_town_name;

struct { unsigned short len; unsigned char arr[21]; } d_res_wilayat_name;

struct { unsigned short len; unsigned char arr[21]; } d_res_tel_num;

struct { unsigned short len; unsigned char arr[21]; } d_other_contact_num;

struct { unsigned short len; unsigned char arr[2]; } d_actual_dob_yn;

struct { unsigned short len; unsigned char arr[31]; } nd_fr_date;

struct { unsigned short len; unsigned char arr[31]; } nd_fr_date1;

struct { unsigned short len; unsigned char arr[31]; } nd_to_date;

struct { unsigned short len; unsigned char arr[31]; } nd_to_date1;

struct { unsigned short len; unsigned char arr[2]; } nd_section_code;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code;

struct { unsigned short len; unsigned char arr[41]; } nd_test_desc;

struct { unsigned short len; unsigned char arr[6]; } nd_variance;

struct { unsigned short len; unsigned char arr[16]; } nd_num_rslt;

struct { unsigned short len; unsigned char arr[4]; } nd_op2;

struct { unsigned short len; unsigned char arr[5]; } nd_rcc1;

struct { unsigned short len; unsigned char arr[5]; } nd_rcc2;

struct { unsigned short len; unsigned char arr[5]; } nd_rcc3;

struct { unsigned short len; unsigned char arr[5]; } nd_rcc4;

struct { unsigned short len; unsigned char arr[11]; } nd_sec_test;

struct { unsigned short len; unsigned char arr[41]; } nd_sec_test_desc;

struct { unsigned short len; unsigned char arr[11]; } nd_third_test;

struct { unsigned short len; unsigned char arr[41]; } nd_third_test_desc;

struct { unsigned short len; unsigned char arr[11]; } nd_fourth_test;

struct { unsigned short len; unsigned char arr[41]; } nd_fourth_test_desc;

struct { unsigned short len; unsigned char arr[11]; } nd_fifth_test;

struct { unsigned short len; unsigned char arr[41]; } nd_fifth_test_desc;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_src_type;

struct { unsigned short len; unsigned char arr[7]; } nd_src_code;

struct { unsigned short len; unsigned char arr[61]; } nd_src_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_source_desc;

struct { unsigned short len; unsigned char arr[11]; } d_location;

struct { unsigned short len; unsigned char arr[11]; } nd_test;

struct { unsigned short len; unsigned char arr[41]; } nd_description;

struct { unsigned short len; unsigned char arr[11]; } nd_test_units;

struct { unsigned short len; unsigned char arr[41]; } nd_test_units_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_num_rslt_to;

struct { unsigned short len; unsigned char arr[21]; } nd_specimen_from;

struct { unsigned short len; unsigned char arr[21]; } nd_specimen_to;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;

struct { unsigned short len; unsigned char arr[5]; } d_category_code;

struct { unsigned short len; unsigned char arr[5]; } d_category_year;

struct { unsigned short len; unsigned char arr[16]; } d_category_num;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_specimen_no;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[16]; } d_printer_name;

struct { unsigned short len; unsigned char arr[41]; } d_dept_desc;

struct { unsigned short len; unsigned char arr[2]; } d_specimen_prefix;


	char            sql_stmt[5000];
 
	/* added by Ananthi on 18/6/2002 for KN ENHANCEMENT*/

	int l_count = 0;
	int l_specimen_length = 0;


   /*  For Patient Age SYSDATE, MTHS amjad 17/7/2002*/
   /* VARCHAR  tday				[30],
			t_days				[30],
			mths				[30],
			mths1				[30],
			t_age				[30],
			frmvar				[30],
			tovar				[30]; */ 
struct { unsigned short len; unsigned char arr[30]; } tday;

struct { unsigned short len; unsigned char arr[30]; } t_days;

struct { unsigned short len; unsigned char arr[30]; } mths;

struct { unsigned short len; unsigned char arr[30]; } mths1;

struct { unsigned short len; unsigned char arr[30]; } t_age;

struct { unsigned short len; unsigned char arr[30]; } frmvar;

struct { unsigned short len; unsigned char arr[30]; } tovar;


	/* VARCHAR l_translated_value  [500], //added for globalisation
	        language_id [5]; */ 
struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;
 //added for globalisation
    int     i; //added for globalisation

	float mt;

	int  l_tab_exists ;
	double frnum;
	double tonum;

	char src_code[11];
	  char fnum[30];
	  char tnum[30];
	  char *strnum;

/* EXEC SQL END DECLARE SECTION; */ 


	int		l_len = 30;
	char	l_delimeter;


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

char      sys_command[200];

int   l_length = 0;
int   i;

/* added on 05/01/2003*/

	int					d_specimen_count;
	double				d_result_total  = 0;
	float				d_result_mean   = 0;			


FILE *fp;
void print_page_header();
void print_col_heading();
void prepare_new_page();
void end_report();
void print_detl_rec();
void print_record();
int  line_no = 0, page_no = 0,d_specimen_count = 0;
char string_var[100] ;

char local_legend[40][600];  //added for globalisation

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];


//char rep_title1[] = "RESULT TRENDING REPORT";
char rep_title1[400];

char rep_title2[30];


void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
  	do_report(),
	dclr_request_header_cur(),
    dclr_test_result_cur();
	//get_dept_printer();

   if(argc < 4) {
     disp_message(ORA_MESG,"Usage rlrcrewl uid/passwd session_id pgm_date\n");
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

  

#ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
#endif  
   
   set_meduser_role();

   /******* from here added for globalisation ********/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
   /******* upto here added for globalisation ********/
   
   get_params();

   get_legend_value(31);  //added for globalisation

   //get_dept_printer();

   gen_file_name();
   
/***************** code added for KN ENHANCEMENT **********************/
   
  /* EXEC SQL SELECT NVL(specimen_length, 15)
	     INTO :l_specimen_length
	     FROM RL_PARAM; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(specimen_length,15) into :b0  from RL_PARAM ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  l_length = l_specimen_length -  strlen(d_specimen_prefix.arr);

  if(strlen(nd_fr_specimen_no.arr) == 0)
  {
      strcpy(nd_fr_specimen_no.arr,d_specimen_prefix.arr);

	for (i=1; i<= l_length; i++)
	{
  	   strcat(nd_fr_specimen_no.arr,"0");
	}

      nd_fr_specimen_no.len = strlen(nd_fr_specimen_no.arr);
  }

  if(strlen(nd_to_specimen_no.arr) == 0)
  {
     strcpy(nd_to_specimen_no.arr,d_specimen_prefix.arr);
	
/**
	for (i=1; i<= l_length; i++)
**/
	for (i=1; i<= l_specimen_length; i++)
	{
  	   strcat(nd_to_specimen_no.arr,"9");
	}
      nd_to_specimen_no.len = strlen(nd_to_specimen_no.arr);

  }

/********************* end of code added on 18/6/2002 ****************/



   /*increment_file_no();*/

   dclr_request_header_cur();
   dclr_test_result_cur();
   get_header_dtls();
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
   sqlstm.offset = (unsigned int  )55;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
}



   fclose(fp);
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
   sqlstm.offset = (unsigned int  )70;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}
/* -------------------------------------------------------------------------*/
/* get the printer name */

/******** added for globalisation start ******************/

get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRTRERP.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRTRERP.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )85;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRTRERP.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLRTRERP.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )108;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[0] = (unsigned int  )502;
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
/******** added for globalisation end ******************/


/***************** this procedure is not getting used any where
void get_dept_printer()
{

   EXEC SQL WHENEVER SQLERROR GOTO err_exit;
   EXEC SQL SELECT printer_name,specimen_prefix 
	      INTO :d_printer_name,:d_specimen_prefix,
              FROM RL_SECTION_CODE
	     WHERE SECTION_CODE = :nd_section_code;

  d_printer_name.arr[d_printer_name.len] = '\0';
  d_specimen_prefix.arr[d_specimen_prefix.len] = '\0';
  

#ifdef DEBUG
   printf("d_printer_name = %s\n", d_printer_name.arr);
   printf("d_specimen_prefix = %s\n", d_specimen_prefix.arr);  
#endif

  return;

err_exit:
   EXEC SQL WHENEVER SQLERROR CONTINUE;
   EXEC SQL ROLLBACK WORK RELEASE;
   disp_message(ORA_MESG,"Oracle error at get_dept_printer() occured....\n");
   proc_exit();
}
*******************/

/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
                   PARAM1, PARAM2, PARAM3, PARAM4, PARAM5, PARAM6,
		           PARAM7, PARAM8, PARAM9, PARAM10, PARAM11, PARAM12,
                   PARAM13,PARAM14,PARAM15,PARAM16,PARAM17,PARAM18,PARAM19,PARAM20
            INTO 
		           :nd_operating_facility_id,:nd_fr_date, :nd_to_date,
		           :nd_section_code, :nd_test_code,
		           :nd_variance, :nd_num_rslt, :nd_op2,
		           :nd_rcc1, :nd_rcc2, :nd_rcc3, :nd_rcc4,
                   :nd_sec_test, :nd_third_test, :nd_fourth_test,:nd_fifth_test,
                   :nd_src_type, :nd_src_code, :nd_num_rslt_to ,:nd_specimen_from, :nd_specimen_to
            FROM   SY_PROG_PARAM
	        // WHERE  UPPER(PGM_ID) = 'RLRMTRRP'
			WHERE  UPPER(PGM_ID) = 'RLRTRERP'
		      AND  SESSION_ID = TO_NUMBER(:nd_session_id)
		      AND  PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13\
 ,PARAM14 ,PARAM15 ,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 into :b0,:b1,:\
b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b\
19,:b20  from SY_PROG_PARAM where ((UPPER(PGM_ID)='RLRTRERP' and SESSION_ID=TO\
_NUMBER(:b21)) and PGM_DATE=:b22)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[3] = (unsigned int  )4;
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
   sqlstm.sqhstv[5] = (         void  *)&nd_variance;
   sqlstm.sqhstl[5] = (unsigned int  )8;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_num_rslt;
   sqlstm.sqhstl[6] = (unsigned int  )18;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_op2;
   sqlstm.sqhstl[7] = (unsigned int  )6;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_rcc1;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_rcc2;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_rcc3;
   sqlstm.sqhstl[10] = (unsigned int  )7;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_rcc4;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_sec_test;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_third_test;
   sqlstm.sqhstl[13] = (unsigned int  )13;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_fourth_test;
   sqlstm.sqhstl[14] = (unsigned int  )13;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_fifth_test;
   sqlstm.sqhstl[15] = (unsigned int  )13;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_src_type;
   sqlstm.sqhstl[16] = (unsigned int  )4;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_src_code;
   sqlstm.sqhstl[17] = (unsigned int  )9;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_num_rslt_to;
   sqlstm.sqhstl[18] = (unsigned int  )18;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_specimen_from;
   sqlstm.sqhstl[19] = (unsigned int  )23;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_specimen_to;
   sqlstm.sqhstl[20] = (unsigned int  )23;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[21] = (unsigned int  )18;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[22] = (unsigned int  )22;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
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
   nd_fr_date.arr[nd_fr_date.len] = '\0';
   nd_to_date.arr[nd_to_date.len] = '\0';
   nd_section_code.arr[nd_section_code.len] = '\0';
   nd_test_code.arr[nd_test_code.len] = '\0';
   nd_variance.arr[nd_variance.len] = '\0';
   nd_num_rslt.arr[nd_num_rslt.len] = '\0';
   nd_op2.arr[nd_op2.len] = '\0';
   nd_rcc1.arr[nd_rcc1.len] = '\0';
   nd_rcc2.arr[nd_rcc2.len] = '\0';
   nd_rcc3.arr[nd_rcc3.len] = '\0';
   nd_rcc4.arr[nd_rcc4.len] = '\0';
   nd_sec_test.arr[nd_sec_test.len] = '\0';
   nd_third_test.arr[nd_third_test.len] = '\0';
   nd_fourth_test.arr[nd_fourth_test.len] = '\0';
   nd_fifth_test.arr[nd_fifth_test.len] = '\0';
   nd_src_type.arr[nd_src_type.len] = '\0';
   nd_src_code.arr[nd_src_code.len] = '\0';
   nd_episode_type.arr[nd_episode_type.len] = '\0';
   nd_num_rslt_to.arr[nd_num_rslt_to.len] = '\0';
   nd_specimen_from.arr[nd_specimen_from.len] = '\0';
   nd_specimen_to.arr[nd_specimen_to.len] = '\0';
   

   nd_test_desc.arr[0] = '\0';
   nd_test_desc.len = 0;
   nd_test.arr[0] = '\0';
   nd_test.len = 0;
   strcpy(nd_test.arr,nd_test_code.arr);
   nd_test.len = nd_test_code.len;
   get_test_desc();
   strcpy(nd_test_desc.arr,nd_description.arr);
   nd_test_desc.len = strlen(nd_description.arr);
/*
sprintf(string_var,"numresult=%s,rcmnt1=%s,rcmnt2=%s,rcmnt3=%s,rcmnt4=%s,ndop1=%s,npop2=%s\n",nd_num_rslt.arr,nd_rcc1.arr,nd_rcc2.arr,nd_rcc3.arr,nd_rcc4.arr,nd_op1.arr,nd_op2.arr);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"sectest=%s,thrdtest=%s,frthtest=%s,fifthtest=%s,srctype=%s,srccd=%s,episdtype=%s\n",nd_sec_test.arr,nd_third_test.arr,nd_fourth_test.arr,nd_fifth_test.arr,nd_src_type.arr,nd_src_code.arr,nd_episode_type.arr);
disp_message(ERR_MESG,string_var);
*/

   if(strlen(nd_sec_test.arr))
   {
      nd_sec_test_desc.arr[0] = '\0';
      nd_sec_test_desc.len = 0;
      nd_test.arr[0] = '\0';
      nd_test.len = 0;
      strcpy(nd_test.arr,nd_sec_test.arr);
      nd_test.len = nd_sec_test.len;
      get_test_desc();
      strcpy(nd_sec_test_desc.arr,nd_description.arr);
      nd_sec_test_desc.len = strlen(nd_description.arr);
   }

   if(strlen(nd_third_test.arr))
   {
      nd_third_test_desc.arr[0] = '\0';
      nd_third_test_desc.len = 0;
      nd_test.arr[0] = '\0';
      nd_test.len = 0;
      strcpy(nd_test.arr,nd_third_test.arr);
      nd_test.len = nd_third_test.len;
      get_test_desc();
      strcpy(nd_third_test_desc.arr,nd_description.arr);
      nd_third_test_desc.len = strlen(nd_description.arr);
   }

   if(strlen(nd_fourth_test.arr))
   {
      nd_fourth_test_desc.arr[0] = '\0';
      nd_fourth_test_desc.len = 0;
      nd_test.arr[0] = '\0';
      nd_test.len = 0;
      strcpy(nd_test.arr,nd_fourth_test.arr);
      nd_test.len = nd_fourth_test.len;
      get_test_desc();
      strcpy(nd_fourth_test_desc.arr,nd_description.arr);
      nd_fourth_test_desc.len = strlen(nd_description.arr);
   }

   if(strlen(nd_fifth_test.arr))
   {
      nd_fifth_test_desc.arr[0] = '\0';
      nd_fifth_test_desc.len = 0;
      nd_test.arr[0] = '\0';
      nd_test.len = 0;
      strcpy(nd_test.arr,nd_fifth_test.arr);
      nd_test.len = nd_fifth_test.len;
      get_test_desc();
      strcpy(nd_fifth_test_desc.arr,nd_description.arr);
      nd_fifth_test_desc.len = strlen(nd_description.arr);
   }
/**************** 25.04.2003  for jordan scf 56
   if(strlen(nd_src_type.arr))
      get_source_desc();
************/

#ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" nd_fr_date = %s\n",nd_fr_date.arr);
   printf(" nd_to_date = %s\n",nd_to_date.arr);
   printf(" nd_section_code = %s\n",nd_section_code.arr);
   printf(" nd_test_code = %s\n",nd_test_code.arr);
   printf(" nd_variance = %s\n",nd_variance.arr);
   printf(" nd_num_rslt = %s\n",nd_num_rslt.arr);   
   printf(" nd_num_rslt_to = %s\n",nd_num_rslt_to.arr);
   printf(" nd_op2 = %s\n",nd_op2.arr);
   printf(" nd_rcc1 = %s\n",nd_rcc1.arr);
   printf(" nd_rcc2 = %s\n",nd_rcc2.arr);
   printf(" nd_rcc3 = %s\n",nd_rcc3.arr);
   printf(" nd_rcc4 = %s\n",nd_rcc4.arr);
   printf(" nd_sec_test = %s\n",nd_sec_test.arr);
   printf(" nd_third_test = %s\n",nd_third_test.arr);
   printf(" nd_fourth_test = %s\n",nd_fourth_test.arr);
   printf(" nd_fifth_test = %s\n",nd_fifth_test.arr);
#endif
  
  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	        //WHERE UPPER(PGM_ID) = 'RLRMTRRP'
			WHERE UPPER(PGM_ID) = 'RLRTRERP'
	        AND SESSION_ID = :nd_session_id
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLRTRER\
P' and SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )238;
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
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )261;
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

   /* EXEC SQL SELECT ACC_ENTITY_NAME,
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY')
	    INTO :d_acc_entity_name,
		     :d_user,
		     :d_sysdate
        FROM SY_ACC_ENTITY_lang_vw
		WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		AND language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY'\
) into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:b3 and la\
nguage_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )276;
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
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )311;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}

void dclr_request_header_cur()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE REQUEST_HEADER CURSOR FOR
              SELECT SPECIMEN_NO,PATIENT_ID,EPISODE_TYPE,SOURCE_CODE,SOURCE_TYPE,
              TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),
			  CATEGORY_CODE,CATEGORY_YEAR,CATEGORY_NUMBER,ORDERED_FACILITY_ID
              FROM RL_REQUEST_HEADER  

/o***** code commented for KN ENHANCEMENT ***********
			  WHERE SPECIMEN_NO BETWEEN :d_specimen_prefix||'00000000000'
                                     AND :d_specimen_prefix||'99999999999'
****************************************************************o/			

/o***commented on 05/01/2004
					WHERE SPECIMEN_NO BETWEEN TO_NUMBER(:nd_fr_specimen_no)
                                    AND TO_NUMBER(:nd_to_specimen_no)
*******o/

/o* Commented on 18/08/2004
				 WHERE SPECIMEN_NO BETWEEN NVL(:nd_specimen_from,TO_NUMBER(:nd_fr_specimen_no))
									   AND NVL(:nd_specimen_to,TO_NUMBER(:nd_to_specimen_no))
*o/
				 WHERE SPECIMEN_NO BETWEEN NVL(:nd_specimen_from,0)
									   AND NVL(:nd_specimen_to,TO_NUMBER(:nd_to_specimen_no))
				 AND SECTION_CODE = :nd_section_code
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND SPEC_REGD_DATE_TIME > to_date(:nd_fr_date,'DD/MM/YYYY')
                 AND SPEC_REGD_DATE_TIME < to_date(:nd_to_date,'DD/MM/YYYY') + 1
                 AND SOURCE_CODE = NVL(:nd_src_code,SOURCE_CODE)
			     AND SOURCE_TYPE = DECODE(NVL(:nd_src_type,SOURCE_TYPE),'C','C','W','W','R','E','E','E')
                 AND NVL(CANCELLED_YN,'N') != 'Y'; */ 


   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL OPEN REQUEST_HEADER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )326;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_specimen_from;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_specimen_to;
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
   sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
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
   sqlstm.sqhstv[5] = (         void  *)&nd_fr_date;
   sqlstm.sqhstl[5] = (unsigned int  )33;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[6] = (unsigned int  )33;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_src_code;
   sqlstm.sqhstl[7] = (unsigned int  )9;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_src_type;
   sqlstm.sqhstl[8] = (unsigned int  )4;
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



   return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )377;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_request_header_cur() occured....\n");
   proc_exit();
}

void dclr_test_result_cur()
{
    //EXEC SQL WHENEVER SQLERROR GOTO err_exit;
	 


 if(strcmp(nd_op2.arr,"OR")==0)
 
 {
 /*	EXEC SQL DECLARE TEST_RESULT CURSOR FOR 
            SELECT NUMERIC_RESULT,
            RESULT_COMMENT_DESC1, RESULT_COMMENT_DESC2, 
            RESULT_COMMENT_DESC3, RESULT_COMMENT_DESC4 
            FROM RL_TEST_RESULT 
            WHERE SPECIMEN_NO = :d_specimen_no 
	        AND OPERATING_FACILITY_ID = :nd_operating_facility_id 
            AND TEST_CODE =:nd_test_code
		    AND NVL(CANCELLED_YN,'N') != 'Y'
            AND (NUMERIC_RESULT IS NOT NULL AND ((TO_NUMBER(NUMERIC_RESULT)
                 < to_number(:nd_num_rslt) and TO_NUMBER(NUMERIC_RESULT)>=(to_number(:nd_num_rslt)-(to_number(:nd_num_rslt)*to_number(:nd_variance))/100))
                 or  (TO_NUMBER(NUMERIC_RESULT) >to_number(:nd_num_rslt_to)
            AND TO_NUMBER(NUMERIC_RESULT) <=TO_NUMBER(:nd_num_rslt_to)+TO_NUMBER(:nd_num_rslt_to)*to_number(:nd_variance)/100))
            OR 
            (((TO_NUMBER(NUMERIC_RESULT)
               < to_number(:nd_num_rslt) and TO_NUMBER(NUMERIC_RESULT)>=(to_number(:nd_num_rslt)-(to_number(:nd_num_rslt)*to_number(:nd_variance))/100))
               or  (TO_NUMBER(NUMERIC_RESULT) >to_number(:nd_num_rslt_to)
            AND TO_NUMBER(NUMERIC_RESULT) <=TO_NUMBER(:nd_num_rslt_to)+TO_NUMBER(:nd_num_rslt_to)*to_number(:nd_variance)/100))
            AND
	        DECODE(NVL(:nd_rcc1,'A'),'A','A',RESULT_COMMENT_CODE1) = NVL(:nd_rcc1,'A')
	        AND
            DECODE(NVL(:nd_rcc2,'B'),'B','B',RESULT_COMMENT_CODE2) = NVL(:nd_rcc2,'B')
	        AND
	        DECODE(NVL(:nd_rcc3,'C'),'C','C',RESULT_COMMENT_CODE3) = NVL(:nd_rcc3,'C')
            AND
	        DECODE(NVL(:nd_rcc4,'D'),'D','D',RESULT_COMMENT_CODE4) = NVL(:nd_rcc4,'D')))
	        ORDER BY TO_NUMBER(NUMERIC_RESULT);
 */
	/* EXEC SQL DECLARE TEST_RESULT CURSOR FOR  
	         SELECT NVL(NUMERIC_PREFIX, '+'), NUMERIC_RESULT,
             RESULT_COMMENT_DESC1, RESULT_COMMENT_DESC2, 
             RESULT_COMMENT_DESC3, RESULT_COMMENT_DESC4 
             FROM RL_TEST_RESULT 
             WHERE SPECIMEN_NO = :d_specimen_no 
	         AND OPERATING_FACILITY_ID = :nd_operating_facility_id
             AND TEST_CODE =:nd_test_code
		     AND NVL(CANCELLED_YN,'N') != 'Y'
             AND NUMERIC_RESULT IS NOT NULL
			 AND (
			     (DECODE(NUMERIC_PREFIX, '-', (-1*NUMERIC_RESULT), NUMERIC_RESULT) 
			        BETWEEN (TO_NUMBER(:nd_num_rslt) - (ABS(TO_NUMBER(:nd_num_rslt))*TO_NUMBER(:nd_variance)/100))
				    AND TO_NUMBER(:nd_num_rslt))
				 OR (DECODE(NUMERIC_PREFIX, '-',(-1*NUMERIC_RESULT), NUMERIC_RESULT)
				    BETWEEN TO_NUMBER(:nd_num_rslt_to)
				    AND TO_NUMBER(:nd_num_rslt_to) + (ABS(TO_NUMBER(:nd_num_rslt_to)) * (TO_NUMBER(:nd_variance)/100))
				 )
			 /o*
             AND ((TO_NUMBER(NUMERIC_RESULT)
                   < to_number(:nd_num_rslt) and TO_NUMBER(NUMERIC_RESULT)>=(to_number(:nd_num_rslt)-(to_number(:nd_num_rslt)*to_number(:nd_variance))/100))
                   or  (TO_NUMBER(NUMERIC_RESULT) >to_number(:nd_num_rslt_to)
             AND TO_NUMBER(NUMERIC_RESULT) <=TO_NUMBER(:nd_num_rslt_to)+TO_NUMBER(:nd_num_rslt_to)*to_number(:nd_variance)/100))
			 *o/
			 AND(  NUMERIC_RESULT IS NOT NULL OR
             DECODE(NVL(:nd_rcc1,'A'),'A','A',RESULT_COMMENT_CODE1) = NVL(:nd_rcc1,'A')
	         AND
             DECODE(NVL(:nd_rcc2,'B'),'B','B',RESULT_COMMENT_CODE2) = NVL(:nd_rcc2,'B')
	         AND
	         DECODE(NVL(:nd_rcc3,'C'),'C','C',RESULT_COMMENT_CODE3) = NVL(:nd_rcc3,'C')
             AND
	         DECODE(NVL(:nd_rcc4,'D'),'D','D',RESULT_COMMENT_CODE4) = NVL(:nd_rcc4,'D')))
	         ORDER BY TO_NUMBER(NUMERIC_RESULT); */ 


 }
 else
 {


	/* EXEC SQL DECLARE TEST_RESULT1 CURSOR FOR
	         SELECT NVL(NUMERIC_PREFIX, '+'), NUMERIC_RESULT,
             RESULT_COMMENT_DESC1, RESULT_COMMENT_DESC2, 
             RESULT_COMMENT_DESC3, RESULT_COMMENT_DESC4 
             FROM RL_TEST_RESULT 
             WHERE SPECIMEN_NO = :d_specimen_no 
	         AND OPERATING_FACILITY_ID = :nd_operating_facility_id 
             AND TEST_CODE =:nd_test_code
		     AND NVL(CANCELLED_YN,'N') != 'Y'
			 AND NUMERIC_RESULT IS NOT NULL
			 AND (
			     (DECODE(NUMERIC_PREFIX, '-', (-1*NUMERIC_RESULT), NUMERIC_RESULT) 
			        BETWEEN (TO_NUMBER(:nd_num_rslt) - (ABS(TO_NUMBER(:nd_num_rslt))*TO_NUMBER(:nd_variance)/100))
				    AND TO_NUMBER(:nd_num_rslt))
				 OR (DECODE(NUMERIC_PREFIX, '-',(-1*NUMERIC_RESULT), NUMERIC_RESULT)
				    BETWEEN TO_NUMBER(:nd_num_rslt_to)
				    AND TO_NUMBER(:nd_num_rslt_to) + (ABS(TO_NUMBER(:nd_num_rslt_to)) * (TO_NUMBER(:nd_variance)/100))
				 )
			 /o*
             AND (NUMERIC_RESULT IS NOT NULL AND ((TO_NUMBER(NUMERIC_RESULT)
                  < :nd_num_rslt and TO_NUMBER(NUMERIC_RESULT)>=(:nd_num_rslt-(:nd_num_rslt*to_number(:nd_variance))/100))
                  or  (TO_NUMBER(NUMERIC_RESULT) >:nd_num_rslt_to
             AND TO_NUMBER(NUMERIC_RESULT) <=:nd_num_rslt_to+:nd_num_rslt_to*to_number(:nd_variance)/100))
			 *o/
			 AND
             ( DECODE(NVL(:nd_rcc1,'A'),'A','A',RESULT_COMMENT_CODE1) = NVL(:nd_rcc1,'A')
	         AND
             DECODE(NVL(:nd_rcc2,'B'),'B','B',RESULT_COMMENT_CODE2)= NVL(:nd_rcc2,'B')
	         AND
	         DECODE(NVL(:nd_rcc3,'C'),'C','C',RESULT_COMMENT_CODE3) = NVL(:nd_rcc3,'C')
             AND
	         DECODE(NVL(:nd_rcc4,'D'),'D','D',RESULT_COMMENT_CODE4) = NVL(:nd_rcc4,'D')))
	         ORDER BY TO_NUMBER(NUMERIC_RESULT); */ 


 }
    return;

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )392;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at dclr_test_result_cur() occured....\n");
    proc_exit(0);
	
}

/* prepares for the new page */
void prepare_new_page()
{
   fprintf(fp,"\f");
   line_no = 1;
//   page_no++;
   print_page_header();
   print_col_heading();
}

/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT DECODE(:language_id,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG),
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   SEX, 
		   NATIONALITY_CODE,
		   TOWN_CODE,

		   /o* Commented since no longer used
		    ** RES_WILAYAT_NAME, 
		    ** RES_TEL_NUM,
		    ** CONTACT_TEL_NUM,
			*o/
           
		   NVL(actual_dob_yn, 'N')
	      INTO :d_short_name,
		   :d_date_of_birth,
		   :d_sex,
		   :d_nation,
		   :d_town_name,
		   
		   /o* Commented since no longer used
		    **:d_res_wilayat_name,
		    **:d_res_tel_num,
		    **:d_other_contact_num,
		    *o/
		   
		   :d_actual_dob_yn
         FROM RL_PATIENT_MAST
	     WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG\
) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX ,NATIONALITY_CODE ,TOWN_CODE ,NVL(\
actual_dob_yn,'N') into :b1,:b2,:b3,:b4,:b5,:b6  from RL_PATIENT_MAST where PA\
TIENT_ID=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )407;
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
   sqlstm.sqhstv[1] = (         void  *)&d_short_name;
   sqlstm.sqhstl[1] = (unsigned int  )242;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[2] = (unsigned int  )13;
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
   sqlstm.sqhstv[4] = (         void  *)&d_nation;
   sqlstm.sqhstl[4] = (unsigned int  )10;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_town_name;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_actual_dob_yn;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[7] = (unsigned int  )33;
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


		 /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

  d_short_name.arr[d_short_name.len]     = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]                       = '\0';
  d_sex.arr[d_sex.len] = '\0';
  d_nation.arr[d_nation.len] = '\0';
  d_town_name.arr[d_town_name.len] = '\0';

  /** Commented since no longer used
   ** d_res_wilayat_name.arr[d_res_wilayat_name.len] = '\0';
   ** d_res_tel_num.arr[d_res_tel_num.len] = '\0';
   ** d_other_contact_num.arr[d_other_contact_num.len] = '\0';
   **/
  
  d_actual_dob_yn.arr[d_actual_dob_yn.len] = '\0';


  #ifdef DEBUG
   printf("d_short_name= %s\n", d_short_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )454;
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

   /* EXEC SQL SELECT DECODE(:language_id,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG),
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   SEX, 
		   NATIONALITY_CODE,
		   /o* Marked since column not present in EHDV database
		    ** RES_TOWN_CODE,  
		    ** RES_AREA_CODE,
		    ** RES_TEL_NUM,
		    ** OTHER_CONTACT_NUM,
		    *o/
           NVL(actual_dob_yn, 'N')
	      INTO :d_short_name,
		   :d_date_of_birth,
		   :d_sex,
		   :d_nation,
		   /o*
		    ** :d_town_name,
		    ** :d_res_wilayat_name,
		    ** :d_res_tel_num,
		    ** :d_other_contact_num,
			*o/
		   :d_actual_dob_yn
          FROM MP_PATIENT_MAST 
	     WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG\
) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX ,NATIONALITY_CODE ,NVL(actual_dob_\
yn,'N') into :b1,:b2,:b3,:b4,:b5  from MP_PATIENT_MAST where PATIENT_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )469;
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
   sqlstm.sqhstv[1] = (         void  *)&d_short_name;
   sqlstm.sqhstl[1] = (unsigned int  )242;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[2] = (unsigned int  )13;
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
   sqlstm.sqhstv[4] = (         void  *)&d_nation;
   sqlstm.sqhstl[4] = (unsigned int  )10;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_actual_dob_yn;
   sqlstm.sqhstl[5] = (unsigned int  )4;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
    return 0;
  d_short_name.arr[d_short_name.len]     = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]                       = '\0';
  d_sex.arr[d_sex.len] = '\0';
  d_nation.arr[d_nation.len] = '\0';
  
  d_town_name.arr[d_town_name.len] = '\0';
  d_res_wilayat_name.arr[d_res_wilayat_name.len] = '\0';
  d_res_tel_num.arr[d_res_tel_num.len] = '\0';
  d_other_contact_num.arr[d_other_contact_num.len] = '\0';
  
  d_actual_dob_yn.arr[d_actual_dob_yn.len] = '\0';

  #ifdef DEBUG
   printf("d_short_name= %s\n", d_short_name.arr);
  #endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )512;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_patient_dtl() occured....\n");
   proc_exit();
}


/*------------------------------------------------------------*/
 patient_age()
 {

		 float  lone = 0;
		 float  num1 = 0, yrs = 0, 
				tmp_mths = 0, 
				tmp_days = 0;

		 char st_r[50];

	tday.arr[0] = '\0';
	tday.len = 0;

	mths.arr[0]  = '\0';
	mths.len  = 0;

	
	/* EXEC SQL SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') INTO :tday
            FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )527;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&tday;
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
		TO_DATE(:l_spec_date,'DD/MM/YYYY'), 
		TO_DATE(:d_date_of_birth, 'DD/MM/YYYY')))
			INTO :mt FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ABS(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),TO_DA\
TE(:b1,'DD/MM/YYYY'))) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )546;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_spec_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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

        	tday.arr[tday.len] = '\0';
							
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

				/* EXEC SQL SELECT TO_CHAR(ROUND((TO_DATE(:l_spec_date,'DD/MM/YYYY') -
					TO_DATE(:d_date_of_birth, 'DD/MM/YYYY')),3))
					INTO :t_days FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ROUND((TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:\
b1,'DD/MM/YYYY')),3)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )573;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_spec_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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



			t_days.arr[t_days.len]		= '\0';

	
				tmp_days = atoi(strtok(t_days.arr,"."));
			}
			else
				tmp_days = (atof(mths.arr) - atoi(mths1.arr)) * 31 ;

			sprintf(st_r, "%f", yrs);
			strcpy(t_age.arr, strtok(st_r, "."));
			strcat(t_age.arr, "Y");
			sprintf(st_r, " %f", tmp_mths);
			strcat(t_age.arr, strtok(st_r, "."));
			strcat(t_age.arr, "M");
			sprintf(st_r, " %f", tmp_days);
			strcat(t_age.arr, strtok(st_r, "."));
			strcat(t_age.arr, "D ");

				
 }
/*------------------------------------------------------------*/

/* to print the last line of the report */
void end_report()
{
  
  //fprintf(fp,"Total Requests      :   %d",d_specimen_count);
  fprintf(fp,"%14.14s      :   %d",local_legend[23],d_specimen_count);

  fprintf(fp,"\n\n");  
  //fprintf(fp,"Total Result        :   %6.3f",d_result_total);
  //fprintf(fp,"\n\n");  
  
  //fprintf(fp,"Mean of all Results :   %6.3f",d_result_mean);
  fprintf(fp,"%19.19s :   %6.3f",local_legend[24],d_result_mean);

  fprintf(fp,"\n\n");  
  
  //fprintf(fp,"                      ******** End of Report *********");
  fprintf(fp,"                      ******** %13.13s *********",local_legend[25]);

  fprintf(fp,"\n");
  fprintf(fp,"\f");
}

gen_file_name()
{
     /*strcpy(nd_file_name,"");
     EXEC SQL SELECT DECODE(PRINT_FILE_NO,NULL,'0',TO_CHAR(PRINT_FILE_NO)) 
	      INTO   :nd_file_no
	      FROM   RL_PARAM;

      if (OERROR)
         err_mesg("Fetch failed on table RL_PARAM",0,"");
      
     nd_file_no.arr[nd_file_no.len] = '\0';
     sprintf(nd_file_name,"rlrmtrrp_%s.lis",nd_file_no.arr);*/

	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);

	 //strcat(nd_file_name.arr,"rlrmtrrp.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);
	 if ((fp = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }

}
/********** commented since this is not getting calling anywhere
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
*****************/
void do_report()
{
  int fetch_request_header();
  int still_rec_left;
  void print_rep_header();
  void printt_page_header() ;
  page_no = 1;
  line_no = 1;
  
  still_rec_left = fetch_request_header();

  print_rep_header();
  print_page_header();
  print_col_heading();

  while(still_rec_left)
  {
//    if(line_no + 6 >= MAX_LINES)  16.10.2002
    if(line_no + 8 >= MAX_LINES)
       prepare_new_page();
    
    print_detl_rec();

    still_rec_left = fetch_request_header();
  }
  close_request_header();

  end_report();
}

close_request_header()
{
	/* EXEC SQL CLOSE REQUEST_HEADER; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )600;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

int fetch_request_header()
{

void get_location();

  d_category_code.arr[0]      = '\0';
  d_category_year.arr[0]      = '\0';
  d_category_num.arr[0]       = '\0';
  d_category_code.len      = 0;
  d_category_year.len      = 0;
  d_category_num.len       = 0;
  rl_ordered_facility_id.arr[0]		= '\0';
  rl_ordered_facility_id.len		=  0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH REQUEST_HEADER INTO
                 :d_specimen_no, :d_patient_id, :d_episode_type,
		 :d_source_code, :d_src_type, :d_spec_date, :l_spec_date, :d_category_code,
		 :d_category_year, :d_category_num,:rl_ordered_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )615;
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
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_source_code;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_src_type;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_spec_date;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_spec_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_category_code;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_category_year;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_category_num;
  sqlstm.sqhstl[9] = (unsigned int  )18;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&rl_ordered_facility_id;
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


  if (NODATAFOUND)
    return 0;

  d_specimen_no.arr[d_specimen_no.len]      = '\0';
  d_patient_id.arr[d_patient_id.len]        = '\0';
  d_episode_type.arr[d_episode_type.len]    = '\0';
  d_source_code.arr[d_source_code.len]      = '\0';
  d_src_type.arr[d_src_type.len]            = '\0';   // 25.04.2003
  d_spec_date.arr[d_spec_date.len]          = '\0';
  l_spec_date.arr[l_spec_date.len]          = '\0';
  d_category_code.arr[d_category_code.len]  = '\0';
  d_category_year.arr[d_category_year.len]  = '\0';
  d_category_num.arr[d_category_num.len]    = '\0';
  rl_ordered_facility_id.arr[rl_ordered_facility_id.len]	= '\0';


#ifdef DEBUG
 printf("d_specimen_no = %s\n",d_specimen_no.arr);
 printf("d_patient_id = %s\n",d_patient_id.arr);
 printf("d_episode_type = %s\n",d_episode_type.arr);
 printf("d_source_code = %s\n",d_source_code.arr);
 printf("d_src_type    = %s\n",d_src_type.arr);
 printf("d_spec_date = %s\n",d_spec_date.arr);
#endif

get_location();

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )674;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_header() occured....\n");
   proc_exit();
}


void get_location()
{
  d_location.arr[0] = '\0';
  d_location.len    =  0;

   /* EXEC SQL SELECT location
	    INTO :d_location
        FROM rl_patient_mast
		WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select location into :b0  from rl_patient_mast where PATIE\
NT_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )689;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_location;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )33;
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



////// 01.07.2003		AND OPERATING_FACILITY_ID = :nd_operating_facility_id;


  d_location.arr[d_location.len] = '\0';

  return;
}

close_curs()
{
if(strcmp(nd_op2.arr,"OR")==0)
	/* EXEC SQL CLOSE TEST_RESULT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )712;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


else
   /* EXEC SQL CLOSE TEST_RESULT1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )727;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

int get_specimen_found()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


if(strcmp(nd_op2.arr,"OR")==0)
 {
  /* EXEC SQL OPEN TEST_RESULT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0014;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )742;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_test_code;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_num_rslt;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_num_rslt;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_variance;
  sqlstm.sqhstl[5] = (unsigned int  )8;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_num_rslt;
  sqlstm.sqhstl[6] = (unsigned int  )18;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_num_rslt_to;
  sqlstm.sqhstl[7] = (unsigned int  )18;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_num_rslt_to;
  sqlstm.sqhstl[8] = (unsigned int  )18;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_num_rslt_to;
  sqlstm.sqhstl[9] = (unsigned int  )18;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_variance;
  sqlstm.sqhstl[10] = (unsigned int  )8;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_rcc1;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_rcc1;
  sqlstm.sqhstl[12] = (unsigned int  )7;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_rcc2;
  sqlstm.sqhstl[13] = (unsigned int  )7;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_rcc2;
  sqlstm.sqhstl[14] = (unsigned int  )7;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_rcc3;
  sqlstm.sqhstl[15] = (unsigned int  )7;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_rcc3;
  sqlstm.sqhstl[16] = (unsigned int  )7;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_rcc4;
  sqlstm.sqhstl[17] = (unsigned int  )7;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_rcc4;
  sqlstm.sqhstl[18] = (unsigned int  )7;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
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


  d_numeric_prefix.arr[0] = '\0';
  d_numeric_result.arr[0] = '\0';
  d_rc_1.arr[0] = '\0';
  d_rc_2.arr[0] = '\0';
  d_rc_3.arr[0] = '\0';
  d_rc_4.arr[0] = '\0';

  d_numeric_prefix.len = 0;
  d_numeric_result.len = 0;
  d_rc_1.len = 0;
  d_rc_2.len = 0;
  d_rc_3.len = 0;
  d_rc_4.len = 0;  


   /* EXEC SQL FETCH TEST_RESULT 
	    INTO :d_numeric_prefix,:d_numeric_result,:d_rc_1, :d_rc_2,:d_rc_3,:d_rc_4; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )833;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_numeric_prefix;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_numeric_result;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_1;
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_rc_2;
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_rc_3;
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_rc_4;
   sqlstm.sqhstl[5] = (unsigned int  )43;
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


		if (NODATAFOUND)
    return 0;

  d_numeric_prefix.arr[d_numeric_prefix.len] = '\0';
  d_numeric_result.arr[d_numeric_result.len] = '\0';
  d_rc_1.arr[d_rc_1.len] = '\0';
  d_rc_2.arr[d_rc_2.len] = '\0';
  d_rc_3.arr[d_rc_3.len] = '\0';
  d_rc_4.arr[d_rc_4.len] = '\0';



  //EXEC SQL CLOSE TEST_RESULT;

  return 1;

  

 }
 
 else
 {
 
  /* EXEC SQL OPEN TEST_RESULT1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0015;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )872;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_test_code;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_num_rslt;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_num_rslt;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_variance;
  sqlstm.sqhstl[5] = (unsigned int  )8;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_num_rslt;
  sqlstm.sqhstl[6] = (unsigned int  )18;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_num_rslt_to;
  sqlstm.sqhstl[7] = (unsigned int  )18;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_num_rslt_to;
  sqlstm.sqhstl[8] = (unsigned int  )18;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_num_rslt_to;
  sqlstm.sqhstl[9] = (unsigned int  )18;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_variance;
  sqlstm.sqhstl[10] = (unsigned int  )8;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_rcc1;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_rcc1;
  sqlstm.sqhstl[12] = (unsigned int  )7;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_rcc2;
  sqlstm.sqhstl[13] = (unsigned int  )7;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_rcc2;
  sqlstm.sqhstl[14] = (unsigned int  )7;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_rcc3;
  sqlstm.sqhstl[15] = (unsigned int  )7;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_rcc3;
  sqlstm.sqhstl[16] = (unsigned int  )7;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_rcc4;
  sqlstm.sqhstl[17] = (unsigned int  )7;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_rcc4;
  sqlstm.sqhstl[18] = (unsigned int  )7;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
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


  d_numeric_prefix.arr[0] = '\0';
  d_numeric_result.arr[0] = '\0';
  d_rc_1.arr[0] = '\0';
  d_rc_2.arr[0] = '\0';
  d_rc_3.arr[0] = '\0';
  d_rc_4.arr[0] = '\0';

  d_numeric_prefix.len = 0;
  d_numeric_result.len = 0;
  d_rc_1.len = 0;
  d_rc_2.len = 0;
  d_rc_3.len = 0;
  d_rc_4.len = 0;  


   /* EXEC SQL FETCH TEST_RESULT1 
	    INTO :d_numeric_prefix,:d_numeric_result,:d_rc_1, :d_rc_2,:d_rc_3,:d_rc_4; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )963;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_numeric_prefix;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_numeric_result;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_rc_1;
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_rc_2;
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_rc_3;
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_rc_4;
   sqlstm.sqhstl[5] = (unsigned int  )43;
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


		if (NODATAFOUND)
    return 0;

  d_numeric_prefix.arr[d_numeric_prefix.len] = '\0';
  d_numeric_result.arr[d_numeric_result.len] = '\0';
  d_rc_1.arr[d_rc_1.len] = '\0';
  d_rc_2.arr[d_rc_2.len] = '\0';
  d_rc_3.arr[d_rc_3.len] = '\0';
  d_rc_4.arr[d_rc_4.len] = '\0';



  //EXEC SQL CLOSE TEST_RESULT;

  return 1;

   }

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   
   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1002;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_specimen_found() occured....\n");
   proc_exit();
}

void print_detl_rec()
{
    int  get_patient_dtl(); 
 	void get_referral_patient_dtl();
    int  get_specimen_found();
    int i = 0 ;
	int spec_found;
	
	


	
    spec_found = get_specimen_found();

	close_curs();
	
    if(spec_found)
    {
	  
	   d_specimen_count++;
	   if (strcmp(d_numeric_prefix.arr , "-")  == 0)
	   {
	      d_result_total = d_result_total + (-1)* (atof(d_numeric_result.arr));
	   }
	   else
	   {
	      d_result_total = d_result_total + atof(d_numeric_result.arr);
	   }
	  

      if(strcmp(d_episode_type.arr,"I") == 0 || strcmp(d_episode_type.arr,"O") == 0 || strcmp(d_episode_type.arr,"H")==0)
      {
         i = get_patient_dtl();
      } 
	  

      else
         if(strcmp(d_episode_type.arr,"R") == 0)
            get_referral_patient_dtl();

	 print_record();
//     fprintf(fp,"\n");	  16.10.2002 commented

	d_result_mean = d_result_total/d_specimen_count;/**Added on 05/04/2004**/
	
    }

	//d_result_mean = d_result_total/d_specimen_count;/**Commented on 05/04/2004 since if specimen_count was 0 then junk was gettign displayed**/
	
	

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1017;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}

void print_record()
{
  int get_secondary_test_result();
  void print_secondary_test_result();
  int sec_test_found;
  char l_age_legend[5];


    patient_age();


	if (strcmp(d_actual_dob_yn.arr, "Y") == 0)
		strcpy(l_age_legend, "");
	else
		strcpy(l_age_legend, "*");

/*****Added on 06/04/2004 to get source description***************/

  nd_source_code.arr[0]		= '\0';
  nd_source_code.len		= 0;
  strcpy(nd_source_code.arr, d_source_code.arr);
  nd_source_code.len = strlen(nd_source_code.arr);
  get_source_desc(); //  added 25.04.2003 for jordan scf 56
  nd_source_code.arr[0]		= '\0';
  nd_source_code.len		= 0;

/*********upto here********************/


  l_delimeter = ' ';
  rl_split_text(d_short_name.arr, l_delimeter, l_len, d_patient_name_1.arr,
			    d_patient_name_2.arr, d_patient_name_3.arr, d_patient_name_4.arr);

  fprintf(fp,"%-21.21s%-31.31s%-1.1s%-11.11s %-4.4s%-11.11s\n",
	      d_patient_id.arr,d_patient_name_1.arr,l_age_legend,t_age.arr,d_sex.arr,d_source_code.arr);
  line_no++;
  fprintf(fp,"%-21.21s%-31.31s%-15.15s\n"," ",d_patient_name_2.arr,nd_src_desc.arr);
  line_no++;

   /*fprintf(fp,"%-20.20s %-17.17s ",
	      d_specimen_no.arr, d_spec_date.arr);*/
   /* EXEC SQL EXECUTE
   DECLARE
		t_date   date;
   BEGIN
		//------Commented aginst leap year date problem in thai
		//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_spec_date,'DD/MM/YYYY'), :language_id , t_date);
		//:d_spec_date1 := to_char(t_date,'DD/MM/YYYY');
		//------Added aginst leap year date problem in thai
		:d_spec_date1 :=sm_convert_date_2t(to_date(:d_spec_date,'DD/MM/YYYY '),:language_id);
   END;
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN :d_spec_date1 := sm_convert_da\
te_2t ( to_date ( :d_spec_date , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1032;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_spec_date1;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_spec_date;
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



   fprintf(fp,"%-20.20s %-17.17s ",
	      d_specimen_no.arr, d_spec_date1.arr);

   if (strlen(d_category_num.arr))  
   {
	fprintf(fp,"%5.5s/%-4.4s/%-16.16s%-10.10s",
				d_category_code.arr,d_category_year.arr,
				d_category_num.arr,d_location.arr);
   }
   else
   {
    fprintf(fp,"%-25.25s%-10.10s"," ",d_location.arr); 
   }


    fprintf(fp,"\n");	  
	line_no++;

// 16.10.2002 modified as per KN requirement with approval of Mr.Cyrus.

   fprintf(fp,"--------------------------------------------------------------------------------\n");
	line_no++;

    fprintf(fp,"%-40.40s",nd_test_desc.arr);

    if(strlen(d_numeric_result.arr))
	{
   	 if (strcmp(d_numeric_prefix.arr, "-") != 0)
	 {	
		strcpy(d_numeric_prefix.arr, " ");
		d_numeric_prefix.len = strlen(d_numeric_prefix.arr);
	 }
	 fprintf(fp,"%1s%-6.6s  %-11.11s\n",d_numeric_prefix.arr,d_numeric_result.arr, nd_test_units_desc.arr);
     line_no++;
	 if(strlen(d_rc_1.arr))
	 {
       fprintf(fp,"%-40.40s%-40.40s\n"," ",d_rc_1.arr);
       line_no++;
     }
	}
	else
    {
	 if(strlen(d_rc_1.arr))
	 {
      fprintf(fp,"%-40.40s\n",d_rc_1.arr);
      line_no++;
     } 
	}
    if(strlen(d_rc_2.arr))
    {
	 fprintf(fp,"%-40.40s%-40.40s\n"," ",d_rc_2.arr);
	 line_no++;
    }
    if(strlen(d_rc_3.arr))
    {
     fprintf(fp,"%-40.40s%-40.40s\n"," ",d_rc_3.arr);
	 line_no++;
    }
    if(strlen(d_rc_4.arr))
    {
     fprintf(fp,"%-40.40s%-40.40s\n"," ",d_rc_4.arr);
	 line_no++;
    }
  
   if(strlen(nd_sec_test.arr))
   {
      nd_description.len = 0;
      nd_description.arr[0] = '\0';
      strcpy(nd_description.arr,nd_sec_test_desc.arr);
      nd_description.len = strlen(nd_sec_test_desc.arr);
      nd_test.arr[0] = '\0';
      nd_test.len = 0;
      strcpy(nd_test.arr,nd_sec_test.arr);
      nd_test.len = nd_sec_test.len;
      sec_test_found = 0;
      sec_test_found = get_secondary_test_result();
      if((line_no + 6) >= MAX_LINES)
         prepare_new_page();
      if(sec_test_found)
  	     print_secondary_test_result(); 
   }
   if(strlen(nd_third_test.arr))
   {
      nd_description.len = 0;
      nd_description.arr[0] = '\0';
      strcpy(nd_description.arr,nd_third_test_desc.arr);
      nd_description.len = strlen(nd_third_test_desc.arr);
      nd_test.arr[0] = '\0';
      nd_test.len = 0;
      strcpy(nd_test.arr,nd_third_test.arr);
      nd_test.len = nd_third_test.len;
      sec_test_found = 0;
      if((line_no + 6) >= MAX_LINES)
         prepare_new_page();
      sec_test_found = get_secondary_test_result();
      if(sec_test_found)
	 print_secondary_test_result(); 
   }
   if(strlen(nd_fourth_test.arr))
   {
      nd_description.len = 0;
      nd_description.arr[0] = '\0';
      strcpy(nd_description.arr,nd_fourth_test_desc.arr);
      nd_description.len = strlen(nd_fourth_test_desc.arr);
      nd_test.arr[0] = '\0';
      nd_test.len = 0;
      strcpy(nd_test.arr,nd_fourth_test.arr);
      nd_test.len = nd_fourth_test.len;
      sec_test_found = 0;
      if((line_no + 6) >= MAX_LINES)
         prepare_new_page();
      sec_test_found = get_secondary_test_result();
      if(sec_test_found)
	 print_secondary_test_result(); 
   }
   if(strlen(nd_fifth_test.arr))
   {
      nd_description.len = 0;
      nd_description.arr[0] = '\0';
      strcpy(nd_description.arr,nd_fifth_test_desc.arr);
      nd_description.len = strlen(nd_fifth_test_desc.arr);
      nd_test.arr[0] = '\0';
      nd_test.len = 0;
      strcpy(nd_test.arr,nd_fifth_test.arr);
      nd_test.len = nd_fifth_test.len;
      sec_test_found = 0;
      if((line_no + 6) >= MAX_LINES)
         prepare_new_page();
      sec_test_found = get_secondary_test_result();
      if(sec_test_found)
	 print_secondary_test_result(); 
   }
   fprintf(fp,"________________________________________________________________________________\n");
   line_no++;

}

void print_secondary_test_result()
{
   int pflag = 0;

   if(strlen(s_numeric_result.arr) || strlen(s_rc_1.arr) ||
      strlen(s_rc_2.arr) || strlen(s_rc_3.arr) || strlen(s_rc_4.arr))
   {
      fprintf(fp,"%-40.40s",nd_description.arr);
   }

   if(strlen(s_numeric_result.arr))
   {
     fprintf(fp,"%-6.6s  %-11.11s\n",s_numeric_result.arr,nd_test_units_desc.arr);
     line_no++;
     if(strlen(s_rc_1.arr))
	 {	 
      fprintf(fp,"%-40.40s%-40.40s\n"," ",s_rc_1.arr);
      line_no++;
	 }
     pflag = 1;
   }
   else
   {
    if(strlen(s_rc_1.arr))
    {
      fprintf(fp,"%-40.40s\n",s_rc_1.arr);
      line_no++;
      pflag = 1;
    }
   }
   if(strlen(s_rc_2.arr))
   {
      fprintf(fp,"%-40.40s%-40.40s\n"," ",s_rc_2.arr);
      line_no++;
      pflag = 1;
   }
   if(strlen(s_rc_3.arr))
   {
      fprintf(fp,"%-40.40s%-40.40s\n"," ",s_rc_3.arr);
      line_no++;
      pflag = 1;
   }
   if(strlen(s_rc_4.arr))
   {
      fprintf(fp,"%-40.40s%-40.40s\n"," ",s_rc_4.arr);
      line_no++;
      pflag = 1;
   }
   /*
     if(pflag)
     {
      fprintf(fp,"\n");
      line_no++;
     }
   */ 
}

int get_secondary_test_result()
{
   s_numeric_result.arr[0] = '\0';
   s_rc_1.arr[0] = '\0';
   s_rc_2.arr[0] = '\0';
   s_rc_3.arr[0] = '\0';
   s_rc_4.arr[0] = '\0';

   s_numeric_result.len = 0;
   s_rc_1.len = 0;
   s_rc_2.len = 0;
   s_rc_3.len = 0;
   s_rc_4.len = 0;
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT NUMERIC_RESULT,
		   RESULT_COMMENT_DESC1,RESULT_COMMENT_DESC2,
		   RESULT_COMMENT_DESC3,RESULT_COMMENT_DESC4
              INTO :s_numeric_result,
		   :s_rc_1,:s_rc_2,:s_rc_3,:s_rc_4
             FROM RL_TEST_RESULT
	     WHERE SPECIMEN_NO = :d_specimen_no
		  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND TEST_CODE = :nd_test
		  AND PATIENT_ID = :d_patient_id
		   AND NVL(CANCELLED_YN,'N') != 'Y'; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NUMERIC_RESULT ,RESULT_COMMENT_DESC1 ,RESULT_COMMEN\
T_DESC2 ,RESULT_COMMENT_DESC3 ,RESULT_COMMENT_DESC4 into :b0,:b1,:b2,:b3,:b4  \
from RL_TEST_RESULT where ((((SPECIMEN_NO=:b5 and OPERATING_FACILITY_ID=:b6) a\
nd TEST_CODE=:b7) and PATIENT_ID=:b8) and NVL(CANCELLED_YN,'N')<>'Y')";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1059;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&s_numeric_result;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&s_rc_1;
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&s_rc_2;
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&s_rc_3;
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&s_rc_4;
   sqlstm.sqhstl[4] = (unsigned int  )43;
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
   sqlstm.sqhstv[7] = (         void  *)&nd_test;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[8] = (unsigned int  )33;
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


		   	       
   if(NODATAFOUND)
      return 0;

   s_numeric_result.arr[s_numeric_result.len] = '\0';
   s_rc_1.arr[s_rc_1.len] = '\0';
   s_rc_2.arr[s_rc_2.len] = '\0';
   s_rc_3.arr[s_rc_3.len] = '\0';
   s_rc_4.arr[s_rc_4.len] = '\0';
   return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1110;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_secondary_test_result() occured....\n");
   proc_exit();
}

void print_page_header()
{
   //page_no++;
   printt_page_header() ;
   
   //fprintf(fp,"TEST CODE           : %-44s\n",nd_test_desc.arr);
   fprintf(fp,"%9.9s           : %-44s\n", local_legend[13], nd_test_desc.arr);

   line_no += 4;
}

void print_col_heading()
{
   fprintf(fp,"--------------------------------------------------------------------------------\n");
   
   //fprintf(fp, "PATIENT ID          PATIENT'S NAME                  AGE          SEX SRC\n");
   fprintf(fp,"%10.10s          %12.12s                  %3.3s          %7.7s\n", local_legend[14], local_legend[15], local_legend[16], local_legend[17]);

   //fprintf(fp, "                                                  DESCRIPTION\n");
   //fprintf(fp, "SPECIMEN NUMBER     SPEC DATE/TIME    CATEGORY NUMBER           LOCATION\n");

   fprintf(fp, "                                                  %11.11s\n",local_legend[18]);
   fprintf(fp,"%15.15s     %14.14s    %15.15s          %8.8s\n",local_legend[19], local_legend[20], local_legend[21], local_legend[22]);

   fprintf(fp,"--------------------------------------------------------------------------------\n");
   line_no += 3;
}
get_test_desc()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
 

  nd_description.arr[0] = '\0';
  nd_description.len = 0;
  /* EXEC SQL SELECT LONG_DESC,TEST_UNITS INTO :nd_description,:nd_test_units
	     FROM RL_TEST_CODE_lang_vw
            WHERE 
/o* Commented on 18/08/2004 since Test Code is Unique across the section
			SECTION_CODE = :nd_section_code
	        AND 
*o/
		  TEST_CODE = :nd_test
		  AND language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LONG_DESC ,TEST_UNITS into :b0,:b1  from RL_TEST_COD\
E_lang_vw where (TEST_CODE=:b2 and language_id=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1125;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_description;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_test_units;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_test;
  sqlstm.sqhstl[2] = (unsigned int  )13;
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



  nd_description.arr[nd_description.len] = '\0';
  nd_test_units.arr[nd_test_units.len] = '\0';

  get_test_units_desc_from_sy_uom(); ///// 19.02.2006

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1156;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_test_desc() occured....\n");
   proc_exit();
}


get_source_desc()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  nd_src_desc.arr[0] = '\0';
  nd_src_desc.len = 0;

//sprintf(string_var,"1=%s\n",nd_src_type.arr);
//disp_message(ERR_MESG,string_var);


  switch(d_src_type.arr[0])
  //switch(nd_src_type.arr[0])/**Added and then commented on 05/04/2004**/
  {
    case 'W' :
              /*EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM IP_WARD
                        WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
						--AND WARD_CODE = :d_source_code;
						AND WARD_CODE = :nd_source_code;*/
			  /* EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM IP_NURSING_UNIT_LANG_VW
                        WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
						--AND WARD_CODE = :d_source_code;
						AND NURSING_UNIT_CODE = :nd_source_code
						AND language_id = :language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 23;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SHORT_DESC into :b0  from IP_NURSING_UNIT_LANG_VW\
 where ((FACILITY_ID=nvl(:b1,:b2) and NURSING_UNIT_CODE=:b3) and language_id=:\
b4)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1171;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_src_desc;
     sqlstm.sqhstl[0] = (unsigned int  )63;
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
     sqlstm.sqhstv[3] = (         void  *)&nd_source_code;
     sqlstm.sqhstl[3] = (unsigned int  )14;
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


              break;
    case 'O' :
              /* EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM OP_CLINIC_lang_vw
                        WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
						--AND CLINIC_CODE = :d_source_code;
						AND CLINIC_CODE = :nd_source_code
						AND language_id = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 23;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from OP_CLINIC_lang\
_vw where ((FACILITY_ID=nvl(:b1,:b2) and CLINIC_CODE=:b3) and language_id=:b4)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )1206;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&nd_src_desc;
              sqlstm.sqhstl[0] = (unsigned int  )63;
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
              sqlstm.sqhstv[3] = (         void  *)&nd_source_code;
              sqlstm.sqhstl[3] = (unsigned int  )14;
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


              break;
    case 'R' :
              /* EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM RL_REFERRAL_lang_vw
                        --WHERE REFERRAL_CODE = :d_source_code;
						WHERE REFERRAL_CODE = :nd_source_code
						AND language_id = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 23;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from RL_REFERRAL_la\
ng_vw where (REFERRAL_CODE=:b1 and language_id=:b2)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )1241;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&nd_src_desc;
              sqlstm.sqhstl[0] = (unsigned int  )63;
              sqlstm.sqhsts[0] = (         int  )0;
              sqlstm.sqindv[0] = (         void  *)0;
              sqlstm.sqinds[0] = (         int  )0;
              sqlstm.sqharm[0] = (unsigned int  )0;
              sqlstm.sqadto[0] = (unsigned short )0;
              sqlstm.sqtdso[0] = (unsigned short )0;
              sqlstm.sqhstv[1] = (         void  *)&nd_source_code;
              sqlstm.sqhstl[1] = (unsigned int  )14;
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


              break;
    case 'E' :
              /* EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM RL_REFERRAL_lang_vw
                        --WHERE REFERRAL_CODE = :d_source_code;
						WHERE REFERRAL_CODE = :nd_source_code
						AND language_id = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 23;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from RL_REFERRAL_la\
ng_vw where (REFERRAL_CODE=:b1 and language_id=:b2)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )1268;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&nd_src_desc;
              sqlstm.sqhstl[0] = (unsigned int  )63;
              sqlstm.sqhsts[0] = (         int  )0;
              sqlstm.sqindv[0] = (         void  *)0;
              sqlstm.sqinds[0] = (         int  )0;
              sqlstm.sqharm[0] = (unsigned int  )0;
              sqlstm.sqadto[0] = (unsigned short )0;
              sqlstm.sqtdso[0] = (unsigned short )0;
              sqlstm.sqhstv[1] = (         void  *)&nd_source_code;
              sqlstm.sqhstl[1] = (unsigned int  )14;
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


              break;

  }   
  
  nd_src_desc.arr[nd_src_desc.len] = '\0';

//sprintf(string_var,"2= %s   %s    %s\n",nd_src_type.arr, nd_source_code.arr, nd_src_desc.arr);
//disp_message(ERR_MESG,string_var);

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1295;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_source_desc() occured....\n");
   proc_exit();
}

/********SECTION DESCRIPTION Added on 05/04/2003 against SCF No RL-44 from HMC******************/
get_section_desc()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  d_dept_desc.arr[0] = '\0';
  d_dept_desc.len = 0;
  /* EXEC SQL SELECT LONG_NAME
		 INTO :d_dept_desc
	     FROM RL_SECTION_CODE_lang_vw
            WHERE SECTION_CODE = :nd_section_code
			AND language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LONG_NAME into :b0  from RL_SECTION_CODE_lang_vw whe\
re (SECTION_CODE=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1310;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_dept_desc;
  sqlstm.sqhstl[0] = (unsigned int  )43;
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

	      

  d_dept_desc.arr[d_dept_desc.len] = '\0';  

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1337;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_section_desc() occured....\n");
   proc_exit();
}

/*********** PRINT REPORT HEADER **************/
void print_rep_header()
{
  char nd_fr_process_date_desc[22],
       nd_to_process_date_desc[22];
  int rec_len;

  if(strcmp(nd_fr_date.arr, "01/01/1800") == 0)
    //strcpy(nd_fr_process_date_desc, "LOWEST");
	strcpy(nd_fr_process_date_desc,local_legend[30]);
    else 
	{
		/* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			//------Commented aginst leap year date problem in thai
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_fr_date,'DD/MM/YYYY'), :language_id , t_date);
			//:nd_fr_date1 := to_char(t_date,'DD/MM/YYYY');
			//------Added aginst leap year date problem in thai
			:nd_fr_date1 :=sm_convert_date_2t(to_date(:nd_fr_date,'DD/MM/YYYY '),:language_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :nd_fr_date1 := sm_convert_date\
_2t ( to_date ( :nd_fr_date , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1352;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_fr_date1;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
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


		strcpy(nd_fr_process_date_desc, nd_fr_date1.arr);
	}

  if(strcmp(nd_to_date.arr, "31/12/4712") == 0)
    //strcpy(nd_to_process_date_desc, "HIGHEST");
	strcpy(nd_to_process_date_desc,local_legend[31]);
    else 
	{
		/* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			//------Commented aginst leap year date problem in thai
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_to_date,'DD/MM/YYYY'), :language_id , t_date);
			//:nd_to_date1 := to_char(t_date,'DD/MM/YYYY');
			//------Added aginst leap year date problem in thai
			:nd_to_date1 :=sm_convert_date_2t(to_date(:nd_to_date,'DD/MM/YYYY'),:language_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :nd_to_date1 := sm_convert_date\
_2t ( to_date ( :nd_to_date , 'DD/MM/YYYY' ) , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1379;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_to_date1;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
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


		strcpy(nd_to_process_date_desc, nd_to_date1.arr);
	}

  
  #ifdef DEBUG
      printf("before report header()\n");
  #endif
  //page_no++ ;
  printt_page_header();

  #ifdef DEBUG
      printf("after page header()\n");
  #endif
  
  get_section_desc();
  get_version_no();   ///// added 01.07.2003

//// 01.07.2003  fprintf(fp,VER);


  fprintf(fp,"%s\n",d_version.arr);

  fprintf(fp,"\n\n\n\n");
  
  //fprintf(fp,"        ");
  //fprintf(fp,"INPUT PARAMETERS :\n");
  rec_len = strlen(local_legend[3]);//added for globalisation
  print_space(30, rec_len,1);//added for globalisation
  fprintf(fp,"%16.16s :\n", local_legend[3]); 

  //fprintf(fp,"        ");
  //fprintf(fp,"------------------\n\n");
  print_space(30, rec_len,1);//added for globalisation
  print_space(30, rec_len,0);//added for globalisation
  fprintf(fp,"\n\n");

  //fprintf(fp,"                   ");
  //fprintf(fp,"TEST            : %s\n", nd_test_code.arr);  
  print_space(35, rec_len,1);
  fprintf(fp,"%4.4s            : %s\n", local_legend[4], nd_test_code.arr);

  //fprintf(fp,"TEST            : %s  %s\n", nd_test_code.arr,nd_test_desc.arr);/**Commented on 06/04/2004**/
  
  //fprintf(fp,"                   ");
  //fprintf(fp,"DEPARTMENT      : %s  %s\n", nd_section_code.arr,d_dept_desc.arr);
  print_space(35, rec_len,1);
  fprintf(fp,"%10.10s      : %s  %s\n", local_legend[5], nd_section_code.arr,d_dept_desc.arr);

  //fprintf(fp,"                   ");
  //fprintf(fp,"DATE FROM       : %s\n", nd_fr_process_date_desc);
  
  print_space(35, rec_len,1);
  fprintf(fp,"%9.9s       : %s\n", local_legend[6], nd_fr_process_date_desc);

  //fprintf(fp,"                   ");
  //fprintf(fp,"     TO         : %s\n", nd_to_process_date_desc); 
  print_space(35, rec_len,1);
  fprintf(fp,"     %2.2s         : %s\n", local_legend[7], nd_to_process_date_desc);

/*        ********* 16.10.2002     */

  //fprintf(fp,"                   ");/***Commented on 05/04/2004****/

//  fprintf(fp,"SOURCE TYPE     : %s\n", nd_src_type.arr);

/*
  if(nd_src_type.arr[0]=="W")
    fprintf(fp,"SOURCE TYPE     : WARD\n");
  else
  {
  if(nd_src_type.arr[0]=="O")
    fprintf(fp,"SOURCE TYPE     : CLINIC\n");
  else
  {
  if(nd_src_type.arr[0]=="R")
    fprintf(fp,"SOURCE TYPE     : EXTERNAL\n");
  else
    fprintf(fp,"SOURCE TYPE     : \n");   
  } 
  }
*/
  switch(nd_src_type.arr[0])
  {
    case 'W' :
			  //fprintf(fp,"                   ");/***Added on 05/04/2004****/
			  //fprintf(fp,"SOURCE TYPE     : WARD\n");
			  print_space(35, rec_len,1);
			  fprintf(fp,"%11.11s     : %4.4s\n",local_legend[26],local_legend[27]);
	          break;
    case 'O' :
			  //fprintf(fp,"                   ");/***Added on 05/04/2004****/
			  //fprintf(fp,"SOURCE TYPE     : CLINIC\n");
			  print_space(35, rec_len,1);
			  fprintf(fp,"%11.11s     : %6.6s\n",local_legend[26],local_legend[28]);
              break;
    case 'R' :
			  //fprintf(fp,"                   ");/***Added on 05/04/2004****/
	          //fprintf(fp,"SOURCE TYPE     : EXTERNAL\n");
			  print_space(35, rec_len,1);
			  fprintf(fp,"%11.11s     : %8.8s\n",local_legend[26],local_legend[29]);
              break;
		
  }
/*****Added on 06/04/2004 to get source description***************/

  nd_source_code.arr[0]		= '\0';
  nd_source_code.len		= 0;
  strcpy(nd_source_code.arr, nd_src_code.arr);
  nd_source_code.len = strlen(nd_source_code.arr);
  get_source_desc();
  nd_source_code.arr[0]		= '\0';
  nd_source_code.len		= 0;

/*************upto here***************/

  //fprintf(fp,"                   ");
  //fprintf(fp,"SOURCE CODE     : %s\n", nd_src_code.arr);  
  print_space(35, rec_len,1);
  fprintf(fp,"%11.11s     : %s\n", local_legend[8], nd_src_code.arr);

  //fprintf(fp,"SOURCE CODE     : %s  %s\n", nd_src_code.arr,nd_src_desc.arr);  
  
  //fprintf(fp,"              ");
  //fprintf(fp,"NUMERIC RESULT RANGE : %s-%s\n", nd_num_rslt.arr,nd_num_rslt_to.arr);
  rec_len = strlen(local_legend[9]);
  print_space(34, rec_len,1);
  fprintf(fp,"%20.20s : %s-%s\n", local_legend[9], nd_num_rslt.arr,nd_num_rslt_to.arr);

  //fprintf(fp,"                   ");
  //fprintf(fp,"VARIANCE        : %s%1s\n", nd_variance.arr,"%");
  rec_len = strlen(local_legend[10]);
  print_space(34, rec_len,1);
  fprintf(fp,"%8.8s : %s%1s\n", local_legend[10], nd_variance.arr,"%");

  
//  fprintf(fp,"RESULT COMMENTS : %s,%s,%s,%s\n", nd_rcc1.arr,nd_rcc2.arr,nd_rcc3.arr,nd_rcc4.arr);  
  
  //fprintf(fp,"                   ");
  //fprintf(fp,"RESULT COMMENTS : %s", nd_rcc1.arr);  
  rec_len = strlen(local_legend[11]);
  print_space(34, rec_len,1);
  fprintf(fp,"%15.15s : %s", local_legend[11], nd_rcc1.arr);

  if(strlen(nd_rcc2.arr))
    fprintf(fp,",%s", nd_rcc2.arr);  
  if(strlen(nd_rcc3.arr))
	  fprintf(fp,",%s", nd_rcc3.arr);  
  if(strlen(nd_rcc4.arr))
	    fprintf(fp,",%s", nd_rcc4.arr);  
  fprintf(fp,"\n");

  
//  fprintf(fp,"SECONDARY TESTS : %s,%s,%s,%s\n", nd_sec_test.arr,nd_third_test.arr,nd_fourth_test.arr,nd_fifth_test.arr);
  
  //fprintf(fp,"SECONDARY TESTS : %s  %s", nd_sec_test.arr,nd_sec_test_desc.arr);
  
  //fprintf(fp,"                   ");
  //fprintf(fp,"SECONDARY TESTS : %s", nd_sec_test.arr);
  rec_len = strlen(local_legend[12]);
  print_space(34, rec_len,1);
  fprintf(fp,"%15.15s : %s", local_legend[12], nd_sec_test.arr);


  if(strlen(nd_third_test.arr))
    //fprintf(fp,",%s  %s", nd_third_test.arr,nd_third_test_desc.arr);/**Commented on 06/04/2004**/
	fprintf(fp,",%s", nd_third_test.arr);
  if(strlen(nd_fourth_test.arr))
    //fprintf(fp,",%s  %s", nd_fourth_test.arr,nd_fourth_test_desc.arr);/**Commented on 06/04/2004**/
	fprintf(fp,",%s", nd_fourth_test.arr);
  if(strlen(nd_fifth_test.arr))
    //fprintf(fp,",%s  %s", nd_fifth_test.arr,nd_fifth_test_desc.arr);/**Commented on 06/04/2004**/
	fprintf(fp,",%s", nd_fifth_test.arr);
  fprintf(fp,"\n");

/* ********** upto here ******** */
  fprintf(fp,"\f");
}

/************ PRINT PAGE HEADER **************** (ONCE FOR THE REPORT)*/
void printt_page_header1()
{

int spc_len;

 fprintf(fp,"\n") ;	
 page_no ++;
 //fprintf(fp,"%c&l1O",ESC);
 /* 
 fprintf(fp,"MDL : RL                     ");
 fprintf(fp,"%-30.30s", d_acc_entity_name.arr);
 fprintf(fp,"%s", d_sysdate.arr);
 fprintf(fp,"\n");
 */

  fprintf(fp,"MDL:RL");
  spc_len = (62 - (strlen(d_acc_entity_name.arr)))/2;
  for(i=1;i<=spc_len;i++)
  fprintf(fp," ");
  fprintf(fp,"%-60.60s", d_acc_entity_name.arr);
  for(i=1;i<=spc_len;i++)
  fprintf(fp," ");
  
  fprintf(fp,"%s", d_sysdate.arr);
  
  fprintf(fp,"\n"); 
 fprintf(fp,"OPR:%-21.21s", d_user.arr);
 fprintf(fp,"  ") ;
 fprintf(fp,"TEST RESULT REPORT ");
 fprintf(fp,"         Page : %3d", page_no);
 fprintf(fp,"\n");
 fprintf(fp,"REP:RLRMTRRP");
 fprintf(fp,"\n");
 fprintf(fp,"--------------------------------------------------------------------------------");
 //fprintf(fp,"-------------------------------------------------------------------------------");
 //fprintf(fp,"------------------------------------------------------");
 fprintf(fp,"\n");
}


/********************* FORM HDR ************************/

void printt_page_header()
{

    static int first = 1;
    char buf[15];
    int col;

        strcpy(rep_title1,local_legend[1]);  //added for globalisation
		strcpy(rep_title2,"");
        

    if(first) 
	{
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
        memset(hdr_line4,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';
	
        strncpy(hdr_line1,"MDL : RL",8);
        col = (int)(REP_WIDTH-strlen(d_acc_entity_name.arr))/2;
        //strncpy(hdr_line1+col-3,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
		strncpy(hdr_line1+col,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr)); // Added by Srinivas
        
		/********added for internalisation start *****************/
		/* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			//------Commented aginst leap year date problem in thai
			//t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
			//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
			//------Added aginst leap year date problem in thai
			:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert_datet\
ime_2t ( SYSDATE , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1406;
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


		
		col = (REP_WIDTH-3-strlen(d_sysdate1.arr));
        strcpy(hdr_line1+col,d_sysdate1.arr);

		/********added for internalisation end *****************/
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,d_user.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRTRERP",14); //RLRMTRRP
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    
	//sprintf(buf,"PAGE : %-4d",page_no++);
	sprintf(buf,"%4.4s : %-4d",local_legend[2],page_no++); //added for globalisation

    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

    col = (int)(REP_WIDTH-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    if(first)
        fprintf(fp,"%s\n",hdr_line1);
    else
	{    
		fprintf(fp,"\n");
		fprintf(fp,"%s\n",hdr_line1);
//        fprintf(fp,"\f%s\n",hdr_line1);
    }

    fprintf(fp,"%s\n",hdr_line2);
    fprintf(fp,"%s\n",hdr_line3);
    fprintf(fp,"%s\n",hdr_line4);
    fprintf(fp,"%s\n",hdr_line5);

    first = 0;
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
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1429;
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
     sqlstm.arrsiz = 23;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1448;
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

   nd_test_units_desc.arr[0]		= '\0';      
   nd_test_units_desc.len		= 0;

   /* EXEC SQL SELECT  short_desc
			  INTO :nd_test_units_desc
		  	  FROM SY_UOM_lang_vw
			 WHERE uom_code = :nd_test_units
			 AND language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from SY_UOM_lang_vw where (uom\
_code=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1467;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_test_units_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_test_units;
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
		strcpy(nd_test_units_desc.arr,nd_test_units.arr);    
		nd_test_units_desc.len = strlen(nd_test_units_desc.arr);
//		rl_tst_cd_test_units_desc.arr[rl_tst_cd_test_units_desc.len]	= '\0';

	}

    if (OERROR)
	{
		strcpy(nd_test_units_desc.arr,nd_test_units.arr);    
		nd_test_units_desc.len = strlen(nd_test_units_desc.arr);
	}

	nd_test_units_desc.arr[nd_test_units_desc.len]	= '\0';

}
/*------------------------------------------------------------*/

/*** added for globalisation ******/
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
/*** added for globalisation ******/


#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

