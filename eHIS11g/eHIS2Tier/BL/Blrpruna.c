
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrpruna.pc"
};


static unsigned int sqlctx = 1288468899;


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
"select EPISODE_ID ,PATIENT_ID ,TO_CHAR(NVL(TOT_UNADJ_PREP_AMT,0),'999,999,99\
0.99') ,NVL(TOT_UNADJ_PREP_AMT,0) ,TO_CHAR(NVL(TOT_PREP_PAID_AMT,0),'999,999,9\
90.99') ,NVL(TOT_PREP_PAID_AMT,0) ,TO_CHAR((NVL(TOT_PREP_PAID_AMT,0)-NVL(TOT_U\
NADJ_PREP_AMT,0)),'999,999,990.99') ,(NVL(TOT_PREP_PAID_AMT,0)-NVL(TOT_UNADJ_P\
REP_AMT,0))  from BL_EPISODE_FIN_DTLS where (((((EPISODE_TYPE=:b0 and EPISODE_\
ID between NVL(:b1,0) and NVL(:b2,99999999)) and PATIENT_ID between NVL(:b3,' \
') and NVL(:b4,'~~~~~~~~~~~~~~~~~~~~')) and NVL(TOT_UNADJ_PREP_AMT,0)<:b5) and\
 NVL(TOT_PREP_PAID_AMT,0)>0) and OPERATING_FACILITY_ID=:b6) order by EPISODE_I\
D,PATIENT_ID            ";

 static const char *sq0006 = 
"select EPISODE_ID ,VISIT_ID ,PATIENT_ID ,TO_CHAR(NVL(TOT_UNADJ_PREP_AMT,0),'\
999,999,990.99') ,NVL(TOT_UNADJ_PREP_AMT,0) ,TO_CHAR(NVL(TOT_PREP_PAID_AMT,0),\
'999,999,990.99') ,NVL(TOT_PREP_PAID_AMT,0) ,TO_CHAR((NVL(TOT_PREP_PAID_AMT,0)\
-NVL(TOT_UNADJ_PREP_AMT,0)),'999,999,990.99') ,(NVL(TOT_PREP_PAID_AMT,0)-NVL(T\
OT_UNADJ_PREP_AMT,0))  from BL_VISIT_FIN_DTLS where ((((((EPISODE_TYPE in ('O'\
,'E') and EPISODE_ID between NVL(:b0,0) and NVL(:b1,99999999)) and VISIT_ID be\
tween NVL(:b2,0) and NVL(:b3,9999)) and PATIENT_ID between NVL(:b4,' ') and NV\
L(:b5,'~~~~~~~~~~~~~~~~~~~~')) and NVL(TOT_UNADJ_PREP_AMT,0)<:b6) and NVL(TOT_\
PREP_PAID_AMT,0)>0) and OPERATING_FACILITY_ID=:b7) order by EPISODE_ID,VISIT_I\
D,PATIENT_ID            ";

 static const char *sq0007 = 
"select PATIENT_ID ,TO_CHAR(NVL(TOT_UNADJ_PREP_REF_AMT,0),'999,999,990.99') ,\
NVL(TOT_UNADJ_PREP_REF_AMT,0)  from BL_PATIENT_FIN_DTLS where (PATIENT_ID betw\
een NVL(:b0,' ') and NVL(:b1,'~~~~~~~~~~~~~~~~~~~~') and NVL(TOT_UNADJ_PREP_RE\
F_AMT,0)<:b2) order by PATIENT_ID            ";

 static const char *sq0008 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,short_name  from MP_PATIENT_MAST wh\
