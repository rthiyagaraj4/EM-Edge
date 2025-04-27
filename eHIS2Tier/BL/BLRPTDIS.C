
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
           char  filnam[39];
};
static const struct sqlcxp sqlfpn =
{
    38,
    "C:\\gana\\MLVER2\\PROC\\Raised\\Blrptdis.pc"
};


static unsigned long sqlctx = 806862781;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {10,14};

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
"select EPISODE_ID ,TO_CHAR(ADMISSION_DATE_TIME,'DD/MM/YYYY') ,PATIENT_ID ,CU\
R_WARD_CODE ,CUR_ROOM_NUM ,CUR_BED_NUM ,CUR_PHYSICIAN_ID ,TO_CHAR(DISCHARGE_DA\
TE_TIME,'DD/MM/YYYY HH24:MI')  from IP_EPISODE where ((DISCHARGE_DATE_TIME bet\
ween TO_DATE((:b0||'00:00:00'),'DD/MM/YYYY HH24:MI:SS') and TO_DATE((:b1||'23:\
59:59'),'DD/MM/YYYY HH24:MI:SS') and EPISODE_ID between NVL(:b2,0) and NVL(:b3\
,'99999999')) and FACILITY_ID=:b4) order by EPISODE_ID,PATIENT_ID            ";

 static const char *sq0005 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,NVL(BILL_TOT_\
AMT,0) ,NVL(BILL_TOT_OUTST_AMT,0) ,NVL(BILL_PAID_AMT,0) ,NVL(GROSS_AMT,0) ,((N\
VL(SERV_DISC_AMT,0)+NVL(MAN_DISC_AMT,0))+NVL(OVERALL_DISC_AMT,0)) ,NVL(PREPAY_\
ADJ_AMT,0) ,NVL(DEPOSIT_ADJ_AMT,0) ,NVL(TOT_REFUND_AMT,0) ,NVL(BILL_STATUS,'X'\
) ,DECODE(NVL(BILL_STATUS,'X'),'X','Valid Bill','A','Interfaced to A/R','C','C\
ancelled Bill','D','Interfaced to Deferred Cash Patients','N','Interfaced to A\
/R as consolidated Invoice','S','Superseded Bill') ,BLNG_GRP_ID  from BL_BILL_\
HDR where ((((EPISODE_TYPE in ('I','D') and EPISODE_ID=:b0) and BILL_TRX_TYPE_\
CODE in ('D','A')) and OPERATING_FACILITY_ID=:b1) and NVL(BILL_STATUS,'X') not\
  in ('C','S')) order by DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0004 = 
"select TO_CHAR(NVL(TOT_DEP_PAID_AMT,0),'999,999,990.99') ,NVL(TOT_DEP_PAID_A\
MT,0) ,LTRIM(TO_CHAR(NVL(NUM_OF_DEPS_PAID,0),'0')) ,LAST_DEP_DOC_TYPE_CODE ,LA\
ST_DEP_DOC_NUMBER ,TO_CHAR(LAST_DEP_DOC_DATE,'DD/MM/YYYY') ,NVL(TOT_BUS_MAN_DI\
SC_AMT,0) ,BLNG_GRP_ID ,NVL(AFT_DISCH_PREPAY_BOUN_CLR,0) ,NVL(AFT_DISCH_DEP_BO\
UN_CLR,0) ,NVL(AFT_DISCH_PMNT_BOUN_CLR,0)  from BL_EPISODE_FIN_DTLS where ((EP\
ISODE_TYPE in ('I','D') and EPISODE_ID=:b0) and OPERATING_FACILITY_ID=:b1)    \
       ";

 static const char *sq0006 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,SUBSTR(SHORT_NAME,1,28) ,decode(sub\
str(short_name,29,60),null ,' ',substr(short_name,29,60)) shortname2  from MP_\
PATIENT_MAST where PATIENT_ID=:b0           ";

 static const char *sq0007 = 
"select FULL_NAME  from SY_PHYSICIAN_MAST where (PHYSICIAN_ID=:b0 and FACILIT\
Y_ID=:b1)           ";

 static const char *sq0008 = 
"select SHORT_DESC  from IP_WARD where (WARD_CODE=:b0 and FACILITY_ID=:b1)   \
        ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,175,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,270,0,0,0,0,0,1,0,
51,0,0,3,465,0,9,437,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
86,0,0,5,758,0,9,444,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
109,0,0,4,473,0,9,451,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
132,0,0,3,0,0,13,477,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,
179,0,0,4,0,0,13,526,0,0,11,0,0,1,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
238,0,0,5,0,0,13,598,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
309,0,0,6,198,0,9,726,0,0,1,1,0,1,0,1,9,0,0,
328,0,0,6,0,0,13,739,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
355,0,0,7,96,0,9,752,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
378,0,0,7,0,0,13,761,0,0,1,0,0,1,0,2,9,0,0,
397,0,0,8,84,0,9,768,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
420,0,0,8,0,0,13,776,0,0,1,0,0,1,0,2,9,0,0,
439,0,0,9,128,0,4,966,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/    
/* PROGRAM NAME          : BLRPTDIS.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */  
/* DATE WRITTEN          : 13-AUG-1993                                  */ 
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                       */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */ 
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/************************************************************************/
                                
#include <stdio.h>
#include <string.h>
#include "gl.h"  
#include "bl.h"

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
// #define INIT_MESG "Report Generation In Progress"

/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [91],
			nd_pwd									   [91],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],
            nd_from_date                               [12],
            nd_to_date                                 [12],
            nd_from_adm_no                             [9],
            nd_to_adm_no                               [9],
			nd_operating_facility_id				   [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[12]; } nd_from_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date;

struct { unsigned short len; unsigned char arr[9]; } nd_from_adm_no;

