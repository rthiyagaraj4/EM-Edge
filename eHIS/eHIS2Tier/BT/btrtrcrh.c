
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
           char  filnam[29];
};
static const struct sqlcxp sqlfpn =
{
    28,
    "d:\\pro-c-winproc\\btrtrcrh.pc"
};


static unsigned long sqlctx = 1518584283;


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
            void  *sqhstv[8];
   unsigned int   sqhstl[8];
            int   sqhsts[8];
            void  *sqindv[8];
            int   sqinds[8];
   unsigned int   sqharm[8];
   unsigned int   *sqharc[8];
   unsigned short  sqadto[8];
   unsigned short  sqtdso[8];
} sqlstm = {10,8};

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
"select TO_CHAR(A.specimen_no)  from BT_UNIT_REQUEST_HDR A where ((((A.PATIEN\
T_ID=:b0 and A.OPERATING_FACILITY_ID=:b1) and A.specimen_no in (select specime\
n_no  from BT_UNIT_REQUEST_DTL where ((OPERATING_FACILITY_ID=:b1 and patient_i\
d=:b0) and UPPER(nvl(UNIT_STATUS,'X'))='T'))) and A.added_date>=to_date(:b4,'d\
d/mm/yyyy')) and A.added_date<(to_date(:b5,'dd/mm/yyyy')+1)) order by A.specim\
en_no            ";

 static const char *sq0015 = 
"select A.specimen_no  from BT_UNIT_REQUEST_HDR A where ((((A.PATIENT_ID=:b0 \
and A.OPERATING_FACILITY_ID=:b1) and A.specimen_no in (select specimen_no  fro\
m BT_UNIT_REQUEST_DTL where ((patient_id=:b0 and UPPER(nvl(CROSSMATCHED_YN,'X'\
))='Y') and OPERATING_FACILITY_ID=:b1))) and A.spec_regd_date_time>to_date(:b4\
,'dd/mm/yyyy')) and A.spec_regd_date_time<(to_date(:b5,'dd/mm/yyyy')+1)) order\
 by A.specimen_no            ";

 static const char *sq0023 = 
"select B.unit_no ,B.product_code ,A.blood_group ,A.rhesus_code ,B.reaction_c\
ode  from BT_UNIT_REQUEST_HDR A ,BT_UNIT_REQUEST_DTL B where ((((((A.PATIENT_I\
D=B.PATIENT_ID and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.PATIENT_ID=:b0) and A.SP\
ECIMEN_NO=TO_NUMBER(:b1)) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID)\
 and A.OPERATING_FACILITY_ID=:b2) and UPPER(nvl(B.UNIT_STATUS,'X'))='T')      \
     ";

 static const char *sq0028 = 
"select B.unit_no ,B.product_code ,A.blood_group ,A.rhesus_code ,B.reaction_c\
ode  from BT_UNIT_REQUEST_HDR A ,BT_UNIT_REQUEST_DTL B where ((((((A.PATIENT_I\
D=B.PATIENT_ID and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.PATIENT_ID=:b0) and A.SP\
ECIMEN_NO=TO_NUMBER(:b1)) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID)\
 and A.OPERATING_FACILITY_ID=:b2) and UPPER(nvl(CROSSMATCHED_YN,'X'))='Y')    \
       ";

 static const char *sq0041 = 
"select category_code ,category_requested  from BT_UNIT_REQUEST_CATEGORY A wh\
ere (A.specimen_no=TO_NUMBER(:b0) and A.OPERATING_FACILITY_ID=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,189,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,206,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,213,0,0,0,0,0,1,0,
66,0,0,4,240,0,4,248,0,0,6,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,
0,0,
105,0,0,5,0,0,32,277,0,0,0,0,0,1,0,
120,0,0,6,0,0,32,349,0,0,0,0,0,1,0,
135,0,0,7,112,0,4,570,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
158,0,0,8,112,0,4,578,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
181,0,0,9,95,0,4,598,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
208,0,0,10,354,0,4,604,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
251,0,0,11,358,0,4,617,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
294,0,0,12,0,0,32,646,0,0,0,0,0,1,0,
309,0,0,14,0,0,32,698,0,0,0,0,0,1,0,
324,0,0,16,0,0,32,733,0,0,0,0,0,1,0,
339,0,0,13,405,0,9,743,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
378,0,0,17,0,0,32,753,0,0,0,0,0,1,0,
393,0,0,15,417,0,9,766,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
432,0,0,18,0,0,32,774,0,0,0,0,0,1,0,
447,0,0,13,0,0,13,788,0,0,1,0,0,1,0,2,9,0,0,
466,0,0,19,0,0,32,813,0,0,0,0,0,1,0,
481,0,0,15,0,0,13,835,0,0,1,0,0,1,0,2,9,0,0,
500,0,0,20,0,0,32,858,0,0,0,0,0,1,0,
515,0,0,13,0,0,15,875,0,0,0,0,0,1,0,
530,0,0,21,0,0,32,881,0,0,0,0,0,1,0,
545,0,0,15,0,0,15,894,0,0,0,0,0,1,0,
560,0,0,22,0,0,32,900,0,0,0,0,0,1,0,
575,0,0,24,0,0,32,939,0,0,0,0,0,1,0,
590,0,0,23,393,0,9,948,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
617,0,0,25,0,0,32,952,0,0,0,0,0,1,0,
632,0,0,23,0,0,13,974,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
667,0,0,26,0,0,32,1004,0,0,0,0,0,1,0,
682,0,0,23,0,0,15,1018,0,0,0,0,0,1,0,
697,0,0,27,0,0,32,1024,0,0,0,0,0,1,0,
712,0,0,29,0,0,32,1064,0,0,0,0,0,1,0,
727,0,0,28,395,0,9,1073,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
754,0,0,30,0,0,32,1077,0,0,0,0,0,1,0,
769,0,0,28,0,0,13,1099,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
804,0,0,31,0,0,32,1132,0,0,0,0,0,1,0,
819,0,0,28,0,0,15,1146,0,0,0,0,0,1,0,
834,0,0,32,0,0,32,1152,0,0,0,0,0,1,0,
849,0,0,33,71,0,4,1167,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
872,0,0,34,0,0,32,1188,0,0,0,0,0,1,0,
887,0,0,35,164,0,4,1208,0,0,5,3,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
922,0,0,36,0,0,32,1232,0,0,0,0,0,1,0,
937,0,0,37,78,0,4,1254,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
960,0,0,38,0,0,32,1275,0,0,0,0,0,1,0,
975,0,0,39,247,0,4,1330,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,
1022,0,0,40,0,0,32,1387,0,0,0,0,0,1,0,
1037,0,0,42,0,0,32,1481,0,0,0,0,0,1,0,
1052,0,0,41,153,0,9,1491,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1075,0,0,43,0,0,32,1496,0,0,0,0,0,1,0,
1090,0,0,41,0,0,13,1510,0,0,2,0,0,1,0,2,9,0,0,2,3,0,0,
1113,0,0,44,0,0,32,1529,0,0,0,0,0,1,0,
1128,0,0,41,0,0,15,1540,0,0,0,0,0,1,0,
1143,0,0,45,0,0,32,1546,0,0,0,0,0,1,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File : btrtrcrh.pc

