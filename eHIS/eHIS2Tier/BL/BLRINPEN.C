
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
    "C:\\gana\\MLVER2\\PROC\\Raised\\Blrinpen.pc"
};


static unsigned long sqlctx = 806863781;


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
            void  *sqhstv[9];
   unsigned int   sqhstl[9];
            int   sqhsts[9];
            void  *sqindv[9];
            int   sqinds[9];
   unsigned int   sqharm[9];
   unsigned int   *sqharc[9];
   unsigned short  sqadto[9];
   unsigned short  sqtdso[9];
} sqlstm = {10,9};

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

 static const char *sq0005 = 
"select OPEN_EPISODE_ID ,PATIENT_ID  from IP_OPEN_EPISODE where (OPEN_EPISODE\
_ID between NVL(:b0,0) and NVL(:b1,99999999) and FACILITY_ID=:b2) order by OPE\
N_EPISODE_ID            ";

 static const char *sq0006 = 
"select TO_CHAR(ADMISSION_DATE_TIME,'DD/MM/YYYY')  from IP_EPISODE where (EPI\
SODE_ID=:b0 and FACILITY_ID=:b1)           ";

 static const char *sq0007 = 
"select DOC_TYPE_CODE ,DOC_NUMBER ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,TO_CHAR(DO\
C_OUTST_AMT,'999,999,990.99') ,DOC_OUTST_AMT ,TO_CHAR(DOC_AMT,'999,999,990.99'\
) ,DOC_AMT ,NVL((SYSDATE-DOC_DATE),0) ,ROWID  from BL_INHOUSE_BILL where ((((E\
PISODE_TYPE in ('I','D') and OPERATING_FACILITY_ID=:b0) and EPISODE_ID=:b1) an\
d PATIENT_ID=:b2) and BILL_TRX_TYPE_CODE='I') order by DOC_DATE,DOC_TYPE_CODE,\
DOC_NUMBER            ";

 static const char *sq0009 = 
"select NVL(TOT_BILLS_PAID_AMT,0)  from BL_EPISODE_FIN_DTLS where ((EPISODE_T\
YPE in ('I','D') and EPISODE_ID=:b0) and OPERATING_FACILITY_ID=:b1)           ";

 static const char *sq0008 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,SUBSTR(SHORT_NAME,1,30) ,decode(sub\
str(short_name,31,60),null ,' ',substr(short_name,31,60)) shortname2  from MP_\
PATIENT_MAST where PATIENT_ID=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,116,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,191,0,0,0,0,0,1,0,
51,0,0,3,157,0,4,209,0,0,7,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
94,0,0,4,84,0,2,231,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
121,0,0,5,178,0,9,298,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
148,0,0,6,119,0,9,305,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
171,0,0,7,410,0,9,312,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
198,0,0,5,0,0,13,325,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
221,0,0,6,0,0,13,345,0,0,1,0,0,1,0,2,9,0,0,
240,0,0,7,0,0,13,376,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,
0,0,2,4,0,0,2,3,0,0,2,9,0,0,
291,0,0,9,154,0,9,404,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
314,0,0,9,0,0,13,408,0,0,1,0,0,1,0,2,4,0,0,
333,0,0,10,88,0,4,419,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
356,0,0,11,61,0,5,433,0,0,2,2,0,1,0,1,4,0,0,1,9,0,0,
379,0,0,8,198,0,9,443,0,0,1,1,0,1,0,1,9,0,0,
398,0,0,8,0,0,13,456,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
425,0,0,12,128,0,4,626,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRINPEN.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 15-AUG-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                        */
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
/*
#define DEBUG 0
*/

/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRINPEN.C-arc   1.0   Apr 19 2007 17:06:24   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRINPEN.C-arc   1.0   Apr 19 2007 17:06:24   vcm_th  $ sqlda.h 
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

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [91],
			nd_pwd                                     [91],
            row_id                                     [25],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],
            nd_from_adm_no                             [9],
            nd_to_adm_no                               [9],
			nd_operating_facility_id				   [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[25]; } row_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[9]; } nd_from_adm_no;

struct { unsigned short len; unsigned char arr[9]; } nd_to_adm_no;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;


    int     nd_no_of_days,
            bl_no_of_days;

   /* VARCHAR bl_ip_open_patient_id                       [21],
           bl_ip_open_episode_id                       [9],

           bl_ip_admission_date_time                   [15],

           bl_patient_name_loc_lang                    [61],
           bl_patient_name                             [61],
		   bl_patient_name1                            [61]; */ 