struct { unsigned short len; unsigned char arr[9]; } nd_to_adm_no;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;


   /* VARCHAR bl_ip_episode_id                            [9],
           bl_ip_admission_date_time                   [15],
           bl_ip_patient_id                            [21],
           bl_ip_cur_ward_code                         [5],
           bl_ip_cur_room_num                          [5],
           bl_ip_cur_bed_num                           [9],
           bl_ip_cur_physician_id                      [16],
           bl_ip_discharge_date_time                   [19],

           bl_patient_name_loc_lang                    [61],
           bl_patient_name                             [61],  
		   bl_patient_name1                            [41],
           bl_physician_name                           [41],
           bl_ward_desc                                [16],   
           bl_status_desc                              [51]; */ 
struct { unsigned short len; unsigned char arr[9]; } bl_ip_episode_id;

struct { unsigned short len; unsigned char arr[15]; } bl_ip_admission_date_time;

struct { unsigned short len; unsigned char arr[21]; } bl_ip_patient_id;

struct { unsigned short len; unsigned char arr[5]; } bl_ip_cur_ward_code;

struct { unsigned short len; unsigned char arr[5]; } bl_ip_cur_room_num;

struct { unsigned short len; unsigned char arr[9]; } bl_ip_cur_bed_num;

struct { unsigned short len; unsigned char arr[16]; } bl_ip_cur_physician_id;

struct { unsigned short len; unsigned char arr[19]; } bl_ip_discharge_date_time;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[41]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[41]; } bl_physician_name;

struct { unsigned short len; unsigned char arr[16]; } bl_ward_desc;

struct { unsigned short len; unsigned char arr[51]; } bl_status_desc;


   /* VARCHAR bl_epi_tot_dep_paid_amt                     [23],
           bl_epi_num_of_deps_paid                     [23],
           bl_epi_last_dep_doc_type_cod                [7],
           bl_epi_last_dep_doc_number                  [23],
           bl_epi_last_dep_doc_date                    [13],
		   bl_epi_blng_grp_id                          [2]; */ 
struct { unsigned short len; unsigned char arr[23]; } bl_epi_tot_dep_paid_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_epi_num_of_deps_paid;

struct { unsigned short len; unsigned char arr[7]; } bl_epi_last_dep_doc_type_cod;

struct { unsigned short len; unsigned char arr[23]; } bl_epi_last_dep_doc_number;

struct { unsigned short len; unsigned char arr[13]; } bl_epi_last_dep_doc_date;

struct { unsigned short len; unsigned char arr[2]; } bl_epi_blng_grp_id;


   /* VARCHAR bl_hdr_doc_type_code                        [7],
           bl_hdr_doc_num                              [9],
           bl_hdr_doc_date                             [13],
           bl_hdr_bill_tot_amt_prn                     [23],
           bl_hdr_bill_tot_outst_amt_pr				   [23],
           bl_hdr_bill_paid_amt_prn                    [23],
		   bl_hdr_gross_amt_prn						   [23],
		   bl_hdr_pmnt_recd_amt_prn                    [23],
		   bl_hdr_deposit_adj_amt_prn                  [23],
           bl_hdr_bill_status                          [2],
		   bl_hdr_blng_grp_id                          [3]; */ 
struct { unsigned short len; unsigned char arr[7]; } bl_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_hdr_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_hdr_doc_date;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_bill_tot_amt_prn;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_bill_tot_outst_amt_pr;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_bill_paid_amt_prn;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_gross_amt_prn;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_pmnt_recd_amt_prn;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_deposit_adj_amt_prn;

struct { unsigned short len; unsigned char arr[2]; } bl_hdr_bill_status;

struct { unsigned short len; unsigned char arr[3]; } bl_hdr_blng_grp_id;


    char   nd_zero_bal;

   long    tot_no_pat,
	   tot_no_ar,
	   tot_no_dcp;

   double  bl_hdr_bill_tot_amt,
           bl_hdr_bill_tot_outst_amt,
           bl_hdr_bill_paid_amt,
		   bl_hdr_gross_amt,
		   bl_hdr_ar_amt,
		   bl_hdr_dcp_amt,
		   bl_hdr_serv_disc_amt,
		   bl_hdr_pmnt_recd_amt,
		   bl_hdr_deposit_adj_amt,
		   bl_hdr_tot_disc_amt,
		   bl_hdr_tot_refund_amt,
		   bl_epi_tot_dep_paid_amt_db,

           bl_tot_bill_amt,
           bl_tot_paid_amt,
           bl_tot_outst_amt,
		   bl_tot_bus_man_disc_amt,
	   
		   d_aft_disch_prepay_boun_clr,
		   d_aft_disch_dep_boun_clr,
		   d_aft_disch_pmnt_boun_clr ;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRPTDIS.C-arc   1.0   Apr 19 2007 17:06:50   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRPTDIS.C-arc   1.0   Apr 19 2007 17:06:50   vcm_th  $ sqlda.h 
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


int lctr = 0,pctr = 0;

FILE *fp;

int bill_ctr = 0;

double g_tot_gross_amt,
       g_tot_disc_amt,
       g_tot_dep_amt,
       g_tot_pmnt_amt,
       g_tot_rfnd_amt,
       g_tot_ar_amt,
       g_tot_dcp_amt,
       g_tot_outst_amt,
       g_tot_inh_pmnt_amt,
       g_tot_dis_pmnt_amt,
       g_tot_boun_clr_amt,
       tot_boun_clr_amt;

char   print_buf[100];
#define REP_WIDTH 240
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char rep_title[] = "REPORT OF PATIENTS DISCHARGED";
int rec_ctr, zero_bal;

