
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/Rlrspclb.pc"
};


static unsigned int sqlctx = 1288616011;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {12,17};

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

 static const char *sq0008 = 
"select test_code  from rl_request_detail where ((specimen_no=TO_NUMBER(:b0) \
and operating_facility_id=:b1) and NVL(cancelled_yn,'N')<>'Y')           ";

 static const char *sq0009 = 
"select test_code ,TO_CHAR(specimen_no) ,seq_no  from RL_INTERVAL_TEST_SPECIM\
ENS where ((interval_test_specimen_no=TO_NUMBER(:b0) and OPERATING_FACILITY_ID\
=:b1) and specimen_no<>TO_NUMBER(:b0)) order by specimen_no            ";

 static const char *sq0012 = 
"select rownum ,specimen_no  from RL_INTERVAL_TEST_SPECIMENS where (interval_\
test_specimen_no=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) order by specim\
en_no            ";

 static const char *sq0017 = 
"select SAMPLE_ID ,SEQ_NO ,ANATOMY_SITE_CODE  from RL_SAMPLE_DETAILS where ((\
(OPERATING_FACILITY_ID=:b0 and SPECIMEN_NO=TO_NUMBER(:b1)) and TEST_CODE=:b2) \
and NVL(SAMPLE_INDICATOR,'SA') not  in ('NA'))           ";

 static const char *sq0020 = 
"select UNIT_NO  from BD_LAB_SCREEN_GROUP_DTL where ((SPECIMEN_NO=TO_NUMBER(:\
b0) and OPERATING_FACILITY_ID=:b1) and SECTION_CODE=:b2)           ";

 static const char *sq0024 = 
"select container_code ,NVL(volume,0) volume ,volume_unit ,NVL(SUBSTR(long_de\
sc,1,30),' ') long_desc ,ABS((NVL(volume,0)-:b0)) req_volume  from RL_SPECIMEN\
_CONTAINER where (container_code in (select container_code  from RL_AGE_SEX_SP\
EC_TYPE_CONT where (specimen_type_code=:b1 and TO_NUMBER(:b2) between calc_min\
_age_in_days and calc_max_age_in_days)) and NVL(volume_unit,'!!!!')=NVL(:b3,'!\
!!!')) order by req_volume            ";

 static const char *sq0025 = 
"select container_code ,NVL(volume,0) volume ,volume_unit ,NVL(SUBSTR(long_de\
sc,1,30),' ') long_desc ,ABS((NVL(volume,0)-:b0)) req_volume  from RL_SPECIMEN\
_CONTAINER where (container_code in (select container_code  from RL_CONTAINER_\
FOR_SPECIMEN_TYPE where specimen_type_code=:b1) and NVL(volume_unit,'!!!!')=NV\
L(:b2,'!!!!')) order by req_volume            ";

 static const char *sq0026 = 
"select test_code  from rl_request_detail where ((specimen_no=TO_NUMBER(:b0) \
and operating_facility_id=:b1) and NVL(cancelled_yn,'N')<>'Y')           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,211,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,529,0,4,247,0,0,17,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
119,0,0,3,0,0,30,369,0,0,0,0,0,1,0,
134,0,0,4,0,0,30,377,0,0,0,0,0,1,0,
149,0,0,5,163,0,4,392,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
176,0,0,6,198,0,4,431,0,0,6,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
215,0,0,7,235,0,4,444,0,0,8,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,
262,0,0,8,149,0,9,487,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
285,0,0,8,0,0,13,500,0,0,1,0,0,1,0,2,9,0,0,
304,0,0,9,225,0,9,545,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
331,0,0,9,0,0,15,556,0,0,0,0,0,1,0,
346,0,0,9,0,0,13,568,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,
373,0,0,10,152,0,4,592,0,0,5,3,0,1,0,2,3,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
408,0,0,11,159,0,4,607,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
439,0,0,12,171,0,9,628,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
462,0,0,12,0,0,13,639,0,0,2,0,0,1,0,2,3,0,0,2,9,0,0,
485,0,0,13,105,0,4,664,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,3,0,0,
512,0,0,14,126,0,4,755,0,0,1,0,0,1,0,2,9,0,0,
531,0,0,15,224,0,3,807,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
558,0,0,16,75,0,4,825,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
581,0,0,17,211,0,9,847,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
608,0,0,17,0,0,13,863,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,
635,0,0,17,0,0,15,926,0,0,0,0,0,1,0,
650,0,0,8,0,0,15,927,0,0,0,0,0,1,0,
665,0,0,18,93,0,4,1070,0,0,2,1,0,1,0,2,1,0,0,1,9,0,0,
688,0,0,19,61,0,4,1098,0,0,1,0,0,1,0,2,9,0,0,
707,0,0,20,143,0,9,1147,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
734,0,0,20,0,0,13,1149,0,0,1,0,0,1,0,2,9,0,0,
753,0,0,20,0,0,15,1153,0,0,0,0,0,1,0,
768,0,0,21,90,0,4,1173,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
791,0,0,22,85,0,4,1183,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
814,0,0,23,282,0,4,1218,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
845,0,0,24,426,0,9,1249,0,0,4,4,0,1,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
876,0,0,24,0,0,13,1251,0,0,5,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
911,0,0,24,0,0,15,1258,0,0,0,0,0,1,0,
926,0,0,24,0,0,15,1289,0,0,0,0,0,1,0,
941,0,0,25,356,0,9,1311,0,0,3,3,0,1,0,1,3,0,0,1,9,0,0,1,9,0,0,
968,0,0,25,0,0,13,1313,0,0,5,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
1003,0,0,25,0,0,15,1320,0,0,0,0,0,1,0,
1018,0,0,25,0,0,15,1351,0,0,0,0,0,1,0,
1033,0,0,26,149,0,9,1370,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1056,0,0,26,0,0,13,1381,0,0,1,0,0,1,0,2,9,0,0,
1075,0,0,27,211,0,4,1422,0,0,5,3,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1110,0,0,28,139,0,4,1436,0,0,4,2,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1141,0,0,29,97,0,4,1446,0,0,3,1,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,
1168,0,0,26,0,0,15,1519,0,0,0,0,0,1,0,
1183,0,0,30,116,0,4,1640,0,0,3,1,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,
1210,0,0,31,175,0,4,1669,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
};


/*
#define DEBUG
*/

#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define INIT_MESG "Label Printing"  
#define HLINE 54
#define VLINE 10
#define ESC 0x1B
#define OERROR (sqlca.sqlcode < 0)

/*#define SPACE1 0xA1    
#define SPACE2 0x40*/   

#include <stdio.h>  
#include <string.h> 
#include <rl.h>
#include <math.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 
  

/* VARCHAR nd_operating_facility_id   [3],
        nd_facility_id		 	   [3],
        uid_pwd                    [91],
		nd_session_id              [50],
        d_specimen_no              [21],
        d_no_copy                  [2], 
		nd_trx_ind		           [2],
		nd_printer_type            [2],
		nd_ws_no			       [50],

	d_patient_id           [21],
	d_spec_regd_date_time  [20],
	d_spec_regd_date_time1 [10],
	d_dob				   [10],  
	d_pat_dob_no_of_days   [10],
	d_sex				   [2],	
	d_section_code         [6],
	d_specimen_type_code   [5],
	d_episode_type		   [2],
	d_order_id			   [16],
	d_order_type_code	   [5],
    d_test_code            [11],
	d_test_code1           [11],
	d_urgent_indicator	   [2],
	d_pat_name             [61],
	nd_specimen_no		   [21],
	parent_spec_no		   [21],
	r_child_spec_no		   [21],
	d_desc_on_label		   [31],
	d_actual_patient_id	   [21],
	d_source_type		   [2],
	d_source_code		   [11],
	d_ref_location		   [21],
	d_description		   [21],
	er_msg                 [171],
	d_category_code		   [5],
	d_category_year		   [5],
	d_category_no		   [21],	
	d_prep_text			   [41]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[50]; } nd_session_id;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[2]; } d_no_copy;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[2]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[50]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[20]; } d_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[10]; } d_spec_regd_date_time1;

struct { unsigned short len; unsigned char arr[10]; } d_dob;

struct { unsigned short len; unsigned char arr[10]; } d_pat_dob_no_of_days;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[6]; } d_section_code;

struct { unsigned short len; unsigned char arr[5]; } d_specimen_type_code;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[16]; } d_order_id;

struct { unsigned short len; unsigned char arr[5]; } d_order_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_test_code1;

struct { unsigned short len; unsigned char arr[2]; } d_urgent_indicator;

struct { unsigned short len; unsigned char arr[61]; } d_pat_name;

struct { unsigned short len; unsigned char arr[21]; } nd_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } parent_spec_no;

struct { unsigned short len; unsigned char arr[21]; } r_child_spec_no;

struct { unsigned short len; unsigned char arr[31]; } d_desc_on_label;

struct { unsigned short len; unsigned char arr[21]; } d_actual_patient_id;

struct { unsigned short len; unsigned char arr[2]; } d_source_type;

struct { unsigned short len; unsigned char arr[11]; } d_source_code;

struct { unsigned short len; unsigned char arr[21]; } d_ref_location;

struct { unsigned short len; unsigned char arr[21]; } d_description;

struct { unsigned short len; unsigned char arr[171]; } er_msg;

struct { unsigned short len; unsigned char arr[5]; } d_category_code;

struct { unsigned short len; unsigned char arr[5]; } d_category_year;

struct { unsigned short len; unsigned char arr[21]; } d_category_no;

struct { unsigned short len; unsigned char arr[41]; } d_prep_text;

	
 char string_var [100];
 short d_specimen_type_ind;

/*tern  char WORKING_DIR_NAME [75];*/

		int er_msg_type = 0;	
		int err_flag = 0;

		int d_count = 0;
		int i_count = 0;
        int c_count = 0;

   /*------- Added on 16-02-2004 --------*/		
	/* VARCHAR  d_facility_name   [300]	,
			 //d_facility_name   [40]	,
			 d_sample_id	   [6]	,			 
		     d_anatomy_site	   [6]	,
			 d_sample_seq_type [2]	,
			 d_blood_unit	   [21]	,
			 d_container_code  [5]	,
			 vol_specimen_no   [21] ,
			 d_volume_unit	   [5]	,
			 d_unit			   [6]  ; */ 
