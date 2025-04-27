
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
    "T:\\BL\\ver remov\\blr00066\\BLR00066.PC"
};


static unsigned long sqlctx = 1476862635;


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
            void  *sqhstv[8];
   unsigned int   sqhstl[8];
            int   sqhsts[8];
            void  *sqindv[8];
            int   sqinds[8];
   unsigned int   sqharm[8];
   unsigned int   *sqharc[8];
   unsigned short  sqadto[8];
   unsigned short  sqtdso[8];
} sqlstm = {10,8};

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
"select a.patient_id ,c.short_name patient_name ,((a.doc_type_code||'-')||to\
_char(a.doc_number)) rcpt_no ,to_char(a.doc_date,'DD/MM/YYYY') rcpt_date ,a.d\
oc_amt Deposit_paid ,a.EPISODE_TYPE ,a.EPISODE_ID ,a.VISIT_ID  from BL_RECEIP\
T_REFUND_HDRDTL_VW a ,BL_PATIENT_LEDGER B ,MP_PATIENT_MAST C where (((((((((a\
.RECPT_REFUND_IND='R' and B.ORG_DOC_TYPE_CODE=A.DOC_TYPE_CODE) and B.ORG_DOC_\
NUM=A.DOC_NUMBER) and A.RECPT_NATURE_CODE in ('AD','PR')) and B.AD_PR_ADJ_BIL\
L_DOC_TYPE is null ) and B.DOC_OUTST_AMT<0) and to_char(a.DOC_DATE,'YYYY/MM/D\
D') between to_char(TO_DATE(:b0,'DD/MM/YYYY'),'YYYY/MM/DD') and to_char(TO_DA\
TE(:b1,'DD/MM/YYYY'),'YYYY/MM/DD')) and a.EPISODE_TYPE=decode(:b2,'A',a.episo\
de_type,:b2)) and NVL(a.CANCELLED_IND,'N')<>'Y') and a.PATIENT_ID=c.PATIENT_I\
D) order by 1,2            ";

 static const char *sq0005 = 
"select ((DOC_TYPE_CODE||'-')||to_char(DOC_NUMBER)) refund_doc ,to_char(DOC_\
DATE,'DD/MM/YYYY') refund_date ,ABS(DOC_AMT) REFUND_AMT  from BL_RECEIPT_REFU\
ND_HDRDTL_VW where ((RECPT_REFUND_IND='F' and ((BILL_DOC_TYPE_CODE||'-')||TO_\
CHAR(BILL_DOC_NUMBER))=:b0) and NVL(CANCELLED_IND,'N')<>'Y') order by 1      \
      ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,110,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,150,0,4,144,0,0,7,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
79,0,0,3,84,0,2,171,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
106,0,0,4,795,0,9,254,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,5,312,0,9,261,0,0,1,1,0,1,0,1,9,0,0,
156,0,0,4,0,0,15,268,0,0,0,0,0,1,0,
171,0,0,5,0,0,15,273,0,0,0,0,0,1,0,
186,0,0,4,0,0,13,294,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,
0,0,2,4,0,0,2,4,0,0,
233,0,0,5,0,0,13,329,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,
260,0,0,6,37,0,4,387,0,0,3,2,0,1,0,1,4,0,0,1,4,0,0,2,4,0,0,
287,0,0,7,188,0,4,435,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
326,0,0,8,0,0,32,452,0,0,0,0,0,1,0,
341,0,0,9,96,0,4,658,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
364,0,0,10,162,0,6,665,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
395,0,0,11,159,0,4,692,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,
426,0,0,12,135,0,4,701,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00066.PC                                  */
/* AUTHOR                : Deepali Gosavi                               */  
/* DATE WRITTEN          : 19/06/2005                                   */      
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
#define NODATAFOUND sqlca.sqlcode == 1403
#define OERROR          (sqlca.sqlcode < 0)
#define MAX_LINES 44
#define REP_WIDTH 218				//132
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
			nd_period_from					[15],
			nd_period_to					[15],
			nd_episode_type					[2],
			d_episode_type					[20],
			d_patient_id					[21],
			d_patient_name					[61],
			nd_patient_id                   [21],
			d_doc_type_code					[6],
			l_translated_value				[201],	
			l_pk_value						[100],
			d_receipt_no					[17],
			d_rcpt_date						[20],
			d_bill_no						[17],
			d_refund_no						[17],
			d_refund_date					[20],
			d_episode_type1					[2],
			d_adm_visit_date				[20],
			p_language_id                   [3]; */ 
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

