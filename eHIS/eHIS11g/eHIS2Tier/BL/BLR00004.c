
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00004.PC"
};


static unsigned int sqlctx = 1288460859;


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
            void  *sqhstv[22];
   unsigned int   sqhstl[22];
            int   sqhsts[22];
            void  *sqindv[22];
            int   sqinds[22];
   unsigned int   sqharm[22];
   unsigned int   *sqharc[22];
   unsigned short  sqadto[22];
   unsigned short  sqtdso[22];
} sqlstm = {12,22};

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

 static const char *sq0006 = 
" ,C.SLMT_TYPE_CODE ,C.CASH_SLMT_FLAG ,C.SLMT_DOC_REF_DESC ,C.SLMT_DOC_REF_DA\
TE ,((-1)* C.DOC_AMT) doc_amt ,C.PATIENT_ID ,C.EPISODE_TYPE ,C.EPISODE_ID ,C.V\
ISIT_ID ,C.BILL_DOC_TYPE_CODE ,C.BILL_DOC_NUMBER ,to_char(B.DOC_DATE,'dd/mm/yy\
yy') BILL_DATE ,BILL_TOT_AMT BILL_AMT ,(MAN_DISC_AMT+OVERALL_DISC_AMT) NET_AMT\
 ,C.ext_acct_code ,A.CASH_COUNTER_FACILITY_ID ,A.CASH_COUNTER_CODE ,c.RECPT_RE\
FUND_IND  from BL_CANCELLED_BOUNCED_TRX A ,BL_BILL_HDR B ,bl_receipt_refund_dt\
l_vw c where (((((((c.operating_facility_id=:b0 and a.cancelled_date between T\
O_DATE(:b3,'DD/MM/YYYYHH24:MI:SS') and TO_DATE(NVL(:b4,TO_CHAR(SYSDATE,'DD/MM/\
YYYYHH24:MI:SS')),'DD/MM/YYYYHH24:MI:SS')) and a.cash_counter_code=nvl(:b1,a.c\
ash_counter_code)) and a.added_by_id=nvl(:b2,a.added_by_id)) and B.DOC_TYPE_CO\
DE(+)=C.BILL_DOC_TYPE_CODE) and B.DOC_NUM(+)=C.BILL_DOC_NUMBER) and C.DOC_TYPE\
_CODE=A.DOC_TYPE_CODE) and C.DOC_NUMBER=A.DOC_NUMBER) order by 22 desc ,5,1   \
         ";

 static const char *sq0008 = 
"D_IND=:b4) and C.DOC_TYPE_CODE=A.DOC_TYPE_CODE) and C.DOC_NUMBER=A.DOC_NUMBE\
R) group by C.SLMT_TYPE_CODE,d.short_desc order by 2            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,133,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,47,0,4,171,0,0,1,0,0,1,0,2,9,0,0,
55,0,0,3,0,0,30,197,0,0,0,0,0,1,0,
70,0,0,4,258,0,4,204,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
101,0,0,5,170,0,4,214,0,0,4,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
132,0,0,6,1967,0,9,300,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
187,0,0,6,0,0,13,348,0,0,22,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,
2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
290,0,0,7,194,0,4,433,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
321,0,0,8,1164,0,9,580,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
392,0,0,8,0,0,13,595,0,0,3,0,0,1,0,2,4,0,0,2,9,0,0,2,9,0,0,
419,0,0,8,0,0,15,612,0,0,0,0,0,1,0,
434,0,0,9,158,0,4,766,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
469,0,0,10,96,0,4,819,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
492,0,0,11,162,0,6,826,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
523,0,0,12,228,0,6,882,0,0,3,3,0,1,0,3,9,0,0,1,9,0,0,1,9,0,0,
550,0,0,13,93,0,6,910,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/  
/* PROGRAM NAME          : BLR00004.PC                                  */
/* AUTHOR                : D. Ganesh Murthi                             */    
/* DATE WRITTEN          : 23/11/2003                                   */        
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
#include <bl.h>        

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define REP_WIDTH 158
#define ESC     0x1B
/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hosp_name                       [120],
            date_time                       [20],
            user_id                         [91],
			nd_pwd 			    [91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility			    [3],
			
			nd_cash_counter			[5],
			nd_login_datetime		[30],
			nd_logout_datetime		[30],
			nd_user_id				[31],
			p_start_time            [100],
			bl_slmt_desc			[41],
			bl_slmt_desc1			[41],
			bl_trx_date			    [30],
			bl_doc_type_code	    [7],
			bl_bill_doc_type_code	[7],
			bl_doc_date				[25],
			bl_slmt_type_code		[3],
			bl_slmt_type_code1      [3],
			bl_cash_slmt_flag		[2],
			bl_slmt_doc_ref_desc	[31],
 			bl_slmt_doc_ref_date	[25],
			bl_patient_id		    [21],
			bl_episode_type			[3],
			l_previous_rec_ref_ind	[4],
			l_recpt_refund_ind		[4],		
			l_print_logout_date		[30],
			l_print_login_date		[30],
			p_language_id			[2],
			nd_temp_date			[30],
			nd_loc_date				[30],
			date_convert            [30],
		
			bl_bill_date			[25],
			bl_ext_acct_code	    [11],
			bl_payer_name		    [41],
			bl_cash_counter_facility_id   [3],
			bl_cash_counter_code		    [5],
			l_translated_value	[201],
			l_pk_value			[100]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[5]; } nd_cash_counter;

struct { unsigned short len; unsigned char arr[30]; } nd_login_datetime;

struct { unsigned short len; unsigned char arr[30]; } nd_logout_datetime;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[100]; } p_start_time;

