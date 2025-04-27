
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
    "T:\\temp\\Bl\\ganapathy\\JDWORK\\PROC\\Blbpgdoc.pc"
};


static unsigned long sqlctx = 1267622685;


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
            void  *sqhstv[24];
   unsigned int   sqhstl[24];
            int   sqhsts[24];
            void  *sqindv[24];
            int   sqinds[24];
   unsigned int   sqharm[24];
   unsigned int   *sqharc[24];
   unsigned short  sqadto[24];
   unsigned short  sqtdso[24];
} sqlstm = {10,24};

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
"select SHORT_NAME_LOC_LANG ,SHORT_NAME  from MP_PATIENT_MAST where PATIENT_I\
D=:b0           ";

 static const char *sq0010 = 
"select BLACK_LISTED_YN ,FINANCIAL_REMARKS  from BL_PATIENT_FIN_DTLS where PA\
TIENT_ID=:b0           ";

 static const char *sq0011 = 
"select CONCAT_POST_ACC_DESC  from GL_POSTING_ACC where ((((((MAIN_ACC1_CODE=\
:b0 and MAIN_ACC2_CODE=:b1) and DEPT_CODE=:b2) and PRODUCT_GROUP_CODE=:b3) and\
 PRODUCT_LINE_CODE=:b4) and SUBLEDGER_GROUP_CODE=:b5) and SUBLEDGER_LINE_CODE=\
:b6)           ";

 static const char *sq0008 = 
"select PATIENT_ID ,ORG_DOC_TYPE_CODE ,ORG_DOC_NUMBER ,TO_CHAR(ORG_DOC_DATE,'\
DD/MM/YYYY') ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,PAT_DOC_REFERENCE ,DOC_NATURE_CO\
DE ,DOC_AMT ,DOC_OUTST_AMT ,TO_CHAR(FULLY_SETTLED_DATE,'DD/MM/YYYY') ,LAST_DOC\
_TYPE_CODE ,LAST_DOC_NUMBER ,TO_CHAR(LAST_DOC_DATE,'DD/MM/YYYY') ,MAIN_ACC1_CO\
DE ,MAIN_ACC2_CODE ,DEPT_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE ,SUBLEDGE\
R_GROUP_CODE ,SUBLEDGER_LINE_CODE ,EPISODE_TYPE ,EPISODE_ID ,VISIT_ID ,ROWID  \
from BL_DCP_PENDING_DOC where (((operating_facility_id=:b0 and DOC_OUTST_AMT=0\
) and PATIENT_ID between NVL(:b1,'!!!!!!!!!!') and NVL(:b2,'~~~~~~~~~~')) and \
TRUNC(FULLY_SETTLED_DATE)<=(TO_DATE(:b3,'DD/MM/YYYY')-NVL(:b4,0))) order by PA\
TIENT_ID,ORG_DOC_TYPE_CODE,ORG_DOC_NUMBER            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,29,186,0,0,0,0,0,1,0,
20,0,0,2,0,0,30,199,0,0,0,0,0,1,0,
35,0,0,3,54,0,1,206,0,0,0,0,0,1,0,
50,0,0,4,46,0,1,214,0,0,0,0,0,1,0,
65,0,0,5,169,0,4,239,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,
0,0,1,9,0,0,
108,0,0,6,91,0,2,263,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
131,0,0,7,0,0,29,272,0,0,0,0,0,1,0,
146,0,0,9,92,0,9,346,0,0,1,1,0,1,0,1,9,0,0,
165,0,0,9,0,0,13,351,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
188,0,0,10,99,0,9,367,0,0,1,1,0,1,0,1,9,0,0,
207,0,0,10,0,0,13,372,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
230,0,0,11,247,0,9,384,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
273,0,0,11,0,0,13,389,0,0,1,0,0,1,0,2,9,0,0,
292,0,0,12,89,0,4,520,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
315,0,0,13,128,0,4,540,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
346,0,0,8,753,0,9,556,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
381,0,0,8,0,0,13,614,0,0,24,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
492,0,0,14,48,0,2,711,0,0,1,1,0,1,0,1,9,0,0,
511,0,0,15,69,0,2,723,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
534,0,0,16,0,0,27,820,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLBPGDOC.PC                                  */
/* AUTHOR                : NITIN NAIK                                   */
/* Converted To Windows  : Prasad B G S 3/7/96                          */
/* DATE WRITTEN          : 20-JUN-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */  
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        BL_DCP_PENDING_DOC       Query/Delete              */
/*         2.        BL_DCP_TRN               Query/Delete              */
/*         3.        SY_PROG_CONTROL          Update/Lookup             */
/*         4.        SY_PROG_MESG             Insert/Delete             */
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
#include <math.h>
#include <string.h>
#include <bl.h>

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

