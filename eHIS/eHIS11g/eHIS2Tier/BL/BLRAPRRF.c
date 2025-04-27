
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRAPRRF.PC"
};


static unsigned int sqlctx = 1288466859;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {12,16};

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
"select approved_date ,to_char(approved_date,'DD/MM/YYYY') ,substr(pmnt_instr\
_num,1,8) ,pmnt_instr_date ,to_char(pmnt_instr_date,'DD/MM/YYYY') ,bank_name ,\
orig_doc_outst_amt ,((doc_type_code||'/')||to_char(doc_num)) ,doc_srl_num ,doc\
_date ,to_char(doc_date,'DD/MM/YYYY') ,((((orig_doc_type_code||'/')||to_char(o\
rig_doc_num))||'/')||to_char(orig_doc_srno)) ,orig_doc_date ,to_char(orig_doc_\
date,'DD/MM/YYYY') ,patient_id ,payee_name  from bl_refund_request_dtl where (\
(operating_facility_id=:b0 and nvl(request_status,'N')='A') and doc_date betwe\
en to_date(:b1,'DD/MM/YYYY') and to_date((:b2||' 23:59:59'),'DD/MM/YYYY HH24:M\
I:SS')) order by decode(:b3,'A',approved_date,'R',doc_date)            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,108,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,123,0,4,142,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
75,0,0,3,84,0,2,161,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
102,0,0,4,0,0,30,187,0,0,0,0,0,1,0,
117,0,0,5,693,0,9,223,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
148,0,0,5,0,0,15,231,0,0,0,0,0,1,0,
163,0,0,5,0,0,13,262,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
242,0,0,6,206,0,4,592,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
285,0,0,7,132,0,4,622,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
312,0,0,8,96,0,4,691,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
335,0,0,9,162,0,6,698,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
366,0,0,10,199,0,6,719,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRAPRRF.PC                                  */
/* AUTHOR                : Jagwinder Kaur                               */  
/* DATE WRITTEN          : 10/06/2004                                   */      
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
			l_acc_name						[120],
			l_sysdate						[20],
            date_time                       [20],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility				        [3],
			bl_doc_no						[16],
			bl_org_doc_no					[19],
			bl_doc_date						[11],
			bl_doc_date1					[11],
			bl_org_doc_date					[11],
			bl_org_doc_date1				[11],
			bl_patient_id					[21],
			bl_patient_name					[58],
			nd_fm_date						[11],
			nd_to_date						[11],
			l_translated_value				[201],
			l_cash_book_acc_desc			[16],
			l_pk_value						[100],
			tmp_doc_date					[11],
			tmp_org_doc_date				[11],
			old_doc_date					[11],
			bl_appr_date					[11],
			bl_appr_date1					[11],
			tmp_appr_date					[11],
			old_appr_date					[11],
			bl_instr_no						[9],
			tmp_instr_date					[11],
			bl_instr_date					[11],
			bl_instr_date1					[11],
			bl_bank_name					[102],
			old_bank_name					[102],
			bl_payee_name					[41],
			p_language_id					[3],
			nd_temp_date					[13],
			nd_loc_date						[13],
			date_convert					[13],
			language_id                     [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[120]; } l_acc_name;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[16]; } bl_doc_no;

struct { unsigned short len; unsigned char arr[19]; } bl_org_doc_no;

struct { unsigned short len; unsigned char arr[11]; } bl_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bl_doc_date1;

struct { unsigned short len; unsigned char arr[11]; } bl_org_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bl_org_doc_date1;

struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[58]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[16]; } l_cash_book_acc_desc;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[11]; } tmp_doc_date;

struct { unsigned short len; unsigned char arr[11]; } tmp_org_doc_date;

struct { unsigned short len; unsigned char arr[11]; } old_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bl_appr_date;

struct { unsigned short len; unsigned char arr[11]; } bl_appr_date1;

struct { unsigned short len; unsigned char arr[11]; } tmp_appr_date;

struct { unsigned short len; unsigned char arr[11]; } old_appr_date;

struct { unsigned short len; unsigned char arr[9]; } bl_instr_no;

struct { unsigned short len; unsigned char arr[11]; } tmp_instr_date;

struct { unsigned short len; unsigned char arr[11]; } bl_instr_date;

struct { unsigned short len; unsigned char arr[11]; } bl_instr_date1;

struct { unsigned short len; unsigned char arr[102]; } bl_bank_name;

struct { unsigned short len; unsigned char arr[102]; } old_bank_name;