ere PATIENT_ID=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,125,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,178,0,0,0,0,0,1,0,
51,0,0,3,275,0,4,209,0,0,14,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
122,0,0,4,84,0,2,271,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
149,0,0,5,646,0,9,358,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
192,0,0,6,724,0,9,365,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
239,0,0,7,277,0,9,372,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
266,0,0,5,0,0,13,400,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,
0,0,2,9,0,0,2,4,0,0,
313,0,0,6,0,0,13,415,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,
0,0,2,4,0,0,2,9,0,0,2,4,0,0,
364,0,0,7,0,0,13,432,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,
391,0,0,8,105,0,9,454,0,0,1,1,0,1,0,1,9,0,0,
410,0,0,8,0,0,13,466,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
433,0,0,9,515,0,6,480,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
460,0,0,10,129,0,4,748,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
491,0,0,11,96,0,4,819,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
514,0,0,12,165,0,6,826,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                 */
/************************************************************************/
/* PROGRAM NAME          : BLRPRUNA.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 24-AUG-1993                                  */
/*                                                                      */
/* CALLED FROM            :                                              */
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
			nd_pwd									   [100],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],
            nd_epi_type                                [2],
            nd_epi_level                               [2],
            nd_fm_epi_no                               [9],
            nd_to_epi_no                               [9],
            nd_fm_visit_no                             [5],
            nd_to_visit_no                             [5],
            nd_fm_pat_no                               [21],
            nd_to_pat_no                               [21],
            nd_cutoff_amt                              [23],
            nd_cutoff_amt_prn                          [23],
			nd_operating_facility_id				   [3],
            d_short_name_full                          [61],
            bl_patient_name_loc_lang                   [61],
            bl_patient_name                            [61],
			bl_patient_name1						   [61],
			l_pk_value								   [100],
			l_translated_value						   [201],
			p_language_id								[3],
			nd_facility_id							   [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[100]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } nd_epi_type;

struct { unsigned short len; unsigned char arr[2]; } nd_epi_level;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_epi_no;

struct { unsigned short len; unsigned char arr[9]; } nd_to_epi_no;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_visit_no;

struct { unsigned short len; unsigned char arr[5]; } nd_to_visit_no;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_pat_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_pat_no;

struct { unsigned short len; unsigned char arr[23]; } nd_cutoff_amt;

struct { unsigned short len; unsigned char arr[23]; } nd_cutoff_amt_prn;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


   /* VARCHAR bl_epi_episode_id                           [9],
           bl_epi_patient_id                           [21],
		   bl_epi_tot_unadj_prep_amt				   [23],
		   bl_epi_tot_prep_paid_amt					   [23],
		   bl_epi_tot_utilized_amt					   [23],
           bl_epi_visit_id                             [5]; */ 
struct { unsigned short len; unsigned char arr[9]; } bl_epi_episode_id;

struct { unsigned short len; unsigned char arr[21]; } bl_epi_patient_id;

struct { unsigned short len; unsigned char arr[23]; } bl_epi_tot_unadj_prep_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_epi_tot_prep_paid_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_epi_tot_utilized_amt;

struct { unsigned short len; unsigned char arr[5]; } bl_epi_visit_id;


 double    bl_epi_tot_unadj_prep_amt_db = 0,
		   bl_epi_tot_prep_paid_amt_db = 0,
		   bl_epi_tot_utilized_amt_db = 0,
           bl_grn_tot_unadj_prep_amt = 0,
		   bl_grn_tot_prep_paid_amt = 0,
		   bl_grn_tot_utilized_amt =0;

	int i;
	
	char g_facility_id[3];

    char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];


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

char       pgm_name_loc                               [15];

int    lctr = 0,pctr = 0;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;
 
    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRPRUNA");

	 strcpy(nd_pwd.arr,argv[1]);
	 nd_pwd.len = strlen(nd_pwd.arr);

	 /* EXEC sql connect :nd_pwd; */ 

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
  sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )102;
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

	strcpy(nd_facility_id.arr,argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);
    strcpy(g_facility_id,nd_facility_id.arr);

		
	strcpy(p_language_id.arr,l_language_id.arr); 
    start_prog_msg();

	fetch_legend_value();

    fetch_prog_param();
    declare_cur();
    fetch_hosp_name();
    open_file();
     
    open_cur();

    while(fetch_cur())
    {
       rec_ctr++;
       print_rec();
       bl_grn_tot_unadj_prep_amt += bl_epi_tot_unadj_prep_amt_db;
	   bl_grn_tot_prep_paid_amt += bl_epi_tot_prep_paid_amt_db;
	   bl_grn_tot_utilized_amt += bl_epi_tot_utilized_amt_db;
     }
     if (rec_ctr)
        print_grand_tot();

    end_of_rep();
    end_prog_msg();
  	fclose(fp);

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

    return;
}