#define RESOURCE_BUSY        (sqlca.sqlcode == -54)

/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd                              [132]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;


   /* VARCHAR  nd_session_id                       [16],
            nd_pgm_date                         [25],
            hosp_name                           [120],
            date_time                           [20],
            user_id                             [30]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[30]; } user_id;


   /* VARCHAR  nd_purge_cutoff_date                [12],
	   		nd_facility_id  [3],
            nd_purge_flag                       [2],
            nd_fm_patient_id                    [21],
            nd_to_patient_id                    [21]; */ 
struct { unsigned short len; unsigned char arr[12]; } nd_purge_cutoff_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[2]; } nd_purge_flag;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;


  long      blparam_ret_full_set_doc_day;

   /* VARCHAR  bldcp_pend_patient_id               [21],
            bldcp_pend_org_doc_type_code        [7],
            bldcp_pend_org_doc_number           [9],
            bldcp_pend_org_doc_date             [11],
            bldcp_pend_due_date                 [11],
            bldcp_pend_pat_doc_reference        [11],
            bldcp_pend_doc_nature_code          [5],
            bldcp_pend_fully_settled_dat       [11],
            bldcp_pend_last_doc_type_cod       [7],
            bldcp_pend_last_doc_number          [9],
            bldcp_pend_last_doc_date            [11],
            bldcp_pend_main_acc1_code           [7],
            bldcp_pend_main_acc2_code           [5],
            bldcp_pend_dept_code                [7],
            bldcp_pend_product_grp_cod       [4],
            bldcp_pend_product_line_cod        [5],
            bldcp_pend_subledger_grp_cod     [4],
            bldcp_pend_subledger_lin_cod      [9],
            bldcp_pend_episode_type             [2],
            bldcp_pend_episode_id               [9],
            bldcp_pend_visit_id                 [5],
            bldcp_pend_rowid                    [19]; */ 
struct { unsigned short len; unsigned char arr[21]; } bldcp_pend_patient_id;

struct { unsigned short len; unsigned char arr[7]; } bldcp_pend_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bldcp_pend_org_doc_number;

struct { unsigned short len; unsigned char arr[11]; } bldcp_pend_org_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bldcp_pend_due_date;

struct { unsigned short len; unsigned char arr[11]; } bldcp_pend_pat_doc_reference;

struct { unsigned short len; unsigned char arr[5]; } bldcp_pend_doc_nature_code;

struct { unsigned short len; unsigned char arr[11]; } bldcp_pend_fully_settled_dat;

struct { unsigned short len; unsigned char arr[7]; } bldcp_pend_last_doc_type_cod;

struct { unsigned short len; unsigned char arr[9]; } bldcp_pend_last_doc_number;

struct { unsigned short len; unsigned char arr[11]; } bldcp_pend_last_doc_date;

struct { unsigned short len; unsigned char arr[7]; } bldcp_pend_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bldcp_pend_main_acc2_code;

struct { unsigned short len; unsigned char arr[7]; } bldcp_pend_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bldcp_pend_product_grp_cod;

struct { unsigned short len; unsigned char arr[5]; } bldcp_pend_product_line_cod;

struct { unsigned short len; unsigned char arr[4]; } bldcp_pend_subledger_grp_cod;

struct { unsigned short len; unsigned char arr[9]; } bldcp_pend_subledger_lin_cod;

struct { unsigned short len; unsigned char arr[2]; } bldcp_pend_episode_type;

struct { unsigned short len; unsigned char arr[9]; } bldcp_pend_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bldcp_pend_visit_id;

struct { unsigned short len; unsigned char arr[19]; } bldcp_pend_rowid;


   double   bldcp_pend_doc_amt,
            bldcp_pend_doc_outst_amt;

   /* VARCHAR  patfndt_black_listed_yn             [2],
            patfndt_fin_remarks                 [41]; */ 
struct { unsigned short len; unsigned char arr[2]; } patfndt_black_listed_yn;

struct { unsigned short len; unsigned char arr[41]; } patfndt_fin_remarks;

   
   /* VARCHAR  gl_posting_desc                     [64]; */ 
struct { unsigned short len; unsigned char arr[64]; } gl_posting_desc;


   /* VARCHAR  mppat_short_name_loc_lang           [61],
            mppat_short_name                    [61]; */ 
