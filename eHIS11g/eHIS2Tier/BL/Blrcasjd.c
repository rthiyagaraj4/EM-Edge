
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
           char  filnam[41];
};
static const struct sqlcxp sqlfpn =
{
    40,
    "D:\\work\\october\\kauh_scf\\11g\\Blrcasjd.pc"
};


static unsigned long sqlctx = 507111035;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {10,18};

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
"999)) and CASH_COUNTER_FACILITY_ID=:b12) order by TRUNC(DOC_DATE),CASH_COUNT\
ER_CODE,SHIFT_ID,RECPT_REFUND_IND,DOC_TYPE_CODE,DOC_NUMBER,DOC_SRNO           \
 ";

 static const char *sq0008 = 
"select SHORT_DESC  from BL_SLMT_TYPE_lang_vw where (SLMT_TYPE_CODE=:b0 and l\
anguage_id=:b1)           ";

 static const char *sq0007 = 
"select A.SLMT_TYPE_CODE ,B.SHORT_DESC ,sum(NVL(DOC_AMT,0)) ,sum(NVL(DOC_AMT,\
0))  from BL_RECEIPT_REFUND_hdrDTL_vw A ,BL_SLMT_TYPE_lang_vw B where ((((((((\
((TRUNC(A.DOC_DATE,'MI') between TO_DATE(:b0,'DD/MM/YYYY HH24:MI') and TO_DATE\
(:b1,'DD/MM/YYYY HH24:MI') and language_id=:b2) and CASH_COUNTER_CODE between \
NVL(:b3,'!!') and NVL(:b4,'~~')) and SHIFT_ID between NVL(:b5,'!') and NVL(:b6\
,'~')) and A.ADDED_BY_ID between NVL(:b7,'!!!!!!!!!!!!!!!!!!!!') and NVL(:b7,'\
~~~~~~~~~~~~~~~~~~~~')) and NVL(CANCELLED_IND,'X')<>'Y') and A.SLMT_TYPE_CODE=\
B.SLMT_TYPE_CODE) and b.language_id=:b2) and NVL(A.CASH_CTRL_DOC_TYPE_CODE,'!!\
!!!!') between NVL(:b10,'!!!!!!') and NVL(:b11,'~~~~~~')) and NVL(A.CASH_CTRL_\
DOC_NUMBER,0) between NVL(:b12,0) and NVL(:b13,9999999999999999999)) and A.CAS\
H_COUNTER_FACILITY_ID=:b14) group by A.SLMT_TYPE_CODE,B.SHORT_DESC           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4146,0,0,0,
5,0,0,1,0,0,27,141,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,270,0,4,178,0,0,14,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
107,0,0,3,158,0,4,234,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
142,0,0,4,0,0,30,269,0,0,0,0,0,1,0,
157,0,0,5,91,0,2,277,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
180,0,0,6,1179,0,9,378,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
247,0,0,6,0,0,13,427,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
2,9,0,0,2,1,0,0,2,9,0,0,
334,0,0,7,0,0,13,489,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
365,0,0,8,102,0,9,518,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
388,0,0,8,0,0,13,526,0,0,1,0,0,1,0,2,9,0,0,
407,0,0,7,855,0,9,701,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
482,0,0,7,0,0,15,721,0,0,0,0,0,1,0,
497,0,0,9,96,0,4,970,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
520,0,0,10,165,0,6,977,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
551,0,0,11,140,0,6,998,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*                         BLRCASJD.PC                                     */
/* Program to Print Daily Cashier Journal by Counter                         */
/* PARAMETER - From Report Date                                              */
/*             To   Report Date                                              */
/*             From Cash Counter Code                                        */  
/*             To   Cash Counter Code                                        */
/*             From Shift Id                                                 */
/*             To   Shift Id                                                 */
/*                                                                           */
/* TABLE     - BL_RECEIPT_REFUND_DTL                                         */
/*****************************************************************************/
                         
/*  
#define DEBUG        
*/    

#include <stdio.h>
#include <string.h>
#include <bl.h>
#define ESC     0x1B



/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[91],
			d_session_id[16],
			d_pgm_date[14],
			rep_date[20],
			comp_name[50],
			nd_temp_date[21],
			p_language_id[3],
			date_convert[21],
			nd_loc_date[21],
			nd_facility_id[3],
			oper_id[21]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[21]; } oper_id;
      
 
    /* VARCHAR report_date_fm          [17],
		    report_date_to          [17],
		    cash_counter_fm         [5],
		    cash_counter_to         [5],
		    shift_id_fm             [2],
		    shift_id_to             [2]; */ 
struct { unsigned short len; unsigned char arr[17]; } report_date_fm;

struct { unsigned short len; unsigned char arr[17]; } report_date_to;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_fm;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_to;

struct { unsigned short len; unsigned char arr[2]; } shift_id_fm;

