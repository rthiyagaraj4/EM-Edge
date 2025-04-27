
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
    "C:\\10xdev\\BLR00097.PC"
};


static unsigned long sqlctx = 139592419;


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

 static const char *sq0006 = 
"select a.BANK_CODE ,b.BANK_NAME ,a.BANK_IN_BATCH_DOC_TYPE ,a.BANK_IN_BATCH_\
DOC_NO ,a.BANK_IN_AMT ,((a.BANK_IN_BATCH_DOC_TYPE||'/')||a.BANK_IN_BATCH_DOC_\
NO) docno ,to_char(a.bank_in_date,'dd/mm/yyyy') ,a.bank_in_doc_no  from bl_ba\
nk_in_doc a ,sy_acc_entity c ,bl_bank_name b where ((((((a.operating_facility\
_id=:b0 and c.acc_entity_id=a.operating_facility_id) and a.bank_code=b.bank_c\
ode(+)) and nvl(a.bank_code,'!!!!')=:b1) and a.BANK_IN_BATCH_DOC_TYPE=decode(\
:b2,'!!!!',a.BANK_IN_BATCH_DOC_TYPE,:b2)) and to_char(a.BANK_IN_BATCH_DOC_NO)\
=decode(:b4,'!!!!',to_char(a.BANK_IN_BATCH_DOC_NO),:b4)) and a.BANK_IN_BATCH_\
DOC_DATE=:b6) order by a.SLMT_TYPE_CODE,a.BANK_IN_BATCH_DOC_DATE,a.BANK_IN_BA\
TCH_DOC_TYPE,a.BANK_IN_BATCH_DOC_NO            ";

 static const char *sq0007 = 
"select a.BANK_IN_BATCH_DOC_TYPE ,a.BANK_IN_BATCH_DOC_NO ,a.BANK_IN_BATCH_DO\
C_DATE ,a.EXT_ACCT_CODE ,ACCT_CODE_AMT ,ACCT_DESC  from BL_BANK_IN_BY_ACCT_CO\
DE a ,BL_EXT_ACCT_CODE b ,sy_acc_entity c where (((((a.OPERATING_FACILITY_ID=\
c.acc_entity_id and a.operating_facility_id=:b0) and b.ACC_ENTITY_CODE=c.acc_\
entity_code) and a.EXT_ACCT_CODE=b.ACCOUNT_CODE) and a.BANK_IN_BATCH_DOC_TYPE\
=:b1) and to_char(a.BANK_IN_BATCH_DOC_NO)=:b2) order by EXT_ACCT_CODE        \
    ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,2075,107,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,135,0,2052,147,0,0,7,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
79,0,0,3,84,0,2050,169,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
106,0,0,4,73,0,2052,179,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
129,0,0,5,0,0,2078,204,0,0,0,0,0,1,0,
144,0,0,6,738,0,2057,257,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
187,0,0,6,0,0,2063,265,0,0,0,0,0,1,0,
202,0,0,7,464,0,2057,274,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,4,0,0,
229,0,0,7,0,0,2063,282,0,0,0,0,0,1,0,
244,0,0,6,0,0,2061,305,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
291,0,0,8,216,0,2052,338,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,
326,0,0,9,212,0,2052,358,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,4,0,0,
357,0,0,7,0,0,2061,386,0,0,6,0,0,1,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
9,0,0,
396,0,0,10,192,0,2052,532,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,1,9,0,0,
439,0,0,11,96,0,2052,683,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
462,0,0,12,162,0,2054,690,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00097.PC                                  */
/* AUTHOR                : Robert Joseph                               */  
/* DATE WRITTEN          : 09/09/2004                                   */      
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

#define ONLINE_PRINTING 1 

