
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
           char  filnam[36];
};
static const struct sqlcxp sqlfpn =
{
    35,
    "D:\\Defered Cash Patient\\Blrstmac.pc"
};


static unsigned long sqlctx = 536878621;


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
            void  *sqhstv[15];
   unsigned int   sqhstl[15];
            int   sqhsts[15];
            void  *sqindv[15];
            int   sqinds[15];
   unsigned int   sqharm[15];
   unsigned int   *sqharc[15];
   unsigned short  sqadto[15];
   unsigned short  sqtdso[15];
} sqlstm = {10,15};

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

 static const char *sq0007 = 
"select DOC_TYPE_CODE ,DOC_NUMBER ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DECODE(TRX\
_TYPE_CODE,'1','INV','2','DN','3','CR','4','ADJ','5','REC','6','PAY') ,DOC_AMT\
 ,PAT_DOC_REFERENCE  from BL_DCP_TRN where (((((operating_facility_id=:b0 and \
PATIENT_ID=:b1) and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUMBER=:b3) and trunc(D\
OC_DATE)<=TO_DATE(:b4,'DD/MM/YYYY')) and (ORG_DOC_TYPE_CODE<>DOC_TYPE_CODE and\
 ORG_DOC_NUMBER<>DOC_NUMBER)) order by trunc(DOC_DATE)            ";

 static const char *sq0006 = 
"select BLACK_LISTED_YN ,FINANCIAL_REMARKS  from BL_PATIENT_FIN_DTLS where PA\
TIENT_ID=:b0           ";

 static const char *sq0008 = 
"select sum(DOC_AMT)  from BL_DCP_TRN where ((((operating_facility_id=:b0 and\
 PATIENT_ID=:b1) and ORG_DOC_NUMBER=:b2) and ORG_DOC_TYPE_CODE=:b3) and trunc(\
DOC_DATE)<=TRUNC(to_date(:b4,'DD/MM/YYYY')))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,208,0,0,0,0,0,1,0,
20,0,0,2,128,0,4,225,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
51,0,0,3,245,0,4,266,0,0,13,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
118,0,0,4,91,0,2,305,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
141,0,0,5,0,0,17,366,0,0,1,1,0,1,0,1,97,0,0,
160,0,0,5,0,0,45,369,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
207,0,0,5,0,0,13,447,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,2,3,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
282,0,0,9,523,0,6,486,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
309,0,0,7,454,0,9,522,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
344,0,0,7,0,0,13,544,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,
0,0,
383,0,0,6,99,0,9,575,0,0,1,1,0,1,0,1,9,0,0,
402,0,0,6,0,0,13,580,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
425,0,0,8,209,0,9,599,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
460,0,0,8,0,0,13,604,0,0,1,0,0,1,0,2,4,0,0,
479,0,0,10,0,0,27,873,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.10.01                                              */
/************************************************************************/
/* PROGRAM NAME          : BLRSTMAC.PC                                  */
/* DATE WRITTEN          : 15-JUN-1993                                  */ 
/* Date Modified         : 15/04/1997                                   */
/* CALLED FROM           : BLRSTMAC (FORM)                              */
/*                                                                      */
/* FUNCTION              :                                              */    
/*                                                                          */
/*                                                                      */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        BL_DCP_PENDING_DOC         Query                   */
/*         2.        MP_PATIENT_MAST            Lookup                  */
/*         3.        BL_PATIENT_FIN_DTLS        Lookup                  */
/*         4.        BL_DCP_TRN                 Query                   */
/*         5.        SY_PROG_PARAM              Query/Delete            */
/*                                                                      */
/*  PARAMETERS                                                          */
/*    REPORT_ORDER - 1 PATIENT ID                                       */
/*                   2 ENGLISH NAME (LAST, FIRST, SECOND)               */
/*                   3 LOCAL LANG. NAME (LAST, FIRST, SECOND)           */
/*    AGEING CUTOFF DT                                                  */
/*    FROM PATIENT_ID            |  RANGE OF ROWS TO BE SELECTED.       */
/*    TO   PATIENT_ID            |                                      */
/*    SHOW ASSOCIATED TRNS   Y - ASSOCIATED TRNS WILL BE PRINTED        */
/*                           N - ASSOCIATED TRNS WILL NOT BE PRINTED    */
/*    PRINT ZERO BAL DOCS    Y - ALL DOCS ARE PRINTED                   */
/*                           N - ZERO BAL DOCS ARE NOT PRINTED          */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/************************************************************************/
 
#include <stdio.h>
#include <string.h>     
#include "bl.h"      
    
#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
// #define INIT_MESG "Report Generation In Progress"

