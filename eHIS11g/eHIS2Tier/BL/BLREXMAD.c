
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLREXMAD.PC"
};


static unsigned int sqlctx = 1288467435;


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
            void  *sqhstv[23];
   unsigned int   sqhstl[23];
            int   sqhsts[23];
            void  *sqindv[23];
            int   sqinds[23];
   unsigned int   sqharm[23];
   unsigned int   *sqharc[23];
   unsigned short  sqadto[23];
   unsigned short  sqtdso[23];
} sqlstm = {12,23};

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

 static const char *sq0009 = 
"led_date ,b.doc_amt ,to_char(a.cancelled_date,'DD/MM/YYYY') ,a.patient_id ,a\
dj_exm_doc_ref ,to_char(adj_exm_doc_ref_date,'DD/MM/YYYY') ,a.reason_code ,a.r\
emarks ,instr(a.remarks,' ') ,'Y'  from bl_bill_adj_hdr_canc a ,bl_bill_adj_hd\
r b where ((((((((a.doc_type_code=b.doc_type_code and a.doc_num=b.doc_num) and\
 a.operating_facility_id=:b0) and b.adjust_exempt_ind=nvl(:b1,b.adjust_exempt_\
ind)) and :b2='Y') and a.reason_code=decode(:b3,'!!!!',a.reason_code,:b3)) and\
 trunc(cancelled_date) between to_date(nvl(:b5,'01/01/1401'),'DD/MM/YYYY') and\
 nvl(to_date(:b6,'DD/MM/YYYY'),sysdate)) and a.doc_type_code=:b7) and a.doc_nu\
m between nvl(to_number(:b8),0) and nvl(to_number(:b9),99999999)) order by d_t\
ype,d_num            ";

 static const char *sq0010 = 
"select ((adj_doc_type_code||'/')||to_char(adj_doc_num)) ,adj_doc_date ,doc_a\
mt ,to_char(adj_doc_date,'DD/MM/YYYY') ,bill_out_amt_bef_adj_exm  from bl_bill\
_adj_dtl where ((operating_facility_id=:b0 and doc_type_code=:b1) and doc_num=\
:b2) order by 2            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,131,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,47,0,4,142,0,0,1,0,0,1,0,2,9,0,0,
55,0,0,3,198,0,4,184,0,0,12,3,0,1,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
118,0,0,4,84,0,2,216,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
145,0,0,5,109,0,6,241,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
172,0,0,6,47,0,4,251,0,0,1,0,0,1,0,2,9,0,0,
191,0,0,7,109,0,6,254,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
218,0,0,8,0,0,30,266,0,0,0,0,0,1,0,
233,0,0,9,1745,0,9,348,0,0,23,23,0,1,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,
0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
340,0,0,10,259,0,9,357,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,4,0,0,
367,0,0,10,0,0,15,365,0,0,0,0,0,1,0,
382,0,0,11,69,0,4,374,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
405,0,0,12,199,0,6,404,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
432,0,0,9,0,0,13,451,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,1,0,0,
499,0,0,13,462,0,6,484,0,0,4,4,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
530,0,0,10,0,0,13,525,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,
565,0,0,14,147,0,4,707,0,0,4,3,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,4,0,0,
596,0,0,15,225,0,4,875,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,1,9,0,0,
643,0,0,16,106,0,4,918,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
670,0,0,17,176,0,4,947,0,0,4,2,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,
701,0,0,18,756,0,6,960,0,0,6,6,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,
740,0,0,19,96,0,4,1064,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
763,0,0,20,162,0,6,1071,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLREXMAD.PC                                  */
/* AUTHOR                : Jagwinder Kaur                               */  
/* DATE WRITTEN          : 06/06/2004                                   */      
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
#define ESC     0x1B
/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hosp_name                       [120],
			l_acc_name						[120],
			date							[20],
			nd_date							[20],
            date_time                       [20],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility				        [3],
			nd_rep_id						[9],
			bl_doc_no						[16],
			bl_doc_type_code				[7],
			bl_adj_doc_no					[16],
			old_doc_no						[16],
			bl_doc_date						[11],
			nd_bl_doc_date					[20],
			bl_adj_doc_date					[11],
			nd_bl_adj_doc_date				[20],
			bl_patient_no					[21],
			bl_patient_name					[61],
			bl_adj_exm_doc_ref				[31],
			bl_adj_exm_doc_date				[11],
			nd_bl_adj_exm_doc_date			[20],
			bl_reason_code					[5],
			bl_reason_desc					[4000],
			bl_reason_desc1					[100],
			bl_reason_desc2					[100],
			bl_reason_desc3					[100],
			bl_reason_desc4					[100],
			bl_reason_desc5					[100],
			bl_remarks						[1000],
			bl_remarks1						[200],
			bl_remarks2						[200],
			bl_remarks3						[200],
			nd_fm_date						[11],
			nd_fm_loc_date 					[20],
			nd_to_loc_date					[20],
			nd_to_date						[11],
			nd_reason_code					[5],
			nd_doc_type						[7],
			nd_fm_doc_num					[9],
			nd_to_doc_num					[9],
			old_doc_date					[11],
			nd_old_doc_date					[20],
			l_translated_value				[201],
			l_cash_book_acc_desc			[16],
			l_pk_value						[100],
			tmp_date						[11],
			nd_temp_date					[20],
			tmp_adj_date					[11],
			nd_temp_adj_date				[20],
			nd_loc_date						[20],
			language_id						[3],
			nd_base_curr					[7],
			base_curr						[7],
			p_language_id					[3],
			uid								[50],
			P_START_TIME					[60] ; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[120]; } l_acc_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } nd_date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[9]; } nd_rep_id;

