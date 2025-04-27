
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
    "C:\\10xdev\\blrinswo.PC"
};


static unsigned long sqlctx = 139599331;


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

 static const char *sq0006 = 
"')='N' and (((:b6='P' and WO_APPROVED_YN is null ) or (:b6='A' and WO_APPROV\
ED_YN='Y')) or (:b6='R' and WO_APPROVED_YN='N'))) or (:b6='C' and nvl(A.cancel\
led_yn,'N')='Y'))) and ((((:b6='P' and nvl(req_reason_code,'!!!!') between nvl\
(:b11,'!!!!') and nvl(:b12,'~~~~')) and TRUNC(a.WO_PROCESS_DATE) between to_da\
te(:b13,'dd/mm/yyyy') and to_date(:b14,'dd/mm/yyyy')) or ((:b6 in ('A','R') an\
d nvl(APPR_REJN_REASON_CODE,'!!!!') between nvl(:b11,'!!!!') and nvl(:b12,'~~~\
~')) and TRUNC(a.WO_APPR_REJN_DATE) between to_date(:b13,'dd/mm/yyyy') and to_\
date(:b14,'dd/mm/yyyy'))) or ((:b6 in ('C') and nvl(b.REASON_CODE,'!!!!') betw\
een nvl(:b11,'!!!!') and nvl(:b12,'~~~~')) and TRUNC(b.CANCELLED_DATE) between\
 to_date(:b13,'dd/mm/yyyy') and to_date(:b14,'dd/mm/yyyy'))))           ";

 static const char *sq0007 = 
"select A.reminder_no ,to_char(A.reminder_dispatched_date,'DD/MM/YYYY') ,A.re\
minder_disp_doc_type ,A.reminder_disp_doc_number ,A.reminder_disp_doc_slno ,nv\
l(A.reminder_not_delivered_yn,'N')  from bl_inst_pmnt_for_reminder A ,BL_CREDI\
T_AGREEMENT B where ((((((A.operating_facility_id=:b0 and A.operating_facility\
_id=B.operating_facility_id) and A.aggr_doc_type_code=B.aggr_doc_type_code) an\
d A.aggr_doc_num=B.aggr_doc_num) and NVL(B.CANCELLED_YN,'N')='N') and A.aggr_d\
oc_type_code=:b1) and A.aggr_doc_num=:b2)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,133,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,206,0,4,189,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
95,0,0,3,84,0,2,219,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
122,0,0,4,73,0,4,227,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
145,0,0,5,0,0,30,252,0,0,0,0,0,1,0,
160,0,0,6,1796,0,9,336,0,0,25,25,0,1,0,1,9,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
275,0,0,6,0,0,15,344,0,0,0,0,0,1,0,
290,0,0,7,518,0,9,351,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
317,0,0,7,0,0,15,359,0,0,0,0,0,1,0,
332,0,0,7,0,0,13,380,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,
371,0,0,6,0,0,13,434,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
426,0,0,8,185,0,4,1052,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,
465,0,0,9,395,0,4,1097,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
528,0,0,10,222,0,4,1155,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,
571,0,0,11,100,0,4,1188,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
594,0,0,12,72,0,4,1205,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
617,0,0,13,96,0,4,1272,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
640,0,0,14,162,0,6,1279,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
671,0,0,15,207,0,6,1303,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00099.PC                                  */
/* AUTHOR                : Jagwinder Kaur                               */  
/* DATE WRITTEN          : 28/07/2004                                   */      
/************************************************************************/
          

#include <stdio.h>         
#include <string.h> 
#include <bl.h>       
#include <math.h> 
//#include <winproc.h>

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define NODATAFOUND sqlca.sqlcode == 1403
/*
#define DEBUG 0
*/
#define ESC 0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hosp_name                       [120],
			date							[20],
            date_time                       [20],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility				        [3],
			bl_reminder_no					[8],
			bl_reminder_dispatched_date		[11],
			bl_reminder_disp_doc_type		[7],
			bl_reminder_disp_doc_number		[9],
			bl_reminder_disp_doc_slno		[4],
			bl_reminder_not_delivered_yn	[2],
			bl_org_doc_type_code			[7],
			nd_appr_ref[35],
			bl_org_doc_num					[9],			
			bl_org_doc_no					[16],
			bl_org_doc_date					[11],
			bl_patient_id					[21],
			old_patient_id					[21],
			bl_episode_type					[2],
			bl_patient_name					[31],
			bl_reason_code					[5],
			bl_reason_desc					[116],
	    		nd_fm_date						[11],
			nd_to_date						[11],
			nd_fm_reason_code				[5],
			nd_to_reason_code				[5],
			nd_blng_grp_catg				[5],
			bl_blng_catg_desc				[30],
			nd_nationality					[2],
			nd_national_id_num				[21],
			nd_ln1_add						[31],
			nd_ln2_add						[31],
			nd_ln3_add						[31],
			nd_ln4_add						[31],
			nd_citizen						[2],
			nd_postal_code					[9],
		//	nd_fr_wo_amt					[15],
		//	nd_to_wo_amt					[15],
			old_reason_code					[5],
			l_translated_value				[201],
			l_cash_book_acc_desc			[16],
			l_pk_value						[100],
			nd_wo_status                    [2],
			bl_canc_reason_code             [5],
			bl_reln_code					[13],
			bl_currency						[3],	
      		bl_wo_foot_note_line01_text		[150],
	 		bl_wo_foot_note_line02_text		[150],
	 		bl_wo_foot_note_line03_text		[150],
	 		bl_wo_foot_note_line04_text		[150],
			bl_wo_foot_note_line05_text		[150],
	 		bl_wo_foot_note_line06_text		[150],
	 		bl_wo_foot_note_line07_text		[150],
	 		bl_wo_foot_note_line08_text		[150],
 	    	bl_wo_foot_note_line09_text		[150],
	 		bl_wo_foot_note_line10_text		[150],
			p_language_id					[3],
			nd_temp_date[21],
			
			date_convert[21],
		
			nd_loc_date[21]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[8]; } bl_reminder_no;

struct { unsigned short len; unsigned char arr[11]; } bl_reminder_dispatched_date;

struct { unsigned short len; unsigned char arr[7]; } bl_reminder_disp_doc_type;

struct { unsigned short len; unsigned char arr[9]; } bl_reminder_disp_doc_number;

struct { unsigned short len; unsigned char arr[4]; } bl_reminder_disp_doc_slno;

struct { unsigned short len; unsigned char arr[2]; } bl_reminder_not_delivered_yn;

struct { unsigned short len; unsigned char arr[7]; } bl_org_doc_type_code;

struct { unsigned short len; unsigned char arr[35]; } nd_appr_ref;

struct { unsigned short len; unsigned char arr[9]; } bl_org_doc_num;

struct { unsigned short len; unsigned char arr[16]; } bl_org_doc_no;

struct { unsigned short len; unsigned char arr[11]; } bl_org_doc_date;

struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[21]; } old_patient_id;

struct { unsigned short len; unsigned char arr[2]; } bl_episode_type;

struct { unsigned short len; unsigned char arr[31]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[5]; } bl_reason_code;

struct { unsigned short len; unsigned char arr[116]; } bl_reason_desc;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_reason_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_reason_code;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_catg;

