
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrrfbls.pc"
};


static unsigned int sqlctx = 1288467891;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {12,14};

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

 static const char *sq0005 = 
"select PATIENT_ID ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,N\
VL(BILL_TOT_AMT,0) ,NVL(BILL_TOT_OUTST_AMT,0) ,NVL(BILL_PAID_AMT,0) ,NVL(GROSS\
_AMT,0) ,NVL(SERV_DISC_AMT,0) ,((NVL(TOT_PAID_AMT,0)-NVL(BILL_PAID_AMT,0))+NVL\
(PREPAY_ADJ_AMT,0)) ,NVL(DEPOSIT_ADJ_AMT,0) ,NVL(TOT_REFUND_AMT,0) ,BILL_STATU\
S ,DECODE(BILL_STATUS,null ,'Valid Bill','A','Interfaced to A/R','C','Cancelle\
d Bill','D','Interfaced to Deferred Cash Patients','N','Interfaced to A/R as c\
onsolidated Invoice','S','Superseded Bill')  from BL_BILL_HDR where ((((EPISOD\
E_TYPE='R' and PATIENT_ID between NVL(:b0,'!!!!!!!!!!!!!!!!!!!!') and NVL(:b1,\
'~~~~~~~~~~~~~~~~~~~~')) and TRUNC(DOC_DATE) between TO_DATE(:b2,'DD/MM/YYYY')\
 and TO_DATE(:b3,'DD/MM/YYYY')) and BILL_TRX_TYPE_CODE='R') and NVL(BILL_STATU\
S,'X') not  in ('C','S')) order by PATIENT_ID,DOC_TYPE_CODE,DOC_NUM           \
 ";

 static const char *sq0006 = 
"select SUBSTR(SHORT_NAME,1,30) PAT_NAME ,decode(substr(short_name,31,60),nul\
l ,' ',substr(short_name,31,60)) shortname2 ,short_name  from MP_PATIENT_MAST \
where PATIENT_ID=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,165,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,281,0,0,0,0,0,1,0,
51,0,0,3,199,0,4,303,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
110,0,0,4,84,0,2,339,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,5,857,0,9,398,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
168,0,0,5,0,0,13,449,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
239,0,0,6,185,0,9,500,0,0,1,1,0,1,0,1,9,0,0,
258,0,0,6,0,0,13,509,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
285,0,0,7,515,0,6,521,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
312,0,0,8,74,0,4,556,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
335,0,0,9,128,0,4,647,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRRFBLS.PC                                    */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 13-AUG-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
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
#include "bl.h"       

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define INIT_MESG "Report Generation In Progress"
/*
#define DEBUG 0
*/

                   
/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [91],
			uid_pwd									   [91],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],
            nd_from_date                               [12],
            nd_to_date                                 [12],
            nd_from_date_prn                           [12],
            nd_to_date_prn                             [12],
            nd_from_pat_no                             [21],
            nd_to_pat_no                               [21],
			nd_operating_facility_id				   [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[12]; } nd_from_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date;

struct { unsigned short len; unsigned char arr[12]; } nd_from_date_prn;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date_prn;

struct { unsigned short len; unsigned char arr[21]; } nd_from_pat_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_pat_no;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;



   /* VARCHAR bl_hdr_patient_id                           [21],
		   bl_hdr_doc_type_code                        [7],
           bl_hdr_doc_num                              [9],
           bl_hdr_doc_date                             [13],
           bl_hdr_bill_tot_amt_prn                     [23],
           bl_hdr_bill_tot_outst_amt_pr				   [23],
           bl_hdr_bill_paid_amt_prn                    [23],
		   bl_hdr_gross_amt_prn                        [23],
		   bl_hdr_pmnt_recd_amt_prn                    [23],
		   bl_hdr_deposit_adj_amt_prn                  [23],
           bl_hdr_bill_status                          [2],

           bl_patient_name_loc_lang                    [61],
           d_short_name_full                           [61],
           bl_patient_name                             [61],
		   bl_patient_name1                            [61],
		   d_blng_grp_id                               [3],
           bl_status_desc                              [51]; */ 
struct { unsigned short len; unsigned char arr[21]; } bl_hdr_patient_id;

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

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[51]; } bl_status_desc;


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

           bl_tot_bill_amt,
           bl_tot_paid_amt,
           bl_tot_outst_amt,
	       bl_tot_bus_man_disc_amt,
	   
		   d_aft_disch_prepay_boun_clr,
		   d_aft_disch_dep_boun_clr,
		   d_aft_disch_pmnt_boun_clr;

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
       tot_boun_clr_amt,
       outst_amt;

