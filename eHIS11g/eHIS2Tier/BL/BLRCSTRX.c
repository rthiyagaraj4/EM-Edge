
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRCSTRX.pc"
};


static unsigned int sqlctx = 1288467515;


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
            void  *sqhstv[29];
   unsigned int   sqhstl[29];
            int   sqhsts[29];
            void  *sqindv[29];
            int   sqinds[29];
   unsigned int   sqharm[29];
   unsigned int   *sqharc[29];
   unsigned short  sqadto[29];
   unsigned short  sqtdso[29];
} sqlstm = {12,29};

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
"select CASH_COUNTER_CODE ,SHIFT_ID ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,(CASH_AM\
OUNT+CREDIT_AMOUNT) TOTAL_AMOUNT ,COLLECT_AMOUNT ,DECODE(DOC_TYPE_CODE,'','',(\
(DOC_TYPE_CODE||'/')||DOC_NUM)) CASH_CTRL_RCPT ,TO_CHAR(CASH_CTRL_DOC_DATE,'DD\
/MM/YYYY')  from BL_CASH_CTRL_RCPT_HDR_VW where (((CASH_COUNTER_CODE between D\
ECODE(:b0,'LOWEST','!!',:b0) and DECODE(:b2,'HIGHEST','~~',:b2) and DOC_DATE b\
etween TO_DATE(:b4,'DD/MM/YYYY') and TO_DATE(:b5,'DD/MM/YYYY')) and CASH_COUNT\
ER_FACILITY_ID=:b6) and ((DOC_TYPE_CODE is null  and :b7='U') or (DOC_TYPE_COD\
E is  not null  and :b7='R'))) order by CASH_COUNTER_CODE,DOC_DATE,SHIFT_ID   \
         ";

 static const char *sq0007 = 
"DESC ,B.SLMT_DOC_REMARKS ,SUBSTR(B.NARRATION,1,40) ,DECODE(IP_ADM_TRF_DEP_IN\
D,'A','Admission Depoist','T','Transfer Deposit','O','Other Deposit','S','Depo\
sit Against Surgery','K','Patient Deposit Against Package','N','Not Applicable\
') ,B.PATIENT_ID ,B.EPISODE_TYPE ,LTRIM(TO_CHAR(B.EPISODE_ID,'00000009')) ,B.V\
ISIT_ID ,Decode(Nvl(CANCELLED_IND,'N'),'Y','B','A') CHK ,DECODE(CANCELLED_IND,\
'Y','CANCEL','')  from BL_RECEIPT_REFUND_HDRDTL_VW B ,BL_BILL_HDR A where ((((\
((B.CASH_COUNTER_FACILITY_ID=:b0 and A.OPERATING_FACILITY_ID(+)=B.OPERATING_FA\
CILITY_ID) and A.DOC_TYPE_CODE(+)=B.BILL_DOC_TYPE_CODE) and A.DOC_NUM(+)=B.BIL\
L_DOC_NUMBER) and B.DOC_DATE between to_date(:b1,'dd/mm/yyyy') and to_date(:b2\
,'dd/mm/yyyy')) and B.CASH_COUNTER_CODE between DECODE(:b3,'LOWEST','!!',:b3) \
and DECODE(:b5,'HIGHEST','~~',:b5)) and ((B.CASH_CTRL_DOC_TYPE_CODE is null  a\
nd :b7='U') or (B.CASH_CTRL_DOC_TYPE_CODE is  not null  and :b7='R'))) order b\
y 1,2,3,6            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,91,0,2,189,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,193,0,0,0,0,0,1,0,
43,0,0,0,0,0,27,206,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,222,0,4,244,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,1,9,0,0,
125,0,0,5,135,0,4,280,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
156,0,0,6,631,0,9,457,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
207,0,0,6,0,0,13,476,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,
0,0,2,9,0,0,
250,0,0,6,0,0,15,500,0,0,0,0,0,1,0,
265,0,0,8,107,0,4,672,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
292,0,0,9,182,0,4,692,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
323,0,0,10,515,0,6,709,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
350,0,0,7,1979,0,9,742,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
401,0,0,7,0,0,13,807,0,0,29,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
532,0,0,7,0,0,15,873,0,0,0,0,0,1,0,
547,0,0,11,96,0,4,1154,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
570,0,0,12,165,0,6,1161,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRCSTRX.PC                                  */
/* AUTHOR                : RAJANISH NAMBIAR                             */
/* DATE WRITTEN          : 05/04/2003                                   */
/* CALLED FROM           : BLRCSTRX.fmb                                 */
/************************************************************************/

#include <stdio.h>
#include <string.h>  
#include <bl.h>    

#define OERROR          (sqlca.sqlcode < 0)
#define NODATA_FOUND    (sqlca.sqlcode == 1403) 
#define NOT_FOUND       (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY   (sqlca.sqlcode == -54)
#define DUPLICATE_KEY   (sqlca.sqlcode == -1)
#define ROW_COUNT       (sqlca.sqlerrd[2]) 
#define MAX_LINES  42
#define ESC     0x1B   


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                   [120],
            date_time                   [20],
            user_id                     [91],
            nd_pwd                      [91],
            nd_session_id               [16],
            nd_pgm_date                 [25],
            d_curr_pgm_name             [15],
			
            nd_facility_id              [3],
            nd_fm_date                  [12],
            nd_to_date                  [12],
            nd_fm_cashcounter           [9],
            nd_to_cashcounter           [9],
            nd_trans_type               [2],
            nd_rpt_type                 [2],
            
        	cv_cash_counter_code        [3],	
            cv_shift_id                 [2],	
			cv_doc_date                 [12],
			cv_cash_ctrl_rcpt           [12],
			cv_rcpt_refund_ind          [2],
			cv_long_rr					[17],
            cv_cash_ctrl_doc_code       [16],
            cv_cash_ctrl_doc_date       [17],
            cv_debt_cat_code            [2],   
			cv_ln_debt_cat_code         [100],
			cv_doc_type_code			[7],
			cv_doc_number				[9],
			cv_doc_srno					[3],
			cv_recpt_nature_code		[3],
			cv_ln_recpt_nature_code		[15],
			cv_recpt_type_code			[3],
			cv_trx_date					[17],
			cv_bill_doc_type_code_num	[16],
			cv_cancel_yn				[7],
			cv_slmt_type_code			[3],
			cv_slmt_doc_ref_desc		[21],
			cv_slmt_doc_remarks			[31],
			cv_narration				[41],
			cv_dep_ind					[32],
			cv_patient_id               [21],
			cv_episode_type				[2],
			cv_episode_id               [9],
			cv_visit_id					[5],
						
			cv_cash_cnt_nm				[31],
			cv_patient_name				[31],
			cv_patient_name1			[31],
			cv_patient_name_loc_lang	[31],
                  d_short_name_full             [61],
			cv_chk						[2],			
			
			p_cc                        [3],
            p_sh                        [2],
	        p_rr                        [2],
	        p_dc                        [100],
			p_dd						[12],
			prv_cash_counter_code       [3],
			l_pk_value					[100],
			p_language_id				[3],
			l_translated_value			[201]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_cashcounter;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cashcounter;

struct { unsigned short len; unsigned char arr[2]; } nd_trans_type;

struct { unsigned short len; unsigned char arr[2]; } nd_rpt_type;

