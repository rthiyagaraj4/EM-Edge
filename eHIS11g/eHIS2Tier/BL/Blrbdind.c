
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrbdind.pc"
};


static unsigned int sqlctx = 1288465851;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {12,18};

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
"select BED_CLASS_CODE ,BLNG_SERV_CODE ,TO_CHAR(SERV_DATE,'DD/MM/YYYY') ,TO_C\
HAR(NVL(BASE_CHARGE,0),'999,999,990.99') ,TO_CHAR(NVL(GROSS_CHARGE,0),'999,999\
,990.99') ,TO_CHAR(NVL(DISC_AMT,0),'999,999,990.99') ,TO_CHAR((NVL(GROSS_CHARG\
E,0)-NVL(DISC_AMT,0)),'999,999,990.99') ,NVL(BASE_CHARGE,0) ,NVL(GROSS_CHARGE,\
0) ,NVL(DISC_AMT,0) ,(NVL(GROSS_CHARGE,0)-NVL(DISC_AMT,0))  from BL_SRV_INC_SU\
M_DTL where ((((EPISODE_TYPE in ('I','D') and BED_CLASS_CODE between NVL(:b0,'\
 ') and NVL(:b1,'~~')) and BLNG_SERV_CODE between NVL(:b2,' ') and NVL(:b3,'~~\
~~~~')) and SERV_DATE between NVL(TO_DATE(:b4,'DD/MM/YYYY'),to_date('00010101'\
,'YYYYDDMM')) and NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM')\
)) and OPERATING_FACILITY_ID=:b6) order by BED_CLASS_CODE,BLNG_SERV_CODE,SERV_\
DATE            ";

 static const char *sq0006 = 
"select BED_CLASS_CODE ,PACKAGE_CODE ,TO_CHAR(SERV_DATE,'DD/MM/YYYY') ,TO_CHA\
R(NVL(BASE_CHARGE,0),'999,999,990.99') ,TO_CHAR(NVL(GROSS_CHARGE,0),'999,999,9\
90.99') ,TO_CHAR(NVL(DISC_AMT,0),'999,999,990.99') ,TO_CHAR((NVL(GROSS_CHARGE,\
0)-NVL(DISC_AMT,0)),'999,999,990.99') ,NVL(BASE_CHARGE,0) ,NVL(GROSS_CHARGE,0)\
 ,NVL(DISC_AMT,0) ,(NVL(GROSS_CHARGE,0)-NVL(DISC_AMT,0))  from BL_PKG_INC_SUM_\
DTL where ((((EPISODE_TYPE in ('I','D') and BED_CLASS_CODE between NVL(:b0,' '\
) and NVL(:b1,'~~')) and PACKAGE_CODE between NVL(:b2,' ') and NVL(:b3,'~~~~~~\
')) and SERV_DATE between NVL(TO_DATE(:b4,'DD/MM/YYYY'),to_date('00010101','YY\
YYDDMM')) and NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))) a\
nd OPERATING_FACILITY_ID=:b6) order by BED_CLASS_CODE,PACKAGE_CODE,SERV_DATE  \
          ";

 static const char *sq0009 = 
"select LONG_DESC  from IP_BED_CLASS where BED_CLASS_CODE=:b0           ";

 static const char *sq0007 = 
"select LONG_DESC  from BL_PACKAGE_HDR where PACKAGE_CODE=:b0           ";

 static const char *sq0008 = 