/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd                      [132],
	   hosp_name                    [120],
	   date_time                    [20],
	   user_id                      [20],
	   nd_session_id                [16],
	   nd_pgm_date                  [35],
	   nd_pat_details               [3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_pat_details;


   /* VARCHAR nd_order                     [2],
	   nd_facility_id  [3],
	   nd_fm_patient_id             [21],
	   nd_to_patient_id             [21],
	   nd_associated_trn_flag       [2],
	   nd_print_zero_bal_doc_flag   [2],                    
	   nd_nature_from                               [5],
	   nd_nature_to                                 [5],
	   nd_ref_from                                  [11],
	   nd_ref_to                                    [11],
	   nd_cutoff_date                               [11]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_order;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[2]; } nd_associated_trn_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_print_zero_bal_doc_flag;

struct { unsigned short len; unsigned char arr[5]; } nd_nature_from;

struct { unsigned short len; unsigned char arr[5]; } nd_nature_to;

struct { unsigned short len; unsigned char arr[11]; } nd_ref_from;

struct { unsigned short len; unsigned char arr[11]; } nd_ref_to;

struct { unsigned short len; unsigned char arr[11]; } nd_cutoff_date;

	   

   /* VARCHAR bldcp_pend_doc_type_code     [7],
	   bldcp_pend_doc_num           [9],
	   bldcp_pend_doc_date          [12],
	   bldcp_pend_due_date          [12],
	   bldcp_pend_pat_doc_ref       [16],
	   bldcp_pend_patient_id        [21],
	   bldcp_pend_narration         [51],    
	   bldcp_pend_nature_code       [5],
	   bldcp_pend_trx_short_desc    [4],
         d_short_name_full            [61],
	   mp_pat_short_name            [61],
	   mp_pat_short_name1           [61],
	   mp_pat_short_name_loc_lang   [61]; */ 
struct { unsigned short len; unsigned char arr[7]; } bldcp_pend_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bldcp_pend_doc_num;

struct { unsigned short len; unsigned char arr[12]; } bldcp_pend_doc_date;

struct { unsigned short len; unsigned char arr[12]; } bldcp_pend_due_date;

struct { unsigned short len; unsigned char arr[16]; } bldcp_pend_pat_doc_ref;

struct { unsigned short len; unsigned char arr[21]; } bldcp_pend_patient_id;

struct { unsigned short len; unsigned char arr[51]; } bldcp_pend_narration;

struct { unsigned short len; unsigned char arr[5]; } bldcp_pend_nature_code;

struct { unsigned short len; unsigned char arr[4]; } bldcp_pend_trx_short_desc;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name1;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name_loc_lang;


   int     bldcp_pend_amt_sign,bldcp_pend_age_days;

   double  bldcp_pend_doc_amt,
	   bldcp_pend_doc_outst_amt;

   /* VARCHAR patfndt_black_listed_yn      [2],
	   patfndt_fin_remarks          [41]; */ 
struct { unsigned short len; unsigned char arr[2]; } patfndt_black_listed_yn;

struct { unsigned short len; unsigned char arr[41]; } patfndt_fin_remarks;


   /* VARCHAR bldcp_trn_doc_type_code      [7],
	   bldcp_trn_doc_num            [9],
	   bldcp_trn_doc_date           [12],
	   bldcp_trn_pat_doc_ref        [16],
	   bldcp_trn_trx_short_desc     [4]; */ 
struct { unsigned short len; unsigned char arr[7]; } bldcp_trn_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bldcp_trn_doc_num;

struct { unsigned short len; unsigned char arr[12]; } bldcp_trn_doc_date;

struct { unsigned short len; unsigned char arr[16]; } bldcp_trn_pat_doc_ref;

struct { unsigned short len; unsigned char arr[4]; } bldcp_trn_trx_short_desc;


   double  bldcp_trn_doc_amt;

   char    sql_stmt                     [2000];      
   char    string_var                                   [70];  
   char    out_str[30],
		   out_str1[30],
		   g_facility_id[3]; 

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

double nd_open_credit,
       pat_d_open_credit,
       pat_d_tot_bal,
       rep_d_open_credit,
       rep_d_tot_bal;

char old_patient_id     [21];
char filename[150];

FILE *fp;
int lctr = 0,pctr =0, pend_doc_ctr = 0;
long pat_pend_doc_ctr, pat_ctr, assoc_trn_ctr;

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc < 5)
   {
      list_args(argc, argv);
      proc_exit();
   }

   strcpy(g_pgm_id,"BLRSTMAC");

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
	 disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
   set_meduser_role();
   fetch_param();
   start_prog_msg();
   fetch_desc();
   open_files();
   declare_cursors();
   old_patient_id[0] = '\0'; pend_doc_ctr     = 0;
   pat_ctr           =    0; pat_pend_doc_ctr = 0;


   while(fetch_pending_doc())
   {
      get_other_details(); 
      get_outst_details();
      pend_doc_ctr++;
      if (strcmp(old_patient_id,bldcp_pend_patient_id.arr))
      {
	      pat_ctr++;
	      if (strlen(old_patient_id))
		   print_pat_footer();
	      print_pat_det();
	      strcpy(old_patient_id,bldcp_pend_patient_id.arr);
      }
      process_det();
      print_pend_doc();
      if (nd_associated_trn_flag.arr[0]=='Y')
      {
	 assoc_trn_ctr = 0;
	 open_trn();
	 while (fetch_trn())
	 {
	    assoc_trn_ctr ++;
	    print_trn();
	 }
	 if (assoc_trn_ctr > 0)
	    print_trn_footer();
      }
   }
   if (pend_doc_ctr > 0)
       print_pat_footer();
   print_report_footer();
   print_end();
   end_prog_msg();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/***************** Database Access & Updation Functions ***********************/