struct { unsigned short len; unsigned char arr[61]; } mppat_short_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } mppat_short_name;


/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;   
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLBPGDOC.C-arc   1.0   Apr 19 2007 17:04:16   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLBPGDOC.C-arc   1.0   Apr 19 2007 17:04:16   vcm_th  $ sqlda.h 
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

int delete_cnt = 0;

char old_patient_id[21];
char filename [150];
char string_var [100];

long pat_ctr, pat_pend_doc_ctr, pend_doc_ctr;

FILE *fp;
int lctr = 0,pctr =0;

void proc_main(argc,argv)
char *argv[];
int argc;
{

   if (argc < 5)
   {
      list_args(argc, argv);
      proc_exit();
   }

   strcpy(g_pgm_id,"BLBPGDOC");
 
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle");
      proc_exit();
   }

   set_meduser_role();
   strcpy(g_pgm_date,argv[3]);

   fetch_param();

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/

   start_prog_msg();
 
   fetch_desc();
   fetch_bl_param();

   delete_prog_param();
   lock_tables();

   open_files();
   declare_cursors();
   open_pending_doc();
   pend_doc_ctr = 0;
   old_patient_id[0] = '\0';
   pat_ctr = 0;
   pat_pend_doc_ctr = 0;
   while (fetch_pending_doc())
   {
      pend_doc_ctr++;
      get_other_details();
      if (strcmp(old_patient_id,bldcp_pend_patient_id.arr))
      {
         pat_ctr++;
         if (strlen(old_patient_id))
            print_pat_footer();
         print_pat_det();
         strcpy(old_patient_id,bldcp_pend_patient_id.arr);
      }
      print_details();
      if (nd_purge_flag.arr[0] == 'Y')
      {
              delete_pending_doc();
              delete_bldcp_trn();
      }
      /* EXEC SQL COMMIT WORK; */ 

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


      if (OERROR)
          err_mesg("COMMIT failed",0,"");
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
   sqlstm.offset = (unsigned int  )20;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   return;
}