struct { unsigned short len; unsigned char arr[41]; } bl_slmt_desc;

struct { unsigned short len; unsigned char arr[41]; } bl_slmt_desc1;

struct { unsigned short len; unsigned char arr[30]; } bl_trx_date;

struct { unsigned short len; unsigned char arr[7]; } bl_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } bl_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[25]; } bl_doc_date;

struct { unsigned short len; unsigned char arr[3]; } bl_slmt_type_code;

struct { unsigned short len; unsigned char arr[3]; } bl_slmt_type_code1;

struct { unsigned short len; unsigned char arr[2]; } bl_cash_slmt_flag;

struct { unsigned short len; unsigned char arr[31]; } bl_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[25]; } bl_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[3]; } bl_episode_type;

struct { unsigned short len; unsigned char arr[4]; } l_previous_rec_ref_ind;

struct { unsigned short len; unsigned char arr[4]; } l_recpt_refund_ind;

struct { unsigned short len; unsigned char arr[30]; } l_print_logout_date;

struct { unsigned short len; unsigned char arr[30]; } l_print_login_date;

struct { unsigned short len; unsigned char arr[2]; } p_language_id;

struct { unsigned short len; unsigned char arr[30]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[30]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[30]; } date_convert;

struct { unsigned short len; unsigned char arr[25]; } bl_bill_date;

struct { unsigned short len; unsigned char arr[11]; } bl_ext_acct_code;

struct { unsigned short len; unsigned char arr[41]; } bl_payer_name;

struct { unsigned short len; unsigned char arr[3]; } bl_cash_counter_facility_id;

struct { unsigned short len; unsigned char arr[5]; } bl_cash_counter_code;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;


int         bl_doc_number;
int			l_printed=0;
int			bl_episode_id;
int			bl_bill_doc_number;
int			bl_visit_id;
int         i,j;

double      bl_doc_amt,
			bl_total_docamt,
			bl_slmt_doc_amt,
			bl_slmt_tot_amt,
			bl_bill_amt,
			bl_net_amt;

