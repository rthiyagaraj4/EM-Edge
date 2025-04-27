
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRMTRRP.pc"
};


static unsigned int sqlctx = 1288616187;


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
            void  *sqhstv[23];
   unsigned int   sqhstl[23];
            int   sqhsts[23];
            void  *sqindv[23];
            int   sqinds[23];
   unsigned int   sqharm[23];
   unsigned int   *sqharc[23];
   unsigned short  sqadto[23];
   unsigned short  sqtdso[23];
} sqlstm = {12,23};

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

 static const char *sq0012 = 
"select SPECIMEN_NO ,PATIENT_ID ,EPISODE_TYPE ,SOURCE_CODE ,SOURCE_TYPE ,TO_C\
HAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD\
/MM/YYYY') ,CATEGORY_CODE ,CATEGORY_YEAR ,CATEGORY_NUMBER ,ORDERED_FACILITY_ID\
  from RL_REQUEST_HEADER where (((((((SPECIMEN_NO between NVL(:b0,0) and NVL(:\
b1,TO_NUMBER(:b2)) and SECTION_CODE=:b3) and OPERATING_FACILITY_ID=:b4) and SP\
EC_REGD_DATE_TIME>to_date(:b5,'DD/MM/YYYY')) and SPEC_REGD_DATE_TIME<(to_date(\
:b6,'DD/MM/YYYY')+1)) and SOURCE_CODE=NVL(:b7,SOURCE_CODE)) and SOURCE_TYPE=DE\
CODE(NVL(:b8,SOURCE_TYPE),'C','C','W','W','R','E','E','E')) and NVL(CANCELLED_\
YN,'N')<>'Y') order by SPECIMEN_NO            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,281,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,55,0,4,305,0,0,1,0,0,1,0,2,3,0,0,
55,0,0,3,0,0,30,350,0,0,0,0,0,1,0,
70,0,0,4,0,0,32,357,0,0,0,0,0,1,0,
85,0,0,5,110,0,6,401,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
108,0,0,6,136,0,6,417,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
131,0,0,7,403,0,4,442,0,0,23,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
238,0,0,8,98,0,2,575,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
261,0,0,9,0,0,32,583,0,0,0,0,0,1,0,
276,0,0,10,150,0,4,593,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
311,0,0,11,0,0,32,617,0,0,0,0,0,1,0,
326,0,0,12,668,0,9,658,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
377,0,0,13,0,0,32,663,0,0,0,0,0,1,0,
392,0,0,14,0,0,17,791,0,0,1,1,0,1,0,1,97,0,0,
411,0,0,15,0,0,32,798,0,0,0,0,0,1,0,
426,0,0,16,248,0,4,817,0,0,8,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,
473,0,0,17,0,0,32,870,0,0,0,0,0,1,0,
488,0,0,18,233,0,4,879,0,0,7,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,
531,0,0,19,0,0,32,926,0,0,0,0,0,1,0,
546,0,0,20,57,0,4,950,0,0,1,0,0,1,0,2,9,0,0,
565,0,0,21,100,0,4,953,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,4,0,0,
592,0,0,22,99,0,4,983,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
619,0,0,12,0,0,15,1097,0,0,0,0,0,1,0,
634,0,0,12,0,0,13,1115,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
693,0,0,23,0,0,32,1150,0,0,0,0,0,1,0,
708,0,0,24,67,0,4,1161,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
731,0,0,14,0,0,15,1176,0,0,0,0,0,1,0,
746,0,0,14,0,0,45,1185,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
769,0,0,14,0,0,13,1201,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
804,0,0,25,0,0,32,1228,0,0,0,0,0,1,0,
819,0,0,26,0,0,32,1277,0,0,0,0,0,1,0,
834,0,0,27,142,0,6,1321,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
861,0,0,28,283,0,4,1538,0,0,9,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
912,0,0,29,0,0,32,1562,0,0,0,0,0,1,0,
927,0,0,30,110,0,4,1591,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
958,0,0,31,0,0,32,1610,0,0,0,0,0,1,0,
973,0,0,32,137,0,4,1631,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1008,0,0,33,125,0,4,1639,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1043,0,0,34,98,0,4,1647,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1070,0,0,35,98,0,4,1654,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1097,0,0,36,0,0,32,1672,0,0,0,0,0,1,0,
1112,0,0,37,100,0,4,1685,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1139,0,0,38,0,0,32,1697,0,0,0,0,0,1,0,
1154,0,0,39,141,0,6,1711,0,0,3,3,0,1,0,2,97,0,0,1,9,0,0,1,9,0,0,
1181,0,0,40,141,0,6,1726,0,0,3,3,0,1,0,2,97,0,0,1,9,0,0,1,9,0,0,
1208,0,0,41,100,0,6,1905,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
1231,0,0,42,101,0,6,1959,0,0,1,1,0,1,0,2,3,0,0,
1250,0,0,43,49,0,4,1972,0,0,1,0,0,1,0,2,9,0,0,
1269,0,0,44,88,0,4,1998,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/***************************************************************************** 
*  File	         : rlrmtrrp.pc
   Author        : Sheelvant
   Date Created  : 18/07/1998
   Last Modified : 18/07/1998    ( Sheelvant )
                   16/10/2002    ( Srinivas  ) report layout modified 

   Last Modified : HAMEED   - eHIS upgrade
   Last Modified : SHRUTI   - (ORDERED_FACILITY_ID)
*  Ver 1.10.01  
   
*  Purpose : To Generate Test Result Report    
            
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
#include "rl.h"

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
		d_spec_date1		[21],
		l_spec_date		[21],
		
		/o Primary test result o/
		d_numeric_result	        [16],
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

		/o Added by babu for internationalization o/

			l_translated_value		 [100],
			language_id			[5],
		/o******* parameters from SY_PROG_PARAM table **********o/
		nd_fr_date			[31],
		nd_to_date			[31],
		nd_section_code    	[3],
		nd_test_code		[11],
		nd_test_desc        [41],
		nd_op1				[61],
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
		nd_facility_id			[3],//Added by babu
		

/oadded by Shruti on 04/01/2004 as per front end changeso/
		nd_num_rslt_to			[16],
		nd_specimen_from        [21], 
		nd_specimen_to          [21],

		/o for header routine o/
	    //d_acc_entity_name        [61],
		d_acc_entity_name        [300],
		d_user                   [21],
		d_sysdate                [17],
		d_sysdate1                [17],//added by babu for internationalization

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
			d_dept_desc				  [101],
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

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;

struct { unsigned short len; unsigned char arr[31]; } nd_fr_date;

struct { unsigned short len; unsigned char arr[31]; } nd_to_date;

struct { unsigned short len; unsigned char arr[3]; } nd_section_code;

struct { unsigned short len; unsigned char arr[11]; } nd_test_code;

struct { unsigned short len; unsigned char arr[41]; } nd_test_desc;

struct { unsigned short len; unsigned char arr[61]; } nd_op1;

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

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

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

struct { unsigned short len; unsigned char arr[101]; } d_dept_desc;

struct { unsigned short len; unsigned char arr[2]; } d_specimen_prefix;


	char            sql_stmt[5000];
 
	int i;

	/* added by Ananthi on 18/6/2002 for KN ENHANCEMENT*/

	int l_count = 0;
	int l_specimen_length = 0;


		/*  For Patient Age SYSDATE, MTHS amjad 17/7/2002*/
   /* VARCHAR  tday				[30],
			t_days				[30],
			mths				[30],
			mths1				[30],
			t_age				[30]; */ 