struct { unsigned short len; unsigned char arr[30]; } bl_blng_catg_desc;

struct { unsigned short len; unsigned char arr[2]; } nd_nationality;

struct { unsigned short len; unsigned char arr[21]; } nd_national_id_num;

struct { unsigned short len; unsigned char arr[31]; } nd_ln1_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln2_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln3_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln4_add;

struct { unsigned short len; unsigned char arr[2]; } nd_citizen;

struct { unsigned short len; unsigned char arr[9]; } nd_postal_code;

struct { unsigned short len; unsigned char arr[5]; } old_reason_code;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[16]; } l_cash_book_acc_desc;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[2]; } nd_wo_status;

struct { unsigned short len; unsigned char arr[5]; } bl_canc_reason_code;

struct { unsigned short len; unsigned char arr[13]; } bl_reln_code;

struct { unsigned short len; unsigned char arr[3]; } bl_currency;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line01_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line02_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line03_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line04_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line05_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line06_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line07_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line08_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line09_text;

struct { unsigned short len; unsigned char arr[150]; } bl_wo_foot_note_line10_text;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

			
double      bl_wo_request_amt,nd_fr_wo_amt=0,nd_to_wo_amt=0,get_amount;			
int i,sl_no=1;
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char fm_date[11],to_date[11];
	char g_amt[15], gstr_amt[15];

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

int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0;
int    first = 1,r_fst = 1;

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
 
    strcpy(g_pgm_id,"BLRINSWO");
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
		strcpy(p_language_id.arr,l_language_id.arr);
		p_language_id.len = strlen(p_language_id.arr);
		p_language_id.arr[p_language_id.len]='\0';

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

		nd_facility.arr[nd_facility.len]='\0';

		nd_fm_date.arr[0]			= '\0';
		nd_to_date.arr[0]			= '\0';
		nd_fm_reason_code.arr[0]	= '\0';
		nd_to_reason_code.arr[0]	= '\0';
		nd_blng_grp_catg.arr[0]		= '\0';
		nd_nationality.arr[0]		= '\0';
		nd_wo_status.arr[0]         = '\0';
	//	nd_fr_wo_amt.arr[0]			= '\0';	
	//	nd_to_wo_amt.arr[0]			= '\0';	
				
		nd_fm_date.len			= 0;
		nd_to_date.len			= 0;
		nd_fm_reason_code.len	= 0;
		nd_to_reason_code.len	= 0;
		nd_blng_grp_catg.len	= 0;
		nd_nationality.len		= 0;
		nd_wo_status.len		= 0;
        //nd_fr_wo_amt.len		= 0;	
		//nd_to_wo_amt.len		= 0;


	//	disp_message(ERR_MESG,"Called Here");



        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,to_number(PARAM7),to_number(PARAM8)
				INTO	:nd_fm_date,
						:nd_to_date,
						:nd_fm_reason_code,
						:nd_to_reason_code,
						:nd_nationality,
						:nd_wo_status,
						:nd_fr_wo_amt,
                        :nd_to_wo_amt 
				FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 11;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6\
 ,to_number(PARAM7) ,to_number(PARAM8) into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  f\
rom SY_PROG_PARAM where ((PGM_ID=:b8 and SESSION_ID=:b9) and PGM_DATE=:b10)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )36;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_fm_date;
        sqlstm.sqhstl[0] = (unsigned int  )13;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
        sqlstm.sqhstl[1] = (unsigned int  )13;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_fm_reason_code;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_to_reason_code;
        sqlstm.sqhstl[3] = (unsigned int  )7;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_nationality;
        sqlstm.sqhstl[4] = (unsigned int  )4;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&nd_wo_status;
        sqlstm.sqhstl[5] = (unsigned int  )4;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&nd_fr_wo_amt;
        sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_to_wo_amt;
        sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

		nd_fm_reason_code.arr[nd_fm_reason_code.len]	= '\0';
		nd_to_reason_code.arr[nd_to_reason_code.len]	= '\0';
		nd_fm_date.arr[nd_fm_date.len]					= '\0';
		nd_to_date.arr[nd_to_date.len]					= '\0';
		nd_blng_grp_catg.arr[nd_blng_grp_catg.len]		= '\0';
		nd_nationality.arr[nd_nationality.len]			= '\0';
		nd_wo_status.arr[nd_wo_status.len]				= '\0';  
        //nd_fr_wo_amt.arr[nd_fr_wo_amt.len]		= '\0'; 
        //nd_to_wo_amt.arr[nd_to_wo_amt.len]		= '\0'; 

	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )95;
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

   /* EXEC SQL Select BASE_CURRENCY into :bl_currency from sy_acc_entity where acc_entity_id = :nd_facility; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select BASE_CURRENCY into :b0  from sy_acc_entity where ac\
c_entity_id=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )122;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_currency;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_facility;
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



    	declare_cur();

		fetch_hosp_name();

        fetch_blng_catg_desc();

		fetch_print_foot_note();

		fetch_legend_value();

		open_file();		

		open_wo_dtl();

      fprintf(fp,"%c&l1O",ESC); /* Set Landscape*/ 
	  fprintf(fp, "%c(s14H", ESC);/* Reduce the font size*/


		print_hdr();
		
		end_of_rep();


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )145;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}

