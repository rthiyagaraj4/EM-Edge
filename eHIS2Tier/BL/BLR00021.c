
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
    "D:\\BUGS\\BLR00021.PC"
};


static unsigned long sqlctx = 36262467;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {10,14};

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
"e) and a.doc_num=d.doc_num) and a.doc_slno=d.doc_slno) and a.operating_facil\
ity_id=:b0) and DECODE(d.adjust_exempt_ind,'S','A',d.adjust_exempt_ind)=nvl(:b\
1,d.adjust_exempt_ind)) and c.reason_code between nvl(:b2,'!!!!') and nvl(:b3,\
'~~~~')) and :b5='Y') and to_char(a.cancelled_date,'MM/YYYY')=:b4) order by r_\
code,d_date            ";

 static const char *sq0005 = 
"select distinct to_char(doc_date,'MM/YYYY') d_date  from bl_bill_adj_hdr whe\
re ((trunc(doc_date) between to_date(:b0,'MM/YYYY') and last_day(to_date(:b1,'\
MM/YYYY')) and operating_facility_id=:b2) and :b3='N') union select distinct t\
o_char(cancelled_date,'MM/YYYY') d_date  from bl_bill_adj_hdr_canc where ((tru\
nc(cancelled_date) between to_date(:b0,'MM/YYYY') and last_day(to_date(:b1,'MM\
/YYYY')) and operating_facility_id=:b2) and :b3='Y') order by d_date          \
  ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,117,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,159,0,4,157,0,0,9,3,0,1,0,2,1,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
87,0,0,3,84,0,2,181,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
114,0,0,4,0,0,30,205,0,0,0,0,0,1,0,
129,0,0,6,2381,0,9,312,0,0,14,14,0,1,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,
200,0,0,5,468,0,9,320,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,1,0,0,
247,0,0,6,0,0,15,328,0,0,0,0,0,1,0,
262,0,0,6,0,0,13,358,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
325,0,0,5,0,0,13,394,0,0,1,0,0,1,0,2,9,0,0,
344,0,0,7,206,0,4,829,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
387,0,0,8,132,0,4,859,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
414,0,0,9,176,0,4,883,0,0,4,2,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,
445,0,0,10,489,0,6,897,0,0,4,4,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
476,0,0,11,96,0,4,986,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
499,0,0,12,162,0,6,993,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
530,0,0,13,199,0,6,1042,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
557,0,0,14,193,0,6,1064,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00021.PC                                  */
/* AUTHOR                : Jagwinder Kaur                               */  
/* DATE WRITTEN          : 07/06/2004                                   */      
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
			date							[20],
            date_time                       [20],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility				        [3],
			//bl_doc_no						[16],commented for tuning
			//bl_doc_type_code				[7],commented for tuning
			bl_adj_doc_no					[16],
			//old_doc_no						[16],commented for tuning
			bl_doc_date						[11],
			bl_adj_doc_date					[11],
			bl_patient_id					[21],
			bl_episode_no					[13],
			bl_visit_id						[5],
			bl_episode_type					[2],
			bl_patient_name					[31],
			bl_reason_code					[5],
			bl_reason_desc					[256],
			bl_reason_desc1					[120],
			bl_reason_desc2					[120],
			bl_reason_desc3					[120],
			bl_user							[31],
			nd_fm_date						[11],
			nd_to_date						[11],
			nd_fm_reason_code				[5],
			nd_to_reason_code				[5],
			old_reason_code					[5],
			l_translated_value				[201],
			//l_cash_book_acc_desc			[16],commented for tuning
			l_pk_value						[100],
			tmp_date						[11],
			//tmp_adj_date					[11], commented for tuning
			nd_temp_date					[20],
			nd_loc_date						[20],
			bl_mon_year						[8],
			p_language_id					[3],
			old_mon_year					[8]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[120]; } l_acc_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[16]; } bl_adj_doc_no;

struct { unsigned short len; unsigned char arr[11]; } bl_doc_date;

struct { unsigned short len; unsigned char arr[11]; } bl_adj_doc_date;

struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[13]; } bl_episode_no;

struct { unsigned short len; unsigned char arr[5]; } bl_visit_id;

struct { unsigned short len; unsigned char arr[2]; } bl_episode_type;

struct { unsigned short len; unsigned char arr[31]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[5]; } bl_reason_code;

struct { unsigned short len; unsigned char arr[256]; } bl_reason_desc;

struct { unsigned short len; unsigned char arr[120]; } bl_reason_desc1;

struct { unsigned short len; unsigned char arr[120]; } bl_reason_desc2;

struct { unsigned short len; unsigned char arr[120]; } bl_reason_desc3;

struct { unsigned short len; unsigned char arr[31]; } bl_user;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_reason_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_reason_code;