struct { unsigned short len; unsigned char arr[30]; } tday;

struct { unsigned short len; unsigned char arr[30]; } t_days;

struct { unsigned short len; unsigned char arr[30]; } mths;

struct { unsigned short len; unsigned char arr[30]; } mths1;

struct { unsigned short len; unsigned char arr[30]; } t_age;


	float mt;

	int  l_tab_exists ;
	int  end_pgm_control = 0;  

	char src_code[11];
    char nd_fr_process_date_desc1[11];//added by babu for conversion
    char nd_to_process_date_desc1[11];//added by babu for conversion 

/* EXEC SQL END DECLARE SECTION; */ 


	int		l_len = 30;
	char	l_delimeter;
    
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

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];


char rep_title1[] = "TEST RESULT REPORT";
char con_rep_title[60];
char rep_title2[30];
//added by babu for internationalization
char local_legend[100][100];
char g_facility_id[50];

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
 
   strcpy(g_facility_id, nd_operating_facility_id.arr);
	
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CONNECT :uid_pwd; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )30;
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

  
   //disp_message(ERR_MESG,"THIS IS BABU");

#ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
#endif  
   
   set_meduser_role();

    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	   
  
   get_legend_value(35);

   get_params();

   //get_dept_printer();

   gen_file_name();
   
