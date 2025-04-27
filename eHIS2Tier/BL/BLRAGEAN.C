
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
           char  filnam[20];
};
static const struct sqlcxp sqlfpn =
{
    19,
    "C:\\temp\\Blragean.pc"
};


static unsigned long sqlctx = 36369659;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {10,17};

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

 static const char *sq0006 = 
"select BLACK_LISTED_YN ,FINANCIAL_REMARKS  from BL_PATIENT_FIN_DTLS where PA\
TIENT_ID=:b0           ";

 static const char *sq0007 = 
"select sum(DOC_AMT)  from BL_DCP_TRN where (((PATIENT_ID=:b0 and ORG_DOC_TYP\
E_CODE=:b1) and ORG_DOC_NUMBER=:b2) and TRUNC(DOC_DATE)<=to_date(:b3,'DD/MM/YY\
YY'))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,285,0,0,0,0,0,1,0,
20,0,0,2,158,0,4,301,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
55,0,0,3,373,0,4,356,0,0,17,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,
138,0,0,4,91,0,2,402,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
161,0,0,5,0,0,17,491,0,0,1,1,0,1,0,1,97,0,0,
180,0,0,5,0,0,45,496,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
227,0,0,5,0,0,13,562,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,2,3,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
302,0,0,8,523,0,6,604,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
329,0,0,6,99,0,9,676,0,0,1,1,0,1,0,1,9,0,0,
348,0,0,6,0,0,13,681,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
371,0,0,7,170,0,9,713,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
402,0,0,7,0,0,13,718,0,0,1,0,0,1,0,2,4,0,0,
421,0,0,9,0,0,27,1253,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
452,0,0,10,96,0,4,1299,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
475,0,0,11,162,0,6,1307,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
506,0,0,12,196,0,6,1332,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
533,0,0,13,210,0,6,1357,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.10.01                                              */
/************************************************************************/
/* PROGRAM NAME          : BLRAGEAN.PC                                  */
/* DATE WRITTEN          : 15-JUN-1993                                  */ 
/* Converted To Windows  : Prasad B G S       3/7/96                    */
/* Modified By           : V. Srikanth       16/4/97                    */
/* CALLED FROM           : BLRAGEAN (FORM)                              */
/*                                                                      */
/* FUNCTION              :                                              */ 
/*                                                                      */
/*                                                                      */  
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        BL_DCP_PENDING_DOC         Query                   */
/*         2.        MP_PATIENT_MAST            Lookup                  */
/*         3.        BL_PATIENT_FIN_DTLS        Lookup                  */
/*         4.        SY_PROG_PARAM              Query/Delete            */
/*                                                                      */
/*  PARAMETERS                                                          */
/*    REPORT_ORDER - 1 PATIENT ID                                       */
/*                   2 ENGLISH NAME (LAST, FIRST, SECOND)               */
/*                   3 LOCAL LANG. NAME (LAST, FIRST, SECOND)           */
/*    AGEING CUTOFF DT                                                  */
/*    FROM PATIENT_ID            |  RANGE OF ROWS TO BE SELECTED.       */
/*    TO   PATIENT_ID            |                                      */
/*    REPORT TYPE  -   S - SUMMARY                                      */
/*                     D - DETAIL                                       */
/*    AGEING SLOTS    1, 2, 3, 4                                        */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/************************************************************************/

#include <stdio.h>        
#include <string.h>         
#include <bl.h>       

#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

/*
#define DEBUG 0
*/
   
/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd                  [132],
	   hosp_name                    [120],
	   date_time                    [20],
	   nd_temp_date					[20],
	   nd_loc_date					[20],
	   nd_temp_date1				[12],
	   nd_loc_date1					[12],
	   date_convert					[20],
	   user_id                      [41],
	   nd_session_id                [16],
	   nd_pgm_date                  [35],
	   nd_pat_details               [3],
	   nd_nature_from               [5],
	   nd_nature_to                 [5],
	   nd_ref_from                  [11],
	   nd_ref_to                    [11]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[12]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[41]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_pat_details;

struct { unsigned short len; unsigned char arr[5]; } nd_nature_from;

struct { unsigned short len; unsigned char arr[5]; } nd_nature_to;

struct { unsigned short len; unsigned char arr[11]; } nd_ref_from;

struct { unsigned short len; unsigned char arr[11]; } nd_ref_to;

	   
   /* VARCHAR nd_rep_type              [3],
       nd_facility_id               [3],
	   nd_fm_patient_id             [21],
	   nd_to_patient_id             [21],
	   nd_cutoff_date               [12],
	   nd_order                     [2],
	   nd_lang_id					[4],
	   l_translated_value			[201],
	   l_pk_value					[100],	
	   nd_print_zero_bal			[2]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_rep_type;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[12]; } nd_cutoff_date;

struct { unsigned short len; unsigned char arr[2]; } nd_order;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[2]; } nd_print_zero_bal;


   int nd_age_slot1,
	   nd_age_slot2,
	   nd_age_slot3,
	   nd_age_slot4;

	int i=0;


   /* VARCHAR bldcp_pend_doc_type_code [7],
	   bldcp_pend_doc_num           [9],
	   bldcp_pend_doc_date          [12],
	   bldcp_pend_due_date          [12],
	   bldcp_pend_pat_doc_ref       [16],
	   bldcp_pend_nature_code        [5],
	   bldcp_pend_patient_id        [21],
	   bldcp_pend_narration         [51],
	   bldcp_pend_trx_short_desc    [4],
       d_short_name_full            [61],
	   mp_pat_short_name            [61],
	   mp_pat_short_name1           [31],
	   mp_pat_short_name_loc_lang   [61]; */ 
struct { unsigned short len; unsigned char arr[7]; } bldcp_pend_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bldcp_pend_doc_num;

struct { unsigned short len; unsigned char arr[12]; } bldcp_pend_doc_date;

struct { unsigned short len; unsigned char arr[12]; } bldcp_pend_due_date;

struct { unsigned short len; unsigned char arr[16]; } bldcp_pend_pat_doc_ref;

struct { unsigned short len; unsigned char arr[5]; } bldcp_pend_nature_code;

struct { unsigned short len; unsigned char arr[21]; } bldcp_pend_patient_id;

struct { unsigned short len; unsigned char arr[51]; } bldcp_pend_narration;