char   print_buf[100];
#define REP_WIDTH 160
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char rep_title[] = "REFERRAL BILL SUMMARY REPORT";
int rec_ctr, zero_bal;

char prv_patient_id[11];

void proc_main(argc,argv)
char *argv[];
int argc;
{

    int frst;

    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRRFBLS");

   
    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

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
}



    if(OERROR) {
		disp_message(ORA_MESG,"Unable to connect to oracle.");
		proc_exit();
    }

   set_meduser_role();

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);
    
    start_prog_msg();

    fetch_prog_param();
    declare_cur();
    fetch_hosp_name();
    open_file();
     

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

    open_bill_hdr();

    prv_patient_id[0] = '\0';
    frst = 1;

    while(fetch_bill_hdr()) {

        outst_amt = bl_hdr_gross_amt -
		   (bl_hdr_tot_disc_amt+
		    bl_hdr_ar_amt+bl_hdr_dcp_amt +
		    bl_hdr_bill_paid_amt + tot_boun_clr_amt) +
                    bl_hdr_tot_refund_amt;

        if(equal(outst_amt,(double)0) && nd_zero_bal == 'N')
	    continue;


	chk_break(1);

	if(strcmp(prv_patient_id, bl_hdr_patient_id.arr)) {
            get_pat_name();
            get_blng_grp();
	    fprintf(fp,"%-20s %-30.30s %-2s %-6s/%-8s ",
		      bl_hdr_patient_id.arr,
		      bl_patient_name.arr,
		      d_blng_grp_id.arr,
		      bl_hdr_doc_type_code.arr,
		      bl_hdr_doc_num.arr);

	    strcpy(prv_patient_id, bl_hdr_patient_id.arr);
	}
	else
	    fprintf(fp,"%-10s %-30s %-2s %-6s/%-8s ",
		      "",
		      "",
		      "",
		      bl_hdr_doc_type_code.arr,
		      bl_hdr_doc_num.arr);

        print_formated(bl_hdr_gross_amt);
        print_formated(bl_hdr_tot_disc_amt);
        print_formated(bl_hdr_bill_paid_amt);
        print_formated(bl_hdr_ar_amt);
        print_formated(bl_hdr_dcp_amt);
        print_formated(outst_amt);
        fprintf(fp,"\n");

	if(strlen(bl_patient_name1.arr) > 2)
	{
	 fprintf(fp,"%20s %s \n"," ",bl_patient_name1.arr);
	lctr++;

	}

	lctr ++;

        g_tot_gross_amt      += bl_hdr_gross_amt;
        g_tot_disc_amt       += bl_hdr_tot_disc_amt;
        g_tot_dis_pmnt_amt   += bl_hdr_bill_paid_amt;
        g_tot_ar_amt         += bl_hdr_ar_amt;
        g_tot_dcp_amt        += bl_hdr_dcp_amt;
        g_tot_outst_amt      += outst_amt;

        tot_no_pat++;
    }

    end_of_rep();
    end_prog_msg();

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


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

}

fetch_prog_param()
{
   nd_from_date.arr[0]     = '\0';
   nd_to_date.arr[0]       = '\0';
   nd_from_date_prn.arr[0] = '\0';
   nd_to_date_prn.arr[0]   = '\0';
   nd_from_pat_no.arr[0]   = '\0';
   nd_to_pat_no.arr[0]     = '\0';

   nd_from_date.len      = 0;
   nd_to_date.len        = 0;
   nd_from_date_prn.len  = 0;
   nd_to_date_prn.len    = 0;
   nd_from_pat_no.len    = 0;
   nd_to_pat_no.len      = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,
				   PARAM2,
                   PARAM1,
                   PARAM2,
                   PARAM3,
				   PARAM4,
				   PARAM5
              INTO :nd_operating_facility_id,
			       :nd_from_date,
                   :nd_to_date,
                   :nd_from_date_prn,
                   :nd_to_date_prn,
                   :nd_from_pat_no,
                   :nd_to_pat_no,
		   :nd_zero_bal
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM1 ,PARA\
M2 ,PARAM3 ,PARAM4 ,PARAM5 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_\
PARAM where ((PGM_ID=:b8 and SESSION_ID=:b9) and PGM_DATE=:b10)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_from_date_prn;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_date_prn;
   sqlstm.sqhstl[4] = (unsigned int  )14;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_from_pat_no;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_pat_no;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_zero_bal;
   sqlstm.sqhstl[7] = (unsigned int  )1;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[8] = (unsigned int  )17;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[10] = (unsigned int  )27;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   nd_from_date.arr[nd_from_date.len] = '\0';
   nd_to_date.arr[nd_to_date.len] = '\0';
   nd_from_date_prn.arr[nd_from_date_prn.len] = '\0';
   nd_to_date_prn.arr[nd_to_date_prn.len] = '\0';
   nd_from_pat_no.arr[nd_from_pat_no.len] = '\0';
   nd_to_pat_no.arr[nd_to_pat_no.len] = '\0';

   strcpy(g_facility_id, nd_operating_facility_id.arr);

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )110;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[0] = (unsigned int  )17;
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
   sqlstm.sqhstl[2] = (unsigned int  )27;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
}

