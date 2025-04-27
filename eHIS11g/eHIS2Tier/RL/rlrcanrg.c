
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
           char  filnam[25];
};
static const struct sqlcxp sqlfpn =
{
    24,
    "d:\\speclabel\\rlrcanrg.pc"
};


static unsigned long sqlctx = 1171895923;


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
            void  *sqhstv[15];
   unsigned int   sqhstl[15];
            int   sqhsts[15];
            void  *sqindv[15];
            int   sqinds[15];
   unsigned int   sqharm[15];
   unsigned int   *sqharc[15];
   unsigned short  sqadto[15];
   unsigned short  sqtdso[15];
} sqlstm = {10,15};

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
"between NVL(:b3,A.SECTION_CODE) and NVL(:b4,A.SECTION_CODE)) and NVL(A.CANCE\
LLED_YN,'N')<>'Y') and NVL(A.STATUS,'O') in ('R','P')) and NVL(cancer_register\
_yn,'N')='Y') and NVL(hide_text_yn,'N')<>'Y') and :b14='Y') order by 5,1      \
      ";

 static const char *sq0013 = 
"select result_text  from RL_RESULT_TEXT where (((((((patient_id=:b0 and spec\
imen_no=:b1) and GROUP_TEST_CODE=:b2) and TEST_CODE=:b3) and operating_facilit\
y_id=:b4) and NVL(cancer_register_yn,'N')='Y') and NVL(hide_text_yn,'N')<>'Y')\
 and 'Y'=DECODE(:b5,null ,'Y',:b6))           ";

 static const char *sq0012 = 
"select SNOMED_CODE ,SNOMED_CODE_2 ,SNOMED_MARKER_CODE_1 ,SNOMED_MARKER_CODE_\
2  from RL_RESULT_SNOMED where (((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and TE\
ST_CODE=:b2) and GROUP_TEST_CODE=:b3) and OPERATING_FACILITY_ID=:b4) and (deco\
de(:b5,null ,'N',:b6)=DECODE(:b6,'Y','Y','N') or decode(:b8,null ,'N',:b6)=DEC\
ODE(:b6,'Y','Y','N')))           ";

 static const char *sq0059 = 
"select long_desc  from rl_anatomy_site_code_lang_vw A ,rl_sample_details AN \
where ((((AN.specimen_no=:b0 and AN.operating_facility_id=:b1) and A.anatomy_s\
ite_code=AN.anatomy_site_code) and AN.test_code=:b2) and A.language_id=:b3)   \
        ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,253,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,29,271,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,277,0,0,0,0,0,1,0,
66,0,0,4,229,0,4,289,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
125,0,0,5,91,0,2,333,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
148,0,0,6,0,0,32,341,0,0,0,0,0,1,0,
163,0,0,7,120,0,6,351,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
186,0,0,8,136,0,6,366,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
209,0,0,9,197,0,4,390,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,
248,0,0,10,0,0,32,410,0,0,0,0,0,1,0,
263,0,0,11,2286,0,9,540,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
338,0,0,14,0,0,32,548,0,0,0,0,0,1,0,
353,0,0,13,278,0,9,557,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
396,0,0,15,0,0,32,562,0,0,0,0,0,1,0,
411,0,0,13,0,0,15,570,0,0,0,0,0,1,0,
426,0,0,16,0,0,32,575,0,0,0,0,0,1,0,
441,0,0,12,343,0,9,584,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
500,0,0,17,0,0,32,589,0,0,0,0,0,1,0,
515,0,0,12,0,0,15,597,0,0,0,0,0,1,0,
530,0,0,18,0,0,32,602,0,0,0,0,0,1,0,
545,0,0,19,100,0,6,998,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
568,0,0,20,148,0,6,1078,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
595,0,0,21,148,0,6,1094,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
622,0,0,22,156,0,6,1118,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
645,0,0,23,255,0,4,1190,0,0,8,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
692,0,0,24,0,0,32,1210,0,0,0,0,0,1,0,
707,0,0,25,108,0,4,1225,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
738,0,0,26,0,0,32,1237,0,0,0,0,0,1,0,
753,0,0,27,108,0,4,1252,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
784,0,0,28,0,0,32,1264,0,0,0,0,0,1,0,
799,0,0,29,125,0,4,1277,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
830,0,0,30,0,0,32,1289,0,0,0,0,0,1,0,
845,0,0,31,125,0,4,1302,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
876,0,0,32,0,0,32,1314,0,0,0,0,0,1,0,
891,0,0,33,102,0,4,1331,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
918,0,0,34,0,0,32,1343,0,0,0,0,0,1,0,
933,0,0,35,102,0,4,1357,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
960,0,0,36,0,0,32,1369,0,0,0,0,0,1,0,
975,0,0,11,0,0,13,1386,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,
1050,0,0,37,0,0,32,1440,0,0,0,0,0,1,0,
1065,0,0,13,0,0,13,1449,0,0,1,0,0,1,0,2,9,0,0,
1084,0,0,38,0,0,32,1471,0,0,0,0,0,1,0,
1099,0,0,12,0,0,13,1490,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1130,0,0,39,0,0,32,1518,0,0,0,0,0,1,0,
1145,0,0,40,138,0,4,1536,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1176,0,0,41,0,0,32,1549,0,0,0,0,0,1,0,
1191,0,0,42,142,0,4,1566,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1222,0,0,43,154,0,4,1577,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1253,0,0,44,124,0,4,1587,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1280,0,0,45,0,0,32,1599,0,0,0,0,0,1,0,
1295,0,0,46,0,0,32,1697,0,0,0,0,0,1,0,
1310,0,0,47,98,0,4,1708,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1337,0,0,48,322,0,4,1747,0,0,11,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1396,0,0,49,0,0,32,1773,0,0,0,0,0,1,0,
1411,0,0,50,222,0,4,1805,0,0,8,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,1,9,0,0,
1458,0,0,51,0,0,32,1829,0,0,0,0,0,1,0,
1473,0,0,52,57,0,4,1855,0,0,1,0,0,1,0,2,9,0,0,
1492,0,0,53,100,0,4,1858,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,4,0,0,
1519,0,0,54,99,0,4,1888,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1546,0,0,55,131,0,4,2005,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,
1585,0,0,56,133,0,4,2086,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,
1624,0,0,57,110,0,4,2158,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1655,0,0,58,94,0,4,2177,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1682,0,0,59,240,0,9,2205,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1713,0,0,59,0,0,13,2210,0,0,1,0,0,1,0,2,9,0,0,
1732,0,0,59,0,0,15,2226,0,0,0,0,0,1,0,
1747,0,0,60,116,0,4,2231,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1774,0,0,61,0,0,32,2245,0,0,0,0,0,1,0,
1789,0,0,62,89,0,4,2257,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1816,0,0,63,101,0,6,2282,0,0,1,1,0,1,0,2,3,0,0,
1835,0,0,64,49,0,4,2296,0,0,1,0,0,1,0,2,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	         : rlrcanrg.pc
   Author        : Robert Joseph
   Date Created  : 10/01/2005
   
*  Ver 4.1
     
*  Purpose : To generate a report for CANCER REGISTER

*  Input Parameters : 
                      Command line inputs
				      1. Usr_id/Password
            
			          2. Session id
				      3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4. SNOMED CODE. 
					  5.Include text Search
                      5. Range of Process Dates 
  
*  Table Accessed :   RL_RESULT_SNOMED, RL_REQUEST_HEADER,RL_RESULT_TEXT
		      PATIENT MASTERS,Sample_Details.
		   
*  Output File : rlrcanrg.lis
*  MODIFIED BY           MODIFIED ON       REASON			                  
*  Gopikannan P			 10/02/2015		   Changed the SPECIMEN_REGISTER Cursor for 
*										   SNOMED Filter at Cancer Register against Bru-HIMS-CRF-440.
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <gl.h>

#define MAX_LINES 42
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
//#define VER  "VER : 1.10.01\n"
#define REP_WIDTH 128
#define REP_TITLE "CANCER REGISTER"
#define VER  "VER : 4.10\n"

/*
#define DEBUG 1 */

#define ESC     0x1B
/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR	    nd_operating_facility_id   [3],
	            uid_pwd		               [91],
                nd_file_name               [151],
				nd_pgm_id					[9],  
                nd_user	                   [15],
                nd_file_no                 [15],
                nd_printer_name            [16],

				d_version_no			   [20],
				d_version  			       [20],


                /o Variables to recieve data from specimen register cursoro/ 
                    d_temp_spec_date             [41],
					d_specimen_type_code         [11],
                    d_spec_month                 [21],
                    d_spec_year                  [21],
                    d_temp_spec_month            [21],
                    d_temp_spec_year             [21],
					d_source_code                [21],/oAdded by Nandhinio/
					d_source_type                [21],/oAdded by Nandhinio/
					d_source_desc                [200],/oAdded by Nandhinio/
				t_specimen_no                [21],
		        d_specimen_no                [21],
				l_specimen_no		 [21],
				d_patient_id             [21],
				d_snomed_code			[21],
				d_description_1			[651],
				d_snomed_code_2			[21],
				d_description_2			[651],
				d_snomed_marker_code_1	[2],
				d_snomed_marker_code_2	[2],
				d_spec_regd_date_time   [21],
				d_spec_recd_date_time   [21],
				d_group_test_code		[11],
				t_test_code				[11],
				d_test_code				[11],
				d_test_desc				[101],
				d_episode_type          [2],
				d_category_number		[41],

				d_patient_name          [240],
				d_patient_name_1		[240],
				d_patient_name_2		[240],
				d_patient_name_3		[240],
				d_patient_name_4		[240],
				d_national_id			[21],
				d_ip_national_id_num	[21],
				d_alternate_id			[21],
				d_actual_dob_yn			[2],
				d_dob                   [11],
				d_date_of_birth			[21],
				d_sex                   [2],
				d_race_code				[5],
				d_race					[16],	
				d_location				[11],
				d_ref_source			[11],
				d_ref_desc				[31],
				d_status				[5],
				d_anatomy_site_code     [5],
				d_anatomy_site			[61],
				l_translated_value		 [100],
		       language_id			[5],


				/o Variables to recieve data from result text cursoro/ 
				d_result_text			[2001],
			
				/o Variables to recieve data for signed electronicallyo/ 
				d_released_by_id		[31],
				d_released_date		    [21],
				d_section_code			[2],
				d_reviewed_by_id		[31],
				d_reviewed_date			[21],

				/o Variables to get user names from SY_USER table, added 23.10.2002 srinivaso/
				d_releasedby_name       [61],
				d_reviewedby_name       [61],
				
				/o Variables to get name on report yn flag from RL_USER_DEPT table, added 23.10.2002 srinivaso/
				d_name_on_report1       [2],
				d_name_on_report2       [2],
 


                /o input parameters to main()   o/
                nd_session_id      	[16],
				nd_pgm_date	   	[20],
	
				/o input parameters through from SY_PROG_PARAM o/
 				nd_snomed_code          [21], 
 				nd_snomed_marker_code	[2],
				nd_fr_process_date    	[21],
 				nd_fr_process_date_con   	[21],
				nd_to_process_date    	[21],
				nd_to_process_date_con    	[21],
	            nd_dept                 [2],
                t_section_code          [4],  /o to perform section break o/
				d_sample_anatomy_ind    [4],  
                t_section_desc          [41],
				nd_fr_dept				[2],
				nd_to_dept				[2],
				nd_res_search			[2],
					d_alt_id1_reqd_yn[2],
					d_alt_id2_reqd_yn[2],
					d_alt_id3_reqd_yn[2],
					d_alt_id4_reqd_yn[2],
					d_alt_id_num  [41],
					d_alt_id_num1 [41],
					d_alt_id_num2 [41],
					d_alt_id_num3 [41],
					d_alt_id_num4 [41],
					d_alt_id_oth  [41],

        		/o for header routine o/
				//d_acc_entity_name        [61],
				d_acc_entity_name        [300],
				d_user                   [31],
				d_sysdate                [20],
				d_sysdate1                [20],
				d_lab_title_2            [101]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[15]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_printer_name;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[41]; } d_temp_spec_date;