struct { unsigned short len; unsigned char arr[21]; } bl_ip_open_patient_id;

struct { unsigned short len; unsigned char arr[9]; } bl_ip_open_episode_id;

struct { unsigned short len; unsigned char arr[15]; } bl_ip_admission_date_time;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name1;


   /* VARCHAR bl_pat_org_doc_type_code                    [7],
           bl_pat_org_doc_num                          [9],
           bl_pat_org_doc_date                         [13],
           bl_pat_doc_outst_amt_prn                    [23],
           bl_pat_doc_amt_prn                          [23]; */ 
struct { unsigned short len; unsigned char arr[7]; } bl_pat_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_org_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_org_doc_date;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_doc_outst_amt_prn;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_doc_amt_prn;


  double   bl_pat_doc_outst_amt,
           bl_tot_bill_paid_amt,
           bl_bill_paid_rem_amt,
           bl_pat_doc_amt,
           bl_doc_outst_amt,
           bl_pat_outst_amt,
           bl_pat_outst_doc_amt;

/* EXEC SQL END DECLARE SECTION; */ 


  double adm_amt_tot,
         adm_amt_outst_tot,
         grand_amt_tot,
         grand_amt_outst_tot;

  int    tot_admissions = 0;

  int    lctr = 0,pctr = 0;

char filename[150];