declare_cur()
{
	/* EXEC SQL DECLARE WO_DTL_CUR CURSOR FOR 
		select  a.aggr_doc_type_code,
					a.aggr_doc_num,
					a.aggr_doc_type_code||'/'||a.aggr_doc_num,
					to_char(a.aggr_doc_date,'DD/MM/YYYY'),
					a.patient_id,
					a.wo_request_amt,
					a.req_reason_code,
	  b.REASON_CODE  Canc_reason_code,
					a.reln_code,
			a.wo_appr_rejn_doc_ref||'/'||a.wo_appr_rejn_doc_ref_sl  appr_ref      
					from bl_inst_wo_request_dtl a,bl_inst_wo_request_canc_dtl b,bl_inst_pmnt_plan d, BL_CREDIT_AGREEMENT E
					where 
					a.operating_facility_id=:nd_facility
					and   a.operating_facility_id = d.operating_facility_id
					and   a.aggr_doc_type_code = d.aggr_doc_type_code
					and   a.aggr_doc_num = d.aggr_doc_num
					and   a.aggr_inst_no = d.aggr_inst_no
					AND D.operating_facility_id=E.operating_facility_id
					and	D.aggr_doc_type_code =E.aggr_doc_type_code
					and	D.aggr_doc_num =E.aggr_doc_num
					AND NVL(E.CANCELLED_YN,'N')='N'
					and   a.doc_type_code = b.doc_type_code(+)
					and   a.doc_num  = b.doc_num(+)
					and  nvl(a.wo_approved_amt,0) between :nd_fr_wo_amt and :nd_to_wo_amt
				   and   (:nd_nationality = 'A' OR 
	   (:nd_nationality = 'C' and RELN_CODE ='NATIONALS') or 
	   (:nd_nationality = 'O' and RELN_CODE ='OTHERS') ) 
	   and 
		( 
		(nvl(A.cancelled_yn,'N') = 'N'
		
		 and 
		((:nd_wo_status = 'P' and WO_APPROVED_YN is null ) or
		 (:nd_wo_status = 'A' and WO_APPROVED_YN = 'Y'   ) or
		 (:nd_wo_status = 'R' and WO_APPROVED_YN = 'N'   ) 
		))
	   or 
	   (:nd_wo_status = 'C' and nvl(A.cancelled_yn,'N') = 'Y' )
			)
		
					and  ( (:nd_wo_status = 'P' and 
	   nvl(req_reason_code,'!!!!') between nvl(:nd_fm_reason_code,'!!!!') and nvl(:nd_to_reason_code,'~~~~')
	   and TRUNC(a.WO_PROCESS_DATE) between to_date(:nd_fm_date,'dd/mm/yyyy') and to_date(:nd_to_date,'dd/mm/yyyy')
	   )
	   or
	   (:nd_wo_status in  ('A','R') and 
	   nvl(APPR_REJN_REASON_CODE,'!!!!') between nvl(:nd_fm_reason_code,'!!!!') and nvl(:nd_to_reason_code,'~~~~')
	   and TRUNC(a.WO_APPR_REJN_DATE) between to_date(:nd_fm_date,'dd/mm/yyyy') and to_date(:nd_to_date,'dd/mm/yyyy')
	   )
	   or
	   (:nd_wo_status in  ('C') and 
	   nvl(b.REASON_CODE,'!!!!') between nvl(:nd_fm_reason_code,'!!!!') and nvl(:nd_to_reason_code,'~~~~')
	   and TRUNC(b.CANCELLED_DATE)  between to_date(:nd_fm_date,'dd/mm/yyyy') and to_date(:nd_to_date,'dd/mm/yyyy'))); */ 



	/* EXEC SQL DECLARE REMINDER_DTL_CUR CURSOR FOR 
	select	A.reminder_no,
			to_char(A.reminder_dispatched_date,'DD/MM/YYYY'),
			A.reminder_disp_doc_type,
			A.reminder_disp_doc_number,
			A.reminder_disp_doc_slno,
			nvl(A.reminder_not_delivered_yn,'N')
			from bl_inst_pmnt_for_reminder A,BL_CREDIT_AGREEMENT B
			where A.operating_facility_id=:nd_facility
			AND A.operating_facility_id=B.operating_facility_id
			and	A.aggr_doc_type_code =B.aggr_doc_type_code
			and	A.aggr_doc_num =B.aggr_doc_num
			AND NVL(B.CANCELLED_YN,'N')='N'
			and	  A.aggr_doc_type_code = :bl_org_doc_type_code
			and   A.aggr_doc_num       = :bl_org_doc_num; */ 


}

open_wo_dtl() 
{

	/* EXEC SQL OPEN WO_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.aggr_doc_type_code ,a.aggr_doc_num ,((a.aggr_doc_type_code||'/'\
)||a.aggr_doc_num) ,to_char(a.aggr_doc_date,'DD/MM/YYYY') ,a.patient_id ,a.w\
o_request_amt ,a.req_reason_code ,b.REASON_CODE Canc_reason_code ,a.reln_cod\
e ,((a.wo_appr_rejn_doc_ref||'/')||a.wo_appr_rejn_doc_ref_sl) appr_ref  from\
 bl_inst_wo_request_dtl a ,bl_inst_wo_request_canc_dtl b ,bl_inst_pmnt_plan \
d ,BL_CREDIT_AGREEMENT E where ((((((((((((((a.operating_facility_id=:b0 and\
 a.operating_facility_id=d.operating_facility_id) and a.aggr_doc_type_code=d\
.aggr_doc_type_code) and a.aggr_doc_num=d.aggr_doc_num) and a.aggr_inst_no=d\
.aggr_inst_no) and D.operating_facility_id=E.operating_facility_id) and D.ag\
gr_doc_type_code=E.aggr_doc_type_code) and D.aggr_doc_num=E.aggr_doc_num) an\
d NVL(E.CANCELLED_YN,'N')='N') and a.doc_type_code=b.doc_type_code(+)) and a\
.doc_num=b.doc_num(+)) and nvl(a.wo_approved_amt,0) between :b1 and :b2) and\
 ((:b3='A' or (:b3='C' and RELN_CODE='NATIONALS')) or (:b3='O' and RELN_CODE\
='OTHERS'))) and ((nvl(A.cancelled_yn,'N");
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )160;
 sqlstm.selerr = (unsigned short)1;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_fr_wo_amt;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_wo_amt;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_nationality;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_nationality;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_nationality;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_wo_status;
 sqlstm.sqhstl[6] = (unsigned int  )4;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_wo_status;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_wo_status;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_wo_status;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_wo_status;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_fm_reason_code;
 sqlstm.sqhstl[11] = (unsigned int  )7;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_to_reason_code;
 sqlstm.sqhstl[12] = (unsigned int  )7;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_fm_date;
 sqlstm.sqhstl[13] = (unsigned int  )13;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[14] = (unsigned int  )13;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_wo_status;
 sqlstm.sqhstl[15] = (unsigned int  )4;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_fm_reason_code;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_to_reason_code;
 sqlstm.sqhstl[17] = (unsigned int  )7;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_fm_date;
 sqlstm.sqhstl[18] = (unsigned int  )13;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[19] = (unsigned int  )13;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&nd_wo_status;
 sqlstm.sqhstl[20] = (unsigned int  )4;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_fm_reason_code;
 sqlstm.sqhstl[21] = (unsigned int  )7;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&nd_to_reason_code;
 sqlstm.sqhstl[22] = (unsigned int  )7;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&nd_fm_date;
 sqlstm.sqhstl[23] = (unsigned int  )13;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[24] = (unsigned int  )13;
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
         err_mesg("OPEN failed on cursor WO_DTL_CUR",0,"");
}

close_wo_dtl() 
{

	/* EXEC SQL CLOSE WO_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )275;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

open_rem_cur() 
{

	/* EXEC SQL OPEN REMINDER_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )290;
 sqlstm.selerr = (unsigned short)1;
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
 sqlstm.sqhstv[1] = (         void  *)&bl_org_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_org_doc_num;
 sqlstm.sqhstl[2] = (unsigned int  )11;
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
         err_mesg("OPEN failed on cursor REMINDER_DTL_CUR",0,"");
}

close_rem_cur() 
{

	/* EXEC SQL CLOSE REMINDER_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )317;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

fetch_reminder_dtl()
{

bl_reminder_no.arr[0]				= '\0';
bl_reminder_dispatched_date.arr[0]	= '\0';
bl_reminder_disp_doc_type.arr[0]	= '\0';
bl_reminder_disp_doc_number.arr[0]	= '\0';
bl_reminder_disp_doc_slno.arr[0]	= '\0';
bl_reminder_not_delivered_yn.arr[0]	= '\0';
			
bl_reminder_no.len				= 0;
bl_reminder_dispatched_date.len	= 0;
bl_reminder_disp_doc_type.len	= 0;
bl_reminder_disp_doc_number.len	= 0;
bl_reminder_disp_doc_slno.len	= 0;
bl_reminder_not_delivered_yn.len= 0;

      /* EXEC SQL FETCH REMINDER_DTL_CUR
               INTO :bl_reminder_no,
					:bl_reminder_dispatched_date,
					:bl_reminder_disp_doc_type,
					:bl_reminder_disp_doc_number,
					:bl_reminder_disp_doc_slno,
					:bl_reminder_not_delivered_yn; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 25;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )332;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_reminder_no;
      sqlstm.sqhstl[0] = (unsigned int  )10;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_reminder_dispatched_date;
      sqlstm.sqhstl[1] = (unsigned int  )13;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_reminder_disp_doc_type;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_reminder_disp_doc_number;
      sqlstm.sqhstl[3] = (unsigned int  )11;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_reminder_disp_doc_slno;
      sqlstm.sqhstl[4] = (unsigned int  )6;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_reminder_not_delivered_yn;
      sqlstm.sqhstl[5] = (unsigned int  )4;
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


	
//	disp_message(ERR_MESG,SQLCA.SQLERRD[2].arr);
					
       if (OERROR)
            err_mesg("FETCH failed on cursor REMINDER_DTL_CUR",0,"");

bl_reminder_no.arr[bl_reminder_no.len]							= '\0';
bl_reminder_dispatched_date.arr[bl_reminder_dispatched_date.len]= '\0';
bl_reminder_disp_doc_type.arr[bl_reminder_disp_doc_type.len]	= '\0';
bl_reminder_disp_doc_number.arr[bl_reminder_disp_doc_number.len]= '\0';
bl_reminder_disp_doc_slno.arr[bl_reminder_disp_doc_slno.len]	= '\0';
bl_reminder_not_delivered_yn.arr[bl_reminder_not_delivered_yn.len]	= '\0';


    return(LAST_ROW?0:1);
}


fetch_wo_dtl()
{
bl_reason_code.arr[0]		= '\0';
bl_org_doc_type_code.arr[0]	= '\0';
bl_org_doc_num.arr[0]		= '\0';
bl_org_doc_no.arr[0]		= '\0';
bl_org_doc_date.arr[0]		= '\0';
bl_patient_id.arr[0]		= '\0';
bl_episode_type.arr[0]		= '\0';
nd_national_id_num.arr[0]	= '\0';
bl_canc_reason_code.arr[0]  = '\0';
bl_reln_code.arr[0]			= '\0';	
nd_appr_ref.arr[0] = '\0';

bl_reason_code.len			= 0;
bl_org_doc_type_code.len	= 0;
bl_org_doc_num.len			= 0;
bl_org_doc_no.len			= 0;
bl_org_doc_date.len			= 0;
bl_patient_id.len			= 0;
bl_episode_type.len			= 0;
nd_national_id_num.len		= 0;
bl_canc_reason_code.len	    = 0;
bl_reln_code.len			= 0;
nd_appr_ref.len= 0;

bl_wo_request_amt           = 0;


      /* EXEC SQL FETCH WO_DTL_CUR
               INTO :bl_org_doc_type_code,
					:bl_org_doc_num,
					:bl_org_doc_no,
					:bl_org_doc_date,
					:bl_patient_id,
					:bl_wo_request_amt,
					:bl_reason_code,
					:bl_canc_reason_code,
					:bl_reln_code,
					:nd_appr_ref; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 25;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )371;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_org_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_org_doc_num;
      sqlstm.sqhstl[1] = (unsigned int  )11;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_org_doc_no;
      sqlstm.sqhstl[2] = (unsigned int  )18;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_org_doc_date;
      sqlstm.sqhstl[3] = (unsigned int  )13;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_patient_id;
      sqlstm.sqhstl[4] = (unsigned int  )23;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_wo_request_amt;
      sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_reason_code;
      sqlstm.sqhstl[6] = (unsigned int  )7;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bl_canc_reason_code;
      sqlstm.sqhstl[7] = (unsigned int  )7;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&bl_reln_code;
      sqlstm.sqhstl[8] = (unsigned int  )15;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&nd_appr_ref;
      sqlstm.sqhstl[9] = (unsigned int  )37;
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
            err_mesg("FETCH failed on cursor WO_DTL_CUR",0,"");

bl_reason_code.arr[bl_reason_code.len]				= '\0';
bl_org_doc_type_code.arr[bl_org_doc_type_code.len]	= '\0';
bl_org_doc_num.arr[bl_org_doc_num.len]				= '\0';
bl_org_doc_no.arr[bl_org_doc_no.len]				= '\0';
bl_org_doc_date.arr[bl_org_doc_date.len]			= '\0';
bl_patient_id.arr[bl_patient_id.len]				= '\0';
bl_episode_type.arr[bl_episode_type.len]			= '\0';
bl_canc_reason_code.arr[bl_canc_reason_code.len]	= '\0';
bl_reln_code.arr[bl_reln_code.len]					= '\0';
nd_appr_ref.arr[nd_appr_ref.len] = '\0';

/*if(strcmp(nd_nationality.arr,'N' == 0)
   	strcpy(nd_citizen.arr,"N");
else
	strcpy(nd_citizen.arr,"Y");
	
*/

    return(LAST_ROW?0:1);
}