struct { unsigned short len; unsigned char arr[4]; } bldcp_pend_trx_short_desc;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name;

struct { unsigned short len; unsigned char arr[31]; } mp_pat_short_name1;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name_loc_lang;


   int bldcp_pend_amt_sign,
	   bldcp_pend_age_days;

   double  bldcp_pend_doc_amt,
	   bldcp_pend_doc_outst_amt;

   /* VARCHAR patfndt_black_listed_yn   [2],
	   patfndt_fin_remarks          [41]; */ 
struct { unsigned short len; unsigned char arr[2]; } patfndt_black_listed_yn;

struct { unsigned short len; unsigned char arr[41]; } patfndt_fin_remarks;

   
   char pr_bldcp_pend_patient_id     [21],
	   pr_mp_pat_short_nm_loc_lang   [61],
	   pr_mp_pat_short_name          [61], 
	   pr_mp_pat_short_name1         [31],
	   pr_patfndt_black_listed_yn    [2],
	   pr_patfndt_fin_remarks        [41];  
   
   char pr1_bldcp_pend_patient_id    [21],
	   pr1_mp_pat_short_nm_loc_lang  [61],
	   pr1_mp_pat_short_name         [61],
	   pr1_mp_pat_short_name1        [31],
	   pr1_patfndt_black_listed_yn   [2],
	   pr1_patfndt_fin_remarks       [41];             

   char sql_stmt                     [2000];                
   char string_var                     [70];             
   char out_str[30],
		out_str1[30],
		g_facility_id[3];
   char loc_legend[999][201];      


char  filename[150];

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRAGEAN.C-arc   1.1   Nov 30 2007 13:08:00   Vivekanand  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRAGEAN.C-arc   1.1   Nov 30 2007 13:08:00   Vivekanand  $ sqlda.h 
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
       bal_amt_slot1,
       bal_amt_slot2,
       bal_amt_slot3,
       bal_amt_slot4,

       pat_d_open_credit,
       pat_d_tot_bal,
       pat_d_amt_slot1,
       pat_d_amt_slot2,
       pat_d_amt_slot3,
       pat_d_amt_slot4,

       rep_d_open_credit,
       rep_d_tot_bal,
       rep_d_amt_slot1,
       rep_d_amt_slot2,
       rep_d_amt_slot3,
       rep_d_amt_slot4;

char old_patient_id     [21];

int    statyn,
	   statyn1;        

