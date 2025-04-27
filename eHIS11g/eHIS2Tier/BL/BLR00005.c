
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00005.PC"
};


static unsigned int sqlctx = 1288460867;


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
            void  *sqhstv[24];
   unsigned int   sqhstl[24];
            int   sqhsts[24];
            void  *sqindv[24];
            int   sqinds[24];
   unsigned int   sqharm[24];
   unsigned int   *sqharc[24];
   unsigned short  sqadto[24];
   unsigned short  sqtdso[24];
} sqlstm = {12,24};

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
"type c where (((((((a.doc_type_code=b.doc_type_code and a.doc_number=b.doc_n\
umber) and a.slmt_type_code=c.slmt_type_code) and a.cash_counter_facility_id=:\
b0) and trunc(b.cancelled_date) between to_date(nvl(:b1,'01/01/1401'),'DD/MM/Y\
YYY') and nvl(to_date(:b2,'DD/MM/YYYY'),sysdate)) and a.cash_counter_code betw\
een nvl(:b3,'!!') and nvl(:b4,'~~')) and a.recpt_refund_ind=decode(:b5,'R','R'\
,'F','F',a.recpt_refund_ind)) and ((:b6='Y' and a.cash_slmt_flag<>'A') or :b6=\
'N'))) where ((((recpt_refund_ind=decode(:b5,'R','R','F','F',recpt_refund_ind)\
 and cash_counter_facility_id=:b0) and trunc(doc_date) between to_date(nvl(:b1\
,'01/01/1401'),'DD/MM/YYYY') and nvl(to_date(:b2,'DD/MM/YYYY'),sysdate)) and c\
ash_counter_code between nvl(:b3,'!!') and nvl(:b4,'~~')) and ((:b6='Y' and ca\
sh_slmt_flag<>'A') or :b6='N')) group by recpt_refund_ind,doc_date,to_char(doc\
_date,'DD/MM/YYYY'),added_by_id,cash_counter_code,slmt_type_code,short_desc or\
der by recpt_refund_ind desc ,doc_date            ";

 static const char *sq0006 = 
"select slmt_type_code ,short_desc  from bl_slmt_type  order by 1            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,112,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,171,0,4,153,0,0,10,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
1,0,0,2,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
91,0,0,3,84,0,2,185,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
118,0,0,4,0,0,30,216,0,0,0,0,0,1,0,
133,0,0,5,2008,0,9,295,0,0,24,24,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,1,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,
0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
244,0,0,6,76,0,9,299,0,0,0,0,0,1,0,
259,0,0,5,0,0,13,322,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,4,0,0,
306,0,0,7,155,0,4,639,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
341,0,0,8,96,0,4,717,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
364,0,0,9,162,0,6,724,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
395,0,0,10,976,0,4,745,0,0,9,8,0,1,0,2,4,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
446,0,0,6,0,0,13,798,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00005.PC                                  */
/* AUTHOR                : Jagwinder Kaur                             */  
/* DATE WRITTEN          : 27/04/2004                                   */      
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
#define ESC 0x1B 
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
			nd_cash_counter_facility		[3],
			nd_fm_cash_counter				[5],
			nd_to_cash_counter				[5],
			nd_fm_doc_date					[11],
			nd_to_doc_date					[11],
			bl_doc_date						[11],
			bl_cash_counter_code			[5],
			old_cash_counter_code			[5],
			bl_cash_counter_facility		[3],
			bl_user							[31],
			old_user						[31],
			bl_slmt_type_code				[3],
			bl_slmt_type_desc				[16],
			old_doc_date					[11],
			l_translated_value			   [201],
			l_cash_book_acc_desc		   [16],
			l_pk_value					   [100],
			tmp_date						[18],
			temp_slmt_type_code				[3],
			temp_slmt_type_desc				[51],
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

struct { unsigned short len; unsigned char arr[3]; } nd_cash_counter_facility;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_cash_counter;

struct { unsigned short len; unsigned char arr[5]; } nd_to_cash_counter;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bl_doc_date;

struct { unsigned short len; unsigned char arr[5]; } bl_cash_counter_code;

