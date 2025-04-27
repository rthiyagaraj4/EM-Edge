
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
           char  filnam[37];
};
static const struct sqlcxp sqlfpn =
{
    36,
    "T:\\BL\\ver remov\\blr00083\\BLR00083.PC"
};


static unsigned long sqlctx = 1476866739;


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

 static const char *sq0004 = 
"select A.FACILITY_ID ,A.EPISODE_TYPE ,A.EPISODE_ID ,A.VISIT_ID ,A.PATIENT_I\
D ,NVL(B.NATIONALITY_CODE,'zzzz') ,B.LEGAL_YN ,DECODE(C.VISIT_TYPE_IND,'F','F\
','L')  from OP_VISIT A ,MP_PATIENT B ,OP_VISIT_TYPE C where (((((((A.FACILIT\
Y_ID=NVL(:b0,A.FACILITY_ID) and A.VISIT_REGN_DATE_TIME>=to_date(:b1,'dd/mm/yy\
yy hh24:mi:ss')) and A.VISIT_REGN_DATE_TIME<to_date(:b2,'dd/mm/yyyy hh24:mi:s\
s')) and NVL(A.VISIT_STATUS,'X')<>'9') and A.PATIENT_ID=B.PATIENT_ID) and A.V\
ISIT_TYPE_CODE=C.VISIT_TYPE_CODE) and NVL(A.EPISODE_TYPE,'O')=DECODE(:b3,'O',\
'O','E','E',NVL(A.EPISODE_TYPE,'O'))) and NVL(B.CITIZEN_YN,'N')=DECODE(:b4,'C\
','Y','N','N',NVL(B.CITIZEN_YN,'N'))) order by A.FACILITY_ID,NVL(B.NATIONALIT\
Y_CODE,'zzzz'),B.LEGAL_YN,DECODE(C.VISIT_TYPE_IND,'F','F','L')            ";

 static const char *sq0005 = 
"select A.FACILITY_ID ,A.EPISODE_TYPE ,A.EPISODE_ID ,A.PATIENT_ID ,NVL(B.NAT\
IONALITY_CODE,'zzzz') ,B.LEGAL_YN ,'F'  from IP_EPISODE A ,MP_PATIENT B where\
 ((((((A.FACILITY_ID=NVL(:b0,A.FACILITY_ID) and A.ADMISSION_DATE_TIME>=to_dat\
e(:b1,'dd/mm/yyyy hh24:mi:ss')) and A.ADMISSION_DATE_TIME<to_date(:b2,'dd/mm/\
yyyy hh24:mi:ss')) and A.PATIENT_ID=B.PATIENT_ID) and NVL(A.EPISODE_STATUS,'X\
')<>'9') and NVL(A.EPISODE_TYPE,'I')=DECODE(:b3,'I','I','D','D',NVL(A.EPISODE\
_TYPE,'I'))) and NVL(B.CITIZEN_YN,'N')=DECODE(:b4,'C','Y','N','N',NVL(B.CITIZ\
EN_YN,'N'))) order by A.FACILITY_ID,NVL(B.NATIONALITY_CODE,'zzzz'),B.LEGAL_YN\
            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,142,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,225,0,4,172,0,0,14,3,0,1,0,2,9,0,0,2,1,0,0,2,1,0,0,2,9,0,0,2,1,0,0,2,
1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
107,0,0,3,84,0,2,198,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
134,0,0,4,765,0,9,368,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
169,0,0,5,626,0,9,376,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
204,0,0,4,0,0,15,387,0,0,0,0,0,1,0,
219,0,0,5,0,0,15,395,0,0,0,0,0,1,0,
234,0,0,4,0,0,13,418,0,0,8,0,0,1,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,1,0,0,2,1,0,0,
281,0,0,5,0,0,13,436,0,0,7,0,0,1,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,
0,0,2,1,0,0,
324,0,0,6,418,0,4,603,0,0,9,8,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
375,0,0,7,397,0,4,623,0,0,8,7,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,
9,0,0,1,9,0,0,1,1,0,0,
422,0,0,8,375,0,4,662,0,0,9,8,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
473,0,0,9,354,0,4,681,0,0,8,7,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,
9,0,0,1,9,0,0,1,1,0,0,
520,0,0,10,373,0,4,719,0,0,9,8,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
571,0,0,11,352,0,4,738,0,0,8,7,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,
9,0,0,1,9,0,0,1,1,0,0,
618,0,0,12,450,0,4,776,0,0,9,8,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
669,0,0,13,429,0,4,796,0,0,8,7,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,
9,0,0,1,9,0,0,1,1,0,0,
716,0,0,14,66,0,4,875,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
739,0,0,15,188,0,4,905,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
778,0,0,16,0,0,32,922,0,0,0,0,0,1,0,
793,0,0,17,96,0,4,1159,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
816,0,0,18,162,0,6,1166,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00083.PC                                  */
/* AUTHOR                : Robert Joseph                                */  
/* DATE WRITTEN          : 07/06/2005                                   */      
/************************************************************************/
          
#include <stdio.h>         
#include <string.h> 
#include <bl.h>       
#include <math.h> 
   
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define NODATAFOUND			  sqlca.sqlcode == 1403
#define OERROR          (sqlca.sqlcode < 0)
#define MAX_LINES 42
//#define VER  "VER : 4.10\n"
#define ESC  0x1B
/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR     hosp_name                       [120],
			date							[20],
            date_time                       [20],
			d_acc_entity_name				[61],
			d_user							[31],
			d_head_name						[31],
			d_sysdate						[20],
			d_curr_date						[20],
			nd_facility_id					[3],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
            nd_facility				        [3],
			nd_period						[8],
			nd_fm_date						[21],
			nd_to_date						[21],
			nd_mth							[21],
			nd_year							[5],
			d_facility_id					[3],
			d_nationality_code				[5],
			d_nationality_desc				[16],
			d_visit_type_code				[3],
			d_episode_id					[13],
			d_visit_id						[7],
			d_patient_id					[21],
			prev_facility_id				[3],
			prev_nationality_code			[5],
			l_translated_value				[201],	
			l_pk_value						[100],
			p_language_id                    [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[61]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[31]; } d_head_name;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } d_curr_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[8]; } nd_period;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[21]; } nd_to_date;

struct { unsigned short len; unsigned char arr[21]; } nd_mth;

struct { unsigned short len; unsigned char arr[5]; } nd_year;

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

struct { unsigned short len; unsigned char arr[5]; } d_nationality_code;

