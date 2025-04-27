
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrunbrf.pc"
};


static unsigned int sqlctx = 1288468779;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {12,11};

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

 static const char *sq0007 = 
"YPE=:b5) and TRX_DATE<=TO_DATE((:b0||' 23:59'),'DD/MM/YYYY HH24:MI')) and A.\
PATIENT_ID between NVL(:b7,'!!!!!!!!!!') and NVL(:b8,'~~~~~~~~~~')) and NVL(TR\
X_FINALIZE_IND,'N')='Y') and ((NVL(PACKAGE_IND,'X')='S' or (NVL(PACKAGE_TRX_IN\
D,'X')='Y' and NVL(PACKAGE_IND,'X')='P')) or AVAILED_IND='Y')) and OPERATING_F\
ACILITY_ID=:b9) group by A.PATIENT_ID,EPISODE_TYPE,A.EPISODE_ID,DECODE(EPISODE\
_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')),A.PATIENT_ID order by \
A.PATIENT_ID,EPISODE_TYPE,A.EPISODE_ID,DECODE(EPISODE_TYPE,'I','    0','D','  \
  0',TO_CHAR(VISIT_ID,'9990'))            ";

 static const char *sq0008 = 
"and TRX_DATE<=TO_DATE((:b0||' 23:59'),'DD/MM/YYYY HH24:MI')) and patient_id \
not  in (select patient_id  from ip_open_episode where facility_id=:b7)) and P\
ATIENT_ID between NVL(:b8,'!!!!!!!!!!') and NVL(:b9,'~~~~~~~~~~')) and NVL(TRX\
_FINALIZE_IND,'N')='Y') and ((NVL(PACKAGE_IND,'X')='S' or (NVL(PACKAGE_TRX_IND\
,'X')='Y' and NVL(PACKAGE_IND,'X')='P')) or AVAILED_IND='Y')) and OPERATING_FA\
CILITY_ID=:b7) group by PATIENT_ID,EPISODE_TYPE,EPISODE_ID,DECODE(EPISODE_TYPE\
,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')) order by PATIENT_ID,EPISODE\
_TYPE,EPISODE_ID,DECODE(EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,\
'9990'))            ";

 static const char *sq0009 = 
"5) and TRX_DATE<=TO_DATE((:b0||' 23:59'),'DD/MM/YYYY HH24:MI')) and PATIENT_\
ID between NVL(:b7,'!!!!!!!!!!') and NVL(:b8,'~~~~~~~~~~')) and NVL(TRX_FINALI\
ZE_IND,'N')='Y') and (NVL(PACKAGE_IND,'X')='S' or (NVL(PACKAGE_TRX_IND,'X')='Y\
' and NVL(PACKAGE_IND,'X')='P'))) and OPERATING_FACILITY_ID=:b9) group by PATI\
ENT_ID,EPISODE_TYPE,EPISODE_ID,DECODE(EPISODE_TYPE,'I','0','D','0',TO_CHAR(VIS\
IT_ID,'9990')) order by PATIENT_ID,EPISODE_TYPE,EPISODE_ID,DECODE(EPISODE_TYPE\
,'I','0','D','0',TO_CHAR(VISIT_ID,'9990'))            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,118,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,154,0,0,0,0,0,1,0,
51,0,0,3,199,0,4,174,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
110,0,0,4,84,0,2,211,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,5,113,0,4,219,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
160,0,0,6,100,0,4,232,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
183,0,0,7,0,0,13,442,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
230,0,0,8,0,0,13,458,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
277,0,0,9,0,0,13,473,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
324,0,0,10,193,0,4,502,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
355,0,0,11,110,0,4,514,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
386,0,0,12,143,0,4,539,0,0,4,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
417,0,0,13,159,0,4,559,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
448,0,0,14,176,0,4,572,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
483,0,0,15,74,0,4,586,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
506,0,0,7,1610,0,9,605,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
561,0,0,8,1666,0,9,607,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
620,0,0,9,1544,0,9,609,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
675,0,0,16,158,0,4,862,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
710,0,0,17,96,0,4,904,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
733,0,0,18,165,0,6,911,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
764,0,0,19,140,0,6,932,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
791,0,0,20,140,0,6,989,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*
#define DEBUG     
*/
#define INIT_MESG "Report Generation In Progress"

#include <stdio.h>
#include <string.h>     
#include <gl.h> 
#include <bl.h>       

#define ESC 0x1B 