struct { unsigned short len; unsigned char arr[11]; } d_specimen_type_code;

struct { unsigned short len; unsigned char arr[21]; } d_spec_month;

struct { unsigned short len; unsigned char arr[21]; } d_spec_year;

struct { unsigned short len; unsigned char arr[21]; } d_temp_spec_month;

struct { unsigned short len; unsigned char arr[21]; } d_temp_spec_year;

struct { unsigned short len; unsigned char arr[21]; } d_source_code;

struct { unsigned short len; unsigned char arr[21]; } d_source_type;

struct { unsigned short len; unsigned char arr[200]; } d_source_desc;

struct { unsigned short len; unsigned char arr[21]; } t_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } l_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_snomed_code;

struct { unsigned short len; unsigned char arr[651]; } d_description_1;

struct { unsigned short len; unsigned char arr[21]; } d_snomed_code_2;

struct { unsigned short len; unsigned char arr[651]; } d_description_2;

struct { unsigned short len; unsigned char arr[2]; } d_snomed_marker_code_1;

struct { unsigned short len; unsigned char arr[2]; } d_snomed_marker_code_2;

struct { unsigned short len; unsigned char arr[21]; } d_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[21]; } d_spec_recd_date_time;

struct { unsigned short len; unsigned char arr[11]; } d_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } t_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[101]; } d_test_desc;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[41]; } d_category_number;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_1;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_2;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_3;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_4;

struct { unsigned short len; unsigned char arr[21]; } d_national_id;

struct { unsigned short len; unsigned char arr[21]; } d_ip_national_id_num;

struct { unsigned short len; unsigned char arr[21]; } d_alternate_id;

struct { unsigned short len; unsigned char arr[2]; } d_actual_dob_yn;

struct { unsigned short len; unsigned char arr[11]; } d_dob;

struct { unsigned short len; unsigned char arr[21]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[5]; } d_race_code;

struct { unsigned short len; unsigned char arr[16]; } d_race;

struct { unsigned short len; unsigned char arr[11]; } d_location;

struct { unsigned short len; unsigned char arr[11]; } d_ref_source;

struct { unsigned short len; unsigned char arr[31]; } d_ref_desc;

struct { unsigned short len; unsigned char arr[5]; } d_status;

struct { unsigned short len; unsigned char arr[5]; } d_anatomy_site_code;

struct { unsigned short len; unsigned char arr[61]; } d_anatomy_site;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;

struct { unsigned short len; unsigned char arr[2001]; } d_result_text;

struct { unsigned short len; unsigned char arr[31]; } d_released_by_id;

struct { unsigned short len; unsigned char arr[21]; } d_released_date;

struct { unsigned short len; unsigned char arr[2]; } d_section_code;

struct { unsigned short len; unsigned char arr[31]; } d_reviewed_by_id;

struct { unsigned short len; unsigned char arr[21]; } d_reviewed_date;

struct { unsigned short len; unsigned char arr[61]; } d_releasedby_name;

struct { unsigned short len; unsigned char arr[61]; } d_reviewedby_name;

struct { unsigned short len; unsigned char arr[2]; } d_name_on_report1;

struct { unsigned short len; unsigned char arr[2]; } d_name_on_report2;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[21]; } nd_snomed_code;

struct { unsigned short len; unsigned char arr[2]; } nd_snomed_marker_code;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_process_date;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_process_date_con;

struct { unsigned short len; unsigned char arr[21]; } nd_to_process_date;

struct { unsigned short len; unsigned char arr[21]; } nd_to_process_date_con;

struct { unsigned short len; unsigned char arr[2]; } nd_dept;

struct { unsigned short len; unsigned char arr[4]; } t_section_code;

struct { unsigned short len; unsigned char arr[4]; } d_sample_anatomy_ind;

struct { unsigned short len; unsigned char arr[41]; } t_section_desc;

struct { unsigned short len; unsigned char arr[2]; } nd_fr_dept;

struct { unsigned short len; unsigned char arr[2]; } nd_to_dept;

struct { unsigned short len; unsigned char arr[2]; } nd_res_search;

struct { unsigned short len; unsigned char arr[2]; } d_alt_id1_reqd_yn;

struct { unsigned short len; unsigned char arr[2]; } d_alt_id2_reqd_yn;

struct { unsigned short len; unsigned char arr[2]; } d_alt_id3_reqd_yn;

struct { unsigned short len; unsigned char arr[2]; } d_alt_id4_reqd_yn;

struct { unsigned short len; unsigned char arr[41]; } d_alt_id_num;

struct { unsigned short len; unsigned char arr[41]; } d_alt_id_num1;

struct { unsigned short len; unsigned char arr[41]; } d_alt_id_num2;

struct { unsigned short len; unsigned char arr[41]; } d_alt_id_num3;

struct { unsigned short len; unsigned char arr[41]; } d_alt_id_num4;

struct { unsigned short len; unsigned char arr[41]; } d_alt_id_oth;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate1;

struct { unsigned short len; unsigned char arr[101]; } d_lab_title_2;

	

/*  For Patient Age SYSDATE, MTHS amjad 27/7/2002*/
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
    int l_count = 0, l_tot_cases = 0;

	int  l_tab_exists;
	int i;
char local_legend[100][100];
char REP_TITLE1[100];


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
int	  l_len = 30;
char  l_delimeter;
/* summary fields for calculating No. of records */ 
int   nd_totl_specimens;

void print_page_header();
void print_col_heading();


int ctr = 0,  len = 0;
int r_ctr = 0;
char l_string[300];
char cl_string[300];


FILE *f1;
char string_var[100] ;


void print_separator(int rep_line)
{
int i;
for (i=0;(i <= rep_line);i++)
fprintf(f1,"-");
//fprintf(f1,"\n");
next_line(1); 
//line_no++;	
	
}


void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	    get_header_dtls(),
  	    dclr_specimen_register(),
  	    do_report();
	
	strcpy(nd_pgm_id.arr, argv[0]);
	nd_pgm_id.len = strlen(nd_pgm_id.arr); 
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
	strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	get_legend_value(27);//Added by Nandhini against CRF ML-MMOH-0585
	
   get_params();
   gen_file_name();

		 fprintf(f1,"%c&l1O",ESC); /* Set Landscape*/ 
		fprintf(f1,"%c(s12H",ESC); 
   get_header_dtls();
   dclr_specimen_register();
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


/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT 
                   OPERATING_FACILITY_ID,
				   PARAM1,
		           PARAM2,
		           PARAM3,
		           PARAM4,
				   PARAM5,
				   PARAM6,
				   PARAM7,
				   PARAM8
            INTO 
			     :nd_operating_facility_id,
			     :nd_snomed_code, 
                 :nd_fr_process_date,
                 :nd_to_process_date,
				 :nd_dept,
				 :nd_snomed_marker_code,
				 :nd_fr_dept,
				 :nd_to_dept,
				 :nd_res_search
            FROM SY_PROG_PARAM
	    WHERE   PGM_ID = 'RLRCANRG'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  f\
rom SY_PROG_PARAM where ((PGM_ID='RLRCANRG' and SESSION_ID=TO_NUMBER(:b9)) and\
 PGM_DATE=:b10)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_snomed_code;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fr_process_date;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_process_date;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_dept;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_snomed_marker_code;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fr_dept;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_dept;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_res_search;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[10] = (unsigned int  )22;
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



   nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
   nd_snomed_code.arr[nd_snomed_code.len]				= '\0';
   nd_fr_process_date.arr[nd_fr_process_date.len]		= '\0';
   nd_to_process_date.arr[nd_to_process_date.len]		= '\0';
   nd_snomed_marker_code.arr[nd_snomed_marker_code.len] = '\0';
   nd_fr_dept.arr[nd_fr_dept.len]						= '\0';
   nd_to_dept.arr[nd_to_dept.len]						= '\0';
   nd_res_search.arr[nd_res_search.len]					= '\0';


  #ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf("nd_snomed_code: %s\n", nd_snomed_code.arr);
   printf("nd_fr_process_date :%s\n", nd_fr_process_date.arr);
   printf("nd_to_process_date : %s\n", nd_to_process_date.arr);
  #endif

  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE PGM_ID = 'RLRCANRG'
	         AND SESSION_ID = :nd_session_id
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='RLRCANRG' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )125;
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
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )148;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_params() occured....\n");
   proc_exit();
}
 
/************get_legend_value*******************/
get_legend_value(int cou)
 {
     
   
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRCANRG.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRCANRG.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )163;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRCANRG.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRCANRG.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )186;
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

	//disp_message(ERR_MESG,l_translated_value.arr);

	strcpy(local_legend[i],l_translated_value.arr);

	

	}
	

 }
/**********END****************88/

/* get the header details */
void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT A.ACC_ENTITY_NAME, /o description of the institution o/
		           USER,
		           TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI'),
		           B.lab_title_2
	        INTO :d_acc_entity_name,
		         :d_user,
		         :d_sysdate,
		         :d_lab_title_2
            FROM SY_ACC_ENTITY_LANG_VW A, rl_param B
            WHERE A.ACC_ENTITY_ID = :nd_operating_facility_id
			AND   A.LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select A.ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYY\
Y HH24:MI') ,B.lab_title_2 into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY_LANG_VW A \
,rl_param B where (A.ACC_ENTITY_ID=:b4 and A.LANGUAGE_ID=:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )209;
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
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_lab_title_2;
   sqlstm.sqhstl[3] = (unsigned int  )103;
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
   sqlstm.sqhstv[5] = (         void  *)&language_id;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )248;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}

 

/* function declares SPECIMEN_REGISTER cursor */
void dclr_specimen_register()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