void proc_main(argc,argv)
char *argv[];
int argc;
{

    if (argc < 4)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
       exit(0);
    }
 
    
     strcpy(nd_pwd.arr,argv[1]);
	 nd_pwd.len = strlen(nd_pwd.arr);

	 /* EXEC sql connect :nd_pwd; */ 

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
  sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
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
}


	  
	  if (sqlca.sqlcode < 0 )
	   {
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
        }
	set_meduser_role(); 

	strcpy(g_pgm_id,"BLRPTDIS");
	strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    strcpy(nd_operating_facility_id.arr,argv[4]);
    nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);
    strcpy(g_facility_id, nd_operating_facility_id.arr);
    
	strcpy(nd_from_date.arr,argv[5]);
    nd_from_date.len = strlen(nd_from_date.arr);

    strcpy(nd_to_date.arr,argv[6]);
    nd_to_date.len = strlen(nd_to_date.arr);

    strcpy(nd_from_adm_no.arr,argv[7]);
    nd_from_adm_no.len = strlen(nd_from_adm_no.arr);

	strcpy(nd_to_adm_no.arr,argv[8]);
    nd_to_adm_no.len = strlen(nd_to_adm_no.arr);

    nd_zero_bal = argv[9][0];

    //fetch_prog_param();
    declare_cur();
    fetch_hosp_name();
    open_file();
     
    open_episode();

    tot_no_pat       = 0;
    tot_no_ar        = 0;
    tot_no_dcp       = 0;
    bl_tot_bill_amt  = 0;
    bl_tot_paid_amt  = 0;
    bl_tot_outst_amt = 0;

    g_tot_gross_amt    = 0;
    g_tot_disc_amt     = 0;
    g_tot_dep_amt      = 0;
    g_tot_pmnt_amt     = 0;    
    g_tot_inh_pmnt_amt = 0;
    g_tot_dis_pmnt_amt = 0;
    g_tot_boun_clr_amt = 0;
    g_tot_rfnd_amt     = 0;
    g_tot_ar_amt       = 0;
    g_tot_dcp_amt      = 0;
    g_tot_outst_amt    = 0;

    while(fetch_episode())
    {
       print_buf[0] = '\0';
       rec_ctr = 0;
       zero_bal = 1;
       fetch_episode_fin();
       prt_rec(0);
       open_bill_hdr();

       while (fetch_bill_hdr()) 
	   {
			prt_rec(1);
            sprintf(print_buf,"%-8s %-20s %-28s ", " ", " ", " ");
       }
       if(!zero_bal) 
	   {
           if(rec_ctr) 
                 prt_rec(2);
           else {
				 fprintf(fp,"%s\n",print_buf);
				 prt_rec(2);
               }
           tot_no_pat++;
       }

    }

    end_of_rep();
    end_prog_msg();

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
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

    return;
}

fetch_prog_param()
{
   nd_from_date.arr[0]     = '\0';
   nd_to_date.arr[0]       = '\0';
   nd_from_adm_no.arr[0]   = '\0';
   nd_to_adm_no.arr[0]     = '\0';

   nd_from_date.len      = 0;
   nd_to_date.len        = 0;
   nd_from_adm_no.len    = 0;
   nd_to_adm_no.len      = 0;


/*-- Y2K correction. Format introduced for 'FROM AND TO' Date prn variable
     as DD/MM/YYYY in form itself. So, no need to format again below also
	 VSK 15/11/1999 */


/*   EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,
                   PARAM3,PARAM4,PARAM5
              INTO :nd_operating_facility_id,
				   :nd_from_date,
                   :nd_to_date,
                   :nd_from_adm_no,
                   :nd_to_adm_no,
				   :nd_zero_bal
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date;

   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   nd_from_date.arr[nd_from_date.len] = '\0';
   nd_to_date.arr[nd_to_date.len] = '\0';
   nd_from_adm_no.arr[nd_from_adm_no.len] = '\0';
   nd_to_adm_no.arr[nd_to_adm_no.len] = '\0';

   strcpy(nd_operating_facility_id.arr,"HG");

   strcpy(g_facility_id, nd_operating_facility_id.arr);
   
   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date;

   if (OERROR)
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
  */ 
}

