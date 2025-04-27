
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
           char  filnam[45];
};
static const struct sqlcxp sqlfpn =
{
    44,
    "T:\\temp\\Bl\\ganapathy\\JDWORK\\PROC\\Blripin2.pc"
};


static unsigned long sqlctx = 1267618901;


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
            void  *sqhstv[27];
   unsigned int   sqhstl[27];
            int   sqhsts[27];
            void  *sqindv[27];
            int   sqinds[27];
   unsigned int   sqharm[27];
   unsigned int   *sqharc[27];
   unsigned short  sqadto[27];
   unsigned short  sqtdso[27];
} sqlstm = {10,27};

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

 static const char *sq0001 = 
"ITY_ID=:b6) order by BED_NUM  for update of BILL_PRINT_FLAG nowait ";

 static const char *sq0002 = 
"select PRT_GRP_HDR_CODE ,PRT_GRP_LINE_CODE ,CHARGE_TYPE_CODE ,DF_PHYSICIAN_I\
D ,sum(NVL(GROSS_AMT,0))  from BL_BILL_LINE where (((DOC_TYPE_CODE=:b0 and DOC\
_NUM=:b1) and AMT_SIGN_IND=0) and OPERATING_FACILITY_ID=:b2) group by CHARGE_T\
YPE_CODE,PRT_GRP_HDR_CODE,DF_PHYSICIAN_ID,PRT_GRP_LINE_CODE           ";

 static const char *sq0008 = 
"select TOT_DEP_PAID_AMT ,NUM_OF_DEPS_PAID ,NVL(TOT_PREP_PAID_AMT,0) ,LAST_DE\
P_DOC_TYPE_CODE ,LTRIM(TO_CHAR(LAST_DEP_DOC_NUMBER,'00000009')) ,TO_CHAR(LAST_\
DEP_DOC_DATE,'DD/MM/YYYY')  from BL_EPISODE_FIN_DTLS where ((EPISODE_TYPE='I' \
and EPISODE_ID=:b0) and OPERATING_FACILITY_ID=:b1)           ";

 static const char *sq0003 = 
"select LONG_DESC  from BL_BLNG_GRP where BLNG_GRP_ID=:b0           ";

 static const char *sq0004 = 
"select SHORT_NAME ,SHORT_NAME_LOC_LANG ,SEX ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY\
YY') ,ABS(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH))  from MP_PATIENT_MAST where P\
ATIENT_ID=:b0           ";

 static const char *sq0005 = 
"select SHORT_NAME  from SY_PHYSICIAN_MAST where (PHYSICIAN_ID=:b0 and FACILI\
TY_ID=:b1)           ";

 static const char *sq0006 = 
"select LONG_DESC ,LOC_LANG_SHORT_DESC  from BL_BLNG_PRT_GRP_HDR where PRT_GR\
P_HDR_CODE=:b0           ";

 static const char *sq0007 = 
"select LONG_DESC ,LOC_LANG_SHORT_DESC  from BL_BLNG_PRT_GRP_LINE where (PRT_\
GRP_HDR_CODE=:b0 and PRT_GRP_LINE_CODE=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,1091,0,9,325,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
48,0,0,2,302,0,9,344,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
75,0,0,9,149,0,46,383,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
98,0,0,1,0,0,13,467,0,0,27,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,2,4,0,0,
221,0,0,8,293,0,9,547,0,0,2,2,0,1,0,1,3,0,0,1,9,0,0,
244,0,0,8,0,0,13,552,0,0,6,0,0,1,0,2,4,0,0,2,3,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,
283,0,0,2,0,0,13,584,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
318,0,0,3,67,0,9,609,0,0,1,1,0,1,0,1,9,0,0,
337,0,0,3,0,0,13,616,0,0,1,0,0,1,0,2,9,0,0,
356,0,0,10,483,0,4,632,0,0,5,4,0,1,0,2,3,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
391,0,0,4,178,0,9,661,0,0,1,1,0,1,0,1,9,0,0,
410,0,0,4,0,0,13,676,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
445,0,0,5,97,0,9,712,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
468,0,0,5,0,0,13,721,0,0,1,0,0,1,0,2,9,0,0,
487,0,0,6,101,0,9,741,0,0,1,1,0,1,0,1,9,0,0,
506,0,0,6,0,0,13,746,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
529,0,0,7,130,0,9,768,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
552,0,0,7,0,0,13,773,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
575,0,0,11,94,0,4,1008,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
602,0,0,12,96,0,4,1084,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
629,0,0,13,229,0,4,1386,0,0,8,3,0,1,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRIPIN2.PC                                  */
/* AUTHOR                : M.NITIN KUMAR                                */
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
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*  MODIFICATION HISTORY :                                              */
/*                                                                      */
/*  15/05/94 NK In cursor BL_BILL_LINE select only those records whose  */
/*              amt_sign_ind != 0                                       */
/*                                                                      */
/*  31/05/94 NK In cursor BL_BILL_LINE select only those records whose  */
/*              amt_sign_ind  = 0                                       */
/*  UPGRADED TO 4.1                                                     */
/************************************************************************/
                                    

/* All control-chars have been commented as they do not make sense on 
   a Dot Matrix Printer
   -  For American Hospital Implementation. -- G. Viswanath/31/7/1996
*/   
  
#include <stdio.h>
#include <string.h>

#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define RESOURCE_BUSY (sqlca.sqlcode == -54)

#define WORKING_DIR "blripin1.lis"

#define HSKIP_1 55
#define HSKIP_1_1 55
#define HSKIP_2 9
#define HSKIP_2_1 33
#define HSKIP_2_2 44
#define HSKIP_3 9
#define HSKIP_3_1 19
#define HSKIP_3_2 13
#define HSKIP_4 4
#define HSKIP_4_1 17
#define HSKIP_4_2 11
#define HSKIP_4_3 6
#define HSKIP_4_4 20
#define HSKIP_5 6
#define HSKIP_5_1 25
#define HSKIP_6 16
#define HSKIP_6_1 21
#define HSKIP_7 7
#define HSKIP_7_1 1
#define HSKIP_7_2 2
#define HSKIP_7_3 1
#define HSKIP_7_4 50
#define HSKIP_8 23
#define HSKIP_10 2
#define HSKIP_11 65
#define HSKIP_12 80
#define HSKIP_13 56
#define HSKIP_13_1 59
#define HSKIP_14 9
#define HSKIP_15 2
#define HSKIP_15_1 35
#define HSKIP_16 83
#define HSKIP_17 82

#define VSKIP_1 4
#define VSKIP_2 1
#define VSKIP_3 3
#define VSKIP_4 5

#define MAX_LINES 22

#define LEGEND 1

#define LENGTH_WORDS 65 

#define ERR_MESG  4


/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
           date_time    [20],
           user_id      [20],
           nd_pgm_date  [35]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;


   extern char OUTPUT_FILE_NAME[150];
   extern /* VARCHAR nd_fm_doc_type             [7],
		           nd_fm_doc_num             [9],
		           nd_to_doc_type            [7],
		           nd_to_doc_num             [9],
		           nd_fm_doc_date            [11],
		           nd_to_doc_date            [11],
				   nd_ws_no					 [31],
				   nd_facility_id			 [3]; */ 
struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;
extern 
struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_num;
extern 
struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;
extern 
struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_num;
extern 
struct { unsigned short len; unsigned char arr[11]; } nd_fm_doc_date;
extern 
struct { unsigned short len; unsigned char arr[11]; } nd_to_doc_date;
extern 
struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;
extern 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


   /* VARCHAR d_doc_type_code            [7],
		   d_doc_date                 [11],
		   d_admission_date           [11],
		   d_admission_time           [6],
		   d_ward_code                [5],
		   d_room_num                 [5],
		   d_bed_num                  [9],
		   d_physician_id             [16],
		   d_physician_name           [16],
		   d_blng_grp_id              [3],
		   d_prt_grp_hdr_code         [3],
		   d_prt_grp_line_code        [3],
		   d_charge_type_code         [2],
		   d_df_physician_id          [16],
		   d_df_physician_name        [31],
		   d_blng_grp_desc            [31],
		   d_patient_id               [21],
		   d_patient_short_name       [61],
		   d_patient_short_name_loc   [61],
		   d_date_of_birth            [11],
		   d_sex                      [2],
		   d_hdr_long_desc            [41],
		   d_hdr_loc_lang_short_desc  [61],
		   d_line_long_desc           [41],
		   d_line_loc_lang_short_desc [16],
		   d_doc_num_prt              [9],
		   d_episode_id_prt           [9],
		   d_prv_doc_type_code        [7],
		   d_prv_doc_num              [9],
		   d_prv_doc_date             [11],
		   d_bill_fm_date             [11],
		   d_bill_to_date             [11],
		   d_last_doc_type_code       [7],
		   d_last_doc_num             [9],
		   d_last_doc_date            [11],
		   cur_str					  [8],
		   sub_cur_str				  [8]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_admission_date;

struct { unsigned short len; unsigned char arr[6]; } d_admission_time;

struct { unsigned short len; unsigned char arr[5]; } d_ward_code;

struct { unsigned short len; unsigned char arr[5]; } d_room_num;

struct { unsigned short len; unsigned char arr[9]; } d_bed_num;

struct { unsigned short len; unsigned char arr[16]; } d_physician_id;

struct { unsigned short len; unsigned char arr[16]; } d_physician_name;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[2]; } d_charge_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_df_physician_id;

struct { unsigned short len; unsigned char arr[31]; } d_df_physician_name;

struct { unsigned short len; unsigned char arr[31]; } d_blng_grp_desc;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_short_name_loc;

struct { unsigned short len; unsigned char arr[11]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[41]; } d_hdr_long_desc;

struct { unsigned short len; unsigned char arr[61]; } d_hdr_loc_lang_short_desc;

struct { unsigned short len; unsigned char arr[41]; } d_line_long_desc;

struct { unsigned short len; unsigned char arr[16]; } d_line_loc_lang_short_desc;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num_prt;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id_prt;

struct { unsigned short len; unsigned char arr[7]; } d_prv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_prv_doc_num;

struct { unsigned short len; unsigned char arr[11]; } d_prv_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_bill_fm_date;

struct { unsigned short len; unsigned char arr[11]; } d_bill_to_date;

struct { unsigned short len; unsigned char arr[7]; } d_last_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_last_doc_num;

struct { unsigned short len; unsigned char arr[11]; } d_last_doc_date;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

int        d_num_of_deps_paid;

long       d_doc_num,
           nd_months,
		   d_episode_id;

double     d_serv_disc_amt,
		   d_man_disc_amt,
		   d_overall_disc_amt,
		   d_prepay_adj_amt,
		   d_deposit_adj_amt,
		   d_bill_paid_amt,
		   d_gross_amt,
		   d_prv_amt,
		   d_prv_outst_amt,
		   d_tot_dep_paid_amt,
		   d_tot_prep_paid_amt;

int        nd_age_yyy,
           nd_age_mm,
           nd_age_dd,
           nd_rc_count;

double     t_bill_amt,
		   t_bill_paid_amt,
		   t_prepay_adj_amt;

/* VARCHAR    t_doc_type_code    [7],
		   t_doc_num          [9]; */ 
struct { unsigned short len; unsigned char arr[7]; } t_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } t_doc_num;

char       string_var [100];


	
/* EXEC SQL END DECLARE SECTION; */ 



// EXEC ORACLE OPTION(HOLD_CURSOR = YES);
// EXEC ORACLE OPTION(REBIND = NO);

/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blripin2.c-arc   1.0   Apr 19 2007 17:06:32   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blripin2.c-arc   1.0   Apr 19 2007 17:06:32   vcm_th  $ sqlda.h 
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





char g_prt_grp_hdr_code[3],
     g_charge_type_code[2],
     g_df_physician_id[16];

char bar_code[25];
char filename[150];


int  g_first_break ;
int  g_df_first_break ;
int  g_hdr_change;
int g_print_subtot;
int lno = 0, pno = 0;

double g_cum_amt = 0,g_sub_tot = 0,g_df_sub_tot = 0, g_net_amt = 0;

FILE *fp;