fetch_desc()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;

  
   

   /* EXEC SQL SELECT ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		   USER
	       INTO :hosp_name, :date_time, :user_id
	       FROM SY_ACC_ENTITY
   		   where ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
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
   sqlstm.sqhstl[2] = (unsigned int  )22;
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


		   //and language_id =:p_language_id;

   if (OERROR)
	 err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';

}

fetch_param()
{
   nd_fm_patient_id.arr[0]       = '\0';
   nd_to_patient_id.arr[0]       = '\0';
   nd_order.arr[0]               = '\0'; 
   nd_nature_from.arr[0]                 = '\0';  
   nd_nature_to.arr[0]                   = '\0';
   nd_ref_from.arr[0]                    = '\0';
   nd_ref_to.arr[0]                              = '\0';
   nd_cutoff_date.arr[0]                 = '\0';
   nd_facility_id.arr[0]  = '\0';
  

   nd_fm_patient_id.len          = 0;
   nd_to_patient_id.len          = 0;
   nd_order.len                  = 0;
   nd_nature_from.len                    = 0;
   nd_nature_to.len                          = 0;
   nd_ref_from.len                               = 0;
   nd_ref_to.len                                 = 0;
   nd_cutoff_date.len                    = 0;
   nd_facility_id.len  = 0;



   /* EXEC SQL SELECT OPERATING_FACILITY_ID,PARAM1,PARAM2,PARAM3, PARAM4, PARAM5,
				   PARAM6,PARAM7,PARAM8,PARAM9,PARAM10
	      INTO :nd_facility_id,:nd_order,
		   :nd_fm_patient_id,
		   :nd_to_patient_id,
		   :nd_associated_trn_flag,
		   :nd_print_zero_bal_doc_flag,
		   :nd_nature_from,
		   :nd_nature_to,
		   :nd_ref_from,
		   :nd_ref_to,
		   :nd_cutoff_date
	      FROM SY_PROG_PARAM
	     WHERE PGM_ID     = 'BLRSTMAC'
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 into :b0,:b1,:b2,:b3,:b4,:\
b5,:b6,:b7,:b8,:b9,:b10  from SY_PROG_PARAM where ((PGM_ID='BLRSTMAC' and SESS\
ION_ID=:b11) and PGM_DATE=:b12)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_order;
   sqlstm.sqhstl[1] = (unsigned int  )4;
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
   sqlstm.sqhstv[4] = (         void  *)&nd_associated_trn_flag;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_print_zero_bal_doc_flag;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_nature_from;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_nature_to;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_ref_from;
   sqlstm.sqhstl[8] = (unsigned int  )13;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_ref_to;
   sqlstm.sqhstl[9] = (unsigned int  )13;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[11] = (unsigned int  )18;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[12] = (unsigned int  )37;
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
}



   if (OERROR)
	err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
	err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_order.arr[nd_order.len]                                     = '\0';
   nd_fm_patient_id.arr[nd_fm_patient_id.len]                     = '\0';
   nd_to_patient_id.arr[nd_to_patient_id.len]                     = '\0';
   nd_associated_trn_flag.arr[nd_associated_trn_flag.len]         = '\0';
   nd_print_zero_bal_doc_flag.arr[nd_print_zero_bal_doc_flag.len] = '\0';
   nd_nature_from.arr[nd_nature_from.len]                                                 = '\0';
   nd_nature_to.arr[nd_nature_to.len]                                                     = '\0';
   nd_ref_from.arr[nd_ref_from.len]                                                               = '\0';
   nd_ref_to.arr[nd_ref_to.len]                                                                   = '\0';
   nd_cutoff_date.arr[nd_cutoff_date.len]                                                 = '\0';
   

}

delete_param()
{
    /* EXEC SQL DELETE FROM SY_PROG_PARAM
		   WHERE PGM_ID     = 'BLRSTMAC'
		     AND SESSION_ID = :nd_session_id
		     AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRSTMAC' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )118;
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

}

declare_cursors()
{
      strcpy(sql_stmt,"SELECT A.PATIENT_ID, ORG_DOC_TYPE_CODE, \
   ORG_DOC_NUMBER, TO_CHAR(ORG_DOC_DATE,'DD/MM/YYYY'), \
   TO_CHAR(DUE_DATE,'DD/MM/YYYY'), \
   DECODE(TRX_TYPE_CODE,'1','INV','2','DN','3','CR','4','ADJ', \
   '5','REC','6','PAY'), \
   CEIL(NVL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),trunc(SYSDATE)) - trunc(ORG_DOC_DATE)), \
   SIGN(NVL(DOC_OUTST_AMT,0)),DOC_AMT,DOC_OUTST_AMT,PAT_DOC_REFERENCE, \
   NARRATION,DOC_NATURE_CODE,/*substr(B.SHORT_NAME,1,30), substr(B.SHORT_NAME,31,60),*/ B.SHORT_NAME_LOC_LANG ,b.short_name\
   FROM BL_DCP_PENDING_DOC A,MP_PATIENT_MAST B \
   WHERE A.operating_facility_id = :nd_facility_id AND \
   A.PATIENT_ID BETWEEN NVL(:nd_fm_patient_id, \
   '        ') AND NVL(:nd_to_patient_id,'~~~~~~~~~~~~~~~~') \
   AND (Nvl(A.DOC_NATURE_CODE,'!!!!') BETWEEN NVL(:nd_nature_from,'    ') AND NVL(:nd_nature_to,'~~~~') ");

      if (strlen(nd_nature_from.arr) == 0 || strlen(nd_nature_to.arr) == 0) 
       strcat(sql_stmt,"  OR A.DOC_NATURE_CODE IS NULL) ");
      else
       strcat(sql_stmt," )");  
   
   strcat(sql_stmt,"  AND (A.PAT_DOC_REFERENCE BETWEEN NVL(:nd_ref_from,'          ') AND NVL(:nd_ref_to,'~~~~~~~~~~') ");

      if (strlen(nd_ref_from.arr) == 0 || strlen(nd_ref_to.arr) == 0) 
       strcat(sql_stmt,"  OR A.PAT_DOC_REFERENCE IS NULL) ");
      else
       strcat(sql_stmt," )");  
  
   
   strcat(sql_stmt,"  AND A.PATIENT_ID = B.PATIENT_ID \
   AND trunc(ORG_DOC_DATE) <= TRUNC(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY')) ");
   
   if (nd_print_zero_bal_doc_flag.arr[0]=='N')
      strcat(sql_stmt, " AND DOC_OUTST_AMT != 0 ");

   switch (nd_order.arr[0]) {
   case '1' :
     strcat(sql_stmt,"ORDER BY A.PATIENT_ID,ORG_DOC_TYPE_CODE,ORG_DOC_NUMBER ");
     break;
   case '2' :
     strcat(sql_stmt,"ORDER BY SHORT_NAME, \
	     ORG_DOC_TYPE_CODE, ORG_DOC_NUMBER ");
     break;
   case '3' :
     strcat(sql_stmt,"ORDER BY SHORT_NAME_LOC_LANG, \
	     ORG_DOC_TYPE_CODE, ORG_DOC_NUMBER ");
     break;

   }    

		      
   /* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )141;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)sql_stmt;
   sqlstm.sqhstl[0] = (unsigned int  )2000;
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



   /* EXEC SQL DECLARE BL_DCP_PENDING_DOC_CUR CURSOR FOR S; */ 

   /* EXEC SQL OPEN BL_DCP_PENDING_DOC_CUR USING :nd_cutoff_date,
											  :nd_facility_id,		
											  :nd_fm_patient_id,
					      :nd_to_patient_id,  
					      :nd_nature_from,
					      :nd_nature_to,
					      :nd_ref_from,
					      :nd_ref_to ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )160;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[0] = (unsigned int  )13;
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
   sqlstm.sqhstv[4] = (         void  *)&nd_nature_from;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_nature_to;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_ref_from;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_ref_to;
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
}


					     
   if (OERROR)
      err_mesg("OPEN FAILED ON CURSOR BL_DCL_PENDING_DOC_CUR",0,"");

   /* EXEC SQL DECLARE BL_PATIENT_FIN_DTLS_CUR CURSOR FOR 
   SELECT BLACK_LISTED_YN, FINANCIAL_REMARKS
   FROM   BL_PATIENT_FIN_DTLS
   WHERE  PATIENT_ID = :bldcp_pend_patient_id; */ 


   /* EXEC SQL DECLARE BL_DCP_TRN_CUR CURSOR FOR
   SELECT DOC_TYPE_CODE, DOC_NUMBER, TO_CHAR(DOC_DATE, 'DD/MM/YYYY'),
	  DECODE(TRX_TYPE_CODE,'1','INV','2','DN','3','CR','4','ADJ', 
			       '5','REC','6','PAY'),
	  DOC_AMT, PAT_DOC_REFERENCE
   FROM   BL_DCP_TRN
   WHERE  operating_facility_id = :nd_facility_id AND
   PATIENT_ID = :bldcp_pend_patient_id
   AND    ORG_DOC_TYPE_CODE = :bldcp_pend_doc_type_code
   AND    ORG_DOC_NUMBER    = :bldcp_pend_doc_num
   AND    trunc(DOC_DATE) <= TO_DATE(:nd_cutoff_date,'DD/MM/YYYY')
   AND    (ORG_DOC_TYPE_CODE != DOC_TYPE_CODE
   AND ORG_DOC_NUMBER != DOC_NUMBER)
   ORDER BY trunc(DOC_DATE); */ 
     
   
   
   /* Cursor for Exact Outstanding from bl_dcp_trn table */
   
   /* EXEC SQL DECLARE BL_DCP_TRN_CUR1 CURSOR FOR
   SELECT SUM(DOC_AMT) FROM BL_DCP_TRN
   WHERE operating_facility_id = :nd_facility_id AND
   PATIENT_ID = :bldcp_pend_patient_id AND
   ORG_DOC_NUMBER = :bldcp_pend_doc_num AND  
   ORG_DOC_TYPE_CODE = :bldcp_pend_doc_type_code AND   
   trunc(DOC_DATE) <= TRUNC(to_date(:nd_cutoff_date,'DD/MM/YYYY')) ; */ 

}

