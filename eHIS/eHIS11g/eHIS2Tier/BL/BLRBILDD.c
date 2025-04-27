
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRBILDD.PC"
};


static unsigned int sqlctx = 1288466107;


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
            void  *sqhstv[20];
   unsigned int   sqhstl[20];
            int   sqhsts[20];
            void  *sqindv[20];
            int   sqinds[20];
   unsigned int   sqharm[20];
   unsigned int   *sqharc[20];
   unsigned short  sqadto[20];
   unsigned short  sqtdso[20];
} sqlstm = {12,20};

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
"select to_char(EPISODE_ID) ,PATIENT_ID ,BLNG_GRP_ID ,TO_CHAR(DISCHARGE_DATE_\
TIME,'DD/MM/YYYY HH24:MI')  from BL_EPISODE_FIN_DTLS where ((((((EPISODE_TYPE \
in ('I','D') and EPISODE_ID between NVL(:b0,'0') and NVL(:b1,'99999999')) and \
PATIENT_ID between NVL(:b2,'!!!!!!!!!!') and NVL(:b3,'~~~~~~~~~~')) and BLNG_G\
RP_ID=NVL(:b4,BLNG_GRP_ID)) and DISCHARGE_DATE_TIME between to_date((:b5||'00:\
00:00'),'DD/MM/YYYY HH24:MI:SS') and to_date((:b6||'23:59:59'),'DD/MM/YYYY HH2\
4:MI:SS')) and NVL(DISCHARGED_YN,'N')='Y') and OPERATING_FACILITY_ID=:b7) orde\
r by EPISODE_ID            ";

 static const char *sq0007 = 
"select TO_CHAR(ADMISSION_DATE_TIME,'DD/MM/YYYY') ,CUR_WARD_CODE ,CUR_ROOM_NU\
M ,CUR_BED_NUM ,CUR_PHYSICIAN_ID  from IP_EPISODE where (EPISODE_ID=:b0 and FA\
CILITY_ID=:b1)           ";

 static const char *sq0008 = 
"select PRT_GRP_HDR_CODE ,PRT_GRP_LINE_CODE ,TO_CHAR(SERVICE_DATE,'DD/MM/YYYY\
') ,BLNG_SERV_CODE ,NVL(UPD_GROSS_CHARGE_AMT,0) ,NVL(SERV_QTY,0) ,NVL(UPD_DISC\
_AMT,0) ,SUBSTR(SERV_ITEM_CODE,1,10) ,SERV_ITEM_DESC ,PACKAGE_IND  from BL_PAT\
IENT_CHARGES_FOLIO where (((((EPISODE_TYPE in ('I','D') and PATIENT_ID=:b0) an\
d EPISODE_ID=:b1) and NVL(TRX_FINALIZE_IND,'X')='Y') and OPERATING_FACILITY_ID\
=:b2) and (LPAD(PRT_GRP_HDR_CODE,2,' ')||LPAD(PRT_GRP_LINE_CODE,2,' ')) betwee\
n :b3 and :b4) order by PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,SERVICE_DATE,BLNG_S\
ERV_CODE            ";

 static const char *sq0009 = 
"select LONG_DESC  from BL_BLNG_GRP where BLNG_GRP_ID=:b0           ";

 static const char *sq0010 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,SEX ,short_name  from MP_PATIENT_MA\
ST where PATIENT_ID=:b0           ";

 static const char *sq0011 = 
"select FULL_NAME  from SY_PHYSICIAN_MAST where PHYSICIAN_ID=:b0           ";

 static const char *sq0012 = 
"select LONG_DESC ,LOC_LANG_SHORT_DESC  from BL_BLNG_PRT_GRP_HDR where PRT_GR\
P_HDR_CODE=:b0           ";

 static const char *sq0013 = 
"select LONG_DESC ,LOC_LANG_SHORT_DESC  from BL_BLNG_PRT_GRP_LINE where (PRT_\
GRP_HDR_CODE=:b0 and PRT_GRP_LINE_CODE=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,477,0,4,255,0,0,20,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
100,0,0,2,117,0,4,324,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
131,0,0,3,91,0,2,338,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
154,0,0,4,0,0,30,347,0,0,0,0,0,1,0,
169,0,0,0,0,0,27,352,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
200,0,0,6,571,0,9,472,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
247,0,0,7,179,0,9,478,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
270,0,0,8,564,0,9,484,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
305,0,0,7,179,0,9,633,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
328,0,0,7,0,0,13,638,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
363,0,0,14,199,0,4,669,0,0,7,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
406,0,0,6,0,0,13,710,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
437,0,0,8,0,0,13,755,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
3,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,1,0,0,
492,0,0,15,103,0,4,787,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,
523,0,0,16,121,0,4,800,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,
554,0,0,9,67,0,9,838,0,0,1,1,0,1,0,1,9,0,0,
573,0,0,9,0,0,13,845,0,0,1,0,0,1,0,2,9,0,0,
592,0,0,10,110,0,9,858,0,0,1,1,0,1,0,1,9,0,0,
611,0,0,10,0,0,13,873,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
638,0,0,17,535,0,6,889,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
665,0,0,11,74,0,9,925,0,0,1,1,0,1,0,1,9,0,0,
684,0,0,11,0,0,13,934,0,0,1,0,0,1,0,2,9,0,0,
703,0,0,12,101,0,9,954,0,0,1,1,0,1,0,1,9,0,0,
722,0,0,12,0,0,13,959,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
745,0,0,13,130,0,9,981,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
768,0,0,13,0,0,13,986,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRBILL2.PC                                  */
/* AUTHOR                : M.NITIN KUMAR                                */
/* Converted To Windows  : Prasad B G S       4/7/96                    */
/* DATE WRITTEN          : 10-JUL-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*  PARAMETERS           :            -                                 */   
/*                                                                      */
/*  SUBROUTINES          :                                               */
/*                                                                      */
/*                                                                      */
/************************************************************************/


/*   All reference to HK$ change to Dhs
   -  For American Hospital Implementation. -- G. Viswanath/31/7/1996
*/   

#include <stdio.h>   
#include <string.h>
#include <bl.h>

#define INIT_MESG "Report Generation In Progress"
#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define DEST_NAME "blrbildd.lis"

#define HSKIP_10 2
#define HSKIP_11 75
#define HSKIP_12 101
#define HSKIP_13 118

#define VSKIP_1 2
#define VSKIP_2 3
#define VSKIP_3 5