declare_cursors()
{


    /* EXEC SQL DECLARE BL_BILL_HDR_CUR CURSOR FOR
	     SELECT DOC_TYPE_CODE,
			    DOC_NUM,
			    LTRIM(TO_CHAR(DOC_NUM,'00000009')),
			    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
			    SERV_DISC_AMT,
			    MAN_DISC_AMT,
			    OVERALL_DISC_AMT,
			    PREPAY_ADJ_AMT,
			    DEPOSIT_ADJ_AMT,
			    BILL_PRV_BILL_PAID_AMT,
			    EPISODE_ID,
			    LTRIM(TO_CHAR(EPISODE_ID,'00000009')),
			    TO_CHAR(ADMISSION_DATE,'DD/MM/YYYY'),
			    TO_CHAR(ADMISSION_DATE,'HH24:MI'),
			    WARD_CODE,
			    ROOM_NUM,
			    BED_NUM,
			    PHYSICIAN_ID,
			    BLNG_GRP_ID,
			    PATIENT_ID,
			    TO_CHAR(BILL_FROM_DATE,'DD/MM/YYYY'),
			    TO_CHAR(BILL_TO_DATE,'DD/MM/YYYY'),
			    BILL_PRV_DOC_TYPE_CODE,
			    LTRIM(TO_CHAR(BILL_PRV_DOC_NUMBER,'00000009')),
	                    TO_CHAR(BILL_PRV_DOC_DATE,'DD/MM/YYYY'),
			    BILL_PRV_BILL_AMT,
			    BILL_PRV_OUTST_AMT
	    FROM    BL_BILL_HDR
	    WHERE  RPAD(DOC_TYPE_CODE,6,' ')||LTRIM(TO_CHAR(DOC_NUM,'00000009'))
	    BETWEEN RPAD(NVL(:nd_fm_doc_type,'      '),6)||
		    NVL(:nd_fm_doc_num,'00000000') AND
	            RPAD(NVL(:nd_to_doc_type,'~~~~~~'),6)||
		    NVL(:nd_to_doc_num,'99999999')
	    AND     DOC_DATE BETWEEN 
		      TO_DATE(NVL(:nd_fm_doc_date,'01/01/1000'),'DD/MM/YYYY')
		      AND
		      TO_DATE(NVL(:nd_to_doc_date,'01/01/3000'),'DD/MM/YYYY')
	    AND     NVL(BILL_TRX_TYPE_CODE,'X') = 'I'
	    AND     NVL(BILL_STATUS,'X') <> 'C'
		AND   OPERATING_FACILITY_ID = :nd_facility_id
	    ORDER BY BED_NUM
	    FOR UPDATE OF BILL_PRINT_FLAG NOWAIT; */ 


    /* EXEC SQL DECLARE BL_BILL_LINE_CUR CURSOR FOR
	     SELECT  PRT_GRP_HDR_CODE,
			     PRT_GRP_LINE_CODE,
                 CHARGE_TYPE_CODE,
                 DF_PHYSICIAN_ID,
    		     SUM(NVL(GROSS_AMT,0))
	     FROM    BL_BILL_LINE
	     WHERE   DOC_TYPE_CODE = :d_doc_type_code
	     AND     DOC_NUM       = :d_doc_num
	     AND     AMT_SIGN_IND  = 0
		 AND     OPERATING_FACILITY_ID = :nd_facility_id
	     GROUP BY CHARGE_TYPE_CODE,PRT_GRP_HDR_CODE,
		         DF_PHYSICIAN_ID,PRT_GRP_LINE_CODE; */ 


    /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
	     SELECT  LONG_DESC
	     FROM    BL_BLNG_GRP
	     WHERE   BLNG_GRP_ID = :d_blng_grp_id; */ 


    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
	     SELECT  SHORT_NAME,
                 SHORT_NAME_LOC_LANG,
			     SEX,
                 TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
                 ABS(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH))  
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :d_patient_id; */ 


    /* EXEC SQL DECLARE SY_PHYSICIAN_MAST_CUR CURSOR FOR
	     SELECT  SHORT_NAME
	     FROM    SY_PHYSICIAN_MAST
	     WHERE   PHYSICIAN_ID = :d_physician_id
		 AND	 FACILITY_ID = :nd_facility_id; */ 


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


    /* EXEC SQL DECLARE BL_EPISODE_FIN_DTLS_CUR CURSOR FOR
	     SELECT  TOT_DEP_PAID_AMT,
		    	 NUM_OF_DEPS_PAID,
		     	 NVL(TOT_PREP_PAID_AMT,0),
		     	 LAST_DEP_DOC_TYPE_CODE,
		         LTRIM(TO_CHAR(LAST_DEP_DOC_NUMBER,'00000009')),
		     	 TO_CHAR(LAST_DEP_DOC_DATE,'DD/MM/YYYY')
	     FROM    BL_EPISODE_FIN_DTLS
	     WHERE   EPISODE_TYPE = 'I'
	     AND     EPISODE_ID   = :d_episode_id
		 AND     OPERATING_FACILITY_ID = :nd_facility_id; */ 


}


prt_inhouse_bill()
{
    open_files();
	declare_cursors();
	
    /* EXEC SQL OPEN BL_BILL_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select DOC_TYPE_CODE ,DOC_NUM ,LTRIM(TO_CHAR(DOC_NUM,'00000009')) ,TO\
_CHAR(DOC_DATE,'DD/MM/YYYY') ,SERV_DISC_AMT ,MAN_DISC_AMT ,OVERALL_DISC_AMT \
,PREPAY_ADJ_AMT ,DEPOSIT_ADJ_AMT ,BILL_PRV_BILL_PAID_AMT ,EPISODE_ID ,LTRIM(\
TO_CHAR(EPISODE_ID,'00000009')) ,TO_CHAR(ADMISSION_DATE,'DD/MM/YYYY') ,TO_CH\
AR(ADMISSION_DATE,'HH24:MI') ,WARD_CODE ,ROOM_NUM ,BED_NUM ,PHYSICIAN_ID ,BL\
NG_GRP_ID ,PATIENT_ID ,TO_CHAR(BILL_FROM_DATE,'DD/MM/YYYY') ,TO_CHAR(BILL_TO\
_DATE,'DD/MM/YYYY') ,BILL_PRV_DOC_TYPE_CODE ,LTRIM(TO_CHAR(BILL_PRV_DOC_NUMB\
ER,'00000009')) ,TO_CHAR(BILL_PRV_DOC_DATE,'DD/MM/YYYY') ,BILL_PRV_BILL_AMT \
,BILL_PRV_OUTST_AMT  from BL_BILL_HDR where (((((RPAD(DOC_TYPE_CODE,6,' ')||\
LTRIM(TO_CHAR(DOC_NUM,'00000009'))) between (RPAD(NVL(:b0,'      '),6)||NVL(\
:b1,'00000000')) and (RPAD(NVL(:b2,'~~~~~~'),6)||NVL(:b3,'99999999')) and DO\
C_DATE between TO_DATE(NVL(:b4,'01/01/1000'),'DD/MM/YYYY') and TO_DATE(NVL(:\
b5,'01/01/3000'),'DD/MM/YYYY')) and NVL(BILL_TRX_TYPE_CODE,'X')='I') and NVL\
(BILL_STATUS,'X')<>'C') and OPERATING_FACIL");
    sqlstm.stmt = sq0001;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_type;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
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
        err_mesg("OPEN failed on cursor BL_BILL_HDR_CUR",0,"");

    if(RESOURCE_BUSY)
	err_mesg("Unable to lock BL_BILL_HDR_CUR. Exiting...",0,"");
    while(fetch_bill_hdr()) {
		
	pno = 1;
	g_cum_amt = 0;

	fetch_blng_grp_desc();
	fetch_patient_name();
	fetch_physician_name();
	fetch_deposit_dtls();
	fetch_ret_chq_hist();
	print_page_head();
	
	/* EXEC SQL OPEN BL_BILL_LINE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0002;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )48;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
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
 sqlstm.sqphsv = sqlstm.sqhstv;
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
            err_mesg("OPEN failed on cursor BL_BILL_LINE_CUR",0,"");

	g_prt_grp_hdr_code[0] = '\0';
	g_first_break = 1;
	g_df_first_break = 1;
	g_print_subtot = 0;
	g_hdr_change = 0;
	while(fetch_bill_line()) {

	    if(strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr)) 
		print_break();
            else
            {
	      if(strcmp(g_df_physician_id,d_df_physician_id.arr)) 
		print_df_break();
            }

	    fetch_prt_grp_line_desc();
	    print_line();


	    strcpy(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr);
	    strcpy(g_charge_type_code,d_charge_type_code.arr);
	    strcpy(g_df_physician_id,d_df_physician_id.arr);

	    g_cum_amt += d_gross_amt;
	    g_sub_tot += d_gross_amt;
	    g_df_sub_tot += d_gross_amt;
	    g_print_subtot = 1;

	} /* end of while fetch_bill_line() */

/**	if(g_print_subtot)
	    print_subtot();   Commented by Aldrin    ***/
	print_balance_due();

	/* EXEC SQL UPDATE BL_BILL_HDR
		 SET    BILL_PRINT_FLAG = 'Y',
			MODIFIED_BY_ID  = USER,               
			MODIFIED_DATE   = SYSDATE,              
			MODIFIED_AT_WS_NO = :nd_ws_no,             
			MODIFIED_FACILITY_ID = :nd_facility_id	  					
			 WHERE  CURRENT OF BL_BILL_HDR_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_BILL_HDR  set BILL_PRINT_FLAG='Y',MODIFIED_BY_ID=U\
SER,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where\
 rowid = :x";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )75;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[0] = (unsigned int  )33;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
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
	    err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");

    fprintf(fp,"");
//    print_page_head();
    } /* end of while fetch_bill_hdr()  */

    fflush(fp);
    fclose(fp);
    return 1;

}