struct { unsigned short len; unsigned char arr[5]; } old_cash_counter_code;

struct { unsigned short len; unsigned char arr[3]; } bl_cash_counter_facility;

struct { unsigned short len; unsigned char arr[31]; } bl_user;

struct { unsigned short len; unsigned char arr[31]; } old_user;

struct { unsigned short len; unsigned char arr[3]; } bl_slmt_type_code;

struct { unsigned short len; unsigned char arr[16]; } bl_slmt_type_desc;

struct { unsigned short len; unsigned char arr[11]; } old_doc_date;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[16]; } l_cash_book_acc_desc;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[18]; } tmp_date;

struct { unsigned short len; unsigned char arr[3]; } temp_slmt_type_code;

struct { unsigned short len; unsigned char arr[51]; } temp_slmt_type_desc;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


double      bl_collection_amt,
			bl_return_amt,
			tot_collection_date,
			tot_return_date,
			tot_collection_rep,
			tot_return_rep,
			date_total;

int i,sno = 0,n;
int tot_rec_in_slmt;
char excl_credit_card_trn;
char nd_rec_ref,bl_recpt_refund_ind;
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char fm_cash_counter[5],
	 to_cash_counter[5],
	 fm_doc_date[12],
	 to_doc_date[12],
	 p_page[10];