/***************** code added for KN ENHANCEMENT **********************/
   
  /* EXEC SQL SELECT NVL(specimen_length, 15)
	     INTO :l_specimen_length
	     FROM RL_PARAM; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(specimen_length,15) into :b0  from RL_PARAM ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )55;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )70;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}
/* -------------------------------------------------------------------------*/
/* get the printer name */

/***************** this procedure is not getting used any where
void get_dept_printer()
{

   EXEC SQL WHENEVER SQLERROR GOTO err_exit;
   EXEC SQL SELECT printer_name,specimen_prefix 
	      INTO :d_printer_name,:d_specimen_prefix,
              FROM RL_SECTION_CODE_LANG_VW
	     WHERE SECTION_CODE = :nd_section_code
		 AND LANGUAGE_ID = :language_id;

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


//Added by babu for internationalization
get_legend_value(int cou)
 {


	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_facility_id,:language_id,'RLRMTRRP.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_facilit\
y_id , :language_id , 'RLRMTRRP.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )85;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRMTRRP.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRMTRRP.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )108;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
		           :nd_op1, :nd_num_rslt, :nd_op2,
		           :nd_rcc1, :nd_rcc2, :nd_rcc3, :nd_rcc4,
                   :nd_sec_test, :nd_third_test, :nd_fourth_test,:nd_fifth_test,
                   :nd_src_type, :nd_src_code, :nd_num_rslt_to ,:nd_specimen_from, :nd_specimen_to
            FROM   SY_PROG_PARAM
	        WHERE  UPPER(PGM_ID) = 'RLRMTRRP'
		      AND  SESSION_ID = TO_NUMBER(:nd_session_id)
		      AND  PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13\
 ,PARAM14 ,PARAM15 ,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 into :b0,:b1,:\
b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b\
19,:b20  from SY_PROG_PARAM where ((UPPER(PGM_ID)='RLRMTRRP' and SESSION_ID=TO\
_NUMBER(:b21)) and PGM_DATE=:b22)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )131;
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
   sqlstm.sqhstv[5] = (         void  *)&nd_op1;
   sqlstm.sqhstl[5] = (unsigned int  )63;
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
   nd_op1.arr[nd_op1.len] = '\0';
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
   printf(" nd_op1 = %s\n",nd_op1.arr);
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
	   WHERE UPPER(PGM_ID) = 'RLRMTRRP'
	         AND SESSION_ID = :nd_session_id
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLRMTRR\
P' and SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )238;
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
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )261;
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

   /* EXEC SQL SELECT ACC_ENTITY_NAME,
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY')
	    INTO :d_acc_entity_name,
		     :d_user,
		     :d_sysdate
        FROM SY_ACC_ENTITY_LANG_VW
		WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		AND   LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY'\
) into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b3 and LA\
NGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )276;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )311;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
                 AND NVL(CANCELLED_YN,'N') != 'Y'
				 ORDER BY SPECIMEN_NO; */ 
   /// added order by clause against ML-SD-SCF-1600

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL OPEN REQUEST_HEADER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )326;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
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
   sqlstm.sqhstl[3] = (unsigned int  )5;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )377;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_request_header_cur() occured....\n");
   proc_exit();
}

