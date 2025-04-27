
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
           char  filnam[59];
};
static const struct sqlcxp sqlfpn =
{
    58,
    "D:\\WORK\\ML-MMOH-CRF-0752.6-US001\\Proc\\rlrexcch\\rlrexcch.pc"
};


static unsigned long sqlctx = 1143473429;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {10,13};

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

 static const char *sq0003 = 
"select to_char(A.specimen_no) ,A.source_type ,NVL(A.patient_id,'') ,NVL(A.cu\
stomer_code,'') ,A.source_code ,B.test_code ,TO_CHAR(A.spec_regd_date_time,'DD\
/MM/YYYY') ,A.episode_type ,A.episode_no ,A.tfr_visit_no ,NVL(B.reflex_type,'X\
') ,B.line_no ,A.added_by_id  from RL_REQUEST_HEADER A ,RL_REQUEST_DETAIL B wh\
ere ((((((((A.OPERATING_FACILITY_ID=:b0 and B.OPERATING_FACILITY_ID=:b0) and A\
.source_type=DECODE(:b2,'A',A.source_type,'R','E','H','E',:b2)) and A.source_c\
ode between DECODE(:b4,'!!!!',A.source_code,:b4) and DECODE(:b6,'~~~~',A.sourc\
e_code,:b6)) and A.spec_regd_date_time>=TO_DATE(:b8,'DD/MM/YYYYhh24:mi:ss')) a\
nd A.spec_regd_date_time<TO_DATE(:b9,'DD/MM/YYYYhh24:mi:ss')) and A.specimen_n\
o=B.specimen_no) and NVL(A.cancelled_yn,'N')<>'Y') and NVL(B.cancelled_yn,'N')\
<>'Y') order by A.specimen_no,A.section_code,A.source_type,A.source_code,B.tes\
t_code            ";

 static const char *sq0005 = 
"select to_char(A.specimen_no) ,A.source_type ,NVL(A.patient_id,'') ,NVL(A.cu\
stomer_code,'') ,A.source_code ,B.test_code ,TO_CHAR(A.spec_regd_date_time,'DD\
/MM/YYYY') ,A.episode_type ,A.episode_no ,A.tfr_visit_no ,NVL(B.reflex_type,'X\
') ,B.line_no ,A.added_by_id  from RL_REQUEST_HEADER A ,RL_REQUEST_DETAIL B wh\
ere (((((((((A.OPERATING_FACILITY_ID=:b0 and B.OPERATING_FACILITY_ID=:b0) and \
A.source_type=DECODE(:b2,'A',A.source_type,'R','E','H','E',:b2)) and A.source_\
code between DECODE(:b4,'!!!!',A.source_code,:b4) and DECODE(:b6,'~~~~',A.sour\
ce_code,:b6)) and A.spec_regd_date_time>=TO_DATE(:b8,'DD/MM/YYYYhh24:mi:ss')) \
and A.spec_regd_date_time<TO_DATE(:b9,'DD/MM/YYYYhh24:mi:ss')) and A.specimen_\
no=B.specimen_no) and NVL(A.cancelled_yn,'N')<>'Y') and NVL(B.cancelled_yn,'N'\
)<>'Y') and B.REFLEX_TYPE is null ) order by A.specimen_no,A.section_code,A.so\
urce_type,A.source_code,B.test_code            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,539,216,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,544,245,0,0,0,0,0,1,0,
51,0,0,3,874,0,521,370,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
106,0,0,4,0,0,544,380,0,0,0,0,0,1,0,
121,0,0,5,903,0,521,415,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
176,0,0,6,0,0,544,425,0,0,0,0,0,1,0,
191,0,0,3,0,0,527,434,0,0,0,0,0,1,0,
206,0,0,7,0,0,544,443,0,0,0,0,0,1,0,
221,0,0,5,0,0,527,452,0,0,0,0,0,1,0,
236,0,0,8,0,0,544,461,0,0,0,0,0,1,0,
251,0,0,3,0,0,525,503,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
318,0,0,5,0,0,525,511,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
385,0,0,9,197,0,518,540,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
412,0,0,10,0,0,544,560,0,0,0,0,0,1,0,
427,0,0,11,115,0,516,576,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
458,0,0,12,127,0,516,588,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
489,0,0,13,97,0,516,606,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
516,0,0,14,0,0,544,626,0,0,0,0,0,1,0,
531,0,0,15,70,0,516,640,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
554,0,0,16,0,0,544,655,0,0,0,0,0,1,0,
569,0,0,17,94,0,516,669,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
596,0,0,18,0,0,544,685,0,0,0,0,0,1,0,
611,0,0,19,81,0,516,709,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
638,0,0,20,72,0,516,717,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
661,0,0,21,89,0,516,725,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
684,0,0,22,81,0,516,730,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
711,0,0,23,225,0,516,813,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
762,0,0,24,109,0,514,858,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
785,0,0,25,0,0,544,866,0,0,0,0,0,1,0,
800,0,0,26,161,0,516,883,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
835,0,0,27,0,0,544,907,0,0,0,0,0,1,0,
850,0,0,28,209,0,518,981,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
877,0,0,29,209,0,518,995,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
904,0,0,30,156,0,518,1052,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
927,0,0,31,78,0,516,1181,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
950,0,0,32,80,0,516,1184,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
973,0,0,33,81,0,516,1187,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
1000,0,0,34,89,0,516,1201,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
1023,0,0,35,78,0,516,1206,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1046,0,0,36,80,0,516,1209,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1069,0,0,37,81,0,516,1213,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
1096,0,0,38,101,0,518,1242,0,0,1,1,0,1,0,2,3,0,0,
1115,0,0,39,122,0,516,1350,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
1142,0,0,40,122,0,516,1358,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
1169,0,0,41,120,0,518,1386,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1192,0,0,42,136,0,518,1396,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: rlrexcch.pc
   Author : Srikanth
   Date Created  : 25/07/2004
   Last Modified : 25/07/2004
   
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
		    