/********************/

  /* EXEC SQL DECLARE SPECIMEN_REGISTER CURSOR FOR
  	 SELECT A.SPEC_REGD_DATE_TIME, A.SPECIMEN_TYPE_CODE,
	        TO_CHAR(A.SPEC_REGD_DATE_TIME, 'MON'),
              TO_CHAR(A.SPEC_REGD_DATE_TIME,'YYYY'),
              A.SECTION_CODE,A.SPECIMEN_NO,A.PATIENT_ID,
			  A.CATEGORY_CODE||'-'||A.CATEGORY_YEAR||'-'||A.CATEGORY_NUMBER,
    	    TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),
    	    TO_CHAR(A.SPEC_RECD_DATE_TIME,'DD/MM/YYYY'),
	        B.GROUP_TEST_CODE, B.TEST_CODE,A.EPISODE_TYPE,A.SOURCE_TYPE,A.SOURCE_CODE/o Added by Nandhini o/
     FROM   RL_REQUEST_HEADER A, RL_RESULT_SNOMED B 
     WHERE  A.PATIENT_ID  = B.PATIENT_ID 
     AND    A.SPECIMEN_NO = B.SPECIMEN_NO  
	 AND    A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID  
	 AND    B.OPERATING_FACILITY_ID = :nd_operating_facility_id
     AND    TO_DATE(TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),'DD/MM/YYYY') 
            >=  TO_DATE(:nd_fr_process_date,'DD/MM/YYYY')
     AND    TO_DATE(TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),'DD/MM/YYYY') 
            <=  TO_DATE(:nd_to_process_date,'DD/MM/YYYY') 
	 AND	A.SECTION_CODE BETWEEN NVL(:nd_fr_dept,A.SECTION_CODE)
	        AND NVL(:nd_to_dept,A.SECTION_CODE)
	 AND    NVL(A.CANCELLED_YN,'N') != 'Y' 
	 AND    NVL(A.STATUS,'O') IN ('R','P')
	/o 	Commented against Bru-HIMS-CRF-440 by Gopikannan P *****
	AND    ((NVL(B.SNOMED_CODE, '!') = NVL(:nd_snomed_code, '!!') OR
	          NVL(B.SNOMED_CODE_2, '!') = NVL(:nd_snomed_code, '!!') 
			 )
			 OR(NVL(B.SNOMED_MARKER_CODE_1,'!') = NVL(:nd_snomed_marker_code, '!!') OR
			    NVL(B.SNOMED_MARKER_CODE_2,'!') = NVL(:nd_snomed_marker_code, '!!')
			   )
			)
	o/		
	/o 	Added by Gopikannan P against Bru-HIMS-CRF-440  ****o/
	AND    ((NVL(B.SNOMED_CODE, '!') = NVL(:nd_snomed_code, B.SNOMED_CODE) OR
	          NVL(B.SNOMED_CODE_2, '!') = NVL(:nd_snomed_code, B.SNOMED_CODE_2) 
			 )
			 AND(NVL(B.SNOMED_MARKER_CODE_1,'!') = NVL(:nd_snomed_marker_code, B.SNOMED_MARKER_CODE_1) OR
			    NVL(B.SNOMED_MARKER_CODE_2,'!') = NVL(:nd_snomed_marker_code, B.SNOMED_MARKER_CODE_2)
			   )
			)				
	 /o*
	 AND    ( decode(:nd_snomed_code,null,'N',:nd_res_search) = DECODE(:nd_res_search,'Y','Y','N')
	  OR    decode(:nd_snomed_marker_code,null,'N',:nd_res_search) = DECODE(:nd_res_search,'Y','Y','N'))
	 AND    (( nvl(B.SNOMED_CODE,'x') = DECODE(:nd_res_search,'Y',nvl(:nd_snomed_code,'Y'), nvl(:nd_snomed_code,nvl(B.SNOMED_CODE,'x')))
     AND    nvl(B.SNOMED_MARKER_CODE_1,'y') = nvl(:nd_snomed_marker_code,nvl(B.SNOMED_MARKER_CODE_1,'y'))
	 AND    decode(:nd_snomed_marker_code,null,'N',:nd_res_search)=DECODE(:nd_res_search,'Y','Y','N'))
	        OR 
			(nvl(B.SNOMED_CODE_2,'x') = nvl(:nd_snomed_code,nvl(B.SNOMED_CODE_2,'x')) AND nvl(B.SNOMED_MARKER_CODE_2,'y') = nvl(:nd_snomed_marker_code,nvl(B.SNOMED_MARKER_CODE_2,'y'))
			)
		    )
	 *o/
    UNION
     SELECT A.SPEC_REGD_DATE_TIME, A.SPECIMEN_TYPE_CODE,
	          TO_CHAR(A.SPEC_REGD_DATE_TIME, 'MON'),
              TO_CHAR(A.SPEC_REGD_DATE_TIME,'YYYY'),
              A.SECTION_CODE,A.SPECIMEN_NO,A.PATIENT_ID,
			  A.CATEGORY_CODE||'-'||A.CATEGORY_YEAR||'-'||A.CATEGORY_NUMBER,
    	    TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),
    	    TO_CHAR(A.SPEC_RECD_DATE_TIME,'DD/MM/YYYY'),
	        B.GROUP_TEST_CODE, B.TEST_CODE, A.EPISODE_TYPE,A.SOURCE_TYPE,A.SOURCE_CODE/o Added by Nandhini o/
     FROM   RL_REQUEST_HEADER A, RL_RESULT_TEXT B 
     WHERE  A.PATIENT_ID  = B.PATIENT_ID 
     AND    A.SPECIMEN_NO = B.SPECIMEN_NO  
	 AND    A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID  
	 AND    B.OPERATING_FACILITY_ID = :nd_operating_facility_id
     AND    TO_DATE(TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),'DD/MM/YYYY') 
            >=  TO_DATE(:nd_fr_process_date,'DD/MM/YYYY')
     AND    TO_DATE(TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),'DD/MM/YYYY') 
            <=  TO_DATE(:nd_to_process_date,'DD/MM/YYYY') 
	 AND	A.SECTION_CODE BETWEEN NVL(:nd_fr_dept,A.SECTION_CODE)
	 AND    NVL(:nd_to_dept,A.SECTION_CODE)
	 AND    NVL(A.CANCELLED_YN,'N') != 'Y' 
	 AND    NVL(A.STATUS,'O') IN ('R','P')
	 AND    NVL(cancer_register_yn, 'N') = 'Y'
     AND    NVL(hide_text_yn, 'N') <> 'Y'
	 AND    :nd_res_search = 'Y'
       ORDER BY  5,1; */ 

	 /**
	 AND    'Y'=DECODE(:nd_snomed_code,NULL,'Y',:nd_res_search)
	 AND    'Y'=DECODE(:nd_snomed_marker_code,NULL,'Y',:nd_res_search);
	 **/
     // ORDER BY  SECTION_CODE,SPECIMEN_NO,PATIENT_ID;



/////////////////
  /* EXEC SQL DECLARE SNOMED_DETAIL CURSOR FOR
     SELECT SNOMED_CODE , SNOMED_CODE_2,
			SNOMED_MARKER_CODE_1 , SNOMED_MARKER_CODE_2
     FROM   RL_RESULT_SNOMED  
     WHERE  PATIENT_ID  = :d_patient_id
     AND    SPECIMEN_NO = :d_specimen_no
	//AND  nvl(SNOMED_CODE,'x') = nvl(:nd_snomed_code,nvl(SNOMED_CODE,'x'))
	AND    TEST_CODE	=:d_test_code    	/oadded by roberto/
	 AND  GROUP_TEST_CODE= :d_group_test_code  /oadded by roberto/
	 AND    OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND (decode(:nd_snomed_code,null,'N',:nd_res_search)=DECODE(:nd_res_search,'Y','Y','N')
	 OR decode(:nd_snomed_marker_code,null,'N',:nd_res_search)=DECODE(:nd_res_search,'Y','Y','N')); */ 

	 

/*********** upto here **************/

  /* EXEC SQL DECLARE  RESULT_TEXT CURSOR FOR
			SELECT result_text
			FROM   RL_RESULT_TEXT
            WHERE  patient_id		= :d_patient_id
			AND    specimen_no		= :d_specimen_no
			AND    GROUP_TEST_CODE	=  :d_group_test_code  /oadded by roberto/
			AND	   TEST_CODE		=	:d_test_code		/oadded by roberto/	  
			AND    operating_facility_id = :nd_operating_facility_id
            AND    NVL(cancer_register_yn, 'N') = 'Y'
            AND    NVL(hide_text_yn, 'N') <> 'Y' 
			and     'Y'=DECODE(:nd_snomed_code,NULL,'Y',:nd_res_search); */ 
 ;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN SPECIMEN_REGISTER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select A.SPEC_REGD_DATE_TIME ,A.SPECIMEN_TYPE_CODE ,TO_CHAR(A.SPEC_REG\
D_DATE_TIME,'MON') ,TO_CHAR(A.SPEC_REGD_DATE_TIME,'YYYY') ,A.SECTION_CODE ,A\
.SPECIMEN_NO ,A.PATIENT_ID ,((((A.CATEGORY_CODE||'-')||A.CATEGORY_YEAR)||'-'\
)||A.CATEGORY_NUMBER) ,TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY') ,TO_CHAR(\
A.SPEC_RECD_DATE_TIME,'DD/MM/YYYY') ,B.GROUP_TEST_CODE ,B.TEST_CODE ,A.EPISO\
DE_TYPE ,A.SOURCE_TYPE ,A.SOURCE_CODE  from RL_REQUEST_HEADER A ,RL_RESULT_S\
NOMED B where (((((((((A.PATIENT_ID=B.PATIENT_ID and A.SPECIMEN_NO=B.SPECIME\
N_NO) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and B.OPERATING_F\
ACILITY_ID=:b0) and TO_DATE(TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),'DD/\
MM/YYYY')>=TO_DATE(:b1,'DD/MM/YYYY')) and TO_DATE(TO_CHAR(A.SPEC_REGD_DATE_T\
IME,'DD/MM/YYYY'),'DD/MM/YYYY')<=TO_DATE(:b2,'DD/MM/YYYY')) and A.SECTION_CO\
DE between NVL(:b3,A.SECTION_CODE) and NVL(:b4,A.SECTION_CODE)) and NVL(A.CA\
NCELLED_YN,'N')<>'Y') and NVL(A.STATUS,'O') in ('R','P')) and ((NVL(B.SNOMED\
_CODE,'!')=NVL(:b5,B.SNOMED_CODE) or NVL(B");
   sqlbuft((void **)0, 
     ".SNOMED_CODE_2,'!')=NVL(:b5,B.SNOMED_CODE_2)) and (NVL(B.SNOMED_MARKER\
_CODE_1,'!')=NVL(:b7,B.SNOMED_MARKER_CODE_1) or NVL(B.SNOMED_MARKER_CODE_2,'\
!')=NVL(:b7,B.SNOMED_MARKER_CODE_2)))) union select A.SPEC_REGD_DATE_TIME ,A\
.SPECIMEN_TYPE_CODE ,TO_CHAR(A.SPEC_REGD_DATE_TIME,'MON') ,TO_CHAR(A.SPEC_RE\
GD_DATE_TIME,'YYYY') ,A.SECTION_CODE ,A.SPECIMEN_NO ,A.PATIENT_ID ,((((A.CAT\
EGORY_CODE||'-')||A.CATEGORY_YEAR)||'-')||A.CATEGORY_NUMBER) ,TO_CHAR(A.SPEC\
_REGD_DATE_TIME,'DD/MM/YYYY') ,TO_CHAR(A.SPEC_RECD_DATE_TIME,'DD/MM/YYYY') ,\
B.GROUP_TEST_CODE ,B.TEST_CODE ,A.EPISODE_TYPE ,A.SOURCE_TYPE ,A.SOURCE_CODE\
  from RL_REQUEST_HEADER A ,RL_RESULT_TEXT B where (((((((((((A.PATIENT_ID=B\
.PATIENT_ID and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.OPERATING_FACILITY_ID=B.O\
PERATING_FACILITY_ID) and B.OPERATING_FACILITY_ID=:b0) and TO_DATE(TO_CHAR(A\
.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),'DD/MM/YYYY')>=TO_DATE(:b1,'DD/MM/YYYY'))\
 and TO_DATE(TO_CHAR(A.SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),'DD/MM/YYYY')<=TO_D\
ATE(:b2,'DD/MM/YYYY')) and A.SECTION_CODE ");
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )263;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_process_date;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_process_date;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fr_dept;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_dept;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_snomed_code;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_snomed_marker_code;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_snomed_marker_code;
   sqlstm.sqhstl[8] = (unsigned int  )4;
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
   sqlstm.sqhstv[10] = (         void  *)&nd_fr_process_date;
   sqlstm.sqhstl[10] = (unsigned int  )23;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_to_process_date;
   sqlstm.sqhstl[11] = (unsigned int  )23;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_fr_dept;
   sqlstm.sqhstl[12] = (unsigned int  )4;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_to_dept;
   sqlstm.sqhstl[13] = (unsigned int  )4;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_res_search;
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


  #ifdef DEBUG
    printf("leaving dclr_specimen_register()\n");
  #endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )338;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_specimen_register() occured....\n");
   proc_exit();
}