struct { unsigned short len; unsigned char arr[15]; } nd_period_from;

struct { unsigned short len; unsigned char arr[15]; } nd_period_to;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[20]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[6]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[17]; } d_receipt_no;

struct { unsigned short len; unsigned char arr[20]; } d_rcpt_date;

struct { unsigned short len; unsigned char arr[17]; } d_bill_no;

struct { unsigned short len; unsigned char arr[17]; } d_refund_no;

struct { unsigned short len; unsigned char arr[20]; } d_refund_date;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type1;

struct { unsigned short len; unsigned char arr[20]; } d_adm_visit_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


	int i,sl_no=1,page_no=0;
	
	double d_episode_id,d_visit_id,d_doc_num ;

    double  d_patient_dep_amt=0,d_bill_amt=0,
			d_patient_dep_amt_tot=0, d_bill_amt_tot=0,
			d_refund_amt=0, d_dep_balance=0, d_refund_amt_tot=0, d_dep_balance_tot=0, d_refund_amt_tot_tot=0;

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

	strcpy(g_pgm_id,"BLR00066");
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


	nd_period_from.arr[0]	= '\0';	
	nd_period_to.arr[0]		= '\0';	
	nd_episode_type.arr[0]  = '\0';
	nd_facility_id.arr[0]  = '\0';
						
    /* EXEC SQL SELECT	OPERATING_FACILITY_ID, PARAM1, PARAM2, PARAM3
			 INTO :nd_facility_id, :nd_period_from, :nd_period_to, :nd_episode_type
			 FROM SY_PROG_PARAM
			 WHERE PGM_ID   = :d_curr_pgm_name
			 AND   SESSION_ID = :nd_session_id
			 AND   PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 int\
o :b0,:b1,:b2,:b3  from SY_PROG_PARAM where ((PGM_ID=:b4 and SESSION_ID=:b5) \
and PGM_DATE=:b6)";
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
    sqlstm.sqhstv[1] = (         void  *)&nd_period_from;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_period_to;
    sqlstm.sqhstl[2] = (unsigned int  )17;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[3] = (unsigned int  )4;
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



    
	/*sprintf(string_var , "nd fromdays %4d" , nd_from_days);
	disp_message(ERR_MESG, string_var);

	sprintf(string_var , "nd to days %4d" , nd_to_days);
	disp_message(ERR_MESG, string_var);*/


   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");


   nd_period_from.arr[nd_period_from.len]	='\0';			
   nd_period_to.arr[nd_period_from.len]		='\0';			
   nd_episode_type.arr[nd_episode_type.len]	='\0';			
   nd_facility_id.arr[nd_facility_id.len]	='\0';			
         
   /* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSIO\
N_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )79;
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
   
    open_files();
    declare_cur();
	get_header_dtls();
	fetch_legend_value();

	fprintf(fp,"%c&l1O",ESC); /* Set Landscape*/ 
 	fprintf(fp, "%c(s20H", ESC);/* Reduce the font size*/
	fprintf(fp,"%c&a4L",ESC); 	/* To Set the Left margin  		*/

    print_param();
    open_det_cur();
   
    while(fetch_det_cur())
    {		
		print_rec();  
    }	
    /*if(bgftime != 0)
	  print_bg_catg_tot();*/

    print_tot();
    print_end();

	fprintf(fp,"%cE",ESC); /* To Reset the Printer */
 }


open_files()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00066.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00066.lis");
       proc_exit();
    }

}

