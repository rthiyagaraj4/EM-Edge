
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
           char  filnam[22];
};
static const struct sqlcxp sqlfpn =
{
    21,
    "C:\\10xdev\\Blrdepcl.pc"
};


static unsigned long sqlctx = 139597675;


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
            void  *sqhstv[25];
   unsigned int   sqhstl[25];
            int   sqhsts[25];
            void  *sqindv[25];
            int   sqinds[25];
   unsigned int   sqharm[25];
   unsigned int   *sqharc[25];
   unsigned short  sqadto[25];
   unsigned short  sqtdso[25];
} sqlstm = {10,25};

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

 static const char *sq0004 = 
"DATE(:b8,'DD/MM/YYYY'),to_date('4712\
3112','YYYYDDMM'))) and TRX_TYPE_CODE='5') and RECPT_NATURE_CODE='RD') and NV\
L(DOC_OUTST_AMT,0)<>0) and OPERATING_FACILITY_ID=:b9) order by EPISODE_TYPE,P\
ATIENT_ID,EPISODE_ID,VISIT_ID,ORG_DOC_TYPE_CODE,ORG_DOC_NUM            ";

 static const char *sq0005 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TRUNC(DOC_DATE) ,TO_CHAR(DOC_AMT,'999,999,99\
0.99') ,DOC_AMT ,TRX_TYPE_CODE ,BILL_TRX_TYPE_CODE ,RECPT_NATURE_CODE ,SUBSTR\
(DECODE(BILL_TRX_TYPE_CODE,'D','Inpatients Discharge Bill','A','Inpatients Af\
ter Dischg Bill','I','Inpatients Inhouse Bill','O','Outpatients Bill','E','Ou\
tpatients Episode Level Bill','R','Referral Patients Bill',''),1,30)  from BL\
_PATIENT_LEDGER_TRN where ((((((EPISODE_TYPE=:b0 and EPISODE_ID=:b1) and PATI\
ENT_ID=:b2) and VISIT_ID=:b3) and ORG_DOC_TYPE_CODE=:b4) and ORG_DOC_NUM=:b5)\
 and OPERATING_FACILITY_ID=:b6) order by DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0006 = 
"select decode(:b0,'en',substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1\
,30)) ,null   from MP_PATIENT_MAST where PATIENT_ID=:b1           ";

 static const char *sq0007 = 
"select LONG_DESC  from BL_RECEIPT_TYPE_lang_vw where (RECEIPT_TYPE_CODE=:b0\
 and language_id=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,258,0,0,0,0,0,1,0,
20,0,0,2,265,0,4,299,0,0,16,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
99,0,0,3,84,0,2,345,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
126,0,0,4,1285,0,9,473,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
181,0,0,5,611,0,9,480,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
224,0,0,4,0,0,13,541,0,0,25,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,
0,
339,0,0,5,0,0,13,622,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,
390,0,0,6,141,0,9,650,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
413,0,0,6,0,0,13,663,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
436,0,0,8,515,0,6,678,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
463,0,0,7,107,0,9,710,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
486,0,0,7,0,0,13,718,0,0,1,0,0,1,0,2,9,0,0,
505,0,0,9,158,0,4,1056,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
540,0,0,10,96,0,4,1100,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
563,0,0,11,165,0,6,1107,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
594,0,0,12,143,0,6,1127,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*************************************************************************/
/* OCS MEDICOM VER 1.0                                                    */
/************************************************************************/
/* PROGRAM NAME          : BLRDEPCL.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 18-AUG-1993                                  */
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
#include <bl.h>         

#define ESC 0x1B
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])

/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [91],
            nd_session_id                              [31],
            nd_pgm_date                                [25],
			nd_temp_date							   [21],
			p_language_id							   [3],
			date_convert							   [21],
			nd_loc_date								   [21],
            d_curr_pgm_name                            [15],
            nd_epi_type                                [2],
            nd_fm_date                                 [12],
            nd_to_date                                 [12],
            nd_fm_pat_no                               [21],
            nd_to_pat_no                               [21],
            nd_fm_epi_no                               [9],
            nd_to_epi_no                               [9],
            nd_fm_visit_no                             [5],
            nd_to_visit_no                             [5],
            nd_show_dtls                               [2],
			nd_operating_facility_id                   [3],
			nd_facility_id							   [3],

            nd_fm_date_prn                             [15],
            nd_to_date_prn                             [15],
            
            bl_patient_name_loc_lang                   [101], 
            bl_patient_name                            [61],
			bl_patient_name1                           [61],
                  d_short_name_full                    [61]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[31]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } nd_epi_type;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_pat_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_pat_no;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_epi_no;

struct { unsigned short len; unsigned char arr[9]; } nd_to_epi_no;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_visit_no;

struct { unsigned short len; unsigned char arr[5]; } nd_to_visit_no;

struct { unsigned short len; unsigned char arr[2]; } nd_show_dtls;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[15]; } nd_fm_date_prn;

struct { unsigned short len; unsigned char arr[15]; } nd_to_date_prn;

struct { unsigned short len; unsigned char arr[101]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

   /* VARCHAR bl_pat_episode_type                         [2],
           bl_pat_patient_id                           [21],
           bl_pat_episode_id                           [9],
           bl_pat_visit_id                             [5],
           bl_pat_org_doc_type_code                    [7],
           bl_pat_org_doc_num                          [9],
		   bl_pat_org_doc_srno	                       [7],
           bl_pat_org_doc_date                         [13],
           bl_pat_trx_type_code                        [2],
           bl_pat_bill_trx_type_code                   [2],
           bl_pat_bill_nature_code                     [2],
           bl_pat_recpt_nature_code                    [3],
           bl_pat_recpt_type_code                      [4],
           bl_pat_narration                            [51],
           bl_pat_max_line_num                         [23],
           bl_pat_doc_amt_prn                          [23],
           bl_pat_doc_outst_amt_prn                    [23],
           bl_pat_added_by_id                          [21],
           bl_pat_added_date                           [13],
           bl_pat_modified_by_id                       [21],
           bl_pat_modified_date                        [13],
		   l_pk_value						           [100],
		   l_translated_value						   [201],
           bl_pat_episode_visit_id                     [16],
           bl_pat_recpt_nat_desc                       [31],

           recpt_type_desc                             [101]; */ 
struct { unsigned short len; unsigned char arr[2]; } bl_pat_episode_type;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_patient_id;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_visit_id;

struct { unsigned short len; unsigned char arr[7]; } bl_pat_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_org_doc_num;

struct { unsigned short len; unsigned char arr[7]; } bl_pat_org_doc_srno;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_org_doc_date;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_trx_type_code;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_bill_trx_type_code;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_bill_nature_code;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_recpt_nature_code;

struct { unsigned short len; unsigned char arr[4]; } bl_pat_recpt_type_code;

struct { unsigned short len; unsigned char arr[51]; } bl_pat_narration;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_max_line_num;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_doc_amt_prn;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_doc_outst_amt_prn;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_added_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_added_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_modified_by_id;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_modified_date;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[16]; } bl_pat_episode_visit_id;

