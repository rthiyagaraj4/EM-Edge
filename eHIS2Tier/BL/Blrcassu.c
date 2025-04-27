
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
           char  filnam[40];
};
static const struct sqlcxp sqlfpn =
{
    39,
    "D:\\work\\october\\kauh_scf\\6i\\Blrcassu.pc"
};


static unsigned long sqlctx = 253716371;


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
            void  *sqhstv[12];
   unsigned int   sqhstl[12];
            int   sqhsts[12];
            void  *sqindv[12];
            int   sqinds[12];
   unsigned int   sqharm[12];
   unsigned int   *sqharc[12];
   unsigned short  sqadto[12];
   unsigned short  sqtdso[12];
} sqlstm = {10,12};

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
"select CASH_COUNTER_CODE ,SHIFT_ID ,SLMT_TYPE_CODE ,sum(DECODE(RECPT_REFUND_\
IND,'R',decode(nvl(cancelled_ind,'N'),'Y',0,DOC_AMT),0)) ,sum(DECODE(RECPT_REF\
UND_IND,'R',0,decode(nvl(cancelled_ind,'N'),'Y',0,(-DOC_AMT)))) ,sum(DECODE(NV\
L(CANCELLED_IND,'N'),'Y',DOC_AMT,0)) ,count(*)   from BL_RECEIPT_REFUND_HDRDTL\
_VW where ((((TRUNC(DOC_DATE,'MI') between TO_DATE(:b0,'DD/MM/YYYY HH24:MI') a\
nd TO_DATE(:b1,'DD/MM/YYYY HH24:MI') and CASH_COUNTER_FACILITY_ID=:b2) and CAS\
H_COUNTER_CODE between NVL(:b3,'!!') and NVL(:b4,'~~')) and SHIFT_ID between N\
VL(:b5,'!') and NVL(:b6,'~')) and ADDED_BY_ID=nvl(:b7,ADDED_BY_ID)) group by C\
ASH_COUNTER_CODE,SHIFT_ID,SLMT_TYPE_CODE order by 1,2,3            ";

 static const char *sq0010 = 
"select B.BLNG_GRP_ID ,B.LONG_DESC ,sum(NVL(A.BILL_TOT_AMT,0.00))  from BL_BL\
NG_GRP_LANG_VW B ,BL_BILL_HDR A where ((((A.BLNG_GRP_ID=B.BLNG_GRP_ID and lang\
uage_id=:b0) and TRUNC(DOC_DATE) between TO_DATE(:b1,'DD/MM/YYYY') and TO_DATE\
(:b2,'DD/MM/YYYY')) and A.BILL_NATURE_CODE='A') and A.OPERATING_FACILITY_ID=:b\
3) group by B.BLNG_GRP_ID,B.LONG_DESC order by B.BLNG_GRP_ID,B.LONG_DESC      \
      ";

 static const char *sq0008 = 
"select SHORT_DESC ,NVL(CASH_SLMT_FLAG,'X')  from BL_SLMT_TYPE_LANG_VW where \
(SLMT_TYPE_CODE=:b0 and language_id=:b1)           ";

 static const char *sq0009 = 
"select SHORT_DESC  from BL_CASH_COUNTER_LANG_VW where ((CASH_COUNTER_CODE=:b\
0 and OPERATING_FACILITY_ID=:b1) and language_id=:b2)           ";

 static const char *sq0007 = 
"select A.SLMT_TYPE_CODE ,B.SHORT_DESC ,sum(DOC_AMT) ,sum(DOC_AMT)  from BL_R\
ECEIPT_REFUND_HDRDTL_VW A ,BL_SLMT_TYPE_LANG_VW B where (((((((TRUNC(A.DOC_DAT\
E,'MI') between TO_DATE(:b0,'DD/MM/YYYY HH24:MI') and TO_DATE(:b1,'DD/MM/YYYY \
HH24:MI') and language_id=:b2) and CASH_COUNTER_CODE between NVL(:b3,'!!') and\
 NVL(:b4,'~~')) and SHIFT_ID between NVL(:b5,'!') and NVL(:b6,'~')) and A.CASH\
_COUNTER_FACILITY_ID=:b7) and NVL(CANCELLED_IND,'X')<>'Y') and A.SLMT_TYPE_COD\
E=B.SLMT_TYPE_CODE) and A.ADDED_BY_ID=NVL(:b8,A.ADDED_BY_ID)) group by A.SLMT_\
TYPE_CODE,B.SHORT_DESC           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4146,0,0,0,
5,0,0,1,0,0,27,150,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,242,0,4,184,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
99,0,0,3,158,0,4,233,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
134,0,0,4,0,0,30,263,0,0,0,0,0,1,0,
149,0,0,5,91,0,2,270,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
172,0,0,6,689,0,9,366,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
219,0,0,10,394,0,9,371,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
250,0,0,6,0,0,13,399,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,
0,0,2,3,0,0,
293,0,0,7,0,0,13,441,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
324,0,0,8,127,0,9,470,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
347,0,0,8,0,0,13,481,0,0,2,0,0,1,0,2,9,0,0,2,1,0,0,
370,0,0,9,140,0,9,495,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
397,0,0,9,0,0,13,504,0,0,1,0,0,1,0,2,9,0,0,
416,0,0,7,577,0,9,848,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
467,0,0,7,0,0,15,870,0,0,0,0,0,1,0,
482,0,0,10,0,0,13,1020,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,
509,0,0,11,96,0,4,1143,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
532,0,0,12,165,0,6,1150,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
563,0,0,13,143,0,6,1173,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*                        BLRCASSU.PC                                     */
/* Program to Print Daily Receipt Summary by Settlement Type                 */ 
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
 #define ESC 0x1B    