declare_cur()
{
	
	/* EXEC SQL DECLARE DET_CUR CURSOR FOR
		SELECT a.patient_id, c.short_name patient_name,						//a.ext_acct_code, 
			   a.doc_type_code||'-'||to_char(a.doc_number)  rcpt_no,
			   to_char(a.doc_date, 'DD/MM/YYYY') rcpt_date,
			   a.doc_amt Deposit_paid,
			   a.EPISODE_TYPE, a.EPISODE_ID, a.VISIT_ID       
		//B.DOC_OUTST_AMT Deposit_Outstanding
		FROM BL_RECEIPT_REFUND_HDRDTL_VW a, BL_PATIENT_LEDGER B, MP_PATIENT_MAST C
		WHERE a.RECPT_REFUND_IND='R'
		AND   B.ORG_DOC_TYPE_CODE =A.DOC_TYPE_CODE
		AND   B.ORG_DOC_NUM=A.DOC_NUMBER
		and   A.RECPT_NATURE_CODE in ('AD','PR') and B.AD_PR_ADJ_BILL_DOC_TYPE is null
		and   B.DOC_OUTST_AMT < 0
		and   to_char(a.DOC_DATE, 'YYYY/MM/DD') BETWEEN to_char(TO_DATE(:nd_period_from,'DD/MM/YYYY'), 'YYYY/MM/DD') 
												AND     to_char(TO_DATE(:nd_period_to,'DD/MM/YYYY'), 'YYYY/MM/DD') 
		and   a.EPISODE_TYPE = decode(:nd_episode_type, 'A', a.episode_type, :nd_episode_type)
		and   NVL(a.CANCELLED_IND, 'N') != 'Y'
		and   a.PATIENT_ID = c.PATIENT_ID
		order by 1,2; */ 


	/* EXEC SQL DECLARE REF_CUR CURSOR FOR
	    SELECT DOC_TYPE_CODE||'-'||to_char(DOC_NUMBER) refund_doc, 
			   to_char(DOC_DATE, 'DD/MM/YYYY') refund_date, ABS(DOC_AMT) REFUND_AMT           
		FROM BL_RECEIPT_REFUND_HDRDTL_VW
		WHERE RECPT_REFUND_IND = 'F'
		AND   BILL_DOC_TYPE_CODE||'-'||TO_CHAR(BILL_DOC_NUMBER) = :d_receipt_no
		AND   NVL(CANCELLED_IND, 'N') != 'Y'
		order by 1; */ 

}