"select LONG_DESC  from BL_BLNG_SERV where BLNG_SERV_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,140,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,206,0,0,0,0,0,1,0,
51,0,0,3,293,0,4,246,0,0,18,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
138,0,0,4,84,0,2,295,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
165,0,0,5,794,0,9,390,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
208,0,0,6,788,0,9,397,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
251,0,0,5,0,0,13,429,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
310,0,0,6,0,0,13,448,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
369,0,0,9,71,0,9,482,0,0,1,1,0,1,0,1,9,0,0,
388,0,0,9,0,0,13,486,0,0,1,0,0,1,0,2,9,0,0,
407,0,0,7,71,0,9,503,0,0,1,1,0,1,0,1,9,0,0,
426,0,0,7,0,0,13,507,0,0,1,0,0,1,0,2,9,0,0,
445,0,0,8,71,0,9,515,0,0,1,1,0,1,0,1,9,0,0,
464,0,0,8,0,0,13,519,0,0,1,0,0,1,0,2,9,0,0,
483,0,0,10,128,0,4,759,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRBDIND.PC                                */
/* AUTHOR                : S. SRIRAM                                    */
/* Converted To Windows  : Prasad B G S                                 */
/* DATE WRITTEN          : 24-AUG-1993                                  */
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
            nd_pkg_serv_flag                           [2],
            nd_rep_flag                                [2],
            nd_fm_bed_class                            [3],
            nd_to_bed_class                            [3],
            nd_fm_blng_serv                            [11],
            nd_to_blng_serv                            [11],
            nd_fm_date                                 [12],
            nd_to_date                                 [12],
            nd_fm_month                                [3],
            nd_to_month                                [3],
            nd_fm_year                                 [5],
            nd_to_year                                 [5],
            nd_fm_date_prn                             [12],
            nd_to_date_prn                             [12],
			nd_operating_facility_id				   [3],

            bl_blng_long_desc                          [41],
            bl_bed_long_desc                           [31]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } nd_pkg_serv_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_flag;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_bed_class;

struct { unsigned short len; unsigned char arr[3]; } nd_to_bed_class;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_blng_serv;

struct { unsigned short len; unsigned char arr[11]; } nd_to_blng_serv;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_month;

struct { unsigned short len; unsigned char arr[3]; } nd_to_month;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_year;

struct { unsigned short len; unsigned char arr[5]; } nd_to_year;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date_prn;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date_prn;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[41]; } bl_blng_long_desc;

struct { unsigned short len; unsigned char arr[31]; } bl_bed_long_desc;


   /* VARCHAR bl_bed_class_code                           [3],
           bl_blng_serv_code                           [11],
           bl_serv_date                                [13],
           bl_base_charge                              [23],
           bl_gross_charge                             [23],
           bl_disc_amt                                 [23],
           bl_net_amt                                  [23]; */ 
struct { unsigned short len; unsigned char arr[3]; } bl_bed_class_code;

struct { unsigned short len; unsigned char arr[11]; } bl_blng_serv_code;

struct { unsigned short len; unsigned char arr[13]; } bl_serv_date;

struct { unsigned short len; unsigned char arr[23]; } bl_base_charge;

struct { unsigned short len; unsigned char arr[23]; } bl_gross_charge;

struct { unsigned short len; unsigned char arr[23]; } bl_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_net_amt;


  double   bl_base_charge_db,
           bl_gross_charge_db,
           bl_disc_amt_db,
           bl_net_amt_db,

           blng_tot_base_charge,
           blng_tot_gross_charge,
           blng_tot_disc_amt,
           blng_tot_net_amt,

           bed_tot_base_charge,
           bed_tot_gross_charge,
           bed_tot_disc_amt,
           bed_tot_net_amt,

           grn_tot_base_charge,
           grn_tot_gross_charge,
           grn_tot_disc_amt,
           grn_tot_net_amt;


char   filename[150];

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

char       store_bed_class_code                           [3],
           store_blng_serv_code                           [11];

int    lctr = 0,pctr = 0;

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
 
    strcpy(g_pgm_id,"BLRBDIND");

 /*   if (sql_connect(argv[1]) == -1)
    {
        disp_message(ERR_MESG,"Error in connecting to Oracle");
        proc_exit();
    }
*/

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
     
    open_cur();

    while(fetch_cur())
    {
       if (rec_ctr == 0)
       {
          strcpy(store_bed_class_code,bl_bed_class_code.arr);
          strcpy(store_blng_serv_code,bl_blng_serv_code.arr);
          fetch_bed_cls_desc();
          fetch_pkg_serv_desc();
          print_rec(0);
          print_rec(1);
       }
       if (strcmp(store_bed_class_code,bl_bed_class_code.arr))
       {
            fetch_bed_cls_desc();
            fetch_pkg_serv_desc();
            print_bed_class_tot(1);
            strcpy(store_bed_class_code,bl_bed_class_code.arr);
            strcpy(store_blng_serv_code,bl_blng_serv_code.arr);
       }
       else if (strcmp(store_blng_serv_code,bl_blng_serv_code.arr))
       {
            fetch_pkg_serv_desc();
            print_blng_serv_tot(1);
            strcpy(store_blng_serv_code,bl_blng_serv_code.arr);
       }

       rec_ctr++;
       print_rec(2);
     }

     if (rec_ctr)
        print_grand_tot();

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
    return;
}