*  Ver 1.10.01
   
*  Purpose : To generate a report for Crossmatch/Transfusion History

*  Input Parameters : 
              Command line inputs
	
              1. Usr_id/Password
              2. Session id
              3. Program Date    
              4. Patient_id
              5. From_date
              6. To_date  

*  Table Accessed : BT_UNIT_REQUEST_HDR
                    BT_UNIT_REQUEST_DTL
					BT_REACTION_CODE_MAST
					BT_BLOOD_UNITS_MAST
					BT_PRODUCT_MAST
					BT_UNIT_REQUEST_CATEGORY
					BT_PATIENT_BLGRP_RH_ANT

*  Output File : btrtrcrh.lis
 ****************************************************************************/  

#include <stdio.h>
#include <string.h>

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"


/* EXEC SQL BEGIN DECLARE SECTION; */ 

/* INPUT PARAMETERS TO MAIN */
	
		

        /* VARCHAR uid_pwd     [91],
			nd_user_id          [21],
			nd_session_id       [16],
			nd_pgm_date	        [20],
			
 			nd_from_date        [31],
			nd_to_date			[31],
			nd_user	            [15],
			nd_file_no          [15],
			nd_file_name		[150]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[21]; } nd_user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_from_date;

struct { unsigned short len; unsigned char arr[31]; } nd_to_date;

struct { unsigned short len; unsigned char arr[15]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;


/****************************/

/* Fields from table SY_ACC_ENTITY*/
	/* varchar 	d_acc_entity_name        [41],
			d_user                   [21],
			d_sysdate                [30],
            d_title                  [50],
			entity_name				 [81],
			sys_date                 [81],
			l_title                  [81]; */ 
struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[30]; } d_sysdate;

struct { unsigned short len; unsigned char arr[50]; } d_title;

struct { unsigned short len; unsigned char arr[81]; } entity_name;

struct { unsigned short len; unsigned char arr[81]; } sys_date;

struct { unsigned short len; unsigned char arr[81]; } l_title;


	

/* Fields from MP_PATIENT_MAST Table   */
   /* varchar     nd_patient_name[81]; */ 
struct { unsigned short len; unsigned char arr[81]; } nd_patient_name;



/*Fields from BT_UNIT_REQUEST_HDR Table */
	/* varchar		nd_specimen_date_time[18],
				nd_patient_id		[32],
				nd_episode_type		[2],
				nd_antibody_code[5],
				nd_anti_code2[5],
				nd_anti_code3[5],
				nd_anti_code4[5],
				nd_operating_facility_id	[3],
				nd_anti_code5[5],
				antibodies[25]; */ 
struct { unsigned short len; unsigned char arr[18]; } nd_specimen_date_time;

struct { unsigned short len; unsigned char arr[32]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[5]; } nd_antibody_code;

struct { unsigned short len; unsigned char arr[5]; } nd_anti_code2;

struct { unsigned short len; unsigned char arr[5]; } nd_anti_code3;

struct { unsigned short len; unsigned char arr[5]; } nd_anti_code4;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[5]; } nd_anti_code5;

struct { unsigned short len; unsigned char arr[25]; } antibodies;

				


	int		nd_red_cells_requested,
			nd_platellets_requested,
			nd_ffp_requested,
			nd_others_requested;

/*Fields from BT_PATIENT_BLGRP_RH_ANT Table */
	/* varchar		nd_blood_group[5],
				nd_rhesus_code[6]; */ 
struct { unsigned short len; unsigned char arr[5]; } nd_blood_group;

struct { unsigned short len; unsigned char arr[6]; } nd_rhesus_code;



/* Fields from BT_UNIT_REQUEST_DTL      */
	/* varchar     d_unit_no[21],
		    d_product_code[11],
		    d_blood_group[5],
		    d_rhesus_code[6],
            d_unit_status[2],
		    d_crossmatched_yn[2],
            d_react_code[5],
			d_specimen_no [21]; */ 
struct { unsigned short len; unsigned char arr[21]; } d_unit_no;

struct { unsigned short len; unsigned char arr[11]; } d_product_code;

struct { unsigned short len; unsigned char arr[5]; } d_blood_group;

struct { unsigned short len; unsigned char arr[6]; } d_rhesus_code;

struct { unsigned short len; unsigned char arr[2]; } d_unit_status;

struct { unsigned short len; unsigned char arr[2]; } d_crossmatched_yn;

struct { unsigned short len; unsigned char arr[5]; } d_react_code;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;


        int d_trans_count,
		    d_cross_count;

/* Fields from BT_PRODUCT_MAST     */ 
       /* varchar      d_short_desc[17]; */ 
struct { unsigned short len; unsigned char arr[17]; } d_short_desc;


/* Fields from BT_BLOOD_UNITS_MAST     */ 
       int          d_volume;
       /* varchar      d_volume_units[11]; */ 
struct { unsigned short len; unsigned char arr[11]; } d_volume_units;


/* Fields from BT_REACTION_CODE_MAST     */ 
       /* varchar      d_short_description[17]; */ 
struct { unsigned short len; unsigned char arr[17]; } d_short_description;



/* Fields from table RL_SECTION_CODE */
	 /* varchar      d_printer_name    [16],
		      nd_fm_section_code[1] ,
		      nd_section_desc   [40]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_printer_name;

struct { unsigned short len; unsigned char arr[1]; } nd_fm_section_code;

struct { unsigned short len; unsigned char arr[40]; } nd_section_desc;


/* Fields from table BT_UNIT_REQUEST_CATEGORY */
	 /* varchar  d_category_code    [5]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_category_code;

	 int      d_category_requested;
			  

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BT/btrtrcrh.c-arc   1.0   24 Apr 2007 15:40:54   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BT/btrtrcrh.c-arc   1.0   24 Apr 2007 15:40:54   vcm_th  $ sqlda.h 
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
char temp_string[500];
int i =  0;
int c_ount = 0 ;
int c_ount1 = 0 ;
int line_no = 0;
int page_no = 0 ;

FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];


{
  	void gen_file_name() ;
	void get_header_dtls() ;
	void get_dept_printer() ;
	void do_report() ;
	char command_line[200] ;

   if(argc != 9) 
   {
     disp_message(ORA_MESG,"Usage btrtrcrh uid/passwd patient_id from_date to_date\n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr); 

   strcpy(nd_episode_type.arr, argv[5]);
   nd_episode_type.len = strlen(nd_episode_type.arr); 

   strcpy(nd_patient_id.arr, argv[6]);
   nd_patient_id.len = strlen(nd_patient_id.arr); 

   strcpy(nd_from_date.arr, argv[7]);
   nd_from_date.len = strlen(nd_from_date.arr); 

   strcpy(nd_to_date.arr, argv[8]);
   nd_to_date.len = strlen(nd_to_date.arr); 
 	
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

  

	if(OERROR)
		disp_message(ORA_MESG,"Failed to connect using : \n");

	#ifdef DEBUG
		printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
	#endif  

		set_meduser_role();

	   	gen_file_name();
        get_header_dtls() ;
        do_report() ;


   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL COMMIT WORK RELEASE; */ 

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



	fclose(f1) ;
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
   sqlstm.offset = (unsigned int  )51;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error occurred at main_function_cursor()\n");
   proc_exit();
}   