declare_cur()
{

  char lmsg[200];

  /* sprintf(lmsg,"%s - frmdat %s todate %s -facl", nd_from_date.arr,
                 nd_to_date.arr,nd_operating_facility_id.arr);

	disp_message(ERR_MESG,lmsg);*/

     /* EXEC SQL DECLARE IP_EPISODE_CUR CURSOR FOR
               SELECT EPISODE_ID,
                      TO_CHAR(ADMISSION_DATE_TIME,'DD/MM/YYYY'),
                      PATIENT_ID,
                      CUR_WARD_CODE,
                      CUR_ROOM_NUM,
                      CUR_BED_NUM,
                      CUR_PHYSICIAN_ID,
                      TO_CHAR(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI')
                 FROM IP_EPISODE
                WHERE 
					  DISCHARGE_DATE_TIME BETWEEN TO_DATE(:nd_from_date||'00:00:00','DD/MM/YYYY HH24:MI:SS') 
										  AND	  TO_DATE(:nd_to_date||'23:59:59','DD/MM/YYYY HH24:MI:SS') 
				/oNVL(DISCHARGE_DATE_TIME,
			  TRUNC(DISCHARGE_DATE_TIME))
			  BETWEEN 
			      TO_DATE(:nd_from_date,'DD/MM/YYYY') AND 
						  TO_DATE(:nd_to_date,'DD/MM/YYYY')o/	//deepali 4/8/2004
                  AND EPISODE_ID BETWEEN
                       NVL(:nd_from_adm_no,0) AND NVL(:nd_to_adm_no,'99999999')
				  AND FACILITY_ID = :nd_operating_facility_id
                ORDER BY EPISODE_ID,PATIENT_ID; */ 


     /* EXEC SQL DECLARE BL_EPI_FIN_DTLS_CUR CURSOR FOR
               SELECT TO_CHAR(NVL(TOT_DEP_PAID_AMT,0),'999,999,990.99'),
			          NVL(TOT_DEP_PAID_AMT,0),
                      LTRIM(TO_CHAR(NVL(NUM_OF_DEPS_PAID,0),'0')),
                      LAST_DEP_DOC_TYPE_CODE,
                      LAST_DEP_DOC_NUMBER,
                      TO_CHAR(LAST_DEP_DOC_DATE,'DD/MM/YYYY'),
                      NVL(TOT_BUS_MAN_DISC_AMT,0),
		      BLNG_GRP_ID,
		      NVL(AFT_DISCH_PREPAY_BOUN_CLR,0),
		      NVL(AFT_DISCH_DEP_BOUN_CLR,0),
		      NVL(AFT_DISCH_PMNT_BOUN_CLR,0)
                 FROM BL_EPISODE_FIN_DTLS
                WHERE EPISODE_TYPE IN ('I','D') 
                  AND EPISODE_ID   = :bl_ip_episode_id
				  AND  OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 


     /* EXEC SQL DECLARE BL_HDR_CUR CURSOR FOR
               SELECT DOC_TYPE_CODE,
                      DOC_NUM,
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                      NVL(BILL_TOT_AMT,0),
                      NVL(BILL_TOT_OUTST_AMT,0),
                      NVL(BILL_PAID_AMT,0),
		      NVL(GROSS_AMT,0),
		      NVL(SERV_DISC_AMT,0)+NVL(MAN_DISC_AMT,0)+NVL(OVERALL_DISC_AMT,0),
		      //(NVL(TOT_PAID_AMT,0)-NVL(BILL_PAID_AMT,0))+
		          NVL(PREPAY_ADJ_AMT,0),
		      NVL(DEPOSIT_ADJ_AMT,0),
		      NVL(TOT_REFUND_AMT,0),
                      NVL(BILL_STATUS,'X'),
                      DECODE(NVL(BILL_STATUS,'X'),
                             'X','Valid Bill',
                             'A','Interfaced to A/R',
                             'C','Cancelled Bill',
                             'D','Interfaced to Deferred Cash Patients',
                             'N','Interfaced to A/R as consolidated Invoice',
                             'S','Superseded Bill'),
					  BLNG_GRP_ID	
                 FROM BL_BILL_HDR
                WHERE EPISODE_TYPE in ('I','D')  
                  AND EPISODE_ID   = :bl_ip_episode_id
                 -- AND PATIENT_ID   = :bl_ip_patient_id
                  AND BILL_TRX_TYPE_CODE IN ('D', 'A')		//ADDED u/c 4/8/2004
				  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				  AND NVL(BILL_STATUS,'X') NOT IN ('C','S')
                ORDER BY DOC_TYPE_CODE,DOC_NUM; */ 


    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
                     SUBSTR(SHORT_NAME,1,28),
					 decode(substr(short_name,29,60),NULL,' ',substr(short_name,29,60)) shortname2 
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_ip_patient_id; */ 


    /* EXEC SQL DECLARE BL_DOC_NAME_CUR CURSOR FOR
              SELECT FULL_NAME
                FROM SY_PHYSICIAN_MAST
               WHERE PHYSICIAN_ID = :bl_ip_cur_physician_id
			   AND   FACILITY_ID = :nd_operating_facility_id; */ 


    /* EXEC SQL DECLARE BL_WARD_DESC_CUR CURSOR FOR
              SELECT SHORT_DESC
                FROM IP_WARD
               WHERE WARD_CODE = :bl_ip_cur_ward_code
			   AND   FACILITY_ID = :nd_operating_facility_id; */ 

}