void open_result_text_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN RESULT_TEXT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0013;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )353;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
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
   sqlstm.sqhstv[2] = (         void  *)&d_group_test_code;
   sqlstm.sqhstl[2] = (unsigned int  )13;
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
   sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_res_search;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )396;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at open_result_text_cur() occured....\n");
   proc_exit();
}

void close_result_text_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CLOSE RESULT_TEXT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )411;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
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


   disp_message(ORA_MESG,"Oracle error at close_result_text_cur() occured....\n");
   proc_exit();
}

void open_snomed_result_cur()
{

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN SNOMED_DETAIL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )441;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
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
   sqlstm.sqhstv[2] = (         void  *)&d_test_code;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_group_test_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
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
   sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_res_search;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_res_search;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_snomed_marker_code;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_res_search;
   sqlstm.sqhstl[9] = (unsigned int  )4;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_res_search;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )500;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at open_snomed_result_cur() occured....\n");
   proc_exit();
}

void close_snomed_result_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CLOSE SNOMED_DETAIL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )515;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )530;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at close_snomed_result_cur() occured....\n");
   proc_exit();
}



/* prints the master-detail record until the cursor is empty */
void do_report()
{


  void get_anatomy_site();
  void prepare_new_page();
  void print_pat_rec();
  void get_snomed_desc1(),
	   get_snomed_desc2();
  void get_signed_dtls();
  void get_releasedby_name();
  void get_reviewedby_name();
  void get_name_on_report1();
  void get_name_on_report2();
  void check_end_of_page(int);
  void end_report();
  void get_section_desc();
  void print_rep_header();

  int   pat_rec_printed,
        result_text_printed,
        snomed_codes_printed,
	    l_1st_snomed_printed;


  int fetch_specimen_register();
  int fetch_result_text();
  int fetch_snomed_result_cur();

  int still_rec_left;
  int still_res_text_left;

  //page_no ++;
  print_rep_header();

  //prepare_new_page();  

  /* read the first cursor record */
  

  still_rec_left = fetch_specimen_register();
  get_section_desc();

  pat_rec_printed			= 0;
  result_text_printed		= 0;
  snomed_codes_printed		= 0;
  l_1st_snomed_printed		= 0;


  while(still_rec_left)
  {
  
    if (pat_rec_printed == 0)
    {
      if ( ( strcmp(t_section_code.arr,nd_dept.arr) != 0) ||
           (strcmp(d_temp_spec_month.arr,d_spec_month.arr) != 0) ||
           (strcmp(d_temp_spec_year.arr,d_spec_year.arr) != 0) )
      {

        if ( (strcmp(t_section_code.arr,nd_dept.arr) != 0) )
		{
		  get_section_desc();
		}
		strcpy(t_section_code.arr,nd_dept.arr);
        t_section_code.len = strlen(nd_dept.arr);
        strcpy(d_temp_spec_month.arr,d_spec_month.arr);
        d_temp_spec_month.len = strlen(d_temp_spec_month.arr);
        strcpy(d_temp_spec_year.arr,d_spec_year.arr);
        d_temp_spec_year.len = strlen(d_temp_spec_year.arr);

//        next_line(6);
		print_separator(REP_WIDTH);
		next_page();
//        print_page_header();
//        line_no=line_no+6;
      }
	  strcpy(l_specimen_no.arr,d_specimen_no.arr);
	  l_specimen_no.len = strlen(d_specimen_no.arr);

      //check_end_of_page(7);
      next_line(1);
      line_no=line_no+1;
      print_pat_rec(); 
	  
      //get_signed_dtls();
      //get_releasedby_name();
      //get_reviewedby_name();
      get_name_on_report1();
      get_name_on_report2();
      pat_rec_printed		= 1;
      l_tot_cases = l_tot_cases + 1;
	}

/* -- Start -- Added by Sai Dutt on 21.01.2006 */

	if ( (strcmp(t_specimen_no.arr, d_specimen_no.arr) == 0) && (strcmp(t_test_code.arr,d_test_code.arr) != 0) )
    {
	  fprintf(f1,"%-11.11s%-26.26s", " ", " ");

    }

    if ( (strcmp(t_specimen_no.arr, d_specimen_no.arr) != 0) || (strcmp(t_test_code.arr,d_test_code.arr) != 0) )
    {
      strcpy(t_test_code.arr, d_test_code.arr);
      t_test_code.len = strlen(t_test_code.arr);
      get_test_desc();
      fprintf(f1,"%-41.41s%-41.41s", d_test_desc.arr, d_anatomy_site.arr);
    }

      strcpy(t_specimen_no.arr, d_specimen_no.arr);
      t_specimen_no.len = strlen(t_specimen_no.arr);


/* -- End -- Added by Sai Dutt on 21.01.2006 */
//-------------------To get The Result Text----------------------------------------------------

    if (result_text_printed == 0) 
    {
      open_result_text_cur();
      still_res_text_left = fetch_result_text();
	
      // fprintf(f1,"\n");
      //next_line(2);	
      while(still_res_text_left)
      {
        ctr = 0;
        r_ctr = 0;
        len = strlen(d_result_text.arr);
        split_text(d_result_text.arr, 100, cl_string, &r_ctr);
//					split_text(d_result_text.arr, 75, cl_string, &r_ctr);
        //check_end_of_page(1);
        next_line(1);
        fprintf(f1,"%4s%s"," ",cl_string);
//		fprintf(f1,"%50s%s"," ",cl_string);
        //	line_no++;
					 
        strcpy(cl_string,"");   
        while(r_ctr < len)
        {	

          split_text(d_result_text.arr, 100, cl_string, &r_ctr);
//		  split_text(d_result_text.arr, 75, cl_string, &r_ctr);
          //check_end_of_page(1);
          next_line(1);
          fprintf(f1,"%4s%s"," ",cl_string);  
//		  fprintf(f1,"%50s%s"," ",cl_string);  
          strcpy(cl_string,"");  
          //line_no++;
        }
        //line_no++;
        //next_line(1); 
        still_res_text_left = fetch_result_text();
      }
      result_text_printed = 1;
      close_result_text_cur();
      //check_end_of_page(5);
      //next_line(1); 
//      fprintf(f1,"%37s"," ");
      //line_no++;
    }

//-------------------------To Get The Snomed Text-------------------------------------------------


    while (still_rec_left)
    {

       open_snomed_result_cur();
       if (strcmp(l_specimen_no.arr,d_specimen_no.arr) == 0)
       {
         while(fetch_snomed_result_cur())  
         {
           get_snomed_desc1();
           get_snomed_desc2();
           if (snomed_codes_printed	== 0)
           {
             if (l_1st_snomed_printed == 0)				
             {
               l_1st_snomed_printed = 1;
               //check_end_of_page(5);
               next_line(1);
               fprintf(f1,"%4s%20s  :"," ",d_snomed_code.arr); 
//             fprintf(f1,"%40s%20s  :"," ",d_snomed_code.arr); 
//	02.11.2002				fprintf(f1,"%s\n",d_description_1.arr);
/////////////////////////////////////////////////added 02.11.2002
               ctr = 0;
               r_ctr = 0;
               len = strlen(d_description_1.arr);

               split_text(d_description_1.arr, 100, cl_string, &r_ctr);
//			   split_text(d_description_1.arr, 75, cl_string, &r_ctr);
               //check_end_of_page(1);
               //next_line(1);
               fprintf(f1,"%s",cl_string);
               //line_no++;
							 
               strcpy(cl_string,"");   
               while(r_ctr < len)
               {	
                 split_text(d_description_1.arr, 100, cl_string, &r_ctr);
//				 split_text(d_description_1.arr, 75, cl_string, &r_ctr);

                 //check_end_of_page(1);
                 next_line(1);
                 fprintf(f1,"%4s%s"," ",cl_string);  
//				 fprintf(f1,"%40s%s"," ",cl_string);  
                 strcpy(cl_string,"");  
                 //line_no++;
               }
////////////////////////////////////////////////
               if(strlen(d_snomed_code_2.arr) > 0)
               {
                 next_line(1);
                 fprintf(f1,"%4s%20s  :"," ",d_snomed_code_2.arr);
//				 fprintf(f1,"%40s%20s  :"," ",d_snomed_code_2.arr);
//		02.11.2002			  fprintf(f1,"%s\n",d_description_2.arr);
///////////////////////////////////////////////// added 02.11.2002
                 ctr = 0;
                 r_ctr = 0;
                 len = strlen(d_description_2.arr);
                 split_text(d_description_2.arr, 100, cl_string, &r_ctr);
//				 split_text(d_description_2.arr, 75, cl_string, &r_ctr);
                 //check_end_of_page(1);
                 //next_line(1);
                 fprintf(f1,"%s",cl_string);
                 //line_no++;
                 //next_line(1); 
                 strcpy(cl_string,"");   
                 while(r_ctr < len)
                 {	
                   split_text(d_description_2.arr, 100, cl_string, &r_ctr);
//				   split_text(d_description_2.arr, 75, cl_string, &r_ctr);
                   //check_end_of_page(1);
                   next_line(1);
                   fprintf(f1,"%4s%s"," ",cl_string);  
//				   fprintf(f1,"%50s%s"," ",cl_string);  
                   strcpy(cl_string,"");  
                   //line_no++;
                   //next_line(1); 
                 }
////////////////////////////////////////////////
               }
               //line_no +=5;
               //	next_line(1); 
             }
             else
             {
               next_line(1); 
               //check_end_of_page(4);
               fprintf(f1,"%4s%20s  :"," ",d_snomed_code.arr);
//			   fprintf(f1,"%40s%20s  :"," ",d_snomed_code.arr);
//							fprintf(f1,"%s\n",d_description_1.arr);
///////////////////////////////////////////////// added 02.11.2002
               ctr = 0;
               r_ctr = 0;
               len = strlen(d_description_1.arr);
               split_text(d_description_1.arr, 100, cl_string, &r_ctr);
//			   split_text(d_description_1.arr, 75, cl_string, &r_ctr);
               //check_end_of_page(1);
               //next_line(1);
               fprintf(f1,"%s",cl_string);
               //line_no++;
               //next_line(1); 
               strcpy(cl_string,"");   
               while(r_ctr < len)
               {	
                 split_text(d_description_1.arr, 100, cl_string, &r_ctr);
//				 split_text(d_description_1.arr, 75, cl_string, &r_ctr);
                 //check_end_of_page(1);
                 next_line(1);
                 fprintf(f1,"%4s%s"," ",cl_string);  
//				 fprintf(f1,"%50s%s"," ",cl_string);  
                 strcpy(cl_string,"");  
                 //line_no++;
                 //next_line(1); 
               }
////////////////////////////////////////////////
               if(strlen(d_snomed_code_2.arr)>0)
               {
                 next_line(1);
                 fprintf(f1,"%4s%20s  :"," ",d_snomed_code_2.arr);
//				 fprintf(f1,"%40s%20s  :"," ",d_snomed_code_2.arr);
//							  fprintf(f1,"%s\n",d_description_2.arr);
///////////////////////////////////////////////// added on 02.11.2002
                 ctr = 0;
                 r_ctr = 0;
                 len = strlen(d_description_2.arr);
                 split_text(d_description_2.arr, 100, cl_string, &r_ctr);
//				 split_text(d_description_2.arr, 75, cl_string, &r_ctr);
                 //check_end_of_page(1);
                 //next_line(1);
                 fprintf(f1,"%s",cl_string);
                 //line_no++;
                 //next_line(1); 
                 strcpy(cl_string,"");   
                 while(r_ctr < len)
                 {	
                   split_text(d_description_2.arr, 100, cl_string, &r_ctr);
//				   split_text(d_description_2.arr, 75, cl_string, &r_ctr);
                   //check_end_of_page(1);
                   next_line(1);
                   fprintf(f1,"%4s%s"," ",cl_string);  
//				   fprintf(f1,"%50s%s"," ",cl_string);  
                   strcpy(cl_string,"");  
                   //line_no++;
                   //next_line(1); 
                 }
////////////////////////////////////////////////
               }
               //line_no +=4;
               //next_line(1); 
             }
           }
         }
         snomed_codes_printed	= 1;
         //print_separator(78);
         close_snomed_result_cur(); 
       }
		 
//---------------------Up to Here-------------------------------------------
       else
       {
         //check_end_of_page(3);
         //line_no += 4;
         next_line(1); 
         //	print_separator(78);
         nd_totl_specimens += 1;
				
         pat_rec_printed			= 0;
         result_text_printed		= 0;
         snomed_codes_printed		= 0;
         l_1st_snomed_printed = 0;
         break;                                  
       }
       still_rec_left = fetch_specimen_register();
     }
   }	

   if (nd_totl_specimens > 0)
   {
     //check_end_of_page(3);
     //line_no += 4;
     next_line(1); 
   }
    
   fprintf(f1, "\n");
   print_separator(REP_WIDTH);
   end_report();	  	
 }
  
