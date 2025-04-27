
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
           char  filnam[32];
};
static const struct sqlcxp sqlfpn =
{
    31,
    "C:\\gana\\MLVER2\\PROC\\blradmbg.pc"
};


static unsigned long sqlctx = 765437203;


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
            void  *sqhstv[26];
   unsigned int   sqhstl[26];
            int   sqhsts[26];
            void  *sqindv[26];
            int   sqinds[26];
   unsigned int   sqharm[26];
   unsigned int   *sqharc[26];
   unsigned short  sqadto[26];
   unsigned short  sqtdso[26];
} sqlstm = {10,26};

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

 static const char *sq0009 = 
"GRP_ID between :b2 and :b3) and NVL(IAT.TRN_TYPE,:b4) between :b4 and :b6) a\
nd NVL(IAT.TO_WARD_CODE,:b7) between :b7 and :b9) and NVL(IAT.TO_BED_CLASS_COD\
E,:b10) between :b10 and :b12) and NVL(IAT.TO_PHYSICIAN_ID,:b13) between :b13 \
and :b15) and NVL(IAT.MED_SPLTY_GRP_CODE,:b16) between :b16 and :b18) and NVL(\
IAT.ADM_DISCHARGE_REFERENCE,:b19) between :b19 and :b21) and IAT.FACILITY_ID=:\
b22) and OPERATING_FACILITY_ID=:b22) order by IAT.TRN_DATE_TIME,BLFIN.BLNG_GRP\
_ID,BLFIN.CUST_CODE,IAT.TO_WARD_CODE,IAT.EPISODE_ID            ";

 static const char *sq0010 = 
"GRP_ID between :b2 and :b3) and NVL(IAT.TRN_TYPE,:b4) between :b4 and :b6) a\
nd NVL(IAT.TO_WARD_CODE,:b7) between :b7 and :b9) and NVL(IAT.TO_BED_CLASS_COD\
E,:b10) between :b10 and :b12) and NVL(IAT.TO_PHYSICIAN_ID,:b13) between :b13 \
and :b15) and NVL(IAT.MED_SPLTY_GRP_CODE,:b16) between :b16 and :b18) and NVL(\
IAT.ADM_DISCHARGE_REFERENCE,:b19) between :b19 and :b21) and IAT.FACILITY_ID=:\
b22) and OPERATING_FACILITY_ID=:b22) order by IAT.TRN_DATE_TIME,IAT.TO_BED_NUM\
,BLFIN.BLNG_GRP_ID,BLFIN.CUST_CODE,IAT.TO_WARD_CODE,IAT.EPISODE_ID            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,205,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,220,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,227,0,0,0,0,0,1,0,
66,0,0,4,340,0,4,240,0,0,19,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,1,0,0,1,9,0,0,1,9,0,0,
157,0,0,5,91,0,2,313,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
180,0,0,6,0,0,32,321,0,0,0,0,0,1,0,
195,0,0,7,128,0,4,330,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
226,0,0,8,0,0,32,347,0,0,0,0,0,1,0,
241,0,0,9,1553,0,9,495,0,0,24,24,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
352,0,0,10,1568,0,9,498,0,0,24,24,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
463,0,0,11,0,0,32,506,0,0,0,0,0,1,0,
478,0,0,9,0,0,13,589,0,0,26,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,3,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
597,0,0,10,0,0,13,623,0,0,26,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,3,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
716,0,0,12,503,0,6,661,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
743,0,0,13,0,0,32,725,0,0,0,0,0,1,0,
758,0,0,14,70,0,4,1055,0,0,2,1,0,1,0,1,9,0,0,2,4,0,0,
781,0,0,15,95,0,4,1065,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
808,0,0,16,64,0,4,1077,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
831,0,0,17,0,0,32,1088,0,0,0,0,0,1,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: blradmbg.pc
   Author : Faizal Eledath
   Converted To Windows : Prasad B G S         3/7/96
   (Chinese changed to Local)
   Date Created : 14/04/1993
   Last Modified : 18/04/1993   
          
*  Ver 4.1        
        
*  Purpose : To report on Admissions for a selected period.
            
*  Input Parameters : 
                      Command line inputs
		      1. Usr_id/Password
                      2. Session id
		      3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4. Preferred range of date_time for admission
		      5. Range of Admission Type
                      6. Range of Ward Codes
    	              7. Range of Bed Classes 
    	              8. Range of doctor ID's
  
*  Table Accessed : IP_ADT_TRN

*  Programs accessed : comma.c

*  Output File : blradmbg.lis
*****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <bl.h>

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 4.1\n"
/*
#define DEBUG
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR uid_pwd		   [91],
 
                /o from IP_ADT_TRN o/
		d_fr_ward_code			[5],
		d_patient_id			[21],
		d_last_name_loc_lang	[21],
		d_first_name_loc_lang	[21],
		d_last_name				[21],
		d_first_name			[21],
		d_second_name			[21],
		d_sex					[2],
		d_date_of_birth	        [13],
		d_fr_physician_id		[16],
		d_episode_id			[9],
		d_trn_date_time	        [20],
		d_trn_type				[3],
		d_fr_bed_num			[9],
		d_fr_room_num			[5], 
		d_fr_bed_class_code		[3],
		d_fr_bed_type_code		[3],
		d_med_splty_grp_code    [5],
        d_adm_dis_reference     [5],
		d_baby_ind              [2],
		d_short_name_loc_lang   [61],
		d_short_name_full       [61],
        mp_pat_short_name       [61],
		d_short_name            [61],
		d_short_name1           [61],  
		d_blng_grp_id           [3],
		d_cust_code             [9],
		d_cust_short_name       [16],

		/o input parameters to main() o/
                nd_session_id      [16],
		nd_pgm_date	   [20],

		/o******* parameters from SY_PROG_PARAM table **********o/
		nd_fr_trn_date_time		[20],
		nd_to_trn_date_time		[20],
		nd_fr_trn_type			[3],
		nd_to_trn_type			[3],
		nd_fr_fr_ward_code		[5],
		nd_to_fr_ward_code		[5],
		nd_fr_fr_bed_class_code	[5],
		nd_to_fr_bed_class_code	[5],
		nd_fr_fr_physician_id	[16],
		nd_to_fr_physician_id	[16],
        nd_fr_med_splty_grp_code[5],
        nd_to_med_splty_grp_code[5],
		nd_adm_dis_reference    [5],
		nd_fr_blng_grp_id       [3],
		nd_to_blng_grp_id       [3],
		nd_operating_facility_id[3],
		

               /o from SY_PHYSICIAN_MAST o/
	       d_phys_short_name         [16], /o modified 28/03/1993 faizal o/

               /o from SY_REFERRAL o/
	       d_adm_dis_reference_desc  [31],

               /o from IP_ADMISSION_TYPE o/
	       d_trn_type_desc           [31],

               /o from IP_WARD o/
	       nd_ward_code_desc         [31],

               /o from IP_WARD_TYPE o/
	       d_ward_type_code          [5],
	       nd_ward_type_desc         [31],

               /o from IP_WARD_TYPE o/
	       d_med_splty_grp_desc      [16],

               /o variable for cursor o/
		nd_cur_trn_date_time     [20],
                nd_cur_ward_code         [5],

                nd_fr_adm_dis_reference  [5],
                nd_to_adm_dis_reference  [5],

	       /o for header routine o/
	       d_acc_entity_name         [41],
	       d_user                    [21],
	       d_sysdate                 [20]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[5]; } d_fr_ward_code;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_last_name_loc_lang;

struct { unsigned short len; unsigned char arr[21]; } d_first_name_loc_lang;

struct { unsigned short len; unsigned char arr[21]; } d_last_name;

struct { unsigned short len; unsigned char arr[21]; } d_first_name;

struct { unsigned short len; unsigned char arr[21]; } d_second_name;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[13]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[16]; } d_fr_physician_id;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[20]; } d_trn_date_time;

struct { unsigned short len; unsigned char arr[3]; } d_trn_type;

struct { unsigned short len; unsigned char arr[9]; } d_fr_bed_num;

struct { unsigned short len; unsigned char arr[5]; } d_fr_room_num;

struct { unsigned short len; unsigned char arr[3]; } d_fr_bed_class_code;

struct { unsigned short len; unsigned char arr[3]; } d_fr_bed_type_code;

struct { unsigned short len; unsigned char arr[5]; } d_med_splty_grp_code;

struct { unsigned short len; unsigned char arr[5]; } d_adm_dis_reference;

struct { unsigned short len; unsigned char arr[2]; } d_baby_ind;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_short_name1;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[16]; } d_cust_short_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } nd_fr_trn_date_time;

struct { unsigned short len; unsigned char arr[20]; } nd_to_trn_date_time;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_trn_type;

struct { unsigned short len; unsigned char arr[3]; } nd_to_trn_type;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_fr_ward_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_fr_ward_code;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_fr_bed_class_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_fr_bed_class_code;

struct { unsigned short len; unsigned char arr[16]; } nd_fr_fr_physician_id;

struct { unsigned short len; unsigned char arr[16]; } nd_to_fr_physician_id;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_med_splty_grp_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_med_splty_grp_code;

struct { unsigned short len; unsigned char arr[5]; } nd_adm_dis_reference;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } nd_to_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[16]; } d_phys_short_name;

struct { unsigned short len; unsigned char arr[31]; } d_adm_dis_reference_desc;

struct { unsigned short len; unsigned char arr[31]; } d_trn_type_desc;

struct { unsigned short len; unsigned char arr[31]; } nd_ward_code_desc;

struct { unsigned short len; unsigned char arr[5]; } d_ward_type_code;

struct { unsigned short len; unsigned char arr[31]; } nd_ward_type_desc;

struct { unsigned short len; unsigned char arr[16]; } d_med_splty_grp_desc;

struct { unsigned short len; unsigned char arr[20]; } nd_cur_trn_date_time;

struct { unsigned short len; unsigned char arr[5]; } nd_cur_ward_code;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_adm_dis_reference;

struct { unsigned short len; unsigned char arr[5]; } nd_to_adm_dis_reference;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;


    char       rep_order;

/* calculated fields from IP_WAIT_LIST */ 
float		nd_total_months, nd_days_old;
int		nd_trunc_total_months;