open_episode()
{
    /* EXEC SQL OPEN IP_EPISODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
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
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )14;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )14;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_from_adm_no;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_adm_no;
    sqlstm.sqhstl[3] = (unsigned int  )11;
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
}


    if (OERROR)
         err_mesg("OPEN failed on cursor IP_EPISODE_CUR",0,"");
}

open_bill_hdr()
{
    /* EXEC SQL OPEN BL_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )86;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_ip_episode_id;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_HDR_CUR",0,"");
}

open_cur_epi_fin_dtls()
{
    /* EXEC SQL OPEN BL_EPI_FIN_DTLS_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )109;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_ip_episode_id;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_EPI_FIN_DTLS_CUR",0,"");
}

fetch_episode()
{
bl_ip_episode_id.arr[0]                                           = '\0';
bl_ip_admission_date_time.arr[0]                                  = '\0';
bl_ip_patient_id.arr[0]                                           = '\0';
bl_ip_cur_ward_code.arr[0]                                        = '\0';
bl_ip_cur_room_num.arr[0]                                         = '\0';
bl_ip_cur_bed_num.arr[0]                                          = '\0';
bl_ip_cur_physician_id.arr[0]                                     = '\0';
bl_ip_discharge_date_time.arr[0]                                  = '\0';

bl_ip_episode_id.len                                              = 0;
bl_ip_admission_date_time.len                                     = 0;
bl_ip_patient_id.len                                              = 0;
bl_ip_cur_ward_code.len                                           = 0;
bl_ip_cur_room_num.len                                            = 0;
bl_ip_cur_bed_num.len                                             = 0;
bl_ip_cur_physician_id.len                                        = 0;
bl_ip_discharge_date_time.len                                     = 0;


     /* EXEC SQL FETCH IP_EPISODE_CUR
               INTO :bl_ip_episode_id,
                    :bl_ip_admission_date_time,
                    :bl_ip_patient_id,
                    :bl_ip_cur_ward_code,
                    :bl_ip_cur_room_num,
                    :bl_ip_cur_bed_num,
                    :bl_ip_cur_physician_id,
                    :bl_ip_discharge_date_time; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )132;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_ip_episode_id;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_ip_admission_date_time;
     sqlstm.sqhstl[1] = (unsigned int  )17;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_ip_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_ip_cur_ward_code;
     sqlstm.sqhstl[3] = (unsigned int  )7;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_ip_cur_room_num;
     sqlstm.sqhstl[4] = (unsigned int  )7;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_ip_cur_bed_num;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_ip_cur_physician_id;
     sqlstm.sqhstl[6] = (unsigned int  )18;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_ip_discharge_date_time;
     sqlstm.sqhstl[7] = (unsigned int  )21;
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


     if (OERROR)
         err_mesg("FETCH failed on cursor IP_EPISODE_CUR",0,"");

bl_ip_episode_id.arr[bl_ip_episode_id.len]                               = '\0';
bl_ip_admission_date_time.arr[bl_ip_admission_date_time.len]             = '\0';
bl_ip_patient_id.arr[bl_ip_patient_id.len]                               = '\0';
bl_ip_cur_ward_code.arr[bl_ip_cur_ward_code.len]                         = '\0';
bl_ip_cur_room_num.arr[bl_ip_cur_room_num.len]                           = '\0';
bl_ip_cur_bed_num.arr[bl_ip_cur_bed_num.len]                             = '\0';
bl_ip_cur_physician_id.arr[bl_ip_cur_physician_id.len]                   = '\0';
bl_ip_discharge_date_time.arr[bl_ip_discharge_date_time.len]             = '\0';

    return(LAST_ROW?0:1);
}

fetch_episode_fin()
{

    open_cur_epi_fin_dtls();

bl_epi_tot_dep_paid_amt.arr[0]                                    = '\0';
bl_epi_num_of_deps_paid.arr[0]                                    = '\0';
bl_epi_last_dep_doc_type_cod.arr[0]                              = '\0';
bl_epi_last_dep_doc_number.arr[0]                                 = '\0';
bl_epi_last_dep_doc_date.arr[0]                                   = '\0';
bl_epi_blng_grp_id.arr[0]  = '\0';

bl_epi_tot_dep_paid_amt.len                                       = 0;
bl_epi_num_of_deps_paid.len                                       = 0;
bl_epi_last_dep_doc_type_cod.len                                 = 0;
bl_epi_last_dep_doc_number.len                                    = 0;
bl_epi_last_dep_doc_date.len                                      = 0;
bl_epi_blng_grp_id.len     = 0;

bl_tot_bus_man_disc_amt  = 0;
d_aft_disch_prepay_boun_clr    = 0;
d_aft_disch_dep_boun_clr       = 0;
d_aft_disch_pmnt_boun_clr      = 0;


     /* EXEC SQL FETCH BL_EPI_FIN_DTLS_CUR
               INTO :bl_epi_tot_dep_paid_amt,
			        :bl_epi_tot_dep_paid_amt_db,
                    :bl_epi_num_of_deps_paid,
                    :bl_epi_last_dep_doc_type_cod,
                    :bl_epi_last_dep_doc_number,
                    :bl_epi_last_dep_doc_date,
					:bl_tot_bus_man_disc_amt,
					:bl_epi_blng_grp_id,
					:d_aft_disch_prepay_boun_clr,
					:d_aft_disch_dep_boun_clr,
					:d_aft_disch_pmnt_boun_clr; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )179;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_epi_tot_dep_paid_amt;
     sqlstm.sqhstl[0] = (unsigned int  )25;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_epi_tot_dep_paid_amt_db;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_epi_num_of_deps_paid;
     sqlstm.sqhstl[2] = (unsigned int  )25;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_epi_last_dep_doc_type_cod;
     sqlstm.sqhstl[3] = (unsigned int  )9;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_epi_last_dep_doc_number;
     sqlstm.sqhstl[4] = (unsigned int  )25;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_epi_last_dep_doc_date;
     sqlstm.sqhstl[5] = (unsigned int  )15;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_tot_bus_man_disc_amt;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_epi_blng_grp_id;
     sqlstm.sqhstl[7] = (unsigned int  )4;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_aft_disch_prepay_boun_clr;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_aft_disch_dep_boun_clr;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_aft_disch_pmnt_boun_clr;
     sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
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



bl_epi_tot_dep_paid_amt.arr[bl_epi_tot_dep_paid_amt.len]                 = '\0';
bl_epi_num_of_deps_paid.arr[bl_epi_num_of_deps_paid.len]                 = '\0';
bl_epi_last_dep_doc_type_cod.arr[bl_epi_last_dep_doc_type_cod.len]     = '\0';
bl_epi_last_dep_doc_number.arr[bl_epi_last_dep_doc_number.len]           = '\0';
bl_epi_last_dep_doc_date.arr[bl_epi_last_dep_doc_date.len]               = '\0';
bl_epi_blng_grp_id.arr[bl_epi_blng_grp_id.len]  = '\0';

    return(ROW_COUNT);
}

fetch_bill_hdr()
{

double outst_amt; 

outst_amt = 0;
tot_boun_clr_amt = 0;

bl_hdr_doc_type_code.arr[0]                                       = '\0';
bl_hdr_doc_num.arr[0]                                             = '\0';
bl_hdr_doc_date.arr[0]                                            = '\0';
bl_hdr_bill_tot_amt_prn.arr[0]                                    = '\0';
bl_hdr_bill_tot_outst_amt_pr.arr[0]                              = '\0';
bl_hdr_bill_paid_amt_prn.arr[0]                                   = '\0';
bl_hdr_bill_status.arr[0]                                         = '\0';
bl_status_desc.arr[0]                                             = '\0';
bl_hdr_gross_amt_prn.arr[0]  = '\0';
bl_hdr_pmnt_recd_amt_prn.arr[0]  = '\0';
bl_hdr_deposit_adj_amt_prn.arr[0]  = '\0';

bl_hdr_blng_grp_id.arr[0] = '\0';


bl_hdr_doc_type_code.len                                          = 0;
bl_hdr_doc_num.len                                                = 0;
bl_hdr_doc_date.len                                               = 0;
bl_hdr_bill_tot_amt_prn.len                                       = 0;
bl_hdr_bill_tot_outst_amt_pr.len                                 = 0;
bl_hdr_bill_paid_amt_prn.len                                      = 0;
bl_hdr_bill_status.len                                            = 0;
bl_status_desc.len                                                = 0;
bl_hdr_gross_amt_prn.len     = 0;
bl_hdr_pmnt_recd_amt_prn.len     = 0;
bl_hdr_deposit_adj_amt_prn.len     = 0;

bl_hdr_blng_grp_id.len = 0;

bl_hdr_bill_tot_amt                                               = 0;
bl_hdr_bill_tot_outst_amt                                         = 0;
bl_hdr_bill_paid_amt                                              = 0;
bl_hdr_gross_amt          = 0;
bl_hdr_ar_amt             = 0;
bl_hdr_dcp_amt            = 0;
bl_hdr_serv_disc_amt      = 0;
bl_hdr_pmnt_recd_amt      = 0;
bl_hdr_deposit_adj_amt    = 0;
bl_hdr_tot_refund_amt     = 0;
     
     
     /* EXEC SQL FETCH BL_HDR_CUR
               INTO :bl_hdr_doc_type_code,
                    :bl_hdr_doc_num,
                    :bl_hdr_doc_date,
                    :bl_hdr_bill_tot_amt,
                    :bl_hdr_bill_tot_outst_amt,
                    :bl_hdr_bill_paid_amt,
                    :bl_hdr_gross_amt,
					:bl_hdr_serv_disc_amt,
                    :bl_hdr_pmnt_recd_amt,
                    :bl_hdr_deposit_adj_amt,
					:bl_hdr_tot_refund_amt,
                    :bl_hdr_bill_status,
                    :bl_status_desc,
					:bl_hdr_blng_grp_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )238;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_hdr_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_hdr_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_hdr_doc_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_hdr_bill_tot_amt;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_hdr_bill_tot_outst_amt;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_hdr_bill_paid_amt;
     sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_hdr_gross_amt;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_hdr_serv_disc_amt;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_hdr_pmnt_recd_amt;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_hdr_deposit_adj_amt;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_hdr_tot_refund_amt;
     sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_hdr_bill_status;
     sqlstm.sqhstl[11] = (unsigned int  )4;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_status_desc;
     sqlstm.sqhstl[12] = (unsigned int  )53;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_hdr_blng_grp_id;
     sqlstm.sqhstl[13] = (unsigned int  )5;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
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



bl_hdr_doc_type_code.arr[bl_hdr_doc_type_code.len]                       = '\0';
bl_hdr_doc_num.arr[bl_hdr_doc_num.len]                                   = '\0';
bl_hdr_doc_date.arr[bl_hdr_doc_date.len]                                 = '\0';
bl_hdr_bill_status.arr[bl_hdr_bill_status.len]                           = '\0';
bl_status_desc.arr[bl_status_desc.len]                                   = '\0';

bl_hdr_blng_grp_id.arr[bl_hdr_blng_grp_id.len] = '\0';

bl_hdr_tot_disc_amt = bl_hdr_serv_disc_amt;			// + bl_tot_bus_man_disc_amt;	4/8/2004

tot_boun_clr_amt = d_aft_disch_dep_boun_clr + d_aft_disch_prepay_boun_clr + 
		   d_aft_disch_pmnt_boun_clr;

outst_amt = bl_hdr_gross_amt - (bl_hdr_tot_disc_amt+bl_hdr_deposit_adj_amt+
				bl_hdr_pmnt_recd_amt + bl_hdr_bill_paid_amt +
				tot_boun_clr_amt) + 
				bl_hdr_tot_refund_amt;


//if(bl_hdr_bill_status.arr[0] == 'X' || bl_hdr_bill_status.arr[0] == 'N')	4/8/2004
if(bl_hdr_bill_status.arr[0] == 'A' || bl_hdr_bill_status.arr[0] == 'N')
{
        bl_hdr_ar_amt = outst_amt;
	    if(nd_zero_bal == 'Y') tot_no_ar++;
	    outst_amt = 0;
}
else 
    if(bl_hdr_bill_status.arr[0] == 'D')
	  {
        bl_hdr_dcp_amt = outst_amt;
		if(nd_zero_bal == 'Y')   tot_no_dcp++;
			outst_amt = 0;
	  }

    return(LAST_ROW?0:1);
}

print_rec(ind)
int ind;
{
   if (lctr > 55)
       print_head();

  fetch_dtls();

  if (ind == 0)
  {
     fprintf(fp,"%8s %-10s %-16s %-20s %-16s %-28.28s %-6s %-30s\n",
           bl_ip_episode_id.arr,
           bl_ip_admission_date_time.arr,
           bl_ip_discharge_date_time.arr,
           bl_ip_patient_id.arr,
           bl_patient_name_loc_lang.arr,
           bl_patient_name.arr,
           bl_ip_cur_physician_id.arr,
           bl_physician_name.arr);
		   
		if(strlen(bl_patient_name1.arr) > 2)
		{
		fprintf(fp,"%74s %s \n"," ",bl_patient_name1.arr);
		lctr++;
		}

     fprintf(fp,"         WARD : %-4s %-15s            ROOM : %-4s   BED : %-8s\n",
           bl_ip_cur_ward_code.arr,
           bl_ward_desc.arr,
           bl_ip_cur_room_num.arr,
           bl_ip_cur_bed_num.arr);
    fprintf(fp,"BILL DTLS : ");
    lctr +=2;
 }
 else if (ind == 1)
 {
   bill_ctr++; 
   bl_tot_bill_amt  += bl_hdr_bill_tot_amt;
   bl_tot_paid_amt  += bl_hdr_bill_paid_amt;
   bl_tot_outst_amt += bl_hdr_bill_tot_outst_amt;

    if (bill_ctr != 1)
           fprintf(fp,"            ");
    fprintf(fp,"%-6s %8s %-10s ",
	// %s %s %s %1s %-20s\n",
                 bl_hdr_doc_type_code.arr,
                 bl_hdr_doc_num.arr,
                 bl_hdr_doc_date.arr);
		print_formated(bl_hdr_bill_tot_amt);
		print_formated(bl_hdr_bill_paid_amt);
		print_formated(bl_hdr_bill_tot_outst_amt);
        fprintf(fp,"%1s %-20s\n", bl_hdr_bill_status.arr, bl_status_desc.arr);
   lctr ++;
  }
  else
  {
     fprintf(fp,"%c",(bill_ctr == 0)?'\n':' ');
     lctr += (bill_ctr==0)?1:0;

     fprintf(fp,"DEP DTLS  : %-6s %-8s %-10s ",
	 //%s        %s\n\n",
                 bl_epi_last_dep_doc_type_cod.arr,
                 bl_epi_last_dep_doc_number.arr,
                 bl_epi_last_dep_doc_date.arr);
	 print_formated(bl_epi_tot_dep_paid_amt_db);
	 fprintf(fp,"        %s\n\n",bl_epi_num_of_deps_paid.arr);

   lctr += 2;
   }
  
   fflush(fp);
}

fetch_dtls()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )309;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_ip_patient_id;
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


   if (OERROR)
        err_mesg("OPEN failed on cursor BL_PAT_NAME_CUR",0,"");

   bl_patient_name_loc_lang.arr[0]           = '\0';
   bl_patient_name.arr[0]                    = '\0';
   bl_patient_name1.arr[0]                    = '\0';

   bl_patient_name_loc_lang.len              = 0;
   bl_patient_name.len                       = 0;
   bl_patient_name1.len                       = 0;
   

    /* EXEC SQL FETCH BL_PAT_NAME_CUR
              INTO :bl_patient_name_loc_lang,
                   :bl_patient_name,
				   :bl_patient_name1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )328;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_patient_name_loc_lang;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_patient_name;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_patient_name1;
    sqlstm.sqhstl[2] = (unsigned int  )43;
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
         err_mesg("FETCH failed on cursor BL_PAT_NAME_CUR",0,"");

    bl_patient_name_loc_lang.arr[bl_patient_name_loc_lang.len] = '\0';
    bl_patient_name.arr[bl_patient_name.len] = '\0';
	bl_patient_name1.arr[bl_patient_name1.len] = '\0';


    /* EXEC SQL OPEN BL_DOC_NAME_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )355;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_ip_cur_physician_id;
    sqlstm.sqhstl[0] = (unsigned int  )18;
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



    if (OERROR)
         err_mesg("OPEN failed on cursor BL_DOC_NAME_CUR",0,"");

   bl_physician_name.arr[0]                  = '\0';
   bl_physician_name.len                     = 0;


    /* EXEC SQL FETCH BL_DOC_NAME_CUR
              INTO :bl_physician_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )378;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_physician_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
         err_mesg("FETCH failed on cursor BL_DOC_NAME_CUR",0,"");

    bl_physician_name.arr[bl_physician_name.len] = '\0';

    /* EXEC SQL OPEN BL_WARD_DESC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )397;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_ip_cur_ward_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_DOC_NAME_CUR",0,"");

    bl_ward_desc.arr[0]          = '\0';
    bl_ward_desc.len             = 0;


    /* EXEC SQL FETCH BL_WARD_DESC_CUR
                INTO :bl_ward_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )420;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_ward_desc;
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


    if (OERROR)
         err_mesg("FETCH failed on cursor BL_WARD_DESC_CUR",0,"");

    bl_ward_desc.arr[bl_ward_desc.len] = '\0';
}


end_of_rep()
{
   if (lctr > 48)
       print_head();

    fprintf(fp,"                                                                                ------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
/*
           "99999999 9999999999 XXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXX/99999999 (99) 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99"
*/

    fprintf(fp,"                                                                                 ");
    print_formated(g_tot_gross_amt);
    print_formated(g_tot_disc_amt);
    print_formated(g_tot_dep_amt);
    print_formated(g_tot_inh_pmnt_amt);  
    print_formated(g_tot_dis_pmnt_amt);
    print_formated(g_tot_boun_clr_amt);
    print_formated(g_tot_rfnd_amt);
    print_formated(g_tot_ar_amt);
    print_formated(g_tot_dcp_amt);
    print_formated(g_tot_outst_amt);

    fprintf(fp,"\n");
    fprintf(fp,"                                                                                ==================================================================================================================================================================\n");


fprintf(fp,"\n\n    TOTAL NO. OF PATIENTS            : %5d\n",tot_no_pat);
fprintf(fp,"    NO OF PATIENTS TRANSFERED TO A/R : %5d\n",tot_no_ar);
fprintf(fp,"    NO OF PATIENTS TRANSFERED TO DCP : %5d\n",tot_no_dcp);
/*
fprintf(fp,"    TOTAL BILLED AMOUNT   : "); print_formated(bl_tot_bill_amt);
fprintf(fp,"\n    TOTAL PAID AMOUNT     : "); print_formated(bl_tot_paid_amt);
fprintf(fp,"\n    TOTAL OUTST AMOUNT    : "); print_formated(bl_tot_outst_amt);
*/

fprintf(fp,"\n\n                                                      ***  END OF REPORT ***\n");
fflush(fp);
}