/*************** GENERATE FILE NAME ***************/
void gen_file_name()
{
  	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
         nd_file_name.len = strlen(nd_file_name.arr); 
         strcat(nd_file_name.arr,"btrtrcrh.lis");
	 nd_file_name.len = strlen(nd_file_name.arr);

	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
         {
	   sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);       
	   disp_message(ERR_MESG,string_var);
           proc_exit();
         }
 
}

/************ GET_HEADER_DETAILS****************/
void get_header_dtls()
{
         d_acc_entity_name.arr[0]   = '\0';
	 d_acc_entity_name.len	    = 0;
	 d_user.arr[0]		    = '\0';
	 d_user.len                 = 0;
	 d_sysdate.arr[0]	    = '\0';
	 d_sysdate.len              = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(LPAD(ACC_ENTITY_NAME,
		   TRUNC(15 + 0.5*LENGTH(ACC_ENTITY_NAME))),1,30),
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI'),
		   'Crossmatch/Transfusion History For ' || :nd_patient_id
	     INTO :d_acc_entity_name,
		  :d_user,
		  :d_sysdate,
		  :d_title
          FROM SY_ACC_ENTITY
		  WHERE ACC_ENTITY_ID=:nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(LPAD(ACC_ENTITY_NAME,TRUNC((15+(0.5* LENGTH(\
ACC_ENTITY_NAME))))),1,30) ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') ,('Cro\
ssmatch/Transfusion History For '||:b0) into :b1,:b2,:b3,:b4  from SY_ACC_ENTI\
TY where ACC_ENTITY_ID=:b5";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )34;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_acc_entity_name;
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_user;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_sysdate;
   sqlstm.sqhstl[3] = (unsigned int  )32;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_title;
   sqlstm.sqhstl[4] = (unsigned int  )52;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[5] = (unsigned int  )5;
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
  d_title.arr[d_title.len]                     = '\0';



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
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )105;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}



/************ LAYOUT/LOGIC FOR THE PROC REPORT ***************/
void do_report()
{

        void print_hdr();
		void get_patient_dtls();
        void print_patient_dtls();
        void do_rep(char t_c);

/*************** date  ******************/
  c_ount = strlen(d_sysdate.arr) ;
  c_ount1 = (80 - c_ount)/2 ;

  for(i;i<(c_ount1-6);i++)
		strcat(sys_date.arr," ") ;
  strcat(sys_date.arr,"Date: ");
  strcat(sys_date.arr,d_sysdate.arr) ;
  sys_date.len=strlen(sys_date.arr);

/*************** entity name  ***********/
  c_ount = strlen(d_acc_entity_name.arr) ;
  c_ount1 = (80 - c_ount)/2 ;
  
  for(i;i<c_ount1;i++)
		strcat(entity_name.arr," ") ;
  
  strcat(entity_name.arr,d_acc_entity_name.arr) ;
  entity_name.len=strlen(entity_name.arr);

/*************** title  ******************/
  
  c_ount = strlen(d_title.arr) ;
  c_ount1 = (80 - c_ount)/2 ;
  
  for(i;i<c_ount1;i++)
		strcat(l_title.arr," ") ;
  
  strcat(l_title.arr,d_title.arr) ;
  l_title.len=strlen(l_title.arr);

/******************************************************/

  line_no = 0 ;
  print_hdr();

  get_patient_dtls(); 


  print_patient_dtls();

  fprintf(f1,"\nTransfusion History:-\n");
  fprintf(f1,"----------------------\n");
  line_no = line_no + 2;

  do_rep('T');

  fprintf(f1,"\nCrossmatch History:-\n");
  fprintf(f1,"----------------------\n");
  line_no = line_no + 2;

  do_rep('C');
  
  return ;
 err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )120;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at report() occured....\n");
   proc_exit();
}   


void do_rep(char t_c)
{

	void print_hdr();
	
	void dclr_master_trans_cur();
	void open_master_trans_cur();
	int  fetch_master_trans_cur();
	void close_master_trans_cur();

	void dclr_master_cross_cur();
	void open_master_cross_cur();
	int  fetch_master_cross_cur();
	void close_master_cross_cur();

	void dclr_detail_trans_cur();
	void open_detail_trans_cur();
	int  fetch_detail_trans_cur();
	void close_detail_trans_cur();
	
	void dclr_detail_cross_cur();
	void open_detail_cross_cur();
	int  fetch_detail_cross_cur();
	void close_detail_cross_cur();

        void get_prod_desc();
        void get_volume();
        void get_react_desc();

	void get_specimen_dtls();
        void print_specimen_dtls();
        void print_unit_hdr(char t_c);
	void print_detail_record(char t_c);

/**********************************/

  int still_master_exist=0;
  int still_detail_exist=0;


if (t_c == 'T')
{

  dclr_master_trans_cur();

  open_master_trans_cur();

  still_master_exist=fetch_master_trans_cur();

  while (still_master_exist==1)
  {
    if (line_no>=MAX_LINES) 
      {
        line_no=0;
	//fprintf(f1,"");
	fprintf(f1,"\f");
  	page_no++;
	print_hdr();
      }


  get_specimen_dtls();
  print_specimen_dtls();

  dclr_detail_trans_cur();
  open_detail_trans_cur();

    if (line_no>=MAX_LINES)
      {
        line_no=0;
	//fprintf(f1,"");
	fprintf(f1,"\f");
  	page_no++;
	print_hdr();
      }

  print_unit_hdr(t_c);

  still_detail_exist=fetch_detail_trans_cur();

  while (still_detail_exist == 1)
  {
   get_prod_desc();
   get_volume();
   get_react_desc();

        if (line_no >= MAX_LINES) 
	      {
        	line_no = 0;
		//fprintf(f1,"");
		fprintf(f1,"\f");
	  	page_no++;
		print_hdr();
	      }

  print_detail_record(t_c);

  still_detail_exist=fetch_detail_trans_cur();
   if (still_detail_exist != 1) 
   {
      break;
   }   
  } 
 	  
 fprintf(f1,"------------------------------------");
 fprintf(f1,"------------------------------------");
 fprintf(f1,"\n");
 line_no = line_no + 1;

 close_detail_trans_cur();
 still_master_exist=fetch_master_trans_cur();
   if (still_master_exist != 1) 
   {
   
      break;
   }   

}
close_master_trans_cur();
}
else
{

  dclr_master_cross_cur();

  open_master_cross_cur();

  still_master_exist=fetch_master_cross_cur();

  while (still_master_exist==1)
  {
    if (line_no>=MAX_LINES) 
      {
        line_no=0;
	//fprintf(f1,"");
	fprintf(f1,"\f");
  	page_no++;
	print_hdr();
      }

  get_specimen_dtls();

  print_specimen_dtls();

  dclr_detail_cross_cur();
  open_detail_cross_cur();

    if (line_no>=MAX_LINES) 
      {
        line_no=0;
	//fprintf(f1,"");
	fprintf(f1,"\f");
  	page_no++;
	print_hdr();
      }

  print_unit_hdr(t_c);

  still_detail_exist=fetch_detail_cross_cur();

  while (still_detail_exist == 1)
  {
   get_prod_desc();
   get_volume();
   get_react_desc();

    if (line_no>=MAX_LINES) 
      {
        line_no=0;
	//fprintf(f1,"");
	fprintf(f1,"\f");
  	page_no++;
	print_hdr();
      }

  print_detail_record(t_c);
  still_detail_exist=fetch_detail_cross_cur();
   if (still_detail_exist != 1) 
   {
      break;
   }   
  } 
 	  
 fprintf(f1,"------------------------------------");
 fprintf(f1,"------------------------------------");
 fprintf(f1,"\n");
 line_no = line_no + 1;
 close_detail_cross_cur();
 still_master_exist=fetch_master_cross_cur();
   if (still_master_exist != 1) 
   {
   
      break;
   }   

}
close_master_cross_cur();
}
}