FILE *fp;
int lctr = 0,pctr =0, pend_doc_ctr = 0;
long pat_pend_doc_ctr, pat_ctr;
int age_days = 0;

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc < 5)
   {
      list_args(argc, argv);
      proc_exit();
   }

   strcpy(g_pgm_id,"BLRAGEAN");

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
	        disp_message(ORA_MESG,"Null oracle uid/pwd");
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
   set_meduser_role();

   strcpy(nd_lang_id.arr,l_language_id.arr);
   nd_lang_id.len = l_language_id.len;

   fetch_param();
   start_prog_msg();
   fetch_desc();
   fetch_legend_value();
   open_files();
   declare_cursors();
   pend_doc_ctr = 0;
   old_patient_id[0] = '\0';
   pat_ctr = 0;    
   statyn = 0;                                                               
   statyn1 = 0;
   strcpy(pr_bldcp_pend_patient_id,"");
   strcpy(pr_mp_pat_short_name,"");
   strcpy(pr_mp_pat_short_name,"");
   strcpy(pr_mp_pat_short_nm_loc_lang,"");                           
   strcpy(pr_patfndt_black_listed_yn,"");
   strcpy(pr_patfndt_fin_remarks,"");
   pat_pend_doc_ctr = 0;

      
   while(fetch_pending_doc())
   {    
      get_other_details();

/*-- Outstanding for patient */ 
    
      get_outst_details();             

      if (bldcp_pend_age_days >= 0)
      {
	  pend_doc_ctr++;
	  if (strcmp(old_patient_id,bldcp_pend_patient_id.arr))
	  {  

	      if (nd_rep_type.arr[0] == 'D')
				pat_ctr++;
	      if (strlen(old_patient_id)) 
	      {            
		   /* Get the details of the old patient */
		   print_pat_footer(); 
		   
	      }    

	      if (nd_rep_type.arr[0] == 'D')
			  {                            
				print_pat_det();  
		  }   
	      strcpy(old_patient_id,bldcp_pend_patient_id.arr);
	  }
	  process_det(); 
	  if (nd_rep_type.arr[0] == 'S')   
	      {
		if ((bldcp_pend_doc_outst_amt == 0) &&
			 (bal_amt_slot1 == 0) &&
			  (bal_amt_slot2 == 0) &&
				(bal_amt_slot3 == 0) && 
					(bal_amt_slot4 == 0))
			{                                         
			continue;
	    }                  
		    
	      } 
	      
	  print_det_line();
      }
    }
    if (pend_doc_ctr > 0)
    {
       print_pat_footer();
    }
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


    return;
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

   /* EXEC SQL SELECT ACC_ENTITY_NAME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		   USER
	      INTO :hosp_name, :date_time, :user_id
	      FROM SY_ACC_ENTITY_LANG_VW
		  WHERE acc_entity_id = :nd_facility_id
		  AND LANGUAGE_ID=:nd_lang_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:b\
3 and LANGUAGE_ID=:b4)";
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
   sqlstm.sqhstl[2] = (unsigned int  )43;
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
   sqlstm.sqhstv[4] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[4] = (unsigned int  )6;
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
	 err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';

   if(date_time.arr[0]!='\0')
	{
		init_date_temp_var();
		strcpy(date_convert.arr,date_time.arr);
		fun_change_loc_date1();
		strcpy(date_time.arr,date_convert.arr);
	}


}

fetch_param()
{
   nd_fm_patient_id.arr[0]       = '\0';
   nd_to_patient_id.arr[0]       = '\0';
   nd_order.arr[0]               = '\0';
   nd_rep_type.arr[0]            = '\0';
   nd_cutoff_date.arr[0]         = '\0';       
   nd_nature_from.arr[0]         = '\0';       
   nd_nature_to.arr[0]           = '\0';       
   nd_ref_from.arr[0]            = '\0';       
   nd_ref_to.arr[0]              = '\0';       
   nd_print_zero_bal.arr[0]      = '\0';       
   nd_facility_id.arr[0]  = '\0';


   nd_fm_patient_id.len          = 0;
   nd_to_patient_id.len          = 0;
   nd_order.len                  = 0;
   nd_rep_type.len               = 0;
   nd_cutoff_date.len            = 0; 
   nd_nature_from.len            = 0;
   nd_nature_to.len              = 0;
   nd_ref_from.len               = 0;
   nd_ref_to.len                 = 0;
   nd_print_zero_bal.len		 = 0;       
   nd_facility_id.len  = 0;

   


   /* EXEC SQL SELECT OPERATING_FACILITY_ID,PARAM1,PARAM2,PARAM3, PARAM4,
		   NVL(TO_NUMBER(PARAM5),0),
		   NVL(TO_NUMBER(PARAM6),0),
		   NVL(TO_NUMBER(PARAM7),0),
		   NVL(TO_NUMBER(PARAM8),0),
		   PARAM9,PARAM10,PARAM11,PARAM12,PARAM13,PARAM14
	      INTO :nd_facility_id,:nd_order,
		   :nd_fm_patient_id,
		   :nd_to_patient_id,
		   :nd_cutoff_date,
		   :nd_age_slot1,
		   :nd_age_slot2,
		   :nd_age_slot3,
		   :nd_age_slot4,
		   :nd_rep_type,
		   :nd_nature_from,
		   :nd_nature_to,
		   :nd_ref_from,
		   :nd_ref_to,
		   :nd_print_zero_bal
	      FROM SY_PROG_PARAM
	     WHERE PGM_ID     = 'BLRAGEAN'
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,NVL(TO_NUMBER(PARAM5),0) ,NVL(TO_NUMBER(PARAM6),0) ,NVL(TO_NUMBER(PARAM7),\
0) ,NVL(TO_NUMBER(PARAM8),0) ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARA\
M14 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14  fro\
m SY_PROG_PARAM where ((PGM_ID='BLRAGEAN' and SESSION_ID=:b15) and PGM_DATE=:b\
16)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )55;
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
   sqlstm.sqhstv[4] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[4] = (unsigned int  )14;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_age_slot1;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_age_slot2;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_age_slot3;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_age_slot4;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_rep_type;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_nature_from;
   sqlstm.sqhstl[10] = (unsigned int  )7;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_nature_to;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_ref_from;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_ref_to;
   sqlstm.sqhstl[13] = (unsigned int  )13;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_print_zero_bal;
   sqlstm.sqhstl[14] = (unsigned int  )4;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[15] = (unsigned int  )18;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[16] = (unsigned int  )37;
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
}



   if (OERROR)
	err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
	err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_order.arr[nd_order.len]                    = '\0';
   nd_fm_patient_id.arr[nd_fm_patient_id.len]    = '\0';
   nd_to_patient_id.arr[nd_to_patient_id.len]    = '\0';
   nd_cutoff_date.arr[nd_cutoff_date.len]        = '\0';
   nd_rep_type.arr[nd_rep_type.len]              = '\0';
   nd_nature_from.arr[nd_nature_from.len]        = '\0';
   nd_nature_to.arr[nd_nature_to.len]            = '\0';
   nd_ref_from.arr[nd_ref_from.len]              = '\0';
   nd_ref_to.arr[nd_ref_to.len]                  = '\0';
   nd_print_zero_bal.arr[nd_print_zero_bal.len]  = '\0';
   strcpy(g_facility_id,nd_facility_id.arr);
}

delete_param()
{
    /* EXEC SQL DELETE FROM SY_PROG_PARAM
		   WHERE PGM_ID     = 'BLRAGEAN'
		     AND SESSION_ID = :nd_session_id
		     AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRAGEAN' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )138;
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
   CEIL(NVL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),SYSDATE) - ORG_DOC_DATE), \
   SIGN(NVL(DOC_OUTST_AMT,0)),DOC_AMT,DOC_OUTST_AMT,PAT_DOC_REFERENCE, \
   NARRATION, DOC_NATURE_CODE, B.SHORT_NAME_LOC_LANG,B.SHORT_NAME \
   FROM BL_DCP_PENDING_DOC A,MP_PATIENT_MAST B \
   WHERE a.operating_facility_id = :nd_facility_id AND \
   A.PATIENT_ID BETWEEN NVL(:nd_fm_patient_id,'        ') AND NVL(:nd_to_patient_id,'~~~~~~~~') \
   AND (A.DOC_NATURE_CODE BETWEEN NVL(:nd_nature_from,'    ') AND NVL(:nd_nature_to,'~~~~') ");
    

  
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
   AND ORG_DOC_DATE <= TRUNC(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY')) ");
   

   


/*
   if (strlen(nd_nature_from.arr) == 0 || strlen(nd_nature_to.arr) == 0) 
      {
       disp_message(ERR_MESG,"Entered"); 
       strcat(sql_stmt,"   AND (A.DOC_NATURE_CODE BETWEEN NVL(:nd_nature_from,'    ') AND NVL(:nd_nature_to,'~~~~') OR DOC_NATURE_CODE IS NULL) ");
      } 
   else
      {
       disp_message(ERR_MESG,"Enteredelse"); 
       strcat(sql_stmt,"   AND (A.DOC_NATURE_CODE BETWEEN NVL(:nd_nature_from,'    ') AND NVL(:nd_nature_to,'~~~~')) ");
      } 
   
   if (strlen(nd_ref_from.arr) == 0 || strlen(nd_ref_to.arr) == 0) 
      {
      disp_message(ERR_MESG,"Entered1");  
       strcat(sql_stmt,"  AND (A.PAT_DOC_REFERENCE BETWEEN NVL(:nd_ref_from,'          ') AND NVL(:nd_ref_to,'~~~~~~~~~~') OR PAT_DOC_REFERENCE IS NULL)  ");
      } 
   else
      {
       disp_message(ERR_MESG,"Enteredelse1");  
       strcat(sql_stmt,"  AND (A.PAT_DOC_REFERENCE BETWEEN NVL(:nd_ref_from,'          ') AND NVL(:nd_ref_to,'~~~~~~~~~~'))  ");
      } 

*/


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
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )161;
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
					      :nd_to_patient_id ,
					      :nd_nature_from,
					      :nd_nature_to,
					      :nd_ref_from,
					      :nd_ref_to; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )180;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[0] = (unsigned int  )14;
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
      err_mesg("OPEN failed ON cursor BL_DCL_PENDING_DOC_CUR",0,"");
      

   /* EXEC SQL DECLARE BL_PATIENT_FIN_DTLS_CUR CURSOR FOR 
   SELECT BLACK_LISTED_YN, FINANCIAL_REMARKS
   FROM   BL_PATIENT_FIN_DTLS
   WHERE  PATIENT_ID = :bldcp_pend_patient_id; */ 
  
   
   
   /* Cursor for Exact Outstanding from bl_dcp_trn table */
   
   /* EXEC SQL DECLARE BL_DCP_TRN_CUR CURSOR FOR
   SELECT SUM(DOC_AMT) FROM BL_DCP_TRN
   WHERE PATIENT_ID = :bldcp_pend_patient_id AND
   ORG_DOC_TYPE_CODE = :bldcp_pend_doc_type_code AND
   ORG_DOC_NUMBER = :bldcp_pend_doc_num AND 
   TRUNC(DOC_DATE) <= to_date(:nd_cutoff_date,'DD/MM/YYYY'); */ 


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
  bldcp_pend_nature_code.arr[0]         = '\0';
  bldcp_pend_narration.arr[0]           = '\0';
  mp_pat_short_name.arr[0]              = '\0';
  mp_pat_short_name1.arr[0]             = '\0';
  mp_pat_short_name_loc_lang.arr[0]     = '\0';

  bldcp_pend_patient_id.len             = 0;
  bldcp_pend_doc_type_code.len          = 0;
  bldcp_pend_doc_num.len                = 0;
  bldcp_pend_doc_date.len               = 0;
  bldcp_pend_due_date.len               = 0;
  bldcp_pend_trx_short_desc.len         = 0;
  bldcp_pend_pat_doc_ref.len            = 0;
  bldcp_pend_narration.len              = 0;
  bldcp_pend_nature_code.len            = 0;
  mp_pat_short_name.len                 = 0;
  mp_pat_short_name1.len				= 0;
  mp_pat_short_name_loc_lang.len        = 0;

  bldcp_pend_age_days                   = 0;
  bldcp_pend_amt_sign                   = 0;
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
		     --:mp_pat_short_name,
			 --:mp_pat_short_name1,
		     :mp_pat_short_name_loc_lang,
	         :d_short_name_full; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )227;
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
  mp_pat_short_name.arr[mp_pat_short_name.len]                           = '\0';
  mp_pat_short_name1.arr[mp_pat_short_name1.len]						 = '\0';
  bldcp_pend_nature_code.arr[bldcp_pend_nature_code.len]                                 = '\0';
  mp_pat_short_name_loc_lang.arr[mp_pat_short_name_loc_lang.len]         = '\0';
  d_short_name_full.arr[d_short_name_full.len]                           = '\0';
  
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
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) \
; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , st\
r2 ) ; IF str2 IS NOT NULL THEN :mp_pat_short_name := str2 ; END IF ; blcommon\
 . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 I\