char filename[150];

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRADMBG.C-arc   1.0   Apr 19 2007 17:05:22   vcm_th  $ sqlca.h 
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

int   line_no=0, page_no=1;

/* summary fields for calculating No. of records */ 
/** modified 16/03/1993 faizal **/
long   totl_detl_rec = 0,
       grand_totl_rec = 0;

char nd_wl_status_desc[10],
     nd_fr_time[20],
     nd_to_time[20],
     nd_time_desc[50],
     nd_date_desc[50],
     nd_date_line[132],
     spaces[100];

FILE *f1;

  int nd_age_years, 
      nd_age_months,
      nd_age_days;

/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRADMBG.C-arc   1.0   Apr 19 2007 17:05:22   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRADMBG.C-arc   1.0   Apr 19 2007 17:05:22   vcm_th  $ sqlda.h 
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

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
  	dclr_ip_adt_trn_cur();
 
    strcpy(filename,WORKING_DIR);
	strcat(filename,"blradmbg.lis");

   if((f1 = fopen(filename, "w")) == NULL) {
     disp_message(ERR_MESG,".... Error opening output file ....");
     proc_exit();
   } 

   if(argc <= 4) {
     disp_message(ERR_MESG,"Usage blradmbg uid/passwd session_id pgm_date");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

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

   get_params();

   dclr_ip_adt_trn_cur();

   get_header_dtls();

   process_rep();


   /*EXEC SQL CLOSE IP_WAIT_LIST_CUR;*/
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
		   PARAM8,
		   PARAM9,
		   PARAM10,
		   PARAM11,
		   PARAM12,
		   PARAM13,    
		   PARAM14,  
		   PARAM15,
		   PARAM16
            INTO 
		:nd_operating_facility_id,
		:nd_fr_trn_date_time,
		:nd_to_trn_date_time,
		:nd_fr_trn_type,
		:nd_to_trn_type,
		:nd_fr_fr_ward_code,
		:nd_to_fr_ward_code,
		:nd_fr_fr_bed_class_code,
		:nd_to_fr_bed_class_code,
		:nd_fr_fr_physician_id,
		:nd_to_fr_physician_id,
        :nd_fr_med_splty_grp_code,
        :nd_to_med_splty_grp_code,
		:nd_adm_dis_reference,
		:nd_fr_blng_grp_id,
		:nd_to_blng_grp_id,
		:rep_order
        FROM	SY_PROG_PARAM
	    WHERE   PGM_ID = 'BLRADMBG'
		AND		SESSION_ID = TO_NUMBER(:nd_session_id)
		AND		PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 19;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13\
 ,PARAM14 ,PARAM15 ,PARAM16 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,\
:b11,:b12,:b13,:b14,:b15,:b16  from SY_PROG_PARAM where ((PGM_ID='BLRADMBG' an\
d SESSION_ID=TO_NUMBER(:b17)) and PGM_DATE=:b18)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_trn_date_time;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_trn_date_time;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fr_trn_type;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_trn_type;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fr_fr_ward_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_fr_ward_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fr_fr_bed_class_code;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_fr_bed_class_code;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_fr_fr_physician_id;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_fr_physician_id;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_fr_med_splty_grp_code;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_to_med_splty_grp_code;
   sqlstm.sqhstl[12] = (unsigned int  )7;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_adm_dis_reference;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_fr_blng_grp_id;
   sqlstm.sqhstl[14] = (unsigned int  )5;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_to_blng_grp_id;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&rep_order;
   sqlstm.sqhstl[16] = (unsigned int  )1;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[17] = (unsigned int  )18;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[18] = (unsigned int  )22;
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




  nd_fr_trn_date_time.arr[nd_fr_trn_date_time.len] 		= '\0';
  nd_to_trn_date_time.arr[nd_to_trn_date_time.len] 		= '\0';
  nd_fr_trn_type.arr[nd_fr_trn_type.len] 			= '\0';
  nd_to_trn_type.arr[nd_to_trn_type.len] 			= '\0';
  nd_fr_fr_ward_code.arr[nd_fr_fr_ward_code.len] 		= '\0';
  nd_to_fr_ward_code.arr[nd_to_fr_ward_code.len] 		= '\0';
  nd_fr_fr_bed_class_code.arr[nd_fr_fr_bed_class_code.len] 	= '\0';
  nd_to_fr_bed_class_code.arr[nd_to_fr_bed_class_code.len] 	= '\0';
  nd_fr_fr_physician_id.arr[nd_fr_fr_physician_id.len] 		= '\0';
  nd_to_fr_physician_id.arr[nd_to_fr_physician_id.len] 		= '\0';
  nd_fr_med_splty_grp_code.arr[nd_fr_med_splty_grp_code.len]    = '\0';
  nd_to_med_splty_grp_code.arr[nd_to_med_splty_grp_code.len]    = '\0';
  nd_adm_dis_reference.arr[nd_adm_dis_reference.len] 		= '\0';
  nd_fr_blng_grp_id.arr[nd_fr_blng_grp_id.len]                  = '\0';
  nd_to_blng_grp_id.arr[nd_to_blng_grp_id.len]                  = '\0';

   strcpy(g_facility_id, nd_operating_facility_id.arr);

   if (strcmp(nd_adm_dis_reference.arr, "%") == 0){
      strcpy(nd_fr_adm_dis_reference.arr, "!!!!");
      strcpy(nd_to_adm_dis_reference.arr, "~~~~");
   }
   else  { strcpy(nd_fr_adm_dis_reference.arr, nd_adm_dis_reference.arr);
           strcpy(nd_to_adm_dis_reference.arr, nd_adm_dis_reference.arr);
         }
   nd_fr_adm_dis_reference.len = strlen(nd_fr_adm_dis_reference.arr);
   nd_to_adm_dis_reference.len = strlen(nd_to_adm_dis_reference.arr);


  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE PGM_ID = 'BLRADMBG'
	         AND SESSION_ID = :nd_session_id
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 19;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRADMBG' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )157;
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
   sqlstm.arrsiz = 19;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )180;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_params() occured....");
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
            FROM SY_ACC_ENTITY
			WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 19;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )195;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )43;
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
   sqlstm.sqhstl[2] = (unsigned int  )22;
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
   sqlstm.arrsiz = 19;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )226;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....");
   proc_exit();
}
 