struct { unsigned short len; unsigned char arr[31]; } bl_pat_recpt_nat_desc;

struct { unsigned short len; unsigned char arr[101]; } recpt_type_desc;


   /* VARCHAR bl_trn_doc_type_code                        [7],
           bl_trn_doc_num                              [9],
           bl_trn_doc_date                             [13],
           bl_trn_doc_amt                              [23],
           bl_trn_trx_type_code                        [2],
           bl_trn_bill_trx_type_code                   [2],
           bl_trn_recpt_nature_code                    [3],

           bl_trn_bill_trx_type_desc                   [35]; */ 
struct { unsigned short len; unsigned char arr[7]; } bl_trn_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_trn_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_trn_doc_date;

struct { unsigned short len; unsigned char arr[23]; } bl_trn_doc_amt;

struct { unsigned short len; unsigned char arr[2]; } bl_trn_trx_type_code;

struct { unsigned short len; unsigned char arr[2]; } bl_trn_bill_trx_type_code;

struct { unsigned short len; unsigned char arr[3]; } bl_trn_recpt_nature_code;

struct { unsigned short len; unsigned char arr[35]; } bl_trn_bill_trx_type_desc;


   double  bl_pat_doc_amt,
           bl_pat_doc_outst_amt,
		   bl_trn_doc_amt_db;


	char filename[150];
	char loc_legend[999][201];
	char x_msg[200];
	char l_mesg[200];

    int i;		

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

int    lctr = 0,pctr = 0;
  
FILE *fp;
 char   store_episode_visit_id                       [16],
         store_patient_id                             [21],
         store_episode_type                           [2];

  double epi_vis_amt_outst_tot,
         pat_amt_outst_tot,
         epi_amt_outst_tot,
         grand_amt_outst_tot;

void proc_main(argc,argv)
char *argv[];
int argc;
{

    int rec_ctr = 0, trn_ctr = 0, page_skip = 0;

    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRDEPCL");

    if (sql_connect(argv[1]) == -1)
    {
        disp_message(ORA_MESG,"Error in connecting to Oracle\n");
        proc_exit();
    }

    set_meduser_role();

   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;

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
fetch_legend_value();
    declare_cur();

    fetch_hosp_name();
							
    open_file();
							
    open_pat_ledger();
							
    epi_vis_amt_outst_tot = 0;
    pat_amt_outst_tot     = 0;
    epi_amt_outst_tot     = 0;
    grand_amt_outst_tot   = 0;

    while(fetch_pat_ledger())
    {

       if (rec_ctr == 0)
       {
          print_rec(0);
          strcpy(store_episode_visit_id,bl_pat_episode_visit_id.arr);
          strcpy(store_patient_id,bl_pat_patient_id.arr);
          strcpy(store_episode_type,bl_pat_episode_type.arr);
       }
       if (strcmp(store_episode_type,bl_pat_episode_type.arr))
       {
            print_epi_tot();
            strcpy(store_episode_type,bl_pat_episode_type.arr);
            strcpy(store_patient_id,bl_pat_patient_id.arr);
            strcpy(store_episode_visit_id,bl_pat_episode_visit_id.arr);
            page_skip = 1;
       }
       else if (strcmp(store_patient_id,bl_pat_patient_id.arr))
       {
            print_pat_tot(1);
            strcpy(store_patient_id,bl_pat_patient_id.arr);
            strcpy(store_episode_visit_id,bl_pat_episode_visit_id.arr);
       }
       else if (strcmp(store_episode_visit_id,bl_pat_episode_visit_id.arr))
       {
            print_epi_vis_tot(1);
            strcpy(store_episode_visit_id,bl_pat_episode_visit_id.arr);
       }

       if (page_skip == 1)
       {
	    
           print_head();
		    
           print_rec(0);
		    
           page_skip = 0;
       }
       rec_ctr++;
       print_rec(1);
	    
       if (nd_show_dtls.arr[0] == 'Y')
       {
          open_pat_ledger_trn();
          while(fetch_pat_ledger_trn())
          {
              trn_ctr++;
              print_rec(2);
          }
       }
     }
     if (rec_ctr)
        print_grand_tot();
 
    end_of_rep();

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


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

    return;
}