S NOT NULL THEN :mp_pat_short_name1 := str2 ; END IF ; blcommon . split_words \
( :d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN\
 :mp_pat_short_name1 := :mp_pat_short_name1 || str2 ; end if ; END ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )302;
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


       mp_pat_short_name.arr[mp_pat_short_name.len]  = '\0';
       mp_pat_short_name1.arr[mp_pat_short_name1.len]  = '\0';




  
  if (strcmp(old_patient_id,bldcp_pend_patient_id.arr))
  {
	statyn = 0;
	statyn1 = 0;
  }
	
  if (nd_rep_type.arr[0] == 'S')
  {                            
    if (statyn == 0)
    {   
	strcpy(pr1_bldcp_pend_patient_id,pr_bldcp_pend_patient_id);          
	strcpy(pr1_mp_pat_short_name,pr_mp_pat_short_name);
	strcpy(pr1_mp_pat_short_name1,pr_mp_pat_short_name1);
	strcpy(pr1_mp_pat_short_nm_loc_lang,pr_mp_pat_short_nm_loc_lang);
		
	strcpy(pr_bldcp_pend_patient_id,bldcp_pend_patient_id.arr);
	strcpy(pr_mp_pat_short_name,mp_pat_short_name.arr);
	strcpy(pr_mp_pat_short_name1,mp_pat_short_name1.arr);
	strcpy(pr_mp_pat_short_nm_loc_lang,mp_pat_short_name_loc_lang.arr);
	
	statyn = 1;
	}       
  }

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
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )329;
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
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )348;
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
   
   if (nd_rep_type.arr[0] == 'S')
   {                            
    if (statyn1 == 0)
    {
		strcpy(pr1_patfndt_black_listed_yn,pr_patfndt_black_listed_yn);
		strcpy(pr1_patfndt_fin_remarks,pr_patfndt_fin_remarks);
		strcpy(pr_patfndt_black_listed_yn,patfndt_black_listed_yn.arr);
		strcpy(pr_patfndt_fin_remarks,patfndt_fin_remarks.arr);
		statyn1 = 1;
	}       
   }
   
}



/* This function will find out the exact outstanding
   as of that cut-off date  for the age */   