struct { unsigned short len; unsigned char arr[41]; } bl_payee_name;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[13]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[13]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[13]; } date_convert;

struct { unsigned short len; unsigned char arr[3]; } language_id;


			
double      bl_org_doc_amt,tot_org_doc_amt,tot_amt;
			
int i,bl_doc_srl_no;
char nd_order_by;
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char fm_date[11],to_date[11];
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
 
    strcpy(g_pgm_id,"BLRAPRRF");
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

    	strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);

		strcpy(p_language_id.arr,l_language_id.arr);
		p_language_id.len = l_language_id.len;

        nd_fm_date.arr[0]			= '\0';
		nd_to_date.arr[0]			= '\0';
		nd_fm_date.len				= 0;
		nd_to_date.len				= 0;
		
        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3
				INTO	:nd_fm_date,
						:nd_to_date,
						:nd_order_by
				FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 into :b0,:b1,:b2  from \
SY_PROG_PARAM where ((PGM_ID=:b3 and SESSION_ID=:b4) and PGM_DATE=:b5)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )36;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
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
        sqlstm.sqhstv[2] = (         void  *)&nd_order_by;
        sqlstm.sqhstl[2] = (unsigned int  )1;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_curr_pgm_name;
        sqlstm.sqhstl[3] = (unsigned int  )17;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_session_id;
        sqlstm.sqhstl[4] = (unsigned int  )18;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&nd_pgm_date;
        sqlstm.sqhstl[5] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

		nd_fm_date.arr[nd_fm_date.len]				= '\0';
		nd_to_date.arr[nd_to_date.len]				= '\0';
		 

	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )75;
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
   

    	declare_cur();

    	fetch_hosp_name();

		fetch_legend_value();

    	open_file();		

		open_dtl();

        print_head();

	    print_hdr();

	    end_of_rep();


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )102;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}

declare_cur()
{
	/* EXEC SQL DECLARE REQUEST_DTL_CUR CURSOR FOR 
		          select  approved_date,
				  to_char(approved_date,'DD/MM/YYYY'),
                  substr(pmnt_instr_num,1,8),
                  pmnt_instr_date,
				  to_char(pmnt_instr_date,'DD/MM/YYYY'),
                  bank_name,
                  orig_doc_outst_amt,
                  doc_type_code||'/'||to_char(doc_num),
                  doc_srl_num,
                  doc_date,
                  to_char(doc_date,'DD/MM/YYYY'),
                  orig_doc_type_code||'/'||to_char(orig_doc_num)||'/'||to_char(orig_doc_srno),
                  orig_doc_date,
                  to_char(orig_doc_date,'DD/MM/YYYY'),
                  patient_id,
                  payee_name
  from bl_refund_request_dtl
  where operating_facility_id= :nd_facility
  and nvl(request_status,'N') = 'A'
  and doc_date between to_date(:nd_fm_date,'DD/MM/YYYY')
                  and to_date(:nd_to_date||' 23:59:59','DD/MM/YYYY HH24:MI:SS')
  order by decode(:nd_order_by,'A',approved_date,'R',doc_date); */ 

}


