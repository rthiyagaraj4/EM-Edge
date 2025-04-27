
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00016.PC"
};


static unsigned int sqlctx = 1288460891;


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
            void  *sqhstv[20];
   unsigned int   sqhstl[20];
            int   sqhsts[20];
            void  *sqindv[20];
            int   sqinds[20];
   unsigned int   sqharm[20];
   unsigned int   *sqharc[20];
   unsigned short  sqadto[20];
   unsigned short  sqtdso[20];
} sqlstm = {12,20};

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
"select a.doc_type_code ,a.DOC_NUMBER ,TO_CHAR(a.BOUNCED_DATE,'DD/MM/YYYY') ,\
a.slmt_doc_ref_desc Cheque_no ,TO_CHAR(a.slmt_doc_ref_date,'DD/MM/YYYY') chequ\
e_date ,((((a.doc_type_code||'/')||A.doc_numBER)||'/')||A.DOC_SRNO) Receipt_no\
 ,a.slmt_doc_remarks ,a.payer_name ,c.ln1_mail_add ,c.ln2_mail_add ,c.ln3_mail\
_add ,c.ln4_res_add ,c.res_postal_code postal_code ,a.doc_amt ,b.reason_code ,\
d.ACTION_REASON_DESC ,a.ext_acct_code  from Bl_receipt_refund_dtl_vw a ,BL_CAN\
CELLED_BOUNCED_TRX b ,MP_PAT_OTHER_DTLS c ,bl_action_reason_lang_vw D where ((\
(((((a.doc_type_code=b.doc_type_code and a.DOC_NUMBER=b.DOC_NUMBER) and a.pati\
ent_id=c.patient_id(+)) and b.reason_code=d.ACTION_REASON_CODE) and a.bounced_\
yn='Y') and to_char(a.bounced_date,'MM/YYYY')=:b0) and ((((:b1='1' and a.REPL_\
CHQ_YN='Y') and to_char(REPL_CHQ_DOC_DATE,'MM/YYYY')<>:b0) or NVL(a.REPL_CHQ_Y\
N,'N')='N') or (:b1='2' and nvl(a.REPL_CHQ_YN,'N')='N'))) and language_id=:b4)\
           ";

 static const char *sq0007 = 
"select a.doc_type_code ,a.doc_number ,TO_CHAR(a.BOUNCED_DATE,'DD/MM/YYYY') ,\
a.slmt_doc_ref_desc Cheque_no ,TO_CHAR(a.slmt_doc_ref_date,'DD/MM/YYYY') chequ\
e_date ,((((a.doc_type_code||'/')||a.doc_number)||'/')||a.DOC_SRNO) Receipt_no\
 ,a.slmt_doc_remarks ,a.payer_name ,c.ln1_mail_add ,c.ln2_mail_add ,c.ln3_mail\
_add ,c.ln4_res_add ,c.res_postal_code postal_code ,a.doc_amt ,b.reason_code ,\
d.action_reason_desc ,a.ext_acct_code ,a.repl_chq_doc_type_code ,a.repl_chq_do\
c_num ,a.repl_chq_doc_date  from Bl_receipt_refund_dtl_vw a ,BL_CANCELLED_BOUN\
CED_TRX b ,mp_pat_other_dtls c ,bl_action_reason_lang_vw D where ((((((((a.doc\
_type_code=b.doc_type_code and a.doc_number=b.doc_number) and a.patient_id=c.p\
atient_id(+)) and b.reason_code=d.action_reason_code) and a.bounced_yn='Y') an\
d a.REPL_CHQ_YN='Y') and to_char(a.bounced_date,'MM/YYYY')=:b0) and (((:b1='1'\
 and a.REPL_CHQ_YN='Y') and to_char(REPL_CHQ_DOC_DATE,'MM/YYYY')=:b0) or (:b1=\
'2' and a.REPL_CHQ_YN='Y'))) and language_id=:b4)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,135,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,111,0,4,170,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
71,0,0,3,84,0,2,188,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
98,0,0,4,88,0,4,198,0,0,1,0,0,1,0,2,4,0,0,
117,0,0,5,0,0,30,232,0,0,0,0,0,1,0,
132,0,0,6,945,0,9,312,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
167,0,0,6,0,0,15,320,0,0,0,0,0,1,0,
182,0,0,7,994,0,9,326,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
217,0,0,7,0,0,15,334,0,0,0,0,0,1,0,
232,0,0,6,0,0,13,372,0,0,17,0,0,1,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
315,0,0,7,0,0,13,456,0,0,20,0,0,1,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
410,0,0,8,456,0,4,529,0,0,14,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,4,0,0,
481,0,0,9,206,0,4,588,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
524,0,0,10,96,0,4,1087,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
547,0,0,11,162,0,6,1094,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
578,0,0,12,199,0,6,1114,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
605,0,0,13,193,0,6,1137,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00016.PC                                  */
/* AUTHOR                : Robert Joseph                               */  
/* DATE WRITTEN          : 06/09/2004                                   */      
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
#define REP_WIDTH 225
#define ESC 0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hosp_name                       [120],
			l_acc_name						[120],
			date							[20],
            date_time                       [20],
			nd_temp_date					[20],
			nd_loc_date						[20],
			date_convert					[20],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility				        [3],
			nd_mm_yyyy					   [11],
			nd_option						[2],
			nrpdoc_type_code					[7],
			nrpbounced_date					[12],
			nrpcheque_no						[21],
			nrpcheque_date					[15],
			nrpreceipt_no					[20],
			nrpslmt_doc_remarks				[102],
			nrppayer_name					[41],
			nrpln1_mail_add					[30],
			nrpln2_mail_add					[30],
			nrpln3_mail_add					[30],
			nrpln4_res_add					[30],
			nrppostal_code					[21],
			nrpreason_code					[5],
			nrpaction_reason_desc			[256],
			nrpext_acct_code				[11],
			rpdoc_type_code					[7],
			rpbounced_date					[12],
			rpcheque_no						[21],
			rpcheque_date					[15],
			rpreceipt_no					[20],
			rpslmt_doc_remarks				[102],
			rppayer_name					[41],
			rpln1_mail_add					[30],
			rpln2_mail_add					[30],
			rpln3_mail_add					[30],
			rpln4_res_add					[30],
			rppostal_code					[21],
			rpreason_code					[5],
			rpaction_reason_desc			[256],
			rpext_acct_code					[11],
			rrepl_chq_doc_type_code			[7]	,					
			rrepl_chq_doc_date				[12],
			chrepl_Cheque_no				[21],				
			chrepl_cheque_date				[12],
			chrepl_Receipt_no				[15],
			chrepl_bank_name				[31],
			chreplacement_Remarks			[51],
			label                           [100],
			replabel                        [30],
			chpayer_name					[41],
			chln1_mail_add					[30],
			chln2_mail_add					[30],
			chln3_mail_add					[30],
			chln4_res_add					[30],
			chpostal_code					[30],
			l_translated_value				[201],
			l_pk_value						[100],
			p_language_id					[3],
			remarklb						[30]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[120]; } l_acc_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[11]; } nd_mm_yyyy;

struct { unsigned short len; unsigned char arr[2]; } nd_option;

struct { unsigned short len; unsigned char arr[7]; } nrpdoc_type_code;