struct { unsigned short len; unsigned char arr[3]; } cv_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } cv_shift_id;

struct { unsigned short len; unsigned char arr[12]; } cv_doc_date;

struct { unsigned short len; unsigned char arr[12]; } cv_cash_ctrl_rcpt;

struct { unsigned short len; unsigned char arr[2]; } cv_rcpt_refund_ind;

struct { unsigned short len; unsigned char arr[17]; } cv_long_rr;

struct { unsigned short len; unsigned char arr[16]; } cv_cash_ctrl_doc_code;

struct { unsigned short len; unsigned char arr[17]; } cv_cash_ctrl_doc_date;

struct { unsigned short len; unsigned char arr[2]; } cv_debt_cat_code;

struct { unsigned short len; unsigned char arr[100]; } cv_ln_debt_cat_code;

struct { unsigned short len; unsigned char arr[7]; } cv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } cv_doc_number;

struct { unsigned short len; unsigned char arr[3]; } cv_doc_srno;

struct { unsigned short len; unsigned char arr[3]; } cv_recpt_nature_code;

struct { unsigned short len; unsigned char arr[15]; } cv_ln_recpt_nature_code;

struct { unsigned short len; unsigned char arr[3]; } cv_recpt_type_code;

struct { unsigned short len; unsigned char arr[17]; } cv_trx_date;

struct { unsigned short len; unsigned char arr[16]; } cv_bill_doc_type_code_num;

struct { unsigned short len; unsigned char arr[7]; } cv_cancel_yn;

struct { unsigned short len; unsigned char arr[3]; } cv_slmt_type_code;

struct { unsigned short len; unsigned char arr[21]; } cv_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[31]; } cv_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[41]; } cv_narration;

struct { unsigned short len; unsigned char arr[32]; } cv_dep_ind;

struct { unsigned short len; unsigned char arr[21]; } cv_patient_id;

struct { unsigned short len; unsigned char arr[2]; } cv_episode_type;

struct { unsigned short len; unsigned char arr[9]; } cv_episode_id;

struct { unsigned short len; unsigned char arr[5]; } cv_visit_id;

struct { unsigned short len; unsigned char arr[31]; } cv_cash_cnt_nm;

struct { unsigned short len; unsigned char arr[31]; } cv_patient_name;

struct { unsigned short len; unsigned char arr[31]; } cv_patient_name1;

struct { unsigned short len; unsigned char arr[31]; } cv_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[2]; } cv_chk;

struct { unsigned short len; unsigned char arr[3]; } p_cc;

struct { unsigned short len; unsigned char arr[2]; } p_sh;

struct { unsigned short len; unsigned char arr[2]; } p_rr;

struct { unsigned short len; unsigned char arr[100]; } p_dc;

struct { unsigned short len; unsigned char arr[12]; } p_dd;

struct { unsigned short len; unsigned char arr[3]; } prv_cash_counter_code;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;



     double cv_total_amount				=	0,
            cv_collect_amount           =	0,
	        sb_total_amount				=	0,
            sb_collect_amount           =	0,
	        gr_total_amount				=	0,
            gr_collect_amount           =	0,
			cv_doc_amt					=   0,

			t_dc						=   0,
			t_rr						=	0,
			t_vd						=	0,
			t_sh						=	0,
			t_cc						=	0,
			g_tt						=	0;

char f_total_amount[17],
     f_collect_amount[17],
	 f_sb_total_amount[17],
     f_sb_collect_amount[17],
	 f_gr_total_amount[17],
     f_gr_collect_amount[17];

	int i;
	
	char g_facility_id[3];

    char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];
	char string_var[200];


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

int i     = 0,
    lctr  = 0,
    pctr  = 0,
    first = 1;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 4)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
	
    strcpy(g_pgm_id,"BLRCSTRX");
    strcpy(nd_pwd.arr,argv[1]);
	nd_pwd.len = strlen(nd_pwd.arr);
	
	conn_sql();
	 
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

    strcpy(g_facility_id,argv[4]);
    strcpy(nd_facility_id.arr,argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);

    fetch_legend_value();

	fetch_prog_param(); fetch_hosp_name();

    open_file();
		
    if(strcmp(nd_rpt_type.arr,"D")==0) 
    {
		detail();
    }
    else
    {
		summary();
	}

    fprintf(fp,"*****   End of Report   *****");
	fprintf(fp,"%cE",ESC); fclose(fp);
	
	/* EXEC SQL DELETE FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRCSTRX'
                AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRCSTRX' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[1] = (unsigned int  )27;
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


	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )28;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	if (OERROR)
	  {
		err_mesg("COMMIT WORK RELEASE failed",0,"");
	  }

}

/*	****************************	Sub Programs	****************************	*/

conn_sql()
{
	/* EXEC sql connect :nd_pwd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )10;
 sqlstm.offset = (unsigned int  )43;
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
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRCSTRX.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRCSTRX.lis");
       proc_exit();
    }
}

fetch_prog_param()
{
	nd_fm_cashcounter.arr[0]	= '\0';
	nd_to_cashcounter.arr[0]	= '\0';
	nd_fm_date.arr[0]			= '\0';
    nd_to_date.arr[0]			= '\0';
    nd_trans_type.arr[0]		= '\0';
	nd_rpt_type.arr[0]			= '\0';
	nd_facility_id.arr[0]		= '\0';	
			
   	nd_fm_cashcounter.len		= 0;
	nd_to_cashcounter.len		= 0;
	nd_fm_date.len				= 0;
	nd_to_date.len				= 0;
	nd_trans_type.len			= 0;
	nd_rpt_type.len				= 0;
	nd_facility_id.len			= 0;
 
    /* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,PARAM2,NVL(PARAM3,'LOWEST'),NVL(PARAM4,'HIGHEST'),
					PARAM5,PARAM6
               INTO :nd_facility_id,:nd_fm_date,:nd_to_date,
					:nd_fm_cashcounter,:nd_to_cashcounter,
					:nd_trans_type,:nd_rpt_type
               FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRCSTRX'
			    AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,NVL(PARAM3,\
'LOWEST') ,NVL(PARAM4,'HIGHEST') ,PARAM5 ,PARAM6 into :b0,:b1,:b2,:b3,:b4,:b5,\
:b6  from SY_PROG_PARAM where ((PGM_ID='BLRCSTRX' and SESSION_ID=:b7) and PGM_\
DATE=:b8)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )74;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqhstl[1] = (unsigned int  )14;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_cashcounter;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_cashcounter;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_trans_type;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_rpt_type;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[7] = (unsigned int  )18;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[8] = (unsigned int  )27;
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
		err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

	if (NODATA_FOUND)
	    err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_fm_cashcounter.arr[nd_fm_cashcounter.len]	= '\0';
	nd_to_cashcounter.arr[nd_to_cashcounter.len]	= '\0';
    nd_fm_date.arr[nd_fm_date.len]		        	= '\0';
    nd_to_date.arr[nd_to_date.len]			        = '\0';
    nd_trans_type.arr[nd_trans_type.len]		    = '\0';
    nd_rpt_type.arr[nd_rpt_type.len]		        = '\0';
	nd_facility_id.arr[nd_facility_id.len]		    = '\0';
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT UPPER(ACC_ENTITY_NAME), TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY
			  WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select UPPER(ACC_ENTITY_NAME) ,TO_CHAR(SYSDATE,'DD/MM/YYY\
Y HH24:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )125;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	user_id.arr[user_id.len]               = '\0';
}

/***	*************************Start of Summary*************************   */

summary()
{	
	print_sum_title(); print_sum_head();	
	dec_sel_sum_cur(); open_sel_sum_cur();
	get_sum_val(); close_sel_sum_cur();
	horz_skip(50); fflush(fp);
}

print_sum_title()
{
	fprintf(fp,"%c&l1O",ESC); fprintf(fp,"%c&k4S",ESC);
	common_sum_head();
	fprintf(fp,"VER : 2.10.01\n");
	fprintf(fp,"\n\n\n"); horz_skip(35); 
	fprintf(fp,"INPUT PARAMETERS :"); 
	fprintf(fp,"\n"); horz_skip(35); 
	fprintf(fp,"----------------"); 
	fprintf(fp,"\n\n");horz_skip(50);
	fprintf(fp,"%11s            %4s : %-11.11s",loc_legend[80],loc_legend[60],nd_fm_date.arr);
 	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"                         %2s : %-11.11s",loc_legend[70],nd_to_date.arr);
	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"%12s           %4s : %-9.9s",loc_legend[90],loc_legend[60],nd_fm_cashcounter.arr);
	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"                         %2s : %-9.9s",loc_legend[70],nd_to_cashcounter.arr);
	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"%12s                : ",loc_legend[400]);
	if (strcmp(nd_trans_type.arr,"R")==0)
	{
		fprintf(fp,"%6s",loc_legend[100]);
	}
	else
	{
		fprintf(fp,"%8s",loc_legend[110]);		
	}
	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"%11s                 : ",loc_legend[390]);
	if (strcmp(nd_rpt_type.arr,"D")==0)
	{
		fprintf(fp,"%6s ",loc_legend[120]);
	}
	else
	{
		fprintf(fp,"%7s ",loc_legend[410]);		
	}
	fprintf(fp,"\n"); fprintf(fp,"\f");
}