struct { unsigned short len; unsigned char arr[5]; } old_reason_code;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[11]; } tmp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[8]; } bl_mon_year;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[8]; } old_mon_year;


	char	loc_legend20_1[16],
			loc_legend20_2[16],
			loc_legend22_1[25],
			loc_legend22_2[25],
			loc_legend23_1[25],
			loc_legend23_2[25],
			loc_legend24_1[25],
			loc_legend24_2[25];



double      bl_doc_amt,bl_tot_outst_amt,tot_doc_amt=0,bl_paid_amt,tot_bl_paid_amt=0,tot_amt=0,tot_outst_amt=0, tot_paid_amt = 0,tot_bl_tot_outst_amt=0;
			
int i,null_place,r_ctr=0;
char nd_trn_type,nd_status;
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char fm_date[11],to_date[11];
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

int    lctr = 0,pctr = 0;//nvalid = 0,ncancel = 0; commented for tuning
int    first = 1,d_first = 1, ctr=0;

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
 
    strcpy(g_pgm_id,"BLR00021");
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

		nd_fm_date.arr[0]			= '\0';
		nd_to_date.arr[0]			= '\0';
		nd_fm_reason_code.arr[0]	= '\0';
		nd_to_reason_code.arr[0]	= '\0';
		
		nd_fm_date.len			= 0;
		nd_to_date.len			= 0;
		nd_fm_reason_code.len	= 0;
		nd_to_reason_code.len	= 0;
		
        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6
				INTO	:nd_trn_type,
						:nd_status,
						:nd_fm_date,
						:nd_to_date,
						:nd_fm_reason_code,
						:nd_to_reason_code
				FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 9;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6\
 into :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID=:b6 and SESSI\
ON_ID=:b7) and PGM_DATE=:b8)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )36;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_trn_type;
        sqlstm.sqhstl[0] = (unsigned int  )1;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_status;
        sqlstm.sqhstl[1] = (unsigned int  )1;
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
        sqlstm.sqhstv[4] = (         void  *)&nd_fm_reason_code;
        sqlstm.sqhstl[4] = (unsigned int  )7;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&nd_to_reason_code;
        sqlstm.sqhstl[5] = (unsigned int  )7;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_curr_pgm_name;
        sqlstm.sqhstl[6] = (unsigned int  )17;
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

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

		nd_fm_reason_code.arr[nd_fm_reason_code.len]	= '\0';
		nd_to_reason_code.arr[nd_to_reason_code.len]	= '\0';
		nd_fm_date.arr[nd_fm_date.len]				= '\0';
		nd_to_date.arr[nd_to_date.len]				= '\0';
		 

	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )87;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
				
		open_mon_yr();

		print_hdr();

	    end_of_rep();


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )114;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");
}