struct { unsigned short len; unsigned char arr[300]; } d_facility_name;

struct { unsigned short len; unsigned char arr[6]; } d_sample_id;

struct { unsigned short len; unsigned char arr[6]; } d_anatomy_site;

struct { unsigned short len; unsigned char arr[2]; } d_sample_seq_type;

struct { unsigned short len; unsigned char arr[21]; } d_blood_unit;

struct { unsigned short len; unsigned char arr[5]; } d_container_code;

struct { unsigned short len; unsigned char arr[21]; } vol_specimen_no;

struct { unsigned short len; unsigned char arr[5]; } d_volume_unit;

struct { unsigned short len; unsigned char arr[6]; } d_unit;


	    int  d_sample_yn        = 0 ,
			 d_sample_seq           ,
			 d_sample_cnt       = 0	,
			 d_container_volume     ,
			 d_test_volume      = 0	,
			 d_volume	        = 0	,
			 d_no_labels        = 0	,
			 d_total            = 0	,
			 d_con_count        = 0	,
			 d_label_cnt        = 1	,	 
			 d_req_volume		    ,
			 d_testvolume          ;
	    
		char h_ind[3];				 			    

  /*---- For Histopathology -----*/	      
    char h_sampleid[100][6];
    int  h_sampleseq[100];
    char h_anatomysite[100][21];  
    char h_testcode[100][21];
    char h_labeldesc[100][31];
    int  h_volume[100];
    char h_unit[100][5]; 

    int  h_histo_count = 0;	

  /*------ For Volume Unit ------*/	
  struct str_volumeunit
  {
    char v_specimen_no[21];
    char v_testcode[1000];
	int  v_testvolume;
	char v_unit[5];
	char v_labeldesc[31];
	int  v_contvolume;
	int  v_nolabels;
	char v_contcode[5];	
	char v_testdesc[21];
  } s_volumeunit[500];

  /*------ For Interval test ------*/	
  struct str_intervaltest
  {
    char  i_specimen_no[21];
	char i_testcode[21];
	int  i_testvolume;
	char i_unit[5];
	char i_labeldesc[31];
	int  i_contvolume;
	int  i_nolabels;
	char i_contcode[5];	
	char i_testdesc[21];
  } s_intervaltest[500];

  int v_index	= 0,  
      v_interval_index = 0,
      v_i;

/* EXEC SQL END DECLARE SECTION; */ 


char *nd_priority;

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

FILE *f1;
char filename[150];
char nd_filename[150];

  char  *command;
  int i;  

  int total_no_copy = 0;

  char gtt_yn = 'N';

  char g_facility_id[50];

void proc_main(argc,argv)
int argc;
char *argv[];
{

   void dclr_cur();

/**** newly added on 14/01/2003 to suppress the error messages ***/
  	err_flag = 0;  

  if(argc < 10) 
  {
        ins_message(ERR_MESG,"rlrspclb : Usage -  arguments wrong\n");
  }

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);

    strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

    strcpy(g_facility_id, nd_facility_id.arr);
	
	strcpy(d_specimen_no.arr,argv[5]);
    d_specimen_no.len = strlen(d_specimen_no.arr);

	strcpy(d_section_code.arr,argv[6]);
    d_section_code.len = strlen(d_section_code.arr);

	strcpy(d_no_copy.arr,argv[7]);
    d_no_copy.len = strlen(d_no_copy.arr);

   	strcpy(nd_printer_type.arr, argv[8]);
    nd_printer_type.len = strlen(nd_printer_type.arr); 

	strcpy(nd_ws_no.arr, argv[9]);
    nd_ws_no.len = strlen(nd_ws_no.arr); 


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



   /*
	* Enable or Disable tracing
	*/
	EnableOrDisableTracing();

    set_meduser_role();

	d_patient_id.arr[0]				= '\0';
	d_patient_id.len				= 0;
	d_spec_regd_date_time.arr[0]	= '\0';			
	d_spec_regd_date_time.len		= 0;
	d_spec_regd_date_time1.arr[0]	= '\0';
	d_spec_regd_date_time1.len		= 0;
	d_episode_type.arr[0]			= '\0';
	d_episode_type.len				= 0;
	d_specimen_type_code.arr[0]		= '\0';
	d_specimen_type_code.len		= 0;
	d_urgent_indicator.arr[0]		= '\0';
	d_urgent_indicator.len			= 0;
	d_source_code.arr[0]			= '\0';
	d_source_code.len				= 0;
	d_source_type.arr[0]			= '\0';
	d_source_type.len				= 0;
	d_category_code.arr[0]			= '\0';
	d_category_code.len				= 0;
	d_category_year.arr[0]			= '\0';
	d_category_year.len				= 0;
	d_category_no.arr[0]			= '\0';
	d_category_no.len				= 0;
	nd_operating_facility_id.arr[0]	= '\0';
	nd_operating_facility_id.len	= 0;
    d_order_id.arr[0]			    = '\0';
	d_order_id.len			        = 0;	    	
    
	/* EXEC SQL SELECT operating_facility_id,
					patient_id, 
					TO_CHAR(spec_regd_date_time,'DD/MM/YYYY HH24:MI'),		
					TO_CHAR(spec_regd_date_time,'DDMONYY'),		
					specimen_type_code, 
					episode_type,
				    NVL(urgent_indicator, 'R'), 
					order_type_code, 
					order_id, 
					source_code, 
					source_type,
					SUBSTR(category_code, 1, 4), 
					SUBSTR(category_year, 3, 2), 
					SUBSTR(category_number, 1, 10)
			  INTO :nd_operating_facility_id,
				   :d_patient_id, 
				   :d_spec_regd_date_time,
				   :d_spec_regd_date_time1,
				   :d_specimen_type_code INDICATOR :d_specimen_type_ind,
				   :d_episode_type,
				   :d_urgent_indicator, 
				   :d_order_type_code,
				   :d_order_id, 
				   :d_source_code, 
				   :d_source_type,
				   :d_category_code, 
				   :d_category_year, 
				   :d_category_no
			  FROM  rl_request_header
			 WHERE  specimen_no = TO_NUMBER(:d_specimen_no)
			   AND  OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,:nd_facility_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select operating_facility_id ,patient_id ,TO_CHAR(spec_regd_\
date_time,'DD/MM/YYYY HH24:MI') ,TO_CHAR(spec_regd_date_time,'DDMONYY') ,speci\
men_type_code ,episode_type ,NVL(urgent_indicator,'R') ,order_type_code ,order\
_id ,source_code ,source_type ,SUBSTR(category_code,1,4) ,SUBSTR(category_year\
,3,2) ,SUBSTR(category_number,1,10) into :b0,:b1,:b2,:b3,:b4:b5,:b6,:b7,:b8,:b\
9,:b10,:b11,:b12,:b13,:b14  from rl_request_header where (specimen_no=TO_NUMBE\
R(:b15) and OPERATING_FACILITY_ID=DECODE(:b16,'*A',OPERATING_FACILITY_ID,:b16)\
)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
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
 sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_spec_regd_date_time;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_spec_regd_date_time1;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_specimen_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)&d_specimen_type_ind;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_urgent_indicator;
 sqlstm.sqhstl[6] = (unsigned int  )4;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_order_type_code;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_order_id;
 sqlstm.sqhstl[8] = (unsigned int  )18;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_source_code;
 sqlstm.sqhstl[9] = (unsigned int  )13;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_source_type;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_category_code;
 sqlstm.sqhstl[11] = (unsigned int  )7;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_category_year;
 sqlstm.sqhstl[12] = (unsigned int  )7;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_category_no;
 sqlstm.sqhstl[13] = (unsigned int  )23;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[14] = (unsigned int  )23;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[15] = (unsigned int  )5;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[16] = (unsigned int  )5;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
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



 	 nd_operating_facility_id.arr[nd_operating_facility_id.len]	= '\0';
	 d_patient_id.arr[d_patient_id.len]					= '\0';
	 d_spec_regd_date_time.arr[d_spec_regd_date_time.len] = '\0';
	 d_spec_regd_date_time1.arr[d_spec_regd_date_time1.len] = '\0';
	 d_episode_type.arr[d_episode_type.len]				= '\0';
	 d_specimen_type_code.arr[d_specimen_type_code.len]	= '\0';
	 d_urgent_indicator.arr[d_urgent_indicator.len]		= '\0';
	 d_order_type_code.arr[d_order_type_code.len]		= '\0';
	 d_order_id.arr[d_order_id.len]						= '\0';
	 d_source_code.arr[d_source_code.len]				= '\0';
	 d_source_type.arr[d_source_type.len]				= '\0';
 	 d_category_code.arr[d_category_code.len]			= '\0';
	 d_category_year.arr[d_category_year.len]			= '\0';
	 d_category_no.arr[d_category_no.len]				= '\0';
	 
	 if(NO_DATA_FOUND)
	 {
		sprintf(string_var,"%s -> %s\n",d_specimen_no.arr, 
									sqlca.sqlerrm.sqlerrmc);
		ins_message(ERR_MESG, string_var);
     }


	 gen_file_name();

	 get_patient_details();
	 //get_prep_text(); [Commented]  

	 dclr_cur();	 

     /*-- Added on 16-2-2004 -----*/	 
	 priority_desc();
	 get_facility_name();
	 d_no_labels = get_no_labels(d_specimen_no.arr); //Total number of labels to be print
	 d_count = 0;   
 
     if (strcmp(nd_printer_type.arr,"3")!= 0)
	   set_fonts();

	 get_trans_ind();
	
	 d_sample_yn = check_sample_exists();
    
	 if (strcmp(h_ind,"SA") == 0)
	  {	   
		 get_sequence_type();
	     histo_label();
	  }
	 else /*-- start else ---*/
	  {  
		 for (v_i=0;v_i<v_index;v_i++)
		   {
			 if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
			   {
				ins_message(ERR_MESG,"Error in opening output file...\n");  
			   }


/*
sprintf(string_var,"test1: %d %s %s %d %s",v_i,s_volumeunit[v_i].v_specimen_no,s_volumeunit[v_i].v_testcode,s_volumeunit[v_i].v_testvolume,s_volumeunit[v_i].v_unit);
ins_message(1,string_var);

sprintf(string_var,"test2: %s %d %d %s %s",s_volumeunit[v_i].v_labeldesc,s_volumeunit[v_i].v_contvolume,s_volumeunit[v_i].v_nolabels,s_volumeunit[v_i].v_contcode,s_volumeunit[v_i].v_testdesc);
ins_message(2,string_var);
EXEC SQL COMMIT;
*/
		 
				/*--- Call the print routine for Non-Histo Samples ---*/
				print_label(v_i); 
				print_test_code(v_i);	  
				fclose(f1);

/*
sprintf(string_var,"Check the Label : %d Now",v_i);
disp_message(ERR_MESG,string_var);
*/
				if (strcmp(nd_printer_type.arr,"3")!= 0) 
				  {
				    fprintf(f1, "%cE", ESC);
			        set_fonts();
                   }

			    if (err_flag == 0)   
				{	     
				  print_barcode_label(s_volumeunit[v_i].v_nolabels); 
				}
		  }
     } /*-- end else ---*/	


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )119;
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

	// EXEC SQL ROLLBACK WORK RELEASE;
    sprintf(string_var,"%s -> %s\n",d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
    ins_message(ORA_MESG,string_var);
	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )134;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