struct { unsigned short len; unsigned char arr[16]; } d_nationality_desc;

struct { unsigned short len; unsigned char arr[3]; } d_visit_type_code;

struct { unsigned short len; unsigned char arr[13]; } d_episode_id;

struct { unsigned short len; unsigned char arr[7]; } d_visit_id;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[3]; } prev_facility_id;

struct { unsigned short len; unsigned char arr[5]; } prev_nationality_code;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


	char	nd_episode_type, nd_period_type, nd_blng_info_for,
			nd_category, nd_print_ded_yn, d_legal_yn, d_visit_type_ind,
			d_episode_type, prev_visit_type_ind, prev_legal_yn;

	int		i,sl_no=1,page_no=0, REP_WIDTH = 252,
			d_new_attend_cnt		= 0,
			d_fup_attend_cnt		= 0,
			d_tot_attend_cnt		= 0,
			net_new_attend_cnt		= 0,
			net_fup_attend_cnt		= 0,
			net_tot_attend_cnt		= 0;
	
	double	d_amt					= 0,
			d_new_deposit_amt		= 0,
			d_fup_deposit_amt		= 0,
			d_tot_deposit_amt		= 0,
			d_new_charged_amt		= 0,
			d_fup_charged_amt		= 0,
			d_tot_charged_amt		= 0,
			d_new_collected_amt		= 0,
			d_fup_collected_amt		= 0,
			d_tot_collected_amt		= 0,
			d_new_outst_amt			= 0,
			d_fup_outst_amt			= 0,
			d_tot_outst_amt			= 0,
			d_new_deduct_amt		= 0,
			d_fup_deduct_amt		= 0,
			d_tot_deduct_amt		= 0,
			net_tot_deduct_amt		= 0,
			net_new_deposit_amt		= 0,
			net_fup_deposit_amt		= 0,
			net_tot_deposit_amt		= 0,
			net_new_charged_amt		= 0,
			net_fup_charged_amt		= 0,
			net_tot_charged_amt		= 0,
			net_new_collected_amt	= 0,
			net_fup_collected_amt	= 0,
			net_tot_collected_amt	= 0,
			net_new_outst_amt		= 0,
			net_fup_outst_amt		= 0,
			net_tot_outst_amt		= 0;

	char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];

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

char string_var [100];

int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0, recctr = 1, ftime = 0, bgftime = 0;


FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }

	strcpy(g_pgm_id,"BLR00083");
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

    	strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);


	 strcpy(p_language_id.arr,l_language_id.arr);
	 p_language_id.len = l_language_id.len;


    /* EXEC SQL SELECT	PARAM1, PARAM2, PARAM3, PARAM4,
					PARAM5,	PARAM6, PARAM7, PARAM8,
					PARAM9, PARAM10, PARAM11	
			 INTO	:nd_facility_id, :nd_episode_type,
					:nd_period_type, :nd_period,
					:nd_blng_info_for, :nd_category,
					:nd_fm_date, :nd_to_date,
					:nd_mth, :nd_year, :nd_print_ded_yn
			 FROM	SY_PROG_PARAM
			 WHERE PGM_ID		= :d_curr_pgm_name
			 AND   SESSION_ID	= :nd_session_id
			 AND   PGM_DATE		= :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,P\
ARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,\
:b8,:b9,:b10  from SY_PROG_PARAM where ((PGM_ID=:b11 and SESSION_ID=:b12) and\
 PGM_DATE=:b13)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )1;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_period_type;
    sqlstm.sqhstl[2] = (unsigned int  )1;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_period;
    sqlstm.sqhstl[3] = (unsigned int  )10;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_blng_info_for;
    sqlstm.sqhstl[4] = (unsigned int  )1;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_category;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_mth;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_year;
    sqlstm.sqhstl[9] = (unsigned int  )7;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_print_ded_yn;
    sqlstm.sqhstl[10] = (unsigned int  )1;
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

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_facility_id.arr[nd_facility_id.len]	= '\0';
	nd_period.arr[nd_period.len]			= '\0';
	nd_fm_date.arr[nd_fm_date.len]			= '\0';
	nd_to_date.arr[nd_to_date.len]			= '\0';
	nd_mth.arr[nd_mth.len]					= '\0';
	nd_year.arr[nd_year.len]				= '\0';
         
   /* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSIO\
N_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )107;
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

	if (nd_print_ded_yn == 'Y')
		REP_WIDTH = 266;
   
    open_files();

    declare_cur();

	get_header_dtls();

	fetch_legend_value();
 
//	fprintf(fp,"%c&l1O",ESC);	/* Set Landscape*/ 
//	fprintf(fp, "%c(s17H", ESC);/* Reduce the font size*/
//	fprintf(fp,"%c&a4L",ESC); 	/* To Set the Left margin*/

 
	next_line(1);

	print_param();

	open_cur();

   ftime = 0;      

   while(fetch_cur())
   {	
   
       	print_rec();
   

   }

   
   
   if (ftime != 0)
   {
			if ((d_legal_yn == 'Y') && (ftime != 0))
			{
				fprintf(fp,"%15s %8d %8d %8d ",loc_legend[14], 
							d_new_attend_cnt, d_fup_attend_cnt, d_tot_attend_cnt);

				print_formated(d_new_deposit_amt);
				print_formated(d_fup_deposit_amt);
				print_formated(d_tot_deposit_amt);

				print_formated(d_new_charged_amt);
				print_formated(d_fup_charged_amt);
				print_formated(d_tot_charged_amt);

				print_formated(d_new_collected_amt);
				print_formated(d_fup_collected_amt);
				print_formated(d_tot_collected_amt);

				calc_outst_amt();

				print_formated(d_new_outst_amt);
				print_formated(d_fup_outst_amt);
				print_formated(d_tot_outst_amt);

				if (nd_print_ded_yn == 'Y')
				print_formated(d_tot_deduct_amt);
			}
			else if ((d_legal_yn != 'Y') && (ftime != 0))
			{
				fprintf(fp,"%15s %8d %8d %8d ",loc_legend[15], 
							d_new_attend_cnt, d_fup_attend_cnt, d_tot_attend_cnt);

				print_formated(d_new_deposit_amt);
				print_formated(d_fup_deposit_amt);
				print_formated(d_tot_deposit_amt);

				print_formated(d_new_charged_amt);
				print_formated(d_fup_charged_amt);
				print_formated(d_tot_charged_amt);

				print_formated(d_new_collected_amt);
				print_formated(d_fup_collected_amt);
				print_formated(d_tot_collected_amt);

				calc_outst_amt();

				print_formated(d_new_outst_amt);
				print_formated(d_fup_outst_amt);
				print_formated(d_tot_outst_amt);

				if (nd_print_ded_yn == 'Y')
				print_formated(d_tot_deduct_amt);
			}

		print_grand_tot();
   }	


    print_end();

	fprintf(fp,"%cE",ESC); /* To Reset the Printer */
 }