get_outst_details()
{    
   bldcp_pend_doc_outst_amt = 0;                               

   /* EXEC SQL OPEN BL_DCP_TRN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )371;
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
   sqlstm.sqhstv[3] = (         void  *)&nd_cutoff_date;
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
      err_mesg("OPEN failed on cursor BL_DCP_TRN_CUR",0,"");

   /* EXEC SQL FETCH BL_DCP_TRN_CUR INTO :bldcp_pend_doc_outst_amt ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )402;
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
      err_mesg("FETCH failed on cursor BL_DCP_TRN_CUR",0,""); 

/*      
   bldcp_pend_doc_outst_amt =   bldcp_pend_doc_amt + bldcp_pend_doc_outst_amt;   
*/   

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
    bal_amt_slot1              = 0;
    bal_amt_slot2              = 0;
    bal_amt_slot3              = 0;
    bal_amt_slot4              = 0;
   
    if (bldcp_pend_amt_sign == -1)
    {         
	   nd_open_credit     = bldcp_pend_doc_outst_amt;
	   pat_d_open_credit += bldcp_pend_doc_outst_amt;
    }
    else if (bldcp_pend_amt_sign == 1)
    {                     
	
	if      (bldcp_pend_age_days >= 0 &&
		 bldcp_pend_age_days <= nd_age_slot1)
	{                      
	      bal_amt_slot1     = bldcp_pend_doc_outst_amt;
	      pat_d_amt_slot1   += bldcp_pend_doc_outst_amt;
	}
	else if (bldcp_pend_age_days >= nd_age_slot1 + 1 && 
		 bldcp_pend_age_days <= nd_age_slot2)
	{                        
	      bal_amt_slot2     = bldcp_pend_doc_outst_amt;
	      pat_d_amt_slot2  += bldcp_pend_doc_outst_amt;
	}
	else if (bldcp_pend_age_days >= nd_age_slot2 + 1 &&
		 bldcp_pend_age_days <= nd_age_slot3)
	{                        
	      bal_amt_slot3     = bldcp_pend_doc_outst_amt;
	      pat_d_amt_slot3  += bldcp_pend_doc_outst_amt;
	}
	else 
	     /*  if (bldcp_pend_age_days >= nd_age_slot3 + 1 && 
		 bldcp_pend_age_days <= nd_age_slot4)  */
	{                        
	      bal_amt_slot4     = bldcp_pend_doc_outst_amt;
	      pat_d_amt_slot4  += bldcp_pend_doc_outst_amt;
	}
    }
    pat_d_tot_bal += bldcp_pend_doc_outst_amt;

}

/*********************** File Handling & Printing Functions *******************/
open_files()
{
  char  err_stmt[70];


   strcpy(filename,WORKING_DIR);
   strcat(filename,"blragean.lis");
   if ((fp = fopen(filename,"w")) == NULL)
   {
	sprintf(err_stmt,"Error while opening File %s",filename);
	err_mesg(err_stmt,0,"");
	proc_exit();
   }

   print_title();
   print_head();

}

print_title()
{
  
  fprintf(fp,"\n%-6.6s : %-3.3s %-39.39s%-40.40s%-24.24s%-s\n",loc_legend[1],loc_legend[2]," ",hosp_name.arr," ",date_time.arr);
  fprintf(fp,"%-6.6s : %-10.10s %-28.28s %-40.40s\n",loc_legend[3],user_id.arr," ",nd_rep_type.arr[0]=='D'? loc_legend[5]:loc_legend[6]);
  fprintf(fp,"%-6.6s : %-10.10s %-28.28s %-40.40s%-28.28s%9.9s :%4d\n",loc_legend[4],g_pgm_id," ",loc_legend[7]," ",loc_legend[8],++pctr);
 
  fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  fprintf(fp,"VER : 4.1 \n");
  fflush(fp);

    fprintf(fp,"\n\n\n\n        %-s \n        ----------------\n\n",loc_legend[9]);
	fprintf(fp," %14s %-13.13s       : %-s\n\n"," ",loc_legend[10],nd_facility_id.arr);
	if (nd_order.arr[0] == '1')
    fprintf(fp," %14s %-13.13s       : %-20.20s\n\n"," ",loc_legend[11],loc_legend[28]);
  else if (nd_order.arr[0] == '2')
    fprintf(fp," %14s %-13.13s       : %-20.20s\n\n"," ",loc_legend[11],loc_legend[29]);
  else
    fprintf(fp," %14s %-13.13s       : %-20.20s\n\n"," ",loc_legend[11],loc_legend[30]);

  if ((strcmp(nd_fm_patient_id.arr,"") == 0) && (strcmp(nd_to_patient_id.arr,"") == 0))
  {
	fprintf(fp," %14s %-13.13s %-5.5s : %-10.10s\n"," ",loc_legend[12],loc_legend[13],loc_legend[15]);              
	fprintf(fp," %14s %-13.13s %-5.5s : %-10.10s\n\n"," "," ",loc_legend[14],loc_legend[16]);            
  }
  else
  {     
	
	fprintf(fp," %14s %-13.13s %-5.5s : %-s\n"," ",loc_legend[12],loc_legend[13],nd_fm_patient_id.arr);              
	fprintf(fp," %14s %-13.13s %-5.5s : %-s\n\n"," "," ",loc_legend[14],nd_to_patient_id.arr);  
	
  } 

  if ((strcmp(nd_nature_from.arr,"") == 0) && (strcmp(nd_nature_to.arr,"") == 0))
  {
    fprintf(fp," %14s %-13.13s %-5.5s : %-10.10s\n"," ",loc_legend[17],loc_legend[13],loc_legend[15]);     
	fprintf(fp," %14s %-13.13s %-5.5s : %-10.10s\n\n"," "," ",loc_legend[14],loc_legend[16]);            
  }
  else
  {
    
	fprintf(fp," %14s %-13.13s %-5.5s : %-s\n"," ",loc_legend[17],loc_legend[13],nd_nature_from.arr);              
	fprintf(fp," %14s %-13.13s %-5.5s : %-s\n\n"," "," ",loc_legend[14],nd_nature_to.arr);  
			
  }                 

  if ((strcmp(nd_ref_from.arr,"") == 0) && (strcmp(nd_ref_to.arr,"") == 0))
  {
    
	fprintf(fp," %14s %-13.13s %-5.5s : %-10.10s\n"," ",loc_legend[18],loc_legend[13],loc_legend[15]);     
	fprintf(fp," %14s %-13.13s %-5.5s : %-10.10s\n\n"," "," ",loc_legend[14],loc_legend[16]);     
	
  }
  else
  {
    
	fprintf(fp," %14s %-13.13s %-5.5s : %-s\n"," ",loc_legend[18],loc_legend[13],nd_ref_from.arr);              
	fprintf(fp," %14s %-13.13s %-5.5s : %-s\n\n"," "," ",loc_legend[14],nd_ref_to.arr);  
		
  }

  fprintf(fp," %14s %-19.19s : %-s\n\n"," ",loc_legend[19],nd_cutoff_date.arr);
  fprintf(fp," %14s %-19.19s : %-3d\n\n"," ",loc_legend[20],nd_age_slot1);
  fprintf(fp," %14s %-19.19s : %-3d\n\n"," ",loc_legend[21],nd_age_slot2);
  fprintf(fp," %14s %-19.19s : %-3d\n\n"," ",loc_legend[22],nd_age_slot3);
  fprintf(fp," %14s %-19.19s : %-3d\n\n"," ",loc_legend[23],nd_age_slot4);
  fprintf(fp," %14s %-19.19s : %-s\n\n"," ",loc_legend[24],nd_rep_type.arr[0]=='D'?loc_legend[25]:loc_legend[26]);
  fprintf(fp," %14s %-19.19s : %-s\n\n"," ",loc_legend[27],nd_print_zero_bal.arr);
  
  fflush(fp);
}