declare_cur()
{
	/* EXEC SQL DECLARE MON_YEAR_CUR CURSOR FOR 
	select	distinct to_char(doc_date,'MM/YYYY') d_date 
			from bl_bill_adj_hdr
			where trunc(doc_date) between to_date(:nd_fm_date,'MM/YYYY')
			and last_day(to_date(:nd_to_date,'MM/YYYY'))
			and operating_facility_id=:nd_facility //ADDED BY SAIKIRAN FOR TUNING
			and :nd_status = 'N'
	UNION
	select	distinct to_char(cancelled_date,'MM/YYYY') d_date
			from bl_bill_adj_hdr_canc
			where trunc(cancelled_date) between to_date(:nd_fm_date,'MM/YYYY')
			and last_day(to_date(:nd_to_date,'MM/YYYY'))
			and operating_facility_id=:nd_facility //ADDED BY SAIKIRAN FOR TUNING
			and :nd_status = 'Y'
	order by d_date; */ 



	if (OERROR)
			err_mesg("Declare failed on cursor MON_YEAR_CUR",0,"");


	/* EXEC SQL DECLARE ADJ_DTL_CUR CURSOR FOR 
	select	a.doc_date d_date,
			to_char(a.doc_date,'DD/MM/YYYY') doc_date,
			c.reason_code r_code,
			b.patient_id patient_id,
			b.episode_type episode_type,
			b.episode_id||'/'||to_char(b.visit_id) enctr_id,
			adj_doc_type_code||'/'||to_char(adj_doc_num) document,
			to_char(adj_doc_date,'DD/MM/YYYY') a_date,
			nvl(a.doc_amt,0) doc_amt,
			nvl(b.bill_tot_amt,0) tot_amt,
			nvl(b.bill_paid_amt,0)-nvl(b.tot_refund_amt,0) paid_amt,
			a.added_by_id added_by
			from bl_bill_adj_dtl a,BL_BILL_DCP_DTL_VW b,bl_bill_adj_hdr c
			where a.operating_facility_id = b.operating_facility_id
			and a.adj_doc_type_code=b.doc_type_code
			and a.adj_doc_num=b.doc_num
			and a.operating_facility_id = c.operating_facility_id
			and a.doc_type_code=c.doc_type_code
			and a.doc_num=c.doc_num
			and a.operating_facility_id=:nd_facility
			//and a.adjust_exempt_ind = :nd_trn_type
			and DECODE(a.adjust_exempt_ind,'S','A',a.adjust_exempt_ind) = nvl(:nd_trn_type,a.adjust_exempt_ind) /oADDED BY NAGARAJAN FOR IN42550 ON 20/9/2013o/
			and c.reason_code between nvl(:nd_fm_reason_code,'!!!!')
			                  and nvl(:nd_to_reason_code,'~~~~')
			and to_char(a.doc_date,'MM/YYYY') = :bl_mon_year
			and :nd_status = 'N'
		/o	and (a.doc_type_code,a.doc_num,a.doc_slno) not in(select doc_type_code,doc_num,doc_slno
				from bl_bill_adj_dtl_canc 
				where operating_facility_id=:nd_facility
				and to_char(cancelled_date,'MM/YYYY') = :bl_mon_year) COMMENTED BY SAIKIRAN FOR TUNINGo/
            and not EXISTS(select 'x'
				from bl_bill_adj_dtl_canc 
				where operating_facility_id=:nd_facility and
				a.doc_type_code=doc_type_code and
				a.doc_num=doc_num and
				a.doc_slno=doc_slno 
				and to_char(cancelled_date,'MM/YYYY') = :bl_mon_year) 
			UNION
			select		a.cancelled_date d_date,
			to_char(a.cancelled_date,'DD/MM/YYYY') doc_date,
			c.reason_code r_code,
			b.patient_id patient_id,
			b.episode_type episode_type,
			b.episode_id||'/'||to_char(b.visit_id) enctr_id,
			adj_doc_type_code||'/'||to_char(adj_doc_num) document,
			to_char(adj_doc_date,'DD/MM/YYYY') a_date,
			nvl(d.doc_amt,0) doc_amt,
			nvl(b.bill_tot_amt,0) tot_amt,
			nvl(b.bill_paid_amt,0)-nvl(b.tot_refund_amt,0) paid_amt,
			a.added_by_id added_by
			from bl_bill_adj_dtl_canc a,BL_BILL_DCP_DTL_VW b,bl_bill_adj_hdr_canc c,bl_bill_adj_dtl d
			where d.adj_doc_type_code=b.doc_type_code
			and d.adj_doc_num=b.doc_num
			and a.operating_facility_id=c.operating_facility_id
			and a.doc_type_code=c.doc_type_code
			and a.doc_num=c.doc_num
			and a.operating_facility_id = d.operating_facility_id
			and a.doc_type_code = d.doc_type_code
			and a.doc_num = d.doc_num
			and a.doc_slno = d.doc_slno
			and a.operating_facility_id=:nd_facility
			//and d.adjust_exempt_ind = :nd_trn_type
			and DECODE(d.adjust_exempt_ind,'S','A',d.adjust_exempt_ind) = nvl(:nd_trn_type,d.adjust_exempt_ind) /oADDED BY NAGARAJAN FOR IN42550 ON 20/9/2013o/
			and c.reason_code between nvl(:nd_fm_reason_code,'!!!!')
			                  and nvl(:nd_to_reason_code,'~~~~')
			and :nd_status = 'Y'
            and to_char(a.cancelled_date,'MM/YYYY') = :bl_mon_year
			order by r_code,d_date; */ 

			
			if (OERROR)
			err_mesg("Declare failed on cursor ADJ_DTL_CUR",0,""); 

}