struct { unsigned short len; unsigned char arr[2]; } shift_id_to;

	
   /* VARCHAR d_doc_type_code                             [7],
	   d_doc_number                                [9],
	   d_doc_srno								   [3],
	   d_doc_date                                  [13],
	   d_doc_date1                                  [13],
	   d_trx_date_time                             [17],
	   d_bill_doc_type_code                        [7],
	   d_bill_doc_number                           [9],
	   d_bill_doc_srno		                       [7],
	   d_cash_counter_code                         [5],
	   d_shift_id                                  [2],
	   d_doc_amt                                   [23],
	   d_slmt_type_code                            [3],
	   d_slmt_type_desc                            [41],
	   d_episode_id                                [9],
	   d_status                                    [2],
	   d_user_id                                   [21],
	   d_cancel_reason							   [51],
	   l_pk_value								   [100],
	   l_translated_value	                       [201],
	   d_added_by_id                               [21],
	   nd_operating_facility_id					   [3]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[3]; } d_doc_srno;

struct { unsigned short len; unsigned char arr[13]; } d_doc_date;

struct { unsigned short len; unsigned char arr[13]; } d_doc_date1;

struct { unsigned short len; unsigned char arr[17]; } d_trx_date_time;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_bill_doc_number;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_srno;

struct { unsigned short len; unsigned char arr[5]; } d_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } d_shift_id;

struct { unsigned short len; unsigned char arr[23]; } d_doc_amt;

struct { unsigned short len; unsigned char arr[3]; } d_slmt_type_code;

struct { unsigned short len; unsigned char arr[41]; } d_slmt_type_desc;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[2]; } d_status;

struct { unsigned short len; unsigned char arr[21]; } d_user_id;

struct { unsigned short len; unsigned char arr[51]; } d_cancel_reason;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[21]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;


  char d_doc_amt2[20];

  /* VARCHAR  d_prv_cash_counter_code                      [5],
	   d_prv_doc_date                               [13],
	   d_prv_shift_id                               [11]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_prv_cash_counter_code;

struct { unsigned short len; unsigned char arr[13]; } d_prv_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_prv_shift_id;


     char  d_dup_flag;

    double d_doc_amt_num, d_doc_amt1,
		   nd_doc_amt,
		   tot_doc_amt;

char filename[150];
	char loc_legend[999][201];
	int i;	

   /* VARCHAR cash_ctrl_doc_type_fm			[7],
	    cash_ctrl_doc_type_to			[7],	    
	   cash_ctrl_doc_num_fm[50],
	   cash_ctrl_doc_num_to[50]; */ 
struct { unsigned short len; unsigned char arr[7]; } cash_ctrl_doc_type_fm;

struct { unsigned short len; unsigned char arr[7]; } cash_ctrl_doc_type_to;

struct { unsigned short len; unsigned char arr[50]; } cash_ctrl_doc_num_fm;

struct { unsigned short len; unsigned char arr[50]; } cash_ctrl_doc_num_to;



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

FILE *f1;

int page_no,
    line_no,
    first_line,
    d_seq_no,
    g_hdr_cnt,
    g_err_typ,
    g_page_break;

char file_name[15],
     g_acct_code[41],
     g_err_id[8],
     g_err_msg[72];