#define MAX_LINES 50

#define LEGEND 1

#define LENGTH_WORDS 65 

/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           hosp_name    [31],
           date_time    [20],
           user_id      [20],
           nd_pgm_date  [35],
		   nd_session_id[16]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;


   /* VARCHAR nd_blng_grp                [3],
		   nd_fm_episode_id           [9],
		   nd_to_episode_id           [9],
		   nd_fm_patient_id           [21],
		   nd_to_patient_id           [21],
		   nd_visit_id                [5],
           nd_fm_date                 [11],
           nd_to_date                 [11],
		   prt_grp_fm                 [3],
		   prt_line_fm                [3],
		   prt_grp_to                 [3],
		   prt_line_to                [3],
		   nd_operating_facility_id	  [3],
		   prt_grp_line_fm            [5],
		   prt_grp_line_to			  [5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_blng_grp;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_episode_id;

struct { unsigned short len; unsigned char arr[9]; } nd_to_episode_id;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_id;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[3]; } prt_grp_fm;

struct { unsigned short len; unsigned char arr[3]; } prt_line_fm;

struct { unsigned short len; unsigned char arr[3]; } prt_grp_to;

struct { unsigned short len; unsigned char arr[3]; } prt_line_to;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[5]; } prt_grp_line_fm;

struct { unsigned short len; unsigned char arr[5]; } prt_grp_line_to;


   char    nd_episode_type,
		   nd_rep_opt,
		   explode_pkg,
		   item_print_yn,
		   d_misc_serv_yn,
		   d_package_ind;

   /* VARCHAR d_doc_type_code            [7],
		   d_doc_date                 [11], 
		   d_admission_date           [11],
		   d_ward_code                [5],
		   d_room_num                 [5],
		   d_bed_num                  [9],
		   d_physician_id             [16],
		   d_physician_name           [31],
		   d_blng_grp_id              [3],
		   d_prt_grp_hdr_code         [3],
		   d_prt_grp_line_code        [3],
		   d_blng_grp_desc            [31],
		   d_patient_id               [21],
		   d_patient_short_name       [61],
               d_short_name_full          [61],
		   d_patient_short_name1      [61],
		   d_short_name_loc_lang      [61],
		   d_sex                      [2],
		   d_disch_date_time          [17],
		   d_hdr_long_desc            [61],
		   d_hdr_loc_lang_short_desc  [17],
		   d_line_long_desc           [61],
		   d_line_loc_lang_short_desc [17],
		   d_doc_num_prt              [9],
		   d_episode_id               [9],
		   d_prv_doc_type_code        [7],
		   d_prv_doc_num              [9],
		   d_prv_doc_date             [11],
		   d_bill_fm_date             [11],
		   d_bill_to_date             [11],
		   d_last_doc_type_code       [7],
		   d_last_doc_num             [9],
		   d_last_doc_date            [11],
		   d_pkg_serv_code            [11],
           d_pkg_serv_desc            [41],
           d_pkg_serv_desc_loc_lang   [17],
		   d_blng_serv_code           [11],
		   d_blng_serv_desc           [41],
		   d_serv_item_desc           [41],
		   d_serv_item_code           [11],
		   d_blng_serv_desc_loc_lang  [16],
		   d_service_date             [11],
		   d_clinic_code              [5],
		   sub_cur					  [10],
		   currency					  [10],
		   d_visit_date_time          [17]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_admission_date;

struct { unsigned short len; unsigned char arr[5]; } d_ward_code;

struct { unsigned short len; unsigned char arr[5]; } d_room_num;

struct { unsigned short len; unsigned char arr[9]; } d_bed_num;

struct { unsigned short len; unsigned char arr[16]; } d_physician_id;

struct { unsigned short len; unsigned char arr[31]; } d_physician_name;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[31]; } d_blng_grp_desc;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } d_patient_short_name1;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_loc_lang;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[17]; } d_disch_date_time;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_long_desc;

struct { unsigned short len; unsigned char arr[17]; } d_hdr_loc_lang_short_desc;

struct { unsigned short len; unsigned char arr[61]; } d_line_long_desc;

struct { unsigned short len; unsigned char arr[17]; } d_line_loc_lang_short_desc;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num_prt;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[7]; } d_prv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_prv_doc_num;

struct { unsigned short len; unsigned char arr[11]; } d_prv_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_bill_fm_date;

struct { unsigned short len; unsigned char arr[11]; } d_bill_to_date;

struct { unsigned short len; unsigned char arr[7]; } d_last_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_last_doc_num;

struct { unsigned short len; unsigned char arr[11]; } d_last_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_pkg_serv_code;

struct { unsigned short len; unsigned char arr[41]; } d_pkg_serv_desc;

struct { unsigned short len; unsigned char arr[17]; } d_pkg_serv_desc_loc_lang;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } d_blng_serv_desc;

struct { unsigned short len; unsigned char arr[41]; } d_serv_item_desc;

struct { unsigned short len; unsigned char arr[11]; } d_serv_item_code;

struct { unsigned short len; unsigned char arr[16]; } d_blng_serv_desc_loc_lang;

struct { unsigned short len; unsigned char arr[11]; } d_service_date;

struct { unsigned short len; unsigned char arr[5]; } d_clinic_code;

struct { unsigned short len; unsigned char arr[10]; } sub_cur;

struct { unsigned short len; unsigned char arr[10]; } currency;

struct { unsigned short len; unsigned char arr[17]; } d_visit_date_time;


char       d_package_ind;

int        d_num_of_deps_paid,
           d_qty;

long       d_doc_num;

double     d_serv_disc_amt,
		   d_man_disc_amt,
		   d_overall_disc_amt,
		   d_prepay_adj_amt,
		   d_deposit_adj_amt,
		   d_bill_paid_amt,
		   d_gross_amt,
		   d_prv_amt,
		   d_prv_outst_amt,
		   d_tot_dep_paid_amt;

 char filename[150];

/* EXEC SQL END DECLARE SECTION; */ 

 

// EXEC ORACLE OPTION(HOLD_CURSOR = YES);
// EXEC ORACLE OPTION(REBIND = NO);

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

char g_prt_grp_hdr_code[3];
char g_prt_grp_line_code[3];

int  g_first_break ;
int  g_print_line_desc;
int g_print_subtot;
int lno = 0, pno = 0;

double g_cum_amt = 0,g_sub_tot = 0;
double tot_disc_amt = 0;

FILE *fp;

void proc_main(argc,argv)
char *argv[];