/* function declares IP_ADT_TRN_CUR cursor on the IP_ADT_TRN */
void dclr_ip_adt_trn_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



    /* EXEC SQL DECLARE IP_ADT_TRN_CUR1 CURSOR FOR
	   SELECT   BLFIN.BLNG_GRP_ID,
		BLFIN.CUST_CODE,
		IAT.TO_WARD_CODE,
		IAT.PATIENT_ID,
		DECODE(MP.TITLE_CODE,'BABY OF','*'),
		SUBSTR(MP.SHORT_NAME_LOC_LANG,1,16),
		MP.LAST_NAME_LOC_LANG,
		MP.FIRST_NAME_LOC_LANG,
		MP.LAST_NAME,
		MP.FIRST_NAME,
		MP.SECOND_NAME,
		MP.SEX,
	    TO_CHAR(DATE_OF_BIRTH, 'DD/MM/YYYY'),
	    TO_CHAR(MONTHS_BETWEEN(SYSDATE, DATE_OF_BIRTH)),
	    TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, DATE_OF_BIRTH))),
		IAT.TO_PHYSICIAN_ID,
		TO_CHAR(IAT.EPISODE_ID),
		TO_CHAR(IAT.TRN_DATE_TIME, 'DD/MM/YYYY HH24:MI'),
		IAT.TRN_TYPE,
		IAT.TO_BED_NUM, 
		IAT.TO_ROOM_NUM,
		IAT.TO_BED_CLASS_CODE,
		IAT.TO_BED_TYPE_CODE,
 		IAT.MED_SPLTY_GRP_CODE,
        IAT.ADM_DISCHARGE_REFERENCE,
		mp.short_name 
     FROM       MP_PATIENT_MAST MP, 
				BL_EPISODE_FIN_DTLS BLFIN,
                IP_ADT_TRN_HIS_VW IAT
     WHERE  IAT.PATIENT_ID = MP.PATIENT_ID(+)
			AND BLFIN.EPISODE_TYPE in ('I','D') //EPNH 04012005
			AND IAT.EPISODE_ID   = BLFIN.EPISODE_ID
			AND IAT.TRN_CODE = 'A'
			AND NVL(IAT.ADT_TRN_STATUS, 'X') != '9'  // ie not cancelled 
            AND IAT.TRN_DATE_TIME BETWEEN 
				TO_DATE(:nd_fr_trn_date_time,'DD/MM/YYYY HH24:MI')
			AND TO_DATE(:nd_to_trn_date_time,'DD/MM/YYYY HH24:MI')
			AND BLFIN.BLNG_GRP_ID BETWEEN
			     :nd_fr_blng_grp_id
			     AND :nd_to_blng_grp_id
			AND NVL(IAT.TRN_TYPE, :nd_fr_trn_type) BETWEEN 
			     :nd_fr_trn_type
			     AND :nd_to_trn_type
			AND NVL(IAT.TO_WARD_CODE, :nd_fr_fr_ward_code) BETWEEN 
			     :nd_fr_fr_ward_code
			     AND :nd_to_fr_ward_code
            AND NVL(IAT.TO_BED_CLASS_CODE, :nd_fr_fr_bed_class_code) BETWEEN
			    :nd_fr_fr_bed_class_code
			    AND :nd_to_fr_bed_class_code
            AND NVL(IAT.TO_PHYSICIAN_ID, :nd_fr_fr_physician_id) BETWEEN
			    :nd_fr_fr_physician_id
			    AND :nd_to_fr_physician_id
            AND NVL(IAT.MED_SPLTY_GRP_CODE, :nd_fr_med_splty_grp_code) BETWEEN
			    :nd_fr_med_splty_grp_code
			    AND :nd_to_med_splty_grp_code
            AND NVL(IAT.ADM_DISCHARGE_REFERENCE, :nd_fr_adm_dis_reference) BETWEEN
			    :nd_fr_adm_dis_reference
			    AND :nd_to_adm_dis_reference 
			AND IAT.FACILITY_ID = :nd_operating_facility_id
			AND OPERATING_FACILITY_ID = :nd_operating_facility_id
     ORDER BY IAT.TRN_DATE_TIME, 
              BLFIN.BLNG_GRP_ID, BLFIN.CUST_CODE,
              IAT.TO_WARD_CODE, IAT.EPISODE_ID; */ 


    /* EXEC SQL DECLARE IP_ADT_TRN_CUR2 CURSOR FOR
       SELECT   BLFIN.BLNG_GRP_ID,
		BLFIN.CUST_CODE,
		IAT.TO_WARD_CODE,
		IAT.PATIENT_ID,
		DECODE(MP.TITLE_CODE,'BABY OF','*'),
		SUBSTR(MP.SHORT_NAME_LOC_LANG,1,16),
		MP.LAST_NAME_LOC_LANG,
		MP.FIRST_NAME_LOC_LANG,
		MP.LAST_NAME,
		MP.FIRST_NAME,
		MP.SECOND_NAME,
		MP.SEX,
	    TO_CHAR(DATE_OF_BIRTH, 'DD/MM/YYYY'),
	    TO_CHAR(MONTHS_BETWEEN(SYSDATE, DATE_OF_BIRTH)),
	    TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, DATE_OF_BIRTH))),
		IAT.TO_PHYSICIAN_ID,
		TO_CHAR(IAT.EPISODE_ID),
		TO_CHAR(IAT.TRN_DATE_TIME, 'DD/MM/YYYY HH24:MI'),
		IAT.TRN_TYPE,
		IAT.TO_BED_NUM, 
		IAT.TO_ROOM_NUM,
		IAT.TO_BED_CLASS_CODE,
		IAT.TO_BED_TYPE_CODE,
 		IAT.MED_SPLTY_GRP_CODE,  
                IAT.ADM_DISCHARGE_REFERENCE,
				  mp.short_name 
     FROM       MP_PATIENT_MAST MP, 
				BL_EPISODE_FIN_DTLS BLFIN,
                IP_ADT_TRN_HIS_VW IAT
     WHERE  IAT.PATIENT_ID = MP.PATIENT_ID(+)
	    AND BLFIN.EPISODE_TYPE  in ('I','D') //EPNH 04012005
	    AND IAT.EPISODE_ID   = BLFIN.EPISODE_ID
	    AND IAT.TRN_CODE = 'A'
	    AND NVL(IAT.ADT_TRN_STATUS, 'X') != '9'  
            AND IAT.TRN_DATE_TIME BETWEEN 
			  TO_DATE(:nd_fr_trn_date_time,'DD/MM/YYYY HH24:MI')
			  AND TO_DATE(:nd_to_trn_date_time,'DD/MM/YYYY HH24:MI')
	    AND BLFIN.BLNG_GRP_ID BETWEEN
			     :nd_fr_blng_grp_id
			     AND :nd_to_blng_grp_id
	    AND NVL(IAT.TRN_TYPE, :nd_fr_trn_type) BETWEEN 
			     :nd_fr_trn_type
			     AND :nd_to_trn_type
	    AND NVL(IAT.TO_WARD_CODE, :nd_fr_fr_ward_code) BETWEEN 
			     :nd_fr_fr_ward_code
			     AND :nd_to_fr_ward_code
            AND NVL(IAT.TO_BED_CLASS_CODE, :nd_fr_fr_bed_class_code) BETWEEN
			    :nd_fr_fr_bed_class_code
			    AND :nd_to_fr_bed_class_code
            AND NVL(IAT.TO_PHYSICIAN_ID, :nd_fr_fr_physician_id) BETWEEN
			    :nd_fr_fr_physician_id
			    AND :nd_to_fr_physician_id
            AND NVL(IAT.MED_SPLTY_GRP_CODE, :nd_fr_med_splty_grp_code) BETWEEN
			    :nd_fr_med_splty_grp_code
			    AND :nd_to_med_splty_grp_code
            AND NVL(IAT.ADM_DISCHARGE_REFERENCE, :nd_fr_adm_dis_reference) BETWEEN
			    :nd_fr_adm_dis_reference
			    AND :nd_to_adm_dis_reference 
			AND IAT.FACILITY_ID = :nd_operating_facility_id
			AND OPERATING_FACILITY_ID = :nd_operating_facility_id
     ORDER BY IAT.TRN_DATE_TIME, 
              IAT.TO_BED_NUM,BLFIN.BLNG_GRP_ID, BLFIN.CUST_CODE,
              IAT.TO_WARD_CODE, IAT.EPISODE_ID; */ 


   

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   if(rep_order == '1') {
       /* EXEC SQL OPEN IP_ADT_TRN_CUR1; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 24;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlbuft((void **)0, 
         "select BLFIN.BLNG_GRP_ID ,BLFIN.CUST_CODE ,IAT.TO_WARD_CODE ,IAT.P\
ATIENT_ID ,DECODE(MP.TITLE_CODE,'BABY OF','*') ,SUBSTR(MP.SHORT_NAME_LOC_LAN\
G,1,16) ,MP.LAST_NAME_LOC_LANG ,MP.FIRST_NAME_LOC_LANG ,MP.LAST_NAME ,MP.FIR\
ST_NAME ,MP.SECOND_NAME ,MP.SEX ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,TO_CHA\
R(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)) ,TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDA\
TE,DATE_OF_BIRTH))) ,IAT.TO_PHYSICIAN_ID ,TO_CHAR(IAT.EPISODE_ID) ,TO_CHAR(I\
AT.TRN_DATE_TIME,'DD/MM/YYYY HH24:MI') ,IAT.TRN_TYPE ,IAT.TO_BED_NUM ,IAT.TO\
_ROOM_NUM ,IAT.TO_BED_CLASS_CODE ,IAT.TO_BED_TYPE_CODE ,IAT.MED_SPLTY_GRP_CO\
DE ,IAT.ADM_DISCHARGE_REFERENCE ,mp.short_name  from MP_PATIENT_MAST MP ,BL_\
EPISODE_FIN_DTLS BLFIN ,IP_ADT_TRN_HIS_VW IAT where ((((((((((((((IAT.PATIEN\
T_ID=MP.PATIENT_ID(+) and BLFIN.EPISODE_TYPE in ('I','D')) and IAT.EPISODE_I\
D=BLFIN.EPISODE_ID) and IAT.TRN_CODE='A') and NVL(IAT.ADT_TRN_STATUS,'X')<>'\
9') and IAT.TRN_DATE_TIME between TO_DATE(:b0,'DD/MM/YYYY HH24:MI') and TO_D\
ATE(:b1,'DD/MM/YYYY HH24:MI')) and BLFIN.BLNG_");
       sqlstm.stmt = sq0009;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )241;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fr_trn_date_time;
       sqlstm.sqhstl[0] = (unsigned int  )22;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_trn_date_time;
       sqlstm.sqhstl[1] = (unsigned int  )22;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fr_blng_grp_id;
       sqlstm.sqhstl[2] = (unsigned int  )5;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_grp_id;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_fr_trn_type;
       sqlstm.sqhstl[4] = (unsigned int  )5;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_fr_trn_type;
       sqlstm.sqhstl[5] = (unsigned int  )5;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&nd_to_trn_type;
       sqlstm.sqhstl[6] = (unsigned int  )5;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&nd_fr_fr_ward_code;
       sqlstm.sqhstl[7] = (unsigned int  )7;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&nd_fr_fr_ward_code;
       sqlstm.sqhstl[8] = (unsigned int  )7;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&nd_to_fr_ward_code;
       sqlstm.sqhstl[9] = (unsigned int  )7;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&nd_fr_fr_bed_class_code;
       sqlstm.sqhstl[10] = (unsigned int  )7;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&nd_fr_fr_bed_class_code;
       sqlstm.sqhstl[11] = (unsigned int  )7;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&nd_to_fr_bed_class_code;
       sqlstm.sqhstl[12] = (unsigned int  )7;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&nd_fr_fr_physician_id;
       sqlstm.sqhstl[13] = (unsigned int  )18;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&nd_fr_fr_physician_id;
       sqlstm.sqhstl[14] = (unsigned int  )18;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&nd_to_fr_physician_id;
       sqlstm.sqhstl[15] = (unsigned int  )18;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&nd_fr_med_splty_grp_code;
       sqlstm.sqhstl[16] = (unsigned int  )7;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&nd_fr_med_splty_grp_code;
       sqlstm.sqhstl[17] = (unsigned int  )7;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&nd_to_med_splty_grp_code;
       sqlstm.sqhstl[18] = (unsigned int  )7;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&nd_fr_adm_dis_reference;
       sqlstm.sqhstl[19] = (unsigned int  )7;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&nd_fr_adm_dis_reference;
       sqlstm.sqhstl[20] = (unsigned int  )7;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&nd_to_adm_dis_reference;
       sqlstm.sqhstl[21] = (unsigned int  )7;
       sqlstm.sqhsts[21] = (         int  )0;
       sqlstm.sqindv[21] = (         void  *)0;
       sqlstm.sqinds[21] = (         int  )0;
       sqlstm.sqharm[21] = (unsigned int  )0;
       sqlstm.sqadto[21] = (unsigned short )0;
       sqlstm.sqtdso[21] = (unsigned short )0;
       sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[22] = (unsigned int  )5;
       sqlstm.sqhsts[22] = (         int  )0;
       sqlstm.sqindv[22] = (         void  *)0;
       sqlstm.sqinds[22] = (         int  )0;
       sqlstm.sqharm[22] = (unsigned int  )0;
       sqlstm.sqadto[22] = (unsigned short )0;
       sqlstm.sqtdso[22] = (unsigned short )0;
       sqlstm.sqhstv[23] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[23] = (unsigned int  )5;
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
   else {
       /* EXEC SQL OPEN IP_ADT_TRN_CUR2; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 24;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlbuft((void **)0, 
         "select BLFIN.BLNG_GRP_ID ,BLFIN.CUST_CODE ,IAT.TO_WARD_CODE ,IAT.P\
ATIENT_ID ,DECODE(MP.TITLE_CODE,'BABY OF','*') ,SUBSTR(MP.SHORT_NAME_LOC_LAN\
G,1,16) ,MP.LAST_NAME_LOC_LANG ,MP.FIRST_NAME_LOC_LANG ,MP.LAST_NAME ,MP.FIR\
ST_NAME ,MP.SECOND_NAME ,MP.SEX ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,TO_CHA\
R(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)) ,TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDA\
TE,DATE_OF_BIRTH))) ,IAT.TO_PHYSICIAN_ID ,TO_CHAR(IAT.EPISODE_ID) ,TO_CHAR(I\
AT.TRN_DATE_TIME,'DD/MM/YYYY HH24:MI') ,IAT.TRN_TYPE ,IAT.TO_BED_NUM ,IAT.TO\
_ROOM_NUM ,IAT.TO_BED_CLASS_CODE ,IAT.TO_BED_TYPE_CODE ,IAT.MED_SPLTY_GRP_CO\
DE ,IAT.ADM_DISCHARGE_REFERENCE ,mp.short_name  from MP_PATIENT_MAST MP ,BL_\
EPISODE_FIN_DTLS BLFIN ,IP_ADT_TRN_HIS_VW IAT where ((((((((((((((IAT.PATIEN\
T_ID=MP.PATIENT_ID(+) and BLFIN.EPISODE_TYPE in ('I','D')) and IAT.EPISODE_I\
D=BLFIN.EPISODE_ID) and IAT.TRN_CODE='A') and NVL(IAT.ADT_TRN_STATUS,'X')<>'\
9') and IAT.TRN_DATE_TIME between TO_DATE(:b0,'DD/MM/YYYY HH24:MI') and TO_D\
ATE(:b1,'DD/MM/YYYY HH24:MI')) and BLFIN.BLNG_");
       sqlstm.stmt = sq0010;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )352;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fr_trn_date_time;
       sqlstm.sqhstl[0] = (unsigned int  )22;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_trn_date_time;
       sqlstm.sqhstl[1] = (unsigned int  )22;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fr_blng_grp_id;
       sqlstm.sqhstl[2] = (unsigned int  )5;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_grp_id;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_fr_trn_type;
       sqlstm.sqhstl[4] = (unsigned int  )5;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_fr_trn_type;
       sqlstm.sqhstl[5] = (unsigned int  )5;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&nd_to_trn_type;
       sqlstm.sqhstl[6] = (unsigned int  )5;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&nd_fr_fr_ward_code;
       sqlstm.sqhstl[7] = (unsigned int  )7;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&nd_fr_fr_ward_code;
       sqlstm.sqhstl[8] = (unsigned int  )7;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&nd_to_fr_ward_code;
       sqlstm.sqhstl[9] = (unsigned int  )7;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&nd_fr_fr_bed_class_code;
       sqlstm.sqhstl[10] = (unsigned int  )7;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&nd_fr_fr_bed_class_code;
       sqlstm.sqhstl[11] = (unsigned int  )7;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&nd_to_fr_bed_class_code;
       sqlstm.sqhstl[12] = (unsigned int  )7;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&nd_fr_fr_physician_id;
       sqlstm.sqhstl[13] = (unsigned int  )18;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&nd_fr_fr_physician_id;
       sqlstm.sqhstl[14] = (unsigned int  )18;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&nd_to_fr_physician_id;
       sqlstm.sqhstl[15] = (unsigned int  )18;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&nd_fr_med_splty_grp_code;
       sqlstm.sqhstl[16] = (unsigned int  )7;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&nd_fr_med_splty_grp_code;
       sqlstm.sqhstl[17] = (unsigned int  )7;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&nd_to_med_splty_grp_code;
       sqlstm.sqhstl[18] = (unsigned int  )7;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&nd_fr_adm_dis_reference;
       sqlstm.sqhstl[19] = (unsigned int  )7;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&nd_fr_adm_dis_reference;
       sqlstm.sqhstl[20] = (unsigned int  )7;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&nd_to_adm_dis_reference;
       sqlstm.sqhstl[21] = (unsigned int  )7;
       sqlstm.sqhsts[21] = (         int  )0;
       sqlstm.sqindv[21] = (         void  *)0;
       sqlstm.sqinds[21] = (         int  )0;
       sqlstm.sqharm[21] = (unsigned int  )0;
       sqlstm.sqadto[21] = (unsigned short )0;
       sqlstm.sqtdso[21] = (unsigned short )0;
       sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[22] = (unsigned int  )5;
       sqlstm.sqhsts[22] = (         int  )0;
       sqlstm.sqindv[22] = (         void  *)0;
       sqlstm.sqinds[22] = (         int  )0;
       sqlstm.sqharm[22] = (unsigned int  )0;
       sqlstm.sqadto[22] = (unsigned short )0;
       sqlstm.sqtdso[22] = (unsigned short )0;
       sqlstm.sqhstv[23] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[23] = (unsigned int  )5;
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
   sqlstm.offset = (unsigned int  )463;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_ip_adt_trn_cur() occured....");
   proc_exit();
}

process_rep()
{
  void prepare_new_page();     
  void print_rep_header();
  void print_page_header();
  void prepare_new_fr_to_date();
  void print_totl_per_day();
  void end_report();
  int fetch_ip_adt_trn_cur();
  int still_rec_left;


  print_rep_header(); 

  /* read the first cursor record */
  still_rec_left = fetch_ip_adt_trn_cur();
  if(still_rec_left == 0)
    prepare_new_page();
  while(still_rec_left) {    /* master_master record */

    strcpy(nd_cur_trn_date_time.arr, d_trn_date_time.arr);
    nd_cur_trn_date_time.len = strlen(nd_cur_trn_date_time.arr);

    prepare_new_fr_to_date();
    prepare_new_page();
    grand_totl_rec = 0;

    /* process until first level break group arrises */
    while((strncmp(nd_cur_trn_date_time.arr, d_trn_date_time.arr, 10) == 0)
						&& still_rec_left) {
   
       grand_totl_rec++;

       print_rec();  

       if(line_no >= MAX_LINES) 
           prepare_new_page();

        /* read the next cursor record */
        still_rec_left = fetch_ip_adt_trn_cur();
    }
    if((line_no + 2) >= MAX_LINES) {
         prepare_new_page();
         print_totl_per_day();
     }
     else print_totl_per_day(); 
 }
 if((line_no + 4) >= MAX_LINES){
   prepare_new_page();
   end_report();
   }
   else end_report();
}
  