/********* GET PATIENT DETAILS **********/
void get_patient_dtls()
  {

    nd_patient_name.arr[0] = '\0';
    nd_patient_name.len = 0 ;
    nd_blood_group.arr[0] = '\0';
    nd_blood_group.len = 0 ;
    nd_rhesus_code.arr[0] = '\0';
    nd_rhesus_code.len = 0 ;
	
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit;*/


    /* EXEC SQL SELECT first_name || ' ' || second_name
                        || ' ' || third_name 
               INTO :nd_patient_name
	       FROM MP_PATIENT_MAST
	      WHERE patient_id = :nd_patient_id ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ((((first_name||' ')||second_name)||' ')||third_na\
me) into :b0  from MP_PATIENT_MAST where patient_id=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )135;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_patient_name;
    sqlstm.sqhstl[0] = (unsigned int  )83;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )34;
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



	if (NODATAFOUND)
	{
		/* EXEC SQL SELECT first_name || ' ' || second_name
								|| ' ' || third_name 
					   INTO :nd_patient_name
				   FROM RL_PATIENT_MAST
				  WHERE patient_id = :nd_patient_id ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select ((((first_name||' ')||second_name)||' ')||third_name\
) into :b0  from RL_PATIENT_MAST where patient_id=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )158;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[0] = (unsigned int  )83;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )34;
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



		if (NODATAFOUND)
			nd_patient_name.arr[0] = '\0';
			nd_patient_name.len = 0 ;
	}


/**************
    EXEC SQL SELECT DISTINCT  blood_group,rhesus_code
              INTO :nd_blood_group,:nd_rhesus_code
	      FROM BT_UNIT_REQUEST_HDR
	     WHERE PATIENT_ID = :nd_patient_id
		 AND   OPERATING_FACILITY_ID=:nd_operating_facility_id;
*********/

    /* EXEC SQL SELECT blood_group,rhesus_code
              INTO :nd_blood_group,:nd_rhesus_code
	      FROM BT_PATIENT_BLGRP_RH_ANT
	     WHERE PATIENT_ID = :nd_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select blood_group ,rhesus_code into :b0,:b1  from BT_PAT\
IENT_BLGRP_RH_ANT where PATIENT_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )181;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_blood_group;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_rhesus_code;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )34;
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




    /* EXEC SQL SELECT COUNT(*) 
	       INTO :d_trans_count 
               FROM BT_UNIT_REQUEST_DTL
              WHERE specimen_no in (SELECT specimen_no 
				                     FROM BT_UNIT_REQUEST_HDR
									 WHERE OPERATING_FACILITY_ID=:nd_operating_facility_id
									 AND   patient_id=:nd_patient_id
									 AND added_date >= to_date(:nd_from_date,'dd/mm/yyyy') 
									 AND added_date < (to_date(:nd_to_date,'dd/mm/yyyy') + 1))						 
				AND OPERATING_FACILITY_ID=:nd_operating_facility_id
				AND PATIENT_ID=:nd_patient_id
                AND UPPER(nvl(UNIT_STATUS,'X'))='T'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from BT_UNIT_REQUEST_DTL where\
 (((specimen_no in (select specimen_no  from BT_UNIT_REQUEST_HDR where (((OPER\
ATING_FACILITY_ID=:b1 and patient_id=:b2) and added_date>=to_date(:b3,'dd/mm/y\
yyy')) and added_date<(to_date(:b4,'dd/mm/yyyy')+1))) and OPERATING_FACILITY_I\
D=:b1) and PATIENT_ID=:b2) and UPPER(nvl(UNIT_STATUS,'X'))='T')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )208;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_trans_count;
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
    sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )34;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[3] = (unsigned int  )33;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[4] = (unsigned int  )33;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[6] = (unsigned int  )34;
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


				
    /* EXEC SQL SELECT COUNT(*) 
               INTO :d_cross_count 
               FROM BT_UNIT_REQUEST_DTL
              WHERE specimen_no in (SELECT specimen_no 
				                      FROM BT_UNIT_REQUEST_HDR
									 WHERE OPERATING_FACILITY_ID=:nd_operating_facility_id
									 AND   patient_id=:nd_patient_id
									 AND added_date >= to_date(:nd_from_date,'dd/mm/yyyy') 
									 AND added_date < (to_date(:nd_to_date,'dd/mm/yyyy') + 1))
				AND OPERATING_FACILITY_ID=:nd_operating_facility_id
				AND PATIENT_ID=:nd_patient_id
                AND UPPER(nvl(CROSSMATCHED_YN,'X'))='Y'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from BT_UNIT_REQUEST_DTL where\
 (((specimen_no in (select specimen_no  from BT_UNIT_REQUEST_HDR where (((OPER\
ATING_FACILITY_ID=:b1 and patient_id=:b2) and added_date>=to_date(:b3,'dd/mm/y\
yyy')) and added_date<(to_date(:b4,'dd/mm/yyyy')+1))) and OPERATING_FACILITY_I\
D=:b1) and PATIENT_ID=:b2) and UPPER(nvl(CROSSMATCHED_YN,'X'))='Y')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )251;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cross_count;
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
    sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )34;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[3] = (unsigned int  )33;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[4] = (unsigned int  )33;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[6] = (unsigned int  )34;
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



  nd_patient_name.arr[nd_patient_name.len]    = '\0';
  nd_blood_group.arr[nd_blood_group.len]      = '\0';
  nd_rhesus_code.arr[nd_rhesus_code.len]      = '\0';

#ifdef DEBUG
    printf("leaving get_patient_name()\n");
	printf(" nd_patient_name= %s\n", nd_patient_name.arr);
    printf(" nd_blood_group=%s\n", nd_blood_group.arr) ;
    printf(" nd_rhesus_code=%s\n", nd_rhesus_code.arr) ;
#endif

  return;

   err_exit:

   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )294;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   disp_message(ORA_MESG,"Oracle error at get_patient_name() occured....\n");
   proc_exit();	


}


void print_patient_dtls()
{
 fprintf(f1,"Patient ID %s\n",nd_patient_id.arr);
 fprintf(f1,"Patient Name %-10s\n",nd_patient_name.arr);
 fprintf(f1,"Blood Group %-15s\n",nd_blood_group.arr);
 fprintf(f1,"Rhesus factor %-5s\n",nd_rhesus_code.arr);
 fprintf(f1,"No. Of Previous Transfusions:%d\n",d_trans_count);
 fprintf(f1,"No. Of Previous Crossmatches:%d\n",d_cross_count);
 fprintf(f1,"____________________________________");
 fprintf(f1,"____________________________________");
 fprintf(f1,"\n");
 line_no = line_no + 7;
}


/********* DECLARE MASTER_TRANS_CURSOR **********/
  void dclr_master_trans_cur()
  {

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  
  /* EXEC SQL DECLARE MASTER_TRANS_CURSOR CURSOR FOR
          SELECT TO_CHAR(A.specimen_no) 
		  FROM BT_UNIT_REQUEST_HDR A
          WHERE A.PATIENT_ID = :nd_patient_id
				 AND A.OPERATING_FACILITY_ID=:nd_operating_facility_id
				 AND A.specimen_no IN(SELECT specimen_no FROM BT_UNIT_REQUEST_DTL
                             WHERE OPERATING_FACILITY_ID=:nd_operating_facility_id
							 AND    patient_id = :nd_patient_id
                             AND UPPER(nvl(UNIT_STATUS,'X')) = 'T')
				 AND A.added_date >= to_date(:nd_from_date,'dd/mm/yyyy') 
				 AND A.added_date < (to_date(:nd_to_date,'dd/mm/yyyy') + 1)				 
				 
	      ORDER BY A.specimen_no; */ 


#ifdef DEBUG
    printf("leaving dclr_master_cur()\n");
    fflush(stdout);
#endif

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )309;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_MASTER__trans_cur() occured....\n");
   proc_exit();	

 }