print_hdr()
{
  while(fetch_wo_dtl())
  {
    fetch_patient_name();
	
	fetch_reason_desc();

    if(first)
	 {
	 print_head();
	 
     strcpy(old_patient_id.arr,bl_patient_id.arr);
	 old_patient_id.len=strlen(old_patient_id.arr);
	 first = 0;
	 }
	
	check_page_end(2,0);
    fprintf(fp," %-3d %-62s %-3s %-4s ",
				sl_no,
				bl_patient_name.arr," ",
				bl_episode_type.arr);
    
	fprintf(fp,"%-10s",bl_reln_code.arr);
	print_formated(bl_wo_request_amt);

		if(bl_org_doc_date.arr[0]!='\0')
		{
		init_date_temp_var();
		strcpy(date_convert.arr,bl_org_doc_date.arr);
		fun_change_loc_date();	
		}
	fprintf(fp,"%-11s %10s %-35s %-4s",bl_org_doc_no.arr,date_convert.arr,nd_appr_ref.arr,bl_reason_code.arr);
	fprintf(fp,"\n");
	lctr = lctr + 1;
	sl_no++;

	if (nd_ln1_add.arr[0] != '\0')
	{
	check_page_end(1,0);
    fprintf(fp," %-3s %-30s \n"," ",nd_ln1_add.arr);			 
	lctr = lctr + 1;
	}

	if (nd_ln2_add.arr[0] != '\0')
	{
	check_page_end(1,0);
    fprintf(fp," %-3s %-30s \n"," ",nd_ln2_add.arr);			 
	lctr = lctr + 1;
	}

	if (nd_ln3_add.arr[0] != '\0')
	{
	check_page_end(1,0);
    fprintf(fp," %-3s %-30s \n"," ",nd_ln3_add.arr);			 
	lctr = lctr + 1;
	}

	if (nd_ln4_add.arr[0] != '\0')
	{
	check_page_end(1,0);
	fprintf(fp," %-3s %-30s "," ",nd_ln4_add.arr);			 
	}
	if (nd_postal_code.arr[0] != '\0')
	{
    fprintf(fp," %-8s\n",nd_postal_code.arr);			 
	lctr = lctr + 1;
	}
   fprintf(fp,"\n");
	r_fst = 1;
	open_rem_cur();
	
	while(fetch_reminder_dtl())
	  {
	  	if(bl_reminder_dispatched_date.arr[0]!='\0')
			  {
			init_date_temp_var();
			strcpy(date_convert.arr,bl_reminder_dispatched_date.arr);
			fun_change_loc_date();	
			  }
	    check_page_end(1,0);
		if(strcmp(bl_reminder_not_delivered_yn.arr,"Y") == 0)
		   {
          fprintf(fp,"%108s %-3s %-10s %12s \n"," ",bl_reminder_no.arr,date_convert.arr,"*Undelivered");
		  lctr = lctr + 1;
		   }
		else
		 {
		 fprintf(fp,"%108s %-3s %-10s \n"," ",bl_reminder_no.arr,date_convert.arr);
		 lctr = lctr + 1;
		}
	   }
     close_rem_cur();
	 strcpy(old_patient_id.arr,bl_patient_id.arr);
	 old_patient_id.len=strlen(old_patient_id.arr);
        
	 }
close_wo_dtl() ;

if(first)
print_head();

if (sl_no > 1) 
print_note();
}   