declare_cur()
{

     /* EXEC SQL DECLARE BL_HDR_CUR CURSOR FOR
               SELECT PATIENT_ID,
		      DOC_TYPE_CODE,
                      DOC_NUM,
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                      NVL(BILL_TOT_AMT,0),
                      NVL(BILL_TOT_OUTST_AMT,0),
                      NVL(BILL_PAID_AMT,0),
		      NVL(GROSS_AMT,0),
		      NVL(SERV_DISC_AMT,0),
		      (NVL(TOT_PAID_AMT,0)-NVL(BILL_PAID_AMT,0))+
		          NVL(PREPAY_ADJ_AMT,0),
		      NVL(DEPOSIT_ADJ_AMT,0),
		      NVL(TOT_REFUND_AMT,0),
                      BILL_STATUS,
                      DECODE(BILL_STATUS,
                             NULL,'Valid Bill',
                             'A','Interfaced to A/R',
                             'C','Cancelled Bill',
                             'D','Interfaced to Deferred Cash Patients',
                             'N','Interfaced to A/R as consolidated Invoice',
                             'S','Superseded Bill')
                 FROM BL_BILL_HDR
                WHERE EPISODE_TYPE = 'R'
                  AND PATIENT_ID BETWEEN
		       NVL(:nd_from_pat_no,'!!!!!!!!!!!!!!!!!!!!') AND
		       NVL(:nd_to_pat_no,'~~~~~~~~~~~~~~~~~~~~')
		  AND TRUNC(DOC_DATE) BETWEEN
		      TO_DATE(:nd_from_date,'DD/MM/YYYY') AND
	              TO_DATE(:nd_to_date,'DD/MM/YYYY')
                  AND BILL_TRX_TYPE_CODE = 'R'
		  AND NVL(BILL_STATUS,'X') NOT IN ('C','S')
             ORDER BY PATIENT_ID,
		      DOC_TYPE_CODE,
		      DOC_NUM; */ 


    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              SELECT SUBSTR(SHORT_NAME,1,30) PAT_NAME,
			         decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname2 ,
                             short_name
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_hdr_patient_id; */ 

}