fetch_prog_param()
{
    nd_epi_type.arr[0]          = '\0';
    nd_epi_level.arr[0]         = '\0';
    nd_fm_epi_no.arr[0]         = '\0';
    nd_to_epi_no.arr[0]         = '\0';
    nd_fm_visit_no.arr[0]       = '\0';
    nd_to_visit_no.arr[0]       = '\0';
    nd_fm_pat_no.arr[0]         = '\0';
    nd_to_pat_no.arr[0]         = '\0';
    nd_cutoff_amt.arr[0]        = '\0';
    nd_cutoff_amt_prn.arr[0]        = '\0';

    nd_epi_type.len             = 0;
    nd_epi_level.len            = 0;
    nd_fm_epi_no.len            = 0;
    nd_to_epi_no.len            = 0;
    nd_fm_visit_no.len          = 0;
    nd_to_visit_no.len          = 0;
    nd_fm_pat_no.len            = 0;
    nd_to_pat_no.len            = 0;
    nd_cutoff_amt.len           = 0;
    nd_cutoff_amt_prn.len       = 0;   
  
   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,
                   PARAM6,PARAM7,PARAM8,PARAM9,
                   TO_CHAR(TO_NUMBER(PARAM9),'999,999,990.99')  
              INTO :nd_operating_facility_id,
			       :nd_epi_type,
                   :nd_epi_level,
                   :nd_fm_epi_no,
                   :nd_to_epi_no,
                   :nd_fm_visit_no,
                   :nd_to_visit_no,
                   :nd_fm_pat_no,
                   :nd_to_pat_no,
                   :nd_cutoff_amt,
                   :nd_cutoff_amt_prn
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,TO_CHAR(TO_NUMBER(PARAM9),'999,999\
,990.99') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from SY_PROG_PARA\
M where ((PGM_ID=:b11 and SESSION_ID=:b12) and PGM_DATE=:b13)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_epi_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_epi_level;
   sqlstm.sqhstl[2] = (unsigned int  )4;
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
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_pat_no;
   sqlstm.sqhstl[7] = (unsigned int  )23;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_pat_no;
   sqlstm.sqhstl[8] = (unsigned int  )23;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_cutoff_amt;
   sqlstm.sqhstl[9] = (unsigned int  )25;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_cutoff_amt_prn;
   sqlstm.sqhstl[10] = (unsigned int  )25;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[11] = (unsigned int  )17;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[12] = (unsigned int  )18;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[13] = (unsigned int  )27;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

    nd_epi_type.arr[nd_epi_type.len]              = '\0';
    nd_epi_level.arr[nd_epi_level.len]            = '\0';
    nd_fm_epi_no.arr[nd_fm_epi_no.len]            = '\0';
    nd_to_epi_no.arr[nd_to_epi_no.len]            = '\0';
    nd_fm_visit_no.arr[nd_fm_visit_no.len]        = '\0';
    nd_to_visit_no.arr[nd_to_visit_no.len]        = '\0';
    nd_fm_pat_no.arr[nd_fm_pat_no.len]            = '\0';
    nd_to_pat_no.arr[nd_to_pat_no.len]            = '\0';
    nd_cutoff_amt.arr[nd_cutoff_amt.len]          = '\0';
    nd_cutoff_amt_prn.arr[nd_cutoff_amt_prn.len]          = '\0';

    strcpy(g_facility_id, nd_operating_facility_id.arr);

    strcpy(pgm_name_loc,"BLRPRUN");
    switch (nd_epi_type.arr[0]) 
    {
       case 'I' : strcat(pgm_name_loc,"I");    
                  break;
       case 'D' : strcat(pgm_name_loc,"I");
                  break;  
       case 'O' :
                  if (nd_epi_level.arr[0] == 'E')
                      strcat(pgm_name_loc,"O");
                  else
                      strcat(pgm_name_loc,"V");
                  break;
       case 'E' :
                  if (nd_epi_level.arr[0] == 'E')
                      strcat(pgm_name_loc,"O");
                  else
                      strcat(pgm_name_loc,"V");
                  break;       
       case 'R' : strcat(pgm_name_loc,"R");
                  break;
    }

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )122;
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

     /* EXEC SQL DECLARE BL_EPI_FIN_DTLS_CUR CURSOR FOR
               SELECT EPISODE_ID,
                      PATIENT_ID,
                      TO_CHAR(NVL(TOT_UNADJ_PREP_AMT,0),'999,999,990.99'),
                      NVL(TOT_UNADJ_PREP_AMT,0),
					  TO_CHAR(NVL(TOT_PREP_PAID_AMT,0),'999,999,990.99'),
					  NVL(TOT_PREP_PAID_AMT,0),
					  TO_CHAR(NVL(TOT_PREP_PAID_AMT,0)-NVL(TOT_UNADJ_PREP_AMT,0),'999,999,990.99'),
					  (NVL(TOT_PREP_PAID_AMT,0)-NVL(TOT_UNADJ_PREP_AMT,0))
                 FROM BL_EPISODE_FIN_DTLS
                WHERE EPISODE_TYPE = :nd_epi_type
                  AND EPISODE_ID 
                         BETWEEN NVL(:nd_fm_epi_no,0) AND
                                 NVL(:nd_to_epi_no,99999999)
                  AND PATIENT_ID
                         BETWEEN NVL(:nd_fm_pat_no,' ') AND
                                 NVL(:nd_to_pat_no,'~~~~~~~~~~~~~~~~~~~~')
                  AND NVL(TOT_UNADJ_PREP_AMT,0) < :nd_cutoff_amt
                  AND NVL(TOT_PREP_PAID_AMT,0)  > 0
				  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                ORDER BY EPISODE_ID,PATIENT_ID; */ 


     /* EXEC SQL DECLARE BL_VISIT_FIN_DTLS_CUR CURSOR FOR
               SELECT EPISODE_ID,
                      VISIT_ID,
                      PATIENT_ID,
                      TO_CHAR(NVL(TOT_UNADJ_PREP_AMT,0),'999,999,990.99'),
                      NVL(TOT_UNADJ_PREP_AMT,0),
					  TO_CHAR(NVL(TOT_PREP_PAID_AMT,0),'999,999,990.99'),
					  NVL(TOT_PREP_PAID_AMT,0),
  					  TO_CHAR(NVL(TOT_PREP_PAID_AMT,0)-NVL(TOT_UNADJ_PREP_AMT,0),'999,999,990.99'),
					  (NVL(TOT_PREP_PAID_AMT,0)-NVL(TOT_UNADJ_PREP_AMT,0))
                 FROM BL_VISIT_FIN_DTLS
                WHERE EPISODE_TYPE in ('O','E') 
                  AND EPISODE_ID 
                         BETWEEN NVL(:nd_fm_epi_no,0) AND
                                 NVL(:nd_to_epi_no,99999999)
                  AND VISIT_ID
                         BETWEEN NVL(:nd_fm_visit_no,0) AND
                                 NVL(:nd_to_visit_no,9999)
                  AND PATIENT_ID
                         BETWEEN NVL(:nd_fm_pat_no,' ') AND
                                 NVL(:nd_to_pat_no,'~~~~~~~~~~~~~~~~~~~~')
                  AND NVL(TOT_UNADJ_PREP_AMT,0) < :nd_cutoff_amt
				  AND NVL(TOT_PREP_PAID_AMT,0)  > 0
				  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                ORDER BY EPISODE_ID,VISIT_ID,PATIENT_ID; */ 


     /* EXEC SQL DECLARE BL_PAT_FIN_DTLS_CUR CURSOR FOR
               SELECT PATIENT_ID,
                      TO_CHAR(NVL(TOT_UNADJ_PREP_REF_AMT,0),'999,999,990.99'),
                      NVL(TOT_UNADJ_PREP_REF_AMT,0)
                 FROM BL_PATIENT_FIN_DTLS
                WHERE PATIENT_ID
                         BETWEEN NVL(:nd_fm_pat_no,' ') AND
                                 NVL(:nd_to_pat_no,'~~~~~~~~~~~~~~~~~~~~')
                  AND NVL(TOT_UNADJ_PREP_REF_AMT,0) < :nd_cutoff_amt
                ORDER BY PATIENT_ID; */ 
  

    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
			         /osubstr(SHORT_NAME,1,30),
					 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname2 ,
                       o/
					           short_name
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_epi_patient_id; */ 

}