char		filename[150];
char loc_legend[999][201];
char		l_mesg[2000];
char		x_msg[200];

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
  
    strcpy(g_pgm_id,"BLR00004");
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


    set_meduser_role(); 
	  	strcpy(p_language_id.arr,l_language_id.arr);
		p_language_id.len = l_language_id.len;
    if (sqlca.sqlcode < 0 )
	{
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
        }

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

		strcpy(nd_cash_counter.arr,argv[5]);
		nd_cash_counter.len = strlen(nd_cash_counter.arr);

		strcpy(nd_login_datetime.arr,argv[6]);
		nd_login_datetime.len = strlen(nd_login_datetime.arr);

		strcpy(nd_user_id.arr,argv[7]);
		nd_user_id.len = strlen(nd_user_id.arr);
    	
    //	start_prog_msg();

   p_start_time.arr[0]		='\0'; 
    p_start_time.len        =0;
 	/* EXEC SQL select GET_TRACE_TIMESTAMP
			 into :p_start_time
			 from dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select GET_TRACE_TIMESTAMP into :b0  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&p_start_time;
  sqlstm.sqhstl[0] = (unsigned int  )102;
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


		fetch_sy_prog_param();



    	declare_cur();

		fetch_legend_value();

    	fetch_hosp_name();

    	open_file();
	// ADDED BY RAVIKIRAN S FOR 16916
		fprintf (fp,"%c&l1O",ESC);
		fprintf (fp, "%c(s14H", ESC);	
		open_hdr();
        
		print_rec();

		end_of_rep();  
 proc_trace();
    //end_prog_msg();


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )55;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}

fetch_sy_prog_param()
{
	/* EXEC SQL select NVL(TO_CHAR(logout_date_time,'DD/MM/YYYYHH24:MI:SS'),TO_CHAR(SYSDATE,'DD/MM/YYYYHH24:MI:SS'))
			into   :nd_logout_datetime
			from   bl_cash_counter_slmt_hdr 
			where  CASH_COUNTER_CODE = :nd_cash_counter
			AND	   TO_CHAR(login_date_time,'DD/MM/YYYYHH24:MI:SS') = :nd_login_datetime
			AND    OPERATING_FACILITY_ID = :nd_facility; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TO_CHAR(logout_date_time,'DD/MM/YYYYHH24:MI:SS'),\
TO_CHAR(SYSDATE,'DD/MM/YYYYHH24:MI:SS')) into :b0  from bl_cash_counter_slmt_h\
dr where ((CASH_COUNTER_CODE=:b1 and TO_CHAR(login_date_time,'DD/MM/YYYYHH24:M\
I:SS')=:b2) and OPERATING_FACILITY_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )70;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_logout_datetime;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_cash_counter;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_login_datetime;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_facility;
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



	l_print_logout_date.arr[0] = '\0';
	l_print_login_date.arr[0]   = '\0';

	/* EXEC SQL SELECT TO_CHAR(TO_DATE(:nd_logout_datetime,'DD/MM/YYYYHH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS'),
					TO_CHAR(TO_DATE(:nd_login_datetime,'DD/MM/YYYYHH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS')	
			   INTO :l_print_logout_date,
					:l_print_login_date
			   FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'DD/MM/YYYYHH24:MI:SS'),'DD/MM/YY\
YY HH24:MI:SS') ,TO_CHAR(TO_DATE(:b1,'DD/MM/YYYYHH24:MI:SS'),'DD/MM/YYYY HH24:\
MI:SS') into :b2,:b3  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )101;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_logout_datetime;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_login_datetime;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_print_logout_date;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_print_login_date;
 sqlstm.sqhstl[3] = (unsigned int  )32;
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

	

	l_print_logout_date.arr[l_print_logout_date.len] = '\0';
	l_print_login_date.arr[l_print_login_date.len]   = '\0';

}


declare_cur()
{
     /* EXEC SQL DECLARE DAILY_COLLN CURSOR FOR 
	SELECT
 	to_char(A.DOC_DATE,'dd/mm/yyyy hh24:mi') Trx_date,
 	A.Doc_date  Doc_date,
 	A.DOC_TYPE_CODE           ,
 	A.DOC_NUMBER               ,
 	A.SLMT_TYPE_CODE            ,
 	A.CASH_SLMT_FLAG             ,
 	A.SLMT_DOC_REF_DESC            ,
 	A.SLMT_DOC_REF_DATE            ,
 	A.DOC_AMT                      ,
 	A.PATIENT_ID                   ,
	A.EPISODE_TYPE                 ,
	A.EPISODE_ID					,
	A.VISIT_ID						,
 	A.BILL_DOC_TYPE_CODE           ,
 	A.BILL_DOC_NUMBER              ,
 	to_char(B.DOC_DATE,'dd/mm/yyyy')   BILL_DATE,
 	B.BILL_TOT_AMT         BILL_AMT,
 	B.MAN_DISC_AMT+B.OVERALL_DISC_AMT  NET_AMT,
 	A.ext_acct_code,
 	A.CASH_COUNTER_FACILITY_ID    ,
 	A.CASH_COUNTER_CODE,
	A.RECPT_REFUND_IND
 	FROM 	BL_RECEIPT_REFUND_DTL_VW A, BL_BILL_HDR B
 	where  a.operating_facility_id = :nd_facility 
	and    a.cash_counter_code = nvl(:nd_cash_counter,a.cash_counter_code)
	and    a.added_by_id = nvl(:nd_user_id,a.added_by_id)
	and    A.DOC_DATE between TO_DATE(:nd_login_datetime,'DD/MM/YYYYHH24:MI:SS') 
	and 		TO_DATE(NVL(:nd_logout_datetime,TO_CHAR(SYSDATE,'DD/MM/YYYYHH24:MI:SS')),'DD/MM/YYYYHH24:MI:SS')
  	AND B.DOC_TYPE_CODE(+)= a.BILL_DOC_TYPE_CODE  AND
       		B.DOC_NUM (+)= A.BILL_DOC_NUMBER
 	Union
	SELECT
 	to_char(A.Cancelled_date,'dd/mm/yyyy hh24:mi')     TRX_DATE,
 	C.DOC_DATE           DOC_DATE    ,
 	A.DOC_TYPE_CODE          ,
 	A.DOC_NUMBER              ,  
 	C.SLMT_TYPE_CODE           ,
 	C.CASH_SLMT_FLAG                  ,
 	C.SLMT_DOC_REF_DESC               ,
 	C.SLMT_DOC_REF_DATE               ,
 	(-1*C.DOC_AMT) doc_amt            ,
 	C.PATIENT_ID                      ,
	C.EPISODE_TYPE					  ,
	C.EPISODE_ID					  ,
	C.VISIT_ID						  ,
 	C.BILL_DOC_TYPE_CODE              ,
 	C.BILL_DOC_NUMBER                 ,
 	to_char(B.DOC_DATE,'dd/mm/yyyy')  BILL_DATE     ,
 	BILL_TOT_AMT  BILL_AMT     ,
 	MAN_DISC_AMT+OVERALL_DISC_AMT  NET_AMT,
 	C.ext_acct_code     ,
 	A.CASH_COUNTER_FACILITY_ID        ,
 	A.CASH_COUNTER_CODE,
	c.RECPT_REFUND_IND
 	FROM BL_CANCELLED_BOUNCED_TRX A , BL_BILL_HDR B, bl_receipt_refund_dtl_vw c
 	where c.operating_facility_id = :nd_facility
	and  a.cancelled_date between TO_DATE(:nd_login_datetime,'DD/MM/YYYYHH24:MI:SS') 
			and 	TO_DATE(NVL(:nd_logout_datetime,TO_CHAR(SYSDATE,'DD/MM/YYYYHH24:MI:SS')),'DD/MM/YYYYHH24:MI:SS')
	and     a.cash_counter_code = nvl(:nd_cash_counter,a.cash_counter_code)
	and     a.added_by_id = nvl(:nd_user_id,a.added_by_id)
	AND B.DOC_TYPE_CODE(+)= C.BILL_DOC_TYPE_CODE  AND
            B.DOC_NUM (+)= C.BILL_DOC_NUMBER
	AND C.DOC_TYPE_CODE = A.DOC_TYPE_CODE AND
    	    C.DOC_NUMBER   =  A.DOC_NUMBER
	Order by  22 desc,5,1; */ 
    

}

