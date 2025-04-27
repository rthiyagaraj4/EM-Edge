
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
    "D:\\WORK\\ML-MMOH-CRF-0752.6-US001\\Proc\\RLRSLPAT\\RLRSLPAT.pc"
};


static unsigned long sqlctx = 1142701877;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {10,18};

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

 static const char *sq0013 = 
"select SPECIMEN_NO ,PATIENT_ID ,SECTION_CODE ,EPISODE_TYPE ,SOURCE_CODE ,CON\
SULTANT_CODE ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SPEC_\
REGD_DATE_TIME,'DD/MM/YYYY') ,REQUEST_COMMENT_DESC1 ,REQUEST_COMMENT_DESC2 ,RE\
QUEST_COMMENT_DESC3 ,SPECIMEN_TYPE_CODE ,CATEGORY_CODE ,CATEGORY_YEAR ,CATEGOR\
Y_NUMBER ,ASSIGN_TO ,SOURCE_TYPE ,ORDERED_FACILITY_ID  from RL_REQUEST_HEADER \
where ((((((((PATIENT_ID=NVL(:b0,PATIENT_ID) and SPEC_REGD_DATE_TIME between T\
O_DATE(:b1,'DD/MM/YYYY HH24:MI') and TO_DATE(:b2,'DD/MM/YYYY HH24:MI')) and OP\
ERATING_FACILITY_ID=:b3) and SECTION_CODE=DECODE(:b4,'*A',SECTION_CODE,:b4)) a\
nd SOURCE_CODE between NVL(:b6,source_code) and NVL(:b7,source_code)) and SOUR\
CE_TYPE=DECODE(NVL(:b8,SOURCE_TYPE),'C','C','W','W','R','E','E','E')) and NVL(\
ASSIGN_TO,'!!!!')=NVL(:b9,NVL(assign_to,'!!!!'))) and NVL(CATEGORY_CODE,'!!!!'\
)=NVL(:b10,NVL(category_code,'!!!!'))) and NVL(CANCELLED_YN,'N')<>'Y') order b\
y PATIENT_ID,SPEC_REGD_DATE_TIME,SPECIMEN_NO            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,539,189,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,541,237,0,0,0,0,0,1,0,
51,0,0,3,0,0,544,244,0,0,0,0,0,1,0,
66,0,0,4,120,0,518,251,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
89,0,0,5,136,0,518,262,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
112,0,0,6,242,0,516,286,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
175,0,0,7,91,0,514,342,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
198,0,0,8,0,0,544,350,0,0,0,0,0,1,0,
213,0,0,9,158,0,516,360,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
248,0,0,10,0,0,544,384,0,0,0,0,0,1,0,
263,0,0,11,100,0,516,403,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
290,0,0,12,55,0,516,416,0,0,1,0,0,1,0,2,3,0,0,
309,0,0,13,990,0,521,494,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
368,0,0,14,0,0,544,504,0,0,0,0,0,1,0,
383,0,0,13,0,0,525,647,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,
470,0,0,15,0,0,544,699,0,0,0,0,0,1,0,
485,0,0,16,67,0,516,709,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
508,0,0,17,197,0,518,786,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
535,0,0,18,0,0,544,868,0,0,0,0,0,1,0,
550,0,0,19,86,0,516,880,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
573,0,0,20,0,0,544,891,0,0,0,0,0,1,0,
588,0,0,21,101,0,516,903,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
615,0,0,22,0,0,544,915,0,0,0,0,0,1,0,
630,0,0,23,254,0,516,924,0,0,7,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,
673,0,0,24,0,0,544,944,0,0,0,0,0,1,0,
688,0,0,25,254,0,516,953,0,0,7,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,
731,0,0,26,0,0,544,974,0,0,0,0,0,1,0,
746,0,0,27,57,0,516,998,0,0,1,0,0,1,0,2,9,0,0,
765,0,0,28,100,0,516,1001,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,4,0,0,
792,0,0,29,99,0,516,1031,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
819,0,0,30,211,0,518,1110,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
846,0,0,31,211,0,518,1127,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
873,0,0,32,156,0,518,1279,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
896,0,0,33,115,0,516,1323,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
927,0,0,34,125,0,516,1329,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
962,0,0,35,98,0,516,1336,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
989,0,0,36,98,0,516,1342,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1016,0,0,37,0,0,544,1360,0,0,0,0,0,1,0,
1031,0,0,38,101,0,518,1457,0,0,1,1,0,1,0,2,3,0,0,
1050,0,0,39,49,0,516,1470,0,0,1,0,0,1,0,2,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: rlrslpat.pc
   Author : Hameed 
   Date Created : 19/02/2005


*  Ver 1.10.01   
   
*  Purpose : To generate a Specimen List by patient.
  
*  Input Parameters : 
                      Command line inputs
		              1. Usr_id/Password
                      2. Session id
		              3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4. Preferred range of Specimen Numbers. 
                      5. Range of Process Dates 
  
*  Table Accessed : RL_REQUEST_HEADER,
		            MP_PATIENT_MAST,RL_PATIENT_MAST. 

*  Output File : rlrslpat.lis
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h> 
#include <stdlib.h>
#include "gl.h"

#define MAX_LINES 45
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ESC 0x1B
/*#define DEBUG 1*/ 



/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR     nd_operating_facility_id   [3],
	            uid_pwd		               [91],
                nd_file_name               [151],
                nd_user	                   [15],
                nd_file_no                 [15],
                nd_printer_name            [16],
				d_version_no			   [20],
				d_version  			       [20],

        /o Variables to recieve data from specimen register cursoro/ 
        d_specimen_no           [21],
		d_patient_name          [61],
		d_patient_name_1		[61],
		d_patient_name_2		[61],
		d_patient_name_3		[61],
		d_patient_name_4		[61],
		d_patient_id            [21],
		d_section_code          [3],
		d_section_desc          [16],
		d_source_code           [7],
		d_src_type				[2],
        d_episode_type          [2],
        d_req_comment_1         [45],
        d_req_comment_2         [45],
        d_req_comment_3         [45],
		d_consultant_code       [16],
		d_spec_date             [21],
		d_spec_date1            [21],
		l_spec_date             [21],
		d_dob                   [11],
		d_date_of_birth			[11],
		d_actual_dob_yn			[2],
		d_sex                   [2],
		d_specimen_type_code    [5],

		d_specimen_type_desc	[41],
		
		d_category_code         [5],
		d_category_year         [5],
		d_category_num          [16],
		d_assign_to             [31],
		nd_src_desc				[100],  /oModified By Manoj S for ML-MMOH-CRF-0752.6o/
		rl_ordered_facility_id	[3],
		d_department_desc		[41],
        /o input parameters to main() o/
        nd_session_id      	[16],
		nd_pgm_date	   	[20],
		nd_sp_prfx				[3],


		/o input parameters through from SY_PROG_PARAM o/
 		nd_fr_specimen_no       [21], 
 		nd_to_specimen_no       [21],
		nd_fr_spec_no			[21], 
 		nd_to_spec_no		    [21],
 		nd_fr_process_date    	[31],
		nd_fr_process_date1     [31],   //added for globalisation
 		nd_to_process_date    	[31],
		nd_to_process_date1     [31],   //added for globalisation
		nd_patient_id           [31],
        nd_dept                 [2],
        nd_src_type             [2],


