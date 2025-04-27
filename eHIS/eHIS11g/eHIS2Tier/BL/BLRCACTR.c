
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
           char  filnam[20];
};
static const struct sqlcxp sqlfpn =
{
    19,
    "D:\\BUGS\\BLRCACTR.pc"
};


static unsigned long sqlctx = 36267403;


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
            void  *sqhstv[29];
   unsigned int   sqhstl[29];
            int   sqhsts[29];
            void  *sqindv[29];
            int   sqinds[29];
   unsigned int   sqharm[29];
   unsigned int   *sqharc[29];
   unsigned short  sqadto[29];
   unsigned short  sqtdso[29];
} sqlstm = {10,29};

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
"CODE ,C.SLMT_DOC_REF_DESC ,C.SLMT_DOC_REF_DATE ,C.SLMT_DOC_REMARKS ,C.APPROV\
AL_REF_NO ,B.BILL_NATURE_CODE ,D.CASH_SLMT_FLAG ,NVL(B.BILL_STATUS,'A') ,nvl(B\
.PATIENT_ID,C.PATIENT_ID) ,b.cust_code  from BL_CANCELLED_BOUNCED_TRX A ,BL_BI\
LL_HDR B ,bl_receipt_refund_dtl_vw c ,bl_slmt_type D where ((((((((c.operating\
_facility_id=:b0 and a.cancelled_date between TO_DATE(:b3,'DD/MM/YYYY HH24:MI:\
SS') and TO_DATE(NVL(:b4,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY\
 HH24:MI:SS')) and a.cash_counter_code=nvl(:b1,a.cash_counter_code)) and a.add\
ed_by_id=nvl(:b2,a.added_by_id)) and B.DOC_TYPE_CODE(+)=C.BILL_DOC_TYPE_CODE) \
and B.DOC_NUM(+)=C.BILL_DOC_NUMBER) and C.DOC_TYPE_CODE=A.DOC_TYPE_CODE) and C\
.DOC_NUMBER=A.DOC_NUMBER) and C.SLMT_TYPE_CODE=D.SLMT_TYPE_CODE) order by 1,2 \
           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,192,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,242,0,0,0,0,0,1,0,
51,0,0,3,258,0,4,250,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
82,0,0,4,170,0,4,261,0,0,4,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
113,0,0,5,3861,0,9,610,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
188,0,0,5,0,0,13,678,0,0,29,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
319,0,0,6,72,0,4,1441,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
342,0,0,7,144,0,4,1594,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
365,0,0,8,0,0,31,1605,0,0,0,0,0,1,0,
380,0,0,9,147,0,6,1636,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/  
/* PROGRAM NAME          : BLRCACTR.PC                                  */
/* AUTHOR                : Saurabh Bhatnagar                            */    
/* DATE WRITTEN          : 13/07/2007                                   */        
/*                                                                      */       
/* CALLED FROM           :                                              */
/*                                                                      */  
/* FUNCTION              :                                              */ 
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
#define ESC 0x1B
#define max_lines 17//21 

/* EXEC SQL BEGIN DECLARE SECTION; */ 
 

/* VARCHAR
	hosp_name		[120],
	date_time		[20],
	user_id			[91],
	nd_pwd			[91],
	nd_session_id		[16],
	nd_pgm_date		[25],
	d_curr_pgm_name		[15],
	nd_facility		[3],

	nd_cash_counter		[5],   /o Prabhakar Has changed. o/
	nd_login_datetime	[30],
	nd_logout_datetime	[30],
	nd_user_id		[31],
	nd_user_name	[50],

	bl_slmt_desc		[16],
	bl_slmt_desc1		[16],
	bl_trx_date		[30],
	bl_doc_type_code	[7],
	bl_bill_doc_type_code	[7],
	bl_doc_date		[25],
	bl_slmt_type_code	[3],
	bl_slmt_type_code1      [3],
	bl_cash_slmt_flag	[2],
				nd_temp_date[130],
			date_convert[130],
			nd_loc_date[130],
	bl_slmt_doc_ref_desc	[31],
	bl_slmt_doc_ref_date	[25],
	bl_patient_id		[21],
	bl_episode_type		[3],
	l_previous_rec_ref_ind	[4],
	l_recpt_refund_ind	[4],		
	l_print_logout_date	[30],
	l_print_login_date	[30],

	bl_bill_date		[25],
	bl_ext_acct_code	[11],
	bl_payer_name		[41],
	bl_cash_counter_facility_id   [3],
	bl_cash_counter_code          [5],
	l_translated_value	      [201],
	l_pk_value		      [100],
	l_cust_code		      [50]; */ 
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

struct { unsigned short len; unsigned char arr[50]; } nd_user_name;

struct { unsigned short len; unsigned char arr[16]; } bl_slmt_desc;

struct { unsigned short len; unsigned char arr[16]; } bl_slmt_desc1;

struct { unsigned short len; unsigned char arr[30]; } bl_trx_date;

struct { unsigned short len; unsigned char arr[7]; } bl_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } bl_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[25]; } bl_doc_date;

struct { unsigned short len; unsigned char arr[3]; } bl_slmt_type_code;

struct { unsigned short len; unsigned char arr[3]; } bl_slmt_type_code1;

struct { unsigned short len; unsigned char arr[2]; } bl_cash_slmt_flag;

struct { unsigned short len; unsigned char arr[130]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[130]; } date_convert;

struct { unsigned short len; unsigned char arr[130]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[31]; } bl_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[25]; } bl_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[3]; } bl_episode_type;

struct { unsigned short len; unsigned char arr[4]; } l_previous_rec_ref_ind;

struct { unsigned short len; unsigned char arr[4]; } l_recpt_refund_ind;

struct { unsigned short len; unsigned char arr[30]; } l_print_logout_date;

struct { unsigned short len; unsigned char arr[30]; } l_print_login_date;

struct { unsigned short len; unsigned char arr[25]; } bl_bill_date;

struct { unsigned short len; unsigned char arr[11]; } bl_ext_acct_code;

struct { unsigned short len; unsigned char arr[41]; } bl_payer_name;

struct { unsigned short len; unsigned char arr[3]; } bl_cash_counter_facility_id;

struct { unsigned short len; unsigned char arr[5]; } bl_cash_counter_code;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[50]; } l_cust_code;


/* varchar
		l_bill_doc_type[7], 
		l_bill_doc_num   [31],
		l_recpt_doc_num	  [31],
		l_dt_time[31],
		l_slmt_type_code[3], 
		l_slmt_doc_ref_desc[31], 
		l_slmt_doc_ref_date[25], 
		l_slmt_doc_remarks[101], 
		l_approval_ref_no[30],
		l_recept_doc_date[12],
		l_recpt_doc_type_code[7], 
		l_recpt_nature_code[11], 
		l_customer_code[11], 
		l_cash_counter_facility_id[11], 
		l_cash_counter_code[11], 
		l_shift_id[11],p_language_id[3],
		l_bill_nature[2],
		l_cash_slmt_flag[2],
		l_bill_status[1],
		l_patient_id[60]; */ 
struct { unsigned short len; unsigned char arr[7]; } l_bill_doc_type;

struct { unsigned short len; unsigned char arr[31]; } l_bill_doc_num;

struct { unsigned short len; unsigned char arr[31]; } l_recpt_doc_num;

struct { unsigned short len; unsigned char arr[31]; } l_dt_time;

struct { unsigned short len; unsigned char arr[3]; } l_slmt_type_code;

struct { unsigned short len; unsigned char arr[31]; } l_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[25]; } l_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[101]; } l_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[30]; } l_approval_ref_no;

struct { unsigned short len; unsigned char arr[12]; } l_recept_doc_date;

struct { unsigned short len; unsigned char arr[7]; } l_recpt_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } l_recpt_nature_code;

struct { unsigned short len; unsigned char arr[11]; } l_customer_code;

struct { unsigned short len; unsigned char arr[11]; } l_cash_counter_facility_id;

struct { unsigned short len; unsigned char arr[11]; } l_cash_counter_code;

struct { unsigned short len; unsigned char arr[11]; } l_shift_id;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[2]; } l_bill_nature;

struct { unsigned short len; unsigned char arr[2]; } l_cash_slmt_flag;

struct { unsigned short len; unsigned char arr[1]; } l_bill_status;

struct { unsigned short len; unsigned char arr[60]; } l_patient_id;



double	
		l_doc_amt,
		l_gross_amt,
		l_serv_disc_amt,
		l_bill_amt,
	    l_dep_adj,
		l_bill_tot_amt,
		l_bill_tot_outst_amt,
		l_recept_doc_amt,
		tot_l_gross_amt = 0,
		tot_l_serv_disc_amt = 0,
		tot_l_bill_amt = 0, 
		tot_l_dep_adj = 0,
		tot_l_bill_tot_amt = 0,
		l_cash_amt = 0,
		l_cheq_amt = 0,
		l_cc_amt = 0,
		l_other_amt = 0,
		l_tot_cheq_amt =0 ,
		l_tot_cash_amt =0,
		l_tot_other_amt =0,
		l_tot_cc_amt =0;


int		bl_episode_id;
int     print_space=0;//17353 by saikiran on 17-dec-2009
int		i,j,v_lno = 0,l_slno = 0,l_rslno = 1,l_no_of_decimal; 
int		l_bill=0,l_due = 0,l_cr = 0,l_cash = 0,l_cc = 0,l_cheq = 0, l_others = 0,l_credit;

int			hl		 = 196,
			vl		 = 179,
			tlc		 = 218,
			trc		 = 191,
			blc		 = 192,
			brc		 = 217,
			vlti	 = 195,
			vrti	 = 180,
			htti	 = 194,
			hbti	 = 193,
			plus	 = 197;