void check_end_of_page(int lin)
{
	   if ((line_no + lin)>= MAX_LINES)
       {
	    fprintf(f1,"\f");
          prepare_new_page();
       }
}


/* prepares for the new page */
void prepare_new_page()
{
   page_no ++;
   line_no = 1;
   fprintf(f1," ");
   print_page_header();
}


/* to print page headers the header details */ 
void print_page_header()
{
	int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];
int spc_len;
int i;

 	fprintf(f1,"%c(s3B",ESC); /* To set Bold style 			*/
	fprintf(f1,"MDL : RL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(f1,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-18);
	
	
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
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert_dateti\
me_2t ( SYSDATE , :language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )545;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_sysdate1;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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


	fprintf(f1,"%s", d_sysdate1.arr);
    
	fprintf(f1,"\n"); 
	fprintf(f1,"OPR : %s", d_user.arr); 
	

/* --Start-- Sai Dutt 21.01.2006 */
	s1 = (REP_WIDTH-d_lab_title_2.len)/2;
	horz_skip(s1- (d_user.len+6));
	fprintf(f1,"%s", d_lab_title_2.arr);
/* --End-- Sai Dutt 21.01.2006 */
	fprintf(f1,"\n");

/* --Start-- Sai Dutt 21.01.2006 */
	s1 = (REP_WIDTH-t_section_desc.len)/2;
	horz_skip(s1);
	fprintf(f1,"%s", t_section_desc.arr);
	s2 = (REP_WIDTH-s1-t_section_desc.len);
	horz_skip(s2-12);
	fprintf(f1,"%s :%4d\n",local_legend[1],++page_no);
/* --End-- Sai Dutt 21.01.2006 */
    
	fprintf(f1,"REP : %s",nd_pgm_id.arr);
	strcpy(REP_TITLE1,REP_TITLE);//ADDED BY BABU
	strcpy(REP_TITLE1,local_legend[26]);		
	strcpy(v_rep_title,REP_TITLE1);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);
	fprintf(f1,"%s",v_rep_title);
	s2 = (REP_WIDTH-s1-14-strlen(v_rep_title));
	horz_skip(s2-10);
	fprintf(f1,"%-5.5s :%s %-4.4s : %s\n",local_legend[2], d_spec_month.arr,local_legend[3], d_spec_year.arr);

/*
	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-12);
	fprintf(f1,"PAGE :%4d\n",++page_no);
*/  
	line_no = line_no + 4;
	print_separator(REP_WIDTH); next_line(1);
	

//--------------------------------Titles-----------------------

//fprintf(f1,"%-12.12s%28s %-14.14s %2s   %-3.3s%10s %-3.3s   %-4.4s%26s    \n", local_legend[4]," ",local_legend[5]," ",local_legend[6]," ",local_legend[7]," ",local_legend[8])
//disp_message(ERR_MESG,local_legend[27],"local legend");
fprintf(f1,"%-12.12s%28s %-14.14s %2s   %-3.3s%10s %-3.3s  %-2.4s%-s                    %-5.5s%10s \n", local_legend[4]," ",local_legend[5]," ",local_legend[6]," ",local_legend[7]," ",local_legend[8]," ",local_legend[27]);  /* Added by Srinivas against scf 6328 */
fprintf(f1,"   %-23.23s               %-9.9s                              %-21.21s \n",local_legend[9],local_legend[10],local_legend[11]);
fprintf(f1,"%3s%14.14s \n"," ",local_legend[12]);
//fprintf(f1,"%3sHistology(Impression) \n"," ");
fprintf(f1,"%c(s-3B",ESC); /* release bold style */
line_no = line_no + 3;
print_separator(REP_WIDTH);
}