/* EXEC SQL BEGIN DECLARE SECTION; */ 

                                          
    /* VARCHAR uid_pwd[91],
		    d_session_id[16],     
		    d_pgm_date[14],
            rep_date[20],
            comp_name[50],
            oper_id[31],
			nd_temp_date[21],
			p_language_id[3],
			date_convert[21],
			date_convert1[21],
			nd_loc_date[21],
			nd_facility_id[3],
            d_curr_pgm_name[15],
            nd_episode_type[2],
			nd_episode_desc[20],
	        nd_disch_bill_stage[2],
            nd_inccur[2]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[31]; } oper_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[20]; } nd_episode_desc;

struct { unsigned short len; unsigned char arr[2]; } nd_disch_bill_stage;

struct { unsigned short len; unsigned char arr[2]; } nd_inccur;

            

    /* VARCHAR nd_fm_pat                   [21],
            nd_to_pat                   [21],
            nd_cutoff_dt                [11],

		    d_patient_id                [21],
		    d_pat_name                  [61],
			d_pat_name1                  [61],
		    d_blng_grp_id               [5],
		    d_episode_type              [2],
		    d_episode_id                [9],
		    d_inccur					[2],
		    d_visit_id                  [5],
			nd_inzero			        [2],
			nd_operating_facility_id    [3],
			nd_confirm                  [2],
			l_pk_value					[100],
		   l_translated_value	        [201]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd_fm_pat;

struct { unsigned short len; unsigned char arr[21]; } nd_to_pat;

struct { unsigned short len; unsigned char arr[11]; } nd_cutoff_dt;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_pat_name;

struct { unsigned short len; unsigned char arr[61]; } d_pat_name1;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[2]; } d_inccur;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[2]; } nd_inzero;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[2]; } nd_confirm;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;


    double  d_gross_amt,
			d_gross_n_amt,
		    d_disc_amt,
			d_disc_n_amt;



       char  filename[150];
char loc_legend[999][201];
	int i;	
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

#define REP_WIDTH 132
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+50];

char rep_title[50] = "UNBILLED TRANSACTIONS FOR PATIENTS";

FILE *f1;

int page_no,
    line_no,
    first_line,
    g_count;

char file_name[15];

double g_net_amt,
       g_tot_gross_amt,
	   g_tot_gross_n_amt,
       g_tot_disc_amt,
	   g_tot_disc_n_amt,
       g_tot_net_amt,
	   g_tot_net_n_amt;

long no_recs;
void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc < 5) {
        disp_message(ERR_MESG,"Usage BLRUNBRF userid/password session_id pgm_date facility_id");
        proc_exit();
    }

    strcpy(g_pgm_id,"BLRUNBRF");

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

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
        disp_message(ERR_MESG,"Unable to connect to oracle.");
        proc_exit();
    }

    set_meduser_role();
	 strcpy(p_language_id.arr,l_language_id.arr);
     p_language_id.len = l_language_id.len;
    fetch_prog_param();
    fetch_discharge_bill_stage();
    fetch_sys_info();



   strcpy(filename,WORKING_DIR);
   strcat(filename,"blrunbrf.lis");

    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file...BLRUNBRF.LIS");
	proc_exit();
    }

    page_no=1;
    line_no=1;
	fetch_legend_value();
    decl_curs();

    put_inp_parm();

    do_report();
    print_end_of_rep();

    fclose(f1);

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



    return;
}

fetch_prog_param()
{

    nd_fm_pat.arr[0]        = '\0';
    nd_to_pat.arr[0]        = '\0';
    nd_cutoff_dt.arr[0]     = '\0';
    nd_episode_type.arr[0]  = '\0';
	nd_episode_desc.arr[0]  = '\0';

    nd_fm_pat.len           = 0;
    nd_to_pat.len           = 0;
    nd_episode_type.len     = 0;
	nd_episode_desc.len     = 0;
    nd_cutoff_dt.len        = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,
				   PARAM2,
				   PARAM3,
				   PARAM4,
				   PARAM5,
				   PARAM6,
				   PARAM7
              INTO :nd_operating_facility_id,
				   :nd_fm_pat,
                   :nd_to_pat,
                   :nd_cutoff_dt,
                   :nd_episode_type,
                   :nd_inccur,
		   :nd_inzero,
		   :nd_confirm
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :d_session_id
               AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_\
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_pat;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_pat;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_cutoff_dt;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_inccur;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_inzero;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_confirm;
   sqlstm.sqhstl[7] = (unsigned int  )4;
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
   sqlstm.sqhstv[9] = (         void  *)&d_session_id;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[10] = (unsigned int  )16;
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

   if (NO_DATA_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

    nd_fm_pat.arr[nd_fm_pat.len]        = '\0';
    nd_to_pat.arr[nd_to_pat.len]        = '\0';
    nd_cutoff_dt.arr[nd_cutoff_dt.len]  = '\0';
    nd_episode_type.arr[nd_episode_type.len]  = '\0';
    nd_inccur.arr[nd_inccur.len]	    = '\0';
	nd_inzero.arr[nd_inzero.len]	    = '\0';
	nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';

    strcpy(g_facility_id, nd_operating_facility_id.arr);
	
   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :d_session_id
               AND PGM_DATE   = :d_pgm_date; */ 

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
   sqlstm.sqhstv[1] = (         void  *)&d_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )16;
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
   