#include <stdio.h>
#include <string.h>       
#include <bl.h>


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[91],
		    d_session_id[16],
		    d_pgm_date[14],
            rep_date[20],
            comp_name[50],
			date_convert[21],
			nd_loc_date[21],
			nd_temp_date[21],
			p_language_id[3],
		    oper_id[21],
			nd_facility_id[3]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


    /* VARCHAR report_date         [17], 
	        rep_to_date			[17],
			r_report_date       [13], 
	        r_rep_to_date		[13],
		    cash_counter_fm     [5],
		    cash_counter_to     [5],
		    shift_id_fm         [2],
		    shift_id_to         [2],
			l_pk_value		        [100],
		    l_translated_value	    [201],
			nd_operating_facility_id [3],
			nd_cashier_user_id   [31]; */ 
struct { unsigned short len; unsigned char arr[17]; } report_date;

struct { unsigned short len; unsigned char arr[17]; } rep_to_date;

struct { unsigned short len; unsigned char arr[13]; } r_report_date;

struct { unsigned short len; unsigned char arr[13]; } r_rep_to_date;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_fm;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_to;

struct { unsigned short len; unsigned char arr[2]; } shift_id_fm;

struct { unsigned short len; unsigned char arr[2]; } shift_id_to;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_cashier_user_id;


   /* VARCHAR d_doc_date                                  [13],
           d_cash_counter_code                         [5],
           d_counter_desc                              [41],
           d_shift_id                                  [2],
     //    d_doc_amt                                   [23],
           d_slmt_type_code                            [3],
           d_slmt_type_desc                            [41],
           d_status                                    [2]; */ 
struct { unsigned short len; unsigned char arr[13]; } d_doc_date;

struct { unsigned short len; unsigned char arr[5]; } d_cash_counter_code;

struct { unsigned short len; unsigned char arr[41]; } d_counter_desc;

struct { unsigned short len; unsigned char arr[2]; } d_shift_id;

struct { unsigned short len; unsigned char arr[3]; } d_slmt_type_code;

struct { unsigned short len; unsigned char arr[41]; } d_slmt_type_desc;

struct { unsigned short len; unsigned char arr[2]; } d_status;


  /* VARCHAR  d_prv_cash_counter_code                      [5],
           d_prv_doc_date                               [13],
           d_prv_slmt_type_code                         [3],
           d_prv_shift_id                               [11]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_prv_cash_counter_code;

struct { unsigned short len; unsigned char arr[13]; } d_prv_doc_date;

struct { unsigned short len; unsigned char arr[3]; } d_prv_slmt_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_prv_shift_id;



  /**** Added by Aldrin   ******/
  /* VARCHAR  r_blng_grp_id                                [5],
           r_long_desc                                 [41]; */ 
struct { unsigned short len; unsigned char arr[5]; } r_blng_grp_id;

struct { unsigned short len; unsigned char arr[41]; } r_long_desc;


    char   d_cash_slmt_flag;

    long   d_no_trx;

    double d_rec_amt,
		   d_ref_amt,
		   d_doc_amt,
           d_void_amt,
		   tot_doc_amt,
    	   d_doc_amt_num,
           r_amt; 

	char loc_legend[999][201];
	char x_msg[200];
	char l_mesg[200],temp[100];

    int i,new_page=0;		


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
    g_hdr_cnt,
    g_err_typ,
    g_page_break;

char filename[150],

	 string_var [100],
     g_acct_code[41],
     g_err_id[8],
     g_err_msg[72];

long   g_sub_no_trx,
       g_ctr_no_trx,
       g_tot_no_trx;

double g_sub_rec_amt,
       g_sub_ref_amt,
       g_sub_void_amt,
       g_ctr_rec_amt,
       g_ctr_ref_amt,
       g_ctr_void_amt,
       g_tot_rec_amt,
       g_tot_ref_amt,
       g_tot_void_amt,
	   g_net_amt;

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc != 5) {
        disp_message(ERR_MESG,"BLRCASSU : Usage BLRCASSU userid/password session_id pgm_date facility_id \n");
        proc_exit();
    }
  
  
    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(g_pgm_id,"BLRCASSU");
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
		disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		proc_exit();
    }

   set_meduser_role();

	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;