lock_tables()
{
   /* EXEC SQL LOCK TABLE BL_DCP_PENDING_DOC
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE BL_DCP_PENDING_DOC IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )35;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2200");
   else if (OERROR)
           err_mesg("LOCK failed on table BL_DCP_PENDING_DOC",0,"");
 
   /* EXEC SQL LOCK TABLE BL_DCP_TRN
              IN EXCLUSIVE MODE NOWAIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "lock TABLE BL_DCP_TRN IN EXCLUSIVE MODE NOWAIT";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )50;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (RESOURCE_BUSY)
         err_mesg("",1,"AR2210");
   else if (OERROR)
           err_mesg("LOCK failed on table BL_DCP_TRN",0,"");

}    

fetch_param()
{
   nd_purge_cutoff_date.arr[0]  = '\0';
   nd_fm_patient_id.arr[0]      = '\0';
   nd_to_patient_id.arr[0]      = '\0';
   nd_purge_flag.arr[0]         = '\0';
	nd_facility_id.arr[0]  = '\0';


   nd_purge_cutoff_date.len     = 0;
   nd_fm_patient_id.len         = 0;
   nd_to_patient_id.len         = 0;
   nd_purge_flag.len            = 0;
   nd_facility_id.len  = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,PARAM1,PARAM2,
                   PARAM3,  PARAM4
            INTO   :nd_facility_id,:nd_purge_cutoff_date, 
				   :nd_purge_flag,:nd_fm_patient_id,:nd_to_patient_id
            FROM   SY_PROG_PARAM
            WHERE  PGM_ID     = 'BLBPGDOC'
            AND    SESSION_ID = :nd_session_id
            AND    PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 into :b0,:b1,:b2,:b3,:b4  from SY_PROG_PARAM where ((PGM_ID='BLBPGDOC' and \
SESSION_ID=:b5) and PGM_DATE=:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )65;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_purge_cutoff_date;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_purge_flag;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_patient_id;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[5] = (unsigned int  )18;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[6] = (unsigned int  )27;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   nd_purge_cutoff_date.arr[nd_purge_cutoff_date.len] = 0;
   nd_fm_patient_id.arr[nd_fm_patient_id.len]         = 0;
   nd_to_patient_id.arr[nd_to_patient_id.len]         = 0;
   nd_purge_flag.arr[nd_purge_flag.len]               = 0;
  nd_facility_id.arr[nd_facility_id.len] = '\0';

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");
}

delete_prog_param()
{
   /* EXEC SQL DELETE
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'BLBPGDOC'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLBPGDOC' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )108;
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
   sqlstm.sqhstl[1] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   /* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )131;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
         err_mesg("COMMIT failed",0,""); 
}

declare_cursors()
{

     /* EXEC SQL DECLARE BL_DCP_PENDING_DOC_CUR CURSOR FOR
               SELECT PATIENT_ID,
                      ORG_DOC_TYPE_CODE,
                      ORG_DOC_NUMBER,
                      TO_CHAR(ORG_DOC_DATE,'DD/MM/YYYY'),
                      TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                      PAT_DOC_REFERENCE,
                      DOC_NATURE_CODE,
                      DOC_AMT,
                      DOC_OUTST_AMT,
                      TO_CHAR(FULLY_SETTLED_DATE,'DD/MM/YYYY'),
                      LAST_DOC_TYPE_CODE,
		      LAST_DOC_NUMBER,
                      TO_CHAR(LAST_DOC_DATE,'DD/MM/YYYY'),
                      MAIN_ACC1_CODE,
                      MAIN_ACC2_CODE,
                      DEPT_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
		      EPISODE_TYPE,
		      EPISODE_ID,
		      VISIT_ID,
                      ROWID
               FROM   BL_DCP_PENDING_DOC
               WHERE  operating_facility_id = :nd_facility_id AND
			   DOC_OUTST_AMT = 0
               AND    PATIENT_ID BETWEEN NVL(:nd_fm_patient_id,'!!!!!!!!!!')
                                 AND     NVL(:nd_to_patient_id,'~~~~~~~~~~')
               AND    TRUNC(FULLY_SETTLED_DATE) <= TO_DATE(:nd_purge_cutoff_date,
                                                       'DD/MM/YYYY') -
                                        NVL(:blparam_ret_full_set_doc_day,0)
               ORDER BY PATIENT_ID, ORG_DOC_TYPE_CODE,ORG_DOC_NUMBER; */ 


     /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
               SELECT SHORT_NAME_LOC_LANG, SHORT_NAME
               FROM   MP_PATIENT_MAST
               WHERE  PATIENT_ID = :bldcp_pend_patient_id; */ 


     /* EXEC SQL DECLARE BL_PATIENT_FIN_DTLS_CUR CURSOR FOR 
               SELECT BLACK_LISTED_YN, FINANCIAL_REMARKS
               FROM   BL_PATIENT_FIN_DTLS
               WHERE  PATIENT_ID = :bldcp_pend_patient_id; */ 


     /* EXEC SQL DECLARE GL_POSTING_ACC_CUR CURSOR FOR
               SELECT CONCAT_POST_ACC_DESC
               FROM   GL_POSTING_ACC
               WHERE  MAIN_ACC1_CODE       = :bldcp_pend_main_acc1_code
               AND    MAIN_ACC2_CODE       = :bldcp_pend_main_acc2_code
               AND    DEPT_CODE            = :bldcp_pend_dept_code
               AND    PRODUCT_GROUP_CODE   = :bldcp_pend_product_grp_cod
               AND    PRODUCT_LINE_CODE    = :bldcp_pend_product_line_cod
               AND    SUBLEDGER_GROUP_CODE = :bldcp_pend_subledger_grp_cod
               AND    SUBLEDGER_LINE_CODE  = :bldcp_pend_subledger_lin_cod; */ 


}