print_note()
{
  /*  check_page_end(2,0);
	fprintf(fp," %s : \n\n",loc_legend[29]);*/

if(strcmp(bl_wo_foot_note_line01_text.arr,"\0")!=0)
    {
	check_page_end(2,0);
    fprintf(fp,"%s \n",bl_wo_foot_note_line01_text.arr);
	lctr=lctr+2;
	}

if(strcmp(bl_wo_foot_note_line02_text.arr,"\0")!=0)
  {
    check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line02_text.arr);
    lctr=lctr+2; 
	}
if(strcmp(bl_wo_foot_note_line03_text.arr,"\0")!=0)
  {
    check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line03_text.arr);
    lctr=lctr+2; 
	}
if(strcmp(bl_wo_foot_note_line05_text.arr,"\0")!=0)
  {
    check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line04_text.arr);
    lctr=lctr+2;
   }
if(strcmp(bl_wo_foot_note_line05_text.arr,"\0")!=0)
  {
	check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line05_text.arr);
    lctr=lctr+2;
   }
if(strcmp(bl_wo_foot_note_line06_text.arr,"\0")!=0)
   {
	check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line06_text.arr);
    lctr=lctr+2;
	}
if(strcmp(bl_wo_foot_note_line07_text.arr,"\0")!=0)
  {
	check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line07_text.arr);
    lctr=lctr+2;
   }

if(strcmp(bl_wo_foot_note_line08_text.arr,"\0")!=0)
  {
	check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line08_text.arr);
    lctr=lctr+2;
  }
 if(strcmp(bl_wo_foot_note_line09_text.arr,"\0")!=0)
  {
	check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line09_text.arr);
    lctr=lctr+2;
   }

  if(strcmp(bl_wo_foot_note_line10_text.arr,"\0")!=0)
     {
	check_page_end(2,0);
	fprintf(fp,"%s \n",bl_wo_foot_note_line10_text.arr);
    lctr=lctr+2;
     }
	/*fprintf(fp,"1._____________________________________   ");
	fprintf(fp,"5._____________________________________   ");
	fprintf(fp,"\n");
	fprintf(fp,"  _____________________________________   ");
	fprintf(fp,"  _____________________________________   ");
	fprintf(fp,"\n");
	lctr=lctr+2; 

	check_page_end(2,0);
	fprintf(fp,"2._____________________________________   ");
	fprintf(fp,"6._____________________________________   ");
	fprintf(fp,"\n");
	fprintf(fp,"  _____________________________________   ");
	fprintf(fp,"  _____________________________________   ");
	fprintf(fp,"\n");
	lctr=lctr+2; 

	check_page_end(2,0);
	fprintf(fp,"3._____________________________________   ");
	fprintf(fp,"7._____________________________________   ");
	fprintf(fp,"\n");
	fprintf(fp,"  _____________________________________   ");
	fprintf(fp,"  _____________________________________   ");
	fprintf(fp,"\n");
	lctr=lctr+2; 

	check_page_end(2,0);
	fprintf(fp,"4._____________________________________   ");
	fprintf(fp,"8._____________________________________   ");
	fprintf(fp,"\n");
	fprintf(fp,"  _____________________________________   ");
	fprintf(fp,"  _____________________________________   ");
	fprintf(fp,"\n");
    */
	lctr=lctr+2; 
}   


end_of_rep()
{
	check_page_end(3,0);
	fprintf(fp,"\n\n %65s   ***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	//strcat(filename,"BLR00099.lis");
	strcat(filename,"BLRINSWO.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       //disp_message(ERR_MESG,"Error in opening file BLR00099.lis");
	   disp_message(ERR_MESG,"Error in opening file BLRINSWO.lis");
       proc_exit();
    }
}

print_page_header()
{

    if (nd_fm_date.arr[0] == '\0')
	  strcpy(fm_date,"Lowest");
    else
	  strcpy(fm_date,nd_fm_date.arr);

	if (nd_to_date.arr[0] == '\0')
	  strcpy(to_date,"Highest");
    else
	  strcpy(to_date,nd_to_date.arr);




print_page_title();
fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1 \n\n\n\n");
fprintf(fp,"           INPUT PARAMETER \n");
fprintf(fp,"           --------------- \n\n\n\n");
fprintf(fp,"				TRANSACTION TYPE                  : ");

fprintf(fp,"\n\n");

fprintf(fp,"				RECEIPT DATE     FROM             : %s\n",fm_date);
fprintf(fp,"				                 TO               : %s\n\n",to_date);
fprintf(fp,"\f");
}

print_head()
{
	print_page_title();
    fill_dash(195);
	fprintf(fp,"\n");
	//fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------\n");
//fprintf(fp," %-3s %-4s/%-7s/%-11s %34s%-7s%-5s %8s %3s %-5s%-7s %4s%-7s %4s%-5s  %-35s %-10s \n",loc_legend[12],loc_legend[13],loc_legend[14],loc_legend[15]," ",loc_legend[17],loc_legend[18],loc_legend[10]," ",loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[21],loc_legend[23],loc_legend[32],loc_legend[24]);
fprintf(fp," %-3s %-4s/%-7s/%-11s %34s%-7s%-5s %8s %3s %-5s%-7s %4s%-7s %4s%-5s  %-25s %-10s \n",loc_legend[12],loc_legend[13],loc_legend[14],loc_legend[15]," ",loc_legend[17],loc_legend[18],loc_legend[10]," ",loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[21],loc_legend[23],loc_legend[32],loc_legend[24]);
 
 
 /* fprintf(fp," %-3s %-16s \n"," "           ,loc_legend[16]);
	fprintf(fp," %-3s %-16s %1s %-4s  %41s %-7s %-6s      %10s  %-16s %-10s %-9s  \n"," "           ,loc_legend[016]," "           ," "           ," ",loc_legend[018]," "           ,loc_legend[020],loc_legend[022],loc_legend[023],loc_legend[025]);
 */

fprintf(fp," %-3s %-16s           %24s% -7s%-5s %-8s %-5s%-7s %5s%6s   %8s%2s/%4s\n"," ",loc_legend[16]," "," "," "," "," "," "," "," ",loc_legend[27],loc_legend[28],loc_legend[23]);
	fill_dash(195);
	fprintf(fp,"\n");
	//fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------\n");
	fflush(fp); 
	lctr = 12;
}

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;
	char   nd_reason1[7],nd_reason2[7];


	//l_report_width=195; SAIKIRAN FOR 18154 on 20/1/2010 
	l_report_width=160;
	l_acc_entity_length = strlen(hosp_name.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2)-8);
	//disp_message(ERR_MESG,"1");
	//disp_message(ERR_MESG,loc_legend[6]);
	fprintf(fp,"MDL           : BL");
	l_start_point=l_start_point-13;
	print_spaces(l_start_point);
	fprintf(fp,"%s",hosp_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(20+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
		init_date_temp_var();
		strcpy(date_convert.arr,date.arr);
		fun_change_loc_date();
   	fprintf(fp,"%-15.15s : %s\n",loc_legend[003],date_convert.arr);

	//Code for Line 2
	
	l_start_point=0;

	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2)-6);

	fprintf(fp,"OPR           : %s",user_id.arr);
	//	l_start_point=l_start_point-(strlen(user_id.arr)+16); SAIKIRAN FOR 18154 on 20/1/2010
	l_start_point=l_start_point-(strlen(user_id.arr)+20);
	print_spaces(l_start_point);

	if(strcmp(nd_wo_status.arr,"R") == 0)
	 {
	     fprintf(fp,"     %s ",loc_legend[45]);
		  l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[45])+5;
			
		}
     if(strcmp(nd_wo_status.arr,"P") == 0)
      {
	  	     fprintf(fp,"%s ",loc_legend[43]);
			  l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[43]);
		
       }
     if(strcmp(nd_wo_status.arr,"A") == 0)
	   {
	   	     fprintf(fp,"    %s ",loc_legend[44]);
			  l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[44])+4;
		}       		           
	  if(strcmp(nd_wo_status.arr,"C") == 0)
	   {
        
   	     //fprintf(fp,"%s ",loc_legend[046]);SAIKIRAN FOR 18154 on 20/1/2010
		 fprintf(fp,"%s ",loc_legend[46]);
		  l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[46]);
		
		             
			 
		}

      