char string_var[200];
char slmt_desc[50][16];
char slmt_code[50][3];
double slmt_tot[30];
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
 
    strcpy(g_pgm_id,"BLR00005");
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

		strcpy(p_language_id.arr,l_language_id.arr);
		p_language_id.len = l_language_id.len; 

    	strcpy(nd_session_id.arr,argv[2]);
    	nd_session_id.len = strlen(nd_session_id.arr);
    	strcpy(g_session_id,nd_session_id.arr);

    	strcpy(nd_pgm_date.arr,argv[3]);
    	nd_pgm_date.len = strlen(nd_pgm_date.arr);
    	strcpy(g_pgm_date,nd_pgm_date.arr);

    	strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);

	   nd_cash_counter_facility.arr[0]	= '\0';
       nd_fm_cash_counter.arr[0]		= '\0';
	   nd_to_cash_counter.arr[0]		= '\0';
	   nd_fm_doc_date.arr[0]			= '\0';
	   nd_to_doc_date.arr[0]			= '\0';

	   nd_cash_counter_facility.len	= 0;
	   nd_fm_cash_counter.len		= 0;
	   nd_to_cash_counter.len		= 0;
	   nd_fm_doc_date.len			= 0;
	   nd_to_doc_date.len			= 0;

        /* EXEC SQL SELECT	PARAM1,
						PARAM2,
						PARAM3,
						PARAM4,
						PARAM5,
						PARAM6,
						PARAM7
				INTO	:nd_cash_counter_facility,
						:nd_fm_cash_counter,
						:nd_to_cash_counter,
						:nd_fm_doc_date,
						:nd_to_doc_date,
						:nd_rec_ref,
						:excl_credit_card_trn
				FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 10;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6\
 ,PARAM7 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where ((PGM_ID=:\
b7 and SESSION_ID=:b8) and PGM_DATE=:b9)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )36;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_cash_counter_facility;
        sqlstm.sqhstl[0] = (unsigned int  )5;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_fm_cash_counter;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_to_cash_counter;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_date;
        sqlstm.sqhstl[3] = (unsigned int  )13;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_date;
        sqlstm.sqhstl[4] = (unsigned int  )13;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&nd_rec_ref;
        sqlstm.sqhstl[5] = (unsigned int  )1;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&excl_credit_card_trn;
        sqlstm.sqhstl[6] = (unsigned int  )1;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&d_curr_pgm_name;
        sqlstm.sqhstl[7] = (unsigned int  )17;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
        sqlstm.sqhstl[8] = (unsigned int  )18;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
        sqlstm.sqhstl[9] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");


		nd_cash_counter_facility.arr[nd_cash_counter_facility.len]	= '\0';
		nd_fm_cash_counter.arr[nd_fm_cash_counter.len]					= '\0';
		nd_to_cash_counter.arr[nd_to_cash_counter.len]					= '\0';
		nd_fm_doc_date.arr[nd_fm_doc_date.len]							= '\0';
		nd_to_doc_date.arr[nd_to_doc_date.len]							= '\0';

      /* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 10;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESS\
ION_ID=:b1) and PGM_DATE=:b2)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )91;
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
fprintf (fp,"%c&l1O",ESC);
fprintf (fp, "%c(s12H", ESC);
		print_page_header();

		//print_head();	ravikiran	
		
		open_hdr();

		fetch_slmt_cur();
    
	    print_detail();
	
	    end_of_rep();


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )118;
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
	/* EXEC SQL DECLARE BL_RCPT_REF_CUR CURSOR FOR 
	select	doc_date,
		to_char(doc_date,'DD/MM/YYYY'),
		recpt_refund_ind,
		added_by_id,
		cash_counter_code,
		slmt_type_code,
		short_desc,
		sum(doc_amt) doc_amt
	from
			(select	cash_counter_facility_id,
				trunc(doc_date) doc_date,
				recpt_refund_ind,
				a.added_by_id,
				cash_counter_code,
				a.slmt_type_code,
				b.short_desc,
				b.cash_slmt_flag,
				doc_amt
			from 	BL_RECEIPT_REFUND_HDRDTL_VW a,bl_slmt_type b
			where   cash_counter_facility_id = :nd_cash_counter_facility
			and 	trunc(doc_date) 
			        between to_date(nvl(:nd_fm_doc_date,'01/01/1401'),'DD/MM/YYYY') 
			        and nvl(to_date(:nd_to_doc_date,'DD/MM/YYYY'),sysdate)			
		        and 	cash_counter_code between nvl(:nd_fm_cash_counter,'!!')
				and nvl(:nd_to_cash_counter,'~~')
			and     recpt_refund_ind = decode(:nd_rec_ref,'R','R','F','F',recpt_refund_ind)		
		        and	((:excl_credit_card_trn = 'Y' and a.cash_slmt_flag <> 'A') 
			          or :excl_credit_card_trn = 'N')
		        and a.slmt_type_code=b.slmt_type_code
			union all
			select  a.cash_counter_facility_id,
				trunc(b.cancelled_date) doc_date,
				a.recpt_refund_ind,
				a.added_by_id,
				a.cash_counter_code,
				a.slmt_type_code,
				c.short_desc,
				c.cash_slmt_flag,
				-doc_amt
			from 	BL_RECEIPT_REFUND_HDRDTL_VW a,bl_cancelled_bounced_trx b, bl_slmt_type c
			where 	a.doc_type_code=b.doc_type_code
			and	a.doc_number = b.doc_number
			and 	a.slmt_type_code=c.slmt_type_code
			and     a.cash_counter_facility_id = :nd_cash_counter_facility
			and 	trunc(b.cancelled_date) 
			        between to_date(nvl(:nd_fm_doc_date,'01/01/1401'),'DD/MM/YYYY') 
				and nvl(to_date(:nd_to_doc_date,'DD/MM/YYYY'),sysdate)			
		        and 	a.cash_counter_code between nvl(:nd_fm_cash_counter,'!!')
				and nvl(:nd_to_cash_counter,'~~')
			and     a.recpt_refund_ind = decode(:nd_rec_ref,'R','R','F','F',a.recpt_refund_ind)		
		        and	((:excl_credit_card_trn = 'Y' and a.cash_slmt_flag <> 'A') or :excl_credit_card_trn = 'N')) 
		where	recpt_refund_ind = decode(:nd_rec_ref,'R','R','F','F',recpt_refund_ind)		
		and     cash_counter_facility_id = :nd_cash_counter_facility
		and 	trunc(doc_date) 
		        between to_date(nvl(:nd_fm_doc_date,'01/01/1401'),'DD/MM/YYYY') 
			and nvl(to_date(:nd_to_doc_date,'DD/MM/YYYY'),sysdate)
		and 	cash_counter_code between nvl(:nd_fm_cash_counter,'!!')
			and nvl(:nd_to_cash_counter,'~~')
		and	((:excl_credit_card_trn = 'Y' and cash_slmt_flag <> 'A') or :excl_credit_card_trn = 'N')		
		group by recpt_refund_ind,doc_date,to_char(doc_date,'DD/MM/YYYY'),added_by_id,cash_counter_code,slmt_type_code,short_desc
		order by recpt_refund_ind desc,doc_date; */ 

		
	/* EXEC SQL DECLARE BL_SLMT_CUR CURSOR FOR 
		Select slmt_type_code,short_desc
		from bl_slmt_type
		order by 1; */ 

}