open_hdr()     
{
    /* EXEC SQL OPEN DAILY_COLLN; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select to_char(A.DOC_DATE,'dd/mm/yyyy hh24:mi') Trx_date ,A.Doc_date \
Doc_date ,A.DOC_TYPE_CODE ,A.DOC_NUMBER ,A.SLMT_TYPE_CODE ,A.CASH_SLMT_FLAG \
,A.SLMT_DOC_REF_DESC ,A.SLMT_DOC_REF_DATE ,A.DOC_AMT ,A.PATIENT_ID ,A.EPISOD\
E_TYPE ,A.EPISODE_ID ,A.VISIT_ID ,A.BILL_DOC_TYPE_CODE ,A.BILL_DOC_NUMBER ,t\
o_char(B.DOC_DATE,'dd/mm/yyyy') BILL_DATE ,B.BILL_TOT_AMT BILL_AMT ,(B.MAN_D\
ISC_AMT+B.OVERALL_DISC_AMT) NET_AMT ,A.ext_acct_code ,A.CASH_COUNTER_FACILIT\
Y_ID ,A.CASH_COUNTER_CODE ,A.RECPT_REFUND_IND  from BL_RECEIPT_REFUND_DTL_VW\
 A ,BL_BILL_HDR B where (((((a.operating_facility_id=:b0 and a.cash_counter_\
code=nvl(:b1,a.cash_counter_code)) and a.added_by_id=nvl(:b2,a.added_by_id))\
 and A.DOC_DATE between TO_DATE(:b3,'DD/MM/YYYYHH24:MI:SS') and TO_DATE(NVL(\
:b4,TO_CHAR(SYSDATE,'DD/MM/YYYYHH24:MI:SS')),'DD/MM/YYYYHH24:MI:SS')) and B.\
DOC_TYPE_CODE(+)=a.BILL_DOC_TYPE_CODE) and B.DOC_NUM(+)=A.BILL_DOC_NUMBER) u\
nion select to_char(A.Cancelled_date,'dd/mm/yyyy hh24:mi') TRX_DATE ,C.DOC_D\
ATE DOC_DATE ,A.DOC_TYPE_CODE ,A.DOC_NUMBER");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )132;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_cash_counter;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_user_id;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_login_datetime;
    sqlstm.sqhstl[3] = (unsigned int  )32;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_logout_datetime;
    sqlstm.sqhstl[4] = (unsigned int  )32;
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
    sqlstm.sqhstv[6] = (         void  *)&nd_login_datetime;
    sqlstm.sqhstl[6] = (unsigned int  )32;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_logout_datetime;
    sqlstm.sqhstl[7] = (unsigned int  )32;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_cash_counter;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_user_id;
    sqlstm.sqhstl[9] = (unsigned int  )33;
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
         err_mesg("OPEN failed on cursor DAILY_COLLN",0,"");
}

fetch_hdr()
{  
bl_trx_date.arr[0]   		= '\0';
bl_doc_type_code.arr[0]		= '\0';
bl_doc_date.arr[0] 			= '\0';
bl_bill_date.arr[0]			= '\0';
bl_slmt_doc_ref_date.arr[0] = '\0';
bl_patient_id.arr[0] 		= '\0';
bl_slmt_doc_ref_desc.arr[0] = '\0';
bl_slmt_type_code.arr[0]	= '\0';
bl_cash_slmt_flag.arr[0]	= '\0';
bl_bill_doc_type_code.arr[0]= '\0';
bl_ext_acct_code.arr[0] 	= '\0';
bl_cash_counter_facility_id.arr[0] 	= '\0';
bl_cash_counter_code.arr[0] = '\0';
bl_episode_type.arr[0]		= '\0';

bl_doc_number		= 0;
bl_bill_doc_number	= 0;
bl_doc_amt			= 0;
bl_bill_amt			= 0;
bl_net_amt			= 0;
bl_episode_id		= 0;
bl_visit_id			= 0;


bl_trx_date.len      		= 0;
bl_doc_type_code.len		= 0;
bl_doc_date.len      		= 0;
bl_bill_date.len      		= 0;
bl_slmt_doc_ref_date.len	= 0;
bl_patient_id.len      		= 0;
bl_slmt_doc_ref_desc.len 	= 0;
bl_slmt_type_code.len      	= 0;
bl_cash_slmt_flag.len      	= 0;
bl_bill_doc_type_code.len   = 0;
bl_ext_acct_code.len      	= 0;
bl_cash_counter_facility_id.len = 0;
bl_cash_counter_code.len    = 0;
bl_episode_type.len			= 0;
bl_cash_counter_code.len     = 0;
l_recpt_refund_ind.len     = 0;

      	/* EXEC SQL FETCH DAILY_COLLN
            INTO 	
			 	:bl_trx_date,
 				:bl_doc_date,
 				:bl_doc_type_code,
				:bl_doc_number,
				:bl_slmt_type_code,
 				:bl_cash_slmt_flag,
 				:bl_slmt_doc_ref_desc,
 				:bl_slmt_doc_ref_date,
 				:bl_doc_amt,
 				:bl_patient_id,
				:bl_episode_type,
				:bl_episode_id,
				:bl_visit_id,
 				:bl_bill_doc_type_code,
 				:bl_bill_doc_number,
 				:bl_bill_date,
 				:bl_bill_amt,
 				:bl_net_amt,
 				:bl_ext_acct_code,
 				:bl_cash_counter_facility_id,
 				:bl_cash_counter_code,
				:l_recpt_refund_ind; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 22;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )187;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&bl_trx_date;
       sqlstm.sqhstl[0] = (unsigned int  )32;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&bl_doc_date;
       sqlstm.sqhstl[1] = (unsigned int  )27;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&bl_doc_type_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&bl_doc_number;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&bl_slmt_type_code;
       sqlstm.sqhstl[4] = (unsigned int  )5;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&bl_cash_slmt_flag;
       sqlstm.sqhstl[5] = (unsigned int  )4;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&bl_slmt_doc_ref_desc;
       sqlstm.sqhstl[6] = (unsigned int  )33;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&bl_slmt_doc_ref_date;
       sqlstm.sqhstl[7] = (unsigned int  )27;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&bl_doc_amt;
       sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&bl_patient_id;
       sqlstm.sqhstl[9] = (unsigned int  )23;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&bl_episode_type;
       sqlstm.sqhstl[10] = (unsigned int  )5;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&bl_episode_id;
       sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&bl_visit_id;
       sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&bl_bill_doc_type_code;
       sqlstm.sqhstl[13] = (unsigned int  )9;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&bl_bill_doc_number;
       sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&bl_bill_date;
       sqlstm.sqhstl[15] = (unsigned int  )27;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&bl_bill_amt;
       sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&bl_net_amt;
       sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&bl_ext_acct_code;
       sqlstm.sqhstl[18] = (unsigned int  )13;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&bl_cash_counter_facility_id;
       sqlstm.sqhstl[19] = (unsigned int  )5;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&bl_cash_counter_code;
       sqlstm.sqhstl[20] = (unsigned int  )7;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&l_recpt_refund_ind;
       sqlstm.sqhstl[21] = (unsigned int  )6;
       sqlstm.sqhsts[21] = (         int  )0;
       sqlstm.sqindv[21] = (         void  *)0;
       sqlstm.sqinds[21] = (         int  )0;
       sqlstm.sqharm[21] = (unsigned int  )0;
       sqlstm.sqadto[21] = (unsigned short )0;
       sqlstm.sqtdso[21] = (unsigned short )0;
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
            err_mesg("FETCH failed on cursor DAILY_COLLN",0,"");

bl_trx_date.arr[bl_trx_date.len]			= '\0';
bl_doc_type_code.arr[bl_doc_type_code.len]	= '\0';
bl_doc_date.arr[bl_doc_date.len] 			= '\0';
bl_bill_date.arr[bl_bill_date.len]			= '\0';
bl_slmt_doc_ref_date.arr[bl_slmt_doc_ref_date.len] = '\0';
bl_patient_id.arr[bl_patient_id.len] 		= '\0';
bl_slmt_doc_ref_desc.arr[bl_slmt_doc_ref_desc.len] = '\0';
bl_slmt_type_code.arr[bl_slmt_type_code.len]	= '\0';
bl_cash_slmt_flag.arr[bl_cash_slmt_flag.len]	= '\0';
bl_bill_doc_type_code.arr[bl_bill_doc_type_code.len]= '\0';
bl_ext_acct_code.arr[bl_ext_acct_code.len] 	= '\0';
bl_cash_counter_facility_id.arr[bl_cash_counter_facility_id.len] 	= '\0';
bl_cash_counter_code.arr[bl_cash_counter_code.len] = '\0';
bl_episode_type.arr[bl_episode_type.len]	= '\0';
l_recpt_refund_ind.arr[l_recpt_refund_ind.len] = '\0';

    return(LAST_ROW?0:1);
}

print_rec()
{
	bl_total_docamt =0;
 
    print_day_details();
	//print_column_total();
}  

print_day_details()
{
	char emsg[200];
	print_head();

   
  l_printed=0;	
  	
  while(fetch_hdr())
  {
		bl_slmt_desc.arr[0] 	= '\0';
		bl_slmt_desc.len =0;

		if((strcmp(l_previous_rec_ref_ind.arr,l_recpt_refund_ind.arr)!=0)&&(strlen(l_previous_rec_ref_ind.arr)!=0))
		{
			print_column_total();
		}
		
		if((strcmp(l_previous_rec_ref_ind.arr,l_recpt_refund_ind.arr)!=0)||(strlen(l_previous_rec_ref_ind.arr)==0))
		{
			print_title();
		}

		if (lctr > 65) 
		{
			fprintf(fp,"\f");
			print_head();  
			lctr = 13;
		}

		/* EXEC SQL select short_desc 
	  			   into :bl_slmt_desc
				  // from bl_slmt_type COMMENTED BY SAIKIRAN FOR 19587
				   from bl_slmt_type_lang_vw
				  where slmt_type_code = :bl_slmt_type_code
				  and language_id=:p_language_id
					and acc_entity_code in (select acc_entity_code 
												from sy_acc_entity 
												where acc_entity_id = :nd_facility); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_desc into :b0  from bl_slmt_type_lang_vw where\
 ((slmt_type_code=:b1 and language_id=:b2) and acc_entity_code in (select acc_\
entity_code  from sy_acc_entity where acc_entity_id=:b3))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )290;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_slmt_desc;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_slmt_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&p_language_id;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_facility;
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

 
						bl_slmt_desc.arr[bl_slmt_desc.len]	= '\0';
		init_date_temp_var();
		strcpy(date_convert.arr,bl_trx_date.arr);
		fun_change_loc_date();
		fprintf(fp,"%-16s %-6s/%-8d %-15.15s",date_convert.arr, bl_doc_type_code.arr, bl_doc_number,bl_slmt_desc.arr);
		print_formated(bl_doc_amt);
		bl_total_docamt += bl_doc_amt;  
		 						 //disp_message(ERR_MESG,"1");
				 //disp_message(ERR_MESG,bl_bill_doc_type_code.arr);
			// disp_message(ERR_MESG,bl_bill_doc_number);
		 if(bl_bill_date.arr[0] !='\0')
		 {
         	init_date_temp_var();
			strcpy(date_convert.arr,bl_bill_date.arr);
			fun_change_loc_date();
		// }
		 if (bl_patient_id.arr[0])
	     {


		  if (bl_bill_doc_type_code.arr[0])

		    fprintf(fp," %-20.20s %-1s/%-8d/%-4d %6s/%-8d %10s",bl_patient_id.arr, bl_episode_type.arr, bl_episode_id, bl_visit_id,bl_bill_doc_type_code.arr, bl_bill_doc_number,date_convert.arr);

		  else

		    fprintf(fp," %-20.20s %-1s/%-8d/%-4d %6s %-8s %10s",bl_patient_id.arr, bl_episode_type.arr, bl_episode_id, bl_visit_id,bl_bill_doc_type_code.arr, bl_bill_doc_number,date_convert.arr);
		}
		else
		{
		  if (bl_bill_doc_type_code.arr[0])
		     fprintf(fp," %-20.20s %-1s %-8s %-4s %6s/%-8d %10s","","","","",bl_bill_doc_type_code.arr, bl_bill_doc_number,date_convert.arr);
			 
		  else
		     fprintf(fp," %-20.20s %-1s %-8s %-4s %6s %-8s %10s","","","","","","",date_convert.arr);
			  
		}
 
}
 /* added by saikiran for 19587 */
 else 
 {
   fprintf(fp," %-20.20s %-1s %-8s %-4s %6s %-8s %10s","","","","","","","");
   }
	
  /* modification ends */

		print_formated(bl_bill_amt);
		fprintf(fp,"%-10s \n",bl_ext_acct_code.arr);
		   
 		lctr++;

		strcpy(l_previous_rec_ref_ind.arr, l_recpt_refund_ind.arr);
		l_previous_rec_ref_ind.len = strlen(l_previous_rec_ref_ind.arr);
  }   
  print_column_total();
}