get_other_details()
{
   mppat_short_name_loc_lang.arr[0] = '\0';
   mppat_short_name_loc_lang.len    = 0;
   mppat_short_name.arr[0]          = '\0';
   mppat_short_name.len             = 0;

   /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )146;
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
      err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

   /* EXEC SQL FETCH MP_PATIENT_MAST_CUR
            INTO  :mppat_short_name_loc_lang, :mppat_short_name; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )165;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&mppat_short_name_loc_lang;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&mppat_short_name;
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


 
   if (OERROR)
      err_mesg("FETCH failed on cursor MP_PATIENT_MAST_CUR",0,"");

   mppat_short_name_loc_lang.arr[mppat_short_name_loc_lang.len] = '\0';
   mppat_short_name.arr[mppat_short_name.len]                   = '\0';

   patfndt_black_listed_yn.arr[0] = '\0';
   patfndt_fin_remarks.arr[0]     = '\0';
   
   patfndt_black_listed_yn.len    = 0;
   patfndt_fin_remarks.len        = 0;


   /* EXEC SQL OPEN BL_PATIENT_FIN_DTLS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0010;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )188;
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
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )207;
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

   gl_posting_desc.arr[0]    = '\0';
   gl_posting_desc.len       = 0;

   /* EXEC SQL OPEN GL_POSTING_ACC_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )230;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bldcp_pend_main_acc1_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bldcp_pend_main_acc2_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bldcp_pend_dept_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bldcp_pend_product_grp_cod;
   sqlstm.sqhstl[3] = (unsigned int  )6;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&bldcp_pend_product_line_cod;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&bldcp_pend_subledger_grp_cod;
   sqlstm.sqhstl[5] = (unsigned int  )6;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&bldcp_pend_subledger_lin_cod;
   sqlstm.sqhstl[6] = (unsigned int  )11;
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



   if (OERROR)
      err_mesg("OPEN failed on cursor GL_POSTING_ACC_CUR",0,"");

   /* EXEC SQL FETCH GL_POSTING_ACC_CUR
            INTO :gl_posting_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )273;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&gl_posting_desc;
   sqlstm.sqhstl[0] = (unsigned int  )66;
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
      err_mesg("FETCH failed on cursor GL_POSTING_ACC_CUR",0,"");

   gl_posting_desc.arr[gl_posting_desc.len] = '\0';
}

open_files()
{
//  char err_stmt[70];
	
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blbpgdoc.lis");

   if ((fp = fopen(filename,"w")) == NULL)
   {
     //   sprintf(err_stmt,"Error while opening File %s","blbpgdoc.lis");
	 sprintf(string_var,"Error while opening File %s",filename);
	 disp_message(ERR_MESG,string_var);
	      
    //    err_mesg(err_stmt,0,"");
        proc_exit();
   }

   print_title();
   print_head();
}

print_title()
{
 
  fprintf(fp, "\n\nMDL : BL %38s  %-30s %34s  %-15s\n", "",
                                        hosp_name.arr,"",date_time.arr);
  fprintf(fp, "OPR : %-10s\n", user_id.arr);
  fprintf(fp, "REP : %-8s %32s  %s %40s PAGE : %4d\n",
        g_pgm_id,"","FULLY SETTLED DCP DOCUMENTS REPORT","",++pctr);
  fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
  fprintf(fp,"VER : 1.10.01\n");
  fflush(fp);

  fprintf(fp,"\n\n\n\n %6s INPUT PARAMETERS :\n %6s ----------------\n\n",
                                                                      "","");
  fprintf(fp," %14s FACILITY ID         : %s\n\n","",nd_facility_id.arr); 
  fprintf(fp," %14s PURGE DOCUMENTS     : %s\n\n","",nd_purge_flag.arr);
  fprintf(fp," %14s PURGING CUTOFF DATE : %-10s\n\n","",
                                                    nd_purge_cutoff_date.arr);
  fprintf(fp," %14s PATIENT NO     FROM : %-10s\n","" ,nd_fm_patient_id.arr);
  fprintf(fp," %14s                  TO : %-10s\n\n","",nd_to_patient_id.arr);

  fflush(fp);
}

print_head()
{
  fprintf(fp, "\f\n\nMDL : BL %38s  %-30s %34s  %-15s\n", "",
                                        hosp_name.arr,"",date_time.arr);
  fprintf(fp, "OPR : %-10s\n", user_id.arr);
  fprintf(fp, "REP : %-8s %32s  %s %40s PAGE : %4d\n",
                       g_pgm_id,"","FULLY SETTLED DCP DOCUMENTS REPORT","",++pctr);
  fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
  fprintf(fp, "DOC TYPE/NUMBER  DOC DATE   DUE DATE   DOC REFERENCE  ");
  fprintf(fp, "DOC NATURE        DOC AMT  OUTSTANDING AMT  EPISODE TYPE/ID");
  fprintf(fp, "  VISIT NO\n");
  fprintf(fp, " %15s POSTING ACCOUNT & DESCRIPTION\n","");
  fprintf(fp, " %26s LAST SETTL. DATE  LAST DOC TYPE/NUMBER  LAST DOC DATE\n",
                                                                  "");
  fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
  fflush(fp);
  lctr = 10;
}

print_pat_det()
{
  if (lctr > 55 - 2) print_head();

  fprintf(fp,"PATIENT NO : %-20s %-16.16s %-30.30s %1.1s %-40.40s\n\n",
               bldcp_pend_patient_id.arr,mppat_short_name_loc_lang.arr,
               mppat_short_name.arr, patfndt_black_listed_yn.arr,
               patfndt_fin_remarks.arr);
  lctr += 2;
}

print_pat_footer()
{
   if (lctr > 55 - 3) print_head();

   fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
   fprintf(fp, "NUMBER OF DOCUMENTS PRINTED : %6ld\n\n", pat_pend_doc_ctr);
   
   lctr += 3;

   pat_pend_doc_ctr = 0;
}

print_report_footer()
{
  if (lctr > 55 - 2) print_head();

  fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
  fprintf(fp, "NUMBER OF PATIENTS : %6ld\n", pat_ctr);
  lctr += 2;
}

print_end()
{
  if (lctr > 55 - 5) print_head();

  fprintf(fp, "\n\n\n  %50s  **   END  OF  REPORT   ** \n\n","");
  fflush(fp);
  fclose(fp);
}

fetch_bl_param()
{
   /* EXEC SQL SELECT RET_FULL_SET_DOC_DAYS
              INTO :blparam_ret_full_set_doc_day
              FROM BL_PARAMETERS
			  WHERE operating_facility_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select RET_FULL_SET_DOC_DAYS into :b0  from BL_PARAMETERS \
where operating_facility_id=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )292;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&blparam_ret_full_set_doc_day;
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


  
   if (OERROR)
         err_mesg("SELECT failed on table BL_PARAMETERS",0,"");

}

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
			  WHERE acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )315;
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
   sqlstm.sqhstl[2] = (unsigned int  )32;
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



   if (OERROR)
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';
}

open_pending_doc()
{
   /* EXEC SQL OPEN BL_DCP_PENDING_DOC_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )346;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_purge_cutoff_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&blparam_ret_full_set_doc_day;
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



   if (OERROR)
      err_mesg("OPEN failed on cursor BL_DCP_PENDING_DOC_CUR",0,"");
}

fetch_pending_doc()
{

   bldcp_pend_patient_id.arr[0]           = '\0';
   bldcp_pend_org_doc_type_code.arr[0]    = '\0';
   bldcp_pend_org_doc_number.arr[0]       = '\0';
   bldcp_pend_org_doc_date.arr[0]         = '\0';
   bldcp_pend_due_date.arr[0]             = '\0';
   bldcp_pend_pat_doc_reference.arr[0]    = '\0';
   bldcp_pend_doc_nature_code.arr[0]      = '\0';
   bldcp_pend_fully_settled_dat.arr[0]   = '\0';
   bldcp_pend_last_doc_type_cod.arr[0]   = '\0';
   bldcp_pend_last_doc_number.arr[0]      = '\0';
   bldcp_pend_last_doc_date.arr[0]        = '\0';
   bldcp_pend_main_acc1_code.arr[0]       = '\0';
   bldcp_pend_main_acc2_code.arr[0]       = '\0';
   bldcp_pend_dept_code.arr[0]            = '\0';
   bldcp_pend_product_grp_cod.arr[0]   = '\0';
   bldcp_pend_product_line_cod.arr[0]    = '\0';
   bldcp_pend_subledger_grp_cod.arr[0] = '\0';
   bldcp_pend_subledger_lin_cod.arr[0]  = '\0';
   bldcp_pend_episode_type.arr[0]         = '\0';
   bldcp_pend_episode_id.arr[0]           = '\0';
   bldcp_pend_visit_id.arr[0]             = '\0';
   bldcp_pend_rowid.arr[0]                = '\0';

   bldcp_pend_patient_id.len              = 0;
   bldcp_pend_org_doc_type_code.len       = 0;
   bldcp_pend_org_doc_number.len          = 0;
   bldcp_pend_org_doc_date.len            = 0;
   bldcp_pend_due_date.len                = 0;
   bldcp_pend_pat_doc_reference.len       = 0;
   bldcp_pend_doc_nature_code.len         = 0;
   bldcp_pend_fully_settled_dat.len      = 0;
   bldcp_pend_last_doc_type_cod.len      = 0;
   bldcp_pend_last_doc_number.len         = 0;
   bldcp_pend_last_doc_date.len           = 0;
   bldcp_pend_main_acc1_code.len          = 0;
   bldcp_pend_main_acc2_code.len          = 0;
   bldcp_pend_dept_code.len               = 0;
   bldcp_pend_product_grp_cod.len      = 0;
   bldcp_pend_product_line_cod.len       = 0;
   bldcp_pend_subledger_grp_cod.len    = 0;
   bldcp_pend_subledger_lin_cod.len     = 0;
   bldcp_pend_episode_type.len            = 0;
   bldcp_pend_episode_id.len              = 0;
   bldcp_pend_visit_id.len                = 0;
   bldcp_pend_rowid.len                   = 0;

   bldcp_pend_doc_amt                     = 0;
   bldcp_pend_doc_outst_amt               = 0;

   /* EXEC SQL FETCH BL_DCP_PENDING_DOC_CUR
             INTO :bldcp_pend_patient_id,
                  :bldcp_pend_org_doc_type_code,
                  :bldcp_pend_org_doc_number,
                  :bldcp_pend_org_doc_date,
                  :bldcp_pend_due_date,
                  :bldcp_pend_pat_doc_reference,
                  :bldcp_pend_doc_nature_code,
                  :bldcp_pend_doc_amt,
                  :bldcp_pend_doc_outst_amt,
                  :bldcp_pend_fully_settled_dat,
                  :bldcp_pend_last_doc_type_cod,
                  :bldcp_pend_last_doc_number,
                  :bldcp_pend_last_doc_date,
                  :bldcp_pend_main_acc1_code,
                  :bldcp_pend_main_acc2_code,
                  :bldcp_pend_dept_code,
                  :bldcp_pend_product_grp_cod,
                  :bldcp_pend_product_line_cod,
                  :bldcp_pend_subledger_grp_cod,
                  :bldcp_pend_subledger_lin_cod,
                  :bldcp_pend_episode_type,
                  :bldcp_pend_episode_id,
                  :bldcp_pend_visit_id,
                  :bldcp_pend_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )381;
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
   sqlstm.sqhstv[1] = (         void  *)&bldcp_pend_org_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bldcp_pend_org_doc_number;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bldcp_pend_org_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&bldcp_pend_due_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&bldcp_pend_pat_doc_reference;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&bldcp_pend_doc_nature_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&bldcp_pend_doc_amt;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&bldcp_pend_doc_outst_amt;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&bldcp_pend_fully_settled_dat;
   sqlstm.sqhstl[9] = (unsigned int  )13;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&bldcp_pend_last_doc_type_cod;
   sqlstm.sqhstl[10] = (unsigned int  )9;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&bldcp_pend_last_doc_number;
   sqlstm.sqhstl[11] = (unsigned int  )11;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&bldcp_pend_last_doc_date;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&bldcp_pend_main_acc1_code;
   sqlstm.sqhstl[13] = (unsigned int  )9;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&bldcp_pend_main_acc2_code;
   sqlstm.sqhstl[14] = (unsigned int  )7;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&bldcp_pend_dept_code;
   sqlstm.sqhstl[15] = (unsigned int  )9;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&bldcp_pend_product_grp_cod;
   sqlstm.sqhstl[16] = (unsigned int  )6;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&bldcp_pend_product_line_cod;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&bldcp_pend_subledger_grp_cod;
   sqlstm.sqhstl[18] = (unsigned int  )6;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&bldcp_pend_subledger_lin_cod;
   sqlstm.sqhstl[19] = (unsigned int  )11;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&bldcp_pend_episode_type;
   sqlstm.sqhstl[20] = (unsigned int  )4;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&bldcp_pend_episode_id;
   sqlstm.sqhstl[21] = (unsigned int  )11;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&bldcp_pend_visit_id;
   sqlstm.sqhstl[22] = (unsigned int  )7;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&bldcp_pend_rowid;
   sqlstm.sqhstl[23] = (unsigned int  )21;
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
}



if (OERROR)
         err_mesg("FETCH failed on cursor BL_DCP_PENDING_DOC",0,"");

bldcp_pend_patient_id.arr[bldcp_pend_patient_id.len]                     = '\0';
bldcp_pend_org_doc_type_code.arr[bldcp_pend_org_doc_type_code.len]       = '\0';
bldcp_pend_org_doc_number.arr[bldcp_pend_org_doc_number.len]             = '\0';
bldcp_pend_org_doc_date.arr[bldcp_pend_org_doc_date.len]                 = '\0';
bldcp_pend_due_date.arr[bldcp_pend_due_date.len]                         = '\0';
bldcp_pend_pat_doc_reference.arr[bldcp_pend_pat_doc_reference.len]       = '\0';
bldcp_pend_doc_nature_code.arr[bldcp_pend_doc_nature_code.len]           = '\0';
bldcp_pend_fully_settled_dat.arr[bldcp_pend_fully_settled_dat.len]     = '\0';
bldcp_pend_last_doc_type_cod.arr[bldcp_pend_last_doc_type_cod.len]     = '\0';
bldcp_pend_last_doc_number.arr[bldcp_pend_last_doc_number.len]           = '\0';
bldcp_pend_last_doc_date.arr[bldcp_pend_last_doc_date.len]               = '\0';
bldcp_pend_main_acc1_code.arr[bldcp_pend_main_acc1_code.len]             = '\0';
bldcp_pend_main_acc2_code.arr[bldcp_pend_main_acc2_code.len]             = '\0';
bldcp_pend_dept_code.arr[bldcp_pend_dept_code.len]                       = '\0';
bldcp_pend_product_grp_cod.arr[bldcp_pend_product_grp_cod.len]     = '\0';
bldcp_pend_product_line_cod.arr[bldcp_pend_product_line_cod.len]       = '\0';
bldcp_pend_subledger_grp_cod.arr[bldcp_pend_subledger_grp_cod.len] = '\0';
bldcp_pend_subledger_lin_cod.arr[bldcp_pend_subledger_lin_cod.len]   = '\0';
bldcp_pend_episode_type.arr[bldcp_pend_episode_type.len]                 = '\0';
bldcp_pend_episode_id.arr[bldcp_pend_episode_id.len]                     = '\0';
bldcp_pend_visit_id.arr[bldcp_pend_visit_id.len]                         = '\0';
bldcp_pend_rowid.arr[bldcp_pend_rowid.len]                               = '\0';

   if (LAST_ROW) return (0);
   else return (1);
}

print_details()
{
   if (lctr > 55 - 3) print_head();

   pat_pend_doc_ctr++;
   fprintf(fp,"%-6s %8s  %-10s %-10s %-10s     %4s       ",
             bldcp_pend_org_doc_type_code.arr, bldcp_pend_org_doc_number.arr,
             bldcp_pend_org_doc_date.arr, bldcp_pend_due_date.arr,
             bldcp_pend_pat_doc_reference.arr, bldcp_pend_doc_nature_code.arr);
            
      print_formated(bldcp_pend_doc_amt);    fprintf(fp,"  ");
      print_formated(bldcp_pend_doc_outst_amt); fprintf(fp,"  ");

   fprintf(fp," %-1s      %8s      %4s\n",
             bldcp_pend_episode_type.arr, bldcp_pend_episode_id.arr,
             bldcp_pend_visit_id.arr);

   fprintf(fp," %15s %-6s-%-4s %-6s %-3s-%-4s %-3s-%-8s  ", "",
             bldcp_pend_main_acc1_code.arr,
             bldcp_pend_main_acc2_code.arr,
             bldcp_pend_dept_code.arr,
             bldcp_pend_product_grp_cod.arr,
             bldcp_pend_product_line_cod.arr,
             bldcp_pend_subledger_grp_cod.arr,
             bldcp_pend_subledger_lin_cod.arr);

   fprintf(fp,"%-s\n",gl_posting_desc.arr);

   fprintf(fp," %25s  %-10s        %-6s %8s       %-10s\n", "",
                            bldcp_pend_fully_settled_dat.arr,
                            bldcp_pend_last_doc_type_cod.arr,
                            bldcp_pend_last_doc_number.arr,
                            bldcp_pend_last_doc_date.arr);
   lctr += 3;
   fflush(fp);
}

delete_pending_doc()
{
    if (nd_purge_flag.arr[0] != 'Y') 
       return(0);
    /* EXEC SQL DELETE BL_DCP_PENDING_DOC
              WHERE ROWID = :bldcp_pend_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from BL_DCP_PENDING_DOC  where ROWID=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )492;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bldcp_pend_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )21;
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
         err_mesg("DELETE failed on table BL_DCP_PENDING_DOC",0,"");

}

delete_bldcp_trn()
{
   if (nd_purge_flag.arr[0] != 'Y') 
      return(0);
   /* EXEC SQL DELETE FROM BL_DCP_TRN
             WHERE DOC_TYPE_CODE = :bldcp_pend_org_doc_type_code
               AND DOC_NUMBER    = :bldcp_pend_org_doc_number; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from BL_DCP_TRN  where (DOC_TYPE_CODE=:b0 and DOC_\
NUMBER=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )511;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bldcp_pend_org_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bldcp_pend_org_doc_number;
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
}



   if (OERROR)
         err_mesg("DELETE failed on table BL_DCP_TRN",0,"");

}

/************************* General Purpose Functions **************************/
print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount == 0)
      fprintf(fp,"%-14s"," ");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%11.2f",loc_amount);
      ltrim(out_str);format_amt(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s",out_str1);
   }
   else
   {
      sprintf(out_str,"%11.2f",-loc_amount);
      ltrim(out_str);format_amt(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14sCR",out_str1);      
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

/* This function is now included in err_mesg.pc
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

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )534;
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