/* prints the master-detail record until the cursor is empty */

/* prepares for the new page */
void prepare_new_page()
{
   page_no += 1;
   fprintf(f1,"");
   print_page_header();
   print_rep_head();
   line_no = 5;
}




/* fetches the next record from IP_ADT_TRN_CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_ip_adt_trn_cur()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  if(rep_order == '1') {
      /* EXEC SQL FETCH IP_ADT_TRN_CUR1 INTO
		    :d_blng_grp_id,
		    :d_cust_code,
		    :d_fr_ward_code,
		    :d_patient_id,
		    :d_baby_ind,
		    :d_short_name_loc_lang,
		   /o :d_short_name,
			:d_short_name1,o/
		    :d_last_name_loc_lang,
		    :d_first_name_loc_lang,
		    :d_last_name,
		    :d_first_name,
		    :d_second_name,
		    :d_sex,
		    :d_date_of_birth,
            :nd_total_months,
            :nd_trunc_total_months,
		    :d_fr_physician_id,
		    :d_episode_id,
		    :d_trn_date_time,
		    :d_trn_type,
		    :d_fr_bed_num,
		    :d_fr_room_num,
		    :d_fr_bed_class_code,
		    :d_fr_bed_type_code,
		    :d_med_splty_grp_code,
		    :d_adm_dis_reference,
			:d_short_name_full; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 26;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )478;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_cust_code;
      sqlstm.sqhstl[1] = (unsigned int  )11;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_fr_ward_code;
      sqlstm.sqhstl[2] = (unsigned int  )7;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
      sqlstm.sqhstl[3] = (unsigned int  )23;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_baby_ind;
      sqlstm.sqhstl[4] = (unsigned int  )4;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_short_name_loc_lang;
      sqlstm.sqhstl[5] = (unsigned int  )63;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_last_name_loc_lang;
      sqlstm.sqhstl[6] = (unsigned int  )23;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_first_name_loc_lang;
      sqlstm.sqhstl[7] = (unsigned int  )23;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_last_name;
      sqlstm.sqhstl[8] = (unsigned int  )23;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&d_first_name;
      sqlstm.sqhstl[9] = (unsigned int  )23;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&d_second_name;
      sqlstm.sqhstl[10] = (unsigned int  )23;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&d_sex;
      sqlstm.sqhstl[11] = (unsigned int  )4;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&d_date_of_birth;
      sqlstm.sqhstl[12] = (unsigned int  )15;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&nd_total_months;
      sqlstm.sqhstl[13] = (unsigned int  )sizeof(float);
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&nd_trunc_total_months;
      sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&d_fr_physician_id;
      sqlstm.sqhstl[15] = (unsigned int  )18;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&d_episode_id;
      sqlstm.sqhstl[16] = (unsigned int  )11;
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&d_trn_date_time;
      sqlstm.sqhstl[17] = (unsigned int  )22;
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&d_trn_type;
      sqlstm.sqhstl[18] = (unsigned int  )5;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&d_fr_bed_num;
      sqlstm.sqhstl[19] = (unsigned int  )11;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqhstv[20] = (         void  *)&d_fr_room_num;
      sqlstm.sqhstl[20] = (unsigned int  )7;
      sqlstm.sqhsts[20] = (         int  )0;
      sqlstm.sqindv[20] = (         void  *)0;
      sqlstm.sqinds[20] = (         int  )0;
      sqlstm.sqharm[20] = (unsigned int  )0;
      sqlstm.sqadto[20] = (unsigned short )0;
      sqlstm.sqtdso[20] = (unsigned short )0;
      sqlstm.sqhstv[21] = (         void  *)&d_fr_bed_class_code;
      sqlstm.sqhstl[21] = (unsigned int  )5;
      sqlstm.sqhsts[21] = (         int  )0;
      sqlstm.sqindv[21] = (         void  *)0;
      sqlstm.sqinds[21] = (         int  )0;
      sqlstm.sqharm[21] = (unsigned int  )0;
      sqlstm.sqadto[21] = (unsigned short )0;
      sqlstm.sqtdso[21] = (unsigned short )0;
      sqlstm.sqhstv[22] = (         void  *)&d_fr_bed_type_code;
      sqlstm.sqhstl[22] = (unsigned int  )5;
      sqlstm.sqhsts[22] = (         int  )0;
      sqlstm.sqindv[22] = (         void  *)0;
      sqlstm.sqinds[22] = (         int  )0;
      sqlstm.sqharm[22] = (unsigned int  )0;
      sqlstm.sqadto[22] = (unsigned short )0;
      sqlstm.sqtdso[22] = (unsigned short )0;
      sqlstm.sqhstv[23] = (         void  *)&d_med_splty_grp_code;
      sqlstm.sqhstl[23] = (unsigned int  )7;
      sqlstm.sqhsts[23] = (         int  )0;
      sqlstm.sqindv[23] = (         void  *)0;
      sqlstm.sqinds[23] = (         int  )0;
      sqlstm.sqharm[23] = (unsigned int  )0;
      sqlstm.sqadto[23] = (unsigned short )0;
      sqlstm.sqtdso[23] = (unsigned short )0;
      sqlstm.sqhstv[24] = (         void  *)&d_adm_dis_reference;
      sqlstm.sqhstl[24] = (unsigned int  )7;
      sqlstm.sqhsts[24] = (         int  )0;
      sqlstm.sqindv[24] = (         void  *)0;
      sqlstm.sqinds[24] = (         int  )0;
      sqlstm.sqharm[24] = (unsigned int  )0;
      sqlstm.sqadto[24] = (unsigned short )0;
      sqlstm.sqtdso[24] = (unsigned short )0;
      sqlstm.sqhstv[25] = (         void  *)&d_short_name_full;
      sqlstm.sqhstl[25] = (unsigned int  )63;
      sqlstm.sqhsts[25] = (         int  )0;
      sqlstm.sqindv[25] = (         void  *)0;
      sqlstm.sqinds[25] = (         int  )0;
      sqlstm.sqharm[25] = (unsigned int  )0;
      sqlstm.sqadto[25] = (unsigned short )0;
      sqlstm.sqtdso[25] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
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



    else {
      /* EXEC SQL FETCH IP_ADT_TRN_CUR2 INTO
		    :d_blng_grp_id,
		    :d_cust_code,
		    :d_fr_ward_code,
		    :d_patient_id,
		    :d_baby_ind,
		    :d_short_name_loc_lang,
		 /o   :d_short_name,
			:d_short_name1,o/
		    :d_last_name_loc_lang,
		    :d_first_name_loc_lang,
		    :d_last_name,
		    :d_first_name,
		    :d_second_name,
		    :d_sex,
		    :d_date_of_birth,
            :nd_total_months,
            :nd_trunc_total_months,
		    :d_fr_physician_id,
		    :d_episode_id,
		    :d_trn_date_time,
		    :d_trn_type,
		    :d_fr_bed_num,
		    :d_fr_room_num,
		    :d_fr_bed_class_code,
		    :d_fr_bed_type_code,
            :d_med_splty_grp_code,
		    :d_adm_dis_reference,
			:d_short_name_full; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 26;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )597;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_cust_code;
      sqlstm.sqhstl[1] = (unsigned int  )11;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_fr_ward_code;
      sqlstm.sqhstl[2] = (unsigned int  )7;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
      sqlstm.sqhstl[3] = (unsigned int  )23;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_baby_ind;
      sqlstm.sqhstl[4] = (unsigned int  )4;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_short_name_loc_lang;
      sqlstm.sqhstl[5] = (unsigned int  )63;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_last_name_loc_lang;
      sqlstm.sqhstl[6] = (unsigned int  )23;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_first_name_loc_lang;
      sqlstm.sqhstl[7] = (unsigned int  )23;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_last_name;
      sqlstm.sqhstl[8] = (unsigned int  )23;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&d_first_name;
      sqlstm.sqhstl[9] = (unsigned int  )23;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&d_second_name;
      sqlstm.sqhstl[10] = (unsigned int  )23;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&d_sex;
      sqlstm.sqhstl[11] = (unsigned int  )4;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&d_date_of_birth;
      sqlstm.sqhstl[12] = (unsigned int  )15;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&nd_total_months;
      sqlstm.sqhstl[13] = (unsigned int  )sizeof(float);
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&nd_trunc_total_months;
      sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&d_fr_physician_id;
      sqlstm.sqhstl[15] = (unsigned int  )18;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&d_episode_id;
      sqlstm.sqhstl[16] = (unsigned int  )11;
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&d_trn_date_time;
      sqlstm.sqhstl[17] = (unsigned int  )22;
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&d_trn_type;
      sqlstm.sqhstl[18] = (unsigned int  )5;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&d_fr_bed_num;
      sqlstm.sqhstl[19] = (unsigned int  )11;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqhstv[20] = (         void  *)&d_fr_room_num;
      sqlstm.sqhstl[20] = (unsigned int  )7;
      sqlstm.sqhsts[20] = (         int  )0;
      sqlstm.sqindv[20] = (         void  *)0;
      sqlstm.sqinds[20] = (         int  )0;
      sqlstm.sqharm[20] = (unsigned int  )0;
      sqlstm.sqadto[20] = (unsigned short )0;
      sqlstm.sqtdso[20] = (unsigned short )0;
      sqlstm.sqhstv[21] = (         void  *)&d_fr_bed_class_code;
      sqlstm.sqhstl[21] = (unsigned int  )5;
      sqlstm.sqhsts[21] = (         int  )0;
      sqlstm.sqindv[21] = (         void  *)0;
      sqlstm.sqinds[21] = (         int  )0;
      sqlstm.sqharm[21] = (unsigned int  )0;
      sqlstm.sqadto[21] = (unsigned short )0;
      sqlstm.sqtdso[21] = (unsigned short )0;
      sqlstm.sqhstv[22] = (         void  *)&d_fr_bed_type_code;
      sqlstm.sqhstl[22] = (unsigned int  )5;
      sqlstm.sqhsts[22] = (         int  )0;
      sqlstm.sqindv[22] = (         void  *)0;
      sqlstm.sqinds[22] = (         int  )0;
      sqlstm.sqharm[22] = (unsigned int  )0;
      sqlstm.sqadto[22] = (unsigned short )0;
      sqlstm.sqtdso[22] = (unsigned short )0;
      sqlstm.sqhstv[23] = (         void  *)&d_med_splty_grp_code;
      sqlstm.sqhstl[23] = (unsigned int  )7;
      sqlstm.sqhsts[23] = (         int  )0;
      sqlstm.sqindv[23] = (         void  *)0;
      sqlstm.sqinds[23] = (         int  )0;
      sqlstm.sqharm[23] = (unsigned int  )0;
      sqlstm.sqadto[23] = (unsigned short )0;
      sqlstm.sqtdso[23] = (unsigned short )0;
      sqlstm.sqhstv[24] = (         void  *)&d_adm_dis_reference;
      sqlstm.sqhstl[24] = (unsigned int  )7;
      sqlstm.sqhsts[24] = (         int  )0;
      sqlstm.sqindv[24] = (         void  *)0;
      sqlstm.sqinds[24] = (         int  )0;
      sqlstm.sqharm[24] = (unsigned int  )0;
      sqlstm.sqadto[24] = (unsigned short )0;
      sqlstm.sqtdso[24] = (unsigned short )0;
      sqlstm.sqhstv[25] = (         void  *)&d_short_name_full;
      sqlstm.sqhstl[25] = (unsigned int  )63;
      sqlstm.sqhsts[25] = (         int  )0;
      sqlstm.sqindv[25] = (         void  *)0;
      sqlstm.sqinds[25] = (         int  )0;
      sqlstm.sqharm[25] = (unsigned int  )0;
      sqlstm.sqadto[25] = (unsigned short )0;
      sqlstm.sqtdso[25] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
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
    


  if (NODATAFOUND)
    return 0;



/* EXEC SQL  EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_short_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :d_short_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_short_name1    := :d_short_name1 || str2;
       end if;
   
	END;             
  END;
          
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 26;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :d_short_name := str2 ; END IF ; blcommon . spli\
t_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NOT N\
ULL THEN :d_short_name1 := str2 ; END IF ; blcommon . split_words ( :d_short_n\
ame_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :d_short_na\
me1 := :d_short_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )716;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )63;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&d_short_name;
sqlstm.sqhstl[1] = (unsigned int  )63;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_short_name1;
sqlstm.sqhstl[2] = (unsigned int  )63;
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


 
       d_short_name.arr[d_short_name.len]  = '\0';
       d_short_name1.arr[d_short_name1.len]  = '\0';


  d_fr_ward_code.arr[d_fr_ward_code.len] 		= '\0';
  d_patient_id.arr[d_patient_id.len] 			= '\0';
  d_baby_ind.arr[d_baby_ind.len]                        = '\0';
  d_short_name_loc_lang.arr[d_short_name_loc_lang.len]  = '\0';
  d_short_name.arr[d_short_name.len]                    = '\0';
  d_short_name1.arr[d_short_name1.len]                    = '\0';
  d_last_name_loc_lang.arr[d_last_name_loc_lang.len] 	= '\0';
  d_first_name_loc_lang.arr[d_first_name_loc_lang.len] 	= '\0';
  d_last_name.arr[d_last_name.len] 			= '\0';
  d_first_name.arr[d_first_name.len] 			= '\0';
  d_second_name.arr[d_second_name.len] 			= '\0';
  d_sex.arr[d_sex.len] 					= '\0';
  d_date_of_birth.arr[d_date_of_birth.len] 		= '\0';
  d_fr_physician_id.arr[d_fr_physician_id.len] 		= '\0';
  d_episode_id.arr[d_episode_id.len] 			= '\0';
  d_trn_date_time.arr[d_trn_date_time.len] 		= '\0';
  d_trn_type.arr[d_trn_type.len] 			= '\0';
  d_fr_bed_num.arr[d_fr_bed_num.len] 			= '\0';
  d_fr_room_num.arr[d_fr_room_num.len] 			= '\0';
  d_fr_bed_class_code.arr[d_fr_bed_class_code.len] 	= '\0';
  d_fr_bed_type_code.arr[d_fr_bed_type_code.len] 	= '\0';
  d_med_splty_grp_code.arr[d_med_splty_grp_code.len]    = '\0';
  d_adm_dis_reference.arr[d_adm_dis_reference.len]      = '\0';
  d_blng_grp_id.arr[d_blng_grp_id.len]                  = '\0';
  d_cust_code.arr[d_cust_code.len]                      = '\0';
  d_short_name_full.arr[d_short_name_full.len]          = '\0';  



  fetch_other_dtls();

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 26;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )743;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_ip_adt_trn_cur() occured....");
   proc_exit();

}

/* print total number of detail records for the  day */
void print_totl_per_day()
{

 fprintf(f1, "\n");
 fprintf(f1, "Total for Day : %ld\n", grand_totl_rec);
 totl_detl_rec = 0;
 grand_totl_rec = 0;
}

