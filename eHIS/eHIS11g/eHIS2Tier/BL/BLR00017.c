
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00017.pc"
};


static unsigned int sqlctx = 1288460899;


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
            void  *sqhstv[12];
   unsigned int   sqhstl[12];
            int   sqhsts[12];
            void  *sqindv[12];
            int   sqinds[12];
   unsigned int   sqharm[12];
   unsigned int   *sqharc[12];
   unsigned short  sqadto[12];
   unsigned short  sqtdso[12];
} sqlstm = {12,12};

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
"select b.cash_counter_code ,b.long_desc ,a.doc_type_code ,a.doc_number ,to_c\
har(a.bounced_date,'dd/mm/yyyy') ,a.slmt_doc_ref_desc Cheque_no ,to_char(a.slm\
t_doc_ref_date,'dd/mm/yyyy') cheque_date ,((((a.doc_type_code||'/')||to_char(d\
oc_number))||'/')||to_char(doc_srno)) Receipt_no ,a.slmt_doc_remarks ,a.payer_\
name ,a.doc_amt ,a.ext_acct_code  from Bl_receipt_refund_dtl_vw a ,bl_cash_cou\
nter b where ((((a.operating_facility_id=b.operating_facility_id and a.cash_co\
unter_code=b.cash_counter_code) and NVL(a.bounced_yn,'N')='Y') and to_char(a.d\
oc_date,'YYYYMM')<=:b0) and (nvl(a.REPL_CHQ_YN,'N')='N' or (nvl(a.REPL_CHQ_YN,\
'N')='Y' and to_char(a.REPL_CHQ_DOC_DATE,'YYYYMM')>:b1))) order by b.cash_coun\
ter_code            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,96,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,233,0,4,138,0,0,8,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
83,0,0,3,84,0,2,159,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
110,0,0,4,0,0,30,217,0,0,0,0,0,1,0,
125,0,0,5,720,0,9,249,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
148,0,0,5,0,0,15,256,0,0,0,0,0,1,0,
163,0,0,6,199,0,6,274,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
190,0,0,7,194,0,6,298,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
217,0,0,8,203,0,6,323,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
244,0,0,5,0,0,13,416,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
307,0,0,9,74,0,4,515,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
330,0,0,10,206,0,4,832,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
373,0,0,11,96,0,4,880,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
396,0,0,12,162,0,6,887,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


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
#define ESC 0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     hosp_name                       [120],
			l_acc_name						[120],
			date_con						[21],
            date_time                       [20],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility				        [3],
			bl_cash_counter_code            [5],
			bl_long_desc					[31],
			bl_doc_type_code                [7], 
			bl_BOUNCED_DATE					[11],
			bl_Cheque_no					[21],
			bl_cheque_date					[11],
			bl_receipt_no					[20],
			bl_slmt_doc_remarks				[102],	
			bl_payer_name					[41],  	
			bl_ext_acct_code				[11],
			nd_month_year					[11],
			
			nd_repl_mm_yyyy					[11],
			l_repl_mm_yyyy					[11],
			l_translated_value				[201],
			l_pk_value						[100],
			month_year						[11],
			repl_mm_yyyy					[11] ,
			repl_mon_yyyy					[40],
			l_month_year					[11],
		 	yearstr							[4],
			cash_counter_code				[5],
			nd_temp_date					[21],
			nd_temp_date1					[11],
			nd_loc_date						[21],
			p_language_id					[3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[120]; } l_acc_name;

struct { unsigned short len; unsigned char arr[21]; } date_con;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[5]; } bl_cash_counter_code;

struct { unsigned short len; unsigned char arr[31]; } bl_long_desc;

struct { unsigned short len; unsigned char arr[7]; } bl_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } bl_BOUNCED_DATE;

struct { unsigned short len; unsigned char arr[21]; } bl_Cheque_no;

struct { unsigned short len; unsigned char arr[11]; } bl_cheque_date;

struct { unsigned short len; unsigned char arr[20]; } bl_receipt_no;

struct { unsigned short len; unsigned char arr[102]; } bl_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[41]; } bl_payer_name;

struct { unsigned short len; unsigned char arr[11]; } bl_ext_acct_code;

struct { unsigned short len; unsigned char arr[11]; } nd_month_year;

struct { unsigned short len; unsigned char arr[11]; } nd_repl_mm_yyyy;