//disp_message(ERR_MESG,p_language_id.arr);
   start_prog_msg();
   
   /*** Added by Aldrin for AMH     ****/
   
   r_report_date.arr[0]            = '\0'; 
   r_rep_to_date.arr[0]            = '\0';
   report_date.arr[0]              = '\0'; 
   rep_to_date.arr[0]              = '\0';
   cash_counter_fm.arr[0]          = '\0';
   cash_counter_to.arr[0]          = '\0';
   shift_id_fm.arr[0]              = '\0';
   shift_id_to.arr[0]              = '\0';
   nd_cashier_user_id.arr[0]       = '\0';

   report_date.len                 = 0;
   rep_to_date.len                 = 0;
   cash_counter_fm.len             = 0;
   cash_counter_to.len             = 0;
   shift_id_fm.len                 = 0;
   shift_id_to.len                 = 0;
   nd_cashier_user_id.arr[0]       = 0;

	/* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,            /o REP_DATE_FM                o/
			        PARAM2,            /o CASH_COUNTER_FM            o/
					PARAM3,            /o CASH_COUNTER_TO            o/
					PARAM4,            /o SHIFT_NO_FM                o/
					PARAM5,            /o SHIFT_NO_TO                o/ 
					PARAM6,            /o REP_DATE_TO                o/
					PARAM7,
					PARAM8,
					PARAM9
			 INTO   :nd_operating_facility_id,
					:report_date,
	                :cash_counter_fm,
	                :cash_counter_to,
	                :shift_id_fm,
	                :shift_id_to,
	                :rep_to_date,
	                :r_report_date,
	                :r_rep_to_date ,
					:nd_cashier_user_id
			 FROM   SY_PROG_PARAM
			 WHERE  PGM_ID     = 'BLRCASSU'
			 AND    PGM_DATE   = :d_pgm_date
			 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,\
:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='BLRCASSU' and PGM_DATE=:b10) and S\
ESSION_ID=TO_NUMBER(:b11))";
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
 sqlstm.sqhstv[1] = (         void  *)&report_date;
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
 sqlstm.sqhstv[6] = (         void  *)&rep_to_date;
 sqlstm.sqhstl[6] = (unsigned int  )19;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&r_report_date;
 sqlstm.sqhstl[7] = (unsigned int  )15;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&r_rep_to_date;
 sqlstm.sqhstl[8] = (unsigned int  )15;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_cashier_user_id;
 sqlstm.sqhstl[9] = (unsigned int  )33;
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
 sqlstm.sqhstv[11] = (         void  *)&d_session_id;
 sqlstm.sqhstl[11] = (unsigned int  )18;
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

  
			 

    if(ERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

   report_date.arr[report_date.len]            = '\0'; 
   rep_to_date.arr[rep_to_date.len]            = '\0';
   cash_counter_fm.arr[cash_counter_fm.len]    = '\0';
   cash_counter_to.arr[cash_counter_to.len]    = '\0';
   shift_id_fm.arr[shift_id_fm.len]            = '\0';
   shift_id_to.arr[shift_id_to.len]            = '\0';
   r_report_date.arr[r_report_date.len]        = '\0'; 
   r_rep_to_date.arr[r_rep_to_date.len]        = '\0';
   nd_cashier_user_id.arr[nd_cashier_user_id.len] = '\0';
    
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrcassu.lis");
    strcpy(g_facility_id, nd_operating_facility_id.arr);

    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file...\n");
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
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )99;
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
     put_inp_parm();
     do_report();
 
    fclose(f1);

    del_parm();
     end_prog_msg();

    /* EXEC SQL COMMIT RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )134;
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
         WHERE  PGM_ID     = 'BLRCASSU' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRCASSU' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )149;
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
                      SLMT_TYPE_CODE,
                      SUM(DECODE(RECPT_REFUND_IND,
                         'R',decode(nvl(cancelled_ind,'N'),'Y',0,DOC_AMT),
                         0)) ,
                      SUM(DECODE(RECPT_REFUND_IND,
                         'R',0,
                         decode(nvl(cancelled_ind,'N'),'Y',0,-DOC_AMT))) ,
                      SUM(DECODE(NVL(CANCELLED_IND,'N'),'Y',DOC_AMT,0)) ,
                      COUNT(*)
                 FROM BL_RECEIPT_REFUND_HDRDTL_VW

                /oWHERE ADDED_DATE  BETWEEN TO_DATE(:report_date,'DD/MM/YYYY HH24:MI') AND o/
		  WHERE TRUNC(DOC_DATE,'MI')  BETWEEN TO_DATE(:report_date,'DD/MM/YYYY HH24:MI') AND 
                						  TO_DATE(:rep_to_date,'DD/MM/YYYY HH24:MI')
                  AND CASH_COUNTER_FACILITY_ID = :nd_operating_facility_id
                  AND CASH_COUNTER_CODE BETWEEN
                          NVL(:cash_counter_fm,'!!') AND 
                          NVL(:cash_counter_to,'~~')
                  AND SHIFT_ID BETWEEN
                          NVL(:shift_id_fm,'!') AND 
                          NVL(:shift_id_to,'~') 
				  AND ADDED_BY_ID = nvl(:nd_cashier_user_id,ADDED_BY_ID)
                GROUP BY CASH_COUNTER_CODE,SHIFT_ID,SLMT_TYPE_CODE
				ORDER BY 1,2,3; */ 


     /* EXEC SQL DECLARE BL_SLMT_TOTALS CURSOR FOR
               SELECT A.SLMT_TYPE_CODE,
		              B.SHORT_DESC,
				      /o TO_CHAR(SUM(DOC_AMT),'999,999,990.99'),o/
					  SUM(DOC_AMT),
				      SUM(DOC_AMT)
                 FROM BL_RECEIPT_REFUND_HDRDTL_VW A, BL_SLMT_TYPE_LANG_VW B
		  /o WHERE A.ADDED_DATE  BETWEEN TO_DATE(:report_date,'DD/MM/YYYY HH24:MI') AND o/
		     WHERE TRUNC(A.DOC_DATE,'MI')  BETWEEN TO_DATE(:report_date,'DD/MM/YYYY HH24:MI') AND 
                					TO_DATE(:rep_to_date,'DD/MM/YYYY HH24:MI')
		  AND		language_id=:p_language_id
		  AND CASH_COUNTER_CODE BETWEEN
			  NVL(:cash_counter_fm,'!!') AND 
			  NVL(:cash_counter_to,'~~')
		  AND SHIFT_ID BETWEEN
			  NVL(:shift_id_fm,'!') AND 
			  NVL(:shift_id_to,'~')
		  AND A.CASH_COUNTER_FACILITY_ID = :nd_operating_facility_id
		  AND NVL(CANCELLED_IND,'X') != 'Y'
		  AND A.SLMT_TYPE_CODE = B.SLMT_TYPE_CODE
		  AND A.ADDED_BY_ID = NVL(:nd_cashier_user_id,A.ADDED_BY_ID)
		GROUP BY A.SLMT_TYPE_CODE,B.SHORT_DESC; */ 


    /* EXEC SQL DECLARE SLMT_TYPE_CUR CURSOR FOR
	     SELECT  SHORT_DESC,
	     NVL(CASH_SLMT_FLAG,'X')
	     FROM    BL_SLMT_TYPE_LANG_VW
	     WHERE   SLMT_TYPE_CODE = :d_prv_slmt_type_code
		 AND		language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE CASH_COUNTER_CUR CURSOR FOR
	     SELECT  SHORT_DESC 
	     FROM    BL_CASH_COUNTER_LANG_VW
	     WHERE   CASH_COUNTER_CODE = :d_prv_cash_counter_code
		 AND     OPERATING_FACILITY_ID  = :nd_operating_facility_id
		 AND	 language_id=:p_language_id ; */ 


    /*** Added by Aldrin for AMH      ****/

    /* EXEC SQL DECLARE BL_SUMMARY_TYPE CURSOR FOR
               SELECT B.BLNG_GRP_ID,
		              B.LONG_DESC,
				      SUM(NVL(A.BILL_TOT_AMT,0.00))
               FROM BL_BLNG_GRP_LANG_VW B, BL_BILL_HDR A
		  	   WHERE A.BLNG_GRP_ID = B.BLNG_GRP_ID
			   AND		language_id=:p_language_id
		  	   AND TRUNC(DOC_DATE) BETWEEN TO_DATE(:r_report_date,'DD/MM/YYYY') AND
                					TO_DATE(:r_rep_to_date,'DD/MM/YYYY') AND
                   A.BILL_NATURE_CODE = 'A' 
			   AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		       GROUP BY B.BLNG_GRP_ID,B.LONG_DESC
		       ORDER BY B.BLNG_GRP_ID,B.LONG_DESC; */ 



    /* EXEC SQL OPEN BL_REC_REF_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )172;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&report_date;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )19;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
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
    sqlstm.sqhstv[7] = (         void  *)&nd_cashier_user_id;
    sqlstm.sqhstl[7] = (unsigned int  )33;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor BL_REC_REF_CUR",0,"");

    /* EXEC SQL OPEN BL_SUMMARY_TYPE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )219;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&p_language_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&r_report_date;
    sqlstm.sqhstl[1] = (unsigned int  )15;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&r_rep_to_date;
    sqlstm.sqhstl[2] = (unsigned int  )15;
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



    if(ERROR)
	err_mesg("OPEN failed on cursor BL_SUMMARY_TYPE",0,"");
    
}

fetch_bl_rec()
{

    d_cash_counter_code.arr[0]                                        = '\0';
    d_shift_id.arr[0]                                                 = '\0';
    d_doc_date.arr[0]                                                 = '\0';
    d_slmt_type_code.arr[0]                                           = '\0';

    d_cash_counter_code.len                                           = 0;
    d_shift_id.len                                                    = 0;
    d_doc_date.len                                                    = 0;
    d_slmt_type_code.len                                              = 0;

    d_rec_amt  = 0;
    d_ref_amt  = 0;
    d_void_amt = 0;

    d_no_trx   = 0;



     /* EXEC SQL FETCH BL_REC_REF_CUR
               INTO :d_cash_counter_code,
                    :d_shift_id,
                    :d_slmt_type_code,
                    :d_rec_amt,
                    :d_ref_amt,
                    :d_void_amt,
                    :d_no_trx; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )250;
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
     sqlstm.sqhstv[2] = (         void  *)&d_slmt_type_code;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_rec_amt;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_ref_amt;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_void_amt;
     sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_no_trx;
     sqlstm.sqhstl[6] = (unsigned int  )sizeof(long);
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



 

    if(ERROR)
	err_mesg("FETCH failed on cursor BL_REC_REF_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_cash_counter_code.arr[d_cash_counter_code.len]                     = '\0';
    d_shift_id.arr[d_shift_id.len]                                       = '\0';
    d_doc_date.arr[d_doc_date.len]                                       = '\0';
    d_slmt_type_code.arr[d_slmt_type_code.len]                           = '\0';

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
    
	d_doc_amt			     = 0;

    d_doc_amt_num = 0;


     /* EXEC SQL FETCH BL_SLMT_TOTALS
               INTO :d_slmt_type_code,
				    :d_slmt_type_desc,
	                :d_doc_amt,
                    :d_doc_amt_num; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )293;
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
     sqlstm.sqhstv[2] = (         void  *)&d_doc_amt;
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

   

   
    tot_doc_amt = tot_doc_amt + d_doc_amt;


    return 1;
	
}

fetch_slmt_desc()
{

    /* EXEC SQL OPEN SLMT_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )324;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prv_slmt_type_code;
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

    d_cash_slmt_flag = '\0';


    /* EXEC SQL FETCH SLMT_TYPE_CUR
	     INTO  :d_slmt_type_desc,
			   :d_cash_slmt_flag; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )347;
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
    sqlstm.sqhstv[1] = (         void  *)&d_cash_slmt_flag;
    sqlstm.sqhstl[1] = (unsigned int  )1;
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
	err_mesg("FETCH failed on cursor SLMT_TYPE_CUR",0,"");

    d_slmt_type_desc.arr[d_slmt_type_desc.len]  = '\0';

}

fetch_counter_desc()
{

    /* EXEC SQL OPEN CASH_COUNTER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )370;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prv_cash_counter_code;
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



    if(ERROR)
        err_mesg("OPEN failed on cursor CASH_COUNTER_CUR",0,"");

    d_counter_desc.arr[0]  = '\0';
    d_counter_desc.len  = 0;


    /* EXEC SQL FETCH CASH_COUNTER_CUR 
	     INTO  :d_counter_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )397;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_counter_desc;
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
        err_mesg("FETCH failed on cursor CASH_COUNTER_CUR",0,"");
   
    d_counter_desc.arr[d_counter_desc.len]  = '\0';

}

do_report()
{

    int cnt,first,brk;
    char s_amt[20];

    g_sub_no_trx   = 0;
    g_ctr_no_trx   = 0;
    g_tot_no_trx   = 0;
    g_sub_rec_amt  = 0;
    g_sub_ref_amt  = 0;
    g_sub_void_amt = 0;
    g_ctr_rec_amt  = 0;
    g_ctr_ref_amt  = 0;
    g_ctr_void_amt = 0;
    g_tot_rec_amt  = 0;
    g_tot_ref_amt  = 0;
    g_tot_void_amt = 0;
	g_net_amt =0;

    line_no = 1;

    g_hdr_cnt = 0;
    init_prv_values();
     while(fetch_bl_rec()) {

        if(!g_hdr_cnt)
           {
		    fprintf(f1,"");  //16157
			++page_no;//16157
           put_hdr();
           }
        if(change()) {
 
	       if(g_hdr_cnt) {
 
	         print_sub_totals();
                if(strcmp(d_prv_cash_counter_code.arr,
		           d_cash_counter_code.arr)) {
		           print_ctr_totals();
		           line_no += 60;
    	         }
	         }
             copy_val();
             fetch_counter_desc();
             chk_break(2);
             fprintf(f1,"\n%14s : %-2s %-15s %10s : %1s\n\n",loc_legend[140],
                        d_prv_cash_counter_code.arr,d_counter_desc.arr,loc_legend[320],
                        d_prv_shift_id.arr);
             line_no += 3;
          }
        else 
            copy_val();
         g_hdr_cnt = 1;
        put_rec();
         g_sub_rec_amt  += d_rec_amt;
 
 

        g_sub_ref_amt  += d_ref_amt;
        g_sub_void_amt += d_void_amt;
        g_sub_no_trx   += d_no_trx;
    }

    if(g_hdr_cnt) {
       print_sub_totals();
       print_ctr_totals();
       print_grand_totals();
    }
     if(g_hdr_cnt)
	 print_slmt_totals();
    fprintf(f1,"");  
    print_summ_totals();                                      
     print_end_of_rep();

}

print_sub_totals()
{
    char s_rec_amt[30], s_ref_amt[30], s_net_amt[30], s_void_amt[30];

    /*put_val(s_rec_amt,g_sub_rec_amt);
    format_amt(s_rec_amt);

    put_val(s_ref_amt,g_sub_ref_amt);
    format_amt(s_ref_amt); 

    put_val(s_void_amt,g_sub_void_amt);
    format_amt(s_void_amt);

    put_val(s_net_amt,g_sub_rec_amt - g_sub_ref_amt);
    format_amt(s_net_amt);*/



    chk_break(4);
    fprintf(f1,"                      -------------------------------------------------------\n");
    /*fprintf(f1,"%12s         %4ld  %15s %15s %15s\n",loc_legend[290],
	       g_sub_no_trx, s_rec_amt, s_ref_amt, s_net_amt); */
	 fprintf(f1,"%12s%13s%4ld ",loc_legend[290]," ",
	       g_sub_no_trx);
	print_formated(g_sub_rec_amt);fprintf(f1," ");
	print_formated(g_sub_ref_amt);fprintf(f1," ");
	print_formated(g_sub_rec_amt - g_sub_ref_amt);
	fprintf(f1,"\n");

    //fprintf(f1,"%19s%11s%15s\n",loc_legend[250]," ", s_void_amt);
	fprintf(f1,"%19s%11s",loc_legend[250]," ");
	print_formated(g_sub_void_amt);
	fprintf(f1,"\n");
    fprintf(f1,"                      -------------------------------------------------------\n");

    g_tot_rec_amt  += g_sub_rec_amt;
    g_tot_ref_amt  += g_sub_ref_amt;
    g_tot_void_amt += g_sub_void_amt;
    g_tot_no_trx   += g_sub_no_trx;

    g_ctr_rec_amt  += g_sub_rec_amt;
    g_ctr_ref_amt  += g_sub_ref_amt;
    g_ctr_void_amt += g_sub_void_amt;
    g_ctr_no_trx   += g_sub_no_trx;

    g_sub_rec_amt  = 0;
    g_sub_ref_amt  = 0;
    g_sub_void_amt = 0;
    g_sub_no_trx   = 0;

    line_no += 5;
}