print_column_total()
{
  fprintf(fp,"%47s %s \n"," ","-----------------");
  fprintf(fp,"%34s %s        "," ",loc_legend[17]);
  print_formated(bl_total_docamt);
  bl_total_docamt=0;
    
 

  fprintf(fp,"\n%47s %s \n"," ","-----------------");
  lctr+=3;

	//fprintf(fp,"  Settlement wise breakup \n");
	fprintf(fp,"  %-50s \n",loc_legend[16]);

	fprintf(fp,"  ----------------------- \n");
	lctr+=2;
	
	declare_stlmt_cursor();
	while(fetch_sumup())  
	{   
   		fprintf(fp,"  %-15.15s", bl_slmt_desc1.arr);
		print_formated(bl_slmt_doc_amt);
		bl_slmt_tot_amt += bl_slmt_doc_amt;
		fprintf(fp,"\n");
		lctr++;
	}
	close_stmt_breakup();

    fprintf(fp,"\n  %-15s%s"," ","-----------------");
	fprintf(fp,"\n  %-15s",loc_legend[17]);
	print_formated(bl_slmt_tot_amt);
	bl_slmt_tot_amt=0;
	  
 
	fprintf(fp,"\n  %-15s%s\n"," ","-----------------");
	lctr+=3;
}