open_hdr() 
{

    /* EXEC SQL OPEN BL_RCPT_REF_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select doc_date ,to_char(doc_date,'DD/MM/YYYY') ,recpt_refund_ind ,ad\
ded_by_id ,cash_counter_code ,slmt_type_code ,short_desc ,sum(doc_amt) doc_a\
mt  from (select cash_counter_facility_id ,trunc(doc_date) doc_date ,recpt_r\
efund_ind ,a.added_by_id ,cash_counter_code ,a.slmt_type_code ,b.short_desc \
,b.cash_slmt_flag ,doc_amt  from BL_RECEIPT_REFUND_HDRDTL_VW a ,bl_slmt_type\
 b where (((((cash_counter_facility_id=:b0 and trunc(doc_date) between to_da\
te(nvl(:b1,'01/01/1401'),'DD/MM/YYYY') and nvl(to_date(:b2,'DD/MM/YYYY'),sys\
date)) and cash_counter_code between nvl(:b3,'!!') and nvl(:b4,'~~')) and re\
cpt_refund_ind=decode(:b5,'R','R','F','F',recpt_refund_ind)) and ((:b6='Y' a\
nd a.cash_slmt_flag<>'A') or :b6='N')) and a.slmt_type_code=b.slmt_type_code\
) union all select a.cash_counter_facility_id ,trunc(b.cancelled_date) doc_d\
ate ,a.recpt_refund_ind ,a.added_by_id ,a.cash_counter_code ,a.slmt_type_cod\
e ,c.short_desc ,c.cash_slmt_flag ,(-doc_amt)  from BL_RECEIPT_REFUND_HDRDTL\
_VW a ,bl_cancelled_bounced_trx b ,bl_slmt_");
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )133;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_cash_counter_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_cash_counter;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_cash_counter;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_rec_ref;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&excl_credit_card_trn;
    sqlstm.sqhstl[6] = (unsigned int  )1;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&excl_credit_card_trn;
    sqlstm.sqhstl[7] = (unsigned int  )1;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_cash_counter_facility;
    sqlstm.sqhstl[8] = (unsigned int  )5;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[10] = (unsigned int  )13;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_fm_cash_counter;
    sqlstm.sqhstl[11] = (unsigned int  )7;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_to_cash_counter;
    sqlstm.sqhstl[12] = (unsigned int  )7;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_rec_ref;
    sqlstm.sqhstl[13] = (unsigned int  )1;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&excl_credit_card_trn;
    sqlstm.sqhstl[14] = (unsigned int  )1;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&excl_credit_card_trn;
    sqlstm.sqhstl[15] = (unsigned int  )1;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_rec_ref;
    sqlstm.sqhstl[16] = (unsigned int  )1;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_cash_counter_facility;
    sqlstm.sqhstl[17] = (unsigned int  )5;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[18] = (unsigned int  )13;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[19] = (unsigned int  )13;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_fm_cash_counter;
    sqlstm.sqhstl[20] = (unsigned int  )7;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&nd_to_cash_counter;
    sqlstm.sqhstl[21] = (unsigned int  )7;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&excl_credit_card_trn;
    sqlstm.sqhstl[22] = (unsigned int  )1;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&excl_credit_card_trn;
    sqlstm.sqhstl[23] = (unsigned int  )1;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
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
         err_mesg("OPEN failed on cursor BL_RCPT_REF_CUR",0,"");

	/* EXEC SQL OPEN BL_SLMT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )244;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_SLMT_CUR",0,"");
}

fetch_hdr()
{
bl_doc_date.arr[0]				= '\0';
bl_cash_counter_code.arr[0]		= '\0';
bl_user.arr[0]					= '\0';
bl_slmt_type_code.arr[0]		= '\0';
bl_slmt_type_desc.arr[0]		= '\0';


bl_doc_date.len					= 0;
bl_cash_counter_code.len		= 0;
bl_user.len						= 0;
bl_slmt_type_code.len			= 0;
bl_slmt_type_desc.len			= 0;


bl_return_amt	= 0;
  
      /* EXEC SQL FETCH BL_RCPT_REF_CUR
               INTO :tmp_date,
					:bl_doc_date,
					:bl_recpt_refund_ind,
					:bl_user,
					:bl_cash_counter_code,
					:bl_slmt_type_code,
					:bl_slmt_type_desc,
					:bl_return_amt; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 24;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )259;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&tmp_date;
      sqlstm.sqhstl[0] = (unsigned int  )20;
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
      sqlstm.sqhstv[2] = (         void  *)&bl_recpt_refund_ind;
      sqlstm.sqhstl[2] = (unsigned int  )1;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_user;
      sqlstm.sqhstl[3] = (unsigned int  )33;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_cash_counter_code;
      sqlstm.sqhstl[4] = (unsigned int  )7;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_slmt_type_code;
      sqlstm.sqhstl[5] = (unsigned int  )5;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_slmt_type_desc;
      sqlstm.sqhstl[6] = (unsigned int  )18;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bl_return_amt;
      sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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
            err_mesg("FETCH failed on cursor BL_RCPT_REF_CUR",0,"");


bl_doc_date.arr[bl_doc_date.len]							= '\0';
bl_cash_counter_code.arr[bl_cash_counter_code.len]			= '\0';
bl_user.arr[bl_user.len]									= '\0';
bl_slmt_type_code.arr[bl_slmt_type_code.len]				= '\0';
bl_slmt_type_desc.arr[bl_slmt_type_desc.len]				= '\0';

    return(LAST_ROW?0:1);
}



print_detail()
{

  while(fetch_hdr())
  {
  
    sno++;
    if(first)
	 {
     strcpy(old_doc_date.arr,bl_doc_date.arr);
	 old_doc_date.len=strlen(old_doc_date.arr);
	 first = 0;
	 print_head();
	 }
    if(strcmp(old_doc_date.arr,bl_doc_date.arr) != 0 )
	  print_date_total();
   
	check_page_end(1,0);   
  
	calc_collection();

	if(strcmp(old_doc_date.arr,bl_doc_date.arr) != 0 || 
	   strcmp(old_user.arr,bl_user.arr) != 0 ||
	   strcmp(old_cash_counter_code.arr,bl_cash_counter_code.arr) != 0)
        {
	     fprintf(fp," %-12s %-30s %-3s %-6s",
					bl_doc_date.arr,
					bl_user.arr,
                    bl_cash_counter_code.arr," ");
    
    	print_formated(bl_collection_amt);
        }
    else
    	fprintf(fp,"%-73s"," ");

	fprintf(fp," %-15.15s ",bl_slmt_type_desc.arr);
    print_formated(bl_return_amt);
					
	fprintf(fp,"\n");
    lctr++;
	
	calc_date_total();

    strcpy(old_doc_date.arr,bl_doc_date.arr);
	old_doc_date.len=strlen(old_doc_date.arr);
    strcpy(old_user.arr,bl_user.arr);
	old_user.len=strlen(old_user.arr);
    strcpy(old_cash_counter_code.arr,bl_cash_counter_code.arr);
	old_cash_counter_code.len=strlen(old_cash_counter_code.arr);
   }
  print_date_total();
	
}   


print_date_total()
{
 int n;
 int nCtr = 0;
 date_total=0;
 //print_head();
        for(n=1;n<=tot_rec_in_slmt;n++)
		{
		//disp_message(ERR_MESG,"in this");
			if( slmt_tot[n] != 0)
			{//disp_message(ERR_MESG,"in if");
			check_page_end(1,0);
				if (nCtr == 0)
				  {
				   fprintf(fp,"\n%-20s %51s  "," ",loc_legend[19]);
				   nCtr = 1;
				  }
				else
				  fprintf(fp,"\n%74s"," ");
				  
			fprintf(fp,"%-15.15s ",slmt_desc[n]);
			print_formated(slmt_tot[n]);
			date_total = date_total + slmt_tot[n];
		      }
		}

	 if (date_total!=0) 
  {	
		lctr+=1;
		check_page_end(3,0);
		fprintf(fp,"\n%90s---------------"," ");
		fprintf(fp,"\n%90s"," ");
		print_formated(date_total);
		fprintf(fp,"\n%90s---------------\n"," ");
		lctr+=3;
		initialize_slmt_tot();
		if (bl_doc_date.arr[0] !='\0')
		{
		fprintf(fp,"\f");
		print_head();
		}
  }
}

initialize_slmt_tot()
{
       for(n=1;n<=tot_rec_in_slmt;n++)
		slmt_tot[n] = 0;
		date_total = 0;

}


end_of_rep()
{

	//check_page_end(3,0);
	sprintf(l_mesg,"%d",pctr);


   if (pctr == 1) 
   {
      print_head();
	 }
	fprintf(fp,"\n\n %45s   ***  END OF REPORT ***\n"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00005.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00005.lis");
       proc_exit();
    }
}

print_head()
{ 
	print_page_title();
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------\n");

	if (bl_recpt_refund_ind =='R')
	   {
		fprintf(fp," %-12s %-30s %-8s %17s   %-16s %-18s %-15s \n"," "," "," "," ",loc_legend[11]," ",loc_legend[8]);
		fprintf(fp," %-12s %-30s %-8s %17s   %-16s %-18s %-15s \n",loc_legend[15],loc_legend[10],loc_legend[16],loc_legend[6],loc_legend[14],loc_legend[7],loc_legend[9]);
		}
    else
       {
		fprintf(fp," %-12s %-30s %-8s %17s   %-16s %-18s %-15s \n"," "," "," "," ",loc_legend[21]," ",loc_legend[8]);
		fprintf(fp," %-12s %-30s %-8s %17s   %-16s %-18s %-15s \n",loc_legend[15],loc_legend[10],loc_legend[16],loc_legend[20],loc_legend[14],loc_legend[7],loc_legend[9]);
		}
    
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------\n");
	fflush(fp);  
	lctr = 8;
}

print_page_header()
{

	if (nd_fm_cash_counter.arr[0] == '\0') 
		strcpy(fm_cash_counter,"Lowest");
	else
		strcpy(fm_cash_counter,nd_fm_cash_counter.arr);

	if (nd_to_cash_counter.arr[0] == '\0') 
		strcpy(to_cash_counter,"Highest");
	else
		strcpy(to_cash_counter,nd_to_cash_counter.arr);

    if (nd_fm_doc_date.arr[0] == '\0')
	  strcpy(fm_doc_date,"Lowest");
    else
	  strcpy(fm_doc_date,nd_fm_doc_date.arr);

	if (nd_to_doc_date.arr[0] == '\0')
	  strcpy(to_doc_date,"Highest");
    else
	  strcpy(to_doc_date,nd_to_doc_date.arr);

fprintf(fp,"\n\n");
print_page_title();

fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------\n");
//fprintf(fp,"VER : 4.1 \n\n\n\n");
fprintf(fp,"\n\n\n\n");
fprintf(fp,"           INPUT PARAMETER \n");
fprintf(fp,"           --------------- \n\n\n\n");
fprintf(fp,"				CASH COUNTER FACILITY             : %s\n\n",nd_cash_counter_facility.arr);

fprintf(fp,"				CASH COUNTER     FROM             : %s\n",fm_cash_counter);
fprintf(fp,"				                 TO               : %s\n\n",to_cash_counter);
fprintf(fp,"				DOCUMENT DATE    FROM             : %s\n",fm_doc_date);
fprintf(fp,"				                 TO               : %s\n\n",to_doc_date);
fprintf(fp,"				TRANSACTION TYPE                  : ");

	if(nd_rec_ref == 'R')
      fprintf(fp,"Receipt");
	if(nd_rec_ref == 'F')
      fprintf(fp,"Refund");
	if(nd_rec_ref == 'B')
      fprintf(fp,"Both");

fprintf(fp,"\n\n");
fprintf(fp,"				EXCLUDING CREDIT CARD TRANSACTION : %c\n\n\n",excl_credit_card_trn);
fprintf(fp,"\f");
}

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;

	l_report_width=122;
	l_acc_entity_length = strlen(hosp_name.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	fprintf(fp,"\nMDL           : BL");
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",hosp_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(18+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[2],date.arr);

	//Code for Line 2
	if (bl_doc_date.arr[0] == '\0')
	{
	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-(strlen(loc_legend[5])/2));
	fprintf(fp,"OPR           : %s",user_id.arr);
	l_start_point=l_start_point-(strlen(user_id.arr)+16);
	print_spaces(l_start_point);
	fprintf(fp,"%s",loc_legend[5]);
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[5]);
	l_start_point=(l_report_width-(20+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[3],date_time.arr);
	    }
	else
	{
	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[5])+strlen(loc_legend[23])+12)/2));
	fprintf(fp,"OPR           : %s",user_id.arr);
	l_start_point=l_start_point-(strlen(user_id.arr)+15);
	print_spaces(l_start_point);
	fprintf(fp,"%s",loc_legend[5]);
	fprintf(fp," %s",loc_legend[23]);
	fprintf(fp," %-11s",bl_doc_date.arr);
	l_comp_name_end_point=l_start_point+strlen(user_id.arr)+16+strlen(loc_legend[5])+strlen(loc_legend[23])+14;
	l_start_point=l_report_width-(19+strlen(date_time.arr))-l_comp_name_end_point;
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[3],date_time.arr);
    }
	
	

	//Code for Line 3
	l_start_point=0;
	l_start_point=ceill(l_report_width/2);
	fprintf(fp,"%-14.14s: BLR00005",loc_legend[1]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	l_comp_name_end_point=l_start_point+24;
	l_start_point=(l_report_width - l_comp_name_end_point- 29);
	print_spaces(l_start_point);
	fprintf(fp," %-15.15s : %d\n",loc_legend[4],++pctr);
	
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
    hosp_name.len    = 0;
    date_time.len    = 0;
	date.len		 = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/RRRR'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
                    USER
               INTO :hosp_name, 
					:date,
					:date_time, 
					:user_id
               FROM SY_ACC_ENTITY
	          WHERE ACC_ENTITY_ID = :nd_facility; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/RRRR') ,TO\
_CHAR(SYSDATE,'HH24:MI:SS') ,USER into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY whe\
re ACC_ENTITY_ID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )306;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_facility;
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
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	date.arr[date.len]					   = '\0';
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
		lctr = 8;
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

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00005.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00005.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )341;
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
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )364;
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


calc_collection()
{

   /* EXEC SQL
   select	sum(doc_amt)
   into		:bl_collection_amt
   from
			(select	cash_counter_facility_id,
				trunc(doc_date) doc_date,
				recpt_refund_ind,
				a.added_by_id,
				cash_counter_code,
				a.slmt_type_code,
				b.short_desc,
				b.cash_slmt_flag,
				doc_amt
			from 	BL_RECEIPT_REFUND_HDRDTL_VW a,bl_slmt_type b
			where   a.slmt_type_code=b.slmt_type_code
			and     recpt_refund_ind = :bl_recpt_refund_ind
			and     cash_counter_facility_id = :nd_cash_counter_facility
			and 	trunc(doc_date) = to_date(:bl_doc_date,'DD/MM/YYYY') 
			and 	a.cash_counter_code = :bl_cash_counter_code
			union all
			select  a.cash_counter_facility_id,
				trunc(b.cancelled_date) doc_date,
				a.recpt_refund_ind,
				a.added_by_id,
				a.cash_counter_code,
				a.slmt_type_code,
				c.short_desc,
				c.cash_slmt_flag,
				-doc_amt
			from 	BL_RECEIPT_REFUND_HDRDTL_VW a,bl_cancelled_bounced_trx b, bl_slmt_type c
			where 	a.doc_type_code=b.doc_type_code
			and	a.doc_number = b.doc_number
			and a.slmt_type_code=c.slmt_type_code
			and a.recpt_refund_ind = :bl_recpt_refund_ind
			and a.cash_counter_facility_id = :nd_cash_counter_facility
			and trunc(b.cancelled_date) = to_date(:bl_doc_date,'DD/MM/YYYY') 
			and a.cash_counter_code = :bl_cash_counter_code); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select sum(doc_amt) into :b0  from (select cash_counter_fa\
cility_id ,trunc(doc_date) doc_date ,recpt_refund_ind ,a.added_by_id ,cash_cou\
nter_code ,a.slmt_type_code ,b.short_desc ,b.cash_slmt_flag ,doc_amt  from BL_\
RECEIPT_REFUND_HDRDTL_VW a ,bl_slmt_type b where ((((a.slmt_type_code=b.slmt_t\
ype_code and recpt_refund_ind=:b1) and cash_counter_facility_id=:b2) and trunc\
(doc_date)=to_date(:b3,'DD/MM/YYYY')) and a.cash_counter_code=:b4) union all s\
elect a.cash_counter_facility_id ,trunc(b.cancelled_date) doc_date ,a.recpt_re\
fund_ind ,a.added_by_id ,a.cash_counter_code ,a.slmt_type_code ,c.short_desc ,\
c.cash_slmt_flag ,(-doc_amt)  from BL_RECEIPT_REFUND_HDRDTL_VW a ,bl_cancelled\
_bounced_trx b ,bl_slmt_type c where ((((((a.doc_type_code=b.doc_type_code and\
 a.doc_number=b.doc_number) and a.slmt_type_code=c.slmt_type_code) and a.recpt\
_refund_ind=:b1) and a.cash_counter_facility_id=:b2) and trunc(b.cancelled_dat\
e)=to_date(:b3,'DD/MM/YYYY')) and a.cash_counter_code=:b4)) ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )395;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_collection_amt;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bl_recpt_refund_ind;
   sqlstm.sqhstl[1] = (unsigned int  )1;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_cash_counter_facility;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&bl_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&bl_cash_counter_code;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&bl_recpt_refund_ind;
   sqlstm.sqhstl[5] = (unsigned int  )1;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_cash_counter_facility;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&bl_doc_date;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&bl_cash_counter_code;
   sqlstm.sqhstl[8] = (unsigned int  )7;
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


} 
	
fetch_slmt_cur()
{
int i=1,j=0;
int k = 1;


	while(k)
	 {
	
	 temp_slmt_type_code.arr[0] = '\0';
	 temp_slmt_type_code.len = 0;
	 temp_slmt_type_desc.arr[0] = '\0';
	 temp_slmt_type_desc.len = 0;

      /* EXEC SQL FETCH BL_SLMT_CUR
               INTO :temp_slmt_type_code,:temp_slmt_type_desc; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 24;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )446;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&temp_slmt_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&temp_slmt_type_desc;
      sqlstm.sqhstl[1] = (unsigned int  )53;
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
            err_mesg("FETCH failed on cursor BL_SLMT_CUR",0,"");
	  if (NODATAFOUND)
           k = 0;
    
	  temp_slmt_type_code.arr[temp_slmt_type_code.len] = '\0';
	  temp_slmt_type_desc.arr[temp_slmt_type_desc.len] = '\0';
       if (k>0)
	   {
	   strcpy(slmt_code[i],temp_slmt_type_code.arr);
	   strcpy(slmt_desc[i],temp_slmt_type_desc.arr);
	   i++;
	   }
	   
	 }
	tot_rec_in_slmt = i;
}

calc_date_total()
{
 int n;
    for (n=1; n <= tot_rec_in_slmt; n++)
	 {
	    if (strcmp(slmt_code[n],bl_slmt_type_code.arr) == 0)
	    slmt_tot[n] = slmt_tot[n] + bl_return_amt;
	  }
  }