fetch_prog_param()
{
    nd_epi_type.arr[0]          = '\0';
    nd_fm_date.arr[0]           = '\0';
    nd_to_date.arr[0]           = '\0';
    nd_fm_pat_no.arr[0]         = '\0';
    nd_to_pat_no.arr[0]         = '\0';
    nd_fm_epi_no.arr[0]         = '\0';
    nd_to_epi_no.arr[0]         = '\0';
    nd_fm_visit_no.arr[0]       = '\0';
    nd_to_visit_no.arr[0]       = '\0';
    nd_show_dtls.arr[0]         = '\0';

    nd_fm_date_prn.arr[0]           = '\0';
    nd_to_date_prn.arr[0]           = '\0';

    nd_epi_type.len             = 0;
    nd_fm_date.len              = 0;
    nd_to_date.len              = 0;
    nd_fm_pat_no.len            = 0;
    nd_to_pat_no.len            = 0;
    nd_fm_epi_no.len            = 0;
    nd_to_epi_no.len            = 0;
    nd_fm_visit_no.len          = 0;
    nd_to_visit_no.len          = 0;
    nd_show_dtls.len            = 0;

    nd_fm_date_prn.len              = 0;
    nd_to_date_prn.len              = 0;

/*-- Y2K correction. Format introduced for 'FROM AND TO' Date prn variable
     as DD/MM/YYYY in form itself. So, no need to format again below also
	 VSK 14/11/1999 */  
  
   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,
                   PARAM6,PARAM7,PARAM8,PARAM9,PARAM10,
				   PARAM2,PARAM3
//                 TO_CHAR(TO_DATE(PARAM2,'DD-MON-YY'),'DD/MM/YYYY'),
//                 TO_CHAR(TO_DATE(PARAM3,'DD-MON-YY'),'DD/MM/YYYY')
              INTO :nd_operating_facility_id,
				   :nd_epi_type,
                   :nd_fm_date,
                   :nd_to_date,
                   :nd_fm_pat_no,
                   :nd_to_pat_no,
                   :nd_fm_epi_no,
                   :nd_to_epi_no,
                   :nd_fm_visit_no,
                   :nd_to_visit_no,
                   :nd_show_dtls,
                   :nd_fm_date_prn,
                   :nd_to_date_prn
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PAR\
AM4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM2 ,PARAM3 into :b0\
,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12  from SY_PROG_PARAM where\
 ((PGM_ID=:b13 and SESSION_ID=:b14) and PGM_DATE=:b15)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_epi_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_date;
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
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_pat_no;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_pat_no;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_epi_no;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_epi_no;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_visit_no;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_visit_no;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_show_dtls;
   sqlstm.sqhstl[10] = (unsigned int  )4;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_fm_date_prn;
   sqlstm.sqhstl[11] = (unsigned int  )17;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_to_date_prn;
   sqlstm.sqhstl[12] = (unsigned int  )17;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[13] = (unsigned int  )17;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[14] = (unsigned int  )33;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[15] = (unsigned int  )27;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
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

    nd_epi_type.arr[nd_epi_type.len]              = '\0';
    nd_fm_date.arr[nd_fm_date.len]                = '\0';
    nd_to_date.arr[nd_to_date.len]                = '\0';
    nd_fm_pat_no.arr[nd_fm_pat_no.len]            = '\0';
    nd_to_pat_no.arr[nd_to_pat_no.len]            = '\0';
    nd_fm_epi_no.arr[nd_fm_epi_no.len]            = '\0';
    nd_to_epi_no.arr[nd_to_epi_no.len]            = '\0';
    nd_fm_visit_no.arr[nd_fm_visit_no.len]        = '\0';
    nd_to_visit_no.arr[nd_to_visit_no.len]        = '\0';
    nd_show_dtls.arr[nd_show_dtls.len]            = '\0';

    nd_fm_date_prn.arr[nd_fm_date_prn.len]                = '\0';
    nd_to_date_prn.arr[nd_to_date_prn.len]                = '\0';



   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSIO\
N_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )99;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqhstl[1] = (unsigned int  )33;
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
   strcpy(g_facility_id, nd_operating_facility_id.arr);   
}

declare_cur()
{


/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY VSK 15/11/1999 */

     /* EXEC SQL DECLARE BL_PAT_LEDGER_CUR CURSOR FOR
               SELECT EPISODE_TYPE,
                      PATIENT_ID,
                      EPISODE_ID,
                      VISIT_ID,
                      ORG_DOC_TYPE_CODE,
                      ORG_DOC_NUM,
                      to_char(TRUNC(ORG_DOC_DATE),'dd/mm/yyyy'),
                      TRX_TYPE_CODE,
                      BILL_TRX_TYPE_CODE,
                      BILL_NATURE_CODE,
                      RECPT_NATURE_CODE,
                      RECPT_TYPE_CODE,
                      NARRATION,
                      MAX_LINE_NUM,
                      TO_CHAR(NVL(DOC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(DOC_OUTST_AMT,0),'999,999,990.99'),
                      ADDED_BY_ID,
                      ADDED_DATE,
                      MODIFIED_BY_ID,
                      MODIFIED_DATE,
					  ORG_DOC_SRNO,
                      EPISODE_ID||VISIT_ID,
                      NVL(DOC_AMT,0),
                      NVL(DOC_OUTST_AMT,0),
                      SUBSTR(DECODE(RECPT_NATURE_CODE,
                            'AD','ADJUSTABLE DEPOSIT',
                            'RD','REFUNDABLE DEPOSIT',
                            'PR','PREPAYMENTS',
                            'MI','MISCELLANEOUS',
                            'DC','DEFERRED CASH PATIENTS',
                            'BI','AGAINST BILLS',
                            'CU','CUSTOMERS',''),1,15)
                 FROM BL_PATIENT_LEDGER
                WHERE EPISODE_TYPE = NVL(:nd_epi_type,EPISODE_TYPE)
                  AND PATIENT_ID  
                         BETWEEN NVL(:nd_fm_pat_no,' ') AND
                                 NVL(:nd_to_pat_no,'~~~~~~~~~~')
                  AND EPISODE_ID 
                         BETWEEN NVL(:nd_fm_epi_no,0) AND
                                 NVL(:nd_to_epi_no,99999999)
                  AND NVL(VISIT_ID,0) 
                         BETWEEN NVL(:nd_fm_visit_no,0) AND
                                 NVL(:nd_to_visit_no,9999)
                  AND TRUNC(ORG_DOC_DATE)
                       BETWEEN 
                        NVL(TO_DATE(:nd_fm_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                         AND
                        NVL(TO_DATE(:nd_to_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
                  AND TRX_TYPE_CODE = '5'
                  AND RECPT_NATURE_CODE = 'RD'
                  AND NVL(DOC_OUTST_AMT,0) != 0
				  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                ORDER BY EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,
                      ORG_DOC_TYPE_CODE,ORG_DOC_NUM; */ 


     /* EXEC SQL DECLARE BL_PAT_LEDGER_TRN_CUR CURSOR FOR
               SELECT DOC_TYPE_CODE,
                      DOC_NUM,
                      TRUNC(DOC_DATE),
                      TO_CHAR(DOC_AMT,'999,999,990.99'),
					  DOC_AMT,
                      TRX_TYPE_CODE,
                      BILL_TRX_TYPE_CODE,
                      RECPT_NATURE_CODE,
                      SUBSTR(DECODE(BILL_TRX_TYPE_CODE,
                             'D','Inpatients Discharge Bill',
                             'A','Inpatients After Dischg Bill',
                             'I','Inpatients Inhouse Bill',
                             'O','Outpatients Bill',
                             'E','Outpatients Episode Level Bill',
                             'R','Referral Patients Bill',''),1,30)
                 FROM BL_PATIENT_LEDGER_TRN
                WHERE EPISODE_TYPE      = :bl_pat_episode_type
                  AND EPISODE_ID        = :bl_pat_episode_id
                  AND PATIENT_ID        = :bl_pat_patient_id 
                  AND VISIT_ID          = :bl_pat_visit_id 
                  AND ORG_DOC_TYPE_CODE = :bl_pat_org_doc_type_code
                  AND ORG_DOC_NUM       = :bl_pat_org_doc_num
				  AND OPERATING_FACILITY_ID =  :nd_operating_facility_id
                ORDER BY DOC_TYPE_CODE,DOC_NUM; */ 

 

    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              /oSELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
                     //substr(SHORT_NAME,1,30),
					 //decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
                     
					           short_name
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_pat_patient_id;o/

			
              SELECT 
				 
		decode(:p_language_id,'en', substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,30)),
				null
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_pat_patient_id; */ 




    /* EXEC SQL DECLARE BL_REC_TYPE_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM BL_RECEIPT_TYPE_lang_vw
               WHERE RECEIPT_TYPE_CODE = :bl_pat_recpt_type_code
			   and language_id=:p_language_id; */ 

}