open_cur()    
{
   if ((nd_epi_type.arr[0] == 'I' || nd_epi_type.arr[0] == 'D' ) || 
          ((nd_epi_type.arr[0] == 'O' || nd_epi_type.arr[0] == 'E') && nd_epi_level.arr[0] == 'E'))
   {
     /* EXEC SQL OPEN BL_EPI_FIN_DTLS_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0005;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )149;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_epi_type;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_fm_epi_no;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_to_epi_no;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_fm_pat_no;
     sqlstm.sqhstl[3] = (unsigned int  )23;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_to_pat_no;
     sqlstm.sqhstl[4] = (unsigned int  )23;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_cutoff_amt;
     sqlstm.sqhstl[5] = (unsigned int  )25;
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
         err_mesg("OPEN failed on cursor BL_EPI_FIN_DTLS_CUR",0,"");
  }
  else if ( (nd_epi_type.arr[0] == 'O' || nd_epi_type.arr[0] == 'E' ) && nd_epi_level.arr[0] == 'V')
  {
     /* EXEC SQL OPEN BL_VISIT_FIN_DTLS_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0006;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )192;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fm_epi_no;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_epi_no;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fm_visit_no;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_to_visit_no;
     sqlstm.sqhstl[3] = (unsigned int  )7;
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
     sqlstm.sqhstv[6] = (         void  *)&nd_cutoff_amt;
     sqlstm.sqhstl[6] = (unsigned int  )25;
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



     if (OERROR)
         err_mesg("OPEN failed on cursor BL_VISIT_FIN_DTLS_CUR",0,"");
  }
  else if (nd_epi_type.arr[0] == 'R')
  {
     /* EXEC SQL OPEN BL_PAT_FIN_DTLS_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0007;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )239;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fm_pat_no;
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
     sqlstm.sqhstv[2] = (         void  *)&nd_cutoff_amt;
     sqlstm.sqhstl[2] = (unsigned int  )25;
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
         err_mesg("OPEN failed on cursor BL_PAT_FIN_DTLS_CUR",0,"");
  }
}

fetch_cur()
{
bl_epi_episode_id.arr[0]                                          = '\0';
bl_epi_patient_id.arr[0]                                          = '\0';
bl_epi_tot_unadj_prep_amt.arr[0]                                  = '\0';
bl_epi_tot_prep_paid_amt.arr[0]                                   = '\0';
bl_epi_tot_utilized_amt.arr[0]									  = '\0';
bl_epi_visit_id.arr[0]                                            = '\0';

bl_epi_episode_id.len                                             = 0;
bl_epi_patient_id.len                                             = 0;
bl_epi_tot_unadj_prep_amt.len                                     = 0;
bl_epi_tot_prep_paid_amt.len                                      = 0;
bl_epi_tot_utilized_amt.len										  = 0;
bl_epi_visit_id.len                                               = 0;

bl_epi_tot_unadj_prep_amt_db                                      = 0;

   if ((nd_epi_type.arr[0] == 'I' || nd_epi_type.arr[0] == 'D') || 
          ((nd_epi_type.arr[0] == 'O' || nd_epi_type.arr[0] == 'E')  && nd_epi_level.arr[0] == 'E'))
   {
     /* EXEC SQL FETCH BL_EPI_FIN_DTLS_CUR
               INTO :bl_epi_episode_id,
                    :bl_epi_patient_id,
                    :bl_epi_tot_unadj_prep_amt,
                    :bl_epi_tot_unadj_prep_amt_db,
					:bl_epi_tot_prep_paid_amt,
					:bl_epi_tot_prep_paid_amt_db,
					:bl_epi_tot_utilized_amt,
					:bl_epi_tot_utilized_amt_db; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )266;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_epi_episode_id;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_epi_patient_id;
     sqlstm.sqhstl[1] = (unsigned int  )23;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_epi_tot_unadj_prep_amt;
     sqlstm.sqhstl[2] = (unsigned int  )25;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_epi_tot_unadj_prep_amt_db;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_epi_tot_prep_paid_amt;
     sqlstm.sqhstl[4] = (unsigned int  )25;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_epi_tot_prep_paid_amt_db;
     sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_epi_tot_utilized_amt;
     sqlstm.sqhstl[6] = (unsigned int  )25;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_epi_tot_utilized_amt_db;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor BL_EPI_FIN_DTLS_CUR",0,"");
  }
  else if ((nd_epi_type.arr[0] == 'O' || nd_epi_type.arr[0] == 'E')  && nd_epi_level.arr[0] == 'V')
  {
     /* EXEC SQL FETCH BL_VISIT_FIN_DTLS_CUR
               INTO :bl_epi_episode_id,
                    :bl_epi_visit_id,
                    :bl_epi_patient_id,
                    :bl_epi_tot_unadj_prep_amt,
                    :bl_epi_tot_unadj_prep_amt_db,
					:bl_epi_tot_prep_paid_amt,
					:bl_epi_tot_prep_paid_amt_db,
					:bl_epi_tot_utilized_amt,
					:bl_epi_tot_utilized_amt_db; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )313;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_epi_episode_id;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_epi_visit_id;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_epi_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_epi_tot_unadj_prep_amt;
     sqlstm.sqhstl[3] = (unsigned int  )25;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_epi_tot_unadj_prep_amt_db;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_epi_tot_prep_paid_amt;
     sqlstm.sqhstl[5] = (unsigned int  )25;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_epi_tot_prep_paid_amt_db;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_epi_tot_utilized_amt;
     sqlstm.sqhstl[7] = (unsigned int  )25;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_epi_tot_utilized_amt_db;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor BL_VISIT_FIN_DTLS_CUR",0,"");
  }
  else if (nd_epi_type.arr[0] == 'R')
  {
     /* EXEC SQL FETCH BL_PAT_FIN_DTLS_CUR
               INTO :bl_epi_patient_id,
                    :bl_epi_tot_unadj_prep_amt,
                    :bl_epi_tot_unadj_prep_amt_db; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )364;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_epi_patient_id;
     sqlstm.sqhstl[0] = (unsigned int  )23;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_epi_tot_unadj_prep_amt;
     sqlstm.sqhstl[1] = (unsigned int  )25;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_epi_tot_unadj_prep_amt_db;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor BL_PAT_FIN_DTLS_CUR",0,"");
  }

bl_epi_episode_id.arr[bl_epi_episode_id.len]                             = '\0';
bl_epi_patient_id.arr[bl_epi_patient_id.len]                             = '\0';
bl_epi_tot_unadj_prep_amt.arr[bl_epi_tot_unadj_prep_amt.len]             = '\0';
bl_epi_tot_utilized_amt.arr[bl_epi_tot_utilized_amt.len]				 = '\0';
bl_epi_tot_prep_paid_amt.arr[bl_epi_tot_prep_paid_amt.len]               = '\0';
bl_epi_visit_id.arr[bl_epi_visit_id.len]                                 = '\0';

    return(LAST_ROW?0:1);
}

fetch_dtls()  
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )391;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_epi_patient_id;
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
                  /o :bl_patient_name,
				   :bl_patient_name1,o/
                           :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )410;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_patient_name_loc_lang;
    sqlstm.sqhstl[0] = (unsigned int  )63;
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
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60\
 ) ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 ,\
 str2 ) ; IF str2 IS NOT NULL THEN :bl_patient_name := str2 ; END IF ; blcommo\
n . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 \
IS NOT NULL THEN :bl_patient_name1 := str2 ; END IF ; blcommon . split_words (\
 :d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN \
:bl_patient_name1 := :bl_patient_name1 || str2 ; end if ; END ; END ;";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )433;
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

print_rec(ind)
int ind;
{
  fetch_dtls();
  if ((nd_epi_type.arr[0] == 'I' || nd_epi_type.arr[0] == 'D' ) || 
          ((nd_epi_type.arr[0] == 'O' || nd_epi_type.arr[0] == 'E') && nd_epi_level.arr[0] == 'E'))
  {
     fprintf(fp,"    %8s %-20s %-16.16s  %-30.30s                ",
	 //  %-23s  %-23s %-23s\n",
              bl_epi_episode_id.arr,
              bl_epi_patient_id.arr,  
              bl_patient_name_loc_lang.arr,
              bl_patient_name.arr);
	print_formated(bl_epi_tot_prep_paid_amt_db, fp);
	print_formated(bl_epi_tot_utilized_amt_db, fp);
	print_formated(bl_epi_tot_unadj_prep_amt_db, fp);
	fprintf(fp, "\n");

if(strlen(bl_patient_name1.arr) > 2)
{
 fprintf(fp,"%51s %s \n"," ",bl_patient_name1.arr);
}


/*			  bl_epi_tot_prep_paid_amt.arr,
			  bl_epi_tot_utilized_amt.arr,
              bl_epi_tot_unadj_prep_amt.arr
			  );*/
  }
  else if ( (nd_epi_type.arr[0] == 'O' || nd_epi_type.arr[0] == 'E') && nd_epi_level.arr[0] == 'V')
  {

     fprintf(fp,"    %8s  %4s  %-20s %-16.16s %-30.30s      ",
	 //%-23s %-23s %-23s\n",
              bl_epi_episode_id.arr,  
              bl_epi_visit_id.arr,    
              bl_epi_patient_id.arr, 
              bl_patient_name_loc_lang.arr,  
              bl_patient_name.arr);
	print_formated(bl_epi_tot_prep_paid_amt_db, fp);
	print_formated(bl_epi_tot_utilized_amt_db, fp);
	print_formated(bl_epi_tot_unadj_prep_amt_db, fp);
	fprintf(fp, "\n");


if(strlen(bl_patient_name1.arr) > 2)
{
 fprintf(fp,"%51s %s \n"," ",bl_patient_name1.arr);
}


/*			  bl_epi_tot_prep_paid_amt.arr,  
			  bl_epi_tot_utilized_amt.arr,   
              bl_epi_tot_unadj_prep_amt.arr); */
  }
  else if (nd_epi_type.arr[0] == 'R')
  {
     fprintf(fp,"    %-20s %-16.16s %-30.30s          ",
	 // %-23s %-23s \n",
              bl_epi_patient_id.arr,
              bl_patient_name_loc_lang.arr,
              bl_patient_name.arr);
	print_formated(bl_epi_tot_prep_paid_amt_db, fp);
	print_formated(bl_epi_tot_unadj_prep_amt_db, fp);
	fprintf(fp, "\n");

if(strlen(bl_patient_name1.arr) > 2)
{
 fprintf(fp,"%41s %s \n"," ",bl_patient_name1.arr);
}


	/*		  bl_epi_tot_prep_paid_amt.arr,
              bl_epi_tot_unadj_prep_amt.arr);*/
  }
  fflush(fp);
}