/* prepares for the page header with new date parameters */
void prepare_new_fr_to_date()
{
 register int i, j;



  if(strncmp(nd_cur_trn_date_time.arr, nd_fr_trn_date_time.arr,10) == 0){
     for(i=0; i<6; i++){
       j=i+10;
       nd_fr_time[i] = nd_fr_trn_date_time.arr[j];
     }
    i += 1;
    nd_fr_time[i] = '\0';
    strcpy(nd_to_time, " 23:59");
  }
  else if(strncmp(nd_cur_trn_date_time.arr, nd_to_trn_date_time.arr, 10) == 0){
        strcpy(nd_fr_time, " 00:00");
	for(i=0; i<6; i++){
	 j = i+10;
	 nd_to_time[i] = nd_to_trn_date_time.arr[j];
        }
        i += 1;
        nd_to_time[i] = '\0';
       }
        else {strcpy(nd_fr_time, " 00:00");
              strcpy(nd_to_time, " 23:59");
             }
 
   sprintf(nd_time_desc,"FROM TIME :%-6.6s  TO TIME :%-6.6s", nd_fr_time, nd_to_time);
   strncpy(nd_date_desc, nd_cur_trn_date_time.arr, 10);
   strcpy(spaces, "                                       ");
   sprintf(nd_date_line,"%sFOR DATE : %-10.10s  %s",spaces, nd_date_desc,nd_time_desc);
}