FILE *fp;  

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;

    if (argc < 4)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRINPEN");
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
     
    open_ip_open_episode();

    while(fetch_ip_open_episode())
    {
       fetch_ip_episode();
       fetch_financial_dtl();
       bl_bill_paid_rem_amt = bl_tot_bill_paid_amt;
       open_pat_ledger();

       adm_amt_tot   = 0;
       adm_amt_outst_tot   = 0;
       rec_ctr = 0;

       while(fetch_pat_ledger())
       {
           bl_pat_outst_amt = bl_pat_doc_amt;
           bl_doc_outst_amt = bl_pat_outst_amt;
           if (bl_bill_paid_rem_amt > 0) 
           {
             if (bl_pat_outst_amt < bl_bill_paid_rem_amt) 
             {
               bl_doc_outst_amt = 0;
               bl_bill_paid_rem_amt -= bl_pat_outst_amt;
              }
             else
             {
               bl_doc_outst_amt = bl_pat_outst_amt-bl_bill_paid_rem_amt;
               bl_bill_paid_rem_amt -= bl_pat_outst_amt;
             }
           }
           update_inhouse_bill_outst();
           if (bl_doc_outst_amt != 0 &&  bl_no_of_days > nd_no_of_days)
           { 
               if (!rec_ctr) print_rec(0);
               rec_ctr++;
               print_rec(1);
           }
       }
       if (rec_ctr)
           print_adm_tot();
    }

    print_grand_tot();

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
   nd_from_adm_no.arr[0]   = '\0';
   nd_to_adm_no.arr[0]     = '\0';

   nd_from_adm_no.len      = 0;
   nd_to_adm_no.len        = 0;

   nd_no_of_days           = 0;


   /* EXEC SQL SELECT  OPERATING_FACILITY_ID,
					PARAM1,PARAM2,nvl(PARAM3,0)
              INTO :nd_operating_facility_id, 
			       :nd_from_adm_no,
                   :nd_to_adm_no,
                   :nd_no_of_days
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,nvl(PARAM3,0\
) into :b0,:b1,:b2,:b3  from SY_PROG_PARAM where ((PGM_ID=:b4 and SESSION_ID=:\
b5) and PGM_DATE=:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_from_adm_no;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_adm_no;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_no_of_days;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[4] = (unsigned int  )17;
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

   nd_from_adm_no.arr[nd_from_adm_no.len] = '\0';
   nd_to_adm_no.arr[nd_to_adm_no.len]     = '\0';

   strcpy(g_facility_id,nd_operating_facility_id.arr);

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )94;
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

     /* EXEC SQL DECLARE IP_OPEN_EPISODE_CUR CURSOR FOR
               SELECT OPEN_EPISODE_ID,
                      PATIENT_ID
                 FROM IP_OPEN_EPISODE
                WHERE OPEN_EPISODE_ID BETWEEN
                      NVL(:nd_from_adm_no,0) AND NVL(:nd_to_adm_no,99999999)
				AND   FACILITY_ID    = :nd_operating_facility_id
                ORDER BY OPEN_EPISODE_ID; */ 


     /* EXEC SQL DECLARE IP_EPISODE_CUR CURSOR FOR
               SELECT TO_CHAR(ADMISSION_DATE_TIME,'DD/MM/YYYY')
                 FROM IP_EPISODE
                WHERE EPISODE_ID = :bl_ip_open_episode_id
				AND   FACILITY_ID = :nd_operating_facility_id; */ 


     /* EXEC SQL DECLARE BL_PAT_LEDGER_CUR CURSOR FOR
               SELECT DOC_TYPE_CODE,
                      DOC_NUMBER,
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                      TO_CHAR(DOC_OUTST_AMT,'999,999,990.99'),
                      DOC_OUTST_AMT,
                      TO_CHAR(DOC_AMT,'999,999,990.99'), 
                      DOC_AMT,
                      NVL((SYSDATE - DOC_DATE),0),
                      ROWID
                 FROM BL_INHOUSE_BILL   
                WHERE EPISODE_TYPE in ('I','D') 
				  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                  AND EPISODE_ID = :bl_ip_open_episode_id
                  AND PATIENT_ID = :bl_ip_open_patient_id
         /o       AND TRX_TYPE_CODE = '1'
                  AND NVL(DOC_OUTST_AMT,0) != 0;  o/
                  AND BILL_TRX_TYPE_CODE = 'I'
         /o       AND SYSDATE - ORG_DOC_DATE > NVL(:nd_no_of_days,0)  o/
                  ORDER BY DOC_DATE, DOC_TYPE_CODE, DOC_NUMBER; */ 


    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
                     SUBSTR(SHORT_NAME,1,30),
					 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname2
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_ip_open_patient_id; */ 


    /* EXEC SQL DECLARE BL_EPISODE_FIN_CUR CURSOR FOR
              SELECT NVL(TOT_BILLS_PAID_AMT,0)
                FROM BL_EPISODE_FIN_DTLS
               WHERE EPISODE_TYPE in ('I','D') 
                 AND EPISODE_ID   = :bl_ip_open_episode_id
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 


}

open_ip_open_episode()
{
    /* EXEC SQL OPEN IP_OPEN_EPISODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )121;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_adm_no;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_adm_no;
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
         err_mesg("OPEN failed on cursor IP_OPEN_EPISODE_CUR",0,"");
}

open_ip_episode()
{
    /* EXEC SQL OPEN IP_EPISODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )148;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_ip_open_episode_id;
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
         err_mesg("OPEN failed on cursor IP_EPISODE_CUR",0,"");
}

open_pat_ledger()
{
    /* EXEC SQL OPEN BL_PAT_LEDGER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )171;
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
    sqlstm.sqhstv[1] = (         void  *)&bl_ip_open_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_ip_open_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
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
         err_mesg("OPEN failed on cursor BL_PAT_LEDGER_CUR",0,"");
}

fetch_ip_open_episode()
{
   bl_ip_open_episode_id.arr[0]  = '\0';
   bl_ip_open_patient_id.arr[0]  = '\0';

   bl_ip_open_episode_id.len     = 0;
   bl_ip_open_patient_id.len     = 0;

    /* EXEC SQL FETCH IP_OPEN_EPISODE_CUR
              INTO :bl_ip_open_episode_id,
                   :bl_ip_open_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )198;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_ip_open_episode_id;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_ip_open_patient_id;
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
         err_mesg("FETCH failed on cursor IP_OPEN_EPISODE_CUR",0,"");

    bl_ip_open_episode_id.arr[bl_ip_open_episode_id.len] = '\0';
    bl_ip_open_patient_id.arr[bl_ip_open_patient_id.len] = '\0';

    return(LAST_ROW?0:1);
}

fetch_ip_episode()
{
     open_ip_episode();

bl_ip_admission_date_time.arr[0]                                  = '\0';
bl_ip_admission_date_time.len                                     = 0;

     /* EXEC SQL FETCH IP_EPISODE_CUR
               INTO :bl_ip_admission_date_time; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )221;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_ip_admission_date_time;
     sqlstm.sqhstl[0] = (unsigned int  )17;
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
         err_mesg("FETCH failed on cursor IP_EPISODE_CUR",0,"");

bl_ip_admission_date_time.arr[bl_ip_admission_date_time.len]             = '\0';

return(ROW_COUNT);
}

fetch_pat_ledger()
{

bl_pat_org_doc_type_code.arr[0]                                   = '\0';
bl_pat_org_doc_num.arr[0]                                         = '\0';
bl_pat_org_doc_date.arr[0]                                        = '\0';
bl_pat_doc_outst_amt_prn.arr[0]                                   = '\0';
bl_pat_doc_amt_prn.arr[0]                                         = '\0';
row_id.arr[0]                                                     = '\0';

bl_pat_org_doc_type_code.len                                      = 0;
bl_pat_org_doc_num.len                                            = 0;
bl_pat_org_doc_date.len                                           = 0;
bl_pat_doc_outst_amt_prn.len                                      = 0;
bl_pat_doc_amt_prn.len                                            = 0;
row_id.len                                                        = 0;

bl_pat_doc_outst_amt                                              = 0;
bl_pat_doc_amt                                                    = 0;

     /* EXEC SQL FETCH BL_PAT_LEDGER_CUR
               INTO :bl_pat_org_doc_type_code,
                    :bl_pat_org_doc_num,
                    :bl_pat_org_doc_date,
                    :bl_pat_doc_outst_amt_prn,
                    :bl_pat_doc_outst_amt,
                    :bl_pat_doc_amt_prn,
                    :bl_pat_doc_amt,
                    :bl_no_of_days,
                    :row_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )240;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_org_doc_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_org_doc_num;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_org_doc_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_pat_doc_outst_amt_prn;
     sqlstm.sqhstl[3] = (unsigned int  )25;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_doc_outst_amt;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_pat_doc_amt_prn;
     sqlstm.sqhstl[5] = (unsigned int  )25;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_pat_doc_amt;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_no_of_days;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&row_id;
     sqlstm.sqhstl[8] = (unsigned int  )27;
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
         err_mesg("FETCH failed on cursor BL_PAT_LEDGER_CUR",0,"");

bl_pat_org_doc_type_code.arr[bl_pat_org_doc_type_code.len]               = '\0';
bl_pat_org_doc_num.arr[bl_pat_org_doc_num.len]                           = '\0';
bl_pat_org_doc_date.arr[bl_pat_org_doc_date.len]                         = '\0';
bl_pat_doc_outst_amt_prn.arr[bl_pat_doc_outst_amt_prn.len]               = '\0';
bl_pat_doc_amt_prn.arr[bl_pat_doc_amt_prn.len]                           = '\0';
row_id.arr[row_id.len]                                                   = '\0';

    return(LAST_ROW?0:1);
}

fetch_financial_dtl()
{
bl_tot_bill_paid_amt     = 0;

     /* EXEC SQL OPEN BL_EPISODE_FIN_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0009;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )291;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_ip_open_episode_id;
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
         err_mesg("OPEN failed on cursor BL_EPISODE_FIN_CUR",0,"");

     /* EXEC SQL FETCH BL_EPISODE_FIN_CUR
               INTO :bl_tot_bill_paid_amt ; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )314;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_tot_bill_paid_amt;
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
         err_mesg("FETCH failed on cursor BL_EPISODE_FIN_CUR",0,"");
     
}

update_inhouse_bill_outst()
{

     /* EXEC SQL SELECT ROWID
                into :row_id
                FROM BL_INHOUSE_BILL       
                WHERE ROWID = :row_id   
                 FOR UPDATE OF DOC_OUTST_AMT; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select ROWID into :b0  from BL_INHOUSE_BILL where ROWID=\
:b0 for update of DOC_OUTST_AMT ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )333;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&row_id;
     sqlstm.sqhstl[0] = (unsigned int  )27;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&row_id;
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
         err_mesg("SELECT failed on table BL_INHOUSE_BILL",0,"");

     if (NOT_FOUND)
         err_mesg("Record not found in BL_INHOUSE_BILL",0,"");

     row_id.arr[row_id.len] = '\0';

     /* EXEC SQL UPDATE BL_INHOUSE_BILL 
                 SET DOC_OUTST_AMT = :bl_doc_outst_amt   
               WHERE ROWID = :row_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update BL_INHOUSE_BILL  set DOC_OUTST_AMT=:b0 where ROWI\
D=:b1";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )356;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_doc_outst_amt;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&row_id;
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
         err_mesg("UPDATE failed on table BL_INHOUSE_BILL",0,"");
}

fetch_dtls()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )379;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_ip_open_patient_id;
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
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )398;
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

    bl_patient_name_loc_lang.arr[bl_patient_name_loc_lang.len] = '\0';
    bl_patient_name.arr[bl_patient_name.len] = '\0';
	bl_patient_name1.arr[bl_patient_name1.len] = '\0';
}

print_rec(ind)
int ind;
{

   if (lctr > 53)
       print_head();

  fetch_dtls();

  if (ind == 0)
  {
      tot_admissions++;
      fprintf(fp,"%8s %-10s %-20s %-16.16s %-30.30s\n",
           bl_ip_open_episode_id.arr,
           bl_ip_admission_date_time.arr,
           bl_ip_open_patient_id.arr,
           bl_patient_name_loc_lang.arr,
           bl_patient_name.arr);

	  if(strlen(bl_patient_name1.arr) > 2)
		{
		 fprintf(fp,"%57s %s \n\n"," ",bl_patient_name1.arr);
		 lctr++;
		}
	  else
	    fprintf(fp,"\n");

     lctr+=2;
  }
  else
  {
      fprintf(fp,"        %-6s %8s %-10s ",
              bl_pat_org_doc_type_code.arr,
              bl_pat_org_doc_num.arr,
              bl_pat_org_doc_date.arr);
	  print_formated(bl_pat_doc_amt);
//              bl_pat_doc_amt_prn.arr);
      print_formated(bl_doc_outst_amt);fprintf(fp,"\n");
     lctr++;
     adm_amt_tot         += bl_pat_doc_amt;
 /*  adm_amt_outst_tot   += bl_pat_doc_outst_amt;  */
     adm_amt_outst_tot   += bl_doc_outst_amt;  
  }
  fflush(fp);
}