fetch_prog_param()
{
    nd_pkg_serv_flag.arr[0]         = '\0';
    nd_rep_flag.arr[0]              = '\0';
    nd_fm_bed_class.arr[0]          = '\0';
    nd_to_bed_class.arr[0]          = '\0';
    nd_fm_blng_serv.arr[0]          = '\0';
    nd_to_blng_serv.arr[0]          = '\0';
    nd_fm_date.arr[0]               = '\0';
    nd_to_date.arr[0]               = '\0';
    nd_fm_month.arr[0]              = '\0';
    nd_to_month.arr[0]              = '\0';
    nd_fm_year.arr[0]               = '\0';
    nd_to_year.arr[0]               = '\0';
    nd_fm_date_prn.arr[0]           = '\0';
    nd_to_date_prn.arr[0]           = '\0';

    nd_pkg_serv_flag.len            = 0;
    nd_rep_flag.len                 = 0;
    nd_fm_bed_class.len             = 0;
    nd_to_bed_class.len             = 0;
    nd_fm_blng_serv.len             = 0;
    nd_to_blng_serv.len             = 0;
    nd_fm_date.len                  = 0;
    nd_to_date.len                  = 0;
    nd_fm_month.len                 = 0;
    nd_to_month.len                 = 0;
    nd_fm_year.len                  = 0;
    nd_to_year.len                  = 0;
    nd_fm_date_prn.len              = 0;
    nd_to_date_prn.len              = 0;



   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,
                   PARAM6,PARAM7,PARAM8,PARAM9,PARAM10,
                   PARAM11,PARAM12,PARAM7,PARAM8
//                 TO_CHAR(TO_DATE(PARAM7,'DD-MON-YY'),'DD/MM/YYYY'),
//                 TO_CHAR(TO_DATE(PARAM8,'DD-MON-YY'),'DD/MM/YYYY')
              INTO :nd_operating_facility_id,
				   :nd_pkg_serv_flag,
                   :nd_rep_flag,
                   :nd_fm_bed_class,
                   :nd_to_bed_class,
                   :nd_fm_blng_serv,
                   :nd_to_blng_serv,
                   :nd_fm_date,
                   :nd_to_date,
                   :nd_fm_month,
                   :nd_to_month,
                   :nd_fm_year,
                   :nd_to_year,
                   :nd_fm_date_prn,
                   :nd_to_date_prn
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM7 \
,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14 \
 from SY_PROG_PARAM where ((PGM_ID=:b15 and SESSION_ID=:b16) and PGM_DATE=:b17\
)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_pkg_serv_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_rep_flag;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_bed_class;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_bed_class;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_blng_serv;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_blng_serv;
   sqlstm.sqhstl[6] = (unsigned int  )13;
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
   sqlstm.sqhstv[9] = (         void  *)&nd_fm_month;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_month;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_fm_year;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_to_year;
   sqlstm.sqhstl[12] = (unsigned int  )7;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_fm_date_prn;
   sqlstm.sqhstl[13] = (unsigned int  )14;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_to_date_prn;
   sqlstm.sqhstl[14] = (unsigned int  )14;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[15] = (unsigned int  )17;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[16] = (unsigned int  )18;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[17] = (unsigned int  )27;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
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

nd_pkg_serv_flag.arr[nd_pkg_serv_flag.len] = '\0';
nd_rep_flag.arr[nd_rep_flag.len] = '\0';
nd_fm_bed_class.arr[nd_fm_bed_class.len] = '\0';
nd_to_bed_class.arr[nd_to_bed_class.len] = '\0';
nd_fm_blng_serv.arr[nd_fm_blng_serv.len] = '\0';  
nd_to_blng_serv.arr[nd_to_blng_serv.len] = '\0';
nd_fm_date.arr[nd_fm_date.len] = '\0';
nd_to_date.arr[nd_to_date.len] = '\0';
nd_fm_month.arr[nd_fm_month.len] = '\0';
nd_to_month.arr[nd_to_month.len] = '\0';
nd_fm_year.arr[nd_fm_year.len] = '\0';
nd_to_year.arr[nd_to_year.len] = '\0';
nd_fm_date_prn.arr[nd_fm_date_prn.len] = '\0';
nd_to_date_prn.arr[nd_to_date_prn.len] = '\0';
   
   strcpy(g_facility_id, nd_operating_facility_id.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )138;
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

/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY VSK 14/11/1999 */


     /* EXEC SQL DECLARE BL_SRV_INC_SUM_DTL_CUR CURSOR FOR
               SELECT BED_CLASS_CODE,
                      BLNG_SERV_CODE,
                      TO_CHAR(SERV_DATE,'DD/MM/YYYY'),
                      TO_CHAR(NVL(BASE_CHARGE,0),'999,999,990.99'),
                      TO_CHAR(NVL(GROSS_CHARGE,0),'999,999,990.99'),
                      TO_CHAR(NVL(DISC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(GROSS_CHARGE,0) - NVL(DISC_AMT,0),'999,999,990.99'),
                      NVL(BASE_CHARGE,0),
                      NVL(GROSS_CHARGE,0),
                      NVL(DISC_AMT,0),
                      NVL(GROSS_CHARGE,0) - NVL(DISC_AMT,0)
                 FROM BL_SRV_INC_SUM_DTL 
                WHERE EPISODE_TYPE in ('I','D') //EPNH 30/10/2004
                  AND BED_CLASS_CODE 
                         BETWEEN NVL(:nd_fm_bed_class,' ') AND
                                 NVL(:nd_to_bed_class,'~~')
                  AND BLNG_SERV_CODE
                         BETWEEN NVL(:nd_fm_blng_serv,' ') AND
                                 NVL(:nd_to_blng_serv,'~~~~~~')
                  AND SERV_DATE BETWEEN 
                        NVL(TO_DATE(:nd_fm_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                       AND
                        NVL(TO_DATE(:nd_to_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
				  AND  OPERATING_FACILITY_ID = :nd_operating_facility_id
                ORDER BY BED_CLASS_CODE,BLNG_SERV_CODE,SERV_DATE; */ 


/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY VSK 14/11/1999 */


     /* EXEC SQL DECLARE BL_PKG_INC_SUM_DTL_CUR CURSOR FOR
               SELECT BED_CLASS_CODE,
                      PACKAGE_CODE,
                      TO_CHAR(SERV_DATE,'DD/MM/YYYY'),
                      TO_CHAR(NVL(BASE_CHARGE,0),'999,999,990.99'),
                      TO_CHAR(NVL(GROSS_CHARGE,0),'999,999,990.99'),
                      TO_CHAR(NVL(DISC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(GROSS_CHARGE,0) - NVL(DISC_AMT,0),'999,999,990.99'),
                      NVL(BASE_CHARGE,0),
                      NVL(GROSS_CHARGE,0),
                      NVL(DISC_AMT,0),
                      NVL(GROSS_CHARGE,0) - NVL(DISC_AMT,0)
                 FROM BL_PKG_INC_SUM_DTL
                WHERE EPISODE_TYPE in ('I','D') //EPNH 30/10/2004
                  AND BED_CLASS_CODE 
                         BETWEEN NVL(:nd_fm_bed_class,' ') AND
                                 NVL(:nd_to_bed_class,'~~')
                  AND PACKAGE_CODE
                         BETWEEN NVL(:nd_fm_blng_serv,' ') AND
                                 NVL(:nd_to_blng_serv,'~~~~~~')
                  AND SERV_DATE BETWEEN 
                        NVL(TO_DATE(:nd_fm_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                       AND
                        NVL(TO_DATE(:nd_to_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
				  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                ORDER BY BED_CLASS_CODE,PACKAGE_CODE,SERV_DATE; */ 


    /* EXEC SQL DECLARE BL_PACKAGE_HDR_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM BL_PACKAGE_HDR
               WHERE PACKAGE_CODE = :bl_blng_serv_code; */ 


    /* EXEC SQL DECLARE BL_BLNG_SERV_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM BL_BLNG_SERV
               WHERE BLNG_SERV_CODE = :bl_blng_serv_code; */ 


    /* EXEC SQL DECLARE IP_BED_CLASS_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM IP_BED_CLASS
               WHERE BED_CLASS_CODE = :bl_bed_class_code; */ 

}