get_patient_details()
{

	if (strlen(d_order_id.arr) > 0) 
	  {
	    d_spec_regd_date_time.arr[0]  = '\0';
		d_spec_regd_date_time.len     = 0;

	    d_spec_regd_date_time1.arr[0] = '\0';
		d_spec_regd_date_time1.len    = 0;


	    /* EXEC SQL SELECT TO_CHAR(start_date_time,'DD/MM/YYYY HH24:MI'),
						TO_CHAR(start_date_time,'DDMONYY')
		     INTO   :d_spec_regd_date_time,
				    :d_spec_regd_date_time1
		     FROM   OR_ORDER_LINE
		     WHERE  order_id = :d_order_id
		     AND    order_line_num = 1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select TO_CHAR(start_date_time,'DD/MM/YYYY HH24:MI') ,TO\
_CHAR(start_date_time,'DDMONYY') into :b0,:b1  from OR_ORDER_LINE where (order\
_id=:b2 and order_line_num=1)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )149;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
     sqlstm.sqhstl[0] = (unsigned int  )22;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_spec_regd_date_time1;
     sqlstm.sqhstl[1] = (unsigned int  )12;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_order_id;
     sqlstm.sqhstl[2] = (unsigned int  )18;
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


	    
		d_spec_regd_date_time.arr[d_spec_regd_date_time.len]   = '\0';	
		d_spec_regd_date_time1.arr[d_spec_regd_date_time1.len] = '\0';	
	  }
	

	if (OERROR)
	 {
	    sprintf(string_var,"%s  get start_date_time -> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
	    ins_message(ORA_MESG, string_var);
	 } 

	d_pat_name.arr[0]				= '\0';
	d_actual_patient_id.arr[0]		= '\0';
	d_ref_location.arr[0]			= '\0';	
	d_sex.arr[0]					= '\0';
	d_dob.arr[0]					= '\0';
	d_pat_dob_no_of_days.arr[0]		= '\0';

	d_actual_patient_id.len			= 0;
	d_pat_name.len					= 0;
	d_ref_location.len				= 0;
	d_sex.len						= 0;
	d_dob.len						= 0;
	d_pat_dob_no_of_days.len		= 0;

	if (strcmp(d_episode_type.arr, "I") == 0 || 
				strcmp(d_episode_type.arr, "O") == 0 ||
				strcmp(d_episode_type.arr, "H") == 0)
	{

	/*** CHANGED ON 21/11/2002 AS PER REQUEST  FROM THE SITE ****/
			/* EXEC SQL SELECT SUBSTR(short_name,1,30),
						    sex,
							TO_CHAR(DATE_OF_BIRTH,'DDMONYY'),
							ROUND(TRUNC(TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI')) - DATE_OF_BIRTH)
					   INTO :d_pat_name,
							:d_sex,
							:d_dob,
							:d_pat_dob_no_of_days
					   FROM MP_PATIENT_MAST
					   WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(short_name,1,30) ,sex ,TO_CHAR(DATE_OF_BIRTH\
,'DDMONYY') ,ROUND((TRUNC(TO_DATE(:b0,'DD/MM/YYYY HH24:MI'))-DATE_OF_BIRTH)) i\
nto :b1,:b2,:b3,:b4  from MP_PATIENT_MAST where PATIENT_ID=:b5";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )176;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pat_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sex;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_dob;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_pat_dob_no_of_days;
   sqlstm.sqhstl[4] = (unsigned int  )12;
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


	}
	else
	{
			/* EXEC SQL SELECT  SUBSTR(short_name,1,30),
							 actual_patient_id, 
							 location,
							 sex,
							 TO_CHAR(DATE_OF_BIRTH,'DDMONYY'),
							 ROUND(TRUNC(TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI')) - DATE_OF_BIRTH) 
					   INTO :d_pat_name, 
							:d_actual_patient_id, 
							:d_ref_location,
							:d_sex,
							:d_dob,
							:d_pat_dob_no_of_days
					 FROM RL_PATIENT_MAST
					 WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(short_name,1,30) ,actual_patient_id ,locatio\
n ,sex ,TO_CHAR(DATE_OF_BIRTH,'DDMONYY') ,ROUND((TRUNC(TO_DATE(:b0,'DD/MM/YYYY\
 HH24:MI'))-DATE_OF_BIRTH)) into :b1,:b2,:b3,:b4,:b5,:b6  from RL_PATIENT_MAST\
 where PATIENT_ID=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )215;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pat_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_actual_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ref_location;
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
   sqlstm.sqhstv[5] = (         void  *)&d_dob;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_pat_dob_no_of_days;
   sqlstm.sqhstl[6] = (unsigned int  )12;
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
}


				 /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */
	}

	d_pat_name.arr[d_pat_name.len]						= '\0';
	d_actual_patient_id.arr[d_actual_patient_id.len]	= '\0';
	d_ref_location.arr[d_ref_location.len]				= '\0';
	d_sex.arr[d_sex.len]								= '\0';
	d_dob.arr[d_dob.len]								= '\0';
	d_pat_dob_no_of_days.arr[d_pat_dob_no_of_days.len]	= '\0';	

    if (OERROR)
	{
		sprintf(string_var,"%s  2.get_patient_details() -> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
     }


}

void dclr_cur()
{
 
		/* EXEC SQL DECLARE c1 CURSOR FOR
			     SELECT test_code
				 FROM rl_request_detail
				 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
				 AND operating_facility_id = :nd_operating_facility_id
				 AND NVL(cancelled_yn, 'N') <> 'Y'; */ 


		/* EXEC SQL OPEN c1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0008;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )262;
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
}


		

     return;
}


int fetch_test_code()
{

	d_test_code.arr[0]		= '\0';
	d_test_code.len			= 0;

      /* EXEC SQL FETCH c1 INTO
				:d_test_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 17;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )285;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
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


 
    if (OERROR)
	{
		sprintf(string_var,"%s  fetch_test_code() -> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
     }

	 if (NO_DATA_FOUND)
        return 0;
  
    d_test_code.arr[d_test_code.len] = '\0';
 
    return 1;
  
}


print_test_code(int ind)
{
   int test_code ;
   int count = 1;
   int spaces ;

   fprintf(f1,"%-40.40s ",s_volumeunit[ind].v_testcode);

   if (i_count > 0)
		fprintf(f1, "\n%-25.25s", s_volumeunit[ind].v_testdesc);
	
   if (d_prep_text.len > 0)
		fprintf(f1, "\n%-25.25s", d_prep_text.arr);

}

get_interval_specimens()
{

    /* EXEC SQL DECLARE interval_curs CURSOR FOR
			SELECT test_code, TO_CHAR(specimen_no), seq_no
		    FROM RL_INTERVAL_TEST_SPECIMENS
			WHERE interval_test_specimen_no = TO_NUMBER(:d_specimen_no)
			AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND specimen_no <> TO_NUMBER(:d_specimen_no)
			ORDER BY specimen_no; */ 

	/* EXEC SQL OPEN interval_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )304;
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
 sqlstm.sqhstv[2] = (         void  *)&d_specimen_no;
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



	while(fetch_interval_curs())
	{
	    strcpy(s_intervaltest[v_interval_index].i_specimen_no,nd_specimen_no.arr);
	    strcpy(s_intervaltest[v_interval_index].i_testcode,d_test_code.arr);		
	    get_interval_desc();
	    strcpy(s_intervaltest[v_interval_index].i_testdesc,d_description.arr);
	    v_interval_index += 1;
	}

	/* EXEC SQL CLOSE interval_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )331;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

int fetch_interval_curs()
{

	d_test_code.arr[d_test_code.len]		= '\0';
	nd_specimen_no.arr[nd_specimen_no.len]	= '\0';
	d_count = 0;


      /* EXEC SQL FETCH interval_curs INTO	:d_test_code, :nd_specimen_no, d_count; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 17;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )346;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&d_test_code;
      sqlstm.sqhstl[0] = (unsigned int  )13;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_specimen_no;
      sqlstm.sqhstl[1] = (unsigned int  )23;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_count;
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


 
    if (OERROR)
	{
		sprintf(string_var,"%s fetch_interval_curs()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);

     }

	 if (NO_DATA_FOUND)
        return 0;
  
    d_test_code.arr[d_test_code.len]	       = '\0';
	nd_specimen_no.arr[nd_specimen_no.len]	   = '\0';
 
    return 1;
  
}

/*************** Get Interval Test ***************/
get_interval_test()
{
	
	
	/* EXEC SQL SELECT seq_no, seq_no
			 INTO :i_count, :d_count
			 FROM RL_INTERVAL_TEST_SPECIMENS
			 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND test_code = :d_test_code1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select seq_no ,seq_no into :b0,:b1  from RL_INTERVAL_TEST_SP\
ECIMENS where ((specimen_no=TO_NUMBER(:b2) and OPERATING_FACILITY_ID=:b3) and \
test_code=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )373;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&i_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_count;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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
 sqlstm.sqhstv[4] = (         void  *)&d_test_code1;
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



}

/*************** Get Parent Details ***************/
get_parent()
{
	parent_spec_no.arr[0]	= '\0';
	parent_spec_no.len		= 0;

	/* EXEC SQL SELECT interval_test_specimen_no
			 INTO :parent_spec_no
			 FROM RL_INTERVAL_TEST_SPECIMENS
			 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND test_code = :d_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select interval_test_specimen_no into :b0  from RL_INTERVAL_\
TEST_SPECIMENS where ((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b\
2) and test_code=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )408;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&parent_spec_no;
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



	parent_spec_no.arr[parent_spec_no.len]	= '\0';

}

dclr_rownum_curs()
{
 
		/* EXEC SQL DECLARE c2 CURSOR FOR
			     SELECT rownum, specimen_no
				 FROM RL_INTERVAL_TEST_SPECIMENS
				 WHERE interval_test_specimen_no = TO_NUMBER(:parent_spec_no)
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 ORDER BY specimen_no; */ 


		/* EXEC SQL OPEN c2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0012;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )439;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&parent_spec_no;
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


		

}

int fetch_rownum_curs()
{
	
	 r_child_spec_no.arr[0]		= '\0';
	 r_child_spec_no.len		= 0;

      /* EXEC SQL FETCH c2 INTO :d_count, r_child_spec_no; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 17;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )462;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&d_count;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&r_child_spec_no;
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


 
	 if (OERROR)
	{
		sprintf(string_var,"%s fetch_rownum_curs()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);

     }

	 if (NO_DATA_FOUND)
        return 0; 

	r_child_spec_no.arr[r_child_spec_no.len]		= '\0';

    return 1;
  
}

/*************** Get Interval Test Desc ***************/
get_interval_desc()
{

	d_description.arr[0]		= '\0';
	d_description.len			= 0;

	/* EXEC SQL SELECT SUBSTR(description, 1, 20)
			 INTO :d_description
			 FROM RL_INTERVAL_TEST_DESC
			 WHERE test_code = :d_test_code1
			 AND seq_no = :d_count; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SUBSTR(description,1,20) into :b0  from RL_INTERVAL_T\
EST_DESC where (test_code=:b1 and seq_no=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )485;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_description;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_test_code1;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_count;
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


	
	
	d_description.arr[d_description.len]		= '\0';
	
}


set_fonts()  
{

	/*fprintf(f1,"%c&k4S",ESC);  This will make the font condensed */
	/*fprintf(fp,"%c(s4B",ESC); This will make the font bold       */
	
	fprintf(f1,"%c&a0L",ESC);   /* This will make the left margin to reduce to 0 */
	fprintf(f1,"%c&l0E\n",ESC);	/* This will make the top margin to reduce to 0  */
	fprintf(f1, "%c(s15H", ESC);/* Reduce the font size							 */
	fprintf(f1,"%c&l12D",ESC);  /* This will make no. of lines per inch to 8     */ 

}
 

/*************** To Print the Label ***************/
print_label(int v_ind)
{	

	fprintf(f1, "%s\n", d_facility_name.arr);
	if (strlen(s_volumeunit[v_ind].v_labeldesc) > 0) 
	  {	
	   fprintf(f1, "%s", s_volumeunit[v_ind].v_labeldesc);	   

	   if (s_volumeunit[v_ind].v_contvolume > 0) 
		 {
		  fprintf(f1," %d",s_volumeunit[v_ind].v_contvolume);
		   if (strcmp(s_volumeunit[v_ind].v_unit,"!!!!")!=0)
			 {fprintf(f1,"%s",s_volumeunit[v_ind].v_unit);}
		  }
	      fprintf(f1,"\n");	
       } 

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	      print_barcode(f1,s_volumeunit[v_ind].v_specimen_no, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	      fprintf(f1,"\n");  
	  }
	else
	  {
	      print_barcode(f1,s_volumeunit[v_ind].v_specimen_no, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	      fprintf(f1,"\n");
	  }

	fprintf(f1, "%-s", s_volumeunit[v_ind].v_specimen_no);	
    fprintf(f1," %s",nd_priority);
	fprintf(f1," %s\n",d_spec_regd_date_time1.arr);
	

	/* Commented
	if (strlen(d_category_code.arr) > 0)
	  {
		fprintf(f1, " %s-%s\n", d_category_code.arr, d_category_no.arr);
	  }
	else
	  {
		fprintf(f1, "\n");  
	  }
	*/
	fprintf(f1,"%-20s\n",  d_pat_name.arr);
	fprintf(f1, "%-4s ", d_source_code.arr);

	if (strlen(d_actual_patient_id.arr) > 0)
	   fprintf(f1, "%-s", d_actual_patient_id.arr);
	else
	   fprintf(f1, "%-s", d_patient_id.arr);

    fprintf(f1, " %s", d_sex.arr);
	fprintf(f1, " %s\n", d_dob.arr);

}


/************************** select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]	= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N')
	          INTO   :nd_trx_ind
	          FROM   sy_online_print_id
              WHERE  MODULE_ID = 'RL'
			  AND    ONLINE_PRINT_NAME = 'RLRSPCLB'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where (MODULE_ID='RL' and ONLINE_PRINT_NAME='RLRSPCLB')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )512;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
		sprintf(string_var,"%s get_trans_ind()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);

	}

	nd_trx_ind.arr[nd_trx_ind.len]			= '\0';


    if(NO_DATA_FOUND)
		return 0;

		
	return 1;

}
/************************** gen file name ***************/
gen_file_name()
{
	strcpy(filename,WORKING_DIR);
	strcat(filename,"rlrspclb.lis");

	strcpy(nd_filename,WORKING_DIR);
	strcat(nd_filename,"rlrspcl1.lis");

	if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
	{
		ins_message(ERR_MESG,"Error in opening output file...\n");  
    }

}
/*--------------------------------------------------*/
ins_message(int msg_type,char msg[])
{
   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   
   er_msg_type = 0;

   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(er_msg.arr);
 
   er_msg_type = msg_type;


   /* EXEC SQL
   INSERT INTO SY_PROG_MSG
          (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
          (:nd_operating_facility_id,'RLRSPCLB',:er_msg_type,NULL, SUBSTR(:er_msg, 1, 70),SYSDATE,USERENV('sessionid'),
		   TO_CHAR(SYSDATE,'DD/MM/YYYY')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'RLRSPCLB\
',:b1,null ,SUBSTR(:b2,1,70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/\
MM/YYYY'))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )531;
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
   sqlstm.sqhstv[1] = (         void  *)&er_msg_type;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&er_msg;
   sqlstm.sqhstl[2] = (unsigned int  )173;
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



   err_flag = 1;
}

/*------------- Added on 16-02-2004 ---------------*/

/************** Hospital name **********/
get_facility_name()
{
  d_facility_name.arr[0] = '\0';
  d_facility_name.len    = 0;

  /* EXEC SQL
  SELECT FACILITY_NAME 
  INTO   :d_facility_name
  FROM   SM_FACILITY_PARAM
  WHERE  FACILITY_ID = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select FACILITY_NAME into :b0  from SM_FACILITY_PARAM where\
 FACILITY_ID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )558;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_name;
  sqlstm.sqhstl[0] = (unsigned int  )302;
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



  d_facility_name.arr[d_facility_name.len] = '\0';
}


/************ To get the sample ids *************/
get_sample_details()
{

  /* EXEC SQL DECLARE sample_id_cur CURSOR FOR
  SELECT SAMPLE_ID,SEQ_NO,ANATOMY_SITE_CODE
  FROM   RL_SAMPLE_DETAILS 
  WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
  AND    SPECIMEN_NO =  TO_NUMBER(:d_specimen_no)
  AND    TEST_CODE   =  :d_test_code
  AND    NVL(SAMPLE_INDICATOR,'SA')  NOT IN ('NA') ; */ 

  
  /* EXEC SQL OPEN sample_id_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0017;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )581;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
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



  return;
   
}

/********** Fetch the sample ids **********/
int fetch_sample_id()
{

    d_sample_id.arr[0]	   = '\0';
	d_sample_id.len	       = 0;
	
	d_anatomy_site.arr[0]  = '\0';
	d_anatomy_site.len     = 0;    
     
	/* EXEC SQL FETCH sample_id_cur
	INTO :d_sample_id,:d_sample_seq,:d_anatomy_site; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )608;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_sample_id;
 sqlstm.sqhstl[0] = (unsigned int  )8;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sample_seq;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_anatomy_site;
 sqlstm.sqhstl[2] = (unsigned int  )8;
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


	 
    d_sample_id.arr[d_sample_id.len]	   = '\0';	 	
    d_anatomy_site.arr[d_anatomy_site.len] = '\0';    


    if (OERROR)
	{
		sprintf(string_var,"%s sample_id_cur()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);

     }

	 if (NO_DATA_FOUND)
        return 0;    
   
		 
	 return 1;

}

/****** Print label & sample id ******/

histo_label()
{
   int test_code ;
   int count = 1;
   int spaces ;
   int sample_code;
   int l_ind = 0;	

   test_code = fetch_test_code();
   while(test_code)
   {

	 get_sample_details();	
     sample_code = fetch_sample_id();

		  if (sample_code)
		   { 
			 while(sample_code)
			  {
				strcpy(h_sampleid[l_ind],d_sample_id.arr);
				h_sampleseq[l_ind]     = d_sample_seq;
				strcpy(h_anatomysite[l_ind],d_anatomy_site.arr);
				strcpy(h_testcode[l_ind],d_test_code.arr);
			    
				l_ind += 1;
				sample_code = fetch_sample_id();
			  }	         
            }
		  else
		  {
			strcpy(h_testcode[l_ind],d_test_code.arr);
			l_ind += 1;
		  }	

	 test_code = fetch_test_code();	 	 
	}

    h_histo_count = l_ind;

	/* EXEC SQL CLOSE sample_id_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )635;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE c1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
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

    

	get_label_desc();

    for (i=0;i< h_histo_count;i++)
     {
	   if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
		  {
   	  	    ins_message(ERR_MESG,"Error in opening output file...\n");  
		  }
		print_histo_label(i);
     }

}

/**************** Get Label Desc **************************/
get_label_desc()
{
	int i,j;
	
	for (j=0;j<v_index;j++) 
	{
	  for (i=0;i<h_histo_count;i++)
	   {
		 if (strlen(s_volumeunit[j].v_labeldesc)>0)
		 {	
			if ( strstr(s_volumeunit[j].v_testcode,h_testcode[i]))
		     {
				strcpy(h_labeldesc[i],s_volumeunit[j].v_labeldesc);				
				h_volume[i] = s_volumeunit[j].v_contvolume;
				strcpy(h_unit[i],s_volumeunit[j].v_unit);
              }
		  }
	
        }
	}
}

/****************** Print Histo Label *********************/
print_histo_label(int h_seq)
 {

	fprintf(f1, "%s\n", d_facility_name.arr);
	
	if (strlen(h_labeldesc[h_seq]) > 0)
	  {	
		fprintf(f1, "%s", h_labeldesc[h_seq]);
		
		if (h_volume[h_seq]>0)	
		{
		  fprintf(f1, " %d",h_volume[h_seq]);
		  if (strcmp(h_unit[h_seq],"!!!!") != 0) 
			{fprintf(f1, "%s",h_unit[h_seq]);}
		 }
		fprintf(f1,"\n");		 	  
	  }

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
		print_barcode(f1, d_specimen_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
		fprintf(f1,"\n");  
	  }
	else
	  {
		print_barcode(f1, d_specimen_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
		fprintf(f1,"\n");
	  }

	fprintf(f1, "%-s", d_specimen_no.arr);	

	 /*--------  Sample ID ------------------*/
	 if (h_sampleseq[h_seq] > 0 )
	  {
		if (strcmp(d_sample_seq_type.arr,"A") == 0) 
		  fprintf(f1, "/%s", h_sampleid[h_seq]);
		else 
		  fprintf(f1, "/%d", h_sampleseq[h_seq]);
       }
	/*---------------------------------------*/

	fprintf(f1," %s",nd_priority);
   	fprintf(f1," %s\n",d_spec_regd_date_time1.arr);

   /* [Commented]
	if (strlen(d_category_code.arr) > 0)
	  {
		fprintf(f1, " %s-%s\n", d_category_code.arr, d_category_no.arr);
	  }
	else
	  {
		fprintf(f1, "\n");  
	  }
   */

	fprintf(f1,"%-20s\n",d_pat_name.arr);
	fprintf(f1, "%-4s ", d_source_code.arr);

    /*---------- Anatomy [Commented]---------
	if (strlen(h_anatomysite[h_seq]) > 0 )    
	  fprintf(f1, "%-4s ", h_anatomysite[h_seq]);
	/*---------------------------------------*/

	if (strlen(d_actual_patient_id.arr) > 0)
		fprintf(f1, "%s", d_actual_patient_id.arr);
	else
		fprintf(f1, "%s", d_patient_id.arr);

    fprintf(f1, " %s", d_sex.arr);
	fprintf(f1, " %s\n", d_dob.arr);
	
	fprintf(f1,"%s\n",h_testcode[h_seq]);	
	//fprintf(f1, "%-25.25s", d_description.arr);   

	/* [Commented]
	 if (d_prep_text.len > 0)
		fprintf(f1, "%-25.25s", d_prep_text.arr);
    */

	fclose(f1);		

/*
sprintf(string_var," Check the Label Now..... ");
disp_message(ERR_MESG,string_var);
*/
	
	if (strcmp(nd_printer_type.arr,"3")!= 0)
	  {	
	    fprintf(f1, "%cE", ESC);
	    set_fonts();
      }
	
	 if (err_flag == 0)   
	 {
		print_barcode_label(1);
	  }
 }



/****************** Check Sample Exists *********************/
check_sample_exists()
{

     /* EXEC SQL 
    SELECT NVL(USE_SAMPLE_ANATOMY_IND,'!!') 
      INTO :h_ind
      FROM RL_SECTION_CODE
     WHERE SECTION_CODE = :d_section_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(USE_SAMPLE_ANATOMY_IND,'!!') into :b0  from R\
L_SECTION_CODE where SECTION_CODE=:b1";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )665;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)h_ind;
     sqlstm.sqhstl[0] = (unsigned int  )3;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_section_code;
     sqlstm.sqhstl[1] = (unsigned int  )8;
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



    if(NO_DATA_FOUND)
	{
		sprintf(string_var,"%s check_sample_exists()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	if(OERROR)
	{
		sprintf(string_var,"%s check_sample_exists()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

}


/********* Sample Seq Type **********/
get_sequence_type()
{

  d_sample_seq_type.arr[0] = '\0';
  d_sample_seq_type.len    = 0;

  /* EXEC SQL SELECT NVL(SAMPLE_SEQUENCE_TYPE,'N')
  INTO :d_sample_seq_type
  FROM RL_PARAM; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(SAMPLE_SEQUENCE_TYPE,'N') into :b0  from RL_PARA\
M ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )688;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_sample_seq_type;
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

 

  d_sample_seq_type.arr[d_sample_seq_type.len] = '\0';

  if(NO_DATA_FOUND)
	{
		sprintf(string_var,"%s get_sequence_type()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

  if(OERROR)
	{
		sprintf(string_var,"%s get_sequence_type()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}


  return;
}

/*********** Description for Priority *********/
priority_desc()
{
 if (strcmp(d_urgent_indicator.arr,"U") == 0)
	nd_priority = "UR";
 if (strcmp(d_urgent_indicator.arr,"S") == 0)
	nd_priority = "ST";
 if (strcmp(d_urgent_indicator.arr,"R") == 0)
    nd_priority = "RO";	
	
}

/************** Get Blood Unit No ***************/
get_blood_unit()
{

 d_blood_unit.arr[0]  = '\0';
 d_blood_unit.len     = 0;

 /* EXEC SQL DECLARE blood_unit_cur CURSOR FOR
 SELECT UNIT_NO 
 //INTO :d_blood_unit
 FROM   BD_LAB_SCREEN_GROUP_DTL 
 WHERE  SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
 AND    OPERATING_FACILITY_ID = :nd_operating_facility_id
 AND    SECTION_CODE = :d_section_code; */ 


 /* EXEC SQL OPEN blood_unit_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0020;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )707;
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
 sqlstm.sqhstv[2] = (         void  *)&d_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )8;
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


 
 /* EXEC SQL FETCH blood_unit_cur INTO :d_blood_unit; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )734;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_blood_unit;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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


 
 d_blood_unit.arr[d_blood_unit.len]  = '\0';       

 /* EXEC SQL CLOSE blood_unit_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )753;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (OERROR)
	{
		sprintf(string_var,"%s blood_unit_cur()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);

     }

	 if (NO_DATA_FOUND)
        return 0;    

 return 1;

}

/****************** Get Container Code *******************/
int check_container_code()
{

      /* EXEC SQL 
    SELECT count(1) 
      INTO :d_con_count
      FROM RL_CONTAINER_FOR_SPECIMEN_TYPE
     WHERE specimen_type_code = :d_specimen_type_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 17;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select count(1) into :b0  from RL_CONTAINER_FOR_SPECIME\
N_TYPE where specimen_type_code=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )768;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_con_count;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
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

    

     if (d_con_count > 0)
	   return 1;
     else      
	  {
		  /* EXEC SQL
		SELECT count(1)
		  INTO :d_con_count
		  FROM RL_AGE_SEX_SPEC_TYPE_CONT
		 WHERE specimen_type_code = :d_specimen_type_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(1) into :b0  from RL_AGE_SEX_SPEC_TYPE_CONT \
where specimen_type_code=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )791;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_con_count;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
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


		
		if (d_con_count > 0)
		   return 1;
		else      
		   return 0;
       }

     if (OERROR)
	  {
	    sprintf(string_var,"%s  get_container_code() -> %s\n", d_specimen_no.arr, 			
			    sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
      }
 
 }
 
/***************** Get Container Label and Volume ********************/
 get_container_volume(int ind,char interval_yn)
{
	int k;

	d_container_code.arr[0]		= '\0';
    d_container_code.len		= 0;
	
	d_desc_on_label.arr[0]		= '\0';
	d_desc_on_label.len			= 0;
	
	d_volume_unit.arr[0]		= '\0';
	d_volume_unit.len			= 0;

	/* EXEC SQL SELECT COUNT(1) INTO :c_count
	           FROM RL_AGE_SEX_SPEC_TYPE_CONT  
	          WHERE specimen_type_code = :d_specimen_type_code	
	            AND TO_NUMBER(:d_pat_dob_no_of_days)
	        BETWEEN calc_min_age_in_days AND calc_max_age_in_days
			    AND container_code IN
				    (
					  SELECT container_code 
					    FROM RL_SPECIMEN_CONTAINER
					   WHERE NVL(volume_unit,'!!!!') = NVL(:d_unit,'!!!!')
					 ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_AGE_SEX_SPEC_TYPE_CONT whe\
re ((specimen_type_code=:b1 and TO_NUMBER(:b2) between calc_min_age_in_days an\
d calc_max_age_in_days) and container_code in (select container_code  from RL_\
SPECIMEN_CONTAINER where NVL(volume_unit,'!!!!')=NVL(:b3,'!!!!')))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )814;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&c_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_pat_dob_no_of_days;
 sqlstm.sqhstl[2] = (unsigned int  )12;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_unit;
 sqlstm.sqhstl[3] = (unsigned int  )8;
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



    if (c_count > 0)
      {

			/* EXEC SQL DECLARE age_con_code_cur CURSOR FOR
					  SELECT container_code,
							 NVL(volume,0) volume,
							 volume_unit,
							 NVL(SUBSTR(long_desc,1,30),' ')  long_desc,
							 ABS(NVL(volume,0) - :d_test_volume) req_volume
						FROM RL_SPECIMEN_CONTAINER
					   WHERE container_code IN (
							    SELECT container_code
								FROM RL_AGE_SEX_SPEC_TYPE_CONT  
								WHERE specimen_type_code = :d_specimen_type_code	
								AND TO_NUMBER(:d_pat_dob_no_of_days)
								BETWEEN calc_min_age_in_days AND calc_max_age_in_days)
					     AND NVL(volume_unit,'!!!!') = NVL(:d_unit,'!!!!')
					   ORDER BY req_volume; */ 
		   

	    /* EXEC SQL OPEN age_con_code_cur; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0024;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )845;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_test_volume;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_pat_dob_no_of_days;
     sqlstm.sqhstl[2] = (unsigned int  )12;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_unit;
     sqlstm.sqhstl[3] = (unsigned int  )8;
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



		/* EXEC SQL FETCH age_con_code_cur INTO 
						:d_container_code,
						:d_container_volume,
						:d_volume_unit,
						:d_desc_on_label,
						:d_req_volume; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )876;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_container_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_container_volume;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_volume_unit;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_desc_on_label;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_req_volume;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
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



		/* EXEC SQL CLOSE age_con_code_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )911;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		d_container_code.arr[d_container_code.len]	= '\0';
		d_desc_on_label.arr[d_desc_on_label.len]	= '\0';
		d_volume_unit.arr[d_volume_unit.len]		= '\0';	

 	    if ( interval_yn == 'N')
		 {
			strcpy(s_volumeunit[ind].v_labeldesc,d_desc_on_label.arr);
			s_volumeunit[ind].v_contvolume = d_container_volume;
			strcpy(s_volumeunit[ind].v_contcode,d_container_code.arr);
		 }	
		else if ( interval_yn == 'Y')
		 {
			for (k=0;k<v_interval_index;k++)			
			 {
			   strcpy(s_intervaltest[k].i_labeldesc,d_desc_on_label.arr);
			   s_intervaltest[k].i_contvolume = d_container_volume;
			   strcpy(s_intervaltest[k].i_contcode,d_container_code.arr);
			  }
		  }	

		if (OERROR)
		{
		   sprintf(string_var,"%s  get_container_volume age() -> %s\n", d_specimen_no.arr,
				sqlca.sqlerrm.sqlerrmc);
			ins_message(ORA_MESG, string_var);
		}

		if (NO_DATA_FOUND)
			{
				/* EXEC SQL CLOSE age_con_code_cur; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )926;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


				return 0;   }
		
		return 1;

	   }
	else
	   {
			/* EXEC SQL DECLARE con_code_cur CURSOR FOR
					  SELECT container_code,
							 NVL(volume,0) volume,
							 volume_unit,
							 NVL(SUBSTR(long_desc,1,30),' ')  long_desc,
							 ABS(NVL(volume,0) - :d_test_volume) req_volume
						FROM RL_SPECIMEN_CONTAINER
					   WHERE container_code IN (
    							SELECT container_code
    							FROM  RL_CONTAINER_FOR_SPECIMEN_TYPE
    							WHERE specimen_type_code = :d_specimen_type_code)
					     AND NVL(volume_unit,'!!!!') = NVL(:d_unit,'!!!!')
					   ORDER BY req_volume; */ 
	

	    /* EXEC SQL OPEN con_code_cur; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0025;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )941;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_test_volume;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_unit;
     sqlstm.sqhstl[2] = (unsigned int  )8;
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



		/* EXEC SQL FETCH con_code_cur INTO 
						:d_container_code,
						:d_container_volume,
						:d_volume_unit,
						:d_desc_on_label,
						:d_req_volume; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )968;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_container_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_container_volume;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_volume_unit;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_desc_on_label;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_req_volume;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
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



		/* EXEC SQL CLOSE con_code_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1003;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		d_container_code.arr[d_container_code.len]	= '\0';
		d_desc_on_label.arr[d_desc_on_label.len]	= '\0';
		d_volume_unit.arr[d_volume_unit.len]		= '\0';	

 	    if ( interval_yn == 'N') 
		 {
			strcpy(s_volumeunit[ind].v_labeldesc,d_desc_on_label.arr);
			s_volumeunit[ind].v_contvolume = d_container_volume;
			strcpy(s_volumeunit[ind].v_contcode,d_container_code.arr);
		 }	
		else if ( interval_yn == 'Y')
		 {
			for (k=0;k<v_interval_index;k++)			
			 {
			   strcpy(s_intervaltest[k].i_labeldesc,d_desc_on_label.arr);
			   s_intervaltest[k].i_contvolume = d_container_volume;
			   strcpy(s_intervaltest[k].i_contcode,d_container_code.arr);
			  }
		  }	

		if (OERROR)
		{
		sprintf(string_var,"%s  get_container_volume() -> %s\n", d_specimen_no.arr,
				sqlca.sqlerrm.sqlerrmc);
			ins_message(ORA_MESG, string_var);
			}

		if (NO_DATA_FOUND)
			{
				/* EXEC SQL CLOSE con_code_cur; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 17;
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


				return 0;   }
		
		return 1;
    }
 
 }

/********************  Get test codes   ************************/
void dclr_test_cur()
{
 
		/* EXEC SQL DECLARE test_cur CURSOR FOR
			     SELECT test_code
				 FROM rl_request_detail
				 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
				 AND operating_facility_id = :nd_operating_facility_id
				 AND NVL(cancelled_yn, 'N') <> 'Y'; */ 


		/* EXEC SQL OPEN test_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0026;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1033;
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
}

		

     return;
}

int fetch_test()
{

	d_test_code1.arr[0]		= '\0';
	d_test_code1.len		= 0;

      /* EXEC SQL FETCH test_cur INTO :d_test_code1; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 17;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1056;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&d_test_code1;
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


 
    if (OERROR)
	{
		sprintf(string_var,"%s  fetch_test() -> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
     }

	 if (NO_DATA_FOUND)
        return 0;
  
    d_test_code1.arr[d_test_code1.len] = '\0';

    return 1;
      
}  
/***************** Get volume for all Tests ********************/
 get_test_volume()

 {  
   int ins_test_yn = 1,  // Insert_test_yn
       int_test_yn = 0;  // Interval_test_yn
   int j,k; 	
   dclr_test_cur();	

   while(fetch_test())
   {

	  d_volume_unit.arr[0]	= '\0';
	  d_volume_unit.len		= 0;

	  if (i_count == 0)
		{	
			get_interval_test();	
			get_interval_desc(); 
			
			if (i_count > 0) 
				int_test_yn = 1; 
		}

	  /*-- Volume for specific age range --*/	
	  /* EXEC SQL SELECT NVL(volume,0),
	  				  NVL(volume_unit,'!!!!')
			   INTO	  :d_volume,	
				      :d_volume_unit			   
			   FROM   RL_AGE_SEX_TEST_VOLUME
			   WHERE  TEST_CODE = :d_test_code1
			   /oAND    SEX       = :d_sexo/
			   AND	  specimen_type_code = :d_specimen_type_code	
			   AND   TO_NUMBER(:d_pat_dob_no_of_days)
			   BETWEEN CALC_MIN_AGE_IN_DAYS AND CALC_MAX_AGE_IN_DAYS; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(volume,0) ,NVL(volume_unit,'!!!!') into :b0,:b1\
  from RL_AGE_SEX_TEST_VOLUME where ((TEST_CODE=:b2 and specimen_type_code=:b3\
) and TO_NUMBER(:b4) between CALC_MIN_AGE_IN_DAYS and CALC_MAX_AGE_IN_DAYS)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1075;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_volume;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_volume_unit;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_test_code1;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_specimen_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_pat_dob_no_of_days;
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



      if (NO_DATA_FOUND)
		{
			/*-- Volume for specimen type --*/
			/* EXEC SQL SELECT NVL(volume,0),
					        NVL(volume_unit,'!!!!')
					 INTO	:d_volume,
							:d_volume_unit
					 FROM   RL_SPECIMEN_TYPE_FOR_TEST
					 WHERE  test_code = :d_test_code1
					 AND	specimen_type_code = :d_specimen_type_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(volume,0) ,NVL(volume_unit,'!!!!') into :b0,:b1\
  from RL_SPECIMEN_TYPE_FOR_TEST where (test_code=:b2 and specimen_type_code=:\
b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1110;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_volume;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_volume_unit;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_test_code1;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_specimen_type_code;
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
}


		
			if(NO_DATA_FOUND)
			  {
					/* EXEC SQL SELECT NVL(volume,0),
								    NVL(volume_unit,'!!!!')  
							 INTO   :d_volume,
								    :d_volume_unit 					  
 							 FROM   RL_TEST_CODE
							 WHERE  test_code = :d_test_code1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(volume,0) ,NVL(volume_unit,'!!!!') into :b0,:\
b1  from RL_TEST_CODE where test_code=:b2";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1141;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_volume;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_volume_unit;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_test_code1;
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
}

			
				
					if(NO_DATA_FOUND)
						d_volume = 0;
			  }

		}
	

      if (OERROR)
		{
			sprintf(string_var,"%s get_test_volume() -> %s\n", d_specimen_no.arr,
					sqlca.sqlerrm.sqlerrmc);
			ins_message(ORA_MESG, string_var);  
        }
	 
	  /* d_test_volume = d_test_volume + d_volume; */
	  d_volume_unit.arr[d_volume_unit.len] = '\0';

		 for (j=0;j<v_index;j++)
		  {
			if (strcmp(s_volumeunit[j].v_unit,d_volume_unit.arr) == 0) //If unit is exist
			  {
		  		strcat(s_volumeunit[j].v_testcode,",");
				strcat(s_volumeunit[j].v_testcode,d_test_code1.arr);
				s_volumeunit[j].v_testvolume += d_volume;											
				ins_test_yn = 0;
				
				if (int_test_yn > 0)
			  	  { 				   
					strcpy(s_volumeunit[j].v_testdesc,d_description.arr);
					get_interval_specimens();
					for (k=0;k<v_interval_index;k++)
				 	{
				   	  s_intervaltest[k].i_testvolume = d_volume;
				      strcpy(s_intervaltest[k].i_unit,d_volume_unit.arr);
				  	}					
					int_test_yn = 0;
			        }
				break;
			   }
		   }

		 if (ins_test_yn) //For new volume unit
		  {		

			strcpy(s_volumeunit[v_index].v_specimen_no,d_specimen_no.arr);
			strcpy(s_volumeunit[v_index].v_testcode,d_test_code1.arr);
			s_volumeunit[v_index].v_testvolume  = d_volume;		
			strcpy(s_volumeunit[v_index].v_unit,d_volume_unit.arr);

			if (int_test_yn > 0)
			  { 				   
				strcpy(s_volumeunit[v_index].v_testdesc,d_description.arr);	
				get_interval_specimens();
				for (k=0;k<v_interval_index;k++)
				 {
				   s_intervaltest[k].i_testvolume = d_volume;
				   strcpy(s_intervaltest[k].i_unit,d_volume_unit.arr);
				  }					
				int_test_yn = 0;
			   }

			v_index += 1;
		  }
	 
	  }

	/* EXEC SQL CLOSE test_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1168;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	return 1;
 }

/****************** Get Total Number of Labels Required ********************/
 int get_no_labels(char *l_specimen_no)
{		 
    double t_test_vol,t_con_vol,t_tot;
    int k;    

    strcpy(vol_specimen_no.arr,l_specimen_no);
    vol_specimen_no.len = strlen(vol_specimen_no.arr);	

	d_test_volume = 0;
	get_test_volume();	   			//Populate array with all test

	if (d_specimen_type_ind != -1)  //If specimen type exists
	 { 

	   if (check_container_code())	//If container exist, calculate volume & label cnt
		 {

			  // Non GTT specimen
			  for (k=0;k<v_index;k++)
				{
				  
				  d_testvolume = s_volumeunit[k].v_testvolume;
				  strcpy(d_unit.arr,s_volumeunit[k].v_unit);
				  d_unit.len = strlen(d_unit.arr);

				  get_container_volume(k,'N');
				  if (s_volumeunit[k].v_testvolume > s_volumeunit[k].v_contvolume)
				   {
				     d_label_cnt = 1; //to reset
					 t_test_vol = s_volumeunit[k].v_testvolume; 
					 t_con_vol  = s_volumeunit[k].v_contvolume;

					 d_total = ceil(t_test_vol/t_con_vol);
					 d_label_cnt = d_total * d_label_cnt;					
					 s_volumeunit[k].v_nolabels = d_label_cnt;
				   }		
				  else // If test volume is less than container volume
				   {
					 s_volumeunit[k].v_nolabels = 1;
					} 	 
				}
			
			// GTT specimen
 			if (strlen(s_intervaltest[0].i_testcode) > 0) 
			  {	
				d_testvolume = s_intervaltest[0].i_testvolume;
				strcpy(d_unit.arr,s_intervaltest[0].i_unit);
				d_unit.len = strlen(d_unit.arr);

				get_container_volume(0,'Y');			
				if (s_intervaltest[0].i_testvolume > s_intervaltest[0].i_contvolume)			   
 				  { 
				     d_label_cnt = 1; //to reset
					 t_test_vol = s_intervaltest[0].i_testvolume; 
					 t_con_vol  = s_intervaltest[0].i_contvolume;

					 d_total = ceil(t_test_vol/t_con_vol);
					 d_label_cnt = d_total * d_label_cnt;					
					 s_intervaltest[0].i_nolabels = d_label_cnt;
				   }
				  else // If test volume is less than container volume
				   {
					 s_intervaltest[k].i_nolabels = 1;
					}
				}

		 }
	   else				//If container not exists, get label cnt from master
	     {		   
		   get_label_cnt_master();
		   for (k=0;k<v_index;k++)
		     {
				strcpy(s_volumeunit[k].v_labeldesc,d_desc_on_label.arr);
				s_volumeunit[k].v_nolabels = d_label_cnt;
			 }
		  }
	 }
	else					// If no specimen type
	 {
	     for (k=0;k<v_index;k++)
		  {
			s_volumeunit[k].v_nolabels = 1;
		  }
	 }
	
	if (strlen(s_intervaltest[0].i_testdesc) > 0)
	{
	  			 
       for(k=0;k<v_interval_index;k++)
	    {
	     s_intervaltest[k].i_nolabels = d_label_cnt;

		 strcpy(s_volumeunit[v_index].v_specimen_no,s_intervaltest[k].i_specimen_no);
		 strcpy(s_volumeunit[v_index].v_testcode,s_intervaltest[k].i_testcode);
		 strcpy(s_volumeunit[v_index].v_unit,s_intervaltest[k].i_unit);
		 strcpy(s_volumeunit[v_index].v_labeldesc,s_intervaltest[k].i_labeldesc);
		 strcpy(s_volumeunit[v_index].v_contcode,s_intervaltest[k].i_contcode);
		 strcpy(s_volumeunit[v_index].v_testdesc,s_intervaltest[k].i_testdesc);
		 s_volumeunit[v_index].v_testvolume = s_intervaltest[k].i_testvolume;
		 s_volumeunit[v_index].v_contvolume = s_intervaltest[k].i_contvolume;
		 s_volumeunit[v_index].v_nolabels = s_intervaltest[k].i_nolabels;
		 v_index += 1;
		}
	 }
    return 1;		

}

/***************** Get the Label Count from Master *********************/
get_label_cnt_master()

{

	d_desc_on_label.arr[0]		= '\0';
	d_desc_on_label.len			= 0;

	/* EXEC SQL 
	SELECT NVL(no_of_coll_labels,1) ,
		   desc_on_label	
	INTO  :d_label_cnt,
		  :d_desc_on_label
	FROM   RL_SPECIMEN_TYPE_CODE 
	WHERE  specimen_type_code = :d_specimen_type_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(no_of_coll_labels,1) ,desc_on_label into :b0,:b1 \
 from RL_SPECIMEN_TYPE_CODE where specimen_type_code=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1183;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_label_cnt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_desc_on_label;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_specimen_type_code;
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



	d_desc_on_label.arr[d_desc_on_label.len] = '\0';

    if (OERROR)
	{
	  sprintf(string_var,"%s  get_label_cnt_master() -> %s\n", d_specimen_no.arr,
			sqlca.sqlerrm.sqlerrmc);
	  ins_message(ORA_MESG, string_var);
      }

    if (NO_DATA_FOUND)		
        return 0;   

    return 1;
}
/*************** Get the Preparation Text from Order ********************/
int get_prep_text()
{

	d_prep_text.arr[0] = '\0';
	d_prep_text.len = 0;

	/* EXEC SQL
	SELECT substr(order_line_field_value,1,30)
	INTO  :d_prep_text
	FROM   OR_ORDER_LINE_FIELD_VALUES
	WHERE  order_id = :d_order_id
	AND	   order_line_num = 1
	AND    order_line_field_mnemonic = 'PAT_PREPS_TEXT'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select substr(order_line_field_value,1,30) into :b0  from OR\
_ORDER_LINE_FIELD_VALUES where ((order_id=:b1 and order_line_num=1) and order_\
line_field_mnemonic='PAT_PREPS_TEXT')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1210;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_prep_text;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_order_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
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




    d_prep_text.arr[d_prep_text.len] = '\0';
	

	if (OERROR)
	{
	  sprintf(string_var,"%s  get_prep_text() -> %s\n", d_specimen_no.arr,
			sqlca.sqlerrm.sqlerrmc);
	  ins_message(ORA_MESG, string_var);
      }

    if (NO_DATA_FOUND)
        return 0;   

    return 1;

}


/***************** Print BarCode Label ********************/

 print_barcode_label(int nolabel)
  {
    int i;

      if (strcmp(nd_trx_ind.arr,"Y") == 0)
	  {
		  for(i=0;i<d_no_labels;i++)	 
		   {

			WSPrintDocument
				(
					uid_pwd.arr,		//char	*PUidPwd;
					nd_session_id.arr,	//char	*PSessionID;
					nd_operating_facility_id.arr,	//char	*PFacilityID;
					"RL",				//char	*PModuleID;
					"RLRSPCLB",			//char	*PDocumentID;
					filename,			//char	*POnlinePrintFileNames;
					"O",				//char	*PLocationTypes;
					d_section_code.arr,	//char	*PLocationCodes;
					1,					//int	PNumOfCopies;
					1,					//int	PPageFrom;
					9999,				//int	PPageTo;
					nd_ws_no.arr,		//char	*PWorkstationID
					WORKING_DIR			//char	*PReportOutputDir
				);
		   }

	  }
	  else
	  {
		
		  for(i=0;i<d_no_labels;i++)	 
		   {
			  WSPrintDocument
					   (
						uid_pwd.arr,		//char	*PUidPwd;
						nd_session_id.arr,	//char	*PSessionID;
						nd_operating_facility_id.arr,	//char	*PFacilityID;
						"RL",				//char	*PModuleID;
						"RLRSPCLB",			//char	*PDocumentID;
						filename,			//char	*POnlinePrintFileNames;
						"O",				//char	*PLocationTypes;
						" ",				//char	*PLocationCodes;
						1,					//int	PNumOfCopies;
						1,					//int	PPageFrom;
						9999,				//int	PPageTo;
						nd_ws_no.arr,		//char	*PWorkstationID
						WORKING_DIR			//char	*PReportOutputDir
					   );
			}
			
	   }
	}
  