print_ctr_totals()
{
    char s_rec_amt[30], s_ref_amt[30], s_net_amt[25], s_void_amt[30];

/*    put_val(s_rec_amt,g_ctr_rec_amt);
    format_amt(s_rec_amt);

    put_val(s_ref_amt,g_ctr_ref_amt);
    format_amt(s_ref_amt);


    put_val(s_void_amt,g_ctr_void_amt);
    format_amt(s_void_amt);

    put_val(s_net_amt,g_ctr_rec_amt - g_ctr_ref_amt);
    format_amt(s_net_amt);*/



    chk_break(4);
    fprintf(f1,"                      =======================================================\n");
    /*fprintf(f1,"%18.18s %10d %15s %15s %15s\n",loc_legend[280],
	       g_ctr_no_trx, s_rec_amt, s_ref_amt, s_net_amt);*/
    fprintf(f1,"%18.18s %10d ",loc_legend[280],
	       g_ctr_no_trx);
	print_formated(g_ctr_rec_amt);fprintf(f1," ");
	print_formated(g_ctr_ref_amt);fprintf(f1," ");
	print_formated(g_ctr_rec_amt - g_ctr_ref_amt);
	fprintf(f1,"\n");


    //fprintf(f1,"%19.19s       %19s\n",loc_legend[250], s_void_amt);
	fprintf(f1,"%19.19s%11s",loc_legend[250]," ");
	print_formated(g_ctr_void_amt);
	fprintf(f1,"\n");
    fprintf(f1,"                      =======================================================\n");

    g_ctr_rec_amt  = 0;
    g_ctr_ref_amt  = 0;
    g_ctr_void_amt = 0;
    g_ctr_no_trx   = 0;

    line_no += 5;
}