print_head()
{
  

  fprintf(fp,"\f\n%-6.6s : %-3.3s %-39.39s%-40.40s%-24.24s%-s\n",loc_legend[1],loc_legend[2]," ",hosp_name.arr," ",date_time.arr);
  fprintf(fp,"%-6.6s : %-10.10s %-28.28s %-40.40s\n",loc_legend[3],user_id.arr," ",nd_rep_type.arr[0]=='D'? loc_legend[5]:loc_legend[6]);
  fprintf(fp,"%-6.6s : %-10.10s %-28.28s %-40.40s%-28.28s%9.9s :%4d\n",loc_legend[4],g_pgm_id," ",loc_legend[7]," ",loc_legend[8],++pctr);
 
 
    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  if (nd_rep_type.arr[0] == 'D')
  {
     /*
	 fprintf(fp, "DOC TYPE/NUMBER  DOC DATE    DUE DATE    TRX TYPE ");
     fprintf(fp, "  OPEN CREDITS          SLOT 1          SLOT 2");
     fprintf(fp, "          SLOT 3          SLOT 4 \n");
	 fprintf(fp, " %28s REFERENCE %27s "," "," ");
	 fprintf(fp, "%3d-%-3d DAYS    %3d-%-3d DAYS    %3d-%-3d DAYS    ",
		 0, nd_age_slot1,
		 nd_age_slot1, nd_age_slot2,
		 nd_age_slot2, nd_age_slot3);
     fprintf(fp, "%3d-%-3d DAYS\n",
		 nd_age_slot3, nd_age_slot4);
     */

     fprintf(fp, "%-8.8s/%-6.6s  %-8.8s    %-8.8s    %-8.8s ",loc_legend[42],loc_legend[43],loc_legend[44],loc_legend[45],loc_legend[46]);
	 fprintf(fp, "  %-12.12s          %-6.6s          %-6.6s",loc_legend[47],loc_legend[48],loc_legend[49]);
     fprintf(fp, "          %-6.6s          %-6.6s \n",loc_legend[50],loc_legend[51]);
     fprintf(fp, " %28s %-9.9s %27s "," ",loc_legend[52]," ");

     fprintf(fp, "%3d-%-3d %-4.4s    %3d-%-3d %-4.4s    %3d-%-3d %-4.4s    ",
		 0, nd_age_slot1,loc_legend[39],
		 nd_age_slot1, nd_age_slot2,loc_legend[39],
		 nd_age_slot2, nd_age_slot3,loc_legend[39]);
     
	 fprintf(fp, "%3d-%-3d %-4.4s\n",
		 nd_age_slot3, nd_age_slot4,loc_legend[39]);
   }
   else
   {
     
     fprintf(fp, " %34s%17.17s        %7.7s       %10.10s","",loc_legend[32],loc_legend[33],loc_legend[34]);
     fprintf(fp, "      %10.10s      %10.10s      %10.10s\n",loc_legend[35],loc_legend[36],loc_legend[37]);
    
	 fprintf(fp, " %34s %17s       %7.7s     %3d-%-3d %4.4s    %3d-%-3d %4.4s","","",loc_legend[38],0, nd_age_slot1,loc_legend[39],nd_age_slot1, nd_age_slot2,loc_legend[39]);
	 
	 fprintf(fp, "    %3d-%-3d %4.4s    %3d-%-3d %4.4s\n",
				    nd_age_slot2, nd_age_slot3,loc_legend[39],
				    nd_age_slot3, nd_age_slot4,loc_legend[39]);
    }
    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
    fflush(fp);
    lctr = 9;
}

print_end()
{
  if (lctr > 55 - 5) print_head();

    fprintf(fp, "\n\n\n %52s **   %-15.15s   ** \n\n", " ",loc_legend[57]);

  fflush(fp);
  fclose(fp);
}

