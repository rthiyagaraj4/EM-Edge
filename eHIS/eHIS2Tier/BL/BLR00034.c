
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
           char  filnam[15];
};
static const struct sqlcxp sqlfpn =
{
    14,
    "d:\\blr00034.pc"
};


static unsigned long sqlctx = 1122923;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {10,11};

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
"select (CASH_COUNTER_CODE||')') ,TO_CHAR(DOC_DATE,'DD/MM/YYYY HH24:MI:SS') T\
rx_date ,((DOC_TYPE_CODE||'/')||to_char(DOC_NUMBER)) ,DOC_AMT ,EXT_ACCT_CODE ,\
BANK_IN_DOC_NO ,to_char(BANK_IN_DATE,'DD/MM/YYYY') ,doc_date  from BL_RECPT_RE\
FUND_CAN_BOU_DTL_VW where ((((trunc(DOC_DATE) between TO_DATE(:b0,'DD/MM/YYYY'\
) and TO_DATE(:b1,'DD/MM/YYYY') and SLMT_TYPE_CODE in (select SLMT_TYPE_CODE  \
from BL_SLMT_TYPE where CASH_SLMT_FLAG<>DECODE(:b2,'Y','A','$'))) and (((BANK_\
IN_BATCH_DOC_NO=BANK_IN_BATCH_DOC_NO and :b3='1') or (BANK_IN_BATCH_DOC_NO is \
null  and :b3='2')) or :b3='3')) and CASH_COUNTER_CODE between :b6 and :b7) an\
d ADDED_BY_ID=nvl(:b8,ADDED_BY_ID)) order by doc_date            ";

 static const char *sq0006 = 
"select EXT_ACCT_CODE ,sum(DOC_AMT)  from BL_RECPT_REFUND_CAN_BOU_DTL_VW wher\
e ((((trunc(DOC_DATE) between TO_DATE(:b0,'DD/MM/YYYY') and TO_DATE(:b1,'DD/MM\
/YYYY') and SLMT_TYPE_CODE in (select SLMT_TYPE_CODE  from BL_SLMT_TYPE where \
CASH_SLMT_FLAG<>DECODE(:b2,'Y','A','$'))) and (((BANK_IN_BATCH_DOC_NO=BANK_IN_\
BATCH_DOC_NO and :b3='1') or (BANK_IN_BATCH_DOC_NO is null  and :b3='2')) or :\
b3='3')) and CASH_COUNTER_CODE between :b6 and :b7) and ADDED_BY_ID=nvl(:b8,AD\
DED_BY_ID)) group by EXT_ACCT_CODE order by EXT_ACCT_CODE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,97,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,194,0,4,137,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
1,0,0,2,1,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
95,0,0,3,84,0,2,160,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
122,0,0,4,0,0,30,193,0,0,0,0,0,1,0,
137,0,0,5,687,0,9,317,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,
1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
188,0,0,5,0,0,15,325,0,0,0,0,0,1,0,
203,0,0,6,535,0,9,330,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,
1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
254,0,0,6,0,0,15,338,0,0,0,0,0,1,0,
269,0,0,5,0,0,13,361,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,
316,0,0,6,0,0,13,392,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
339,0,0,7,188,0,4,649,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
378,0,0,8,71,0,4,678,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
401,0,0,9,108,0,4,696,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
428,0,0,10,108,0,4,702,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
455,0,0,11,96,0,4,766,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
478,0,0,12,162,0,6,773,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00034.PC                                  */
/* AUTHOR                : Jagwinder Kaur                               */  
/* DATE WRITTEN          : 30/06/2004                                   */      
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
/*
#define DEBUG 0
*/

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
	    bl_doc_no						[19],
	    bl_bank_doc_no					[21],
	    bl_doc_date						[11],
	    b1_doc_date_1[30],
	    bl_bank_doc_date				[11],
	    bl_acct_code					[11],
	    bl_summ_acct_code				[11],
	    acct_desc						[61],
	    nd_fm_date						[11],
	    nd_to_date						[11],
	    l_translated_value				[201],
	    l_cash_book_acc_desc			[16],
	    l_pk_value						[100],
	    temp_doc_date					[11],
	    old_doc_date					[11],
	    nd_user							[31],
	    nd_fm_cash_counter				[3],
	    nd_to_cash_counter				[3],
	    base_curr						[9],
	    cc_fm_desc						[31],
	    cc_to_desc						[31],
	    nd_subtitle[100],
	    d_cash_counter_code				[4],
		p_language_id                   [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[19]; } bl_doc_no;