print_grand_totals()
{
    char s_rec_amt[20], s_ref_amt[20], s_net_amt[20], s_void_amt[20];

    /*put_val(s_rec_amt,g_tot_rec_amt);
    format_amt(s_rec_amt);

    put_val(s_ref_amt,g_tot_ref_amt);
    format_amt(s_ref_amt);

    put_val(s_void_amt,g_tot_void_amt);
    format_amt(s_void_amt);

    put_val(s_net_amt,g_tot_rec_amt - g_tot_ref_amt);
    format_amt(s_net_amt);*/

    chk_break(4);
    fprintf(f1,"                      -------------------------------------------------------\n");
    /*fprintf(f1,"%15.15s%10s%4ld  %15s %15s %15s\n",loc_legend[260]," ",
	       g_tot_no_trx, s_rec_amt, s_ref_amt, s_net_amt);*/
	fprintf(f1,"%15.15s%10s%4ld ",loc_legend[260]," ",
	       g_tot_no_trx);

	print_formated(g_tot_rec_amt);fprintf(f1," ");
	print_formated(g_tot_ref_amt);fprintf(f1," ");
	print_formated(g_tot_rec_amt - g_tot_ref_amt);
	fprintf(f1,"\n");

    //fprintf(f1,"%19.19s%8s%19s\n",loc_legend[250]," ", s_void_amt);
	fprintf(f1,"%19.19s%11s",loc_legend[250]," ");
	print_formated(g_tot_void_amt);
    fprintf(f1,"\n");
    fprintf(f1,"                      -------------------------------------------------------\n");

    line_no += 4;
}