/o****** added on 18/6/2002 for KN ENHANCEMENT by Ananthi******o/
        nd_fr_ref_source        [7],
		nd_to_ref_source        [7],
		nd_category_code        [5],
		nd_assign_to            [31],
		d_location				[11],

		/o for header routine  o/
        //d_acc_entity_name        [61],
		d_acc_entity_name        [300],
		d_user                   [21],
		d_sysdate                [17],
		d_sysdate1               [17]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[15]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_printer_name;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_1;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_2;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_3;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_4;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[3]; } d_section_code;

struct { unsigned short len; unsigned char arr[16]; } d_section_desc;

struct { unsigned short len; unsigned char arr[7]; } d_source_code;

struct { unsigned short len; unsigned char arr[2]; } d_src_type;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[45]; } d_req_comment_1;

struct { unsigned short len; unsigned char arr[45]; } d_req_comment_2;

struct { unsigned short len; unsigned char arr[45]; } d_req_comment_3;

struct { unsigned short len; unsigned char arr[16]; } d_consultant_code;

struct { unsigned short len; unsigned char arr[21]; } d_spec_date;

struct { unsigned short len; unsigned char arr[21]; } d_spec_date1;

struct { unsigned short len; unsigned char arr[21]; } l_spec_date;

struct { unsigned short len; unsigned char arr[11]; } d_dob;

struct { unsigned short len; unsigned char arr[11]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[2]; } d_actual_dob_yn;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[5]; } d_specimen_type_code;

struct { unsigned short len; unsigned char arr[41]; } d_specimen_type_desc;

struct { unsigned short len; unsigned char arr[5]; } d_category_code;

struct { unsigned short len; unsigned char arr[5]; } d_category_year;

struct { unsigned short len; unsigned char arr[16]; } d_category_num;

struct { unsigned short len; unsigned char arr[31]; } d_assign_to;

struct { unsigned short len; unsigned char arr[100]; } nd_src_desc;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_department_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_sp_prfx;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_spec_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_spec_no;

struct { unsigned short len; unsigned char arr[31]; } nd_fr_process_date;

struct { unsigned short len; unsigned char arr[31]; } nd_fr_process_date1;

struct { unsigned short len; unsigned char arr[31]; } nd_to_process_date;

struct { unsigned short len; unsigned char arr[31]; } nd_to_process_date1;

struct { unsigned short len; unsigned char arr[31]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[2]; } nd_dept;

struct { unsigned short len; unsigned char arr[2]; } nd_src_type;

struct { unsigned short len; unsigned char arr[7]; } nd_fr_ref_source;

struct { unsigned short len; unsigned char arr[7]; } nd_to_ref_source;

struct { unsigned short len; unsigned char arr[5]; } nd_category_code;

struct { unsigned short len; unsigned char arr[31]; } nd_assign_to;

struct { unsigned short len; unsigned char arr[11]; } d_location;

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


	int l_specimen_length = 0;

	int  l_tab_exists ;


/* EXEC SQL END DECLARE SECTION; */ 


	int	 l_len = 30;
	char l_delimeter;

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
long  nd_totl_specimens      = 0;

int   l_length = 0;
int   i;

/* summary fields for calculating No. of records */ 
void print_page_header();
void print_col_heading();
FILE *f1;
char string_var[100];

char local_legend[40][600];  //added for globalisation

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
  	dclr_specimen_register(),
  	do_report();
 
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

  

   #ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
   #endif  
 
   set_meduser_role();

   /******* from here added for globalisation ********/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
   /******* upto here added for globalisation ********/

   #ifdef DEBUG
    printf("I am here main() 0\n");
    fflush(stdout);
   #endif  

   get_params();

   get_legend_value(33);  //added for globalisation

   #ifdef DEBUG
    printf("I am here main() 1");
    fflush(stdout);
   #endif  
   gen_file_name();
   /*increment_file_no();*/

   get_header_dtls();

   #ifdef DEBUG
    printf("I am here main() 2");
    fflush(stdout);
   #endif  

   dclr_specimen_register();

   #ifdef DEBUG
    printf("I am here main() 3");
    fflush(stdout);
   #endif  

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

get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRSLPAT.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRSLPAT.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRSLPAT.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLRSLPAT.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )89;
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


/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
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
		   PARAM9
           INTO 
		   :nd_operating_facility_id,
           :nd_fr_process_date,
           :nd_to_process_date,
  		   :nd_dept,
		   :nd_patient_id,
		   :nd_fr_ref_source,
		   :nd_to_ref_source,
		   :nd_category_code,
		   :nd_assign_to,
		   :nd_src_type           
            FROM SY_PROG_PARAM
	        WHERE   PGM_ID = 'RLRSLPAT'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b\