open_files()
{
 //char a1[150];
 strcpy(OUTPUT_FILE_NAME,WORKING_DIR);
// sprintf(a1,"%s",OUTPUT_FILE_NAME);
   if ((fp = fopen(OUTPUT_FILE_NAME,"w")) == NULL)
   {
        err_mesg("\nError while opening File blripin1.lis\n",0,"");
        exit(0);
   }

}

fetch_bill_hdr()
{
   d_doc_type_code.arr[0]       = '\0';
   d_doc_date.arr[0]            = '\0';
   d_admission_date.arr[0]      = '\0';
   d_admission_time.arr[0]      = '\0';
   d_ward_code.arr[0]           = '\0';
   d_room_num.arr[0]            = '\0';
   d_bed_num.arr[0]             = '\0';
   d_physician_id.arr[0]        = '\0';
   d_blng_grp_id.arr[0]         = '\0';
   d_patient_id.arr[0]          = '\0';
   d_doc_num_prt.arr[0]         = '\0';
   d_episode_id_prt.arr[0]      = '\0';
   d_bill_fm_date.arr[0]        = '\0';
   d_bill_to_date.arr[0]        = '\0';
   d_prv_doc_type_code.arr[0]   = '\0';
   d_prv_doc_num.arr[0]         = '\0';
   d_prv_doc_date.arr[0]        = '\0';

   d_doc_type_code.len       = 0;
   d_doc_date.len            = 0;
   d_admission_date.len      = 0;
   d_admission_time.len      = 0;
   d_ward_code.len           = 0;
   d_room_num.len            = 0;
   d_bed_num.len             = 0;
   d_physician_id.len        = 0;
   d_blng_grp_id.len         = 0;
   d_patient_id.len          = 0;
   d_doc_num_prt.len         = 0;
   d_episode_id_prt.len      = 0;
   d_bill_fm_date.len        = 0;
   d_bill_to_date.len        = 0;
   d_prv_doc_type_code.len   = 0;
   d_prv_doc_num.len         = 0;
   d_prv_doc_date.len        = 0;


   d_doc_num          = 0;
   d_episode_id       = 0;
   d_serv_disc_amt    = 0;
   d_man_disc_amt     = 0;
   d_overall_disc_amt = 0;
   d_prepay_adj_amt   = 0;
   d_deposit_adj_amt  = 0;
   d_bill_paid_amt    = 0;
   d_prv_amt          = 0;
   d_prv_outst_amt    = 0;

   /* EXEC SQL FETCH BL_BILL_HDR_CUR 
		    INTO  :d_doc_type_code,
                  :d_doc_num,
				  :d_doc_num_prt,
                  :d_doc_date,
                  :d_serv_disc_amt,
                  :d_man_disc_amt,
                  :d_overall_disc_amt,
                  :d_prepay_adj_amt,
                  :d_deposit_adj_amt,
                  :d_bill_paid_amt,
                  :d_episode_id,
				  :d_episode_id_prt,
                  :d_admission_date,
                  :d_admission_time,
                  :d_ward_code,
                  :d_room_num,
                  :d_bed_num,
                  :d_physician_id,
                  :d_blng_grp_id,
				  :d_patient_id,
				  :d_bill_fm_date,
				  :d_bill_to_date,
				  :d_prv_doc_type_code,
				  :d_prv_doc_num,
				  :d_prv_doc_date,
				  :d_prv_amt,
				  :d_prv_outst_amt; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )98;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_doc_num_prt;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_serv_disc_amt;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_man_disc_amt;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_overall_disc_amt;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_prepay_adj_amt;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_deposit_adj_amt;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_bill_paid_amt;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_episode_id_prt;
   sqlstm.sqhstl[11] = (unsigned int  )11;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_admission_date;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_admission_time;
   sqlstm.sqhstl[13] = (unsigned int  )8;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_ward_code;
   sqlstm.sqhstl[14] = (unsigned int  )7;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_room_num;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_bed_num;
   sqlstm.sqhstl[16] = (unsigned int  )11;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_physician_id;
   sqlstm.sqhstl[17] = (unsigned int  )18;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_blng_grp_id;
   sqlstm.sqhstl[18] = (unsigned int  )5;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[19] = (unsigned int  )23;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_bill_fm_date;
   sqlstm.sqhstl[20] = (unsigned int  )13;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_bill_to_date;
   sqlstm.sqhstl[21] = (unsigned int  )13;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_prv_doc_type_code;
   sqlstm.sqhstl[22] = (unsigned int  )9;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_prv_doc_num;
   sqlstm.sqhstl[23] = (unsigned int  )11;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&d_prv_doc_date;
   sqlstm.sqhstl[24] = (unsigned int  )13;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&d_prv_amt;
   sqlstm.sqhstl[25] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&d_prv_outst_amt;
   sqlstm.sqhstl[26] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
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
	err_mesg("FETCH failed on cursor BL_BILL_HDR_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

   d_doc_type_code.arr[d_doc_type_code.len]            = '\0';
   d_doc_date.arr[d_doc_date.len]                      = '\0';
   d_admission_date.arr[d_admission_date.len]          = '\0';
   d_admission_time.arr[d_admission_time.len]          = '\0';
   d_ward_code.arr[d_ward_code.len]                    = '\0';
   d_room_num.arr[d_room_num.len]                      = '\0';
   d_bed_num.arr[d_bed_num.len]                        = '\0';
   d_physician_id.arr[d_physician_id.len]              = '\0';
   d_blng_grp_id.arr[d_blng_grp_id.len]                = '\0';
   d_patient_id.arr[d_patient_id.len]                  = '\0';
   d_doc_num_prt.arr[d_doc_num_prt.len]                = '\0';
   d_episode_id_prt.arr[d_episode_id_prt.len]          = '\0';
   d_bill_fm_date.arr[d_bill_fm_date.len]              = '\0';
   d_bill_to_date.arr[d_bill_to_date.len]              = '\0';
   d_prv_doc_type_code.arr[d_prv_doc_type_code.len]    = '\0';
   d_prv_doc_num.arr[d_prv_doc_num.len]                = '\0';
   d_prv_doc_date.arr[d_prv_doc_date.len]              = '\0';

   t_bill_amt = 0;
   t_bill_paid_amt = 0;
   t_prepay_adj_amt = 0;

    if(d_prv_doc_type_code.arr[0])
	   get_prv_amts();


   return 1;

}

fetch_deposit_dtls()
{

   d_last_doc_type_code.arr[0]   = '\0';
   d_last_doc_num.arr[0]         = '\0';
   d_last_doc_date.arr[0]        = '\0';

   d_last_doc_type_code.len   = 0;
   d_last_doc_num.len         = 0;
   d_last_doc_date.len        = 0;

   d_num_of_deps_paid = 0;
   d_tot_dep_paid_amt = 0;
   d_tot_prep_paid_amt= 0;

   /* EXEC SQL OPEN BL_EPISODE_FIN_DTLS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )221;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
   sqlstm.sqphsv = sqlstm.sqhstv;
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
       err_mesg("OPEN failed on cursor BL_EPISODE_FIN_DTLS_CUR",0,"");

    /* EXEC SQL FETCH BL_EPISODE_FIN_DTLS_CUR INTO
						   :d_tot_dep_paid_amt,
						   :d_num_of_deps_paid,
						   :d_tot_prep_paid_amt,
						   :d_last_doc_type_code,
						   :d_last_doc_num,
						   :d_last_doc_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )244;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_tot_dep_paid_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_num_of_deps_paid;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_tot_prep_paid_amt;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_last_doc_type_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_last_doc_num;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_last_doc_date;
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
}



   if(OERROR)
       err_mesg("OPEN failed on cursor BL_EPISODE_FIN_DTLS_CUR",0,"");

   d_last_doc_type_code.arr[d_last_doc_type_code.len]    = '\0';
   d_last_doc_num.arr[d_last_doc_num.len]                = '\0';
   d_last_doc_date.arr[d_last_doc_date.len]              = '\0';

}

fetch_bill_line()
{

    d_prt_grp_hdr_code.arr[0]  = '\0';
    d_prt_grp_line_code.arr[0] = '\0';
    d_charge_type_code.arr[0]  = '\0';
    d_df_physician_id.arr[0]   = '\0';
  
    d_prt_grp_hdr_code.len  = 0;
    d_prt_grp_line_code.len = 0;
    d_charge_type_code.len  = 0;
    d_df_physician_id.len   = 0;

    d_gross_amt = 0;

    /* EXEC SQL FETCH BL_BILL_LINE_CUR
		     INTO  :d_prt_grp_hdr_code,
				   :d_prt_grp_line_code,
	               :d_charge_type_code,
	               :d_df_physician_id,
				   :d_gross_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )283;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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
    sqlstm.sqhstv[2] = (         void  *)&d_charge_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_df_physician_id;
    sqlstm.sqhstl[3] = (unsigned int  )18;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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
	err_mesg("FETCH failed on table BL_BILL_LINE_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]   = '\0';
    d_prt_grp_line_code.arr[d_prt_grp_line_code.len] = '\0';
    d_charge_type_code.arr[d_charge_type_code.len]   = '\0';
    d_df_physician_id.arr[d_df_physician_id.len]     = '\0';

    return 1;

}

fetch_blng_grp_desc()
{

    /* EXEC SQL OPEN BL_BLNG_GRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0003;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )318;
    sqlstm.selerr = (unsigned short)1;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )337;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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


fetch_ret_chq_hist()
{

    nd_rc_count = 0;

    /* EXEC SQL SELECT COUNT(*)
             INTO   :nd_rc_count
             FROM   BL_RECEIPT_REFUND_DTL A
             WHERE  A.RECPT_REFUND_IND = 'R'
             AND    A.EPISODE_TYPE = 'I'
             AND    A.EPISODE_ID   = :d_episode_id
             AND    A.PATIENT_ID   = :d_patient_id
             AND    NVL(A.CANCELLED_IND,'N') != 'Y'
             AND    A.CASH_SLMT_FLAG = 'B'
			 AND    OPERATING_FACILITY_ID = :nd_facility_id
             AND    EXISTS ( SELECT 'X'
                             FROM   BL_CANCELLED_BOUNCED_TRX B
                             WHERE  A.DOC_TYPE_CODE = B.DOC_TYPE_CODE
                             AND    A.DOC_NUMBER    = B.DOC_NUMBER
                             AND    B.BOUNCED_YN    = 'Y'
                             AND    NVL(B.BOUNCED_STATUS_IND,'X')
                                    IN ('R','W')
							 AND    OPERATING_FACILITY_ID = :nd_facility_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from BL_RECEIPT_REFUND_DTL A w\
here (((((((A.RECPT_REFUND_IND='R' and A.EPISODE_TYPE='I') and A.EPISODE_ID=:b\
1) and A.PATIENT_ID=:b2) and NVL(A.CANCELLED_IND,'N')<>'Y') and A.CASH_SLMT_FL\
AG='B') and OPERATING_FACILITY_ID=:b3) and exists (select 'X'  from BL_CANCELL\
ED_BOUNCED_TRX B where ((((A.DOC_TYPE_CODE=B.DOC_TYPE_CODE and A.DOC_NUMBER=B.\
DOC_NUMBER) and B.BOUNCED_YN='Y') and NVL(B.BOUNCED_STATUS_IND,'X') in ('R','W\
')) and OPERATING_FACILITY_ID=:b3)))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )356;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_rc_count;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
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
    sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
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



    if(OERROR)
        err_mesg("SELECT failed on TABLE BL_RECEIPT_REFUND_DTL",0,"");
}

fetch_patient_name()
{
  float      mths;
  float      yrs,days;
  int        iyrs,imths,idays;

    /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )391;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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

    d_patient_short_name.arr[0]     = '\0';
    d_patient_short_name_loc.arr[0] = '\0';
    d_date_of_birth.arr[0]          = '\0';
    d_sex.arr[0]                    = '\0';

    d_patient_short_name.len      = 0;
    d_patient_short_name_loc.len  = 0;
    d_date_of_birth.len           = 0;
    d_sex.len                     = 0;

    /* EXEC SQL FETCH MP_PATIENT_MAST_CUR
		     INTO  :d_patient_short_name,
	               :d_patient_short_name_loc,
				   :d_sex,
	               :d_date_of_birth,
	               :nd_months; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )410;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_short_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_patient_short_name_loc;
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
    sqlstm.sqhstv[3] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_months;
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
}


    if(OERROR)
	err_mesg("FETCH failed on cursor MP_PATIENT_MAST_CUR",0,"");

    d_patient_short_name.arr[d_patient_short_name.len]         = '\0';
    d_patient_short_name_loc.arr[d_patient_short_name_loc.len] = '\0';
    d_date_of_birth.arr[d_date_of_birth.len]                   = '\0';
    d_sex.arr[d_sex.len]                                       = '\0';

    mths = nd_months;
/*--------------------------- Age Calculation -------------------------------*/
   yrs= days=0;
   imths = mths;

   if (imths > 0)
       yrs = mths/12;

   iyrs = yrs;
   imths = imths - iyrs * 12;

   days = (mths - (int)mths) * 31;
   idays = days;

   nd_age_yyy = iyrs;                                          /* Age in YYY */
   nd_age_mm  = imths;                                         /* Age in MM */
   nd_age_dd  = idays;                                         /* Age in DD */
}