double g_tot_cntr_shift,
       g_tot_counter,
       g_grand_tot;

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc < 5) {
	disp_message(ERR_MESG,"BLRCASJD : Usage BLRCASJD userid/password session_id pgm_date facility_id");
	proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(g_pgm_id,"BLRCASJD");
    strcpy(g_pgm_date,argv[3]);

    /* EXEC SQL CONNECT :uid_pwd; */ 

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
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(ERROR) {
		disp_message(ORA_MESG,"Unable to connect to oracle.");
		proc_exit();
    }

    set_meduser_role();
 
   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;
   
    start_prog_msg();

   report_date_fm.arr[0]           = '\0';
   report_date_to.arr[0]           = '\0';
   cash_counter_fm.arr[0]          = '\0';
   cash_counter_to.arr[0]          = '\0';
   shift_id_fm.arr[0]              = '\0';
   shift_id_to.arr[0]              = '\0';
   cash_ctrl_doc_type_fm.arr[0]    = '\0';
   cash_ctrl_doc_type_to.arr[0]    = '\0';
   cash_ctrl_doc_num_fm.arr[0]	   = '\0';
   cash_ctrl_doc_num_to.arr[0]	   = '\0';

   report_date_fm.len              = 0;
   report_date_to.len              = 0;
   cash_counter_fm.len             = 0;
   cash_counter_to.len             = 0;
   shift_id_fm.len                 = 0;
   shift_id_to.len                 = 0;

   cash_ctrl_doc_type_fm.len	   = 0;
   cash_ctrl_doc_type_to.len	   = 0;
   cash_ctrl_doc_num_fm.len	   = 0;
   cash_ctrl_doc_num_to.len	   = 0;

	/* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,            /o REP_DATE_FM                o/
					PARAM2,            /o REP_DATE_TO                o/
					PARAM3,            /o CASH_COUNTER_FM            o/
					PARAM4,            /o CASH_COUNTER_TO            o/
					PARAM5,            /o SHIFT_NO_FM                o/
					PARAM6,            /o SHIFT_NO_TO                o/
					PARAM7,
					PARAM8,		   /o CASH CONTROL FROM DOC TYPE o/	
					PARAM9,            /o CASH CONTROL FROM DOC NUM  o/
					PARAM10,	   /o CASH CONTROL TO DOC TYPE   o/
					PARAM11	           /o CASH CONTROL TO DOC NUM    o/
		 INTO       :nd_operating_facility_id,
			    :report_date_fm,
			    :report_date_to,
			    :cash_counter_fm,
			    :cash_counter_to,
			    :shift_id_fm,
			    :shift_id_to,
			    :d_user_id,
			    :cash_ctrl_doc_type_fm,
			    :cash_ctrl_doc_num_fm,
	                    :cash_ctrl_doc_type_to,
	                    :cash_ctrl_doc_num_to	    
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRCASJD'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 into :b0,:b1,:b2,:b\
3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11  from SY_PROG_PARAM where ((PGM_ID='BLRCAS\
JD' and PGM_DATE=:b12) and SESSION_ID=TO_NUMBER(:b13))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
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
 sqlstm.sqhstv[1] = (         void  *)&report_date_fm;
 sqlstm.sqhstl[1] = (unsigned int  )19;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&report_date_to;
 sqlstm.sqhstl[2] = (unsigned int  )19;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&cash_counter_fm;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&cash_counter_to;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&shift_id_fm;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&shift_id_to;
 sqlstm.sqhstl[6] = (unsigned int  )4;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_user_id;
 sqlstm.sqhstl[7] = (unsigned int  )23;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&cash_ctrl_doc_type_fm;
 sqlstm.sqhstl[8] = (unsigned int  )9;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&cash_ctrl_doc_num_fm;
 sqlstm.sqhstl[9] = (unsigned int  )52;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&cash_ctrl_doc_type_to;
 sqlstm.sqhstl[10] = (unsigned int  )9;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&cash_ctrl_doc_num_to;
 sqlstm.sqhstl[11] = (unsigned int  )52;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[12] = (unsigned int  )16;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_session_id;
 sqlstm.sqhstl[13] = (unsigned int  )18;
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



    if(ERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

   report_date_fm.arr[report_date_fm.len]            = '\0';
   report_date_to.arr[report_date_to.len]            = '\0';
   cash_counter_fm.arr[cash_counter_fm.len]          = '\0';
   cash_counter_to.arr[cash_counter_to.len]          = '\0';
   shift_id_fm.arr[shift_id_fm.len]                  = '\0';
   shift_id_to.arr[shift_id_to.len]                  = '\0';
   cash_ctrl_doc_type_fm.arr[cash_ctrl_doc_type_fm.len] = '\0';
   cash_ctrl_doc_type_to.arr[cash_ctrl_doc_type_to.len] = '\0';
   cash_ctrl_doc_num_fm.arr[cash_ctrl_doc_num_fm.len]   = '\0';
   cash_ctrl_doc_num_to.arr[cash_ctrl_doc_num_to.len]   = '\0';

   d_user_id.arr[d_user_id.len]                              = '\0';
   
   strcpy(filename,WORKING_DIR);
   strcat(filename,"blrcasjd.lis");
   strcpy(g_facility_id, nd_operating_facility_id.arr);
    
    if( (f1=fopen(filename,"w")) == NULL) 
	{
	   disp_message(ERR_MESG,"Error in opening output file...");
	   proc_exit();
    }


    /* EXEC SQL SELECT ACC_ENTITY_NAME,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		    USER 
	     INTO   :comp_name,
				:rep_date,
				:oper_id
	     FROM   SY_ACC_ENTITY_lang_vw
	     WHERE  ACC_ENTITY_ID = :nd_operating_facility_id
		 AND		language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )107;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    sqlstm.sqhstl[2] = (unsigned int  )23;
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



    if(ERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';

    page_no=1;
    line_no=1;
fetch_legend_value();

    decl_curs();

fprintf (f1,"%c&l1O",ESC);
fprintf(f1,"%c(s14H",ESC); 
fprintf(f1,"\n");
    put_inp_parm();

    do_report();

    fclose(f1);

    del_parm();
    end_prog_msg();

    /* EXEC SQL COMMIT RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )142;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}

del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
	 WHERE  PGM_ID     = 'BLRCASJD' 
	 AND    PGM_DATE   = :d_pgm_date
	 AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRCASJD' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )157;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )16;
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



    if(ERROR) 
	err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 

}


decl_curs()
{

     /* EXEC SQL DECLARE BL_REC_REF_CUR CURSOR FOR
	       SELECT CASH_COUNTER_CODE,
		      SHIFT_ID,
		      TO_CHAR(TRX_DATE_TIME,'DD/MM/YYYY HH24:MI'),
		      DOC_TYPE_CODE,
		      DOC_NUMBER,
			  DOC_SRNO,
		      to_char(TRUNC(DOC_DATE),'dd/mm/yyyy'),
		      BILL_DOC_TYPE_CODE,
		      LTRIM(TO_CHAR(BILL_DOC_NUMBER,'00000009')),
			  BILL_DOC_SRNO,
		      SLMT_TYPE_CODE,
				      EPISODE_ID,
		      DECODE(RECPT_REFUND_IND,'R',DOC_AMT, -DOC_AMT),
		      DOC_AMT,
		      //TO_CHAR(DOC_AMT,'999,999,990.99'),
			      DECODE(RECPT_REFUND_IND,
				      'R',DECODE(NVL(CANCELLED_IND,'N'),'Y','V',' '),
			      DECODE(NVL(CANCELLED_IND,'N'),'Y','V','F')),
				      ADDED_BY_ID,
		      DECODE(REPRINT_YN,'Y','D',' '),
			  CANCEL_REASON
		FROM BL_RECEIPT_REFUND_hdrDTL_vw
		/o WHERE ADDED_DATE  BETWEEN o/
                WHERE TRUNC(DOC_DATE,'MI')   BETWEEN
			TO_DATE(:report_date_fm,'DD/MM/YYYY HH24:MI')
			AND
			TO_DATE(:report_date_to,'DD/MM/YYYY HH24:MI')
		  AND CASH_COUNTER_CODE BETWEEN
			  NVL(:cash_counter_fm,'!!') AND 
			  NVL(:cash_counter_to,'~~')
		  AND SHIFT_ID BETWEEN
			  NVL(:shift_id_fm,'!') AND 
			  NVL(:shift_id_to,'~') 
	      AND ADDED_BY_ID BETWEEN		  
			  NVL(:d_user_id,'!!!!!!!!!!!!!!!!!!!!')
	      AND NVL(:d_user_id,'~~~~~~~~~~~~~~~~~~~~')
	      AND NVL(CASH_CTRL_DOC_TYPE_CODE,'!!!!!!') BETWEEN NVL(:cash_ctrl_doc_type_fm,'!!!!!!')
			AND NVL(:cash_ctrl_doc_type_to,'~~~~~~')
		  AND NVL(CASH_CTRL_DOC_NUMBER,0) BETWEEN NVL(:cash_ctrl_doc_num_fm,0) AND 
			NVL(:cash_ctrl_doc_num_to,9999999999999999999)
		  AND CASH_COUNTER_FACILITY_ID  = :nd_operating_facility_id		  
		ORDER BY TRUNC(DOC_DATE),CASH_COUNTER_CODE,SHIFT_ID,RECPT_REFUND_IND,
			 DOC_TYPE_CODE,DOC_NUMBER,DOC_SRNO; */ 


/*---------- Added to fetch the Slmt Totals ----------*/
 
   /* EXEC SQL DECLARE BL_SLMT_TOTALS CURSOR FOR
               SELECT A.SLMT_TYPE_CODE,
		              B.SHORT_DESC,
				      /o TO_CHAR(SUM(DOC_AMT),'999,999,990.99'),o/
					  SUM(NVL(DOC_AMT,0)),
				      SUM(NVL(DOC_AMT,0))
                 FROM BL_RECEIPT_REFUND_hdrDTL_vw A, BL_SLMT_TYPE_lang_vw B
		  /o WHERE A.ADDED_DATE  BETWEEN o/
                  WHERE TRUNC(A.DOC_DATE,'MI')  BETWEEN 
				TO_DATE(:report_date_fm,'DD/MM/YYYY HH24:MI') AND
				TO_DATE(:report_date_to,'DD/MM/YYYY HH24:MI')
		  AND		language_id=:p_language_id		
		  AND CASH_COUNTER_CODE BETWEEN
			  NVL(:cash_counter_fm,'!!') AND 
			  NVL(:cash_counter_to,'~~')
		  AND SHIFT_ID BETWEEN
			  NVL(:shift_id_fm,'!') AND 
			  NVL(:shift_id_to,'~')
		  AND A.ADDED_BY_ID BETWEEN		  
			  NVL(:d_user_id,'!!!!!!!!!!!!!!!!!!!!')
	      AND NVL(:d_user_id,'~~~~~~~~~~~~~~~~~~~~')		  
		  AND NVL(CANCELLED_IND,'X') != 'Y'
		  AND A.SLMT_TYPE_CODE = B.SLMT_TYPE_CODE
		  and b.language_id=:p_language_id
		  AND NVL(A.CASH_CTRL_DOC_TYPE_CODE,'!!!!!!') BETWEEN NVL(:cash_ctrl_doc_type_fm,'!!!!!!')
			AND NVL(:cash_ctrl_doc_type_to,'~~~~~~')
		  AND NVL(A.CASH_CTRL_DOC_NUMBER,0) BETWEEN NVL(:cash_ctrl_doc_num_fm,0) AND 
			NVL(:cash_ctrl_doc_num_to,9999999999999999999)
		  AND A.CASH_COUNTER_FACILITY_ID  = :nd_operating_facility_id
		GROUP BY A.SLMT_TYPE_CODE,B.SHORT_DESC; */ 


 /*---------------------------------------------------*/
 
 
    /* EXEC SQL DECLARE SLMT_TYPE_CUR CURSOR FOR
	     SELECT  SHORT_DESC
	     FROM    BL_SLMT_TYPE_lang_vw
	     WHERE   SLMT_TYPE_CODE = :d_slmt_type_code
         AND		language_id=:p_language_id; */ 


    /* EXEC SQL OPEN BL_REC_REF_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select CASH_COUNTER_CODE ,SHIFT_ID ,TO_CHAR(TRX_DATE_TIME,'DD/MM/YYYY\
 HH24:MI') ,DOC_TYPE_CODE ,DOC_NUMBER ,DOC_SRNO ,to_char(TRUNC(DOC_DATE),'dd\
/mm/yyyy') ,BILL_DOC_TYPE_CODE ,LTRIM(TO_CHAR(BILL_DOC_NUMBER,'00000009')) ,\
BILL_DOC_SRNO ,SLMT_TYPE_CODE ,EPISODE_ID ,DECODE(RECPT_REFUND_IND,'R',DOC_A\
MT,(-DOC_AMT)) ,DOC_AMT ,DECODE(RECPT_REFUND_IND,'R',DECODE(NVL(CANCELLED_IN\
D,'N'),'Y','V',' '),DECODE(NVL(CANCELLED_IND,'N'),'Y','V','F')) ,ADDED_BY_ID\
 ,DECODE(REPRINT_YN,'Y','D',' ') ,CANCEL_REASON  from BL_RECEIPT_REFUND_hdrD\
TL_vw where ((((((TRUNC(DOC_DATE,'MI') between TO_DATE(:b0,'DD/MM/YYYY HH24:\
MI') and TO_DATE(:b1,'DD/MM/YYYY HH24:MI') and CASH_COUNTER_CODE between NVL\
(:b2,'!!') and NVL(:b3,'~~')) and SHIFT_ID between NVL(:b4,'!') and NVL(:b5,\
'~')) and ADDED_BY_ID between NVL(:b6,'!!!!!!!!!!!!!!!!!!!!') and NVL(:b6,'~\
~~~~~~~~~~~~~~~~~~~')) and NVL(CASH_CTRL_DOC_TYPE_CODE,'!!!!!!') between NVL\
(:b8,'!!!!!!') and NVL(:b9,'~~~~~~')) and NVL(CASH_CTRL_DOC_NUMBER,0) betwee\
n NVL(:b10,0) and NVL(:b11,9999999999999999");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )180;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&report_date_fm;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&report_date_to;
    sqlstm.sqhstl[1] = (unsigned int  )19;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&cash_counter_fm;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&cash_counter_to;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&shift_id_fm;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&shift_id_to;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_user_id;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_user_id;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&cash_ctrl_doc_type_fm;
    sqlstm.sqhstl[8] = (unsigned int  )9;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&cash_ctrl_doc_type_to;
    sqlstm.sqhstl[9] = (unsigned int  )9;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&cash_ctrl_doc_num_fm;
    sqlstm.sqhstl[10] = (unsigned int  )52;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&cash_ctrl_doc_num_to;
    sqlstm.sqhstl[11] = (unsigned int  )52;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[12] = (unsigned int  )5;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor BL_REC_REF_CUR",0,"");

}

fetch_bl_rec()
{

    d_cash_counter_code.arr[0]                                        = '\0';
    d_shift_id.arr[0]                                                 = '\0';
    d_trx_date_time.arr[0]                                            = '\0';
    d_doc_type_code.arr[0]                                            = '\0';
    d_doc_number.arr[0]                                               = '\0';
	d_doc_srno.arr[0]												  = '\0';
    d_doc_date.arr[0]                                                 = '\0';
    d_bill_doc_type_code.arr[0]                                       = '\0';
    d_bill_doc_number.arr[0]                                          = '\0';
	d_bill_doc_srno.arr[0]			                                  = '\0';
    d_slmt_type_code.arr[0]                                           = '\0';
    d_episode_id.arr[0]                                               = '\0';
    d_doc_amt.arr[0]                                                  = '\0';
    d_status.arr[0]                                                   = '\0';
    d_added_by_id.arr[0]                                              = '\0';
    d_cancel_reason.arr[0]                                            = '\0';

    d_cash_counter_code.len                                           = 0;
    d_shift_id.len                                                    = 0;
    d_trx_date_time.len                                               = 0;
    d_doc_type_code.len                                               = 0;
	d_doc_srno.len													  = 0;
    d_doc_number.len                                                  = 0;
    d_doc_date.len                                                    = 0;
    d_bill_doc_type_code.len                                          = 0;
    d_bill_doc_number.len                                             = 0;
	d_bill_doc_srno.len                                               = 0;
    d_slmt_type_code.len                                              = 0;
    d_episode_id.len                                                  = 0;
    d_doc_amt.len                                                     = 0;
    d_status.len                                                      = 0;
    d_added_by_id.len                                                 = 0;
    d_cancel_reason.len                                               = 0;

    d_dup_flag = '\0';

    d_doc_amt_num = 0;

 
     /* EXEC SQL FETCH BL_REC_REF_CUR
	       INTO :d_cash_counter_code,
		    :d_shift_id,
		    :d_trx_date_time,
		    :d_doc_type_code,
		    :d_doc_number,
			:d_doc_srno,
		    :d_doc_date,
		    :d_bill_doc_type_code,
		    :d_bill_doc_number,
			:d_bill_doc_srno,
		    :d_slmt_type_code,
 		    :d_episode_id,
		    :d_doc_amt_num,
		    :d_doc_amt1,
		    :d_status,
		    :d_added_by_id,
		    :d_dup_flag,
	  	    :d_cancel_reason; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )247;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_cash_counter_code;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_shift_id;
     sqlstm.sqhstl[1] = (unsigned int  )4;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_trx_date_time;
     sqlstm.sqhstl[2] = (unsigned int  )19;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_doc_type_code;
     sqlstm.sqhstl[3] = (unsigned int  )9;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_doc_number;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_doc_srno;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_doc_date;
     sqlstm.sqhstl[6] = (unsigned int  )15;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_bill_doc_type_code;
     sqlstm.sqhstl[7] = (unsigned int  )9;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_bill_doc_number;
     sqlstm.sqhstl[8] = (unsigned int  )11;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_bill_doc_srno;
     sqlstm.sqhstl[9] = (unsigned int  )9;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_slmt_type_code;
     sqlstm.sqhstl[10] = (unsigned int  )5;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&d_episode_id;
     sqlstm.sqhstl[11] = (unsigned int  )11;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&d_doc_amt_num;
     sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&d_doc_amt1;
     sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&d_status;
     sqlstm.sqhstl[14] = (unsigned int  )4;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&d_added_by_id;
     sqlstm.sqhstl[15] = (unsigned int  )23;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&d_dup_flag;
     sqlstm.sqhstl[16] = (unsigned int  )1;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&d_cancel_reason;
     sqlstm.sqhstl[17] = (unsigned int  )53;
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



    if(ERROR)
	err_mesg("FETCH failed on cursor BL_REC_REF_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_cash_counter_code.arr[d_cash_counter_code.len]                     = '\0';
    d_shift_id.arr[d_shift_id.len]                                       = '\0';
    d_trx_date_time.arr[d_trx_date_time.len]                             = '\0';
    d_doc_type_code.arr[d_doc_type_code.len]                             = '\0';
    d_doc_number.arr[d_doc_number.len]                                   = '\0';
	d_doc_srno.arr[d_doc_srno.len]										 = '\0';
    d_doc_date.arr[d_doc_date.len]                                       = '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]                   = '\0';
    d_bill_doc_number.arr[d_bill_doc_number.len]                         = '\0';
	d_bill_doc_srno.arr[d_bill_doc_srno.len]                             = '\0';
    d_doc_amt.arr[d_doc_amt.len]                                         = '\0';
    d_slmt_type_code.arr[d_slmt_type_code.len]                           = '\0';
    d_episode_id.arr[d_episode_id.len]                                   = '\0';
    d_status.arr[d_status.len]                                           = '\0';
    d_added_by_id.arr[d_added_by_id.len]                                 = '\0';
    d_cancel_reason.arr[d_cancel_reason.len]                             = '\0';

    return 1;

}

fetch_slmt_totals()
{

    d_slmt_type_code.arr[0]  = '\0';
    d_slmt_type_desc.arr[0]  = '\0';
//  d_doc_amt.arr[0]         = '\0';

    d_slmt_type_code.len     = 0;
    d_slmt_type_desc.len     = 0;
//  d_doc_amt.len            = 0;
    
	nd_doc_amt			     = 0;

    d_doc_amt_num = 0;

     /* EXEC SQL FETCH BL_SLMT_TOTALS
               INTO :d_slmt_type_code,
		    :d_slmt_type_desc,
                    :nd_doc_amt,
                    :d_doc_amt_num; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )334;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_slmt_type_desc;
     sqlstm.sqhstl[1] = (unsigned int  )43;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_doc_amt;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_doc_amt_num;
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



    if(ERROR)
	err_mesg("FETCH failed on cursor BL_REC_REF_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_slmt_type_code.arr[d_slmt_type_code.len]   = '\0';
    d_slmt_type_desc.arr[d_slmt_type_desc.len]   = '\0';
  //   d_doc_amt.arr[d_doc_amt.len]                 = '\0';

   

   
    tot_doc_amt = tot_doc_amt + nd_doc_amt;


    return 1;
	
}

fetch_slmt_desc()
{

    /* EXEC SQL OPEN SLMT_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )365;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor SLMT_TYPE_CUR",0,"");

    d_slmt_type_desc.arr[0]  = '\0';
    d_slmt_type_desc.len  = 0;

    /* EXEC SQL FETCH SLMT_TYPE_CUR
	     INTO  :d_slmt_type_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )388;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_desc;
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



    if(ERROR)
	err_mesg("FETCH failed on cursor SLMT_TYPE_CUR",0,"");

    d_slmt_type_desc.arr[d_slmt_type_desc.len]  = '\0';

}

do_report()
{

    int cnt,first,brk;
    char s_amt[20];

    g_tot_cntr_shift = 0;
    g_tot_counter    = 0;
    g_grand_tot = 0;

    line_no = 1;

    g_hdr_cnt = 0;
    init_prv_values();

    while(fetch_bl_rec()) {

	if(!g_hdr_cnt)
	   put_hdr();

	if((brk = change())) {
	    if(g_hdr_cnt)
		print_totals(brk,1);
	    copy_val();
	    put_rec(brk);
	}
	else {
	    copy_val();
	    put_rec(0);
	}

	if(d_status.arr[0] == 'F') {
	   g_tot_cntr_shift -= d_doc_amt_num;
	   g_tot_counter    -= d_doc_amt_num;
	   g_grand_tot      -= d_doc_amt_num;
	}
	 else if(d_status.arr[0] == ' ') {
	   g_tot_cntr_shift += d_doc_amt_num;
	   g_tot_counter    += d_doc_amt_num;
	   g_grand_tot      += d_doc_amt_num;
	 }
/*
	g_tot_cntr_shift += d_doc_amt_num;
	g_tot_counter    += d_doc_amt_num;

	g_grand_tot += d_doc_amt_num;
*/

	g_hdr_cnt = 1;
    }

    if(g_hdr_cnt) {
	print_totals(2,0);
	print_grand_totals();
    }
	
    if(g_hdr_cnt) print_slmt_totals();
	
    print_end_of_rep();

}