struct { unsigned short len; unsigned char arr[11]; } l_repl_mm_yyyy;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[11]; } month_year;

struct { unsigned short len; unsigned char arr[11]; } repl_mm_yyyy;

struct { unsigned short len; unsigned char arr[40]; } repl_mon_yyyy;

struct { unsigned short len; unsigned char arr[11]; } l_month_year;

struct { unsigned short len; unsigned char arr[4]; } yearstr;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_code;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[11]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


			double bl_doc_amt,bl_doc_number,nd_cc_total_amt = 0,nd_cc_grand_total_amt = 0;
int i;
			
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[2000];
char l_tit[2000];
char l_pctr1[10];


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

int  lctr = 0,pctr = 0,pctr1=0,slno = 0,frec = 0;


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
 
    strcpy(g_pgm_id,"BLR00017");
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

		nd_month_year.arr[0]			= '\0';
		month_year.arr[0]				= '\0';
		repl_mm_yyyy.arr[0]				= '\0';
		nd_repl_mm_yyyy.arr[0]			= '\0';
		yearstr.arr[0]				    = '\0';
		l_month_year.arr[0]				= '\0';
		l_repl_mm_yyyy.arr[0]			= '\0';

		nd_month_year.len			= 0;
		nd_repl_mm_yyyy.len			= 0;
		yearstr.len			 		= 0;
		l_month_year.len			= 0;
		l_repl_mm_yyyy.len			= 0;

        /* EXEC SQL SELECT	PARAM1,PARAM2,SUBSTR(PARAM1,1,4),to_char(to_date(PARAM1,'yyyymm'),'mm/yyyy'),
			to_char(to_date(PARAM2,'yyyymm'),'mm/yyyy')
		 INTO :nd_month_year,:nd_repl_mm_yyyy,yearstr,:l_month_year,:l_repl_mm_yyyy
		 FROM SY_PROG_PARAM
                 WHERE PGM_ID   = :d_curr_pgm_name
                 AND SESSION_ID = :nd_session_id
                 AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 8;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,SUBSTR(PARAM1,1,4) ,to_char(to\
_date(PARAM1,'yyyymm'),'mm/yyyy') ,to_char(to_date(PARAM2,'yyyymm'),'mm/yyyy')\
 into :b0,:b1,:b2,:b3,:b4  from SY_PROG_PARAM where ((PGM_ID=:b5 and SESSION_I\
D=:b6) and PGM_DATE=:b7)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )36;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_month_year;
        sqlstm.sqhstl[0] = (unsigned int  )13;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_repl_mm_yyyy;
        sqlstm.sqhstl[1] = (unsigned int  )13;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&yearstr;
        sqlstm.sqhstl[2] = (unsigned int  )6;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&l_month_year;
        sqlstm.sqhstl[3] = (unsigned int  )13;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&l_repl_mm_yyyy;
        sqlstm.sqhstl[4] = (unsigned int  )13;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_curr_pgm_name;
        sqlstm.sqhstl[5] = (unsigned int  )17;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&nd_session_id;
        sqlstm.sqhstl[6] = (unsigned int  )18;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_pgm_date;
        sqlstm.sqhstl[7] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

		nd_month_year.arr[nd_month_year.len]				= '\0';
		nd_repl_mm_yyyy.arr[nd_repl_mm_yyyy.len]			= '\0';
		yearstr.arr[yearstr.len]							= '\0'; 
		l_month_year.arr[l_month_year.len]					= '\0';
		l_repl_mm_yyyy.arr[l_repl_mm_yyyy.len]				= '\0';


	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )83;
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
	declare_cursor();
	
	fetch_hosp_name();
	
	//get_language_id();

	fetch_legend_value();

    open_file();

	open_bill_cur();


  //fprintf(fp,"%c&l1O",ESC); 
  //fprintf(fp,"%c(s12H",ESC);
	fprintf(fp,"\n");
	print_page_header();
	
    while (fetch_bill_cur())
       {
		
		
		frec = frec + 1;

		if (strcmp(cash_counter_code.arr,bl_cash_counter_code.arr) != 0)
		{
			if (frec > 1) print_total();
		        nd_cc_total_amt = 0;

			check_page_end(1,0);
			print_rec(0);
			strcpy(cash_counter_code.arr,bl_cash_counter_code.arr);
		}
		else
		{
			check_page_end(1,0);				  
			print_rec(1);
			strcpy(cash_counter_code.arr,bl_cash_counter_code.arr);
		}
            nd_cc_total_amt = nd_cc_total_amt + bl_doc_amt;
	    nd_cc_grand_total_amt = nd_cc_grand_total_amt + bl_doc_amt;	
      }
		print_total();
		print_grand_total();	
   end_of_rep();

   close_bill_cur();



   
 /* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )110;
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


/* EXEC SQL DECLARE BILL_CUR CURSOR FOR
        Select b.cash_counter_code,b.long_desc,a.doc_type_code,a.doc_number,to_char(a.bounced_date,'dd/mm/yyyy'), 
		a.slmt_doc_ref_desc Cheque_no,
		to_char(a.slmt_doc_ref_date,'dd/mm/yyyy') cheque_date,
		a.doc_type_code||'/'||to_char(doc_number)||'/'||to_char(doc_srno) Receipt_no,
		a.slmt_doc_remarks,
		a.payer_name , 
		a.doc_amt,
		a.ext_acct_code
		from Bl_receipt_refund_dtl_vw a,bl_cash_counter b
		where a.operating_facility_id=b.operating_facility_id and
		a.cash_counter_code=b.cash_counter_code 
		and NVL(a.bounced_yn,'N') = 'Y' 
		and to_char(a.doc_date,'YYYYMM') <= :nd_month_year and (nvl(a.REPL_CHQ_YN,'N') ='N'
	        or
		( nvl(a.REPL_CHQ_YN,'N') ='Y' and to_char(a.REPL_CHQ_DOC_DATE,'YYYYMM') > :nd_repl_mm_yyyy ) )
		order by b.cash_counter_code ; */ 
	 
		

 		   
}