fetch_physician_name()
{

    /* EXEC SQL OPEN SY_PHYSICIAN_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )445;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_physician_id;
    sqlstm.sqhstl[0] = (unsigned int  )18;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )468;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_physician_name;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )487;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )506;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_hdr_long_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_hdr_loc_lang_short_desc;
    sqlstm.sqhstl[1] = (unsigned int  )63;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )529;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )552;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_line_long_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_line_loc_lang_short_desc;
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
//       fprintf(fp,"\f");

//    fprintf(fp,"~d0x4;");

    g_first = 0;

//  Commented due to non availability of BARCODE.OBJ
//  Commented in Windows Version. - Prasad
//    get_bar_code(d_patient_id.arr,bar_code);

    for(i = 0; i < VSKIP_1; i++) fprintf(fp,"\n");
    fprintf(fp,"                                                                    %3d",pno);
    for(i = 0; i < VSKIP_1; i++) fprintf(fp,"\n");
    for(i = 0; i < VSKIP_1 - 2;i++) fprintf(fp,"\n");

/*
    for(i = 0; i < HSKIP_1; i++) fprintf(fp," ");

    fprintf(fp,"Page No : %-3d",pno);
*/

//    fprintf(fp,"~L0;");
//    fprintf(fp,"%s",bar_code);

    for(i = 0; i < HSKIP_1 -2; i++) fprintf(fp," ");
    fprintf(fp,"%-6s/%-8s\n",d_doc_type_code.arr,d_doc_num_prt.arr);

//    fprintf(fp,"%s\n",bar_code);

//    fprintf(fp,"%s",bar_code);
    for(i = 0; i < HSKIP_1_1 -1; i++) fprintf(fp," ");
    fprintf(fp,"%s",d_doc_date.arr);
    
//    fprintf(fp,"~L6;\n");
      fprintf(fp, "\n");

    for(i = 0; i < VSKIP_2; i++) fprintf(fp,"\n");
/*
    for(i = 0; i < HSKIP_2; i++) fprintf(fp," ");
    fprintf(fp,"%-30s\n\n",d_blng_grp_desc.arr);

    for(i = 0; i < HSKIP_3; i++) fprintf(fp," ");
    fprintf(fp,"%-10s %-30.30s",d_patient_id.arr,d_patient_short_name.arr);
*/

    for(i = 0; i < HSKIP_2 + 2 ; i++) fprintf(fp," ");
    fprintf(fp,"%-15.15s",d_patient_short_name.arr);

    for(i = 0; i < HSKIP_2_1 -4; i++) fprintf(fp," ");
    fprintf(fp,"%-10.10s\n\n",d_patient_id.arr);

    for(i = 0; i < HSKIP_2_2 - 42; i++) fprintf(fp," ");
    fprintf(fp,"%3dY",nd_age_yyy);

    for(i = 0; i < HSKIP_3; i++) fprintf(fp," ");
//    fprintf(fp,"%-16.16s",d_patient_short_name_loc.arr);

//    for(i = 0; i < HSKIP_3_1; i++) fprintf(fp," ");
//    fprintf(fp,"Yrs / Mths / Days");

    for(i = 0; i < HSKIP_3_2 + 32; i++) fprintf(fp," ");
    fprintf(fp,"%-8s\n\n",d_episode_id_prt.arr);

    for(i = 0; i < HSKIP_4; i++) fprintf(fp," ");
    fprintf(fp,"%-4s",d_ward_code.arr);

    for(i = 0; i < HSKIP_4_1; i++) fprintf(fp," ");
    fprintf(fp,"%-4s/",d_room_num.arr);

  //  for(i = 0; i < HSKIP_4_2 ; i++) fprintf(fp," ");
    fprintf(fp,"%-8s",d_bed_num.arr);

    for(i = 0; i < HSKIP_4_3 -2; i++) fprintf(fp," ");
    fprintf(fp,"%c",d_sex.arr[0]);

    for(i = 0; i < HSKIP_4_4 -3; i++) fprintf(fp," ");
    fprintf(fp,"%s\n",d_admission_date.arr);

    for(i = 0; i < HSKIP_5 + 8; i++) fprintf(fp," ");
    fprintf(fp,"%-15s   %-6s",d_physician_name.arr,d_physician_id.arr);

    for(i = 0; i < HSKIP_5_1 - 4; i++) fprintf(fp," ");
    fprintf(fp,"%s\n\n",d_admission_time.arr);

    for(i = 0; i < HSKIP_6 -10; i++) fprintf(fp," ");
    print_formated(d_tot_dep_paid_amt,0);
    fprintf(fp,"  (%2d)",d_num_of_deps_paid);

    if(nd_rc_count)
        fprintf(fp,"        %2s/RC", d_blng_grp_id.arr);
    else
        fprintf(fp,"        %2s   ", d_blng_grp_id.arr);

    for(i = 0; i < HSKIP_6_1 -2; i++) fprintf(fp," ");
    fprintf(fp,"%6s/%-8s \n", d_last_doc_type_code.arr,
                                d_last_doc_num.arr);
//  Commented By Aldrin
//    fprintf(fp,"%6s/%-8s %s\n", d_last_doc_type_code.arr,
//                                d_last_doc_num.arr,d_last_doc_date.arr);
/*
    if(d_prv_doc_type_code.arr[0]) {
        for(i = 0; i < HSKIP_7; i++) fprintf(fp," ");
        fprintf(fp,"%-6s/%-8s",d_prv_doc_type_code.arr,d_prv_doc_num.arr);

        for(i = 0; i < HSKIP_7_1; i++) fprintf(fp," ");
        fprintf(fp,"%10s",d_prv_doc_date.arr);
    
        for(i = 0; i < HSKIP_7_2; i++) fprintf(fp," ");
        print_formated(d_prv_amt,0);
    
        for(i = 0; i < HSKIP_7_3; i++) fprintf(fp," ");
        print_formated(d_bill_paid_amt,0);
    
        for(i = 0; i < HSKIP_7_4; i++) fprintf(fp," ");
        print_formated(d_prv_outst_amt,1);
    }
*/

    for(i = 0; i < VSKIP_3 +1 ; i++) fprintf(fp,"\n");

    for(i = 0; i < HSKIP_8 -3; i++) fprintf(fp," ");
    fprintf(fp,"%10s      %10s\n\n",
                      d_bill_fm_date.arr,d_bill_to_date.arr);

    lno = 0;

}