struct { unsigned short len; unsigned char arr[12]; } nrpbounced_date;

struct { unsigned short len; unsigned char arr[21]; } nrpcheque_no;

struct { unsigned short len; unsigned char arr[15]; } nrpcheque_date;

struct { unsigned short len; unsigned char arr[20]; } nrpreceipt_no;

struct { unsigned short len; unsigned char arr[102]; } nrpslmt_doc_remarks;

struct { unsigned short len; unsigned char arr[41]; } nrppayer_name;

struct { unsigned short len; unsigned char arr[30]; } nrpln1_mail_add;

struct { unsigned short len; unsigned char arr[30]; } nrpln2_mail_add;

struct { unsigned short len; unsigned char arr[30]; } nrpln3_mail_add;

struct { unsigned short len; unsigned char arr[30]; } nrpln4_res_add;

struct { unsigned short len; unsigned char arr[21]; } nrppostal_code;

struct { unsigned short len; unsigned char arr[5]; } nrpreason_code;

struct { unsigned short len; unsigned char arr[256]; } nrpaction_reason_desc;

struct { unsigned short len; unsigned char arr[11]; } nrpext_acct_code;

struct { unsigned short len; unsigned char arr[7]; } rpdoc_type_code;

struct { unsigned short len; unsigned char arr[12]; } rpbounced_date;

struct { unsigned short len; unsigned char arr[21]; } rpcheque_no;

struct { unsigned short len; unsigned char arr[15]; } rpcheque_date;

struct { unsigned short len; unsigned char arr[20]; } rpreceipt_no;

struct { unsigned short len; unsigned char arr[102]; } rpslmt_doc_remarks;

struct { unsigned short len; unsigned char arr[41]; } rppayer_name;

struct { unsigned short len; unsigned char arr[30]; } rpln1_mail_add;

struct { unsigned short len; unsigned char arr[30]; } rpln2_mail_add;

struct { unsigned short len; unsigned char arr[30]; } rpln3_mail_add;

struct { unsigned short len; unsigned char arr[30]; } rpln4_res_add;

struct { unsigned short len; unsigned char arr[21]; } rppostal_code;

struct { unsigned short len; unsigned char arr[5]; } rpreason_code;

struct { unsigned short len; unsigned char arr[256]; } rpaction_reason_desc;

struct { unsigned short len; unsigned char arr[11]; } rpext_acct_code;

struct { unsigned short len; unsigned char arr[7]; } rrepl_chq_doc_type_code;

struct { unsigned short len; unsigned char arr[12]; } rrepl_chq_doc_date;

struct { unsigned short len; unsigned char arr[21]; } chrepl_Cheque_no;

struct { unsigned short len; unsigned char arr[12]; } chrepl_cheque_date;

struct { unsigned short len; unsigned char arr[15]; } chrepl_Receipt_no;

struct { unsigned short len; unsigned char arr[31]; } chrepl_bank_name;

struct { unsigned short len; unsigned char arr[51]; } chreplacement_Remarks;

struct { unsigned short len; unsigned char arr[100]; } label;

struct { unsigned short len; unsigned char arr[30]; } replabel;

struct { unsigned short len; unsigned char arr[41]; } chpayer_name;

struct { unsigned short len; unsigned char arr[30]; } chln1_mail_add;

struct { unsigned short len; unsigned char arr[30]; } chln2_mail_add;

struct { unsigned short len; unsigned char arr[30]; } chln3_mail_add;

struct { unsigned short len; unsigned char arr[30]; } chln4_res_add;

struct { unsigned short len; unsigned char arr[30]; } chpostal_code;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[30]; } remarklb;


			

	double nrpdoc_number,nrpdoc_amt,nrptot_amt,cnt =0,chqtot_amt =0;
	double rpdoc_number,rpdoc_amt,rrepl_chq_doc_num,chdoc_amt,rptot_amt;
		 					
			int i;
			
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];

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