declare_stlmt_cursor()
{
    /* EXEC SQL DECLARE SLMT_BREAKUP CURSOR FOR 
		  SELECT sum(nvl(A.DOC_AMT,0)) DOCAMT,
				 a.SLMT_TYPE_CODE   SLMT_CODE,
				 c.short_desc       SLMT_DESC
		  //FROM  BL_RECEIPT_REFUND_DTL_VW A, BL_SLMT_TYPE C COMMENTED BY SAIKIRAN FOR 19587
		  FROM  BL_RECEIPT_REFUND_DTL_VW A, BL_SLMT_TYPE_LANG_VW C 
		  where  a.operating_facility_id = :nd_facility 
		  and   c.slmt_type_code(+) = a.slmt_type_code
		  and    a.cash_counter_code = nvl(:nd_cash_counter,a.cash_counter_code)
		  and    a.added_by_id = nvl(:nd_user_id,a.added_by_id)
		  AND    C.LANGUAGE_ID =:p_language_id //ADDED BY SAIKIRAN FOR 19587
		  AND    A.RECPT_REFUND_IND = :l_previous_rec_ref_ind
		  and    A.DOC_DATE between TO_DATE(:nd_login_datetime,'DD/MM/YYYYHH24:MI:SS') 
		  and 		TO_DATE(:nd_logout_datetime,'DD/MM/YYYYHH24:MI:SS')
		  GROUP BY a.SLMT_TYPE_CODE  , c.short_desc
		  UNION
	   	  SELECT sum(nvl((-1*C.DOC_AMT),0))  DOCAMT,
				 C.SLMT_TYPE_CODE  SLMT_CODE,
				 D.SHORT_DESC      SLMT_DESC 
 		  FROM BL_CANCELLED_BOUNCED_TRX A , bl_receipt_refund_dtl_vw c, 
		       //BL_SLMT_TYPE D COMMENTED BY SAIKIRAN FOR 19587
		       BL_SLMT_TYPE_LANG_VW D 
 		  where c.operating_facility_id = :nd_facility
		  and   D.slmt_type_code(+) = c.slmt_type_code
   	         AND  LANGUAGE_ID =:p_language_id //ADDED BY SAIKIRAN FOR 19587
		  and  a.cancelled_date between TO_DATE(:nd_login_datetime,'DD/MM/YYYYHH24:MI:SS') 
				and 	TO_DATE(:nd_logout_datetime,'DD/MM/YYYYHH24:MI:SS')
		  and     a.cash_counter_code = nvl(:nd_cash_counter,a.cash_counter_code)
		  and     a.added_by_id = nvl(:nd_user_id,a.added_by_id)
		  AND    A.RECPT_REFUND_IND = :l_previous_rec_ref_ind
		  AND C.DOC_TYPE_CODE = A.DOC_TYPE_CODE AND
    		  C.DOC_NUMBER   =  A.DOC_NUMBER
		  Group by C.SLMT_TYPE_CODE , d.short_desc 
		  order by 2 ; */ 


		if (OERROR)
            err_mesg("DECLARE failed on cursor SLMT_BREAKUP",0,"");
	
	/* EXEC SQL OPEN SLMT_BREAKUP; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select sum(nvl(A.DOC_AMT,0)) DOCAMT ,a.SLMT_TYPE_CODE SLMT_CODE ,c.short\
_desc SLMT_DESC  from BL_RECEIPT_REFUND_DTL_VW A ,BL_SLMT_TYPE_LANG_VW C whe\
re ((((((a.operating_facility_id=:b0 and c.slmt_type_code(+)=a.slmt_type_cod\
e) and a.cash_counter_code=nvl(:b1,a.cash_counter_code)) and a.added_by_id=n\
vl(:b2,a.added_by_id)) and C.LANGUAGE_ID=:b3) and A.RECPT_REFUND_IND=:b4) an\
d A.DOC_DATE between TO_DATE(:b5,'DD/MM/YYYYHH24:MI:SS') and TO_DATE(:b6,'DD\
/MM/YYYYHH24:MI:SS')) group by a.SLMT_TYPE_CODE,c.short_desc union select su\
m(nvl(((-1)* C.DOC_AMT),0)) DOCAMT ,C.SLMT_TYPE_CODE SLMT_CODE ,D.SHORT_DESC\
 SLMT_DESC  from BL_CANCELLED_BOUNCED_TRX A ,bl_receipt_refund_dtl_vw c ,BL_\
SLMT_TYPE_LANG_VW D where ((((((((c.operating_facility_id=:b0 and D.slmt_typ\
e_code(+)=c.slmt_type_code) and LANGUAGE_ID=:b3) and a.cancelled_date betwee\
n TO_DATE(:b5,'DD/MM/YYYYHH24:MI:SS') and TO_DATE(:b6,'DD/MM/YYYYHH24:MI:SS'\
)) and a.cash_counter_code=nvl(:b1,a.cash_counter_code)) and a.added_by_id=n\
vl(:b2,a.added_by_id)) and A.RECPT_REFUN");
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )321;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_cash_counter;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_user_id;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_language_id;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_previous_rec_ref_ind;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_login_datetime;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_logout_datetime;
 sqlstm.sqhstl[6] = (unsigned int  )32;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_facility;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&p_language_id;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_login_datetime;
 sqlstm.sqhstl[9] = (unsigned int  )32;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_logout_datetime;
 sqlstm.sqhstl[10] = (unsigned int  )32;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_cash_counter;
 sqlstm.sqhstl[11] = (unsigned int  )7;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_user_id;
 sqlstm.sqhstl[12] = (unsigned int  )33;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&l_previous_rec_ref_ind;
 sqlstm.sqhstl[13] = (unsigned int  )6;
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
		err_mesg("Open failed on cursor SLMT_BREAKUP",0,"");

}

fetch_sumup()
{  
	bl_slmt_desc1.arr[0]		= '\0';
	bl_slmt_type_code1.arr[0]		= '\0';
	bl_slmt_doc_amt			= 0;
	bl_slmt_desc1.len      	= 0;
	bl_slmt_type_code1.len  = 0;

      	/* EXEC SQL FETCH SLMT_BREAKUP
            INTO 	
			 	:bl_slmt_doc_amt,
				:bl_slmt_type_code1,
 				:bl_slmt_desc1; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 22;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )392;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqfoff = (           int )0;
       sqlstm.sqfmod = (unsigned int )2;
       sqlstm.sqhstv[0] = (         void  *)&bl_slmt_doc_amt;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&bl_slmt_type_code1;
       sqlstm.sqhstl[1] = (unsigned int  )5;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&bl_slmt_desc1;
       sqlstm.sqhstl[2] = (unsigned int  )43;
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
            err_mesg("FETCH failed on cursor SLMT_BREAKUP",0,"");

		bl_slmt_desc1.arr[bl_slmt_desc1.len]		= '\0';
		bl_slmt_type_code1.arr[bl_slmt_type_code1.len] = '\0';

    return(LAST_ROW?0:1);
}

close_stmt_breakup()
{
	/* EXEC SQL CLOSE SLMT_BREAKUP; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )419;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		err_mesg("CLOSE failed on cursor SLMT_BREAKUP",0,"");
}

print_title()
{
	if(strcmp(l_recpt_refund_ind.arr,"R")==0)
	{
		if (lctr > 65) 
		{
			fprintf(fp,"\f");
			print_head();  
			lctr = 13;
		}


		fprintf(fp,"%-15s\n",loc_legend[18]);	
		fprintf(fp,"=======\n");
		lctr=lctr+2;
	}
	else if(strcmp(l_recpt_refund_ind.arr,"F")==0)
	{
		if (lctr > 65) 
		{
			fprintf(fp,"\f");
			print_head();  
			lctr = 13;
		}

		fprintf(fp,"%-15s\n",loc_legend[15]);	
		fprintf(fp,"======\n");	
		lctr=lctr+2;
	}
}
 
end_of_rep()
{
	//fprintf(fp,"\n\n %72s   ***  END OF REPORT ***\n\f"," "); COMMENTED BY SAIKIRAN FOR 19587
	fprintf(fp,"\n\n %72s   *** %-10s ***\n\f","",loc_legend[25]);
	fflush(fp);
}


open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00004.lis");
     if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00004.lis");
       proc_exit();
    }
}

print_head()
{
	int hosp_nm_len, rep_title_len = 10, s1, s2,s3,s4,date_len,user_len,pgm_len,char_len,opr_len;
	char v_rep_title[200],v_as_on_date[12];
	lctr=0;

// LINE-1
	
	fprintf(fp,"%s : %s",loc_legend[22],"BL");
	//fprintf(fp,"MDL : BL"); commented by saikiran for 19587
	hosp_nm_len  =  hosp_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", hosp_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-27);
	init_date_temp_var();
	strcpy(date_convert.arr,date_time.arr);
	fun_change_loc_date();
	fprintf(fp,"%9s : %s", loc_legend[20],date_convert.arr);
   
	fprintf(fp,"\n");
// LINE-2
        fprintf(fp,"%s : %-10s \n",loc_legend[23],user_id.arr);
	//fprintf(fp,"OPR : %-10s \n", user_id.arr);commented by saikiran for 19587

// LINE-3

      fprintf(fp,"%s : %s",loc_legend[24],"BLR00004");
   // fprintf(fp,"REP : %s","BLR00004");commented by saikiran for 19587
    pgm_len=8;
	 strcpy(v_rep_title,loc_legend[1]);	
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-pgm_len-6);
	fprintf(fp,"%s",v_rep_title);

   s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-30);
	fprintf(fp,"%12s : %-d\n",loc_legend[21],++pctr);

    //fprintf(fp,"MDL : BL %53s %-30s %47s %-16s\n"," ",hosp_name.arr," ",date_time.arr);
	//fprintf(fp,"OPR : %-10s \n", user_id.arr);
    //fprintf(fp,"REP : %-8s  %43s %s  %46s  PAGE : %4d\n","BLR00004"," ",loc_legend[1]," ",++pctr);  
    //	fprintf(fp,"%40s Log in Date & Time : %s Log out Date & Time : %s    \n"," ",l_print_login_date.arr, l_print_logout_date.arr);
   
 // LINE-4

   char_len =strlen(loc_legend[2])+strlen(loc_legend[3])+38;
     s3 = (REP_WIDTH-char_len)/2;
     horz_skip(s3);
		init_date_temp_var();
		strcpy(date_convert.arr,l_print_login_date.arr);
		fun_change_loc_date();
		fprintf(fp,"%s : %s ",loc_legend[2],date_convert.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,l_print_logout_date.arr);
		fun_change_loc_date();
	    fprintf(fp,"%s : %s    \n",loc_legend[3],date_convert.arr);
	 //fprintf(fp,"%s : %s %s : %s    \n",loc_legend[2],l_print_login_date.arr,loc_legend[3],l_print_logout_date.arr);

   // fprintf(fp,"%33s %25s : %s %25s : %s    \n"," ",loc_legend[2],l_print_login_date.arr,loc_legend[3],l_print_logout_date.arr);

// LINE-5
   opr_len = strlen(loc_legend[4])+strlen(nd_user_id.arr);
      s4 = (REP_WIDTH-opr_len)/2;  
	  horz_skip(s4-2);
	fprintf(fp,"%s : %s \n",loc_legend[4],nd_user_id.arr);       

	//fprintf(fp,"%50s         %15s : %s \n"," ",loc_legend[4],nd_user_id.arr);

	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
	fprintf(fp,"%38s %49s\n",loc_legend[5],loc_legend[19]);
	fprintf(fp,"%-15.15s %-12.12s %-12.12s %21.21s   %-18.18s  %-15.15s  %-15.15s %-18.18s %-25.25s\n",loc_legend[6],loc_legend[7],loc_legend[8],loc_legend[9],loc_legend[10],loc_legend[11],loc_legend[12],loc_legend[13],loc_legend[14]);
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");

	fflush(fp);  
	lctr = 13;
}

fill_dash(flg)
{
  int i;
  for (i=1;i<=flg;i++)
     { 
		fprintf(fp,"%s","-");
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
             INTO  :hosp_name, :date_time, :user_id
             FROM  SY_ACC_ENTITY_LANG_VW
	     WHERE ACC_ENTITY_ID = :nd_facility
			 AND   LANGUAGE_ID   = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:\
b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )434;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_facility;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&p_language_id;
    sqlstm.sqhstl[4] = (unsigned int  )4;
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


       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
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

horz_skip(num) /* this is to obtain required blank space */
int num;
	{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
	}



fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';
     
		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00004.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00004.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )469;
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
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )492;
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


       
		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}