open_bill_hdr()
{
    /* EXEC SQL OPEN BL_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )137;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_pat_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_pat_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[3] = (unsigned int  )14;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_HDR_CUR",0,"");
}

fetch_bill_hdr()
{

double l_outst_amt; 

l_outst_amt = 0;
tot_boun_clr_amt = 0;

bl_hdr_patient_id.arr[0]                        = '\0';
bl_hdr_doc_type_code.arr[0]                     = '\0';
bl_hdr_doc_num.arr[0]                           = '\0';
bl_hdr_doc_date.arr[0]                          = '\0';
bl_hdr_bill_tot_amt_prn.arr[0]                  = '\0';
bl_hdr_bill_tot_outst_amt_pr.arr[0]            = '\0';
bl_hdr_bill_paid_amt_prn.arr[0]                 = '\0';
bl_hdr_bill_status.arr[0]                       = '\0';
bl_status_desc.arr[0]                           = '\0';
bl_hdr_gross_amt_prn.arr[0]                     = '\0';
bl_hdr_pmnt_recd_amt_prn.arr[0]                 = '\0';
bl_hdr_deposit_adj_amt_prn.arr[0]               = '\0';

bl_hdr_patient_id.len                           = 0;
bl_hdr_doc_type_code.len                        = 0;
bl_hdr_doc_num.len                              = 0;
bl_hdr_doc_date.len                             = 0;
bl_hdr_bill_tot_amt_prn.len                     = 0;
bl_hdr_bill_tot_outst_amt_pr.len               = 0;
bl_hdr_bill_paid_amt_prn.len                    = 0;
bl_hdr_bill_status.len                          = 0;
bl_status_desc.len                              = 0;
bl_hdr_gross_amt_prn.len                        = 0;
bl_hdr_pmnt_recd_amt_prn.len                    = 0;
bl_hdr_deposit_adj_amt_prn.len                  = 0;

bl_hdr_bill_tot_amt                             = 0;
bl_hdr_bill_tot_outst_amt                       = 0;
bl_hdr_bill_paid_amt                            = 0;
bl_hdr_gross_amt                                = 0;
bl_hdr_ar_amt                                   = 0;
bl_hdr_dcp_amt                                  = 0;
bl_hdr_serv_disc_amt                            = 0;
bl_hdr_pmnt_recd_amt                            = 0;
bl_hdr_deposit_adj_amt                          = 0;
bl_hdr_tot_refund_amt                           = 0;


     /* EXEC SQL FETCH BL_HDR_CUR
               INTO :bl_hdr_patient_id,
		    :bl_hdr_doc_type_code,
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
                    :bl_status_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )168;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_hdr_patient_id;
     sqlstm.sqhstl[0] = (unsigned int  )23;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_hdr_doc_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_hdr_doc_num;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_hdr_doc_date;
     sqlstm.sqhstl[3] = (unsigned int  )15;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_hdr_bill_tot_amt;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_hdr_bill_tot_outst_amt;
     sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_hdr_bill_paid_amt;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_hdr_gross_amt;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_hdr_serv_disc_amt;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_hdr_pmnt_recd_amt;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_hdr_deposit_adj_amt;
     sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_hdr_tot_refund_amt;
     sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_hdr_bill_status;
     sqlstm.sqhstl[12] = (unsigned int  )4;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_status_desc;
     sqlstm.sqhstl[13] = (unsigned int  )53;
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



bl_hdr_patient_id.arr[bl_hdr_patient_id.len]           = '\0';
bl_hdr_doc_type_code.arr[bl_hdr_doc_type_code.len]     = '\0';
bl_hdr_doc_num.arr[bl_hdr_doc_num.len]                 = '\0';
bl_hdr_doc_date.arr[bl_hdr_doc_date.len]               = '\0';
bl_hdr_bill_status.arr[bl_hdr_bill_status.len]         = '\0';
bl_status_desc.arr[bl_status_desc.len]                 = '\0';

bl_hdr_tot_disc_amt = bl_hdr_serv_disc_amt + bl_tot_bus_man_disc_amt;

tot_boun_clr_amt = d_aft_disch_dep_boun_clr + d_aft_disch_prepay_boun_clr + 
		   d_aft_disch_pmnt_boun_clr;

l_outst_amt = bl_hdr_gross_amt - (bl_hdr_tot_disc_amt+bl_hdr_deposit_adj_amt+
				bl_hdr_pmnt_recd_amt + bl_hdr_bill_paid_amt +
				tot_boun_clr_amt) + 
				bl_hdr_tot_refund_amt;

if(bl_hdr_bill_status.arr[0] == 'A' || bl_hdr_bill_status.arr[0] == 'N'){
        bl_hdr_ar_amt = l_outst_amt;
	if(nd_zero_bal == 'Y')
            tot_no_ar++;
	l_outst_amt = 0;
}
else if(bl_hdr_bill_status.arr[0] == 'D'){
        bl_hdr_dcp_amt = l_outst_amt;
	if(nd_zero_bal == 'Y')
            tot_no_dcp++;
	l_outst_amt = 0;
}

    return(LAST_ROW?0:1);
}

get_pat_name()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )239;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_hdr_patient_id;
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

   bl_patient_name.arr[0]  = '\0';
   bl_patient_name1.arr[0]  = '\0';
   bl_patient_name.len     = 0;
   bl_patient_name1.len     = 0;

    /* EXEC SQL FETCH BL_PAT_NAME_CUR
              INTO :bl_patient_name,
			       :bl_patient_name1,
                   :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )258;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_patient_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_patient_name1;
    sqlstm.sqhstl[1] = (unsigned int  )63;
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



    if (OERROR)
         err_mesg("FETCH failed on cursor BL_PAT_NAME_CUR",0,"");

    bl_patient_name.arr[bl_patient_name.len] = '\0';
	bl_patient_name1.arr[bl_patient_name1.len] = '\0';
    d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
   /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :bl_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_name1    := :bl_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 )\
 ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , s\
tr2 ) ; IF str2 IS NOT NULL THEN :bl_patient_name := str2 ; END IF ; blcommon \
. split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS\
 NOT NULL THEN :bl_patient_name1 := str2 ; END IF ; blcommon . split_words ( :\
d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :b\
l_patient_name1 := :bl_patient_name1 || str2 ; end if ; END ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )285;
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
   sqlstm.sqhstv[1] = (         void  *)&bl_patient_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bl_patient_name1;
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


       bl_patient_name.arr[bl_patient_name.len]  = '\0';
       bl_patient_name1.arr[bl_patient_name1.len]  = '\0';

}

get_blng_grp()
{

    /* EXEC SQL SELECT BLNG_GRP_ID
	       INTO :d_blng_grp_id
	       FROM BL_PATIENT_FIN_DTLS
	      WHERE PATIENT_ID = :bl_hdr_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select BLNG_GRP_ID into :b0  from BL_PATIENT_FIN_DTLS whe\
re PATIENT_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )312;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_hdr_patient_id;
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



    if(OERROR)
	err_mesg("SELECT failed on table BL_PATIENT_FIN_DTLS",0,"");

    d_blng_grp_id.arr[d_blng_grp_id.len]  = '\0';
}

end_of_rep()
{
    chk_break(5);
    fprintf(fp,"                                                                       -----------------------------------------------------------------------------------------\n");

    fprintf(fp,"                                                                       ");
    print_formated(g_tot_gross_amt);
    print_formated(g_tot_disc_amt);
    print_formated(g_tot_dis_pmnt_amt);
    print_formated(g_tot_ar_amt);
    print_formated(g_tot_dcp_amt);
    print_formated(g_tot_outst_amt);

    fprintf(fp,"\n");
    fprintf(fp,"                                                                       =========================================================================================\n");
    fprintf(fp,"TOTAL NO OF BILLS : %ld\n", tot_no_pat);

fprintf(fp,"\n\n                                                      ***  END OF REPORT ***\n");
fflush(fp);
}

open_file()
{
char filename[30];
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrrfbls.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrrfbls.lis");
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
fprintf(fp,"                       BILL DATE  FROM : %s\n",nd_from_date_prn.arr);
fprintf(fp,"                                   TO  : %s\n\n",nd_to_date_prn.arr);
fprintf(fp,"                    PATIENT NO    FROM : %s\n",nd_from_pat_no.arr);
fprintf(fp,"                                   TO  : %s\n\n",nd_to_pat_no.arr);
fprintf(fp,"         INCLUDE ZERO BALANCE PATIENTS : %c\n\n",nd_zero_bal);

}

print_head()
{

    form_hdr();

    fprintf(fp,"PATIENT                                                BILL                      BILL                       PAYMENT       TRANSFER       TRANSFER    OUTSTANDING\n");
    fprintf(fp,"NUMBER     PATIENT NAME                                NUMBER                  AMOUNT       DISCOUNT       RECEIVED         TO A/R         TO DCP         AMOUNT\n");


/*
PATIENT                                      BILL                      BILL                       PAYMENT       TRANSFER       TRANSFER    OUTSTANDING
NUMBER     PATIENT NAME                      NUMBER                  AMOUNT       DISCOUNT       RECEIVED         TO A/R         TO DCP         AMOUNT
xxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xx xxxxxx/99999999 999,999,999.99 999,999,999.99 999,999,999.99 999,999,999.99 999,999,999.99 999,999,999.99
*/
fprintf(fp,"%s\n",hdr_line5);

fflush(fp);
lctr = 10;
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT acc_entity_name, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY
			   WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select acc_entity_name ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )335;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
	char s_amt[16], str_amt[16];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        //ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt,"-");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
          //ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s ",str_amt);
        }
}

/*
print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15.2f",loc_amount);
      //ltrim(out_str);
	  str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
      //ltrim(out_str);
	  str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
}
*/
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

        sprintf(head,"BILL DATE %s TO %s         PATIENT NO %10s TO %10s",
                 nd_from_date_prn.arr,nd_to_date_prn.arr,
                 nd_from_pat_no.arr,nd_to_pat_no.arr);
        col = (REP_WIDTH-strlen(head))/2;
        strcpy(hdr_line4+col,head);
    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : BLRRFBLS",14);
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
  
chk_break(nol)
int nol;
{
    if(lctr+nol >= 55) {
        lctr = 1;
	print_head();
    }
}