print_break()
{

    int i;
    char s_amt[20];

    fetch_prt_grp_hdr_desc();

    g_hdr_change = 1;

/*    if(!g_first_break) 
        print_subtot();        Commented by Aldrin  **/
 
    g_first_break = 0;
    if(lno > MAX_LINES)  print_next_page();

/*
    for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");
    fprintf(fp,"%-2s        %-40s  %-16.16s\n",d_prt_grp_hdr_code.arr,
            d_hdr_long_desc.arr, d_hdr_loc_lang_short_desc.arr);
    lno++;
*/
}

print_line()
{
    int i;

    if(!equal(d_gross_amt,(double) 0))
    {
       if(g_hdr_change)
       {
            /*for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");*/

//          fprintf(fp,"~d4x12;");

            fprintf(fp,"%-2s     %-40s\n",d_prt_grp_hdr_code.arr,
               d_hdr_long_desc.arr);
               
//            fprintf(fp,"~d0x4;");

//Commented by Aldrin  fprintf(fp,"%-16s\n",d_hdr_loc_lang_short_desc.arr);
            lno++;

            if (d_charge_type_code.arr[0] != '1')
            { 
               g_df_first_break = 1;
               print_df_break();
            }
            g_hdr_change = 0;
        }
        if(lno > MAX_LINES) print_next_page();

        /*for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");*/

//        fprintf(fp,"~d4x12;");

        fprintf(fp,"  %-2s        %-40s          ", d_prt_grp_line_code.arr,
           d_line_long_desc.arr);

//        fprintf(fp,"~d0x4;");

// Commented by Aldrin  fprintf(fp,"%-16s",d_line_loc_lang_short_desc.arr);
// Commented by Aldrin  fprintf(fp,"          ");
    
        print_formated(d_gross_amt,1);

        lno++;
    }


}