void dclr_test_result_cur()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


    strcpy(sql_stmt,
    " SELECT NUMERIC_RESULT, \
            RESULT_COMMENT_DESC1, RESULT_COMMENT_DESC2, \
            RESULT_COMMENT_DESC3, RESULT_COMMENT_DESC4 \
       FROM RL_TEST_RESULT \
      WHERE SPECIMEN_NO = to_number(:d_specimen_no) \
	    AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
        AND TEST_CODE = '"); 
    strcat(sql_stmt,nd_test_code.arr);
    strcat(sql_stmt,"'");
	strcat(sql_stmt, " AND NVL(CANCELLED_YN,'N') != 'Y' ");

    if(strlen(nd_op1.arr))
    {		  
       strcat(sql_stmt,
	      //" AND( ( NUMERIC_RESULT IS NOT NULL AND TO_NUMBER(NUMERIC_RESULT) ");

		  " AND (NUMERIC_RESULT IS NOT NULL AND TO_NUMBER(NUMERIC_RESULT) ");
       switch(nd_op1.arr[0])
       {
	 
	      case '>': strcat(sql_stmt," > ");
		            break;
	      case '<': strcat(sql_stmt," < ");
		            break;
	      case '=': strcat(sql_stmt," = ");
		            break;
		//added on 05/01/2004----

		  case 'R': strcat(sql_stmt," BETWEEN ");
					break;
		}

	  if(strcmp(nd_op1.arr,"R") == 0)		
		{
		strcat(sql_stmt,nd_num_rslt.arr);	
		strcat(sql_stmt," AND ");	
		strcat(sql_stmt,nd_num_rslt_to.arr);
		strcpy(nd_op1.arr,"Range   ");
		strcat(nd_num_rslt.arr,"  -  ");		
		//strcat(sql_stmt,")");
		}		 

	  else

       strcat(sql_stmt,nd_num_rslt.arr);
	   //strcat(sql_stmt,")");
	   
	}
 
    if(strlen(nd_op2.arr))
    {
       if(strcmp(nd_op2.arr,"AND") == 0)
  	      strcat(sql_stmt," AND ( ");
       else
	      strcat(sql_stmt," OR ( ");
    }
/*
    else
    {
       if(strlen(nd_op1.arr) == 0)
	     strcat(sql_stmt," AND ");
    }
*/

    if(strlen(nd_rcc1.arr))
    {
       if(strlen(nd_op2.arr) == 0)
	     strcat(sql_stmt," AND ");

       strcat(sql_stmt,
         " RESULT_COMMENT_CODE1 = ");
       strcat(sql_stmt,"'");
       strcat(sql_stmt,nd_rcc1.arr);
       strcat(sql_stmt,"'");
    }
    if(strlen(nd_rcc2.arr))
    {
       if(strlen(nd_rcc1.arr))
	     strcat(sql_stmt," AND ");

       strcat(sql_stmt," RESULT_COMMENT_CODE2 = ");
       strcat(sql_stmt,"'");
       strcat(sql_stmt,nd_rcc2.arr);
       strcat(sql_stmt,"'");
    }
    if(strlen(nd_rcc3.arr))
    {
       if(strlen(nd_rcc1.arr) || strlen(nd_rcc2.arr))
	      strcat(sql_stmt," AND ");

       strcat(sql_stmt,
         " RESULT_COMMENT_CODE3 = ");
       strcat(sql_stmt,"'");
       strcat(sql_stmt,nd_rcc3.arr);
       strcat(sql_stmt,"'");
    }
    if(strlen(nd_rcc4.arr))
    {
       if(strlen(nd_rcc1.arr) || strlen(nd_rcc2.arr) ||strlen(nd_rcc3.arr))
	       strcat(sql_stmt," AND ");

       strcat(sql_stmt,
         " RESULT_COMMENT_CODE4 = ");
       strcat(sql_stmt,"'");
       strcat(sql_stmt,nd_rcc4.arr);
       strcat(sql_stmt,"'");
    }

    if(strlen(nd_op2.arr))
       strcat(sql_stmt," ) ");
    
	if(strlen(nd_op1.arr))
       strcat(sql_stmt," ) ");
	   
/*	
	sprintf(string_var,"SQL= %s\n",sql_stmt);
	disp_message(ERR_MESG,string_var);   
*/	   
	/* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )392;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



    /* EXEC SQL DECLARE TEST_RESULT CURSOR FOR S; */ 
   
    return;

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )411;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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

   /* EXEC SQL SELECT DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) SHORT_NAME, 
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_loc_lang,\
SHORT_NAME)) SHORT_NAME ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX ,NATIONALITY\
_CODE ,TOWN_CODE ,NVL(actual_dob_yn,'N') into :b1,:b2,:b3,:b4,:b5,:b6  from RL\
_PATIENT_MAST where PATIENT_ID=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )426;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )473;
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
int get_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT Decode (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) SHORT_NAME,
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select Decode(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_loc_lang,\
SHORT_NAME)) SHORT_NAME ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX ,NATIONALITY\
_CODE ,NVL(actual_dob_yn,'N') into :b1,:b2,:b3,:b4,:b5  from MP_PATIENT_MAST w\
here PATIENT_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )488;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )531;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )546;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ABS(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),TO_DA\
TE(:b1,'DD/MM/YYYY'))) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )565;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ROUND((TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:\
b1,'DD/MM/YYYY')),3)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )592;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
			strncat(t_age.arr, local_legend[31],1);
			sprintf(st_r, " %f", tmp_mths);
			strcat(t_age.arr, strtok(st_r, "."));
			strncat(t_age.arr, local_legend[32],1);
			sprintf(st_r, " %f", tmp_days);
			strcat(t_age.arr, strtok(st_r, "."));
			strncat(t_age.arr, local_legend[33],1);

				
 }
/*------------------------------------------------------------*/