print_adm_tot()
{
   if (lctr > 50)
       print_head();

      fprintf(fp,"\n                                   ");
      fprintf(fp,"--------------------------------------------------------------------------------------------------\n");
      fprintf(fp,"                      Total        ");
      print_formated(adm_amt_tot);fprintf(fp," ");
      print_formated(adm_amt_outst_tot);fprintf(fp,"\n");
      fprintf(fp,"                                   ");
      fprintf(fp,"--------------------------------------------------------------------------------------------------\n\n");
      lctr +=5;
      grand_amt_tot         += adm_amt_tot;
      grand_amt_outst_tot   += adm_amt_outst_tot;

}  

print_grand_tot()
{
   if (lctr > 50)
       print_head();

      fprintf(fp,"\n              Number of Admissions ");
      fprintf(fp,"   %12d\n",tot_admissions);
      fprintf(fp,"\n                                   ");
      fprintf(fp,"--------------------------------------------------------------------------------------------------\n");
      fprintf(fp,"              Grand Total          ");
      print_formated(grand_amt_tot);fprintf(fp," ");
      print_formated(grand_amt_outst_tot);fprintf(fp,"\n");
      fprintf(fp,"                                   ");
      fprintf(fp,"--------------------------------------------------------------------------------------------------\n\n");
      lctr +=5;

}