open_bill_cur()
{
  /* EXEC SQL OPEN BILL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0005;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )125;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_month_year;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_repl_mm_yyyy;
  sqlstm.sqhstl[1] = (unsigned int  )13;
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
         err_mesg("OPEN failed on cursor BILL_CUR",0,"");
}

close_bill_cur()
{
  /* EXEC SQL CLOSE BILL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
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

/*get_language_id()
{
	language_id.arr[0] = '\0';
	language_id.len = 0;
	

	EXEC SQL SELECT LANGUAGE_ID INTO :language_id FROM SM_APPL_USER where APPL_USER_ID = :user_id;

	if (OERROR)
        err_mesg("SELECTING LANGUAGE_ID failed",0,"");
}*/
get_local_date1()
{

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'dd/mm/yyyy'),
															:p_language_id,
															t_date);

		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'dd/mm/yyyy' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )163;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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


		nd_loc_date.arr[nd_loc_date.len]='\0';
		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

}
get_local_date2()
{

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'MM/YYYY'),
															:p_language_id,
															t_date);
		:nd_loc_date := to_char(t_date,'MM/YYYY');
	
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date1 , 'MM/YYYY' ) , :p_language_id , t_date ) \
; :nd_loc_date := to_char ( t_date , 'MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )190;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date1;
 sqlstm.sqhstl[0] = (unsigned int  )13;
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


	
	nd_loc_date.arr[nd_loc_date.len] = '\0';

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");
}
get_local_date3()
{

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'FMMonth/YYYY'),
															:p_language_id,
															t_date);
		:nd_loc_date := to_char(t_date,'FMMonth/YYYY');
	
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'FMMonth/YYYY' ) , :p_language_id , t_dat\
e ) ; :nd_loc_date := to_char ( t_date , 'FMMonth/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )217;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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


	
	nd_loc_date.arr[nd_loc_date.len] = '\0';

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");
}



get_initialize()
{
nd_temp_date.arr[0] = '\0';
nd_temp_date1.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';

nd_temp_date.len = 0;
nd_temp_date1.len = 0;
nd_loc_date.len  = 0;
}
get_local_date_convn1()
{

nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';
get_local_date1();

}

get_local_date_convn2()
{

nd_temp_date1.len = strlen(nd_temp_date1.arr);
nd_temp_date1.arr[nd_temp_date1.len]='\0';

get_local_date2();

}
get_local_date_convn3()
{

nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date3();

}