open_det_cur()
{
   /* EXEC SQL OPEN DET_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0004;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )106;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_period_from;
   sqlstm.sqhstl[0] = (unsigned int  )17;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_period_to;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[3] = (unsigned int  )4;
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
        err_mesg("OPEN failed on cursor DET_CUR",0,"");
}

open_ref_cur()
{
   /* EXEC SQL OPEN REF_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )137;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_receipt_no;
   sqlstm.sqhstl[0] = (unsigned int  )19;
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
        err_mesg("OPEN failed on cursor REF_CUR",0,"");
}

close_det_cur()
{
	/* EXEC SQL CLOSE DET_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )156;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   
}

close_ref_cur()
{
	/* EXEC SQL CLOSE REF_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )171;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

    
}

fetch_det_cur()
{ 

        d_patient_id.arr[0]		= '\0';	  
		d_patient_name.arr[0]   = '\0';
		d_receipt_no.arr[0]		= '\0';
		d_rcpt_date.arr[0]		= '\0';
		d_episode_type1.arr[0]  = '\0';

		d_patient_id.len		= 0;
		d_patient_name.len		= 0;
		d_receipt_no.len		= 0;
		d_rcpt_date.len  		= 0;
		d_episode_type1.len		= 0;

		d_patient_dep_amt		= 0;
	

	/* EXEC SQL FETCH  DET_CUR INTO 
		:d_patient_id,
		:d_patient_name,
		:d_receipt_no,	
		:d_rcpt_date,		
		:d_patient_dep_amt,
		:d_episode_type1,
		:d_episode_id,
		:d_visit_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )186;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_receipt_no;
 sqlstm.sqhstl[2] = (unsigned int  )19;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_rcpt_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_patient_dep_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_episode_type1;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_visit_id;
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
		err_mesg("FETCH failed on cursor DET_CUR ",0,"");	
    

	d_patient_id.arr[d_patient_id.len]				= '\0';
	d_patient_name.arr[d_patient_name.len]			= '\0';
	d_receipt_no.arr[d_receipt_no.len]				= '\0';
	d_rcpt_date.arr[d_rcpt_date.len]				= '\0';
	d_episode_type1.arr[d_episode_type1.len]		= '\0';

	
	return(LAST_ROW?0:1);   
}

fetch_ref_cur()
{ 

		d_refund_no.arr[0]		= '\0';
		d_refund_date.arr[0]	= '\0';

		d_refund_no.len			= 0;
		d_refund_date.len  		= 0;

		d_refund_amt			= 0;		

	/* EXEC SQL FETCH  REF_CUR INTO 
		:d_refund_no,	
		:d_refund_date,		
		:d_refund_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )233;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_refund_no;
 sqlstm.sqhstl[0] = (unsigned int  )19;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_refund_date;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_refund_amt;
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
		err_mesg("FETCH failed on cursor REF_CUR ",0,"");	
    
	d_refund_no.arr[d_refund_no.len]		= '\0';
	d_refund_date.arr[d_refund_date.len]	= '\0';

	return(LAST_ROW?0:1);   
}


print_rec()
{

    int first_ref=1, refund_yn=0;
    if (lctr > 40)
	   next_page();

	get_adm_visit_date();
    fprintf(fp,"%4d ",recctr);
    fprintf(fp,"%-20s %-60s %-15s",d_patient_id.arr,d_patient_name.arr, d_adm_visit_date.arr);
	fprintf(fp,"  ");
	print_formated(d_patient_dep_amt);
	fprintf(fp," ");

	//lctr++;

    fprintf(fp,"%16s(%10s) ",d_receipt_no.arr, d_rcpt_date.arr);

	open_ref_cur();
	d_refund_amt_tot = 0;



    while(fetch_ref_cur())
	{
	      if (first_ref==1)
		     fprintf(fp,"%16s(%10s)     ",d_refund_no.arr,d_refund_date.arr);
	      else	
		  {
		     fprintf(fp,"\n");  
		     fprintf(fp,"%161s(%10s)     ",d_refund_no.arr,d_refund_date.arr);		     
		  }
	      first_ref++;
	      print_formated(d_refund_amt);
         
		  d_refund_amt_tot += d_refund_amt;	
		  refund_yn++;      
	}


	close_ref_cur();
	first_ref=0;

	/* EXEC SQL SELECT :d_patient_dep_amt-:d_refund_amt_tot
			 into   :d_dep_balance
			 from   DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (:b0-:b1) into :b2  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )260;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_patient_dep_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_refund_amt_tot;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_dep_balance;
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


	
	if (refund_yn==0)
	horz_skip(54);
	else
     horz_skip(5);

	  // fprintf(fp,"                                                     ");
	print_formated(d_dep_balance);	

	fprintf(fp,"\n");
	lctr++;
	
	recctr++;

	d_patient_dep_amt_tot   += d_patient_dep_amt;
	d_dep_balance_tot		+= d_dep_balance;
	d_refund_amt_tot_tot    += d_refund_amt_tot;
}

print_tot()
{
   fprintf(fp,"%69s                                   --------------                                                                ---------------      ---------------\n"," ");
   fprintf(fp,"%99s     ",loc_legend[15]);
   print_formated(d_patient_dep_amt_tot); fprintf(fp,"%63s"," ");
   print_formated(d_refund_amt_tot_tot);horz_skip(5);
   print_formated(d_dep_balance_tot); 
   next_line(1);
   fprintf(fp,"%69s                                   --------------                                                                ---------------      ---------------\n"," ");
   next_line(1);
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
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM\
/YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,HEAD_OF_COMPANY_NAME into :b0,:b1,:b2\
,:b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )287;
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
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )326;
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
	date1_len=strlen(loc_legend[3]);
	horz_skip(s2-date1_len-12);
	fprintf(fp,"%s : %s", loc_legend[3],d_sysdate.arr);
    
	next_line(1);
	
	fprintf(fp,"OPR : %s", d_user.arr); 	
    user_len=strlen(d_user.arr);
	strcpy(v_rep_title,loc_legend[1]);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	//strcpy(v_as_on_date,nd_as_on_date.arr);
	//date_len= strlen(v_as_on_date);
	horz_skip(s1-user_len-6);
	fprintf(fp,"%s",v_rep_title);
   	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-17);
	fprintf(fp," %-4s :   %-10s",loc_legend[2],d_curr_date.arr);
	next_line(1);

	fprintf(fp,"REP : %s",d_curr_pgm_name.arr);
        pgm_len=strlen(d_curr_pgm_name.arr);
	
	//sprintf(v_sub_title, "PERIOD FROM  : %2d - %2d year",nd_from_year,nd_to_year); 
	//strcpy(v_sub_title,d_head_name.arr);
	//sub_title_len = strlen(v_sub_title);
	//s1 = (REP_WIDTH-sub_title_len)/2;
   	//horz_skip(s1-pgm_len-6);
    //fprintf(fp,"%s",v_sub_title);

        s2 = (REP_WIDTH-5);
	    horz_skip(s2-28);
		fprintf(fp,"%5s :  %9d",loc_legend[4],++page_no);
	next_line(1);
	//fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 			*/

    //fprintf(fp,"%c(s-3B",ESC); /* release bold style */
   
	lctr = 6;
	print_line('-',REP_WIDTH); next_line(1);

	
}