/* EXEC SQL SELECT decode(:nd_episode_type,'O','Outpatient','I','Inpatient','D','Daycare','R','Referral','Emergency') 
     into  :nd_episode_desc from dual; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select decode(:b0,'O','Outpatient','I','Inpatient','D','Dayca\
re','R','Referral','Emergency') into :b1  from dual ";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )137;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
sqlstm.sqhstl[0] = (unsigned int  )4;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_episode_desc;
sqlstm.sqhstl[1] = (unsigned int  )22;
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



    nd_episode_desc.arr[nd_episode_desc.len]  = '\0';

}

fetch_discharge_bill_stage()
{
	
	nd_disch_bill_stage.arr[0] = '\0';
	nd_disch_bill_stage.len = 0;

	/* EXEC SQL select nvl(discharge_billing_stage,'1') into :nd_disch_bill_stage
	FROM bl_parameters 
	WHERE operating_facility_id = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select nvl(discharge_billing_stage,'1') into :b0  from bl_pa\
rameters where operating_facility_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )160;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_disch_bill_stage;
 sqlstm.sqhstl[0] = (unsigned int  )4;
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

		

	nd_disch_bill_stage.arr[nd_disch_bill_stage.len] = '\0';

	if (OERROR)
         err_mesg("SELECT failed on table BL_PARAMETERS",0,"");
	 
}

   


decl_curs()
{
//EPNH 30/10/2004 
if ( (strcmp(nd_episode_type.arr,"I") == 0 || strcmp(nd_episode_type.arr,"D") == 0 ) && (strcmp(nd_inccur.arr,"Y")== 0))
{  
    /* EXEC SQL DECLARE BL_PATIENT_CHARGES_CURI CURSOR FOR
             SELECT A.PATIENT_ID,
                    A.EPISODE_TYPE,
                    TO_CHAR(A.EPISODE_ID,'99999990'),
                    DECODE(A.EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')),                                         
			SUM(DECODE(CONFIRMED_YN,'Y',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_GROSS_CHARGE_AMT,
				DECODE(SIGN(trunc(BILL_DOC_DATE)-
				TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
				-1, 0,0,0,1,UPD_GROSS_CHARGE_AMT))),0)),
			SUM(DECODE(CONFIRMED_YN,'N',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_GROSS_CHARGE_AMT,
				DECODE(SIGN(trunc(BILL_DOC_DATE)-
				TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
				-1, 0,0,0,1,UPD_GROSS_CHARGE_AMT))),0)),
			SUM(DECODE(CONFIRMED_YN,'Y',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_DISC_AMT,
				DECODE(SIGN(trunc(BILL_DOC_DATE)-
				TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
				-1, 0,0,0,1,UPD_DISC_AMT))),0)),
			SUM(DECODE(CONFIRMED_YN,'N',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_DISC_AMT,
				DECODE(SIGN(trunc(BILL_DOC_DATE)-
				TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
				-1, 0,0,0,1,UPD_DISC_AMT))),0))				
               FROM BL_PATIENT_CHARGES_FOLIO A
               WHERE  ( BILL_DOC_TYPE_CODE IS NULL 
                        OR
                        ( BILL_DOC_TYPE_CODE IS NOT NULL
                          AND trunc(BILL_DOC_DATE)  > TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY') 
                        )
                     )
                 AND EPISODE_TYPE = :nd_episode_type                         
                 AND TRX_DATE <= TO_DATE(:nd_cutoff_dt ||' 23:59','DD/MM/YYYY HH24:MI')
                 AND A.PATIENT_ID  BETWEEN  
		                           NVL(:nd_fm_pat,'!!!!!!!!!!') AND
		                           NVL(:nd_to_pat,'~~~~~~~~~~')                 
                 AND NVL(TRX_FINALIZE_IND,'N') = 'Y'
                 AND ( NVL(PACKAGE_IND,'X')      = 'S' OR
	               ( NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND 
	                 NVL(PACKAGE_IND,'X')      = 'P'
                       ) OR
			         AVAILED_IND = 'Y'
                     )
		 AND OPERATING_FACILITY_ID = :nd_operating_facility_id			
		       GROUP BY A.PATIENT_ID,EPISODE_TYPE,A.EPISODE_ID,
                       DECODE(EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')),A.PATIENT_ID
               ORDER BY A.PATIENT_ID,EPISODE_TYPE,A.EPISODE_ID,
                       DECODE(EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')); */ 



    if(OERROR)
	err_mesg("SELECT failed on cursor BL_PATIENT_CHARGES_CURI",0,"");
} //EPNH 30/10/2004
else if ( ( strcmp(nd_episode_type.arr,"I") == 0 || strcmp(nd_episode_type.arr,"D") == 0 ) && (strcmp(nd_inccur.arr,"N")== 0))
{                         
    /* EXEC SQL DECLARE BL_PATIENT_CHARGES_CURIC CURSOR FOR
             SELECT  PATIENT_ID,
                     EPISODE_TYPE,
                     TO_CHAR(EPISODE_ID,'99999990'),
                     DECODE(EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')),                      
                     SUM(DECODE(CONFIRMED_YN,'Y',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_GROSS_CHARGE_AMT,
						 DECODE(SIGN(trunc(BILL_DOC_DATE)-
						 TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
						 -1, 0,0,0,1,UPD_GROSS_CHARGE_AMT))),0)),
                     SUM(DECODE(CONFIRMED_YN,'N',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_GROSS_CHARGE_AMT,
						 DECODE(SIGN(trunc(BILL_DOC_DATE)-
						 TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
						 -1, 0,0,0,1,UPD_GROSS_CHARGE_AMT))),0)),
                     SUM(DECODE(CONFIRMED_YN,'Y',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_DISC_AMT,
						 DECODE(SIGN(trunc(BILL_DOC_DATE)-
						 TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
						 -1, 0,0,0,1,UPD_DISC_AMT))),0)),
                     SUM(DECODE(CONFIRMED_YN,'N',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_DISC_AMT,
						 DECODE(SIGN(trunc(BILL_DOC_DATE)-
						 TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
						 -1, 0,0,0,1,UPD_DISC_AMT))),0)) 
               FROM BL_PATIENT_CHARGES_FOLIO
               WHERE 
                     ( BILL_DOC_TYPE_CODE IS NULL 
                        OR
                        ( BILL_DOC_TYPE_CODE IS NOT NULL
                          AND trunc(BILL_DOC_DATE)  > TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY') 
                        ) )
                      AND EPISODE_TYPE = :nd_episode_type  
                      AND TRX_DATE <= TO_DATE(:nd_cutoff_dt ||' 23:59','DD/MM/YYYY HH24:MI')
                  AND (
			(patient_id not in (select patient_id from ip_open_episode
			 where facility_id = :nd_operating_facility_id)
		         //and nvl(:nd_disch_bill_stage,'1') = '1' for 20061
				 				 ) 
			 //or for 20061
			//(patient_id not in ( select patient_id from bl_episode_fin_dtls for 20061
			//where operating_facility_id = :nd_operating_facility_id and for 20061
			//episode_type in ('I','D') and nvl(discharge_bill_gen_ind,'N') = 'N') for 20061
			//and nvl(:nd_disch_bill_stage,'1') = '2') for 20061 for 20061
			)
                 AND PATIENT_ID  BETWEEN  
		       NVL(:nd_fm_pat,'!!!!!!!!!!') AND
		       NVL(:nd_to_pat,'~~~~~~~~~~')
                 AND NVL(TRX_FINALIZE_IND,'N') = 'Y'
                 AND ( NVL(PACKAGE_IND,'X')      = 'S' OR
	               ( NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND 
	                 NVL(PACKAGE_IND,'X')      = 'P'
                       ) OR
			         AVAILED_IND = 'Y'
                     )
		AND OPERATING_FACILITY_ID = :nd_operating_facility_id
               GROUP BY PATIENT_ID,EPISODE_TYPE,EPISODE_ID,
                        DECODE(EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990'))
               ORDER BY PATIENT_ID,EPISODE_TYPE,EPISODE_ID,
                        DECODE(EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')); */ 




    if(OERROR)
		err_mesg("SELECT failed on cursor BL_PATIENT_CHARGES_CURIC",0,""); 

}
else
{   

    /* EXEC SQL DECLARE BL_PATIENT_CHARGES_CUR CURSOR FOR
             SELECT  PATIENT_ID,
                     EPISODE_TYPE,
                     TO_CHAR(EPISODE_ID,'99999990'),
                     DECODE(EPISODE_TYPE,'I','0','D','0',TO_CHAR(VISIT_ID,'9990')),                      
                     SUM(DECODE(CONFIRMED_YN,'Y',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_GROSS_CHARGE_AMT,
						 DECODE(SIGN(trunc(BILL_DOC_DATE)-
						 TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
						  -1, 0,0,0,1,UPD_GROSS_CHARGE_AMT))),0)) GROSS_Y_AMT,
                     SUM(DECODE(CONFIRMED_YN,'N',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_GROSS_CHARGE_AMT,
						 DECODE(SIGN(trunc(BILL_DOC_DATE)-
						 TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
						  -1, 0,0,0,1,UPD_GROSS_CHARGE_AMT))),0)),
                     SUM(DECODE(CONFIRMED_YN,'Y',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_DISC_AMT,
						 DECODE(SIGN(trunc(BILL_DOC_DATE)-
					     TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
						 -1, 0,0,0,1,UPD_DISC_AMT))),0)),
                     SUM(DECODE(CONFIRMED_YN,'N',(DECODE(BILL_DOC_TYPE_CODE,NULL,UPD_DISC_AMT,
						 DECODE(SIGN(trunc(BILL_DOC_DATE)-
					     TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY')),
						 -1, 0,0,0,1,UPD_DISC_AMT))),0)) 
                FROM BL_PATIENT_CHARGES_FOLIO
               WHERE (  BILL_DOC_TYPE_CODE IS NULL 
                        OR
                        ( BILL_DOC_TYPE_CODE IS NOT NULL
                          AND trunc(BILL_DOC_DATE)  > TO_DATE(:nd_cutoff_dt,'DD/MM/YYYY') 
                        )
                      )  
                 AND EPISODE_TYPE = :nd_episode_type                         
                 AND TRX_DATE <= TO_DATE(:nd_cutoff_dt ||' 23:59','DD/MM/YYYY HH24:MI')
                 AND PATIENT_ID  BETWEEN  
		       NVL(:nd_fm_pat,'!!!!!!!!!!') AND
		       NVL(:nd_to_pat,'~~~~~~~~~~')
                 AND NVL(TRX_FINALIZE_IND,'N') = 'Y'
                 AND ( NVL(PACKAGE_IND,'X')      = 'S' OR
	               ( NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND 
	                 NVL(PACKAGE_IND,'X')      = 'P'
                       )
                     )
			AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		               GROUP BY PATIENT_ID,EPISODE_TYPE,EPISODE_ID,
                        DECODE(EPISODE_TYPE,'I','0','D','0',TO_CHAR(VISIT_ID,'9990'))
               ORDER BY PATIENT_ID,EPISODE_TYPE,EPISODE_ID,
                        DECODE(EPISODE_TYPE,'I','0','D','0',TO_CHAR(VISIT_ID,'9990')); */ 

    if(OERROR)
	err_mesg("SELECT failed on cursor BL_PATIENT_CHARGES_CUR",0,"");
                        
}

}