/* to print the last line of the report */
void end_report()
{
  
  fprintf(fp,"%s      :   %d",local_legend[2],d_specimen_count);
  fprintf(fp,"\n\n");  
  //fprintf(fp,"%s        :   %6.3f",local_legend[3],d_result_total);
  //fprintf(fp,"\n\n");  
  fprintf(fp,"%s :   %6.3f",local_legend[4],d_result_mean);
  fprintf(fp,"\n\n");  
  fprintf(fp,"                      ******** %s *********",local_legend[5]);
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
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )619;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )634;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )693;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select location into :b0  from rl_patient_mast where PATIE\
NT_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )708;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
	/* EXEC SQL CLOSE TEST_RESULT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )731;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}


int get_specimen_found()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL OPEN TEST_RESULT
          USING :d_specimen_no,
		        :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )746;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}

 

  d_numeric_result.arr[0] = '\0';
  d_rc_1.arr[0] = '\0';
  d_rc_2.arr[0] = '\0';
  d_rc_3.arr[0] = '\0';
  d_rc_4.arr[0] = '\0';

  d_numeric_result.len = 0;
  d_rc_1.len = 0;
  d_rc_2.len = 0;
  d_rc_3.len = 0;
  d_rc_4.len = 0;  

  /* EXEC SQL FETCH TEST_RESULT 
	    INTO :d_numeric_result,:d_rc_1, :d_rc_2,:d_rc_3,:d_rc_4; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )769;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_numeric_result;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_rc_1;
  sqlstm.sqhstl[1] = (unsigned int  )43;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_rc_2;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_rc_3;
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_rc_4;
  sqlstm.sqhstl[4] = (unsigned int  )43;
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



	/*if (strlen(d_numeric_result.arr)) 
	{
	d_specimen_count++;	
	d_result_total=d_result_total+atoi(d_numeric_result.arr);
	}*/

  if (NODATAFOUND)
    return 0;

  d_numeric_result.arr[d_numeric_result.len] = '\0';
  d_rc_1.arr[d_rc_1.len] = '\0';
  d_rc_2.arr[d_rc_2.len] = '\0';
  d_rc_3.arr[d_rc_3.len] = '\0';
  d_rc_4.arr[d_rc_4.len] = '\0';



  // EXEC SQL CLOSE TEST_RESULT;

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   
   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )804;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
	   d_result_total = d_result_total + atof(d_numeric_result.arr);
	  

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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )819;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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

   /* EXEC SQL EXECUTE
			DECLARE
				t_date   date;
				
				BEGIN
				
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_spec_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:d_spec_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:d_spec_date1 :=sm_convert_datetime_2t(to_date(:d_spec_date,'DD/MM/YYYY HH24:MI'),:language_id);

				END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN :d_spec_date1 := sm_convert_da\
tetime_2t ( to_date ( :d_spec_date , 'DD/MM/YYYY HH24:MI' ) , :language_id ) ;\
 END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )834;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
   	 fprintf(fp,"%-6.6s  %-11.11s\n",d_numeric_result.arr, nd_test_units_desc.arr);
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
   fprintf(fp,"\n________________________________________________________________________________\n");
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NUMERIC_RESULT ,RESULT_COMMENT_DESC1 ,RESULT_COMMEN\
T_DESC2 ,RESULT_COMMENT_DESC3 ,RESULT_COMMENT_DESC4 into :b0,:b1,:b2,:b3,:b4  \
from RL_TEST_RESULT where ((((SPECIMEN_NO=:b5 and OPERATING_FACILITY_ID=:b6) a\
nd TEST_CODE=:b7) and PATIENT_ID=:b8) and NVL(CANCELLED_YN,'N')<>'Y')";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )861;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
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


   disp_message(ORA_MESG,"Oracle error at get_secondary_test_result() occured....\n");
   proc_exit();
}

void print_page_header()
{
   //page_no++;
   printt_page_header() ;
   fprintf(fp,"%s           : %-44s\n",local_legend[6],nd_test_desc.arr);
   line_no += 4;
}

void print_col_heading()
{
   fprintf(fp,"--------------------------------------------------------------------------------\n");
   fprintf(fp, "%-10.10s          %-12.12s                    %-3.3s             %-3.3s %-s\n",local_legend[7],local_legend[8],local_legend[9],local_legend[10],local_legend[11]);
   fprintf(fp, "                                                    %s\n",local_legend[12]);
   fprintf(fp, "%-15.15s     %-18.18s %-15.15s                %-8.8s\n",local_legend[13],local_legend[14],local_legend[15],local_legend[16]);

   fprintf(fp,"--------------------------------------------------------------------------------\n");
   line_no += 3;
}
get_test_desc()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  nd_description.arr[0] = '\0';
  nd_description.len = 0;
  /* EXEC SQL SELECT LONG_DESC,TEST_UNITS INTO :nd_description,:nd_test_units
	     FROM RL_TEST_CODE_LANG_VW
            WHERE 
/o* Commented on 18/08/2004 since Test Code is Unique across the section
			SECTION_CODE = :nd_section_code
	        AND 
*o/
		  TEST_CODE = :nd_test
		  AND LANGUAGE_ID =:language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LONG_DESC ,TEST_UNITS into :b0,:b1  from RL_TEST_COD\
E_LANG_VW where (TEST_CODE=:b2 and LANGUAGE_ID=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )927;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

  get_test_units_desc_from_sy_uom();  //// 19.02.2006 

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )958;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
              /* EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM IP_NURSING_UNIT_LANG_VW //Changed by babu from IP_WARD to IP_NURSING_UNIT_LANG_VW 
                        WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
						--AND WARD_CODE = :d_source_code;
						AND NURSING_UNIT_CODE = :nd_source_code
						AND LANGUAGE_ID = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 12;
              sqlstm.arrsiz = 23;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from IP_NURSING_UNI\
T_LANG_VW where ((FACILITY_ID=nvl(:b1,:b2) and NURSING_UNIT_CODE=:b3) and LANG\
UAGE_ID=:b4)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )973;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)4352;
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
                         FROM OP_CLINIC_LANG_VW
                        WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
						--AND CLINIC_CODE = :d_source_code;
						AND CLINIC_CODE = :nd_source_code
						AND LANGUAGE_ID = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 12;
              sqlstm.arrsiz = 23;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from OP_CLINIC_LANG\
_VW where ((FACILITY_ID=nvl(:b1,:b2) and CLINIC_CODE=:b3) and LANGUAGE_ID=:b4)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )1008;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)4352;
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
                         FROM RL_REFERRAL_LANG_VW
                        --WHERE REFERRAL_CODE = :d_source_code;
						WHERE REFERRAL_CODE = :nd_source_code
						AND    LANGUAGE_ID = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 12;
              sqlstm.arrsiz = 23;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from RL_REFERRAL_LA\
NG_VW where (REFERRAL_CODE=:b1 and LANGUAGE_ID=:b2)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )1043;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)4352;
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
                         FROM RL_REFERRAL_LANG_VW
                        --WHERE REFERRAL_CODE = :d_source_code;
						WHERE REFERRAL_CODE = :nd_source_code
						AND    LANGUAGE_ID = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 12;
              sqlstm.arrsiz = 23;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from RL_REFERRAL_LA\
NG_VW where (REFERRAL_CODE=:b1 and LANGUAGE_ID=:b2)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )1070;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)4352;
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

;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1097;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
	     FROM RL_SECTION_CODE_LANG_VW
            WHERE SECTION_CODE = :nd_section_code
			AND   LANGUAGE_ID = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LONG_NAME into :b0  from RL_SECTION_CODE_LANG_VW whe\
re (SECTION_CODE=:b1 and LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1112;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_dept_desc;
  sqlstm.sqhstl[0] = (unsigned int  )103;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[1] = (unsigned int  )5;
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
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1139;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_section_desc() occured....\n");
   proc_exit();
}

/*********** PRINT REPORT HEADER **************/
void print_rep_header()
{
  char nd_fr_process_date_desc[11],
       nd_to_process_date_desc[11];

  if(strcmp(nd_fr_date.arr, "01/01/1800") == 0)
    strcpy(nd_fr_process_date_desc, "LOWEST");
    else strcpy(nd_fr_process_date_desc, nd_fr_date.arr);
/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_fr_date,'DD/MM/YYYY'), :language_id , t_date);
				//:nd_fr_process_date_desc1 := to_char(t_date,'DD/MM/YYYY');
				:nd_fr_process_date_desc1 :=sm_convert_date_2t(to_date(:nd_fr_date,'DD/MM/YYYY'),:language_id);
				END;
			END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 23;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare t_date date ; BEGIN :nd_fr_process_date_desc1 := sm_c\