print_pat_det()
{
  if (lctr > 55 - 1) print_head();
  
  if (nd_rep_type.arr[0] == 'S')  
  {                                      
	
	/*fprintf(fp,"%-10.10s : %-20s %-16.16s %-30.30s %1.1s %-40.40s\n",loc_legend[31],
	       pr1_bldcp_pend_patient_id,pr1_mp_pat_short_nm_loc_lang,
	       pr1_mp_pat_short_name, pr1_patfndt_black_listed_yn,
	       pr1_patfndt_fin_remarks);
     */
	
	if(strcmp(nd_lang_id.arr,"en")==0)
	{	
	
	 fprintf(fp,"%-10.10s : %-20s %-47.47s %1.1s %-40.40s\n",loc_legend[31],
	       pr1_bldcp_pend_patient_id,pr1_mp_pat_short_name,
	       pr1_patfndt_black_listed_yn,
	       pr1_patfndt_fin_remarks);
     }
	else
	{

    fprintf(fp,"%-10.10s : %-20s %-47.47s %1.1s %-40.40s\n",loc_legend[31],
	       pr1_bldcp_pend_patient_id,pr1_mp_pat_short_nm_loc_lang,
	       pr1_patfndt_black_listed_yn,
	       pr1_patfndt_fin_remarks);
	}

    if (strlen(pr1_mp_pat_short_name1) > 2)  
	{
	if(strcmp(nd_lang_id.arr,"en")==0)
    fprintf(fp,"%50s %s \n"," ", pr1_mp_pat_short_name1);
	else
	fprintf(fp,"%50s %s \n"," ", pr1_mp_pat_short_nm_loc_lang);

	lctr++;
	}
	return(0);  
  }
  else    
  {     
	
	/*fprintf(fp,"%-10.10s : %-20s %-16.16s %-30.30s %1.1s %-40.40s\n",loc_legend[31],
	       bldcp_pend_patient_id.arr,mp_pat_short_name_loc_lang.arr,
	       mp_pat_short_name.arr, patfndt_black_listed_yn.arr,
	       patfndt_fin_remarks.arr);
	*/
	if(strcmp(nd_lang_id.arr,"en")==0)
	{

	fprintf(fp,"%-10.10s : %-20s %-47.47s %1.1s %-40.40s\n",loc_legend[31],
	       bldcp_pend_patient_id.arr,mp_pat_short_name.arr,
	       patfndt_black_listed_yn.arr,
	       patfndt_fin_remarks.arr);
	}
    else
	{

	fprintf(fp,"%-10.10s : %-20s %-47.47s %1.1s %-40.40s\n",loc_legend[31],
	       bldcp_pend_patient_id.arr,mp_pat_short_name_loc_lang.arr,
	       patfndt_black_listed_yn.arr,
	       patfndt_fin_remarks.arr);

	}

	if (strlen(mp_pat_short_name1.arr) > 2)
	{

	 if(strcmp(nd_lang_id.arr,"en")==0)
	 fprintf(fp,"%50s %s"," ", mp_pat_short_name1.arr);
	 else
	 fprintf(fp,"%50s %s"," ", mp_pat_short_name_loc_lang.arr);
	   lctr++;
	 }
  }             
  lctr++;

  if (lctr > 55 - 1) print_head();
  fprintf(fp,"\n"); lctr++;
  
}
  
  
print_pat_footer()
{

/*----- This code is added by VSK on 10/01/1999 to avoid printing  records
        having zero balance, if the Print_Zero_Records Flag is Off in case
		of Summary Report  ------ */

/*
sprintf(string_var,"ZER BAL REQD %c",nd_print_zero_bal.arr[0]);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"TOT BAL  %lf",pat_d_tot_bal);
disp_message(ERR_MESG,string_var);
*/
   
   if (nd_rep_type.arr[0] == 'S')
   {
     if (nd_print_zero_bal.arr[0] == 'N' && pat_d_tot_bal == 0)
	 {
//		 disp_message(ERR_MESG,"Tot Bal is made zero before return..");
		 return(0);

	 }

  }
/*----- Added by Venkat on 18/10/1999 to Print details corresponciing
  ----------- to zero_bal flag ----------------*/

  if (nd_rep_type.arr[0] == 'D')
   {
     if (nd_print_zero_bal.arr[0] == 'N' && pat_d_tot_bal == 0)
	 {
		//  disp_message(ERR_MESG,"Tot Bal is made zero before return (Detail)..");
		    return(0); 

	 }

  }
/*-----------------------------------------------------------------------*/

  if (nd_rep_type.arr[0] == 'D')
   {
     if (lctr > 55 - 4) print_head();
     fprintf(fp, "\n %24s %s%s\n"," ","-------------------------------------",
     "---------------------------------------------------------------------");
     fprintf(fp, "%-22.22s :                          ",loc_legend[53]);
     print_formated(pat_d_open_credit); fprintf(fp," ");
     print_formated(pat_d_amt_slot1);   fprintf(fp," ");
     print_formated(pat_d_amt_slot2);   fprintf(fp," ");
     print_formated(pat_d_amt_slot3);   fprintf(fp," ");
     print_formated(pat_d_amt_slot4);   fprintf(fp,"\n");
   
     fprintf(fp, " %24s %s%s\n"," ","-------------------------------------",
     "---------------------------------------------------------------------");
     lctr += 4;

     if (lctr > 55 - 3) print_head();
	 fprintf(fp, "%-31.31s : %6ld\n",loc_legend[54],pat_pend_doc_ctr);
	 fprintf(fp, "%-33.33s : ",loc_legend[55]);
     print_formated(pat_d_tot_bal); fprintf(fp,"\n\n");
     lctr += 3;
   }
   else 
   {

/*-- This summary part has been modified to have the line counter proper
     for skiping the page.  VSK 11/01/1999 */

     if (((pat_d_tot_bal != 0) ||
			(pat_d_amt_slot1 != 0) ||
			(pat_d_amt_slot2 != 0) ||
			(pat_d_amt_slot3 != 0) || 
		(pat_d_amt_slot4 != 0)) || (nd_print_zero_bal.arr[0] == 'Y'))
     {
	
		print_pat_det();   
		statyn = 0;
		statyn1 = 0;
		
		fprintf(fp, " %37s","");

		print_formated(pat_d_tot_bal);     fprintf(fp," ");
		print_formated(pat_d_open_credit); fprintf(fp," ");
		print_formated(pat_d_amt_slot1);   fprintf(fp," ");
		print_formated(pat_d_amt_slot2);   fprintf(fp," ");
		print_formated(pat_d_amt_slot3);   fprintf(fp," ");
		print_formated(pat_d_amt_slot4);   fprintf(fp,"\n\n");

	    lctr += 3;
		pat_ctr++;
		
	    if (lctr > 58) print_head();   
	 }
 
   }

   rep_d_open_credit     += pat_d_open_credit;
   rep_d_tot_bal         += pat_d_tot_bal;
   rep_d_amt_slot1       += pat_d_amt_slot1;
   rep_d_amt_slot2       += pat_d_amt_slot2;
   rep_d_amt_slot3       += pat_d_amt_slot3;
   rep_d_amt_slot4       += pat_d_amt_slot4;

   pat_d_open_credit     = 0;
   pat_d_tot_bal         = 0;
   pat_d_amt_slot1       = 0;
   pat_d_amt_slot2       = 0;
   pat_d_amt_slot3       = 0;
   pat_d_amt_slot4       = 0;

   pat_pend_doc_ctr = 0;
}