print_sum_head()
{
	common_sum_head();
	fprintf(fp,"%12s",loc_legend[90]); horz_skip(5);
	fprintf(fp,"%5s",loc_legend[430]); horz_skip(5);
	fprintf(fp,"%-10.10s",loc_legend[420]); horz_skip(3);
	fprintf(fp,"  %14.14s",loc_legend[440]); horz_skip(5);
	fprintf(fp,"%16.16s",loc_legend[450]); horz_skip(5);
	fprintf(fp,"%20.20s",loc_legend[460]); horz_skip(5);
	fprintf(fp,"%20.20s %-10.10s",loc_legend[460],loc_legend[420]); next_sum_line(); dot_line();
}

get_sum_val()
{
	prv_cash_counter_code.arr[0]='\0';
	prv_cash_counter_code.len=0;

	while (fetch_sel_sum_cur())
	{
	    /*sprintf(string_var,"%d %f %ld",cv_total_amount,cv_total_amount,cv_total_amount);
	    disp_message(ERR_MESG,string_var);*/

		if (strcmp(prv_cash_counter_code.arr,cv_cash_counter_code.arr)!=0)
		{	
			if (first ==1)
			{
				first = 0; print_sum_val();
			}
			else
			{
				print_sub_tot(); print_sum_val(); 
			}
		}	
		else
		{
			print_sum_val(); 
		}
		strcpy(prv_cash_counter_code.arr,cv_cash_counter_code.arr);
	}
	print_grd_tot();
}

cum_sub_tot()
{
	sb_total_amount		=	sb_total_amount   + cv_total_amount;
	sb_collect_amount   =   sb_collect_amount + cv_collect_amount;
}

cum_grp_tot()
{	
	gr_total_amount		=	gr_total_amount   + sb_total_amount;
    gr_collect_amount   =   gr_collect_amount + sb_collect_amount;
}

reset_sub_tot()
{
	sb_total_amount		=	0; sb_collect_amount	=	0;	
}

print_sum_val()
{
	fprintf(fp,"%-12.12s",cv_cash_counter_code.arr); horz_skip(5);
	fprintf(fp,"%-5.5s",cv_shift_id.arr); horz_skip(5);
	fprintf(fp,"%-10.10s",cv_doc_date.arr); horz_skip(3);
	print_formated(f_total_amount,cv_total_amount);
	fprintf(fp,"%17s",f_total_amount); horz_skip(5);
	print_formated(f_collect_amount,cv_collect_amount);
	fprintf(fp,"%17s",f_collect_amount); horz_skip(5);
	fprintf(fp,"%-20.20s",cv_cash_ctrl_rcpt.arr); horz_skip(5);
	fprintf(fp,"%-25.25s",cv_cash_ctrl_doc_date.arr);
	cum_sub_tot(); next_sum_line();
}

print_sub_tot()
{
	check_sum_line(1); dot_line(); 
	fprintf(fp,"%10.10s :",loc_legend[330]); horz_skip(3);
	print_formated(f_sb_total_amount,sb_total_amount); 
	fprintf(fp,"%17s",f_sb_total_amount);horz_skip(5);
	print_formated(f_sb_collect_amount,sb_collect_amount);
	fprintf(fp,"%17s",f_sb_collect_amount);horz_skip(5);
	cum_grp_tot(); reset_sub_tot();
	next_sum_line(); dot_line(); 
}

print_grd_tot()
{
	print_sub_tot(); check_sum_line(1);
	fprintf(fp,"%12.12s :",loc_legend[320]); horz_skip(3);
	print_formated(f_gr_total_amount,gr_total_amount);
	fprintf(fp,"%17s",f_gr_total_amount);horz_skip(5);
	print_formated(f_gr_collect_amount,gr_collect_amount); 
	fprintf(fp,"%17s",f_gr_total_amount);horz_skip(5);
	next_sum_line(); dot_line();
}

dec_sel_sum_cur()
{
	/* EXEC SQL DECLARE SEL_SUM_CUR CURSOR FOR 
		SELECT CASH_COUNTER_CODE, SHIFT_ID, TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
               CASH_AMOUNT+CREDIT_AMOUNT TOTAL_AMOUNT, COLLECT_AMOUNT,
               DECODE(DOC_TYPE_CODE,'','',DOC_TYPE_CODE||'/'||DOC_NUM) CASH_CTRL_RCPT,
               TO_CHAR(CASH_CTRL_DOC_DATE,'DD/MM/YYYY')
          FROM BL_CASH_CTRL_RCPT_HDR_VW
         WHERE CASH_COUNTER_CODE BETWEEN DECODE(:nd_fm_cashcounter,'LOWEST','!!',:nd_fm_cashcounter) 
									 AND DECODE(:nd_to_cashcounter,'HIGHEST','~~',:nd_to_cashcounter)
		   AND DOC_DATE BETWEEN TO_DATE(:nd_fm_date,'DD/MM/YYYY') AND TO_DATE(:nd_to_date,'DD/MM/YYYY')
           AND CASH_COUNTER_FACILITY_ID = :nd_facility_id
           AND ((DOC_TYPE_CODE IS NULL AND :nd_trans_type='U') OR (DOC_TYPE_CODE IS NOT NULL AND :nd_trans_type='R'))
      ORDER BY CASH_COUNTER_CODE,DOC_DATE,SHIFT_ID; */ 

}

