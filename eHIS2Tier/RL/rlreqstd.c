
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
           char  filnam[40];
};
static const struct sqlcxp sqlfpn =
{
    39,
    "d:\\laxman\\th\\proc\\corrected\\rlreqstd.pc"
};


static unsigned long sqlctx = 1360937957;


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
            void  *sqhstv[24];
   unsigned int   sqhstl[24];
            int   sqhsts[24];
            void  *sqindv[24];
            int   sqinds[24];
   unsigned int   sqharm[24];
   unsigned int   *sqharc[24];
   unsigned short  sqadto[24];
   unsigned short  sqtdso[24];
} sqlstm = {10,24};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,236,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,32,272,0,0,0,0,0,1,0,
51,0,0,3,120,0,6,282,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
74,0,0,4,136,0,6,293,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
97,0,0,5,115,0,4,388,0,0,4,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
128,0,0,6,0,0,17,1560,0,0,1,1,0,1,0,1,97,0,0,
147,0,0,7,0,0,32,1575,0,0,0,0,0,1,0,
162,0,0,6,0,0,45,1591,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
225,0,0,6,0,0,45,1611,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
272,0,0,6,0,0,45,1627,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
335,0,0,6,0,0,45,1647,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
414,0,0,6,0,0,45,1674,0,0,24,24,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
525,0,0,6,0,0,45,1705,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
604,0,0,6,0,0,45,1728,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
667,0,0,6,0,0,45,1748,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
746,0,0,8,0,0,32,1777,0,0,0,0,0,1,0,
761,0,0,6,0,0,15,1787,0,0,0,0,0,1,0,
776,0,0,9,0,0,32,1795,0,0,0,0,0,1,0,
791,0,0,6,0,0,13,1828,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
3,0,0,
830,0,0,6,0,0,13,1836,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
861,0,0,6,0,0,13,1845,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
896,0,0,6,0,0,13,1854,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,
939,0,0,6,0,0,13,1863,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
974,0,0,6,0,0,13,1872,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,
1017,0,0,6,0,0,13,1881,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,
1064,0,0,6,0,0,13,1890,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
3,0,0,
1103,0,0,6,0,0,13,1899,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
3,0,0,
1142,0,0,6,0,0,13,1907,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,
1189,0,0,6,0,0,13,1916,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
1240,0,0,6,0,0,13,1925,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,
1283,0,0,10,0,0,32,1960,0,0,0,0,0,1,0,
1298,0,0,11,115,0,4,1976,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1329,0,0,12,127,0,4,1994,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1360,0,0,13,97,0,4,2005,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1387,0,0,14,0,0,32,2025,0,0,0,0,0,1,0,
1402,0,0,15,100,0,4,2039,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1429,0,0,16,0,0,32,2055,0,0,0,0,0,1,0,
1444,0,0,17,95,0,4,2070,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1471,0,0,18,0,0,32,2086,0,0,0,0,0,1,0,
1486,0,0,19,81,0,4,2125,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
1513,0,0,20,67,0,4,2139,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
1536,0,0,21,79,0,4,2151,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
1559,0,0,22,81,0,4,2162,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
1586,0,0,23,118,0,4,2314,0,0,6,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,3,0,0,2,3,0,0,
2,3,0,0,
1625,0,0,24,562,0,4,2401,0,0,20,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1720,0,0,25,90,0,4,2428,0,0,3,2,0,1,0,1,3,0,0,1,3,0,0,2,9,0,0,
1747,0,0,26,90,0,4,2431,0,0,3,2,0,1,0,1,3,0,0,1,3,0,0,2,9,0,0,
1774,0,0,27,144,0,4,2434,0,0,3,2,0,1,0,1,3,0,0,1,3,0,0,2,9,0,0,
1801,0,0,28,109,0,2,2473,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1824,0,0,29,0,0,32,2481,0,0,0,0,0,1,0,
1839,0,0,30,158,0,4,2509,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1874,0,0,31,0,0,32,2533,0,0,0,0,0,1,0,
1889,0,0,32,121,0,6,2680,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1916,0,0,33,121,0,6,2698,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1943,0,0,34,100,0,6,2793,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
1966,0,0,35,419,0,6,2826,0,0,5,5,0,1,0,3,9,0,0,1,9,0,0,1,9,0,0,3,9,0,0,1,9,0,0,
2001,0,0,36,78,0,4,2883,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
2024,0,0,37,78,0,4,2886,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
2047,0,0,38,80,0,4,2889,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
2070,0,0,39,81,0,4,2897,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
2097,0,0,40,79,0,4,2916,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
2120,0,0,41,78,0,4,2921,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
2143,0,0,42,78,0,4,2924,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
2166,0,0,43,80,0,4,2927,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
2189,0,0,44,81,0,4,2936,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
2216,0,0,45,101,0,6,2986,0,0,1,1,0,1,0,2,3,0,0,
2235,0,0,46,49,0,4,2999,0,0,1,0,0,1,0,2,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: rlreqstd.pc
   Author : S.Sheelvant 
   Date Created  : 20/08/1998
   Last Modified : 22/08/1998
   Last Modified : 04/09/2003 (ordered_facility_id)
   Last Modified : 20/01/2004 (OTHER COMBINATIONS OF WORKGROUP AND Urgency indicators)

   Modified by   : Hameed

*  Ver 1.10.01
   
*  Purpose : To generate a report for Request Statistics of Test Codes

*  Input Parameters : 
              Command line inputs 
	
		      1. Usr_id/Password
              2. Session id
		      3. Program Date
                 Parameters from SY_PROG_PARAM table 
              4. Preferred range of Section Codes.
  
*  Table Accessed : RL_REQUEST_HEADER,RL_REQUEST_DETAIL,
					RL_SECTION_CODE, RL_TEST_CODE,
					OP_CLINIC, IP_WARD, RL_REFERRAL
		    

*  Output File : rlreqstd.lis
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <rl.h>

#define MAX_LINES 45
//#define MAX_LINES 40
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ESC 0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 

/* INPUT PARAMETERS TO MAIN */

	/* VARCHAR  
	    nd_operating_facility_id   [3],
	    uid_pwd		               [91],
		nd_user_id                 [21],
		nd_session_id              [16],
		nd_pgm_date	               [20], 
		nd_user	                   [15],
        nd_file_no                 [15],
		nd_file_name			   [150],
		d_version_no			   [20],
		d_version  			       [20]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[21]; } nd_user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;


/****************************/
/* FIELDS from CURSOR SECTION CURSOR */
	/* varchar d_section_code	[2] , 
		    d_section_name  [41] ; */ 
struct { unsigned short len; unsigned char arr[2]; } d_section_code;

struct { unsigned short len; unsigned char arr[41]; } d_section_name;


	int specimen_prefix = 0;

/* FIELDS from CURSOR TEST CURSOR */
	/* varchar d_test_code [11] ,
			d_workgroup_code [11] ,
			rl_ordered_facility_id	[3],
		    d_test_name [41],
			d_workgroup_name [41],
			d_urgent_ind_desc [10]; */ 
struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_workgroup_code;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_test_name;

struct { unsigned short len; unsigned char arr[41]; } d_workgroup_name;

struct { unsigned short len; unsigned char arr[10]; } d_urgent_ind_desc;
			
	
/* FIELDS for FETCHING SOURCE CURSOR */
	/* varchar d_source_code [7] ,
			d_source_name [41],
			d_source_type  [2] ; */ 
struct { unsigned short len; unsigned char arr[7]; } d_source_code;

struct { unsigned short len; unsigned char arr[41]; } d_source_name;

struct { unsigned short len; unsigned char arr[2]; } d_source_type;

			

/* FIELDS for GET TEST_GROUP DETAILS */
	long count_test ;
	long total_records;
	
/* Fields from table RL_SECTION_CODE */
	 /* varchar      d_printer_name            [16]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_printer_name;


/* Fields from table SY_ACC_ENTITY*/
	/* varchar 	//d_acc_entity_name        [61],
				d_acc_entity_name        [300],
				d_user                   [21],
				d_sysdate                [17],	
				d_sysdate1               [17]; */ 
struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;
	
				
	/* varchar	l_translated_value		[500], // added for globalisation
				language_id				[5]; */ 
struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;
  // added for globalisation

	 int        i;                            // added for globalisation
	 int        rec_len;                     //added for globalisation

	 

/**********************************************/
 /*INPUT PARAMETERS FROM SY_PROG_PARAM TABLE */
	/* varchar nd_fm_section_code			[2],
			nd_to_section_code			[2],
			nd_type						[2],
			nd_fm_source_type			[7],
			nd_to_source_type			[7],
			nd_print_yn					[6],
			nd_rc_source				[7],
			nd_rc_period				[2],	
			nd_rc_wrk_test				[3],
			nd_fm_wrkgrp_test			[11],
			nd_to_wrkgrp_test			[11],
			nd_rc_urgent_ind			[10],
			nd_include_test             [2],
			nd_clinic_grp_yn			[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_fm_section_code;

struct { unsigned short len; unsigned char arr[2]; } nd_to_section_code;

struct { unsigned short len; unsigned char arr[2]; } nd_type;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_source_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_source_type;

struct { unsigned short len; unsigned char arr[6]; } nd_print_yn;

struct { unsigned short len; unsigned char arr[7]; } nd_rc_source;

struct { unsigned short len; unsigned char arr[2]; } nd_rc_period;

struct { unsigned short len; unsigned char arr[3]; } nd_rc_wrk_test;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_wrkgrp_test;

struct { unsigned short len; unsigned char arr[11]; } nd_to_wrkgrp_test;

struct { unsigned short len; unsigned char arr[10]; } nd_rc_urgent_ind;

struct { unsigned short len; unsigned char arr[2]; } nd_include_test;

struct { unsigned short len; unsigned char arr[2]; } nd_clinic_grp_yn;


						

	int 	nd_fm_month ,
			nd_fm_year ,
			nd_to_month ,
			nd_to_year ;

	int		m_month,
			m_date,
			m_year,
			a_month,
			a_date,
			a_year,
			t_month,
			t_date,
			t_year;

/* FIELDS from DECLARING VARIABLES(COLUMN HEADINGS) IN DCLR_MONTH_VARIABLES()*/
	/* varchar x_date		[30] ,
			v_date		[30],
			v_date1     [30],   // added for globalisation
			w_date		[30],
			w_date1     [30],   // added for globalisation
			q_date		[30]; */ 
struct { unsigned short len; unsigned char arr[30]; } x_date;

struct { unsigned short len; unsigned char arr[30]; } v_date;

struct { unsigned short len; unsigned char arr[30]; } v_date1;

struct { unsigned short len; unsigned char arr[30]; } w_date;

struct { unsigned short len; unsigned char arr[30]; } w_date1;

struct { unsigned short len; unsigned char arr[30]; } q_date;


	/* varchar h_head		[8]; */ 
struct { unsigned short len; unsigned char arr[8]; } h_head;


	/* varchar d_spec_date [30]; */ 
struct { unsigned short len; unsigned char arr[30]; } d_spec_date;


	int date1[31];
	int month[14];
	int year[14];
    long mnth_yr[31]; 
	long dpt_mnth_yr[31];
	int j_date,j_month, j_year;

	int  l_tab_exists ;

	char            sql_stmt[7000];
	char            select_sql_stmt[5000];
	char            from_sql_stmt[5000];
	char            where_sql_stmt[5000];
	char            group_sql_stmt[5000];
	char            order_sql_stmt[5000];

	char            select_sql_stmt1[5000];
	char            from_sql_stmt1[5000];
	char            where_sql_stmt1[5000];
	char            group_sql_stmt1[5000];
	char            order_sql_stmt1[5000];
    int end_pgm_control = 0;
	int l_first_page    = 1;
     
	/* VARCHAR l_page_head_month   [10],
			l_page_head_year    [10],
			
			l_page_head_month1  [10],   // added on 01/04/2008 for globalisation
			l_page_head_year1   [10]; */ 
struct { unsigned short len; unsigned char arr[10]; } l_page_head_month;

struct { unsigned short len; unsigned char arr[10]; } l_page_head_year;

struct { unsigned short len; unsigned char arr[10]; } l_page_head_month1;

struct { unsigned short len; unsigned char arr[10]; } l_page_head_year1;
	// added on 01/04/2008 for globalisation

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
 
char string_var[5000] ;


/************************************************/
int line_no = 0;
int page_no = 0 ;
long total_count = 0;
long g_total_count = 0;
long s_total_count = 0;
long d_total_count = 0;
int mon_incr = 0;
int tot_incr = 0;