double	bl_doc_amt,
	bl_total_docamt,
	bl_slmt_doc_amt,
	bl_slmt_tot_amt,
	bl_bill_amt,
	bl_net_amt;


char		filename[150];
char		l_mesg[2000];
char		x_msg[200];
char		string_var[1000];
char l_prev_bill_ref [31];

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

  
    set_meduser_role(); 
	  
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

   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;



	fetch_sy_prog_param();

	declare_cur();

	open_file();

	open_hdr();

	print_title();

	print_rec();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}

fetch_sy_prog_param()
{

	/* EXEC SQL 
		select NVL(TO_CHAR(logout_date_time,'DD/MM/YYYYHH24:MI:SS'),TO_CHAR(SYSDATE,'DD/MM/YYYYHH24:MI:SS'))
		into   :nd_logout_datetime
		from   bl_cash_counter_slmt_hdr 
		where  CASH_COUNTER_CODE = :nd_cash_counter
		AND    TO_CHAR(login_date_time,'DD/MM/YYYYHH24:MI:SS') = :nd_login_datetime
		AND    OPERATING_FACILITY_ID = :nd_facility; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TO_CHAR(logout_date_time,'DD/MM/YYYYHH24:MI:SS'),\
TO_CHAR(SYSDATE,'DD/MM/YYYYHH24:MI:SS')) into :b0  from bl_cash_counter_slmt_h\
dr where ((CASH_COUNTER_CODE=:b1 and TO_CHAR(login_date_time,'DD/MM/YYYYHH24:M\
I:SS')=:b2) and OPERATING_FACILITY_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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

	/* EXEC SQL 
		SELECT TO_CHAR(TO_DATE(:nd_logout_datetime,'DD/MM/YYYYHH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS'),
		TO_CHAR(TO_DATE(:nd_login_datetime,'DD/MM/YYYYHH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS')	
		INTO :l_print_logout_date,
		:l_print_login_date
		FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'DD/MM/YYYYHH24:MI:SS'),'DD/MM/YY\
YY HH24:MI:SS') ,TO_CHAR(TO_DATE(:b1,'DD/MM/YYYYHH24:MI:SS'),'DD/MM/YYYY HH24:\
MI:SS') into :b2,:b3  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )82;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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

   /*  EXEC SQL DECLARE DAILY_SCROLL CURSOR FOR 
	SELECT	B.DOC_TYPE_CODE BILL_DOC_TYPE, 
		B.DOC_NUM  BILL_DOC_NUM,
		TO_CHAR(A.DOC_DATE,'DD/MM/YYYY HH24:MI') DT_TIME,
		GROSS_AMT,
		SERV_DISC_AMT,
		BILL_AMT,
	    NVL(UNADJ_PREP_AMT,0)+ NVL(DEPOSIT_ADJ_AMT,0)+NVL(DEPOSIT_ADJ_AMT_PD,0)+ NVL(SPL_AGENCY_DEP_ADJ_AMT,0)
		+ NVL(BILL_TOT_ADJUST_AMT,0) + NVL(BILL_TOT_EXEMPT_AMT,0) + NVL(BILL_TOT_WRITE_OFF_AMT,0) DEP_ADJ,
		BILL_TOT_AMT,
		BILL_TOT_OUTST_AMT,
		A.DOC_DATE,
		RECPT_REFUND_IND, 
		A.DOC_TYPE_CODE RECPT_DOC_TYPE_CODE, 
		A.DOC_NUMBER RECPT_DOC_NUM, 
		RECPT_NATURE_CODE, 
		CUSTOMER_CODE, 
		A.CASH_COUNTER_FACILITY_ID, 
		A.CASH_COUNTER_CODE,    
		A.SHIFT_ID, 
		A.DOC_AMT, 
		A.SLMT_TYPE_CODE, 
		SLMT_DOC_REF_DESC, 
		SLMT_DOC_REF_DATE, 
		SLMT_DOC_REMARKS, 
		APPROVAL_REF_NO,
		BILL_NATURE_CODE,
		C.CASH_SLMT_FLAG,
		NVL(B.BILL_STATUS,'A')
	FROM BL_RECEIPT_REFUND_DTL A,
		BL_BILL_HDR B , bl_slmt_type C   
	WHERE
		A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID(+) AND 
		A.BILL_DOC_TYPE_CODE=B.DOC_TYPE_CODE(+)	AND 
		C.SLMT_TYPE_CODE = A.SLMT_TYPE_CODE AND
		A.BILL_DOC_NUMBER = B.DOC_NUM(+) AND 
		A.OPERATING_FACILITY_ID = :nd_facility  AND
		A.CASH_COUNTER_CODE = NVL(:nd_cash_counter,A.CASH_COUNTER_CODE) AND    
		A.ADDED_BY_ID = NVL(:nd_user_id,A.ADDED_BY_ID)	AND  
		A.DOC_DATE BETWEEN 
		     TO_DATE (:nd_login_datetime,'DD/MM/YYYY HH24:MI:SS') AND 
		     TO_DATE(NVL(:nd_logout_datetime,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY HH24:MI:SS') AND
	     NVL(CANCELLED_IND,'N') <> 'Y' 
	UNION ALL
	SELECT B.DOC_TYPE_CODE 
		BILL_DOC_TYPE, 
		B.DOC_NUM BILL_DOC_NUM,
		TO_CHAR(DOC_DATE,'DD/MM/YYYY HH24:MI') DT_TIME,
		GROSS_AMT,SERV_DISC_AMT,BILL_AMT,
		 NVL(UNADJ_PREP_AMT,0)+ NVL(DEPOSIT_ADJ_AMT,0)+NVL(DEPOSIT_ADJ_AMT_PD,0)+ NVL(SPL_AGENCY_DEP_ADJ_AMT,0)
		+ NVL(BILL_TOT_ADJUST_AMT,0) + NVL(BILL_TOT_EXEMPT_AMT,0) + NVL(BILL_TOT_WRITE_OFF_AMT,0) DEP_ADJ,
		BILL_TOT_AMT,
		BILL_TOT_OUTST_AMT,
		B.DOC_DATE,
		NULL RECPT_REFUND_IND, 
		NULL RECPT_DOC_TYPE_CODE, 
		NULL RECPT_DOC_NUM, 
		NULL RECPT_NATURE_CODE, 
		CUST_CODE, 
		CASH_COUNTER_FACILITY_ID, 
		CASH_COUNTER_CODE, 
		SHIFT_ID, 
		NULL DOC_AMT, 
		NULL SLMT_TYPE_CODE, 
		NULL SLMT_DOC_REF_DESC, 
		NULL SLMT_DOC_REF_DATE, 
		NULL SLMT_DOC_REMARKS, 
		NULL APPROVAL_REF_NO,
		'Y' BILL_NATURE_CODE,
		'Y' SLMT_TYPE_CODE,
		NVL(B.BILL_STATUS,'A')
	FROM	BL_BILL_HDR B 
	//WHERE	BILL_NATURE_CODE ='A' AND
	WHERE
		B.BILL_AMT = B.BILL_TOT_OUTST_AMT + NVL(B.BILL_TOT_ADJUST_AMT,0) + NVL(B.BILL_TOT_EXEMPT_AMT,0) + NVL(B.BILL_TOT_WRITE_OFF_AMT,0) +
				    NVL(UNADJ_PREP_AMT,0)+ NVL(DEPOSIT_ADJ_AMT,0)+NVL(DEPOSIT_ADJ_AMT_PD,0)+ NVL(SPL_AGENCY_DEP_ADJ_AMT,0)
	   AND
		B.OPERATING_FACILITY_ID = :nd_facility  AND 
		B.CASH_COUNTER_CODE = NVL(:nd_cash_counter,B.CASH_COUNTER_CODE) AND    
		B.ADDED_BY_ID = NVL(:nd_user_id,B.ADDED_BY_ID)	AND  
		B.ADDED_DATE BETWEEN 
		     TO_DATE(:nd_login_datetime,'DD/MM/YYYY HH24:MI:SS') AND 
		     TO_DATE(NVL(:nd_logout_datetime,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY HH24:MI:SS')
	ORDER BY 1,2; */  
/*
    EXEC SQL DECLARE DAILY_SCROLL CURSOR FOR 
	SELECT b.doc_type_code bill_doc_type,
		   b.doc_num bill_doc_num,
		   TO_CHAR(a.doc_date, 'DD/MM/YYYY HH24:MI') dt_time,
		   gross_amt,
		   serv_disc_amt,
		   bill_amt,
		   NVL(unadj_prep_amt, 0) + NVL(deposit_adj_amt, 0) +
		   NVL(deposit_adj_amt_pd, 0) + NVL(spl_agency_dep_adj_amt, 0) +
		   NVL(bill_tot_adjust_amt, 0) + NVL(bill_tot_exempt_amt, 0) +
		   NVL(bill_tot_write_off_amt, 0) dep_adj,
		   bill_tot_amt,
		   bill_tot_outst_amt,
		   a.doc_date,
		   recpt_refund_ind,
		   a.doc_type_code recpt_doc_type_code,
		   a.doc_number recpt_doc_num,
		   recpt_nature_code,
		   customer_code,
		   d.cash_counter_facility_id,
		   d.cash_counter_code,
		   d.shift_id,
		   a.doc_amt,
		   a.slmt_type_code,
		   slmt_doc_ref_desc,
		   slmt_doc_ref_date,
		   slmt_doc_remarks,
		   approval_ref_no,
		   bill_nature_code,
		   c.cash_slmt_flag,
		   NVL(b.bill_status, 'A'),
		   b.patient_id
	  FROM bl_receipt_refund_hdr d,
		   bl_receipt_refund_dtl a,
		   bl_bill_hdr           b,
		   bl_slmt_type          c
	 WHERE d.operating_facility_id = a.operating_facility_id(+)
	   AND a.operating_facility_id = b.operating_facility_id
	   AND d.doc_type_code = a.doc_type_code
	   AND d.doc_number = a.doc_number
	   AND d.bill_doc_type_code = b.doc_type_code(+)
	   AND c.slmt_type_code = a.slmt_type_code
	   AND d.bill_doc_number = b.doc_num(+)
	   AND a.operating_facility_id = :nd_facility
	   AND d.cash_counter_code = NVL(:nd_cash_counter, d.cash_counter_code)
	   AND a.added_by_id = NVL(:nd_user_id, a.added_by_id)
	   AND a.doc_date BETWEEN
		   TO_DATE(:nd_login_datetime, 'DD/MM/YYYY HH24:MI:SS') AND
		   TO_DATE(NVL(:nd_logout_datetime,
					   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI:SS')),
				   'DD/MM/YYYY HH24:MI:SS')
	   AND NVL(a.cancelled_ind, 'N') <> 'Y'

	UNION ALL

	SELECT b.doc_type_code bill_doc_type,
		   b.doc_num bill_doc_num,
		   TO_CHAR(doc_date, 'DD/MM/YYYY HH24:MI') dt_time,
		   gross_amt,
		   serv_disc_amt,
		   bill_amt,
		   NVL(unadj_prep_amt, 0) + NVL(deposit_adj_amt, 0) +
		   NVL(deposit_adj_amt_pd, 0) + NVL(spl_agency_dep_adj_amt, 0) +
		   NVL(bill_tot_adjust_amt, 0) + NVL(bill_tot_exempt_amt, 0) +
		   NVL(bill_tot_write_off_amt, 0) dep_adj,
		   bill_tot_amt,
		   bill_tot_outst_amt,
		   b.doc_date,
		   NULL recpt_refund_ind,
		   NULL recpt_doc_type_code,
		   NULL recpt_doc_num,
		   NULL recpt_nature_code,
		   cust_code,
		   cash_counter_facility_id,
		   cash_counter_code,
		   shift_id,
		   NULL doc_amt,
		   NULL slmt_type_code,
		   NULL slmt_doc_ref_desc,
		   NULL slmt_doc_ref_date,
		   NULL slmt_doc_remarks,
		   NULL approval_ref_no,
		   'Y' bill_nature_code,
		   'Y' slmt_type_code,
		   NVL(b.bill_status, 'A'),
		   b.patient_id
	  FROM bl_bill_hdr b
	 WHERE b.bill_amt =
		   b.bill_tot_outst_amt + NVL(b.bill_tot_adjust_amt, 0) +
		   NVL(b.bill_tot_exempt_amt, 0) + NVL(b.bill_tot_write_off_amt, 0) +
		   NVL(unadj_prep_amt, 0) + NVL(deposit_adj_amt, 0) +
		   NVL(deposit_adj_amt_pd, 0) + NVL(spl_agency_dep_adj_amt, 0)
	   AND b.operating_facility_id = :nd_facility
	   AND b.cash_counter_code = NVL(:nd_cash_counter, b.cash_counter_code)
	   AND b.added_by_id = NVL(:nd_user_id, b.added_by_id)
	   AND b.added_date BETWEEN
		   TO_DATE(:nd_login_datetime, 'DD/MM/YYYY HH24:MI:SS') AND
		   TO_DATE(NVL(:nd_logout_datetime,
					   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI:SS')),
				   'DD/MM/YYYY HH24:MI:SS')
	 ORDER BY 1, 2; */

   /* EXEC SQL DECLARE DAILY_SCROLL CURSOR FOR 
	SELECT	B.DOC_TYPE_CODE BILL_DOC_TYPE, 
		B.DOC_NUM  BILL_DOC_NUM,
		TO_CHAR(A.DOC_DATE,'DD/MM/YYYY HH24:MI') DT_TIME,
		GROSS_AMT,
		SERV_DISC_AMT,
		BILL_AMT,
	    --NVL(UNADJ_PREP_AMT,0)+ NVL(DEPOSIT_ADJ_AMT,0)+NVL(DEPOSIT_ADJ_AMT_PD,0)+ NVL(SPL_AGENCY_DEP_ADJ_AMT,0)
		-- + NVL(BILL_TOT_ADJUST_AMT,0) + NVL(BILL_TOT_EXEMPT_AMT,0) + NVL(BILL_TOT_WRITE_OFF_AMT,0) DEP_ADJ,
    	NVL(DEPOSIT_ADJ_AMT,0)+NVL(PREPAY_ADJ_AMT,0)+NVL(SPL_AGENCY_DEP_ADJ_AMT,0)+NVL(BILL_TOT_ADJUST_AMT,0) + NVL(BILL_TOT_EXEMPT_AMT,0) + NVL(BILL_TOT_WRITE_OFF_AMT,0) DEP_ADJ,
		BILL_TOT_AMT,
		BILL_TOT_OUTST_AMT,
		A.DOC_DATE,
		RECPT_REFUND_IND, 
		A.DOC_TYPE_CODE RECPT_DOC_TYPE_CODE, 
		A.DOC_NUMBER RECPT_DOC_NUM, 
		RECPT_NATURE_CODE, 
		CUSTOMER_CODE, 
		A.CASH_COUNTER_FACILITY_ID, 
		A.CASH_COUNTER_CODE,    
		A.SHIFT_ID, 
		A.DOC_AMT, 
		A.SLMT_TYPE_CODE, 
		SLMT_DOC_REF_DESC, 
		SLMT_DOC_REF_DATE, 
		SLMT_DOC_REMARKS, 
		APPROVAL_REF_NO,
		BILL_NATURE_CODE,
		C.CASH_SLMT_FLAG,
		NVL(B.BILL_STATUS,'A'),
		nvl(B.PATIENT_ID,A.PATIENT_ID),
		b.cust_code		
	FROM BL_RECEIPT_REFUND_DTL_VW A,
		BL_BILL_HDR B , bl_slmt_type C   
			WHERE
		A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID(+) AND 
		A.BILL_DOC_TYPE_CODE=B.DOC_TYPE_CODE(+)	AND 
		C.SLMT_TYPE_CODE = A.SLMT_TYPE_CODE AND
		A.BILL_DOC_NUMBER = B.DOC_NUM(+) AND 
		A.OPERATING_FACILITY_ID = :nd_facility  AND
		A.CASH_COUNTER_CODE = NVL(:nd_cash_counter,A.CASH_COUNTER_CODE) AND    
		A.ADDED_BY_ID = NVL(:nd_user_id,A.ADDED_BY_ID)	AND  
		A.DOC_DATE BETWEEN 
		     TO_DATE (:nd_login_datetime,'DD/MM/YYYY HH24:MI:SS') AND 
		     TO_DATE(NVL(:nd_logout_datetime,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY HH24:MI:SS') --AND
	   //  NVL(CANCELLED_IND,'N') <> 'Y' 
	UNION ALL
	SELECT B.DOC_TYPE_CODE 
		BILL_DOC_TYPE, 
		B.DOC_NUM BILL_DOC_NUM,
		TO_CHAR(DOC_DATE,'DD/MM/YYYY HH24:MI') DT_TIME,
		GROSS_AMT,SERV_DISC_AMT,BILL_AMT,
	//	 NVL(UNADJ_PREP_AMT,0)+ NVL(DEPOSIT_ADJ_AMT,0)+NVL(DEPOSIT_ADJ_AMT_PD,0)+ NVL(SPL_AGENCY_DEP_ADJ_AMT,0)
	//	+ NVL(BILL_TOT_ADJUST_AMT,0) + NVL(BILL_TOT_EXEMPT_AMT,0) + NVL(BILL_TOT_WRITE_OFF_AMT,0) DEP_ADJ,
    	NVL(DEPOSIT_ADJ_AMT,0)+NVL(PREPAY_ADJ_AMT,0)+NVL(SPL_AGENCY_DEP_ADJ_AMT,0)+NVL(BILL_TOT_ADJUST_AMT,0) + NVL(BILL_TOT_EXEMPT_AMT,0) + NVL(BILL_TOT_WRITE_OFF_AMT,0) DEP_ADJ,
    	BILL_TOT_AMT,
		BILL_TOT_OUTST_AMT,
		B.DOC_DATE,
		NULL RECPT_REFUND_IND, 
		NULL RECPT_DOC_TYPE_CODE, 
		NULL RECPT_DOC_NUM, 
		NULL RECPT_NATURE_CODE, 
		CUST_CODE, 
		CASH_COUNTER_FACILITY_ID, 
		CASH_COUNTER_CODE, 
		SHIFT_ID, 
		NULL DOC_AMT, 
		NULL SLMT_TYPE_CODE, 
		NULL SLMT_DOC_REF_DESC, 
		NULL SLMT_DOC_REF_DATE, 
		NULL SLMT_DOC_REMARKS, 
		NULL APPROVAL_REF_NO,
		'Y' BILL_NATURE_CODE,
		'Y' SLMT_TYPE_CODE,
		NVL(B.BILL_STATUS,'A'),
		B.PATIENT_ID,
		b.cust_code
	FROM	BL_BILL_HDR B 
	//WHERE	BILL_NATURE_CODE ='A' AND
	WHERE
		//B.BILL_AMT = B.BILL_TOT_OUTST_AMT + NVL(B.BILL_TOT_ADJUST_AMT,0) + NVL(B.BILL_TOT_EXEMPT_AMT,0) + NVL(B.BILL_TOT_WRITE_OFF_AMT,0) +
		//		    NVL(UNADJ_PREP_AMT,0)+ NVL(DEPOSIT_ADJ_AMT,0)+NVL(DEPOSIT_ADJ_AMT_PD,0)+ NVL(SPL_AGENCY_DEP_ADJ_AMT,0)
		nvl(BILL_PAID_AMT,0)=0 and nvl(TOT_REFUND_AMT,0)=0
	   
	    AND nvl(B.bill_status,'A')<>'C'
	     
		and 	 
		B.OPERATING_FACILITY_ID = :nd_facility  AND 
		B.CASH_COUNTER_CODE = NVL(:nd_cash_counter,B.CASH_COUNTER_CODE) AND    
		B.ADDED_BY_ID = NVL(:nd_user_id,B.ADDED_BY_ID)	AND  
		B.ADDED_DATE BETWEEN 
		     TO_DATE(:nd_login_datetime,'DD/MM/YYYY HH24:MI:SS') AND 
		     TO_DATE(NVL(:nd_logout_datetime,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY HH24:MI:SS')
	//ORDER BY 1,2;

	UNION ALL
	SELECT
 	B.DOC_TYPE_CODE BILL_DOC_TYPE, 
	B.DOC_NUM  BILL_DOC_NUM,
	TO_CHAR(A.Cancelled_date,'DD/MM/YYYY HH24:MI') DT_TIME,
	GROSS_AMT,
	SERV_DISC_AMT,
	BILL_AMT,
	NVL(DEPOSIT_ADJ_AMT,0)+NVL(PREPAY_ADJ_AMT,0)+NVL(SPL_AGENCY_DEP_ADJ_AMT,0)+NVL(BILL_TOT_ADJUST_AMT,0) + NVL(BILL_TOT_EXEMPT_AMT,0) + NVL(BILL_TOT_WRITE_OFF_AMT,0) DEP_ADJ,
	BILL_TOT_AMT,
	BILL_TOT_OUTST_AMT,
	A.Cancelled_date DOC_DATE,
	C.RECPT_REFUND_IND, 
	C.DOC_TYPE_CODE RECPT_DOC_TYPE_CODE, 
	C.DOC_NUMBER RECPT_DOC_NUM, 
	C.RECPT_NATURE_CODE, 
	C.CUSTOMER_CODE, 
	A.CASH_COUNTER_FACILITY_ID, 
	A.CASH_COUNTER_CODE,    
	A.SHIFT_ID, 
 	(-1*C.DOC_AMT) doc_amt            ,
	C.SLMT_TYPE_CODE, 
	C.SLMT_DOC_REF_DESC, 
	C.SLMT_DOC_REF_DATE, 
	C.SLMT_DOC_REMARKS, 
	C.APPROVAL_REF_NO,
	B.BILL_NATURE_CODE,
	D.CASH_SLMT_FLAG,
	NVL(B.BILL_STATUS,'A'),
	nvl(B.PATIENT_ID,C.PATIENT_ID),
	b.cust_code		
 	FROM BL_CANCELLED_BOUNCED_TRX A , BL_BILL_HDR B, bl_receipt_refund_dtl_vw c,  bl_slmt_type D   
 	where c.operating_facility_id = :nd_facility
	and  a.cancelled_date between TO_DATE(:nd_login_datetime,'DD/MM/YYYY HH24:MI:SS') 
	//and 	TO_DATE(NVL(null,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY HH24:MI:SS')
	and 	TO_DATE(NVL(:nd_logout_datetime,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY HH24:MI:SS')
	and     a.cash_counter_code = nvl(:nd_cash_counter,a.cash_counter_code)
	and     a.added_by_id = nvl(:nd_user_id,a.added_by_id)
	AND B.DOC_TYPE_CODE(+)= C.BILL_DOC_TYPE_CODE  AND
            B.DOC_NUM (+)= C.BILL_DOC_NUMBER
	AND C.DOC_TYPE_CODE = A.DOC_TYPE_CODE AND
    	    C.DOC_NUMBER   =  A.DOC_NUMBER
	AND C.SLMT_TYPE_CODE = D.SLMT_TYPE_CODE 
	ORDER BY 1,2; */ 




}