open_sel_sum_cur()

{
    /* EXEC SQL OPEN SEL_SUM_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )156;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_cashcounter;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_cashcounter;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_cashcounter;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_cashcounter;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[4] = (unsigned int  )14;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[5] = (unsigned int  )14;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_trans_type;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_trans_type;
    sqlstm.sqhstl[8] = (unsigned int  )4;
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
         err_mesg("OPEN failed on cursor SEL_SUM_CUR",0,"");
}

fetch_sel_sum_cur()
{
    cv_cash_counter_code.arr[0]	    = '\0';
	cv_shift_id.arr[0]				= '\0'; 
	cv_doc_date.arr[0]				= '\0'; 
	cv_cash_ctrl_rcpt.arr[0]		= '\0';  
	cv_cash_ctrl_doc_date.arr[0]	= '\0';  
		 			  
    cv_cash_counter_code.len		= 0; 
	cv_shift_id.len			        = 0; 
	cv_doc_date.len			        = 0;
    cv_cash_ctrl_rcpt.len			= 0; 
	cv_cash_ctrl_doc_date.len		= 0; 

/* EXEC SQL FETCH SEL_SUM_CUR INTO	:cv_cash_counter_code,
									:cv_shift_id,
									:cv_doc_date,
									:cv_total_amount,
									:cv_collect_amount,
									:cv_cash_ctrl_rcpt,
									:cv_cash_ctrl_doc_date; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 9;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )207;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqfoff = (           int )0;
sqlstm.sqfmod = (unsigned int )2;
sqlstm.sqhstv[0] = (         void  *)&cv_cash_counter_code;
sqlstm.sqhstl[0] = (unsigned int  )5;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&cv_shift_id;
sqlstm.sqhstl[1] = (unsigned int  )4;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&cv_doc_date;
sqlstm.sqhstl[2] = (unsigned int  )14;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&cv_total_amount;
sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&cv_collect_amount;
sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&cv_cash_ctrl_rcpt;
sqlstm.sqhstl[5] = (unsigned int  )14;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&cv_cash_ctrl_doc_date;
sqlstm.sqhstl[6] = (unsigned int  )19;
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

	
		
    cv_cash_counter_code.arr[cv_cash_counter_code.len]	= '\0';
	cv_shift_id.arr[cv_shift_id.len]					= '\0'; 
	cv_doc_date.arr[cv_doc_date.len	]					= '\0'; 
	cv_cash_ctrl_rcpt.arr[cv_cash_ctrl_rcpt.len]		= '\0';  
	cv_cash_ctrl_doc_date.arr[cv_cash_ctrl_doc_date.len]= '\0';
      				 
	if (OERROR)
	{
		err_mesg("FETCH failed on cursor SEL_SUM_CUR",0,"");
	}
    return(NODATA_FOUND?0:1);
	
}

close_sel_sum_cur()
{
    /* EXEC SQL CLOSE SEL_SUM_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )250;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("CLOSE failed on cursor SEL_SUM_CUR",0,"");
}

dot_line()
{
	for(i=0;i<132;i++)fprintf(fp,"-"); next_sum_line();
}

check_sum_line(skip) /* will check for MAX LINE before printing totals */
int skip;
{
	if ((lctr + skip) > (MAX_LINES-1))
	{
		next_sum_page(); 
	}
}

next_sum_line() /* will check for MAX LINE before printing totals */		
{
	if (lctr > (MAX_LINES-1))
	{
		next_sum_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; // fprintf(fp,"%2d",lctr);
	}
}

next_sum_page() /* will move the cursor to next page */
{
	fprintf(fp,"\f");  print_sum_head(); 	
}

common_sum_head()
{
	lctr = 1; fprintf(fp,"\n"); fprintf(fp,"MDL : %2s",loc_legend[150]);	horz_skip(45);
	fprintf(fp,"%-30.30s",hosp_name.arr); horz_skip(33);
	fprintf(fp,"%-16s",date_time.arr); next_sum_line();
	fprintf(fp,"OPR : %-10s", user_id.arr); next_sum_line();
	fprintf(fp,"REP : %-8s",loc_legend[40]); horz_skip(31);
	fprintf(fp,"%25.25s ",loc_legend[50]);
	if (strcmp(nd_trans_type.arr,"R")==0)
	{
		fprintf(fp,"%-8.8s",loc_legend[100]);
	}
	else
	{
		fprintf(fp,"%-8.8s",loc_legend[110]);		
	}
	fprintf(fp," - %-7.7s",loc_legend[410]); horz_skip(32);
	fprintf(fp,"%4s : %4d",loc_legend[30],++pctr); next_sum_line(); dot_line();
}
/***	*************************End of Summary*************************   */

detail()
{
	print_title(); print_head();
	dec_sel_cur(); open_sel_cur();
    get_val(); close_sel_cur(); 
	horz_skip(83); fflush(fp); 
}

print_title()
{
	fprintf(fp,"%c&l1O",ESC); fprintf(fp,"%c&k2S",ESC); common_head();
	fprintf(fp,"VER : 2.10.01\n");
	fprintf(fp,"\n\n\n"); horz_skip(35); 
	fprintf(fp,"INPUT PARAMETERS :"); 
	fprintf(fp,"\n"); horz_skip(35); 
	fprintf(fp,"----------------"); 
	fprintf(fp,"\n\n");horz_skip(50);
	fprintf(fp,"%11s            %4s : %-11.11s",loc_legend[80],loc_legend[60],nd_fm_date.arr);
 	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"                         %2s : %-11.11s",loc_legend[70],nd_to_date.arr);
	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"%12s           %4s : %-9.9s",loc_legend[90],loc_legend[60],nd_fm_cashcounter.arr);
	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"                         %2s : %-9.9s",loc_legend[70],nd_to_cashcounter.arr);
	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"%12s                : ",loc_legend[400]);
	if (strcmp(nd_trans_type.arr,"R")==0)
	{
		fprintf(fp,"%6s",loc_legend[100]);
	}
	else
	{
		fprintf(fp,"%8s",loc_legend[110]);		
	}
	fprintf(fp,"\n\n"); horz_skip(50);
	fprintf(fp,"%11s                 : ",loc_legend[390]);
	fprintf(fp,"%6s ",loc_legend[120]); next_line();
	fprintf(fp,"\f");
}

print_head()
{
	common_head();
	fprintf(fp,"%-15.15s",160); horz_skip(11);
	fprintf(fp,"%-17.17s",loc_legend[170]); horz_skip(11);
	fprintf(fp,"%-8.8s",loc_legend[180]); horz_skip(11);
	fprintf(fp,"%-16.16s",loc_legend[190]); horz_skip(11);
	fprintf(fp,"%-15.15s",loc_legend[200]); horz_skip(11);
	fprintf(fp,"%16.16s",loc_legend[210]); horz_skip(9);
	fprintf(fp,"%-6.6s",loc_legend[220]); horz_skip(11);
	fprintf(fp,"%-20.20s",loc_legend[230]); next_line();

	fprintf(fp,"%-15.15s",loc_legend[270]); horz_skip(11);
	fprintf(fp,"%-14.14s",loc_legend[280]); horz_skip(14);
	fprintf(fp,"%-30.30s",loc_legend[290]); horz_skip(16);
	fprintf(fp,"%-40.40s",loc_legend[250]); horz_skip(11);
	fprintf(fp,"%-11.11s",loc_legend[260]); next_line();
	dash_line(); fflush(fp);
}