open_dtl() 
{

	/* EXEC SQL OPEN ADJ_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.doc_date d_date ,to_char(a.doc_date,'DD/MM/YYYY') doc_date ,c.r\
eason_code r_code ,b.patient_id patient_id ,b.episode_type episode_type ,((b\
.episode_id||'/')||to_char(b.visit_id)) enctr_id ,((adj_doc_type_code||'/')|\
|to_char(adj_doc_num)) document ,to_char(adj_doc_date,'DD/MM/YYYY') a_date ,\
nvl(a.doc_amt,0) doc_amt ,nvl(b.bill_tot_amt,0) tot_amt ,(nvl(b.bill_paid_am\
t,0)-nvl(b.tot_refund_amt,0)) paid_amt ,a.added_by_id added_by  from bl_bill\
_adj_dtl a ,BL_BILL_DCP_DTL_VW b ,bl_bill_adj_hdr c where (((((((((((a.opera\
ting_facility_id=b.operating_facility_id and a.adj_doc_type_code=b.doc_type_\
code) and a.adj_doc_num=b.doc_num) and a.operating_facility_id=c.operating_f\
acility_id) and a.doc_type_code=c.doc_type_code) and a.doc_num=c.doc_num) an\
d a.operating_facility_id=:b0) and DECODE(a.adjust_exempt_ind,'S','A',a.adju\
st_exempt_ind)=nvl(:b1,a.adjust_exempt_ind)) and c.reason_code between nvl(:\
b2,'!!!!') and nvl(:b3,'~~~~')) and to_char(a.doc_date,'MM/YYYY')=:b4) and :\
b5='N') and  not exists (select 'x'  fro");
 sqlbuft((void **)0, 
   "m bl_bill_adj_dtl_canc where ((((operating_facility_id=:b0 and a.doc_typ\
e_code=doc_type_code) and a.doc_num=doc_num) and a.doc_slno=doc_slno) and to\
_char(cancelled_date,'MM/YYYY')=:b4))) union select a.cancelled_date d_date \
,to_char(a.cancelled_date,'DD/MM/YYYY') doc_date ,c.reason_code r_code ,b.pa\
tient_id patient_id ,b.episode_type episode_type ,((b.episode_id||'/')||to_c\
har(b.visit_id)) enctr_id ,((adj_doc_type_code||'/')||to_char(adj_doc_num)) \
document ,to_char(adj_doc_date,'DD/MM/YYYY') a_date ,nvl(d.doc_amt,0) doc_am\
t ,nvl(b.bill_tot_amt,0) tot_amt ,(nvl(b.bill_paid_amt,0)-nvl(b.tot_refund_a\
mt,0)) paid_amt ,a.added_by_id added_by  from bl_bill_adj_dtl_canc a ,BL_BIL\
L_DCP_DTL_VW b ,bl_bill_adj_hdr_canc c ,bl_bill_adj_dtl d where ((((((((((((\
(d.adj_doc_type_code=b.doc_type_code and d.adj_doc_num=b.doc_num) and a.oper\
ating_facility_id=c.operating_facility_id) and a.doc_type_code=c.doc_type_co\
de) and a.doc_num=c.doc_num) and a.operating_facility_id=d.operating_facilit\
y_id) and a.doc_type_code=d.doc_type_cod");
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )129;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_trn_type;
 sqlstm.sqhstl[1] = (unsigned int  )1;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_fm_reason_code;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_reason_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_mon_year;
 sqlstm.sqhstl[4] = (unsigned int  )10;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_status;
 sqlstm.sqhstl[5] = (unsigned int  )1;
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
 sqlstm.sqhstv[7] = (         void  *)&bl_mon_year;
 sqlstm.sqhstl[7] = (unsigned int  )10;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_facility;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_trn_type;
 sqlstm.sqhstl[9] = (unsigned int  )1;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_fm_reason_code;
 sqlstm.sqhstl[10] = (unsigned int  )7;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_to_reason_code;
 sqlstm.sqhstl[11] = (unsigned int  )7;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_status;
 sqlstm.sqhstl[12] = (unsigned int  )1;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&bl_mon_year;
 sqlstm.sqhstl[13] = (unsigned int  )10;
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
         err_mesg("OPEN failed on cursor ADJ_DTL_CUR",0,"");
}

open_mon_yr() 
{

	/* EXEC SQL OPEN MON_YEAR_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )200;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_facility;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_status;
 sqlstm.sqhstl[3] = (unsigned int  )1;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_fm_date;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[5] = (unsigned int  )13;
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
 sqlstm.sqhstv[7] = (         void  *)&nd_status;
 sqlstm.sqhstl[7] = (unsigned int  )1;
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
         err_mesg("OPEN failed on cursor MON_YEAR_CUR",0,"");
}

close_dtl() 
{

	/* EXEC SQL CLOSE ADJ_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )247;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

fetch_dtl()
{
bl_reason_code.arr[0]		= '\0';
bl_doc_date.arr[0]			= '\0';
bl_patient_id.arr[0]		= '\0';
bl_episode_type.arr[0]		= '\0';
bl_episode_no.arr[0]		= '\0';
bl_visit_id.arr[0]			= '\0';
bl_adj_doc_no.arr[0]		= '\0';
bl_adj_doc_date.arr[0]		= '\0';
bl_user.arr[0]				= '\0';

bl_reason_code.len			= 0;
bl_doc_date.len				= 0;
bl_patient_id.len			= 0;
bl_episode_no.len			= 0;
bl_visit_id.len				= 0;
bl_episode_type.len			= 0;
bl_adj_doc_no.len			= 0;
bl_adj_doc_date.len			= 0;
bl_user.len					= 0;

bl_doc_amt           = 0;
bl_tot_outst_amt	 = 0;
bl_paid_amt			 = 0;

/* EXEC SQL FETCH ADJ_DTL_CUR
         INTO :tmp_date,
	  	    :bl_doc_date,
		    :bl_reason_code,
		    :bl_patient_id,
		    :bl_episode_type,
		    :bl_episode_no,
		    :bl_adj_doc_no,
		    :bl_adj_doc_date,
		    :bl_doc_amt,
		    :bl_tot_outst_amt,
		    :bl_paid_amt,
		    :bl_user; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 14;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )262;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&tmp_date;
sqlstm.sqhstl[0] = (unsigned int  )13;
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
sqlstm.sqhstv[2] = (         void  *)&bl_reason_code;
sqlstm.sqhstl[2] = (unsigned int  )7;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&bl_patient_id;
sqlstm.sqhstl[3] = (unsigned int  )23;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&bl_episode_type;
sqlstm.sqhstl[4] = (unsigned int  )4;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&bl_episode_no;
sqlstm.sqhstl[5] = (unsigned int  )15;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&bl_adj_doc_no;
sqlstm.sqhstl[6] = (unsigned int  )18;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&bl_adj_doc_date;
sqlstm.sqhstl[7] = (unsigned int  )13;
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
sqlstm.sqhstv[9] = (         void  *)&bl_tot_outst_amt;
sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&bl_paid_amt;
sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[10] = (         int  )0;
sqlstm.sqindv[10] = (         void  *)0;
sqlstm.sqinds[10] = (         int  )0;
sqlstm.sqharm[10] = (unsigned int  )0;
sqlstm.sqadto[10] = (unsigned short )0;
sqlstm.sqtdso[10] = (unsigned short )0;
sqlstm.sqhstv[11] = (         void  *)&bl_user;
sqlstm.sqhstl[11] = (unsigned int  )33;
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
	err_mesg("FETCH failed on cursor ADJ_DTL_CUR",0,"");

bl_reason_code.arr[bl_reason_code.len]		= '\0';
bl_doc_date.arr[bl_doc_date.len]			= '\0';
bl_patient_id.arr[bl_patient_id.len]		= '\0';
bl_episode_type.arr[bl_episode_type.len]	= '\0';
bl_episode_no.arr[bl_episode_no.len]		= '\0';
bl_visit_id.arr[bl_visit_id.len]			= '\0';
bl_adj_doc_no.arr[bl_adj_doc_no.len]		= '\0';
bl_adj_doc_date.arr[bl_adj_doc_date.len]	= '\0';
bl_user.arr[bl_user.len]					= '\0';

    return(LAST_ROW?0:1);
}


fetch_mon_yr()
{
bl_mon_year.arr[0]			= '\0';
bl_mon_year.len				= 0;

      /* EXEC SQL FETCH MON_YEAR_CUR
               INTO :bl_mon_year; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 14;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )325;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_mon_year;
      sqlstm.sqhstl[0] = (unsigned int  )10;
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
            err_mesg("FETCH failed on cursor MON_YEAR_CUR",0,"");


bl_mon_year.arr[bl_mon_year.len]			= '\0';
return(LAST_ROW?0:1);
}

print_hdr()
{
 while (fetch_mon_yr())
  {
    if (d_first)
     {
         strcpy(old_mon_year.arr,bl_mon_year.arr);
	     old_mon_year.len=strlen(old_mon_year.arr);
     }
    if(strcmp(old_mon_year.arr,bl_mon_year.arr) != 0 )
     {
	        print_total();
		print_grand_total();
		//fprintf(fp,"\f");
		first = 1;	
     }
     open_dtl();
   
  while(fetch_dtl())
  {
    d_first = 0;
    fetch_patient_name();
	fetch_reason_desc();

    if(first)
	 {
	 ctr = ctr +1;

	 if (ctr > 1)
	 {
	    fprintf(fp,"\f");	    
	 }

	 print_head();

	 fprintf(fp," %s :   %-5.5s %-110.110s\n",loc_legend[45],bl_reason_code.arr,bl_reason_desc1.arr);
	 lctr=lctr+1;
	 if(bl_reason_desc2.arr[0] != '\0')
	 {
	 fprintf(fp,"            %-5.5s %-110.110s\n"," ",bl_reason_desc2.arr);
	 lctr=lctr+1;
	 }
	 if(bl_reason_desc3.arr[0] != '\0')
	 {
	 fprintf(fp,"            %-5.5s %-110.110s\n"," ",bl_reason_desc3.arr);
	 lctr=lctr+1;
	 }

	 fprintf(fp,"\n");
	 lctr=lctr+1;
	 
	 strcpy(old_reason_code.arr,bl_reason_code.arr);
	 old_reason_code.len=strlen(old_reason_code.arr);
	 first = 0;
	 }
	
	 if(strcmp(old_reason_code.arr,bl_reason_code.arr) != 0  )
	 {
				print_total();
				check_page_end(4,0);

				fprintf(fp," %s :   %-5.5s %-115.115s\n",loc_legend[45],bl_reason_code.arr,bl_reason_desc1.arr);
				lctr=lctr+1;
				if(bl_reason_desc2.arr[0] != '\0')
				 {
				 fprintf(fp,"            %-5.5s %-110.110s\n"," ",bl_reason_desc2.arr);
				 lctr=lctr+1;
				 } 
				if(bl_reason_desc3.arr[0] != '\0')
				 {
				 fprintf(fp,"            %-5.5s %-110.110s\n"," ",bl_reason_desc3.arr);
				 lctr=lctr+1;
				 }
			        fprintf(fp,"\n");
				lctr=lctr+1;
	}      

	check_page_end(2,0);

	get_initialize();
    strcpy(nd_temp_date.arr,bl_doc_date.arr);
   		get_local_date_convn1();
     	strcpy(bl_doc_date.arr,nd_loc_date.arr);
     		
	fprintf(fp," %-15.15s %-20.20s %-13.13s %-16.16s ",
				bl_doc_date.arr,
				bl_patient_id.arr,
				bl_episode_no.arr,
				bl_adj_doc_no.arr);
 	fprintf(fp,"  ");
	print_formated(bl_tot_outst_amt);
	fprintf(fp,"         ");
	print_formated(bl_doc_amt);
	fprintf(fp,"         ");
	print_formated(bl_paid_amt);
	//fprintf(fp,"   ");
	fprintf(fp,"%-30.30s",bl_user.arr);
	fprintf(fp,"\n");

	get_initialize();
	strcpy(nd_temp_date.arr,bl_adj_doc_date.arr);
 	get_local_date_convn1();
	strcpy(bl_adj_doc_date.arr,nd_loc_date.arr);
		
	fprintf(fp," %-15.15s %-34.34s %-15.15s\n"," ",
	bl_patient_name.arr,bl_adj_doc_date.arr);			 
	lctr=lctr+2;

	if (nd_trn_type == 'A')
	{ 
	   if (bl_doc_amt > 0)
	   {
		tot_doc_amt = tot_doc_amt + bl_doc_amt;
		tot_bl_tot_outst_amt = tot_bl_tot_outst_amt +  bl_tot_outst_amt;
		tot_bl_paid_amt = tot_bl_paid_amt + bl_paid_amt;
	   }
	}
	else
	{
		tot_doc_amt = tot_doc_amt + bl_doc_amt;
		tot_bl_tot_outst_amt = tot_bl_tot_outst_amt +  bl_tot_outst_amt;
		tot_bl_paid_amt = tot_bl_paid_amt + bl_paid_amt;
	}

	strcpy(old_reason_code.arr,bl_reason_code.arr);
	old_reason_code.len=strlen(old_reason_code.arr);

	 }
	 strcpy(old_mon_year.arr,bl_mon_year.arr);
	 old_mon_year.len=strlen(old_mon_year.arr);

  }

if (first && d_first)
{	
	print_head();
}
if (!first)
{
print_total();
print_grand_total();
}

}   


print_total()
{
    
	if(tot_bl_tot_outst_amt!=0 || tot_doc_amt!=0 || tot_bl_paid_amt!=0)
	{
	check_page_end(3,0);
	fprintf(fp,"%-67.67s %-70.70s\n"," ","----------------------------------------------------------------------");
	fprintf(fp,"%-33.33s %-28.28s :       "," ",loc_legend[26]); 
	print_formated(tot_bl_tot_outst_amt);
	fprintf(fp,"         ");
	print_formated(tot_doc_amt);
	fprintf(fp,"         ");
	print_formated(tot_bl_paid_amt);
	fprintf(fp,"   ");
	fprintf(fp,"\n");
	fprintf(fp,"%-67.67s %-70.70s\n"," ","----------------------------------------------------------------------");
	}

	tot_amt = tot_amt + tot_doc_amt;
	tot_outst_amt = tot_outst_amt + tot_bl_tot_outst_amt;
	tot_paid_amt = tot_paid_amt + tot_bl_paid_amt;

	lctr=lctr+3;

	tot_doc_amt = 0;
	tot_bl_tot_outst_amt = 0;
	tot_bl_paid_amt = 0;
}   

print_grand_total()
{
    if(tot_outst_amt!=0 || tot_amt!=0 || tot_paid_amt!=0)
	{

		check_page_end(5,0);
		fprintf(fp,"%-33.33s %-28.28s :       "," ",loc_legend[27]); 
		print_formated(tot_outst_amt);
		fprintf(fp,"         ");
		print_formated(tot_amt);
		fprintf(fp,"         ");
		print_formated(tot_paid_amt);
		fprintf(fp,"   ");
		fprintf(fp,"\n");
		fprintf(fp,"%-67.67s %-70.70s\n"," ","----------------------------------------------------------------------");
	}
	tot_amt = 0;
	tot_outst_amt = 0;
	tot_paid_amt = 0;	
}   


end_of_rep()
{
	check_page_end(3,0);
	fprintf(fp,"\n\n%80s ",loc_legend[33]);
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00021.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00021.lis");
       proc_exit();
    }
}

print_page_header()
{

    if (nd_fm_date.arr[0] == '\0')
	  strcpy(fm_date,"Lowest");
    else
	  strcpy(fm_date,nd_fm_date.arr);

	if (nd_to_date.arr[0] == '\0')
	  strcpy(to_date,"Highest");
    else
	  strcpy(to_date,nd_to_date.arr);
 
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

print_head()
{

	print_page_title();

 
  fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	if (nd_trn_type == 'A')
	 {
	    fprintf(fp," %-15.15s %-20.20s %-13.13s %-16.16s  %16.16s %25.25s %25.25s  %-30.30s\n",
	              loc_legend[13],loc_legend[14],loc_legend[16],
		      loc_legend[18],loc_legend20_1,loc_legend23_1,loc_legend24_1,loc_legend[25]);

	   fprintf(fp," %-15.15s %-18.18s %-1.1s %-13.13s %-16.16s  %16.16s %25.25s %25.25s      \n",
	          loc_legend[11],loc_legend[17],"","",loc_legend[11],loc_legend20_2,loc_legend23_2,loc_legend24_2);

	 }
	else
	  {
	     fprintf(fp," %-15.15s %-20.20s %-13.13s %-16.16s  %16.16s %25.25s %25.25s  %-30.30s\n",
	              loc_legend[12],loc_legend[14],loc_legend[16],loc_legend[18],
		      loc_legend20_1,loc_legend22_1,loc_legend24_1,loc_legend[25]);    

	    fprintf(fp," %-15.15s %-18.18s %-1.1s %-13.13s %-16.16s  %16.16s %25.25s %25.25s      \n",
	     loc_legend[11],loc_legend[17],"","",loc_legend[11],loc_legend20_2,loc_legend22_2,loc_legend24_2);

	  }
	fprintf(fp,"--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
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


	l_report_width=156;
	l_acc_entity_length = strlen(hosp_name.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	fprintf(fp,"%-13s : BL",loc_legend[30]);
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",hosp_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
    get_initialize();
	strcpy(nd_temp_date.arr,date.arr);
 	get_local_date_convn1();
	strcpy(date.arr,nd_loc_date.arr);		
	fprintf(fp,"%-15.15s : %s\n",loc_legend[6],date.arr);

	//Code for Line 2
	
	l_start_point=0;

	if (nd_trn_type == 'A')
	{
	if(nd_status == 'N')
	l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[2]))/2)-(7/2));
	else
	l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[29]))/2)-(7/2));
	}
	else
	{
	if(nd_status == 'N')
    l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[1]))/2)-(7/2));
    else
	l_start_point=ceill((l_report_width/2)-((strlen(loc_legend[28]))/2)-(7/2));
    }
	
	fprintf(fp,"%-13s : %s",loc_legend[31],user_id.arr);
	l_start_point=l_start_point-(strlen(user_id.arr)+16);
	print_spaces(l_start_point);
	
	if (nd_trn_type == 'A')
	  { 
	  if(nd_status == 'N')
	  fprintf(fp,"%s ",loc_legend[2]);
	  else
	  fprintf(fp,"%s ",loc_legend[29]);
	  }	
	else
	  { 
	  if(nd_status == 'N')
	  fprintf(fp,"%s ",loc_legend[1]);
	  else
	  fprintf(fp,"%s ",loc_legend[28]);
	  }
	if (bl_mon_year.arr[0] != '\0')

		{
		
		get_initialize();
		strcpy(nd_temp_date.arr,bl_mon_year.arr);
 		get_local_date_convn2();
		strcpy(bl_mon_year.arr,nd_loc_date.arr);
	    fprintf(fp,"%-7s",bl_mon_year.arr);

		}
    else   
		{  
		
		get_initialize();
		strcpy(nd_temp_date.arr,old_mon_year.arr);
 		if (nd_temp_date.arr[0] !='\0')
		{
			get_local_date_convn2();
			strcpy(old_mon_year.arr,nd_loc_date.arr);
			fprintf(fp,"%-7s",old_mon_year.arr);
		}
		}

	if (nd_trn_type == 'A')
	{
	if (nd_status == 'N')
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[2]);
	else
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[29]);
	}
	else
	{
	if (nd_status == 'N')
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[1]);
	else
	l_comp_name_end_point=l_start_point+(strlen(user_id.arr)+16)+strlen(loc_legend[28]);
	}

	l_start_point=(l_report_width-(18+strlen(date_time.arr)+7)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[7],date_time.arr);
    
	//Code for Line 3
	l_start_point=0;
	l_start_point=ceill(l_report_width/2);
	fprintf(fp,"%-14.14s: BLR00021",loc_legend[5]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	l_comp_name_end_point=l_start_point+24;
	l_start_point=(l_report_width-(17+9)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp," %-15.15s : %d\n",loc_legend[8],++pctr);

	
}

fill_dash(flg)
{
  int i;
  for (i=1;i<=flg;i++)
	fprintf(fp,"%s","-");
}

fetch_hosp_name()
{
    l_acc_name.arr[0] = '\0';
	hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
	date.arr[0]		 = '\0';
    user_id.arr[0]   = '\0';
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
			  AND   LANGUAGE_ID	  = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,\
'DD/MM/RRRR') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,USER into :b0,:b1,:b2,:b3,:b4  f\
rom SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b5 and LANGUAGE_ID=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )344;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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

fetch_patient_name()
{
    bl_patient_name.arr[0] = '\0';
    bl_patient_name.len = 0;

    /* EXEC SQL SELECT decode(:p_language_id,'en',substr(short_name,1,35),substr(short_name_loc_lang,1,35))
               INTO :bl_patient_name
               FROM MP_PATIENT_MAST
	           WHERE PATIENT_ID = :bl_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select decode(:b0,'en',substr(short_name,1,35),substr(sho\
rt_name_loc_lang,1,35)) into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )387;
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
    sqlstm.sqhstv[1] = (         void  *)&bl_patient_name;
    sqlstm.sqhstl[1] = (unsigned int  )33;
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

fetch_reason_desc()
{
    bl_reason_desc.arr[0]	= '\0';
	bl_reason_desc1.arr[0]	= '\0';
    bl_reason_desc2.arr[0]	= '\0';
	bl_reason_desc3.arr[0]	= '\0';
	
	bl_reason_desc.len		= 0;
	bl_reason_desc1.len		= 0;
	bl_reason_desc2.len		= 0;
	bl_reason_desc3.len		= 0;
	
   /* EXEC SQL SELECT replace(action_reason_desc,CHR(10),CHR(32)),instr(action_reason_desc,' ')
               INTO :bl_reason_desc,:null_place
               FROM  BL_ACTION_REASON_LANG_VW
	           WHERE action_reason_code = :bl_reason_code
			   AND   LANGUAGE_ID        = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select replace(action_reason_desc,CHR(10),CHR(32)) ,instr(\
action_reason_desc,' ') into :b0,:b1  from BL_ACTION_REASON_LANG_VW where (act\
ion_reason_code=:b2 and LANGUAGE_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )414;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_reason_desc;
   sqlstm.sqhstl[0] = (unsigned int  )258;
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
     blcommon.split_words(:bl_reason_desc,110,'*',1,str1,str2);
	    IF str2 IS NOT NULL THEN
         :bl_reason_desc1 := str2;
        END IF;
	 blcommon.split_words(:bl_reason_desc,110,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :bl_reason_desc2  := str2;
       END IF;
	 blcommon.split_words(:bl_reason_desc,110,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_reason_desc3    :=  str2;
        END IF;
     
	 END;
	 END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin declare str1 varchar2 ( 4000 ) ; str2 varchar2 ( 1000 \
) ; BEGIN blcommon . split_words ( :bl_reason_desc , 110 , '*' , 1 , str1 , st\
r2 ) ; IF str2 IS NOT NULL THEN :bl_reason_desc1 := str2 ; END IF ; blcommon .\
 split_words ( :bl_reason_desc , 110 , '*' , 2 , str1 , str2 ) ; IF str2 IS NO\
T NULL THEN :bl_reason_desc2 := str2 ; END IF ; blcommon . split_words ( :bl_r\
eason_desc , 110 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl_reas\
on_desc3 := str2 ; END IF ; END ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )445;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_reason_desc;
 sqlstm.sqhstl[0] = (unsigned int  )258;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_reason_desc1;
 sqlstm.sqhstl[1] = (unsigned int  )122;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_reason_desc2;
 sqlstm.sqhstl[2] = (unsigned int  )122;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_reason_desc3;
 sqlstm.sqhstl[3] = (unsigned int  )122;
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


		bl_reason_desc1.arr[bl_reason_desc1.len]  = '\0';
		bl_reason_desc2.arr[bl_reason_desc2.len]  = '\0';
		bl_reason_desc3.arr[bl_reason_desc3.len]  = '\0';
     
    }
	else
	{
     strcpy(bl_reason_desc1.arr,bl_reason_desc.arr);
	 bl_reason_desc1.len = strlen(bl_reason_desc1.arr);
	 }
     
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

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00021.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00021.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )476;
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )499;
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

		r_ctr = 0;
	if (strlen(loc_legend[20]) > 0)
		split_text(loc_legend[20],15,loc_legend20_1,&r_ctr);
	if (strlen(loc_legend[20]) >= 15)	
		split_text(loc_legend[20],15,loc_legend20_2,&r_ctr);


	r_ctr = 0;
	if (strlen(loc_legend[22]) > 0)
		split_text(loc_legend[22],25,loc_legend22_1,&r_ctr);
	if (strlen(loc_legend[22]) >= 25)	
		split_text(loc_legend[22],25,loc_legend22_2,&r_ctr);


	r_ctr = 0;
	if (strlen(loc_legend[23]) > 0)
		split_text(loc_legend[23],25,loc_legend23_1,&r_ctr);
	if (strlen(loc_legend[23]) >= 25)	
		split_text(loc_legend[23],25,loc_legend23_2,&r_ctr);


	r_ctr = 0;
	if (strlen(loc_legend[24]) > 0)
		split_text(loc_legend[24],25,loc_legend24_1,&r_ctr);
	if (strlen(loc_legend[24]) >= 25)	
		split_text(loc_legend[24],25,loc_legend24_2,&r_ctr);

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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'dd/mm/yyyy' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )530;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'mm/yyyy' ) , :p_language_id , t_date ) ;\
 :nd_loc_date := to_char ( t_date , 'mm/yyyy' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )557;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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