print_grand_tot()
{
    if (lctr > 52)
       print_head();

  fprintf(fp,"\n");
  fprintf(fp,"                                                                                       ------------------------------------------------------------------\n");
  fprintf(fp,"                          %11s                                                             ",loc_legend[190]);
  print_formated(bl_grn_tot_prep_paid_amt, fp);
//  fprintf(fp,"%-10s"," ");
  print_formated(bl_grn_tot_utilized_amt, fp);
//  fprintf(fp,"%-9s"," ");
  print_formated(bl_grn_tot_unadj_prep_amt, fp);
  fprintf(fp,"\n");
  fprintf(fp,"                                                                                       ------------------------------------------------------------------\n");
fflush(fp);
}
   
end_of_rep()
{
fprintf(fp,"\n\n                                                      ***  END OF REPORT ***\n");
fflush(fp);
}

open_file()
{
char filename[30];

  if (nd_epi_type.arr[0] == 'I' || nd_epi_type.arr[0] == 'D' )
  {
    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrpruni.lis");
    strcpy(OUTPUT_FILE_NAME,"blrpruni.lis");
	}
  else if (nd_epi_type.arr[0] == 'O' || nd_epi_type.arr[0] == 'E')
  {
       if (nd_epi_level.arr[0] == 'E')
   {
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrpruno.lis");
	strcpy(OUTPUT_FILE_NAME,"blrpruno.lis");
	}
       else
	  {
    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrprunv.lis");
	strcpy(OUTPUT_FILE_NAME,"blrprunv.lis");
	}
}

  else 
 //   strcpy(file_name,"blrprunr.lis");
 {
    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrprunr.lis");
	strcpy(OUTPUT_FILE_NAME,"blrprunr.lis");
	}

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRPRUNR.LIS");
       proc_exit();
    }
    print_title();
    print_head(); 
}