end_of_rep()
{
fprintf(fp,"\n\n                                                      ***  END OF REPORT ***\n");
fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"blrinpen.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrinpen.lis");
       proc_exit();
    }
    print_title();
    print_head();
}

print_title()
{
fprintf(fp,
"MDL : BL                                         %-30s                                        %-16s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %s                               PAGE : %4d\n",
"BLRINPEN","INHOUSE BILLS OUTSTANDING FOR MORE THAN SPECIFIED DAYS",
++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"                  ADMISSION NO    FROM : %s\n",nd_from_adm_no.arr);
fprintf(fp,"                                   TO  : %s\n\n",nd_to_adm_no.arr);
fprintf(fp,"                  NO OF DAYS           : %d\n\n",nd_no_of_days);

}
print_head()
{
fprintf(fp,
"\fMDL : BL                                         %-30s                                        %-16s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %s                               PAGE : %4d\n",
"BLRINPEN","INHOUSE BILLS OUTSTANDING FOR MORE THAN SPECIFIED DAYS",++pctr);
fprintf(fp,"            NO. OF DAYS : %d\n",nd_no_of_days);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,
"ADM  NO. ADM DATE   PATIENT NO LOCAL   NAME     NAME\n");
fprintf(fp,
"        BILL NUMBER     BILL DATE           AMOUNT     OUTST AMOUNT\n");
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
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
     VSK 15/11/1999 */

    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY
			   WHERE  ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )425;
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