/* to print the header page for the report */
void print_rep_header()
{
	int spc_len;
	int i;
		int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];

  char nd_fr_process_date_desc[11],
       nd_to_process_date_desc[11];

  if(strcmp(nd_fr_process_date.arr, "01/01/1800") == 0)
    strcpy(nd_fr_process_date_desc, local_legend[13]);
    else 
	/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_fr_process_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:nd_fr_process_date_con := to_char(t_date,'DD/MM/YYYY');
				:nd_fr_process_date_con :=sm_convert_date_2t(to_date(:nd_fr_process_date,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_fr_process_date_con := sm_co\
nvert_date_2t ( to_date ( :nd_fr_process_date , 'DD/MM/YYYY ' ) , :language_id\
 ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )568;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fr_process_date_con;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fr_process_date;
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



	strcpy(nd_fr_process_date_desc, nd_fr_process_date_con.arr);

  if(strcmp(nd_to_process_date.arr, "31/12/4712") == 0)
    strcpy(nd_to_process_date_desc, local_legend[14]);
    else 
	/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_to_process_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:nd_to_process_date_con := to_char(t_date,'DD/MM/YYYY');
				:nd_to_process_date_con :=sm_convert_date_2t(to_date(:nd_to_process_date,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_to_process_date_con := sm_co\
nvert_date_2t ( to_date ( :nd_to_process_date , 'DD/MM/YYYY ' ) , :language_id\
 ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )595;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_to_process_date_con;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_process_date;
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



	
	strcpy(nd_to_process_date_desc, nd_to_process_date_con.arr);

 //--------------------------Main head---------

	fprintf(f1,"%c(s3B",ESC); /* To set Bold style 			*/
	fprintf(f1,"MDL : RL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(f1,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-18);
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
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET_\
CURRENT_DATE ( :language_id ) ; :d_sysdate1 := to_char ( t_date , 'DD/MM/YYYY \
HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )622;
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


	
	fprintf(f1,"%s", d_sysdate1.arr);
    
	fprintf(f1,"\n"); fprintf(f1,"OPR : %s", d_user.arr); fprintf(f1,"\n");
    
	fprintf(f1,"REP : %s",nd_pgm_id.arr);
	strcpy(REP_TITLE1,local_legend[26]);		
	strcpy(v_rep_title,REP_TITLE1);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);
	fprintf(f1,"%s",v_rep_title);
	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-12);
	fprintf(f1,"%s :%4d\n",local_legend[1],++page_no);
	line_no = 3;
//	-----------------------------
print_separator(REP_WIDTH); next_line(1); /*Moved from two lines below to up by srinivas */
  get_version_no();   

  /////////// 01.07.2003 fprintf(f1,VER);

  fprintf(f1,"%s\n",d_version.arr);
  
  
    
	


  fprintf(f1,"\n\n\n\n");
  fprintf(f1,"        ");
  fprintf(f1,"%s :\n",local_legend[15]);
  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  fprintf(f1,"                %-28.28s  : %s\n",local_legend[16], nd_snomed_code.arr);
  fprintf(f1,"\n");
  fprintf(f1,"                %-28.28s  : %s\n",local_legend[17],nd_snomed_marker_code.arr);
  fprintf(f1,"\n");
  fprintf(f1,"                %-28.28s  : %s\n",local_legend[18],nd_res_search.arr);
  fprintf(f1,"\n");
  fprintf(f1,"                %-28.28s  : %s\n", local_legend[19],nd_fr_process_date_desc);
  fprintf(f1,"                %-28.28s  : %s\n", local_legend[20],nd_to_process_date_desc); 
//  next_page();
}


void get_signed_dtls()
{

d_released_by_id.arr[0]  = '\0';
d_released_by_id.len = 0;
d_released_date.arr[0]	= '\0';
d_released_date.len = 0;
d_reviewed_by_id.arr[0]	= '\0';
d_reviewed_by_id.len = 0;
d_reviewed_date.arr[0]	= '\0';
d_reviewed_date.len = 0;
d_section_code.arr[0]	    = '\0';
d_section_code.len = 0;


   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL SELECT  A.released_by_id, TO_CHAR(A.released_date, 'DD/MM/YYYY'), 
             A.reviewed_by_id, TO_CHAR(A.reviewed_date, 'DD/MM/YYYY'),
			 section_code
	INTO :d_released_by_id,:d_released_date,
		 :d_reviewed_by_id,:d_reviewed_date,
		 :d_section_code
    FROM RL_TEST_RESULT A
    WHERE specimen_no = :d_specimen_no
	AND   operating_facility_id = :nd_operating_facility_id
    AND   test_code = :d_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select A.released_by_id ,TO_CHAR(A.released_date,'DD/MM/YYYY\
') ,A.reviewed_by_id ,TO_CHAR(A.reviewed_date,'DD/MM/YYYY') ,section_code into\
 :b0,:b1,:b2,:b3,:b4  from RL_TEST_RESULT A where ((specimen_no=:b5 and operat\
ing_facility_id=:b6) and test_code=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )645;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_released_by_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_released_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_reviewed_by_id;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_reviewed_date;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_section_code;
 sqlstm.sqhstl[4] = (unsigned int  )4;
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
 sqlstm.sqhstv[7] = (         void  *)&d_test_code;
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



d_released_by_id.arr[d_released_by_id.len]  = '\0';
d_released_date.arr[d_released_date.len]	= '\0';
d_reviewed_by_id.arr[d_reviewed_by_id.len]	= '\0';
d_reviewed_date.arr[d_reviewed_date.len]	= '\0';
d_section_code.arr[d_section_code.len]	    = '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )692;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_signed_dtls() occured....\n");
   proc_exit();
}



void get_releasedby_name()
{
d_releasedby_name.arr[0] = '\0';
d_releasedby_name.len = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



   /* EXEC SQL	SELECT username 
	INTO :d_releasedby_name
    FROM SY_USER_LANG_vW	
    WHERE FACILITY_ID = :nd_operating_facility_id
	AND user_id = :d_released_by_id
	AND language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select username into :b0  from SY_USER_LANG_vW where ((FAC\
ILITY_ID=:b1 and user_id=:b2) and language_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )707;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_releasedby_name;
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
   sqlstm.sqhstv[2] = (         void  *)&d_released_by_id;
   sqlstm.sqhstl[2] = (unsigned int  )33;
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



d_releasedby_name.arr[d_releasedby_name.len] = '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )738;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_releasedby_name() occured....\n");
   proc_exit();
}

////////////////

void get_reviewedby_name()
{
d_reviewedby_name.arr[0] = '\0';
d_reviewedby_name.len = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



   /* EXEC SQL	SELECT username 
	INTO :d_reviewedby_name
    FROM SY_USER_LANG_VW	
    WHERE FACILITY_ID = :nd_operating_facility_id
	AND user_id = :d_reviewed_by_id
	AND language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select username into :b0  from SY_USER_LANG_VW where ((FAC\
ILITY_ID=:b1 and user_id=:b2) and language_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )753;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_reviewedby_name;
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
   sqlstm.sqhstv[2] = (         void  *)&d_reviewed_by_id;
   sqlstm.sqhstl[2] = (unsigned int  )33;
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



d_reviewedby_name.arr[d_reviewedby_name.len] = '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )784;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_reviewedby_name() occured....\n");
   proc_exit();
}

void get_name_on_report1()
{
d_name_on_report1.arr[0] = '\0';
d_name_on_report1.len = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



   /* EXEC SQL	SELECT name_on_report_yn  
	INTO  :d_name_on_report1
    FROM  RL_USER_DEPT	
    WHERE operating_facility_id = :nd_operating_facility_id
	AND   user_id      = :d_released_by_id
	AND   section_code = :d_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select name_on_report_yn into :b0  from RL_USER_DEPT where\
 ((operating_facility_id=:b1 and user_id=:b2) and section_code=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )799;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_name_on_report1;
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
   sqlstm.sqhstv[2] = (         void  *)&d_released_by_id;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_section_code;
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



d_name_on_report1.arr[d_name_on_report1.len] = '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )830;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_name_on_report1() occured....\n");
   proc_exit();
}

void get_name_on_report2()
{
d_name_on_report2.arr[0] = '\0';
d_name_on_report2.len = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



   /* EXEC SQL	SELECT name_on_report_yn  
	INTO :d_name_on_report2
    FROM RL_USER_DEPT	
    WHERE operating_facility_id = :nd_operating_facility_id
	AND   user_id      = :d_reviewed_by_id
	AND   section_code = :d_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select name_on_report_yn into :b0  from RL_USER_DEPT where\
 ((operating_facility_id=:b1 and user_id=:b2) and section_code=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )845;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_name_on_report2;
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
   sqlstm.sqhstv[2] = (         void  *)&d_reviewed_by_id;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_section_code;
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



d_name_on_report2.arr[d_name_on_report2.len] = '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )876;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_name_on_report2() occured....\n");
   proc_exit();
}





void get_snomed_desc1()
{
d_description_1.arr[0] = '\0';
d_description_1.len = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



   /* EXEC SQL	SELECT description_1 
	INTO :d_description_1
    FROM RL_SNOMED_CODE_LANG_VW	
    WHERE snomed_code = :d_snomed_code
	AND   language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select description_1 into :b0  from RL_SNOMED_CODE_LANG_VW\
 where (snomed_code=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )891;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_description_1;
   sqlstm.sqhstl[0] = (unsigned int  )653;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_snomed_code;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


//	  AND snomed_marker_code = :d_snomed_marker_code_1;

d_description_1.arr[d_description_1.len] = '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )918;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_snomed_desc1() occured....\n");
   proc_exit();
}



void get_snomed_desc2()
{
d_description_2.arr[0] = '\0';
d_description_2.len = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL SELECT description_1 
	INTO :d_description_2
    FROM RL_SNOMED_CODE_LANG_VW	
    WHERE snomed_code = :d_snomed_code_2
	AND   language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select description_1 into :b0  from RL_SNOMED_CODE_LANG_VW w\
here (snomed_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )933;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_description_2;
 sqlstm.sqhstl[0] = (unsigned int  )653;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_snomed_code_2;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


//	  AND snomed_marker_code = :d_snomed_marker_code_2;

d_description_2.arr[d_description_2.len] = '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )960;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_snomed_desc2() occured....\n");
   proc_exit();
}


/* fetches the next record from SPECIMEN REGISTER CURSOR */
/* returns 0 if the end of cursor is reached else returns 1. */

int fetch_specimen_register()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



/* *****************  added    23.10.2002      *****/

  /* EXEC SQL FETCH SPECIMEN_REGISTER INTO
                  :d_temp_spec_date,
				  :d_specimen_type_code,
                  :d_spec_month,
                  :d_spec_year,
			:nd_dept,
	        :d_specimen_no,
		    :d_patient_id,
			:d_category_number,
			:d_spec_regd_date_time,
		    :d_spec_recd_date_time,
			:d_group_test_code,
			:d_test_code,
		    :d_episode_type,
			:d_source_type,//Added by Nandhini
			:d_source_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )975;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_temp_spec_date;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_spec_month;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_spec_year;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_dept;
  sqlstm.sqhstl[4] = (unsigned int  )4;
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
  sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_category_number;
  sqlstm.sqhstl[7] = (unsigned int  )43;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_spec_regd_date_time;
  sqlstm.sqhstl[8] = (unsigned int  )23;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_spec_recd_date_time;
  sqlstm.sqhstl[9] = (unsigned int  )23;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_group_test_code;
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
  sqlstm.sqhstv[12] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[12] = (unsigned int  )4;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_source_type;
  sqlstm.sqhstl[13] = (unsigned int  )23;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_source_code;
  sqlstm.sqhstl[14] = (unsigned int  )23;
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

//Added by Nandhini

/* **************** upto here                  *****/
   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_temp_spec_date.arr[d_temp_spec_date.len]				= '\0';
  d_specimen_type_code.arr[d_specimen_type_code.len]		= '\0';
  d_spec_month.arr[d_spec_month.len]					= '\0';
  d_spec_year.arr[d_spec_year.len]			    			= '\0';

  nd_dept.arr[nd_dept.len]								= '\0';
  d_specimen_no.arr[d_specimen_no.len]					= '\0';
  d_patient_id.arr[d_patient_id.len]					= '\0';
 


  d_spec_regd_date_time.arr[d_spec_regd_date_time.len]	= '\0';
  d_spec_recd_date_time.arr[d_spec_recd_date_time.len]	= '\0';
  d_group_test_code.arr[d_group_test_code.len]			= '\0';
  d_test_code.arr[d_test_code.len]						= '\0';
  d_episode_type.arr[d_episode_type.len]				= '\0';
   d_category_number.arr[d_category_number.len]			= '\0';

#ifdef DEBUG
 printf("d_specimen_no = %s\n",d_specimen_no.arr);
 printf("d_patient_id = %s\n",d_patient_id.arr);
 printf("d_episode_type = %s\n",d_episode_type.arr);
 printf("d_spec_regd_date_time = %s\n",d_spec_regd_date_time);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1050;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_specimen_register() occured....\n");
   proc_exit();
}

int fetch_result_text()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH RESULT_TEXT INTO 
				:d_result_text; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1065;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_result_text;
  sqlstm.sqhstl[0] = (unsigned int  )2003;
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

  d_result_text.arr[d_result_text.len]					= '\0';


#ifdef DEBUG
 printf("d_result_text = %s",d_result_text.arr); next_line(1);

#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1084;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_result_text() occured....\n");
   proc_exit();
}

/* ******** added 23.10.2002   srinivas      ****** */
int fetch_snomed_result_cur()
{

  d_snomed_code.arr[0]	         = '\0';	
  d_snomed_code.len              = 0;
  d_snomed_code_2.arr[0]         = '\0';	 
  d_snomed_code_2.len            = 0;	 
  d_snomed_marker_code_1.arr[0]	 = '\0';	 
  d_snomed_marker_code_2.len	 = 0;	 


  
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH SNOMED_DETAIL INTO 
			:d_snomed_code,
			:d_snomed_code_2,
			:d_snomed_marker_code_1,
			:d_snomed_marker_code_2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1099;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_snomed_code;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_snomed_code_2;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_snomed_marker_code_1;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_snomed_marker_code_2;
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



   #ifdef DEBUG
    printf("SQLCA code after fetch SNOMED DETAIL CURSOR :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_snomed_code.arr[d_snomed_code.len]					= '\0';	
  d_snomed_code_2.arr[d_snomed_code_2.len]				= '\0';	 
  d_snomed_marker_code_1.arr[d_snomed_marker_code_1.len]				= '\0';	 
  d_snomed_marker_code_2.arr[d_snomed_marker_code_2.len]				= '\0';	 



#ifdef DEBUG
 printf("d_snomed_code = %s\n",d_snomed_code.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1130;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_snomed_result_cur() occured....\n");
   proc_exit();

}

/* ******** upto here                        ****** */

void get_section_desc()
{

  t_section_desc.arr[0]	='\0';
  t_section_desc.len	=0;

  d_sample_anatomy_ind.arr[0]	='\0';
  d_sample_anatomy_ind.len		=0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT LONG_NAME, NVL(use_sample_anatomy_ind,'!!') /o description of the section o/
	    INTO :t_section_desc, :d_sample_anatomy_ind
            FROM RL_SECTION_CODE_LANG_VW
	    WHERE SECTION_CODE = :nd_dept
		AND   LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_NAME ,NVL(use_sample_anatomy_ind,'!!') into :b\
0,:b1  from RL_SECTION_CODE_LANG_VW where (SECTION_CODE=:b2 and LANGUAGE_ID=:b\
3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1145;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&t_section_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_sample_anatomy_ind;
   sqlstm.sqhstl[1] = (unsigned int  )6;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_dept;
   sqlstm.sqhstl[2] = (unsigned int  )4;
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
  d_sample_anatomy_ind.arr[d_sample_anatomy_ind.len] = '\0';

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1176;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_section_desc() occured....\n");
   proc_exit();
}


/* ******Added by Nandhini*********** */
get_source_desc()
{
d_source_desc.arr[0] = '\0';
d_source_desc.len = 0;

 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

 
  if(strcmp(d_source_type.arr,"C")==0)
 {
	
	/* EXEC SQL SELECT UPPER(short_desc)
			INTO :d_source_desc
		  FROM op_clinic_lang_vw
		 WHERE language_id = :language_id
		   AND clinic_code = UPPER(:d_source_code)
		   AND facility_id = :nd_operating_facility_id
		 ORDER BY 1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select UPPER(short_desc) into :b0  from op_clinic_lang_vw wh\
ere ((language_id=:b1 and clinic_code=UPPER(:b2)) and facility_id=:b3) order b\
y 1 ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1191;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
 sqlstm.sqhstl[0] = (unsigned int  )202;
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
 sqlstm.sqhstv[2] = (         void  *)&d_source_code;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



}
	else if (strcmp(d_source_type.arr,"W")==0)
{
		/* EXEC SQL SELECT UPPER(short_desc)
			INTO :d_source_desc
		  FROM ip_nursing_unit_lang_vw
		 WHERE language_id       = :language_id
		   AND nursing_unit_code = UPPER(:d_source_code)
		   AND facility_id       = :nd_operating_facility_id
		 ORDER BY 1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select UPPER(short_desc) into :b0  from ip_nursing_unit_lan\
g_vw where ((language_id=:b1 and nursing_unit_code=UPPER(:b2)) and facility_id\
=:b3) order by 1 ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1222;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
  sqlstm.sqhstl[0] = (unsigned int  )202;
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
  sqlstm.sqhstv[2] = (         void  *)&d_source_code;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


	} 
	else if ((strcmp(d_source_type.arr,"R")==0) || (strcmp(d_source_type.arr,"E")==0)) 
{
		 /* EXEC SQL SELECT UPPER(short_desc)
			INTO :d_source_desc
		  FROM rl_referral_lang_vw
		 WHERE language_id   = :language_id 
		   AND referral_code = UPPER(:d_source_code)
		 ORDER BY 1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select UPPER(short_desc) into :b0  from rl_referral_lang_v\
w where (language_id=:b1 and referral_code=UPPER(:b2)) order by 1 ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1253;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
   sqlstm.sqhstl[0] = (unsigned int  )202;
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
   sqlstm.sqhstv[2] = (         void  *)&d_source_code;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


	}
d_source_desc.arr[d_source_desc.len] = '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1280;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_source code() occured....\n");
   proc_exit();
}



/* to print the detailed record */
void print_pat_rec()
{
    void print_separator(int);
    int  get_patient_dtl(); 
    void get_referral_patient_dtl();
	char l_age_legend[5];
    int i = 0;
   
    if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0 || strcmp(d_episode_type.arr,"H")==0)
    { 
		i = get_patient_dtl();
	   if(l_tab_exists ) 
	      {
		   if ( strlen(d_national_id.arr) <= 0 )
		   {
		     get_ip_national_id();
		     strcpy(d_national_id.arr,d_alt_id_num.arr);
		   }
		  }
		   	

    } 
    else
    if(strcmp(d_episode_type.arr,"R")==0)
	{
	  get_referral_patient_dtl();
	  if ( l_tab_exists ) 
	  {
	    if ( strlen(d_national_id.arr) <= 0 )
		{
	      get_ext_national_id();
		  strcpy(d_national_id.arr,d_alt_id_num.arr);
		}
	  }
	}
    patient_age();

	if (strcmp(d_actual_dob_yn.arr, "Y") == 0)
		strcpy(l_age_legend, "");
	else
		strcpy(l_age_legend, "*");

    l_delimeter = ' ';

	rl_split_text(d_patient_name.arr, l_delimeter, l_len,d_patient_name_1.arr, 
	              d_patient_name_2.arr,d_patient_name_3.arr,d_patient_name_4.arr);
 
	if ( strlen(d_patient_name.arr) > 40 )
	{
	  strncpy(d_patient_name_1.arr, d_patient_name.arr, 37);
	  d_patient_name_1.len = strlen(d_patient_name_1.arr);
	  strcat(d_patient_name_1.arr, "...");
	  d_patient_name_1.len = strlen(d_patient_name_1.arr);
	  strcpy(d_patient_name.arr, d_patient_name_1.arr);
	  d_patient_name.len = strlen(d_patient_name.arr);
	}
 next_line(1);
 
 get_anatomy_site();

 get_race();


//check_end_of_page(2);

get_source_desc();/* Added by nandhini */

 fprintf(f1,"%-41.41s%-19.19s%-16.16s  %-5.5s%-30s%-100s \n", d_patient_name.arr, d_national_id.arr, t_age.arr, d_sex.arr, d_race.arr,d_source_desc.arr);/*Added by Nandhini*/
 fprintf(f1,"%-3.3s%-11.11s", " ", d_specimen_no.arr);
 if ( (strcmp(d_sample_anatomy_ind.arr, "AT") == 0) || (strcmp(d_sample_anatomy_ind.arr, "SA") == 0) )
  {
    fprintf(f1,"%-26.26s", d_category_number.arr);
  }
  else
  {
    fprintf(f1,"%-26.26s", " ");
  }

// fprintf(f1," %-21.21s%-41.41s%-21.21s%-11.11s    %-2.2s   %-16s %-16s %-16s \n",d_specimen_no.arr, d_patient_name_1.arr,d_national_id.arr,t_age.arr,d_sex.arr,d_race.arr,d_anatomy_site.arr);

	//line_no=line_no+2;	
	
//		next_line(1); 

	//print_separator(78);

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
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


   disp_message(ORA_MESG,"Oracle error at print_pat_rec() occured....\n");
   proc_exit();
}


get_ref_desc()
{
	d_ref_desc.arr[0]		= '\0';
	d_ref_desc.len		= 0;

	/* EXEC SQL SELECT short_desc
			 INTO :d_ref_desc
			 FROM RL_REFERRAL_LANG_VW
			 WHERE referral_code = :d_ref_source
			 AND LANGUAGE_ID = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from RL_REFERRAL_LANG_VW where (\
referral_code=:b1 and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1310;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_ref_desc;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_ref_source;
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



	d_ref_desc.arr[d_ref_desc.len]	= '\0';

}



/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{


  d_patient_name.arr[0]     = '\0';
  d_patient_name.len = 0;
  d_dob.arr[0]                       = '\0';
  d_dob.len = 0;
  d_actual_dob_yn.arr[0]		 = '\0';
  d_actual_dob_yn.len = 0;
  d_date_of_birth.arr[0]	 = '\0';
  d_date_of_birth.len = 0;
  d_sex.arr[0]                       = '\0';
  d_sex.len = 0;
  d_race_code.arr[0]			 = '\0';
  d_race_code.len = 0;
  d_location.arr[0]			 = '\0';
  d_location.len = 0;
  d_ref_source.arr[0]		 = '\0';
  d_ref_source.len			 = 0;
  d_national_id.arr[0]		='\0';
  d_national_id.len=0;
  


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) SHORT_NAME,
		NATIONAL_ID_NUM,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY'),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),SEX,NVL(actual_dob_yn, 'N'),race_code,location, ref_source_code
	    INTO   :d_patient_name,:d_national_id,:d_dob,:d_date_of_birth,:d_sex,:d_actual_dob_yn,:d_race_code,:d_location, :d_ref_source
            FROM   RL_PATIENT_MAST
	    WHERE  PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_loc_lang,S\
HORT_NAME)) SHORT_NAME ,NATIONAL_ID_NUM ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') ,TO\
_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX ,NVL(actual_dob_yn,'N') ,race_code ,loc\
ation ,ref_source_code into :b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  from RL_PATIE\
NT_MAST where PATIENT_ID=:b10";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1337;
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
  sqlstm.sqhstv[2] = (         void  *)&d_national_id;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_dob;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_date_of_birth;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_sex;
  sqlstm.sqhstl[5] = (unsigned int  )4;
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
  sqlstm.sqhstv[7] = (         void  *)&d_race_code;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_location;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_ref_source;
  sqlstm.sqhstl[9] = (unsigned int  )13;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[10] = (unsigned int  )23;
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


	/* AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */

  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_dob.arr[d_dob.len]                       = '\0';
  d_actual_dob_yn.arr[d_actual_dob_yn.len]		 = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]	 = '\0';
  d_sex.arr[d_sex.len]                       = '\0';
  d_race_code.arr[d_race_code.len]			 = '\0';
  d_location.arr[d_location.len]			 = '\0';
  d_ref_source.arr[d_ref_source.len]		 = '\0';
  d_national_id.arr[d_national_id.len]		 = '\0';

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
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1396;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_referral_patient_dtl() occured....\n");
   proc_exit();
}
;

/* Function to fetch the INPATIENT details */

int get_patient_dtl()
{


  d_patient_name.arr[0]     = '\0';
  d_patient_name.len = 0;
  d_dob.arr[0]                       = '\0';
  d_dob.len = 0;
  d_date_of_birth.arr[0]	 = '\0';
  d_date_of_birth.len = 0;
  d_sex.arr[0]                       = '\0';
  d_sex.len = 0;
  d_actual_dob_yn.arr[0]	 = '\0';
  d_actual_dob_yn.len = 0;
  d_race_code.arr[0]			 = '\0';  
  d_race_code.len = 0;
  d_location.arr[0] = '\0';
  d_location.len = 0;
  d_ip_national_id_num.arr[0] ='\0';
  d_ip_national_id_num.len =0;
  d_alternate_id.arr[0]	='\0';
   d_alternate_id.len=0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SHORT_NAME,NATIONAL_ID_NUM,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY'),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),SEX,NVL(actual_dob_yn, 'N'),race_code
	    INTO   :d_patient_name,:d_national_id,:d_dob,:d_date_of_birth,:d_sex,:d_actual_dob_yn,:d_race_code
            FROM   MP_PATIENT_MAST 
	    WHERE  PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_NAME ,NATIONAL_ID_NUM ,TO_CHAR(DATE_OF_BIRTH,\
'DD/MM/YY') ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX ,NVL(actual_dob_yn,'N') \
,race_code into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from MP_PATIENT_MAST where PATIEN\
T_ID=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1411;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[0] = (unsigned int  )242;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_national_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_dob;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_sex;
   sqlstm.sqhstl[4] = (unsigned int  )4;
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
   sqlstm.sqhstv[6] = (         void  *)&d_race_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_patient_id;
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


  
  if(NODATAFOUND)
     return 0;

  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_dob.arr[d_dob.len]                       = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]	 = '\0';
  d_sex.arr[d_sex.len]                       = '\0';
  d_actual_dob_yn.arr[d_actual_dob_yn.len]	 = '\0';
  d_race_code.arr[d_race_code.len]			 = '\0';  
  d_national_id.arr[d_national_id.len]	='\0';

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
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1458;
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
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1473;
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
		TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY'), 
		TO_DATE(:d_date_of_birth, 'DD/MM/YYYY')))
			INTO :mt FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ABS(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),TO_DA\
TE(:b1,'DD/MM/YYYY'))) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1492;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[1] = (unsigned int  )23;
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

				/* EXEC SQL SELECT TO_CHAR(ROUND((TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY') -
					TO_DATE(:d_date_of_birth, 'DD/MM/YYYY')),3))
					INTO :t_days FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ROUND((TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:\
b1,'DD/MM/YYYY')),3)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1519;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[1] = (unsigned int  )23;
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
			
			strncat(t_age.arr, local_legend[23],1);
			sprintf(st_r, " %f", tmp_mths);
			strcat(t_age.arr, strtok(st_r, "."));
			strncat(t_age.arr, local_legend[24],1);
			sprintf(st_r, " %f", tmp_days);
			strcat(t_age.arr, strtok(st_r, "."));
			strncat(t_age.arr, local_legend[25],1);

				
 }
/*------------------------------------------------------------*/


gen_file_name()
{
     /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_file_name.arr,"rlrcancr.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);
	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
	   proc_exit(0);
     }

}



