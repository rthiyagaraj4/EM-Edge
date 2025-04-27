
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
    "c:\\temp\\rlrtsagx.pc"
};


static unsigned long sqlctx = 36389291;


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
            void  *sqhstv[56];
   unsigned int   sqhstl[56];
            int   sqhsts[56];
            void  *sqindv[56];
            int   sqinds[56];
   unsigned int   sqharm[56];
   unsigned int   *sqharc[56];
   unsigned short  sqadto[56];
   unsigned short  sqtdso[56];
} sqlstm = {10,56};

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
"select SECTION_CODE  from RL_SECTION_CTL where OPERATING_FACILITY_ID=:b0 ord\
er by section_code            ";

 static const char *sq0013 = 
"select A.patient_id ,A.episode_type ,B.test_code ,to_char(A.spec_regd_date_t\
ime,'dd/mm/yyyy') spec_regd_date_time ,A.section_code  from RL_REQUEST_HEADER \
A ,RL_TEST_RESULT B where (((((((A.spec_regd_date_time between TO_DATE(:b0,'DD\
/MM/YYYY') and (TO_DATE(:b1,'DD/MM/YYYY')+1) and A.specimen_no=B.specimen_no) \
and A.operating_facility_id=:b2) and A.operating_facility_id=B.operating_facil\
ity_id) and NVL(A.cancelled_yn,'N')<>'Y') and NVL(B.cancelled_yn,'N')<>'Y') an\
d a.section_code=b.section_code) and A.PATIENT_ID in (select PATIENT_ID  from \
RL_PATIENT_MAST where NATIONALITY_CODE in (select MEMBER_ID  from AM_STAT_GRP_\
DETAIL where STAT_GRP_ID=:b3) union all select PATIENT_ID  from MP_PATIENT_MAS\
T where NATIONALITY_CODE in (select MEMBER_ID  from AM_STAT_GRP_DETAIL where S\
TAT_GRP_ID=:b3)))           ";

 static const char *sq0014 = 
"select distinct A.patient_id \"patient_id\" ,A.episode_type  from RL_REQUEST\
_HEADER A ,RL_TEST_RESULT B where (((((((A.spec_regd_date_time between TO_DATE\
(:b0,'DD/MM/YYYY') and (TO_DATE(:b1,'DD/MM/YYYY')+1) and A.specimen_no=B.speci\
men_no) and A.operating_facility_id=:b2) and A.operating_facility_id=B.operati\
ng_facility_id) and NVL(A.cancelled_yn,'N')<>'Y') and NVL(B.cancelled_yn,'N')<\
>'Y') and a.section_code=b.section_code) and A.PATIENT_ID in (select PATIENT_I\
D  from RL_PATIENT_MAST where NATIONALITY_CODE in (select MEMBER_ID  from AM_S\
TAT_GRP_DETAIL where STAT_GRP_ID=:b3) union all select PATIENT_ID  from MP_PAT\
IENT_MAST where NATIONALITY_CODE in (select MEMBER_ID  from AM_STAT_GRP_DETAIL\
 where STAT_GRP_ID=:b3))) order by A.patient_id            ";

 static const char *sq0015 = 
"select MEMBER_ID  from AM_STAT_GRP_DETAIL where STAT_GRP_ID=:b0 order by STA\
T_GRP_ID            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,343,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,29,365,0,0,0,0,0,1,0,
51,0,0,3,0,0,30,366,0,0,0,0,0,1,0,
66,0,0,4,0,0,32,371,0,0,0,0,0,1,0,
81,0,0,5,120,0,6,381,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
104,0,0,6,136,0,6,392,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
127,0,0,7,156,0,6,442,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
150,0,0,8,54,0,4,484,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
173,0,0,9,1067,0,4,488,0,0,56,1,0,1,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,
0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,4,0,0,1,9,0,0,
412,0,0,10,158,0,4,1318,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
447,0,0,11,0,0,32,1336,0,0,0,0,0,1,0,
462,0,0,16,0,0,32,1415,0,0,0,0,0,1,0,
477,0,0,12,106,0,9,1426,0,0,1,1,0,1,0,1,9,0,0,
496,0,0,17,0,0,32,1432,0,0,0,0,0,1,0,
511,0,0,13,806,0,9,1442,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
546,0,0,18,0,0,32,1448,0,0,0,0,0,1,0,
561,0,0,14,757,0,9,1458,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
596,0,0,19,0,0,32,1464,0,0,0,0,0,1,0,
611,0,0,15,96,0,9,1475,0,0,1,1,0,1,0,1,9,0,0,
630,0,0,20,0,0,32,1481,0,0,0,0,0,1,0,
645,0,0,12,0,0,15,1493,0,0,0,0,0,1,0,
660,0,0,21,0,0,32,1497,0,0,0,0,0,1,0,
675,0,0,13,0,0,15,1508,0,0,0,0,0,1,0,
690,0,0,22,0,0,32,1512,0,0,0,0,0,1,0,
705,0,0,14,0,0,15,1523,0,0,0,0,0,1,0,
720,0,0,23,0,0,32,1527,0,0,0,0,0,1,0,
735,0,0,15,0,0,15,1538,0,0,0,0,0,1,0,
750,0,0,24,0,0,32,1542,0,0,0,0,0,1,0,
765,0,0,12,0,0,13,1555,0,0,1,0,0,1,0,2,9,0,0,
784,0,0,25,0,0,32,1569,0,0,0,0,0,1,0,
799,0,0,13,0,0,13,1592,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
834,0,0,26,0,0,32,1613,0,0,0,0,0,1,0,
849,0,0,14,0,0,13,1631,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
872,0,0,27,0,0,32,1647,0,0,0,0,0,1,0,
887,0,0,15,0,0,13,1662,0,0,1,0,0,1,0,2,9,0,0,
906,0,0,28,0,0,32,1676,0,0,0,0,0,1,0,
921,0,0,29,0,0,32,1723,0,0,0,0,0,1,0,
936,0,0,30,208,0,4,1746,0,0,6,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
1,9,0,0,
975,0,0,31,68,0,4,1774,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
998,0,0,32,208,0,4,1794,0,0,6,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
1,9,0,0,
1037,0,0,33,68,0,4,1822,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1060,0,0,34,123,0,4,1870,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1091,0,0,35,68,0,4,1893,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1114,0,0,36,123,0,4,1921,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1145,0,0,37,68,0,4,1943,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1168,0,0,38,113,0,4,1972,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1195,0,0,39,0,0,32,1990,0,0,0,0,0,1,0,
1210,0,0,40,0,0,32,2524,0,0,0,0,0,1,0,
};


/* process *****************************
*  File	: RLRTSAGX.PC   
   Date Created : 17/03/2005
    
*  Ver 1.10.01 

*  Purpose : Age and Gender by Workgroup For Lab Tests
            
*  Input Parameters : 
			Command line inputs
				1. Usr_id/Password
				2. Session id
				3. Program Date
				4. Cut-off Month
				5. Range of Nationality Groups
				6. Age Group

*  Output File : RLRTSAGX.lis  
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <rl.h>

#define MAX_LINES 42
#define ESC     0x1B
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"

/***********************************************************************/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */

	/* VARCHAR		uid_pwd			[91],

				nd_operating_facility_id [3],
			    g_facility_id [3],  //added for globalisation
			/o For Diagnosis statistics o/

			d_patient_id		[11],
			d_prev_patient_id	[11],
			d_episode_type		[2],
			d_test_code			[11],

			d_sex				[2],
			d_nationality_code  [5],
			d_date_of_birth		[20],
			d_spec_regd_date_time [30],

			d_country_grp_code	[100][5],
			nd_country_grp_code	[5],
			d_country_grp_nationality [21],

			d_section_code	[5],
			d_section_desc	[41],
            v_section_code	[5],

        	d_prev_country_grp_code		[5],
			d_prev_country_grp_nat		[21],

			d_prev_workgroup_code		[5],
			d_prev_workgroup_desc		[21],

			d_trn_date_time			[17],  /o a date field o/

			/o input parameters to main() o/
			nd_session_id			[16],
			nd_pgm_date			[16],
			
			/o For Cut-off Month periodo/
			nd_fr_preferred_date		[20], 
			nd_to_preferred_date		[20], 

			/oFor Nationality Group o/
			nd_fr_nationality_grp_code	[5],
			nd_to_nationality_grp_code	[5],

			nd_age_range_code [5],

			/o To get parameter Month and Yearo/
			nd_monthyear			[8],
			nd_title_month			[20],

            RANGE_1_FR_LEG        [4],
			RANGE_1_TO_LEG        [4], 
            RANGE_2_FR_LEG        [4],
			RANGE_2_TO_LEG        [4], 
            RANGE_3_FR_LEG        [4],
			RANGE_3_TO_LEG        [4], 
            RANGE_4_FR_LEG        [4],
			RANGE_4_TO_LEG        [4], 
            RANGE_5_FR_LEG        [4],
			RANGE_5_TO_LEG        [4], 
            RANGE_6_FR_LEG        [4],
			RANGE_6_TO_LEG        [4], 
            RANGE_7_FR_LEG        [4],
			RANGE_7_TO_LEG        [4], 
            RANGE_8_FR_LEG        [4],
			RANGE_8_TO_LEG        [4], 
            RANGE_9_FR_LEG        [4],
			RANGE_9_TO_LEG        [4], 

            RANGE_1_FR_LEG_VAL    [20],
			RANGE_1_TO_LEG_VAL    [20], 
            RANGE_2_FR_LEG_VAL    [20],
			RANGE_2_TO_LEG_VAL    [20], 
            RANGE_3_FR_LEG_VAL    [20],
			RANGE_3_TO_LEG_VAL    [20], 
            RANGE_4_FR_LEG_VAL    [20],
			RANGE_4_TO_LEG_VAL    [20], 
            RANGE_5_FR_LEG_VAL    [20],
			RANGE_5_TO_LEG_VAL    [20], 
            RANGE_6_FR_LEG_VAL    [20],
			RANGE_6_TO_LEG_VAL    [20], 
            RANGE_7_FR_LEG_VAL    [20],
			RANGE_7_TO_LEG_VAL    [20], 
            RANGE_8_FR_LEG_VAL    [20],
			RANGE_8_TO_LEG_VAL    [20], 
            RANGE_9_FR_LEG_VAL    [20],
			RANGE_9_TO_LEG_VAL    [20], 

			RANGES_LEGEND         [20], 


            RANGE_1_FR_UNIT        [1],
			RANGE_1_TO_UNIT        [1], 
            RANGE_2_FR_UNIT        [1],
			RANGE_2_TO_UNIT        [1], 
            RANGE_3_FR_UNIT        [1],
			RANGE_3_TO_UNIT        [1], 
            RANGE_4_FR_UNIT        [1],
			RANGE_4_TO_UNIT        [1], 
            RANGE_5_FR_UNIT        [1],
			RANGE_5_TO_UNIT        [1], 
            RANGE_6_FR_UNIT        [1],
			RANGE_6_TO_UNIT        [1], 
            RANGE_7_FR_UNIT        [1],
			RANGE_7_TO_UNIT        [1], 
            RANGE_8_FR_UNIT        [1],
			RANGE_8_TO_UNIT        [1], 
            RANGE_9_FR_UNIT        [1],
			RANGE_9_TO_UNIT        [1], 

		/o for header routine o/
			//d_acc_entity_name		[41],
			d_acc_entity_name		[300],
			d_user				[21],
			d_sysdate			[17],
			d_sysdate1          [17]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } g_facility_id;

struct { unsigned short len; unsigned char arr[11]; } d_patient_id;

struct { unsigned short len; unsigned char arr[11]; } d_prev_patient_id;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[5]; } d_nationality_code;

struct { unsigned short len; unsigned char arr[20]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[30]; } d_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[6]; } d_country_grp_code[100];

struct { unsigned short len; unsigned char arr[5]; } nd_country_grp_code;

struct { unsigned short len; unsigned char arr[21]; } d_country_grp_nationality;

struct { unsigned short len; unsigned char arr[5]; } d_section_code;

struct { unsigned short len; unsigned char arr[41]; } d_section_desc;

struct { unsigned short len; unsigned char arr[5]; } v_section_code;

struct { unsigned short len; unsigned char arr[5]; } d_prev_country_grp_code;

struct { unsigned short len; unsigned char arr[21]; } d_prev_country_grp_nat;

struct { unsigned short len; unsigned char arr[5]; } d_prev_workgroup_code;

struct { unsigned short len; unsigned char arr[21]; } d_prev_workgroup_desc;

struct { unsigned short len; unsigned char arr[17]; } d_trn_date_time;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[16]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } nd_fr_preferred_date;

struct { unsigned short len; unsigned char arr[20]; } nd_to_preferred_date;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_nationality_grp_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_nationality_grp_code;

struct { unsigned short len; unsigned char arr[5]; } nd_age_range_code;

struct { unsigned short len; unsigned char arr[8]; } nd_monthyear;

struct { unsigned short len; unsigned char arr[20]; } nd_title_month;

struct { unsigned short len; unsigned char arr[4]; } RANGE_1_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_1_TO_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_2_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_2_TO_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_3_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_3_TO_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_4_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_4_TO_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_5_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_5_TO_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_6_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_6_TO_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_7_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_7_TO_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_8_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_8_TO_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_9_FR_LEG;

struct { unsigned short len; unsigned char arr[4]; } RANGE_9_TO_LEG;

struct { unsigned short len; unsigned char arr[20]; } RANGE_1_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_1_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_2_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_2_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_3_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_3_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_4_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_4_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_5_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_5_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_6_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_6_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_7_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_7_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_8_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_8_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_9_FR_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGE_9_TO_LEG_VAL;

struct { unsigned short len; unsigned char arr[20]; } RANGES_LEGEND;

struct { unsigned short len; unsigned char arr[1]; } RANGE_1_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_1_TO_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_2_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_2_TO_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_3_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_3_TO_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_4_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_4_TO_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_5_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_5_TO_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_6_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_6_TO_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_7_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_7_TO_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_8_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_8_TO_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_9_FR_UNIT;

struct { unsigned short len; unsigned char arr[1]; } RANGE_9_TO_UNIT;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;


	/* VARCHAR l_translated_value  [500], //added for globalisation
			language_id [5]; */ 
struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;
 //added for globalisation
	int     i; //added for globalisation

int     d_los,nd_pgm_month; 

float	 RANGE_1_FR ,
		 RANGE_1_TO ,
         RANGE_2_FR ,
		 RANGE_2_TO ,
         RANGE_3_FR ,
		 RANGE_3_TO ,
         RANGE_4_FR ,
		 RANGE_4_TO ,
         RANGE_5_FR ,
		 RANGE_5_TO ,
         RANGE_6_FR ,
		 RANGE_6_TO ,
         RANGE_7_FR ,
		 RANGE_7_TO ,
         RANGE_8_FR ,
		 RANGE_8_TO ,
         RANGE_9_FR ,
		 RANGE_9_TO ,
		 NO_OF_RANGES,
         d_age_in_days,d_age_in_months,d_age_in_years;
int		d_country_grp_counter;
long	d_country_grp_count[100];

int     l_rec_count = 0;
char	v_temp[500];
char	filename[150];
char	string_var[100];

/* EXEC SQL END DECLARE SECTION; */ 

/***********************************************************************/

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

/* To get the Test Count */
long	d_age_m_0_6_days	= 0,
		d_age_f_0_6_days	= 0,
		d_age_m_7_28_days	= 0,
		d_age_f_7_28_days	= 0,
		d_age_m_30_365_days	= 0,
		d_age_f_30_365_days	= 0,
		d_age_m_1_4_years	= 0,
		d_age_f_1_4_years	= 0,
		d_age_m_5_14_years	= 0,
		d_age_f_5_14_years	= 0,
		d_age_m_15_24_years	= 0,
		d_age_f_15_24_years	= 0,
		d_age_m_25_44_years	= 0,
		d_age_f_25_44_years	= 0,
		d_age_m_45_64_years	= 0,
		d_age_f_45_64_years	= 0,
		d_age_m_65_years	= 0,
		d_age_f_65_years	= 0,
		
		d_workgroup_m_total = 0,
	    d_total_m = 0,

	    d_workgroup_f_total = 0,
	    d_total_f = 0,

		d_workgroup_grand_total = 0,
		d_grand_total = 0,

		 d_total_m_0_6_days = 0,
		 d_total_f_0_6_days = 0,
		 d_total_m_7_28_days = 0,
		 d_total_f_7_28_days = 0,
	     d_total_m_30_365_days = 0,
	     d_total_f_30_365_days = 0,
	     d_total_m_1_4_years = 0,
	     d_total_f_1_4_years = 0,
	     d_total_m_5_14_years = 0,
	     d_total_f_5_14_years = 0,
	     d_total_m_15_24_years = 0,
	     d_total_f_15_24_years = 0,
	     d_total_m_25_44_years = 0,
	     d_total_f_25_44_years = 0,
		 d_total_m_45_64_years = 0,
		 d_total_f_45_64_years = 0,
	     d_total_m_65_years = 0,
	     d_total_f_65_years = 0;

FILE *f1;

char local_legend[40][600];  //added for globalisation

int lncnt = 0, first_page_flg = 0;
int	page_no=1;

/***********************************************************************/
void proc_main(argc, argv)
int argc;
char *argv[];
{

  void do_report();

	if(argc != 16) 
	{
    	disp_message(ERR_MESG,"Usage rlrtsagx uid/passwd session id pgm date");
    	proc_exit();
   	}

	strcpy(uid_pwd.arr, argv[1]);	
   	uid_pwd.len = strlen(uid_pwd.arr); 
   
	strcpy(nd_session_id.arr, argv[2]);
   	nd_session_id.len = strlen(nd_session_id.arr);
	
    strcpy(nd_pgm_date.arr, argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr); 

	strcpy(nd_operating_facility_id.arr,argv[4]);
	nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

    strcpy(g_facility_id.arr,nd_operating_facility_id.arr);

    strcpy(OUTPUT_FILE_NAME, argv[5]);

	strcpy(nd_fr_preferred_date.arr,argv[6]);
	nd_fr_preferred_date.len = strlen(nd_fr_preferred_date.arr);
    
//	disp_message(ERR_MESG,nd_fr_preferred_date.arr);

//	strcat(nd_fr_preferred_date.arr," ");
//	strcat(nd_fr_preferred_date.arr,argv[7]);
//	nd_fr_preferred_date.len = strlen(nd_fr_preferred_date.arr);

//	disp_message(ERR_MESG,argv[7]);

	strcpy(nd_to_preferred_date.arr,argv[8]);
	nd_to_preferred_date.len = strlen(nd_to_preferred_date.arr);

//	disp_message(ERR_MESG,nd_to_preferred_date.arr);

//	strcat(nd_to_preferred_date.arr," ");
//	strcat(nd_to_preferred_date.arr,argv[9]);
//	nd_to_preferred_date.len = strlen(nd_to_preferred_date.arr);

//	disp_message(ERR_MESG,argv[9]);

	strcpy(nd_fr_nationality_grp_code.arr,argv[10]);
	nd_fr_nationality_grp_code.len = strlen(nd_fr_nationality_grp_code.arr);

//	disp_message(ERR_MESG,nd_fr_nationality_grp_code.arr);

	strcpy(nd_to_nationality_grp_code.arr,argv[11]);
	nd_to_nationality_grp_code.len = strlen(nd_to_nationality_grp_code.arr);

//	disp_message(ERR_MESG,nd_to_nationality_grp_code.arr);

	strcpy(nd_age_range_code.arr,argv[12]);
	nd_age_range_code.len = strlen(nd_age_range_code.arr);

//	disp_message(ERR_MESG,nd_age_range_code.arr);

	strcpy(nd_monthyear.arr,argv[13]);
	nd_monthyear.len = strlen(nd_monthyear.arr);

//	disp_message(ERR_MESG,nd_monthyear.arr);
			
	strcpy(nd_title_month.arr,argv[14]);
	nd_title_month.len = strlen(nd_title_month.arr);
	strcat(nd_title_month.arr," ");
	strcat(nd_title_month.arr,argv[15]);
	nd_title_month.len = strlen(nd_title_month.arr);

//	disp_message(ERR_MESG,nd_title_month.arr);
	

	strcpy(filename,WORKING_DIR);
    strcat(filename,OUTPUT_FILE_NAME);

    if ((f1=fopen(filename,"w+")) == NULL) {
       disp_message(ERR_MESG,"Error in Opening outout file");
       fflush(stdout);
       proc_exit();
	 }

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CONNECT :uid_pwd; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )20;
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
   
/* Added to print report in Landscape format in Laser Printer */
   fprintf(f1,"%c&l1O",ESC); // To Print in Landscape Mode 
   fprintf(f1,"%c&k2S",ESC); // To Condence 
   fprintf(f1,"%c&a5L",ESC); // To print Left Margin

   get_legend_value(20);  //added for globalisation

//  disp_message(ERR_MESG,"Latest");
   do_report();
   fprintf(f1,"%cE",ESC);    // To reset printer 
   fclose(f1);

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


   /* EXEC SQL COMMIT WORK RELEASE; */ 

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
   if (sqlca.sqlcode < 0) goto err_exit;
}


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
   sqlstm.offset = (unsigned int  )66;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at main() occured....");
   proc_exit();
}   
/***********************************************************************/

/******** added for globalisation start ******************/

get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRTSAGX.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRTSAGX.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )81;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRTSAGX.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLRTSAGX.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )104;
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
 
/***********************************************************************/
void print_line(ch,n)
  char ch;
  int n;
{
 int i;
 for(i=0;i<n;i++)
 fprintf(f1,"%c",ch);
 fprintf(f1,"\n");
 }
/***********************************************************************/

/***********************************************************************/
void print_spaces(n) 
int n;
 {
  int i;
  for(i=0;i<n;i++)
  fprintf(f1,"%s"," ");
  }
/***********************************************************************/