print_column_title()
 {

  //no.ID, name
  fprintf(fp, "%-4s%-22s%-60s %-15s%16s  %28s %48s %20s",loc_legend[5],loc_legend[6],loc_legend[7],loc_legend[10],loc_legend[8],loc_legend[9],loc_legend[11],loc_legend[13]);
  next_line(1);

  fprintf(fp, "%178s",loc_legend[12]);
  next_line(1);

  print_line('-',REP_WIDTH);
  next_line(1);

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

  d_episode_type.arr[0]		= '\0';	  
  d_episode_type.len		= 0;

  if (strcmp(nd_episode_type.arr,"I")==0)
	 strcpy(d_episode_type.arr, "Inpatient");
  else if (strcmp(nd_episode_type.arr,"D")==0)
	 strcpy(d_episode_type.arr, "DayCare");	
  else if (strcmp(nd_episode_type.arr,"O")==0)
	 strcpy(d_episode_type.arr, "Outpatient");	
  else if (strcmp(nd_episode_type.arr,"E")==0)
	 strcpy(d_episode_type.arr, "Emergency");	
  else if (strcmp(nd_episode_type.arr,"R")==0)
	 strcpy(d_episode_type.arr, "External");	
  else if (strcmp(nd_episode_type.arr,"A")==0)
	 strcpy(d_episode_type.arr, "All");	

  d_episode_type.len = strlen(d_episode_type.arr);

  fprintf(fp,"                EPISODE_TYPE : %s\n",d_episode_type.arr);  
  fprintf(fp,"                PERIOD_FROM  : %s\n",nd_period_from.arr);  
  fprintf(fp,"                PERIOD TO    : %s",nd_period_to.arr);

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
	lctr=0;
	fprintf(fp,"\n"); 
	 
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
  fprintf(fp,"\n \n");
  horz_skip(98);

  fprintf(fp,"**   END  OF  REPORT   **");
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

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00066.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00066.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )341;
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
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM'\
 , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value\
 , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )364;
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


get_adm_visit_date()
{

   d_adm_visit_date.arr[0] = '\0';
   d_adm_visit_date.len    = 0;

   if ((strcmp(d_episode_type1.arr, "I")==0)||(strcmp(d_episode_type1.arr, "D")==0))
   {
      
	  /* EXEC SQL select to_char(ADMISSION_DATE_TIME, 'DD/MM/YYYY')
			   into   :d_adm_visit_date
			   from   BL_EPISODE_FIN_DTLS
			   where  operating_facility_id = :nd_facility_id
			   and    episode_type = :d_episode_type1
			   and    episode_id   = :d_episode_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select to_char(ADMISSION_DATE_TIME,'DD/MM/YYYY') into :b0\
  from BL_EPISODE_FIN_DTLS where ((operating_facility_id=:b1 and episode_type\
=:b2) and episode_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )395;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_adm_visit_date;
   sqlstm.sqhstl[0] = (unsigned int  )22;
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
   sqlstm.sqhstv[2] = (         void  *)&d_episode_type1;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
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

			   
   }
   else if ((strcmp(d_episode_type1.arr, "O")==0)||(strcmp(d_episode_type1.arr, "E")==0))
   {
	  /* EXEC SQL select to_char(VISIT_REGN_DATE_TIME, 'DD/MM/YYYY')
			   into   :d_adm_visit_date
			   from   OP_VISIT
			   where  facility_id = :nd_facility_id
			   and    episode_id  = :d_episode_id
			   and    visit_id    = :d_visit_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select to_char(VISIT_REGN_DATE_TIME,'DD/MM/YYYY') into :b\
0  from OP_VISIT where ((facility_id=:b1 and episode_id=:b2) and visit_id=:b3\
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )426;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_adm_visit_date;
   sqlstm.sqhstl[0] = (unsigned int  )22;
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
   sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
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

			   

   }

   d_adm_visit_date.arr[d_adm_visit_date.len]	= '\0';

}