struct { unsigned short len; unsigned char arr[21]; } bl_bank_doc_no;

struct { unsigned short len; unsigned char arr[11]; } bl_doc_date;

struct { unsigned short len; unsigned char arr[30]; } b1_doc_date_1;

struct { unsigned short len; unsigned char arr[11]; } bl_bank_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bl_acct_code;

struct { unsigned short len; unsigned char arr[11]; } bl_summ_acct_code;

struct { unsigned short len; unsigned char arr[61]; } acct_desc;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[16]; } l_cash_book_acc_desc;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[11]; } temp_doc_date;

struct { unsigned short len; unsigned char arr[11]; } old_doc_date;

struct { unsigned short len; unsigned char arr[31]; } nd_user;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_cash_counter;

struct { unsigned short len; unsigned char arr[3]; } nd_to_cash_counter;

struct { unsigned short len; unsigned char arr[9]; } base_curr;

struct { unsigned short len; unsigned char arr[31]; } cc_fm_desc;

struct { unsigned short len; unsigned char arr[31]; } cc_to_desc;

struct { unsigned short len; unsigned char arr[100]; } nd_subtitle;

struct { unsigned short len; unsigned char arr[4]; } d_cash_counter_code;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

			
			
double      bl_doc_amt,tot_amt,bl_acct_doc_amt,tot_acct_amt,g_tot_amt;
char exclude_credit_card_trn,print_flag;			
int i;
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char fm_date[11],to_date[11];
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
int    first = 1;

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
 
    strcpy(g_pgm_id,"BLR00034");
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


		nd_fm_date.arr[0]			= '\0';
		nd_to_date.arr[0]			= '\0';
		
		nd_fm_date.len			= 0;
		nd_to_date.len			= 0;

		nd_subtitle.arr[0] = '\0';
		nd_subtitle.len = 0;

		
        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM7,PARAM8||PARAM9
		 INTO	:nd_fm_date,
			:nd_to_date,
			:nd_fm_cash_counter,
			:nd_to_cash_counter,
			:nd_user,
			:exclude_credit_card_trn,
			:print_flag,:nd_subtitle
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
 ,PARAM7 ,(PARAM8||PARAM9) into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_\