#define ESC 0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hosp_name                       [120],
			date							[20],
            date_time                       [22],
            user_id                         [91],
			tel_num							[20],
			fax_num							[20],	
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility						[3],
			nd_reportid									[20],
			nd_bank_code					[7],
			nd_bank_date					[15],
			nd_bank_in_doc_type				[7],
			nd_bank_in_doc_no				[9],
            bl_bank_code					[7],
			bl_bank_in_batch_doc_type		[7],
		    bl_pr_bank_in_batch_doc_type	[7],
			bl_pr_bank_in_batch_doc_date	[15], 
			bl_pr_ext_acc_code				[11],
			bl_acct_desc					[61],
			bl_bank_name					[31],
			bl_docno						[25],
			l_translated_value				[201],
			l_pk_value						[100],
			 bl_bank_in_date				[15],
			 bl_trx_fr_date					[15],
			 bl_trx_to_date					[15],
			 bl_bank_in_doc_no				[15],
			 bl_slmnt_code					[3],
			 bl_slmnt_des					[31],
			
			 p_language_id					[3],

			 bl_currency					[4]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[22]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[20]; } tel_num;

struct { unsigned short len; unsigned char arr[20]; } fax_num;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[20]; } nd_reportid;

struct { unsigned short len; unsigned char arr[7]; } nd_bank_code;

struct { unsigned short len; unsigned char arr[15]; } nd_bank_date;

struct { unsigned short len; unsigned char arr[7]; } nd_bank_in_doc_type;

struct { unsigned short len; unsigned char arr[9]; } nd_bank_in_doc_no;

struct { unsigned short len; unsigned char arr[7]; } bl_bank_code;

struct { unsigned short len; unsigned char arr[7]; } bl_bank_in_batch_doc_type;

struct { unsigned short len; unsigned char arr[7]; } bl_pr_bank_in_batch_doc_type;

struct { unsigned short len; unsigned char arr[15]; } bl_pr_bank_in_batch_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bl_pr_ext_acc_code;

struct { unsigned short len; unsigned char arr[61]; } bl_acct_desc;

struct { unsigned short len; unsigned char arr[31]; } bl_bank_name;

struct { unsigned short len; unsigned char arr[25]; } bl_docno;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[15]; } bl_bank_in_date;

struct { unsigned short len; unsigned char arr[15]; } bl_trx_fr_date;

struct { unsigned short len; unsigned char arr[15]; } bl_trx_to_date;

struct { unsigned short len; unsigned char arr[15]; } bl_bank_in_doc_no;

struct { unsigned short len; unsigned char arr[3]; } bl_slmnt_code;

struct { unsigned short len; unsigned char arr[31]; } bl_slmnt_des;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[4]; } bl_currency;



double 	bl_bank_in_batch_doc_no	,bl_bank_in_amt,bl_acc_code_amt,bl_pr_bank_in_batch_doc_no,tot_pr_amt;
					int i;
			
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

int  lctr = 0,pctr = 0,slno = 1, gcnt=0 ,j =0;
int    first = 1,r_fst = 1;

FILE *fp;

void proc_main(argc,argv)