FILE *f1;


char local_legend[40][600]; // added for globalisation
char g_facility_id[50];

void proc_main(argc, argv)
int argc;
char *argv[];
{
   void get_params();
   void get_header_dtls();
   void gen_file_name();
   void do_report();
   void do_footer();     // 26.04.2003

   int fetch_test_cur();
   
   if(argc < 4) {
     disp_message(ORA_MESG,"Usage rlreqstd uid/passwd session_id pgm_date\n");
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )30;
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

  

   if(OERROR)
      disp_message(ORA_MESG,"Failed to connect using : \n");

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

	get_header_dtls();
	gen_file_name(); 
	initialize_array();	

	do_report();
	
	//do_footer();  // 26.04.2003 for jordan scf 57
     fprintf(f1,"%cE",ESC);	

	 fclose(f1);
	
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
   sqlstm.offset = (unsigned int  )36;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();	
	
}	

/******** added for globalisation start ******************/

get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND(:nd_operating_facility_id,:language_id,'RLREQSTD.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLREQSTD.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
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
               :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RLREQSTD.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLREQSTD.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )74;
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


void do_report()
{	
    int fetch_section_cur();
	void dclr_source_cur();	
	void dclr_test_cur();
	void open_test_cur();
	void close_test_cur();	
	void chk_break(int lin_no);	
	void get_source_name();
	void get_section_name();
	void get_test_name();
	void print_dtl_record();
	void print_rep_header();
	void print_page_header();
	void print_total_count();
	void print_dept_col_heading();
	void print_source_col_heading();	
	void print_indicator_col_heading();	
	void print_workgroup_col_heading();
	
	char temp_source_name[5];
	char temp_section_name[2];
	char temp_indicator_name[5];
	char temp_workgroup_name[5];
	char temp_test_name[11];
	char flag_1 = 'N';
	char flag_2 = 'N';
	char flag_3 = 'N';
	char flag_4 = 'N';
	char flag_5 = 'N';
	char f_section = 'N';
	char f_source = 'N';
	char f_indicator = 'N';
	char f_workgroup = 'N';
	char first_time = 'Y';	

	int i =0;
	int j =0;
	strcpy(temp_source_name, " ");
	strcpy(temp_section_name, " ");
	strcpy(temp_indicator_name, " ");
	strcpy(temp_workgroup_name, " ");
	strcpy(temp_test_name, " ");

	line_no = 0;
    page_no = 0;

    dclr_test_cur();
	
	open_test_cur();		
					
    while(fetch_test_cur())
	{
	  get_source_name();
	  get_test_name();
	  get_section_name();

	  if(flag_3 == 'N')
		flag_3 = 'Y';

	  /***********Compare section codes******************/
	  if(strcmp(temp_section_name, d_section_code.arr) != 0)
	  {
		  strcpy(temp_section_name, d_section_code.arr);
		  //strcpy(temp_source_name, d_source_code.arr);
		  strcpy(temp_source_name, " ");
		  strcpy(temp_indicator_name, " ");
		  strcpy(temp_test_name, " ");
		  strcpy(temp_workgroup_name, " ");

		  if(flag_1 == 'N')
		  {
			 flag_1 = 'Y';
			 print_rep_header();
             l_page_head_month.arr[0] = '\0';
			 l_page_head_month.len = 0;
             l_page_head_year.arr[0] = '\0';
			 l_page_head_year.len = 0;
			 /* EXEC SQL SELECT TO_CHAR(TO_DATE(:v_date,'DD/MM/YYYY'),'MON'),
							 TO_CHAR(TO_DATE(:v_date,'DD/MM/YYYY'),'YYYY')
			            INTO :l_page_head_month,:l_page_head_year 
					    FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'MON') ,TO_CHAR(\
TO_DATE(:b0,'DD/MM/YYYY'),'YYYY') into :b2,:b3  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )97;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&v_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&v_date;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_page_head_month;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_page_head_year;
    sqlstm.sqhstl[3] = (unsigned int  )12;
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


			 l_page_head_month.arr[l_page_head_month.len] = '\0';
			 l_page_head_year.arr[l_page_head_year.len] = '\0';
			 print_page_header();
			 print_month_col_heading();
		  }
		  f_section = 'Y';	  
	  }
	    /***********Compare source codes******************/
	  if(strcmp(nd_rc_source.arr,"Y") == 0) 
	  {
		if(strcmp(temp_source_name, d_source_code.arr) != 0)
		{
		  strcpy(temp_source_name, d_source_code.arr);
		  strcpy(temp_indicator_name, " ");
		  strcpy(temp_test_name, " ");
		  strcpy(temp_workgroup_name, " ");
		  f_source = 'Y';
		}
	  }
	  /***********Compare indicator codes******************/
	  if(strcmp(nd_rc_urgent_ind.arr,"Y") == 0) 
	 {
	    if(strcmp(temp_indicator_name, d_urgent_ind_desc.arr) != 0)
	  {
		  strcpy(temp_indicator_name, d_urgent_ind_desc.arr);
		  strcpy(temp_workgroup_name, " ");
		  strcpy(temp_test_name, " ");
		  f_indicator = 'Y';
	  }
	}
	 /***********Compare workgroup codes******************/
	  if(strcmp(nd_rc_wrk_test.arr,"WD") == 0)
	  {
		if(strcmp(temp_workgroup_name, d_workgroup_code.arr) != 0)
		{
		  strcpy(temp_workgroup_name, d_workgroup_code.arr);
		  //strcpy(temp_workgroup_name, " ");
		  strcpy(temp_test_name, " ");		  
		  f_workgroup = 'Y';		  
		}
	  }

	/********* Workgroup summary********************/
	if(strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
	{
	   if(strcmp(temp_workgroup_name, d_workgroup_code.arr) != 0)		
	  {
	  	 strcpy(temp_workgroup_name, d_workgroup_code.arr);
 		  if(flag_4 == 'Y')
		  {
			chk_break(3);
			print_total_count();
		  }
		  else
		  	 flag_4 = 'Y';			   
		 if( f_source != 'Y' && f_section != 'Y' && f_indicator != 'Y')
		 {
    	   first_time = 'N';		   
		   print_workgroup();
		 }
	  }	 	 	 
	}
	
		
	/***********Compare Individual test codes******************/	
	if(strcmp(nd_rc_wrk_test.arr,"T") == 0) 
	{
	  if(strcmp(temp_test_name, d_test_code.arr) != 0)
	  {
		 strcpy(temp_test_name, d_test_code.arr);	 

 		  if(flag_2 == 'Y')
		  {	  
		   chk_break(3);
		   print_total_count();
		  }
		  else
		  	 flag_2 = 'Y';		 
		 if( f_source != 'Y' && f_section != 'Y' && f_indicator != 'Y')
		 {		 
    	   first_time = 'N';		   
		   print_tests();
		 }
	   }	   
	 }	  	
	 
	 /********* Workgroup Detail********************/
	if(strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
	{	
	  if((strcmp(temp_test_name, d_test_code.arr) != 0) 
		|| (strcmp(temp_workgroup_name, d_workgroup_code.arr) != 0) || f_workgroup == 'Y') 
	  {
		if(strcmp(temp_test_name, d_test_code.arr) != 0) 
			//first_time = 'Y';
		{
		 strcpy(temp_test_name, d_test_code.arr);
 		  if(flag_5 == 'Y')
		  {
		   chk_break(3);
		   print_total_count();
		  }
		  else
		  	 flag_5 = 'Y';
		
			if( f_source != 'Y' && f_section != 'Y' && f_workgroup != 'Y' && f_indicator != 'Y')
			{		 
    			first_time = 'N';		   
				print_tests();
			}
		
		}	  
	   }
	 }	  	
	  

		/********************** PRINT HEADINGS ********************************/
	  if(f_section == 'Y')
	  {
		  if(first_time == 'N')
		  {		  
		    if(strcmp(nd_rc_source.arr,"Y") == 0) 
		    {			
		     print_source_total();		  
		    }			
		  print_department_total();
		  }
		  	 			
		  f_section = 'N';
		  first_time = 'Y';		  			  
		  print_dept_col_heading();	  

		  chk_break(3);	
		  if(strcmp(nd_rc_source.arr,"Y") == 0)  
			{
			f_source = 'N';
			first_time = 'Y';			
			print_source_col_heading();
			}
		 if(strcmp(nd_rc_wrk_test.arr,"WD") == 0)
			{ 		
			f_workgroup = 'N';
			first_time = 'Y';			
			print_workgroup_col_heading();
			}				
	      if(strcmp(nd_rc_urgent_ind.arr,"Y") == 0)  				
			{

			f_indicator = 'N';
			first_time = 'Y';			
			print_indicator_col_heading();			
			}
	  }
	  else if(f_source == 'Y')
	  {
	  	 f_source = 'N';
		 first_time = 'Y';
		 chk_break(3);
		 if(strcmp(nd_rc_source.arr,"Y") == 0)  
			{			
			print_source_total();
			print_source_col_heading();

		 if(strcmp(nd_rc_wrk_test.arr,"WD") == 0)
			{
			f_workgroup = 'N';
			first_time = 'Y';			
			 print_workgroup_col_heading();			  
			}
		 if(strcmp(nd_rc_urgent_ind.arr,"Y") == 0)
			{
			f_indicator = 'N';
			first_time = 'Y';			
			print_indicator_col_heading();			
			}
		}	
	  }
	    
	  else if(f_indicator == 'Y')
	  {	  
		 f_indicator = 'N';
		 first_time = 'Y';
		 chk_break(3);

		 if(strcmp(nd_rc_wrk_test.arr,"WD") == 0)
			{ 
			f_workgroup = 'N';
			first_time = 'Y';			
			print_workgroup_col_heading();
			}
		 if(strcmp(nd_rc_urgent_ind.arr,"Y") == 0)  
			{			
			print_indicator_col_heading();
			}		  
	  }	
	 else if(f_workgroup == 'Y')
	  {
		 f_workgroup = 'N';
		 first_time = 'Y';
		 chk_break(3);
		 if(strcmp(nd_rc_wrk_test.arr,"WD") == 0)  
			{
			print_workgroup_col_heading();
			}
		}
	 	
	/********* Print Workgroup summary******************/

	if(strcmp(nd_rc_wrk_test.arr,"WS") == 0)
		{
		 if(f_source == 'Y' || f_section == 'Y' || f_indicator == 'Y'|| first_time == 'Y')
		 {
		   first_time = 'N';		   
		   print_workgroup();
		 }
		}
		/*********Print Individual tests******************/

	else if (strcmp(nd_rc_wrk_test.arr,"T") == 0)
	  {
		 if(f_source == 'Y' || f_section == 'Y' || f_indicator == 'Y'|| first_time == 'Y')
		 {					
		   first_time = 'N';
		   print_tests();

		 }
	  }

		/********* Print Workgroup Detail******************/

	else if(strcmp(nd_rc_wrk_test.arr,"WD") == 0)
		{
		 if(f_source == 'Y' ||f_section == 'Y' ||f_workgroup == 'Y' ||f_indicator == 'Y' ||first_time == 'Y')
		 {
		   first_time = 'N';		
		   print_tests();
		 }
		}


	/*********************print detail record******************/
	  print_dtl_record();
	}	

	/*************fetch from cursor over*****************/
	if (mon_incr != 0)
	{
	for(i = mon_incr; i < tot_incr; i++)
	//fprintf(f1, "        ");		
	//fprintf(f1, "%6d", total_count);			
	//fprintf(f1, "    ");
	fprintf(f1, "  . "); /********For printing dots for blank spaces**********/
	fprintf(f1, "%5d", total_count);		
    fprintf(f1, "\n");
	line_no += 1;
    chk_break(3);
	}

	if(flag_3 == 'N')
	{
		 print_rep_header();
		 print_page_header();
		 print_month_col_heading();
		 
    }	
	if(strcmp(nd_rc_source.arr,"Y") == 0)  
	{
	print_source_total();			
	}
	print_department_total();
	
	close_test_cur();
}  

/*************** DECLARE TEST CURSOR ***************/
void dclr_test_cur()
 {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


    /*
	EXEC SQL DECLARE TEST_CURSOR CURSOR FOR
			SELECT A.section_code, A.source_type, 
				   A.source_code,  B.test_code, 
				   TO_CHAR(A.spec_regd_date_time, 'MM/YYYY'), count(*)
			FROM RL_REQUEST_HEADER A, RL_REQUEST_DETAIL B
			WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type)
			AND A.source_code BETWEEN :nd_fm_source_type
			AND :nd_to_source_type
			AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY')
			AND A.spec_regd_date_time <= TO_DATE(:w_date,'DD/MM/YYYY') + 1
			AND A.specimen_no = B.specimen_no 
			AND A.section_code BETWEEN :nd_fm_section_code 
			AND :nd_to_section_code   
			AND NVL(A.cancelled_yn,'N') != 'Y' 
			GROUP BY A.section_code, A.source_type, 
					 A.source_code, B.test_code,
					 TO_CHAR(A.spec_regd_date_time, 'MM/YYYY')
			ORDER BY A.section_code, A.source_type, 
					 A.source_code, B.test_code,
					 TO_CHAR(A.spec_regd_date_time, 'MM/YYYY');
	*/

	/********** SELECT ************************/

   if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, A.source_type as source_type, \
					   A.source_code as source_code,  B.test_code as test_code, \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, B.test_code as test_code, \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time,count(*) ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, B.test_code as test_code, \
					DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent') as urgent_indicator, \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  "); */
			  strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, B.test_code as test_code, \
					A.urgent_indicator as urgent_indicator, \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, A.source_type as source_type, \
					   A.source_code as source_code, \
					   DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent') as urgent_indicator, \
					   B.test_code as test_code, \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  "); */
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, A.source_type as source_type, \
					   A.source_code as source_code, \
					   A.urgent_indicator as urgent_indicator, \
					   B.test_code as test_code, \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N") == 0))
   			{
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code,C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  "); */
			// commented and changed on 31/03/2008 against ML-SD-SCF-2270
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code,C.outst_work_group_code as outst_work_group_code, C.short_desc as short_desc, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N") == 0))
   			{
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, A.source_type as source_type, A.source_code as source_code, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");*/
			//commented and changed on 31/03/2008 against ML-SD-SCF-2270
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, A.source_type as source_type, A.source_code as source_code, \
				  C.outst_work_group_code as outst_work_group_code, C.short_desc as short_desc, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y") == 0))
   			{
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, A.source_type as source_type, A.source_code as source_code, \
				  DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent') as urgent_indicator, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");*/
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, A.source_type as source_type, A.source_code as source_code, \
				  A.urgent_indicator as urgent_indicator, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");*/
			//commented anc changed on 31/03/2008 against ML-SD-SCF-2270
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, A.source_type as source_type, A.source_code as source_code, \
				  A.urgent_indicator as urgent_indicator, \
				  C.outst_work_group_code as outst_work_group_code, C.short_desc as short_desc, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y") == 0))
   			{
			
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent') as urgent_indicator, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");*/
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  A.urgent_indicator as urgent_indicator, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");*/
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, \
				  C.outst_work_group_code as outst_work_group_code, C.short_desc as short_desc, \
				  A.urgent_indicator as urgent_indicator, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}

	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N") == 0))
   			{
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code,C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  B.test_code as test_code, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N") == 0))
   			{
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code,A.source_type as source_type,A.source_code as source_code, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  B.test_code as test_code, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y") == 0))
   			{
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code,A.source_type as source_type,A.source_code as source_code, \
				  DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent') as urgent_indicator, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  B.test_code as test_code, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  "); */
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code,A.source_type as source_type,A.source_code as source_code, \
				  A.urgent_indicator as urgent_indicator, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  B.test_code as test_code, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y") == 0))
   			{
			/*strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, \
				  DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent') as urgent_indicator, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  B.test_code as test_code, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");*/
			strcpy(select_sql_stmt,
				" SELECT A.section_code as section_code, \
				  A.urgent_indicator as urgent_indicator, \
				  C.outst_work_group_code as outst_work_group_code, C.long_desc as long_desc, \
				  B.test_code as test_code, \
				  TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') as spec_regd_date_time, count(*)  ");
			}

	/********** FROM ************************/

    if(((strcmp(nd_rc_source.arr,"Y") == 0) || (strcmp(nd_rc_source.arr,"N") == 0)) 
		 && (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		 && ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
			{	
			strcpy(from_sql_stmt,"FROM RL_REQUEST_HEADER A, RL_REQUEST_DETAIL B ");
			}	

	else if(((strcmp(nd_rc_source.arr,"N") == 0) || (strcmp(nd_rc_source.arr,"Y") == 0))
		&& ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0))
		&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
   			{
			strcpy(from_sql_stmt,"FROM RL_REQUEST_HEADER A, RL_REQUEST_DETAIL B , \
					RL_OUTST_WORK_GROUP C, RL_OUTST_WORK_GROUP_DTL D ");
			}

	/** FROM clause Added for condition to get the Combination of 
	    Group and Individual Tests 
	 **/

    if(((strcmp(nd_rc_source.arr,"Y") == 0) || (strcmp(nd_rc_source.arr,"N") == 0)) 
		 && (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		 && ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
			{	
			strcpy(from_sql_stmt1,"FROM RL_REQUEST_HEADER A, RL_TEST_RESULT B ");
			}	

	else if(((strcmp(nd_rc_source.arr,"N") == 0) || (strcmp(nd_rc_source.arr,"Y") == 0))
		&& ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0))
		&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
   			{
			strcpy(from_sql_stmt1,"FROM RL_REQUEST_HEADER A, RL_TEST_RESULT B , \
					RL_OUTST_WORK_GROUP_lang_vw C, RL_OUTST_WORK_GROUP_DTL D ");
			}

	/********** WHERE ************************/
			
	if((strcmp(nd_rc_source.arr,"Y") == 0) && (strcmp(nd_include_test.arr, "O") == 0)
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
			{	
			 if (strcmp(nd_clinic_grp_yn.arr,"N") == 0)
			 {
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
						AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type) \
					AND A.source_code BETWEEN :nd_fm_source_type AND :nd_to_source_type \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}
			else
			{
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
						AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type) \
					AND A.source_code IN (SELECT clinic_code FROM OP_CLINIC \
					    WHERE clinic_grp_code in (:nd_fm_source_type,:nd_to_source_type) ) \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}
			}	
	if((strcmp(nd_rc_source.arr,"Y") == 0) && (strcmp(nd_include_test.arr, "A") == 0)
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
			{	
			 if (strcmp(nd_clinic_grp_yn.arr,"N") == 0)
			 {
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
						AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type) \
					AND A.source_code BETWEEN :nd_fm_source_type AND :nd_to_source_type \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND NVL(B.group_test_yn, 'N') = 'Y' \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}	
			else
			{
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
						AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type) \
					AND A.source_code IN (SELECT clinic_code FROM OP_CLINIC \
					    WHERE clinic_grp_code in (:nd_fm_source_type,:nd_to_source_type) ) \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND NVL(B.group_test_yn, 'N') = 'Y' \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) && (strcmp(nd_include_test.arr, "O") == 0)
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
			{	
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) && (strcmp(nd_include_test.arr, "A") == 0)
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
			{	
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND NVL(B.group_test_yn, 'N') = 'Y' \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0))
		&& ((strcmp(nd_rc_urgent_ind.arr,"N") == 0) || (strcmp(nd_rc_urgent_ind.arr,"Y") == 0)))
   			{
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND C.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND D.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.OPERATING_FACILITY_ID = C.operating_facility_id \
					AND A.OPERATING_FACILITY_ID = D.operating_facility_id \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code = C.section_code \
					AND A.section_code BETWEEN :nd_fm_section_code	AND :nd_to_section_code \
					AND C.outst_work_group_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND C.outst_work_group_code = D.outst_work_group_code \
					AND B.group_test_code = DECODE(:nd_include_test, 'A', B.group_test_code, B.test_code) \
					AND B.test_code = D.test_code \
					AND C.language_id = :language_id \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
					
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0)) 
		&& ((strcmp(nd_rc_urgent_ind.arr,"N") == 0) || (strcmp(nd_rc_urgent_ind.arr,"Y") == 0)))
   			{
			 if (strcmp(nd_clinic_grp_yn.arr,"N") == 0)
			 {
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND C.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND D.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.OPERATING_FACILITY_ID = C.operating_facility_id \
					AND A.OPERATING_FACILITY_ID = D.operating_facility_id \
					AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type) \
					AND A.source_code BETWEEN :nd_fm_source_type AND :nd_to_source_type \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code = C.section_code \
					AND A.section_code BETWEEN :nd_fm_section_code	AND :nd_to_section_code \
					AND C.outst_work_group_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND C.outst_work_group_code = D.outst_work_group_code \
					AND B.group_test_code = DECODE(:nd_include_test, 'A', B.group_test_code, B.test_code) \
					AND B.test_code = D.test_code \
					AND C.language_id = :language_id \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}
			else
			{
			strcpy(where_sql_stmt,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND C.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND D.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.OPERATING_FACILITY_ID = C.operating_facility_id \
					AND A.OPERATING_FACILITY_ID = D.operating_facility_id \
					AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type) \
					AND A.source_code IN (SELECT clinic_code FROM OP_CLINIC \
					    WHERE clinic_grp_code in (:nd_fm_source_type,:nd_to_source_type) ) \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code = C.section_code \
					AND A.section_code BETWEEN :nd_fm_section_code	AND :nd_to_section_code \
					AND C.outst_work_group_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND C.outst_work_group_code = D.outst_work_group_code \
					AND B.group_test_code = DECODE(:nd_include_test, 'A', B.group_test_code, B.test_code) \
					AND B.test_code = D.test_code \
					AND C.language_id = :language_id \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}
			}
	/** WHERE Clause Added for condition to get the combination of 
	    Group and Individual Test 
	 **/

	if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
			{	
			 if (strcmp(nd_clinic_grp_yn.arr,"N") == 0)
			 {
			strcpy(where_sql_stmt1,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type) \
					AND A.source_code BETWEEN :nd_fm_source_type AND :nd_to_source_type \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}	
			else
			{
			strcpy(where_sql_stmt1,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E', :nd_type) \
					AND A.source_code IN (SELECT clinic_code FROM OP_CLINIC \
					    WHERE clinic_grp_code in (:nd_fm_source_type,:nd_to_source_type) ) \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
			{
			strcpy(where_sql_stmt1,"WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
					AND A.OPERATING_FACILITY_ID = B.operating_facility_id \
					AND A.spec_regd_date_time >= TO_DATE(:v_date,'DD/MM/YYYY') \
					AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYY') + 1 \
					AND A.specimen_no = B.specimen_no \
					AND A.section_code BETWEEN :nd_fm_section_code AND :nd_to_section_code \
					AND B.test_code BETWEEN :nd_fm_wrkgrp_test AND :nd_to_wrkgrp_test \
					AND NVL(A.cancelled_yn,'N') != 'Y' ");
			}


	/********** GROUP BY ************************/

	if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
			{		
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code, A.source_type, \
					 A.source_code, B.test_code, \
					 TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");	
			}		

	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
			{		
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code,B.test_code, \
					 TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");	
			}		

	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
			{		
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code,B.test_code, \
					 DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
					 TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
					 strcpy(group_sql_stmt,
			" GROUP BY A.section_code,B.test_code, \
					 urgent_indicator, \
					 TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}		
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
			{		
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
			DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
			B.test_code, TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
			urgent_indicator, \
			B.test_code, TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
					
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code,C.outst_work_group_code,C.long_desc, \
			TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
			//commented and changed on 31/03/2008 against ML-SD-SCF-2270
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code,C.outst_work_group_code,C.short_desc, \
			TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
				C.outst_work_group_code,C.long_desc, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
			//commented and changed on 31/03/2008 against ML-SD-SCF-2270
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
				C.outst_work_group_code,C.short_desc, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
				DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
				C.outst_work_group_code,C.long_desc, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
				urgent_indicator, \
				C.outst_work_group_code,C.long_desc, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
			//commented and changed on 31/03/2008 against ML-SD-SCF-2270
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
				urgent_indicator, \
				C.outst_work_group_code,C.short_desc, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code, \
				DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
				C.outst_work_group_code,C.long_desc, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') "); */
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code, \
				urgent_indicator, \
				C.outst_work_group_code,C.long_desc, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
			//commented anc changed on 31/03/2008 against ML-SD-SCF-2270
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code, \
				urgent_indicator, \
				C.outst_work_group_code,C.short_desc, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}

	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code,C.outst_work_group_code,C.long_desc, \
			B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
			C.outst_work_group_code,C.long_desc, \
			B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}			
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
			DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
			C.outst_work_group_code,C.long_desc, \
			B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code,A.source_type,A.source_code, \
			urgent_indicator, \
			C.outst_work_group_code,C.long_desc, \
			B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/*strcpy(group_sql_stmt,
			" GROUP BY A.section_code, \
			DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
			C.outst_work_group_code,C.long_desc, \
			B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");*/
			strcpy(group_sql_stmt,
			" GROUP BY A.section_code, \
			urgent_indicator, \
			C.outst_work_group_code,C.long_desc, \
			B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}

	/********** ORDER BY ************************/

	if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, source_type, \
						 source_code, test_code, \
						 spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code,test_code, \
						 spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, \
				  urgent_indicator,test_code, \
				  spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
			{	
			strcpy(order_sql_stmt,
				" ORDER BY section_code, source_type, source_code, \
						   urgent_indicator, \
						   test_code, spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, outst_work_group_code, \
				spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, source_type, source_code, \
					outst_work_group_code, \
					spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, source_type, source_code, \
					outst_work_group_code, \
					urgent_indicator, \
					spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code,  \
					outst_work_group_code, \
					urgent_indicator, \
					spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, outst_work_group_code, long_desc,  \
				  test_code,spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, source_type,source_code, \
				  outst_work_group_code, \
				  test_code,spec_regd_date_time ");
			}			
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, source_type,source_code, \
				  outst_work_group_code, \
				  urgent_indicator, \
				  test_code, spec_regd_date_time ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY section_code, \
				  outst_work_group_code, \
				  urgent_indicator, \
				  test_code,spec_regd_date_time ");
			}
	
	/**
	if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
			{	
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, A.source_type, \
						 A.source_code, B.test_code, \
						 TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
			{	
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code,B.test_code, \
						 TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}		
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
			{	
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, \
				DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'),B.test_code, \
						 TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}		
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
			{	
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, A.source_type, A.source_code, \
						 DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
						 B.test_code, TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, C.outst_work_group_code, \
				TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, A.source_type, A.source_code, \
					C.outst_work_group_code, \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, A.source_type, A.source_code, \
					C.outst_work_group_code, \
					DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code,  \
					C.outst_work_group_code, \
					DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
					TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, C.outst_work_group_code, C.long_desc  \
				B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, A.source_type,A.source_code, \
				C.outst_work_group_code, \
				B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}			
	else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, A.source_type,A.source_code, \
				C.outst_work_group_code, \
				DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
				B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			strcpy(order_sql_stmt,
				" ORDER BY A.section_code, \
				C.outst_work_group_code, \
				DECODE(A.urgent_indicator,'R','Routine','S','Stat','U','Urgent'), \
				B.test_code,TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY') ");
			}
	**/

	/********** COMPLETE SQL STATEMENT ************************/					 	

	if ((strcmp(nd_include_test.arr, "O") == 0) && (strcmp(nd_rc_wrk_test.arr,"T") == 0))
	{
		strcat(sql_stmt,select_sql_stmt);	
		strcat(sql_stmt,from_sql_stmt);	
		strcat(sql_stmt,where_sql_stmt);
		strcat(sql_stmt,group_sql_stmt);
		strcat(sql_stmt,order_sql_stmt);
	}
	else if ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0))
	{
		strcat(sql_stmt,select_sql_stmt);
		strcat(sql_stmt,from_sql_stmt1);	
		strcat(sql_stmt,where_sql_stmt);
		strcat(sql_stmt,group_sql_stmt);
		strcat(sql_stmt,order_sql_stmt);
	}
	else if ((strcmp(nd_include_test.arr, "A") == 0) && (strcmp(nd_rc_wrk_test.arr,"T") == 0))
	{
		strcat(sql_stmt,select_sql_stmt);
		strcat(sql_stmt,from_sql_stmt);	
		strcat(sql_stmt,where_sql_stmt);
		strcat(sql_stmt,group_sql_stmt);
		strcat(sql_stmt,"UNION ");
		strcat(sql_stmt,select_sql_stmt);
		strcat(sql_stmt,from_sql_stmt1);
		strcat(sql_stmt,where_sql_stmt1);
		strcat(sql_stmt,group_sql_stmt);
		strcat(sql_stmt,order_sql_stmt);
	}

/*
	sprintf(string_var," %s\n",sql_stmt);
	disp_message(ERR_MESG,string_var);
*/
	/* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )128;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)sql_stmt;
 sqlstm.sqhstl[0] = (unsigned int  )7000;
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



	/* EXEC SQL DECLARE TEST_CURSOR CURSOR FOR S; */ 


    return;

	 //EXEC SQL OPEN test_cursor;
	
#ifdef DEBUG
    printf("leaving dclr_test_cur()\n");
    fflush(stdout);
#endif
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
   sqlstm.offset = (unsigned int  )147;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_test_cur() occured....\n");
   proc_exit();	
 }

/*************** OPEN TEST CURSOR ***************/
void open_test_cur()
{

/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	if (strcmp(nd_include_test.arr, "O") == 0)
	{
		if((strcmp(nd_rc_source.arr,"Y") == 0) 
			&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
			&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
					{
					/* EXEC SQL OPEN test_cursor
						USING	:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_type,
								:nd_type,
								:nd_fm_source_type,
								:nd_to_source_type,
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )162;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_type;
     sqlstm.sqhstl[2] = (unsigned int  )4;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_type;
     sqlstm.sqhstl[3] = (unsigned int  )4;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fm_source_type;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_source_type;
     sqlstm.sqhstl[5] = (unsigned int  )9;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&v_date;
     sqlstm.sqhstl[6] = (unsigned int  )32;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&w_date;
     sqlstm.sqhstl[7] = (unsigned int  )32;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[8] = (unsigned int  )4;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[9] = (unsigned int  )4;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[10] = (unsigned int  )13;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&nd_to_wrkgrp_test;
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
     if (sqlca.sqlcode < 0) goto err_exit;
}


								
					}

		else if((strcmp(nd_rc_source.arr,"N") == 0) 
			&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
			&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
					{
					/* EXEC SQL OPEN test_cursor
						USING	:nd_operating_facility_id,
								:nd_operating_facility_id,						
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )225;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&v_date;
     sqlstm.sqhstl[2] = (unsigned int  )32;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&w_date;
     sqlstm.sqhstl[3] = (unsigned int  )32;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[6] = (unsigned int  )13;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_wrkgrp_test;
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


								
					}
			
		else if((strcmp(nd_rc_source.arr,"N") == 0) 
				&& ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0))
				&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
   					{
					/* EXEC SQL OPEN test_cursor
						USING	:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test,
								:nd_include_test,
								:language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )272;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
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
     sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&v_date;
     sqlstm.sqhstl[4] = (unsigned int  )32;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&w_date;
     sqlstm.sqhstl[5] = (unsigned int  )32;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[6] = (unsigned int  )4;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[7] = (unsigned int  )4;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[8] = (unsigned int  )13;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_to_wrkgrp_test;
     sqlstm.sqhstl[9] = (unsigned int  )13;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_include_test;
     sqlstm.sqhstl[10] = (unsigned int  )4;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&language_id;
     sqlstm.sqhstl[11] = (unsigned int  )7;
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

		else if((strcmp(nd_rc_source.arr,"Y") == 0) 
				&& ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0)) 
				&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
   					{
					/* EXEC SQL OPEN test_cursor
						USING	:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_type,
								:nd_type,
								:nd_fm_source_type,
								:nd_to_source_type,
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test,
								:nd_include_test,
								:language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )335;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
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
     sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_type;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_type;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_fm_source_type;
     sqlstm.sqhstl[6] = (unsigned int  )9;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_source_type;
     sqlstm.sqhstl[7] = (unsigned int  )9;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&v_date;
     sqlstm.sqhstl[8] = (unsigned int  )32;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&w_date;
     sqlstm.sqhstl[9] = (unsigned int  )32;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[10] = (unsigned int  )4;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[11] = (unsigned int  )4;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[12] = (unsigned int  )13;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&nd_to_wrkgrp_test;
     sqlstm.sqhstl[13] = (unsigned int  )13;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&nd_include_test;
     sqlstm.sqhstl[14] = (unsigned int  )4;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&language_id;
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

	}
	else if (strcmp(nd_include_test.arr, "A") == 0)
	{
		if((strcmp(nd_rc_source.arr,"Y") == 0) 
			&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
			&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
					{
					/* EXEC SQL OPEN test_cursor
						USING	:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_type,
								:nd_type,
								:nd_fm_source_type,
								:nd_to_source_type,
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_type,
								:nd_type,
								:nd_fm_source_type,
								:nd_to_source_type,
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )414;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_type;
     sqlstm.sqhstl[2] = (unsigned int  )4;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_type;
     sqlstm.sqhstl[3] = (unsigned int  )4;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fm_source_type;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_source_type;
     sqlstm.sqhstl[5] = (unsigned int  )9;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&v_date;
     sqlstm.sqhstl[6] = (unsigned int  )32;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&w_date;
     sqlstm.sqhstl[7] = (unsigned int  )32;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[8] = (unsigned int  )4;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[9] = (unsigned int  )4;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[10] = (unsigned int  )13;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&nd_to_wrkgrp_test;
     sqlstm.sqhstl[11] = (unsigned int  )13;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[12] = (unsigned int  )5;
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
     sqlstm.sqhstv[14] = (         void  *)&nd_type;
     sqlstm.sqhstl[14] = (unsigned int  )4;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&nd_type;
     sqlstm.sqhstl[15] = (unsigned int  )4;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&nd_fm_source_type;
     sqlstm.sqhstl[16] = (unsigned int  )9;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&nd_to_source_type;
     sqlstm.sqhstl[17] = (unsigned int  )9;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&v_date;
     sqlstm.sqhstl[18] = (unsigned int  )32;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&w_date;
     sqlstm.sqhstl[19] = (unsigned int  )32;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[20] = (unsigned int  )4;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[21] = (unsigned int  )4;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[22] = (unsigned int  )13;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&nd_to_wrkgrp_test;
     sqlstm.sqhstl[23] = (unsigned int  )13;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
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

		else if((strcmp(nd_rc_source.arr,"N") == 0) 
			&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
			&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
					{
					/* EXEC SQL OPEN test_cursor
						USING	:nd_operating_facility_id,
								:nd_operating_facility_id,						
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test,
								:nd_operating_facility_id,
								:nd_operating_facility_id,						
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )525;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&v_date;
     sqlstm.sqhstl[2] = (unsigned int  )32;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&w_date;
     sqlstm.sqhstl[3] = (unsigned int  )32;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[6] = (unsigned int  )13;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_wrkgrp_test;
     sqlstm.sqhstl[7] = (unsigned int  )13;
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
     sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[9] = (unsigned int  )5;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&v_date;
     sqlstm.sqhstl[10] = (unsigned int  )32;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&w_date;
     sqlstm.sqhstl[11] = (unsigned int  )32;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[12] = (unsigned int  )4;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[13] = (unsigned int  )4;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[14] = (unsigned int  )13;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&nd_to_wrkgrp_test;
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
     if (sqlca.sqlcode < 0) goto err_exit;
}


					}
			
		else if((strcmp(nd_rc_source.arr,"N") == 0) 
				&& ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0))
				&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
   					{
					/* EXEC SQL OPEN test_cursor
						USING	:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test,
								:nd_include_test,
								:language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )604;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
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
     sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&v_date;
     sqlstm.sqhstl[4] = (unsigned int  )32;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&w_date;
     sqlstm.sqhstl[5] = (unsigned int  )32;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[6] = (unsigned int  )4;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[7] = (unsigned int  )4;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[8] = (unsigned int  )13;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_to_wrkgrp_test;
     sqlstm.sqhstl[9] = (unsigned int  )13;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_include_test;
     sqlstm.sqhstl[10] = (unsigned int  )4;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&language_id;
     sqlstm.sqhstl[11] = (unsigned int  )7;
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

		else if((strcmp(nd_rc_source.arr,"Y") == 0) 
				&& ((strcmp(nd_rc_wrk_test.arr,"WS") == 0) || (strcmp(nd_rc_wrk_test.arr,"WD") == 0)) 
				&& ((strcmp(nd_rc_urgent_ind.arr,"N")==0) || (strcmp(nd_rc_urgent_ind.arr,"Y")==0)))
   					{
					/* EXEC SQL OPEN test_cursor
						USING	:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_operating_facility_id,
								:nd_type,
								:nd_type,
								:nd_fm_source_type,
								:nd_to_source_type,
								:v_date,
								:w_date,
								:nd_fm_section_code,
								:nd_to_section_code,
								:nd_fm_wrkgrp_test,
								:nd_to_wrkgrp_test,
								:nd_include_test,
								:language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )667;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
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
     sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_type;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_type;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_fm_source_type;
     sqlstm.sqhstl[6] = (unsigned int  )9;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_source_type;
     sqlstm.sqhstl[7] = (unsigned int  )9;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&v_date;
     sqlstm.sqhstl[8] = (unsigned int  )32;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&w_date;
     sqlstm.sqhstl[9] = (unsigned int  )32;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_fm_section_code;
     sqlstm.sqhstl[10] = (unsigned int  )4;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&nd_to_section_code;
     sqlstm.sqhstl[11] = (unsigned int  )4;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&nd_fm_wrkgrp_test;
     sqlstm.sqhstl[12] = (unsigned int  )13;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&nd_to_wrkgrp_test;
     sqlstm.sqhstl[13] = (unsigned int  )13;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&nd_include_test;
     sqlstm.sqhstl[14] = (unsigned int  )4;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&language_id;
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
	
	}


#ifdef DEBUG
    printf("leaving open_test_cur()\n");
    fflush(stdout);
 #endif
  return;
 err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )746;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at open_test_cur() occured....\n");
   proc_exit();	
}

/*************** CLOSE TEST CURSOR ***************/
void close_test_cur()
 {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL CLOSE test_cursor; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )761;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}


 #ifdef DEBUG
    printf("leaving close_test_cur()\n");
    fflush(stdout);
 #endif
  return;
 err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )776;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at close_test_cur() occured....\n");
   proc_exit();	
 }

 /*************** FETCH TEST CURSOR ***************/
int fetch_test_cur()
{
  d_section_code.arr[0]				= '\0';
  d_source_type.arr[0]				= '\0';
  d_source_code.arr[0]				= '\0';
  d_test_code.arr[0]                = '\0';  
  d_spec_date.arr[0]				= '\0';
  d_urgent_ind_desc.arr[0]          = '\0';  
  d_workgroup_code.arr[0]           = '\0';  
  d_workgroup_name.arr[0]				= '\0';
 
  d_section_code.len				= 0;
  d_source_type.len					= 0;
  d_source_code.len					= 0;
  d_test_code.len                   = 0;
  d_spec_date.len					= 0;
  d_urgent_ind_desc.len	            = 0;  
  d_workgroup_code.len	            = 0;  
  d_workgroup_name.len					= 0;

  count_test = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

if((strcmp(nd_rc_source.arr,"Y") == 0) 
	&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
	&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, :d_source_type, 
				:d_source_code, :d_test_code, :d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )791;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_source_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_source_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
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
   sqlstm.sqhstv[4] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[4] = (unsigned int  )32;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&count_test;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(long);
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


			}
else if((strcmp(nd_rc_source.arr,"N") == 0) 
	&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
	&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, 
				:d_test_code, :d_spec_date,:count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )830;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
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
   sqlstm.sqhstv[2] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[2] = (unsigned int  )32;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&count_test;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
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

else if((strcmp(nd_rc_source.arr,"N") == 0) 
	&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
	&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code,:d_test_code,:d_urgent_ind_desc,
				:d_spec_date,:count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )861;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
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
   sqlstm.sqhstv[2] = (         void  *)&d_urgent_ind_desc;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[3] = (unsigned int  )32;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&count_test;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
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


			}

else if((strcmp(nd_rc_source.arr,"Y") == 0) 
	&& (strcmp(nd_rc_wrk_test.arr,"T") == 0) 
	&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, :d_source_type, :d_source_code, 
				:d_urgent_ind_desc,:d_test_code, :d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )896;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_source_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_source_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_urgent_ind_desc;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_test_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[5] = (unsigned int  )32;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&count_test;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(long);
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


			}	

else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, :d_workgroup_code,:d_workgroup_name,
				:d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )939;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_workgroup_code;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_workgroup_name;
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[3] = (unsigned int  )32;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&count_test;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
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


			}

else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, :d_source_type, :d_source_code, 
				:d_workgroup_code,:d_workgroup_name,
				:d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )974;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_source_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_source_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_workgroup_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_workgroup_name;
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[5] = (unsigned int  )32;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&count_test;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(long);
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


			}
else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0)
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, :d_source_type, :d_source_code, 
				:d_urgent_ind_desc,:d_workgroup_code,:d_workgroup_name, 
				:d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1017;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_source_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_source_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_urgent_ind_desc;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_workgroup_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_workgroup_name;
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[6] = (unsigned int  )32;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&count_test;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
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
else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WS") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, 
				:d_workgroup_code,:d_workgroup_name,:d_urgent_ind_desc, 
				:d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1064;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_workgroup_code;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_workgroup_name;
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_urgent_ind_desc;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[4] = (unsigned int  )32;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&count_test;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(long);
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


			}
else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, :d_workgroup_code,:d_workgroup_name,
				:d_test_code,:d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1103;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_workgroup_code;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_workgroup_name;
   sqlstm.sqhstl[2] = (unsigned int  )43;
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
   sqlstm.sqhstv[4] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[4] = (unsigned int  )32;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&count_test;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(long);
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


			}
else if((strcmp(nd_rc_source.arr,"Y") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"N")==0))
   			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, :d_source_type,:d_source_code,
				:d_workgroup_code,:d_workgroup_name,
				:d_test_code,:d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1142;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_source_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_source_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_workgroup_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_workgroup_name;
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_test_code;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[6] = (unsigned int  )32;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&count_test;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
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
else if((strcmp(nd_rc_source.arr,"Y") == 0)
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code, :d_source_type,:d_source_code,:d_urgent_ind_desc,
				:d_workgroup_code,:d_workgroup_name,
				:d_test_code,:d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1189;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_source_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_source_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_urgent_ind_desc;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_workgroup_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_workgroup_name;
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_test_code;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[7] = (unsigned int  )32;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&count_test;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(long);
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
else if((strcmp(nd_rc_source.arr,"N") == 0) 
		&& (strcmp(nd_rc_wrk_test.arr,"WD") == 0) 
		&& (strcmp(nd_rc_urgent_ind.arr,"Y")==0))
   			{
			/* EXEC SQL FETCH TEST_CURSOR INTO
				:d_section_code,:d_urgent_ind_desc,
				:d_workgroup_code,:d_workgroup_name,
				:d_test_code,:d_spec_date, :count_test; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1240;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_urgent_ind_desc;
   sqlstm.sqhstl[1] = (unsigned int  )12;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_workgroup_code;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_workgroup_name;
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_test_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_spec_date;
   sqlstm.sqhstl[5] = (unsigned int  )32;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&count_test;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(long);
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


			}

#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif


  if(NODATAFOUND)
    return 0;


  d_section_code.arr[d_section_code.len]			= '\0';
  d_source_type.arr[d_source_type.len]				= '\0';
  d_source_code.arr[d_source_code.len]				= '\0';
  d_test_code.arr[d_test_code .len]					= '\0';
  d_urgent_ind_desc.arr[d_urgent_ind_desc.len]		= '\0';
  d_spec_date.arr[d_spec_date.len]					= '\0';
  d_workgroup_code.arr[d_workgroup_code.len]		= '\0';
  d_workgroup_name.arr[d_workgroup_name.len]		= '\0'; 

  
#ifdef DEBUG
   printf("********* Details from RL_WORKLIST_FMT_DTL**************\n");
   printf(" d_test_code= %s\n", d_test_code.arr);
   printf(" d_test_name= %s\n", d_test_name.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1283;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_test_cursor() occured....\n");
   proc_exit();

}

/********* GET SOURCE_NAME  **********/
  void get_source_name()
  {
    d_source_name.arr[0]	= '\0';
	d_source_name.len		= 0;

 	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	if(strcmp(d_source_type.arr,"C") == 0)
	{
   				/* EXEC SQL SELECT LONG_DESC 
				INTO :d_source_name
				FROM OP_CLINIC_lang_vw 
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND clinic_code = :d_source_code
				AND language_id = :language_id; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 24;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select LONG_DESC into :b0  from OP_CLINIC_lang_vw wher\
e ((FACILITY_ID=:b1 and clinic_code=:b2) and language_id=:b3)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1298;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&d_source_name;
       sqlstm.sqhstl[0] = (unsigned int  )43;
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
       sqlstm.sqhstv[2] = (         void  *)&d_source_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
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


	}
	else
	{
		if(strcmp(d_source_type.arr,"W") == 0) 
		{
		
				/*EXEC SQL SELECT LONG_DESC
				INTO :d_source_name
				FROM IP_WARD 
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND ward_code = :d_source_code; */  // commented for globalisation
				
				/* EXEC SQL SELECT LONG_DESC
				INTO :d_source_name
				FROM ip_nursing_unit_lang_vw
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND nursing_unit_code = :d_source_code
				AND language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from ip_nursing_unit_lang_vw w\
here ((FACILITY_ID=:b1 and nursing_unit_code=:b2) and language_id=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1329;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_source_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
    sqlstm.sqhstv[2] = (         void  *)&d_source_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
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


		}
		else
		{
			if((strcmp(d_source_type.arr,"R") == 0 ) || (strcmp(d_source_type.arr,"E") == 0 ) )
			{
					/* EXEC SQL SELECT LONG_DESC
					INTO :d_source_name
					FROM RL_REFERRAL_lang_vw 
					WHERE referral_code = :d_source_code
					AND language_id = :language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RL_REFERRAL_lang_vw wher\
e (referral_code=:b1 and language_id=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1360;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_source_name;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_source_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
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


			}
		}
	}

#ifdef DEBUG
    printf("leaving dclr_source_cur()\n");
    fflush(stdout);
#endif

	d_source_name.arr[d_source_name.len]	= '\0';


  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1387;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_source_cur() occured....\n");
   proc_exit();	
  }


/********* GET SECTION_NAME  **********/
  void get_section_name()
  {
    d_section_name.arr[0]	= '\0';
	d_section_name.len		= 0;

 	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL SELECT long_name
	INTO :d_section_name
	FROM RL_SECTION_CODE_lang_vw
	WHERE section_code = :d_section_code
	AND language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_name into :b0  from RL_SECTION_CODE_lang_vw wher\
e (section_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1402;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_section_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
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



#ifdef DEBUG
    printf("leaving dclr_section_cur()\n");
    fflush(stdout);
#endif

	d_section_name.arr[d_section_name.len]	= '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1429;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_section_name() occured....\n");
   proc_exit();	
  }


/********* GET TEST_NAME  **********/
  void get_test_name()
  {
    d_test_name.arr[0]	= '\0';
	d_test_name.len		= 0;

 	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


//	EXEC SQL SELECT LONG_DESC
	/* EXEC SQL SELECT short_desc
	INTO :d_test_name
	FROM RL_TEST_CODE_lang_vw 
	WHERE test_code = :d_test_code
	AND language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from RL_TEST_CODE_lang_vw where \
(test_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1444;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_test_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



#ifdef DEBUG
    printf("leaving dclr_source_cur()\n");
    fflush(stdout);
#endif

	d_test_name.arr[d_test_name.len]	= '\0';

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1471;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_test_name() occured....\n");
   proc_exit();	
  }

/********* PRINT MONTH COLUMN HEADING  **********/

print_month_col_heading()
{
	m_date  = 0;
    m_month = 0;
	m_year = 0;
	a_date = 0;
	a_month = 0;
	a_year = 0;

	h_head.arr[0]		= '\0';
	h_head.len			= 0;


	strcpy(x_date.arr, v_date.arr);
	x_date.len = strlen(x_date.arr);

	//fprintf(f1, "Description     ");
	//fprintf(f1, "Test        Description     ");
	
	//fprintf(f1,"%4.4s        %11.11s      ", local_legend[14],local_legend[15]);
	//commented and changed on 31/03/2008

	if (strcmp(nd_rc_wrk_test.arr,"WS") == 0)
		fprintf(f1,"%9.9s   %11.11s      ", local_legend[18],local_legend[15]);
	else
		fprintf(f1,"%4.4s        %11.11s      ", local_legend[14],local_legend[15]);

   	   /*EXEC SQL SELECT TO_DATE(:q_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL;*/

	   /* EXEC SQL SELECT TO_DATE(:w_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b1,'DD/MM/YYYY\
')) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1486;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&w_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&x_date;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&m_month;
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



	while(m_month >= 0)
	{
	   
	  /*EXEC SQL SELECT TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'DD/MM/YYYY')
			INTO :h_head FROM DUAL;

		EXEC SQL SELECT TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'DD/MM')
			INTO :h_head FROM DUAL;*/
		
		/* EXEC SQL SELECT TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'DD')
			INTO :h_head FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'DD') into :b1  fr\
om DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1513;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&x_date;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&h_head;
  sqlstm.sqhstl[1] = (unsigned int  )10;
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



  	   h_head.arr[h_head.len]		= '\0';

	   //fprintf(f1,"%-7s", h_head.arr);
	   fprintf(f1,"%-3s", h_head.arr);
	   fprintf(f1, " ");

	   //EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:x_date, 'DD/MM/YYYY'), 1), 'DD/MM/YYYY')
		//	INTO :x_date FROM DUAL;
		
		/* EXEC SQL SELECT TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY')+ 1, 'DD/MM/YYYY')
			INTO :x_date FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY')+1),'DD/MM/YYYY') \
into :b0  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1536;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&x_date;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&x_date;
  sqlstm.sqhstl[1] = (unsigned int  )32;
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


	
	   x_date.arr[x_date.len]		= '\0';


	   /*EXEC SQL SELECT TO_DATE(:q_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL;*/

	   /* EXEC SQL SELECT TO_DATE(:w_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b1,'DD/MM/YYYY\
')) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1559;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&w_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&x_date;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&m_month;
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



	}

	//fprintf(f1, "Total");
	fprintf(f1,"%5.5s",local_legend[23]);

	fprintf(f1,"\n-------------------------------------------------------------------------------");
	fprintf(f1,"-------------------------------------------------------------------------------");
	fprintf(f1,"\n") ;

	line_no += 2;

}

/************** PRINT DEPARTMENT COLUMN HEADING ***************/
void print_dept_col_heading()
{
 //chk_break(3);
 chk_break(12);

 fprintf(f1, "\n");
 //fprintf(f1,"Dept : %s",d_section_name.arr);
 fprintf(f1,"%4.4s : %s",local_legend[16],d_section_name.arr);
 fprintf(f1,"\n-----------------------------------");
 fprintf(f1, "\n");
 line_no += 3;
 total_records++ ;
}

/***************PRINT SOURCE COLUMN HEADING *************/
void print_source_col_heading()
{
 //chk_break(3);
 chk_break(9);

 //fprintf(f1, "\n");
 //fprintf(f1,"Source : %s",d_source_name.arr );
 fprintf(f1,"%6.6s : %s",local_legend[17],d_source_name.arr);

 fprintf(f1,"\n");
 fprintf(f1,"-----------------------------------");
 fprintf(f1,"\n");
 line_no +=2;

}
/************** PRINT WORKGROUP COLUMN HEADING ***************/
void print_workgroup_col_heading()
{
 //chk_break(3);
 chk_break(6);

 //fprintf(f1, "\n");
 //fprintf(f1,"Workgroup : %s",d_workgroup_name.arr);
 fprintf(f1,"%9.9s : %s",local_legend[18],d_workgroup_name.arr);
 fprintf(f1,"\n-----------------------------------");
 fprintf(f1, "\n");
 line_no += 2;
 total_records++;
}
/***************PRINT URGENT INDICATOR COLUMN HEADING *************/
void print_indicator_col_heading()
{
 //chk_break(3);
 chk_break(6);

 //fprintf(f1, "\n");
 //fprintf(f1,"Priority         : %s",d_urgent_ind_desc.arr );

 /****************added for globalisation *************************/
  if (strcmp(d_urgent_ind_desc.arr,"R") == 0) 
		strcpy (d_urgent_ind_desc.arr, local_legend[29]);
  else if (strcmp(d_urgent_ind_desc.arr,"U") == 0) 
		strcpy (d_urgent_ind_desc.arr, local_legend[30]);
  else if (strcmp(d_urgent_ind_desc.arr,"S") == 0)  
		strcpy (d_urgent_ind_desc.arr, local_legend[31]);

 fprintf(f1,"%8.8s : %s",local_legend[19],d_urgent_ind_desc.arr);
 fprintf(f1,"\n");
 fprintf(f1,"-----------------------------------");
 fprintf(f1,"\n");
 line_no +=2;
 total_records++ ;
}
/***************PRINT TOTAL_COUNT *************/
void print_total_count()
{
	int i =0;	

	for(i = mon_incr; i < tot_incr; i++)
	//fprintf(f1, "        ");
	//fprintf(f1, "    ");
	fprintf(f1, "  . ");/********For printing dots for blank spaces**********/
	fprintf(f1, "%5d", total_count);		
	fprintf(f1, "\n");	
	line_no++;
    total_count = 0;
    mon_incr = 0;	

}

/***************PRINT TESTS ****************************/
print_tests()
{
	chk_break(3);

	fprintf(f1,"%-11.11s",d_test_code.arr);
	fprintf(f1, " ");
		
	fprintf(f1,"%-15.15s",d_test_name.arr) ;  
	fprintf(f1, " ");	
}

/***************PRINT WORKGROUP ****************************/
print_workgroup()
{
	chk_break(3);

	fprintf(f1,"%-11.11s",d_workgroup_code.arr);
	fprintf(f1, " ");
		
	fprintf(f1,"%-15.15s",d_workgroup_name.arr) ;  
	fprintf(f1, " ");	
}
/*******************************************************************/
void chk_break(int lin)
{
   if((line_no + lin) >= MAX_LINES)
   {
   //disp_message(ERR_MESG,"TEST"); 
     fprintf(f1,"");
	 print_page_header();
	 print_month_col_heading();
	 line_no += 1;
   }
//sprintf(string_var,"Line    %d,Test    %s\n",line_no,d_test_code.arr);
//disp_message(ERR_MESG,string_var);

}

/***************PRINT TEST DETAILS OF THE REPORT *************/
void print_dtl_record()
{	
    
   /*EXEC SQL SELECT TO_NUMBER(SUBSTR(:d_spec_date, 1, 2)),
			TO_NUMBER(SUBSTR(:d_spec_date, 4, 4)) 
		INTO :j_month, :j_year
		FROM DUAL;*/

		/* EXEC SQL SELECT TO_NUMBER(SUBSTR(:d_spec_date, 1, 2)),
			TO_NUMBER(SUBSTR(:d_spec_date, 4, 2)),
			TO_NUMBER(SUBSTR(:d_spec_date, 7, 4)) 
		INTO :j_date,:j_month, :j_year
		FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select TO_NUMBER(SUBSTR(:b0,1,2)) ,TO_NUMBER(SUBSTR(:b0,4,2\
)) ,TO_NUMBER(SUBSTR(:b0,7,4)) into :b3,:b4,:b5  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1586;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_spec_date;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_spec_date;
  sqlstm.sqhstl[1] = (unsigned int  )32;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_spec_date;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&j_date;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&j_month;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&j_year;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
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



/**********/
 while(TRUE)
 {
    //if(date[mon_incr] == j_date && month[mon_incr] == j_month && year[mon_incr] == j_year )
   if(date1[mon_incr] == j_date && month[mon_incr] == j_month)
   {	
      break;
   }
   //fprintf(f1, "        ");
   //fprintf(f1, "    ");
	 fprintf(f1, "  . ");/********For printing dots for blank spaces**********/
     mon_incr++; 

 }
/**********/   

   //if(date[mon_incr] == j_date && month[mon_incr] == j_month && year[mon_incr] == j_year)
   if(date1[mon_incr] == j_date && month[mon_incr] == j_month)
   {
      //fprintf(f1, "%7d", count_test);	  
	  fprintf(f1, "%3d", count_test);
	  fprintf(f1, " ");	  
	  mnth_yr[mon_incr] = mnth_yr[mon_incr] + count_test;  // 26.04.2003	
   }
   else
   {
	  //fprintf(f1, "        ");	
	  fprintf(f1, "    ");
   }

   mon_incr++;
   
   total_count = total_count + count_test;
   s_total_count = s_total_count + count_test;         
   g_total_count = g_total_count + count_test;   // 26.04.2003 
   d_total_count = d_total_count + count_test;    

}

/************* get_params ***************/
void get_params()
{
	nd_fm_section_code.arr[0] 		= '\0';
	nd_fm_section_code.len			= 0 ;
	nd_to_section_code.arr[0]		= '\0' ;
	nd_to_section_code.len			= 0;
	nd_type.arr[0]					= '\0'	;
	nd_type.len				 		= 0;
	nd_fm_source_type.arr[0]		= '\0' ;
	nd_fm_source_type.len 			= 0;
	nd_to_source_type.arr[0]		= '\0' ;
	nd_to_source_type.len 			= 0;
	v_date.arr[0]					= '\0';
	v_date.len						= 0;
	w_date.arr[0]					= '\0';
	w_date.len						= 0;
	q_date.arr[0]					= '\0';
	q_date.len						= 0;
	nd_rc_source.arr[0]				= '\0';
	nd_rc_source.len				= 0;
	nd_rc_period.arr[0]				= '\0';
	nd_rc_period.len				= 0;
	nd_rc_wrk_test.arr[0]			= '\0';
	nd_rc_wrk_test.len				= 0;
	nd_fm_wrkgrp_test.arr[0]		= '\0';
	nd_fm_wrkgrp_test.len			= 0;
	nd_to_wrkgrp_test.arr[0]		= '\0';
	nd_to_wrkgrp_test.len			= 0;
	nd_rc_urgent_ind.arr[0]			= '\0';
	nd_rc_urgent_ind.len			= 0;
	nd_include_test.arr[0]          = '\0';
	nd_include_test.len             = 0;
    nd_clinic_grp_yn.arr[0]			= '\0';	
	nd_clinic_grp_yn.len			= 0;	


   //if(OERROR)
   //      disp_message(ORA_MESG,"get parameter function using : \n");

   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
            PARAM1,PARAM2,
		    LTRIM(RTRIM(PARAM3)),
		    PARAM4,PARAM5,
		    TO_NUMBER(SUBSTR(LTRIM(RTRIM(NVL(PARAM6,'0000000'))),1,2)),
		    TO_NUMBER(SUBSTR(NVL(PARAM6,'0000000'),4,4)),
		    TO_NUMBER(SUBSTR(LTRIM(RTRIM(NVL(PARAM7,'0000000'))),1,2)),
		    TO_NUMBER(SUBSTR(NVL(PARAM7,'0000000'),4,4)),
			PARAM8,PARAM9,PARAM10,
			PARAM11,PARAM12,PARAM13,PARAM14,nvl(PARAM15,'N')
		    INTO 
		    :nd_operating_facility_id,
		    :nd_fm_section_code ,:nd_to_section_code ,
		    :nd_type ,
		    :nd_fm_source_type ,:nd_to_source_type ,
		    :nd_fm_month ,
		    :nd_fm_year ,
		    :nd_to_month ,
		    :nd_to_year,
			:nd_rc_source,:nd_rc_period,:nd_rc_wrk_test,
			:nd_fm_wrkgrp_test,:nd_to_wrkgrp_test,:nd_rc_urgent_ind,
			:nd_include_test,:nd_clinic_grp_yn
            FROM SY_PROG_PARAM
	        WHERE   UPPER(PGM_ID) = 'RLREQSTD'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,LTRIM(RTRIM(\
PARAM3)) ,PARAM4 ,PARAM5 ,TO_NUMBER(SUBSTR(LTRIM(RTRIM(NVL(PARAM6,'0000000')))\
,1,2)) ,TO_NUMBER(SUBSTR(NVL(PARAM6,'0000000'),4,4)) ,TO_NUMBER(SUBSTR(LTRIM(R\
TRIM(NVL(PARAM7,'0000000'))),1,2)) ,TO_NUMBER(SUBSTR(NVL(PARAM7,'0000000'),4,4\
)) ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,nvl(PARAM15,'\
N') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15\
,:b16,:b17  from SY_PROG_PARAM where ((UPPER(PGM_ID)='RLREQSTD' and SESSION_ID\
=TO_NUMBER(:b18)) and PGM_DATE=:b19)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1625;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_section_code;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_type;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_source_type;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_source_type;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_month;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_year;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_month;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_year;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_rc_source;
   sqlstm.sqhstl[10] = (unsigned int  )9;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_rc_period;
   sqlstm.sqhstl[11] = (unsigned int  )4;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_rc_wrk_test;
   sqlstm.sqhstl[12] = (unsigned int  )5;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_fm_wrkgrp_test;
   sqlstm.sqhstl[13] = (unsigned int  )13;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_to_wrkgrp_test;
   sqlstm.sqhstl[14] = (unsigned int  )13;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_rc_urgent_ind;
   sqlstm.sqhstl[15] = (unsigned int  )12;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_include_test;
   sqlstm.sqhstl[16] = (unsigned int  )4;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_clinic_grp_yn;
   sqlstm.sqhstl[17] = (unsigned int  )4;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[18] = (unsigned int  )18;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[19] = (unsigned int  )22;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


	
	/* EXEC SQL SELECT '01'||'/'||LPAD(TO_CHAR(:nd_fm_month),2,'0')||'/'||
		TO_CHAR(:nd_fm_year) INTO :v_date FROM DUAL ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (((('01'||'/')||LPAD(TO_CHAR(:b0),2,'0'))||'/')||TO_C\
HAR(:b1)) into :b2  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1720;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fm_month;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fm_year;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&v_date;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	/* EXEC SQL SELECT '01'||'/'||LPAD(TO_CHAR(:nd_to_month),2,'0')||'/'||
		TO_CHAR(:nd_to_year) INTO :q_date FROM DUAL ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (((('01'||'/')||LPAD(TO_CHAR(:b0),2,'0'))||'/')||TO_C\
HAR(:b1)) into :b2  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1747;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&q_date;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



    /* EXEC SQL SELECT TO_CHAR(LAST_DAY(TO_DATE('01'||'/'||LPAD(TO_CHAR(:nd_to_month),2,'0')||'/'||
		TO_CHAR(:nd_to_year), 'DD/MM/YYYY')), 'DD/MM/YYYY') INTO :w_date FROM DUAL ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(LAST_DAY(TO_DATE((((('01'||'/')||LPAD(TO_C\
HAR(:b0),2,'0'))||'/')||TO_CHAR(:b1)),'DD/MM/YYYY')),'DD/MM/YYYY') into :b2  f\
rom DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1774;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_to_month;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_year;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&w_date;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}




   if(OERROR)
      disp_message(ORA_MESG,"get_parameter_function2 : \n");
   
  nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
  nd_fm_section_code.arr[nd_fm_section_code.len] 		= '\0';
  nd_to_section_code.arr[nd_to_section_code.len]		= '\0';
  nd_type.arr[nd_type.len]                              = '\0';
  nd_fm_source_type.arr[nd_fm_source_type.len] 			= '\0';
  nd_to_source_type.arr[nd_to_source_type.len] 			= '\0';
  v_date.arr[v_date.len]								= '\0';
  q_date.arr[q_date.len]								= '\0';
  w_date.arr[w_date.len]								= '\0';  
  nd_rc_source.arr[nd_rc_source.len]					= '\0';					
  nd_rc_period.arr[nd_rc_period.len]					= '\0';					
  nd_rc_wrk_test.arr[nd_rc_wrk_test.len]				= '\0';
  nd_fm_wrkgrp_test.arr[nd_fm_wrkgrp_test.len]			= '\0';
  nd_to_wrkgrp_test.arr[nd_to_wrkgrp_test.len]			= '\0';
  nd_rc_urgent_ind.arr[nd_rc_urgent_ind.len]			= '\0';
  nd_include_test.arr[nd_include_test.len]              = '\0';
  nd_include_test.arr[nd_include_test.len]              = '\0';
  nd_clinic_grp_yn.arr[nd_clinic_grp_yn.len]			= '\0';

  #ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" nd_fm_section_code = %s\n",nd_fm_section_code.arr);
   printf(" nd_to_section_code = %s\n",nd_to_section_code.arr);
   printf(" nd_type = %d\n",nd_type);
   printf(" nd_fm_source_type = %s\n",nd_fm_source_type.arr);
   printf(" nd_to_source_type = %s\n",nd_to_source_type.arr);
   printf(" v_date = %s\n",v_date.arr);
   printf(" w_date = %s\n",w_date.arr);
   getchar();  
#endif
  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
	        WHERE UPPER(PGM_ID) = 'RLREQSTD'
	        AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLREQST\
D' and SESSION_ID=TO_NUMBER(:b0)) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1801;
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
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1824;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_params() occured....\n");
   proc_exit();
}

/************ GET_HEADER_DETAILS****************/
void get_header_dtls()
{
     d_acc_entity_name.arr[0]   = '\0';
	 d_acc_entity_name.len		= 0;
	 d_user.arr[0]				= '\0';
	 d_user.len                 = 0;
	 d_sysdate.arr[0]			= '\0';
	 d_sysdate.len              = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /*
   EXEC SQL SELECT SUBSTR(LPAD(ACC_ENTITY_NAME,
		       TRUNC(15 + 0.5*LENGTH(ACC_ENTITY_NAME))),1,30),
		    USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	    INTO :d_acc_entity_name,
		 :d_user,
		 :d_sysdate
            FROM SY_ACC_ENTITY
			WHERE ACC_ENTITY_ID = :nd_operating_facility_id
*/

   /* EXEC SQL SELECT ACC_ENTITY_NAME,
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	       INTO :d_acc_entity_name,
		   :d_user,
		   :d_sysdate
            FROM SY_ACC_ENTITY_lang_vw
			WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			AND language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:b\
3 and language_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1839;
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
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1874;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}


/*************** GENERATE FILE NAME ***************/
void gen_file_name()
{

  	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_file_name.arr,"rlreqstd.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);

	 if((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
    

}

/*********** PRINT REPORT HEADER **************/

void print_rep_header()
{
  char			nd_fm_section_desc[10],
				nd_to_section_desc[10],
				nd_fm_source_desc[10],
				nd_to_source_desc[10],
			    nd_fm_date[30],
				nd_to_date[30],
				nd_wrk_test_ind[30],
				nd_fm_wrktest_desc[30],
				nd_to_wrktest_desc[30],
				nd_urgent_ind[10];

  if(strcmp(nd_fm_section_code.arr, "!") == 0)
    //strcpy(nd_fm_section_desc,"LOWEST");
	strcpy(nd_fm_section_desc, local_legend[24]); // added for globalisation
  else strcpy(nd_fm_section_desc, nd_fm_section_code.arr);
  if(strcmp(nd_to_section_code.arr, "~") == 0)
    //strcpy(nd_to_section_desc,"HIGHEST");
	strcpy(nd_to_section_desc, local_legend[25]); // added for globalisation
  else strcpy(nd_to_section_desc, nd_to_section_code.arr);   
   
  if(strcmp(nd_fm_source_type.arr, "!!!!") == 0)
    //strcpy(nd_fm_source_desc,"LOWEST");
	strcpy(nd_fm_source_desc, local_legend[24]); // added for globalisation
  else strcpy(nd_fm_source_desc, nd_fm_source_type.arr);
  if(strcmp(nd_to_source_type.arr, "~~~~") == 0)
    //strcpy(nd_to_source_desc,"HIGHEST");
	strcpy(nd_to_source_desc, local_legend[25]); // added for globalisation
  else strcpy(nd_to_source_desc, nd_to_source_type.arr);

  if(strcmp(nd_rc_wrk_test.arr,"WS") == 0)
	//strcpy(nd_wrk_test_ind,"WORKGROUP SUMMARY");
    strcpy(nd_wrk_test_ind, local_legend[26]); // added for globalisation
  if(strcmp(nd_rc_wrk_test.arr,"WD") == 0)
	//strcpy(nd_wrk_test_ind,"WORKGROUP DETAIL");
	strcpy(nd_wrk_test_ind, local_legend[27]); // added for globalisation
  if(strcmp(nd_rc_wrk_test.arr,"T") == 0)
	//strcpy(nd_wrk_test_ind,"INDIVIDUAL TEST");
	strcpy(nd_wrk_test_ind, local_legend[28]); // added for globalisation

  if(strcmp(nd_fm_wrkgrp_test.arr, "!!!!") == 0)
    //strcpy(nd_fm_wrktest_desc,"LOWEST");
	strcpy(nd_fm_wrktest_desc, local_legend[24]); // added for globalisation
  else strcpy(nd_fm_wrktest_desc, nd_fm_wrkgrp_test.arr);
  if(strcmp(nd_to_wrkgrp_test.arr, "~~~~") == 0)
    //strcpy(nd_to_wrktest_desc,"HIGHEST");
	strcpy(nd_to_wrktest_desc, local_legend[25]); // added for globalisation
   else strcpy(nd_to_wrktest_desc, nd_to_wrkgrp_test.arr);  

  strcpy(nd_urgent_ind, nd_rc_urgent_ind.arr);  


  #ifdef DEBUG
      printf("before report header()\n");
  #endif
  l_first_page = 1;
  print_page_header();
  l_first_page = 0;
  #ifdef DEBUG
      printf("after page header()\n");   
  #endif
  
  get_version_no();   ///// added 01.07.2003

////////// 01.07.2003  fprintf(f1,VER);

  fprintf(f1,"%s\n",d_version.arr);

  fprintf(f1,"\n\n\n\n");
  //fprintf(f1,"        ");
  //fprintf(f1,"INPUT PARAMETERS :\n");
  
  rec_len = strlen(local_legend[5]);//added for globalisation
  print_space(25, rec_len,1);//added for globalisation
  fprintf(f1,"%s:\n", local_legend[5]); 

  //fprintf(f1,"        ");
  //fprintf(f1,"------------------\n\n");

  print_space(25, rec_len,1);//added for globalisation
  print_space(25, rec_len,0);//added for globalisation
  fprintf(f1,"\n\n");

  //fprintf(f1,"                ");
  //fprintf(f1,"DEPARTMENT      FROM : %s\n", nd_fm_section_desc);

  rec_len = strlen(local_legend[6]);//added for globalisation
  rec_len = rec_len + strlen(local_legend[7]) + 6;
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s      %s : %s\n", local_legend[6], local_legend[7], nd_fm_section_desc); // added for globalisation

  //fprintf(f1,"                ");  
  //fprintf(f1,"                  TO : %s\n", nd_to_section_desc);

  rec_len = strlen(local_legend[8]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n", local_legend[8],nd_to_section_desc);

  /***added on 19/01/2004***/
  //fprintf(f1,"                ");
  //fprintf(f1," SOURCE         FROM : %s\n", nd_fm_source_desc);

  rec_len = strlen(local_legend[9]);//added for globalisation
  rec_len = rec_len + strlen(local_legend[7]) + 6;
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s      %s : %s\n", local_legend[9], local_legend[7], nd_fm_source_desc); // added for globalisation

  //fprintf(f1,"                ");
  //fprintf(f1,"                  TO : %s\n", nd_to_source_desc);
  
  rec_len = strlen(local_legend[8]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n", local_legend[8],nd_to_source_desc);

  //fprintf(f1,"                ");
  //fprintf(f1," PERIOD         FROM : %s\n", v_date.arr);

  /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE(to_date(:v_date,'DD/MM/YYYY'), :language_id , t_date);
			//:v_date1 := to_char(t_date,'DD/MM/YYYY');
			:v_date1 :=sm_convert_date_2t(to_date(:v_date,'DD/MM/YYYY '),:language_id);
		END;
  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :v_date1 := sm_convert_date_2t \
( to_date ( :v_date , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1889;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&v_date1;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&v_date;
  sqlstm.sqhstl[1] = (unsigned int  )32;
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



  rec_len = strlen(local_legend[10]);//added for globalisation
  rec_len = rec_len + strlen(local_legend[7]) + 6;
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s      %s : %s\n", local_legend[10], local_legend[7], v_date1.arr); // added for globalisation

  //fprintf(f1,"                ");
  //fprintf(f1,"                  TO : %s\n", w_date.arr);

  /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE(to_date(:w_date,'DD/MM/YYYY'), :language_id , t_date);
			//:w_date1 := to_char(t_date,'DD/MM/YYYY');
			:w_date1 :=sm_convert_date_2t(to_date(:w_date,'DD/MM/YYYY '),:language_id);
		END;
  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :w_date1 := sm_convert_date_2t \
( to_date ( :w_date , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1916;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&w_date1;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&w_date;
  sqlstm.sqhstl[1] = (unsigned int  )32;
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



  rec_len = strlen(local_legend[8]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n", local_legend[8],w_date1.arr);

  //fprintf(f1,"                ");
  //fprintf(f1," WORKGROUP/TEST INDICATOR  : %s\n", nd_wrk_test_ind);

  rec_len = strlen(local_legend[11]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n", local_legend[11],nd_wrk_test_ind);

  //fprintf(f1,"                ");
  //fprintf(f1," WORKGROUP/TEST FROM : %s\n", nd_fm_wrktest_desc);

  rec_len = strlen(local_legend[12]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n", local_legend[12],nd_fm_wrktest_desc);

  //fprintf(f1,"                ");
  //fprintf(f1,"                  TO : %s\n", nd_to_wrktest_desc);

  rec_len = strlen(local_legend[8]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n", local_legend[8],nd_to_wrktest_desc);

  //fprintf(f1,"                ");
  //fprintf(f1," PRIORITY            : %s\n", nd_urgent_ind);

  rec_len = strlen(local_legend[13]);//added for globalisation
  print_space(35, rec_len,1);//added for globalisation
  fprintf(f1,"%s : %s\n", local_legend[13],nd_urgent_ind);

  fprintf(f1,"\n");
  fprintf(f1,"");
}


/************ PRINT PAGE HEADER ****************/
void print_page_header()
{
 register int i;
 char nd_fm_section_desc[10],
       nd_to_section_desc[10];
 int spc_len;

  if(strcmp(nd_fm_section_code.arr, "!") == 0)
    
	//strcpy(nd_fm_section_desc, "LOWEST");
    strcpy(nd_fm_section_desc, local_legend[24]); // added for globalisation

  else strcpy(nd_fm_section_desc, nd_fm_section_code.arr);

  if(strcmp(nd_to_section_code.arr, "~") == 0)
  
    //strcpy(nd_to_section_desc, "HIGHEST");
    strcpy(nd_to_section_desc, local_legend[25]); // added for globalisation

  else strcpy(nd_to_section_desc,nd_to_section_code.arr);

 line_no = 0;
 page_no++;

 fprintf(f1,"%c&l1O",ESC);
 //fprintf(f1,"%c&k4S",ESC);
 fprintf(f1,"%c&k2S",ESC);
 fprintf(f1,"\n") ;	
 /*
 fprintf(f1,"MDL : RL                              ");
 fprintf(f1,"%30.30s", d_acc_entity_name.arr);
 fprintf(f1,"                                  %s", d_sysdate.arr);
 fprintf(f1,"\n"); 
 */

  fprintf(f1,"MDL : RL");
  //spc_len = (94 - (strlen(d_acc_entity_name.arr)))/2;
  spc_len = (130 - (strlen(d_acc_entity_name.arr)))/2;
  for(i=1;i<=spc_len;i++)
  fprintf(f1," ");
  //fprintf(f1,"%-60.60s", d_acc_entity_name.arr);  
  fprintf(f1,"%s", d_acc_entity_name.arr);  
  for(i=1;i<=spc_len;i++)
  fprintf(f1," ");
  
  //fprintf(f1,"%s", d_sysdate.arr);  
  /*************************added for globalisation start************/
  /* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		//t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
		//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
		:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
	END;
  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert_datet\
ime_2t ( SYSDATE , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1943;
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


  /*************************added for globalisation end************/

  fprintf(f1,"%s", d_sysdate1.arr);  
  fprintf(f1,"\n");

 fprintf(f1,"OPR : %s", d_user.arr);
 fprintf(f1,"                                         ") ;
 //fprintf(f1,"                  REQUEST STATISTICS                              ");
 
 //fprintf(f1,"                  REQUEST STATISTICS");
 rec_len = strlen(local_legend[1]);//added for globalisation
 print_space(30, rec_len,1);//added for globalisation
 fprintf(f1,"%s", local_legend[1]);//added for globalisation

 fprintf(f1,"                                                     ");
 //fprintf(f1,"        Page : %4d", page_no);
 
 //fprintf(f1,"Page : %4d", page_no);
 fprintf(f1,"        %s : %4d", local_legend[2],page_no);//added for globalisation

 fprintf(f1,"\n");
 fprintf(f1,"REP : RLREQSTD");

// added on 01/04/2008 for globalisation
 /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE(to_date(:l_page_head_month,'MON'), :language_id , t_date);
			//:l_page_head_month1 := to_char(t_date,'MON');
			:l_page_head_month1 :=sm_convert_date_2t(to_date(:l_page_head_month,'MON'),:language_id);
			:l_page_head_month1:=TO_CHAR(TO_DATE(:l_page_head_month1,'DD/MM/YYYY'),'MON');
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE(to_date(:l_page_head_year,'YYYY'), :language_id , t_date);
			//:l_page_head_year1 := to_char(t_date,'YYYY');
			:l_page_head_year1 :=sm_convert_date_2t(to_date(:l_page_head_year,'YYYY'),:language_id);
			:l_page_head_year1:=TO_CHAR(TO_DATE(:l_page_head_year1,'DD/MM/YYYY'),'YYYY');

		END;
 END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :l_page_head_month1 := sm_conver\
t_date_2t ( to_date ( :l_page_head_month , 'MON' ) , :language_id ) ; :l_page_\
head_month1 := TO_CHAR ( TO_DATE ( :l_page_head_month1 , 'DD/MM/YYYY' ) , 'MON\
' ) ; :l_page_head_year1 := sm_convert_date_2t ( to_date ( :l_page_head_year ,\
 'YYYY' ) , :language_id ) ; :l_page_head_year1 := TO_CHAR ( TO_DATE ( :l_page\
_head_year1 , 'DD/MM/YYYY' ) , 'YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1966;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_page_head_month1;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_page_head_month;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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
 sqlstm.sqhstv[3] = (         void  *)&l_page_head_year1;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_page_head_year;
 sqlstm.sqhstl[4] = (unsigned int  )12;
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



 if (! l_first_page)
    //fprintf(f1,"%121sMONTH: %s YEAR: %s"," ",l_page_head_month.arr,l_page_head_year.arr);
	//fprintf(f1,"%121s%5.5s: %s %4.4s: %s"," ", local_legend[3],l_page_head_month.arr,local_legend[4],l_page_head_year.arr);
	fprintf(f1,"%121s%5.5s: %s %4.4s: %s"," ", local_legend[3],l_page_head_month1.arr,local_legend[4],l_page_head_year1.arr);

 fprintf(f1,"\n");
 fprintf(f1,"-------------------------------------------------------------------------------");
 fprintf(f1,"-------------------------------------------------------------------------------") ;
 fprintf(f1,"\n");
 line_no = line_no + 6;
}

initialize_array()
{

    int i = 0;
	int k = 0;
	
	m_date = 0;
	m_month = 0;
	m_year = 0;
	a_date = 0;
	a_month = 0;
	a_year = 0;

	tot_incr = 0;

	strcpy(x_date.arr, v_date.arr);
	x_date.len = strlen(x_date.arr);

	for(k=0;k<32;k++)
	{
		date1[k] = 0;
	}

	for(k=0;k<13;k++)
	{
		month[k] = 0;
		year[k]	= 0;
	}

	/* EXEC SQL SELECT TO_NUMBER(TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'DD'))
	INTO :t_date FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'DD')) in\
to :b1  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2001;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&x_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&t_date;
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



	/* EXEC SQL SELECT TO_NUMBER(TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'MM'))
	INTO :t_month FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'MM')) in\
to :b1  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2024;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&x_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&t_month;
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


    
	/* EXEC SQL SELECT TO_NUMBER(TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'YYYY')) 
	INTO :t_year FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'YYYY')) \
into :b1  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2047;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&x_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&t_year;
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


	
	   /*EXEC SQL SELECT TO_DATE(:q_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL;*/

	/* EXEC SQL SELECT TO_DATE(:w_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b1,'DD/MM/YYYY'))\
 into :b2  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2070;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&w_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&x_date;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&m_month;
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




   date1[i]  = t_date;
   month[i] = t_month;
   year[i]	= t_year;

	while(m_month >= 0)
	{

	   tot_incr++;


	   //EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:x_date, 'DD/MM/YYYY'), 1), 'DD/MM/YYYY')
		//	INTO :x_date FROM DUAL;

		/* EXEC SQL SELECT TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY')+ 1, 'DD/MM/YYYY')
			INTO :x_date FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY')+1),'DD/MM/YYYY') \
into :b0  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2097;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&x_date;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&x_date;
  sqlstm.sqhstl[1] = (unsigned int  )32;
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



	   x_date.arr[x_date.len]		= '\0';

	   /* EXEC SQL SELECT TO_NUMBER(TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'DD'))
		INTO :t_date FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'DD'))\
 into :b1  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2120;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&x_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_date;
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



	   	/* EXEC SQL SELECT TO_NUMBER(TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'MM'))
		INTO :t_month FROM DUAL; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'MM')\
) into :b1  from DUAL ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2143;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&x_date;
     sqlstm.sqhstl[0] = (unsigned int  )32;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&t_month;
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



		/* EXEC SQL SELECT TO_NUMBER(TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'YYYY'))
		INTO :t_year FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'YYYY'))\
 into :b1  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2166;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&x_date;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&t_year;
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




   	   /*EXEC SQL SELECT TO_DATE(:q_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL;*/

	   /* EXEC SQL SELECT TO_DATE(:w_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b1,'DD/MM/YYYY\
')) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2189;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&w_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&x_date;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&m_month;
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



	   i++;
	   date1[i] = t_date;
	   month[i] = t_month;
	   year[i]	= t_year;
	}
}
/* ************* added the following function on  26.04.2003 *************/
void do_footer()
{
 int i =0; 

 fprintf(f1,"\n");
 fprintf(f1,"-------------------------------------------------------------------------------");
 fprintf(f1,"-------------------------------------------------------------------------------") ;
 fprintf(f1,"\n");
 //fprintf(f1,"Report Totals:              "); 
 fprintf(f1,"%s :             ",local_legend[22]);
 
 for(i = 0; i < tot_incr; i++)
 {  
    fprintf(f1,"%7d",mnth_yr[i]);	
	fprintf(f1," ");
	mnth_yr[i] = 0;
 }

 fprintf(f1,"%5d\n",g_total_count);   
 g_total_count = 0;
 fprintf(f1,"-------------------------------------------------------------------------------");
 fprintf(f1,"-------------------------------------------------------------------------------") ;
 fprintf(f1,"\n");
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
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2216;
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




    if(l_tab_exists) 
    {
	    /* EXEC SQL SELECT VERSION_NO INTO :d_version_no 
                 FROM   SM_INSTALLATION; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2235;
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


    if(OERROR)
	{
	    strcpy(d_version_no.arr,"2.1");
	    strcat(d_version.arr,d_version_no.arr);
    }

}
//////////// UPTO HERE   

/* ************* added the following function on  18.01.2004 *************/
print_source_total()
{
 int i =0; 

 chk_break(3);

 //fprintf(f1,"\n");
 fprintf(f1,"-------------------------------------------------------------------------------");
 fprintf(f1,"-------------------------------------------------------------------------------") ;
 fprintf(f1,"\n"); 
 
 //fprintf(f1,"Source Totals:              "); 
 fprintf(f1,"%13.13s :             ", local_legend[21]);

 for(i = 0; i < tot_incr; i++)
 {  
    //fprintf(f1,"%7d",mnth_yr[i]);	
	fprintf(f1,"%3d",mnth_yr[i]);	
	fprintf(f1," ");
	
	dpt_mnth_yr[i] = dpt_mnth_yr[i] + mnth_yr[i];
	mnth_yr[i] = 0;
 }
 
 fprintf(f1,"%5d\n",s_total_count);  
 s_total_count = 0;
 fprintf(f1,"-------------------------------------------------------------------------------");
 fprintf(f1,"-------------------------------------------------------------------------------") ;
 fprintf(f1,"\n");
 line_no += 3;
}

print_department_total()
{
 int i =0; 
 chk_break(3);

 //fprintf(f1,"\n");
 fprintf(f1,"-------------------------------------------------------------------------------");
 fprintf(f1,"-------------------------------------------------------------------------------") ;
 fprintf(f1,"\n");
 //fprintf(f1,"Department Total:           "); 
 fprintf(f1,"%16.16s :          ", local_legend[20]);

 for(i = 0; i < tot_incr; i++)
 {  
	if(strcmp(nd_rc_source.arr,"Y") == 0)
	{
    //fprintf(f1,"%7d",dpt_mnth_yr[i]);	
	fprintf(f1,"%3d",dpt_mnth_yr[i]);
	fprintf(f1," ");
	dpt_mnth_yr[i] = 0;
	}
	else	
	{
	//fprintf(f1,"%7d",mnth_yr[i]);
	fprintf(f1,"%3d",mnth_yr[i]);		
	fprintf(f1," ");
	mnth_yr[i] = 0; 
	}
 } 
 fprintf(f1,"%5d\n",d_total_count);

 d_total_count = 0; 

 fprintf(f1,"-------------------------------------------------------------------------------");
 fprintf(f1,"-------------------------------------------------------------------------------") ;
 fprintf(f1,"\n");

 line_no += 2;
}

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

/**********************THE END OF REPORT*************************************************/