PARAM where ((PGM_ID=:b8 and SESSION_ID=:b9) and PGM_DATE=:b10)";
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
        sqlstm.sqhstv[2] = (         void  *)&nd_fm_cash_counter;
        sqlstm.sqhstl[2] = (unsigned int  )5;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_to_cash_counter;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_user;
        sqlstm.sqhstl[4] = (unsigned int  )33;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&exclude_credit_card_trn;
        sqlstm.sqhstl[5] = (unsigned int  )1;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&print_flag;
        sqlstm.sqhstl[6] = (unsigned int  )1;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_subtitle;
        sqlstm.sqhstl[7] = (unsigned int  )102;
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

	nd_fm_date.arr[nd_fm_date.len]	= '\0';
	nd_to_date.arr[nd_to_date.len]	= '\0';
	nd_subtitle.arr[nd_subtitle.len] = '\0';		 

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
   

    	declare_cur();

    	fetch_hosp_name();

		fetch_legend_value();

		fetch_cash_counter_desc();

    	open_file();		

		open_cur();

		print_head();
		        
	    print_dtl();

		print_summ_head();

		print_acct_dtl();

	    end_of_rep();

		close_cur();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )122;
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

	/*
	EXEC SQL DECLARE BL_REC_REF_CUR CURSOR FOR
	SELECT	CASH_COUNTER_CODE||')',
	        TO_CHAR(DOC_DATE,'DD/MM/YYYY HH24:MI:SS')Trx_date,
		 DOC_TYPE_CODE||'/'||to_char(DOC_NUMBER),
		 DOC_AMT,
		 EXT_ACCT_CODE,
		 BANK_IN_DOC_NO,
		 to_char(BANK_IN_DATE,'DD/MM/YYYY'),
		 doc_date
	FROM	BL_RECEIPT_REFUND_DTL_VW
	WHERE	trunc(DOC_DATE) BETWEEN TO_DATE(:nd_fm_date,'DD/MM/YYYY') AND
            TO_DATE(:nd_to_date,'DD/MM/YYYY')
	AND		SLMT_TYPE_CODE IN (SELECT SLMT_TYPE_CODE FROM BL_SLMT_TYPE
			WHERE CASH_SLMT_FLAG != DECODE(:exclude_credit_card_trn ,'Y'
			, 'A' , '$' ))
    AND     ((BANK_IN_BATCH_DOC_NO =  BANK_IN_BATCH_DOC_NO AND
	             :print_flag = '1') OR (BANK_IN_BATCH_DOC_NO IS NULL AND :print_flag = '2')
              OR :print_flag = '3')
	AND    RECPT_REFUND_IND = 'R'
	AND		CASH_COUNTER_CODE between  :nd_fm_cash_counter and :nd_to_cash_counter
	AND		ADDED_BY_ID = nvl(:nd_user,ADDED_BY_ID)

	UNION ALL
	SELECT a.CASH_COUNTER_CODE||')',	
	 TO_CHAR(b.CANCELLED_DATE,'DD/MM/YYYY HH24:MI:SS')trx_date,
			b.DOC_TYPE_CODE||'/'||TO_CHAR(b.DOC_NUMBER),
			a.DOC_AMT * -1,
			a.EXT_ACCT_CODE,
			a.BANK_IN_DOC_NO,
			to_char(a.BANK_IN_DATE,'DD/MM/YYYY'),
			b.CANCELLED_DATE doc_date
	FROM	BL_RECEIPT_REFUND_DTL_VW a, BL_CANCELLED_BOUNCED_TRX b
	WHERE	a.DOC_TYPE_CODE = b.DOC_TYPE_CODE
	AND		a.DOC_NUMBER = b.DOC_NUMBER
	AND		(a.cancelled_ind = 'Y' or a.bounced_yn = 'Y')
	AND		trunc(b.CANCELLED_DATE)
	BETWEEN TO_DATE(:nd_fm_date,'DD/MM/YYYY') AND
            TO_DATE(:nd_to_date,'DD/MM/YYYY')
	AND		a.SLMT_TYPE_CODE IN (SELECT SLMT_TYPE_CODE FROM BL_SLMT_TYPE
	WHERE   CASH_SLMT_FLAG != DECODE(:exclude_credit_card_trn ,'Y'
			, 'A' , '$' ))
	AND     ((a.BANK_IN_BATCH_DOC_NO =  a.BANK_IN_BATCH_DOC_NO AND
	             :print_flag = '1') OR (a.BANK_IN_BATCH_DOC_NO IS NULL AND :print_flag = '2')
              OR :print_flag = '3')
	AND    a.RECPT_REFUND_IND       = 'R'
	AND		a.CASH_COUNTER_CODE between  :nd_fm_cash_counter and :nd_to_cash_counter
	AND		a.ADDED_BY_ID = nvl(:nd_user,a.ADDED_BY_ID)	
	ORDER BY doc_date;*/

	/* EXEC SQL DECLARE BL_REC_REF_CUR CURSOR FOR
	SELECT	CASH_COUNTER_CODE||')',
	        TO_CHAR(DOC_DATE,'DD/MM/YYYY HH24:MI:SS')Trx_date,
		 DOC_TYPE_CODE||'/'||to_char(DOC_NUMBER),
		 DOC_AMT,
		 EXT_ACCT_CODE,
		 BANK_IN_DOC_NO,
		 to_char(BANK_IN_DATE,'DD/MM/YYYY'),
		 doc_date
	FROM	BL_RECPT_REFUND_CAN_BOU_DTL_VW 
	WHERE	trunc(DOC_DATE) BETWEEN TO_DATE(:nd_fm_date,'DD/MM/YYYY') AND
               TO_DATE(:nd_to_date,'DD/MM/YYYY')
	AND    SLMT_TYPE_CODE IN (SELECT SLMT_TYPE_CODE FROM BL_SLMT_TYPE
		                  WHERE CASH_SLMT_FLAG != DECODE(:exclude_credit_card_trn ,
					                    'Y'	, 'A' , '$' ))
        AND     ((BANK_IN_BATCH_DOC_NO =  BANK_IN_BATCH_DOC_NO AND
	             :print_flag = '1') OR (BANK_IN_BATCH_DOC_NO IS NULL AND :print_flag = '2')
              OR :print_flag = '3')	
	AND		CASH_COUNTER_CODE between  :nd_fm_cash_counter and :nd_to_cash_counter
	AND		ADDED_BY_ID = nvl(:nd_user,ADDED_BY_ID)
	ORDER BY doc_date; */ 


	/*
	EXEC SQL DECLARE ACCT_CUR CURSOR FOR
	SELECT      EXT_ACCT_CODE,sum(DOC_AMT)
	FROM    BL_RECEIPT_REFUND_DTL_VW
	WHERE   trunc(DOC_DATE) BETWEEN TO_DATE(:nd_fm_date,'DD/MM/YYYY') AND
            TO_DATE(:nd_to_date,'DD/MM/YYYY')
	AND             SLMT_TYPE_CODE IN (SELECT SLMT_TYPE_CODE FROM BL_SLMT_TYPE
                   WHERE CASH_SLMT_FLAG != DECODE(:exclude_credit_card_trn ,'Y'
                   , 'A' , '$' ))
    AND     ((BANK_IN_BATCH_DOC_NO =  BANK_IN_BATCH_DOC_NO AND
                :print_flag = '1') OR (BANK_IN_BATCH_DOC_NO IS NULL AND :print_flag = '2')
              OR :print_flag = '3')
    AND (DOC_TYPE_CODE,DOC_NUMBER) NOT IN(SELECT DOC_TYPE_CODE,DOC_NUMBER
                                      FROM BL_CANCELLED_BOUNCED_TRX
                                      WHERE TRUNC(CANCELLED_DATE) BETWEEN
                                   TO_DATE(:nd_fm_date,'DD/MM/YYYY') AND
                                   TO_DATE(:nd_to_date,'DD/MM/YYYY')
				   AND RECPT_REFUND_IND = 'R')
	AND    RECPT_REFUND_IND = 'R'
	AND	   CASH_COUNTER_CODE   between  :nd_fm_cash_counter and :nd_to_cash_counter
	AND	   ADDED_BY_ID = nvl(:nd_user,ADDED_BY_ID)
	GROUP BY EXT_ACCT_CODE
	ORDER BY EXT_ACCT_CODE;*/

	/* EXEC SQL DECLARE ACCT_CUR CURSOR FOR
	SELECT      EXT_ACCT_CODE,sum(DOC_AMT)
	FROM    BL_RECPT_REFUND_CAN_BOU_DTL_VW
	WHERE   trunc(DOC_DATE) BETWEEN TO_DATE(:nd_fm_date,'DD/MM/YYYY') AND
            TO_DATE(:nd_to_date,'DD/MM/YYYY')
	AND             SLMT_TYPE_CODE IN (SELECT SLMT_TYPE_CODE FROM BL_SLMT_TYPE
                   WHERE CASH_SLMT_FLAG != DECODE(:exclude_credit_card_trn ,'Y'
                   , 'A' , '$' ))
    AND     ((BANK_IN_BATCH_DOC_NO =  BANK_IN_BATCH_DOC_NO AND
                :print_flag = '1') OR (BANK_IN_BATCH_DOC_NO IS NULL AND :print_flag = '2')
              OR :print_flag = '3')  
	AND	   CASH_COUNTER_CODE   between  :nd_fm_cash_counter and :nd_to_cash_counter
	AND	   ADDED_BY_ID = nvl(:nd_user,ADDED_BY_ID)
	GROUP BY EXT_ACCT_CODE
	ORDER BY EXT_ACCT_CODE; */ 

}