fetch_bill_cur()
 {
   
	bl_cash_counter_code.arr[0]    ='\0';
	bl_long_desc.arr[0]			   ='\0';	
	bl_doc_type_code.arr[0]		   ='\0';	
	bl_BOUNCED_DATE.arr[0]	       ='\0';
	bl_Cheque_no.arr[0]		       ='\0';
	bl_cheque_date.arr[0]		   ='\0';
	bl_slmt_doc_remarks.arr[0]	   ='\0';
	bl_receipt_no.arr[0]           ='\0';
	bl_payer_name.arr[0]		   ='\0';
	bl_payer_name.arr[0]	       ='\0';		
	bl_ext_acct_code.arr[0]		   ='\0';
	
	
		bl_cash_counter_code.len			=0;
		bl_long_desc.len					=0;
		bl_doc_type_code.len				=0;
		bl_BOUNCED_DATE.len					=0;
		bl_Cheque_no.len					=0;
		bl_cheque_date.len					=0;
		bl_slmt_doc_remarks.len				=0;
		bl_receipt_no.len					=0;
		bl_payer_name.len					=0;
		bl_ext_acct_code.len				=0;

		bl_doc_number    =0;
		bl_doc_amt       =0;


  /* EXEC SQL FETCH BILL_CUR INTO
			:bl_cash_counter_code,
			:bl_long_desc,
			:bl_doc_type_code,
			:bl_doc_number,				
			:bl_BOUNCED_DATE,		
			:bl_Cheque_no	,		
			:bl_cheque_date,
			:bl_receipt_no,
			:bl_slmt_doc_remarks,
			:bl_payer_name,
			:bl_doc_amt  ,
			:bl_ext_acct_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )244;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&bl_cash_counter_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_long_desc;
  sqlstm.sqhstl[1] = (unsigned int  )33;
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
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&bl_BOUNCED_DATE;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&bl_Cheque_no;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&bl_cheque_date;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&bl_receipt_no;
  sqlstm.sqhstl[7] = (unsigned int  )22;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&bl_slmt_doc_remarks;
  sqlstm.sqhstl[8] = (unsigned int  )104;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&bl_payer_name;
  sqlstm.sqhstl[9] = (unsigned int  )43;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&bl_doc_amt;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&bl_ext_acct_code;
  sqlstm.sqhstl[11] = (unsigned int  )13;
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
          err_mesg("FETCH failed on cursor BILL_CUR",0,"");

           
	bl_cash_counter_code.arr[bl_cash_counter_code.len]	='\0';
	bl_long_desc.arr[bl_long_desc.len]					='\0';            
	bl_doc_type_code.arr[bl_doc_type_code.len]			='\0';	
	bl_BOUNCED_DATE.arr[bl_BOUNCED_DATE.len]			='\0';
	bl_Cheque_no.arr[bl_Cheque_no.len]					='\0';					
	bl_cheque_date.arr[bl_cheque_date.len]				='\0';					
	bl_slmt_doc_remarks.arr[bl_slmt_doc_remarks.len]	='\0';				
	bl_receipt_no.arr[bl_receipt_no.len]				='\0';					
	bl_payer_name.arr[bl_payer_name.len]				='\0';					
	bl_ext_acct_code.arr[bl_ext_acct_code.len]			='\0';	

	return(LAST_ROW?0:1);
}

end_of_rep()
{
	check_page_end(3,0);
	fprintf(fp,"\n\n%80s\n\f",loc_legend[23]);//loc_legend[21]
	fflush(fp);
}

open_file()
{
        strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00017.lis");

        if ((fp = fopen(filename,"w")) == NULL)
        {
          disp_message(ERR_MESG,"Error in opening file BLR00017.lis");
          proc_exit();
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

print_page_header()
{
   double l_report_width;
   double l_acc_entity_length;
   double l_start_point;
   double l_comp_name_end_point;
   int l_page_width;

   l_report_width=145;
   l_acc_entity_length = strlen(hosp_name.arr);

   if (nd_repl_mm_yyyy.arr[0] == '\0')
   {
	  strcpy(repl_mm_yyyy.arr,l_month_year.arr);
	  repl_mm_yyyy.len = strlen(repl_mm_yyyy.arr);
   }
    else
    {
	  strcpy(repl_mm_yyyy.arr,l_repl_mm_yyyy.arr);
	  repl_mm_yyyy.len = strlen(repl_mm_yyyy.arr);
    }
     
	if (nd_month_year.arr[0] == '\0')	
	 strcpy(month_year.arr,loc_legend[20]);
	else
	 strcpy(month_year.arr,l_month_year.arr);

      
	     
/*
fprintf(fp,"\fMDL : BL                                         %-30s                                    Date : %-16s\n",
hosp_name.arr,date.arr);
*/


repl_mon_yyyy.arr[0] = '\0';
repl_mon_yyyy.len = 0;

/* EXEC SQL SELECT TO_CHAR(TO_DATE(:repl_mm_yyyy,'mm/yyyy'),'FMMonth/YYYY') 
into :repl_mon_yyyy
FROM dual; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 12;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'mm/yyyy'),'FMMonth/YYYY') into :b\
1  from dual ";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )307;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&repl_mm_yyyy;
sqlstm.sqhstl[0] = (unsigned int  )13;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&repl_mon_yyyy;
sqlstm.sqhstl[1] = (unsigned int  )42;
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




if(repl_mm_yyyy.arr[0]!= 0)
{
get_initialize();
strcpy(nd_temp_date.arr,repl_mon_yyyy.arr);
get_local_date_convn3();
strcpy(repl_mon_yyyy.arr,nd_loc_date.arr); 
repl_mon_yyyy.arr[repl_mon_yyyy.len] = '\0';
}


//Line 1
//fprintf(fp,"MDL : BL                                         %-30s                                    Date : %-10.10s\n",
//hosp_name.arr,date.arr);
//fprintf(fp,"OPR : %-10s                                                                                                   Time : %-14s\n", user_id.arr,date_time.arr);
//fprintf(fp,"REP : %-8s            %s%-4s              PAGE : %4d\n",
//"ssBLR00017","   List of Bounced Cheque that Has Not Been Replaced Ending 31 December",yearstr.arr,++pctr);

l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
fprintf(fp,"%-13s : BL",loc_legend[20]);        
l_start_point=l_start_point-18;
print_spaces(l_start_point);
fprintf(fp,"%s",hosp_name.arr);
l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
l_start_point=(l_report_width-(15+strlen(date_con.arr))-l_comp_name_end_point);
print_spaces(l_start_point);

date_con.arr[date_con.len]='\0';

get_initialize();
strcpy(nd_temp_date.arr,date_con.arr);
get_local_date_convn1();
strcpy(date_con.arr,nd_loc_date.arr); 

fprintf(fp,"%-15.15s : %s\n",loc_legend[3],date_con.arr);

nd_temp_date.arr[nd_temp_date.len] = '\0';
nd_loc_date.arr[nd_loc_date.len]   = '\0';

//Line 2

l_start_point=0;
l_start_point=ceill((l_report_width/2));
fprintf(fp,"%-13s : %s",loc_legend[21],user_id.arr);
l_start_point=l_start_point-(strlen(user_id.arr)+16);
print_spaces(l_start_point);
//fprintf(fp,"%s",loc_legend[1]);
l_comp_name_end_point=l_start_point+strlen(user_id.arr)+16;
l_start_point=(l_report_width-(17+strlen(date_time.arr))-l_comp_name_end_point);
print_spaces(l_start_point);
fprintf(fp,"%-15.15s : %s\n",loc_legend[4],date_time.arr);

l_start_point=0;
l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[16])+strlen(loc_legend[17])
			+strlen(repl_mon_yyyy.arr)+2)/2));
//Line 3

fprintf(fp,"%-14.14s: BLR00017",loc_legend[2]);
l_start_point=l_start_point-24;
print_spaces(l_start_point);
fprintf(fp,"%s %s %s",loc_legend[16],loc_legend[17],repl_mon_yyyy.arr);
l_comp_name_end_point=l_start_point+24+2+strlen(loc_legend[16])+strlen(loc_legend[17])
		+strlen(repl_mon_yyyy.arr);
pctr1 = pctr;
sprintf(l_pctr1,"%d",++pctr1);
l_start_point=(l_report_width-(18+6+strlen(l_pctr1))-l_comp_name_end_point);
print_spaces(l_start_point);
fprintf(fp,"%-15.15s : %d\n",loc_legend[5],++pctr);

fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1 \n\n\n\n");
fprintf(fp,"           %s :\n",loc_legend[26]); 
fprintf(fp,"           ------------------- \n\n\n");
fprintf(fp,"\n\n");


if(nd_month_year.arr[0]!='\0')	
{
get_initialize();
strcpy(nd_temp_date1.arr,month_year.arr);
get_local_date_convn2();
strcpy(month_year.arr,nd_loc_date.arr); 
}
else
strcpy(month_year.arr,loc_legend[28]);


if(repl_mm_yyyy.arr[0]!='\0')
{
get_initialize();
strcpy(nd_temp_date1.arr,repl_mm_yyyy.arr);
get_local_date_convn2();
strcpy(repl_mm_yyyy.arr,nd_loc_date.arr); 
}
else
strcpy(repl_mm_yyyy.arr,loc_legend[19]);


fprintf(fp,"				%s            : %s\n",loc_legend[6],month_year.arr);
fprintf(fp,"				%s                : %s\n\n",loc_legend[7],repl_mm_yyyy.arr);

fprintf(fp,"\f");
print_head();

}



print_head()
{

double l_report_width;
double l_acc_entity_length;
double l_start_point;
double l_comp_name_end_point;
int l_page_width;

l_report_width=145;
l_acc_entity_length = strlen(hosp_name.arr);

sprintf(l_tit,"%s %s %s",loc_legend[16],loc_legend[17],repl_mon_yyyy.arr);

fprintf(fp,"\n");

//fprintf(fp,"MDL : BL                                          %-30s                                 Date : %-16s\n",
//hosp_name.arr,date.arr);
//fprintf(fp,"OPR : %-10s                                                                                                 Time : %-14s \n", user_id.arr,date_time.arr);
//fprintf(fp,"REP : %-8s             %-75.75s           PAGE : %4d\n",
//"BLR00017",l_tit,++pctr);

//Line 1

l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
fprintf(fp,"%-13s : BL",loc_legend[20]);
l_start_point=l_start_point-18;
print_spaces(l_start_point);
fprintf(fp,"%s",hosp_name.arr);
l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
l_start_point=(l_report_width-(15+strlen(date_con.arr))-l_comp_name_end_point);
print_spaces(l_start_point);
fprintf(fp,"%-15.15s : %s\n",loc_legend[3],date_con.arr);


//Line 2

l_start_point=0;
l_start_point=ceill((l_report_width/2));
fprintf(fp,"%-13s : %s",loc_legend[21],user_id.arr);
l_start_point=l_start_point-(strlen(user_id.arr)+16);
print_spaces(l_start_point);
//fprintf(fp,"%s",loc_legend[1]);
l_comp_name_end_point=l_start_point+strlen(user_id.arr)+16;
l_start_point=(l_report_width-(17+strlen(date_time.arr))-l_comp_name_end_point);
print_spaces(l_start_point);


/*get_initialize();
strcpy(nd_temp_date.arr,date_con.arr);
get_local_date_convn1();
strcpy(date_con.arr,nd_loc_date.arr);*/

fprintf(fp,"%-15.15s : %s\n",loc_legend[4],date_time.arr);


//Line 3

l_start_point=0;
l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[16])+strlen(loc_legend[17])
			+strlen(repl_mon_yyyy.arr)+2)/2));