7,:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='RLRSLPAT' and SESSION_ID=TO_NUMB\
ER(:b10)) and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )112;
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
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_process_date;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_dept;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[4] = (unsigned int  )33;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fr_ref_source;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_ref_source;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_category_code;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_assign_to;
   sqlstm.sqhstl[8] = (unsigned int  )33;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_src_type;
   sqlstm.sqhstl[9] = (unsigned int  )4;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[11] = (unsigned int  )22;
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



   // strcpy(nd_fr_specimen_no.arr,nd_fr_spec_no.arr);
   // nd_fr_specimen_no.len = strlen(nd_fr_specimen_no.arr);

   // strcpy(nd_to_specimen_no.arr,nd_to_spec_no.arr);
   // nd_to_specimen_no.len = strlen(nd_to_specimen_no.arr);
   
   nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
   // nd_fr_specimen_no.arr[nd_fr_specimen_no.len]     = '\0';
   // nd_to_specimen_no.arr[nd_to_specimen_no.len]     = '\0';
   // nd_fr_spec_no.arr[nd_fr_spec_no.len]     = '\0';
   // nd_to_spec_no.arr[nd_to_spec_no.len]     = '\0';
   nd_fr_process_date.arr[nd_fr_process_date.len]   = '\0';
   nd_to_process_date.arr[nd_to_process_date.len]   = '\0';
   nd_patient_id.arr[nd_patient_id.len]             = '\0';
   nd_fr_ref_source.arr[nd_fr_ref_source.len]       = '\0';
   nd_to_ref_source.arr[nd_to_ref_source.len]       = '\0';
   nd_category_code.arr[nd_category_code.len]       = '\0';
   nd_assign_to.arr[nd_assign_to.len]               = '\0';
   nd_src_type.arr[nd_src_type.len]					= '\0';

  #ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   // printf("nd_fr_specimen_no : %s\n", nd_fr_specimen_no.arr);
   // printf("nd_to_specimen_no :%s\n", nd_to_specimen_no.arr);
   printf("nd_fr_process_date :%s\n", nd_fr_process_date.arr);
   printf("nd_to_process_date : %s\n", nd_to_process_date.arr);
  #endif

  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE PGM_ID = 'RLRSLPAT'
	         AND SESSION_ID = :nd_session_id
		 AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='RLRSLPAT' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )175;
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
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )198;
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

   /* EXEC SQL SELECT ACC_ENTITY_NAME, /o description of the institution o/
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
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:b\
3 and language_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )213;
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
   sqlstm.arrsiz = 12;
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

  
  nd_sp_prfx.arr[0]   = '\0';
  nd_sp_prfx.len      = 0;
  d_department_desc.arr[0]   = '\0';
  d_department_desc.len      = 0;

  if (strcmp(nd_dept.arr, "*A") != 0)
  {
	/* EXEC SQL SELECT 
	// SPECIMEN_PREFIX,
	LONG_NAME
	INTO 
	// :nd_sp_prfx,
	:d_department_desc
	FROM RL_SECTION_CODE_lang_vw
	WHERE SECTION_CODE = :nd_dept
	AND language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_NAME into :b0  from RL_SECTION_CODE_lang_vw wher\
e (SECTION_CODE=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )263;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_department_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_dept;
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



	nd_sp_prfx.arr[nd_sp_prfx.len] = '\0';
   }
  
  /* EXEC SQL SELECT NVL(specimen_length, 15)
	     INTO :l_specimen_length
	     FROM RL_PARAM; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(specimen_length,15) into :b0  from RL_PARAM ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )290;
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



  l_length = l_specimen_length -  strlen(nd_sp_prfx.arr);

  if(strlen(nd_fr_specimen_no.arr) == 0)
  {
    /**
    strcpy(nd_fr_specimen_no.arr,nd_sp_prfx.arr);

	for (i=1; i<= l_length; i++)
	{
  	   strcat(nd_fr_specimen_no.arr,"0");
	}
    **/
	for (i=1; i<= l_specimen_length; i++)
	{
  	   strcat(nd_fr_specimen_no.arr,"0");
	}
	
	nd_fr_specimen_no.len = strlen(nd_fr_specimen_no.arr);
  }

  if(strlen(nd_to_specimen_no.arr) == 0)
  {
/**     
	 strcpy(nd_to_specimen_no.arr,nd_sp_prfx.arr);
	
	for (i=1; i<= l_length; i++)
	{
  	   strcat(nd_to_specimen_no.arr,"9");
	}
**/  
	for (i=1; i<= l_specimen_length; i++)
	{
  	   strcat(nd_to_specimen_no.arr,"9");
	}
	 
    nd_to_specimen_no.len = strlen(nd_to_specimen_no.arr);

  }


  /* EXEC SQL DECLARE SPECIMEN_REGISTER CURSOR FOR
     SELECT SPECIMEN_NO,PATIENT_ID,SECTION_CODE, EPISODE_TYPE,SOURCE_CODE,
	    CONSULTANT_CODE,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
		TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),
	    REQUEST_COMMENT_DESC1,REQUEST_COMMENT_DESC2,REQUEST_COMMENT_DESC3,
            SPECIMEN_TYPE_CODE,CATEGORY_CODE,CATEGORY_YEAR,CATEGORY_NUMBER,
			ASSIGN_TO,SOURCE_TYPE,ORDERED_FACILITY_ID
       FROM RL_REQUEST_HEADER
      WHERE PATIENT_ID = NVL(:nd_patient_id, PATIENT_ID)
	    /o*
		AND SPEC_REGD_DATE_TIME > TO_DATE(:nd_fr_process_date,'DD/MM/YYYY')
        AND SPEC_REGD_DATE_TIME < TO_DATE(:nd_to_process_date,'DD/MM/YYYY')+1
		*o/
		
		AND SPEC_REGD_DATE_TIME BETWEEN TO_DATE(:nd_fr_process_date,'DD/MM/YYYY HH24:MI')
		                        AND TO_DATE(:nd_to_process_date,'DD/MM/YYYY HH24:MI')
        AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		/o*
		AND SPECIMEN_NO >=  TO_NUMBER(:nd_fr_specimen_no)
		AND SPECIMEN_NO <=  TO_NUMBER(:nd_to_specimen_no) 
		*o/

		AND SECTION_CODE = DECODE(:nd_dept,'*A',SECTION_CODE, :nd_dept)
		AND SOURCE_CODE  BETWEEN NVL(:nd_fr_ref_source,source_code)
		    AND NVL(:nd_to_ref_source,source_code)
        AND SOURCE_TYPE = DECODE(NVL(:nd_src_type,SOURCE_TYPE),'C','C','W','W','R','E','E','E')
		AND NVL(ASSIGN_TO,'!!!!')    =   NVL(:nd_assign_to,NVL(assign_to,'!!!!'))
		AND NVL(CATEGORY_CODE,'!!!!')  = NVL(:nd_category_code,NVL(category_code,'!!!!'))
		AND NVL(CANCELLED_YN,'N') != 'Y' 
        ORDER BY PATIENT_ID , SPEC_REGD_DATE_TIME, SPECIMEN_NO; */ 


     
     /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  
     /* EXEC SQL OPEN SPECIMEN_REGISTER; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )309;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[0] = (unsigned int  )33;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_fr_process_date;
     sqlstm.sqhstl[1] = (unsigned int  )33;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_to_process_date;
     sqlstm.sqhstl[2] = (unsigned int  )33;
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
     sqlstm.sqhstv[4] = (         void  *)&nd_dept;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_dept;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_fr_ref_source;
     sqlstm.sqhstl[6] = (unsigned int  )9;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_to_ref_source;
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
     sqlstm.sqhstv[9] = (         void  *)&nd_assign_to;
     sqlstm.sqhstl[9] = (unsigned int  )33;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_category_code;
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
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )368;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_specimen_register() occured....\n");
   proc_exit();
}


/* prints the master-detail record until the cursor is empty */
void do_report()
{
  void prepare_new_page();
  void print_detl_rec();
  void end_report();
  void print_rep_header();
  int fetch_specimen_register();
  int still_rec_left;


  #ifdef DEBUG
      printf("entered do_report()\n");
  #endif
  
  prepare_new_page();
  print_rep_header() ;
  prepare_new_page();

  /* read the first cursor record */
  
  still_rec_left = fetch_specimen_register();

  #ifdef DEBUG
      printf("entered do_report()\n");
      fflush(stdout);
  #endif

  while(still_rec_left)
  {
	if ((line_no + 3) >= MAX_LINES)
       {
          prepare_new_page();
          print_detl_rec();
       }
       else 
          print_detl_rec();

    nd_totl_specimens += 1;
    still_rec_left = fetch_specimen_register();
  }

	if ((line_no + 3) >= MAX_LINES)
  {
    prepare_new_page();
	print_total_request();
  }
  else
  {
	print_total_request();
  }

  #ifdef DEBUG
      printf("entered do_report outside while()\n");
      fflush(stdout);
  #endif
  end_report();
}