/********* DECLARE MASTER_CROSS_CURSOR **********/
void dclr_master_cross_cur()
  {

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  
  /* EXEC SQL DECLARE MASTER_CROSS_CURSOR CURSOR FOR 
          SELECT A.specimen_no 
		  FROM	 BT_UNIT_REQUEST_HDR A
          WHERE	 A.PATIENT_ID = :nd_patient_id
			 AND A.OPERATING_FACILITY_ID=:nd_operating_facility_id
             AND A.specimen_no IN 
						(SELECT specimen_no 
						 FROM BT_UNIT_REQUEST_DTL
                         WHERE patient_id = :nd_patient_id
                             AND UPPER(nvl(CROSSMATCHED_YN,'X')) = 'Y'
							 AND OPERATING_FACILITY_ID=:nd_operating_facility_id
						 )
			 AND A.spec_regd_date_time > to_date(:nd_from_date,'dd/mm/yyyy') 
			 AND A.spec_regd_date_time < (to_date(:nd_to_date,'dd/mm/yyyy') + 1)			 
             ORDER BY A.specimen_no; */ 


#ifdef DEBUG
    printf("leaving dclr_master_cur()\n");
    fflush(stdout);
#endif
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )324;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_MASTER__trans_cur() occured....\n");
   proc_exit();	
}

/********* OPEN MASTER TRANS CURSOR **********/
 void open_master_trans_cur()
  {
   /*  EXEC SQL WHENEVER SQLERROR GOTO err_exit;*/

     /* EXEC SQL OPEN MASTER_TRANS_CURSOR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )339;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[0] = (unsigned int  )34;
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
     sqlstm.sqhstv[3] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[3] = (unsigned int  )34;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_from_date;
     sqlstm.sqhstl[4] = (unsigned int  )33;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
     sqlstm.sqhstl[5] = (unsigned int  )33;
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



		if(OERROR)
			disp_message(ORA_MESG,"Error in opening Master Trans Cursor \n");

     return;
	 	 
   err_exit:
   
   	 /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )378;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




     disp_message(ORA_MESG,"Oracle error while Opening master trans cursor occured...\n");
     proc_exit();
	 

  }

/********* OPEN MASTER CROSS CURSOR **********/
 void open_master_cross_cur()
  {
     /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

     /* EXEC SQL OPEN MASTER_CROSS_CURSOR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0015;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )393;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[0] = (unsigned int  )34;
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
     sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )34;
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
     sqlstm.sqhstv[4] = (         void  *)&nd_from_date;
     sqlstm.sqhstl[4] = (unsigned int  )33;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
     sqlstm.sqhstl[5] = (unsigned int  )33;
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



	 if(OERROR)
			disp_message(ORA_MESG,"Error in opening Master Cross Cursor \n");

     return;
   err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )432;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message(ORA_MESG,"Oracle error while Opening master cross cursor occured...\n");
     proc_exit();
  }

/********* FETCH MASTER TRANS CURSOR **********/
int fetch_master_trans_cur()
{

  d_specimen_no.arr[0]  = '\0';
  d_specimen_no.len		= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH MASTER_TRANS_CURSOR	
            INTO :d_specimen_no; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )447;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
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



  d_specimen_no.arr[d_specimen_no.len]	= '\0';

#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif



  if (NODATAFOUND)
{
    return 0;
}

#ifdef DEBUG
   printf("********* Details from BT_UNIT_REQUEST_HDR**************\n");
   printf(" d_specimen_no= %d\n", d_specimen_no);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )466;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (NODATAFOUND)
   {
     disp_message(ORA_MESG,"trans MASTER NO DATA FOUND....\n");
     return 0;
   }

   
    disp_message(ORA_MESG,"Oracle error at fetch_Master_trans_cursor() occured....\n");
    proc_exit();

}

/********* FETCH MASTER CROSS CURSOR **********/
int fetch_master_cross_cur()
{

  d_specimen_no.arr[0]  = '\0';
  d_specimen_no.len		= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH MASTER_CROSS_CURSOR	
            INTO :d_specimen_no; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )481;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
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



  d_specimen_no.arr[d_specimen_no.len]	= '\0';

#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
{
    return 0;
}

#ifdef DEBUG
   printf("********* Details from BT_UNIT_REQUEST_HDR**************\n");
   printf(" d_specimen_no= %d\n", d_specimen_no);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
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


   if (NODATAFOUND)
   {
     disp_message(ORA_MESG,"cross MASTER NO DATA FOUND....\n");
     return 0;
   }
    disp_message(ORA_MESG,"Oracle error at fetch_Master_cross_cursor() occured....\n");
    proc_exit();
}



/********** CLOSE MASTER TRANS CURSOR *********/
void close_master_trans_cur()
{
  
	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL CLOSE MASTER_TRANS_CURSOR ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
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



	 return ;
   
   err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
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


	 
     disp_message(ORA_MESG,"Oracle error while Closing trans master cursor occured...\n");
     proc_exit();

}