put_hdr()
{
    char cash_ctr_fm[110],cash_ctr_to[110];
	char shift_fm[110],shift_to[110];

	if (cash_counter_fm.arr[0] != '\0')
	   strcpy(cash_ctr_fm,cash_counter_fm.arr);
    else
		//strcpy(cash_ctr_fm,"LOWEST");
		 strcpy(cash_ctr_fm,loc_legend[300]);	
	if (cash_counter_to.arr[0] != '\0')
	   strcpy(cash_ctr_to,cash_counter_to.arr);
    else
		//strcpy(cash_ctr_to,"HIGHEST");
		strcpy(cash_ctr_to,loc_legend[310]);

	if (shift_id_fm.arr[0] != '\0')
	   strcpy(shift_fm,shift_id_fm.arr);
    else
		//strcpy(shift_fm,"LOWEST");
		strcpy(shift_fm,loc_legend[300]);
	if (shift_id_to.arr[0] != '\0')
	   strcpy(shift_to,shift_id_to.arr);
    else
		//strcpy(shift_to,"HIGHEST");
		strcpy(shift_to,loc_legend[310]);
	  init_date_temp_var();
	strcpy(date_convert.arr,rep_date.arr);
	fun_change_loc_date();
    fprintf(f1,"%5.5s : %-6.6s                 %-40.40s       %-10s\n",loc_legend[340],loc_legend[150],comp_name.arr,date_convert.arr);

    fprintf(f1,"%5.5s : %-8s\n",loc_legend[350],oper_id.arr);

    fprintf(f1,"%5.5s : %8.8s       %45.45s      %7s : %-3d\n",loc_legend[360],loc_legend[40],loc_legend[330],loc_legend[30],page_no);
 	 
/*	 init_date_temp_var();
	strcpy(date_convert.arr,report_date.arr);
	fun_change_loc_date();
    fprintf(f1,"                      %30.30s %s - ",loc_legend[240],date_convert.arr);      
	 init_date_temp_var();
	strcpy(date_convert.arr,rep_to_date.arr);
	fun_change_loc_date();	

	fprintf(f1,"%s \n",date_convert.arr);      
    fprintf(f1,"                       %20.20s %7.7s %s ",loc_legend[140],loc_legend[60],cash_ctr_fm);
    fprintf(f1,"%5s %s\n",loc_legend[70],cash_ctr_to);
    fprintf(f1,"                         %18.18s %7.7s %s ",loc_legend[320],loc_legend[60],shift_fm);
    fprintf(f1,"%5s %s\n",loc_legend[70],shift_to);
    if (nd_cashier_user_id.arr[0]=='\0')
	    strcpy(nd_cashier_user_id.arr, "FOR ALL CASHIERS");

	fprintf(f1,"                         %30.30s:  %s \n",loc_legend[100],nd_cashier_user_id.arr);
	saikiran for 17675 on 31/12/2009 */

    fprintf(f1,"-----------------------------------------------------------------------------\n");
//    fprintf(f1,"%15.15s%10.10s %15.15s%15.15s%20.20s\n",loc_legend[180],loc_legend[190],loc_legend[200],loc_legend[210],loc_legend[220]);
      fprintf(f1,"%-18.18s %10.10s %15.15s %15.15s %15.15s\n",loc_legend[180],loc_legend[190],loc_legend[200],loc_legend[210],loc_legend[220]);

/*
               "XX XXXXXXXXXXXXXXX 999999  999,999,990.99 999,999,990.99 999,999,990.99"
*/
    fprintf(f1,"-----------------------------------------------------------------------------\n");

    line_no=9;
   
    nd_cashier_user_id.arr[nd_cashier_user_id.len] = '\0';
}

put_rec() 
{
    char s_rec_amt[20], s_ref_amt[20], s_net_amt[20];

    chk_break(1);
    fetch_slmt_desc();

    /*put_val(s_rec_amt,d_rec_amt);
    format_amt(s_rec_amt);

    put_val(s_ref_amt,d_ref_amt);
    format_amt(s_ref_amt);

    put_val(s_net_amt,d_rec_amt - d_ref_amt);
    format_amt(s_net_amt);*/




/*    fprintf(f1,"%-2s %-15.15s %10ld %15.15s %15s %15s\n",
            d_prv_slmt_type_code.arr, d_slmt_type_desc.arr,d_no_trx,
            s_rec_amt,s_ref_amt,s_net_amt); sai*/

 fprintf(f1,"%-2s %-15.15s %10ld ",
            d_prv_slmt_type_code.arr, d_slmt_type_desc.arr,d_no_trx);

	print_formated(d_rec_amt);fprintf(f1," ");
	print_formated(d_ref_amt);fprintf(f1," ");
	print_formated(d_rec_amt - d_ref_amt);
	fprintf(f1,"\n");

        line_no ++;
}