fetch_data()
{
    d_patient_id.arr[0]   = '\0';
    d_patient_id.len      = 0;

    d_episode_type.arr[0] = '\0';
    d_episode_type.len    = 0;
    
//	d_inccur.arr[0]	  = '\0';
//	d_inccur.len      = 0;

    d_episode_id.arr[0]   = '\0';
    d_episode_id.len      = 0;
    
    d_visit_id.arr[0]     = '\0';
    d_visit_id.len        = 0;
		    
    d_gross_amt   = 0;
    d_disc_amt    = 0;

if (( strcmp(nd_episode_type.arr,"I") == 0 || strcmp(nd_episode_type.arr,"D") == 0  ) && (strcmp(nd_inccur.arr,"Y")== 0))
{
    /* EXEC SQL FETCH BL_PATIENT_CHARGES_CURI
	      INTO :d_patient_id,
	           :d_episode_type, 
	           :d_episode_id,
	           :d_visit_id,
		       :d_gross_amt,
		       :d_gross_n_amt,
		       :d_disc_amt,
		       :d_disc_n_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )183;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
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
    sqlstm.sqhstv[5] = (         void  *)&d_gross_n_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_disc_n_amt;
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


    if(OERROR)
	err_mesg("FETCH failed on cursor BL_PATIENT_CHARGES_CURI",0,"");	


}		       
else if (( strcmp(nd_episode_type.arr,"I") == 0 || strcmp(nd_episode_type.arr,"D") == 0 ) && (strcmp(nd_inccur.arr,"N")== 0))
{
    /* EXEC SQL FETCH BL_PATIENT_CHARGES_CURIC
	      INTO :d_patient_id,
	           :d_episode_type, 
	           :d_episode_id,
	           :d_visit_id,
		   :d_gross_amt,
		   :d_gross_n_amt,
		   :d_disc_amt,
		    :d_disc_n_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )230;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
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
    sqlstm.sqhstv[5] = (         void  *)&d_gross_n_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_disc_n_amt;
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


		       
    if(OERROR)
	err_mesg("FETCH failed on cursor BL_PATIENT_CHARGES_CURIC",0,"");
}	
else
{	
    /* EXEC SQL FETCH BL_PATIENT_CHARGES_CUR
	      INTO :d_patient_id,
	           :d_episode_type, 
	           :d_episode_id,
	           :d_visit_id,
		       :d_gross_amt,
			   :d_gross_n_amt,
		       :d_disc_amt,
			   :d_disc_n_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )277;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
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
    sqlstm.sqhstv[5] = (         void  *)&d_gross_n_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_disc_n_amt;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_PATIENT_CHARGES_CUR",0,"");
}
    if(NO_DATA_FOUND)
	return 0;

    d_patient_id.arr[d_patient_id.len]     = '\0';
    d_episode_type.arr[d_episode_type.len] = '\0';
    d_episode_id.arr[d_episode_id.len]     = '\0';
    d_visit_id.arr[d_visit_id.len]         = '\0';
//    d_inccur.arr[d_inccur.len]		   = '\0';    

    if (( strcmp(nd_episode_type.arr,"I") == 0 || strcmp(nd_episode_type.arr,"D") == 0 ) && (strcmp(nd_inccur.arr,"Y")== 0))
    {
	d_inccur.arr[0] = '\0';
	d_inccur.len = 0;

	if (strcmp(nd_disch_bill_stage.arr,"2") == 0)
	{
	   /* EXEC SQL select 'Y' into :d_inccur
	   from bl_episode_fin_dtls 
	   where operating_facility_id = :nd_operating_facility_id 
	   and episode_type in ('I','D') and nvl(discharge_bill_gen_ind,'N') = 'N'
	   and patient_id = :d_patient_id 
	   and episode_id = :d_episode_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select 'Y' into :b0  from bl_episode_fin_dtls where ((((o\
perating_facility_id=:b1 and episode_type in ('I','D')) and nvl(discharge_bill\
_gen_ind,'N')='N') and patient_id=:b2) and episode_id=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )324;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_inccur;
    sqlstm.sqhstl[0] = (unsigned int  )4;
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
    sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[3] = (unsigned int  )11;
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

	   

	   d_inccur.arr[d_inccur.len] = '\0';		 
	}

	else
	{
	   /* EXEC SQL select 'Y' into :d_inccur
	   from ip_open_episode 
	   where facility_id = :nd_operating_facility_id 		
	   and patient_id = :d_patient_id 
	   and open_episode_id = :d_episode_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select 'Y' into :b0  from ip_open_episode where ((facilit\
y_id=:b1 and patient_id=:b2) and open_episode_id=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )355;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_inccur;
    sqlstm.sqhstl[0] = (unsigned int  )4;
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
    sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[3] = (unsigned int  )11;
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



	   d_inccur.arr[d_inccur.len] = '\0';		 
	}

    }

	return 1;

}

get_pat_name()
{
        d_pat_name.arr[0]   = '\0';
	d_pat_name1.arr[0]  = '\0';
	d_pat_name.len		= 0;
	d_pat_name1.len		= 0;


    /*EXEC SQL SELECT substr(SHORT_NAME,1,20),
	                decode(substr(short_name,21,60),NULL,' ',substr(short_name,21,60)) shortname2 */
	  /* EXEC SQL SELECT 
	                null,
					decode(:p_language_id,'en', substr(short_name,1,60),substr(SHORT_NAME_LOC_LANG,1,60))
			 INTO   :d_pat_name,
			        :d_pat_name1
			 FROM   MP_PATIENT_MAST
	         WHERE  PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select null  ,decode(:b0,'en',substr(short_name,1,60),subs\
tr(SHORT_NAME_LOC_LANG,1,60)) into :b1,:b2  from MP_PATIENT_MAST where PATIENT\
_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )386;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&p_language_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pat_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_pat_name1;
   sqlstm.sqhstl[2] = (unsigned int  )63;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )23;
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



    if(OERROR)
	err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

    d_pat_name.arr[d_pat_name.len]   = '\0';
	d_pat_name1.arr[d_pat_name1.len]   = '\0';

}
  
get_blng_grp()
{
    if ( strcmp(d_episode_type.arr,"I") == 0 || strcmp(d_episode_type.arr,"D") == 0 )
    {
	/* EXEC SQL SELECT blng_grp_id INTO :d_blng_grp_id
	FROM bl_episode_fin_dtls
	WHERE operating_facility_id = :nd_operating_facility_id
	AND episode_type in ('I','D')
	AND patient_id = :d_patient_id
	AND episode_id = :d_episode_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select blng_grp_id into :b0  from bl_episode_fin_dtls where \
(((operating_facility_id=:b1 and episode_type in ('I','D')) and patient_id=:b2\
) and episode_id=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )417;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
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
 sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )11;
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



	if(OERROR)
	err_mesg("SELECT failed on table BL_EPISODE_FIN_DTLS",0,"");
	d_blng_grp_id.arr[d_blng_grp_id.len]  = '\0';
    }
    else if ( strcmp(d_episode_type.arr,"O") == 0 || strcmp(d_episode_type.arr,"E") == 0 )
    {
	/* EXEC SQL SELECT blng_grp_id INTO :d_blng_grp_id
	FROM bl_visit_fin_dtls
	WHERE operating_facility_id = :nd_operating_facility_id
	AND episode_type in ('O','E') 
	AND patient_id = :d_patient_id
	AND episode_id = :d_episode_id
	AND visit_id = :d_visit_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select blng_grp_id into :b0  from bl_visit_fin_dtls where ((\
((operating_facility_id=:b1 and episode_type in ('O','E')) and patient_id=:b2)\
 and episode_id=:b3) and visit_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )448;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
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
 sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_visit_id;
 sqlstm.sqhstl[4] = (unsigned int  )7;
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
	err_mesg("SELECT failed on table BL_VISIT_FIN_DTLS",0,"");
	d_blng_grp_id.arr[d_blng_grp_id.len]  = '\0';
    }
    else
    {	
	/* EXEC SQL SELECT BLNG_GRP_ID
	INTO :d_blng_grp_id
	FROM BL_PATIENT_FIN_DTLS
	WHERE PATIENT_ID = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select BLNG_GRP_ID into :b0  from BL_PATIENT_FIN_DTLS where \
PATIENT_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )483;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
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
}

  
do_report()
{
    char s_gross_amt[20], s_gross_n_amt[20],s_disc_amt[20],s_disc_n_amt[20],s_net_amt[20],s_net_n_amt[20];

    put_hdr();
    
if (( strcmp(nd_episode_type.arr,"I") == 0 || strcmp(nd_episode_type.arr,"D") == 0 ) && (strcmp(nd_inccur.arr,"Y")== 0))    
    /* EXEC SQL OPEN BL_PATIENT_CHARGES_CURI; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select A.PATIENT_ID ,A.EPISODE_TYPE ,TO_CHAR(A.EPISODE_ID,'99999990')\
 ,DECODE(A.EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')) ,s\
um(DECODE(CONFIRMED_YN,'Y',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_GROSS_CHARGE_\
AMT,DECODE(SIGN((trunc(BILL_DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0\
,1,UPD_GROSS_CHARGE_AMT)),0)) ,sum(DECODE(CONFIRMED_YN,'N',DECODE(BILL_DOC_T\
YPE_CODE,null ,UPD_GROSS_CHARGE_AMT,DECODE(SIGN((trunc(BILL_DOC_DATE)-TO_DAT\
E(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_GROSS_CHARGE_AMT)),0)) ,sum(DECODE(CO\
NFIRMED_YN,'Y',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_DISC_AMT,DECODE(SIGN((tru\
nc(BILL_DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_DISC_AMT)),0)\
) ,sum(DECODE(CONFIRMED_YN,'N',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_DISC_AMT,\
DECODE(SIGN((trunc(BILL_DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,U\
PD_DISC_AMT)),0))  from BL_PATIENT_CHARGES_FOLIO A where (((((((BILL_DOC_TYP\
E_CODE is null  or (BILL_DOC_TYPE_CODE is  not null  and trunc(BILL_DOC_DATE\
)>TO_DATE(:b0,'DD/MM/YYYY'))) and EPISODE_T");
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )506;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fm_pat;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_pat;
    sqlstm.sqhstl[8] = (unsigned int  )23;
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


else if (( strcmp(nd_episode_type.arr,"I") == 0 || strcmp(nd_episode_type.arr,"D") == 0 ) && (strcmp(nd_inccur.arr,"N")== 0))    
    /* EXEC SQL OPEN BL_PATIENT_CHARGES_CURIC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select PATIENT_ID ,EPISODE_TYPE ,TO_CHAR(EPISODE_ID,'99999990') ,DECO\
DE(EPISODE_TYPE,'I','    0','D','    0',TO_CHAR(VISIT_ID,'9990')) ,sum(DECOD\
E(CONFIRMED_YN,'Y',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_GROSS_CHARGE_AMT,DECO\
DE(SIGN((trunc(BILL_DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_G\
ROSS_CHARGE_AMT)),0)) ,sum(DECODE(CONFIRMED_YN,'N',DECODE(BILL_DOC_TYPE_CODE\
,null ,UPD_GROSS_CHARGE_AMT,DECODE(SIGN((trunc(BILL_DOC_DATE)-TO_DATE(:b0,'D\
D/MM/YYYY'))),(-1),0,0,0,1,UPD_GROSS_CHARGE_AMT)),0)) ,sum(DECODE(CONFIRMED_\
YN,'Y',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_DISC_AMT,DECODE(SIGN((trunc(BILL_\
DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_DISC_AMT)),0)) ,sum(D\
ECODE(CONFIRMED_YN,'N',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_DISC_AMT,DECODE(S\
IGN((trunc(BILL_DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_DISC_\
AMT)),0))  from BL_PATIENT_CHARGES_FOLIO where ((((((((BILL_DOC_TYPE_CODE is\
 null  or (BILL_DOC_TYPE_CODE is  not null  and trunc(BILL_DOC_DATE)>TO_DATE\
(:b0,'DD/MM/YYYY'))) and EPISODE_TYPE=:b5) ");
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )561;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[6] = (unsigned int  )13;
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
    sqlstm.sqhstv[8] = (         void  *)&nd_fm_pat;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_pat;
    sqlstm.sqhstl[9] = (unsigned int  )23;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[10] = (unsigned int  )5;
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


else
    /* EXEC SQL OPEN BL_PATIENT_CHARGES_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select PATIENT_ID ,EPISODE_TYPE ,TO_CHAR(EPISODE_ID,'99999990') ,DECO\
DE(EPISODE_TYPE,'I','0','D','0',TO_CHAR(VISIT_ID,'9990')) ,sum(DECODE(CONFIR\
MED_YN,'Y',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_GROSS_CHARGE_AMT,DECODE(SIGN(\
(trunc(BILL_DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_GROSS_CHA\
RGE_AMT)),0)) GROSS_Y_AMT ,sum(DECODE(CONFIRMED_YN,'N',DECODE(BILL_DOC_TYPE_\
CODE,null ,UPD_GROSS_CHARGE_AMT,DECODE(SIGN((trunc(BILL_DOC_DATE)-TO_DATE(:b\
0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_GROSS_CHARGE_AMT)),0)) ,sum(DECODE(CONFIR\
MED_YN,'Y',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_DISC_AMT,DECODE(SIGN((trunc(B\
ILL_DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_DISC_AMT)),0)) ,s\
um(DECODE(CONFIRMED_YN,'N',DECODE(BILL_DOC_TYPE_CODE,null ,UPD_DISC_AMT,DECO\
DE(SIGN((trunc(BILL_DOC_DATE)-TO_DATE(:b0,'DD/MM/YYYY'))),(-1),0,0,0,1,UPD_D\
ISC_AMT)),0))  from BL_PATIENT_CHARGES_FOLIO where (((((((BILL_DOC_TYPE_CODE\
 is null  or (BILL_DOC_TYPE_CODE is  not null  and trunc(BILL_DOC_DATE)>TO_D\
ATE(:b0,'DD/MM/YYYY'))) and EPISODE_TYPE=:b");
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )620;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_cutoff_dt;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fm_pat;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_pat;
    sqlstm.sqhstl[8] = (unsigned int  )23;
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

    
    
    if(OERROR)
	err_mesg("OPEN failed on cursor BL_PATIENT_CHARGES_CUR",0,"");

    g_tot_gross_amt   = 0;
    g_tot_disc_amt    = 0;
    g_tot_net_amt     = 0;
	g_tot_gross_n_amt = 0;
	g_tot_disc_n_amt  = 0;
	g_tot_net_n_amt   = 0;

    no_recs = 0;

    while(fetch_data()) {
// the following statement prevent from printing the zero trx VSK 28/06/2000
//    if (d_gross_amt ==0)
//	   continue;

	if (strcmp(nd_inzero.arr,"N") == 0)
	    { if (d_gross_amt ==0  &&  d_gross_n_amt ==0)
  	        continue;
		} 
      
         
	   get_pat_name();
	   get_blng_grp();
	   chk_break(1);

	  print_formated(s_gross_amt, d_gross_amt);
	  print_formated(s_gross_n_amt, d_gross_n_amt);
	  //format_amt(s_gross_amt);
	  print_formated(s_disc_amt,  d_disc_amt);
	  print_formated(s_disc_n_amt, d_disc_n_amt);
	  //format_amt(s_disc_amt);
	  print_formated(s_net_amt,   d_gross_amt-d_disc_amt);
	  print_formated(s_net_n_amt, d_gross_n_amt-d_disc_n_amt);
	  //format_amt(s_net_amt);

	  fprintf(f1,"%-20.20s %-20.20s %-1s/%-8s/%-4s  %-4s%14.14s %14.14s %14.14s %14.14s %14.14s %14.14s %-1s\n",
		d_patient_id.arr,
		d_pat_name.arr,
		d_episode_type.arr,
		d_episode_id.arr,
		d_visit_id.arr,
		d_blng_grp_id.arr,
		s_gross_amt,
		s_gross_n_amt,
		s_disc_amt,
		s_disc_n_amt,
		s_net_amt,
		s_net_n_amt,
		d_inccur.arr);  

        if(strlen(d_pat_name1.arr) > 2)
	   {
		fprintf(f1,"%20s %s \n"," ",d_pat_name1.arr);
		line_no++;
	   }
	    line_no ++;
    	no_recs ++;

        g_tot_gross_amt   += d_gross_amt;
		g_tot_gross_n_amt += d_gross_n_amt;
        g_tot_disc_amt    += d_disc_amt;
		g_tot_disc_n_amt  += d_disc_n_amt;
        g_tot_net_amt     += (d_gross_amt-d_disc_amt);
		g_tot_net_n_amt   += (d_gross_n_amt-d_disc_n_amt);

    }

    if(no_recs)
	 print_tot();
}

print_tot()
{
    char s_gross_amt[20],s_gross_n_amt[20], s_disc_amt[20],s_disc_n_amt[20], s_net_amt[20],s_net_n_amt[20];
    chk_break(3);

    print_formated(s_gross_amt, g_tot_gross_amt);
	print_formated(s_gross_n_amt, g_tot_gross_n_amt);
    print_formated(s_disc_amt,  g_tot_disc_amt);
	print_formated(s_disc_n_amt, g_tot_disc_n_amt);
    print_formated(s_net_amt,   g_tot_gross_amt-g_tot_disc_amt);
	print_formated(s_net_n_amt, g_tot_gross_n_amt-g_tot_disc_n_amt);

    fprintf(f1,"%64s------------------------------------------------------------------------------------------\n","");
    

    fprintf(f1,"%63s%15.15s %15.15s %14.14s %14.14s %14.14s %14.14s\n","", s_gross_amt, s_gross_n_amt, s_disc_amt, s_disc_n_amt, s_net_amt, s_net_n_amt);
    fprintf(f1,"%64s==========================================================================================\n","");
    line_no += 3;

    chk_break(2);
    fprintf(f1,"\n%30s : %ld\n",loc_legend[28], no_recs);
    line_no += 2;

}

chk_break(nol)
int nol;
{

	if(line_no+nol >= 39) //55
	{
           line_no = 1;
	   g_count = 1;
	   put_hdr();
	}

}

put_inp_parm()
{

form_hdr();
fprintf(f1,"%5s : 4.1\n",loc_legend[180]);
fprintf(f1,"\n\n\n\n        %-22.22s :\n        ----------------------\n\n",loc_legend[100]);
fprintf(f1,"                  %-20.20s                 : %s\n\n",loc_legend[8],nd_episode_desc.arr);
if(nd_fm_pat.arr[0] == '\0')
fprintf(f1,"                  %-20.20s      %10.10s : %-10.10s\n",loc_legend[9],loc_legend[6],loc_legend[110]);
else
fprintf(f1,"                  %-20.20s      %10.10s : %s\n",loc_legend[9],loc_legend[6],nd_fm_pat.arr);
if(nd_to_pat.arr[0] == '\0')
fprintf(f1,"                                              %8.8s : %-12.12s\n\n",loc_legend[7],loc_legend[120]);
else
fprintf(f1,"                                              %8.8s : %s\n\n",loc_legend[7],nd_to_pat.arr);
if (strcmp(nd_episode_type.arr,"I") == 0)
{
fprintf(f1,"                  %-30.30s       : %s\n\n",loc_legend[10],nd_inccur.arr);
}

if (strcmp(nd_episode_type.arr,"D") == 0)
{
fprintf(f1,"                  %-30.30s       : %s\n\n",loc_legend[11],nd_inccur.arr);
}



fprintf(f1,"                  %-25.25s            : %s\n\n",loc_legend[12],nd_inzero.arr);

init_date_temp_var();                              //pradeep
strcpy(date_convert1.arr,nd_cutoff_dt.arr);            // pradeep
fun_change_loc_date(); 
fprintf(f1,"                  %-20.20s                 : %s\n",loc_legend[13], date_convert1.arr);

}

print_end_of_rep()
{
    int col;
    char buff[REP_WIDTH+1];

//    memset(buff,' ',REP_WIDTH+1);
//    col = (int)(REP_WIDTH-19)/2;

//    strncpy(buff+col,"** END OF REPORT **",19);
    fprintf(f1,"\n%69s** %-10s ** \n","",loc_legend[130]);
}



   
//    fprintf(f1,"Patient Id Patient Name                   BG           Gross       Discount            Net\n");
//    fprintf(f1,"Patient Id           Patient Name           EPISODE   VISIT BG            Gross                         Discount                        Net             Current\n");
//    fprintf(f1,"                                          TYPE/  ID   / ID        Confirmed     Unconfirmed     Confirmed     Unconfirmed     Confirmed     Unconfirmed  I/P\n");

put_hdr()
{
 form_hdr();
    fprintf(f1,"%-20.20s %-20.20s %-9.9s    %-11.11s         %-10.10s                   %-15.15s           %10.10s     %13.13s\n",loc_legend[14],loc_legend[16],loc_legend[17],loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22]);
    fprintf(f1,"                                      %13.13s    %5.5s      %12.12s %14.14s   %12.12s %14.14s   %12.12s %14.14s  %-6.6s\n",loc_legend[23],loc_legend[24],loc_legend[25],loc_legend[26],loc_legend[25],loc_legend[26],loc_legend[25],loc_legend[26],loc_legend[27]);

/*
Patient Id Patient Name                   GP           Gross       Discount            Net
xxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xx  999,999,999.99 999,999,999.99 999,999,999.99
*/

    fprintf(f1,"%s\n",
"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
/*    fprintf(f1,"%s\n",hdr_line4);*/
    fprintf(f1,"\n");
    line_no=9;

}

form_hdr()
{

    static int first = 1;
    char buf[15];
    int col;

    fprintf(f1,"%c&l1O",ESC);   /* To Print Landscape           */
	fprintf(f1,"%c&a4L",ESC); 	/* To Set the Left margin  		*/
    fprintf(f1,"%c(s16H",ESC); 	/* To set the font size			*/


    if(first) {
     /*   memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
	memset(hdr_line4,'-',REP_WIDTH+40);*/
    memset(hdr_line4,'-',170);
	hdr_line4[REP_WIDTH] = '\0';

        /*strncpy(hdr_line1,"MDL : BL",8);			
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));
        col = (REP_WIDTH-strlen(rep_date.arr));
		strcpy(hdr_line1+col,date_convert.arr);
		strcpy(hdr_line1,date_convert.arr);
		  strcpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);*/
		
		
		init_date_temp_var1();                              //pradeep
		strcpy(date_convert.arr,rep_date.arr);            // pradeep
	    fun_change_loc_date1();     
    }

    memset(hdr_line3,' ',REP_WIDTH+1);
    /*strncpy(hdr_line3,"REP : BLRUNBRF",14);
    col = (int)(REP_WIDTH-strlen(rep_title))/2;
    //strncpy(hdr_line3+col,rep_title,strlen(rep_title));
	 strncpy(hdr_line3+col,loc_legend[5],strlen(loc_legend[5]));
    sprintf(buf,"%-8.8s : %4d",loc_legend[3],page_no++);
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);*/

     
	 if(first)  
  	{  
        fprintf(f1,"%6.6s : %-5.5s%45s%-30s%55s%s\n",loc_legend[140],loc_legend[150],"",comp_name.arr,"",date_convert.arr); //prad
		 }  
     else  
	 {
	    fprintf(f1,"\f");
		
        fprintf(f1,"%6.6s : %-5.5s%45s%-30s%52s%s\n",loc_legend[140],loc_legend[150],"",comp_name.arr,"",date_convert.arr); 
      }
        fprintf(f1,"%6.6s : %-12s\n",loc_legend[160],oper_id.arr);
        fprintf(f1,"%6.6s : %-12.12s%34s%-43s%47s%8.8s :%4d\n",loc_legend[170],loc_legend[4],"",loc_legend[5],"",loc_legend[3],page_no++);
    /*fprintf(f1,"%s\n",hdr_line4);*/
	    fprintf(f1,"%s\n",
"---------------------------------------------------------------------------------------------------------------------------------------------------------------");


    first = 0;
}

fetch_sys_info()
{

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
                    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
		     INTO   :comp_name,
				    :rep_date,
				    :oper_id
		     FROM   SY_ACC_ENTITY_LANG_VW
			 WHERE  ACC_ENTITY_ID = :nd_operating_facility_id
			 and language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )675;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )52;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&oper_id;
    sqlstm.sqhstl[2] = (unsigned int  )33;
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



    if(OERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';
}


print_formated(s_amt, l_amt)
double l_amt;
char *s_amt;
{

    if(l_amt < 0){
        put_val(s_amt,-l_amt);
        format_amt(s_amt);
        strcat(s_amt,"-");
    }
    else {
        put_val(s_amt,l_amt);
        format_amt(s_amt);
        strcat(s_amt," ");
    }
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRUNBRF.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRUNBRF.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )710;
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
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )733;
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

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  
       //	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   //:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	   :nd_loc_date :=sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )764;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
date_convert1.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert1.len = 0;
}


fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert1.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();

strcpy(date_convert1.arr,nd_loc_date.arr); 

}


get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  
       //	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   //:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	   :nd_loc_date :=sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )791;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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

                     
init_date_temp_var1()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
date_convert.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
}


fun_change_loc_date1()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}