/*--------- OVER -------------*/
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
//nd_loc_date.arr[nd_loc_date.len]='\0'; 
//date_convert.arr[date_convert.len]='\0';
  


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

get_local_date()
{

	 
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	 
  //  get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id,t_date);  
	   :nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id);  
      
//	:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	:nd_loc_date := to_char(to_date(:nd_loc_date,'DD/MM/YYYY'),'DD/MM/YYYY');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_id ) ; \
:nd_loc_date := to_char ( to_date ( :nd_loc_date , 'DD/MM/YYYY' ) , 'DD/MM/YYY\
Y' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )523;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
 sqlstm.sqhstl[2] = (unsigned int  )4;
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


     //nd_loc_date.arr[nd_loc_date.len]='\0';   

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

} 

proc_trace()
{
 /* EXEC SQL EXECUTE
	
 BEGIN
 
  TRACE_DURATION_BL(
  :d_curr_pgm_name,
  'Report' ,
  :p_start_time ,
  :nd_user_id );
  END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin TRACE_DURATION_BL ( :d_curr_pgm_name , 'Report' , :p_s\
tart_time , :nd_user_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )550;
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
 sqlstm.sqhstv[1] = (         void  *)&p_start_time;
 sqlstm.sqhstl[1] = (unsigned int  )102;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_user_id;
 sqlstm.sqhstl[2] = (unsigned int  )33;
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
        err_mesg("TRACE_DURATION_BL failed",0,"");
}