*  Output File : RLREXCCH.lis
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <rl.h>

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ESC 0x1B
#define REP_WIDTH 78 // added for globalisation

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
		d_version  			       [20],
		d_added_by_id			   [31]; */ 
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

struct { unsigned short len; unsigned char arr[31]; } d_added_by_id;

/****************************/
/* FIELDS from CURSOR SECTION CURSOR */
	/* varchar d_section_code	[2] , 
		    d_section_name  [41] ; */ 
struct { unsigned short len; unsigned char arr[2]; } d_section_code;

struct { unsigned short len; unsigned char arr[41]; } d_section_name;


	int specimen_prefix = 0;

/* FIELDS from CURSOR TEST CURSOR */
	/* varchar d_test_code [11] ,
			rl_ordered_facility_id	[3],
		    d_test_name [41],
			d_reflex_type [3]; */ 
struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_test_name;

struct { unsigned short len; unsigned char arr[3]; } d_reflex_type;



/* FIELDS for FETCHING SOURCE CURSOR */
	/* varchar d_source_code [11] ,			
			d_source_name [100],  /oModified By Manoj S for ML-MMOH-CRF-0752.6o/
			d_source_type  [2] ; */ 
struct { unsigned short len; unsigned char arr[11]; } d_source_code;

struct { unsigned short len; unsigned char arr[100]; } d_source_name;

struct { unsigned short len; unsigned char arr[2]; } d_source_type;


/* FIELDS for GET TEST_GROUP DETAILS */
	long count_test ;
	long total_records;
	
/* Fields from table RL_SECTION_CODE */
	 /* varchar      d_printer_name            [16]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_printer_name;


/* Fields from table EPISODE */
	 /* varchar      d_episode_type[3],
	              nd_episode_type[2]; */ 
struct { unsigned short len; unsigned char arr[3]; } d_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;


	  int         d_episode_no;            

/* Fields from TFR_VISIT_NO */	 
	  int         d_tfr_visit_no, d_line_no;

/* Fields from PATIENT_ID */
     /* varchar	  d_patient_id[21],
	              d_customer_code[21],
	              nd_patient_id[21],
				  patient_name[61]; */ 
struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_customer_code;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[61]; } patient_name;

				  	
/* Specimen number as character */
     /* varchar	txt_specimen_no[15]; */ 
struct { unsigned short len; unsigned char arr[15]; } txt_specimen_no;


/* Fields for passing parameter to BL Procedure */

	/* varchar		p_charged_yn	   [2],		 		 		 
				p_status           [2],      
				p_err_code         [3],      
				p_sys_message_id   [9],          
				p_error_text       [200]; */ 
struct { unsigned short len; unsigned char arr[2]; } p_charged_yn;

struct { unsigned short len; unsigned char arr[2]; } p_status;

struct { unsigned short len; unsigned char arr[3]; } p_err_code;

struct { unsigned short len; unsigned char arr[9]; } p_sys_message_id;

struct { unsigned short len; unsigned char arr[200]; } p_error_text;
      

double p_charged_gross_amt=0.0,p_charged_disc_amt=0.0,p_charged_net_amt=0.0;

/* Fields from table SY_ACC_ENTITY*/
	/* varchar 	//d_acc_entity_name        [61],
				d_acc_entity_name        [300],
				d_user                   [21],
				d_sysdate                [30],
				d_sysdate1                [30]; */ 
struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[30]; } d_sysdate;

struct { unsigned short len; unsigned char arr[30]; } d_sysdate1;
 //added for globalisation
		 
 /*INPUT PARAMETERS FROM SY_PROG_PARAM TABLE */
	/* varchar nd_fm_section_code			[2],
			nd_to_section_code			[2],
			nd_type						[2],
			nd_fm_source_type			[5],
			nd_to_source_type			[5],
			nd_print_yn					[6],
			er_msg					  [200],
			cur_date				   [13],
			nd_incl_reflex_yn           [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_fm_section_code;

struct { unsigned short len; unsigned char arr[2]; } nd_to_section_code;

struct { unsigned short len; unsigned char arr[2]; } nd_type;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_source_type;

struct { unsigned short len; unsigned char arr[5]; } nd_to_source_type;

struct { unsigned short len; unsigned char arr[6]; } nd_print_yn;

struct { unsigned short len; unsigned char arr[200]; } er_msg;

struct { unsigned short len; unsigned char arr[13]; } cur_date;

struct { unsigned short len; unsigned char arr[2]; } nd_incl_reflex_yn;


	int 	nd_fm_month ,
			nd_fm_year ,
			nd_to_month ,
			nd_to_year ,
			er_msg_type=0;

	int		m_month,
			m_year,
			a_month,
			a_year,
			t_month,
			t_year;

/* FIELDS from DECLARING VARIABLES(COLUMN HEADINGS) IN DCLR_MONTH_VARIABLES()*/
	/* varchar x_date		[21] ,
			v_date		[30],
			v_date1		[30], //added for globalisation
			w_date		[30],
			w_date1		[30], //added for globalisation
			q_date		[21]; */ 
struct { unsigned short len; unsigned char arr[21]; } x_date;

struct { unsigned short len; unsigned char arr[30]; } v_date;

struct { unsigned short len; unsigned char arr[30]; } v_date1;

struct { unsigned short len; unsigned char arr[30]; } w_date;

struct { unsigned short len; unsigned char arr[30]; } w_date1;

struct { unsigned short len; unsigned char arr[21]; } q_date;


	/* varchar h_head		[8]; */ 
struct { unsigned short len; unsigned char arr[8]; } h_head;


	/* varchar d_spec_date [12],
			d_spec_date1 [12]; */ 
struct { unsigned short len; unsigned char arr[12]; } d_spec_date;

struct { unsigned short len; unsigned char arr[12]; } d_spec_date1;

	/***************added for globalisation*************************/
	/* varchar		l_translated_value		 [500],
	language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;


	int i;
	/***************added for globalisation*************************/
	int month[14];
	int year[14];
    long mnth_yr[14]; 
	int j_month, j_year;

	int  l_tab_exists ;

	
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
 
char string_var[100] ;