print_df_break()
{

    int i;

/*    if(!g_df_first_break) 
	print_subtot();              Commented by Aldrin **/
 
    g_df_first_break=0;
    if(lno > MAX_LINES)  print_next_page();

    d_df_physician_name.arr[0]  = '\0';
    d_df_physician_name.len     = 0;

    /* EXEC SQL SELECT  FULL_NAME
		     INTO    :d_df_physician_name
             FROM    SY_PHYSICIAN_MAST
             WHERE   PHYSICIAN_ID = :d_df_physician_id
			 AND FACILITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST where (\
PHYSICIAN_ID=:b1 and FACILITY_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )575;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_df_physician_name;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_df_physician_id;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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



    d_physician_name.arr[d_physician_name.len]  = '\0';

    for(i = 0; i < HSKIP_15; i++) fprintf(fp," ");

//    fprintf(fp,"~d4x12;");

    fprintf(fp,"       DOCTOR : ");
    /*
    for(i = 0; i < HSKIP_15_1; i++) fprintf(fp," ");
    */
    fprintf(fp,"%-6s %-30s",d_df_physician_id.arr, d_df_physician_name.arr);

//  fprintf(fp,"~d0x4;\n");
    fprintf(fp, "\n");
    
    lno++;

}


print_next_page()
{
    int i;

/*
    fprintf(fp,"\n");

    for(i = 0; i < HSKIP_11; i++ ) fprintf(fp," ");
    fprintf(fp,"C/F BALANCE           :  ");
    print_formated(g_cum_amt,1);
*/
    fprintf(fp,"");

//    Commented By Aldrin for AMH   

//    for(lno; lno < 34; lno++) fprintf(fp,"\n");
//    for(i = 0; i < VSKIP_4; i++) fprintf(fp,"\n");
//    for(i = 0; i < HSKIP_17; i++) fprintf(fp," ");

//    fprintf(fp,"%-3d",pno);

    pno++;

    print_page_head();
/*
    for(i = 0; i < HSKIP_11; i++ ) fprintf(fp," ");
    fprintf(fp,"B/F BALANCE           :  ");
    print_formated(g_cum_amt,1);
    lno = 2;
*/

}

print_balance_due()
{
    int i;
    int no_of_lines;
    double tot_disc_amt   = 0;
    double unadj_prep_amt = 0;
    double prt_cum_amt    = 0;
    char out_str[10][133];
	char l_var[70];
	
//Added by MRAMESH. Date :31-dec-1997
    cur_str.len     = 0;
	cur_str.arr[0]  = '\0';
	sub_cur_str.arr[0]   = '\0';
	sub_cur_str.len      = 0;

 
 /* EXEC SQL select base_currency,
				 base_currency_dec
		   into :cur_str,
		         sub_cur_str
		   from sy_acc_entity
		   where acc_entity_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select base_currency ,base_currency_dec into :b0,:b1  from s\
y_acc_entity where acc_entity_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )602;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cur_str;
 sqlstm.sqhstl[0] = (unsigned int  )10;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_cur_str;
 sqlstm.sqhstl[1] = (unsigned int  )10;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
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



    if(sqlca.sqlcode < 0) 
      err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

    if(sqlca.sqlcode == 1403)
      err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");
	   
    cur_str.arr[cur_str.len] = '\0';
	sub_cur_str.arr[sub_cur_str.len] = '\0';
	 
//
	for(i=0; i<10; i++) out_str[i][0] = '\0';

    if(lno+8 > MAX_LINES) print_next_page();

    unadj_prep_amt = d_tot_prep_paid_amt-(t_prepay_adj_amt + d_prepay_adj_amt);

    for(i = 0; i < HSKIP_12 -21; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    lno++;

    for(i = 0; i <= HSKIP_5; i++) fprintf(fp," ");
    fprintf(fp,"GRAND TOTAL");
    for(i = 0; i <= HSKIP_5+37; i++) fprintf(fp," ");
    print_formated(g_cum_amt,1);
    lno++;
/*
    for(i = 0; i < HSKIP_12; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
*/

    tot_disc_amt = d_serv_disc_amt+d_man_disc_amt+d_overall_disc_amt;


    if(!equal(tot_disc_amt,(double)0)) {
        for(i = 0; i <= HSKIP_5; i++) fprintf(fp," ");
        fprintf(fp,"DISCOUNT");

		/*THE FOLLG ONE LINE IS MODIFIED BY MRAMESH. HSKIP_5 + 40 IS
		  CHANGED AS HSKIP_5+40*/
        for(i = 0; i <= HSKIP_5 + 40; i++) fprintf(fp," ");
        print_formated(-tot_disc_amt,1);                   
        
        lno++;
 
        g_cum_amt -= tot_disc_amt;

	    /*THE FOLLG ONE LINE IS COMMENTED BY MRAMESH*/
        /*  for(i = 0; i < HSKIP_12; i++) fprintf(fp," "); */

		/*THE FOLLG ONE LINE IS ADDED BY MRAMESH TO TAKE CARE OF
		ALIGNMENT */
	    for(i = 0; i < 59; i++) fprintf(fp," ");

        for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
        lno++;

        for(i = 0; i <= HSKIP_5-12; i++) fprintf(fp," ");
      //  fprintf(fp,"                                                                            ");
	    fprintf(fp,"                                                              ");
	    print_formated(g_cum_amt,1);
        lno++;
    }

    if(d_prv_doc_type_code.arr[0]) {
        for(i = 0; i < HSKIP_7; i++) fprintf(fp," ");
        fprintf(fp,"PREVIOUS BILL AMOUNT\n");
        lno++;

        for(i = 0; i < HSKIP_7; i++) fprintf(fp," ");
        fprintf(fp,"%-6s/%-8s",d_prv_doc_type_code.arr,d_prv_doc_num.arr);

        for(i = 0; i < HSKIP_7_1; i++) fprintf(fp," ");
        fprintf(fp,"%10s",d_prv_doc_date.arr);

        for(i = 0; i < HSKIP_7_4 - 21; i++) fprintf(fp," ");
        print_formated(t_bill_amt,1);
        lno++;

        g_cum_amt += t_bill_amt;

        for(i = 0; i < HSKIP_12 - 21; i++) fprintf(fp," ");
        for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
        lno++;

        for(i = 0; i <= HSKIP_5 - 21; i++) fprintf(fp," ");
        fprintf(fp,"                                                              ");
        print_formated(g_cum_amt,1);
        lno++;
    }


   for(i = 0; i < HSKIP_12 - 21; i++) fprintf(fp," ");
   for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");    
   //Commented By Aldrin
    lno++;

    if(!equal(d_prepay_adj_amt+t_prepay_adj_amt,(double)0) ||
       !equal(t_bill_paid_amt,(double)0) ) {

        for(i = 0; i < HSKIP_7; i++) fprintf(fp," ");
        fprintf(fp,"PAYMENT RECEIVED\n");
        lno++;
    }

    if(!equal(d_prepay_adj_amt+t_prepay_adj_amt,(double)0)) {
        fprintf(fp,"              Prepayments                                     ");
        print_formated(-(d_prepay_adj_amt+t_prepay_adj_amt),0);

        if(unadj_prep_amt)
          fprintf(fp,"*\n");
        else
          fprintf(fp,"\n");

        lno++;
        g_cum_amt -= (d_prepay_adj_amt + t_prepay_adj_amt);
    }


    if(!equal(t_bill_paid_amt,(double)0) ) {
        fprintf(fp,"              Amount Paid                                     ");
        print_formated(-t_bill_paid_amt,1);
        g_cum_amt -= t_bill_paid_amt;
        lno++;
    }

/*
    for(i = 0; i < HSKIP_12; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"GRAND TOTAL           :  ");
    print_formated(g_cum_amt,1);

    for(i = 0; i < HSKIP_12; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"Previous Outstanding  :  ");
    print_formated(d_prv_outst_amt,1);
    g_cum_amt += d_prv_outst_amt;
*/
/*
    for(i = 0; i < HSKIP_12; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    lno++;
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"   TOTAL BALANCE DUE     ");
    print_formated(g_cum_amt,1);
    lno++;


    for(i = 0; i < HSKIP_12; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"="); fprintf(fp,"\n");
    lno++;
 */

    prt_cum_amt = (g_cum_amt < 0) ? g_cum_amt * -1 : g_cum_amt;



/********* MODIFIED ON 29/04/1998 BY VENKAT FOR PRINTING CURRENCY *******/
 
   no_of_lines = print_in_words(prt_cum_amt,LENGTH_WORDS,sub_cur_str.arr,out_str);

/************************************************************************/


    for(lno; lno < 23; lno++) fprintf(fp,"\n");
	
	if(prt_cum_amt != 0)
	fprintf(fp,"%-6s",cur_str.arr);

	//   Added by MRAMESH. Date : 31-dec-1997
    for (i =0;i<no_of_lines;i++)
	    fprintf(fp," %s\n",out_str[i]);
   
   //   Commented by MRAMESH. Date : 31-dec-1997
   //   fprintf(fp,"     %s\n",out_str[i]);

    lno = lno + no_of_lines;
    for(lno; lno < 27; lno++) fprintf(fp,"\n");
    for(i = 0; i < HSKIP_16 - 21; i++) fprintf(fp," ");
    print_formated(g_cum_amt,1);
    lno++;
   //  for(i = 0; i < VSKIP_4; i++) fprintf(fp,"\n");
   //  for(i = 0; i < HSKIP_17; i++) fprintf(fp," ");
   //  fprintf(fp,"%-3d\n\n",pno);


   /*
    if( unadj_prep_amt > 0)
    {
       fprintf(fp,"\n*    Balance Prepayment amount HK$ ");
       lno++;
       print_formated(unadj_prep_amt,0);
       lno++;
       fprintf(fp,"will be adjusted\n     in the next bill.");
       lno++;
    }
    */

}