open_cur()
{
   if (nd_pkg_serv_flag.arr[0] == 'S')
   {
     /* EXEC SQL OPEN BL_SRV_INC_SUM_DTL_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0005;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )165;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fm_bed_class;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_bed_class;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fm_blng_serv;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv;
     sqlstm.sqhstl[3] = (unsigned int  )13;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fm_date;
     sqlstm.sqhstl[4] = (unsigned int  )14;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
     sqlstm.sqhstl[5] = (unsigned int  )14;
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
         err_mesg("OPEN failed on cursor BL_SRV_INC_SUM_DTL_CUR",0,"");
  }
  else 
  {
     /* EXEC SQL OPEN BL_PKG_INC_SUM_DTL_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0006;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )208;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fm_bed_class;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_bed_class;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fm_blng_serv;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv;
     sqlstm.sqhstl[3] = (unsigned int  )13;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fm_date;
     sqlstm.sqhstl[4] = (unsigned int  )14;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
     sqlstm.sqhstl[5] = (unsigned int  )14;
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
         err_mesg("OPEN failed on cursor BL_PKG_INC_SUM_DTL_CUR",0,"");
  }
}

fetch_cur()
{
bl_bed_class_code.arr[0]                                          = '\0';
bl_blng_serv_code.arr[0]                                          = '\0';
bl_serv_date.arr[0]                                               = '\0';
bl_base_charge.arr[0]                                             = '\0';
bl_gross_charge.arr[0]                                            = '\0';
bl_disc_amt.arr[0]                                                = '\0';
bl_net_amt.arr[0]                                                 = '\0';

bl_bed_class_code.len                                             = 0;
bl_blng_serv_code.len                                             = 0;
bl_serv_date.len                                                  = 0;
bl_base_charge.len                                                = 0;
bl_gross_charge.len                                               = 0;
bl_disc_amt.len                                                   = 0;
bl_net_amt.len                                                    = 0;

bl_base_charge_db                                                 = 0;
bl_gross_charge_db                                                = 0;
bl_disc_amt_db                                                    = 0;
bl_net_amt_db                                                     = 0;

   if (nd_pkg_serv_flag.arr[0] == 'S')
   {
     /* EXEC SQL FETCH BL_SRV_INC_SUM_DTL_CUR
               INTO :bl_bed_class_code,
                    :bl_blng_serv_code,
                    :bl_serv_date,
                    :bl_base_charge,
                    :bl_gross_charge,
                    :bl_disc_amt,
                    :bl_net_amt,
                    :bl_base_charge_db,
                    :bl_gross_charge_db,
                    :bl_disc_amt_db,
                    :bl_net_amt_db; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )251;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_bed_class_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_blng_serv_code;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_serv_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_base_charge;
     sqlstm.sqhstl[3] = (unsigned int  )25;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_gross_charge;
     sqlstm.sqhstl[4] = (unsigned int  )25;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_disc_amt;
     sqlstm.sqhstl[5] = (unsigned int  )25;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_net_amt;
     sqlstm.sqhstl[6] = (unsigned int  )25;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_base_charge_db;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_gross_charge_db;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_disc_amt_db;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_net_amt_db;
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



   if (OERROR)
         err_mesg("FETCH failed on cursor BL_SRV_INC_SUM_DTL_CUR",0,"");

  }
  else
  {
     /* EXEC SQL FETCH BL_PKG_INC_SUM_DTL_CUR
               INTO :bl_bed_class_code,
                    :bl_blng_serv_code,
                    :bl_serv_date,
                    :bl_base_charge,
                    :bl_gross_charge,
                    :bl_disc_amt,
                    :bl_net_amt,
                    :bl_base_charge_db,
                    :bl_gross_charge_db,
                    :bl_disc_amt_db,
                    :bl_net_amt_db; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )310;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_bed_class_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_blng_serv_code;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_serv_date;
     sqlstm.sqhstl[2] = (unsigned int  )15;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_base_charge;
     sqlstm.sqhstl[3] = (unsigned int  )25;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_gross_charge;
     sqlstm.sqhstl[4] = (unsigned int  )25;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_disc_amt;
     sqlstm.sqhstl[5] = (unsigned int  )25;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_net_amt;
     sqlstm.sqhstl[6] = (unsigned int  )25;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_base_charge_db;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_gross_charge_db;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_disc_amt_db;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_net_amt_db;
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



   if (OERROR)
         err_mesg("FETCH failed on cursor BL_PKG_INC_SUM_DTL_CUR",0,"");

  }

bl_bed_class_code.arr[bl_bed_class_code.len]                             = '\0';
bl_blng_serv_code.arr[bl_blng_serv_code.len]                             = '\0';
bl_serv_date.arr[bl_serv_date.len]                                       = '\0';
bl_base_charge.arr[bl_base_charge.len]                                   = '\0';
bl_gross_charge.arr[bl_gross_charge.len]                                 = '\0';
bl_disc_amt.arr[bl_disc_amt.len]                                         = '\0';
bl_net_amt.arr[bl_net_amt.len]                                           = '\0';

    return(LAST_ROW?0:1);
}

fetch_bed_cls_desc()
{
    bl_bed_long_desc.arr[0]                                           = '\0';
    bl_bed_long_desc.len                                              = 0;

    /* EXEC SQL OPEN IP_BED_CLASS_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )369;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_bed_class_code;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor IP_BED_CLASS_CUR",0,"");

    /* EXEC SQL FETCH IP_BED_CLASS_CUR
              INTO :bl_bed_long_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )388;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_bed_long_desc;
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



   if (OERROR)
        err_mesg("FETCH failed on cursor BL_PACKAGE_HDR_CUR",0,"");

   bl_bed_long_desc.arr[bl_bed_long_desc.len] = '\0';

}

fetch_pkg_serv_desc()
{
    bl_blng_long_desc.arr[0]                                           = '\0';
    bl_blng_long_desc.len                                              = 0;

    if (nd_pkg_serv_flag.arr[0] == 'P')
    {
        /* EXEC SQL OPEN BL_PACKAGE_HDR_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 18;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0007;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )407;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqcmod = (unsigned int )0;
        sqlstm.sqhstv[0] = (         void  *)&bl_blng_serv_code;
        sqlstm.sqhstl[0] = (unsigned int  )13;
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
             err_mesg("OPEN failed on cursor BL_PACKAGE_HDR_CUR",0,"");
   
        /* EXEC SQL FETCH BL_PACKAGE_HDR_CUR
                  INTO :bl_blng_long_desc; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 18;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )426;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqfoff = (           int )0;
        sqlstm.sqfmod = (unsigned int )2;
        sqlstm.sqhstv[0] = (         void  *)&bl_blng_long_desc;
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
             err_mesg("FETCH failed on cursor BL_PACKAGE_HDR_CUR",0,"");
   }
   else 
   {
        /* EXEC SQL OPEN BL_BLNG_SERV_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 18;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0008;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )445;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqcmod = (unsigned int )0;
        sqlstm.sqhstv[0] = (         void  *)&bl_blng_serv_code;
        sqlstm.sqhstl[0] = (unsigned int  )13;
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
             err_mesg("OPEN failed on cursor BL_BLNG_SERV_CUR",0,"");
   
        /* EXEC SQL FETCH BL_BLNG_SERV_CUR
                  INTO :bl_blng_long_desc; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 18;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )464;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqfoff = (           int )0;
        sqlstm.sqfmod = (unsigned int )2;
        sqlstm.sqhstv[0] = (         void  *)&bl_blng_long_desc;
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
             err_mesg("FETCH failed on cursor BL_BLNG_SERV_CUR",0,"");
   }
   bl_blng_long_desc.arr[bl_blng_long_desc.len]                      = '\0';

}

print_rec(ind)
int ind;
{
  if (ind == 0)
  {
       fprintf(fp,"BED CLASS       : %-2s %-30s\n",
              bl_bed_class_code.arr,bl_bed_long_desc.arr);
       fflush(fp);
       lctr++;
  }
  else if (ind == 1)
  {
     if (lctr > 53)
        print_head(1);
      if (nd_pkg_serv_flag.arr[0] == 'S')
         fprintf(fp,"BILLING SERVICE : ");
      else
         fprintf(fp,"PACKAGE         : ");
      fprintf(fp,"%-10s %-30s\n\n",
             bl_blng_serv_code.arr,bl_blng_long_desc.arr);
      lctr+= 2;
       fflush(fp);
       lctr++;
  }
  else 
  {
      if (lctr > 53)
       print_head(1);
      fprintf(fp,"                            %-10s  ",
	  // %s %s %s %s\n",
               bl_serv_date.arr);

		print_formated(bl_base_charge_db,fp); fprintf(fp," ");
		print_formated(bl_gross_charge_db,fp);fprintf(fp," ");
        print_formated(bl_disc_amt_db,fp);fprintf(fp," ");
        print_formated(bl_net_amt_db,fp);
		fprintf(fp,"\n");
      lctr++;

      blng_tot_base_charge += bl_base_charge_db;
      blng_tot_gross_charge += bl_gross_charge_db;
      blng_tot_disc_amt += bl_disc_amt_db;
      blng_tot_net_amt += bl_net_amt_db;
  }
}

print_blng_serv_tot(l_flg)
int l_flg;
{
    if (lctr > 52)
       print_head(1);

    fprintf(fp,"\n");
    fprintf(fp,"                                        --------------  --------------  --------------  --------------\n");
    fprintf(fp,"               %s  ",
      (nd_pkg_serv_flag.arr[0] == 'S')?"BILLING SERVICE TOTAL :":
             "PACKAGE TOTAL         :");
    print_formated(blng_tot_base_charge,fp);fprintf(fp," ");
    print_formated(blng_tot_gross_charge,fp);fprintf(fp," ");
    print_formated(blng_tot_disc_amt,fp);fprintf(fp," ");
    print_formated(blng_tot_net_amt,fp);
    fprintf(fp,"\n");
    fprintf(fp,"                                        --------------  --------------  --------------  --------------\n");
    fflush(fp);
    lctr+=4;

       bed_tot_base_charge += blng_tot_base_charge;
       bed_tot_gross_charge += blng_tot_gross_charge;
       bed_tot_disc_amt += blng_tot_disc_amt;
       bed_tot_net_amt += blng_tot_net_amt;

       blng_tot_base_charge = 0;
       blng_tot_gross_charge = 0;
       blng_tot_disc_amt = 0;
       blng_tot_net_amt = 0;

       if (l_flg)
          print_rec(1);
}

print_bed_class_tot(l_flg)
int l_flg;
{
    print_blng_serv_tot(0);

    if (lctr > 52)
       print_head(1);

    fprintf(fp,"\n");
    fprintf(fp,"                                        --------------  --------------  --------------  --------------\n");
    fprintf(fp,"               %s  ",
                 "BED CLASS TOTAL       :");
    print_formated(bed_tot_base_charge,fp);fprintf(fp," ");
    print_formated(bed_tot_gross_charge,fp);fprintf(fp," ");
    print_formated(bed_tot_disc_amt,fp);fprintf(fp," ");
    print_formated(bed_tot_net_amt,fp);
    fprintf(fp,"\n");
    fprintf(fp,"                                        --------------  --------------  --------------  --------------\n");
    fflush(fp);
    lctr+=4;

    grn_tot_base_charge += bed_tot_base_charge;
    grn_tot_gross_charge += bed_tot_gross_charge;
    grn_tot_disc_amt += bed_tot_disc_amt;
    grn_tot_net_amt += bed_tot_net_amt;

    bed_tot_base_charge = 0;
    bed_tot_gross_charge = 0;
    bed_tot_disc_amt = 0;
    bed_tot_net_amt = 0;

    if (l_flg)
    {
       print_rec(0);
       print_rec(1);
    }
}

print_grand_tot()
{
    print_bed_class_tot(0);

    if (lctr > 52)
       print_head(0);

  fprintf(fp,"\n");
    fprintf(fp,"                                        --------------  --------------  --------------  --------------\n");
  fprintf(fp,"               %s  ",
                 "GRAND TOTAL           :");
  print_formated(grn_tot_base_charge,fp);fprintf(fp," ");
  print_formated(grn_tot_gross_charge,fp);fprintf(fp," ");
  print_formated(grn_tot_disc_amt,fp);fprintf(fp," ");
  print_formated(grn_tot_net_amt,fp);
  fprintf(fp,"\n");
    fprintf(fp,"                                        --------------  --------------  --------------  --------------\n");
fflush(fp);
}

end_of_rep()
{
fprintf(fp,"\n\n                                                      ***  END OF REPORT ***\n");
fflush(fp);
}

open_file()
{
  strcpy(filename,WORKING_DIR);
  strcat(filename,"blrbdind.lis");

  if ((fp = fopen(filename,"w")) == NULL)
  {
       disp_message(ERR_MESG,"Error in opening file : blrbdind.lis");
       proc_exit();
  }
  print_title();
  print_head(0);
}

print_title()
{
fprintf(fp,
"\fMDL : BL                                         %-30s                                        %-16s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %s                                PAGE : %4d\n",
"BLRBDIND",
 (nd_pkg_serv_flag.arr[0] == 'P')?
"       INCOME ANALYSIS BY BED CLASS - PACKAGES       ":
"       INCOME ANALYSIS BY BED CLASS - SERVICES       ", ++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"                  PACKAGE/SERVICE      : %s\n\n",nd_pkg_serv_flag.arr);
/*
fprintf(fp,"                  DAILY/MONTHLY REPORT : %s\n\n",nd_rep_flag.arr);
*/
fprintf(fp,"                  BED CLASS       FROM : %s\n",nd_fm_bed_class.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_to_bed_class.arr);
fprintf(fp,"                  PACKAGE/SERVICE FROM : %s\n",nd_fm_blng_serv.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_to_blng_serv.arr);
fprintf(fp,"                  DATE            FROM : %s\n",nd_fm_date_prn.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_to_date_prn.arr);
/*
fprintf(fp,"                  MONTH           FROM : %02d/%04d\n",
                    atoi(nd_fm_month.arr),atoi(nd_fm_year.arr));
fprintf(fp,"                                  TO   : %02d/%04d\n\n",
                    atoi(nd_to_month.arr),atoi(nd_to_year.arr));
*/

}

print_head(l_flg)
int l_flg;
{
fprintf(fp,
"\fMDL : BL                                         %-30s                                        %-16s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %s                                PAGE : %4d\n",
"BLRBDIND",
 (nd_pkg_serv_flag.arr[0] == 'P')?
"       INCOME ANALYSIS BY BED CLASS - PACKAGES       ":
"       INCOME ANALYSIS BY BED CLASS - SERVICES       ", ++pctr);
 fprintf(fp,"DAILY REPORT\n");
 fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------\n");
 fprintf(fp,"                            DATE           BASE CHARGE    GROSS CHARGE        DISC AMT      NET CHARGE\n");
 fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 8;
 if (l_flg)
 {
   print_rec(0);
   print_rec(1);  
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )483;
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
   //   ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
  //     ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
}
*/

print_formated(loc_amount,fp)
double loc_amount;
FILE *fp;
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
               // ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s ",str_amt);
        }
}