/********** CLOSE MASTER CROSS CURSOR *********/
void close_master_cross_cur()
{
  
	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL CLOSE MASTER_CROSS_CURSOR ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )545;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
  if (sqlca.sqlcode < 0) goto err_exit;
}



	 return ;
   
   err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )560;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message(ORA_MESG,"Oracle error while Closing trans master cursor occured...\n");
     proc_exit();
}

/********* DECLARE DETAIL_CURSOR **********/
  void dclr_detail_trans_cur()
  {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

 
 /*  EXEC SQL DECLARE DETAIL_TRANS_CURSOR CURSOR FOR 
    SELECT unit_no,product_code,blood_group,rhesus_code,react_code FROM RL_ALLOC_UNIT_TRN 
    WHERE PATIENT_ID = :nd_patient_id 
    AND SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
    AND UPPER(nvl(UNIT_STATUS,'X')) = 'T';
	*/


	/* EXEC SQL DECLARE DETAIL_TRANS_CURSOR CURSOR FOR 
    SELECT B.unit_no,B.product_code,A.blood_group,A.rhesus_code,B.reaction_code 
	FROM BT_UNIT_REQUEST_HDR A , BT_UNIT_REQUEST_DTL B
    WHERE A.PATIENT_ID=B.PATIENT_ID
			AND A.SPECIMEN_NO=B.SPECIMEN_NO
			AND A.PATIENT_ID = :nd_patient_id 
			AND A.SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
			AND A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID
			AND A.OPERATING_FACILITY_ID=:nd_operating_facility_id
			AND UPPER(nvl(B.UNIT_STATUS,'X')) = 'T'; */ 



#ifdef DEBUG
    printf("leaving dclr_detail_cur()\n");
    fflush(stdout);
#endif

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )575;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_detail_trans_cur() occured....\n");
   proc_exit();	
  }

/********* OPEN DETAIL CURSOR **********/
   void open_detail_trans_cur()
   {
	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

     /* EXEC SQL OPEN DETAIL_TRANS_CURSOR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0023;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )590;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[0] = (unsigned int  )34;
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
     sqlstm.sqphsv = sqlstm.sqhstv;
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
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )617;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message(ORA_MESG,"Oracle error while Opening trans detail cursor occured...\n");
     proc_exit();
   }


/********* FETCH DETAIL CURSOR **********/
int fetch_detail_trans_cur()
{

  d_unit_no.arr[0]                                   = '\0';
  d_unit_no.len                                      = 0;
  d_product_code.arr[0]                              = '\0';
  d_product_code.len                                 = 0;
  d_blood_group.arr[0]				     = '\0';
  d_blood_group.len            			     = 0;
  d_rhesus_code.arr[0]                               = '\0';
  d_rhesus_code.len                                  = 0;
  d_react_code.arr[0]                                = '\0';
  d_react_code.len                                   = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH detail_trans_cursor	
	    INTO :d_unit_no,:d_product_code,
		 :d_blood_group,:d_rhesus_code,:d_react_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )632;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_unit_no;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_product_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_blood_group;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_rhesus_code;
  sqlstm.sqhstl[3] = (unsigned int  )8;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_react_code;
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



#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
    return 0;

  d_unit_no.arr[d_unit_no.len]				    	= '\0';
  d_product_code.arr[d_product_code.len]			= '\0';
  d_blood_group.arr[d_blood_group.len]				= '\0';
  d_rhesus_code.arr[d_rhesus_code.len]                          = '\0';
  d_react_code.arr[d_react_code.len]                            = '\0';

  
#ifdef DEBUG
   printf("********* Details from BT_UNIT_REQUEST_HDR / DTL **************\n");
   printf(" d_unit_no= %s\n", d_unit_no.arr);
   printf(" d_product_code= %s\n", d_product_code.arr);
   printf(" d_blood_group= %s\n", d_blood_group.arr);
   printf(" d_rhesus_code= %s\n", d_rhesus_code.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )667;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (NODATAFOUND)
     return 0;
   disp_message(ORA_MESG,"Oracle error at fetch_Detail_trans_cursor() occured....\n");
   proc_exit();
}



/********** CLOSE DETAIL CURSOR *********/
void close_detail_trans_cur()
{
  
	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL CLOSE DETAIL_TRANS_CURSOR ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )682;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
  if (sqlca.sqlcode < 0) goto err_exit;
}



	 return ;
   
   err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )697;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message(ORA_MESG,"Oracle error while Closing trans detail cursor occured...\n");
     proc_exit();
}

/********* DECLARE DETAIL_CURSOR **********/
  void dclr_detail_cross_cur()
  {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

 
 /*
   EXEC SQL DECLARE DETAIL_CROSS_CURSOR CURSOR FOR 
    SELECT unit_no,product_code,blood_group,rhesus_code,react_code FROM RL_ALLOC_UNIT_TRN 
    WHERE PATIENT_ID = :nd_patient_id 
    AND SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
    AND UPPER(nvl(CROSSMATCHED_YN,'X')) = 'Y';
*/

   /* EXEC SQL DECLARE DETAIL_CROSS_CURSOR CURSOR FOR 
    SELECT B.unit_no,B.product_code,A.blood_group,A.rhesus_code,B.reaction_code 
	FROM BT_UNIT_REQUEST_HDR A , BT_UNIT_REQUEST_DTL B
    WHERE A.PATIENT_ID=B.PATIENT_ID
			AND A.SPECIMEN_NO=B.SPECIMEN_NO
			AND A.PATIENT_ID = :nd_patient_id 
			AND A.SPECIMEN_NO = TO_NUMBER(:d_specimen_no)
			AND A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID
			AND A.OPERATING_FACILITY_ID=:nd_operating_facility_id
			AND UPPER(nvl(CROSSMATCHED_YN,'X')) = 'Y'; */ 




#ifdef DEBUG
    printf("leaving dclr_detail_cur()\n");
    fflush(stdout);
#endif

  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
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


   disp_message(ORA_MESG,"Oracle error at dclr_detail_cross_cur() occured....\n");
   proc_exit();	
  }