open_file()
{
char filename[30];
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrptdis.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrptdis.lis");
       proc_exit();
    }
    print_title();
    print_head();
}

print_title()
{
form_hdr();
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"          DISCHARGE PROCESS DATE  FROM : %s\n",nd_from_date.arr);
fprintf(fp,"                                   TO  : %s\n\n",nd_to_date.arr);
fprintf(fp,"                  ADMISSION NO    FROM : %s\n",nd_from_adm_no.arr);
fprintf(fp,"                                   TO  : %s\n\n",nd_to_adm_no.arr);
fprintf(fp,"         INCLUDE ZERO BALANCE PATIENTS : %c\n\n",nd_zero_bal);

}

print_head()
{
form_hdr();

fprintf(fp,"ADM NO   PATIENT NUMBER AND NAME                           BILL NO.        GP             BILL                         DEPOSIT         <--PAYMENT RECEIVED-->      AFTER DISCH          REFUND        TRANSFER        TRANSFER          OUTST\n");
fprintf(fp,"         ADM DATE DIS DATE/TIME  WARD BED                                               AMOUNT        DISCOUNT          AMOUNT         PR            AMT PAID     BOUN/CLR AMT          AMOUNT          TO A/R          TO DCP         AMOUNT\n");

/*
           "99999999 9999999999 XXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXX/99999999 (99) 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99 999,999,990.99"
*/
fprintf(fp,"%s\n",hdr_line5);

fflush(fp);
lctr = 10;
}