int argc;
{
   if (argc < 4)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"BLRBILL2");

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   }

   set_meduser_role();

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);


   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   nd_blng_grp.arr[0]      = '\0';
   nd_fm_episode_id.arr[0] = '\0';
   nd_to_episode_id.arr[0] = '\0';
   nd_fm_patient_id.arr[0] = '\0';
   nd_to_patient_id.arr[0] = '\0';
   nd_fm_date.arr[0]       = '\0';
   nd_to_date.arr[0]       = '\0';
   prt_grp_fm.arr[0]       = '\0';
   prt_line_fm.arr[0]      = '\0';
   prt_grp_to.arr[0]       = '\0';
   prt_line_to.arr[0]      = '\0';
   d_doc_date.arr[0]       = '\0';

   prt_grp_line_fm.arr[0]  = '\0';
   prt_grp_line_to.arr[0]  = '\0';	

   nd_blng_grp.len         = 0;
   nd_fm_episode_id.len    = 0;
   nd_to_episode_id.len    = 0;
   nd_fm_patient_id.len    = 0;
   nd_to_patient_id.len    = 0;
   nd_fm_date.len          = 0;
   nd_to_date.len          = 0;
   prt_grp_fm.len          = 0;
   prt_line_fm.len         = 0;
   prt_grp_to.len          = 0;
   prt_line_to.len         = 0;
   d_doc_date.len          = 0;

   prt_grp_line_fm.len     = 0;
   prt_grp_line_to.len     = 0;

   nd_episode_type = '\0';

   nd_rep_opt      = '\0';
   explode_pkg     = '\0';
   item_print_yn   = '\0';

   /* EXEC SQL SELECT 
		   OPERATING_FACILITY_ID,
		   PARAM1,PARAM2,
		   PARAM3,PARAM4,PARAM5,PARAM6,
		   PARAM7,PARAM8,PARAM9,
		   PARAM10,PARAM11,PARAM12,PARAM13,PARAM14,
		   TO_CHAR(SYSDATE,'DD/MM/YYYY'),
		   LPAD(nvl(PARAM8, '!!'), 2, ' ')||LPAD(nvl(PARAM9, '!!'), '2', ' '),
		   LPAD(nvl(PARAM10, '~~'), 2, ' ')||LPAD(nvl(PARAM11, '~~'), '2', ' ')
              INTO :nd_operating_facility_id,
				   :nd_blng_grp,
                   :nd_fm_episode_id,
                   :nd_to_episode_id,
                   :nd_fm_patient_id,
                   :nd_to_patient_id,
                   :nd_fm_date,
                   :nd_to_date,
                   :prt_grp_fm,
                   :prt_line_fm,
                   :prt_grp_to,
                   :prt_line_to,
		   :nd_rep_opt,
                   :explode_pkg,
                   :item_print_yn,
                   :d_doc_date,
				   :prt_grp_line_fm,
				   :prt_grp_line_to
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'BLRBILL2'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13\
 ,PARAM14 ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,(LPAD(nvl(PARAM8,'!!'),2,' ')||LPAD(\
nvl(PARAM9,'!!'),'2',' ')) ,(LPAD(nvl(PARAM10,'~~'),2,' ')||LPAD(nvl(PARAM11,'\
~~'),'2',' ')) into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b1\
3,:b14,:b15,:b16,:b17  from SY_PROG_PARAM where ((PGM_ID='BLRBILL2' and SESSIO\
N_ID=:b18) and PGM_DATE=:b19)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_episode_id;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_patient_id;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_patient_id;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&prt_grp_fm;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&prt_line_fm;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&prt_grp_to;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&prt_line_to;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_rep_opt;
   sqlstm.sqhstl[12] = (unsigned int  )1;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&explode_pkg;
   sqlstm.sqhstl[13] = (unsigned int  )1;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&item_print_yn;
   sqlstm.sqhstl[14] = (unsigned int  )1;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_doc_date;
   sqlstm.sqhstl[15] = (unsigned int  )13;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&prt_grp_line_fm;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&prt_grp_line_to;
   sqlstm.sqhstl[17] = (unsigned int  )7;
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
   sqlstm.sqhstl[19] = (unsigned int  )37;
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

	

   	

   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_blng_grp.arr[nd_blng_grp.len]              = '\0';
   nd_fm_episode_id.arr[nd_fm_episode_id.len]    = '\0';
   nd_to_episode_id.arr[nd_to_episode_id.len]    = '\0';
   nd_fm_patient_id.arr[nd_fm_patient_id.len]    = '\0';
   nd_to_patient_id.arr[nd_to_patient_id.len]    = '\0';
   nd_fm_date.arr[nd_fm_date.len]  = '\0';
   nd_to_date.arr[nd_to_date.len]  = '\0';
   prt_grp_fm.arr[prt_grp_fm.len]  = '\0';
   prt_line_fm.arr[prt_line_fm.len]  = '\0';
   prt_grp_to.arr[prt_grp_to.len]  = '\0';
   prt_line_to.arr[prt_line_to.len]  = '\0';
   d_doc_date.arr[d_doc_date.len]  = '\0';

   prt_grp_line_fm.arr[prt_grp_line_fm.len] = '\0';
   prt_grp_line_to.arr[prt_grp_line_to.len] = '\0';

   strcpy(g_facility_id, nd_operating_facility_id.arr);

   nd_episode_type = 'I';

   start_prog_msg();

   hosp_name.arr[0]  = '\0';
   currency.arr[0]	 = '\0';
   sub_cur.arr[0]	 = '\0';
   hosp_name.len     = 0;
   currency.len		 = 0;
   sub_cur.len		 = 0;

   /* EXEC SQL SELECT ACC_ENTITY_NAME, BASE_CURRENCY, BASE_CURRENCY_DEC
	    INTO   :hosp_name, :currency, :sub_cur
	    FROM   SY_ACC_ENTITY
		WHERE  ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,BASE_CURRENCY ,BASE_CURRENCY_DEC i\
nto :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )100;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&hosp_name;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&currency;
   sqlstm.sqhstl[1] = (unsigned int  )12;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&sub_cur;
   sqlstm.sqhstl[2] = (unsigned int  )12;
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
}



    if(OERROR)
	err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]  = '\0';
   currency.arr[currency.len] = '\0';
   sub_cur.arr[sub_cur.len] = '\0';

   prt_bill();

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
                  WHERE PGM_ID     = 'BLRBILL2'
                    AND SESSION_ID = :nd_session_id
                    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRBILL2' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )131;
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
   sqlstm.sqhstl[1] = (unsigned int  )37;
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
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");


   end_prog_msg();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )154;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )169;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )134;
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



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

declare_cursors()
{

    /* EXEC SQL DECLARE BL_EPISODE_CUR CURSOR FOR
	      SELECT to_char(EPISODE_ID),	//3/8/2004
		     PATIENT_ID,
		     BLNG_GRP_ID,
		     TO_CHAR(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI')
		FROM BL_EPISODE_FIN_DTLS
	       WHERE EPISODE_TYPE in ('I','D') //EPNH 04012005 :nd_episode_type
	         AND EPISODE_ID BETWEEN
		         NVL(:nd_fm_episode_id,'0') AND
		         NVL(:nd_to_episode_id,'99999999')
	         AND PATIENT_ID BETWEEN
		         NVL(:nd_fm_patient_id,'!!!!!!!!!!') AND
			 NVL(:nd_to_patient_id,'~~~~~~~~~~')
	         AND BLNG_GRP_ID = NVL(:nd_blng_grp,BLNG_GRP_ID)
			 AND DISCHARGE_DATE_TIME between to_date(:nd_fm_date||'00:00:00', 'DD/MM/YYYY HH24:MI:SS')		//added this condition 3/8/2004
									 AND     to_date(:nd_to_date||'23:59:59', 'DD/MM/YYYY HH24:MI:SS')			
			 AND NVL(DISCHARGED_YN, 'N') = 'Y'
	        /oAND DISCHARGE_DATE_TIME >=
		     TO_DATE(NVL(:nd_fm_date,'01/01/1000'),'DD/MM/YYYY')     
			 AND DISCHARGE_DATE_TIME <
		         TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')+1o/
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
	       ORDER BY EPISODE_ID; */ 


    /* EXEC SQL DECLARE IP_EPISODE_CUR CURSOR FOR
             SELECT  TO_CHAR(ADMISSION_DATE_TIME,'DD/MM/YYYY'),
                     CUR_WARD_CODE,
                     CUR_ROOM_NUM,
                     CUR_BED_NUM,
                     CUR_PHYSICIAN_ID
	     FROM    IP_EPISODE
	     WHERE   EPISODE_ID = :d_episode_id
		 AND     FACILITY_ID = :nd_operating_facility_id; */ 


    /* EXEC SQL DECLARE BL_PAT_FOLIO_CUR CURSOR FOR
             SELECT  PRT_GRP_HDR_CODE,
                     PRT_GRP_LINE_CODE,
                     TO_CHAR(SERVICE_DATE,'DD/MM/YYYY'),
                     BLNG_SERV_CODE,
                     NVL(UPD_GROSS_CHARGE_AMT,0),
                     NVL(SERV_QTY,0),
                     NVL(UPD_DISC_AMT,0),
                     SUBSTR(SERV_ITEM_CODE,1,10),
                     SERV_ITEM_DESC,
                     PACKAGE_IND
             FROM    BL_PATIENT_CHARGES_FOLIO
             WHERE   EPISODE_TYPE in ('I','D') //EPNH 04012005  :nd_episode_type
	     AND     PATIENT_ID   = :d_patient_id
	     AND     EPISODE_ID   = :d_episode_id
		 AND     NVL(TRX_FINALIZE_IND,'X') = 'Y'
		 AND	 OPERATING_FACILITY_ID = :nd_operating_facility_id
	     AND     LPAD(PRT_GRP_HDR_CODE,2,' ')||LPAD(PRT_GRP_LINE_CODE, 2, ' ')
		           BETWEEN 
				   :prt_grp_line_fm AND :prt_grp_line_to
		 /oAND     ( (:explode_pkg = 'Y' AND NVL(PACKAGE_TRX_IND,'X')  = 'N')
	                                     OR        
		       (:explode_pkg = 'N' AND 
			   ( NVL(PACKAGE_IND,'X')      = 'S' OR
			    ( NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND
			       NVL(PACKAGE_IND,'X')      = 'P'
			     )
			   )
		       )
		     )o/
             ORDER BY PRT_GRP_HDR_CODE, PRT_GRP_LINE_CODE,SERVICE_DATE,
		   BLNG_SERV_CODE; */ 


    /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
	     SELECT  LONG_DESC
	     FROM    BL_BLNG_GRP
	     WHERE   BLNG_GRP_ID = :d_blng_grp_id; */ 


    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
	     SELECT  /osubstr(SHORT_NAME,1,30),
		         decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,o/
				 SUBSTR(SHORT_NAME_LOC_LANG,1,16),
				 SEX ,short_name
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :d_patient_id; */ 


    /* EXEC SQL DECLARE SY_PHYSICIAN_MAST_CUR CURSOR FOR
	     SELECT  FULL_NAME
	     FROM    SY_PHYSICIAN_MAST
	     WHERE   PHYSICIAN_ID = :d_physician_id; */ 


    /* EXEC SQL DECLARE PRT_GRP_HDR_CUR CURSOR FOR
	     SELECT  LONG_DESC,
		     LOC_LANG_SHORT_DESC
	     FROM   BL_BLNG_PRT_GRP_HDR
	     WHERE  PRT_GRP_HDR_CODE = :d_prt_grp_hdr_code; */ 


    /* EXEC SQL DECLARE PRT_GRP_LINE_CUR CURSOR FOR
	     SELECT  LONG_DESC,
		     LOC_LANG_SHORT_DESC
	     FROM   BL_BLNG_PRT_GRP_LINE
	     WHERE  PRT_GRP_HDR_CODE  = :d_prt_grp_hdr_code
	     AND    PRT_GRP_LINE_CODE = :d_prt_grp_line_code; */ 


}