int  lctr = 0,pctr = 0,slno = 1,nslno=1,pagebreak=1;
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
  

         strcpy(g_pgm_id,"BLR00016");
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
		 
		 strcpy(p_language_id.arr,l_language_id.arr);
		 p_language_id.len = l_language_id.len;

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

	
        nd_mm_yyyy.arr[0]			= '\0';
		nd_option.arr[0]				= '\0';
		nd_mm_yyyy.len			    = 0;
        nd_option.len			  	    = 0;  

		 /* EXEC SQL SELECT	PARAM1,PARAM2
				INTO	:nd_mm_yyyy,
						:nd_option
				FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 into :b0,:b1  from SY_PROG_PARAM whe\
re ((PGM_ID=:b2 and SESSION_ID=:b3) and PGM_DATE=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_mm_yyyy;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_option;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[2] = (unsigned int  )17;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[3] = (unsigned int  )18;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[4] = (unsigned int  )27;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

		nd_mm_yyyy.arr[nd_mm_yyyy.len]				= '\0';
        nd_option.arr[nd_option.len]						= '\0';

    
			/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )71;
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
   	 
		
        /* EXEC SQL SELECT COUNT(1) INTO :cnt  FROM 
		      bl_submodule where
			  SUBMODULE_ID='EX' and INSTALL_YN='Y'; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 5;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select count(1) into :b0  from bl_submodule where (SU\
BMODULE_ID='EX' and INSTALL_YN='Y')";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )98;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&cnt;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
        err_mesg("SELECT failed on table BL_SUBMODULE",0,"");

		 if (NODATAFOUND)
		 cnt =0;
    	   
		declare_cursor();

        fetch_hosp_name();

        fetch_legend_value();

        open_file();
  
        //Modified for converting to DMP Printer//
	    //fprintf(fp,"%c&l1O",ESC); 
        //fprintf(fp,"%c(s20H",ESC);
		
	    fprintf(fp,"%c",0x12);   // Set Dot matrix Noraml Mode

		fprintf(fp,"%c",0x0F); // set Dot-matrix Printer  printer to compressed mode 

		print_page_header();

        print_hdr();

        end_of_rep();

		fprintf(fp,"%c",0x12);   // Set Dot matrix Noraml Mode

   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )117;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}

	

declare_cursor()
 {

   /* EXEC SQL DECLARE CHQ_NOT_REPLACE_CUR CURSOR FOR
   Select a.doc_type_code, a.DOC_NUMBER,TO_CHAR(a.BOUNCED_DATE,'DD/MM/YYYY'), 
      a.slmt_doc_ref_desc Cheque_no,
      TO_CHAR(a.slmt_doc_ref_date,'DD/MM/YYYY') cheque_date,
      a.doc_type_code||'/'||A.doc_numBER||'/'||A.DOC_SRNO Receipt_no,
      a. slmt_doc_remarks, 
      a.payer_name , 
      c.ln1_mail_add, c.ln2_mail_add   , c.ln3_mail_add , c.ln4_res_add       ,     
      c.res_postal_code   postal_code,
       a.doc_amt,
       b.reason_code ,
       d.ACTION_REASON_DESC, 
       a.ext_acct_code
      from Bl_receipt_refund_dtl_vw a, BL_CANCELLED_BOUNCED_TRX b, MP_PAT_OTHER_DTLS c, bl_action_reason_lang_vw D
      where a.doc_type_code = b.doc_type_code
		and a.DOC_NUMBER = b.DOC_NUMBER
		and a.patient_id = c.patient_id(+)
		and b.reason_code = d.ACTION_REASON_CODE
		and a.bounced_yn = 'Y' 
		and to_char(a.bounced_date,'MM/YYYY')  =:nd_mm_yyyy
		and (
 		(:nd_option='1' and 
		a.REPL_CHQ_YN ='Y' and 
         	to_char(REPL_CHQ_DOC_DATE,'MM/YYYY')<>:nd_mm_yyyy or NVL(a.REPL_CHQ_YN,'N') ='N') 
		or
		 ( :nd_option='2' and nvl(a.REPL_CHQ_YN,'N') ='N'))
		 and language_id=:p_language_id; */ 

         

 /* EXEC SQL  DECLARE CHQ_REPLACE_CUR CURSOR FOR
    Select a.doc_type_code, a.doc_number,TO_CHAR(a.BOUNCED_DATE,'DD/MM/YYYY'), 
      a.slmt_doc_ref_desc Cheque_no,
      TO_CHAR(a.slmt_doc_ref_date,'DD/MM/YYYY') cheque_date,
      a.doc_type_code||'/'||a.doc_number||'/'||a.DOC_SRNO Receipt_no,
      a. slmt_doc_remarks ,
      a.payer_name , 
      c.ln1_mail_add, c.ln2_mail_add   , c.ln3_mail_add , c.ln4_res_add       ,     
      c.res_postal_code   postal_code,
       a.doc_amt,
       b.reason_code ,
       d.action_reason_desc, 
       a.ext_acct_code,
       a.repl_chq_doc_type_code,
       a.repl_chq_doc_num,
       a.repl_chq_doc_date                
      from Bl_receipt_refund_dtl_vw a, BL_CANCELLED_BOUNCED_TRX b, mp_pat_other_dtls c, bl_action_reason_lang_vw D
      where a.doc_type_code = b.doc_type_code
	and a.doc_number = b.doc_number
	and a.patient_id = c.patient_id(+)
	and b.reason_code = d.action_reason_code
	and a.bounced_yn = 'Y' 
	and a.REPL_CHQ_YN ='Y'
	and to_char(a.bounced_date,'MM/YYYY') = :nd_mm_yyyy
	and (
	(:nd_option='1' and 
	a.REPL_CHQ_YN ='Y' and 
			to_char(REPL_CHQ_DOC_DATE,'MM/YYYY')=:nd_mm_yyyy) 
	or
	(:nd_option='2' and  a.REPL_CHQ_YN ='Y')
	)
	and language_id=:p_language_id; */ 





  }
  
  open_chq_not_repl()
{

	/* EXEC SQL OPEN CHQ_NOT_REPLACE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )132;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_mm_yyyy;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_option;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_mm_yyyy;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_option;
 sqlstm.sqhstl[3] = (unsigned int  )4;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor CHQ_NOT_REPLACE_CUR",0,"");
}

close_chq_not_repl()
{

	/* EXEC SQL CLOSE CHQ_NOT_REPLACE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )167;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

open_chq_repl() 
{
	/* EXEC SQL OPEN CHQ_REPLACE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )182;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_mm_yyyy;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_option;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_mm_yyyy;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_option;
 sqlstm.sqhstl[3] = (unsigned int  )4;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor CHQ_REPLACE_CUR",0,"");
}

close_chq_repl() 
{

	/* EXEC SQL CLOSE CHQ_REPLACE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )217;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}  

fetch_chq_not_replace_cur()
 {
    nrpdoc_type_code.arr[0]				= '\0';
	nrpcheque_no.arr[0]					= '\0';
	nrpcheque_date.arr[0]				= '\0';
	nrpreceipt_no.arr[0]				= '\0';
	nrpslmt_doc_remarks.arr[0]			= '\0';
	nrppayer_name.arr[0]				= '\0';  
	nrpln1_mail_add.arr[0]				= '\0';
	nrpln2_mail_add.arr[0]				= '\0'; 
	nrpln3_mail_add.arr[0]				= '\0';
	nrpln4_res_add.arr[0]				= '\0';        
	nrppostal_code.arr[0]				= '\0';
	nrpreason_code.arr[0]				= '\0'; 
	nrpaction_reason_desc.arr[0]		= '\0';
	nrpext_acct_code.arr[0]				= '\0';

	nrpdoc_type_code.len			= 0;
	nrpbounced_date.len				= 0;
	nrpcheque_no.len				= 0;
	nrpcheque_date.len				= 0;
	nrpreceipt_no.len				= 0;
	nrpslmt_doc_remarks.len			= 0;
	nrppayer_name.len				= 0;
	nrpln1_mail_add.len				= 0;
	nrpln2_mail_add.len				= 0;
	nrpln3_mail_add.len				= 0;
	nrpln4_res_add.len				= 0;
	nrppostal_code.len				= 0;
	nrpreason_code.len				= 0;
	nrpaction_reason_desc.len		= 0;
	nrpext_acct_code.len			= 0;


/* EXEC SQL FETCH CHQ_NOT_REPLACE_CUR INTO
	:nrpdoc_type_code,
	:nrpdoc_number,
	:nrpbounced_date,
	:nrpcheque_no,
	:nrpcheque_date,
	:nrpreceipt_no,
	:nrpslmt_doc_remarks,
	:nrppayer_name,
	:nrpln1_mail_add,
	:nrpln2_mail_add,
	:nrpln3_mail_add,
	:nrpln4_res_add,
	:nrppostal_code,
	:nrpdoc_amt,
	:nrpreason_code,
	:nrpaction_reason_desc,
	:nrpext_acct_code; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 17;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )232;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqfoff = (           int )0;
sqlstm.sqfmod = (unsigned int )2;
sqlstm.sqhstv[0] = (         void  *)&nrpdoc_type_code;
sqlstm.sqhstl[0] = (unsigned int  )9;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nrpdoc_number;
sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nrpbounced_date;
sqlstm.sqhstl[2] = (unsigned int  )14;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nrpcheque_no;
sqlstm.sqhstl[3] = (unsigned int  )23;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nrpcheque_date;
sqlstm.sqhstl[4] = (unsigned int  )17;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&nrpreceipt_no;
sqlstm.sqhstl[5] = (unsigned int  )22;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nrpslmt_doc_remarks;
sqlstm.sqhstl[6] = (unsigned int  )104;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&nrppayer_name;
sqlstm.sqhstl[7] = (unsigned int  )43;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&nrpln1_mail_add;
sqlstm.sqhstl[8] = (unsigned int  )32;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&nrpln2_mail_add;
sqlstm.sqhstl[9] = (unsigned int  )32;
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&nrpln3_mail_add;
sqlstm.sqhstl[10] = (unsigned int  )32;
sqlstm.sqhsts[10] = (         int  )0;
sqlstm.sqindv[10] = (         void  *)0;
sqlstm.sqinds[10] = (         int  )0;
sqlstm.sqharm[10] = (unsigned int  )0;
sqlstm.sqadto[10] = (unsigned short )0;
sqlstm.sqtdso[10] = (unsigned short )0;
sqlstm.sqhstv[11] = (         void  *)&nrpln4_res_add;
sqlstm.sqhstl[11] = (unsigned int  )32;
sqlstm.sqhsts[11] = (         int  )0;
sqlstm.sqindv[11] = (         void  *)0;
sqlstm.sqinds[11] = (         int  )0;
sqlstm.sqharm[11] = (unsigned int  )0;
sqlstm.sqadto[11] = (unsigned short )0;
sqlstm.sqtdso[11] = (unsigned short )0;
sqlstm.sqhstv[12] = (         void  *)&nrppostal_code;
sqlstm.sqhstl[12] = (unsigned int  )23;
sqlstm.sqhsts[12] = (         int  )0;
sqlstm.sqindv[12] = (         void  *)0;
sqlstm.sqinds[12] = (         int  )0;
sqlstm.sqharm[12] = (unsigned int  )0;
sqlstm.sqadto[12] = (unsigned short )0;
sqlstm.sqtdso[12] = (unsigned short )0;
sqlstm.sqhstv[13] = (         void  *)&nrpdoc_amt;
sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[13] = (         int  )0;
sqlstm.sqindv[13] = (         void  *)0;
sqlstm.sqinds[13] = (         int  )0;
sqlstm.sqharm[13] = (unsigned int  )0;
sqlstm.sqadto[13] = (unsigned short )0;
sqlstm.sqtdso[13] = (unsigned short )0;
sqlstm.sqhstv[14] = (         void  *)&nrpreason_code;
sqlstm.sqhstl[14] = (unsigned int  )7;
sqlstm.sqhsts[14] = (         int  )0;
sqlstm.sqindv[14] = (         void  *)0;
sqlstm.sqinds[14] = (         int  )0;
sqlstm.sqharm[14] = (unsigned int  )0;
sqlstm.sqadto[14] = (unsigned short )0;
sqlstm.sqtdso[14] = (unsigned short )0;
sqlstm.sqhstv[15] = (         void  *)&nrpaction_reason_desc;
sqlstm.sqhstl[15] = (unsigned int  )258;
sqlstm.sqhsts[15] = (         int  )0;
sqlstm.sqindv[15] = (         void  *)0;
sqlstm.sqinds[15] = (         int  )0;
sqlstm.sqharm[15] = (unsigned int  )0;
sqlstm.sqadto[15] = (unsigned short )0;
sqlstm.sqtdso[15] = (unsigned short )0;
sqlstm.sqhstv[16] = (         void  *)&nrpext_acct_code;
sqlstm.sqhstl[16] = (unsigned int  )13;
sqlstm.sqhsts[16] = (         int  )0;
sqlstm.sqindv[16] = (         void  *)0;
sqlstm.sqinds[16] = (         int  )0;
sqlstm.sqharm[16] = (unsigned int  )0;
sqlstm.sqadto[16] = (unsigned short )0;
sqlstm.sqtdso[16] = (unsigned short )0;
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
          err_mesg("FETCH failed on cursor CHQ_NOT_REPLACE_CUR",0,"");


		nrpdoc_type_code.arr[nrpdoc_type_code.len]		='\0';
		nrpbounced_date.arr[nrpbounced_date.len]			='\0';
		nrpcheque_no.arr[nrpcheque_no.len]				='\0';
		nrpcheque_date.arr[nrpcheque_date.len]			='\0';
		nrpreceipt_no.arr[nrpreceipt_no.len]				='\0';			
		nrpslmt_doc_remarks.arr[nrpslmt_doc_remarks.len]	='\0';			
		nrppayer_name.arr[nrppayer_name.len]				='\0';
		nrpln1_mail_add.arr[nrpln1_mail_add.len]			='\0';
		nrpln2_mail_add.arr[nrpln2_mail_add.len]			='\0';
		nrpln3_mail_add.arr[nrpln3_mail_add.len]			='\0';
		nrpln4_res_add.arr[nrpln4_res_add.len]			='\0';
		nrppostal_code.arr[nrppostal_code.len]			='\0';
		nrpreason_code.arr[nrpreason_code.len]			='\0';
		nrpaction_reason_desc.arr[nrpaction_reason_desc.len]	= '\0'	;
		nrpext_acct_code.arr[nrpext_acct_code.len]  		= '\0';
   

    return(LAST_ROW?0:1);
	}

fetch_chq_replace_cur()
 {

    rpdoc_type_code.arr[0]				= '\0';
	rpbounced_date.arr[0]				= '\0';
	rpcheque_no.arr[0]					= '\0';
	rpcheque_date.arr[0]				= '\0';
	rpreceipt_no.arr[0]					= '\0';
	rpslmt_doc_remarks.arr[0]			= '\0';
	rppayer_name.arr[0]					= '\0';  
	rpln1_mail_add.arr[0]				= '\0';
	rpln2_mail_add.arr[0]				= '\0'; 
	rpln3_mail_add.arr[0]				= '\0';
	rpln4_res_add.arr[0]				= '\0';        
	rppostal_code.arr[0]				= '\0';
	rpreason_code.arr[0]				= '\0'; 
	rpaction_reason_desc.arr[0]			= '\0';
	rpext_acct_code.arr[0]				= '\0';
	rrepl_chq_doc_type_code.arr[0]		= '\0';			
	rrepl_chq_doc_date.arr[0]			= '\0';
	

	rpdoc_type_code.len				= 0;
	rpbounced_date.len				= 0;
	rpcheque_no.len					= 0;
	rpcheque_date.len				= 0;
	rpreceipt_no.len				= 0;
	rpslmt_doc_remarks.len			= 0;
	rppayer_name.len				= 0;
	rpln1_mail_add.len				= 0;
	rpln2_mail_add.len				= 0;
	rpln3_mail_add.len				= 0;
	rpln4_res_add.len				= 0;
	rppostal_code.len				= 0;
	rpreason_code.len				= 0;
	rpaction_reason_desc.len		= 0;
	rpext_acct_code.len				= 0;
	rrepl_chq_doc_type_code.len			= 0;			
	rrepl_chq_doc_date.len 				= 0;


/* EXEC SQL FETCH CHQ_REPLACE_CUR INTO
	:rpdoc_type_code,
	:rpdoc_number,
	:rpbounced_date,
	:rpcheque_no,
	:rpcheque_date,
	:rpreceipt_no,
	:rpslmt_doc_remarks,
	:rppayer_name,
	:rpln1_mail_add,
	:rpln2_mail_add,
	:rpln3_mail_add,
	:rpln4_res_add,
	:rppostal_code,
	:rpdoc_amt,
	:rpreason_code,
	:rpaction_reason_desc,
	:rpext_acct_code,
	:rrepl_chq_doc_type_code,
	:rrepl_chq_doc_num,				
	:rrepl_chq_doc_date; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 20;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )315;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqfoff = (           int )0;
sqlstm.sqfmod = (unsigned int )2;
sqlstm.sqhstv[0] = (         void  *)&rpdoc_type_code;
sqlstm.sqhstl[0] = (unsigned int  )9;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&rpdoc_number;
sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&rpbounced_date;
sqlstm.sqhstl[2] = (unsigned int  )14;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&rpcheque_no;
sqlstm.sqhstl[3] = (unsigned int  )23;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&rpcheque_date;
sqlstm.sqhstl[4] = (unsigned int  )17;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&rpreceipt_no;
sqlstm.sqhstl[5] = (unsigned int  )22;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&rpslmt_doc_remarks;
sqlstm.sqhstl[6] = (unsigned int  )104;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&rppayer_name;
sqlstm.sqhstl[7] = (unsigned int  )43;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&rpln1_mail_add;
sqlstm.sqhstl[8] = (unsigned int  )32;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&rpln2_mail_add;
sqlstm.sqhstl[9] = (unsigned int  )32;
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&rpln3_mail_add;
sqlstm.sqhstl[10] = (unsigned int  )32;
sqlstm.sqhsts[10] = (         int  )0;
sqlstm.sqindv[10] = (         void  *)0;
sqlstm.sqinds[10] = (         int  )0;
sqlstm.sqharm[10] = (unsigned int  )0;
sqlstm.sqadto[10] = (unsigned short )0;
sqlstm.sqtdso[10] = (unsigned short )0;
sqlstm.sqhstv[11] = (         void  *)&rpln4_res_add;
sqlstm.sqhstl[11] = (unsigned int  )32;
sqlstm.sqhsts[11] = (         int  )0;
sqlstm.sqindv[11] = (         void  *)0;
sqlstm.sqinds[11] = (         int  )0;
sqlstm.sqharm[11] = (unsigned int  )0;
sqlstm.sqadto[11] = (unsigned short )0;
sqlstm.sqtdso[11] = (unsigned short )0;
sqlstm.sqhstv[12] = (         void  *)&rppostal_code;
sqlstm.sqhstl[12] = (unsigned int  )23;
sqlstm.sqhsts[12] = (         int  )0;
sqlstm.sqindv[12] = (         void  *)0;
sqlstm.sqinds[12] = (         int  )0;
sqlstm.sqharm[12] = (unsigned int  )0;
sqlstm.sqadto[12] = (unsigned short )0;
sqlstm.sqtdso[12] = (unsigned short )0;
sqlstm.sqhstv[13] = (         void  *)&rpdoc_amt;
sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[13] = (         int  )0;
sqlstm.sqindv[13] = (         void  *)0;
sqlstm.sqinds[13] = (         int  )0;
sqlstm.sqharm[13] = (unsigned int  )0;
sqlstm.sqadto[13] = (unsigned short )0;
sqlstm.sqtdso[13] = (unsigned short )0;
sqlstm.sqhstv[14] = (         void  *)&rpreason_code;
sqlstm.sqhstl[14] = (unsigned int  )7;
sqlstm.sqhsts[14] = (         int  )0;
sqlstm.sqindv[14] = (         void  *)0;
sqlstm.sqinds[14] = (         int  )0;
sqlstm.sqharm[14] = (unsigned int  )0;
sqlstm.sqadto[14] = (unsigned short )0;
sqlstm.sqtdso[14] = (unsigned short )0;
sqlstm.sqhstv[15] = (         void  *)&rpaction_reason_desc;
sqlstm.sqhstl[15] = (unsigned int  )258;
sqlstm.sqhsts[15] = (         int  )0;
sqlstm.sqindv[15] = (         void  *)0;
sqlstm.sqinds[15] = (         int  )0;
sqlstm.sqharm[15] = (unsigned int  )0;
sqlstm.sqadto[15] = (unsigned short )0;
sqlstm.sqtdso[15] = (unsigned short )0;
sqlstm.sqhstv[16] = (         void  *)&rpext_acct_code;
sqlstm.sqhstl[16] = (unsigned int  )13;
sqlstm.sqhsts[16] = (         int  )0;
sqlstm.sqindv[16] = (         void  *)0;
sqlstm.sqinds[16] = (         int  )0;
sqlstm.sqharm[16] = (unsigned int  )0;
sqlstm.sqadto[16] = (unsigned short )0;
sqlstm.sqtdso[16] = (unsigned short )0;
sqlstm.sqhstv[17] = (         void  *)&rrepl_chq_doc_type_code;
sqlstm.sqhstl[17] = (unsigned int  )9;
sqlstm.sqhsts[17] = (         int  )0;
sqlstm.sqindv[17] = (         void  *)0;
sqlstm.sqinds[17] = (         int  )0;
sqlstm.sqharm[17] = (unsigned int  )0;
sqlstm.sqadto[17] = (unsigned short )0;
sqlstm.sqtdso[17] = (unsigned short )0;
sqlstm.sqhstv[18] = (         void  *)&rrepl_chq_doc_num;
sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[18] = (         int  )0;
sqlstm.sqindv[18] = (         void  *)0;
sqlstm.sqinds[18] = (         int  )0;
sqlstm.sqharm[18] = (unsigned int  )0;
sqlstm.sqadto[18] = (unsigned short )0;
sqlstm.sqtdso[18] = (unsigned short )0;
sqlstm.sqhstv[19] = (         void  *)&rrepl_chq_doc_date;
sqlstm.sqhstl[19] = (unsigned int  )14;
sqlstm.sqhsts[19] = (         int  )0;
sqlstm.sqindv[19] = (         void  *)0;
sqlstm.sqinds[19] = (         int  )0;
sqlstm.sqharm[19] = (unsigned int  )0;
sqlstm.sqadto[19] = (unsigned short )0;
sqlstm.sqtdso[19] = (unsigned short )0;
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
          err_mesg("FETCH failed on cursor CHQ_REPLACE_CUR",0,"");


	rpdoc_type_code.arr[rpdoc_type_code.len]		='\0';
	rpbounced_date.arr[rpbounced_date.len]			='\0';
	rpcheque_no.arr[rpcheque_no.len]				='\0';
	rpcheque_date.arr[rpcheque_date.len]			='\0';
	rpreceipt_no.arr[rpreceipt_no.len]				='\0';			
	rpslmt_doc_remarks.arr[rpslmt_doc_remarks.len]		='\0';
	rppayer_name.arr[rppayer_name.len]				='\0';
	rpln1_mail_add.arr[rpln1_mail_add.len]			='\0';
	rpln2_mail_add.arr[rpln2_mail_add.len]			='\0';
	rpln3_mail_add.arr[rpln3_mail_add.len]			='\0';
	rpln4_res_add.arr[rpln4_res_add.len]			='\0';
	rppostal_code.arr[rppostal_code.len]			='\0';
	rpreason_code.arr[rpreason_code.len]			='\0';
	rpaction_reason_desc.arr[rpaction_reason_desc.len]	='\0';	
	rpext_acct_code.arr[rpext_acct_code.len]  		='\0';
	rrepl_chq_doc_type_code.arr[rrepl_chq_doc_type_code.len] ='\0';							
	rrepl_chq_doc_date.arr[rrepl_chq_doc_date.len]		='\0';		 
	
  return(LAST_ROW?0:1);
	}

fetch_repl_cheque_desc()
{
    chrepl_Cheque_no.arr[0]		 ='\0';					
	chrepl_cheque_date.arr[0]	 ='\0';		
	chrepl_Receipt_no.arr[0]	 ='\0';			
	chrepl_bank_name.arr[0]		 ='\0';			
	chreplacement_Remarks.arr[0] ='\0';
	chpayer_name.arr[0]			='\0';			
	chln1_mail_add.arr[0]		='\0';
	chln2_mail_add.arr[0]		='\0';
	chln3_mail_add.arr[0]		='\0';
	chln4_res_add.arr[0]		='\0';
	chpostal_code.arr[0]		='\0';

	chrepl_Cheque_no.len		 = 0;			
	chrepl_cheque_date.len		 = 0;	
	chrepl_Receipt_no.len		 = 0;		
	chrepl_bank_name.len		 = 0;	
	chreplacement_Remarks.len	 = 0;
	chpayer_name.len			=0;	
	chln1_mail_add.len			=0;
	chln2_mail_add.len			=0;
	chln3_mail_add.len			=0;
	chln4_res_add.len			=0;
	chpostal_code.len			=0;

    /* EXEC SQL SELECT a.slmt_doc_ref_desc,
           TO_CHAR(a.slmt_doc_ref_date,'DD/MM/YYYY') ,
           a.doc_type_code||'/'||a.doc_number,
           a.slmt_doc_remarks, 
           a.doc_amt,
           a.narration,
		   a.payer_name, 
           c.ln1_mail_add, 
		   c.ln2_mail_add,
		   c.ln3_mail_add,
		   c.ln4_res_add,            
           c.res_postal_code   postal_code into
		    :chrepl_Cheque_no,						
			:chrepl_cheque_date,			
			:chrepl_Receipt_no,				
			:chrepl_bank_name,
			:chdoc_amt,				
			:chreplacement_Remarks,
			:chpayer_name,
			:chln1_mail_add,
			:chln2_mail_add,
			:chln3_mail_add,
			:chln4_res_add,
			:chpostal_code	
     FROM Bl_receipt_refund_dtl_vw a,MP_PAT_OTHER_DTLS c 
     WHERE  a.patient_id    = c.patient_id(+) and  
            a.doc_type_code = :rrepl_chq_doc_type_code
       AND  a.doc_number    = :rrepl_chq_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select a.slmt_doc_ref_desc ,TO_CHAR(a.slmt_doc_ref_date,'\
DD/MM/YYYY') ,((a.doc_type_code||'/')||a.doc_number) ,a.slmt_doc_remarks ,a.do\
c_amt ,a.narration ,a.payer_name ,c.ln1_mail_add ,c.ln2_mail_add ,c.ln3_mail_a\
dd ,c.ln4_res_add ,c.res_postal_code postal_code into :b0,:b1,:b2,:b3,:b4,:b5,\
:b6,:b7,:b8,:b9,:b10,:b11  from Bl_receipt_refund_dtl_vw a ,MP_PAT_OTHER_DTLS \
c where ((a.patient_id=c.patient_id(+) and a.doc_type_code=:b12) and a.doc_num\
ber=:b13)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )410;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&chrepl_Cheque_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&chrepl_cheque_date;
    sqlstm.sqhstl[1] = (unsigned int  )14;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&chrepl_Receipt_no;
    sqlstm.sqhstl[2] = (unsigned int  )17;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&chrepl_bank_name;
    sqlstm.sqhstl[3] = (unsigned int  )33;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&chdoc_amt;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&chreplacement_Remarks;
    sqlstm.sqhstl[5] = (unsigned int  )53;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&chpayer_name;
    sqlstm.sqhstl[6] = (unsigned int  )43;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&chln1_mail_add;
    sqlstm.sqhstl[7] = (unsigned int  )32;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&chln2_mail_add;
    sqlstm.sqhstl[8] = (unsigned int  )32;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&chln3_mail_add;
    sqlstm.sqhstl[9] = (unsigned int  )32;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&chln4_res_add;
    sqlstm.sqhstl[10] = (unsigned int  )32;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&chpostal_code;
    sqlstm.sqhstl[11] = (unsigned int  )32;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rrepl_chq_doc_type_code;
    sqlstm.sqhstl[12] = (unsigned int  )9;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rrepl_chq_doc_num;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
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
		err_mesg("SELECT failed on table BL_RECEIPT_REFUND_DTL",0,"");

			chrepl_Cheque_no.arr[chrepl_Cheque_no.len]			 ='\0';						
			chrepl_cheque_date.arr[chrepl_cheque_date.len]		 ='\0';			
			chrepl_Receipt_no.arr[chrepl_Receipt_no.len]		 ='\0';				
			chrepl_bank_name.arr[chrepl_bank_name.len]			 ='\0';				
			chreplacement_Remarks.arr[chreplacement_Remarks.len] ='\0';
            chpayer_name.arr[chpayer_name.len]			='\0';			
			chln1_mail_add.arr[chln1_mail_add.len]		='\0';
			chln2_mail_add.arr[chln2_mail_add.len]		='\0';
			chln3_mail_add.arr[chln3_mail_add.len]		='\0';
			chln4_res_add.arr[chln4_res_add.len]		='\0';
			chpostal_code.arr[chpostal_code.len]		='\0'; 

}

fetch_hosp_name()
{
    l_acc_name.arr[0]= '\0';
	hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
	date.arr[0]		 = '\0';
    user_id.arr[0]   = '\0';
    l_acc_name.len   = 0;
	hosp_name.len    = 0;
    date_time.len    = 0;
	date.len		 = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACCOUNTING_NAME, 
					ACC_ENTITY_NAME,
					TO_CHAR(SYSDATE,'DD/MM/RRRR'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
                    USER
               INTO :l_acc_name,
					:hosp_name, 
					:date,
					:date_time, 
					:user_id
               FROM SY_ACC_ENTITY_LANG_VW
	           WHERE ACC_ENTITY_ID = :nd_facility
			   AND  LANGUAGE_ID    = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,\
'DD/MM/RRRR') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,USER into :b0,:b1,:b2,:b3,:b4  f\
rom SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b5 and LANGUAGE_ID=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )481;
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
    sqlstm.sqhstv[2] = (         void  *)&date;
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
	date.arr[date.len]					   = '\0';
	user_id.arr[user_id.len]               = '\0';
	}


print_hdr()

{
  open_chq_not_repl();
  nrptot_amt = 0;


					  while(fetch_chq_not_replace_cur() ==1)

					  { 
						 if(first)
						 {
						  strcpy(label.arr,loc_legend[24] );

						   print_head();

     						 first = 0;
						 }

				check_page_end(5,0);

				get_initialize();
				strcpy(nd_temp_date.arr,nrpbounced_date.arr);
				get_local_date_convn1();
				strcpy(date_convert.arr,nd_loc_date.arr);

				fprintf(fp," %-6d %-15s %-23s %-31.31s %-28.28s ",nslno,date_convert.arr,nrpcheque_no.arr,nrpslmt_doc_remarks.arr,nrppayer_name.arr);
				print_formated(nrpdoc_amt);
				fprintf(fp,"%-18s %-71.71s  "," ",nrpaction_reason_desc.arr);
				if(cnt == 1)
				fprintf(fp,"%11.11s \n",nrpext_acct_code.arr);
				else
				fprintf(fp," \n");
				get_initialize();
				strcpy(nd_temp_date.arr,nrpcheque_date.arr);
				get_local_date_convn1();
				strcpy(date_convert.arr,nd_loc_date.arr);

				fprintf(fp,"%6s  %-15s %-23s %-31s %-43s %-12s %-90s %11s  \n"," "," ",date_convert.arr," ",nrpln1_mail_add.arr," "," "," ");
				fprintf(fp,"%6s  %-15s %-23s %-31s %-43s %-12s %-87s %11s  \n"," "," ",nrpreceipt_no.arr," ",nrpln2_mail_add.arr," "," "," ");
				fprintf(fp,"%6s  %-15s %-23s %-31s %-43s %-12s %-87s %11s  \n"," "," "," "," ",nrpln3_mail_add.arr," "," "," ");
				fprintf(fp,"%6s  %-15s %-23s %-31s %-15s%-28s %-12s %-87s %11s  \n"," "," "," "," ",loc_legend[23],nrppostal_code.arr," "," "," ");

				/*fprintf(fp,"%3.3s  %-15.15s %-23.23s %-31.31s %-43.43s %-12.12s %-86.86s %11.11s  \n"," "," ",date_convert.arr," ",nrpln1_mail_add.arr," "," "," ");
				fprintf(fp,"%3.3s  %-15.15s %-23.23s %-31.31s %-43.43s %-12.12s %-86.86s %11.11s  \n"," "," ",nrpreceipt_no.arr," ",nrpln2_mail_add.arr," "," "," ");
				fprintf(fp,"%3.3s  %-15.15s %-23.23s %-31.31s %-43.43s %-12.12s %-86.86s %11.11s  \n"," "," "," "," ",nrpln3_mail_add.arr," "," "," ");
				fprintf(fp,"%3.3s  %-15.15s %-23.23s %-31.31s %-15.15s%-28.28s %-12.12s %-86.86s %11.11s  \n"," "," "," "," ",loc_legend[23],nrppostal_code.arr," "," "," ");*/

    				
				lctr = lctr + 5;
				nslno++;
				nrptot_amt=nrptot_amt+nrpdoc_amt;
				} 
				close_chq_not_repl();

						  strcpy(label.arr,loc_legend[24] );
					
				if(nrptot_amt != 0)
				 {
					  if (nslno >3)
					 {
						 fprintf(fp,"\f");
						 print_head();
					 }
					 else
					 { 
						
						 print_total_nrp();
						 fprintf(fp,"\f");
                    }
                  }

   lctr=0;
   label.arr[0] ='\0';
   replabel.arr[0] ='\0';
   remarklb.arr[0]	='\0';
   strcpy(label.arr,loc_legend[25] );
   first =1;
   open_chq_repl();
   rptot_amt =0;
   chqtot_amt =0;

	while(fetch_chq_replace_cur() == 1 )
	  {
   
	   
	 fetch_repl_cheque_desc();
	 if(first)
	 {
	  strcpy(replabel.arr,loc_legend[17]);
	  strcpy(remarklb.arr,loc_legend[20] );
	  print_head();
	  first = 0;
	 }
	    
   


	check_page_end(5,0);

    get_initialize();
	strcpy(nd_temp_date.arr,rpbounced_date.arr);
	get_local_date_convn1();
    strcpy(date_convert.arr,nd_loc_date.arr);

    fprintf(fp," %-6d %-15s %-23s %-31.31s %-28.28s ",slno,date_convert.arr,rpcheque_no.arr,rpslmt_doc_remarks.arr,rppayer_name.arr);
	print_formated(rpdoc_amt);
    fprintf(fp,"%19s%-75.75s "," ",rpaction_reason_desc.arr);
	if(cnt == 1)
	fprintf(fp,"%11s \n",rpext_acct_code.arr);
	else
    fprintf(fp," \n");
    
	get_initialize();
	strcpy(nd_temp_date.arr,rpcheque_date.arr);
	get_local_date_convn1();
    strcpy(date_convert.arr,nd_loc_date.arr);
	
    fprintf(fp,"%6s  %-15s %-23s %-31s %-43s %-12s %-90s %11s  \n"," "," ",date_convert.arr," ",rpln1_mail_add.arr," "," "," ");
    fprintf(fp,"%6s  %-15s %-23s %-31s %-43s %-12s %-87s %11s  \n"," "," ",rpreceipt_no.arr," ",rpln2_mail_add.arr," "," "," ");
    fprintf(fp,"%6s  %-15s %-23s %-31s %-43s %-12s %-87s %11s  \n"," "," "," "," ",rpln3_mail_add.arr," "," "," ");
    fprintf(fp,"%6s  %-15s %-23s %-31s %-15s%-28s %-12s %-87s %11s  \n"," "," "," "," ",loc_legend[23],rppostal_code.arr," "," "," ");
     
	lctr = lctr + 5;
	check_page_end(5,0);
    fprintf(fp,"%-24s%-23s %-31s %-45s   ",loc_legend[22],chrepl_Cheque_no.arr,chrepl_bank_name.arr,chpayer_name.arr);
	print_formated(chdoc_amt);
	fprintf(fp,"%-70s\n",chreplacement_Remarks.arr );
    
	if(chrepl_cheque_date.arr[0]!='\0')
	{
	get_initialize();
	strcpy(nd_temp_date.arr,chrepl_cheque_date.arr);
	get_local_date_convn1();
    strcpy(date_convert.arr,nd_loc_date.arr); 
	}
	fprintf(fp,"%-23s %-23s %-31s %-31s\n"," ",date_convert.arr," ",chln1_mail_add.arr);
	fprintf(fp,"%-23s %-23s %-31s %-31s\n"," ",chrepl_Receipt_no.arr," ",chln2_mail_add.arr);
    fprintf(fp,"%-23s %-23s %-31s %-31s\n"," "," "," ",chln3_mail_add.arr);
	fprintf(fp,"%-23s %-23s %-31s %-15s%-16s\n"," "," "," ",loc_legend[23],chpostal_code.arr);
	fprintf(fp,"\n");
	lctr = lctr + 6;
	slno++;
    rptot_amt = rptot_amt + rpdoc_amt;
	chqtot_amt = chqtot_amt+chdoc_amt;
	}

  

	 close_chq_repl();
	 			    if(nrptot_amt==0 && chqtot_amt ==0) 
				  { 
	  					 	  strcpy(label.arr,loc_legend[24] );
						  print_head();	 
						  print_total_nrp(); 

				  } 
     
	 	if (chqtot_amt !=0)  
		 { 
  	       print_total_chq();
		 }
 
  
	 label.arr[0] ='\0';
	 replabel.arr[0] ='\0';
	 remarklb.arr[0] ='\0';
	 