prt_rec(flg)
{
    double outst_amt;

    outst_amt = 0;

   if (lctr > 55)
       print_head();

	fetch_dtls();

    switch(flg) {

	case 0:
     	
    sprintf(print_buf,"%-8s %-20s %-28.28s ", 
	       bl_ip_episode_id.arr,
	       bl_ip_patient_id.arr, bl_patient_name.arr);

    print_buf[strlen(print_buf)] = '\0';

	       break;

	case 1:

    outst_amt = bl_hdr_gross_amt -
		(bl_hdr_tot_disc_amt+bl_hdr_pmnt_recd_amt+
		 bl_hdr_deposit_adj_amt+bl_hdr_ar_amt+bl_hdr_dcp_amt +
		 bl_hdr_bill_paid_amt + tot_boun_clr_amt) +
                 bl_hdr_tot_refund_amt;
    /*if(equal(outst_amt,(double)0) && nd_zero_bal == 'N')
	break;
*/
    rec_ctr = 1;
    zero_bal = 0;

    fprintf(fp,"%s%-6s/%-8s %2s   ", print_buf,
		bl_hdr_doc_type_code.arr,bl_hdr_doc_num.arr,
                bl_hdr_blng_grp_id.arr);
    print_formated(bl_hdr_gross_amt);
    print_formated(bl_hdr_tot_disc_amt);
    print_formated(bl_hdr_deposit_adj_amt);
    print_formated(bl_hdr_pmnt_recd_amt);
    print_formated(bl_hdr_bill_paid_amt);
    print_formated(tot_boun_clr_amt);
    print_formated(bl_hdr_tot_refund_amt);
    print_formated(bl_hdr_ar_amt);
    print_formated(bl_hdr_dcp_amt);

    //print_formated(outst_amt);				4/8/2004
	print_formated(bl_hdr_bill_tot_outst_amt);

    fprintf(fp,"\n");

    g_tot_gross_amt      += bl_hdr_gross_amt;
    g_tot_disc_amt       += bl_hdr_tot_disc_amt;
    g_tot_dep_amt        += bl_hdr_deposit_adj_amt;
    g_tot_inh_pmnt_amt   += bl_hdr_pmnt_recd_amt;
    g_tot_dis_pmnt_amt   += bl_hdr_bill_paid_amt;
    g_tot_boun_clr_amt   += tot_boun_clr_amt;
    g_tot_rfnd_amt       += bl_hdr_tot_refund_amt;
    g_tot_ar_amt         += bl_hdr_ar_amt;
    g_tot_dcp_amt        += bl_hdr_dcp_amt;
    //g_tot_outst_amt      += outst_amt;				4/8/2004
	g_tot_outst_amt      += bl_hdr_bill_tot_outst_amt;


    lctr ++;
    /*
    prt_rec(2);
    tot_no_pat++;
    */
    break;

	case 2:

    fprintf(fp,"         %10s %14s %-4s %-8s          \n",
           bl_ip_admission_date_time.arr, bl_ip_discharge_date_time.arr,
           bl_ip_cur_ward_code.arr, bl_ip_cur_bed_num.arr);

    lctr ++;
    break;

    }

}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY
			   WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )439;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&hosp_name;
    sqlstm.sqhstl[0] = (unsigned int  )122;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&date_time;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&user_id;
    sqlstm.sqhstl[2] = (unsigned int  )93;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	user_id.arr[user_id.len]               = '\0';
}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        format_amt(s_amt);
		sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
        format_amt(s_amt);
		sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s  ",str_amt);
        }
}