print_subtot()
{
    int i;
/*
    if(lno+3 > MAX_LINES) print_next_page();

    for(i = 0; i < HSKIP_13; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");

    if (g_charge_type_code[0] != '1')
    {
      for(i = 0; i < HSKIP_13_1; i++) fprintf(fp," ");
      print_formated(g_df_sub_tot,1);

      g_df_sub_tot = 0;
      for(i = 0; i < HSKIP_13; i++) fprintf(fp," ");
      for(i = 0; i < 18; i++) fprintf(fp,"-");
      fprintf(fp,"         ");
      lno += 1;
    }
    else {
      for(i = 0; i < HSKIP_14; i++) fprintf(fp," ");
      fprintf(fp," ");
    }
*/
   /* fprintf(fp,"Sub Total             :  "); */

    if(lno > MAX_LINES) print_next_page();
    for(i = 0; i < HSKIP_13; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-");

    for(i = 0; i < HSKIP_14; i++) fprintf(fp," ");

    print_formated(g_sub_tot,1);
    /*fprintf(fp,"\n");*/
    g_sub_tot = 0;
    g_df_sub_tot = 0;
    lno ++;
}


print_df_subtot()
{
    int i;

    for(i = 0; i < HSKIP_13; i++) fprintf(fp," ");
    for(i = 0; i < 18; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    
    for(i = 0; i < HSKIP_13_1; i++) fprintf(fp," ");
    print_formated(g_df_sub_tot);

    g_df_sub_tot = 0;
    lno += 1;
}

print_formated(loc_amount,flg)
double loc_amount;
int flg;
{
   char s_amt[20];
   char prt_str[20];

   sprintf(s_amt,"%15.2f",loc_amount);
   format_amt(s_amt);

/*   if (loc_amount < 0)
   {
      strcpy(prt_str,"-");
      strcat(prt_str,s_amt);
      fprintf(fp,"%15s ",prt_str);
   }
   else                       Commented by Aldrin */
      fprintf(fp,"%15s ",s_amt);
 
   if(flg)
       fprintf(fp,"\n");
}

get_prv_amts()
{

    double tot_bill_amt = 0,
	   tot_bill_paid_amt = 0,
	   tot_prepay_adj_amt = 0;

    strcpy(t_doc_type_code.arr, d_prv_doc_type_code.arr);
    t_doc_type_code.len = strlen(t_doc_type_code.arr);

    strcpy(t_doc_num.arr, d_prv_doc_num.arr);
    t_doc_num.len = strlen(t_doc_num.arr);

    while(t_doc_type_code.arr[0]) {

	/* EXEC SQL SELECT NVL(BILL_AMT,0),
					NVL(BILL_PAID_AMT,0),
					NVL(PREPAY_ADJ_AMT,0),
					BILL_PRV_DOC_TYPE_CODE,
					BILL_PRV_DOC_NUMBER
			 INTO   :t_bill_amt,
					:t_bill_paid_amt,
					:t_prepay_adj_amt,
					:t_doc_type_code,
					:t_doc_num
			 FROM   BL_BILL_HDR
			 WHERE  DOC_TYPE_CODE = :t_doc_type_code
			 AND    DOC_NUM       = :t_doc_num
			 AND    OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(BILL_AMT,0) ,NVL(BILL_PAID_AMT,0) ,NVL(PREPAY_ADJ\
_AMT,0) ,BILL_PRV_DOC_TYPE_CODE ,BILL_PRV_DOC_NUMBER into :b0,:b1,:b2,:b3,:b4 \
 from BL_BILL_HDR where ((DOC_TYPE_CODE=:b3 and DOC_NUM=:b4) and OPERATING_FAC\
ILITY_ID=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )629;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&t_bill_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&t_bill_paid_amt;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&t_prepay_adj_amt;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&t_doc_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&t_doc_num;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&t_doc_type_code;
 sqlstm.sqhstl[5] = (unsigned int  )9;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&t_doc_num;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_facility_id;
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
    	    err_mesg("SELECT failed on table BL_BILL_HDR",0,"");

        if(NO_DATA_FOUND)
	    break;

		tot_bill_amt       += t_bill_amt;
		tot_bill_paid_amt  += t_bill_paid_amt;
		tot_prepay_adj_amt += t_prepay_adj_amt;
    }

    t_bill_amt       = tot_bill_amt;
    t_bill_paid_amt  = tot_bill_paid_amt;
    t_prepay_adj_amt = tot_prepay_adj_amt;

}