int fetch_pending_doc()
{
  bldcp_pend_patient_id.arr[0]          = '\0';
  bldcp_pend_doc_type_code.arr[0]       = '\0';
  bldcp_pend_doc_num.arr[0]             = '\0';
  bldcp_pend_doc_date.arr[0]            = '\0';
  bldcp_pend_due_date.arr[0]            = '\0';
  bldcp_pend_trx_short_desc.arr[0]      = '\0'; 
  bldcp_pend_pat_doc_ref.arr[0]         = '\0';
  bldcp_pend_narration.arr[0]           = '\0';
  bldcp_pend_nature_code.arr[0]                 = '\0';
  mp_pat_short_name.arr[0]              = '\0'; 
  mp_pat_short_name1.arr[0]              = '\0'; 
  mp_pat_short_name_loc_lang.arr[0]     = '\0';

  bldcp_pend_patient_id.len             = 0;
  bldcp_pend_doc_type_code.len          = 0;
  bldcp_pend_doc_num.len                = 0;
  bldcp_pend_doc_date.len               = 0;
  bldcp_pend_due_date.len               = 0;
  bldcp_pend_trx_short_desc.len         = 0;
  bldcp_pend_pat_doc_ref.len            = 0;
  bldcp_pend_narration.len              = 0;   
  bldcp_pend_nature_code.len                    = 0;
  mp_pat_short_name.len                 = 0;
  mp_pat_short_name1.len                 = 0;
  mp_pat_short_name_loc_lang.len        = 0;

  bldcp_pend_amt_sign                   = 0;
  bldcp_pend_age_days                                   = 0;
  bldcp_pend_doc_amt                    = 0;
  bldcp_pend_doc_outst_amt              = 0;    
  

      /* EXEC SQL FETCH BL_DCP_PENDING_DOC_CUR
	       INTO  :bldcp_pend_patient_id,
		     :bldcp_pend_doc_type_code,
		     :bldcp_pend_doc_num,
		     :bldcp_pend_doc_date,
		     :bldcp_pend_due_date,
		     :bldcp_pend_trx_short_desc, 
		     :bldcp_pend_age_days,
		     :bldcp_pend_amt_sign,
		     :bldcp_pend_doc_amt,
		     :bldcp_pend_doc_outst_amt,
		     :bldcp_pend_pat_doc_ref,
		     :bldcp_pend_narration, 
		     :bldcp_pend_nature_code,
		     //:mp_pat_short_name,
			 //:mp_pat_short_name1,
		     :mp_pat_short_name_loc_lang,
                 :d_short_name_full; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 15;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )207;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bldcp_pend_patient_id;
      sqlstm.sqhstl[0] = (unsigned int  )23;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bldcp_pend_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bldcp_pend_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bldcp_pend_doc_date;
      sqlstm.sqhstl[3] = (unsigned int  )14;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bldcp_pend_due_date;
      sqlstm.sqhstl[4] = (unsigned int  )14;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bldcp_pend_trx_short_desc;
      sqlstm.sqhstl[5] = (unsigned int  )6;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bldcp_pend_age_days;
      sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bldcp_pend_amt_sign;
      sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&bldcp_pend_doc_amt;
      sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&bldcp_pend_doc_outst_amt;
      sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&bldcp_pend_pat_doc_ref;
      sqlstm.sqhstl[10] = (unsigned int  )18;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&bldcp_pend_narration;
      sqlstm.sqhstl[11] = (unsigned int  )53;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&bldcp_pend_nature_code;
      sqlstm.sqhstl[12] = (unsigned int  )7;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&mp_pat_short_name_loc_lang;
      sqlstm.sqhstl[13] = (unsigned int  )63;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&d_short_name_full;
      sqlstm.sqhstl[14] = (unsigned int  )63;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
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



  if (LAST_ROW)
      return(0);
  else if (OERROR)
	    err_mesg("FETCH failed on cursor BL_DCP_PENDING_DOC_CUR",0,"");


  bldcp_pend_patient_id.arr[bldcp_pend_patient_id.len]                   = '\0';
  bldcp_pend_doc_type_code.arr[bldcp_pend_doc_type_code.len]             = '\0';
  bldcp_pend_doc_num.arr[bldcp_pend_doc_num.len]                         = '\0';
  bldcp_pend_doc_date.arr[bldcp_pend_doc_date.len]                       = '\0';
  bldcp_pend_due_date.arr[bldcp_pend_due_date.len]                       = '\0';
  bldcp_pend_trx_short_desc.arr[bldcp_pend_trx_short_desc.len]           = '\0';
  bldcp_pend_pat_doc_ref.arr[bldcp_pend_pat_doc_ref.len]                 = '\0';
  bldcp_pend_narration.arr[bldcp_pend_narration.len]                     = '\0';
  bldcp_pend_nature_code.arr[bldcp_pend_nature_code.len]                                 = '\0';
  mp_pat_short_name.arr[mp_pat_short_name.len]                           = '\0';
  mp_pat_short_name1.arr[mp_pat_short_name1.len]                           = '\0';
  mp_pat_short_name_loc_lang.arr[mp_pat_short_name_loc_lang.len]         = '\0';
  d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
    /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :mp_pat_short_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :mp_pat_short_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :mp_pat_short_name1    := :mp_pat_short_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 \
) ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , \
str2 ) ; IF str2 IS NOT NULL THEN :mp_pat_short_name := str2 ; END IF ; blcomm\
on . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2\
 IS NOT NULL THEN :mp_pat_short_name1 := str2 ; END IF ; blcommon . split_word\
s ( :d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL TH\
EN :mp_pat_short_name1 := :mp_pat_short_name1 || str2 ; end if ; END ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )282;
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
    sqlstm.sqhstv[1] = (         void  *)&mp_pat_short_name;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&mp_pat_short_name1;
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


       mp_pat_short_name.arr[mp_pat_short_name.len]  = '\0';
       mp_pat_short_name1.arr[mp_pat_short_name1.len]  = '\0';


      return(1);
}

open_trn()
{
   /* EXEC SQL OPEN BL_DCP_TRN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )309;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bldcp_pend_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bldcp_pend_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bldcp_pend_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_cutoff_date;
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


   
   if(OERROR) 
     err_mesg("OPEN failed on cursor BL_DCP_TRN_CUR",0,"");
}

fetch_trn()
{
   bldcp_trn_doc_type_code.arr[0]       = '\0';
   bldcp_trn_doc_num.arr[0]             = '\0';
   bldcp_trn_doc_date.arr[0]            = '\0';
   bldcp_trn_trx_short_desc.arr[0]      = '\0';
   bldcp_trn_pat_doc_ref.arr[0]         = '\0';
 
   bldcp_trn_doc_type_code.len          = 0;
   bldcp_trn_doc_num.len                = 0;
   bldcp_trn_doc_date.len               = 0;
   bldcp_trn_trx_short_desc.len         = 0;
   bldcp_trn_pat_doc_ref.len            = 0;
 
   bldcp_trn_doc_amt                    = 0;

   /* EXEC SQL FETCH BL_DCP_TRN_CUR INTO :bldcp_trn_doc_type_code,
				      :bldcp_trn_doc_num, 
				      :bldcp_trn_doc_date, 
				      :bldcp_trn_trx_short_desc,
				      :bldcp_trn_doc_amt,
				      :bldcp_trn_pat_doc_ref; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )344;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bldcp_trn_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bldcp_trn_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bldcp_trn_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bldcp_trn_trx_short_desc;
   sqlstm.sqhstl[3] = (unsigned int  )6;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&bldcp_trn_doc_amt;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&bldcp_trn_pat_doc_ref;
   sqlstm.sqhstl[5] = (unsigned int  )18;
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


					  
   if (OERROR)
      err_mesg("FETCH failed on cursor BL_DCP_TRN_CUR",0,"");

  bldcp_trn_doc_type_code.arr[bldcp_trn_doc_type_code.len]             = '\0';
  bldcp_trn_doc_num.arr[bldcp_trn_doc_num.len]                         = '\0';
  bldcp_trn_doc_date.arr[bldcp_trn_doc_date.len]                       = '\0';
  bldcp_trn_trx_short_desc.arr[bldcp_trn_trx_short_desc.len]           = '\0';
  bldcp_trn_pat_doc_ref.arr[bldcp_trn_pat_doc_ref.len]                 = '\0';

  if (LAST_ROW)
      return(0);
  else
      return(1);
}

get_other_details()
{
   patfndt_black_listed_yn.arr[0] = '\0';
   patfndt_fin_remarks.arr[0]     = '\0';
   
   patfndt_black_listed_yn.len    = 0;
   patfndt_fin_remarks.len        = 0;


   /* EXEC SQL OPEN BL_PATIENT_FIN_DTLS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )383;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bldcp_pend_patient_id;
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
      err_mesg("OPEN failed on cursor BL_PATIENT_FIN_DTLS",0,"");

   /* EXEC SQL FETCH BL_PATIENT_FIN_DTLS_CUR INTO :patfndt_black_listed_yn,
					       :patfndt_fin_remarks; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )402;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&patfndt_black_listed_yn;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&patfndt_fin_remarks;
   sqlstm.sqhstl[1] = (unsigned int  )43;
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
      err_mesg("FETCH failed on cursor BL_PATIENT_FIN_DTLS",0,"");

   patfndt_black_listed_yn.arr[patfndt_black_listed_yn.len] = '\0';
   patfndt_fin_remarks.arr[patfndt_fin_remarks.len]         = '\0';
}


/* This function will find out the exact outstanding
   as of that cut-off date  for the age */   

get_outst_details()
{    
   bldcp_pend_doc_outst_amt = 0;                               

   /* EXEC SQL OPEN BL_DCP_TRN_CUR1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )425;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bldcp_pend_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bldcp_pend_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bldcp_pend_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_cutoff_date;
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


   
   if (OERROR)
      err_mesg("OPEN failed on cursor BL_DCP_TRN_CUR1",0,"");

   /* EXEC SQL FETCH BL_DCP_TRN_CUR1 INTO :bldcp_pend_doc_outst_amt ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )460;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bldcp_pend_doc_outst_amt;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
      err_mesg("FETCH failed on cursor BL_DCP_TRN_CUR1",0,"");

 /*  bldcp_pend_doc_outst_amt =   bldcp_pend_doc_amt + bldcp_pend_doc_outst_amt;  */
    
   if (bldcp_pend_doc_outst_amt < 0)
		  bldcp_pend_amt_sign = -1 ;
   else if (bldcp_pend_doc_outst_amt == 0)
		  bldcp_pend_amt_sign = 0;
   else
		  bldcp_pend_amt_sign = 1; 
} 


process_det()
{
    nd_open_credit             = 0;
    if (bldcp_pend_amt_sign == -1)
    {
	   nd_open_credit     = bldcp_pend_doc_outst_amt;
	   pat_d_open_credit += bldcp_pend_doc_outst_amt;
    }
    pat_d_tot_bal += bldcp_pend_doc_outst_amt;
}

/*********************** File Handling & Printing Functions *******************/
open_files()
{

	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrstmac.lis");


 // char *file_name = "blrstmac.lis", err_stmt[70];

   if ((fp = fopen(filename,"w")) == NULL)
   {
	// sprintf(err_stmt,"Error while opening File %s",file_name);
//	sprintf(string_var,"Error while opening File %s",filename);
	// err_mesg(err_stmt,0,"");
	disp_message(ERR_MESG,"Error while opening File");
	proc_exit();
   }

   print_title();
   print_head();

}

print_title()
{
  fprintf(fp, "\n\nMDL : BL %39s %-30s %34s  %-15s\n",
      " ", hosp_name.arr," ", date_time.arr);
  fprintf(fp, "OPR : %-10s                 %s\n",
     user_id.arr, "STATEMENT OF ACCOUNTS REPORT (DEFERRED CASH PATIENTS ONLY)");
  fprintf(fp, "REP : %-8s %35s  %-28s %39s PAGE : %4d\n", g_pgm_id, " ", 
    nd_associated_trn_flag.arr[0]=='Y'?" (WITH ASSOCIATED TRXS)"
				      :"(WITHOUT ASSOCIATED TRXS)","", ++pctr);
  fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  fprintf(fp,"VER : 1.10.01\n");
  fflush(fp);

  fprintf(fp,"\n\n\n\n        INPUT PARAMETERS \n        ----------------\n\n");
  fprintf(fp," %14s FACILITY ID         : %s\n\n"," ", nd_facility_id.arr);
  fprintf(fp," %14s REPORT ORDER        : %s\n\n"," ", nd_order.arr);
  if ((strcmp(nd_fm_patient_id.arr,"") == 0) && (strcmp(nd_to_patient_id.arr,"") == 0))
  {
	fprintf(fp," %14s PATIENT ID FROM     : %-10s\n"," ", "LOWEST");              
	fprintf(fp," %14s            TO       : %-10s\n\n"," ","HIGHEST");            
  }
  else
  {     
	fprintf(fp," %14s            FROM     : %-20s\n"," ",nd_fm_patient_id.arr); 
	fprintf(fp," %14s            TO       : %-20s\n\n"," ",nd_to_patient_id.arr); 
  } 
									   
  if ((strcmp(nd_nature_from.arr,"") == 0) && (strcmp(nd_nature_to.arr,"") == 0))
  {
    fprintf(fp," %14s DOC NATURE    FROM  : %-10s\n"," ","LOWEST");     
    fprintf(fp," %14s               TO    : %-10s\n\n"," ","HIGHEST"); 
  }
  else
  {
    fprintf(fp," %14s DOC NATURE    FROM  : %-4s\n"," ",nd_nature_from.arr);     
    fprintf(fp," %14s               TO    : %-4s\n\n"," ",nd_nature_to.arr); 
  }                                                                

  if ((strcmp(nd_ref_from.arr,"") == 0) && (strcmp(nd_ref_to.arr,"") == 0))
  {
    fprintf(fp," %14s DOC REFERENCE FROM  : %-10s\n"," ","LOWEST");     
    fprintf(fp," %14s               TO    : %-10s\n\n"," ","HIGHEST");     
  }
  else
  {
    fprintf(fp," %14s DOC REFERENCE FROM  : %-10s\n"," ",nd_ref_from.arr);     
    fprintf(fp," %14s               TO    : %-10s\n\n"," ",nd_ref_to.arr);
  }
  
  fprintf(fp," %14s CUT-OFF DATE        : %s\n\n"," ",nd_cutoff_date.arr);
  fprintf(fp," %14s SHOW ASSOCIATED\n","");
  fprintf(fp," %14s    TRANSACTIONS     : %s\n\n","",
						   nd_associated_trn_flag.arr);
  fprintf(fp," %14s PRINT ZERO BAL\n","");
  fprintf(fp,"  %14s     DOCUMENTS      : %s\n","",
						nd_print_zero_bal_doc_flag.arr);

  fflush(fp);
}

print_head()
{
  fprintf(fp, "\f\n\nMDL : BL %39s %-30s %35s %-15s\n",
      " ", hosp_name.arr," ", date_time.arr);
  fprintf(fp, "OPR : %-10s                 %s\n",
     user_id.arr, "STATEMENT OF ACCOUNTS REPORT (DEFERRED CASH PATIENTS ONLY)");
  fprintf(fp, "REP : %-8s %35s  %-28s %39s PAGE : %4d\n", g_pgm_id, " ",
    nd_associated_trn_flag.arr[0]=='Y'?" (WITH ASSOCIATED TRXS)"
				      :"(WITHOUT ASSOCIATED TRXS)","", ++pctr);
    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
     fprintf(fp, "DOC TYPE/NUMBER  DOC TYPE/NUMBER  DOC DATE    DUE DATE    ");
     fprintf(fp, "TRX TYPE  REFERENCE        DOC AMOUNT     ADJUSTMENTS");
     fprintf(fp, "    OUTST AMOUNT\n");

    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
    fflush(fp);
    lctr = 8;
}

print_end()
{
  fprintf(fp, "\n\n\n %52s **   END  OF  REPORT   ** \n\n", " ");
  fflush(fp);
  fclose(fp);
}

print_pat_det()
{
  if (lctr > 56) print_head();

  fprintf(fp,"PATIENT NO : %-20s %-16.16s %-30.30s %1.1s %-40.40s\n",
	       bldcp_pend_patient_id.arr,mp_pat_short_name_loc_lang.arr,
	       mp_pat_short_name.arr, patfndt_black_listed_yn.arr,
	       patfndt_fin_remarks.arr);
   
   if(strlen(mp_pat_short_name1.arr) > 2)
	{
	fprintf(fp,"%51s %s \n"," ",mp_pat_short_name1.arr);
	lctr++;
	}
  
  fprintf(fp,"Cut-Off Date  : %12s \n\n",nd_cutoff_date.arr);                           
  lctr += 2;
}

print_pat_footer()
{
     if (lctr > 55 - 4) print_head();
     fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
     fprintf(fp, "NUMBER OF OUTSTANDING DOCUMENTS : %6ld\n", pat_pend_doc_ctr);
     fprintf(fp, "TOTAL OUTSTANDING FOR THE PATIENT : ");
     print_formated(pat_d_tot_bal); fprintf(fp,"\n\n");
     lctr += 4;

     rep_d_open_credit     += pat_d_open_credit;
     rep_d_tot_bal         += pat_d_tot_bal;

     pat_d_open_credit     = 0;
     pat_d_tot_bal         = 0;

     pat_pend_doc_ctr = 0;
}

print_report_footer()
{
  if (lctr > 55 - 4) print_head();

  fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  fprintf(fp, "NUMBER OF PATIENTS : %6ld\n", pat_ctr);
  fprintf(fp, "TOTAL OUTSTANDING: ");
  print_formated(rep_d_tot_bal);   fprintf(fp,"\n");
  lctr += 4;
}

print_pend_doc()
{
   
   strcpy(out_str,"");
   strcpy(out_str1,"");

   pat_pend_doc_ctr++;


   if (lctr > 55 - 1) print_head();
   fprintf(fp,"%-6s %8s  %15s  %-10s  %-10s  %-3.3s       %-10s   ", 
	      bldcp_pend_doc_type_code.arr, bldcp_pend_doc_num.arr,"",
	      bldcp_pend_doc_date.arr, bldcp_pend_due_date.arr,
	      bldcp_pend_trx_short_desc.arr,
	      bldcp_pend_pat_doc_ref.arr);

   print_formated(bldcp_pend_doc_amt);  fprintf(fp," ");
   print_formated(bldcp_pend_doc_outst_amt-bldcp_pend_doc_amt); fprintf(fp," ");
   print_formated(bldcp_pend_doc_outst_amt);  fprintf(fp,"\n");

   lctr ++;

   if(strlen(bldcp_pend_narration.arr)) {
       if (lctr > 55 - 1) print_head();
       fprintf(fp,"REMARK : %s    \n", bldcp_pend_narration.arr);
       lctr ++;
   }

   fflush(fp);

   if (lctr > 55 - 1) print_head();
   if (nd_associated_trn_flag.arr[0]=='Y') 
   {
       fprintf(fp, "\n"); fflush(fp); lctr ++;
   }
}

print_trn()
{
   
   strcpy(out_str,"");
   strcpy(out_str1,"");

   assoc_trn_ctr++;

   if (lctr > 55 - 1) print_head();

   fprintf(fp,"%15s  %-6s %8s  %-10s  %-10s  %-3.3s       %-10s   ", 
	      "", bldcp_trn_doc_type_code.arr, bldcp_trn_doc_num.arr,
	      bldcp_trn_doc_date.arr, "",
	      bldcp_trn_trx_short_desc.arr,
	      bldcp_trn_pat_doc_ref.arr);

   print_formated(bldcp_trn_doc_amt);  fprintf(fp,"\n");

   fflush(fp);
   lctr ++;
}

print_trn_footer()
{
   fprintf(fp,"\n"); lctr++;
   fflush(fp);
}

/************************** General Purpose Functions *************************/
sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )479;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