/********* OPEN DETAIL CROSS CURSOR **********/
   void open_detail_cross_cur()
   {
	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

     /* EXEC SQL OPEN DETAIL_CROSS_CURSOR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0028;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )727;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[0] = (unsigned int  )34;
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
     sqlstm.sqphsv = sqlstm.sqhstv;
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
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )754;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message(ORA_MESG,"Oracle error while Opening trans detail cursor occured...\n");
     proc_exit();
   }


/********* FETCH DETAIL CROSS CURSOR **********/
int fetch_detail_cross_cur()
{

  d_unit_no.arr[0]                                   = '\0';
  d_unit_no.len                                      = 0;
  d_product_code.arr[0]                              = '\0';
  d_product_code.len                                 = 0;
  d_blood_group.arr[0]				     = '\0';
  d_blood_group.len            			     = 0;
  d_rhesus_code.arr[0]                               = '\0';
  d_rhesus_code.len                                  = 0;
  d_react_code.arr[0]                                = '\0';
  d_react_code.len                                   = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH detail_cross_cursor	
	    INTO :d_unit_no,
			 :d_product_code,
			 :d_blood_group,
			 :d_rhesus_code,
			 :d_react_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )769;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_unit_no;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_product_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_blood_group;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_rhesus_code;
  sqlstm.sqhstl[3] = (unsigned int  )8;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_react_code;
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



#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
    return 0;

  d_unit_no.arr[d_unit_no.len]				    	= '\0';
  d_product_code.arr[d_product_code.len]			= '\0';
  d_blood_group.arr[d_blood_group.len]				= '\0';
  d_rhesus_code.arr[d_rhesus_code.len]                          = '\0';
  d_react_code.arr[d_react_code.len]                            = '\0';

  
#ifdef DEBUG
   printf("********* Details from BT_UNIT_REQUEST_DTL / HDR**************\n");
   printf(" d_unit_no= %s\n", d_unit_no.arr);
   printf(" d_product_code= %s\n", d_product_code.arr);
   printf(" d_blood_group= %s\n", d_blood_group.arr);
   printf(" d_rhesus_code= %s\n", d_rhesus_code.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )804;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (NODATAFOUND)
     return 0;
   disp_message(ORA_MESG,"Oracle error at fetch_Detail_cross_cursor() occured....\n");
   proc_exit();
}



/********** CLOSE DETAIL CURSOR *********/
void close_detail_cross_cur()
{
  
	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL CLOSE DETAIL_CROSS_CURSOR ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )819;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
  if (sqlca.sqlcode < 0) goto err_exit;
}



	 return ;
   
   err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
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


     disp_message(ORA_MESG,"Oracle error while Closing cross detail cursor occured...\n");
     proc_exit();
}



/********************************************************************/
void get_prod_desc()
{

  d_short_desc.arr[0]                                ='\0';
  d_short_desc.len                                   =0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT short_desc
	     INTO :d_short_desc 
	     FROM bt_product_mast
	    WHERE product_code=:d_product_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_desc into :b0  from bt_product_mast where prod\
uct_code=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )849;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_short_desc;
  sqlstm.sqhstl[0] = (unsigned int  )19;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_product_code;
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



#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
  {
   strcpy(d_short_desc.arr," ");      
   d_short_desc.arr[d_short_desc.len]			= '\0';
   return;
  }

  d_short_desc.arr[d_short_desc.len]			= '\0';
  return ;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
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



   if (NODATAFOUND)
   {
    strcpy(d_short_desc.arr," ");      
    d_short_desc.arr[d_short_desc.len]			= '\0';
    return;
   }
   disp_message(ORA_MESG,"Oracle error at fetch_Detail_cursor() occured....\n");
   proc_exit();
}


/********************************************************************/
void get_volume()
{
  d_volume_units.arr[0]                              ='\0';
  d_volume_units.len                                 =0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT nvl(current_volume,0),nvl(volume_units,'ml') 
	     INTO :d_volume,
			  :d_volume_units
	     FROM bt_blood_units_mast
	    WHERE product_code=:d_product_code
	      AND unit_no=:d_unit_no
		  AND OPERATING_FACILITY_ID=:nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select nvl(current_volume,0) ,nvl(volume_units,'ml') into :\
b0,:b1  from bt_blood_units_mast where ((product_code=:b2 and unit_no=:b3) and\
 OPERATING_FACILITY_ID=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )887;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_volume;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_volume_units;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_product_code;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_unit_no;
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
  sqlstm.sqphsv = sqlstm.sqhstv;
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
  {
   strcpy(d_volume_units.arr," ");      
   d_volume_units.arr[d_volume_units.len]			= '\0';
   return;
  }

  d_volume_units.arr[d_volume_units.len]			= '\0';
  return ;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )922;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (NODATAFOUND)
  {
   strcpy(d_volume_units.arr," ");      
   d_volume_units.arr[d_volume_units.len]			= '\0';
   return;
  }

   disp_message(ORA_MESG,"Oracle error at get_volume() occured....\n");
   proc_exit();
}


/********************************************************************/
void get_react_desc()
{
  d_short_description.arr[0]                         ='\0';
  d_short_description.len                            =0;


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT short_desc 
	     INTO :d_short_description 
	     FROM bt_reaction_code_mast
	    WHERE reaction_code=:d_react_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_desc into :b0  from bt_reaction_code_mast wher\
e reaction_code=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )937;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_short_description;
  sqlstm.sqhstl[0] = (unsigned int  )19;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_react_code;
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



#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
  {
   strcpy(d_short_description.arr," ");      
   d_short_description.arr[d_short_description.len]    	= '\0';
   return;
  }

  d_short_description.arr[d_short_description.len]    	= '\0';
  return ;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
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



   if (NODATAFOUND)
   {
    strcpy(d_short_description.arr," ");      
    d_short_description.arr[d_short_description.len]    	= '\0';
    return;
   }
   disp_message(ORA_MESG,"Oracle error at fetch_Detail_cursor() occured....\n");
   proc_exit();
}

/************ PREPARE NEW PAGE **************/
void prepare_new_page(f1)
FILE *f1;
{
   fprintf(f1,"");
   line_no = 0;
   page_no++ ;
}


void print_hdr()
{
 fprintf(f1,"\n");
 fprintf(f1,"%s\n",sys_date.arr);
 fprintf(f1,"%-9s\n",entity_name.arr);
 fprintf(f1,"%-6s\n",l_title.arr);
 fprintf(f1,"____________________________________");
 fprintf(f1,"____________________________________");
 fprintf(f1,"\n\n");
 line_no = line_no + 6 ;
}