open_hdr()     
{

    /* EXEC SQL OPEN DAILY_SCROLL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select B.DOC_TYPE_CODE BILL_DOC_TYPE ,B.DOC_NUM BILL_DOC_NUM ,TO_CHAR\
(A.DOC_DATE,'DD/MM/YYYY HH24:MI') DT_TIME ,GROSS_AMT ,SERV_DISC_AMT ,BILL_AM\
T ,(((((NVL(DEPOSIT_ADJ_AMT,0)+NVL(PREPAY_ADJ_AMT,0))+NVL(SPL_AGENCY_DEP_ADJ\
_AMT,0))+NVL(BILL_TOT_ADJUST_AMT,0))+NVL(BILL_TOT_EXEMPT_AMT,0))+NVL(BILL_TO\
T_WRITE_OFF_AMT,0)) DEP_ADJ ,BILL_TOT_AMT ,BILL_TOT_OUTST_AMT ,A.DOC_DATE ,R\
ECPT_REFUND_IND ,A.DOC_TYPE_CODE RECPT_DOC_TYPE_CODE ,A.DOC_NUMBER RECPT_DOC\
_NUM ,RECPT_NATURE_CODE ,CUSTOMER_CODE ,A.CASH_COUNTER_FACILITY_ID ,A.CASH_C\
OUNTER_CODE ,A.SHIFT_ID ,A.DOC_AMT ,A.SLMT_TYPE_CODE ,SLMT_DOC_REF_DESC ,SLM\
T_DOC_REF_DATE ,SLMT_DOC_REMARKS ,APPROVAL_REF_NO ,BILL_NATURE_CODE ,C.CASH_\
SLMT_FLAG ,NVL(B.BILL_STATUS,'A') ,nvl(B.PATIENT_ID,A.PATIENT_ID) ,b.cust_co\
de  from BL_RECEIPT_REFUND_DTL_VW A ,BL_BILL_HDR B ,bl_slmt_type C where (((\
((((A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID(+) and A.BILL_DOC_TYPE_C\
ODE=B.DOC_TYPE_CODE(+)) and C.SLMT_TYPE_CODE=A.SLMT_TYPE_CODE) and A.BILL_DO\
C_NUMBER=B.DOC_NUM(+)) and A.OPERATING_FACI");
    sqlbuft((void **)0, 
      "LITY_ID=:b0) and A.CASH_COUNTER_CODE=NVL(:b1,A.CASH_COUNTER_CODE)) an\
d A.ADDED_BY_ID=NVL(:b2,A.ADDED_BY_ID)) and A.DOC_DATE between TO_DATE(:b3,'\
DD/MM/YYYY HH24:MI:SS') and TO_DATE(NVL(:b4,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24\
:MI:SS')),'DD/MM/YYYY HH24:MI:SS')) union all select B.DOC_TYPE_CODE BILL_DO\
C_TYPE ,B.DOC_NUM BILL_DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY HH24:MI') DT_TI\
ME ,GROSS_AMT ,SERV_DISC_AMT ,BILL_AMT ,(((((NVL(DEPOSIT_ADJ_AMT,0)+NVL(PREP\
AY_ADJ_AMT,0))+NVL(SPL_AGENCY_DEP_ADJ_AMT,0))+NVL(BILL_TOT_ADJUST_AMT,0))+NV\
L(BILL_TOT_EXEMPT_AMT,0))+NVL(BILL_TOT_WRITE_OFF_AMT,0)) DEP_ADJ ,BILL_TOT_A\
MT ,BILL_TOT_OUTST_AMT ,B.DOC_DATE ,null  RECPT_REFUND_IND ,null  RECPT_DOC_\
TYPE_CODE ,null  RECPT_DOC_NUM ,null  RECPT_NATURE_CODE ,CUST_CODE ,CASH_COU\
NTER_FACILITY_ID ,CASH_COUNTER_CODE ,SHIFT_ID ,null  DOC_AMT ,null  SLMT_TYP\
E_CODE ,null  SLMT_DOC_REF_DESC ,null  SLMT_DOC_REF_DATE ,null  SLMT_DOC_REM\
ARKS ,null  APPROVAL_REF_NO ,'Y' BILL_NATURE_CODE ,'Y' SLMT_TYPE_CODE ,NVL(B\
.BILL_STATUS,'A') ,B.PATIENT_ID ,b.cust_cod");
    sqlbuft((void **)0, 
      "e  from BL_BILL_HDR B where ((((((nvl(BILL_PAID_AMT,0)=0 and nvl(TOT_\
REFUND_AMT,0)=0) and nvl(B.bill_status,'A')<>'C') and B.OPERATING_FACILITY_I\
D=:b0) and B.CASH_COUNTER_CODE=NVL(:b1,B.CASH_COUNTER_CODE)) and B.ADDED_BY_\
ID=NVL(:b2,B.ADDED_BY_ID)) and B.ADDED_DATE between TO_DATE(:b3,'DD/MM/YYYY \
HH24:MI:SS') and TO_DATE(NVL(:b4,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS')),'\
DD/MM/YYYY HH24:MI:SS')) union all select B.DOC_TYPE_CODE BILL_DOC_TYPE ,B.D\
OC_NUM BILL_DOC_NUM ,TO_CHAR(A.Cancelled_date,'DD/MM/YYYY HH24:MI') DT_TIME \
,GROSS_AMT ,SERV_DISC_AMT ,BILL_AMT ,(((((NVL(DEPOSIT_ADJ_AMT,0)+NVL(PREPAY_\
ADJ_AMT,0))+NVL(SPL_AGENCY_DEP_ADJ_AMT,0))+NVL(BILL_TOT_ADJUST_AMT,0))+NVL(B\
ILL_TOT_EXEMPT_AMT,0))+NVL(BILL_TOT_WRITE_OFF_AMT,0)) DEP_ADJ ,BILL_TOT_AMT \
,BILL_TOT_OUTST_AMT ,A.Cancelled_date DOC_DATE ,C.RECPT_REFUND_IND ,C.DOC_TY\
PE_CODE RECPT_DOC_TYPE_CODE ,C.DOC_NUMBER RECPT_DOC_NUM ,C.RECPT_NATURE_CODE\
 ,C.CUSTOMER_CODE ,A.CASH_COUNTER_FACILITY_ID ,A.CASH_COUNTER_CODE ,A.SHIFT_\
ID ,((-1)* C.DOC_AMT) doc_amt ,C.SLMT_TYPE_");
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )113;
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
    sqlstm.sqhstv[6] = (         void  *)&nd_cash_counter;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_user_id;
    sqlstm.sqhstl[7] = (unsigned int  )33;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_login_datetime;
    sqlstm.sqhstl[8] = (unsigned int  )32;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_logout_datetime;
    sqlstm.sqhstl[9] = (unsigned int  )32;
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
    sqlstm.sqhstv[11] = (         void  *)&nd_login_datetime;
    sqlstm.sqhstl[11] = (unsigned int  )32;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_logout_datetime;
    sqlstm.sqhstl[12] = (unsigned int  )32;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_cash_counter;
    sqlstm.sqhstl[13] = (unsigned int  )7;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_user_id;
    sqlstm.sqhstl[14] = (unsigned int  )33;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor DAILY_SCROLL",0,"");
}

fetch_hdr()
{



	l_bill_doc_type.arr[0]		=	'\0'; 
	l_bill_doc_num.arr[0]		= '\0' ; 
	l_recpt_doc_num.arr [0]		= '\0';
	l_dt_time.arr[0]		=	'\0';
	l_slmt_type_code.arr[0]		=	'\0'; 
	l_slmt_doc_ref_desc.arr[0]	=	'\0'; 
	l_slmt_doc_ref_date.arr[0]	=	'\0'; 
	l_slmt_doc_remarks.arr[0]	=	'\0';  
	l_approval_ref_no.arr[0]	=	'\0'; 
	l_recept_doc_date.arr[0]	=	'\0'; 
	l_recpt_refund_ind.arr[0]	=	'\0'; 
	l_recpt_doc_type_code.arr[0]	=	'\0'; 
	l_recpt_nature_code.arr[0]	=	'\0'; 
	l_customer_code.arr[0]		=	'\0'; 
	l_cash_counter_facility_id.arr[0]	=	'\0'; 
	l_cash_counter_code.arr[0]	=	'\0'; 
	l_shift_id.arr[0]		=	'\0'; 
	l_bill_nature.arr[0]		=	'\0';
	l_cash_slmt_flag.arr[0] = '\0';
	l_bill_status.arr[0] = '\0';
	l_patient_id.arr[0] = '\0';
	l_cust_code.arr[0] = '\0';



	l_gross_amt		=	0;
	l_serv_disc_amt		=	0;
	l_doc_amt		=	0;
	l_bill_amt		=	0;
    l_dep_adj		=	0;
	l_bill_tot_amt		=	0;
	l_bill_tot_outst_amt	=	0;
	l_recept_doc_amt	=	0;

	l_bill_doc_type.len		=	0;
	l_bill_doc_num.len		= 0;
	l_recpt_doc_num.len		= 0;
	l_dt_time.len			=	0;
	l_slmt_type_code.len		=	0;
	l_slmt_doc_ref_desc.len		=	0; 
	l_slmt_doc_ref_date.len		=	0; 
	l_slmt_doc_remarks.len		=	0;  
	l_approval_ref_no.len		=	0; 
	l_recept_doc_date.len		=	0; 
	l_recpt_refund_ind.len		=	0; 
	l_recpt_doc_type_code.len	=	0; 
	l_recpt_nature_code.len		=	0; 
	l_customer_code.len		=	0;
	l_cash_counter_facility_id.len	=	0; 
	l_cash_counter_code.len		=	0; 
	l_shift_id.len			=	0; 
	l_bill_nature.len		=	0;
	l_cash_slmt_flag.len		= 0 ; 
	l_bill_status.len = 0;
	l_patient_id.len = 0;
	l_cust_code.len=0;


      	/* EXEC SQL FETCH DAILY_SCROLL
            INTO 	
		:l_bill_doc_type, 
		:l_bill_doc_num,
		:l_dt_time,
		:l_gross_amt,
		:l_serv_disc_amt,
		:l_bill_amt,
	    :l_dep_adj,
		:l_bill_tot_amt,
		:l_bill_tot_outst_amt,
		:l_recept_doc_date,
		:l_recpt_refund_ind, 
		:l_recpt_doc_type_code, 
		:l_recpt_doc_num, 
		:l_recpt_nature_code, 
		:l_customer_code, 
		:l_cash_counter_facility_id, 
		:l_cash_counter_code, 
		:l_shift_id, 
		:l_doc_amt, 
		:l_slmt_type_code, 
		:l_slmt_doc_ref_desc, 
		:l_slmt_doc_ref_date, 
		:l_slmt_doc_remarks, 
		:l_approval_ref_no,
		:l_bill_nature,
		:l_cash_slmt_flag,
		:l_bill_status,
		:l_patient_id,
		:l_cust_code; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 29;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )188;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&l_bill_doc_type;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&l_bill_doc_num;
       sqlstm.sqhstl[1] = (unsigned int  )33;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&l_dt_time;
       sqlstm.sqhstl[2] = (unsigned int  )33;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&l_gross_amt;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&l_serv_disc_amt;
       sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&l_bill_amt;
       sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&l_dep_adj;
       sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&l_bill_tot_amt;
       sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&l_bill_tot_outst_amt;
       sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&l_recept_doc_date;
       sqlstm.sqhstl[9] = (unsigned int  )14;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&l_recpt_refund_ind;
       sqlstm.sqhstl[10] = (unsigned int  )6;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&l_recpt_doc_type_code;
       sqlstm.sqhstl[11] = (unsigned int  )9;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&l_recpt_doc_num;
       sqlstm.sqhstl[12] = (unsigned int  )33;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&l_recpt_nature_code;
       sqlstm.sqhstl[13] = (unsigned int  )13;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&l_customer_code;
       sqlstm.sqhstl[14] = (unsigned int  )13;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&l_cash_counter_facility_id;
       sqlstm.sqhstl[15] = (unsigned int  )13;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&l_cash_counter_code;
       sqlstm.sqhstl[16] = (unsigned int  )13;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&l_shift_id;
       sqlstm.sqhstl[17] = (unsigned int  )13;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&l_doc_amt;
       sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&l_slmt_type_code;
       sqlstm.sqhstl[19] = (unsigned int  )5;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&l_slmt_doc_ref_desc;
       sqlstm.sqhstl[20] = (unsigned int  )33;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&l_slmt_doc_ref_date;
       sqlstm.sqhstl[21] = (unsigned int  )27;
       sqlstm.sqhsts[21] = (         int  )0;
       sqlstm.sqindv[21] = (         void  *)0;
       sqlstm.sqinds[21] = (         int  )0;
       sqlstm.sqharm[21] = (unsigned int  )0;
       sqlstm.sqadto[21] = (unsigned short )0;
       sqlstm.sqtdso[21] = (unsigned short )0;
       sqlstm.sqhstv[22] = (         void  *)&l_slmt_doc_remarks;
       sqlstm.sqhstl[22] = (unsigned int  )103;
       sqlstm.sqhsts[22] = (         int  )0;
       sqlstm.sqindv[22] = (         void  *)0;
       sqlstm.sqinds[22] = (         int  )0;
       sqlstm.sqharm[22] = (unsigned int  )0;
       sqlstm.sqadto[22] = (unsigned short )0;
       sqlstm.sqtdso[22] = (unsigned short )0;
       sqlstm.sqhstv[23] = (         void  *)&l_approval_ref_no;
       sqlstm.sqhstl[23] = (unsigned int  )32;
       sqlstm.sqhsts[23] = (         int  )0;
       sqlstm.sqindv[23] = (         void  *)0;
       sqlstm.sqinds[23] = (         int  )0;
       sqlstm.sqharm[23] = (unsigned int  )0;
       sqlstm.sqadto[23] = (unsigned short )0;
       sqlstm.sqtdso[23] = (unsigned short )0;
       sqlstm.sqhstv[24] = (         void  *)&l_bill_nature;
       sqlstm.sqhstl[24] = (unsigned int  )4;
       sqlstm.sqhsts[24] = (         int  )0;
       sqlstm.sqindv[24] = (         void  *)0;
       sqlstm.sqinds[24] = (         int  )0;
       sqlstm.sqharm[24] = (unsigned int  )0;
       sqlstm.sqadto[24] = (unsigned short )0;
       sqlstm.sqtdso[24] = (unsigned short )0;
       sqlstm.sqhstv[25] = (         void  *)&l_cash_slmt_flag;
       sqlstm.sqhstl[25] = (unsigned int  )4;
       sqlstm.sqhsts[25] = (         int  )0;
       sqlstm.sqindv[25] = (         void  *)0;
       sqlstm.sqinds[25] = (         int  )0;
       sqlstm.sqharm[25] = (unsigned int  )0;
       sqlstm.sqadto[25] = (unsigned short )0;
       sqlstm.sqtdso[25] = (unsigned short )0;
       sqlstm.sqhstv[26] = (         void  *)&l_bill_status;
       sqlstm.sqhstl[26] = (unsigned int  )3;
       sqlstm.sqhsts[26] = (         int  )0;
       sqlstm.sqindv[26] = (         void  *)0;
       sqlstm.sqinds[26] = (         int  )0;
       sqlstm.sqharm[26] = (unsigned int  )0;
       sqlstm.sqadto[26] = (unsigned short )0;
       sqlstm.sqtdso[26] = (unsigned short )0;
       sqlstm.sqhstv[27] = (         void  *)&l_patient_id;
       sqlstm.sqhstl[27] = (unsigned int  )62;
       sqlstm.sqhsts[27] = (         int  )0;
       sqlstm.sqindv[27] = (         void  *)0;
       sqlstm.sqinds[27] = (         int  )0;
       sqlstm.sqharm[27] = (unsigned int  )0;
       sqlstm.sqadto[27] = (unsigned short )0;
       sqlstm.sqtdso[27] = (unsigned short )0;
       sqlstm.sqhstv[28] = (         void  *)&l_cust_code;
       sqlstm.sqhstl[28] = (unsigned int  )52;
       sqlstm.sqhsts[28] = (         int  )0;
       sqlstm.sqindv[28] = (         void  *)0;
       sqlstm.sqinds[28] = (         int  )0;
       sqlstm.sqharm[28] = (unsigned int  )0;
       sqlstm.sqadto[28] = (unsigned short )0;
       sqlstm.sqtdso[28] = (unsigned short )0;
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
            err_mesg("FETCH failed on cursor DAILY_SCROLL",0,"");

		l_bill_doc_type.arr[l_bill_doc_type.len]		=	'\0'; 
		l_bill_doc_num.arr[l_bill_doc_num.len]			= '\0';
		l_recpt_doc_num.arr[l_recpt_doc_num.len]		= '\0';
		l_dt_time.arr[l_dt_time.len]				=	'\0';
		l_recept_doc_date.arr[l_recept_doc_date.len]		=	'\0'; 
		l_recpt_refund_ind.arr[l_recpt_refund_ind.len]		=	'\0'; 
		l_recpt_doc_type_code.arr[l_recpt_doc_type_code.len]	=	'\0'; 
		l_recpt_nature_code.arr[l_recpt_nature_code.len]	=	'\0'; 
		l_customer_code.arr[l_customer_code.len]		=	'\0'; 
		l_cash_counter_facility_id.arr[l_cash_counter_facility_id.len]	=	'\0'; 
		l_cash_counter_code.arr[l_cash_counter_code.len]	=	'\0'; 
		l_shift_id.arr[l_shift_id.len]				=	'\0'; 
		l_slmt_type_code.arr[l_slmt_type_code.len]		=	'\0'; 
		l_slmt_doc_ref_desc.arr[l_slmt_doc_ref_desc.len]	=	'\0'; 
		l_slmt_doc_ref_date.arr[l_slmt_doc_ref_date.len]	=	'\0'; 
		l_slmt_doc_remarks.arr[l_slmt_doc_remarks.len]		=	'\0';  
		l_approval_ref_no.arr[l_approval_ref_no.len]		=	'\0'; 
		l_bill_nature.arr[l_bill_nature.len]			=	'\0';
		l_cash_slmt_flag.arr[l_cash_slmt_flag.len] = '\0';
		l_bill_status.arr[l_bill_status.len] = '\0';
		l_patient_id.arr[l_patient_id.len] = '\0';
		l_cust_code.arr[l_cust_code.len]= '\0';
    return(LAST_ROW?0:1);
}

print_rec()
{
	
    //bl_total_docamt =0; 
    print_day_details();

     

}

print_day_details()
{

	char emsg[200]; 
	print_head();

  while(fetch_hdr())
  {
	
	  //fprintf(fp,"%2d   ",l_rslno);
	   if (strcmp(l_prev_bill_ref,l_bill_doc_num.arr) != 0)
	   {
			strcpy(l_prev_bill_ref,l_bill_doc_num.arr);
     		l_slno++;
		    if (strcmp(l_bill_status.arr,"C")!=0)
			{
				if(l_bill_doc_num.arr[0] != '\0') 
				{ 
				
						  l_bill++;

	                      
						  fprintf(fp,"%6s/%-8s",l_bill_doc_type.arr,l_bill_doc_num.arr); 
						  print_formated(l_gross_amt);
						  print_formated(l_bill_amt);
						  print_formated(l_dep_adj);
						  print_formated(l_bill_tot_amt);


						  

						  if (l_cust_code.arr[0]!='\0')
						   {
						   l_credit++;
						   }
								  
						  if (l_bill_tot_outst_amt==0)
						  { 	
							replicate(' ',11);
						  }
						  else if(l_bill_tot_outst_amt != 0)
						  { 
							  l_due++;
							  print_formated(l_bill_tot_outst_amt);
						  }

						  else
						  {
							replicate(' ',11);
						  }

						  if (l_bill_nature.arr=='A')
						  { 
							l_cr++;
							print_formated(l_bill_tot_outst_amt);

						  }
						 else
						 {
							replicate(' ',11);
						 }
						 replicate(' ',2);

	                    if (l_recpt_doc_type_code.arr[0]!='\0') //senthil
						{
						fprintf(fp,"%6s/%-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);	  		  \
						 }
						else
						  {
						fprintf(fp,"%6s %-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);	  		  
						   }
						
						
						l_cash_amt = 0;
						l_cc_amt = 0;
						l_cheq_amt = 0;
						
						if ((strcmp(l_cash_slmt_flag.arr,"A") == 0) && (l_recpt_doc_type_code.arr[0] != '\0'))
						{
					
							l_cash_amt = 0;
							l_cheq_amt = 0;
							l_cc_amt = l_doc_amt;
							l_other_amt = 0;
							l_cc++;
						}

						else
						if((strcmp(l_cash_slmt_flag.arr,"B") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						{
				
							l_cash_amt = 0;
							l_cheq_amt = l_doc_amt;
							l_cc_amt = 0; 
							l_other_amt = 0;
							l_cc++; 
						}
						 else
						 if((strcmp(l_cash_slmt_flag.arr,"Y") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						 {
	

							 l_cash_amt = l_doc_amt;
							 l_cheq_amt = 0;
							 l_cc_amt =  0;		
							 l_other_amt = 0;
							 l_cash++; 
						 }
						 else   /* Prabhakar Changes starts  */
						 if((strcmp(l_cash_slmt_flag.arr,"C") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0')
						 || (strcmp(l_cash_slmt_flag.arr,"D") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						 {
							 l_cash_amt = 0;	
							 l_cheq_amt = 0;
							 l_cc_amt =  0;	
							 l_other_amt = l_doc_amt;
							 l_others++; 
						 }   /* Prabhakar Changes Ends.  */
						 else /* ---to be verified ---*/
						 {
							if(l_recpt_doc_type_code.arr[0] != '\0')
							 {

								 l_cash_amt = l_doc_amt;
								 l_cheq_amt = 0;
								 l_cc_amt =  0;		
								 l_cash++; 
							 }
						}/* ---to be verified ---*/
						 if (l_recpt_doc_type_code.arr[0] == '\0')
						{
		
							l_cash_amt = 0;
							 l_cheq_amt = 0;
							 l_cc_amt =  0;	
							 l_other_amt = 0;	
							 
						}
								print_formated(l_cash_amt);
								l_tot_cash_amt += l_cash_amt;
								
								print_formated(l_cc_amt);
								l_tot_cc_amt += l_cc_amt;
								
								print_formated(l_cheq_amt);
								l_tot_cheq_amt += l_cheq_amt;
					

								print_formated(l_other_amt);
								l_tot_other_amt += l_other_amt;

						replicate(' ',2); //senthil 8
						fprintf(fp,"%-s",l_customer_code.arr);
					//	replicate(' ',144);
					//	fprintf(fp,"%-s",l_patient_id.arr);

					}
					else
					{

						replicate(' ',83);	
						
						if (l_recpt_doc_type_code.arr!= '\0')
						{
						fprintf(fp,"%6s/%-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);
						}
						else
						{
						fprintf(fp,"%6s %-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);
						}
						
						
						l_cash_amt = 0;
						l_cc_amt = 0;
						l_cheq_amt = 0;

						if ((strcmp(l_cash_slmt_flag.arr,"A") == 0) && (l_recpt_doc_type_code.arr[0] != '\0'))
						 {
	

							l_cash_amt = 0;
							l_cheq_amt = 0;
							l_cc_amt = l_doc_amt;
							l_cc++;
						  }
						else
						if ((strcmp(l_cash_slmt_flag.arr,"B") == 0) && (l_recpt_doc_type_code.arr[0] != '\0'))
						{



							l_cash_amt = 0;
							l_cheq_amt = l_doc_amt;
							l_cc_amt =  0;
							l_cheq++;
						}
						else
						if((strcmp(l_cash_slmt_flag.arr,"Y") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						{


							l_cash_amt = l_doc_amt;
							l_cheq_amt = 0;
							l_cc_amt =  0;
							l_cash++;
						}
						 else   /* Prabhakar Changes starts  */
						 if((strcmp(l_cash_slmt_flag.arr,"C") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0')
						 || (strcmp(l_cash_slmt_flag.arr,"D") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						 {
							 l_cash_amt = 0;	
							 l_cheq_amt = 0;
							 l_cc_amt =  0;	
							 l_other_amt = l_doc_amt;
							 l_others++; 

						 }   /* Prabhakar Changes Ends.  */
						 else /* ---to be verified ---*/
						 {
							if(l_recpt_doc_type_code.arr[0] != '\0')
							 {
	
								 l_cash_amt = l_doc_amt;
								 l_cheq_amt = 0;
								 l_cc_amt =  0;		
								 l_cash++; 
							 }
						}/* ---to be verified ---*/
						
							print_formated(l_cash_amt);
							l_tot_cash_amt += l_cash_amt;
							
							print_formated(l_cc_amt);
							l_tot_cc_amt += l_cc_amt;
							
							print_formated(l_cheq_amt);
							l_tot_cheq_amt += l_cheq_amt;

							print_formated(l_other_amt);
							l_tot_other_amt += l_other_amt;
					   
					}
					//replicate(' ',8);
					  replicate(' ',2);

					 // replicate(' ',144);
					  //fprintf(fp,"\n");

					//fprintf(fp,"%s",l_customer_code.arr);
					
					tot_l_gross_amt+=l_gross_amt;
					tot_l_bill_amt += l_bill_amt; 
					tot_l_dep_adj += l_dep_adj;
					tot_l_bill_tot_amt += l_bill_tot_amt; 
				}
				else
				{
									if(l_bill_doc_num.arr[0] != '\0') 
				{ 
				
						  l_bill++;

					if (l_cust_code.arr[0]!='\0')
					{
					l_credit++;
					}
	
						  fprintf(fp,"%6s/%-8s",l_bill_doc_type.arr,l_bill_doc_num.arr); 
						  print_formated(l_gross_amt);
						  print_formated(l_bill_amt);
						  print_formated(l_dep_adj);
						  print_formated(l_bill_tot_amt);
								  
						  if (l_bill_tot_outst_amt==0)
						  { 	
							replicate(' ',11);
						  }
						  else if(l_bill_tot_outst_amt != 0)
						  { 
							  l_due++;
							  print_formated(l_bill_tot_outst_amt);
						  }
						  else
						  {
							replicate(' ',11);
						  }

						  if (l_bill_nature.arr=='A')
						  { 
							l_cr++;
							print_formated(l_bill_tot_outst_amt);

						  }
						 else
						 {
							replicate(' ',11);
						 }
						 replicate(' ',2);
						  //fprintf(fp,"%6s/%-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);
						 fprintf(fp,"Cancelled Bill ");	  		  
						
						l_cash_amt = 0;
						l_cc_amt = 0;
						l_cheq_amt = 0;
						
						if ((strcmp(l_cash_slmt_flag.arr,"A") == 0) && (l_recpt_doc_type_code.arr[0] != '\0'))
						{

							l_cash_amt = 0;
							l_cheq_amt = 0;
							l_cc_amt = l_doc_amt;
							l_cc++;
						}

						else
						if((strcmp(l_cash_slmt_flag.arr,"B") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						{

					
							l_cash_amt = 0;
							l_cheq_amt = l_doc_amt;
							l_cc_amt = 0; 
							l_cc++; 
						}
						 else
						 if((strcmp(l_cash_slmt_flag.arr,"Y") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						 {

							 l_cash_amt = l_doc_amt;
							 l_cheq_amt = 0;
							 l_cc_amt =  0;		
							 l_cash++; 
						 }
						 else   /* Prabhakar Changes starts  */
						 if((strcmp(l_cash_slmt_flag.arr,"C") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0')
						 || (strcmp(l_cash_slmt_flag.arr,"D") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						 {
							 l_cash_amt = 0;	
							 l_cheq_amt = 0;
							 l_cc_amt =  0;	
							 l_other_amt = l_doc_amt;
							 l_others++; 
						 }   /* Prabhakar Changes Ends.  */
						 else /* ---to be verified ---*/
						 {
							if(l_recpt_doc_type_code.arr[0] != '\0')
							 {
				
								 l_cash_amt = l_doc_amt;
								 l_cheq_amt = 0;
								 l_cc_amt =  0;		
								 l_cash++; 
							 }
						}/* ---to be verified ---*/
						 if (l_recpt_doc_type_code.arr[0] == '\0')
						{
				
							l_cash_amt = 0;
							 l_cheq_amt = 0;
							 l_cc_amt =  0;		
							 
						}
								print_formated(l_cash_amt);
								l_tot_cash_amt += l_cash_amt;
								
								print_formated(l_cc_amt);
								l_tot_cc_amt += l_cc_amt;
								
								print_formated(l_cheq_amt);
								l_tot_cheq_amt += l_cheq_amt;

								print_formated(l_other_amt);
								l_tot_other_amt += l_other_amt;

						replicate(' ',2); //senthil
					 	fprintf(fp,"%-s",l_customer_code.arr);
						//fprintf(fp,"%-s",l_patient_id.arr);
						//replicate(' ',144);
					
					//	fprintf(fp,"%-s",l_patient_id.arr);
					}
					else
					{
						replicate(' ',83);	
                        
						if (l_recpt_doc_type_code.arr[0] != '\0')
						{
						fprintf(fp,"%6s/%-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);
						}
						else
                        {
                        fprintf(fp,"%6s %-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);
						}
						
						l_cash_amt = 0;
						l_cc_amt = 0;
						l_cheq_amt = 0;
						l_other_amt = 0;
						
						if ((strcmp(l_cash_slmt_flag.arr,"A") == 0) && (l_recpt_doc_type_code.arr[0] != '\0'))
						 {

							l_cash_amt = 0;
							l_cheq_amt = 0;
							l_cc_amt = l_doc_amt;
							l_cc++;
						  }
						else
						if ((strcmp(l_cash_slmt_flag.arr,"B") == 0) && (l_recpt_doc_type_code.arr[0] != '\0'))
						{
			
							l_cash_amt = 0;
							l_cheq_amt = l_doc_amt;
							l_cc_amt =  0;
							l_cheq++;
						}
						else
						if((strcmp(l_cash_slmt_flag.arr,"Y") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						{
							l_cash_amt = l_doc_amt;
							l_cheq_amt = 0;
							l_cc_amt =  0;
							l_cash++;
						}
						 else   /* Prabhakar Changes starts  */
						 if((strcmp(l_cash_slmt_flag.arr,"C") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0')
						 || (strcmp(l_cash_slmt_flag.arr,"D") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
						 {
							 l_cash_amt = 0;	
							 l_cheq_amt = 0;
							 l_cc_amt =  0;	
							 l_other_amt = l_doc_amt;
							 l_others++; 
						 }   /* Prabhakar Changes Ends.  */
						 else /* ---to be verified ---*/
						 {
							if(l_recpt_doc_type_code.arr[0] != '\0')
							 {
			
								 l_cash_amt = l_doc_amt;
								 l_cheq_amt = 0;
								 l_cc_amt =  0;		
								 l_cash++; 
							 }
						}/* ---to be verified ---*/
						
							print_formated(l_cash_amt);
							l_tot_cash_amt += l_cash_amt;
							
							print_formated(l_cc_amt);
							l_tot_cc_amt += l_cc_amt;
							
							print_formated(l_cheq_amt);
							l_tot_cheq_amt += l_cheq_amt;

							print_formated(l_other_amt);
							l_tot_other_amt += l_other_amt;

					   
					}
					//replicate(' ',8);
					replicate(' ',2);
					fprintf(fp,"%s",l_customer_code.arr);
					//replicate(' ',144);
					//fprintf(fp,"%-s",l_patient_id.arr);
				}
	  }
      else
	   {

		replicate(' ',83);	
        
		if (l_recpt_doc_type_code.arr[0] != '\0') 
		{
		fprintf(fp,"%6s/%-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);		  
		}
		else
		{
		fprintf(fp,"%6s %-8s",l_recpt_doc_type_code.arr,l_recpt_doc_num.arr);		  
		}
	
		l_cash_amt = 0;
		l_cc_amt = 0;
		l_cheq_amt = 0;
		l_other_amt = 0;
		
		if((strcmp(l_cash_slmt_flag.arr,"A") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
		{
		
			l_cash_amt = 0;
			l_cheq_amt = 0;
			l_cc_amt = l_doc_amt;
			l_cc++;
		}
		else
		if((strcmp(l_cash_slmt_flag.arr,"B") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
		{
		
			l_cash_amt = 0;
			l_cheq_amt = l_doc_amt;
			l_cc_amt =  0;
			l_cheq++;
		}
		else
		if((strcmp(l_cash_slmt_flag.arr,"Y") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
		{
			l_cash_amt = l_doc_amt;
			l_cheq_amt = 0;
			l_cc_amt =  0;
			l_cash++;
			
		}
		 else   /* Prabhakar Changes starts  */
		 if((strcmp(l_cash_slmt_flag.arr,"C") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0')
		 || (strcmp(l_cash_slmt_flag.arr,"D") == 0)  && (l_recpt_doc_type_code.arr[0] != '\0'))
		 {
			 l_cash_amt = 0;	
			 l_cheq_amt = 0;
			 l_cc_amt =  0;	
			 l_other_amt = l_doc_amt;
			 l_others++; 
		 }   /* Prabhakar Changes Ends.  */
		 else /* ---to be verified ---*/
			 {
				if(l_recpt_doc_type_code.arr[0] != '\0')
				 {

					 l_cash_amt = l_doc_amt;
					 l_cheq_amt = 0;
					 l_cc_amt =  0;		
					 l_cash++; 
				 }
			}/* ---to be verified ---*/	
		print_formated(l_cash_amt);
		l_tot_cash_amt += l_cash_amt;
		
		print_formated(l_cc_amt);
		l_tot_cc_amt += l_cc_amt;
		
		print_formated(l_cheq_amt);
		l_tot_cheq_amt += l_cheq_amt;

		print_formated(l_other_amt);
		l_tot_other_amt += l_other_amt;

		//replicate(' ',8);
		replicate(' ',2);
		fprintf(fp,"%s",l_customer_code.arr);
		//replicate(' ',144);
		//fprintf(fp,"%-s",l_patient_id.arr);

		
		} 
		fprintf(fp,"\n");
		replicate(' ',144);
		fprintf(fp,"%-s",l_patient_id.arr);
		fprintf(fp,"\n");

		v_lno++;
	   if (v_lno > max_lines) 
	   { 
	   print_next_page1();
	   }
	}

	print_total(); 
 
    if (v_lno>=10)//17353 by saikiran on 17-dec-2009
	{
	  fprintf(fp,"%c&l0H",ESC);// TO Eject Page
		v_lno = 0; 
		print_space=1;
		print_title(); 
	    fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------------------\n"); //17353 by saikiran on 17-dec-2009
	    print_last(); 
	  }
	else //17353 by saikiran on 17-dec-2009
	{
	  print_last(); 
	}
	fclose(fp); 
	fflush(fp);
  
}	
print_total()
{ 
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------\n"); 
	fprintf(fp,"Total");
	replicate(' ',10);
	
	print_formated(tot_l_gross_amt);
	print_formated(tot_l_bill_amt);
	print_formated(tot_l_dep_adj);
	print_formated(tot_l_bill_tot_amt);
	
	replicate(' ',39);

	print_formated(l_tot_cash_amt);
	print_formated(l_tot_cc_amt);
	print_formated(l_tot_cheq_amt);
	print_formated(l_tot_other_amt);

	fprintf(fp,"\n");
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------\n"); 
}

print_last()
{ 

	fprintf(fp,"\n\n\n");
	fprintf(fp,"%c(s12H",ESC);
	
	fprintf(fp,"Summary\n");
	fprintf(fp,"-------\n");
	
	fprintf(fp,"%10s Number of Bills Generated : %d"," ",l_bill);
	fprintf(fp,"%10s Due Bills   : %d"," ",l_due); 
	//fprintf(fp,"%10s Credit Bills : %d"," ",l_due);
	fprintf(fp,"%10s Credit Bills : %d"," ",l_credit);
	fprintf(fp,"\n");
	
	fprintf(fp,"%10s Cash Receipts             : %d"," ",l_cash);
	fprintf(fp,"%10s Credit Cards:%d"," ",l_cc); 
	fprintf(fp,"%10s Cheques      : %d"," ",l_cheq);
	fprintf(fp,"%10s Others      : %d"," ",l_others);    /* Added by Prabhakar.D.  */
	fprintf(fp,"\n\n\n\n\n");
	
	fprintf(fp,"%100s\n","Name of Operator");
	fprintf(fp,"%100s\n",nd_user_name.arr);
	
	fprintf(fp,"\n\n\n");
	fprintf(fp,"%c(s3B",ESC);
	fprintf(fp,"%c(s10H",ESC);
	fprintf(fp,"For Accounts Department:\n\n\n");
	fprintf(fp,"%c(s-3B",ESC);
	fprintf(fp,"%c(s12H",ESC);
	fprintf(fp,"Amount Received:\n\n");
	fprintf(fp,"Cash:\n\n");
	fprintf(fp,"Cheque:\n\n");
	fprintf(fp,"DD:\n\n");
	fprintf(fp,"Credit/Debit Card:\n\n\n\n\n");

	fprintf(fp,"Signature");
	
	v_lno++;
	if (v_lno > max_lines) 
	{ 
	print_next_page1();
	}

}
print_title()
{	

	fprintf(fp,"%c(s0P",ESC);	/* To fix the Primary Spacing		*/
	fprintf(fp,"%c&l1O",ESC); /* Set Landscape*/ 
	// LINE-1
	fprintf(fp,"\n\n");
    if (print_space==0) //17353 by saikiran on 17-dec-2009
	{
    replicate(' ' ,51);   
	}
	else 
	 replicate(' ' ,71);   
	fprintf(fp,"%c&d0D",ESC); /* set Underline mode */
	fprintf(fp,"%c(s3B",ESC); /* For Bold printing */
    fprintf(fp,"%c(s12H",ESC); 	/* To set the font 			*/	 //17353 by saikiran on 17-dec-2009
	//This is added because from the second page onwards font is displaying in small font and aligning
	//to left hand side
	fprintf(fp,"SCROLL");
	fprintf(fp,"\n\n");
	fprintf(fp,"%c(s-3B",ESC); /* For Bold printing release */	    
	fprintf(fp,"%c&d@",ESC); /* release underline mode */
	fprintf(fp,"%c&a1L",ESC); /* settting the left margin */
	fprintf(fp,"\n");
    

//LINE 2 
	
	fprintf(fp,"%c(s12H",ESC); 	/* To set the font 			*/	
	fprintf(fp,"Scroll No       : %-30.30s"," ");
	fprintf(fp,"                                             ");
	fprintf(fp,"Counter NO.   : ");
	fprintf(fp,"%-20s\n",nd_cash_counter.arr);

//line 3 

	fprintf(fp,"Cashier ID      : %-30.30s",nd_user_id.arr);
	fprintf(fp,"                                             ");
	fprintf(fp,"Cashier Name  : ");
	nd_user_name.arr[0] = '\0'; 
	nd_user_name.len	= '\0'; 
	
	/* EXEC SQL 
		select appl_user_name into :nd_user_name
			from sm_appl_user where appl_user_id = :nd_user_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select appl_user_name into :b0  from sm_appl_user where appl\
_user_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )319;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_user_name;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_user_id;
 sqlstm.sqhstl[1] = (unsigned int  )33;
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


		
	fprintf(fp,"%-20s\n",nd_user_name.arr);
	
	nd_user_name.arr[nd_user_name.len]	= '\0';

//line 4 
//	fprintf(fp,"From Date       : %-30.30s",l_print_login_date.arr);
   if(l_print_login_date.arr[0]!='\0')
   {
      init_date_temp_var();                              
 	  strcpy(date_convert.arr,l_print_login_date.arr);         
 	  fun_change_loc_date();
 	  fprintf(fp,"From Date       : %-30.30s",date_convert.arr);
     }
	fprintf(fp,"                                             ");
 
   if(l_print_login_date.arr[0]!='\0')
   {
      init_date_temp_var();                              

	  strcpy(date_convert.arr,l_print_login_date.arr);         
 	  fun_change_loc_date();
		fprintf(fp,"To Date       :",date_convert.arr);
     }
	
//	fprintf(fp,"To Date       :",l_print_login_date.arr);

   if(l_print_logout_date.arr[0]!='\0')
   {
      init_date_temp_var();                              

	  strcpy(date_convert.arr,l_print_logout_date.arr);         
 	  fun_change_loc_date();
	fprintf(fp,"%-20s\n\n",date_convert.arr);
     }

//	fprintf(fp,"%-20s\n\n",l_print_logout_date.arr);
}

end_of_rep()
{
	fprintf(fp,"\n\n %72s   ***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}


open_file()
{
	strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRCACTR.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRCACTR.lis");
       proc_exit();
    }
}

print_head()
{
	
	
	fprintf(fp,"%c&a2L",ESC); /* settting the left margin */
	fprintf(fp,"%c&l8D",ESC); 	/* To set vertical lines per inch 	*/
	fprintf(fp,"%c(s14H",ESC); 	/* To set the font 			*/
	fprintf(fp,"%c(s3B",ESC); 

	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(fp,"Bill Number       Gross      Net Bill   Deposit    Bill Pay.  Due Bill   Credit    Receipt/Refund               Receipt                         Customer \n");
	fprintf(fp,"                  Bill Amt   Amount     Amount/    Amount     Amount     Bill Amt  Number                Cash   Credit Card  Cheque      Others			   \n");
	fprintf(fp,"                                        Exp/Adj	                                                                                                Patient Id    \n");
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
	fprintf(fp,"%c(s-3B",ESC);
}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt1(s_amt);
        sprintf(str_amt,"%9s",s_amt);
        fprintf(fp,"%9.9sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt1(s_amt);
        sprintf(str_amt,"%11s",s_amt);
        fprintf(fp,"%11.11s",str_amt);
        }

}                           

horz_skip(num) /* this is to obtain required blank space */
int num;
	{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
	}

replicate(printchar,no_of_times)
int printchar;
int no_of_times;
{
int i;
    for (i = 0; i < no_of_times; i++)
	    
	    fprintf(fp,"%c",printchar);
	   	          
  	return;
}

print_next_page1()
{
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------\n"); 
	fprintf(fp,"Total");
	replicate(' ',10);

	print_formated(tot_l_gross_amt);
	print_formated(tot_l_bill_amt);
	print_formated(tot_l_dep_adj);
	print_formated(tot_l_bill_tot_amt);
	
	replicate(' ',39);

	print_formated(l_tot_cash_amt);
	print_formated(l_tot_cc_amt);
	print_formated(l_tot_cheq_amt);

	fprintf(fp,"\n");
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------\n"); 
	fprintf(fp,"%c&l8D",ESC);
	 
	fprintf(fp,"%c&l0H",ESC);// To Eject Page
	v_lno = 0; 
	print_space=1;
	print_title();//17353 by saikiran on 17-dec-2009
	print_head();
}


format_amt1(str)
char	*str;
{
	

	/* EXEC SQL SELECT no_of_decimal
               INTO :l_no_of_decimal
	  		   FROM sm_acc_entity_param
              WHERE acc_entity_id = (SELECT acc_entity_code 
									   FROM sy_acc_entity
									  WHERE acc_entity_id = :nd_facility); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select no_of_decimal into :b0  from sm_acc_entity_param wher\
e acc_entity_id=(select acc_entity_code  from sy_acc_entity where acc_entity_i\
d=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )342;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_no_of_decimal;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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


      

   	if (sqlca.sqlcode < 0) 
	{
        disp_message(ORA_MESG,"ERR_MESG: Select failed in sm_acc_entity_param");
      	/* EXEC SQL ROLLBACK WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 29;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )365;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	}

	if(strlen(str) == 0)
	{
		if(l_no_of_decimal == 2)
		{
			strcpy(str, "0.00");
		}
		else if(l_no_of_decimal == 3)
		{
			strcpy(str, "0.000");
		}
	}
	else 
	{      
		u_ltrim(str);
		str = check_decimal(str,l_no_of_decimal);
		//str = put_comma(str,l_no_of_decimal);
    }
	
	return str;
}

/*--------- OVER -------------*/


get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  
 	   
	   :nd_loc_date := sm_convert_datetime_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id);  
		
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_datet\
ime_2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_id \
) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )380;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )132;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )132;
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