/***********************************************************************/
void print_page_header()
{
void print_column_title();
  // register int i;
  fprintf(f1,"\nMDL : RL");
  print_spaces(67);
  fprintf(f1,"%s", d_acc_entity_name.arr);
  print_spaces(60);
  
  //fprintf(f1,"%s", d_sysdate.arr);
  /****** use pl/sql for displying current date depending on language_id********/
	/* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
		:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET_\
CURRENT_DATE ( :language_id ) ; :d_sysdate1 := to_char ( t_date , 'DD/MM/YYYY \
HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )127;
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


  fprintf(f1,"%s", d_sysdate1.arr);

  fprintf(f1,"\n");
  fprintf(f1,"OPR : %s", d_user.arr);
  fprintf(f1,"\n");
  fprintf(f1,"REP : RLRTSAGX");
  print_spaces(51);
  
  //fprintf(f1,"Laboratory Tests Count by Age/Sex Nationality     ");
  fprintf(f1,"%45.45s     ",local_legend[1]);
	                
  print_spaces(47);  
  
  //fprintf(f1,"Page : %4d", page_no++);
  fprintf(f1,"%4.4s : %4d", local_legend[2],page_no++);

  fprintf(f1,"\n");

lncnt += 5;
  
 if(first_page_flg != 1){
	print_column_title();
 }
 print_line('-',175);

lncnt += 1;

return;
}
/***********************************************************************/
/***********************************************************************/
void init_age_range()
 {

	/* EXEC SQL SELECT TO_NUMBER(SUBSTR(:nd_to_preferred_date,1,2))
	         into nd_pgm_month
			 FROM dual ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_NUMBER(SUBSTR(:b0,1,2)) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )150;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_to_preferred_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_pgm_month;
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



	/* EXEC SQL SELECT RANGE_1_FR,RANGE_1_FR_UNIT,RANGE_1_TO,RANGE_1_TO_UNIT,  
	                RANGE_1_FR,RANGE_1_TO,
					RANGE_2_FR,RANGE_2_FR_UNIT,RANGE_2_TO,RANGE_2_TO_UNIT,
					RANGE_2_FR,RANGE_2_TO,
					RANGE_3_FR,RANGE_3_FR_UNIT,RANGE_3_TO,RANGE_3_TO_UNIT,
					RANGE_3_FR,RANGE_3_TO,
					RANGE_4_FR,RANGE_4_FR_UNIT,RANGE_4_TO,RANGE_4_TO_UNIT,
					RANGE_4_FR,RANGE_4_TO,
					RANGE_5_FR,RANGE_5_FR_UNIT,RANGE_5_TO,RANGE_5_TO_UNIT,
					RANGE_5_FR,RANGE_5_TO,
					RANGE_6_FR,RANGE_6_FR_UNIT,RANGE_6_TO,RANGE_6_TO_UNIT,
					RANGE_6_FR,RANGE_6_TO,
					RANGE_7_FR,RANGE_7_FR_UNIT,RANGE_7_TO,RANGE_7_TO_UNIT,
					RANGE_7_FR,RANGE_7_TO,
					RANGE_8_FR,RANGE_8_FR_UNIT,RANGE_8_TO,RANGE_8_TO_UNIT,
					RANGE_8_FR,RANGE_8_TO,
					RANGE_9_FR,RANGE_9_FR_UNIT,RANGE_9_TO,RANGE_9_TO_UNIT,
					RANGE_9_FR,RANGE_9_TO,
					NO_OF_RANGES
	
	INTO			RANGE_1_FR,RANGE_1_FR_UNIT,RANGE_1_TO,RANGE_1_TO_UNIT,  
					RANGE_1_FR_LEG,RANGE_1_TO_LEG,
					RANGE_2_FR,RANGE_2_FR_UNIT,RANGE_2_TO,RANGE_2_TO_UNIT,
					RANGE_2_FR_LEG,RANGE_2_TO_LEG,
					RANGE_3_FR,RANGE_3_FR_UNIT,RANGE_3_TO,RANGE_3_TO_UNIT,
					RANGE_3_FR_LEG,RANGE_3_TO_LEG,
					RANGE_4_FR,RANGE_4_FR_UNIT,RANGE_4_TO,RANGE_4_TO_UNIT,
					RANGE_4_FR_LEG,RANGE_4_TO_LEG,
					RANGE_5_FR,RANGE_5_FR_UNIT,RANGE_5_TO,RANGE_5_TO_UNIT,
					RANGE_5_FR_LEG,RANGE_5_TO_LEG,
					RANGE_6_FR,RANGE_6_FR_UNIT,RANGE_6_TO,RANGE_6_TO_UNIT,
					RANGE_6_FR_LEG,RANGE_6_TO_LEG,
					RANGE_7_FR,RANGE_7_FR_UNIT,RANGE_7_TO,RANGE_7_TO_UNIT,
					RANGE_7_FR_LEG,RANGE_7_TO_LEG,
					RANGE_8_FR,RANGE_8_FR_UNIT,RANGE_8_TO,RANGE_8_TO_UNIT,
					RANGE_8_FR_LEG,RANGE_8_TO_LEG,
					RANGE_9_FR,RANGE_9_FR_UNIT,RANGE_9_TO,RANGE_9_TO_UNIT,
					RANGE_9_FR_LEG,RANGE_9_TO_LEG,
					NO_OF_RANGES
	FROM    AM_SUMM_RANGE  
	WHERE RANGE_ID =:nd_age_range_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select RANGE_1_FR ,RANGE_1_FR_UNIT ,RANGE_1_TO ,RANGE_1_TO_UNIT ,RANGE_1\
_FR ,RANGE_1_TO ,RANGE_2_FR ,RANGE_2_FR_UNIT ,RANGE_2_TO ,RANGE_2_TO_UNIT ,R\
ANGE_2_FR ,RANGE_2_TO ,RANGE_3_FR ,RANGE_3_FR_UNIT ,RANGE_3_TO ,RANGE_3_TO_U\
NIT ,RANGE_3_FR ,RANGE_3_TO ,RANGE_4_FR ,RANGE_4_FR_UNIT ,RANGE_4_TO ,RANGE_\
4_TO_UNIT ,RANGE_4_FR ,RANGE_4_TO ,RANGE_5_FR ,RANGE_5_FR_UNIT ,RANGE_5_TO ,\
RANGE_5_TO_UNIT ,RANGE_5_FR ,RANGE_5_TO ,RANGE_6_FR ,RANGE_6_FR_UNIT ,RANGE_\
6_TO ,RANGE_6_TO_UNIT ,RANGE_6_FR ,RANGE_6_TO ,RANGE_7_FR ,RANGE_7_FR_UNIT ,\
RANGE_7_TO ,RANGE_7_TO_UNIT ,RANGE_7_FR ,RANGE_7_TO ,RANGE_8_FR ,RANGE_8_FR_\
UNIT ,RANGE_8_TO ,RANGE_8_TO_UNIT ,RANGE_8_FR ,RANGE_8_TO ,RANGE_9_FR ,RANGE\
_9_FR_UNIT ,RANGE_9_TO ,RANGE_9_TO_UNIT ,RANGE_9_FR ,RANGE_9_TO ,NO_OF_RANGE\
S into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15\
,:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24,:b25,:b26,:b27,:b28,:b29,:b30,\
:b31,:b32,:b33,:b34,:b35,:b36,:b37,:b38,:b39,:b40,:b41,:b42,:b43,:b44,:b45,:\
b46,:b47,:b48,:b49,:b50,:b51,:b52,:b53,:");
 sqlstm.stmt = "b54  from AM_SUMM_RANGE where RANGE_ID=:b55";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )173;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&RANGE_1_FR;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&RANGE_1_FR_UNIT;
 sqlstm.sqhstl[1] = (unsigned int  )3;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&RANGE_1_TO;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&RANGE_1_TO_UNIT;
 sqlstm.sqhstl[3] = (unsigned int  )3;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&RANGE_1_FR_LEG;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&RANGE_1_TO_LEG;
 sqlstm.sqhstl[5] = (unsigned int  )6;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&RANGE_2_FR;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&RANGE_2_FR_UNIT;
 sqlstm.sqhstl[7] = (unsigned int  )3;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&RANGE_2_TO;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&RANGE_2_TO_UNIT;
 sqlstm.sqhstl[9] = (unsigned int  )3;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&RANGE_2_FR_LEG;
 sqlstm.sqhstl[10] = (unsigned int  )6;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&RANGE_2_TO_LEG;
 sqlstm.sqhstl[11] = (unsigned int  )6;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&RANGE_3_FR;
 sqlstm.sqhstl[12] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&RANGE_3_FR_UNIT;
 sqlstm.sqhstl[13] = (unsigned int  )3;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&RANGE_3_TO;
 sqlstm.sqhstl[14] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&RANGE_3_TO_UNIT;
 sqlstm.sqhstl[15] = (unsigned int  )3;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&RANGE_3_FR_LEG;
 sqlstm.sqhstl[16] = (unsigned int  )6;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&RANGE_3_TO_LEG;
 sqlstm.sqhstl[17] = (unsigned int  )6;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&RANGE_4_FR;
 sqlstm.sqhstl[18] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&RANGE_4_FR_UNIT;
 sqlstm.sqhstl[19] = (unsigned int  )3;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&RANGE_4_TO;
 sqlstm.sqhstl[20] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&RANGE_4_TO_UNIT;
 sqlstm.sqhstl[21] = (unsigned int  )3;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&RANGE_4_FR_LEG;
 sqlstm.sqhstl[22] = (unsigned int  )6;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&RANGE_4_TO_LEG;
 sqlstm.sqhstl[23] = (unsigned int  )6;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&RANGE_5_FR;
 sqlstm.sqhstl[24] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&RANGE_5_FR_UNIT;
 sqlstm.sqhstl[25] = (unsigned int  )3;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&RANGE_5_TO;
 sqlstm.sqhstl[26] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&RANGE_5_TO_UNIT;
 sqlstm.sqhstl[27] = (unsigned int  )3;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&RANGE_5_FR_LEG;
 sqlstm.sqhstl[28] = (unsigned int  )6;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&RANGE_5_TO_LEG;
 sqlstm.sqhstl[29] = (unsigned int  )6;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&RANGE_6_FR;
 sqlstm.sqhstl[30] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&RANGE_6_FR_UNIT;
 sqlstm.sqhstl[31] = (unsigned int  )3;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&RANGE_6_TO;
 sqlstm.sqhstl[32] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&RANGE_6_TO_UNIT;
 sqlstm.sqhstl[33] = (unsigned int  )3;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&RANGE_6_FR_LEG;
 sqlstm.sqhstl[34] = (unsigned int  )6;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&RANGE_6_TO_LEG;
 sqlstm.sqhstl[35] = (unsigned int  )6;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&RANGE_7_FR;
 sqlstm.sqhstl[36] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&RANGE_7_FR_UNIT;
 sqlstm.sqhstl[37] = (unsigned int  )3;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&RANGE_7_TO;
 sqlstm.sqhstl[38] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&RANGE_7_TO_UNIT;
 sqlstm.sqhstl[39] = (unsigned int  )3;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&RANGE_7_FR_LEG;
 sqlstm.sqhstl[40] = (unsigned int  )6;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&RANGE_7_TO_LEG;
 sqlstm.sqhstl[41] = (unsigned int  )6;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)&RANGE_8_FR;
 sqlstm.sqhstl[42] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[42] = (         int  )0;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
 sqlstm.sqhstv[43] = (         void  *)&RANGE_8_FR_UNIT;
 sqlstm.sqhstl[43] = (unsigned int  )3;
 sqlstm.sqhsts[43] = (         int  )0;
 sqlstm.sqindv[43] = (         void  *)0;
 sqlstm.sqinds[43] = (         int  )0;
 sqlstm.sqharm[43] = (unsigned int  )0;
 sqlstm.sqadto[43] = (unsigned short )0;
 sqlstm.sqtdso[43] = (unsigned short )0;
 sqlstm.sqhstv[44] = (         void  *)&RANGE_8_TO;
 sqlstm.sqhstl[44] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[44] = (         int  )0;
 sqlstm.sqindv[44] = (         void  *)0;
 sqlstm.sqinds[44] = (         int  )0;
 sqlstm.sqharm[44] = (unsigned int  )0;
 sqlstm.sqadto[44] = (unsigned short )0;
 sqlstm.sqtdso[44] = (unsigned short )0;
 sqlstm.sqhstv[45] = (         void  *)&RANGE_8_TO_UNIT;
 sqlstm.sqhstl[45] = (unsigned int  )3;
 sqlstm.sqhsts[45] = (         int  )0;
 sqlstm.sqindv[45] = (         void  *)0;
 sqlstm.sqinds[45] = (         int  )0;
 sqlstm.sqharm[45] = (unsigned int  )0;
 sqlstm.sqadto[45] = (unsigned short )0;
 sqlstm.sqtdso[45] = (unsigned short )0;
 sqlstm.sqhstv[46] = (         void  *)&RANGE_8_FR_LEG;
 sqlstm.sqhstl[46] = (unsigned int  )6;
 sqlstm.sqhsts[46] = (         int  )0;
 sqlstm.sqindv[46] = (         void  *)0;
 sqlstm.sqinds[46] = (         int  )0;
 sqlstm.sqharm[46] = (unsigned int  )0;
 sqlstm.sqadto[46] = (unsigned short )0;
 sqlstm.sqtdso[46] = (unsigned short )0;
 sqlstm.sqhstv[47] = (         void  *)&RANGE_8_TO_LEG;
 sqlstm.sqhstl[47] = (unsigned int  )6;
 sqlstm.sqhsts[47] = (         int  )0;
 sqlstm.sqindv[47] = (         void  *)0;
 sqlstm.sqinds[47] = (         int  )0;
 sqlstm.sqharm[47] = (unsigned int  )0;
 sqlstm.sqadto[47] = (unsigned short )0;
 sqlstm.sqtdso[47] = (unsigned short )0;
 sqlstm.sqhstv[48] = (         void  *)&RANGE_9_FR;
 sqlstm.sqhstl[48] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[48] = (         int  )0;
 sqlstm.sqindv[48] = (         void  *)0;
 sqlstm.sqinds[48] = (         int  )0;
 sqlstm.sqharm[48] = (unsigned int  )0;
 sqlstm.sqadto[48] = (unsigned short )0;
 sqlstm.sqtdso[48] = (unsigned short )0;
 sqlstm.sqhstv[49] = (         void  *)&RANGE_9_FR_UNIT;
 sqlstm.sqhstl[49] = (unsigned int  )3;
 sqlstm.sqhsts[49] = (         int  )0;
 sqlstm.sqindv[49] = (         void  *)0;
 sqlstm.sqinds[49] = (         int  )0;
 sqlstm.sqharm[49] = (unsigned int  )0;
 sqlstm.sqadto[49] = (unsigned short )0;
 sqlstm.sqtdso[49] = (unsigned short )0;
 sqlstm.sqhstv[50] = (         void  *)&RANGE_9_TO;
 sqlstm.sqhstl[50] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[50] = (         int  )0;
 sqlstm.sqindv[50] = (         void  *)0;
 sqlstm.sqinds[50] = (         int  )0;
 sqlstm.sqharm[50] = (unsigned int  )0;
 sqlstm.sqadto[50] = (unsigned short )0;
 sqlstm.sqtdso[50] = (unsigned short )0;
 sqlstm.sqhstv[51] = (         void  *)&RANGE_9_TO_UNIT;
 sqlstm.sqhstl[51] = (unsigned int  )3;
 sqlstm.sqhsts[51] = (         int  )0;
 sqlstm.sqindv[51] = (         void  *)0;
 sqlstm.sqinds[51] = (         int  )0;
 sqlstm.sqharm[51] = (unsigned int  )0;
 sqlstm.sqadto[51] = (unsigned short )0;
 sqlstm.sqtdso[51] = (unsigned short )0;
 sqlstm.sqhstv[52] = (         void  *)&RANGE_9_FR_LEG;
 sqlstm.sqhstl[52] = (unsigned int  )6;
 sqlstm.sqhsts[52] = (         int  )0;
 sqlstm.sqindv[52] = (         void  *)0;
 sqlstm.sqinds[52] = (         int  )0;
 sqlstm.sqharm[52] = (unsigned int  )0;
 sqlstm.sqadto[52] = (unsigned short )0;
 sqlstm.sqtdso[52] = (unsigned short )0;
 sqlstm.sqhstv[53] = (         void  *)&RANGE_9_TO_LEG;
 sqlstm.sqhstl[53] = (unsigned int  )6;
 sqlstm.sqhsts[53] = (         int  )0;
 sqlstm.sqindv[53] = (         void  *)0;
 sqlstm.sqinds[53] = (         int  )0;
 sqlstm.sqharm[53] = (unsigned int  )0;
 sqlstm.sqadto[53] = (unsigned short )0;
 sqlstm.sqtdso[53] = (unsigned short )0;
 sqlstm.sqhstv[54] = (         void  *)&NO_OF_RANGES;
 sqlstm.sqhstl[54] = (unsigned int  )sizeof(float);
 sqlstm.sqhsts[54] = (         int  )0;
 sqlstm.sqindv[54] = (         void  *)0;
 sqlstm.sqinds[54] = (         int  )0;
 sqlstm.sqharm[54] = (unsigned int  )0;
 sqlstm.sqadto[54] = (unsigned short )0;
 sqlstm.sqtdso[54] = (unsigned short )0;
 sqlstm.sqhstv[55] = (         void  *)&nd_age_range_code;
 sqlstm.sqhstl[55] = (unsigned int  )7;
 sqlstm.sqhsts[55] = (         int  )0;
 sqlstm.sqindv[55] = (         void  *)0;
 sqlstm.sqinds[55] = (         int  )0;
 sqlstm.sqharm[55] = (unsigned int  )0;
 sqlstm.sqadto[55] = (unsigned short )0;
 sqlstm.sqtdso[55] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
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



   
/*******************************************/
 	if (NO_OF_RANGES >= 1) 
	 {
		if (strlen(RANGE_1_FR_UNIT.arr) != 0) 
		  {
		   if(strcmp(RANGE_1_FR_UNIT.arr, "D") == 0)
			 RANGE_1_FR = RANGE_1_FR/nd_pgm_month;

		   if(strcmp(RANGE_1_FR_UNIT.arr, "W") == 0)
			 RANGE_1_FR = (RANGE_1_FR*7)/nd_pgm_month;

		   if (strcmp(RANGE_1_FR_UNIT.arr, "Y") == 0)
			 RANGE_1_FR = RANGE_1_FR*12;

		  }
		if (strlen(RANGE_1_TO_UNIT.arr) != 0) 
		  {
			RANGE_1_TO = RANGE_1_TO+1;//adding 1 bacuase if the to_value is 6 and next range from is 7 then  
		                              //we are considering the range as < 7
		   if(strcmp(RANGE_1_TO_UNIT.arr, "D") == 0)
			 RANGE_1_TO = RANGE_1_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_1_TO_UNIT.arr, "W") == 0)
			 RANGE_1_TO = (RANGE_1_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_1_TO_UNIT.arr, "Y") == 0)
			 RANGE_1_TO = RANGE_1_TO*12;
		  }
      }