open_dtl() 
{

	/* EXEC SQL OPEN REQUEST_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )117;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_order_by;
 sqlstm.sqhstl[3] = (unsigned int  )1;
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
         err_mesg("OPEN failed on cursor REQUEST_DTL_CUR",0,"");
}

close_dtl() 
{

	/* EXEC SQL CLOSE REQUEST_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )148;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

fetch_dtl()
{

bl_appr_date.arr[0]		= '\0';
bl_instr_no.arr[0]		= '\0';
bl_instr_date.arr[0]	= '\0';
bl_bank_name.arr[0]		= '\0';
bl_doc_no.arr[0]		= '\0';
bl_doc_date.arr[0]		= '\0';
bl_org_doc_no.arr[0]	= '\0';
bl_org_doc_date.arr[0]	= '\0';
bl_patient_id.arr[0]	= '\0';
bl_payee_name.arr[0]	= '\0';

bl_appr_date.len		= 0;
bl_instr_no.len			= 0;
bl_instr_date.len		= 0;
bl_bank_name.len		= 0;
bl_doc_no.len			= 0;
bl_doc_date.len			= 0;
bl_org_doc_no.len		= 0;
bl_org_doc_date.len		= 0;
bl_patient_id.len		= 0;
bl_payee_name.len		= 0;

bl_org_doc_amt           = 0;

      /* EXEC SQL FETCH REQUEST_DTL_CUR
               INTO :tmp_appr_date,
					:bl_appr_date,
					:bl_instr_no,
					:tmp_instr_date,
					:bl_instr_date,
					:bl_bank_name,
					:bl_org_doc_amt,	
					:bl_doc_no,
					:bl_doc_srl_no,
					:tmp_doc_date,
			   		:bl_doc_date,
					:bl_org_doc_no,
					:tmp_org_doc_date,
					:bl_org_doc_date,
					:bl_patient_id,
					:bl_payee_name; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 16;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )163;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&tmp_appr_date;
      sqlstm.sqhstl[0] = (unsigned int  )13;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_appr_date;
      sqlstm.sqhstl[1] = (unsigned int  )13;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_instr_no;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&tmp_instr_date;
      sqlstm.sqhstl[3] = (unsigned int  )13;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_instr_date;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_bank_name;
      sqlstm.sqhstl[5] = (unsigned int  )104;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_org_doc_amt;
      sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bl_doc_no;
      sqlstm.sqhstl[7] = (unsigned int  )18;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&bl_doc_srl_no;
      sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&tmp_doc_date;
      sqlstm.sqhstl[9] = (unsigned int  )13;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&bl_doc_date;
      sqlstm.sqhstl[10] = (unsigned int  )13;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&bl_org_doc_no;
      sqlstm.sqhstl[11] = (unsigned int  )21;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&tmp_org_doc_date;
      sqlstm.sqhstl[12] = (unsigned int  )13;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&bl_org_doc_date;
      sqlstm.sqhstl[13] = (unsigned int  )13;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&bl_patient_id;
      sqlstm.sqhstl[14] = (unsigned int  )23;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&bl_payee_name;
      sqlstm.sqhstl[15] = (unsigned int  )43;
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
            err_mesg("FETCH failed on cursor REQUEST_DTL_CUR",0,"");

bl_appr_date.arr[bl_appr_date.len]		= '\0';
bl_instr_no.arr[bl_instr_no.len]		= '\0';
bl_instr_date.arr[bl_instr_date.len]	= '\0';
bl_bank_name.arr[bl_bank_name.len]		= '\0';
bl_doc_no.arr[bl_doc_no.len]			= '\0';
bl_doc_date.arr[bl_doc_date.len]		= '\0';
bl_org_doc_no.arr[bl_org_doc_no.len]	= '\0';
bl_org_doc_date.arr[bl_org_doc_date.len]= '\0';
bl_patient_id.arr[bl_patient_id.len]	= '\0';
bl_payee_name.arr[bl_payee_name.len]	= '\0';

    return(LAST_ROW?0:1);
}



print_hdr()
{
  while(fetch_dtl())
  {
    fetch_patient_name();

    if(first)
	 {
     strcpy(old_doc_date.arr,bl_doc_date.arr);
	 old_doc_date.len=strlen(old_doc_date.arr);

	 strcpy(old_appr_date.arr,bl_appr_date.arr);
	 old_appr_date.len=strlen(old_appr_date.arr);

	 strcpy(old_bank_name.arr,bl_bank_name.arr);
	 old_bank_name.len=strlen(old_bank_name.arr);
	 
	 first = 0;
	 }
      
	if(nd_order_by == 'R' && strcmp(old_doc_date.arr,bl_doc_date.arr) != 0)
	    print_total();

	if(nd_order_by == 'A' && strcmp(old_appr_date.arr,bl_appr_date.arr) != 0)
	    print_total();

    if(nd_order_by == 'B' && strcmp(old_bank_name.arr,bl_bank_name.arr) != 0)
	    print_total();

	check_page_end(2,0);

	  	 
	  if(bl_appr_date.arr[0]!='\0')
	  {
	  init_date_temp_var();
	  strcpy(date_convert.arr,bl_appr_date.arr);
	  fun_change_loc_date();
	  strcpy(bl_appr_date1.arr,date_convert.arr);
	  }
	  
	  if(bl_instr_date.arr[0]!='\0')
	  {
	  init_date_temp_var();
	  strcpy(date_convert.arr,bl_instr_date.arr);
	  fun_change_loc_date();
	  strcpy(bl_instr_date1.arr,date_convert.arr);
	  }
	
	fprintf(fp," %-11s%-5s%-12s %-10s %-30.30s",
	             bl_appr_date1.arr," ",
				 bl_instr_no.arr,
				 bl_instr_date1.arr,
				 bl_bank_name.arr);
	print_formated(bl_org_doc_amt);

     if(bl_doc_date.arr[0]!='\0')
	  {
	  init_date_temp_var();
	  strcpy(date_convert.arr,bl_doc_date.arr);
	  fun_change_loc_date();
	  strcpy(bl_doc_date1.arr,date_convert.arr);
	  }
 
    if(bl_org_doc_date.arr[0]!='\0')
	  {
	  init_date_temp_var();
	  strcpy(date_convert.arr,bl_org_doc_date.arr);
	  fun_change_loc_date();
	  strcpy(bl_org_doc_date1.arr,date_convert.arr);
	  }
	fprintf(fp," %-19s %6d %-10s %-15s %-10s\n",
				bl_doc_no.arr,
				bl_doc_srl_no,
				bl_doc_date1.arr,
				bl_org_doc_no.arr,
				bl_org_doc_date1.arr);
	
	/*fprintf(fp," %-20s %-57s %-40s \n",
				bl_patient_id.arr,
				bl_patient_name.arr,
				bl_payee_name.arr);*/

	 fprintf(fp," %-15s %-12s %-42s %-14s  %-40s\n",
	            bl_patient_id.arr," ",
				bl_patient_name.arr," ",
				bl_payee_name.arr);

    lctr=lctr+2;
	tot_org_doc_amt = tot_org_doc_amt + bl_org_doc_amt;

	 if (nd_order_by == 'A')
	 {
	 strcpy(old_appr_date.arr,bl_appr_date.arr);
	 old_appr_date.len=strlen(old_appr_date.arr);
      }

	 if (nd_order_by == 'R')
	 {
	 strcpy(old_doc_date.arr,bl_doc_date.arr);
	 old_doc_date.len=strlen(old_doc_date.arr);
      }

     if (nd_order_by == 'B')
	 {
	 strcpy(old_bank_name.arr,bl_bank_name.arr);
	 old_bank_name.len=strlen(old_bank_name.arr);
	 }
	 
	}