/*	fprintf(fp,"%s ",loc_legend[001]);
	
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[1]);*/
	
	l_start_point=(l_report_width-(23+strlen(date_time.arr))-l_comp_name_end_point);
 	print_spaces(l_start_point);

	 fprintf(fp,"%-15.15s : %s\n",loc_legend[004],date_time.arr); 
     
	//Code for Line 3
 l_start_point=0;
	 l_start_point=ceill(l_report_width/2)-((23+6)/2+10);
    
	 //fprintf(fp,"%-14.14s: BLR00099",loc_legend[002]);
	 fprintf(fp,"%-14.14s: BLRINSWO",loc_legend[002]);
	 //l_start_point=l_start_point-24;saikiran
	 l_start_point=l_start_point-19;
	print_spaces(l_start_point);


	if (nd_blng_grp_catg.arr[0] != '\0')
	  	  { 
		  
	      fprintf(fp,"%s : %-30s",loc_legend[006],bl_blng_catg_desc.arr);
		    l_comp_name_end_point=l_start_point+(24+23)+6;
        	l_start_point=(l_report_width-48-l_comp_name_end_point);
		 }
	else
	{
           fprintf(fp,"%s : %4s",loc_legend[006],loc_legend[30]);
			l_comp_name_end_point=l_start_point+(24+23)+3;
        	l_start_point=(l_report_width-(25)-l_comp_name_end_point);
      }
	print_spaces(l_start_point-7);
  	fprintf(fp,"   %-11.11s : %d\n",loc_legend[005],++pctr);

/*---------------------------------*/

	//Code for Line 4

  if(strcmp(nd_wo_status.arr,"P") == 0)
	   {

   	//fprintf(fp,"%40s :  %12s %3s %12s",loc_legend[47],nd_fm_date.arr,loc_legend[007],nd_to_date.arr);
	init_date_temp_var();
	strcpy(date_convert.arr,nd_fm_date.arr);
	fun_change_loc_date();
	 fprintf(fp,"%40s :  %-12s ",loc_legend[47],date_convert.arr);
	init_date_temp_var();
	strcpy(date_convert.arr,nd_to_date.arr);
	fun_change_loc_date();
	 //fprintf(fp,"%3s :%12s",loc_legend[007],date_convert.arr); SAIKIRAN FOR 18154 on 20/1/2010
	 fprintf(fp,"%3s %-12s",loc_legend[007],date_convert.arr); 
		}

  if(strcmp(nd_wo_status.arr,"A") == 0)
	   {
	init_date_temp_var();
	strcpy(date_convert.arr,nd_fm_date.arr);
	fun_change_loc_date();
	fprintf(fp,"%40s :  %-12s",loc_legend[48],date_convert.arr);
 	init_date_temp_var();
	strcpy(date_convert.arr,nd_to_date.arr);
	fun_change_loc_date();
	//fprintf(fp,"%3s: %12s",loc_legend[007],date_convert.arr); SAIKIRAN FOR 18154 on 20/1/2010
	fprintf(fp," %3s %-12s",loc_legend[007],date_convert.arr);
	//fprintf(fp,"%40s :  %12s %3s %12s",loc_legend[48],nd_fm_date.arr,loc_legend[007],nd_to_date.arr);
	
			
		}

	if(strcmp(nd_wo_status.arr,"R") == 0)
	   {

		init_date_temp_var();
		strcpy(date_convert.arr,nd_fm_date.arr);
		fun_change_loc_date();
		fprintf(fp,"%40s :  %-12s",loc_legend[49],date_convert.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_to_date.arr);
		fun_change_loc_date();
		//fprintf(fp,"%3s: %12s",loc_legend[007],date_convert.arr);SAIKIRAN FOR 18154 on 20/1/2010
		fprintf(fp," %3s %-12s",loc_legend[007],date_convert.arr);
	//fprintf(fp,"%40s :  %12s %3s %12s",loc_legend[49],nd_fm_date.arr,loc_legend[007],nd_to_date.arr);

		}
	if(strcmp(nd_wo_status.arr,"C") == 0)
	   {

	//fprintf(fp,"%40s :  %12s %3s %12s",loc_legend[50],nd_fm_date.arr,loc_legend[007],nd_to_date.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_fm_date.arr);
		fun_change_loc_date();
		fprintf(fp,"%40s :  %-12s ",loc_legend[50],date_convert.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_to_date.arr);
		fun_change_loc_date();
		fprintf(fp,"%3s %-12s",loc_legend[007],date_convert.arr);
	
	
		}

//Code for Line 5
 
	fprintf(fp,"%30s : %s ",loc_legend[57],bl_currency.arr); 
	put_val(g_amt,nd_fr_wo_amt); 
	    format_amt(g_amt);
        
		/*sprintf(gstr_amt,"%-11s",g_amt);
        fprintf(fp,"%-11s  ",gstr_amt);		
		commented by saikiran for 18154 on 20/1/2010 */
		
		sprintf(gstr_amt,"%-s",g_amt);
		fprintf(fp,"%-s ",gstr_amt);

	// print_formated(nd_fr_wo_amt);
    //fprintf(fp,"%3s ",loc_legend[007]);SAIKIRAN FOR 18154 on 20/1/2010
	fprintf(fp,"%-3s ",loc_legend[007]);
	put_val(g_amt,nd_to_wo_amt); 
      format_amt(g_amt);
       
	   /* sprintf(gstr_amt,"%-11s",g_amt);
        fprintf(fp,"%-11s  ",gstr_amt);
         commented by saikiran for 18154 on 20/1/2010 */
		
		sprintf(gstr_amt,"%-s",g_amt);
        fprintf(fp,"%-s ",gstr_amt);
         