fprintf(fp,"%-14.14s: BLR00017",loc_legend[2]);
//fprintf(fp,"%-14.14s: %8s",loc_legend[2],loc_legend[25]);
l_start_point=l_start_point-24;
print_spaces(l_start_point);
fprintf(fp,"%s %s %s",loc_legend[16],loc_legend[17],repl_mon_yyyy.arr);
l_comp_name_end_point=l_start_point+24+2+strlen(loc_legend[16])+strlen(loc_legend[17])
		+strlen(repl_mon_yyyy.arr);
pctr1 = pctr;
sprintf(l_pctr1,"%d",++pctr1);
l_start_point=(l_report_width-(18+6+strlen(l_pctr1))-l_comp_name_end_point);
print_spaces(l_start_point);
fprintf(fp,"%-15.15s : %d\n",loc_legend[5],++pctr);

fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------------------\n");
//lctr = 13;
fprintf(fp,"    %6s %-27s %-20s  %-15s %-20s %-32s %15s \n",loc_legend[8],loc_legend[9],loc_legend[10],loc_legend[11],loc_legend[18],loc_legend[12],loc_legend[13]);
fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------------------\n");

lctr = 15;
}

print_rec(ind)
int ind;
{
  if (ind == 0)
  { 	
    slno=1;
    check_page_end(5,0);    
        fprintf(fp,"\n");
        fprintf(fp," %-5.5s %-31.31s \n",bl_cash_counter_code.arr,bl_long_desc.arr);
	    fprintf(fp,"\n");
	/*	fprintf(fp,"-------------------------------------------------------------------"); 
		fprintf(fp,"---------------------------------------------------------------------------\n"); */

//Commented on 01/12/2004 as per ML requirement
      /*
	    fprintf(fp,"    %-3s%-31s %-21s %-11s %-41s          %-7s \n",loc_legend[8],loc_legend[9],loc_legend[10],loc_legend[11],loc_legend[12],loc_legend[13]);
		fprintf(fp,"------------------------------------------------------------------");
		fprintf(fp,"-----------------------------------------------------------------------------\n");
       */  


get_initialize();

strcpy(nd_temp_date.arr,bl_cheque_date.arr);

get_local_date_convn1();

strcpy(bl_cheque_date.arr,nd_loc_date.arr); 
  	   		
		fprintf(fp,"%-4s%6d %-27.27s %-20s  %-15s %-20s %-32.32s ",
		            " ", slno,
					bl_slmt_doc_remarks.arr,				
					bl_Cheque_no.arr,		
					bl_cheque_date.arr,
					bl_receipt_no.arr,
					bl_payer_name.arr);

		print_formated(bl_doc_amt);
        lctr+=1;
		
 }
  else
  {
     slno=slno+1;
 
      check_page_end(3,0);  
     	        


get_initialize();
strcpy(nd_temp_date.arr,bl_cheque_date.arr);
get_local_date_convn1();
strcpy(bl_cheque_date.arr,nd_loc_date.arr); 

	fprintf(fp,"%-4s%6d %-27.27s %-20s  %-15s %-20s %-32.32s ",
		            " ", slno,
					bl_slmt_doc_remarks.arr,				
					bl_Cheque_no.arr,		
					bl_cheque_date.arr,
					bl_receipt_no.arr,
					bl_payer_name.arr);
		print_formated(bl_doc_amt);
        lctr+=1;

   }

}