print_title()
{
fprintf(fp,
"MDL : %2s                                         %-30s                                     %-15s\n",loc_legend[150],
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %49s                                    %4s : %4d\n",
loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"                  %12s         : %s\n\n",loc_legend[260],nd_epi_type.arr);
fprintf(fp,"                  %7s%s%11s  : %s\n\n",loc_legend[120],"/",loc_legend[90],nd_epi_level.arr);
fprintf(fp,"                  %10s      %4s : %s\n",loc_legend[270],loc_legend[60],nd_fm_epi_no.arr);
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],nd_to_epi_no.arr);
fprintf(fp,"                  %8s        %4s : %s\n",loc_legend[280],loc_legend[60],nd_fm_visit_no.arr);
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],nd_to_visit_no.arr);
fprintf(fp,"                  %10s      %4s : %s\n",loc_legend[200],loc_legend[60],nd_fm_pat_no.arr);
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],nd_to_pat_no.arr);
fprintf(fp,"                  %13s        : %s\n\n",loc_legend[110],nd_cutoff_amt_prn.arr);

}
print_head()
{
fprintf(fp,
"\fMDL : %2s                                         %-30s                                                     %-15s\n",loc_legend[150],
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %49s                                                    %4s : %4d\n",
loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
  if ((nd_epi_type.arr[0] == 'I' || nd_epi_type.arr[0] == 'D' ) || 
          ( (nd_epi_type.arr[0] == 'O' || nd_epi_type.arr[0] == 'E') && nd_epi_level.arr[0] == 'E'))
  {
    /*
     fprintf(fp,"\n EPISODE TYPE : %s    %s\n",
             nd_epi_type.arr,(nd_epi_type.arr[0] == 'I')?
                "I/P":"O/P      EPISODE LEVEL");
    */
    fprintf(fp,"\n %12s : %s    ",loc_legend[260],nd_epi_type.arr);
    if (nd_epi_type.arr[0] == 'I' )
      fprintf(fp,"%3s\n",loc_legend[250]);
    else if (nd_epi_type.arr[0] == 'D' )
      fprintf(fp,"%3s\n",loc_legend[240]);
    else if (nd_epi_type.arr[0] == 'O' )
      fprintf(fp,"%3s %13s\n",loc_legend[230],loc_legend[130]);
    else if (nd_epi_type.arr[0] == 'E' )
      fprintf(fp,"%3s %13s\n",loc_legend[220],loc_legend[130]);

     fprintf(fp,"------------------------------------------------------------------------------------------------------------------------------------------------------\n");
     fprintf(fp,"      %6s %10s %s %4s                                                                        %11s  %15s  %16s\n",loc_legend[100],loc_legend[200],"&",loc_legend[80],loc_legend[140],loc_legend[170],loc_legend[160]);
     fprintf(fp,"------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  }
  else if (nd_epi_type.arr[0] == 'O' && nd_epi_level.arr[0] == 'V')
  {
     fprintf(fp,"\n %12s : %s    %3s      %11s\n",loc_legend[260],loc_legend[300],loc_legend[230],loc_legend[90]);
     fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
     fprintf(fp,"    %10s %8s %10s %s %4s                                                %11s  %15s  %16s\n",loc_legend[270],loc_legend[280],loc_legend[200],"&",loc_legend[80],loc_legend[140],loc_legend[170],loc_legend[160]);
     fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  }
 else if (nd_epi_type.arr[0] == 'E' && nd_epi_level.arr[0] == 'V')
  {
     fprintf(fp,"\n %12s : %s    %3s      %11s\n",loc_legend[260],loc_legend[320],loc_legend[220],loc_legend[90]);
     fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
     fprintf(fp,"    %10s %8s %10s %s %4s                                                %11s  %15s  %16s\n",loc_legend[270],loc_legend[280],loc_legend[200],"&",loc_legend[80],loc_legend[140],loc_legend[170],loc_legend[160]);
     fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  }
  else if (nd_epi_type.arr[0] == 'R')
  {
     fprintf(fp,"\n %12s : %s    %3s\n",loc_legend[260],loc_legend[330],loc_legend[210]);
     fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------\n");
     fprintf(fp,"    %10s %s %4s                                                                    %11s %16s\n",loc_legend[200],"&",loc_legend[80],loc_legend[140],loc_legend[160]);
     fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------\n");
  }
fflush(fp);
lctr = 8;
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY  HH24:MI'),
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
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY  HH24\
:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )460;
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

print_formated(loc_amount,fp)
	double  loc_amount;
	FILE	*fp;
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

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRPRUNA.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRPRUNA.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )491;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )514;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