print_total_request()
{

   fprintf(f1, "\n");
   fprintf(f1, "--------------------------------------------------------------------");
   fprintf(f1, "----------------------------------------------------------------");
   fprintf(f1, "\n");
   
   //fprintf(f1, "Total Requests : %ld", nd_totl_specimens);
   fprintf(f1, "%14.14s : %ld", local_legend[33],nd_totl_specimens);

   fprintf(f1, "\n");
   fprintf(f1, "--------------------------------------------------------------------");
   fprintf(f1, "----------------------------------------------------------------");
   
}

/* prepares for the new page */
void prepare_new_page()
{
   #if DEBUG
     printf("entered prepare_new_page\n");
     fflush(stdout);
   #endif
   page_no += 1; /* incr. by 1 to move to subsequent pages */
   line_no = 0;
   if (page_no != 1)
   fprintf(f1,"");
   print_page_header();
   if (page_no != 1) 
   print_col_heading(); 
}

/* fetches the next record from SPECIMEN REGISTER CURSOR */
/* returns 0 if the end of cursor is reached else returns 1. */
int fetch_specimen_register()
{

void get_location();

  d_specimen_no.arr[0]        = '\0';
  d_specimen_type_code.arr[0] = '\0';
  d_patient_id.arr[0]         = '\0';
  d_section_code.arr[0]       = '\0';
  d_source_code.arr[0]        = '\0';
  d_src_type.arr[0]           = '\0';
  d_consultant_code.arr[0]    = '\0';
  d_spec_date.arr[0]          = '\0';
  l_spec_date.arr[0]          = '\0';
  d_req_comment_1.arr[0]      = '\0';
  d_req_comment_2.arr[0]      = '\0';
  d_req_comment_3.arr[0]      = '\0';
  d_category_code.arr[0]      = '\0';
  d_category_year.arr[0]      = '\0';
  d_category_num.arr[0]       = '\0';
  d_assign_to.arr[0]          = '\0';
  rl_ordered_facility_id.arr[0]	= '\0';

  d_specimen_no.len           = 0;
  d_specimen_type_code.len    = 0;
  d_patient_id.len         = 0;
  d_section_code.len       = 0;
  d_source_code.len        = 0;
  d_src_type.len           = 0;
  d_consultant_code.len    = 0;
  d_spec_date.len          = 0;
  l_spec_date.len          = 0;
  d_req_comment_1.len      = 0;
  d_req_comment_2.len      = 0;
  d_req_comment_3.len      = 0;
  d_category_code.len      = 0;
  d_category_year.len      = 0;
  d_category_num.len       = 0;
  d_assign_to.len          = 0;
  rl_ordered_facility_id.len  = 0;


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH SPECIMEN_REGISTER INTO
                 d_specimen_no, d_patient_id,d_section_code,d_episode_type,
		         d_source_code, d_consultant_code,d_spec_date,l_spec_date,
		         d_req_comment_1,d_req_comment_2,d_req_comment_3,
		         d_specimen_type_code,d_category_code,
		         d_category_year,d_category_num,d_assign_to,d_src_type,:rl_ordered_facility_id ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )383;
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
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_section_code;
  sqlstm.sqhstl[2] = (unsigned int  )5;
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
  sqlstm.sqhstv[4] = (         void  *)&d_source_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_consultant_code;
  sqlstm.sqhstl[5] = (unsigned int  )18;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_spec_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_spec_date;
  sqlstm.sqhstl[7] = (unsigned int  )23;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_req_comment_1;
  sqlstm.sqhstl[8] = (unsigned int  )47;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_req_comment_2;
  sqlstm.sqhstl[9] = (unsigned int  )47;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_req_comment_3;
  sqlstm.sqhstl[10] = (unsigned int  )47;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_specimen_type_code;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_category_code;
  sqlstm.sqhstl[12] = (unsigned int  )7;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_category_year;
  sqlstm.sqhstl[13] = (unsigned int  )7;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_category_num;
  sqlstm.sqhstl[14] = (unsigned int  )18;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_assign_to;
  sqlstm.sqhstl[15] = (unsigned int  )33;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_src_type;
  sqlstm.sqhstl[16] = (unsigned int  )4;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&rl_ordered_facility_id;
  sqlstm.sqhstl[17] = (unsigned int  )5;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_specimen_no.arr[d_specimen_no.len]      = '\0';
  d_patient_id.arr[d_patient_id.len]        = '\0';
  d_section_code.arr[d_section_code.len]    = '\0';
  d_episode_type.arr[d_episode_type.len]    = '\0';
  d_source_code.arr[d_source_code.len]      = '\0';
  d_src_type.arr[d_src_type.len]            = '\0';
  d_consultant_code.arr[d_consultant_code.len]    = '\0';
  d_spec_date.arr[d_spec_date.len]          = '\0';
  l_spec_date.arr[l_spec_date.len]          = '\0';
  d_req_comment_1.arr[d_req_comment_1.len]  = '\0';
  d_req_comment_2.arr[d_req_comment_2.len]  = '\0';
  d_req_comment_3.arr[d_req_comment_3.len]  = '\0';
  d_specimen_type_code.arr[d_specimen_type_code.len] = '\0';
  d_category_code.arr[d_category_code.len]  = '\0';
  d_category_year.arr[d_category_year.len]  = '\0';
  d_category_num.arr[d_category_num.len]    = '\0';
  d_assign_to.arr[d_assign_to.len]          = '\0';
  rl_ordered_facility_id.arr[rl_ordered_facility_id.len]	= '\0';