struct { unsigned short len; unsigned char arr[16]; } bl_doc_no;

struct { unsigned short len; unsigned char arr[7]; } bl_doc_type_code;

struct { unsigned short len; unsigned char arr[16]; } bl_adj_doc_no;

struct { unsigned short len; unsigned char arr[16]; } old_doc_no;

struct { unsigned short len; unsigned char arr[11]; } bl_doc_date;

struct { unsigned short len; unsigned char arr[20]; } nd_bl_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bl_adj_doc_date;

struct { unsigned short len; unsigned char arr[20]; } nd_bl_adj_doc_date;

struct { unsigned short len; unsigned char arr[21]; } bl_patient_no;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[31]; } bl_adj_exm_doc_ref;

struct { unsigned short len; unsigned char arr[11]; } bl_adj_exm_doc_date;

struct { unsigned short len; unsigned char arr[20]; } nd_bl_adj_exm_doc_date;

struct { unsigned short len; unsigned char arr[5]; } bl_reason_code;

struct { unsigned short len; unsigned char arr[4000]; } bl_reason_desc;

struct { unsigned short len; unsigned char arr[100]; } bl_reason_desc1;

struct { unsigned short len; unsigned char arr[100]; } bl_reason_desc2;

struct { unsigned short len; unsigned char arr[100]; } bl_reason_desc3;

struct { unsigned short len; unsigned char arr[100]; } bl_reason_desc4;

struct { unsigned short len; unsigned char arr[100]; } bl_reason_desc5;

struct { unsigned short len; unsigned char arr[1000]; } bl_remarks;

struct { unsigned short len; unsigned char arr[200]; } bl_remarks1;

struct { unsigned short len; unsigned char arr[200]; } bl_remarks2;

struct { unsigned short len; unsigned char arr[200]; } bl_remarks3;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[20]; } nd_fm_loc_date;

struct { unsigned short len; unsigned char arr[20]; } nd_to_loc_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[5]; } nd_reason_code;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[11]; } old_doc_date;

struct { unsigned short len; unsigned char arr[20]; } nd_old_doc_date;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[16]; } l_cash_book_acc_desc;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[11]; } tmp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[11]; } tmp_adj_date;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_adj_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[3]; } language_id;

struct { unsigned short len; unsigned char arr[7]; } nd_base_curr;

struct { unsigned short len; unsigned char arr[7]; } base_curr;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[50]; } uid;

struct { unsigned short len; unsigned char arr[60]; } P_START_TIME;


double      bl_doc_amt,bl_adj_doc_amt,bl_outst_amt,bl_doc_num,tot_adj_doc_amt,bl_adj_amt;
			