form_hdr()
{

    static int first = 1;
    char buf[15];
    char head[200];
    int col;

    if(first) {
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
        memset(hdr_line4,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL : BL",8);
        col = (int)(REP_WIDTH-strlen(hosp_name.arr))/2;
        strncpy(hdr_line1+col,hosp_name.arr,strlen(hosp_name.arr));
        col = (REP_WIDTH-strlen(date_time.arr));
        strcpy(hdr_line1+col,date_time.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,user_id.arr);

        sprintf(head,"DISCHARGE PROCESS DATE %s TO %s       ADMISSION NO %8s TO %8s\n",
			     nd_from_date.arr,nd_to_date.arr,
                 nd_from_adm_no.arr,nd_to_adm_no.arr);
        col = (REP_WIDTH-strlen(head))/2;
        strcpy(hdr_line4+col,head);
    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : BLRPTDIS",14);
    col = (int)(REP_WIDTH-strlen(rep_title))/2;
    strncpy(hdr_line3+col,rep_title,strlen(rep_title));
    sprintf(buf,"PAGE : %4d",++pctr);
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

    if(first)
        fprintf(fp,"%s\n",hdr_line1);
    else
        fprintf(fp,"\f%s\n",hdr_line1);
    fprintf(fp,"%s\n",hdr_line2);
    fprintf(fp,"%s\n",hdr_line3);
    fprintf(fp,"%s\n",hdr_line4);
    fprintf(fp,"%s\n",hdr_line5);

    first = 0;
}