open_files()
{
	strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00083.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00083.lis");
       proc_exit();
    }

}

declare_cur()
{
	if ((nd_episode_type == 'O') || (nd_episode_type == 'E') ||
		(nd_episode_type == 'V'))
	{
	/* EXEC SQL DECLARE VISIT_CUR CURSOR FOR
	SELECT	A.FACILITY_ID, A.EPISODE_TYPE, A.EPISODE_ID, A.VISIT_ID, 
			A.PATIENT_ID, NVL(B.NATIONALITY_CODE,'zzzz'), B.LEGAL_YN,
			DECODE(C.VISIT_TYPE_IND,'F','F','L')
	FROM	OP_VISIT A, MP_PATIENT B, OP_VISIT_TYPE C
	WHERE	A.FACILITY_ID = NVL(:nd_facility_id,A.FACILITY_ID)
	AND	A.VISIT_REGN_DATE_TIME >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss')
	AND	A.VISIT_REGN_DATE_TIME < 	to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss')	
	AND	NVL(A.VISIT_STATUS,'X') != '9'
	AND	A.PATIENT_ID = B.PATIENT_ID
	AND	A.VISIT_TYPE_CODE = C.VISIT_TYPE_CODE	
	AND	NVL(A.EPISODE_TYPE,'O') = DECODE(:nd_episode_type,'O','O','E','E',NVL(A.EPISODE_TYPE,'O'))
	AND	NVL(B.CITIZEN_YN,'N') = DECODE(:nd_category,'C','Y','N','N',NVL(B.CITIZEN_YN,'N'))
	ORDER BY A.FACILITY_ID, NVL(B.NATIONALITY_CODE,'zzzz'), B.LEGAL_YN, DECODE(C.VISIT_TYPE_IND,'F','F','L'); */ 


	if (OERROR)
        err_mesg("DECLARE failed on cursor 7/22/2005",0,"");
	}

	if ((nd_episode_type == 'I') || (nd_episode_type == 'D') ||
		(nd_episode_type == 'A'))
	{
	/* EXEC SQL DECLARE ADM_CUR CURSOR FOR
	SELECT	A.FACILITY_ID, A.EPISODE_TYPE, A.EPISODE_ID,  
			A.PATIENT_ID, NVL(B.NATIONALITY_CODE,'zzzz'), B.LEGAL_YN, 'F'
	FROM	IP_EPISODE A, MP_PATIENT B
	WHERE	A.FACILITY_ID = NVL(:nd_facility_id,A.FACILITY_ID)
	AND	A.ADMISSION_DATE_TIME >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss')
	AND	A.ADMISSION_DATE_TIME < 	to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss')
	AND	A.PATIENT_ID = B.PATIENT_ID
	AND	NVL(A.EPISODE_STATUS,'X') != '9'
	AND	NVL(A.EPISODE_TYPE,'I') = DECODE(:nd_episode_type,'I','I','D','D',NVL(A.EPISODE_TYPE,'I'))
	AND	NVL(B.CITIZEN_YN,'N') = DECODE(:nd_category,'C','Y','N','N',NVL(B.CITIZEN_YN,'N'))
	ORDER BY A.FACILITY_ID, NVL(B.NATIONALITY_CODE,'zzzz'), B.LEGAL_YN; */ 


	if (OERROR)
        err_mesg("DECLARE failed on cursor ADM_CUR",0,"");
	}
	
}