put_hdr()
{

	init_date_temp_var();                              //pradeep

	strcpy(date_convert.arr,rep_date.arr);            // pradeep
 	fun_change_loc_date();
     fprintf(f1,"%5.5s : %-3s                                             %-59.59s%-10.10s\n",loc_legend[330],loc_legend[150],comp_name.arr,date_convert.arr);

    fprintf(f1,"%5.5s : %s\n",loc_legend[340],oper_id.arr);

    fprintf(f1,"%5.5s : %-10.10s                                    %-62.62s%-5.5s : %4d\n",loc_legend[350],loc_legend[40],loc_legend[50],loc_legend[30],page_no);

    /* Added by Irfan J.S on 16/04/2000  */
	

	


	if (d_doc_date.arr[0] =='\0') 
	
	fprintf(f1,"\n\n");
       
   else
   {
   	init_date_temp_var();                              //pradeep
     
	strcpy(date_convert.arr,d_doc_date.arr);            // pradeep
 	fun_change_loc_date();
        fprintf(f1,"                                                 %-25.25s : %10s \n\n",loc_legend[160],date_convert.arr);
	   }
     fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"%-6.6s %-9.9s %-19.19s %-17.17s %-21.21s %-17.17s %-13.13s %-16.16s%-8.8s%-12.12s \n",loc_legend[170],loc_legend[180],loc_legend[190],loc_legend[200],loc_legend[210],loc_legend[120],loc_legend[220],loc_legend[230],loc_legend[240],loc_legend[250]);

	fprintf(f1,"      %-17.17s \n",loc_legend[260]);