open_pat_ledger()
{
    /* EXEC SQL OPEN BL_PAT_LEDGER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0,
      "select EPISODE_TYPE ,PATIENT_ID ,EPISODE_ID ,VISIT_ID ,ORG_DOC_TYPE_C\
ODE ,ORG_DOC_NUM ,to_char(TRUNC(ORG_DOC_DATE),'dd/mm/yyyy') ,TRX_TYPE_CODE ,\
BILL_TRX_TYPE_CODE ,BILL_NATURE_CODE ,RECPT_NATURE_CODE ,RECPT_TYPE_CODE ,NA\
RRATION ,MAX_LINE_NUM ,TO_CHAR(NVL(DOC_AMT,0),'999,999,990.99') ,TO_CHAR(NVL\
(DOC_OUTST_AMT,0),'999,999,990.99') ,ADDED_BY_ID ,ADDED_DATE ,MODIFIED_BY_ID\
 ,MODIFIED_DATE ,ORG_DOC_SRNO ,(EPISODE_ID||VISIT_ID) ,NVL(DOC_AMT,0) ,NVL(D\
OC_OUTST_AMT,0) ,SUBSTR(DECODE(RECPT_NATURE_CODE,'AD','ADJUSTABLE DEPOSIT','\
RD','REFUNDABLE DEPOSIT','PR','PREPAYMENTS','MI','MISCELLANEOUS','DC','DEFER\
RED CASH PATIENTS','BI','AGAINST BILLS','CU','CUSTOMERS',''),1,15)  from BL_\
PATIENT_LEDGER where ((((((((EPISODE_TYPE=NVL(:b0,EPISODE_TYPE) and PATIENT_\
ID between NVL(:b1,' ') and NVL(:b2,'~~~~~~~~~~')) and EPISODE_ID between NV\
L(:b3,0) and NVL(:b4,99999999)) and NVL(VISIT_ID,0) between NVL(:b5,0) and N\
VL(:b6,9999)) and TRUNC(ORG_DOC_DATE) between NVL(TO_DATE(:b7,'DD/MM/YYYY'),\
to_date('00010101','YYYYDDMM')) and NVL(TO_");
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )126;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_pat_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_pat_no;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_epi_no;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_epi_no;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_visit_no;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_visit_no;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[7] = (unsigned int  )14;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[8] = (unsigned int  )14;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[9] = (unsigned int  )5;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_PAT_LEDGER_CUR",0,"");
}

open_pat_ledger_trn()
{
    /* EXEC SQL OPEN BL_PAT_LEDGER_TRN_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )181;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_pat_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_pat_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_pat_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_pat_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_pat_org_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_pat_org_doc_num;
    sqlstm.sqhstl[5] = (unsigned int  )11;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_PAT_LEDGER_TRN_CUR",0,"");
}

fetch_pat_ledger()
{

bl_pat_episode_type.arr[0]                                        = '\0';
bl_pat_patient_id.arr[0]                                          = '\0';
bl_pat_episode_id.arr[0]                                          = '\0';
bl_pat_visit_id.arr[0]                                            = '\0';
bl_pat_org_doc_type_code.arr[0]                                   = '\0';
bl_pat_org_doc_num.arr[0]                                         = '\0';
bl_pat_org_doc_srno.arr[0]		                                  = '\0';
bl_pat_org_doc_date.arr[0]                                        = '\0';
bl_pat_trx_type_code.arr[0]                                       = '\0';
bl_pat_bill_trx_type_code.arr[0]                                  = '\0';
bl_pat_bill_nature_code.arr[0]                                    = '\0';
bl_pat_recpt_nature_code.arr[0]                                   = '\0';
bl_pat_recpt_type_code.arr[0]                                     = '\0';
bl_pat_narration.arr[0]                                           = '\0';
bl_pat_max_line_num.arr[0]                                        = '\0';
bl_pat_doc_amt_prn.arr[0]                                         = '\0';
bl_pat_doc_outst_amt_prn.arr[0]                                   = '\0';
bl_pat_added_by_id.arr[0]                                         = '\0';
bl_pat_added_date.arr[0]                                          = '\0';
bl_pat_modified_by_id.arr[0]                                      = '\0';
bl_pat_modified_date.arr[0]                                       = '\0';
bl_pat_recpt_nat_desc.arr[0]                                      = '\0';
bl_pat_episode_visit_id.arr[0]                                    = '\0'; 


bl_pat_episode_type.len                                           = 0;
bl_pat_patient_id.len                                             = 0;
bl_pat_episode_id.len                                             = 0;
bl_pat_visit_id.len                                               = 0;
bl_pat_org_doc_type_code.len                                      = 0;
bl_pat_org_doc_num.len                                            = 0;
bl_pat_org_doc_srno.len		                                      = 0;
bl_pat_org_doc_date.len                                           = 0;
bl_pat_trx_type_code.len                                          = 0;
bl_pat_bill_trx_type_code.len                                     = 0;
bl_pat_bill_nature_code.len                                       = 0;
bl_pat_recpt_nature_code.len                                      = 0;
bl_pat_recpt_type_code.len                                        = 0;
bl_pat_narration.len                                              = 0;
bl_pat_max_line_num.len                                           = 0;
bl_pat_doc_amt_prn.len                                            = 0;
bl_pat_doc_outst_amt_prn.len                                      = 0;
bl_pat_added_by_id.len                                            = 0;
bl_pat_added_date.len                                             = 0;
bl_pat_modified_by_id.len                                         = 0;
bl_pat_modified_date.len                                          = 0;
bl_pat_recpt_nat_desc.len                                         = 0;
bl_pat_episode_visit_id.len                                       = 0;

bl_pat_doc_amt                                                    = 0;
bl_pat_doc_outst_amt                                              = 0;
bl_trn_doc_amt_db												  = 0;

     /* EXEC SQL FETCH BL_PAT_LEDGER_CUR
               INTO :bl_pat_episode_type,
                    :bl_pat_patient_id,
                    :bl_pat_episode_id,
                    :bl_pat_visit_id,
                    :bl_pat_org_doc_type_code,
                    :bl_pat_org_doc_num,
                    :bl_pat_org_doc_date,
                    :bl_pat_trx_type_code,
                    :bl_pat_bill_trx_type_code,
                    :bl_pat_bill_nature_code,
                    :bl_pat_recpt_nature_code,
                    :bl_pat_recpt_type_code,
                    :bl_pat_narration,
                    :bl_pat_max_line_num,
                    :bl_pat_doc_amt_prn,
                    :bl_pat_doc_outst_amt_prn,
                    :bl_pat_added_by_id,
                    :bl_pat_added_date,
                    :bl_pat_modified_by_id,
                    :bl_pat_modified_date,
					:bl_pat_org_doc_srno,
                    :bl_pat_episode_visit_id,
                    :bl_pat_doc_amt,
                    :bl_pat_doc_outst_amt,
                    :bl_pat_recpt_nat_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )224;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_episode_type;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_patient_id;
     sqlstm.sqhstl[1] = (unsigned int  )23;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_episode_id;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_pat_visit_id;
     sqlstm.sqhstl[3] = (unsigned int  )7;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_org_doc_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_pat_org_doc_num;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_pat_org_doc_date;
     sqlstm.sqhstl[6] = (unsigned int  )15;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_pat_trx_type_code;
     sqlstm.sqhstl[7] = (unsigned int  )4;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_pat_bill_trx_type_code;
     sqlstm.sqhstl[8] = (unsigned int  )4;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_pat_bill_nature_code;
     sqlstm.sqhstl[9] = (unsigned int  )4;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_pat_recpt_nature_code;
     sqlstm.sqhstl[10] = (unsigned int  )5;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_pat_recpt_type_code;
     sqlstm.sqhstl[11] = (unsigned int  )6;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_pat_narration;
     sqlstm.sqhstl[12] = (unsigned int  )53;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_pat_max_line_num;
     sqlstm.sqhstl[13] = (unsigned int  )25;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_pat_doc_amt_prn;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_pat_doc_outst_amt_prn;
     sqlstm.sqhstl[15] = (unsigned int  )25;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_pat_added_by_id;
     sqlstm.sqhstl[16] = (unsigned int  )23;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_pat_added_date;
     sqlstm.sqhstl[17] = (unsigned int  )15;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_pat_modified_by_id;
     sqlstm.sqhstl[18] = (unsigned int  )23;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_pat_modified_date;
     sqlstm.sqhstl[19] = (unsigned int  )15;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_pat_org_doc_srno;
     sqlstm.sqhstl[20] = (unsigned int  )9;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_pat_episode_visit_id;
     sqlstm.sqhstl[21] = (unsigned int  )18;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_pat_doc_amt;
     sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_pat_doc_outst_amt;
     sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_pat_recpt_nat_desc;
     sqlstm.sqhstl[24] = (unsigned int  )33;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
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
         err_mesg("FETCH failed on cursor BL_PAT_LEDGER_CUR",0,"");

bl_pat_episode_type.arr[bl_pat_episode_type.len]                         = '\0';
bl_pat_patient_id.arr[bl_pat_patient_id.len]                             = '\0';
bl_pat_episode_id.arr[bl_pat_episode_id.len]                             = '\0';
bl_pat_visit_id.arr[bl_pat_visit_id.len]                                 = '\0';
bl_pat_org_doc_type_code.arr[bl_pat_org_doc_type_code.len]               = '\0';
bl_pat_org_doc_num.arr[bl_pat_org_doc_num.len]                           = '\0';
bl_pat_org_doc_date.arr[bl_pat_org_doc_date.len]                         = '\0';
bl_pat_trx_type_code.arr[bl_pat_trx_type_code.len]                       = '\0';
bl_pat_bill_trx_type_code.arr[bl_pat_bill_trx_type_code.len]             = '\0';
bl_pat_bill_nature_code.arr[bl_pat_bill_nature_code.len]                 = '\0';
bl_pat_recpt_nature_code.arr[bl_pat_recpt_nature_code.len]               = '\0';
bl_pat_recpt_type_code.arr[bl_pat_recpt_type_code.len]                   = '\0';
bl_pat_narration.arr[bl_pat_narration.len]                               = '\0';
bl_pat_max_line_num.arr[bl_pat_max_line_num.len]                         = '\0';
bl_pat_doc_amt_prn.arr[bl_pat_doc_amt_prn.len]                           = '\0';
bl_pat_doc_outst_amt_prn.arr[bl_pat_doc_outst_amt_prn.len]               = '\0';
bl_pat_added_by_id.arr[bl_pat_added_by_id.len]                           = '\0';
bl_pat_added_date.arr[bl_pat_added_date.len]                             = '\0';
bl_pat_modified_by_id.arr[bl_pat_modified_by_id.len]                     = '\0';
bl_pat_modified_date.arr[bl_pat_modified_date.len]                       = '\0';
bl_pat_org_doc_srno.arr[bl_pat_org_doc_srno.len]			             = '\0';
bl_pat_recpt_nat_desc.arr[bl_pat_recpt_nat_desc.len]                     = '\0';
bl_pat_episode_visit_id.arr[bl_pat_episode_visit_id.len]                 = '\0';

    return(LAST_ROW?0:1);
}

fetch_pat_ledger_trn()
{

bl_trn_doc_type_code.arr[0]                                       = '\0';
bl_trn_doc_num.arr[0]                                             = '\0';
bl_trn_doc_date.arr[0]                                            = '\0';
bl_trn_doc_amt.arr[0]                                             = '\0';
bl_trn_trx_type_code.arr[0]                                       = '\0';
bl_trn_bill_trx_type_code.arr[0]                                  = '\0';
bl_trn_recpt_nature_code.arr[0]                                   = '\0';

bl_trn_bill_trx_type_desc.arr[0]                                  = '\0';

bl_trn_doc_type_code.len                                          = 0;
bl_trn_doc_num.len                                                = 0;
bl_trn_doc_date.len                                               = 0;
bl_trn_doc_amt.len                                                = 0;
bl_trn_trx_type_code.len                                          = 0;
bl_trn_bill_trx_type_code.len                                     = 0;
bl_trn_recpt_nature_code.len                                      = 0;

bl_trn_bill_trx_type_desc.len                                     = 0;

     /* EXEC SQL FETCH BL_PAT_LEDGER_TRN_CUR
               INTO :bl_trn_doc_type_code,
                    :bl_trn_doc_num,
                    :bl_trn_doc_date,
                    :bl_trn_doc_amt,
					:bl_trn_doc_amt_db,
                    :bl_trn_trx_type_code,
                    :bl_trn_bill_trx_type_code,
                    :bl_trn_recpt_nature_code,
                    :bl_trn_bill_trx_type_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 25;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )339;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_trn_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_trn_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_trn_doc_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_trn_doc_amt;
     sqlstm.sqhstl[3] = (unsigned int  )25;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_trn_doc_amt_db;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_trn_trx_type_code;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_trn_bill_trx_type_code;
     sqlstm.sqhstl[6] = (unsigned int  )4;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_trn_recpt_nature_code;
     sqlstm.sqhstl[7] = (unsigned int  )5;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_trn_bill_trx_type_desc;
     sqlstm.sqhstl[8] = (unsigned int  )37;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
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
         err_mesg("FETCH failed on cursor BL_PAT_LEDGER_TRN_CUR",0,"");

bl_trn_doc_type_code.arr[bl_trn_doc_type_code.len]                       = '\0';
bl_trn_doc_num.arr[bl_trn_doc_num.len]                                   = '\0';
bl_trn_doc_date.arr[bl_trn_doc_date.len]                                 = '\0';
bl_trn_doc_amt.arr[bl_trn_doc_amt.len]                                   = '\0';
bl_trn_trx_type_code.arr[bl_trn_trx_type_code.len]                       = '\0';
bl_trn_bill_trx_type_code.arr[bl_trn_bill_trx_type_code.len]             = '\0';
bl_trn_recpt_nature_code.arr[bl_trn_recpt_nature_code.len]               = '\0';

bl_trn_bill_trx_type_desc.arr[bl_trn_bill_trx_type_desc.len]             = '\0';

    return(LAST_ROW?0:1);
}

fetch_dtls()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )390;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&p_language_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bl_pat_patient_id;
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
                  /o :bl_patient_name,
				   :bl_patient_name1,o/
                           :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )413;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_patient_name_loc_lang;
    sqlstm.sqhstl[0] = (unsigned int  )103;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_short_name_full;
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
         err_mesg("FETCH failed on cursor BL_PAT_NAME_CUR",0,"");

    bl_patient_name_loc_lang.arr[bl_patient_name_loc_lang.len] = '\0';
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60\
 ) ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 \
, str2 ) ; IF str2 IS NOT NULL THEN :bl_patient_name := str2 ; END IF ; blcom\
mon . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF st\
r2 IS NOT NULL THEN :bl_patient_name1 := str2 ; END IF ; blcommon . split_wor\
ds ( :d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL \
THEN :bl_patient_name1 := :bl_patient_name1 || str2 ; end if ; END ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )436;
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
 


    /* EXEC SQL OPEN BL_REC_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )463;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_pat_recpt_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )6;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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
         err_mesg("OPEN failed on cursor BL_REC_TYPE_CUR",0,"");

    recpt_type_desc.arr[0]  = '\0';
    recpt_type_desc.len     = 0;

    /* EXEC SQL FETCH BL_REC_TYPE_CUR
              INTO :recpt_type_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )486;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&recpt_type_desc;
    sqlstm.sqhstl[0] = (unsigned int  )103;
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
         err_mesg("FETCH failed on cursor BL_REC_TYPE_CUR",0,"");

    recpt_type_desc.arr[recpt_type_desc.len] = '\0';
}


print_rec(ind)
int ind;
{

  if (ind == 0)
  {
      fetch_dtls();

	  if (lctr > 37)  //53
          print_head();

	  
      fprintf(fp,"%-16s     %1s ",loc_legend[220],bl_pat_episode_type.arr);
      switch (bl_pat_episode_type.arr[0])
      {
         case 'I' : fprintf(fp,"%-7s",loc_legend[360]);
                    break;

         case 'D' : fprintf(fp,"%-7s",loc_legend[350]);
	            break;

         case 'O' : fprintf(fp,"%-7s",loc_legend[340]);
                    break;

         case 'E' : fprintf(fp,"%-7s",loc_legend[330]);
                    break;
 
         case 'R' : fprintf(fp,"%-7s",loc_legend[320]);
                    break;

         default  : fprintf(fp,"  ");
                    break;
      }
      fprintf(fp,"\n");

      fprintf(fp,"%-14s       %-20s %-16.16s %-30.30s",loc_legend[90],
                bl_pat_patient_id.arr,
                bl_patient_name_loc_lang.arr,
                bl_patient_name.arr);
	  
      fprintf(fp,"    %-14s  %8s    %-12s  %4s\n",loc_legend[100],
                bl_pat_episode_id.arr,loc_legend[110], bl_pat_visit_id.arr);

	 if(strlen(bl_patient_name1.arr) > 2)
	{
	 fprintf(fp,"%54s %s \n"," ",bl_patient_name1.arr);
	 lctr++;
	}

     lctr+=2;
   }
   else if (ind == 1)
   {
      if (lctr > 37) //53
          print_head();
		  	if(bl_pat_org_doc_date.arr[0]!='\0')
			{
    init_date_temp_var();
	strcpy(date_convert.arr,bl_pat_org_doc_date.arr);
	fun_change_loc_date();

     fprintf(fp,"    %-6s %8s/%-19s%12s%7s      %-2s %-15s %-2s %-32.32s ",
                bl_pat_org_doc_type_code.arr,
                bl_pat_org_doc_num.arr,bl_pat_org_doc_srno.arr,
                date_convert.arr,
                bl_pat_trx_type_code.arr,
                bl_pat_recpt_nature_code.arr,
                bl_pat_recpt_nat_desc.arr,
                bl_pat_recpt_type_code.arr,
                recpt_type_desc.arr);
//                bl_pat_doc_amt_prn.arr);
//                bl_pat_doc_outst_amt_prn.arr);
			    print_formated(bl_pat_doc_amt);
				fprintf(fp," ");
			    print_formated(bl_pat_doc_outst_amt);fprintf(fp,"\n");
     lctr++;
     epi_vis_amt_outst_tot += bl_pat_doc_outst_amt;
	} 
   }
   else
   {
      if (lctr > 37) //53
          print_head();
		if(bl_trn_doc_date.arr[0]!='\0')
			{
    init_date_temp_var();
	strcpy(date_convert.arr,bl_trn_doc_date.arr);
	fun_change_loc_date();  
				 "    %-6s %8s/%-19s%12s%7s      %-2s %-15s %-2s %-30s ",
      fprintf(fp,"            %-6s %9s %-10s  %1s    %-3s %-15s    %-3s %-30s ",
               bl_trn_doc_type_code.arr,
               bl_trn_doc_num.arr,
               date_convert.arr,
               bl_trn_trx_type_code.arr,
               bl_trn_recpt_nature_code.arr,
               (bl_trn_recpt_nature_code.arr[0] == 'C')?"Cash Memo":
               (bl_trn_recpt_nature_code.arr[0] == 'A')?"Ack. Slip":"",
               bl_trn_bill_trx_type_code.arr,
               bl_trn_bill_trx_type_desc.arr);
//               bl_trn_doc_amt.arr);
			    print_formated(bl_trn_doc_amt_db);fprintf(fp,"\n");
}
     lctr++;
 	  
  }
  fflush(fp);
}
 
print_epi_vis_tot(l_flg)
int l_flg;
{
    if (lctr > 38) //52
       print_head();

	   
    fprintf(fp,"%117s-----------------\n"," ");
    fprintf(fp,"%81s%-23s               "," ",loc_legend[230]);
    print_formated(epi_vis_amt_outst_tot);fprintf(fp,"\n");
    fprintf(fp,"%117s-----------------\n"," ");
    lctr +=3;
    pat_amt_outst_tot += epi_vis_amt_outst_tot;
    epi_vis_amt_outst_tot = 0;
    if (l_flg)
       print_rec(0);
}

print_pat_tot(l_flg)
int l_flg;
{
    print_epi_vis_tot(0);

    if (lctr > 38) //52
       print_head();

    fprintf(fp,"%117s-----------------\n"," ");
    fprintf(fp,"%81s%-17s                     "," ",loc_legend[210]);
    print_formated(pat_amt_outst_tot);fprintf(fp,"\n");
    fprintf(fp,"%117s-----------------\n"," ");
    lctr +=3;
    epi_amt_outst_tot += pat_amt_outst_tot;
    pat_amt_outst_tot = 0;
    if (l_flg)
       print_rec(0);
}

print_epi_tot()
{
    print_pat_tot(0);

    if (lctr > 38) //52
       print_head();


    fprintf(fp,"%117s-----------------\n"," ");
    fprintf(fp,"%81s%-22s                "," ",loc_legend[200]);
    print_formated(epi_amt_outst_tot);fprintf(fp,"\n");
    fprintf(fp,"%117s-----------------\n"," ");
    lctr +=3;
    grand_amt_outst_tot += epi_amt_outst_tot;
    epi_amt_outst_tot = 0;
}

print_grand_tot()
{
    print_epi_tot();
    if (lctr > 38) //52
       print_head();


    fprintf(fp,"%117s-----------------\n"," ");
    fprintf(fp,"%81s%-15s                       "," ",loc_legend[190]);
    print_formated(grand_amt_outst_tot);fprintf(fp,"\n");
    fprintf(fp,"%117s-----------------\n"," ");
    lctr +=3;
}

end_of_rep()
{
fprintf(fp,"\n\n                                                      ***  END OF REPORT ***\n");
fflush(fp);
}

open_file()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"blrdepcl.lis");
	
    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrdepcl.lis");
       proc_exit();
    }
    print_title();
    print_head();
}

print_title()
{
init_date_temp_var();

strcpy(date_convert.arr,date_time.arr);
	
fun_change_loc_date();

    fprintf(fp,"%c&l1O",ESC);   /* To Print Landscape           */
     fprintf(fp,"%c(s14H",ESC); 	/* To set the font size			*/

/*fprintf(fp,
"\f%6s : %-5s                                     %-30s                                        %-16s\n",loc_legend[400],loc_legend[150],
hosp_name.arr,date_convert.arr);*/

fprintf(fp,
"%6s : %-5s                                     %-30s                                        %-16s\n",loc_legend[400],loc_legend[150],
hosp_name.arr,date_convert.arr);
 
fprintf(fp,"%6s : %-10s \n",loc_legend[410], user_id.arr);
fprintf(fp,"%6s : %-12s                       %-70s %10s : %4d\n",loc_legend[420],loc_legend[40],loc_legend[390],loc_legend[30],++pctr);
fprintf(fp,
"--------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        %-20s :\n        ---------------------\n\n",loc_legend[430]);
fprintf(fp,"                  %-17s                      : %s\n\n",loc_legend[220],nd_epi_type.arr);
	if(nd_fm_date_prn.arr[0]=='\0')
fprintf(fp,"                  %-17s           %-10s : LOWEST\n",loc_legend[80],loc_legend[60]);
else
{
init_date_temp_var();
strcpy(date_convert.arr,nd_fm_date_prn.arr);
fun_change_loc_date();
fprintf(fp,"                  %-17s           %-10s : %s\n",loc_legend[80],loc_legend[60],date_convert.arr);
}
if(nd_to_date_prn.arr[0]=='\0')
fprintf(fp,"                                              %-10s : HIGHEST\n\n",loc_legend[70]);
else
{
init_date_temp_var();
strcpy(date_convert.arr,nd_to_date_prn.arr);
fun_change_loc_date();
fprintf(fp,"                                              %-10s : %s\n\n",loc_legend[70],date_convert.arr);
}
if(nd_fm_pat_no.arr[0]=='\0')
fprintf(fp,"                  %-17s           %-10s : LOWEST\n",loc_legend[90],loc_legend[60]);
else
fprintf(fp,"                  %-17s           %-10s : %s\n",loc_legend[90],loc_legend[60],nd_fm_pat_no.arr);
if(nd_to_pat_no.arr[0]=='\0')
fprintf(fp,"                                              %-10s : HIGHEST\n\n",loc_legend[70]);
else
fprintf(fp,"                                              %-10s : %s\n\n",loc_legend[70],nd_to_pat_no.arr);
if(nd_fm_epi_no.arr[0]=='\0')
fprintf(fp,"                  %-17s           %-10s : LOWEST\n",loc_legend[100],loc_legend[60]);
else
fprintf(fp,"                  %-17s           %-10s : %s\n",loc_legend[100],loc_legend[60],nd_fm_epi_no.arr);
if(nd_to_epi_no.arr[0]=='\0')
fprintf(fp,"                                              %-10s : HIGHEST\n\n",loc_legend[70]);
else
fprintf(fp,"                                              %-10s : %s\n\n",loc_legend[70],nd_to_epi_no.arr);
if(nd_fm_visit_no.arr[0]=='\0')
fprintf(fp,"                  %-17s           %-10s : LOWEST\n",loc_legend[110],loc_legend[60]);
else
fprintf(fp,"                  %-17s           %-10s : %s\n",loc_legend[110],loc_legend[60],nd_fm_visit_no.arr);
if(nd_to_visit_no.arr[0]=='\0')
fprintf(fp,"                                              %-10s : %HIGHEST\n\n",loc_legend[70]);
else
fprintf(fp,"                                              %-10s : %s\n\n",loc_legend[70],nd_to_visit_no.arr);
fprintf(fp,"                  %-24s               : %s\n\n",loc_legend[120],nd_show_dtls.arr);
}
/*fprintf(fp,"                  EPISODE TYPE         : %s\n\n",nd_epi_type.arr);
fprintf(fp,"                  DATE            FROM : %s\n",nd_fm_date_prn.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_to_date_prn.arr);
fprintf(fp,"                  PATIENT NO      FROM : %s\n",nd_fm_pat_no.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_to_pat_no.arr);
fprintf(fp,"                  EPISODE NO      FROM : %s\n",nd_fm_epi_no.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_to_epi_no.arr);
fprintf(fp,"                  VISIT NO        FROM : %s\n",nd_fm_visit_no.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_to_visit_no.arr);
fprintf(fp,"                  SHOW ALLOCATION DTLS : %s\n\n",nd_show_dtls.arr);*/