print_slmt_totals()
{
    char s_amt[20];
	tot_doc_amt = 0;

    chk_break(4);
	/*--------- Page Skip Added on 13/3/1999 ----------*/
	 if(new_page!=1)
	 {
		 fprintf(f1,"");
			   line_no = 1;
			   ++page_no;
		   put_hdr();
	 }
	/*-------------------------------------------------*/

    fprintf(f1,"\n\n%50.50s\n",loc_legend[170]); //p1
    fprintf(f1,"----------------------------------------------\n\n");
    line_no += 5;

    /* EXEC SQL OPEN BL_SLMT_TOTALS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )416;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&report_date;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_to_date;
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
    sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[7] = (unsigned int  )5;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_cashier_user_id;
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


    if(ERROR)
	err_mesg("OPEN failed on cursor BL_SLMT_TOTALS",0,"");
     
    while(fetch_slmt_totals()) {
       chk_break(1);
	   
       fprintf(f1,"%-2s %-16.16s    ", 
		  d_slmt_type_code.arr, d_slmt_type_desc.arr);
       print_formated(d_doc_amt);
		  fprintf(f1,"\n");
		
       line_no ++;
    }

	 fprintf(f1,"%-18s"," ");
	   fprintf(f1,"--------------------\n");
	   fprintf(f1,"%9s              ",loc_legend[160]);
	   print_formated(tot_doc_amt);
	   fprintf(f1,"\n");
	   fprintf(f1,"%-18s"," ");
	   fprintf(f1,"--------------------\n");
    /* EXEC SQL CLOSE BL_SLMT_TOTALS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )467;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(ERROR)
	err_mesg("CLOSE failed on cursor BL_SLMT_TOTALS",0,"");
}

chk_break(nol)
int nol;
{
	g_page_break = 0;
	 
	if(line_no+nol + 2 >= 55) {
	   g_page_break = 1;
           fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   new_page=1;	   
	   put_hdr();
	}

}

put_inp_parm()
{
	init_date_temp_var();

	strcpy(date_convert.arr,rep_date.arr);

	fun_change_loc_date();

    fprintf(f1,"%c&l1O",ESC);   /* To Print Landscape           */
	fprintf(f1,"%c&a7L",ESC); 	/* To Set the Left margin  		*/
    fprintf(f1,"%c(s14H",ESC); 	/* To set the font size			*/

    fprintf(f1,"%5.5s : %-6.6s                  %-38.38s      %-10s\n",loc_legend[340],loc_legend[150],comp_name.arr,date_convert.arr);

    fprintf(f1,"%5.5s : %-8s\n",loc_legend[350],oper_id.arr);
    fprintf(f1,"%5.5s : %-8.8s       %45.45s   %8s : %-3d\n",loc_legend[360],loc_legend[40],loc_legend[330],loc_legend[30],page_no);

    //fprintf(f1,"            RECEIPT FOR THE DATE : %16s  -  %16s \n\n",report_date.arr,rep_to_date.arr);
		init_date_temp_var();

	strcpy(date_convert.arr,report_date.arr);
 	fun_change_loc_date();
	fprintf(f1," \t                %27.27s :%10s -",loc_legend[120],date_convert.arr);
		init_date_temp_var();

	strcpy(date_convert.arr,rep_to_date.arr);

	fun_change_loc_date();
	fprintf(f1," %10s \n\n",date_convert.arr);
    fprintf(f1,"-----------------------------------------------------------------------------------------\n\n");
    fprintf(f1,"VER : 4.1\n");
    fprintf(f1,"\n\n\n");
    fprintf(f1,"\t     %-20s\n",loc_legend[370]);
    fprintf(f1,"\t      --------------------\n\n");
		init_date_temp_var();

	strcpy(date_convert.arr,report_date.arr);
 	fun_change_loc_date();
    fprintf(f1,"\t\t%20.20s           %10.10s : %s\n",loc_legend[10],loc_legend[60],date_convert.arr);
		init_date_temp_var();

	strcpy(date_convert.arr,rep_to_date.arr);
 	fun_change_loc_date();
    fprintf(f1,"\t\t           %30.30s : %s\n\n",loc_legend[70],date_convert.arr);
	if(cash_counter_fm.arr[0] == '\0')
    fprintf(f1,"\t\t %20.20s          %10s : %s\n",loc_legend[140],loc_legend[60],loc_legend[300]);
	else
	fprintf(f1,"\t\t %20.20s          %10s : %s\n",loc_legend[140],loc_legend[60],cash_counter_fm.arr);
	if(cash_counter_to.arr[0] == '\0')
    fprintf(f1,"\t\t           %30.30s : %s\n\n",loc_legend[70],loc_legend[310]);
	else
	fprintf(f1,"\t\t           %30.30s : %s\n\n",loc_legend[70],cash_counter_to.arr);
	if(shift_id_fm.arr[0] == '\0')
    fprintf(f1,"\t\t%17.17s              %10s : %s\n",loc_legend[320],loc_legend[60],loc_legend[300]);
	else
	fprintf(f1,"\t\t%17.17s              %10s : %s\n",loc_legend[320],loc_legend[60],shift_id_fm.arr);
	if(shift_id_to.arr[0] == '\0')
    fprintf(f1,"\t\t           %30.30s : %s\n\n",loc_legend[70],loc_legend[310]);
	else
	fprintf(f1,"\t\t           %30.30s : %s\n\n",loc_legend[70],shift_id_to.arr);

    if (nd_cashier_user_id.arr[0]=='\0')
	   {
	   	    strcpy(nd_cashier_user_id.arr, "FOR ALL CASHIERS");
	    fprintf(f1,"\t\t    %20.20s                  : %s\n\n",loc_legend[100],nd_cashier_user_id.arr);
           }
      else
	  {
    fprintf(f1,"\t\t    %20.20s                  : %s\n\n",loc_legend[100],nd_cashier_user_id.arr);
	}
    //fprintf(f1,"");16157
 
    //++page_no;16157
}