/************************************************/
char string_var[100],tmpbuf[100];
int line_no = 0;
int page_no = 0 ;
long total_count = 0;
long g_total_count = 0;
int mon_incr = 0;
int tot_incr = 0;
char local_legend[35][500];//added for globalisation
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1];

FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
   void get_params();
   void get_header_dtls();
   void gen_file_name();
   void do_report();
   void do_footer();     
   
   if(argc < 4) {
     disp_message(ORA_MESG,"Usage rlrexcch uid/passwd session_id pgm_date\n");
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

  

   if(OERROR)
      disp_message(ORA_MESG,"Failed to connect using : \n");

#ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
#endif
    
	set_meduser_role();
	get_params();
/*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	get_legend_value(33); 
/*********************** added for globalisation ******************************/
	get_header_dtls();
	gen_file_name(); 
	do_report();

	do_footer();  
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

void do_report()
{
	void dclr_source_cur();
	void close_test_cur();
	void close_test_cur_no_reflex();
	void chk_break(int lin_no);

	void dclr_test_cur();
	void dclr_test_cur_no_reflex();

	void get_source_name();
	void get_section_name();
	void get_test_name();	

	void print_rep_header();
	void print_page_header();	
	void print_cont_header();	

	void print_source_col_heading();
	

	char temp_source_name[11];
	char temp_episode_name[18];
	char temp_test_name[11];
	char flag_1 = 'N';
	char flag_2 = 'N';
	char flag_3 = 'N';
	char f_section = 'N';
	char f_source = 'N';
	char first_time = 'Y';

	int i =0,status=0;

	strcpy(temp_source_name, " ");
	strcpy(temp_episode_name, " ");
	strcpy(temp_test_name, " ");

	line_no = 0;
    page_no = 0;

    if (strcmp(nd_incl_reflex_yn.arr, "Y") == 0)
	{
		dclr_test_cur();
	}
	else
	{
	 	dclr_test_cur_no_reflex();
	}

	print_rep_header();
    while(fetch_test_cur())
	{

	  get_source_name();
	  get_test_name();	  
      fetch_patient_desc();
	 		  
	 strcpy(temp_test_name, " ");
		  if (flag_1 == 'N')
		  {
			 flag_1 = 'Y';			 
			 print_page_header();
			 print_cont_header();			 			 
		  }
	  status = get_rev_details();	      

	if (p_charged_yn.arr[0] == 'N')
	{
	  sprintf(temp_episode_name,"%-12d/%04d",d_episode_no,d_tfr_visit_no);	  	
      fprintf(f1,"%-20s%-60s \n",d_patient_id.arr,patient_name.arr);			  	  	  
	  fprintf(f1,"%-20s%-5s %-20.20s    %-15s %12s\n",temp_episode_name,d_source_code.arr,d_source_name.arr,txt_specimen_no.arr,d_spec_date1.arr);
	  
	  if ( strcmp(d_reflex_type.arr,"X") != 0)
		fprintf(f1,"%-11s%-4s%-37.37s%26s \n",d_test_code.arr,"[R]",d_test_name.arr,d_added_by_id.arr);
	  else
		fprintf(f1,"%-15s%-37.37s%26s \n",d_test_code.arr,d_test_name.arr,d_added_by_id.arr);

	  fprintf(f1,"\n");			  	  
	  line_no = line_no+4;
	  chk_break(4);
     }
	}
		        
	if (strcmp(nd_incl_reflex_yn.arr,"Y") == 0)
		close_test_cur();
	else
		close_test_cur_no_reflex();

}

/********* DECLARE TEST_CURSOR **********/
void dclr_test_cur()
 {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

 
	/* EXEC SQL DECLARE TEST_CURSOR CURSOR FOR
			SELECT to_char(A.specimen_no),A.source_type,
				   // DECODE(A.episode_type, 'R', NVL(A.customer_code, A.patient_id), NVL(A.patient_id,'')),
				   NVL(A.patient_id,''),
				   NVL(A.customer_code, ''),
				   A.source_code,  B.test_code,
				   TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY'),
				   A.episode_type, A.episode_no, A.tfr_visit_no,
				   NVL(B.reflex_type, 'X') ,B.line_no,A.added_by_id
			FROM RL_REQUEST_HEADER A, RL_REQUEST_DETAIL B
			WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E','H','E',:nd_type)
			AND A.source_code BETWEEN DECODE(:nd_fm_source_type,'!!!!',A.source_code,:nd_fm_source_type)
			AND DECODE(:nd_to_source_type,'~~~~',A.source_code,:nd_to_source_type)
			AND A.spec_regd_date_time >= TO_DATE(:v_date, 'DD/MM/YYYYhh24:mi:ss')			
			AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYYhh24:mi:ss')
			AND A.specimen_no = B.specimen_no 			
			AND NVL(A.cancelled_yn,'N') != 'Y'
			AND NVL(B.cancelled_yn,'N') != 'Y'
			ORDER BY A.specimen_no,A.section_code, A.source_type, 
					 A.source_code, B.test_code; */ 
					 		

	 /* EXEC SQL OPEN test_cursor; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0003;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )51;
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
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_source_type;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_source_type;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_source_type;
  sqlstm.sqhstl[7] = (unsigned int  )7;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
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
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )106;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_test_cur() occured....\n");
   proc_exit();	
 }

/********* DECLARE TEST_CURSOR EXCLUDING REFLEX TEST **********/
void dclr_test_cur_no_reflex()
 {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

 
	/* EXEC SQL DECLARE TEST_CURSOR_NO_REFLEX CURSOR FOR
			SELECT to_char(A.specimen_no),A.source_type,
				   // DECODE(A.episode_type, 'R', NVL(A.customer_code, A.patient_id), NVL(A.patient_id,'')),	 
   				   NVL(A.patient_id,''),
				   NVL(A.customer_code, ''),
				   A.source_code,  B.test_code, 
				   TO_CHAR(A.spec_regd_date_time, 'DD/MM/YYYY'),
				   A.episode_type, A.episode_no, A.tfr_visit_no,
				   NVL(B.reflex_type, 'X'), B.line_no,A.added_by_id
			FROM RL_REQUEST_HEADER A, RL_REQUEST_DETAIL B
			WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND A.source_type = DECODE(:nd_type, 'A', A.source_type, 'R', 'E','H','E',:nd_type)
			AND A.source_code BETWEEN DECODE(:nd_fm_source_type,'!!!!',A.source_code,:nd_fm_source_type)
			AND DECODE(:nd_to_source_type,'~~~~',A.source_code,:nd_to_source_type)
			AND A.spec_regd_date_time >= TO_DATE(:v_date, 'DD/MM/YYYYhh24:mi:ss')			
			AND A.spec_regd_date_time < TO_DATE(:w_date,'DD/MM/YYYYhh24:mi:ss')
			AND A.specimen_no = B.specimen_no
			AND NVL(A.cancelled_yn,'N') != 'Y'
			AND NVL(B.cancelled_yn,'N') != 'Y'
			AND B.REFLEX_TYPE IS NULL
			ORDER BY A.specimen_no,A.section_code, A.source_type,
					 A.source_code, B.test_code; */ 


	 /* EXEC SQL OPEN test_cursor_no_reflex; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0005;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )121;
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
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_source_type;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_source_type;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_source_type;
  sqlstm.sqhstl[7] = (unsigned int  )7;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
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
    printf("leaving dclr_test_cur_no_reflex()\n");
    fflush(stdout);
#endif

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )176;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_test_cur_no_reflex() occured....\n");
   proc_exit();	
 }

void close_test_cur()
 {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL CLOSE test_cursor; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )191;
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
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )206;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at close_test_cur() occured....\n");
   proc_exit();	
 }

void close_test_cur_no_reflex()
 {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL CLOSE test_cursor_no_reflex; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )221;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}


#ifdef DEBUG
    printf("leaving close_test_cur_no_reflex()\n");
    fflush(stdout);
#endif

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )236;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at close_test_cur_no_reflex() occured....\n");
   proc_exit();	
 }

 /*************** FETCH TEST CURSOR ***************/
int fetch_test_cur()
{
  d_test_code.arr[0]                = '\0';
  d_section_code.arr[0]				= '\0';
  d_source_type.arr[0]				= '\0';
  d_source_code.arr[0]				= '\0';
  d_spec_date.arr[0]				= '\0';
  d_episode_type.arr[0]				= '\0';
  d_patient_id.arr[0]			    = '\0';
  txt_specimen_no.arr[0]		    = '\0';	
  d_added_by_id.arr[0]				= '\0';
  d_reflex_type.arr[0]              = '\0';
  d_customer_code.arr[0]            = '\0';


  d_test_code.len                   = 0;
  d_section_code.len				= 0;
  d_source_type.len					= 0;
  d_source_code.len					= 0;
  d_spec_date.len					= 0;
  d_episode_type.len				= 0;
  d_patient_id.len					= 0;
  txt_specimen_no.len				= 0;
  d_added_by_id.len					= 0;
  d_reflex_type.len					= 0;
  d_episode_no                      = 0;
  d_tfr_visit_no                    = 0;
  d_customer_code.len               = 0;



  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  
   if (strcmp(nd_incl_reflex_yn.arr,"Y") == 0)
   {

	/* EXEC SQL FETCH TEST_CURSOR INTO
		:txt_specimen_no, :d_source_type,:d_patient_id,:d_customer_code,
		:d_source_code, :d_test_code,  :d_spec_date, 
		:d_episode_type,:d_episode_no, :d_tfr_visit_no, 
		:d_reflex_type, :d_line_no, d_added_by_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )251;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&txt_specimen_no;
 sqlstm.sqhstl[0] = (unsigned int  )17;
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
 sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_customer_code;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_source_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
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
 sqlstm.sqhstl[6] = (unsigned int  )14;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_episode_no;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_tfr_visit_no;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_reflex_type;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_line_no;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_added_by_id;
 sqlstm.sqhstl[12] = (unsigned int  )33;
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
   else
   {
	/* EXEC SQL FETCH TEST_CURSOR_NO_REFLEX INTO
		:txt_specimen_no, :d_source_type,:d_patient_id,:d_customer_code,
		:d_source_code, :d_test_code,  :d_spec_date, 
		:d_episode_type,:d_episode_no, :d_tfr_visit_no, 
		:d_reflex_type, :d_line_no,d_added_by_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )318;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&txt_specimen_no;
 sqlstm.sqhstl[0] = (unsigned int  )17;
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
 sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_customer_code;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_source_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
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
 sqlstm.sqhstl[6] = (unsigned int  )14;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_episode_no;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_tfr_visit_no;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_reflex_type;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_line_no;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_added_by_id;
 sqlstm.sqhstl[12] = (unsigned int  )33;
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
  
				
#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif


  if (NODATAFOUND)
    return 0;


  d_test_code.arr[d_test_code .len]			= '\0';
  d_section_code.arr[d_section_code.len]	= '\0';
  d_source_code.arr[d_source_code.len]		= '\0';
  d_source_type.arr[d_source_type.len]		= '\0';
  d_spec_date.arr[d_spec_date.len]			= '\0';
  txt_specimen_no.arr[txt_specimen_no.len]  = '\0';
  d_episode_type.arr[d_episode_type.len]	= '\0';
  d_patient_id.arr[d_patient_id.len]		= '\0';
  d_added_by_id.arr[d_added_by_id.len]		= '\0';
  d_reflex_type.arr[d_reflex_type.len]      = '\0';
  d_customer_code.arr[d_customer_code.len]  = '\0';

        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_spec_date,'DD/MM/YYYY'), :language_id , t_date);
				:d_spec_date1 := to_char(t_date,'DD/MM/YYYY');
				END;
			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 13;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT\
_TO_LOCALE_DATE ( to_date ( :d_spec_date , 'DD/MM/YYYY' ) , :language_id , t_d\
ate ) ; :d_spec_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )385;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_spec_date;
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
        sqlstm.sqhstv[2] = (         void  *)&d_spec_date1;
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
        if (sqlca.sqlcode < 0) goto err_exit;
}




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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )412;
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


	if ( strcmp(d_source_type.arr,"C") == 0)
	{
   				/* EXEC SQL SELECT LONG_DESC 
				INTO :d_source_name
				FROM OP_CLINIC_LANG_VW 
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND clinic_code = :d_source_code
				AND LANGUAGE_ID = :language_id; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 13;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select LONG_DESC into :b0  from OP_CLINIC_LANG_VW wher\
e ((FACILITY_ID=:b1 and clinic_code=:b2) and LANGUAGE_ID=:b3)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )427;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&d_source_name;
       sqlstm.sqhstl[0] = (unsigned int  )102;
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

       	
	}
	else
	{
		if (strcmp(d_source_type.arr,"W") == 0) 
		{
		
				/* EXEC SQL 
				/oSELECT LONG_DESC
				INTO :d_source_name
				FROM IP_WARD 
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND ward_code = :d_source_code;
				o/
				SELECT LONG_DESC
				INTO :d_source_name
				FROM IP_NURSING_UNIT_LANG_VW 
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND NURSING_UNIT_code = :d_source_code
				AND LANGUAGE_ID = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from IP_NURSING_UNIT_LANG_VW w\
here ((FACILITY_ID=:b1 and NURSING_UNIT_code=:b2) and LANGUAGE_ID=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )458;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_source_name;
    sqlstm.sqhstl[0] = (unsigned int  )102;
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


		}
		else
		{
			if ( (strcmp(d_source_type.arr,"R") == 0 ) || (strcmp(d_source_type.arr,"E") == 0 ) )
			{
					/* EXEC SQL SELECT LONG_DESC
					INTO :d_source_name
					FROM RL_REFERRAL_LANG_VW 
					WHERE referral_code = :d_source_code
					AND LANGUAGE_ID = :language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RL_REFERRAL_LANG_VW wher\
e (referral_code=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )489;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_source_name;
     sqlstm.sqhstl[0] = (unsigned int  )102;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_source_code;
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )516;
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
	FROM RL_SECTION_CODE
	WHERE section_code = :d_section_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_name into :b0  from RL_SECTION_CODE where sectio\
n_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )531;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )554;
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


	/* EXEC SQL SELECT long_desc
	INTO :d_test_name
	FROM RL_TEST_CODE_LANG_VW 
	WHERE test_code = :d_test_code
	AND LANGUAGE_ID = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_TEST_CODE_LANG_VW where (\
test_code=:b1 and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )569;
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
   sqlstm.arrsiz = 13;
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


   disp_message(ORA_MESG,"Oracle error at get_test_name() occured....\n");
   proc_exit();	
  }

print_month_col_heading()
{

    m_month = 0;
	m_year = 0;
	a_month = 0;
	a_year = 0;

	h_head.arr[0]		= '\0';
	h_head.len			= 0;


	strcpy(x_date.arr, v_date.arr);
	x_date.len = strlen(x_date.arr);

//	fprintf(f1, "Test        Description     ");
	fprintf(f1, "%-4.4s        %-11.11s     ", local_legend[1], local_legend[2]); //added for globalisation
	//fprintf(f1, "Description     ");

   	   /* EXEC SQL SELECT TO_DATE(:q_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 13;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select (TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b1,'DD/MM/Y\
YYY')) into :b2  from DUAL ";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )611;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&q_date;
       sqlstm.sqhstl[0] = (unsigned int  )23;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&x_date;
       sqlstm.sqhstl[1] = (unsigned int  )23;
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
	   
	  /* EXEC SQL SELECT TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'MM/YYYY')
			INTO :h_head FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'MM/YYYY') into :\
b1  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )638;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&x_date;
   sqlstm.sqhstl[0] = (unsigned int  )23;
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

	   fprintf(f1,"%-7s", h_head.arr);
	   fprintf(f1, " ");

	   /* EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:x_date, 'DD/MM/YYYY'), 1), 'DD/MM/YYYY')
			INTO :x_date FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),1),'D\
D/MM/YYYY') into :b0  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )661;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&x_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&x_date;
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


	
	   x_date.arr[x_date.len]		= '\0';

	   /* EXEC SQL SELECT TO_DATE(:q_date, 'DD/MM/YYYY') - 
			TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b1,'DD/MM/YYYY\
')) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )684;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&q_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&x_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
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

//	fprintf(f1, "Total");
	fprintf(f1, "%s", local_legend[3]); //added for globalisation

	fprintf(f1,"\n-------------------------------------------------------------------------------");
	fprintf(f1,"----------------------------------------------------") ;
	fprintf(f1,"\n") ;

	line_no += 2;

}

/************** PRINT DEPARTMENT COLUMN HEADING ***************/
void print_dept_col_heading()
{
 fprintf(f1, "\n");
// fprintf(f1,"Dept : %s",d_section_name.arr);
 fprintf(f1,"%-4.4s : %s",local_legend[4], d_section_name.arr); //added for globalisation
 fprintf(f1,"\n-----------------------------------");
 line_no += 2;
 total_records++ ;
}

/***************PRINT SOURCE COLUMN HEADING *************/
void print_source_col_heading()
{
 fprintf(f1, "\n");
// fprintf(f1,"Source : %s",d_source_name.arr );
 fprintf(f1,"%-5.5s : %s",local_legend[5], d_source_name.arr ); //added for globalisation
 fprintf(f1,"\n");
 fprintf(f1,"-----------------------------------");
 fprintf(f1,"\n");
 line_no +=3 ;
}


void chk_break(int lin)
{
   if ((line_no + lin) >= MAX_LINES)
   {
     fprintf(f1,"\f");	 
	 print_page_header();	 
	 print_cont_header();
	 line_no += 1;
   }
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
	
	nd_incl_reflex_yn.arr[0]        = '\0';
	nd_incl_reflex_yn.len           = 0;

	v_date.arr[0]					= '\0';
	v_date.len						= 0;
	w_date.arr[0]					= '\0';
	w_date.len						= 0;
	q_date.arr[0]					= '\0';
	q_date.len						= 0;

   

   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
            LTRIM(RTRIM(PARAM1)),
		    PARAM2,
		    PARAM3,
		    PARAM4,
		    PARAM5,
			PARAM6
		    INTO 
		    :nd_operating_facility_id,		    
		    :nd_type ,
		    :nd_fm_source_type ,
		    :nd_to_source_type ,
		    :v_date ,
		    :w_date,
			:nd_incl_reflex_yn
            FROM SY_PROG_PARAM
	        WHERE   UPPER(PGM_ID) = 'RLREXCCH'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,LTRIM(RTRIM(PARAM1)) ,PARAM2\
 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PRO\
G_PARAM where ((UPPER(PGM_ID)='RLREXCCH' and SESSION_ID=TO_NUMBER(:b7)) and PG\
M_DATE=:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )711;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_source_type;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_source_type;
   sqlstm.sqhstl[3] = (unsigned int  )7;
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
   sqlstm.sqhstv[6] = (         void  *)&nd_incl_reflex_yn;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[8] = (unsigned int  )22;
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


	

   if(OERROR)
      disp_message(ORA_MESG,"get_parameter_function2 : \n");
   
  nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';  
  nd_type.arr[nd_type.len]                              = '\0';
  nd_fm_source_type.arr[nd_fm_source_type.len] 			= '\0';
  nd_to_source_type.arr[nd_fm_source_type.len] 			= '\0';
  v_date.arr[v_date.len]								= '\0';
  w_date.arr[w_date.len]								= '\0';
  nd_incl_reflex_yn.arr[nd_incl_reflex_yn.len]          = '\0';

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
	        WHERE UPPER(PGM_ID) = 'RLREXCCH'
	        AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLREXCC\
H' and SESSION_ID=TO_NUMBER(:b0)) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )762;
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )785;
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


   /* EXEC SQL SELECT ACC_ENTITY_NAME,
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI:SS')
	       INTO :d_acc_entity_name,
		   :d_user,
		   :d_sysdate
            FROM SY_ACC_ENTITY_lang_vw
			WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			and language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI:SS') into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID\
=:b3 and language_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )800;
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
   sqlstm.sqhstl[2] = (unsigned int  )32;
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )835;
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
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);

	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
    
}

/*********** PRINT REPORT HEADER **************/

void print_rep_header()
{
  char nd_fm_section_desc[10],
       nd_to_section_desc[10];
  int rec_len; //added for globalisation

  #ifdef DEBUG
      printf("before report header()\n");
  #endif
  print_page_header();

  #ifdef DEBUG
      printf("after page header()\n");   
  #endif
  
  get_version_no();   

  fprintf(f1,"%s\n",d_version.arr);

  fprintf(f1,"\n\n\n\n");
//  fprintf(f1,"                ");
//  fprintf(f1,"INPUT PARAMETERS :\n");
  rec_len = strlen(local_legend[6]);//added for globalisation
  print_space(43, rec_len,1);//added for globalisation
  fprintf(f1,"%s:\n", local_legend[6]);//added for globalisation
//  fprintf(f1,"                ");
//  fprintf(f1,"------------------\n\n");
  print_space(43, rec_len,1);//added for globalisation
  print_space(43, rec_len,0);//added for globalisation
  fprintf(f1,"\n\n");//added for globalisation
//  fprintf(f1,"                ");
//  fprintf(f1,"SOURCE TYPE    : %s\n",nd_type.arr);
  rec_len = strlen(local_legend[7]);//added for globalisation
  print_space(43, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[7], nd_type.arr); //added for globalisation
//  fprintf(f1,"                ");
//  fprintf(f1,"FROM SOURCE    : %s\n",nd_fm_source_type.arr);
  rec_len = strlen(local_legend[8]);//added for globalisation
  print_space(43, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[8], nd_fm_source_type.arr); //added for globalisation
//  fprintf(f1,"                ");
//  fprintf(f1,"TO SOURCE      : %s\n",nd_to_source_type.arr);
  rec_len = strlen(local_legend[9]);//added for globalisation
  print_space(43, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[9], nd_to_source_type.arr); //added for globalisation
//  fprintf(f1,"                ");
//  fprintf(f1,"SPEC FROM DATE : %s\n",v_date.arr);
        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:v_date,'DD/MM/YYYY hh24:mi:ss'), :language_id , t_date);
				:v_date1 := to_char(t_date,'DD/MM/YYYY hh24:mi:ss');
				END;
			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 13;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT\
_TO_LOCALE_DATE ( to_date ( :v_date , 'DD/MM/YYYY hh24:mi:ss' ) , :language_id\
 , t_date ) ; :v_date1 := to_char ( t_date , 'DD/MM/YYYY hh24:mi:ss' ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )850;
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
        sqlstm.sqhstv[1] = (         void  *)&language_id;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&v_date1;
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



  rec_len = strlen(local_legend[10]);//added for globalisation
  print_space(43, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[10], v_date1.arr); //added for globalisation
//  fprintf(f1,"                ");
//  fprintf(f1,"SPEC TO   DATE : %s\n",w_date.arr);
        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:w_date,'DD/MM/YYYY hh24:mi:ss'), :language_id , t_date);
				:w_date1 := to_char(t_date,'DD/MM/YYYY hh24:mi:ss');
				END;
			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 13;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT\
_TO_LOCALE_DATE ( to_date ( :w_date , 'DD/MM/YYYY hh24:mi:ss' ) , :language_id\
 , t_date ) ; :w_date1 := to_char ( t_date , 'DD/MM/YYYY hh24:mi:ss' ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )877;
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
        sqlstm.sqhstv[1] = (         void  *)&language_id;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&w_date1;
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



  rec_len = strlen(local_legend[11]);//added for globalisation
  print_space(43, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[11], w_date1.arr); //added for globalisation
//  fprintf(f1,"                ");
//  fprintf(f1,"INCLUDE REFLEX : %s\n",nd_incl_reflex_yn.arr);
  rec_len = strlen(local_legend[12]);//added for globalisation
  print_space(43, rec_len,1);//added for globalisation
  fprintf(f1,"%s: %s\n", local_legend[12], nd_incl_reflex_yn.arr); //added for globalisation
  fprintf(f1,"\n\n\n");
  fprintf(f1,"                ");
//  fprintf(f1,"[R] - Reflex Test");
  fprintf(f1,"[R] - %s", local_legend[13]);//added for globalisation
  fprintf(f1,"\n\n\n\n\n");
  fprintf(f1,"\f");      
}


/************ PRINT PAGE HEADER ****************/
void print_page_header()
{
 register int i;
 char nd_fm_section_desc[10],
       nd_to_section_desc[10];
 int spc_len;
 char buf[15]; //added for globalisation
 int col;// added for globalisation

 line_no = 0;
 page_no = page_no+1;

  
  fill_dash(78);
/*  fprintf(f1,"MDL : RL");
  spc_len = 15;
  for(i=1;i<=spc_len;i++)
  fprintf(f1," ");
  fprintf(f1,"%-30s", d_acc_entity_name.arr);
  spc_len = 6;
  for(i=1;i<=spc_len;i++)
  fprintf(f1," ");
  fprintf(f1,"%s", d_sysdate.arr);
  fprintf(f1,"\n"); 
*/

  memset(hdr_line1,' ',REP_WIDTH+1);
  strncpy(hdr_line1,"MDL : RL",8);
  col = (int)(REP_WIDTH - strlen(d_acc_entity_name.arr))/2;
  strncpy(hdr_line1 + col -1,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET\
_CURRENT_DATE ( :language_id ) ; :d_sysdate1 := to_char ( t_date , 'DD/MM/YYYY\
 HH24:MI' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )904;
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


	col = (REP_WIDTH-strlen(d_sysdate1.arr));
	strcpy(hdr_line1+col+1,d_sysdate1.arr);
  fprintf(f1,"\n");	
  fprintf(f1,hdr_line1);
  fprintf(f1,"\n");	

 fprintf(f1,"OPR : %s", d_user.arr);
// fprintf(f1,"              List of Tests not Charged             \n");
  memset(hdr_line2,' ',REP_WIDTH+1);
  col = (int)(REP_WIDTH - strlen(local_legend[14]))/2;
  strncpy(hdr_line2+ col -1,local_legend[14],strlen(local_legend[14]));
  fprintf(f1,hdr_line2);
  fprintf(f1,"\n");	

 fprintf(f1,"REP : RLREXCCH");
 fprintf(f1,"                                        ") ;
// fprintf(f1,"            Page : %4d", page_no);
 fprintf(f1,"            %-4.4s : %4d", local_legend[15],page_no);
 fprintf(f1,"\n");
 fill_dash(78);
 fprintf(f1,"\n");
 line_no = line_no + 8;
}

void print_cont_header()
{
 register int i;
 char nd_fm_section_desc[10],
       nd_to_section_desc[10];
 char loc_legend1[41];
 char loc_legend2[41];
 char loc_legend3[41];
 char loc_legend4[41];
 char loc_legend5[41];
 char loc_legend6[41];
 char loc_legend7[41];
 char loc_legend8[41];
 char loc_legend9[41];
 char loc_legend10[41];
 char loc_legend11[41];
 char loc_legend12[41];
 int spc_len;

// strcpy(loc_legend1,"Patient ID");
 strcpy(loc_legend1,local_legend[16]); //added for globalisation
 loc_legend1[10] = '\0';

// strcpy(loc_legend2,"Name");
 strcpy(loc_legend2,local_legend[17]); //added for globalisation
 loc_legend2[5] = '\0';

// strcpy(loc_legend3,"Episode     /Visit");
 strcpy(loc_legend3,local_legend[18]); //added for globalisation
 loc_legend3[19] = '\0';

// strcpy(loc_legend4,"Visit");
 strcpy(loc_legend4,local_legend[19]); //added for globalisation
 loc_legend4[6] = '\0';

// strcpy(loc_legend5,"Source");
 strcpy(loc_legend5,local_legend[5]); //added for globalisation
 loc_legend5[7] = '\0';

// strcpy(loc_legend6,"Name");
 strcpy(loc_legend6,local_legend[17]); //added for globalisation
 loc_legend6[5] = '\0';

// strcpy(loc_legend7,"Spec No");
 strcpy(loc_legend7,local_legend[20]); //added for globalisation
 loc_legend7[8] = '\0';

// strcpy(loc_legend8,"Test Code");
 strcpy(loc_legend8,local_legend[21]); //added for globalisation
 loc_legend8[10] = '\0';

// strcpy(loc_legend9,"Name");
 strcpy(loc_legend9,local_legend[17]); //added for globalisation
 loc_legend9[5] = '\0';

 strcpy(loc_legend10,"Test Date");
 strcpy(loc_legend10,local_legend[22]); //added for globalisation
 loc_legend10[9] = '\0';

// strcpy(loc_legend11,"Added By ID");
 strcpy(loc_legend11,local_legend[23]); //added for globalisation
 loc_legend11[12] = '\0';
	
 fprintf(f1,"\n") ;	
  
fprintf(f1,"%-20s%-60s \n",loc_legend1, loc_legend2);

fprintf(f1,"%-20s%-6s %-20s   %-15s %12s\n",loc_legend3,loc_legend5,loc_legend6,loc_legend7,loc_legend10);
fprintf(f1,"%-15s%-37s%26s\n",loc_legend8,loc_legend9,loc_legend11);
line_no = line_no + 4;
fill_dash(78);  
line_no = line_no + 1;
}

initialize_array()
{

    int i = 0;
	int k = 0;

	m_month = 0;
	m_year = 0;
	a_month = 0;
	a_year = 0;

	tot_incr = 0;

	strcpy(x_date.arr, v_date.arr);
	x_date.len = strlen(x_date.arr);

	for(k=0;k<13;k++)
	{
		month[k] = 0;
		year[k]	= 0;
	}


	/* EXEC SQL SELECT TO_NUMBER(TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'MM'))
	INTO :t_month FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'MM')) in\
to :b1  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )927;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&x_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'YYYY')) \
into :b1  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )950;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&x_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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


	
    /* EXEC SQL SELECT TO_DATE(:q_date, 'DD/MM/YYYY') - 
		 TO_DATE(:x_date, 'DD/MM/YYYY') 
    INTO :m_month
    FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b1,'DD/MM/YYYY\
')) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )973;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&q_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&x_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
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



    month[i] = t_month;
    year[i]	 = t_year;

	while(m_month >= 0)
	{

	   tot_incr++;


	   /* EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:x_date, 'DD/MM/YYYY'), 1), 'DD/MM/YYYY')
			INTO :x_date FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),1),'D\
D/MM/YYYY') into :b0  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1000;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&x_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&x_date;
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



	   x_date.arr[x_date.len]		= '\0';

	   /* EXEC SQL SELECT TO_NUMBER(TO_CHAR(TO_DATE(:x_date, 'DD/MM/YYYY'), 'MM'))
	   INTO :t_month FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'MM'))\
 into :b1  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1023;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&x_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_NUMBER(TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'YYYY'\
)) into :b1  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1046;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&x_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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




   	   /* EXEC SQL SELECT TO_DATE(:q_date, 'DD/MM/YYYY') - TO_DATE(:x_date, 'DD/MM/YYYY') 
	   INTO :m_month
	   FROM DUAL; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 13;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select (TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b1,'DD/MM/Y\
YYY')) into :b2  from DUAL ";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1069;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&q_date;
       sqlstm.sqhstl[0] = (unsigned int  )23;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&x_date;
       sqlstm.sqhstl[1] = (unsigned int  )23;
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
	   month[i] = t_month;
	   year[i]	= t_year;


	}

}

void do_footer()
{
   chk_break(4);
   fprintf(f1,"\n\n %15s   ***  END OF REPORT ***\n\f"," ");
   fflush(f1);
}


get_version_no()
{

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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1096;
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
	    /**
		EXEC SQL SELECT VERSION_NO INTO :d_version_no 
                 FROM   SM_INSTALLATION; 
        **/
		
		strcpy(d_version_no.arr,"4.1");

		//d_version_no.arr[d_version_no.len] = '\0';
		d_version_no.arr[strlen(d_version_no.arr)] = '\0';
		
		
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

int get_rev_details()
 {

    /** manipulate the Patient ID for external patients 
        and episode type to R if episode type is H   
	 **/

	strcpy(nd_patient_id.arr, d_patient_id.arr);

	if (strcmp(d_episode_type.arr, "R") == 0)
	  strcpy(nd_patient_id.arr, d_customer_code.arr);

	nd_patient_id.len = strlen(nd_patient_id.arr);

	strcpy(nd_episode_type.arr, d_episode_type.arr);

	if (strcmp(d_episode_type.arr, "H") == 0)
	  strcpy(nd_episode_type.arr, "R");

	nd_episode_type.len = strlen(nd_episode_type.arr);

/******
 commented as this procedure is not available in srdv, needs to be reviewed later

	EXEC SQL EXECUTE 
			 BEGIN
				BL_PROC_FOR_EXT_SERVICE.GET_PAT_CHARGE_AMT_FOR_TEST 
				(
				 :nd_operating_facility_id,                  	
				 :nd_patient_id,                  	
				 :nd_episode_type,
				 :d_episode_no,
				 :d_tfr_visit_no,
				 'RL',                    	
				 :txt_specimen_no,                    	
				 :d_line_no,
				 :d_test_code,                   
				 :p_charged_yn,
				 :p_charged_gross_amt,
				 :p_charged_disc_amt,
				 :p_charged_net_amt,
				 :p_status,
				 :p_err_code,
				 :p_sys_message_id,
				 :p_error_text);    		
		END;
	END-EXEC;
	********/		
/* Commented on 07-09-2004
		if (strcmp(p_err_code.arr,"10") == 0)
		   {	
				sprintf(string_var," Error:%s in BL_PROC_FOR_EXT_SERVICE.GET_PAT_CHARGE_AMT_FOR_TEST \n", p_error_text.arr);
				disp_message(ERR_MESG, string_var);										
		   }
*/
     return 1;

}


int fetch_patient_desc()
{
    patient_name.arr[0]	= '\0';	
    patient_name.len		= 0;
	
    if (strcmp(d_episode_type.arr, "I") == 0 || 
				strcmp(d_episode_type.arr, "O") == 0 ||
				strcmp(d_episode_type.arr, "H") == 0)
     {
		/* EXEC SQL SELECT DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG) SHORT_NAME
				   INTO :patient_name
				   FROM MP_PATIENT_MAST
				  WHERE PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG)\
 SHORT_NAME into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1115;
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
  sqlstm.sqhstv[1] = (         void  *)&patient_name;
  sqlstm.sqhstl[1] = (unsigned int  )63;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
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


				  
	 }
	else
	 {
	   /* EXEC SQL SELECT DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG) short_name
				  INTO :patient_name
				  FROM RL_PATIENT_MAST
				 WHERE PATIENT_ID = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LAN\
G) short_name into :b1  from RL_PATIENT_MAST where PATIENT_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1142;
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
    sqlstm.sqhstv[1] = (         void  *)&patient_name;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
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


				 
	 }	

    if (OERROR) 
	{
	      sprintf(string_var,"Error when fetching the patient name:%s\n",sqlca.sqlerrm.sqlerrmc);	
	      disp_message(ERR_MESG, string_var);			      
	      return 0;
	}

	patient_name.arr[patient_name.len]           = '\0';
	return 1;
}

fill_dash(flg)
{
  int ini_lp1;
  for (ini_lp1=1;ini_lp1<=flg;ini_lp1++)
	fprintf(f1,"%s","-");
	fprintf(f1,"\n");
}

get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLREXCCH.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLREXCCH.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1169;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLREXCCH.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LREXCCH.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1192;
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