//	print_total_chq(); saikiran
 }





  /*if(first)
    print_head();

    if (slno > 1) 
   print_note();*/
       
   

end_of_rep()
{
	check_page_end(2,0);
	fprintf(fp,"\n\n %90s ",loc_legend[33]);
	fflush(fp);
	fclose(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00016.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00016.lis");
       proc_exit();
    }
}

print_page_header()
{ 


print_page_title();
fill_dash(225);
fprintf(fp,"\n");
fprintf(fp,"VER : 4.1 \n\n");
fprintf(fp,"           %s \n",loc_legend[32]);
fprintf(fp,"           ------------------- \n\n\n");
fprintf(fp,"\n\n");

    get_initialize();
	strcpy(nd_temp_date.arr,nd_mm_yyyy.arr);
	get_local_date_convn2();
	strcpy(date_convert.arr,nd_loc_date.arr);
   fprintf(fp,"                       %-50s : %-12s \n",loc_legend[29],date_convert.arr);
  if(strcmp(nd_option.arr,"1" )== 0)  
  {
    get_initialize();
	strcpy(nd_temp_date.arr,nd_mm_yyyy.arr);
	get_local_date_convn2();
	strcpy(date_convert.arr,nd_loc_date.arr);                              
   fprintf(fp,"                       %-50s : %-18s ",loc_legend[27],date_convert.arr);
   }
   else
   fprintf(fp,"                       %-50s : %-15s \n",loc_legend[28]," ");
   fprintf(fp,"\f");
    

}