open_cur() 
{
	/* EXEC SQL OPEN BL_REC_REF_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
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
 sqlstm.sqhstv[2] = (         void  *)&exclude_credit_card_trn;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&print_flag;
 sqlstm.sqhstl[3] = (unsigned int  )1;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&print_flag;
 sqlstm.sqhstl[4] = (unsigned int  )1;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&print_flag;
 sqlstm.sqhstl[5] = (unsigned int  )1;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_fm_cash_counter;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_to_cash_counter;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_user;
 sqlstm.sqhstl[8] = (unsigned int  )33;
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
         err_mesg("OPEN failed on cursor BL_REC_REF_CUR",0,"");
}

close_cur() 
{
	/* EXEC SQL CLOSE BL_REC_REF_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )188;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   
}

open_acct_cur() 
{
	/* EXEC SQL OPEN ACCT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )203;
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
 sqlstm.sqhstv[2] = (         void  *)&exclude_credit_card_trn;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&print_flag;
 sqlstm.sqhstl[3] = (unsigned int  )1;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&print_flag;
 sqlstm.sqhstl[4] = (unsigned int  )1;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&print_flag;
 sqlstm.sqhstl[5] = (unsigned int  )1;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_fm_cash_counter;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_to_cash_counter;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_user;
 sqlstm.sqhstl[8] = (unsigned int  )33;
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
         err_mesg("OPEN failed on cursor ACCT_CUR",0,"");
}

close_acct_cur() 
{
	/* EXEC SQL CLOSE ACCT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )254;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   
}


fetch_cur()
{
	bl_doc_date.arr[0]		= '\0';
	bl_doc_no.arr[0]		= '\0';
	bl_acct_code.arr[0]		= '\0';
	bl_bank_doc_no.arr[0]	= '\0';
	bl_bank_doc_date.arr[0]	= '\0';
	d_cash_counter_code.arr[0]  = '\0';
	b1_doc_date_1.arr[0] = '\0';

	bl_doc_date.len			= 0;
	bl_doc_no.len			= 0;
	bl_acct_code.len		= 0;
	bl_bank_doc_no.len		= 0;
	bl_bank_doc_date.len	= 0;
	bl_doc_amt           = 0;
	d_cash_counter_code.len  =0;
	b1_doc_date_1.len = 0;

      /* EXEC SQL FETCH BL_REC_REF_CUR
               INTO :d_cash_counter_code,            
	                :bl_doc_date,
					:bl_doc_no,
					:bl_doc_amt,
					:bl_acct_code,
					:bl_bank_doc_no,
			   		:bl_bank_doc_date,
					:b1_doc_date_1; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 11;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )269;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_cash_counter_code;
      sqlstm.sqhstl[0] = (unsigned int  )6;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_doc_date;
      sqlstm.sqhstl[1] = (unsigned int  )13;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_doc_no;
      sqlstm.sqhstl[2] = (unsigned int  )21;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_doc_amt;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_acct_code;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_bank_doc_no;
      sqlstm.sqhstl[5] = (unsigned int  )23;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_bank_doc_date;
      sqlstm.sqhstl[6] = (unsigned int  )13;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&b1_doc_date_1;
      sqlstm.sqhstl[7] = (unsigned int  )32;
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
            err_mesg("FETCH failed on cursor BL_REC_REF_CUR",0,"");

    bl_doc_date.arr[bl_doc_date.len]			= '\0';
	bl_doc_no.arr[bl_doc_no.len]				= '\0';
	bl_acct_code.arr[bl_acct_code.len]			= '\0';
	bl_bank_doc_no.arr[bl_bank_doc_no.len]		= '\0';
	bl_bank_doc_date.arr[bl_bank_doc_date.len]	= '\0';
	d_cash_counter_code.arr[d_cash_counter_code.len]  = '\0';
	b1_doc_date_1.arr[b1_doc_date_1.len] = '\0';

    return(LAST_ROW?0:1);
}

fetch_acct_cur()
{
	bl_summ_acct_code.arr[0]	= '\0';
	bl_summ_acct_code.len		= 0;

	bl_acct_doc_amt           = 0;

      /* EXEC SQL FETCH ACCT_CUR
               INTO :bl_summ_acct_code,
					:bl_acct_doc_amt; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 11;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )316;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_summ_acct_code;
      sqlstm.sqhstl[0] = (unsigned int  )13;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_acct_doc_amt;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
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
            err_mesg("FETCH failed on cursor ACCT_CUR",0,"");

	bl_summ_acct_code.arr[bl_summ_acct_code.len]			= '\0';

    return(LAST_ROW?0:1);
}

print_dtl()
{
	tot_amt = 0;
	open_cur();
    
	while(fetch_cur())
	{
		if (first)
		{
			strcpy(old_doc_date.arr,bl_doc_date.arr);
			first = 0;
		}

		if (strcmp(bl_doc_date.arr,old_doc_date.arr) != 0) 
			print_daily_total();
		
		check_page_end(1,0);
		fprintf(fp,"%-10s %-14s (%-3s %-10s",
			bl_doc_date.arr,
			bl_doc_no.arr,
			d_cash_counter_code.arr,
			bl_acct_code.arr);

        print_formated(bl_doc_amt);

		//Commented by Harish on 15/07/2004 - To make the report as per the 
		//format given by MOH, Malaysia
		//fprintf(fp,"%-20s %-10s \n",bl_bank_doc_no.arr,bl_bank_doc_date.arr);

		fprintf(fp,"%-20s %-10s \n"," "," ");

		lctr=lctr+1;
		tot_amt = tot_amt + bl_doc_amt;
		
		strcpy(old_doc_date.arr,bl_doc_date.arr);
		old_doc_date.len=strlen(old_doc_date.arr);

       }

   print_daily_total();
   print_total();
}


print_daily_total()
{
    check_page_end(3,0);
	fprintf(fp,"%-56s %-15s\n"," ","---------------");
	fprintf(fp,"%44s %12s",loc_legend[14]," ");
	print_formated(tot_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-56s %-15s\n"," ","---------------");
	lctr=lctr+3;
	g_tot_amt = g_tot_amt + tot_amt;
	tot_amt = 0; 
	
}   

print_total()
{
    check_page_end(3,0);
	fprintf(fp,"%-56s %-15s\n"," ","---------------");
	fprintf(fp,"%44s %12s",loc_legend[17]," ");
	print_formated(g_tot_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-56s %-15s\n"," ","---------------");
	lctr=lctr+3;
	g_tot_amt = 0;
	check_page_end(1,0);
	fprintf(fp,"\n");
	lctr=lctr+1; 
}   

print_summ_head()
{
    check_page_end(3,0);
	fprintf(fp,"%-5s %s\n"," ","==========================================================================================");
	fprintf(fp,"%-5s %-25s%40s%19s%3s\n"," ",loc_legend[23]," ",loc_legend[13],base_curr.arr);
	fprintf(fp,"%-5s %s\n"," ","==========================================================================================");
	lctr=lctr+3;
}   

print_acct_dtl()
{
tot_acct_amt = 0;
open_acct_cur();
     while(fetch_acct_cur())
	  {
	   fetch_acct_desc();
	   check_page_end(1,0);
       fprintf(fp,"%-5s %-10s %-60s "," ",bl_summ_acct_code.arr,acct_desc.arr);
        print_formated(bl_acct_doc_amt);
		fprintf(fp,"\n");
		lctr=lctr+1;
		tot_acct_amt = tot_acct_amt + bl_acct_doc_amt;
       }
   print_acct_total();
}


print_acct_total()
{
    check_page_end(3,0);
	fprintf(fp,"%-78s%-15s\n"," ","---------------");
	fprintf(fp,"%78s",loc_legend[17]);
	print_formated(tot_acct_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-78s%-15s\n"," ","---------------");
	lctr=lctr+3;

}   

end_of_rep()
{
	check_page_end(3,0);
	fprintf(fp,"\n\n %35s   ***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00034.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00034.lis");
       proc_exit();
    }
}

print_head()
{
	print_page_title();
	fprintf(fp,"---------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(fp," %-30s %-10s %-55s %-10s \n"," ",loc_legend[8]," ",loc_legend[9]);
	fprintf(fp," %-10s %-14s      %-10s%15s  %-15s%-10s%-25s %-20s\n",loc_legend[10],loc_legend[11],loc_legend[12],loc_legend[13],loc_legend[14],loc_legend[10],loc_legend[15],loc_legend[16]);
	fprintf(fp," %-10s %-14s      %-10s %15s  %-6s %6s %-4s       %-18s  %-20s\n"," "," "," ",base_curr.arr," ",base_curr.arr," ",loc_legend[21],loc_legend[22]);
	fprintf(fp,"---------------------------------------------------------------------------------------------------------------------------------------\n");
	fflush(fp); 
	lctr = 8;
}

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;

	l_report_width=132;
	l_acc_entity_length = strlen(hosp_name.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	fprintf(fp,"MDL           : BL");
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",hosp_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[3],date.arr);

	//Code for Line 2
	
	l_start_point=0;

	l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[1]))/2))-((strlen(nd_fm_date.arr)+strlen(nd_to_date.arr)+strlen(loc_legend[7]) + 2)/2);
	fprintf(fp,"OPR           : %s",user_id.arr);
	l_start_point=l_start_point-(strlen(user_id.arr)+16);
	print_spaces(l_start_point);
	fprintf(fp,"%s %s %s %s",loc_legend[1],nd_fm_date.arr,loc_legend[7],nd_to_date.arr);
	
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[1])+strlen(loc_legend[7])+strlen(nd_fm_date.arr)+strlen(nd_to_date.arr)+2;
	
	l_start_point=(l_report_width-(18+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[4],date_time.arr);
    
	//Code for Line 3
	l_start_point=0;
	
	if (nd_subtitle.arr[0] == '\0')
	{
		l_start_point=ceill(l_report_width/2)-((strlen(loc_legend[18])+2+strlen(cc_fm_desc.arr)+strlen(cc_to_desc.arr))/2);
		fprintf(fp,"%-14.14s: BLR00034",loc_legend[2]);
		l_start_point=l_start_point-24;
		print_spaces(l_start_point);

		fprintf(fp,"%s : %s ",loc_legend[18],cc_fm_desc.arr);
		fprintf(fp,"%s %s",loc_legend[7],cc_to_desc.arr);
		l_comp_name_end_point=l_start_point+26+strlen(loc_legend[18])+strlen(cc_fm_desc.arr)+strlen(loc_legend[7])+strlen(cc_to_desc.arr)+2;

		l_start_point=(l_report_width-(17+9)-l_comp_name_end_point);
		print_spaces(l_start_point);
		fprintf(fp,"%-15.15s : %d\n",loc_legend[5],++pctr);
	}
	else
	{
		l_start_point=ceill(l_report_width/2)-((strlen(nd_subtitle.arr))/2);
		fprintf(fp,"%-14.14s: BLR00034",loc_legend[2]);
		l_start_point=l_start_point-24;
		print_spaces(l_start_point);

		fprintf(fp,"%s",nd_subtitle.arr);
		l_comp_name_end_point=l_start_point+24+strlen(nd_subtitle.arr);

		l_start_point=(l_report_width-(25)-l_comp_name_end_point);
		print_spaces(l_start_point);
		fprintf(fp,"%-15.15s : %d\n",loc_legend[5],++pctr);		
	}	

	//Code for Line 4

	l_start_point=0;
	l_start_point=ceill(l_report_width/2)-((strlen(loc_legend[26])+
						strlen(nd_user.arr))/2);
	print_spaces(l_start_point);
	fprintf(fp,"%s\n",loc_legend[26]);
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
	base_curr.arr[0] = '\0';

    hosp_name.len    = 0;
    date_time.len    = 0;
	date.len		 = 0;
    user_id.len      = 0;
	base_curr.len    = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME,//ACCOUNTING_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/RRRR'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
                    USER,
					'('||BASE_CURRENCY||')'
               INTO :hosp_name, 
					:date,
					:date_time, 
					:user_id,
					:base_curr
               FROM SY_ACC_ENTITY
	          WHERE ACC_ENTITY_ID = :nd_facility; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/RRRR') ,TO\
_CHAR(SYSDATE,'HH24:MI:SS') ,USER ,(('('||BASE_CURRENCY)||')') into :b0,:b1,:b\
2,:b3,:b4  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b5";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )339;
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
    sqlstm.sqhstv[4] = (         void  *)&base_curr;
    sqlstm.sqhstl[4] = (unsigned int  )11;
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
}



    if (OERROR) 
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	date.arr[date.len]					   = '\0';
	user_id.arr[user_id.len]               = '\0';
	base_curr.arr[base_curr.len]           = '\0';

}

fetch_acct_desc()
{
    acct_desc.arr[0] = '\0';
    acct_desc.len    = 0;
    
    /* EXEC SQL SELECT ACCT_DESC
			 INTO :acct_desc
             FROM BL_EXT_ACCT_CODE
	         WHERE ACCOUNT_CODE = :bl_summ_acct_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCT_DESC into :b0  from BL_EXT_ACCT_CODE where AC\
COUNT_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )378;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&acct_desc;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_summ_acct_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
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
		err_mesg("SELECT failed on table BL_EXT_ACCT_CODE",0,"");

	acct_desc.arr[acct_desc.len]           = '\0';
}

fetch_cash_counter_desc()
{
    cc_fm_desc.arr[0] = '\0';
    cc_fm_desc.len    = 0;
	 cc_to_desc.arr[0] = '\0';
    cc_to_desc.len    = 0;
    
    /* EXEC SQL SELECT short_desc
			 INTO :cc_fm_desc
             FROM BL_CASH_COUNTER
	         WHERE operating_facility_id = :nd_facility
			 and CASH_COUNTER_CODE = :nd_fm_cash_counter; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select short_desc into :b0  from BL_CASH_COUNTER where (o\
perating_facility_id=:b1 and CASH_COUNTER_CODE=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )401;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&cc_fm_desc;
    sqlstm.sqhstl[0] = (unsigned int  )33;
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
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_cash_counter;
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



   /* EXEC SQL SELECT short_desc 
			 INTO :cc_to_desc
             FROM BL_CASH_COUNTER
	         WHERE operating_facility_id = :nd_facility
			 and CASH_COUNTER_CODE = :nd_to_cash_counter; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from BL_CASH_COUNTER where (op\
erating_facility_id=:b1 and CASH_COUNTER_CODE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )428;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&cc_to_desc;
   sqlstm.sqhstl[0] = (unsigned int  )33;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_to_cash_counter;
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
		err_mesg("SELECT failed on table BL_CASH_COUNTER",0,"");

    	cc_fm_desc.arr[cc_fm_desc.len]           = '\0';
		cc_to_desc.arr[cc_to_desc.len]           = '\0';
}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s  ",str_amt);
    }
}                        

check_page_end(l_lead_lines, l_print_flag)
int l_lead_lines;
int	l_print_flag;
{
	if(l_print_flag==1)
		l_lead_lines=l_lead_lines+10;

	if((lctr+l_lead_lines)> 52) 
	{
		fprintf(fp,"\f\n");
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

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00034.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00034.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )455;
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
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )478;
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