char *argv[];
int argc ;
{
    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
  

         strcpy(g_pgm_id,"BLR00097");
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

	strcpy(nd_reportid.arr,argv[5]);
        nd_reportid.len = strlen(nd_reportid.arr);	

	
        nd_bank_code.arr[0]				= '\0';
		nd_bank_date.arr[0]				= '\0';
		nd_bank_in_doc_type.arr[0]			= '\0';
		nd_bank_in_doc_no.arr[0]			= '\0';
						
		nd_bank_code.len			    = 0;
        nd_bank_date.len			  	= 0;  
		nd_bank_in_doc_type.len			= 0;
		nd_bank_in_doc_no.len			= 0;

		 /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4
				INTO	:nd_bank_code,
						:nd_bank_date,
						:nd_bank_in_doc_type,
						:nd_bank_in_doc_no
				FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 into :b0,:b1,:b2,:b\
3  from SY_PROG_PARAM where ((PGM_ID=:b4 and SESSION_ID=:b5) and PGM_DATE=:b6\
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_bank_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_bank_date;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_bank_in_doc_type;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_bank_in_doc_no;
   sqlstm.sqhstl[3] = (unsigned int  )11;
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

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

		nd_bank_code.arr[nd_bank_code.len]				= '\0';
        nd_bank_date.arr[nd_bank_date.len]				= '\0';
		nd_bank_in_doc_type.arr[nd_bank_in_doc_type.len]= '\0';
		nd_bank_in_doc_no.arr[nd_bank_in_doc_no.len]		= '\0';

    
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
   	 

	 	/* EXEC SQL Select BASE_CURRENCY into :bl_currency from sy_acc_entity where acc_entity_id = :nd_facility; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select BASE_CURRENCY into :b0  from sy_acc_entity where a\
cc_entity_id=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )106;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_currency;
   sqlstm.sqhstl[0] = (unsigned int  )6;
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


 
     if (OERROR)
        err_mesg("SELECT failed on table sy_acc_entity",0,"");
		
        declare_cursor();
       
        fetch_hosp_name();

		fetch_legend_value();

      
         open_file();


        fprintf(fp,"%c(s14H",ESC); 		// To set the font
		
          print_hdr();
   	    print_file();
        end_of_rep();
  

	fclose(fp); 
   

	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )129;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



        if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}

	declare_cursor()
 {

       /* EXEC SQL DECLARE BANK_IN_CUR   CURSOR FOR
	    select a.BANK_CODE,
				b.BANK_NAME,
				a.BANK_IN_BATCH_DOC_TYPE, 
				a.BANK_IN_BATCH_DOC_NO, 
				a.BANK_IN_AMT,
				a.BANK_IN_BATCH_DOC_TYPE||'/'||a.BANK_IN_BATCH_DOC_NO docno,
		to_char(a.bank_in_date,'dd/mm/yyyy'),a.bank_in_doc_no
		from bl_bank_in_doc a,sy_acc_entity c ,bl_bank_name b
		where    a.operating_facility_id     = :nd_facility
			and  c.acc_entity_id          = a.operating_facility_id
			and  a.bank_code=b.bank_code(+) 
            and  nvl(a.bank_code,'!!!!')=:nd_bank_code
			and a.BANK_IN_BATCH_DOC_TYPE    =decode(:nd_bank_in_doc_type,'!!!!',a.BANK_IN_BATCH_DOC_TYPE ,:nd_bank_in_doc_type)
			and to_char(a.BANK_IN_BATCH_DOC_NO)    = decode(:nd_bank_in_doc_no,'!!!!',to_char(a.BANK_IN_BATCH_DOC_NO),:nd_bank_in_doc_no)
			and a.BANK_IN_BATCH_DOC_DATE    = :nd_bank_date
			order by a.SLMT_TYPE_CODE,a.BANK_IN_BATCH_DOC_DATE,a.BANK_IN_BATCH_DOC_TYPE, 
             a.BANK_IN_BATCH_DOC_NO  ; */ 


 
     
	
     
      
     /* EXEC SQL DECLARE PRINT_CUR  CURSOR FOR
	   select a.BANK_IN_BATCH_DOC_TYPE, a.BANK_IN_BATCH_DOC_NO ,a.BANK_IN_BATCH_DOC_DATE, 
		a.EXT_ACCT_CODE , ACCT_CODE_AMT,ACCT_DESC      
		from BL_BANK_IN_BY_ACCT_CODE a, BL_EXT_ACCT_CODE b, sy_acc_entity c 
		where a.OPERATING_FACILITY_ID= c.acc_entity_id
		and  a.operating_facility_id     = :nd_facility
		and b.ACC_ENTITY_CODE=c.acc_entity_code
		and a.EXT_ACCT_CODE=b.ACCOUNT_CODE
		and a.BANK_IN_BATCH_DOC_TYPE =:bl_bank_in_batch_doc_type
		and to_char(a.BANK_IN_BATCH_DOC_NO)   =:bl_bank_in_batch_doc_no
		order by EXT_ACCT_CODE ; */ 


	    }

  


  open_bank_in_cur()
{

	/* EXEC SQL OPEN BANK_IN_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )144;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_bank_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_bank_in_doc_type;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_bank_in_doc_type;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_bank_in_doc_no;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_bank_in_doc_no;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_bank_date;
 sqlstm.sqhstl[6] = (unsigned int  )17;
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
         err_mesg("OPEN failed on cursor BANK_IN_CUR",0,"");
}

close_bank_in_cur()
{

	/* EXEC SQL CLOSE BANK_IN_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )187;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

 

open_print_cur()
{

	/* EXEC SQL OPEN PRINT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )202;
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
 sqlstm.sqhstv[1] = (         void  *)&bl_bank_in_batch_doc_type;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_bank_in_batch_doc_no;
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
         err_mesg("OPEN failed on cursor PRINT_CUR",0,"");
}

close_print_cur()
{

	/* EXEC SQL CLOSE PRINT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )229;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}


 fetch_bank_in_cur()
 {
    
bl_bank_code.arr[0]				= '\0';
bl_bank_name.arr[0]				= '\0';
bl_bank_in_batch_doc_type.arr[0]	= '\0';
bl_docno.arr[0]						='\0';			
bl_bank_in_date.arr[0]				='\0';

bl_bank_in_doc_no.arr[0]			='\0';
bl_bank_code.len						= 0;
bl_bank_name.len						= 0;
bl_bank_in_batch_doc_type.len			= 0;
bl_docno.len							= 0;				
bl_bank_in_date.len						=0;

bl_bank_in_doc_no.len					=0;

 /* EXEC SQL FETCH BANK_IN_CUR INTO
				:bl_bank_code,
				:bl_bank_name,
				:bl_bank_in_batch_doc_type,
				:bl_bank_in_batch_doc_no,
				:bl_bank_in_amt,
				:bl_docno,
				:bl_bank_in_date,
				:bl_bank_in_doc_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )244;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_bank_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_bank_name;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_bank_in_batch_doc_type;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_bank_in_batch_doc_no;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_bank_in_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_docno;
 sqlstm.sqhstl[5] = (unsigned int  )27;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&bl_bank_in_date;
 sqlstm.sqhstl[6] = (unsigned int  )17;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&bl_bank_in_doc_no;
 sqlstm.sqhstl[7] = (unsigned int  )17;
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
          err_mesg("FETCH failed on cursor BANK_IN_CUR",0,"");

bl_bank_code.arr[bl_bank_code.len]		='\0';
bl_bank_name.arr[bl_bank_name.len]		='\0';	
bl_bank_in_batch_doc_type.arr[bl_bank_in_batch_doc_type.len] ='\0';
bl_docno.arr[bl_docno.len]				='\0';
bl_bank_in_date.arr[bl_bank_in_date.len]  ='\0';

bl_bank_in_doc_no.arr[bl_bank_in_doc_no.len] ='\0';

fetch_slmnt_cur();

return(LAST_ROW?0:1);
}

fetch_trx_date()
{
	bl_trx_fr_date.arr[0] = '\0';
	bl_trx_fr_date.len = 0;

	bl_trx_to_date.arr[0] = '\0';
	bl_trx_to_date.len = 0;
	
	/* EXEC SQL SELECT to_char(MIN(doc_date),'dd/mm/yyyy'), to_char(MAX(doc_date),'dd/mm/yyyy') 
	INTO :bl_trx_fr_date, :bl_trx_to_date
	FROM bl_receipt_refund_dtl
	WHERE operating_facility_id = :nd_facility
	AND bank_in_batch_doc_type = :bl_bank_in_batch_doc_type
	AND bank_in_batch_doc_no = :bl_bank_in_batch_doc_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select to_char(min(doc_date),'dd/mm/yyyy') ,to_char(max(doc\
_date),'dd/mm/yyyy') into :b0,:b1  from bl_receipt_refund_dtl where ((operati\
ng_facility_id=:b2 and bank_in_batch_doc_type=:b3) and bank_in_batch_doc_no=:\
b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )291;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_trx_fr_date;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_trx_to_date;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_bank_in_batch_doc_type;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_bank_in_batch_doc_no;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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



	bl_trx_fr_date.arr[bl_trx_fr_date.len] = '\0';
	bl_trx_fr_date.arr[bl_trx_fr_date.len] = '\0';
}

fetch_slmnt_cur()
 {

  bl_slmnt_code.arr[0]  ='\0';
  bl_slmnt_des.arr[0]  ='\0';

  bl_slmnt_code.len    =0;
  bl_slmnt_des.len    =0;

  /* EXEC SQL Select distinct s.SLMT_TYPE_CODE,LONG_DESC INTO
       :bl_slmnt_code,
	   :bl_slmnt_des 
	    from bl_slmt_type s,BL_BANK_IN_BY_ACCT_CODE b where
		b.SLMT_TYPE_CODE=s.SLMT_TYPE_CODE and
		b.BANK_IN_BATCH_DOC_TYPE=:bl_bank_in_batch_doc_type and
		b.BANK_IN_BATCH_DOC_NO=:bl_bank_in_batch_doc_no; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select distinct s.SLMT_TYPE_CODE ,LONG_DESC into :b0,:b1  \
from bl_slmt_type s ,BL_BANK_IN_BY_ACCT_CODE b where ((b.SLMT_TYPE_CODE=s.SLM\
T_TYPE_CODE and b.BANK_IN_BATCH_DOC_TYPE=:b2) and b.BANK_IN_BATCH_DOC_NO=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )326;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_slmnt_code;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_slmnt_des;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_bank_in_batch_doc_type;
  sqlstm.sqhstl[2] = (unsigned int  )9;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bl_bank_in_batch_doc_no;
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



if (OERROR)
          err_mesg("FETCH failed on cursor PRINT_CUR",0,"");

		bl_slmnt_code.arr[bl_slmnt_code.len]   ='\0';
        bl_slmnt_des.arr[bl_slmnt_des.len]     ='\0';
}

fetch_print_cur()
{
  
			bl_pr_bank_in_batch_doc_type.arr[0]		='\0';
			bl_pr_bank_in_batch_doc_date.arr[0]		='\0';
			bl_pr_ext_acc_code.arr[0]				='\0';			
			bl_acct_desc.arr[0]						='\0';

			bl_pr_bank_in_batch_doc_type.len		=0;
			bl_pr_bank_in_batch_doc_date.len		=0;
			bl_pr_ext_acc_code.len					=0;		
			bl_acct_desc.len						=0;

 /* EXEC SQL FETCH PRINT_CUR INTO
        :bl_pr_bank_in_batch_doc_type,
        :bl_pr_bank_in_batch_doc_no,
		:bl_pr_bank_in_batch_doc_date,
		:bl_pr_ext_acc_code,
		:bl_acc_code_amt,
		:bl_acct_desc; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )357;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_pr_bank_in_batch_doc_type;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_pr_bank_in_batch_doc_no;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_pr_bank_in_batch_doc_date;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_pr_ext_acc_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_acc_code_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_acct_desc;
 sqlstm.sqhstl[5] = (unsigned int  )63;
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
          err_mesg("FETCH failed on table BL_SLMNT_TYPE",0,"");

			bl_pr_bank_in_batch_doc_type.arr[bl_pr_bank_in_batch_doc_type.len]		='\0';
			bl_pr_bank_in_batch_doc_date.arr[bl_pr_bank_in_batch_doc_date.len]		='\0';
			bl_pr_ext_acc_code.arr[bl_pr_ext_acc_code.len]							='\0';			
			bl_acct_desc.arr[bl_acct_desc.len]										='\0';

return(LAST_ROW?0:1);		
		
}


print_hdr()
  {
   open_bank_in_cur();
   
  while(fetch_bank_in_cur())    
  {
 	fetch_trx_date();
      	 
	check_page_end(2,0);
	fprintf(fp,"\n");
	print_page_title();
        fprintf(fp,"\n\n\n\n\n");
	fprintf(fp,"%c(s10H",ESC);
	fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	if(strcmp(bl_bank_code.arr,"\0") == 0)
	 {
	 fprintf(fp,"%-8s",loc_legend[18]);
	 fill_dash(35);
         fprintf(fp,"\n\n\n\n");
	  }
    else
    fprintf(fp,"%-31s \n\n\n\n",bl_bank_name.arr);
      fprintf(fp,"%c(s-3B",ESC);	// To release bold style
     fprintf(fp,"%c(s14H",ESC); 
     
     fprintf(fp,"%-s %-s %-s %-s",loc_legend[20],bl_trx_fr_date.arr,loc_legend[21],bl_trx_to_date.arr);
     fprintf(fp,"\n");
     fill_dash(104);
	 fprintf(fp,"\n\n");
	  fprintf(fp,"%-20s %-15s %-15s %-15s%-14s ",loc_legend[1],nd_bank_date.arr,loc_legend[2],bl_docno.arr,loc_legend[3]);
	  print_formated(bl_bank_in_amt);
	  fprintf(fp,"%-5s \n",bl_currency.arr);
	  fill_dash(104);
	  fprintf(fp,"\n");
	  fprintf(fp,"%-15s %-40s \n",loc_legend[4],bl_slmnt_des.arr );
	  fill_dash(104);
	  fprintf(fp,"\n\n\n\n\n\n");
	  fill_dash(104);
      fprintf(fp,"\n");
       fprintf(fp,"%-7s %-14s%-15s %39s%15s(%-4s)\n",loc_legend[5],loc_legend[6],loc_legend[7]," ",loc_legend[8],bl_currency.arr);
	   fill_dash(104);
     fprintf(fp,"\n\n");
	 open_print_cur();
	  tot_pr_amt =0;
	  slno=1;
	
	  while (fetch_print_cur())
	     {
 		   fprintf(fp,"%7d %-11s   %-61s ",slno,bl_pr_ext_acc_code.arr, bl_acct_desc.arr);
		   print_formated(bl_acc_code_amt);
		   fprintf(fp,"\n");
		   tot_pr_amt=tot_pr_amt+bl_acc_code_amt;
		   slno++;
	    } 
		 
		 if( slno!=7)
		 {
		 gcnt = slno;
		 for (j=gcnt;j<=7;j++)
    	fprintf(fp,"\n");
		   }
		   fill_dash(104);



		   fprintf(fp,"\n");
		   fprintf(fp,"%73s %-10s"," ",loc_legend[9]);
		  print_formated(tot_pr_amt);
          fprintf(fp,"\n\n\n\n\n");
          fprintf(fp,"%-8s :",loc_legend[10] );
		  fill_dash(40);
		  fprintf(fp,"\n\n");
		  fprintf(fp,"%-8s :",loc_legend[11]);
		  fill_dash(15);
          fprintf(fp,"\n\n");
		  fill_dash(104);
		  fprintf(fp,"\n\n");
          fprintf(fp,"%-12s",loc_legend[12]);
		  fill_dash(26);
 
		  fprintf(fp," %-15s ",loc_legend[13]);

		  if(strcmp(bl_bank_in_doc_no.arr,"\0")==0)
		  fill_dash(15);
		  else  
		  fprintf(fp," %-15s",bl_bank_in_doc_no.arr);
          
          fprintf(fp," %-15s",loc_legend[14]);
           if(strcmp(bl_bank_in_date.arr,"\0")==0)
		   {
		   fill_dash(3);
		   fprintf(fp,"/");
		   fill_dash(5);
		   fprintf(fp,"/");
		   fill_dash(7);
		   }
          else
		   
		   fprintf(fp,"%-14s",bl_bank_in_date.arr);
		  
		  fprintf(fp,"\n");
          fill_dash(104); 
           fprintf(fp,"\n\n\n\n\n\n\n\n\n\n\n\n\n");
         fprintf(fp,"%11s %30s %10s %-20s %10s %-20s \n"," ",hosp_name.arr,loc_legend[16],tel_num.arr,loc_legend[17],fax_num.arr);
		 fprintf(fp,"%36s %16s %20s "," ",loc_legend[19],date_time.arr);
		fprintf(fp,"\f");
		  }

   }

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
	date.arr[0]		 = '\0';
    user_id.arr[0]   = '\0';
	tel_num.arr[0]	 = '\0';
	fax_num.arr[0]	 = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
	date.len		 = 0;
    user_id.len      = 0;
	tel_num.len		 = 0;
	fax_num.len		 = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/RRRR'),
					TO_CHAR(SYSDATE,'DD/MM/RRRR:HH24:MI:SS'),
                    USER,
					tel_num,
					fax_num
               INTO :hosp_name, 
					:date,
					:date_time, 
					:user_id,
					:tel_num,
					:fax_num 
               FROM SY_ACC_ENTITY
	          WHERE ACC_ENTITY_ID = :nd_facility; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/RRRR') ,T\
O_CHAR(SYSDATE,'DD/MM/RRRR:HH24:MI:SS') ,USER ,tel_num ,fax_num into :b0,:b1,\
:b2,:b3,:b4,:b5  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b6";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )396;
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
    sqlstm.sqhstl[2] = (unsigned int  )24;
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
    sqlstm.sqhstv[4] = (         void  *)&tel_num;
    sqlstm.sqhstl[4] = (unsigned int  )22;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&fax_num;
    sqlstm.sqhstl[5] = (unsigned int  )22;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_facility;
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
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	date.arr[date.len]					   = '\0';
	user_id.arr[user_id.len]               = '\0';
	tel_num.arr[tel_num.len]			   = '\0';
	fax_num.arr[fax_num.len]			   = '\0';

	}

end_of_rep()
{
 	check_page_end(3,0);
	fflush(fp);
}


open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00097.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00097.lis");
       proc_exit();
    }
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


fill_dash(flg)
{
  int i;
  for (i=1;i<=flg;i++)
	fprintf(fp,"%s","_");
}

print_page_title()
{
	double l_report_width;
	double l_start_point;
        double head_length;
	int	   l_page_width;
	
	l_report_width=132;
	head_length = strlen(loc_legend[15]);

	
	l_start_point=ceill((l_report_width/2)-(head_length/2)-15);
	fprintf(fp,"\n");
        print_spaces(l_start_point);
    fprintf(fp,"%c(s09H",ESC);
	fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	fprintf(fp,"%c&d0D",ESC); /* set Underline mode */
	fprintf(fp,"%12s\n",loc_legend[15]);
	fprintf(fp,"%c(s-3B",ESC);	// To release bold style
    fprintf(fp,"%c(s14H",ESC); 
	fprintf(fp,"%c&d@",ESC); /* release underline mode */
	fprintf(fp,"\n");
	l_start_point=0;
}

print_spaces(l_length)
double l_length;

{
 int i;
	for(i=0;i<l_length;i++)
	{
		fprintf(fp," ");
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
		//print_head();
		lctr = 2;
	}
}


print_file()
{
 
	PrintDocument(	nd_pwd.arr,		//char	*PUidPwd;
			nd_session_id.arr,	//char	*PSessionID;
			nd_facility.arr,	//char	*PFacilityID;
			"BL",			//char	*PModuleID;
			nd_reportid.arr,	//char	*PDocumentID;
			filename,		//char	*POnlinePrintFileNames;
			"O",			//char	*PLocationTypes;
			" ",			//char	*PLocationCodes;
			1,			//int		PNumOfCopies;
			1,			//int		PPageFrom;
			999			//int		PPageTo;
			); 
}  
  
  
fetch_legend_value()
 {
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00097.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00097.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )439;
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
  sqlstm.offset = (unsigned int  )462;
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