print_head()
{
   
	print_page_title();
      fill_dash(225);
	  fprintf(fp," \n");
	 /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	     if (strcmp(nd_option.arr,"1") == 0)
		  {
		  get_initialize();
		  strcpy(nd_temp_date.arr,nd_mm_yyyy.arr);
		  get_local_date_convn2();
		  strcpy(date_convert.arr,nd_loc_date.arr);    
		  fprintf(fp," %s  %s \n\n",label.arr,date_convert.arr);
		  }
		 else
          fprintf(fp," %s  \n\n",label.arr);
	   	  fprintf(fp," %-6s %-17s    %188"," ",loc_legend[7]," ");
		 if( cnt ==1)
		  fprintf(fp,"     Kod \n");
		 else
          fprintf(fp," \n");
            fprintf(fp," %-6s %-15s %-23s %172s"," ",loc_legend[8],loc_legend[11]," ");
		 if( cnt ==1)
		  fprintf(fp,"  Hasil/ \n");
		 else
          fprintf(fp," \n");
		   
		  fprintf(fp," %-6s %-15s %-23s %-31s%-63s  %s"," ",loc_legend[9],loc_legend[12],loc_legend[14]," ",loc_legend[19]); 
		 if( cnt ==1)
		  fprintf(fp,"     Amanah/ \n");
		 else
          fprintf(fp," \n");
          fprintf(fp," %-6s %-15s %-23s %-31s %-28s%15s %18s  %s",loc_legend[6],loc_legend[10],loc_legend[13],loc_legend[15],loc_legend[16],loc_legend[18],replabel.arr,remarklb.arr);
		 if( cnt ==1)
		  fprintf(fp,"  Vot \n");
		 else
          fprintf(fp," \n");
         fill_dash(225);
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	fflush(fp);
	fprintf(fp," \n");
	lctr = 12;


}