prt_bill()
{
    int print_header = 1;

    open_files();
	
    declare_cursors();
	

    /* EXEC SQL OPEN BL_EPISODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )200;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_episode_id;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_blng_grp;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[6] = (unsigned int  )13;
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
}


    if(OERROR)
	err_mesg("OPEN failed on cursor BL_EPISODE_CUR",0,"");

    while(fetch_episode()) {

        /* EXEC SQL OPEN IP_EPISODE_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 20;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0007;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )247;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqcmod = (unsigned int )0;
        sqlstm.sqhstv[0] = (         void  *)&d_episode_id;
        sqlstm.sqhstl[0] = (unsigned int  )11;
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


    
        if(OERROR)
	    err_mesg("OPEN failed on cursor IP_EPISODE_CUR",0,"");

	
		/* EXEC SQL OPEN BL_PAT_FOLIO_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0008;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )270;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[1] = (unsigned int  )11;
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
  sqlstm.sqhstv[3] = (         void  *)&prt_grp_line_fm;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&prt_grp_line_to;
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
}



        if(OERROR)
            err_mesg("OPEN failed on cursor BL_PAT_FOLIO_CUR",0,"");

        fetch_ip_episode();
	
		pno = 1;
		g_cum_amt = 0;
		tot_disc_amt = 0;

		fetch_blng_grp_desc();
		fetch_patient_name();
		fetch_physician_name();
	

		//	print_page_head();

		g_prt_grp_line_code[0] = '\0';
		g_first_break  = 1;
		g_print_subtot = 0;
		print_header   = 1;

		g_prt_grp_hdr_code[0] = '\0'; //deepali

		while(fetch_folio()) {

	    if (print_header == 1) {

	        print_page_head();
	        print_header = 0;
	     }    
	
		if(strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr)) 
		{
			print_break_hdr();//deepali
			print_break_line(); 
		}

	    /*if(strcmp(g_prt_grp_line_code,d_prt_grp_line_code.arr)) 
		print_break_line(); */

		/*if(strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr) &&
		   strcmp(g_prt_grp_line_code,d_prt_grp_line_code.arr))
		   {
              print_break_hdr();
			  print_break_line();
		   }

		else
		{
		 if ((strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr)==0) &&
		     (strcmp(g_prt_grp_line_code,d_prt_grp_line_code.arr)!=0))
		   {
              //print_break_hdr();
			  print_break_line();
		   }
		 else 
		   if ((strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr)!=0) &&
		       (strcmp(g_prt_grp_line_code,d_prt_grp_line_code.arr)==0))
		   {
              print_break_hdr();
			  print_break_line();
		   }

		
		}*/

			
            if(g_print_subtot) {
                fprintf(fp,"\n");
                lno++;
            }
		

	    print_line();
		
	    strcpy(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr);
	    strcpy(g_prt_grp_line_code,d_prt_grp_line_code.arr); 

	    g_cum_amt += d_gross_amt;
	    g_sub_tot += d_gross_amt;
	    tot_disc_amt += d_serv_disc_amt;
	    g_print_subtot = 1;

	} /* end of while fetch_folio() */

	if(g_print_subtot) {
	    

		print_subtot();

    	print_balance_due();

      }
	  
        fflush(fp);


    } /* end of while fetch_episode()  */

	

    fclose(fp);
    return 1;

}