#ifdef DEBUG
 printf("d_specimen_no = %s\n",d_specimen_no.arr);
 printf("d_patient_id = %s\n",d_patient_id.arr);
 printf("d_episode_type = %s\n",d_episode_type.arr);
 printf("d_source_code = %s\n",d_source_code.arr);
 printf("d_src_type = %s\n",d_src_type.arr);
 printf("d_consultant_code = %s\n",d_consultant_code.arr);
 printf("d_spec_date = %s\n",d_spec_date.arr);
 printf("d_req_comment_1 = %s\n",d_req_comment_1.arr);
 printf("d_req_comment_2 = %s\n",d_req_comment_2.arr);
 printf("d_req_comment_3 = %s\n",d_req_comment_3.arr);
#endif

get_location();

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )470;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_specimen_register() occured....\n");
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
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select location into :b0  from rl_patient_mast where PATIE\
NT_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )485;
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


		/* AND OPERATING_FACILITY_ID = :nd_operating_facility_id;*/


  d_location.arr[d_location.len] = '\0';

  return;

}



/* print the finishing line of the report */
void end_report()
{
  fprintf(f1,"\n\n\n");
  fprintf(f1,"\n");
  fprintf(f1,"                                                   ");
  
  //fprintf(f1,"** End of Report **");
  fprintf(f1,"** %13.13s **",local_legend[29]);

  fprintf(f1,"");
}

/* to print the detailed record */
void print_detl_rec()
{
    int  get_patient_dtl(); 
    void get_referral_patient_dtl();
	char l_age_legend[5];
    int i = 0;

	
    if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0 || strcmp(d_episode_type.arr,"H")==0)
    { 
  	  i=get_patient_dtl();
      
    } 
    else
    if(strcmp(d_episode_type.arr,"R")==0)
      get_referral_patient_dtl();

    if(d_specimen_type_code.len)
	{  d_specimen_type_desc.arr[0] = '\0';
	   d_specimen_type_desc.len = 0;
       get_spec_type_desc();
	}

    patient_age();

	if (strcmp(d_actual_dob_yn.arr, "Y") == 0)
		strcpy(l_age_legend, "");
	else
		strcpy(l_age_legend, "*");

    get_source_desc();    // 26.04.2003

	if (strcmp(nd_dept.arr, "*A") == 0)
	{
	  get_section_desc();
	}


   	l_delimeter = ' ';
	rl_split_text(d_patient_name.arr,l_delimeter,l_len,d_patient_name_1.arr,
			      d_patient_name_2.arr,d_patient_name_3.arr,d_patient_name_4.arr);

	fprintf(f1,"%-18.18s%-31s%-21s%-1.1s%-12.12s%-4s%-5s%-16.16s%-12s%-7s\n",
	 d_specimen_no.arr,d_patient_name_1.arr,d_patient_id.arr,l_age_legend,t_age.arr,
	 d_sex.arr,d_source_code.arr,nd_src_desc.arr,d_location.arr,d_consultant_code.arr);

	
	//fprintf(f1,"%-18.18s%-31s%-43.43s",d_spec_date.arr,d_patient_name_2.arr,d_specimen_type_desc.arr);
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
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :d_spec_date , 'DD/MM/YYYY' ) , :language_id , t_date ) ;\
 :d_spec_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )508;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_spec_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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


	fprintf(f1,"%-18.18s%-31s%-43.43s",d_spec_date1.arr,d_patient_name_2.arr,d_specimen_type_desc.arr);
	
	if (strcmp(nd_dept.arr, "*A") == 0)
	{
	  fprintf(f1,"%-20.20s\n",d_section_desc.arr);
	}
	else
	  fprintf(f1,"\n");
 
	line_no += 2;

	fprintf(f1,"%-18s"," ");
	line_no += 1;

 if (strlen(d_category_num.arr))
   {

    //	fprintf(f1,"%5.5s/%-4.4s/%-16.16s %s",
    //				d_category_code.arr,d_category_year.arr,
    //				d_category_num.arr,d_assign_to.arr);

	fprintf(f1,"%s/%s/%-22.22s %s",
				d_category_code.arr,d_category_year.arr,
				d_category_num.arr,d_assign_to.arr);
	}
 else 
	if (strlen(d_assign_to.arr))
	{
	fprintf(f1,"%-32s%s"," ",d_assign_to.arr);
	}   
    
	fprintf(f1,"\n");

   if(line_no + 3 >= MAX_LINES)
       {
          prepare_new_page();
		}
    if(strlen(d_req_comment_1.arr))
    {
       fprintf(f1,"%83.83s%-41s\n"," ",d_req_comment_1.arr);
       line_no += 1;
    }

   if(line_no + 3 >= MAX_LINES)
       {
          prepare_new_page();
		}

    if(strlen(d_req_comment_2.arr))
    {
       fprintf(f1,"%83.83s%-41s\n"," ",d_req_comment_2.arr);
       line_no += 1;
    }

   if ((line_no + 3) >= MAX_LINES)
       {
          prepare_new_page();
		}

    if(strlen(d_req_comment_3.arr))
    {
       fprintf(f1,"%83.83s%-41s\n"," ",d_req_comment_3.arr);
       line_no += 1;
    }

	/*
    fprintf(f1,"\n");
    line_no += 1;
	*/

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )535;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}

/* Function to fetch the Specimen Type description */
get_spec_type_desc()
{
  d_specimen_type_desc.arr[0] = '\0';
  d_specimen_type_desc.len = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT SPECIMEN_DESC
	         INTO :d_specimen_type_desc
             FROM RL_SPECIMEN_TYPE_CODE
	        WHERE SPECIMEN_TYPE_CODE = :d_specimen_type_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SPECIMEN_DESC into :b0  from RL_SPECIMEN_TYPE_CODE w\
here SPECIMEN_TYPE_CODE=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )550;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_type_desc;
  sqlstm.sqhstl[0] = (unsigned int  )43;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  d_specimen_type_desc.arr[d_specimen_type_desc.len] = '\0';

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )573;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_spec_type_desc() occured....\n");
   proc_exit();
}