print_page_title()
{

	int hosp_nm_len, rep_title_len = 10, s1, s2,date_len,user_len,pgm_len;
	char v_rep_title[200],v_as_on_date[12];
  
	//Code for Line 1

	fprintf(fp,"\n");
	fprintf(fp,"%-13s :%s",loc_legend[30],loc_legend[34]);
	hosp_nm_len  = hosp_name.len;
    s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-12);
	fprintf(fp,"%s", hosp_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
    horz_skip(s2-(strlen(loc_legend[3])+strlen(date.arr)+14));
	get_initialize();
	strcpy(nd_temp_date.arr,date.arr);
	get_local_date_convn1();
	strcpy(date_convert.arr,nd_loc_date.arr);
	fprintf(fp,"%s : %s\n", loc_legend[3],date_convert.arr);
   
	 
	//Code for Line 2
	
    fprintf(fp,"%-13s : %s",loc_legend[31],user_id.arr);
    user_len=strlen(user_id.arr);
    strcpy(v_rep_title,loc_legend[26]);	
	rep_title_len = strlen(v_rep_title)+strlen(nd_mm_yyyy.arr);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-user_len-7);
	get_initialize();
	strcpy(nd_temp_date.arr,nd_mm_yyyy.arr);
	get_local_date_convn2();
	strcpy(date_convert.arr,nd_loc_date.arr);
	fprintf(fp,"%s %-s",v_rep_title,date_convert.arr);
	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-(strlen(loc_legend[4])+strlen(date_time.arr)+19));
	fprintf(fp,"%s : %s\n",loc_legend[4],date_time.arr);

    //Code for Line 3
 
	fprintf(fp,"%-13s : %s",loc_legend[2],d_curr_pgm_name.arr);
    pgm_len=strlen(d_curr_pgm_name.arr);

	s1 = (REP_WIDTH)/2;
  	horz_skip(s1-6-pgm_len);
     s2 = REP_WIDTH-s1;
    horz_skip(s2-(strlen(loc_legend[5])+27));
	fprintf(fp,"%s : %-d\n",loc_legend[5],++pctr);
		
}