/********* GET SPECIMEN DETAILS **********/
void get_specimen_dtls()
  {
    	
        nd_specimen_date_time.arr[0] = '\0';
        nd_specimen_date_time.len    =0;
        nd_antibody_code.arr[0]  = '\0';
        nd_antibody_code.len     = 0;
	nd_anti_code2.arr[0]     = '\0';
	nd_anti_code2.len        =  0;
	nd_anti_code3.arr[0]     = '\0';
	nd_anti_code3.len        =  0;
	nd_anti_code4.arr[0]     = '\0';
	nd_anti_code4.len        =  0;
	nd_anti_code5.arr[0]     = '\0';
	nd_anti_code5.len        =  0;
    antibodies.arr[0]		 = '\0';
    antibodies.len			 = 0;
	
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


    /* EXEC SQL SELECT TO_CHAR(added_date,'DD/MM/YYYY HH24:MI'),antibody_code1,
					antibody_code2,antibody_code3,antibody_code4,antibody_code5
               INTO :nd_specimen_date_time,:nd_antibody_code,
					:nd_anti_code2,:nd_anti_code3,:nd_anti_code4,:nd_anti_code5
	       FROM BT_UNIT_REQUEST_HDR
	      WHERE specimen_no= TO_NUMBER(:d_specimen_no)
		  AND   OPERATING_FACILITY_ID=:nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(added_date,'DD/MM/YYYY HH24:MI') ,antibody\
_code1 ,antibody_code2 ,antibody_code3 ,antibody_code4 ,antibody_code5 into :b\
0,:b1,:b2,:b3,:b4,:b5  from BT_UNIT_REQUEST_HDR where (specimen_no=TO_NUMBER(:\
b6) and OPERATING_FACILITY_ID=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )975;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_specimen_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )20;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_antibody_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_anti_code2;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_anti_code3;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_anti_code4;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_anti_code5;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[7] = (unsigned int  )5;
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




if (NODATAFOUND)
    return ;


if (nd_antibody_code.len>1)
{
strcpy(antibodies.arr,nd_antibody_code.arr);
}

if (nd_anti_code2.len>1)
{
strcat(antibodies.arr,",");
strcat(antibodies.arr,nd_anti_code2.arr);
}

if (nd_anti_code3.len>1)
{
strcat(antibodies.arr,",");
strcat(antibodies.arr,nd_anti_code3.arr);
}

if (nd_anti_code4.len>1)
{
strcat(antibodies.arr,",");
strcat(antibodies.arr,nd_anti_code4.arr);
}

if (nd_anti_code5.len>1)
{
strcat(antibodies.arr,",");
strcat(antibodies.arr,nd_anti_code5.arr);
}

        nd_specimen_date_time.arr[nd_specimen_date_time.len] = '\0';
        nd_antibody_code.arr[nd_antibody_code.len]           = '\0';
	    nd_anti_code2.arr[nd_anti_code2.len]                = '\0';
	    nd_anti_code3.arr[nd_anti_code3.len]                 = '\0';
	    nd_anti_code4.arr[nd_anti_code4.len]                = '\0';
	    nd_anti_code5.arr[nd_anti_code5.len]                 = '\0';

#ifdef DEBUG
    printf("leaving get_specimen_dtls()\n");
#endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1022;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_specimen_dtls() occured....\n");
   proc_exit();	
}


void print_specimen_dtls()
{


 fprintf(f1,"Specimen No :%s        ",d_specimen_no.arr);
 fprintf(f1,"Date Time :%s",nd_specimen_date_time.arr);

 fprintf(f1,"\n\tType  Of Antibodies\t:-\t%s\n", antibodies.arr);
 fprintf(f1,"\tRequested Units\t\t:-\n");

  do_category();
}

void print_unit_hdr(char t_c)
{
 char unit_type[13]; 
if (t_c=='T')
     strcpy(unit_type,"Transfused");
 else
    strcpy(unit_type,"Crossmatched");
 fprintf(f1,"------------------------------------");
 fprintf(f1,"------------------------------------");
 fprintf(f1,"\nUNIT NO         PRODUCT    VOLUME  BLOOD  RHESUS  %s  REACTION\n",unit_type);
 fprintf(f1,"                                   GROUP");
 fprintf(f1,"\n");
 fprintf(f1,"------------------------------------");
 fprintf(f1,"------------------------------------");
 fprintf(f1,"\n");
line_no=line_no + 4;
}

void print_detail_record(char t_c) 
{
 char unit_type[13]; 
if (t_c=='T')

     strcpy(unit_type,"TRANSFUSED");
 else
    strcpy(unit_type,"CROSSMATCHED");


// fprintf(f1,"%-16s%-11s%d%-4s   %-3s  %-8s%s  %-16s",d_unit_no.arr,
//				d_short_desc.arr,d_volume,d_volume_units.arr,d_blood_group.arr,d_rhesus_code.arr,unit_type,d_short_description.arr);

fprintf(f1,"%-16s",d_unit_no.arr);
fprintf(f1,"%-11s",d_short_desc.arr);
fprintf(f1,"%d",d_volume);
fprintf(f1,"%-4s",d_volume_units.arr);
fprintf(f1,"%-3s",d_blood_group.arr);
fprintf(f1,"%-8s",d_rhesus_code.arr);
fprintf(f1,"%d",unit_type);
fprintf(f1,"%-16s",d_short_description.arr);

 fprintf(f1,"\n") ;
 line_no++ ;
}

/********* DECLARE CATEGORY_CURSOR **********/

  void dclr_category_cur()
  {

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  
  /*
  EXEC SQL DECLARE CATEGORY_CURSOR CURSOR FOR
          SELECT category_code,category_requested
		  FROM BT_UNIT_REQUEST_CATEGORY A
          WHERE A.specimen_no IN(SELECT specimen_no FROM BT_UNIT_REQUEST_HDR
                             WHERE specimen_no = A.specimen_no
							 AND   OPERATING_FACILITY_ID=:nd_operating_facility_id)
		  AND A.OPERATING_FACILITY_ID=:nd_operating_facility_id					 ;
*/

  /* EXEC SQL DECLARE CATEGORY_CURSOR CURSOR FOR
          SELECT category_code,category_requested
		  FROM BT_UNIT_REQUEST_CATEGORY A
          WHERE A.specimen_no = TO_NUMBER(:d_specimen_no)
		  AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 


#ifdef DEBUG
    printf("leaving category_cur()\n");
    fflush(stdout);
#endif
   
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1037;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_category_cur() occured....\n");
   proc_exit();	
}


/********* OPEN CATEGORY CURSOR **********/
 void open_category_cur()
  {
     /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

     /* EXEC SQL OPEN CATEGORY_CURSOR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0041;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1052;
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
     sqlstm.sqphsv = sqlstm.sqhstv;
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
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1075;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message(ORA_MESG,"Oracle error while Opening category cursor occured...\n");
     proc_exit();
  }

/********* FETCH CATEGORY CURSOR **********/
int fetch_category_cur()
{

  d_category_code.arr[0]  = '\0';
  d_category_code.len		= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH CATEGORY_CURSOR	
            INTO :d_category_code,
				 :d_category_requested; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1090;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_category_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_category_requested;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  d_category_code.arr[d_category_code.len]	= '\0';


#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
{
    return 0;
}

  return 1;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1113;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_Detail_cross_cursor() occured....\n");
   proc_exit();

}

/********** CLOSE CATEGORY CURSOR *********/
void close_category_cur()
{
  
	 /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	 /* EXEC SQL CLOSE CATEGORY_CURSOR ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1128;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
  if (sqlca.sqlcode < 0) goto err_exit;
}



	 return ;
   
   err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1143;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message(ORA_MESG,"Oracle error while Closing category cursor occured...\n");
     proc_exit();
}
/************* DO CATEGORY *******************/

do_category()
{

  int still_category_exist=0;

  dclr_category_cur();
  open_category_cur();

  still_category_exist = fetch_category_cur();
  while (still_category_exist==1)
  {
    if (line_no>=MAX_LINES) 
      {
	      line_no=0;
		 //fprintf(f1,"");
	     fprintf(f1,"\f");
  		  page_no++;
		  print_hdr();
      }
 
       print_category_dtls();

  
       still_category_exist=fetch_category_cur();
  } 
 close_category_cur();
 	  
 fprintf(f1,"------------------------------------");
 fprintf(f1,"------------------------------------");
 fprintf(f1,"\n");
 line_no = line_no + 1;

}


print_category_dtls()
{
 
 fprintf(f1,"%-4.4s",d_category_code.arr);
 fprintf(f1,"  :-  %d\n",d_category_requested);
 line_no++;
}