/*******************************************/
   
	if (NO_OF_RANGES >= 2)
	  {
		if (strlen(RANGE_2_FR_UNIT.arr) != 0) 
		  {
		   if(strcmp(RANGE_2_FR_UNIT.arr, "D") == 0)
			 RANGE_2_FR = RANGE_2_FR/nd_pgm_month;
		   
		   if(strcmp(RANGE_2_FR_UNIT.arr, "W") == 0)
			 RANGE_2_FR = (RANGE_2_FR*7)/nd_pgm_month;

		   if (strcmp(RANGE_2_FR_UNIT.arr, "Y") == 0)
			 RANGE_2_FR = RANGE_2_FR*12;

		  }
		if (strlen(RANGE_2_TO_UNIT.arr) != 0) 
		  {
		   RANGE_2_TO = RANGE_2_TO+1;
		   if(strcmp(RANGE_2_TO_UNIT.arr, "D") == 0)
			 RANGE_2_TO = RANGE_2_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_2_TO_UNIT.arr, "W") == 0)
			 RANGE_2_TO = (RANGE_2_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_2_TO_UNIT.arr, "Y") == 0)
			 RANGE_2_TO = RANGE_2_TO*12;
		  }
       }
/*******************************************/
    if (NO_OF_RANGES >= 3)
	  {
		if (strlen(RANGE_3_FR_UNIT.arr) != 0) 
		  {
		   if(strcmp(RANGE_3_FR_UNIT.arr, "D") == 0)
			 RANGE_3_FR = RANGE_3_FR/nd_pgm_month;
		   
		   if(strcmp(RANGE_3_FR_UNIT.arr, "W") == 0)
			 RANGE_3_FR = (RANGE_3_FR*7)/nd_pgm_month;

		   if (strcmp(RANGE_3_FR_UNIT.arr, "Y") == 0)
			 RANGE_3_FR = RANGE_3_FR*12;

		  }
		if (strlen(RANGE_3_TO_UNIT.arr) != 0) 
		  {
		   RANGE_3_TO = RANGE_3_TO+1;
		   if(strcmp(RANGE_3_TO_UNIT.arr, "D") == 0)
			 RANGE_3_TO = RANGE_3_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_3_TO_UNIT.arr, "W") == 0)
			 RANGE_3_TO = (RANGE_3_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_3_TO_UNIT.arr, "Y") == 0)
			 RANGE_3_TO = RANGE_3_TO*12;
		  }
        }
/*******************************************/
	if (NO_OF_RANGES >= 4)
	{
		if (strlen(RANGE_4_FR_UNIT.arr) != 0) 
		  {
		   if(strcmp(RANGE_4_FR_UNIT.arr, "D") == 0)
			 RANGE_4_FR = RANGE_4_FR/nd_pgm_month;
		   
		   if(strcmp(RANGE_4_FR_UNIT.arr, "W") == 0)
			 RANGE_4_FR = (RANGE_4_FR*7)/nd_pgm_month;

		   if (strcmp(RANGE_4_FR_UNIT.arr, "Y") == 0)
			 RANGE_4_FR = RANGE_4_FR*12;

		  }
		if (strlen(RANGE_4_TO_UNIT.arr) != 0) 
		  {
		   RANGE_4_TO = RANGE_4_TO+1;
		   if(strcmp(RANGE_4_TO_UNIT.arr, "D") == 0)
			 RANGE_4_TO = RANGE_4_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_4_TO_UNIT.arr, "W") == 0)
			 RANGE_4_TO = (RANGE_4_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_4_TO_UNIT.arr, "Y") == 0)
			 RANGE_4_TO = RANGE_4_TO*12;
		  }
     } 
/*******************************************/
	if (NO_OF_RANGES >= 5)
	  {
		if (strlen(RANGE_5_FR_UNIT.arr) != 0) 
		  {
		   if(strcmp(RANGE_5_FR_UNIT.arr, "D") == 0)
			 RANGE_5_FR = RANGE_5_FR/nd_pgm_month;
		   
		   if(strcmp(RANGE_5_FR_UNIT.arr, "W") == 0)
			 RANGE_5_FR = (RANGE_5_FR*7)/nd_pgm_month;
		   
		   if (strcmp(RANGE_5_FR_UNIT.arr, "Y") == 0)
			 RANGE_5_FR = RANGE_5_FR*12;

		  }
		if (strlen(RANGE_5_TO_UNIT.arr) != 0) 
		  {
		   RANGE_5_TO = RANGE_5_TO+1;
		   if(strcmp(RANGE_5_TO_UNIT.arr, "D") == 0)
			 RANGE_5_TO = RANGE_5_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_5_TO_UNIT.arr, "W") == 0)
			 RANGE_5_TO = (RANGE_5_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_5_TO_UNIT.arr, "Y") == 0)
			 RANGE_5_TO = RANGE_5_TO*12;
		  }
      }
/*******************************************/
	if (NO_OF_RANGES >= 6)
	  {
		if (strlen(RANGE_6_FR_UNIT.arr) != 0) 
		  {
		   if(strcmp(RANGE_6_FR_UNIT.arr, "D") == 0)
			 RANGE_6_FR = RANGE_6_FR/nd_pgm_month;
		   
		   if(strcmp(RANGE_6_FR_UNIT.arr, "W") == 0)
			 RANGE_6_FR = (RANGE_6_FR*7)/nd_pgm_month;

		   if (strcmp(RANGE_6_FR_UNIT.arr, "Y") == 0)
			 RANGE_6_FR = RANGE_6_FR*12;

		  }
		if (strlen(RANGE_6_TO_UNIT.arr) != 0) 
		  {
		   RANGE_6_TO = RANGE_6_TO+1;
		   if(strcmp(RANGE_6_TO_UNIT.arr, "D") == 0)
			 RANGE_6_TO = RANGE_6_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_6_TO_UNIT.arr, "W") == 0)
			 RANGE_6_TO = (RANGE_6_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_6_TO_UNIT.arr, "Y") == 0)
			 RANGE_6_TO = RANGE_6_TO*12;
		  }
       }
/*******************************************/
	if (NO_OF_RANGES >= 7)
	 {
		if (strlen(RANGE_7_FR_UNIT.arr) != 0) 
		  {
		   if(strcmp(RANGE_7_FR_UNIT.arr, "D") == 0)
			 RANGE_7_FR = RANGE_7_FR/nd_pgm_month;
		   
		   if(strcmp(RANGE_7_FR_UNIT.arr, "W") == 0)
			 RANGE_7_FR = (RANGE_7_FR*7)/nd_pgm_month;

		   if (strcmp(RANGE_7_FR_UNIT.arr, "Y") == 0)
			 RANGE_7_FR = RANGE_7_FR*12;

		  }
		if (strlen(RANGE_7_TO_UNIT.arr) != 0) 
		  {
		   RANGE_7_TO = RANGE_7_TO+1;
		   if(strcmp(RANGE_7_TO_UNIT.arr, "D") == 0)
			 RANGE_7_TO = RANGE_7_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_7_TO_UNIT.arr, "W") == 0)
			 RANGE_7_TO = (RANGE_7_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_7_TO_UNIT.arr, "Y") == 0)
			 RANGE_7_TO = RANGE_7_TO*12;
		  }
       }
/*******************************************/
	if (NO_OF_RANGES >= 8)
	{
		if (strlen(RANGE_8_FR_UNIT.arr) != 0) 
		  {
		   if(strcmp(RANGE_8_FR_UNIT.arr, "D") == 0)
			 RANGE_8_FR = RANGE_8_FR/nd_pgm_month;
		   
		   if(strcmp(RANGE_8_FR_UNIT.arr, "W") == 0)
			 RANGE_8_FR = (RANGE_8_FR*7)/nd_pgm_month;

		   if (strcmp(RANGE_8_FR_UNIT.arr, "Y") == 0)
			 RANGE_8_FR = RANGE_8_FR*12;

		  }
		if (strlen(RANGE_8_TO_UNIT.arr) != 0) 
		  {
		   RANGE_8_TO = RANGE_8_TO+1;
		   if(strcmp(RANGE_8_TO_UNIT.arr, "D") == 0)
			 RANGE_8_TO = RANGE_8_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_8_TO_UNIT.arr, "W") == 0)
			 RANGE_8_TO = (RANGE_8_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_8_TO_UNIT.arr, "Y") == 0)
			 RANGE_8_TO = RANGE_8_TO*12;
		  }
      }
/*******************************************/
	if (NO_OF_RANGES >= 9)
	  {
		if ((strlen(RANGE_9_FR_UNIT.arr) != 0) && RANGE_9_FR > 0)
		  {
		   if(strcmp(RANGE_9_FR_UNIT.arr, "D") == 0)
			 RANGE_9_FR = RANGE_9_FR/nd_pgm_month;
		   
		   if(strcmp(RANGE_9_FR_UNIT.arr, "W") == 0)
			 RANGE_9_FR = (RANGE_9_FR*7)/nd_pgm_month;

		   if (strcmp(RANGE_9_FR_UNIT.arr, "Y") == 0)
			 RANGE_9_FR = RANGE_9_FR*12;

		  }
		if ((strlen(RANGE_9_TO_UNIT.arr) != 0) && RANGE_9_TO > 0)
		  {
		   if(strcmp(RANGE_9_TO_UNIT.arr, "D") == 0)
			 RANGE_9_TO = RANGE_9_TO/nd_pgm_month;
		   
 		   if(strcmp(RANGE_9_TO_UNIT.arr, "W") == 0)
			 RANGE_9_TO = (RANGE_9_TO*7)/nd_pgm_month;

		   if (strcmp(RANGE_9_TO_UNIT.arr, "Y") == 0)
			 RANGE_9_TO = RANGE_9_TO*12;
		  }
        }
    
 }				
/***********************************************************************/

/***********************************************************************/
void print_rep_header()
{
  char	nd_fr_preferred_date_desc	[20],
  nd_to_preferred_date_desc	[20],	
  nd_preferred_monthyr		[20];
  char	nd_fr_nat_grp_code_desc		[20],
  nd_to_nat_grp_code_desc		[20];

  void print_page_header();


  if(strcmp(nd_fr_nationality_grp_code.arr, "!!!!") == 0)
	//strcpy(nd_fr_nat_grp_code_desc, "LOWEST");
	strcpy(nd_fr_nat_grp_code_desc, local_legend[16]);
  else	strcpy(nd_fr_nat_grp_code_desc, nd_fr_nationality_grp_code.arr);

  if(strcmp(nd_to_nationality_grp_code.arr, "~~~~") == 0)
	//strcpy(nd_to_nat_grp_code_desc, "HIGHEST");
	strcpy(nd_to_nat_grp_code_desc, local_legend[17]);
  else	strcpy(nd_to_nat_grp_code_desc, nd_to_nationality_grp_code.arr);

  print_page_header();
  fprintf(f1,VER);
  fprintf(f1,"\n\n\n\n");
  fprintf(f1,"        ");
  
  //fprintf(f1,"INPUT PARAMETERS :\n");
  fprintf(f1,"%16.16s :\n",local_legend[3]);

  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n"); 
  fprintf(f1,"                "); 
  
  //fprintf(f1,"MONTH                         : %-8.8s\n\n", nd_monthyear.arr);
  fprintf(f1,"%5.5s                         : %-8.8s\n\n", local_legend[4],nd_monthyear.arr);

  fprintf(f1,"                ");
  
  //fprintf(f1,"NATIONALITY GROUP FROM        : %s\n\n", nd_fr_nat_grp_code_desc);
  fprintf(f1,"%22.22s        : %s\n\n", local_legend[5],nd_fr_nat_grp_code_desc);

  fprintf(f1,"                ");
  
  //fprintf(f1,"                  TO          : %s\n\n", nd_to_nat_grp_code_desc);
  fprintf(f1,"%22.22s        : %s\n\n", local_legend[6],nd_to_nat_grp_code_desc);

  fprintf(f1,"                ");
  fprintf(f1,"\n");
return;
}                             
/***********************************************************************/

/***********************************************************************/
void print_column_title()
{
 int j;
	print_spaces(73);  
	
	//fprintf(f1,"FOR THE MONTH OF %s", nd_title_month.arr);
	fprintf(f1,"%16.16s %s", local_legend[7],nd_title_month.arr);

	fprintf(f1,"\n");	
//	print_nat_group_desc();
	print_line('_',175);

	print_spaces(31);	
	
	//fprintf(f1,"Age Group:");	
	fprintf(f1,"%9.9s:",local_legend[8]);	

	//fprintf(f1,"|   0 +     |   7 Days  | 29 Days   | 1- 4 yrs. | 5-14 yrs. | 15-24 yrs.| 25-44 yrs.| 45-64 yrs.|  65+ yrs. |        TOTAL"); 
	//fprintf(f1,"|   0 +     |   7 %3.3s  | 29 %3.3s   | 1- 4 %3.3s. | 5-14 %3.3s. | 15-24 %3.3s.| 25-44 %3.3s.| 45-64 %3.3s.|  65+ %3.3s. |        %5.5s",
	//                               local_legend[9],local_legend[9],local_legend[10],local_legend[10],local_legend[10],local_legend[10],local_legend[10],local_legend[10],local_legend[11]); 

	 
	 if (NO_OF_RANGES >= 1) 
		{
   				RANGE_1_FR_LEG_VAL.arr[0]	= '\0';
                RANGE_1_FR_LEG_VAL.len		= 0;
				
				RANGES_LEGEND.arr[0]	= '\0';
                RANGES_LEGEND.len		= 0;
			 if(strcmp(RANGE_1_FR_UNIT.arr, "D") == 0)
				strcpy(RANGE_1_FR_LEG_VAL.arr,local_legend[9]);
			 if(strcmp(RANGE_1_FR_UNIT.arr, "W") == 0)
				 strcpy(RANGE_1_FR_LEG_VAL.arr,local_legend[22]);
			 if(strcmp(RANGE_1_FR_UNIT.arr, "M") == 0)
				 strcpy(RANGE_1_FR_LEG_VAL.arr,local_legend[21]);
			 if(strcmp(RANGE_1_FR_UNIT.arr, "Y") == 0)
				 strcpy(RANGE_1_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_1_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_1_FR_LEG_VAL.arr);
		  fprintf(f1,"|%10.10s -",RANGES_LEGEND.arr);
        }
     if (NO_OF_RANGES >= 2) 
		{
  				RANGE_2_FR_LEG_VAL.arr[0]	= '\0';
                RANGE_2_FR_LEG_VAL.len		= 0;
				RANGES_LEGEND.arr[0]	= '\0';
                RANGES_LEGEND.len		= 0;

			 if(strcmp(RANGE_2_FR_UNIT.arr, "D") == 0)
				 strcpy(RANGE_2_FR_LEG_VAL.arr,local_legend[9]);
			 if(strcmp(RANGE_2_FR_UNIT.arr, "W") == 0)
				 strcpy(RANGE_2_FR_LEG_VAL.arr,local_legend[22]);
			 if(strcmp(RANGE_2_FR_UNIT.arr, "M") == 0)
				 strcpy(RANGE_2_FR_LEG_VAL.arr,local_legend[21]);
			 if(strcmp(RANGE_2_FR_UNIT.arr, "Y") == 0)
				 strcpy(RANGE_2_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_2_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_2_FR_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s -",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 3) 
	    {
			RANGE_3_FR_LEG_VAL.arr[0]	= '\0';
            RANGE_3_FR_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;

		 if(strcmp(RANGE_3_FR_UNIT.arr, "D") == 0)
             strcpy(RANGE_3_FR_LEG_VAL.arr,local_legend[9]);			 
		 if(strcmp(RANGE_3_FR_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_3_FR_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_3_FR_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_3_FR_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_3_FR_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_3_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_3_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_3_FR_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s -",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 4) 
		{
			RANGE_4_FR_LEG_VAL.arr[0]	= '\0';
            RANGE_4_FR_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;

		 if(strcmp(RANGE_4_FR_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_4_FR_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_4_FR_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_4_FR_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_4_FR_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_4_FR_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_4_FR_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_4_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_4_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_4_FR_LEG_VAL.arr);
		fprintf(f1,"|%9.9s -",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 5) 
		{ 
			RANGE_5_FR_LEG_VAL.arr[0]	= '\0';
            RANGE_5_FR_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;

		 if(strcmp(RANGE_5_FR_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_5_FR_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_5_FR_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_5_FR_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_5_FR_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_5_FR_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_5_FR_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_5_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_5_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_5_FR_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s -",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 6) 
		 {
			RANGE_6_FR_LEG_VAL.arr[0]	= '\0';
            RANGE_6_FR_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;
		 
		 if(strcmp(RANGE_6_FR_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_6_FR_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_6_FR_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_6_FR_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_6_FR_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_6_FR_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_6_FR_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_6_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_6_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_6_FR_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s -",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 7) 
		 {
			RANGE_7_FR_LEG_VAL.arr[0]	= '\0';
            RANGE_7_FR_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;
		
		 if(strcmp(RANGE_7_FR_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_7_FR_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_7_FR_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_7_FR_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_7_FR_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_7_FR_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_7_FR_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_7_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_7_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_7_FR_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s -",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 8) 
		 {
			RANGE_8_FR_LEG_VAL.arr[0]	= '\0';
            RANGE_8_FR_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;
		
		 if(strcmp(RANGE_8_FR_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_8_FR_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_8_FR_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_8_FR_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_8_FR_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_8_FR_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_8_FR_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_8_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_8_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_8_FR_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s -",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 9) 
		 {
			RANGE_9_FR_LEG_VAL.arr[0]	= '\0';
            RANGE_9_FR_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;

		 if(strcmp(RANGE_9_FR_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_9_FR_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_9_FR_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_9_FR_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_9_FR_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_9_FR_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_9_FR_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_9_FR_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_9_FR_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_9_FR_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s -",RANGES_LEGEND.arr);
		}
		
        
        fprintf(f1,"|        %5.5s",local_legend[11]);
       

	fprintf(f1,"\n");
	

	print_spaces(41);
   
     if (NO_OF_RANGES >= 1) 
		
		{
			RANGE_1_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_1_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;
		
			 if(strcmp(RANGE_1_TO_UNIT.arr, "D") == 0)
				strcpy(RANGE_1_TO_LEG_VAL.arr,local_legend[9]);
			 if(strcmp(RANGE_1_TO_UNIT.arr, "W") == 0)
				 strcpy(RANGE_1_TO_LEG_VAL.arr,local_legend[22]);
			 if(strcmp(RANGE_1_TO_UNIT.arr, "M") == 0)
				 strcpy(RANGE_1_TO_LEG_VAL.arr,local_legend[21]);
			 if(strcmp(RANGE_1_TO_UNIT.arr, "Y") == 0)
				 strcpy(RANGE_1_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_1_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_1_TO_LEG_VAL.arr);
		  fprintf(f1,"|%10.10s  ",RANGES_LEGEND.arr);
        }
     if (NO_OF_RANGES >= 2) 
		{
			RANGE_2_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_2_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;

			 if(strcmp(RANGE_2_TO_UNIT.arr, "D") == 0)
				 strcpy(RANGE_2_TO_LEG_VAL.arr,local_legend[9]);
			 if(strcmp(RANGE_2_TO_UNIT.arr, "W") == 0)
				 strcpy(RANGE_2_TO_LEG_VAL.arr,local_legend[22]);
			 if(strcmp(RANGE_2_TO_UNIT.arr, "M") == 0)
				 strcpy(RANGE_2_TO_LEG_VAL.arr,local_legend[21]);
			 if(strcmp(RANGE_2_TO_UNIT.arr, "Y") == 0)
				 strcpy(RANGE_2_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_2_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_2_TO_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s  ",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 3) 
	    {
			RANGE_3_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_3_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;


		 if(strcmp(RANGE_3_TO_UNIT.arr, "D") == 0)
             strcpy(RANGE_3_TO_LEG_VAL.arr,local_legend[9]);			 
		 if(strcmp(RANGE_3_TO_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_3_TO_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_3_TO_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_3_TO_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_3_TO_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_3_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_3_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_3_TO_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s  ",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 4) 
		{
			RANGE_4_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_4_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;
		
		 if(strcmp(RANGE_4_TO_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_4_TO_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_4_TO_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_4_TO_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_4_TO_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_4_TO_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_4_TO_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_4_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_4_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_4_TO_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s  ",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 5) 
		{ 
			RANGE_5_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_5_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;

	
		 if(strcmp(RANGE_5_TO_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_5_TO_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_5_TO_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_5_TO_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_5_TO_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_5_TO_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_5_TO_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_5_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_5_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_5_TO_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s  ",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 6) 
		 {
			RANGE_6_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_6_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;


		 if(strcmp(RANGE_6_TO_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_6_TO_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_6_TO_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_6_TO_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_6_TO_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_6_TO_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_6_TO_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_6_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_6_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_6_TO_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s  ",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 7) 
		 {
			RANGE_7_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_7_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;

		
		 if(strcmp(RANGE_7_TO_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_7_TO_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_7_TO_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_7_TO_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_7_TO_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_7_TO_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_7_TO_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_7_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_7_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_7_TO_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s  ",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 8) 
		 {
			RANGE_8_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_8_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;


		 if(strcmp(RANGE_8_TO_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_8_TO_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_8_TO_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_8_TO_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_8_TO_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_8_TO_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_8_TO_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_8_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_8_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_8_TO_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s  ",RANGES_LEGEND.arr);
		}
     if (NO_OF_RANGES >= 9) 
		 {
			RANGE_9_TO_LEG_VAL.arr[0]	= '\0';
            RANGE_9_TO_LEG_VAL.len		= 0;
			RANGES_LEGEND.arr[0]	= '\0';
            RANGES_LEGEND.len		= 0;
		 
		 if(strcmp(RANGE_9_TO_UNIT.arr, "D") == 0)
   		    strcpy(RANGE_9_TO_LEG_VAL.arr,local_legend[9]);
		 if(strcmp(RANGE_9_TO_UNIT.arr, "W") == 0)
   		    strcpy(RANGE_9_TO_LEG_VAL.arr,local_legend[22]);
		 if(strcmp(RANGE_9_TO_UNIT.arr, "M") == 0)
   		    strcpy(RANGE_9_TO_LEG_VAL.arr,local_legend[21]);
		 if(strcmp(RANGE_9_TO_UNIT.arr, "Y") == 0)
   		    strcpy(RANGE_9_TO_LEG_VAL.arr,local_legend[10]);

		  strcat(RANGES_LEGEND.arr,RANGE_9_TO_LEG.arr);
          strcat(RANGES_LEGEND.arr," ");
          strcat(RANGES_LEGEND.arr,RANGE_9_TO_LEG_VAL.arr);
		  fprintf(f1,"|%9.9s  ",RANGES_LEGEND.arr);
		}
	
	fprintf(f1,"\n");

	
	//fprintf(f1,"Lab Section:");
	fprintf(f1,"%11.11s:",local_legend[12]);

	print_spaces(25);
	
	//fprintf(f1,"Sex:");		 
	fprintf(f1,"%3.3s:",local_legend[13]);		 

	//fprintf(f1,"|  M  |  F  |  M  |  F  |  M  |  F  |  M  |  F  |  M  |  F  |  M  |  F  |  M  |  F  |  M  |  F  |  M  |  F  |    M   |    F   |  GT");
	//fprintf(f1,"|  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |  %1.1s  |    %1.1s   |    %1.1s   |  %2.2s",
	//                local_legend[14],local_legend[15],local_legend[14],local_legend[15],local_legend[14],local_legend[15],local_legend[14],local_legend[15],local_legend[14],local_legend[15],local_legend[14],local_legend[15],
	//				local_legend[14],local_legend[15],local_legend[14],local_legend[15],local_legend[14],local_legend[15],local_legend[14],local_legend[15],local_legend[18]);
     if (NO_OF_RANGES >= 1) 
		fprintf(f1,"|   %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);
     if (NO_OF_RANGES >= 2) 
		fprintf(f1,"|  %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);
     if (NO_OF_RANGES >= 3) 
		fprintf(f1,"|  %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);
     if (NO_OF_RANGES >= 4) 
		fprintf(f1,"|  %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);
     if (NO_OF_RANGES >= 5) 
		fprintf(f1,"|  %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);
     if (NO_OF_RANGES >= 6) 
		fprintf(f1,"|  %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);
     if (NO_OF_RANGES >= 7) 
		fprintf(f1,"|  %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);
     if (NO_OF_RANGES >= 8) 
		fprintf(f1,"|  %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);
     if (NO_OF_RANGES >= 9) 
		fprintf(f1,"|  %1.1s  |  %1.1s  ",local_legend[14],local_legend[15]);

		fprintf(f1,"|    %1.1s  |    %1.1s  ",local_legend[14],local_legend[15]);
		fprintf(f1,"|    %2.2s",local_legend[18]);

	fprintf(f1,"\n");

lncnt += 3;

return;
}

/***********************************************************************/
void page_break()
 {
	lncnt = 0;
	// fprintf(f1,"");
	fprintf(f1,"\f");
	print_page_header();
 }
/***********************************************************************/

/***********************************************************************/
/* get the header details */
void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL	SELECT	ACC_ENTITY_NAME, /o description of the institution o/
			USER,
			TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
		INTO	:d_acc_entity_name,
			:d_user,
			:d_sysdate
		FROM	SY_ACC_ENTITY_lang_vw
		WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		and language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:b\
3 and language_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )412;
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

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )447;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/ 
void dclr_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
	

	/* EXEC SQL DECLARE section_CUR CURSOR FOR 
	SELECT SECTION_CODE
	  FROM RL_SECTION_CTL
     WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	 order by section_code; */ 


	/* EXEC SQL DECLARE PATIENT_CUR CURSOR FOR 
	SELECT A.patient_id, A.episode_type, B.test_code,to_char(A.spec_regd_date_time,'dd/mm/yyyy') spec_regd_date_time,A.section_code
	  FROM RL_REQUEST_HEADER A, RL_TEST_RESULT B
	 WHERE A.spec_regd_date_time  BETWEEN  TO_DATE(:nd_fr_preferred_date, 'DD/MM/YYYY')
	                                   AND TO_DATE(:nd_to_preferred_date, 'DD/MM/YYYY') + 1
	   AND A.specimen_no = B.specimen_no
	   AND A.operating_facility_id = :nd_operating_facility_id
	   AND A.operating_facility_id = B.operating_facility_id
	   
	   AND NVL(A.cancelled_yn, 'N') <> 'Y' 
       AND NVL(B.cancelled_yn, 'N') <> 'Y'
	   and a.section_code =b.section_code
  	   AND A.PATIENT_ID IN (
	                        SELECT PATIENT_ID FROM  RL_PATIENT_MAST WHERE NATIONALITY_CODE  IN 
					          (SELECT MEMBER_ID FROM AM_STAT_GRP_DETAIL 
							   WHERE STAT_GRP_ID =:nd_fr_nationality_grp_code)
                            UNION ALL
                             SELECT PATIENT_ID FROM  MP_PATIENT_MAST WHERE NATIONALITY_CODE  IN 
							 (SELECT MEMBER_ID FROM AM_STAT_GRP_DETAIL 
                              WHERE STAT_GRP_ID =:nd_fr_nationality_grp_code)
							); */ 

    
	/* EXEC SQL DECLARE PATIENT_CUR_2 CURSOR FOR 
	SELECT DISTINCT A.patient_id "patient_id",A.episode_type
	  FROM RL_REQUEST_HEADER A, RL_TEST_RESULT B
	 WHERE A.spec_regd_date_time  BETWEEN  TO_DATE(:nd_fr_preferred_date, 'DD/MM/YYYY')
	                                   AND TO_DATE(:nd_to_preferred_date, 'DD/MM/YYYY') + 1
	   AND A.specimen_no = B.specimen_no
	   AND A.operating_facility_id = :nd_operating_facility_id
	   AND A.operating_facility_id = B.operating_facility_id
	   AND NVL(A.cancelled_yn, 'N') <> 'Y' 
       AND NVL(B.cancelled_yn, 'N') <> 'Y'
	   and a.section_code =b.section_code
  	   AND A.PATIENT_ID IN (
	                        SELECT PATIENT_ID FROM  RL_PATIENT_MAST WHERE NATIONALITY_CODE  IN 
					          (SELECT MEMBER_ID FROM AM_STAT_GRP_DETAIL 
							   WHERE STAT_GRP_ID =:nd_fr_nationality_grp_code)
                            UNION ALL
                             SELECT PATIENT_ID FROM  MP_PATIENT_MAST WHERE NATIONALITY_CODE  IN 
							 (SELECT MEMBER_ID FROM AM_STAT_GRP_DETAIL 
                              WHERE STAT_GRP_ID =:nd_fr_nationality_grp_code)
							)	   
	   ORDER BY A.patient_id; */ 


   	/*EXEC SQL DECLARE COUNTRY_GROUP_CUR CURSOR FOR 
			SELECT COUNTRY_GRP_CODE
	          FROM MP_COUNTRY_GROUP_MAST 
			  WHERE COUNTRY_GRP_CODE BETWEEN nvl(:nd_fr_nationality_grp_code,'!!!!') 
			  AND nvl(:nd_to_nationality_grp_code,'~~~~')
			  ORDER BY COUNTRY_GRP_CODE;
			  commennted and added code on 18/01/2008 because table does not exist int SRDV database
			  */
	/* EXEC SQL DECLARE COUNTRY_GROUP_CUR CURSOR FOR 
			SELECT MEMBER_ID
	          FROM AM_STAT_GRP_DETAIL 
			  WHERE STAT_GRP_ID =:nd_fr_nationality_grp_code
			  ORDER BY STAT_GRP_ID; */ 


return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )462;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_cur() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
void open_section_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL OPEN section_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0012;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )477;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
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
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )496;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at open_section_cur() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
void open_patient_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL OPEN PATIENT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0013;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )511;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fr_preferred_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_preferred_date;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_fr_nationality_grp_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_fr_nationality_grp_code;
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



return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )546;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at open_patient_cur() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
void open_patient_cur_2()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL OPEN PATIENT_CUR_2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0014;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )561;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fr_preferred_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_preferred_date;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_fr_nationality_grp_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_fr_nationality_grp_code;
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



return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )596;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at open_patient_cur_2() occured....");
   proc_exit();
}
/***********************************************************************/


/***********************************************************************/
void open_country_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL OPEN COUNTRY_GROUP_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0015;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )611;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fr_nationality_grp_code;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )630;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at open_country_cur() occured....");
   proc_exit();
}
/***********************************************************************/


/***********************************************************************/
void close_section_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL CLOSE section_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )645;
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
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )660;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at close_section_cur() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
void close_patient_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL CLOSE PATIENT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )675;
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
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )690;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at close_patient_cur() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
void close_patient_cur_2()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL CLOSE PATIENT_CUR_2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )705;
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
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )720;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at close_patient_cur_2() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
void close_country_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL CLOSE COUNTRY_GROUP_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )735;
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
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )750;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at close_country_cur() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
int fetch_section_cur()
{
 d_section_code.arr[0]		= '\0';
 d_section_code.len			= 0;

	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL FETCH section_CUR INTO	
						d_section_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 56;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )765;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_section_code;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
  {  
	return 0; 
  }
 
 d_section_code.arr[d_section_code.len]		= '\0';

 return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
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


   disp_message(ORA_MESG,"Oracle error at fetch_section_cur() occured....");
   proc_exit();
   return 0;
}
/***********************************************************************/

/***********************************************************************/
int fetch_patient_cur()
{

  d_patient_id.arr[0] = '\0';
  d_episode_type.arr[0] = '\0';	
  d_test_code.arr[0] = '\0';
  d_spec_regd_date_time.arr[0] = '\0';

  d_patient_id.len = 0;
  d_episode_type.len = 0;
  d_test_code.len = 0;
  d_spec_regd_date_time.len = 0;


	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL FETCH  PATIENT_CUR INTO	
						d_patient_id,
						d_episode_type,
						d_test_code,
						d_spec_regd_date_time,
						v_section_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 56;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )799;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
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
  sqlstm.sqhstv[2] = (         void  *)&d_test_code;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_spec_regd_date_time;
  sqlstm.sqhstl[3] = (unsigned int  )32;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&v_section_code;
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



  if (NODATAFOUND)
  {  
	return 0; 
  }
 
  d_patient_id.arr[d_patient_id.len] = '\0';
  d_episode_type.arr[d_episode_type.len] = '\0';	
  d_test_code.arr[d_test_code.len] = '\0';
  d_spec_regd_date_time.arr[d_spec_regd_date_time.len] = '\0';

 return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )834;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_patient_cur() occured....");
   proc_exit();
   return 0;
}
/***********************************************************************/

/***********************************************************************/
int fetch_patient_cur_2()
{

  d_patient_id.arr[0] = '\0';
  d_patient_id.len = 0;

  d_episode_type.arr[0] = '\0';	
  d_episode_type.len = 0;

	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL FETCH  PATIENT_CUR_2 INTO	
						d_patient_id,
						d_episode_type; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 56;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )849;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
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
  {  
	return 0; 
  }
 
  d_patient_id.arr[d_patient_id.len] = '\0';
  d_episode_type.arr[d_episode_type.len] = '\0';	

 return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )872;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_patient_cur_2() occured....");
   proc_exit();
   return 0;
}
/***********************************************************************/


/***********************************************************************/
int fetch_country_cur()
{
 nd_country_grp_code.arr[0]		= '\0';
 nd_country_grp_code.len			= 0;

	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL FETCH COUNTRY_GROUP_CUR INTO	
						nd_country_grp_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 56;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )887;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_country_grp_code;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
  {  
	return 0; 
  }
 
 nd_country_grp_code.arr[nd_country_grp_code.len]		= '\0';

 return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )906;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_country_cur() occured....");
   proc_exit();
   return 0;
}
/***********************************************************************/

/***********************************************************************/
void get_country_group()
{
  int i;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  open_country_cur();
  d_country_grp_counter = 0;
  
  while (fetch_country_cur())
  {
	d_country_grp_counter++;
	strcpy(d_country_grp_code[d_country_grp_counter].arr,nd_country_grp_code.arr);
	d_country_grp_code[d_country_grp_counter].len = strlen(d_country_grp_code[d_country_grp_counter].arr);
//	disp_message(ERR_MESG,d_country_grp_code[d_country_grp_counter].arr);	
  }

	if ((strcmp(nd_fr_nationality_grp_code.arr,"!!!!") == 0) && 
			  (strcmp(nd_to_nationality_grp_code.arr,"~~~~") == 0))
	{
	d_country_grp_counter++;
	strcpy(d_country_grp_code[d_country_grp_counter].arr,"NC");
	d_country_grp_code[d_country_grp_counter].len = strlen(d_country_grp_code[d_country_grp_counter].arr);
	}
/* checking 
for (i = 1;i<=d_country_grp_counter;i++)
{
fprintf(f1,"%s ",d_country_grp_code[i].arr);
}
*/

		/********initialize the national counter **********/ 
			for (i=1;i <= d_country_grp_counter;i++)
				{
					d_country_grp_count[i] = 0;
				}
return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )921;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_country_grp() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
int get_patient_details()
{

int i;

d_sex.arr[0] = '\0';
d_nationality_code.arr[0] = '\0';
d_date_of_birth.arr[0] = '\0';
nd_country_grp_code.arr[0] = '\0';

	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


		if ((strcmp(d_episode_type.arr,"I") == 0) || 
			(strcmp(d_episode_type.arr,"O") == 0) ||
			(strcmp(d_episode_type.arr,"H") == 0))
			{
			/* EXEC SQL SELECT A.sex, nvl(A.nationality_code,'NC'), A.date_of_birth, 
							//to_date(:d_spec_regd_date_time,'dd/mm/yyyy hh24:mi') - A.date_of_birth age_in_days,
							months_between(to_date(:d_spec_regd_date_time,'dd/mm/yyyy hh24:mi'),A.date_of_birth)  age_in_months
							//months_between(to_date(:d_spec_regd_date_time,'dd/mm/yyyy hh24:mi'),A.date_of_birth)/12 age_in_yrs
					   INTO d_sex,d_nationality_code,d_date_of_birth,
							//d_age_in_days,
							d_age_in_months
							//d_age_in_years
					   FROM MP_PATIENT_MAST A	
					  WHERE A.patient_id = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select A.sex ,nvl(A.nationality_code,'NC') ,A.date_of_birt\
h ,months_between(to_date(:b0,'dd/mm/yyyy hh24:mi'),A.date_of_birth) age_in_mo\
nths into :b1,:b2,:b3,:b4  from MP_PATIENT_MAST A where A.patient_id=:b5";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )936;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )32;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_sex;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_nationality_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[3] = (unsigned int  )22;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_age_in_months;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(float);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
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



			d_sex.arr[d_sex.len] = '\0';
			d_nationality_code.arr[d_nationality_code.len] = '\0';
			d_date_of_birth.arr[d_date_of_birth.len] = '\0';
			
			if (strcmp(d_nationality_code.arr,"NC") == 0) 
			{
				strcpy(nd_country_grp_code.arr,"NC");
				nd_country_grp_code.len = strlen(nd_country_grp_code.arr);
				}
			else
			{
	   			/*EXEC SQL SELECT COUNTRY_GRP_CODE
				  INTO nd_country_grp_code
			      FROM MP_COUNTRY
				  WHERE COUNTRY_CODE = :d_nationality_code;
				  changed and added code on 18/01/2008 because country_grp_code does not exist in mp_country table in SRDV database*/

				  /* EXEC SQL SELECT COUNTRY_CODE
				  INTO nd_country_grp_code
			      FROM MP_COUNTRY
				  WHERE COUNTRY_CODE = :d_nationality_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 56;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select COUNTRY_CODE into :b0  from MP_COUNTRY where COU\
NTRY_CODE=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )975;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_country_grp_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_nationality_code;
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


	
				nd_country_grp_code.arr[nd_country_grp_code.len] = '\0';					
			}

	
		for (i=1;i <= d_country_grp_counter;i++)
				{
					if (strcmp(d_country_grp_code[i].arr,nd_country_grp_code.arr) == 0)
					{
						return 1;
					} 
				}
			return 0;
			}
		else
			{
			/* EXEC SQL SELECT A.sex, nvl(A.nationality_code,'NC'), A.date_of_birth,
							//to_date(:d_spec_regd_date_time,'dd/mm/yyyy hh24:mi') - A.date_of_birth age_in_days,
							months_between(to_date(:d_spec_regd_date_time,'dd/mm/yyyy hh24:mi'),A.date_of_birth) age_in_months
							//months_between(to_date(:d_spec_regd_date_time,'dd/mm/yyyy hh24:mi'),A.date_of_birth)/12 age_in_yrs
					   INTO d_sex,d_nationality_code,d_date_of_birth,
							//d_age_in_days,
							d_age_in_months
							//d_age_in_years
					   FROM RL_PATIENT_MAST A
					  WHERE A.patient_id = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select A.sex ,nvl(A.nationality_code,'NC') ,A.date_of_birt\
h ,months_between(to_date(:b0,'dd/mm/yyyy hh24:mi'),A.date_of_birth) age_in_mo\
nths into :b1,:b2,:b3,:b4  from RL_PATIENT_MAST A where A.patient_id=:b5";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )998;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )32;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_sex;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_nationality_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[3] = (unsigned int  )22;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_age_in_months;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(float);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
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



			d_sex.arr[d_sex.len] = '\0';
			d_nationality_code.arr[d_nationality_code.len] = '\0';
			d_date_of_birth.arr[d_date_of_birth.len] = '\0';

			if (strcmp(d_nationality_code.arr,"NC") == 0) 
			{
				strcpy(nd_country_grp_code.arr,"NC");
				nd_country_grp_code.len = strlen(nd_country_grp_code.arr);
				}
			else
			{
	   			/*EXEC SQL SELECT COUNTRY_GRP_CODE
				  INTO nd_country_grp_code
			      FROM MP_COUNTRY
				  WHERE COUNTRY_CODE = :d_nationality_code;
				  changed and added code on 18/01/2008 because country_grp_code does not exist in mp_country table in SRDV database*/

				  /* EXEC SQL SELECT COUNTRY_CODE
				  INTO nd_country_grp_code
			      FROM MP_COUNTRY
				  WHERE COUNTRY_CODE = :d_nationality_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 56;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select COUNTRY_CODE into :b0  from MP_COUNTRY where COU\
NTRY_CODE=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1037;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_country_grp_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_nationality_code;
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


	
				nd_country_grp_code.arr[nd_country_grp_code.len] = '\0';					
			}

			for (i=1;i <= d_country_grp_counter;i++)
				{
					if (strcmp(d_country_grp_code[i].arr,nd_country_grp_code.arr) == 0)
					{
						return 1;
					} 
				}
			return 0;
			}
err_exit:
return 0;
}
/***********************************************************************/

/***********************************************************************/
void get_patient_details_2()
{

int i;

d_sex.arr[0] = '\0';
d_nationality_code.arr[0] = '\0';
d_date_of_birth.arr[0] = '\0';
nd_country_grp_code.arr[0] = '\0';

	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


		if ((strcmp(d_episode_type.arr,"I") == 0) || 
			(strcmp(d_episode_type.arr,"O") == 0) ||
			(strcmp(d_episode_type.arr,"H") == 0))
			{
		    /* 
			EXEC SQL SELECT A.sex, nvl(A.nationality_code,'NC'), A.date_of_birth, 
							TRUNC(sysdate - A.date_of_birth) age_in_days,
							TRUNC(months_between(sysdate,A.date_of_birth)/12) age_in_yrs
					   INTO d_sex,d_nationality_code,d_date_of_birth,
							d_age_in_days,d_age_in_years
					   FROM MP_PATIENT_MAST A	
					  WHERE A.patient_id = :d_patient_id;*/
		
			/* EXEC SQL SELECT A.sex, nvl(A.nationality_code,'NC'), A.date_of_birth 
					   INTO d_sex,d_nationality_code,d_date_of_birth
					   FROM MP_PATIENT_MAST A	
					  WHERE A.patient_id = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select A.sex ,nvl(A.nationality_code,'NC') ,A.date_of_birt\
h into :b0,:b1,:b2  from MP_PATIENT_MAST A where A.patient_id=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1060;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_sex;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_nationality_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
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




			d_sex.arr[d_sex.len] = '\0';
			d_nationality_code.arr[d_nationality_code.len] = '\0';
			d_date_of_birth.arr[d_date_of_birth.len] = '\0';

			if (strcmp(d_nationality_code.arr,"NC") == 0) 
			{
				strcpy(nd_country_grp_code.arr,"NC");
				nd_country_grp_code.len = strlen(nd_country_grp_code.arr);
				}
			else
			{
	   			/*EXEC SQL SELECT COUNTRY_GRP_CODE
				  INTO nd_country_grp_code
			      FROM MP_COUNTRY
				  WHERE COUNTRY_CODE = :d_nationality_code;
				  changed and added code on 18/01/2008 because country_grp_code does not exist in mp_country table in SRDV database*/

				  /* EXEC SQL SELECT COUNTRY_CODE
				  INTO nd_country_grp_code
			      FROM MP_COUNTRY
				  WHERE COUNTRY_CODE = :d_nationality_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 56;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select COUNTRY_CODE into :b0  from MP_COUNTRY where COU\
NTRY_CODE=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1091;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_country_grp_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_nationality_code;
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


	
				nd_country_grp_code.arr[nd_country_grp_code.len] = '\0';					
			}

	
		for (i=1;i <= d_country_grp_counter;i++)
				{
					if (strcmp(d_country_grp_code[i].arr,nd_country_grp_code.arr) == 0)
					{
						d_country_grp_count[i]++;
					} 
				}
			}
		else
			{
			/*
			EXEC SQL SELECT A.sex, nvl(A.nationality_code,'NC'), A.date_of_birth,
							TRUNC(sysdate - A.date_of_birth) age_in_days,
							TRUNC(months_between(sysdate,A.date_of_birth)/12) age_in_yrs
					   INTO d_sex,d_nationality_code,d_date_of_birth,
							d_age_in_days,d_age_in_years
					   FROM RL_PATIENT_MAST A
					  WHERE A.patient_id = :d_patient_id;*/

			/* EXEC SQL SELECT A.sex, nvl(A.nationality_code,'NC'), A.date_of_birth
					   INTO d_sex,d_nationality_code,d_date_of_birth
					   FROM RL_PATIENT_MAST A
					  WHERE A.patient_id = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select A.sex ,nvl(A.nationality_code,'NC') ,A.date_of_birt\
h into :b0,:b1,:b2  from RL_PATIENT_MAST A where A.patient_id=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1114;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_sex;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_nationality_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
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



			d_sex.arr[d_sex.len] = '\0';
			d_nationality_code.arr[d_nationality_code.len] = '\0';
			d_date_of_birth.arr[d_date_of_birth.len] = '\0';

			if (strcmp(d_nationality_code.arr,"NC") == 0) 
			{
				strcpy(nd_country_grp_code.arr,"NC");
				nd_country_grp_code.len = strlen(nd_country_grp_code.arr);
				}
			else
			{
	   			/*EXEC SQL SELECT COUNTRY_GRP_CODE
				  INTO nd_country_grp_code
			      FROM MP_COUNTRY
				  WHERE COUNTRY_CODE = :d_nationality_code;
				  changed and added code on 18/01/2008 because country_grp_code does not exist in mp_country table in SRDV database*/

				  /* EXEC SQL SELECT COUNTRY_CODE
				  INTO nd_country_grp_code
			      FROM MP_COUNTRY
				  WHERE COUNTRY_CODE = :d_nationality_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 56;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select COUNTRY_CODE into :b0  from MP_COUNTRY where COU\
NTRY_CODE=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1145;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_country_grp_code;
      sqlstm.sqhstl[0] = (unsigned int  )7;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_nationality_code;
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


	
				nd_country_grp_code.arr[nd_country_grp_code.len] = '\0';					
			}

			for (i=1;i <= d_country_grp_counter;i++)
				{
					if (strcmp(d_country_grp_code[i].arr,nd_country_grp_code.arr) == 0)
					{
						d_country_grp_count[i]++;
					} 
				}
			}
err_exit:
return;
}
/***********************************************************************/


/***********************************************************************/
void print_section_desc()
{
	d_section_desc.arr[0]	= '\0';  
	d_section_desc.len	= 0;

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL SELECT	SUBSTR(LONG_NAME,1,30) 
			INTO	:d_section_desc
			FROM	RL_SECTION_CODE_lang_vw
			WHERE   SECTION_CODE = :d_section_code
			AND language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SUBSTR(LONG_NAME,1,30) into :b0  from RL_SECTION_CODE\
_lang_vw where (SECTION_CODE=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1168;
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

	
	
	d_section_desc.arr[d_section_desc.len] = '\0';

  if (lncnt + 8 > MAX_LINES ) 
	page_break(); 

  fprintf(f1,"%-40.40s", d_section_desc.arr);


  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1195;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_section_desc() occured....");
   proc_exit();
}
/***********************************************************************/

/***********************************************************************/
print_workgroup_line()
 {
  int i;
  char string_var[200];
  print_spaces(1);
  

  
  //fprintf(f1,"%5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %7ld %7ld %7ld", d_age_m_0_6_days, d_age_f_0_6_days, d_age_m_7_28_days, d_age_f_7_28_days, d_age_m_30_365_days, d_age_f_30_365_days, d_age_m_1_4_years, d_age_f_1_4_years, d_age_m_5_14_years, d_age_f_5_14_years, d_age_m_15_24_years, d_age_f_15_24_years, d_age_m_25_44_years, d_age_f_25_44_years, d_age_m_45_64_years, d_age_f_45_64_years, d_age_m_65_years, d_age_f_65_years,d_workgroup_m_total,d_workgroup_f_total,d_workgroup_grand_total);
  
  if (NO_OF_RANGES >= 1)
  	    fprintf(f1,"%5ld %5ld ", d_age_m_0_6_days, d_age_f_0_6_days);
  if (NO_OF_RANGES >= 2)
        fprintf(f1,"%5ld %5ld ", d_age_m_7_28_days, d_age_f_7_28_days);
  if (NO_OF_RANGES >= 3)
       fprintf(f1,"%5ld %5ld ", d_age_m_30_365_days, d_age_f_30_365_days);
  if (NO_OF_RANGES >= 4)
       fprintf(f1,"%5ld %5ld ", d_age_m_1_4_years, d_age_f_1_4_years); 
  if (NO_OF_RANGES >= 5)
       fprintf(f1,"%5ld %5ld ", d_age_m_5_14_years, d_age_f_5_14_years); 
  if (NO_OF_RANGES >= 6)
       fprintf(f1,"%5ld %5ld ", d_age_m_15_24_years, d_age_f_15_24_years);
  if (NO_OF_RANGES >= 7)
       fprintf(f1,"%5ld %5ld ", d_age_m_25_44_years, d_age_f_25_44_years);
  if (NO_OF_RANGES >= 8)
       fprintf(f1,"%5ld %5ld ", d_age_m_45_64_years, d_age_f_45_64_years);
  if (NO_OF_RANGES >= 9)
       fprintf(f1,"%5ld %5ld ",d_age_m_65_years, d_age_f_65_years);

      fprintf(f1,"%7ld %7ld %7ld", d_workgroup_m_total,d_workgroup_f_total,d_workgroup_grand_total);
        
  fprintf(f1,"\n");
  print_line('-',175);
  lncnt += 2;
 }
/***********************************************************************/

/***********************************************************************/
print_total_line()
 {

  if (lncnt + 8 > MAX_LINES ) 
	page_break(); 

  print_spaces(34);

  //fprintf(f1," TOTAL:");
  fprintf(f1," %5.5s:",local_legend[11]);

  //fprintf(f1,"%5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %5ld %7ld %7ld %7ld", d_total_m_0_6_days, d_total_f_0_6_days, d_total_m_7_28_days, d_total_f_7_28_days, d_total_m_30_365_days, d_total_f_30_365_days, d_total_m_1_4_years, d_total_f_1_4_years, d_total_m_5_14_years, d_total_f_5_14_years, d_total_m_15_24_years, d_total_f_15_24_years, d_total_m_25_44_years, d_total_f_25_44_years, d_total_m_45_64_years, d_total_f_45_64_years, d_total_m_65_years, d_total_f_65_years,d_total_m,d_total_f,d_grand_total);

	  if (NO_OF_RANGES >= 1)
  		  fprintf(f1,"%5ld %5ld ", d_total_m_0_6_days, d_total_f_0_6_days);
	  if (NO_OF_RANGES >= 2)
		  fprintf(f1,"%5ld %5ld ", d_total_m_7_28_days, d_total_f_7_28_days);
	  if (NO_OF_RANGES >= 3)
		  fprintf(f1,"%5ld %5ld ", d_total_m_30_365_days, d_total_f_30_365_days);
	  if (NO_OF_RANGES >= 4)
		  fprintf(f1,"%5ld %5ld ", d_total_m_1_4_years, d_total_f_1_4_years); 
	  if (NO_OF_RANGES >= 5)
		  fprintf(f1,"%5ld %5ld ", d_total_m_5_14_years, d_total_f_5_14_years); 
	  if (NO_OF_RANGES >= 6)
		  fprintf(f1,"%5ld %5ld ", d_total_m_15_24_years, d_total_f_15_24_years);
	  if (NO_OF_RANGES >= 7)
		  fprintf(f1,"%5ld %5ld ", d_total_m_25_44_years, d_total_f_25_44_years);
	  if (NO_OF_RANGES >= 8)
		  fprintf(f1,"%5ld %5ld ", d_total_m_45_64_years, d_total_f_45_64_years);
	  if (NO_OF_RANGES >= 9)
		  fprintf(f1,"%5ld %5ld ",d_total_m_65_years, d_total_f_65_years);

      fprintf(f1,"%7ld %7ld %7ld", d_total_m,d_total_f,d_grand_total);


  fprintf(f1,"\n");
  lncnt += 1;
 }
/***********************************************************************/

print_country_count()
{
int i;
int line_len = 0;
char str[100];

  if (lncnt + 8 > MAX_LINES ) 
	page_break(); 

	for (i = 1;i<=d_country_grp_counter;i++)
	{
		if (line_len >= 160) 
		{
			line_len = 0;
			fprintf(f1,"\n");
		}

		print_spaces(5);
		line_len = line_len + 5;

		fprintf(f1,"%ld - ",d_country_grp_count[i]);
		ltoa(d_country_grp_count[i],str,10);
		line_len = line_len + strlen(str) + 3;

		if (strcmp(d_country_grp_code[i].arr,"NC") == 0)
		{
		//fprintf(f1,"Nationality Not defined");	
		//line_len += strlen("Nationality Not defined");
		fprintf(f1,"%23.23s",local_legend[19]);	
		line_len += strlen(local_legend[19]);
		}
		else
		{
		fprintf(f1,"%s",d_country_grp_code[i].arr);
		line_len += strlen(d_country_grp_code[i].arr);
		}
	}
}

/***********************************************************************/
init_workgroup_count()
 {
	d_age_m_0_6_days	= 0;  
	d_age_f_0_6_days	= 0; 
	d_age_m_7_28_days	= 0; 
	d_age_f_7_28_days	= 0; 
	d_age_m_30_365_days	= 0; 
	d_age_f_30_365_days	= 0;
	d_age_m_1_4_years	= 0; 
	d_age_f_1_4_years	= 0; 
	d_age_m_5_14_years	= 0;
	d_age_f_5_14_years	= 0;
	d_age_m_15_24_years	= 0;
	d_age_f_15_24_years	= 0;
	d_age_m_25_44_years	= 0;
	d_age_f_25_44_years	= 0;
	d_age_m_45_64_years	= 0;
	d_age_f_45_64_years	= 0; 
	d_age_m_65_years	= 0;
	d_age_f_65_years	= 0;

	d_workgroup_m_total = 0;
	d_workgroup_f_total = 0;
	d_workgroup_grand_total = 0;
 }				
/***********************************************************************/

/***********************************************************************/
init_total_count()
 {
		 d_total_m_0_6_days = 0;
		 d_total_f_0_6_days = 0;
		 d_total_m_7_28_days = 0;
		 d_total_f_7_28_days = 0;
	     d_total_m_30_365_days = 0;
	     d_total_f_30_365_days = 0;
	     d_total_m_1_4_years = 0;
	     d_total_f_1_4_years = 0;
	     d_total_m_5_14_years = 0;
	     d_total_f_5_14_years = 0;
	     d_total_m_15_24_years = 0;
	     d_total_f_15_24_years = 0;
	     d_total_m_25_44_years = 0;
	     d_total_f_25_44_years = 0;
		 d_total_m_45_64_years = 0;
		 d_total_f_45_64_years = 0;
	     d_total_m_65_years = 0;
	     d_total_f_65_years = 0;

   	     d_total_m = 0;
	     d_total_f = 0;
		 d_grand_total = 0;
 }				
/***********************************************************************/


/***********************************************************************/ 		 
do_test_count()
{
	/* Age range >= 0 and < 6 days -------- 0 + */

//	if ((d_age_in_days >= 0) && (d_age_in_days <= 6))

   		/*sprintf(string_var,"MONTH %d",nd_pgm_month);
    	disp_message(ERR_MESG,string_var);

		sprintf(string_var,"PATIENT ID %s",d_patient_id.arr);
    	disp_message(ERR_MESG,string_var);
	    

		sprintf(string_var,"IN MONTHS %f",d_age_in_months);
    	disp_message(ERR_MESG,string_var);

	    sprintf(string_var,"RANGE_1_FR %f",RANGE_1_FR);
    	disp_message(ERR_MESG,string_var);

	    sprintf(string_var,"RANGE_1_TO %f",RANGE_1_TO);
    	disp_message(ERR_MESG,string_var);*/
  	   

	if (NO_OF_RANGES >= 1)
	{
		if ((d_age_in_months >= RANGE_1_FR ) && (d_age_in_months < RANGE_1_TO ))
		  {	   
		   if(strcmp(d_sex.arr,"M") == 0 )  
			{
			 d_age_m_0_6_days = d_age_m_0_6_days + 1;
			 d_total_m_0_6_days = d_total_m_0_6_days + 1;
			 d_workgroup_m_total = d_workgroup_m_total+1;
			 d_total_m = d_total_m+1;
			}
		   
		   if ( strcmp(d_sex.arr,"F") == 0 )  
			{
			 d_age_f_0_6_days = d_age_f_0_6_days + 1;
			 d_total_f_0_6_days = d_total_f_0_6_days + 1;
	 		 d_workgroup_f_total = d_workgroup_f_total+1;
    		 d_total_f = d_total_f+1;

			}
		  }
      }

	/* Age range >= 7 and < 29 days  -------- 7 Days */

//	if ((d_age_in_days >=7 ) && (d_age_in_days <= 28 ))
	if (NO_OF_RANGES >= 2)
	{
	
	if ((d_age_in_months >=RANGE_2_FR ) && (d_age_in_months < RANGE_2_TO ))
	  {	   
	   if(strcmp(d_sex.arr,"M") == 0 )  
	    {
	     d_age_m_7_28_days = d_age_m_7_28_days  + 1;
		 d_total_m_7_28_days = d_total_m_7_28_days + 1;
		 d_workgroup_m_total = d_workgroup_m_total+1;
	     d_total_m = d_total_m+1;

	    }
	   
	   if ( strcmp(d_sex.arr,"F") == 0 )  
	    {
	     d_age_f_7_28_days = d_age_f_7_28_days + 1;
		 d_total_f_7_28_days = d_total_f_7_28_days + 1;
	 	 d_workgroup_f_total = d_workgroup_f_total+1;
    	 d_total_f = d_total_f+1;

	    }
	  }
	 }

	/* Age range >= 29 and < 365 days  -------- 29 Days */

//	if ((d_age_in_days >=29 ) && (d_age_in_days <= 364 ))
	if (NO_OF_RANGES >= 3)
	{
	
	if ((d_age_in_months >=RANGE_3_FR ) && (d_age_in_months < RANGE_3_TO ))
	  {	   
	   if(strcmp(d_sex.arr,"M") == 0 )  
	    {
	     d_age_m_30_365_days = d_age_m_30_365_days  + 1;
	     d_total_m_30_365_days = d_total_m_30_365_days  + 1;
		 d_workgroup_m_total = d_workgroup_m_total+1;
	     d_total_m = d_total_m+1;

	    }
	   
	   if ( strcmp(d_sex.arr,"F") == 0 )  
	    {
	    d_age_f_30_365_days = d_age_f_30_365_days  + 1;
	    d_total_f_30_365_days = d_total_f_30_365_days + 1;
	 	 d_workgroup_f_total = d_workgroup_f_total+1;
    	 d_total_f = d_total_f+1;

	    }
	  }
	  }

	/* Age range >= 1 and <= 4 Years   --------  1 - 4 Years */

//	if ((d_age_in_years >=1 ) && (d_age_in_years <= 4 ))
	if (NO_OF_RANGES >= 4)
	{
    
	if ((d_age_in_months >=RANGE_4_FR ) && (d_age_in_months < RANGE_4_TO ))
	  {	   
	   if(strcmp(d_sex.arr,"M") == 0 )  
	    {
	     d_age_m_1_4_years = d_age_m_1_4_years + 1;
	     d_total_m_1_4_years = d_age_m_1_4_years + 1;
		 d_workgroup_m_total = d_workgroup_m_total+1;
	     d_total_m = d_total_m+1;

	    }
	   
	   if ( strcmp(d_sex.arr,"F") == 0 )  
	    {
	     d_age_f_1_4_years = d_age_f_1_4_years  + 1;
	     d_total_f_1_4_years = d_total_f_1_4_years + 1;
	 	 d_workgroup_f_total = d_workgroup_f_total+1;
    	 d_total_f = d_total_f+1;
	    }
	  }
     }
	/* Age range >= 5 and <= 14 Years   --------  5 - 14 Years  */

//	if ((d_age_in_years >=5 ) && (d_age_in_years <= 14 ))
	if (NO_OF_RANGES >= 5)
	{

	if ((d_age_in_months >=RANGE_5_FR ) && (d_age_in_months < RANGE_5_TO ))
	  {	   
	   if(strcmp(d_sex.arr,"M") == 0 )  
	    {
	     d_age_m_5_14_years = d_age_m_5_14_years + 1;
	     d_total_m_5_14_years = d_total_m_5_14_years + 1;
		 d_workgroup_m_total = d_workgroup_m_total+1;
	     d_total_m = d_total_m+1;

	    }
	   
	   if ( strcmp(d_sex.arr,"F") == 0 )  
	    {
	     d_age_f_5_14_years = d_age_f_5_14_years + 1;
	     d_total_f_5_14_years = d_total_f_5_14_years + 1;
	 	 d_workgroup_f_total = d_workgroup_f_total+1;
    	 d_total_f = d_total_f+1;

	    }
	  }
    } 

	/* Age range >= 15 and <= 24 Years     --------  15 - 24 Years */
//	if ((d_age_in_years >= 15 ) && (d_age_in_years <= 24 ))
	if (NO_OF_RANGES >= 6)
	{
			if ((d_age_in_months >= RANGE_6_FR ) && (d_age_in_months < RANGE_6_TO ))
			  {	   
			   if(strcmp(d_sex.arr,"M") == 0 )  
				{
				 d_age_m_15_24_years = d_age_m_15_24_years + 1;
				 d_total_m_15_24_years = d_total_m_15_24_years + 1;
				 d_workgroup_m_total = d_workgroup_m_total+1;
				 d_total_m = d_total_m+1;

				}
			   
			   if ( strcmp(d_sex.arr,"F") == 0 )  
				{
				 d_age_f_15_24_years = d_age_f_15_24_years + 1;
				 d_total_f_15_24_years = d_total_f_15_24_years + 1;
	 			 d_workgroup_f_total = d_workgroup_f_total+1;
    			 d_total_f = d_total_f+1;

				}
			  }
      }
	/* Age range >= 25 and <= 44 Years    --------  25 - 44 Years */

	//if ((d_age_in_years >= 25 ) && (d_age_in_years <= 44 ))
		if (NO_OF_RANGES >= 7)
		{
		 if ((d_age_in_months >= RANGE_7_FR ) && (d_age_in_months < RANGE_7_TO ))
		  {	   
		   if(strcmp(d_sex.arr,"M") == 0 )  
			{
			 d_age_m_25_44_years = d_age_m_25_44_years + 1;
			 d_total_m_25_44_years = d_total_m_25_44_years + 1;
			 d_workgroup_m_total = d_workgroup_m_total+1;
			 d_total_m = d_total_m+1;

			}
		   if ( strcmp(d_sex.arr,"F") == 0 )  
			{
			 d_age_f_25_44_years = d_age_f_25_44_years + 1;
			 d_total_f_25_44_years = d_total_f_25_44_years + 1;
	 		 d_workgroup_f_total = d_workgroup_f_total+1;
    		 d_total_f = d_total_f+1;

			}
		  }
        }   
	
	/* Age range >= 45 and <= 64 Years    --------  45 - 64 Years */

	//if ((d_age_in_years >= 45 ) && (d_age_in_years <= 64 ))
	  if (NO_OF_RANGES >= 8)
	  {
			if ((d_age_in_months >= RANGE_8_FR ) && (d_age_in_months < RANGE_8_TO ))
			  {	   
			   if(strcmp(d_sex.arr,"M") == 0 )  
				{
				 d_age_m_45_64_years = d_age_m_45_64_years + 1;
				 d_total_m_45_64_years = d_total_m_45_64_years + 1;
				 d_workgroup_m_total = d_workgroup_m_total+1;
				 d_total_m = d_total_m+1;

				}
			   if ( strcmp(d_sex.arr,"F") == 0 )  
				{
				 d_age_f_45_64_years = d_age_f_45_64_years + 1;
				 d_total_f_45_64_years = d_total_f_45_64_years + 1;
	 			 d_workgroup_f_total = d_workgroup_f_total+1;
    			 d_total_f = d_total_f+1;

				}
			  }
        }

	/* Age range > 64     --------  65 ++ Years  */

	//if ((d_age_in_years > 64 ))
	  
	  if (NO_OF_RANGES >= 9)
	  {
		  if ((d_age_in_months > RANGE_9_FR ))
		   {	   
		     if(strcmp(d_sex.arr,"M") == 0 )  
		    	{
				 d_age_m_65_years = d_age_m_65_years + 1;
				 d_total_m_65_years = d_total_m_65_years + 1;
				 d_workgroup_m_total = d_workgroup_m_total+1;
				 d_total_m = d_total_m+1;

				}
			  if ( strcmp(d_sex.arr,"F") == 0 )  
				{
				 d_age_f_65_years = d_age_f_65_years + 1;
				 d_total_f_65_years = d_total_f_65_years + 1;
	 			 d_workgroup_f_total = d_workgroup_f_total+1;
    			 d_total_f = d_total_f+1;
				}
		  }
	   }

//	d_workgroup_m_total = d_age_m_0_6_days + d_age_m_7_28_days + d_age_m_30_365_days + d_age_m_1_4_years + d_age_m_5_14_years + d_age_m_15_24_years + d_age_m_25_44_years + d_age_m_45_64_years + d_age_m_65_years;
//	d_total_m = d_total_m_0_6_days + d_total_m_7_28_days + d_total_m_30_365_days + d_total_m_1_4_years + d_total_m_5_14_years + d_total_m_15_24_years + d_total_m_25_44_years + d_total_m_45_64_years + d_total_m_65_years;

//	d_workgroup_f_total = d_age_f_0_6_days + d_age_f_7_28_days + d_age_f_30_365_days + d_age_f_1_4_years + d_age_f_5_14_years + d_age_f_15_24_years + d_age_f_25_44_years + d_age_f_45_64_years + d_age_f_65_years;
//	d_total_f = d_total_f_0_6_days + d_total_f_7_28_days + d_total_f_30_365_days + d_total_f_1_4_years + d_total_f_5_14_years + d_total_f_15_24_years + d_total_f_25_44_years + d_total_f_45_64_years + d_total_f_65_years;

	d_workgroup_grand_total = d_workgroup_m_total +  d_workgroup_f_total;
	d_grand_total = d_total_m + d_total_f;
}
/***********************************************************************/

/***********************************************************************/
/* prints the master-detail record until the cursor is empty */
void do_report()
{
  void init_age_range();
  void get_header_dtls();
  void print_rep_header();
  void print_page_header();    
  void dclr_cur();
  int still_rec_left;
  char string_var[500]; 
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  get_header_dtls();
  first_page_flg = 1;
  print_rep_header();
  init_age_range();
  first_page_flg = 0;

  // fprintf(f1,"");
  fprintf(f1,"\f"); 
  dclr_cur();
  open_section_cur();
  init_workgroup_count();
  
  init_total_count();
  get_country_group();
  
print_page_header();
  while (fetch_section_cur())
    {

	print_section_desc();
	open_patient_cur();
		while (fetch_patient_cur())
		{
		  if (strcmp(d_section_code.arr,v_section_code.arr) == 0)
		   {
			if (get_patient_details())
			{
				do_test_count();
			}
           } 
		}
	close_patient_cur();
    print_workgroup_line();
	init_workgroup_count();
	}
 
   close_section_cur();
   print_total_line();

   print_line('_',175);
  
  fprintf(f1,"\n\n");
  
  open_patient_cur_2();

  while (fetch_patient_cur_2())
		{
			get_patient_details_2();
		}

  close_patient_cur_2();
  
  print_country_count();

  fprintf(f1,"\n");

  print_line('_',175);
      
  fprintf(f1,"\n\n");
  
  print_spaces(71);
  
  //fprintf(f1,"** End of Report **\n");
  fprintf(f1,"** %13.13s **\n",local_legend[20]);

  fprintf(f1,"\f");  
return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1210;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at do_report() occured....");
   proc_exit();
}
/***********************************************************************/