fill_dash(flg)
{
  int i;
  for (i=1;i<=flg;i++)
	fprintf(fp,"%s","-");
}

/*print_total_rp()
{
    check_page_end(3,0);
	fprintf(fp,"%-100s "," ");
    fill_dash(35);
	fprintf(fp,"\n");
	fprintf(fp,"%-100s "," ");
	fprintf(fp,"Total");
	print_formated(rptot_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-100s "," ");
	fill_dash(35);
	fprintf(fp,"\n");
	
	lctr=lctr+3; 
	check_page_end(1,0);
	fprintf(fp,"\n");
	lctr=lctr+1; 

}  */ 

print_total_chq()
{
   
	check_page_end(3,0);
	fprintf(fp,"%-104s "," ");
	fill_dash(37);
    fprintf(fp," \n");
	fprintf(fp,"%-90s "," ");
	fprintf(fp,"%-15s   ",loc_legend[21]);
	print_formated(rptot_amt);
	fprintf(fp,"%-3s"," ");
	print_formated(chqtot_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-104s "," ");
	fill_dash(37);
    fprintf(fp,"\n");
	lctr=lctr+3; 
	check_page_end(1,0);
	fprintf(fp,"\n");
	lctr=lctr+1; 

}   


print_total_nrp()
{
 
	check_page_end(3,0);
	fprintf(fp,"%-103s "," ");
	fill_dash(19);
	fprintf(fp,"\n");
	fprintf(fp,"%-94s "," ");
	fprintf(fp,"%-13s ",loc_legend[21]);
	print_formated(nrptot_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-103s "," ");
	fill_dash(19);
	fprintf(fp,"\n");
	lctr=lctr+3; 
	check_page_end(1,0);
	fprintf(fp,"\n");
	lctr=lctr+1; 

}   


horz_skip(num) /* this is to obtain required blank space */
int num;
	{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
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

	if((lctr+l_lead_lines)>= 35) //42
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

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00016.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00016.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )524;
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
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )547;
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

get_local_date1()
{

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'dd/mm/yyyy'),:p_language_id,t_date);
															
		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'dd/mm/yyyy' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )578;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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
 sqlstm.sqhstl[2] = (unsigned int  )22;
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

get_local_date2()
{

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'mm/yyyy'),:p_language_id,t_date);
	    :nd_loc_date := to_char(t_date,'mm/yyyy');
	
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'mm/yyyy' ) , :p_language_id , t_date ) ;\
 :nd_loc_date := to_char ( t_date , 'mm/yyyy' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )605;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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
 sqlstm.sqhstl[2] = (unsigned int  )22;
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


	
	nd_loc_date.arr[nd_loc_date.len] = '\0';

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");
}

get_initialize()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
}
  
get_local_date_convn1()
{

nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date1();

}

get_local_date_convn2()
{

nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date2();

}