/* to print the header page for the report */
void print_rep_header()
{
  register int i;
  void print_page_header();
  char nd_fr_trn_date_time_desc     [20],
       nd_to_trn_date_time_desc     [20],
       nd_fr_trn_type_desc	    [20],
       nd_to_trn_type_desc	    [20],
       nd_fr_fr_ward_code_desc      [20],
       nd_to_fr_ward_code_desc      [20],
       nd_fr_fr_bed_class_code_desc [20],
       nd_to_fr_bed_class_code_desc [20],
       nd_fr_fr_physician_id_desc   [20],
       nd_to_fr_physician_id_desc   [20],
       nd_fr_med_splty_grp_code_desc[20],
       nd_to_med_splty_grp_code_desc[20],
       nd_fr_blng_grp_id_desc       [20],
       nd_to_blng_grp_id_desc       [20],
       nd_adm_dis_reference_desc    [20];

  if(strcmp(nd_fr_trn_date_time.arr, "01/01/1800 00:00") == 0)
    strcpy(nd_fr_trn_date_time_desc, "LOWEST");
    else strcpy(nd_fr_trn_date_time_desc, nd_fr_trn_date_time.arr);

  if(strcmp(nd_to_trn_date_time.arr, "31/12/4712 23:59") == 0)
    strcpy(nd_to_trn_date_time_desc, "HIGHEST");
    else strcpy(nd_to_trn_date_time_desc, nd_to_trn_date_time.arr);

  if(strcmp(nd_fr_trn_type.arr, "!!") == 0)
    strcpy(nd_fr_trn_type_desc, "LOWEST");
    else strcpy(nd_fr_trn_type_desc, nd_fr_trn_type.arr);

  if(strcmp(nd_to_trn_type.arr, "~~") == 0)
    strcpy(nd_to_trn_type_desc, "HIGHEST");
    else strcpy(nd_to_trn_type_desc, nd_to_trn_type.arr);

  if(strcmp(nd_fr_fr_ward_code.arr, "!!!!") == 0)
    strcpy(nd_fr_fr_ward_code_desc, "LOWEST");
    else strcpy(nd_fr_fr_ward_code_desc, nd_fr_fr_ward_code.arr);

  if(strcmp(nd_to_fr_ward_code.arr, "~~~~") == 0)
    strcpy(nd_to_fr_ward_code_desc, "HIGHEST");
    else strcpy(nd_to_fr_ward_code_desc, nd_to_fr_ward_code.arr);

  if(strcmp(nd_fr_fr_bed_class_code.arr, "!!") == 0)
    strcpy(nd_fr_fr_bed_class_code_desc, "LOWEST");
    else strcpy(nd_fr_fr_bed_class_code_desc, nd_fr_fr_bed_class_code.arr);

  if(strcmp(nd_to_fr_bed_class_code.arr, "~~") == 0)
    strcpy(nd_to_fr_bed_class_code_desc, "HIGHEST");
    else strcpy(nd_to_fr_bed_class_code_desc, nd_to_fr_bed_class_code.arr);

  if(strcmp(nd_fr_fr_physician_id.arr, "!!!!!!") == 0)
    strcpy(nd_fr_fr_physician_id_desc, "LOWEST");
    else strcpy(nd_fr_fr_physician_id_desc, nd_fr_fr_physician_id.arr);

  if(strcmp(nd_to_fr_physician_id.arr, "~~~~~~") == 0)
    strcpy(nd_to_fr_physician_id_desc, "HIGHEST");
    else strcpy(nd_to_fr_physician_id_desc, nd_to_fr_physician_id.arr);

  if(strcmp(nd_fr_med_splty_grp_code.arr, "!!!!") == 0)
    strcpy(nd_fr_med_splty_grp_code_desc, "LOWEST");
    else strcpy(nd_fr_med_splty_grp_code_desc, nd_fr_med_splty_grp_code.arr);

  if(strcmp(nd_to_med_splty_grp_code.arr, "~~~~") == 0)
    strcpy(nd_to_med_splty_grp_code_desc, "HIGHEST");
    else strcpy(nd_to_med_splty_grp_code_desc, nd_to_med_splty_grp_code.arr);

  if(strcmp(nd_fr_blng_grp_id.arr, "!!") == 0)
    strcpy(nd_fr_blng_grp_id_desc, "LOWEST");
    else strcpy(nd_fr_blng_grp_id_desc, nd_fr_blng_grp_id.arr);

  if(strcmp(nd_to_blng_grp_id.arr, "~~") == 0)
    strcpy(nd_to_blng_grp_id_desc, "HIGHEST");
    else strcpy(nd_to_blng_grp_id_desc, nd_to_blng_grp_id.arr);

  if(strcmp(nd_adm_dis_reference.arr, "%") == 0)
    strcpy(nd_adm_dis_reference_desc, "ALL");
    else strcpy(nd_adm_dis_reference_desc, nd_adm_dis_reference.arr);


/* the date line in the report page header is modified */
  for(i=0; i< (66 -(int)((29 + (strlen(nd_to_trn_date_time_desc) + strlen(nd_to_trn_date_time_desc)))/2)); i++)
    spaces[i] = ' ';
  spaces[i] = '\0';
  sprintf(nd_date_line,"%sFOR THE PERIOD FROM : %s  TO : %s",spaces, nd_fr_trn_date_time_desc ,nd_to_trn_date_time_desc);
  print_page_header();
  fprintf(f1,VER);
  fprintf(f1,"\n\n\n\n");
  fprintf(f1,"        ");
  fprintf(f1,"INPUT PARAMETERS :\n");
  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  fprintf(f1,"                ");
  fprintf(f1,"ADMISSION DATE FROM           : %s\n", nd_fr_trn_date_time_desc);
  fprintf(f1,"                ");
  fprintf(f1,"                 TO           : %s\n", nd_to_trn_date_time_desc);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  fprintf(f1,"ADMISSION TYPE FROM           : %s\n", nd_fr_trn_type_desc);
  fprintf(f1,"                ");
  fprintf(f1,"                 TO           : %s\n", nd_to_trn_type_desc);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  fprintf(f1,"WARD CODE FROM                : %s\n", nd_fr_fr_ward_code_desc);
  fprintf(f1,"                ");
  fprintf(f1,"            TO                : %s\n", nd_to_fr_ward_code_desc);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  fprintf(f1,"BED CLASS CODE FROM           : %s\n", nd_fr_fr_bed_class_code_desc);
  fprintf(f1,"                ");
  fprintf(f1,"                 TO           : %s\n", nd_to_fr_bed_class_code_desc);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  fprintf(f1,"DOCTOR ID FROM                : %s\n", nd_fr_fr_physician_id_desc);
  fprintf(f1,"                ");
  fprintf(f1,"            TO                : %s\n", nd_to_fr_physician_id_desc);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  fprintf(f1,"MEDICAL SPLTY GROUP CODE FROM : %s\n", nd_fr_fr_physician_id_desc);
  fprintf(f1,"                ");
  fprintf(f1,"                           TO : %s\n", nd_to_fr_physician_id_desc);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  fprintf(f1,"BILLING GROUP CODE FROM       : %s\n", nd_fr_blng_grp_id_desc);
  fprintf(f1,"                ");
  fprintf(f1,"                           TO : %s\n", nd_to_blng_grp_id_desc);
  fprintf(f1,"\n");

  fprintf(f1,"                ");
  fprintf(f1,"ADMISSION REFERAL SOURCE      : %s\n", nd_adm_dis_reference_desc);
}