open_cur()
{
	if ((nd_episode_type == 'O') || (nd_episode_type == 'E') ||
		(nd_episode_type == 'V'))
	{
		/* EXEC SQL OPEN VISIT_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0004;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )134;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[3] = (unsigned int  )1;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_category;
  sqlstm.sqhstl[4] = (unsigned int  )1;
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
        err_mesg("OPEN failed on cursor VISIT_CUR",0,"");
	}

	if ((nd_episode_type == 'I') || (nd_episode_type == 'D') ||
		(nd_episode_type == 'A'))
	{
		/* EXEC SQL OPEN ADM_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0005;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )169;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[3] = (unsigned int  )1;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_category;
  sqlstm.sqhstl[4] = (unsigned int  )1;
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
        err_mesg("OPEN failed on cursor ADM_CUR",0,"");
	}
}

close_cur()
{
	if ((nd_episode_type == 'O') || (nd_episode_type == 'E') ||
		(nd_episode_type == 'V'))
	{
		/* EXEC SQL CLOSE VISIT_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )204;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
        err_mesg("CLOSE failed on cursor VISIT_CUR",0,"");
	}

	if ((nd_episode_type == 'I') || (nd_episode_type == 'D') ||
		(nd_episode_type == 'A'))
	{
		/* EXEC SQL CLOSE ADM_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )219;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
        err_mesg("CLOSE failed on cursor ADM_CUR",0,"");
	}
}

fetch_cur()
{ 
	d_facility_id.arr[0]		= '\0';
	d_episode_id.arr[0]			= '\0';
	d_visit_id.arr[0]			= '\0';
	d_patient_id.arr[0]			= '\0';
	d_nationality_code.arr[0]	= '\0';

	d_facility_id.len			= 0;
	d_episode_id.len			= 0;
	d_visit_id.len				= 0;
	d_patient_id.len			= 0;
	d_nationality_code.len		= 0;
	
	if ((nd_episode_type == 'O') || (nd_episode_type == 'E') ||
		(nd_episode_type == 'V'))
	{
		/* EXEC SQL FETCH  VISIT_CUR INTO 
			:d_facility_id,
			:d_episode_type,
			:d_episode_id,
			:d_visit_id,
			:d_patient_id,
			:d_nationality_code,
			:d_legal_yn,
			:d_visit_type_ind; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )234;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_nationality_code;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_legal_yn;
  sqlstm.sqhstl[6] = (unsigned int  )1;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_visit_type_ind;
  sqlstm.sqhstl[7] = (unsigned int  )1;
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
		err_mesg("FETCH failed on cursor VISIT_CUR ",0,"");	 
	}

	if ((nd_episode_type == 'I') || (nd_episode_type == 'D') ||
		(nd_episode_type == 'A'))
	{
	
		/* EXEC SQL FETCH  ADM_CUR INTO 
			:d_facility_id,
			:d_episode_type,
			:d_episode_id,
			:d_patient_id,
			:d_nationality_code,
			:d_legal_yn,
			:d_visit_type_ind; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )281;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
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
  sqlstm.sqhstv[4] = (         void  *)&d_nationality_code;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_legal_yn;
  sqlstm.sqhstl[5] = (unsigned int  )1;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_visit_type_ind;
  sqlstm.sqhstl[6] = (unsigned int  )1;
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
		err_mesg("FETCH failed on cursor ADM_CUR ",0,"");	
	}

    d_facility_id.arr[d_facility_id.len]			= '\0';
	d_episode_id.arr[d_episode_id.len]				= '\0';
	d_visit_id.arr[d_visit_id.len]					= '\0';
	d_patient_id.arr[d_patient_id.len]				= '\0';
	d_nationality_code.arr[d_nationality_code.len]	= '\0';

	return(LAST_ROW?0:1);   
}

print_rec()
{
    check_line(1);

	if ((strcmp(d_nationality_code.arr, prev_nationality_code.arr) != 0) ||
		(strcmp(d_facility_id.arr, prev_facility_id.arr) != 0) ||
		(d_legal_yn != prev_legal_yn))
	{
		get_nationality();

		if ((strcmp(d_nationality_code.arr, prev_nationality_code.arr) != 0) ||
		(d_legal_yn != prev_legal_yn))
		{
			if ((prev_legal_yn == 'Y') && (ftime != 0))
			{
				fprintf(fp,"%15s %8d %8d %8d ",loc_legend[14], 
							d_new_attend_cnt, d_fup_attend_cnt, d_tot_attend_cnt);

				print_formated(d_new_deposit_amt);
				print_formated(d_fup_deposit_amt);
				print_formated(d_tot_deposit_amt);

				print_formated(d_new_charged_amt);
				print_formated(d_fup_charged_amt);
				print_formated(d_tot_charged_amt);

				print_formated(d_new_collected_amt);
				print_formated(d_fup_collected_amt);
				print_formated(d_tot_collected_amt);

				calc_outst_amt();

				print_formated(d_new_outst_amt);
				print_formated(d_fup_outst_amt);
				print_formated(d_tot_outst_amt);

				if (nd_print_ded_yn == 'Y')
				print_formated(d_tot_deduct_amt);

				next_line(1);
			}
			else if ((prev_legal_yn != 'Y') && (ftime != 0))
			{
				fprintf(fp,"%15s %8d %8d %8d ",loc_legend[15], 
							d_new_attend_cnt, d_fup_attend_cnt, d_tot_attend_cnt);

				print_formated(d_new_deposit_amt);
				print_formated(d_fup_deposit_amt);
				print_formated(d_tot_deposit_amt);

				print_formated(d_new_charged_amt);
				print_formated(d_fup_charged_amt);
				print_formated(d_tot_charged_amt);

				print_formated(d_new_collected_amt);
				print_formated(d_fup_collected_amt);
				print_formated(d_tot_collected_amt);

				calc_outst_amt();

				print_formated(d_new_outst_amt);
				print_formated(d_fup_outst_amt);
				print_formated(d_tot_outst_amt);

				if (nd_print_ded_yn == 'Y')
				print_formated(d_tot_deduct_amt);
				next_line(1);
			}

			if (strcmp(d_nationality_code.arr, prev_nationality_code.arr) != 0)
			{
				fprintf(fp,"%-15.15s ", d_nationality_desc.arr);
			}

			if ((strcmp(d_nationality_code.arr, prev_nationality_code.arr) == 0) && 
				(d_legal_yn != prev_legal_yn) && (ftime != 0))
			{
				fprintf(fp,"%15s "," ");
			}
		}
		
		strcpy(prev_facility_id.arr, d_facility_id.arr);
		prev_facility_id.len = strlen(d_facility_id.arr);
		prev_facility_id.arr[prev_facility_id.len] = '\0';

		strcpy(prev_nationality_code.arr, d_nationality_code.arr);
		prev_nationality_code.len = strlen(d_nationality_code.arr);
		prev_nationality_code.arr[prev_nationality_code.len] = '\0';

		prev_legal_yn = d_legal_yn;

		d_new_attend_cnt		= 0;
		d_fup_attend_cnt		= 0;
		d_tot_attend_cnt		= 0;

		d_new_deposit_amt		= 0;
		d_fup_deposit_amt		= 0;
		d_tot_deposit_amt		= 0;
		d_new_charged_amt		= 0;
		d_fup_charged_amt		= 0;
		d_tot_charged_amt		= 0;
		d_new_collected_amt		= 0;
		d_fup_collected_amt		= 0;
		d_tot_collected_amt		= 0;
		d_new_deduct_amt		= 0;
		d_fup_deduct_amt		= 0;
		d_tot_deduct_amt		= 0;
		d_new_outst_amt			= 0;
		d_fup_outst_amt			= 0;
		d_tot_outst_amt			= 0;

	}
	
	ftime = 1;
	if (d_visit_type_ind == 'F')
	{
		d_new_attend_cnt	+= 1;
		net_new_attend_cnt	+= 1;
	}
	else
	{
		d_fup_attend_cnt	+= 1;
		net_fup_attend_cnt	+= 1;
	}

	d_tot_attend_cnt	+= 1;
	net_tot_attend_cnt	+= 1;

    calc_deposit_amt();
	
	calc_charged_amt();
	
	calc_collected_amt();

	calc_ded_amt();

}

calc_deposit_amt()
{
	d_amt = 0;

	if ((nd_episode_type == 'O') || (nd_episode_type == 'E') ||
	(nd_episode_type == 'V'))
	{
		/* EXEC SQL SELECT	SUM(NVL(DEBIT_AMT,0)) into :d_amt
		FROM BL_PATIENT_STATEMENT_VW A
		WHERE	A.EPISODE_TYPE = DECODE(:nd_episode_type,'O','O','E','E',A.EPISODE_TYPE)
		AND		A.EPISODE_ID = :d_episode_id
		AND		A.VISIT_ID	= :d_visit_id
		AND		A.PATIENT_ID = :d_patient_id
		AND		((:nd_blng_info_for = 'P' 
				AND A.DOC_DATE >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss') 
				AND A.DOC_DATE <  to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss'))
				OR (:nd_blng_info_for = 'A'))
		AND		TRX_TYPE IN ('CANC-RECEIPT','RECEIPT')
		AND		TRX_NATURE_CODE in ('AD','PR'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(NVL(DEBIT_AMT,0)) into :b0  from BL_PATIENT_STA\
TEMENT_VW A where ((((((A.EPISODE_TYPE=DECODE(:b1,'O','O','E','E',A.EPISODE_T\
YPE) and A.EPISODE_ID=:b2) and A.VISIT_ID=:b3) and A.PATIENT_ID=:b4) and (((:\
b5='P' and A.DOC_DATE>=to_date(:b6,'dd/mm/yyyy hh24:mi:ss')) and A.DOC_DATE<t\
o_date(:b7,'dd/mm/yyyy hh24:mi:ss')) or :b5='A')) and TRX_TYPE in ('CANC-RECE\
IPT','RECEIPT')) and TRX_NATURE_CODE in ('AD','PR'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )324;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[5] = (unsigned int  )1;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[7] = (unsigned int  )23;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[8] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table BL_PATIENT_STATEMENT_VW",0,"");
	}

	if ((nd_episode_type == 'I') || (nd_episode_type == 'D') ||
		(nd_episode_type == 'A'))
	{
		/* EXEC SQL SELECT	SUM(NVL(DEBIT_AMT,0)) into :d_amt
		FROM BL_PATIENT_STATEMENT_VW A
		WHERE	A.EPISODE_TYPE = DECODE(:nd_episode_type,'I','I','D','D',A.EPISODE_TYPE)
		AND		A.EPISODE_ID = :d_episode_id
		AND		A.PATIENT_ID = :d_patient_id
		AND		((:nd_blng_info_for = 'P' 
				AND A.DOC_DATE >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss') 
				AND A.DOC_DATE <  to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss'))
				OR (:nd_blng_info_for = 'A'))
		AND		TRX_TYPE IN ('CANC-RECEIPT','RECEIPT')
		AND		TRX_NATURE_CODE in ('AD','PR'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(NVL(DEBIT_AMT,0)) into :b0  from BL_PATIENT_STA\
TEMENT_VW A where (((((A.EPISODE_TYPE=DECODE(:b1,'I','I','D','D',A.EPISODE_TY\
PE) and A.EPISODE_ID=:b2) and A.PATIENT_ID=:b3) and (((:b4='P' and A.DOC_DATE\
>=to_date(:b5,'dd/mm/yyyy hh24:mi:ss')) and A.DOC_DATE<to_date(:b6,'dd/mm/yyy\
y hh24:mi:ss')) or :b4='A')) and TRX_TYPE in ('CANC-RECEIPT','RECEIPT')) and \
TRX_NATURE_CODE in ('AD','PR'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )375;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[7] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table BL_PATIENT_STATEMENT_VW",0,"");
	}

	if (d_visit_type_ind == 'F')
	{
		d_new_deposit_amt	+= d_amt;
		net_new_deposit_amt	+= d_amt;
	}
	else
	{
		d_fup_deposit_amt	+= d_amt;
		net_fup_deposit_amt	+= d_amt;
	}

	d_tot_deposit_amt	+= d_amt;
	net_tot_deposit_amt += d_amt;
	
}

calc_charged_amt()
{
	d_amt = 0;

	if ((nd_episode_type == 'O') || (nd_episode_type == 'E') ||
	(nd_episode_type == 'V'))
	{
		/* EXEC SQL SELECT	SUM(NVL(DEBIT_AMT,0)) into :d_amt
		FROM	BL_PATIENT_STATEMENT_VW A
		WHERE	A.EPISODE_TYPE = DECODE(:nd_episode_type,'O','O','E','E',A.EPISODE_TYPE)
		AND		A.EPISODE_ID = :d_episode_id
		AND		A.VISIT_ID	= :d_visit_id
		AND		A.PATIENT_ID = :d_patient_id
		AND		((:nd_blng_info_for = 'P' 
				AND A.DOC_DATE >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss') 
				AND A.DOC_DATE <  to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss'))
				OR (:nd_blng_info_for = 'A'))
		AND		TRX_TYPE in ('BILL','CANC-BILL'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(NVL(DEBIT_AMT,0)) into :b0  from BL_PATIENT_STA\
TEMENT_VW A where (((((A.EPISODE_TYPE=DECODE(:b1,'O','O','E','E',A.EPISODE_TY\
PE) and A.EPISODE_ID=:b2) and A.VISIT_ID=:b3) and A.PATIENT_ID=:b4) and (((:b\
5='P' and A.DOC_DATE>=to_date(:b6,'dd/mm/yyyy hh24:mi:ss')) and A.DOC_DATE<to\
_date(:b7,'dd/mm/yyyy hh24:mi:ss')) or :b5='A')) and TRX_TYPE in ('BILL','CAN\
C-BILL'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )422;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[5] = (unsigned int  )1;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[7] = (unsigned int  )23;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[8] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table BL_PATIENT_STATEMENT_VW",0,"");
	}

	if ((nd_episode_type == 'I') || (nd_episode_type == 'D') ||
		(nd_episode_type == 'A'))
	{
		/* EXEC SQL SELECT	SUM(NVL(DEBIT_AMT,0)) into :d_amt
		FROM BL_PATIENT_STATEMENT_VW A
		WHERE	A.EPISODE_TYPE = DECODE(:nd_episode_type,'I','I','D','D',A.EPISODE_TYPE)
		AND		A.EPISODE_ID = :d_episode_id
		AND		A.PATIENT_ID = :d_patient_id
		AND		((:nd_blng_info_for = 'P' 
				AND A.DOC_DATE >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss') 
				AND A.DOC_DATE <  to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss'))
				OR (:nd_blng_info_for = 'A'))
		AND		TRX_TYPE in ('BILL','CANC-BILL'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(NVL(DEBIT_AMT,0)) into :b0  from BL_PATIENT_STA\
TEMENT_VW A where ((((A.EPISODE_TYPE=DECODE(:b1,'I','I','D','D',A.EPISODE_TYP\
E) and A.EPISODE_ID=:b2) and A.PATIENT_ID=:b3) and (((:b4='P' and A.DOC_DATE>\
=to_date(:b5,'dd/mm/yyyy hh24:mi:ss')) and A.DOC_DATE<to_date(:b6,'dd/mm/yyyy\
 hh24:mi:ss')) or :b4='A')) and TRX_TYPE in ('BILL','CANC-BILL'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )473;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[7] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table BL_PATIENT_STATEMENT_VW",0,"");
	}

	if (d_visit_type_ind == 'F')
	{
		d_new_charged_amt	+= d_amt;
		net_new_charged_amt	+= d_amt;
	}
	else
	{
		d_fup_charged_amt	+= d_amt;
		net_fup_charged_amt	+= d_amt;
	}

	d_tot_charged_amt	+= d_amt;
	net_tot_charged_amt += d_amt;
	
}

calc_collected_amt()
{
	d_amt = 0;

	if ((nd_episode_type == 'O') || (nd_episode_type == 'E') ||
	(nd_episode_type == 'V'))
	{
		/* EXEC SQL SELECT	SUM(NVL(DEBIT_AMT,0)) into :d_amt
		FROM	BL_PATIENT_STATEMENT_VW A
		WHERE	A.EPISODE_TYPE = DECODE(:nd_episode_type,'O','O','E','E',A.EPISODE_TYPE)
		AND		A.EPISODE_ID = :d_episode_id
		AND		A.VISIT_ID	= :d_visit_id
		AND		A.PATIENT_ID = :d_patient_id
		AND		((:nd_blng_info_for = 'P' 
				AND A.DOC_DATE >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss') 
				AND A.DOC_DATE <  to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss'))
				OR (:nd_blng_info_for = 'A'))
		AND		TRX_NATURE_CODE IN ('BI','DC'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(NVL(DEBIT_AMT,0)) into :b0  from BL_PATIENT_STA\
TEMENT_VW A where (((((A.EPISODE_TYPE=DECODE(:b1,'O','O','E','E',A.EPISODE_TY\
PE) and A.EPISODE_ID=:b2) and A.VISIT_ID=:b3) and A.PATIENT_ID=:b4) and (((:b\
5='P' and A.DOC_DATE>=to_date(:b6,'dd/mm/yyyy hh24:mi:ss')) and A.DOC_DATE<to\
_date(:b7,'dd/mm/yyyy hh24:mi:ss')) or :b5='A')) and TRX_NATURE_CODE in ('BI'\
,'DC'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )520;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[5] = (unsigned int  )1;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[7] = (unsigned int  )23;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[8] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table BL_PATIENT_STATEMENT_VW",0,"");
	}

	if ((nd_episode_type == 'I') || (nd_episode_type == 'D') ||
		(nd_episode_type == 'A'))
	{
		/* EXEC SQL SELECT	SUM(NVL(DEBIT_AMT,0)) into :d_amt
		FROM BL_PATIENT_STATEMENT_VW A
		WHERE	A.EPISODE_TYPE = DECODE(:nd_episode_type,'I','I','D','D',A.EPISODE_TYPE)
		AND		A.EPISODE_ID = :d_episode_id
		AND		A.PATIENT_ID = :d_patient_id
		AND		((:nd_blng_info_for = 'P' 
				AND A.DOC_DATE >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss') 
				AND A.DOC_DATE <  to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss'))
				OR (:nd_blng_info_for = 'A'))
		AND		TRX_NATURE_CODE IN ('BI','DC'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(NVL(DEBIT_AMT,0)) into :b0  from BL_PATIENT_STA\
TEMENT_VW A where ((((A.EPISODE_TYPE=DECODE(:b1,'I','I','D','D',A.EPISODE_TYP\
E) and A.EPISODE_ID=:b2) and A.PATIENT_ID=:b3) and (((:b4='P' and A.DOC_DATE>\
=to_date(:b5,'dd/mm/yyyy hh24:mi:ss')) and A.DOC_DATE<to_date(:b6,'dd/mm/yyyy\
 hh24:mi:ss')) or :b4='A')) and TRX_NATURE_CODE in ('BI','DC'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )571;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[7] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table BL_PATIENT_STATEMENT_VW",0,"");
	}

	if (d_visit_type_ind == 'F')
	{
		d_new_collected_amt	+= d_amt;
		net_new_collected_amt+= d_amt;
	}
	else
	{
		d_fup_collected_amt	+= d_amt;
		net_fup_collected_amt+= d_amt;
	}

	d_tot_collected_amt		+= d_amt;
	net_tot_collected_amt	+= d_amt;
	
}

calc_ded_amt()
{
	d_amt = 0;

	if ((nd_episode_type == 'O') || (nd_episode_type == 'E') ||
	(nd_episode_type == 'V'))
	{
		/* EXEC SQL SELECT	SUM(NVL(DEBIT_AMT,0)) into :d_amt
		FROM	BL_PATIENT_STATEMENT_VW A
		WHERE	A.EPISODE_TYPE = DECODE(:nd_episode_type,'O','O','E','E',A.EPISODE_TYPE)
		AND		A.EPISODE_ID = :d_episode_id
		AND		A.VISIT_ID	= :d_visit_id
		AND		A.PATIENT_ID = :d_patient_id
		AND		((:nd_blng_info_for = 'P' 
				AND A.DOC_DATE >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss') 
				AND A.DOC_DATE <  to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss'))
				OR (:nd_blng_info_for = 'A'))
		AND		TRX_TYPE in ('ADJ-BILL','CANC-ADJ-BILL','EXM-BILL','CANC-EXM-BILL',
					'WRITEOFF','CANC-WRITEOFF','DCP-ADJUST'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(NVL(DEBIT_AMT,0)) into :b0  from BL_PATIENT_STA\
TEMENT_VW A where (((((A.EPISODE_TYPE=DECODE(:b1,'O','O','E','E',A.EPISODE_TY\
PE) and A.EPISODE_ID=:b2) and A.VISIT_ID=:b3) and A.PATIENT_ID=:b4) and (((:b\
5='P' and A.DOC_DATE>=to_date(:b6,'dd/mm/yyyy hh24:mi:ss')) and A.DOC_DATE<to\
_date(:b7,'dd/mm/yyyy hh24:mi:ss')) or :b5='A')) and TRX_TYPE in ('ADJ-BILL',\
'CANC-ADJ-BILL','EXM-BILL','CANC-EXM-BILL','WRITEOFF','CANC-WRITEOFF','DCP-AD\
JUST'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )618;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[3] = (unsigned int  )9;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[5] = (unsigned int  )1;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[7] = (unsigned int  )23;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[8] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table BL_PATIENT_STATEMENT_VW",0,"");
	}

	if ((nd_episode_type == 'I') || (nd_episode_type == 'D') ||
		(nd_episode_type == 'A'))
	{
		/* EXEC SQL SELECT	SUM(NVL(DEBIT_AMT,0)) into :d_amt
		FROM BL_PATIENT_STATEMENT_VW A
		WHERE	A.EPISODE_TYPE = DECODE(:nd_episode_type,'I','I','D','D',A.EPISODE_TYPE)
		AND		A.EPISODE_ID = :d_episode_id
		AND		A.PATIENT_ID = :d_patient_id
		AND		((:nd_blng_info_for = 'P' 
				AND A.DOC_DATE >= to_date(:nd_fm_date,'dd/mm/yyyy hh24:mi:ss') 
				AND A.DOC_DATE <  to_date(:nd_to_date,'dd/mm/yyyy hh24:mi:ss'))
				OR (:nd_blng_info_for = 'A'))
		AND		TRX_TYPE in ('ADJ-BILL','CANC-ADJ-BILL','EXM-BILL','CANC-EXM-BILL',
					'WRITEOFF','CANC-WRITEOFF','DCP-ADJUST'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(NVL(DEBIT_AMT,0)) into :b0  from BL_PATIENT_STA\
TEMENT_VW A where ((((A.EPISODE_TYPE=DECODE(:b1,'I','I','D','D',A.EPISODE_TYP\
E) and A.EPISODE_ID=:b2) and A.PATIENT_ID=:b3) and (((:b4='P' and A.DOC_DATE>\
=to_date(:b5,'dd/mm/yyyy hh24:mi:ss')) and A.DOC_DATE<to_date(:b6,'dd/mm/yyyy\
 hh24:mi:ss')) or :b4='A')) and TRX_TYPE in ('ADJ-BILL','CANC-ADJ-BILL','EXM-\
BILL','CANC-EXM-BILL','WRITEOFF','CANC-WRITEOFF','DCP-ADJUST'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )669;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )15;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_blng_info_for;
  sqlstm.sqhstl[7] = (unsigned int  )1;
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
        err_mesg("SELECT failed on table BL_PATIENT_STATEMENT_VW",0,"");
	}

	if (d_visit_type_ind == 'F')
	{
		d_new_deduct_amt	+= d_amt;
	}
	else
	{
		d_fup_deduct_amt	+= d_amt;
	}

	d_tot_deduct_amt		+= d_amt;
	net_tot_deduct_amt		+= d_amt;
}

calc_outst_amt()
{
	d_new_outst_amt		+= d_new_charged_amt - d_new_collected_amt - d_new_deposit_amt - d_new_deduct_amt;
	net_new_outst_amt	+= d_new_outst_amt;

	d_fup_outst_amt		+= d_fup_charged_amt - d_fup_collected_amt - d_fup_deposit_amt - d_fup_deduct_amt;
	net_fup_outst_amt	+= d_fup_outst_amt;

	d_tot_outst_amt		+= d_new_outst_amt + d_fup_outst_amt;
	net_tot_outst_amt	+= d_new_outst_amt + d_fup_outst_amt;
}

print_grand_tot()
{
	check_line(4);
	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
	fprintf(fp,"%-31s %8d %8d %8d ","Total", net_new_attend_cnt, 
				net_fup_attend_cnt, net_tot_attend_cnt);

	print_formated(net_new_deposit_amt);
	print_formated(net_fup_deposit_amt);
	print_formated(net_tot_deposit_amt);

	print_formated(net_new_charged_amt);
	print_formated(net_fup_charged_amt);
	print_formated(net_tot_charged_amt);

	print_formated(net_new_collected_amt);
	print_formated(net_fup_collected_amt);
	print_formated(net_tot_collected_amt);

	print_formated(net_new_outst_amt);
	print_formated(net_fup_outst_amt);
	print_formated(net_tot_outst_amt);

	if (nd_print_ded_yn == 'Y')
	print_formated(net_tot_deduct_amt);

	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
}

get_nationality()
{
	d_nationality_desc.arr[0]	= '\0';
	d_nationality_desc.len		= 0;

	/* EXEC SQL SELECT SHORT_NAME INTO :d_nationality_desc
				FROM MP_COUNTRY
				WHERE COUNTRY_CODE = :d_nationality_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_NAME into :b0  from MP_COUNTRY where COUNTRY_C\
ODE=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )716;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_nationality_desc;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_nationality_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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



	if (LAST_ROW)
	{
		strcpy(d_nationality_desc.arr,"Others");
		d_nationality_desc.len = strlen(d_nationality_desc.arr);
	}

	if (OERROR)
		err_mesg("SELECT failed on table MP_COUNTRY ",0,"");

	d_nationality_desc.arr[d_nationality_desc.len]	= '\0';
}

get_header_dtls()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    d_acc_entity_name.arr[0] ='\0';
    d_curr_date.arr[0]   ='\0';
	d_user.arr[0] ='\0';
    d_sysdate.arr[0] ='\0';
	d_head_name.arr[0] ='\0';
    d_acc_entity_name.len =0;
    d_curr_date.len   =0;
	d_user.len =0;
    d_sysdate.len =0;
	d_head_name.len=0;

	/* EXEC SQL SELECT upper(ACC_ENTITY_NAME), /o description of the institution o/
				   USER, TO_CHAR(SYSDATE, 'DD/MM/YYYY'),TO_CHAR(SYSDATE, 'HH24:MI:SS'),HEAD_OF_COMPANY_NAME
             INTO :d_acc_entity_name,
				  :d_user, :d_sysdate,:d_curr_date,d_head_name
			 FROM SY_ACC_ENTITY
			 WHERE acc_entity_id = :nd_facility; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM\
/YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,HEAD_OF_COMPANY_NAME into :b0,:b1,:b2\
,:b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )739;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_user;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_curr_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_head_name;
 sqlstm.sqhstl[4] = (unsigned int  )33;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_facility;
 sqlstm.sqhstl[5] = (unsigned int  )5;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


    
	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';
	d_curr_date.arr[d_curr_date.len]			 = '\0';
	d_head_name.arr[d_head_name.len]			 = '\0';

   
	return;
	err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )778;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	proc_exit();
}


print_page_title()
{

	int hosp_nm_len,date1_len, rep_title_len = 10,v_title_len,v_title1_len, s1, s2,date_len,user_len,pgm_len,sub_title_len;
	char v_rep_title[200],v_as_on_date[12],v_sub_title[200],v_title[200],v_title1[200];
   
	fprintf(fp,"MDL : BL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	date1_len=d_sysdate.len;
	//horz_skip(s2-date1_len-strlen(loc_legend[3])-3);
	horz_skip(s2-date1_len-15-3);
	fprintf(fp,"%15.15s : %s", loc_legend[3],d_sysdate.arr);
    
	next_line(1);
	
	fprintf(fp,"OPR : %s", d_user.arr); 	
        user_len=strlen(d_user.arr);
	strcpy(v_rep_title,loc_legend[1]);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-user_len-6);
	fprintf(fp,"%s",loc_legend[1]);
   	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-28);
	fprintf(fp,"%15.15s : %10s",loc_legend[2],d_curr_date.arr);
	next_line(1);


	fprintf(fp,"REP : %s",d_curr_pgm_name.arr);
        pgm_len=strlen(d_curr_pgm_name.arr);
	
	sprintf(v_sub_title, loc_legend[5]); 
	//strcpy(v_sub_title,d_head_name.arr);

	sub_title_len = strlen(v_sub_title);
	s1 = (REP_WIDTH-sub_title_len)/2;
   	horz_skip(s1-pgm_len-6);
    fprintf(fp,"%s",v_sub_title);

        s2 = (REP_WIDTH-s1-sub_title_len);
	    horz_skip(s2-28);
		fprintf(fp,"%15.15s : %10d",loc_legend[4],++page_no);
	next_line(1);

  s1=0;
	s1 = (REP_WIDTH-strlen(loc_legend[6])-strlen(nd_period.arr))/2;
	horz_skip(s1);
	fprintf(fp,"%s: %-s",loc_legend[6], nd_period.arr);
	next_line(1);

    s1=0;
	s1 = (REP_WIDTH-strlen(loc_legend[8])-strlen(d_acc_entity_name.arr))/2;
	horz_skip(s1);
	fprintf(fp,"%s: %-s",loc_legend[8], d_acc_entity_name.arr);
	next_line(1);

	print_line('-',REP_WIDTH); next_line(1);
	lctr = 7;	
}

print_column_title()
{

  fprintf(fp, "%-31.31s  %18.18s         %40.40s        %40.40s         %40.40s         %40.40s    ",loc_legend[9],loc_legend[10],loc_legend[16],loc_legend[17],loc_legend[18], loc_legend[19]);

  if(nd_print_ded_yn == 'Y')
  fprintf(fp,"%15.15s",loc_legend[20]);

  next_line(1);

  fprintf(fp, "%-31.31s %8.8s %8.8s %8.8s%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s"," ",loc_legend[11],loc_legend[12],loc_legend[13],loc_legend[11],loc_legend[12],loc_legend[13],loc_legend[11],loc_legend[12],loc_legend[13],loc_legend[11],loc_legend[12],loc_legend[13],loc_legend[11],loc_legend[12],loc_legend[13]);
  next_line(1);

  print_line('-',REP_WIDTH);
  next_line(1);

  lctr += 3;

}

print_param()
{
  print_page_title();

 // fprintf(fp,"VER 4.1\n");
 
  fprintf(fp,"\n\n\n\n");
  fprintf(fp,"        ");
  fprintf(fp,"INPUT PARAMETERS :\n");
  fprintf(fp,"        ");
  fprintf(fp,"------------------\n\n");

  fprintf(fp,"                FACILITY		        : %s\n\n",nd_facility_id.arr);

  if (nd_episode_type == 'O')
  fprintf(fp,"                EPISODE TYPE			: OUTPATIENT\n\n");

  if (nd_episode_type == 'E')
  fprintf(fp,"                EPISODE TYPE			: EMERGENCY\n\n");

  if (nd_episode_type == 'V')
  fprintf(fp,"                EPISODE TYPE			: OUTPATIENT AND EMERGENCY\n\n");

  if (nd_episode_type == 'I')
  fprintf(fp,"                EPISODE TYPE			: INPATIENT\n\n");

  if (nd_episode_type == 'D')
  fprintf(fp,"                EPISODE TYPE			: DAYCARE\n\n");

  if (nd_episode_type == 'A')
  fprintf(fp,"                EPISODE TYPE			: INPATIENT AND DAYCARE\n\n");

/*
  if (nd_period_type == 'M')
  fprintf(fp,"                PERIOD TYPE			: MONTHLY\n\n");
  else
  fprintf(fp,"                PERIOD TYPE			: YEARLY\n\n");*/

  fprintf(fp,"                PERIOD				: %s\n\n",nd_period.arr);

  if (nd_blng_info_for == 'P')
  fprintf(fp,"                BLNG INFO FOR			: ATTENDANCE OR ADMISSION PERIOD\n\n");
  else
  fprintf(fp,"                BLNG INFO FOR			: ALL\n\n");

  if (nd_category == 'C')
  fprintf(fp,"                CATEGORY			: CITIZEN\n\n");
  if (nd_category == 'N')
  fprintf(fp,"                CATEGORY			: NON-CITIZEN\n\n");
  if (nd_category == 'B')
  fprintf(fp,"                CATEGORY			: BOTH\n\n");

  if (nd_print_ded_yn == 'Y')
  fprintf(fp,"                PRINT DEDUCTION			: YES\n\n");
  else
  fprintf(fp,"                PRINT DEDUCTION			: NO\n\n");

  next_page();
}


check_line(skip) /* will check for MAX LINE before printing totals */
int skip;
{
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
}

next_line(skip) /* will check for MAX LINE before printing totals */		
int skip;
{
	if ((lctr + skip) > MAX_LINES)
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; 
	}
}

next_page() /* will move the cursor to next page */
{
  
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	fprintf(fp,"\n");
	lctr=1;
	 
	print_page_title();
	print_column_title();  	
}

print_line(ch,n) /* this is to obtain required characters */
  char ch;
  int n;
{
	int i;
	for(i=0;i<n;i++)
	fprintf(fp,"%c",ch);  
}

horz_skip(num) /* this is to obtain required blank space */
int num;
{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
}

print_end()
{
  fprintf(fp,"\n\n");
  fprintf(fp,"%106s **   END  OF  REPORT   **"," ");
  //next_line(1);
  fflush(fp);
  fclose(fp);
}


print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14s  ",str_amt);
    }
}  

fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00083.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00083.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )793;
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
			blcommon.get_local_lang_desc(:nd_facility,
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
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM'\
 , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value\
 , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )816;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
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