print_total()
{
	fprintf(fp,"\n");
	fprintf(fp,"%-131s%-15s\n"," ","---------------");
	fprintf(fp,"%-101s%-29s "," ",loc_legend[14]);
	print_formated(nd_cc_total_amt);
	fprintf(fp,"%-131s%-15s\n"," ","---------------");
    lctr+=4;
}

print_grand_total()
{
	fprintf(fp,"%-108s%-22s "," ",loc_legend[15]);
	print_formated(nd_cc_grand_total_amt);
	fprintf(fp,"%-131s%-15s\n"," ","---------------");
    lctr+=2;
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
        fprintf(fp,"%15sCR \n",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s  \n",str_amt);
    }
}          



fetch_hosp_name()

{
    l_acc_name.arr[0] ='\0';
	hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    date_con.arr[0]	 = '\0';
    user_id.arr[0]   = '\0';
    l_acc_name.len   = 0;
	hosp_name.len    = 0;
    date_time.len    = 0;
    date_con.len	 = 0;
    user_id.len      = 0;


    /* EXEC SQL SELECT ACCOUNTING_NAME,
					ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/YYYY'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
					USER
              INTO :l_acc_name, 
				   :hosp_name,
				   :date_con,
				   :date_time,
				   :user_id
              FROM SY_ACC_ENTITY_LANG_VW
	          WHERE ACC_ENTITY_ID = :nd_facility
		      AND   LANGUAGE_ID   = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,\
'DD/MM/YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,USER into :b0,:b1,:b2,:b3,:b4  f\
rom SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b5 and LANGUAGE_ID=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )330;
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
    sqlstm.sqhstv[2] = (         void  *)&date_con;
    sqlstm.sqhstl[2] = (unsigned int  )23;
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
	date_con.arr[date_con.len]			   = '\0';
	user_id.arr[user_id.len]               = '\0';

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
		//lctr = 3;
		lctr = 5;
	}
}
		   
fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00017.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00017.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )373;
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
			blcommon.get_local_lang_desc(
						:nd_facility,
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
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )396;
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