onvert_date_2t ( to_date ( :nd_fr_date , 'DD/MM/YYYY' ) , :language_id ) ; END\
 ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1154;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)nd_fr_process_date_desc1;
sqlstm.sqhstl[0] = (unsigned int  )11;
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


	
  
  if(strcmp(nd_to_date.arr, "31/12/4712") == 0)
    strcpy(nd_to_process_date_desc, "HIGHEST");
    else strcpy(nd_to_process_date_desc, nd_to_date.arr);
/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_to_date,'DD/MM/YYYY'), :language_id , t_date);
				//:nd_to_process_date_desc1 := to_char(t_date,'DD/MM/YYYY');
				:nd_to_process_date_desc1 :=sm_convert_date_2t(to_date(:nd_to_date,'DD/MM/YYYY'),:language_id);
				END;
			END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 23;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare t_date date ; BEGIN :nd_to_process_date_desc1 := sm_c\
onvert_date_2t ( to_date ( :nd_to_date , 'DD/MM/YYYY' ) , :language_id ) ; END\
 ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1181;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)nd_to_process_date_desc1;
sqlstm.sqhstl[0] = (unsigned int  )11;
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
  fprintf(fp,"        ");
  fprintf(fp,"%s :\n",local_legend[17]);
  fprintf(fp,"        ");
  fprintf(fp,"------------------\n\n");
  fprintf(fp,"                   ");
  fprintf(fp,"%-24.24s :%s\n", local_legend[18],nd_test_code.arr);  
  fprintf(fp,"                   ");
  fprintf(fp,"%-24.24s :%s  %s\n",local_legend[19], nd_section_code.arr,d_dept_desc.arr);
  fprintf(fp,"                   ");
  
  
  fprintf(fp,"%-24.24s :%s\n",local_legend[20] ,nd_fr_process_date_desc1);
  fprintf(fp,"                   ");
  fprintf(fp,"%-24.24s :%s\n",local_legend[21] ,nd_to_process_date_desc1); 