print_report_footer()
{
  if (nd_rep_type.arr[0] == 'D')
  {
  if (lctr > 55 - 4) print_head();
  fprintf(fp, "\n %24s %s%s\n"," ","-------------------------------------",
     "---------------------------------------------------------------------");
  fprintf(fp, "%-22.22s :                          ",loc_legend[40]);
  print_formated(rep_d_open_credit); fprintf(fp," ");
  print_formated(rep_d_amt_slot1);   fprintf(fp," ");
  print_formated(rep_d_amt_slot2);   fprintf(fp," ");
  print_formated(rep_d_amt_slot3);   fprintf(fp," ");
  print_formated(rep_d_amt_slot4);   fprintf(fp,"\n");
  fprintf(fp, " %24s %s%s\n"," ","-------------------------------------",
     "---------------------------------------------------------------------");
  lctr += 4;

  if (lctr > 55 - 2) print_head();
  fprintf(fp, "%-18.18s : %6ld\n",loc_legend[41],pat_ctr);
  fprintf(fp, "%-17.17s: ",loc_legend[56]);
  print_formated(rep_d_tot_bal);   fprintf(fp,"\n");
  lctr += 2;
  }
  else 
  {
  if (lctr > 55 - 3) print_head();
  fprintf(fp, " %24s %s%s\n"," ","-------------------------------------",
     "---------------------------------------------------------------------");
  fprintf(fp, "%-22.22s :              ",loc_legend[40]);
  print_formated(rep_d_tot_bal);     fprintf(fp," ");
  print_formated(rep_d_open_credit); fprintf(fp," ");
  print_formated(rep_d_amt_slot1);   fprintf(fp," ");
  print_formated(rep_d_amt_slot2);   fprintf(fp," ");
  print_formated(rep_d_amt_slot3);   fprintf(fp," ");
  print_formated(rep_d_amt_slot4);   fprintf(fp,"\n");
  fprintf(fp, " %24s %s%s\n"," ","-------------------------------------",
     "---------------------------------------------------------------------");
  lctr += 3;

  if (lctr > 55 - 1) print_head();
  fprintf(fp, "%-18.18s : %6ld\n",loc_legend[41],pat_ctr);
  lctr ++;
  }
}

print_det_line()
{
   pat_pend_doc_ctr++;
   if (nd_rep_type.arr[0] == 'S')
	  return(0);

/*--- Added by Venkat on 18/10/1999 to print details corresponding 
  ----		to zero bal flag */
   if((nd_open_credit == 0) &&
      (bal_amt_slot1 == 0) &&
	  (bal_amt_slot2 == 0) &&
	  (bal_amt_slot3 == 0) &&
	  (bal_amt_slot4 == 0))
	  {

		return(0);
	  }
/*---------------- End of Addition --------------------*/
   if (lctr > 55 - 2) print_head();

   if(bldcp_pend_doc_date.arr[0]!='\0')
	{
	  init_date_temp_var();
	  strcpy(date_convert.arr,bldcp_pend_doc_date.arr);
	  fun_change_loc_date();
	  strcpy(bldcp_pend_doc_date.arr,nd_loc_date1.arr);
	}

	if(bldcp_pend_due_date.arr[0]!='\0')
	{
	  init_date_temp_var();
	  strcpy(date_convert.arr,bldcp_pend_due_date.arr);
	  fun_change_loc_date();
	  strcpy(bldcp_pend_due_date.arr,nd_loc_date1.arr);
	}
      
   fprintf(fp,"%-6s %8s  %-10s  %-10s  %-3.3s      ", 
	      bldcp_pend_doc_type_code.arr, bldcp_pend_doc_num.arr,
	      bldcp_pend_doc_date.arr, bldcp_pend_due_date.arr,
	      bldcp_pend_trx_short_desc.arr);
    lctr ++;

   print_formated(nd_open_credit);  fprintf(fp," ");
   print_formated(bal_amt_slot1);   fprintf(fp," ");
   print_formated(bal_amt_slot2);   fprintf(fp," ");
   print_formated(bal_amt_slot3);   fprintf(fp," ");
   print_formated(bal_amt_slot4);   fprintf(fp,"\n");

   if(strlen(bldcp_pend_pat_doc_ref.arr)) {
       fprintf(fp," %28s%s\n", " ", bldcp_pend_pat_doc_ref.arr);
       lctr++;
   }
   if(strlen(bldcp_pend_narration.arr)) {
	     fprintf(fp,"%-6.6s : %s\n",loc_legend[58],bldcp_pend_narration.arr);
       lctr++;
   }
   fflush(fp);
}

/************************** General Purpose Functions *************************/
sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )421;
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
    
   int i;              
		   
   strcpy(out_str,"");
   strcpy(out_str1,"");

   if (loc_amount == 0)
      fprintf(fp,"%-14s "," ");
   else if (loc_amount > 0)
   {                          
	  sprintf(out_str,"%11.2f",loc_amount);
      ltrim(out_str);put_comma(out_str);      
      strcpy(out_str1,"");
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1); 
      
      
   }
   else
   {                      
      sprintf(out_str,"%11.2f",-loc_amount);
      ltrim(out_str);put_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1); 

   }
}

/* This code added by Raghava for Internationalization at 20/11/2007 */

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';
     
		/* EXEC SQL SELECT LTRIM(RTRIM('BLRAGEAN.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRAGEAN.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )452;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&i;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_pk_value;
  sqlstm.sqhstl[1] = (unsigned int  )102;
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



		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_translated_value.arr[0]		= '\0';


		/* EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:nd_facility_id ,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:nd_lang_id);

      

		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )475;
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
  sqlstm.sqhstv[1] = (         void  *)&l_pk_value;
  sqlstm.sqhstl[1] = (unsigned int  )102;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[2] = (unsigned int  )203;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
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


       
		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
		
		
	}
}

get_local_date()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YY'),:nd_lang_id,t_date);

		 :nd_loc_date1:= to_char(t_date,'DD/MM/YYYY');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date1 , 'DD/MM/YY' ) , :nd_lang_id , t_date ) ; \
:nd_loc_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )506;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date1;
 sqlstm.sqhstl[0] = (unsigned int  )14;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date1;
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
}


     		
		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");


}

get_local_date1()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		 get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YY HH24:MI'),:nd_lang_id,t_date);

		 :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YY HH24:MI' ) , :nd_lang_id , t_da\
te ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )533;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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
        err_mesg("SELECTING Date failed",0,"");


}
init_date_temp_var()
{
nd_temp_date.arr[0] =  '\0';
nd_loc_date.arr[0]  =  '\0';
nd_temp_date1.arr[0]=  '\0';
nd_loc_date1.arr[0] =  '\0';
date_convert.arr[0] =  '\0';


nd_temp_date.len = 0;
nd_loc_date.len  = 0;
nd_temp_date1.len= 0;
nd_loc_date1.len = 0;
date_convert.len = 0;

}

fun_change_loc_date()
{

strcpy(nd_temp_date1.arr,date_convert.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);

get_local_date();

}

fun_change_loc_date1()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date1();

strcpy(date_convert.arr,nd_loc_date.arr); 
}

/* upto here */

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


list_args(arg_cnt, arg_list)
int arg_cnt;
char *arg_list[];
{
   int i;

   disp_message(ERR_MESG,"Not enough Parameters for running this program");
}