/* Function to fetch the SECTION description */
get_section_desc()
{
  d_section_desc.arr[0] = '\0';
  d_section_desc.len = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT SHORT_NAME
	         INTO :d_section_desc
             FROM RL_SECTION_CODE_lang_vw
	        WHERE SECTION_CODE = :d_section_code
			AND language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_NAME into :b0  from RL_SECTION_CODE_lang_vw wh\
ere (SECTION_CODE=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )588;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_section_desc;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_section_code;
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



  d_section_desc.arr[d_section_desc.len] = '\0';

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )615;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_section_desc() occured....\n");
   proc_exit();
}

/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT DECODE(:language_id,'en',SUBSTR(SHORT_NAME,1,25),'th',SUBSTR(SHORT_NAME_LOC_LANG,1,25)),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY'),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),SEX,NVL(actual_dob_yn, 'N')
	       INTO   :d_patient_name,:d_dob,:d_date_of_birth,:d_sex,:d_actual_dob_yn
           FROM   RL_PATIENT_MAST
	       WHERE  PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DECODE(:b0,'en',SUBSTR(SHORT_NAME,1,25),'th',SUBSTR(\
SHORT_NAME_LOC_LANG,1,25)) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') ,TO_CHAR(DATE_OF\
_BIRTH,'DD/MM/YYYY') ,SEX ,NVL(actual_dob_yn,'N') into :b1,:b2,:b3,:b4,:b5  fr\
om RL_PATIENT_MAST where PATIENT_ID=:b6";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )630;
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
  sqlstm.sqhstl[1] = (unsigned int  )63;
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
  sqlstm.sqhstl[3] = (unsigned int  )13;
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
  sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )23;
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


		   /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_dob.arr[d_dob.len]                       = '\0';
  d_actual_dob_yn.arr[d_actual_dob_yn.len]		 = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]	 = '\0';
  d_sex.arr[d_sex.len]                       = '\0';

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
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )673;
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

   /* EXEC SQL SELECT DECODE(:language_id,'en',SUBSTR(SHORT_NAME,1,25),'th',SUBSTR(SHORT_NAME_LOC_LANG,1,25)),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY'),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),SEX,NVL(actual_dob_yn, 'N')
	    INTO   :d_patient_name,:d_dob,:d_date_of_birth,:d_sex,:d_actual_dob_yn
            FROM   MP_PATIENT_MAST 
	    WHERE  PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DECODE(:b0,'en',SUBSTR(SHORT_NAME,1,25),'th',SUBSTR\
(SHORT_NAME_LOC_LANG,1,25)) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') ,TO_CHAR(DATE_O\
F_BIRTH,'DD/MM/YYYY') ,SEX ,NVL(actual_dob_yn,'N') into :b1,:b2,:b3,:b4,:b5  f\
rom MP_PATIENT_MAST where PATIENT_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )688;
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
   sqlstm.sqhstl[1] = (unsigned int  )63;
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
   sqlstm.sqhstl[3] = (unsigned int  )13;
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
   sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[6] = (unsigned int  )23;
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


  if(NODATAFOUND)
     return 0;
  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_dob.arr[d_dob.len]                       = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]	 = '\0';
  d_sex.arr[d_sex.len]                       = '\0';
  d_actual_dob_yn.arr[d_actual_dob_yn.len]	 = '\0';
  

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
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )731;
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
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )746;
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
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ABS(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),TO_DA\
TE(:b1,'DD/MM/YYYY'))) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )765;
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
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ROUND((TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:\
b1,'DD/MM/YYYY')),3)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )792;
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
			
			//strcat(t_age.arr, "Y");
			strcat(t_age.arr, local_legend[30]);

			sprintf(st_r, " %f", tmp_mths);
			strcat(t_age.arr, strtok(st_r, "."));
			
			//strcat(t_age.arr, "M");
			strcat(t_age.arr, local_legend[31]);

			sprintf(st_r, " %f", tmp_days);
			strcat(t_age.arr, strtok(st_r, "."));
			
			//strcat(t_age.arr, "D ");
			strcat(t_age.arr, local_legend[32]);

				
 }
/*------------------------------------------------------------*/