dec_sel_cur()
{
   /* EXEC SQL DECLARE SEL_CUR CURSOR FOR 
   SELECT B.CASH_COUNTER_CODE ,TO_CHAR(B.DOC_DATE,'DD/MM/YYYY') ,B.SHIFT_ID, 
			B.RECPT_REFUND_IND, DECODE(B.RECPT_REFUND_IND,'R','Receipts','Payments / Refunds'),
			DECODE(B.CASH_CTRL_DOC_TYPE_CODE,'','',B.CASH_CTRL_DOC_TYPE_CODE||'/'||LTRIM(TO_CHAR(B.CASH_CTRL_DOC_NUMBER,'00000009'))) CCDTC,
			TO_CHAR(B.CASH_CTRL_DOC_DATE ,'DD/MM/YYYY HH24:MI'),
			DEBTOR_CATEGORY_CODE, 
			DECODE(DEBTOR_CATEGORY_CODE,'I','Inpatients',
			                            'D','Daycare',
			                            'O','Outpatients',
						    'E','Emergency',
						    'R','Referal Patients',
						    'Miscellaneous (Deferred cash patients, Customers, Others)'),
             B.DOC_TYPE_CODE, LTRIM(TO_CHAR(B.DOC_NUMBER,'00000009')),B.DOC_SRNO,
             B.RECPT_NATURE_CODE,DECODE(B.RECPT_NATURE_CODE,'AD','Adjustable Dep ',
					                  'RD','Refundable Dep ',
					                  'PR','Prepayments',
					                  'MI','Miscellaneous',
					                  'DC','Def. Cash Pat.',
					                  'BI','Against Bill',
					                  'CU','Customers'),
              B.RECPT_TYPE_CODE,TO_CHAR(B.TRX_DATE_TIME,'DD/MM/YYYY HH24:MI'),
              DECODE(BILL_DOC_TYPE_CODE,'','',BILL_DOC_TYPE_CODE||'/'||LTRIM(TO_CHAR(BILL_DOC_NUMBER,'00000009'))) ,              
			  B.DOC_AMT, B.SLMT_TYPE_CODE, B.SLMT_DOC_REF_DESC,
			  B.SLMT_DOC_REMARKS, SUBSTR(B.NARRATION,1,40),
			  DECODE(IP_ADM_TRF_DEP_IND,'A','Admission Depoist'
                                       ,'T','Transfer Deposit'
                                       ,'O','Other Deposit'
									   ,'S','Deposit Against Surgery'
                        			   ,'K','Patient Deposit Against Package'
									   ,'N','Not Applicable'),
			  B.PATIENT_ID, B.EPISODE_TYPE,LTRIM(TO_CHAR(B.EPISODE_ID,'00000009')),B.VISIT_ID,
			  Decode(Nvl(CANCELLED_IND,'N'),'Y','B','A') CHK, DECODE(CANCELLED_IND,'Y','CANCEL','')

		 FROM BL_RECEIPT_REFUND_HDRDTL_VW B, BL_BILL_HDR  A   

		WHERE B.CASH_COUNTER_FACILITY_ID = :nd_facility_id
		  AND A.OPERATING_FACILITY_ID(+) = B.OPERATING_FACILITY_ID
          AND A.DOC_TYPE_CODE(+) = B.BILL_DOC_TYPE_CODE
          AND A.DOC_NUM(+)= B.BILL_DOC_NUMBER
		  
		  AND B.DOC_DATE BETWEEN to_date(:nd_fm_date,'dd/mm/yyyy') AND to_date(:nd_to_date,'dd/mm/yyyy')
 		  AND B.CASH_COUNTER_CODE BETWEEN DECODE(:nd_fm_cashcounter,'LOWEST','!!',:nd_fm_cashcounter) 
									AND DECODE(:nd_to_cashcounter,'HIGHEST','~~',:nd_to_cashcounter)
		  AND ((B.CASH_CTRL_DOC_TYPE_CODE IS NULL AND :nd_trans_type = 'U') OR 
		       (B.CASH_CTRL_DOC_TYPE_CODE IS NOT NULL AND :nd_trans_type = 'R'))
	 ORDER BY 1,2,3,6; */ 

}