print_end_of_rep()
{
    fprintf(f1,"\n\n                                 ** %15s **\n",loc_legend[380]);
}

init_prv_values()
{

    d_prv_cash_counter_code.arr[0]     = '\0';
    d_prv_shift_id.arr[0]              = '\0';

    d_prv_cash_counter_code.len     = 0;
    d_prv_shift_id.len              = 0;

}

change()
{

    if(strcmp(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr)||
       strcmp(d_prv_shift_id.arr, d_shift_id.arr))
	  	     return 1;
		
    return 0;

}

copy_val()
{

    strcpy(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr);
    strcpy(d_prv_shift_id.arr, d_shift_id.arr);
    strcpy(d_prv_slmt_type_code.arr, d_slmt_type_code.arr);

    d_prv_cash_counter_code.len     =   strlen(d_cash_counter_code.arr);
    d_prv_shift_id.len              =   strlen(d_shift_id.arr);
    d_prv_slmt_type_code.len        =   strlen(d_slmt_type_code.arr);

}

/**** Added by Aldrin for AMH *******/

fetch_summary_totals()
{

    r_blng_grp_id.arr[0] = '\0';
    r_long_desc.arr[0]   = '\0';
    r_amt                = 0;

    r_blng_grp_id.len    = 0;
    r_long_desc.len      = 0;
    r_amt                = 0;

     /* EXEC SQL FETCH BL_SUMMARY_TYPE
              INTO :r_blng_grp_id,
			       :r_long_desc,
	               :r_amt; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )482;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&r_blng_grp_id;
     sqlstm.sqhstl[0] = (unsigned int  )7;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&r_long_desc;
     sqlstm.sqhstl[1] = (unsigned int  )43;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&r_amt;
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


                            
                            
    if(ERROR)
	err_mesg("FETCH failed on cursor BL_REC_REF_CUR",0,"");

    if(NO_DATA_FOUND)
   	  return 0;

    r_blng_grp_id.arr[r_blng_grp_id.len]   = '\0';
    r_long_desc.arr[r_long_desc.len]       = '\0';

    return 1;

}
                                

                                        
print_col_heading()          

{
		init_date_temp_var();

	strcpy(date_convert.arr,rep_date.arr);

	fun_change_loc_date();
   
    fprintf(f1,"%5.5s : %-6.6s                   %-38.38s           %-10s\n",loc_legend[340],loc_legend[150],comp_name.arr,date_convert.arr);

  	fprintf(f1,"%5.5s : %-8s\n",loc_legend[350],oper_id.arr);
    fprintf(f1,"%5.5s : %8.8s       %50.50s      %7s : %-3d\n",loc_legend[360],loc_legend[40],loc_legend[50],loc_legend[30],page_no); 
    /*
	fprintf(f1,"                RECEIPT FOR THE DATE : %11s -  %11s \n",r_report_date.arr,r_rep_to_date.arr);
    fprintf(f1,"                        CASH COUNTER FROM %-2s ",cash_counter_fm.arr);
    fprintf(f1,"TO %-2s\n",cash_counter_to.arr);
    fprintf(f1,"                          SHIFT ID FROM %-2s",shift_id_fm.arr);
    fprintf(f1,"TO %-2s\n",shift_id_to.arr);
	*/
	
	//fprintf(f1,"                                 %-25s %s \n",loc_legend[100],nd_cashier_user_id.arr); saikiran for 17675 on 30/12/2009
    //fprintf(f1,"\n\n\n-----------------------------------------------------------------------------\n\n");saikiran for 17675 on 30/12/2009
	fprintf(f1,"-----------------------------------------------------------------------------\n\n");

    fprintf(f1,"%33s                    %18s\n\n",loc_legend[80],loc_legend[90]);

}


print_summ_totals()
{
  double gr_total =0;
  line_no = 11;  
 // put_summ_param();
  ++page_no;
  print_col_heading();
  while(fetch_summary_totals()) {
       
       gr_total = gr_total + r_amt;       
       if (line_no > 55) {
		  fprintf(f1,"");
    	  ++page_no;

    	  print_col_heading();
	      line_no=11;
    	 }  
       	  
       fprintf(f1,"%-4s %-48.48s   ",r_blng_grp_id.arr,
                                 r_long_desc.arr);
       print_formated(r_amt);
	   fprintf(f1,"\n");
       line_no ++;
    }
    
    fprintf(f1,"                                                       ----------------\n");
    fprintf(f1,"                                  %19s   ",loc_legend[270]);
    print_formated(gr_total);
	fprintf(f1,"\n");
    fprintf(f1,"                                                       ----------------\n");
 
}                                    

/*
print_formated(loc_amount)
double loc_amount;
{
 char s_amt[20];
 sprintf(s_amt,"%15.2f",loc_amount);
 format_amt(s_amt);
 fprintf(f1,"%18s \n",s_amt); 
}            */                    

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount); 
        format_amt(s_amt); 
        sprintf(str_amt,"%15s",s_amt);
        fprintf(f1,"%15sCR",str_amt);
        }
    else 
	{ 
 
        put_val(s_amt,loc_amount); 
        format_amt(s_amt); 
        sprintf(str_amt,"%15s",s_amt);
        fprintf(f1,"%15s",str_amt);
        }
}

 
fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRCASSU.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRCASSU.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )509;
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
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )532;
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
	  
  //     	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
//	   :nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	
	   :nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id);  

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_id ) ; \
END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )563;
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
                                     