/*
	           "9999   XX/9    DD/MM/YYYY HH:MI   XXXXXX/99999999  X  XXXXXX/99999999  XX XXXXXXXXXXXXXXX 99999999 999,999,999.99    X    xxxxxxxx"
*/
    fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");

    line_no=9;

}

put_rec(flg) 
int flg;
{
    chk_break(1);
    fetch_slmt_desc();
    d_seq_no++;

		init_date_temp_var();

		strcpy(date_convert.arr,d_trx_date_time.arr);
 		if (d_trx_date_time.arr[0]!='\0')
		{
		fun_change_loc_date();
        fprintf(f1,"%5d  %-4.4s/%-5.5s %-18.18s  %-6.6s/%-7.7s/%-1s%c %-7.7s/%-9.9s/%-3.3s ",
	    d_seq_no, d_cash_counter_code.arr,d_shift_id.arr,
	    date_convert.arr,d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr,d_dup_flag,
	    d_bill_doc_type_code.arr, d_bill_doc_number.arr,d_bill_doc_srno.arr );
		}

/*
	       "9999   XX/9    DD/MM/YYYY HH:MI   XXXXXX/99999999  X  XXXXXX/99999999  XX XXXXXXXXXXXXXXX 99999999 999,999,999.99    X    xxxxxxxx"
*/
   print_formated1(d_doc_amt1,d_doc_amt2);   

    fprintf(f1,"%-2.2s %-14.14s%-12.12s%16.16s   %-8.8s %-10.10s\n", 
	    d_slmt_type_code.arr, d_slmt_type_desc.arr, d_episode_id.arr,
	    d_doc_amt2,d_status.arr,d_added_by_id.arr);

	line_no++;

	if(d_cancel_reason.arr[0] != '\0') 
	{	
		fprintf(f1,"       %-51s\n",d_cancel_reason.arr);
		line_no++;
	}

}