print_total();
print_grand_total();
}   

print_total()
{
    check_page_end(3,0);
	fprintf(fp,"%-70s %-15s\n"," ","---------------");
	fprintf(fp,"%-49s %-19s :"," ",loc_legend[12]); 
	print_formated(tot_org_doc_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-70s %-15s\n"," ","---------------");
	tot_amt = tot_amt + tot_org_doc_amt;
	lctr=lctr+3; 
	tot_org_doc_amt = 0;
}   

print_grand_total()
{
    check_page_end(5,0);
	fprintf(fp,"%-49s %-19s :"," ",loc_legend[13]); 
	print_formated(tot_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-70s %-15s\n"," ","---------------");
	tot_amt = 0;
	
}   


end_of_rep()
{
	check_page_end(3,0);
	fprintf(fp,"\n\n %56s   ***  END OF THE REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRAPRRF.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRAPRRF.lis");
       proc_exit();
    }
}

/*print_page_header()
{

   




print_page_title();
fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1 \n\n\n\n");
fprintf(fp,"           INPUT PARAMETER \n");
fprintf(fp,"           --------------- \n\n\n\n");
fprintf(fp,"				TRANSACTION TYPE                  : ");

if (nd_trn_type == 'R')
fprintf(fp,"Receipt");
else
fprintf(fp,"Refund");
fprintf(fp,"\n\n");

fprintf(fp,"				RECEIPT DATE     FROM             : %s\n",fm_date);
fprintf(fp,"				                 TO               : %s\n\n",to_date);
fprintf(fp,"\f");
}

*/
print_head()
{
	print_page_title();
	fprintf(fp,"---------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(fp," %-15s %-12s %-10s %-28s  %16s  %-16s%-4s%6s %-10s %-15s %-8s\n",loc_legend[4],loc_legend[5],loc_legend[6],loc_legend[7],loc_legend[8],loc_legend[9]," ",loc_legend[10],loc_legend[6],loc_legend[11],loc_legend[6]);
	fprintf(fp," %-14s%-15s%-8s%-51s%-9s %-8s\n",loc_legend[18]," ",loc_legend[19]," ",loc_legend[20],loc_legend[19]);
	fprintf(fp,"---------------------------------------------------------------------------------------------------------------------------------------------------------\n");
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
    char fm_date[10],to_date[10];
  
     
	 if (strcmp(nd_fm_date.arr,"01/01/1000") == 0)
	  strcpy(fm_date,loc_legend[25]);
    else
	  {
	  init_date_temp_var();
	  strcpy(date_convert.arr,nd_fm_date.arr);
	  fun_change_loc_date();
	  strcpy(fm_date,date_convert.arr);
	  }
   
	if (strcmp(nd_to_date.arr,"31/12/4000") == 0)
	  strcpy(to_date,loc_legend[24]);
    else
	  {
	  init_date_temp_var();
	  strcpy(date_convert.arr,nd_to_date.arr);
	  fun_change_loc_date();
	  strcpy(to_date,date_convert.arr);
	  }

	l_report_width=132;
	l_acc_entity_length = strlen(hosp_name.arr);

	//Code for Line 1

	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	fprintf(fp,"%-13s : BL",loc_legend[21]);
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",hosp_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(l_sysdate.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	init_date_temp_var();
	strcpy(date_convert.arr,l_sysdate.arr);
	fun_change_loc_date();
	
	fprintf(fp,"%-15.15s : %s\n",loc_legend[15],date_convert.arr);

	//Code for Line 2
	
	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[1]))/2));
	fprintf(fp,"%-13s : %s",loc_legend[22],user_id.arr);
	l_start_point=l_start_point-(strlen(user_id.arr)+16);
	print_spaces(l_start_point);
	fprintf(fp,"%s ",loc_legend[1]);
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[1]);
	l_start_point=(l_report_width-(18+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[16],date_time.arr);
    
	//Code for Line 3

	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[2])+strlen(fm_date)+strlen(to_date)+strlen(loc_legend[3]))/2));;
	fprintf(fp,"%-14.14s: BLRAPRRF",loc_legend[14]);
	l_start_point=l_start_point-24;
    print_spaces(l_start_point);
    fprintf(fp,"%s %s %s %s",loc_legend[2],fm_date,loc_legend[3],to_date);
	l_comp_name_end_point=l_start_point+24+strlen(loc_legend[2])+strlen(fm_date)+strlen(to_date)+strlen(loc_legend[3]);
	l_start_point=(l_report_width-(19+9)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %d\n",loc_legend[17],++pctr);

	
}