fprintf(fp,"\n");


/*	l_start_point=ceill(l_report_width/2)-(strlen(loc_legend[008])+strlen(nd_fm_date.arr)+strlen(nd_to_date.arr)+4)/2;
	print_spaces(l_start_point);
	fprintf(fp,"%s :%s %s %s\n",loc_legend[008],nd_fm_date.arr,loc_legend[007],nd_to_date.arr);
	*/

	//Code for Line 6

  

    if (strcmp(nd_fm_reason_code.arr,"!!!!" ) == 0)
	  strcpy(nd_reason1,"Lowest");
    else
	   strcpy(nd_reason1,nd_fm_reason_code.arr);
    
	if (strcmp(nd_to_reason_code.arr,"~~~~") == 0)
	  strcpy(nd_reason2,"Highest");
    else
	   strcpy(nd_reason2,nd_to_reason_code.arr);
    

	l_start_point=0;
  
if(strcmp(nd_wo_status.arr,"P") == 0)
	   {
	fprintf(fp,"%40s :  %-12s %3s %-12s",loc_legend[51],nd_reason1,loc_legend[007],nd_reason2);
	
    }
if(strcmp(nd_wo_status.arr,"A") == 0)
	   {

	fprintf(fp,"%40s :  %-12s %3s %-12s",loc_legend[52],nd_reason1,loc_legend[007],nd_reason2);

     }
if(strcmp(nd_wo_status.arr,"R") == 0)
	   {

	fprintf(fp,"%40s :  %-12s %3s %-12s",loc_legend[53],nd_reason1,loc_legend[007],nd_reason2);
		
     }
if(strcmp(nd_wo_status.arr,"C") == 0)
	   {

	fprintf(fp,"%40s :  %-12s %3s %-12s",loc_legend[54],nd_reason1,loc_legend[007],nd_reason2);

  }


/*	l_start_point=ceill(l_report_width/2)-(strlen(loc_legend[009])+strlen(nd_reason1)+strlen(nd_reason2)+4)/2;
	print_spaces(l_start_point);
	fprintf(fp,"%s :%s %s %s\n",loc_legend[009],nd_reason1,loc_legend[007],nd_reason2);

*/
	//Code for Line 7
	l_start_point=0;

	fprintf(fp,"%30s : ",loc_legend[31]);

	if (strcmp(nd_nationality.arr,"A") == 0)
		//fprintf(fp," %s \n",loc_legend[30]); commented by saikiran for 18154 on 20/1/2010 
		fprintf(fp,"%s \n",loc_legend[30]); 
    if (strcmp(nd_nationality.arr,"C") == 0)
		//fprintf(fp," %s \n",loc_legend[10]);commented by saikiran for 18154 on 20/1/2010 
		fprintf(fp,"%s \n",loc_legend[10]);
    if (strcmp(nd_nationality.arr,"N") == 0)
		//fprintf(fp," %s \n",loc_legend[11]);commented by saikiran for 18154 on 20/1/2010 
		fprintf(fp,"%s \n",loc_legend[11]);
   
   
}