print_head()
{
init_date_temp_var();

strcpy(date_convert.arr,date_time.arr);
	
fun_change_loc_date();

/*fprintf(fp,
"\f%6s : %-5s                                         %-30s                                        %-16s\n",loc_legend[400],loc_legend[150],
hosp_name.arr,date_convert.arr);
*/

fprintf(fp,
"\f%6s : %-5s                                     %-42.42s                                        %-12s\n",loc_legend[400],loc_legend[150],
hosp_name.arr,date_convert.arr); 

 
fprintf(fp,"%6s : %-10s \n",loc_legend[410], user_id.arr);
fprintf(fp,
"%6s : %-12s        %70s %36s : %4d\n",loc_legend[420],loc_legend[40],loc_legend[390],loc_legend[30],++pctr);
fprintf(fp,
"------------------------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,
"    %-19s/%-15s  %-12s  %-7s  %-14s     %-30s  %19s %15s\n",loc_legend[140],loc_legend[450],loc_legend[160],loc_legend[170],loc_legend[180],loc_legend[250],loc_legend[260],loc_legend[270]);
fprintf(fp,
"            %-15s             %-8s %-15s    %-17s                                                  %15s\n",loc_legend[280],loc_legend[290],loc_legend[300],loc_legend[310],loc_legend[260]);
fprintf(fp,
"------------------------------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 11;
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

/*-- Y2K correction. Format introduced for year as YYYY instead of YY 
     VSK 14/11/1999 */


    /* EXEC SQL SELECT ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, 
			        :date_time,
			        :user_id
               FROM SY_ACC_ENTITY_lang_vw
			   WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			   and language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24\
:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID\
=:b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )505;
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
    sqlstm.sqhstv[4] = (         void  *)&p_language_id;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}

print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15.2f",loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRDEPCL.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRDEPCL.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )540;
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
			blcommon.get_local_lang_desc(:nd_facility_id,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:p_language_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , '\
SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_va\
lue , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )563;
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
  sqlstm.sqhstv[3] = (         void  *)&p_language_id;
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
	  
    //   	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	//   :nd_loc_date := to_char(t_date,'DD/MM/YYYY');

		   :nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id);  

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date\
_2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_id ) \
; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )594;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


        

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

}

                     
init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
date_convert.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
}


fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

fun_centre(v_text,v_size)
{
int l_length,i;

l_length=strlen(v_text);

for (i=0;i<(v_size-l_length)/2;i++)
{

	fprintf(fp," ");
}
 
}			