/*------ Added to Print Slmt Totals ------------*/

print_slmt_totals()
{
    char s_amt[20];
	tot_doc_amt = 0;

    chk_break(4);
	/*--------- Page Skip Added on 13/3/1999 ----------*/
	 fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
	/*-------------------------------------------------*/

    fprintf(f1,"\n\n%-45.45s\n",loc_legend[270]);
    fprintf(f1,"----------------------------------------------\n\n");
    line_no += 5;

    /* EXEC SQL OPEN BL_SLMT_TOTALS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )407;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&report_date_fm;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&report_date_to;
    sqlstm.sqhstl[1] = (unsigned int  )19;
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
    sqlstm.sqhstv[3] = (         void  *)&cash_counter_fm;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&cash_counter_to;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&shift_id_fm;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&shift_id_to;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_user_id;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_user_id;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&p_language_id;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&cash_ctrl_doc_type_fm;
    sqlstm.sqhstl[10] = (unsigned int  )9;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&cash_ctrl_doc_type_to;
    sqlstm.sqhstl[11] = (unsigned int  )9;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&cash_ctrl_doc_num_fm;
    sqlstm.sqhstl[12] = (unsigned int  )52;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&cash_ctrl_doc_num_to;
    sqlstm.sqhstl[13] = (unsigned int  )52;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[14] = (unsigned int  )5;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
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


    if(ERROR)
	err_mesg("OPEN failed on cursor BL_SLMT_TOTALS",0,"");
     
    while(fetch_slmt_totals()) {
       chk_break(1);
	   
       fprintf(f1,"%-2s %-16.16s    ", 
		  d_slmt_type_code.arr, d_slmt_type_desc.arr);
       print_formated(nd_doc_amt);
		
       line_no ++;
    }

	 fprintf(f1,"%-18s"," ");
	   fprintf(f1,"-----------------------\n");
	   fprintf(f1,"%-9.9s              ",loc_legend[280]);
	   print_formated(tot_doc_amt);
	   fprintf(f1,"%-18s"," ");
	   fprintf(f1,"-----------------------\n");
    /* EXEC SQL CLOSE BL_SLMT_TOTALS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )482;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(ERROR)
	err_mesg("CLOSE failed on cursor BL_SLMT_TOTALS",0,"");
}


/*----------------------------------------------*/

print_totals(brk,new_page)
int brk, new_page;
{

    char s_amt[20];

    chk_break(brk+1);

    fprintf(f1,"\n");

    if(brk >= 1) {
	put_val(s_amt,g_tot_cntr_shift);
	format_amt(s_amt);
	fprintf(f1,"%45s %-31.31s %-2.2s/%-1s   :  ",
		   "",loc_legend[290],d_prv_cash_counter_code.arr,d_prv_shift_id.arr);
	fprintf(f1,"%19s %15s\n\n"," ",s_amt);
	g_tot_cntr_shift  = 0;
	d_seq_no          = 0;
	
    }

    if(brk >= 2) {
	put_val(s_amt,g_tot_counter);
	format_amt(s_amt);
	fprintf(f1,"%45s %-25.25s %-2s         :  ",
		   "",loc_legend[300],d_prv_cash_counter_code.arr);
	fprintf(f1,"%19s %15s\n"," ",s_amt);
	g_tot_counter = 0;
    }

    if(brk == 3)
	print_grand_totals();

    line_no += brk+2;

    if(brk > 2 && new_page) {
	   fprintf(f1,"");
	   line_no = 1;
	   ++page_no;
	   put_hdr();
    }

}

print_grand_totals()
{
    char s_amt[20];

    chk_break(2);

    put_val(s_amt,g_grand_tot);
    format_amt(s_amt);
    fprintf(f1,"\n%45s %-28.28s           :  ","",loc_legend[310]);
    fprintf(f1,"%19s %15s\n\n", " ",s_amt);
    
    g_grand_tot = 0;
    line_no += 3;

}

chk_break(nol)
int nol;
{
	g_page_break = 0;

	if(line_no+nol >= 55) {
	   g_page_break = 1;
	   fprintf(f1,"");
	   line_no = 1;
	   ++page_no;
	   put_hdr();
	}

}

put_inp_parm()
{
	init_date_temp_var();
	strcpy(date_convert.arr,rep_date.arr);
	fun_change_loc_date();
    fprintf(f1,"%5.5s : %-3s                                             %-59.59s%-10.10s\n",loc_legend[330],loc_legend[150],comp_name.arr,date_convert.arr);
    fprintf(f1,"%5.5s : %s\n",loc_legend[340],oper_id.arr);
    fprintf(f1,"%5.5s : %-10.10s                                    %-62.62s%-5.5s : %4d\n",loc_legend[350],loc_legend[40],loc_legend[50],loc_legend[30],page_no);

    //fprintf(f1,"                                                    %16s  -  %16.16s\n",report_date_fm.arr, report_date_to.arr);
	init_date_temp_var();
	strcpy(date_convert.arr,report_date_fm.arr);
	fun_change_loc_date();
	fprintf(f1,"                                                    %16.16s  - ",date_convert.arr);
	init_date_temp_var();
	strcpy(date_convert.arr,report_date_to.arr);
	fun_change_loc_date();
	fprintf(f1," %-16.16s\n",date_convert.arr);
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n\n");
    //fprintf(f1,"VER : 4.1\n"); COMMENTED BY SAIKIRAN FOR 19587
    fprintf(f1,"%s : 4.1\n",loc_legend[391]); 
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\t%-25s\n",loc_legend[360]);
    fprintf(f1,"\t----------------\n\n");

	if(report_date_fm.arr[0]=='\0')
		fprintf(f1,"\t\t%-31s %-8s : %-6s\n",loc_legend[80],loc_legend[60],loc_legend[390]);
	else
	init_date_temp_var();                              //pradeep

	strcpy(date_convert.arr,report_date_fm.arr);            // pradeep

	fun_change_loc_date();
		fprintf(f1,"\t\t%-31s %-8s : %s\n",loc_legend[80],loc_legend[60],date_convert.arr);

	if(report_date_to.arr[0]=='\0')
		fprintf(f1,"%50s       : %-7.7s\n\n",loc_legend[70],loc_legend[380]);
    else
	init_date_temp_var();                              //pradeep

	strcpy(date_convert.arr,report_date_to.arr);            // pradeep

	fun_change_loc_date();
		fprintf(f1,"%50s       : %s\n\n",loc_legend[70],date_convert.arr);

	if(cash_counter_fm.arr[0]=='\0')
		fprintf(f1,"\t\t%-31s %-8s : %-6.6s\n",loc_legend[90],loc_legend[60],loc_legend[390]);
    else
		fprintf(f1,"\t\t%-31s %-8s : %s\n",loc_legend[90],loc_legend[60],cash_counter_fm.arr);

	if(cash_counter_to.arr[0]=='\0')
		fprintf(f1,"%50s       : %-7.7s\n\n",loc_legend[70],loc_legend[380]);
	else
		fprintf(f1,"%50s       : %s\n\n",loc_legend[70],cash_counter_to.arr);

	if(shift_id_fm.arr[0]=='\0')
		fprintf(f1,"\t\t%-31s %-8s : %-6.6s\n",loc_legend[100],loc_legend[60],loc_legend[390]);
	else
		fprintf(f1,"\t\t%-31s %-8s : %s\n",loc_legend[100],loc_legend[60],shift_id_fm.arr);

	if(shift_id_to.arr[0]=='\0')
		fprintf(f1,"%50s       : %-7.7s\n\n",loc_legend[70],loc_legend[380]);
	else
		fprintf(f1,"%50s       : %s\n\n",loc_legend[70],shift_id_to.arr);

    if ((cash_ctrl_doc_type_fm.arr[0] && cash_ctrl_doc_num_fm.arr[0])=='\0')
		fprintf(f1,"\t\t%-31s %-8s : %-7.7s\n",loc_legend[110],loc_legend[60],loc_legend[390]); //%s/%scash_ctrl_doc_type_fm.arr,cash_ctrl_doc_num_fm.arr
    else
		fprintf(f1,"\t\t%-31s %-8s : %s %s\n",loc_legend[110],loc_legend[60],cash_ctrl_doc_type_fm.arr,cash_ctrl_doc_num_fm.arr);

    if ((cash_ctrl_doc_type_to.arr[0] && cash_ctrl_doc_num_to.arr[0])=='\0')		
		fprintf(f1,"%50s       : %-7.7s\n\n",loc_legend[70],loc_legend[380]);   //%s/%s ,cash_ctrl_doc_type_to.arr,cash_ctrl_doc_num_to.arr
    else
		fprintf(f1,"%50s       : %s %s\n\n",loc_legend[70],cash_ctrl_doc_type_to.arr,cash_ctrl_doc_num_to.arr);


	if(d_user_id.arr[0] == '\0')
 		fprintf(f1,"\t\t%-40s : %s\n\n",loc_legend[130],loc_legend[392]);
	else
        fprintf(f1,"\t\t%-40s : %s\n\n",loc_legend[130],d_user_id.arr);

   /* Added by Irfan J.S on 16/04/2000 for scf-558 */
        fprintf(f1,"\t\t%-41s: %-8s\n\n",loc_legend[140],loc_legend[320]);
    fprintf(f1,"");
    ++page_no;

} 



print_end_of_rep()
{
    fprintf(f1,"\n\n                                                    ** %-17s **                                                             \n",loc_legend[370]);
}

init_prv_values()
{

    d_prv_cash_counter_code.arr[0]     = '\0';
    d_prv_shift_id.arr[0]              = '\0';
    d_prv_doc_date.arr[0]              = '\0';

    d_prv_cash_counter_code.len     = 0;
    d_prv_shift_id.len              = 0;
    d_prv_doc_date.len              = 0;

}

change()
{
    if(strcmp(d_prv_doc_date.arr,    d_doc_date.arr))
	return 3;

    if(strcmp(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr))
	return 2;

    if(strcmp(d_prv_shift_id.arr, d_shift_id.arr))
	return 1;
    
    return 0;

}

copy_val()
{

    strcpy(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr);
    strcpy(d_prv_doc_date.arr, d_doc_date.arr);
    strcpy(d_prv_shift_id.arr, d_shift_id.arr);

    d_prv_cash_counter_code.len     =   strlen(d_cash_counter_code.arr);
    d_prv_doc_date.len              =   strlen(d_doc_date.arr);
    d_prv_shift_id.len              =   strlen(d_shift_id.arr);

}

print_formated(loc_amount)
double loc_amount;
{
 char s_amt[20];
 //sprintf(s_amt,"%15.2f",loc_amount);
 put_val(s_amt,loc_amount);
 format_amt(s_amt);
 fprintf(f1,"%18s \n",s_amt); 
}                                

print_formated1(loc_amount,doc_amt)
double loc_amount;
char doc_amt[20];
{
 char s_amt[20];
 //sprintf(s_amt,"%15.2f",loc_amount);
 
 put_val(s_amt,loc_amount); 
 format_amt(s_amt); 
 sprintf(doc_amt,"%15s",s_amt);
 //fprintf(f1,"%18s \n",s_amt); 
}                                
   
   
   fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRCASJD.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRCASJD.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )497;
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )520;
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
      
	 //  :nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	
	   :nd_loc_date := sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);  

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )551;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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