open_files()
{
  

   strcpy(filename,WORKING_DIR);
   strcpy(filename,"blrbildd.lis");

    if( (fp=fopen(filename,"w")) == NULL)
	 {
        disp_message(ERR_MESG,"Error in opening output file...BLRUNBRF.LIS");
	proc_exit();
     }

   /* if ((fp = fopen(DEST_NAME,"w")) == NULL)
   {
        err_mesg("\nError while opening File blrbildd.lis\n",0,"");
        proc_exit();
   } */

}

fetch_ip_episode()
{

    if(nd_episode_type == 'R')
	return 1;
    //EPNH 04012005
    if(nd_episode_type == 'I' || nd_episode_type == 'D' ) {

        d_admission_date.arr[0]    = '\0';
        d_ward_code.arr[0]         = '\0';
        d_room_num.arr[0]          = '\0';
        d_bed_num.arr[0]           = '\0';
        d_physician_id.arr[0]      = '\0';
    
        d_admission_date.len       = 0;
        d_ward_code.len            = 0;
        d_room_num.len             = 0;
        d_bed_num.len              = 0;
        d_physician_id.len         = 0;

        /* EXEC SQL OPEN IP_EPISODE_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 20;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0007;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )305;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqcmod = (unsigned int )0;
        sqlstm.sqhstv[0] = (         void  *)&d_episode_id;
        sqlstm.sqhstl[0] = (unsigned int  )11;
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


    
        if(OERROR)
	    err_mesg("OPEN failed on cursor IP_EPISODE_CUR",0,"");
    
        /* EXEC SQL FETCH IP_EPISODE_CUR INTO 
                       :d_admission_date,
                       :d_ward_code,
                       :d_room_num,
                       :d_bed_num,
                       :d_physician_id; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 20;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )328;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqfoff = (           int )0;
        sqlstm.sqfmod = (unsigned int )2;
        sqlstm.sqhstv[0] = (         void  *)&d_admission_date;
        sqlstm.sqhstl[0] = (unsigned int  )13;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_ward_code;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_room_num;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_bed_num;
        sqlstm.sqhstl[3] = (unsigned int  )11;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_physician_id;
        sqlstm.sqhstl[4] = (unsigned int  )18;
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


    
        if(OERROR)
	    err_mesg("FETCH failed on cursor IP_EPISODE_CUR",0,"");
    
        if(NO_DATA_FOUND)
	    return 0;
    
        d_admission_date.arr[d_admission_date.len]            = '\0';
        d_ward_code.arr[d_ward_code.len]              = '\0';
        d_room_num.arr[d_room_num.len]                = '\0';
        d_bed_num.arr[d_bed_num.len]                  = '\0';
        d_physician_id.arr[d_physician_id.len]        = '\0';
    
        return 1;
    }
    else if(nd_episode_type == 'O' || nd_episode_type == 'E' ) {

        d_clinic_code.arr[0]       = '\0';
        d_physician_id.arr[0]      = '\0';
        d_visit_date_time.arr[0]   = '\0';

        d_clinic_code.len          = 0;
        d_physician_id.len         = 0;
        d_visit_date_time.len      = 0;

	/* EXEC SQL SELECT CLINIC_CODE,
			PHYSICIAN_ID,
			TO_CHAR(VISIT_REGN_DATE_TIME,'DD/MM/YYYY HH24:MI')
		   INTO :d_clinic_code,
			:d_physician_id,
			:d_visit_date_time
		   FROM OP_VISIT
		  WHERE EPISODE_ID = :d_episode_id
		    AND PATIENT_ID = :d_patient_id
		    AND VISIT_ID   = :nd_visit_id
			AND FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CLINIC_CODE ,PHYSICIAN_ID ,TO_CHAR(VISIT_REGN_DATE_TI\
ME,'DD/MM/YYYY HH24:MI') into :b0,:b1,:b2  from OP_VISIT where (((EPISODE_ID=:\
b3 and PATIENT_ID=:b4) and VISIT_ID=:b5) and FACILITY_ID=:b6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )363;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_clinic_code;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_physician_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_visit_date_time;
 sqlstm.sqhstl[2] = (unsigned int  )19;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_visit_id;
 sqlstm.sqhstl[5] = (unsigned int  )7;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
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
	    err_mesg("FETCH failed on cursor IP_EPISODE_CUR",0,"");
    
        if(NO_DATA_FOUND)
	    return 0;

        d_clinic_code.arr[d_clinic_code.len]           = '\0';
        d_physician_id.arr[d_physician_id.len]         = '\0';
        d_visit_date_time.arr[d_visit_date_time.len]   = '\0';

	return 1;

    }

}

fetch_episode()
{

    d_episode_id.arr[0]        = '\0';
    d_patient_id.arr[0]        = '\0';
    d_blng_grp_id.arr[0]       = '\0';
    d_disch_date_time.arr[0]   = '\0';

    d_episode_id.len           = 0;
    d_patient_id.len           = 0;
    d_blng_grp_id.len          = 0;
    d_disch_date_time.len      = 0;

    /* EXEC SQL FETCH BL_EPISODE_CUR
	     INTO  :d_episode_id,
                   :d_patient_id,
					:d_blng_grp_id,
                   :d_disch_date_time; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )406;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[0] = (unsigned int  )11;
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
    sqlstm.sqhstv[2] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_disch_date_time;
    sqlstm.sqhstl[3] = (unsigned int  )19;
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




    if(OERROR)
	err_mesg("FETCH failed on cursor BL_PAT_FOLIO_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_episode_id.arr[d_episode_id.len]               = '\0';
    d_patient_id.arr[d_patient_id.len]               = '\0';
    d_blng_grp_id.arr[d_blng_grp_id.len]             = '\0';
    d_disch_date_time.arr[d_disch_date_time.len]     = '\0';

    return 1;

}

fetch_folio()
{

    d_prt_grp_hdr_code.arr[0]  = '\0';
    d_prt_grp_line_code.arr[0] = '\0';
    d_blng_serv_code.arr[0]    = '\0';
    d_serv_item_desc.arr[0]    = '\0';
    d_serv_item_code.arr[0]    = '\0';
    d_service_date.arr[0]      = '\0';

    d_prt_grp_hdr_code.len     = 0;
    d_prt_grp_line_code.len    = 0;
    d_blng_serv_code.len       = 0;
    d_serv_item_code.len       = 0;
    d_serv_item_desc.len       = 0;
    d_service_date.len         = 0;

    d_gross_amt     = 0;
    d_qty           = 0;
    d_serv_disc_amt = 0;

    d_package_ind   = '\0';

    /* EXEC SQL FETCH BL_PAT_FOLIO_CUR
	     INTO  :d_prt_grp_hdr_code,
		   :d_prt_grp_line_code,
		   :d_service_date,
		   :d_blng_serv_code,
		   :d_gross_amt,
		   :d_qty,
		   :d_serv_disc_amt,
                   :d_serv_item_code,
                   :d_serv_item_desc,
		   :d_package_ind; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )437;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_service_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_gross_amt;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_qty;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_serv_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_serv_item_code;
    sqlstm.sqhstl[7] = (unsigned int  )13;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_serv_item_desc;
    sqlstm.sqhstl[8] = (unsigned int  )43;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_package_ind;
    sqlstm.sqhstl[9] = (unsigned int  )1;
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
}



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_PAT_FOLIO_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]   = '\0';
    d_prt_grp_line_code.arr[d_prt_grp_line_code.len] = '\0';
    d_service_date.arr[d_service_date.len]           = '\0';
    d_blng_serv_code.arr[d_blng_serv_code.len]       = '\0';
    d_serv_item_code.arr[d_serv_item_code.len]       = '\0';
    d_serv_item_desc.arr[d_serv_item_desc.len]       = '\0';

    d_blng_serv_desc.arr[0]  = '\0';
    d_blng_serv_desc_loc_lang.arr[0]  = '\0';

    d_blng_serv_desc.len     = 0;
    d_blng_serv_desc_loc_lang.len     = 0;

    if(d_package_ind == 'P'&& explode_pkg == 'N') {
        /* EXEC SQL SELECT LONG_DESC,
		        LOC_LANG_SHORT_DESC,
		        'N'
	         INTO   :d_blng_serv_desc,
                        :d_blng_serv_desc_loc_lang,
		        :d_misc_serv_yn
	         FROM   BL_PACKAGE_HDR
	         WHERE  PACKAGE_CODE = :d_blng_serv_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 20;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select LONG_DESC ,LOC_LANG_SHORT_DESC ,'N' into :b0,:\
b1,:b2  from BL_PACKAGE_HDR where PACKAGE_CODE=:b3";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )492;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
        sqlstm.sqhstl[0] = (unsigned int  )43;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_desc_loc_lang;
        sqlstm.sqhstl[1] = (unsigned int  )18;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_misc_serv_yn;
        sqlstm.sqhstl[2] = (unsigned int  )1;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
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



        if(OERROR)
	    err_mesg("SELECT failed on table BL_PACKAGE_HDR",0,"");
    }
    else {
        /* EXEC SQL SELECT LONG_DESC,
		        LOC_LANG_SHORT_DESC,
		        NVL(MISC_SERV_YN,'N')
	         INTO   :d_blng_serv_desc,
                        :d_blng_serv_desc_loc_lang,
		        :d_misc_serv_yn
	         FROM   BL_BLNG_SERV
	         WHERE  BLNG_SERV_CODE = :d_blng_serv_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 20;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select LONG_DESC ,LOC_LANG_SHORT_DESC ,NVL(MISC_SERV_\
YN,'N') into :b0,:b1,:b2  from BL_BLNG_SERV where BLNG_SERV_CODE=:b3";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )523;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
        sqlstm.sqhstl[0] = (unsigned int  )43;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_desc_loc_lang;
        sqlstm.sqhstl[1] = (unsigned int  )18;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_misc_serv_yn;
        sqlstm.sqhstl[2] = (unsigned int  )1;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
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



        if(OERROR)
	    err_mesg("SELECT failed on table BL_BLNG_SERV",0,"");
    }

    d_blng_serv_desc.arr[d_blng_serv_desc.len]  = '\0';
    d_blng_serv_desc_loc_lang.arr[d_blng_serv_desc_loc_lang.len]  = '\0';

    if(d_misc_serv_yn == 'Y') {
	strcpy(d_blng_serv_desc.arr, d_serv_item_desc.arr);
	d_blng_serv_desc_loc_lang.arr[0] = '\0';
    }

    if(item_print_yn == 'Y')
    {
      if(d_serv_item_code.arr[0]) 
      {
	strcpy(d_blng_serv_code.arr, d_serv_item_code.arr);
	strcpy(d_blng_serv_desc.arr, d_serv_item_desc.arr);
	d_blng_serv_desc_loc_lang.arr[0] = '\0';
      }
    }

    return 1;

}

fetch_blng_grp_desc()
{

    /* EXEC SQL OPEN BL_BLNG_GRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )554;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
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
}



    if(OERROR)
	err_mesg("OPEN failed on cursor BL_BLNG_GRP_CUR",0,"");

    d_blng_grp_desc.arr[0] = '\0';

    /* EXEC SQL FETCH BL_BLNG_GRP_CUR INTO
		   :d_blng_grp_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )573;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_desc;
    sqlstm.sqhstl[0] = (unsigned int  )33;
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
	err_mesg("FETCH failed on cursor BL_BLNG_GRP_CUR",0,"");

    d_blng_grp_desc.arr[d_blng_grp_desc.len] = '\0';

}

fetch_patient_name()
{

    /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )592;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

    d_patient_short_name.arr[0]   = '\0';
	d_patient_short_name1.arr[0]   = '\0';
    d_short_name_loc_lang.arr[0]  = '\0';
    d_sex.arr[0]                  = '\0';

    d_patient_short_name.len    = 0;
	d_patient_short_name1.len    = 0;  
    d_short_name_loc_lang.len   = 0;
    d_sex.len                   = 0;   
   
    /* EXEC SQL FETCH MP_PATIENT_MAST_CUR
	     INTO /o:d_patient_short_name,
			   :d_patient_short_name1,o/
               :d_short_name_loc_lang,
			   :d_sex,
               :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )611;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_short_name_loc_lang;
    sqlstm.sqhstl[0] = (unsigned int  )63;
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
    sqlstm.sqhstv[2] = (         void  *)&d_short_name_full;
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
}



    if(OERROR)
	err_mesg("FETCH failed on cursor MP_PATIENT_MAST_CUR",0,"");

    d_patient_short_name.arr[d_patient_short_name.len]    = '\0';
	d_patient_short_name1.arr[d_patient_short_name1.len]    = '\0';
    d_short_name_loc_lang.arr[d_short_name_loc_lang.len]  = '\0';
    d_sex.arr[d_sex.len]                                  = '\0';
    d_short_name_full.arr[d_short_name_full.len]          = '\0';

 	 /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_short_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :d_patient_short_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_short_name1    := :d_patient_short_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 )\
 ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , s\
tr2 ) ; IF str2 IS NOT NULL THEN :d_patient_short_name := str2 ; END IF ; blco\
mmon . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF st\
r2 IS NOT NULL THEN :d_patient_short_name1 := str2 ; END IF ; blcommon . split\
_words ( :d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NU\
LL THEN :d_patient_short_name1 := :d_patient_short_name1 || str2 ; end if ; EN\
D ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )638;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_patient_short_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_patient_short_name1;
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
}


       d_patient_short_name.arr[d_patient_short_name.len]  = '\0';
       d_patient_short_name1.arr[d_patient_short_name1.len]  = '\0';


}

fetch_physician_name()
{

    /* EXEC SQL OPEN SY_PHYSICIAN_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )665;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_physician_id;
    sqlstm.sqhstl[0] = (unsigned int  )18;
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
	err_mesg("OPEN failed on cursor SY_PHYSICIAN_MAST_CUR",0,"");

    d_physician_name.arr[0] = '\0';

    d_physician_name.len    = 0;

    /* EXEC SQL FETCH SY_PHYSICIAN_MAST_CUR
	     INTO  :d_physician_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )684;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_physician_name;
    sqlstm.sqhstl[0] = (unsigned int  )33;
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
	err_mesg("FETCH failed on cursor SY_PHYSICIAN_MAST_CUR",0,"");

    d_physician_name.arr[d_physician_name.len] = '\0';

}


fetch_prt_grp_hdr_desc()
{

    d_hdr_long_desc.arr[0]           = '\0';
    d_hdr_loc_lang_short_desc.arr[0] = '\0';

    d_hdr_long_desc.len              = 0;
    d_hdr_loc_lang_short_desc.len    = 0;

    /* EXEC SQL OPEN PRT_GRP_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )703;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
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
}



    if(OERROR)
	err_mesg("OPEN failed on cursor PRT_GRP_HDR_CUR",0,"");

    /* EXEC SQL FETCH PRT_GRP_HDR_CUR INTO
	     :d_hdr_long_desc,
	     :d_hdr_loc_lang_short_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )722;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_hdr_long_desc;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_hdr_loc_lang_short_desc;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor PRT_GRP_HDR_CUR",0,"");

    d_hdr_long_desc.arr[d_hdr_long_desc.len]                     = '\0';
    d_hdr_loc_lang_short_desc.arr[d_hdr_loc_lang_short_desc.len] = '\0';


}

fetch_prt_grp_line_desc()
{

    d_line_long_desc.arr[0]           = '\0';
    d_line_loc_lang_short_desc.arr[0] = '\0';

    d_line_long_desc.len              = 0;
    d_line_loc_lang_short_desc.len    = 0;

    /* EXEC SQL OPEN PRT_GRP_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0013;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )745;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor PRT_GRP_LINE_CUR",0,"");

    /* EXEC SQL FETCH PRT_GRP_LINE_CUR INTO
	     :d_line_long_desc,
	     :d_line_loc_lang_short_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )768;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_line_long_desc;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_line_loc_lang_short_desc;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor PRT_GRP_LINE_CUR",0,"");

    d_line_long_desc.arr[d_line_long_desc.len]                     = '\0';
    d_line_loc_lang_short_desc.arr[d_line_loc_lang_short_desc.len] = '\0';


}

print_page_head()
{
    int i;
    static int g_first = 1;

    if(!g_first) 
	fprintf(fp,"\f");

    g_first = 0;

    for(i = 0; i < VSKIP_1; i++) fprintf(fp,"\n");

fprintf(fp,"%-30s%70sPage No        : %-3d\n",hosp_name.arr," ",pno);
fprintf(fp,"%-40s%60sDischarged Date: %10s\n",
	"BILLING DETAILS : DETAILED BREAKDOWN    "," ",d_disch_date_time.arr);
fprintf(fp,"%100sDate           : %s\n\n"," ",d_doc_date.arr);


fprintf(fp,"Patient Id : %-20s  Name : %-30.30s  %-16.16s\n",
	    d_patient_id.arr, d_patient_short_name.arr,
	    d_short_name_loc_lang.arr);

if (strlen(d_patient_short_name1.arr) > 2)
{
	fprintf(fp,"%43s %s\n\n", " ",d_patient_short_name1.arr);
}
  
else     
{ 
  fprintf(fp,"\n");
}

if(nd_episode_type == 'I' || nd_episode_type == 'D' )
    fprintf(fp,"Adm. No.   : %-8s    Ward : %-4s    Room : %-4s  Bed : %-8s\n\n",
	        d_episode_id.arr, d_ward_code.arr, d_room_num.arr, 
	        d_bed_num.arr);
else if(nd_episode_type == 'O' || nd_episode_type == 'E' )
    fprintf(fp,"Episode No.   : %-8s    Visit No : %-4s    Clinic : %-4s \n\n",
	        d_episode_id.arr, nd_visit_id.arr, d_clinic_code.arr);

fprintf(fp,"                       Service    Service                                                                    \n");
fprintf(fp,"            Date       Code       Description                                                   Qty              Amt              Total\n");
fprintf(fp,"------------------------------------------------------------------------------------------------------------------------------------------\n");

if(nd_episode_type == 'R')
    lno = 12;
else
    lno = 14;

}

print_break_hdr()
{

    int i;
    char s_amt[20];

    fetch_prt_grp_hdr_desc();

    if(lno > MAX_LINES)  print_next_page();

    //for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");	
	fprintf(fp,"\n");
    fprintf(fp,"%-2s        %-40s  %21s%-16s\n",d_prt_grp_hdr_code.arr,
	       d_hdr_long_desc.arr, " ",d_hdr_loc_lang_short_desc.arr);

    lno++;
    /*
    g_prt_grp_line_code[0] = '\0';
    */

}

print_break_line()
{

    int i;
    char s_amt[20];

    fetch_prt_grp_line_desc();
	
	/*
    if(!g_first_break) {
       if(lno+3 > MAX_LINES)  print_next_page();
       print_subtot();
       fprintf(fp,"\n\n");
       lno=lno+2;
    }	deepali*/

    /*if(strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr)) 
       print_break_hdr();  DEEPALI*/


    g_first_break = 0;
    if(lno > MAX_LINES)  print_next_page();

    for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");
    fprintf(fp,"      %-2s  %-40s  %21s%-16s  \n",d_prt_grp_line_code.arr,
    	         d_line_long_desc.arr, " ",d_line_loc_lang_short_desc.arr);
    lno++;

}

print_line()
{
    int i;

    if(lno > MAX_LINES) print_next_page();

    for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");
    fprintf(fp,"          %10s %-10s %-40s  %-16s  ", d_service_date.arr,
	    d_blng_serv_code.arr, d_blng_serv_desc.arr, 
	    d_blng_serv_desc_loc_lang.arr);

    /* print_formated(d_gross_amt/d_qty,0);*/

    fprintf(fp,"  %3d  ",d_qty);

    print_formated(d_gross_amt, 0);

    /*
    fprintf(fp,"\n");
    lno++;

    fprintf(fp,"                       %-40s", d_serv_item_desc.arr);
    lno++;
    */
}

print_next_page()
{
    int i;

    pno++;

    print_page_head();

}

print_balance_due()
{

    int i;
    int no_of_lines;
    int new_page;
    char out_str[10][133];
	
    for(i=0; i<10; i++) out_str[i][0] = '\0';

    new_page = 0;
    if(lno+6 > MAX_LINES) {
	new_page = 1;
	print_next_page();
    }
	
    if(new_page) {
	for (i=0; i < HSKIP_13; i++) 
	    fprintf(fp, " ");
    }
    else
        fprintf(fp,"  ");

    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"SUB TOTAL                                     ");
    print_formated(g_cum_amt,1);

    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"LESS Discount                                 ");
    print_formated(tot_disc_amt,1);
    g_cum_amt -= tot_disc_amt;
	