fill_dash(flg)
{
  int i;
  for (i=1;i<=flg;i++)
	fprintf(fp,"%s","-");
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
	date.arr[0]		 = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
	date.len		 = 0;
    user_id.len      = 0;



    /* EXEC SQL SELECT ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/RRRR'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
                    USER
               INTO :hosp_name, 
					:date,
					:date_time, 
					:user_id
               FROM SY_ACC_ENTITY_LANG_VW
	          WHERE ACC_ENTITY_ID = :nd_facility
			  AND LANGUAGE_ID =:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/RRRR') ,TO\
_CHAR(SYSDATE,'HH24:MI:SS') ,USER into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY_LAN\
G_VW where (ACC_ENTITY_ID=:b4 and LANGUAGE_ID=:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )426;
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
    sqlstm.sqhstv[1] = (         void  *)&date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&date_time;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&user_id;
    sqlstm.sqhstl[3] = (unsigned int  )93;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_facility;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&p_language_id;
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
}



    if (OERROR) 
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	date.arr[date.len]					   = '\0';
	user_id.arr[user_id.len]               = '\0';

}

fetch_print_foot_note()
{
bl_wo_foot_note_line01_text.arr[0]    ='\0';
bl_wo_foot_note_line02_text.arr[0]    ='\0';
bl_wo_foot_note_line03_text.arr[0]    ='\0';
bl_wo_foot_note_line04_text.arr[0]    ='\0';
bl_wo_foot_note_line05_text.arr[0]    ='\0';
bl_wo_foot_note_line06_text.arr[0]    ='\0';
bl_wo_foot_note_line07_text.arr[0]    ='\0';
bl_wo_foot_note_line08_text.arr[0]    ='\0';
bl_wo_foot_note_line09_text.arr[0]    ='\0';
bl_wo_foot_note_line10_text.arr[0]    ='\0';
 bl_wo_foot_note_line01_text.len      =0;
 bl_wo_foot_note_line02_text.len      =0;
 bl_wo_foot_note_line03_text.len      =0;
 bl_wo_foot_note_line04_text.len      =0;
 bl_wo_foot_note_line05_text.len      =0;
 bl_wo_foot_note_line06_text.len      =0;
 bl_wo_foot_note_line07_text.len      =0;
 bl_wo_foot_note_line08_text.len      =0;
 bl_wo_foot_note_line09_text.len      =0;
 bl_wo_foot_note_line10_text.len	  =0;
   
    /* EXEC SQL SELECT 
	             wo_foot_note_line01_text,
				 wo_foot_note_line02_text,
				 wo_foot_note_line03_text,
				 wo_foot_note_line04_text,
				 wo_foot_note_line05_text,
				 wo_foot_note_line06_text,
				 wo_foot_note_line07_text,
				 wo_foot_note_line08_text,
				 wo_foot_note_line09_text,
				 wo_foot_note_line10_text 
                 INTO  :bl_wo_foot_note_line01_text, 
					   :bl_wo_foot_note_line02_text,
					   :bl_wo_foot_note_line03_text,
					   :bl_wo_foot_note_line04_text,
					   :bl_wo_foot_note_line05_text,
					   :bl_wo_foot_note_line06_text,
					   :bl_wo_foot_note_line07_text,
					   :bl_wo_foot_note_line08_text,
					   :bl_wo_foot_note_line09_text,
					   :bl_wo_foot_note_line10_text
                 FROM BL_WO_REPORT_NOTES_PARAM
				 WHERE  operating_facility_id=:nd_facility AND
				        report_id=:d_curr_pgm_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select wo_foot_note_line01_text ,wo_foot_note_line02_text\
 ,wo_foot_note_line03_text ,wo_foot_note_line04_text ,wo_foot_note_line05_text\
 ,wo_foot_note_line06_text ,wo_foot_note_line07_text ,wo_foot_note_line08_text\
 ,wo_foot_note_line09_text ,wo_foot_note_line10_text into :b0,:b1,:b2,:b3,:b4,\
:b5,:b6,:b7,:b8,:b9  from BL_WO_REPORT_NOTES_PARAM where (operating_facility_i\
d=:b10 and report_id=:b11)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )465;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_wo_foot_note_line01_text;
    sqlstm.sqhstl[0] = (unsigned int  )152;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_wo_foot_note_line02_text;
    sqlstm.sqhstl[1] = (unsigned int  )152;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_wo_foot_note_line03_text;
    sqlstm.sqhstl[2] = (unsigned int  )152;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bl_wo_foot_note_line04_text;
    sqlstm.sqhstl[3] = (unsigned int  )152;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bl_wo_foot_note_line05_text;
    sqlstm.sqhstl[4] = (unsigned int  )152;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bl_wo_foot_note_line06_text;
    sqlstm.sqhstl[5] = (unsigned int  )152;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_wo_foot_note_line07_text;
    sqlstm.sqhstl[6] = (unsigned int  )152;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bl_wo_foot_note_line08_text;
    sqlstm.sqhstl[7] = (unsigned int  )152;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&bl_wo_foot_note_line09_text;
    sqlstm.sqhstl[8] = (unsigned int  )152;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&bl_wo_foot_note_line10_text;
    sqlstm.sqhstl[9] = (unsigned int  )152;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_facility;
    sqlstm.sqhstl[10] = (unsigned int  )5;
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
		err_mesg("SELECT failed on table BL_WO_REPORT_NOTES_PARAM",0,"");

		bl_wo_foot_note_line01_text.arr[bl_wo_foot_note_line01_text.len] ='\0';
		bl_wo_foot_note_line02_text.arr[bl_wo_foot_note_line02_text.len] ='\0';
		bl_wo_foot_note_line03_text.arr[bl_wo_foot_note_line03_text.len] ='\0';
		bl_wo_foot_note_line04_text.arr[bl_wo_foot_note_line04_text.len] ='\0';
		bl_wo_foot_note_line05_text.arr[bl_wo_foot_note_line05_text.len] ='\0';
		bl_wo_foot_note_line06_text.arr[bl_wo_foot_note_line06_text.len] ='\0';
		bl_wo_foot_note_line07_text.arr[bl_wo_foot_note_line07_text.len] ='\0';
		bl_wo_foot_note_line08_text.arr[bl_wo_foot_note_line08_text.len] ='\0';
		bl_wo_foot_note_line09_text.arr[bl_wo_foot_note_line09_text.len] ='\0';
		bl_wo_foot_note_line10_text.arr[bl_wo_foot_note_line10_text.len] ='\0';


	}
		     

fetch_patient_name()
{
    bl_patient_name.arr[0]		= '\0';
	nd_ln1_add.arr[0]		= '\0';
	nd_ln2_add.arr[0]		= '\0';
	nd_ln3_add.arr[0]		= '\0';
	nd_ln4_add.arr[0]		= '\0';
	nd_postal_code.arr[0]	= '\0';

    bl_patient_name.len		= 0;
	nd_ln1_add.len		= 0;
	nd_ln2_add.len		= 0;
	nd_ln3_add.len		= 0;
	nd_ln4_add.len		= 0;
	nd_postal_code.len	= 0;

    /* EXEC SQL SELECT a.short_name,
					ln1_mail_add,
					ln2_mail_add,
					ln3_mail_add,
					ln4_mail_add,
					mail_postal_code
               INTO :bl_patient_name,
					:nd_ln1_add,
					:nd_ln2_add,
					:nd_ln3_add,
					:nd_ln4_add,
					:nd_postal_code
               FROM MP_PATIENT_MAST a,MP_PAT_OTHER_DTLS b
	          WHERE a.patient_id = b.patient_id
			  AND   a.patient_id = :bl_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select a.short_name ,ln1_mail_add ,ln2_mail_add ,ln3_mail\
_add ,ln4_mail_add ,mail_postal_code into :b0,:b1,:b2,:b3,:b4,:b5  from MP_PAT\
IENT_MAST a ,MP_PAT_OTHER_DTLS b where (a.patient_id=b.patient_id and a.patien\
t_id=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )528;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_patient_name;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_ln1_add;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ln2_add;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_ln3_add;
    sqlstm.sqhstl[3] = (unsigned int  )33;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_ln4_add;
    sqlstm.sqhstl[4] = (unsigned int  )33;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_postal_code;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bl_patient_id;
    sqlstm.sqhstl[6] = (unsigned int  )23;
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
		err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

	bl_patient_name.arr[bl_patient_name.len]    = '\0';
	nd_ln1_add.arr[nd_ln1_add.len]		= '\0';
	nd_ln2_add.arr[nd_ln2_add.len]		= '\0';
	nd_ln3_add.arr[nd_ln3_add.len]		= '\0';
	nd_ln4_add.arr[nd_ln4_add.len]		= '\0';
	nd_postal_code.arr[nd_postal_code.len]	= '\0';

}

fetch_reason_desc()
{
    bl_reason_desc.arr[0]	= '\0';
	bl_reason_desc.len		= 0;

   /* EXEC SQL SELECT substr(action_reason_desc,1,115)
               INTO :bl_reason_desc
               FROM BL_ACTION_REASON
	          WHERE action_reason_code = :bl_reason_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select substr(action_reason_desc,1,115) into :b0  from BL_\
ACTION_REASON where action_reason_code=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )571;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_reason_desc;
   sqlstm.sqhstl[0] = (unsigned int  )118;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bl_reason_code;
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



    if (OERROR) 
		err_mesg("SELECT failed on table BL_ACTION_REASON",0,"");

	bl_reason_desc.arr[bl_reason_desc.len]           = '\0';

}

fetch_blng_catg_desc()
{
    bl_blng_catg_desc.arr[0]	= '\0';
	bl_blng_catg_desc.len		= 0;

   /* EXEC SQL SELECT long_desc
               INTO :bl_blng_catg_desc
               FROM BL_BLNG_GRP_CATG
	          WHERE BLNG_GRP_CATG =:nd_blng_grp_catg; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 25;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select long_desc into :b0  from BL_BLNG_GRP_CATG where BLN\
G_GRP_CATG=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )594;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_blng_catg_desc;
   sqlstm.sqhstl[0] = (unsigned int  )32;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp_catg;
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



    if (OERROR) 
		err_mesg("SELECT failed on table BL_BLNG_GRP_CATG",0,"");

	bl_blng_catg_desc.arr[bl_blng_catg_desc.len]           = '\0';

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

check_page_end(l_lead_lines, l_print_flag)
int l_lead_lines;
int	l_print_flag;
{
	if(l_print_flag==1)
		l_lead_lines=l_lead_lines+10;

	if((lctr+l_lead_lines)> 55) 
	{
		fprintf(fp,"\f");
		print_head();
		lctr = 3;
	}
}

print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp," ");
	}
}




fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		//EXEC SQL SELECT LTRIM(RTRIM('BLR00099.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		/* EXEC SQL SELECT LTRIM(RTRIM('BLRINSWO.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRINSWO.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )617;
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
  sqlstm.arrsiz = 25;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )640;
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

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/RRRR HH24:MI'),:p_language_id,t_date);  
      
	   :nd_loc_date := to_char(t_date,'DD/MM/RRRR');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/RRRR HH24:MI' ) , :p_language_id ,\
 t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/RRRR' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )671;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
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