fill_dash(flg)
{
  int i;
  for (i=1;i<=flg;i++)
	fprintf(fp,"%s","-");
}

fetch_hosp_name()
{
    l_acc_name.arr[0]= '\0';
	hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
	l_sysdate.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    l_acc_name.len   = 0;
	hosp_name.len    = 0;
    date_time.len    = 0;
	l_sysdate.len	 = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACCOUNTING_NAME,
					ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/RRRR'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
                    USER
               INTO :l_acc_name,
					:hosp_name, 
					:l_sysdate,
					:date_time, 
					:user_id
               FROM SY_ACC_ENTITY_LANG_VW
	          WHERE ACC_ENTITY_ID = :nd_facility
			  AND   LANGUAGE_ID   = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,\
'DD/MM/RRRR') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,USER into :b0,:b1,:b2,:b3,:b4  f\
rom SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b5 and LANGUAGE_ID=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )242;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_acc_name;
    sqlstm.sqhstl[0] = (unsigned int  )122;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&hosp_name;
    sqlstm.sqhstl[1] = (unsigned int  )122;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_sysdate;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&date_time;
    sqlstm.sqhstl[3] = (unsigned int  )22;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&user_id;
    sqlstm.sqhstl[4] = (unsigned int  )93;
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
    sqlstm.sqhstv[6] = (         void  *)&p_language_id;
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

	l_acc_name.arr[l_acc_name.len]		   = '\0';
	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	l_sysdate.arr[l_sysdate.len]		   = '\0';
	user_id.arr[user_id.len]               = '\0';

}

fetch_patient_name()
{
    bl_patient_name.arr[0] = '\0';
    bl_patient_name.len = 0;

    /* EXEC SQL SELECT decode(:p_language_id,'en', substr(short_name,1,57),
								      substr(short_name_loc_lang,1,57))
               INTO :bl_patient_name
               FROM MP_PATIENT_MAST
	           WHERE PATIENT_ID = :bl_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select decode(:b0,'en',substr(short_name,1,57),substr(sho\
rt_name_loc_lang,1,57)) into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )285;
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
    sqlstm.sqhstv[1] = (         void  *)&bl_patient_name;
    sqlstm.sqhstl[1] = (unsigned int  )60;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_patient_id;
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
		err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

	bl_patient_name.arr[bl_patient_name.len]           = '\0';
	
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

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRAPRRF.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRAPRRF.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )312;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )335;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:p_language_id,t_date);

		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )366;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )15;
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
 sqlstm.sqhstl[2] = (unsigned int  )15;
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

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 
}