/*        ********* 16.10.2002     */

  //fprintf(fp,"                   ");/***Commented on 05/04/2004****/

//  fprintf(fp,"%s%s\n", nd_src_type.arr);


  switch(nd_src_type.arr[0])
  {
    case 'W' :
			  fprintf(fp,"                   ");/***Added on 05/04/2004****/
			  fprintf(fp,"%-24.24s :%s,local_legend[22],local_legend[23]\n");
	          break;
    case 'O' :
			  fprintf(fp,"                   ");/***Added on 05/04/2004****/
			  fprintf(fp,"%-24.24s :%s,local_legend[22]local_legend[24]\n");
              break;
    case 'R' :
			  fprintf(fp,"                   ");/***Added on 05/04/2004****/
	          fprintf(fp,"%-24.24s%s,local_legend[22]local_legend[25]\n");
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

  fprintf(fp,"                   ");
  fprintf(fp,"%-24.24s :%s\n",local_legend[26], nd_src_code.arr);  
  //fprintf(fp,"SOURCE CODE     : %s  %s\n", nd_src_code.arr,nd_src_desc.arr);  
  fprintf(fp,"                   ");
  fprintf(fp,"%-24.24s :%s %s %s\n",local_legend[27], nd_op1.arr,nd_num_rslt.arr,nd_num_rslt_to.arr);
  fprintf(fp,"                   ");
//  fprintf(fp,"RESULT COMMENTS : %s,%s,%s,%s\n", nd_rcc1.arr,nd_rcc2.arr,nd_rcc3.arr,nd_rcc4.arr);  
  fprintf(fp,"%-24.24s :%s",local_legend[28], nd_rcc1.arr);  
  if(strlen(nd_rcc2.arr))
    fprintf(fp,",%s", nd_rcc2.arr);  
  if(strlen(nd_rcc3.arr))
	  fprintf(fp,",%s", nd_rcc3.arr);  
  if(strlen(nd_rcc4.arr))
	    fprintf(fp,",%s", nd_rcc4.arr);  
  fprintf(fp,"\n");

  fprintf(fp,"                   ");
//  fprintf(fp,"SECONDARY TESTS : %s,%s,%s,%s\n", nd_sec_test.arr,nd_third_test.arr,nd_fourth_test.arr,nd_fifth_test.arr);
  
  //fprintf(fp,"SECONDARY TESTS : %s  %s", nd_sec_test.arr,nd_sec_test_desc.arr);
  fprintf(fp,"%--24.24s :%s",local_legend[29], nd_sec_test.arr);

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
 fprintf(fp,"%s",local_legend[30]);
 fprintf(fp,"             -%4.4s : %3d",local_legend[1], page_no);
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
        strncpy(hdr_line1+col,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//t_date := GET_LOCALE_DATE.GET_CURRENT_DATE (:language_id);
				//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI'); //added HH24:MI in the t_data by srinivas 
				:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
				END;
			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 23;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert\
_datetime_2t ( SYSDATE , :language_id ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1208;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
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


	
		col = (REP_WIDTH-strlen(d_sysdate1.arr))-5;
        strcpy(hdr_line1+col,d_sysdate1.arr);
       
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,d_user.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRMTRRP",14);
    strcpy(con_rep_title,local_legend[30]);
	col = (int)(REP_WIDTH-strlen(con_rep_title))/2;
    strncpy(hdr_line3+col,con_rep_title,strlen(con_rep_title));
    sprintf(buf,"%-4.4s : %4d",local_legend[1],page_no++);
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf))-4,buf);

    col = (int)(REP_WIDTH-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    fprintf(fp,"\n");
		fprintf(fp,"%s\n",hdr_line1);
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1231;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 23;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1250;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
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
		  	  FROM SY_UOM_LANG_VW
			 WHERE uom_code = :nd_test_units
			 AND   language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from SY_UOM_LANG_VW where (uom\
_code=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1269;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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



#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER


