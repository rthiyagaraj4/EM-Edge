
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RD/RDREXSTA.PC"
};


static unsigned int sqlctx = 1288578499;


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
            void  *sqhstv[25];
   unsigned int   sqhstl[25];
            int   sqhsts[25];
            void  *sqindv[25];
            int   sqinds[25];
   unsigned int   sqharm[25];
   unsigned int   *sqharc[25];
   unsigned short  sqadto[25];
   unsigned short  sqtdso[25];
} sqlstm = {12,25};

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

 static const char *sq0006 = 
"select B.SECTION_CODE ,A.PATIENT_CLASS ,C.NATIONALITY_CODE ,B.EXAM_CODE ,A.P\
ATIENT_ID ,C.SEX ,ROUND((REQUEST_DATE-C.DATE_OF_BIRTH))  from RD_REQUEST A ,RD\
_EXAM_VIEW_REQUESTED B ,MP_PATIENT_MAST C where (((((((((A.OPERATING_FACILITY_\
ID=B.OPERATING_FACILITY_ID and A.REQUEST_NUM=B.REQUEST_NUM) and A.PATIENT_ID=C\
.PATIENT_ID) and NVL(B.STATUS,'X')<>'99') and A.OPERATING_FACILITY_ID=:b0) and\
 TRUNC(A.REQUEST_DATE) between to_date(:b1,'dd/mm/yyyy') and to_date(:b2,'dd/m\
m/yyyy')) and NVL(WING_CODE,:b3) between :b3 and :b5) and NVL(EXAM_ROOM,:b6) b\
etween :b6 and :b8) and NVL(B.SECTION_CODE,:b9) between :b9 and :b11) and NVL(\
EXAM_CODE,:b12) between :b12 and :b14) order by B.SECTION_CODE,A.PATIENT_CLASS\
,C.NATIONALITY_CODE            ";

 static const char *sq0007 = 
"select B.SECTION_CODE ,A.PATIENT_CLASS ,C.NATIONALITY_CODE ,B.EXAM_CODE ,A.P\
ATIENT_ID ,C.SEX ,ROUND((REQUEST_DATE-C.DATE_OF_BIRTH))  from RD_REQUEST A ,RD\
_EXAM_VIEW_REQUESTED B ,MP_PATIENT_MAST C where (((((((((A.OPERATING_FACILITY_\
ID=B.OPERATING_FACILITY_ID and A.REQUEST_NUM=B.REQUEST_NUM) and A.PATIENT_ID=C\
.PATIENT_ID) and NVL(B.STATUS,'X')<>'99') and A.OPERATING_FACILITY_ID=:b0) and\
 TRUNC(A.REQUEST_DATE) between to_date(:b1,'dd/mm/yyyy') and to_date(:b2,'dd/m\
m/yyyy')) and NVL(WING_CODE,:b3) between :b3 and :b5) and NVL(EXAM_ROOM,:b6) b\
etween :b6 and :b8) and NVL(B.SECTION_CODE,:b9) between :b9 and :b11) and NVL(\
EXAM_CODE,:b12) between :b12 and :b14) order by B.EXAM_CODE,A.PATIENT_CLASS,C.\
NATIONALITY_CODE            ";

 static const char *sq0008 = 
"select B.SECTION_CODE ,A.PATIENT_CLASS ,C.NATIONALITY_CODE ,B.EXAM_CODE ,A.P\
ATIENT_ID ,C.SEX ,ROUND((REQUEST_DATE-C.DATE_OF_BIRTH)) ,NVL(D.VIEW_CODE,'XXXX\
')  from RD_REQUEST A ,RD_EXAM_VIEW_REQUESTED B ,MP_PATIENT_MAST C ,RD_REQUEST\
_EXAM_VIEWS D where ((((((((((((((A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY\
_ID and A.REQUEST_NUM=B.REQUEST_NUM) and A.PATIENT_ID=C.PATIENT_ID) and D.OPER\
ATING_FACILITY_ID(+)=B.OPERATING_FACILITY_ID) and D.REQUEST_NUM(+)=B.REQUEST_N\
UM) and D.REQUEST_LINE_NUM(+)=B.REQUEST_LINE_NUM) and NVL(B.STATUS,'X')<>'99')\
 and D.VIEW_CODE is  not null ) and A.OPERATING_FACILITY_ID=:b0) and TRUNC(A.R\
EQUEST_DATE) between to_date(:b1,'dd/mm/yyyy') and to_date(:b2,'dd/mm/yyyy')) \
and NVL(WING_CODE,:b3) between :b3 and :b5) and NVL(EXAM_ROOM,:b6) between :b6\
 and :b8) and NVL(B.SECTION_CODE,:b9) between :b9 and :b11) and NVL(B.EXAM_COD\
E,:b12) between :b12 and :b14) and NVL(D.VIEW_CODE,:b15) between :b15 and :b17\
) order by D.VIEW_CODE,A.PATIENT_CLASS,C.NATIONALITY_CODE            ";

 static const char *sq0009 = 
"select B.SECTION_CODE ,A.PATIENT_CLASS ,C.NATIONALITY_CODE ,B.EXAM_CODE ,A.P\
ATIENT_ID ,C.SEX ,ROUND((REQUEST_DATE-C.DATE_OF_BIRTH)) ,E.EXAM_CATEGORY_PAREN\
T  from RD_REQUEST A ,RD_EXAM_VIEW_REQUESTED B ,MP_PATIENT_MAST C ,RD_EXAMS D \
,RD_EXAM_CATEGORY E where ((((((((((((A.OPERATING_FACILITY_ID=B.OPERATING_FACI\
LITY_ID and A.REQUEST_NUM=B.REQUEST_NUM) and A.PATIENT_ID=C.PATIENT_ID) and B.\
EXAM_CODE=D.EXAM_CODE) and D.EXAM_CATEGORY_CODE=E.EXAM_CATEGORY_CODE) and NVL(\
B.STATUS,'X')<>'99') and A.OPERATING_FACILITY_ID=:b0) and TRUNC(A.REQUEST_DATE\
) between to_date(:b1,'dd/mm/yyyy') and to_date(:b2,'dd/mm/yyyy')) and NVL(A.W\
ING_CODE,:b3) between :b3 and :b5) and NVL(B.EXAM_ROOM,:b6) between :b6 and :b\
8) and NVL(B.SECTION_CODE,:b9) between :b9 and :b11) and NVL(B.EXAM_CODE,:b12)\
 between :b12 and :b14) and NVL(E.EXAM_CATEGORY_PARENT,:b15) between :b15 and \
:b17) order by E.EXAM_CATEGORY_PARENT,A.PATIENT_CLASS,C.NATIONALITY_CODE      \
      ";

 static const char *sq0010 = 
"select B.SECTION_CODE ,A.PATIENT_CLASS ,C.NATIONALITY_CODE ,B.EXAM_CODE ,A.P\
ATIENT_ID ,C.SEX ,ROUND((REQUEST_DATE-C.DATE_OF_BIRTH)) ,E.EXAM_CATEGORY_CODE \
 from RD_REQUEST A ,RD_EXAM_VIEW_REQUESTED B ,MP_PATIENT_MAST C ,RD_EXAMS D ,R\
D_EXAM_CATEGORY E where ((((((((((((A.OPERATING_FACILITY_ID=B.OPERATING_FACILI\
TY_ID and A.REQUEST_NUM=B.REQUEST_NUM) and A.PATIENT_ID=C.PATIENT_ID) and B.EX\
AM_CODE=D.EXAM_CODE) and D.EXAM_CATEGORY_CODE=E.EXAM_CATEGORY_CODE) and NVL(B.\
STATUS,'X')<>'99') and A.OPERATING_FACILITY_ID=:b0) and TRUNC(A.REQUEST_DATE) \
between to_date(:b1,'dd/mm/yyyy') and to_date(:b2,'dd/mm/yyyy')) and NVL(A.WIN\
G_CODE,:b3) between :b3 and :b5) and NVL(B.EXAM_ROOM,:b6) between :b6 and :b8)\
 and NVL(B.SECTION_CODE,:b9) between :b9 and :b11) and NVL(B.EXAM_CODE,:b12) b\
etween :b12 and :b14) and NVL(E.EXAM_CATEGORY_CODE,:b15) between :b15 and :b17\
) order by E.EXAM_CATEGORY_CODE,A.PATIENT_CLASS,C.NATIONALITY_CODE            ";

 static const char *sq0011 = 
"select B.SECTION_CODE ,A.PATIENT_CLASS ,C.NATIONALITY_CODE ,B.EXAM_CODE ,A.P\
ATIENT_ID ,C.SEX ,ROUND((REQUEST_DATE-C.DATE_OF_BIRTH)) ,B.EXAM_ROOM  from RD_\
REQUEST A ,RD_EXAM_VIEW_REQUESTED B ,MP_PATIENT_MAST C ,RD_EXAMS D ,RD_EXAM_CA\
TEGORY E where (((((((((((((A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID an\
d A.REQUEST_NUM=B.REQUEST_NUM) and A.PATIENT_ID=C.PATIENT_ID) and B.EXAM_CODE=\
D.EXAM_CODE) and D.EXAM_CATEGORY_CODE=E.EXAM_CATEGORY_CODE) and NVL(B.STATUS,'\
X')<>'99') and A.OPERATING_FACILITY_ID=:b0) and TRUNC(A.REQUEST_DATE) between \
to_date(:b1,'dd/mm/yyyy') and to_date(:b2,'dd/mm/yyyy')) and NVL(A.WING_CODE,:\
b3) between :b3 and :b5) and NVL(B.EXAM_ROOM,:b6) between :b6 and :b8) and NVL\
(B.SECTION_CODE,:b9) between :b9 and :b11) and NVL(B.EXAM_CODE,:b12) between :\
b12 and :b14) and NVL(E.EXAM_CATEGORY_CODE,:b15) between :b15 and :b17) and B.\
EXAM_ROOM between nvl(:b6,B.EXAM_ROOM) and nvl(:b8,B.EXAM_ROOM)) order by B.EX\
AM_ROOM,A.PATIENT_CLASS,C.NATIONALITY_CODE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,242,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,280,0,0,0,0,0,1,0,
51,0,0,3,429,0,4,303,0,0,25,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
166,0,0,4,134,0,2,396,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
193,0,0,5,158,0,4,432,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
228,0,0,6,731,0,9,650,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
303,0,0,7,728,0,9,651,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
378,0,0,8,1003,0,9,652,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
465,0,0,9,940,0,9,653,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
552,0,0,10,934,0,9,654,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
639,0,0,11,988,0,9,655,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
734,0,0,12,56,0,4,677,0,0,1,0,0,1,0,2,9,0,0,
753,0,0,13,234,0,4,684,0,0,11,1,0,1,0,2,3,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,3,0,0,
2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
812,0,0,6,0,0,13,1662,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,
855,0,0,7,0,0,13,1677,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,
898,0,0,8,0,0,13,1691,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,2,9,0,0,
945,0,0,9,0,0,13,1706,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,2,9,0,0,
992,0,0,10,0,0,13,1722,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,2,9,0,0,
1039,0,0,11,0,0,13,1738,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,3,0,0,2,9,0,0,
1086,0,0,14,88,0,4,1852,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1113,0,0,15,110,0,4,1867,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1140,0,0,16,108,0,4,1881,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1167,0,0,17,126,0,4,1896,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1198,0,0,18,123,0,4,1920,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1229,0,0,19,96,0,4,1939,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1256,0,0,20,90,0,4,1955,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1283,0,0,21,322,0,6,2404,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,2,9,0,0,
1314,0,0,22,112,0,6,2441,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1337,0,0,23,136,0,6,2454,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/******************************************************************************/
/* MEDICOM VER 4.1                                                            */
/******************************************************************************/
/* PROGRAM NAME     : rdrexsta.pc                                             */
/* AUTHOR           : 												  */
/* DATE WRITTEN     : 19-NOV-2003                                             */
/*                                                                            */
/* CALLED FROM      : rdrexsta.fmb                                            */
/*                                                                            */
/* INPUT PARAMETERS : USER_ID/PASSWORD                                        */
/*                  : SESSION_ID                                              */
/*                  : PGM_DATE                                                */
/*                  : APPOINTMENT FROM AND TO DATE                            */
/*                  : APPOINTMENT FROM AND TO SECTION                         */
/*                  : APPOINTMENT FROM AND TO CLINIC                          */
/*                                                                            */
/* TABLES ACCESSED  : SY_PROG_PARAM                                           */
/*                  : RD_REQUEST                                              */
/*                                                                            */
/* OUTPUT FILE      : rdrexsta.lis                                            */
/*                                                                            */
/* FUNCTION         : This program prints a Patient Appointment List          */
/*                    For a given SY_PROG_PARAM parameters                    */
/*                                                                            */
/* VERSION          : eHIS 4.1                                                */
/* MODIFICATIONS    :                                                         */
/*                                                                            */
/******************************************************************************/

#include <stdio.h>
#include <math.h>
#include "gl.h"
#include <string.h>

#define OERROR (sqlca.sqlcode < 0)
//#define NO_DATA_FOUND sqlca.sqlcode==1403
#define MAX_LINES 55
#define REP_WIDTH 78
#define REP_TITLE "EXAMINATION STATISTICS"
#define VER  "VER : 10.2\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR nd_facility_id		   [3],  --added 0n 18/Aug/2003
			nd_pgm_id    		   [9],  --added 0n 18/Aug/2003
			//uid_pwd		           [91], --size increased 0n 18/Aug/2003
			uid_pwd		           [122], /o Length increased from 91 to 122 o/
			nd_session_id		   [16],
			nd_pgm_date			   [13], /o Input Parameters       o/

			h_acc_entity_name      [61],  /o SY_ACC_ENTITY header access o/
			h_user                 [31],
			h_sysdate              [17],

			nd_exam_date           [11],  /o SY_PROG_PARAM Parameters o/
			nd_section_code        [5],
			nd_wing_code           [3] ,
			
			h_wing_int_or_ext      [2],
			h_order_type_code      [5],

			t_wing_desc            [61],
			t_section_desc         [51],   /o Desc for the Code access o/
			t_view_desc		       [51],
			t_exam_desc            [41],

			fm_period_date			[31],
			to_period_date			[31],
			consolidation_level		[2],
			fm_wing_code			[3],
			to_wing_code			[3],
			fm_clinic_code			[5],
			to_clinic_code			[5],
			summarization_level		[2],
			fm_section_code			[5],
			to_section_code			[5],
			fm_view_code			[5],
			to_view_code			[5],
			fm_exam_code			[11], 
			to_exam_code			[11],
			t_facility_id			[3],
			t_facility_desc			[100],
			age_group1				[5],
			age_group2				[5],
			d_fm_period				[30],
			d_to_period				[30],
			d_summ					[30],

			t_range_1_desc			[16], 
			t_range_2_desc			[16],   
	
			t_section_code			[7],
			t_patient_class			[3],
			t_nationality_code		[5],
			t_exam_code				[11],
			t_view_code				[5],
			t_patient_id			[21],
			t_sex					[2],
			t_date_of_birth			[30],
			cit_nationality_code	[5],

			fm_main_exam_catg		[13],
			to_main_exam_catg		[13],
			fm_sub_exam_catg		[13],
			to_sub_exam_catg		[13],


			h_study_location		[5],
			t_study_location		[5],
			t_study_location_desc   [16],

			t_exam_catg_code		[13],
			h_exam_catg_code		[13],
			t_exam_catg_desc		[31],
			fm_clinic_desc			[31],	
			to_clinic_desc			[31],	

			h_section_code			[7], 
			h_exam_code				[11],
			h_patient_class			[3],
			h_nationality_code		[5],
			h_view_code				[5],

			t_range_unit_desc		[16],
			
			t_range_1_fr_unit		[3],	
			t_range_1_to_unit		[3],	
			t_range_2_fr_unit		[3],	
			t_range_2_to_unit		[3],	

			t_wing_code            [3],
			 
			p_language_id		   [3],
			date_convert		   [21],
			nd_temp_date		   [21],
			nd_loc_date            [21],
			l_translated_value	   [200]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[122]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[61]; } h_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } h_user;

struct { unsigned short len; unsigned char arr[17]; } h_sysdate;

struct { unsigned short len; unsigned char arr[11]; } nd_exam_date;

struct { unsigned short len; unsigned char arr[5]; } nd_section_code;

struct { unsigned short len; unsigned char arr[3]; } nd_wing_code;

struct { unsigned short len; unsigned char arr[2]; } h_wing_int_or_ext;

struct { unsigned short len; unsigned char arr[5]; } h_order_type_code;

struct { unsigned short len; unsigned char arr[61]; } t_wing_desc;

struct { unsigned short len; unsigned char arr[51]; } t_section_desc;

struct { unsigned short len; unsigned char arr[51]; } t_view_desc;

struct { unsigned short len; unsigned char arr[41]; } t_exam_desc;

struct { unsigned short len; unsigned char arr[31]; } fm_period_date;

struct { unsigned short len; unsigned char arr[31]; } to_period_date;

struct { unsigned short len; unsigned char arr[2]; } consolidation_level;

struct { unsigned short len; unsigned char arr[3]; } fm_wing_code;

struct { unsigned short len; unsigned char arr[3]; } to_wing_code;

struct { unsigned short len; unsigned char arr[5]; } fm_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } to_clinic_code;

struct { unsigned short len; unsigned char arr[2]; } summarization_level;

struct { unsigned short len; unsigned char arr[5]; } fm_section_code;

struct { unsigned short len; unsigned char arr[5]; } to_section_code;

struct { unsigned short len; unsigned char arr[5]; } fm_view_code;

struct { unsigned short len; unsigned char arr[5]; } to_view_code;

struct { unsigned short len; unsigned char arr[11]; } fm_exam_code;

struct { unsigned short len; unsigned char arr[11]; } to_exam_code;

struct { unsigned short len; unsigned char arr[3]; } t_facility_id;

struct { unsigned short len; unsigned char arr[100]; } t_facility_desc;

struct { unsigned short len; unsigned char arr[5]; } age_group1;

struct { unsigned short len; unsigned char arr[5]; } age_group2;

struct { unsigned short len; unsigned char arr[30]; } d_fm_period;

struct { unsigned short len; unsigned char arr[30]; } d_to_period;

struct { unsigned short len; unsigned char arr[30]; } d_summ;

struct { unsigned short len; unsigned char arr[16]; } t_range_1_desc;

struct { unsigned short len; unsigned char arr[16]; } t_range_2_desc;

struct { unsigned short len; unsigned char arr[7]; } t_section_code;

struct { unsigned short len; unsigned char arr[3]; } t_patient_class;

struct { unsigned short len; unsigned char arr[5]; } t_nationality_code;

struct { unsigned short len; unsigned char arr[11]; } t_exam_code;

struct { unsigned short len; unsigned char arr[5]; } t_view_code;

struct { unsigned short len; unsigned char arr[21]; } t_patient_id;

struct { unsigned short len; unsigned char arr[2]; } t_sex;

struct { unsigned short len; unsigned char arr[30]; } t_date_of_birth;

struct { unsigned short len; unsigned char arr[5]; } cit_nationality_code;

struct { unsigned short len; unsigned char arr[13]; } fm_main_exam_catg;

struct { unsigned short len; unsigned char arr[13]; } to_main_exam_catg;

struct { unsigned short len; unsigned char arr[13]; } fm_sub_exam_catg;

struct { unsigned short len; unsigned char arr[13]; } to_sub_exam_catg;

struct { unsigned short len; unsigned char arr[5]; } h_study_location;

struct { unsigned short len; unsigned char arr[5]; } t_study_location;

struct { unsigned short len; unsigned char arr[16]; } t_study_location_desc;

struct { unsigned short len; unsigned char arr[13]; } t_exam_catg_code;

struct { unsigned short len; unsigned char arr[13]; } h_exam_catg_code;

struct { unsigned short len; unsigned char arr[31]; } t_exam_catg_desc;

struct { unsigned short len; unsigned char arr[31]; } fm_clinic_desc;

struct { unsigned short len; unsigned char arr[31]; } to_clinic_desc;

struct { unsigned short len; unsigned char arr[7]; } h_section_code;

struct { unsigned short len; unsigned char arr[11]; } h_exam_code;

struct { unsigned short len; unsigned char arr[3]; } h_patient_class;

struct { unsigned short len; unsigned char arr[5]; } h_nationality_code;

struct { unsigned short len; unsigned char arr[5]; } h_view_code;

struct { unsigned short len; unsigned char arr[16]; } t_range_unit_desc;

struct { unsigned short len; unsigned char arr[3]; } t_range_1_fr_unit;

struct { unsigned short len; unsigned char arr[3]; } t_range_1_to_unit;

struct { unsigned short len; unsigned char arr[3]; } t_range_2_fr_unit;

struct { unsigned short len; unsigned char arr[3]; } t_range_2_to_unit;

struct { unsigned short len; unsigned char arr[3]; } t_wing_code;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;


	   int  t_male_nat_age1		= 0,
			t_female_nat_age1	= 0,
			t_male_oth_age1		= 0,
			t_female_oth_age1	= 0,
			t_male_nat_age2		= 0,
			t_female_nat_age2	= 0,
			t_male_oth_age2		= 0,
			t_female_oth_age2	= 0,
			sec_male_nat_tot1	= 0,
			sec_female_nat_tot1	= 0,
			sec_male_oth_tot1	= 0,
			sec_female_oth_tot1	= 0,
			sec_male_nat_tot2	= 0,
			sec_female_nat_tot2	= 0,
			sec_male_oth_tot2	= 0,
			sec_female_oth_tot2	= 0,
			t_date_of_birth_days = 0,
			t_min_age1			= 0, 
			t_max_age1			= 0, 
			t_min_days1			= 0,
			t_max_days1			= 0,
			t_min_age2			= 0, 
			t_max_age2			= 0,
			t_min_days2			= 0,
			t_max_days2			= 0;
			int i=0;
			int time_flag = 0;

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




#include "winproc.h";

char string_var[100];

char string_age_range[100];
char string_age_range_1[100];

char filename[150];
char temp[1000];

char loc_legend[999][200];

int line_no=0;
int page_no=0;


long   gr_total_inpat       = 0,
       gr_total_outpat      = 0,
       gr_total_referral    = 0,
       gr_total_pat         = 0;


FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
	void get_params(),
         get_header_dtls(),
         dclr_appt_cur(),
		 get_default_values(),
         do_report();

	/*printf("RDREXSTD : Program Started.\n\n");     */

    if (argc != 6) 
    {
		int i = 0;
		disp_message(ERR_MESG,"Usage rdrexstd uid/passwd session_id pgm_date\n");
		disp_message(ERR_MESG,"Exiting due to Mismatch of input parameters\007\007\007");
		sprintf(string_var,"No of Parameters is <%d>\n",argc);
		disp_message(ERR_MESG,string_var); 
		disp_message(ERR_MESG,"The following are the parameters :-\n");

		for ( i = 0; i < argc; i++ ) 
		sprintf(string_var,"argv[ %d ] ---> <%s>\n",i,argv[i]); 
		disp_message(ERR_MESG,string_var);

		proc_exit();
	}
   
	strcpy(nd_pgm_id.arr, argv[0]);
	nd_pgm_id.len = strlen(nd_pgm_id.arr); 

	strcpy(uid_pwd.arr, argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr); 

	strcpy(nd_session_id.arr, argv[2]);
	nd_session_id.len = strlen(nd_session_id.arr); 

	strcpy(nd_pgm_date.arr, argv[3]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr); 

	strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

	strcpy(OUTPUT_FILE_NAME, argv[5]);
	

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
    sqlstm.sqhstl[0] = (unsigned int  )124;
    sqlstm.sqhsts[0] = (         int  )124;
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

  

    if (OERROR) 
      {
         disp_message(ERR_MESG,"USERID/PASSWORD failed to Connect\n");
         proc_exit();
      }
  
	set_meduser_role();

	/*Code Included for internationalization*/
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

	
	strcpy(filename,WORKING_DIR);
	//strcat(filename,"rdrexstd.lis");
	strcat(filename,OUTPUT_FILE_NAME);
	if ((f1 = fopen(filename, "w")) == NULL) 
    {
		disp_message(ERR_MESG,".... Error opening output file ....\n");
        proc_exit();
	} 
  
	get_params();

	fetch_legend_value();
	
	get_header_dtls();
	
	dclr_appt_cur();
	
	get_default_values();
	
	fprintf(f1,"%c&k4S",ESC); fprintf(f1,"%c&a8L",ESC);
    
    do_report();
	
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


	/*-------------- Check for any error and No data found ----------------------*/
     if (OERROR) 
       {
          disp_message(ERR_MESG,"COMMIT failed\n");
          proc_exit();
       }

	/*-------------------------- End of Error Check ------------------------------*/

     fclose(f1);
	/*     printf("RDREXSTD : Program Ended.\n\n");      */
     return;
}   


/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
  {
		  
   /* read the parameter record */
     
	  /* EXEC SQL SELECT	PARAM1,
						PARAM2,
						PARAM3,
						PARAM4,
						PARAM5,
						PARAM6,
						PARAM7,
						PARAM8,
						PARAM9,
						PARAM10,
						PARAM11,
						PARAM12,
						PARAM13,
						PARAM14,
						PARAM15,
						PARAM16,
						PARAM17,
						PARAM18,
						PARAM19,
						PARAM20,
						PARAM21,
						PARAM22
				INTO    :fm_period_date,
						:to_period_date,
						:consolidation_level,
						:fm_wing_code,
						:to_wing_code,
						:fm_clinic_code,
						:to_clinic_code,
						:summarization_level,
						:fm_section_code,
						:to_section_code,
						:fm_exam_code, 
						:to_exam_code,
						:t_facility_id,
						:age_group1,
						:age_group2,
						:t_facility_desc,
						:fm_view_code,
						:to_view_code,
						:fm_main_exam_catg,
						:to_main_exam_catg,
						:fm_sub_exam_catg,
						:to_sub_exam_catg
          FROM      SY_PROG_PARAM
	      WHERE     OPERATING_FACILITY_ID = :nd_facility_id
		  AND		PGM_ID				  = 'RDREXSTA'
	      AND       SESSION_ID			  = TO_NUMBER(:nd_session_id)
	      AND       PGM_DATE			  = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,PAR\
AM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 ,PARAM21 ,PARAM22 into :b0,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b\
20,:b21  from SY_PROG_PARAM where (((OPERATING_FACILITY_ID=:b22 and PGM_ID='RD\
REXSTA') and SESSION_ID=TO_NUMBER(:b23)) and PGM_DATE=:b24)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&fm_period_date;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&to_period_date;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&consolidation_level;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&fm_wing_code;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&to_wing_code;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&fm_clinic_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&to_clinic_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&summarization_level;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&fm_section_code;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&to_section_code;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&fm_exam_code;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&to_exam_code;
   sqlstm.sqhstl[11] = (unsigned int  )13;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&t_facility_id;
   sqlstm.sqhstl[12] = (unsigned int  )5;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&age_group1;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&age_group2;
   sqlstm.sqhstl[14] = (unsigned int  )7;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&t_facility_desc;
   sqlstm.sqhstl[15] = (unsigned int  )102;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&fm_view_code;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&to_view_code;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&fm_main_exam_catg;
   sqlstm.sqhstl[18] = (unsigned int  )15;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&to_main_exam_catg;
   sqlstm.sqhstl[19] = (unsigned int  )15;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&fm_sub_exam_catg;
   sqlstm.sqhstl[20] = (unsigned int  )15;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&to_sub_exam_catg;
   sqlstm.sqhstl[21] = (unsigned int  )15;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[22] = (unsigned int  )5;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[23] = (unsigned int  )18;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[24] = (unsigned int  )15;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
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



		  
		  

	/*-------------- Check for any error and No data found ----------------------*/
	if (OERROR) 
	{
		disp_message(ERR_MESG,"SELECT failed on SY_PROG_PARAM\n");
		proc_exit();
    }
	if (NO_DATA_FOUND)
    {
        disp_message(ERR_MESG,"No Data Found in the SY_PROG_PARAM\n");
        proc_exit();
    }
	
	/*-------------------------- End of Error Check ------------------------------*/
    
	fm_period_date.arr[fm_period_date.len]				= '\0';
	to_period_date.arr[to_period_date.len]				= '\0';
	consolidation_level.arr[consolidation_level.len]	= '\0';
	fm_wing_code.arr[fm_wing_code.len]					= '\0';
	to_wing_code.arr[to_wing_code.len]					= '\0';						
	fm_clinic_code.arr[fm_clinic_code.len]				= '\0';						
	to_clinic_code.arr[to_clinic_code.len]				= '\0';						
	summarization_level.arr[summarization_level.len]	= '\0';
	fm_section_code.arr[fm_section_code.len]			= '\0';						
	to_section_code.arr[to_section_code.len]			= '\0';						
	fm_exam_code.arr[fm_exam_code.len]					= '\0';						
	to_exam_code.arr[to_exam_code.len]					= '\0';												
	t_facility_id.arr[t_facility_id.len]				= '\0';												
	t_facility_desc.arr[t_facility_desc.len]			= '\0';												
	age_group1.arr[age_group1.len]						= '\0';												
	age_group2.arr[age_group2.len]						= '\0';												
	fm_view_code.arr[fm_view_code.len]					= '\0';						
	to_view_code.arr[to_view_code.len]					= '\0';												

	fm_main_exam_catg.arr[fm_main_exam_catg.len]		= '\0';												
	to_main_exam_catg.arr[to_main_exam_catg.len]		= '\0';												
	fm_sub_exam_catg.arr[fm_sub_exam_catg.len]			= '\0';												
	to_sub_exam_catg.arr[to_sub_exam_catg.len]			= '\0';												


    /* delete the parameter record */
	/* EXEC SQL DELETE SY_PROG_PARAM
			   WHERE OPERATING_FACILITY_ID = :nd_facility_id
				 AND PGM_ID				   = 'RDREXSTA'
				 AND SESSION_ID			   = TO_NUMBER(:nd_session_id)
				 AND PGM_DATE			   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_ID=:\
b0 and PGM_ID='RDREXSTA') and SESSION_ID=TO_NUMBER(:b1)) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )166;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[2] = (unsigned int  )15;
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



	/*-------------- Check for any error and No data found ----------------------*/
	if (OERROR) 
    {
        disp_message(ERR_MESG,"DELETE failed on SY_PROG_PARAM\n");
        proc_exit();
    }

	if (NO_DATA_FOUND) 
    {
        disp_message(ERR_MESG,"No Data Found in the SY_PROG_PARAM\n");
        proc_exit();
    }
	/*------------------------- End of Error Check -------------------------------*/

	return;

  }

  /*--------------------------- get the header details -------------------------*/
void get_header_dtls()
  {
     h_acc_entity_name.len = 0;
     h_user.len            = 0;
     h_sysdate.len         = 0;

     h_acc_entity_name.arr[h_acc_entity_name.len]   = '\0';
     h_user.arr[h_user.len]                         = '\0';
     h_sysdate.arr[h_sysdate.len]                   = '\0';
	
	/*For internationlization SY_ACC_ENTITY table is changed to SY_ACC_ENTITY_LANG_VW*/
     /* EXEC SQL SELECT ACC_ENTITY_NAME, USER,
		             TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	            INTO :h_acc_entity_name, :h_user,
		             :h_sysdate
                FROM SY_ACC_ENTITY_LANG_VW
			   WHERE ACC_ENTITY_ID = :nd_facility_id
			   AND   LANGUAGE_ID   = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYY\
Y HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=\
:b3 and LANGUAGE_ID=:b4)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )193;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_acc_entity_name;
     sqlstm.sqhstl[0] = (unsigned int  )63;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&h_user;
     sqlstm.sqhstl[1] = (unsigned int  )33;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&h_sysdate;
     sqlstm.sqhstl[2] = (unsigned int  )19;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&p_language_id;
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


	
	/*-------------- Check for any error and No data found ----------------------*/
     if (OERROR)
       {
          disp_message(ERR_MESG,"SELECT failed on SY_ACC_ENTITY\n");
          proc_exit();
       }

     if (NO_DATA_FOUND)
       {
          disp_message(ERR_MESG,"No Data Found in the SY_ACC_ENTITY\n");
          proc_exit();
       }

	/*------------------------- End of Error Check -------------------------------*/
     h_acc_entity_name.arr[h_acc_entity_name.len]   = '\0';
     h_user.arr[h_user.len]                         = '\0';
     h_sysdate.arr[h_sysdate.len]                   = '\0';

  }
/*------------------------- End of Header access -----------------------------*/


/*------------------------- Appointments Cursor ------------------------------*/
void dclr_appt_cur()
  {
	
		 if (strcmp(summarization_level.arr,"S")==0)
		 {
		 
		 /* EXEC SQL DECLARE REQUEST_CUR CURSOR FOR
                SELECT	B.SECTION_CODE,
						A.PATIENT_CLASS,
						C.NATIONALITY_CODE,
						B.EXAM_CODE,
						A.PATIENT_ID,
						C.SEX,
						ROUND(REQUEST_DATE - C.DATE_OF_BIRTH)
				FROM	RD_REQUEST A,RD_EXAM_VIEW_REQUESTED B,MP_PATIENT_MAST C
				WHERE   A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				AND		A.REQUEST_NUM = B.REQUEST_NUM
				AND		A.PATIENT_ID = C.PATIENT_ID
				AND		NVL(B.STATUS,'X')!='99'
				AND     A.OPERATING_FACILITY_ID = :t_facility_id
				AND     TRUNC(A.REQUEST_DATE) between to_date(:fm_period_date,'dd/mm/yyyy') and to_date(:to_period_date,'dd/mm/yyyy')
				AND     NVL(WING_CODE,:fm_wing_code) between :fm_wing_code and	:to_wing_code
				AND     NVL(EXAM_ROOM,:fm_clinic_code) between :fm_clinic_code and :to_clinic_code
				AND     NVL(B.SECTION_CODE,:fm_section_code) between :fm_section_code and :to_section_code
				AND     NVL(EXAM_CODE,:fm_exam_code) between :fm_exam_code and :to_exam_code
				ORDER BY B.SECTION_CODE, A.PATIENT_CLASS, C.NATIONALITY_CODE; */ 


		}
		
		if (strcmp(summarization_level.arr,"E")==0)
		{
		 
		 /* EXEC SQL DECLARE  REQUEST_CUR1 CURSOR FOR
                SELECT	B.SECTION_CODE,
						A.PATIENT_CLASS,
						C.NATIONALITY_CODE,
						B.EXAM_CODE,
						A.PATIENT_ID,
						C.SEX,
						ROUND(REQUEST_DATE - C.DATE_OF_BIRTH)
				FROM	RD_REQUEST A,RD_EXAM_VIEW_REQUESTED B,MP_PATIENT_MAST C
				WHERE   A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				AND		A.REQUEST_NUM = B.REQUEST_NUM
				AND		A.PATIENT_ID = C.PATIENT_ID
				AND		NVL(B.STATUS,'X')!='99'
				AND     A.OPERATING_FACILITY_ID = :t_facility_id
				AND     TRUNC(A.REQUEST_DATE) between to_date(:fm_period_date,'dd/mm/yyyy') and to_date(:to_period_date,'dd/mm/yyyy')
				AND     NVL(WING_CODE,:fm_wing_code) between :fm_wing_code and	:to_wing_code
				AND     NVL(EXAM_ROOM,:fm_clinic_code) between :fm_clinic_code and :to_clinic_code
				AND     NVL(B.SECTION_CODE,:fm_section_code) between :fm_section_code and :to_section_code
				AND     NVL(EXAM_CODE,:fm_exam_code) between :fm_exam_code and :to_exam_code
				ORDER BY B.EXAM_CODE, A.PATIENT_CLASS, C.NATIONALITY_CODE; */ 

		}
		
		if (strcmp(summarization_level.arr,"V")==0)
		{
		 
		 /* EXEC SQL DECLARE  REQUEST_CUR2 CURSOR FOR
                SELECT	B.SECTION_CODE,
						A.PATIENT_CLASS,
						C.NATIONALITY_CODE,
						B.EXAM_CODE,
						A.PATIENT_ID,
						C.SEX,
						ROUND(REQUEST_DATE - C.DATE_OF_BIRTH),
						NVL(D.VIEW_CODE,'XXXX') 
				FROM	RD_REQUEST A, RD_EXAM_VIEW_REQUESTED B, MP_PATIENT_MAST C, RD_REQUEST_EXAM_VIEWS D
				WHERE   A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				AND		A.REQUEST_NUM = B.REQUEST_NUM
				AND		A.PATIENT_ID = C.PATIENT_ID
				AND		D.OPERATING_FACILITY_ID(+)=B.OPERATING_FACILITY_ID
				AND		D.REQUEST_NUM(+)=B.REQUEST_NUM
				AND		D.REQUEST_LINE_NUM(+)=B.REQUEST_LINE_NUM
				AND		NVL(B.STATUS,'X')!='99'
				AND     D.VIEW_CODE IS NOT NULL
				AND     A.OPERATING_FACILITY_ID = :t_facility_id
				AND     TRUNC(A.REQUEST_DATE) between to_date(:fm_period_date,'dd/mm/yyyy') and to_date(:to_period_date,'dd/mm/yyyy')
				AND     NVL(WING_CODE,:fm_wing_code) between :fm_wing_code and	:to_wing_code
				AND     NVL(EXAM_ROOM,:fm_clinic_code) between :fm_clinic_code and :to_clinic_code
				AND     NVL(B.SECTION_CODE,:fm_section_code) between :fm_section_code and :to_section_code
				AND     NVL(B.EXAM_CODE,:fm_exam_code) between :fm_exam_code and :to_exam_code
				AND     NVL(D.VIEW_CODE,:fm_view_code) between :fm_view_code and :to_view_code
				ORDER BY D.VIEW_CODE, A.PATIENT_CLASS, C.NATIONALITY_CODE; */ 

		}


		if (strcmp(summarization_level.arr,"M")==0)
		{
		 
		 /* EXEC SQL DECLARE  REQUEST_CUR3 CURSOR FOR
                SELECT	B.SECTION_CODE,
						A.PATIENT_CLASS,
						C.NATIONALITY_CODE,
						B.EXAM_CODE,
						A.PATIENT_ID,
						C.SEX,
						ROUND(REQUEST_DATE - C.DATE_OF_BIRTH),
						E.EXAM_CATEGORY_PARENT 
				FROM RD_REQUEST A,RD_EXAM_VIEW_REQUESTED B, MP_PATIENT_MAST C, RD_EXAMS D, RD_EXAM_CATEGORY E
				WHERE   A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				AND		A.REQUEST_NUM = B.REQUEST_NUM
				AND		A.PATIENT_ID = C.PATIENT_ID
				AND     B.EXAM_CODE = D.EXAM_CODE
				AND     D.EXAM_CATEGORY_CODE = E.EXAM_CATEGORY_CODE
				AND		NVL(B.STATUS,'X')!='99'
				AND     A.OPERATING_FACILITY_ID = :t_facility_id
				AND     TRUNC(A.REQUEST_DATE) between to_date(:fm_period_date,'dd/mm/yyyy') and to_date(:to_period_date,'dd/mm/yyyy')
				AND     NVL(A.WING_CODE,:fm_wing_code) between :fm_wing_code and	:to_wing_code
				AND     NVL(B.EXAM_ROOM,:fm_clinic_code) between :fm_clinic_code and :to_clinic_code
				AND     NVL(B.SECTION_CODE,:fm_section_code) between :fm_section_code and :to_section_code
				AND     NVL(B.EXAM_CODE,:fm_exam_code) between :fm_exam_code and :to_exam_code
				AND     NVL(E.EXAM_CATEGORY_PARENT,:fm_main_exam_catg) between :fm_main_exam_catg and :to_main_exam_catg
				ORDER BY E.EXAM_CATEGORY_PARENT, A.PATIENT_CLASS, C.NATIONALITY_CODE; */ 

		}


		if (strcmp(summarization_level.arr,"U")==0)
		{
		 
		 /* EXEC SQL DECLARE  REQUEST_CUR4 CURSOR FOR
                SELECT	B.SECTION_CODE,
						A.PATIENT_CLASS,
						C.NATIONALITY_CODE,
						B.EXAM_CODE,
						A.PATIENT_ID,
						C.SEX,
						ROUND(REQUEST_DATE - C.DATE_OF_BIRTH),
						E.EXAM_CATEGORY_CODE 
				FROM RD_REQUEST A,RD_EXAM_VIEW_REQUESTED B, MP_PATIENT_MAST C, RD_EXAMS D, RD_EXAM_CATEGORY E
				WHERE   A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				AND		A.REQUEST_NUM = B.REQUEST_NUM
				AND		A.PATIENT_ID = C.PATIENT_ID
				AND     B.EXAM_CODE = D.EXAM_CODE
				AND     D.EXAM_CATEGORY_CODE = E.EXAM_CATEGORY_CODE
				AND		NVL(B.STATUS,'X')!='99'
				AND     A.OPERATING_FACILITY_ID = :t_facility_id
				AND     TRUNC(A.REQUEST_DATE) between to_date(:fm_period_date,'dd/mm/yyyy') and to_date(:to_period_date,'dd/mm/yyyy')
				AND     NVL(A.WING_CODE,:fm_wing_code) between :fm_wing_code and	:to_wing_code
				AND     NVL(B.EXAM_ROOM,:fm_clinic_code) between :fm_clinic_code and :to_clinic_code
				AND     NVL(B.SECTION_CODE,:fm_section_code) between :fm_section_code and :to_section_code
				AND     NVL(B.EXAM_CODE,:fm_exam_code) between :fm_exam_code and :to_exam_code
				AND     NVL(E.EXAM_CATEGORY_CODE,:fm_sub_exam_catg) between :fm_sub_exam_catg and :to_sub_exam_catg
				ORDER BY E.EXAM_CATEGORY_CODE, A.PATIENT_CLASS, C.NATIONALITY_CODE; */ 

		}


		if (strcmp(summarization_level.arr,"L")==0)
		{

		 /* EXEC SQL DECLARE  REQUEST_CUR5 CURSOR FOR
                SELECT	B.SECTION_CODE,
						A.PATIENT_CLASS,
						C.NATIONALITY_CODE,
						B.EXAM_CODE,
						A.PATIENT_ID,
						C.SEX,
						ROUND(REQUEST_DATE - C.DATE_OF_BIRTH),
						B.EXAM_ROOM
				FROM RD_REQUEST A,RD_EXAM_VIEW_REQUESTED B, MP_PATIENT_MAST C, RD_EXAMS D, RD_EXAM_CATEGORY E
				WHERE   A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				AND		A.REQUEST_NUM = B.REQUEST_NUM
				AND		A.PATIENT_ID = C.PATIENT_ID
				AND     B.EXAM_CODE = D.EXAM_CODE
				AND     D.EXAM_CATEGORY_CODE = E.EXAM_CATEGORY_CODE
				AND		NVL(B.STATUS,'X')!='99'
				AND     A.OPERATING_FACILITY_ID = :t_facility_id
				AND     TRUNC(A.REQUEST_DATE) between to_date(:fm_period_date,'dd/mm/yyyy') and to_date(:to_period_date,'dd/mm/yyyy')
				AND     NVL(A.WING_CODE,:fm_wing_code) between :fm_wing_code and	:to_wing_code
				AND     NVL(B.EXAM_ROOM,:fm_clinic_code) between :fm_clinic_code and :to_clinic_code
				AND     NVL(B.SECTION_CODE,:fm_section_code) between :fm_section_code and :to_section_code
				AND     NVL(B.EXAM_CODE,:fm_exam_code) between :fm_exam_code and :to_exam_code
				AND     NVL(E.EXAM_CATEGORY_CODE,:fm_sub_exam_catg) between :fm_sub_exam_catg and :to_sub_exam_catg
				AND     B.EXAM_ROOM BETWEEN nvl(:fm_clinic_code, B.EXAM_ROOM) and  nvl(:to_clinic_code , B.EXAM_ROOM)
				ORDER BY B.EXAM_ROOM, A.PATIENT_CLASS, C.NATIONALITY_CODE; */ 

		}

		
/*-------------- Check for any error and No data found ----------------------*/

     if (OERROR) 
       {
          disp_message(ERR_MESG,"SELECT failed on RD_REQUEST\n");
          proc_exit();
       }

/*------------------------- End of Error Check -------------------------------*/

     /* EXEC SQL OPEN REQUEST_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0006;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )228;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&t_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&fm_period_date;
     sqlstm.sqhstl[1] = (unsigned int  )33;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&to_period_date;
     sqlstm.sqhstl[2] = (unsigned int  )33;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&fm_wing_code;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&fm_wing_code;
     sqlstm.sqhstl[4] = (unsigned int  )5;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&to_wing_code;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&fm_clinic_code;
     sqlstm.sqhstl[6] = (unsigned int  )7;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&fm_clinic_code;
     sqlstm.sqhstl[7] = (unsigned int  )7;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&to_clinic_code;
     sqlstm.sqhstl[8] = (unsigned int  )7;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&fm_section_code;
     sqlstm.sqhstl[9] = (unsigned int  )7;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&fm_section_code;
     sqlstm.sqhstl[10] = (unsigned int  )7;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&to_section_code;
     sqlstm.sqhstl[11] = (unsigned int  )7;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&fm_exam_code;
     sqlstm.sqhstl[12] = (unsigned int  )13;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&fm_exam_code;
     sqlstm.sqhstl[13] = (unsigned int  )13;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&to_exam_code;
     sqlstm.sqhstl[14] = (unsigned int  )13;
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


	 /* EXEC SQL OPEN REQUEST_CUR1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0007;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )303;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&t_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&fm_period_date;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&to_period_date;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&to_wing_code;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&to_clinic_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[10] = (unsigned int  )7;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&to_section_code;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[12] = (unsigned int  )13;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[13] = (unsigned int  )13;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&to_exam_code;
  sqlstm.sqhstl[14] = (unsigned int  )13;
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


	 /* EXEC SQL OPEN REQUEST_CUR2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0008;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )378;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&t_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&fm_period_date;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&to_period_date;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&to_wing_code;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&to_clinic_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[10] = (unsigned int  )7;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&to_section_code;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[12] = (unsigned int  )13;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[13] = (unsigned int  )13;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&to_exam_code;
  sqlstm.sqhstl[14] = (unsigned int  )13;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&fm_view_code;
  sqlstm.sqhstl[15] = (unsigned int  )7;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&fm_view_code;
  sqlstm.sqhstl[16] = (unsigned int  )7;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&to_view_code;
  sqlstm.sqhstl[17] = (unsigned int  )7;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
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


	 /* EXEC SQL OPEN REQUEST_CUR3; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0009;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )465;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&t_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&fm_period_date;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&to_period_date;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&to_wing_code;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&to_clinic_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[10] = (unsigned int  )7;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&to_section_code;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[12] = (unsigned int  )13;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[13] = (unsigned int  )13;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&to_exam_code;
  sqlstm.sqhstl[14] = (unsigned int  )13;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&fm_main_exam_catg;
  sqlstm.sqhstl[15] = (unsigned int  )15;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&fm_main_exam_catg;
  sqlstm.sqhstl[16] = (unsigned int  )15;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&to_main_exam_catg;
  sqlstm.sqhstl[17] = (unsigned int  )15;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
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


	 /* EXEC SQL OPEN REQUEST_CUR4; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0010;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )552;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&t_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&fm_period_date;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&to_period_date;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&to_wing_code;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&to_clinic_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[10] = (unsigned int  )7;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&to_section_code;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[12] = (unsigned int  )13;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[13] = (unsigned int  )13;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&to_exam_code;
  sqlstm.sqhstl[14] = (unsigned int  )13;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&fm_sub_exam_catg;
  sqlstm.sqhstl[15] = (unsigned int  )15;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&fm_sub_exam_catg;
  sqlstm.sqhstl[16] = (unsigned int  )15;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&to_sub_exam_catg;
  sqlstm.sqhstl[17] = (unsigned int  )15;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
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


	 /* EXEC SQL OPEN REQUEST_CUR5; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0011;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )639;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&t_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&fm_period_date;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&to_period_date;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&fm_wing_code;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&to_wing_code;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&to_clinic_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&fm_section_code;
  sqlstm.sqhstl[10] = (unsigned int  )7;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&to_section_code;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[12] = (unsigned int  )13;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&fm_exam_code;
  sqlstm.sqhstl[13] = (unsigned int  )13;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&to_exam_code;
  sqlstm.sqhstl[14] = (unsigned int  )13;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&fm_sub_exam_catg;
  sqlstm.sqhstl[15] = (unsigned int  )15;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&fm_sub_exam_catg;
  sqlstm.sqhstl[16] = (unsigned int  )15;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&to_sub_exam_catg;
  sqlstm.sqhstl[17] = (unsigned int  )15;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&fm_clinic_code;
  sqlstm.sqhstl[18] = (unsigned int  )7;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&to_clinic_code;
  sqlstm.sqhstl[19] = (unsigned int  )7;
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



/*-------------- Check for any error and No data found ----------------------*/

     if (OERROR) 
       {
          disp_message(ERR_MESG,"OPEN failed on REQUEST_CUR\n");
          proc_exit();
       }

/*------------------------- End of Error Check -------------------------------*/
     return;
/*------------------------- End of Appt Cursor -------------------------------*/
  }

 


 void get_default_values()
 {
     
    
		/* EXEC SQL SELECT CITIZEN_NATIONALITY_CODE       
				 INTO   :cit_nationality_code
				 FROM   MP_PARAM; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select CITIZEN_NATIONALITY_CODE into :b0  from MP_PARAM ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )734;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&cit_nationality_code;
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



			cit_nationality_code.arr[cit_nationality_code.len]		= '\0';												

		
		/* EXEC SQL select range_1_fr, range_1_fr_unit, range_1_to, range_1_to_unit,
						range_2_fr, range_2_fr_unit, range_2_to, range_2_to_unit,
						range_1_desc, range_2_desc   
				 into   t_min_age1, t_range_1_fr_unit, t_max_age1, t_range_1_to_unit,
						t_min_age2, t_range_2_fr_unit, t_max_age2, t_range_2_to_unit,
						t_range_1_desc, t_range_2_desc   
				 from   am_summ_range
				 where  range_id = :age_group1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select range_1_fr ,range_1_fr_unit ,range_1_to ,range_1_to_\
unit ,range_2_fr ,range_2_fr_unit ,range_2_to ,range_2_to_unit ,range_1_desc ,\
range_2_desc into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  from am_summ_range \
where range_id=:b10";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )753;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&t_min_age1;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&t_range_1_fr_unit;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&t_max_age1;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&t_range_1_to_unit;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&t_min_age2;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&t_range_2_fr_unit;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&t_max_age2;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&t_range_2_to_unit;
  sqlstm.sqhstl[7] = (unsigned int  )5;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&t_range_1_desc;
  sqlstm.sqhstl[8] = (unsigned int  )18;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&t_range_2_desc;
  sqlstm.sqhstl[9] = (unsigned int  )18;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&age_group1;
  sqlstm.sqhstl[10] = (unsigned int  )7;
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



			t_range_1_fr_unit.arr[t_range_1_fr_unit.len]		= '\0';												
			t_range_1_to_unit.arr[t_range_1_to_unit.len]		= '\0';												
			t_range_2_fr_unit.arr[t_range_2_fr_unit.len]		= '\0';												
			t_range_2_to_unit.arr[t_range_2_to_unit.len]		= '\0';												
			t_range_1_desc.arr[t_range_1_desc.len]				= '\0';	
			t_range_2_desc.arr[t_range_2_desc.len]				= '\0';	
			
			sprintf(string_age_range, "%d %s -  %d %s", t_min_age1, t_range_1_fr_unit.arr, t_max_age1, t_range_1_to_unit.arr);

			sprintf(string_age_range_1, "%d %s -  %d %s",  t_min_age2, t_range_2_fr_unit.arr, t_max_age2, t_range_2_to_unit.arr);


			if (strcmp(t_range_1_fr_unit.arr,"Y")==0)
				t_min_days1	= (t_min_age1*365);
			else if (strcmp(t_range_1_fr_unit.arr,"M")==0)
				t_min_days1	= (t_min_age1*30);
			else if (strcmp(t_range_1_fr_unit.arr,"D")==0)
				t_min_days1	= t_min_age1;

			if (strcmp(t_range_1_to_unit.arr,"Y")==0)
				t_max_days1	= (t_max_age1*365);
			else if (strcmp(t_range_1_to_unit.arr,"M")==0)
				t_max_days1	= (t_max_age1*30);
			else if (strcmp(t_range_1_to_unit.arr,"D")==0)
				t_max_days1	= t_max_age1;


			if (strcmp(t_range_2_fr_unit.arr,"Y")==0)
				t_min_days2	= (t_min_age2*365);
			else if (strcmp(t_range_2_fr_unit.arr,"M")==0)
				t_min_days2	= (t_min_age2*30);
			else if (strcmp(t_range_2_fr_unit.arr,"D")==0)
				t_min_days2	= t_min_age2;

			if (strcmp(t_range_2_to_unit.arr,"Y")==0)
				t_max_days2	= (t_max_age2*365);
			else if (strcmp(t_range_2_to_unit.arr,"M")==0)
				t_max_days2	= (t_max_age2*30);
			else if (strcmp(t_range_2_to_unit.arr,"D")==0)
				t_max_days2	= t_max_age2;
	
     


		
	 if (OERROR)
       {
          disp_message(ERR_MESG,"SELECT failed on AM_SUMM_RANGE\n");
          proc_exit();
       }

     if (NO_DATA_FOUND)
       {
          disp_message(ERR_MESG,"No Data Found in the AM_SUMM_RANGE\n");
          proc_exit();
       }


     return;
  }






/*------------------------- Fetching from Appt Cursor ------------------------*/
void do_report()
  {
     void	print_page_header(),
       		print_rep_header(),
			print_hdr(),
			print_hdr_1(),
			print_col_heading(),
			print_detl_rec(),
			print_section_total(),
			get_exam_desc(),
			get_wing_desc(),
			get_view_desc(),
			get_exam_catg_sub(),
			get_exam_catg_par(),
			get_section_desc(),
			get_study_location_desc();
     int   fetch_appt_cur();
	 int   still_rec_left, posted = 0;

    print_rep_header(); /* once for the report */
	print_page_header();
	
	still_rec_left = fetch_appt_cur();
		
	while ( still_rec_left )
    {
		if (strcmp(summarization_level.arr,"S") == 0) 
	 	{

			print_hdr();
			print_col_heading();

			sec_male_nat_tot1	= 0;
			sec_female_nat_tot1	= 0;
			sec_male_oth_tot1	= 0;
			sec_female_oth_tot1	= 0;
			sec_male_nat_tot2	= 0;
			sec_female_nat_tot2	= 0;
			sec_male_oth_tot2	= 0;
			sec_female_oth_tot2	= 0;


			strcpy(h_section_code.arr, t_section_code.arr);
			h_section_code.len = strlen(t_section_code.arr);

		 while((strcmp(h_section_code.arr, t_section_code.arr) == 0)
					&& still_rec_left)
		 {
			strcpy(h_patient_class.arr, t_patient_class.arr);
			h_patient_class.len = strlen(t_patient_class.arr);

			t_male_nat_age1		= 0;
			t_female_nat_age1	= 0;
			t_male_oth_age1		= 0;
			t_female_oth_age1	= 0;
			t_male_nat_age2		= 0;
			t_female_nat_age2	= 0;
			t_male_oth_age2		= 0;
			t_female_oth_age2	= 0;

			while((strcmp(h_section_code.arr, t_section_code.arr) == 0)
				  && (strcmp(h_patient_class.arr, t_patient_class.arr) == 0)
				  && still_rec_left)
			{

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
							t_male_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
							t_male_nat_age2	+= 1;
						}

				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
							t_female_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_nat_age2	+= 1;
						}
					
				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_male_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_male_oth_age2	+= 1;				
						}


				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
				{
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_female_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_oth_age2	+= 1;				
						}
				}

					still_rec_left = fetch_appt_cur();
			
			}
					
					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
					}
					print_detl_rec();

		  }

					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
						print_line('_',REP_WIDTH);
					}
					else
					print_line('_',REP_WIDTH);
					print_section_total();
					print_line('_',REP_WIDTH);

		}				


		if (strcmp(summarization_level.arr,"E") == 0) 
	 	{
			print_hdr();
			print_col_heading();

			sec_male_nat_tot1	= 0;
			sec_female_nat_tot1	= 0;
			sec_male_oth_tot1	= 0;
			sec_female_oth_tot1	= 0;
			sec_male_nat_tot2	= 0;
			sec_female_nat_tot2	= 0;
			sec_male_oth_tot2	= 0;
			sec_female_oth_tot2	= 0;

			strcpy(h_exam_code.arr, t_exam_code.arr);
			h_exam_code.len = strlen(t_exam_code.arr);

			while((strcmp(h_exam_code.arr, t_exam_code.arr) == 0)
					&& still_rec_left)
			{
				strcpy(h_patient_class.arr, t_patient_class.arr);
				h_patient_class.len = strlen(t_patient_class.arr);

				t_male_nat_age1		= 0;
				t_female_nat_age1	= 0;
				t_male_oth_age1		= 0;
				t_female_oth_age1	= 0;
				t_male_nat_age2		= 0;
				t_female_nat_age2	= 0;
				t_male_oth_age2		= 0;
				t_female_oth_age2	= 0;

				while( (strcmp(h_exam_code.arr, t_exam_code.arr) == 0)
					&& (strcmp(h_patient_class.arr, t_patient_class.arr) == 0)
					&& still_rec_left)
				{
					if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
					{
							
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_male_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_male_nat_age2	+= 1;
						}

						
					}

					if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
					{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_female_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_nat_age2	+= 1;
						}
					
					}

					if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
					{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_male_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_male_oth_age2	+= 1;				
						}


					}

					if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
					{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_female_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_oth_age2	+= 1;				
						}
					}

					still_rec_left = fetch_appt_cur();
					
			
				}

						
					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
					}
					
					print_detl_rec();
					

			}

					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
						print_line('_',REP_WIDTH);
					}
					else
					print_line('_',REP_WIDTH);
					print_section_total();
					print_line('_',REP_WIDTH);

					
		}				


		if (strcmp(summarization_level.arr,"V") == 0) 
	 	{

			print_hdr();
			print_col_heading();

			sec_male_nat_tot1	= 0;
			sec_female_nat_tot1	= 0;
			sec_male_oth_tot1	= 0;
			sec_female_oth_tot1	= 0;
			sec_male_nat_tot2	= 0;
			sec_female_nat_tot2	= 0;
			sec_male_oth_tot2	= 0;
			sec_female_oth_tot2	= 0;

			strcpy(h_view_code.arr, t_view_code.arr);
			h_view_code.len = strlen(t_view_code.arr);

			while((strcmp(h_view_code.arr, t_view_code.arr) == 0)
					&& still_rec_left)
			{
				strcpy(h_patient_class.arr, t_patient_class.arr);
				h_patient_class.len = strlen(t_patient_class.arr);

				t_male_nat_age1		= 0;
				t_female_nat_age1	= 0;
				t_male_oth_age1		= 0;
				t_female_oth_age1	= 0;
				t_male_nat_age2		= 0;
				t_female_nat_age2	= 0;
				t_male_oth_age2		= 0;
				t_female_oth_age2	= 0;

				while( (strcmp(h_view_code.arr, t_view_code.arr) == 0)
					&& (strcmp(h_patient_class.arr, t_patient_class.arr) == 0)
					&& still_rec_left)
				{

					if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
					{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_male_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_male_nat_age2	+= 1;
						}

						
					}

					if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
					{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_female_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_nat_age2	+= 1;
						}
					
					}

					if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
					{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_male_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_male_oth_age2	+= 1;				
						}


					}

					if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
					{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_female_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_oth_age2	+= 1;				
						}
					}

					still_rec_left = fetch_appt_cur();
					
			
				}

						
					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
					}
					
					print_detl_rec();
					

			}

					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
						print_line('_',REP_WIDTH);
					}
					else
					print_line('_',REP_WIDTH);
					print_section_total();
					print_line('_',REP_WIDTH);

					
		}				


			
		if (strcmp(summarization_level.arr,"M") == 0) 
	 	{

			print_hdr();
			print_col_heading();

			sec_male_nat_tot1	= 0;
			sec_female_nat_tot1	= 0;
			sec_male_oth_tot1	= 0;
			sec_female_oth_tot1	= 0;
			sec_male_nat_tot2	= 0;
			sec_female_nat_tot2	= 0;
			sec_male_oth_tot2	= 0;
			sec_female_oth_tot2	= 0;

			strcpy(h_exam_catg_code.arr, t_exam_catg_code.arr);
			h_exam_catg_code.len = strlen(t_exam_catg_code.arr);

		 while((strcmp(h_exam_catg_code.arr, t_exam_catg_code.arr) == 0)
					&& still_rec_left)
		 {
			strcpy(h_patient_class.arr, t_patient_class.arr);
			h_patient_class.len = strlen(t_patient_class.arr);

			t_male_nat_age1		= 0;
			t_female_nat_age1	= 0;
			t_male_oth_age1		= 0;
			t_female_oth_age1	= 0;
			t_male_nat_age2		= 0;
			t_female_nat_age2	= 0;
			t_male_oth_age2		= 0;
			t_female_oth_age2	= 0;

			while((strcmp(h_exam_catg_code.arr, t_exam_catg_code.arr) == 0)
				  && (strcmp(h_patient_class.arr, t_patient_class.arr) == 0)
				  && still_rec_left)
			{

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
							t_male_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
							t_male_nat_age2	+= 1;
						}

				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
							t_female_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_nat_age2	+= 1;
						}
					
				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_male_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_male_oth_age2	+= 1;				
						}


				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
				{
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_female_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_oth_age2	+= 1;				
						}
				}

					still_rec_left = fetch_appt_cur();
			
			}
					
					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
					}
					print_detl_rec();

		  }

					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
						print_line('_',REP_WIDTH);
					}
					else
					print_line('_',REP_WIDTH);
					print_section_total();
					print_line('_',REP_WIDTH);

		}


			
		if (strcmp(summarization_level.arr,"U") == 0) 
	 	{

			print_hdr();
			print_col_heading();
		
			sec_male_nat_tot1	= 0;
			sec_female_nat_tot1	= 0;
			sec_male_oth_tot1	= 0;
			sec_female_oth_tot1	= 0;
			sec_male_nat_tot2	= 0;
			sec_female_nat_tot2	= 0;
			sec_male_oth_tot2	= 0;
			sec_female_oth_tot2	= 0;

			strcpy(h_exam_catg_code.arr, t_exam_catg_code.arr);
			h_exam_catg_code.len = strlen(t_exam_catg_code.arr);

		 while((strcmp(h_exam_catg_code.arr, t_exam_catg_code.arr) == 0)
					&& still_rec_left)
		 {
			strcpy(h_patient_class.arr, t_patient_class.arr);
			h_patient_class.len = strlen(t_patient_class.arr);

			t_male_nat_age1		= 0;
			t_female_nat_age1	= 0;
			t_male_oth_age1		= 0;
			t_female_oth_age1	= 0;
			t_male_nat_age2		= 0;
			t_female_nat_age2	= 0;
			t_male_oth_age2		= 0;
			t_female_oth_age2	= 0;

			while((strcmp(h_exam_catg_code.arr, t_exam_catg_code.arr) == 0)
				  && (strcmp(h_patient_class.arr, t_patient_class.arr) == 0)
				  && still_rec_left)
			{

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
							t_male_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
							t_male_nat_age2	+= 1;
						}

				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
							t_female_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_nat_age2	+= 1;
						}
					
				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_male_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_male_oth_age2	+= 1;				
						}


				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
				{
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_female_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_oth_age2	+= 1;				
						}
				}

					still_rec_left = fetch_appt_cur();
			
			}
					
					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
					}
					print_detl_rec();

		  }

					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
						print_line('_',REP_WIDTH);
					}
					else
					print_line('_',REP_WIDTH);
					print_section_total();
					print_line('_',REP_WIDTH);

		}

		if (strcmp(summarization_level.arr,"L") == 0) 
	 	{

			print_hdr();

			print_col_heading();
		
			sec_male_nat_tot1	= 0;
			sec_female_nat_tot1	= 0;
			sec_male_oth_tot1	= 0;
			sec_female_oth_tot1	= 0;
			sec_male_nat_tot2	= 0;
			sec_female_nat_tot2	= 0;
			sec_male_oth_tot2	= 0;
			sec_female_oth_tot2	= 0;

			strcpy(h_study_location.arr, t_study_location.arr);
			h_study_location.len = strlen(t_exam_catg_code.arr);


		 while((strcmp(h_study_location.arr, t_study_location.arr) == 0)
					&& still_rec_left)
		 {
			strcpy(h_patient_class.arr, t_patient_class.arr);
			h_patient_class.len = strlen(t_patient_class.arr);

			t_male_nat_age1		= 0;
			t_female_nat_age1	= 0;
			t_male_oth_age1		= 0;
			t_female_oth_age1	= 0;
			t_male_nat_age2		= 0;
			t_female_nat_age2	= 0;
			t_male_oth_age2		= 0;
			t_female_oth_age2	= 0;

			while((strcmp(h_study_location.arr, t_study_location.arr) == 0)
				  && (strcmp(h_patient_class.arr, t_patient_class.arr) == 0)
				  && still_rec_left)
			{

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
							t_male_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
							t_male_nat_age2	+= 1;
						}

				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)==0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
							t_female_nat_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_nat_age2	+= 1;
						}
					
				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"M")==0) && still_rec_left)
				{
						
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_male_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_male_oth_age2	+= 1;				
						}


				}

				if ((strcmp(t_nationality_code.arr,cit_nationality_code.arr)!=0)
					&& (strcmp(t_sex.arr,"F")==0) && still_rec_left)
				{
						if ((t_date_of_birth_days >= t_min_days1) &&
							(t_date_of_birth_days <= t_max_days1) )
						{
								t_female_oth_age1	+= 1;
						}
							
						if ((t_date_of_birth_days >= t_min_days2) &&
							(t_date_of_birth_days <= t_max_days2) )
						{
								t_female_oth_age2	+= 1;				
						}
				}

					still_rec_left = fetch_appt_cur();
			
			}
					
					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
					}
					print_detl_rec();

		  }

					if ( ( line_no + 6 ) > MAX_LINES )
					{	
						page_skip();
						print_line('_',REP_WIDTH);
					}
					else
					print_line('_',REP_WIDTH);
					print_section_total();
					print_line('_',REP_WIDTH);

		}

	
	}



	
	if ( ( line_no + 6 ) > MAX_LINES )
	{	
		page_skip();
		print_line('_',REP_WIDTH);
	}
	else
		print_line('_',REP_WIDTH);

	print_end_of_rep();
}
/* -------------------------- End of Report function -------------------------*/

/*--------------------------- Page Skip --------------------------------------*/
page_skip()
{
     line_no = 11;
     fprintf(f1,"\f");

     print_page_header();

	 print_hdr_1();
	 print_col_heading();
}
/*--------------------------- End of Page Skip -------------------------------*/
/* fetches the next record from REQUEST_CUR     */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_appt_cur()
  {

	 t_section_code.len				= 0;
	 t_patient_class.len			= 0;
	 t_nationality_code.len			= 0;
	 t_exam_code.len				= 0;
	 t_patient_id.len				= 0;
	 t_sex.len						= 0;
	 t_view_code.len				= 0;
	 t_exam_catg_code.len			= 0;
	 
	 t_section_code.arr[t_section_code.len]					= '\0';
	 t_patient_class.arr[t_patient_class.len]				= '\0';
	 t_nationality_code.arr[t_nationality_code.len]			= '\0';						
	 t_exam_code.arr[t_exam_code.len]						= '\0';												
	 t_patient_id.arr[t_patient_id.len]						= '\0';																	
	 t_sex.arr[t_sex.len]									= '\0';											
	 t_view_code.arr[t_view_code.len]						= '\0';																		
	 t_exam_catg_code.arr[t_exam_catg_code.len]				= '\0';																		

	 if (strcmp(summarization_level.arr,"S")==0)
	 {

     /* EXEC SQL FETCH REQUEST_CUR INTO
						:t_section_code,
						:t_patient_class,
						:t_nationality_code,
						:t_exam_code,
						:t_patient_id,
						:t_sex,
						:t_date_of_birth_days; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )812;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&t_section_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&t_patient_class;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&t_nationality_code;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&t_exam_code;
     sqlstm.sqhstl[3] = (unsigned int  )13;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&t_patient_id;
     sqlstm.sqhstl[4] = (unsigned int  )23;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&t_sex;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&t_date_of_birth_days;
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


	 }

	 

	 if (strcmp(summarization_level.arr,"E")==0)
	 {
		
	   /* EXEC SQL FETCH REQUEST_CUR1 INTO
						:t_section_code,
						:t_patient_class,
						:t_nationality_code,
						:t_exam_code,
						:t_patient_id,
						:t_sex,
						:t_date_of_birth_days; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )855;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&t_section_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_patient_class;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_nationality_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_exam_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_sex;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_date_of_birth_days;
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



	 }

	 if (strcmp(summarization_level.arr,"V")==0)
	 {
		
	   /* EXEC SQL FETCH REQUEST_CUR2 INTO
						:t_section_code,
						:t_patient_class,
						:t_nationality_code,
						:t_exam_code,
						:t_patient_id,
						:t_sex,
						:t_date_of_birth_days,
						:t_view_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )898;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&t_section_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_patient_class;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_nationality_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_exam_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_sex;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_date_of_birth_days;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_view_code;
    sqlstm.sqhstl[7] = (unsigned int  )7;
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



	 }

	 if (strcmp(summarization_level.arr,"M")==0)
	 {
		
	   /* EXEC SQL FETCH REQUEST_CUR3 INTO
						:t_section_code,
						:t_patient_class,
						:t_nationality_code,
						:t_exam_code,
						:t_patient_id,
						:t_sex,
						:t_date_of_birth_days,
						:t_exam_catg_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )945;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&t_section_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_patient_class;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_nationality_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_exam_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_sex;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_date_of_birth_days;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_exam_catg_code;
    sqlstm.sqhstl[7] = (unsigned int  )15;
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



	 }


	 if (strcmp(summarization_level.arr,"U")==0)
	 {
		
	   /* EXEC SQL FETCH REQUEST_CUR4 INTO
						:t_section_code,
						:t_patient_class,
						:t_nationality_code,
						:t_exam_code,
						:t_patient_id,
						:t_sex,
						:t_date_of_birth_days,
						:t_exam_catg_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )992;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&t_section_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_patient_class;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_nationality_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_exam_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_sex;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_date_of_birth_days;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_exam_catg_code;
    sqlstm.sqhstl[7] = (unsigned int  )15;
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



	 }
								

	 if (strcmp(summarization_level.arr,"L")==0)
	 {
	
	   /* EXEC SQL FETCH REQUEST_CUR5 INTO
						:t_section_code,
						:t_patient_class,
						:t_nationality_code,
						:t_exam_code,
						:t_patient_id,
						:t_sex,
						:t_date_of_birth_days,
						:t_study_location; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1039;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&t_section_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_patient_class;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_nationality_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_exam_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_sex;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_date_of_birth_days;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_study_location;
    sqlstm.sqhstl[7] = (unsigned int  )7;
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



	 }

    
     if (OERROR) 
       {
          disp_message(ORA_MESG,"FETCH failed\n");
          proc_exit();
       }

     if (NO_DATA_FOUND)
       return 0;

     t_section_code.arr[t_section_code.len]					= '\0';
	 t_patient_class.arr[t_patient_class.len]				= '\0';
	 t_nationality_code.arr[t_nationality_code.len]			= '\0';						
	 t_exam_code.arr[t_exam_code.len]						= '\0';												
	 t_patient_id.arr[t_patient_id.len]						= '\0';																	
	 t_sex.arr[t_sex.len]									= '\0';																	
	 t_view_code.arr[t_view_code.len]						= '\0';													 						
	 t_exam_catg_code.arr[t_exam_catg_code.len]				= '\0';													 						

	 

     return 1;
  }
 
         
/* to print the detailed record with to horizontal summeries */
void print_detl_rec()
{
    fprintf(f1,"%-4.4s", h_patient_class.arr); horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", t_male_nat_age1);horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", t_female_nat_age1);horz_skip(2);
	fprintf(f1,"%6d", t_male_oth_age1);horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", t_female_oth_age1);horz_skip(2);

	fprintf(f1,"%6d", t_male_nat_age2);horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", t_female_nat_age2);horz_skip(2);
	fprintf(f1,"%6d", t_male_oth_age2);horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", t_female_oth_age2);

	fprintf(f1,"\n\n");

	sec_male_nat_tot1	+= t_male_nat_age1;
	sec_female_nat_tot1	+= t_female_nat_age1;
	sec_male_oth_tot1	+= t_male_oth_age1;
	sec_female_oth_tot1	+= t_female_oth_age1;
	sec_male_nat_tot2	+= t_male_nat_age2;
	sec_female_nat_tot2	+= t_female_nat_age2;
	sec_male_oth_tot2	+= t_male_oth_age2;
	sec_female_oth_tot2	+= t_female_oth_age2;

	line_no += 2;

}

/*----------------------------- Service    Total --------------------------*/
void print_section_total()
  { 
    
	fprintf(f1,"%-8s",loc_legend[31]);
	fprintf(f1,"%6d", sec_male_nat_tot1);horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", sec_female_nat_tot1);horz_skip(2);
	fprintf(f1,"%6d", sec_male_oth_tot1);horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", sec_female_oth_tot1);horz_skip(2);

	fprintf(f1,"%6d", sec_male_nat_tot2);horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", sec_female_nat_tot2);horz_skip(2);
	fprintf(f1,"%6d", sec_male_oth_tot2);horz_skip(2);horz_skip(2);
	fprintf(f1,"%6d", sec_female_oth_tot2);

	fprintf(f1,"\n");

	sec_male_nat_tot1	= 0;
	sec_female_nat_tot1	= 0;
	sec_male_oth_tot1	= 0;
	sec_female_oth_tot1	= 0;
	sec_male_nat_tot2	= 0;
	sec_female_nat_tot2	= 0;
	sec_male_oth_tot2	= 0;
	sec_female_oth_tot2	= 0;

	line_no += 2;

  }


/*-------------------------------- Grand Total -------------------------------*/
print_grand_tot()
{
	  //fprintf(f1,"%-45.45s", "Grand   Total : ");
	  fprintf(f1,"%-45.45s :", loc_legend[33]);
	  fprintf(f1,"%7d",gr_total_inpat); horz_skip(2);
	  fprintf(f1,"%6d",gr_total_outpat); horz_skip(2);
	  fprintf(f1,"%8d",gr_total_referral); horz_skip(2);
	  fprintf(f1,"%6d\n",gr_total_pat); 
}

/*----------------------------- Get Exam Desc --------------------------------*/
void get_exam_desc ()
  {
     t_exam_desc.arr[0]  = '\0';
     t_exam_desc.len     = 0;

     /* EXEC SQL SELECT LONG_DESC
	      INTO   :t_exam_desc
	      FROM   RD_EXAMINATION
	      WHERE  EXAM_CODE = :t_exam_code
		  AND    LANGUAGE_ID = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RD_EXAMINATION where (EX\
AM_CODE=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1086;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&t_exam_desc;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&t_exam_code;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



     t_exam_desc.arr [t_exam_desc.len ] = '\0';
  }


 void get_exam_catg_par ()
  {
     t_exam_catg_desc.arr[0]  = '\0';
     t_exam_catg_desc.len     = 0;

     /* EXEC SQL SELECT SHORT_DESC
	      INTO   :t_exam_catg_desc
	      FROM   RD_EXAM_CATEGORY_LANG_VW
	      WHERE  EXAM_CATEGORY_PARENT = :t_exam_catg_code
		  AND    LANGUAGE_ID = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SHORT_DESC into :b0  from RD_EXAM_CATEGORY_LANG_V\
W where (EXAM_CATEGORY_PARENT=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1113;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&t_exam_catg_desc;
     sqlstm.sqhstl[0] = (unsigned int  )33;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&t_exam_catg_code;
     sqlstm.sqhstl[1] = (unsigned int  )15;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



     t_exam_catg_desc.arr [t_exam_catg_desc.len ] = '\0';
  }

  void get_exam_catg_sub ()
  {
     t_exam_catg_desc.arr[0]  = '\0';
     t_exam_catg_desc.len     = 0;

     /* EXEC SQL SELECT SHORT_DESC
	      INTO   :t_exam_catg_desc
	      FROM   RD_EXAM_CATEGORY_LANG_VW
	      WHERE  EXAM_CATEGORY_CODE = :t_exam_catg_code
		  AND    LANGUAGE_ID = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SHORT_DESC into :b0  from RD_EXAM_CATEGORY_LANG_V\
W where (EXAM_CATEGORY_CODE=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1140;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&t_exam_catg_desc;
     sqlstm.sqhstl[0] = (unsigned int  )33;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&t_exam_catg_code;
     sqlstm.sqhstl[1] = (unsigned int  )15;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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



     t_exam_catg_desc.arr [t_exam_catg_desc.len ] = '\0';
  }

/*-------------- Study location desc ---------------- */
  void get_study_location_desc()
  {
     t_study_location_desc.arr[0]  = '\0';
     t_study_location_desc.len     = 0;

     /* EXEC SQL SELECT SHORT_DESC
	      INTO   :t_study_location_desc
	      FROM   RD_CLINIC_LANG_VW
	      WHERE  CLINIC_CODE    = :t_study_location
		  AND    OPERATING_FACILITY_ID = :nd_facility_id
		  AND    LANGUAGE_ID  =  :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SHORT_DESC into :b0  from RD_CLINIC_LANG_VW where\
 ((CLINIC_CODE=:b1 and OPERATING_FACILITY_ID=:b2) and LANGUAGE_ID=:b3)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1167;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&t_study_location_desc;
     sqlstm.sqhstl[0] = (unsigned int  )18;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&t_study_location;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&p_language_id;
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



     t_study_location_desc.arr [t_study_location_desc.len ] = '\0';
  }






/*----------------------------- End Exam Desc -------------------------------*/

/*------ gets the Wing desc for the Wing code ----------------------------*/
void get_wing_desc()
{
  
  t_wing_desc.arr [0]   = '\0';
  t_wing_desc.len     = 0;

   /* EXEC SQL SELECT SHORT_DESC
            INTO   :t_wing_desc
			FROM   RD_WINGS_LANG_VW
	    WHERE OPERATING_FACILITY_ID = :nd_facility_id
			   AND WING_CODE = :t_wing_code
			   AND LANGUAGE_ID = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from RD_WINGS_LANG_VW where ((\
OPERATING_FACILITY_ID=:b1 and WING_CODE=:b2) and LANGUAGE_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1198;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&t_wing_desc;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&t_wing_code;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&p_language_id;
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

	

  t_wing_desc.arr [t_wing_desc.len ] = '\0';
  return;
}

/*-------------------- End of Wing Desc ------------------------------------*/

void get_section_desc()
{
  
  t_section_desc.arr [0]   = '\0';
  t_section_desc.len     = 0;

   /* EXEC SQL SELECT SHORT_DESC
            INTO   :t_section_desc
			FROM   RD_SECTION_LANG_VW
	    WHERE SECTION_CODE = :t_section_code
		AND   LANGUAGE_ID  = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from RD_SECTION_LANG_VW where \
(SECTION_CODE=:b1 and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1229;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&t_section_desc;
   sqlstm.sqhstl[0] = (unsigned int  )53;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&t_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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

	

  t_section_desc.arr [t_section_desc.len ] = '\0';
  return;
}

void get_view_desc()
{
  
  t_view_desc.arr [0]   = '\0';
  t_view_desc.len     = 0;

   /* EXEC SQL SELECT SHORT_DESC
            INTO   :t_view_desc
			FROM   RD_VIEW_LANG_VW
	    WHERE VIEW_CODE = :t_view_code
		AND    LANGUAGE_ID = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from RD_VIEW_LANG_VW where (VI\
EW_CODE=:b1 and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1256;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&t_view_desc;
   sqlstm.sqhstl[0] = (unsigned int  )53;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&t_view_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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

	

  t_view_desc.arr [t_view_desc.len ] = '\0';

  return;
}


/*-------------------- to print the header page for the report ---------------*/
void print_rep_header()
  {
     print_page_header();

     fprintf(f1,VER);
     fprintf(f1,"\n\n\n\n");
     fprintf(f1,"        ");
     //fprintf(f1,"INPUT PARAMETERS :\n");  for internationlization
	 fprintf(f1,"%s :\n",loc_legend[3]);
     fprintf(f1,"        ");
	 fprintf(f1 ,"________________\n\n");

	 if (strcmp(summarization_level.arr,"S")==0){
	    //strcpy(d_summ.arr, "Section");
		strcpy(d_summ.arr, loc_legend[4]);
	 }
	 else if (strcmp(summarization_level.arr,"E")==0){
	    //strcpy(d_summ.arr, "Exam");
		strcpy(d_summ.arr, loc_legend[5]);

	 }
	 else if (strcmp(summarization_level.arr,"V")==0){
	    //strcpy(d_summ.arr, "View");
		strcpy(d_summ.arr, loc_legend[6]);
	 }
	 else if (strcmp(summarization_level.arr,"M")==0){
	    //strcpy(d_summ.arr, "Main Exam Category");
		strcpy(d_summ.arr, loc_legend[7]);

	 }
	 else if (strcmp(summarization_level.arr,"U")==0){
	    //strcpy(d_summ.arr, "Sub Exam Category");
		strcpy(d_summ.arr, loc_legend[8]);
	 }
	 else if (strcmp(summarization_level.arr,"L")==0){
	    //strcpy(d_summ.arr, "Study Location");
		strcpy(d_summ.arr, loc_legend[9]);
	 }

	 
	 if (strcmp(fm_period_date.arr, "01/01/1800") ==0)
	     //strcpy(d_fm_period.arr, "LOWEST");
		 strcpy(d_fm_period.arr, loc_legend[13]);
     else
		{
	     //strcpy(d_fm_period.arr, fm_period_date.arr);
		 strcpy(date_convert.arr,fm_period_date.arr);
		 time_flag = 0;
         fun_change_loc_date();
		 strcpy(d_fm_period.arr, date_convert.arr);
		}

	 if (strcmp(to_period_date.arr, "31/12/4712") ==0)
	     //strcpy(d_to_period.arr, "HIGHEST");
		 strcpy(d_to_period.arr, loc_legend[14]);
     else
		{
	    // strcpy(d_to_period.arr, to_period_date.arr);
		 strcpy(date_convert.arr,to_period_date.arr);
		 time_flag = 0;
         fun_change_loc_date();
		 strcpy(d_to_period.arr, date_convert.arr);
		}

/*	 Commented for internationlization
	 fprintf(f1,"\t\tSummarization Level   : %-30s\n\n", d_summ.arr);
     fprintf(f1,"\t\tFROM EXAM DATE        : %-20s\n\n", d_fm_period.arr);
	 fprintf(f1,"\t\tTO EXAM DATE          : %-20s\n\n", d_to_period.arr);*/

 	 fprintf(f1,"\t\t%-30.30s: %-30s\n\n", loc_legend[10],d_summ.arr);
     fprintf(f1,"\t\t%-30.30s: %-20s\n\n", loc_legend[11],d_fm_period.arr);
	 fprintf(f1,"\t\t%-30.30s: %-20s\n\n", loc_legend[12],d_to_period.arr);
	 fprintf(f1,"\t\t%-30.30s: %-30s\n\n", loc_legend[15],t_facility_desc.arr);



//   fprintf(f1,"\t\tFROM EXAM DATE        : %-20s\n\n", fm_period_date.arr);
//	 fprintf(f1,"\t\tTO EXAM DATE          : %-20s\n\n", to_period_date.arr);

//	 fprintf(f1,"\t\tFACILITY              : %-30s\n\n", t_facility_desc.arr);

//     fprintf(f1,"                ");

	 if (strcmp(fm_wing_code.arr,"!!") == 0)
          /*  legend[16] -- ALL*/
		  strcpy(t_wing_desc.arr, loc_legend[16]);
     else 
	     {
	      strcpy(t_wing_code.arr,fm_wing_code.arr);
		  t_wing_code.len = strlen(t_wing_code.arr);
          get_wing_desc();
		 }

	 if (strcmp(fm_wing_code.arr,"!!") != 0) 
	 /*  legend[17] -- FROM WING CODE*/
	 fprintf(f1,"\t\t%-30s: %-2s %-16s\n\n",loc_legend[17],fm_wing_code.arr,t_wing_desc.arr);
     if (strcmp(fm_wing_code.arr,"!!") == 0) 
	 fprintf(f1,"\t\t%-30s: %-3s\n\n",loc_legend[17],t_wing_desc.arr);
//	 fprintf(f1,"                ");

	 if (strcmp(to_wing_code.arr,"~~") == 0)
          strcpy(t_wing_desc.arr, loc_legend[16]);
     else 
	     {
	      strcpy(t_wing_code.arr,to_wing_code.arr);
		  t_wing_code.len = strlen(t_wing_code.arr);
          get_wing_desc();
		 }

	 if (strcmp(to_wing_code.arr,"~~") != 0) 
	 /*  legend[18] -- TO WING CODE*/
	 fprintf(f1,"\t\t%-30s: %-2s %-16s\n\n",loc_legend[18], to_wing_code.arr,t_wing_desc.arr);
     if (strcmp(to_wing_code.arr,"~~") == 0) 
	 fprintf(f1,"\t\t%-30s: %-3s\n\n",loc_legend[18],t_wing_desc.arr);
//	 fprintf(f1,"                ");

	
	 
	 if (strcmp(fm_clinic_code.arr,"!!!!") == 0){
          strcpy(fm_clinic_desc.arr, loc_legend[16]);
	  }
	 else
          strcpy(fm_clinic_desc.arr, fm_clinic_code.arr);
	 /*  legend[19] -- FROM STUDY LOCATION*/
	  fprintf(f1, "\t\t%-30s: %-4s\n\n",loc_legend[19], fm_clinic_desc.arr);
//   	  fprintf(f1,"                ");


	 if (strcmp(to_clinic_code.arr,"~~~~") == 0){
          strcpy(to_clinic_desc.arr, loc_legend[16]);
	  }
	 else
          strcpy(to_clinic_desc.arr, to_clinic_code.arr);

	 /*  legend[20] -- TO STUDY LOCATION*/
	  fprintf(f1, "\t\t%-30s: %-4s\n\n",loc_legend[20], to_clinic_desc.arr);
//   	  fprintf(f1,"                ");

	 
		
	 if (strcmp(fm_section_code.arr,"!!!!") == 0)
          strcpy(t_section_desc.arr, loc_legend[16]); 
     else
	     { 
	      strcpy(t_section_code.arr,fm_section_code.arr);
  		  t_section_code.len = strlen(t_section_code.arr);
          get_section_desc(); 
		 }
			   
	 if (strcmp(fm_section_code.arr,"!!!!") != 0) 
	/*  legend[21] -- FROM SECTION CODE*/
     fprintf(f1,"\t\t%-30s: %-4s %-16s\n\n",loc_legend[21],fm_section_code.arr,t_section_desc.arr);
     if (strcmp(fm_section_code.arr,"!!!!") == 0) 
	 fprintf(f1,"\t\t%-30s: %-3s\n\n",loc_legend[21],t_section_desc.arr);
//	 fprintf(f1,"                ");

     
	 if (strcmp(to_section_code.arr,"~~~~") == 0)
          strcpy(t_section_desc.arr, loc_legend[16]); 
     else
	     { 
	      strcpy(t_section_code.arr,to_section_code.arr);
  		  t_section_code.len = strlen(t_section_code.arr);
          get_section_desc(); 
		 }
			   
	 if (strcmp(to_section_code.arr,"~~~~") != 0) 
	/*  legend[22] -- TO SECTION CODE */
     fprintf(f1,"\t\t%-30s: %-4s %-16s\n\n",loc_legend[22],to_section_code.arr,t_section_desc.arr);
     if (strcmp(to_section_code.arr,"~~~~") == 0) 
	 fprintf(f1,"\t\t%-30s: %-3s\n\n",loc_legend[22],t_section_desc.arr);
	 
	 /* legend[23] -- AGE GROUP  */
	 fprintf(f1,"\t\t%-30s: %-30s\n\n",loc_legend[23], age_group1.arr);
	 
     fprintf(f1,"\f");
  }


/* to print page headers the header details */ 
void print_page_header()
{
    int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];
	
	fprintf(f1,"MDL : RD");
	hosp_nm_len  =  h_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(f1,"%s", h_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-16);


    init_date_temp_var();
	strcpy(date_convert.arr,h_sysdate.arr);
	time_flag = 1;
    fun_change_loc_date();


	//fprintf(f1,"%s", h_sysdate.arr);  date_convert.arr
	fprintf(f1,"%s", date_convert.arr);
    
	fprintf(f1,"\n"); fprintf(f1,"OPR : %s", h_user.arr); fprintf(f1,"\n");
    
	fprintf(f1,"REP : %s",nd_pgm_id.arr);

    strcpy(v_rep_title,REP_TITLE);

	/* leged[1]  --  EXAMINATION STATISTICS */
    strcpy(v_rep_title,loc_legend[1]);

	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);
	//fprintf(f1,"%s",REP_TITLE);
	fprintf(f1,"%s",v_rep_title);

	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-10);
	fprintf(f1,"%s :%4d\n",loc_legend[2],++page_no);  
    print_line('_',REP_WIDTH);

	line_no = 5; 
}
/*------------------------------ Name Header ---------------------------------*/
void print_hdr()
  {  

     if (strcmp(summarization_level.arr,"S") == 0) 
	 {
		get_section_desc(); 
     
		/* legend[24]  --  Facility  */
		fprintf(f1,"%-15s:  %-30s \n",loc_legend[24],t_facility_desc.arr);
		/* legend[4]   --  Section   */
		fprintf(f1,"%-15s:  %-30s \n",loc_legend[4],t_section_desc.arr);

	 }

	if (strcmp(summarization_level.arr,"E") == 0) 
	 {
		get_exam_desc(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[5]  --  Exam  */
		fprintf(f1,"%-10s: %-40s \n",loc_legend[5],t_exam_desc.arr);

	 }

	 if (strcmp(summarization_level.arr,"V") == 0) 
	 {
		get_view_desc(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[6]  --  View  */
		fprintf(f1,"%-10s: %-30s \n",loc_legend[6],t_view_desc.arr);

	 }

	 if (strcmp(summarization_level.arr,"M") == 0) 
	 {
		get_exam_catg_par(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[25]  --- Main Exam Category  */
		fprintf(f1,"%-30s: %-30s \n",loc_legend[25],t_exam_catg_desc.arr);

	 }

	 if (strcmp(summarization_level.arr,"U") == 0) 
	 {
		get_exam_catg_sub(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[26]  --  Exam Category  */
		fprintf(f1,"%-25s: %-30s \n",loc_legend[26],t_exam_catg_desc.arr);

	 }

    if (strcmp(summarization_level.arr,"L") == 0) 
	 {

		get_study_location_desc(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[9]  -  Study location  */
		fprintf(f1,"%-30s: %-30s \n",loc_legend[9],t_study_location_desc.arr);


	 }


	line_no += 4;
  }

/*------------------------------ End Header ----------------------------------*/
void print_hdr_1()
  {  

     if (strcmp(summarization_level.arr,"S") == 0) 
	 {
	//	get_section_desc(); 
     
		/* legend[24]  --  Facility  */
		fprintf(f1,"%-15s:  %-30s \n",loc_legend[24],t_facility_desc.arr);
		/* legend[4]   --  Section   */
		fprintf(f1,"%-15s:  %-30s \n",loc_legend[4],t_section_desc.arr);

	 }

	if (strcmp(summarization_level.arr,"E") == 0) 
	 {
	//	get_exam_desc(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[5]  --  Exam  */
		fprintf(f1,"%-10s: %-40s \n",loc_legend[5],t_exam_desc.arr);

	 }

	 if (strcmp(summarization_level.arr,"V") == 0) 
	 {
	//	get_view_desc(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[6]  --  View  */
		fprintf(f1,"%-10s: %-30s \n",loc_legend[6],t_view_desc.arr);

	 }

	 if (strcmp(summarization_level.arr,"M") == 0) 
	 {
	//	get_exam_catg_par(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[25]  --- Main Exam Category  */
		fprintf(f1,"%-30s: %-30s \n",loc_legend[25],t_exam_catg_desc.arr);
	 }

	 if (strcmp(summarization_level.arr,"U") == 0) 
	 {
	//	get_exam_catg_sub(); 
     
		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[26]  --  Exam Category  */
		fprintf(f1,"%-25s: %-30s \n",loc_legend[26],t_exam_catg_desc.arr);

	 }

    if (strcmp(summarization_level.arr,"L") == 0) 
	 {

		fprintf(f1,"%-15s: %-30s \n",loc_legend[24],t_facility_desc.arr);
		/*  legend[9]  -  Study location  */
		fprintf(f1,"%-30s: %-30s \n",loc_legend[9],t_study_location_desc.arr);

	 }

	line_no += 4;
  }

/*------------------------------ column Header -------------------------------*/
/* print the heading */
void print_col_heading()
{
     print_line('_',REP_WIDTH);
	 fprintf(f1,"          <------ %-15s ------>    <------ %-15s ------>\n", string_age_range, string_age_range_1);
/*	 fprintf(f1,"          Local             Non-Local         Local             Non-Local \n");
	 fprintf(f1,"          Male    Female    Male    Female    Male    Female    Male    Female\n");*/

	 fprintf(f1,"%15s %21s %13s %21s        \n",loc_legend[27],loc_legend[28],loc_legend[27],loc_legend[28]);
	 fprintf(f1,"%14s %9s %7s %9s %7s %9s %7s %9s    \n",loc_legend[29],loc_legend[30],loc_legend[29],loc_legend[30],loc_legend[29],loc_legend[30],loc_legend[29],loc_legend[30]);

     print_line('_',REP_WIDTH);
	 line_no += 5;
}

    		

print_end_of_rep()
{
    fprintf(f1,"\n");
	horz_skip(23);
	/*  legend[33] -- End of Report */
	fprintf(f1,"***** %s *****",loc_legend[33]);
	fprintf(f1,"%cE",ESC); /*for resetting to default mode 26/Aug/2003 */
} 


horz_skip(num) /* this is to obtain required blank space */
int num;
{
	for(i=0;i<num;i++)fprintf(f1," ");
}

print_line(ch,n)
  char ch;
  int n;
{
 int i;
 for(i=0;i<n;i++)
 fprintf(f1,"%c",ch);  fprintf(f1,"\n");
}

/*--------------------------------- End Header -------------------------------*/

init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
date_convert.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
}


fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

get_local_date()
{


	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;

	
	BEGIN
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);

		IF :time_flag = 1 THEN
		   :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
		   :time_flag := 0;
		ELSE

	       :nd_loc_date := to_char(t_date,'DD/MM/YYYY');

		END IF;
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; IF :time_flag = 1 THEN :nd_loc_date := to_char ( t_date , 'DD/MM/Y\
YYY HH24:MI' ) ; :time_flag := 0 ; ELSE :nd_loc_date := to_char ( t_date , 'DD\
/MM/YYYY' ) ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1283;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&time_flag;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[3] = (unsigned int  )23;
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



		nd_loc_date.arr[nd_loc_date.len]='\0';		     

		if (OERROR)
		disp_message(ERR_MESG,"Date conversion failed...\n");
        //err_mesg("SELECTING Date failed",0,"");

}

fetch_legend_value()
{
	
	int i=0;
	/* EXEC SQL EXECUTE
	BEGIN	      
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDREXSTA.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDREXSTA.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1314;
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
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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





	for (i=1; i<=100; i++)
	{

	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDREXSTA.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DREXSTA.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1337;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )202;
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

	strcpy(loc_legend[i],l_translated_value.arr);

	}

}





#undef DEBUG
#undef NODATAFOUND
#undef OERROR
#undef MAX_LINES
#undef VER