/* to print the header page for the report */
void print_rep_header()
{
  char nd_fr_specimen_desc[21],
       nd_to_specimen_desc[21],
       nd_fr_process_date_desc[31],
       nd_to_process_date_desc[31],
       nd_dept_desc[2],
	   nd_fr_ref_source_desc[5],
	   nd_to_ref_source_desc[5],
	   nd_category_code_desc[5],
	   nd_assign_to_desc[21],
	   nd_patient_id_desc[31];



/****Commented on 05/04/2004 as per Mr Cyrus, to now display highest and lowest********

    if(strlen(nd_fr_specimen_no.arr) == 0)
       strcpy(nd_fr_specimen_desc, "LOWEST");
    else strcpy(nd_fr_specimen_desc, nd_fr_specimen_no.arr);

    if(strlen(nd_to_specimen_no.arr) == 0)
      strcpy(nd_to_specimen_desc, "HIGHEST");
    else strcpy(nd_to_specimen_desc, nd_to_specimen_no.arr);

******************/

	if(strlen(nd_fr_spec_no.arr) == 0)
       //strcpy(nd_fr_specimen_desc, "LOWEST");
	   strcpy(nd_fr_specimen_desc, local_legend[12]);
    else strcpy(nd_fr_specimen_desc, nd_fr_spec_no.arr);

    if(strlen(nd_to_spec_no.arr) == 0)
      //strcpy(nd_to_specimen_desc, "HIGHEST");
	  strcpy(nd_to_specimen_desc, local_legend[13]);
    else strcpy(nd_to_specimen_desc, nd_fr_spec_no.arr);

	if(strcmp(nd_fr_process_date.arr, "01/01/1800 00:00") == 0)
		//strcpy(nd_fr_process_date_desc, "LOWEST");
		strcpy(nd_fr_process_date_desc, local_legend[12]);
    else 
	{
		/* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_fr_process_date,'DD/MM/YYYY'), :language_id , t_date);
			:nd_fr_process_date1 := to_char(t_date,'DD/MM/YYYY');
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LO\
CALE_DATE ( to_date ( :nd_fr_process_date , 'DD/MM/YYYY' ) , :language_id , t_\
date ) ; :nd_fr_process_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )819;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_fr_process_date;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_fr_process_date1;
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
}


		//strcpy(nd_fr_process_date_desc, nd_fr_process_date.arr);
		strcpy(nd_fr_process_date_desc, nd_fr_process_date1.arr);
	}

    if(strcmp(nd_to_process_date.arr, "31/12/4712 00:00") == 0)
	    //strcpy(nd_to_process_date_desc, "HIGHEST");
		strcpy(nd_to_process_date_desc, local_legend[13]);
    else 
	{
		/* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_to_process_date,'DD/MM/YYYY'), :language_id , t_date);
			:nd_to_process_date1 := to_char(t_date,'DD/MM/YYYY');
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LO\
CALE_DATE ( to_date ( :nd_to_process_date , 'DD/MM/YYYY' ) , :language_id , t_\
date ) ; :nd_to_process_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )846;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_to_process_date;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_to_process_date1;
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
}


		//strcpy(nd_to_process_date_desc, nd_to_process_date.arr);
		strcpy(nd_to_process_date_desc, nd_to_process_date1.arr);
	}


	if (strlen(nd_patient_id.arr) == 0)
	  //strcpy(nd_patient_id_desc, "ALL");
	  strcpy(nd_patient_id_desc, local_legend[14]);
	else
	  strcpy(nd_patient_id_desc, nd_patient_id.arr);

    if(strlen(nd_dept.arr) == 0)
      //strcpy(nd_dept_desc, "ALL");
	  strcpy(nd_dept_desc, local_legend[14]);
    else if (strcmp(nd_dept.arr, "*A") == 0 )
	  //strcpy(nd_dept_desc, "ALL");
	  strcpy(nd_dept_desc, local_legend[14]);
	else
	  strcpy(nd_dept_desc, nd_dept.arr);

    if(strlen(nd_fr_ref_source.arr) == 0)
      //strcpy(nd_fr_ref_source_desc, "HIGHEST");
	  strcpy(nd_fr_ref_source_desc, local_legend[13]);
    else strcpy(nd_fr_ref_source_desc, nd_fr_ref_source.arr);

    if(strlen(nd_to_ref_source.arr) == 0)
      //strcpy(nd_to_ref_source_desc, "LOWEST");
	  strcpy(nd_to_ref_source_desc, local_legend[12]);
    else strcpy(nd_to_ref_source_desc, nd_to_ref_source.arr);

    if(strlen(nd_category_code.arr) == 0)
      //strcpy(nd_category_code_desc, "ALL");
	  strcpy(nd_category_code_desc, local_legend[14]);
    else strcpy(nd_category_code_desc, nd_category_code.arr);


    if(strlen(nd_assign_to.arr) == 0)
      //strcpy(nd_assign_to_desc, "ALL");
	  strcpy(nd_assign_to_desc, local_legend[14]);
    else strcpy(nd_assign_to_desc, nd_assign_to.arr);
	   	   	   
	   
  #ifdef DEBUG
      printf("before report header()\n");
  #endif

  #ifdef DEBUG
      printf("after page header()\n");  
  #endif 
  fprintf(f1,"--------------------------------------------------------------------");
  fprintf(f1,"----------------------------------------------------------------");
  fprintf(f1,"\n") ;

  get_version_no();   ///// added 01.07.2003

/////////// 01.07.2003  fprintf(f1,VER);

  fprintf(f1,"%s\n",d_version.arr);

  fprintf(f1,"\n\n\n\n"); 
  fprintf(f1,"        ");
  
  //fprintf(f1,"INPUT PARAMETERS :\n");
  fprintf(f1,"%16.16s :\n",local_legend[3]);

  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  // fprintf(f1,"                ");
  // fprintf(f1,"SPECIMEN NO. FROM : %s\n", nd_fr_specimen_desc);
  // fprintf(f1,"                ");
  // fprintf(f1,"               TO : %s\n", nd_to_specimen_desc);
  // fprintf(f1,"\n");
  fprintf(f1,"                ");
  
  //fprintf(f1,"DATE         FROM : %s\n", nd_fr_process_date_desc);
  fprintf(f1,"%4.4s         %4.4s : %s\n", local_legend[4],local_legend[5],nd_fr_process_date_desc);

  fprintf(f1,"                ");
  
  //fprintf(f1,"               TO : %s\n", nd_to_process_date_desc);
  fprintf(f1,"               %2.2s : %s\n", local_legend[6],nd_to_process_date_desc);

  fprintf(f1,"\n");
  fprintf(f1,"                ");
  
  //fprintf(f1,"PATIENT           : %s\n", nd_patient_id_desc);
  fprintf(f1,"%7.7s           : %s\n", local_legend[7],nd_patient_id_desc);

  fprintf(f1,"\n");
  fprintf(f1,"                ");
  
  //fprintf(f1,"DEPARTMENT        : %s  %s\n", nd_dept_desc,d_department_desc.arr);
  fprintf(f1,"%10.10s        : %s  %s\n", local_legend[8],nd_dept_desc,d_department_desc.arr);

  fprintf(f1,"\n");
  fprintf(f1,"                ");
  
  //fprintf(f1,"SOURCE       FROM : %s\n", nd_fr_ref_source_desc);
  fprintf(f1,"%6.6s       %4.4s : %s\n", local_legend[9],local_legend[5],nd_fr_ref_source_desc);

  fprintf(f1,"                ");
  
  //fprintf(f1,"               TO : %s\n", nd_to_ref_source_desc);
  fprintf(f1,"               %2.2s : %s\n", local_legend[6],nd_to_ref_source_desc);

  fprintf(f1,"\n");
  fprintf(f1,"                ");
  
  //fprintf(f1,"CATEGORY          : %s\n", nd_category_code_desc);
  fprintf(f1,"%8.8s          : %s\n", local_legend[10],nd_category_code_desc);

  fprintf(f1,"\n");
  fprintf(f1,"                ");
  
  //fprintf(f1,"ASSIGN TO         : %s\n", nd_assign_to_desc);
  fprintf(f1,"%6.6s %2.2s         : %s\n", local_legend[11],local_legend[6],nd_assign_to_desc);

  fprintf(f1,"\n");
}

/* to print page headers the header details */ 
void print_page_header()
{
 register int i;
 int spc_len;

 fprintf(f1,"%c&l1O",ESC);
 fprintf(f1,"%c&k4S",ESC);
 /*
 fprintf(f1,"MDL : RL    ");
 fprintf(f1,"                                        ");  
 fprintf(f1,"%-30.30s", d_acc_entity_name.arr);
 fprintf(f1,"               ");  
 */

  fprintf(f1,"MDL : RL");
  spc_len = (88 - (strlen(d_acc_entity_name.arr)))/2;
  for(i=1;i<=spc_len;i++)
  fprintf(f1," ");
  fprintf(f1,"%-60.60s", d_acc_entity_name.arr);
  for(i=1;i<=(spc_len-20);i++)
  fprintf(f1," ");
  
  //fprintf(f1,"%s", d_sysdate.arr);
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
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET\
_CURRENT_DATE ( :language_id ) ; :d_sysdate1 := to_char ( t_date , 'DD/MM/YYYY\
 HH24:MI' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )873;
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
  fprintf(f1,"                                         ");  
  
  //fprintf(f1,"PATIENT SPECIMEN LOG");
  fprintf(f1,"%20.20s",local_legend[1]);

  fprintf(f1,"                              ");  
  
  //fprintf(f1,"Page : %4d", page_no);
  fprintf(f1,"%4.4s : %4d", local_legend[2],page_no);

  fprintf(f1,"\n");
  fprintf(f1,"REP : RLRSLPAT");
  fprintf(f1,"\n");
  line_no = 3;
}

/********************* ADDED 26.04.2003  **********************/

get_source_desc()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  nd_src_desc.arr[0] = '\0';
  nd_src_desc.len = 0;

//sprintf(string_var,"1=%s\n",d_src_type.arr);
//disp_message(ERR_MESG,string_var);


  switch(d_src_type.arr[0])
  {
    case 'W' :
              /* EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM IP_NURSING_UNIT_LANG_VW
                        WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
						AND NURSING_UNIT_CODE = :d_source_code; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 18;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from IP_NURSING_UNI\
T_LANG_VW where (FACILITY_ID=nvl(:b1,:b2) and NURSING_UNIT_CODE=:b3)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )896;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&nd_src_desc;
              sqlstm.sqhstl[0] = (unsigned int  )102;
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
              sqlstm.sqhstv[3] = (         void  *)&d_source_code;
              sqlstm.sqhstl[3] = (unsigned int  )9;
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


              break;
    case 'O' :
              /* EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM OP_CLINIC_lang_vw
                        WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
						AND CLINIC_CODE = :d_source_code
						AND language_id = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 18;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from OP_CLINIC_lang\
_vw where ((FACILITY_ID=nvl(:b1,:b2) and CLINIC_CODE=:b3) and language_id=:b4)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )927;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&nd_src_desc;
              sqlstm.sqhstl[0] = (unsigned int  )102;
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
              sqlstm.sqhstv[3] = (         void  *)&d_source_code;
              sqlstm.sqhstl[3] = (unsigned int  )9;
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
                        WHERE REFERRAL_CODE = :d_source_code
						AND language_id = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 18;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from RL_REFERRAL_la\
ng_vw where (REFERRAL_CODE=:b1 and language_id=:b2)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )962;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&nd_src_desc;
              sqlstm.sqhstl[0] = (unsigned int  )102;
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


              break;
    case 'E' :
              /* EXEC SQL SELECT SHORT_DESC INTO :nd_src_desc
                         FROM RL_REFERRAL_lang_vw
                        WHERE REFERRAL_CODE = :d_source_code
						AND language_id = :language_id; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 18;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = "select SHORT_DESC into :b0  from RL_REFERRAL_la\
ng_vw where (REFERRAL_CODE=:b1 and language_id=:b2)";
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )989;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&nd_src_desc;
              sqlstm.sqhstl[0] = (unsigned int  )102;
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


              break;

  }   
  
  nd_src_desc.arr[nd_src_desc.len] = '\0';

//sprintf(string_var,"2=%s\n",nd_src_desc.arr);
//disp_message(ERR_MESG,string_var);


  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1016;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_source_desc() occured....\n");
   proc_exit();
}

/* print the heading */
void print_col_heading()
{

 fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"----------------------------------------------------------------");
 fprintf(f1,"\n");

 /* line 1 */

//fprintf(f1,"SPECIMEN NO       PATIENT'S NAME                 PATIENT ID           AGE          SEX SRC  DESCRIPTION     LOCATION    DOCTOR\n");
fprintf(f1,"%11.11s       %12.12s                 %10.10s           %3.3s          %7.7s  %11.11s     %8.8s    %6.6s\n",
            local_legend[15],local_legend[16],local_legend[17],local_legend[18],local_legend[19],local_legend[20],local_legend[21],local_legend[22]);

 /* line 1 */
//fprintf(f1,"REGD. DATE TIME                                  SPECIMEN TYPE                              DEPARTMENT\n");
fprintf(f1,"%4.4s. %9.9s                                  %13.13s                              %10.10s\n",
            local_legend[23],local_legend[24],local_legend[25],local_legend[8]);

//fprintf(f1,"                  CATEGORY NUMBER                ASSIGN TO                         CLINICAL COMMENTS\n");
fprintf(f1,"                  %15.15s                %9.9s                         %17.17s\n",
                              local_legend[26],local_legend[27],local_legend[28]);

fprintf(f1,"--------------------------------------------------------------------");
fprintf(f1,"----------------------------------------------------------------");
fprintf(f1,"\n");
  line_no +=5; /*incr. by 5 as col. headings occupy 5 lines */ 
}

/*--------------------------------------------------------------------------*/
gen_file_name()
{
/*     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
     EXEC SQL SELECT DECODE(PRINT_FILE_NO,NULL,'0',TO_CHAR(PRINT_FILE_NO)),
		     LOWER(USER)
	      INTO   :nd_file_no,
		     :nd_user
	      FROM   RL_PARAM;

     if (OERROR)
         err_mesg("Fetch failed on table RL_PARAM",0,"");
      
     nd_file_no.arr[nd_file_no.len] = '\0';
     nd_user.arr[nd_user.len] = '\0';
     sprintf(nd_file_name.arr,"rlrsplst_%s.lis",nd_file_no.arr);*/

     /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_file_name.arr,"rlrsplst.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);
	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
       disp_message(ERR_MESG,string_var) ; 
	   proc_exit();
     }

}


/*--------------------------------------------------------------------------*/
/************ 01.07.2003
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
*************/
/*--------------------------------------------------------------------------*/

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
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1031;
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
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1050;
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


#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
        