get_cash_cntr_nm()
{
	cv_cash_cnt_nm.arr[0]	= '\0';
    cv_cash_cnt_nm.len		= 0;

	/* EXEC SQL 
	SELECT LONG_DESC 
	  INTO :cv_cash_cnt_nm
	  FROM BL_CASH_COUNTER
	 WHERE CASH_COUNTER_CODE = :cv_cash_counter_code
	   AND OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from BL_CASH_COUNTER where (CASH_\
COUNTER_CODE=:b1 and OPERATING_FACILITY_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )265;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cv_cash_cnt_nm;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cv_cash_counter_code;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
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



    if(OERROR)
        err_mesg("SELECTION failed on cursor CASH_COUNTER_CUR",0,"");
	  
	cv_cash_cnt_nm.arr[cv_cash_cnt_nm.len]  = '\0';
}

get_patient_name()
{
	cv_patient_name.arr[0]			 = '\0';
	cv_patient_name1.arr[0]			 = '\0';
    cv_patient_name.len				 = 0;
	cv_patient_name1.len				 = 0;

	/* EXEC SQL 
		SELECT substr(SHORT_NAME,1,30),
			   decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
                     short_name
	      INTO cv_patient_name,
		       cv_patient_name1,
                   d_short_name_full
		  FROM MP_PATIENT_MAST
	     WHERE PATIENT_ID = :cv_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select substr(SHORT_NAME,1,30) ,decode(substr(short_name,31,\
60),null ,' ',substr(short_name,31,60)) shortname1 ,short_name into :b0,:b1,:b\
2  from MP_PATIENT_MAST where PATIENT_ID=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )292;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cv_patient_name;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cv_patient_name1;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_short_name_full;
 sqlstm.sqhstl[2] = (unsigned int  )63;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&cv_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )23;
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



    if(OERROR)
	err_mesg("SELECTION failed on table MP_PATIENT_MAST_CUR",0,"");

    cv_patient_name.arr[cv_patient_name.len]  = '\0';
	cv_patient_name1.arr[cv_patient_name1.len]  = '\0';
     d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
/* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :cv_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :cv_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :cv_patient_name1    := :cv_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 9;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :cv_patient_name := str2 ; END IF ; blcommon . s\
plit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NO\
T NULL THEN :cv_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d_s\
hort_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :cv_p\
atient_name1 := :cv_patient_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )323;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )63;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&cv_patient_name;
sqlstm.sqhstl[1] = (unsigned int  )33;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&cv_patient_name1;
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


       cv_patient_name.arr[cv_patient_name.len]  = '\0';
       cv_patient_name1.arr[cv_patient_name1.len]  = '\0';
}

open_sel_cur()
{
   /* EXEC SQL OPEN SEL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select B.CASH_COUNTER_CODE ,TO_CHAR(B.DOC_DATE,'DD/MM/YYYY') ,B.SHIFT_\
ID ,B.RECPT_REFUND_IND ,DECODE(B.RECPT_REFUND_IND,'R','Receipts','Payments /\
 Refunds') ,DECODE(B.CASH_CTRL_DOC_TYPE_CODE,'','',((B.CASH_CTRL_DOC_TYPE_CO\
DE||'/')||LTRIM(TO_CHAR(B.CASH_CTRL_DOC_NUMBER,'00000009')))) CCDTC ,TO_CHAR\
(B.CASH_CTRL_DOC_DATE,'DD/MM/YYYY HH24:MI') ,DEBTOR_CATEGORY_CODE ,DECODE(DE\
BTOR_CATEGORY_CODE,'I','Inpatients','D','Daycare','O','Outpatients','E','Eme\
rgency','R','Referal Patients','Miscellaneous (Deferred cash patients, Custo\
mers, Others)') ,B.DOC_TYPE_CODE ,LTRIM(TO_CHAR(B.DOC_NUMBER,'00000009')) ,B\
.DOC_SRNO ,B.RECPT_NATURE_CODE ,DECODE(B.RECPT_NATURE_CODE,'AD','Adjustable \
Dep ','RD','Refundable Dep ','PR','Prepayments','MI','Miscellaneous','DC','D\
ef. Cash Pat.','BI','Against Bill','CU','Customers') ,B.RECPT_TYPE_CODE ,TO_\
CHAR(B.TRX_DATE_TIME,'DD/MM/YYYY HH24:MI') ,DECODE(BILL_DOC_TYPE_CODE,'','',\
((BILL_DOC_TYPE_CODE||'/')||LTRIM(TO_CHAR(BILL_DOC_NUMBER,'00000009')))) ,B.\
DOC_AMT ,B.SLMT_TYPE_CODE ,B.SLMT_DOC_REF_");
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )350;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_cashcounter;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_cashcounter;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_cashcounter;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_cashcounter;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_trans_type;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_trans_type;
   sqlstm.sqhstl[8] = (unsigned int  )4;
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
   err_mesg("OPEN failed on cursor SEL_CUR",0,"");
}

fetch_sel_cur()
{
	cv_cash_counter_code.arr[0]			= '\0';
	cv_shift_id.arr[0]					= '\0'; 
	cv_rcpt_refund_ind.arr[0]			= '\0';
    cv_debt_cat_code.arr[0]				= '\0';
	cv_ln_debt_cat_code.arr[0]			= '\0';
	cv_doc_date.arr[0]					= '\0';
	cv_long_rr.arr[0]					= '\0';
	cv_doc_type_code.arr[0]				= '\0';
	cv_doc_number.arr[0]				= '\0';
	cv_doc_srno.arr[0]					= '\0';
	cv_recpt_nature_code.arr[0]			= '\0';
	cv_ln_recpt_nature_code.arr[0]		= '\0';
	cv_trx_date.arr[0]					= '\0';
	cv_bill_doc_type_code_num.arr[0]	= '\0';
	cv_slmt_type_code.arr[0]			= '\0';
	cv_slmt_doc_ref_desc.arr[0]			= '\0';
	cv_slmt_doc_remarks.arr[0]			= '\0';
	cv_narration.arr[0]					= '\0';
	cv_dep_ind.arr[0]					= '\0';
	cv_cash_ctrl_doc_code.arr[0]		= '\0';
	cv_cash_ctrl_doc_date.arr[0]		= '\0';
	cv_patient_id.arr[0]				= '\0';
	cv_episode_type.arr[0]				= '\0';
	cv_episode_id.arr[0]				= '\0';
	cv_visit_id.arr[0]					= '\0';
	cv_recpt_type_code.arr[0]			= '\0';
	cv_cancel_yn.arr[0]					= '\0';
	cv_chk.arr[0]						= '\0';
   
 	cv_cash_counter_code.len			= 0; 
	cv_shift_id.len						= 0; 
	cv_rcpt_refund_ind.len				= 0;
	cv_debt_cat_code.len				= 0; 
	cv_ln_debt_cat_code.len			    = 0; 
	cv_doc_date.len						= 0; 
	cv_long_rr.len						= 0; 
	cv_doc_type_code.len				= 0; 
	cv_doc_number.len					= 0; 
	cv_doc_srno.len						= 0;
	cv_recpt_nature_code.len			= 0; 
	cv_ln_recpt_nature_code.len			= 0; 
	cv_trx_date.len						= 0;
	cv_bill_doc_type_code_num.len		= 0;
	cv_patient_id.len					= 0;
	cv_episode_type.len					= 0;
	cv_episode_id.len					= 0;
	cv_visit_id.len						= 0;
	cv_slmt_type_code.len				= 0;
	cv_slmt_doc_ref_desc.len			= 0;
	cv_slmt_doc_remarks.len				= 0;
	cv_narration.len					= 0;
	cv_dep_ind.len						= 0;
	cv_cash_ctrl_doc_code.len			= 0;
	cv_cash_ctrl_doc_date.len			= 0;	
	cv_recpt_type_code.len				= 0;	
	cv_cancel_yn.len					= 0;
	cv_chk.len							= 0;
							    
	/* EXEC SQL FETCH SEL_CUR INTO	:cv_cash_counter_code,
					 	        :cv_doc_date,
								:cv_shift_id,
						        :cv_rcpt_refund_ind,
								:cv_long_rr,
								:cv_cash_ctrl_doc_code,
								:cv_cash_ctrl_doc_date,
								:cv_debt_cat_code,
						        :cv_ln_debt_cat_code,								
								:cv_doc_type_code,
								:cv_doc_number,
								:cv_doc_srno,
								:cv_recpt_nature_code,
								:cv_ln_recpt_nature_code,
								:cv_recpt_type_code,
								:cv_trx_date,
								:cv_bill_doc_type_code_num,
								:cv_doc_amt,
								:cv_slmt_type_code,
								:cv_slmt_doc_ref_desc,
								:cv_slmt_doc_remarks,
								:cv_narration,
								:cv_dep_ind,				
								:cv_patient_id,
								:cv_episode_type,
								:cv_episode_id,
								:cv_visit_id,
								:cv_chk,
								:cv_cancel_yn; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )401;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&cv_cash_counter_code;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cv_doc_date;
 sqlstm.sqhstl[1] = (unsigned int  )14;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&cv_shift_id;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&cv_rcpt_refund_ind;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&cv_long_rr;
 sqlstm.sqhstl[4] = (unsigned int  )19;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&cv_cash_ctrl_doc_code;
 sqlstm.sqhstl[5] = (unsigned int  )18;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&cv_cash_ctrl_doc_date;
 sqlstm.sqhstl[6] = (unsigned int  )19;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&cv_debt_cat_code;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&cv_ln_debt_cat_code;
 sqlstm.sqhstl[8] = (unsigned int  )102;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&cv_doc_type_code;
 sqlstm.sqhstl[9] = (unsigned int  )9;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&cv_doc_number;
 sqlstm.sqhstl[10] = (unsigned int  )11;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&cv_doc_srno;
 sqlstm.sqhstl[11] = (unsigned int  )5;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&cv_recpt_nature_code;
 sqlstm.sqhstl[12] = (unsigned int  )5;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&cv_ln_recpt_nature_code;
 sqlstm.sqhstl[13] = (unsigned int  )17;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&cv_recpt_type_code;
 sqlstm.sqhstl[14] = (unsigned int  )5;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&cv_trx_date;
 sqlstm.sqhstl[15] = (unsigned int  )19;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&cv_bill_doc_type_code_num;
 sqlstm.sqhstl[16] = (unsigned int  )18;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&cv_doc_amt;
 sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&cv_slmt_type_code;
 sqlstm.sqhstl[18] = (unsigned int  )5;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&cv_slmt_doc_ref_desc;
 sqlstm.sqhstl[19] = (unsigned int  )23;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&cv_slmt_doc_remarks;
 sqlstm.sqhstl[20] = (unsigned int  )33;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&cv_narration;
 sqlstm.sqhstl[21] = (unsigned int  )43;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&cv_dep_ind;
 sqlstm.sqhstl[22] = (unsigned int  )34;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&cv_patient_id;
 sqlstm.sqhstl[23] = (unsigned int  )23;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&cv_episode_type;
 sqlstm.sqhstl[24] = (unsigned int  )4;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&cv_episode_id;
 sqlstm.sqhstl[25] = (unsigned int  )11;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&cv_visit_id;
 sqlstm.sqhstl[26] = (unsigned int  )7;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&cv_chk;
 sqlstm.sqhstl[27] = (unsigned int  )4;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&cv_cancel_yn;
 sqlstm.sqhstl[28] = (unsigned int  )9;
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


								
	cv_cash_counter_code.arr[cv_cash_counter_code.len]				= '\0';
	cv_shift_id.arr[cv_shift_id.len]								= '\0'; 
	cv_rcpt_refund_ind.arr[cv_rcpt_refund_ind.len]					= '\0'; 
	cv_debt_cat_code.arr[cv_debt_cat_code.len]						= '\0';  
	cv_ln_debt_cat_code.arr[cv_ln_debt_cat_code.len]				= '\0';
	cv_doc_date.arr[cv_doc_date.len]								= '\0';
	cv_long_rr.arr[cv_long_rr.len]									= '\0';
	cv_doc_type_code.arr[cv_doc_type_code.len]						= '\0';
	cv_doc_number.arr[cv_doc_number.len]							= '\0';
	cv_doc_srno.arr[cv_doc_srno.len]								= '\0';
	cv_recpt_nature_code.arr[cv_recpt_nature_code.len]				= '\0';
	cv_ln_recpt_nature_code.arr[cv_ln_recpt_nature_code.len]		= '\0';
	cv_trx_date.arr[cv_trx_date.len]								= '\0';
	cv_bill_doc_type_code_num.arr[cv_bill_doc_type_code_num.len]	= '\0';
	cv_patient_id.arr[cv_patient_id.len]							= '\0';
	cv_episode_type.arr[cv_episode_type.len]						= '\0';
	cv_episode_id.arr[cv_episode_id.len]							= '\0';
	cv_visit_id.arr[cv_visit_id.len]								= '\0';
	cv_slmt_type_code.arr[cv_slmt_type_code.len]					= '\0';
	cv_slmt_doc_ref_desc.arr[cv_slmt_doc_ref_desc.len]				= '\0';
	cv_slmt_doc_remarks.arr[cv_slmt_doc_remarks.len]				= '\0';
	cv_narration.arr[cv_narration.len]								= '\0';
	cv_dep_ind.arr[cv_dep_ind.len]									= '\0';
	cv_cash_ctrl_doc_code.arr[cv_cash_ctrl_doc_code.len]			= '\0';
	cv_cash_ctrl_doc_date.arr[cv_cash_ctrl_doc_date.len]			= '\0';	
	cv_recpt_type_code.arr[cv_recpt_type_code.len]					= '\0';	
	cv_cancel_yn.arr[cv_cancel_yn.len]								= '\0';	
	cv_chk.arr[cv_chk.len]											= '\0';	
       				
	if (OERROR)
		err_mesg("FETCH failed on cursor SEL_CUR",0,"");
    return(NODATA_FOUND?0:1);
}

close_sel_cur()
{
    /* EXEC SQL CLOSE SEL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )532;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("CLOSE failed on cursor SEL_CUR",0,"");
}

get_val()
{      
    p_cc.arr[0]  ='\0'; p_sh.arr[0]  ='\0';
    p_rr.arr[0]  ='\0'; p_dc.arr[0]  ='\0';   

    p_cc.len=0; p_sh.len=0;
    p_rr.len=0; p_dc.len=0;

    while (fetch_sel_cur())
	{
	  get_cash_cntr_nm(); get_patient_name();
      if(strcmp(p_cc.arr,cv_cash_counter_code.arr)!=0) 
      {
        if(first == 1) 
	    {  
	      first = 0; print_grp_hd();
		  print_sub_grp_hd(); print_val();
	    }
	    else
	    {	  	  
		  print_cash_cntr_tot(); dash_line();
		  t_dc = 0; t_rr = 0; t_vd = 0; t_sh = 0; t_cc = 0;
		  print_grp_hd(); print_sub_grp_hd();  print_val();
		}
	  }
      else if (strcmp(p_dd.arr,cv_doc_date.arr)!=0) 
	  {
		print_shift_tot(); dash_line();
		t_dc = 0; t_rr = 0; t_vd = 0; t_sh = 0;
		print_grp_hd(); print_sub_grp_hd();  print_val();
	  }
      else if (strcmp(p_sh.arr,cv_shift_id.arr)!=0) 
	  {		
		print_shift_tot(); dash_line();
		t_dc = 0; t_rr = 0; t_vd = 0; t_sh = 0;
		print_grp_hd(); print_sub_grp_hd();  print_val();
	  }
	  else if (strcmp(p_rr.arr,cv_rcpt_refund_ind.arr)!=0)
	  {
		print_rcpt_tot(); dash_line();
		t_dc = 0; t_rr = 0; t_vd = 0;
		print_grp_hd(); print_sub_grp_hd(); print_val();
	  }
      else if (strcmp(p_dc.arr,cv_debt_cat_code.arr)!=0) 
	  {
		print_deb_cat_tot(); dash_line();
		t_dc = 0; print_sub_grp_hd(); print_val();
	  }
	  else if (strcmp(p_dc.arr,cv_debt_cat_code.arr)==0)  
      {
	    print_val();
	  }
      strcpy(p_cc.arr, cv_cash_counter_code.arr); 
      strcpy(p_sh.arr, cv_shift_id.arr);
      strcpy(p_rr.arr, cv_rcpt_refund_ind.arr);
      strcpy(p_dc.arr, cv_debt_cat_code.arr);
	  strcpy(p_dd.arr, cv_doc_date.arr);
   }
	print_cash_cntr_tot(); check_line(1); dash_line();
	horz_skip(101); fprintf(fp,"%34.34s : ",loc_legend[470]);
	print_formated_amt(g_tt);
	 next_line(); dash_line();
}

print_grp_hd()
{
	fprintf(fp,"%-12.12s : ",loc_legend[90]);
	fprintf(fp,"%-2.2s",cv_cash_counter_code.arr); horz_skip(1);
	fprintf(fp,"%-30.30s",cv_cash_cnt_nm.arr); horz_skip(8);
	fprintf(fp,"%-8.8s : ",loc_legend[310]);
	fprintf(fp,"%-10.10s",cv_doc_date.arr); horz_skip(9);
	fprintf(fp,"%-13.13s : ",loc_legend[300]);
	fprintf(fp,"%-1.1s",cv_shift_id.arr); horz_skip(9); 
	fprintf(fp,"%-16.16s ",loc_legend[240]);
	fprintf(fp,"%-1.1s",cv_rcpt_refund_ind.arr); horz_skip(1);
	fprintf(fp,"%-16.16s",cv_long_rr.arr);horz_skip(9);
	fprintf(fp,"%-15.15s",cv_cash_ctrl_doc_code.arr);horz_skip(1);
	fprintf(fp,"%-16.16s",cv_cash_ctrl_doc_date.arr); next_line(); next_line();
}

print_cash_cntr_tot()
{
	print_shift_tot();
	horz_skip(101); fprintf(fp,"%22.22s : ",loc_legend[380]);
	print_formated_amt(t_cc ); next_line();
}

print_shift_tot()
{
	print_rcpt_tot();
	horz_skip(101); fprintf(fp,"%22.22s : ",loc_legend[480]);
	print_formated_amt(t_sh); next_line();
}

print_rcpt_tot()
{
	print_deb_cat_tot(); 
	horz_skip(101); fprintf(fp,"%22.22s : ",loc_legend[350]);
	print_formated_amt(t_rr ); next_line(); 
	horz_skip(101); fprintf(fp,"%25.25s","Void Totals : ");
	print_formated_amt(t_vd ); next_line();
}

print_deb_cat_tot()
{
	horz_skip(101);
	fprintf(fp,"%-22.22s : ",loc_legend[370]);  
	print_formated_amt(t_dc ); next_line(); 
}
				       
print_sub_grp_hd()
{
	fprintf(fp,"%-15.15s : ",loc_legend[140]);
	fprintf(fp,"%-2.2s",cv_debt_cat_code.arr); horz_skip(1);
	fprintf(fp,cv_ln_debt_cat_code.arr); next_line();
}
								
print_val()
{
	fprintf(fp,"%-6.6s",cv_doc_type_code.arr); fprintf(fp,"/");
	fprintf(fp,"%-8.8s",cv_doc_number.arr); fprintf(fp,"/");
	fprintf(fp,"%-8.8s",cv_doc_srno.arr); horz_skip(11);
	fprintf(fp,"%-2.2s",cv_recpt_nature_code.arr); horz_skip(1);
	fprintf(fp,"%-14.14s",cv_ln_recpt_nature_code.arr); horz_skip(11);
	fprintf(fp,"%-8.8s",cv_recpt_type_code.arr); horz_skip(11);
	fprintf(fp,"%-16.16s",cv_trx_date.arr); horz_skip(11);
	fprintf(fp,"%-15.15s",cv_bill_doc_type_code_num.arr); horz_skip(11);
	print_formated_amt(cv_doc_amt); horz_skip(9); 
	fprintf(fp,"%-6.6s",cv_cancel_yn.arr);next_line();

	fprintf(fp,"%-15.15s",cv_slmt_type_code.arr); horz_skip(11);
	fprintf(fp,"%-14.14s",cv_slmt_doc_ref_desc.arr); horz_skip(14);
	fprintf(fp,"%-30.30s",cv_slmt_doc_remarks.arr); horz_skip(16);
	fprintf(fp,"%-40.40s",cv_narration.arr); horz_skip(11);
	fprintf(fp,"%-31.31s",cv_dep_ind.arr); next_line();
	 
	fprintf(fp,"%-7.7s : ",loc_legend[130]);
	fprintf(fp,"%-20.20s",cv_patient_id.arr); horz_skip(5); 
	fprintf(fp,"%-30.30s",cv_patient_name.arr); horz_skip(5); 	
	fprintf(fp,"%-1.1s",cv_episode_type.arr); horz_skip(5);
	fprintf(fp,"%-8.8s",cv_episode_id.arr); horz_skip(5);
	fprintf(fp,"%-4.4s",cv_visit_id.arr); 
	next_line(); next_line(); check_void();

	if(strlen(cv_patient_name1.arr) > 2)
    {
	 fprintf(fp,"%30s %s \n"," ",cv_patient_name1.arr);
    }

}

check_void()
{
  if (strcmp(cv_chk.arr,"B")==0)
  {
	t_vd = t_vd + cv_doc_amt;
  }
  else
  {
	t_dc = t_dc + cv_doc_amt;
	t_rr = t_rr + cv_doc_amt;
	t_sh = t_sh + cv_doc_amt;
	t_cc = t_cc + cv_doc_amt;
	g_tt = g_tt + cv_doc_amt;
  }
}

horz_skip(num)
int num;
{
	for(i=0;i<num;i++)fprintf(fp," ");
}

dash_line()
{
	for(i=0;i<188;i++)fprintf(fp,"-");next_line();
}

check_line(skip) /* will check for MAX LINE before printing totals */
int skip;
{
	if ((lctr + skip) > (MAX_LINES-1))
	{
		next_page(); 
	}
}

next_line() /* will check for MAX LINE before printing totals */		
{
	if (lctr > (MAX_LINES-1))
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; //fprintf(fp,"%2d",lctr); 
	}
}