int i,null_place,null_remark;
char nd_adj_stat;
char nd_trn_type;
char bl_cancel_flag;
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char fm_date[11],to_date[11],TEMP[10];
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
 
    strcpy(g_pgm_id,"BLREXMAD");
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

		/* EXEC SQL select GET_TRACE_TIMESTAMP
			 into :P_START_TIME from dual; */ 

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
  sqlstm.sqhstv[0] = (         void  *)&P_START_TIME;
  sqlstm.sqhstl[0] = (unsigned int  )62;
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

		strcpy(nd_rep_id.arr,argv[5]);
		nd_rep_id.len = strlen(nd_rep_id.arr);
    	
		nd_fm_date.arr[0]		= '\0';
		nd_to_date.arr[0]		= '\0';
		nd_reason_code.arr[0]	= '\0';
		nd_doc_type.arr[0]		= '\0';
		nd_fm_doc_num.arr[0]	= '\0';
		nd_to_doc_num.arr[0]	= '\0';
		uid.arr[0]				= '\0';
				
		nd_fm_date.len		= 0;
		nd_to_date.len		= 0;
		nd_reason_code.len	= 0;
		nd_doc_type.len		= 0;
		nd_fm_doc_num.len	= 0;
		nd_to_doc_num.len	= 0;
		uid.len				= 0;
	
		/* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM7,PARAM8,PARAM11
				INTO	:nd_trn_type,
						:nd_reason_code,
						:nd_fm_date,
						:nd_to_date,
						:nd_doc_type,
						:nd_fm_doc_num,
						:nd_to_doc_num,
						:nd_adj_stat,
						:uid
			  FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PARA\
M7 ,PARAM8 ,PARAM11 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from SY_PROG_PAR\
AM where ((PGM_ID=:b9 and SESSION_ID=:b10) and PGM_DATE=:b11)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )55;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_trn_type;
  sqlstm.sqhstl[0] = (unsigned int  )1;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_reason_code;
  sqlstm.sqhstl[1] = (unsigned int  )7;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_doc_type;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_num;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_num;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_adj_stat;
  sqlstm.sqhstl[7] = (unsigned int  )1;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&uid;
  sqlstm.sqhstl[8] = (unsigned int  )52;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_curr_pgm_name;
  sqlstm.sqhstl[9] = (unsigned int  )17;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
  sqlstm.sqhstl[10] = (unsigned int  )18;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[11] = (unsigned int  )27;
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


		


   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

		nd_reason_code.arr[nd_reason_code.len]	= '\0';
		nd_fm_date.arr[nd_fm_date.len]			= '\0';
		nd_to_date.arr[nd_to_date.len]			= '\0';
		nd_doc_type.arr[nd_doc_type.len]		= '\0';
		nd_fm_doc_num.arr[nd_fm_doc_num.len]	= '\0';
		nd_to_doc_num.arr[nd_to_doc_num.len]	= '\0';
		uid.arr[uid.len]						= '\0';
		

	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )118;
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

		get_language_id();

    	fetch_hosp_name();

		fetch_legend_value();

    	open_file();

	//	print_head();		

		open_hdr();
        
	    print_hdr();


	/* EXEC SQL EXECUTE
	BEGIN	
		TRACE_DURATION_BL(
		 :nd_rep_id ,
		 'Adjustment Document Report Spooling' ,
		 :P_START_TIME ,
		 :uid );
	  END;
	  END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin TRACE_DURATION_BL ( :nd_rep_id , 'Adjustment Document \
Report Spooling' , :P_START_TIME , :uid ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )145;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_rep_id;
 sqlstm.sqhstl[0] = (unsigned int  )11;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&P_START_TIME;
 sqlstm.sqhstl[1] = (unsigned int  )62;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&uid;
 sqlstm.sqhstl[2] = (unsigned int  )52;
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



	/* EXEC SQL select GET_TRACE_TIMESTAMP
			 into :P_START_TIME from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GET_TRACE_TIMESTAMP into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )172;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&P_START_TIME;
 sqlstm.sqhstl[0] = (unsigned int  )62;
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


	    end_of_rep();
	/* EXEC SQL EXECUTE
	BEGIN	
		TRACE_DURATION_BL(
		 :nd_rep_id ,
		 'Adjustment Document Report Printing' ,
		 :P_START_TIME ,
		 :uid );
	  END;
	  END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin TRACE_DURATION_BL ( :nd_rep_id , 'Adjustment Document \
Report Printing' , :P_START_TIME , :uid ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )191;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_rep_id;
 sqlstm.sqhstl[0] = (unsigned int  )11;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&P_START_TIME;
 sqlstm.sqhstl[1] = (unsigned int  )62;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&uid;
 sqlstm.sqhstl[2] = (unsigned int  )52;
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


		close_dtl();


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )218;
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
	

	/* EXEC SQL DECLARE ADJ_HDR_CUR CURSOR FOR 
	select	doc_type_code||'/'||to_char(doc_num) document,
			doc_type_code d_type,
			doc_num d_num,
			doc_date,
			doc_amt,
			to_char(doc_date,'DD/MM/YYYY'),
			patient_id,
			adj_exm_doc_ref,
			to_char(adj_exm_doc_ref_date,'DD/MM/YYYY'),
			reason_code,
			remarks,
			instr(remarks,' '),
			'N'
			from bl_bill_adj_hdr 
			where operating_facility_id=:nd_facility
			and adjust_exempt_ind = nvl(:nd_trn_type,adjust_exempt_ind)
			//and nvl(cancelled_yn,'N') = NVL(:nd_adj_stat,nvl(cancelled_yn,'N'))
			and :nd_adj_stat = 'N'
			and reason_code = decode(:nd_reason_code,'!!!!',reason_code,:nd_reason_code)
			and trunc(doc_date) between to_date(nvl(:nd_fm_date,'01/01/1401'),'DD/MM/YYYY') and nvl(to_date(:nd_to_date,'DD/MM/YYYY'),sysdate)
			and doc_type_code = :nd_doc_type
			and doc_num between nvl(to_number(:nd_fm_doc_num),0) and nvl(to_number(:nd_to_doc_num),99999999)
			and (doc_type_code,doc_num) not in(select doc_type_code,doc_num
									from bl_bill_adj_dtl_canc 
									where operating_facility_id=:nd_facility
									and trunc(cancelled_date) between to_date(nvl(:nd_fm_date,'01/01/1401'),'DD/MM/YYYY') and nvl(to_date(:nd_to_date,'DD/MM/YYYY'),sysdate))
	
	UNION
	select	a.doc_type_code||'/'||to_char(a.doc_num) document,
			a.doc_type_code d_type,
			a.doc_num d_num,
			a.cancelled_date,
			b.doc_amt,
			to_char(a.cancelled_date,'DD/MM/YYYY'),
			a.patient_id,
			adj_exm_doc_ref,
			to_char(adj_exm_doc_ref_date,'DD/MM/YYYY'),
			a.reason_code,
			a.remarks,
			instr(a.remarks,' '),
			'Y'
			from bl_bill_adj_hdr_canc a,bl_bill_adj_hdr b
			where a.doc_type_code=b.doc_type_code
			and a.doc_num = b.doc_num
			and a.operating_facility_id=:nd_facility
			and b.adjust_exempt_ind = nvl(:nd_trn_type,b.adjust_exempt_ind)
			and :nd_adj_stat = 'Y'
			and a.reason_code = decode(:nd_reason_code,'!!!!',a.reason_code,:nd_reason_code)
			and trunc(cancelled_date) between to_date(nvl(:nd_fm_date,'01/01/1401'),'DD/MM/YYYY') and nvl(to_date(:nd_to_date,'DD/MM/YYYY'),sysdate)
			and a.doc_type_code = :nd_doc_type
			and a.doc_num between nvl(to_number(:nd_fm_doc_num),0) and nvl(to_number(:nd_to_doc_num),99999999)
			order by d_type,d_num; */ 


	/* EXEC SQL DECLARE ADJ_DTL_CUR CURSOR FOR 
	select	adj_doc_type_code||'/'||to_char(adj_doc_num),
			adj_doc_date,
			doc_amt,
			to_char(adj_doc_date,'DD/MM/YYYY'),
			bill_out_amt_bef_adj_exm
			from bl_bill_adj_dtl 
			where operating_facility_id=:nd_facility
			and doc_type_code = :bl_doc_type_code
			and doc_num = :bl_doc_num
			order by 2; */ 


}