/* to print page headers the header details */ 
void print_page_header()
{
 register int i;

 fprintf(f1,"MDL : BL    ");
 fprintf(f1,"                                            ");
 fprintf(f1,"%s", d_acc_entity_name.arr);
 fprintf(f1,"                                       ");
 fprintf(f1,"%s", d_sysdate.arr);
 fprintf(f1,"\n");
 fprintf(f1,"OPR : %s", d_user.arr);
 fprintf(f1,"\n");
 fprintf(f1,"REP : BLRADMBG");
 fprintf(f1,"                                            ");  
 fprintf(f1,"ADMISSION LIST");
 fprintf(f1,"                                                 ");  
 fprintf(f1,"Page : %4d", page_no);
 fprintf(f1,"\n");

 fprintf(f1,"%s", nd_date_line);
 fprintf(f1,"\n");
 fprintf(f1,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  fprintf(f1,"\n");
}

/* to print the last line of the report */
void end_report()
{
  fprintf(f1,"\n\n\n");
  fprintf(f1,"                                                   ");
  fprintf(f1,"** End of Report **");
  fprintf(f1,"");
}

print_rep_head()
{


    line_no += 2;

if(rep_order == '1') {

    fprintf(f1,"BG Customer code & Name     Patient Local   & English Names                 Patient No Adm. No. Doctor Code & Name     Ward Bty Bed No.  Dly Charge Sex Age Time\n");

/*
               "XX XXXXXXXX XXXXXXXXXXXXXXX XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXX 99999999 XXXXXX XXXXXXXXXXXXXXX XXXX XX  XXXXXXXX 999,999.99  X  999 99:99"
*/

}
else {

    fprintf(f1,"Bed No.  Dly Charge BG Customer Code & Name     Patient Local   & English Names                 Patient No Adm. No. Doctor Code & Name     Ward Bty Time\n");

/*
               "XXXXXXXX 999,999.99 XX XXXXXXXX XXXXXXXXXXXXXXX XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXX 99999999 XXXXXX XXXXXXXXXXXXXXX XXXX XX  99:99"
*/

}
    fprintf(f1,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

}

print_rec()
{

if(rep_order == '1') {

/*    fprintf(f1,"%-2s %-8s %-15s %-16s %-30s %-10s %-8s %-6s %-15s %-4s %-2s  %-8s %-10s  %1s  %3d %5s\n",*/
    fprintf(f1,"%-2s %-8s %-15s %-16.16s %-30.30s %-20.20s %-8s %-6s %-15s %-4s %-2s  %-8s   %1s  %3d %5s\n",
	d_blng_grp_id.arr, 
	d_cust_code.arr,
	d_cust_short_name.arr,
    d_short_name_loc_lang.arr, 
	d_short_name.arr, 
    d_patient_id.arr, 
	d_episode_id.arr, 
	d_fr_physician_id.arr, 
	d_phys_short_name.arr,
    d_fr_ward_code.arr, 
	d_fr_bed_type_code.arr, 
	d_fr_bed_num.arr,
/*	d_fr_daily_rate.arr,*/
    d_sex.arr, 
	nd_age_years, 
	d_trn_date_time.arr+11);

	if (strlen(d_short_name1.arr) > 2)
	{
       fprintf(f1,"%44s %s \n"," ", d_short_name1.arr);
	   line_no ++;

	}


/*
               "XX XXXXXXXX XXXXXXXXXXXXXXX XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXX 99999999 XXXXXX XXXXXXXXXXXXXXX XXXX XX  XXXXXXXX 999,999.99  X  999 99:99"
*/
}
else {

/*   fprintf(f1,"%-8s %-10s %-2s %-8s %-15s %-16s %-30s %-10s %-8s %-6s %-15s %-4s %-2s  %5s\n",*/
   fprintf(f1,"%-8s      %-2s %-8s %-15s %-16.16s %-20.20s %-20.20s %-8s %-6s %-15s %-4s %-2s  %5s\n",
	d_fr_bed_num.arr,
	d_blng_grp_id.arr, 
	d_cust_code.arr,
	d_cust_short_name.arr,
        d_short_name_loc_lang.arr, 
	d_short_name.arr, 
        d_patient_id.arr, 
	d_episode_id.arr, 
	d_fr_physician_id.arr, 
	d_phys_short_name.arr,
        d_fr_ward_code.arr, 
	d_fr_bed_type_code.arr, 
	d_trn_date_time.arr+11);
		if (strlen(d_short_name1.arr) > 2 )
	{
       fprintf(f1,"%58s %s \n"," ", d_short_name1.arr);
	   line_no ++;

	}      

/*
               "XXXXXXXX 999,999.99 XX XXXXXXXX XXXXXXXXXXXXXXX XXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXX 99999999 XXXXXX XXXXXXXXXXXXXXX XXXX XX  99:99"
*/

}
    line_no ++;
	
}

fetch_other_dtls()
{
  extern double floor();
  nd_age_years = nd_age_months = nd_age_days = 0;

  /* calculating the age in terms of days, months and days */
  nd_age_years  = (int) floor(nd_trunc_total_months / 12.0);
  nd_age_months = (int) floor(nd_trunc_total_months - (nd_age_years * 12)); 

  if ((nd_age_years == 0) && (nd_age_months == 0)){
  /* if the patient is less than a month old */
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT TRUNC(SYSDATE - TO_DATE(:d_date_of_birth, 'DD/MM/YYYY'))
       INTO :nd_days_old
       FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 26;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TRUNC((SYSDATE-TO_DATE(:b0,'DD/MM/YYYY'))) into :b\
1  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )758;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[0] = (unsigned int  )15;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_days_old;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(float);
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


    nd_age_days = (int) nd_days_old;
   }
   /* if the patient is more than a month old */
   else nd_age_days   = (int) floor((nd_total_months - nd_trunc_total_months) * 31);


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL SELECT SHORT_NAME INTO :d_phys_short_name
	   FROM SY_PHYSICIAN_MAST
	   WHERE PHYSICIAN_ID = :d_fr_physician_id
	   AND    FACILITY_ID  = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 26;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_NAME into :b0  from SY_PHYSICIAN_MAST where (P\
HYSICIAN_ID=:b1 and FACILITY_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )781;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_phys_short_name;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_fr_physician_id;
  sqlstm.sqhstl[1] = (unsigned int  )18;
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



    d_phys_short_name.arr[d_phys_short_name.len] = '\0';

  d_cust_short_name.arr[0]  = '\0';
  d_cust_short_name.len     = 0;

  if (d_cust_code.arr[0]) {
      /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

      /* EXEC SQL SELECT SHORT_NAME
	       INTO   :d_cust_short_name
	       FROM   AR_CUSTOMER
	       WHERE  CUST_CODE = :d_cust_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 26;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select SHORT_NAME into :b0  from AR_CUSTOMER where CUST\
_CODE=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )808;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_cust_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )18;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_cust_code;
      sqlstm.sqhstl[1] = (unsigned int  )11;
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



      d_cust_short_name.arr[d_cust_short_name.len]  = '\0';
  }
return 0;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 26;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )831;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_other_dtls() occured....");
   proc_exit();

}


#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