next_page() /* will move the cursor to next page */
{
	fprintf(fp,"\f");  print_head(); 	
}

common_head()
{
	lctr=1; fprintf(fp,"\n"); fprintf(fp,"MDL : %2s",loc_legend[150]); horz_skip(73);
	fprintf(fp,"%-30.30s",hosp_name.arr); horz_skip(61);
	fprintf(fp,"%-16s",date_time.arr); next_line();
	fprintf(fp,"OPR : %-10s", user_id.arr); next_line();
	fprintf(fp,"REP : %-8s",loc_legend[40]); horz_skip(60);
	fprintf(fp,"%25.25s ",loc_legend[50]);
	if (strcmp(nd_trans_type.arr,"R")==0)
	{
		fprintf(fp,"%-8.8s",loc_legend[100]);
	}
	else
	{
		fprintf(fp,"%-8.8s",loc_legend[110]);		
	}
	fprintf(fp," - %6s",loc_legend[120]); horz_skip(60);
	fprintf(fp,"%4s : %4d",loc_legend[30],++pctr); next_line(); dash_line();
}

print_formated_amt(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        	       
        sprintf(str_amt,"%16s",s_amt);				
		ltrim (str_amt);	
		rtrim (str_amt);	
		strcpy(fstr_amt,"-");
		strcat(fstr_amt,str_amt);		
		ltrim (fstr_amt);	
		rtrim (fstr_amt);   
		sprintf(str_amt,"%16s",fstr_amt);		
        fprintf(fp,"%16s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%16s",s_amt);
        fprintf(fp,"%16s",str_amt);
     }
}  

print_formated(s_amt, l_amt)
double l_amt;
char *s_amt;
{

    if(l_amt < 0)
	{
        put_val(s_amt,-l_amt);
        format_amt(s_amt);
        strcat(s_amt,"-");
    }
    else 
	{
        put_val(s_amt,l_amt);
        format_amt(s_amt);
        strcat(s_amt," ");
    }
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRCSTRX.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRCSTRX.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )547;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )570;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

/*	****************************	End of Program	***************************	*/