open_hdr() 
{

    /* EXEC SQL OPEN ADJ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select ((doc_type_code||'/')||to_char(doc_num)) document ,doc_type_co\
de d_type ,doc_num d_num ,doc_date ,doc_amt ,to_char(doc_date,'DD/MM/YYYY') \
,patient_id ,adj_exm_doc_ref ,to_char(adj_exm_doc_ref_date,'DD/MM/YYYY') ,re\
ason_code ,remarks ,instr(remarks,' ') ,'N'  from bl_bill_adj_hdr where ((((\
(((operating_facility_id=:b0 and adjust_exempt_ind=nvl(:b1,adjust_exempt_ind\
)) and :b2='N') and reason_code=decode(:b3,'!!!!',reason_code,:b3)) and trun\
c(doc_date) between to_date(nvl(:b5,'01/01/1401'),'DD/MM/YYYY') and nvl(to_d\
ate(:b6,'DD/MM/YYYY'),sysdate)) and doc_type_code=:b7) and doc_num between n\
vl(to_number(:b8),0) and nvl(to_number(:b9),99999999)) and (doc_type_code,do\
c_num) not  in (select doc_type_code ,doc_num  from bl_bill_adj_dtl_canc whe\
re (operating_facility_id=:b0 and trunc(cancelled_date) between to_date(nvl(\
:b5,'01/01/1401'),'DD/MM/YYYY') and nvl(to_date(:b6,'DD/MM/YYYY'),sysdate)))\
) union select ((a.doc_type_code||'/')||to_char(a.doc_num)) document ,a.doc_\
type_code d_type ,a.doc_num d_num ,a.cancel");
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )233;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_trn_type;
    sqlstm.sqhstl[1] = (unsigned int  )1;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_adj_stat;
    sqlstm.sqhstl[2] = (unsigned int  )1;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_reason_code;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_reason_code;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_doc_type;
    sqlstm.sqhstl[7] = (unsigned int  )9;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_fm_doc_num;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[9] = (unsigned int  )11;
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
    sqlstm.sqhstv[11] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[12] = (unsigned int  )13;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_facility;
    sqlstm.sqhstl[13] = (unsigned int  )5;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_trn_type;
    sqlstm.sqhstl[14] = (unsigned int  )1;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_adj_stat;
    sqlstm.sqhstl[15] = (unsigned int  )1;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_reason_code;
    sqlstm.sqhstl[16] = (unsigned int  )7;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_reason_code;
    sqlstm.sqhstl[17] = (unsigned int  )7;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[18] = (unsigned int  )13;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[19] = (unsigned int  )13;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_doc_type;
    sqlstm.sqhstl[20] = (unsigned int  )9;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&nd_fm_doc_num;
    sqlstm.sqhstl[21] = (unsigned int  )11;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[22] = (unsigned int  )11;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
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
         err_mesg("OPEN failed on cursor ADJ_HDR_CUR",0,"");

}

open_dtl() 
{

	/* EXEC SQL OPEN ADJ_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0010;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )340;
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
 sqlstm.sqhstv[1] = (         void  *)&bl_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_doc_num;
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
         err_mesg("OPEN failed on cursor ADJ_DTL_CUR",0,"");
}

close_dtl() 
{

	/* EXEC SQL CLOSE ADJ_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )367;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

get_language_id()
{
	language_id.arr[0] = '\0';
	language_id.len = 0;
	
	/* EXEC SQL SELECT LANGUAGE_ID INTO :language_id FROM SM_APPL_USER where APPL_USER_ID = :user_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LANGUAGE_ID into :b0  from SM_APPL_USER where APPL_US\
ER_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )382;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&user_id;
 sqlstm.sqhstl[1] = (unsigned int  )93;
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
        err_mesg("SELECTING LANGUAGE_ID failed",0,"");
}

init_date_temp_var()

{
	nd_temp_date.arr[0] = '\0';
	nd_loc_date.arr[0]  = '\0';

	nd_temp_date.len = 0;
	nd_loc_date.len  = 0;

}

fun_change_loc_date()
{

nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';
get_local_date();

}


get_local_date()
{

	/* EXEC SQL EXECUTE
	
	DECLARE
    
	t_date date;	

	BEGIN
		get_locale_date.convert_to_locale_date(TO_DATE(:nd_temp_date,'dd/mm/yyyy'),
					 :p_language_id,
					  t_date);

		:nd_loc_date:=to_char(t_date,'DD/MM/YYYY');
	
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( TO_DATE ( :nd_temp_date , 'dd/mm/yyyy' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )405;
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


fetch_hdr()
{

bl_doc_no.arr[0]			= '\0';
bl_doc_date.arr[0]			= '\0';
bl_patient_no.arr[0]		= '\0';
bl_adj_exm_doc_ref.arr[0]	= '\0';
bl_adj_exm_doc_date.arr[0]	= '\0';
bl_reason_code.arr[0]		= '\0';
bl_remarks.arr[0]			= '\0';
bl_remarks1.arr[0]			= '\0';
bl_remarks2.arr[0]			= '\0';
bl_remarks3.arr[0]			= '\0';

bl_doc_no.len			= 0;
bl_doc_date.len			= 0;
bl_patient_no.len		= 0;
bl_adj_exm_doc_ref.len	= 0;
bl_adj_exm_doc_date.len	= 0;
bl_reason_code.len		= 0;
bl_remarks.len			= 0;
bl_remarks1.len			= 0;
bl_remarks2.len			= 0;
bl_remarks3.len			= 0;
bl_doc_amt              = 0;

      /* EXEC SQL FETCH ADJ_HDR_CUR
               INTO :bl_doc_no,
					:bl_doc_type_code,
					:bl_doc_num,
					:tmp_date,
					:bl_doc_amt,
					:bl_doc_date,
					:bl_patient_no,
					:bl_adj_exm_doc_ref,
					:bl_adj_exm_doc_date,
					:bl_reason_code,
					:bl_remarks,
					:null_remark,
					:bl_cancel_flag; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 23;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )432;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&bl_doc_no;
      sqlstm.sqhstl[0] = (unsigned int  )18;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&tmp_date;
      sqlstm.sqhstl[3] = (unsigned int  )13;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_doc_amt;
      sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_doc_date;
      sqlstm.sqhstl[5] = (unsigned int  )13;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_patient_no;
      sqlstm.sqhstl[6] = (unsigned int  )23;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bl_adj_exm_doc_ref;
      sqlstm.sqhstl[7] = (unsigned int  )33;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&bl_adj_exm_doc_date;
      sqlstm.sqhstl[8] = (unsigned int  )13;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&bl_reason_code;
      sqlstm.sqhstl[9] = (unsigned int  )7;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&bl_remarks;
      sqlstm.sqhstl[10] = (unsigned int  )1002;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&null_remark;
      sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&bl_cancel_flag;
      sqlstm.sqhstl[12] = (unsigned int  )1;
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



       if (OERROR)
            err_mesg("FETCH failed on cursor ADJ_HDR_CUR",0,"");

bl_doc_no.arr[bl_doc_no.len]					= '\0';
bl_doc_type_code.arr[bl_doc_type_code.len]		= '\0';
bl_doc_date.arr[bl_doc_date.len]				= '\0';
bl_patient_no.arr[bl_patient_no.len]			= '\0';
bl_adj_exm_doc_ref.arr[bl_adj_exm_doc_ref.len]	= '\0';
bl_adj_exm_doc_date.arr[bl_adj_exm_doc_date.len]= '\0';
bl_reason_code.arr[bl_reason_code.len]			= '\0';
bl_remarks.arr[bl_remarks.len]					= '\0';

    //return(LAST_ROW?0:1);
}

remarks_spl()
{

	/* EXEC SQL EXECUTE
	BEGIN
	declare
		str1   varchar2(4000);
		str2   varchar2(1000);
    
	 BEGIN
     blcommon.split_words(:bl_remarks,75,'*',1,str1,str2);
	    IF str2 IS NOT NULL THEN
         :bl_remarks1 := str2;
        END IF;
	 blcommon.split_words(:bl_remarks,75,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :bl_remarks2  := str2;
       END IF;
	 blcommon.split_words(:bl_remarks,75,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_remarks3    :=  str2;
        END IF;
     
	 END;
	 END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin declare str1 varchar2 ( 4000 ) ; str2 varchar2 ( 1000 \
) ; BEGIN blcommon . split_words ( :bl_remarks , 75 , '*' , 1 , str1 , str2 ) \
; IF str2 IS NOT NULL THEN :bl_remarks1 := str2 ; END IF ; blcommon . split_wo\
rds ( :bl_remarks , 75 , '*' , 2 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :b\
l_remarks2 := str2 ; END IF ; blcommon . split_words ( :bl_remarks , 75 , '*' \
, 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl_remarks3 := str2 ; END IF ;\
 END ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )499;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_remarks;
 sqlstm.sqhstl[0] = (unsigned int  )1002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_remarks1;
 sqlstm.sqhstl[1] = (unsigned int  )202;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_remarks2;
 sqlstm.sqhstl[2] = (unsigned int  )202;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_remarks3;
 sqlstm.sqhstl[3] = (unsigned int  )202;
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


		bl_remarks1.arr[bl_remarks1.len]  = '\0';
		bl_remarks2.arr[bl_remarks2.len]  = '\0';
		bl_remarks3.arr[bl_remarks3.len]  = '\0';
	}

fetch_dtl()
{

bl_adj_doc_no.arr[0]		= '\0';
bl_adj_doc_date.arr[0]		= '\0';

bl_adj_doc_no.len			= 0;
bl_adj_doc_date.len			= 0;


bl_adj_doc_amt   = 0;
bl_outst_amt     = 0;

      /* EXEC SQL FETCH ADJ_DTL_CUR
               INTO :bl_adj_doc_no,
					:tmp_adj_date,
					:bl_adj_doc_amt,
					:bl_adj_doc_date,
					:bl_outst_amt; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 23;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )530;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&bl_adj_doc_no;
      sqlstm.sqhstl[0] = (unsigned int  )18;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&tmp_adj_date;
      sqlstm.sqhstl[1] = (unsigned int  )13;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_adj_doc_amt;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_adj_doc_date;
      sqlstm.sqhstl[3] = (unsigned int  )13;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_outst_amt;
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



       if (OERROR)
            err_mesg("FETCH failed on cursor ADJ_DTL_CUR",0,"");

bl_adj_doc_no.arr[bl_adj_doc_no.len]		= '\0';
bl_adj_doc_date.arr[bl_adj_doc_date.len]	= '\0';

    return(LAST_ROW?0:1);
}


print_hdr()
{
  while(fetch_hdr())
  {
    calc_adj_amt();		
    fetch_patient_name();
	fetch_reason_desc();

	
	if (null_remark > 0) 
	remarks_spl();
	else
    strcpy(bl_remarks1.arr,bl_remarks.arr);

	tot_adj_doc_amt = 0;
    if(first)
	 {
	 print_head();
     strcpy(old_doc_no.arr,bl_doc_no.arr);
	 old_doc_no.len=strlen(old_doc_no.arr);
	 first = 0;
	 }

    if(strcmp(old_doc_no.arr,bl_doc_no.arr) != 0 )
      { 
	  fprintf(fp,"\n\f");
	  print_head();
      }
	
	 if(bl_doc_date.arr[0]!='\0')
	 {
	 init_date_temp_var();

	 strcpy(nd_temp_date.arr,bl_doc_date.arr);
     fun_change_loc_date();
	 strcpy(bl_doc_date.arr,nd_loc_date.arr);
	 }

	  fprintf(fp," %-15.15s : %-15s %-36.36s %-8.8s :%-11s\n\n",loc_legend[2],bl_doc_no.arr," ",loc_legend[3],bl_doc_date.arr); 
			
	fprintf(fp," %-15.15s : %s\n\n",loc_legend[4],bl_patient_no.arr);
	fprintf(fp," %-15.15s : %s\n\n",loc_legend[5],bl_patient_name.arr);  
	if (nd_trn_type == 'E')	
	{
	fprintf(fp," %-23.23s (%s):",loc_legend[6],base_curr.arr);
	print_formated(bl_doc_amt);
	}
	else
	{
	fprintf(fp," %-23.23s (%s):",loc_legend[19],base_curr.arr);
	print_formated(bl_adj_amt);
	}
	fprintf(fp,"\n\n"); 
	
	if(bl_adj_exm_doc_date.arr[0]!='\0')
	{

	init_date_temp_var();
	strcpy(nd_temp_date.arr,bl_adj_exm_doc_date.arr);
	fun_change_loc_date();
	strcpy(bl_adj_exm_doc_date.arr,nd_loc_date.arr);
	}

	fprintf(fp," %-25.25s : %-41.41s ",loc_legend[15],bl_adj_exm_doc_ref.arr);
	fprintf(fp," %-9.9s: %-20.20s\n\n",loc_legend[7],bl_adj_exm_doc_date.arr);
	
		

	if (nd_trn_type == 'E')	
	fprintf(fp," %-25.25s : %-60.60s\n",loc_legend[8],bl_reason_desc1.arr);
    else
	fprintf(fp," %-25.25s : %-60.60s\n",loc_legend[20],bl_reason_desc1.arr);

	if(bl_reason_desc2.arr[0] != '\0')
	fprintf(fp," %-25.25s   %-60.60s\n"," ",bl_reason_desc2.arr);

	if(bl_reason_desc3.arr[0] != '\0')
	fprintf(fp," %-25.25s   %-60.60s\n"," ",bl_reason_desc3.arr);

	if(bl_reason_desc4.arr[0] != '\0')
	fprintf(fp," %-25.25s   %-60.60s\n"," ",bl_reason_desc4.arr);

	if(bl_reason_desc5.arr[0] != '\0')
	fprintf(fp," %-25.25s   %-60.60s\n"," ",bl_reason_desc5.arr);

	fprintf(fp," \n");
	fprintf(fp," %-8.8s : %-75.75s\n",loc_legend[9],bl_remarks1.arr);

	if(bl_remarks2.arr[0] != '\0')
	fprintf(fp," %-8.8s   %-75.75s\n"," ",bl_remarks2.arr);

	if(bl_remarks3.arr[0] != '\0')
	fprintf(fp," %-8.8s   %-75.75s\n"," ",bl_remarks3.arr);
    fprintf(fp," \n");
	if(nd_trn_type == 'E')
	fprintf(fp," %-50.50s \n",loc_legend[10]);
	else
	fprintf(fp," %-50.50s \n",loc_legend[23]);
    fill_dash(93);
    fprintf(fp,"\n");
	if(nd_trn_type == 'E')
	fprintf(fp," %-20.20s %-15.15s %23.23s   %21.21s(%s)\n",loc_legend[11],loc_legend[3],loc_legend[13],loc_legend[12],base_curr.arr);
	else
	fprintf(fp," %-20.20s %-15.15s %23.23s   %21.21s(%s)\n",loc_legend[11],loc_legend[3],loc_legend[13],loc_legend[21],base_curr.arr);
	fill_dash(93);
	fprintf(fp,"\n");
	lctr = lctr + 26;
	open_dtl();
    print_det();
	check_page_end(4,0);
	fprintf(fp,"%-70.70s"," ");
    fill_dash(15);
	fprintf(fp,"\n");
	fprintf(fp,"%68.68s  ",loc_legend[24]);
	print_formated(tot_adj_doc_amt);
	fprintf(fp,"\n");
	fprintf(fp,"%-70.70s"," ");
    fill_dash(15);
	close_dtl();
	strcpy(old_doc_no.arr,bl_doc_no.arr);
	old_doc_no.len=strlen(old_doc_no.arr);

	 }
 
	
}   

print_det()
{
while(fetch_dtl())
   {
    
	check_page_end(1,0);

	
	
	if(bl_adj_doc_date.arr[0]!='\0')
	{
	
	init_date_temp_var();

	strcpy(nd_temp_date.arr,bl_adj_doc_date.arr);

	fun_change_loc_date();

	strcpy(bl_adj_doc_date.arr,nd_loc_date.arr);
	}

	fprintf(fp," %-20.20s %-20.20s    ",bl_adj_doc_no.arr,bl_adj_doc_date.arr); 
	print_formated(bl_outst_amt);
	fprintf(fp,"%7.7s"," ");
	print_formated(bl_adj_doc_amt);
	fprintf(fp,"\n");
	lctr++; 
	
	tot_adj_doc_amt = tot_adj_doc_amt + bl_adj_doc_amt;

	
   }	
}
   
calc_adj_amt()
{
bl_adj_amt = 0;

	/* EXEC SQL select	sum(nvl(doc_amt,0))
		    into :bl_adj_amt
			from bl_bill_adj_dtl 
			where operating_facility_id=:nd_facility
			and doc_type_code = :bl_doc_type_code
			and doc_num = :bl_doc_num
			and doc_amt>0; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select sum(nvl(doc_amt,0)) into :b0  from bl_bill_adj_dtl wh\
ere (((operating_facility_id=:b1 and doc_type_code=:b2) and doc_num=:b3) and d\
oc_amt>0)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )565;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_adj_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
 sqlstm.sqhstv[2] = (         void  *)&bl_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_doc_num;
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


end_of_rep()
{
	check_page_end(3,0);
	fprintf(fp,"\n\n %35.35s   %s\n\f"," ",loc_legend[28]);
	fflush(fp);
    fclose(fp);
    
	PrintDocument
	(
		nd_pwd.arr,				//char	*PUidPwd;
		nd_session_id.arr,		//char	*PSessionID;
		nd_facility.arr,		//char	*PFacilityID;
		"BL",					//char	*PModuleID;
		nd_rep_id.arr,			//char	*PDocumentID;
		filename,				//char	*POnlinePrintFileNames;
		"O",					//char	*PLocationTypes;
		" ",					//char	*PLocationCodes;
		1,						//int	PNumOfCopies;
		1,						//int	PPageFrom;
		9999					//int	PPageTo;
	 );
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLREXMAD.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLREXMAD.lis");
       proc_exit();
    }

}

print_page_header()
{

    if (nd_fm_date.arr[0] == '\0')
	  strcpy(fm_date,loc_legend[31]);
    else
	  strcpy(fm_date,nd_fm_date.arr);

	if (nd_to_date.arr[0] == '\0')
	  strcpy(to_date,loc_legend[32]);
    else
	  strcpy(to_date,nd_to_date.arr);




print_page_title();
fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1 \n\n\n\n");
fprintf(fp,"           %s \n",loc_legend[33]);
fprintf(fp,"           --------------- \n\n\n\n");
fprintf(fp,"				%s                  : ",loc_legend[34]);

if (nd_trn_type == 'R')
fprintf(fp,"%s",loc_legend[35]);
else
fprintf(fp,"%s",loc_legend[36]);
fprintf(fp,"\n\n");

fprintf(fp,"				%s     %s             : %s\n",loc_legend[37],loc_legend[38],fm_date);
fprintf(fp,"				                 %s               : %s\n\n",loc_legend[39],to_date);
fprintf(fp,"\f");
}


print_head()
{
	print_page_title();
	if (nd_trn_type == 'E')
	{
    if (bl_cancel_flag == 'Y')
	fprintf(fp,"%-37.37s%s"," ",loc_legend[1]);
	else
	fprintf(fp,"%-37.37s%s"," ",loc_legend[1]);
	}
	else
	{
	if (bl_cancel_flag == 'Y')
    
	 fprintf(fp,"%-37.37s%s"," ",loc_legend[18]);    

	else
    
     fprintf(fp,"%-37.37s%s"," ",loc_legend[18]);                                  
		
	}
	fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 			*/		
		if (bl_cancel_flag == 'Y')
		{
		fprintf(fp,"(");
		fprintf(fp,"%c&d0D",ESC); /* set Underline mode */
		fprintf(fp,"%-s",loc_legend[17]);
		fprintf(fp,"%c&d@",ESC); /* release underline mode */
		fprintf(fp,")");
		}
	fprintf(fp,"%c(s-3B",ESC); /* release bold style */	
	fprintf(fp,"\n\n");	
	lctr = 3;
}

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;

	l_report_width=90;
	l_acc_entity_length = strlen(hosp_name.arr);
	fprintf(fp,"%c(s12H",ESC); 	/* To set the font 			*/
	fprintf(fp,"\n");
	
	//Code for Line 1

	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	print_spaces(l_start_point);
	fprintf(fp,"%s\n",hosp_name.arr);
	
	
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
	date.arr[0]		 = '\0';
    user_id.arr[0]   = '\0';
	base_curr.arr[0] = '\0';
	nd_temp_date.arr[0] = '\0';
	language_id.arr[0] = '\0';
	nd_loc_date.arr[0] = '\0';

    l_acc_name.len   = 0;
	hosp_name.len    = 0;
    date_time.len    = 0;
	date.len		 = 0;
    user_id.len      = 0;
	base_curr.len    = 0;
	nd_temp_date.len = 0;
	language_id.len  = 0;
	nd_loc_date.len  = 0;


    /* EXEC SQL SELECT ACCOUNTING_NAME,
					ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/RRRR'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
                    USER,
					BASE_CURRENCY
               INTO :l_acc_name,
					:hosp_name, 
					:date,
					:date_time, 
					:user_id,
					:base_curr
               FROM SY_ACC_ENTITY_LANG_VW
	          WHERE ACC_ENTITY_ID = :nd_facility
			  AND   LANGUAGE_ID   = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,\
'DD/MM/RRRR') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,USER ,BASE_CURRENCY into :b0,:b1\
,:b2,:b3,:b4,:b5  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b6 and LANG\
UAGE_ID=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )596;
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
    sqlstm.sqhstv[5] = (         void  *)&base_curr;
    sqlstm.sqhstl[5] = (unsigned int  )9;
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
    sqlstm.sqhstv[7] = (         void  *)&p_language_id;
    sqlstm.sqhstl[7] = (unsigned int  )5;
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
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	if(date.arr[0]!='\0')
	{
	init_date_temp_var();
	strcpy(nd_temp_date.arr,date.arr);
	fun_change_loc_date();
	strcpy(date.arr,nd_loc_date.arr);
	}

	l_acc_name.arr[l_acc_name.len]		   = '\0';
	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	date.arr[date.len]					   = '\0';
	user_id.arr[user_id.len]               = '\0';
	base_curr.arr[base_curr.len]           = '\0';
	nd_temp_date.arr[nd_temp_date.len]     = '\0';
	nd_loc_date.arr[nd_loc_date.len]       = '\0';

}

fetch_patient_name()
{
    bl_patient_name.arr[0] = '\0';
    bl_patient_name.len = 0;

    /* EXEC SQL SELECT  decode(:p_language_id,'en',short_name,short_name_loc_lang)
               INTO :bl_patient_name
               FROM MP_PATIENT_MAST
	           WHERE PATIENT_ID = :bl_patient_no; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select decode(:b0,'en',short_name,short_name_loc_lang) in\
to :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )643;
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
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_patient_no;
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

fetch_reason_desc()
{

    bl_reason_desc.arr[0]	= '\0';
    bl_reason_desc1.arr[0]	= '\0';
    bl_reason_desc2.arr[0]	= '\0';
	bl_reason_desc3.arr[0]	= '\0';
	bl_reason_desc4.arr[0]	= '\0';
	bl_reason_desc5.arr[0]	= '\0';	

	bl_reason_desc.len		= 0;
	bl_reason_desc1.len		= 0;
	bl_reason_desc2.len		= 0;
	bl_reason_desc3.len		= 0;
	bl_reason_desc4.len		= 0;
	bl_reason_desc5.len		= 0;

    /* EXEC SQL SELECT replace(action_reason_desc,CHR(10),CHR(32)),instr(action_reason_desc,' ')
               INTO :bl_reason_desc,:null_place
               FROM BL_ACTION_REASON_LANG_VW
	           WHERE action_reason_code = :bl_reason_code
			   AND   LANGUAGE_ID	    = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 23;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select replace(action_reason_desc,CHR(10),CHR(32)) ,instr\
(action_reason_desc,' ') into :b0,:b1  from BL_ACTION_REASON_LANG_VW where (ac\
tion_reason_code=:b2 and LANGUAGE_ID=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )670;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_reason_desc;
    sqlstm.sqhstl[0] = (unsigned int  )4002;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&null_place;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bl_reason_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
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



    if (OERROR) 
		err_mesg("SELECT failed on table BL_ACTION_REASON",0,"");

	bl_reason_desc.arr[bl_reason_desc.len]           = '\0';

    if(null_place > 0)
	{
	/* EXEC SQL EXECUTE
	BEGIN
	declare
		str1   varchar2(4000);
		str2   varchar2(1000);
    
	 BEGIN
     blcommon.split_words(:bl_reason_desc,60,'*',1,str1,str2);
	    IF str2 IS NOT NULL THEN
         :bl_reason_desc1 := str2;
        END IF;
	 blcommon.split_words(:bl_reason_desc,60,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :bl_reason_desc2  := str2;
       END IF;
	 blcommon.split_words(:bl_reason_desc,60,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_reason_desc3    :=  str2;
        END IF;

	 blcommon.split_words(:bl_reason_desc,60,'*',4,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_reason_desc4    := str2;
        END IF;

	 blcommon.split_words(:bl_reason_desc,60,'*',5,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_reason_desc5    := str2;
        END IF;

     
	 END;
	 END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin declare str1 varchar2 ( 4000 ) ; str2 varchar2 ( 1000 \
) ; BEGIN blcommon . split_words ( :bl_reason_desc , 60 , '*' , 1 , str1 , str\
2 ) ; IF str2 IS NOT NULL THEN :bl_reason_desc1 := str2 ; END IF ; blcommon . \
split_words ( :bl_reason_desc , 60 , '*' , 2 , str1 , str2 ) ; IF str2 IS NOT \
NULL THEN :bl_reason_desc2 := str2 ; END IF ; blcommon . split_words ( :bl_rea\
son_desc , 60 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl_reason_\
desc3 := str2 ; END IF ; blcommon . split_words ( :bl_reason_desc , 60 , '*' ,\
 4 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl_reason_desc4 := str2 ; END I\
F ; blcommon . split_words ( :bl_reason_desc , 60 , '*' , 5 , str1 , str2 ) ; \
IF str2 IS NOT NULL THEN :bl_reason_desc5 := str2 ; END IF ; END ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )701;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_reason_desc;
 sqlstm.sqhstl[0] = (unsigned int  )4002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_reason_desc1;
 sqlstm.sqhstl[1] = (unsigned int  )102;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_reason_desc2;
 sqlstm.sqhstl[2] = (unsigned int  )102;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_reason_desc3;
 sqlstm.sqhstl[3] = (unsigned int  )102;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_reason_desc4;
 sqlstm.sqhstl[4] = (unsigned int  )102;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_reason_desc5;
 sqlstm.sqhstl[5] = (unsigned int  )102;
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


	}

	else
	{
     strcpy(bl_reason_desc1.arr,bl_reason_desc.arr);
	 bl_reason_desc1.len = strlen(bl_reason_desc1.arr);
	 }
		bl_reason_desc1.arr[bl_reason_desc1.len]  = '\0';
		bl_reason_desc2.arr[bl_reason_desc2.len]  = '\0';
		bl_reason_desc3.arr[bl_reason_desc3.len]  = '\0';
		bl_reason_desc4.arr[bl_reason_desc4.len]  = '\0';
		bl_reason_desc5.arr[bl_reason_desc5.len]  = '\0';
	
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

		/* EXEC SQL SELECT LTRIM(RTRIM('BLREXMAD.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLREXMAD.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )740;
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
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )763;
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