/*
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"LESS Prepayments                             ");
    print_formated(d_prepay_adj_amt,1);
    g_cum_amt -= d_prepay_adj_amt;

    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"TOTAL BALANCE DUE                             ");
    print_formated(g_cum_amt,1);

    for(i = 0; i < HSKIP_13; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"Previous Outstanding                         ");
    print_formated(d_prv_outst_amt,1);
    g_cum_amt += d_prv_outst_amt;
*/

    for(i = 0; i < HSKIP_13; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"TOTAL                                         ");
    print_formated(g_cum_amt,1);
	
	for(i = 0; i < HSKIP_13; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"="); fprintf(fp,"\n");

    g_cum_amt = (g_cum_amt < 0) ? g_cum_amt * -1 : g_cum_amt;

    if(equal(g_cum_amt,0.00)) 
	no_of_lines=0;
    else
        no_of_lines = print_in_words(g_cum_amt,LENGTH_WORDS,sub_cur.arr,out_str);
	
	/*fprintf(fp,"%-6s ",currency.arr);
    for (i =0;i<no_of_lines;i++)
        fprintf(fp,"     %s\n",out_str[i]);*/

}

print_subtot()
{
    int i;

    fprintf(fp,"    ");
    print_formated(g_sub_tot,1);

    for(i = 0; i < HSKIP_12; i++) fprintf(fp," ");
    for(i = 0; i < 15; i++) fprintf(fp,"-");

/*
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"Sub Total             :  ");
    print_formated(g_sub_tot,1);
    fprintf(fp,"\n");
*/
    g_sub_tot = 0;
    g_print_subtot = 0;
    lno += 1;
}


print_formated(loc_amount,flg)
double loc_amount;
int flg;
{
   char s_amt[20], str_amt[20];
 

     if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
      //  ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt,"-");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
            //    ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s ",str_amt);
        }
/*
   sprintf(s_amt,"%15.2f",loc_amount);
   format_amt(s_amt);

   if (loc_amount < 0)
      fprintf(fp,"%15s-",s_amt);
   else
      fprintf(fp,"%15s ",s_amt);
 */
   if(flg)
       fprintf(fp,"\n");
}