/* print the finishing line of the report */
void end_report()
{
  fprintf(f1,"\n%-11.11s : %d\n",local_legend[21], l_tot_cases);
//  fprintf(f1,"\n");

//fprintf(f1,"%-30.30s** %s **"," ",local_legend[22]);
  fprintf(f1,"%-60.60s** %s **"," ",local_legend[22]); /*Added by srinivas against scf 6328*/
  fprintf(f1," ");
}
/*-----------------------------------------------------*/
chk_break(int nol)
{

	if((line_no + nol) >= MAX_LINES) 
	{
	    prepare_new_page();
 	}
}
/*-----------------------------------------------------*/

////////////////// 

next_line(skip) /* will check for MAX LINE before printing totals */		
int skip;
{
	if ((line_no + skip + 1) >= MAX_LINES)
	{
		next_page(); 
	}
	else
	{
		fprintf(f1,"\n"); ++line_no; //fprintf(fp,"LNNO:%2d",line_no); 
	}
}

horz_skip(num) /* this is to obtain required blank space */
int num;
{
	int i;
	for(i=0;i<num;i++)fprintf(f1," ");
}


next_page() /* will move the cursor to next page */
{
	fprintf(f1,"\n");
	fprintf(f1,"\f");
	fprintf(f1,"\n");
	line_no = 1;  
	print_page_header(); 	
}