print_formated(loc_amount)
double loc_amount;
{
     
   
   strcpy(out_str,"");
   strcpy(out_str1,"");

   if (loc_amount == 0)
      fprintf(fp,"%14s ","0.00");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%11.2f",loc_amount);
      ltrim(out_str);format_amt(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%11.2f",-loc_amount);
      ltrim(out_str);format_amt(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
}

ltrim(l_str)
char *l_str;
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}

/* This function is now included in err_mesg 
put_comma(str)
char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10];
  strcpy(arr,str);
  strncpy(l_str1,arr + (strlen(arr) - 2),2);
  l_str1[2] = '\0';
  arr[strlen(str)-3] = '\0';
  i = strlen(arr);
  j = i;
  k = j/3;
  l = k;
  m = i - (l*3);
  if (i > 3)
  {
      for (a=0;a<m;a++)
	 o_arr[a] = arr[a];
   if (m)
   {
     o_arr[m] = ','; b=m+1;
   }
   else b = m;
  for (c=1,a=m;arr[a]!= '\0';a++,b++)
  {
     o_arr[b] = arr[a]; 
     c++;
     if (c > 3 && arr[a+1] != '\0')
     {
       o_arr[++b] = ','; c = 1;
     }
   }
   o_arr[b] = '\0';
  }
  else
      strcpy(o_arr,arr);
   sprintf(str,"%s.%s",o_arr,l_str1);
}
*/

list_args(arg_cnt, arg_list)
int arg_cnt;
char *arg_list[];
{
   int i;

   disp_message(ERR_MESG,"Not enough Parameters for running this program");
}