get_ip_national_id()
{
	d_alt_id_num.arr[0]      = '\0';
	d_alt_id_num.len         =  0;
	d_alt_id_num1.arr[0]     = '\0';
	d_alt_id_num1.len        =  0;
	d_alt_id_num2.arr[0]     = '\0';
	d_alt_id_num2.len        =  0;
	d_alt_id_num3.arr[0]     = '\0';
	d_alt_id_num3.len        =  0;
	d_alt_id_num4.arr[0]     = '\0';
	d_alt_id_num4.len        =  0;
	d_alt_id_oth.arr[0]      = '\0';
	d_alt_id_oth.len         =  0;

    get_rl_param();

	    /* EXEC SQL SELECT alt_id1_no, alt_id2_no, alt_id3_no,
		                alt_id4_no, oth_alt_id_no
		         INTO   :d_alt_id_num1, :d_alt_id_num2, :d_alt_id_num3, 
				        :d_alt_id_num4, :d_alt_id_oth
                 FROM   mp_patient 
				 WHERE  patient_id=:d_patient_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select alt_id1_no ,alt_id2_no ,alt_id3_no ,alt_id4_no ,o\
th_alt_id_no into :b0,:b1,:b2,:b3,:b4  from mp_patient where patient_id=:b5";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1546;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_alt_id_num1;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_alt_id_num2;
     sqlstm.sqhstl[1] = (unsigned int  )43;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_alt_id_num3;
     sqlstm.sqhstl[2] = (unsigned int  )43;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_alt_id_num4;
     sqlstm.sqhstl[3] = (unsigned int  )43;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_alt_id_oth;
     sqlstm.sqhstl[4] = (unsigned int  )43;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
     sqlstm.sqhstl[5] = (unsigned int  )23;
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

 

		 d_alt_id_num1.arr[d_alt_id_num1.len] ='\0';
		 d_alt_id_num2.arr[d_alt_id_num2.len] ='\0';
		 d_alt_id_num3.arr[d_alt_id_num3.len] ='\0';
		 d_alt_id_num4.arr[d_alt_id_num4.len] ='\0';
		 d_alt_id_oth.arr[d_alt_id_oth.len]   ='\0';

/* --Start -- Commented on 18.04.2006 as it is not required to check for yn flag.--

     if(strcmp(d_alt_id1_reqd_yn.arr,"Y") == 0)
	 {
       strcpy(d_alt_id_num.arr, d_alt_id_num1.arr);
     }
     else if(strcmp(d_alt_id2_reqd_yn.arr,"Y")== 0)
	 {
       strcpy(d_alt_id_num.arr, d_alt_id_num2.arr);
     }
	 else if(strcmp(d_alt_id3_reqd_yn.arr,"Y")== 0)
	 {
       strcpy(d_alt_id_num.arr, d_alt_id_num3.arr);
     }
     else if(strcmp(d_alt_id4_reqd_yn.arr,"Y")== 0)
	 {
       strcpy(d_alt_id_num.arr, d_alt_id_num4.arr);
     }

	 d_alt_id_num.len = strlen(d_alt_id_num.arr);

 --End -- Commented on 18.04.2006 as it is not required to check for yn flag.--
 */
     if(strlen(d_alt_id_num.arr) == 0)
     {
       if(strlen(d_alt_id_num1.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_num1.arr);
       }
       else if(strlen(d_alt_id_num2.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_num2.arr);
       }
       else if(strlen(d_alt_id_num3.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_num3.arr);
       }
       else if(strlen(d_alt_id_num4.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_num4.arr);
       }
       else if(strlen(d_alt_id_oth.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_oth.arr);
       }
     }
	 d_alt_id_num.len = strlen(d_alt_id_num.arr);

}


get_ext_national_id()
{
	d_alt_id_num.arr[0]      = '\0';
	d_alt_id_num.len         =  0;
	d_alt_id_num1.arr[0]     = '\0';
	d_alt_id_num1.len        =  0;
	d_alt_id_num2.arr[0]     = '\0';
	d_alt_id_num2.len        =  0;
	d_alt_id_num3.arr[0]     = '\0';
	d_alt_id_num3.len        =  0;
	d_alt_id_num4.arr[0]     = '\0';
	d_alt_id_num4.len        =  0;
	d_alt_id_oth.arr[0]      = '\0';
	d_alt_id_oth.len         =  0;

    get_rl_param();

	    /* EXEC SQL SELECT alt_id1_no, alt_id2_no, alt_id3_no,
		                alt_id4_no, oth_alt_id_no
		         INTO   :d_alt_id_num1, :d_alt_id_num2, :d_alt_id_num3, 
				        :d_alt_id_num4, :d_alt_id_oth
                 FROM   mp_ext_person
				 WHERE  person_id=:d_patient_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select alt_id1_no ,alt_id2_no ,alt_id3_no ,alt_id4_no ,o\
th_alt_id_no into :b0,:b1,:b2,:b3,:b4  from mp_ext_person where person_id=:b5";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1585;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_alt_id_num1;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_alt_id_num2;
     sqlstm.sqhstl[1] = (unsigned int  )43;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_alt_id_num3;
     sqlstm.sqhstl[2] = (unsigned int  )43;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_alt_id_num4;
     sqlstm.sqhstl[3] = (unsigned int  )43;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_alt_id_oth;
     sqlstm.sqhstl[4] = (unsigned int  )43;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
     sqlstm.sqhstl[5] = (unsigned int  )23;
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

 

		 d_alt_id_num1.arr[d_alt_id_num1.len] ='\0';
		 d_alt_id_num2.arr[d_alt_id_num2.len] ='\0';
		 d_alt_id_num3.arr[d_alt_id_num3.len] ='\0';
		 d_alt_id_num4.arr[d_alt_id_num4.len] ='\0';
		 d_alt_id_oth.arr[d_alt_id_oth.len]   ='\0';

/* --Start -- Commented on 18.04.2006 as it is not required to check for yn flag.--

     if(strcmp(d_alt_id1_reqd_yn.arr,"Y") == 0)
	 {
       strcpy(d_alt_id_num.arr, d_alt_id_num1.arr);
     }
     else if(strcmp(d_alt_id2_reqd_yn.arr,"Y")== 0)
	 {
       strcpy(d_alt_id_num.arr, d_alt_id_num2.arr);
     }
	 else if(strcmp(d_alt_id3_reqd_yn.arr,"Y")== 0)
	 {
       strcpy(d_alt_id_num.arr, d_alt_id_num3.arr);
     }
     else if(strcmp(d_alt_id4_reqd_yn.arr,"Y")== 0)
	 {
       strcpy(d_alt_id_num.arr, d_alt_id_num4.arr);
     }

	 d_alt_id_num.len = strlen(d_alt_id_num.arr);

 --End -- Commented on 18.04.2006 as it is not required to check for yn flag.--
 */

     if(strlen(d_alt_id_num.arr) == 0)
     {
       if(strlen(d_alt_id_num1.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_num1.arr);
       }
       else if(strlen(d_alt_id_num2.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_num2.arr);
       }
       else if(strlen(d_alt_id_num3.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_num3.arr);
       }
       else if(strlen(d_alt_id_num4.arr) != 0)
       {
         strcpy(d_alt_id_num.arr, d_alt_id_num4.arr);
       }
     }
	 d_alt_id_num.len = strlen(d_alt_id_num.arr);

}


get_rl_param()
{
	d_alt_id1_reqd_yn.arr[0] = '\0';
    d_alt_id1_reqd_yn.len    =  0;
    d_alt_id2_reqd_yn.arr[0] = '\0';
	d_alt_id2_reqd_yn.len    =  0;
    d_alt_id3_reqd_yn.arr[0] = '\0';
    d_alt_id3_reqd_yn.len    =  0;
    d_alt_id4_reqd_yn.arr[0] = '\0';
    d_alt_id4_reqd_yn.len    =  0;

    /* EXEC SQL SELECT ALT_ID1_REQD_YN,ALT_ID2_REQD_YN ,ALT_ID3_REQD_YN ,ALT_ID4_REQD_YN  INTO
		        d_alt_id1_reqd_yn,
		        d_alt_id2_reqd_yn,
		        d_alt_id3_reqd_yn,
		        d_alt_id4_reqd_yn
		 FROM MP_PARAM; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ALT_ID1_REQD_YN ,ALT_ID2_REQD_YN ,ALT_ID3_REQD_YN \
,ALT_ID4_REQD_YN into :b0,:b1,:b2,:b3  from MP_PARAM ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1624;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_alt_id1_reqd_yn;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_alt_id2_reqd_yn;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_alt_id3_reqd_yn;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_alt_id4_reqd_yn;
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
}



         d_alt_id1_reqd_yn.arr[d_alt_id1_reqd_yn.len] = '\0';
		 d_alt_id2_reqd_yn.arr[d_alt_id2_reqd_yn.len] = '\0';
		 d_alt_id3_reqd_yn.arr[d_alt_id3_reqd_yn.len] = '\0';
		 d_alt_id4_reqd_yn.arr[d_alt_id4_reqd_yn.len] = '\0';

}

get_test_desc()
{
 d_test_desc.arr[0]	='\0';
 d_test_desc.len		=0;

 /* EXEC SQL SELECT long_desc 
          INTO   :d_test_desc
          FROM   rl_test_code_lang_vw
          WHERE  test_code = :d_test_code
		  AND    language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from rl_test_code_lang_vw where (\
test_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1655;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_test_desc;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_test_code;
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



 d_test_desc.arr[d_test_desc.len]			='\0';

}

void get_anatomy_site()
{
  d_anatomy_site.arr[0]	='\0';
  d_anatomy_site.len		=0;

 if ( (strcmp(d_sample_anatomy_ind.arr, "SA") == 0) )
  {
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


    /* EXEC SQL DECLARE anatomy_site CURSOR FOR
             SELECT  long_desc
             FROM    rl_anatomy_site_code_lang_vw A, rl_sample_details AN  
             WHERE   AN.specimen_no = :d_specimen_no 
             AND     AN.operating_facility_id = :nd_operating_facility_id
             AND     A.anatomy_site_code = AN.anatomy_site_code
             AND     AN.test_code = :d_test_code
			 AND     A.language_id = :language_id; */ 


    /* EXEC SQL OPEN anatomy_site; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0059;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1682;
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
    sqlstm.sqhstv[2] = (         void  *)&d_test_code;
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


    #ifdef DEBUG
      printf("leaving get_anatomy_site()\n");
    #endif

    /* EXEC SQL FETCH anatomy_site INTO
                  :d_anatomy_site; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1713;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_anatomy_site;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



    #ifdef DEBUG
      printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
    #endif

    if (NODATAFOUND)
      return;

    d_anatomy_site.arr[d_anatomy_site.len]			= '\0';

    #ifdef DEBUG
     printf("d_anatomy_site = %s\n", d_anatomy_site.arr);
    #endif

    /* EXEC SQL CLOSE anatomy_site; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1732;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}


    return;
  }
  else
  {
    /* EXEC SQL SELECT specimen_desc
	         INTO   :d_anatomy_site
			 FROM   rl_specimen_type_code_lang_vw
			 WHERE  specimen_type_code = :d_specimen_type_code
			 AND    language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select specimen_desc into :b0  from rl_specimen_type_code\
_lang_vw where (specimen_type_code=:b1 and language_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1747;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_anatomy_site;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



    d_anatomy_site.arr[d_anatomy_site.len]			= '\0';

    return;

  }

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1774;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_anatomy_site() occured....\n");
   proc_exit();
}


//------------------ADDED-----
get_race()
{
d_race.arr[0]		='\0';
d_race.len		=0;

  /* EXEC SQL SELECT LONG_DESC INTO :d_race from mp_race_lang_vw Where 
					RACE_CODE=:d_race_code
					AND LANGUAGE_ID = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LONG_DESC into :b0  from mp_race_lang_vw where (RACE\
_CODE=:b1 and LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1789;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_race;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_race_code;
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



d_race.arr[d_race.len]			='\0';

    }
//--------------------


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
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1816;
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
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1835;
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



#undef DEBUG
#undef NODATAFOUND
//#undef MAX_LINES
#undef VER

